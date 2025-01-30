import { Route } from '@angular/router';
import { AdminCategoriesComponent } from './admin-categories/admin-categories.component';
import { CreateCategoryComponent } from './create-category/create-category.component';

export const appRoutes: Route[] = [
    {
        path: 'admin/categories/list',
        component: AdminCategoriesComponent,
        canActivate: [roleCheckGuard],
        data: {
          authorities: ['ROLE_ADMIN'],
        },
      },
      {
        path: 'admin/categories/create',
        component: CreateCategoryComponent,
        canActivate: [roleCheckGuard],
        data: {
          authorities: ['ROLE_ADMIN'],
        },
      },
      {
        path: 'admin/products/create',
        component: CreateProductComponent,
        canActivate: [roleCheckGuard],
        data: {
          authorities: ['ROLE_ADMIN'],
        },
      },
      {
        path: 'admin/products/list',
        component: AdminProductsComponent,
        canActivate: [roleCheckGuard],
        data: {
          authorities: ['ROLE_ADMIN'],
        },
      },
      {
        path: 'admin/orders/list',
        component: AdminOrdersComponent,
        canActivate: [roleCheckGuard],
        data: {
          authorities: ['ROLE_ADMIN'],
        },
      },
      {
        path: '',
        component: HomeComponent,
      },
      {
        path: 'product/:publicId',
        component: ProductDetailComponent,
      },
      {
        path: 'products',
        component: ProductsComponent,
      },
      {
        path: 'cart',
        component: CartComponent,
      },
      {
        path: 'cart/success',
        component: CartSuccessComponent,
      },
      {
        path: 'users/orders',
        component: UserOrdersComponent
      }
];
