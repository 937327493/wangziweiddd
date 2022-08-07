package com.wzw.wangziwei.ddd.api.servcie.file;

import com.wzw.wangziwei.ddd.api.utils.UmsResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件用的接口——File接口
 */
public interface FileFacade {
    //上传文件到oss，根本不用真的将文件传输到服务端，可以直接通过服务端请求oss服务端得到令牌，
    //前端通过令牌去把文件直接上传oss

    UmsResult uploadFile(MultipartFile multipartFile);

    UmsResult uploadFileByKey();
}
