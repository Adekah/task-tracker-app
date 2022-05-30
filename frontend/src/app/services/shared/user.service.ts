import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { map } from "rxjs/operators";

import { ApiService } from "../api.service";

@Injectable({ providedIn: 'root' })
export class UserService {

    private USER_PATH = "/user";

    constructor(private apiService: ApiService) { }

    getAll(page): Observable<any> {
        return this.apiService.get(this.USER_PATH + '/pagination', page).pipe(map(
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
        return this.apiService.get(this.USER_PATH, id).pipe(map(
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

    createUser(user): Observable<any> {
        return this.apiService.post(this.USER_PATH, user).pipe(map(
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
        return this.apiService.delete(this.USER_PATH + '/' + id).pipe(map(
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