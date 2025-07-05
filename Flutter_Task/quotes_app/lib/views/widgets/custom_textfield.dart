import 'package:flutter/material.dart';

class CustomTextfield extends StatefulWidget {
  final String label;
  final TextInputType keyboardType;
  final bool obscureText;
  final TextEditingController? controller;
  final String? Function(String?)? validator;

  const CustomTextfield({
    super.key,
    required this.label,
    this.keyboardType = TextInputType.text,
    this.obscureText = false,
    this.controller,
    this.validator,
  });

  @override
  State<CustomTextfield> createState() => _CustomTextfieldState();
}

class _CustomTextfieldState extends State<CustomTextfield> {
  late bool _obscure;

  @override
  void initState() {
    super.initState();
    _obscure = widget.obscureText; //initialize _ obscure based on widget property i.e in password true
  }

  @override
  Widget build(BuildContext context) {
    return TextFormField(
      controller: widget.controller,
      validator: widget.validator,
      keyboardType: widget.keyboardType,
      obscureText: _obscure,
      decoration: InputDecoration(
        label: Text(widget.label),
        border: OutlineInputBorder(),
        suffixIcon:
            widget.obscureText //obscure text is true for password field
                ? IconButton(
                  icon: Icon(
                    _obscure ? Icons.visibility_off : Icons.visibility,
                  ),
                  onPressed: () {
                    setState(() {
                      _obscure = !_obscure;
                    });
                  },
                )
                : null, // Show suffix icon only if obscureText is true
      ),
    );
  }
}
