package com.bluepowermod.api.bluestone;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import com.qmunity.lib.vec.Vec3i;

public class DummyBluestoneDevice implements IBluestoneDevice {

    private static List<DummyBluestoneDevice> devices = new ArrayList<DummyBluestoneDevice>();

    public static DummyBluestoneDevice getDeviceAt(World world, int x, int y, int z) {

        DummyBluestoneDevice device = null;
        Vec3i loc = new Vec3i(x, y, z, world);

        for (DummyBluestoneDevice d : devices) {
            if (d.location.equals(loc)) {
                device = d;
                break;
            }
        }

        if (device != null) {
            if (device.location.getBlock() != loc.getBlock() || device.location.getBlockMeta() != loc.getBlockMeta()
                    || device.location.getTileEntity() != loc.getTileEntity()) {
                devices.remove(device);
                devices.add(device = new DummyBluestoneDevice(loc.getWorld(), loc));
            }
        } else {
            devices.add(device = new DummyBluestoneDevice(loc.getWorld(), loc));
        }

        return device;
    }

    private Vec3i location;

    public DummyBluestoneDevice(World world, Vec3i location) {

        this.location = location.setWorld(world).getImmutableCopy();
    }

    public DummyBluestoneDevice(World world, int x, int y, int z) {

        this(world, new Vec3i(x, y, z));
    }

    public DummyBluestoneDevice() {

    }

    @Override
    public IBluestoneDevice getConnectedDevice(ForgeDirection side) {

        return null;
    }

    @Override
    public void onPowerUpdate(int network, int oldValue, int newValue) {

    }

    @Override
    public void listConnected(List<IBluestoneDevice> visited, BluestoneColor insulationColor, ForgeDirection from) {

    }

    @Override
    public boolean canConnect(BluestoneColor insulationColor, BluestoneColor bundleColor) {

        return insulationColor == BluestoneColor.NONE && bundleColor == BluestoneColor.INVALID;
    }

}
