import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor(private router: Router) {
    this.redirectIfLoggedIn();
  }

  redirectIfLoggedIn() {
    if (localStorage.getItem("username")) {
      this.router.navigate(['/home']);
    }
  }
}
