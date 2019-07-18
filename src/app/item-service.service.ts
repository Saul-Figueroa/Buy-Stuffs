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
    return this._httpService.get("http://localhost:3000/Items/");
  }

  //4. Delete a Book
  deleteItem(itemId: number){
    return this._httpService.delete("http://localhost:3000/Items/" + itemId);
  }
}
