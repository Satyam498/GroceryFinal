import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegistrationService } from './registration.service';
import { RegistrationComponent } from './registration/registration.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { HttpClientModule } from '@angular/common/http';
import { AdminComponent } from './admin/admin.component';
import { UpdateProductComponent } from './admin/update-product/update-product.component';
import { ShowProductsComponent } from './admin/show-products/show-products.component';
import { AdminService } from './admin.service';
import { AddProductComponent } from './admin/add-product/add-product.component';

import { ProductFilterPipe } from './product-filter.pipe';
import { CustomerComponent } from './customer/customer.component';
import { CartComponent } from './customer/cart/cart.component';
import { ViewProductsComponent } from './customer/view-products/view-products.component';
import { ViewProfileComponent } from './customer/view-profile/view-profile.component';
import { UpdateProfileComponent } from './customer/update-profile/update-profile.component';
import { ErrorComponent } from './error/error.component';
import { CartService } from './cart.service';


//The purpose of a NgModule is to declare each thing you create in Angular
@NgModule({
  declarations: [
    AppComponent,
    RegistrationComponent,
    LoginComponent,
    AdminComponent,
    UpdateProductComponent,
    ShowProductsComponent,
    AddProductComponent,
    ProductFilterPipe,
    CustomerComponent,
    CartComponent,
    ViewProductsComponent,
    ViewProfileComponent,
   
    UpdateProfileComponent,
    ErrorComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [RegistrationService,AdminService,CartService],
  bootstrap: [AppComponent]
})
export class AppModule { }
