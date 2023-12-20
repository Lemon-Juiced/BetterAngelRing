package lemon_juice.better_angel_ring;

import lemon_juice.better_angel_ring.creativetab.BetterAngelRingCreativeTab;
import lemon_juice.better_angel_ring.item.BetterAngelRingItems;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.InterModComms;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.event.lifecycle.InterModEnqueueEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import top.theillusivec4.curios.api.SlotTypeMessage;

@Mod(BetterAngelRing.MOD_ID)
public class BetterAngelRing {
    public static final String MOD_ID = "better_angel_ring";

    public BetterAngelRing(IEventBus modEventBus) {
        modEventBus.addListener(this::commonSetup);

        // Register Items & Blocks
        BetterAngelRingItems.register(modEventBus);

        // Register Creative Tab
        BetterAngelRingCreativeTab.register(modEventBus);
        modEventBus.addListener(BetterAngelRingCreativeTab::registerTabs);

        // Registers enqueueIMC (Curios)
        modEventBus.addListener(this::enqueueIMC);

        NeoForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {}

    //InterModQueue For Curios
    private void enqueueIMC(InterModEnqueueEvent event) {
        // Creates 1 "angel_ring" Slots
        InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE, () -> new SlotTypeMessage.Builder("angel_ring").icon(new ResourceLocation(BetterAngelRing.MOD_ID, "slot/empty_angel_ring_slot")).build());
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {}

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {}
    }
}
