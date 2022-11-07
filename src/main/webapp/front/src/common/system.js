export function isAuth(tableName, key) {
  let role = localStorage.getItem("UserTableName");
  let menus = [{ "backMenu": [{ "child": [{ "appFrontIcon": "cuIcon-copy", "buttons": ["Add", "View", "Update", "Remove"], "menu": "seller", "menuJump": "list", "tableName": "maijia" }], "menu": "Seller management" }, { "child": [{ "appFrontIcon": "cuIcon-similar", "buttons": ["Add", "View", "Update", "Remove"], "menu": "user", "menuJump": "list", "tableName": "yonghu" }], "menu": "User management" }, { "child": [{ "appFrontIcon": "cuIcon-skin", "buttons": ["Add", "View", "Update", "Remove"], "menu": "Book classification", "menuJump": "list", "tableName": "tushufenlei" }], "menu": "BookType manage" }, { "child": [{ "appFrontIcon": "cuIcon-cardboard", "buttons": ["View", "Update", "Remove"], "menu": "Book information", "menuJump": "list", "tableName": "tushuxinxi" }], "menu": "BookInfo manage" }, { "child": [{ "appFrontIcon": "cuIcon-discover", "buttons": ["View", "Update", "Remove"], "menu": "Chat record", "menuJump": "list", "tableName": "liaotianjilu" }], "menu": "Chat record manage" }, { "child": [{ "appFrontIcon": "cuIcon-pay", "buttons": ["View", "Update"], "menu": "Rotation chart", "tableName": "config" }, { "appFrontIcon": "cuIcon-news", "buttons": ["Add", "View", "Update", "Remove"], "menu": "Notice information", "tableName": "news" }], "menu": "System manage" }], "frontMenu": [{ "child": [{ "appFrontIcon": "cuIcon-pay", "buttons": ["View", "Consultation chat"], "menu": "Book informationlist", "menuJump": "list", "tableName": "tushuxinxi" }], "menu": "Book information模块" }], "hasBackLogin": "Yes", "hasBackRegister": "No", "hasFrontLogin": "No", "hasFrontRegister": "No", "roleName": "administrators", "tableName": "users" }, { "backMenu": [{ "child": [{ "appFrontIcon": "cuIcon-cardboard", "buttons": ["Add", "View", "Update", "Remove", "View Comments"], "menu": "Book information", "menuJump": "list", "tableName": "tushuxinxi" }], "menu": "BookInfo manage" }, { "child": [{ "appFrontIcon": "cuIcon-discover", "buttons": ["View", "Examined"], "menu": "Chat record", "menuJump": "list", "tableName": "liaotianjilu" }], "menu": "Chat record manage" }, { "child": [{ "appFrontIcon": "cuIcon-goods", "buttons": ["View"], "menu": "ShippedOrder", "tableName": "orders/Shipped" }, { "appFrontIcon": "cuIcon-qrcode", "buttons": ["View"], "menu": "UnpaidOrder", "tableName": "orders/Unpaid" }, { "appFrontIcon": "cuIcon-phone", "buttons": ["View", "Deliver goods"], "menu": "PaidOrder", "tableName": "orders/Paid" }, { "appFrontIcon": "cuIcon-list", "buttons": ["View", "品销额"], "menu": "Completed Order", "tableName": "orders/Completed" }, { "appFrontIcon": "cuIcon-form", "buttons": ["View"], "menu": "Canceled Order", "tableName": "orders/Canceled" }, { "appFrontIcon": "cuIcon-vipcard", "buttons": ["View"], "menu": "RefundedOrder", "tableName": "orders/Refunded" }], "menu": "Order management" }], "frontMenu": [{ "child": [{ "appFrontIcon": "cuIcon-pay", "buttons": ["View", "Consultation chat"], "menu": "Book informationlist", "menuJump": "list", "tableName": "tushuxinxi" }], "menu": "Book information模块" }], "hasBackLogin": "Yes", "hasBackRegister": "Yes", "hasFrontLogin": "No", "hasFrontRegister": "No", "roleName": "seller", "tableName": "maijia" }, { "backMenu": [{ "child": [{ "appFrontIcon": "cuIcon-discover", "buttons": ["View"], "menu": "Chat record", "menuJump": "list", "tableName": "liaotianjilu" }], "menu": "Chat record manage" }, { "child": [{ "appFrontIcon": "cuIcon-favor", "buttons": ["View"], "menu": "My Collection manage", "tableName": "storeup" }], "menu": "My Collection manage" }], "frontMenu": [{ "child": [{ "appFrontIcon": "cuIcon-pay", "buttons": ["View", "Consultation chat"], "menu": "Book informationlist", "menuJump": "list", "tableName": "tushuxinxi" }], "menu": "Book information模块" }], "hasBackLogin": "Yes", "hasBackRegister": "No", "hasFrontLogin": "Yes", "hasFrontRegister": "Yes", "roleName": "user", "tableName": "yonghu" }];
  for (let i = 0; i < menus.length; i++) {
    if (menus[i].tableName == role) {
      for (let j = 0; j < menus[i].frontMenu.length; j++) {
        for (let k = 0; k < menus[i].frontMenu[j].child.length; k++) {
          if (tableName == menus[i].frontMenu[j].child[k].tableName) {
            let buttons = menus[i].frontMenu[j].child[k].buttons.join(',');
            return buttons.indexOf(key) !== -1 || false
          }
        }
      }
    }
  }
  return false;
}

/**
 *  * 获取当前时间（yyyy-MM-dd hh:mm:ss）
 *   */
export function getCurDateTime() {
  let currentTime = new Date(),
    year = currentTime.getFullYear(),
    month = currentTime.getMonth() + 1 < 10 ? '0' + (currentTime.getMonth() + 1) : currentTime.getMonth() + 1,
    day = currentTime.getDate() < 10 ? '0' + currentTime.getDate() : currentTime.getDate(),
    hour = currentTime.getHours(),
    minute = currentTime.getMinutes(),
    second = currentTime.getSeconds();
  return year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second;
}

/**
 *  * 获取当前日期（yyyy-MM-dd）
 *   */
export function getCurDate() {
  let currentTime = new Date(),
    year = currentTime.getFullYear(),
    month = currentTime.getMonth() + 1 < 10 ? '0' + (currentTime.getMonth() + 1) : currentTime.getMonth() + 1,
    day = currentTime.getDate() < 10 ? '0' + currentTime.getDate() : currentTime.getDate();
  return year + "-" + month + "-" + day;
}
