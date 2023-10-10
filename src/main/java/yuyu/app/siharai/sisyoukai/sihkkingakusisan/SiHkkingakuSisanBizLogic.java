package yuyu.app.siharai.sisyoukai.sihkkingakusisan;

import static yuyu.app.siharai.sisyoukai.sihkkingakusisan.GenSiHkkingakuSisanConstants.*;
import static yuyu.app.siharai.sisyoukai.sihkkingakusisan.SiHkkingakuSisanConstants.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.resource.ResourceUtil;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.common.base.CTIParamBean;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.GetSjkkktyouseiyouriritu;
import yuyu.common.biz.bzcommon.GetSjkkktyouseiyourirituBean;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.bzdairiten.BzHanteiAgUtil;
import yuyu.common.biz.kaikei.BzJkuSymtgoSknidougkKeisan;
import yuyu.common.biz.kaikei.BzJkuSymtgoSknidougkKeisanmtBean;
import yuyu.common.hozen.khcommon.KeisanKihrkP;
import yuyu.common.siharai.chksk.ChkKekkaBean;
import yuyu.common.siharai.chksk.ChkSubJisatuMenseki;
import yuyu.common.siharai.chksk.ChkSubSknnKaisiYmd;
import yuyu.common.siharai.chksk.ChkSubTmttknJyoutai;
import yuyu.common.siharai.edittbl.SiSiDetailParamBean;
import yuyu.common.siharai.kyk.KeiyakuInfoSyutoku;
import yuyu.common.siharai.kyk.KeiyakuPrm;
import yuyu.common.siharai.sicommon.CalcSeisankgk;
import yuyu.common.siharai.sicommon.DouituSyonoStyChk;
import yuyu.common.siharai.sicommon.SiCommonMojiretuHensyu;
import yuyu.common.siharai.sicommon.SiHkkingakuSisanParamBean;
import yuyu.common.siharai.sicommon.SiMeisaiCommonCalc;
import yuyu.common.siharai.sicommon.SiMeisaiCommonCalcBean;
import yuyu.common.siharai.sicommon.SiSiharaiKingakuKeisan;
import yuyu.common.siharai.sicommon.SiSiharaiKingakuKeisanBean;
import yuyu.common.siharai.sicommon.Siinhantei;
import yuyu.common.siharai.sicommon.TeisuuSiharai;
import yuyu.common.siharai.siedittyouhyou.EditEnkaryuui;
import yuyu.common.siharai.siedittyouhyou.EditEnkaryuuiBean;
import yuyu.common.siharai.siedittyouhyou.SiTyouhyouHensyuuCommonBean;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Bnshrkaisuu;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_GeninKbn;
import yuyu.def.classification.C_HasuukasanUmuKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_Hkuktsyu;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_NkHaitoukinuketorihouKbn;
import yuyu.def.classification.C_Nstknsyu;
import yuyu.def.classification.C_Nyktrksflg;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_SaisateiKbn;
import yuyu.def.classification.C_SeisankinKanritukaKbn;
import yuyu.def.classification.C_SiHonninKakninKekkaKbn;
import yuyu.def.classification.C_SiharaiTuukaKbn;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_SikinouModeIdKbn;
import yuyu.def.classification.C_SinsaGendoKknKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.classification.C_ZeitratkiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_SjkkkTyouseiyouRiritu2;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.JM_SiSyouhnZokusei;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.entity.JT_SiKykSyouhn;
import yuyu.def.db.entity.JT_SiUkt;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.result.bean.NyknJissekiRirekiByNyktrksflgBean;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.infr.kinoumode.KinouMode;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.OutputReport;
import yuyu.infr.report.swakreport.ReportServicesBean;

import com.google.common.collect.Lists;
/**
 * 保険金額試算 のビジネスロジックです。
 */
public class SiHkkingakuSisanBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private CTIParamBean cTIParamBean;

    @Inject
    private SiHkkingakuSisanUiBean uiBean;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private KinouMode kinouMode;

    @Inject
    private MessageManager messageManager;

    @Inject
    private CreateReport createReport;

    @Inject
    private OutputReport outputReport;

    private static final C_Kouteikanristatus[] KOUTEIKANRISTATUS_KANRYOU = { C_Kouteikanristatus.KANRYOU };

    void init() {
    }

    void clear() {
    }

    void ronriChkAndjyouhoSyutoku() {
        BizPropertyInitializer.initialize(uiBean);

        KeiyakuInfoSyutoku keiyakuInfoSyutoku = SWAKInjector.getInstance(KeiyakuInfoSyutoku.class);
        KeiyakuPrm keiyakuPrm = SWAKInjector.getInstance(KeiyakuPrm.class);

        keiyakuPrm.setSyono(uiBean.getSyono());

        keiyakuInfoSyutoku.getInfos(keiyakuPrm);

        List<JT_SiKykKihon> siKykKihonList = keiyakuInfoSyutoku.getKykKihons();

        if (siKykKihonList.get(0) == null) {
            throw new BizLogicException(MessageId.EBA0024, MessageUtil.getMessage(MessageId.IJW1001));
        }

        JT_SiKykKihon siKykKihon = siKykKihonList.get(0);

        uiBean.setKyknmkn(siKykKihon.getKyknmkn());
        uiBean.setKykseiymd(siKykKihon.getKykseiymd());
        uiBean.setKyknmkj(siKykKihon.getKyknmkj());
        uiBean.setKyksei(siKykKihon.getKyksei());

        uiBean.setTsinyno(siKykKihon.getTsinyno());
        uiBean.setTsinadr1kj(siKykKihon.getTsinadr1kj());
        uiBean.setTsinadr2kj(siKykKihon.getTsinadr2kj());
        uiBean.setTsinadr3kj(siKykKihon.getTsinadr3kj());

        uiBean.setHhknnmkn(siKykKihon.getHhknnmkn());
        uiBean.setHhknseiymd(siKykKihon.getHhknseiymd());
        uiBean.setHhknnmkj(siKykKihon.getHhknnmkj());
        uiBean.setHhknsei(siKykKihon.getHhknsei());

        List<JT_SiUkt> siUktList = siKykKihon.getSiUkts();

        for (int i = siUktList.size() - 1; i >= 0; i--) {
            if (!siUktList.get(i).getHkuktsyu().eq(C_Hkuktsyu.SBHKKUKT)) {
                siUktList.remove(i);
            }
        }

        uiBean.setSbuktnin(siKykKihon.getSbuktnin());

        for (int i = 0; i < siUktList.size(); i++) {
            if (i == 0) {
                uiBean.setDispsbuktkbn1(siUktList.get(i).getUktkbn());
                uiBean.setDispsbuktnmkn1(siUktList.get(i).getUktnmkn());
                uiBean.setDispsbuktnmkj1(siUktList.get(i).getUktnmkj());
                uiBean.setDispsbuktseiymd1(siUktList.get(i).getUktseiymd());
                uiBean.setDispsbuktbnwari1(siUktList.get(i).getUktbnwari());

            }
            else if (i == 1) {
                uiBean.setDispsbuktkbn2(siUktList.get(i).getUktkbn());
                uiBean.setDispsbuktnmkn2(siUktList.get(i).getUktnmkn());
                uiBean.setDispsbuktnmkj2(siUktList.get(i).getUktnmkj());
                uiBean.setDispsbuktseiymd2(siUktList.get(i).getUktseiymd());
                uiBean.setDispsbuktbnwari2(siUktList.get(i).getUktbnwari());
            }
            else if (i == 2) {
                uiBean.setDispsbuktkbn3(siUktList.get(i).getUktkbn());
                uiBean.setDispsbuktnmkn3(siUktList.get(i).getUktnmkn());
                uiBean.setDispsbuktnmkj3(siUktList.get(i).getUktnmkj());
                uiBean.setDispsbuktseiymd3(siUktList.get(i).getUktseiymd());
                uiBean.setDispsbuktbnwari3(siUktList.get(i).getUktbnwari());

            }
            else if (i == 3) {
                uiBean.setDispsbuktkbn4(siUktList.get(i).getUktkbn());
                uiBean.setDispsbuktnmkn4(siUktList.get(i).getUktnmkn());
                uiBean.setDispsbuktnmkj4(siUktList.get(i).getUktnmkj());
                uiBean.setDispsbuktseiymd4(siUktList.get(i).getUktseiymd());
                uiBean.setDispsbuktbnwari4(siUktList.get(i).getUktbnwari());

            }
        }

        uiBean.setKnsnkijyunymd(BizDate.getSysDate());
        uiBean.setSihknknuktbnwari(BizNumber.valueOf(100.00));

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(uiBean.getSyono());

        List<JT_SiKykSyouhn> siKykSyouhnList = siKykKihon.getSiKykSyouhns();
        uiBean.setSiKykSyouhn(siKykSyouhnList.get(0));

        if (C_Hrkkaisuu.ITIJI.eq(siKykKihon.getHrkkaisuu())) {
            NyknJissekiRirekiByNyktrksflgBean nyknJissekiRirekiByNyktrksflgBean = kykKihon
                .getNyknJissekiRirekiByNyktrksflg(C_Nyktrksflg.BLNK);

            List<IT_NyknJissekiRireki> nyknJissekiRirekiList = hozenDomManager
                .getNyknJissekiRirekisBySyonoMaxJyutoustartymNyktrksflg(uiBean.getSyono(), C_Nyktrksflg.BLNK);

            if (nyknJissekiRirekiList.size() > 0) {
                if (C_Tuukasyu.JPY.eq(nyknJissekiRirekiList.get(0).getRstuukasyu())) {
                    uiBean.setVhrkiyentkykwsratetuukasyu(uiBean.getSiKykSyouhn().getKyktuukasyu());
                    uiBean.setZeimuKihrkmpDispFlag(false);
                } else {
                    uiBean.setVhrkiyentkykwsratetuukasyu(nyknJissekiRirekiList.get(0).getRstuukasyu());
                    uiBean.setZeimuKihrkmpDispFlag(true);
                }
                HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
                CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(nyknJissekiRirekiList.get(0)
                    .getRstuukasyu());
                uiBean.setItijibrp(nyknJissekiRirekiList.get(0).getHrkp());
                uiBean.setKihrkmp(nyknJissekiRirekiByNyktrksflgBean.getSumRsgaku().get(currencyType));
                uiBean.setRyosyuymd(nyknJissekiRirekiList.get(0).getRyosyuymd());

                if (C_Tuukasyu.JPY.eq(nyknJissekiRirekiList.get(0).getRstuukasyu())) {
                    uiBean.setYenkansantkykwsrate(nyknJissekiRirekiList.get(0).getRyosyukwsrate());
                } else {
                    uiBean.setYenkansantkykwsrate(nyknJissekiRirekiList.get(0).getYenkansantkykwsrate());
                }

                uiBean.setVhrkiyenkansannyknkingk(nyknJissekiRirekiByNyktrksflgBean.getSumYenkansannyknkingk().get(
                    BizCurrencyTypes.YEN));
            }

        } else {
            KeisanKihrkP keisanKihrkP = SWAKInjector.getInstance(KeisanKihrkP.class);
            keisanKihrkP.exec(uiBean.getSyono(), uiBean.getSiKykSyouhn().getKyktuukasyu());
            uiBean.setKihrkmp(keisanKihrkP.getSkjHrktuukaKihrkP());
        }

        List<JM_SiSyouhnZokusei> siSyouhnZokuseiLst = siharaiDomManager.getSiSyouhnZokuseisBySyouhncdKyhgndkatakbnSyouhnsdno
            (uiBean.getSiKykSyouhn().getSyouhncd(), uiBean.getSiKykSyouhn().getKyhgndkatakbn(),  uiBean.getSiKykSyouhn().getSyouhnsdno());

        if (siSyouhnZokuseiLst.size() == 0) {
            throw new BizLogicException(MessageId.EBS0006, JM_SiSyouhnZokusei.TABLE_NAME,
                "syouhncd", uiBean.getSiKykSyouhn().getSyouhncd(),
                "kyhgndkatakbn", uiBean.getSiKykSyouhn().getKyhgndkatakbn().getValue(),
                "syouhnsdno", String.valueOf(uiBean.getSiKykSyouhn().getSyouhnsdno()));
        }

        uiBean.setSiKykKihon(siKykKihon);
        uiBean.setSiSyouhnZokuseiLst(siSyouhnZokuseiLst);
        if (C_Tuukasyu.JPY.eq(uiBean.getSiKykSyouhn().getKyktuukasyu())) {
            uiBean.setKnsnkijyunymdDispFlag(false);
        }
        else {
            uiBean.setKnsnkijyunymdDispFlag(true);
        }

        if (!C_YuukousyoumetuKbn.YUUKOU.eq(siKykKihon.getYuukousyoumetukbn())) {
            messageManager.addConversationMessageId(MessageId.WJA0024);
        }

        BM_SyouhnZokusei syouhnZokuseiSyu = bizDomManager.getSyouhnZokusei(uiBean.getSiKykSyouhn().getSyouhncd(),
            uiBean.getSiKykSyouhn().getSyouhnsdno());
        if (syouhnZokuseiSyu == null) {
            throw new BizLogicException(MessageId.EBS0005, BM_SyouhnZokusei.TABLE_NAME,
                "syouhncd", uiBean.getSiKykSyouhn().getSyouhncd(),
                "syouhnsdno ", String.valueOf(uiBean.getSiKykSyouhn().getSyouhnsdno()));
        }

        uiBean.setSyouhnZokusei(syouhnZokuseiSyu);

        if (C_UmuKbn.ARI.eq(uiBean.getSyouhnZokusei().getHeijyunbaraiumu())) {

            DouituSyonoStyChk douituSyonoStyChk = SWAKInjector.getInstance(DouituSyonoStyChk.class);

            boolean result = douituSyonoStyChk.exec(uiBean.getSyono(), TeisuuSiharai.JIMUTETUZUKICD_SISIBOU,
                KOUTEIKANRISTATUS_KANRYOU);

            if (!result) {
                messageManager.addConversationMessageId(MessageId.WJA1073);
            }
        }

        boolean bChkResult = BzHanteiAgUtil.isAgMrfkouzatoriatukaiKeyOyadrten(siKykKihon.getOyadrtencd());

        if (bChkResult) {
            messageManager.addConversationMessageId(MessageId.WBA1006);
        }
    }

    void taGamenSyori() {
        if (BizUtil.isBlank(uiBean.getSyono())) {
            throw new BizLogicException(MessageId.EBC0043, MessageUtil.getMessage(DDID_SEARCHCONDITION_SYONO
                .getErrorResourceKey()));
        }

        ronriChkAndjyouhoSyutoku();
    }

    void fromCTISyori() {
        uiBean.setSyono(cTIParamBean.getSyono());
    }

    void hokenKingakuSisan() {
        if (uiBean.getKnsnkijyunymd() != null && !uiBean.getKawaserate().isOptional()) {
            throw new BizLogicException(MessageId.EJA1007);
        }

        if (uiBean.getKnsnkijyunymd() == null
            && (uiBean.getKawaserate().isOptional() || BizNumber.valueOf(0).compareTo(uiBean.getKawaserate()) == 0)
            && (!C_Tuukasyu.JPY.eq(uiBean.getSiKykSyouhn().getKyktuukasyu()))) {
            throw new BizLogicException(MessageId.EJA1007);
        }

        if (uiBean.getKnsnkijyunymd() != null
            && (!C_Tuukasyu.JPY.eq(uiBean.getSiKykSyouhn().getKyktuukasyu()))) {
            GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

            C_ErrorKbn errorKbn = getKawaseRate.exec(uiBean.getKnsnkijyunymd(),
                C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                uiBean.getSiKykSyouhn().getKyktuukasyu(),
                C_Tuukasyu.JPY,
                C_KawasetekiyoKbn.TTM,
                C_KawasetsryKbn.SYUKKINRATE,
                C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                C_YouhiKbn.HUYOU);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                throw new BizLogicException(MessageId.EJA1008, uiBean.getKnsnkijyunymd().toString());
            }
        }

        if (uiBean.getSihknknuktbnwari().equals(BizNumber.valueOf(100)) &&
            C_HasuukasanUmuKbn.HASUUKASANARI.eq(uiBean.getHasuukasanhyouji())) {
            throw new BizLogicException(MessageId.EJA1041);
        }


        List<ChkKekkaBean> chkKekkaBeanLst = Lists.newArrayList();

        ChkSubSknnKaisiYmd chkSubSknnKaisiYmd = SWAKInjector.getInstance(ChkSubSknnKaisiYmd.class);
        for (JT_SiKykSyouhn siKykSyouhnTemp : uiBean.getSiKykKihon().getSiKykSyouhns()) {
            chkSubSknnKaisiYmd.exec(uiBean.getCalckijyunymd(), uiBean.getSiKykKihon().getHksknnkaisiymd(),
                siKykSyouhnTemp, chkKekkaBeanLst);

            if (chkKekkaBeanLst.size() != 0) {
                ResourceBundle resourceBundle = ResourceUtil.getApplicationResources();
                String strResult = resourceBundle.getString(JT_SiKykSyouhn.SKNNKAISIYMD);

                throw new BizLogicException(MessageId.EJA0076, strResult,
                    MessageUtil.getMessage(DDID_SISANINFO_CALCKIJYUNYMD.getErrorResourceKey()));
            }
        }
        if ( BizDateUtil.compareYmd(uiBean.getSiKykKihon().getSykyknyhenkouymd(), uiBean.getCalckijyunymd())
            == BizDateUtil.COMPARE_GREATER) {
            throw new BizLogicException(MessageId.EJA1045,
                MessageUtil.getMessage(DDID_SISANINFO_CALCKIJYUNYMD.getErrorResourceKey()));
        }

        if ((C_UmuKbn.ARI.eq(uiBean.getSiSyouhnZokuseiLst().get(0).getCalckijyunmiraibicheck())) &&
            ( BizDateUtil.compareYmd(uiBean.getCalckijyunymd(), BizDate.getSysDate()))
            == BizDateUtil.COMPARE_GREATER) {
            throw new BizLogicException(MessageId.EBA0026,
                MessageUtil.getMessage(DDID_SISANINFO_CALCKIJYUNYMD.getErrorResourceKey()));
        }

        if ((C_UmuKbn.ARI.eq(uiBean.getSiSyouhnZokuseiLst().get(0).getKyuuhu().getTmttknjyoutaicheck()))) {
            List<ChkKekkaBean> chkKekkaBeanList = Lists.newArrayList();

            ChkSubTmttknJyoutai chkSubTmttknJyoutai = SWAKInjector.getInstance(ChkSubTmttknJyoutai.class);

            chkSubTmttknJyoutai.exec(uiBean.getCalckijyunymd(), uiBean.getSyono(), uiBean.getSiKykSyouhn().getKykymd(),
                uiBean.getSiKykSyouhn().getTmttknitenymd(), chkKekkaBeanList);

            if (chkKekkaBeanList.size() != 0) {
                for (ChkKekkaBean chkKekkaBean : chkKekkaBeanList) {

                    if (C_SKNaiyouChkKbn.TMTTKIN_MIHANEI_CHK.eq(chkKekkaBean.getSKNaiyouChkKbn())) {
                        throw new BizLogicException(MessageId.EBA1052);
                    }

                    if (C_SKNaiyouChkKbn.TMTTKIN_ITENBI_CHK.eq(chkKekkaBean.getSKNaiyouChkKbn())) {
                        throw new BizLogicException(MessageId.EBA1053,
                            MessageUtil.getMessage(DDID_SISANINFO_CALCKIJYUNYMD.getErrorResourceKey()),
                            MessageUtil.getMessage(MessageId.IBW1022));
                    }
                }
            }
        }

        if (uiBean.getSiKykSyouhn().getYendthnkymd() != null
            && BizDateUtil.compareYmd(uiBean.getSiKykSyouhn().getYendthnkymd(), uiBean.getCalckijyunymd())
            == BizDateUtil.COMPARE_GREATER) {
            throw new BizLogicException(MessageId.EJA0076,
                MessageUtil.getMessage(ResourceUtil.getApplicationResources().getString(JT_SiKykSyouhn.YENDTHNKYMD)),
                MessageUtil.getMessage(DDID_SISANINFO_CALCKIJYUNYMD.getErrorResourceKey()));
        }

        if (C_Kykjyoutai.ZENNOU.eq(uiBean.getSiKykKihon().getKykjyoutai())) {
            BizDate jkipjytymOutouYmd = BizDate.valueOf(uiBean.getSiKykKihon().getNexthrkym(),
                uiBean.getSiKykSyouhn().getKykymd().getDay()).getRekijyou();

            if (BizDateUtil.compareYmd(uiBean.getCalckijyunymd(), jkipjytymOutouYmd) == BizDateUtil.COMPARE_GREATER ||
                BizDateUtil.compareYmd(uiBean.getCalckijyunymd(), jkipjytymOutouYmd) == BizDateUtil.COMPARE_EQUAL) {
                throw new BizLogicException(MessageId.EBA1055);
            }
        }

        JM_SiSyouhnZokusei siSyouhnZokusei = uiBean.getSiSyouhnZokuseiLst().get(0);
        uiBean.setJisatuMensekiDispFlag(false);
        if (C_GeninKbn.JS.eq(uiBean.getGeninkbn()) && siSyouhnZokusei.getJisatumensekinensuu() != 0) {
            ChkSubJisatuMenseki chkSubJisatuMenseki = SWAKInjector.getInstance(ChkSubJisatuMenseki.class);

            chkSubJisatuMenseki.exec(uiBean.getCalckijyunymd(), uiBean.getGeninkbn(), null, uiBean.getSiKykSyouhn(),
                siSyouhnZokusei, chkKekkaBeanLst);

            if (chkKekkaBeanLst.size() > 0) {
                uiBean.setJisatuMensekiDispFlag(true);
                uiBean.setSihknknuktbnwari(MAX_BNWARI);
            }
        }

        SiSiharaiKingakuKeisanBean siSiharaiKingakuKeisanBean = SWAKInjector
            .getInstance(SiSiharaiKingakuKeisanBean.class);
        SiSiharaiKingakuKeisan siSiharaiKingakuKeisan = SWAKInjector.getInstance(SiSiharaiKingakuKeisan.class);

        Siinhantei siinhantei = SWAKInjector.getInstance(Siinhantei.class);
        C_SiinKbn siinKbn = siinhantei.hanteiGeninKbn(uiBean.getGeninkbn());

        BizNumber kaiykSjkkkTyouseiyouRiritu = BizNumber.valueOf(0);
        Boolean minasiRiritu = false;
        GetSjkkktyouseiyourirituBean getSjkkktyouseiyourirituBean = SWAKInjector.getInstance(GetSjkkktyouseiyourirituBean.class);
        GetSjkkktyouseiyouriritu getSjkkktyouseiyouriritu = SWAKInjector.getInstance(GetSjkkktyouseiyouriritu.class);

        C_UmuKbn mvatekiumu = uiBean.getSyouhnZokusei().getMvatekiumu();
        C_UmuKbn heijyunbaraiumu = uiBean.getSyouhnZokusei().getHeijyunbaraiumu();

        if (C_UmuKbn.ARI.eq(mvatekiumu)) {
            getSjkkktyouseiyourirituBean.setSyouhncd(uiBean.getSiKykSyouhn().getSyouhncd());
            getSjkkktyouseiyourirituBean.setKijyunymd(uiBean.getCalckijyunymd());
            getSjkkktyouseiyourirituBean.setHknkkn(uiBean.getSiKykSyouhn().getHknkkn());
            getSjkkktyouseiyourirituBean.setHknkknsmnkbn(uiBean.getSiKykSyouhn().getHknkknsmnkbn());
            getSjkkktyouseiyourirituBean.setHhknnen(uiBean.getSiKykSyouhn().getHhknnen());

            C_ErrorKbn errorKbnSjkkk = getSjkkktyouseiyouriritu.exec(getSjkkktyouseiyourirituBean);

            if (errorKbnSjkkk.eq(C_ErrorKbn.ERROR)) {
                minasiRiritu = true;

                errorKbnSjkkk = getSjkkktyouseiyouriritu.execMaxkjnymd(getSjkkktyouseiyourirituBean);
                if (errorKbnSjkkk.eq(C_ErrorKbn.ERROR)) {
                    throw new BizLogicException(MessageId.EBS1006, BM_SjkkkTyouseiyouRiritu2.TABLE_NAME,
                        "syouhncd", uiBean.getSiKykSyouhn().getSyouhncd(),
                        "hknkkn", String.valueOf(uiBean.getSiKykSyouhn().getHknkkn()),
                        "hknkknsmnkbn", uiBean.getSiKykSyouhn().getHknkknsmnkbn().getValue(),
                        "hhknnen", String.valueOf(uiBean.getSiKykSyouhn().getHhknnen()));
                }
            }

            kaiykSjkkkTyouseiyouRiritu = getSjkkktyouseiyouriritu.getSjkkktyouseiyouriritu();

        }

        BizNumber gaikaknsnKawaserate = BizNumber.optional();
        if (!uiBean.getKawaserate().isOptional()) {
            gaikaknsnKawaserate = uiBean.getKawaserate().add(BizNumber.ONE);
        }

        siSiharaiKingakuKeisanBean.setSyoNo(uiBean.getSyono());
        siSiharaiKingakuKeisanBean.setSeikyuuSyubetu(uiBean.getSeikyuusyubetu());
        siSiharaiKingakuKeisanBean.setCalcKijyunYmd(uiBean.getCalckijyunymd());
        siSiharaiKingakuKeisanBean.setKnsnKijyunYmd(uiBean.getKnsnkijyunymd());
        siSiharaiKingakuKeisanBean.setKawaseRate(uiBean.getKawaserate());
        siSiharaiKingakuKeisanBean.setUktBnWari(uiBean.getSihknknuktbnwari());
        siSiharaiKingakuKeisanBean.setHasuuKasanHyouji(uiBean.getHasuukasanhyouji());
        siSiharaiKingakuKeisanBean.setInputShrhouSiteiKbn(C_InputShrhousiteiKbn.FBSOUKIN);

        if(uiBean.getKawaserate().isOptional()){
            siSiharaiKingakuKeisanBean.setSyoruiUkeYmd(uiBean.getKnsnkijyunymd());
        }else{
            siSiharaiKingakuKeisanBean.setSyoruiUkeYmd(BizDate.getSysDate());
        }

        siSiharaiKingakuKeisanBean.setHubiKanryouYmd(null);
        siSiharaiKingakuKeisanBean.setRikoukiTyuutuudanNissuu(0);
        siSiharaiKingakuKeisanBean.setSinsaGendoKknKbn(C_SinsaGendoKknKbn.BLNK);
        siSiharaiKingakuKeisanBean.setSUketoriHouhouKbn(uiBean.getSuketorihouhoukbn());
        siSiharaiKingakuKeisanBean.setSiharaiTuukaKbn(C_SiharaiTuukaKbn.GAIKASIHARAI);
        siSiharaiKingakuKeisanBean.setNkShrTkykNksyuKbn(C_Nstknsyu.BLNK);
        siSiharaiKingakuKeisanBean.setNkShrTkykNksyuKkn(0);
        siSiharaiKingakuKeisanBean.setBnShrKaisuu(C_Bnshrkaisuu.BLNK);
        siSiharaiKingakuKeisanBean.setNkKknJyutouGk(BizCurrency.valueOf(0));
        siSiharaiKingakuKeisanBean.setNkHaitoukinuketorihouKbn(C_NkHaitoukinuketorihouKbn.NONE);
        siSiharaiKingakuKeisanBean.setSiKykKihon(uiBean.getSiKykKihon());
        siSiharaiKingakuKeisanBean.setSiHonninKakninKbn(C_SiHonninKakninKekkaKbn.KOUZA);
        siSiharaiKingakuKeisanBean.setKeisanKahiKbn(C_KahiKbn.KA);
        siSiharaiKingakuKeisanBean.setYobidasimotoKinouId(kinou.getKinouId());
        siSiharaiKingakuKeisanBean.setSikinouModeIdKbn(C_SikinouModeIdKbn.valueOf(kinouMode.getKinouMode()));
        siSiharaiKingakuKeisanBean.setSiinKbn(siinKbn);
        siSiharaiKingakuKeisanBean.setSaisateiKbn(C_SaisateiKbn.BLNK);
        siSiharaiKingakuKeisanBean.setUktMnmeigiBangou("");
        siSiharaiKingakuKeisanBean.setKykMnmeigiBango("");
        siSiharaiKingakuKeisanBean.setBankCd("");
        siSiharaiKingakuKeisanBean.setKaiyakusjkkktyouseirirituUmKbn(mvatekiumu);
        siSiharaiKingakuKeisanBean.setKaiyakusjkkktyouseiriritu(kaiykSjkkkTyouseiyouRiritu);
        siSiharaiKingakuKeisanBean.setGaikaknsnKwsrate(gaikaknsnKawaserate);

        C_ErrorKbn errorKbn = siSiharaiKingakuKeisan.exec(siSiharaiKingakuKeisanBean);

        if (errorKbn.eq(C_ErrorKbn.ERROR)) {
            if (siSiharaiKingakuKeisan.getErrMsg().exists()) {
                throw new BizLogicException(siSiharaiKingakuKeisan.getErrMsg());
            }
        }

        SiHkkingakuSisanParamBean siHkkingakuSisanParamBean = siSiharaiKingakuKeisan.getSiHkkingakuSisanParamBean();

        String misyuupgaitoukkn = "";
        String mikeikapgaitoukkn = "";
        SiCommonMojiretuHensyu siCommonMojiretuHensyu = SWAKInjector.getInstance(SiCommonMojiretuHensyu.class);
        if (siHkkingakuSisanParamBean.getMisyuup().compareTo(
            BizCurrency.valueOf(0, siHkkingakuSisanParamBean.getMisyuup().getType())) != 0) {
            misyuupgaitoukkn = siCommonMojiretuHensyu.editPGaitoukkn(siHkkingakuSisanParamBean.getMisyuupjyuutouym(),
                siHkkingakuSisanParamBean.getMisyuupjyuutoukaisuuy(),
                siHkkingakuSisanParamBean.getMisyuupjyuutoukaisuum());
        }
        if (siHkkingakuSisanParamBean.getMikeikap().compareTo(
            BizCurrency.valueOf(0, siHkkingakuSisanParamBean.getMikeikap().getType())) != 0) {
            mikeikapgaitoukkn = siCommonMojiretuHensyu.editPGaitoukkn(
                siHkkingakuSisanParamBean.getMikeikapjyuutouym(),
                siHkkingakuSisanParamBean.getMikeikapjyuutoukaisuuy(),
                siHkkingakuSisanParamBean.getMikeikapjyuutoukaisuum());
        }

        if (uiBean.isJisatuMensekiDispFlag()) {
            uiBean.setHokenkinsyurui(JISATU_MENSEKI_SEISAN);
        }
        else {
            uiBean.setHokenkinsyurui(siHkkingakuSisanParamBean.getHokenkinsyurui());
        }
        uiBean.setDispsuketorihouhoukbn(siHkkingakuSisanParamBean.getSUketoriHouhouKbn());
        uiBean.setDispcalckijyunymd(siHkkingakuSisanParamBean.getCalcKijyunYmd());
        uiBean.setDispknsnkijyunymd(siHkkingakuSisanParamBean.getKnsnKijyunYmd());
        uiBean.setDisptuukasyu(uiBean.getSiKykSyouhn().getKyktuukasyu().getContent());
        uiBean.setDispkawaserate(siHkkingakuSisanParamBean.getKawaseRate());
        uiBean.setGaikaknsnkwsratekjymd(siHkkingakuSisanParamBean.getKnsnKijyunYmd());
        uiBean.setDisptuukasyu2(uiBean.getSiKykSyouhn().getKyktuukasyu().getContent());
        uiBean.setGaikaknsnkwsrate(siHkkingakuSisanParamBean.getGaikaknsnkwsrate());
        uiBean.setDispsihknknuktbnwari(siHkkingakuSisanParamBean.getUktBnWari());
        uiBean.setDisphasuukasanhyouji(uiBean.getHasuukasanhyouji());
        uiBean.setHokenkngk(siHkkingakuSisanParamBean.getBunkatugoHokenKngk());
        uiBean.setHaitoukin(siHkkingakuSisanParamBean.getBunkatugohaitoukin());
        uiBean.setSonotahaitoukin(siHkkingakuSisanParamBean.getBunkatugosonotahaitoukin());
        uiBean.setMikeikap(siHkkingakuSisanParamBean.getBunkatugomikeikap());
        uiBean.setMikeikapgaitoukkn(mikeikapgaitoukkn);
        uiBean.setMisyuup(siHkkingakuSisanParamBean.getBunkatugomisyuup());
        uiBean.setMisyuupgaitoukkn(misyuupgaitoukkn);
        uiBean.setZennouseisankgk(siHkkingakuSisanParamBean.getBunkatugozennouseisank());
        uiBean.setAzukarikingk(siHkkingakuSisanParamBean.getBunkatugoazukarikingk());
        uiBean.setKrkgk(siHkkingakuSisanParamBean.getBunkatugokrkgk());

        if (uiBean.isJisatuMensekiDispFlag()) {
            CalcSeisankgk calcSeisankgk = SWAKInjector.getInstance(CalcSeisankgk.class);
            calcSeisankgk.exec(uiBean.getSiKykSyouhn().getSyouhncd(), siHkkingakuSisanParamBean);

            BizCurrency sbymdSeisankGk = calcSeisankgk.getSbymdSeisankGk();

            uiBean.setPtumitatekin(sbymdSeisankGk);
            if (C_Tuukasyu.JPY.eq(uiBean.getSiKykSyouhn().getKyktuukasyu())) {
                uiBean.setJpyptumitatekin(BizCurrency.optional());
            }
            else {
                KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
                BizCurrency jpyptumitatekin = keisanGaikakanzan.exec(C_Tuukasyu.JPY, sbymdSeisankGk,
                    uiBean.getDispkawaserate(), C_HasuusyoriKbn.AGE);

                uiBean.setJpyptumitatekin(jpyptumitatekin);
            }
        }

        if (C_Tuukasyu.JPY.eq(uiBean.getSiKykSyouhn().getKyktuukasyu())) {
            uiBean.setYenhokenkngk(BizCurrency.optional());
            uiBean.setYenkahaitoukin(BizCurrency.optional());
            uiBean.setYenkasonotahaitoukin(BizCurrency.optional());
            uiBean.setYenkamikeikap(BizCurrency.optional());
            uiBean.setYenkamisyuup(BizCurrency.optional());
            uiBean.setYenkazennouseisankgk(BizCurrency.optional());
            uiBean.setYenkaazukarikingk(BizCurrency.optional());
            uiBean.setYenkakrkgk(BizCurrency.optional());
            uiBean.setDispyenkagoukeigk(BizCurrency.optional());
        } else {
            uiBean.setYenhokenkngk(siHkkingakuSisanParamBean.getBunkatugoYenHokenKngk());
            uiBean.setYenkahaitoukin(siHkkingakuSisanParamBean.getBunkatugoyenkahaitoukin());
            uiBean.setYenkasonotahaitoukin(siHkkingakuSisanParamBean.getBunkatugoyenkasonotahaitoukin());
            uiBean.setYenkamikeikap(siHkkingakuSisanParamBean.getBunkatugoyenkamikeikap());
            uiBean.setYenkamisyuup(siHkkingakuSisanParamBean.getBunkatugoyenkamisyuup());
            uiBean.setYenkazennouseisankgk(siHkkingakuSisanParamBean.getBunkatugoyenkazennouseisank());
            uiBean.setYenkaazukarikingk(siHkkingakuSisanParamBean.getBunkatugoyenkaazukarikingk());
            uiBean.setYenkakrkgk(siHkkingakuSisanParamBean.getBunkatugoyenkakrkgk());
            if (uiBean.isJisatuMensekiDispFlag()) {
                KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

                BizCurrency yenkaknsntkgk = uiBean.getPtumitatekin().add(
                    siHkkingakuSisanParamBean.getBunkatugoZitkazukarikingksiteituuka());
                if (C_SeisankinKanritukaKbn.SITEITUUKA.eq(uiBean.getSiSyouhnZokuseiLst().get(0)
                    .getZnnusisnkinknrtuukakbn())) {
                    yenkaknsntkgk = yenkaknsntkgk.add(uiBean.getZennouseisankgk());
                }
                if (C_SeisankinKanritukaKbn.SITEITUUKA.eq(uiBean.getSiSyouhnZokuseiLst().get(0)
                    .getMikeikapknrtuukakbn())) {
                    yenkaknsntkgk = yenkaknsntkgk.add(uiBean.getMikeikap());
                }
                BizCurrency yenkaknsnkekkakgk = keisanGaikakanzan.exec(C_Tuukasyu.JPY,
                    yenkaknsntkgk, uiBean.getDispkawaserate(), C_HasuusyoriKbn.AGE);

                BizCurrency goukeigk = yenkaknsnkekkakgk.add(uiBean.getYenkahaitoukin())
                    .add(uiBean.getYenkasonotahaitoukin()).
                    add(uiBean.getYenkakrkgk()).add(siHkkingakuSisanParamBean.getBunkatugoZitkazukarikingkyen());
                if (C_SeisankinKanritukaKbn.YENKA.eq(uiBean.getSiSyouhnZokuseiLst().get(0).getZnnusisnkinknrtuukakbn())) {
                    goukeigk = goukeigk.add(uiBean.getYenkazennouseisankgk());
                }
                if (C_SeisankinKanritukaKbn.YENKA.eq(uiBean.getSiSyouhnZokuseiLst().get(0).getMikeikapknrtuukakbn())) {
                    goukeigk = goukeigk.add(uiBean.getYenkamikeikap());
                }
                uiBean.setDispyenkagoukeigk(goukeigk);

            }
            else {
                uiBean.setDispyenkagoukeigk(siHkkingakuSisanParamBean.getBunkatugoyenkagoukeigk());
            }
        }

        if (uiBean.isJisatuMensekiDispFlag()) {
            if (C_Tuukasyu.JPY.eq(uiBean.getSiKykSyouhn().getKyktuukasyu())) {
                uiBean.setDispgoukeigk(uiBean.getPtumitatekin().add(uiBean.getZennouseisankgk())
                    .add(uiBean.getMikeikap()).add(uiBean.getKrkgk()).
                    add(uiBean.getHaitoukin()).add(uiBean.getSonotahaitoukin()));
            }
            else {
                BizCurrency gaikaknsntkgk = uiBean.getYenkahaitoukin().add(uiBean.getYenkasonotahaitoukin())
                    .add(uiBean.getYenkakrkgk().add(siHkkingakuSisanParamBean.getBunkatugoZitkazukarikingkyen()));
                if (C_SeisankinKanritukaKbn.YENKA.eq(uiBean.getSiSyouhnZokuseiLst().get(0).getZnnusisnkinknrtuukakbn())) {
                    gaikaknsntkgk = gaikaknsntkgk.add(uiBean.getYenkazennouseisankgk());
                }
                if (C_SeisankinKanritukaKbn.YENKA.eq(uiBean.getSiSyouhnZokuseiLst().get(0).getMikeikapknrtuukakbn())) {
                    gaikaknsntkgk = gaikaknsntkgk.add(uiBean.getYenkamikeikap());
                }
                KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
                BizCurrency gaikaknsnkekkakgk = keisanGaikakanzan.execDivide(uiBean.getSiKykSyouhn().getKyktuukasyu(),
                    gaikaknsntkgk, uiBean.getGaikaknsnkwsrate(), C_HasuusyoriKbn.AGE);
                BizCurrency goukeigk = uiBean.getPtumitatekin().add(gaikaknsnkekkakgk)
                    .add(siHkkingakuSisanParamBean.getBunkatugoZitkazukarikingksiteituuka());
                if (C_SeisankinKanritukaKbn.SITEITUUKA.eq(uiBean.getSiSyouhnZokuseiLst().get(0).getZnnusisnkinknrtuukakbn())) {
                    goukeigk = goukeigk.add(uiBean.getZennouseisankgk());
                }
                if (C_SeisankinKanritukaKbn.SITEITUUKA.eq(uiBean.getSiSyouhnZokuseiLst().get(0).getMikeikapknrtuukakbn())) {
                    goukeigk = goukeigk.add(uiBean.getMikeikap());
                }
                uiBean.setDispgoukeigk(goukeigk);

            }
        }
        else {
            uiBean.setDispgoukeigk(siHkkingakuSisanParamBean.getBunkatugogoukeigk());
        }

        if (!C_ZeitratkiKbn.BLNK.eq(uiBean.getZeitratkikbn())) {

            SiMeisaiCommonCalcBean siMeisaiCommonCalcBean = SWAKInjector
                .getInstance(SiMeisaiCommonCalcBean.class);

            SiMeisaiCommonCalc siMeisaiCommonCalc = SWAKInjector.getInstance(SiMeisaiCommonCalc.class);

            siMeisaiCommonCalcBean.setKykTuukasyu(uiBean.getSiKykSyouhn().getKyktuukasyu());
            siMeisaiCommonCalcBean.setShrTuukasyu(C_Tuukasyu.JPY);
            siMeisaiCommonCalcBean.setKawaseRate(siHkkingakuSisanParamBean.getKawaseRate());
            siMeisaiCommonCalcBean.setGaikaknsnkwsrate(siHkkingakuSisanParamBean.getGaikaknsnkwsrate());
            siMeisaiCommonCalcBean.setZeimukwsrate(siHkkingakuSisanParamBean.getZeimukwsrate());
            siMeisaiCommonCalcBean.setHokenkngkgoukei(siHkkingakuSisanParamBean.getBunkatugoHokenKngk());
            siMeisaiCommonCalcBean.setZennouseisankgk(siHkkingakuSisanParamBean.getBunkatugozennouseisank());
            siMeisaiCommonCalcBean.setYenkazennouseisankgk(siHkkingakuSisanParamBean.getBunkatugoyenkazennouseisank());
            siMeisaiCommonCalcBean.setMisyuup(siHkkingakuSisanParamBean.getBunkatugomisyuup());
            siMeisaiCommonCalcBean.setMikeikap(siHkkingakuSisanParamBean.getBunkatugomikeikap());
            siMeisaiCommonCalcBean.setYenkamikeikap(siHkkingakuSisanParamBean.getBunkatugoyenkamikeikap());
            siMeisaiCommonCalcBean.setHaitoukin(siHkkingakuSisanParamBean.getBunkatugohaitoukin());
            siMeisaiCommonCalcBean.setYenkahaitoukin(siHkkingakuSisanParamBean.getBunkatugoyenkahaitoukin());
            siMeisaiCommonCalcBean.setSonotahaitoukin(siHkkingakuSisanParamBean.getBunkatugosonotahaitoukin());
            siMeisaiCommonCalcBean.setYenkasonotahaitoukin(siHkkingakuSisanParamBean.getBunkatugoyenkasonotahaitoukin());
            siMeisaiCommonCalcBean.setZitkazukarikingksiteituuka(siHkkingakuSisanParamBean.getBunkatugoZitkazukarikingksiteituuka());
            siMeisaiCommonCalcBean.setZitkazukarikingkyen(siHkkingakuSisanParamBean.getBunkatugoZitkazukarikingkyen());
            siMeisaiCommonCalcBean.setYenkakrkgk(siHkkingakuSisanParamBean.getBunkatugoyenkakrkgk());
            siMeisaiCommonCalcBean.setZeitratkikbn(uiBean.getZeitratkikbn());
            siMeisaiCommonCalcBean.setSyouhinCd(uiBean.getSiKykSyouhn().getSyouhncd());

            C_ErrorKbn errorKbnMeisaiCommonCalc1 = siMeisaiCommonCalc.exec(siMeisaiCommonCalcBean);

            if (C_ErrorKbn.ERROR.eq(errorKbnMeisaiCommonCalc1)) {
                throw new BizAppException(MessageId.EJA1027);
            }

            uiBean.setDispzeitratkikbn(uiBean.getZeitratkikbn());
            uiBean.setSynykngk(siMeisaiCommonCalc.getShrmisisynykngk());

            if (!C_Tuukasyu.JPY.eq(uiBean.getSiKykSyouhn().getKyktuukasyu())) {

                C_KawasetekiyoKbn kawasetekiyoKbn = C_KawasetekiyoKbn.BLNK;

                if (C_ZeitratkiKbn.ITIJI.eq(uiBean.getZeitratkikbn())) {
                    kawasetekiyoKbn = C_KawasetekiyoKbn.TTM;
                }
                else {
                    kawasetekiyoKbn = C_KawasetekiyoKbn.TTB;
                }

                GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

                getKawaseRate.exec(uiBean.getCalckijyunymd(), C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
                    uiBean.getSiKykSyouhn().getKyktuukasyu(), C_Tuukasyu.JPY, kawasetekiyoKbn,
                    C_KawasetsryKbn.JISSEIRATE, C_EigyoubiHoseiKbn.ZENEIGYOUBI, C_YouhiKbn.HUYOU);

                siMeisaiCommonCalcBean.setShrTuukasyu(uiBean.getSiKykSyouhn().getKyktuukasyu());
                siMeisaiCommonCalcBean.setZeimukwsrate(getKawaseRate.getKawaserate());

                C_ErrorKbn errorKbnMeisaiCommonCalc2 = siMeisaiCommonCalc.exec(siMeisaiCommonCalcBean);

                if (C_ErrorKbn.ERROR.eq(errorKbnMeisaiCommonCalc2)) {
                    throw new BizAppException(MessageId.EJA1027);
                }

                uiBean.setGaikashrsynykngk(siMeisaiCommonCalc.getShrmisisynykngk());
                uiBean.setKztkgk(siMeisaiCommonCalc.getShrmisikztkgk());

            }
        }

        if (C_Syoumetujiyuu.JIKOU.eq(uiBean.getSiKykKihon().getSyoumetujiyuu())) {

            BzJkuSymtgoSknidougkKeisanmtBean bzJkuSymtgoSknidougkKeisanmtBean = SWAKInjector
                .getInstance(BzJkuSymtgoSknidougkKeisanmtBean.class);

            BzJkuSymtgoSknidougkKeisan bzJkuSymtgoSknidougkKeisan = SWAKInjector
                .getInstance(BzJkuSymtgoSknidougkKeisan.class);

            bzJkuSymtgoSknidougkKeisanmtBean.setSyono(uiBean.getSyono());
            bzJkuSymtgoSknidougkKeisanmtBean.setSyouhncd(uiBean.getSiKykSyouhn().getSyouhncd());
            bzJkuSymtgoSknidougkKeisanmtBean.setKyktuukasyu(uiBean.getSiKykSyouhn().getKyktuukasyu());

            if (uiBean.isJisatuMensekiDispFlag()) {
                bzJkuSymtgoSknidougkKeisanmtBean.setHokenkngkgoukeiKyktuuka(uiBean.getPtumitatekin());
            } else {
                bzJkuSymtgoSknidougkKeisanmtBean.setHokenkngkgoukeiKyktuuka(siHkkingakuSisanParamBean.getBunkatugoHokenKngk());
            }
            bzJkuSymtgoSknidougkKeisanmtBean.setMisyuupKyktuuka(siHkkingakuSisanParamBean.getBunkatugomisyuup());
            bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankinKyktuuka(siHkkingakuSisanParamBean.getBunkatugozennouseisank());
            bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapKyktuuka(siHkkingakuSisanParamBean.getBunkatugomikeikap());

            if (BizDateUtil.compareYmd(uiBean.getCalckijyunymd(), uiBean.getSiKykSyouhn().getKykymd()) == BizDateUtil.COMPARE_LESSER) {
                bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankijyunymd(uiBean.getSiKykSyouhn().getKykymd());
            } else {
                bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankijyunymd(uiBean.getCalckijyunymd());
            }
            if (siHkkingakuSisanParamBean.getBunkatugomikeikap().compareTo(
                BizCurrency.valueOf(0, siHkkingakuSisanParamBean.getBunkatugomikeikap().getType())) == 0) {
                bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapjyuutouym(null);
            } else {
                bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapjyuutouym(siHkkingakuSisanParamBean.getMikeikapjyuutouym());
            }
            bzJkuSymtgoSknidougkKeisanmtBean.setZitkazkrknstituka(siHkkingakuSisanParamBean.getBunkatugoZitkazukarikingksiteituuka());
            bzJkuSymtgoSknidougkKeisanmtBean.setKykymd(uiBean.getSiKykSyouhn().getKykymd());

            C_ErrorKbn errorKbnJkuSymt = bzJkuSymtgoSknidougkKeisan
                .keisanJkuSymtgoSknidougk(bzJkuSymtgoSknidougkKeisanmtBean);

            if (C_ErrorKbn.ERROR.eq(errorKbnJkuSymt)) {
                throw new BizLogicException(bzJkuSymtgoSknidougkKeisan.getErrorMsgid(),
                    bzJkuSymtgoSknidougkKeisan.getErrorMsgInfo());
            }
            uiBean.setSisankekkaSikinidougakuDispFlag(true);
            uiBean.setSikinidougaku(bzJkuSymtgoSknidougkKeisan.getJkuSymtgoShrjSknidougk());
        }
        else {
            uiBean.setSisankekkaSikinidougakuDispFlag(false);
        }

        uiBean.setSisankekkaHaitoukinDispFlag(getSisankekkaDispFlg(siHkkingakuSisanParamBean.getBunkatugohaitoukin()));
        uiBean.setSisankekkaSonotahaitoukinDispFlag(getSisankekkaDispFlg(siHkkingakuSisanParamBean
            .getBunkatugosonotahaitoukin()));
        uiBean.setSisankekkaMikeikapDispFlag(getSisankekkaDispFlg(siHkkingakuSisanParamBean.getBunkatugomikeikap()));
        uiBean.setSisankekkaMisyuupDispFlag(getSisankekkaDispFlg(siHkkingakuSisanParamBean.getBunkatugomisyuup()));
        uiBean.setSisankekkaZennouseisankgkDispFlag(getSisankekkaDispFlg(siHkkingakuSisanParamBean
            .getBunkatugozennouseisank()));
        uiBean.setSisankekkaAzukarikingkDispFlag(getSisankekkaDispFlg(siHkkingakuSisanParamBean
            .getBunkatugoazukarikingk()));
        uiBean.setSisankekkaKrkgkDispFlag(getSisankekkaDispFlg(siHkkingakuSisanParamBean.getBunkatugokrkgk()));
        if (siHkkingakuSisanParamBean.getBunkatugoHokenKngk().compareTo(
            siHkkingakuSisanParamBean.getBunkatugogoukeigk()) == 0) {
            uiBean.setSisankekkaGoukeigkDispFlag(false);
        } else {
            uiBean.setSisankekkaGoukeigkDispFlag(true);
        }
        if (C_Tuukasyu.JPY.eq(uiBean.getSiKykSyouhn().getKyktuukasyu()) ||
            (!uiBean.isSisankekkaHaitoukinDispFlag() && !uiBean.isSisankekkaSonotahaitoukinDispFlag()
                && !uiBean.isSisankekkaMikeikapDispFlag() && !uiBean.isSisankekkaZennouseisankgkDispFlag()
                && !uiBean.isSisankekkaAzukarikingkDispFlag() && !uiBean.isSisankekkaKrkgkDispFlag())) {
            uiBean.setSisankekkaGaikaknsnkijyunymdDispFlag(false);
        } else {
            uiBean.setSisankekkaGaikaknsnkijyunymdDispFlag(true);
        }
        if (C_ZeitratkiKbn.BLNK.eq(uiBean.getZeitratkikbn())
            || uiBean.isJisatuMensekiDispFlag()
            || (C_Tuukasyu.JPY.eq(uiBean.getSiKykSyouhn().getKyktuukasyu()) && (C_ZeitratkiKbn.SOUZOKU.eq(uiBean
                .getZeitratkikbn()) || C_ZeitratkiKbn.ZOUYO.eq(uiBean.getZeitratkikbn())))) {
            uiBean.setSisankekkaZeimuInfoDispFlag(false);
        }
        else {
            uiBean.setSisankekkaZeimuInfoDispFlag(true);
        }
        if (C_ZeitratkiKbn.ITIJI.eq(uiBean.getZeitratkikbn())) {
            uiBean.setSisankekkaSynykngkDispFlag(true);
        }
        else {
            uiBean.setSisankekkaSynykngkDispFlag(false);
        }
        if (C_ZeitratkiKbn.ITIJI.eq(uiBean.getZeitratkikbn())
            && !C_Tuukasyu.JPY.eq(uiBean.getSiKykSyouhn().getKyktuukasyu())) {
            uiBean.setSisankekkaGaikashrsynykngkDispFlag(true);
        }
        else {
            uiBean.setSisankekkaGaikashrsynykngkDispFlag(false);
        }
        if (!C_Tuukasyu.JPY.eq(uiBean.getSiKykSyouhn().getKyktuukasyu())
            && (C_ZeitratkiKbn.SOUZOKU.eq(uiBean.getZeitratkikbn()) || C_ZeitratkiKbn.ZOUYO
                .eq(uiBean.getZeitratkikbn()))) {
            uiBean.setSisankekkaKztkgkDispFlag(true);
        }
        else {
            uiBean.setSisankekkaKztkgkDispFlag(false);
        }

        if (C_UmuKbn.ARI.eq(heijyunbaraiumu)) {
            uiBean.setItijibrpDispFlag(false);
            uiBean.setNyknymdDispFlag(false);
            uiBean.setNyknkawaserateDispFlag(false);
            uiBean.setZeimuKihrkmpDispFlag(false);
        } else {
            uiBean.setItijibrpDispFlag(true);
            uiBean.setNyknymdDispFlag(true);
            uiBean.setNyknkawaserateDispFlag(true);
        }

        uiBean.setSiHkkingakuSisanParamBean(siHkkingakuSisanParamBean);
        uiBean.setSiSiDetailParamBeanList(siSiharaiKingakuKeisan.getSiSiDetailParamBean());

        if (!C_Tuukasyu.JPY.eq(uiBean.getSiKykSyouhn().getKyktuukasyu())
            && !uiBean.getVhrkiyenkansannyknkingk().isOptional()
            && uiBean.getVhrkiyenkansannyknkingk().compareTo(siHkkingakuSisanParamBean.getYenHokenknGk()) > 0) {
            messageManager.addMessageId(MessageId.WJA1003);
        }

        if (C_UmuKbn.ARI.eq(heijyunbaraiumu) && BizCurrencyTypes.YEN.isSameCurrency(uiBean.getKihrkmp().getType())
            && !C_Tuukasyu.JPY.eq(uiBean.getSiKykSyouhn().getKyktuukasyu())
            && uiBean.getKihrkmp().compareTo(uiBean.getDispyenkagoukeigk()) > 0) {
            messageManager.addMessageId(MessageId.WJA1072);
        }

        if (minasiRiritu) {
            messageManager.addMessageId(MessageId.WJA1056);
        }

        if (C_UmuKbn.ARI.eq(siHkkingakuSisanParamBean.getSykSbYenSitiHsyuTkTekiUmu())) {
            messageManager.addMessageId(MessageId.WJA1054);
        }

        uiBean.setSisanKekkaFlag(true);
    }

    @Transactional
    void sisansyoSakusei() {
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        EditEnkaryuuiBean editEnkaryuuiBean = SWAKInjector.getInstance(EditEnkaryuuiBean.class);
        EditEnkaryuui editEnkaryuui = SWAKInjector.getInstance(EditEnkaryuui.class);

        SiHkkingakuSisanParamBean siHkkingakuSisanParamBean = uiBean.getSiHkkingakuSisanParamBean();

        List<SiSiDetailParamBean> siSiDetailParamBeanList = new ArrayList<>();
        for (SiSiDetailParamBean siSiDetailParamBean : uiBean.getSiSiDetailParamBeanList()) {
            if (!BizUtil.isZero(siSiDetailParamBean.getKyhkg())) {
                siSiDetailParamBeanList.add(siSiDetailParamBean);
            }
        }

        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.getSysDate());
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_ENKASIHARAIRYUUIJIKOU);

        editEnkaryuuiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        editEnkaryuuiBean.setSyoNo(uiBean.getSyono());
        editEnkaryuuiBean.setKyknmKj(uiBean.getKyknmkj());
        editEnkaryuuiBean.setHhknnmKj(uiBean.getHhknnmkj());
        editEnkaryuuiBean.setUktnmKj(uiBean.getDispsbuktnmkj1());
        editEnkaryuuiBean.setUkthouKbn(uiBean.getDispsuketorihouhoukbn());
        editEnkaryuuiBean.setCalckijyunYmd(uiBean.getDispcalckijyunymd());
        editEnkaryuuiBean.setUktbnWari(String.valueOf(uiBean.getDispsihknknuktbnwari().toString(new DecimalFormat("#,##0.00"))));
        editEnkaryuuiBean.setHkgkGaika(siHkkingakuSisanParamBean.getBunkatugogoukeigk());
        editEnkaryuuiBean.setHkgkYen(siHkkingakuSisanParamBean.getBunkatugoyenkagoukeigk());
        editEnkaryuuiBean.setTuukasyu(uiBean.getSiKykSyouhn().getKyktuukasyu());
        editEnkaryuuiBean.setSiHkkingakuSisanParamBean(siHkkingakuSisanParamBean);
        editEnkaryuuiBean.setSiSiDetailParamBeanList(siSiDetailParamBeanList);

        ReportServicesBean reportServicesBean = editEnkaryuui.exec(editEnkaryuuiBean);

        String tyouhyouKey = createReport.execNoCommit(reportServicesBean);

        uiBean.setReportKey(tyouhyouKey);

    }


    void printReport() {
        outputReport.outputPDFWithDel(uiBean.getReportKey());
        uiBean.setReportKey("");
    }

    private boolean getSisankekkaDispFlg(BizCurrency pKngk) {
        if (pKngk.compareTo(BizCurrency.valueOf(0, pKngk.getType())) == 0) {
            return false;
        }
        return true;
    }
}
