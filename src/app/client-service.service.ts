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
    return this._httpService.get("http://localhost:8090/Buy_Stuffs/client/clients/" + clientId);
  }

  // //4. Delete a Client
  // deleteClient(clientId: number){
  //   return this._httpService.delete("http://localhost:8090/Buy_Stuffs/client/clients/" + clientId);
  // }

  loginStatus(home: String) { //asynchronous "http://localhost:8090/Buy_Stuffs/LoginController/loginStatus?home=" + home
    console.log("Inside ClientServiceService with home value of " + home);
    return this._httpService.get("http://localhost:8090/Buy_Stuffs/LoginController/loginStatus?home=" + home);
  }

  loadHome() {
    var text = "";
    document.getElementById("load").innerHTML =text + "<div class=row>"+
    "<div class=\"col-sm-4\"> <!-- Sets column os span 4-->"+
     "<div class=\"card my-10\" style=\"width:400px\">"+
       "<img class=\"card-img-top\" src=\"https://buy-stuffs.s3.us-east-2.amazonaws.com/pokemon.gif\" alt=\"Card image\" style=\"width:100%\">"+
       "<div class=\"card-body\">"+
         "<h4 class=\"card-title\">User</h4>"+
         "<p class=\"card-text\">user@123.com</p>"+
       "</div>"+
    "</div>"+
    "</div>"+
    "<div id=\"section\" class=\"col-sm-8\">"+
      "<iframe width=\"1000px\" height=\"750px\" name=\"myframe\">"+
      "</iframe>"+
    "</div>"+
    "</div>";
  }

}