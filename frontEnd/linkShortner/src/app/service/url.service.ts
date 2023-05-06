import { Injectable } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class UrlService {

  serviceUrl : string = '';
  constructor(private http : HttpClient) { 
    this.serviceUrl = "http://localhost:8080/url/shortner";
  }

  getShortUrl(url : string) {
    return this.http.post<any>(this.serviceUrl,url);
  }
  getUrl(url : string) {
    return this.http.get<any>(this.serviceUrl+"/"+url);
  }
}
