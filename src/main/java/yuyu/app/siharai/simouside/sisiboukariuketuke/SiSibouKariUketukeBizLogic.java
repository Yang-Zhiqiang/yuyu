package yuyu.app.siharai.simouside.sisiboukariuketuke;

import static yuyu.app.siharai.simouside.sisiboukariuketuke.GenSiSibouKariUketukeConstants.*;
import static yuyu.app.siharai.simouside.sisiboukariuketuke.SiSibouKariUketukeConstants.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.SaibanBiz;
import yuyu.common.biz.bznayose.BetukutiKeiyakuInfoBean;
import yuyu.common.biz.bznayose.BetukutiKeiyakuInfoGet;
import yuyu.common.biz.bznayose.BetukutiKeiyakuInfoGetParam;
import yuyu.common.biz.bznayose.BetukutiKeiyakuInfoResultBean;
import yuyu.common.siharai.chksk.CheckSbkrSkNaiyouKekkaBean;
import yuyu.common.siharai.chksk.ChkKekkaBean;
import yuyu.common.siharai.chksk.ChkSubDsKaiykSyori;
import yuyu.common.siharai.chksk.ChkSubEndtHenkouYmd;
import yuyu.common.siharai.chksk.ChkSubHnrkinMbr;
import yuyu.common.siharai.chksk.ChkSubKhSyorityuu;
import yuyu.common.siharai.chksk.ChkSubPHrkmYuuyokkn;
import yuyu.common.siharai.chksk.ChkSubSknnKaisiYmd;
import yuyu.common.siharai.chksk.ChkSubTmttknJyoutai;
import yuyu.common.siharai.chksk.SiSKNaiyouChkkekkaSettei;
import yuyu.common.siharai.edittbl.EditRrk;
import yuyu.common.siharai.edittbl.EditRrkTblBean;
import yuyu.common.siharai.kyk.KeiyakuInfoSyutoku;
import yuyu.common.siharai.kyk.KeiyakuPrm;
import yuyu.common.siharai.sicommon.DouituSyonoStyChk;
import yuyu.common.siharai.sicommon.SiSetUiBean;
import yuyu.common.siharai.sicommon.TeisuuSiharai;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_GeninKbn;
import yuyu.def.classification.C_Huho2kyknoKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_MQSyorikekkaKbn;
import yuyu.def.classification.C_MQSyoukaiErrorKbn;
import yuyu.def.classification.C_NayoseYouhi;
import yuyu.def.classification.C_PalSyoukaiJissiumuKbn;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_SakuintsnTaisyouKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SibouKariUketukeSyoriKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.JM_SiSyouhnZokusei;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.entity.JT_SiKykSyouhn;
import yuyu.def.db.entity.JT_SiUkt;
import yuyu.def.db.entity.JT_SibouKariuketsuke;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.db.entity.JT_TtdkRireki;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.infr.kinoumode.KinouMode;

import com.google.common.collect.Lists;

/**
 * 死亡仮受付 のビジネスロジックです。
 */
public class SiSibouKariUketukeBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private SiSibouKariUketukeUiBean uiBean;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private MessageManager messageManager;

    @Inject
    private KinouMode kinouMode;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private BaseDomManager baseDomManager;

    void init() {
    }

    void clear() {
    }

    String ketteiBtnOnClickBL() {

        BizPropertyInitializer.initialize(uiBean);

        BizDate sysDate = BizDate.getSysDate();

        uiBean.setYouhiKbn(C_YouhiKbn.HUYOU);

        KeiyakuPrm keiyakuPrm = SWAKInjector.getInstance(KeiyakuPrm.class);

        keiyakuPrm.setSyono(uiBean.getSyono());
        keiyakuPrm.setINayoseyh(C_NayoseYouhi.HUYOU);

        KeiyakuInfoSyutoku keiyakuInfoSyutoku = SWAKInjector.getInstance(KeiyakuInfoSyutoku.class);
        keiyakuInfoSyutoku.getInfos(keiyakuPrm);

        List<JT_SiKykKihon> siKykKihonLst = keiyakuInfoSyutoku.getKykKihons();

        if (siKykKihonLst.get(0) == null) {

            throw new BizLogicException(MessageId.EBA0024, MessageUtil.getMessage(MessageId.IJW1001));
        }

        JT_SiKykKihon siKykKihon = siKykKihonLst.get(0);
        uiBean.setSiKykKihon(siKykKihon);

        List<JT_SiKykSyouhn> siKykSyouhnLst = siKykKihon.getSiKykSyouhns();

        JT_SiKykSyouhn siKykSyouhnSyu = new JT_SiKykSyouhn();

        for (JT_SiKykSyouhn siKykSyouhn : siKykSyouhnLst) {
            if (C_SyutkKbn.SYU.eq(siKykSyouhn.getSyutkkbn())) {

                siKykSyouhnSyu = siKykSyouhn;

                uiBean.setSiKykSyouhn(siKykSyouhnSyu);
            }
        }

        List<JM_SiSyouhnZokusei> siSyouhnZokuseiList = siharaiDomManager.getSiSyouhnZokuseisBySyouhncdKyhgndkatakbnSyouhnsdno(
            siKykSyouhnSyu.getSyouhncd(), siKykSyouhnSyu.getKyhgndkatakbn(), siKykSyouhnSyu.getSyouhnsdno());

        if (siSyouhnZokuseiList.size() == 0) {
            throw new BizLogicException(MessageId.EBS0006, JM_SiSyouhnZokusei.TABLE_NAME,
                JM_SiSyouhnZokusei.SYOUHNCD, siKykSyouhnSyu.getSyouhncd(),
                JM_SiSyouhnZokusei.KYHGENDONISSUU, siKykSyouhnSyu.getKyhgndkatakbn().getValue(),
                JM_SiSyouhnZokusei.SYOUHNSDNO, String.valueOf(siKykSyouhnSyu.getSyouhnsdno()));
        }

        uiBean.setSiSyouhnZokusei(siSyouhnZokuseiList.get(0));

        List<JT_SkKihon> skKihonLst = siharaiDomManager.getSkKihonsBySyonoSeikyuusyubetuTorikesiflg(uiBean.getSyono(),
            C_SeikyuuSyubetu.SBKRUKTK, C_UmuKbn.NONE);

        if (C_SibouKariUketukeSyoriKbn.TOUROKU.eq(uiBean.getSiboukariuketukesyorikbn())) {

            if (skKihonLst.size() != 0) {

                throw new BizLogicException(MessageId.EJA0087, MessageUtil.getMessage(MessageId.IJW1002));
            }
        }

        JT_SkKihon skKihon = new JT_SkKihon();

        if (C_SibouKariUketukeSyoriKbn.TORIKESI.eq(uiBean.getSiboukariuketukesyorikbn())) {

            if (skKihonLst.size() == 0) {

                throw new BizLogicException(MessageId.EBA0024,
                    MessageUtil.getMessage(MessageId.IJW1003));
            }

            skKihon = skKihonLst.get(0);

            if (BizDateUtil.compareYmd(sysDate, skKihon.getSiboukaritrkymd()) != BizDateUtil.COMPARE_EQUAL) {
                throw new BizLogicException(MessageId.EJA1005);
            }

            DouituSyonoStyChk douituSyonoStyChk = SWAKInjector.getInstance(DouituSyonoStyChk.class);
            if(!douituSyonoStyChk.exec(uiBean.getSyono(), TeisuuSiharai.JIMUTETUZUKICD_SISIBOU,
                KOUTEIKANRISTATUS_SYORITYUU_KANRYOU)){
                throw new BizLogicException(MessageId.EJA0087, MessageUtil.getMessage(MessageId.IJW1093));
            }
        }

        List<ChkKekkaBean> chkKekkaKhSyoriBeanLst = Lists.newArrayList();

        ChkSubKhSyorityuu chkSubKhSyorityuu = SWAKInjector.getInstance(ChkSubKhSyorityuu.class);

        chkSubKhSyorityuu.exec(siKykKihon, kinou.getKinouId(), chkKekkaKhSyoriBeanLst);

        khSyorityuuChkKekkasettei(chkKekkaKhSyoriBeanLst);

        List<ChkKekkaBean> chkKekkaDsBeanLst = Lists.newArrayList();

        ChkSubDsKaiykSyori chkSubKeiyakusyaHnk = SWAKInjector.getInstance(ChkSubDsKaiykSyori.class);

        chkSubKeiyakusyaHnk.exec(uiBean.getSyono(), chkKekkaDsBeanLst);

        if (chkKekkaDsBeanLst.size() != 0){

            throw new BizLogicException(MessageId.EJA0087,
                MessageUtil.getMessage(MessageId.IJW1090));

        }

        if (C_Kykjyoutai.ZENNOU.eq(siKykKihon.getKykjyoutai())) {

            BizDate jkipjytymd = BizDate.valueOf(siKykKihon.getNexthrkym(), siKykSyouhnSyu.getKykymd().getDay()).getRekijyou();

            if (BizDateUtil.compareYmd(BizDate.getSysDate(), jkipjytymd) == BizDateUtil.COMPARE_GREATER ||
                BizDateUtil.compareYmd(BizDate.getSysDate(), jkipjytymd) == BizDateUtil.COMPARE_EQUAL) {
                throw new BizLogicException(MessageId.EBA1055);
            }
        }

        uiBean.setSkKihon(skKihon);

        BetukutiKeiyakuInfoGetParam betukutiKeiyakuInfoGetParam = SWAKInjector
            .getInstance(BetukutiKeiyakuInfoGetParam.class);

        BetukutiKeiyakuInfoGet betukutiKeiyakuInfoGet = SWAKInjector.getInstance(BetukutiKeiyakuInfoGet.class);

        betukutiKeiyakuInfoGetParam.setHuho2kyknokbn(C_Huho2kyknoKbn.SYONO);
        betukutiKeiyakuInfoGetParam.setHuho2kykno(uiBean.getSyono());
        betukutiKeiyakuInfoGetParam.setSkintsntaisyoukbn(C_SakuintsnTaisyouKbn.HHKN);

        BetukutiKeiyakuInfoResultBean betukutiKeiyakuInfoResultBean = betukutiKeiyakuInfoGet
            .exec(betukutiKeiyakuInfoGetParam);

        List<BetukutiKeiyakuInfoBean> betukutiKeiyakuInfoBeanLst = betukutiKeiyakuInfoResultBean
            .getBetukutiKeiyakuInfoBeanLst();

        uiBean.setKyknmkn(siKykKihon.getKyknmkn());
        uiBean.setKykseiymd(siKykKihon.getKykseiymd());
        uiBean.setKyknmkj(siKykKihon.getKyknmkj());
        uiBean.setKyksei(siKykKihon.getKyksei());

        uiBean.setHhknnmkn(siKykKihon.getHhknnmkn());
        uiBean.setHhknseiymd(siKykKihon.getHhknseiymd());
        uiBean.setHhknnmkj(siKykKihon.getHhknnmkj());
        uiBean.setHhknsei(siKykKihon.getHhknsei());

        List<JT_SiUkt> siUktLst = siKykKihon.getSiUkts();

        SiSetUiBean.setUketorinin(uiBean, siKykKihon, siUktLst);

        if (C_SibouKariUketukeSyoriKbn.TOUROKU.eq(uiBean.getSiboukariuketukesyorikbn())) {
            uiBean.setSibouymd(null);

            uiBean.setGeninkbn(C_GeninKbn.SP);
        }
        else {
            JT_SibouKariuketsuke sibouKariuketsuke = skKihon.getSibouKariuketsuke();

            uiBean.setSibouymd(sibouKariuketsuke.getSibouymd());

            uiBean.setGeninkbn(sibouKariuketsuke.getGeninkbn());
        }

        List<BetukykInfoDataSourceBean> betukeiyakuInfoDataSourceBeanLst = Lists.newArrayList();

        BetukykInfoDataSourceBean betukeiyakuInfoDataSourceBean = null;

        for (BetukutiKeiyakuInfoBean dataSourceBean : betukutiKeiyakuInfoBeanLst) {
            betukeiyakuInfoDataSourceBean = SWAKInjector.getInstance(BetukykInfoDataSourceBean.class);
            betukeiyakuInfoDataSourceBean.setBtkyksyono(dataSourceBean.getBtkyksyono());
            betukeiyakuInfoDataSourceBean.setSyscdkbn(dataSourceBean.getSyscdkbn());
            betukeiyakuInfoDataSourceBean.setBetukutikeiyakukbn(dataSourceBean.getBetukutikeiyakukbn());
            betukeiyakuInfoDataSourceBean.setKankeisyakbnname(dataSourceBean.getKankeisyakbnname());
            betukeiyakuInfoDataSourceBean.setSyoumetuymd(dataSourceBean.getSyoumetuymd());
            betukeiyakuInfoDataSourceBean.setSyoumetujiyuuname(dataSourceBean.getSyoumetujiyuuname());
            betukeiyakuInfoDataSourceBean.setSyouhnnm(dataSourceBean.getSyouhnnm());

            betukeiyakuInfoDataSourceBeanLst.add(betukeiyakuInfoDataSourceBean);
        }

        uiBean.setBetukykInfo(betukeiyakuInfoDataSourceBeanLst);

        if (C_MQSyorikekkaKbn.ERROR.eq(betukutiKeiyakuInfoResultBean.getMqsyorikekkakbn())) {
            messageManager.addConversationMessageId(KEY_GROUP_MESSAGE, MessageId.WJA1057, MessageUtil.getMessage(MessageId.IJW1084));
        }

        if (C_MQSyorikekkaKbn.SEIJYOU.eq(betukutiKeiyakuInfoResultBean.getMqsyorikekkakbn()) &&
            C_PalSyoukaiJissiumuKbn.NONE.eq(betukutiKeiyakuInfoResultBean.getPalsyoukaijissiumukbn())) {
            messageManager.addConversationMessageId(KEY_GROUP_MESSAGE, MessageId.WJA1058, MessageUtil.getMessage(MessageId.IJW1084));
        }

        if (C_MQSyoukaiErrorKbn.SYOUKAIERROR.eq(betukutiKeiyakuInfoResultBean.getSakuininfosyoukaierrkbn())) {
            messageManager.addConversationMessageId(KEY_GROUP_MESSAGE, MessageId.WJA1059, MessageUtil.getMessage(MessageId.IJW1084));
        }

        if (C_BlnktkumuKbn.ARI.eq(betukutiKeiyakuInfoResultBean.getKykensuutyoukaumu()) ||
            C_BlnktkumuKbn.ARI.eq(betukutiKeiyakuInfoResultBean.getNkkensuutyoukaumu()) ||
            C_BlnktkumuKbn.ARI.eq(betukutiKeiyakuInfoResultBean.getKykmfkensuutyoukaumu()) ||
            C_BlnktkumuKbn.ARI.eq(betukutiKeiyakuInfoResultBean.getNkfkensuutyoukaumu()) ||
            C_BlnktkumuKbn.ARI.eq(betukutiKeiyakuInfoResultBean.getSueokifkensuutyoukaumu())) {
            messageManager.addConversationMessageId(KEY_GROUP_MESSAGE, MessageId.WBA0012);
        }

        List<ChkKekkaBean> chkKekkaHrnBeanLst = Lists.newArrayList();

        if (siKykSyouhnSyu.getYendthnkymd() != null){
            ChkSubHnrkinMbr chkSubHnrkinMbr = SWAKInjector.getInstance(ChkSubHnrkinMbr.class);

            chkSubHnrkinMbr.exec(siKykKihon, chkKekkaHrnBeanLst);
        }

        if (chkKekkaHrnBeanLst.size() != 0){
            if (C_SKNaiyouChkKbn.HRMBRCHECK_KEIUKEDOU_CHK.eq(chkKekkaHrnBeanLst.get(0).getSKNaiyouChkKbn())){
                messageManager.addConversationMessageId(KEY_GROUP_MESSAGE, MessageId.WJA1062);
            }

            if (C_SKNaiyouChkKbn.HRMBRCHECK_KEIUKEBETU_CHK.eq(chkKekkaHrnBeanLst.get(0).getSKNaiyouChkKbn())){
                messageManager.addConversationMessageId(KEY_GROUP_MESSAGE, MessageId.WJA1063);
            }

        }

        return FORWARDNAME_INPUTCONTENTS;
    }

    String kakuninBtnOnClickBL() {

        BizDate sysDate = BizDate.getSysDate();

        if (BizDateUtil.compareYmd(uiBean.getSibouymd(), sysDate) == BizDateUtil.COMPARE_GREATER) {

            throw new BizLogicException(MessageId.EBF0124, MessageUtil.getMessage(DDID_MOUSIDEINFO_SIBOUYMD
                .getErrorResourceKey()));
        }

        JT_SiKykKihon siKykKihon = uiBean.getSiKykKihon();

        C_YuukousyoumetuKbn yuukousyoumetukbn = siKykKihon.getYuukousyoumetukbn();

        if (!C_YuukousyoumetuKbn.YUUKOU.eq(yuukousyoumetukbn)) {

            BizDate syometuYmd = siKykKihon.getSyoumetuymd();

            if (BizDateUtil.compareYmd(syometuYmd, uiBean.getSibouymd()) == BizDateUtil.COMPARE_LESSER) {

                throw new BizLogicException(MessageId.EJA0090);
            }

            messageManager.addConversationMessageId(INPUTCONTENTS_GROUP_MESSAGE, MessageId.WJA0024);
        }

        List<ChkKekkaBean> chkKekkaBeanLst = Lists.newArrayList();

        JT_SiKykSyouhn siKykSyouhnSyu = uiBean.getSiKykSyouhn();

        ChkSubSknnKaisiYmd chkSubSknnKaisiYmd = SWAKInjector.getInstance(ChkSubSknnKaisiYmd.class);

        chkSubSknnKaisiYmd.exec(uiBean.getSibouymd(), siKykKihon.getHksknnkaisiymd(),
            siKykSyouhnSyu, chkKekkaBeanLst);

        if (chkKekkaBeanLst.size() != 0) {

            throw new BizLogicException(MessageId.EJA0076, MessageUtil.getMessage(JT_SiKykSyouhn.SKNNKAISIYMD),
                MessageUtil.getMessage(DDID_MOUSIDEINFO_SIBOUYMD.getErrorResourceKey()));
        }

        if (C_UmuKbn.ARI.eq(uiBean.getSiSyouhnZokusei().getKyuuhu().getTmttknjyoutaicheck())) {

            List<ChkKekkaBean> chkKekkaBeanTmttLst = Lists.newArrayList();

            ChkSubTmttknJyoutai chkSubTmttknJyoutai = SWAKInjector.getInstance(ChkSubTmttknJyoutai.class);

            chkSubTmttknJyoutai.exec(uiBean.getSibouymd(), uiBean.getSyono(), siKykSyouhnSyu.getKykymd(),
                siKykSyouhnSyu.getTmttknitenymd(), chkKekkaBeanTmttLst);

            if (chkKekkaBeanTmttLst.size() != 0) {

                for (ChkKekkaBean chkTmttBean : chkKekkaBeanTmttLst) {

                    if (C_SKNaiyouChkKbn.TMTTKIN_MIHANEI_CHK.eq(chkTmttBean.getSKNaiyouChkKbn())) {

                        throw new BizLogicException(MessageId.EBA1052);
                    }

                    if (C_SKNaiyouChkKbn.TMTTKIN_ITENBI_CHK.eq(chkTmttBean.getSKNaiyouChkKbn())) {

                        throw new BizLogicException(MessageId.EBA1053,
                            MessageUtil.getMessage(DDID_MOUSIDEINFO_SIBOUYMD.getErrorResourceKey()),
                            MessageUtil.getMessage(MessageId.IBW1022));
                    }
                }
            }
        }

        List<ChkKekkaBean> chkKekkaBeanEndHenkouLst = Lists.newArrayList();

        if (uiBean.getSiKykSyouhn().getYendthnkymd() != null){

            ChkSubEndtHenkouYmd chkSubEndtHenkouYmd = SWAKInjector.getInstance(ChkSubEndtHenkouYmd.class);

            chkSubEndtHenkouYmd.exec(uiBean.getSibouymd(), uiBean.getSiKykSyouhn().getYendthnkymd(),chkKekkaBeanEndHenkouLst);

            if (chkKekkaBeanEndHenkouLst.size() != 0){
                throw new BizLogicException(MessageId.EBA1054, MessageUtil.getMessage(MessageId.IJW1091),
                    MessageUtil.getMessage(DDID_MOUSIDEINFO_SIBOUYMD.getErrorResourceKey()));
            }
        }

        List<ChkKekkaBean> chkKekkaBeanPHrkmYuuyokknLst = Lists.newArrayList();

        ChkSubPHrkmYuuyokkn chkSubPHrkmYuuyokkn = SWAKInjector.getInstance(ChkSubPHrkmYuuyokkn.class);

        chkSubPHrkmYuuyokkn.exec(uiBean.getSibouymd(), uiBean.getSyono(),chkKekkaBeanPHrkmYuuyokknLst);

        if (chkKekkaBeanPHrkmYuuyokknLst.size() != 0){
            throw new BizLogicException(MessageId.EJA1049,
                MessageUtil.getMessage(DDID_MOUSIDEINFO_SIBOUYMD.getErrorResourceKey()));
        }


        if (BizDateUtil.compareYmd(uiBean.getSibouymd(), uiBean.getSiKykSyouhn().getKykymd()) == BizDateUtil.COMPARE_LESSER){
            messageManager.addConversationMessageId(INPUTCONTENTS_GROUP_MESSAGE, MessageId.WJA0046,
                MessageUtil.getMessage(JT_SiKykSyouhn.KYKYMD),
                MessageUtil.getMessage(DDID_MOUSIDEINFO_SIBOUYMD.getErrorResourceKey()));

        }

        messageManager.addMessageId(MessageId.QBA0001);

        return FORWARDNAME_CONFIRM;
    }

    String modoruBtnByInputContentsOnClickBL() {

        messageManager.removeConversationMessage(KEY_GROUP_MESSAGE);

        return FORWARDNAME_INIT;
    }

    @Transactional
    String kakuteiBtnOnClickBL() {

        List<ChkKekkaBean> chkKekkaKhSyoriBeanLst = Lists.newArrayList();

        ChkSubKhSyorityuu chkSubKhSyorityuu = SWAKInjector.getInstance(ChkSubKhSyorityuu.class);

        JT_SiKykKihon siKykKihon = uiBean.getSiKykKihon();

        chkSubKhSyorityuu.exec(siKykKihon, kinou.getKinouId(), chkKekkaKhSyoriBeanLst);

        khSyorityuuChkKekkasettei(chkKekkaKhSyoriBeanLst);

        List<ChkKekkaBean> chkKekkaDsBeanLst = Lists.newArrayList();

        ChkSubDsKaiykSyori chkSubKeiyakusyaHnk = SWAKInjector.getInstance(ChkSubDsKaiykSyori.class);

        chkSubKeiyakusyaHnk.exec(uiBean.getSyono(), chkKekkaDsBeanLst);

        if (chkKekkaDsBeanLst.size() != 0){

            throw new BizLogicException(MessageId.EJA0087,
                MessageUtil.getMessage(MessageId.IJW1090));

        }

        BizDate sysDate = BizDate.getSysDate();

        String sSysTime = BizDate.getSysDateTimeMilli();

        if (C_SibouKariUketukeSyoriKbn.TOUROKU.eq(uiBean.getSiboukariuketukesyorikbn())) {

            List<JT_SkKihon> skKihonLst = siharaiDomManager.getSkKihonsBySyonoSeikyuusyubetuTorikesiflg(uiBean.getSyono(),
                C_SeikyuuSyubetu.SBKRUKTK, C_UmuKbn.NONE);

            if (skKihonLst.size() != 0) {

                throw new BizLogicException(MessageId.EJA0087, MessageUtil.getMessage(MessageId.IJW1002));
            }

        }

        if(C_SibouKariUketukeSyoriKbn.TORIKESI.eq(uiBean.getSiboukariuketukesyorikbn())){
            DouituSyonoStyChk douituSyonoStyChk = SWAKInjector.getInstance(DouituSyonoStyChk.class);
            if(!douituSyonoStyChk.exec(uiBean.getSyono(), TeisuuSiharai.JIMUTETUZUKICD_SISIBOU,
                KOUTEIKANRISTATUS_SYORITYUU_KANRYOU)){
                throw new BizLogicException(MessageId.EJA0087, MessageUtil.getMessage(MessageId.IJW1093));
            }
        }

        if (C_SibouKariUketukeSyoriKbn.TOUROKU.eq(uiBean.getSiboukariuketukesyorikbn())) {

            String sSeikyuBangou  = SaibanBiz.getSeikyuBangou();

            JT_SkKihon skKihon = new JT_SkKihon();
            skKihon.setSkno(sSeikyuBangou);
            skKihon.setSyono(uiBean.getSyono());
            skKihon.setSeikyuusyubetu(C_SeikyuuSyubetu.SBKRUKTK);
            skKihon.setSiboukaritrkymd(sysDate);
            skKihon.setKyknmkj(uiBean.getKyknmkj());
            skKihon.setKyknmkn(uiBean.getKyknmkn());
            skKihon.setKykseiymd(uiBean.getKykseiymd());
            skKihon.setKyksei(uiBean.getKyksei());
            skKihon.setHhknnmkj(uiBean.getHhknnmkj());
            skKihon.setHhknnmkn(uiBean.getHhknnmkn());
            skKihon.setHhknseiymd(uiBean.getHhknseiymd());
            skKihon.setHhknsei(uiBean.getHhknsei());
            skKihon.setKossyoricd(kinou.getKinouId());
            skKihon.setKossyorisscd(kinouMode.getKinouMode());
            skKihon.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            skKihon.setGyoumuKousinTime(sSysTime);

            BizPropertyInitializer.initialize(skKihon);

            JT_SibouKariuketsuke sibouKariuketsuke = skKihon.createSibouKariuketsuke();

            sibouKariuketsuke.setSibouymd(uiBean.getSibouymd());
            sibouKariuketsuke.setGeninkbn(uiBean.getGeninkbn());
            sibouKariuketsuke.setTorikesiflg(C_UmuKbn.NONE);
            sibouKariuketsuke.setKossyoricd(kinou.getKinouId());
            sibouKariuketsuke.setKossyorisscd(kinouMode.getKinouMode());
            sibouKariuketsuke.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            sibouKariuketsuke.setGyoumuKousinTime(sSysTime);

            BizPropertyInitializer.initialize(sibouKariuketsuke);

            ttdkRirekiUp(skKihon,sysDate,sSeikyuBangou);

            siharaiDomManager.insert(skKihon);

        }

        else if (C_SibouKariUketukeSyoriKbn.TORIKESI.eq(uiBean.getSiboukariuketukesyorikbn())) {

            uiBean.getSkKihon().setKossyoricd(kinou.getKinouId());
            uiBean.getSkKihon().setKossyorisscd(kinouMode.getKinouMode());
            uiBean.getSkKihon().setGyoumuKousinsyaId(baseUserInfo.getUserId());
            uiBean.getSkKihon().setGyoumuKousinTime(sSysTime);

            JT_SibouKariuketsuke sibouKariuketsuke = uiBean.getSkKihon().getSibouKariuketsuke();
            sibouKariuketsuke.setTorikesiflg(C_UmuKbn.ARI);
            sibouKariuketsuke.setKossyoricd(kinou.getKinouId());
            sibouKariuketsuke.setKossyorisscd(kinouMode.getKinouMode());
            sibouKariuketsuke.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            sibouKariuketsuke.setGyoumuKousinTime(sSysTime);

            ttdkRirekiUp(uiBean.getSkKihon(),sysDate,null);

            siharaiDomManager.update(uiBean.getSkKihon());
        }

        messageManager.addMessageId(MessageId.IAC0009);

        return FORWARDNAME_RESULT;
    }

    String modoruBtnByConfirmOnClickBL() {

        messageManager.removeConversationMessage(INPUTCONTENTS_GROUP_MESSAGE);

        return FORWARDNAME_INPUTCONTENTS;
    }

    String fromSiTtzkRirekiSyoukaiBL() {

        BizPropertyInitializer.initialize(uiBean);

        JT_SkKihon skKihon = siharaiDomManager.getSkKihon(uiBean.getSiTtzkRirekiSyoukaiUiBean().getSkno(), uiBean
            .getSiTtzkRirekiSyoukaiUiBean().getSyono());

        JT_SibouKariuketsuke sibouKariuketsuke = skKihon.getSibouKariuketsuke();

        uiBean.setSyono(uiBean.getSiTtzkRirekiSyoukaiUiBean().getSyono());
        uiBean.setSibouymd(sibouKariuketsuke.getSibouymd());
        uiBean.setGeninkbn(sibouKariuketsuke.getGeninkbn());
        uiBean.setSiboukariuketukesyorikbn(uiBean.getSiTtzkRirekiSyoukaiUiBean().getSibouKariUketukeSyoriKbn());

        uiBean.setYouhiKbn(C_YouhiKbn.YOU);

        AS_Kinou kinous = baseDomManager.getKinou(TeisuuSiharai.SITTZKRIREKISYOUKAI);

        String sKinouNm = kinous.getKinouNm();

        uiBean.setKinouNm(sKinouNm);

        return FORWARDNAME_CONFIRM;
    }


    private void ttdkRirekiUp(JT_SkKihon pSkKihon,BizDate pSysDate,String pSeikyuBangou) {


        EditRrkTblBean editRrkTblBean = SWAKInjector.getInstance(EditRrkTblBean.class);

        if (C_SibouKariUketukeSyoriKbn.TOUROKU.eq(uiBean.getSiboukariuketukesyorikbn())) {

            editRrkTblBean.setSeiNo(pSeikyuBangou);
            editRrkTblBean.setSyoNo(uiBean.getSyono());
            editRrkTblBean.setSyoriYmd(pSysDate);
        }

        else {

            editRrkTblBean.setSeiNo(uiBean.getSkKihon().getSkno());
            editRrkTblBean.setSyoNo(uiBean.getSkKihon().getSyono());
            editRrkTblBean.setSyoriYmd(pSysDate);
        }

        EditRrk editRrk = SWAKInjector.getInstance(EditRrk.class);

        editRrkTblBean = editRrk.makeTtdkRrk(uiBean, editRrkTblBean);

        JT_TtdkRireki ttdkRireki = pSkKihon.createTtdkRireki();

        BeanUtil.copyProperties(ttdkRireki, editRrkTblBean.getTtdkRireki());

        BizPropertyInitializer.initialize(ttdkRireki);
    }

    private void khSyorityuuChkKekkasettei(List<ChkKekkaBean> pChkKekkaKhSyoriBeanLst){

        if (pChkKekkaKhSyoriBeanLst.size() != 0) {

            CheckSbkrSkNaiyouKekkaBean checkSbkrSkNaiyouKekkaBean = SWAKInjector.getInstance(CheckSbkrSkNaiyouKekkaBean.class);
            SiSKNaiyouChkkekkaSettei siSKNaiyouChkkekkaSettei = SWAKInjector.getInstance(SiSKNaiyouChkkekkaSettei.class);

            siSKNaiyouChkkekkaSettei.exec(C_SeikyuuSyubetu.SBKRUKTK,
                kinou.getKinouId(), null, null, null, checkSbkrSkNaiyouKekkaBean, null,pChkKekkaKhSyoriBeanLst);

            if (checkSbkrSkNaiyouKekkaBean.getSbkrSeikyuuNaiyouChkKekkaError().getMessages().size() != 0) {
                throw new BizLogicException(checkSbkrSkNaiyouKekkaBean.getSbkrSeikyuuNaiyouChkKekkaError());
            }
        }

    }
}
