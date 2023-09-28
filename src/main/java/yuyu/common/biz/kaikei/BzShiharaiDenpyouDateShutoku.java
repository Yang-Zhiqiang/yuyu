package yuyu.common.biz.kaikei;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_SeisanDShrymd;
import yuyu.def.db.entity.BM_TuukabetuKyuusibi;

import com.google.common.collect.Lists;

/**
 * 業務共通 経理・会計 支払伝票日付取得
 */
public class BzShiharaiDenpyouDateShutoku {

    private final String BANKCODE_SMBC = "0009";

    @Inject
    private static Logger logger;

    @Inject
    private BizDomManager bizDomManager;

    public BzShiharaiDenpyouDateShutoku() {
        super();
    }

    public BizDate exec(BizDate pSyoriYmd, C_ShrhousiteiKbn pShrhousiteiKbn, C_Tuukasyu pTuukasyu, String pBankCd) {

        logger.debug("▽ 支払伝票日付取得 開始");

        BizDate shiharaiDenpyouHiduke = null;

        if (C_ShrhousiteiKbn.FB_SOUDAIKAI_YOKUEI.eq(pShrhousiteiKbn)
            || C_ShrhousiteiKbn.KARIUKE_RISOKU_ARI_SOUDAIKAI_YOKUEI.eq(pShrhousiteiKbn)) {

            BizDateY syoriY = pSyoriYmd.getBizDateY();

            BM_SeisanDShrymd seisanDShrymd = bizDomManager.getSeisanDShrymd(syoriY);

            shiharaiDenpyouHiduke = seisanDShrymd.getSeisandshrymd();

        }
        else {

            int chakkinYoteiNissuu = 0;

            if (C_ShrhousiteiKbn.FB_YOKUJITU.eq(pShrhousiteiKbn)) {

                chakkinYoteiNissuu = 1;
            }

            else if (C_ShrhousiteiKbn.FB_2EIGYOUBI.eq(pShrhousiteiKbn)) {

                chakkinYoteiNissuu = 2;
            }

            else if (C_ShrhousiteiKbn.FB_3EIGYOUBI.eq(pShrhousiteiKbn)) {

                chakkinYoteiNissuu = 3;
            }

            else if (C_ShrhousiteiKbn.KARIUKE_RISOKU_ARI.eq(pShrhousiteiKbn)
                || C_ShrhousiteiKbn.KARIUKE_RISOKU_NASI.eq(pShrhousiteiKbn)) {

                chakkinYoteiNissuu = 1;
            }

            else {

                return null;
            }

            int pDays = chakkinYoteiNissuu;
            shiharaiDenpyouHiduke = pSyoriYmd.addBusinessDays(pDays);

        }

        if ((C_Tuukasyu.USD.eq(pTuukasyu) || C_Tuukasyu.AUD.eq(pTuukasyu) || C_Tuukasyu.EUR.eq(pTuukasyu)) &&
            (C_ShrhousiteiKbn.FB_YOKUJITU.eq(pShrhousiteiKbn)
                || C_ShrhousiteiKbn.FB_2EIGYOUBI.eq(pShrhousiteiKbn)
                || C_ShrhousiteiKbn.FB_3EIGYOUBI.eq(pShrhousiteiKbn)
                || C_ShrhousiteiKbn.FB_SOUDAIKAI_YOKUEI.eq(pShrhousiteiKbn)) &&
                !BANKCODE_SMBC.equals(pBankCd)) {

            int pMonths = 1;
            BizDate shutokuShuuryoubi = shiharaiDenpyouHiduke.addMonths(pMonths).getRekijyou();

            List<BM_TuukabetuKyuusibi> toriatukaibiLst = Lists.newArrayList();

            if (C_Tuukasyu.USD.eq(pTuukasyu)) {

                toriatukaibiLst = bizDomManager.getTuukabetuKyuusibisByTuukatoriatukaiymdKyuusiusdkbnBlank
                    (shiharaiDenpyouHiduke, shutokuShuuryoubi);
            }

            else if (C_Tuukasyu.AUD.eq(pTuukasyu)) {

                toriatukaibiLst = bizDomManager.getTuukabetuKyuusibisByTuukatoriatukaiymdKyuusiaudkbnBlank
                    (shiharaiDenpyouHiduke, shutokuShuuryoubi);
            }

            else if (C_Tuukasyu.EUR.eq(pTuukasyu)) {

                toriatukaibiLst = bizDomManager.getTuukabetuKyuusibisByTuukatoriatukaiymdKyuusieurkbnBlank
                    (shiharaiDenpyouHiduke, shutokuShuuryoubi);
            }

            for (BM_TuukabetuKyuusibi tempTuukabetuKyuusibi : toriatukaibiLst) {
                BizDate toriatukaibi = tempTuukabetuKyuusibi.getTuukatoriatukaiymd();

                if (BizDateUtil.compareYmd(shiharaiDenpyouHiduke, toriatukaibi) == 0) {
                    shiharaiDenpyouHiduke = shiharaiDenpyouHiduke.addBusinessDays(1);
                }
                else if (BizDateUtil.compareYmd(shiharaiDenpyouHiduke, toriatukaibi) < 0) {
                    break;
                }
            }
        }

        logger.debug("△ 支払伝票日付取得 終了");

        return shiharaiDenpyouHiduke;
    }
}
