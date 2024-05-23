import { createApp } from 'vue'
import App from './App.vue'
import PrimeVue from 'primevue/config'
import 'primevue/resources/themes/aura-light-green/theme.css'
import pt from "./locales/pt.json" 
import en from "./locales/en.json" 
import { createI18n } from 'vue-i18n'

const i18n = createI18n({ 
    legacy: false,
    locale: 'pt', 
    fallbackLocale: 'en', 
    messages: { pt, en }, 
  })


const app = createApp(App)
 app.use(PrimeVue).use(i18n).mount('#app')