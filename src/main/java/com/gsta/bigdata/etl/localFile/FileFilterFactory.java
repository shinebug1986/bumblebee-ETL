package com.gsta.bigdata.etl.localFile;

import java.io.FilenameFilter;

import com.gsta.bigdata.etl.ETLException;
import com.gsta.bigdata.etl.core.Constants;
import com.gsta.bigdata.etl.core.ETLProcess;
import com.gsta.bigdata.utils.StringUtils;
/**
 * 
 * @author Shine
 *
 */
public class FileFilterFactory {
	public static FilenameFilter createFileFilter(ETLProcess process,
			String fileSuffix, String fileNamePattern) throws ETLException {
		if (process == null) {
			throw new ETLException("process object is null.");
		}

		String type = process.getSourceType();
		type = StringUtils.upperCaseFirstChar(type);
		if (Constants.SOURCE_ZTE_NODEB_XML.equals(type) && fileNamePattern != null) {
			return new ExtensionAndPatternFileFilter(fileSuffix, fileNamePattern);
		} else {
			return new ExtensionFileFilter(fileSuffix);
		}
	}
}
