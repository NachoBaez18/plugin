package com.example.wizarpos.peripherals;

import com.cloudpos.printer.Format;
import com.cloudpos.printer.PrinterDevice;
import com.cloudpos.DeviceException;
import com.cloudpos.POSTerminal;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;

public class Printer {

    private Context context;
    private PrinterDevice device = null;
    
    // public void Printer() {
    //     if (device == null) {
    //         device = (PrinterDevice) POSTerminal.getInstance(context)
    //                 .getDevice("cloudpos.device.printer");
    //     }
    // }
    public String imprimirFactura() {
        if (device == null) {
            device = (PrinterDevice) POSTerminal.getInstance(context)
                    .getDevice("cloudpos.device.printer");
        }
        try {
            device.open();
            device.printText("\n\nTicket de billetaje electronico\n\n\n" +
                "MAS TARJETA" +
                "" +
                "LA SAMPEDRANA" +
                "RUC 80006065-2" +
                "------------------" +
                "Maria Auxiliadora 974 esq Rca Argentina" +
                "Asuncion" +
                "Call Center: 021 2381111" +
                "www.lasantaniana.com.py" +
                "50000045" +
                "OPERATOR" +
                "50000045" +
                "SCN:01" +
                "TUR:008004E000" +
                "IAD:07010103602002010A01000000000005DD79CB" +
                "TermCap:EOE1C8" +
                "CARD HOLDER SIGNATURE" +
                "" +
                "www.mastarjeta.net" +
                "" +
                "\n\n\n");
            device.close();
            return "Factura impresa correctamente";
        } catch (DeviceException e) {
            //TODO: handle exception
            e.printStackTrace();
            return "Error al imprimir la factura";
        }
    }

    public boolean estadoPapel(){
        try {
            
            if (device == null) {
                device = (PrinterDevice) POSTerminal.getInstance(context)
                        .getDevice("cloudpos.device.printer");
            }
            device.open();
            System.out.println(device.queryStatus());
            if (device.queryStatus() == device.STATUS_OUT_OF_PAPER) {
                device.close();
                return false;
            } else{
                device.close();
                return true;
            }
            
        } catch (Exception e) {
            System.out.println(e);
            return true;
        }
    }

    public String imprimirFacturaArg(String data) {
        if (device == null) {
            device = (PrinterDevice) POSTerminal.getInstance(context)
                    .getDevice("cloudpos.device.printer");
        }
        try {
            device.open();
            device.printText(data);
            device.close();
            return "Factura impresa correctamente";
        } catch (DeviceException e) {
            //TODO: handle exception
            e.printStackTrace();
            return "Error al imprimir la factura";
        }
    }
    public String imprimirFactura2() {
        if (device == null) {
            device = (PrinterDevice) POSTerminal.getInstance(context)
                    .getDevice("cloudpos.device.printer");
        }
        try {
            device.open();
            final String htmlContent = "<!DOCTYPE html>" +
                    "<html>" +
                    "<head>" +
                    "    <style type=\"text/css\">" +
                    "     * {" +
                    "        margin:0;" +
                    "        padding:0;" +
                    "     }" +
                    "    </style>" +
                    "</head>" +
                    "<body>" +
                    "Demo receipts<br />" +
                    "MERCHANT COPY<br />" +
                    "<hr/>" +
                    "MERCHANT NAME<br />" +
                    "SHXXXXXXCo.,LTD.<br />" +
                    "530310041315039<br />" +
                    "TERMINAL NO<br />" +
                    "50000045<br />" +
                    "OPERATOR<br />" +
                    "50000045<br />" +
                    "<hr />" +
                    "CARD NO<br />" +
                    "623020xxxxxx3994 I<br />" +
                    "ISSUER ACQUIRER<br />" +
                    "<br />" +
                    "TRANS TYPE<br />" +
                    "PAY SALE<br />" +
                    "PAY SALE<br />" +
                    "<hr/>" +
                    "DATE/TIME EXP DATE<br />" +
                    "2005/01/21 16:52:32 2099/12<br />" +
                    "REF NO BATCH NO<br />" +
                    "165232857468 000001<br />" +
                    "VOUCHER AUTH NO<br />" +
                    "000042<br />" +
                    "AMOUT:<br />" +
                    "RMB:0.01<br />" +
                    "<hr/>" +
                    "BEIZHU<br />" +
                    "SCN:01<br />" +
                    "UMPR NUM:4F682D56<br />" +
                    "TC:EF789E918A548668<br />" +
                    "TUR:008004E000<br />" +
                    "AID:A000000333010101<br />" +
                    "TSI:F800<br />" +
                    "ATC:0440<br />" +
                    "APPLAB:PBOC DEBIT<br />" +
                    "APPNAME:PBOC DEBIT<br />" +
                    "AIP:7C00<br />" +
                    "CUMR:020300<br />" +
                    "IAD:07010103602002010A01000000000005DD79CB<br />" +
                    "TermCap:EOE1C8<br />" +
                    "CARD HOLDER SIGNATURE<br />" +
                    "I ACKNOWLEDGE SATISFACTORY RECEIPT OF RELATIVE GOODS/SERVICE<br />" +
                    "I ACKNOWLEDGE SATISFACTORY RECEIPT OF RELATIVE GOODS/SERVICE<br />" +
                    "I ACKNOWLEDGE SATISFACTORY RECEIPT OF RELATIVE GOODS/SERVICE<br />" +
                    "<br />" +
                    "Demo receipts,do not sign!<br />" +
                    "<br />" +
                    "<br />" +
                    "<br />" +
                    "</body>" +
                    "</html>";
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    try {
                        device.printHTML(context,htmlContent, null);
                        device.close();
                        // sendSuccessLog(mContext.getString(R.string.operation_succeed));
                    } catch (Exception e) {
                        // sendFailedLog(mContext.getString(R.string.operation_failed));
                    }
                }
            });
            
            return "Impresion completa HTML";
        } catch (Exception e) {
            e.printStackTrace();
            // sendFailedLog(mContext.getString(R.string.operation_failed));
            return "Impresion Fail HTML";
        }
    }
}