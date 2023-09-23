package yuyu.common.hozen.khcommon;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import jp.co.slcs.swak.core.configuration.CoreConfig;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateFormat;
import jp.co.slcs.swak.date.BizDateFormat.FillStyle;
import jp.co.slcs.swak.date.BizDateSpan;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.string.ConvertUtil;
import yuyu.common.base.format.FixedDateFormatter;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.SetNenrei;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.siharai.sicommon.CalcHkShrKngk;
import yuyu.common.siharai.sicommon.CalcHkShrKngkBean;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_Nenkinsyu;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.ZT_GaikaKokyakuTuutiTy;

/**
 * 契約保全 契約保全共通 契約内容のお知らせ編集５（年金円貨）
 */
public class EditKykNaiyouOsirase5 {

    private static final String AISATUMSGCD_03005 = "03005";

    private static final String OSIRASEMSGCD_08007 = "08007";

    private static final String OSIRASEMSGCD_08008 = "08008";

    private static final String NEN = "年";

    private static final String BLANK = "";

    private static final int JYOUSUU_MAN = 10000;

    private static final String ERROR_MSG = "金額チェックエラーです。システム管理者にお問い合わせください。";

    private C_ErrorKbn commonErrorKbn = C_ErrorKbn.OK;

    public EditKykNaiyouOsirase5() {
        super();
    }

    C_ErrorKbn getCommonErrorKbn() {
        return commonErrorKbn;
    }

    public ZT_GaikaKokyakuTuutiTy editInfo(
        IT_KykKihon pKykKihon,
        BizDate pSyoriYmd,
        BizDate pKykoutoubi,
        ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTyn) {

        String osiraseMsgcd1  = BLANK;
        IT_KykSyouhn kykSyouhn = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);

        String syono = pKykKihon.getSyono();
        BizDate yendtHnkYmd = kykSyouhn.getYendthnkymd();

        SetNenrei setNenrei = SWAKInjector.getInstance(SetNenrei.class);
        int nkNenrei =
            setNenrei.getNkshrStartNenrei(
                kykSyouhn.getHhknnen(),
                kykSyouhn.getHknkkn());

        String nksyukbn;

        if (C_Nenkinsyu.KAKUTEINENKIN.eq(kykSyouhn.getNksyukbn())) {

            nksyukbn =
                ConvertUtil.toZenNumeric(kykSyouhn.getNenkinkkn().toString()) + NEN + kykSyouhn.getNksyukbn().getContent();
        }
        else {
            nksyukbn = kykSyouhn.getNksyukbn().getContent();
        }

        CalcHkShrKngk calcHkShrKngk = SWAKInjector.getInstance(CalcHkShrKngk.class);
        C_ErrorKbn errorKbn = calcHkShrKngk.execByKeisanWExt(
            syono,
            pKykoutoubi,
            C_SiinKbn.SP,
            C_HokenkinsyuruiKbn.SBKYUUHUKIN,
            pKykKihon.getSdpdkbn(),
            pKykKihon.getHrkkeiro());

        if (!C_ErrorKbn.OK.eq(errorKbn)) {
            if (CoreConfig.getInstance().isBatchProduct()) {
                commonErrorKbn = C_ErrorKbn.ERROR;
                return pGaikaKokyakuTuutiTyn;
            }

            throw new CommonBizAppException(ERROR_MSG);
        }

        CalcHkShrKngkBean calcHkShrKngkBean = calcHkShrKngk.getCalcHkShrKngkBean();

        BizCurrency tmttkngkkukYen = calcHkShrKngkBean.getTmttKnGk();

        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.BLNK;

        List<IT_KhTtdkRireki> ttdkRirekiYendthnkList =
            pKykKihon.getKhTtdkRirekisByGyoumuKousinKinou(
                IKhozenCommonConstants.KINOUID_KHMKHGKTTTYENDTHNK);

        if (ttdkRirekiYendthnkList.size() > 0) {
            yendthnkSyoriKbn = ttdkRirekiYendthnkList.get(ttdkRirekiYendthnkList.size() - 1).getSyorikbn();
        }

        if (C_SyoriKbn.YENDTHNK_MKHGKTTT.eq(yendthnkSyoriKbn)) {
            osiraseMsgcd1 = OSIRASEMSGCD_08007;
        }
        else if (C_SyoriKbn.YENDTHNK_NINISEIKYUU.eq(yendthnkSyoriKbn)) {
            osiraseMsgcd1 = OSIRASEMSGCD_08008;
        }

        pGaikaKokyakuTuutiTyn.setZtysyoruicd(C_SyoruiCdKbn.KK_GAIKA_KOKYAKUTUUTI.getValue().toUpperCase());
        pGaikaKokyakuTuutiTyn.setZtyaisatumsgcd1(AISATUMSGCD_03005);
        pGaikaKokyakuTuutiTyn.setZtyosirasetuutisakuseiymwa(
            FixedDateFormatter.formatYMZenkakuSeirekiKanji(pKykoutoubi));
        pGaikaKokyakuTuutiTyn.setZtyyendthnkymd(FixedDateFormatter.formatYMDZenkakuSeirekiKanji(yendtHnkYmd));
        pGaikaKokyakuTuutiTyn.setZtynkshrstartymdstr(
            FixedDateFormatter.formatYMDZenkakuSeirekiKanji(kykSyouhn.getHknkknmanryouymd()));
        pGaikaKokyakuTuutiTyn.setZtynenkinstartnen(String.valueOf(nkNenrei));
        pGaikaKokyakuTuutiTyn.setZtynksyuruinm(nksyukbn);
        pGaikaKokyakuTuutiTyn.setZtyosirasemsgcd1(osiraseMsgcd1);
        pGaikaKokyakuTuutiTyn.setZtykijyunkingaku(kykSyouhn.getKihons().toString());
        pGaikaKokyakuTuutiTyn.setZtytumitatekngkkyen(tmttkngkkukYen.toString());

        pGaikaKokyakuTuutiTyn.setZtytumitateriritustr(String.valueOf(kykSyouhn.getTumitateriritu().multiply(JYOUSUU_MAN)));

        BizDateFormat format = new BizDateFormat("yyyy年MM月dd日", FillStyle.Blank);

        BizDate ptmttSuiiYmd = kykSyouhn.getHknkknmanryouymd().getPreviousDay();

        BizDateSpan ksKikan = BizDateUtil.calcDifference(ptmttSuiiYmd, pKykoutoubi);

        int listSize = 0;

        if (BizDateUtil.compareYmd(pKykoutoubi, ptmttSuiiYmd) == BizDateUtil.COMPARE_LESSER ||
            BizDateUtil.compareYmd(pKykoutoubi, ptmttSuiiYmd) == BizDateUtil.COMPARE_EQUAL) {
            if (ksKikan.getYears() > 0) {
                if (ptmttSuiiYmd.getBizDateMD().compareTo(yendtHnkYmd.getBizDateMD()) > 0) {
                    if (ksKikan.getMonths() == 0 && ksKikan.getDays() == 0) {
                        listSize = ksKikan.getYears();
                    }
                    else {
                        listSize = ksKikan.getYears() + 1;
                    }
                }
                else {
                    BizDate keiyakuoutoubiTmp = BizDate.valueOf(pKykoutoubi.getYear(), yendtHnkYmd.getBizDateMD()).getRekijyou();
                    if (BizDateUtil.compareYmd(pKykoutoubi, keiyakuoutoubiTmp) == BizDateUtil.COMPARE_LESSER ) {
                        listSize = ksKikan.getYears();
                    }
                    else {
                        if (ksKikan.getMonths() == 0 && ksKikan.getDays() == 0) {
                            listSize = ksKikan.getYears();
                        }
                        else {
                            listSize = ksKikan.getYears() + 1;
                        }
                    }
                }
            }
            else if (ksKikan.getMonths() > 0 || ksKikan.getDays() > 0 ||
                BizDateUtil.compareYmd(pKykoutoubi, ptmttSuiiYmd) == BizDateUtil.COMPARE_EQUAL) {
                listSize = 1;
            }
        }

        int maxCount = 9;
        int loopCount = 0;

        if (listSize <= maxCount) {
            loopCount = listSize;
        }
        else {
            loopCount = maxCount;
        }

        KeisanSisuuRendouNkTmttknYendtHnk keisanSisuuRendouNkTmttknYendtHnk = SWAKInjector
            .getInstance(KeisanSisuuRendouNkTmttknYendtHnk.class);

        for (int index = 1; index <= loopCount; index++) {

            BizDate keiyakuoutoubi = null;
            BizDateYM keiyakuoutouYm = null;
            BizDateYM yendthnkYm = null;

            if (index == loopCount) {
                keiyakuoutoubi = ptmttSuiiYmd;
            }
            else {
                keiyakuoutoubi = BizDate.valueOf(
                    pKykoutoubi.getYear() + index,
                    yendtHnkYmd.getBizDateMD()).getRekijyou();
            }

            KeisanWKijunYM keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);

            keiyakuoutouYm = keisanWKijunYM.exec(
                kykSyouhn.getKykymd(),
                keiyakuoutoubi,
                null,
                pKykKihon.getHrkkaisuu(),
                kykSyouhn.getKykjyoutai(),
                kykSyouhn.getSyouhncd(),
                yendtHnkYmd);

            yendthnkYm = keisanWKijunYM.exec(
                kykSyouhn.getKykymd(),
                yendtHnkYmd,
                null,
                pKykKihon.getHrkkaisuu(),
                kykSyouhn.getKykjyoutai(),
                kykSyouhn.getSyouhncd(),
                null);

            keisanSisuuRendouNkTmttknYendtHnk.exec(
                keiyakuoutoubi,
                keiyakuoutouYm,
                yendtHnkYmd,
                yendthnkYm,
                kykSyouhn.getKykymd(),
                kykSyouhn.getHknkkn(),
                kykSyouhn.getKihons(),
                kykSyouhn.getTumitateriritu());

            BizCurrency ptumitatekngkyen = keisanSisuuRendouNkTmttknYendtHnk.getTumitategk();

            try {
                methodNmEditAndExec(
                    ZT_GaikaKokyakuTuutiTy.class,
                    pGaikaKokyakuTuutiTyn,
                    "setZtykeiyakuoutoubix",
                    index, format.format(keiyakuoutoubi));

                methodNmEditAndExec(
                    ZT_GaikaKokyakuTuutiTy.class,
                    pGaikaKokyakuTuutiTyn,
                    "setZtyptumitatekngkyenx",
                    index, ptumitatekngkyen.toString());

            } catch (IllegalAccessException
                | NoSuchMethodException
                | InvocationTargetException e) {
                throw new CommonBizAppException();
            }
        }

        return pGaikaKokyakuTuutiTyn;
    }

    private void methodNmEditAndExec (
        Class<ZT_GaikaKokyakuTuutiTy> pClass,
        ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTy,
        String pMethodNm,
        int pMethodNo,
        Object pValue) throws
        IllegalAccessException,
        NoSuchMethodException,
        InvocationTargetException {

        Method setMethod =
            pClass.getMethod(pMethodNm +
                String.valueOf(pMethodNo), pValue.getClass());
        setMethod.invoke(pGaikaKokyakuTuutiTy, pValue);
    }
}
