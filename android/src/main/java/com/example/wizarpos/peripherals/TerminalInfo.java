package com.example.wizarpos.peripherals;

import com.cloudpos.TerminalSpec;
import com.cloudpos.DeviceException;
import com.cloudpos.POSTerminal;
import android.content.Context;

public class TerminalInfo {
    private Context context;
    private TerminalSpec device = null;

    public String serialNumberPos(){
        if (device == null) {
            device = (TerminalSpec) POSTerminal.getInstance(context)
                    .getTerminalSpec();
        }
        try {
            return device.getSerialNumber();
        } catch (Exception e) {

            return "";
        }

    }
}
