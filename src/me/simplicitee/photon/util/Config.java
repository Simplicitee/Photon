package me.simplicitee.photon.util;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Config {

	private File file;
	private FileConfiguration config;
	
	public Config(File file) {
		this.file = file;
		this.config = YamlConfiguration.loadConfiguration(file);
		this.init();
	}
	
	private void init() {
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void reload() {
		try {
			this.config.load(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void save() {
		this.init();
		config.options().copyDefaults(true);
		try {
			config.save(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public FileConfiguration bukkit() {
		return config;
	}
}
