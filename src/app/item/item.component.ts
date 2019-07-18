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

  getItems():void{
    this._itemService.getItems().
    subscribe((itemData) => this.items = itemData,
                             (error) =>{console.log(error);
                             this.statusMessage = "Problem with service. Please try again later!";
                            }
    );
  }


}
