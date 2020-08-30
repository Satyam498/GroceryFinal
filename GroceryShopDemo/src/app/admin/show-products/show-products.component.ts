import { Component, OnInit } from '@angular/core';
import { products } from 'src/app/products';
import { AdminService } from 'src/app/admin.service';
import { Router } from '@angular/router';
import { AdminComponent } from '../admin.component';

@Component({
  selector: 'app-show-products',
  templateUrl: './show-products.component.html',
  styleUrls: ['./show-products.component.css']
})
export class ShowProductsComponent implements OnInit {
  product : products =new products();
  prodData:any[];
  searchTerm: string;
  selected: any;
  
  constructor( private admin: AdminService,
    private adminComp: AdminComponent,
    private router: Router) { }

  ngOnInit() {
    this.product = new products();
    this.loadData();
  }

  loadData() {
    return this.admin.getProducts().subscribe((data: any) => {
      this.prodData = data;
    });
  }

  updateButtonClicked(a: products) {
    console.log(a);
    this.adminComp.product = a;
    this.product = a;
    
    this.router.navigate(["admin/update"]);
  }

  delete(a: products) {
    alert("delete successfully");
    return this.admin.delete(a.productId).subscribe((data: any) => {
      this.prodData = data;
    });
    alert("delete successfully");
  }

}
