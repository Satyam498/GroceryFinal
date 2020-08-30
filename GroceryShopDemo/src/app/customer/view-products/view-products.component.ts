import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/admin.service';
import { Router } from '@angular/router';
import { CartService } from 'src/app/cart.service';
import { products } from 'src/app/products';
import { FormBuilder, FormGroup, FormControl } from '@angular/forms';
import { CustomerService } from 'src/app/customer.service';
import { customer } from 'src/app/customer';
import { Cart } from 'src/app/cart';

@Component({
  selector: 'app-view-products',
  templateUrl: './view-products.component.html',
  styleUrls: ['./view-products.component.css']
})
export class ViewProductsComponent implements OnInit {
  proddata: products[];
  product: products;
  profile: customer[];
  cartData:any[];
  qty:any;
    searchTerm: string;
  selected: any;
  constructor(private admin: AdminService,
    private router: Router,private cartService:CartService,private formBuilder: FormBuilder,private customerService:CustomerService) { 
      this.qtyForm = new FormGroup({
        productQuantity: new FormControl(),
        productName: new FormControl()

        });
    }

  ngOnInit() {
    this.product = new products();
    this.loadData();
    if(sessionStorage.getItem("role")!="user"){
      this.router.navigate(["/login"]);
    }
    
  }

  qtyForm = this.formBuilder.group({
    
    productPrice: ['']
  
 });

 

  loadData() {
    return this.admin.getProducts().subscribe((data: any) => {
      this.proddata = data;
    });
  }



  
 public addtoCart(a: Cart)
   {

   console.log(JSON.parse(localStorage.getItem('Key'))) ;
    this.customerService.
  findByEmailId(JSON.parse(localStorage.getItem('Key'))).subscribe(data =>{
    this.profile=data;
  });

  if(this.qtyForm.get('productQuantity').value<=0 || this.qtyForm.get('productQuantity').value==null){
    alert("Quantity should not be null or less than one");
  }
  else{
    this.qty=this.qtyForm.get('productQuantity').value;
    
    this.cartService.cart.productName=this.qtyForm.get('productName').value;
    this.cartService.cart.productName= a.productName;
    this.cartService.cart.productId = a.productId;
    this.cartService.cart.productPrice = a.productPrice;
    
    this.cartService.cart.quantity=this.qty;
    this.cartService.cart.customerId =this.cartService.idAfterLogin;

    this.cartService.
    addCart(JSON.parse(localStorage.getItem('Key')),this.cartService.cart.productId,this.cartService.cart.quantity)
    .subscribe(data => {
    
  },
  );
}
   }
}
