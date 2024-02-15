package com.utils.org;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperty {

	public static Properties p;

	public ConfigProperty() throws IOException {

		File profile = new File(
				"C:\\Users\\Surendhar\\eclipse-workspace\\BestBuy_E-commerce_Project\\src\\main\\java\\com\\utils\\org\\config.properties");
		FileInputStream fis = new FileInputStream(profile);
		p = new Properties();
		p.load(fis);
	}

	public static String getBrowser() {
		String browser = p.getProperty("browser");
		return browser;
	}

	public static String getUrl() {
		String url = p.getProperty("url");
		return url;
	}
}
