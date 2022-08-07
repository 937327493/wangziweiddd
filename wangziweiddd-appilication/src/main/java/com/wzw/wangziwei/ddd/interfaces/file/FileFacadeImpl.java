package com.wzw.wangziwei.ddd.interfaces.file;

import com.wzw.wangziwei.ddd.api.servcie.file.FileFacade;
import com.wzw.wangziwei.ddd.api.utils.UmsResult;
import org.springframework.web.multipart.MultipartFile;

public class FileFacadeImpl implements FileFacade {
    @Override
    public UmsResult uploadFile(MultipartFile multipartFile) {
        return null;
    }

    @Override
    public UmsResult uploadFileByKey() {
        return null;
    }
}
