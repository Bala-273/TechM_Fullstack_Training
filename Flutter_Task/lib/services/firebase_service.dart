import 'package:cloud_firestore/cloud_firestore.dart';

class FirebaseService {
  final FirebaseFirestore _firestore = FirebaseFirestore.instance;

  // Add new quote
  Future<void> addQuote(Map<String, dynamic> quoteData) async {
    try {
      await _firestore.collection('quotes').add({
        'text_en': quoteData['text_en'],
        'author_en': quoteData['author_en'],
        'text_ta': quoteData['text_ta'],
        'author_ta': quoteData['author_ta'],
        'text_es': quoteData['text_es'],
        'author_es': quoteData['author_es'],
        'timestamp': Timestamp.now(),
      });
    } catch (e) {
      throw "Failed to add quote: $e";
    }
  }

  // Get all quotes stream
  Stream<QuerySnapshot> getAllQuotes() {
    return _firestore
        .collection('quotes')
        .orderBy('timestamp', descending: true)
        .snapshots();
  }

  // Delete quote
  Future<void> deleteQuote(String quoteId) async {
    try {
      await _firestore.collection('quotes').doc(quoteId).delete();
    } catch (e) {
      throw "Failed to delete quote: $e";
    }
  }

  // Get single fetch of quotes
  Future<QuerySnapshot> getQuotesOnce() async {
    return await _firestore
        .collection('quotes')
        .orderBy('timestamp', descending: true)
        .get();
  }
}