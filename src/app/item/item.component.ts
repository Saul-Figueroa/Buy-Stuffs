import { Component, OnInit } from '@angular/core';
import { ItemServiceService } from '../item-service.service';
import { Item } from './item';

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.css']
})
export class ItemComponent implements OnInit {

  constructor(private _itemService:ItemServiceService) { }

  items:Item[];
  statusMessage:string;
  item = new Item();

  ngOnInit() {
    this.getItems();
  }

  getItems():void{
    this._itemService.getItems().
    subscribe((bookData) => this.items = bookData,
                             (error) =>{console.log(error);
                             this.statusMessage = "Problem with service. Please try again later!";
                            }
    );
  }

}
