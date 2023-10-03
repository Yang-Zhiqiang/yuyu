package yuyu.batch.suuri.srsuuritoukei.srbikinkykhaitoujynbknsel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateMD;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBTransactionalUtil;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.GetYoteiriritu;
import yuyu.common.biz.bzcommon.GetYoteirirituBean;
import yuyu.common.biz.kaikei.BzSegmentCdSyutoku;
import yuyu.common.biz.kaikei.SyouhinbetuSegmentBean;
import yuyu.common.hozen.haitou.GetDRiritu;
import yuyu.common.hozen.haitou.KeisanDCommon;
import yuyu.common.hozen.haitou.KeisanDGanrikin;
import yuyu.common.hozen.khcommon.SetOutoubi;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.common.suuri.srcommon.SrCommonConstants;
import yuyu.common.suuri.srcommon.SrGetTokutejitenAnsyuKihonInfo;
import yuyu.common.suuri.srcommon.SrGetTokutejitenKykKihonInfo;
import yuyu.common.suuri.srcommon.SrGetTokutejitenKykKihonInfoBean;
import yuyu.common.suuri.srcommon.SrSuuriKbnHenkanBean;
import yuyu.common.suuri.srcommon.SrSuuriKbnHenkanSet;
import yuyu.common.suuri.suuricommon.SrGetTokutejitenSyohnInfo;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinBean;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinKijyunBean;
import yuyu.def.MessageId;
import yuyu.def.classification.C_BknJkuKbn;
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HaitoukinsksKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_KykKihonTokuteiJitenKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_SrKbnHenkanKbn;
import yuyu.def.classification.C_SuuriAnnaiFuyouRiyuuKbn;
import yuyu.def.classification.C_SuuriHaraikataKbn;
import yuyu.def.classification.C_TokutejitenSyoriKbn;
import yuyu.def.classification.C_TumitateDSakuseiKbn;
import yuyu.def.classification.C_TykzentykgoKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KhDshrTuki;
import yuyu.def.db.entity.IT_KhHaitouKanri;
import yuyu.def.db.entity.IT_KhTumitateDKanri;
import yuyu.def.db.entity.JT_SiDshrTuki;
import yuyu.def.db.entity.ST_BknkykHtjynbkn;
import yuyu.def.db.entity.ST_SuuriyouErrJyouhou;
import yuyu.def.db.entity.SV_BikinKykHaitouMeisai;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 数理 数理統計 備金契約配当準備金データ抽出バッチ項目編集クラス
 */
public class SrBikinKykHaitoujynbknSelBatchEdit {

    private static final String TUMITATERISOKU = "積立利息";

    private static final String KARIWARIATEDRISOKU = "仮割当Ｄ利息";

    private static final String SEISIKIWARIATENENDOHYJ_ARI = "（正式割当年度表示）有り";

    private static final String SEISIKIWARIATENENDOHYJ_NASI = "（正式割当年度表示）無し";

    private Boolean errorFlag;

    @Inject
    private BatchLogger batchLogger;

    public SrBikinKykHaitoujynbknSelBatchEdit() {

        errorFlag = false;
    }

    public boolean editKoumoku(
        SrBikinKykHaitoujynbknSelBatchParam pBatchParam,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenSyouhinInfo,
        SV_BikinKykHaitouMeisai pBikinKykHaitouMeisai,
        ST_BknkykHtjynbkn pBknkykHtjynbkn,
        int pSyohinHanteiKbn,
        List<SV_KiykSyuhnData> pKiykSyuhnDataList,
        JT_SiDshrTuki pSiDshrTuki,
        IT_KhDshrTuki pKhDshrTuki,
        List<IT_KhHaitouKanri> pKhHaitouKanriList,
        List<IT_KhTumitateDKanri> pKhTumitateDKanriList,
        BizCurrency pSeisanD,
        BizCurrency pKariwariateDGanrikin,
        BizCurrency pTumitateDGanrikin) {

        SrSuuriKbnHenkanSet srSuuriKbnHenkanSet = SWAKInjector.getInstance(SrSuuriKbnHenkanSet.class);

        String haraikomikaisuKbn = null;
        String hrkkeiroKbn = null;
        String annaihuyouRiyuuKbn = null;
        String syukeiyakusyuruiCd = null;
        String kyknendo = null;
        BizNumber daihyouyoteiriritu = null;
        String kbnkeiriyousegmentkbn = null;
        String kbnkeiriyourgnbnskkbn = null;

        SrGetTokutejitenAnsyuKihonInfo srGetTokutejitenAnsyuKihonInfo = SWAKInjector.getInstance(
            SrGetTokutejitenAnsyuKihonInfo.class);

        C_Hrkkeiro hrkkeiro = null;
        C_Hrkkaisuu hrkkaisuu = null;

        if (C_Kykjyoutai.ITIJIBARAI.eq(pTkJitenSyouhinInfo.getKykjyoutai())) {

            hrkkeiro = pBikinKykHaitouMeisai.getHrkkeiro();
        }
        else {

            BizDateYM jkipjytYm = null;

            if (C_BkncdKbn.KAIYAKU.eq(pBikinKykHaitouMeisai.getBkncdkbn())) {

                jkipjytYm = srGetTokutejitenAnsyuKihonInfo.exec(
                    pBikinKykHaitouMeisai.getSyono(),
                    null,
                    pBikinKykHaitouMeisai.getJkipjytym(),
                    pBikinKykHaitouMeisai.getHenkousikibetukey());
            }
            else if (C_BkncdKbn.SIBOUKAIJYO.eq(pBikinKykHaitouMeisai.getBkncdkbn())) {

                jkipjytYm = srGetTokutejitenAnsyuKihonInfo.exec(
                    pBikinKykHaitouMeisai.getSyono(),
                    BizDate.valueOf(pBikinKykHaitouMeisai.getGyoumuKousinTime().substring(0, 8)),
                    pBikinKykHaitouMeisai.getJkipjytym(),
                    null);
            }
            else if (C_BkncdKbn.PMINYUUSYOUMETU.eq(pBikinKykHaitouMeisai.getBkncdkbn())) {

                jkipjytYm = pBikinKykHaitouMeisai.getJkipjytym();
            }
            else {

                jkipjytYm = pBikinKykHaitouMeisai.getCalckijyunymd().getBizDateYM().addMonths(SrCommonConstants.KIKAN_1M);
            }

            BizDate heijyunKouryokukaisiYmd = null;

            if (C_BkncdKbn.KAIYAKU.eq(pBikinKykHaitouMeisai.getBkncdkbn()) ||
                C_BkncdKbn.SIBOUKAIJYO.eq(pBikinKykHaitouMeisai.getBkncdkbn())) {

                if (BizDateUtil.compareYm(pBikinKykHaitouMeisai.getCalckijyunymd().getBizDateYM(),
                    jkipjytYm) == BizDateUtil.COMPARE_LESSER  ) {

                    SetOutoubi setOutoubi = SWAKInjector.getInstance(SetOutoubi.class);

                    heijyunKouryokukaisiYmd = setOutoubi.exec(
                        C_TykzentykgoKbn.TYKGO,
                        pTkJitenSyouhinInfo.getKykymd(),
                        pBikinKykHaitouMeisai.getHrkkaisuu(),
                        pBikinKykHaitouMeisai.getCalckijyunymd());
                }
                else {

                    heijyunKouryokukaisiYmd =
                        BizDate.valueOf(jkipjytYm, pTkJitenSyouhinInfo.getKykymd().getDay()).getRekijyou();
                }
            }
            else {

                heijyunKouryokukaisiYmd = pBikinKykHaitouMeisai.getCalckijyunymd();
            }

            SrGetTokutejitenKykKihonInfo srGetTokutejitenKykKihonInfo =
                SWAKInjector.getInstance(SrGetTokutejitenKykKihonInfo.class);

            SrGetTokutejitenKykKihonInfoBean srGetTokutejitenKykKihonInfoBean =
                srGetTokutejitenKykKihonInfo.exec(
                    C_KykKihonTokuteiJitenKbn.HRIHN_KIJYUNBIJITEN,
                    pBikinKykHaitouMeisai.getSyono(),
                    heijyunKouryokukaisiYmd,
                    null,
                    pKiykSyuhnDataList,
                    pBikinKykHaitouMeisai.getTikiktbrisyuruikbn(),
                    pBikinKykHaitouMeisai.getHrkkeiro(),
                    pBikinKykHaitouMeisai.getHrkkaisuu());

            hrkkeiro = srGetTokutejitenKykKihonInfoBean.getHrkkeiroMae();
            hrkkaisuu = srGetTokutejitenKykKihonInfoBean.getHrkkaisuuMae();
        }

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.HRK_KEIRO, hrkkeiro.getValue());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002, C_SrKbnHenkanKbn.HRK_KEIRO.getContent(),
                pBikinKykHaitouMeisai.getSyono(), hrkkeiro.getValue());

            batchLogger.warn(msg);

            insertSuuriyouErrJyouhou(pBatchParam, pBikinKykHaitouMeisai.getSyono(), msg);
        }
        else {

            hrkkeiroKbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        if (C_Kykjyoutai.ITIJIBARAI.eq(pTkJitenSyouhinInfo.getKykjyoutai())) {

            hrkkaisuu = pBikinKykHaitouMeisai.getHrkkaisuu();
        }

        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.HRK_KAISUU, hrkkaisuu.getValue());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002, C_SrKbnHenkanKbn.HRK_KAISUU.getContent(),
                pBikinKykHaitouMeisai.getSyono(), hrkkaisuu.getValue());

            batchLogger.warn(msg);

            insertSuuriyouErrJyouhou(pBatchParam, pBikinKykHaitouMeisai.getSyono(), msg);
        }
        else {

            haraikomikaisuKbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        if (C_Kykjyoutai.ITIJIBARAI.eq(pTkJitenSyouhinInfo.getKykjyoutai())) {

            annaihuyouRiyuuKbn = C_SuuriAnnaiFuyouRiyuuKbn.ITIJI.getValue();
        }
        else {

            annaihuyouRiyuuKbn = C_SuuriAnnaiFuyouRiyuuKbn.ANNAITYUU.getValue();
        }

        String bikinKbn = C_BkncdKbn.BLNK.getValue();

        if (C_BkncdKbn.SIBOUUKETUKE.eq(pBikinKykHaitouMeisai.getBkncdkbn()) ||
            C_BkncdKbn.SIBOUKARIUKETUKE.eq(pBikinKykHaitouMeisai.getBkncdkbn()) ||
            C_BkncdKbn.KOUDOSYOUGAIUKETUKE.eq(pBikinKykHaitouMeisai.getBkncdkbn())) {

            bikinKbn = SrCommonConstants.BIKINKBN_SIBOU_KOUDOSG;
        }
        else if (C_BkncdKbn.KAIYAKU.eq(pBikinKykHaitouMeisai.getBkncdkbn()) ||
            C_BkncdKbn.MENSEKI.eq(pBikinKykHaitouMeisai.getBkncdkbn()) ||
            C_BkncdKbn.SIBOUKAIJYO.eq(pBikinKykHaitouMeisai.getBkncdkbn())) {

            bikinKbn = SrCommonConstants.BIKINKBN_KAIYAKU;

        }
        else if (C_BkncdKbn.PMINYUUSYOUMETU.eq(pBikinKykHaitouMeisai.getBkncdkbn())) {

            bikinKbn = SrCommonConstants.BIKINKBN_SIKKOU;
        }

        BzSegmentCdSyutoku bzSegmentCdSyutoku = SWAKInjector.getInstance(BzSegmentCdSyutoku.class);

        SyouhinbetuSegmentBean syouhinbetuSegmentBean = bzSegmentCdSyutoku.exec(pTkJitenSyouhinInfo.getSyouhncd(),
            pTkJitenSyouhinInfo.getKyktuukasyu());

        if (C_ErrorKbn.ERROR.eq(syouhinbetuSegmentBean.getErrorKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1007,
                SrCommonConstants.MSGHYOUJIMOJIRETU_SEGCD,
                pBikinKykHaitouMeisai.getSyono(),
                pTkJitenSyouhinInfo.getSyouhncd(),
                pTkJitenSyouhinInfo.getKyktuukasyu().getValue());

            batchLogger.warn(msg);

            insertSuuriyouErrJyouhou(pBatchParam, pBikinKykHaitouMeisai.getSyono(), msg);
        }
        else {

            kbnkeiriyousegmentkbn = syouhinbetuSegmentBean.getSegcd1().getValue().substring(0, 2);
            kbnkeiriyourgnbnskkbn = syouhinbetuSegmentBean.getSegcd1().getValue().substring(2, 4);
        }

        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(C_SrKbnHenkanKbn.SYOKEIYAKU,
            pTkJitenSyouhinInfo.getSyouhncd(), pTkJitenSyouhinInfo.getKyktuukasyu().getValue());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1006, C_SrKbnHenkanKbn.SYOKEIYAKU.getContent(),
                pBikinKykHaitouMeisai.getSyono(), pTkJitenSyouhinInfo.getSyouhncd(), pTkJitenSyouhinInfo.getKyktuukasyu().getValue());

            batchLogger.warn(msg);

            insertSuuriyouErrJyouhou(pBatchParam, pBikinKykHaitouMeisai.getSyono(), msg);
        }
        else {

            syukeiyakusyuruiCd = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        if (pTkJitenSyouhinInfo.getKykymd().getMonth() <= SrCommonConstants.MONTH_MARCH) {

            kyknendo = String.valueOf(pTkJitenSyouhinInfo.getKykymd().getYear() - SrCommonConstants.YEAR_1Y);
        }
        else {

            kyknendo = String.valueOf(pTkJitenSyouhinInfo.getKykymd().getYear());
        }

        if (pSyohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {

            GetYoteiriritu getYoteiriritu = SWAKInjector.getInstance(GetYoteiriritu.class);

            GetYoteirirituBean getYoteirirituBean = SWAKInjector.getInstance(GetYoteirirituBean.class);

            getYoteirirituBean.setSyouhncd(pTkJitenSyouhinInfo.getSyouhncd());
            getYoteirirituBean.setKijyunymd(pTkJitenSyouhinInfo.getKykymd());
            getYoteirirituBean.setSknnkaisiymd(pTkJitenSyouhinInfo.getKykymd());
            getYoteirirituBean.setKykymd(pTkJitenSyouhinInfo.getKykymd());
            getYoteirirituBean.setHknkkn(pTkJitenSyouhinInfo.getHknkkn());
            getYoteirirituBean.setHknkknsmnkbn(pTkJitenSyouhinInfo.getHknkknsmnKbn());
            getYoteirirituBean.setHhknnen(pTkJitenSyouhinInfo.getHhknnen());
            getYoteirirituBean.setSitihsyuriritu(pTkJitenSyouhinInfo.getYoteirrthendohosyurrt());
            getYoteirirituBean.setTuukasyu(pTkJitenSyouhinInfo.getKyktuukasyu());

            C_ErrorKbn kekkakbn = getYoteiriritu.exec(getYoteirirituBean);

            if (C_ErrorKbn.ERROR.eq(kekkakbn)) {

                String msg = MessageUtil.getMessage(MessageId.ESA1001, "代表予定利率", pBikinKykHaitouMeisai.getSyono());

                batchLogger.warn(msg);

                insertSuuriyouErrJyouhou(pBatchParam, pBikinKykHaitouMeisai.getSyono(), msg);

            }
            else {

                daihyouyoteiriritu =  getYoteiriritu.getYoteiriritu().multiply(SrCommonConstants.INT_VALUE_100);
            }
        }
        else if (pTkJitenSyouhinInfo.getYendthnkymd() != null) {

            if (pSyohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR) {

                daihyouyoteiriritu =  pTkJitenSyouhinInfo.getYoteiriritu().multiply(SrCommonConstants.INT_VALUE_100);
            }
            else {

                daihyouyoteiriritu = BizNumber.ZERO;
            }
        }
        else {

            daihyouyoteiriritu =  pTkJitenSyouhinInfo.getYoteiriritu().multiply(SrCommonConstants.INT_VALUE_100);
        }

        String haraikataKbn = null;

        if (C_Kykjyoutai.ITIJIBARAI.eq(pTkJitenSyouhinInfo.getKykjyoutai())) {

            haraikataKbn = C_SuuriHaraikataKbn.ITIJI.getValue();
        }
        else {

            if (C_Hrkkaisuu.TUKI.eq(hrkkaisuu)) {

                if (C_Hrkkeiro.HURIKAE.eq(hrkkeiro)) {

                    haraikataKbn = C_SuuriHaraikataKbn.TIZUKI.getValue();
                }
                else if (C_Hrkkeiro.KOUHURI.eq(hrkkeiro)) {

                    haraikataKbn = C_SuuriHaraikataKbn.BANKZUKI.getValue();
                }
                else if (C_Hrkkeiro.CREDIT.eq(hrkkeiro)) {

                    haraikataKbn = C_SuuriHaraikataKbn.CREDIT.getValue();
                }
            }

            else if (C_Hrkkaisuu.HALFY.eq(hrkkaisuu)) {

                haraikataKbn = C_SuuriHaraikataKbn.HALFY.getValue();
            }

            else if (C_Hrkkaisuu.NEN.eq(hrkkaisuu)) {

                haraikataKbn = C_SuuriHaraikataKbn.NEN.getValue();
            }
        }

        BizCurrency seisanD = null;
        BizCurrency kariwariateDGanrikin = null;
        BizCurrency tumitateDGanrikin = null;

        if (C_BkncdKbn.SIBOUKARIUKETUKE.eq(pBikinKykHaitouMeisai.getBkncdkbn())) {

            seisanD = pSeisanD;
            kariwariateDGanrikin = pKariwariateDGanrikin;
            tumitateDGanrikin = pTumitateDGanrikin;
        }
        else if (C_BkncdKbn.SIBOUUKETUKE.eq(pBikinKykHaitouMeisai.getBkncdkbn())) {

            if (pSiDshrTuki != null) {

                seisanD = pSiDshrTuki.getSiharaid();
                kariwariateDGanrikin = pSiDshrTuki.getHaitouganrikincalckari();
                tumitateDGanrikin = pSiDshrTuki.getHaitouganrikincalctumi();
            }
            else {

                seisanD = pSeisanD;
                kariwariateDGanrikin = pKariwariateDGanrikin;
                tumitateDGanrikin = pTumitateDGanrikin;
            }
        }
        else {

            if (pKhDshrTuki != null) {

                seisanD = pKhDshrTuki.getSiharaid();
                kariwariateDGanrikin = pKhDshrTuki.getHaitouganrikincalckari();
                tumitateDGanrikin = pKhDshrTuki.getHaitouganrikincalctumi();
            }
            else {

                seisanD = pSeisanD;
                kariwariateDGanrikin = pKariwariateDGanrikin;
                tumitateDGanrikin = pTumitateDGanrikin;
            }
        }

        BizCurrency tumitateRisoku = BizCurrency.valueOf(0);
        BizCurrency kariwariateDRisoku = BizCurrency.valueOf(0);
        BizDate zenjigyouNendoMatuymd = null;

        if (C_BknJkuKbn.SINBI.eq(pBikinKykHaitouMeisai.getBknjkukbn())) {

            if (pBatchParam.getKijyunymd().getMonth() <= SrCommonConstants.MONTH_MARCH) {

                zenjigyouNendoMatuymd = BizDate.valueOf(
                    String.valueOf(pBatchParam.getKijyunymd().getYear() - SrCommonConstants.YEAR_1Y)
                    + SrCommonConstants.FIXEDDAY_NENDOKSNBI);
            }
            else {

                zenjigyouNendoMatuymd = BizDate.valueOf(
                    String.valueOf(pBatchParam.getKijyunymd().getYear()) + SrCommonConstants.FIXEDDAY_NENDOKSNBI);
            }

            BizDate[] kariwariateDShrYmd = getKariwariatedshrymd(pKhHaitouKanriList, pKiykSyuhnDataList);

            if (tumitateDGanrikin.compareTo(BizCurrency.valueOf(
                SrCommonConstants.DEFAULT_INT_ZERO, tumitateDGanrikin.getType())) > 0) {

                BizCurrency zenjigyouNendoTumitateD = BizCurrency.valueOf(0);

                IT_KhTumitateDKanri khTumitateDKanriZennendo = null;
                IT_KhTumitateDKanri khTumitateDKanriTounendo = null;
                IT_KhTumitateDKanri khTumitateDKanri = null;

                for (IT_KhTumitateDKanri khTumitateDKanriLoop : pKhTumitateDKanriList) {

                    if (BizDateUtil.compareYmd(khTumitateDKanriLoop.getTumitatedtumitateymd(),
                        zenjigyouNendoMatuymd) == BizDateUtil.COMPARE_LESSER ||
                        BizDateUtil.compareYmd(khTumitateDKanriLoop.getTumitatedtumitateymd(),
                            zenjigyouNendoMatuymd) == BizDateUtil.COMPARE_EQUAL) {

                        khTumitateDKanriZennendo = khTumitateDKanriLoop;

                        break;
                    }
                }

                if (khTumitateDKanriZennendo == null) {
                    zenjigyouNendoTumitateD = BizCurrency.valueOf(0);
                }
                else {
                    if (khTumitateDKanriZennendo.getTumitated().compareTo(
                        BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO,
                            khTumitateDKanriZennendo.getTumitated().getType())) == 0) {
                        zenjigyouNendoTumitateD = BizCurrency.valueOf(0);
                    }
                    else {

                        if (BizDateUtil.compareYmd(pKhTumitateDKanriList.get(0).getTumitatedtumitateymd(),
                            zenjigyouNendoMatuymd)== BizDateUtil.COMPARE_LESSER ||
                            BizDateUtil.compareYmd(pKhTumitateDKanriList.get(0).getTumitatedtumitateymd(),
                                zenjigyouNendoMatuymd)== BizDateUtil.COMPARE_EQUAL) {

                            zenjigyouNendoTumitateD = keisanDGanrikin(
                                khTumitateDKanriZennendo.getTumitated(),
                                khTumitateDKanriZennendo.getTumitatedtumitateymd(),
                                zenjigyouNendoMatuymd,
                                TUMITATERISOKU,
                                pBikinKykHaitouMeisai.getSyono(),
                                pBatchParam);
                        }
                        else {

                            khTumitateDKanriTounendo = pKhTumitateDKanriList.get(0);

                            if (C_TumitateDSakuseiKbn.ITIBUHIKIDASI.eq(khTumitateDKanriTounendo.getTumitatedskskbn()) ||
                                C_TumitateDSakuseiKbn.RISOKUKURIIRE.eq(khTumitateDKanriTounendo.getTumitatedskskbn())) {

                                zenjigyouNendoTumitateD = keisanWarimodosigk(
                                    khTumitateDKanriTounendo.getTumitated(),
                                    zenjigyouNendoMatuymd,
                                    khTumitateDKanriTounendo.getTumitatedtumitateymd(),
                                    TUMITATERISOKU,
                                    pBikinKykHaitouMeisai.getSyono(),
                                    pBatchParam);
                            }
                            else if (C_TumitateDSakuseiKbn.ZENHIKIDASI.eq(khTumitateDKanriTounendo.getTumitatedskskbn())) {
                                zenjigyouNendoTumitateD = BizCurrency.valueOf(0);
                            }
                            else if (C_TumitateDSakuseiKbn.SEISIKI.eq(khTumitateDKanriTounendo.getTumitatedskskbn())) {

                                khTumitateDKanri = pKhTumitateDKanriList.get(1);

                                zenjigyouNendoTumitateD = keisanWarimodosigk(
                                    khTumitateDKanri.getTumitated(),
                                    zenjigyouNendoMatuymd,
                                    khTumitateDKanri.getTumitatedtumitateymd(),
                                    TUMITATERISOKU,
                                    pBikinKykHaitouMeisai.getSyono(),
                                    pBatchParam);
                            }
                            else if (C_TumitateDSakuseiKbn.YENDTHNKSEISIKI.eq(khTumitateDKanriTounendo.getTumitatedskskbn())) {

                                if (BizDateUtil.compareYmd(pKhTumitateDKanriList.get(1).getTumitatedtumitateymd(),
                                    zenjigyouNendoMatuymd) == BizDateUtil.COMPARE_GREATER &&
                                    C_TumitateDSakuseiKbn.SEISIKI.eq(pKhTumitateDKanriList.get(1).getTumitatedskskbn())) {

                                    khTumitateDKanri = pKhTumitateDKanriList.get(2);

                                    for (int i = 2; pKhTumitateDKanriList.size() > i; i ++) {
                                        if (C_TumitateDSakuseiKbn.RISOKUKURIIRE.eq(
                                            pKhTumitateDKanriList.get(i).getTumitatedskskbn())) {

                                            khTumitateDKanri = pKhTumitateDKanriList.get(i);

                                            break;
                                        }
                                    }

                                    zenjigyouNendoTumitateD = keisanWarimodosigk(
                                        khTumitateDKanri.getTumitated(),
                                        zenjigyouNendoMatuymd,
                                        khTumitateDKanri.getTumitatedtumitateymd(),
                                        TUMITATERISOKU,
                                        pBikinKykHaitouMeisai.getSyono(),
                                        pBatchParam);

                                }
                                else {
                                    for (int i = 1; pKhTumitateDKanriList.size() > i; i ++) {
                                        if (BizDateUtil.compareYmd(pKhTumitateDKanriList.get(i).getTumitatedtumitateymd(),
                                            zenjigyouNendoMatuymd) == BizDateUtil.COMPARE_GREATER) {

                                            khTumitateDKanri = pKhTumitateDKanriList.get(i);

                                            break;
                                        }
                                    }

                                    if (khTumitateDKanri != null) {

                                        zenjigyouNendoTumitateD = keisanWarimodosigk(
                                            khTumitateDKanri.getTumitated(),
                                            zenjigyouNendoMatuymd,
                                            khTumitateDKanri.getTumitatedtumitateymd(),
                                            TUMITATERISOKU,
                                            pBikinKykHaitouMeisai.getSyono(),
                                            pBatchParam);
                                    }
                                    else {
                                        BizCurrency tounendoD = BizCurrency.valueOf(0);

                                        for (IT_KhHaitouKanri khHaitouKanriLoop : pKhHaitouKanriList) {
                                            if (C_HaitoukinsksKbn.YENDTHNKSEISIKI.eq(khHaitouKanriLoop.getHaitoukinskskbn())) {

                                                tounendoD = khHaitouKanriLoop.getTounendod();

                                                break;
                                            }
                                        }

                                        zenjigyouNendoTumitateD = keisanWarimodosigk(
                                            pKhTumitateDKanriList.get(0).getTumitated().subtract(tounendoD),
                                            zenjigyouNendoMatuymd,
                                            pKhTumitateDKanriList.get(0).getTumitatedtumitateymd(),
                                            TUMITATERISOKU,
                                            pBikinKykHaitouMeisai.getSyono(),
                                            pBatchParam);
                                    }

                                }
                            }
                        }
                    }
                }

                BizCurrency tounendoD = BizCurrency.valueOf(0);

                if (BizDateUtil.compareYmd(zenjigyouNendoMatuymd, pKhTumitateDKanriList.get(0)
                    .getTumitatedtumitateymd()) == BizDateUtil.COMPARE_LESSER) {

                    if (C_TumitateDSakuseiKbn.SEISIKI.eq(pKhTumitateDKanriList.get(0).getTumitatedskskbn())) {
                        for (IT_KhHaitouKanri khHaitouKanriLoop : pKhHaitouKanriList) {
                            if (C_HaitoukinsksKbn.SEISIKI.eq(khHaitouKanriLoop.getHaitoukinskskbn())) {

                                tounendoD = khHaitouKanriLoop.getTounendod();

                                break;
                            }
                        }
                    }

                    if (C_TumitateDSakuseiKbn.YENDTHNKSEISIKI.eq(pKhTumitateDKanriList.get(0).getTumitatedskskbn())) {

                        boolean seisikiWariateFlg = false;

                        if (pKhTumitateDKanriList.size() > 1 &&
                            BizDateUtil.compareYmd(zenjigyouNendoMatuymd, pKhTumitateDKanriList.get(1)
                                .getTumitatedtumitateymd()) == BizDateUtil.COMPARE_LESSER &&
                                C_TumitateDSakuseiKbn.SEISIKI.eq(pKhTumitateDKanriList.get(1).getTumitatedskskbn())){

                            seisikiWariateFlg = true;
                        }

                        for (IT_KhHaitouKanri khHaitouKanriLoop : pKhHaitouKanriList) {
                            if (BizDateUtil.compareYmd(zenjigyouNendoMatuymd, khHaitouKanriLoop.
                                getKariwariatedshrymd()) == BizDateUtil.COMPARE_LESSER &&
                                (C_HaitoukinsksKbn.SEISIKI.eq(khHaitouKanriLoop.getHaitoukinskskbn()) ||
                                    C_HaitoukinsksKbn.YENDTHNKSEISIKI.eq(khHaitouKanriLoop.getHaitoukinskskbn()))) {

                                tounendoD = tounendoD.add(khHaitouKanriLoop.getTounendod());

                                if (!seisikiWariateFlg){

                                    break;
                                }
                            }
                        }
                    }
                }
                else {

                    tounendoD = BizCurrency.valueOf(0);
                }

                tumitateRisoku = tumitateDGanrikin.subtract(tounendoD).subtract(zenjigyouNendoTumitateD);
            }
            else {

                tumitateRisoku = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
            }

            BizDate kariwariateDShrYmdZen = null;

            if (kariwariateDGanrikin.compareTo(
                BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO, kariwariateDGanrikin.getType())) > 0) {

                BizCurrency zenjgyndmtKariwariateDGanrikin = BizCurrency.valueOf(0);

                IT_KhHaitouKanri khHaitouKanriZennendo = null;
                IT_KhHaitouKanri khHaitouKanriTounendo = null;

                for (int i = 0; i < pKhHaitouKanriList.size(); i++) {


                    if (BizDateUtil.compareYmd(kariwariateDShrYmd[i], zenjigyouNendoMatuymd) == BizDateUtil.COMPARE_LESSER ||
                        BizDateUtil.compareYmd(kariwariateDShrYmd[i], zenjigyouNendoMatuymd) == BizDateUtil.COMPARE_EQUAL) {

                        khHaitouKanriZennendo = pKhHaitouKanriList.get(i);

                        kariwariateDShrYmdZen = kariwariateDShrYmd[i];

                        break;
                    }
                }

                if (khHaitouKanriZennendo == null) {
                    zenjgyndmtKariwariateDGanrikin = BizCurrency.valueOf(0);
                }
                else {
                    if (khHaitouKanriZennendo.getKariwariatedruigk().compareTo(
                        BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO,
                            khHaitouKanriZennendo.getKariwariatedruigk().getType())) == 0) {
                        zenjgyndmtKariwariateDGanrikin = BizCurrency.valueOf(0);
                    }
                    else {

                        if (BizDateUtil.compareYmd(kariwariateDShrYmd[0],
                            zenjigyouNendoMatuymd) == BizDateUtil.COMPARE_LESSER ||
                            BizDateUtil.compareYmd(kariwariateDShrYmd[0],
                                zenjigyouNendoMatuymd) == BizDateUtil.COMPARE_EQUAL) {

                            zenjgyndmtKariwariateDGanrikin = keisanDGanrikin(
                                khHaitouKanriZennendo.getKariwariatedruigk(),
                                kariwariateDShrYmdZen,
                                zenjigyouNendoMatuymd,
                                KARIWARIATEDRISOKU,
                                pBikinKykHaitouMeisai.getSyono(),
                                pBatchParam);
                        }
                        else {

                            khHaitouKanriTounendo = pKhHaitouKanriList.get(0);

                            if (C_HaitoukinsksKbn.SEISIKI.eq(khHaitouKanriTounendo.getHaitoukinskskbn())) {

                                zenjgyndmtKariwariateDGanrikin = keisanWarimodosigk(
                                    pKhHaitouKanriList.get(1).getKariwariatedruigk().subtract(pKhHaitouKanriList.get(1).getTounendod()),
                                    zenjigyouNendoMatuymd,
                                    pKhHaitouKanriList.get(1).getKariwariatedshrymd(),
                                    KARIWARIATEDRISOKU,
                                    pBikinKykHaitouMeisai.getSyono(),
                                    pBatchParam);
                            }
                            else if (C_HaitoukinsksKbn.KARIWARIATE1.eq(khHaitouKanriTounendo.getHaitoukinskskbn()) ||
                                C_HaitoukinsksKbn.KARIWARIATE2.eq(khHaitouKanriTounendo.getHaitoukinskskbn()) ||
                                C_HaitoukinsksKbn.KARIWARIATE3.eq(khHaitouKanriTounendo.getHaitoukinskskbn()) ||
                                C_HaitoukinsksKbn.KARIWARIATE4.eq(khHaitouKanriTounendo.getHaitoukinskskbn())) {

                                zenjgyndmtKariwariateDGanrikin = keisanWarimodosigk(
                                    khHaitouKanriTounendo.getKariwariatedruigk().subtract(khHaitouKanriTounendo.getTounendod()),
                                    zenjigyouNendoMatuymd,
                                    khHaitouKanriTounendo.getKariwariatedshrymd(),
                                    KARIWARIATEDRISOKU,
                                    pBikinKykHaitouMeisai.getSyono(),
                                    pBatchParam);
                            }
                            else if (C_HaitoukinsksKbn.KARIDSIHARAI.eq(khHaitouKanriTounendo.getHaitoukinskskbn())) {

                                zenjgyndmtKariwariateDGanrikin = keisanWarimodosigk(
                                    khHaitouKanriTounendo.getKariwariatedruigk(),
                                    zenjigyouNendoMatuymd,
                                    kariwariateDShrYmd[0],
                                    KARIWARIATEDRISOKU,
                                    pBikinKykHaitouMeisai.getSyono(),
                                    pBatchParam);
                            }
                            else if (C_HaitoukinsksKbn.YENDTHNKSEISIKI.eq(khHaitouKanriTounendo.getHaitoukinskskbn())) {

                                C_UmuKbn seisikiwariateFlg = C_UmuKbn.NONE;
                                C_UmuKbn kariwariateFlg = C_UmuKbn.NONE;
                                C_UmuKbn karidsiharaiFlg = C_UmuKbn.NONE;

                                if (BizDateUtil.compareYmd(zenjigyouNendoMatuymd,
                                    kariwariateDShrYmd[2]) == BizDateUtil.COMPARE_LESSER) {

                                    if (C_HaitoukinsksKbn.SEISIKI.eq(pKhHaitouKanriList.get(2).getHaitoukinskskbn())) {

                                        seisikiwariateFlg = C_UmuKbn.ARI;
                                    }
                                    else if (C_HaitoukinsksKbn.KARIDSIHARAI.eq(pKhHaitouKanriList.get(2).getHaitoukinskskbn())) {

                                        karidsiharaiFlg = C_UmuKbn.ARI;
                                    }
                                    else if (C_HaitoukinsksKbn.KARIWARIATE1.eq(pKhHaitouKanriList.get(2).getHaitoukinskskbn()) ||
                                        C_HaitoukinsksKbn.KARIWARIATE2.eq(pKhHaitouKanriList.get(2).getHaitoukinskskbn()) ||
                                        C_HaitoukinsksKbn.KARIWARIATE3.eq(pKhHaitouKanriList.get(2).getHaitoukinskskbn()) ||
                                        C_HaitoukinsksKbn.KARIWARIATE4.eq(pKhHaitouKanriList.get(2).getHaitoukinskskbn())) {

                                        kariwariateFlg = C_UmuKbn.ARI;
                                    }
                                }

                                if (C_UmuKbn.ARI.eq(seisikiwariateFlg)) {

                                    zenjgyndmtKariwariateDGanrikin = BizCurrency.valueOf(0);
                                }
                                else if (C_UmuKbn.ARI.eq(karidsiharaiFlg)) {

                                    zenjgyndmtKariwariateDGanrikin = keisanWarimodosigk(
                                        pKhHaitouKanriList.get(2).getKariwariatedruigk(),
                                        zenjigyouNendoMatuymd,
                                        kariwariateDShrYmd[2],
                                        KARIWARIATEDRISOKU,
                                        pBikinKykHaitouMeisai.getSyono(),
                                        pBatchParam);
                                }
                                else if (C_UmuKbn.ARI.eq(kariwariateFlg)) {

                                    zenjgyndmtKariwariateDGanrikin = keisanWarimodosigk(
                                        pKhHaitouKanriList.get(2).getKariwariatedruigk().subtract(
                                            pKhHaitouKanriList.get(2).getTounendod()),
                                            zenjigyouNendoMatuymd,
                                            pKhHaitouKanriList.get(2).getKariwariatedshrymd(),
                                            KARIWARIATEDRISOKU,
                                            pBikinKykHaitouMeisai.getSyono(),
                                            pBatchParam);
                                }
                                else {

                                    zenjgyndmtKariwariateDGanrikin = keisanWarimodosigk(
                                        pKhHaitouKanriList.get(1).getKariwariatedruigk().subtract(
                                            pKhHaitouKanriList.get(1).getTounendod()),
                                            zenjigyouNendoMatuymd,
                                            pKhHaitouKanriList.get(1).getKariwariatedshrymd(),
                                            KARIWARIATEDRISOKU,
                                            pBikinKykHaitouMeisai.getSyono(),
                                            pBatchParam);
                                }
                            }
                        }
                    }
                }

                BizCurrency tounendoKariwariateD = BizCurrency.valueOf(0);
                String seisikiwariateNendohyj = "";

                BizDate kijyunYmd = pTkJitenSyouhinInfo.getKykymd();

                if (pTkJitenSyouhinInfo.getYendthnkymd() != null) {

                    kijyunYmd = pTkJitenSyouhinInfo.getYendthnkymd();
                }

                BizDateY kijyunNendo = kijyunYmd.getBizDateY();

                if (kijyunYmd.getMonth() <= SrCommonConstants.MONTH_MARCH) {

                    kijyunNendo = BizDateY.valueOf(kijyunNendo.getYear() - SrCommonConstants.YEAR_1Y) ;
                }

                BizDateY haitouNendo = pKhHaitouKanriList.get(0).getHaitounendo();

                if ((haitouNendo.getYear() - kijyunNendo.getYear()) % 5 == 0) {

                    if (haitouNendo.getYear() == zenjigyouNendoMatuymd.getYear()) {

                        seisikiwariateNendohyj = SEISIKIWARIATENENDOHYJ_ARI;
                    }
                    else {

                        seisikiwariateNendohyj = SEISIKIWARIATENENDOHYJ_NASI;
                    }
                }
                else {

                    seisikiwariateNendohyj = SEISIKIWARIATENENDOHYJ_NASI;
                }

                if (SEISIKIWARIATENENDOHYJ_NASI.equals(seisikiwariateNendohyj)) {

                    if (pKhHaitouKanriList.size() > 0 &&
                        BizDateUtil.compareYmd(zenjigyouNendoMatuymd,
                            kariwariateDShrYmd[0]) == BizDateUtil.COMPARE_LESSER) {

                        if (!C_HaitoukinsksKbn.KARIDSIHARAI.eq(pKhHaitouKanriList.get(0).getHaitoukinskskbn())) {

                            tounendoKariwariateD = pKhHaitouKanriList.get(0).getTounendod();
                        }
                    }
                }
                else {

                    if (khHaitouKanriTounendo != null &&
                        C_HaitoukinsksKbn.SEISIKI.eq(khHaitouKanriTounendo.getHaitoukinskskbn())) {

                        tounendoKariwariateD = (pKhHaitouKanriList.get(1).getKariwariatedruigk().subtract(
                            pKhHaitouKanriList.get(1).getTounendod()).multiply(-1));
                    }
                    else {

                        tounendoKariwariateD = (pKhHaitouKanriList.get(1).getKariwariatedruigk().subtract(
                            pKhHaitouKanriList.get(1).getTounendod()));

                        if (pKhHaitouKanriList.size() > 2 &&
                            BizDateUtil.compareYmd(zenjigyouNendoMatuymd,
                                kariwariateDShrYmd[2]) == BizDateUtil.COMPARE_LESSER) {

                            if (C_HaitoukinsksKbn.KARIWARIATE1.eq(pKhHaitouKanriList.get(2).getHaitoukinskskbn()) ||
                                C_HaitoukinsksKbn.KARIWARIATE2.eq(pKhHaitouKanriList.get(2).getHaitoukinskskbn()) ||
                                C_HaitoukinsksKbn.KARIWARIATE3.eq(pKhHaitouKanriList.get(2).getHaitoukinskskbn()) ||
                                C_HaitoukinsksKbn.KARIWARIATE4.eq(pKhHaitouKanriList.get(2).getHaitoukinskskbn())) {

                                tounendoKariwariateD = tounendoKariwariateD.subtract(
                                    pKhHaitouKanriList.get(2).getTounendod()).multiply(-1);
                            }
                            else if (C_HaitoukinsksKbn.KARIDSIHARAI.eq(pKhHaitouKanriList.get(2).getHaitoukinskskbn())) {

                                tounendoKariwariateD = tounendoKariwariateD.multiply(-1);
                            }
                        }
                        else {

                            tounendoKariwariateD = tounendoKariwariateD.multiply(-1);
                        }
                    }
                }

                kariwariateDRisoku = kariwariateDGanrikin.subtract(tounendoKariwariateD).subtract(zenjgyndmtKariwariateDGanrikin);
            }
            else {

                kariwariateDRisoku = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
            }
        }

        pBknkykHtjynbkn.setHknsyukigou(pTkJitenSyouhinInfo.getSyouhncd());
        pBknkykHtjynbkn.setHaraikomikaisukbn(haraikomikaisuKbn);
        pBknkykHtjynbkn.setHrkkeirokbn(hrkkeiroKbn);
        pBknkykHtjynbkn.setAnnaihuyouriyuukbn(annaihuyouRiyuuKbn);
        pBknkykHtjynbkn.setBikinkbn(bikinKbn);
        pBknkykHtjynbkn.setBikinnendokbn(pBikinKykHaitouMeisai.getBknjkukbn().getValue());
        pBknkykHtjynbkn.setSeisand(seisanD);
        pBknkykHtjynbkn.setTumitaterisoku(tumitateRisoku);
        pBknkykHtjynbkn.setKbnkeiriyousegmentkbn(kbnkeiriyousegmentkbn);
        pBknkykHtjynbkn.setKbnkeiriyourgnbnskkbn(kbnkeiriyourgnbnskkbn);
        pBknkykHtjynbkn.setKariwariatedganrikin(kariwariateDGanrikin);
        pBknkykHtjynbkn.setKariwariatedrisoku(kariwariateDRisoku);
        pBknkykHtjynbkn.setSyukeiyakusyuruicd(syukeiyakusyuruiCd);
        pBknkykHtjynbkn.setKyknendo(kyknendo);
        pBknkykHtjynbkn.setDaihyouyoteiriritu(daihyouyoteiriritu);
        pBknkykHtjynbkn.setHaraikatakbn(haraikataKbn);

        BizPropertyInitializer.initialize(pBknkykHtjynbkn);

        return errorFlag;
    }

    private BizCurrency keisanDGanrikin(BizCurrency pRuikeiGk, BizDate pCalckijyunYmdFrom, BizDate pCalckijyunYmdTo,
        String pKoumokuNm, String pSyono, SrBikinKykHaitoujynbknSelBatchParam pBatchParam) {

        KeisanDGanrikin keisanDGanrikin = SWAKInjector.getInstance(KeisanDGanrikin.class);

        BizCurrency haitouganrikin = null;

        C_ErrorKbn errorKbn = keisanDGanrikin.exec(pRuikeiGk, pCalckijyunYmdFrom, pCalckijyunYmdTo);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            String msg = MessageUtil.getMessage(MessageId.ESA1001, "配当元利金計算(" + pKoumokuNm + ")", pSyono);

            batchLogger.warn(msg);

            insertSuuriyouErrJyouhou(pBatchParam, pSyono, msg);
        }
        else {

            haitouganrikin = keisanDGanrikin.getDGanrikin();
        }

        return haitouganrikin;
    }

    private BizCurrency keisanWarimodosigk(BizCurrency pWarimodosiMaeGk, BizDate pCalckijyunYmdFrom,
        BizDate pCalckijyunYmdTo, String pKoumokuNm, String pSyono, SrBikinKykHaitoujynbknSelBatchParam pBatchParam) {

        BizCurrency warimodosiAtoGk = null;

        if (pWarimodosiMaeGk.compareTo(BizCurrency.valueOf(
            SrCommonConstants.DEFAULT_INT_ZERO, pWarimodosiMaeGk.getType())) == 0) {

            warimodosiAtoGk = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);

            return warimodosiAtoGk;
        }

        GetDRiritu getDRiritu = SWAKInjector.getInstance(GetDRiritu.class);
        KeisanDCommon keisanDCommon = SWAKInjector.getInstance(KeisanDCommon.class);
        List<BizNumber> haitourirituList = new ArrayList<BizNumber>();

        C_ErrorKbn errorKbn = getDRiritu.exec(pCalckijyunYmdFrom, pCalckijyunYmdTo);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            String msg = MessageUtil.getMessage(MessageId.ESA1001, "割戻し計算(" + pKoumokuNm + ")", pSyono);

            batchLogger.warn(msg);

            insertSuuriyouErrJyouhou(pBatchParam, pSyono, msg);

            return warimodosiAtoGk;
        }

        haitourirituList.add(getDRiritu.getDRiritu());

        warimodosiAtoGk = keisanDCommon.calcWrmdsKngk(pWarimodosiMaeGk, haitourirituList);

        return warimodosiAtoGk;
    }

    private BizDate[] getKariwariatedshrymd(List<IT_KhHaitouKanri> pKhHaitouKanriList,
        List<SV_KiykSyuhnData> pKiykSyuhnDataList) {

        BizDate[] haitouYmd = new BizDate[pKhHaitouKanriList.size()];

        for (int i = 0; pKhHaitouKanriList.size() > i; i ++) {
            haitouYmd[i] = pKhHaitouKanriList.get(i).getKariwariatedshrymd();

            if (C_HaitoukinsksKbn.KARIDSIHARAI.eq(pKhHaitouKanriList.get(i).getHaitoukinskskbn())) {

                SrGetTokutejitenSyohnInfo srGetTokutejitenSyohnInfo = SWAKInjector.getInstance(
                    SrGetTokutejitenSyohnInfo.class);

                TkJitenKeiyakuSyouhinBean tkJitenKeiyakuSyouhinBean = srGetTokutejitenSyohnInfo.exec(
                    C_TokutejitenSyoriKbn.KIJYUNBIJITENSYOUHININFO,
                    pKhHaitouKanriList.get(i).getSyono(),
                    pKhHaitouKanriList.get(i).getKariwariatedshrymd(),
                    "",
                    pKiykSyuhnDataList);

                TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBean =
                    tkJitenKeiyakuSyouhinBean.getTkJitenKeiyakuSyouhinKijyunBeanAto();

                BizDateMD outoutMd = null;

                if (tkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd()  != null) {

                    outoutMd = tkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd().getBizDateMD();
                }
                else {

                    outoutMd = tkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateMD();
                }

                BizDateY haitouY = null;

                if (outoutMd.getMonth() <= SrCommonConstants.MONTH_MARCH) {

                    haitouY = pKhHaitouKanriList.get(i).getHaitounendo().addYears(SrCommonConstants.YEAR_1Y);
                }
                else {

                    haitouY = pKhHaitouKanriList.get(i).getHaitounendo();
                }

                haitouYmd[i] = (BizDate.valueOf(haitouY, outoutMd)).getRekijyou();
            }
        }

        return haitouYmd;
    }

    private void insertSuuriyouErrJyouhou(SrBikinKykHaitoujynbknSelBatchParam pBatchParam, String pSyono, String pMsg) {

        ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

        suuriyouErrJyouhou.setSyoriYmd(pBatchParam.getSyoriYmd());
        suuriyouErrJyouhou.setKakutyoujobcd(pBatchParam.getIbKakutyoujobcd());
        suuriyouErrJyouhou.setSyono(pSyono);
        suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
        suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(pMsg);

        BizPropertyInitializer.initialize(suuriyouErrJyouhou);

        ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

        pBatchParam.setErrorSyoriKensuu(pBatchParam.getErrorSyoriKensuu() + 1);

        errorFlag = true;
    }
}
