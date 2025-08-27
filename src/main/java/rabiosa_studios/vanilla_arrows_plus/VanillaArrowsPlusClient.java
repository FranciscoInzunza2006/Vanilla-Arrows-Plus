package rabiosa_studios.vanilla_arrows_plus;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import rabiosa_studios.vanilla_arrows_plus.entity.ModEntities;
import rabiosa_studios.vanilla_arrows_plus.entity.client.GoldArrowEntityRenderer;
import rabiosa_studios.vanilla_arrows_plus.entity.client.IronArrowEntityRenderer;

public class VanillaArrowsPlusClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.IRON_ARROW, IronArrowEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.GOLD_ARROW, GoldArrowEntityRenderer::new);
    }
}
