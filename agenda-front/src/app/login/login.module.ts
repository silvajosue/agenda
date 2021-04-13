import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LoginComponent } from './pages/login/login.component';
import {InputTextModule} from 'primeng-lts/inputtext';
import {CardModule} from 'primeng-lts/card';
import {ButtonModule} from 'primeng-lts/button';
import {FieldsetModule} from 'primeng-lts/fieldset';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LoginRoutingModule } from './login-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { LoginService } from './service/login.service';



@NgModule({
  declarations: [LoginComponent],
  imports: [
    CommonModule,
    LoginRoutingModule,
    HttpClientModule,
    CardModule,
    FieldsetModule,
    FormsModule,
    InputTextModule,
    ReactiveFormsModule,
    ButtonModule
  ],
  providers: [LoginRoutingModule, LoginService],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class LoginModule { }
