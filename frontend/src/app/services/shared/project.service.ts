import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { map } from "rxjs/operators";

import { ApiService } from "../api.service";

@Injectable({ providedIn: 'root' })
export class ProjectService {

    private PROJECT_PATH = "/project";

    constructor(private apiService: ApiService) { }

    getAll(page): Observable<any> {
        return this.apiService.get(this.PROJECT_PATH + '/pagination', page).pipe(map(
            response => {
                if (response) {
                    return response;
                } else {
                    console.log(response);
                    return {};
                }
            }
        ));
    }

    getById(id): Observable<any> {
        return this.apiService.get(this.PROJECT_PATH, id).pipe(map(
            response => {
                if (response) {
                    return response;
                } else {
                    console.log(response);
                    return {};
                }
            }
        ));
    }

    createProject(project): Observable<any> {
        return this.apiService.post(this.PROJECT_PATH, project).pipe(map(
            response => {
                if (response) {
                    return response;
                } else {
                    console.log(response);
                    return {};
                }
            }
        ));
    }

    delete(id): Observable<any> {
        return this.apiService.delete(this.PROJECT_PATH + '/' + id).pipe(map(
            response => {
                if (response) {
                    return response;
                } else {
                    console.log(response);
                    return {};
                }
            }
        ));
    }
}