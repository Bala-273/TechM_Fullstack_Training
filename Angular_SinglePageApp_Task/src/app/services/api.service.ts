import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppEvent } from '../model/event';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private http:HttpClient) { }

  getServices():Observable<any>{
    return this.http.get('http://localhost:4500/services');
  }

  getEvents(): Observable<AppEvent[]> {
    return this.http.get<AppEvent[]>('http://localhost:4500/events');
  }

  getEnquiries(): Observable<any> {
    return this.http.get('http://localhost:4500/enquiries');
  }

  addEnquiry(data: any): Observable<any> {
  return this.http.post('http://localhost:4500/enquiries', data);
}

addEnquiryReply(responseData: any): Observable<any> {
  return this.http.post(`http://localhost:4500/enquiry-replies`, responseData);
}

}