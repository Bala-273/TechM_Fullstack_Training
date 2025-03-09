import { Component } from '@angular/core';
import { Contact } from '../../model/contact';
import { contacts } from '../../data/info';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent {
  contactlist: Contact[] = contacts;
}
