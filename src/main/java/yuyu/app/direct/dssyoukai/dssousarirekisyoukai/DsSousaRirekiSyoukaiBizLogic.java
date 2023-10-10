package yuyu.app.direct.dssyoukai.dssousarirekisyoukai;

import static yuyu.app.direct.dssyoukai.dssousarirekisyoukai.DsSousaRirekiSyoukaiConstants.*;
import static yuyu.app.direct.dssyoukai.dssousarirekisyoukai.GenDsSousaRirekiSyoukaiConstants.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateConfig;
import jp.co.slcs.swak.date.BizDateFormat;
import jp.co.slcs.swak.date.BizDateFormat.FillStyle;
import jp.co.slcs.swak.date.SeirekiWarekiKbn;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.app.direct.dssyoukai.dssousarirekisyoukai.dba.DsSousaRirekiSyoukaiDao;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.direct.dscommon.DsTimeUtil;
import yuyu.common.direct.dscommon.HourMinSecChangeBean;
import yuyu.def.MessageId;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_DsSyoriNaiyouKbn;
import yuyu.def.classification.C_SousaRirekiJkKbn;
import yuyu.def.classification.C_TtdkKekkaKbn;
import yuyu.def.classification.C_TtdkKinouKbn;
import yuyu.def.db.entity.MT_SousaRireki;
import yuyu.def.db.entity.MT_SousaRirekiIvrInfo;
import yuyu.def.db.entity.MT_SousaRirekiSyousai;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;

/**
 * 操作履歴照会 のビジネスロジックです。
 */
public class DsSousaRirekiSyoukaiBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private DsSousaRirekiSyoukaiUiBean uiBean;

    @Inject
    private DsSousaRirekiSyoukaiDao dsSousaRirekiSyoukaiDao;

    @Inject
    private MessageManager messageManager;

    void init() {
        BizPropertyInitializer.initialize(uiBean);

        uiBean.setTtdkymdfrom(BizDate.getSysDate());
        uiBean.setTtdkymdto(BizDate.getSysDate());
    }

    void clear() {
    }

    void pushSearchBtnBL() {

        uiBean.setKensakukekka(null);
        uiBean.setSousarirekisyousaiInfo(null);
        uiBean.setSousaRirekiSyousaiInfoHyoujiFlg(false);

        if (uiBean.getTtdkymdfrom() == null && uiBean.getTtdkymdto() == null &&
            BizUtil.isBlank(uiBean.getTtdkstarttimefrom()) && BizUtil.isBlank(uiBean.getTtdkstarttimeto()) &&
            BizUtil.isBlank(uiBean.getSyono()) && !uiBean.getSyonomisetteikensaku() &&
            C_SousaRirekiJkKbn.BLNK.eq(uiBean.getSousarirekijkkbn()) && C_TtdkKekkaKbn.BLNK.eq(uiBean.getSousarirekikekkakbn())) {

            throw new BizLogicException(MessageId.EMC1005);
        }

        if (uiBean.getTtdkymdfrom() != null && uiBean.getTtdkymdto() != null &&
            BizDateUtil.compareYmd(uiBean.getTtdkymdfrom(), uiBean.getTtdkymdto()) == BizDateUtil.COMPARE_GREATER) {

            throw new BizLogicException(MessageId.EAC0005,
                new Item[] {DDID_KENSAKUZYOUKEN_TTDKYMDFROM, DDID_KENSAKUZYOUKEN_TTDKYMDTO });
        }

        if (uiBean.getTtdkymdfrom() != null &&
            BizDateUtil.compareYmd(uiBean.getTtdkymdfrom(), BizDate.getSysDate()) == BizDateUtil.COMPARE_GREATER) {

            throw new BizLogicException(MessageId.EMA1007,
                new Item[] {DDID_KENSAKUZYOUKEN_TTDKYMDFROM });
        }

        if (!BizUtil.isBlank(uiBean.getTtdkstarttimefrom()) && !BizUtil.isBlank(uiBean.getTtdkstarttimeto()) &&
            uiBean.getTtdkstarttimefrom().compareTo(uiBean.getTtdkstarttimeto()) > 0) {

            throw new BizLogicException(MessageId.EAC0005,
                new Item[] {DDID_KENSAKUZYOUKEN_TTDKSTARTTIMEFROM, DDID_KENSAKUZYOUKEN_TTDKSTARTTIMETO });
        }

        if (!BizUtil.isBlank(uiBean.getSyono()) && uiBean.getSyonomisetteikensaku()) {

            throw new BizLogicException(MessageId.EMF1025);
        }

        List<MT_SousaRireki> sousaRirekiList = dsSousaRirekiSyoukaiDao.getSousaRirekiByKensakuJyouken(
            uiBean.getTtdkymdfrom(),
            uiBean.getTtdkymdto(),
            uiBean.getTtdkstarttimefrom(),
            uiBean.getTtdkstarttimeto(),
            uiBean.getSyono(),
            uiBean.getSyonomisetteikensaku(),
            C_TtdkKinouKbn.DENWAKAIYAKUUKETUKE,
            uiBean.getSousarirekijkkbn(),
            uiBean.getSousarirekikekkakbn());

        if (sousaRirekiList.size() == 0) {

            messageManager.addMessageId(MessageId.IAC0023);

            return;
        }

        int searchResultMaxCnt = YuyuBizConfig.getInstance().getSearchResultMaxCnt();

        if (sousaRirekiList.size() > searchResultMaxCnt) {

            messageManager.addMessageId(MessageId.IBA0019, String.valueOf(searchResultMaxCnt));

            for (int n = sousaRirekiList.size() - 1; sousaRirekiList.size() > searchResultMaxCnt; n--) {

                sousaRirekiList.remove(n);
            }
        }

        List<KensakukekkaDataSourceBean> kensakukekkaDSBeanList = Lists.newArrayList();

        for (MT_SousaRireki sousaRireki : sousaRirekiList) {

            KensakukekkaDataSourceBean KensakukekkaDSBean = SWAKInjector.getInstance(KensakukekkaDataSourceBean.class);

            KensakukekkaDSBean.setTtdkstartymd(sousaRireki.getTtdkstartymd());
            KensakukekkaDSBean.setTtdkstarttime(editHms(sousaRireki.getTtdkstarttime()));
            KensakukekkaDSBean.setTtdkendymd(sousaRireki.getTtdkendymd());
            KensakukekkaDSBean.setTtdkendtime(editHms(sousaRireki.getTtdkendtime()));
            KensakukekkaDSBean.setDispsyono(sousaRireki.getSyono());
            KensakukekkaDSBean.setTtdkkinoukbn(sousaRireki.getTtdkkinoukbn());
            KensakukekkaDSBean.setDispsousarirekijkkbn(sousaRireki.getSousarirekijkkbn());
            KensakukekkaDSBean.setDispsousarirekikekkakbn(sousaRireki.getSousarirekikekkakbn());
            KensakukekkaDSBean.setSyousaiLink(HYOUZIYOUNM_SYOUSAI);
            KensakukekkaDSBean.setTtdksikibetuid(sousaRireki.getTtdksikibetuid());

            kensakukekkaDSBeanList.add(KensakukekkaDSBean);
        }

        uiBean.setKensakukekka(kensakukekkaDSBeanList);
    }

    void pushClearBtnBL() {

        uiBean.setKensakukekka(null);
        uiBean.setSousarirekisyousaiInfo(null);
        uiBean.setSousaRirekiSyousaiInfoHyoujiFlg(false);
        uiBean.setTtdkymdfrom(null);
        uiBean.setTtdkymdto(null);
        uiBean.setTtdkstarttimefrom("");
        uiBean.setTtdkstarttimeto("");
        uiBean.setSyono("");
        uiBean.setSyonomisetteikensaku(false);
        uiBean.setSousarirekijkkbn(C_SousaRirekiJkKbn.BLNK);
        uiBean.setSousarirekikekkakbn(C_TtdkKekkaKbn.BLNK);
    }

    void pushSyoukaiLinkBL() {

        uiBean.setSousarirekisyousaiInfo(null);
        String patternDsSyorNaiyKbn = "";

        String ttdksikibetuid = uiBean.getKensakukekkaDataSource().getSelectedBean().getTtdksikibetuid();

        List<MT_SousaRirekiSyousai> sousaRirekiSysList =
            dsSousaRirekiSyoukaiDao.getSousaRirekiSyousaiByTtdkSikibetuId(ttdksikibetuid);

        MT_SousaRireki sousaRireki = sousaRirekiSysList.get(0).getSousaRireki();
        MT_SousaRirekiIvrInfo sousaRirekiIvrInfo = sousaRireki.getSousaRirekiIvrInfo();

        if (C_TtdkKinouKbn.DENWAKAIYAKUUKETUKE.eq(sousaRireki.getTtdkkinoukbn()) ) {

            patternDsSyorNaiyKbn = C_DsSyoriNaiyouKbn.PATTERN_DENWAKAIYAKU;
        }
        else {
            throw new CommonBizAppException("存在しない手続機能区分です。");
        }

        uiBean.setSousaRirekiSyousaiInfoHyoujiFlg(true);
        List<SousarirekisyousaiInfoDataSourceBean> sousaRirekiSyousaiList = Lists.newArrayList();

        for (MT_SousaRirekiSyousai sousaRirekiSyousai : sousaRirekiSysList) {

            SousarirekisyousaiInfoDataSourceBean sousarirekisysInfoDSBean =
                SWAKInjector.getInstance(SousarirekisyousaiInfoDataSourceBean.class);

            sousarirekisysInfoDSBean.setPatternDsSyoriNaiyouKbn(patternDsSyorNaiyKbn);
            sousarirekisysInfoDSBean.setSyorinaiyoukbn(sousaRirekiSyousai.getSyorinaiyoukbn());
            sousarirekisysInfoDSBean.setSyoriendymd(sousaRirekiSyousai.getSyoriendymd());
            sousarirekisysInfoDSBean.setSyoriendtime(editHms(sousaRirekiSyousai.getSyoriendtime()));
            sousarirekisysInfoDSBean.setSyorisyousai(sousaRirekiSyousai.getSyorisyousai());

            sousaRirekiSyousaiList.add(sousarirekisysInfoDSBean);
        }

        String tetuzukikekkaMsg = "";

        if (C_SousaRirekiJkKbn.TETUZUKITYUU.eq(sousaRireki.getSousarirekijkkbn())) {

            tetuzukikekkaMsg = MessageUtil.getMessage(MessageId.IMF1019);
        }
        else {
            if (C_SousaRirekiJkKbn.END.eq(sousaRireki.getSousarirekijkkbn()) &&
                C_TtdkKekkaKbn.TETUDUKIKANRYOU.eq(sousaRireki.getSousarirekikekkakbn())) {

                tetuzukikekkaMsg = MessageUtil.getMessage(MessageId.IMF1020);
            }
            else {
                tetuzukikekkaMsg = MessageUtil.getMessage(MessageId.IMF1021);
            }
        }

        tetuzukikekkaMsg = MessageUtil.getMessage(
            MessageId.IMF1022,
            tetuzukikekkaMsg,
            sousaRireki.getSyono(),
            sousaRireki.getDskokno(),
            sousaRireki.getTtdkkinoukbn().getContent(),
            sousaRireki.getSousarirekijkkbn().getContent(),
            sousaRireki.getSousarirekikekkakbn().getContent(),
            sousaRireki.getTtdksikibetuid());

        SousarirekisyousaiInfoDataSourceBean sousarirekiTtzukkekkaBean = SWAKInjector.getInstance(
            SousarirekisyousaiInfoDataSourceBean.class);

        sousarirekiTtzukkekkaBean.setSyorinaiyoukbn(C_DsSyoriNaiyouKbn.TETUZUKIKEKKA);
        sousarirekiTtzukkekkaBean.setSyoriendymd(null);
        sousarirekiTtzukkekkaBean.setSyoriendtime("");
        sousarirekiTtzukkekkaBean.setSyorisyousai(tetuzukikekkaMsg);

        sousaRirekiSyousaiList.add(sousarirekiTtzukkekkaBean);

        if (sousaRirekiIvrInfo != null) {

            String ivrInfoMsg = "";

            DsTimeUtil dsTimeUtil = SWAKInjector.getInstance(DsTimeUtil.class);
            HourMinSecChangeBean hourMinSecChangeBean = dsTimeUtil.hourMinSecChange(Integer.valueOf(
                sousaRirekiIvrInfo.getTuuwatime()));

            ivrInfoMsg = MessageUtil.getMessage(
                MessageId.IMF1023,
                sousaRirekiIvrInfo.getDsgyoumucd().getContent(),
                sousaRirekiIvrInfo.getSyorinaiyoukbn().getContent(patternDsSyorNaiyKbn),
                editDateYmdHms(sousaRirekiIvrInfo.getTyakusinymd()),
                sousaRirekiIvrInfo.getCallid(),
                sousaRirekiIvrInfo.getTtdkisihyouzikbn().getContent(),
                sousaRirekiIvrInfo.getDssyorikekkakbn().getContent(),
                sousaRirekiIvrInfo.getSetudankasyokbn().getContent(),
                sousaRirekiIvrInfo.getSetudanriyuukbn().getContent(),
                editHms(Strings.padStart(String.valueOf(hourMinSecChangeBean.getHour()), 2, '0') +
                    Strings.padStart(String.valueOf(hourMinSecChangeBean.getMin()), 2, '0') +
                    Strings.padStart(String.valueOf(hourMinSecChangeBean.getSec()), 2, '0')));

            SousarirekisyousaiInfoDataSourceBean sousarirekiIvrInfoDSBean = SWAKInjector.getInstance(
                SousarirekisyousaiInfoDataSourceBean.class);

            sousarirekiIvrInfoDSBean.setSyorinaiyoukbn(C_DsSyoriNaiyouKbn.IVRRENKEIINFO);
            sousarirekiIvrInfoDSBean.setSyoriendymd(null);
            sousarirekiIvrInfoDSBean.setSyoriendtime("");
            sousarirekiIvrInfoDSBean.setSyorisyousai(ivrInfoMsg);

            sousaRirekiSyousaiList.add(sousarirekiIvrInfoDSBean);
        }

        uiBean.setSousarirekisyousaiInfo(sousaRirekiSyousaiList);
    }

    private String editHms(String pDate) {

        StringBuffer rtnHms = new StringBuffer("");

        if (pDate.length() >= 6) {
            rtnHms.append(pDate.substring(0, 2));
            rtnHms.append(COLON);
            rtnHms.append(pDate.substring(2, 4));
            rtnHms.append(COLON);
            rtnHms.append(pDate.substring(4, 6));
        }

        return rtnHms.toString();
    }

    public String editDateYmdHms(String pSyorYmdHms) {

        StringBuffer syoriTime = new StringBuffer("");

        if (pSyorYmdHms != null && pSyorYmdHms.length() >= 14) {

            SeirekiWarekiKbn kbn = BizDateConfig.getInstance().getSeirekiWarekiKbn();
            switch (kbn) {
                case SEIREKI:
                    syoriTime.append(new BizDateFormat("yyyy/MM/dd", FillStyle.Zero).format(
                        BizDate.valueOf(pSyorYmdHms.substring(0, 8))));
                    break;
                case WAREKI_SYMBOL:
                case WAREKI_KANJI:
                case WAREKI_INPUT:
                default:
                    syoriTime.append(new BizDateFormat("Gyy/MM/dd", FillStyle.Zero).format(
                        BizDate.valueOf(pSyorYmdHms.substring(0, 8))));
            }

            syoriTime.append(HANKAKU_SPACE);
            syoriTime.append(pSyorYmdHms.substring(8, 10));
            syoriTime.append(COLON);
            syoriTime.append(pSyorYmdHms.substring(10, 12));
            syoriTime.append(COLON);
            syoriTime.append(pSyorYmdHms.substring(12, 14));
        }

        return syoriTime.toString();
    }
}
