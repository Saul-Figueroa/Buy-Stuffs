import { Component, OnInit } from '@angular/core';
import { ClientServiceService } from '../client-service.service';
import { ContextService } from '../context.service';
import { Client } from '../client/client';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(
    private _clientService:ClientServiceService,
    private _contextService:ContextService,
  ) { }

  ngOnInit() {
    // this._clientService.getClients();
    // viewProfile();
    console.log("Home OnInit method reached");
    // this.loginStatus();
    this.loadHome(this._contextService.getClient().role);
  }

  // loginStatus() {
  //   this._clientService.loginStatus("CUSTOMER").subscribe((response) => {console.log(response);
  //                                                                       if (response != null) {
  //                                                                       window.location.assign(response.toString())}
  //                                                                       });
  // // }

  loadHome(role:String) {
    if (role == "MANAGER") {
      this._clientService.loadHomeManager();
    } else if (role == "VENDOR") {
      this._clientService.loadHomeVendor();
    } else {
      this._clientService.loadHomeCustomer();
    }
  }

  
    
        
        
        // function viewProfile(){
        //     var xmlhttp = new XMLHttpRequest();
        //     xmlhttp.open("GET", "client/clients",true);
        //     xmlhttp.onreadystatechange=function() {
        //         if(xmlhttp.readyState == 4 && xmlhttp.responseText) {
        //             let data = JSON.parse(xmlhttp.responseText);
        //             console.log(xmlhttp.responseText);
        //             var text = "";
        //             if (data != null) {

        //                 text += "Welcome, "+data.firstName+"!";
        //                 document.getElementById("demo").innerHTML = text;
        //             }
        //         }
        //     }
        //     xmlhttp.send();
        

}
