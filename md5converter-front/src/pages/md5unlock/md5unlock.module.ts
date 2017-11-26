import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { Md5unlockPage } from './md5unlock';

@NgModule({
  declarations: [
    Md5unlockPage,
  ],
  imports: [
    IonicPageModule.forChild(Md5unlockPage),
  ],
})
export class Md5unlockPageModule {}
