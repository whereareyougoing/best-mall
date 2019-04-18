package com.imooc.mall.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author 宋艾衡
 * @date 2019/4/12 15:35
 * @desc
 */
public interface IFileService {
    String upload(MultipartFile file, String path);
}
