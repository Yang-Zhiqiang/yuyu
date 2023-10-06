package yuyu.batch.biz.bzinterf.bzonlinegkfbsoukinfilesks;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import yuyu.common.biz.bzcommon.BzBatchParam;

/**
 * 業務共通 インターフェイス オンライン オンライン外貨ＦＢ送金ファイル作成パラメータ
 */
@BatchScoped
public class BzOnlineGkFBSoukinFileSksBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    private String fileNm2eiatoTyakkin = "OnlineGkFBSoukinFile2eigo";

    public String getFileNm2eiatoTyakkin() {
        return fileNm2eiatoTyakkin;
    }

    public void setFileNm2eiatoTyakkin(String pFileNm2eiatoTyakkin) {
        fileNm2eiatoTyakkin = pFileNm2eiatoTyakkin;
    }
}
