import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule} from '@angular/common/http';

import { AlertComponent } from './alerts/alert.component';

import { AppComponent } from './app.component';
import { PostsComponent } from './posts/posts.component';
import { AddProductComponent } from './products/add-product/add-product.component';
import { ProductComponent } from './products/product.component';
import { ProductsComponent } from './products/products.component';
import { ProductsService } from './products/products.service';
import { ShortenPipe } from './shorten.pipe';
import { SignupComponent } from './signup/signup.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { CatalogComponent } from './catalog/catalog.component';
import { ProjectinfoComponent } from './catalog/projectinfo/projectinfo.component';
import { NotfoundComponent } from './site/notfound/notfound.component';
import { AuthGuard } from './auth.guard';
import { AppLoginComponent } from './site/app-login/app-login.component';

const routes:Routes = [
  { path:'',component:HomeComponent, canActivate: [AuthGuard]},
  {
    path:'catalog/:id', component:CatalogComponent, canActivate: [AuthGuard],
    children: [
      { path:'productinfo/:id', component:ProjectinfoComponent }
    ]
  },
  {
    path: 'app-login', component: AppLoginComponent
  },
  {
    path: 'not-found', component: NotfoundComponent
  },
  {
    path: '**', redirectTo: 'not-found'
  }
  // {path:'catalog/:category/productinfo/:id',component:ProjectinfoComponent},
]

@NgModule({
  declarations: [
    AppComponent,
    ProductComponent,
    ProductsComponent,
    AddProductComponent,
    AlertComponent,
    PostsComponent,
    ShortenPipe,
    SignupComponent,
    LoginComponent,
    HomeComponent,
    CatalogComponent,
    ProjectinfoComponent,
    NotfoundComponent,
    AppLoginComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
