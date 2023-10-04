package yuyu.batch.siharai.sikessan.simakejikoudenmeisailist;

import java.io.Serializable;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * 保険金給付金支払 決算 時効伝票明細リスト集計Beanクラス
 */
public class JikouDenMeisaiListSyukeiBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private BizCurrency goukeikasitukekgk;

    @Getter @Setter
    private BizCurrency goukeitatekaekgk;

    @Getter @Setter
    private BizCurrency goukeikrkgk;

    @Getter @Setter
    private BizCurrency goukeikaribaraikgk;

    @Getter @Setter
    private BizCurrency goukeizatusyunyukgk;

    @Getter @Setter
    private BizCurrency goukeihkgk;

    public JikouDenMeisaiListSyukeiBean() {
        goukeikasitukekgk = BizCurrency.valueOf(0);
        goukeitatekaekgk = BizCurrency.valueOf(0);
        goukeikrkgk = BizCurrency.valueOf(0);
        goukeikaribaraikgk = BizCurrency.valueOf(0);
        goukeizatusyunyukgk = BizCurrency.valueOf(0);
        goukeihkgk = BizCurrency.valueOf(0);
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
