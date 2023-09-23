package yuyu.common.hozen.khcommon;

import java.util.List;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.configuration.CoreConfig;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.CHolidayAdjustingMode;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.base.format.FixedDateFormatter;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.direct.dscommon.GenkyouTuutiKariPasswordHakkou;
import yuyu.common.direct.dscommon.GenkyouTuutiyouKariPasswordBean;
import yuyu.common.hozen.haitou.CheckDShrDShr;
import yuyu.common.hozen.haitou.DBAccessDCommon;
import yuyu.def.MessageId;
import yuyu.def.classification.C_DsKrPswdGnkTtStrkHnCdKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_KktyuitaKbn;
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TargetTkKbn;
import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YennykntksyuruiKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KhTtdkTyuui;
import yuyu.def.db.entity.IT_KhTumitateDKanri;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.db.entity.IT_TrkKzk;
import yuyu.def.db.entity.ZT_GaikaKokyakuTuutiTy;
import yuyu.def.hozen.configuration.YuyuHozenConfig;

import com.google.common.collect.Lists;

/**
 * 契約保全 契約保全共通 契約内容のお知らせ編集（共通項目）
 */
public class EditKykNaiyouOsiraseKytKm {

    private static final String HASSOUKBN_TYOKUSOU = "1";

    private static final String HASSOUKBN_HONSYAKAISOU = "2";

    private static final String UKTMIDASIKBN_NONE = "01";

    private static final String UKTMIDASIKBN_SBUKT = "02";

    private static final String UKTMIDASIKBN_NKUKT = "03";

    private static final String UKTMIDASIKBN_STDR = "04";

    private static final String UKTMIDASIKBN_SBKHUUKT = "05";

    private static final String UKTMIDASIKBN_KKYDR = "06";

    private static final String UKTRJNKBN_HKN = "02";

    private static final String UKTRJNKBN_HKNKYK = "03";

    private static final String UKTRJNKBN_SOUZOKU = "04";

    private static final String UKTRJNKBN_HKNSYO = "05";

    private static final String UKTRJNKBN_ZENKAKU_MINUS = "06";

    private static final String UKTRJNKBN_TOKUTEIMEIGI = "07";

    private static final String HUKA_TK_04001 = "04001";

    private static final String HUKA_TK_04002 = "04002";

    private static final String HUKA_TK_04004 = "04004";

    private static final String HUKA_TK_04005 = "04005";

    private static final String HUKA_TK_04006 = "04006";

    private static final String HUKA_TK_04007 = "04007";

    private static final String HUKA_TK_04008 = "04008";

    private static final String HUKA_TK_04009 = "04009";

    private static final String HUKA_TK_04010 = "04010";

    private static final String HUKA_TK_04011 = "04011";

    private static final String HUKA_TK_04012 = "04012";

    private static final String SD1MSGCD_07003 = "07003";

    private static final String DSTOUROKUJYOU_TOUROKUNASI = "0";

    private static final String DSTOUROKUJYOU_TOUROKU_KAIYAKUARI = "1";

    private static final String DSTOUROKUJYOU_TOUROKU_KAIYAKUNASI = "2";

    private static final String DSTOUROKUJYOU_MOS_KAIYAKUARI = "3";

    private static final String DSTOUROKUJYOU_MOS_KAIYAKUNASI = "4";

    private static final String DSKAIYKTIRASIDOUHUUKBN_NASI = "0";

    private static final String DSKAIYKTIRASIDOUHUUKBN_ARI = "1";

    private static final String KZKTRKJK_TOUROKUNASI = "0";

    private static final String KZKTRKJK_TOUROKUZUMI = "1";

    private static final String ASSISTPLUSTIRASIDHKBN_NASI = "0";

    private static final String ASSISTPLUSTIRASIDHKBN_ARI = "1";

    private static final String BLANK = "";

    private C_ErrorKbn commonErrorKbn = C_ErrorKbn.OK;

    private C_ErrorKbn bizLogicErrorKbn = C_ErrorKbn.OK;

    private String bizLogicErrorMsg = "";

    public EditKykNaiyouOsiraseKytKm() {
        super();
    }

    C_ErrorKbn getCommonErrorKbn() {
        return commonErrorKbn;
    }

    C_ErrorKbn getBizLogicErrorKbn() {
        return bizLogicErrorKbn;
    }

    public String getBizLogicErrorMsg() {
        return bizLogicErrorMsg;
    }

    public ZT_GaikaKokyakuTuutiTy editDsTourokuJyou(
        String pSyono,
        BizDate pSyoriYmd,
        ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTy) {
        String dsTourokuJyou = BLANK;
        GenkyouTuutiKariPasswordHakkou genkyouTuutiKariPasswordHakkou =
            SWAKInjector.getInstance(GenkyouTuutiKariPasswordHakkou.class);
        GenkyouTuutiyouKariPasswordBean genkyouTuutiyouKariPasswordBean =
            genkyouTuutiKariPasswordHakkou.exec(pSyono, pSyoriYmd);
        C_ErrorKbn dsErrorKbn = genkyouTuutiyouKariPasswordBean.getErrorkbn();

        if (!C_ErrorKbn.OK.eq(dsErrorKbn)) {
            String errorMsg;
            if (CoreConfig.getInstance().isBatchProduct()) {
                errorMsg = "ダイレクトサービス．現況通知用仮パスワード発行　　対象証券番号：" + pSyono;
            }
            else {
                errorMsg = "ダイレクトサービス状況取得が実行できませんでした。";
            }
            throw new CommonBizAppException(errorMsg);
        }

        if (C_UmuKbn.ARI.eq(genkyouTuutiyouKariPasswordBean.getDsKanyuuUmu())) {
            if (C_DsKrPswdGnkTtStrkHnCdKbn.SAIHAKKOUSEIKYUUZUMI.eq(genkyouTuutiyouKariPasswordBean.getDsKrPswdGnkTtStrkHnCdKbn()) ||
                C_DsKrPswdGnkTtStrkHnCdKbn.KRPASSWORDMIHAKKOU.eq(genkyouTuutiyouKariPasswordBean.getDsKrPswdGnkTtStrkHnCdKbn()) ||
                C_DsKrPswdGnkTtStrkHnCdKbn.BLNK.eq(genkyouTuutiyouKariPasswordBean.getDsKrPswdGnkTtStrkHnCdKbn()) ||
                C_DsKrPswdGnkTtStrkHnCdKbn.ZANZONKIKANSUKUNAI.eq(genkyouTuutiyouKariPasswordBean.getDsKrPswdGnkTtStrkHnCdKbn())) {

                if (C_UmuKbn.ARI.eq(genkyouTuutiyouKariPasswordBean.getDsKaiykServiceTourokuUmu())) {
                    dsTourokuJyou = DSTOUROKUJYOU_MOS_KAIYAKUARI;
                }
                else {
                    dsTourokuJyou = DSTOUROKUJYOU_MOS_KAIYAKUNASI;
                }

            }
            else {
                if (C_UmuKbn.ARI.eq(genkyouTuutiyouKariPasswordBean.getDsKaiykServiceTourokuUmu())) {
                    dsTourokuJyou = DSTOUROKUJYOU_TOUROKU_KAIYAKUARI;
                }
                else {
                    dsTourokuJyou = DSTOUROKUJYOU_TOUROKU_KAIYAKUNASI;
                }
            }
        }
        else {
            dsTourokuJyou = DSTOUROKUJYOU_TOUROKUNASI;
        }

        pGaikaKokyakuTuutiTy.setZtydstourokujyou(dsTourokuJyou);
        pGaikaKokyakuTuutiTy.setZtysd1msgcd(SD1MSGCD_07003);
        pGaikaKokyakuTuutiTy.setZtysd2msgcd(BLANK);
        pGaikaKokyakuTuutiTy.setZtysd3msgcd(BLANK);
        pGaikaKokyakuTuutiTy.setZtykrpassword(BLANK);
        pGaikaKokyakuTuutiTy.setZtyyuukoukigenwareki(BLANK);

        return pGaikaKokyakuTuutiTy;
    }

    public ZT_GaikaKokyakuTuutiTy editInfo(
        IT_KykKihon pKykKihon,
        BizDate pSyoriYmd,
        BizDate pKykoutoubi,
        String pSyouhnHanmeiKbn,
        ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTy,
        int pYobidasimotoKbn) {

        String dsKaiykTirasiDouhuuKbn = BLANK;
        String kyknm = BLANK;
        String hhknnm = BLANK;
        String syoukaiSakiDrtennm1 = BLANK;
        String syoukaiSakiDrtennm2 = BLANK;
        String hassoukbn = BLANK;
        List<String> uktMidasiKbnLst = Lists.newArrayList();
        List<String> uktKbnLst = Lists.newArrayList();
        List<String> uktNmLst = Lists.newArrayList();
        List<String> hukaTkLst = Lists.newArrayList();
        boolean kykdrFlg = false;
        boolean hhkndrFlg = false;
        boolean kzktrkjkFlg = false;

        IT_KykSyouhn kykSyouhn = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);
        IT_KykSonotaTkyk kykSonotaTkyk = pKykKihon.getKykSonotaTkyk();
        IT_KykSya kykSya = pKykKihon.getKykSya();
        IT_HhknSya hhknSya = pKykKihon.getHhknSya();
        BM_SyouhnZokusei syouhnZokusei = kykSyouhn.getSyouhnZokusei();

        String syono = pKykKihon.getSyono();
        BizDate kykymd = kykSyouhn.getKykymd();
        String sclatoSyono = syono.substring(3, 11) + syono.substring(0, 3);

        String tmtthaitoukinzndkyenStr = BLANK;

        if (EditKykNaiyouOsirase.SYOUHNHANMEIKBN_SYUUSIN_GAIKA.equals(pSyouhnHanmeiKbn) ||
            EditKykNaiyouOsirase.SYOUHNHANMEIKBN_SYUUSIN_ENKA.equals(pSyouhnHanmeiKbn) ||
            EditKykNaiyouOsirase.SYOUHNHANMEIKBN_NENKIN_ENKA.equals(pSyouhnHanmeiKbn) ||
            EditKykNaiyouOsirase.SYOUHNHANMEIKBN_SYUUSIN_GAIKA_KAITEI.equals(pSyouhnHanmeiKbn) ||
            EditKykNaiyouOsirase.SYOUHNHANMEIKBN_SYUUSIN_ENKA_19.equals(pSyouhnHanmeiKbn) ||
            EditKykNaiyouOsirase.SYOUHNHANMEIKBN_NENKIN_SISUU3MONTHMAE.equals(pSyouhnHanmeiKbn) ||
            EditKykNaiyouOsirase.SYOUHNHANMEIKBN_NENKIN_SISUU.equals(pSyouhnHanmeiKbn) ||
            EditKykNaiyouOsirase.SYOUHNHANMEIKBN_NENKIN_TEIRITUITEN.equals(pSyouhnHanmeiKbn) ||
            EditKykNaiyouOsirase.SYOUHNHANMEIKBN_NENKIN_TEIRITU.equals(pSyouhnHanmeiKbn)) {

            CheckDShrDShr checkDShrDShr = SWAKInjector.getInstance(CheckDShrDShr.class);
            C_ErrorKbn errorKbn = checkDShrDShr.checkDShr(syono, pSyoriYmd, null, C_YouhiKbn.HUYOU, pSyoriYmd);
            BizCurrency tmtthaitoukinzndkyen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
            if (C_ErrorKbn.OK.eq(errorKbn)) {

                if (C_SyorikahiKbn.SYORIHUKA.eq(checkDShrDShr.getSyorikahiKbn())) {

                    if (CoreConfig.getInstance().isBatchProduct()) {
                        commonErrorKbn = C_ErrorKbn.ERROR;
                        return pGaikaKokyakuTuutiTy;
                    }

                    if (C_UmuKbn.ARI.eq(checkDShrDShr.getDHuseigouUmu())) {
                        if (pYobidasimotoKbn == EditKykNaiyouOsirase.YOBIDASIMOTOKBN_SEIHOWEB) {

                            bizLogicErrorKbn = C_ErrorKbn.ERROR;

                            bizLogicErrorMsg = MessageUtil.getMessage(MessageId.EBS1012);

                            return null;
                        }

                        throw new BizLogicException(MessageId.EBS1012);
                    }

                    if (C_UmuKbn.ARI.eq(checkDShrDShr.getMihaneiDUmu())) {

                        if (pYobidasimotoKbn == EditKykNaiyouOsirase.YOBIDASIMOTOKBN_SEIHOWEB) {

                            bizLogicErrorKbn = C_ErrorKbn.ERROR;

                            bizLogicErrorMsg = MessageUtil.getMessage(MessageId.EBA1048);

                            return null;
                        }

                        throw new BizLogicException(MessageId.EBA1048);
                    }
                }
                DBAccessDCommon dBAccessDCommon = SWAKInjector.getInstance(DBAccessDCommon.class);
                dBAccessDCommon.getSaisinTumitateDKanri(syono);
                IT_KhTumitateDKanri khTumitateDKanri = dBAccessDCommon.getKhTumitateDKanri();
                if (khTumitateDKanri != null) {
                    tmtthaitoukinzndkyen = khTumitateDKanri.getTumitated();
                }
            }
            else {
                if (CoreConfig.getInstance().isBatchProduct()) {
                    commonErrorKbn = C_ErrorKbn.ERROR;
                    return pGaikaKokyakuTuutiTy;
                }

                throw new CommonBizAppException("配当支払チェックが実行できませんでした。");
            }

            tmtthaitoukinzndkyenStr = tmtthaitoukinzndkyen.toString();
        }

        IT_KhTtdkTyuui khTtdkTyuui = pKykKihon.getKhTtdkTyuui();

        if (khTtdkTyuui != null) {
            if (C_KktyuitaKbn.DNGNMEMOARI.eq(khTtdkTyuui.getKktyuitakbn())) {
                hassoukbn = HASSOUKBN_HONSYAKAISOU;
            }
            else {
                hassoukbn = HASSOUKBN_TYOKUSOU;
            }
        }
        else {
            hassoukbn = HASSOUKBN_TYOKUSOU;
        }

        if (C_KjkhukaKbn.KJKHUKA.eq(kykSya.getKyknmkjkhukakbn())) {
            kyknm = kykSya.getKyknmkn();
        }
        else {
            kyknm = kykSya.getKyknmkj();
        }
        if (C_KjkhukaKbn.KJKHUKA.eq(hhknSya.getHhknnmkjkhukakbn())) {
            hhknnm = hhknSya.getHhknnmkn();
        }
        else {
            hhknnm = hhknSya.getHhknnmkj();
        }

        List<IT_KykDairiten> kykDairitenLst = pKykKihon.getKykDairitens();
        if (kykDairitenLst.size() > 0) {

            BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);

            List<BzGetAgInfoBean> bzGetAgInfoBeanList = bzGetAgInfo.exec(
                kykDairitenLst.get(0).getDrtencd());

            BzGetAgInfoBean bzGetAgInfoBean = bzGetAgInfoBeanList.get(2);

            syoukaiSakiDrtennm1 = bzGetAgInfoBean.getKanjiHoujinSyougou();

            String oyadrtenCd1 = bzGetAgInfoBean.getOyadrtenCd();

            if (kykDairitenLst.size() > 1) {

                bzGetAgInfoBeanList = bzGetAgInfo.exec(
                    kykDairitenLst.get(1).getDrtencd());

                bzGetAgInfoBean = bzGetAgInfoBeanList.get(2);

                if (!oyadrtenCd1.equals(bzGetAgInfoBean.getOyadrtenCd())) {
                    syoukaiSakiDrtennm2 = bzGetAgInfoBean.getKanjiHoujinSyougou();
                }
            }
        }

        C_UmuKbn nkuktumu = syouhnZokusei.getNkuktumu();

        List<IT_KykUkt> kykUktSbuktLst = pKykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        if (pKykKihon.getSbuktnin() > 2) {
            if (C_UmuKbn.ARI.eq(nkuktumu)) {
                uktMidasiKbnLst.add(UKTMIDASIKBN_SBKHUUKT);
            }
            else {
                uktMidasiKbnLst.add(UKTMIDASIKBN_SBUKT);
            }

            uktKbnLst.add(UKTRJNKBN_HKNSYO);
            uktNmLst.add(BLANK);
        }
        else if (pKykKihon.getSbuktnin() == 2) {
            for (int i = 0; i < 2; i++) {
                if (i == 0) {
                    if (C_UktKbn.TOKUTEIMEIGI.eq(kykUktSbuktLst.get(i).getUktkbn())) {

                        if (C_UmuKbn.ARI.eq(nkuktumu)) {
                            uktMidasiKbnLst.add(UKTMIDASIKBN_SBKHUUKT);
                        }
                        else {
                            uktMidasiKbnLst.add(UKTMIDASIKBN_SBUKT);
                        }
                        uktKbnLst.add(UKTRJNKBN_TOKUTEIMEIGI);

                        if (C_KjkhukaKbn.KJKHUKA.eq(kykUktSbuktLst.get(i).getUktnmkjkhukakbn())) {
                            uktNmLst.add(kykUktSbuktLst.get(i).getUktnmkn());
                        }
                        else {
                            uktNmLst.add(kykUktSbuktLst.get(i).getUktnmkj());
                        }
                    }
                }
                else {
                    if (C_UktKbn.TOKUTEIMEIGI.eq(kykUktSbuktLst.get(i).getUktkbn())) {

                        uktMidasiKbnLst.add(UKTMIDASIKBN_NONE);
                        uktKbnLst.add(UKTRJNKBN_TOKUTEIMEIGI);
                        if (C_KjkhukaKbn.KJKHUKA.eq(kykUktSbuktLst.get(i).getUktnmkjkhukakbn())) {
                            uktNmLst.add(kykUktSbuktLst.get(i).getUktnmkn());
                        }
                        else {
                            uktNmLst.add(kykUktSbuktLst.get(i).getUktnmkj());
                        }
                    }
                }
            }
        }
        else {
            if (!kykUktSbuktLst.isEmpty()) {

                if (C_UmuKbn.ARI.eq(nkuktumu)) {
                    uktMidasiKbnLst.add(UKTMIDASIKBN_SBKHUUKT);
                }
                else {
                    uktMidasiKbnLst.add(UKTMIDASIKBN_SBUKT);
                }

                if (C_UktKbn.KYK.eq(kykUktSbuktLst.get(0).getUktkbn())) {
                    uktKbnLst.add(UKTRJNKBN_HKNKYK);
                }
                else if (C_UktKbn.HHKN.eq(kykUktSbuktLst.get(0).getUktkbn())) {
                    uktKbnLst.add(UKTRJNKBN_HKN);
                }
                else if (C_UktKbn.SOUZOKUNIN.eq(kykUktSbuktLst.get(0).getUktkbn())) {
                    uktKbnLst.add(UKTRJNKBN_SOUZOKU);
                }
                else if (C_UktKbn.TOKUTEIMEIGI.eq(kykUktSbuktLst.get(0).getUktkbn())) {
                    uktKbnLst.add(UKTRJNKBN_TOKUTEIMEIGI);
                }

                if (C_UktKbn.TOKUTEIMEIGI.eq(kykUktSbuktLst.get(0).getUktkbn())) {
                    if (C_KjkhukaKbn.KJKHUKA.eq(kykUktSbuktLst.get(0).getUktnmkjkhukakbn())) {
                        uktNmLst.add(kykUktSbuktLst.get(0).getUktnmkn());
                    }
                    else {
                        uktNmLst.add(kykUktSbuktLst.get(0).getUktnmkj());
                    }
                }
                else {
                    uktNmLst.add(BLANK);
                }
            }
        }

        if (C_UmuKbn.ARI.eq(nkuktumu)) {
            List<IT_KykUkt> kykUkNkuktLst = pKykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.NKUKT);

            uktMidasiKbnLst.add(UKTMIDASIKBN_NKUKT);

            if (C_UktKbn.HHKN.eq(kykUkNkuktLst.get(0).getUktkbn())) {
                uktKbnLst.add(UKTRJNKBN_HKN);
            }
            else if (C_UktKbn.KYK.eq(kykUkNkuktLst.get(0).getUktkbn())) {
                uktKbnLst.add(UKTRJNKBN_HKNKYK);
            }

            uktNmLst.add(BLANK);
        }

        List<IT_KykUkt> kykUkKykdrsktLst = pKykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.KYKDRN);

        if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getKykdrtkykhukaumu())) {

            uktMidasiKbnLst.add(UKTMIDASIKBN_KKYDR);
            kykdrFlg = true;
            IT_KykUkt kykUkt = kykUkKykdrsktLst.get(0);

            if (C_UktKbn.TOUROKUKAZOKU1.eq(kykUkt.getUktkbn())) {
                IT_TrkKzk trkKzk1 = pKykKihon.getTrkKzkByTrkKzkKbn(C_TrkKzkKbn.TRKKZK1);
                uktKbnLst.add(UKTRJNKBN_TOKUTEIMEIGI);
                if (C_KjkhukaKbn.KJKHUKA.eq(trkKzk1.getTrkkzknmkjkhukakbn())) {
                    uktNmLst.add(trkKzk1.getTrkkzknmkn());
                }
                else {
                    uktNmLst.add(trkKzk1.getTrkkzknmkj());
                }
            }
            else if (C_UktKbn.TOUROKUKAZOKU2.eq(kykUkt.getUktkbn())) {
                IT_TrkKzk trkKzk2 = pKykKihon.getTrkKzkByTrkKzkKbn(C_TrkKzkKbn.TRKKZK2);
                uktKbnLst.add(UKTRJNKBN_TOKUTEIMEIGI);
                if (C_KjkhukaKbn.KJKHUKA.eq(trkKzk2.getTrkkzknmkjkhukakbn())) {
                    uktNmLst.add(trkKzk2.getTrkkzknmkn());
                }
                else {
                    uktNmLst.add(trkKzk2.getTrkkzknmkj());
                }
            }
            else if (C_UktKbn.TOKUTEIMEIGI.eq(kykUkt.getUktkbn())) {
                uktKbnLst.add(UKTRJNKBN_TOKUTEIMEIGI);
                if (C_KjkhukaKbn.KJKHUKA.eq(kykUkt.getUktnmkjkhukakbn())) {
                    uktNmLst.add(kykUkt.getUktnmkn());
                }
                else {
                    uktNmLst.add(kykUkt.getUktnmkj());
                }
            }
        }
        else {
            uktMidasiKbnLst.add(UKTMIDASIKBN_KKYDR);
            uktKbnLst.add(UKTRJNKBN_ZENKAKU_MINUS);
            uktNmLst.add(BLANK);
        }

        List<IT_KykUkt> kykUkStdrsktLst = pKykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.STDRSK);

        if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getStdrsktkyhkumu())) {

            uktMidasiKbnLst.add(UKTMIDASIKBN_STDR);
            hhkndrFlg = true;
            IT_KykUkt kykUkt = kykUkStdrsktLst.get(0);

            if (C_UktKbn.KYK.eq(kykUkt.getUktkbn())) {
                uktKbnLst.add(UKTRJNKBN_TOKUTEIMEIGI);
                if (C_KjkhukaKbn.KJKHUKA.eq(kykSya.getKyknmkjkhukakbn())) {
                    uktNmLst.add(kykSya.getKyknmkn());
                }
                else {
                    uktNmLst.add(kykSya.getKyknmkj());
                }
            }
            else if (C_UktKbn.TOKUTEIMEIGI.eq(kykUkt.getUktkbn())) {
                uktKbnLst.add(UKTRJNKBN_TOKUTEIMEIGI);
                if (C_KjkhukaKbn.KJKHUKA.eq(kykUkt.getUktnmkjkhukakbn())) {
                    uktNmLst.add(kykUkt.getUktnmkn());
                }
                else {
                    uktNmLst.add(kykUkt.getUktnmkj());
                }
            }
            else if (C_UktKbn.SBUK.eq(kykUkt.getUktkbn())) {
                uktKbnLst.add(UKTRJNKBN_TOKUTEIMEIGI);

                if (C_KjkhukaKbn.KJKHUKA.eq(kykUktSbuktLst.get(0).getUktnmkjkhukakbn())) {
                    uktNmLst.add(kykUktSbuktLst.get(0).getUktnmkn());
                }
                else {
                    uktNmLst.add(kykUktSbuktLst.get(0).getUktnmkj());
                }
            }
            else if (C_UktKbn.TOUROKUKAZOKU1.eq(kykUkt.getUktkbn())) {
                IT_TrkKzk trkKzk1 = pKykKihon.getTrkKzkByTrkKzkKbn(C_TrkKzkKbn.TRKKZK1);
                uktKbnLst.add(UKTRJNKBN_TOKUTEIMEIGI);
                if (C_KjkhukaKbn.KJKHUKA.eq(trkKzk1.getTrkkzknmkjkhukakbn())) {
                    uktNmLst.add(trkKzk1.getTrkkzknmkn());
                }
                else {
                    uktNmLst.add(trkKzk1.getTrkkzknmkj());
                }
            }
            else if (C_UktKbn.TOUROKUKAZOKU2.eq(kykUkt.getUktkbn())) {
                IT_TrkKzk trkKzk2 = pKykKihon.getTrkKzkByTrkKzkKbn(C_TrkKzkKbn.TRKKZK2);
                uktKbnLst.add(UKTRJNKBN_TOKUTEIMEIGI);
                if (C_KjkhukaKbn.KJKHUKA.eq(trkKzk2.getTrkkzknmkjkhukakbn())) {
                    uktNmLst.add(trkKzk2.getTrkkzknmkn());
                }
                else {
                    uktNmLst.add(trkKzk2.getTrkkzknmkj());
                }
            }
            else if (C_UktKbn.NASI.eq(kykUkt.getUktkbn())) {
                uktKbnLst.add(UKTRJNKBN_ZENKAKU_MINUS);
                uktNmLst.add(BLANK);
            }
        }
        else {
            uktMidasiKbnLst.add(UKTMIDASIKBN_STDR);
            uktKbnLst.add(UKTRJNKBN_ZENKAKU_MINUS);
            uktNmLst.add(BLANK);
        }

        while (uktMidasiKbnLst.size() < 5) {
            uktMidasiKbnLst.add(BLANK);
            uktKbnLst.add(BLANK);
            uktNmLst.add(BLANK);
        }

        if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getYennykntkhkumu())) {

            if (C_YennykntksyuruiKbn.PYENHRKM_GKSITEI.eq(kykSonotaTkyk.getYennyknsyuruikbn())) {
                hukaTkLst.add(HUKA_TK_04009);
            }
            else if (C_YennykntksyuruiKbn.PYENHRKM.eq(kykSonotaTkyk.getYennyknsyuruikbn())) {
                if (EditKykNaiyouOsirase.SYOUHNHANMEIKBN_SYUUSIN_GAIKA_KAITEI.equals(pSyouhnHanmeiKbn)) {
                    hukaTkLst.add(HUKA_TK_04012);
                }
                else {
                    if (BizDateUtil.compareYmd(pSyoriYmd, BizDate.valueOf("20200401")) == BizDateUtil.COMPARE_LESSER) {
                        hukaTkLst.add(HUKA_TK_04001);
                    }
                    else {
                        hukaTkLst.add(HUKA_TK_04012);
                    }
                }
            }
        }

        if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getGaikanykntkhkumu())) {
            hukaTkLst.add(HUKA_TK_04002);
        }
        if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getTargettkhkumu())) {

            if (C_TargetTkKbn.SYUUSIN.eq(kykSonotaTkyk.getTargettkkbn())) {
                hukaTkLst.add(HUKA_TK_04004);
            }
            else if (C_TargetTkKbn.NENKIN.eq(kykSonotaTkyk.getTargettkkbn())) {
                hukaTkLst.add(HUKA_TK_04008);
            }
        }

        if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getInitsbjiyensitihsytkhukaumu())) {
            hukaTkLst.add(HUKA_TK_04005);
        }
        if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getJyudkaigomeharaitkhukaumu())) {
            hukaTkLst.add(HUKA_TK_04006);
        }
        if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getKykdrtkykhukaumu())) {
            hukaTkLst.add(HUKA_TK_04011);
        }
        if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getStdrsktkyhkumu())) {
            hukaTkLst.add(HUKA_TK_04007);
        }
        if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getZeiseitkkktkykhukaumu())) {
            hukaTkLst.add(HUKA_TK_04010);
        }

        while (hukaTkLst.size() < 10) {
            hukaTkLst.add(BLANK);
        }

        BizDate keisanYmd = null;

        if (BizDateUtil.compareYmd(YuyuHozenConfig.getInstance().getDsKaiyakuServiceStartYmd(), kykymd) == BizDateUtil.COMPARE_LESSER) {

            keisanYmd = kykymd;
        }
        else {
            keisanYmd = YuyuHozenConfig.getInstance().getDsKaiyakuServiceStartYmd();
        }

        if (BizDateUtil.compareYmd(pSyoriYmd, keisanYmd.addYears(1).getBusinessDay(CHolidayAdjustingMode.NEXT)) == BizDateUtil.COMPARE_EQUAL
            || BizDateUtil.compareYmd(pSyoriYmd, keisanYmd.addYears(1).getBusinessDay(CHolidayAdjustingMode.NEXT)) == BizDateUtil.COMPARE_LESSER) {
            dsKaiykTirasiDouhuuKbn = DSKAIYKTIRASIDOUHUUKBN_ARI;
        }
        else {
            dsKaiykTirasiDouhuuKbn = DSKAIYKTIRASIDOUHUUKBN_NASI;
        }

        String kzktrkjk = BLANK;
        String[] trkKzkNm = new String[]{BLANK, BLANK};

        if (C_UmuKbn.ARI.eq(syouhnZokusei.getKzktourokuserviceumu())) {
            List<IT_TrkKzk> trkKzkList = pKykKihon.getTrkKzks();

            if (trkKzkList.size() > 0) {
                kzktrkjk = KZKTRKJK_TOUROKUZUMI;
                kzktrkjkFlg = true;
            }
            else {
                kzktrkjk = KZKTRKJK_TOUROKUNASI;
            }

            if (KZKTRKJK_TOUROKUZUMI.equals(kzktrkjk)) {
                for (int index = 0; index < trkKzkList.size(); index++) {
                    IT_TrkKzk trkKzk = trkKzkList.get(index);

                    if (C_KjkhukaKbn.KJKHUKA.eq(trkKzk.getTrkkzknmkjkhukakbn())) {
                        trkKzkNm[index] = trkKzk.getTrkkzknmkn();
                    }
                    else {
                        trkKzkNm[index] = trkKzk.getTrkkzknmkj();
                    }
                }
            }
        }

        String assistplustirasidhkbn = ASSISTPLUSTIRASIDHKBN_NASI;
        if (!kykdrFlg || !hhkndrFlg || !kzktrkjkFlg) {
            assistplustirasidhkbn = ASSISTPLUSTIRASIDHKBN_ARI;
        }

        pGaikaKokyakuTuutiTy.setZtyuktmidasikbn1(uktMidasiKbnLst.get(0));
        pGaikaKokyakuTuutiTy.setZtyuktkbn1(uktKbnLst.get(0));
        pGaikaKokyakuTuutiTy.setZtyuktnm118(uktNmLst.get(0));
        pGaikaKokyakuTuutiTy.setZtyuktmidasikbn2(uktMidasiKbnLst.get(1));
        pGaikaKokyakuTuutiTy.setZtyuktkbn2(uktKbnLst.get(1));
        pGaikaKokyakuTuutiTy.setZtyuktnm218(uktNmLst.get(1));
        pGaikaKokyakuTuutiTy.setZtyuktmidasikbn3(uktMidasiKbnLst.get(2));
        pGaikaKokyakuTuutiTy.setZtyuktkbn3(uktKbnLst.get(2));
        pGaikaKokyakuTuutiTy.setZtyuktnm318(uktNmLst.get(2));
        pGaikaKokyakuTuutiTy.setZtyuktmidasikbn4(uktMidasiKbnLst.get(3));
        pGaikaKokyakuTuutiTy.setZtyuktkbn4(uktKbnLst.get(3));
        pGaikaKokyakuTuutiTy.setZtyuktnm418(uktNmLst.get(3));
        pGaikaKokyakuTuutiTy.setZtyuktmidasikbn5(uktMidasiKbnLst.get(4));
        pGaikaKokyakuTuutiTy.setZtyuktkbn5(uktKbnLst.get(4));
        pGaikaKokyakuTuutiTy.setZtyuktnm518(uktNmLst.get(4));
        pGaikaKokyakuTuutiTy.setZtykzktrkjk(kzktrkjk);
        pGaikaKokyakuTuutiTy.setZtytrkkzknm118(trkKzkNm[0]);
        pGaikaKokyakuTuutiTy.setZtytrkkzknm218(trkKzkNm[1]);
        pGaikaKokyakuTuutiTy.setZtytyouhyouymd(pSyoriYmd.toString());
        pGaikaKokyakuTuutiTy.setZtysyono(syono);
        pGaikaKokyakuTuutiTy.setZtysclatosyono(sclatoSyono);
        pGaikaKokyakuTuutiTy.setZtyhassoukbn(hassoukbn);
        pGaikaKokyakuTuutiTy.setZtydskaiyktirasidouhuukbn(dsKaiykTirasiDouhuuKbn);
        pGaikaKokyakuTuutiTy.setZtykoktuutireportlayoutptn(pSyouhnHanmeiKbn);
        pGaikaKokyakuTuutiTy.setZtytuusinsakiyuubinno(kykSya.getTsinyno());
        pGaikaKokyakuTuutiTy.setZtytsinadr1kj(kykSya.getTsinadr1kj());
        pGaikaKokyakuTuutiTy.setZtytsinadr2kj(kykSya.getTsinadr2kj());
        pGaikaKokyakuTuutiTy.setZtytsinadr3kj(kykSya.getTsinadr3kj());
        pGaikaKokyakuTuutiTy.setZtytsintelno(kykSya.getTsintelno());
        pGaikaKokyakuTuutiTy.setZtytsinnm18(kyknm);
        pGaikaKokyakuTuutiTy.setZtysyoukaisakidrtennm1(syoukaiSakiDrtennm1);
        pGaikaKokyakuTuutiTy.setZtysyoukaisakidrtennm2(syoukaiSakiDrtennm2);
        pGaikaKokyakuTuutiTy.setZtysyono2(syono);
        pGaikaKokyakuTuutiTy.setZtyaisyoumeikbn(pKykKihon.getAisyoumeikbn().getValue());
        pGaikaKokyakuTuutiTy.setZtykyknmkj18(kyknm);
        pGaikaKokyakuTuutiTy.setZtyhhknnmkj18(hhknnm);
        pGaikaKokyakuTuutiTy.setZtykykymdwa(FixedDateFormatter.formatYMDZenkakuSeirekiKanji(kykymd));
        pGaikaKokyakuTuutiTy.setZtykyktuukasyuzn(kykSyouhn.getKyktuukasyu().getContent());
        pGaikaKokyakuTuutiTy.setZtykyktuukatype(kykSyouhn.getKyktuukasyu().getValue());
        pGaikaKokyakuTuutiTy.setZtytk1msgcd(hukaTkLst.get(0));
        pGaikaKokyakuTuutiTy.setZtytk2msgcd(hukaTkLst.get(1));
        pGaikaKokyakuTuutiTy.setZtytk3msgcd(hukaTkLst.get(2));
        pGaikaKokyakuTuutiTy.setZtytk4msgcd(hukaTkLst.get(3));
        pGaikaKokyakuTuutiTy.setZtytk5msgcd(hukaTkLst.get(4));
        pGaikaKokyakuTuutiTy.setZtytk6msgcd(hukaTkLst.get(5));
        pGaikaKokyakuTuutiTy.setZtytk7msgcd(hukaTkLst.get(6));
        pGaikaKokyakuTuutiTy.setZtytk8msgcd(hukaTkLst.get(7));
        pGaikaKokyakuTuutiTy.setZtytk9msgcd(hukaTkLst.get(8));
        pGaikaKokyakuTuutiTy.setZtytk10msgcd(hukaTkLst.get(9));
        pGaikaKokyakuTuutiTy.setZtysakuseikijyunymdwa(
            FixedDateFormatter.formatYMDZenkakuSeirekiKanji(pKykoutoubi));
        pGaikaKokyakuTuutiTy.setZtytmtthaitoukinzndkyen(tmtthaitoukinzndkyenStr);
        pGaikaKokyakuTuutiTy.setZtyassistplustirasidhkbn(assistplustirasidhkbn);

        return pGaikaKokyakuTuutiTy;
    }

}
