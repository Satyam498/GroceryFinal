import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { customer } from './customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http: HttpClient) { }

  public findByEmailId(email:string){
    console.log("Inside customer Service")
    return this.http.get<customer[]>('http://localhost:5555/User/findbyemail/'+email);
  }

  updateUser(customer,userId:number) {
    return this.http.put<customer>('http://localhost:5555/User/update/'+userId,customer);

  }
}
