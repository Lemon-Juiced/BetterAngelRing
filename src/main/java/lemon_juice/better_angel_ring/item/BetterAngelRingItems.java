package lemon_juice.better_angel_ring.item;

import lemon_juice.better_angel_ring.BetterAngelRing;
import lemon_juice.better_angel_ring.item.custom.AngelRingItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BetterAngelRingItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BetterAngelRing.MOD_ID);

    public static final DeferredItem<Item> ANGEL_RING = ITEMS.register("angel_ring", () -> new AngelRingItem(new Item.Properties()));
    public static final DeferredItem<Item> RING = ITEMS.register("ring", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
