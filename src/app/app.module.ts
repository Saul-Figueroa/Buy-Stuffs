import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ItemComponent } from './item/item.component';
import { ItemListComponent } from './item-list/item-list.component';
import { HomeComponent } from './home/home.component';
import { DeleteItemComponent } from "./delete-item/delete-item.component";
import { FormsModule } from '@angular/forms';
import { ItemServiceService } from './item-service.service';
import { ClientComponent } from './client/client.component';
import { LoginComponent } from './login/login.component';



@NgModule({
  declarations: [
    AppComponent,
    ItemComponent,
    ItemListComponent,
    HomeComponent,
    DeleteItemComponent,
    ClientComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    // import HttpClientModule after BrowserModule.
    HttpClientModule,
    FormsModule
  ],
  providers: [ItemServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
