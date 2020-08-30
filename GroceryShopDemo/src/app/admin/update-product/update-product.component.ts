import { Component, OnInit } from '@angular/core';
import { products } from 'src/app/products';
import { AdminService } from 'src/app/admin.service';
import { Router } from '@angular/router';
import { AdminComponent } from '../admin.component';

@Component({
  selector: 'app-update-product',
  templateUrl: './update-product.component.html',
  styleUrls: ['./update-product.component.css']
})
export class UpdateProductComponent implements OnInit {
  product : products=new products();
  prodData:any[];
  constructor( private admin: AdminService,private router: Router,private adminComp: AdminComponent) { }

  ngOnInit() {
    this.product = new products();
    this.loadData();
  }
  update(up:products){
    this.admin.updateProduct(this.product, up.productId).subscribe((data: any) => {
      this.prodData = data;
      console.log("updated");
      this.router.navigate(['/admin/show']); 
    });
  }
  loadData() {
    
    this.product = this.adminComp.product;
   
  }
}
