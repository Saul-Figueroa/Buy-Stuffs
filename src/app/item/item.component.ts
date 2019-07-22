import { Component, OnInit } from '@angular/core';
import { ItemServiceService } from '../item-service.service';
import { Item } from './item';

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.css']
})
export class ItemComponent implements OnInit {


  items:Item[];
  statusMessage:string;
  item = new Item();

  constructor(private _itemService:ItemServiceService){}


  ngOnInit() {
    this.getItems();
  }

  //Add an item
  addItem(): void{

    this._itemService.addItem(this.item).subscribe((response) => {console.log(response);

    } );

    
    this.refresh();
  }

  getItems():void{
    this._itemService.getItems().
    subscribe((itemData) => this.items = itemData,
                             (error) =>{console.log(error);
                             this.statusMessage = "Problem with service. Please try again later!";
                            }
    );
  }

  refresh(): void {
    window.location.reload();
}


  private reset(){
    
    this.item.name = null;
    this.item.description = null;
    this.item.price = null;
    this.item.quantity = null;
  }


}
