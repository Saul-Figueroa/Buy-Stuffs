import { Component, OnInit } from '@angular/core';
<<<<<<< HEAD
import { ItemServiceService } from '../item-service.service';
import { Item } from './item';
=======
import {ItemServiceService} from '../item-service.service';
import {Item} from './item';
>>>>>>> 3f2bb87ff4400731150c9cfa99fe422a55182a03

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.css']
})
export class ItemComponent implements OnInit {


  items:Item[];
  statusMessage:string;
  item = new Item();

  ngOnInit() {
    this.getItems();
  }

  getItems():void{
   
  }
}
