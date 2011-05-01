package com.schmeedy.pdt.joomla.ui.server.wizard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.databinding.viewers.ObservableListTreeContentProvider;
import org.eclipse.jface.databinding.viewers.TreeStructureAdvisor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Tree;

import com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel;
import com.schmeedy.pdt.joomla.core.project.model.JoomlaExtensionProject;
import com.schmeedy.pdt.joomla.core.project.model.JoomlaProjectModelPackage;
import com.schmeedy.pdt.joomla.core.server.cfg.DeploymentRuntime;
import com.schmeedy.pdt.joomla.core.server.cfg.JoomlaExtensionDeployment;
import com.schmeedy.pdt.joomla.core.server.cfg.JoomlaServerConfigurationFactory;
import com.schmeedy.pdt.joomla.ui.server.DeploymentTreeContentProvider;
import com.schmeedy.pdt.joomla.ui.server.DeploymentTreeLabelProvider;
import com.schmeedy.pdt.joomla.ui.server.view.ExtensionModelLabelProvider;

public class AddOrRemoveExtensionsWizardSetupPage extends WizardPage {

	private final List<JoomlaExtensionProject> extensionProjects;
	private final DeploymentRuntime targetRuntime;
	
	private final List<IObservable> observables = new LinkedList<IObservable>();
	private final Map<BasicExtensionModel, JoomlaExtensionProject> extensionToProjectMap = new HashMap<BasicExtensionModel, JoomlaExtensionProject>();
	
	private final Set<BasicExtensionModel> toInstall = new LinkedHashSet<BasicExtensionModel>();
	private final Set<BasicExtensionModel> toUninstall = new LinkedHashSet<BasicExtensionModel>();
	
	private TreeViewer availableTreeViewer;
	private TreeViewer configuredTreeViewer;
	private Button addButton;
	private Button removeButton;
	
	public AddOrRemoveExtensionsWizardSetupPage(List<JoomlaExtensionProject> extensionProjects, DeploymentRuntime targetRuntime) {
		super("Add or remove extensions - setup");
		setPageComplete(false);
		this.extensionProjects = extensionProjects;
		this.targetRuntime = EcoreUtil.copy(targetRuntime);
		setDescription("Select extensions to be synchronized with server");
		setTitle("Add or remove extensions");
		initExtensionToProjectMap();
	}

	private void initExtensionToProjectMap() {
		for (final JoomlaExtensionProject project : extensionProjects) {
			for (final BasicExtensionModel extension : project.getExtensions()) {
				extensionToProjectMap.put(extension, project);
			}
		}
	}

	@Override
	public void createControl(Composite parent) {
		final Composite container = new Composite(parent, SWT.NULL);
		setControl(container);
		final GridLayout gl_container = new GridLayout(3, false);
		gl_container.marginWidth = 0;
		gl_container.marginHeight = 0;
		gl_container.verticalSpacing = 0;
		gl_container.horizontalSpacing = 0;
		container.setLayout(gl_container);
		
		final Composite availableComposite = new Composite(container, SWT.NONE);
		final GridLayout gl_availableComposite = new GridLayout(1, false);
		gl_availableComposite.marginHeight = 0;
		availableComposite.setLayout(gl_availableComposite);
		availableComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		final Label lblAvailable = new Label(availableComposite, SWT.NONE);
		lblAvailable.setText("Available:");
		
		availableTreeViewer = new TreeViewer(availableComposite, SWT.BORDER | SWT.MULTI);
		availableTreeViewer.setAutoExpandLevel(2);
		final Tree availableTree = availableTreeViewer.getTree();
		final GridData gd_availableTree = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_availableTree.widthHint = 200;
		availableTree.setLayoutData(gd_availableTree);
		availableTreeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent arg0) {
				addButton.setEnabled(!getSelectedAvailableExtensions().isEmpty());
			}
		});
		
		final Composite buttonComposite = new Composite(container, SWT.NONE);
		buttonComposite.setLayout(new GridLayout(1, false));
		buttonComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		addButton = new Button(buttonComposite, SWT.NONE);
		addButton.setEnabled(false);
		final GridData gd_addButton = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_addButton.widthHint = 90;
		addButton.setLayoutData(gd_addButton);
		addButton.setText("Add >");
		addButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				final List<BasicExtensionModel> extensions = getSelectedAvailableExtensions();
				if (extensions.isEmpty()) {
					return;
				}
				final List<JoomlaExtensionDeployment> deployments = new ArrayList<JoomlaExtensionDeployment>();
				for (final BasicExtensionModel extension : extensions) {
					final JoomlaExtensionDeployment deployment = JoomlaServerConfigurationFactory.eINSTANCE.createJoomlaExtensionDeployment();
					deployment.setExtension(extension);
					deployments.add(deployment);
					if (toUninstall.contains(extension)) {
						toUninstall.remove(extension);
					} else {
						toInstall.add(extension);
					}
				}
				targetRuntime.getDeployedExtensions().addAll(deployments);
				configuredTreeViewer.expandAll();
				onScheduledOperationsChanged();
			}
		});
		
		removeButton = new Button(buttonComposite, SWT.NONE);
		removeButton.setEnabled(false);
		removeButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		removeButton.setText("< Remove");
		removeButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				final List<JoomlaExtensionDeployment> deployments = getSelectedConfiguredDeployments();
				if (deployments.isEmpty()) {
					return;
				}
				for (final JoomlaExtensionDeployment deployment : deployments) {
					final BasicExtensionModel extension = deployment.getExtension();
					extensionToProjectMap.get(extension).getExtensions().add(extension);
					deployment.getRuntime().getDeployedExtensions().remove(deployment);
					if (toInstall.contains(extension)) {
						toInstall.remove(extension);
					} else {
						toUninstall.add(extension);
					}
				}
				onScheduledOperationsChanged();
			}
		});
		
		final Composite configuredComposite = new Composite(container, SWT.NONE);
		configuredComposite.setLayout(new GridLayout(1, false));
		configuredComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		final Label lblConfigured = new Label(configuredComposite, SWT.NONE);
		lblConfigured.setText("Configured:");
		
		configuredTreeViewer = new TreeViewer(configuredComposite, SWT.BORDER | SWT.MULTI);
		configuredTreeViewer.setAutoExpandLevel(2);
		final Tree configuredTree = configuredTreeViewer.getTree();
		final GridData gd_configuredTree = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_configuredTree.widthHint = 200;
		configuredTree.setLayoutData(gd_configuredTree);
		configuredTreeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent arg0) {
				removeButton.setEnabled(!getSelectedConfiguredDeployments().isEmpty());
			}
		});
		
		initViewers();
	}

	private void onScheduledOperationsChanged() {
		setPageComplete(!toInstall.isEmpty() || !toInstall.isEmpty());
	}
	
	private List<BasicExtensionModel> getSelectedAvailableExtensions() {
		final ISelection availableTreeSelection = availableTreeViewer.getSelection();
		if (availableTreeSelection.isEmpty()) {
			return Collections.emptyList();
		} else {
			final IStructuredSelection structuredSelection = (IStructuredSelection) availableTreeSelection;
			final Set<BasicExtensionModel> extensions = new LinkedHashSet<BasicExtensionModel>();
			for (final Object element : structuredSelection.toList()) {
				if (element instanceof BasicExtensionModel) {
					extensions.add((BasicExtensionModel) element);
				} else if (element instanceof JoomlaExtensionProject) {
					extensions.addAll(((JoomlaExtensionProject) element).getExtensions());
				}
			}
			return extensions.isEmpty() ? Collections.<BasicExtensionModel>emptyList() : new ArrayList<BasicExtensionModel>(extensions);
		}
	}
	
	private List<JoomlaExtensionDeployment> getSelectedConfiguredDeployments() {
		final ISelection configuredSelection = configuredTreeViewer.getSelection();
		if (configuredSelection.isEmpty()) {
			return Collections.emptyList();
		} else {
			final IStructuredSelection structuredSelection = (IStructuredSelection) configuredSelection;
			final List<JoomlaExtensionDeployment> extensions = new ArrayList<JoomlaExtensionDeployment>();
			for (final Object element : structuredSelection.toList()) {
				if (element instanceof JoomlaExtensionDeployment) {
					extensions.add((JoomlaExtensionDeployment) element);
				}
			}
			return extensions;
		}
	}
	
	private void initViewers() {
		final IObservableList projectsObservable = new WritableList(extensionProjects, JoomlaExtensionProject.class);
		observables.add(projectsObservable);
		availableTreeViewer.setContentProvider(new ObservableListTreeContentProvider(new AvailableExtensionsObservableFactory(), new AvailableExtensionsStructureAdvisor()));
		availableTreeViewer.setLabelProvider(new ExtensionModelLabelProvider());
		availableTreeViewer.setInput(projectsObservable);
		
		final ArrayList<DeploymentRuntime> runtimeAsList = new ArrayList<DeploymentRuntime>();
		runtimeAsList.add(targetRuntime);
		final IObservableList runtimeObservable = new WritableList(runtimeAsList, DeploymentRuntime.class);
		observables.add(runtimeObservable);
		final DeploymentTreeContentProvider configuredContentProvider = new DeploymentTreeContentProvider();
		configuredTreeViewer.setContentProvider(configuredContentProvider);
		configuredTreeViewer.setLabelProvider(new DeploymentTreeLabelProvider(configuredContentProvider.getKnownElements()));
		configuredTreeViewer.setInput(runtimeObservable);
	}
	
	@Override
	public void dispose() {
		availableTreeViewer.setInput(null);
		configuredTreeViewer.setInput(null);
		for (final IObservable observable : observables) {
			observable.dispose();
		}
	}
	
	private static class AvailableExtensionsObservableFactory implements IObservableFactory {
		private final IEMFListProperty extensionsProperty = EMFProperties.list(JoomlaProjectModelPackage.Literals.JOOMLA_EXTENSION_PROJECT__EXTENSIONS);
		
		@Override
		public IObservable createObservable(Object target) {
			if (target instanceof IObservableList) {
				return (IObservable) target;
			} else if (target instanceof JoomlaExtensionProject) {
				return extensionsProperty.observe(target);
			}
			return null;
		}
	}
	
	private static class AvailableExtensionsStructureAdvisor extends TreeStructureAdvisor {
		@Override
		public Object getParent(Object element) {
			if (element instanceof BasicExtensionModel) {
				return ((BasicExtensionModel) element).getProject();
			}
			return null;
		}
	}
	
}
