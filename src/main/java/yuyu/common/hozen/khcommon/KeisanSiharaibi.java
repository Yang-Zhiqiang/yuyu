package yuyu.common.hozen.khcommon;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.kaikei.BzShiharaiDenpyouDateShutoku;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_KinouKbn;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.AS_Kinou;

/**
 * 契約保全 契約保全共通 支払日計算
 */
public class KeisanSiharaibi {

    private C_ShrhousiteiKbn shrhousiteiKbn = C_ShrhousiteiKbn.BLNK;

    @Inject
    private AS_Kinou kinou;

    public C_ShrhousiteiKbn getShrhousiteiKbn() {
        return shrhousiteiKbn;
    }

    public BizDate exec(BizDate pSyoriYmd, C_InputShrhousiteiKbn pInputShrhousiteiKbn, C_Tuukasyu pTuukasyu, String pBankCd) {

        shrhousiteiKbn = C_ShrhousiteiKbn.BLNK;

        C_KinouKbn kinouKbn = kinou.getKinouKbn();

        if (C_InputShrhousiteiKbn.FBSOUKIN.eq(pInputShrhousiteiKbn)){

            if (C_KinouKbn.ONLINE.eq(kinouKbn)){

                if (C_Tuukasyu.JPY.eq(pTuukasyu)){

                    shrhousiteiKbn = C_ShrhousiteiKbn.FB_YOKUJITU;

                }
                else {

                    shrhousiteiKbn = C_ShrhousiteiKbn.FB_2EIGYOUBI;

                }
            }

            else if(C_KinouKbn.BATCH.eq(kinouKbn)){

                shrhousiteiKbn = C_ShrhousiteiKbn.FB_3EIGYOUBI;

            }
        }
        if (C_InputShrhousiteiKbn.KARIUKE_RISOKU_ARI.eq(pInputShrhousiteiKbn)){

            shrhousiteiKbn = C_ShrhousiteiKbn.KARIUKE_RISOKU_ARI;

        }

        if (C_InputShrhousiteiKbn.KARIUKE_RISOKU_NASI.eq(pInputShrhousiteiKbn)){

            shrhousiteiKbn = C_ShrhousiteiKbn.KARIUKE_RISOKU_NASI;

        }

        BzShiharaiDenpyouDateShutoku bzShiharaiDenpyouDateShutoku = SWAKInjector.getInstance(BzShiharaiDenpyouDateShutoku.class);

        BizDate siharaiBi = bzShiharaiDenpyouDateShutoku.exec(pSyoriYmd, shrhousiteiKbn, pTuukasyu, pBankCd);

        return siharaiBi;

    }
}
