import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';

import { Md5 } from '../../app/models/md5';
import { Md5ServiceProvider } from '../../providers/md5-service/md5-service';

/**
 * Generated class for the Md5unlockPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-md5unlock',
  templateUrl: 'md5unlock.html',
  providers: [Md5ServiceProvider]
})
export class Md5unlockPage {

  md5: Md5;
  inputKey: String;
  isCopied: Boolean;

  getByValue(value: String) {
    this.md5Service.getByValue(value).then(md5 => this.md5 = md5);
  }

  btnClick() {
    this.isCopied = false;
  	if( typeof this.inputKey != "undefined" && this.inputKey != "" ) {
  		this.getByValue(this.inputKey);
  	} else {
  		this.md5 = null;
  	}
  }

  constructor(
  	public navCtrl: NavController,
  	public navParams: NavParams,
  	public md5Service: Md5ServiceProvider) {
  }

  ionViewDidLoad() {
  	//
  }

}
