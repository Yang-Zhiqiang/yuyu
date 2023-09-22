package yuyu.common.sinkeiyaku.moschk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.number.BizCurrency;

import org.slf4j.Logger;

import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_SyoriCTL;

/**
 * 新契約 申込内容チェック 普通死亡Ｓ設定
 */
public class SetHutuuSibouS {

    @Inject
    private static Logger logger;

    @Inject
    private BizDomManager bizDomManager;

    public SetHutuuSibouS() {
        super();
    }

    public BizCurrency exec(MosnaiCheckParam pMp) {

        if (logger.isDebugEnabled()) {
            logger.debug("▼ 普通死亡Ｓ設定 開始");
        }

        BM_SyouhnZokusei syouhnZokusei = null;
        List<HT_MosSyouhn> syuMosSyouhnLst = null;
        List<HT_MosSyouhn> tkMosSyouhnLst = null;
        HT_SyoriCTL syoriCTL = pMp.getDataSyoriControl();
        String mosNo = syoriCTL.getMosno();


        syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        if (syuMosSyouhnLst.size() != 1) {
            throw new CommonBizAppException("主契約申込商品件数異常 申込番号：" + mosNo);
        }
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnLst.get(0);

        tkMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.TK);

        BizCurrency futuuSibouS = BizCurrency.valueOf(0, syuMosSyouhnParam.getSeitoukihons().getType());
        BizCurrency syuKeiYakuSibouS = BizCurrency.valueOf(0, syuMosSyouhnParam.getSeitoukihons().getType());
        BizCurrency tokuYakuSibouS = BizCurrency.valueOf(0, syuMosSyouhnParam.getSeitoukihons().getType());


        HT_MosSyouhn mosSyouhn = syuMosSyouhnParam;

        String syouhncd = mosSyouhn.getSyouhncd();
        Integer syouhnsdno = mosSyouhn.getSyouhnsdno();

        syouhnZokusei = bizDomManager.getSyouhnZokusei(syouhncd, syouhnsdno);

        if (C_UmuKbn.ARI.eq(syouhnZokusei.getHutuusbhsyumu())) {
            syuKeiYakuSibouS = syuKeiYakuSibouS.add(syuMosSyouhnParam.getSeitoukihons());
        }

        HT_MosSyouhn tkMosSyouhn;

        if (tkMosSyouhnLst != null && tkMosSyouhnLst.size() > 0) {
            for (HT_MosSyouhn tkMosSyouhnParam : tkMosSyouhnLst) {

                tkMosSyouhn = tkMosSyouhnParam;

                String tkSyouhnCd = tkMosSyouhn.getSyouhncd();
                Integer tkSyouhnsdNo = tkMosSyouhn.getSyouhnsdno();

                syouhnZokusei = bizDomManager.getSyouhnZokusei(tkSyouhnCd, tkSyouhnsdNo);

                if (C_UmuKbn.ARI.eq(syouhnZokusei.getHutuusbhsyumu())){

                    tokuYakuSibouS = tokuYakuSibouS.add(tkMosSyouhnParam.getSeitoukihons());
                }
            }
        }

        futuuSibouS = syuKeiYakuSibouS.add(tokuYakuSibouS);
        if (logger.isDebugEnabled()) {
            logger.debug("|| 普通死亡Ｓ："+ futuuSibouS.toString());
            logger.debug("▲ 普通死亡Ｓ設定 終了");
        }

        return futuuSibouS;
    }
}
