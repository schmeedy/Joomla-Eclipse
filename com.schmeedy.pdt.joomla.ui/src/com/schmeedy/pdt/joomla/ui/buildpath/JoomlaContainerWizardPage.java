package com.schmeedy.pdt.joomla.ui.buildpath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.AbstractObservable;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.dltk.core.IBuildpathEntry;
import org.eclipse.dltk.core.IScriptProject;
import org.eclipse.dltk.core.ModelException;
import org.eclipse.dltk.internal.ui.wizards.IBuildpathContainerPage;
import org.eclipse.dltk.ui.wizards.IBuildpathContainerPageExtension;
import org.eclipse.dltk.ui.wizards.NewElementWizardPage;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import com.schmeedy.pdt.joomla.common.ui.JoomlaCommonUiPlugin;
import com.schmeedy.pdt.joomla.core.project.buildpath.JoomlaBuildpathUtils;
import com.schmeedy.pdt.joomla.core.server.IJoomlaServerManager;
import com.schmeedy.pdt.joomla.core.server.cfg.JoomlaServerConfigurationPackage;
import com.schmeedy.pdt.joomla.core.server.cfg.LocalJoomlaServer;
import com.schmeedy.pdt.joomla.ui.JoomlaUiPlugin;
import com.schmeedy.pdt.service.registry.ServiceRegistry;

@SuppressWarnings("restriction")
public class JoomlaContainerWizardPage extends NewElementWizardPage implements IBuildpathContainerPage, IBuildpathContainerPageExtension {

	private static final IStatus OK_STATUS = JoomlaUiPlugin.getInstance().newOkStatus("Select how the Joomla! API library should be constructed");
	
	private final List<LocalJoomlaServer> servers = ServiceRegistry.getInstance().getService(IJoomlaServerManager.class).getAvailableServers().getServers();
	private final List<AbstractObservable> observablesToDispose = new LinkedList<AbstractObservable>();
	
	private IScriptProject project;
	private IBuildpathEntry[] buildpath;

	private Button optionAutoContainer;
	private Button optionSelectedContainer;

	private TableViewer serversTableViewer;
	private Table serversTable;
	
	private DataBindingContext dataBindingContext;

	private IBuildpathEntry newEntry;
	private IBuildpathEntry alreadyPresentJoomlaEntry;
	
	public JoomlaContainerWizardPage() {
		super("Joomla! API");
		setDescription(OK_STATUS.getMessage());
		setTitle("Add Joomla! API Library");
		setMessage("");
	}

	@Override
	public void initialize(IScriptProject project, IBuildpathEntry[] currentEntries) {
		this.project = project;
		this.buildpath = currentEntries;
		
		for (final IBuildpathEntry entry : buildpath) {
			if (JoomlaBuildpathUtils.isJoomlaContainerEntry(entry)) {
				alreadyPresentJoomlaEntry = entry;
				newEntry = entry;
				break;
			}
		}
	}
	
	@Override
	public void createControl(Composite parent) {
		final Composite wizardContainer = new Composite(parent, SWT.NULL);
		setControl(wizardContainer);
		final GridLayout gl_wizardContainer = new GridLayout(1, false);
		gl_wizardContainer.marginHeight = 0;
		gl_wizardContainer.marginWidth = 0;
		wizardContainer.setLayout(gl_wizardContainer);
		
		final Group joomlaContainerSelectionGroup = new Group(wizardContainer, SWT.NONE);
		joomlaContainerSelectionGroup.setText("Joomla! API Library Options");
		joomlaContainerSelectionGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		final GridLayout gl_joomlaContainerSelectionComposite = new GridLayout(1, false);
		joomlaContainerSelectionGroup.setLayout(gl_joomlaContainerSelectionComposite);
		
		optionAutoContainer = new Button(joomlaContainerSelectionGroup, SWT.RADIO);
		optionAutoContainer.setText("Automatically maintain Joomla! API library based on contained extensions");
		optionAutoContainer.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateCurrentEntryAndStatus();
			}
		});
		
		optionSelectedContainer = new Button(joomlaContainerSelectionGroup, SWT.RADIO);
		optionSelectedContainer.setText("Add Joomla! API library based on the selected server");
		optionAutoContainer.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateCurrentEntryAndStatus();
			}
		});
		
		final Composite tableComposite = new Composite(joomlaContainerSelectionGroup, SWT.NONE);
		tableComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		final TableColumnLayout tableColumnLayout = new TableColumnLayout();
		tableComposite.setLayout(tableColumnLayout);
		
		serversTableViewer = new TableViewer(tableComposite, SWT.BORDER | SWT.FULL_SELECTION);
		serversTable = serversTableViewer.getTable();
		serversTableViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				updateCurrentEntryAndStatus();
			}
		});

		final TableColumn singleColumn = new TableColumn(serversTable, SWT.NONE);
		tableColumnLayout.setColumnData(singleColumn, new ColumnWeightData(100));
		
		final ObservableListContentProvider contentProvider = new ObservableListContentProvider();
		serversTableViewer.setContentProvider(contentProvider);
		
		final IObservableMap[] attributeMaps = EMFObservables.observeMaps(contentProvider.getKnownElements(), new EStructuralFeature[]{ JoomlaServerConfigurationPackage.Literals.LOCAL_JOOMLA_SERVER__NAME, JoomlaServerConfigurationPackage.Literals.LOCAL_JOOMLA_SERVER__BASE_URL });
		serversTableViewer.setLabelProvider(new ServerLabelProvider(attributeMaps));
		
		final WritableList inputObservable = new WritableList();
		inputObservable.addAll(servers);
		observablesToDispose.add(inputObservable);
		
		serversTableViewer.setInput(inputObservable);
		
		dataBindingContext = initDataBindings();

		updateSelection(newEntry);
		updateCurrentEntryAndStatus();
	}

	private void updateSelection(IBuildpathEntry entry) {
		if (servers.isEmpty()) {
			optionSelectedContainer.setEnabled(false);
			optionAutoContainer.setSelection(true);
		} else if (JoomlaBuildpathUtils.isExtendedJoomlaContainerEntry(entry)) {
			final String teamId = JoomlaBuildpathUtils.getJoomlaServerTeamId(entry);
			LocalJoomlaServer serverToSelect = null;
			for (final LocalJoomlaServer server : servers) {
				if (teamId.equals(server.getTeamId())) {
					serverToSelect = server;
				}
			}
			if (serverToSelect == null) {
				optionAutoContainer.setSelection(true);
			} else {
				optionSelectedContainer.setSelection(true);
				serversTableViewer.setSelection(new StructuredSelection(serverToSelect));
			}
		} else {
			optionAutoContainer.setSelection(true);
		}
	}

	private void updateCurrentEntryAndStatus() {
		if (optionAutoContainer.getSelection()) {
			setNewEntry(JoomlaBuildpathUtils.newDefaultJoomlaContainerEntry());
		} else if (optionSelectedContainer.getSelection()) {
			final StructuredSelection selection = (StructuredSelection) serversTableViewer.getSelection();
			if (selection.isEmpty()) {
				setNewEntry(null);
			} else {
				setNewEntry(JoomlaBuildpathUtils.newJoomlaContainerEntry((LocalJoomlaServer) selection.getFirstElement()));
			}
		}
	}

	private void setNewEntry(IBuildpathEntry entry) {
		if (entry == null) {
			newEntry = null;
			updateStatus(ValidationStatus.error("No Joomla! installation selected."));
		} else if (alreadyPresentJoomlaEntry == null) {
			newEntry = entry;
			updateStatus(OK_STATUS);
		} else if (alreadyPresentJoomlaEntry.getPath().equals(entry.getPath())) {
			newEntry = null;
			updateStatus(ValidationStatus.info("This entry is already present on the project's classpath."));
		} else {
			newEntry = entry;
			updateStatus(ValidationStatus.warning("Different entry with Joomla! API library is already on project's classpath and will be overwritten."));
		}
	}
	
	@Override
	public boolean finish() {
		return true;
	}

	@Override
	public IBuildpathEntry getSelection() {
		if (newEntry != null && alreadyPresentJoomlaEntry != null) {
			final List<IBuildpathEntry> entries = new ArrayList<IBuildpathEntry>(Arrays.asList(buildpath));
			entries.remove(alreadyPresentJoomlaEntry);
			try {
				project.setRawBuildpath(entries.toArray(new IBuildpathEntry[entries.size()]), null);
			} catch (final ModelException e) {
				JoomlaUiPlugin.getInstance().logError("Failed to remove buildpath entry. New Joomla! API container entry cannot be created.", e);
				return null;
			}
		}
		return newEntry;
	}

	@Override
	public void setSelection(IBuildpathEntry containerEntry) {}

	@Override
	public void dispose() {
		dataBindingContext.dispose();
		for (final AbstractObservable observable : observablesToDispose) {
			observable.dispose();
		}
	}

	public static class ServerLabelProvider extends ObservableMapLabelProvider {
		private final Image joomlaServerImage = JoomlaCommonUiPlugin.getInstance().getImage(JoomlaCommonUiPlugin.IMG_OBJ_JOOMLA);
		
		public ServerLabelProvider(IObservableMap[] attributeMaps) {
			super(attributeMaps);
		}
		
		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			return columnIndex == 0 ? joomlaServerImage : null;
		}
		
		@Override
		public String getColumnText(Object element, int columnIndex) {
			final LocalJoomlaServer server = (LocalJoomlaServer) element;
			if (columnIndex == 0) {
				return server.getName() + " (" + server.getInstallDir() + ")";
			} else {
				return super.getColumnText(element, columnIndex);
			}
		}
		
	}
	
	protected DataBindingContext initDataBindings() {
		final DataBindingContext bindingContext = new DataBindingContext();
		//
		final IObservableValue serversTableObserveEnabledObserveWidget = SWTObservables.observeEnabled(serversTable);
		final IObservableValue optionSelectedContainerSelectionObserveValue = SWTObservables.observeSelection(optionSelectedContainer);
		bindingContext.bindValue(serversTableObserveEnabledObserveWidget, optionSelectedContainerSelectionObserveValue, null, null);
		//
		return bindingContext;
	}
}
