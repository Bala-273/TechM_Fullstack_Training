import 'package:flutter/material.dart';
import 'package:quotes_app/data/notifier.dart';

class AppbarWidget extends StatelessWidget implements PreferredSizeWidget {
  const AppbarWidget({super.key});

  @override
  Widget build(BuildContext context) {
    return AppBar(
      backgroundColor: Colors.blueGrey,
      title: Text(
        'Quotify',
        style: TextStyle(fontSize: 24.0, fontWeight: FontWeight.bold),
      ),
      actions: [
        IconButton(
          onPressed: () => isDarkModeNotifier.value = !isDarkModeNotifier.value,
          icon: ValueListenableBuilder(
            valueListenable: isDarkModeNotifier,
            builder: (context, isDarkMode, child) {
              return Icon(isDarkMode ? Icons.dark_mode : Icons.light_mode);
            },
          ),
        ),
      ],
    );
  }

  @override
  Size get preferredSize => const Size.fromHeight(kToolbarHeight);
}
