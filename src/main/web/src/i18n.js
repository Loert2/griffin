import i18n from 'i18next';
import Backend from 'i18next-xhr-backend';
import LanguageDetector from 'i18next-browser-languagedetector';
import { initReactI18next } from 'react-i18next';

i18n
   .use(LanguageDetector)
   .use(Backend)
   .use(initReactI18next)
   .init({
      fallbackLng: 'en',

      whitelist: ['en', 'ru',],
      nonExplicitWhitelist: true,
      load: 'languageOnly',

      // have a common namespace used around the full app
      ns: ['translations'],
      defaultNS: 'translations',

      nsSeparator: false,
      keySeparator: false,

      debug: false,

      interpolation: {
         escapeValue: false, // not needed for react!!
      },

      react: {
         wait: true,
         bindI18n: 'languageChanged loaded'
      },

      backend: {
         loadPath: '/rest-api/i18n/{{lng}}.json'
      }

   });


export default i18n;