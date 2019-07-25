import { Component, OnInit } from '@angular/core';
import { ClientServiceService } from '../client-service.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private _clientService:ClientServiceService) { }

  ngOnInit() {
    console.log("OnInit method reached");
    // this.loginStatus();
    this.loadHome();
  }

  loginStatus() {
    this._clientService.loginStatus("CUSTOMER").subscribe((response) => {console.log(response);
                                                                        if (response != null) {
                                                                        window.location.assign(response.toString())}
                                                                        });
  }

  loadHome() {
    this._clientService.loadHome();
  }

}
