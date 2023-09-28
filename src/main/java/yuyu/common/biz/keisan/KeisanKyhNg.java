package yuyu.common.biz.keisan;

import javax.inject.Inject;

import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_KataKbn;

/**
 * 業務共通 計算 給付日額計算クラス
 */
public class KeisanKyhNg {

    @Inject
    private BizDomManager bizDomManager;

    public KeisanKyhNg() {
        super();
    }

    public BizCurrency exec(String pSyouhncd, int pSyouhnsdno, C_KataKbn pKatakbn, BizCurrency pKihons) {

//        if (BizUtil.isBlank(pSyouhncd)) {
//            throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBA0023, "商品コード"));
//        }
//
//        BM_KyhNitigakuBairitu kyhNitigakuBairitu = bizDomManager.getSyouhnZokusei(pSyouhncd, pSyouhnsdno).
//                getKyhNitigakuBairituByKatakbn(pKatakbn);
//
//        if (kyhNitigakuBairitu == null) {
//            throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBA0024, "給付日額倍率マスタ"));
//        }
//
//        BizNumber kyhngbairitu = kyhNitigakuBairitu.getKyhngbairitu();
//
//        return pKihons.multiply(kyhngbairitu).round(0, RoundingMode.UNNECESSARY);
        return null;
    }
}