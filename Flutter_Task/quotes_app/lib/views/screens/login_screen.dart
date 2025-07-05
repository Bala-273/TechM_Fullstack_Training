import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';
import 'package:quotes_app/utils/snackbar_util.dart';
import 'package:quotes_app/views/screens/signup_screen.dart';
import 'package:quotes_app/views/widget_tree.dart';

class LoginScreen extends StatefulWidget {
  const LoginScreen({super.key});

  @override
  State<LoginScreen> createState() => _LoginScreenState();
}

class _LoginScreenState extends State<LoginScreen> {
  final TextEditingController emailController = TextEditingController();
  final TextEditingController passwordController = TextEditingController();
  String error = '';

  void login() async {
    try {
      await FirebaseAuth.instance.signInWithEmailAndPassword(
        email: emailController.text.trim(),
        password: passwordController.text.trim(),
      );

      SnackbarUtil.showSuccess(context, 'Login Successful');
      Navigator.pushReplacement(
        context,
        MaterialPageRoute(builder: (context) => WidgetTree()),
      );
    } catch (e) {
      SnackbarUtil.showError(context, 'Login failed');
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Padding(
        padding: EdgeInsets.all(20),
        child: Center(
          child: Column(
            children: [
              Container(
                margin: EdgeInsets.only(top: 100.0),
                width: 300.0,
                child: Column(
                  children: [
                    Text(
                      'Login',
                      style: TextStyle(
                        fontSize: 20.0,
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                    SizedBox(height: 10.0),
                    TextField(
                      controller: emailController,
                      decoration: InputDecoration(
                        label: Text('Email'),
                        border: OutlineInputBorder(),
                      ),
                    ),
                    SizedBox(height: 20.0),
                    TextField(
                      controller: passwordController,
                      obscureText: true,
                      decoration: InputDecoration(
                        label: Text('Password'),
                        border: OutlineInputBorder(),
                      ),
                    ),
                  ],
                ),
              ),

              SizedBox(height: 20.0),
              ElevatedButton(
                onPressed: login,
                child: Text('Login'),
                style: ElevatedButton.styleFrom(
                  minimumSize: Size(300.0, 50.0),
                  backgroundColor: Colors.blueGrey,
                  foregroundColor: Colors.white,
                  shape: RoundedRectangleBorder(
                    borderRadius: BorderRadius.circular(5.0),
                  ),
                ),
              ),
              if (error.isNotEmpty)
                Padding(
                  padding: EdgeInsets.only(top: 10.0),
                  child: Text(error, style: TextStyle(color: Colors.red)),
                ),
              SizedBox(height: 10.0),
              TextButton(
                onPressed: () {
                  Navigator.pushReplacement(
                    context,
                    MaterialPageRoute(builder: (context) => SignupScreen()),
                  );
                },

                child: Text(
                  'Sign Up',
                  style: TextStyle(fontWeight: FontWeight.bold),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
