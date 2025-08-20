package rabiosa_studios.vanilla_arrows_plus.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import rabiosa_studios.vanilla_arrows_plus.VanillaArrowsPlus;
import rabiosa_studios.vanilla_arrows_plus.entity.custom.IronArrowEntity;

import java.util.function.Function;

public class ModEntities {
//    private static final Regist
//
//    public static final EntityType<ArrowEntity> ARROW = register(
//            "arrow",
//            EntityType.Builder.<ArrowEntity>create(IronArrowEntity::new, SpawnGroup.MISC)
//                    .dropsNothing()
//                    .dimensions(0.5F, 0.5F)
//                    .eyeHeight(0.13F);
//
//    private static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
//        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(VanillaArrowsPlus.MOD_ID, name));
//        Item item = itemFactory.apply(settings.registryKey(itemKey));
//        Registry.register(Registries.ITEM, itemKey, item);
//
//        return item;
//    }

    public static void registerModEntities() {

    }
}
