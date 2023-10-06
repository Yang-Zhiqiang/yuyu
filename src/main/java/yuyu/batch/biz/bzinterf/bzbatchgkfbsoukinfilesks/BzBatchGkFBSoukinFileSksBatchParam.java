package yuyu.batch.biz.bzinterf.bzbatchgkfbsoukinfilesks;

import yuyu.common.biz.bzcommon.BzBatchParam;
import jp.co.slcs.swak.batch.annotation.BatchScoped;

/**
 * 業務共通 インターフェイス バッチ外貨ＦＢ送金ファイル作成パラメータ
 */
@BatchScoped
public class BzBatchGkFBSoukinFileSksBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    private String fileNm2eiatoTyakkin = "GkFBSoukinFile2eigo";

    private String fileNm3eiatoTyakkin = "GkFBSoukinFile3eigo";

    public String getFileNm2eiatoTyakkin() {
        return fileNm2eiatoTyakkin;
    }

    public void setFileNm2eiatoTyakkin(String pFileNm2eiatoTyakkin) {
        fileNm2eiatoTyakkin = pFileNm2eiatoTyakkin;
    }

    public String getFileNm3eiatoTyakkin() {
        return fileNm3eiatoTyakkin;
    }

    public void setFileNm3eiatoTyakkin(String pFileNm3eiatochakkin) {
        fileNm3eiatoTyakkin = pFileNm3eiatochakkin;
    }

}
