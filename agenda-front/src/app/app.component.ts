import { Component, OnInit } from '@angular/core';
import { MenuItem } from 'primeng-lts/api/menuitem';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'agenda';
  items: MenuItem[];

  ngOnInit() {
    this.items = [
      {
        label: 'Login',
        icon: 'pi pi-fw pi-plus',
        routerLink: 'login'
      },
    ]
  }
}
