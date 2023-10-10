package yuyu.app.direct.dsmailhaisinkanri.dsmailhaisinyoyaku;

import static yuyu.app.direct.dsmailhaisinkanri.dsmailhaisinyoyaku.DsMailHaisinYoyakuConstants.*;
import static yuyu.app.direct.dsmailhaisinkanri.dsmailhaisinyoyaku.GenDsMailHaisinYoyakuConstants.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

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

import yuyu.app.direct.dsmailhaisinkanri.dsmailhaisinyoyaku.dba.DsMailHaisinYoyakuDao;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.def.MessageId;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_DsHaisinYoyakuStatusKbn;
import yuyu.def.classification.C_DsKinouModeIdKbn;
import yuyu.def.classification.C_DsSousinMailSyubetuKbn;
import yuyu.def.classification.C_DsSpiralSequenceHsnSetKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.MT_DsMailHaisinYoyaku;
import yuyu.def.direct.manager.DirectDomManager;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;

/**
 * ＤＳメール配信予約 のビジネスロジックです。
 */
public class DsMailHaisinYoyakuBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private DsMailHaisinYoyakuUiBean uiBean;

    @Inject
    private MessageManager messageManager;

    @Inject
    private DsMailHaisinYoyakuDao dsMailHaisinYoyakuDao;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private DirectDomManager directDomManager;

    void init() {

        BizPropertyInitializer.initialize(uiBean);

        uiBean.setSrchdshaisinyoyakustatuskbn(new C_DsHaisinYoyakuStatusKbn[]{
            C_DsHaisinYoyakuStatusKbn.SYOUNIN_MATI,C_DsHaisinYoyakuStatusKbn.SYOUNIN_SUMI});

        setYoyakuItiranInitMessage();
    }

    void clear() {
    }

    void pushSearchBtnByYoyakuItiran(){

        uiBean.setSearchResultInfo(null);

        chkHaisinYoteiYmdContext();

        chkStatusSelected();

        int searchResultMaxCnt = YuyuBizConfig.getInstance().getSearchResultMaxCnt();

        BizDate srchDsHaisinYoteiYmdFrom = null;

        if (uiBean.getSrchdshaisinyoteiymdfrom() == null){

            srchDsHaisinYoteiYmdFrom = BizDate.valueOf(MIN_INT_VALUE_VALID_YOYAKUKENSAKU);

        }else{

            srchDsHaisinYoteiYmdFrom = uiBean.getSrchdshaisinyoteiymdfrom();
        }

        BizDate srchDsHaisinYoteiYmdTo = null;

        if (uiBean.getSrchdshaisinyoteiymdto() == null){

            srchDsHaisinYoteiYmdTo = BizDate.valueOf(MAX_INT_VALUE_VALID_YOYAKUKENSAKU);

        }else{

            srchDsHaisinYoteiYmdTo = uiBean.getSrchdshaisinyoteiymdto();
        }

        List<MT_DsMailHaisinYoyaku> dsMailHaisinYoyakuList =
            dsMailHaisinYoyakuDao.getDsMailHaisinYoyakuDaoByMailSyubetuHaisinYoteiYmdStatus(
                uiBean.getSrchdssousinmailsyubetukbn(),
                srchDsHaisinYoteiYmdFrom,
                srchDsHaisinYoteiYmdTo,
                uiBean.getSrchdshaisinyoyakustatuskbn(),
                searchResultMaxCnt + 1);

        if (dsMailHaisinYoyakuList.size() == 0) {
            messageManager.addMessageId(MessageId.EAC0014);

            return;
        }

        if (dsMailHaisinYoyakuList.size() > searchResultMaxCnt) {

            messageManager.addMessageId(MessageId.IBA0019, String.valueOf(searchResultMaxCnt));

        }


        chkKinouModeHantei();

        BizDate sysDate = BizDate.getSysDate();
        C_DsKinouModeIdKbn kinouMode = uiBean.getKinouMode();
        List<SearchResultInfoDataSourceBean> dataSourceBeanList = Lists.newArrayList();

        for (MT_DsMailHaisinYoyaku dsMailHaisinYoyaku : dsMailHaisinYoyakuList) {

            SearchResultInfoDataSourceBean dataSourceBean =
                SWAKInjector.getInstance(SearchResultInfoDataSourceBean.class);

            dataSourceBean.setDsmailhaisinyoyakuskbtkey(dsMailHaisinYoyaku.getDsmailhaisinyoyakuskbtkey());
            dataSourceBean.setDsmailhaisinyoteiymd(dsMailHaisinYoyaku.getDsmailhaisinyoteiymd());
            dataSourceBean.setDssousinmailsyubetukbn(dsMailHaisinYoyaku.getDssousinmailsyubetukbn());
            dataSourceBean.setDshaisinyoyakustatuskbn(dsMailHaisinYoyaku.getDshaisinyoyakustatuskbn());
            dataSourceBean.setGyoumuKousinTime(editDateYmd(dsMailHaisinYoyaku.getGyoumuKousinTime()));
            dataSourceBean.setKostime(dsMailHaisinYoyaku.getGyoumuKousinTime());
            dataSourceBean.setDsmailhaisintourokuymd(dsMailHaisinYoyaku.getDsmailhaisintourokuymd());
            dataSourceBean.setDsmailhaisinsyouninymd(dsMailHaisinYoyaku.getDsmailhaisinsyouninymd());

            C_DsHaisinYoyakuStatusKbn dsHaisinYoyakuStatusKbn = dsMailHaisinYoyaku.getDshaisinyoyakustatuskbn();

            if ((BizDateUtil.compareYmd(sysDate, dsMailHaisinYoyaku.getDsmailhaisinyoteiymd()) == BizDateUtil.COMPARE_LESSER) &&
                (C_DsHaisinYoyakuStatusKbn.SYOUNIN_MATI.eq(dsHaisinYoyakuStatusKbn)) &&
                (C_DsKinouModeIdKbn.SYOUNIN.eq(kinouMode))) {

                dataSourceBean.setSyouninlink(SYOUNIN_LINK);
            }
            else{

                dataSourceBean.setSyouninlink(SYOUNIN_LINK_HTML);
            }

            if ( !(C_DsHaisinYoyakuStatusKbn.SAKUJYO_SUMI.eq(dsHaisinYoyakuStatusKbn)) &&
                !( C_DsHaisinYoyakuStatusKbn.RENKEI_SUMI.eq(dsHaisinYoyakuStatusKbn)) &&
                (C_DsKinouModeIdKbn.SYOUNIN.eq(kinouMode))) {

                dataSourceBean.setSakujyoLink(SAKUJYO_LINK);
            }
            else{

                dataSourceBean.setSakujyoLink(SAKUJYO_LINK_HTML);
            }

            dataSourceBeanList.add(dataSourceBean);
        }

        if (dataSourceBeanList.size() > searchResultMaxCnt) {

            dataSourceBeanList.remove(searchResultMaxCnt);

        }

        uiBean.setSearchResultInfo(dataSourceBeanList);

        setYoyakuItiranInitMessage();
    }

    void pushYoyakuTourokuBtnByYoyakuItiran(){

        chkExistHaisinYoyaku();

        messageManager.addMessageId(MessageId.IMF1009);
    }

    void syouninLinkOnClick(){

        chkKosTime(uiBean.getSearchResultInfoDataSource().getSelectedBean());

        setGamenData(uiBean.getSearchResultInfoDataSource().getSelectedBean().getDsmailhaisinyoyakuskbtkey());
    }

    void sakujyoLinkOnClick(){

        chkKosTime(uiBean.getSearchResultInfoDataSource().getSelectedBean());

        setGamenData(uiBean.getSearchResultInfoDataSource().getSelectedBean().getDsmailhaisinyoyakuskbtkey());
    }

    void pushKakuninBtnByYoyakuTouroku(){


        chkDsSpiralSequenceHsnSetKbnSelected();

        chkDsHaisinYoteiYmd(uiBean.getDsmailhaisinyoteiymd(), BizDate.getSysDate());

        uiBean.setSenimotoKbnInput(DS_MAIL_HAISINYOYAKU_TOUROKU_GAMEN);
        uiBean.setDsmailhaisinyoyakuskbtkey(BLANK);
        uiBean.setDsspiralsequencehsnset(false);
        uiBean.setDsspiralsequencehsnsetkbn(C_DsSpiralSequenceHsnSetKbn.KAKUNINZUMI);

        haisinYoyakuMessageInfo();
    }

    void pushModoruBtnByYoyakuTouroku(){

        setYoyakuItiranInitMessage();
    }

    void pushKakuninBtnByYoyakuSyounin(){

        chkDsSpiralSequenceHsnSetKbnSelected();

        uiBean.setSenimotoKbnInput(DS_MAIL_HAISINYOYAKU_SYONIN_GAMEN);
        uiBean.setDsspiralsequencehsnset(false);
        uiBean.setDsspiralsequencehsnsetkbn(C_DsSpiralSequenceHsnSetKbn.KAKUNINZUMI);

        haisinYoyakuMessageInfo();

    }

    void pushModoruBtnByYoyakuSyounin(){

        setYoyakuItiranInitMessage();
    }

    void pushKakuninBtnByYoyakuSakujyo(){

        chkDsSpiralSequenceHsnSetKbnSelected();

        uiBean.setSenimotoKbnInput(DS_MAIL_HAISINYOYAKU_SAKUJYO_GAMEN);
        uiBean.setDsspiralsequencehsnset(false);
        uiBean.setDsspiralsequencehsnsetkbn(C_DsSpiralSequenceHsnSetKbn.KAKUNINZUMI);

        haisinYoyakuMessageInfo();
    }

    void pushModoruBtnByYoyakuSakujyo(){

        setYoyakuItiranInitMessage();
    }

    @Transactional
    void pushKakuteiBtnBL(){

        MT_DsMailHaisinYoyaku dsMailHaisinYoyaku = uiBean.getDsMailHaisinYoyaku();
        String kinouId = kinou.getKinouId();
        String userId = baseUserInfo.getUserId();
        BizDate sysDate = BizDate.getSysDate();
        String sysDateTimeMilli = BizDate.getSysDateTimeMilli();

        switch(uiBean.getSenimotoKbnInput()){

            case DS_MAIL_HAISINYOYAKU_TOUROKU_GAMEN:

                chkExistHaisinYoyaku();

                String dsmailhaisinyoyakuskbtke = saibanDsMailHaisinYoyakuSkbtKey(sysDate);

                MT_DsMailHaisinYoyaku dsMailHaisinYoyaku2 = new MT_DsMailHaisinYoyaku();

                dsMailHaisinYoyaku2.setDsmailhaisinyoyakuskbtkey(dsmailhaisinyoyakuskbtke);
                dsMailHaisinYoyaku2.setDsmailhaisinyoteiymd(uiBean.getDsmailhaisinyoteiymd());
                dsMailHaisinYoyaku2.setDssousinmailsyubetukbn(uiBean.getDssousinmailsyubetukbn());
                dsMailHaisinYoyaku2.setDshaisinyoyakustatuskbn(C_DsHaisinYoyakuStatusKbn.SYOUNIN_MATI);
                dsMailHaisinYoyaku2.setDsmailhaisintourokuymd(sysDate);
                dsMailHaisinYoyaku2.setDsmailhaisinsyouninymd(null);
                dsMailHaisinYoyaku2.setDsmailhaisintourokusyaid(userId);
                dsMailHaisinYoyaku2.setDsmailhaisinsyouninsyaid(BLANK);
                dsMailHaisinYoyaku2.setGyoumuKousinKinou(kinouId);
                dsMailHaisinYoyaku2.setGyoumuKousinsyaId(userId);
                dsMailHaisinYoyaku2.setGyoumuKousinTime(sysDateTimeMilli);

                BizPropertyInitializer.initialize(dsMailHaisinYoyaku2);

                directDomManager.insert(dsMailHaisinYoyaku2);

                break;

            case DS_MAIL_HAISINYOYAKU_SYONIN_GAMEN:


                dsMailHaisinYoyaku.setDshaisinyoyakustatuskbn(C_DsHaisinYoyakuStatusKbn.SYOUNIN_SUMI);
                dsMailHaisinYoyaku.setDsmailhaisinsyouninymd(sysDate);
                dsMailHaisinYoyaku.setDsmailhaisinsyouninsyaid(userId);
                dsMailHaisinYoyaku.setGyoumuKousinKinou(kinouId);
                dsMailHaisinYoyaku.setGyoumuKousinsyaId(userId);
                dsMailHaisinYoyaku.setGyoumuKousinTime(sysDateTimeMilli);

                break;

            case DS_MAIL_HAISINYOYAKU_SAKUJYO_GAMEN:


                dsMailHaisinYoyaku.setDshaisinyoyakustatuskbn(C_DsHaisinYoyakuStatusKbn.SAKUJYO_SUMI);
                dsMailHaisinYoyaku.setGyoumuKousinKinou(kinouId);
                dsMailHaisinYoyaku.setGyoumuKousinsyaId(userId);
                dsMailHaisinYoyaku.setGyoumuKousinTime(sysDateTimeMilli);

                break;

            default:
                break;
        }
        messageManager.addMessageId(MessageId.IAC0009);
    }

    void pushModoruBtnByYoyakuKakunin(){

        setInputGamenMessageSettei();
    }

    private void setYoyakuItiranInitMessage(){

        messageManager.addMessageId(MessageId.IMF1008);

        messageManager.addMessageId(MessageId.IMF1009);
    }

    private void chkStatusSelected(){

        if (uiBean.getSrchdshaisinyoyakustatuskbn() == null ) {

            throw new BizLogicException(MessageId.EDF0014,
                MessageUtil.getMessage(DDID_SEARCHRESULTINFO_DSHAISINYOYAKUSTATUSKBN.getErrorResourceKey()));
        }
    }

    private void chkHaisinYoteiYmdContext(){

        BizDate dsHaisinYoteiYmd_From = uiBean.getSrchdshaisinyoteiymdfrom();
        BizDate dsHaisinYoteiYmd_To   = uiBean.getSrchdshaisinyoteiymdto();

        if (dsHaisinYoteiYmd_From != null && dsHaisinYoteiYmd_To != null) {

            if (BizDateUtil.compareYmd(dsHaisinYoteiYmd_From, dsHaisinYoteiYmd_To) == BizDateUtil.COMPARE_GREATER) {
                throw new BizLogicException(MessageId.EAC0005,
                    DDID_DSSOUSINMAILKENSAKU_SRCHDSHAISINYOTEIYMDFROM,
                    DDID_DSSOUSINMAILKENSAKU_SRCHDSHAISINYOTEIYMDTO);
            }
        }
    }

    private void chkExistHaisinYoyaku(){

        List<MT_DsMailHaisinYoyaku> dsMailHaisinYoyakuList =
            dsMailHaisinYoyakuDao.getDsMailHaisinYoyakuByMailSyubetu(C_DsSousinMailSyubetuKbn.BLNK);

        if (dsMailHaisinYoyakuList.size() >= 1) {

            throw new BizLogicException(MessageId.EMF1013);
        }
    }

    private void chkKosTime(SearchResultInfoDataSourceBean pDataSourceBean){

        MT_DsMailHaisinYoyaku dsMailHaisinYoyaku =
            dsMailHaisinYoyakuDao.getDsMailHaisinYoyakuByDsMailHaisinSkbtKey(pDataSourceBean.getDsmailhaisinyoyakuskbtkey());

        if (!pDataSourceBean.getKostime().equals(dsMailHaisinYoyaku.getGyoumuKousinTime())) {

            throw new BizLogicException(MessageId.EAS0030);
        }
    }

    private void haisinYoyakuMessageInfo(){

        switch(uiBean.getSyoriKbn()){

            case TOUROKU:

                messageManager.addMessageId(MessageId.QMA1012);
                break;

            case SYOUNIN:

                messageManager.addMessageId(MessageId.QMA1013);
                break;

            case SAKUJYO:

                messageManager.addMessageId(MessageId.QMA1014);
                break;

            default:
                break;
        }
    }

    private void setGamenData(String pDsMailHaisinYoyakuSkbtKey){

        MT_DsMailHaisinYoyaku dsMailHaisinYoyaku = dsMailHaisinYoyakuDao.
            getDsMailHaisinYoyakuByDsMailHaisinSkbtKey(pDsMailHaisinYoyakuSkbtKey);

        uiBean.setDsMailHaisinYoyaku(dsMailHaisinYoyaku);
        uiBean.setDsmailhaisinyoyakuskbtkey(pDsMailHaisinYoyakuSkbtKey);
        uiBean.setDsmailhaisinyoteiymd(dsMailHaisinYoyaku.getDsmailhaisinyoteiymd());
        uiBean.setDssousinmailsyubetukbn(dsMailHaisinYoyaku.getDssousinmailsyubetukbn());
    }

    private void chkKinouModeHantei() {

        C_DsKinouModeIdKbn kinouMode = null;

        Boolean hasTeiseiKinouId = baseUserInfo.hasAuthenticatedFunctionMode(C_DsKinouModeIdKbn.SYOUNIN.getValue());

        if (hasTeiseiKinouId) {

            kinouMode = C_DsKinouModeIdKbn.SYOUNIN;
        }
        else {

            kinouMode = C_DsKinouModeIdKbn.DEFAULT;
        }
        uiBean.setKinouMode(kinouMode);
    }

    private void chkDsSpiralSequenceHsnSetKbnSelected(){

        if (!uiBean.getDsspiralsequencehsnset()) {

            throw new BizLogicException(MessageId.EMA1010,
                MessageUtil.getMessage(DDID_SOUSINMAILNAIYOU_DSSPIRALSEQUENCEHSNSET.getErrorResourceKey()));
        }
    }

    private void chkDsHaisinYoteiYmd(BizDate pDsHaisinYoteiYmd, BizDate pSysDate){

        if ((BizDateUtil.compareYmd(pDsHaisinYoteiYmd, pSysDate) == BizDateUtil.COMPARE_LESSER)
            || (BizDateUtil.compareYmd(pDsHaisinYoteiYmd, pSysDate) == BizDateUtil.COMPARE_EQUAL)) {

            throw new BizLogicException(MessageId.EMA1011,DDID_SOUSINMAILNAIYOU_DSMAILHAISINYOTEIYMD);
        }

        BizDate haisinKanouSaisyuuYmd = pSysDate.addMonths(3).getRekijyou();

        if (BizDateUtil.compareYmd(pDsHaisinYoteiYmd, haisinKanouSaisyuuYmd) == BizDateUtil.COMPARE_GREATER) {

            throw new BizLogicException(MessageId.EMA1012,DDID_SOUSINMAILNAIYOU_DSMAILHAISINYOTEIYMD);
        }

        BizDate haisinYoteiPrevDay = pDsHaisinYoteiYmd.addDays(-1);

        if (pDsHaisinYoteiYmd.isHoliday() || haisinYoteiPrevDay.isHoliday()) {

            throw new BizLogicException(MessageId.EMF1014,DDID_SOUSINMAILNAIYOU_DSMAILHAISINYOTEIYMD);
        }
    }

    private String saibanDsMailHaisinYoyakuSkbtKey(BizDate pSysDate){

        long siteiHaisinTourokuYmdRecordCount =
            dsMailHaisinYoyakuDao.getDsMailHaisinYoyakuCountHaisinTourokuYmd(pSysDate);

        String siteiHaisinTourokuYmdRenban = Strings.padStart(String.valueOf(siteiHaisinTourokuYmdRecordCount + 1),
            MAIL_HAISINYOYAKU_SIKIBETUKEY_RENBAN_KETASU, '0');

        String dsMailHaisinYoyakuSkbtKey = pSysDate.toString() + siteiHaisinTourokuYmdRenban;

        return dsMailHaisinYoyakuSkbtKey;
    }

    private void setInputGamenMessageSettei(){

        if (uiBean.getSenimotoKbnInput() == DS_MAIL_HAISINYOYAKU_TOUROKU_GAMEN) {

            messageManager.addMessageId(MessageId.IMF1009);
        }
    }


    public String editDateYmd(String pSyorYmdHms) {

        StringBuffer syoriTime = new StringBuffer("");

        if (pSyorYmdHms != null && pSyorYmdHms.length() >= 8) {

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
        }

        return syoriTime.toString();
    }
}
