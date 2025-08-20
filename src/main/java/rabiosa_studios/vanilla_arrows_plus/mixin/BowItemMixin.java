package rabiosa_studios.vanilla_arrows_plus.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
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

@Debug(export = true)
@Mixin(BowItem.class)
public abstract class BowItemMixin {
    @WrapOperation(method = "onStoppedUsing", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/BowItem;shootAll(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/util/Hand;Lnet/minecraft/item/ItemStack;Ljava/util/List;FFZLnet/minecraft/entity/LivingEntity;)V"))
    private void customArrowShoot(BowItem instance, ServerWorld server_world, LivingEntity shooter, Hand hand, ItemStack stack, List<ItemStack> projectiles, float speed, float divergence, boolean critical, LivingEntity target, Operation<Void> original) {
        Item projectile = projectiles.getFirst().getItem();
        if (projectile instanceof CustomArrowItem arrow) {
            // Remove multipliers
            speed /= 3.0f;

            speed *= arrow.speed;
            divergence *= arrow.divergence;

            VanillaArrowsPlus.LOGGER.info("Speed: %f",(Object) speed);
            VanillaArrowsPlus.LOGGER.info("Divergence: %f°", (Object) divergence);

            original.call(instance, server_world, shooter, hand, stack, projectiles, speed, divergence, critical, target);
        } else {
            original.call(instance, server_world, shooter, hand, stack, projectiles, speed, divergence, critical, target);
        }
    }
}
