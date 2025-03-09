import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ApiService } from '../../../services/api.service';

@Component({
  selector: 'app-enquiry-response',
  templateUrl: './enquiry-response.component.html',
  styleUrls: ['./enquiry-response.component.css']
})
export class EnquiryResponseComponent implements OnInit {
  enquiryForm: FormGroup;
  ids: string[] = [];
  emailList: string[] = [];

  constructor(private fb: FormBuilder, private api: ApiService) {
    this.enquiryForm = this.fb.group({
      messageId: ['', Validators.required],
      email: ['', Validators.required],
      subject: ['', Validators.required],
      message: ['', Validators.required],
      estimatedPrice: ['', Validators.required],
      duration: ['', Validators.required]
    });
  }

  ngOnInit() {
    this.api.getEnquiries().subscribe({
      next: (result: any) => {      
        this.ids = result.map((enquiry: any) => enquiry.id);
        this.emailList = result.map((enquiry: any) => enquiry.email);
      },
      error: (error: any) => console.log(error)
    });
  
    this.enquiryForm.get('email')?.disable(); 
  }
  

  onIdChange(event: any) {
    const selectedId = event.target.value;
    this.enquiryForm.patchValue({ email: this.emailList[selectedId] });
  }

  onSubmit() {
    if (this.enquiryForm.valid) {
      const formData = this.enquiryForm.getRawValue(); 

      this.api.addEnquiryReply(formData).subscribe({
        next: (response: any) => {
          alert('Response submitted successfully!');
          this.enquiryForm.reset();
        },
        error: (error: any) => console.log(error)
      });
    }
  }
}
