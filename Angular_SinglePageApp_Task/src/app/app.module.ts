import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './pages/home/home.component';
import { AboutComponent } from './pages/about/about.component';
import { ContactComponent } from './pages/contact/contact.component';
import { ServicesComponent } from './pages/services/services.component';
import { MenuBarComponent } from './common/menu-bar/menu-bar.component';
import { ContactItemComponent } from './pages/contact/contact-item/contact-item.component';
import { HttpClientModule } from '@angular/common/http';
import { EventFilterPipe } from './pipes/event-filter.pipe';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { EventComponent } from './pages/home/event/event.component';
import { EventCardComponent } from './pages/home/event-card/event-card.component';
import { ApiService } from './services/api.service';
import { ServiceCardComponent } from './pages/services/service-card/service-card.component';
import { EnquiryComponent } from './pages/enquiry/enquiry.component';
import { EnquiryResponseComponent } from './pages/enquiry/enquiry-response/enquiry-response.component';
import { LoginComponent } from './common/login/login.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AboutComponent,
    ContactComponent,
    ServicesComponent,
    MenuBarComponent,
    ContactItemComponent,
    EventFilterPipe,
    EventComponent,
    EventCardComponent,
    ServiceCardComponent,
    EnquiryComponent,
    EnquiryResponseComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [ApiService],
  bootstrap: [AppComponent]
})
export class AppModule { }
