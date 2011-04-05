package com.schmeedy.pdt.joomla.ui.preferences;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.databinding.viewers.ViewersObservables;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.schmeedy.pdt.joomla.common.ui.JoomlaCommonUiPlugin;
import com.schmeedy.pdt.joomla.core.server.IJoomlaServerManager;
import com.schmeedy.pdt.joomla.core.server.cfg.AvailableServers;
import com.schmeedy.pdt.joomla.core.server.cfg.JoomlaServerConfigurationFactory;
import com.schmeedy.pdt.joomla.core.server.cfg.JoomlaServerConfigurationPackage.Literals;
import com.schmeedy.pdt.joomla.core.server.cfg.LocalJoomlaServer;
import com.schmeedy.pdt.service.registry.ServiceRegistry;

public class JoomlaServersPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {

	private IJoomlaServerManager serverManager;

	private DataBindingContext dataBindingContext;
	private AvailableServers availableServers;
	private TableViewer serversTableViewer;
	private Button newButton;
	private Button removeButton;
	private Button editButton;
	private boolean modelModified;
	
	public JoomlaServersPreferencePage() {
		setDescription("Joomla! Servers Management");
		setTitle("Joomla! Servers");
		noDefaultAndApplyButton();
	}
	
	@Override
	public void init(IWorkbench workbench) {
		serverManager = ServiceRegistry.getInstance().getService(IJoomlaServerManager.class);
		availableServers = serverManager.getAvailableServers();
		modelModified = false;
	}
	
	@Override
	protected Control createContents(Composite parent) {
		final Composite contentComposite = new Composite(parent, SWT.NONE);
		final GridLayout gl_contentComposite = new GridLayout(2, false);
		gl_contentComposite.marginWidth = 0;
		gl_contentComposite.marginHeight = 0;
		contentComposite.setLayout(gl_contentComposite);
		
		final Composite tableViewerComposite = new Composite(contentComposite, SWT.NONE);
		tableViewerComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		serversTableViewer = new TableViewer(tableViewerComposite, SWT.BORDER | SWT.FULL_SELECTION);
		final Table serversTable = serversTableViewer.getTable();
		serversTable.setHeaderVisible(true);
		
		final TableColumn nameColumn = new TableColumn(serversTableViewer.getTable(), SWT.NONE);
		nameColumn.setText("Name");
		final TableColumn urlColumn = new TableColumn(serversTableViewer.getTable(), SWT.NONE);
		urlColumn.setText("URL");
		final TableColumn versionColumn = new TableColumn(serversTableViewer.getTable(), SWT.NONE);
		versionColumn.setText("Version");
		final TableColumnLayout tableViewerCompositeLayout = new TableColumnLayout();
		tableViewerCompositeLayout.setColumnData(nameColumn, new ColumnWeightData(40));
		tableViewerCompositeLayout.setColumnData(urlColumn, new ColumnWeightData(40));		
		tableViewerCompositeLayout.setColumnData(versionColumn, new ColumnWeightData(20));
		tableViewerComposite.setLayout(tableViewerCompositeLayout);
		
		final Composite buttonComposite = new Composite(contentComposite, SWT.NONE);
		final GridLayout gl_buttonComposite = new GridLayout(1, false);
		gl_buttonComposite.marginWidth = 0;
		gl_buttonComposite.marginHeight = 0;
		buttonComposite.setLayout(gl_buttonComposite);
		buttonComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1));
		
		newButton = new Button(buttonComposite, SWT.NONE);
		final GridData gd_newButton = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_newButton.widthHint = 90;
		newButton.setLayoutData(gd_newButton);
		newButton.setText("New");
		newButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				final LocalJoomlaServer server = JoomlaServerConfigurationFactory.eINSTANCE.createLocalJoomlaServer();
				server.setName(getNewJoomlaServerDefaultName());
				server.setBaseUrl("http://localhost/joomla");
				availableServers.getServers().add(server);
				
				final EditLocalJoomlaServerDialog dialog = new EditLocalJoomlaServerDialog(getShell(), server, false);
				final int result = dialog.open();
				if (result == Window.CANCEL) {
					availableServers.getServers().remove(server);
				} else {
					modelModified = true;
				}
			}
		});
		
		editButton = new Button(buttonComposite, SWT.NONE);
		editButton.setEnabled(false);
		editButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		editButton.setText("Edit");
		editButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (!serversTableViewer.getSelection().isEmpty()) {
					final StructuredSelection selection = (StructuredSelection) serversTableViewer.getSelection();
					final LocalJoomlaServer edited = (LocalJoomlaServer) selection.getFirstElement();
					final LocalJoomlaServer original = EcoreUtil.copy(edited);
					
					final EditLocalJoomlaServerDialog dialog = new EditLocalJoomlaServerDialog(getShell(), edited, true);
					final int result = dialog.open();
					if (result == Window.CANCEL) {
						final EList<LocalJoomlaServer> servers = availableServers.getServers();
						final int idx = servers.indexOf(edited);
						servers.add(idx, original);
						servers.remove(edited);
					} else {
						modelModified = modelModified || !EcoreUtil.equals(edited, original);
					}
				}
			}
		});
		
		removeButton = new Button(buttonComposite, SWT.NONE);
		removeButton.setEnabled(false);
		removeButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		removeButton.setText("Remove");
		removeButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (!serversTableViewer.getSelection().isEmpty()) {
					final StructuredSelection selection = (StructuredSelection) serversTableViewer.getSelection();
					final LocalJoomlaServer toRemove = (LocalJoomlaServer) selection.getFirstElement();
					availableServers.getServers().remove(toRemove);
					modelModified = true;
				}
			}
		});
		
		dataBindingContext = initDataBindings();
	
		applyDialogFont(contentComposite);
		return contentComposite;
	}
	
	private String getNewJoomlaServerDefaultName() {
		final String baseName = "Development Joomla! Server";
		final Set<String> names = new HashSet<String>();
		for (final LocalJoomlaServer server: availableServers.getServers()) {
			names.add(server.getName());
		}
		String candidate = baseName;
		int i = 1;
		while (names.contains(candidate)) {
			candidate = baseName + " (" + (i++) + ")"; 
		}
		return candidate;
	}
	
	@Override
	public boolean performOk() {
		if (modelModified) {
			serverManager.updateAvailableServers(availableServers);
		}
		return true;
	}
	
	@Override
	public void dispose() {
		dataBindingContext.dispose();
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
	}
	
	public static class SelectionToBooleanConverter extends Converter {
		public SelectionToBooleanConverter() {
			super(Object.class, Boolean.class);
		}

		@Override
		public Object convert(Object selection) {
			return Boolean.valueOf(selection != null);
		}
	}
	protected DataBindingContext initDataBindings() {
		final DataBindingContext bindingContext = new DataBindingContext();
		//
		final ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		serversTableViewer.setContentProvider(listContentProvider);
		//
		final IObservableMap[] observeMaps = EMFObservables.observeMaps(listContentProvider.getKnownElements(), new EStructuralFeature[]{Literals.LOCAL_JOOMLA_SERVER__NAME, Literals.LOCAL_JOOMLA_SERVER__BASE_URL, Literals.LOCAL_JOOMLA_SERVER__EXACT_VERSION});
		serversTableViewer.setLabelProvider(new ServerLabelProvider(observeMaps));
		//
		final IObservableList availableServersServersObserveList = EMFObservables.observeList(Realm.getDefault(), availableServers, Literals.AVAILABLE_SERVERS__SERVERS);
		serversTableViewer.setInput(availableServersServersObserveList);
		//
		final IObservableValue removeButtonObserveEnabledObserveWidget = SWTObservables.observeEnabled(removeButton);
		final IObservableValue serversTableViewerObserveSingleSelection = ViewersObservables.observeSingleSelection(serversTableViewer);
		final UpdateValueStrategy strategy = new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER);
		final UpdateValueStrategy strategy_1 = new UpdateValueStrategy();
		strategy_1.setConverter(new SelectionToBooleanConverter());
		bindingContext.bindValue(removeButtonObserveEnabledObserveWidget, serversTableViewerObserveSingleSelection, strategy, strategy_1);
		//
		final IObservableValue editButtonObserveEnabledObserveWidget = SWTObservables.observeEnabled(editButton);
		final IObservableValue serversTableViewerObserveSingleSelection_1 = ViewersObservables.observeSingleSelection(serversTableViewer);
		final UpdateValueStrategy strategy_2 = new UpdateValueStrategy();
		strategy_2.setConverter(new SelectionToBooleanConverter());
		bindingContext.bindValue(editButtonObserveEnabledObserveWidget, serversTableViewerObserveSingleSelection_1, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), strategy_2);
		//
		return bindingContext;
	}
}
