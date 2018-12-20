/**
 *  @format
 *  混合开发
 *    rn页面作为activity
 *    rn模块作为嵌入原生的布局区域
 *  */

import {AppRegistry} from 'react-native';
import App from './App';
import App1 from './App1';
import {name as appName} from './app.json';

AppRegistry.registerComponent(appName, () => App);
AppRegistry.registerComponent("float", () => App1);
