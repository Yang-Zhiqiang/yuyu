package yuyu.common.hozen.khcommon;

import javax.inject.Inject;

import org.slf4j.Logger;

import yuyu.def.classification.C_Syoumetujiyuu;

/**
 * 契約保全 契約保全共通 ＰＡＬ消滅コード変換
 */
public class ConvertPALSyoumetucd {

    @Inject
    private static Logger logger;

    public String exec(C_Syoumetujiyuu pSyoumetujiyuu) {
        logger.debug("▽ ＰＡＬ消滅コード変換 開始");
        logger.debug("｜   消滅事由  ＝  " +  pSyoumetujiyuu);

        String palSyoumetuCd = "";

        if (C_Syoumetujiyuu.JIKOU.eq(pSyoumetujiyuu) ) {
            palSyoumetuCd = "0100";
        }
        else if(C_Syoumetujiyuu.KYKTORIKESI.eq(pSyoumetujiyuu) ||
            C_Syoumetujiyuu.CLGOFF.eq(pSyoumetujiyuu) ||
            C_Syoumetujiyuu.MUKOU.eq(pSyoumetujiyuu)) {
            palSyoumetuCd = "0350";
        }
        else if (C_Syoumetujiyuu.KAIJO.eq(pSyoumetujiyuu)) {
            palSyoumetuCd = "0351";
        }
        else if (C_Syoumetujiyuu.SIBOU.eq(pSyoumetujiyuu)) {
            palSyoumetuCd = "3090";
        }
        else if (C_Syoumetujiyuu.SIBOUKYUUHUKINSHR.eq(pSyoumetujiyuu)) {
            palSyoumetuCd = "3091";
        }
        else if (C_Syoumetujiyuu.SIBOUSAIGAIHIGAITOU.eq(pSyoumetujiyuu)) {
            palSyoumetuCd = "3092";
        }
        else if (C_Syoumetujiyuu.SIBOUSAIGAIMENSEKI.eq(pSyoumetujiyuu)) {
            palSyoumetuCd = "3093";
        }
        else if (C_Syoumetujiyuu.SBKAIJO.eq(pSyoumetujiyuu)) {
            palSyoumetuCd = "3250";
        }
        else if (C_Syoumetujiyuu.MENSEKI.eq(pSyoumetujiyuu)) {
            palSyoumetuCd = "3251";
        }
        else if (C_Syoumetujiyuu.SBMUKOU.eq(pSyoumetujiyuu)) {
            palSyoumetuCd = "3252";
        }
        else if (C_Syoumetujiyuu.KAIYAKU.eq(pSyoumetujiyuu)) {
            palSyoumetuCd = "5010";
        }
        else if (C_Syoumetujiyuu.PMNYSYMET_JDSKN_SSNZM.eq(pSyoumetujiyuu)) {
            palSyoumetuCd = "5010";
        }
        else if (C_Syoumetujiyuu.PMNYSYMET_JDSKNGAI_SSNZM.eq(pSyoumetujiyuu)) {
            palSyoumetuCd = "5011";
        }
        else if (C_Syoumetujiyuu.PMNYSYMET_MSSN.eq(pSyoumetujiyuu)) {
            palSyoumetuCd = "6020";
        }

        logger.debug("｜   ＰＡＬ消滅コード  ＝  " +  palSyoumetuCd);
        logger.debug("△ ＰＡＬ消滅コード変換 終了");

        return palSyoumetuCd;
    }

}
