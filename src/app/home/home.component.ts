import { Component, OnInit } from '@angular/core';
import { ClientServiceService } from '../client-service.service';
import { ContextService } from '../context.service';
import { Client } from '../client/client';
import { AppComponent } from '../app.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(
    private _clientService:ClientServiceService,
    public _appComponent:AppComponent,
    private _contextService:ContextService,
    private router:Router
  ) { }

  ngOnInit() {
    // this._clientService.getClients();
    // viewProfile();
    console.log("Home OnInit method reached");
    // this.loginStatus();
    console.log("loadHome role: "+this._contextService.retrieve())
    this.loadHome(this._contextService.retrieve());
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
    } else if (role == "CUSTOMER") {
      this._clientService.loadHomeCustomer();
    } else {
      this.router.navigateByUrl('login');
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
