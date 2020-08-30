import { Component, OnInit } from '@angular/core';
import { products } from '../products';
import { AdminService } from '../admin.service';
import { Router } from '@angular/router';
import { CartService } from '../cart.service';
import { customer } from '../customer';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
  proddata: products[];
  product: products;
  searchTerm: string;
  selected: any;
  customer : customer =new customer();
 
  constructor(private admin: AdminService,
    private router: Router,private cart:CartService) 
      { }

  ngOnInit() {
   
    this.loadData();
    // if(sessionStorage.getItem("role")!="user"){
    //   this.router.navigate(["/login"])
    //}
  }


  loadData() {
    return this.admin.getProducts().subscribe((data: any) => {
      this.proddata = data;
    });
  }

  logout(){
    sessionStorage.removeItem("role");
    this.router.navigate(['/Login']);
  }

}
