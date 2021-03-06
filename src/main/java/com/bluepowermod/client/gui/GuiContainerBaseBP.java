package com.bluepowermod.client.gui;

import com.bluepowermod.client.gui.widget.WidgetTabItemLister;
import com.bluepowermod.reference.Refs;
import com.bluepowermod.tile.TileMachineBase;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class GuiContainerBaseBP<T extends Container> extends GuiContainerBase<T> {

    public GuiContainerBaseBP(T container, PlayerInventory playerInventory, ITextComponent title, ResourceLocation resloc){
        super(container, playerInventory, title, resloc);
    }

    @Override
    public void init() {

        super.init();
        lastLeftStat = lastRightStat = null;

        if (inventory instanceof TileMachineBase) {
            WidgetTabItemLister backlogTab = new WidgetTabItemLister(this, "gui.bluepower:tab.stuffed", Refs.MODID
                    + ":textures/gui/widgets/gui_stuffed.png", guiLeft + xSize, guiTop + 5, 0xFFc13d40, null, false);
            lastRightStat = backlogTab;
            backlogTab.setItems(((TileMachineBase) inventory).getBacklog());
            addWidget(backlogTab);
        }

        //TODO: Widgets currently conflicting with progress GUI
        if(container.getType() != BPContainerType.ALLOY_FURNACE
                && container.getType() != BPContainerType.BLULECTRIC_ALLOY_FURNACE
                && container.getType() != BPContainerType.BLULECTRIC_FURNACE
                && container.getType() != BPContainerType.CANVAS_BAG
                && container.getType() != BPContainerType.SEEDBAG) {
            String unlocalizedInfo = title.getString() + ".info";
            addAnimatedStat("gui.bluepower:tab.info", Refs.MODID + ":textures/gui/widgets/gui_info.png", 0xFF8888FF, isInfoStatLeftSided()).setText(
                    unlocalizedInfo);
        }

    }

}
