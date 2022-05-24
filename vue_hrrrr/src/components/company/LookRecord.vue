<template>
    <div>
        <!--        添加用户的对话框-->
        <el-dialog
                title="添加新员工"
                :visible.sync="addDialogVisible"
                width="40%" @close="addDialogClosed">
            <!--            对话框主题区域-->
            <el-form :model="addUserForm" :rules="addUserFormRules" ref="addUserFormRef" label-width="70px">
                <el-form-item label="账号" prop="tel">
                    <el-input v-model="addUserForm.tel"></el-input>
                </el-form-item>
                <el-form-item label="密码" prop="password">
                    <el-input v-model="addUserForm.password"></el-input>
                </el-form-item>
                <el-form-item label="姓名" prop="name">
                    <el-input v-model="addUserForm.name"></el-input>
                </el-form-item>
                <el-form-item label="身份证号" prop="identNumber">
                    <el-input v-model="addUserForm.identNumber"></el-input>
                </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
    <el-button @click="addDialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="addUser">确 定</el-button>
  </span>
        </el-dialog>
    </div>
</template>

<script>
    export default {

    }
</script>

<style scoped>

</style>