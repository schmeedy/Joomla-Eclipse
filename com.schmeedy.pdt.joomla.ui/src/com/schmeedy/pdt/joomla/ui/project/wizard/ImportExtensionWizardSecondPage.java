package com.schmeedy.pdt.joomla.ui.project.wizard;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.dltk.ui.wizards.NewElementWizardPage;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnPixelData;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import com.schmeedy.pdt.joomla.common.ui.EmulatedNativeCheckBoxLabelProvider;
import com.schmeedy.pdt.joomla.common.ui.JoomlaCommonUiPlugin;
import com.schmeedy.pdt.joomla.core.project.importer.ArchivedExtensionManifest;
import com.schmeedy.pdt.joomla.core.project.importer.IJoomlaExtensionPackageImporter;
import com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel;
import com.schmeedy.pdt.joomla.ui.JoomlaUiPlugin;
import com.schmeedy.pdt.joomla.ui.project.ExtensionProjectFactory;

public class ImportExtensionWizardSecondPage extends NewElementWizardPage {

	private static final String DESCRIPTION = "Select extensions to import.";

	private TableViewer tableViewer;
	
	private TableRow[] tableModel;
	
	private final IExtensionPackageFileProvider extensionPackageFileProvider;
	
	private final IJoomlaExtensionPackageImporter extensionPackageImporter;
	
	private final ExtensionProjectFactory projectFactory = new ExtensionProjectFactory();
	
	public ImportExtensionWizardSecondPage(IExtensionPackageFileProvider extensionPackageFileProvider, IJoomlaExtensionPackageImporter extensionPackageImporter) {
		super("Import Joomla! Extension");
		setTitle("Import Joomla! Extension");
		setDescription(DESCRIPTION);
				
		this.extensionPackageFileProvider = extensionPackageFileProvider;
		this.extensionPackageImporter = extensionPackageImporter;
		
		setPageComplete(false);
	}

	@Override
	public void createControl(Composite parent) {
		final Composite container = new Composite(parent, SWT.NULL);
		setControl(container);
		container.setLayout(new GridLayout(1, false));
		
		final Composite composite = new Composite(container, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		final TableColumnLayout tcl_composite = new TableColumnLayout();
		composite.setLayout(tcl_composite);
		
		tableViewer = new TableViewer(composite, SWT.BORDER | SWT.FULL_SELECTION);
		final Table table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		tableViewer.setContentProvider(new ArrayContentProvider());
		
		final TableViewerColumn importColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		final TableColumn tblclmnImport = importColumn.getColumn();
		tcl_composite.setColumnData(tblclmnImport, new ColumnPixelData(25, false, true));
		importColumn.setLabelProvider(new EmulatedNativeCheckBoxLabelProvider(tableViewer) {
			@Override
			protected boolean isChecked(Object element) {
				return ((TableRow) element).doImport;
			}
			
			@Override
			public String getText(Object element) {
				return "";
			}
		});
		importColumn.setEditingSupport(new EditingSupport(tableViewer) {
			@Override
			protected void setValue(Object element, Object value) {
				((TableRow) element).doImport = value == null ? null : (Boolean) value;
				tableViewer.refresh();
				validate();
			}
			
			@Override
			protected Object getValue(Object element) {
				return ((TableRow) element).doImport;
			}
			
			@Override
			protected CellEditor getCellEditor(Object element) {
				return new CheckboxCellEditor(table, SWT.CHECK);
			}
			
			@Override
			protected boolean canEdit(Object element) {
				return true;
			}
		});
		
		final TableViewerColumn extensionInfoColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		final TableColumn tblclmnNewColumn = extensionInfoColumn.getColumn();
		tcl_composite.setColumnData(tblclmnNewColumn, new ColumnWeightData(60));
		tblclmnNewColumn.setText("Extension Info");
		extensionInfoColumn.setLabelProvider(new ColumnLabelProvider() {
			private final Image componentImage = JoomlaCommonUiPlugin.getInstance().getImage(JoomlaCommonUiPlugin.IMG_OBJ_EXT_COMPONENT);
			private final Image pluginImage = JoomlaCommonUiPlugin.getInstance().getImage(JoomlaCommonUiPlugin.IMG_OBJ_EXT_PLUGIN);
			private final Image moduleImage = JoomlaCommonUiPlugin.getInstance().getImage(JoomlaCommonUiPlugin.IMG_OBJ_EXT_MODULE);
			
			@Override
			public Image getImage(Object element) {
				final BasicExtensionModel model = ((TableRow) element).extension.getModel();
				if (model.getType() == null) {
					return super.getImage(element);
				}
				switch (model.getType()) {
					case COMPONENT:
						return componentImage;
					case MODULE:
						return moduleImage;
					case PLUGIN:
						return pluginImage;
					default:
						return super.getImage(element);
				}
			}
			
			@Override
			public String getText(Object element) {
				final BasicExtensionModel model = ((TableRow) element).extension.getModel();
				return model.getName() + ", " + model.getManifestVersion() + " " + model.getType().getLiteral() + " (" + model.getManifestPath().lastSegment() + ")";
			}
		});
		
		final TableViewerColumn projectNameColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		final TableColumn tblclmnProject = projectNameColumn.getColumn();
		tcl_composite.setColumnData(tblclmnProject, new ColumnWeightData(40));
		tblclmnProject.setText("Project Name");
		projectNameColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				return ((TableRow) element).projectName;
			}
		});
		projectNameColumn.setEditingSupport(new EditingSupport(tableViewer) {
			@Override
			protected void setValue(Object element, Object value) {
				((TableRow) element).projectName = value == null || "".equals(value) ? null : value.toString();
				tableViewer.refresh();
				validate();
			}
			
			@Override
			protected Object getValue(Object element) {
				return ((TableRow) element).projectName == null ? "" : ((TableRow) element).projectName;
			}
			
			@Override
			protected CellEditor getCellEditor(Object element) {
				return new TextCellEditor(table);
			}
			
			@Override
			protected boolean canEdit(Object element) {
				return element != null;
			}
		});
	}
	
	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		if (visible) {
			scanExtensionPackage();
		}
	}
	
	private void scanExtensionPackage() {
		try {
			final File packageFile = extensionPackageFileProvider.getExtensionPackageFile();
			getContainer().run(true, false, new IRunnableWithProgress() {
				@Override
				public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
					final List<ArchivedExtensionManifest> manifests = extensionPackageImporter.findExtensionManifests(packageFile, monitor);
					final List<TableRow> tableRows = new LinkedList<ImportExtensionWizardSecondPage.TableRow>();
					for (final ArchivedExtensionManifest archivedExtensionManifest : manifests) {
						final TableRow tableRow = new TableRow(archivedExtensionManifest);
						if (manifests.size() == 1) {
							tableRow.doImport = true;
						}
						tableRow.projectName = projectFactory.suggestProjectName(archivedExtensionManifest.getModel());
						tableRows.add(tableRow);
					}
					getShell().getDisplay().asyncExec(new Runnable() {
						@Override
						public void run() {
							tableModel = tableRows.toArray(new TableRow[tableRows.size()]);
							tableViewer.setInput(tableModel);
							validate();
						}
					});
				}
			});
		} catch (final InvocationTargetException e) {
			setErrorMessage(e.getMessage());
			JoomlaUiPlugin.getInstance().logError("Exception while scanning extension package.", e);
		} catch (final InterruptedException e) {
			return;
		}
	}
	
	private void validate() {
		if (tableModel.length == 0) {
			setMessage("No supported Joomla! extension found.", IMessageProvider.WARNING);
			return;
		}
		
		final Set<String> lowerCaseProjectNames = new HashSet<String>();
		for (final IProject project : ResourcesPlugin.getWorkspace().getRoot().getProjects()) {
			lowerCaseProjectNames.add(project.getName().toLowerCase());
		}
		
		final Set<String> importedProjectNamesLowerCase = new HashSet<String>();
		for (final TableRow row : tableModel) {
			if (row.doImport) {
				final String projectName = row.projectName;
				if (projectName == null || projectName.equals("")) {
					setErrorMessage("Project name cannot be empty - enter project name for '" + row.extension.getModel().getName() + "'");
					setPageComplete(false);
					return;
				}
				final String requestedProjectNameLC = (projectName).trim().toLowerCase();
				if (lowerCaseProjectNames.contains(requestedProjectNameLC)) {
					setErrorMessage("Project with name '" + projectName + "' already exists, please choose another name.");
					setPageComplete(false);
					return;
				}
				if (importedProjectNamesLowerCase.contains(projectName.toLowerCase())) {
					setErrorMessage("Multiple imported projects share the same name: " + projectName);
					setPageComplete(false);
					return;
				}
				importedProjectNamesLowerCase.add(projectName);
			}
		}
		
		setErrorMessage(null);
		setMessage(DESCRIPTION + " You can modify name of the extension's project directly in the table.", IMessageProvider.INFORMATION);
		setPageComplete(!importedProjectNamesLowerCase.isEmpty());
	}

	private static class TableRow {
		boolean doImport;
		ArchivedExtensionManifest extension;
		String projectName;
		
		TableRow(ArchivedExtensionManifest extension) {
			super();
			this.extension = extension;
		}
	}
	
}
