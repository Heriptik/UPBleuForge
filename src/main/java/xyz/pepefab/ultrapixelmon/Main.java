package xyz.pepefab.ultrapixelmon;

import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.server.permission.DefaultPermissionLevel;
import net.minecraftforge.server.permission.PermissionAPI;
import org.apache.logging.log4j.Logger;
import xyz.pepefab.ultrapixelmon.Listeners.DisableBucketInPokemon;

@Mod(modid = Main.MODID, name = Main.NAME, version = Main.VERSION, serverSideOnly = true, acceptableRemoteVersions = "*")
public class Main
{
    public static final String MODID = "upbleuforge";
    public static final String NAME = "UPBleuForge";
    public static final String VERSION = "1.0";

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        MinecraftForge.EVENT_BUS.register(new DisableBucketInPokemon());
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        logger.info("[UPBleuForge] Mod initialise avec succes. Version: " + Main.VERSION);
        PermissionAPI.registerNode("worldbuildallow.worldbuildallow", DefaultPermissionLevel.OP, "Permet de ne pas avoir de restriction de pose");
    }
}
