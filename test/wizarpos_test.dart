import 'package:flutter_test/flutter_test.dart';
import 'package:wizarpos/wizarpos.dart';
import 'package:wizarpos/wizarpos_platform_interface.dart';
import 'package:wizarpos/wizarpos_method_channel.dart';
import 'package:plugin_platform_interface/plugin_platform_interface.dart';

class MockWizarposPlatform
    with MockPlatformInterfaceMixin
    implements WizarposPlatform {

  @override
  Future<String> getPlatformVersion() => Future.value('42');

  @override
  Future<String> cancelRequestNFC() {
    // TODO: implement cancelRequestNFC
    throw UnimplementedError();
  }

  @override
  Future<String> cancelarBlink() {
    // TODO: implement cancelarBlink
    throw UnimplementedError();
  }

  @override
  Future<String> closeNFC() {
    // TODO: implement closeNFC
    throw UnimplementedError();
  }

  @override
  Future<String> listenCard() {
    // TODO: implement listenCard
    throw UnimplementedError();
  }

  @override
  Future<String> listenCardAsync() {
    // TODO: implement listenCardAsync
    throw UnimplementedError();
  }

  @override
  Future<String> openNfc() {
    // TODO: implement openNfc
    throw UnimplementedError();
  }

  @override
  Future<String> openPrinter() {
    // TODO: implement openPrinter
    throw UnimplementedError();
  }

  @override
  Future<String> prenderLedVerde() {
    // TODO: implement prenderLedVerde
    throw UnimplementedError();
  }

  @override
  Future<void> printer(data) {
    // TODO: implement printer
    throw UnimplementedError();
  }

  @override
  Future<bool> printerStatus() {
    // TODO: implement printerStatus
    throw UnimplementedError();
  }

  @override
  Future<String> sacarTarjeta() {
    // TODO: implement sacarTarjeta
    throw UnimplementedError();
  }

  @override
  Future<String> serialPos() {
    // TODO: implement serialPos
    throw UnimplementedError();
  }

  @override
  Future<String> uID() {
    // TODO: implement uID
    throw UnimplementedError();
  }
}

void main() {
  final WizarposPlatform initialPlatform = WizarposPlatform.instance;

  test('$MethodChannelWizarpos is the default instance', () {
    expect(initialPlatform, isInstanceOf<MethodChannelWizarpos>());
  });

  test('getPlatformVersion', () async {
    Wizarpos wizarposPlugin = Wizarpos();
    MockWizarposPlatform fakePlatform = MockWizarposPlatform();
    WizarposPlatform.instance = fakePlatform;

    expect(await wizarposPlugin.getPlatformVersion(), '42');
  });
}
