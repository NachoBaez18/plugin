
package com.example.wizarpos.peripherals;

import java.util.Map;

import com.cloudpos.DeviceException;
import com.cloudpos.POSTerminal;
import com.cloudpos.led.LEDDevice;;
import android.content.Context;

public class LEDAction1 {

    private LEDDevice device = null;
    private Context mContext;

//     @Override
//     protected void doBefore() {
//         super.doBefore(param, callback);
        // if (device == null) {
        //     device = (LEDDevice) POSTerminal.getInstance(mContext)
        //             .getDevice("cloudpos.device.led");
        // }
//     }

    int logicalID = 2;

    public void open() {
        if (device == null) {
            device = (LEDDevice) POSTerminal.getInstance(mContext)
                    .getDevice("cloudpos.device.led");
        }
        try {
            device.open(logicalID);
            // sendSuccessLog(mContext.getString(R.string.operation_succeed));
        } catch (DeviceException e) {
            e.printStackTrace();
            // sendFailedLog(mContext.getString(R.string.operation_failed));
        }
    }

//     public void getLogicalID() {
//         try {
//             int logicalID = device.getLogicalID();
//             sendSuccessLog(mContext.getString(R.string.operation_succeed) + " Logical ID = "
//                     + logicalID);
//         } catch (DeviceException e) {
//             e.printStackTrace();
//             sendFailedLog(mContext.getString(R.string.operation_failed));
//         }
//     }

//     public void startBlink() {
//         try {
//             device.startBlink(100, 100, 10);
//             sendSuccessLog(mContext.getString(R.string.operation_succeed));
//         } catch (DeviceException e) {
//             e.printStackTrace();
//             sendFailedLog(mContext.getString(R.string.operation_failed));
//         }
//     }

//     public void cancelRequest() {
//         try {
//             device.cancelRequest();
//             sendSuccessLog(mContext.getString(R.string.operation_succeed));
//         } catch (DeviceException e) {
//             e.printStackTrace();
//             sendFailedLog(mContext.getString(R.string.operation_failed));
//         }
//     }

    public String cancelBlink() {
        try {
            device.cancelBlink();
            // device.close();
            return "Blink Cancelado";
            // sendSuccessLog(mContext.getString(R.string.operation_succeed));
        } catch (DeviceException e) {
            e.printStackTrace();
            // device.close();
            return "Error al cancelar el blink";
            // sendFailedLog(mContext.getString(R.string.operation_failed));
        }
    }

    public String blink() {
        try {
            // this.open();
            // sendSuccessLog("");
            device.blink(100, 100, 10);
            // device.close();
            return "Led encendido";
            // sendSuccessLog(mContext.getString(R.string.operation_succeed));
        } catch (DeviceException e) {
            e.printStackTrace();
            return "Led FAIL";
            // sendFailedLog(mContext.getString(R.string.operation_failed));
        }
    }

//     public void getStatus() {
//         try {
//             int status = device.getStatus();
//             sendSuccessLog(mContext.getString(R.string.operation_succeed) + " Status: "
//                     + (status == LEDDevice.STATUS_ON ? "ON" : "OFF"));
//         } catch (DeviceException e) {
//             e.printStackTrace();
//             sendFailedLog(mContext.getString(R.string.operation_failed));
//         }
//     }

//     public void turnOn() {
//         try {
//             device.turnOn();
//             sendSuccessLog(mContext.getString(R.string.operation_succeed));
//         } catch (DeviceException e) {
//             e.printStackTrace();
//             sendFailedLog(mContext.getString(R.string.operation_failed));
//         }
//     }

//     public void turnOff() {
//         try {
//             device.turnOff();
//             sendSuccessLog(mContext.getString(R.string.operation_succeed));
//         } catch (DeviceException e) {
//             e.printStackTrace();
//             sendFailedLog(mContext.getString(R.string.operation_failed));
//         }
//     }

    public void close() {
        try {
            device.close();
            // sendSuccessLog(mContext.getString(R.string.operation_succeed));
        } catch (DeviceException e) {
            e.printStackTrace();
            // sendFailedLog(mContext.getString(R.string.operation_failed));
        }
    }
}
