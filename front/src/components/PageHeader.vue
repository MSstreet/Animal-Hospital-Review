<template>
  <header>
    <nav class="navbar">
      <div class="navbar-container">
        <!-- 왼쪽: Logo and Navigation Links -->
        <div class="navbar-left">
          <!-- Logo -->
          <div class="navbar-logo">
            <router-link to="/">리뷰</router-link>
          </div>

          <!-- Navigation Links -->
          <ul class="navbar-links">
            <li class="navbar-item" v-for="item in menuItems" :key="item.text">
              <router-link :to="item.link">{{ item.text }}</router-link>
            </li>
          </ul>
        </div>

        <!-- 오르쪽: 유저 정보 -->
        <div class="navbar-user-info">
          <router-link to="/login">Login</router-link>
        </div>

        <!-- 모바일 메뉴 버튼 -->
        <div class="navbar-toggle" @click="toggleMenu">
          <span class="navbar-toggle-icon"></span>
        </div>
      </div>
    </nav>

    <!-- 모바일 메뉴 -->
    <div class="navbar-mobile-menu" v-if="menuOpen">
      <ul class="navbar-links">
        <li class="navbar-item" v-for="item in menuItems" :key="item.text">
          <router-link :to="item.link">{{ item.text }}</router-link>
        </li>
      </ul>
    </div>
  </header>
</template>

<script>
import './PageHeader.css';

export default {
  data() {
    return {
      menuOpen: false,
      menuItems: [
        {text: '게시판', link: '/board/list'},
      ]
    };
  },
  methods: {
    toggleMenu() {
      this.menuOpen = !this.menuOpen;
    }
  }
};
</script>
