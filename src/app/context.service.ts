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

    private client = new Client();

    setClient(client: Client) {
        this.client = client;
    }

    getClient():Client {
        return this.client;
    }

}