import request from "@/utils/request";
import type{ResultModel} from '@/api/model/dept'
import type { DeptModel } from "./model";
export const QueryAllApi=()=>request.get<any,ResultModel>('/depts');
export const addApi=(dept:DeptModel)=>request.post<any,ResultModel>('/depts',dept);
export const getDeptApi=(id:number)=>request.get<any,ResultModel>( `/depts/${id}`);
export const updateApi=(dept:DeptModel)=>request.put<any,ResultModel>('/depts',dept);
export const deleteDeptApi=(id:number)=>request.delete<any,ResultModel>( `/depts?id=${id}`);