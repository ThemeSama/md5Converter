import { Component } from '@angular/core';

import { Md5Page } from '../md5/md5';
import { Md5unlockPage } from '../md5unlock/md5unlock';
import { ContactPage } from '../contact/contact';
import { HomePage } from '../home/home';

@Component({
  templateUrl: 'tabs.html'
})
export class TabsPage {

  tab1Root = HomePage;
  tab2Root = Md5Page;
  tab3Root = Md5unlockPage;
  tab4Root = ContactPage;

  constructor() {

  }
}
