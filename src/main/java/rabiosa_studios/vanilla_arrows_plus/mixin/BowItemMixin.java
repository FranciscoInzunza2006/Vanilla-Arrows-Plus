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
    @ModifyArgs(method = "onStoppedUsing",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/item/BowItem;shootAll(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/util/Hand;Lnet/minecraft/item/ItemStack;Ljava/util/List;FFZLnet/minecraft/entity/LivingEntity;)V"))
    private void applyArrowSpeedAndDivergence(Args args) {
        final int PLAYER_ENTITY_INDEX = 1;
        final int PROJECTILES_INDEX = 4;
        final int BOW_CHARGE_INDEX = 5;
        final int DIVERGENCE_INDEX = 6;

        List<ItemStack> projectiles = args.get(PROJECTILES_INDEX);
        if (!(projectiles.getFirst().getItem() instanceof CustomArrowItem arrow)) {
            return;
        }

        final PlayerEntity player = args.get(PLAYER_ENTITY_INDEX);
        float bow_charge = (float) args.get(BOW_CHARGE_INDEX) / CustomArrowItem.VANILLA_SPEED;
        float divergence = args.get(DIVERGENCE_INDEX);

        args.set(BOW_CHARGE_INDEX, bow_charge * arrow.getSpeed(player));
        args.set(DIVERGENCE_INDEX, divergence * arrow.getDivergence());
    }

    @ModifyArg(method = "onStoppedUsing", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/BowItem;getPullProgress(I)F"))
    private int applyArrowChargeTime(int use_ticks, @Local(ordinal = 1) ItemStack arrow_stack, @Local(argsOnly = true)LivingEntity user) {
        if (arrow_stack.getItem() instanceof CustomArrowItem custom_arrow)
            return (int) (use_ticks / custom_arrow.getChargeTime(user));

        return use_ticks;
    }
}
