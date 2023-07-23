package yuyu.infr.report.swakreport.config;

import jp.co.slcs.swak.SWAK;

/**
 * Virtualizer情報格納部品
 */
public class VirtualizerConfig {

    @Deprecated
    public VirtualizerConfig() { }

    private int maxSize;

    private String directory;

    private int blockSize;

    private int growCount;

    public int getMaxSize() {
        return maxSize;
    }

    @Deprecated
    public void setMaxSize(int pMaxSize) {
        maxSize = pMaxSize;
    }

    public String getDirectory() {
        return directory;
    }

    @Deprecated
    public void setDirectory(String pDirectory) {
        String absolutePath = getAbsolutePath(pDirectory);
        directory = absolutePath;
    }

    public int getBlockSize() {
        return blockSize;
    }

    @Deprecated
    public void setBlockSize(int pBlockSize) {
        blockSize = pBlockSize;
    }

    public int getGrowCount() {
        return growCount;
    }

    @Deprecated
    public void setGrowCount(int pGrowCount) {
        growCount = pGrowCount;
    }

    private static String getAbsolutePath(String pFilePath) {
        return SWAK.getApplicationRootPath() + pFilePath;
    }
}
