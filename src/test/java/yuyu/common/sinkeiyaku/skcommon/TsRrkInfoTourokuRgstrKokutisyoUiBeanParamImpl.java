package yuyu.common.sinkeiyaku.skcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import yuyu.def.classification.C_KijiKbn;

/**
 * 訂正履歴情報登録RgstrKokutisyoインタフェースの実装クラス
 */
public class TsRrkInfoTourokuRgstrKokutisyoUiBeanParamImpl extends AbstractUiBean
implements TsRrkInfoTourokuRgstrKokutisyoUiBeanParam {

    private static final long serialVersionUID = 1L;
    private String mosno;
    private BizDate kktymd;
    private Integer sintyou;
    private Integer taijyuu;
    private C_KijiKbn kijikbn;
    private String hbcmnt;

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

    @Override
    public String getHbcmnt() {
        return hbcmnt;
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

    public void setHbcmnt(String hbcmnt) {
        this.hbcmnt = hbcmnt;
    }
}