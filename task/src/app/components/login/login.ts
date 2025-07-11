import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AuthRequest } from '../../models/auth-request';
import { AuthService } from '../../service/auth-service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './login.html',
  styleUrls: ['./login.css']
})
export class Login {
  userName: string = '';
  passWord: string = '';
  jwt: string = '';
  authRequest: AuthRequest = new AuthRequest();
  showPassword: boolean = false;

  constructor(private _authService: AuthService, private _router: Router) {}

  toggleShowPassword() {
    this.showPassword = !this.showPassword;
  }

  generate(): void {
    this.authRequest.username = this.userName;
    this.authRequest.password = this.passWord;

    this._authService.generateToken(this.authRequest).subscribe({
      next: (token: string) => {
        localStorage.setItem("jwt", token);
        this.jwt = token;
        // No alert(token); here!
        alert("Login successful!");
        this._router.navigate(['/main-menu']);
      },
      error: (err) => {
        alert("Login failed. Please check your credentials.");
        console.error(err);
      }
    });
  }
}
