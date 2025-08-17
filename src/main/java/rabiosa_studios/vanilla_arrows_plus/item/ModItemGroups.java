package rabiosa_studios.vanilla_arrows_plus.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import rabiosa_studios.vanilla_arrows_plus.VanillaArrowsPlus;

public class ModItemGroups {
    public static final RegistryKey<ItemGroup> MOD_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(VanillaArrowsPlus.MOD_ID, "item_group"));
    public static final ItemGroup MOD_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(Items.FLETCHING_TABLE))
            .displayName(Text.translatable("itemGroup.vanilla_arrows_plus"))
            .build();

    private static void registerEquipment (FabricItemGroupEntries item_group) {
        item_group.add(ModItems.AERIAL_ARROW);
        item_group.add(ModItems.AMETHYST_ARROW);
        item_group.add(ModItems.BLAZING_ARROW);
        item_group.add(ModItems.COPPER_ARROW);
        item_group.add(ModItems.CHARGED_COPPER_ARROW);
        item_group.add(ModItems.ECHO_ARROW);
        item_group.add(ModItems.GOLD_ARROW);
        item_group.add(ModItems.HONEY_ARROW);
        item_group.add(ModItems.IRON_ARROW);
        item_group.add(ModItems.PRISMARINE_ARROW);
        item_group.add(ModItems.REDSTONE_ARROW);
        item_group.add(ModItems.SLIME_ARROW);
        item_group.add(ModItems.SPECTRAL_ARROW);
    }

    private static void registerIngredients (FabricItemGroupEntries item_group) {
        item_group.add(ModItems.VIBRATING_DUST);
        item_group.add(ModItems.WARDEN_ANTENNAE);
    }

    public static void registerItemGroups() {
        Registry.register(Registries.ITEM_GROUP, MOD_ITEM_GROUP_KEY, MOD_ITEM_GROUP);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItemGroups::registerEquipment);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItemGroups::registerIngredients);

        ItemGroupEvents.modifyEntriesEvent(MOD_ITEM_GROUP_KEY).register(ModItemGroups::registerEquipment);
        ItemGroupEvents.modifyEntriesEvent(MOD_ITEM_GROUP_KEY).register(ModItemGroups::registerIngredients);

    }
}
