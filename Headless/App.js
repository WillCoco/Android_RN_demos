/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow
 *
 * rn 多线程尝试
 * 结论 只能在原生中开启其他线程
 */

import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, ActivityIndicator, PermissionsAndroid} from 'react-native';
import {LongTask, ToastExample} from './utils/CustomModules';
import Demo1 from './containers/demo1';
import Demo2 from './containers/demo2';
import Demo3 from './containers/demo3';
import Demo4 from './containers/demo4';
// import ImageManager from './utils/ImageManager';
import CustomViewManager from './utils/CustomViewManager';

console.log(ToastExample, 'ToastExample');

const instructions = Platform.select({
  ios: 'Press Cmd+R to reload,\n' + 'Cmd+D or shake for dev menu',
  android:
    'Welcome to RN\n' +
    'Double tap R on your keyboard to reload,\n' +
    'Shake or press menu button for dev menu',
});

type Props = {};
export default class App extends Component<Props> {
  state = {
    show: false
  }

  componentDidMount() {
    // LongTask.floatWindow()
    this.requestCameraPermission()
  }

  requestCameraPermission = async () => {
    try {
      const granted = await PermissionsAndroid.request(
        PermissionsAndroid.PERMISSIONS.SYSTEM_ALERT_WINDOW,
        {
          title: '申请摄像头权限',
          message:
          '一个很牛逼的应用想借用你的摄像头，' +
          '然后你就可以拍出酷炫的皂片啦。',
          buttonNeutral: '等会再问我',
          buttonNegative: '不行',
          buttonPositive: '好吧',
        },
      );
      if (granted === PermissionsAndroid.RESULTS.GRANTED) {
        console.log('现在你获得摄像头权限了');
        this.setState({
          show: true
        })
      } else {
        console.log('用户并不屌你');
      }
    } catch (err) {
      console.warn(err);
    }
  };

  render() {
    console.log('render app');
    return (
      <View style={styles.container}>
        <Demo4 />
        {/*<View style={{flex: 1}}>*/}
        {
          this.state.show &&
          <CustomViewManager style={{width: 200}} />
        }
        {/*</View>*/}
        {/*<Text>{instructions}</Text>*/}
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
  progress: {
    width: 40,
    height: 40,
    backgroundColor: '#ff0000',
  }
});
