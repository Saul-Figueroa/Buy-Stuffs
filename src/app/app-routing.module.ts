import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ItemComponent } from './item/item.component';
import { DeleteItemComponent } from './delete-item/delete-item.component';
import { ItemListComponent } from './item-list/item-list.component';
import { ClientComponent } from './client/client.component';
import { HomeManagerComponent } from './home-manager/home-manager.component';
import { HomeVendorComponent } from './home-vendor/home-vendor.component';


const routes: Routes = [
  {path: 'homeCustomer', component: HomeComponent},
  {path: 'deleteItem', component: DeleteItemComponent},
  {path: 'addItem', component: ItemComponent},
  {path: 'showList', component: ItemListComponent},
  {path: 'showClientList', component: ClientComponent},
  {path: 'homeManager', component: HomeManagerComponent},
  {path: 'homeVendor', component: HomeVendorComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
