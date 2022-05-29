import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TranslateModule } from '@ngx-translate/core';
import { ModalModule } from 'ngx-bootstrap';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ConfirmationComponent } from './confirmation/confirmation.component';

@NgModule({
  entryComponents: [
    ConfirmationComponent
  ],
  imports: [CommonModule,
    FormsModule, ModalModule.forRoot()],
  exports: [
    TranslateModule,
    ModalModule,
    ReactiveFormsModule,
    ConfirmationComponent
  ],
  declarations: [ConfirmationComponent]
})
export class SharedModule { }
