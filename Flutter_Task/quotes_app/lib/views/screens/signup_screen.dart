import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';
import 'package:quotes_app/utils/snackbar_util.dart';
import 'package:quotes_app/utils/validators/password_rules.dart';
import 'package:quotes_app/utils/validators/password_validator.dart';
import 'package:quotes_app/views/screens/login_screen.dart';
import 'package:quotes_app/views/widget_tree.dart';
import 'package:quotes_app/views/widgets/custom_textfield.dart';

class SignupScreen extends StatefulWidget {
  const SignupScreen({super.key});

  @override
  State<SignupScreen> createState() => _SignupScreenState();
}

class _SignupScreenState extends State<SignupScreen> {
  final _formKey = GlobalKey<FormState>();
  final userNameController = TextEditingController();
  final emailController = TextEditingController();
  final phoneController = TextEditingController();
  final passwordController = TextEditingController();

  void _submitForm() async {
    if (_formKey.currentState!.validate()) {
      try {
        await FirebaseAuth.instance.createUserWithEmailAndPassword(
          email: emailController.text.trim(),
          password: passwordController.text.trim(),
        );
        SnackbarUtil.showSuccess(context, 'Registration successful');
        Navigator.pushReplacement(
          context,
          MaterialPageRoute(builder: (context) => WidgetTree()),
        );
      } catch (e) {
        SnackbarUtil.showError(context, 'Registration failed ${e}');
      }
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: Form(
          key: _formKey,
          child: Column(
            children: [
              Container(
                margin: EdgeInsets.only(top: 100.0),
                width: 300.0,
                child: Column(
                  children: [
                    Text(
                      'Sign Up',
                      style: TextStyle(
                        fontWeight: FontWeight.bold,
                        fontSize: 20.0,
                      ),
                    ),
                    SizedBox(height: 10.0),
                    CustomTextfield(
                      label: 'Username',
                      controller: userNameController,
                      validator:
                          (value) =>
                              value == null || value.isEmpty
                                  ? 'Enter username'
                                  : null,
                    ),
                    SizedBox(height: 15.0),
                    CustomTextfield(
                      label: 'Email',
                      controller: emailController,
                      validator:
                          (value) =>
                              value == null || value.isEmpty
                                  ? 'Enter mail'
                                  : null,
                    ),
                    SizedBox(height: 10.0),
                    CustomTextfield(
                      label: 'Phone No',
                      keyboardType: TextInputType.phone,
                      controller: phoneController,
                      validator:
                          (value) =>
                              value == null || value.isEmpty
                                  ? 'Enter phone number'
                                  : null,
                    ),
                    SizedBox(height: 10.0),
                    CustomTextfield(
                      label: 'Password',
                      obscureText: true,
                      controller: passwordController,
                      validator:
                          (value) => validatePassword(value ?? '', [
                            PasswordRules.minLength,
                            PasswordRules.maxLength,
                            PasswordRules.hasUppercase,
                            PasswordRules.hasLowercase,
                            PasswordRules.hasNumber,
                            PasswordRules.hasSpecialCharacter,
                          ]),
                    ),
                  ],
                ),
              ),
              SizedBox(height: 20.0),
              ElevatedButton(
                onPressed: () => _submitForm(),
                child: Text('Sign Up'),
                style: ElevatedButton.styleFrom(
                  minimumSize: Size(300.0, 50.0),
                  backgroundColor: Colors.blueGrey,
                  foregroundColor: Colors.white,
                  shape: RoundedRectangleBorder(
                    borderRadius: BorderRadius.circular(5.0),
                  ),
                ),
              ),
              SizedBox(height: 10.0),
              TextButton(
                onPressed:
                    () => Navigator.pushReplacement(
                      context,
                      MaterialPageRoute(builder: (context) => LoginScreen()),
                    ),
                child: Text(
                  'Already have an account? Login',
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
