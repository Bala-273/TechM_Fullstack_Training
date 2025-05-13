import 'package:flutter/material.dart';
import 'package:flutter_gen/gen_l10n/app_localizations.dart';
import '../services/firebase_service.dart';

class AddQuoteScreen extends StatefulWidget {
  @override
  _AddQuoteScreenState createState() => _AddQuoteScreenState();
}

class _AddQuoteScreenState extends State<AddQuoteScreen> {
  final _formKey = GlobalKey<FormState>();
  final Map<String, TextEditingController> _controllers = {
    'text_en': TextEditingController(),
    'author_en': TextEditingController(),
    'text_ta': TextEditingController(),
    'author_ta': TextEditingController(),
    'text_es': TextEditingController(),
    'author_es': TextEditingController(),
  };
  final FirebaseService _firebaseService = FirebaseService();

  Widget _buildLanguageSection(String langCode, AppLocalizations l10n) {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Text(
          langCode.toUpperCase(),
          style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
        ),
        TextFormField(
          controller: _controllers['text_$langCode'],
          decoration: InputDecoration(labelText: l10n.quoteText),
          maxLines: 3,
          validator: (value) => value!.isEmpty ? l10n.fieldRequired : null,
        ),
        TextFormField(
          controller: _controllers['author_$langCode'],
          decoration: InputDecoration(labelText: l10n.authorName),
          validator: (value) => value!.isEmpty ? l10n.fieldRequired : null,
        ),
        SizedBox(height: 20),
      ],
    );
  }

  void _submitForm() async {
    if (_formKey.currentState!.validate()) {
      try {
        await _firebaseService.addQuote({
          'text_en': _controllers['text_en']!.text,
          'author_en': _controllers['author_en']!.text,
          'text_ta': _controllers['text_ta']!.text,
          'author_ta': _controllers['author_ta']!.text,
          'text_es': _controllers['text_es']!.text,
          'author_es': _controllers['author_es']!.text,
        });
        Navigator.pop(context);
      } catch (e) {
        ScaffoldMessenger.of(
          context,
        ).showSnackBar(SnackBar(content: Text(e.toString())));
      }
    }
  }

  @override
  void dispose() {
    _controllers.values.forEach((controller) => controller.dispose());
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    final l10n = AppLocalizations.of(context)!;

    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.black,
        iconTheme: IconThemeData(color: Colors.white),
        title: Text(l10n.addQuote, style: TextStyle(color: Colors.white)),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Form(
          key: _formKey,
          child: SingleChildScrollView(
            child: Column(
              children: [
                _buildLanguageSection('en', l10n),
                _buildLanguageSection('ta', l10n),
                _buildLanguageSection('es', l10n),
                SizedBox(height: 30),
                ElevatedButton(
                  style: ElevatedButton.styleFrom(
                    backgroundColor: Colors.black,
                    foregroundColor: Colors.white,
                    padding: EdgeInsets.symmetric(horizontal: 40, vertical: 15),
                  ),
                  onPressed: _submitForm,
                  child: Text(l10n.saveQuote, style: TextStyle(fontSize: 18)),
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}
