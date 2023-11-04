package yuyu.common.sinkeiyaku.skcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import yuyu.def.classification.C_SinsaKbn;
import yuyu.def.classification.C_SyosaiKbn;

/**
 * 訂正履歴情報登録RgstrHoujyouインタフェースの実装クラス
 */
public class TsRrkInfoTourokuRgstrHoujyouUiBeanParamImpl extends AbstractUiBean
implements TsRrkInfoTourokuRgstrHoujyouUiBeanParam {

    private static final long serialVersionUID = 1L;
    private String mosno;
    private C_SyosaiKbn syosaikbn;
    private BizDate kktymd;
    private Integer sintyou;
    private Integer taijyuu;
    private C_SinsaKbn sinsakbn;
    private BizDate sinsaymd;
    private String hbcmnt;

    @Override
    public String getMosno() {
        return mosno;
    }

    @Override
    public C_SyosaiKbn getSyosaikbn() {
        return syosaikbn;
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
    public C_SinsaKbn getSinsakbn() {
        return sinsakbn;
    }

    @Override
    public BizDate getSinsaymd() {
        return sinsaymd;
    }

    @Override
    public String getHbcmnt() {
        return hbcmnt;
    }

    public void setMosno(String mosno) {
        this.mosno = mosno;
    }

    public void setSyosaikbn(C_SyosaiKbn syosaikbn) {
        this.syosaikbn = syosaikbn;
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

    public void setSinsakbn(C_SinsaKbn sinsakbn) {
        this.sinsakbn = sinsakbn;
    }

    public void setSinsaymd(BizDate sinsaymd) {
        this.sinsaymd = sinsaymd;
    }

    public void setHbcmnt(String hbcmnt) {
        this.hbcmnt = hbcmnt;
    }
}