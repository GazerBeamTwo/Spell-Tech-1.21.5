package net.gazerbeam2.spelltech.component;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import org.jetbrains.annotations.NotNull;

public class PlayerLevelComponent implements SpellLevelComponent {

    private final PlayerEntity player;
    private int level = 0;

    public PlayerLevelComponent(PlayerEntity player) {
        this.player = player;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public void setLevel(int level) {
        this.level = level;
        sync();
    }

    @Override
    public void sync() {
        ModComponents.LEVEL.sync(this.player);
    }

    @Override
    public void readFromNbt(NbtCompound nbtCompound, RegistryWrapper.WrapperLookup wrapperLookup) {
        this.level = nbtCompound.getInt("level", 0);  // Load the level value from NBT
    }

    @Override
    public void writeToNbt(NbtCompound nbtCompound, RegistryWrapper.WrapperLookup wrapperLookup) {
        nbtCompound.putInt("level", this.level);  // Save the level value in NBT
    }
}