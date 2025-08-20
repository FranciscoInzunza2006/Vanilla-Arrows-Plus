package rabiosa_studios.vanilla_arrows_plus.item;

import net.minecraft.item.ArrowItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import rabiosa_studios.vanilla_arrows_plus.VanillaArrowsPlus;
import rabiosa_studios.vanilla_arrows_plus.item.custom.CustomArrowItem;
import rabiosa_studios.vanilla_arrows_plus.item.custom.IronArrow;

import java.util.function.Function;

public class ModItems {
    public static final Item AERIAL_ARROW = register("aerial_arrow");
    public static final Item AMETHYST_ARROW = register("amethyst_arrow");
    public static final Item BLAZING_ARROW = register("blazing_arrow");
    public static final Item CHARGED_COPPER_ARROW = register("charged_copper_arrow");
    public static final Item COPPER_ARROW = register("copper_arrow");
    public static final Item ECHO_ARROW = register("echo_arrow");
    //public static final Item GOLD_ARROW = register("gold_arrow", settings -> new CustomArrowItem(settings, 2, 10, 0.1f));
    public static final Item HONEY_ARROW = register("honey_arrow");
    //public static final Item IRON_ARROW = register("iron_arrow", settings -> new CustomArrowItem(settings, 10.0, 2.5f, 5));
    public static final Item IRON_ARROW = register("iron_arrow", settings -> new IronArrow(settings, 10.0, 2.5f, 5));
    public static final Item PRISMARINE_ARROW = register("prismarine_arrow");
    public static final Item REDSTONE_ARROW = register("redstone_arrow");
    public static final Item SLIME_ARROW = register("slime_arrow");

    public static final Item VIBRATING_DUST = register("vibrating_dust");
    public static final Item WARDEN_ANTENNAE = register("warden_antennae");

    //region Register Functions
    private static Item register(String name) {
        return register(name, new Item.Settings());
    }

    private static Item register(String name, Item.Settings settings) {
        return register(name, Item::new, settings);
    }

    private static Item register(String name, Function<Item.Settings, Item> itemFactory) {
        return register(name, itemFactory, new Item.Settings());
    }

    private static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(VanillaArrowsPlus.MOD_ID, name));
        Item item = itemFactory.apply(settings.registryKey(itemKey));
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }

    public static void registerItems() {
    }
    //endregion
}
