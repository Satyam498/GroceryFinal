import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { products } from './products';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http: HttpClient) { 

  }

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

 

  getProducts(): Observable<products> {
    return this.http.get<products>('http://localhost:9111/Product/getProducts');
    
  }

  delete(productId: number) {

    return this.http.delete<products>('http://localhost:9111/Product/delete/'+productId);
  }

  addProduct(products) {
    return this.http.post<products>('http://localhost:9111/Product/add',products);
  }
  
  updateProduct(products,productId:number) {
    return this.http.put<products>('http://localhost:9111/Product/update/'+productId,products);

  }
  public searchProductbyCategory(productCategory: String){
    return this.http.get<products[]>('http://localhost:9111/Product/search/'+productCategory);
  }


  findById(productId:number){
    return this.http.get<products>('http://localhost:9111/Product'+productId);
  }


  deleteAll(){
    console.log("inside deleteall");
    return this.http.delete<products>('http://localhost:9111/Product');
  }




 
}
