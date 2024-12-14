package devcmb.petsplus.screen.block;

import devcmb.petsplus.screen.ModScreens;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

import java.util.ArrayList;
import java.util.List;

public class PetsManagerBlockScreenHandler extends ScreenHandler {
    private final Inventory inventory;
    private final Slot outputSlot;
    private final List<Slot> inputSlots = new ArrayList<>();


    public PetsManagerBlockScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(9));
    }

    public PetsManagerBlockScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(ModScreens.PETS_MANAGER_SCREEN_HANDLER, syncId);
        this.inventory = inventory;

        outputSlot = this.addSlot(new Slot(inventory, 8, 80, 63){
            @Override
            public boolean canInsert(ItemStack stack) {
                return false;
            }
        });


        inputSlots.addAll(List.of(
            this.addSlot(new Slot(inventory, 0, 80, 26)),
            this.addSlot(new Slot(inventory, 1, 106, 37)),
            this.addSlot(new Slot(inventory, 2, 117, 63)),
            this.addSlot(new Slot(inventory, 3, 106, 89)),
            this.addSlot(new Slot(inventory, 4, 80, 100)),
            this.addSlot(new Slot(inventory, 5, 54, 89)),
            this.addSlot(new Slot(inventory, 6, 43, 63)),
            this.addSlot(new Slot(inventory, 7, 54, 37))
        ));

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                this.addSlot(new Slot(playerInventory, col + row * 9 + 9, 8 + col * 18, 140 + row * 18));
            }
        }

        for (int col = 0; col < 9; col++) {
            this.addSlot(new Slot(playerInventory, col, 8 + col * 18, 198));
        }
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);

        if (slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();

            if (invSlot < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else {
                if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
                    return ItemStack.EMPTY;
                }
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }

        return newStack;
    }

    @Override
    public void onClosed(PlayerEntity player) {
        super.onClosed(player);
        for (Slot slot : inputSlots) {
            if (slot.hasStack()) {
                player.getInventory().offerOrDrop(slot.getStack());
                slot.setStack(ItemStack.EMPTY);
            }
        }
    }
}