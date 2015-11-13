import org.bukkit.*;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class CustomConfigExample
{
	private static final String HOME = "home";
	private static final String WELCOME_MESSAGE = "welcome-message";
	private static final String KILLS = "kills";
	private static final String SOME_STRING_LIST = "some-string-list";

	private File file;
	private YamlConfiguration config;

	public CustomConfigExample(File file)
	{
		this.file = file;
		load();
	}

	/**
	 * Loads the configuration. You can use this to reload it as well.
	 */
	public void load()
	{
		config = YamlConfiguration.loadConfiguration(file);
		config.addDefault(HOME, Bukkit.getWorlds().get(0).getName());
		config.addDefault(WELCOME_MESSAGE, "&aWelcome home!");
		config.addDefault(KILLS, 0);
		config.addDefault(SOME_STRING_LIST, new ArrayList<>());
		config.options().copyDefaults(true);
	}

	/**
	 * Saves the configuration
	 */
	public void save()
	{
		try
		{
			config.save(file);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public World getHome()
	{
		return Bukkit.getWorld(config.getString(HOME));
	}

	public void setHome(World world)
	{
		config.set(HOME, world.getName());
	}

	public String getWelcomeMessage()
	{
		return ChatColor.translateAlternateColorCodes('&', config.getString(WELCOME_MESSAGE));
	}

	public void setWelcomeMessage(String s)
	{
		config.set(WELCOME_MESSAGE, s);
	}

	public int getKills()
	{
		return config.getInt(KILLS);
	}

	public void setKills(int i)
	{
		config.set(KILLS, i);
	}

	public List<String> getSomeStringList()
	{
		return config.getStringList(SOME_STRING_LIST);
	}

	public void setSomeStringList(List<String> list)
	{
		config.set(SOME_STRING_LIST, list);
	}
}

