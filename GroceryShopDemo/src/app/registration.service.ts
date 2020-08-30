import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { customer } from 'src/app/customer';
import { loginCredential } from './loginCredential';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {
  userId:number;
  constructor(private http:HttpClient) { } 

  public addUser(usr:customer){
    console.log("inside addUser()"+usr);
    return this.http.post<customer>("http://localhost:5555/User/add",usr);
  }

  public addLoginCredentials(lc:loginCredential){
    console.log("inside addLoginCredentials()");
    return this.http.post<loginCredential>("http://localhost:4444/Login/AddLogin",lc);
  }


  public getAllCredentials() {
    return this.http.get<loginCredential[]>("http://localhost:4444/Login/getall");
  }

}
