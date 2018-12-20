/**
 * @format
 * @flow
 */

import React, {Component} from 'react';
import {StyleSheet, Text, View, AppRegistry} from 'react-native';
import {LongTask} from '../utils/CustomModules';
import longTaskJS from '../Headless/longTask';


type Props = {};
export default class App extends Component<Props> {
  rotate: number = 0;

  componentDidMount() {
    setInterval(() => {
      this.rotate += 2;
      this.rect.setNativeProps({
        transform: [{rotate: `${this.rotate}deg`}]
      })
    }, 10);
    // longTaskJS()
    // LongTask.run(d => console.log(d, '长时任务完成'))
    // setTimeout(() => { LongTask.run(d => console.log(d, '长时任务完成'))}, 0)
    // LongTask.runAsync(d => console.log(d, '长时任务完成'))
    // AppRegistry.runApplication('longTask', {data: 23415, callback: d => console.log(d)});
  }

  render() {
    console.log('render demo2');
    return (
      <View style={styles.container}>
        <View ref={c => this.rect = c} style={{...styles.progress, transform: [{rotate: `0deg`}]}} />

        <Text style={{marginTop: 20}}>直接操作控件属性，不重新render</Text>
        <Text>同时执行longTask</Text>
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
  progress: {
    width: 40,
    height: 40,
    backgroundColor: '#ff0000',
  }
});
