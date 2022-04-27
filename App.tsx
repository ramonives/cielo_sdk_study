import React from 'react';
import {Alert, NativeModules, Text, TouchableOpacity, View} from 'react-native';

const App = () => {
  const {CieloModule} = NativeModules;

  function handlePrint() {
    CieloModule.printSimpleText();
  }

  function handleSayHello() {
    CieloModule.sayHello('FUNCIONANDO', (msg: any) => {
      Alert.alert(msg);
    });
  }

  return (
    <View
      style={{
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: '#121015',
      }}>
      <TouchableOpacity
        activeOpacity={0.7}
        onPress={handlePrint}
        style={{
          backgroundColor: '#a370f7',
          padding: 15,
          borderRadius: 7,
          alignItems: 'center',
          marginBottom: 10,
        }}>
        <Text style={{color: '#FFFFFF', fontSize: 17, fontWeight: 'bold'}}>
          IMPRIMIR
        </Text>
      </TouchableOpacity>
      <TouchableOpacity
        activeOpacity={0.7}
        onPress={handleSayHello}
        style={{
          backgroundColor: '#a370f7',
          padding: 15,
          borderRadius: 7,
          alignItems: 'center',
        }}>
        <Text style={{color: '#FFFFFF', fontSize: 17, fontWeight: 'bold'}}>
          HELLO
        </Text>
      </TouchableOpacity>
    </View>
  );
};

export default App;
