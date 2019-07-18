import { Component, OnInit } from '@angular/core';
import {ItemServiceService} from '../item-service.service';
import {Item} from './item';

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.css']
})
export class ItemComponent implements OnInit {

  items:Item[]; //creating a items array
  statusMessage: string;
  item = new Item(); 

  constructor(private _itemService:ItemServiceService) { }

  ngOnInit() {

  }

  //---------add item---------

  addItem(): void{
   this._itemService.addItem(this.item).subscribe((response) => {console.log(response);
   }
   );
  }

}
