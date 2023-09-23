package yuyu.common.siharai.sicommon;

import java.io.Serializable;
import java.util.List;

import yuyu.def.db.entity.JT_SiDenpyoData;

/**
 * 保険金給付金支払 保険金給付金支払共通 保険金給付金仕訳共通処理結果Bean
 */
public class SiCommonSiwakeKekkaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<JT_SiDenpyoData> siDenpyoDataLst;

    private int fbSoukinEdaNo;

    public List<JT_SiDenpyoData> getSiDenpyoDataLst() {
        return siDenpyoDataLst;
    }

    public void setSiDenpyoDataLst(List<JT_SiDenpyoData> pSiDenpyoDataLst) {
        siDenpyoDataLst = pSiDenpyoDataLst;
    }

    public int getFbSoukinEdaNo() {
        return fbSoukinEdaNo;
    }

    public void setFbSoukinEdaNo(int pFbSoukinEdaNo) {
        fbSoukinEdaNo = pFbSoukinEdaNo;
    }
}
