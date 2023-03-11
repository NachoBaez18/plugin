import 'package:flutter/foundation.dart';
import 'package:flutter/services.dart';

import 'wizarpos_platform_interface.dart';

/// An implementation of [WizarposPlatform] that uses method channels.
class MethodChannelWizarpos extends WizarposPlatform {
  /// The method channel used to interact with the native platform.
  @visibleForTesting
  final methodChannel = const MethodChannel('wizarpos');

  @override
  Future<String?> getPlatformVersion() async {
    return await methodChannel.invokeMethod<String?>('getPlatformVersion');
  }

  @override
  Future<String> openPrinter() async {
    final String result = await methodChannel.invokeMethod('openPrinter');
    return result;
  }

  @override
  Future<void> printer(data) async {
    await methodChannel.invokeMethod('printer', data);
  }

  @override
  Future<String> openNfc() async {
    final String uuid = await methodChannel.invokeMethod('openNfc');
    return uuid;
  }

  @override
  Future<String> uID() async {
    final String uuid = await methodChannel.invokeMethod('getUID');
    return uuid;
  }

  @override
  Future<String> closeNFC() async {
    final String uuid = await methodChannel.invokeMethod('closeNfc');
    return uuid;
  }

  @override
  Future<String> listenCard() async {
    final String uuid = await methodChannel.invokeMethod('listenCard');
    return uuid;
  }

  @override
  Future<String> listenCardAsync() async {
    final String uuid = await methodChannel.invokeMethod('listenCardAsync');
    return uuid;
  }

  @override
  Future<String> cancelRequestNFC() async {
    final String uuid = await methodChannel.invokeMethod('cancelRequestNFC');
    return uuid;
  }

  @override
  Future<String> sacarTarjeta() async {
    final String uuid = await methodChannel.invokeMethod('sacarTarjeta');
    return uuid;
  }

  @override
  Future<String> prenderLedVerde() async {
    final String uuid = await methodChannel.invokeMethod('prenderLedVerde');
    return uuid;
  }

  @override
  Future<String> cancelarBlink() async {
    final String uuid = await methodChannel.invokeMethod('cancelarBlink');
    return uuid;
  }

  @override
  Future<String> serialPos() async {
    final String uuid = await methodChannel.invokeMethod('serialPOS');
    return uuid;
  }

  @override
  Future<bool> printerStatus() async {
    final bool uuid = await methodChannel.invokeMethod('papelImp');
    return uuid;
  }
}
