package yuyu.common.siharai.chksk;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.bizinfr.exception.ErrorMessageCollector;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_SKNaiyouChkkekkaKbn;
import yuyu.def.classification.C_YouhiKbn;

/**
 * 保険金給付金支払 請求内容チェック （高度障害）請求内容チェック結果Beanクラス
 */
public class CheckKdSkNaiyouKekkaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_SKNaiyouChkkekkaKbn skNaiyouChkkekkaKbn;

    private C_YouhiKbn sateiKaisouYouhiKbn;

    private C_KahiKbn keisanKahiKbn;

    private List<String> warningMessageList;

    private ErrorMessageCollector errorMessageCollector;

    private List<ChkKekkaBean> chkKekkaBeanList;

    private String sateiKoumokuMessage;

    public CheckKdSkNaiyouKekkaBean() {
        skNaiyouChkkekkaKbn = C_SKNaiyouChkkekkaKbn.SEIJYOU;
        sateiKaisouYouhiKbn = C_YouhiKbn.HUYOU;
        keisanKahiKbn = C_KahiKbn.KA;
        warningMessageList = new ArrayList<>();
        errorMessageCollector = new ErrorMessageCollector();
        chkKekkaBeanList = new ArrayList<>();
        sateiKoumokuMessage = null;
    }

    public C_SKNaiyouChkkekkaKbn getSkNaiyouChkkekkaKbn() {
        return skNaiyouChkkekkaKbn;
    }

    public void setSkNaiyouChkkekkaKbn(C_SKNaiyouChkkekkaKbn pSKNaiyouChkkekkaKbn) {
        this.skNaiyouChkkekkaKbn = pSKNaiyouChkkekkaKbn;
    }

    public C_YouhiKbn getSateiKaisouYouhiKbn() {
        return sateiKaisouYouhiKbn;
    }

    public void setSateiKaisouYouhiKbn(C_YouhiKbn pSateiKaisouYouhiKbn) {
        this.sateiKaisouYouhiKbn = pSateiKaisouYouhiKbn;
    }

    public C_KahiKbn getKeisanKahiKbn() {
        return keisanKahiKbn;
    }

    public void setKeisanKahiKbn(C_KahiKbn pKeisanKahiKbn) {
        this.keisanKahiKbn = pKeisanKahiKbn;
    }

    public List<String> getWarningMessageList() {
        return warningMessageList;
    }

    public void setWarningMessageList(List<String> pWarningMessageList) {
        this.warningMessageList = pWarningMessageList;
    }

    public ErrorMessageCollector getErrorMessageCollector() {
        return errorMessageCollector;
    }

    public void setErrorMessageCollector(ErrorMessageCollector pErrorMessageCollector) {
        this.errorMessageCollector = pErrorMessageCollector;
    }

    public List<ChkKekkaBean> getChkKekkaBeanList() {
        return chkKekkaBeanList;
    }

    public void setChkKekkaBeanList(List<ChkKekkaBean> pChkKekkaBeanList) {
        this.chkKekkaBeanList = pChkKekkaBeanList;
    }

    public String getSateiKoumokuMessage() {
        return sateiKoumokuMessage;
    }

    public void setSateiKoumokuMessage(String pSateiKoumokuMessage) {
        this.sateiKoumokuMessage = pSateiKoumokuMessage;
    }
}
