<template>
    <div>
        <el-menu
                :default-active="activeIndex"
                class="el-menu-demo"
                mode="horizontal"
                @select="handleSelect"
                background-color="#545c64"
                text-color="#fff"
                active-text-color="#ffd04b">
            <el-menu-item index="1">完善信息</el-menu-item>
            <el-menu-item index="2">查看档案</el-menu-item>
            <el-menu-item index="3">搜索职位</el-menu-item>
        </el-menu>

            <router-view></router-view>

    </div>
</template>

<script>
    export default {
        data() {
            return {
                activeIndex: '1'
            };
        },
        created() {
        },
        methods: {
            async handleSelect(key, keyPath) {
                var _this = this
                if(key==1){
                    console.log(key)
                    await _this.$router.push("/home")
                }else if(key==2){
                    await _this.$router.push("/look")
                }else {
                    await _this.$router.push("/findJob")
                }
            }
        }
    }
</script>

<style lang="less" scoped>

</style>