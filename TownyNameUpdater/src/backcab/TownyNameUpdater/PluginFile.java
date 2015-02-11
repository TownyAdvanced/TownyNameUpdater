package backcab.TownyNameUpdater;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

public class PluginFile {
	private YamlConfiguration file;
	private File f;
	
	protected PluginFile(TownyNameUpdater p, String name){
		f = new File(p.getDataFolder().toString() + "/" + name + ".yml");
		if(!f.exists()){
			p.saveResource(name + ".yml", false);
		}
		file = YamlConfiguration.loadConfiguration(f);
	}
	
	protected ConfigurationSection get(String path){
		return file.getConfigurationSection(path);
	}
	
	protected YamlConfiguration getFile(){
		return file;
	}
	
	protected void save() throws IOException{
		file.save(f);
		file = YamlConfiguration.loadConfiguration(f);
	}
	
	protected void reload(){
		file = YamlConfiguration.loadConfiguration(f);
	}
}
