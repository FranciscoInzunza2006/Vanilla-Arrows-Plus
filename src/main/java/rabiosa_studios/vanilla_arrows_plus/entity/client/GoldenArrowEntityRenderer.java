package rabiosa_studios.vanilla_arrows_plus.entity.client;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.client.render.entity.state.ProjectileEntityRenderState;
import net.minecraft.util.Identifier;
import rabiosa_studios.vanilla_arrows_plus.VanillaArrowsPlus;
import rabiosa_studios.vanilla_arrows_plus.entity.custom.GoldenArrowEntity;

public class GoldenArrowEntityRenderer extends ProjectileEntityRenderer<GoldenArrowEntity, ProjectileEntityRenderState> {
    public static final Identifier TEXTURE = Identifier.of(VanillaArrowsPlus.MOD_ID, "textures/entity/projectiles/golden_arrow.png");

    public GoldenArrowEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    protected Identifier getTexture(ProjectileEntityRenderState state) {
        return TEXTURE;
    }

    public ProjectileEntityRenderState createRenderState() {
        return new ProjectileEntityRenderState();
    }
}
