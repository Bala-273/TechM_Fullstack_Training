import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:flutter/material.dart';
import 'package:quotes_app/utils/snackbar_util.dart';

class QuoteTile extends StatelessWidget {
  final String quote;
  final String author;
  final String docId;

  const QuoteTile({
    super.key,
    required this.quote,
    required this.author,
    required this.docId,
  });

  void _deleteQuote(BuildContext context) async {
    try {
      await FirebaseFirestore.instance.collection('quotes').doc(docId).delete();
      SnackbarUtil.showSuccess(context, 'Quote deleted');
    } catch (e) {
      SnackbarUtil.showError(context, 'Delete failed');
    }
  }

  void _editQuote(BuildContext context) {
    final quoteController = TextEditingController(text: quote);
    final authorController = TextEditingController(text: author);

    showDialog(
      context: context,
      builder:
          (context) => AlertDialog(
            title: Text('Edit Quote'),
            content: Container(
              width: 400,
              child: Column(
                mainAxisSize: MainAxisSize.min,
                children: [
                  TextField(
                    controller: quoteController,
                    decoration: InputDecoration(
                      border: OutlineInputBorder(),
                      label: Text('Quote'),
                    ),
                    maxLines: 5,
                  ),
                  SizedBox(height: 10),
                  TextField(
                    controller: authorController,
                    decoration: InputDecoration(
                      border: OutlineInputBorder(),
                      label: Text('Author'),
                    ),
                  ),
                ],
              ),
            ),
            actions: [
              ElevatedButton(
                style: ElevatedButton.styleFrom(backgroundColor: Colors.white),
                onPressed: () async {
                  try {
                    await FirebaseFirestore.instance
                        .collection('quotes')
                        .doc(docId)
                        .update({
                          'quote': quoteController.text.trim(),
                          'author': authorController.text.trim(),
                        });
                    Navigator.pop(context);
                    SnackbarUtil.showSuccess(context, 'Quote updated');
                  } catch (e) {
                    SnackbarUtil.showError(context, 'Update failed');
                  }
                },
                child: Text('Update', style: TextStyle(color: Colors.black)),
              ),
              TextButton(
                style: TextButton.styleFrom(backgroundColor: Colors.redAccent),
                onPressed: () => Navigator.pop(context),
                child: Text('Cancel', style: TextStyle(color: Colors.black)),
              ),
            ],
          ),
    );
  }

  @override
  Widget build(BuildContext context) {
    return Card(
      //color: Color(0xFFDCEEFB),
      shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(10)),
      elevation: 4,
      margin: EdgeInsets.symmetric(horizontal: 12, vertical: 6),
      child: ListTile(
        title: Text(
          quote,
          style: TextStyle(fontWeight: FontWeight.bold, fontSize: 16),
        ),
        subtitle: Text('- $author', style: TextStyle(fontSize: 14)),
        trailing: Row(
          mainAxisSize: MainAxisSize.min,
          children: [
            IconButton(
              icon: Icon(Icons.edit, color: Colors.blue),
              onPressed: () => _editQuote(context),
            ),
            IconButton(
              icon: Icon(Icons.delete, color: Colors.red),
              onPressed: () => _deleteQuote(context),
            ),
          ],
        ),
      ),
    );
  }
}
