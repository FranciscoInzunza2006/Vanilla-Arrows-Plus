package rabiosa_studios.vanilla_arrows_plus.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import rabiosa_studios.vanilla_arrows_plus.VanillaArrowsPlus;

public class ModEffects {
    public static final RegistryEntry<StatusEffect> HONEYED = register("honeyed", new HoneyedEffect());
    public static final RegistryEntry<StatusEffect> REDSTONED = register("redstoned", new RedstonedEffect());

    private static RegistryEntry<StatusEffect> register (String name, StatusEffect status_effect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(VanillaArrowsPlus.MOD_ID, name), status_effect);
    }

    public static void registerEffects() {

    }
}
