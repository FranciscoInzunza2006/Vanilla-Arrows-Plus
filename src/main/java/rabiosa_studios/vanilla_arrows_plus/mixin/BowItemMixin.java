package rabiosa_studios.vanilla_arrows_plus.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import rabiosa_studios.vanilla_arrows_plus.VanillaArrowsPlus;
import rabiosa_studios.vanilla_arrows_plus.item.custom.CustomArrowItem;

import java.util.List;

@Mixin(BowItem.class)
public abstract class BowItemMixin {
    @WrapOperation(
            method = "onStoppedUsing",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/item/BowItem;shootAll(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/util/Hand;Lnet/minecraft/item/ItemStack;Ljava/util/List;FFZLnet/minecraft/entity/LivingEntity;)V")
    )

    private void customArrowShoot(BowItem instance,
                                  ServerWorld server_world,
                                  LivingEntity shooter,
                                  Hand hand,
                                  ItemStack stack,
                                  List<ItemStack> projectiles,
                                  float speed,
                                  float divergence,
                                  boolean critical,
                                  LivingEntity target,
                                  Operation<Void> original,

                                  @Local(ordinal = 1) int bow_use_time) {
        Item projectile = projectiles.getFirst().getItem();
        if (projectile instanceof CustomArrowItem arrow) {
            float bow_charge = BowItem.getPullProgress((int) (bow_use_time / arrow.charge_time));

            VanillaArrowsPlus.LOGGER.info("-----------------------------------------");
            VanillaArrowsPlus.LOGGER.info("Bow charge: {}", bow_charge);
            VanillaArrowsPlus.LOGGER.info("Arrow launch speed: {}", bow_charge * arrow.speed);

            original.call(instance, server_world, shooter, hand, stack, projectiles,
                    bow_charge * arrow.speed,
                    arrow.divergence,
                    critical, target);
        } else {
            original.call(instance, server_world, shooter, hand, stack, projectiles, speed, divergence, critical, target);
        }
    }
}
