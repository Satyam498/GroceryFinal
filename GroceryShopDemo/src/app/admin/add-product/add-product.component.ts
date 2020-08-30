import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/admin.service';
import { Router } from '@angular/router';
import { products } from 'src/app/products';
import { AdminComponent } from '../admin.component';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {
  product : products=new products();
  prodData:any[];

  constructor(private admin: AdminService,private router: Router,private adminComp: AdminComponent) { }

  ngOnInit() {
  }
  add(){
    this.admin.addProduct(this.product).subscribe((data)=>{
     alert("added successfully"); 
      this.router.navigate(['/admin/show']);
    })
    this.prodData.push(this.product);
    }
}
