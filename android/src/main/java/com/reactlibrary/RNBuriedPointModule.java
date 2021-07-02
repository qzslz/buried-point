
package com.reactlibrary;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class RNBuriedPointModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNBuriedPointModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNBuriedPoint";
  }

  /**
   * 开启埋点视图
   */
  @ReactMethod
  public void openBuriedView(){
    BuriedPointUtil.showBuriedOverPoint(getCurrentActivity(),true);
  }

  /**
   * 关闭埋点视图
   */
  @ReactMethod
  public  void closeBuriedView(){
    BuriedPointUtil.showBuriedOverPoint(getCurrentActivity(),false);
  }

}