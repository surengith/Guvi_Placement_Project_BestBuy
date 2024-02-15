package com.utils.org;

import java.io.IOException;

public class FileReaderManager {

	private FileReaderManager() {
		
	}
	
	public static FileReaderManager GetInstanceFRM() {
		FileReaderManager frm = new FileReaderManager();
		return frm;
	}

	public ConfigProperty getInstanceCR() throws IOException {
		ConfigProperty cr = new ConfigProperty();
		return cr;
	}
}