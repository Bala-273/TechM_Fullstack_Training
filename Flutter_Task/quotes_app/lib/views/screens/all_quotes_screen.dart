import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:flutter/material.dart';
import 'package:quotes_app/views/widgets/quote_tile.dart';

class AllQuotesScreen extends StatelessWidget {
  const AllQuotesScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: StreamBuilder<QuerySnapshot>(
        stream: FirebaseFirestore.instance.collection('quotes').snapshots(),
        builder: (context, snapshot) {
          if (snapshot.connectionState == ConnectionState.waiting) {
            return Center(child: CircularProgressIndicator());
          }

          final quotes = snapshot.data!.docs;

          if (quotes.isEmpty) {
            return Center(child: Text('No quotes added yet'));
          }

          return ListView.builder(
            itemCount: quotes.length,
            itemBuilder: (context, index) {
              final data = quotes[index].data() as Map<String, dynamic>;
              final docId = quotes[index].id;
              final quote = data['quote'];
              final author = data['author'];
              return QuoteTile(docId: docId, quote: quote, author: author);
            },
          );
        },
      ),
    );
  }
}
