package yuyu.common.hozen.khcommon;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BzGetBankData;
import yuyu.common.biz.bzcommon.BzGetBankDataBean;
import yuyu.common.biz.bzcommon.IGkCommonKoumoku;
import yuyu.def.classification.C_BankYuuksHantKbn;
import yuyu.def.classification.C_BankmasterUmuKbn;
import yuyu.def.classification.C_EnkashrKahiKbn;
import yuyu.def.classification.C_GaikashrKahiKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 契約保全 契約保全共通 銀行マスタチェック
 */
public class KhCheckBankMaster {

    public static final int SYORI_OK = 0;

    public static final int BANK_SONZAI_ERR = 1;

    public static final int BANK_YUUKOU_HANTEI_ERR = 2;

    public static final int BANK_YTGINKOU_SOUKIN_ERR = 3;

    public static final int GAIKAKOUZA_SOUKIN_ERR = 4;

    private String ginkouName;

    private String shitenName;

    @Inject
    private static Logger logger;

    public KhCheckBankMaster() {
        super();
    }

    public int checkBankMaster(C_Tuukasyu pShrtuukasyu, String pBankCd, String pSitenCd) {

        logger.debug("▽ 銀行マスタチェック 開始");

        int errNaiyou = SYORI_OK;
        BizDate sysDate = BizDate.getSysDate();

        BzGetBankData bzGetBankData = SWAKInjector.getInstance(BzGetBankData.class);
        BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(pBankCd, pSitenCd, sysDate);

        if (!C_BankmasterUmuKbn.ARI.eq(bzGetBankDataBean.getBankmasterUmuKbn())) {
            errNaiyou = BANK_SONZAI_ERR;
            logger.debug("△ 銀行マスタチェック 終了");
            return errNaiyou;
        }

        if (!C_BankYuuksHantKbn.OK.eq(bzGetBankDataBean.getBankYuuksHantKbn())) {
            errNaiyou = BANK_YUUKOU_HANTEI_ERR;
            logger.debug("△ 銀行マスタチェック 終了");
            return errNaiyou;
        }

        if (IGkCommonKoumoku.BANKCD_YTGINKOU.equals(pBankCd)) {
            if (!C_EnkashrKahiKbn.KA.eq(bzGetBankDataBean.getEnkashrKahiKbn())) {
                errNaiyou = BANK_YTGINKOU_SOUKIN_ERR;
                logger.debug("△ 銀行マスタチェック 終了");
                return errNaiyou;
            }
        }

        if (!C_Tuukasyu.JPY.eq(pShrtuukasyu)) {
            if (!C_GaikashrKahiKbn.KA.eq(bzGetBankDataBean.getGaikashrKahiKbn())) {
                errNaiyou = GAIKAKOUZA_SOUKIN_ERR;
                logger.debug("△ 銀行マスタチェック 終了");
                return errNaiyou;
            }
        }

        this.ginkouName = bzGetBankDataBean.getBankNmKj();
        this.shitenName = bzGetBankDataBean.getSitenNmKj();
        logger.debug("△ 銀行マスタチェック 終了");

        return errNaiyou;
    }

    public String getGinkouName() {

        return this.ginkouName;
    }

    public String getShitenName() {

        return this.shitenName;
    }

}
