import { Component } from '@angular/core';
import { ContextService } from './context.service';
import { Client } from './client/client';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Buy-Stuffs';
  
  constructor(private _contextService:ContextService){ }

  client = new Client();

  // setClientRole(role:string) {
  //     this.client.role = role;
  //     var text = JSON.stringify(this.client);
  //     console.log(text);
  // }

  // getClientRole():string {
  //   var text = JSON.stringify(this.client);
  //   console.log(text);
  //   return this.client.role;
  // }

  // clearClient(client: Client) {
  //   this.client = null;
  //   var text = JSON.stringify(this.client);
  //   console.log(text);
  // }
  
  logout() {
    this._contextService.clear();
  }
}
