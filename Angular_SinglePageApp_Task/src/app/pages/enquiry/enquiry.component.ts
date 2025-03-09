import { Component, ViewChild } from '@angular/core';
import { ApiService } from '../../services/api.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-enquiry',
  templateUrl: './enquiry.component.html',
  styleUrls: ['./enquiry.component.css']
})
export class EnquiryComponent {
  @ViewChild('enquiryForm') enquiryForm!: NgForm; 

  enquiry = {
    name: '',
    email: '',
    eventType: '',
    message: ''
  };

  eventTypes: string[] = [
    'Wedding', 'Birthday', 'Corporate', 'College',
    'Entertainment'
  ];

  constructor(private apiService: ApiService) {}

  submitEnquiry() {
    if (this.enquiryForm.valid) {
      this.apiService.addEnquiry(this.enquiry).subscribe({
        next: () => {
          alert('Enquiry submitted successfully!');
          this.enquiryForm.resetForm();
        },
        error: (err) => {
          console.error('Error submitting enquiry:', err);
          alert('Failed to submit enquiry. Please try again.');
        }
      });
    }
  }
}
