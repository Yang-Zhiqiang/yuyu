package yuyu.common.biz.bzcommon;

import java.io.Serializable;

import yuyu.def.db.entity.BM_SyouhnZokusei;
import jp.co.slcs.swak.date.BizDate;

/**
 * 業務共通 共通 保険期間判定Beanクラス
 */
public class HanteiHokenKikanBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BizDate kykYmd;

    private BizDate calcKijyunYmd ;

    private BM_SyouhnZokusei syouhnZokusei ;

    private int dai1hknkkn;

    public HanteiHokenKikanBean(){

        kykYmd = null;
        calcKijyunYmd = null;
        syouhnZokusei = null;
        dai1hknkkn = 0;
    }

    public BizDate getKykYmd() {
        return kykYmd;
    }

    public void setKykYmd(BizDate pKykYmd) {
        kykYmd = pKykYmd;
    }

    public BizDate getCalcKijyunYmd() {
        return calcKijyunYmd;
    }

    public void setCalcKijyunYmd(BizDate pCalcKijyunYmd) {
        calcKijyunYmd = pCalcKijyunYmd;
    }
    public BM_SyouhnZokusei getSyouhnZokusei() {
        return syouhnZokusei;
    }

    public void setSyouhnZokusei(BM_SyouhnZokusei pSyouhnZokusei) {
        syouhnZokusei = pSyouhnZokusei;
    }

    public int getDai1hknkkn() {
        return dai1hknkkn;
    }

    public void setDai1hknkkn(int pDai1hknkkn) {
        dai1hknkkn = pDai1hknkkn;
    }
}
