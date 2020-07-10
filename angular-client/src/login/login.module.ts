import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {LoginService} from './login.service';
import {LoginRoutingModule} from './login-routing.module';

import {HttpClientModule, HttpParams} from '@angular/common/http';

@NgModule({
  declarations: [LoginComponent, RegisterComponent],
  providers: [LoginService, HttpParams],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    LoginRoutingModule,
    HttpClientModule

  ]
})
export class LoginModule { }
