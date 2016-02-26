package com.malqua.thunderstone;

import com.malqua.thunderstone.events.EventHandlerPacket;
import com.malqua.thunderstone.init.ThunderstoneEntities;
import com.malqua.thunderstone.init.ThunderstoneItems;
import com.malqua.thunderstone.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.FMLEventChannel;
import net.minecraftforge.fml.common.network.NetworkRegistry;

/**
 * Created by Malqua on 2/25/2016.
 */

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.version)
public class ThunderstoneMod {

    public static ThunderstoneMod instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    public static String eventChannelName = "thunderstoneEvent";
    public static final FMLEventChannel eventChannel = NetworkRegistry.INSTANCE.newEventDrivenChannel(eventChannelName);

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e){
        instance = this;
        eventChannel.register(new EventHandlerPacket());
        ThunderstoneItems.init();
        ThunderstoneItems.register();
        ThunderstoneEntities.init();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e){
        proxy.registerRenders();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e){

    }
}
