import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { products } from './products';
import { Cart } from './cart';
// @Injectable ensures that the compiler will generate the necessary metadata to create the class's dependencies when the class is injected. 
@Injectable({
  providedIn: 'root'
})
export class CartService {
idAfterLogin:any;
 
 cart : Cart=new Cart();
  constructor(private http: HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

 
 
  addCart(customer: any, product: any,quantity: any) {
   
    console.log("Insidee cart service");
    console.log('user email is ', customer);
 
    console.log('qty',quantity);
    console.log('product id is ', product);
    
   return this.http.post<any>(`http://localhost:2222/add?email=${customer}&quantity=${quantity}&productId=${product}`,{});
   
  }

  getCart(customerId: number) {
    console.log('id is ', customerId);
    return this.http.get<Cart>(`http://localhost:2222/findById/`+customerId);
  }

  

}

