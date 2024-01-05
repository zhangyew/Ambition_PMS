<template>
  <div class="hz">
    <editor v-model="context" />
    <div style="margin: 0 auto;display: table;margin-top: 25px; margin-bottom: 20px;">
      <el-button type="success" plain size="medium" @click="$router.back()">返回</el-button>
      <el-button type="primary" plain size="medium" @click="submitForm">下载标书</el-button>
      <!-- <el-button type="success" plain size="medium">投标</el-button> -->
      <el-button type="success" plain size="medium " v-if="zt!=-1"><router-link class="link-type" target="_blank"
              :to="{ path: '/desk_insert', query: { tenderNoticeId: this.tenderNoticeId, ProjectsId: this.tenderNoticeProjectsId }}">
              投标</router-link>
          </el-button>
    </div>
  </div>
</template>

<script>
  export default {
    components: {},
    props: {},
    data() {
      return {
        tenderNoticeId: null,
        context: null,
        tenderNoticeProjectsId: null,
      }
    },
    created() {
      this.tenderNoticeId = this.$route.params.tenderNoticeId;
      this.context = this.$route.params.context;
      this.tenderNoticeProjectsId = this.$route.params.tenderNoticeProjectsId;
    },
    mounted() {},
    methods: {
      onEditorReady(event) {
        this.event = event;
      },
    }
  }
</script>

<style>
  .hz {
    .ql-toolbar {
      display: none !important;
    }

    .d2 {
      min-width: 100%;
      height: 40px;
      position: relative;
      display: flex;
      justify-content: flex-end;

    }

    .btn1 {
      position: relative;
      right: 10px;
      top: 10px;
    }
  }
</style>
