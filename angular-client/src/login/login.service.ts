import { Injectable } from '@angular/core';
import {Observable, of, throwError} from 'rxjs';
import {HttpClient, HttpErrorResponse, HttpHeaders, HttpParams} from '@angular/common/http';
import {Login} from './login';
import {catchError, map} from 'rxjs/operators';
import {Register} from './register';

const headers: HttpHeaders = new HttpHeaders();
headers.set('Accept', 'application/json');

@Injectable()
export class LoginService {
  constructor(private http: HttpClient,  private params: HttpParams) { }

  public checkUserCred(valueElement: string): Observable<Login> {
    this.params.set('username', valueElement);
    return this.http.get<Login>('', { headers, params : this.params})
      .pipe( catchError(this.handleError('checkUserCred', 'getUserCredentials', {} as Login)));

  }

  saveRegistration(details: Register): Observable<any> {

    return this.http.put<Register>('', details).pipe(map(x => x),
      catchError(this.handleError('saveRegistration', 'saveRegistrationDetails', {} as string)));

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

