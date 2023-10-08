package yuyu.app.sinkeiyaku.sksonota.sktetudukityuui;

import static yuyu.app.sinkeiyaku.sksonota.sktetudukityuui.SkTetudukiTyuuiConstants.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.StringUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.EditSecurityKm;
import yuyu.common.biz.koutei.BzCommonLockProcess;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.sinkeiyaku.skcommon.GetSkTtdkTyuui;
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;
import yuyu.def.MessageId;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_SkeittdkrenrakuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YesNoKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.HT_SkTtdkTyuui;
import yuyu.def.db.entity.HT_SkTtdkTyuuiKanri;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * 新契約手続注意設定 のビジネスロジックです。
 */
public class SkTetudukiTyuuiBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private SkTetudukiTyuuiUiBean uiBean;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private MessageManager messageManager;

    @Inject
    private GetSkTtdkTyuui getSkTtdkTyuui;

    @Inject
    private BzCommonLockProcess bzCommonLockProcess;

    @Inject
    private BzGetProcessSummary bzGetProcessSummary;

    @Inject
    private BzGetProcessSummaryInBean bzGetProcessSummaryInBean;

    void init() {
    }

    void clear() {
    }

    void pushTourokuBL() {
        BizPropertyInitializer.initialize(uiBean);

        HT_SyoriCTL syoriCtl = sinkeiyakuDomManager.getSyoriCTL(uiBean.getMosno());

        if (syoriCtl == null) {

            throw new BizLogicException(MessageId.EBA0090);
        }


        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(uiBean.getMosno());

        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanList =
            bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

        if (bzGetProcessSummaryOutBeanList.size() != 0) {
            bzCommonLockProcess.lockProcess(bzGetProcessSummaryOutBeanList.get(0).getKouteiKanriId(),
                ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
        }

        uiBean.setSyoriCTL(syoriCtl);

        setSkeittdktyuuiset();

    }

    void createToriatukaiList(){
        List<ToriatukaiTyuuiInfoDataSourceBean> groupList = uiBean.getToriatukaiTyuuiInfoDataSource().getAllData();

        List<ToriatukaiTyuuiInfoDataSourceBean> toriatukaiTyuuiInfoList = Lists.newArrayList();
        for (int i = 0; i < MAX_ROW_COUNT; i++) {


            if (i < groupList.size()){
                ToriatukaiTyuuiInfoDataSourceBean DataSourceBean = groupList.get(i);
                DataSourceBean.setLinehyoujiflag(C_YesNoKbn.YES);
                toriatukaiTyuuiInfoList.add(DataSourceBean);
            }
            else {
                ToriatukaiTyuuiInfoDataSourceBean DataSourceBean = new ToriatukaiTyuuiInfoDataSourceBean();
                DataSourceBean.setDisptratkityuuidel(false);

                DataSourceBean.setLinehyoujiflag(C_YesNoKbn.NO);
                toriatukaiTyuuiInfoList.add(DataSourceBean);
            }
        }
        uiBean.setToriatukaiTyuuiInfo(toriatukaiTyuuiInfoList);
    }

    void createSonotaList(){
        List<SonotaTyuuiInfoDataSourceBean> groupList = uiBean.getSonotaTyuuiInfoDataSource().getAllData();

        List<SonotaTyuuiInfoDataSourceBean> sonotaTyuuiInfoList = Lists.newArrayList();
        for (int i = 0; i < MAX_ROW_COUNT; i++) {
            if (i < groupList.size()){
                SonotaTyuuiInfoDataSourceBean DataSourceBean = groupList.get(i);
                DataSourceBean.setLinehyoujiflag(C_YesNoKbn.YES);
                sonotaTyuuiInfoList.add(DataSourceBean);
            }
            else {
                SonotaTyuuiInfoDataSourceBean DataSourceBean = new SonotaTyuuiInfoDataSourceBean();
                DataSourceBean.setDispsttratkityuuidel(false);

                DataSourceBean.setLinehyoujiflag(C_YesNoKbn.NO);
                sonotaTyuuiInfoList.add(DataSourceBean);
            }
        }
        uiBean.setSonotaTyuuiInfo(sonotaTyuuiInfoList);
    }

    void pushModoruByInputContentsBL() {
        clear();
    }

    void pushKakuninBL() {

        List<ToriatukaiTyuuiInfoDataSourceBean> toriatukaiTyuuiInfoOldList = uiBean.getToriatukaiTyuuiInfoDataSource().getAllData();

        List<SonotaTyuuiInfoDataSourceBean> sonotaTyuuiInfoOldList = uiBean.getSonotaTyuuiInfoDataSource().getAllData();

        if (C_UmuKbn.ARI.eq(uiBean.getFsttourokuFlg())) {

            boolean trtNaiyosFlg = false;
            boolean sntNaiyoFlg = false;

            for (int iCount = 0; iCount < toriatukaiTyuuiInfoOldList.size(); iCount++) {
                if (BizUtil.isBlank(toriatukaiTyuuiInfoOldList.get(iCount).getSkeittdktyuitrtnaiyo())) {
                    trtNaiyosFlg = true;
                }
                else {
                    break;
                }
            }

            for (int iCount = 0; iCount < sonotaTyuuiInfoOldList.size(); iCount++) {
                if (BizUtil.isBlank(sonotaTyuuiInfoOldList.get(iCount).getSkeittdktyuistnaiyo())) {
                    sntNaiyoFlg = true;
                }
                else {
                    break;
                }
            }
            if (!uiBean.getSkeittdkkinkyuyouhi()
                && !uiBean.getSkeittdktyuuiyouhi()
                && trtNaiyosFlg && sntNaiyoFlg ) {
                throw new BizLogicException(MessageId.EBC0043,
                    MessageUtil.getMessage(DDID_TORIATUKAITYUUIINFO_SKEITTDKTYUITRTNAIYO.getErrorResourceKey()));
            }
        }

        messageManager.addMessageId(MessageId.QBA0001);
    }


    @Transactional
    void pushKakuteiBL() {
        String sysDateTime = BizDate.getSysDateTimeMilli();
        HT_SyoriCTL syoriCtl = uiBean.getSyoriCTL();

        List<ToriatukaiTyuuiInfoDataSourceBean> toriatukaiTyuuiInfoList =
            uiBean.getToriatukaiTyuuiInfoDataSource().getAllData();
        List<SonotaTyuuiInfoDataSourceBean> sonotaTyuuiInfoList =
            uiBean.getSonotaTyuuiInfoDataSource().getAllData();

        HT_SkTtdkTyuuiKanri skTtdkTyuuiKanri = getSkTtdkTyuui.getTtdkTyuuiKanri(uiBean.getMosno());

        Boolean kinkyuyouhiKbn =  uiBean.getSkeittdkkinkyuyouhi();
        Boolean tyuuiyouhiKbn = uiBean.getSkeittdktyuuiyouhi();

        if (skTtdkTyuuiKanri != null) {

            if (kinkyuyouhiKbn
                || tyuuiyouhiKbn) {
                if (!kinkyuyouhiKbn) {
                    skTtdkTyuuiKanri.setSkeittdkkinkyuyouhikbn(C_YouhiKbn.HUYOU);
                }
                else {
                    skTtdkTyuuiKanri.setSkeittdkkinkyuyouhikbn(C_YouhiKbn.YOU);
                }

                if (!tyuuiyouhiKbn) {
                    skTtdkTyuuiKanri.setSkeittdktyuuiyouhikbn(C_YouhiKbn.HUYOU);
                }
                else {
                    skTtdkTyuuiKanri.setSkeittdktyuuiyouhikbn(C_YouhiKbn.YOU);
                }
                skTtdkTyuuiKanri.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                skTtdkTyuuiKanri.setGyoumuKousinTime(sysDateTime);
            }
            else {
                syoriCtl.setSkTtdkTyuuiKanri(null);
            }
        }
        else {
            if (kinkyuyouhiKbn
                || tyuuiyouhiKbn) {

                HT_SkTtdkTyuuiKanri skKanri = syoriCtl.createSkTtdkTyuuiKanri();

                if (!kinkyuyouhiKbn) {
                    skKanri.setSkeittdkkinkyuyouhikbn(C_YouhiKbn.HUYOU);
                }
                else {
                    skKanri.setSkeittdkkinkyuyouhikbn(C_YouhiKbn.YOU);
                }

                if (!tyuuiyouhiKbn) {
                    skKanri.setSkeittdktyuuiyouhikbn(C_YouhiKbn.HUYOU);
                }
                else {
                    skKanri.setSkeittdktyuuiyouhikbn(C_YouhiKbn.YOU);
                }
                skKanri.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                skKanri.setGyoumuKousinTime(sysDateTime);
                BizPropertyInitializer.initialize(skKanri);
            }
        }

        if (C_UmuKbn.ARI.eq(uiBean.getFsttourokuFlg())) {

            editDataFstTouroku(toriatukaiTyuuiInfoList, sonotaTyuuiInfoList, sysDateTime,
                C_SkeittdkrenrakuKbn.TTDK_TRATKITYUUIINFO);
            editDataFstTouroku(toriatukaiTyuuiInfoList, sonotaTyuuiInfoList, sysDateTime,
                C_SkeittdkrenrakuKbn.TTDK_SONOTATYUUIINFO);
        }
        else {
            List<HT_SkTtdkTyuui> skTtdkTyuuiTorList = getSkTtdkTyuui.getTtdkTyuui(uiBean.getMosno(),
                C_SkeittdkrenrakuKbn.TTDK_TRATKITYUUIINFO);


            List<HT_SkTtdkTyuui> skTtdkTyuuiSonList = getSkTtdkTyuui.getTtdkTyuui(uiBean.getMosno(),
                C_SkeittdkrenrakuKbn.TTDK_SONOTATYUUIINFO);

            if (!syoriCtl.getSkTtdkTyuuis().isEmpty()) {
                syoriCtl.getSkTtdkTyuuis().clear();
                sinkeiyakuDomManager.flush();
            }

            editData(toriatukaiTyuuiInfoList, sonotaTyuuiInfoList, sysDateTime, skTtdkTyuuiTorList,
                C_SkeittdkrenrakuKbn.TTDK_TRATKITYUUIINFO);

            editData(toriatukaiTyuuiInfoList, sonotaTyuuiInfoList, sysDateTime, skTtdkTyuuiSonList,
                C_SkeittdkrenrakuKbn.TTDK_SONOTATYUUIINFO);
        }

        syoriCtl.setGyoumuKousinsyaId(baseUserInfo.getUserId());
        syoriCtl.setGyoumuKousinTime(sysDateTime);
        sinkeiyakuDomManager.update(syoriCtl);

        messageManager.addMessageId(MessageId.IAC0009);
    }

    void doContinueLockProcess() {

        bzCommonLockProcess.continueLockProcess();
    }

    void doUnlockProcess() {

        bzCommonLockProcess.unlockProcess();
    }


    private void setSkeittdktyuuiset() {

        String skeitdkTyuuiKanriUmu = "";
        String ttdkTyuitrtUmu = "";
        String ttdkTyuistUmu = "";

        HT_SkTtdkTyuuiKanri skTtdkTyuuiKanri = getSkTtdkTyuui.getTtdkTyuuiKanri(uiBean.getMosno());
        if (skTtdkTyuuiKanri != null) {
            skeitdkTyuuiKanriUmu = "1";
            if (C_YouhiKbn.YOU.eq(skTtdkTyuuiKanri.getSkeittdkkinkyuyouhikbn())){
                uiBean.setSkeittdkkinkyuyouhi(true);
            }
            else {
                uiBean.setSkeittdkkinkyuyouhi(false);
            }

            if (C_YouhiKbn.YOU.eq(skTtdkTyuuiKanri.getSkeittdktyuuiyouhikbn())){
                uiBean.setSkeittdktyuuiyouhi(true);
            }
            else {
                uiBean.setSkeittdktyuuiyouhi(false);
            }

        }
        else {
            uiBean.setSkeittdkkinkyuyouhi(false);
            uiBean.setSkeittdktyuuiyouhi(false);
        }

        List<HT_SkTtdkTyuui> skTtdkTyuuiToriatukaiList = getSkTtdkTyuui.getTtdkTyuui(uiBean.getMosno(),
            C_SkeittdkrenrakuKbn.TTDK_TRATKITYUUIINFO);

        EditSecurityKm editSecurityKm = EditSecurityKm.getInstance();
        editSecurityKm.init(uiBean.getMosno());

        List<ToriatukaiTyuuiInfoDataSourceBean> toriatukaiList = Lists.newArrayList();
        if (skTtdkTyuuiToriatukaiList != null && skTtdkTyuuiToriatukaiList.size() > 0) {
            ttdkTyuitrtUmu = "1";
            for (HT_SkTtdkTyuui items : skTtdkTyuuiToriatukaiList) {

                HT_SkTtdkTyuui skTtdkTyuui = items;

                ToriatukaiTyuuiInfoDataSourceBean toriatukaiBean = new ToriatukaiTyuuiInfoDataSourceBean();
                toriatukaiBean.setSkeittdktyuitrtnaiyo(editSecurityKm.decode(skTtdkTyuui.getSkeittdktyuuinaiyou()));
                toriatukaiBean.setSkeittdktyuitrtrenno(skTtdkTyuui.getDatarenno());
                toriatukaiBean.setSkeittdktyuitrttrkymd(skTtdkTyuui.getTrkymd());
                toriatukaiList.add(toriatukaiBean);
            }

        }
        else {
            ToriatukaiTyuuiInfoDataSourceBean toriatukaiBean = new ToriatukaiTyuuiInfoDataSourceBean();
            toriatukaiBean.setDisptratkityuuidel(false);
            toriatukaiList.add(toriatukaiBean);
        }
        uiBean.setToriatukaiTyuuiInfo(toriatukaiList);

        List<HT_SkTtdkTyuui> skTtdkTyuuiSonotaList = getSkTtdkTyuui.getTtdkTyuui(uiBean.getMosno(),
            C_SkeittdkrenrakuKbn.TTDK_SONOTATYUUIINFO);

        List<SonotaTyuuiInfoDataSourceBean> sonotaList = Lists.newArrayList();
        if (skTtdkTyuuiSonotaList != null && skTtdkTyuuiSonotaList.size() > 0) {
            ttdkTyuistUmu = "1";
            for (HT_SkTtdkTyuui items : skTtdkTyuuiSonotaList) {

                HT_SkTtdkTyuui skTtdkTyuui = items;

                SonotaTyuuiInfoDataSourceBean sonotaBean = new SonotaTyuuiInfoDataSourceBean();
                sonotaBean.setSkeittdktyuistnaiyo(editSecurityKm.decode(skTtdkTyuui.getSkeittdktyuuinaiyou()));
                sonotaBean.setSkeittdktyuisttrkrenno(skTtdkTyuui.getDatarenno());
                sonotaBean.setSkeittdktyuisttrkymd(skTtdkTyuui.getTrkymd());
                sonotaList.add(sonotaBean);
            }
        }
        else {
            SonotaTyuuiInfoDataSourceBean sonotaBean = new SonotaTyuuiInfoDataSourceBean();
            sonotaBean.setDispsttratkityuuidel(false);
            sonotaList.add(sonotaBean);
        }
        uiBean.setSonotaTyuuiInfo(sonotaList);

        if (BizUtil.isBlank(skeitdkTyuuiKanriUmu)
            && BizUtil.isBlank(ttdkTyuitrtUmu)
            && BizUtil.isBlank(ttdkTyuistUmu)) {
            uiBean.setFsttourokuFlg(C_UmuKbn.ARI);
        }
        else {
            uiBean.setFsttourokuFlg(C_UmuKbn.NONE);
        }
    }

    private void editDataFstTouroku(List<ToriatukaiTyuuiInfoDataSourceBean> pToriatukaiTyuuiInfoList,
        List<SonotaTyuuiInfoDataSourceBean> pSonotaTyuuiInfoList,
        String pSysDateTime,
        C_SkeittdkrenrakuKbn pRenrakuKbn) {

        EditSecurityKm editSecurityKm = EditSecurityKm.getInstance();
        editSecurityKm.init(uiBean.getMosno());

        BizDate sysDate = BizDate.getSysDate();
        int count = getCount(pToriatukaiTyuuiInfoList, pSonotaTyuuiInfoList, pRenrakuKbn);

        int renNo = 0;
        for (int i = 0; i < count; i++) {
            String naiyou = getNaiyo(pToriatukaiTyuuiInfoList, pSonotaTyuuiInfoList, i, pRenrakuKbn);

            if (!getDel(pToriatukaiTyuuiInfoList, pSonotaTyuuiInfoList, i, pRenrakuKbn) &&
                !BizUtil.isBlank(StringUtil.lrTrim(naiyou))) {
                HT_SkTtdkTyuui skTtdkTyuui = uiBean.getSyoriCTL().createSkTtdkTyuui();
                renNo++;
                skTtdkTyuui.setSkeittdkrenrakukbn(pRenrakuKbn);
                skTtdkTyuui.setDatarenno(renNo);
                skTtdkTyuui.setSkeittdktyuuinaiyou(editSecurityKm.encode(naiyou));
                skTtdkTyuui.setTrkymd(sysDate);
                skTtdkTyuui.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                skTtdkTyuui.setGyoumuKousinTime(pSysDateTime);
                BizPropertyInitializer.initialize(skTtdkTyuui);

            }
        }
    }

    private void editData(List<ToriatukaiTyuuiInfoDataSourceBean> pToriatukaiTyuuiInfoList,
        List<SonotaTyuuiInfoDataSourceBean> pSonotaTyuuiInfoList,
        String pSysDateTime,
        List<HT_SkTtdkTyuui> pskTtdkTyuuiList,
        C_SkeittdkrenrakuKbn pRenrakuKbn) {

        EditSecurityKm editSecurityKm = EditSecurityKm.getInstance();
        BizDate sysDate = BizDate.getSysDate();
        int count = getCount(pToriatukaiTyuuiInfoList, pSonotaTyuuiInfoList, pRenrakuKbn);
        int renNo = 0;

        for (int i = 0; i < count; i++) {
            String naiyou = getNaiyo(pToriatukaiTyuuiInfoList, pSonotaTyuuiInfoList, i, pRenrakuKbn);

            if (!getDel(pToriatukaiTyuuiInfoList, pSonotaTyuuiInfoList, i, pRenrakuKbn) &&
                !BizUtil.isBlank(StringUtil.lrTrim(naiyou))) {
                C_UmuKbn henkouUmuKbn = C_UmuKbn.ARI;
                if (pskTtdkTyuuiList != null && i < pskTtdkTyuuiList.size()) {
                    editSecurityKm.init(uiBean.getMosno());

                    String ttdkNaiyouOld = editSecurityKm.decode(pskTtdkTyuuiList.get(i).getSkeittdktyuuinaiyou());

                    if (ttdkNaiyouOld.equals(naiyou)) {
                        henkouUmuKbn = C_UmuKbn.NONE;
                    }
                }
                editSecurityKm.init(uiBean.getMosno());

                HT_SkTtdkTyuui skTtdkTyuui = uiBean.getSyoriCTL().createSkTtdkTyuui();

                if (getRenno(pToriatukaiTyuuiInfoList, pSonotaTyuuiInfoList, i, pRenrakuKbn) == null) {
                    renNo++ ;
                    skTtdkTyuui.setSkeittdkrenrakukbn(pRenrakuKbn);
                    skTtdkTyuui.setDatarenno(renNo);
                    skTtdkTyuui.setSkeittdktyuuinaiyou(editSecurityKm.encode(naiyou));
                    skTtdkTyuui.setTrkymd(sysDate);
                    skTtdkTyuui.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                    skTtdkTyuui.setGyoumuKousinTime(pSysDateTime);
                }
                else {
                    renNo++ ;
                    skTtdkTyuui.setSkeittdkrenrakukbn(pRenrakuKbn);
                    skTtdkTyuui.setDatarenno(renNo);
                    skTtdkTyuui.setSkeittdktyuuinaiyou(editSecurityKm.encode(naiyou));

                    if (C_UmuKbn.ARI.eq(henkouUmuKbn)) {
                        skTtdkTyuui.setTrkymd(getTrkymd(pToriatukaiTyuuiInfoList, pSonotaTyuuiInfoList, i, pRenrakuKbn));
                        skTtdkTyuui.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                        skTtdkTyuui.setGyoumuKousinTime(pSysDateTime);
                    }
                    else {
                        skTtdkTyuui.setTrkymd(pskTtdkTyuuiList.get(i).getTrkymd());
                        skTtdkTyuui.setGyoumuKousinsyaId(pskTtdkTyuuiList.get(i).getGyoumuKousinsyaId());
                        skTtdkTyuui.setGyoumuKousinTime(pskTtdkTyuuiList.get(i).getGyoumuKousinTime());
                    }
                }
                BizPropertyInitializer.initialize(skTtdkTyuui);
            }
        }
    }

    private int getCount(List<ToriatukaiTyuuiInfoDataSourceBean> pToriatukaiTyuuiInfoList,
        List<SonotaTyuuiInfoDataSourceBean> pSonotaTyuuiInfoList,
        C_SkeittdkrenrakuKbn pRenrakuKbn) {
        if (C_SkeittdkrenrakuKbn.TTDK_TRATKITYUUIINFO.eq(pRenrakuKbn)) {
            return pToriatukaiTyuuiInfoList.size();
        }

        return pSonotaTyuuiInfoList.size();
    }

    private boolean getDel(List<ToriatukaiTyuuiInfoDataSourceBean> pToriatukaiTyuuiInfoList,
        List<SonotaTyuuiInfoDataSourceBean> pSonotaTyuuiInfoList,
        int pIndex,
        C_SkeittdkrenrakuKbn pRenrakuKbn) {
        if (C_SkeittdkrenrakuKbn.TTDK_TRATKITYUUIINFO.eq(pRenrakuKbn)) {
            return pToriatukaiTyuuiInfoList.get(pIndex).getDisptratkityuuidel();
        }

        return pSonotaTyuuiInfoList.get(pIndex).getDispsttratkityuuidel();
    }

    private String getNaiyo(List<ToriatukaiTyuuiInfoDataSourceBean> pToriatukaiTyuuiInfoList,
        List<SonotaTyuuiInfoDataSourceBean> pSonotaTyuuiInfoList,
        int pIndex,
        C_SkeittdkrenrakuKbn pRenrakuKbn) {
        if (C_SkeittdkrenrakuKbn.TTDK_TRATKITYUUIINFO.eq(pRenrakuKbn)) {
            return pToriatukaiTyuuiInfoList.get(pIndex).getSkeittdktyuitrtnaiyo();
        }

        return pSonotaTyuuiInfoList.get(pIndex).getSkeittdktyuistnaiyo();
    }

    private Integer getRenno(List<ToriatukaiTyuuiInfoDataSourceBean> pToriatukaiTyuuiInfoList,
        List<SonotaTyuuiInfoDataSourceBean> pSonotaTyuuiInfoList,
        int pIndex,
        C_SkeittdkrenrakuKbn pRenrakuKbn) {
        if (C_SkeittdkrenrakuKbn.TTDK_TRATKITYUUIINFO.eq(pRenrakuKbn)) {
            return pToriatukaiTyuuiInfoList.get(pIndex).getSkeittdktyuitrtrenno();
        }

        return pSonotaTyuuiInfoList.get(pIndex).getSkeittdktyuisttrkrenno();
    }

    private BizDate getTrkymd(List<ToriatukaiTyuuiInfoDataSourceBean> pToriatukaiTyuuiInfoList,
        List<SonotaTyuuiInfoDataSourceBean> pSonotaTyuuiInfoList,
        int pIndex,
        C_SkeittdkrenrakuKbn pRenrakuKbn) {
        if (C_SkeittdkrenrakuKbn.TTDK_TRATKITYUUIINFO.eq(pRenrakuKbn)) {
            return pToriatukaiTyuuiInfoList.get(pIndex).getSkeittdktyuitrttrkymd();
        }

        return pSonotaTyuuiInfoList.get(pIndex).getSkeittdktyuisttrkymd();
    }

    void listClean() {
        List<ToriatukaiTyuuiInfoDataSourceBean> toriatukaiTyuuiInfoOldList = uiBean.getToriatukaiTyuuiInfoDataSource().getDatas();
        Iterables.removeIf(toriatukaiTyuuiInfoOldList, new ToriatukaiDataSourceBeanPredicate());
        uiBean.setToriatukaiTyuuiInfo(toriatukaiTyuuiInfoOldList);

        List<SonotaTyuuiInfoDataSourceBean> sonotaTyuuiInfoOldList = uiBean.getSonotaTyuuiInfoDataSource().getDatas();
        Iterables.removeIf(sonotaTyuuiInfoOldList, new SonotaDataSourceBeanPredicate());
        uiBean.setSonotaTyuuiInfo(sonotaTyuuiInfoOldList);
    }

    private class ToriatukaiDataSourceBeanPredicate implements Predicate<ToriatukaiTyuuiInfoDataSourceBean>{

        public ToriatukaiDataSourceBeanPredicate() {
        }

        @Override
        public boolean apply(ToriatukaiTyuuiInfoDataSourceBean bean) {
            return C_YesNoKbn.NO.eq(bean.getLinehyoujiflag());
        }
    }

    private class SonotaDataSourceBeanPredicate implements Predicate<SonotaTyuuiInfoDataSourceBean>{

        public SonotaDataSourceBeanPredicate() {
        }

        @Override
        public boolean apply(SonotaTyuuiInfoDataSourceBean bean) {
            return C_YesNoKbn.NO.eq(bean.getLinehyoujiflag());
        }
    }
}
