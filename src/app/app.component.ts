import { Component, OnInit } from '@angular/core';
import { ContextService } from './context.service';
import { Client } from './client/client';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'Buy-Stuffs';
  
  constructor(private _contextService:ContextService,
              private router:Router){ }

  ngOnInit() {
    console.log("AppComponent OnInit method reached");
    // console.log("loadApp role: "+this._contextService.retrieveTokenRole());
    // this.loadApp(this._contextService.retrieveTokenRole());
  }

  // loadApp(role:String) {
  //   if (role == "MANAGER") {
  //     console.log("routerLink is: " + document.getElementById("addItem").getAttribute("routerLink"));
  //     window.onload = function(){
  //     document.getElementById("m addItem").setAttribute("routerLink", "showClientList");}
  //     console.log("routerLink now is: " + document.getElementById("addItem").getAttribute("routerLink"));
      // console.log("Attribute might be: " + document.getElementById("addItem").set);
      // document.getElementById("addItem").setAttribute("routerLink", "showClientList")
    // } else if (role == "VENDOR") {
    //   this._clientService.loadHomeVendor(name, email);
    // } else if (role == "CUSTOMER") {
    //   this._clientService.loadHomeCustomer(name, email);
  //   } else {
  //     this.router.navigateByUrl('login');
  //   }
  // }

  // client = new Client();
  
  logout() {
    this._contextService.clear();
  }
}

// var text = "";
// text +="<meta charset=\"utf-8\">"+
// "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">"+
// "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\">"+
// "<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>"+
// "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\"></script>"+
// "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\"></script>"+
// "<nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\" >"+
//        "<a class=\"navbar-brand\" href=\"Home\">"+
//        "<img src=\"https://buy-stuffs.s3.us-east-2.amazonaws.com/stuffs_disscount.jpg\" style=\"position:absolute;left:150;top:10px; height:50px\"alt=\"BuyStuffs logo\">"+
//        "</a>"+
//        "<div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">"+
//                "<ul class=\"navbar-nav mr-auto\">"+
// "</ul>"+
// "<ul class=\"nav nav-tabs\">"+
// "<li routerLinkActive=\"active\" class=\"active p-3\">"+
// "<a href=\"login\" style=\"padding-left:100px; color: gray\">Login</a> </li>"+
// "<li routerLinkActive=\"active\" class=\"active p-3\">"+
//     "<a href=\"home\" style=\"padding-left:100px; color: gray\">Home</a> </li>"+
// "<li routerLinkActive=\"active\" class=\"active p-3\">"+
//     "<a routerLink=\"addItem\" style=\"padding-left:100px; color: gray\">Add Item</a>"+
// "</li>"+
// "<li routerLinkActive=\"active\" class=\"active p-3\">"+
//   "<a routerLink=\"showClientList\" style=\"padding-left:100px; color: gray\">Clients</a>"+
// "</li>"+
// "</ul>"+
// "<a href=\"login\">"+
//   "<button (click)=\"logout()\" class=\"btn btn-danger ml-4\">Log Out</button>"+
// "</a>"+
// "</div>"+
// "</nav>"+
// "<router-outlet></router-outlet>";
// window.onload = function(){
// document.open();
// document.write(text);
// document.close();}
