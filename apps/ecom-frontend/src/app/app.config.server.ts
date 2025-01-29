import { mergeApplicationConfig, ApplicationConfig } from '@angular/core';
import { provideServerRendering } from '@angular/platform-server';
import { appConfig } from './app.config';
import { UNIVERSAL_PROVIDERS } from '@angular/universal';

const serverConfig: ApplicationConfig = {
  providers: 
    // provideServerRendering(),
    // UNIVERSAL_PROVIDERS,
    // provideServerRoutesConfig(serverRoutes),
    [provideServerRendering(), UNIVERSAL_PROVIDERS],
  };

export const config = mergeApplicationConfig(appConfig, serverConfig);

