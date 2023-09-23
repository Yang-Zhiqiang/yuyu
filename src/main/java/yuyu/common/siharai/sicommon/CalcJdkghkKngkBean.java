package yuyu.common.siharai.sicommon;

import java.io.Serializable;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

/**
 * 保険金給付金支払 保険金給付金支払共通 重度介護前払保険金額計算Beanクラス
 */
public class CalcJdkghkKngkBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BizCurrency jdkghkKnGkCompareBefore;

    private BizCurrency jdkghkKnGk;

    private BizNumber waribikiKikan;

    public CalcJdkghkKngkBean() {

        jdkghkKnGkCompareBefore = BizCurrency.valueOf(0);
        jdkghkKnGk = BizCurrency.valueOf(0);
        waribikiKikan = BizNumber.valueOf(0);
    }

    public BizCurrency getJdkghkKnGkCompareBefore() {
        return jdkghkKnGkCompareBefore;
    }

    public void setJdkghkKnGkCompareBefore(BizCurrency pJdkghkKnGkCompareBefore) {
        this.jdkghkKnGkCompareBefore = pJdkghkKnGkCompareBefore;
    }

    public BizCurrency getJdkghkKnGk() {
        return jdkghkKnGk;
    }

    public void setJdkghkKnGk(BizCurrency pJdkghkKnGk) {
        this.jdkghkKnGk = pJdkghkKnGk;
    }

    public BizNumber getWaribikiKikan() {
        return waribikiKikan;
    }

    public void setWaribikiKikan(BizNumber pWaribikiKikan) {
        this.waribikiKikan = pWaribikiKikan;
    }
}
