package net.quetzi.bluepower;

import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;
import net.quetzi.bluepower.init.BPBlocks;
import net.quetzi.bluepower.init.BPItems;
import net.quetzi.bluepower.init.Config;
import net.quetzi.bluepower.init.CustomTabs;
import net.quetzi.bluepower.init.Recipes;
import net.quetzi.bluepower.references.Refs;
import net.quetzi.bluepower.world.WorldGenerationHandler;

import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Refs.MODID, name = Refs.NAME)
public class BluePower {
    @Instance("BluePower")
    public static BluePower instance;
//    @SidedProxy(clientSide = "ClientProxy", serverSide = "CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void PreInit(FMLPreInitializationEvent event) {
        event.getModMetadata().version = Refs.fullVersionString();
        
        Logger log = event.getModLog();
        Configuration config = new Configuration(event.getSuggestedConfigurationFile());
        
        CustomTabs.init();
        // Load configs
        config.load();
        Config.setUp(config);
        config.save();

        BPBlocks.init();
        BPItems.init();
        GameRegistry.registerWorldGenerator(new WorldGenerationHandler(), 0);
    }
    @EventHandler
    public void Init(FMLInitializationEvent event) {
        Recipes.init(CraftingManager.getInstance());
    }
    @EventHandler
    public void PostInit(FMLPostInitializationEvent event) {
        
        // register events
    }
    @EventHandler
    public void ServerStarting(FMLServerStartingEvent event) {
        // register commands
    }
}
