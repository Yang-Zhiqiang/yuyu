package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzGetBankData;
import yuyu.common.biz.bzcommon.BzGetBankDataBean;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfo;
import yuyu.common.biz.bzcommon.BzHanteiSosikiUtil;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.bean.report.BzSksKaisyasiyouranBean;
import yuyu.def.classification.C_Kaiyakujiyuu;
import yuyu.def.classification.C_KeihiKbn;
import yuyu.def.classification.C_KhTyouhyoumsgbunruiKbn1;
import yuyu.def.classification.C_KhTyouhyoumsgbunruiKbn2;
import yuyu.def.classification.C_KhTyouhyoumsgbunruiKbn3;
import yuyu.def.classification.C_KihonssyuruiKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_KykdrknHtdjytKbn;
import yuyu.def.classification.C_KyksyaSibouUmuKbn;
import yuyu.def.classification.C_Meigihnkjiyuu;
import yuyu.def.classification.C_MousideninKbn;
import yuyu.def.classification.C_NengetuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TargetTkKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YouhiblnkKbn;
import yuyu.def.db.entity.AM_SyoruiZokusei;
import yuyu.def.db.entity.IM_KhTyouhyoumsg2;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KhTtdkTyuui;
import yuyu.def.db.entity.IT_Kouza;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.db.entity.IT_TeikikinKouza;
import yuyu.def.db.entity.IT_TrkKzk;
import yuyu.def.hozen.bean.report.KhSeikyuusyoBean;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;

import com.google.common.base.Strings;

/**
 * 契約保全 契約保全共通 請求書TBL編集
 */
public class EditSeikyuusyoTbl {

    @Inject
    private CreateReport createReport;

    @Inject
    private BzGetBankData getBankData;

    @Inject
    private BaseDomManager baseDomManager;

    @Inject
    private HozenDomManager hozenDomManager;

    public EditSeikyuusyoTbl() {
        super();

    }

    public ReportServicesBean editBean(C_SyoruiCdKbn pSyoruiCd,
        String pSyoNo,
        KhozenCommonParam pKhozenCommonParam,
        EditSeikyuusyoParam pEditSeikyuusyoParam) {


        String categoryId = pKhozenCommonParam.getCategoryId();
        String kinouId = pKhozenCommonParam.getFunctionId();
        String stDrskNmKj = "";
        String kzMeigiNmKn = "";
        String hhknseiYMD = "";

        C_TargetTkKbn targettkKbn = C_TargetTkKbn.BLNK;
        int targettkMokuhyouti = 0;
        ArrayList<String> sbUktNmkjList = new ArrayList<>();
        ArrayList<BizNumber> sbUktBnwariList = new ArrayList<>();
        ArrayList<C_UmuKbn> sibousUktUmuKbnList = new ArrayList<>();
        ArrayList<C_UmuKbn> sbuBnwariUmuList = new ArrayList<>();
        String nenkinUktNmKanji = "";
        C_UmuKbn nkuktUmuKbn = C_UmuKbn.NONE;
        C_UmuKbn stDrSkUmuKbn = C_UmuKbn.NONE;
        String sbUktNmkn = "";
        C_UktKbn sbUktKbn = C_UktKbn.BLNK;
        C_UktKbn stDrUktKbn = C_UktKbn.BLNK;
        C_KeihiKbn ckeihiKbn = C_KeihiKbn.BLNK;
        String sosikiCd = pKhozenCommonParam.getTmSosikiCd();
        String tsinyno = "";
        String tsinadr1kj = "";
        String tsinadr2kj = "";
        String tsinadr3kj = "";
        String tsintelno = "";
        String trkkzknmknInfo1 = "";
        String trkkzknmkjInfo1 = "";
        C_KjkhukaKbn trkkzkKjkhukaKbn1 = C_KjkhukaKbn.BLNK;
        String trkkzkadr1kjInfo1 = "";
        String trkkzkadr2kjInfo1 = "";
        String trkkzkadr3kjInfo1 = "";
        String trkkzktelnoInfo1 = "";
        String trkkzknmknInfo2 = "";
        String trkkzknmkjInfo2 = "";
        C_KjkhukaKbn trkkzkKjkhukaKbn2 = C_KjkhukaKbn.BLNK;
        String trkkzkadr1kjInfo2 = "";
        String trkkzkadr2kjInfo2 = "";
        String trkkzkadr3kjInfo2 = "";
        String trkkzktelnoInfo2 = "";
        String kykdairinmkj = "";
        C_UktKbn kykdruktKbn = C_UktKbn.BLNK;
        GetKhKykdrInfoBean getKhKykdrInfoBean = SWAKInjector.getInstance(GetKhKykdrInfoBean.class);
        C_UmuKbn saikenSetUmu = C_UmuKbn.NONE;

        GetKhKykdrInfo getKhKykdrInfo = SWAKInjector.getInstance(GetKhKykdrInfo.class);

        IT_KykKihon kykKihon = pKhozenCommonParam.getKeiyakuKihon(pSyoNo);

        getKhKykdrInfoBean = getKhKykdrInfo.exec(kykKihon);
        kykdairinmkj = getKhKykdrInfoBean.getKkdairinmKj();
        kykdruktKbn = getKhKykdrInfoBean.getKykdruktKbn();

        IT_KhTtdkTyuui khTtdkTyuui = pKhozenCommonParam.getKkTetudukiTyuui(pSyoNo);


        kykKihon = pKhozenCommonParam.getKeiyakuKihon(pSyoNo);

        if (kykKihon == null) {
            throw new CommonBizAppException("契約基本TBLにデータが存在しません。");
        }

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        try {

            kykSya = pKhozenCommonParam.getKeiyakusya(pSyoNo);

            hhknSya = pKhozenCommonParam.getHihokensya(pSyoNo);
        } catch (RuntimeException e) {
            throw e;
        }

        if (kykSya == null || hhknSya == null) {
            throw new CommonBizAppException("契約者TBL、被保険者TBLにデータが存在しません。");
        }

        String kykNmKj = "";

        if (C_SyoruiCdKbn.KK_MEIGIHNK_SKS.eq(pSyoruiCd)) {
            if (BizUtil.isBlank(kykSya.getKyknmkj()) || C_KjkhukaKbn.KJKHUKA.eq(kykSya.getKyknmkjkhukakbn())) {
                kykNmKj = "";
            }
            else {
                kykNmKj = kykSya.getKyknmkj();
            }

        }
        else {
            if (C_KykdrknHtdjytKbn.SETTEI.eq(khTtdkTyuui.getKykdrknhatudoujyoutai())) {
                kykNmKj = getKhKykdrInfoBean.getKkdairinmKj();
            }
            else {
                kykNmKj = kykSya.getKyknmkj();
            }
        }

        String hhKnNmKj = hhknSya.getHhknnmkj();

        if (C_SyoruiCdKbn.KK_MEIGIHNK_SKS.eq(pSyoruiCd) &&
            (BizUtil.isBlank(hhKnNmKj) || C_KjkhukaKbn.KJKHUKA.eq(hhknSya.getHhknnmkjkhukakbn()))) {

            hhKnNmKj = "";
        }

        List<IT_TrkKzk> trkKzkLst = pKhozenCommonParam.getTrkKzk(pSyoNo);

        if (trkKzkLst != null) {
            for (IT_TrkKzk trkKzk : trkKzkLst) {
                if (C_TrkKzkKbn.TRKKZK1.eq(trkKzk.getTrkkzkkbn())) {
                    trkkzknmknInfo1 = trkKzk.getTrkkzknmkn();
                    trkkzknmkjInfo1 = trkKzk.getTrkkzknmkj();
                    trkkzkKjkhukaKbn1 = trkKzk.getTrkkzknmkjkhukakbn();
                    trkkzkadr1kjInfo1 = trkKzk.getTrkkzkadr1kj();
                    trkkzkadr2kjInfo1 = trkKzk.getTrkkzkadr2kj();
                    trkkzkadr3kjInfo1 = trkKzk.getTrkkzkadr3kj();
                    trkkzktelnoInfo1 = trkKzk.getTrkkzktelno();
                }
                else if (C_TrkKzkKbn.TRKKZK2.eq(trkKzk.getTrkkzkkbn())) {
                    trkkzknmknInfo2 = trkKzk.getTrkkzknmkn();
                    trkkzknmkjInfo2 = trkKzk.getTrkkzknmkj();
                    trkkzkKjkhukaKbn2 = trkKzk.getTrkkzknmkjkhukakbn();
                    trkkzkadr1kjInfo2 = trkKzk.getTrkkzkadr1kj();
                    trkkzkadr2kjInfo2 = trkKzk.getTrkkzkadr2kj();
                    trkkzkadr3kjInfo2 = trkKzk.getTrkkzkadr3kj();
                    trkkzktelnoInfo2 = trkKzk.getTrkkzktelno();
                }
            }
        }


        IT_KykUkt siteiDairiSeikyuunin = pKhozenCommonParam.getSiteiDairiSeikyuunin(pSyoNo);
        List<IT_KykUkt> sibouUketorininList = pKhozenCommonParam.getSibouUketorinin(pSyoNo);
        IT_KykUkt nenkinUketorinin = pKhozenCommonParam.getNenkinUketorinin(pSyoNo);

        int sibouUketorininSetteiCnt = 0;

        if (sibouUketorininList != null && sibouUketorininList.size() > 0) {

            sibouUketorininSetteiCnt = sibouUketorininList.size();
        }

        for (int index = 0; index < 4; index++) {

            if (index < sibouUketorininSetteiCnt) {

                sbUktBnwariList.add(sibouUketorininList.get(index).getUktbnwari());

                sibousUktUmuKbnList.add(C_UmuKbn.ARI);

                sbuBnwariUmuList.add(C_UmuKbn.ARI);

                if (C_UktKbn.KYK.eq(sibouUketorininList.get(index).getUktkbn())) {

                    sbUktNmkjList.add(kykNmKj);

                }
                else if (C_UktKbn.HHKN.eq(sibouUketorininList.get(index).getUktkbn())) {

                    sbUktNmkjList.add(hhKnNmKj);

                }
                else {
                    if (C_SyoruiCdKbn.KK_MEIGIHNK_SKS.eq(pSyoruiCd) &&
                        BizUtil.isBlank(sibouUketorininList.get(index).getUktnmkj()) ||
                        C_KjkhukaKbn.KJKHUKA.eq(sibouUketorininList.get(index).getUktnmkjkhukakbn())) {

                        sbUktNmkjList.add("");
                    }
                    else {

                        sbUktNmkjList.add(sibouUketorininList.get(index).getUktnmkj());
                    }
                }

                if (index == 0) {

                    sbUktKbn = sibouUketorininList.get(index).getUktkbn();

                    if (C_UktKbn.KYK.eq(sibouUketorininList.get(index).getUktkbn())) {

                        sbUktNmkn = kykSya.getKyknmkn();
                    }
                    else if (C_UktKbn.HHKN.eq(sibouUketorininList.get(index).getUktkbn())) {

                        sbUktNmkn = hhknSya.getHhknnmkn();
                    }
                    else {

                        sbUktNmkn = sibouUketorininList.get(index).getUktnmkn();
                    }
                }
            }
            else {

                sbUktNmkjList.add("");

                sbUktBnwariList.add(BizNumber.valueOf(0));

                sibousUktUmuKbnList.add(C_UmuKbn.NONE);

                sbuBnwariUmuList.add(C_UmuKbn.NONE);
            }
        }

        if (siteiDairiSeikyuunin != null) {

            C_KjkhukaKbn kjkhukaKbn = C_KjkhukaKbn.BLNK;

            if (C_UktKbn.KYK.eq(siteiDairiSeikyuunin.getUktkbn())) {

                stDrskNmKj = kykNmKj;

                stDrSkUmuKbn = C_UmuKbn.ARI;
            }
            else if (C_UktKbn.HHKN.eq(siteiDairiSeikyuunin.getUktkbn())) {

                stDrskNmKj = hhKnNmKj;

                stDrSkUmuKbn = C_UmuKbn.ARI;
            }
            else if (C_UktKbn.SBUK.eq(siteiDairiSeikyuunin.getUktkbn())) {

                stDrskNmKj = sbUktNmkjList.get(0);

                stDrSkUmuKbn = C_UmuKbn.ARI;
            }
            else if (C_UktKbn.TOUROKUKAZOKU1.eq(siteiDairiSeikyuunin.getUktkbn())) {

                stDrskNmKj = trkkzknmkjInfo1;

                kjkhukaKbn = trkkzkKjkhukaKbn1;

                stDrSkUmuKbn = C_UmuKbn.ARI;
            }
            else if (C_UktKbn.TOUROKUKAZOKU2.eq(siteiDairiSeikyuunin.getUktkbn())) {

                stDrskNmKj = trkkzknmkjInfo2;

                kjkhukaKbn = trkkzkKjkhukaKbn2;

                stDrSkUmuKbn = C_UmuKbn.ARI;
            }

            else {

                stDrskNmKj = siteiDairiSeikyuunin.getUktnmkj();

                kjkhukaKbn = siteiDairiSeikyuunin.getUktnmkjkhukakbn();

                stDrSkUmuKbn = C_UmuKbn.ARI;
            }

            stDrUktKbn = siteiDairiSeikyuunin.getUktkbn();

            if (C_SyoruiCdKbn.KK_MEIGIHNK_SKS.eq(pSyoruiCd) && C_KjkhukaKbn.KJKHUKA.eq(kjkhukaKbn)) {

                stDrskNmKj = "";
            }
        }

        if (nenkinUketorinin != null) {

            if (C_UktKbn.KYK.eq(nenkinUketorinin.getUktkbn())) {

                nenkinUktNmKanji = kykNmKj;

                nkuktUmuKbn = C_UmuKbn.ARI;
            }
            else if (C_UktKbn.HHKN.eq(nenkinUketorinin.getUktkbn())) {

                nenkinUktNmKanji = hhKnNmKj;

                nkuktUmuKbn = C_UmuKbn.ARI;
            }
            else {

                nenkinUktNmKanji = nenkinUketorinin.getUktnmkj();

                nkuktUmuKbn = C_UmuKbn.ARI;

                if (C_SyoruiCdKbn.KK_MEIGIHNK_SKS.eq(pSyoruiCd) &&
                    BizUtil.isBlank(nenkinUktNmKanji) ||
                    C_KjkhukaKbn.KJKHUKA.eq(nenkinUketorinin.getUktnmkjkhukakbn())) {

                    nenkinUktNmKanji = "";
                }
            }
        }

        if (C_SyoruiCdKbn.KK_MEIGIHNK_SKS.eq(pSyoruiCd)
            || (C_SyoruiCdKbn.KK_KAIYAKU_SKS.eq(pSyoruiCd)
                && C_Kaiyakujiyuu.KYKSB.eq(pEditSeikyuusyoParam.getKaiyakujiyuu()))) {

            tsinyno = kykSya.getTsinyno();
            tsinadr1kj = kykSya.getTsinadr1kj();
            tsinadr2kj = kykSya.getTsinadr2kj();
            tsinadr3kj = kykSya.getTsinadr3kj();
            tsintelno = kykSya.getTsintelno();
        }
        else {
            if (C_KykdrknHtdjytKbn.SETTEI.eq(khTtdkTyuui.getKykdrknhatudoujyoutai())) {
                tsinyno = getKhKykdrInfoBean.getKykdryNo();
                tsinadr1kj = getKhKykdrInfoBean.getKykdradr1();
                tsinadr2kj = getKhKykdrInfoBean.getKykdradr2();
                tsinadr3kj = getKhKykdrInfoBean.getKykdradr3();
                tsintelno = getKhKykdrInfoBean.getKykdrtelno();
            }
            else {
                tsinyno = kykSya.getTsinyno();
                tsinadr1kj = kykSya.getTsinadr1kj();
                tsinadr2kj = kykSya.getTsinadr2kj();
                tsinadr3kj = kykSya.getTsinadr3kj();
                tsintelno = kykSya.getTsintelno();
            }
        }


        String bankName = "";
        String sitenName = "";

        String bankCd = "";
        String sitenCd = "";
        String kouzaNo = "";
        C_YokinKbn yokinKbn = C_YokinKbn.BLNK;
        BizDate tyouhyouYMD = BizDate.getSysDate();

        if (C_SyoruiCdKbn.KK_SHRKZHNK_SKS.eq(pSyoruiCd)) {

            IT_TeikikinKouza teikikinKouza = pKhozenCommonParam.getTeikikinKouza(pSyoNo);

            BzGetBankDataBean bankDataBean =
                getBankData.exec(teikikinKouza.getBankcd(), teikikinKouza.getSitencd(), tyouhyouYMD);

            bankName = bankDataBean.getBankNmKj();
            sitenName = bankDataBean.getSitenNmKj();
            kzMeigiNmKn = teikikinKouza.getKzmeiginmkn();
            bankCd = teikikinKouza.getBankcd();
            sitenCd = teikikinKouza.getSitencd();
            yokinKbn = teikikinKouza.getYokinkbn();

            kouzaNo = KhozenEdit.editKouzaNo(teikikinKouza.getBankcd(), teikikinKouza.getKouzano());
        }

        if (C_SyoruiCdKbn.KK_GENGAKU_SKS.eq(pSyoruiCd) || C_SyoruiCdKbn.KK_KAIYAKU_SKS.eq(pSyoruiCd) || C_SyoruiCdKbn.KK_SEINENGAPPISEI_SKS.eq(pSyoruiCd)) {

            IT_Kouza kouza = pKhozenCommonParam.getKouza(pSyoNo);

            if (kouza != null) {

                BzGetBankDataBean bankDataBean = getBankData.exec(kouza.getBankcd(), kouza.getSitencd(), tyouhyouYMD);

                bankName = bankDataBean.getBankNmKj();

                kzMeigiNmKn = kouza.getKzmeiginmkn();
            }
        }


        IT_KykSonotaTkyk kykSonotaTkyk = pKhozenCommonParam.getSonotaTokuyaku(pSyoNo);

        if (C_SyoruiCdKbn.KK_SEINENGAPPISEI_SKS.eq(pSyoruiCd)) {


            hhknseiYMD = DateFormatUtil.dateKANJIWarekiNoEx(pEditSeikyuusyoParam.getHhknseiymd());

        }

        if (C_SyoruiCdKbn.KK_KZKTRKKYKDRTKYKHNK_SKS.eq(pSyoruiCd)) {

            if (C_MousideninKbn.HHKNHONNIN.eq(pEditSeikyuusyoParam.getMousideninkbn())) {

                trkkzknmkjInfo1 = trkkzknmkjInfo1 + "　" + "様";
                trkkzknmkjInfo2 = trkkzknmkjInfo2 + "　" + "様";
            }
            else {

                if (Strings.isNullOrEmpty(trkkzknmkjInfo1)) {

                    trkkzknmkjInfo1 = "未登録";
                    trkkzkadr1kjInfo1 = "未登録";
                }
                else if (C_KjkhukaKbn.KJKHUKA.eq(trkkzkKjkhukaKbn1)) {

                    trkkzknmkjInfo1 = "右記欄にご記入ください→";
                }
                else {

                    trkkzknmkjInfo1 = trkkzknmkjInfo1 + "　" + "様";
                }

                if (Strings.isNullOrEmpty(trkkzktelnoInfo1)) {

                    trkkzktelnoInfo1 = "未登録";
                }

                if (Strings.isNullOrEmpty(trkkzknmkjInfo2)) {

                    trkkzknmkjInfo2 = "未登録";
                    trkkzkadr1kjInfo2 = "未登録";
                }
                else if (C_KjkhukaKbn.KJKHUKA.eq(trkkzkKjkhukaKbn2)) {

                    trkkzknmkjInfo2 = "右記欄にご記入ください→";
                }
                else {

                    trkkzknmkjInfo2 = trkkzknmkjInfo2 + "　" + "様";
                }

                if (Strings.isNullOrEmpty(trkkzktelnoInfo2)) {

                    trkkzktelnoInfo2 = "未登録";
                }

                if (Strings.isNullOrEmpty(kykdairinmkj)) {

                    kykdairinmkj = "未登録";
                }
                else if (C_KjkhukaKbn.KJKHUKA.eq(getKhKykdrInfoBean.getKkdairinmKjkhukaKbn())) {

                    kykdairinmkj = "右記欄にご記入ください→";
                }
                else {

                    kykdairinmkj = kykdairinmkj + "　" + "様";
                }

                if(C_UktKbn.TOKUTEIMEIGI.eq(kykdruktKbn)) {

                    kykdruktKbn = C_UktKbn.BLNK;
                }
            }
        }


        List<IT_KykSyouhn> kykSyouhnLst = pKhozenCommonParam.getKeiyakuSyouhin(pSyoNo, C_SyutkKbn.SYU);


        C_YouhiblnkKbn fatcaKakYhkbn;

        C_UmuKbn fatcaTaisyouUmu = kykSyouhnLst.get(0).getSyouhnZokusei().getFatcataisyouumu();

        if (C_SyoruiCdKbn.KK_KAIYAKU_SKS.eq(pSyoruiCd) || C_SyoruiCdKbn.KK_MEIGIHNK_SKS.eq(pSyoruiCd)
            || C_SyoruiCdKbn.KK_YENDTHNKHNRKN_SKS.eq(pSyoruiCd)) {

            if (C_UmuKbn.ARI.eq(fatcaTaisyouUmu)) {

                fatcaKakYhkbn = C_YouhiblnkKbn.YOU;
            }

            else {

                fatcaKakYhkbn = C_YouhiblnkKbn.HUYOU;
            }
        }

        else {

            fatcaKakYhkbn = C_YouhiblnkKbn.HUYOU;
        }

        C_YouhiblnkKbn aeoikakuninyhkbn;
        C_UmuKbn aeoitaisyouUmu = kykSyouhnLst.get(0).getSyouhnZokusei().getAeoitaisyouumu();

        if (C_SyoruiCdKbn.KK_MEIGIHNK_SKS.eq(pSyoruiCd)) {

            if (C_UmuKbn.ARI.eq(aeoitaisyouUmu)) {

                aeoikakuninyhkbn = C_YouhiblnkKbn.YOU;
            }

            else {

                aeoikakuninyhkbn = C_YouhiblnkKbn.HUYOU;
            }
        }

        else {

            aeoikakuninyhkbn = C_YouhiblnkKbn.HUYOU;
        }

        if (C_Tdk.HONNIN.eq(kykSya.getKkkyktdk())) {

            ckeihiKbn = C_KeihiKbn.KEIHIDOUITU;
        }

        int syohinHanteiKbn = SyouhinUtil.hantei(kykSyouhnLst.get(0).getSyouhncd());

        if ((khTtdkTyuui.getTtdktyuuikbn1() != null && (C_TtdktyuuiKbn.HASANOYOBITOUSAN.eq(khTtdkTyuui.
            getTtdktyuuikbn1()) || C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE.eq(khTtdkTyuui.getTtdktyuuikbn1()))) ||
            (khTtdkTyuui.getTtdktyuuikbn2() != null && (C_TtdktyuuiKbn.HASANOYOBITOUSAN.eq(khTtdkTyuui.
                getTtdktyuuikbn2()) || C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE.eq(khTtdkTyuui.getTtdktyuuikbn2()))) ||
                (khTtdkTyuui.getTtdktyuuikbn3() != null && (C_TtdktyuuiKbn.HASANOYOBITOUSAN.eq(khTtdkTyuui.
                    getTtdktyuuikbn3()) || C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE.eq(khTtdkTyuui.getTtdktyuuikbn3()))) ||
                    (khTtdkTyuui.getTtdktyuuikbn4() != null && (C_TtdktyuuiKbn.HASANOYOBITOUSAN.eq(khTtdkTyuui.
                        getTtdktyuuikbn4()) || C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE.eq(khTtdkTyuui.
                            getTtdktyuuikbn4()))) ||
                            (khTtdkTyuui.getTtdktyuuikbn5() != null && (C_TtdktyuuiKbn.HASANOYOBITOUSAN.eq(khTtdkTyuui.
                                getTtdktyuuikbn5()) || C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE.eq(khTtdkTyuui.
                                    getTtdktyuuikbn5())))) {

            saikenSetUmu = C_UmuKbn.ARI;
        }

        IM_KhTyouhyoumsg2 khTyouhyoumsg2 = getKhTyouhyouMsg(pSyoruiCd, pEditSeikyuusyoParam.getMousideninkbn(),
            khTtdkTyuui.getKykdrknhatudoujyoutai());

        KhSeikyuusyoBean khSeikyuusyoBean = new KhSeikyuusyoBean();

        khSeikyuusyoBean.setIrSyono(pSyoNo);
        khSeikyuusyoBean.setIrTsinyno(tsinyno);
        khSeikyuusyoBean.setIrTsinadr1kj(tsinadr1kj);
        khSeikyuusyoBean.setIrTsinadr2kj(tsinadr2kj);
        khSeikyuusyoBean.setIrTsinadr3kj(tsinadr3kj);
        khSeikyuusyoBean.setIrTsintelno(tsintelno);
        khSeikyuusyoBean.setIrBanknmkj(bankName);
        khSeikyuusyoBean.setIrSitennmkj(sitenName);

        khSeikyuusyoBean.setIrBankcd(bankCd);
        khSeikyuusyoBean.setIrSitencd(sitenCd);

        khSeikyuusyoBean.setIrKzmeiginmkn(kzMeigiNmKn);
        khSeikyuusyoBean.setIrKyknmkj(kykNmKj);
        khSeikyuusyoBean.setIrKkkyktdk(kykSya.getKkkyktdk());
        khSeikyuusyoBean.setIrHhknnmkj(hhKnNmKj);
        khSeikyuusyoBean.setIrHhknseiymd(hhknseiYMD);
        khSeikyuusyoBean.setIrHhknseiymdhenkouumu(pEditSeikyuusyoParam.getHhknseiymdhenkouumu());
        khSeikyuusyoBean.setIrHhknsei(pEditSeikyuusyoParam.getHhknsei());
        khSeikyuusyoBean.setIrHhknseihenkouumu(pEditSeikyuusyoParam.getHhknseihenkouumu());
        khSeikyuusyoBean.setIrStdrsknmkj(stDrskNmKj);
        khSeikyuusyoBean.setIrFatcakakuninyhkbn(fatcaKakYhkbn);
        khSeikyuusyoBean.setIrAeoikakuninyhkbn(aeoikakuninyhkbn);

        khSeikyuusyoBean.setIrTargettkkbn(kykSonotaTkyk.getTargettkkbn());
        khSeikyuusyoBean.setIrAftertargettkmokuhyouti(
            Integer.parseInt(pEditSeikyuusyoParam.getBfrTargettkmokuhyouti().toString()));
        khSeikyuusyoBean.setIrBeforetargettkmokuhyouti(kykSonotaTkyk.getTargettkmokuhyouti());
        khSeikyuusyoBean.setIrBeforekihons(kykSyouhnLst.get(0).getKihons());
        khSeikyuusyoBean.setIrAfterkihons(pEditSeikyuusyoParam.getBfrKihonS());
        khSeikyuusyoBean.setIrBeforep(kykSyouhnLst.get(0).getHokenryou());
        khSeikyuusyoBean.setIrAfterp(pEditSeikyuusyoParam.getBfrP());
        khSeikyuusyoBean.setIrKyktuukasyu(kykSyouhnLst.get(0).getKyktuukasyu());
        khSeikyuusyoBean.setIrSbuktnmkj1(sbUktNmkjList.get(0));
        khSeikyuusyoBean.setIrSbuktnmkj2(sbUktNmkjList.get(1));
        khSeikyuusyoBean.setIrSbuktnmkj3(sbUktNmkjList.get(2));
        khSeikyuusyoBean.setIrSbuktnmkj4(sbUktNmkjList.get(3));
        khSeikyuusyoBean.setIrSbuktnmkn(sbUktNmkn);
        khSeikyuusyoBean.setIrYokinkbn(yokinKbn);
        khSeikyuusyoBean.setIrKouzano(kouzaNo);
        khSeikyuusyoBean.setIrAfternkshrtkyknksyukbn(pEditSeikyuusyoParam.getBfrTokuyakuNenkinsyuKbn());
        khSeikyuusyoBean.setIrBiforenkshrtkyknksyukbn(kykSonotaTkyk.getNkshrtkyknksyukbn());
        khSeikyuusyoBean.setIrAfternkshrtkyknkkkn(pEditSeikyuusyoParam.getBfrNkshrtkyknksyukkn());
        khSeikyuusyoBean.setIrBeforenkshrtkyknkkkn(kykSonotaTkyk.getNkshrtkyknksyukkn());
        khSeikyuusyoBean.setIrNkuktnm(nenkinUktNmKanji);
        khSeikyuusyoBean.setIrSbubnwari1(sbUktBnwariList.get(0));
        khSeikyuusyoBean.setIrSbubnwari2(sbUktBnwariList.get(1));
        khSeikyuusyoBean.setIrSbubnwari3(sbUktBnwariList.get(2));
        khSeikyuusyoBean.setIrSbubnwari4(sbUktBnwariList.get(3));
        khSeikyuusyoBean.setIrTargettkhnkkbn(pEditSeikyuusyoParam.getTargetTkHenkouKbn());
        khSeikyuusyoBean.setIrKaiyakujiyuu(pEditSeikyuusyoParam.getKaiyakujiyuu());
        khSeikyuusyoBean.setIrGengkhoukbn(pEditSeikyuusyoParam.getGengkhouKbn());
        khSeikyuusyoBean.setIrSbuktnin(kykKihon.getSbuktnin());
        khSeikyuusyoBean.setIrSbuuktkbn(sbUktKbn);
        khSeikyuusyoBean.setIrYenshrtkumu(kykSonotaTkyk.getYenshrtkhkumu());
        khSeikyuusyoBean.setIrHenkankinumukbn(pEditSeikyuusyoParam.getHenkankumukbn());
        khSeikyuusyoBean.setIrRstuukasyu(pEditSeikyuusyoParam.getRstuukasyu());
        khSeikyuusyoBean.setIrNkshrtkykhnkkbn(pEditSeikyuusyoParam.getNkshrtkykhnkkbn());
        khSeikyuusyoBean.setIrMeigihnkjiyuu(pEditSeikyuusyoParam.getMeigihnkjiyuu());
        khSeikyuusyoBean.setIrNkhknumu(kykSyouhnLst.get(0).getSyouhnZokusei().getNkhknumu());
        khSeikyuusyoBean.setIrSiboukyhkuktumukbn(kykSyouhnLst.get(0).getSyouhnZokusei().getSbkyuuhukinuktumu());
        khSeikyuusyoBean.setIrSibousuktumukbn1(sibousUktUmuKbnList.get(0));
        khSeikyuusyoBean.setIrSibousuktumukbn2(sibousUktUmuKbnList.get(1));
        khSeikyuusyoBean.setIrSibousuktumukbn3(sibousUktUmuKbnList.get(2));
        khSeikyuusyoBean.setIrSibousuktumukbn4(sibousUktUmuKbnList.get(3));
        khSeikyuusyoBean.setIrSbubnwariumu1(sbuBnwariUmuList.get(0));
        khSeikyuusyoBean.setIrSbubnwariumu2(sbuBnwariUmuList.get(1));
        khSeikyuusyoBean.setIrSbubnwariumu3(sbuBnwariUmuList.get(2));
        khSeikyuusyoBean.setIrSbubnwariumu4(sbuBnwariUmuList.get(3));
        khSeikyuusyoBean.setIrStdrsktkyhukaumu(kykSonotaTkyk.getStdrsktkyhkumu());
        khSeikyuusyoBean.setIrStdrsktkyuuktmukbn(stDrSkUmuKbn);
        khSeikyuusyoBean.setIrStdruktkbn(stDrUktKbn);
        khSeikyuusyoBean.setIrJyudkaigomaebrtkykhnkkbn(pEditSeikyuusyoParam.getJyudkaigomaebaraiTkykhnkKbn());
        khSeikyuusyoBean.setIrKeihikbn(ckeihiKbn);
        khSeikyuusyoBean.setIrKihonshenkouumu(pEditSeikyuusyoParam.getKihonshenkouumu());
        String kihonssyurui = C_KihonssyuruiKbn.getContentByValue(C_KihonssyuruiKbn.PATTERN_REPORT, kykSyouhnLst.get(0)
            .getSyouhnZokusei().getKihonssyuruikbn().getValue());
        khSeikyuusyoBean.setIrKihonssyurui(kihonssyurui);
        khSeikyuusyoBean.setIrTmttknitenkbn(pEditSeikyuusyoParam.getTmttknitenkbn());
        khSeikyuusyoBean.setIrTmttknitenymd(DateFormatUtil.dateKANJINoEx(pEditSeikyuusyoParam.getTmttknitenymd()));
        khSeikyuusyoBean.setIrKhhrshrjiyuu(pEditSeikyuusyoParam.getKhhrshrjiyuu());
        khSeikyuusyoBean.setIrKhskssakuseijiyuu(pEditSeikyuusyoParam.getKhskssakuseijiyuu());
        khSeikyuusyoBean.setIrAfterkijyunkingaku(pEditSeikyuusyoParam.getHenkougokjnkngk());
        khSeikyuusyoBean.setIrHrkkeiro(kykKihon.getHrkkeiro());
        khSeikyuusyoBean.setIrSyouhnhanteikekka(syohinHanteiKbn);
        khSeikyuusyoBean.setIrKykjyoutai(kykSyouhnLst.get(0).getKykjyoutai());
        khSeikyuusyoBean.setIrZeiseitkkktkykhukaumu(kykSonotaTkyk.getZeiseitkkktkykhukaumu());
        khSeikyuusyoBean.setIrYuuyokkntyoukaumu(pEditSeikyuusyoParam.getYuuyokkntyoukaumu());
        khSeikyuusyoBean.setIrMousideikoukbn(kykSyouhnLst.get(0).getSyouhnZokusei().getMousideikoukbn());
        khSeikyuusyoBean.setIrSaikensetumu(saikenSetUmu);
        khSeikyuusyoBean.setIrTrkkzknmkn1(trkkzknmknInfo1);
        khSeikyuusyoBean.setIrTrkkzknmkj1(trkkzknmkjInfo1);
        khSeikyuusyoBean.setIrTrkkzkadr1kj1(trkkzkadr1kjInfo1);
        khSeikyuusyoBean.setIrTrkkzkadr2kj1(trkkzkadr2kjInfo1);
        khSeikyuusyoBean.setIrTrkkzkadr3kj1(trkkzkadr3kjInfo1);
        khSeikyuusyoBean.setIrTrkkzktelno1(trkkzktelnoInfo1);
        khSeikyuusyoBean.setIrTrkkzksakujyokahi1(pEditSeikyuusyoParam.getTrkkzksakujyokahi1());
        khSeikyuusyoBean.setIrTrkkzknmkn2(trkkzknmknInfo2);
        khSeikyuusyoBean.setIrTrkkzknmkj2(trkkzknmkjInfo2);
        khSeikyuusyoBean.setIrTrkkzkadr1kj2(trkkzkadr1kjInfo2);
        khSeikyuusyoBean.setIrTrkkzkadr2kj2(trkkzkadr2kjInfo2);
        khSeikyuusyoBean.setIrTrkkzkadr3kj2(trkkzkadr3kjInfo2);
        khSeikyuusyoBean.setIrTrkkzktelno2(trkkzktelnoInfo2);
        khSeikyuusyoBean.setIrTrkkzksakujyokahi2(pEditSeikyuusyoParam.getTrkkzksakujyokahi2());
        khSeikyuusyoBean.setIrKyknmkn(kykSya.getKyknmkn());
        khSeikyuusyoBean.setIrKykdairinmkj(kykdairinmkj);
        khSeikyuusyoBean.setIrKykdrtkykhukaumu(kykSonotaTkyk.getKykdrtkykhukaumu());
        khSeikyuusyoBean.setIrMousideninkbn(pEditSeikyuusyoParam.getMousideninkbn());
        khSeikyuusyoBean.setIrKykdrknhatudoujyoutai(khTtdkTyuui.getKykdrknhatudoujyoutai());
        khSeikyuusyoBean.setIrDrstiskkyknmkj(kykSya.getKyknmkj());
        khSeikyuusyoBean.setIrTyouhyoutitle(khTyouhyoumsg2.getTyouhyoutitle());
        khSeikyuusyoBean.setIrSouhuannaimsg1(khTyouhyoumsg2.getRsouhuannaimsg1());
        khSeikyuusyoBean.setIrSouhuannaimsg2(khTyouhyoumsg2.getRsouhuannaimsg2());
        khSeikyuusyoBean.setIrSouhuannaimsg3(khTyouhyoumsg2.getRsouhuannaimsg3());
        khSeikyuusyoBean.setIrSouhuannaimsg4(khTyouhyoumsg2.getRsouhuannaimsg4());
        khSeikyuusyoBean.setIrSouhuannaimsg5(khTyouhyoumsg2.getRsouhuannaimsg5());
        khSeikyuusyoBean.setIrSouhuannaimsg6(khTyouhyoumsg2.getRsouhuannaimsg6());
        khSeikyuusyoBean.setIrSouhuannaimsg7(khTyouhyoumsg2.getRsouhuannaimsg7());
        khSeikyuusyoBean.setIrSouhuannaimsg8(khTyouhyoumsg2.getRsouhuannaimsg8());
        khSeikyuusyoBean.setIrSouhuannaimsg9(khTyouhyoumsg2.getRsouhuannaimsg9());
        khSeikyuusyoBean.setIrSouhuannaimsg10(khTyouhyoumsg2.getRsouhuannaimsg10());
        khSeikyuusyoBean.setIrKykdrkbn(kykdruktKbn);


        String hozonKikan = getHozonKknTani(pSyoruiCd);

        BzSksKaisyasiyouranBean sksKaisyasiyouranBean = new BzSksKaisyasiyouranBean();

        BzGetSosikiMadogutiInfo bzGetSosikiMadogutiInfo = SWAKInjector.getInstance(BzGetSosikiMadogutiInfo.class);

        bzGetSosikiMadogutiInfo.exec(sosikiCd);

        String dateKANJI = DateFormatUtil.dateKANJI(tyouhyouYMD);

        boolean hanteiKekka = BzHanteiSosikiUtil.isCallcenterKeySosikicd(sosikiCd);

        if (hanteiKekka) {

            sksKaisyasiyouranBean.setIrToritsugisyasyozokunm(pKhozenCommonParam.getTmSosikiNm());
            sksKaisyasiyouranBean.setIrTyouhyousakuseiymd(dateKANJI);
            sksKaisyasiyouranBean.setIrHozonkkn(hozonKikan);

        }
        else {

            sksKaisyasiyouranBean.setIrToritsugisyasyozokunm(pKhozenCommonParam.getTmSosikiNm());
            sksKaisyasiyouranBean.setIrToritsugisyakjncd(pKhozenCommonParam.getUserID());
            sksKaisyasiyouranBean.setIrToritsugisyanm(pKhozenCommonParam.getUserNm());
            sksKaisyasiyouranBean.setIrTyouhyousakuseiymd(dateKANJI);
            sksKaisyasiyouranBean.setIrHozonkkn(hozonKikan);

        }

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            IKhozenCommonConstants.SUBSYSTEMID_HOZEN,
            categoryId,
            kinouId,
            pSyoruiCd);

        reportServicesBean.setKensakuKeys(pSyoNo);

        reportServicesBean.addParamObjects(new Object[] { khSeikyuusyoBean, sksKaisyasiyouranBean });

        return reportServicesBean;
    }

    public String getHozonKknTani(C_SyoruiCdKbn pSyoruiCd) {

        AM_SyoruiZokusei amSyoruiZokusei = baseDomManager.getSyoruiZokusei(pSyoruiCd);

        return getHozonKknTani(amSyoruiZokusei);
    }

    public String getHozonKknTani(AM_SyoruiZokusei pSyoruiZokusei) {

        C_SyoruiCdKbn syoruiCd = pSyoruiZokusei.getSyoruiCd();
        String hozonKkn = String.valueOf(pSyoruiZokusei.getHozonKikan());
        C_NengetuKbn nengetuKbn = pSyoruiZokusei.getNengetukbn();

        if ("0".equals(hozonKkn)) {
            hozonKkn = "";
        }
        else if ("99".equals(hozonKkn)) {
            hozonKkn = "永久";
        }
        else {

            if (C_NengetuKbn.NEN.eq(nengetuKbn)) {
                hozonKkn = hozonKkn + " " + "年";
            }
            else if (C_NengetuKbn.TUKI.eq(nengetuKbn)) {
                hozonKkn = hozonKkn + "ヵ月";
            }

            if (C_SyoruiCdKbn.KK_SEINENGAPPISEI_SKS.eq(syoruiCd) || C_SyoruiCdKbn.KK_SYOSAIHK_SKS.eq(syoruiCd) ||
                C_SyoruiCdKbn.KK_STDRHNK_SKS.eq(syoruiCd) || C_SyoruiCdKbn.KK_GENGAKU_SKS.eq(syoruiCd) ||
                C_SyoruiCdKbn.KK_KAIGOMAETKHNK_SKS.eq(syoruiCd) || C_SyoruiCdKbn.KK_MKHGKHNK_SKS.eq(syoruiCd) ||
                C_SyoruiCdKbn.KK_TUMITATEKINITEN_SKS.eq(syoruiCd) || C_SyoruiCdKbn.KK_YENDTHNK_SKS.eq(syoruiCd) ||
                C_SyoruiCdKbn.KK_KZKTRKKYKDRTKYKHNK_SKS.eq(syoruiCd)) {

                hozonKkn = "　" + "消滅後" + " " + hozonKkn;
            }
        }

        return hozonKkn;
    }

    public IM_KhTyouhyoumsg2 getKhTyouhyouMsg(
        C_SyoruiCdKbn pSyoruiCdKbn,
        C_MousideninKbn pMousideninKbn,
        C_KykdrknHtdjytKbn pKykdrknHtdjytKbn) {

        C_KhTyouhyoumsgbunruiKbn1 khTyouhyoumsgbunruiKbn1 = C_KhTyouhyoumsgbunruiKbn1.BLNK;

        if (C_SyoruiCdKbn.KK_KZKTRKKYKDRTKYKHNK_SKS.eq(pSyoruiCdKbn)) {

            if (C_MousideninKbn.KYKHONNIN.eq(pMousideninKbn)) {

                if (C_KykdrknHtdjytKbn.BLNK.eq(pKykdrknHtdjytKbn)) {

                    khTyouhyoumsgbunruiKbn1 = C_KhTyouhyoumsgbunruiKbn1.KYKMOUSIDE;
                }
                else {

                    khTyouhyoumsgbunruiKbn1 = C_KhTyouhyoumsgbunruiKbn1.DRMOUSIDE;
                }
            }
            else if (C_MousideninKbn.HHKNHONNIN.eq(pMousideninKbn)) {

                khTyouhyoumsgbunruiKbn1 = C_KhTyouhyoumsgbunruiKbn1.HHKNMOUSIDE;
            }
            else {

                khTyouhyoumsgbunruiKbn1 = C_KhTyouhyoumsgbunruiKbn1.KZKMOUSIDE;
            }
        }

        IM_KhTyouhyoumsg2 khTyouhyoumsg2 = hozenDomManager.getKhTyouhyoumsg2(
            pSyoruiCdKbn,
            C_Meigihnkjiyuu.BLNK,
            C_KyksyaSibouUmuKbn.BLNK,
            C_UmuKbn.NONE,
            C_UmuKbn.NONE,
            khTyouhyoumsgbunruiKbn1,
            C_KhTyouhyoumsgbunruiKbn2.BLNK,
            C_KhTyouhyoumsgbunruiKbn3.BLNK);

        if (khTyouhyoumsg2 == null) {

            khTyouhyoumsg2 = SWAKInjector.getInstance(IM_KhTyouhyoumsg2.class);
        }

        return khTyouhyoumsg2;
    }
}
