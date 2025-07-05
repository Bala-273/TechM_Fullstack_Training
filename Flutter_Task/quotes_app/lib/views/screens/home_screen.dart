import 'dart:async';
import 'dart:math';

import 'package:flutter/material.dart';
import 'package:quotes_app/services/firestore_service.dart';
import 'package:quotes_app/views/screens/add_quotes_screen.dart';

class HomeScreen extends StatefulWidget {
  const HomeScreen({super.key});

  @override
  State<HomeScreen> createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  final _firestoreService = FirestoreService();
  List<Map<String, dynamic>> _quotes = [];
  int _currentIndex = 0;
  Timer? _timer;

  @override
  void dispose() {
    _timer?.cancel();
    super.dispose();
  }

  void _startQuoteTimer() {
    _timer = Timer.periodic(Duration(seconds: 5), (timer) {
      if (_quotes.isNotEmpty) {
        setState(() {
          _currentIndex = (_currentIndex + 1) % _quotes.length;
        });
      }
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: StreamBuilder<List<Map<String, dynamic>>>(
        stream: _firestoreService.getQuotes(),
        builder: (context, snapshot) {
          if (!snapshot.hasData) {
            return Center(child: CircularProgressIndicator());
          }

          final data = snapshot.data!;

          if (data.isEmpty) {
            return Center(child: Text('No quotes available'));
          }

          if (_quotes.isEmpty) {
            _quotes = List.from(data)..shuffle(Random());
            _startQuoteTimer();
          }

          final currentQuote = _quotes[_currentIndex];
          final quoteText = currentQuote['quote'];
          final authorText = currentQuote['author'];

          return Center(
            child: Container(
              width: 400.0,
              height: 300.0,
              padding: EdgeInsets.all(20.0),
              child: Card(
                color: const Color.fromARGB(255, 150, 157, 160),
                elevation: 5.0,
                child: Padding(
                  padding: EdgeInsets.all(16.0),
                  child: Column(
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: [
                      Text(
                        '"$quoteText"',
                        style: TextStyle(
                          fontSize: 20.0,
                          fontStyle: FontStyle.italic,
                        ),
                        textAlign: TextAlign.center,
                      ),
                      SizedBox(height: 20.0),
                      Text(
                        '-$authorText',
                        style: TextStyle(
                          fontSize: 16.0,
                          fontWeight: FontWeight.bold,
                        ),
                      ),
                    ],
                  ),
                ),
              ),
            ),
          );
        },
      ),

      floatingActionButton: FloatingActionButton(
        onPressed:
            () => Navigator.push(
              context,
              MaterialPageRoute(builder: (context) => AddQuotesScreen()),
            ),
        backgroundColor: Colors.blueGrey,
        child: Icon(Icons.add),
      ),
    );
  }
}
