import { Component, OnInit } from '@angular/core';
import { CustomerService } from 'src/app/customer.service';
import { Router } from '@angular/router';
import { Key } from 'protractor';
import { customer } from 'src/app/customer';
import { RegistrationService } from 'src/app/registration.service';
import { CartService } from 'src/app/cart.service';
import { CustomerComponent } from '../customer.component';

@Component({
  selector: 'app-view-profile',
  templateUrl: './view-profile.component.html',
  styleUrls: ['./view-profile.component.css']
})
export class ViewProfileComponent implements OnInit {
profile:customer[];
customer: customer=new customer();

  constructor(private cust:CustomerService,private router: Router,private cart:CartService,private customerComponent:CustomerComponent,private register:RegistrationService) { }

  ngOnInit() {
    this.customer=new customer();
    this.loadMyProfile();
  }

  loadMyProfile(){

    console.log(JSON.parse(localStorage.getItem('Key')));
this.cust.findByEmailId(JSON.parse(localStorage.getItem('Key'))).subscribe((data:any) =>{
  console.log(data);
  this.profile=data;
},
);
  }

  updateButtonClicked(profile: customer) {
    this.customerComponent.customer= profile;
    this.customer = profile;
    this.router.navigate(["customer/update"]);
  }
}
