import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';

class SnackbarUtil {
  static void showSuccess(BuildContext context, String message) {
    ScaffoldMessenger.of(context).showSnackBar(
      SnackBar(
        content: Text(message, style: TextStyle(color: Colors.black)),
        backgroundColor: Colors.greenAccent,
      ),
    );
  }

  static void showError(BuildContext context, String message) {
    ScaffoldMessenger.of(context).showSnackBar(
      SnackBar(
        content: Text(message, style: TextStyle(color: Colors.black)),
        backgroundColor: Colors.redAccent,
      ),
    );
  }
}
