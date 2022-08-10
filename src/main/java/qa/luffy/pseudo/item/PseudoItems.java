package qa.luffy.pseudo.item;

import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import qa.luffy.init.PseudoTiers;
import qa.luffy.pseudo.Pseudo;
import qa.luffy.pseudo.PseudoCreativeTab;
import qa.luffy.pseudo.entity.custom.pseudoBoatEntity;

//test
public class PseudoItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Pseudo.MODID);

    public static final RegistryObject<Item> GRAPHITE = ITEMS.register("graphite", () -> new Item(new Item.Properties().tab(PseudoCreativeTab.PSEUDO_TAB)));
    public static final RegistryObject<Item> GRAPHENE_SHEET = ITEMS.register("graphene_sheet", () -> new Item(new Item.Properties().tab(PseudoCreativeTab.PSEUDO_TAB)));
    public static final RegistryObject<Item> GRAPHENE_MESH = ITEMS.register("graphene_mesh", () -> new Item(new Item.Properties().tab(PseudoCreativeTab.PSEUDO_TAB)));
    public static final RegistryObject<Item> IRON_GEAR = ITEMS.register("iron_gear", () -> new Item(new Item.Properties().tab(PseudoCreativeTab.PSEUDO_TAB)));
    public static final RegistryObject<Item> MESH_GEARBOX = ITEMS.register("mesh_gearbox", () -> new Item(new Item.Properties().tab(PseudoCreativeTab.PSEUDO_TAB)));
    public static final RegistryObject<Item> MESH_HARDENING = ITEMS.register("mesh_hardening", () -> new Item(new Item.Properties().tab(PseudoCreativeTab.PSEUDO_TAB)));
    public static final RegistryObject<Item> MOLE_MITTS = ITEMS.register("mole_mitts", () -> new DiggingMittsItem(PseudoTiers.MOLE, 0, 0f, new Item.Properties().tab(PseudoCreativeTab.PSEUDO_TAB)));
    public static final RegistryObject<Item> MESH_MITTS = ITEMS.register("mesh_mitts", () -> new DiggingMittsItem(PseudoTiers.MESH, 0, 0f, new Item.Properties().tab(PseudoCreativeTab.PSEUDO_TAB)));
    public static final RegistryObject<Item> ENDER_KNAPSACK = ITEMS.register("ender_knapsack", () -> new EnderKnapsackItem(new Item.Properties().tab(PseudoCreativeTab.PSEUDO_TAB)));
    public static final RegistryObject<Item> MESH_BOAT = ITEMS.register("cherry_blossom_boat", () -> new MeshBoatItem(new Item.Properties().tab(PseudoCreativeTab.PSEUDO_TAB), pseudoBoatEntity.Type.MESH_BOAT));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
