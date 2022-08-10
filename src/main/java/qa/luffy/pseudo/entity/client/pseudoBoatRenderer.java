package qa.luffy.pseudo.entity.client;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Pair;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;
import qa.luffy.pseudo.Pseudo;
import qa.luffy.pseudo.entity.custom.pseudoBoatEntity;

import java.util.Map;
import java.util.stream.Stream;

public class pseudoBoatRenderer extends BoatRenderer {
    private final Map<pseudoBoatEntity.Type, Pair<ResourceLocation, BoatModel>> boatResources;

    public pseudoBoatRenderer(EntityRendererProvider.Context context) {
        super(context, false);
        this.shadowRadius = 0.8F;
        this.boatResources = Stream.of(pseudoBoatEntity.Type.values()).collect(ImmutableMap.toImmutableMap((p_173938_) -> p_173938_,
                (type) -> Pair.of(new ResourceLocation(Pseudo.MODID,"textures/entity/boat/mesh_boat.png"),
                        new BoatModel(context.bakeLayer(
                                new ModelLayerLocation(new ResourceLocation("minecraft", "boat/oak"),"main")), false))));

    }

    @Override
    public ResourceLocation getTextureLocation(Boat pEntity) {
        if(pEntity instanceof pseudoBoatEntity modBoat) {
            return this.boatResources.get(modBoat.getModBoatType()).getFirst();
        }

        return new ResourceLocation("minecraft", "boat/oak");
    }

    public Pair<ResourceLocation, BoatModel> getModelWithLocation(Boat boat) {
        if(boat instanceof pseudoBoatEntity modBoat) {
            return this.boatResources.get(modBoat.getModBoatType());
        }

        return null;
    }
}