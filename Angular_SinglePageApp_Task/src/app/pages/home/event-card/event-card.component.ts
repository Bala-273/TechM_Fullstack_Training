import { Component, Input } from '@angular/core';
import { AppEvent } from '../../../model/event';

@Component({
  selector: 'app-event-card',
  templateUrl: './event-card.component.html',
  styleUrls: ['./event-card.component.css']
})
export class EventCardComponent {
  @Input() event!: AppEvent;  

  showForm = false;

  formData={
    name: '',
    email: ''
  };

  toggleForm() {
    this.showForm = !this.showForm;
  }

  submitForm() {
    console.log("Form data: ", this.formData);

    this.formData={name: '', email: ''};
    this.showForm = false;
  }
}
