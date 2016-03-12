package com.malqua.thunderstone.events;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

/**
 * Created by Malqua on 3/11/2016.
 */
public class EventHandlerFML {

    @SubscribeEvent
    public void tickServer(TickEvent.ServerTickEvent event){
        if(event.phase == TickEvent.Phase.END){
            ServerTickHandler.OnTickInGame();
        }
    }
}
