import { ApplicationConfig, provideZoneChangeDetection } from '@angular/core';
import { provideRouter } from '@angular/router';
import { appRoutes } from './app.routes';
import {
  provideClientHydration,
  withEventReplay,
} from '@angular/platform-browser';
import { environments } from '../environments/environment';

import { SsrStorageService } from './auth/ssr-storage.service';
import { QueryClient } from '@tanstack/query-core';
import { provideHttpClient, withFetch, withInterceptors } from '@angular/common/http';
import { AbstractSecurityStorage, authInterceptor, LogLevel, provideAuth } from 'angular-auth-oidc-client';
import { provideQueryClient } from '@tanstack/angular-query-experimental';

export const appConfig: ApplicationConfig = {
  providers: [
    provideClientHydration(withEventReplay()),
    provideZoneChangeDetection({ eventCoalescing: true }),
    provideRouter(appRoutes,withComponentInputBinding()),
    provideHttpClient(withFetch(), withInterceptors([authInterceptor()])),
    provideAuth({
      config: {
        authority: environments.kinde.authority,
        redirectUrl: environments.kinde.redirectUrl,
        postLogoutRedirectUri: environments.kinde.postLogoutRedirectUri,
        clientId: environments.kinde.clientId,
        scope: 'openid profile email offline',
        responseType: 'code',
        silentRenew: true,
        useRefreshToken: true,
        logLevel: LogLevel.Warn,
        secureRoutes: [environments.apiUrl],
        customParamsAuthRequest: {
          audience: environments.kinde.audience,
        },
      },
    }),
    { provide: AbstractSecurityStorage, useClass: SsrStorageService },
    provideQueryClient(new QueryClient()),
    provideNgxStripe(environments.stripePublishableKey),
  ],
};
function withComponentInputBinding(): import("@angular/router").RouterFeatures {
  throw new Error('Function not implemented.');
}

function provideNgxStripe(stripePublishableKey: any): import("@angular/core").Provider | import("@angular/core").EnvironmentProviders {
  throw new Error('Function not implemented.');
}

