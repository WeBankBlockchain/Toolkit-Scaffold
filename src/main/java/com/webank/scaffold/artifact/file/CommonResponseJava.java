package com.webank.scaffold.artifact.file;

import com.webank.scaffold.artifact.Artifact;
import com.webank.scaffold.config.UserConfig;
import com.webank.scaffold.constants.FileNameConstants;
import com.webank.scaffold.constants.ReplaceConstants;
import com.webank.scaffold.util.IOUtil;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class CommonResponseJava implements Artifact {

    private File parentDir;
    private UserConfig config;

    public CommonResponseJava(File parentDir, UserConfig config){
        this.parentDir = parentDir;
        this.config = config;
    }

    @Override
    public void generate() throws Exception {
        this.parentDir.mkdirs();
        String pkg = config.getGroup() + "." + config.getArtifact() + ".model";
        Map<String, String> map = new HashMap<>();
        map.put(ReplaceConstants.PACKAGE, pkg);
        IOUtil.replaceAllStr(FileNameConstants.TEMPLATE_COMMONRESPONSE, map, this.toFile());
    }

    @Override
    public File getParentDir() {
        return parentDir;
    }

    @Override
    public String getName() {
        return FileNameConstants.COMMON_RESPONSE_JAVA;
    }

}
