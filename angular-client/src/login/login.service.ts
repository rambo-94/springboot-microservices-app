import { Injectable } from '@angular/core';
import {Observable, throwError} from 'rxjs';
import {HttpClient, HttpErrorResponse, HttpHeaders, HttpParams} from '@angular/common/http';
import {Login} from './login';
import {catchError, map} from 'rxjs/operators';


@Injectable()
export class LoginService {
  constructor(private http: HttpClient,  private params: HttpParams) { }

  public checkUserCred(valueElement: string): Observable<Login> {

    this.params.set('username', valueElement);
    return this.http.get<Login>('', { params : this.params})
      .pipe( catchError(this.handleError('checkUserCred', 'getUserCredentials', {} as Login)));

  }


  handleError<T>(serviceName= 'service', operation = 'operation', result = {} as T) {
    return (error: HttpErrorResponse): Observable<T> => {

      const message = error.error instanceof ErrorEvent
        ? error.error.message : `server returned status of ${error.status} with body of ${error.error}`;

      console.error(`${serviceName}::${operation} failed: ${message}`);

      return throwError(message);
    };
  }

}

