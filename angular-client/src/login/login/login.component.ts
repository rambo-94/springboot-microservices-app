import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, NgForm, Validators} from '@angular/forms';
import {LoginService} from '../login.service';
import {Login} from '../login';
import {Router} from '@angular/router';

function contains(input: FormControl) {

  const hasCharacters = (a) => {
    if (a.value.includes('@') || a.value.includes('-') && a.value.includes(',')) {
      return true;
    }

  };

  return hasCharacters(input) ? null : {noRequiredCharacters: true};

}

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
 loginCred: Login;
 errorMessage = false;
 error: string;
  constructor(private builder: FormBuilder, private api: LoginService, private route: Router ) {
  }


  loginDetails = this.builder.group({

    username: ['', [ Validators.minLength(3), Validators.pattern('[a-zA-Z0-9^@^-^,^.]{3-7}')]],
    password: ['', [Validators.minLength(6), Validators.required, contains]]


  });


  ngOnInit() {
  }

  onSubmit(value: NgForm) {

    console.log(value['username']);
    this.api.checkUserCred(value['username']).subscribe(login => {

      this.errorMessage = login.password === value['password'] ?  true : false;
      if ( this.errorMessage ) {
         this.route.navigate(['/home']);
       }
      }, message => {
          console.log(message);
          this.error = 'error retrieving details ,Please try again';
      }
    );
  }

  navigate() {
    this.route.navigate(['/register']);
  }
}



