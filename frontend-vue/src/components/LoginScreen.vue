<template>
  <div class="screen-size screen-item-position">
    <Card class="card-position card-dimension">
      <template #header>
        <div class="logo-position">
          <img alt="company name" :src="cardImage" class="logo"  />
        </div>
      </template>
      <template #title>Login</template>
      <template #content >
        <br />
        <FloatLabel>
          <InputText id="username" v-model="value" />
          <label for="username">Username</label>
        </FloatLabel> 
        <br/>
        <br/>
        <FloatLabel>
          <Password v-model="value" inputId="password" :feedback="false"/>
          <label for="password">Password</label>
        </FloatLabel>
      </template>
      <template #footer>
          <div class="footer-itens-position">
            <Button label="Login" severity="secondary" outlined class="w-full" />
            <Button label="Cadastro" class="w-full" />
          </div>
      </template>
    </Card>
  </div>
  
</template>
  
<script>
  import  {onMounted, reactive}  from 'vue'
  import Button from 'primevue/button';
  import Card from 'primevue/card';
  import InputText from 'primevue/inputtext';
  import FloatLabel from 'primevue/floatlabel';
  import logo from '@/assets/logo-site.png';
  import Password from 'primevue/password';
  
  export default {
    name: 'LoginScreen',
    components: {
      Button,
      Card,
      InputText,
      FloatLabel,
      Password
    },
  
    setup() {
      const state = reactive({
        test: null,
      });
      
      
  
      onMounted(async () => {
        await fetch("http://localhost:8090/users")
         .then(response => response.json())
         .then(json => state.test = json)
         .catch(error => console.log(error))
      });
  
  
      return {
        state,
      };
    },

    data() {
        return {
          cardImage : logo
        }
    }
    
  }
</script>
<style>
.screen-size {
  width: 100%;
  min-height:100vh;
  height:100vh; 
  max-height:100vh;
}
.screen-item-position {
  display: flex;
  justify-content: center;
  align-items: center;
}
.card-position {
  display: flex;
  justify-content: center; 
}
.card-dimension {
  width: 50%;
  height: 50%;
}
.logo {
  width: 30%;
  height: 40%;
}
.footer-itens-position {
  display: flex;
  justify-content: space-between;
}
.logo-position {
  display: flex;
  justify-content: flex-end;
}

</style>
  
  