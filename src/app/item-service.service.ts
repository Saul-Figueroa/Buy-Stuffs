import { Injectable } from '@angular/core';
import { Item } from './item/item';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ItemServiceService {

  constructor(private _httpService: HttpClient) {}
  getItems(): Observable<any>{ //asynchronous
    return this._httpService.get("http://localhost:3000/items/");
  }
   //2. add a new item

   addItem(item: Item)
   {
     let body = JSON.parse(JSON.stringify(item));
 
     return this._httpService.post("http://localhost:3000/Items/", body);
   }

  //4. Delete a Item
  deleteItem(itemId: number){
    return this._httpService.delete("http://localhost:3000/Items/" + itemId);
  }


}
