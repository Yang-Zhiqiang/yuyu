package yuyu.common.hozen.khcommon;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * 為替レートBeanクラスです。<br />
 */
public class KawaseRateBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private BizNumber kwsrateUsdjpy1mae;

    @Getter @Setter
    private BizDate kwsrateKijyunymd1mae;

    @Getter @Setter
    private BizNumber kwsrateAudjpy1mae;

    @Getter @Setter
    private BizNumber kwsrateUsdjpy2mae;

    @Getter @Setter
    private BizDate kwsrateKijyunymd2mae;

    @Getter @Setter
    private BizNumber kwsrateAudjpy2mae;

    @Getter @Setter
    private BizNumber kwsrateUsdjpy3mae;

    @Getter @Setter
    private BizDate kwsrateKijyunymd3mae;

    @Getter @Setter
    private BizNumber kwsrateAudjpy3mae;

    @Getter @Setter
    private BizNumber kwsrateUsdjpy4mae;

    @Getter @Setter
    private BizDate kwsrateKijyunymd4mae;

    @Getter @Setter
    private BizNumber kwsrateAudjpy4mae;

    @Getter @Setter
    private BizNumber kwsrateUsdjpy5mae;

    @Getter @Setter
    private BizDate kwsrateKijyunymd5mae;

    @Getter @Setter
    private BizNumber kwsrateAudjpy5mae;

    @Getter @Setter
    private BizNumber kwsrateUsdjpy6mae;

    @Getter @Setter
    private BizDate kwsrateKijyunymd6mae;

    @Getter @Setter
    private BizNumber kwsrateAudjpy6mae;

    @Getter @Setter
    private BizNumber kwsrateUsdjpy7mae;

    @Getter @Setter
    private BizDate kwsrateKijyunymd7mae;

    @Getter @Setter
    private BizNumber kwsrateAudjpy7mae;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
