package com.schmeedy.pdt.joomla.ui.buildpath;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.AbstractObservable;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.dltk.core.IBuildpathEntry;
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
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import com.schmeedy.pdt.joomla.common.ui.JoomlaCommonUiPlugin;
import com.schmeedy.pdt.joomla.core.project.buildpath.JoomlaBuildpathUtils;
import com.schmeedy.pdt.joomla.core.server.IJoomlaServerManager;
import com.schmeedy.pdt.joomla.core.server.cfg.JoomlaServerConfigurationPackage;
import com.schmeedy.pdt.joomla.core.server.cfg.LocalJoomlaServer;
import com.schmeedy.pdt.service.registry.ServiceRegistry;

public class JoomlaBuildpathContainerBlock {

	private final List<LocalJoomlaServer> servers = ServiceRegistry.getInstance().getService(IJoomlaServerManager.class).getAvailableServers().getServers();
	private final List<AbstractObservable> observablesToDispose = new LinkedList<AbstractObservable>();
	private final List<IBuildPathEntryListener> buildPathEntryListeners = new ArrayList<IBuildPathEntryListener>();

	private Button optionAutoContainer;
	private Button optionSelectedContainer;

	private TableViewer serversTableViewer;
	private Table serversTable;
	
	private DataBindingContext dataBindingContext;

	private IBuildpathEntry currentEntry;
	
	public JoomlaBuildpathContainerBlock() {}
	
	public JoomlaBuildpathContainerBlock(IBuildpathEntry initiallySelectedEntry) {
		this.currentEntry = initiallySelectedEntry;
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public Control createControl(Composite parent) {
		final Group joomlaContainerSelectionGroup = new Group(parent, SWT.NONE);
		joomlaContainerSelectionGroup.setText("Joomla! API Library Options");
		final GridLayout gl_joomlaContainerSelectionComposite = new GridLayout(1, false);
		joomlaContainerSelectionGroup.setLayout(gl_joomlaContainerSelectionComposite);
		
		optionAutoContainer = new Button(joomlaContainerSelectionGroup, SWT.RADIO);
		optionAutoContainer.setText("Automatically maintain Joomla! API library based on contained extensions");
		optionAutoContainer.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateCurrentEntry();
			}
		});
		
		optionSelectedContainer = new Button(joomlaContainerSelectionGroup, SWT.RADIO);
		optionSelectedContainer.setText("Add Joomla! API library based on the selected server");
		optionAutoContainer.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateCurrentEntry();
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
				updateCurrentEntry();
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

		if (currentEntry != null) {
			updateSelection(currentEntry);
		}
		
		fireBuildPathEntryChanged();
		
		return joomlaContainerSelectionGroup;
	}
	
	public IBuildpathEntry getCurrentEntry() {
		return currentEntry;
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

	private void updateCurrentEntry() {
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
		if (currentEntry == null) {
			if (entry != null) {
				currentEntry = entry;
				fireBuildPathEntryChanged();
			}
		} else if (!currentEntry.equals(entry)) {
			currentEntry = entry;
			fireBuildPathEntryChanged();
		}
	}
	
	public void addBuildPathEntryListener(IBuildPathEntryListener listener) {
		buildPathEntryListeners.add(listener);
	}
	
	public void removeBuildPathEntryListener(IBuildPathEntryListener listener) {
		buildPathEntryListeners.remove(listener);
	}
	
	public void fireBuildPathEntryChanged() {
		for (final IBuildPathEntryListener listener : buildPathEntryListeners) {
			listener.onBuildPathEntryChanged(currentEntry);
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
	
	public void dispose() {
		dataBindingContext.dispose();
		for (final AbstractObservable observable : observablesToDispose) {
			observable.dispose();
		}
	}
	
}
