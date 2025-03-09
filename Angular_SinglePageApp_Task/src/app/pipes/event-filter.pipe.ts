import { Pipe, PipeTransform } from '@angular/core';
import { EventService } from '../model/service'; 

@Pipe({
  name: 'eventFilter'
})
export class EventFilterPipe implements PipeTransform {
  transform(services: EventService[], eventType?: string): EventService[] {
    if (!services || !eventType || eventType === 'All') {
      return services;
    }
    return services.filter(service => service.eventType?.toLowerCase() === eventType.toLowerCase());
  }
}
