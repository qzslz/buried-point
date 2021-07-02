import { NativeModules } from "react-native";

const { RNBuriedPoint } = NativeModules;
class Native {
  /**
   * 开启埋点视图
   */
  openBuriedView() {
    RNBuriedPoint.openBuriedView();
  }

  /**
   * 关闭埋点视图
   */
  closeBuriedView() {
    RNBuriedPoint.closeBuriedView();
  }
}

export const native = new Native();
