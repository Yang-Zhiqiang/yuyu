package yuyu.common.siharai.chksk;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.bizinfr.exception.ErrorMessageCollector;
/**
 * （診断書料支払）請求内容チェック結果Beanクラスです。
 */
public class CheckSdsSkNaiyouKekkaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<String> sdsrSeikyuuNaiyouChkKekkaAlert;

    private ErrorMessageCollector sdsrSeikyuuNaiyouChkKekkaError;

    private ChkKekkaBean sdsrSateiKoumokuChkKekka;

    public CheckSdsSkNaiyouKekkaBean() {
        sdsrSeikyuuNaiyouChkKekkaAlert = new ArrayList<>();
        sdsrSeikyuuNaiyouChkKekkaError = new ErrorMessageCollector();
        sdsrSateiKoumokuChkKekka = null;
    }

    public List<String> getSdsrSeikyuuNaiyouChkKekkaAlert() {
        return sdsrSeikyuuNaiyouChkKekkaAlert;
    }

    public void setSdsrSeikyuuNaiyouChkKekkaAlert(List<String> pSdsrSeikyuuNaiyouChkKekkaAlert) {
        sdsrSeikyuuNaiyouChkKekkaAlert = pSdsrSeikyuuNaiyouChkKekkaAlert;
    }

    public ErrorMessageCollector getSdsrSeikyuuNaiyouChkKekkaError() {
        return sdsrSeikyuuNaiyouChkKekkaError;
    }

    public void setSdsrSeikyuuNaiyouChkKekkaError(ErrorMessageCollector pSdsrSeikyuuNaiyouChkKekkaError) {
        sdsrSeikyuuNaiyouChkKekkaError = pSdsrSeikyuuNaiyouChkKekkaError;
    }

    public ChkKekkaBean getSdsrSateiKoumokuChkKekka() {
        return sdsrSateiKoumokuChkKekka;
    }

    public void setSdsrSateiKoumokuChkKekka(ChkKekkaBean pSdsrSateiKoumokuChkKekka) {
        sdsrSateiKoumokuChkKekka = pSdsrSateiKoumokuChkKekka;
    }

}


