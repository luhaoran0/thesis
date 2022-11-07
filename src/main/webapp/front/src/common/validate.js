export default {
    isEmail2: function (s) {
          return /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((.[a-zA-Z0-9_-]{2,3}){1,2})$/.test(s)
    },
  isEmail: function (rule, value, callback) {
    let reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((.[a-zA-Z0-9_-]{2,3}){1,2})$/;
    if (value && reg.test(value) === false) {
      callback(new Error('Please enter the correct email address'));
    } else {
      callback()
    }
  },
  isMobile: function (rule, value, callback) {
    let reg = /^1[0-9]{10}$/;
    if (value && reg.test(value) === false) {
      callback(new Error('Please enter the correct mobile phone number'));
    } else {
      callback()
    }
  },
  isPhone: function (rule, value, callback) {
    let reg = /^([0-9]{3,4}-)?[0-9]{7,8}$/;
    if (value && reg.test(value) === false) {
      callback(new Error('Please enter the correct telephone number'));
    } else {
      callback()
    }
  },
  isURL: function (rule, value, callback) {
    let reg = /^http[s]?:\/\/.*/;
    if (value && reg.test(value) === false) {
      callback(new Error('Please enter the correct URL address'));
    } else {
      callback()
    }
  },
  isNumber: function (rule, value, callback) {
    let reg = /(^-?[+-]?([0-9]*\.?[0-9]+|[0-9]+\.?[0-9]*)([eE][+-]?[0-9]+)?$)|(^$)/;
    if (value && reg.test(value) === false) {
      callback(new Error('Please enter the correct number'));
    } else {
      callback()
    }
  },
  isIntNumer: function (rule, value, callback) {
    let reg = /(^-?\d+$)|(^$)/;
    if (value && reg.test(value) === false) {
      callback(new Error('Please enter the correct integer'));
    } else {
      callback()
    }
  },
  isIdCard: function (rule, value, callback) {
    let reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
    if (value && reg.test(value) === false) {
      callback(new Error('Please enter the correct ID card'));
    } else {
      callback()
    }
  }
}
