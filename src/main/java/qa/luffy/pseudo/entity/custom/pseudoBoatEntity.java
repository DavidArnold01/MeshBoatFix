package qa.luffy.pseudo.entity.custom;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import qa.luffy.pseudo.entity.pseudoEntityTypes;
import qa.luffy.pseudo.item.PseudoItems;

public class pseudoBoatEntity extends Boat {
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE =
            SynchedEntityData.defineId(pseudoBoatEntity.class, EntityDataSerializers.INT);

    public pseudoBoatEntity(EntityType<? extends pseudoBoatEntity> entityType, Level level) {
        super(entityType, level);
        this.blocksBuilding = true;
    }

    public pseudoBoatEntity(Level worldIn, double x, double y, double z) {
        this(pseudoEntityTypes.BOAT_ENTITY.get(), worldIn);
        this.setPos(x, y, z);
        this.xo = x;
        this.yo = y;
        this.zo = z;
    }

    protected void addAdditionalSaveData(CompoundTag compound) {
        compound.putString("Type", this.getModBoatType().getName());
    }

    protected void readAdditionalSaveData(CompoundTag compound) {
        if (compound.contains("Type", 8)) {
            this.setBoatType(pseudoBoatEntity.Type.byName(compound.getString("Type")));
        }
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_ID_TYPE, Type.MESH_BOAT.ordinal());
    }

    @Override
    public Item getDropItem() {
        switch (this.getModBoatType()) {
            case MESH_BOAT:
                return PseudoItems.MESH_BOAT.get();
            default:
                return Items.OAK_BOAT;
        }
    }

    public void setBoatType(pseudoBoatEntity.Type boatType) {
        this.entityData.set(DATA_ID_TYPE, boatType.ordinal());
    }

    public pseudoBoatEntity.Type getModBoatType() {
        return pseudoBoatEntity.Type.byId(this.entityData.get(DATA_ID_TYPE));
    }

    public enum Type {
        MESH_BOAT("mesh_boat");

        private final String name;
        Type(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public static pseudoBoatEntity.Type byId(int id) {
            pseudoBoatEntity.Type[] types = values();
            if (id < 0 || id >= types.length) {
                id = 0;
            }

            return types[id];
        }

        public static pseudoBoatEntity.Type byName(String nameIn) {
            pseudoBoatEntity.Type[] types = values();

            for (int i = 0; i < types.length; ++i) {
                if (types[i].getName().equals(nameIn)) {
                    return types[i];
                }
            }

            return types[0];
        }
    }
}