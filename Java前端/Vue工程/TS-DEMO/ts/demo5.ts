//对象接口
interface User{
    name:string,
    age:number,
    say?():void
}
let stu:User={
    name:'wusong',
    age:45,
    say()
    {
        console.log('爱打老虎........')
    }

}
console.log(stu.name+stu.age)
console.log(stu.say)