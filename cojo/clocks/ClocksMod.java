package cojo.clocks;

import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import cojo.proxies.CommonProxy;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.Mod.ServerStarting;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;

@NetworkMod(channels = { "Clocks" }, clientSideRequired = true, serverSideRequired = false)
@Mod(modid = ModInfo.MODID, name = ModInfo.NAME, version = ModInfo.VERSION)
public class ClocksMod {

	@Instance(ModInfo.MODID)
	public static ClocksMod instance;

	/**
	 * Tropicraft configuration file
	 */
	public Configuration config;

	/** Used for client-side stuff on servers, etc */
	@SidedProxy(clientSide = "clocks.proxies.ClientProxy", serverSide = "clocks.proxies.CommonProxy")
	public static CommonProxy proxy;

	/**
	 * Initialize commands registry
	 * @param event Event invoked upon server start
	 */
	@ServerStarting
	public void serverStarting(FMLServerStartingEvent event) {

		//CommandRegistry.init(event);
	}

	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		try {
			config = new Configuration(event.getSuggestedConfigurationFile());
			ConfigHandler.initConfig(config);
		} catch (Exception e) {
			FMLLog.log(Level.SEVERE, e, "Tropicraft has a problem loading it's configuration");
		} finally {
			config.save();
		}
	}


	@Init
	public void load(FMLInitializationEvent evt) {
		ClockBlocks.init();
		ClockItems.init();

		//schedule this class for event callbacks
		MinecraftForge.EVENT_BUS.register(this);
	}

	@PostInit
	public void modsLoaded(FMLPostInitializationEvent evt) {

	}
}
