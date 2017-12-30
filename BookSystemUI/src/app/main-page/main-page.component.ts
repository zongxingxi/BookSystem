import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';
import { herf } from './../herf';

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit {

  display: string = '';
  constructor(private http: Http) { }

  ngOnInit() {
    this.http.get(herf + "booksystem/sessionTest")
    .toPromise()
    .then((response)=>{
      console.info(this.display = response.text())
    })
  }

}
