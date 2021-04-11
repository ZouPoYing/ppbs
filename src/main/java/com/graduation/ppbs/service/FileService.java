package com.graduation.ppbs.service;

import com.graduation.ppbs.dao.File;
import com.graduation.ppbs.dao.Set;
import com.graduation.ppbs.mapper.FileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileService {

    @Autowired(required = false)
    private FileMapper fileMapper;

    public void fileUpload(String filename, Integer userid) throws Exception {
        fileMapper.fileUpload(filename,userid);
    }

    public File getFileByFilename(String filename) throws Exception {
        return fileMapper.getFileByFilename(filename);
    }

    public File getFileByFileid(Integer fileid) throws Exception {
        return fileMapper.getFileByFileid(fileid);
    }
}
