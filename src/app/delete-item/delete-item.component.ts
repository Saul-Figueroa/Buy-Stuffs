import { Component, OnInit } from '@angular/core';
import { Item } from '../item/item';
import { ItemServiceService } from '../item-service.service';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-delete-item',
  templateUrl: './delete-item.component.html',
  styleUrls: ['./delete-item.component.css']
})
export class DeleteItemComponent implements OnInit {
  constructor(private _itemService:ItemServiceService) {}

  // 1. Get all items
  getItems():void{
    this._itemService.getItems().
    subscribe((itemData) => this.items = itemData,
                             (error) =>{console.log(error);
                             this.statusMessage = "Problem with service. Please try again later!";
                            }
    );
  }


   //4. Delete a Item
   deleteItem(itemId):void{
    this._itemService.deleteItem(itemId).
    subscribe((response) => {console.log(response);
                            this.getItems();
                            },
                            (error) => {
                              console.log(error);
                              this.statusMessage = "Problem with service. Please try again later.";
                            }
            );
  }
  // 1. Create empty items array
  public items:Item[]=[];

  statusMessage:String;
  item = new Item();

  // 2. Create service object-------------commented to allow for HttpClient
  // constructor(private _itemService:ItemServiceService) { }

  // 3. return item array
  ///////////////Commented because I took in other getItems method
  // getItems():Item[]{
  //   return this.items;
  // }

  // 4. Call service method and assign the result in items array
  ngOnInit() {
    this.getItems();
  }

  // Delete method-----------------------commented cuz tried again above
  // deleteItem(id:number){
  //   this._itemService.deleteItem(id).subscribe((response) => {console.log(response);
  //                                                            this.getItems();
  //                                                             },
  //                                                             (error) => {
  //                                                               console.log(error);
  //                                                               this.statusMessage = "Problem with service. Please try again later.";
  //                                                             }
  //                                             );
  // }

}
