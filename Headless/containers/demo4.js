/**
 * @format
 * @flow
 */

import React, {Component} from 'react';
import {StyleSheet, Text, View, ActivityIndicator} from 'react-native';
import {LongTask} from '../utils/CustomModules';


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
    console.log('render demo3');
    return (
      <View style={styles.container}>
        <ActivityIndicator size="large" color="#0000ff" />

        <Text style={{marginTop: 20}}>ActivityIndicator</Text>
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
});
