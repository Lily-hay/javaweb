export let checkName=()=>
    {
        let flag=1;
        let usernameValue=document.querySelector("#username").value;
        if(usernameValue.length<4 || usernameValue.length>16)
        {
            document.querySelector("#name_msg").innerHTML='用户名不合法';
            flag=0;
        }
        else{
            document.querySelector("#name_msg").innerHTML='';
        }
        return flag;

    }
 export   let checkPhone=()=>
    {
        let flag=1;
        let phoneValue=document.querySelector("#phone").value;
        if(phoneValue.length!=11)
        {
            document.querySelector("#phone_msg").innerHTML='用户名不合法';
            flag=0;
        }
        else{
            document.querySelector("#phone_msg").innerHTML='';
        }
        return flag;

    }