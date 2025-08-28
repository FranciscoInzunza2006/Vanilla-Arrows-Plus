package rabiosa_studios.vanilla_arrows_plus.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.item.Items;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import rabiosa_studios.vanilla_arrows_plus.item.custom.CustomArrowItem;

@Mixin(HeldItemRenderer.class)
public abstract class HeldItemRendererMixin {
    @ModifyArg(method = "renderFirstPersonItem",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/util/math/MatrixStack;translate(FFF)V", ordinal = 6),
            index = 1)
    private float shakeBowBasedOnArrowDivergence(float y_scale, @Local(argsOnly = true) @NotNull AbstractClientPlayerEntity player) {
        return y_scale * (player.getProjectileType(Items.BOW.getDefaultStack()).getItem() instanceof CustomArrowItem arrow ? arrow.getDivergence() : 1.0f);
    }

    @ModifyConstant(method = "renderFirstPersonItem", constant = @Constant(floatValue = 20.0F))
    private float scaleBowBasedOnChargeTime(float tick_rate_idk, @Local(argsOnly = true) @NotNull AbstractClientPlayerEntity player) {
        return 20.0f * (player.getProjectileType(Items.BOW.getDefaultStack()).getItem() instanceof CustomArrowItem arrow ? arrow.getChargeTime() : 1.0f);
    }
}
