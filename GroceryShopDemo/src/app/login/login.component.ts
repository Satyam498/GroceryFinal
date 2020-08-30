import { Component, OnInit } from '@angular/core';
import { RegistrationService } from '../registration.service';
import { loginCredential } from '../loginCredential';
import { Router } from '@angular/router';
import { CartService } from '../cart.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  lc:loginCredential = new loginCredential();
  logincred_list:loginCredential[];
  userFound:boolean = false;
  
  result;

  constructor(private service:RegistrationService,private router: Router,private cart:CartService) { }

  ngOnInit(): void {
    this.service.getAllCredentials().subscribe(data =>{this.logincred_list = data});
  }

  login(){console.log("Inside login");
  console.log(this.logincred_list);
  if(this.lc.username=="admin@gmail.com" && this.lc.password=="admin"){
    this.userFound = true;
    alert("admin login successfully");
    sessionStorage.setItem("role","admin");
    this.router.navigate(['/admin/show']);
  }
  else{
    this.logincred_list.forEach(cred => {
      if(cred.username==this.lc.username){
        if(cred.password==this.lc.password){
          this.userFound = true;
         
         this.service.userId = cred.userId;
         localStorage.setItem('Id', JSON.stringify(cred.userId));
                  localStorage.setItem('Key', JSON.stringify(cred.username));
         
          sessionStorage.setItem("role","user");
           console.log(sessionStorage.getItem("role"));
        //  sessionStorage.setItem("role",String(cred.role));
          // console.log(sessionStorage.getItem("role"));
          // if(cred.role=="user")
          // this.router.navigate(['/customer/view']);
          // else
          // this.router.navigate(['/Admin']);
       this.router.navigate(['/customer/view']);
        
        }
      }
    });
  }
    if(!this.userFound)
      alert("Please enter valid credentials','Wrong Credentials");  
      //alert("user Not Found");
    
  }

}
