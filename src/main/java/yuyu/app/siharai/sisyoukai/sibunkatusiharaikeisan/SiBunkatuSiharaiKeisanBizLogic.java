package yuyu.app.siharai.sisyoukai.sibunkatusiharaikeisan;

import static yuyu.app.siharai.sisyoukai.sibunkatusiharaikeisan.SiBunkatuSiharaiKeisanConstants.*;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.ConvertUtil;
import jp.co.slcs.swak.web.message.MessageManager;
import jp.co.slcs.swak.web.ui.LabelValuePair;
import jp.co.slcs.swak.web.ui.UserDefsList;

import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfo;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfoKekkaBean;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.bzcommon.KeisanTienrisoku;
import yuyu.common.biz.bzcommon.KeisanTienrisokuBean;
import yuyu.common.biz.bzcommon.SaibanBiz;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.siharai.edittbl.SiSiDetailParamBean;
import yuyu.common.siharai.kyk.KeiyakuInfoSyutoku;
import yuyu.common.siharai.kyk.KeiyakuPrm;
import yuyu.common.siharai.sicommon.CalcSiTyousyo;
import yuyu.common.siharai.sicommon.CalcSiTyousyoBean;
import yuyu.common.siharai.sicommon.HanteiSaikenInfoNyuuryoku;
import yuyu.common.siharai.sicommon.SiCommonMojiretuHensyu;
import yuyu.common.siharai.sicommon.SiCommonSiwake;
import yuyu.common.siharai.sicommon.SiCommonSiwakeBean;
import yuyu.common.siharai.sicommon.SiCommonSiwakeKekkaBean;
import yuyu.common.siharai.sicommon.SiDetailMikeikapBean;
import yuyu.common.siharai.sicommon.SiDetailMisyuupBean;
import yuyu.common.siharai.sicommon.SiMeisaiCommonCalc;
import yuyu.common.siharai.sicommon.SiMeisaiCommonCalcBean;
import yuyu.common.siharai.sicommon.SiSiharaiKingakuKeisan;
import yuyu.common.siharai.sicommon.SiSiharaiKingakuKeisanBean;
import yuyu.common.siharai.sicommon.SiharaigakuBean;
import yuyu.common.siharai.sicommon.TeisuuSiharai;
import yuyu.common.siharai.siedittyouhyou.EditSiharaimeisaisyo;
import yuyu.common.siharai.siedittyouhyou.EditSiharaimeisaisyoBean;
import yuyu.common.siharai.siedittyouhyou.SaikensyaInfoBean;
import yuyu.common.siharai.siedittyouhyou.SeikyuusyaInfoBean;
import yuyu.common.siharai.siedittyouhyou.SiTyouhyouHensyuuCommonBean;
import yuyu.common.siharai.siedittyouhyou.ToiawaseInfoBean;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_BunkatuHouhouKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_SUketoriHouhouKbn;
import yuyu.def.classification.C_SaisateiKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SeikyuusyaKbn;
import yuyu.def.classification.C_SeisankinKanritukaKbn;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_SiHonninKakninKekkaKbn;
import yuyu.def.classification.C_SiharaiTuukaKbn;
import yuyu.def.classification.C_SikinouModeIdKbn;
import yuyu.def.classification.C_SinsaGendoKknKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_ZeitratkiKbn;
import yuyu.def.db.entity.AS_FileSyurui;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.JM_SiSyouhnZokusei;
import yuyu.def.db.entity.JT_MisyuupMkkpDetail;
import yuyu.def.db.entity.JT_SiDenpyoData;
import yuyu.def.db.entity.JT_SiDetail;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.entity.JT_SiKykSyouhn;
import yuyu.def.db.entity.JT_Sk;
import yuyu.def.db.entity.JT_SkJiyuu;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.siharai.file.csv.SiBunkatuSiharaiKeisanLayoutFile;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.infr.kinoumode.KinouMode;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.OutputReport;
import yuyu.infr.report.swakreport.ReportServicesBean;

import com.google.common.collect.Lists;

/**
 * 分割支払計算 のビジネスロジックです。
 */
public class SiBunkatuSiharaiKeisanBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private SiBunkatuSiharaiKeisanUiBean uiBean;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private KinouMode kinouMode;

    @Inject
    private MessageManager messageManager;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BaseDomManager baseDomManager;

    void init() {
        clear();
    }

    void clear() {
    }

    String ketteiBtnOnClickBL(){

        setKykInfo();

        setNaiyouWarning();

        setUibean();

        BizPropertyInitializer.initialize(uiBean);

        return FORWARDNAME_INPUTCONTENTS;
    }

    String kakuninBtnOnClickBL(){

        chekNyuuryoku();

        execSiKingakukeisan();

        bunkatu();

        calcShrgk();

        setNaiyouWarning();
        setKakuninWarning();

        BizPropertyInitializer.initialize(uiBean);

        messageManager.addMessageId(MessageId.QBA0001);

        return FORWARDNAME_CONFIRM;

    }

    @Transactional
    String kakuteiBtnOnClickBL(){

        SiCommonSiwakeKekkaBean siCommonSiwakeKekkaBean = SWAKInjector.getInstance(SiCommonSiwakeKekkaBean.class);
        if (uiBean.getHasuuChk()) {
            siCommonSiwakeKekkaBean = siBunkatuSiwake();
        }

        CalcSiTyousyoBean calcSiTyousyoBean = siTyousyoSettei();

        makeSimeisaisyo();

        makeBunkatuCSV(calcSiTyousyoBean, siCommonSiwakeKekkaBean);

        return FORWARDNAME_RESULT;
    }

    void modoruBtnByInputContentsOnClickBL() {

        messageManager.removeConversationMessage(KEY_GROUP_MESSAGE);
    }

    void modoruBtnByConfirmOnClickBL() {

        messageManager.removeConversationMessage(INPUTCONTENTS_GROUP_MESSAGE);
    }

    void naiyounyuuryokugamenheBtnOnClickBL(){

        messageManager.removeConversationMessage(INPUTCONTENTS_GROUP_MESSAGE);
    }

    private void setNaiyouWarning() {

        if (!C_Tdk.HONNIN.eq(uiBean.getSiKykKihon().getKkkyktdk())) {
            messageManager.addConversationMessageId(KEY_GROUP_MESSAGE, MessageId.WJA1076);
        }
        HanteiSaikenInfoNyuuryoku hanteiSaikenInfoNyuuryoku = SWAKInjector.getInstance(HanteiSaikenInfoNyuuryoku.class);
        if(hanteiSaikenInfoNyuuryoku.exec(uiBean.getSiKykKihon())){
            messageManager.addConversationMessageId(KEY_GROUP_MESSAGE, MessageId.WJA1077);
        }

        if (C_NaiteiKakuteiKbn.NAITEI.eq(uiBean.getSkMax().getVhtnaiteikakuteikbn())) {
            messageManager.addConversationMessageId(KEY_GROUP_MESSAGE, MessageId.WJA1083);
        }
    }

    private void setKakuninWarning() {

        if (!uiBean.getHasuuChk()) {
            messageManager.addConversationMessageId(INPUTCONTENTS_GROUP_MESSAGE, MessageId.WJA1078);
        }

        if (C_UmuKbn.ARI.eq(uiBean.getSykSbYenSitiHsyuTkTekiUmu())) {

            messageManager.addConversationMessageId(INPUTCONTENTS_GROUP_MESSAGE, MessageId.WJA1054);
        }

        List<UktrInfoDataSourceBean> uktrInfoList = uiBean.getUktrInfoDataSource().getDatas();

        for (int i = 0; i < uiBean.getSbuktninint(); i++) {
            Boolean shrtaisyou = uktrInfoList.get(i).getShrtaisyou();
            if (shrtaisyou) {
                if (BizUtil.isBlank(uktrInfoList.get(i).getBnktsbuktnmkj())) {
                    messageManager.addConversationMessageId(INPUTCONTENTS_GROUP_MESSAGE, MessageId.WJA1074);
                }
            }
        }

        if (BizUtil.isBlank(uiBean.getTsinyno()) || BizUtil.isBlank(uiBean.getTsinadr1kj())) {
            messageManager.addConversationMessageId(INPUTCONTENTS_GROUP_MESSAGE, MessageId.WJA1075);
        }
    }

    private void makeBunkatuCSV(CalcSiTyousyoBean pCalcSiTyousyoBean, SiCommonSiwakeKekkaBean pSiCommonSiwakeKekkaBean) {

        List<SiBunkatuSiharaiKeisanLayoutFile> siBunkatuSiharaiKeisanLayoutFile = Lists.newArrayList();
        SiBunkatuSiharaiKeisanLayoutFile file = new SiBunkatuSiharaiKeisanLayoutFile();

        file.setIfcSyono(uiBean.getSyono());
        file.setIfcHnyksiinkbn(uiBean.getSkMax().getSiinkbn().getContent());
        file.setIfcSyouhncd(uiBean.getSiKykSyouhn().getSyouhncd());
        file.setIfcKyknmkn(uiBean.getSiKykKihon().getKyknmkn());
        file.setIfcKyknmkj(uiBean.getSiKykKihon().getKyknmkj());
        file.setIfcTsinyno(uiBean.getSiKykKihon().getTsinyno());
        file.setIfcTsinadr1kj(uiBean.getSiKykKihon().getTsinadr1kj());
        file.setIfcTsinadr2kj(uiBean.getSiKykKihon().getTsinadr2kj());
        file.setIfcTsinadr3kj(uiBean.getSiKykKihon().getTsinadr3kj());
        file.setIfcHhknnmkn(uiBean.getSiKykKihon().getHhknnmkn());
        file.setIfcHhknnmkj(uiBean.getSiKykKihon().getHhknnmkj());
        file.setIfcHhknyno(uiBean.getSiKykKihon().getHhknyno());
        file.setIfcHhknadr1kj(uiBean.getSiKykKihon().getHhknadr1kj());
        file.setIfcHhknadr2kj(uiBean.getSiKykKihon().getHhknadr2kj());
        file.setIfcHhknadr3kj(uiBean.getSiKykKihon().getHhknadr3kj());
        file.setIfcKyktuukasyukbn(uiBean.getSiKykSyouhn().getKyktuukasyu());
        file.setIfcSaiteihosyouumu(uiBean.getSiHkkingakuSisanParamBean().getSykSbYenSitiHsyuTkTekiUmu());
        file.setIfcKykhnkkaisuu(uiBean.getSiKykKihon().getKykhnkkaisuu());
        file.setIfcSbuktnin(uiBean.getSbuktninint());
        file.setIfcBunkatuhouhou(uiBean.getBunkatuhouhoukbn().getContent());

        List<UktrInfoDataSourceBean>  uktrInfoList = uiBean.getUktrInfoDataSource().getDatas();

        file.setIfcUktrwraibunsi1(uktrInfoList.get(0).getUktrwraibunsi());
        file.setIfcUktrwraibunbo1(uktrInfoList.get(0).getUktrwraibunbo());
        file.setIfcUktrwraibunsi2(uktrInfoList.get(1).getUktrwraibunsi());
        file.setIfcUktrwraibunbo2(uktrInfoList.get(1).getUktrwraibunbo());
        file.setIfcUktrwraibunsi3(uktrInfoList.get(2).getUktrwraibunsi());
        file.setIfcUktrwraibunbo3(uktrInfoList.get(2).getUktrwraibunbo());
        file.setIfcUktrwraibunsi4(uktrInfoList.get(3).getUktrwraibunsi());
        file.setIfcUktrwraibunbo4(uktrInfoList.get(3).getUktrwraibunbo());
        file.setIfcUktrwraibunsi5(uktrInfoList.get(4).getUktrwraibunsi());
        file.setIfcUktrwraibunbo5(uktrInfoList.get(4).getUktrwraibunbo());
        file.setIfcUktrwraibunsi6(uktrInfoList.get(5).getUktrwraibunsi());
        file.setIfcUktrwraibunbo6(uktrInfoList.get(5).getUktrwraibunbo());
        file.setIfcUktrwraibunsi7(uktrInfoList.get(6).getUktrwraibunsi());
        file.setIfcUktrwraibunbo7(uktrInfoList.get(6).getUktrwraibunbo());
        file.setIfcUktrwraibunsi8(uktrInfoList.get(7).getUktrwraibunsi());
        file.setIfcUktrwraibunbo8(uktrInfoList.get(7).getUktrwraibunbo());
        file.setIfcUktrwraibunsi9(uktrInfoList.get(8).getUktrwraibunsi());
        file.setIfcUktrwraibunbo9(uktrInfoList.get(8).getUktrwraibunbo());
        file.setIfcUktrwraibunsi10(uktrInfoList.get(9).getUktrwraibunsi());
        file.setIfcUktrwraibunbo10(uktrInfoList.get(9).getUktrwraibunbo());
        file.setIfcUktrwraibunsi11(uktrInfoList.get(10).getUktrwraibunsi());
        file.setIfcUktrwraibunbo11(uktrInfoList.get(10).getUktrwraibunbo());
        file.setIfcUktrwraibunsi12(uktrInfoList.get(11).getUktrwraibunsi());
        file.setIfcUktrwraibunbo12(uktrInfoList.get(11).getUktrwraibunbo());
        file.setIfcUktrwraibunsi13(uktrInfoList.get(12).getUktrwraibunsi());
        file.setIfcUktrwraibunbo13(uktrInfoList.get(12).getUktrwraibunbo());
        file.setIfcUktrwraibunsi14(uktrInfoList.get(13).getUktrwraibunsi());
        file.setIfcUktrwraibunbo14(uktrInfoList.get(13).getUktrwraibunbo());
        file.setIfcUktrwraibunsi15(uktrInfoList.get(14).getUktrwraibunsi());
        file.setIfcUktrwraibunbo15(uktrInfoList.get(14).getUktrwraibunbo());
        file.setIfcShrtaisyouuktrjuni(uiBean.getShrtaisyouuktrjuni());
        file.setIfcShrtuukasyu(uiBean.getSkBunkatugo().getShrtuukasyu());
        file.setIfcUktnmkj(uktrInfoList.get(uiBean.getShrtaisyouuktrjuni()-1).getBnktsbuktnmkj());
        file.setIfcShskyno(uiBean.getTsinyno());
        file.setIfcShskadr1kj(uiBean.getTsinadr1kj());
        file.setIfcShskadr2kj(uiBean.getTsinadr2kj());
        file.setIfcShskadr3kj(uiBean.getTsinadr3kj());
        file.setIfcSibouymd(uiBean.getSibouymd());
        file.setIfcSyoruiukeymd(uiBean.getSyoruiukeymd());
        file.setIfcShrymd(uiBean.getShrymd());
        file.setIfcSiboukariymd(uiBean.getSkKihon().getSiboukaritrkymd());
        file.setIfcShrkwsratekjnymd(uiBean.getShrkwsratekjnymd());
        file.setIfcShrkwsrate(uiBean.getShrkwsrate());
        file.setIfcGaikaknsnkwsratekjymd(uiBean.getGaikaknsnkwsratekjymd());
        file.setIfcGaikaknsnkwsrate(uiBean.getGaikaknsnkwsrate());
        file.setIfcZeimukwsratekjnymd(uiBean.getZeimukwsratekjnymd());
        file.setIfcZeimukwsrate(uiBean.getZeimukwsrate());

        file.setIfcBnktmaegaikagoukei(uiBean.getBnktmaegaikagoukei());
        file.setIfcBnktmaezitkazkrknstitk(uiBean.getBnkatmaezitkazkrknstituka());
        file.setIfcBnktmaemikeikap(uiBean.getBnktmaemikeikap());
        file.setIfcBnktmaemisyuup(uiBean.getBnktmaemisyuup());
        file.setIfcBnktmaeznnusisnkgk(uiBean.getBnktmaeznnusisnkgk());
        file.setIfcBnktmaeyengoukei(uiBean.getBnktmaeyengoukei());
        file.setIfcBnktmaeyenhaitoukin(uiBean.getBnktmaeyenhaitoukin());
        file.setIfcBnktmaeyensntahaitoukn(uiBean.getBnktmaeyensonotahaitoukin());
        file.setIfcBnktmaeyenmikeikap(uiBean.getBnktmaeyenmikeikap());
        file.setIfcBnktmaeyenmisyuup(uiBean.getBnktmaeyenmisyuup());
        file.setIfcBnktmaeyenznnusisnkgk(uiBean.getBnktmaeyenznnusisnkgk());
        file.setIfcBnktmaezitkazkrknyen(uiBean.getBnktmaezitkazkrknyen());
        file.setIfcBnktmaeyenkrkgk(uiBean.getBnktmaeyenkrkgk());

        file.setIfcBnktgogaikagoukei(uiBean.getSkBunkatugo().getYenkaknsntkgk());
        file.setIfcBnktgozitkazkrknstituka(uiBean.getSkBunkatugo().getZitkazukarikingksiteituuka());

        file.setIfcBnktgoyenkaknsntkgk(uiBean.getBnktgoyenkaknsntkgk());
        file.setIfcBnktgogaikaknsntkgk(uiBean.getBnktgogaikaknsntkgk());

        if (C_Tuukasyu.JPY.eq(uiBean.getSiKykSyouhn().getKyktuukasyu())) {

            file.setIfcBnktmaehokenkngkgoukei(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            file.setIfcBnktmaezitkazkrknstitk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            file.setIfcBnktmaemikeikap(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            file.setIfcBnktmaemisyuup(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            file.setIfcBnktmaeznnusisnkgk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            file.setIfcBnktmaeyenhknkngkguki(uiBean.getBnktmaeyenhknkngkguki());

            file.setIfcBnktgohokenkngkgoukei(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            file.setIfcBnktgomikeikap(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            file.setIfcBnktgomisyuup(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            file.setIfcBnktgoznnusisnkgk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            file.setIfcBnktgoyengoukei(uiBean.getSkBunkatugo().getHokenkngkgoukei().add(uiBean.getSkBunkatugo().getHaitoukin())
                .add(uiBean.getSkBunkatugo().getSonotahaitoukin()).add(uiBean.getSkBunkatugo().getMikeikap())
                .add(uiBean.getSkBunkatugo().getZennouseisankgk()).add(uiBean.getSkBunkatugo().getZitkazukarikingkyen())
                .add(uiBean.getSkBunkatugo().getKrkgk()).subtract(uiBean.getSkBunkatugo().getMisyuup()));
            file.setIfcBnktgoyenhknkngkguki(uiBean.getSkBunkatugo().getHokenkngkgoukei());
            file.setIfcBnktgoyenhaitoukin(uiBean.getSkBunkatugo().getHaitoukin());
            file.setIfcBnktgoyensonotahaitoukin(uiBean.getSkBunkatugo().getSonotahaitoukin());
            file.setIfcBnktgoyenmikeikap(uiBean.getSkBunkatugo().getMikeikap());
            file.setIfcBnktgoyenmisyuup(uiBean.getSkBunkatugo().getMisyuup().multiply(-1));
            file.setIfcBnktgoyenznnusisnkgk(uiBean.getSkBunkatugo().getZennouseisankgk());
            file.setIfcBnktgozitkazkrknyen(uiBean.getSkBunkatugo().getZitkazukarikingkyen());
            file.setIfcBnktgoyenkrkgk(uiBean.getSkBunkatugo().getKrkgk());

            file.setIfcBnktgogaikaknsntkgk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        } else {

            file.setIfcBnktmaehokenkngkgoukei(uiBean.getBnktmaehokenkngkgoukei());
            file.setIfcBnktmaeyenhknkngkguki(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            file.setIfcBnktgohokenkngkgoukei(uiBean.getSkBunkatugo().getHokenkngkgoukei());
            if (C_SeisankinKanritukaKbn.SITEITUUKA.eq(uiBean.getSiSyouhnZokusei().getMikeikapknrtuukakbn())) {
                file.setIfcBnktgomikeikap(uiBean.getSkBunkatugo().getMikeikap());
            } else {
                file.setIfcBnktgomikeikap(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            }

            if (C_SeisankinKanritukaKbn.SITEITUUKA.eq(uiBean.getSiSyouhnZokusei().getMsyupknrtuukakbn())) {
                file.setIfcBnktgomisyuup(uiBean.getSkBunkatugo().getMisyuup().multiply(-1));
            } else {
                file.setIfcBnktgomisyuup(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            }

            if (C_SeisankinKanritukaKbn.SITEITUUKA.eq(uiBean.getSiSyouhnZokusei().getZnnusisnkinknrtuukakbn())) {
                file.setIfcBnktgoznnusisnkgk(uiBean.getSkBunkatugo().getZennouseisankgk());
            } else {
                file.setIfcBnktgoznnusisnkgk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            }

            file.setIfcBnktgoyenhknkngkguki(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

            file.setIfcBnktgoyengoukei(uiBean.getSkBunkatugo().getGaikaknsntkgk());
            file.setIfcBnktgoyenhaitoukin(uiBean.getSkBunkatugo().getYenkahaitoukin());
            file.setIfcBnktgoyensonotahaitoukin(uiBean.getSkBunkatugo().getYenkasonotahaitoukin());
            if (C_SeisankinKanritukaKbn.YENKA.eq(uiBean.getSiSyouhnZokusei().getMikeikapknrtuukakbn())) {
                file.setIfcBnktgoyenmikeikap(uiBean.getSkBunkatugo().getYenkamikeikap());
            } else {
                file.setIfcBnktgoyenmikeikap(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            }
            if (C_SeisankinKanritukaKbn.YENKA.eq(uiBean.getSiSyouhnZokusei().getMsyupknrtuukakbn())) {
                file.setIfcBnktgoyenmisyuup(uiBean.getSkBunkatugo().getYenkamisyuup().multiply(-1));
            } else {
                file.setIfcBnktgoyenmisyuup(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            }
            if (C_SeisankinKanritukaKbn.YENKA.eq(uiBean.getSiSyouhnZokusei().getZnnusisnkinknrtuukakbn())) {
                file.setIfcBnktgoyenznnusisnkgk(uiBean.getSkBunkatugo().getYenkazennouseisankgk());
            } else {
                file.setIfcBnktgoyenznnusisnkgk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            }
            file.setIfcBnktgozitkazkrknyen(uiBean.getSkBunkatugo().getZitkazukarikingkyen());
            file.setIfcBnktgoyenkrkgk(uiBean.getSkBunkatugo().getYenkakrkgk());
        }

        if (C_SiharaiTuukaKbn.YENSIHARAI.eq(uiBean.getSiharaituukakbn())) {
            file.setIfcShrtienrsk(uiBean.getYenshrtienrsk().toString());
            file.setIfcShrkgbizc(uiBean.getBnktgoyengoukei());
            file.setIfckztgk(uiBean.getBnktgoyengoukei().subtract(uiBean.getYenshrtienrsk()).toString());
        } else {
            file.setIfcShrtienrsk(uiBean.getShrtienrsk().toString());
            file.setIfcShrkgbizc(uiBean.getBnktgogaikagoukei());
            file.setIfckztgk( uiBean.getKztkgk().toString());
        }
        file.setIfcSetc(pCalcSiTyousyoBean.getHokenkingaku().toString());
        file.setIfcMbrriekihaitou(pCalcSiTyousyoBean.getMiharaihaitou().toString());
        file.setIfcMihrkmpetc(pCalcSiTyousyoBean.getMiharaikomip().toString());
        file.setIfcZennouphrmdskn(pCalcSiTyousyoBean.getZennouptou().toString());
        file.setIfcSshkshrgketc(pCalcSiTyousyoBean.getSasihikis().toString());
        file.setIfcKihrkmpetc(pCalcSiTyousyoBean.getKibaraikomip().toString());


        List<JT_SiDenpyoData> siDenpyoDataList = pSiCommonSiwakeKekkaBean.getSiDenpyoDataLst();
        List<JT_SiDenpyoData> kRktSiDenpyoDataList = Lists.newArrayList();
        List<JT_SiDenpyoData> kSktSiDenpyoDataList = Lists.newArrayList();


        if (siDenpyoDataList != null){
            for (JT_SiDenpyoData data : siDenpyoDataList) {
                if (C_TaisyakuKbn.KARIKATA.eq(data.getTaisyakukbn())){
                    kRktSiDenpyoDataList.add(data);
                }

                if (C_TaisyakuKbn.KASIKATA.eq(data.getTaisyakukbn())){
                    kSktSiDenpyoDataList.add(data);
                }
            }
        }

        int kaRikatasize = kRktSiDenpyoDataList.size();
        int kaSikatasize = kSktSiDenpyoDataList.size();

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        if (kaRikatasize >= 1 ) {
            file.setIfcKrkanjyoukmkcd1(kRktSiDenpyoDataList.get(0).getKanjyoukmkcd());
            file.setIfcKrkanjyoukmknm1(kRktSiDenpyoDataList.get(0).getKanjyoukmkcd().getContent());
            BizCurrency denKngk = selectDenkngk(kRktSiDenpyoDataList.get(0));
            file.setIfcKrkngk1(denKngk);
            file.setIfcKrkngktani1(henkanTuuka.henkanTuukaTypeToKbn(denKngk.getType()));
        }

        if (kaRikatasize >= 2 ) {
            file.setIfcKrkanjyoukmkcd2(kRktSiDenpyoDataList.get(1).getKanjyoukmkcd());
            file.setIfcKrkanjyoukmknm2(kRktSiDenpyoDataList.get(1).getKanjyoukmkcd().getContent());
            BizCurrency denKngk = selectDenkngk(kRktSiDenpyoDataList.get(1));
            file.setIfcKrkngk2(denKngk);
            file.setIfcKrkngktani2(henkanTuuka.henkanTuukaTypeToKbn(denKngk.getType()));
        }

        if (kaRikatasize >= 3 ) {
            file.setIfcKrkanjyoukmkcd3(kRktSiDenpyoDataList.get(2).getKanjyoukmkcd());
            file.setIfcKrkanjyoukmknm3(kRktSiDenpyoDataList.get(2).getKanjyoukmkcd().getContent());
            BizCurrency denKngk = selectDenkngk(kRktSiDenpyoDataList.get(2));
            file.setIfcKrkngk3(denKngk);
            file.setIfcKrkngktani3(henkanTuuka.henkanTuukaTypeToKbn(denKngk.getType()));
        }

        if (kaRikatasize >= 4 ) {
            file.setIfcKrkanjyoukmkcd4(kRktSiDenpyoDataList.get(3).getKanjyoukmkcd());
            file.setIfcKrkanjyoukmknm4(kRktSiDenpyoDataList.get(3).getKanjyoukmkcd().getContent());
            BizCurrency denKngk = selectDenkngk(kRktSiDenpyoDataList.get(3));
            file.setIfcKrkngk4(denKngk);
            file.setIfcKrkngktani4(henkanTuuka.henkanTuukaTypeToKbn(denKngk.getType()));
        }

        if (kaRikatasize >= 5 ) {
            file.setIfcKrkanjyoukmkcd5(kRktSiDenpyoDataList.get(4).getKanjyoukmkcd());
            file.setIfcKrkanjyoukmknm5(kRktSiDenpyoDataList.get(4).getKanjyoukmkcd().getContent());
            BizCurrency denKngk = selectDenkngk(kRktSiDenpyoDataList.get(4));
            file.setIfcKrkngk5(denKngk);
            file.setIfcKrkngktani5(henkanTuuka.henkanTuukaTypeToKbn(denKngk.getType()));
        }

        if (kaRikatasize >= 6 ) {
            file.setIfcKrkanjyoukmkcd6(kRktSiDenpyoDataList.get(5).getKanjyoukmkcd());
            file.setIfcKrkanjyoukmknm6(kRktSiDenpyoDataList.get(5).getKanjyoukmkcd().getContent());
            BizCurrency denKngk = selectDenkngk(kRktSiDenpyoDataList.get(5));
            file.setIfcKrkngk6(denKngk);
            file.setIfcKrkngktani6(henkanTuuka.henkanTuukaTypeToKbn(denKngk.getType()));
        }

        if (kaRikatasize >= 7 ) {
            file.setIfcKrkanjyoukmkcd7(kRktSiDenpyoDataList.get(6).getKanjyoukmkcd());
            file.setIfcKrkanjyoukmknm7(kRktSiDenpyoDataList.get(6).getKanjyoukmkcd().getContent());
            BizCurrency denKngk = selectDenkngk(kRktSiDenpyoDataList.get(6));
            file.setIfcKrkngk7(denKngk);
            file.setIfcKrkngktani7(henkanTuuka.henkanTuukaTypeToKbn(denKngk.getType()));
        }

        if (kaRikatasize >= 8 ) {
            file.setIfcKrkanjyoukmkcd8(kRktSiDenpyoDataList.get(7).getKanjyoukmkcd());
            file.setIfcKrkanjyoukmknm8(kRktSiDenpyoDataList.get(7).getKanjyoukmkcd().getContent());
            BizCurrency denKngk = selectDenkngk(kRktSiDenpyoDataList.get(7));
            file.setIfcKrkngk8(denKngk);
            file.setIfcKrkngktani8(henkanTuuka.henkanTuukaTypeToKbn(denKngk.getType()));
        }

        if (kaRikatasize >= 9 ) {
            file.setIfcKrkanjyoukmkcd9(kRktSiDenpyoDataList.get(8).getKanjyoukmkcd());
            file.setIfcKrkanjyoukmknm9(kRktSiDenpyoDataList.get(8).getKanjyoukmkcd().getContent());
            BizCurrency denKngk = selectDenkngk(kRktSiDenpyoDataList.get(8));
            file.setIfcKrkngk9(denKngk);
            file.setIfcKrkngktani9(henkanTuuka.henkanTuukaTypeToKbn(denKngk.getType()));
        }

        if (kaRikatasize >= 10 ) {
            file.setIfcKrkanjyoukmkcd10(kRktSiDenpyoDataList.get(9).getKanjyoukmkcd());
            file.setIfcKrkanjyoukmknm10(kRktSiDenpyoDataList.get(9).getKanjyoukmkcd().getContent());
            BizCurrency denKngk = selectDenkngk(kRktSiDenpyoDataList.get(9));
            file.setIfcKrkngk10(denKngk);
            file.setIfcKrkngktani10(henkanTuuka.henkanTuukaTypeToKbn(denKngk.getType()));
        }

        if (kaSikatasize >= 1 ) {
            file.setIfcKskanjyoukmkcd1(kSktSiDenpyoDataList.get(0).getKanjyoukmkcd());
            file.setIfcKskanjyoukmknm1(kSktSiDenpyoDataList.get(0).getKanjyoukmkcd().getContent());
            BizCurrency denKngk = selectDenkngk(kSktSiDenpyoDataList.get(0));
            file.setIfcKskngk1(denKngk);
            file.setIfcKskngktani1(henkanTuuka.henkanTuukaTypeToKbn(denKngk.getType()));
        }

        if (kaSikatasize >= 2 ) {
            file.setIfcKskanjyoukmkcd2(kSktSiDenpyoDataList.get(1).getKanjyoukmkcd());
            file.setIfcKskanjyoukmknm2(kSktSiDenpyoDataList.get(1).getKanjyoukmkcd().getContent());
            BizCurrency denKngk = selectDenkngk(kSktSiDenpyoDataList.get(1));
            file.setIfcKskngk2(denKngk);
            file.setIfcKskngktani2(henkanTuuka.henkanTuukaTypeToKbn(denKngk.getType()));
        }

        if (kaSikatasize >= 3 ) {
            file.setIfcKskanjyoukmkcd3(kSktSiDenpyoDataList.get(2).getKanjyoukmkcd());
            file.setIfcKskanjyoukmknm3(kSktSiDenpyoDataList.get(2).getKanjyoukmkcd().getContent());
            BizCurrency denKngk = selectDenkngk(kSktSiDenpyoDataList.get(2));
            file.setIfcKskngk3(denKngk);
            file.setIfcKskngktani3(henkanTuuka.henkanTuukaTypeToKbn(denKngk.getType()));
        }

        if (kaSikatasize >= 4 ) {
            file.setIfcKskanjyoukmkcd4(kSktSiDenpyoDataList.get(3).getKanjyoukmkcd());
            file.setIfcKskanjyoukmknm4(kSktSiDenpyoDataList.get(3).getKanjyoukmkcd().getContent());
            BizCurrency denKngk = selectDenkngk(kSktSiDenpyoDataList.get(3));
            file.setIfcKskngk4(denKngk);
            file.setIfcKskngktani4(henkanTuuka.henkanTuukaTypeToKbn(denKngk.getType()));
        }

        if (kaSikatasize >= 5 ) {
            file.setIfcKskanjyoukmkcd5(kSktSiDenpyoDataList.get(4).getKanjyoukmkcd());
            file.setIfcKskanjyoukmknm5(kSktSiDenpyoDataList.get(4).getKanjyoukmkcd().getContent());
            BizCurrency denKngk = selectDenkngk(kSktSiDenpyoDataList.get(4));
            file.setIfcKskngk5(denKngk);
            file.setIfcKskngktani5(henkanTuuka.henkanTuukaTypeToKbn(denKngk.getType()));
        }

        if (kaSikatasize >= 6 ) {
            file.setIfcKskanjyoukmkcd6(kSktSiDenpyoDataList.get(5).getKanjyoukmkcd());
            file.setIfcKskanjyoukmknm6(kSktSiDenpyoDataList.get(5).getKanjyoukmkcd().getContent());
            BizCurrency denKngk = selectDenkngk(kSktSiDenpyoDataList.get(5));
            file.setIfcKskngk6(denKngk);
            file.setIfcKskngktani6(henkanTuuka.henkanTuukaTypeToKbn(denKngk.getType()));
        }

        if (kaSikatasize >= 7 ) {
            file.setIfcKskanjyoukmkcd7(kSktSiDenpyoDataList.get(6).getKanjyoukmkcd());
            file.setIfcKskanjyoukmknm7(kSktSiDenpyoDataList.get(6).getKanjyoukmkcd().getContent());
            BizCurrency denKngk = selectDenkngk(kSktSiDenpyoDataList.get(6));
            file.setIfcKskngk7(denKngk);
            file.setIfcKskngktani7(henkanTuuka.henkanTuukaTypeToKbn(denKngk.getType()));
        }

        if (kaSikatasize >= 8 ) {
            file.setIfcKskanjyoukmkcd8(kSktSiDenpyoDataList.get(7).getKanjyoukmkcd());
            file.setIfcKskanjyoukmknm8(kSktSiDenpyoDataList.get(7).getKanjyoukmkcd().getContent());
            BizCurrency denKngk = selectDenkngk(kSktSiDenpyoDataList.get(7));
            file.setIfcKskngk8(denKngk);
            file.setIfcKskngktani8(henkanTuuka.henkanTuukaTypeToKbn(denKngk.getType()));
        }

        if (kaSikatasize >= 9 ) {
            file.setIfcKskanjyoukmkcd9(kSktSiDenpyoDataList.get(8).getKanjyoukmkcd());
            file.setIfcKskanjyoukmknm9(kSktSiDenpyoDataList.get(8).getKanjyoukmkcd().getContent());
            BizCurrency denKngk = selectDenkngk(kSktSiDenpyoDataList.get(8));
            file.setIfcKskngk9(denKngk);
            file.setIfcKskngktani9(henkanTuuka.henkanTuukaTypeToKbn(denKngk.getType()));
        }

        if (kaSikatasize >= 10 ) {
            file.setIfcKskanjyoukmkcd10(kSktSiDenpyoDataList.get(9).getKanjyoukmkcd());
            file.setIfcKskanjyoukmknm10(kSktSiDenpyoDataList.get(9).getKanjyoukmkcd().getContent());
            BizCurrency denKngk = selectDenkngk(kSktSiDenpyoDataList.get(9));
            file.setIfcKskngk10(denKngk);
            file.setIfcKskngktani10(henkanTuuka.henkanTuukaTypeToKbn(denKngk.getType()));
        }


        siBunkatuSiharaiKeisanLayoutFile.add(file);

        BizDate sysDate = BizDate.getSysDate();

        AS_FileSyurui syurui = baseDomManager.getFileSyurui(C_FileSyuruiCdKbn.SI_BUNKATUSIHARAIKEISAN);

        if (syurui == null) {

            throw new BizLogicException(MessageId.EBF0129, MessageUtil.getMessage(kinou.getKinouNm()));
        }

        String downloadFileNm = syurui.getDownloadFileNm();
        String fileName1 = "";
        String fileName2 = "";

        fileName1 = downloadFileNm.split("\\.")[0];
        fileName2 =  "." + downloadFileNm.split("\\.")[1];

        String bunkatuSiFRenNo = SaibanBiz.getBunkatuSiKeisanFRenNo(String.valueOf(sysDate));

        BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);

        C_ErrorKbn errorKbn = bzFileUploadUtil.exec(C_FileSyuruiCdKbn.SI_BUNKATUSIHARAIKEISAN, siBunkatuSiharaiKeisanLayoutFile,
            true, bunkatuSiFRenNo);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            throw new BizLogicException(MessageId.EBF0129, MessageUtil.getMessage(kinou.getKinouNm()));
        }

        messageManager.addMessageId(MessageId.IAC0009);

        messageManager.addMessageId(MessageId.IBA1009, fileName1 + "_" + sysDate + "_" + bunkatuSiFRenNo + fileName2);

    }

    private BizCurrency selectDenkngk(JT_SiDenpyoData pSiDenpyoData) {

        BizCurrency denGaika = pSiDenpyoData.getDengaikagk();
        BizCurrency denYenka = pSiDenpyoData.getDenyenkagk();

        if (denGaika.compareTo(BizCurrency.valueOf(0, denGaika.getType())) > 0) {

            return denGaika;
        }

        return denYenka;
    }

    void pushKakuteiPrintOutBL() {

        String tyouhyouKey = uiBean.getResultTyouhyouKey();
        OutputReport outputReport = SWAKInjector.getInstance(OutputReport.class);

        outputReport.outputPDFByJoinKey(tyouhyouKey);

    }

    private void makeSimeisaisyo() {

        JT_Sk bunkatugoSK = uiBean.getSkBunkatugo();

        YuyuBizConfig yuyuBizConfig = YuyuBizConfig.getInstance();
        BzGetSosikiMadogutiInfo bzGetSosikiMadogutiInfo = SWAKInjector.getInstance(BzGetSosikiMadogutiInfo.class);

        String callcentersosikicd = yuyuBizConfig.getCallcentersosikicd();

        BzGetSosikiMadogutiInfoKekkaBean bzGetSosikiMadogutiInfoKekkaBean = bzGetSosikiMadogutiInfo.exec(callcentersosikicd);

        String callcentersosikiTelno = bzGetSosikiMadogutiInfoKekkaBean.getTelno();

        bzGetSosikiMadogutiInfoKekkaBean = bzGetSosikiMadogutiInfo.exec(baseUserInfo.getTmSosikiCd());


        List<JT_SiDetail> siDetailLst = Lists.newArrayList();

        for (int count = 0; count < uiBean.getSiSiDetailParamBeanLst().size(); count++){
            if(!BizUtil.isZero(uiBean.getSiSiDetailParamBeanLst().get(count).getKyhkg())){

                JT_SiDetail siDetail = new JT_SiDetail();

                BeanUtil.copyProperties(siDetail, uiBean.getSiSiDetailParamBeanLst().get(count));

                siDetailLst.add(siDetail);
            }
        }

        siDetailLst.get(0).setKyhkg(bunkatugoSK.getHokenkngkgoukei());
        siDetailLst.get(0).setYenkyhgk(bunkatugoSK.getYenhkgkgoukei());

        BizCurrency synykngk = BizCurrency.valueOf(0);
        BizCurrency kztkgk = BizCurrency.valueOf(0);

        SiMeisaiCommonCalcBean siMeisaiCommonCalcBean = SWAKInjector
            .getInstance(SiMeisaiCommonCalcBean.class);

        siMeisaiCommonCalcBean.setKykTuukasyu(bunkatugoSK.getKyktuukasyu());
        siMeisaiCommonCalcBean.setShrTuukasyu(bunkatugoSK.getShrtuukasyu());
        siMeisaiCommonCalcBean.setKawaseRate(bunkatugoSK.getShrkwsrate());
        siMeisaiCommonCalcBean.setGaikaknsnkwsrate(bunkatugoSK.getGaikaknsnkwsrate());
        siMeisaiCommonCalcBean.setZeimukwsrate(bunkatugoSK.getZeimukwsrate());
        siMeisaiCommonCalcBean.setHokenkngkgoukei(bunkatugoSK.getHokenkngkgoukei());
        siMeisaiCommonCalcBean.setZennouseisankgk(bunkatugoSK.getZennouseisankgk());
        siMeisaiCommonCalcBean.setYenkazennouseisankgk(bunkatugoSK.getYenkazennouseisankgk());
        siMeisaiCommonCalcBean.setMisyuup(bunkatugoSK.getMisyuup());
        siMeisaiCommonCalcBean.setMikeikap(bunkatugoSK.getMikeikap());
        siMeisaiCommonCalcBean.setYenkamikeikap(bunkatugoSK.getYenkamikeikap());
        siMeisaiCommonCalcBean.setHaitoukin(bunkatugoSK.getHaitoukin());
        siMeisaiCommonCalcBean.setYenkahaitoukin(bunkatugoSK.getYenkahaitoukin());
        siMeisaiCommonCalcBean.setSonotahaitoukin(bunkatugoSK.getSonotahaitoukin());
        siMeisaiCommonCalcBean.setYenkasonotahaitoukin(bunkatugoSK.getYenkasonotahaitoukin());
        siMeisaiCommonCalcBean.setZitkazukarikingksiteituuka(bunkatugoSK.getZitkazukarikingksiteituuka());
        siMeisaiCommonCalcBean.setZitkazukarikingkyen(bunkatugoSK.getZitkazukarikingkyen());
        siMeisaiCommonCalcBean.setYenkakrkgk(bunkatugoSK.getYenkakrkgk());
        siMeisaiCommonCalcBean.setZeitratkikbn(uiBean.getZeitratkikbn());
        siMeisaiCommonCalcBean.setSyouhinCd(siDetailLst.get(0).getSyouhncd());

        SiMeisaiCommonCalc siMeisaiCommonCalc = SWAKInjector.getInstance(SiMeisaiCommonCalc.class);

        C_ErrorKbn errorKbn = siMeisaiCommonCalc.exec(siMeisaiCommonCalcBean);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {
            throw new BizAppException(MessageId.EJA1027);
        }

        synykngk = siMeisaiCommonCalc.getShrmisisynykngk();
        kztkgk = siMeisaiCommonCalc.getShrmisikztkgk();
        uiBean.setKztkgk(kztkgk);


        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector.getInstance(SiTyouhyouHensyuuCommonBean.class);
        SeikyuusyaInfoBean seikyuusyaInfoBean = SWAKInjector.getInstance(SeikyuusyaInfoBean.class);
        SaikensyaInfoBean saikensyaInfoBean = SWAKInjector.getInstance(SaikensyaInfoBean.class);
        ToiawaseInfoBean toiawaseInfoBean =SWAKInjector.getInstance(ToiawaseInfoBean.class);
        EditSiharaimeisaisyoBean editSiharaimeisaisyoBean = SWAKInjector.getInstance(EditSiharaimeisaisyoBean.class);

        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.getSysDate());
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);

        seikyuusyaInfoBean.setSeikyuusyanmKn("");
        seikyuusyaInfoBean.setSeikyuusyanmKj(uiBean.getSitaisyouuketorinmkj());
        seikyuusyaInfoBean.setTsinyno(uiBean.getTsinyno());
        seikyuusyaInfoBean.setTsinadr1kj(uiBean.getTsinadr1kj());
        seikyuusyaInfoBean.setTsinadr2kj(uiBean.getTsinadr2kj());
        seikyuusyaInfoBean.setTsinadr3kj(uiBean.getTsinadr3kj());
        seikyuusyaInfoBean.setTsintelno("");

        toiawaseInfoBean.setSosikiNm(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikinm());
        toiawaseInfoBean.setTsinyno(bzGetSosikiMadogutiInfoKekkaBean.getPostalCd());
        toiawaseInfoBean.setTsinadr1kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr1());
        toiawaseInfoBean.setTsinadr2kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr2());
        toiawaseInfoBean.setTsinadr3kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr3());
        toiawaseInfoBean.setTsintelno(bzGetSosikiMadogutiInfoKekkaBean.getTelno());

        editSiharaimeisaisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        editSiharaimeisaisyoBean.setSeikyuusyaInfoBean(seikyuusyaInfoBean);
        editSiharaimeisaisyoBean.setSaikensyaInfoBean(saikensyaInfoBean);
        editSiharaimeisaisyoBean.setToiawaseInfoBean(toiawaseInfoBean);
        editSiharaimeisaisyoBean.setSyoNo(uiBean.getSyono());
        editSiharaimeisaisyoBean.setKyknmKj(uiBean.getSiKykKihon().getKyknmkj());
        editSiharaimeisaisyoBean.setHhknnmKj(uiBean.getSiKykKihon().getHhknnmkj());
        editSiharaimeisaisyoBean.setTyakkinYmd(uiBean.getShrymd());
        editSiharaimeisaisyoBean.setSibouYmd(uiBean.getSibouymd());
        editSiharaimeisaisyoBean.setKykTuukasyu(bunkatugoSK.getKyktuukasyu());
        editSiharaimeisaisyoBean.setShrTuukasyu(bunkatugoSK.getShrtuukasyu());
        editSiharaimeisaisyoBean.setShrKwsrate(uiBean.getShrkwsrate());
        editSiharaimeisaisyoBean.setKnsnkijyunymd(uiBean.getShrkwsratekjnymd());
        editSiharaimeisaisyoBean.setShrGk(bunkatugoSK.getShrgk());
        editSiharaimeisaisyoBean.setYenShrgk(bunkatugoSK.getYenshrgk());
        editSiharaimeisaisyoBean.setYokinKbn(C_YokinKbn.BLNK);
        editSiharaimeisaisyoBean.setSynykngk(synykngk);
        editSiharaimeisaisyoBean.setHtykeihi(bunkatugoSK.getGoukeihituyoukeihi());
        editSiharaimeisaisyoBean.setCctelNo(ConvertUtil.toZenNumeric(callcentersosikiTelno));
        editSiharaimeisaisyoBean.setSk(bunkatugoSK);
        editSiharaimeisaisyoBean.setSiDetailLst(siDetailLst);
        editSiharaimeisaisyoBean.setKztkgk(kztkgk);
        editSiharaimeisaisyoBean.setZeitratkiKbn(uiBean.getZeitratkikbn());
        editSiharaimeisaisyoBean.setKykHnkKaisuu(bunkatugoSK.getKykhnkkaisuu());
        editSiharaimeisaisyoBean.setShrKykHtyKeihi(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        editSiharaimeisaisyoBean.setKykjyoutai(uiBean.getSiKykKihon().getKykjyoutai());
        editSiharaimeisaisyoBean.setKouzaHyoujiUmu(C_UmuKbn.NONE);

        EditSiharaimeisaisyo editSiharaimeisaisyo = SWAKInjector.getInstance(EditSiharaimeisaisyo.class);

        List<ReportServicesBean> reportServicesBean = editSiharaimeisaisyo.exec(editSiharaimeisaisyoBean);

        CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);

        String tyouhyouKey = createReport.execNoCommit(reportServicesBean);

        uiBean.setResultTyouhyouKey(tyouhyouKey);

    }

    private SiCommonSiwakeKekkaBean siBunkatuSiwake() {

        SiCommonSiwakeBean siCommonSiwakeBean = SWAKInjector.getInstance(SiCommonSiwakeBean.class);

        JT_Sk bunkatugoSK = uiBean.getSkBunkatugo();


        List<SiharaigakuBean> siharaigakuBeanLat = Lists.newArrayList();
        SiharaigakuBean siharaigakuBean = SWAKInjector.getInstance(SiharaigakuBean.class);

        for (SiSiDetailParamBean paramBean : uiBean.getSiSiDetailParamBeanLst()) {
            if (!BizUtil.isZero(paramBean.getKyhkg())){

                siharaigakuBean.setKanjyouKmkCd(paramBean.getKanjyoukmkcd());
            }
        }

        BizCurrency shrgk = BizCurrency.optional();
        if (!C_Tuukasyu.JPY.eq(bunkatugoSK.getKyktuukasyu()) &&
            C_Tuukasyu.JPY.eq(bunkatugoSK.getShrtuukasyu())){
            shrgk = bunkatugoSK.getYenhkgkgoukei();
        }
        else {
            shrgk = bunkatugoSK.getHokenkngkgoukei();
        }

        siharaigakuBean.setSiharaiGk(shrgk);
        siharaigakuBean.setKeiyakuGk(bunkatugoSK.getHokenkngkgoukei());

        siharaigakuBeanLat.add(siharaigakuBean);

        BizCurrency shrtienrisok = BizCurrency.optional();
        BizCurrency shrgkkei = BizCurrency.optional();

        if (!C_Tuukasyu.JPY.eq(bunkatugoSK.getKyktuukasyu()) &&
            C_Tuukasyu.JPY.eq(bunkatugoSK.getShrtuukasyu())){
            shrtienrisok = bunkatugoSK.getYenshrtienrsk();
            shrgkkei = bunkatugoSK.getYenshrgk();
        }
        else {
            shrtienrisok = bunkatugoSK.getShrtienrsk();
            shrgkkei = bunkatugoSK.getShrgk();
        }


        List<SiDetailMikeikapBean> siDetailMikeikap = uiBean.getSiDetailMikeikapBeanLst();
        List<SiDetailMisyuupBean> siDetailMisyuup = Lists.newArrayList();

        if (uiBean.getKouteikanryouFlag()) {

            if (uiBean.getSkMax().getMisyuupjyuutouym() != null) {
                List<JT_MisyuupMkkpDetail> misyuupMkkpDetail = uiBean.getSkMax().getMisyuupMkkpDetails();

                for (JT_MisyuupMkkpDetail tempDetail : misyuupMkkpDetail) {
                    SiDetailMisyuupBean  tempDetailMisyuupBean = new  SiDetailMisyuupBean();

                    tempDetailMisyuupBean.setDtlmisyuup(tempDetail.getDtlmisyuup());
                    tempDetailMisyuupBean.setDtlmisyuupgaika(tempDetail.getDtlmisyuupgaika());
                    tempDetailMisyuupBean.setDtlmisyuupgaikayenkingk(tempDetail.getDtlmisyuupgaikayenknsnkngk());
                    tempDetailMisyuupBean.setDtlmisyuuphrkkaisuu(tempDetail.getDtlmisyuuphrkkaisuu());
                    tempDetailMisyuupBean.setDtlmisyuupiktnyuukinnumu(tempDetail.getDtlmisyuupiktnkumu());
                    tempDetailMisyuupBean.setDtlmisyuupjyutoukaisuum(tempDetail.getDtlmisyuupjtkaisuum());
                    tempDetailMisyuupBean.setDtlmisyuupjyutoukaisuuy(tempDetail.getDtlmisyuupjtkaisuuy());
                    tempDetailMisyuupBean.setDtlmisyuupjyuutouym(tempDetail.getDtlmisyuupjytym());

                    siDetailMisyuup.add(tempDetailMisyuupBean);
                }
            }
        } else {
            siDetailMisyuup = uiBean.getSiDetailMisyuupBeanLst();
        }

        if (siDetailMisyuup.size() != 0) {
            Map<String, BizCurrency> dtlMisyuuBunkatuKingakuMap = new LinkedHashMap<String, BizCurrency>();

            dtlMisyuuBunkatuKingakuMap.put(GAIKA_MISYUUP_BUNKATUKEY, uiBean.getSkMax().getMisyuup());

            if (C_Tuukasyu.JPY.eq(bunkatugoSK.getKyktuukasyu())) {
                for (SiDetailMisyuupBean tempMisyuu : siDetailMisyuup) {
                    dtlMisyuuBunkatuKingakuMap.put(tempMisyuu.getDtlmisyuupjyuutouym().toString(), tempMisyuu.getDtlmisyuup());
                }
            } else {
                for (SiDetailMisyuupBean tempMisyuu : siDetailMisyuup) {
                    dtlMisyuuBunkatuKingakuMap.put(tempMisyuu.getDtlmisyuupjyuutouym().toString(), tempMisyuu.getDtlmisyuupgaika());
                }
            }

            Map<Integer, Map<String, BizCurrency>> misyuBunkatuKekka = new TreeMap<Integer, Map<String, BizCurrency>>();

            String hasuutuki = hasuuTyouseiSettei(dtlMisyuuBunkatuKingakuMap);
            misyuBunkatuKekka = calcBunkatuKingaku(uiBean.getSbuktninint(), uiBean.getUktrWariaiBeanMap(),
                dtlMisyuuBunkatuKingakuMap, hasuutuki, GAIKA_MISYUUP_BUNKATUKEY);

            Map<String, BizCurrency> siTaisyoukekka = misyuBunkatuKekka.get(uiBean.getShrtaisyouuktrjuni());

            for (int i = 0; i < siDetailMisyuup.size(); i++) {
                for (Map.Entry<String, BizCurrency> entry : siTaisyoukekka.entrySet()) {

                    if (GAIKA_MISYUUP_BUNKATUKEY.equals(entry.getKey())) {
                        continue;
                    }

                    if (siDetailMisyuup.get(i).getDtlmisyuupjyuutouym().toString().equals(entry.getKey())) {
                        if (C_Tuukasyu.JPY.eq(bunkatugoSK.getKyktuukasyu())) {
                            siDetailMisyuup.get(i).setDtlmisyuup(entry.getValue());
                        } else {
                            siDetailMisyuup.get(i).setDtlmisyuupgaika(entry.getValue());
                        }
                    }
                }

                if (!C_Tuukasyu.JPY.eq(bunkatugoSK.getKyktuukasyu())) {
                    KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

                    BizNumber kawaseRate = uiBean.getShrkwsrate();
                    BizCurrency kanzanGaku = keisanGaikakanzan.exec(C_Tuukasyu.JPY, siDetailMisyuup.get(i).getDtlmisyuupgaika(),
                        kawaseRate, C_HasuusyoriKbn.AGE);
                    siDetailMisyuup.get(i).setDtlmisyuupgaikayenkingk(kanzanGaku);
                }
            }
        }

        if (siDetailMikeikap.size() != 0) {

            Map<String, BizCurrency> dtlMikeikaBunkatuKingakuMap = new LinkedHashMap<String, BizCurrency>();
            if (C_Tuukasyu.JPY.eq(bunkatugoSK.getKyktuukasyu())) {
                dtlMikeikaBunkatuKingakuMap.put(YEN_MIKEIKAP_BUNKATUKEY, uiBean.getSkMax().getMikeikap());
                for (SiDetailMikeikapBean tempMikeika : siDetailMikeikap) {
                    dtlMikeikaBunkatuKingakuMap.put(tempMikeika.getDtlmikeikapjyuutouym().toString(),
                        tempMikeika.getDtlmikeikap());
                }
            } else {
                if (C_SeisankinKanritukaKbn.YENKA.eq(uiBean.getSiSyouhnZokusei().getMikeikapknrtuukakbn())) {
                    dtlMikeikaBunkatuKingakuMap.put(YEN_MIKEIKAP_BUNKATUKEY, uiBean.getSkMax().getYenkamikeikap());
                    for (SiDetailMikeikapBean tempMikeika : siDetailMikeikap) {
                        dtlMikeikaBunkatuKingakuMap.put(tempMikeika.getDtlmikeikapjyuutouym().toString(),
                            tempMikeika.getDtlmikeikap());
                    }
                } else {
                    dtlMikeikaBunkatuKingakuMap.put(YEN_MIKEIKAP_BUNKATUKEY, uiBean.getSkMax().getMikeikap());
                    for (SiDetailMikeikapBean tempMikeika : siDetailMikeikap) {
                        dtlMikeikaBunkatuKingakuMap.put(tempMikeika.getDtlmikeikapjyuutouym().toString(),
                            tempMikeika.getDtlmikeikapgaika());
                    }
                }
            }

            Map<Integer, Map<String, BizCurrency>> mikeikaBunkatuKekka = new TreeMap<Integer, Map<String, BizCurrency>>();

            String hasuutuki = hasuuTyouseiSettei(dtlMikeikaBunkatuKingakuMap);
            mikeikaBunkatuKekka = calcBunkatuKingaku(uiBean.getSbuktninint(), uiBean.getUktrWariaiBeanMap(),
                dtlMikeikaBunkatuKingakuMap, hasuutuki, YEN_MIKEIKAP_BUNKATUKEY);

            Map<String, BizCurrency> siTaisyoukekka = mikeikaBunkatuKekka.get(uiBean.getShrtaisyouuktrjuni());

            for (int i = 0; i < siDetailMikeikap.size(); i++) {
                for (Map.Entry<String, BizCurrency> entry : siTaisyoukekka.entrySet()) {

                    if (YEN_MIKEIKAP_BUNKATUKEY.equals(entry.getKey())) {
                        continue;
                    }

                    if (siDetailMikeikap.get(i).getDtlmikeikapjyuutouym().toString().equals(entry.getKey())) {
                        siDetailMikeikap.get(i).setDtlmikeikap(entry.getValue());
                    }

                }
            }

            if (C_Tuukasyu.JPY.eq(bunkatugoSK.getKyktuukasyu()) ||
                !C_Tuukasyu.JPY.eq(bunkatugoSK.getKyktuukasyu())
                && C_SeisankinKanritukaKbn.YENKA.eq(uiBean.getSiSyouhnZokusei().getMikeikapknrtuukakbn())) {
                for (int i = 0; i < siDetailMikeikap.size(); i++) {
                    for (Map.Entry<String, BizCurrency> entry : siTaisyoukekka.entrySet()) {
                        if (YEN_MIKEIKAP_BUNKATUKEY.equals(entry.getKey())) {
                            continue;
                        }
                        if (siDetailMikeikap.get(i).getDtlmikeikapjyuutouym().toString().equals(entry.getKey())) {
                            siDetailMikeikap.get(i).setDtlmikeikap(entry.getValue());
                        }
                    }
                }
            } else {
                for (int i = 0; i < siDetailMikeikap.size(); i++) {
                    for (Map.Entry<String, BizCurrency> entry : siTaisyoukekka.entrySet()) {
                        if (YEN_MIKEIKAP_BUNKATUKEY.equals(entry.getKey())) {
                            continue;
                        }
                        if (siDetailMikeikap.get(i).getDtlmikeikapjyuutouym().toString().equals(entry.getKey())) {
                            siDetailMikeikap.get(i).setDtlmikeikapgaika(entry.getValue());
                        }
                    }
                }
            }

        }


        siCommonSiwakeBean.setSyoNo(uiBean.getSyono());
        siCommonSiwakeBean.setDenYmd(uiBean.getShrymd());
        siCommonSiwakeBean.setTuukasyu(bunkatugoSK.getShrtuukasyu());
        siCommonSiwakeBean.setKeiyakuTuukasyu(bunkatugoSK.getKyktuukasyu());
        siCommonSiwakeBean.setInputShrhousiteiKbn(C_InputShrhousiteiKbn.FBSOUKIN);
        siCommonSiwakeBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        siCommonSiwakeBean.setSyoriYmd(BizDate.getSysDate());
        siCommonSiwakeBean.setSyoriCd(kinou.getSyoricd());
        siCommonSiwakeBean.setSyoriSosikiCd(baseUserInfo.getTmSosikiCd());
        siCommonSiwakeBean.setKakoKawaserateShiteiFlg(true);
        siCommonSiwakeBean.setKakoKawaserateShiteiYmd(uiBean.getSyoruiukeymd());
        siCommonSiwakeBean.setSyouhnCd(uiBean.getSiKykSyouhn().getSyouhncd());
        siCommonSiwakeBean.setSyouhnsdNo(uiBean.getSiKykSyouhn().getSyouhnsdno());
        siCommonSiwakeBean.setNkRendouUmu(C_UmuKbn.NONE);
        siCommonSiwakeBean.setSiharaigakuBeanList(siharaigakuBeanLat);
        siCommonSiwakeBean.setHaitoukin(bunkatugoSK.getHaitoukin());
        siCommonSiwakeBean.setYenkaHaitoukin(bunkatugoSK.getYenkahaitoukin());
        siCommonSiwakeBean.setSonotaHaitoukin(bunkatugoSK.getSonotahaitoukin());
        siCommonSiwakeBean.setYenkaSonotaHaitoukin(bunkatugoSK.getYenkasonotahaitoukin());
        siCommonSiwakeBean.setMisyuup(bunkatugoSK.getMisyuup());
        siCommonSiwakeBean.setYenkaMisyuup(bunkatugoSK.getYenkamisyuup());
        siCommonSiwakeBean.setSiDetailMisyuupBeanLst(siDetailMisyuup);
        siCommonSiwakeBean.setMikeikapJyuutouym(uiBean.getSiHkkingakuSisanParamBean().getMikeikapjyuutouym());
        siCommonSiwakeBean.setMikeikap(bunkatugoSK.getMikeikap());
        siCommonSiwakeBean.setYenkaMikeikap(bunkatugoSK.getYenkamikeikap());
        siCommonSiwakeBean.setSiDetailMikeikapBeanLst(siDetailMikeikap);
        siCommonSiwakeBean.setZennouryosyuymd(uiBean.getSiKykKihon().getZennouryosyuymd());
        siCommonSiwakeBean.setZennouseisank(bunkatugoSK.getZennouseisankgk());
        siCommonSiwakeBean.setYenkaZennouseisank(bunkatugoSK.getYenkazennouseisankgk());
        siCommonSiwakeBean.setAzukarikingk(bunkatugoSK.getAzukarikingk());
        siCommonSiwakeBean.setYenkaAzukarikingk(bunkatugoSK.getYenkaazukarikingk());
        siCommonSiwakeBean.setZitkAzukarikingkSiteituuka(bunkatugoSK.getZitkazukarikingksiteituuka());
        siCommonSiwakeBean.setZitkAzukarikingkYen(bunkatugoSK.getZitkazukarikingkyen());
        siCommonSiwakeBean.setKrkgk(bunkatugoSK.getKrkgk());
        siCommonSiwakeBean.setYenkaKrkgk(bunkatugoSK.getYenkakrkgk());
        siCommonSiwakeBean.setShrtienRsk(shrtienrisok);
        siCommonSiwakeBean.setKeiyakuShrtienRsk(null);
        siCommonSiwakeBean.setShrgkkei(shrgkkei);
        siCommonSiwakeBean.setItijibrumu(uiBean.getSyouhnZokusei().getItijibrumu());
        siCommonSiwakeBean.setKawaserate(bunkatugoSK.getShrkwsrate());
        siCommonSiwakeBean.setGaikaknsnKwsrate(bunkatugoSK.getGaikaknsnkwsrate());
        siCommonSiwakeBean.setKykymd(uiBean.getSiKykSyouhn().getKykymd());

        if (uiBean.getKouteikanryouFlag()) {
            if (uiBean.getSkMax().getMisyuupjyuutouym() != null) {
                siCommonSiwakeBean.setNexthrkym(uiBean.getSkMax().getMisyuupjyuutouym());

            } else {
                siCommonSiwakeBean.setNexthrkym(uiBean.getSiKykKihon().getNexthrkym());
            }
        } else {
            siCommonSiwakeBean.setNexthrkym(uiBean.getSiKykKihon().getNexthrkym());
        }
        siCommonSiwakeBean.setHrkkaisuu(uiBean.getSiKykKihon().getHrkkaisuu());
        siCommonSiwakeBean.setTikiktbrisyuruikbn(uiBean.getSiKykKihon().getTikiktbrisyuruikbn());
        SiCommonSiwake siCommonSiwake = SWAKInjector.getInstance(SiCommonSiwake.class);

        SiCommonSiwakeKekkaBean siCommonSiwakeKekkaBean = siCommonSiwake.exec(siCommonSiwakeBean);

        return siCommonSiwakeKekkaBean;
    }

    private CalcSiTyousyoBean siTyousyoSettei() {

        Map<Integer, Map<String, BizCurrency>> hituyoukeihiBunkatu = new TreeMap<Integer, Map<String, BizCurrency>>();
        Map<String, BizCurrency> hituyoukeihiBunkatuMap = new LinkedHashMap<String, BizCurrency>();

        hituyoukeihiBunkatuMap.put(HITUYOKEIHI_BUNKATUKEY, uiBean.getSkMax().getGoukeihituyoukeihi());

        hituyoukeihiBunkatu = calcBunkatuKingaku(uiBean.getSbuktninint(), uiBean.getUktrWariaiBeanMap(),
            hituyoukeihiBunkatuMap, null, null);

        uiBean.getSkBunkatugo().setGoukeihituyoukeihi(hituyoukeihiBunkatu
            .get(uiBean.getShrtaisyouuktrjuni()).get(HITUYOKEIHI_BUNKATUKEY));

        CalcSiTyousyo calcSiTyousyo = SWAKInjector.getInstance(CalcSiTyousyo.class);

        C_ErrorKbn kekka = calcSiTyousyo.exec(uiBean.getSkBunkatugo(), uiBean.getSiKykSyouhn().getSyouhncd());

        if (C_ErrorKbn.ERROR.eq(kekka)) {
            throw new BizLogicException(MessageId.EJA1027);
        }

        return calcSiTyousyo.getCalcSiTyousyoBean();

    }

    private void bunkatu() {

        List<UktrInfoDataSourceBean> uktrInfoList = uiBean.getUktrInfoDataSource().getDatas();

        if (C_BunkatuHouhouKbn.KINTOUWARI.eq(uiBean.getBunkatuhouhoukbn())) {
            for (int i = 0; i < uiBean.getSbuktninint(); i++) {
                uktrInfoList.get(i).setUktrwraibunsi(1);
                uktrInfoList.get(i).setUktrwraibunbo(uiBean.getSbuktninint());
            }
        }

        for (int i = 0; i < uiBean.getSbuktninint(); i++) {
            if (uktrInfoList.get(i).getShrtaisyou()) {
                uiBean.setShrtaisyouuktrjuni(i+1);
                uiBean.setSitaisyouuketorinmkj(uktrInfoList.get(i).getBnktsbuktnmkj());
            }
        }

        setteiUktrInfo(uktrInfoList);

        Map<Integer,UktrWariaiBean> uktrWariaiBeanMap = new TreeMap<Integer,UktrWariaiBean>();
        for (int i = 0; i < uiBean.getSbuktninint(); i++) {
            uktrWariaiBeanMap.put(uktrInfoList.get(i).getUktrjuni(),
                new UktrWariaiBean(uktrInfoList.get(i).getUktrwraibunsi(), uktrInfoList.get(i).getUktrwraibunbo()));
        }

        uiBean.setUktrWariaiBeanMap(uktrWariaiBeanMap);

        Map<String, BizCurrency> gaiakBunkatuKingakuMap = new LinkedHashMap<String, BizCurrency>();
        Map<String, BizCurrency> yenBunkatuKingakuMap = new LinkedHashMap<String, BizCurrency>();

        bunkatuMaeSettei(gaiakBunkatuKingakuMap, yenBunkatuKingakuMap);



        Map<Integer, Map<String, BizCurrency>> gaikaBunkatuKekka = new TreeMap<Integer, Map<String, BizCurrency>>();
        Map<Integer, Map<String, BizCurrency>> yenBunkatuKekka = new TreeMap<Integer, Map<String, BizCurrency>>();

        uiBean.setHasuuChk(true);

        if (C_Tuukasyu.JPY.eq(uiBean.getSiKykSyouhn().getKyktuukasyu())) {

            String yenHasuuhimoku = hasuuTyouseiSettei(yenBunkatuKingakuMap);
            yenBunkatuKekka = calcBunkatuKingaku(uiBean.getSbuktninint(),
                uktrWariaiBeanMap, yenBunkatuKingakuMap, yenHasuuhimoku, YEN_GOUKEI_BUNKATUKEY);

            hasuuChk(yenBunkatuKekka, yenHasuuhimoku);

        } else {

            String yenHasuuhimoku = hasuuTyouseiSettei(yenBunkatuKingakuMap);
            yenBunkatuKekka = calcBunkatuKingaku(uiBean.getSbuktninint(), uktrWariaiBeanMap,
                yenBunkatuKingakuMap, yenHasuuhimoku, YEN_GOUKEI_BUNKATUKEY);

            hasuuChk(yenBunkatuKekka, yenHasuuhimoku);

            String gaikaHasuuhimoku = hasuuTyouseiSettei(gaiakBunkatuKingakuMap);
            gaikaBunkatuKekka = calcBunkatuKingaku(uiBean.getSbuktninint(), uktrWariaiBeanMap,
                gaiakBunkatuKingakuMap, gaikaHasuuhimoku, GAIKA_GOUKEI_BUNKATUKEY);

            hasuuChk(gaikaBunkatuKekka, gaikaHasuuhimoku);
        }

        setBunkatukingaku(gaikaBunkatuKekka, yenBunkatuKekka);

        uiBean.setGaikaBunkatuKekka(gaikaBunkatuKekka);
        uiBean.setYenkaBunkatuKekka(yenBunkatuKekka);
    }


    private void hasuuChk(Map<Integer, Map<String, BizCurrency>> pBunkatuKekka, String pHasuuhimoku) {

        for (Map.Entry<Integer, Map<String, BizCurrency>> entry : pBunkatuKekka.entrySet()) {

            BizCurrency kingaku = entry.getValue().get(pHasuuhimoku);

            if (YEN_MISYUUP_BUNKATUKEY.equals(pHasuuhimoku) || GAIKA_MISYUUP_BUNKATUKEY.equals(pHasuuhimoku)) {

                if (kingaku.compareTo(BizCurrency.valueOf(0, kingaku.getType())) > 0) {
                    uiBean.setHasuuChk(false);
                    return;
                }

            } else {
                if (kingaku.compareTo(BizCurrency.valueOf(0, kingaku.getType())) < 0) {
                    uiBean.setHasuuChk(false);
                    return;
                }
            }
        }
    }

    private void calcShrgk() {


        JT_Sk skBunkatugo = uiBean.getSkBunkatugo();
        C_Tuukasyu keiyakuTuukasyu = uiBean.getSkMax().getKyktuukasyu();

        KeisanTienrisoku keisanTienrisoku = SWAKInjector.getInstance(KeisanTienrisoku.class);

        if (C_Tuukasyu.JPY.eq(keiyakuTuukasyu)) {

            BizCurrency yendateHokengk = skBunkatugo.getShrgk();

            BizCurrency yendateRisoku = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

            KeisanTienrisokuBean endateKeisanTienrisokuBean = SWAKInjector.getInstance(KeisanTienrisokuBean.class);

            endateKeisanTienrisokuBean = keisanTienrisoku.exec(
                uiBean.getSyoruiukeymd(), null,
                uiBean.getShrymd(), yendateHokengk, 0, C_SinsaGendoKknKbn.BD5);

            yendateRisoku = endateKeisanTienrisokuBean.getShrtienrsk();

            skBunkatugo.setShrgk(yendateHokengk.add(yendateRisoku));
            skBunkatugo.setTienrisokukisanymd(endateKeisanTienrisokuBean.getShrtienrskStartYmd());
            skBunkatugo.setTienrsknissuu(endateKeisanTienrisokuBean.getShrtienNissuu());
            skBunkatugo.setShrtienrsk(yendateRisoku);

            uiBean.setBnktgoyengoukei(yendateHokengk.add(yendateRisoku));
            uiBean.setBnktgoyenkaknsntkgk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            uiBean.setBnktgoyenhknkngkguki(skBunkatugo.getHokenkngkgoukei());
            uiBean.setBnktgoyenhaitoukin(skBunkatugo.getHaitoukin());
            uiBean.setBnktgoyensonotahaitoukin(skBunkatugo.getSonotahaitoukin());
            uiBean.setBnktgoyenmisyuup(skBunkatugo.getMisyuup().multiply(-1));
            uiBean.setBnktgoyenmikeikap(skBunkatugo.getMikeikap());
            uiBean.setBnktgoyenznnusisnkgk(skBunkatugo.getZennouseisankgk());
            uiBean.setBnktgozitkazkrknyen(skBunkatugo.getZitkazukarikingksiteituuka());
            uiBean.setBnktgoyenkrkgk(skBunkatugo.getKrkgk());

            if (Integer.valueOf(0).equals(endateKeisanTienrisokuBean.getShrtienNissuu())) {
                uiBean.setYentienrsknissuu(null);
            } else {
                uiBean.setYentienrsknissuu(endateKeisanTienrisokuBean.getShrtienNissuu());
            }
            uiBean.setYentienrisokukisanymd(endateKeisanTienrisokuBean.getShrtienrskStartYmd());
            uiBean.setYenshrtienrsk(yendateRisoku);

        } else {

            HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
            CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(keiyakuTuukasyu);

            KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

            BizNumber kawaseRate = uiBean.getShrkwsrate();
            BizNumber gaikaknsnKwsrate = uiBean.getGaikaknsnkwsrate();

            BizCurrency gaikaKnsnTKgk = skBunkatugo.getGaikaknsntkgk();
            BizCurrency gaikaKnsnKekkaKgk = BizCurrency.valueOf(0, currencyType);
            BizCurrency yenkaKnsnTKgk = skBunkatugo.getYenkaknsntkgk();
            BizCurrency yenkaKnsnKekkaKgk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

            BizCurrency gaikaHokengk = BizCurrency.valueOf(0, currencyType);
            BizCurrency yenkaHokengk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

            BizCurrency gaikaSigk = BizCurrency.valueOf(0, currencyType);
            BizCurrency yenkaSigk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

            BizCurrency gaikaRisoku = BizCurrency.valueOf(0, currencyType);
            BizCurrency yenkaRisoku = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

            if (gaikaKnsnTKgk.compareTo(BizCurrency.valueOf(0, BizCurrencyTypes.YEN)) > 0) {
                keisanGaikakanzan.execDivide(keiyakuTuukasyu, gaikaKnsnTKgk, gaikaknsnKwsrate, C_HasuusyoriKbn.AGE);
                gaikaKnsnKekkaKgk = keisanGaikakanzan.getKanzanGaku();
            }

            uiBean.setSykSbYenSitiHsyuTkTekiUmu(C_UmuKbn.NONE);

            if (C_UmuKbn.ARI.eq(uiBean.getSiHkkingakuSisanParamBean().getSykSbYenSitiHsyuTkTekiUmu())) {
                if (C_Tuukasyu.JPY.eq(skBunkatugo.getShrtuukasyu())) {

                    Map<String, BizCurrency> sykSbYenBunkatuKingakuMap = new LinkedHashMap<String, BizCurrency>();
                    sykSbYenBunkatuKingakuMap.put(SYKSBYEN_BUNKATUKEY, uiBean.getSiKykKihon().getInitsbjiyenkasaiteihsygk());

                    Map<Integer, Map<String, BizCurrency>> sykSbYenBunkatuKekka = new TreeMap<Integer,
                        Map<String, BizCurrency>>();

                    sykSbYenBunkatuKekka = calcBunkatuKingaku(uiBean.getSbuktninint(),
                        uiBean.getUktrWariaiBeanMap(), sykSbYenBunkatuKingakuMap, null, null);

                    yenkaKnsnKekkaKgk = sykSbYenBunkatuKekka.get(uiBean.getShrtaisyouuktrjuni()).get(SYKSBYEN_BUNKATUKEY);
                    skBunkatugo.setYenhkgkgoukei(yenkaKnsnKekkaKgk);

                    uiBean.setSykSbYenSitiHsyuTkTekiUmu(C_UmuKbn.ARI);
                } else {
                    if (yenkaKnsnTKgk.compareTo(BizCurrency.valueOf(0, currencyType)) > 0) {
                        keisanGaikakanzan.exec(C_Tuukasyu.JPY, yenkaKnsnTKgk, kawaseRate, C_HasuusyoriKbn.AGE);
                        yenkaKnsnKekkaKgk = keisanGaikakanzan.getKanzanGaku();
                    }
                }
            } else {
                if (yenkaKnsnTKgk.compareTo(BizCurrency.valueOf(0, currencyType)) > 0) {
                    keisanGaikakanzan.exec(C_Tuukasyu.JPY, yenkaKnsnTKgk, kawaseRate, C_HasuusyoriKbn.AGE);
                    yenkaKnsnKekkaKgk = keisanGaikakanzan.getKanzanGaku();
                }
            }

            gaikaHokengk = gaikaKnsnKekkaKgk.add(skBunkatugo.getHokenkngkgoukei())
                .add(skBunkatugo.getZitkazukarikingksiteituuka()).subtract(skBunkatugo.getMisyuup());

            if (C_SeisankinKanritukaKbn.SITEITUUKA.eq(uiBean.getSiSyouhnZokusei().getZnnusisnkinknrtuukakbn())) {
                gaikaHokengk = gaikaHokengk.add(skBunkatugo.getZennouseisankgk());
            }

            if (C_SeisankinKanritukaKbn.SITEITUUKA.eq(uiBean.getSiSyouhnZokusei().getMikeikapknrtuukakbn())) {
                gaikaHokengk = gaikaHokengk.add(skBunkatugo.getMikeikap());
            }

            yenkaHokengk = yenkaKnsnKekkaKgk.add(skBunkatugo.getZitkazukarikingkyen()).add(skBunkatugo.getYenkakrkgk())
                .add(skBunkatugo.getYenkahaitoukin()).add(skBunkatugo.getYenkasonotahaitoukin());

            if (C_SeisankinKanritukaKbn.YENKA.eq(uiBean.getSiSyouhnZokusei().getZnnusisnkinknrtuukakbn())) {
                yenkaHokengk = yenkaHokengk.add(skBunkatugo.getYenkazennouseisankgk());
            }

            if (C_SeisankinKanritukaKbn.YENKA.eq(uiBean.getSiSyouhnZokusei().getMikeikapknrtuukakbn())) {
                yenkaHokengk = yenkaHokengk.add(skBunkatugo.getYenkamikeikap());
            }

            KeisanTienrisokuBean gaikaSiKeisanTienrisokuBean = SWAKInjector.getInstance(KeisanTienrisokuBean.class);

            gaikaSiKeisanTienrisokuBean = keisanTienrisoku.exec(
                uiBean.getSyoruiukeymd(), null,
                uiBean.getShrymd(), gaikaHokengk, 0, C_SinsaGendoKknKbn.BD5);

            gaikaRisoku = gaikaSiKeisanTienrisokuBean.getShrtienrsk();

            KeisanTienrisokuBean yenSiKeisanTienrisokuBean = SWAKInjector.getInstance(KeisanTienrisokuBean.class);

            yenSiKeisanTienrisokuBean = keisanTienrisoku.exec(
                uiBean.getSyoruiukeymd(), null,
                uiBean.getShrymd(), yenkaHokengk, 0, C_SinsaGendoKknKbn.BD5);

            yenkaRisoku = yenSiKeisanTienrisokuBean.getShrtienrsk();

            gaikaSigk = gaikaHokengk.add(gaikaRisoku);
            yenkaSigk = yenkaHokengk.add(yenkaRisoku);

            skBunkatugo.setShrgk(gaikaSigk);
            skBunkatugo.setYenshrgk(yenkaSigk);
            skBunkatugo.setTienrisokukisanymd(yenSiKeisanTienrisokuBean.getShrtienrskStartYmd());
            skBunkatugo.setTienrsknissuu(yenSiKeisanTienrisokuBean.getShrtienNissuu());
            skBunkatugo.setShrtienrsk(gaikaRisoku);
            skBunkatugo.setYenshrtienrsk(yenkaRisoku);

            skBunkatugo.setGaikaknsnkekkakgk(gaikaKnsnKekkaKgk);
            skBunkatugo.setYenkaknsnkekkakgk(yenkaKnsnKekkaKgk);

            skBunkatugo.setShrkwsrate(kawaseRate);
            skBunkatugo.setShrkwsratekjnymd(uiBean.getShrkwsratekjnymd());
            skBunkatugo.setGaikaknsnkwsrate(gaikaknsnKwsrate);
            skBunkatugo.setGaikaknsnkwsratekjymd(uiBean.getGaikaknsnkwsratekjymd());
            skBunkatugo.setZeimukwsrate(uiBean.getZeimukwsrate());
            skBunkatugo.setZeimukwsratekjnymd(uiBean.getZeimukwsratekjnymd());

            uiBean.setBnktgoyengoukei(yenkaSigk);
            uiBean.setBnktgoyenkaknsntkgk(yenkaKnsnKekkaKgk);
            uiBean.setBnktgoyenhknkngkguki(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            uiBean.setBnktgoyenkrkgk(skBunkatugo.getYenkakrkgk());
            uiBean.setBnktgoyenhaitoukin(skBunkatugo.getYenkahaitoukin());
            uiBean.setBnktgoyensonotahaitoukin(skBunkatugo.getYenkasonotahaitoukin());
            if (C_Tuukasyu.JPY.eq(keiyakuTuukasyu)) {
                uiBean.setBnktgoyenmikeikap(skBunkatugo.getMikeikap());
            } else {
                if (C_SeisankinKanritukaKbn.YENKA.eq(uiBean.getSiSyouhnZokusei().getMikeikapknrtuukakbn())) {
                    uiBean.setBnktgoyenmikeikap(skBunkatugo.getYenkamikeikap());
                } else {
                    uiBean.setBnktgoyenmikeikap(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                }
            }

            if (C_Tuukasyu.JPY.eq(keiyakuTuukasyu)) {
                uiBean.setBnktgoyenmisyuup(skBunkatugo.getMisyuup());
            } else {
                if (C_SeisankinKanritukaKbn.YENKA.eq(uiBean.getSiSyouhnZokusei().getMsyupknrtuukakbn())) {
                    uiBean.setBnktgoyenmisyuup(skBunkatugo.getYenkamisyuup());
                } else {
                    uiBean.setBnktgoyenmisyuup(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                }
            }

            if (C_Tuukasyu.JPY.eq(keiyakuTuukasyu)) {
                uiBean.setBnktgoyenznnusisnkgk(skBunkatugo.getZennouseisankgk());
            } else {
                if (C_SeisankinKanritukaKbn.YENKA.eq(uiBean.getSiSyouhnZokusei().getZnnusisnkinknrtuukakbn())) {
                    uiBean.setBnktgoyenznnusisnkgk(skBunkatugo.getYenkazennouseisankgk());
                } else {
                    uiBean.setBnktgoyenznnusisnkgk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                }
            }
            uiBean.setBnktgozitkazkrknyen(skBunkatugo.getZitkazukarikingkyen());
            if (Integer.valueOf(0).equals(gaikaSiKeisanTienrisokuBean.getShrtienNissuu())) {
                uiBean.setYentienrsknissuu(null);
            } else {
                uiBean.setYentienrsknissuu(yenSiKeisanTienrisokuBean.getShrtienNissuu());
            }
            uiBean.setYentienrisokukisanymd(yenSiKeisanTienrisokuBean.getShrtienrskStartYmd());
            uiBean.setYenshrtienrsk(yenkaRisoku);

            uiBean.setBnktgogaikagoukei(gaikaSigk);
            uiBean.setBnktgogaikaknsntkgk(gaikaKnsnKekkaKgk);
            uiBean.setBnktgohokenkngkgoukei(skBunkatugo.getHokenkngkgoukei());
            uiBean.setBnktgozitkazkrknstituka(skBunkatugo.getZitkazukarikingksiteituuka());
            uiBean.setBnktgomisyuup(skBunkatugo.getMisyuup().multiply(-1));
            if (!C_Tuukasyu.JPY.eq(keiyakuTuukasyu)) {
                if (C_SeisankinKanritukaKbn.YENKA.eq(uiBean.getSiSyouhnZokusei().getMikeikapknrtuukakbn())) {
                    uiBean.setBnktgomikeikap(BizCurrency.valueOf(0, currencyType));
                } else {
                    uiBean.setBnktgomikeikap(skBunkatugo.getMikeikap());
                }
            }
            if (!C_Tuukasyu.JPY.eq(keiyakuTuukasyu)) {
                if (C_SeisankinKanritukaKbn.YENKA.eq(uiBean.getSiSyouhnZokusei().getZnnusisnkinknrtuukakbn())) {
                    uiBean.setBnktgoznnusisnkgk(BizCurrency.valueOf(0, currencyType));
                } else {
                    uiBean.setBnktgoznnusisnkgk(skBunkatugo.getZennouseisankgk());
                }
            }
            if (Integer.valueOf(0).equals(gaikaSiKeisanTienrisokuBean.getShrtienNissuu())) {
                uiBean.setTienrsknissuu(null);
            } else {
                uiBean.setTienrsknissuu(gaikaSiKeisanTienrisokuBean.getShrtienNissuu());
            }
            uiBean.setTienrisokukisanymd(gaikaSiKeisanTienrisokuBean.getShrtienrskStartYmd());
            uiBean.setShrtienrsk(gaikaRisoku);

        }
    }

    private void execSiKingakukeisan() {


        SiSiharaiKingakuKeisanBean siSiharaiKingakuKeisanBean = SWAKInjector.getInstance(SiSiharaiKingakuKeisanBean.class);

        siSiharaiKingakuKeisanBean.setSyoNo(uiBean.getSyono());
        siSiharaiKingakuKeisanBean.setSeikyuuSyubetu(uiBean.getSkKihon().getSeikyuusyubetu());
        siSiharaiKingakuKeisanBean.setCalcKijyunYmd(uiBean.getSibouymd());
        siSiharaiKingakuKeisanBean.setInputShrhouSiteiKbn(C_InputShrhousiteiKbn.FBSOUKIN);
        siSiharaiKingakuKeisanBean.setSyoruiUkeYmd(uiBean.getSyoruiukeymd());
        siSiharaiKingakuKeisanBean.setHubiKanryouYmd(null);
        siSiharaiKingakuKeisanBean.setRikoukiTyuutuudanNissuu(0);
        siSiharaiKingakuKeisanBean.setSinsaGendoKknKbn(C_SinsaGendoKknKbn.BD5);
        siSiharaiKingakuKeisanBean.setSUketoriHouhouKbn(C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN);
        siSiharaiKingakuKeisanBean.setSiharaiTuukaKbn(uiBean.getSiharaituukakbn());
        siSiharaiKingakuKeisanBean.setSiKykKihon(uiBean.getSiKykKihon());
        siSiharaiKingakuKeisanBean.setSiHonninKakninKbn(C_SiHonninKakninKekkaKbn.KOUZA);
        siSiharaiKingakuKeisanBean.setKeisanKahiKbn(C_KahiKbn.KA);
        siSiharaiKingakuKeisanBean.setYobidasimotoKinouId(kinou.getKinouId());
        siSiharaiKingakuKeisanBean.setSikinouModeIdKbn(C_SikinouModeIdKbn.valueOf(kinouMode.getKinouMode()));
        siSiharaiKingakuKeisanBean.setSiinKbn(uiBean.getSkMax().getSiinkbn());
        siSiharaiKingakuKeisanBean.setSaisateiKbn(C_SaisateiKbn.BLNK);
        siSiharaiKingakuKeisanBean.setBankCd("");
        siSiharaiKingakuKeisanBean.setSeikyuusyaKbn(C_SeikyuusyaKbn.UKTDAIHYOU);

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType type = henkanTuuka.henkanTuukaKbnToType(uiBean.getSiKykKihon().getSiKykSyouhns().get(0)
            .getKyktuukasyu());
        BizCurrency nkKknJyutouGk = BizCurrency.valueOf(0, type);
        siSiharaiKingakuKeisanBean.setNkKknJyutouGk(nkKknJyutouGk);

        SiSiharaiKingakuKeisan siSiharaiKingakuKeisan = SWAKInjector.getInstance(SiSiharaiKingakuKeisan.class);

        C_ErrorKbn errorKbn = siSiharaiKingakuKeisan.exec(siSiharaiKingakuKeisanBean);

        if (errorKbn.eq(C_ErrorKbn.ERROR)) {
            if (siSiharaiKingakuKeisan.getErrMsg().exists()) {
                throw new BizLogicException(siSiharaiKingakuKeisan.getErrMsg());
            }
        }

        uiBean.setSiSiDetailParamBeanLst(siSiharaiKingakuKeisan.getSiSiDetailParamBean());
        uiBean.setSiHkkingakuSisanParamBean(siSiharaiKingakuKeisan.getSiHkkingakuSisanParamBean());
        uiBean.setSiDetailMisyuupBeanLst(siSiharaiKingakuKeisan.getSiDetailMisyuupBeans());
        uiBean.setSiDetailMikeikapBeanLst(siSiharaiKingakuKeisan.getDetailMikeikapBeans());


        uiBean.setShrkwsratekjnymd(siSiharaiKingakuKeisan.getSiHkkingakuSisanParamBean().getKnsnKijyunYmd());
        uiBean.setGaikaknsnkwsratekjymd(siSiharaiKingakuKeisan.getSiHkkingakuSisanParamBean().getKnsnKijyunYmd());
        uiBean.setZeimukwsratekjnymd(siSiharaiKingakuKeisan.getSiHkkingakuSisanParamBean().getZeimukwsratekjnymd());

        uiBean.setShrkwsrate(siSiharaiKingakuKeisan.getSiHkkingakuSisanParamBean().getKawaseRate());
        uiBean.setGaikaknsnkwsrate(siSiharaiKingakuKeisan.getSiHkkingakuSisanParamBean().getGaikaknsnkwsrate());
        uiBean.setZeimukwsrate(siSiharaiKingakuKeisan.getSiHkkingakuSisanParamBean().getZeimukwsrate());

    }

    private void setBunkatukingaku(Map<Integer, Map<String, BizCurrency>> gaikaBunkatuKekka,
        Map<Integer, Map<String, BizCurrency>> yenBunkatuKekka) {

        JT_Sk skBunkatugo = new JT_Sk();
        C_Tuukasyu keiyakuTuukasyu = uiBean.getSkMax().getKyktuukasyu();

        skBunkatugo.setKyktuukasyu(keiyakuTuukasyu);
        skBunkatugo.setSiharaituukakbn(uiBean.getSiharaituukakbn());

        if (C_SiharaiTuukaKbn.YENSIHARAI.eq(uiBean.getSiharaituukakbn())) {
            skBunkatugo.setShrtuukasyu(C_Tuukasyu.JPY);
        } else {
            skBunkatugo.setShrtuukasyu(keiyakuTuukasyu);
        }

        skBunkatugo.setShrkwsratekjnymd(uiBean.getShrkwsratekjnymd());
        skBunkatugo.setGaikaknsnkwsratekjymd(uiBean.getGaikaknsnkwsratekjymd());
        skBunkatugo.setZeimukwsratekjnymd(uiBean.getZeimukwsratekjnymd());
        skBunkatugo.setShrkwsrate(uiBean.getShrkwsrate());
        skBunkatugo.setGaikaknsnkwsrate(uiBean.getGaikaknsnkwsrate());
        skBunkatugo.setZeimukwsrate(uiBean.getZeimukwsrate());

        skBunkatugo.setMikeikapjyuutoukaisuuy(uiBean.getSkMax().getMikeikapjyuutoukaisuuy());
        skBunkatugo.setMikeikapjyuutoukaisuum(uiBean.getSkMax().getMikeikapjyuutoukaisuum());
        skBunkatugo.setMikeikapjyuutouym(uiBean.getSkMax().getMikeikapjyuutouym());
        skBunkatugo.setMisyuupjyuutoukaisuuy(uiBean.getSkMax().getMisyuupjyuutoukaisuuy());
        skBunkatugo.setMisyuupjyuutoukaisuum(uiBean.getSkMax().getMisyuupjyuutoukaisuum());
        skBunkatugo.setMisyuupjyuutouym(uiBean.getSkMax().getMisyuupjyuutouym());
        skBunkatugo.setSinsagendokknkbn(C_SinsaGendoKknKbn.BD5);
        skBunkatugo.setKykhnkkaisuu(uiBean.getSkMax().getKykhnkkaisuu());

        Map<String, BizCurrency> yenBunkatugk = yenBunkatuKekka.get(uiBean.getShrtaisyouuktrjuni());
        Map<String, BizCurrency> gaikaBunkatugk = gaikaBunkatuKekka.get(uiBean.getShrtaisyouuktrjuni());

        if (C_Tuukasyu.JPY.eq(keiyakuTuukasyu)) {

            skBunkatugo.setShrgk(yenBunkatugk.get(YEN_GOUKEI_BUNKATUKEY));
            skBunkatugo.setHokenkngkgoukei(yenBunkatugk.get(YEN_S_BUNKATUKEY));
            skBunkatugo.setHaitoukin(yenBunkatugk.get(YEN_HAITOU_BUNKATUKEY));
            skBunkatugo.setSonotahaitoukin(yenBunkatugk.get(YEN_SONOTAHAITOU_BUNKATUKEY));
            skBunkatugo.setMikeikap(yenBunkatugk.get(YEN_MIKEIKAP_BUNKATUKEY));
            skBunkatugo.setMisyuup(yenBunkatugk.get(YEN_MISYUUP_BUNKATUKEY).multiply(-1));
            skBunkatugo.setZennouseisankgk(yenBunkatugk.get(YEN_ZENNOU_BUNKATUKEY));
            skBunkatugo.setZitkazukarikingksiteituuka(yenBunkatugk.get(YEN_ZEITEKI_BUNKATUKEY));
            skBunkatugo.setAzukarikingk(yenBunkatugk.get(YEN_ZEITEKI_BUNKATUKEY));
            skBunkatugo.setKrkgk(yenBunkatugk.get(YEN_KARIUKE_BUNKATUKEY));

        } else {
            skBunkatugo.setYenkaknsntkgk(gaikaBunkatugk.get(GAIKA_GOUKEI_BUNKATUKEY));
            skBunkatugo.setHokenkngkgoukei(gaikaBunkatugk.get(GAIKA_S_BUNKATUKEY));
            skBunkatugo.setZitkazukarikingksiteituuka(gaikaBunkatugk.get(SITEI_ZEITEKI_BUNKATUKEY));
            skBunkatugo.setMisyuup(gaikaBunkatugk.get(GAIKA_MISYUUP_BUNKATUKEY).multiply(-1));

            skBunkatugo.setGaikaknsntkgk(yenBunkatugk.get(YEN_GOUKEI_BUNKATUKEY));
            skBunkatugo.setYenkahaitoukin(yenBunkatugk.get(YEN_HAITOU_BUNKATUKEY));
            skBunkatugo.setYenkasonotahaitoukin(yenBunkatugk.get(YEN_SONOTAHAITOU_BUNKATUKEY));

            skBunkatugo.setZitkazukarikingkyen(yenBunkatugk.get(YEN_ZEITEKI_BUNKATUKEY));
            skBunkatugo.setYenkakrkgk(yenBunkatugk.get(YEN_KARIUKE_BUNKATUKEY));


            HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
            CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(keiyakuTuukasyu);

            KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

            BizNumber kawaseRate = uiBean.getShrkwsrate();
            BizNumber gaikaknsnKwsrate = uiBean.getGaikaknsnkwsrate();

            BizCurrency hokenKngkYenGoukei = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
            BizCurrency yenkaMisyuuP = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

            BizCurrency haitoukin = BizCurrency.valueOf(0, currencyType);
            BizCurrency sonotahaitoukin = BizCurrency.valueOf(0, currencyType);
            BizCurrency zennouSeisanKgk = BizCurrency.valueOf(0, currencyType);
            BizCurrency yenkaZennouSeisanKgk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
            BizCurrency mikeikaP = BizCurrency.valueOf(0, currencyType);
            BizCurrency yenkaMikeikaP = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
            BizCurrency krkgk = BizCurrency.valueOf(0, currencyType);

            BizCurrency yenkaAzukariKingk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
            BizCurrency azukariKingk = BizCurrency.valueOf(0, currencyType);

            BizCurrency zitkAzukariKingkSiteituuka = skBunkatugo.getZitkazukarikingksiteituuka();
            BizCurrency zitkAzukariKingkYen = skBunkatugo.getZitkazukarikingkyen();

            keisanGaikakanzan.exec(C_Tuukasyu.JPY, skBunkatugo.getHokenkngkgoukei(), kawaseRate, C_HasuusyoriKbn.AGE);
            hokenKngkYenGoukei = keisanGaikakanzan.getKanzanGaku();
            skBunkatugo.setYenhkgkgoukei(hokenKngkYenGoukei);

            keisanGaikakanzan.exec(C_Tuukasyu.JPY, skBunkatugo.getMisyuup(), kawaseRate, C_HasuusyoriKbn.AGE);
            yenkaMisyuuP = keisanGaikakanzan.getKanzanGaku();
            skBunkatugo.setYenkamisyuup(yenkaMisyuuP);

            keisanGaikakanzan.execDivide(keiyakuTuukasyu, skBunkatugo.getYenkahaitoukin(), gaikaknsnKwsrate, C_HasuusyoriKbn.AGE);
            haitoukin = keisanGaikakanzan.getKanzanGaku();
            skBunkatugo.setHaitoukin(haitoukin);

            keisanGaikakanzan.execDivide(keiyakuTuukasyu, skBunkatugo.getYenkasonotahaitoukin(), gaikaknsnKwsrate, C_HasuusyoriKbn.AGE);
            sonotahaitoukin = keisanGaikakanzan.getKanzanGaku();
            skBunkatugo.setSonotahaitoukin(sonotahaitoukin);

            if (C_SeisankinKanritukaKbn.YENKA.eq(uiBean.getSiSyouhnZokusei().getMikeikapknrtuukakbn())) {
                skBunkatugo.setYenkamikeikap(yenBunkatugk.get(YEN_MIKEIKAP_BUNKATUKEY));

                keisanGaikakanzan.execDivide(keiyakuTuukasyu, skBunkatugo.getYenkamikeikap(), gaikaknsnKwsrate, C_HasuusyoriKbn.AGE);
                mikeikaP = keisanGaikakanzan.getKanzanGaku();
                skBunkatugo.setMikeikap(mikeikaP);
            } else {
                skBunkatugo.setMikeikap(gaikaBunkatugk.get(GAIKA_MIKEIKAP_BUNKATUKEY));

                keisanGaikakanzan.exec(C_Tuukasyu.JPY, skBunkatugo.getMikeikap(), kawaseRate, C_HasuusyoriKbn.AGE);
                yenkaMikeikaP = keisanGaikakanzan.getKanzanGaku();
                skBunkatugo.setYenkamikeikap(yenkaMikeikaP);
            }

            if (C_SeisankinKanritukaKbn.YENKA.eq(uiBean.getSiSyouhnZokusei().getZnnusisnkinknrtuukakbn())) {
                skBunkatugo.setYenkazennouseisankgk(yenBunkatugk.get(YEN_ZENNOU_BUNKATUKEY));

                keisanGaikakanzan.execDivide(keiyakuTuukasyu, skBunkatugo.getYenkazennouseisankgk(), gaikaknsnKwsrate, C_HasuusyoriKbn.AGE);
                zennouSeisanKgk = keisanGaikakanzan.getKanzanGaku();
                skBunkatugo.setZennouseisankgk(zennouSeisanKgk);
            } else {
                skBunkatugo.setZennouseisankgk(gaikaBunkatugk.get(GAIKA_ZENNOU_BUNKATUKEY));

                keisanGaikakanzan.exec(C_Tuukasyu.JPY, skBunkatugo.getZennouseisankgk(), kawaseRate, C_HasuusyoriKbn.AGE);
                yenkaZennouSeisanKgk = keisanGaikakanzan.getKanzanGaku();
                skBunkatugo.setYenkazennouseisankgk(yenkaZennouSeisanKgk);
            }

            keisanGaikakanzan.execDivide(keiyakuTuukasyu, skBunkatugo.getYenkakrkgk(), gaikaknsnKwsrate, C_HasuusyoriKbn.AGE);
            krkgk = keisanGaikakanzan.getKanzanGaku();
            skBunkatugo.setKrkgk(krkgk);

            keisanGaikakanzan.execDivide(keiyakuTuukasyu, zitkAzukariKingkYen, skBunkatugo.getGaikaknsnkwsrate(), C_HasuusyoriKbn.AGE);
            azukariKingk = zitkAzukariKingkSiteituuka.add(keisanGaikakanzan.getKanzanGaku());

            keisanGaikakanzan.exec(C_Tuukasyu.JPY, zitkAzukariKingkSiteituuka, skBunkatugo.getShrkwsrate(), C_HasuusyoriKbn.AGE);
            yenkaAzukariKingk = zitkAzukariKingkYen.add(keisanGaikakanzan.getKanzanGaku());

            skBunkatugo.setAzukarikingk(azukariKingk);
            skBunkatugo.setYenkaazukarikingk(yenkaAzukariKingk);

        }

        BizPropertyInitializer.initialize(skBunkatugo);
        uiBean.setSkBunkatugo(skBunkatugo);

        if (gaikaBunkatuKekka.size() > 0) {

            if (gaikaBunkatuKekka.get(1) != null) {
                uiBean.setGaikaknrgoukei1(gaikaBunkatuKekka.get(1).get(GAIKA_GOUKEI_BUNKATUKEY));
                uiBean.setHokenkngkgoukei1(gaikaBunkatuKekka.get(1).get(GAIKA_S_BUNKATUKEY));
                uiBean.setZitkazkrknstituka1(gaikaBunkatuKekka.get(1).get(SITEI_ZEITEKI_BUNKATUKEY));
                uiBean.setMisyuup1(gaikaBunkatuKekka.get(1).get(GAIKA_MISYUUP_BUNKATUKEY));
                uiBean.setMikeikap1(gaikaBunkatuKekka.get(1).get(GAIKA_MIKEIKAP_BUNKATUKEY));
                uiBean.setZnnusisnkgk1(gaikaBunkatuKekka.get(1).get(GAIKA_ZENNOU_BUNKATUKEY));
            }

            if (gaikaBunkatuKekka.get(2) != null) {
                uiBean.setGaikaknrgoukei2(gaikaBunkatuKekka.get(2).get(GAIKA_GOUKEI_BUNKATUKEY));
                uiBean.setHokenkngkgoukei2(gaikaBunkatuKekka.get(2).get(GAIKA_S_BUNKATUKEY));
                uiBean.setZitkazkrknstituka2(gaikaBunkatuKekka.get(2).get(SITEI_ZEITEKI_BUNKATUKEY));
                uiBean.setMisyuup2(gaikaBunkatuKekka.get(2).get(GAIKA_MISYUUP_BUNKATUKEY));
                uiBean.setMikeikap2(gaikaBunkatuKekka.get(2).get(GAIKA_MIKEIKAP_BUNKATUKEY));
                uiBean.setZnnusisnkgk2(gaikaBunkatuKekka.get(2).get(GAIKA_ZENNOU_BUNKATUKEY));
            }

            if (gaikaBunkatuKekka.get(3) != null) {
                uiBean.setGaikaknrgoukei3(gaikaBunkatuKekka.get(3).get(GAIKA_GOUKEI_BUNKATUKEY));
                uiBean.setHokenkngkgoukei3(gaikaBunkatuKekka.get(3).get(GAIKA_S_BUNKATUKEY));
                uiBean.setZitkazkrknstituka3(gaikaBunkatuKekka.get(3).get(SITEI_ZEITEKI_BUNKATUKEY));
                uiBean.setMisyuup3(gaikaBunkatuKekka.get(3).get(GAIKA_MISYUUP_BUNKATUKEY));
                uiBean.setMikeikap3(gaikaBunkatuKekka.get(3).get(GAIKA_MIKEIKAP_BUNKATUKEY));
                uiBean.setZnnusisnkgk3(gaikaBunkatuKekka.get(3).get(GAIKA_ZENNOU_BUNKATUKEY));
            }

            if (gaikaBunkatuKekka.get(4) != null) {
                uiBean.setGaikaknrgoukei4(gaikaBunkatuKekka.get(4).get(GAIKA_GOUKEI_BUNKATUKEY));
                uiBean.setHokenkngkgoukei4(gaikaBunkatuKekka.get(4).get(GAIKA_S_BUNKATUKEY));
                uiBean.setZitkazkrknstituka4(gaikaBunkatuKekka.get(4).get(SITEI_ZEITEKI_BUNKATUKEY));
                uiBean.setMisyuup4(gaikaBunkatuKekka.get(4).get(GAIKA_MISYUUP_BUNKATUKEY));
                uiBean.setMikeikap4(gaikaBunkatuKekka.get(4).get(GAIKA_MIKEIKAP_BUNKATUKEY));
                uiBean.setZnnusisnkgk4(gaikaBunkatuKekka.get(4).get(GAIKA_ZENNOU_BUNKATUKEY));
            }

            if (gaikaBunkatuKekka.get(5) != null) {
                uiBean.setGaikaknrgoukei5(gaikaBunkatuKekka.get(5).get(GAIKA_GOUKEI_BUNKATUKEY));
                uiBean.setHokenkngkgoukei5(gaikaBunkatuKekka.get(5).get(GAIKA_S_BUNKATUKEY));
                uiBean.setZitkazkrknstituka5(gaikaBunkatuKekka.get(5).get(SITEI_ZEITEKI_BUNKATUKEY));
                uiBean.setMisyuup5(gaikaBunkatuKekka.get(5).get(GAIKA_MISYUUP_BUNKATUKEY));
                uiBean.setMikeikap5(gaikaBunkatuKekka.get(5).get(GAIKA_MIKEIKAP_BUNKATUKEY));
                uiBean.setZnnusisnkgk5(gaikaBunkatuKekka.get(5).get(GAIKA_ZENNOU_BUNKATUKEY));
            }

            if (gaikaBunkatuKekka.get(6) != null) {
                uiBean.setGaikaknrgoukei6(gaikaBunkatuKekka.get(6).get(GAIKA_GOUKEI_BUNKATUKEY));
                uiBean.setHokenkngkgoukei6(gaikaBunkatuKekka.get(6).get(GAIKA_S_BUNKATUKEY));
                uiBean.setZitkazkrknstituka6(gaikaBunkatuKekka.get(6).get(SITEI_ZEITEKI_BUNKATUKEY));
                uiBean.setMisyuup6(gaikaBunkatuKekka.get(6).get(GAIKA_MISYUUP_BUNKATUKEY));
                uiBean.setMikeikap6(gaikaBunkatuKekka.get(6).get(GAIKA_MIKEIKAP_BUNKATUKEY));
                uiBean.setZnnusisnkgk6(gaikaBunkatuKekka.get(6).get(GAIKA_ZENNOU_BUNKATUKEY));
            }

            if (gaikaBunkatuKekka.get(7) != null) {
                uiBean.setGaikaknrgoukei7(gaikaBunkatuKekka.get(7).get(GAIKA_GOUKEI_BUNKATUKEY));
                uiBean.setHokenkngkgoukei7(gaikaBunkatuKekka.get(7).get(GAIKA_S_BUNKATUKEY));
                uiBean.setZitkazkrknstituka7(gaikaBunkatuKekka.get(7).get(SITEI_ZEITEKI_BUNKATUKEY));
                uiBean.setMisyuup7(gaikaBunkatuKekka.get(7).get(GAIKA_MISYUUP_BUNKATUKEY));
                uiBean.setMikeikap7(gaikaBunkatuKekka.get(7).get(GAIKA_MIKEIKAP_BUNKATUKEY));
                uiBean.setZnnusisnkgk7(gaikaBunkatuKekka.get(7).get(GAIKA_ZENNOU_BUNKATUKEY));
            }

            if (gaikaBunkatuKekka.get(8) != null) {
                uiBean.setGaikaknrgoukei8(gaikaBunkatuKekka.get(8).get(GAIKA_GOUKEI_BUNKATUKEY));
                uiBean.setHokenkngkgoukei8(gaikaBunkatuKekka.get(8).get(GAIKA_S_BUNKATUKEY));
                uiBean.setZitkazkrknstituka8(gaikaBunkatuKekka.get(8).get(SITEI_ZEITEKI_BUNKATUKEY));
                uiBean.setMisyuup8(gaikaBunkatuKekka.get(8).get(GAIKA_MISYUUP_BUNKATUKEY));
                uiBean.setMikeikap8(gaikaBunkatuKekka.get(8).get(GAIKA_MIKEIKAP_BUNKATUKEY));
                uiBean.setZnnusisnkgk8(gaikaBunkatuKekka.get(8).get(GAIKA_ZENNOU_BUNKATUKEY));
            }

            if (gaikaBunkatuKekka.get(9) != null) {
                uiBean.setGaikaknrgoukei9(gaikaBunkatuKekka.get(9).get(GAIKA_GOUKEI_BUNKATUKEY));
                uiBean.setHokenkngkgoukei9(gaikaBunkatuKekka.get(9).get(GAIKA_S_BUNKATUKEY));
                uiBean.setZitkazkrknstituka9(gaikaBunkatuKekka.get(9).get(SITEI_ZEITEKI_BUNKATUKEY));
                uiBean.setMisyuup9(gaikaBunkatuKekka.get(9).get(GAIKA_MISYUUP_BUNKATUKEY));
                uiBean.setMikeikap9(gaikaBunkatuKekka.get(9).get(GAIKA_MIKEIKAP_BUNKATUKEY));
                uiBean.setZnnusisnkgk9(gaikaBunkatuKekka.get(9).get(GAIKA_ZENNOU_BUNKATUKEY));
            }

            if (gaikaBunkatuKekka.get(10) != null) {
                uiBean.setGaikaknrgoukei10(gaikaBunkatuKekka.get(10).get(GAIKA_GOUKEI_BUNKATUKEY));
                uiBean.setHokenkngkgoukei10(gaikaBunkatuKekka.get(10).get(GAIKA_S_BUNKATUKEY));
                uiBean.setZitkazkrknstituka10(gaikaBunkatuKekka.get(10).get(SITEI_ZEITEKI_BUNKATUKEY));
                uiBean.setMisyuup10(gaikaBunkatuKekka.get(10).get(GAIKA_MISYUUP_BUNKATUKEY));
                uiBean.setMikeikap10(gaikaBunkatuKekka.get(10).get(GAIKA_MIKEIKAP_BUNKATUKEY));
                uiBean.setZnnusisnkgk10(gaikaBunkatuKekka.get(10).get(GAIKA_ZENNOU_BUNKATUKEY));
            }

            if (gaikaBunkatuKekka.get(11) != null) {
                uiBean.setGaikaknrgoukei11(gaikaBunkatuKekka.get(11).get(GAIKA_GOUKEI_BUNKATUKEY));
                uiBean.setHokenkngkgoukei11(gaikaBunkatuKekka.get(11).get(GAIKA_S_BUNKATUKEY));
                uiBean.setZitkazkrknstituka11(gaikaBunkatuKekka.get(11).get(SITEI_ZEITEKI_BUNKATUKEY));
                uiBean.setMisyuup11(gaikaBunkatuKekka.get(11).get(GAIKA_MISYUUP_BUNKATUKEY));
                uiBean.setMikeikap11(gaikaBunkatuKekka.get(11).get(GAIKA_MIKEIKAP_BUNKATUKEY));
                uiBean.setZnnusisnkgk11(gaikaBunkatuKekka.get(11).get(GAIKA_ZENNOU_BUNKATUKEY));
            }

            if (gaikaBunkatuKekka.get(12) != null) {
                uiBean.setGaikaknrgoukei12(gaikaBunkatuKekka.get(12).get(GAIKA_GOUKEI_BUNKATUKEY));
                uiBean.setHokenkngkgoukei12(gaikaBunkatuKekka.get(12).get(GAIKA_S_BUNKATUKEY));
                uiBean.setZitkazkrknstituka12(gaikaBunkatuKekka.get(12).get(SITEI_ZEITEKI_BUNKATUKEY));
                uiBean.setMisyuup12(gaikaBunkatuKekka.get(12).get(GAIKA_MISYUUP_BUNKATUKEY));
                uiBean.setMikeikap12(gaikaBunkatuKekka.get(12).get(GAIKA_MIKEIKAP_BUNKATUKEY));
                uiBean.setZnnusisnkgk12(gaikaBunkatuKekka.get(12).get(GAIKA_ZENNOU_BUNKATUKEY));
            }

            if (gaikaBunkatuKekka.get(13) != null) {
                uiBean.setGaikaknrgoukei13(gaikaBunkatuKekka.get(13).get(GAIKA_GOUKEI_BUNKATUKEY));
                uiBean.setHokenkngkgoukei13(gaikaBunkatuKekka.get(13).get(GAIKA_S_BUNKATUKEY));
                uiBean.setZitkazkrknstituka13(gaikaBunkatuKekka.get(13).get(SITEI_ZEITEKI_BUNKATUKEY));
                uiBean.setMisyuup13(gaikaBunkatuKekka.get(13).get(GAIKA_MISYUUP_BUNKATUKEY));
                uiBean.setMikeikap13(gaikaBunkatuKekka.get(13).get(GAIKA_MIKEIKAP_BUNKATUKEY));
                uiBean.setZnnusisnkgk13(gaikaBunkatuKekka.get(13).get(GAIKA_ZENNOU_BUNKATUKEY));
            }

            if (gaikaBunkatuKekka.get(14) != null) {
                uiBean.setGaikaknrgoukei14(gaikaBunkatuKekka.get(14).get(GAIKA_GOUKEI_BUNKATUKEY));
                uiBean.setHokenkngkgoukei14(gaikaBunkatuKekka.get(14).get(GAIKA_S_BUNKATUKEY));
                uiBean.setZitkazkrknstituka14(gaikaBunkatuKekka.get(14).get(SITEI_ZEITEKI_BUNKATUKEY));
                uiBean.setMisyuup14(gaikaBunkatuKekka.get(14).get(GAIKA_MISYUUP_BUNKATUKEY));
                uiBean.setMikeikap14(gaikaBunkatuKekka.get(14).get(GAIKA_MIKEIKAP_BUNKATUKEY));
                uiBean.setZnnusisnkgk14(gaikaBunkatuKekka.get(14).get(GAIKA_ZENNOU_BUNKATUKEY));
            }

            if (gaikaBunkatuKekka.get(15) != null) {
                uiBean.setGaikaknrgoukei15(gaikaBunkatuKekka.get(15).get(GAIKA_GOUKEI_BUNKATUKEY));
                uiBean.setHokenkngkgoukei15(gaikaBunkatuKekka.get(15).get(GAIKA_S_BUNKATUKEY));
                uiBean.setZitkazkrknstituka15(gaikaBunkatuKekka.get(15).get(SITEI_ZEITEKI_BUNKATUKEY));
                uiBean.setMisyuup15(gaikaBunkatuKekka.get(15).get(GAIKA_MISYUUP_BUNKATUKEY));
                uiBean.setMikeikap15(gaikaBunkatuKekka.get(15).get(GAIKA_MIKEIKAP_BUNKATUKEY));
                uiBean.setZnnusisnkgk15(gaikaBunkatuKekka.get(15).get(GAIKA_ZENNOU_BUNKATUKEY));
            }
        }

        if (yenBunkatuKekka.size() > 0) {

            if (yenBunkatuKekka.get(1) != null) {
                uiBean.setYenkaknrgoukei1(yenBunkatuKekka.get(1).get(YEN_GOUKEI_BUNKATUKEY));
                uiBean.setYenhknkngkguki1(yenBunkatuKekka.get(1).get(YEN_S_BUNKATUKEY));
                uiBean.setYenhaitoukin1(yenBunkatuKekka.get(1).get(YEN_HAITOU_BUNKATUKEY));
                uiBean.setYensonotahaitoukin1(yenBunkatuKekka.get(1).get(YEN_SONOTAHAITOU_BUNKATUKEY));
                uiBean.setYenmikeikap1(yenBunkatuKekka.get(1).get(YEN_MIKEIKAP_BUNKATUKEY));
                uiBean.setYenmisyuup1(yenBunkatuKekka.get(1).get(YEN_MISYUUP_BUNKATUKEY));
                uiBean.setYenznnusisnkgk1(yenBunkatuKekka.get(1).get(YEN_ZENNOU_BUNKATUKEY));
                uiBean.setZitkazkrknyen1(yenBunkatuKekka.get(1).get(YEN_ZEITEKI_BUNKATUKEY));
                uiBean.setYenkrkgk1(yenBunkatuKekka.get(1).get(YEN_KARIUKE_BUNKATUKEY));
            }

            if (yenBunkatuKekka.get(2) != null) {
                uiBean.setYenkaknrgoukei2(yenBunkatuKekka.get(2).get(YEN_GOUKEI_BUNKATUKEY));
                uiBean.setYenhknkngkguki2(yenBunkatuKekka.get(2).get(YEN_S_BUNKATUKEY));
                uiBean.setYenhaitoukin2(yenBunkatuKekka.get(2).get(YEN_HAITOU_BUNKATUKEY));
                uiBean.setYensonotahaitoukin2(yenBunkatuKekka.get(2).get(YEN_SONOTAHAITOU_BUNKATUKEY));
                uiBean.setYenmikeikap2(yenBunkatuKekka.get(2).get(YEN_MIKEIKAP_BUNKATUKEY));
                uiBean.setYenmisyuup2(yenBunkatuKekka.get(2).get(YEN_MISYUUP_BUNKATUKEY));
                uiBean.setYenznnusisnkgk2(yenBunkatuKekka.get(2).get(YEN_ZENNOU_BUNKATUKEY));
                uiBean.setZitkazkrknyen2(yenBunkatuKekka.get(2).get(YEN_ZEITEKI_BUNKATUKEY));
                uiBean.setYenkrkgk2(yenBunkatuKekka.get(2).get(YEN_KARIUKE_BUNKATUKEY));
            }

            if (yenBunkatuKekka.get(3) != null) {
                uiBean.setYenkaknrgoukei3(yenBunkatuKekka.get(3).get(YEN_GOUKEI_BUNKATUKEY));
                uiBean.setYenhknkngkguki3(yenBunkatuKekka.get(3).get(YEN_S_BUNKATUKEY));
                uiBean.setYenhaitoukin3(yenBunkatuKekka.get(3).get(YEN_HAITOU_BUNKATUKEY));
                uiBean.setYensonotahaitoukin3(yenBunkatuKekka.get(3).get(YEN_SONOTAHAITOU_BUNKATUKEY));
                uiBean.setYenmikeikap3(yenBunkatuKekka.get(3).get(YEN_MIKEIKAP_BUNKATUKEY));
                uiBean.setYenmisyuup3(yenBunkatuKekka.get(3).get(YEN_MISYUUP_BUNKATUKEY));
                uiBean.setYenznnusisnkgk3(yenBunkatuKekka.get(3).get(YEN_ZENNOU_BUNKATUKEY));
                uiBean.setZitkazkrknyen3(yenBunkatuKekka.get(3).get(YEN_ZEITEKI_BUNKATUKEY));
                uiBean.setYenkrkgk3(yenBunkatuKekka.get(3).get(YEN_KARIUKE_BUNKATUKEY));
            }

            if (yenBunkatuKekka.get(4) != null) {
                uiBean.setYenkaknrgoukei4(yenBunkatuKekka.get(4).get(YEN_GOUKEI_BUNKATUKEY));
                uiBean.setYenhknkngkguki4(yenBunkatuKekka.get(4).get(YEN_S_BUNKATUKEY));
                uiBean.setYenhaitoukin4(yenBunkatuKekka.get(4).get(YEN_HAITOU_BUNKATUKEY));
                uiBean.setYensonotahaitoukin4(yenBunkatuKekka.get(4).get(YEN_SONOTAHAITOU_BUNKATUKEY));
                uiBean.setYenmikeikap4(yenBunkatuKekka.get(4).get(YEN_MIKEIKAP_BUNKATUKEY));
                uiBean.setYenmisyuup4(yenBunkatuKekka.get(4).get(YEN_MISYUUP_BUNKATUKEY));
                uiBean.setYenznnusisnkgk4(yenBunkatuKekka.get(4).get(YEN_ZENNOU_BUNKATUKEY));
                uiBean.setZitkazkrknyen4(yenBunkatuKekka.get(4).get(YEN_ZEITEKI_BUNKATUKEY));
                uiBean.setYenkrkgk4(yenBunkatuKekka.get(4).get(YEN_KARIUKE_BUNKATUKEY));
            }

            if (yenBunkatuKekka.get(5) != null) {
                uiBean.setYenkaknrgoukei5(yenBunkatuKekka.get(5).get(YEN_GOUKEI_BUNKATUKEY));
                uiBean.setYenhknkngkguki5(yenBunkatuKekka.get(5).get(YEN_S_BUNKATUKEY));
                uiBean.setYenhaitoukin5(yenBunkatuKekka.get(5).get(YEN_HAITOU_BUNKATUKEY));
                uiBean.setYensonotahaitoukin5(yenBunkatuKekka.get(5).get(YEN_SONOTAHAITOU_BUNKATUKEY));
                uiBean.setYenmikeikap5(yenBunkatuKekka.get(5).get(YEN_MIKEIKAP_BUNKATUKEY));
                uiBean.setYenmisyuup5(yenBunkatuKekka.get(5).get(YEN_MISYUUP_BUNKATUKEY));
                uiBean.setYenznnusisnkgk5(yenBunkatuKekka.get(5).get(YEN_ZENNOU_BUNKATUKEY));
                uiBean.setZitkazkrknyen5(yenBunkatuKekka.get(5).get(YEN_ZEITEKI_BUNKATUKEY));
                uiBean.setYenkrkgk5(yenBunkatuKekka.get(5).get(YEN_KARIUKE_BUNKATUKEY));
            }

            if (yenBunkatuKekka.get(6) != null) {
                uiBean.setYenkaknrgoukei6(yenBunkatuKekka.get(6).get(YEN_GOUKEI_BUNKATUKEY));
                uiBean.setYenhknkngkguki6(yenBunkatuKekka.get(6).get(YEN_S_BUNKATUKEY));
                uiBean.setYenhaitoukin6(yenBunkatuKekka.get(6).get(YEN_HAITOU_BUNKATUKEY));
                uiBean.setYensonotahaitoukin6(yenBunkatuKekka.get(6).get(YEN_SONOTAHAITOU_BUNKATUKEY));
                uiBean.setYenmikeikap6(yenBunkatuKekka.get(6).get(YEN_MIKEIKAP_BUNKATUKEY));
                uiBean.setYenmisyuup6(yenBunkatuKekka.get(6).get(YEN_MISYUUP_BUNKATUKEY));
                uiBean.setYenznnusisnkgk6(yenBunkatuKekka.get(6).get(YEN_ZENNOU_BUNKATUKEY));
                uiBean.setZitkazkrknyen6(yenBunkatuKekka.get(6).get(YEN_ZEITEKI_BUNKATUKEY));
                uiBean.setYenkrkgk6(yenBunkatuKekka.get(6).get(YEN_KARIUKE_BUNKATUKEY));
            }

            if (yenBunkatuKekka.get(7) != null) {
                uiBean.setYenkaknrgoukei7(yenBunkatuKekka.get(7).get(YEN_GOUKEI_BUNKATUKEY));
                uiBean.setYenhknkngkguki7(yenBunkatuKekka.get(7).get(YEN_S_BUNKATUKEY));
                uiBean.setYenhaitoukin7(yenBunkatuKekka.get(7).get(YEN_HAITOU_BUNKATUKEY));
                uiBean.setYensonotahaitoukin7(yenBunkatuKekka.get(7).get(YEN_SONOTAHAITOU_BUNKATUKEY));
                uiBean.setYenmikeikap7(yenBunkatuKekka.get(7).get(YEN_MIKEIKAP_BUNKATUKEY));
                uiBean.setYenmisyuup7(yenBunkatuKekka.get(7).get(YEN_MISYUUP_BUNKATUKEY));
                uiBean.setYenznnusisnkgk7(yenBunkatuKekka.get(7).get(YEN_ZENNOU_BUNKATUKEY));
                uiBean.setZitkazkrknyen7(yenBunkatuKekka.get(7).get(YEN_ZEITEKI_BUNKATUKEY));
                uiBean.setYenkrkgk7(yenBunkatuKekka.get(7).get(YEN_KARIUKE_BUNKATUKEY));
            }

            if (yenBunkatuKekka.get(8) != null) {
                uiBean.setYenkaknrgoukei8(yenBunkatuKekka.get(8).get(YEN_GOUKEI_BUNKATUKEY));
                uiBean.setYenhknkngkguki8(yenBunkatuKekka.get(8).get(YEN_S_BUNKATUKEY));
                uiBean.setYenhaitoukin8(yenBunkatuKekka.get(8).get(YEN_HAITOU_BUNKATUKEY));
                uiBean.setYensonotahaitoukin8(yenBunkatuKekka.get(8).get(YEN_SONOTAHAITOU_BUNKATUKEY));
                uiBean.setYenmikeikap8(yenBunkatuKekka.get(8).get(YEN_MIKEIKAP_BUNKATUKEY));
                uiBean.setYenmisyuup8(yenBunkatuKekka.get(8).get(YEN_MISYUUP_BUNKATUKEY));
                uiBean.setYenznnusisnkgk8(yenBunkatuKekka.get(8).get(YEN_ZENNOU_BUNKATUKEY));
                uiBean.setZitkazkrknyen8(yenBunkatuKekka.get(8).get(YEN_ZEITEKI_BUNKATUKEY));
                uiBean.setYenkrkgk8(yenBunkatuKekka.get(8).get(YEN_KARIUKE_BUNKATUKEY));
            }

            if (yenBunkatuKekka.get(9) != null) {
                uiBean.setYenkaknrgoukei9(yenBunkatuKekka.get(9).get(YEN_GOUKEI_BUNKATUKEY));
                uiBean.setYenhknkngkguki9(yenBunkatuKekka.get(9).get(YEN_S_BUNKATUKEY));
                uiBean.setYenhaitoukin9(yenBunkatuKekka.get(9).get(YEN_HAITOU_BUNKATUKEY));
                uiBean.setYensonotahaitoukin9(yenBunkatuKekka.get(9).get(YEN_SONOTAHAITOU_BUNKATUKEY));
                uiBean.setYenmikeikap9(yenBunkatuKekka.get(9).get(YEN_MIKEIKAP_BUNKATUKEY));
                uiBean.setYenmisyuup9(yenBunkatuKekka.get(9).get(YEN_MISYUUP_BUNKATUKEY));
                uiBean.setYenznnusisnkgk9(yenBunkatuKekka.get(9).get(YEN_ZENNOU_BUNKATUKEY));
                uiBean.setZitkazkrknyen9(yenBunkatuKekka.get(9).get(YEN_ZEITEKI_BUNKATUKEY));
                uiBean.setYenkrkgk9(yenBunkatuKekka.get(9).get(YEN_KARIUKE_BUNKATUKEY));
            }

            if (yenBunkatuKekka.get(10) != null) {
                uiBean.setYenkaknrgoukei10(yenBunkatuKekka.get(10).get(YEN_GOUKEI_BUNKATUKEY));
                uiBean.setYenhknkngkguki10(yenBunkatuKekka.get(10).get(YEN_S_BUNKATUKEY));
                uiBean.setYenhaitoukin10(yenBunkatuKekka.get(10).get(YEN_HAITOU_BUNKATUKEY));
                uiBean.setYensonotahaitoukin10(yenBunkatuKekka.get(10).get(YEN_SONOTAHAITOU_BUNKATUKEY));
                uiBean.setYenmikeikap10(yenBunkatuKekka.get(10).get(YEN_MIKEIKAP_BUNKATUKEY));
                uiBean.setYenmisyuup10(yenBunkatuKekka.get(10).get(YEN_MISYUUP_BUNKATUKEY));
                uiBean.setYenznnusisnkgk10(yenBunkatuKekka.get(10).get(YEN_ZENNOU_BUNKATUKEY));
                uiBean.setZitkazkrknyen10(yenBunkatuKekka.get(10).get(YEN_ZEITEKI_BUNKATUKEY));
                uiBean.setYenkrkgk10(yenBunkatuKekka.get(10).get(YEN_KARIUKE_BUNKATUKEY));
            }

            if (yenBunkatuKekka.get(11) != null) {
                uiBean.setYenkaknrgoukei11(yenBunkatuKekka.get(11).get(YEN_GOUKEI_BUNKATUKEY));
                uiBean.setYenhknkngkguki11(yenBunkatuKekka.get(11).get(YEN_S_BUNKATUKEY));
                uiBean.setYenhaitoukin11(yenBunkatuKekka.get(11).get(YEN_HAITOU_BUNKATUKEY));
                uiBean.setYensonotahaitoukin11(yenBunkatuKekka.get(11).get(YEN_SONOTAHAITOU_BUNKATUKEY));
                uiBean.setYenmikeikap11(yenBunkatuKekka.get(11).get(YEN_MIKEIKAP_BUNKATUKEY));
                uiBean.setYenmisyuup11(yenBunkatuKekka.get(11).get(YEN_MISYUUP_BUNKATUKEY));
                uiBean.setYenznnusisnkgk11(yenBunkatuKekka.get(11).get(YEN_ZENNOU_BUNKATUKEY));
                uiBean.setZitkazkrknyen11(yenBunkatuKekka.get(11).get(YEN_ZEITEKI_BUNKATUKEY));
                uiBean.setYenkrkgk11(yenBunkatuKekka.get(11).get(YEN_KARIUKE_BUNKATUKEY));
            }

            if (yenBunkatuKekka.get(12) != null) {
                uiBean.setYenkaknrgoukei12(yenBunkatuKekka.get(12).get(YEN_GOUKEI_BUNKATUKEY));
                uiBean.setYenhknkngkguki12(yenBunkatuKekka.get(12).get(YEN_S_BUNKATUKEY));
                uiBean.setYenhaitoukin12(yenBunkatuKekka.get(12).get(YEN_HAITOU_BUNKATUKEY));
                uiBean.setYensonotahaitoukin12(yenBunkatuKekka.get(12).get(YEN_SONOTAHAITOU_BUNKATUKEY));
                uiBean.setYenmikeikap12(yenBunkatuKekka.get(12).get(YEN_MIKEIKAP_BUNKATUKEY));
                uiBean.setYenmisyuup12(yenBunkatuKekka.get(12).get(YEN_MISYUUP_BUNKATUKEY));
                uiBean.setYenznnusisnkgk12(yenBunkatuKekka.get(12).get(YEN_ZENNOU_BUNKATUKEY));
                uiBean.setZitkazkrknyen12(yenBunkatuKekka.get(12).get(YEN_ZEITEKI_BUNKATUKEY));
                uiBean.setYenkrkgk12(yenBunkatuKekka.get(12).get(YEN_KARIUKE_BUNKATUKEY));
            }

            if (yenBunkatuKekka.get(13) != null) {
                uiBean.setYenkaknrgoukei13(yenBunkatuKekka.get(13).get(YEN_GOUKEI_BUNKATUKEY));
                uiBean.setYenhknkngkguki13(yenBunkatuKekka.get(13).get(YEN_S_BUNKATUKEY));
                uiBean.setYenhaitoukin13(yenBunkatuKekka.get(13).get(YEN_HAITOU_BUNKATUKEY));
                uiBean.setYensonotahaitoukin13(yenBunkatuKekka.get(13).get(YEN_SONOTAHAITOU_BUNKATUKEY));
                uiBean.setYenmikeikap13(yenBunkatuKekka.get(13).get(YEN_MIKEIKAP_BUNKATUKEY));
                uiBean.setYenmisyuup13(yenBunkatuKekka.get(13).get(YEN_MISYUUP_BUNKATUKEY));
                uiBean.setYenznnusisnkgk13(yenBunkatuKekka.get(13).get(YEN_ZENNOU_BUNKATUKEY));
                uiBean.setZitkazkrknyen13(yenBunkatuKekka.get(13).get(YEN_ZEITEKI_BUNKATUKEY));
                uiBean.setYenkrkgk13(yenBunkatuKekka.get(13).get(YEN_KARIUKE_BUNKATUKEY));
            }

            if (yenBunkatuKekka.get(14) != null) {
                uiBean.setYenkaknrgoukei14(yenBunkatuKekka.get(14).get(YEN_GOUKEI_BUNKATUKEY));
                uiBean.setYenhknkngkguki14(yenBunkatuKekka.get(14).get(YEN_S_BUNKATUKEY));
                uiBean.setYenhaitoukin14(yenBunkatuKekka.get(14).get(YEN_HAITOU_BUNKATUKEY));
                uiBean.setYensonotahaitoukin14(yenBunkatuKekka.get(14).get(YEN_SONOTAHAITOU_BUNKATUKEY));
                uiBean.setYenmikeikap14(yenBunkatuKekka.get(14).get(YEN_MIKEIKAP_BUNKATUKEY));
                uiBean.setYenmisyuup14(yenBunkatuKekka.get(14).get(YEN_MISYUUP_BUNKATUKEY));
                uiBean.setYenznnusisnkgk14(yenBunkatuKekka.get(14).get(YEN_ZENNOU_BUNKATUKEY));
                uiBean.setZitkazkrknyen14(yenBunkatuKekka.get(14).get(YEN_ZEITEKI_BUNKATUKEY));
                uiBean.setYenkrkgk14(yenBunkatuKekka.get(14).get(YEN_KARIUKE_BUNKATUKEY));
            }

            if (yenBunkatuKekka.get(15) != null) {
                uiBean.setYenkaknrgoukei15(yenBunkatuKekka.get(15).get(YEN_GOUKEI_BUNKATUKEY));
                uiBean.setYenhknkngkguki15(yenBunkatuKekka.get(15).get(YEN_S_BUNKATUKEY));
                uiBean.setYenhaitoukin15(yenBunkatuKekka.get(15).get(YEN_HAITOU_BUNKATUKEY));
                uiBean.setYensonotahaitoukin15(yenBunkatuKekka.get(15).get(YEN_SONOTAHAITOU_BUNKATUKEY));
                uiBean.setYenmikeikap15(yenBunkatuKekka.get(15).get(YEN_MIKEIKAP_BUNKATUKEY));
                uiBean.setYenmisyuup15(yenBunkatuKekka.get(15).get(YEN_MISYUUP_BUNKATUKEY));
                uiBean.setYenznnusisnkgk15(yenBunkatuKekka.get(15).get(YEN_ZENNOU_BUNKATUKEY));
                uiBean.setZitkazkrknyen15(yenBunkatuKekka.get(15).get(YEN_ZEITEKI_BUNKATUKEY));
                uiBean.setYenkrkgk15(yenBunkatuKekka.get(15).get(YEN_KARIUKE_BUNKATUKEY));
            }
        }
    }

    private void chekNyuuryoku() {


        List<UktrInfoDataSourceBean> uktrInfoList = uiBean.getUktrInfoDataSource().getDatas();

        int uktrNinsuu = uiBean.getSbuktninint();
        C_BunkatuHouhouKbn bunkatuhouhoukbn = uiBean.getBunkatuhouhoukbn();

        if (C_BunkatuHouhouKbn.WARIAI.eq(bunkatuhouhoukbn)) {

            int sumUktrbunsi = 0;
            int chkUktrbunbo = 0;
            if (uktrInfoList.get(0).getUktrwraibunbo() == null) {
                throw new BizLogicException(MessageId.EJA1051);
            }
            chkUktrbunbo = uktrInfoList.get(0).getUktrwraibunbo();

            for (int i = 0; i < uktrNinsuu; i++) {
                UktrInfoDataSourceBean uktrInfo = uktrInfoList.get(i);

                if (uktrInfo.getUktrwraibunsi() == null || uktrInfo.getUktrwraibunbo() == null) {
                    throw new BizLogicException(MessageId.EJA1051);
                }
                sumUktrbunsi = sumUktrbunsi + uktrInfo.getUktrwraibunsi();

                if (chkUktrbunbo != uktrInfo.getUktrwraibunbo()) {
                    throw new BizLogicException(MessageId.EJA1052);
                }
            }

            if (chkUktrbunbo != sumUktrbunsi) {
                throw new BizLogicException(MessageId.EJA1053);
            }
        }

        int countChkUktrnin = 0;

        for (int i = 0; i < uktrNinsuu; i++) {
            Boolean shrtaisyou = uktrInfoList.get(i).getShrtaisyou();
            if (shrtaisyou) {
                ++countChkUktrnin;
                if (countChkUktrnin > 1) {
                    throw new BizLogicException(MessageId.EJA1054);
                }
            }
        }
        if (countChkUktrnin == 0) {
            throw new BizLogicException(MessageId.EJA1055);
        }


        List<JT_SkJiyuu> skJiyuuList = uiBean.getSkMax().getSkJiyuus();
        BizDate sibouYmd = skJiyuuList.get(0).getSibouymd();
        uiBean.setSibouymd(sibouYmd);

        if (BizDateUtil.compareYmd(uiBean.getSyoruiukeymd(), sibouYmd) == BizDateUtil.COMPARE_LESSER ||
            BizDateUtil.compareYmd(uiBean.getSyoruiukeymd(), sibouYmd) == BizDateUtil.COMPARE_EQUAL) {

            throw new BizLogicException(MessageId.EJA0075,
                MessageUtil.getMessage(JT_SkJiyuu.SIBOUYMD),
                MessageUtil.getMessage(DDID_SHRINFOMATION_SYORUIUKEYMD.getErrorResourceKey()));
        }

        if (BizDateUtil.compareYmd(uiBean.getShrymd(), uiBean.getSyoruiukeymd()) == BizDateUtil.COMPARE_LESSER ) {

            throw new BizLogicException(MessageId.EJA0081, MessageUtil.getMessage(DDID_SHRINFOMATION_SHRYMD
                .getErrorResourceKey()), MessageUtil.getMessage(DDID_SHRINFOMATION_SYORUIUKEYMD
                    .getErrorResourceKey()));
        }
    }

    private void setUibean() {

        List<UktrInfoDataSourceBean> uktrInfo = Lists.newArrayList();
        for(int i=1; i<=UKTRNINSUU_JOGUEN; i++ ){

            UktrInfoDataSourceBean uktrInfoBean = new UktrInfoDataSourceBean();

            uktrInfoBean.setShrtaisyou(false);
            uktrInfoBean.setUktrjuni(i);
            uktrInfo.add(uktrInfoBean);
        }
        uiBean.setUktrInfo(uktrInfo);

        if (C_Tuukasyu.JPY.eq(uiBean.getSkMax().getKyktuukasyu())) {
            uiBean.setPatternsiharaituukakbn(C_SiharaiTuukaKbn.PATTERN_YENDATE);
        } else {
            uiBean.setPatternsiharaituukakbn(C_SiharaiTuukaKbn.PATTERN_DEFAULT);
        }

        UserDefsList sbuktninOptionBeanList = new UserDefsList();
        LabelValuePair pair = new LabelValuePair();
        pair.setLabel("");
        pair.setValue("");
        sbuktninOptionBeanList.add(pair);

        for(int i=1; i<=UKTRNINSUU_JOGUEN; i++ ){

            LabelValuePair pairSelect = new LabelValuePair();
            pairSelect.setLabel(String.valueOf(i));
            pairSelect.setValue(String.valueOf(i));
            sbuktninOptionBeanList.add(pairSelect);
        }

        uiBean.setSbuktninmojiOptionBeanList(sbuktninOptionBeanList);

        uiBean.setBunkatuhouhoukbn(C_BunkatuHouhouKbn.WARIAI);
    }

    private void setKykInfo() {

        KeiyakuInfoSyutoku keiyakuInfoSyutoku = SWAKInjector.getInstance(KeiyakuInfoSyutoku.class);
        KeiyakuPrm keiyakuPrm = SWAKInjector.getInstance(KeiyakuPrm.class);

        keiyakuPrm.setSyono(uiBean.getSyono());

        keiyakuInfoSyutoku.getInfos(keiyakuPrm);

        List<JT_SiKykKihon> siKykKihonList = keiyakuInfoSyutoku.getKykKihons();

        if (siKykKihonList.get(0) == null) {
            throw new BizLogicException(MessageId.EBA0048);
        }

        uiBean.setSiKykKihon(siKykKihonList.get(0));

        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();

        for (JT_SiKykSyouhn worksiKykSyouhn : siKykKihonList.get(0).getSiKykSyouhns()) {

            if (C_SyutkKbn.SYU.eq(worksiKykSyouhn.getSyutkkbn())) {

                siKykSyouhn = worksiKykSyouhn;

                break;
            }
        }

        uiBean.setSiKykSyouhn(siKykSyouhn);

        List<JT_SkKihon> skKihonList = siharaiDomManager.getSkKihonsBySyonoSeikyuusyubetu(uiBean.getSyono(), C_SeikyuuSyubetu.SB);

        JT_SkKihon taisyouSkKihon = null;
        for (JT_SkKihon skSKihon : skKihonList) {
            if (C_SaisateiKbn.BLNK.eq(skSKihon.getSaisateikbn())) {
                if (skSKihon.getSks() != null && skSKihon.getSks().size() != 0) {
                    taisyouSkKihon = skSKihon;
                }
            }
        }

        if (taisyouSkKihon == null) {
            throw new BizLogicException(MessageId.EBA0048);
        }

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(TeisuuSiharai.JIMUTETUZUKICD_SISIBOU);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU, C_Kouteikanristatus.KANRYOU);
        bzGetProcessSummaryInBean.setSyoNo(uiBean.getSyono());

        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        List<BzGetProcessSummaryOutBean> processSummaryOutBeanList = bzGetProcessSummary
            .exec(bzGetProcessSummaryInBean);

        if (processSummaryOutBeanList.size() == 0) {
            throw new BizLogicException(MessageId.EBA0048);
        }

        String skNo = taisyouSkKihon.getSkno();
        BzGetProcessSummaryOutBean taisyouOut = new BzGetProcessSummaryOutBean();
        for (BzGetProcessSummaryOutBean out : processSummaryOutBeanList) {
            if (skNo.equals(out.getSkNo())) {
                taisyouOut = out;
            }
        }
        if (C_Kouteikanristatus.KANRYOU.eq(taisyouOut.getKouteiKanriStatus())) {
            uiBean.setKouteikanryouFlag(true);

        } else {
            if (C_SikinouModeIdKbn.TETUDUKI_SATEIHUYOU.getValue().equals(taisyouOut.getNowNodoId()) ||
                C_SikinouModeIdKbn.TETUDUKI_SATEIYOU.getValue().equals(taisyouOut.getNowNodoId()) ||
                C_SikinouModeIdKbn.SYOUNIN_SATEIHUYOU.getValue().equals(taisyouOut.getNowNodoId()) ||
                C_SikinouModeIdKbn.SYOUNIN_SATEIYOU.getValue().equals(taisyouOut.getNowNodoId())) {

                uiBean.setKouteikanryouFlag(false);

            } else if (C_SikinouModeIdKbn.SESSYOU1.getValue().equals(taisyouOut.getNowNodoId()) ||
                C_SikinouModeIdKbn.SESSYOU2.getValue().equals(taisyouOut.getNowNodoId()) ||
                C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU.getValue().equals(taisyouOut.getNowNodoId()) ||
                C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU.getValue().equals(taisyouOut.getNowNodoId())) {

                uiBean.setKouteikanryouFlag(false);

            }else if (SIHARAIHUSIHARAI.equals(taisyouOut.getNowNodoId())) {

                uiBean.setKouteikanryouFlag(false);

            } else {

                throw new BizLogicException(MessageId.EBA0048);
            }
        }

        uiBean.setSkKihon(taisyouSkKihon);

        Integer  seikyuurirekiNo = siharaiDomManager.getSkMaxSeikyuurirekinoBySknoSyono(taisyouSkKihon.getSkno(), uiBean.getSyono());

        uiBean.setSkMax(taisyouSkKihon.getSkBySeikyuurirekino(seikyuurirekiNo));

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(uiBean.getSiKykSyouhn().getSyouhncd(),
            uiBean.getSiKykSyouhn().getSyouhnsdno());
        if (syouhnZokusei == null) {
            throw new BizAppException(MessageId.EBS0005,BM_SyouhnZokusei.TABLE_NAME, BM_SyouhnZokusei.SYOUHNCD,
                uiBean.getSiKykSyouhn().getSyouhncd(), BM_SyouhnZokusei.SYOUHNSDNO,
                String.valueOf(uiBean.getSiKykSyouhn().getSyouhnsdno()));
        }
        uiBean.setSyouhnZokusei(syouhnZokusei);

        C_ZeitratkiKbn zeitratkiKbn = C_ZeitratkiKbn.BLNK;

        if (C_Tdk.HONNIN.eq(siKykKihonList.get(0).getKkkyktdk())) {
            zeitratkiKbn = C_ZeitratkiKbn.SOUZOKU;
        }
        else {
            zeitratkiKbn = C_ZeitratkiKbn.ZOUYO;
        }

        uiBean.setZeitratkikbn(zeitratkiKbn);

        JM_SiSyouhnZokusei siSyouhnZokusei = siharaiDomManager.getSiSyouhnZokuseisBySyouhncd(uiBean.getSiKykSyouhn()
            .getSyouhncd());
        uiBean.setSiSyouhnZokusei(siSyouhnZokusei);
    }

    private Map<Integer, Map<String, BizCurrency>> calcBunkatuKingaku(Integer pUktrninsuu,
        Map<Integer,UktrWariaiBean> pUktrwariaiBean, Map<String, BizCurrency> pBunkatuKingakuMap, String pHasuuHimoku, String pSumHimoku){

        Map<Integer, Map<String, BizCurrency>> bunkatuKekka = new TreeMap<Integer, Map<String, BizCurrency>>();

        for (int i = 1; i <= pUktrninsuu; i++) {

            bunkatuKekka.put(i, new HashMap<String, BizCurrency>());
        }

        for (Map.Entry<String, BizCurrency> entry : pBunkatuKingakuMap.entrySet()) {

            if (!entry.getKey().equals(pHasuuHimoku)) {
                Map<Integer, BizCurrency> himokuBunkatuMap = new TreeMap<Integer, BizCurrency>();
                calcHimokubetuBunkatugk(himokuBunkatuMap, pUktrninsuu, pUktrwariaiBean, entry.getValue());

                for (int i = 1; i <= pUktrninsuu; i++) {
                    bunkatuKekka.get(i).put(entry.getKey(), himokuBunkatuMap.get(i));
                }
            }
        }

        if (pHasuuHimoku != null && pSumHimoku != null) {

            for (Map.Entry<Integer, Map<String, BizCurrency>> entry : bunkatuKekka.entrySet()) {

                BizCurrency sasihikiSum = BizCurrency.valueOf(0, entry.getValue().get(pSumHimoku).getType());

                for (Map.Entry<String, BizCurrency> entry2 : entry.getValue().entrySet()) {
                    if (!pSumHimoku.equals(entry2.getKey())) {
                        sasihikiSum = sasihikiSum.add(entry2.getValue());
                    }
                }

                BizCurrency hasuuTyousei = entry.getValue().get(pSumHimoku).subtract(sasihikiSum);
                entry.getValue().put(pHasuuHimoku, hasuuTyousei);

            }
        }

        return bunkatuKekka;
    }


    private void calcHimokubetuBunkatugk(Map<Integer, BizCurrency> himokuBunkatuMap, Integer pUktrninsuu,
        Map<Integer, UktrWariaiBean> pUktrwariaiBean, BizCurrency value) {

        BizCurrency amariWork = BizCurrency.valueOf(0, value.getType());

        for (int i = 1; i <= pUktrninsuu; i++) {
            UktrWariaiBean wariai = pUktrwariaiBean.get(i);
            BizCurrency kariBunkatugk = value.multiply(wariai.getUktrwraibunsi())
                .divide(wariai.getUktrwraibunbo(), 0, RoundingMode.DOWN);

            amariWork = amariWork.add(kariBunkatugk);

            himokuBunkatuMap.put(i, kariBunkatugk);
        }

        BizNumber amari = BizNumber.ZERO;
        BizCurrency saisyouTani;
        if (BizCurrencyTypes.YEN.equals(value.getType())) {
            amari = BizNumber.valueOf(value.subtract(amariWork));
            saisyouTani = BizCurrency.valueOf(1, value.getType());
        } else {
            BizNumber sagaku = BizNumber.valueOf(value.subtract(amariWork));
            amari = BizNumber.valueOf(sagaku.multiply(100));
            saisyouTani = BizCurrency.valueOf(0.01, value.getType());
        }

        if (amari.compareTo(BizNumber.ZERO) < 0) {
            amari = amari.multiply(-1);
        }

        if (amari.compareTo(BizNumber.ZERO) > 0) {
            for (int i = 1; i <= pUktrninsuu; i++) {
                if (amari.compareTo(BizNumber.valueOf(i)) >= 0 ) {

                    BizCurrency amariAddgk = himokuBunkatuMap.get(i);

                    if (amariAddgk.compareTo(BizCurrency.valueOf(0, amariAddgk.getType())) < 0) {

                        amariAddgk = amariAddgk.subtract(saisyouTani);

                    } else {

                        amariAddgk = himokuBunkatuMap.get(i).add(saisyouTani);
                    }
                    himokuBunkatuMap.put(i, amariAddgk);
                }
            }
        }
    }

    private String hasuuTyouseiSettei(Map<String, BizCurrency> pkingakuMap){

        String hasuuTyouseiHimoku = "";

        BizCurrency hikakuWork = null;

        int i = 1;

        for (Map.Entry<String, BizCurrency> entry : pkingakuMap.entrySet()) {

            if (entry.getValue().compareTo(BizCurrency.valueOf(0, entry.getValue().getType())) == 0) {
                continue;
            }

            if (i == 1) {
                hikakuWork = entry.getValue();
                hasuuTyouseiHimoku = entry.getKey();

            } else {

                if (entry.getValue().compareTo(hikakuWork) <= 0){
                    hikakuWork = entry.getValue();
                    hasuuTyouseiHimoku = entry.getKey();
                }
            }

            i++;
        }

        return hasuuTyouseiHimoku;
    }

    private void bunkatuMaeSettei(Map<String, BizCurrency> pGaikaBunkatuKingakuMap,
        Map<String, BizCurrency> pYenBunkatuKingakuMap) {

        BizCurrency yendateGoukei = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        if (C_Tuukasyu.JPY.eq(uiBean.getSiKykSyouhn().getKyktuukasyu())) {
            uiBean.setBnktmaeyenhknkngkguki(uiBean.getSkMax().getHokenkngkgoukei());
            yendateGoukei = uiBean.getSkMax().getHokenkngkgoukei().subtract(uiBean.getSkMax().getMisyuup()).add(uiBean.getSkMax().getMikeikap())
                .add(uiBean.getSkMax().getZennouseisankgk()).add(uiBean.getSkMax().getZitkazukarikingksiteituuka())
                .add(uiBean.getSkMax().getKrkgk()).add(uiBean.getSkMax().getHaitoukin()).add(uiBean.getSkMax().getSonotahaitoukin());
            uiBean.setBnktmaeyengoukei(yendateGoukei);

            uiBean.setBnktmaeyenmikeikap(uiBean.getSkMax().getMikeikap());
            uiBean.setBnktmaeyenmisyuup(uiBean.getSkMax().getMisyuup().multiply(-1));
            uiBean.setBnktmaeyenznnusisnkgk(uiBean.getSkMax().getZennouseisankgk());
            uiBean.setBnktmaezitkazkrknyen(uiBean.getSkMax().getZitkazukarikingksiteituuka());
            uiBean.setBnktmaeyenkrkgk(uiBean.getSkMax().getKrkgk());
            uiBean.setBnktmaeyenhaitoukin(uiBean.getSkMax().getHaitoukin());
            uiBean.setBnktmaeyensonotahaitoukin(uiBean.getSkMax().getSonotahaitoukin());

        } else {
            HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
            CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(uiBean.getSiKykSyouhn().getKyktuukasyu());

            if (uiBean.getSkMax().getYenkaknsntkgk().compareTo(BizCurrency.valueOf(0,
                uiBean.getSkMax().getYenkaknsntkgk().getType())) == 0) {
                uiBean.setBnktmaegaikagoukei(uiBean.getSkMax().getHokenkngkgoukei());
            } else {
                uiBean.setBnktmaegaikagoukei(uiBean.getSkMax().getYenkaknsntkgk());
            }

            uiBean.setBnktmaehokenkngkgoukei(uiBean.getSkMax().getHokenkngkgoukei());
            uiBean.setBnkatmaezitkazkrknstituka(uiBean.getSkMax().getZitkazukarikingksiteituuka());
            uiBean.setBnktmaemisyuup(uiBean.getSkMax().getMisyuup().multiply(-1));
            if (C_SeisankinKanritukaKbn.YENKA.eq(uiBean.getSiSyouhnZokusei().getMikeikapknrtuukakbn())) {
                uiBean.setBnktmaemikeikap(BizCurrency.valueOf(0, currencyType));
            } else {
                uiBean.setBnktmaemikeikap(uiBean.getSkMax().getMikeikap());
            }
            if (C_SeisankinKanritukaKbn.YENKA.eq(uiBean.getSiSyouhnZokusei().getZnnusisnkinknrtuukakbn())) {
                uiBean.setBnktmaeznnusisnkgk(BizCurrency.valueOf(0, currencyType));
            } else {
                uiBean.setBnktmaeznnusisnkgk(uiBean.getSkMax().getZennouseisankgk());
            }
            uiBean.setBnktmaeyengoukei(uiBean.getSkMax().getGaikaknsntkgk());
            uiBean.setBnktmaeyenhknkngkguki(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            uiBean.setBnktmaeyenhaitoukin(uiBean.getSkMax().getYenkahaitoukin());
            uiBean.setBnktmaeyensonotahaitoukin(uiBean.getSkMax().getYenkasonotahaitoukin());
            if (C_SeisankinKanritukaKbn.YENKA.eq(uiBean.getSiSyouhnZokusei().getMikeikapknrtuukakbn())) {
                uiBean.setBnktmaeyenmikeikap(uiBean.getSkMax().getYenkamikeikap());
            } else {
                uiBean.setBnktmaeyenmikeikap(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            }
            uiBean.setBnktmaeyenmisyuup(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            if (C_SeisankinKanritukaKbn.YENKA.eq(uiBean.getSiSyouhnZokusei().getZnnusisnkinknrtuukakbn())) {
                uiBean.setBnktmaeyenznnusisnkgk(uiBean.getSkMax().getYenkazennouseisankgk());
            } else {
                uiBean.setBnktmaeyenznnusisnkgk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            }
            uiBean.setBnktmaezitkazkrknyen(uiBean.getSkMax().getZitkazukarikingkyen());
            uiBean.setBnktmaeyenkrkgk(uiBean.getSkMax().getYenkakrkgk());

        }

        if (uiBean.getSkMax().getMikeikap()
            .compareTo(BizCurrency.valueOf(0, uiBean.getSkMax().getMikeikap().getType())) == 0) {
            uiBean.setMikeikapgaitoukkn("");
        } else {
            if (C_Tuukasyu.JPY.eq(uiBean.getSiKykSyouhn().getKyktuukasyu())) {
                uiBean.setMikeikapgaitoukkn("");
            } else {
                if (C_SeisankinKanritukaKbn.YENKA.eq(uiBean.getSiSyouhnZokusei().getMikeikapknrtuukakbn())) {
                    uiBean.setMikeikapgaitoukkn("");
                } else {
                    SiCommonMojiretuHensyu siCommonMojiretuHensyu = SWAKInjector.getInstance(SiCommonMojiretuHensyu.class);
                    String pGaitoukknHensyu = siCommonMojiretuHensyu.editPGaitoukkn(
                        uiBean.getSkMax().getMikeikapjyuutouym(),
                        uiBean.getSkMax().getMikeikapjyuutoukaisuuy(),
                        uiBean.getSkMax().getMikeikapjyuutoukaisuum());

                    uiBean.setMikeikapgaitoukkn(pGaitoukknHensyu);
                }
            }
        }

        if (uiBean.getSkMax().getMikeikap().compareTo(BizCurrency.valueOf(0, uiBean.getSkMax().getMikeikap().getType())) == 0) {
            uiBean.setYenkamikeikapgaitoukkn("");
        } else {
            if (C_Tuukasyu.JPY.eq(uiBean.getSiKykSyouhn().getKyktuukasyu()) || C_SeisankinKanritukaKbn.YENKA.eq(uiBean.getSiSyouhnZokusei().getMikeikapknrtuukakbn())) {
                SiCommonMojiretuHensyu siCommonMojiretuHensyu = SWAKInjector.getInstance(SiCommonMojiretuHensyu.class);
                String pGaitoukknHensyu = siCommonMojiretuHensyu.editPGaitoukkn(
                    uiBean.getSkMax().getMikeikapjyuutouym(),
                    uiBean.getSkMax().getMikeikapjyuutoukaisuuy(),
                    uiBean.getSkMax().getMikeikapjyuutoukaisuum());

                uiBean.setYenkamikeikapgaitoukkn(pGaitoukknHensyu);

            } else {
                uiBean.setYenkamikeikapgaitoukkn("");
            }
        }

        if ( uiBean.getSkMax().getMisyuup().compareTo(BizCurrency.valueOf(0, uiBean.getSkMax().getMisyuup().getType())) == 0) {
            uiBean.setMisyuupgaitoukkn("");
            uiBean.setYenkamisyuupgaitoukkn("");
        } else {
            SiCommonMojiretuHensyu siCommonMojiretuHensyu = SWAKInjector.getInstance(SiCommonMojiretuHensyu.class);

            String pGaitoukknHensyu = siCommonMojiretuHensyu.editPGaitoukkn(uiBean.getSkMax().getMisyuupjyuutouym(),
                uiBean.getSkMax().getMisyuupjyuutoukaisuuy(),  uiBean.getSkMax().getMisyuupjyuutoukaisuum());

            if (C_Tuukasyu.JPY.eq(uiBean.getSiKykSyouhn().getKyktuukasyu())) {
                uiBean.setYenkamisyuupgaitoukkn(pGaitoukknHensyu);
            } else {
                uiBean.setMisyuupgaitoukkn(pGaitoukknHensyu);
            }
        }

        if (C_Tuukasyu.JPY.eq(uiBean.getSiKykSyouhn().getKyktuukasyu())) {
            pYenBunkatuKingakuMap.put(YEN_GOUKEI_BUNKATUKEY, uiBean.getBnktmaeyengoukei());
            pYenBunkatuKingakuMap.put(YEN_S_BUNKATUKEY, uiBean.getBnktmaeyenhknkngkguki());
            pYenBunkatuKingakuMap.put(YEN_HAITOU_BUNKATUKEY, uiBean.getBnktmaeyenhaitoukin());
            pYenBunkatuKingakuMap.put(YEN_SONOTAHAITOU_BUNKATUKEY, uiBean.getBnktmaeyensonotahaitoukin());
            pYenBunkatuKingakuMap.put(YEN_MIKEIKAP_BUNKATUKEY, uiBean.getBnktmaeyenmikeikap());
            pYenBunkatuKingakuMap.put(YEN_ZENNOU_BUNKATUKEY, uiBean.getBnktmaeyenznnusisnkgk());
            pYenBunkatuKingakuMap.put(YEN_ZEITEKI_BUNKATUKEY, uiBean.getBnktmaezitkazkrknyen());
            pYenBunkatuKingakuMap.put(YEN_KARIUKE_BUNKATUKEY, uiBean.getBnktmaeyenkrkgk());
            pYenBunkatuKingakuMap.put(YEN_MISYUUP_BUNKATUKEY, uiBean.getBnktmaeyenmisyuup());

        } else {


            pGaikaBunkatuKingakuMap.put(GAIKA_GOUKEI_BUNKATUKEY, uiBean.getBnktmaegaikagoukei());
            pGaikaBunkatuKingakuMap.put(GAIKA_S_BUNKATUKEY, uiBean.getBnktmaehokenkngkgoukei());
            pGaikaBunkatuKingakuMap.put(GAIKA_MIKEIKAP_BUNKATUKEY, uiBean.getBnktmaemikeikap());
            pGaikaBunkatuKingakuMap.put(GAIKA_ZENNOU_BUNKATUKEY, uiBean.getBnktmaeznnusisnkgk());
            pGaikaBunkatuKingakuMap.put(SITEI_ZEITEKI_BUNKATUKEY, uiBean.getBnkatmaezitkazkrknstituka());
            pGaikaBunkatuKingakuMap.put(GAIKA_MISYUUP_BUNKATUKEY, uiBean.getBnktmaemisyuup());


            pYenBunkatuKingakuMap.put(YEN_GOUKEI_BUNKATUKEY, uiBean.getBnktmaeyengoukei());
            pYenBunkatuKingakuMap.put(YEN_S_BUNKATUKEY, BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            pYenBunkatuKingakuMap.put(YEN_HAITOU_BUNKATUKEY, uiBean.getBnktmaeyenhaitoukin());
            pYenBunkatuKingakuMap.put(YEN_SONOTAHAITOU_BUNKATUKEY, uiBean.getBnktmaeyensonotahaitoukin());
            pYenBunkatuKingakuMap.put(YEN_MIKEIKAP_BUNKATUKEY, uiBean.getBnktmaeyenmikeikap());
            pYenBunkatuKingakuMap.put(YEN_ZENNOU_BUNKATUKEY, uiBean.getBnktmaeyenznnusisnkgk());
            pYenBunkatuKingakuMap.put(YEN_ZEITEKI_BUNKATUKEY, uiBean.getBnktmaezitkazkrknyen());
            pYenBunkatuKingakuMap.put(YEN_KARIUKE_BUNKATUKEY, uiBean.getBnktmaeyenkrkgk());
            pYenBunkatuKingakuMap.put(YEN_MISYUUP_BUNKATUKEY, uiBean.getBnktmaeyenmisyuup());
        }

    }


    private void setteiUktrInfo(List<UktrInfoDataSourceBean> uktrInfoList) {

        BunkatuKeisanKekka1DataSourceBean bnkat1 = new BunkatuKeisanKekka1DataSourceBean();
        bnkat1.setShrtaisyou1(uktrInfoList.get(0).getShrtaisyou());
        bnkat1.setUktrjuni1(uktrInfoList.get(0).getUktrjuni());
        bnkat1.setUktrwraibunsi1(uktrInfoList.get(0).getUktrwraibunsi());
        bnkat1.setUktrwraibunbo1(uktrInfoList.get(0).getUktrwraibunbo());
        bnkat1.setBnktsbuktnmkj1(uktrInfoList.get(0).getBnktsbuktnmkj());
        uiBean.setBunkatuKeisanKekka1(new ArrayList<BunkatuKeisanKekka1DataSourceBean>(Arrays.asList(bnkat1)));

        BunkatuKeisanKekka2DataSourceBean bnkat2 = new BunkatuKeisanKekka2DataSourceBean();
        bnkat2.setShrtaisyou2(uktrInfoList.get(1).getShrtaisyou());
        bnkat2.setUktrjuni2(uktrInfoList.get(1).getUktrjuni());
        bnkat2.setUktrwraibunsi2(uktrInfoList.get(1).getUktrwraibunsi());
        bnkat2.setUktrwraibunbo2(uktrInfoList.get(1).getUktrwraibunbo());
        bnkat2.setBnktsbuktnmkj2(uktrInfoList.get(1).getBnktsbuktnmkj());
        uiBean.setBunkatuKeisanKekka2(new ArrayList<BunkatuKeisanKekka2DataSourceBean>(Arrays.asList(bnkat2)));

        BunkatuKeisanKekka3DataSourceBean bnkat3 = new BunkatuKeisanKekka3DataSourceBean();
        bnkat3.setShrtaisyou3(uktrInfoList.get(2).getShrtaisyou());
        bnkat3.setUktrjuni3(uktrInfoList.get(2).getUktrjuni());
        bnkat3.setUktrwraibunsi3(uktrInfoList.get(2).getUktrwraibunsi());
        bnkat3.setUktrwraibunbo3(uktrInfoList.get(2).getUktrwraibunbo());
        bnkat3.setBnktsbuktnmkj3(uktrInfoList.get(2).getBnktsbuktnmkj());
        uiBean.setBunkatuKeisanKekka3(new ArrayList<BunkatuKeisanKekka3DataSourceBean>(Arrays.asList(bnkat3)));

        BunkatuKeisanKekka4DataSourceBean bnkat4 = new BunkatuKeisanKekka4DataSourceBean();
        bnkat4.setShrtaisyou4(uktrInfoList.get(3).getShrtaisyou());
        bnkat4.setUktrjuni4(uktrInfoList.get(3).getUktrjuni());
        bnkat4.setUktrwraibunsi4(uktrInfoList.get(3).getUktrwraibunsi());
        bnkat4.setUktrwraibunbo4(uktrInfoList.get(3).getUktrwraibunbo());
        bnkat4.setBnktsbuktnmkj4(uktrInfoList.get(3).getBnktsbuktnmkj());
        uiBean.setBunkatuKeisanKekka4(new ArrayList<BunkatuKeisanKekka4DataSourceBean>(Arrays.asList(bnkat4)));

        BunkatuKeisanKekka5DataSourceBean bnkat5 = new BunkatuKeisanKekka5DataSourceBean();
        bnkat5.setShrtaisyou5(uktrInfoList.get(4).getShrtaisyou());
        bnkat5.setUktrjuni5(uktrInfoList.get(4).getUktrjuni());
        bnkat5.setUktrwraibunsi5(uktrInfoList.get(4).getUktrwraibunsi());
        bnkat5.setUktrwraibunbo5(uktrInfoList.get(4).getUktrwraibunbo());
        bnkat5.setBnktsbuktnmkj5(uktrInfoList.get(4).getBnktsbuktnmkj());
        uiBean.setBunkatuKeisanKekka5(new ArrayList<BunkatuKeisanKekka5DataSourceBean>(Arrays.asList(bnkat5)));

        BunkatuKeisanKekka6DataSourceBean bnkat6 = new BunkatuKeisanKekka6DataSourceBean();
        bnkat6.setShrtaisyou6(uktrInfoList.get(5).getShrtaisyou());
        bnkat6.setUktrjuni6(uktrInfoList.get(5).getUktrjuni());
        bnkat6.setUktrwraibunsi6(uktrInfoList.get(5).getUktrwraibunsi());
        bnkat6.setUktrwraibunbo6(uktrInfoList.get(5).getUktrwraibunbo());
        bnkat6.setBnktsbuktnmkj6(uktrInfoList.get(5).getBnktsbuktnmkj());
        uiBean.setBunkatuKeisanKekka6(new ArrayList<BunkatuKeisanKekka6DataSourceBean>(Arrays.asList(bnkat6)));

        BunkatuKeisanKekka7DataSourceBean bnkat7 = new BunkatuKeisanKekka7DataSourceBean();
        bnkat7.setShrtaisyou7(uktrInfoList.get(6).getShrtaisyou());
        bnkat7.setUktrjuni7(uktrInfoList.get(6).getUktrjuni());
        bnkat7.setUktrwraibunsi7(uktrInfoList.get(6).getUktrwraibunsi());
        bnkat7.setUktrwraibunbo7(uktrInfoList.get(6).getUktrwraibunbo());
        bnkat7.setBnktsbuktnmkj7(uktrInfoList.get(6).getBnktsbuktnmkj());
        uiBean.setBunkatuKeisanKekka7(new ArrayList<BunkatuKeisanKekka7DataSourceBean>(Arrays.asList(bnkat7)));

        BunkatuKeisanKekka8DataSourceBean bnkat8 = new BunkatuKeisanKekka8DataSourceBean();
        bnkat8.setShrtaisyou8(uktrInfoList.get(7).getShrtaisyou());
        bnkat8.setUktrjuni8(uktrInfoList.get(7).getUktrjuni());
        bnkat8.setUktrwraibunsi8(uktrInfoList.get(7).getUktrwraibunsi());
        bnkat8.setUktrwraibunbo8(uktrInfoList.get(7).getUktrwraibunbo());
        bnkat8.setBnktsbuktnmkj8(uktrInfoList.get(7).getBnktsbuktnmkj());
        uiBean.setBunkatuKeisanKekka8(new ArrayList<BunkatuKeisanKekka8DataSourceBean>(Arrays.asList(bnkat8)));

        BunkatuKeisanKekka9DataSourceBean bnkat9 = new BunkatuKeisanKekka9DataSourceBean();
        bnkat9.setShrtaisyou9(uktrInfoList.get(8).getShrtaisyou());
        bnkat9.setUktrjuni9(uktrInfoList.get(8).getUktrjuni());
        bnkat9.setUktrwraibunsi9(uktrInfoList.get(8).getUktrwraibunsi());
        bnkat9.setUktrwraibunbo9(uktrInfoList.get(8).getUktrwraibunbo());
        bnkat9.setBnktsbuktnmkj9(uktrInfoList.get(8).getBnktsbuktnmkj());
        uiBean.setBunkatuKeisanKekka9(new ArrayList<BunkatuKeisanKekka9DataSourceBean>(Arrays.asList(bnkat9)));

        BunkatuKeisanKekka10DataSourceBean bnkat10 = new BunkatuKeisanKekka10DataSourceBean();
        bnkat10.setShrtaisyou10(uktrInfoList.get(9).getShrtaisyou());
        bnkat10.setUktrjuni10(uktrInfoList.get(9).getUktrjuni());
        bnkat10.setUktrwraibunsi10(uktrInfoList.get(9).getUktrwraibunsi());
        bnkat10.setUktrwraibunbo10(uktrInfoList.get(9).getUktrwraibunbo());
        bnkat10.setBnktsbuktnmkj10(uktrInfoList.get(9).getBnktsbuktnmkj());
        uiBean.setBunkatuKeisanKekka10(new ArrayList<BunkatuKeisanKekka10DataSourceBean>(Arrays.asList(bnkat10)));

        BunkatuKeisanKekka11DataSourceBean bnkat11 = new BunkatuKeisanKekka11DataSourceBean();
        bnkat11.setShrtaisyou11(uktrInfoList.get(10).getShrtaisyou());
        bnkat11.setUktrjuni11(uktrInfoList.get(10).getUktrjuni());
        bnkat11.setUktrwraibunsi11(uktrInfoList.get(10).getUktrwraibunsi());
        bnkat11.setUktrwraibunbo11(uktrInfoList.get(10).getUktrwraibunbo());
        bnkat11.setBnktsbuktnmkj11(uktrInfoList.get(10).getBnktsbuktnmkj());
        uiBean.setBunkatuKeisanKekka11(new ArrayList<BunkatuKeisanKekka11DataSourceBean>(Arrays.asList(bnkat11)));

        BunkatuKeisanKekka12DataSourceBean bnkat12 = new BunkatuKeisanKekka12DataSourceBean();
        bnkat12.setShrtaisyou12(uktrInfoList.get(11).getShrtaisyou());
        bnkat12.setUktrjuni12(uktrInfoList.get(11).getUktrjuni());
        bnkat12.setUktrwraibunsi12(uktrInfoList.get(11).getUktrwraibunsi());
        bnkat12.setUktrwraibunbo12(uktrInfoList.get(11).getUktrwraibunbo());
        bnkat12.setBnktsbuktnmkj12(uktrInfoList.get(11).getBnktsbuktnmkj());
        uiBean.setBunkatuKeisanKekka12(new ArrayList<BunkatuKeisanKekka12DataSourceBean>(Arrays.asList(bnkat12)));

        BunkatuKeisanKekka13DataSourceBean bnkat13 = new BunkatuKeisanKekka13DataSourceBean();
        bnkat13.setShrtaisyou13(uktrInfoList.get(12).getShrtaisyou());
        bnkat13.setUktrjuni13(uktrInfoList.get(12).getUktrjuni());
        bnkat13.setUktrwraibunsi13(uktrInfoList.get(12).getUktrwraibunsi());
        bnkat13.setUktrwraibunbo13(uktrInfoList.get(12).getUktrwraibunbo());
        bnkat13.setBnktsbuktnmkj13(uktrInfoList.get(12).getBnktsbuktnmkj());
        uiBean.setBunkatuKeisanKekka13(new ArrayList<BunkatuKeisanKekka13DataSourceBean>(Arrays.asList(bnkat13)));

        BunkatuKeisanKekka14DataSourceBean bnkat14 = new BunkatuKeisanKekka14DataSourceBean();
        bnkat14.setShrtaisyou14(uktrInfoList.get(13).getShrtaisyou());
        bnkat14.setUktrjuni14(uktrInfoList.get(13).getUktrjuni());
        bnkat14.setUktrwraibunsi14(uktrInfoList.get(13).getUktrwraibunsi());
        bnkat14.setUktrwraibunbo14(uktrInfoList.get(13).getUktrwraibunbo());
        bnkat14.setBnktsbuktnmkj14(uktrInfoList.get(13).getBnktsbuktnmkj());
        uiBean.setBunkatuKeisanKekka14(new ArrayList<BunkatuKeisanKekka14DataSourceBean>(Arrays.asList(bnkat14)));

        BunkatuKeisanKekka15DataSourceBean bnkat15 = new BunkatuKeisanKekka15DataSourceBean();
        bnkat15.setShrtaisyou15(uktrInfoList.get(14).getShrtaisyou());
        bnkat15.setUktrjuni15(uktrInfoList.get(14).getUktrjuni());
        bnkat15.setUktrwraibunsi15(uktrInfoList.get(14).getUktrwraibunsi());
        bnkat15.setUktrwraibunbo15(uktrInfoList.get(14).getUktrwraibunbo());
        bnkat15.setBnktsbuktnmkj15(uktrInfoList.get(14).getBnktsbuktnmkj());
        uiBean.setBunkatuKeisanKekka15(new ArrayList<BunkatuKeisanKekka15DataSourceBean>(Arrays.asList(bnkat15)));

    }
}
