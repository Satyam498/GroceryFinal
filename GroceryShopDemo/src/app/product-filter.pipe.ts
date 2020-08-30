import { Pipe, PipeTransform } from '@angular/core';
import { products } from './products';

@Pipe({
  name: 'productFilter'
})
export class ProductFilterPipe implements PipeTransform {
  transform(prodData: products[], searchTerm: string, selected: string ): products[] {
    if (!prodData || !searchTerm || !selected) {
        return prodData;
    }
    else if(selected=="Product Id") {
      return prodData.filter(prodData=>
          String(prodData.productId).toLowerCase().indexOf(searchTerm.toLowerCase()) !== -1);
    }
    else if( selected=="Product Name") {
      return prodData.filter(prodData =>
        prodData.productName.toLowerCase().indexOf(searchTerm.toLowerCase()) !== -1);
    }
   
    else if(selected=="Category") {
      return prodData.filter(prodData =>
        prodData.productCategory.toLowerCase().indexOf(searchTerm.toLowerCase()) !== -1);
    }


}
}
