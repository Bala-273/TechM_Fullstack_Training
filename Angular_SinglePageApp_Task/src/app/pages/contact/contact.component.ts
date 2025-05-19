import { Component } from '@angular/core';
import { ContactDetails } from '../../model/contactDetails';
import { contacts } from '../../data/info';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent {
  contactlist: ContactDetails[] = contacts;
}
