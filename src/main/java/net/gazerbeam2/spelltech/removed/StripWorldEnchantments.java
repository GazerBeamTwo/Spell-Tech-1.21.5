package net.gazerbeam2.spelltech.removed;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;

public class StripWorldEnchantments {

    public static void register() {
        ServerTickEvents.END_WORLD_TICK.register(world -> {
            for (PlayerEntity player : world.getPlayers()) {
                // Get the player's position and define the radius
//                Vec3d playerPos = player.getPos();
//                double radius = 10.0;  // Adjust the radius as needed
//
//                // Create a Box around the player with a given radius
//                Box box = new Box(playerPos.subtract(radius, radius, radius), playerPos.add(radius, radius, radius));


//                for (ItemEntity entity : world.getEntitiesByClass(ItemEntity.class, box, item -> item.getStack().contains(DataComponentTypes.ENCHANTMENTS))) {
//                    // Remove enchantments
//                    ItemStack clean = entity.getStack().copy();
//                    clean.set(DataComponentTypes.ENCHANTMENTS, null);
//                    entity.setStack(clean);
//                }

                for (int i = 0; i < player.getInventory().size(); i++) {
                    ItemStack stack = player.getInventory().getStack(i);

                    // Check if the item has enchantments and remove them
                    if (stack.contains(DataComponentTypes.ENCHANTMENTS)) {
                        var enchantments = stack.get(DataComponentTypes.ENCHANTMENTS);
                        if (enchantments != null && !enchantments.isEmpty()) {
                            ItemStack clean = stack.copy();
                            clean.set(DataComponentTypes.ENCHANTMENTS, null); // Remove enchantments
                            player.getInventory().setStack(i, clean); // Update the inventory
                        }
                    }

                    if (stack.isOf(Items.ENCHANTED_BOOK)) {
                        player.getInventory().setStack(i, ItemStack.EMPTY);
                    }
                }
            }
        });
    }
}