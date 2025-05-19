import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { AboutComponent } from './pages/about/about.component';
import { ServicesComponent } from './pages/services/services.component';
import { ContactComponent } from './pages/contact/contact.component';
import { EventComponent } from './pages/home/event/event.component';
import { EnquiryComponent } from './pages/enquiry/enquiry.component';
import { LoginComponent } from './common/login/login.component';
import { AuthGuard } from './auth-guard/auth.guard';

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  {path:'login', component: LoginComponent},

  { path: 'home', component: HomeComponent, canActivate: [AuthGuard] },
  { path: 'events', component: EventComponent, canActivate:[AuthGuard]},
  { path: 'about', component: AboutComponent, canActivate:[AuthGuard] },
  { path: 'services', component: ServicesComponent, canActivate:[AuthGuard] },
  { path: 'contact', component: ContactComponent, canActivate:[AuthGuard] },
  {path: 'enquiry', component: EnquiryComponent, canActivate:[AuthGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
