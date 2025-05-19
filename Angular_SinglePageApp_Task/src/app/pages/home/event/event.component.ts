import { Component, OnInit } from '@angular/core';
import { ApiService } from '../../../services/api.service';
import { AppEvent } from '../../../model/event'; 

@Component({
  selector: 'app-event',
  templateUrl: './event.component.html',
  styleUrls: ['./event.component.css']
})
export class EventComponent implements OnInit {
  events: AppEvent[] = [];

  constructor(private apiService: ApiService) {}

  ngOnInit() {
    this.apiService.getEvents().subscribe({
      next: (data) => {
        this.events = data;
      }
    });
  }
}
