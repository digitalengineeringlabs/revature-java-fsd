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

@NgModule({
  declarations: [
    AppComponent,
    ProductComponent,
    ProductsComponent,
    AddProductComponent,
    AlertComponent,
    PostsComponent,
    ShortenPipe
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
