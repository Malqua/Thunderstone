package com.malqua.thunderstone.events;

import com.malqua.thunderstone.ThunderstoneMod;
import com.malqua.thunderstone.entity.weather.EntityThunderBolt;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.MathHelper;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.internal.FMLProxyPacket;

/**
 * Created by Malqua on 2/26/2016.
 */
public class EventManagerServer {

    public static void syncLightningBolt(EntityLightningBolt parEnt) {
        NBTTagCompound data = new NBTTagCompound();
        data.setString("packetCommand", "LightningBolt");
        data.setString("command", "syncLightningBolt");
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setInteger("posX", MathHelper.floor_double(parEnt.posX/* * 32.0D*/));
        nbt.setInteger("posY", MathHelper.floor_double(parEnt.posY/* * 32.0D*/));
        nbt.setInteger("posZ", MathHelper.floor_double(parEnt.posZ/* * 32.0D*/));
        nbt.setInteger("entityID", parEnt.getEntityId());
        data.setTag("data", nbt);
        ThunderstoneMod.eventChannel.sendToDimension(getNBTPacket(data, ThunderstoneMod.eventChannelName),
                parEnt.worldObj.provider.getDimensionId());
    }

    public static void syncThunderBolt(EntityThunderBolt parEnt) {
        NBTTagCompound data = new NBTTagCompound();
        data.setString("packetCommand", "ThunderBolt");
        data.setString("command", "syncThunderBolt");
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setInteger("posX", MathHelper.floor_double(parEnt.posX/* * 32.0D*/));
        nbt.setInteger("posY", MathHelper.floor_double(parEnt.posY/* * 32.0D*/));
        nbt.setInteger("posZ", MathHelper.floor_double(parEnt.posZ/* * 32.0D*/));
        nbt.setInteger("entityID", parEnt.getEntityId());
        data.setTag("data", nbt);
        ThunderstoneMod.eventChannel.sendToDimension(getNBTPacket(data, ThunderstoneMod.eventChannelName),
                parEnt.worldObj.provider.getDimensionId());
    }

    public static FMLProxyPacket getNBTPacket(NBTTagCompound parNBT, String parChannel) {
        ByteBuf byteBuf = Unpooled.buffer();

        try {
            //byteBuf.writeBytes(CompressedStreamTools.compress(parNBT));
            ByteBufUtils.writeTag(byteBuf, parNBT);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return new FMLProxyPacket(new PacketBuffer(byteBuf), parChannel);
    }
}
