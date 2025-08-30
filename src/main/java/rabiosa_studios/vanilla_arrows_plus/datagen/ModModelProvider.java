package rabiosa_studios.vanilla_arrows_plus.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;
import rabiosa_studios.vanilla_arrows_plus.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.AERIAL_ARROW, Models.GENERATED);
        itemModelGenerator.register(ModItems.CLUSTER_ARROW, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLAZING_ARROW, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_ARROW, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHARGED_COPPER_ARROW, Models.GENERATED);
        itemModelGenerator.register(ModItems.ECHO_ARROW, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOLDEN_ARROW, Models.GENERATED);
        itemModelGenerator.register(ModItems.HONEY_ARROW, Models.GENERATED);
        itemModelGenerator.register(ModItems.IRON_ARROW, Models.GENERATED);
        itemModelGenerator.register(ModItems.PRISMARINE_ARROW, Models.GENERATED);
        itemModelGenerator.register(ModItems.REDSTONE_ARROW, Models.GENERATED);
        itemModelGenerator.register(ModItems.SLIME_ARROW, Models.GENERATED);

        itemModelGenerator.register(ModItems.VIBRATING_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.WARDEN_ANTENNAE, Models.GENERATED);
    }
}
