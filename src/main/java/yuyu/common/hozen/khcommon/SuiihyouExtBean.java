package yuyu.common.hozen.khcommon;

import java.io.Serializable;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import lombok.Getter;
import lombok.Setter;

/**
 * 契約保全 契約保全共通 推移表テーブル拡張Beanクラス
 */
public class SuiihyouExtBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BizNumber sjkkktusirrtUp = BizNumber.ZERO;

    private BizNumber sjkkktusirrtSame = BizNumber.ZERO;

    private BizNumber sjkkktusirrtDown = BizNumber.ZERO;

    private BizNumber sjkkktusirrtHendouUp = BizNumber.ZERO;

    private BizNumber sjkkktusirrtHendouDown = BizNumber.ZERO;

    private BizNumber sisuuUpRitu = BizNumber.ZERO;

    private BizCurrency mvaAriPTumitatekin = BizCurrency.valueOf(0);

    private BizCurrency mvaAriTmttkgkKykkjmaeUp = BizCurrency.valueOf(0);

    private BizCurrency mvaAriTmttkgkKykkjmaeSame = BizCurrency.valueOf(0);

    private BizCurrency mvaAriTmttkgkKykjmaeDown = BizCurrency.valueOf(0);

    private BizCurrency mvaAriWUp = BizCurrency.valueOf(0);

    private BizCurrency mvaAriWSame = BizCurrency.valueOf(0);

    private BizCurrency mvaAriWDown = BizCurrency.valueOf(0);

    private BizCurrency mvaNoneWSame = BizCurrency.valueOf(0);

    private BizCurrency mvaNonePTumitatekin = BizCurrency.valueOf(0);

    @Getter @Setter
    private BizNumber kaiyakuKjRitu = BizNumber.ZERO;

    @Getter @Setter
    private BizCurrency kaiyakuKjgk = BizCurrency.valueOf(0);

    @Getter @Setter
    private Integer sisuuUpCount1 = 0;

    @Getter @Setter
    private Integer sisuuDownCount1 = 0;

    public SuiihyouExtBean() {
        super();
    }

    public BizNumber getSjkkktusirrtUp() {
        return sjkkktusirrtUp;
    }

    public void setSjkkktusirrtUp(BizNumber pSjkkktusirrtUp) {
        sjkkktusirrtUp = pSjkkktusirrtUp;
    }
    public BizNumber getSjkkktusirrtSame() {
        return sjkkktusirrtSame;
    }

    public void setSjkkktusirrtSame(BizNumber pSjkkktusirrtSame) {
        sjkkktusirrtSame = pSjkkktusirrtSame;
    }
    public BizNumber getSjkkktusirrtDown() {
        return sjkkktusirrtDown;
    }

    public void setSjkkktusirrtDown(BizNumber pSjkkktusirrtDown) {
        sjkkktusirrtDown = pSjkkktusirrtDown;
    }
    public BizNumber getSjkkktusirrtHendouUp() {
        return sjkkktusirrtHendouUp;
    }

    public void setSjkkktusirrtHendouUp(BizNumber pSjkkktusirrtHendouUp) {
        sjkkktusirrtHendouUp = pSjkkktusirrtHendouUp;
    }
    public BizNumber getSjkkktusirrtHendouDown() {
        return sjkkktusirrtHendouDown;
    }

    public void setSjkkktusirrtHendouDown(BizNumber pSjkkktusirrtHendouDown) {
        sjkkktusirrtHendouDown = pSjkkktusirrtHendouDown;
    }
    public BizNumber getSisuuUpRitu() {
        return sisuuUpRitu;
    }

    public void setSisuuUpRitu(BizNumber pSisuuUpRitu) {
        sisuuUpRitu = pSisuuUpRitu;
    }
    public BizCurrency getMvaAriPTumitatekin() {
        return mvaAriPTumitatekin;
    }

    public void setMvaAriPTumitatekin(BizCurrency pMvaAriPTumitatekin) {
        mvaAriPTumitatekin = pMvaAriPTumitatekin;
    }
    public BizCurrency getMvaAriTmttkgkKykkjmaeUp() {
        return mvaAriTmttkgkKykkjmaeUp;
    }

    public void setMvaAriTmttkgkKykkjmaeUp(BizCurrency pMvaAriTmttkgkKykkjmaeUp) {
        mvaAriTmttkgkKykkjmaeUp = pMvaAriTmttkgkKykkjmaeUp;
    }
    public BizCurrency getMvaAriTmttkgkKykkjmaeSame() {
        return mvaAriTmttkgkKykkjmaeSame;
    }

    public void setMvaAriTmttkgkKykkjmaeSame(BizCurrency pMvaAriTmttkgkKykkjmaeSame) {
        mvaAriTmttkgkKykkjmaeSame = pMvaAriTmttkgkKykkjmaeSame;
    }
    public BizCurrency getMvaAriTmttkgkKykjmaeDown() {
        return mvaAriTmttkgkKykjmaeDown;
    }

    public void setMvaAriTmttkgkKykjmaeDown(BizCurrency pMvaAriTmttkgkKykjmaeDown) {
        mvaAriTmttkgkKykjmaeDown = pMvaAriTmttkgkKykjmaeDown;
    }
    public BizCurrency getMvaAriWUp() {
        return mvaAriWUp;
    }

    public void setMvaAriWUp(BizCurrency pMvaAriWUp) {
        mvaAriWUp = pMvaAriWUp;
    }
    public BizCurrency getMvaAriWSame() {
        return mvaAriWSame;
    }

    public void setMvaAriWSame(BizCurrency pMvaAriWSame) {
        mvaAriWSame = pMvaAriWSame;
    }
    public BizCurrency getMvaAriWDown() {
        return mvaAriWDown;
    }

    public void setMvaAriWDown(BizCurrency pMvaAriWDown) {
        mvaAriWDown = pMvaAriWDown;
    }
    public BizCurrency getMvaNoneWSame() {
        return mvaNoneWSame;
    }

    public void setMvaNoneWSame(BizCurrency pMvaNoneWSame) {
        mvaNoneWSame = pMvaNoneWSame;
    }
    public BizCurrency getMvaNonePTumitatekin() {
        return mvaNonePTumitatekin;
    }

    public void setMvaNonePTumitatekin(BizCurrency pMvaNonePTumitatekin) {
        mvaNonePTumitatekin = pMvaNonePTumitatekin;
    }
}
