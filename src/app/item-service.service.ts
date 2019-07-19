import { Injectable } from '@angular/core';
import { Item } from './item/item';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ItemServiceService {

  constructor(private _httpService: HttpClient) {}
  // 1. get all items
  getItems(): Observable<any>{ //asynchronous
    return this._httpService.get("http://localhost:8090/Buy_Stuffs/item/items");
  }
  // 2. add a new item
   addItem(item: Item)
   {
     let body = JSON.parse(JSON.stringify(item));
 
     return this._httpService.post("http://localhost:8090/Buy_Stuffs/item/items/", body);
   }

   // 3. Get an item
  getItemById(itemId: number): Observable<any>{
    return this._httpService.get("http://localhost:8090/Buy_Stuffs/item/items/" + itemId)
  }

  //4. Delete a Item
  deleteItem(itemId: number){
    return this._httpService.delete("http://localhost:8090/Buy_Stuffs/item/items/" + itemId);
  }


}
// http://localhost:3000/Items/
// http://localhost:8090/Rev_SpringMVC_Hello/api/items
// http://localhost:8090/Buy_Stuffs/item/items/