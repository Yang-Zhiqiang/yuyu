package yuyu.common.sinkeiyaku.skcommon;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheckParam;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_SyoriCTL;

/**
 * 新契約 新契約共通 ＬＩＮＣ登録S（日額）取得
 */
public class GetLincTourokuS {

    private BizCurrency saigainYuinng = BizCurrency.valueOf(0);

    private BizCurrency sippeinYuinng = BizCurrency.valueOf(0);

    private BizCurrency seijinnYuinng = BizCurrency.valueOf(0);

    private final BizCurrency sonotanYuinng = BizCurrency.valueOf(0);

    private BizCurrency hutuSibous = BizCurrency.valueOf(0);

    private BizCurrency saigaiSibous = BizCurrency.valueOf(0);

    @Inject
    private BizDomManager bizDomManager;

    public GetLincTourokuS() {
        super();
    }

    public BizCurrency getSaigainyuinng() {
        return saigainYuinng;
    }

    public BizCurrency getSippeinyuinng() {
        return sippeinYuinng;
    }

    public BizCurrency getSeijinnyuinng() {
        return seijinnYuinng;
    }

    public BizCurrency getSonotanyuinng() {
        return sonotanYuinng;
    }

    public BizCurrency getHutusibous() {
        return hutuSibous;
    }

    public BizCurrency getSaigaisibous() {
        return saigaiSibous;
    }

    public void exec(MosnaiCheckParam pMosnaiCheckParam) {

        HT_SyoriCTL syoriCTL = pMosnaiCheckParam.getDataSyoriControl();
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhns();
        String mosNo = syoriCTL.getMosno();
        if (mosSyouhnLst == null || mosSyouhnLst.size() == 0) {
            throw new CommonBizAppException("申込番号=" + mosNo);
        }

        String syouhnCD = null;
        Integer syouhnsdNo = null;
        BizCurrency kihons = null;

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

        C_Tuukasyu kykTuukasyu = mosKihon.getKyktuukasyu();

        for (HT_MosSyouhn mosSyouhn : mosSyouhnLst) {

            syouhnCD = mosSyouhn.getSyouhncd();
            syouhnsdNo = mosSyouhn.getSyouhnsdno();
            kihons = mosSyouhn.getSeitoukihons();

            if (!C_Tuukasyu.JPY.eq(kykTuukasyu)) {

                GetKiteiCheckYenkansangk getKiteiCheckYenkansangk = SWAKInjector.getInstance(GetKiteiCheckYenkansangk.class);

                kihons = getKiteiCheckYenkansangk.exec(
                    mosKihon.getMosymd(), kihons, kykTuukasyu);
            }

            BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(syouhnCD, syouhnsdNo);

            if (syouhnZokusei == null) {
                throw new CommonBizAppException("申込番号=" + mosNo);
            }

            if (C_UmuKbn.ARI.eq(syouhnZokusei.getHutuusbhsyumu())) {
                hutuSibous = hutuSibous.add(kihons);
            }

            if (C_UmuKbn.ARI.eq(syouhnZokusei.getSgsbhsyumu())) {
                saigaiSibous = saigaiSibous.add(kihons);
            }

            if (C_UmuKbn.ARI.eq(syouhnZokusei.getSipnyukyhumu())) {
                sippeinYuinng = sippeinYuinng.add(kihons);
            }

            if (C_UmuKbn.ARI.eq(syouhnZokusei.getSgnyukyhumu())) {
                saigainYuinng = saigainYuinng.add(kihons);
            }

            if (C_UmuKbn.ARI.eq(syouhnZokusei.getSjnyukyhumu())) {
                seijinnYuinng = seijinnYuinng.add(kihons);
            }
        }
    }
}
