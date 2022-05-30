import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { map } from "rxjs/operators";
import { ApiService } from "../api.service";


@Injectable()
export class TaskHistoryService{

    private TASK_HİSTORY_PATH="/task";

    constructor(private apiService:ApiService){}

    getAll():Observable<any>{
        return this.apiService.get(this.TASK_HİSTORY_PATH).pipe(map(
            response=>{
                if(response){
                    return response;
                }else{
                    console.log(response);
                    return {};
                }
            }
        ));
    }

    getById(id):Observable<any>{
        return this.apiService.get(this.TASK_HİSTORY_PATH,id).pipe(map(
            response=>{
                if(response){
                    return response;
                }else{
                    console.log(response);
                    return {};
                }
            }
        ));
    }

    createTask(task):Observable<any>{
        return this.apiService.post(this.TASK_HİSTORY_PATH,task).pipe(map(
            response=>{
                if(response){
                    return response;
                }else{
                    console.log(response);
                    return {};
                }
            }
        ));
    }

    delete(id):Observable<any>{
        return this.apiService.delete(this.TASK_HİSTORY_PATH,id).pipe(map(
            response=>{
                if(response){
                    return response;
                }else{
                    console.log(response);
                    return {};
                }
            }
        ));
    }
}