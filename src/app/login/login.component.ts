import { Component, OnInit } from '@angular/core';
import { Client } from '../client/client';
import { ClientServiceService } from '../client-service.service';
import { Router } from '@angular/router';
import { ContextService } from '../context.service';
import { AppComponent } from '../app.component'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  private email;
  private password;
  clientToLog = new Client();
  loggedClient = new Client();
  statusMessage:string;

  constructor(
    private router:Router,
    private _clientService:ClientServiceService,
    public _appComponent:AppComponent,
    private _contextService:ContextService
  ) { }

  ngOnInit() {
    console.log("login Init role: "+this._contextService.retrieveTokenRole()); 
    if (this._contextService.retrieveTokenRole() != null) {
      this.router.navigateByUrl('home');
    }
  }

  loginSubmit() {
    console.log("Email: "+this.clientToLog);

    this._clientService.loginAuthentication(this.clientToLog).subscribe((clientData) => {
        this.loggedClient = <Client>clientData; this.loginAuthorization(this.loggedClient);
      }
    ),
    (error) => {
      console.log(error);
      this.statusMessage = "Problem with service. Please try again later.";
    }
  }

  loginAuthorization(client: Client){
    if (client != null) {
      this._contextService.store(client);
      console.log("Set Client");
      console.log(this.loggedClient);
      this.router.navigateByUrl('home')
    } else {
      this.reset();
    }
  }

  private reset(){
    this.clientToLog.email = null;
    this.clientToLog.password = null;
  }

}
