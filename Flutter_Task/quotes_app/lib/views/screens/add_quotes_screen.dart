import 'package:flutter/material.dart';
import 'package:quotes_app/services/firestore_service.dart';
import 'package:quotes_app/utils/snackbar_util.dart';
import 'package:quotes_app/views/widgets/appbar_widget.dart';
import 'package:flutter_gen/gen_l10n/app_localizations.dart';

class AddQuotesScreen extends StatefulWidget {
  const AddQuotesScreen({super.key});

  @override
  State<AddQuotesScreen> createState() => _AddQuotesScreenState();
}

class _AddQuotesScreenState extends State<AddQuotesScreen> {
  final _formKey = GlobalKey<FormState>();
  final quoteController = TextEditingController();
  final authorControler = TextEditingController();
  final _firestoreService = FirestoreService();

  void _submitQuote() async {
    if (_formKey.currentState!.validate()) {
      final quote = quoteController.text.trim();
      final author = authorControler.text.trim();

      try {
        await _firestoreService.addQuote(quote, author);

        SnackbarUtil.showSuccess(context, 'Quote Added');

        quoteController.clear();
        authorControler.clear();
      } catch (e) {
        SnackbarUtil.showError(context, 'Failed to add quote');
      }
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppbarWidget(),
      body: Center(
        child: Container(
          width: 350.0,
          margin: EdgeInsets.only(top: 100.0),
          child: Form(
            key: _formKey,
            child: Column(
              children: [
                TextFormField(
                  controller: quoteController,
                  maxLines: 5,
                  decoration: InputDecoration(
                    border: OutlineInputBorder(),
                    label: Text(AppLocalizations.of(context)!.quoteLabel),
                  ),
                  validator:
                      (value) =>
                          value == null || value.isEmpty
                              ? AppLocalizations.of(context)!.enterQuote
                              : null,
                ),
                SizedBox(height: 15.0),
                TextFormField(
                  controller: authorControler,
                  decoration: InputDecoration(
                    border: OutlineInputBorder(),
                    label: Text(AppLocalizations.of(context)!.authorLabel),
                  ),
                  validator:
                      (value) =>
                          value == null || value.isEmpty
                              ? AppLocalizations.of(context)!.enterAuthor
                              : null,
                ),
                SizedBox(height: 15.0),
                ElevatedButton(
                  onPressed: () => _submitQuote(),
                  style: ElevatedButton.styleFrom(
                    backgroundColor: Colors.blueGrey,
                    foregroundColor: Colors.white,
                    minimumSize: Size(double.infinity, 50.0),
                  ),
                  child: Text(AppLocalizations.of(context)!.addQuote),
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}
