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

    private tokenKey:string = "notNull";

    store(client:Client) {
        localStorage.setItem(this.tokenKey, client.role);
    }

    retrieve() {
        let storedToken:string = localStorage.getItem(this.tokenKey);
        return storedToken;
    }

    clear() {
        localStorage.removeItem(this.tokenKey);
    }

    private client = new Client();

    setClient(client: Client) {
        this.client = client;
    }

    getClient():Client {
        return this.client;
    }

}