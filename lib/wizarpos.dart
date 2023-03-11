
import 'wizarpos_platform_interface.dart';

class Wizarpos {

  Future<String?> getPlatformVersion() {
    return WizarposPlatform.instance.getPlatformVersion();
  }

  Future<String> openPrinter() async {
    return WizarposPlatform.instance.openPrinter();
  }

  Future<void> printer(data) async {
    return WizarposPlatform.instance.printer(data);
  }

  Future<String> openNfc() async {
    return WizarposPlatform.instance.openNfc();
  }

  Future<String> uID() async {
    return WizarposPlatform.instance.uID();
  }

  Future<String> closeNFC() async {
    return WizarposPlatform.instance.closeNFC();
  }

  Future<String> listenCard() async {
    return WizarposPlatform.instance.listenCard();
  }

  Future<String> listenCardAsync() async {
    return WizarposPlatform.instance.listenCardAsync();
  }

  Future<String> cancelRequestNFC() async {
    return WizarposPlatform.instance.cancelRequestNFC();
  }

  Future<String> sacarTarjeta() async {
    return WizarposPlatform.instance.sacarTarjeta();
  }

  Future<String> prenderLedVerde() async {
    return WizarposPlatform.instance.prenderLedVerde();
  }

  Future<String> cancelarBlink() async {
    return WizarposPlatform.instance.cancelarBlink();
  }

  Future<String> serialPos() async {
    return WizarposPlatform.instance.serialPos();
  }

  Future<bool> printerStatus() async {
    return WizarposPlatform.instance.printerStatus();
  }

}
