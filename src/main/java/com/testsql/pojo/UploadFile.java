package com.testsql.pojo;

import lombok.Data;

@Data
public class UploadFile {

    public int id;
    public String file_name;
    public String file_suffix;
    public String file_type;
    public int file_size;

    public UploadFile() {
    }

    public UploadFile(int id, String file_name, String file_suffix, String file_type, int file_size) {
        super();
        this.id = id;
        this.file_name = file_name;
        this.file_suffix = file_suffix;
        this.file_type = file_type;
        this.file_size = file_size;
    }
}
