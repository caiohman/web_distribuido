<template>
  <p>
    {{ 
       state.test
    }}
  </p>
</template>

<script>
import  {onMounted, reactive}  from 'vue'

export default {
  name: 'App',

  setup() {
    const state = reactive({
      test: null,
    });


    onMounted(async () => {
      // const response = await fetch("http://localhost:8090/users", {mode: 'no-cors'});
      // state.test = await response.json();
      await fetch("http://localhost:8090/users")
       .then(response => response.json())
       .then(json => state.test = json)
       .catch(error => console.log(error))
    });


    return {
      state,
    };
  },
  
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
