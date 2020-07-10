import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {RouterModule} from '@angular/router';
import {LoginModule} from '../login/login.module';

@NgModule({
  declarations: [
    AppComponent
  ],
    imports: [
        BrowserModule,
        RouterModule,
        AppRoutingModule,
        LoginModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
