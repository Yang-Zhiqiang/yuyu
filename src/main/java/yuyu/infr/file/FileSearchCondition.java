package yuyu.infr.file;

import yuyu.def.classification.C_FileSyuruiCdKbn;

/**
 * ファイル保存基盤で使用するファイル検索条件オブジェクト
 */
public class FileSearchCondition {

    private String uniqueId;

    private String  fileName;

    private C_FileSyuruiCdKbn  fileSyuruiCd;

    private String haitaKey;

    private String tourokuTimeFrom;

    private String tourokuTimeTo;

    private String sakuseiKinouId;

    private String userId;

    private boolean forceCompress;

    public FileSearchCondition() {
        clearUniqueId();
        clearFileName();
        clearFileSyuruiCd();
        clearHaitaKey();
        clearTourokuTimeFrom();
        clearTourokuTimeTo();
        clearSakuseiKinouId();
        clearUserId();
        clearForceCompress();
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String pUniqueId) {
        uniqueId = pUniqueId;
    }

    public void clearUniqueId() {
        uniqueId = null;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String pFileName) {
        fileName = pFileName;
    }

    public void clearFileName() {
        fileName = null;
    }

    public C_FileSyuruiCdKbn getFileSyuruiCd() {
        return fileSyuruiCd;
    }

    public void setFileSyuruiCd(C_FileSyuruiCdKbn pFileSyuruiCd) {
        fileSyuruiCd = pFileSyuruiCd;
    }

    public void clearFileSyuruiCd() {
    	fileSyuruiCd = null;
    }

    public String getHaitaKey() {
        return haitaKey;
    }

    public void setHaitaKey(String pHaitaKey) {
        haitaKey = pHaitaKey;
    }

    public void clearHaitaKey() {
        haitaKey = null;
    }

    public String getTourokuTimeFrom() {
        return tourokuTimeFrom;
    }

    public void setTourokuTimeFrom(String pTourokuTimeFrom) {
        tourokuTimeFrom = pTourokuTimeFrom;
    }

    public void clearTourokuTimeFrom() {
        tourokuTimeFrom = null;
    }

    public String getTourokuTimeTo() {
        return tourokuTimeTo;
    }

    public void setTourokuTimeTo(String pTourokuTimeTo) {
        tourokuTimeTo = pTourokuTimeTo;
    }

    public void clearTourokuTimeTo() {
        tourokuTimeTo = null;
    }

    public String getSakuseiKinouId() {
        return sakuseiKinouId;
    }

    public void setSakuseiKinouId(String pSakuseiKinouId) {
        sakuseiKinouId = pSakuseiKinouId;
    }

    public void clearSakuseiKinouId() {
        sakuseiKinouId = null;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String pUserId) {
        userId = pUserId;
    }

    public void clearUserId() {
        userId = null;
    }

    public boolean isForceCompress() {
        return forceCompress;
    }

    public void setForceCompress(boolean forceCompress) {
        this.forceCompress = forceCompress;
    }

    public void clearForceCompress() {
        forceCompress = false;
    }
}
