package yuyu.common.hozen.khcommon;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.common.base.format.DefaultDateFormatter;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfo;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfoKekkaBean;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.report.ViewReport;
import yuyu.def.biz.bean.report.BzKokyakuAtesakiBean;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_HaitoukinuketorihouKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_KoujyosyoumeimsgKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_SaihkHyjKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.IT_KhTtdkTyuui;
import yuyu.def.db.entity.IT_KoujyoSym;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.hozen.bean.report.KhKoujyosyoumeisyoBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;

import com.google.common.base.Strings;

/**
 * 契約保全 契約保全共通 控除証明書TBL編集クラス
 */
public class EditKoujyoSyoumeiTbl {

    private static final String ZENKAKUHOSI2KETA = "＊＊";

    private static final String ZENKAKUHOSI3KETA = "＊＊＊";

    private static final String ZENKAKUHOSI4KETA = "＊＊＊＊";

    private static final String ZENKAKUHOSI11KETA = "＊＊＊＊＊＊＊＊＊＊＊";

    private static final String ZENKAKUHOSI18KETA = "＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊";

    private static final String HANKAKUHOSI10KETA = "**********";

    @Inject
    private CreateReport createReport;

    public EditKoujyoSyoumeiTbl() {
        super();
    }

    public IT_KoujyoSym editTBL(KhozenCommonParam pKCParm,
        IT_KykKihon pKykKihon,
        List<IT_KykSyouhn> pKykSyohnSyuLst,
        IT_KykSya pKykSya,
        List<IT_KykUkt> pKykUktLst,
        IT_KykUkt pKykUkt,
        List<IT_KykDairiten> pKykDaritenLst,
        IT_KhTtdkTyuui pKktetudukityuui,
        EditKoujyoSyoumeiParam pEditKoujyoSyoumeiParam,
        C_HassouKbn pHassouKbn,
        BizDate pSyoriYmd,
        int pRenno) {

        if (pKykSyohnSyuLst == null || pKykSyohnSyuLst.size() == 0) {
            return null;
        }

        C_UmuKbn newSyoumeigkUmuKbn = C_UmuKbn.NONE;

        C_UmuKbn kjnNkKoujyUm = C_UmuKbn.NONE;

        String uktNmKj = "";

        String uktNmKn = "";

        BizNumber hknkknSyu = BizNumber.valueOf(0);

        Integer phrkkkn = 0;

        BizDate nkshrstartYMD = null;

        BizDate nenkinUktSeiYMD = null;

        String nknShrY = "";

        C_UmuKbn hengakuUmu = pKykSyohnSyuLst.get(0).getSyouhnZokusei().getHengakuumu();

        if (pEditKoujyoSyoumeiParam.getNewIppanJissekiSyoumeigk().compareTo(BizCurrency.valueOf(0)) != 0 ||
            pEditKoujyoSyoumeiParam.getNewIryouJissekiSyoumeigk().compareTo(BizCurrency.valueOf(0)) != 0 ||
            pEditKoujyoSyoumeiParam.getNewNenkinJissekiSyoumeigk().compareTo(BizCurrency.valueOf(0)) != 0 ||
            pEditKoujyoSyoumeiParam.getNewIppanNenkanSyoumeigk().compareTo(BizCurrency.valueOf(0)) != 0 ||
            pEditKoujyoSyoumeiParam.getNewIryouNenkanSyoumeigk().compareTo(BizCurrency.valueOf(0)) != 0 ||
            pEditKoujyoSyoumeiParam.getNewNenkinNenkanSyoumeigk().compareTo(BizCurrency.valueOf(0)) != 0) {

            newSyoumeigkUmuKbn = C_UmuKbn.ARI;
        }

        int syoumeiPeriodMonth = 0;

        if (pEditKoujyoSyoumeiParam.getSyoumeiStartYm() != null && pEditKoujyoSyoumeiParam.getSyoumeiEndYm() != null) {

            syoumeiPeriodMonth = BizDateUtil.calcDifferenceMonths(pEditKoujyoSyoumeiParam.getSyoumeiEndYm(),
                pEditKoujyoSyoumeiParam.getSyoumeiStartYm()) + 1;
        }

        int syoumeiKknNensuu = syoumeiPeriodMonth / 12;

        String ccSosikiCd = YuyuBizConfig.getInstance().getCallcentersosikicd();

        BzGetSosikiMadogutiInfo getSosikiMadogutiInfo = SWAKInjector.getInstance(BzGetSosikiMadogutiInfo.class);

        BzGetSosikiMadogutiInfoKekkaBean getCcSosikiMadogutiInfoKekkaBean = getSosikiMadogutiInfo.exec(ccSosikiCd);

        String toiawaseSosikiNmKj = getCcSosikiMadogutiInfoKekkaBean.getKanjisosikinm();

        String toiawaSeyno = getCcSosikiMadogutiInfoKekkaBean.getPostalCd();

        String toiawaseAdr1Kj = getCcSosikiMadogutiInfoKekkaBean.getKanjisosikiadr1();

        String toiawaseAdr2Kj = getCcSosikiMadogutiInfoKekkaBean.getKanjisosikiadr2();

        String toiawaseAdr3Kj = getCcSosikiMadogutiInfoKekkaBean.getKanjisosikiadr3();

        String toiawaseTelNo = getCcSosikiMadogutiInfoKekkaBean.getTelno();

        String toiawaseTelUktkKanou1 = YuyuBizConfig.getInstance().getUketimecallcenter1();

        String toiawaseTelUktkKanou2 = YuyuBizConfig.getInstance().getUketimecallcenter2();

        String toiawaseSosikiNmKj2 = "";

        String toiawaseTelNo2 = "";

        if(pEditKoujyoSyoumeiParam.getNewNenkinNenkanSyoumeigk().compareTo(
            BizCurrency.valueOf(0, pEditKoujyoSyoumeiParam.getNewNenkinNenkanSyoumeigk().getType())) > 0){
            kjnNkKoujyUm = C_UmuKbn.ARI;
        }

        if (C_UmuKbn.NONE.eq(kjnNkKoujyUm)) {
            if (pKykKihon.getSbuktnin() > 1) {
                uktNmKj = "保険証券をご覧ください。";
                uktNmKn = "";
            }
            if (pKykUktLst != null && pKykUktLst.size() > 0) {

                if (pKykKihon.getSbuktnin() == 1) {

                    if (pKykUktLst.get(0).getUktkbn().eq(C_UktKbn.KYK)) {

                        uktNmKj = ViewReport.editSama(pKykSya.getKyknmkj());
                        uktNmKn = pKykSya.getKyknmkn();
                    }
                    else if (pKykUktLst.get(0).getUktkbn().eq(C_UktKbn.HHKN)) {

                        uktNmKj = ViewReport.editSama(pKykKihon.getHhknSya().getHhknnmkj());
                        uktNmKn = pKykKihon.getHhknSya().getHhknnmkn();
                    }
                    else if (pKykUktLst.get(0).getUktkbn().eq(C_UktKbn.SOUZOKUNIN)) {

                        uktNmKj = "法定相続人様";
                        uktNmKn = "";
                    }
                    else {
                        uktNmKj = ViewReport.editSama(pKykUktLst.get(0).getUktnmkj());
                        uktNmKn = pKykUktLst.get(0).getUktnmkn();
                    }
                }
            }
        }
        else {
            if (C_UktKbn.HHKN.eq(pKykUkt.getUktkbn())) {

                uktNmKj = ViewReport.editSama(pKykKihon.getHhknSya().getHhknnmkj());
                uktNmKn = pKykKihon.getHhknSya().getHhknnmkn();
                nenkinUktSeiYMD = pKykKihon.getHhknSya().getHhknseiymd();
            }
            else if (C_UktKbn.KYK.eq(pKykUkt.getUktkbn())) {

                uktNmKj = ViewReport.editSama(pKykSya.getKyknmkj());
                uktNmKn = pKykSya.getKyknmkn();
                nenkinUktSeiYMD = pKykSya.getKykseiymd();
            }
        }

        if (C_HknkknsmnKbn.SAIMANKI.eq(pKykSyohnSyuLst.get(0).getHknkknsmnkbn()) &&
            pKykSyohnSyuLst.get(0).getHknkkn() != 99) {

            hknkknSyu = BizNumber.valueOf(pKykSyohnSyuLst.get(0).getHknkkn()).subtract(
                BizNumber.valueOf(pKykSyohnSyuLst.get(0).getHhknnen()));
        }
        else {

            hknkknSyu = BizNumber.valueOf(pKykSyohnSyuLst.get(0).getHknkkn());
        }

        if (C_UmuKbn.ARI.eq(kjnNkKoujyUm)) {
            if (C_HrkkknsmnKbn.SAIMANKI.eq(pKykSyohnSyuLst.get(0).getHrkkknsmnkbn())) {

                phrkkkn = pKykSyohnSyuLst.get(0).getHrkkkn() - pKykSyohnSyuLst.get(0).getHhknnen();
            }
            else {

                phrkkkn = pKykSyohnSyuLst.get(0).getHrkkkn();
            }

            nkshrstartYMD = pKykSyohnSyuLst.get(0).getHknkknmanryouymd();

            nknShrY = pKykSyohnSyuLst.get(0).getNenkinkkn().toString();
        }

        IT_KoujyoSym koujyoSym = pKykKihon.createKoujyoSym();

        IT_KykSyouhn kykSyouhn = pKykSyohnSyuLst.get(0);

        koujyoSym.setSyono(pKykKihon.getSyono());

        koujyoSym.setNendo(pEditKoujyoSyoumeiParam.getKoujyoNendo());

        koujyoSym.setKjsmsakuseisyorikbn(pEditKoujyoSyoumeiParam.getKoujyoSakuseiSyoriKbn());

        koujyoSym.setTyouhyouymd(pSyoriYmd);

        koujyoSym.setRenno(pRenno);

        koujyoSym.setTekiyouseidokbn(pEditKoujyoSyoumeiParam.getTekiyouSeidoKbn());

        koujyoSym.setSyoumeiymd(pEditKoujyoSyoumeiParam.getSyoumeiYmd().toString());

        koujyoSym.setSyoumeistartym(pEditKoujyoSyoumeiParam.getSyoumeiStartYm());

        koujyoSym.setSyoumeiendym(pEditKoujyoSyoumeiParam.getSyoumeiEndYm());

        koujyoSym.setSyoumeikkntukisuu(syoumeiPeriodMonth);

        koujyoSym.setSyoumeikknnensuu(syoumeiKknNensuu);

        koujyoSym.setKyknmkj(pKykSya.getKyknmkj());

        koujyoSym.setUktnmkjaddsama(uktNmKj);

        koujyoSym.setNenkinuktseiymd(nenkinUktSeiYMD);

        koujyoSym.setHknsyuruinmrykkj(kykSyouhn.getSyouhnZokusei().getHknsyuruikoujyosyoumei());

        koujyoSym.setKykymd(kykSyouhn.getKykymd());

        koujyoSym.setHknkknsmnkbnsyu(kykSyouhn.getHknkknsmnkbn());

        koujyoSym.setHknkknsyu(hknkknSyu);

        koujyoSym.setNenkanhrkkaisuu(12 / Integer.valueOf(
            pEditKoujyoSyoumeiParam.getHrkkaisuu().getValue().toString()));

        koujyoSym.setPhrkkkn(phrkkkn);

        koujyoSym.setNkshrstartymd(nkshrstartYMD);

        koujyoSym.setNknshry(nknShrY);

        koujyoSym.setKykjyoutai(kykSyouhn.getKykjyoutai());

        koujyoSym.setYuukousyoumetukbn(kykSyouhn.getYuukousyoumetukbn());

        koujyoSym.setHaitoukinuketorihoukbn(pKykKihon.getHaitoukinuketorihoukbn());

        koujyoSym.setOldippanjissekip(pEditKoujyoSyoumeiParam.getOldIppanJissekiP());

        koujyoSym.setOldippannenkanp(pEditKoujyoSyoumeiParam.getOldIppanNenkanP());

        koujyoSym.setOldippanjissekihaitoukin(pEditKoujyoSyoumeiParam.getOldIppanJissekiHaitoukin());

        koujyoSym.setOldippannenkanhaitoukin(pEditKoujyoSyoumeiParam.getOldIppanNenkanHaitoukin());

        koujyoSym.setOldippanjissekisyoumeigk(pEditKoujyoSyoumeiParam.getOldIppanJissekiSyoumeigk());

        koujyoSym.setOldippannenkansyoumeigk(pEditKoujyoSyoumeiParam.getOldIppanNenkanSyoumeigk());

        koujyoSym.setNewippanjissekip(pEditKoujyoSyoumeiParam.getNewIppanJissekiP());

        koujyoSym.setNewippannenkanp(pEditKoujyoSyoumeiParam.getNewIppanNenkanP());

        koujyoSym.setNewippanjissekihaitoukin(pEditKoujyoSyoumeiParam.getNewIppanJissekiHaitoukin());

        koujyoSym.setNewippannenkanhaitoukin(pEditKoujyoSyoumeiParam.getNewIppanNenkanHaitoukin());

        koujyoSym.setNewippanjissekisyoumeigk(pEditKoujyoSyoumeiParam.getNewIppanJissekiSyoumeigk());

        koujyoSym.setNewippannenkansyoumeigk(pEditKoujyoSyoumeiParam.getNewIppanNenkanSyoumeigk());

        koujyoSym.setNewiryoujissekip(pEditKoujyoSyoumeiParam.getNewIryouJissekiP());

        koujyoSym.setNewiryounenkanp(pEditKoujyoSyoumeiParam.getNewIryouNenkanP());

        koujyoSym.setNewiryoujissekihaitoukin(pEditKoujyoSyoumeiParam.getNewIryouJissekiHaitoukin());

        koujyoSym.setNewiryounenkanhaitoukin(pEditKoujyoSyoumeiParam.getNewIryouNenkanHaitoukin());

        koujyoSym.setNewiryoujissekisyoumeigk(pEditKoujyoSyoumeiParam.getNewIryouJissekiSyoumeigk());

        koujyoSym.setNewiryounenkansyoumeigk(pEditKoujyoSyoumeiParam.getNewIryouNenkanSyoumeigk());

        koujyoSym.setNewnkjissekip(pEditKoujyoSyoumeiParam.getNewNenkinJissekiP());

        koujyoSym.setNewnknenkanp(pEditKoujyoSyoumeiParam.getNewNenkinNenkanP());

        koujyoSym.setNewnkjissekihaitoukin(pEditKoujyoSyoumeiParam.getNewNenkinJissekiHaitoukin());

        koujyoSym.setNewnknenkanhaitoukin(pEditKoujyoSyoumeiParam.getNewNenkinNenkanHaitoukin());

        koujyoSym.setNewnkjissekisyoumeigk(pEditKoujyoSyoumeiParam.getNewNenkinJissekiSyoumeigk());

        koujyoSym.setNewnknenkansyoumeigk(pEditKoujyoSyoumeiParam.getNewNenkinNenkanSyoumeigk());

        koujyoSym.setKjnnkkoujyum(kjnNkKoujyUm);

        koujyoSym.setTsinyno(pKykSya.getTsinyno());

        koujyoSym.setTsinadr1kj(pKykSya.getTsinadr1kj());

        koujyoSym.setTsinadr2kj(pKykSya.getTsinadr2kj());

        koujyoSym.setTsinadr3kj(pKykSya.getTsinadr3kj());

        koujyoSym.setToiawasesosikinmkj(toiawaseSosikiNmKj);

        koujyoSym.setToiawaseyno(toiawaSeyno);

        koujyoSym.setToiawaseadr1kj(toiawaseAdr1Kj);

        koujyoSym.setToiawaseadr2kj(toiawaseAdr2Kj);

        koujyoSym.setToiawaseadr3kj(toiawaseAdr3Kj);

        koujyoSym.setToiawasetelno(toiawaseTelNo);

        koujyoSym.setToiawaseteluktkkanou1(toiawaseTelUktkKanou1);

        koujyoSym.setToiawaseteluktkkanou2(toiawaseTelUktkKanou2);

        koujyoSym.setToiawasesosikinmkj2(toiawaseSosikiNmKj2);

        koujyoSym.setToiawasetelno2(toiawaseTelNo2);

        koujyoSym.setHassoukbn(pHassouKbn);

        koujyoSym.setHengakuumu(hengakuUmu);

        koujyoSym.setNewsyoumeigkumukbn(newSyoumeigkUmuKbn);

        koujyoSym.setGyoumuKousinKinou(pKCParm.getFunctionId());

        koujyoSym.setGyoumuKousinsyaId(pKCParm.getUserID());

        koujyoSym.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

        koujyoSym.setKoujyosyoumeisentakukbn(pEditKoujyoSyoumeiParam.getKoujyosyoumeisentakuKbn());

        koujyoSym.setKyknmkn(pKykSya.getKyknmkn());

        koujyoSym.setUktnmkn(uktNmKn);

        koujyoSym.setSaihkhyjkbn(pEditKoujyoSyoumeiParam.getSaihkhyjkbn());

        koujyoSym.setKoujyosyoumeimsgkbn(pEditKoujyoSyoumeiParam.getKoujyosyoumeimsgKbn());

        BizPropertyInitializer.initialize(koujyoSym);

        return koujyoSym;
    }

    public ReportServicesBean editBean(KhozenCommonParam pKhozenCommonParam,
        IT_KoujyoSym pKoujyoSym,
        BizDate pSyoriYmd) {

        if (pKoujyoSym == null) {

            return null;
        }

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            IKhozenCommonConstants.SUBSYSTEMID_HOZEN,
            pKhozenCommonParam.getCategoryId(),
            pKhozenCommonParam.getFunctionId(),
            C_SyoruiCdKbn.KK_KOUJYOSYOUMEIS);

        reportServicesBean.setKensakuKeys(pKoujyoSym.getSyono());

        C_UmuKbn kjnNkKoujyUm = pKoujyoSym.getKjnnkkoujyum();

        C_UmuKbn newSyoumeigkUmuKbn = pKoujyoSym.getNewsyoumeigkumukbn();

        String hrkHou = "";

        if (pKoujyoSym.getNenkanhrkkaisuu() == 12) {

            hrkHou = "月払";
        }
        else if (pKoujyoSym.getNenkanhrkkaisuu() == 2) {

            hrkHou = "年２回払";
        }
        else if (pKoujyoSym.getNenkanhrkkaisuu() == 1) {

            hrkHou = "年１回払";
        }
        else {

            hrkHou = ZENKAKUHOSI2KETA;
        }
        String hrJyoutai = "";

        if (pKoujyoSym.getNenkanhrkkaisuu() == 12) {

            if (C_Kykjyoutai.HARAIMAN.eq(pKoujyoSym.getKykjyoutai())) {
                hrJyoutai = "払込停止";
            }
            else if (C_YuukousyoumetuKbn.SYOUMETU.eq(pKoujyoSym.getYuukousyoumetukbn())) {
                hrJyoutai = "払込停止";
            }
            else if (C_Kykjyoutai.HRKMTYUU.eq(pKoujyoSym.getKykjyoutai())
                || C_Kykjyoutai.IKKATUNK.eq(pKoujyoSym.getKykjyoutai())) {
                hrJyoutai = "払込中";
            }
            else {
                hrJyoutai = "払込停止";
            }
        }
        else {
            hrJyoutai = ZENKAKUHOSI4KETA;
        }

        String uktmidasi = "";

        String nenkinUktSeiYMD = "";

        String nknShrY = "";

        String nkShrStartYMD = "";

        String pHrkKkn = "";

        String haitoukinUketoriHouKbn = "";

        String hknKkn = "";

        if (C_UmuKbn.NONE.eq(kjnNkKoujyUm)) {

            uktmidasi = "保険金";

            nenkinUktSeiYMD = ZENKAKUHOSI11KETA;

            nknShrY = ZENKAKUHOSI3KETA;

            nkShrStartYMD = ZENKAKUHOSI11KETA;

            pHrkKkn = "**";

            if (C_HaitoukinuketorihouKbn.TUMIHAI.eq(pKoujyoSym.getHaitoukinuketorihoukbn())) {

                haitoukinUketoriHouKbn = "積立";
            }
            else {

                haitoukinUketoriHouKbn = "無配当";
            }

            if (pKoujyoSym.getHknkknsyu().compareTo(BizNumber.valueOf(99)) == 0) {

                hknKkn = "終身";
            }
            else {

                hknKkn = pKoujyoSym.getHknkknsyu().toString() + "年";
            }
        }
        else {

            uktmidasi = "年金";

            nenkinUktSeiYMD = DateFormatUtil.dateKANJISeirekiNoZero(pKoujyoSym.getNenkinuktseiymd());

            if (pKoujyoSym.getNknshry().equals("99")) {

                nknShrY = "終身";
            }
            else {

                nknShrY = pKoujyoSym.getNknshry().toString() + "年";
            }

            nkShrStartYMD = DateFormatUtil.dateKANJISeirekiNoZero(pKoujyoSym.getNkshrstartymd());

            pHrkKkn = pKoujyoSym.getPhrkkkn().toString();

            haitoukinUketoriHouKbn = ZENKAKUHOSI2KETA;

            hknKkn = ZENKAKUHOSI3KETA;

        }

        String newIppanJissekiP = "";

        String newIppanJissekiHaitoukin = "";

        String newIppanJissekiSyoumeigk = "";

        String newIppanNenkanP = "";

        String newIppanNenkanHaitoukin = "";

        String newIppanNenkanSyoumeigk = "";

        String newIryouJissekiP = "";

        String newIryouJissekiHaitoukin = "";

        String newIryouJissekiSyoumeigk = "";

        String newIryouNenkanP = "";

        String newIryouNenkanHaitoukin = "";

        String newIryouNenkanSyoumeigk = "";

        String newNkJissekiP = "";

        String newNkJissekiHaitoukin = "";

        String newNkJissekiSyoumeigk = "";

        String newNknenkanP = "";

        String newNknenkanHaitoukin = "";

        String newNknenkanSyoumeigk = "";

        String newHknJytuKikan = "";

        if (C_UmuKbn.ARI.eq(newSyoumeigkUmuKbn)) {

            if (BizUtil.isZero(pKoujyoSym.getNewippanjissekip())) {
                newIppanJissekiP = "";
            } else {
                newIppanJissekiP = pKoujyoSym.getNewippanjissekip().toString();
            }

            if (BizUtil.isZero(pKoujyoSym.getNewippanjissekihaitoukin())) {
                newIppanJissekiHaitoukin = "";
            } else {
                newIppanJissekiHaitoukin = pKoujyoSym.getNewippanjissekihaitoukin().toString();
            }

            int MasukuKetasuu = 0;

            String aftNewIppanJissekiSyoumeigk = "";

            if (BizUtil.isZero(pKoujyoSym.getNewippanjissekisyoumeigk())) {
                newIppanJissekiSyoumeigk = HANKAKUHOSI10KETA;

            } else {
                newIppanJissekiSyoumeigk = pKoujyoSym.getNewippanjissekisyoumeigk().toString();

                if (pKoujyoSym.getNewippanjissekisyoumeigk().compareTo(
                    BizCurrency.valueOf(0, pKoujyoSym.getNewippanjissekisyoumeigk().getType())) > 0) {

                    MasukuKetasuu = 10 - pKoujyoSym.getNewippanjissekisyoumeigk().toString().length();

                    aftNewIppanJissekiSyoumeigk = BizUtil.zeroNum(newIppanJissekiSyoumeigk, 10, 0);

                    newIppanJissekiSyoumeigk = BizUtil.editMask(aftNewIppanJissekiSyoumeigk, 0, MasukuKetasuu, '*');
                }
                else {
                    newIppanJissekiSyoumeigk = Strings.padStart(newIppanJissekiSyoumeigk, 10, ' ');
                }
            }


            if (BizUtil.isZero(pKoujyoSym.getNewippannenkanp())) {
                newIppanNenkanP = "";
            } else {
                newIppanNenkanP = pKoujyoSym.getNewippannenkanp().toString();
            }

            if (BizUtil.isZero(pKoujyoSym.getNewippannenkanhaitoukin())) {
                newIppanNenkanHaitoukin = "";
            } else {
                newIppanNenkanHaitoukin = pKoujyoSym.getNewippannenkanhaitoukin().toString();
            }

            if (BizUtil.isZero(pKoujyoSym.getNewippannenkansyoumeigk())) {
                newIppanNenkanSyoumeigk = HANKAKUHOSI10KETA;

            } else {
                newIppanNenkanSyoumeigk = pKoujyoSym.getNewippannenkansyoumeigk().toString();

                if (pKoujyoSym.getNewippannenkansyoumeigk().compareTo(
                    BizCurrency.valueOf(0, pKoujyoSym.getNewippannenkansyoumeigk().getType())) > 0) {

                    MasukuKetasuu = 10 - pKoujyoSym.getNewippannenkansyoumeigk().toString().length();

                    aftNewIppanJissekiSyoumeigk = BizUtil.zeroNum(newIppanNenkanSyoumeigk, 10, 0);

                    newIppanNenkanSyoumeigk = BizUtil.editMask(aftNewIppanJissekiSyoumeigk, 0, MasukuKetasuu, '*');
                }
                else {
                    newIppanNenkanSyoumeigk = Strings.padStart(newIppanNenkanSyoumeigk, 10, ' ');
                }
            }

            if (BizUtil.isZero(pKoujyoSym.getNewiryoujissekip())) {
                newIryouJissekiP = "";
            } else {
                newIryouJissekiP = pKoujyoSym.getNewiryoujissekip().toString();
            }

            if (BizUtil.isZero(pKoujyoSym.getNewiryoujissekihaitoukin())) {
                newIryouJissekiHaitoukin = "";
            } else {
                newIryouJissekiHaitoukin = pKoujyoSym.getNewiryoujissekihaitoukin().toString();
            }

            if (BizUtil.isZero(pKoujyoSym.getNewiryoujissekisyoumeigk())) {
                newIryouJissekiSyoumeigk = HANKAKUHOSI10KETA;

            } else {
                newIryouJissekiSyoumeigk = pKoujyoSym.getNewiryoujissekisyoumeigk().toString();

                if (pKoujyoSym.getNewiryoujissekisyoumeigk().compareTo(
                    BizCurrency.valueOf(0, pKoujyoSym.getNewiryoujissekisyoumeigk().getType())) > 0) {

                    MasukuKetasuu = 10 - pKoujyoSym.getNewiryoujissekisyoumeigk().toString().length();

                    aftNewIppanJissekiSyoumeigk = BizUtil.zeroNum(newIryouJissekiSyoumeigk, 10, 0);

                    newIryouJissekiSyoumeigk = BizUtil.editMask(aftNewIppanJissekiSyoumeigk, 0, MasukuKetasuu, '*');
                }
                else {
                    newIryouJissekiSyoumeigk = Strings.padStart(newIryouJissekiSyoumeigk, 10, ' ');
                }
            }

            if (BizUtil.isZero(pKoujyoSym.getNewiryounenkanp())) {
                newIryouNenkanP = "";
            } else {
                newIryouNenkanP = pKoujyoSym.getNewiryounenkanp().toString();
            }

            if (BizUtil.isZero(pKoujyoSym.getNewiryounenkanhaitoukin())) {
                newIryouNenkanHaitoukin = "";
            } else {
                newIryouNenkanHaitoukin = pKoujyoSym.getNewiryounenkanhaitoukin().toString();
            }

            if (BizUtil.isZero(pKoujyoSym.getNewiryounenkansyoumeigk())) {
                newIryouNenkanSyoumeigk = HANKAKUHOSI10KETA;

            } else {
                newIryouNenkanSyoumeigk = pKoujyoSym.getNewiryounenkansyoumeigk().toString();

                if (pKoujyoSym.getNewiryounenkansyoumeigk().compareTo(
                    BizCurrency.valueOf(0, pKoujyoSym.getNewiryounenkansyoumeigk().getType())) > 0) {

                    MasukuKetasuu = 10 - pKoujyoSym.getNewiryounenkansyoumeigk().toString().length();

                    aftNewIppanJissekiSyoumeigk = BizUtil.zeroNum(newIryouNenkanSyoumeigk, 10, 0);

                    newIryouNenkanSyoumeigk = BizUtil.editMask(aftNewIppanJissekiSyoumeigk, 0, MasukuKetasuu, '*');
                }
                else {
                    newIryouNenkanSyoumeigk = Strings.padStart(newIryouNenkanSyoumeigk, 10, ' ');
                }
            }

            if (BizUtil.isZero(pKoujyoSym.getNewnkjissekip())) {
                newNkJissekiP = "";
            } else {
                newNkJissekiP = pKoujyoSym.getNewnkjissekip().toString();
            }

            if (BizUtil.isZero(pKoujyoSym.getNewnkjissekihaitoukin())) {
                newNkJissekiHaitoukin = "";
            } else {
                newNkJissekiHaitoukin = pKoujyoSym.getNewnkjissekihaitoukin().toString();
            }

            if (BizUtil.isZero(pKoujyoSym.getNewnkjissekisyoumeigk())) {
                newNkJissekiSyoumeigk = HANKAKUHOSI10KETA;
            } else {
                newNkJissekiSyoumeigk = pKoujyoSym.getNewnkjissekisyoumeigk().toString();

                if (pKoujyoSym.getNewnkjissekisyoumeigk().compareTo(
                    BizCurrency.valueOf(0, pKoujyoSym.getNewnkjissekisyoumeigk().getType())) > 0) {

                    MasukuKetasuu = 10 - pKoujyoSym.getNewnkjissekisyoumeigk().toString().length();

                    aftNewIppanJissekiSyoumeigk = BizUtil.zeroNum(newNkJissekiSyoumeigk, 10, 0);

                    newNkJissekiSyoumeigk = BizUtil.editMask(aftNewIppanJissekiSyoumeigk, 0, MasukuKetasuu, '*');
                }
                else {
                    newNkJissekiSyoumeigk = Strings.padStart(newNkJissekiSyoumeigk, 10, ' ');
                }
            }

            if (BizUtil.isZero(pKoujyoSym.getNewnknenkanp())) {
                newNknenkanP = "";
            } else {
                newNknenkanP = pKoujyoSym.getNewnknenkanp().toString();
            }

            if (BizUtil.isZero(pKoujyoSym.getNewnknenkanhaitoukin())) {
                newNknenkanHaitoukin = "";
            } else {
                newNknenkanHaitoukin = pKoujyoSym.getNewnknenkanhaitoukin().toString();
            }

            if (BizUtil.isZero(pKoujyoSym.getNewnknenkansyoumeigk())) {
                newNknenkanSyoumeigk = HANKAKUHOSI10KETA;
            } else {
                newNknenkanSyoumeigk = pKoujyoSym.getNewnknenkansyoumeigk().toString();

                if (pKoujyoSym.getNewnknenkansyoumeigk().compareTo(
                    BizCurrency.valueOf(0, pKoujyoSym.getNewnknenkansyoumeigk().getType())) > 0) {

                    MasukuKetasuu = 10 - pKoujyoSym.getNewnknenkansyoumeigk().toString().length();

                    aftNewIppanJissekiSyoumeigk = BizUtil.zeroNum(newNknenkanSyoumeigk, 10, 0);

                    newNknenkanSyoumeigk = BizUtil.editMask(aftNewIppanJissekiSyoumeigk, 0, MasukuKetasuu, '*');
                }
                else {
                    newNknenkanSyoumeigk = Strings.padStart(newNknenkanSyoumeigk, 10, ' ');
                }
            }

            if (pKoujyoSym.getHknkknsyu().compareTo(BizNumber.valueOf(99)) == 0) {

                newHknJytuKikan = "終身";
            }

            else if (C_Kykjyoutai.ITIJIBARAI.eq(pKoujyoSym.getKykjyoutai())) {
                newHknJytuKikan = DefaultDateFormatter.formatYMKanji(pKoujyoSym.getKykymd().getBizDateYM().toString())
                    + "から"
                    + pKoujyoSym.getHknkknsyu().toString() + "年分";
            }
            else if (pKoujyoSym.getSyoumeikknnensuu() == 0
                && pKoujyoSym.getSyoumeikkntukisuu() == 0) {

                if (C_UmuKbn.NONE.eq(pKoujyoSym.getKjnnkkoujyum())) {

                    newHknJytuKikan = "入金なし";
                }
                else {
                    newHknJytuKikan = DefaultDateFormatter.formatYMKanji(pKoujyoSym.getSyoumeistartym().toString())
                        + "から入金なし";
                }
            }
            else {
                newHknJytuKikan = DefaultDateFormatter.formatYMKanji(pKoujyoSym.getSyoumeistartym().toString()) + "から";

                if (pKoujyoSym.getSyoumeikknnensuu() != 0) {

                    newHknJytuKikan = newHknJytuKikan + pKoujyoSym.getSyoumeikknnensuu() + "年";
                }

                if (pKoujyoSym.getSyoumeikkntukisuu() % 12 != 0) {

                    newHknJytuKikan = newHknJytuKikan + pKoujyoSym.getSyoumeikkntukisuu() % 12 + "か月";
                }
                newHknJytuKikan = newHknJytuKikan + "分";
            }

        }
        else {

            newIppanJissekiP = "";

            newIppanJissekiHaitoukin = "";

            newIppanJissekiSyoumeigk = HANKAKUHOSI10KETA;

            newIppanNenkanP = "";

            newIppanNenkanHaitoukin = "";

            newIppanNenkanSyoumeigk = HANKAKUHOSI10KETA;

            newIryouJissekiP = "";

            newIryouJissekiHaitoukin = "";

            newIryouJissekiSyoumeigk = HANKAKUHOSI10KETA;

            newIryouNenkanP = "";

            newIryouNenkanHaitoukin = "";

            newIryouNenkanSyoumeigk = HANKAKUHOSI10KETA;

            newNkJissekiP = "";

            newNkJissekiHaitoukin = "";

            newNkJissekiSyoumeigk = HANKAKUHOSI10KETA;

            newNknenkanP = "";

            newNknenkanHaitoukin = "";

            newNknenkanSyoumeigk = HANKAKUHOSI10KETA;

            newHknJytuKikan = ZENKAKUHOSI18KETA;

        }

        String midasiSub = "";
        if (C_SaihkHyjKbn.HYOUJI.eq(pKoujyoSym.getSaihkhyjkbn())) {

            midasiSub = "－再発行－";
        }

        String koujyosyoumeifreearea1 = "";

        if (C_KoujyosyoumeimsgKbn.YENHNDSNKKYTGKKSNHK.eq(pKoujyoSym.getKoujyosyoumeimsgkbn())) {

            koujyosyoumeifreearea1 = "本商品は、円貨払込保険料が変動するため、申告予定額は記載しておりません。";
        }

        KhKoujyosyoumeisyoBean khKoujyosyoumeisyoBean = SWAKInjector.getInstance(KhKoujyosyoumeisyoBean.class);

        BzKokyakuAtesakiBean kokyakuAtesakiBean = SWAKInjector.getInstance(BzKokyakuAtesakiBean.class);

        String hknkisynm = YuyuBizConfig.getInstance().getHokenKaisyaNmKanji();

        String[] hensyuugoAdr = ViewReport.editAdrDisp(24, pKoujyoSym.getTsinadr1kj(), pKoujyoSym.getTsinadr2kj(),
            pKoujyoSym.getTsinadr3kj());

        khKoujyosyoumeisyoBean.setIrKyknmkj(pKoujyoSym.getKyknmkj());

        khKoujyosyoumeisyoBean.setIrSyoumeinnd(DateFormatUtil.dateYKANJISeireki(pKoujyoSym.getNendo()));

        khKoujyosyoumeisyoBean.setIrUktnm(pKoujyoSym.getUktnmkjaddsama());

        khKoujyosyoumeisyoBean.setIrNenkinuktseiymd(nenkinUktSeiYMD);

        khKoujyosyoumeisyoBean.setIrSyono(pKoujyoSym.getSyono());

        khKoujyosyoumeisyoBean.setIrHknsyuruikoujyosyoumei(pKoujyoSym.getHknsyuruinmrykkj());

        khKoujyosyoumeisyoBean.setIrNkshrkknkoujyosyoumei(nknShrY);

        khKoujyosyoumeisyoBean.setIrKeiyakuymd(DateFormatUtil.dateKANJISeirekiNoZero(pKoujyoSym.getKykymd()));

        khKoujyosyoumeisyoBean.setIrHaitoukinuketorihoukbn(haitoukinUketoriHouKbn);

        khKoujyosyoumeisyoBean.setIrHknkkn(hknKkn);

        khKoujyosyoumeisyoBean.setIrNkshrstartymd(nkShrStartYMD);

        khKoujyosyoumeisyoBean.setIrPhrkkkn(pHrkKkn);

        khKoujyosyoumeisyoBean.setIrHrkhou(hrkHou);

        khKoujyosyoumeisyoBean.setIrNewippanseimeip(newIppanJissekiP);

        khKoujyosyoumeisyoBean.setIrNewippanhaitoukin(newIppanJissekiHaitoukin);

        khKoujyosyoumeisyoBean.setIrNewippansyoumeigk(newIppanJissekiSyoumeigk);

        khKoujyosyoumeisyoBean.setIrNewnenkanippanseimeip(newIppanNenkanP);

        khKoujyosyoumeisyoBean.setIrNewnenkanippanhaitoukin(newIppanNenkanHaitoukin);

        khKoujyosyoumeisyoBean.setIrNewippansinkokugk(newIppanNenkanSyoumeigk);

        khKoujyosyoumeisyoBean.setIrNewiryouseimeip(newIryouJissekiP);
        khKoujyosyoumeisyoBean.setIrNewiryouhaitoukin(newIryouJissekiHaitoukin);

        khKoujyosyoumeisyoBean.setIrNewiryousyoumeigk(newIryouJissekiSyoumeigk);

        khKoujyosyoumeisyoBean.setIrNewnenkaniryouseimeip(newIryouNenkanP);

        khKoujyosyoumeisyoBean.setIrNewnenkaniryouhaitoukin(newIryouNenkanHaitoukin);

        khKoujyosyoumeisyoBean.setIrNewiryousinkokugk(newIryouNenkanSyoumeigk);

        khKoujyosyoumeisyoBean.setIrNewnkseimeip(newNkJissekiP);

        khKoujyosyoumeisyoBean.setIrNewnkhaitoukin(newNkJissekiHaitoukin);

        khKoujyosyoumeisyoBean.setIrNewnksyoumeigk(newNkJissekiSyoumeigk);

        khKoujyosyoumeisyoBean.setIrNewnenkannkseimeip(newNknenkanP);
        khKoujyosyoumeisyoBean.setIrNewnenkannkhaitoukin(newNknenkanHaitoukin);

        khKoujyosyoumeisyoBean.setIrNewnksinkokugk(newNknenkanSyoumeigk);

        khKoujyosyoumeisyoBean.setIrNewhknjytuKikan(newHknJytuKikan);

        khKoujyosyoumeisyoBean.setIrPhrkkknjyoutai(hrJyoutai);

        khKoujyosyoumeisyoBean.setIrSyoumeiymd(DateFormatUtil.dateKANJISeirekiNoZero(pKoujyoSym.getSyoumeiymd()));

        khKoujyosyoumeisyoBean.setIrUktmidasi(uktmidasi);

        khKoujyosyoumeisyoBean.setIrMidasisub(midasiSub);

        khKoujyosyoumeisyoBean.setIrKoujyosyoumeifreearea1(koujyosyoumeifreearea1);

        kokyakuAtesakiBean.setIrTyouhyousakuseiymd(DateFormatUtil.dateKANJISeirekiNoZero(pSyoriYmd));

        kokyakuAtesakiBean.setIrShsyno(pKoujyoSym.getTsinyno());

        kokyakuAtesakiBean.setIrShadr1kj(hensyuugoAdr[0]);

        kokyakuAtesakiBean.setIrShadr2kj(hensyuugoAdr[1]);

        kokyakuAtesakiBean.setIrShadr3kj(hensyuugoAdr[2]);

        kokyakuAtesakiBean.setIrShsnmkj(pKoujyoSym.getKyknmkj());

        kokyakuAtesakiBean.setIrToiawaseyno(pKoujyoSym.getToiawaseyno());

        kokyakuAtesakiBean.setIrToiawaseadr1kj(pKoujyoSym.getToiawaseadr1kj());

        kokyakuAtesakiBean.setIrToiawaseadr2kj(pKoujyoSym.getToiawaseadr2kj());

        kokyakuAtesakiBean.setIrToiawaseadr3kj(pKoujyoSym.getToiawaseadr3kj());

        kokyakuAtesakiBean.setIrHknkisynm(hknkisynm);

        kokyakuAtesakiBean.setIrToiawasesosiki(pKoujyoSym.getToiawasesosikinmkj());

        kokyakuAtesakiBean.setIrToiawasetelno(pKoujyoSym.getToiawasetelno());

        reportServicesBean.addParamObjects(new Object[] { khKoujyosyoumeisyoBean, kokyakuAtesakiBean });

        return reportServicesBean;
    }
}
