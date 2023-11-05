package yuyu.common.sinkeiyaku.skcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import yuyu.def.classification.C_KijiKbn;

/**
 * 差異データ登録RegisterSaiDataKokutisyoインタフェースの実装クラス
 */
public class SaiDataTourokuRegisterSaiDataKokutisyoUiBeanParamImpl extends AbstractUiBean
implements SaiDataTourokuRegisterSaiDataKokutisyoUiBeanParam {

    private static final long serialVersionUID = 1L;
    private String mosno;

    private BizDate kktymd;

    private Integer sintyou;

    private Integer taijyuu;

    private C_KijiKbn kijikbn;

    @Override
    public String getMosno() {
        return mosno;
    }

    @Override
    public BizDate getKktymd() {
        return kktymd;
    }

    @Override
    public Integer getSintyou() {
        return sintyou;
    }

    @Override
    public Integer getTaijyuu() {
        return taijyuu;
    }

    @Override
    public C_KijiKbn getKijikbn() {
        return kijikbn;
    }

    public void setMosno(String mosno) {
        this.mosno = mosno;
    }

    public void setKktymd(BizDate kktymd) {
        this.kktymd = kktymd;
    }

    public void setSintyou(Integer sintyou) {
        this.sintyou = sintyou;
    }

    public void setTaijyuu(Integer taijyuu) {
        this.taijyuu = taijyuu;
    }

    public void setKijikbn(C_KijiKbn kijikbn) {
        this.kijikbn = kijikbn;
    }
}