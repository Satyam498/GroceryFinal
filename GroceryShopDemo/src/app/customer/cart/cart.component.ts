import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CartService } from 'src/app/cart.service';
import { products } from 'src/app/products';
import { Cart } from 'src/app/cart';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  cartdata: Cart[];
 
 cart: Cart=new Cart();

  constructor(private router: Router,private cartservice:CartService) { }

  ngOnInit() {
     this.getCart(this.cart);
  }

  getCart(cart:Cart){
    console.log("inside mycart");
    return this.cartservice.getCart(JSON.parse(localStorage.getItem('Id'))).subscribe((data:any) =>{
      console.log(data);
      this.cartdata=data;
     }
     );
}
}