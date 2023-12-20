package lemon_juice.better_angel_ring.creativetab;

import lemon_juice.better_angel_ring.BetterAngelRing;
import lemon_juice.better_angel_ring.item.BetterAngelRingItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BetterAngelRingCreativeTab {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BetterAngelRing.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BETTER_ANGEL_RING_TAB = CREATIVE_MODE_TABS.register("better_angel_ring", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.better_angel_ring"))
            .icon(() -> new ItemStack(BetterAngelRingItems.ANGEL_RING.get()))
            .build());

    public static void registerTabs(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == BETTER_ANGEL_RING_TAB.get()) {

            event.accept(BetterAngelRingItems.ANGEL_RING.get());
            event.accept(BetterAngelRingItems.RING.get());
        }
    }

    /******************************** Registry ********************************/
    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
