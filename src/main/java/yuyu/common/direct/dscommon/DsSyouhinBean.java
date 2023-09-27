package yuyu.common.direct.dscommon;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_DsSyouhnbunruiKbn;

/**
 * ダイレクトサービス ダイレクトサービス共通 ＤＳ商品情報Bean<br/>
 */
public class DsSyouhinBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String syoNo;

    private C_DsSyouhnbunruiKbn dsSyouhnbunruiKbn;

    public String getSyoNo() {
        return syoNo;
    }

    public void setSyoNo(String pSyoNo) {
        this.syoNo = pSyoNo;
    }

    public C_DsSyouhnbunruiKbn getDsSyouhnbunruiKbn() {
        return dsSyouhnbunruiKbn;
    }

    public void setDsSyouhnbunruiKbn(C_DsSyouhnbunruiKbn pDsSyouhnbunruiKbn) {
        this.dsSyouhnbunruiKbn = pDsSyouhnbunruiKbn;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
