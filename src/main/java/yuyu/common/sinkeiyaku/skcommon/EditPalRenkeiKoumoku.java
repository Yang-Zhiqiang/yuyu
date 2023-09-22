package yuyu.common.sinkeiyaku.skcommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.string.ConvertUtil;
import jp.co.slcs.swak.util.string.IDataConvert;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.classification.C_DakuhiktbunruiKbn;
import yuyu.def.classification.C_DntryourituKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FstphrkkeiroKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_IkkatubaraiKaisuuKbn;
import yuyu.def.classification.C_IkkatubaraiKbn;
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_Ketriyuucd;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_KykkakjkKbn;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_MostenkenjyouKbn;
import yuyu.def.classification.C_MostenkenyhKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_Sknenkinsyu;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_TorikesisyousairiyuuCd;
import yuyu.def.classification.C_TsindousiteiKbn;
import yuyu.def.classification.C_TumitatekinHaibunWariKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_DakuhiKettei;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_MosTrkKzk;
import yuyu.def.db.entity.HT_MostenkenRireki;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;

import com.google.common.base.Strings;

/**
 * 新契約 新契約共通 ＰＡＬ連携項目編集
 */
public class EditPalRenkeiKoumoku {

    private C_Ketkekkacd saisinKetkekkaCd;

    private C_TorikesisyousairiyuuCd saisinTorikesiSyousaiRiyuuCd;

    private String saisinPalKetsyaCd;

    private C_Ketkekkacd dakuhiKetSaisinKetKekkaCd;

    private BizDate dakuhiKetSaisinKetteiYmd;

    private C_Ketriyuucd dakuhiKetSaisinKetKekkaCd1;

    private C_Ketriyuucd dakuhiKetSaisinKetKekkaCd2;

    private C_Ketriyuucd dakuhiKetSaisinKetKekkaCd3;

    private C_Ketriyuucd dakuhiKetSaisinKetKekkaCd4;

    private List<C_Ketkekkacd> dakuhiKetSaisinKetKekkaCdLst;

    private List<String> dakuhiKetSaisinKetteiMdLst;

    private HT_MosSyouhn mosSyouhn;

    private BM_SyouhnZokusei syouhnZokusei;

    private String hknKkn;

    private String saiMnkKykHyj;

    private String hrkkkn;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    public EditPalRenkeiKoumoku() {
        super();
    }

    public C_Ketkekkacd getSaisinKetkekkaCd() {
        return saisinKetkekkaCd;
    }

    public C_TorikesisyousairiyuuCd getSaisinTorikesiSyousaiRiyuuCd() {
        return saisinTorikesiSyousaiRiyuuCd;
    }

    public String getSaisinPalKetsyaCd() {
        return saisinPalKetsyaCd;
    }

    public C_Ketkekkacd getDakuhiKetSaisinKetKekkaCd() {
        return dakuhiKetSaisinKetKekkaCd;
    }

    public BizDate getDakuhiKetSaisinKetteiYmd() {
        return dakuhiKetSaisinKetteiYmd;
    }

    public C_Ketriyuucd getDakuhiKetSaisinKetKekkaCd1() {
        return dakuhiKetSaisinKetKekkaCd1;
    }

    public C_Ketriyuucd getDakuhiKetSaisinKetKekkaCd2() {
        return dakuhiKetSaisinKetKekkaCd2;
    }

    public C_Ketriyuucd getDakuhiKetSaisinKetKekkaCd3() {
        return dakuhiKetSaisinKetKekkaCd3;
    }

    public C_Ketriyuucd getDakuhiKetSaisinKetKekkaCd4() {
        return dakuhiKetSaisinKetKekkaCd4;
    }

    public List<C_Ketkekkacd> getDakuhiKetSaisinKetKekkaCdLst() {
        return dakuhiKetSaisinKetKekkaCdLst;
    }

    public List<String> getDakuhiKetSaisinKetteiMdLst() {
        return dakuhiKetSaisinKetteiMdLst;
    }

    public HT_MosSyouhn getMosSyouhn() {
        return mosSyouhn;
    }

    public BM_SyouhnZokusei getSyouhnZokusei() {
        return syouhnZokusei;
    }

    public String getHknKkn() {
        return hknKkn;
    }

    public String getSaiMnkKykHyj() {
        return saiMnkKykHyj;
    }

    public String getHrkkkn() {
        return hrkkkn;
    }

    public void editDakuhiKetteiKanrenKoumoku(List<HT_DakuhiKettei> pDakuhiketteiLst) {

        saisinKetkekkaCd = C_Ketkekkacd.BLNK;

        saisinTorikesiSyousaiRiyuuCd = C_TorikesisyousairiyuuCd.BLNK;

        saisinPalKetsyaCd = "";

        dakuhiKetSaisinKetKekkaCd = C_Ketkekkacd.BLNK;

        dakuhiKetSaisinKetteiYmd = null;

        dakuhiKetSaisinKetKekkaCd1 = C_Ketriyuucd.BLNK;

        dakuhiKetSaisinKetKekkaCd2 = C_Ketriyuucd.BLNK;

        dakuhiKetSaisinKetKekkaCd3 = C_Ketriyuucd.BLNK;

        dakuhiKetSaisinKetKekkaCd4 = C_Ketriyuucd.BLNK;

        dakuhiKetSaisinKetKekkaCdLst = new ArrayList<>();

        dakuhiKetSaisinKetteiMdLst = new ArrayList<>();

        for (int i = 0; i < 6; i++) {

            dakuhiKetSaisinKetKekkaCdLst.add(C_Ketkekkacd.BLNK);
            dakuhiKetSaisinKetteiMdLst.add("0000");
        }

        int kensuu = 0;

        for (int n = 0; n < pDakuhiketteiLst.size(); n++) {

            HT_DakuhiKettei dakuhiKettei = pDakuhiketteiLst.get(n);

            saisinKetkekkaCd = dakuhiKettei.getKetkekkacd();
            saisinTorikesiSyousaiRiyuuCd = dakuhiKettei.getTorikesisyousairiyuucd();
            saisinPalKetsyaCd = dakuhiKettei.getPalketsyacd();

            if (C_DakuhiktbunruiKbn.DAKUHIKETTEI.eq(dakuhiKettei.getDakuhiktbunruikbn())) {
                dakuhiKetSaisinKetKekkaCd = dakuhiKettei.getKetkekkacd();
                dakuhiKetSaisinKetteiYmd = dakuhiKettei.getKetymd();
                dakuhiKetSaisinKetKekkaCd1 = dakuhiKettei.getKetriyuucd1();
                dakuhiKetSaisinKetKekkaCd2 = dakuhiKettei.getKetriyuucd2();
                dakuhiKetSaisinKetKekkaCd3 = dakuhiKettei.getKetriyuucd3();
                dakuhiKetSaisinKetKekkaCd4 = dakuhiKettei.getKetriyuucd4();
                kensuu = kensuu + 1;

                if (kensuu <= 6) {
                    dakuhiKetSaisinKetKekkaCdLst.set(kensuu - 1, dakuhiKettei.getKetkekkacd());
                    dakuhiKetSaisinKetteiMdLst.set(kensuu - 1, dakuhiKettei.getKetymd().getBizDateMD().toString());
                }
            }
        }
    }

    public String editMosSyoumetuKbn(C_SeirituKbn pSeiritukbn, C_Ketkekkacd pKetKekkaCd) {

        String mosSyoumetuKbn = "";

        if (C_SeirituKbn.SEIRITU.eq(pSeiritukbn)) {

            mosSyoumetuKbn = "1";
        }

        else if (C_SeirituKbn.HUSEIRITU.eq(pSeiritukbn) &&
            C_Ketkekkacd.MIAWASE.eq(pKetKekkaCd)) {

            mosSyoumetuKbn = "2";
        }

        else if (C_SeirituKbn.HUSEIRITU.eq(pSeiritukbn) &&
            (C_Ketkekkacd.ENKI_SIJINASI.eq(pKetKekkaCd) ||
                C_Ketkekkacd.ENKI_SUUNENGOSAISIN.eq(pKetKekkaCd))) {

            mosSyoumetuKbn = "3";
        }

        else if (C_SeirituKbn.HUSEIRITU.eq(pSeiritukbn) &&
            (C_Ketkekkacd.COOLINGOFF.eq(pKetKekkaCd) ||
                C_Ketkekkacd.MOS_TORIKESI.eq(pKetKekkaCd))) {

            mosSyoumetuKbn = "4";
        }

        else if (C_SeirituKbn.HUSEIRITU.eq(pSeiritukbn) && C_Ketkekkacd.YUUKOUKKNKKA.eq(pKetKekkaCd)) {

            mosSyoumetuKbn = "5";
        }

        else {

            mosSyoumetuKbn = "0";
        }

        return mosSyoumetuKbn;
    }

    public String editDakuhiKtkekkaCd(C_Ketkekkacd pKetKekkaCd) {

        String dakuhiKtkekkaCd = "";

        if (C_Ketkekkacd.MUJYOUKEN.eq(pKetKekkaCd)) {

            dakuhiKtkekkaCd = "10";
        }

        else if (C_Ketkekkacd.GENKAITAI_SYOUDAKU.eq(pKetKekkaCd)) {

            dakuhiKtkekkaCd = "13";
        }

        else if (C_Ketkekkacd.ENKI_SIJINASI.eq(pKetKekkaCd)) {

            dakuhiKtkekkaCd = "70";
        }

        else if (C_Ketkekkacd.ENKI_SUUNENGOSAISIN.eq(pKetKekkaCd)) {

            dakuhiKtkekkaCd = "75";
        }

        else if (C_Ketkekkacd.MIAWASE.eq(pKetKekkaCd)) {

            dakuhiKtkekkaCd = "80";
        }

        else {

            dakuhiKtkekkaCd = "";
        }

        return dakuhiKtkekkaCd;
    }

    public String editHrkKeiroKbn(C_Hrkkeiro pHrkKeiro, C_Hrkkaisuu pHrkKaisuu) {

        String hrkKeiroKbn = "";

        if (C_Hrkkeiro.KOUHURI.eq(pHrkKeiro)) {
            hrkKeiroKbn = "1";
        }

        else if (C_Hrkkeiro.DANTAI.eq(pHrkKeiro)) {
            hrkKeiroKbn = "2";
        }

        else if (C_Hrkkeiro.HURIKAE.eq(pHrkKeiro)) {
            hrkKeiroKbn = "4";
        }

        else if (C_Hrkkeiro.SYUUDAN.eq(pHrkKeiro)) {
            hrkKeiroKbn = "6";
        }

        else if (C_Hrkkeiro.CREDIT.eq(pHrkKeiro)) {
            hrkKeiroKbn = "8";
        }

        else if (C_Hrkkeiro.BLNK.eq(pHrkKeiro) && C_Hrkkaisuu.ITIJI.eq(pHrkKaisuu)) {
            hrkKeiroKbn = " ";
        }

        else {
            hrkKeiroKbn = " ";
        }

        return hrkKeiroKbn;
    }

    public String editHrkKeiroKbnSyuudanCreditHkm(C_Hrkkeiro pHrkKeiro, C_Hrkkaisuu pHrkKaisuu) {

        String hrkKeiroKbn = "";

        if (C_Hrkkeiro.KOUHURI.eq(pHrkKeiro)) {
            hrkKeiroKbn = "1";
        }

        else if (C_Hrkkeiro.DANTAI.eq(pHrkKeiro)) {
            hrkKeiroKbn = "2";
        }

        else if (C_Hrkkeiro.HURIKAE.eq(pHrkKeiro)) {
            hrkKeiroKbn = "4";
        }

        else if (C_Hrkkeiro.SYUUDAN.eq(pHrkKeiro)) {
            hrkKeiroKbn = "6";
        }

        else if (C_Hrkkeiro.CREDIT.eq(pHrkKeiro)) {
            hrkKeiroKbn = "6";
        }

        else if (C_Hrkkeiro.BLNK.eq(pHrkKeiro) && C_Hrkkaisuu.ITIJI.eq(pHrkKaisuu)) {
            hrkKeiroKbn = " ";
        }

        else {
            hrkKeiroKbn = " ";
        }

        return hrkKeiroKbn;
    }

    public String editKykKakjkKbn1(
        C_KykkakjkKbn pKykkakjkKbn,
        C_SeirituKbn pSeirituKbn,
        C_UmuKbn pKakukiSyouryakuKbumuKbn) {

        String kykKakjkKbn1 = "";

        if (C_KykkakjkKbn.KAKUNIN_SUMI.eq(pKykkakjkKbn)) {

            kykKakjkKbn1 = "4";
        }

        else if (C_KykkakjkKbn.SEIRITUGO_KAK_IRAISU.eq(pKykkakjkKbn)) {

            kykKakjkKbn1 = "2";
        }

        else if ((C_KykkakjkKbn.KETMAE_KAKUNIN.eq(pKykkakjkKbn) ||
            C_KykkakjkKbn.KETHORYU_KAKUNIN.eq(pKykkakjkKbn)) && C_SeirituKbn.HUSEIRITU.eq(pSeirituKbn)) {

            kykKakjkKbn1 = "4";
        }

        else if ((C_KykkakjkKbn.KETMAE_KAKUNIN.eq(pKykkakjkKbn) ||
            C_KykkakjkKbn.KETHORYU_KAKUNIN.eq(pKykkakjkKbn)) &&
            !C_SeirituKbn.HUSEIRITU.eq(pSeirituKbn) &&
            C_UmuKbn.ARI.eq(pKakukiSyouryakuKbumuKbn)) {

            kykKakjkKbn1 = "3";
        }

        else if ((C_KykkakjkKbn.KETMAE_KAKUNIN.eq(pKykkakjkKbn) ||
            C_KykkakjkKbn.KETHORYU_KAKUNIN.eq(pKykkakjkKbn)) &&
            !C_SeirituKbn.HUSEIRITU.eq(pSeirituKbn) &&
            !C_UmuKbn.ARI.eq(pKakukiSyouryakuKbumuKbn)) {

            kykKakjkKbn1 = "2";
        }

        else {

            kykKakjkKbn1 = "0";
        }

        return kykKakjkKbn1;
    }

    public String editNyknJkKbn(C_UmuKbn pNyknnrkumu, BizDate pRyosyuYmd, BizDateYM pMosYm) {

        String nyknJkKbn = "";

        if (C_UmuKbn.NONE.eq(pNyknnrkumu)) {
            nyknJkKbn = "0";
        }
        else {
            if (BizDateUtil.compareYmd(pRyosyuYmd, pMosYm.getLastDay()) == BizDateUtil.COMPARE_EQUAL
                || BizDateUtil.compareYmd(pRyosyuYmd, pMosYm.getLastDay()) == BizDateUtil.COMPARE_LESSER) {

                nyknJkKbn = "1";
            }
            else if (BizDateUtil.compareYmd(pRyosyuYmd, pMosYm.getLastDay()) == BizDateUtil.COMPARE_GREATER) {
                nyknJkKbn = "2";
            }
        }

        return nyknJkKbn;
    }

    public void getSyuEntity(List<HT_MosSyouhn> pMosSyouhnLst) {
        mosSyouhn = null;
        syouhnZokusei = null;
        for (int n = 0; n < pMosSyouhnLst.size(); n++) {

            if (C_SyutkKbn.SYU.eq(pMosSyouhnLst.get(n).getSyutkkbn())) {

                mosSyouhn = pMosSyouhnLst.get(n);
                syouhnZokusei = mosSyouhn.getSyouhnZokusei();

                break;
            }
        }
    }

    public String editBosyuuDairitenAtkiKeitaiKbn(List<HT_MosDairiten> pMosDairitenLst) {

        String bsDrtAtkiKtKbn = "";

        if (pMosDairitenLst.size() == 2) {

            bsDrtAtkiKtKbn = "1";

            for (HT_MosDairiten mosDairiten : pMosDairitenLst) {

                if (mosDairiten.getRenno() == 2 && !BizUtil.isBlank(mosDairiten.getBosyuucd())) {

                    bsDrtAtkiKtKbn = "3";

                    return bsDrtAtkiKtKbn;
                }
            }
        }
        else if (pMosDairitenLst.size() == 0) {

            bsDrtAtkiKtKbn = "0";
        }
        else {

            bsDrtAtkiKtKbn = "1";
        }

        return bsDrtAtkiKtKbn;
    }

    public String editHhknnen(int pHhknNen) {

        String hhknNen = "";

        if (pHhknNen < 100) {

            hhknNen = Strings.padStart(String.valueOf(pHhknNen), 2, '0');
        }
        else {

            hhknNen = "99";
        }

        return hhknNen;
    }

    public String editToukeiyouSinsaKbn(C_SntkhouKbn pSntkhoukbn) {

        String toukeiyouSinsaKbn = "";

        if (C_SntkhouKbn.KKT.eq(pSntkhoukbn) || C_SntkhouKbn.SYOKUGYOU.eq(pSntkhoukbn)) {

            toukeiyouSinsaKbn = "10";
        }

        else if (C_SntkhouKbn.NONE.eq(pSntkhoukbn)) {

            toukeiyouSinsaKbn = "14";
        }

        else if (C_SntkhouKbn.HJY.eq(pSntkhoukbn)) {

            toukeiyouSinsaKbn = "00";
        }

        else {
            toukeiyouSinsaKbn = "00";
        }

        return toukeiyouSinsaKbn;
    }

    public String editHjykktKbn(C_SntkhouKbn pSntkhoukbn) {

        String hjykktKbn = "";

        if (C_SntkhouKbn.HJY.eq(pSntkhoukbn)) {
            hjykktKbn = "1";
        }
        else {
            hjykktKbn = "2";
        }

        return hjykktKbn;
    }

    public String editFstpNyknHouhouKbn(C_UmuKbn pNyknnrkumu, C_FstphrkkeiroKbn pFstphrkkeirokbn) {

        String fstpNyknHouhouKbn = "";

        if (C_UmuKbn.ARI.eq(pNyknnrkumu) &&
            C_FstphrkkeiroKbn.CREDIT.eq(pFstphrkkeirokbn)) {

            fstpNyknHouhouKbn = "8";
        }
        else {
            fstpNyknHouhouKbn = "0";
        }

        return fstpNyknHouhouKbn;
    }

    public String editSinfstpNyknHouhouKbn(C_UmuKbn pNyknnrkumu) {

        String sinfstpNyknHouhouKbn = "";

        if (C_UmuKbn.ARI.eq(pNyknnrkumu)) {

            sinfstpNyknHouhouKbn = "08";
        }
        else {
            sinfstpNyknHouhouKbn = "00";
        }

        return sinfstpNyknHouhouKbn;
    }

    public void editHknkkn(HT_MosKihon pMosKihon, HT_MosSyouhn pMosSyouhn, BM_SyouhnZokusei pSyouhnZokusei) {

        hknKkn = "00";
        saiMnkKykHyj = "0";
        hrkkkn = "00";
        long wkHknkkn = 0;
        String wkSaiMnkKykHyj = "0";

        if (pMosKihon == null) {
            return;
        }
        else if (pMosSyouhn == null) {
            return;
        }
        else if (pSyouhnZokusei == null) {
            return;
        }

        int wkHrkkkn = pMosSyouhn.getHrkkkn();

        if (C_UmuKbn.ARI.eq(pSyouhnZokusei.getNkhknumu())) {

            EditNenkinKoumokuUtil editNenkinKoumokuUtil = SWAKInjector.getInstance(EditNenkinKoumokuUtil.class);
            C_ErrorKbn errorKbn = editNenkinKoumokuUtil.editNenkinSiharaiKaisiNenrei(
                pMosSyouhn.getHknkkn(), pMosSyouhn.getHknkknsmnkbn(), pMosKihon.getHhknnen());

            if (C_ErrorKbn.OK.eq(errorKbn)) {
                wkHknkkn = editNenkinKoumokuUtil.getNenkinSiharaiKaisiNenrei();
                wkSaiMnkKykHyj = "1";
            }
        }
        else {
            wkHknkkn = pMosSyouhn.getHknkkn();

            if(C_HknkknsmnKbn.SAIMANKI.eq(pMosSyouhn.getHknkknsmnkbn())){
                wkSaiMnkKykHyj = "1";
            }
        }

        if (wkHrkkkn != 0) {

            if ("1".equals(wkSaiMnkKykHyj) && C_HrkkknsmnKbn.NENMANKI.eq(pMosSyouhn.getHrkkknsmnkbn())) {

                wkHrkkkn = pMosSyouhn.getHrkkkn() + pMosKihon.getHhknnen();
            }
            else if ("0".equals(wkSaiMnkKykHyj) && C_HrkkknsmnKbn.SAIMANKI.eq(pMosSyouhn.getHrkkknsmnkbn())) {

                wkHrkkkn = pMosSyouhn.getHrkkkn() - pMosKihon.getHhknnen();
            }
        }

        hknKkn = editKetasuuShiteiZeroUme(wkHknkkn, 2);
        saiMnkKykHyj = wkSaiMnkKykHyj;
        hrkkkn = editKetasuuShiteiZeroUme(wkHrkkkn, 2);

    }

    public String editKyknmkj(C_KykKbn pKykKbn, String pHhknnmkj, String pKyknmkj, int pMaxNum) {

        String kyknmKj = "";

        if (C_KykKbn.KEIHI_BETU.eq(pKykKbn)) {
            if (pKyknmkj.length() <= pMaxNum) {

                kyknmKj = pKyknmkj;
            }
            else {

                kyknmKj = pKyknmkj.substring(0, pMaxNum);
            }

        }
        else {
            if (pHhknnmkj.length() <= pMaxNum) {

                kyknmKj = pHhknnmkj;
            }
            else {

                kyknmKj = pHhknnmkj.substring(0, pMaxNum);
            }

        }

        return kyknmKj;
    }

    public String editKyknmkn(C_KykKbn pKykKbn, String pHhknnmkn, String pKyknmkn, int pMaxNum) {

        String kyknmKn = "";

        if (C_KykKbn.KEIHI_BETU.eq(pKykKbn)) {
            kyknmKn = pKyknmkn;
        }
        else {
            kyknmKn = pHhknnmkn;
        }
        kyknmKn = editKanaHankakuLengthSpecified(kyknmKn, pMaxNum);

        return kyknmKn;
    }
    private String editKanaHankakuLengthSpecified(String pKanaNmZen, int pMaxNum) {
        String cnvKanaNmHan = ConvertUtil.convZenHan(IDataConvert.iCONVERT_Z2H_ALL, pKanaNmZen);
        if (cnvKanaNmHan.length() > pMaxNum) {
            cnvKanaNmHan = cnvKanaNmHan.substring(0, pMaxNum);
        }
        String cnvKanaNmZen = ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL, cnvKanaNmHan);

        return cnvKanaNmZen;
    }

    public String editKykSyaseiKbn(C_KykKbn pKykKbn, C_Hhknsei pHhknsei, C_Kyksei pKyksei) {

        String kykSyaseiKbn = "";

        if (C_KykKbn.KEIHI_BETU.eq(pKykKbn)) {

            if (C_Kyksei.MALE.eq(pKyksei)) {

                kykSyaseiKbn = "1";
            }

            else if (C_Kyksei.FEMALE.eq(pKyksei)) {

                kykSyaseiKbn = "2";
            }

            else {

                kykSyaseiKbn = "0";
            }
        }

        else {

            if (C_Hhknsei.MALE.eq(pHhknsei)) {

                kykSyaseiKbn = "1";
            }

            else if (C_Hhknsei.FEMALE.eq(pHhknsei)) {

                kykSyaseiKbn = "2";
            }

            else {

                kykSyaseiKbn = "0";
            }
        }

        return kykSyaseiKbn;
    }

    public String editKyksyanen2Keta(C_KykKbn pKykKbn, int pHhknNen, int pKyknen) {

        String kyksyaNen2Keta = "";

        if (C_KykKbn.KEIHI_BETU.eq(pKykKbn)) {

            if (pKyknen < 100) {

                kyksyaNen2Keta = Strings.padStart(String.valueOf(pKyknen), 2, '0');
            }

            else {

                kyksyaNen2Keta = "99";
            }
        }

        else {
            if (pHhknNen < 100) {

                kyksyaNen2Keta = Strings.padStart(String.valueOf(pHhknNen), 2, '0');
            }

            else {

                kyksyaNen2Keta = "99";
            }
        }

        return kyksyaNen2Keta;
    }

    public String editNyknzumiHyouji(C_UmuKbn pMosnrkUmu, C_UmuKbn pNyknnrkUmu) {

        String nyknzumiHyouji = "";

        if (C_UmuKbn.ARI.eq(pMosnrkUmu) && C_UmuKbn.ARI.eq(pNyknnrkUmu)) {

            nyknzumiHyouji = "1";
        }

        else {

            nyknzumiHyouji = "0";
        }

        return nyknzumiHyouji;
    }

    public String editTkariHyouji(C_Tkhukaumu pTkhukaUmu) {

        String tkariHyouji = "";

        if (C_Tkhukaumu.HUKA.eq(pTkhukaUmu)) {

            tkariHyouji = "1";
        }
        else {

            tkariHyouji = "0";
        }

        return tkariHyouji;
    }

    public String editTuukaKbn(C_Tuukasyu pTuukasyu) {

        String tuukaKbn = "";

        if (C_Tuukasyu.USD.eq(pTuukasyu)) {

            tuukaKbn = "1";
        }
        else if (C_Tuukasyu.EUR.eq(pTuukasyu)) {

            tuukaKbn = "2";
        }
        else if (C_Tuukasyu.AUD.eq(pTuukasyu)) {
            tuukaKbn = "3";
        }
        else {
            tuukaKbn = "0";
        }

        return tuukaKbn;
    }

    public String editSyokenSakuseiYmd(C_SeirituKbn pSeiritukbn, BizDate pSeirituSyoriYmd) {

        String syoukenSakuseiYmd = "";

        if (C_SeirituKbn.SEIRITU.eq(pSeiritukbn)) {
            syoukenSakuseiYmd = pSeirituSyoriYmd.toString();
        }

        else {
            syoukenSakuseiYmd = "00000000";
        }

        return syoukenSakuseiYmd;
    }

    public BizDate getEnknsnKijyunYmd(C_Tuukasyu pTuukasyu, BizDate pRyosyuYmd, BizDate pMosYmd) {

        BizDate enknsnKijyunYmd;

        if (C_Tuukasyu.JPY.eq(pTuukasyu)) {

            enknsnKijyunYmd = null;
        }

        else {

            if (pRyosyuYmd != null) {

                enknsnKijyunYmd = pRyosyuYmd;
            }

            else {

                enknsnKijyunYmd = pMosYmd;
            }
        }

        return enknsnKijyunYmd;
    }

    public BizNumber getEnknsnKawaseRate(C_Tuukasyu pTuukasyu, BizDate pYenKasaKijyuYmd, C_Hrkkaisuu pHrkKaisuu,
        C_UmuKbn pZennouMousideUmu, C_IkkatubaraiKbn pIkkatubaraiKbn) {

        BizNumber enknsnKawaseRate = BizNumber.ZERO;
        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

        if (C_Tuukasyu.JPY.eq(pTuukasyu)) {

            enknsnKawaseRate = BizNumber.ZERO;
        }

        else {

            C_ErrorKbn errorKbn = getKawaseRate.execHyoukagk(pYenKasaKijyuYmd,
                pTuukasyu,
                C_Tuukasyu.JPY,
                C_YouhiKbn.YOU,
                pHrkKaisuu,
                pZennouMousideUmu,
                pIkkatubaraiKbn);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                throw new CommonBizAppException(
                    "評価額算出用為替レート取得に失敗しました。領収日："+ pYenKasaKijyuYmd
                    + "　元通貨：" + pTuukasyu.getContent()
                    + "　換算通貨：" + C_Tuukasyu.JPY.getContent()
                    + "　前営業日為替レート取得要否：" + C_YouhiKbn.YOU.getContent()
                    + "　払込回数：" + pHrkKaisuu.getContent()
                    + "　前納申出有無：" + pZennouMousideUmu.getContent()
                    + "　一括払区分：" + pIkkatubaraiKbn.getContent());
            }

            enknsnKawaseRate = getKawaseRate.getKawaserate();
        }

        return enknsnKawaseRate;
    }

    public BizNumber getSyksbEnknsnKawaseRate(C_Tuukasyu pTuukasyu, BizDate pYenknsnKijyuYmd, C_Hrkkaisuu pHrkKaisuu,
        C_UmuKbn pZennouMousideUmu, C_IkkatubaraiKbn pIkkatubaraiKbn) {

        BizNumber yenknsnKawaseRate = BizNumber.ZERO;
        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

        if (C_Tuukasyu.JPY.eq(pTuukasyu)) {

            yenknsnKawaseRate = BizNumber.ZERO;
        }
        else {

            C_ErrorKbn errorKbn = getKawaseRate.execFstPNyuukin(pYenknsnKijyuYmd,
                pTuukasyu,
                C_Tuukasyu.JPY,
                C_YouhiKbn.YOU,
                pHrkKaisuu,
                C_SysKbn.SKEI,
                pZennouMousideUmu,
                pIkkatubaraiKbn);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                throw new CommonBizAppException(
                    "初回Ｐ入金用為替レート取得に失敗しました。領収日：" + pYenknsnKijyuYmd
                    + "　契約通貨：" + pTuukasyu.getContent()
                    + "　払込通貨：" + C_Tuukasyu.JPY.getContent()
                    + "　前営業日為替レート取得要否：" + C_YouhiKbn.YOU.getContent()
                    + "　払込回数：" + pHrkKaisuu.getContent()
                    + "　システム区分：" + C_SysKbn.SKEI.getContent()
                    + "　前納申出有無：" + pZennouMousideUmu.getContent()
                    + "　一括払区分：" + pIkkatubaraiKbn.getContent());
            }

            yenknsnKawaseRate = getKawaseRate.getKawaserate();
        }

        return yenknsnKawaseRate;
    }

    public String editKetasuuShiteiZeroUme(long pHknkkn, int pKetasuu) {

        String henkangoMoziretu = null;

        if (pHknkkn < 0) {
            henkangoMoziretu = Strings.padStart("", pKetasuu, '0');
        }
        else {
            if (String.valueOf(pHknkkn).length() > pKetasuu) {
                henkangoMoziretu = Strings.padStart("", pKetasuu, '9');
            }
            else {
                henkangoMoziretu = Strings.padStart(String.valueOf(pHknkkn), pKetasuu, '0');
            }
        }
        return henkangoMoziretu;
    }

    public String editSisyaketteiYmd(HT_SyoriCTL pSyoriCTL) {

        String sisyaketteiYmd = null;

        if (C_MostenkenjyouKbn.MOSTENKEN_ZUMI.eq(pSyoriCTL.getMostenkenjoukbn())) {

            HT_MostenkenRireki mostenkenRireki = sinkeiyakuDomManager.getMostenkenRirekiByMosnoKanryouMaxRenno(pSyoriCTL.getMosno());

            if (mostenkenRireki != null) {
                sisyaketteiYmd = String.valueOf(mostenkenRireki.getSyoriYmd());
            }
            else {
                sisyaketteiYmd = String.valueOf(pSyoriCTL.getMosnrkymd());
            }
        }
        else if (C_MostenkenyhKbn.HUYOU.eq(pSyoriCTL.getMostenken1jiyhkbn())
            && C_MostenkenyhKbn.HUYOU.eq(pSyoriCTL.getMostenken2jiyhkbn())
            && C_MostenkenjyouKbn.NONE.eq(pSyoriCTL.getMostenkenjoukbn())) {

            sisyaketteiYmd = String.valueOf(pSyoriCTL.getMosnrkymd());
        }
        else {
            sisyaketteiYmd = "00000000";
        }

        return sisyaketteiYmd;
    }

    public String editHrkkaisuu(HT_MosKihon pMosKihon) {

        String hrkkaisuu = null;

        if (C_Hrkkaisuu.TUKI.eq(pMosKihon.getHrkkaisuu())) {

            if (C_IkkatubaraiKbn.TEIKIIKKATU.eq(pMosKihon.getIkkatubaraikbn())) {

                if (C_IkkatubaraiKaisuuKbn.IKKATU6.eq(pMosKihon.getIkkatubaraikaisuu())) {

                    hrkkaisuu = "2";
                }
                else if (C_IkkatubaraiKaisuuKbn.IKKATU12.eq(pMosKihon.getIkkatubaraikaisuu())) {

                    hrkkaisuu = "1";
                }
                else {
                    hrkkaisuu = "3";
                }
            }
            else {
                hrkkaisuu = "3";
            }
        }
        else if (C_Hrkkaisuu.HALFY.eq(pMosKihon.getHrkkaisuu())) {

            hrkkaisuu = "2";
        }
        else if (C_Hrkkaisuu.NEN.eq(pMosKihon.getHrkkaisuu())) {

            hrkkaisuu = "1";
        }
        else {
            hrkkaisuu = "0";
        }

        return hrkkaisuu;
    }

    public int getKeisanHrkkaisuu(C_Hrkkaisuu hrkkaisuu) {

        int keisanHrkkaisuu;

        if (C_Hrkkaisuu.TUKI.eq(hrkkaisuu)) {

            keisanHrkkaisuu = 1;
        }
        else if (C_Hrkkaisuu.HALFY.eq(hrkkaisuu)) {

            keisanHrkkaisuu = 6;
        }
        else if (C_Hrkkaisuu.NEN.eq(hrkkaisuu)) {

            keisanHrkkaisuu = 12;
        }
        else {
            keisanHrkkaisuu = 1;
        }

        return keisanHrkkaisuu;
    }

    public String editRyourituKbn(C_Hrkkeiro hrkkeiro, C_DntryourituKbn dntryourituKbn) {

        String ryourituKbn;

        if (C_Hrkkeiro.KOUHURI.eq(hrkkeiro)) {
            ryourituKbn = "3";
        }
        else if (C_Hrkkeiro.DANTAI.eq(hrkkeiro)) {
            if (C_DntryourituKbn.A.eq(dntryourituKbn)) {
                ryourituKbn = "1";
            }
            else if (C_DntryourituKbn.B.eq(dntryourituKbn)) {
                ryourituKbn = "2";
            }
            else {
                ryourituKbn = "0";
            }
        }
        else if (C_Hrkkeiro.SYUUDAN.eq(hrkkeiro)) {
            ryourituKbn = "4";
        }
        else if (C_Hrkkeiro.CREDIT.eq(hrkkeiro)) {
            ryourituKbn = "5";
        }
        else {
            ryourituKbn = "0";
        }

        return ryourituKbn;
    }

    public String editNenkinsyu(C_Sknenkinsyu sknenkinsyu) {

        String nenkinsyu;

        if (C_Sknenkinsyu.KKTI5.eq(sknenkinsyu)) {
            nenkinsyu = "1";
        }
        else if (C_Sknenkinsyu.KKTI10.eq(sknenkinsyu)) {
            nenkinsyu = "2";
        }
        else if (C_Sknenkinsyu.KKTI15.eq(sknenkinsyu)) {
            nenkinsyu = "3";
        }
        else if (C_Sknenkinsyu.SGKHSYSYSN.eq(sknenkinsyu)) {
            nenkinsyu = "8";
        }
        else if (C_Sknenkinsyu.KKTI5DAI1BAIGAKU.eq(sknenkinsyu)) {
            nenkinsyu = "A";
        }
        else {
            nenkinsyu = "0";
        }

        return nenkinsyu;
    }

    public String getToukeiHokensyuruiKbn(BM_SyouhnZokusei pSyouhnZokusei, HT_MosKihon pMosKihon) {

        String toukeiHokensyuruiKbn;

        int syohinHanteiKbn = SyouhinUtil.hantei(pSyouhnZokusei.getSyouhncd());

        if (SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == syohinHanteiKbn) {
            if (C_TumitatekinHaibunWariKbn.WARIAI100.eq(pMosKihon.getTeirituhaibunwarikbn()) &&
                C_TumitatekinHaibunWariKbn.WARIAI000.eq(pMosKihon.getSisuuhaibunwarikbn())) {
                toukeiHokensyuruiKbn = "10";
            }
            else {
                toukeiHokensyuruiKbn = pSyouhnZokusei.getToukeiyouhokensyuruikbn();
            }
        }
        else if (SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 == syohinHanteiKbn) {

            if (C_Tkhukaumu.HUKA.eq(pMosKihon.getTeikisiharaitkykhkkbn())) {
                toukeiHokensyuruiKbn = pSyouhnZokusei.getToukeiyouhokensyuruikbn();
            }
            else {
                if (C_TumitatekinHaibunWariKbn.WARIAI100.eq(pMosKihon.getTeirituhaibunwarikbn()) &&
                    C_TumitatekinHaibunWariKbn.WARIAI000.eq(pMosKihon.getSisuuhaibunwarikbn())) {
                    toukeiHokensyuruiKbn = "M2";
                }
                else {
                    toukeiHokensyuruiKbn = pSyouhnZokusei.getToukeiyouhokensyuruikbn();
                }
            }
        }
        else if (SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN == syohinHanteiKbn) {

            if (C_Tuukasyu.USD.eq(pMosKihon.getKyktuukasyu())) {

                toukeiHokensyuruiKbn = "M5";
            }
            else {
                toukeiHokensyuruiKbn = pSyouhnZokusei.getToukeiyouhokensyuruikbn();
            }
        }
        else {
            toukeiHokensyuruiKbn = pSyouhnZokusei.getToukeiyouhokensyuruikbn();
        }

        return toukeiHokensyuruiKbn;
    }

    public String getKzktrkServiceKbn(HT_SyoriCTL pSyoriCTL) {

        String kzktrkServiceKbn;

        List<HT_MosTrkKzk> mosTrkKzkLst = pSyoriCTL.getMosTrkKzks();

        if (mosTrkKzkLst.size() == 0) {

            kzktrkServiceKbn = "0";
        }
        else if (mosTrkKzkLst.size() == 1) {

            kzktrkServiceKbn = "1";
        }
        else if (mosTrkKzkLst.size() == 2) {

            kzktrkServiceKbn = "2";
        }
        else {

            kzktrkServiceKbn = "0";
        }

        return kzktrkServiceKbn;
    }

    public String getKzkTuutiTyokusouKbn(HT_SyoriCTL pSyoriCTL) {

        List<HT_MosTrkKzk> mosTrkKzkLst = pSyoriCTL.getMosTrkKzks();

        HT_MosKihon mosKihon = pSyoriCTL.getMosKihon();

        C_TsindousiteiKbn[] tsindousiteiKbn = new C_TsindousiteiKbn[2];
        String trkkzkadr = null;

        String tsinAdr = mosKihon.getTsinadr1kj() + mosKihon.getTsinadr2kj() + mosKihon.getTsinadr3kj();

        for (int i = 0; i < mosTrkKzkLst.size(); i++) {

            HT_MosTrkKzk mosTrkKzk = mosTrkKzkLst.get(i);

            trkkzkadr = mosTrkKzk.getTrkkzkadr1kj() + mosTrkKzk.getTrkkzkadr2kj() + mosTrkKzk.getTrkkzkadr3kj();

            if (C_TsindousiteiKbn.BLNK.eq(mosTrkKzk.getTrkkzktsindousiteikbn()) &&
                ((!BizUtil.isBlank(mosKihon.getTsinyno()) &&
                    !BizUtil.isBlank(mosTrkKzk.getTrkkzkyno()) &&
                    !BizUtil.isBlank(tsinAdr) &&
                    !BizUtil.isBlank(trkkzkadr)) &&
                    (!mosKihon.getTsinyno().equals(mosTrkKzk.getTrkkzkyno()) ||
                        !mosKihon.getTsinadr1kj().equals(mosTrkKzk.getTrkkzkadr1kj()) ||
                        !mosKihon.getTsinadr2kj().equals(mosTrkKzk.getTrkkzkadr2kj()) ||
                        !mosKihon.getTsinadr3kj().equals(mosTrkKzk.getTrkkzkadr3kj())))) {

                tsindousiteiKbn[i] = C_TsindousiteiKbn.BLNK;
            }
            else {

                tsindousiteiKbn[i] = C_TsindousiteiKbn.ARI;
            }

            trkkzkadr = "";
        }

        int kykNen = 0;

        if (C_KykKbn.KEIHI_BETU.eq(mosKihon.getKykkbn())) {

            kykNen = mosKihon.getKyknen();
        }
        else {

            kykNen = mosKihon.getHhknnen();
        }

        String kzkTuutiTyokusouKbn = "";

        if (kykNen >= 70) {

            if (C_TsindousiteiKbn.BLNK.eq(tsindousiteiKbn[0])) {

                if (C_TsindousiteiKbn.BLNK.eq(tsindousiteiKbn[1])) {

                    kzkTuutiTyokusouKbn = "3";
                }
                else {

                    kzkTuutiTyokusouKbn = "1";
                }
            }
            else if (C_TsindousiteiKbn.ARI.eq(tsindousiteiKbn[0])) {

                if (C_TsindousiteiKbn.BLNK.eq(tsindousiteiKbn[1])) {

                    kzkTuutiTyokusouKbn = "2";
                }
                else {

                    kzkTuutiTyokusouKbn = "9";
                }
            }
        }

        return kzkTuutiTyokusouKbn;
    }

    public BizNumber getNknsnPssyKwsRate(C_Tuukasyu pTuukasyu, C_Tuukasyu pHrkTuukasyu, BizDate pYenknsnKijyuYmd,
        C_Hrkkaisuu pHrkKaisuu, C_UmuKbn pZennouMousideUmu, C_IkkatubaraiKbn pIkkatubaraiKbn) {

        BizNumber yenknsnKawaseRate = BizNumber.ZERO;
        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

        if (C_Tuukasyu.JPY.eq(pTuukasyu)) {

            yenknsnKawaseRate = BizNumber.ZERO;
        }
        else {

            if (C_Tuukasyu.JPY.eq(pHrkTuukasyu)) {

                C_ErrorKbn errorKbn = getKawaseRate.execFstPNyuukin(
                    pYenknsnKijyuYmd,
                    pTuukasyu,
                    C_Tuukasyu.JPY,
                    C_YouhiKbn.HUYOU,
                    pHrkKaisuu,
                    C_SysKbn.SKEI,
                    pZennouMousideUmu,
                    pIkkatubaraiKbn);

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                    throw new CommonBizAppException(
                        "初回Ｐ入金用為替レート取得に失敗しました。領収日：" + pYenknsnKijyuYmd
                        + "　契約通貨：" + pTuukasyu.getContent()
                        + "　払込通貨：" + C_Tuukasyu.JPY.getContent()
                        + "　前営業日為替レート取得要否：" + C_YouhiKbn.HUYOU.getContent()
                        + "　払込回数：" + pHrkKaisuu.getContent()
                        + "　システム区分：" + C_SysKbn.SKEI.getContent()
                        + "　前納申出有無：" + pZennouMousideUmu.getContent()
                        + "　一括払区分：" + pIkkatubaraiKbn.getContent());
                }

                yenknsnKawaseRate = getKawaseRate.getKawaserate();
            }
            else {

                C_ErrorKbn errorKbn = getKawaseRate.execHyoukagk(
                    pYenknsnKijyuYmd,
                    pTuukasyu,
                    C_Tuukasyu.JPY,
                    C_YouhiKbn.HUYOU,
                    pHrkKaisuu,
                    pZennouMousideUmu,
                    pIkkatubaraiKbn);

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                    throw new CommonBizAppException(
                        "評価額算出用為替レート（契約時）取得に失敗しました。領収日：" + pYenknsnKijyuYmd
                        + "　元通貨：" + pTuukasyu.getContent()
                        + "　換算通貨：" + C_Tuukasyu.JPY.getContent()
                        + "　前営業日為替レート取得要否：" + C_YouhiKbn.HUYOU.getContent()
                        + "　払込回数：" + pHrkKaisuu.getContent()
                        + "　前納申出有無：" + pZennouMousideUmu.getContent()
                        + "　一括払区分：" + pIkkatubaraiKbn.getContent());
                }

                yenknsnKawaseRate = getKawaseRate.getKawaserate();
            }
        }

        return yenknsnKawaseRate;
    }
}
