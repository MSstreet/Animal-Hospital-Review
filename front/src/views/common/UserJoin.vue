<template>
  <div class="join-container">
    <div class="join-box">
      <h2>JOIN</h2>
      <div id="joinForm">
        <form @submit.prevent="fnLogin">
          <div class="textbox">
            <input name="uid" placeholder="아이디" v-model="user_id">
          </div>
          <div class="textbox">
            <input name="password" placeholder="비밀번호" v-model="user_pw">
          </div>
          <div class="textbox">
            <input name="passwordChk" placeholder="비밀번호 확인" v-model="user_pw_chk" type="password">
          </div>
          <div class="textbox">
            <input name="email" placeholder="이메일" v-model="user_email" type="password">
          </div>
          <div class="textbox">
            <input name="name" placeholder="이름" v-model="user_name" type="password">
          </div>
          <div class="textbox">
            <input name="zipCode" placeholder="우편번호" v-model="user_zip_code" type="password">
          </div>
          <div class="textbox">
            <input name="address" placeholder="주소" v-model="user_address" type="password">
          </div>
          <div class="textbox">
            <input name="addressDtl" placeholder="상세주소" v-model="user_address_dtl" type="password">
          </div>
          <div class="btn-box">
            <button type="submit" class="btn">Join</button>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>
<script setup lang="ts">
</script>