import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { JwtService } from 'src/app/utils/jwt.service';
import { Login } from '../model/Login';

@Injectable({
  providedIn: 'root'
})
export class LoginService extends JwtService{

  private urlBase: String = 'localhost:8080/agenda';

  constructor(private http: HttpClient) {
    super(http);
  }

  //Inicio dos estudos, espero que fique top hehe
  public login(login: Login): Observable<any>{
    return this.authenticate(login.username, login.password);
  }
}
