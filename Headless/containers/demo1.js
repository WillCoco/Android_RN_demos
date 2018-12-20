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
  state = {
    rotate: 0
  };

  componentDidMount() {
    setInterval(() => {
      this.setState({
        rotate: this.state.rotate + 2
      })
    }, 10);

    // longTaskJS()
    // LongTask.run(d => console.log(d, '长时任务完成'))
    // LongTask.runAsync(d => console.log(d, '长时任务完成'))
    AppRegistry.runApplication('longTask', {data: 23415, callback: d => console.log(d)});

  }

  render() {
    console.log('render demo1');
    return (
      <View style={styles.container}>
        <View style={{...styles.progress, transform: [{rotate: `${this.state.rotate}deg`}]}} />

        <Text style={{marginTop: 20}}>setState的方式更新ui</Text>
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
