package com.malqua.thunderstone.events;

import com.malqua.thunderstone.Reference;
import com.malqua.thunderstone.ThunderstoneMod;
import com.malqua.thunderstone.entity.EntityThunderBolt;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.MathHelper;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.event.FMLInterModComms;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;
import net.minecraftforge.fml.common.network.internal.FMLProxyPacket;

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
