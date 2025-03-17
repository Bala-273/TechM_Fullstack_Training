import 'package:flutter/material.dart';
import 'package:flutter_gen/gen_l10n/app_localizations.dart';
import 'package:cloud_firestore/cloud_firestore.dart';
import '../services/firebase_service.dart';
import 'add_quote_screen.dart';

class AllQuotesScreen extends StatelessWidget {
  final FirebaseService _firebaseService = FirebaseService();

  String _getLocalizedText(Map<String, dynamic> data, String field, BuildContext context) {
    final lang = Localizations.localeOf(context).languageCode;
    return data['${field}_$lang'] ?? data[field] ?? '';
  }

  @override
  Widget build(BuildContext context) {
    final l10n = AppLocalizations.of(context)!;

    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.black,
        iconTheme: IconThemeData(color: Colors.white),
        title: Text(l10n.allQuotes,
        style: TextStyle(color: Colors.white)),
        actions: [
          IconButton(
            icon: Icon(Icons.home),
            onPressed: () => Navigator.pushReplacementNamed(context, '/'),
          ),
        ],
      ),
      body: StreamBuilder<QuerySnapshot>(
        stream: _firebaseService.getAllQuotes(),
        builder: (context, snapshot) {
          if (snapshot.connectionState == ConnectionState.waiting) {
            return Center(child: CircularProgressIndicator());
          }

          if (snapshot.hasError) {
            return Center(child: Text('${l10n.error}: ${snapshot.error}'));
          }

          if (!snapshot.hasData || snapshot.data!.docs.isEmpty) {
            return Center(child: Text(l10n.noQuotesFound));
          }

          final quotes = snapshot.data!.docs;

          return ListView.builder(
            itemCount: quotes.length,
            itemBuilder: (context, index) {
              final quote = quotes[index].data() as Map<String, dynamic>;
              return Card(
                margin: EdgeInsets.all(8),
                child: ListTile(
                  title: Text(
                    _getLocalizedText(quote, 'text', context),
                    style: TextStyle(fontSize: 16),
                  ),
                  subtitle: Text(
                    '- ${_getLocalizedText(quote, 'author', context)}',
                    style: TextStyle(fontStyle: FontStyle.italic),
                  ),
                  trailing: IconButton(
                    icon: Icon(Icons.delete, color: Colors.red),
                    onPressed: () => _firebaseService.deleteQuote(quotes[index].id),
                  ),
                ),
              );
            },
          );
        },
      ),
      floatingActionButton: FloatingActionButton(
        backgroundColor: Colors.black,
        foregroundColor: Colors.white,
        child: Icon(Icons.add),
        onPressed: () => Navigator.push(
          context,
          MaterialPageRoute(builder: (context) => AddQuoteScreen()),
        ),
      ),
    );
  }
}