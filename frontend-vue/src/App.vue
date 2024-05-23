<template>
  <SiteNavBar />
  <LoginScreen/>
</template>

<script>
import LoginScreen from '@/components/LoginScreen.vue';
import SiteNavBar from '@/components/SiteNavBar.vue';

export default {
    name: 'App',
    components: {
      LoginScreen,
      SiteNavBar
    },

  }

</script>

<style>
</style>
