import 'password_rules.dart';

String? validatePassword(String value, List<PasswordRules> rules){
  for(var rule in rules){
    switch(rule){
      case PasswordRules.minLength:
        if(value.length<8) {
          return 'Password must be atleast 8 characters long';
        }
          break;
      case PasswordRules.maxLength:
        if(value.length>16) {
          return 'Password must be within 16 characters';
        }
          break;
      case PasswordRules.hasLowercase:
        if(!value.contains(RegExp(r'[a-z]'))) {
          return 'Password must contain atleast one lowercase character';
        }
          break;
      case PasswordRules.hasUppercase:
        if(!value.contains(RegExp(r'[A-Z]'))) {
          return 'Password must contain atleast one uppercase character';
        }
          break;
      case PasswordRules.hasNumber:
        if(!value.contains(RegExp(r'[0-9]'))) {
          return 'Password must contain atleast one number';
        }
          break;
      case PasswordRules.hasSpecialCharacter:
        if(!value.contains(RegExp('[!@#\$%&*]'))) {
          return 'Password must contain atleast one special characters';
        }
          break;
      
    }
  }
  return null;

}