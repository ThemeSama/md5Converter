import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { Md5Page } from './md5';

@NgModule({
  declarations: [
    Md5Page,
  ],
  imports: [
    IonicPageModule.forChild(Md5Page),
  ],
})
export class Md5PageModule {}
