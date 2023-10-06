package yuyu.batch.biz.bzinterf.bzbatchfbsoukinfilesks;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import yuyu.common.biz.bzcommon.BzBatchParam;

/**
 * 業務共通 インターフェイス オンライン バッチＦＢ送金ファイル作成パラメータ
 */
@BatchScoped
public class BzBatchFBSoukinFileSksBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    private String fileNm3eiatoTyakkin = "FBSoukinFile3eigo";

    public String getFileNm3eiatoTyakkin() {
        return fileNm3eiatoTyakkin;
    }

    public void setFileNm3eiatoTyakkin(String pFileNm3eiatoTyakkin) {
        fileNm3eiatoTyakkin = pFileNm3eiatoTyakkin;
    }

}
