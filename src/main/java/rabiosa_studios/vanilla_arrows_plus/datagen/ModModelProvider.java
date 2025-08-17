package rabiosa_studios.vanilla_arrows_plus.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
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
        itemModelGenerator.register(ModItems.AERIAL_ARROW);
        itemModelGenerator.register(ModItems.BLAZING_ARROW);
        itemModelGenerator.register(ModItems.COPPER_ARROW);
        itemModelGenerator.register(ModItems.GOLD_ARROW);
        itemModelGenerator.register(ModItems.HONEY_ARROW);
        itemModelGenerator.register(ModItems.IRON_ARROW);
        itemModelGenerator.register(ModItems.PRISM_ARROW);
        itemModelGenerator.register(ModItems.REDSTONE_ARROW);
        itemModelGenerator.register(ModItems.SLIME_ARROW);
        itemModelGenerator.register(ModItems.SPECTRAL_ARROW);
    }
}
