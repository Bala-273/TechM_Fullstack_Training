import 'package:flutter/material.dart';
import 'package:flutter_gen/gen_l10n/app_localizations.dart';
import 'package:cloud_firestore/cloud_firestore.dart';
import 'dart:async';
import 'dart:math';
import '../services/firebase_service.dart';
import 'add_quote_screen.dart';

class HomeScreen extends StatefulWidget {
  final Function(Locale) setLocale;
  const HomeScreen({required this.setLocale});
  @override
  _HomeScreenState createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  final FirebaseService _firebaseService = FirebaseService();
  List<QueryDocumentSnapshot> _quotes = [];
  int _currentIndex = 0;
  Timer? _timer;
  late String _currentLang;

  @override
  void initState() {
    super.initState();
    _loadQuotes();
    _startTimer();
  }

  @override
  void didChangeDependencies() {
    super.didChangeDependencies();
    _currentLang = Localizations.localeOf(context).languageCode;
  }

  void _loadQuotes() async {
    final snapshot = await _firebaseService.getQuotesOnce();
    setState(() {
      _quotes = snapshot.docs;
    });
    _updateRandomQuote();
  }

  void _startTimer() {
    _timer = Timer.periodic(Duration(seconds: 20), (timer) {
      _updateRandomQuote();
    });
  }

  void _updateRandomQuote() {
    if (_quotes.isNotEmpty) {
      final random = Random();
      setState(() {
        _currentIndex = random.nextInt(_quotes.length);
      });
    }
  }

  String _getLocalizedText(Map<String, dynamic> data, String field) {
    return data['${field}_$_currentLang'] ?? data[field] ?? '';
  }

  @override
  void dispose() {
    _timer?.cancel();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    final l10n = AppLocalizations.of(context)!;
    final currentQuote = _quotes.isNotEmpty
        ? _quotes[_currentIndex].data() as Map<String, dynamic>
        : null;

    return Scaffold(
      appBar: AppBar(
        backgroundColor:Colors.black,
        iconTheme: IconThemeData(color: Colors.white),
        title: Text(l10n.appTitle,
        style: TextStyle(color: Colors.white)),
        actions: [
          DropdownButton<String>(
            value: _currentLang,
            dropdownColor: Colors.black,
            style: TextStyle(color: Colors.white),
            items: [
              DropdownMenuItem(value: 'en', child: Text(l10n.english, style: TextStyle(color: Colors.white))),
              DropdownMenuItem(value: 'ta', child: Text(l10n.tamil, style: TextStyle(color: Colors.white))),
              DropdownMenuItem(value: 'es', child: Text(l10n.spanish, style: TextStyle(color: Colors.white))),
            ],
            onChanged: (value) {
              if (value != null) {
                setState(() => _currentLang = value);
                widget.setLocale(Locale(value));
              }
            },
          ),
          IconButton(
            icon: Icon(Icons.list, color: Colors.white),
            onPressed: () => Navigator.pushNamed(context, '/all-quotes'),
          ),
        ],
      ),
      body: Center(
        child: Padding(
          padding: EdgeInsets.all(20),
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Stack(
                alignment: Alignment.center,
                children: [
                  Image.asset(
                    'assets/background.jpeg',
                    height: 300,
                    width: double.infinity,
                    fit: BoxFit.cover,
                  ),
                  if (currentQuote != null)
                    Positioned(
                      left: 20,
                      right: 20,
                      child: Column(
                        children: [
                          Text(
                            '"${_getLocalizedText(currentQuote, 'text')}"',
                            style: TextStyle(
                              fontSize: 24,
                              fontStyle: FontStyle.italic,
                              color: Colors.white,
                              shadows: [
                                Shadow(
                                  blurRadius: 5.0,
                                  color: Colors.black,
                                  offset: Offset(2.0, 2.0),
                                ),
                              ],
                            ),
                            textAlign: TextAlign.center,
                          ),
                          SizedBox(height: 10),
                          Text(
                            '- ${_getLocalizedText(currentQuote, 'author')}',
                            style: TextStyle(
                              fontSize: 18,
                              fontWeight: FontWeight.bold,
                              color: Colors.white,
                              shadows: [
                                Shadow(
                                  blurRadius: 5.0,
                                  color: Colors.black,
                                  offset: Offset(2.0, 2.0),
                                ),
                              ],
                            ),
                            textAlign: TextAlign.center,
                          ),
                        ],
                      ),
                    ),
                ],
              ),
              SizedBox(height: 40),
              ElevatedButton(
                style: ElevatedButton.styleFrom(
                  backgroundColor: Colors.black, foregroundColor: Colors.white,
                ),
                onPressed: _updateRandomQuote,
                child: Text(l10n.showAnotherQuote),
              ),
            ],
          ),
        ),
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
