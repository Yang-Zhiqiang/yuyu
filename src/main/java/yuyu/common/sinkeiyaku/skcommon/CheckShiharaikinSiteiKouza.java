package yuyu.common.sinkeiyaku.skcommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzGetBankData;
import yuyu.common.biz.bzcommon.BzGetBankDataBean;
import yuyu.common.biz.bzcommon.CheckKana;
import yuyu.common.biz.bzcommon.CheckKouzaNo;
import yuyu.common.biz.bzcommon.CheckMeigininNmKana;
import yuyu.common.biz.bzcommon.IGkCommonKoumoku;
import yuyu.def.classification.C_BankYuuksHantKbn;
import yuyu.def.classification.C_BankmasterUmuKbn;
import yuyu.def.classification.C_EnkashrKahiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_GaikashrKahiKbn;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YokinKbn;

/**
 * 新契約 新契約共通 支払金指定口座チェック
 */
public class CheckShiharaikinSiteiKouza {

    public static int SHRKINSITEIKOUZAJYOUHOU_NRK_ERROR = 1;

    public static int SHRKINSITEIKOUZAJYOUHOU_MNRK_ERROR = 2;

    public static int TEIKISIHARAIKINSHRTUUKA_MNRK_ERROR = 3;

    public static int BANKCD_MNRK_ERROR = 4;

    public static int SITENCD_MNRK_ERROR = 5;

    public static int BANKMASTER_SNZCHK_ERROR = 6;

    public static int BANKYUUKOU_HANTEICHK_ERROR = 7;

    public static int BANKYENSOUKIN_CHK_ERROR = 8;

    public static int BANKGAIKASOUKIN_CHK_ERROR = 9;

    public static int YOKINSYUMOKU_MNRK_ERROR = 10;

    public static int YOKINSYUMOKUGAIKA_NRK_ERROR = 11;

    public static int YOKINSYUMOKU_YUUTYOCHK_ERROR = 12;

    public static int KOUZANO_MNRK_ERROR = 13;

    public static int KOUZANO_KYOKAMOJICHK_ERROR = 14;

    public static int KOUZANO_KETASUUCHK_ERROR = 15;

    public static int KZKYKDOUKBN_MNRK_ERROR = 16;

    public static int KZKYKDOUKBNGAIKA_NRK_ERROR = 17;

    public static int KZMEIGINMKN_MNRK_ERROR = 18;

    public static int KZMEIGINMKN_NRK_ERROR = 19;

    public static int KZMEIGINMKN_KYOKAMOJICHK_ERROR = 20;

    public static int KZMEIGINMKN_KETASUUCHK_ERROR = 21;

    public static int KZMEIGINMKN_HUITTICHK_ERROR = 22;

    private List<Integer> errorCdList;

    @Inject
    private static Logger logger;

    public CheckShiharaikinSiteiKouza() {
        super();
    }

    public C_ErrorKbn exec(C_Tkhukaumu pTeikisiharaitkykhkkbn, C_KouzasyuruiKbn pTeikishrkinshrtuuka, String pBankcd,
        String pSitencd, C_YokinKbn pYokinkbn, String pKouzano, C_KzkykdouKbn pKzkykdoukbn, String pKyknmkn,
        String pKzmeiginmkn, BizDate pSyoriymd) {

        logger.debug("▽ 支払金指定口座チェック処理 開始");

        errorCdList = new ArrayList<>();

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        checkAllKoumokuInput(pTeikisiharaitkykhkkbn, pTeikishrkinshrtuuka, pBankcd, pSitencd, pYokinkbn, pKouzano,
            pKzkykdoukbn, pKzmeiginmkn);

        if (errorCdList.size() > 0) {

            errorKbn = C_ErrorKbn.ERROR;

            logger.debug("△ 支払金指定口座チェック処理 終了");

            return errorKbn;

        }

        if (!C_Tkhukaumu.HUKA.eq(pTeikisiharaitkykhkkbn)) {

            logger.debug("△ 支払金指定口座チェック処理 終了");

            return errorKbn;
        }

        if (C_KouzasyuruiKbn.BLNK.eq(pTeikishrkinshrtuuka)) {

            errorCdList.add(TEIKISIHARAIKINSHRTUUKA_MNRK_ERROR);
        }

        checkGinkouSiten(pBankcd, pSitencd, pTeikishrkinshrtuuka, pSyoriymd);

        checkYokinSyumoku(pYokinkbn, pBankcd, pTeikishrkinshrtuuka);

        checkKouzaNo(pKouzano, pTeikishrkinshrtuuka);

        checkKouzaMeigiNmKana(pKzkykdoukbn, pKzmeiginmkn, pKyknmkn, pTeikishrkinshrtuuka);

        if (C_KzkykdouKbn.SITEI.eq(pKzkykdoukbn)) {

            if (!BizUtil.isBlank(pKzmeiginmkn)) {

                if (!pKzmeiginmkn.equals(pKyknmkn)) {

                    errorCdList.add(KZMEIGINMKN_HUITTICHK_ERROR);
                }
            }
        }

        if (errorCdList.size() > 0) {

            errorKbn = C_ErrorKbn.ERROR;
        }

        logger.debug("△ 支払金指定口座チェック処理 終了");

        return errorKbn;

    }

    public List<Integer> getErrorCdList() {

        return errorCdList;
    }

    private void checkAllKoumokuInput(C_Tkhukaumu pTeikisiharaitkykhkkbn, C_KouzasyuruiKbn pTeikishrkinshrtuuka,
        String pBankcd, String pSitencd, C_YokinKbn pYokinkbn, String pKouzano, C_KzkykdouKbn pKzkykdoukbn,
        String pKzmeiginmkn) {

        if (!C_Tkhukaumu.HUKA.eq(pTeikisiharaitkykhkkbn)) {

            if (!C_KouzasyuruiKbn.BLNK.eq(pTeikishrkinshrtuuka) || !BizUtil.isBlank(pBankcd) ||
                !BizUtil.isBlank(pSitencd) || !C_YokinKbn.BLNK.eq(pYokinkbn) || !BizUtil.isBlank(pKouzano) ||
                !C_KzkykdouKbn.BLNK.eq(pKzkykdoukbn) || !BizUtil.isBlank(pKzmeiginmkn)) {

                errorCdList.add(SHRKINSITEIKOUZAJYOUHOU_NRK_ERROR);

                return;
            }
        }

        if (C_Tkhukaumu.HUKA.eq(pTeikisiharaitkykhkkbn)) {

            if (C_KouzasyuruiKbn.BLNK.eq(pTeikishrkinshrtuuka) && BizUtil.isBlank(pBankcd) &&
                BizUtil.isBlank(pSitencd) && C_YokinKbn.BLNK.eq(pYokinkbn) && BizUtil.isBlank(pKouzano)
                && C_KzkykdouKbn.BLNK.eq(pKzkykdoukbn) && BizUtil.isBlank(pKzmeiginmkn)) {

                errorCdList.add(SHRKINSITEIKOUZAJYOUHOU_MNRK_ERROR);

                return;
            }
        }
    }

    private void checkGinkouSiten(String pBankcd, String pSitencd, C_KouzasyuruiKbn pTeikishrkinshrtuuka,
        BizDate pSyoriymd) {

        if (BizUtil.isBlank(pBankcd)) {

            errorCdList.add(BANKCD_MNRK_ERROR);
        }

        if (BizUtil.isBlank(pSitencd)) {

            errorCdList.add(SITENCD_MNRK_ERROR);
        }

        if (BizUtil.isBlank(pBankcd) || BizUtil.isBlank(pSitencd)) {

            return;
        }

        BzGetBankData getBankData = SWAKInjector.getInstance(BzGetBankData.class);

        BzGetBankDataBean bzGetBankDataBean = getBankData.exec(pBankcd, pSitencd, pSyoriymd);

        if (!C_BankmasterUmuKbn.ARI.eq(bzGetBankDataBean.getBankmasterUmuKbn())) {

            errorCdList.add(BANKMASTER_SNZCHK_ERROR);

            return;
        }

        if (!C_BankYuuksHantKbn.OK.eq(bzGetBankDataBean.getBankYuuksHantKbn())) {

            errorCdList.add(BANKYUUKOU_HANTEICHK_ERROR);
        }

        if (C_KouzasyuruiKbn.YENKOUZA.eq(pTeikishrkinshrtuuka)) {

            if (!C_EnkashrKahiKbn.KA.eq(bzGetBankDataBean.getEnkashrKahiKbn())) {

                errorCdList.add(BANKYENSOUKIN_CHK_ERROR);
            }
        }
        else if (C_KouzasyuruiKbn.GAIKAKOUZA.eq(pTeikishrkinshrtuuka)) {

            if (!C_GaikashrKahiKbn.KA.eq(bzGetBankDataBean.getGaikashrKahiKbn())) {

                errorCdList.add(BANKGAIKASOUKIN_CHK_ERROR);
            }
        }
    }

    private void checkYokinSyumoku(C_YokinKbn pYokinkbn, String pBankcd, C_KouzasyuruiKbn pTeikishrkinshrtuuka) {

        if (C_KouzasyuruiKbn.YENKOUZA.eq(pTeikishrkinshrtuuka)) {

            if (C_YokinKbn.BLNK.eq(pYokinkbn)) {

                errorCdList.add(YOKINSYUMOKU_MNRK_ERROR);
            }
        }
        else if (C_KouzasyuruiKbn.GAIKAKOUZA.eq(pTeikishrkinshrtuuka)) {

            if (!C_YokinKbn.BLNK.eq(pYokinkbn)) {

                errorCdList.add(YOKINSYUMOKUGAIKA_NRK_ERROR);
            }
        }

        if (BizUtil.isBlank(pBankcd)) {

            return;
        }

        if (IGkCommonKoumoku.BANKCD_YTGINKOU.equals(pBankcd) && !C_YokinKbn.HUTUU.eq(pYokinkbn)) {

            errorCdList.add(YOKINSYUMOKU_YUUTYOCHK_ERROR);
        }
    }

    private void checkKouzaNo(String pKouzano, C_KouzasyuruiKbn pTeikishrkinshrtuuka) {

        C_Tuukasyu tuukasyu = C_Tuukasyu.BLNK;
        String kouzano = pKouzano;

        if (C_KouzasyuruiKbn.YENKOUZA.eq(pTeikishrkinshrtuuka)) {

            tuukasyu = C_Tuukasyu.JPY;
        }
        else if (C_KouzasyuruiKbn.GAIKAKOUZA.eq(pTeikishrkinshrtuuka)) {

            tuukasyu = C_Tuukasyu.USD;
        }

        if (BizUtil.isBlank(kouzano)) {

            errorCdList.add(KOUZANO_MNRK_ERROR);

            return;
        }

        CheckKouzaNo checkKouzaNo = SWAKInjector.getInstance(CheckKouzaNo.class);

        if (!C_Tuukasyu.BLNK.eq(tuukasyu)) {

            boolean checkKekka = checkKouzaNo.isCheckOK(kouzano, tuukasyu);

            if (!checkKekka) {

                errorCdList.add(KOUZANO_KYOKAMOJICHK_ERROR);
            }
        }

        if (!C_Tuukasyu.BLNK.eq(tuukasyu)) {

            boolean checkKekka = checkKouzaNo.isKyoyouKeta(kouzano, tuukasyu);

            if (!checkKekka) {

                errorCdList.add(KOUZANO_KETASUUCHK_ERROR);
            }
        }
    }

    private void checkKouzaMeigiNmKana(C_KzkykdouKbn pKzkykdoukbn, String pKzmeiginmkn, String pKyknmkn,
        C_KouzasyuruiKbn pTeikishrkinshrtuuka) {

        C_Tuukasyu tuukasyu = C_Tuukasyu.BLNK;
        String kzmeiginmkn = pKzmeiginmkn;

        if (C_KouzasyuruiKbn.YENKOUZA.eq(pTeikishrkinshrtuuka)) {

            tuukasyu = C_Tuukasyu.JPY;
        }
        else if (C_KouzasyuruiKbn.GAIKAKOUZA.eq(pTeikishrkinshrtuuka)) {

            tuukasyu = C_Tuukasyu.USD;
        }

        if (C_KzkykdouKbn.BLNK.eq(pKzkykdoukbn)) {

            errorCdList.add(KZKYKDOUKBN_MNRK_ERROR);

            return;
        }

        if (C_KouzasyuruiKbn.GAIKAKOUZA.eq(pTeikishrkinshrtuuka)) {

            if (C_KzkykdouKbn.DOUITU.eq(pKzkykdoukbn)) {

                errorCdList.add(KZKYKDOUKBNGAIKA_NRK_ERROR);
            }
        }

        if (BizUtil.isBlank(pKzmeiginmkn)) {

            if (C_KzkykdouKbn.SITEI.eq(pKzkykdoukbn)) {

                errorCdList.add(KZMEIGINMKN_MNRK_ERROR);

                return;
            }
            else if (C_KzkykdouKbn.DOUITU.eq(pKzkykdoukbn)) {

                kzmeiginmkn = pKyknmkn;
            }
        }
        else {

            if (C_KzkykdouKbn.DOUITU.eq(pKzkykdoukbn)) {

                errorCdList.add(KZMEIGINMKN_NRK_ERROR);

                return;
            }
        }

        if (!C_Tuukasyu.BLNK.eq(tuukasyu)) {

            boolean checkKekka = CheckMeigininNmKana.isCheckOK_Tuuka(kzmeiginmkn, tuukasyu);

            if (!checkKekka) {

                errorCdList.add(KZMEIGINMKN_KYOKAMOJICHK_ERROR);
            }
        }

        boolean checkKekka = CheckKana.isKyoyouKetaHankaku_Kouza(kzmeiginmkn);

        if (!checkKekka) {

            errorCdList.add(KZMEIGINMKN_KETASUUCHK_ERROR);
        }
    }
}