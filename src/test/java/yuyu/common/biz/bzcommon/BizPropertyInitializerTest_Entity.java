package yuyu.common.biz.bzcommon;

import javax.persistence.Entity;

import jp.co.slcs.swak.number.BizRate;
import yuyu.def.db.mapping.GenAM_Role;

/**
 * BizRate型のフィールドを持つEntity
 */
@Entity
public class BizPropertyInitializerTest_Entity extends GenAM_Role{
    private static final long serialVersionUID = 1L;

    private BizRate rate;

    public BizRate getRate() {
        return rate;
    }

    public void setRate(BizRate rate) {
        this.rate = rate;
    }
}
