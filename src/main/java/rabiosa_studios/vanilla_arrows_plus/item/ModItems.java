package rabiosa_studios.vanilla_arrows_plus.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import rabiosa_studios.vanilla_arrows_plus.VanillaArrowsPlus;

import java.util.function.Function;

public class ModItems {
    public static final Item AERIAL_ARROW = register("aerial_arrow");
    public static final Item BLAZING_ARROW = register("blazing_arrow");
    public static final Item COPPER_ARROW = register("copper_arrow");
    public static final Item GOLD_ARROW = register("gold_arrow");
    public static final Item HONEY_ARROW = register("honey_arrow");
    public static final Item IRON_ARROW = register("iron_arrow");
    public static final Item PRISM_ARROW = register("prism_arrow");
    public static final Item REDSTONE_ARROW = register("redstone_arrow");
    public static final Item SLIME_ARROW = register("slime_arrow");
    public static final Item SPECTRAL_ARROW = register("spectral_arrow");

    // TODO: Add Echo arrow

    //region Register Functions
    public static Item register(String name) {
        return register(name, new Item.Settings());
    }

    public static Item register(String name, Item.Settings settings) {
        return register(name, Item::new, settings);
    }

    public static Item register(String name, Function<Item.Settings, Item> itemFactory) {
        return register(name, itemFactory, new Item.Settings());
    }

    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(VanillaArrowsPlus.MOD_ID, name));
        Item item = itemFactory.apply(settings.registryKey(itemKey));
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }

    public static void registerItems() {
    }
    //endregion
}
