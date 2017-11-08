package p455w0rd.endermanevo.init;

import java.io.File;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ModConfig {

	public static Configuration CONFIG;

	private static final String DEF_CAT = "General";
	public static boolean reloadConfigs = false;

	@SubscribeEvent
	public void onConfigChange(ConfigChangedEvent.OnConfigChangedEvent e) {
		if (e.getModID().equals(ModGlobals.MODID)) {
			init();
		}
	}

	public static void init() {
		if (CONFIG == null) {
			CONFIG = new Configuration(new File(ModGlobals.CONFIG_FILE));
			MinecraftForge.EVENT_BUS.register(new ModConfig());
		}

		ConfigOptions.ENABLE_ENDERMAN = CONFIG.getBoolean("EnableEnderman", DEF_CAT, true, "Enable custom Enderman");
		ConfigOptions.ENDERMAN_DAY_SPAWN = CONFIG.getBoolean("EndermanSpawnIgnoreLightLevel", DEF_CAT, true, "Allow custom Enderman to spawn at any light level");
		ConfigOptions.ENABLE_FRIENDERMAN = CONFIG.getBoolean("EnableFrienderman", DEF_CAT, true, "Enable the Friendermans =]");
		ConfigOptions.ENDERMAN_PROBABILITY = CONFIG.getInt("EndermanSpawnProbability", DEF_CAT, 3, 1, 10, "Probability PWThings Enderman will spawn when game deicdes to spawn a mob");
		ConfigOptions.ENDERMAN_MAX_SPAWN = CONFIG.getInt("EndermanMaxSpawnPerGroup", DEF_CAT, 2, 1, 4, "When the game decides to spawn PWThings Enderman, what is the max that should spawn in the group?");

		if (CONFIG.hasChanged() || reloadConfigs) {
			CONFIG.save();
			reloadConfigs = false;
		}
	}

	public static class ConfigOptions {

		public static boolean ENABLE_ENDERMAN = true;
		public static boolean ENABLE_FRIENDERMAN = true;
		public static int ENDERMAN_PROBABILITY = 3;
		public static int ENDERMAN_MAX_SPAWN = 2;
		public static boolean ENDERMAN_DAY_SPAWN = true;

	}
}