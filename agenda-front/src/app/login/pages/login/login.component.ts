import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Login } from '../../model/Login';
import { LoginService } from '../../service/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  formulario: FormGroup;
  login: Login = new Login();

  constructor(private formBuilder: FormBuilder, private service: LoginService) { }

  ngOnInit(): void {
    this.createForm();
  }

  public createForm(): void {
    this.formulario = this.formBuilder.group({
      username: [],
      password: []
    });
  }

  public entrar() {
    this.login.username = this.formulario.get('username').value;
    this.login.password = this.formulario.get('password').value;
    console.log(this.login);

    this.service.login(this.login).subscribe(
      sucesso => {
          console.log('logado');
      },
      erro => {
        console.log('falhou');
      }
    )
  }

  public cadastrar(): void {

  }
}
