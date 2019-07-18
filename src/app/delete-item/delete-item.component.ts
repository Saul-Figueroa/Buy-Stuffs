import { Component, OnInit } from '@angular/core';
import { Item } from '../item/item';
import { ItemServiceService } from '../item-service.service';

@Component({
  selector: 'app-delete-item',
  templateUrl: './delete-item.component.html',
  styleUrls: ['./delete-item.component.css']
})
export class DeleteItemComponent implements OnInit {

  // 1. Create empty items array
  public items:Item[]=[];

  statusMessage:String;
  item = new Item();

  // 2. Create service object
  constructor(private _itemService:ItemServiceService) { }

  // 3. return item array
  getItems():Item[]{
    return this.items;
  }

  // 4. Call service method and assign the result in items array
  ngOnInit() {
    this._itemService.getItems();
  }

  // Delete method
  deleteItem(id:number){
    this._itemService.deleteItem(id).subscribe((response) => {console.log(response);
                                                             this.getItems();
                                                              },
                                                              (error) => {
                                                                console.log(error);
                                                                this.statusMessage = "Problem with service. Please try again later.";
                                                              }
                                              );
  }

}
