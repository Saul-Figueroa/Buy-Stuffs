import { Component, OnInit } from '@angular/core';
import { ClientServiceService } from '../client-service.service';

@Component({
  selector: 'app-home-vendor',
  templateUrl: './home-vendor.component.html',
  styleUrls: ['./home-vendor.component.css']
})
export class HomeVendorComponent implements OnInit {

  constructor(private _clientService:ClientServiceService) { }

  ngOnInit() {
    console.log("OnInit method reached");
    this.loginStatus();
  }

  loginStatus() {
    this._clientService.loginStatus("VENDOR");
  }

}
