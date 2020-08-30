import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { AdminComponent } from './admin/admin.component';
import { UpdateProductComponent } from './admin/update-product/update-product.component';
import { ShowProductsComponent } from './admin/show-products/show-products.component';
import { AddProductComponent } from './admin/add-product/add-product.component';
import { CustomerComponent } from './customer/customer.component';
import { CartComponent } from './customer/cart/cart.component';
import { ViewProductsComponent } from './customer/view-products/view-products.component';
import { ViewProfileComponent } from './customer/view-profile/view-profile.component';
import { UpdateProfileComponent } from './customer/update-profile/update-profile.component';
import { ErrorComponent } from './error/error.component';

const routes: Routes = [];

@NgModule({
  imports: [RouterModule.forRoot([
    {path: '',redirectTo: "/Login", pathMatch: 'full'},
  
  {path:'Login',component:LoginComponent},
  {path:'Register',component:RegistrationComponent},
 
  {path:'customer',
    component:CustomerComponent,
  children: [
    {path: "view", component:ViewProductsComponent},
    {path: "cart", component:CartComponent},
    {path: "profile", component:ViewProfileComponent},
    {path:"update" , component:UpdateProfileComponent}
    
   
  ],
},
  {path: "admin",
        component: AdminComponent,
        children: [
          { path: "update", component: UpdateProductComponent },
          { path: "show", component: ShowProductsComponent },
          { path: "add", component: AddProductComponent }
          
        ]
      },

   { path: "**", component: ErrorComponent },

  ])],
  exports: [RouterModule]
})
export class AppRoutingModule { }
