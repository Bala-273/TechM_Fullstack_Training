import 'package:flutter/material.dart';
import 'package:quotes_app/data/notifier.dart';
import 'package:quotes_app/views/screens/all_quotes_screen.dart';
import 'package:quotes_app/views/screens/home_screen.dart';
import 'package:quotes_app/views/widgets/app_drawer.dart';
import 'package:quotes_app/views/widgets/appbar_widget.dart';
import 'package:quotes_app/views/widgets/navbar_widget.dart';

List<Widget> screen = [HomeScreen(), AllQuotesScreen()];

class WidgetTree extends StatelessWidget {
  const WidgetTree({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppbarWidget(),
      drawer: AppDrawer(),
      body: ValueListenableBuilder(
        valueListenable: selectedScreenNotifier,
        builder: (context, selectedScreen, child) {
          return screen.elementAt(selectedScreen);
        },
      ),
      bottomNavigationBar: NavbarWidget(),
    );
  }
}
