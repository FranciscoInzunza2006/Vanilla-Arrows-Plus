package rabiosa_studios.vanilla_arrows_plus.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import rabiosa_studios.vanilla_arrows_plus.VanillaArrowsPlus;
import rabiosa_studios.vanilla_arrows_plus.entity.custom.ClusterArrowEntity;
import rabiosa_studios.vanilla_arrows_plus.entity.custom.GoldArrowEntity;
import rabiosa_studios.vanilla_arrows_plus.entity.custom.IronArrowEntity;
import rabiosa_studios.vanilla_arrows_plus.entity.custom.PrismarineArrowEntity;

public class ModEntities {
    public static final EntityType<GoldArrowEntity> GOLD_ARROW = register(
            "gold_arrow",
            EntityType.Builder.<GoldArrowEntity>create(GoldArrowEntity::new, SpawnGroup.MISC)
                    .dropsNothing()
                    .dimensions(0.5F, 0.5F)
                    .eyeHeight(0.13F)
                    .maxTrackingRange(4)
                    .trackingTickInterval(20)
    );
    public static final EntityType<IronArrowEntity> IRON_ARROW = register(
            "iron_arrow",
            EntityType.Builder.<IronArrowEntity>create(IronArrowEntity::new, SpawnGroup.MISC)
                    .dropsNothing()
                    .dimensions(0.5F, 0.5F)
                    .eyeHeight(0.13F)
                    .maxTrackingRange(4)
                    .trackingTickInterval(20)
    );

    public static final EntityType<PrismarineArrowEntity> PRISMARINE_ARROW = register(
            "prismarine_arrow",
            EntityType.Builder.<PrismarineArrowEntity>create(PrismarineArrowEntity::new, SpawnGroup.MISC)
                    .dropsNothing()
                    .dimensions(0.5F, 0.5F)
                    .eyeHeight(0.13F)
                    .maxTrackingRange(4)
                    .trackingTickInterval(20)
    );

    public static final EntityType<ClusterArrowEntity> CLUSTER_ARROW = register(
            "cluster_arrow",
            EntityType.Builder.<ClusterArrowEntity>create(ClusterArrowEntity::new, SpawnGroup.MISC)
                    .dropsNothing()
                    .dimensions(0.5F, 0.5F)
                    .eyeHeight(0.13F)
                    .maxTrackingRange(4)
                    .trackingTickInterval(20)
    );

    private static <T extends Entity> EntityType<T> register(RegistryKey<EntityType<?>> key, EntityType.Builder<T> type) {
        return Registry.register(Registries.ENTITY_TYPE, key, type.build(key));
    }

    private static <T extends Entity> EntityType<T> register(String id, EntityType.Builder<T> type) {
        return register(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(VanillaArrowsPlus.MOD_ID, id)), type);
    }

    public static void registerModEntities() {

    }
}
