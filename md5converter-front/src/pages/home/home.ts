import { Component, OnInit } from '@angular/core';
import { NavController, LoadingController } from 'ionic-angular';

import { Md5 } from '../../app/models/md5';
import { Md5ServiceProvider } from '../../providers/md5-service/md5-service';

@Component({
  selector: 'page-home',
  templateUrl: 'home.html',
  providers: [Md5ServiceProvider]
})
export class HomePage implements OnInit{

  md5List: Md5[];

  getLatest(): void {
    this.md5Service.getLatest().then(md5List => this.md5List = md5List);
  }

  doRefresh(refresher) {
    this.getLatest();

    setTimeout(() => {
      refresher.complete();
    }, 2000);
  }

  constructor(
    public navCtrl: NavController,
    public loadingCtrl: LoadingController,
    public md5Service: Md5ServiceProvider) {}

  ngOnInit(): void {
    this.getLatest();
  }

}
