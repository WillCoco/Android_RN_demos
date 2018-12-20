import { NativeModules } from "react-native";
// 下一句中的ToastExample即对应上文
// public String getName()中返回的字符串
console.log(NativeModules, 'NativeModules');
module.exports = {
  ToastExample: NativeModules.ToastExample,
  LongTask: NativeModules.LongTask
};