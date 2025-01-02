<template>
  <div class="join-container">
    <div class="join-box">

      <div id="joinForm">
        <form @submit.prevent="fnJoin">
          <div class="join-textbox">
            <input name="uid" placeholder="아이디" v-model="user_id">
          </div>
          <div class="join-textbox">
            <input name="password" placeholder="비밀번호" v-model="user_pw">
          </div>
          <div class="join-textbox">
            <input name="passwordChk" placeholder="비밀번호 확인" v-model="user_pw_chk" type="password">
          </div>
          <div class="join-textbox">
            <input name="email" placeholder="이메일" v-model="user_email">
          </div>
          <div class="join-textbox">
            <input name="name" placeholder="이름" v-model="user_name">
          </div>
          <div class="join-textbox">
            <input name="zipCode" placeholder="우편번호" v-model="user_zip_code">
          </div>
          <div class="join-textbox">
            <input name="address" placeholder="주소" v-model="user_address">
          </div>
          <div class="join-textbox">
            <input name="addressDtl" placeholder="상세주소" v-model="user_address_dtl">
          </div>
          <div class="join-btn-box">
            <button type="submit" class="join-btn">Join</button>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>
<script>
import './UserJoin.css'
import {mapActions, mapGetters} from "vuex";

export default {
  data() {
    return {
      user_id: '',
      user_pw: '',
      user_pw_chk: '',
      user_email: '',
      user_name: '',
      user_zip_code: '',
      user_address: '',
      user_address_dtl: '',
    }
  },
  methods: {
    ...mapActions(['']),

    async fnJoin() {       //async 함수로 변경
      try {
        let joinResult = await this.join( {
          user_id: this.user_id,
          user_pw: this.user_pw,
          user_email:this.user_email,
          user_name: this.user_name,
          user_zip_code: this.user_zip_code,
          user_address: this.user_address,
          user_address_dtl: this.user_address_dtl,
        })
        if (joinResult) {
          alert("가입이 완료되었습니다!")
        }
      }
      catch (err) {
        if (err.message.indexOf('Network Error') > -1) {
          alert('서버에 접속할 수 없습니다. 상태를 확인해주세요.')
        } else {
          alert('실패')
        }
      }
    },
  },
  computed: {
    ...mapGetters({
      errorState: 'getErrorState'
    })
  }
}
</script>