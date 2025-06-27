//DOM元素，离焦事件，校验
import { checkName,checkPhone } from "./checkFn.js";
       let input1=document.querySelector("#username");
       
       input1.addEventListener('blur',checkName);

      let input2=document.querySelector("#phone");
      
       input2.addEventListener('blur',checkPhone)
       
       //校验表单提交是否合法
       document.querySelector("form").addEventListener('submit',(event)=>
    {
        if(!checkName() || !checkPhone())
    {
        event.preventDefault();//阻止表单提交
    }
    })