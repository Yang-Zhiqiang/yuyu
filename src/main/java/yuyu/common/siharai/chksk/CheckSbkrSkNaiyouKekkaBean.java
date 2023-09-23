package yuyu.common.siharai.chksk;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.bizinfr.exception.ErrorMessageCollector;

/**
 * 保険金給付金支払 請求内容チェック （死亡仮受付）請求内容チェック結果Beanクラス
 */
public class CheckSbkrSkNaiyouKekkaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<String> sbkrSeikyuuNaiyouChkKekkaAlert;

    private ErrorMessageCollector sbkrSeikyuuNaiyouChkKekkaError;

    private ChkKekkaBean sbkrSateiKoumokuChkKekka;

    public CheckSbkrSkNaiyouKekkaBean() {
        sbkrSeikyuuNaiyouChkKekkaAlert = new ArrayList<>();
        sbkrSeikyuuNaiyouChkKekkaError = new ErrorMessageCollector();
        sbkrSateiKoumokuChkKekka = null;
    }

    public List<String> getSbkrSeikyuuNaiyouChkKekkaAlert() {
        return sbkrSeikyuuNaiyouChkKekkaAlert;
    }

    public void setSbkrSeikyuuNaiyouChkKekkaAlert(List<String> pSbkrSeikyuuNaiyouChkKekkaAlert) {
        sbkrSeikyuuNaiyouChkKekkaAlert = pSbkrSeikyuuNaiyouChkKekkaAlert;
    }

    public ErrorMessageCollector getSbkrSeikyuuNaiyouChkKekkaError() {
        return sbkrSeikyuuNaiyouChkKekkaError;
    }

    public void setSbkrSeikyuuNaiyouChkKekkaError(ErrorMessageCollector pSbkrSeikyuuNaiyouChkKekkaError) {
        sbkrSeikyuuNaiyouChkKekkaError = pSbkrSeikyuuNaiyouChkKekkaError;
    }

    public ChkKekkaBean getSbkrSateiKoumokuChkKekka() {
        return sbkrSateiKoumokuChkKekka;
    }

    public void setSbkrSateiKoumokuChkKekka(ChkKekkaBean pSbkrSateiKoumokuChkKekka) {
        sbkrSateiKoumokuChkKekka = pSbkrSateiKoumokuChkKekka;
    }
}
