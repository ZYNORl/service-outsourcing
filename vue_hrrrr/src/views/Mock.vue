<template>
    <div>
        <button @click="getGoodList">获取商品泪飙</button>
    </div>
</template>

<script>
    export default {
        methods:{
            async getGoodList(){
               const {data:res}  = await this.$http.get('/api/getMenus')
                console.log(res)
            }

        }
    }
</script>

<style scoped>

</style>