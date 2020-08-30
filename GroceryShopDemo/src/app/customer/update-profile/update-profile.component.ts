import { Component, OnInit } from '@angular/core';
import { CustomerService } from 'src/app/customer.service';
import { Router } from '@angular/router';
import { CustomerComponent } from '../customer.component';
import { customer } from 'src/app/customer';
import { RegistrationService } from 'src/app/registration.service';

@Component({
  selector: 'app-update-profile',
  templateUrl: './update-profile.component.html',
  styleUrls: ['./update-profile.component.css']
})
export class UpdateProfileComponent implements OnInit {
  customer : customer=new customer();
  customerData:any[];
  cus:customer[];
  constructor( private customerservice:CustomerService,private router: Router,private customercomp:CustomerComponent,private register:RegistrationService) { }

  ngOnInit() {
    
    this.customer=new customer();
    this.loadData();

  }
 loadData() {
    
    this.customer = this.customercomp.customer;
   
  }

  update(up:customer){
    
    this.customerservice.updateUser(this.customer,this.register.userId ).subscribe((data: any) => {
      this.customerData = data;
      
      this.router.navigate(['/customer/profile']); 
    });
  }
}
