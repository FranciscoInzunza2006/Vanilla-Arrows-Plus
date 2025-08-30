package rabiosa_studios.vanilla_arrows_plus;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import rabiosa_studios.vanilla_arrows_plus.entity.ModEntities;
import rabiosa_studios.vanilla_arrows_plus.entity.client.ClusterArrowEntityRenderer;
import rabiosa_studios.vanilla_arrows_plus.entity.client.GoldenArrowEntityRenderer;
import rabiosa_studios.vanilla_arrows_plus.entity.client.IronArrowEntityRenderer;
import rabiosa_studios.vanilla_arrows_plus.entity.client.PrismarineArrowEntityRenderer;

public class VanillaArrowsPlusClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.IRON_ARROW, IronArrowEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.GOLDEN_ARROW, GoldenArrowEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.PRISMARINE_ARROW, PrismarineArrowEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.CLUSTER_ARROW, ClusterArrowEntityRenderer::new);
    }
}
