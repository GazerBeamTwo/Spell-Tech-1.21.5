package net.gazerbeam2.spelltech.component;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;
import net.minecraft.nbt.NbtString;
import net.minecraft.registry.RegistryWrapper;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class PlayerSpellDataComponentImpl implements PlayerSpellDataComponent {

    private final PlayerEntity player;
    private final Set<String> unlockedSpells = new HashSet<>();

    public PlayerSpellDataComponentImpl(PlayerEntity player) {
        this.player = player;
    }

    @Override
    public boolean hasUnlocked(String spellId) {
        return unlockedSpells.contains(spellId);
    }

    @Override
    public void unlock(String spellId) {
        if (unlockedSpells.add(spellId)) { // Only add if not already unlocked
            sync(); // Only sync if new spell was added
        }
    }

    @Override
    public Set<String> getUnlockedSpells() {
        return unlockedSpells;
    }

    @Override
    public void sync() {
        ModComponents.SPELL_DATA.sync(this.player);
    }

    @Override
    public void readFromNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup lookup) {
        unlockedSpells.clear();
        NbtList list = nbt.getListOrEmpty("UnlockedSpells");
        for (int i = 0; i < list.size(); i++) {
            Optional<String> spellIdOpt = list.getString(i);
            spellIdOpt.ifPresent(unlockedSpells::add);  // Add the spell ID only if present
        }
    }

    @Override
    public void writeToNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup lookup) {
        NbtList list = new NbtList();
        for (String spell : unlockedSpells) {
            list.add(NbtString.of(spell)); // wrap string correctly
        }
        nbt.put("UnlockedSpells", list);
    }
}
