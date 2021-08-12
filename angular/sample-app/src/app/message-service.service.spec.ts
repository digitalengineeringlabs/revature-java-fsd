import { TestBed } from '@angular/core/testing';

import { MessageServiceService } from './message-service.service';

describe('MessageServiceService', () => {

  let service: MessageServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MessageServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should formatMessage return valid result', () => {
    let result = service.formatMessage('Server Down') //Warning: Server Down
    expect(result).toBe('Warning: Server Down');
  });
});
