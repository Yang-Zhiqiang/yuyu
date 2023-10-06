package yuyu.batch.biz.bzinterf.bzonlinefbsoukinfilesks;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import yuyu.common.biz.bzcommon.BzBatchParam;

/**
 * 業務共通 インターフェイス オンライン オンラインＦＢ送金ファイル作成パラメータ
 */
@BatchScoped
public class BzOnlineFBSoukinFileSksBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    private String fileNmYokueiTyakkin = "FBSoukinFileYoku";

    private String fileNm2eiatoTyakkin = "FBSoukinFile2eigo";

    public String getFileNmYokueiTyakkin() {
        return fileNmYokueiTyakkin;
    }

    public void setFileNmYokueiTyakkin(String pFileNmYokueiTyakkin) {
        fileNmYokueiTyakkin = pFileNmYokueiTyakkin;
    }

    public String getFileNm2eiatoTyakkin() {
        return fileNm2eiatoTyakkin;
    }

    public void setFileNm2eiatoTyakkin(String pFileNm2eiatoTyakkin) {
        fileNm2eiatoTyakkin = pFileNm2eiatoTyakkin;
    }


}
