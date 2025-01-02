<template>
  <div class="login-container">
    <div class="login-box">
      <div id="loginForm">
        <form @submit.prevent="fnLogin">
          <div class="login-textbox">
            <input name="uid" placeholder="아이디" v-model="user_id">
          </div>
          <div class="login-textbox">
            <input name="password" placeholder="비밀번호" v-model="user_pw" type="password">
          </div>
          <div class="btn-box">
            <button type="submit" class="login-btn">Login</button>
            <button type="button" class="kakao-btn" @click="kakaoLogin">
              <img src="@/assets/kakao_login_medium.png" class="kakao-btn-img" alt="카카오 로그인 로고" />
            </button>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import './UserLogin.css'
import {mapActions, mapGetters} from 'vuex'
import axios from 'axios'

export default {
  data() {
    return {
      user_id: '',
      user_pw: ''
    }
  },
  methods: {
    ...mapActions(['login']),

    async fnLogin() {
      if (this.user_id === '') {
        alert('ID를 입력하세요.')
        return
      }

      if (this.user_pw === '') {
        alert('비밀번호를 입력하세요.')
        return
      }

      try {
        let loginResult = await this.login({user_id: this.user_id, user_pw: this.user_pw})
        if (loginResult) this.goToPages()
      } catch (err) {
        if (err.message.indexOf('Network Error') > -1) {
          alert('서버에 접속할 수 없습니다. 상태를 확인해주세요.')
        } else {
          alert('로그인 정보를 확인할 수 없습니다.')
        }
      }
    },
    redirectToBackend() {
      // 백엔드의 카카오 로그인 엔드포인트로 리디렉트
      window.location.href = "http://localhost:8081/oauth2/authorization/kakao";
    },
    async kakaoLogin() {
      // const redirectUri = "http://localhost:8081/oauth/kakao/callback"; // 백엔드 카카오 콜백 URL
      // const clientId = "409b3fb04dd78999f86c8dbc4a19372a";
      // const authorizationUri = `https://kauth.kakao.com/oauth/authorize?client_id=${clientId}&redirect_uri=${redirectUri}&response_type=code`;
      //
      // // 카카오 로그인 페이지로 리디렉션
      // window.location.href = authorizationUri;
      try {
        // 백엔드로 로그인 URL을 요청
        const response = await axios.get("http://localhost:8081/oauth/kakao/login-url");
        const authorizationUri = response.data;

        // 카카오 로그인 페이지로 리디렉션
        window.location.href = authorizationUri;
      } catch (error) {
        console.error("카카오 로그인 URL을 가져오는 중 오류가 발생했습니다.", error);
      }
    },
    goToPages() {
      this.$router.push({
        name: 'Home'
      })
    }
  },
  computed: {
    ...mapGetters({
      errorState: 'getErrorState'
    })
  }
}
</script>
