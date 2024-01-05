<template>
  <div class="app-container">
    <div class="top">
      <div id="top_img" style="width: 100px;">
        <img src="@/assets/logo/logo2.jpg" alt="donate" height="100px" width="230px" />
      </div>
      <h1
        style="text-align: center; margin-top: -50px; margin-bottom: 75px;text-shadow: #008fff 2px 3px 8px; font-size: 40px;">
        身份认证</h1>
    </div>
    <el-form ref="registerForm" :model="registerForm" :rules="registerRules" class="register-form"
      style="margin: 0 auto;margin-top: 60px;">
      <!-- <h3 class="title">远志供应商系统</h3> -->
      <el-form-item prop="number">
        <el-input v-model="registerForm.number" type="text" placeholder="供应商编码" @blur="handBlur()">
          <svg-icon slot="prefix" icon-class="user" class="el-input__icon input-icon" />
        </el-input>
      </el-form-item>
      <el-form-item prop="phone">
        <el-input style="width: 238px;" v-model="registerForm.phone" type="phone" placeholder="手机号码">
          <svg-icon slot="prefix" icon-class="password" class="el-input__icon input-icon" />
        </el-input>
        <el-button style="height: 38px;" @click="getCode()">发送验证码</el-button>
      </el-form-item>
      <el-form-item prop="code">
        <el-input v-model="registerForm.code" placeholder="短信验证码">
          <svg-icon slot="prefix" icon-class="validCode" class="el-input__icon input-icon" />
        </el-input>
      </el-form-item>
      <el-form-item style="width:100%;">
        <el-button size="medium" type="primary" style="width:100%;" @click="ok()">
          认证
        </el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
  // import { getCodeImg, register } from "@/api/login";
  import {
    selCount,
    selRe,
    codeVa,
    updateExist
  } from "@/api/public/vendor";

  export default {
    name: "Register",
    data() {
      return {
        url:'https://cn.bing.com/images/search?view=detailV2&ccid=z2zfEXVc&id=B057F1A8EE3C7AEEC2D3210C04015245502FF8FC&thid=OIP.z2zfEXVcxOn9vHoBPFfYdgAAAA&mediaurl=https%3a%2f%2fts1.cn.mm.bing.net%2fth%2fid%2fR-C.cf6cdf11755cc4e9fdbc7a013c57d876%3frik%3d%252fPgvUEVSAQQMIQ%26riu%3dhttp%253a%252f%252fimg95.699pic.com%252fphoto%252f40143%252f5768.gif_wh300.gif!%252ffh%252f188%26ehk%3d6GbQh0YW8IzE%252bekNUbEKWpTcdtdcLSukYekJcFQAraM%253d%26risl%3d%26pid%3dImgRaw%26r%3d0&exph=188&expw=334&q=%e5%95%86%e4%b8%9a%e5%8a%a8%e6%80%81%e8%83%8c%e6%99%af%e5%9b%be&simid=608046784235140206&FORM=IRPRST&ck=4975ABD31A5FFE2EE31758239DC1D15C&selectedIndex=66&itb=0&ajaxhist=0&ajaxserp=0',

        reYzm: "",
        registerForm: {
          number: "",
          phone: "",
          code: "",
        },
        registerRules: {
          number: [{
            required: true,
            trigger: "blur",
            message: "请输入您的编码"
          }, ],
          phone: [{
            required: true,
            trigger: "blur",
            message: "请输入您的手机号码"
          }, ],
          code: [{
            required: true,
            trigger: "change",
            message: "请输入验证码"
          }]
        },
      };
    },
    created() {

    },
    methods: {
      getCode() {
        if (this.registerForm.phone != "") {
          codeVa(this.registerForm.phone).then(res => {
            // console.log(res);
            this.reYzm = res;
          });
        }else{
          this.$message.error("请先填写手机号码!");
          return false;
        }
      },
      handBlur() {
        // console.log(this.registerForm.number);
        selCount(this.registerForm.number).then(res => {
          console.log(res);
          if (res < 1) {
            this.$message.error("编码不存在!");
            return false;
          }
        });
      },
      ok() {
        let bm = this.registerForm.number;
        let hm = this.registerForm.phone;
        let yzm = this.registerForm.code;
        console.log("发送的验证码" + this.reYzm);
        console.log("填写的验证码" + yzm);
        //判断验证码是否一致
        if (yzm != this.reYzm) {
          this.$message.error("验证码不一致!");
          return false;
        }
        selRe(bm, hm).then(res => {
          if (res = 1) {
            let cat = localStorage.getItem("userId");
            console.log("uid:" + cat);
            //setUid
            updateExist(cat, bm).then(res => {
              console.log("!!!!" + res);
              this.$modal.msgSuccess("认证成功!");
              this.$router.back();
            });
          }
        });
      }
    }
  };
</script>

<style rel="stylesheet/scss" lang="scss">
  .register {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100%;
    background-image: url("../assets/images/login-background.jpg");
    background-size: cover;
  }

  .title {
    margin: 0px auto 30px auto;
    text-align: center;
    color: #707070;
  }

  .register-form {
    border-radius: 6px;
    background: #ffffff;
    width: 400px;
    padding: 25px 25px 5px 25px;

    .el-input {
      height: 38px;

      input {
        height: 38px;
      }
    }

    .input-icon {
      height: 39px;
      width: 14px;
      margin-left: 2px;
    }
  }

  .register-tip {
    font-size: 13px;
    text-align: center;
    color: #bfbfbf;
  }

  .register-code {
    width: 33%;
    height: 38px;
    float: right;

    img {
      cursor: pointer;
      vertical-align: middle;
    }
  }

  .el-register-footer {
    height: 40px;
    line-height: 40px;
    position: fixed;
    bottom: 0;
    width: 100%;
    text-align: center;
    color: #fff;
    font-family: Arial;
    font-size: 12px;
    letter-spacing: 1px;
  }

  .register-code-img {
    height: 38px;
  }
</style>
