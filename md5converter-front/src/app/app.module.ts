import { NgModule, ErrorHandler } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { IonicApp, IonicModule, IonicErrorHandler } from 'ionic-angular';
import { MyApp } from './app.component';
import { HttpModule } from '@angular/http';

import { ClipboardModule } from 'ngx-clipboard';

import { Md5Page } from '../pages/md5/md5';
import { Md5unlockPage } from '../pages/md5unlock/md5unlock';
import { ContactPage } from '../pages/contact/contact';
import { HomePage } from '../pages/home/home';
import { TabsPage } from '../pages/tabs/tabs';

import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';
import { Md5ServiceProvider } from '../providers/md5-service/md5-service';

@NgModule({
  declarations: [
    MyApp,
    Md5Page,
    Md5unlockPage,
    ContactPage,
    HomePage,
    TabsPage
  ],
  imports: [
    BrowserModule,
    HttpModule,
    IonicModule.forRoot(MyApp),
    ClipboardModule
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    Md5Page,
    Md5unlockPage,
    ContactPage,
    HomePage,
    TabsPage
  ],
  providers: [
    StatusBar,
    SplashScreen,
    {provide: ErrorHandler, useClass: IonicErrorHandler},
    Md5ServiceProvider
  ]
})
export class AppModule {}
