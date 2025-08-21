package rabiosa_studios.vanilla_arrows_plus.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import rabiosa_studios.vanilla_arrows_plus.item.custom.CustomArrowItem;

@Mixin(HeldItemRenderer.class)
public abstract class HeldItemRendererMixin {
    @WrapOperation(method = "renderFirstPersonItem",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/util/math/MatrixStack;translate(FFF)V", ordinal = 6))
    private void shakeBowBasedOnArrowDivergence (MatrixStack instance, float x, float y, float z, Operation<Void> original,
                                                 @Local(argsOnly = true) AbstractClientPlayerEntity player,
                                                 @Local(argsOnly = true) ItemStack bow) {
        float m = 1;
        if (player.getProjectileType(bow).getItem() instanceof CustomArrowItem arrow) {
            m = arrow.divergence;
        }
        original.call(instance, x, y*m, z);
    }
}
