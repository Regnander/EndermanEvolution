package p455w0rd.endermanevo.init;

import java.io.File;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ModConfig {

	public static Configuration CONFIG;

	private static final String DEF_CAT = "General";
	public static final String CLIENT_CAT = "Client Only";
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

		ConfigOptions.ENDERMAN_DAY_SPAWN = CONFIG.getBoolean("EndermanSpawnIgnoreLightLevel", DEF_CAT, true, "Allow Evolved Enderman to spawn at any light level");
		ConfigOptions.ENDERMAN_PROBABILITY = CONFIG.getInt("EndermanSpawnProbability", DEF_CAT, 3, 1, 10, "Probability Evolved Enderman will spawn when game deicdes to spawn a mob");
		ConfigOptions.FRIENDERMAN_PROBABILITY = CONFIG.getInt("FrindermanSpawnProbability", DEF_CAT, 3, 1, 10, "Probability Frienderman will spawn when game deicdes to spawn a mob");
		ConfigOptions.ENDERMAN_MAX_SPAWN = CONFIG.getInt("EndermanMaxSpawnPerGroup", DEF_CAT, 2, 1, 4, "When the game decides to spawn an Evolved Enderman, what is the max that should spawn in the group?");
		ConfigOptions.FRIENDERMAN_MAX_SPAWN = CONFIG.getInt("FriendermanMaxSpawnPerGroup", DEF_CAT, 2, 1, 4, "When the game decides to spawn a Frienderman, what is the max that should spawn in the group?");
		ConfigOptions.SHOW_SKULL_PARTICLES = CONFIG.getBoolean("DisplaySkullParticles", CLIENT_CAT, true, "Whether or not to spawn particles when wearing an enderman skull");
		ConfigOptions.ENABLE_ENDERFLOWER_WORLDGEN = CONFIG.getBoolean("EnableEnderDaisyWorldGen", DEF_CAT, true, "Whether or not Ender Daisies generate naturally");
		ConfigOptions.ENDERFLOWER_SPAWN_PROBABILITY = CONFIG.getFloat("EnderDaisySpawnProbability", DEF_CAT, 0.2F, 0.01F, 0.8F, "Chance between 0.0 and 1.0 that an Ender Daisy will spawn (0.2=20% chance)");
		ConfigOptions.ENDERFLOWER_DIM_WHITELIST = CONFIG.get(DEF_CAT, "EnderDaisyDimensionWhitelist", new int[] {
				-1, 0, 1
		}, "Integer dimension IDs where Ender Daisies are allowed to spawn. One integer per line.").getIntList();

		if (CONFIG.hasChanged() || reloadConfigs) {
			CONFIG.save();
			reloadConfigs = false;
		}
	}

	public static class ConfigOptions {

		public static int ENDERMAN_PROBABILITY = 3;
		public static int FRIENDERMAN_PROBABILITY = 3;
		public static int ENDERMAN_MAX_SPAWN = 2;
		public static int FRIENDERMAN_MAX_SPAWN = 2;
		public static boolean ENDERMAN_DAY_SPAWN = true;
		public static boolean SHOW_SKULL_PARTICLES = true;
		public static boolean ENABLE_ENDERFLOWER_WORLDGEN = true;
		public static float ENDERFLOWER_SPAWN_PROBABILITY = 0.2F;
		public static int[] ENDERFLOWER_DIM_WHITELIST = new int[] {
				-1, 0, 1
		};

	}
}
