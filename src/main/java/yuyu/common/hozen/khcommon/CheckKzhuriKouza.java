package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;

import com.google.common.base.Strings;

import yuyu.common.biz.bzcommon.BzGetBankData;
import yuyu.common.biz.bzcommon.BzGetBankDataBean;
import yuyu.common.biz.bzcommon.GetBankSitenNm;
import yuyu.common.biz.bzcommon.CheckKana;
import yuyu.common.biz.bzcommon.CheckKouzaNo;
import yuyu.common.biz.bzcommon.CheckMeigininNmKana;
import yuyu.common.biz.bzcommon.IGkCommonKoumoku;
import yuyu.def.MessageId;
import yuyu.def.classification.C_BankYuuksHantKbn;
import yuyu.def.classification.C_BankmasterUmuKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YokinKbn;

/**
 * 契約保全 契約保全共通 口座振替口座入力チェック
 */
public class CheckKzhuriKouza {

    public static int BANKCD_NRK_ERROR = 1;

    public static int SITENCD_NRK_ERROR = 2;

    public static int BANKMASTER_SNZCHK_ERROR = 3;

    public static int BANKYUUKOU_HANTEICHK_ERROR = 4;

    public static int YOFURIKYOUTEI_CHK_ERROR = 5;

    public static int BFRYOKIN_MINRYK_ERROR = 6;

    public static int BFRYOKIN_YUUTYOCHK_ERROR = 7;

    public static int KOUZANO_MNYRYK_ERROR = 8;

    public static int KOUZANO_KYOKAMONJICHK_ERROR = 9;

    public static int KOUZANO_KETASUCHK_ERROR = 10;

    public static int KZKYK_DOUKBNMINYURYK_ERROR = 11;

    public static int KZMEIGINMKN_MNYRYKU_ERROR = 12;

    public static int KZMEIGINMK_NNYRYKU_ERROR = 13;

    public static int KZMEIGINMKN_KYOKAMONJICHK_ERROR = 14;

    public static int KZMEIGINMKN_KETASUUCHK_ERROR = 15;

    private List<Integer> errorCdlst;

    private String banknm;

    private String sitennm;

    private String kozano;

    private String kzmeiginmei;

    @Inject
    private static Logger logger;

    public CheckKzhuriKouza() {
        super();
    }

    public C_ErrorKbn exec(String pBankcd, String pSitencd, C_YokinKbn pBfryokin, C_KzkykdouKbn pKzkykdoukbn,
        String pKyknmkn, String pKzmeiginmkn, String pKouzano, BizDate pSyoriymd) {

        logger.debug("▽ 口座振替口座入力チェック 開始");

        errorCdlst = new ArrayList<>();

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        checkGinkouSiten(pBankcd, pSitencd, pSyoriymd);

        checkYokinSyumoku(pBfryokin, pBankcd);

        checkKouzaNo(pKouzano, C_Tuukasyu.JPY);

        checkKouzaMeigiNmKana(pKzkykdoukbn, pKzmeiginmkn, pKyknmkn, C_Tuukasyu.JPY);

        if (errorCdlst != null && errorCdlst.size() != 0) {

            errorKbn = C_ErrorKbn.ERROR;
        }

        logger.debug("△ 口座振替口座入力チェック 終了");

        return errorKbn;
    }

    public boolean exec(CheckKzhuriKouzaExecUiBeanParam pUiBean) {

        logger.debug("▽ 口座振替口座入力チェック 開始");

        errorCdlst = new ArrayList<>();

        banknm = null;

        sitennm = null;

        kozano = null;

        kzmeiginmei = null;

        checkGinkouSiten(pUiBean.getBankcd(), pUiBean.getSitencd(), BizDate.getSysDate());

        if (errorCdlst != null && errorCdlst.size() > 0) {

            if (errorCdlst.get(0) == BANKCD_NRK_ERROR) {

                throw new BizLogicException(MessageId.EBC0043, "銀行コード");
            }
            else if (errorCdlst.get(0) == SITENCD_NRK_ERROR) {

                throw new BizLogicException(MessageId.EBC0043, "支店コード");
            }
            else if (errorCdlst.get(0) == BANKMASTER_SNZCHK_ERROR) {

                throw new BizLogicException(MessageId.EBC1007);
            }
            else if (errorCdlst.get(0) == BANKYUUKOU_HANTEICHK_ERROR) {

                throw new BizLogicException(MessageId.EBC1008);
            }
            else if (errorCdlst.get(0) == YOFURIKYOUTEI_CHK_ERROR) {

                throw new BizLogicException(MessageId.EIA3009);
            }
        }

        pUiBean.setBanknmkj(banknm);

        pUiBean.setSitennmkj(sitennm);

        checkYokinSyumoku(pUiBean.getYokinkbn(), pUiBean.getBankcd());

        if (errorCdlst != null && errorCdlst.size() > 0) {

            if (errorCdlst.get(0) == BFRYOKIN_MINRYK_ERROR) {

                throw new BizLogicException(MessageId.EBC0043, "預金種目");
            }
            else if (errorCdlst.get(0) == BFRYOKIN_YUUTYOCHK_ERROR) {

                throw new BizLogicException(MessageId.EBC1011, pUiBean.getYokinkbn().getContent());
            }
        }

        checkKouzaNo(pUiBean.getKouzano(), C_Tuukasyu.JPY);

        if (errorCdlst != null && errorCdlst.size() > 0) {

            if (errorCdlst.get(0) == KOUZANO_MNYRYK_ERROR) {

                throw new BizLogicException(MessageId.EBC0043, "口座番号");
            }
            else if (errorCdlst.get(0) == KOUZANO_KYOKAMONJICHK_ERROR) {

                throw new BizLogicException(MessageId.EBC0046, "口座番号");
            }
            else if (errorCdlst.get(0) == KOUZANO_KETASUCHK_ERROR) {

                throw new BizLogicException(MessageId.EBC1012, "口座番号");
            }
        }

        pUiBean.setKouzano(kozano);

        checkKouzaMeigiNmKana(pUiBean.getKzkykdoukbn(), pUiBean.getKzmeiginmkn(), pUiBean.getVkykskyknmkn(),
            C_Tuukasyu.JPY);

        if (errorCdlst != null && errorCdlst.size() > 0) {

            if (errorCdlst.get(0) == KZKYK_DOUKBNMINYURYK_ERROR) {

                throw new BizLogicException(MessageId.EBC0043, "口座名義契約者同一人区分");
            }
            else if (errorCdlst.get(0) == KZMEIGINMKN_MNYRYKU_ERROR) {

                throw new BizLogicException(MessageId.EBC0045, "口座名義人");
            }
            else if (errorCdlst.get(0) == KZMEIGINMK_NNYRYKU_ERROR) {

                throw new BizLogicException(MessageId.EBC0046, "口座名義人");
            }
            else if (errorCdlst.get(0) == KZMEIGINMKN_KYOKAMONJICHK_ERROR) {

                throw new BizLogicException(MessageId.EBC0046, "口座名義人");
            }
            else if (errorCdlst.get(0) == KZMEIGINMKN_KETASUUCHK_ERROR) {

                throw new BizLogicException(MessageId.EBC1012, "口座名義人");
            }
        }

        pUiBean.setKzmeiginmkn(kzmeiginmei);

        logger.debug("△ 口座振替口座入力チェック 終了");

        return true;
    }

    private void checkGinkouSiten(String pBankcd, String pSitencd, BizDate pSyoriymd) {

        String bankcd = pBankcd;

        String sitencd = pSitencd;

        BizDate syoriymd = pSyoriymd;

        if (StringUtils.isBlank(bankcd)) {

            errorCdlst.add(BANKCD_NRK_ERROR);
        }

        if (StringUtils.isBlank(sitencd)) {

            errorCdlst.add(SITENCD_NRK_ERROR);
        }

        if (StringUtils.isBlank(bankcd) || StringUtils.isBlank(sitencd)) {

            return;
        }

        BzGetBankData bzGetBankData = SWAKInjector.getInstance(BzGetBankData.class);

        BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(bankcd, sitencd, syoriymd);

        if (!C_BankmasterUmuKbn.ARI.eq(bzGetBankDataBean.getBankmasterUmuKbn())) {

            errorCdlst.add(BANKMASTER_SNZCHK_ERROR);

            return;
        }
        if (!C_BankYuuksHantKbn.OK.eq(bzGetBankDataBean.getBankYuuksHantKbn())) {

            errorCdlst.add(BANKYUUKOU_HANTEICHK_ERROR);

            return;

        }
        GetBankSitenNm getBankSitenNm = SWAKInjector.getInstance(GetBankSitenNm.class);

        getBankSitenNm.exec(bankcd, sitencd);

        if (C_ErrorKbn.OK.eq(getBankSitenNm.getErrorKbn())){

            banknm = getBankSitenNm.getBankNmKj();

            sitennm = getBankSitenNm.getSitenNmKj();

        }
        if (C_KahiKbn.HUKA.eq(bzGetBankDataBean.getYohuriKahiKbn())) {

            errorCdlst.add(YOFURIKYOUTEI_CHK_ERROR);
        }
    }

    private void checkYokinSyumoku(C_YokinKbn pBfryokin, String pBankcd) {

        C_YokinKbn bfryokin = pBfryokin;

        String bankcd = pBankcd;

        if (C_YokinKbn.BLNK.eq(bfryokin)) {

            errorCdlst.add(BFRYOKIN_MINRYK_ERROR);
        }

        if (C_YokinKbn.BLNK.eq(bfryokin) || StringUtils.isBlank(bankcd)) {

            return;
        }

        if (IGkCommonKoumoku.BANKCD_YTGINKOU.equals(bankcd) && !C_YokinKbn.HUTUU.eq(bfryokin)) {

            errorCdlst.add(BFRYOKIN_YUUTYOCHK_ERROR);
        }
    }

    private void checkKouzaNo(String pKouzano, C_Tuukasyu pTuukasyu) {

        String kouzano = pKouzano;

        C_Tuukasyu tuukasyu = pTuukasyu;

        if (StringUtils.isBlank(kouzano)) {

            errorCdlst.add(KOUZANO_MNYRYK_ERROR);

            return;
        }
        else if (kouzano.length() < 7) {

            kouzano = Strings.padStart(kouzano, 7, '0');
        }

        CheckKouzaNo checkKouzaNo = SWAKInjector.getInstance(CheckKouzaNo.class);

        boolean checkKeika = checkKouzaNo.isCheckOK(kouzano, tuukasyu);

        if (!checkKeika) {

            errorCdlst.add(KOUZANO_KYOKAMONJICHK_ERROR);
        }

        checkKeika = checkKouzaNo.isKyoyouKeta(kouzano, tuukasyu);

        if (!checkKeika) {

            errorCdlst.add(KOUZANO_KETASUCHK_ERROR);
        }

        kozano = kouzano;

    }

    private void checkKouzaMeigiNmKana(C_KzkykdouKbn pKzkykdoukbn, String pKzmeiginmkn, String pKyknmkn,
        C_Tuukasyu pTuukasyu) {

        C_KzkykdouKbn kzkykdoukbn = pKzkykdoukbn;

        String kzmeiginmkn = pKzmeiginmkn;

        String kyknmkn = pKyknmkn;

        C_Tuukasyu tuukasyu = pTuukasyu;

        if (C_KzkykdouKbn.BLNK.eq(kzkykdoukbn)) {

            errorCdlst.add(KZKYK_DOUKBNMINYURYK_ERROR);

            return;
        }

        if (StringUtils.isBlank(kzmeiginmkn)) {

            if (!C_KzkykdouKbn.DOUITU.eq(kzkykdoukbn)) {

                errorCdlst.add(KZMEIGINMKN_MNYRYKU_ERROR);

                return;
            }
            else if (C_KzkykdouKbn.DOUITU.eq(kzkykdoukbn)) {

                kzmeiginmkn = kyknmkn;
            }
        }
        else {

            if (C_KzkykdouKbn.DOUITU.eq(kzkykdoukbn)) {

                errorCdlst.add(KZMEIGINMK_NNYRYKU_ERROR);

                return;
            }
        }

        boolean checkkeika = CheckMeigininNmKana.isCheckOK_Tuuka(kzmeiginmkn, tuukasyu);

        if (!checkkeika) {

            errorCdlst.add(KZMEIGINMKN_KYOKAMONJICHK_ERROR);
        }

        checkkeika = CheckKana.isKyoyouKetaHankaku_Kouza(kzmeiginmkn);

        if (!checkkeika) {

            errorCdlst.add(KZMEIGINMKN_KETASUUCHK_ERROR);
        }

        kzmeiginmei = kzmeiginmkn;
    }

    public List<Integer> getErrorCdlst() {

        return errorCdlst;
    }

}
