package yuyu.common.hozen.khcommon;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfo;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfoKekkaBean;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.bzcommon.SetNenrei;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.report.ViewReport;
import yuyu.common.direct.dscommon.CheckDsTorihikiService;
import yuyu.common.direct.dscommon.GetTrhkServiceTourokuJyoukyouBean;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.biz.bean.report.BzKokyakuAtesakiBean;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_Kaiyakujiyuu;
import yuyu.def.classification.C_KhTyouhyoumsgbunruiKbn1;
import yuyu.def.classification.C_KhTyouhyoumsgbunruiKbn2;
import yuyu.def.classification.C_KhTyouhyoumsgbunruiKbn3;
import yuyu.def.classification.C_Khhrshrjiyuu;
import yuyu.def.classification.C_Khskssakuseijiyuu;
import yuyu.def.classification.C_KykMsnKbn;
import yuyu.def.classification.C_KykdrknHtdjytKbn;
import yuyu.def.classification.C_KyksyaSibouUmuKbn;
import yuyu.def.classification.C_Meigihnkjiyuu;
import yuyu.def.classification.C_MousideIkouKbn;
import yuyu.def.classification.C_MousideninKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tmttknitenkbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiblnkKbn;
import yuyu.def.db.entity.IM_KhTyouhyoumsg2;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.bean.report.KhHanyouSouhuannaiBean;
import yuyu.def.hozen.bean.report.KhSouhuannaiBean;
import yuyu.def.hozen.configuration.YuyuHozenConfig;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 契約保全 契約保全共通 送付案内TBL編集
 */
public class EditSouhuannaiTbl {

    @Inject
    private HozenDomManager hozenDomManager;

    // Ph2で対応する
    //    @Inject
    //    private KhYakkanSouhuannaiBean khYakkanSouhuannaiBean;

    public EditSouhuannaiTbl() {
        super();
    }

    public ReportServicesBean editBean(C_SyoruiCdKbn pSyorui, String pSyoNo,
        KhozenCommonParam pKhozenCommonParam, EditSouhuannaiParam pEditSouhuannaiParam) {

        String shsyNo = "";

        String shAdr1Kj = "";

        String shAdr2Kj = "";

        String shAdr3Kj = "";

        String shsNmKj = "";

        String categoriID = pKhozenCommonParam.getCategoryId();

        String kinouID = pKhozenCommonParam.getFunctionId();

        String hokenKaisya = YuyuBizConfig.getInstance().getHokenKaisyaNmKanji();

        String tyouhYouSakusei = DateFormatUtil.dateKANJINoEx(BizDate.getSysDate());

        String sosikiCd = pKhozenCommonParam.getTmSosikiCd();

        int kykAge = 0;

        C_KykMsnKbn kykMsnKbn = C_KykMsnKbn.BLNK;

        int seijinNenrei = YuyuHozenConfig.getInstance().getSeijinNenrei();

        GetKhKykdrInfoBean getKhKykdrInfoBean = SWAKInjector.getInstance(GetKhKykdrInfoBean.class);

        List<IT_KykSyouhn> kykSyouhnLst = pKhozenCommonParam.getKeiyakuSyouhin(pSyoNo, C_SyutkKbn.SYU);

        C_YouhiblnkKbn fatcakakyhkbn;

        C_UmuKbn fatcaTaisyouUmu = kykSyouhnLst.get(0).getSyouhnZokusei().getFatcataisyouumu();

        if (C_UmuKbn.ARI.eq(fatcaTaisyouUmu)) {

            fatcakakyhkbn = C_YouhiblnkKbn.YOU;
        }
        else {

            fatcakakyhkbn = C_YouhiblnkKbn.HUYOU;
        }

        String ccSosikiCd = YuyuBizConfig.getInstance().getCallcentersosikicd();

        BzGetSosikiMadogutiInfo getSosikiMadogutiInfo = SWAKInjector.getInstance(BzGetSosikiMadogutiInfo.class);

        BzGetSosikiMadogutiInfoKekkaBean getSosikiMadogutiInfoKekkaBean = getSosikiMadogutiInfo.exec(sosikiCd);

        IT_KykSya kykSya = pKhozenCommonParam.getKeiyakusya(pSyoNo);

        IT_KykKihon kykKihon = pKhozenCommonParam.getKeiyakuKihon(pSyoNo);

        C_KykdrknHtdjytKbn kykdrknhatudoujyoutai = kykKihon.getKhTtdkTyuui().getKykdrknhatudoujyoutai();

        if (C_KykdrknHtdjytKbn.SETTEI.eq(kykdrknhatudoujyoutai)) {

            GetKhKykdrInfo getKhKykdrInfo = SWAKInjector.getInstance(GetKhKykdrInfo.class);

            getKhKykdrInfoBean = getKhKykdrInfo.exec(kykKihon);
        }

        if (IKhozenCommonConstants.KINOUID_KAIYAKU.equals(kinouID)) {

            if (C_Kaiyakujiyuu.TUUJYOU.eq(pEditSouhuannaiParam.getKaiyakujiyuu())) {

                if (C_KykdrknHtdjytKbn.SETTEI.eq(kykdrknhatudoujyoutai)) {

                    shsyNo = getKhKykdrInfoBean.getKykdryNo();

                    shAdr1Kj = getKhKykdrInfoBean.getKykdradr1();

                    shAdr2Kj = getKhKykdrInfoBean.getKykdradr2();

                    shAdr3Kj = getKhKykdrInfoBean.getKykdradr3();

                    shsNmKj = getKhKykdrInfoBean.getKkdairinmKj();
                }
                else {

                    shsyNo = kykSya.getTsinyno();

                    shAdr1Kj = kykSya.getTsinadr1kj();

                    shAdr2Kj = kykSya.getTsinadr2kj();

                    shAdr3Kj = kykSya.getTsinadr3kj();

                    shsNmKj = kykSya.getKyknmkj();
                }
            }
            else {

                if (!BizUtil.isBlank(pEditSouhuannaiParam.getShsyno())) {

                    shsyNo = pEditSouhuannaiParam.getShsyno();

                    shAdr1Kj = pEditSouhuannaiParam.getShsadr1kj();

                    shAdr2Kj = pEditSouhuannaiParam.getShsadr2kj();

                    shAdr3Kj = pEditSouhuannaiParam.getShsadr3kj();

                    shsNmKj = pEditSouhuannaiParam.getShsnmkj();
                }
            }
        }
        else {

            if (BizUtil.isBlank(pEditSouhuannaiParam.getShsyno())) {

                if (C_KykdrknHtdjytKbn.SETTEI.eq(kykdrknhatudoujyoutai)) {

                    shsyNo = getKhKykdrInfoBean.getKykdryNo();

                    shAdr1Kj = getKhKykdrInfoBean.getKykdradr1();

                    shAdr2Kj = getKhKykdrInfoBean.getKykdradr2();

                    shAdr3Kj = getKhKykdrInfoBean.getKykdradr3();

                    shsNmKj = getKhKykdrInfoBean.getKkdairinmKj();
                }
                else {

                    shsyNo = kykSya.getTsinyno();

                    shAdr1Kj = kykSya.getTsinadr1kj();

                    shAdr2Kj = kykSya.getTsinadr2kj();

                    shAdr3Kj = kykSya.getTsinadr3kj();

                    shsNmKj = kykSya.getKyknmkj();
                }
            }
            else {

                shsyNo = pEditSouhuannaiParam.getShsyno();

                shAdr1Kj = pEditSouhuannaiParam.getShsadr1kj();

                shAdr2Kj = pEditSouhuannaiParam.getShsadr2kj();

                shAdr3Kj = pEditSouhuannaiParam.getShsadr3kj();

                shsNmKj = pEditSouhuannaiParam.getShsnmkj();
            }
        }

        SetNenrei setNenrei = SWAKInjector.getInstance(SetNenrei.class);

        kykAge = setNenrei.exec(BizDate.getSysDate(), kykSya.getKykseiymd());

        if (kykAge < seijinNenrei) {

            kykMsnKbn = C_KykMsnKbn.MISEINEN;
        }
        else {

            kykMsnKbn = C_KykMsnKbn.SEINEN;
        }

        int syohinHanteiKbn = SyouhinUtil.hantei(kykSyouhnLst.get(0).getSyouhncd());

        CheckDsTorihikiService checkDsTorihikiService = SWAKInjector.getInstance(CheckDsTorihikiService.class);
        GetTrhkServiceTourokuJyoukyouBean getTrhkServiceTourokuJyoukyouBean = checkDsTorihikiService.getTrhkServiceTourokuJyoukyou(pSyoNo);

        C_UmuKbn dsKaiykServiceTourokuUmu = getTrhkServiceTourokuJyoukyouBean.getDsKaiykServiceTourokuUmu();
        C_KahiKbn dskaiyakuKahiKbn;

        if (C_UmuKbn.ARI.eq(dsKaiykServiceTourokuUmu)) {
            dskaiyakuKahiKbn = C_KahiKbn.KA;
        }
        else {
            dskaiyakuKahiKbn = C_KahiKbn.HUKA;
        }

        CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            IKhozenCommonConstants.SUBSYSTEMID_HOZEN,
            categoriID,
            kinouID,
            pSyorui);


        String[] editedadd = ViewReport.editAdrDisp(
            24,
            shAdr1Kj,
            shAdr2Kj,
            shAdr3Kj
            );

        String edaddress1 = editedadd[0];
        String edaddress2 = editedadd[1];
        String edaddress3 = editedadd[2];

        BzKokyakuAtesakiBean kokyakuAtesakiBean = SWAKInjector.getInstance(BzKokyakuAtesakiBean.class);

        kokyakuAtesakiBean.setIrTyouhyousakuseiymd(tyouhYouSakusei);

        kokyakuAtesakiBean.setIrShsyno(shsyNo);

        kokyakuAtesakiBean.setIrShadr1kj(edaddress1);

        kokyakuAtesakiBean.setIrShadr2kj(edaddress2);

        kokyakuAtesakiBean.setIrShadr3kj(edaddress3);

        kokyakuAtesakiBean.setIrShsnmkj(shsNmKj);

        kokyakuAtesakiBean.setIrHknkisynm(hokenKaisya);

        kokyakuAtesakiBean.setIrToiawasesosiki(getSosikiMadogutiInfoKekkaBean.getKanjisosikinm());

        kokyakuAtesakiBean.setIrToiawasetantounm(pKhozenCommonParam.getUserNm());

        kokyakuAtesakiBean.setIrToiawaseyno(getSosikiMadogutiInfoKekkaBean.getPostalCd());

        kokyakuAtesakiBean.setIrToiawaseadr1kj(getSosikiMadogutiInfoKekkaBean.getKanjisosikiadr1());

        kokyakuAtesakiBean.setIrToiawaseadr2kj(getSosikiMadogutiInfoKekkaBean.getKanjisosikiadr2());

        kokyakuAtesakiBean.setIrToiawasetelno(getSosikiMadogutiInfoKekkaBean.getTelno());

        if (C_SyoruiCdKbn.KK_SOUHUANNAI.eq(pSyorui)) {

            KhHanyouSouhuannaiBean khHanyouSouhuannaiBean = SWAKInjector.getInstance(KhHanyouSouhuannaiBean.class);

            khHanyouSouhuannaiBean.setIrHanyoushannaityouhyounm(pEditSouhuannaiParam.getHyshantyouhyounm());

            khHanyouSouhuannaiBean.setIrHanyoushannaiinjinaiyou(pEditSouhuannaiParam.getHyshaninjinaiyou());

            reportServicesBean.setKensakuKeys(pSyoNo);

            reportServicesBean.addParamObjects(khHanyouSouhuannaiBean, kokyakuAtesakiBean);

            return reportServicesBean;
        }

        IT_HhknSya hhknSya = pKhozenCommonParam.getHihokensya(pSyoNo);

        IT_KykSonotaTkyk kykSonotaTkyk = pKhozenCommonParam.getSonotaTokuyaku(pSyoNo);

        C_KyksyaSibouUmuKbn kykSbUmu;

        if (C_Meigihnkjiyuu.KYKSB.eq(pEditSouhuannaiParam.getMeigihnkjiyuu()) ||
            C_Khhrshrjiyuu.KYKSB.eq(pEditSouhuannaiParam.getHrshrjiyuu()) ||
            C_Kaiyakujiyuu.KYKSB.eq(pEditSouhuannaiParam.getKaiyakujiyuu())) {

            kykSbUmu = C_KyksyaSibouUmuKbn.KYKSBARI;
        }
        else {

            kykSbUmu = C_KyksyaSibouUmuKbn.BLNK;
        }

        C_MousideIkouKbn mousideIkouKbn = C_MousideIkouKbn.NONE;

        if (C_SyoruiCdKbn.KK_YENDTHNK_SOUHU.eq(pSyorui)) {
            mousideIkouKbn = kykSyouhnLst.get(0).getSyouhnZokusei().getMousideikoukbn();
        }

        C_Tuukasyu kykTuukaSyu = C_Tuukasyu.BLNK;

        if (C_SyoruiCdKbn.KK_SHIHARAI_SOUHU.eq(pSyorui)) {

            kykTuukaSyu = kykSyouhnLst.get(0).getKyktuukasyu();
        }

        C_KhTyouhyoumsgbunruiKbn1 khTyouhyoumsgbunruiKbn1 = checkKhTyouhyoumsgbunruiKbn1(
            pSyorui, pEditSouhuannaiParam.getSkssakuseijiyuu(), pEditSouhuannaiParam.getTmttknitenkbn(),
            pEditSouhuannaiParam.getMousideninkbn(), kykdrknhatudoujyoutai, mousideIkouKbn, kykTuukaSyu);

        IM_KhTyouhyoumsg2 khTyouhyoumsg = hozenDomManager.getKhTyouhyoumsg2(
            pSyorui, C_Meigihnkjiyuu.BLNK, kykSbUmu, C_UmuKbn.NONE, C_UmuKbn.NONE,
            khTyouhyoumsgbunruiKbn1, C_KhTyouhyoumsgbunruiKbn2.BLNK, C_KhTyouhyoumsgbunruiKbn3.BLNK);

        if (khTyouhyoumsg == null) {

            throw new CommonBizAppException("契約保全帳票メッセージMSTにデータが存在しません。");
        }

        KhSouhuannaiBean khSouhuannaiBean = SWAKInjector.getInstance(KhSouhuannaiBean.class);

        khSouhuannaiBean.setIrTyouhyousakuseiymd(tyouhYouSakusei);

        khSouhuannaiBean.setIrSouhuannaimsg1(khTyouhyoumsg.getRsouhuannaimsg1());

        khSouhuannaiBean.setIrSouhuannaimsg2(khTyouhyoumsg.getRsouhuannaimsg2());

        khSouhuannaiBean.setIrSouhuannaimsg3(khTyouhyoumsg.getRsouhuannaimsg3());

        khSouhuannaiBean.setIrSouhuannaimsg4(khTyouhyoumsg.getRsouhuannaimsg4());

        khSouhuannaiBean.setIrSouhuannaimsg5(khTyouhyoumsg.getRsouhuannaimsg5());

        khSouhuannaiBean.setIrSouhuannaimsg6(khTyouhyoumsg.getRsouhuannaimsg6());

        khSouhuannaiBean.setIrSouhuannaimsg7(khTyouhyoumsg.getRsouhuannaimsg7());

        khSouhuannaiBean.setIrSouhuannaimsg8(khTyouhyoumsg.getRsouhuannaimsg8());

        khSouhuannaiBean.setIrSouhuannaimsg9(khTyouhyoumsg.getRsouhuannaimsg9());

        khSouhuannaiBean.setIrSouhuannaimsg10(khTyouhyoumsg.getRsouhuannaimsg10());

        khSouhuannaiBean.setIrSyono(pSyoNo);

        khSouhuannaiBean.setIrHhknnmkj(hhknSya.getHhknnmkj());

        khSouhuannaiBean.setIrTargettkhkumu(pEditSouhuannaiParam.getTargetTkHkUmu());

        khSouhuannaiBean.setIrTargettkkbn(pEditSouhuannaiParam.getTargetTkKbn());

        khSouhuannaiBean.setIrSyosaihkymd(DateFormatUtil.dateKANJINoEx(kykKihon.getLastsyosaihkymd()));

        khSouhuannaiBean.setIrNexttkshrkjt(DateFormatUtil.dateKANJINoEx(pEditSouhuannaiParam.getNextTkshrkjt()));

        khSouhuannaiBean.setIrSeikyuukigenymd(DateFormatUtil.dateKANJINoEx(pEditSouhuannaiParam.getSeikyuukigenYmd()));

        khSouhuannaiBean.setIrSyoruicd(pSyorui);

        khSouhuannaiBean.setIrHengakuumukbn(kykSyouhnLst.get(0).getSyouhnZokusei().getHengakuumu());

        khSouhuannaiBean.setIrSibousumukbn(kykSyouhnLst.get(0).getSyouhnZokusei().getSbhkuktumu());

        khSouhuannaiBean.setIrSiboukyhkumukbn(kykSyouhnLst.get(0).getSyouhnZokusei().getSbkyuuhukinuktumu());

        khSouhuannaiBean.setIrStdrsktkyumukbn(kykSyouhnLst.get(0).getSyouhnZokusei().getStdrsktkumu());

        khSouhuannaiBean.setIrTargettkhnkkbn(pEditSouhuannaiParam.getTargetTkHenkouKbn());

        khSouhuannaiBean.setIrKkkyktdk(kykSya.getKkkyktdk());

        khSouhuannaiBean.setIrHenkankinumukbn(pEditSouhuannaiParam.getHenkankinumuKbn());

        khSouhuannaiBean.setIrNkshrtkykhnkkbn(pEditSouhuannaiParam.getNkshrtkykhnkKbn());

        khSouhuannaiBean.setIrMeigihnkjiyuu(pEditSouhuannaiParam.getMeigihnkjiyuu());

        khSouhuannaiBean.setIrKaiyakujiyuu(pEditSouhuannaiParam.getKaiyakujiyuu());

        khSouhuannaiBean.setIrKyknmkj(kykSya.getKyknmkj());

        khSouhuannaiBean.setIrTyouhyoutitle(khTyouhyoumsg.getTyouhyoutitle());

        khSouhuannaiBean.setIrFatcakakuninyhkbn(fatcakakyhkbn);

        khSouhuannaiBean.setIrTrhkjikakumukbn(pEditSouhuannaiParam.getTrhkjikakumukbn());

        khSouhuannaiBean.setIrSyouhnnm(kykSyouhnLst.get(0).getSyouhnZokusei().getSyouhnnmsyouken());

        khSouhuannaiBean.setIrKykmsnkbn(kykMsnKbn);

        khSouhuannaiBean.setIrJyudkaigomaebrtkykhnkkbn(pEditSouhuannaiParam.getJyudkaigomaebrtkykhnkkbn());

        khSouhuannaiBean.setIrHhknseiymdhenkouumu(pEditSouhuannaiParam.getHhknseiymdhenkouumu());

        khSouhuannaiBean.setIrHhknseihenkouumu(pEditSouhuannaiParam.getHhknseihenkouumu());

        khSouhuannaiBean.setIrKyktuukasyu(kykSyouhnLst.get(0).getKyktuukasyu());

        khSouhuannaiBean.setIrYendthnkHrgk(pEditSouhuannaiParam.getYendthnkhrgk());

        khSouhuannaiBean.setIrKhhrshrjiyuu(pEditSouhuannaiParam.getHrshrjiyuu());

        khSouhuannaiBean.setIrKhskssakuseijiyuu(pEditSouhuannaiParam.getSkssakuseijiyuu());

        khSouhuannaiBean.setIrTmttknitenkbn(pEditSouhuannaiParam.getTmttknitenkbn());

        khSouhuannaiBean.setIrTmttknitenuktkstartymd(DateFormatUtil.dateKANJINoEx(pEditSouhuannaiParam.getTmttknitenuktkstartymd()));

        khSouhuannaiBean.setIrSyoruiuktkkigenymd(DateFormatUtil.dateKANJINoEx(pEditSouhuannaiParam.getSyoruiuktkkigenymd()));

        khSouhuannaiBean.setIrGsbunritaisyouumukbn(pEditSouhuannaiParam.getGsbunritaisyouumukbn());

        khSouhuannaiBean.setIrSyouhnhanteikekka(syohinHanteiKbn);

        khSouhuannaiBean.setIrDskaiyakukahikbn(dskaiyakuKahiKbn);

        khSouhuannaiBean.setIrTmttknhaibunjyoutai(kykSyouhnLst.get(0).getTmttknhaibunjyoutai());

        khSouhuannaiBean.setIrCalckijyunymd(DateFormatUtil.dateKANJINoEx(pEditSouhuannaiParam.getCalckijyunymd()));

        khSouhuannaiBean.setIrTmtthtkinzndk(pEditSouhuannaiParam.getTmtthtkinzndk());

        khSouhuannaiBean.setIrZeiseitkkktkykhukaumu(kykSonotaTkyk.getZeiseitkkktkykhukaumu());

        khSouhuannaiBean.setIrKykjyoutai(kykSyouhnLst.get(0).getKykjyoutai());

        khSouhuannaiBean.setIrTmttknitenuktkkahikbn(pEditSouhuannaiParam.getTmttknitenuktkkahikbn());

        khSouhuannaiBean.setIrSyoumetuymd(DateFormatUtil.dateKANJINoEx(pEditSouhuannaiParam.getSyoumetuymd()));

        khSouhuannaiBean.setIrHaraimodosikngk(pEditSouhuannaiParam.getHaraimodosikngk());

        khSouhuannaiBean.setIrKykymd(DateFormatUtil.dateKANJINoEx(kykSyouhnLst.get(0).getKykymd()));

        khSouhuannaiBean.setIrMynosinkokutaisyouumukbn(pEditSouhuannaiParam.getMynosinkokutaisyouumukbn());

        khSouhuannaiBean.setIrKykdrknhatudoujyoutai(kykdrknhatudoujyoutai);

        khSouhuannaiBean.setIrMousideninkbn(pEditSouhuannaiParam.getMousideninkbn());

        khSouhuannaiBean.setIrSksnm(khTyouhyoumsg.getSksnm());

        khSouhuannaiBean.setIrMousideikoukbn(mousideIkouKbn);

        khSouhuannaiBean.setIrTuikahrkkinumu(pEditSouhuannaiParam.getTuikaHrkkinUmu());

        khSouhuannaiBean.setIrTuikahrkkin(pEditSouhuannaiParam.getTuikaHrkkin());

        khSouhuannaiBean.setIrYendthnkymd(DateFormatUtil.dateKANJINoEx(kykSyouhnLst.get(0).getYendthnkymd()));

        reportServicesBean.setKensakuKeys(pSyoNo);

        reportServicesBean.addParamObjects(khSouhuannaiBean, kokyakuAtesakiBean);

        return reportServicesBean;
    }

    private C_KhTyouhyoumsgbunruiKbn1 checkKhTyouhyoumsgbunruiKbn1(C_SyoruiCdKbn pSyorui,
        C_Khskssakuseijiyuu pKhskssakuseijiyuu, C_Tmttknitenkbn pTmttknitenkbn,
        C_MousideninKbn pMousideninKbn, C_KykdrknHtdjytKbn pKykdrknHtdiytKbn, C_MousideIkouKbn pMousideIkouKbn,
        C_Tuukasyu pKykTuukaSyu) {

        C_KhTyouhyoumsgbunruiKbn1 khTyouhyoumsgbunruiKbn1 = C_KhTyouhyoumsgbunruiKbn1.BLNK;

        if (C_SyoruiCdKbn.KK_YENDTHNKHNRKN_SOUHU.eq(pSyorui)) {

            if (C_Khskssakuseijiyuu.OKYAKUSAMAMOUSIDE.eq(pKhskssakuseijiyuu)) {

                khTyouhyoumsgbunruiKbn1 = C_KhTyouhyoumsgbunruiKbn1.OKYAKUSAMAMOUSIDE;

            } else if (C_Khskssakuseijiyuu.KOBETUKANSYOU.eq(pKhskssakuseijiyuu)) {

                khTyouhyoumsgbunruiKbn1 = C_KhTyouhyoumsgbunruiKbn1.KOBETUKANSYOU;
            }

        } else if (C_SyoruiCdKbn.KK_TUMITATEKINITEN_SOUHU.eq(pSyorui)) {

            if (C_Tmttknitenkbn.ITEN.eq(pTmttknitenkbn)) {

                khTyouhyoumsgbunruiKbn1 = C_KhTyouhyoumsgbunruiKbn1.TMTTKNITEN;

            } else if (C_Tmttknitenkbn.ITEN_TORIKESI.eq(pTmttknitenkbn)) {

                khTyouhyoumsgbunruiKbn1 = C_KhTyouhyoumsgbunruiKbn1.TMTTKNITENTORIKESI;
            }
        } else if (C_SyoruiCdKbn.KK_KZKTRKKYKDRTKYKHNK_SOUHU.eq(pSyorui)) {

            if ( C_MousideninKbn.KYKHONNIN.eq(pMousideninKbn) && C_KykdrknHtdjytKbn.BLNK.eq(pKykdrknHtdiytKbn)) {

                khTyouhyoumsgbunruiKbn1 = C_KhTyouhyoumsgbunruiKbn1. KYKMOUSIDE;
            }
        } else if (C_SyoruiCdKbn.KK_YENDTHNK_SOUHU.eq(pSyorui)) {

            if (C_MousideIkouKbn.YENSYUUSIN.eq(pMousideIkouKbn)) {

                khTyouhyoumsgbunruiKbn1 = C_KhTyouhyoumsgbunruiKbn1.YENDTHNK_SYUUSIN;
            }
            else if (C_MousideIkouKbn.YENNENKIN.eq(pMousideIkouKbn)) {

                khTyouhyoumsgbunruiKbn1 = C_KhTyouhyoumsgbunruiKbn1.YENDTHNK_NENKIN;
            }
        } else if (C_SyoruiCdKbn.KK_SHIHARAI_SOUHU.eq(pSyorui)) {

            if (C_Tuukasyu.JPY.eq(pKykTuukaSyu)) {

                khTyouhyoumsgbunruiKbn1 = C_KhTyouhyoumsgbunruiKbn1.YENDT;
            }
            else {

                khTyouhyoumsgbunruiKbn1 = C_KhTyouhyoumsgbunruiKbn1.GAIKADT;
            }
        }

        return khTyouhyoumsgbunruiKbn1;
    }
}
