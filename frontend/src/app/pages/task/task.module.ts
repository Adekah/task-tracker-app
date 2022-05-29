import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TaskComponent } from './task.component';
import { TaskRoutingModule } from './task.routing.module';
import { TaskService } from 'src/app/services/shared/task.service';
import { SharedModule } from 'src/app/shared/shared.module';



@NgModule({
  declarations: [
    TaskComponent
  ],
  imports: [
    CommonModule,
    TaskRoutingModule,
    SharedModule
  ],
  providers:[TaskService]
})
export class TaskModule { }
