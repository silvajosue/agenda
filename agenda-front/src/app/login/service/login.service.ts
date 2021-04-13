import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Login } from '../model/Login';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private urlBase: String = 'localhost:8080/agenda';

  constructor(private http: HttpClient) {
  }

  //Inicio dos estudos, espero que fique top hehe
  public login(login: Login): Observable<any>{
    return this.http.post<any>(this.urlBase + '/login', login);
  }
}
