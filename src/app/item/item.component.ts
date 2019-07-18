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

  ngOnInit() {
    this.getItems();
  }

  getItems():void{
   
  }


}
