package yuyu.common.hozen.ascommon;

import javax.inject.Inject;

import org.slf4j.Logger;

import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * 契約保全 案内収納共通 払変処理区分設定
 */
public class SetHrhnSyoriKbn {

    @Inject
    private static Logger logger;

    public SetHrhnSyoriKbn() {
        super();
    }

    public C_SyoriKbn exec(C_UmuKbn pHrkkaisuuhn, C_UmuKbn pTikiktbrisyuruihnkumu, C_Hrkkeiro pBfrHrkkeiro,
        C_Hrkkeiro pHenHrkkeiro) {

        logger.debug("▽ 払変処理区分設定 開始");

        if (C_UmuKbn.ARI.eq(pHrkkaisuuhn)) {

            if (C_Hrkkeiro.BLNK.eq(pHenHrkkeiro)) {

                logger.debug("△ 払変処理区分設定 終了");

                return C_SyoriKbn.KAISUUHENKOU;
            }
            else if (C_Hrkkeiro.KOUHURI.eq(pHenHrkkeiro)) {

                if (C_Hrkkeiro.KOUHURI.eq(pBfrHrkkeiro)) {

                    logger.debug("△ 払変処理区分設定 終了");

                    return C_SyoriKbn.KAISUUHENKOU_KOUZAHENKOU;
                }
                else if (C_Hrkkeiro.CREDIT.eq(pBfrHrkkeiro)) {

                    logger.debug("△ 払変処理区分設定 終了");

                    return C_SyoriKbn.KAISUUHENKOU_YOHURIHENNYUU;
                }
            }
            else if (C_Hrkkeiro.CREDIT.eq(pHenHrkkeiro)) {

                if(C_Hrkkeiro.KOUHURI.eq(pBfrHrkkeiro)){

                    logger.debug("△ 払変処理区分設定 終了");

                    return C_SyoriKbn.KAISUUHENKOU_CRECAHENNYUU;
                }
            }
        }
        else if (C_UmuKbn.ARI.eq(pTikiktbrisyuruihnkumu)) {

            if (C_Hrkkeiro.BLNK.eq(pHenHrkkeiro)) {

                logger.debug("△ 払変処理区分設定 終了");

                return C_SyoriKbn.TIKIKTSYURUIHENKOU;
            }
            else if (C_Hrkkeiro.KOUHURI.eq(pHenHrkkeiro)) {

                if (C_Hrkkeiro.KOUHURI.eq(pBfrHrkkeiro)) {

                    logger.debug("△ 払変処理区分設定 終了");

                    return C_SyoriKbn.TIKIKTSYURUIHENKOU_KOUZAHENKOU;
                }
                else if (C_Hrkkeiro.CREDIT.eq(pBfrHrkkeiro)) {

                    logger.debug("△ 払変処理区分設定 終了");

                    return C_SyoriKbn.TIKIKTSYURUIHENKOU_YOHURIHENNYUU;
                }
            }
            else if (C_Hrkkeiro.CREDIT.eq(pHenHrkkeiro)) {

                if (C_Hrkkeiro.KOUHURI.eq(pBfrHrkkeiro)) {

                    logger.debug("△ 払変処理区分設定 終了");

                    return C_SyoriKbn.TIKIKTSYURUIHENKOU_CRECAHENNYUU;
                }
            }
        }
        else {

            if (C_Hrkkeiro.BLNK.eq(pHenHrkkeiro)) {

                logger.debug("△ 払変処理区分設定 終了");

                return C_SyoriKbn.HRIHENNONE;
            }
            else if (C_Hrkkeiro.KOUHURI.eq(pHenHrkkeiro)) {

                if (C_Hrkkeiro.KOUHURI.eq(pBfrHrkkeiro)) {

                    logger.debug("△ 払変処理区分設定 終了");

                    return C_SyoriKbn.KOUZAHENKOU;
                }
                else if (C_Hrkkeiro.CREDIT.eq(pBfrHrkkeiro)) {

                    logger.debug("△ 払変処理区分設定 終了");

                    return C_SyoriKbn.YOHURIHENNYUU;
                }
            }
            else if (C_Hrkkeiro.CREDIT.eq(pHenHrkkeiro)) {

                if (C_Hrkkeiro.KOUHURI.eq(pBfrHrkkeiro)) {

                    logger.debug("△ 払変処理区分設定 終了");

                    return C_SyoriKbn.CRECAHENNYUU;
                }
                else if (C_Hrkkeiro.CREDIT.eq(pBfrHrkkeiro)) {

                    logger.debug("△ 払変処理区分設定 終了");

                    return C_SyoriKbn.CRECAHENKOU;
                }
            }
        }

        logger.debug("△ 払変処理区分設定 終了");

        return C_SyoriKbn.BLNK;
    }
}
