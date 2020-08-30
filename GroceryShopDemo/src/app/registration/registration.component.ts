import { Component, OnInit } from '@angular/core';
import { customer } from 'src/app/customer';
import { loginCredential } from 'src/app/loginCredential';

import {Router} from "@angular/router"
import { RegistrationService } from '../registration.service';
@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  usr:customer = new customer();
  lc:loginCredential = new loginCredential();
  abc:any;
  userId:any;
  constructor(private service:RegistrationService,private router: Router) { }

  ngOnInit(): void {
    //this.usr = new user();
  }

  addNewUser(){
    console.log(this.usr);
    if(this.usr.mobile==null||this.usr.address==null||this.usr.fname==null||this.usr.lname==null
      ||this.usr.mobile==""||this.usr.address==""||this.usr.fname==""||this.usr.lname==""||
      !this.usr.mobile.match("^((\\+91-?)|0)?[0-9]{10}$") || !this.usr.address.match("[a-zA-Z ]*") ||
       !this.usr.fname.match("[a-zA-Z ]*") || !this.usr.lname.match("[a-zA-Z ]*") || !this.usr.email.match("^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$")){
      console.log(this.usr);
       
    }
    else{
      this.abc = this.service.addUser(this.usr)
        .subscribe( data => {
        });
        console.log(this.usr);
    this.lc.username = this.usr.email;
   //this.lc.role="user";
    this.service.addLoginCredentials(this.lc)
        .subscribe(data => {
          alert("registration succefully");  
            this.router.navigate(['Login'])
          });
    }
  }

  

}
