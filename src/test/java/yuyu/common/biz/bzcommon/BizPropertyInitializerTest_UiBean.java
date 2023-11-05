package yuyu.common.biz.bzcommon;

import jp.co.slcs.swak.number.BizRate;
import yuyu.app.base.system.roletouroku.GenRoleTourokuUiBean;

/**
 * BizRate型のフィールドを持つUiBean
 */
public class BizPropertyInitializerTest_UiBean extends GenRoleTourokuUiBean {

    private static final long serialVersionUID = 1L;

    private BizRate rate;

    public BizRate getRate() {
        return rate;
    }

    public void setRate(BizRate rate) {
        this.rate = rate;
    }
}
