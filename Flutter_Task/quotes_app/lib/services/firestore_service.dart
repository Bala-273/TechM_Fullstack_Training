import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:firebase_auth/firebase_auth.dart';

class FirestoreService {
  final _quotesCollection = FirebaseFirestore.instance.collection('quotes');
  final _db = FirebaseFirestore.instance.collection('defaultDB');

  Future<void> addQuote(String quote, String author) async {
    final uid = FirebaseAuth.instance.currentUser?.uid;
    await _quotesCollection.add({
      'quote': quote,
      'author': author,
      'userId': uid,
      'timestamp': FieldValue.serverTimestamp(),
    });
  }

  Stream<List<Map<String, dynamic>>> getQuotes() {
    return _db.snapshots().map((snapshot) {
      return snapshot.docs.map((doc) {
        final data = doc.data();
        return {'quote': data['quote'] ?? '', 'author': data['author'] ?? ''};
      }).toList();
    });
  }
}
