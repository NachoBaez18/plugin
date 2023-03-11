package com.example.wizarpos.peripherals;
import java.util.Map;

import android.os.Bundle;
import android.os.Handler;

import com.cloudpos.DeviceException;
import com.cloudpos.OperationListener;
import com.cloudpos.OperationResult;
import com.cloudpos.POSTerminal;
import com.cloudpos.TimeConstants;
import com.cloudpos.card.Card;
import com.cloudpos.card.SLE4442Card;
import com.cloudpos.smartcardreader.SmartCardReaderDevice;

import com.cloudpos.rfcardreader.RFCardReaderDevice;
import com.cloudpos.rfcardreader.RFCardReaderOperationResult;
import android.content.Context;
import android.os.Message;

import androidx.annotation.NonNull;

import com.example.wizarpos.util.StringUtility;

public class SmartCardAction1 {

    private SmartCardReaderDevice device1 = null;
    private RFCardReaderDevice device = null;
    private Card rfCard;
    private Card psamCard;
    private Context mContext;
    Thread readThread;
    

    public String open() {
        if (device == null) {
            device = (RFCardReaderDevice) POSTerminal.getInstance(mContext)
                    .getDevice("cloudpos.device.rfcardreader");
        }
        try {
            device.open();
            return "NFC Abierto";
            // sendSuccessLog(mContext.getString(R.string.operation_succeed));
        } catch (DeviceException e) {
            e.printStackTrace();
            return "Error al abrir el nfc " + e.getCode();
            // sendFailedLog(mContext.getString(R.string.operation_failed));
        }
    }

    public String waitForCardPresent() {
        try {
            OperationResult operationResult = device.waitForCardPresent(TimeConstants.FOREVER);
            if (operationResult.getResultCode() == OperationResult.SUCCESS) {
                rfCard = ((RFCardReaderOperationResult) operationResult).getCard();
                return this.getID();
            } else {
                return null;
            }
        } catch (DeviceException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String listenForCardPresent() {
        final Message msg = new Message();
        final Bundle bundle = new Bundle();
        final Handler mHandler = new Handler();
        try {
            OperationListener listener = new OperationListener() {

                @Override
                public void handleResult(OperationResult arg0) {
                    if (arg0.getResultCode() == OperationResult.SUCCESS) {
                        rfCard = ((RFCardReaderOperationResult) arg0).getCard();
                        bundle.putString("id", getID());
                        bundle.putString("id2", "Hola");
                        msg.setData(bundle);
                        mHandler.sendMessage(msg);

                        // handler.obtainMessage(2, "CARD Leido").sendToTarget();
                    } else {
                        // handler.obtainMessage(3, "\t\t" + "Fail log nfc" + "\n")
                                    //    .sendToTarget();
                    }
                }
            };
            device.listenForCardPresent(listener, TimeConstants.FOREVER);
//            readThread = new SmartCardAction1().ReadThread();
//            readThread.start();
//            int retries = 0;
//            while(rfCard == null && retries < 10) {
//                // waiting to nfc is active
//                retries++;
//            }
//            if (rfCard == null) {
//                return "Null";
//            }
//            return "NFC success";

        } catch (DeviceException e) {
            e.printStackTrace();
        }
        return "NFC LISTEN";
    }
    public String waitForCardAbsent() {
        try {
            OperationResult operationResult = device.waitForCardAbsent(TimeConstants.FOREVER);
            if (operationResult.getResultCode() == OperationResult.SUCCESS) {
                rfCard = null;
                return "Tarjeta sacada";
            } else {
                return "Tarjeta no sacada1";
            }
        } catch (DeviceException e) {
            e.printStackTrace();
            return "Tarjeta no sacada";
        }
    }
//    private class ReadThread extends Thread {
//        @Override
//        public void run() {
//            rfCard = null;
//            try {
////                rfCard = nfc.activate(50); // 10
//            } catch (DeviceException e) {
//                e.printStackTrace();
//            }
//        }
//    }



    public String getID() {
        
        try {
            byte[] cardID;
            if(rfCard == null){
               return "CardID vacio"; 
            }else{
               cardID = rfCard.getID();
               return " Card ID = "
                       + StringUtility.byteArray2String(cardID);
            }
            // sendSuccessLog(mContext.getString(R.string.operation_succeed) + " Card ID = "
            //         + StringUtility.byteArray2String(cardID));
        } catch (DeviceException e) {
            e.printStackTrace();
            return "Error al leer el ID";
            // sendFailedLog(mContext.getString(R.string.operation_failed));
        }
    }

    public void getProtocol() {
        try {
            int protocol = rfCard.getProtocol();
            // sendSuccessLog(mContext.getString(R.string.operation_succeed) + " Protocol = "
            //         + protocol);
        } catch (DeviceException e) {
            e.printStackTrace();
            // sendFailedLog(mContext.getString(R.string.operation_failed));
        }
    }

    public void getCardStatus() {
        try {
            int cardStatus = rfCard.getCardStatus();
            // sendSuccessLog(mContext.getString(R.string.operation_succeed) + " Card Status = "
                    // + cardStatus);
        } catch (DeviceException e) {
            e.printStackTrace();
            // sendFailedLog(mContext.getString(R.string.operation_failed));
        }
    }

    // public void verify() {
    //     byte[] key = new byte[] {
    //             (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF,
    //             (byte) 0xFF
    //     };
    //     try {

    //         boolean verifyResult = ((SLE4442Card) rfCard).verify(key);
    //         sendSuccessLog(mContext.getString(R.string.operation_succeed));
    //     } catch (DeviceException e) {
    //         e.printStackTrace();
    //         sendFailedLog(mContext.getString(R.string.operation_failed));
    //     }
    // }

    // public void read() {
    //     try {
    //         byte[] result = ((SLE4442Card) rfCard).read(area, address, length);
    //         sendSuccessLog(mContext.getString(R.string.operation_succeed) + " (" + area
    //                 + ", " + address + ") memory data: " + StringUtility.byteArray2String(result));
    //     } catch (DeviceException e) {
    //         e.printStackTrace();
    //         sendFailedLog(mContext.getString(R.string.operation_failed));
    //     }
    // }

    // public void write() {
    //     byte[] arryData = Common.createMasterKey(10);// 随机创造10个字节的数组
    //     try {
    //         ((SLE4442Card) rfCard).write(area, address, arryData);
    //         sendSuccessLog(mContext.getString(R.string.operation_succeed));
    //     } catch (DeviceException e) {
    //         e.printStackTrace();
    //         sendFailedLog(mContext.getString(R.string.operation_failed));
    //     }
    // }

    // public void disconnect() {
    //     try {
    //         sendNormalLog(mContext.getString(R.string.rfcard_remove_card));
    //         ((CPUCard) rfCard).disconnect();
    //         sendSuccessLog(mContext.getString(R.string.operation_succeed));
    //     } catch (DeviceException e) {
    //         e.printStackTrace();
    //         sendFailedLog(mContext.getString(R.string.operation_failed));
    //     }
    // }

    public String cancelRequest() {
        try {
            device.cancelRequest();
            return "Cancelado";
        } catch (DeviceException e) {
            e.printStackTrace();
            return "Error al cancelar el request";
        }
    }

    public String close() {
        try {
            rfCard = null;
            if(device != null){
                device.close();
            }else {
                return "NFC null";
            }
            return "NFC Close";
            // sendSuccessLog(mContext.getString(R.string.operation_succeed));
        } catch (DeviceException e) {
            e.printStackTrace();
            return "FAIL NFC Close";
            // sendFailedLog(mContext.getString(R.string.operation_failed));
        }
    }

}
