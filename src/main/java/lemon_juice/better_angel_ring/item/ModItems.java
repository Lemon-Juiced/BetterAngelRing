package lemon_juice.better_angel_ring.item;

import lemon_juice.better_angel_ring.BetterAngelRing;
import lemon_juice.better_angel_ring.item.custom.AngelRingItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BetterAngelRing.MOD_ID);

    public static final RegistryObject<Item> ANGEL_RING = ITEMS.register("angel_ring", () -> new AngelRingItem(new Item.Properties()));
    public static final RegistryObject<Item> RING = ITEMS.register("ring", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
