package com.schmeedy.pdt.joomla.ui.server.wizard;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.jface.databinding.viewers.ObservableListTreeContentProvider;
import org.eclipse.jface.databinding.viewers.TreeStructureAdvisor;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

import com.schmeedy.pdt.joomla.common.ui.JoomlaCommonUiPlugin;
import com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel;
import com.schmeedy.pdt.joomla.core.project.model.JoomlaExtensionProject;
import com.schmeedy.pdt.joomla.core.project.model.JoomlaProjectModelPackage;
import com.schmeedy.pdt.joomla.core.server.cfg.DeploymentRuntime;

public class AddOrRemoveExtensionsWizardSetupPage extends WizardPage {

	private final List<JoomlaExtensionProject> extensionProjects;
	private final DeploymentRuntime targetRuntime;
	
	private final List<IObservable> observables = new LinkedList<IObservable>();
	
	private TreeViewer availableTreeViewer;
	private TreeViewer configuredTreeViewer;
	
	public AddOrRemoveExtensionsWizardSetupPage(List<JoomlaExtensionProject> extensionProjects, DeploymentRuntime targetRuntime) {
		super("Add or remove extensions");
		this.extensionProjects = extensionProjects;
		this.targetRuntime = targetRuntime;
		setDescription("Select extensions to be synchronized with server");
		setTitle("Add or remove extensions");
	}

	@Override
	public void createControl(Composite parent) {
		final Composite container = new Composite(parent, SWT.NULL);
		setControl(container);
		container.setLayout(new GridLayout(3, false));
		
		final Composite availableComposite = new Composite(container, SWT.NONE);
		availableComposite.setLayout(new GridLayout(1, false));
		availableComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		final Label lblAvailable = new Label(availableComposite, SWT.NONE);
		lblAvailable.setText("Available:");
		
		availableTreeViewer = new TreeViewer(availableComposite, SWT.BORDER);
		availableTreeViewer.setAutoExpandLevel(2);
		final Tree availableTree = availableTreeViewer.getTree();
		availableTree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		final Composite buttonComposite = new Composite(container, SWT.NONE);
		buttonComposite.setLayout(new GridLayout(1, false));
		buttonComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		final Button addButton = new Button(buttonComposite, SWT.NONE);
		final GridData gd_addButton = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_addButton.widthHint = 90;
		addButton.setLayoutData(gd_addButton);
		addButton.setText("Add >");
		
		final Button btnNewButton = new Button(buttonComposite, SWT.NONE);
		btnNewButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnNewButton.setText("< Remove");
		
		final Composite configuredComposite = new Composite(container, SWT.NONE);
		configuredComposite.setLayout(new GridLayout(1, false));
		configuredComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		final Label lblConfigured = new Label(configuredComposite, SWT.NONE);
		lblConfigured.setText("Configured:");
		
		configuredTreeViewer = new TreeViewer(configuredComposite, SWT.BORDER);
		final Tree configuredTree = configuredTreeViewer.getTree();
		configuredTree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		initViewers();
	}

	private void initViewers() {
		final IObservableList projectsObservable = new WritableList(extensionProjects, JoomlaExtensionProject.class);
		observables.add(projectsObservable);
		availableTreeViewer.setContentProvider(new ObservableListTreeContentProvider(new AvailableExtensionsObservableFactory(), new AvailableExtensionsStructureAdvisor()));
		availableTreeViewer.setLabelProvider(new AvailableExtensionsLabelProvider());
		availableTreeViewer.setInput(projectsObservable);
	}
	
	@Override
	public void dispose() {
		availableTreeViewer.setInput(null);
		for (final IObservable observable : observables) {
			observable.dispose();
		}
	}
	
	private static class AvailableExtensionsLabelProvider extends LabelProvider {
		private final Image projectImage = PlatformUI.getWorkbench().getSharedImages().getImage(IDE.SharedImages.IMG_OBJ_PROJECT);
		
		private final Image componentImage = JoomlaCommonUiPlugin.getInstance().getImage(JoomlaCommonUiPlugin.IMG_OBJ_EXT_COMPONENT);
		private final Image pluginImage = JoomlaCommonUiPlugin.getInstance().getImage(JoomlaCommonUiPlugin.IMG_OBJ_EXT_PLUGIN);
		private final Image moduleImage = JoomlaCommonUiPlugin.getInstance().getImage(JoomlaCommonUiPlugin.IMG_OBJ_EXT_MODULE);
		
		@Override
		public Image getImage(Object element) {
			if (element instanceof JoomlaExtensionProject) {
				return projectImage;
			} if (element instanceof BasicExtensionModel) {
				switch (((BasicExtensionModel) element).getType()) {
					case COMPONENT:
						return componentImage;
					case PLUGIN:
						return pluginImage;
					case MODULE:
						return moduleImage;
				}
			}
			return super.getImage(element);
		}
		
		@Override
		public String getText(Object element) {
			if (element instanceof JoomlaExtensionProject) {
				return ((JoomlaExtensionProject) element).getProject().getName();
			} else if (element instanceof BasicExtensionModel) {
				return ((BasicExtensionModel) element).getName();
			}
			return super.getText(element);
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
		
		@Override
		public Boolean hasChildren(Object element) {
			if (element instanceof JoomlaExtensionProject) {
				return !((JoomlaExtensionProject) element).getExtensions().isEmpty();
			}
			return null;
		}
	}
	
}
