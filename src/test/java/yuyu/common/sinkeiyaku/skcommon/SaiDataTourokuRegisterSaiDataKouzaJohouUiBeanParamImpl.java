package yuyu.common.sinkeiyaku.skcommon;

import jp.co.slcs.swak.web.ui.AbstractUiBean;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_YokinKbn;

/**
 * 差異データ登録RegisterSaiDataKouzaJohouインタフェースの実装クラス
 */
public class SaiDataTourokuRegisterSaiDataKouzaJohouUiBeanParamImpl extends AbstractUiBean
implements SaiDataTourokuRegisterSaiDataKouzaJohouUiBeanParam {

    private static final long serialVersionUID = 1L;
    private String mosno;

    private String bankcd;

    private String sitencd;

    private C_YokinKbn yokinkbn;

    private String kouzano;

    private C_KzkykdouKbn kzkykdoukbn;

    private String kzmeiginmkn;

    @Override
    public String getMosno() {
        return mosno;
    }

    @Override
    public String getBankcd() {
        return bankcd;
    }

    @Override
    public String getSitencd() {
        return sitencd;
    }

    @Override
    public C_YokinKbn getYokinkbn() {
        return yokinkbn;
    }

    @Override
    public String getKouzano() {
        return kouzano;
    }

    @Override
    public C_KzkykdouKbn getKzkykdoukbn() {
        return kzkykdoukbn;
    }

    @Override
    public String getKzmeiginmkn() {
        return kzmeiginmkn;
    }

    public void setMosno(String mosno) {
        this.mosno = mosno;
    }

    public void setBankcd(String bankcd) {
        this.bankcd = bankcd;
    }

    public void setSitencd(String sitencd) {
        this.sitencd = sitencd;
    }

    public void setYokinkbn(C_YokinKbn yokinkbn) {
        this.yokinkbn = yokinkbn;
    }

    public void setKouzano(String kouzano) {
        this.kouzano = kouzano;
    }

    public void setKzkykdoukbn(C_KzkykdouKbn kzkykdoukbn) {
        this.kzkykdoukbn = kzkykdoukbn;
    }

    public void setKzmeiginmkn(String kzmeiginmkn) {
        this.kzmeiginmkn = kzmeiginmkn;
    }
}