import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * Feel free to use this. It is a template for a custom configuration class
 */
public class CustomConfiguration
{
	private File file;
	private YamlConfiguration config;

	public CustomConfiguration(File file)
	{
		this.file = file;
		load();
	}

	public void load()
	{
		config = YamlConfiguration.loadConfiguration(file);
		// Add and copy your defaults here
		// Do any other necessary things here too
	}

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
}
