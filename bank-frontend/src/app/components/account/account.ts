import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { BankService } from '../../services/bank.service';


@Component({
  selector: 'app-account',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './account.html',
  styleUrl: './account.css'
})
export class AccountComponent {

  name = '';
  accountId!: number;
  amount!: number;
  account: any;

  constructor(private bankService: BankService) {}

  createAccount() {
    this.bankService.createAccount({
      name: this.name,
      balance: this.amount
    }).subscribe(res => {
      this.account = res;
    });
  }

  getAccount() {
    this.bankService.getAccount(this.accountId).subscribe(res => {
      this.account = res;
    });
  }

  deposit() {
    this.bankService.deposit(this.accountId, this.amount).subscribe(res => {
      this.account = res;
    });
  }

  withdraw() {
    this.bankService.withdraw(this.accountId, this.amount).subscribe(res => {
      this.account = res;
    });
  }
}
