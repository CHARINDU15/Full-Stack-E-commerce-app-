import { isPlatformBrowser } from '@angular/common';
import { inject, Injectable, PLATFORM_ID } from '@angular/core';

export interface AbstractSecurityStorage {
  clear(): void;
  read(key: string): string | null;
  remove(key: string): void;
  write(key: string, value: string): void;
}

@Injectable({
  providedIn: 'root'
})
export class SsrStorageService implements AbstractSecurityStorage {
  private platformId = inject(PLATFORM_ID);

  clear(): void {
    if (isPlatformBrowser(this.platformId)) {
      sessionStorage.clear();
    }
  }

  read(key: string): string | null {
    if (isPlatformBrowser(this.platformId)) {
      return sessionStorage.getItem(key);
    } else {
      return null;
    }
  }

  remove(key: string): void {
    if (isPlatformBrowser(this.platformId)) {
      sessionStorage.removeItem(key);
    }
  }

  write(key: string, value: string): void {
    if (isPlatformBrowser(this.platformId)) {
      sessionStorage.setItem(key, value);
    }
  }
}
