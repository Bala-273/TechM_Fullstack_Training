import { Component, Input } from '@angular/core';
import { EventService } from '../../../model/service'; 

@Component({
  selector: 'app-service-card',
  templateUrl: './service-card.component.html',
  styleUrls: ['./service-card.component.css']
})
export class ServiceCardComponent {
  @Input() service!: EventService; 
}
