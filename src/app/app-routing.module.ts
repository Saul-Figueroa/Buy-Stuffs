import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ItemComponent } from './item/item.component';
import { DeleteItemComponent } from './delete-item/delete-item.component';
import { ItemListComponent } from './item-list/item-list.component';


const routes: Routes = [
  {path: 'Home', component: HomeComponent},
  {path: 'deleteItem', component: DeleteItemComponent},
  {path: 'addItem', component: ItemComponent},
  {path: 'showList', component: ItemListComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
