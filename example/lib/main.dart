import 'package:flutter/material.dart';
import 'dart:async';

import 'package:flutter/services.dart';
import 'package:wizarpos/wizarpos.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  String? _platformVersion = 'Unknown';
  String _prueba = 'Unknown';

  @override
  void initState() {
    super.initState();
    initPlatformState();
  }

  // Platform messages are asynchronous, so we initialize in an async method.
  Future<void> initPlatformState() async {
    String? platformVersion;

    // Platform messages may fail, so we use a try/catch PlatformException.
    try {
      platformVersion = await Wizarpos().getPlatformVersion();
    } on PlatformException {
      platformVersion = 'Failed to get platform version.';
    }

    // If the widget was removed from the tree while the asynchronous platform
    // message was in flight, we want to discard the reply rather than calling
    // setState to update our non-existent appearance.
    if (!mounted) return;

    setState(() {
      _platformVersion = platformVersion;
    });
  }

  _openPrinter(BuildContext context) async {
    late String prueba;
    try {
      prueba = await Wizarpos().openPrinter();
    } on PlatformException {
      _prueba = 'Failed to open.';
    }
    if (!mounted) return;

    setState(() {
      _prueba = prueba;
    });
  }

  _openNfc() async {
    late String prueba;
    try {
      prueba = await Wizarpos().openNfc();
    } on PlatformException {
      _prueba = 'Failed to open NFC.';
    }
    if (!mounted) return;

    setState(() {
      _prueba = prueba;
    });
  }

  _getUID() async {
    late String prueba;
    try {
      prueba = await Wizarpos().uID();
    } on PlatformException {
      _prueba = 'Failed to open NFC.';
    }
    if (!mounted) return;

    setState(() {
      _prueba = prueba;
    });
  }

  _closeNFC() async {
    late String prueba;
    try {
      prueba = await Wizarpos().closeNFC();
    } on PlatformException {
      _prueba = 'Failed to close NFC.';
    }
    if (!mounted) return;

    setState(() {
      _prueba = prueba;
    });
  }

  _listenCard() async {
    late String prueba;
    try {
      prueba = await Wizarpos().listenCardAsync();
    } on PlatformException {
      _prueba = 'Failed to listen card NFC.';
    }
    if (!mounted) return;

    setState(() {
      _prueba = prueba;
    });
  }

  _cancelRequestNFC() async {
    late String prueba;
    try {
      prueba = await Wizarpos().cancelRequestNFC();
    } on PlatformException {
      _prueba = 'Failed to listen card NFC.';
    }
    if (!mounted) return;

    setState(() {
      _prueba = prueba;
    });
  }

  _sacarTarjeta() async {
    late String prueba;
    try {
      prueba = await Wizarpos().sacarTarjeta();
    } on PlatformException {
      _prueba = 'Failed to expulse card NFC.';
    }
    if (!mounted) return;

    setState(() {
      _prueba = prueba;
    });
  }

  _probarLed() async {
    late String prueba;
    try {
      prueba = await Wizarpos().prenderLedVerde();
    } on PlatformException {
      _prueba = 'Failed to expulse card NFC.';
    }
    if (!mounted) return;

    setState(() {
      _prueba = prueba;
    });
  }

  _cancelarBlink() async {
    late String prueba;
    try {
      prueba = await Wizarpos().cancelarBlink();
    } on PlatformException {
      _prueba = 'Failed to expulse card NFC.';
    }
    if (!mounted) return;

    setState(() {
      _prueba = prueba;
    });
  }

  _serialPOS() async {
    late String prueba;
    try {
      prueba = await Wizarpos().serialPos();
    } on PlatformException {
      _prueba = 'Errpr serial';
    }
    if (!mounted) return;

    setState(() {
      _prueba = prueba;
    });
  }

  _papelImp() async {
    late bool prueba;
    try {
      prueba = await Wizarpos().printerStatus();
      print(prueba);
    } on PlatformException {
      _prueba = 'Errpr serial';
    }
    if (!mounted) return;

    setState(() {
      _prueba = prueba.toString();
    });
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        appBar: AppBar(
          title: const Text('WizarPosPlugin'),
        ),
        body: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Text('Running on: $_platformVersion\n prueba: $_prueba'),
              ElevatedButton(
                onPressed: () {
                  _serialPOS();
                },
                child: const Text("serial Pos"),
              ),
              ElevatedButton(
                onPressed: () {
                  _papelImp();
                },
                child: const Text("Printer Status"),
              ),
              ElevatedButton(
                onPressed: () {
                  _openPrinter(context);
                },
                child: const Text("PRINTER"),
              ),
              ElevatedButton(
                onPressed: () {
                  _openNfc();
                },
                child: const Text("NFC"),
              ),
              ElevatedButton(
                onPressed: () {
                  _getUID();
                },
                child: const Text("UID"),
              ),
              ElevatedButton(
                onPressed: () {
                  _closeNFC();
                },
                child: const Text("Close NFC"),
              ),
              ElevatedButton(
                onPressed: () {
                  _listenCard();
                },
                child: const Text("Listen Card NFC"),
              ),
              ElevatedButton(
                onPressed: () {
                  _cancelRequestNFC();
                },
                child: const Text("Cancel Request NFC"),
              ),
              ElevatedButton(
                onPressed: () {
                  _sacarTarjeta();
                },
                child: const Text("sacar tarjeta NFC"),
              ),
              ElevatedButton(
                onPressed: () {
                  _probarLed();
                },
                child: const Text("Blink"),
              ),
              ElevatedButton(
                onPressed: () {
                  _cancelarBlink();
                },
                child: const Text("Cancel Blink"),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
