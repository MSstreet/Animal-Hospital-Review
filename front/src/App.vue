<template>
  <PageHeader/> <!-- 헤더 컴포넌트 -->
  <router-view/>  <!-- 페이지 이동이 표시될 곳 -->
</template>

<script>
import PageHeader from '@/components/PageHeader'

export default {
  name: 'App',
  components: {
    PageHeader
  }
}
</script>

<style>
#app {
  display: flex;
  flex-direction: column;
  height: 100%;
  margin: 0;
  padding: 0;
  text-align: center;
}

* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

html, body {
  height: 100%;
  margin: 0;
  padding: 0;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>