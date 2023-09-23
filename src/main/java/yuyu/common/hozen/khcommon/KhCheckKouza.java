package yuyu.common.hozen.khcommon;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.CheckKana;
import yuyu.common.biz.bzcommon.CheckKouzaNo;
import yuyu.common.biz.bzcommon.CheckMeigininNmKana;
import yuyu.common.biz.bzcommon.IGkCommonKoumoku;
import yuyu.def.MessageId;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_SoukinsakiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.IT_Kouza;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_UketoriKouza;

import com.google.common.base.Strings;

/**
 * 契約保全 契約保全共通 口座情報入力チェック
 */
public class KhCheckKouza {

    @Inject
    private static Logger logger;

    private String ginkouName;

    private String shitenName;

    public KhCheckKouza() {
        super();
    }

    public boolean chkSoukinsakiKouza(CheckKouzaChkSoukinsakiKouzaUiBeanParam pUiBeanParam, KhozenCommonParam pKCParm) {

        logger.debug("▽ 口座情報入力チェック 開始");

        C_SoukinsakiKbn soukinsakiKbn = pUiBeanParam.getSoukinsakikbn();

        if (C_SoukinsakiKbn.BLNK.eq(soukinsakiKbn)) {

            checkKouza(pUiBeanParam.getBankcd(),
                pUiBeanParam.getSitencd(),
                pUiBeanParam.getYokinkbn(),
                pUiBeanParam.getKouzano(),
                pUiBeanParam.getKzdoukbn(),
                pUiBeanParam.getKzmeiginmkn(),
                pUiBeanParam,
                pKCParm);
        }
        else if (C_SoukinsakiKbn.PHURIKZ.eq(soukinsakiKbn)) {

            IT_Kouza kouza = pKCParm.getKouza(pUiBeanParam.getSyono());

            if (kouza == null) {
                throw new BizLogicException(MessageId.EIA0082);
            }

            checkKouza(kouza.getBankcd(),
                kouza.getSitencd(),
                kouza.getYokinkbn(),
                kouza.getKouzano(),
                C_Kzdou.BLNK,
                kouza.getKzmeiginmkn(),
                pUiBeanParam,
                pKCParm);

            pUiBeanParam.setBankcd(kouza.getBankcd());
            pUiBeanParam.setSitencd(kouza.getSitencd());
            pUiBeanParam.setYokinkbn(kouza.getYokinkbn());

            if (C_KzkykdouKbn.DOUITU.eq(kouza.getKzkykdoukbn())) {
                pUiBeanParam.setKzdoukbn(C_Kzdou.DOUITU);
            }
            else {
                pUiBeanParam.setKzdoukbn(C_Kzdou.BLNK);
            }
        }
        else if (C_SoukinsakiKbn.TKSHKSHRKZ.eq(soukinsakiKbn)) {

            IT_UketoriKouza uketoriKouza = pKCParm.getTeikiShrUketoriKouza(pUiBeanParam.getSyono());

            if (uketoriKouza == null) {
                throw new BizLogicException(MessageId.EIA0082);
            }

            checkKouza(uketoriKouza.getBankcd(),
                uketoriKouza.getSitencd(),
                uketoriKouza.getYokinkbn(),
                uketoriKouza.getKouzano(),
                C_Kzdou.BLNK,
                uketoriKouza.getKzmeiginmkn(),
                pUiBeanParam,
                pKCParm);

            pUiBeanParam.setBankcd(uketoriKouza.getBankcd());
            pUiBeanParam.setSitencd(uketoriKouza.getSitencd());
            pUiBeanParam.setYokinkbn(uketoriKouza.getYokinkbn());
            pUiBeanParam.setKzdoukbn(C_Kzdou.DOUITU);
        }

        logger.debug("△ 口座情報入力チェック 終了");

        return true;
    }

    public String getGinkouName() {
        return this.ginkouName;
    }

    public String getShitenName() {
        return this.shitenName;
    }

    private void checkKouza(String pBankcd, String pSitencd, C_YokinKbn pYokinkbn, String pKouzano, C_Kzdou pKzdoukbn,
        String pKzmeiginmkn, CheckKouzaChkSoukinsakiKouzaUiBeanParam pUiBeanParam, KhozenCommonParam pKCParm) {

        if (BizUtil.isBlank(pBankcd)) {
            throw new BizLogicException(MessageId.EBC0043, "銀行コード");
        }

        if (BizUtil.isBlank(pSitencd)) {
            throw new BizLogicException(MessageId.EBC0043, "支店コード");
        }

        C_Tuukasyu shrtuukasyu = pUiBeanParam.getShrtuukasyu();
        KhCheckBankMaster khCheckBankMaster = SWAKInjector.getInstance(KhCheckBankMaster.class);
        int errNaiyou = khCheckBankMaster.checkBankMaster(shrtuukasyu, pBankcd, pSitencd);

        if (errNaiyou == KhCheckBankMaster.BANK_SONZAI_ERR) {
            throw new BizLogicException(MessageId.EBC1007);
        }

        if (errNaiyou == KhCheckBankMaster.BANK_YUUKOU_HANTEI_ERR) {
            throw new BizLogicException(MessageId.EBC1008);
        }

        if (errNaiyou == KhCheckBankMaster.BANK_YTGINKOU_SOUKIN_ERR) {
            throw new BizLogicException(MessageId.EBC1009);
        }

        if (errNaiyou == KhCheckBankMaster.GAIKAKOUZA_SOUKIN_ERR) {
            throw new BizLogicException(MessageId.EBC1010);
        }

        this.ginkouName = khCheckBankMaster.getGinkouName();
        this.shitenName = khCheckBankMaster.getShitenName();

        C_YokinKbn yokinKbn = pYokinkbn;
        if (C_YokinKbn.BLNK.eq(yokinKbn) && C_Tuukasyu.JPY.eq(shrtuukasyu)) {
            throw new BizLogicException(MessageId.EBC0043, "預金種目");
        }
        else if (IGkCommonKoumoku.BANKCD_YTGINKOU.equals(pBankcd) && !C_YokinKbn.HUTUU.eq(yokinKbn)) {
            throw new BizLogicException(MessageId.EBC1011, yokinKbn.getContent());

        }

        String kouzaNo = pKouzano;
        if (BizUtil.isBlank(kouzaNo)) {
            throw new BizLogicException(MessageId.EBC0043, "口座番号");
        } else if (kouzaNo.length() < 7 && C_Tuukasyu.JPY.eq(shrtuukasyu)) {
            kouzaNo = Strings.padStart(kouzaNo, 7, '0');
        }

        CheckKouzaNo checkKouzaNo = SWAKInjector.getInstance(CheckKouzaNo.class);

        if (!checkKouzaNo.isCheckOK(kouzaNo, shrtuukasyu)) {
            throw new BizLogicException(MessageId.EBC0046, "口座番号");
        }

        if (!checkKouzaNo.isKyoyouKeta(kouzaNo, shrtuukasyu)) {
            throw new BizLogicException(MessageId.EBC1012, "口座番号");
        }

        String kzmeigiNmKn = pKzmeiginmkn;
        if (BizUtil.isBlank(kzmeigiNmKn)) {
            if (!C_Kzdou.DOUITU.eq(pKzdoukbn)) {
                throw new BizLogicException(MessageId.EBC0045, "口座名義人");
            }
            else if (C_Kzdou.DOUITU.eq(pKzdoukbn) && C_Tuukasyu.JPY.eq(shrtuukasyu)) {
                String kykNmKn = pUiBeanParam.getKyknmkn();
                if (BizUtil.isBlank(kykNmKn)) {
                    IT_KykSya kykSya = pKCParm.getKeiyakusya(pUiBeanParam.getSyono());
                    kykNmKn = kykSya.getKyknmkn();
                }
                kzmeigiNmKn = kykNmKn;
            }
        }
        else {
            if (C_Kzdou.DOUITU.eq(pKzdoukbn)) {
                throw new BizLogicException(MessageId.EBC0046, "口座名義人");
            }
        }

        if (!CheckMeigininNmKana.isCheckOK_Tuuka(kzmeigiNmKn, shrtuukasyu)) {
            throw new BizLogicException(MessageId.EBC0046, "口座名義人");
        }

        if (!CheckKana.isKyoyouKetaHankaku_Kouza(kzmeigiNmKn)) {
            throw new BizLogicException(MessageId.EBC1012, "口座名義人");
        }

        pUiBeanParam.setKzmeiginmkn(kzmeigiNmKn);
        pUiBeanParam.setKouzano(kouzaNo);
    }
}
