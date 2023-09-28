package yuyu.common.biz.kaikei;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.uniquekey.UniqueKeyGenerator;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.classification.C_DensyoriKbn;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_Hjkmkcd;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_Syuudaikocd;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.nenkin.manager.NenkinDomManager;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;

/**
 * 業務共通 経理・会計 伝票データ登録処理
 */
public class DenDataTrk {

    private int edaBanngou = 0;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private NenkinDomManager nenkinDomManager;

    @Inject
    private UniqueKeyGenerator unique;

    public DenDataTrk() {
        super();
    }

    public int getEdano() {
        return edaBanngou;
    }

    public String exec(C_DensysKbn pDenpyouSysKubun,
            C_DensyoriKbn pDenpyouSyoriKubun,
            BizDate pDenpyouKihyouYMD,
            BizDate pDenpyouYMD,
            int pSiwaGyousu,
            C_TaisyakuKbn[] pTaisyakuKbn,
            C_Kanjyoukmkcd[] pKannjyouKamokuCds,
            C_Hjkmkcd[] pHujyoKamokuCds,
            BizCurrency[] pDenGks,
            BizCurrency[] pSyouHiZeiGks,
            String pSyoukenBangou,
            String pDairitenCd,
            C_Syuudaikocd pSyuudaikocd,
            String pBankCd,
            String pCardKaisyaCd,
            String pOyaDairitenCd,
            int pHandoKarikanjyouBangou,
            String pSegumento1Cd,
            String pSegumento2Cd,
            String pKinouID,
            String pUserID) {

        if (!BizUtil.isBlank(pSegumento1Cd)) {
            throw new CommonBizAppException("セグメント１コードが設定されています。");
        }
        if (!BizUtil.isBlank(pSegumento2Cd)) {
            throw new CommonBizAppException("セグメント２コードが設定されています。");
        }

        C_Segcd[] seg1CDs = new C_Segcd[pSiwaGyousu];
        C_Segcd[] seg2CDs = new C_Segcd[pSiwaGyousu];

        for (int index = 0; index < pSiwaGyousu; index++) {
            seg1CDs[index] = C_Segcd.BLNK;
            seg2CDs[index] = C_Segcd.BLNK;
        }

        return exec(pDenpyouSysKubun,
                pDenpyouSyoriKubun,
                pDenpyouKihyouYMD,
                pDenpyouYMD,
                pSiwaGyousu,
                pTaisyakuKbn,
                pKannjyouKamokuCds,
                pHujyoKamokuCds,
                pDenGks,
                pSyouHiZeiGks,
                seg1CDs,
                seg2CDs,
                pSyoukenBangou,
                pDairitenCd,
                pSyuudaikocd,
                pBankCd,
                pCardKaisyaCd,
                pOyaDairitenCd,
                pHandoKarikanjyouBangou,
                pKinouID,
                pUserID);
    }

    public String exec(C_DensysKbn pDenpyouSysKubun,
            C_DensyoriKbn pDenpyouSyoriKubun,
            BizDate pDenpyouKihyouYMD,
            BizDate pDenpyouYMD,
            int pSiwaGyousu,
            C_TaisyakuKbn[] pTaisyakuKbn,
            C_Kanjyoukmkcd[] pKannjyouKamokuCds,
            C_Hjkmkcd[] pHujyoKamokuCds,
            BizCurrency[] pDenGks,
            BizCurrency[] pSyouHiZeiGks,
            C_Segcd[] pSegumento1Cds,
            C_Segcd[] pSegumento2Cds,
            String pSyoukenBangou,
            String pDairitenCd,
            C_Syuudaikocd pSyuudaikocd,
            String pBankCd,
            String pCardKaisyaCd,
            String pOyaDairitenCd,
            int pHandoKarikanjyouBangou,
            String pKinouID,
            String pUserID) {

//        BizCurrency karikataKingaku = BizCurrency.valueOf(0);
//        BizCurrency kasikataKingaku = BizCurrency.valueOf(0);
//
//        for (int index = 0; index < pSiwaGyousu; index++) {
//
//            if (C_TaisyakuKbn.KARIKATA.eq(pTaisyakuKbn[index])) {
//
//                karikataKingaku = karikataKingaku.add(pDenGks[index]);
//            }
//            else if (C_TaisyakuKbn.KASIKATA.eq(pTaisyakuKbn[index])) {
//
//                kasikataKingaku = kasikataKingaku.add(pDenGks[index]);
//            }
//        }
//
//        if (karikataKingaku.compareTo(kasikataKingaku) != 0) {
//            throw new CommonBizAppException(
//                    MessageUtil.getMessage(MessageId.EBA0043, pSyoukenBangou, pDairitenCd));
//        }
//
//        String denpyouRenban = unique.generateUniqueKey();
//        int tourokuEdaBangou = 0;
//        String syoriDate = BizDate.getSysDateTimeMilli();
//        C_Hjkmkcd[] hujyoKamokuCds = new C_Hjkmkcd[pSiwaGyousu];
//
//        for (int index = 0; index < pSiwaGyousu; index++) {
//
//            if (C_Hjkmkcd.BLNK.eq(pHujyoKamokuCds[index])) {
//
//                if (pKannjyouKamokuCds[index].eq(C_Kanjyoukmkcd.JIGYOUHI_HRKMTSRY)) {
//
//                    hujyoKamokuCds[index] = C_Hjkmkcd.KZNKFKTSRY;
//                }
//                else if(pKannjyouKamokuCds[index].eq(C_Kanjyoukmkcd.JIGYOUHI_PAGTSRY)){
//
//                    hujyoKamokuCds[index] = C_Hjkmkcd.PFKTSRY;
//
//                }
//                else if (pKannjyouKamokuCds[index].eq(C_Kanjyoukmkcd.JIGYOUHI_SNDNSY)) {
//
//                    hujyoKamokuCds[index] = C_Hjkmkcd.SDSYOSTKHIY;
//                }
//                else {
//
//                    hujyoKamokuCds[index] = C_Hjkmkcd.BLNK;
//                }
//            }
//            else if (pHujyoKamokuCds[index] == null) {
//
//                throw new CommonBizAppException("補助科目コードが設定されていません。");
//            }
//            else {
//                hujyoKamokuCds[index] = pHujyoKamokuCds[index];
//            }
//        }
//
//        if (C_DensysKbn.SKEI.eq(pDenpyouSysKubun)) {
//
//            for (int index = 0; index < pSiwaGyousu; index++) {
//
//                tourokuEdaBangou++;
//
//                HT_SkDenpyoData skDenpyoData = new HT_SkDenpyoData();
//
//                skDenpyoData.setDenrenno(denpyouRenban);
//                skDenpyoData.setEdano(tourokuEdaBangou);
//                skDenpyoData.setDensyskbn(pDenpyouSysKubun);
//                skDenpyoData.setDensyorikbn(pDenpyouSyoriKubun);
//                skDenpyoData.setDenkihyouymd(pDenpyouKihyouYMD);
//                skDenpyoData.setDenymd(pDenpyouYMD);
//                skDenpyoData.setTaisyakukbn(pTaisyakuKbn[index]);
//                skDenpyoData.setKanjyoukmkcd(pKannjyouKamokuCds[index]);
//                skDenpyoData.setHjkmkcd(hujyoKamokuCds[index]);
//                skDenpyoData.setDengk(pDenGks[index]);
//
//                if (pSyouHiZeiGks[index] == null) {
//                    skDenpyoData.setSyouhizeigk(BizCurrency.valueOf(0));
//                }
//                else {
//                    skDenpyoData.setSyouhizeigk(pSyouHiZeiGks[index]);
//                }
//
//                skDenpyoData.setSyono(pSyoukenBangou);
//                skDenpyoData.setDrtencd(pDairitenCd);
//                skDenpyoData.setSyuudaikocd(pSyuudaikocd);
//                skDenpyoData.setBankcd(pBankCd);
//                skDenpyoData.setCardkaisyacd(pCardKaisyaCd);
//                skDenpyoData.setOyadrtencd(pOyaDairitenCd);
//                skDenpyoData.setHndkarikanjyono(pHandoKarikanjyouBangou);
//                skDenpyoData.setSeg1cd(pSegumento1Cds[index]);
//                skDenpyoData.setSeg2cd(pSegumento2Cds[index]);
//                skDenpyoData.setGyoumuKousinKinou(pKinouID);
//                skDenpyoData.setGyoumuKousinsyaId(pUserID);
//                skDenpyoData.setGyoumuKousinTime(syoriDate);
//
//                BizPropertyInitializer.initialize(skDenpyoData);
//
//                sinkeiyakuDomManager.insert(skDenpyoData);
//
//                if (C_Kanjyoukmkcd.KARIUKE_FBSOKIN.eq(pKannjyouKamokuCds[index])) {
//                    edaBanngou = tourokuEdaBangou;
//                }
//            }
//        }
//
//        if (C_DensysKbn.HOZEN.eq(pDenpyouSysKubun)) {
//
//            for (int index = 0; index < pSiwaGyousu; index++) {
//
//                tourokuEdaBangou++;
//
//                IT_KhDenpyoData khDenpyoData = new IT_KhDenpyoData();
//
//                khDenpyoData.setDenrenno(denpyouRenban);
//                khDenpyoData.setEdano(tourokuEdaBangou);
//                khDenpyoData.setDensyskbn(pDenpyouSysKubun);
//                khDenpyoData.setDensyorikbn(pDenpyouSyoriKubun);
//                khDenpyoData.setDenkihyouymd(pDenpyouKihyouYMD);
//                khDenpyoData.setDenymd(pDenpyouYMD);
//                khDenpyoData.setTaisyakukbn(pTaisyakuKbn[index]);
//                khDenpyoData.setKanjyoukmkcd(pKannjyouKamokuCds[index]);
//                khDenpyoData.setHjkmkcd(hujyoKamokuCds[index]);
//                khDenpyoData.setDengk(pDenGks[index]);
//
//                if (pSyouHiZeiGks[index] == null) {
//                    khDenpyoData.setSyouhizeigk(BizCurrency.valueOf(0));
//                }
//                else {
//                    khDenpyoData.setSyouhizeigk(pSyouHiZeiGks[index]);
//                }
//
//                khDenpyoData.setSyono(pSyoukenBangou);
//                khDenpyoData.setDrtencd(pDairitenCd);
//                khDenpyoData.setSyuudaikocd(pSyuudaikocd);
//                khDenpyoData.setBankcd(pBankCd);
//                khDenpyoData.setCardkaisyacd(pCardKaisyaCd);
//                khDenpyoData.setOyadrtencd(pOyaDairitenCd);
//                khDenpyoData.setHndkarikanjyono(pHandoKarikanjyouBangou);
//                khDenpyoData.setSeg1cd(pSegumento1Cds[index]);
//                khDenpyoData.setSeg2cd(pSegumento2Cds[index]);
//                khDenpyoData.setGyoumuKousinKinou(pKinouID);
//                khDenpyoData.setGyoumuKousinsyaId(pUserID);
//                khDenpyoData.setGyoumuKousinTime(syoriDate);
//
//                BizPropertyInitializer.initialize(khDenpyoData);
//
//                hozenDomManager.insert(khDenpyoData);
//
//                if (C_Kanjyoukmkcd.KARIUKE_FBSOKIN.eq(pKannjyouKamokuCds[index])) {
//                    edaBanngou = tourokuEdaBangou;
//                }
//            }
//        }
//
//        if (C_DensysKbn.HKSIHARAI.eq(pDenpyouSysKubun)) {
//
//            for (int index = 0; index < pSiwaGyousu; index++) {
//
//                tourokuEdaBangou++;
//
//                JT_SiDenpyoData siDenpyoData = new JT_SiDenpyoData();
//
//                siDenpyoData.setDenrenno(denpyouRenban);
//                siDenpyoData.setEdano(tourokuEdaBangou);
//                siDenpyoData.setDensyskbn(pDenpyouSysKubun);
//                siDenpyoData.setDensyorikbn(pDenpyouSyoriKubun);
//                siDenpyoData.setDenkihyouymd(pDenpyouKihyouYMD);
//                siDenpyoData.setDenymd(pDenpyouYMD);
//                siDenpyoData.setTaisyakukbn(pTaisyakuKbn[index]);
//                siDenpyoData.setKanjyoukmkcd(pKannjyouKamokuCds[index]);
//                siDenpyoData.setHjkmkcd(hujyoKamokuCds[index]);
//                siDenpyoData.setDengk(pDenGks[index]);
//
//                if (pSyouHiZeiGks[index] == null) {
//                    siDenpyoData.setSyouhizeigk(BizCurrency.valueOf(0));
//                }
//                else {
//                    siDenpyoData.setSyouhizeigk(pSyouHiZeiGks[index]);
//                }
//
//                siDenpyoData.setSyono(pSyoukenBangou);
//                siDenpyoData.setDrtencd(pDairitenCd);
//                siDenpyoData.setSyuudaikocd(pSyuudaikocd);
//                siDenpyoData.setBankcd(pBankCd);
//                siDenpyoData.setCardkaisyacd(pCardKaisyaCd);
//                siDenpyoData.setOyadrtencd(pOyaDairitenCd);
//                siDenpyoData.setHndkarikanjyono(pHandoKarikanjyouBangou);
//                siDenpyoData.setSeg1cd(pSegumento1Cds[index]);
//                siDenpyoData.setSeg2cd(pSegumento2Cds[index]);
//                siDenpyoData.setGyoumuKousinKinou(pKinouID);
//                siDenpyoData.setGyoumuKousinsyaId(pUserID);
//                siDenpyoData.setGyoumuKousinTime(syoriDate);
//
//                BizPropertyInitializer.initialize(siDenpyoData);
//
//                siharaiDomManager.insert(siDenpyoData);
//
//                if (C_Kanjyoukmkcd.KARIUKE_FBSOKIN.eq(pKannjyouKamokuCds[index])) {
//                    edaBanngou = tourokuEdaBangou;
//                }
//            }
//        }
//
//        if (C_DensysKbn.NENKIN.eq(pDenpyouSysKubun)) {
//
//            for (int index = 0; index < pSiwaGyousu; index++) {
//
//                tourokuEdaBangou++;
//
//                KT_NkDenpyoData nkDenpyoData = new KT_NkDenpyoData();
//
//                nkDenpyoData.setDenrenno(denpyouRenban);
//                nkDenpyoData.setEdano(tourokuEdaBangou);
//                nkDenpyoData.setDensyskbn(pDenpyouSysKubun);
//                nkDenpyoData.setDensyorikbn(pDenpyouSyoriKubun);
//                nkDenpyoData.setDenkihyouymd(pDenpyouKihyouYMD);
//                nkDenpyoData.setDenymd(pDenpyouYMD);
//                nkDenpyoData.setTaisyakukbn(pTaisyakuKbn[index]);
//                nkDenpyoData.setKanjyoukmkcd(pKannjyouKamokuCds[index]);
//                nkDenpyoData.setHjkmkcd(hujyoKamokuCds[index]);
//                nkDenpyoData.setDengk(pDenGks[index]);
//
//                if (pSyouHiZeiGks[index] == null) {
//                    nkDenpyoData.setSyouhizeigk(BizCurrency.valueOf(0));
//                }
//                else {
//                    nkDenpyoData.setSyouhizeigk(pSyouHiZeiGks[index]);
//                }
//
//                nkDenpyoData.setNksysyno(pSyoukenBangou);
//                nkDenpyoData.setDrtencd(pDairitenCd);
//                nkDenpyoData.setSyuudaikocd(pSyuudaikocd);
//                nkDenpyoData.setBankcd(pBankCd);
//                nkDenpyoData.setCardkaisyacd(pCardKaisyaCd);
//                nkDenpyoData.setOyadrtencd(pOyaDairitenCd);
//                nkDenpyoData.setHndkarikanjyono(pHandoKarikanjyouBangou);
//                nkDenpyoData.setSeg1cd(pSegumento1Cds[index]);
//                nkDenpyoData.setSeg2cd(pSegumento2Cds[index]);
//                nkDenpyoData.setGyoumuKousinKinou(pKinouID);
//                nkDenpyoData.setGyoumuKousinsyaId(pUserID);
//                nkDenpyoData.setGyoumuKousinTime(syoriDate);
//
//                BizPropertyInitializer.initialize(nkDenpyoData);
//
//                nenkinDomManager.insert(nkDenpyoData);
//
//                if (C_Kanjyoukmkcd.KARIUKE_FBSOKIN.eq(pKannjyouKamokuCds[index])) {
//                    edaBanngou = tourokuEdaBangou;
//                }
//            }
//        }
//
//        return denpyouRenban;
        return null;
    }
}
