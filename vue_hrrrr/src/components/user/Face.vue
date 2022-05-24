<template>
  <div>
    <div align="center">
      <p ref="hhh" id="flag" class="tishi"></p>
    </div>
    <div class="getface">
      <video
        id="video"
        width="400px"
        height="400px"
        autoplay="autoplay"
      ></video>
      <canvas
        id="canvas"
        width="400px"
        height="400px"
        style="display: none;"
      ></canvas>
      <img id="imgTag" src="" alt="imgTag" style="display: none;" />
    </div>
  </div>
</template>

<script>
  import user from './Users'
  import $ from 'jquery'
export default {
  data() {
    return {
      addUserQuery:{userid:window.sessionStorage.getItem("addUserId"),comid:window.sessionStorage.getItem("comId")},
      mediaStreamTrack:'',
        number: 0,
    };
  },
  mounted() {

    this.loadTime();
  },
  methods: {
    loadTime() {
      this.openMedia();
      setTimeout(()=>{
          this.$refs.hhh.innerHTML="正在打开摄像头"
      }, "1000");
      setTimeout(()=>{
          this.$refs.hhh.innerHTML="请正视摄像头"
      }, "3000");
      setTimeout(()=>{
          this.takePhoto()
      }, "5000");
    },
    async tishi() {
      window.location.href = "/users";
    },
    openMedia() {
      let constraints = {
        video: { width: 500, height: 500 },
        audio: false
      };
      let this_ = this
      //获得video摄像头
      let video = document.getElementById("video");
      let promise = navigator.mediaDevices.getUserMedia(constraints);
      promise.then(mediaStream => {
        this_.mediaStreamTrack =
          typeof mediaStream.stop === "function"
            ? mediaStream
            : mediaStream.getTracks()[1];
        video.srcObject = mediaStream;
        window.stream = mediaStream
        video.play();
      });
    },
    takePhoto() {
      var _this = this
      //获得Canvas对象
      this.number++;
      let video = document.getElementById("video");
      let canvas = document.getElementById("canvas");
      let ctx = canvas.getContext("2d");
      ctx.drawImage(video, 0, 0, 500, 500); // toDataURL  ---  可传入'image/png'---默认, 'image/jpeg'
      let img = document.getElementById("canvas").toDataURL();
      // 这里的img就是得到的图片
      console.log("img-----", img);
      document.getElementById("imgTag").src = img;

      //String base64encodedString = Base64.getEncoder().encodeToString(img.getBytes("utf-8"));
        this.$refs.hhh.innerHTML="正在识别"
      $.ajax({
        url: "http://localhost:83/searchface", //请求的url地址
        dataType: "json", //返回格式为json
        async: true, //请求是否异步，默认为异步，这也是ajax重要特性
        //contentType:"application/json",
        data: { imagebast64: img }, //参数值
        type: "POST", //请求方式
        success: function(data) {
          console.log('我进来了')
          if (data === "fail" || data.score.substr(0, 2) < 80) {
            $("#flag").html("识别失败，请保持人像处于框内 2秒后重新识别");
            if (this.number < 10) {
              setTimeout("takePhoto()", 3000);
            } else {
              $("#flag").html("三秒后回到主页");
              console.log("jjjj")
              _this.closeMedia()
              console.log("jjjj")
              setTimeout(()=>{_this.$router.push({path:'/users'})}, 3000);
            }
          }
          if (data.score.substr(0, 2) > 80) {
            $("#flag").html("识别成功")
            _this.$http.get('company/face/addUser',{params:_this.addUserQuery});
            _this.$message.success("操作完成")
             _this.closeMedia()
            user.methods.getUerList()
            _this.$router.push({path:'/users'})
          }
        }
      });
    },
      // 关闭摄像头
    closeMedia() {
      this.MediaStreamTrack=null;
      window.stream.getTracks().forEach(track => track.stop())
}
  }
};
</script>

<style lang="less" scoped>
.getface {
  position: absolute;
  top: 20%;
  left: 35%;
}
.tishi {
  font-size: 20px;
}
</style>
