# SC001-microservice-springCloud-parent
## 目录
* 服务端
	* [SpringCloud系统]
		* [查询客户信息](./servers/mine_service/myInterface1.md)
		* [新增客户信息](./servers/mine_service/myInterface2.md)
	* [超链接示例]
		* [我是超链接](./servers/mine_service/myInterface3.md)
 		

# 格式实例
## 接口说明
额度查询

## 权限
无

## 调用地址
URI：http://localhost:8080/service/HttpSpringCloudService


## 请求参数
| 参数名      | 必填    |  类型       |  说明  |
| --------   | -----:  | :----:     | :----: |
|  customerId  |   是    | string    | 客户ID |
|  certId  |   是    | string    | 身份证 |
|  customerName  |   是    | string    | 客户姓名 |
|  mobile  |   是    | string    | 手机号 |

## 响应数据
| 参数名      | 必填    |  类型       |  说明  |
| --------   | -----:  | :----:     | :----: |
| returnCode        | 是      |   string       |   返回码    |
| returnMsg        | 是      |   string    |   返回消息  |
| data       | 是     |   json    |  数据信息  |

## 示例
### 请求
``` json
{
    "aaa": "111",
    "bbb": "222",
    "ccc": "333",
    "ddd": "444"
}

```

### 成功返回
``` json
{
    "returnCode": "0",
    "returnMsg": "请求成功",
    "data": {
        "authAmount": "8000.00"
    }
}
```
