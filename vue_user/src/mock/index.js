//导入模拟数据的包
import Mock from 'mockjs'
//通过mock()函数模拟API接口
Mock.mock('http://www.ysqorz.top:8888/api/private/v1/api/goodsList','get',{
    status:200,
    message:'获取商品列表成功',
    data:[1,2,3,4]
})
Mock.mock('http://www.ysqorz.top:8888/api/private/v1/api/getMenus','get',{
    meta:{message:'获取菜单列表成功',status:200},
    data:[{
        id:125,
        authName:'员工管理',
        path:'users',
        children:[{authName:'员工列表',children:null,path:'users'}]
    },{
        id:103,
        authName:'招聘管理',
        children:[{authName:'发布招聘',children:null},{authName:'搜索简历',children:null}]
    },{
        id:101,
        authName:'出勤管理',
        children:[{authName:'出勤列表',children:null}]
    },{
        id:102,
        authName:'绩效管理',
        children:[{authName:'绩效列表',children:null}]
    },{
        id:145,
        authName:'数据统计',
        children:[{authName:'出勤统计',children:null},{authName:'绩效统计',children:null}]
    }]
})


const Random = Mock.Random // Mock.Random 是一个工具类，用于生成各种随机数据
const userList = [] // 用于接受生成数据的数组
//生成随机手机号码
const phonePrefix = ['132','135','189','187','166','162']
//生成随机职称
const role_name = ['java初级工程师','java中级工程师','java高级工程师','java架构师','UI设计师','web前端开发工程师','项目经理','运维工程师','测试工程师']
//生成学历
const role_edu = ['大学专科','大学本科','硕士研究生']
for (let i = 0; i < 206; i++) { // 可自定义生成的个数
    const index=Math.floor(Math.random()*phonePrefix.length)
    const i=Math.floor(Math.random()*role_name.length)
    const j=Math.floor(Math.random()*role_edu.length)
    const temp = {
        'id': Random.increment(), // 生成2到10个字符之间的字符串
        'username': Random.cname(2,4), // 模拟全名
        'role_name': role_name[i], // .通过Random.csentence( min?, max? )指定句子汉字个数的范围：
        'role_age': Random.natural(18, 40), // 生成1到100之间的整数
        'role_edu': role_edu[j], // 生成0到100之间的浮点数,小数点后尾数为0到5位
        'email': Random.email(), // 生成随机字符串,可加参数定义规则
        'mobile':phonePrefix[index]+Mock.mock(/\d{8}/),
        'mg_state':true
    }
    userList.push(temp)
}    // list 分页接口()
    Mock.mock('http://www.ysqorz.top:8888/api/private/v1/api/userlists', 'post', (params) => {
        const queryInfo = JSON.parse(params.body)
        const index= queryInfo.pagenum
         const [ size, total] = [ queryInfo.pagesize, userList.length]
        const len = total / size
        const totalPages = len - parseInt(len) > 0 ? parseInt(len) + 1 : len
        const newUserList = userList.slice(index * size, (index + 1) * size)
        return {
            'code': 200,
            'message': '获取员工列表成功',
            'data': {
                'pagenum': index,
                'pagesize': size,
                'users': newUserList,
                'total': total,
                'totalPages':totalPages,
            }
        }
    })

