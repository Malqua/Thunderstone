package com.malqua.thunderstone.events;

import io.netty.buffer.ByteBuf;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;

import java.io.IOException;

/**
 * Created by Malqua on 2/26/2016.
 */
public class EventHandlerPacket {

    @SubscribeEvent
    public void onPacketFromServer(FMLNetworkEvent.ClientCustomPacketEvent event) {
        try{
            NBTTagCompound nbt = readNBTTagCompound(event.packet.payload());
            String packetCommand = nbt.getString("packetCommand");

            if(packetCommand.equals("ThunderBolt")){
                EventManagerClient.nbtSyncFromServer(nbt);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @SubscribeEvent
    public void onPacketFromClient(FMLNetworkEvent.ServerCustomPacketEvent event) {
        try{
            NBTTagCompound nbt = readNBTTagCompound(event.packet.payload());
            String packetCommand = nbt.getString("packetCommand");

            if(packetCommand.equals("ThunderBolt")){

            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public static NBTTagCompound readNBTTagCompound(ByteBuf fullBuffer) throws IOException {
        return ByteBufUtils.readTag(fullBuffer);
    }
}
