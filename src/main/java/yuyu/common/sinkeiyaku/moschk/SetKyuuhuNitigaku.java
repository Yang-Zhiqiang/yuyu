package yuyu.common.sinkeiyaku.moschk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_MosSyouhn;

/**
 * 新契約 申込内容チェック 給付日額設定
 */
public class SetKyuuhuNitigaku {

    private BizCurrency sipNyuTsnNtgk1;

    private BizCurrency sipNyuTsnNtgk2;

    private BizCurrency sipNyuTsnNtgk3;

    @Inject
    private BizDomManager bizDomManager;

    public SetKyuuhuNitigaku() {
        super();
    }

    public BizCurrency getSipnyutsnntgk1() {
        return sipNyuTsnNtgk1;
    }

    public BizCurrency getSipnyutsnntgk2() {
        return sipNyuTsnNtgk2;
    }

    public BizCurrency getSipnyutsnntgk3() {
        return sipNyuTsnNtgk3;
    }

    public void exec(List<HT_MosSyouhn> pSyuMosSyouhnParamLst, List<HT_MosSyouhn> pTkMosSyouhnParamLst) {


        HT_MosSyouhn syuSyouhnParam = pSyuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = null;

        HT_MosSyouhn mosSyouhn = syuSyouhnParam;
        String syuSyouhnCd = mosSyouhn.getSyouhncd();
        Integer syuSyouhnsdNo = mosSyouhn.getSyouhnsdno();

        syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);

        sipNyuTsnNtgk1 = BizCurrency.valueOf(0, syuSyouhnParam.getKihons().getType());
        sipNyuTsnNtgk2 = BizCurrency.valueOf(0, syuSyouhnParam.getKihons().getType());
        sipNyuTsnNtgk3 = BizCurrency.valueOf(0, syuSyouhnParam.getKihons().getType());

        //        if (C_UmuKbn.ARI.eq(syuSyouhnZokusei.getSipnyutsn1umu())) {
        //            sipNyuTsnNtgk1 = sipNyuTsnNtgk1.add(syuSyouhnParam.getKihons());
        //        }
        //        if (C_UmuKbn.ARI.eq(syuSyouhnZokusei.getSipnyutsn2umu())) {
        //            sipNyuTsnNtgk2 = sipNyuTsnNtgk2.add(syuSyouhnParam.getKihons());
        //        }
        //        if (C_UmuKbn.ARI.eq(syuSyouhnZokusei.getSipnyutsn3umu())) {
        //            sipNyuTsnNtgk3 = sipNyuTsnNtgk3.add(syuSyouhnParam.getKihons());
        //        }

        if (pTkMosSyouhnParamLst != null && pTkMosSyouhnParamLst.size() > 0) {

            for (HT_MosSyouhn tkSyouhnParam : pTkMosSyouhnParamLst){

                BM_SyouhnZokusei tkSyouhnZokusei = null;

                mosSyouhn = tkSyouhnParam;

                String tkSyouhnCd = mosSyouhn.getSyouhncd();
                Integer tkSyouhnsdNo = mosSyouhn.getSyouhnsdno();

                tkSyouhnZokusei = bizDomManager.getSyouhnZokusei(tkSyouhnCd, tkSyouhnsdNo);

                //                if (C_UmuKbn.ARI.eq(tkSyouhnZokusei.getSipnyutsn1umu())) {
                //                    sipNyuTsnNtgk1 = sipNyuTsnNtgk1.add(tkSyouhnParam.getKihons());
                //                }
                //                if (C_UmuKbn.ARI.eq(tkSyouhnZokusei.getSipnyutsn2umu())) {
                //                    sipNyuTsnNtgk2 = sipNyuTsnNtgk2.add(tkSyouhnParam.getKihons());
                //                }
                //                if (C_UmuKbn.ARI.eq(tkSyouhnZokusei.getSipnyutsn3umu())) {
                //                    sipNyuTsnNtgk3 = sipNyuTsnNtgk3.add(tkSyouhnParam.getKihons());
                //                }
            }
        }
    }
}
