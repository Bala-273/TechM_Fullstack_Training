import 'package:flutter/widgets.dart';
import 'package:quotes_app/main.dart';

class LocaleService {
  static void setLocale(BuildContext context, Locale newLocale) {
    final state = context.findAncestorStateOfType<MyAppState>();
    state?.updateLocale(newLocale);
  }
}
