package lemon_juice.better_angel_ring.creativetab;

import lemon_juice.better_angel_ring.BetterAngelRing;
import lemon_juice.better_angel_ring.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTab {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BetterAngelRing.MOD_ID);

    public static final RegistryObject<CreativeModeTab> BETTER_ANGEL_RING_TAB = CREATIVE_MODE_TABS.register("better_angel_ring", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.better_angel_ring"))
            .icon(() -> new ItemStack(ModItems.ANGEL_RING.get()))
            .build());

    public static void registerTabs(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == BETTER_ANGEL_RING_TAB.get()) {

            event.accept(ModItems.ANGEL_RING.get());
            event.accept(ModItems.RING.get());
        }
    }

    /******************************** Registry ********************************/
    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
