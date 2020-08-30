import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';
import { Router } from '@angular/router';
import { products } from '../products';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  product : products=new products();
  prodData:any[];

  constructor( private admin: AdminService,private router: Router) { }

  ngOnInit() {
    this.loadData();
     if(sessionStorage.getItem("role")!="admin"){
     this.router.navigate(["/login"]);
     }
     
  }

  loadData() {
    return this.admin.getProducts().subscribe((data: any) => {
      this.prodData = data;
    });
  }

  logout(){
  sessionStorage.removeItem("role");
    this.router.navigate(['/Login']);
  }



}
