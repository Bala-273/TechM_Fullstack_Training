import 'package:flutter/material.dart';
import 'package:quotes_app/services/auth_service.dart';
import 'package:flutter_gen/gen_l10n/app_localizations.dart';
import 'package:quotes_app/services/locale_service.dart';

class AppDrawer extends StatelessWidget {
  const AppDrawer({super.key});

  @override
  Widget build(BuildContext context) {
    return Drawer(
      child: Column(
        children: [
          DrawerHeader(
            decoration: BoxDecoration(color: Colors.blueGrey),
            child: Center(
              child: Text(
                AppLocalizations.of(context)!.welcome,
                style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold),
              ),
            ),
          ),
          ListTile(
            leading: Icon(Icons.language),
            title: Text(AppLocalizations.of(context)!.language),
            onTap: () {
              showDialog(
                context: context,
                builder:
                    (_) => AlertDialog(
                      title: Text(AppLocalizations.of(context)!.chooseLanguage),
                      content: Column(
                        mainAxisSize: MainAxisSize.min,
                        children: [
                          ListTile(
                            title: Text('English'),
                            onTap: () {
                              LocaleService.setLocale(
                                context,
                                const Locale('en'),
                              );
                              Navigator.pop(context);
                            },
                          ),
                          ListTile(
                            title: Text('Francais'),
                            onTap: () {
                              LocaleService.setLocale(
                                context,
                                const Locale('fr'),
                              );
                              Navigator.pop(context);
                            },
                          ),
                        ],
                      ),
                    ),
              );
            },
          ),
          ListTile(
            leading: Icon(Icons.logout),
            title: Text(AppLocalizations.of(context)!.logout),
            onTap: () async {
              Navigator.of(context).pop();
              await AuthService().logout();
              Navigator.of(
                context,
              ).pushNamedAndRemoveUntil('/login', (route) => false);
            },
          ),
        ],
      ),
    );
  }
}
