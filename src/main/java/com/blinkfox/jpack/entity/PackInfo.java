package com.blinkfox.jpack.entity;

import com.blinkfox.jpack.consts.PlatformEnum;
import com.blinkfox.jpack.consts.SkipErrorEnum;

import java.io.File;

/**
 * 在各个平台打包时所需要封装的参数信息的实体类.
 *
 * @author blinkfox on 2019-04-28.
 */
public class PackInfo {

    /**
     * jar 包后缀常量.
     */
    private static final String JAR = ".jar";

    /**
     * maven 生成的 target 文件目录.
     */
    private File targetDir;

    /**
     * 各平台打包的主文件目录.
     */
    private File homeDir;

    /**
     * 所打包项目的 artifactId.
     */
    private String artifactId;

    /**
     * 所打包项目的 version.
     */
    private String version;

    /**
     * 所打包项目的名称.
     */
    private String name;

    /**
     * 所打包项目的描述信息.
     */
    private String description;

    /**
     * 运行 Java 程序的 JVM 选项参数.
     */
    private String vmOptions;

    /**
     * 程序运行时需要的其他参数.
     */
    private String programArgs;

    /**
     * 运行 SpringBoot 程序所需要的配置文件路径，可以是相对路径或者绝对路径.
     */
    private String[] configFiles;

    /**
     * 执行过程中是否跳过异常或错误，如果为true则直跳过不抛异常，否则抛出异常，默认值是default，会折中做了默认处理.
     */
    private SkipErrorEnum skipError;

    /**
     * 构建 Windowns 发布包相关的个性化参数配置.
     */
    private Windows windows;

    /**
     * 构建 Linux 发布包相关的个性化参数配置.
     */
    private Linux linux;

    /**
     * 构建 Docker 发布包相关的个性化参数配置.
     */
    private Docker docker;

    /**
     * 需要排除（即不生成）的文件或目录.
     */
    private String[] excludeFiles;

    /**
     * 复制相关资源到各平台包的中的自定义配置参数.
     */
    private CopyResource[] copyResources;

    /**
     * 创建一个新的、具有公共信息的 PackInfo 对象实例.
     *
     * @param packInfo PackInfo 对象
     * @return 新的 PackInfo 对象
     */
    public static PackInfo newCommonPackInfo(PackInfo packInfo) {
        return new PackInfo()
                .setTargetDir(packInfo.getTargetDir())
                .setHomeDir(packInfo.getHomeDir())
                .setArtifactId(packInfo.getArtifactId())
                .setVersion(packInfo.getVersion())
                .setName(packInfo.getName())
                .setDescription(packInfo.getDescription())
                .setVmOptions(packInfo.getVmOptions())
                .setProgramArgs(packInfo.getProgramArgs())
                .setConfigFiles(packInfo.getConfigFiles())
                .setSkipError(packInfo.getSkipError())
                .setWindows(packInfo.getWindows())
                .setLinux(packInfo.getLinux())
                .setDocker(packInfo.getDocker())
                .setExcludeFiles(packInfo.getExcludeFiles())
                .setCopyResources(packInfo.getCopyResources());
    }

    /**
     * 获取完整的打包时 jar 包的名称.
     *
     * @return jar 包名称
     */
    public String getFullJarName() {
        return this.name + JAR;
    }

    /**
     * 获取打包的完整文件路径名称，但不含文件扩展名.
     *
     * @return 包名称
     */
    public String getPackName() {
        return this.homeDir.getAbsolutePath() + File.separator + this.name;
    }

    /**
     * 获取打包的完整文件路径名称，但不含文件扩展名.
     * <p>如：`/home/xxx/target/jpack/docker/test-1.2.5-docker.tar.gz`(实际结果没有 .tar.gz 的扩展名)</p>
     *
     * @return 包名称
     */
    public String getDockerPackName() {
        return this.homeDir.getAbsolutePath() + File.separator
                + this.docker.getImageTarName() + "-" + PlatformEnum.DOCKER.getCode();
    }

    /**
     * 重写的 toString 方法.
     *
     * @return String
     */
    @Override
    public String toString() {
        return "PackInfo = {"
                + "targetDir: '" + this.targetDir + '\''
                + ", homeDir: '" + this.homeDir + '\''
                + ", artifactId: '" + this.artifactId + '\''
                + ", name: '" + this.name + '\''
                + ", description: '" + this.description + '\''
                + ", vmOptions: '" + this.vmOptions + '\''
                + ", programArgs: '" + this.programArgs + '\''
                + ", skipError: '" + this.skipError + '\''
                + '}';
    }

    /* 以下是 getter 和 setter 方法. */

    public File getTargetDir() {
        return targetDir;
    }

    public PackInfo setTargetDir(File targetDir) {
        this.targetDir = targetDir;
        return this;
    }

    public File getHomeDir() {
        return homeDir;
    }

    public PackInfo setHomeDir(File homeDir) {
        this.homeDir = homeDir;
        return this;
    }

    public String getArtifactId() {
        return artifactId;
    }

    public PackInfo setArtifactId(String artifactId) {
        this.artifactId = artifactId;
        return this;
    }

    public String getVersion() {
        return version;
    }

    public PackInfo setVersion(String version) {
        this.version = version;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public PackInfo setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return this.description;
    }

    public PackInfo setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getVmOptions() {
        return this.vmOptions;
    }

    public PackInfo setVmOptions(String vmOptions) {
        this.vmOptions = vmOptions;
        return this;
    }

    public String getProgramArgs() {
        return this.programArgs;
    }

    public PackInfo setProgramArgs(String programArgs) {
        this.programArgs = programArgs;
        return this;
    }

    public String[] getConfigFiles() {
        return configFiles;
    }

    public PackInfo setConfigFiles(String[] configFiles) {
        this.configFiles = configFiles;
        return this;
    }

    public SkipErrorEnum getSkipError() {
        return skipError;
    }

    public PackInfo setSkipError(SkipErrorEnum skipError) {
        this.skipError = skipError;
        return this;
    }

    public Windows getWindows() {
        return windows;
    }

    public PackInfo setWindows(Windows windows) {
        this.windows = windows;
        return this;
    }

    public Linux getLinux() {
        return linux;
    }

    public PackInfo setLinux(Linux linux) {
        this.linux = linux;
        return this;
    }

    public Docker getDocker() {
        return docker;
    }

    public PackInfo setDocker(Docker docker) {
        this.docker = docker;
        return this;
    }

    public String[] getExcludeFiles() {
        return excludeFiles;
    }

    public PackInfo setExcludeFiles(String[] excludeFiles) {
        this.excludeFiles = excludeFiles;
        return this;
    }

    public CopyResource[] getCopyResources() {
        return copyResources;
    }

    public PackInfo setCopyResources(CopyResource[] copyResources) {
        this.copyResources = copyResources;
        return this;
    }

}
