import { Component, inject, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { FaIconComponent } from '@fortawesome/angular-fontawesome';
import { Oauth2Service } from '../../auth/oauth2.service';
import { CartService } from '../../services/cart.service';
import { UserProductService } from '../../services/user-product.service';
import { injectQuery } from '@tanstack/angular-query-experimental';
import { lastValueFrom } from 'rxjs';

@Component({
  // eslint-disable-next-line @angular-eslint/component-selector
  selector: 'ecom-navbar',
  imports: [CommonModule, RouterLink, FaIconComponent],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.scss',
})
export class NavbarComponent implements OnInit {
  oauth2Service = inject(Oauth2Service);
  productService = inject(UserProductService);
  cartService = inject(CartService);

  nbItemsInCart = 0;

  connectedUserQuery = this.oauth2Service.connectedUserQuery;

  categoryQuery = injectQuery(() => ({
    queryKey: ['categories'],
    queryFn: () => lastValueFrom(this.productService.findAllCategories()),
  }));

  login(): void {
    this.closeDropDownMenu();
    this.oauth2Service.login();
  }

  logout(): void {
    this.closeDropDownMenu();
    this.oauth2Service.logout();
  }

  isConnected(): boolean {
    return (
      this.connectedUserQuery?.status() === 'success' &&
      this.connectedUserQuery?.data()?.username !== this.oauth2Service.notConnected
    );
  }

  closeDropDownMenu() {
    const bodyElement = document.activeElement as HTMLBodyElement;
    if (bodyElement) {
      bodyElement.blur();
    }
  }

  closeMenu(menu: HTMLDetailsElement) {
    menu.removeAttribute('open');
  }

  ngOnInit(): void {
    this.listenToCart();
  }

  private listenToCart() {
    this.cartService.addedToCart.subscribe((productsInCart: { quantity: number }[]) => {
      this.nbItemsInCart = productsInCart.reduce(
        (acc, product) => acc + product.quantity,
        0
      );
    });
  }
}

