package com.example.wizarpos;

import androidx.annotation.NonNull;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;

import com.example.wizarpos.peripherals.Printer;
import com.example.wizarpos.peripherals.SmartCardAction1;
import com.example.wizarpos.peripherals.LEDAction1;
import com.example.wizarpos.peripherals.TerminalInfo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import java.util.Objects;

/** WizarposPlugin */
public class WizarposPlugin implements FlutterPlugin, MethodCallHandler {
  /// The MethodChannel that will the communication between Flutter and native Android
  ///
  /// This local reference serves to register the plugin with the Flutter Engine and unregister it
  /// when the Flutter Engine is detached from the Activity
  private MethodChannel channel;
  private Handler handler;
  public String result = "";

  Printer impresora = new Printer();
  LEDAction1 led = new LEDAction1();
  TerminalInfo terminal = new TerminalInfo();
  SmartCardAction1 nfc = new SmartCardAction1();

  @Override
  public void onAttachedToEngine(@NonNull FlutterPluginBinding flutterPluginBinding) {
    channel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "wizarpos");
    channel.setMethodCallHandler(this);
  }

  @Override
  public void onMethodCall(@NonNull MethodCall call, @NonNull Result result) {
    switch (call.method) {
      case "openPrinter":
        this.result = impresora.imprimirFactura();
        result.success(this.result);
        break;

      case "papelImp":
        result.success(impresora.estadoPapel());
        break;

      case "serialPOS":
        this.result = terminal.serialNumberPos();
        result.success(this.result);
        break;

      case "printer":
        this.result = impresora.imprimirFacturaArg(call.argument("data").toString());
        break;

      case "openNfc":
        this.result = nfc.open();
        // nfc.listenForCardPresent();
        result.success(this.result);
        break;

      case "listenCard":
        this.result = nfc.waitForCardPresent();
        result.success(this.result);
        break;

      case "listenCardAsync":
        nfc.listenForCardPresent();
        Handler handlerCallback = new Handler() {
          @Override
          public void handleMessage(@NonNull Message msg) {
            Bundle datos = msg.getData();
            result.success("hola");
          }
        };
        break;

      case "getPlatformVersion":
        result.success("Android " + android.os.Build.VERSION.RELEASE);
        break;

      case "getUID":
        this.result = nfc.getID();
        result.success(this.result);
        break;

      case "cancelRequestNFC":
        this.result = nfc.cancelRequest();
        result.success(this.result);
        break;

      case "sacarTarjeta":
        this.result = nfc.waitForCardAbsent();
        result.success(this.result);
        break;

      case "closeNfc":
        this.result = nfc.close();
        result.success(this.result);
        break;

      case "prenderLedVerde":
        led.open();
        this.result = led.blink();
        led.close();
        result.success(this.result);
        break;

      case "cancelarBlink":
        led.open();
        this.result = led.cancelBlink();
        led.close();
        result.success(this.result);
        break;

      default:
        result.success("Defaults case");
        result.notImplemented();
    }
  }

  @Override
  public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
    channel.setMethodCallHandler(null);
  }
}
