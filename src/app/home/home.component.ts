import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ClientServiceService } from '../client-service.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private _clientService:ClientServiceService) { }

  statusMessage: String;

  viewHome():void{
    this._clientService.viewHome().
    subscribe((clientData) => this.statusMessage = "Success",
                             (error) =>{console.log(error);
                             this.statusMessage = "Problem with service. Please try again later!";
                            }
    );
  }

  ngOnInit() {
    this.viewHome();
  }

}
