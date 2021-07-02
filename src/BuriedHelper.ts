import { native } from "./Native";

export class BuriedHelper {
  private static instance?: BuriedHelper;

  static shared(): BuriedHelper {
    if (this.instance == null) {
      this.instance = new BuriedHelper();
    }
    return this.instance;
  }

  private constructor() {}

  openBuriedView() {
    native.openBuriedView();
  }

  closeBuriedView() {
    native.closeBuriedView();
  }
}
