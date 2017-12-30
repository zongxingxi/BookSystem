import { Component, OnInit } from '@angular/core';
import { herf } from './../herf';
import { Headers, Http } from '@angular/http';
import { Router } from '@angular/router';
import 'rxjs/add/operator/toPromise';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  studyId: string = '';
  password: string = '';
  userExits: boolean = true;
  readonly warningInfo: string = '账号不存在请先注册';

  constructor(private http: Http, private router: Router) { }

  ngOnInit() {

  }

  onSubmit() {
    if (!this.studyId || !this.password) {
      return;
    }

    // console.info(this.studyId);
    // console.info(this.password);

    let headers = new Headers({ 'studyId': this.studyId, 'password': this.password });

    this.http.put(herf + "booksystem/login", '', { headers: headers })
      .toPromise()
      .then(response => {
        this.CheckLoginStatus(response.text());
      });
  }

  private CheckLoginStatus(result: String) {
    let LowerCaseResult = result.toLowerCase();
    if (LowerCaseResult === "true") {
      this.router.navigate(["/main-page"]);
    }
    else {
      //请先注册
      this.userExits = false;
    }
  }

}
