package xyz.pepefab.ultrapixelmon.Listeners;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.server.permission.PermissionAPI;

public class DisableBucketInPokemon {

    @SubscribeEvent
    public void playerInteractEvent(PlayerInteractEvent event){

        ItemStack it = event.getItemStack();
        final boolean hasPermission = PermissionAPI.hasPermission(event.getEntityPlayer(), "worldbuildallow.worldbuildallow");

        if(it.isEmpty()) return;
        if(!hasPermission){
            World world = event.getWorld();
            if(world.getWorldInfo().getWorldName().equals("world")){
                if(it.getItem() == Items.LAVA_BUCKET ||
                        it.getItem() == Items.WATER_BUCKET ||
                        it.getItem() == Item.getByNameOrId("FORGE:BUCKETFILLED")){
                    event.setCanceled(true);
                    event.getEntityPlayer().sendMessage(new TextComponentString(TextFormatting.GRAY + "Vous ne pouvez pas interagir avec cet objet dans la main."));
                }
            }
        }
    }

}
