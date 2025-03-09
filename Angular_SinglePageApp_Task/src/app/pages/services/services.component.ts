import { Component, OnInit } from '@angular/core';
import { ApiService } from '../../services/api.service';
import { EventService } from '../../model/service'; // Renamed to avoid conflicts

@Component({
  selector: 'app-services',
  templateUrl: './services.component.html',
  styleUrls: ['./services.component.css']
})
export class ServicesComponent implements OnInit {
  services: EventService[] = []; // Updated variable type
  selectedEventType: string = 'All';
  eventTypes: string[] = ['All', 'Wedding', 'Birthday', 'Corporate', 'College', 'Entertainment'];

  constructor(private apiService: ApiService) {}

  ngOnInit() {
    this.apiService.getServices().subscribe({
      next: (data) => {
        this.services = data;
      },
      error: (err) => console.error('Error fetching services:', err)
    });
  }
}
