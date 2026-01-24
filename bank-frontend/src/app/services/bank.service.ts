import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class BankService {

  private baseUrl = 'http://localhost:8080/api/bankchor';

  constructor(private http: HttpClient) {}

  createAccount(data: any) {
    console.log('Creating account', data);
    return this.http.post(this.baseUrl, data);
  }

  getAccount(id: number) {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  deposit(id: number, amount: number) {
    return this.http.post(`${this.baseUrl}/${id}/deposit`, { amount });
  }

  withdraw(id: number, amount: number) {
    return this.http.post(`${this.baseUrl}/${id}/withdraw`, { amount });
  }
}
