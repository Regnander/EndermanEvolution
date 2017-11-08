package p455w0rd.endermanevo.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppedEvent;
import p455w0rd.endermanevo.init.ModBlocks;
import p455w0rd.endermanevo.init.ModConfig;
import p455w0rd.endermanevo.init.ModEntities;
import p455w0rd.endermanevo.init.ModEvents;
import p455w0rd.endermanevo.init.ModIntegration;
import p455w0rd.endermanevo.init.ModItems;
import p455w0rd.endermanevo.init.ModLogger;
import p455w0rd.endermanevo.init.ModNetworking;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent e) {
		ModLogger.infoBegin("PreInit");
		ModConfig.init();
		ModBlocks.init();
		ModItems.init();
		ModIntegration.preInit();
		ModNetworking.init();
		ModLogger.infoEnd("PreInit");
	}

	public void init(FMLInitializationEvent e) {
		ModLogger.infoBegin("Init");
		ModEvents.init();
		ModEntities.init();
		ModIntegration.init();
		ModLogger.infoEnd("Init");
	}

	public void postInit(FMLPostInitializationEvent e) {
		ModLogger.infoBegin("PostInit");
		ModIntegration.postInit();
		ModLogger.infoEnd("PostInit");
	}

	public void serverStarting(FMLServerStartingEvent e) {
	}

	public void serverStopped(FMLServerStoppedEvent event) {
	}

	public EntityPlayer getPlayer() {
		return null;
	}

}
