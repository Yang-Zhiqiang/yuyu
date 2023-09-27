package yuyu.common.direct.dscommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateFormat;
import jp.co.slcs.swak.date.BizDateFormat.FillStyle;

import org.slf4j.Logger;

import com.google.common.base.Strings;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.CheckKana;
import yuyu.common.biz.bzcommon.CheckKouzaNo;
import yuyu.common.biz.bzcommon.CheckMeigininNmKana;
import yuyu.common.biz.bzcommon.IGkCommonKoumoku;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.khcommon.KhCheckBankMaster;
import yuyu.def.classification.C_ChkkekkaKbn;
import yuyu.def.classification.C_DsZokuseinochkkekkaKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_SoukinyoukzchkkekkaKbn;
import yuyu.def.classification.C_SoukinyoukzinputchkkekkaKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_DsTrhkserviceRiyoujkKbn;
import yuyu.def.db.entity.MT_DsKokyakuKeiyaku;
import yuyu.def.db.entity.MT_DsTorihikiServiceKanri;
import yuyu.def.direct.manager.DirectDomManager;

/**
 * ダイレクトサービス ダイレクトサービス共通 ＤＳ取引サービス共通チェック
 */
public class CheckDsTorihikiService {

    @Inject
    private DirectDomManager directDomManager;

    private static final String ANSYONOPATTERN = "^\\d{4}$";

    private static final String TELNOPATTERN = "^\\d{10,11}$";

    private static final int ZENKETADOUTIINNSUU = 1111;

    @Inject
    private static Logger logger;

    public CheckDsTorihikiService() {
        super();
    }

    public CheckZokuseinoResultBean checkZokuseiNo(String pAnsyoNo, BizDate pSeiYmd, String pTelNo) {

        logger.debug("▽ 属性番号チェック 開始");

        boolean checkResult = pAnsyoNo.matches(ANSYONOPATTERN);

        if (!checkResult) {
            throw new CommonBizAppException("暗証番号の数字・桁数が不正です。");
        }

        if (pSeiYmd == null) {
            throw new CommonBizAppException("生年月日にnullが設定されています。");
        }

        String telNo = pTelNo.replace("-", "");

        checkResult = telNo.matches(TELNOPATTERN);

        if (!checkResult) {
            throw new CommonBizAppException("電話番号の数字・桁数が不正です。");
        }

        String seirekiNen = String.valueOf(pSeiYmd.getYear());
        String seirekiNen2keta = seirekiNen.substring(2);
        String warekiNen = new BizDateFormat("Gyy", FillStyle.Zero).format(pSeiYmd).toString().substring(1, 3);
        String month = Strings.padStart(String.valueOf(pSeiYmd.getMonth()), 2, '0');
        String day = Strings.padStart(String.valueOf(pSeiYmd.getDay()), 2, '0');
        String monthDay = month.substring(1).concat(day.substring(1));

        List<String> patternList = new ArrayList<>();
        CheckZokuseinoResultBean checkZokuseinoResultBean = SWAKInjector.getInstance(CheckZokuseinoResultBean.class);

        patternList.add(warekiNen.concat(month));
        patternList.add(warekiNen.concat(day));
        patternList.add(month.concat(warekiNen));
        patternList.add(day.concat(warekiNen));
        patternList.add(seirekiNen);
        patternList.add(seirekiNen2keta.concat(monthDay));
        patternList.add(seirekiNen2keta.concat(month));
        patternList.add(seirekiNen2keta.concat(day));
        patternList.add(month.concat(day));
        patternList.add(day.concat(month));

        for (String pattern : patternList) {
            if (pAnsyoNo.equals(pattern)) {
                checkZokuseinoResultBean.setChkkekkaKbn(C_ChkkekkaKbn.ERROR);
                checkZokuseinoResultBean.setDsZokuseinochkkekkaKbn(C_DsZokuseinochkkekkaKbn.SEIYMD);

                logger.debug("△ 属性番号チェック 終了");
                return checkZokuseinoResultBean;
            }
        }

        String checkTelNo = telNo.substring(telNo.length() - 4);

        if (pAnsyoNo.equals(checkTelNo)) {
            checkZokuseinoResultBean.setChkkekkaKbn(C_ChkkekkaKbn.ERROR);
            checkZokuseinoResultBean.setDsZokuseinochkkekkaKbn(C_DsZokuseinochkkekkaKbn.TELNO);

            logger.debug("△ 属性番号チェック 終了");
            return checkZokuseinoResultBean;
        }

        int checkZenketaDoutiKekka = Integer.parseInt(pAnsyoNo) % ZENKETADOUTIINNSUU;

        if (checkZenketaDoutiKekka == 0) {
            checkZokuseinoResultBean.setChkkekkaKbn(C_ChkkekkaKbn.ERROR);
            checkZokuseinoResultBean.setDsZokuseinochkkekkaKbn(C_DsZokuseinochkkekkaKbn.ZENKETADOUTI);

            logger.debug("△ 属性番号チェック 終了");
            return checkZokuseinoResultBean;
        }

        checkZokuseinoResultBean.setChkkekkaKbn(C_ChkkekkaKbn.SEIJYOU);
        checkZokuseinoResultBean.setDsZokuseinochkkekkaKbn(C_DsZokuseinochkkekkaKbn.BLNK);

        logger.debug("△ 属性番号チェック 終了");
        return checkZokuseinoResultBean;

    }

    public CheckSoukinyoukzResultBean checkSoukinyoukz(C_Tuukasyu pShrtuukasyu, String pBankCd, String pSitenCd,
        String pKzmeiginmKn, C_Kzdou pKzdouKbn, String pKyknmKn) {

        logger.debug("▽ 送金用口座正当性チェック 開始");

        CheckSoukinyoukzResultBean checkSoukinyoukzResultBean =
            SWAKInjector.getInstance(CheckSoukinyoukzResultBean.class);
        KhCheckBankMaster khCheckBankMaster = SWAKInjector.getInstance(KhCheckBankMaster.class);

        int bankMasterChkResult = khCheckBankMaster.checkBankMaster(pShrtuukasyu, pBankCd, pSitenCd);

        if (bankMasterChkResult == KhCheckBankMaster.BANK_SONZAI_ERR) {
            checkSoukinyoukzResultBean.setChkkekkaKbn(C_ChkkekkaKbn.ERROR);
            checkSoukinyoukzResultBean.setSoukinyoukzchkkekkaKbn(C_SoukinyoukzchkkekkaKbn.GINKOUMASTERSONZAI);

            logger.debug("△ 送金用口座正当性チェック 終了");
            return checkSoukinyoukzResultBean;
        }
        else if (bankMasterChkResult == KhCheckBankMaster.BANK_YUUKOU_HANTEI_ERR) {
            checkSoukinyoukzResultBean.setChkkekkaKbn(C_ChkkekkaKbn.ERROR);
            checkSoukinyoukzResultBean.setSoukinyoukzchkkekkaKbn(C_SoukinyoukzchkkekkaKbn.GINKOUYUUKOUHANTEI);

            logger.debug("△ 送金用口座正当性チェック 終了");
            return checkSoukinyoukzResultBean;
        }
        else if (bankMasterChkResult == KhCheckBankMaster.BANK_YTGINKOU_SOUKIN_ERR) {
            checkSoukinyoukzResultBean.setChkkekkaKbn(C_ChkkekkaKbn.ERROR);
            checkSoukinyoukzResultBean.setSoukinyoukzchkkekkaKbn(C_SoukinyoukzchkkekkaKbn.YUUTYOGINKOUSOUKINKAHI);

            logger.debug("△ 送金用口座正当性チェック 終了");
            return checkSoukinyoukzResultBean;
        }
        else if (bankMasterChkResult == KhCheckBankMaster.GAIKAKOUZA_SOUKIN_ERR) {
            checkSoukinyoukzResultBean.setChkkekkaKbn(C_ChkkekkaKbn.ERROR);
            checkSoukinyoukzResultBean.setSoukinyoukzchkkekkaKbn(C_SoukinyoukzchkkekkaKbn.GAIKAKOUZASOUKINKAHI);

            logger.debug("△ 送金用口座正当性チェック 終了");
            return checkSoukinyoukzResultBean;
        }
        else if (bankMasterChkResult != KhCheckBankMaster.SYORI_OK) {

            throw new CommonBizAppException("銀行マスタチェック結果が想定外の値です。");

        }

        if (C_Kzdou.DOUITU.eq(pKzdouKbn) && !pKzmeiginmKn.equals(pKyknmKn)) {
            checkSoukinyoukzResultBean.setChkkekkaKbn(C_ChkkekkaKbn.ERROR);
            checkSoukinyoukzResultBean.setSoukinyoukzchkkekkaKbn(C_SoukinyoukzchkkekkaKbn.KOUZAMEIGININ);

            logger.debug("△ 送金用口座正当性チェック 終了");
            return checkSoukinyoukzResultBean;
        }

        checkSoukinyoukzResultBean.setChkkekkaKbn(C_ChkkekkaKbn.SEIJYOU);
        checkSoukinyoukzResultBean.setSoukinyoukzchkkekkaKbn(C_SoukinyoukzchkkekkaKbn.BLNK);

        logger.debug("△ 送金用口座正当性チェック 終了");
        return checkSoukinyoukzResultBean;
    }

    public CheckSoukinyoukzinputResultBean checkSoukinyoukzInput(C_Tuukasyu pShrtuukasyu, String pBankCd,
        C_YokinKbn pYokinKbn, String pKouzaNo, String pKzmeiginmKn, C_Kzdou pKzdouKbn, String pKyknmKn) {

        logger.debug("▽ 送金用口座入力チェック 開始");

        CheckSoukinyoukzinputResultBean checkSoukinyoukzinputResultBean =
            SWAKInjector.getInstance(CheckSoukinyoukzinputResultBean.class);
        if (C_Tuukasyu.JPY.eq(pShrtuukasyu) &&
            C_YokinKbn.BLNK.eq(pYokinKbn)) {
            checkSoukinyoukzinputResultBean.setChkkekkaKbn(C_ChkkekkaKbn.ERROR);
            checkSoukinyoukzinputResultBean.setSoukinyoukzinputchkkekkaKbn(
                C_SoukinyoukzinputchkkekkaKbn.YOKINMINYUURYOKU);

            logger.debug("△ 送金用口座入力チェック 終了");
            return checkSoukinyoukzinputResultBean;
        }

        if (IGkCommonKoumoku.BANKCD_YTGINKOU.equals(pBankCd) &&
            !C_YokinKbn.HUTUU.eq(pYokinKbn)) {
            checkSoukinyoukzinputResultBean.setChkkekkaKbn(C_ChkkekkaKbn.ERROR);
            checkSoukinyoukzinputResultBean.setSoukinyoukzinputchkkekkaKbn(
                C_SoukinyoukzinputchkkekkaKbn.YUTYOGINKOUDATOUSEI);

            logger.debug("△ 送金用口座入力チェック 終了");
            return checkSoukinyoukzinputResultBean;
        }

        if (BizUtil.isBlank(pKouzaNo)) {
            checkSoukinyoukzinputResultBean.setChkkekkaKbn(C_ChkkekkaKbn.ERROR);
            checkSoukinyoukzinputResultBean.setSoukinyoukzinputchkkekkaKbn(
                C_SoukinyoukzinputchkkekkaKbn.BANGOUMINYUURYOKU);

            logger.debug("△ 送金用口座入力チェック 終了");
            return checkSoukinyoukzinputResultBean;
        }

        CheckKouzaNo checkKouzaNo = SWAKInjector.getInstance(CheckKouzaNo.class);
        boolean kouzanoKyokaMojiChkResult = checkKouzaNo.isCheckOK(pKouzaNo, pShrtuukasyu);

        if (!kouzanoKyokaMojiChkResult) {
            checkSoukinyoukzinputResultBean.setChkkekkaKbn(C_ChkkekkaKbn.ERROR);
            checkSoukinyoukzinputResultBean.setSoukinyoukzinputchkkekkaKbn(
                C_SoukinyoukzinputchkkekkaKbn.BANGOUKYOKAMOJI);

            logger.debug("△ 送金用口座入力チェック 終了");
            return checkSoukinyoukzinputResultBean;
        }

        boolean kouzanoKetasuuChkResult = checkKouzaNo.isKyoyouKeta(pKouzaNo, pShrtuukasyu);

        if (!kouzanoKetasuuChkResult) {
            checkSoukinyoukzinputResultBean.setChkkekkaKbn(C_ChkkekkaKbn.ERROR);
            checkSoukinyoukzinputResultBean.setSoukinyoukzinputchkkekkaKbn(
                C_SoukinyoukzinputchkkekkaKbn.BANGOUKETASUU);

            logger.debug("△ 送金用口座入力チェック 終了");
            return checkSoukinyoukzinputResultBean;
        }

        if (BizUtil.isBlank(pKzmeiginmKn)) {
            checkSoukinyoukzinputResultBean.setChkkekkaKbn(C_ChkkekkaKbn.ERROR);
            checkSoukinyoukzinputResultBean.setSoukinyoukzinputchkkekkaKbn(
                C_SoukinyoukzinputchkkekkaKbn.MEIGININMINYUURYOKU);

            logger.debug("△ 送金用口座入力チェック 終了");
            return checkSoukinyoukzinputResultBean;
        }

        if (C_Kzdou.DOUITU.eq(pKzdouKbn)) {
            boolean kzmeigiKetaChkResult = CheckKana.isKyoyouKetaHankaku_Kouza(pKyknmKn);

            if (!kzmeigiKetaChkResult) {
                checkSoukinyoukzinputResultBean.setChkkekkaKbn(C_ChkkekkaKbn.ERROR);
                checkSoukinyoukzinputResultBean.setSoukinyoukzinputchkkekkaKbn(
                    C_SoukinyoukzinputchkkekkaKbn.MEIGININKETASUU);

                logger.debug("△ 送金用口座入力チェック 終了");
                return checkSoukinyoukzinputResultBean;
            }

            kzmeigiKetaChkResult = CheckMeigininNmKana.isCheckOK_Tuuka(pKyknmKn, pShrtuukasyu);

            if (!kzmeigiKetaChkResult) {
                checkSoukinyoukzinputResultBean.setChkkekkaKbn(C_ChkkekkaKbn.ERROR);
                checkSoukinyoukzinputResultBean.setSoukinyoukzinputchkkekkaKbn(
                    C_SoukinyoukzinputchkkekkaKbn.MEIGININKYOKAMOJI);

                logger.debug("△ 送金用口座入力チェック 終了");
                return checkSoukinyoukzinputResultBean;
            }
        }
        else {
            boolean kzmeigiKetaChkResult = CheckKana.isKyoyouKetaHankaku_Kouza(pKzmeiginmKn);

            if (!kzmeigiKetaChkResult) {
                checkSoukinyoukzinputResultBean.setChkkekkaKbn(C_ChkkekkaKbn.ERROR);
                checkSoukinyoukzinputResultBean.setSoukinyoukzinputchkkekkaKbn(
                    C_SoukinyoukzinputchkkekkaKbn.MEIGININKETASUU);

                logger.debug("△ 送金用口座入力チェック 終了");
                return checkSoukinyoukzinputResultBean;
            }

            kzmeigiKetaChkResult = CheckMeigininNmKana.isCheckOK_Tuuka(pKzmeiginmKn, pShrtuukasyu);

            if (!kzmeigiKetaChkResult) {
                checkSoukinyoukzinputResultBean.setChkkekkaKbn(C_ChkkekkaKbn.ERROR);
                checkSoukinyoukzinputResultBean.setSoukinyoukzinputchkkekkaKbn(
                    C_SoukinyoukzinputchkkekkaKbn.MEIGININKYOKAMOJI);

                logger.debug("△ 送金用口座入力チェック 終了");
                return checkSoukinyoukzinputResultBean;
            }
        }

        checkSoukinyoukzinputResultBean.setChkkekkaKbn(C_ChkkekkaKbn.SEIJYOU);
        checkSoukinyoukzinputResultBean.setSoukinyoukzinputchkkekkaKbn(C_SoukinyoukzinputchkkekkaKbn.BLNK);

        logger.debug("△ 送金用口座入力チェック 終了");
        return checkSoukinyoukzinputResultBean;
    }

    public GetTrhkServiceTourokuJyoukyouBean getTrhkServiceTourokuJyoukyou(String pSyono) {

        logger.debug("▽ 取引サービス登録状況取得 開始");

        GetTrhkServiceTourokuJyoukyouBean getTrhkServiceTourokuJyoukyouBean =
            SWAKInjector.getInstance(GetTrhkServiceTourokuJyoukyouBean.class);

        List<MT_DsKokyakuKeiyaku> dsKokyakuKeiyakuList = directDomManager
            .getDsKokyakuKeiyakusBySyonoDskykmukouhyjBlank(pSyono);

        if (dsKokyakuKeiyakuList.size() == 0) {

            getTrhkServiceTourokuJyoukyouBean.setErrorkbn(C_ErrorKbn.OK);
            getTrhkServiceTourokuJyoukyouBean.setDsKaiykServiceTourokuUmu(C_UmuKbn.NONE);

        } else if (dsKokyakuKeiyakuList.size() == 1) {

            MT_DsTorihikiServiceKanri dsTorihikiServiceKanri = dsKokyakuKeiyakuList.get(0).getDsTorihikiServiceKanri();

            getTrhkServiceTourokuJyoukyouBean.setErrorkbn(C_ErrorKbn.OK);

            if (dsTorihikiServiceKanri != null
                && C_DsTrhkserviceRiyoujkKbn.RIYOU_KA.eq(dsTorihikiServiceKanri.getDstrhkserviceriyoujkkbn())) {

                getTrhkServiceTourokuJyoukyouBean.setDsKaiykServiceTourokuUmu(C_UmuKbn.ARI);

            } else {

                getTrhkServiceTourokuJyoukyouBean.setDsKaiykServiceTourokuUmu(C_UmuKbn.NONE);

            }

        } else {

            getTrhkServiceTourokuJyoukyouBean.setErrorkbn(C_ErrorKbn.ERROR);
            getTrhkServiceTourokuJyoukyouBean.setDsKaiykServiceTourokuUmu(null);

        }

        logger.debug("△ 取引サービス登録状況取得 終了");
        return getTrhkServiceTourokuJyoukyouBean;

    }

}
