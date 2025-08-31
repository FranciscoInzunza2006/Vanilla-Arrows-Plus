package rabiosa_studios.vanilla_arrows_plus.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;
import rabiosa_studios.vanilla_arrows_plus.item.custom.CustomArrowItem;

import java.util.List;

@Mixin(BowItem.class)
public abstract class BowItemMixin {


    @ModifyArg(method = "onStoppedUsing", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/BowItem;getPullProgress(I)F"))
    private int applyArrowChargeTime(int use_ticks, @Local(ordinal = 1) ItemStack arrow_stack, @Local(argsOnly = true)LivingEntity user) {
        if (arrow_stack.getItem() instanceof CustomArrowItem custom_arrow)
            return (int) (use_ticks / custom_arrow.getPullTime(user));

        return use_ticks;
    }
}
