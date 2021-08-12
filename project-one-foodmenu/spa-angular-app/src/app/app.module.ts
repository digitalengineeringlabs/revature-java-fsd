import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';


import { AppComponent } from './app.component';
import { MenusComponent } from './menus/menus.component';
import { LoginComponent } from './site/login.component';
import { FormsModule } from '@angular/forms';
import { HomeComponent } from './site/home.component';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './site/auth.guard';

const routes:Routes = [
  { path: '', component: HomeComponent, canActivate: [AuthGuard], children: 
    [{ path: 'menus', component: MenusComponent }] },
  { path: 'login', component: LoginComponent }
]

@NgModule({
  declarations: [
    AppComponent,
    MenusComponent,
    LoginComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
