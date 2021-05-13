package com.webank.scaffold.artifact;

import com.webank.scaffold.config.GeneratorOptions;
import com.webank.scaffold.config.UserConfig;
import com.webank.scaffold.util.PackageNameUtil;
import java.io.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author aaronchu
 * @Description
 * @data 2021/01/20
 */
public class NewTestJavaDir extends TestJavaDir {
    private static final Logger logger = LoggerFactory.getLogger(NewTestJavaDir.class);

    private UserConfig config;

    public NewTestJavaDir(File parentDir,  UserConfig userConfig) {
        super(parentDir, userConfig);
        this.config = userConfig;
    }

    @Override
    protected void doGenerateSubContents() throws Exception {
        /**
         * 1. Build sub directory due to package name
         */
        String groupName = this.config.getProperty(GeneratorOptions.GENERATOR_GROUP);
        String artifactName = this.config.getProperty(GeneratorOptions.GENERATOR_ARTIFACT);
        String packageName = groupName + "." + artifactName;
        File packageDir = new File(this.toFile(), packageName);
        //packageDir.mkdirs();
        handleDemoPkey();
    }

    @Override
    public String getName() {
        return "java";
    }

    private void handleDemoPkey()  throws Exception{
        File javaDir = this.toFile();
        String utilsPackage = PackageNameUtil.getRootPackageName(config);
        DemoPkeyTestJava demoPkeyTestJava = new DemoPkeyTestJava(PackageNameUtil.convertPackageToFile(javaDir,utilsPackage), config);
        demoPkeyTestJava.generate();
    }
}