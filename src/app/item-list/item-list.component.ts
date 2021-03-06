import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Item } from '../item/item';
import { ItemServiceService } from '../item-service.service';

@Component({
  selector: 'app-item-list',
  templateUrl: './item-list.component.html',
  styleUrls: ['./item-list.component.css']
})
export class ItemListComponent implements OnInit {
  
  constructor(private httpService: HttpClient) { }
  public items:Item[]; 

  


  ngOnInit() {
    this.getItems();
  }

  getItems():Item[]{
      return this.items;
  }

}
