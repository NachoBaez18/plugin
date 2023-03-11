import 'package:plugin_platform_interface/plugin_platform_interface.dart';

import 'wizarpos_method_channel.dart';

abstract class WizarposPlatform extends PlatformInterface {
  /// Constructs a WizarposPlatform.
  WizarposPlatform() : super(token: _token);

  static final Object _token = Object();

  static WizarposPlatform _instance = MethodChannelWizarpos();

  /// The default instance of [WizarposPlatform] to use.
  ///
  /// Defaults to [MethodChannelWizarpos].
  static WizarposPlatform get instance => _instance;

  /// Platform-specific implementations should set this with their own
  /// platform-specific class that extends [WizarposPlatform] when
  /// they register themselves.
  static set instance(WizarposPlatform instance) {
    PlatformInterface.verifyToken(instance, _token);
    _instance = instance;
  }

  Future<String?> getPlatformVersion() {
    throw UnimplementedError('platformVersion() has not been implemented.');
  }

  Future<String> openPrinter() async {
    throw UnimplementedError('openPrinter() has not been implemented.');
  }

  Future<void> printer(data) async {
    throw UnimplementedError('printer() has not been implemented.');
  }

  Future<String> openNfc() async {
    throw UnimplementedError('openNfc() has not been implemented.');
  }

  Future<String> uID() async {
    throw UnimplementedError('uID() has not been implemented.');
  }

  Future<String> closeNFC() async {
    throw UnimplementedError('closeNFC() has not been implemented.');
  }

  Future<String> listenCard() async {
    throw UnimplementedError('listenCard() has not been implemented.');
  }

  Future<String> listenCardAsync() async {
    throw UnimplementedError('listenCardAsync() has not been implemented.');
  }

  Future<String> cancelRequestNFC() async {
    throw UnimplementedError('cancelRequestNFC() has not been implemented.');
  }

  Future<String> sacarTarjeta() async {
    throw UnimplementedError('sacarTarjeta() has not been implemented.');
  }

  Future<String> prenderLedVerde() async {
    throw UnimplementedError('prenderLedVerde() has not been implemented.');
  }

  Future<String> cancelarBlink() async {
    throw UnimplementedError('cancelarBlink() has not been implemented.');
  }

  Future<String> serialPos() async {
    throw UnimplementedError('serialPos() has not been implemented.');
  }

  Future<bool> printerStatus() async {
    throw UnimplementedError('printerStatus() has not been implemented.');
  }
}
