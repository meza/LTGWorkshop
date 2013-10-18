package ltg.workshop.meza;

import hu.meza.tools.config.Config;
import hu.meza.tools.config.Loaders.ResourceConfiguration;
import hu.meza.tools.config.Required;

public class Configuration {

	private Config config = new Config();

	public Configuration() {
		config.add(new Required(new ResourceConfiguration("users.properties")));
	}

	public String getUsernameFor(String user) {
		String key = String.format("%s.username", user);
		return config.get(key);
	}

	public String getPasswordFor(String user) {
		String key = String.format("%s.password", user);
		return config.get(key);
	}
}
