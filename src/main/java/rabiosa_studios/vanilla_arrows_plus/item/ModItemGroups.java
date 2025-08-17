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

    }

    public static void registerItemGroups() {
        Registry.register(Registries.ITEM_GROUP, MOD_ITEM_GROUP_KEY, MOD_ITEM_GROUP);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItemGroups::registerEquipment);
        ItemGroupEvents.modifyEntriesEvent(MOD_ITEM_GROUP_KEY).register(ModItemGroups::registerEquipment);
    }
}
