package com.schmeedy.pdt.joomla.core.project.buildpath;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.dltk.core.DLTKCore;
import org.eclipse.dltk.core.IBuildpathEntry;

import com.schmeedy.pdt.joomla.core.project.buildpath.impl.JoomlaBuildpathContainer;
import com.schmeedy.pdt.joomla.core.server.cfg.LocalJoomlaServer;

public class JoomlaBuildpathUtils {
	
	private JoomlaBuildpathUtils() {}
	
	public static boolean isJoomlaContainerPath(final IPath path) {
		return path.segmentCount() > 0 && path.segment(0).equals(JoomlaBuildpathContainer.ID);
	}
	
	public static boolean isJoomlaContainerEntry(IBuildpathEntry entry) {
		if (entry == null) {
			return false;
		}
		final IPath path = entry.getPath();
		return isJoomlaContainerPath(path);
	}
	
	public static boolean isDefaultJoomlaContainerEntry(IBuildpathEntry entry) {
		return isJoomlaContainerEntry(entry) && entry.getPath().segmentCount() == 1;
	}
	
	public static boolean isExtendedJoomlaContainerEntry(IBuildpathEntry entry) {
		return entry != null && isExtendedJoomlaContainerPath(entry.getPath());
	}
	
	public static boolean isExtendedJoomlaContainerPath(IPath path) {
		return isJoomlaContainerPath(path) && path.segmentCount() > 1;
	}
	
	public static IBuildpathEntry newDefaultJoomlaContainerEntry() {
		return DLTKCore.newContainerEntry(new Path(JoomlaBuildpathContainer.ID));
	}
	
	public static IBuildpathEntry newJoomlaContainerEntry(LocalJoomlaServer server) {
		return DLTKCore.newContainerEntry(new Path(JoomlaBuildpathContainer.ID + "/" + server.getTeamId()));
	}
	
	public static String getJoomlaServerTeamId(IBuildpathEntry entry) {
		if (!isJoomlaContainerEntry(entry) || isDefaultJoomlaContainerEntry(entry)) {
			throw new IllegalArgumentException("Entry is not an extended Joomla! container entry.");
		}
		return entry.getPath().segment(1);
	}
	
	public static String getJoomlaServerTeamId(IPath containerPath) {
		if (!isExtendedJoomlaContainerPath(containerPath)) {
			throw new IllegalArgumentException("Path is not an extended Joomla! container path.");
		}
		return containerPath.segment(1);
	}
	
}
