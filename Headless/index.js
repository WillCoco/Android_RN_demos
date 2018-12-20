/** @format */

import {AppRegistry} from 'react-native';
import App from './App';
import {name as appName} from './app.json';
import longTaskJS from './Headless/longTask';
import { LongTask } from './utils/CustomModules';

AppRegistry.registerRunnable('longTask', ({data, callback}) => {
  longTaskJS();
  callback('JS长时任务完成');
});

AppRegistry.registerComponent(appName, () => App);

