import { Injectable } from '@angular/core';
import { Client } from './client/client';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ClientServiceService {

  constructor(private _httpService: HttpClient) {}
  // 1. get all clients
  getClients(): Observable<any>{ //asynchronous
    return this._httpService.get("http://localhost:8090/Buy_Stuffs/client/clients");
  }
  // 2. add a new client
   addClient(client: Client)
   {
     let body = JSON.parse(JSON.stringify(client));
 
     return this._httpService.post("http://localhost:8090/Buy_Stuffs/client/clients/", body);
   }

   // 3. Get an client
  getClientById(clientId: number): Observable<any>{
    return this._httpService.get("http://localhost:8090/Buy_Stuffs/client/clients/" + clientId)
  }

  //4. Delete a Client
  deleteClient(clientId: number){
    return this._httpService.delete("http://localhost:8090/Buy_Stuffs/client/clients/" + clientId);
  }

  viewHome() { //asynchronous
    return this._httpService.get("http://localhost:8090/Buy_Stuffs/LoginController/home");
  }


}