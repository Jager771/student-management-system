<template>
    <div id="app">
        <div class="col-8 offset-2">
            <table class="table caption-top table-hover">
                <caption class="text-center">
                    <h1>学生管理系统</h1>
                    <el-button type="primary" @click="getStudents">获取学生信息</el-button>
                    <el-button type="warning" @click="dialogVisible = true">添加学生</el-button>
                    <el-input type="text" placeholder="请输入姓名" class="w-25" v-model="search_name"/>
                    <el-button type="success" @click="search">搜索</el-button>

                    <el-dialog title="提示" :visible.sync="dialogVisible" width="30%" :before-close="handleClose">
                        <div>添加学生信息</div>
                        <span slot="footer" class="dialog-footer">
                            <el-button @click="dialogVisible = false">取消</el-button>
                            <el-button type="primary" @click="addStudent">添加</el-button>
                        </span>
                        <div>
                            <span>学号</span><input v-model="newStudent.number" />
                        </div>
                        <div>
                            <span>姓名</span><input v-model="newStudent.name" />
                        </div>
                        <div>
                            <span>年龄</span><input v-model.number="newStudent.age" />
                        </div>
                        <div>
                            <span>性别</span><input v-model="newStudent.gender" />
                        </div>
                    </el-dialog>
                </caption>

                <thead>
                    <tr>
                        <th scope="col">学号</th>
                        <th scope="col">姓名</th>
                        <th scope="col">年龄</th>
                        <th scope="col">性别</th>
                        <th scope="col">操作</th>
                        <th></th>
                    </tr>
                </thead>

                <tbody>
                    <Student v-for="stu in students" :key="stu.id" :student="stu"></Student>
                </tbody>
            </table>
        </div>
    </div>
</template>

<script>
import axios from 'axios'
import Student from './components/Student'
export default {
    name: 'App',
    components: {
        Student
    },
    data() {
        return {
            students: [],
            dialogVisible: false,
            newStudent: {
                number: "",
                name: "",
                age: "",
                gender: ""
            }
        }
    },
    methods: {
        getStudents() {
            axios({
                url: "http://localhost:8080/students",
                method: 'GET',
            }).then(res => {
                // console.log(res.data);
                this.students = res.data;
            })
        },
        handleClose(done) {
            this.$confirm('确认关闭？')
                .then(() => {
                    done();
                })
                .catch(() => { });
        },
        addStudent() {
            axios({
                url: 'http://localhost:8080/add',
                method: 'POST',
                data: this.newStudent
            })
            this.dialogVisible = false
        },
        search() {
            axios({
                url: "http://localhost:8080/search",
                method: "POST",
                data: {
                    name: this.search_name
                }
            }).then(res => {
                this.students = res.data;
            })
        }
    }
}



</script>

<style>

</style>
