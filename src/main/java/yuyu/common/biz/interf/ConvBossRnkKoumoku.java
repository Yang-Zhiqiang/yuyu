package yuyu.common.biz.interf;

import javax.inject.Inject;

import org.slf4j.Logger;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;

/**
 * 業務共通 インターフェイス ＢＯＳＳ連携用項目変換
 */
public class ConvBossRnkKoumoku {

    @Inject
    private static Logger logger;

    public ConvBossRnkKoumoku() {
        super();
    }

    public ConvBossRnkKoumokuBean execAll(BM_SyouhnZokusei pSyouhnZokusei, C_Hrkkeiro pHrkkeiro, C_Tuukasyu pTuukasyu) {

        logger.debug("▽ ＢＯＳＳ連携用項目変換 開始");

        ConvBossRnkKoumokuBean convBossRnkKoumokuBean = SWAKInjector.getInstance(ConvBossRnkKoumokuBean.class);

        String syouhinBunruiKbn = getSyouhnBunruiKbn(pSyouhnZokusei);
        String syouhnNmKbn = getSyouhnNmKbn(pSyouhnZokusei, pTuukasyu);
        String syuunouKeiroKbn = getSyuunouKeiroKbn(pHrkkeiro);

        convBossRnkKoumokuBean.setSyouhinBunruiKbn(syouhinBunruiKbn);
        convBossRnkKoumokuBean.setSyouhnNmKbn(syouhnNmKbn);
        convBossRnkKoumokuBean.setSyuunouKeiroKbn(syuunouKeiroKbn);

        logger.debug("△ ＢＯＳＳ連携用項目変換 終了");

        return convBossRnkKoumokuBean;
    }

    public String getSyouhnBunruiKbn(BM_SyouhnZokusei pSyouhnZokusei) {
        String syouhinBunruiKbn = "";

        if (C_UmuKbn.ARI.eq(pSyouhnZokusei.getSyuusinhknumu())) {
            syouhinBunruiKbn = "C";
        }
        else if (C_UmuKbn.ARI.eq(pSyouhnZokusei.getNkhknumu())) {
            syouhinBunruiKbn = "B";
        }
        return syouhinBunruiKbn;
    }

    public String getSyouhnNmKbn(BM_SyouhnZokusei pSyouhnZokusei, C_Tuukasyu pTuukasyu) {
        String syouhnNmKbn = "";

        int syohinHanteiKbn = SyouhinUtil.hantei(pSyouhnZokusei.getSyouhncd());

        if(syohinHanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN){
            if(C_Tuukasyu.JPY.eq(pTuukasyu)){
                syouhnNmKbn = "33";
            }
            if(C_Tuukasyu.USD.eq(pTuukasyu)){
                syouhnNmKbn = "34";
            }
        }
        else if(syohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN){
            syouhnNmKbn = "37";
        }
        else if (C_UmuKbn.ARI.eq(pSyouhnZokusei.getSyuusinhknumu())) {
            syouhnNmKbn = "35";
        }
        else if (C_UmuKbn.ARI.eq(pSyouhnZokusei.getNkhknumu())) {
            syouhnNmKbn = "36";
        }
        return syouhnNmKbn;
    }

    public String getSyuunouKeiroKbn(C_Hrkkeiro pHrkkeiro) {
        String syuunouKeiroKbn = "";

        if (C_Hrkkeiro.KOUHURI.eq(pHrkkeiro)) {
            syuunouKeiroKbn = "3";
        }
        else if (C_Hrkkeiro.HURIKAE.eq(pHrkkeiro)) {
            syuunouKeiroKbn = "8";
        }
        else if (C_Hrkkeiro.CREDIT.eq(pHrkkeiro)) {
            syuunouKeiroKbn = "A";
        }
        return syuunouKeiroKbn;
    }
}