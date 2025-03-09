import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  username: string = '';
  password: string = '';

  constructor(private router: Router) {}

  login() {
    if (this.username === "BalaK" && this.password === "password") {
      localStorage.setItem("username", this.username);

      
      this.router.navigate(['/home']);
    } else {
      alert("Invalid Credentials");
    }
  }
}
