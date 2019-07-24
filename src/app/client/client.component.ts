import { Component, OnInit } from '@angular/core';
import { Client } from '../client/client';
import { ClientServiceService } from '../client-service.service';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css']
})
export class ClientComponent implements OnInit {

  constructor(private _clientService:ClientServiceService) { }

  ngOnInit() {
    this.getClients();
  }

  public clients:Client[]=[];
  statusMessage:String;
  client = new Client();

  getClients():void{
    this._clientService.getClients().
    subscribe((clientData) => this.clients = clientData,
                             (error) =>{console.log(error);
                             this.statusMessage = "Problem with service. Please try again later!";
                            }
    );
  }

  deleteClient(clientId):void{
    this._clientService.deleteClient(clientId).
    subscribe((response) => {console.log(response);
                            this.getClients();
                            },
                            (error) => {
                              console.log(error);
                              this.statusMessage = "Problem with service. Please try again later.";
                            }
            );
  }

  addClient(): void{

    this._clientService.addClient(this.client).subscribe((response) => {console.log(response);

    } );

    this.reset();
  }

  private reset(){
    
    this.client.firstName = null;
    this.client.lastName = null;
    this.client.email = null;
    this.client.password = null;
    this.client.role = null;
  }

}
