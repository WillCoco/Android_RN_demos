/**
 * @format
 * @flow
 */

import React, {Component} from 'react';
import {StyleSheet, Text, View, ActivityIndicator} from 'react-native';
import {ToastExample} from '../utils/CustomModules';


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
    }, 10)
  }

  render() {
    console.log('render app');
    return (
      <View style={styles.container}>
        <Text onPress={() => ToastExample.show('原生模块toast', ToastExample.SHORT)} style={styles.welcome}>点击显示原生Toast</Text>
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
});
