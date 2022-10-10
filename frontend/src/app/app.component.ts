import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  formCadastrarPessoa = false;


  cadastrarPessoa() {
    this.formCadastrarPessoa = true;
  }

  fecharFormCadastrarPessoa() {
    this.formCadastrarPessoa = false;
  }
}
