package com.juhe.my01.testng.juhe.case01.clearsetter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.juhe.my01.utils.EncryDecryUtils;
import com.juhe.my01.utils.Undecode_util;
import org.testng.annotations.Test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * ClassName: DataTest
 * Description: 业务系统报送清结算报文解密
 * date: 2020/7/14 17:36
 *
 * @author ZouQi
 * @version 1.0
 * @since JDK 1.8
 */
public class clearSetter_Test {

    /**
     * 抓取业务系统（退款系统）上报清结算数据
     * 先通过UrlDecode解密、在通过3DES混合base64进行解密
     */

    @Test
    public void test() {
        String data = "6Kj9Fm4fE9ljvklkudVnEXlzYPk8JX64RCoc45vJwrwun5EVRpo5hAo4mVIPjMt6pMPz7NvaPOqn%0As18rfBInP%2BCqZjFIfPw%2FHnlJxwvLyMfGQEs5I5Dop4QosUr1UG3Bys6u8tcK3gf2PowJLeOhiGl7%0Aabdh%2Bld17XMqStJha4fkEl4YdYnNlkmb\n" +
                "1hnOEiqtPLeVWgNtwfaU4KdU%2FSnNBePynG%2FJVcfK578g%0AelqEoe5pEz%2FOGbCgCOLyV9fV0XaHv3uvHX8hcjSxjHEdy%2B0uVVVrnVm%2BDhPiUWzw0LDcjRUb1I0s%0AAzQe6Q6K08ddFngJ3MIj9qDQCtqh0Jr8xDiu0knUXf%2BSQkFhxuflfj5FsRelJ6Q1qZI%2FvX2zD3oP%0AqcxfL9b1ZtJOdqAK%2\n" +
                "BHNcmbAVjZdQOSA6j5p2juRlUxhGx5qQgWRhx8jGFnlAYBhlBMoAtYm1cU33%0ArNAi5MIZELqX1V%2BKDHHYr%2FCVN5uGJ7Ta7FpdzDwh4XutwxYkUYWxJNlmgjA%2BSbj16b2GKTNmdkkO%0AR5QuS1nK42bbmgBsXbn0nklSXdOueF%2BA4TvVeYqZZDW8L6nU9MPmI5XP3i6%2F6qx6bY8bgpNvZ9yF%0AHEie9f\n" +
                "wxexnVOmB2U6zuZxlqGeTYNXn2I1u5icsICNrZbrxokQz57GZBFjT8iEAoO%2Bi5cVuk2EkH%0AOP4VatSS2fycV3qMFF2bf5hXVXQFH19MLbODzFFaY55ZJIqqmesMuLhZUp1sT6NHPw22FLUAsd%2FG%0AuaZFsgbZbovIkcYon150bjXiaabeKiay%2BHMLshCJI3kpAGe0XHNqgSk9Lzh12QFGyv7PEnJJtlrE%0A\n" +
                "6bRBK1QxEQCwwY%2BFIT5XhceocM3ThWcng2FENd7OS1KDdl9Z6Z59Vm4aSych1yRyw%2FC%2BNaynWGTt%0AJqrhE%2BPs8KtQ32G6DmUPNAL7vP%2FpJ%2BUQxZwkCYlzNOft020kNuflZGQULQtBSJoq9LQzYmE19cWc%0AQXBexhSBQevN%2BC0t6hPmWHrJevK9%2BMSfJZvB0nnyLCdRdxtNTMD22BVBwatPl8C\n" +
                "0ZUkKV68cReib%0ABu4FE5tW6FzU5xB1Xt8mTElO3WCgkMGSqlGhbB2SeKjL1X99MMG%2B1BmElYQh5WkkOcAVfb5wCkmF%0AV94QMPQ1RFQB%2BrF4RX66rXo7OnIAdVrDjIjcRtKy0rPWMsAUvCVej6KdDca1qzqRWPaAcp%2BpRnVh%0A1c4%2BbvOiLWRRLX3zkeConJSxaUFAPXtKUl3TrnhfgOE71XmKmWQ1vIn\n" +
                "IT6D3zIo241ocfIUnwbp0%0AqQqHmlBawPwzAbi%2FP%2Fcp12mR0zMO6K0V86QVNOMq3mRza%2BaT4cJqPLeVWgNtwfaU4KdU%2FSnNBY6B%0Abxg8T0rkBPKdVI%2B6SV%2Bali9mvpWqed%2BQpxL4tlj%2FS2KuzvO6QsQU44F%2BKe7brlUpGKr83yGFXuxl%0A0VCbeYYYF9BRZqlNOpwWYRgGV1LdZ6aQX3382\n" +
                "ARp4ZU%2FAsvuf1%2BvCT77rEmfyzUtZloCIKzHOVrc%0AlNlnJacLXbZUa%2FQ4%2FClSOHZ4c4nXV37OKNCss%2FAuNLer9SQ7ojXbbxfoWfV1%2FY%2BdkP1ief8VJGly%0AotFxr7MF%2FKMy8ZvwLjS3q%2FUkO8cVdgmSTPxcPleFx6hwzdOFZyeDYUQ13rSrfZhpDadOX68zUSEd%0Aw7DKDXBayW%2FanzuXA\n" +
                "qNLQ2cppdKTBq3KE06XPzJoQhjt8Q%3D%3D";
        data = Undecode_util.res(data);
//        String result = EncryDecryUtils.decryptFromBase64DES("doxfqtoh69gosffefmqcuaqk", data);//测试环境
        String result = EncryDecryUtils.decryptFromBase64DES("o751qdkkv4ymc6xohpsl1qmw",data);//生产环境
        //parseObject 字符转JSON  toJSONString(,true) JSON格式打印数据
        System.out.println(JSON.toJSONString(JSONObject.parseObject(result), true));
    }
}
