package qa.luffy.pseudo.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import qa.luffy.pseudo.Pseudo;
import qa.luffy.pseudo.entity.custom.pseudoBoatEntity;


public class pseudoEntityTypes {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Pseudo.MODID);

    public static final RegistryObject<EntityType<pseudoBoatEntity>> BOAT_ENTITY =
             ENTITY_TYPES.register("mesh_boat", () -> EntityType.Builder.<pseudoBoatEntity>of(pseudoBoatEntity::new,
                             MobCategory.MISC).fireImmune().sized(1.375F, 0.5625F)
                     .setCustomClientFactory((spawnEntity, world) -> new pseudoBoatEntity(world, 0, 0, 0))
                     .build("mesh_boat"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }

}
