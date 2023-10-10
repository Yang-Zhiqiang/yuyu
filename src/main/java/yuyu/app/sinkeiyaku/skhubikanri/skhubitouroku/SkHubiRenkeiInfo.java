package yuyu.app.sinkeiyaku.skhubikanri.skhubitouroku;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import yuyu.def.classification.C_HbtyhyoutKbn;

/**
 * 不備登録機能間遷移用Beanクラスです。<br />
 */
public class SkHubiRenkeiInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<HubiList2DataSourceBean> hubiList2 = new ArrayList<>();

    private List<HubiList1DataSourceBean> hubiList1 = new ArrayList<>();

    private String utdskknnm1kj;

    private String utdskknnm2kj;

    private String tuutisakitantounmkj;

    private C_HbtyhyoutKbn hbtyhyoutkbn;

    private boolean hubiTourokuHenkouFlg;

    private String  hubiTourokuKouteikanriId;

    public SkHubiRenkeiInfo() {
    }

    public List<HubiList2DataSourceBean> getHubiList2() {
        return hubiList2;
    }

    public void setHubiList2(List<HubiList2DataSourceBean> pHubiList2) {
        this.hubiList2 = pHubiList2;
    }

    public List<HubiList1DataSourceBean> getHubiList1() {
        return hubiList1;
    }

    public void setHubiList1(List<HubiList1DataSourceBean> pHubiList1) {
        this.hubiList1 = pHubiList1;
    }

    public String getUtdskknnm1kj() {
        return utdskknnm1kj;
    }

    public void setUtdskknnm1kj(String pUtdskknnm1kj) {
        utdskknnm1kj = pUtdskknnm1kj;
    }

    public String getUtdskknnm2kj() {
        return utdskknnm2kj;
    }


    public void setUtdskknnm2kj(String pUtdskknnm2kj) {
        utdskknnm2kj = pUtdskknnm2kj;
    }

    public String getTuutisakitantounmkj() {
        return tuutisakitantounmkj;
    }

    public void setTuutisakitantounmkj(String pTuutisakitantounmkj) {
        tuutisakitantounmkj = pTuutisakitantounmkj;
    }

    public C_HbtyhyoutKbn getHbtyhyoutkbn() {
        return hbtyhyoutkbn;
    }

    public void setHbtyhyoutkbn(C_HbtyhyoutKbn pHbtyhyoutkbn) {
        hbtyhyoutkbn = pHbtyhyoutkbn;
    }

    public boolean isHubiTourokuHenkouFlg() {
        return hubiTourokuHenkouFlg;
    }

    public void setHubiTourokuHenkouFlg(boolean pHubiTourokuHenkouFlg) {
        this.hubiTourokuHenkouFlg = pHubiTourokuHenkouFlg;
    }

    public String getHubiTourokuKouteikanriId() {
        return hubiTourokuKouteikanriId;
    }

    public void setHubiTourokuKouteikanriId(String hubiTourokuKouteikanriId) {
        this.hubiTourokuKouteikanriId = hubiTourokuKouteikanriId;
    }
}
