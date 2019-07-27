import { Injectable } from '@angular/core';
import { Client } from './client/client';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { setInjectImplementation } from '@angular/core/src/di/injector_compatibility';

@Injectable({
  providedIn: 'root'
})
export class ContextService {

    constructor(){}

    private tokenKeyRole:string = "tokenKeyRole";
    private tokenKeyFullName:string = "tokenKeyFullName";
    private tokenKeyEmail:string = "tokenKeyEmail";

    store(client:Client) {
        localStorage.setItem(this.tokenKeyRole, client.role);
        localStorage.setItem(this.tokenKeyFullName, client.firstName+" "+client.lastName);
        localStorage.setItem(this.tokenKeyEmail, client.email);
    }

    retrieveTokenRole() {
        let storedTokenRole:string = localStorage.getItem(this.tokenKeyRole);
        return storedTokenRole;
    }

    retrieveTokenFullName() {
        let storedTokenFullName:string = localStorage.getItem(this.tokenKeyFullName);
        return storedTokenFullName;
    }

    retrieveTokenEmail() {
        let storedTokenEmail:string = localStorage.getItem(this.tokenKeyEmail);
        return storedTokenEmail;
    }

    clear() {
        localStorage.removeItem(this.tokenKeyRole);
        localStorage.removeItem(this.tokenKeyFullName);
        localStorage.removeItem(this.tokenKeyEmail);
    }

    private client = new Client();

    setClient(client: Client) {
        this.client = client;
    }

    getClient():Client {
        return this.client;
    }

}