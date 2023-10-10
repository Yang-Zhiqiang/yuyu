package yuyu.app.siharai.simouside.sisiboukariuketuketeisei;

import static yuyu.app.siharai.simouside.sisiboukariuketuketeisei.GenSiSibouKariUketukeTeiseiConstants.*;
import static yuyu.app.siharai.simouside.sisiboukariuketuketeisei.SiSibouKariUketukeTeiseiConstants.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bznayose.BetukutiKeiyakuInfoBean;
import yuyu.common.biz.bznayose.BetukutiKeiyakuInfoGet;
import yuyu.common.biz.bznayose.BetukutiKeiyakuInfoGetParam;
import yuyu.common.biz.bznayose.BetukutiKeiyakuInfoResultBean;
import yuyu.common.siharai.chksk.ChkKekkaBean;
import yuyu.common.siharai.chksk.ChkSubEndtHenkouYmd;
import yuyu.common.siharai.chksk.ChkSubPHrkmYuuyokkn;
import yuyu.common.siharai.chksk.ChkSubSknnKaisiYmd;
import yuyu.common.siharai.chksk.ChkSubTmttknJyoutai;
import yuyu.common.siharai.kyk.KeiyakuInfoSyutoku;
import yuyu.common.siharai.kyk.KeiyakuPrm;
import yuyu.common.siharai.sicommon.SiSetUiBean;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_Huho2kyknoKbn;
import yuyu.def.classification.C_MQSyorikekkaKbn;
import yuyu.def.classification.C_MQSyoukaiErrorKbn;
import yuyu.def.classification.C_NayoseYouhi;
import yuyu.def.classification.C_PalSyoukaiJissiumuKbn;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_SakuintsnTaisyouKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.JM_SiSyouhnZokusei;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.entity.JT_SiKykSyouhn;
import yuyu.def.db.entity.JT_SiUkt;
import yuyu.def.db.entity.JT_SibouKariuketsuke;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.db.entity.JT_TtdkRireki;
import yuyu.def.siharai.manager.SiharaiDomManager;

import com.google.common.collect.Lists;

/**
 * 死亡仮受付訂正 のビジネスロジックです。
 */
public class SiSibouKariUketukeTeiseiBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private SiSibouKariUketukeTeiseiUiBean uiBean;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private MessageManager messageManager;

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

        List<JT_SkKihon> skKihonLst = siharaiDomManager.getSkKihonsBySyonoSeikyuusyubetuTorikesiflg(uiBean.getSyono(),
            C_SeikyuuSyubetu.SBKRUKTK, C_UmuKbn.NONE);

        if (skKihonLst.size() == 0) {
            throw new BizLogicException(MessageId.EBA0024,
                MessageUtil.getMessage(MessageId.IJW1003));
        }

        JT_SkKihon skKihon = skKihonLst.get(0);

        if (BizDateUtil.compareYmd(sysDate, skKihon.getSiboukaritrkymd()) == BizDateUtil.COMPARE_EQUAL) {

            throw new BizLogicException(MessageId.EJA1061);

        }

        uiBean.setSkKihon(skKihon);

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

        List<JM_SiSyouhnZokusei> siSyouhnZokuseiList = siharaiDomManager
            .getSiSyouhnZokuseisBySyouhncdKyhgndkatakbnSyouhnsdno(
                siKykSyouhnSyu.getSyouhncd(), siKykSyouhnSyu.getKyhgndkatakbn(), siKykSyouhnSyu.getSyouhnsdno());

        if (siSyouhnZokuseiList.size() == 0) {
            throw new BizLogicException(MessageId.EBS0006, JM_SiSyouhnZokusei.TABLE_NAME,
                JM_SiSyouhnZokusei.SYOUHNCD, siKykSyouhnSyu.getSyouhncd(),
                JM_SiSyouhnZokusei.KYHGENDONISSUU, siKykSyouhnSyu.getKyhgndkatakbn().getValue(),
                JM_SiSyouhnZokusei.SYOUHNSDNO, String.valueOf(siKykSyouhnSyu.getSyouhnsdno()));
        }

        uiBean.setSiSyouhnZokusei(siSyouhnZokuseiList.get(0));

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

        JT_TtdkRireki ttdkRireki = skKihon.getTtdkRirekis().get(0);

        String bfrtntnm = null;
        AM_User bfrtntUser = baseDomManager.getUser(ttdkRireki.getGyoumuKousinsyaId());
        if (bfrtntUser != null) {
            bfrtntnm = bfrtntUser.getUserNm();

        }

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

        JT_SibouKariuketsuke sibouKariuketsuke = skKihon.getSibouKariuketsuke();

        uiBean.setBfrsibouymd(sibouKariuketsuke.getSibouymd());

        uiBean.setBfrgeninkbn(sibouKariuketsuke.getGeninkbn());

        uiBean.setBfrtntnm(bfrtntnm);

        uiBean.setSibouymd(sibouKariuketsuke.getSibouymd());

        uiBean.setGeninkbn(sibouKariuketsuke.getGeninkbn());

        uiBean.setTntnm(baseUserInfo.getUserNm());

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
            messageManager.addConversationMessageId(KEY_GROUP_MESSAGE, MessageId.WJA1057,
                MessageUtil.getMessage(MessageId.IJW1084));
        }

        if (C_MQSyorikekkaKbn.SEIJYOU.eq(betukutiKeiyakuInfoResultBean.getMqsyorikekkakbn()) &&
            C_PalSyoukaiJissiumuKbn.NONE.eq(betukutiKeiyakuInfoResultBean.getPalsyoukaijissiumukbn())) {
            messageManager.addConversationMessageId(KEY_GROUP_MESSAGE, MessageId.WJA1058,
                MessageUtil.getMessage(MessageId.IJW1084));
        }

        if (C_MQSyoukaiErrorKbn.SYOUKAIERROR.eq(betukutiKeiyakuInfoResultBean.getSakuininfosyoukaierrkbn())) {
            messageManager.addConversationMessageId(KEY_GROUP_MESSAGE, MessageId.WJA1059,
                MessageUtil.getMessage(MessageId.IJW1084));
        }

        if (C_BlnktkumuKbn.ARI.eq(betukutiKeiyakuInfoResultBean.getKykensuutyoukaumu()) ||
            C_BlnktkumuKbn.ARI.eq(betukutiKeiyakuInfoResultBean.getNkkensuutyoukaumu()) ||
            C_BlnktkumuKbn.ARI.eq(betukutiKeiyakuInfoResultBean.getKykmfkensuutyoukaumu()) ||
            C_BlnktkumuKbn.ARI.eq(betukutiKeiyakuInfoResultBean.getNkfkensuutyoukaumu()) ||
            C_BlnktkumuKbn.ARI.eq(betukutiKeiyakuInfoResultBean.getSueokifkensuutyoukaumu())) {
            messageManager.addConversationMessageId(KEY_GROUP_MESSAGE, MessageId.WBA0012);
        }

        return FORWARDNAME_INPUTCONTENTS;
    }

    String kakuninBtnOnClickBL() {

        if (BizDateUtil.compareYmd(uiBean.getSibouymd(), uiBean.getSkKihon().getSiboukaritrkymd()) == BizDateUtil.COMPARE_GREATER) {

            throw new BizLogicException(MessageId.EBA1029,
                MessageUtil.getMessage(DDID_MOUSIDEINFOTEISEIGO_SIBOUYMD.getErrorResourceKey()),
                MessageUtil.getMessage(JT_SkKihon.SIBOUKARITRKYMD));
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
                MessageUtil.getMessage(DDID_MOUSIDEINFOTEISEIGO_SIBOUYMD.getErrorResourceKey()));
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
                            MessageUtil.getMessage(DDID_MOUSIDEINFOTEISEIGO_SIBOUYMD.getErrorResourceKey()),
                            MessageUtil.getMessage(MessageId.IBW1022));
                    }
                }
            }
        }

        List<ChkKekkaBean> chkKekkaBeanEndHenkouLst = Lists.newArrayList();

        if (uiBean.getSiKykSyouhn().getYendthnkymd() != null) {

            ChkSubEndtHenkouYmd chkSubEndtHenkouYmd = SWAKInjector.getInstance(ChkSubEndtHenkouYmd.class);

            chkSubEndtHenkouYmd.exec(uiBean.getSibouymd(), uiBean.getSiKykSyouhn().getYendthnkymd(),
                chkKekkaBeanEndHenkouLst);

            if (chkKekkaBeanEndHenkouLst.size() != 0) {
                throw new BizLogicException(MessageId.EBA1054, MessageUtil.getMessage(MessageId.IJW1091),
                    MessageUtil.getMessage(DDID_MOUSIDEINFOTEISEIGO_SIBOUYMD.getErrorResourceKey()));
            }
        }

        List<ChkKekkaBean> chkKekkaBeanPHrkmYuuyokknLst = Lists.newArrayList();

        ChkSubPHrkmYuuyokkn chkSubPHrkmYuuyokkn = SWAKInjector.getInstance(ChkSubPHrkmYuuyokkn.class);

        chkSubPHrkmYuuyokkn.exec(uiBean.getSibouymd(), uiBean.getSyono(), chkKekkaBeanPHrkmYuuyokknLst);

        if (chkKekkaBeanPHrkmYuuyokknLst.size() != 0) {
            throw new BizLogicException(MessageId.EJA1049,
                MessageUtil.getMessage(DDID_MOUSIDEINFOTEISEIGO_SIBOUYMD.getErrorResourceKey()));
        }

        if (BizDateUtil.compareYmd(uiBean.getSibouymd(), uiBean.getSiKykSyouhn().getKykymd()) == BizDateUtil.COMPARE_LESSER) {
            messageManager.addConversationMessageId(INPUTCONTENTS_GROUP_MESSAGE, MessageId.WJA0046,
                MessageUtil.getMessage(JT_SiKykSyouhn.KYKYMD),
                MessageUtil.getMessage(DDID_MOUSIDEINFOTEISEIGO_SIBOUYMD.getErrorResourceKey()));

        }

        messageManager.addMessageId(MessageId.QBA0001);

        messageManager.addConversationMessageId(INPUTCONTENTS_GROUP_MESSAGE, MessageId.WJA1084);

        return FORWARDNAME_CONFIRM;
    }

    String modoruBtnByInputContentsOnClickBL() {

        messageManager.removeConversationMessage(KEY_GROUP_MESSAGE);

        return FORWARDNAME_INIT;
    }

    @Transactional
    String kakuteiBtnOnClickBL() {
        JT_SkKihon skKihon = uiBean.getSkKihon();
        JT_SibouKariuketsuke sibouKariuketsuke = skKihon.getSibouKariuketsuke();
        JT_TtdkRireki ttdkRireki = skKihon.getTtdkRirekis().get(0);


        skKihon.setGyoumuKousinsyaId(baseUserInfo.getUserId());


        sibouKariuketsuke.setSibouymd(uiBean.getSibouymd());
        sibouKariuketsuke.setGeninkbn(uiBean.getGeninkbn());
        sibouKariuketsuke.setGyoumuKousinsyaId(baseUserInfo.getUserId());

        ttdkRireki.setSyorisosikicd(baseUserInfo.getTmSosikiCd());
        ttdkRireki.setGyoumuKousinsyaId(baseUserInfo.getUserId());

        siharaiDomManager.update(uiBean.getSkKihon());

        messageManager.addMessageId(MessageId.IAC0009);

        return FORWARDNAME_RESULT;
    }

    String modoruBtnByConfirmOnClickBL() {

        messageManager.removeConversationMessage(INPUTCONTENTS_GROUP_MESSAGE);

        return FORWARDNAME_INPUTCONTENTS;
    }

}
