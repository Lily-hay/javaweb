/* import './assets/main.css' */

import { createApp } from 'vue'
import App from './App.vue'

import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import zhCn from 'element-plus/es/locale/lang/zh-cn'

const app = createApp(App)
app.mount('#app')
app.use(ElementPlus, {
  locale: zhCn,
})
