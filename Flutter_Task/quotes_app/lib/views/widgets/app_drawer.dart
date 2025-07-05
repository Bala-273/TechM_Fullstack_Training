import 'package:flutter/material.dart';
import 'package:quotes_app/main.dart';
import 'package:quotes_app/services/auth_service.dart';
import 'package:flutter_gen/gen_l10n/app_localizations.dart';

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
                              Locale newLocale = Locale('en');
                              setLocale(context, newLocale);
                            },
                          ),
                          ListTile(
                            title: Text('Francais'),
                            onTap: () {
                              Locale newLocale = Locale('fr');
                              setLocale(context, newLocale);
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

  void setLocale(BuildContext context, Locale newLocale) {
    MyApp.setLocale(context, newLocale);
  }
}
