<template>
    <Toolbar>
        <template #end> 
            <Dropdown v-model="selectedLanguage" :options="languages" optionLabel="name" :placeholder="language" class="w-full md:w-14rem" @change="changeLocale"/>
        </template>
    </Toolbar>    
</template>
    
  <script>
    import { ref } from 'vue'
    import Dropdown from 'primevue/dropdown';
    import Toolbar from 'primevue/toolbar';
    import { useI18n } from 'vue-i18n';
  
    export default {
      name: 'SiteNavBar',
      components: {
        Toolbar,
        Dropdown,
      },
    
      setup() {

        const { t } = useI18n();

        const languages = ref([
            {
                name: 'Brasil',
            },
            {
                name: 'USA',
            }
        ]);

        const selectedLanguage = ref();

        return {
          languages, selectedLanguage, t
        };
      },

      computed: {
        language() {
            return this.t("navbar.country");
        }
      },

      methods: {
        changeLocale() {
            console.log(this.selectedLanguage)
            if(this.selectedLanguage.name === 'Brasil') {
                console.log('Brasil');
                this.$i18n.locale = 'pt';  
                return;
            }
            if(this.selectedLanguage.name === 'USA') {
                console.log('USA');
                this.$i18n.locale = 'en';  
                return;
            }
        }
      }

    }
  </script>
  <style>
  </style>
    
    