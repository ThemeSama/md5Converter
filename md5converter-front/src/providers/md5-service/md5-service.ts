import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';

import { Md5 } from '../../app/models/md5';

/*
  Generated class for the Md5ServiceProvider provider.

  See https://angular.io/guide/dependency-injection for more info on providers
  and Angular DI.
*/
@Injectable()
export class Md5ServiceProvider {

  private md5RestService = 'http://localhost:8080/';

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }

  constructor(public http: Http) {
    console.log('Hello Md5ServiceProvider Provider');
  }

  getLatest(): Promise<Md5[]> {
    return this.http.get(this.md5RestService + "latest")
               .toPromise()
               .then(response => response.json() as Md5[])
               .catch(this.handleError);
  }

  getByKey(key: String): Promise<Md5> {
    return this.http.get(this.md5RestService + "key/" + key)
               .toPromise()
               .then(response => response.json() as Md5)
               .catch(this.handleError);
  }

  getByValue(md5: String): Promise<Md5> {
    return this.http.get(this.md5RestService + "md5/" + md5)
               .toPromise()
               .then(response => response.json() as Md5)
               .catch(this.handleError);
  }

}
