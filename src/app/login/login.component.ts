import { Component, OnInit } from '@angular/core';
import { Client } from '../client/client';
import { ClientServiceService } from '../client-service.service';
import { Router } from '@angular/router';
import { ContextService } from '../context.service';

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
  statusMessage:String;

  constructor(
    private router:Router,
    private _clientService:ClientServiceService,
    private _contextService:ContextService
  ) { }

  ngOnInit() {
    if (this._contextService.getClient().firstName != null) {
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

  loginAuthorization(loggedClient: Client){
    if (this.loggedClient != null) {
      const client = this.loggedClient;
      this._contextService.setClient(client);
      console.log("Set Client");
      console.log(this.loggedClient);
      this.router.navigateByUrl('home')
    }
  }

}
