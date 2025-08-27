package rabiosa_studios.vanilla_arrows_plus.mixin;

import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import rabiosa_studios.vanilla_arrows_plus.item.custom.CustomArrowItem;

@Mixin(AbstractClientPlayerEntity.class)
public abstract class AbstractClientPlayerEntityMixin {
    @ModifyArg(method = "getFovMultiplier", at = @At(value = "INVOKE", target = "Ljava/lang/Math;min(FF)F"), index = 0)
    private float applyArrowChargeTimeFovVisual(float used_time) {
        AbstractClientPlayerEntity thisObject = (AbstractClientPlayerEntity) (Object) this;
        if (thisObject.getProjectileType(Items.BOW.getDefaultStack()).getItem() instanceof CustomArrowItem arrow) {
            return used_time / arrow.charge_time;
        }

        return used_time;
    }
}
