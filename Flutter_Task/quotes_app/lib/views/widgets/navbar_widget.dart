import 'package:flutter/material.dart';
import 'package:quotes_app/data/notifier.dart';
import 'package:flutter_gen/gen_l10n/app_localizations.dart';

class NavbarWidget extends StatelessWidget {
  const NavbarWidget({super.key});

  @override
  Widget build(BuildContext context) {
    return ValueListenableBuilder(
      valueListenable: selectedScreenNotifier,
      builder: (context, selectedScreen, child) {
        return NavigationBar(
          destinations: [
            NavigationDestination(icon: Icon(Icons.home), label: AppLocalizations.of(context)!.home),
            NavigationDestination(icon: Icon(Icons.list), label: AppLocalizations.of(context)!.quotes),
          ],
          onDestinationSelected: (value) => selectedScreenNotifier.value = value, selectedIndex: selectedScreen,
        );
      },
    );
  }
}
