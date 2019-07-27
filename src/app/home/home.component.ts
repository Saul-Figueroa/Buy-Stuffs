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
    console.log("Home OnInit method reached");
    console.log("loadHome role: "+this._contextService.retrieveTokenRole());
    this.loadHome(this._contextService.retrieveTokenRole());
  }

  loadHome(role:String) {
    let name:string = this._contextService.retrieveTokenFullName();
    let email:string = this._contextService.retrieveTokenEmail();
    if (role == "MANAGER") {
      this._clientService.loadHomeManager(name, email);
    } else if (role == "VENDOR") {
      this._clientService.loadHomeVendor(name, email);
    } else if (role == "CUSTOMER") {
      this._clientService.loadHomeCustomer(name, email);
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
