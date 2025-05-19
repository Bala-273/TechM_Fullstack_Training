import { Component, Input } from '@angular/core';
import { ContactDetails } from '../../../model/contactDetails';
@Component({
  selector: 'app-contact-item',
  templateUrl: './contact-item.component.html',
  styleUrl: './contact-item.component.css'
})
export class ContactItemComponent {
  @Input() contact!:ContactDetails;
}