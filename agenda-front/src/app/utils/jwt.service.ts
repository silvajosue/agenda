import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})

export class JwtService {

  constructor(private httpClient: HttpClient) {}
  
    authenticate(username, password) {
      return this.httpClient
        .post<any>("http://localhost:8080/agenda/login", { username, password })
        .pipe(
          map(userData => {
            sessionStorage.setItem("username", username);
            let tokenStr = "Bearer " + userData.token;
            sessionStorage.setItem("token", tokenStr);
            return userData;
          })
        );
    }
  
    isUserLoggedIn() {
      let user = sessionStorage.getItem("username");
      console.log(!(user === null));
      return !(user === null);
    }
  
    logOut() {
      sessionStorage.removeItem("username");
    }
}