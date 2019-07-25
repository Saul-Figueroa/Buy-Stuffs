import { Component, OnInit } from '@angular/core';
import { ClientServiceService } from '../client-service.service';

@Component({
  selector: 'app-home-manager',
  templateUrl: './home-manager.component.html',
  styleUrls: ['./home-manager.component.css']
})
export class HomeManagerComponent implements OnInit {

  constructor(private _clientService:ClientServiceService) { }

  ngOnInit() {
    console.log("OnInit method reached");
    this.loginStatus();
  }

  loginStatus() {
    this._clientService.loginStatus("MANAGER");
  }

}
