import {Component, OnInit} from '@angular/core';
import {FormBuilder, NgForm, Validators} from '@angular/forms';
import {LoginService} from '../login.service';
import {Register} from '../register';
import {Router} from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  constructor(private builder: FormBuilder, private api: LoginService, private route: Router) {
  }

  register: Register;
  error: any;
  registerDetails = this.builder.group({
    firstName: ['', [Validators.minLength(2)]],
    lastName: ['', [Validators.required]],
    username: ['', [Validators.minLength(3), Validators.pattern('[a-zA-Z0-9^@^-^,^.]{3-7}')]],
    password: ['', [Validators.minLength(5), Validators.required]],
    confirmPassword: ['', [Validators.minLength(5), Validators.required]],
    email: ['', null],

  });
  unwrap = ({firstName, lastName, username, password, email}) => ({firstName, lastName, username, password, email});


  ngOnInit() {
  }

  saveDetails(details: any) {
    console.log(details);

    this.register = this.unwrap(details);
    console.log(this.register);


    this.api.saveRegistration(details).subscribe(msg => {
        this.route.navigate(['/login']);
      },
      error => {

        console.log(error);
        if (error.includes('40')) {
          this.error = 'Server error ,Please try again';
        }

      });


  }
}
