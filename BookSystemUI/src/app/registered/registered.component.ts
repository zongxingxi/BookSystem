import { Component, OnInit } from '@angular/core';
import { Headers, Http } from '@angular/http';
import { Router } from '@angular/router';
import { herf } from './../herf';

@Component({
  selector: 'app-registered',
  templateUrl: './registered.component.html',
  styleUrls: ['./registered.component.css']
})
export class RegisteredComponent implements OnInit {

  registeredStudentID: string = '';
  registeredPasswordSec: string = '';
  registeredPassword: string = '';
  warningInfo: string = '';
  constructor(private http: Http, private router: Router) { }

  ngOnInit() {
  }

  onSubmit(): void {
    if (this.registeredPassword !== this.registeredPasswordSec) {
      this.warningInfo = "密码两次输入不一致";
      return;
    }

    let headers = new Headers({ 'studyId': this.registeredStudentID, 'password': this.registeredPassword, 'Access-Control-Allow-Origin': '*' });
    this.http.put(herf + "booksystem/registered", { headers: headers })
      .toPromise()
      .then(response => {
        this.CheckResponse(response.text());
      });
  }

  private CheckResponse(result: string): void {
    if (!result) {
      this.warningInfo = "注册失败";
      return;
    }

    this.warningInfo = "注册成功，自动跳转中";
    setTimeout(()=>{this.router.navigate(["/login"])}, 2000);
  }
}
