package yuyu.infr.report.swakreport.config;

import jp.co.slcs.swak.SWAK;

/**
 * JasperReport用定義情報格納部品
 */
public class JasperConfig {

    @Deprecated
    public JasperConfig() { }

    private String compileClassPath;

    private String compileJarPath;

    private VirtualizerConfig virtualizerConfig;

    public String getCompileClassPath() {
        return compileClassPath;
    }

    @Deprecated
    public void setCompileClassPath(String pCompileClassPath) {
        String absolutePath = getAbsolutePath(pCompileClassPath);
        compileClassPath = absolutePath;
    }

    public String getCompileJarPath() {
        return compileJarPath;
    }

    @Deprecated
    public void setCompileJarPath(String pCompileJarPath) {
        String absolutePath = getAbsolutePath(pCompileJarPath);
        compileJarPath = absolutePath;
    }

    public VirtualizerConfig getVirtualizerConfig() {
        return virtualizerConfig;
    }

    @Deprecated
    public void setVirtualizerConfig(VirtualizerConfig pVirtualizerConfig) {
        virtualizerConfig = pVirtualizerConfig;
    }

    private static String getAbsolutePath(String pFilePath) {
        return SWAK.getApplicationRootPath() + pFilePath;
    }
}
