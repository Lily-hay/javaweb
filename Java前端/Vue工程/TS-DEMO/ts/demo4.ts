let add=(x:number,y:number):number=>{
    return x+y;
}
let sum_ad:number=add(10,20);
console.log(sum_ad);
function getFullName(firstName:string,lastName?:string)
{
    if(lastName)
    {
        console.log(`${firstName}.${lastName}`);
        return;
    }
    console.log(`${firstName}`)
}
getFullName('Tom','Cat')
getFullName('Jerry')