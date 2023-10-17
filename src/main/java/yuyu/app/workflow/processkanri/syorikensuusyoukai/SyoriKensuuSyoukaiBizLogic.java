package yuyu.app.workflow.processkanri.syorikensuusyoukai;

import static yuyu.app.workflow.processkanri.syorikensuusyoukai.GenSyoriKensuuSyoukaiConstants.*;
import static yuyu.app.workflow.processkanri.syorikensuusyoukai.SyoriKensuuSyoukaiConstants.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;

import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.workflow.wfcommon.GetExecutableSubSystemsSelectInBean;
import yuyu.common.workflow.wfcommon.GetExecutableSubSystemsSelectOutBean;
import yuyu.common.workflow.wfcommon.WfUserSelectCommon;
import yuyu.common.workflow.workflowutility.CountOfTaskSummaryByJimutetuzukiBean;
import yuyu.common.workflow.workflowutility.CountOfTaskSummaryBySubsystemBean;
import yuyu.common.workflow.workflowutility.CountOfTaskSummaryByTaskBean;
import yuyu.common.workflow.workflowutility.GetCountOfTaskSummaryByJimutetuzukiResultBean;
import yuyu.common.workflow.workflowutility.GetCountOfTaskSummaryBySubsystemResultBean;
import yuyu.common.workflow.workflowutility.GetCountOfTaskSummaryByTaskResultBean;
import yuyu.common.workflow.workflowutility.WorkFlowResultConstants;
import yuyu.common.workflow.workflowutility.WorkFlowUtility;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.entity.AM_User;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;

/**
 * 処理件数照会 のビジネスロジックです。
 */
public class SyoriKensuuSyoukaiBizLogic {

    @Inject
    private static Logger logger;

    @Inject
    private SyoriKensuuSyoukaiUiBean uiBean;

    @Inject
    BaseDomManager baseDomManager;

    @Inject
    BaseUserInfo baseUserInfo;

    void init() {

        logger.info("処理件数照会機能を起動しました。");

        clear();
        BizPropertyInitializer.initialize(uiBean);

        String wkUserId = baseUserInfo.getUserId();

        logger.debug("============================================");
        logger.debug("ログインユーザ情報取得");
        logger.debug(wkUserId);
        logger.debug("============================================");


        WfUserSelectCommon wfUserSelectCommon = SWAKInjector.getInstance(WfUserSelectCommon.class);
        GetExecutableSubSystemsSelectInBean getExecutableSubSystemsSelectInBean =
            SWAKInjector.getInstance(GetExecutableSubSystemsSelectInBean.class);

        getExecutableSubSystemsSelectInBean.setUserId(wkUserId);
        getExecutableSubSystemsSelectInBean.setBlankUmu(true);
        GetExecutableSubSystemsSelectOutBean getExecutableSubSystemsSelectOutBean =
            wfUserSelectCommon.getExecutableSubSystemsSelectList(getExecutableSubSystemsSelectInBean);
        uiBean.setSubSystemIdOptionBeanList(getExecutableSubSystemsSelectOutBean.getUserDefsList());

        uiBean.setSyoriYmd(BizDate.getSysDate());
        uiBean.setSyoriYmdTo(BizDate.getSysDate());
    }

    void clear() {


        uiBean.setSubSystemId(null);
        uiBean.setUserId(null);
        uiBean.setUserNm(null);
        uiBean.setSyoriYmd(null);
        uiBean.setSyoriYmdTo(null);

        uiBean.setDispsubsystemnm(null);
        uiBean.setDispjimutetuzukinm(null);
        uiBean.setDisptantcd(null);
        uiBean.setDisptantounm(null);
        uiBean.setDispsyoriymd(null);
        uiBean.setDispsyoriymdto(null);

        uiBean.setDisptasknm(null);

        uiBean.clearSubSystemIdOptionBeanList();

        uiBean.getTaskuserInfoDataSource().setDatas(null);
        uiBean.getTaskuserInfo2DataSource().setDatas(null);
        uiBean.getTaskuserInfo3DataSource().setDatas(null);

    }

    void searchBtnOnClick() {
        logger.info("処理件数照会機能 検索を起動しました。");

        if (BizDateUtil.compareYmd(uiBean.getSyoriYmd(), BizDate.getSysDate()) == BizDateUtil.COMPARE_GREATER) {
            throw new BizLogicException(MessageId.EBA0026, new Item[] { DDID_SEARCHKEYINPUT_SYORIYMD },SYORI_YMD);
        }

        if (BizDateUtil.compareYmd(uiBean.getSyoriYmdTo(), BizDate.getSysDate()) == BizDateUtil.COMPARE_GREATER) {
            throw new BizLogicException(MessageId.EBA0026, new Item[] { DDID_SEARCHKEYINPUT_SYORIYMDTO },SYORI_YMD);

        }

        if (BizDateUtil.compareYmd(uiBean.getSyoriYmd(), uiBean.getSyoriYmdTo()) == BizDateUtil.COMPARE_GREATER) {
            throw new BizLogicException(MessageId.EDF0003,
                new Item[] { DDID_SEARCHKEYINPUT_SYORIYMD, DDID_SEARCHKEYINPUT_SYORIYMDTO },SYORI_YMD);

        }

        if (BizDateUtil.compareYmd(uiBean.getSyoriYmd().addMonths(3).getRekijyou(),
            uiBean.getSyoriYmdTo()) == BizDateUtil.COMPARE_LESSER) {
            throw new BizLogicException(MessageId.EBA1061,
                new Item[] { DDID_SEARCHKEYINPUT_SYORIYMD, DDID_SEARCHKEYINPUT_SYORIYMDTO },SYORI_YMD);

        }


        int listSize = 1;
        if (Strings.isNullOrEmpty(uiBean.getSubSystemId())) {
            listSize = uiBean.getSubSystemIdOptionBeanList().size() - 1;
        }

        String wkUserNm = uiBean.getUserNm();
        String[] wkSubSystemId = new String[listSize];

        String wkUserId = uiBean.getUserId();
        String pDispsubsystemnm = "";

        if (!Strings.isNullOrEmpty(uiBean.getSubSystemId())) {
            for (int i = 0; i < uiBean.getSubSystemIdOptionBeanList().size(); i++) {
                if (uiBean.getSubSystemIdOptionBeanList().get(i).getValue().equals(uiBean.getSubSystemId())) {
                    wkSubSystemId[0] = uiBean.getSubSystemIdOptionBeanList().get(i).getValue();
                    pDispsubsystemnm = uiBean.getSubSystemIdOptionBeanList().get(i).getLabel();
                }
            }
        }

        uiBean.setTaskuserInfo(null);


        if (!wkUserId.isEmpty()) {
            AM_User amUser = baseDomManager.getUser(uiBean.getUserId());
            if (amUser != null) {
                wkUserNm = amUser.getUserNm();
            } else {
                throw new BizLogicException(MessageId.EAC0001,
                    new Item[] { SyoriKensuuSyoukaiConstants.DDID_SEARCHKEYINPUT_USERID });
            }
        } else {
            wkUserNm = "";
        }

        List<TaskuserInfoDataSourceBean> pTaskuserInfo = new ArrayList<TaskuserInfoDataSourceBean>();
        List<CountOfTaskSummaryBySubsystemBean> countOfTaskSummaryBySubsystemBeanLst = Lists.newArrayList();
        List<CountOfTaskSummaryBySubsystemBean> touJituCountOfTaskSummaryBySubsystemBeanLst = Lists.newArrayList();
        List<CountOfTaskSummaryBySubsystemBean> kakoCountOfTaskSummaryBySubsystemBeanLst = Lists.newArrayList();
        List<TaskuserInfoDataSourceBean> touGmKmkBeanList = new ArrayList<TaskuserInfoDataSourceBean>();

        if (BizDateUtil.compareYmd(uiBean.getSyoriYmd(), uiBean.getSyoriYmdTo()) == BizDateUtil.COMPARE_EQUAL) {

            if (BizDateUtil.compareYmd(uiBean.getSyoriYmd(), BizDate.getSysDate()) == BizDateUtil.COMPARE_EQUAL) {

                logger.info("【ワークフロー呼出Utility#処理残件数取得（サブシステム・ユーザID指定）】実施");

                logger.debug("============================================");
                logger.debug("utility呼出し引数チェック");
                for (int i = 0; i < wkSubSystemId.length; i++) {
                    logger.debug("サブシステムID : " + wkSubSystemId[i]);
                }
                logger.debug("ユーザID : " + wkUserId);
                logger.debug("============================================");

                GetCountOfTaskSummaryBySubsystemResultBean result =
                    WorkFlowUtility.getCountOfTaskSummaryBySubsystem(wkSubSystemId, wkUserId);
                countOfTaskSummaryBySubsystemBeanLst = result.getCountOfTaskSummaryBean();

                if (!WorkFlowResultConstants.RESULT_OK.equals(result.getSyorikekkaStatus())) {
                    logger.error("ワークフロー呼出Utility#処理残件数取得(サブシステム・ユーザーID指定)");
                    logger.error("エラーコード：" + result.getSyousaiMessageCd());
                    logger.error("エラーメッセージ：" + result.getSyousaiMessage());
                    throw new BizAppException(MessageId.EAS0037);
                }
            }
            else {

                logger.info("【ワークフロー呼出Utility#処理残件数取得_過去実績サマリ分(サブシステム・ユーザーID指定)");
                logger.debug("============================================");
                logger.debug("utility呼出し引数チェック");
                for (int i = 0; i < wkSubSystemId.length; i++) {
                    logger.debug("サブシステムID : " + wkSubSystemId[i]);
                }
                logger.debug("ユーザID : " + wkUserId);
                logger.debug("処理日（自） : " + uiBean.getSyoriYmd().toString());
                logger.debug("============================================");

                GetCountOfTaskSummaryBySubsystemResultBean result =
                    WorkFlowUtility.getCountOfKakoJissekiTaskSummaryBySubsystem(wkSubSystemId, uiBean.getSyoriYmd(),
                        wkUserId);

                countOfTaskSummaryBySubsystemBeanLst = result.getCountOfTaskSummaryBean();

                if (WorkFlowResultConstants.RESULT_NODATA.equals(result.getSyorikekkaStatus())) {
                    throw new BizLogicException(MessageId.EAC0014);
                }
            }

            for (CountOfTaskSummaryBySubsystemBean taskSummaryBySubsystemBean : countOfTaskSummaryBySubsystemBeanLst) {
                TaskuserInfoDataSourceBean pTaskuserInfoDataSource = new TaskuserInfoDataSourceBean();

                pTaskuserInfoDataSource.setDispjimutetuzukinm(taskSummaryBySubsystemBean.getJimutetuzukiNm());
                pTaskuserInfoDataSource.setZenjituzanKensuu(taskSummaryBySubsystemBean.getCountOfprocessStartToday());
                pTaskuserInfoDataSource.setZanKensuu(taskSummaryBySubsystemBean.getCountOfprocessLeftToday());
                pTaskuserInfoDataSource.setKanryoKensuu(taskSummaryBySubsystemBean.getCountOfprocessFinToday());
                pTaskuserInfoDataSource.setJimutetuzukiCd(taskSummaryBySubsystemBean.getJimutetuzukiCd());

                if (pTaskuserInfoDataSource.getKanryoKensuu().equals(BizNumber.valueOf(0)) &&
                    pTaskuserInfoDataSource.getZanKensuu().equals(BizNumber.valueOf(0)) &&
                    pTaskuserInfoDataSource.getZenjituzanKensuu().equals(BizNumber.valueOf(0))) {
                    if (taskSummaryBySubsystemBean.isTaskFinByActorFlg()) {
                        pTaskuserInfoDataSource.setSyousaiLink(SyoriKensuuSyoukaiConstants.SYOUSAI_LINK);
                    }
                    else {
                        pTaskuserInfoDataSource.setSyousaiLink(SyoriKensuuSyoukaiConstants.BLANK);
                    }
                }
                else {
                    pTaskuserInfoDataSource.setSyousaiLink(SyoriKensuuSyoukaiConstants.SYOUSAI_LINK);
                }
                pTaskuserInfo.add(pTaskuserInfoDataSource);
            }
        }

        else {
            if (BizDateUtil.compareYmd(uiBean.getSyoriYmdTo(), BizDate.getSysDate()) == BizDateUtil.COMPARE_EQUAL) {

                logger.info("【ワークフロー呼出Utility#処理残件数取得(サブシステム・ユーザーID指定)】実施");

                logger.debug("============================================");
                logger.debug("utility呼出し引数チェック");
                for (int i = 0; i < wkSubSystemId.length; i++) {
                    logger.debug("サブシステムID : " + wkSubSystemId[i]);
                }
                logger.debug("ユーザID : " + wkUserId);
                logger.debug("============================================");

                GetCountOfTaskSummaryBySubsystemResultBean result =
                    WorkFlowUtility.getCountOfTaskSummaryBySubsystem(wkSubSystemId, wkUserId);

                if (!WorkFlowResultConstants.RESULT_OK.equals(result.getSyorikekkaStatus())) {
                    logger.error("ワークフロー呼出Utility#処理残件数取得(サブシステム・ユーザーID指定)");
                    logger.error("エラーコード：" + result.getSyousaiMessageCd());
                    logger.error("エラーメッセージ：" + result.getSyousaiMessage());
                    throw new BizAppException(MessageId.EAS0037);
                }

                touJituCountOfTaskSummaryBySubsystemBeanLst = result.getCountOfTaskSummaryBean();

            }

            logger.info("【ワークフロー呼出Utility#処理残件数取得_過去実績サマリ分(サブシステム・処理日・ユーザーID指定)");
            logger.debug("============================================");
            logger.debug("utility呼出し引数チェック");
            for (int i = 0; i < wkSubSystemId.length; i++) {
                logger.debug("サブシステムID : " + wkSubSystemId[i]);
            }
            logger.debug("ユーザID : " + wkUserId);
            logger.debug("処理日（自） : " + uiBean.getSyoriYmd().toString());
            logger.debug("処理日（至） : " + uiBean.getSyoriYmdTo().toString());
            logger.debug("============================================");

            GetCountOfTaskSummaryBySubsystemResultBean result =
                WorkFlowUtility.getCountOfKakoJissekiTaskSummaryBySubsystem(wkSubSystemId, uiBean.getSyoriYmd(),
                    uiBean.getSyoriYmdTo(), wkUserId);

            if (WorkFlowResultConstants.RESULT_NODATA.equals(result.getSyorikekkaStatus())) {

                if (BizDateUtil.compareYmd(uiBean.getSyoriYmdTo(), BizDate.getSysDate()) != BizDateUtil.COMPARE_EQUAL) {

                    throw new BizLogicException(MessageId.EAC0014);
                }
            }

            kakoCountOfTaskSummaryBySubsystemBeanLst = result.getCountOfTaskSummaryBean();

            for (CountOfTaskSummaryBySubsystemBean summaryBySubsystemBean : kakoCountOfTaskSummaryBySubsystemBeanLst) {
                TaskuserInfoDataSourceBean pTaskuserInfoDataSource = new TaskuserInfoDataSourceBean();

                pTaskuserInfoDataSource.setJimutetuzukiCd(summaryBySubsystemBean.getJimutetuzukiCd());
                pTaskuserInfoDataSource.setDispjimutetuzukinm(summaryBySubsystemBean.getJimutetuzukiNm());
                pTaskuserInfoDataSource.setKanryoKensuu(summaryBySubsystemBean.getCountOfprocessFinToday());

                if (summaryBySubsystemBean.getCountOfprocessStartToday().equals(BizNumber.valueOf(0)) &&
                    summaryBySubsystemBean.getCountOfprocessLeftToday().equals(BizNumber.valueOf(0)) &&
                    summaryBySubsystemBean.getCountOfprocessFinToday().equals(BizNumber.valueOf(0))) {
                    if (summaryBySubsystemBean.isTaskFinByActorFlg()) {
                        pTaskuserInfoDataSource.setSyousaiLink(SYOUSAI_LINK);
                    }
                    else {
                        pTaskuserInfoDataSource.setSyousaiLink(BLANK);
                    }
                }
                else {
                    pTaskuserInfoDataSource.setSyousaiLink(SYOUSAI_LINK);
                }
                pTaskuserInfo.add(pTaskuserInfoDataSource);
            }

            for (CountOfTaskSummaryBySubsystemBean summaryBySubsystemBean : touJituCountOfTaskSummaryBySubsystemBeanLst) {
                boolean kanryouKensuuInsFlg = false;

                for (TaskuserInfoDataSourceBean taskuserInfo : pTaskuserInfo) {

                    if (summaryBySubsystemBean.getJimutetuzukiCd().equals(taskuserInfo.getJimutetuzukiCd())) {

                        taskuserInfo.setKanryoKensuu(taskuserInfo.getKanryoKensuu().add(
                            summaryBySubsystemBean.getCountOfprocessFinToday()));

                        kanryouKensuuInsFlg = true;

                        break;
                    }
                }

                if (!kanryouKensuuInsFlg) {

                    TaskuserInfoDataSourceBean touGmKmkBean = new TaskuserInfoDataSourceBean();

                    touGmKmkBean.setJimutetuzukiCd(summaryBySubsystemBean.getJimutetuzukiCd());
                    touGmKmkBean.setDispjimutetuzukinm(summaryBySubsystemBean.getJimutetuzukiNm());
                    touGmKmkBean.setKanryoKensuu(summaryBySubsystemBean.getCountOfprocessFinToday());

                    if (summaryBySubsystemBean.getCountOfprocessStartToday().equals(BizNumber.valueOf(0)) &&
                        summaryBySubsystemBean.getCountOfprocessLeftToday().equals(BizNumber.valueOf(0)) &&
                        summaryBySubsystemBean.getCountOfprocessFinToday().equals(BizNumber.valueOf(0))) {

                        if (summaryBySubsystemBean.isTaskFinByActorFlg()) {
                            touGmKmkBean.setSyousaiLink(SyoriKensuuSyoukaiConstants.SYOUSAI_LINK);
                        }
                        else {
                            touGmKmkBean.setSyousaiLink(SyoriKensuuSyoukaiConstants.BLANK);
                        }
                    }
                    else {

                        touGmKmkBean.setSyousaiLink(SyoriKensuuSyoukaiConstants.SYOUSAI_LINK);

                    }

                    touGmKmkBeanList.add(touGmKmkBean);
                }
            }

            for (TaskuserInfoDataSourceBean touGmKmkBean : touGmKmkBeanList) {
                TaskuserInfoDataSourceBean pTaskuserInfoDataSource = new TaskuserInfoDataSourceBean();

                pTaskuserInfoDataSource.setJimutetuzukiCd(touGmKmkBean.getJimutetuzukiCd());
                pTaskuserInfoDataSource.setDispjimutetuzukinm(touGmKmkBean.getDispjimutetuzukinm());
                pTaskuserInfoDataSource.setKanryoKensuu(touGmKmkBean.getKanryoKensuu());
                pTaskuserInfoDataSource.setSyousaiLink(touGmKmkBean.getSyousaiLink());

                pTaskuserInfo.add(pTaskuserInfoDataSource);
            }

        }

        uiBean.setTaskuserInfo(pTaskuserInfo);

        uiBean.setUserNm(wkUserNm);
        uiBean.setUserId(wkUserId);
        uiBean.setDispsubsystemnm(pDispsubsystemnm);
        uiBean.setDispsyoriymd(uiBean.getSyoriYmd());
        uiBean.setDispsyoriymdto(uiBean.getSyoriYmdTo());
        uiBean.setDisptantcd(wkUserId);
        uiBean.setSearchSubsystemId(wkSubSystemId[0]);
    }

    void syousaiLinkOnClick() {
        logger.info("処理件数照会機能 「詳細」リンクが押下されました。");

        uiBean.setDisptantounm(uiBean.getUserNm());
        String pSearchSubsystemId = uiBean.getSearchSubsystemId();
        String pJimutetuzukiNm = uiBean.getTaskuserInfoDataSource().getSelectedBean().getDispjimutetuzukinm();
        String pJimutetuzukiCd = uiBean.getTaskuserInfoDataSource().getSelectedBean().getJimutetuzukiCd();
        String pDisptantcd = uiBean.getDisptantcd();
        BizDate pDispsyoriymd = uiBean.getDispsyoriymd();
        BizDate pDispsyoriymdTo = uiBean.getDispsyoriymdto();

        logger.debug("============================================");
        logger.debug("詳細リンク押下時　データ取得確認");
        logger.debug(pJimutetuzukiNm);
        logger.debug(pJimutetuzukiCd);
        logger.debug(pDispsyoriymd.toString());
        logger.debug(pDispsyoriymdTo.toString());
        logger.debug(pDisptantcd);
        logger.debug("============================================");

        List<TaskuserInfo2DataSourceBean> pTaskuserInfo2 = new ArrayList<TaskuserInfo2DataSourceBean>();
        List<CountOfTaskSummaryByJimutetuzukiBean> countOfTaskSummaryByJimutetuzukiBeanLst = Lists.newArrayList();
        List<CountOfTaskSummaryByJimutetuzukiBean> touJituCountOfTaskSummaryByJimutetuzukiBeanLst = Lists.newArrayList();
        List<CountOfTaskSummaryByJimutetuzukiBean> kakoCountOfTaskSummaryByJimutetuzukiBeanLst = Lists.newArrayList();
        List<TaskuserInfo2DataSourceBean> touGmKmkBeanList = new ArrayList<TaskuserInfo2DataSourceBean>();

        if (BizDateUtil.compareYmd(pDispsyoriymd, pDispsyoriymdTo) == BizDateUtil.COMPARE_EQUAL) {

            if (BizDateUtil.compareYmd(pDispsyoriymd, BizDate.getSysDate()) == BizDateUtil.COMPARE_EQUAL) {
                logger.info("【ワークフロー呼出Utility#処理残件数取得（事務手続指定）】実施");

                GetCountOfTaskSummaryByJimutetuzukiResultBean result =
                    WorkFlowUtility.getCountOfTaskSummaryByJimutetuzuki(pSearchSubsystemId, pJimutetuzukiCd, pDisptantcd);
                countOfTaskSummaryByJimutetuzukiBeanLst = result.getCountOfTaskSummaryBean();

                if (!WorkFlowResultConstants.RESULT_OK.equals(result.getSyorikekkaStatus())) {
                    logger.error("ワークフロー呼出Utility#処理残件数取得（事務手続指定）");
                    logger.error("エラーコード：" + result.getSyousaiMessageCd());
                    logger.error("エラーメッセージ：" + result.getSyousaiMessage());
                    throw new BizAppException(MessageId.EAS0037);
                }
            }
            else {
                logger.info("【ワークフロー呼出Utility#処理残件数取得_過去実績サマリ分(事務手続指定)】実施");
                GetCountOfTaskSummaryByJimutetuzukiResultBean result =
                    WorkFlowUtility.getCountOfKakoJissekiTaskSummaryByJimutetuzuki(
                        new String[] { pSearchSubsystemId }, pDispsyoriymd, pJimutetuzukiCd, pDisptantcd);
                countOfTaskSummaryByJimutetuzukiBeanLst = result.getCountOfTaskSummaryBean();

                if (WorkFlowResultConstants.RESULT_NODATA.equals(result.getSyorikekkaStatus())) {
                    throw new BizLogicException(MessageId.EAC0014);
                }
            }

            for (CountOfTaskSummaryByJimutetuzukiBean ｔaskSummaryByJimutetuzukiBean : countOfTaskSummaryByJimutetuzukiBeanLst) {
                TaskuserInfo2DataSourceBean pTaskuserInfo2DataSource = new TaskuserInfo2DataSourceBean();
                pTaskuserInfo2DataSource.setDisptasknm(ｔaskSummaryByJimutetuzukiBean.getDispTaskNm());
                pTaskuserInfo2DataSource.setZenjituzanKensuu(ｔaskSummaryByJimutetuzukiBean.getCountOfprocessStartToday());
                pTaskuserInfo2DataSource.setZanKensuu(ｔaskSummaryByJimutetuzukiBean.getCountOfprocessLeftToday());
                pTaskuserInfo2DataSource.setKanryoKensuu(ｔaskSummaryByJimutetuzukiBean.getCountOfprocessFinToday());
                pTaskuserInfo2DataSource.setTaskId(ｔaskSummaryByJimutetuzukiBean.getTaskNm());

                if (pTaskuserInfo2DataSource.getKanryoKensuu().equals(BizNumber.valueOf(0)) &&
                    pTaskuserInfo2DataSource.getZanKensuu().equals(BizNumber.valueOf(0)) &&
                    pTaskuserInfo2DataSource.getZenjituzanKensuu().equals(BizNumber.valueOf(0))) {
                    pTaskuserInfo2DataSource.setSyousaiLinkTask(SyoriKensuuSyoukaiConstants.BLANK);
                }
                else {
                    pTaskuserInfo2DataSource.setSyousaiLinkTask(SyoriKensuuSyoukaiConstants.SYOUSAI_LINK);
                }

                pTaskuserInfo2.add(pTaskuserInfo2DataSource);
            }
        }

        else {
            if (BizDateUtil.compareYmd(pDispsyoriymdTo, BizDate.getSysDate()) == BizDateUtil.COMPARE_EQUAL) {
                logger.info("【ワークフロー呼出Utility#処理残件数取得（事務手続指定）】実施");

                GetCountOfTaskSummaryByJimutetuzukiResultBean result =
                    WorkFlowUtility.getCountOfTaskSummaryByJimutetuzuki(pSearchSubsystemId, pJimutetuzukiCd, pDisptantcd);

                if (!WorkFlowResultConstants.RESULT_OK.equals(result.getSyorikekkaStatus())) {
                    logger.error("ワークフロー呼出Utility#処理残件数取得（事務手続指定）");
                    logger.error("エラーコード：" + result.getSyousaiMessageCd());
                    logger.error("エラーメッセージ：" + result.getSyousaiMessage());
                    throw new BizAppException(MessageId.EAS0037);
                }

                touJituCountOfTaskSummaryByJimutetuzukiBeanLst = result.getCountOfTaskSummaryBean();
            }

            logger.info("【ワークフロー呼出Utility#処理残件数取得_過去実績サマリ分(事務手続・処理日指定)】実施");
            GetCountOfTaskSummaryByJimutetuzukiResultBean result =
                WorkFlowUtility.getCountOfTaskSummaryByJimutetuzuki(
                    new String[] { pSearchSubsystemId }, pDispsyoriymd, pDispsyoriymdTo, pJimutetuzukiCd, pDisptantcd);

            if (WorkFlowResultConstants.RESULT_NODATA.equals(result.getSyorikekkaStatus())) {
                if (BizDateUtil.compareYmd(pDispsyoriymdTo, BizDate.getSysDate()) != BizDateUtil.COMPARE_EQUAL) {
                    throw new BizLogicException(MessageId.EAC0014);
                }
            }

            kakoCountOfTaskSummaryByJimutetuzukiBeanLst = result.getCountOfTaskSummaryBean();

            for (CountOfTaskSummaryByJimutetuzukiBean summaryByJimutetuzukiBean : kakoCountOfTaskSummaryByJimutetuzukiBeanLst) {

                TaskuserInfo2DataSourceBean pTaskuserInfo2DataSource = new TaskuserInfo2DataSourceBean();

                pTaskuserInfo2DataSource.setTaskId(summaryByJimutetuzukiBean.getTaskNm());
                pTaskuserInfo2DataSource.setDisptasknm(summaryByJimutetuzukiBean.getDispTaskNm());
                pTaskuserInfo2DataSource.setKanryoKensuu(summaryByJimutetuzukiBean.getCountOfprocessFinToday());

                if (summaryByJimutetuzukiBean.getCountOfprocessStartToday().equals(BizNumber.valueOf(0)) &&
                    summaryByJimutetuzukiBean.getCountOfprocessLeftToday().equals(BizNumber.valueOf(0)) &&
                    summaryByJimutetuzukiBean.getCountOfprocessFinToday().equals(BizNumber.valueOf(0))) {

                    pTaskuserInfo2DataSource.setSyousaiLinkTask(SyoriKensuuSyoukaiConstants.BLANK);
                }
                else {

                    pTaskuserInfo2DataSource.setSyousaiLinkTask(SyoriKensuuSyoukaiConstants.SYOUSAI_LINK);
                }

                pTaskuserInfo2.add(pTaskuserInfo2DataSource);
            }

            for (CountOfTaskSummaryByJimutetuzukiBean summaryByJimutetuzukiBean : touJituCountOfTaskSummaryByJimutetuzukiBeanLst) {

                boolean kanryouKensuuInsFlg = false;

                for (TaskuserInfo2DataSourceBean taskuserInfo2 : pTaskuserInfo2) {

                    if (summaryByJimutetuzukiBean.getTaskNm().equals(taskuserInfo2.getTaskId())) {

                        taskuserInfo2.setKanryoKensuu(taskuserInfo2.getKanryoKensuu().add(
                            summaryByJimutetuzukiBean.getCountOfprocessFinToday()));

                        kanryouKensuuInsFlg = true;

                        break;
                    }
                }

                if (!kanryouKensuuInsFlg) {
                    TaskuserInfo2DataSourceBean touGmKmkBean = new TaskuserInfo2DataSourceBean();

                    touGmKmkBean.setTaskId(summaryByJimutetuzukiBean.getTaskNm());
                    touGmKmkBean.setDisptasknm(summaryByJimutetuzukiBean.getDispTaskNm());
                    touGmKmkBean.setKanryoKensuu(summaryByJimutetuzukiBean.getCountOfprocessFinToday());

                    if (summaryByJimutetuzukiBean.getCountOfprocessStartToday().equals(BizNumber.valueOf(0)) &&
                        summaryByJimutetuzukiBean.getCountOfprocessLeftToday().equals(BizNumber.valueOf(0)) &&
                        summaryByJimutetuzukiBean.getCountOfprocessFinToday().equals(BizNumber.valueOf(0))) {

                        touGmKmkBean.setSyousaiLinkTask(SyoriKensuuSyoukaiConstants.BLANK);
                    }
                    else {

                        touGmKmkBean.setSyousaiLinkTask(SyoriKensuuSyoukaiConstants.SYOUSAI_LINK);
                    }

                    touGmKmkBeanList.add(touGmKmkBean);
                }
            }

            for (TaskuserInfo2DataSourceBean touGmKmkBean : touGmKmkBeanList) {

                TaskuserInfo2DataSourceBean pTaskuserInfo2DataSource = new TaskuserInfo2DataSourceBean();

                pTaskuserInfo2DataSource.setTaskId(touGmKmkBean.getTaskId());
                pTaskuserInfo2DataSource.setDisptasknm(touGmKmkBean.getDisptasknm());
                pTaskuserInfo2DataSource.setKanryoKensuu(touGmKmkBean.getKanryoKensuu());
                pTaskuserInfo2DataSource.setSyousaiLinkTask(touGmKmkBean.getSyousaiLinkTask());

                pTaskuserInfo2.add(pTaskuserInfo2DataSource);
            }
        }

        uiBean.setTaskuserInfo2(pTaskuserInfo2);
        uiBean.setJimutetuzukiCd(pJimutetuzukiCd);
        uiBean.setDispjimutetuzukinm(pJimutetuzukiNm);
        uiBean.setDisptantcd(pDisptantcd);
        uiBean.setDisptantounm(uiBean.getUserNm());
    }

    void syousaiLinkTaskOnClick() {
        String pJimutetuzukiCd = uiBean.getJimutetuzukiCd();
        String pTaskId = uiBean.getTaskuserInfo2DataSource().getSelectedBean().getTaskId();
        String pDisptantcd = uiBean.getDisptantcd();
        BizDate pDispsyoriymd = uiBean.getDispsyoriymd();
        BizDate pDispsyoriymdTo = uiBean.getDispsyoriymdto();

        List<TaskuserInfo3DataSourceBean> pTaskuserInfo3 = new ArrayList<TaskuserInfo3DataSourceBean>();
        List<CountOfTaskSummaryByTaskBean> taskSummaryByTaskBeanLst = Lists.newArrayList();
        List<CountOfTaskSummaryByTaskBean> touJituCountOfTaskSummaryByTaskBeanLst = Lists.newArrayList();
        List<CountOfTaskSummaryByTaskBean> kakoCountOfTaskSummaryByTaskBeanLst = Lists.newArrayList();
        List<TaskuserInfo3DataSourceBean> touGmKmkBeanList = new ArrayList<TaskuserInfo3DataSourceBean>();
        List<TaskuserInfo3DataSourceBean> gmKmkNzHtYouBeanList = new ArrayList<TaskuserInfo3DataSourceBean>();

        if (BizDateUtil.compareYmd(pDispsyoriymd, pDispsyoriymdTo) == BizDateUtil.COMPARE_EQUAL) {

            if (BizDateUtil.compareYmd(pDispsyoriymd, BizDate.getSysDate()) == BizDateUtil.COMPARE_EQUAL) {

                logger.info("【ワークフロー呼出Utility#処理残件数取得(事務手続・タスク指定)】実施");

                GetCountOfTaskSummaryByTaskResultBean result =
                    WorkFlowUtility.getCountOfTaskSummaryByTask(pJimutetuzukiCd, pTaskId, pDisptantcd);

                taskSummaryByTaskBeanLst = result.getCountOfTaskSummaryBean();

                if (!WorkFlowResultConstants.RESULT_OK.equals(result.getSyorikekkaStatus())) {
                    logger.error("ワークフロー呼出Utility#処理残件数取得(事務手続・タスク指定)");
                    logger.error("エラーコード：" + result.getSyousaiMessageCd());
                    logger.error("エラーメッセージ：" + result.getSyousaiMessage());
                    throw new BizAppException(MessageId.EAS0037);
                }

            }
            else {

                logger.info("【ワークフロー呼出Utility#処理残件数取得_過去実績サマリ分(事務手続・タスク指定)】実施");

                GetCountOfTaskSummaryByTaskResultBean result = WorkFlowUtility.getCountOfKakoJissekiTaskSummaryByTask(
                    pDispsyoriymd, pJimutetuzukiCd, new String[] { pTaskId }, pDisptantcd);
                taskSummaryByTaskBeanLst = result.getCountOfTaskSummaryBean();

                if (!WorkFlowResultConstants.RESULT_OK.equals(result.getSyorikekkaStatus())) {
                    logger.error("ワークフロー呼出Utility#処理残件数取得_過去実績サマリ分(事務手続・タスク指定)");
                    logger.error("エラーコード：" + result.getSyousaiMessageCd());
                    logger.error("エラーメッセージ：" + result.getSyousaiMessage());
                    throw new BizAppException(MessageId.EAS0037);
                }
            }
            if (BizUtil.isBlank(pDisptantcd)) {
                for (int i = 0; i < taskSummaryByTaskBeanLst.size(); i++) {
                    TaskuserInfo3DataSourceBean pTaskuserInfo3DataSource = new TaskuserInfo3DataSourceBean();
                    if (i == 0) {
                        pTaskuserInfo3DataSource.setDisptantounm(taskSummaryByTaskBeanLst.get(i).getDispUserNm());
                        pTaskuserInfo3DataSource.setZenjituzanKensuu(
                            taskSummaryByTaskBeanLst.get(i).getCountOfprocessStartToday());
                        pTaskuserInfo3DataSource.setZanKensuu(taskSummaryByTaskBeanLst.get(i).getCountOfprocessLeftToday());
                        pTaskuserInfo3DataSource.setKanryoKensuu(taskSummaryByTaskBeanLst.get(i)
                            .getCountOfprocessFinToday());
                        pTaskuserInfo3.add(pTaskuserInfo3DataSource);
                    }
                    else {

                        if (!(taskSummaryByTaskBeanLst.get(i).getCountOfprocessFinToday().isZeroOrOptional() &&
                            taskSummaryByTaskBeanLst.get(i).getCountOfprocessLeftToday().isZeroOrOptional() &&
                            taskSummaryByTaskBeanLst.get(i).getCountOfprocessStartToday().isZeroOrOptional())) {
                            pTaskuserInfo3DataSource.setDisptantounm(taskSummaryByTaskBeanLst.get(i).getDispUserNm());
                            pTaskuserInfo3DataSource.setZenjituzanKensuu(
                                taskSummaryByTaskBeanLst.get(i).getCountOfprocessStartToday());
                            pTaskuserInfo3DataSource.setZanKensuu(
                                taskSummaryByTaskBeanLst.get(i).getCountOfprocessLeftToday());
                            pTaskuserInfo3DataSource.setKanryoKensuu(
                                taskSummaryByTaskBeanLst.get(i).getCountOfprocessFinToday());
                            pTaskuserInfo3.add(pTaskuserInfo3DataSource);
                        }
                    }
                }
            }
            else {
                for (CountOfTaskSummaryByTaskBean taskSummaryByTaskBean : taskSummaryByTaskBeanLst) {
                    if (!BizUtil.isBlank(taskSummaryByTaskBean.getUserId())) {
                        TaskuserInfo3DataSourceBean pTaskuserInfo3DataSource = new TaskuserInfo3DataSourceBean();
                        pTaskuserInfo3DataSource.setDisptantounm(taskSummaryByTaskBean.getDispUserNm());
                        pTaskuserInfo3DataSource.setZenjituzanKensuu(taskSummaryByTaskBean.getCountOfprocessStartToday());
                        pTaskuserInfo3DataSource.setZanKensuu(taskSummaryByTaskBean.getCountOfprocessLeftToday());
                        pTaskuserInfo3DataSource.setKanryoKensuu(taskSummaryByTaskBean.getCountOfprocessFinToday());

                        pTaskuserInfo3.add(pTaskuserInfo3DataSource);
                    }
                }
            }

        }
        else {

            if (BizDateUtil.compareYmd(pDispsyoriymdTo, BizDate.getSysDate()) == BizDateUtil.COMPARE_EQUAL) {

                logger.info("【ワークフロー呼出Utility#処理残件数取得(事務手続・タスク指定)】実施");

                GetCountOfTaskSummaryByTaskResultBean result =
                    WorkFlowUtility.getCountOfTaskSummaryByTask(pJimutetuzukiCd, pTaskId, pDisptantcd);

                if (!WorkFlowResultConstants.RESULT_OK.equals(result.getSyorikekkaStatus())) {
                    logger.error("ワークフロー呼出Utility#処理残件数取得(事務手続・タスク指定)");
                    logger.error("エラーコード：" + result.getSyousaiMessageCd());
                    logger.error("エラーメッセージ：" + result.getSyousaiMessage());
                    throw new BizAppException(MessageId.EAS0037);
                }

                touJituCountOfTaskSummaryByTaskBeanLst = result.getCountOfTaskSummaryBean();

            }

            logger.info("【ワークフロー呼出Utility#処理残件数取得_過去実績サマリ分(事務手続・処理日・タスク指定)】実施");

            GetCountOfTaskSummaryByTaskResultBean result = WorkFlowUtility.getCountOfKakoJissekiTaskSummaryByTask(
                pDispsyoriymd, pDispsyoriymdTo, pJimutetuzukiCd, new String[] { pTaskId }, pDisptantcd);

            if (!WorkFlowResultConstants.RESULT_OK.equals(result.getSyorikekkaStatus())) {
                logger.error("ワークフロー呼出Utility#処理残件数取得_過去実績サマリ分(事務手続・タスク指定)");
                logger.error("エラーコード：" + result.getSyousaiMessageCd());
                logger.error("エラーメッセージ：" + result.getSyousaiMessage());
                throw new BizAppException(MessageId.EAS0037);
            }

            kakoCountOfTaskSummaryByTaskBeanLst = result.getCountOfTaskSummaryBean();

            if (BizUtil.isBlank(pDisptantcd)) {
                TaskuserInfo3DataSourceBean taskuserInfo3Bean = new TaskuserInfo3DataSourceBean();

                if (touJituCountOfTaskSummaryByTaskBeanLst.size() > 0) {
                    if (BizUtil.isBlank(touJituCountOfTaskSummaryByTaskBeanLst.get(0).getUserId())) {
                        taskuserInfo3Bean.setDisptantounm(touJituCountOfTaskSummaryByTaskBeanLst.get(0).getDispUserNm());
                        taskuserInfo3Bean.setKanryoKensuu(
                            touJituCountOfTaskSummaryByTaskBeanLst.get(0).getCountOfprocessFinToday());

                        pTaskuserInfo3.add(taskuserInfo3Bean);
                    }
                }

                if (kakoCountOfTaskSummaryByTaskBeanLst.size() > 0) {
                    if (BizUtil.isBlank(kakoCountOfTaskSummaryByTaskBeanLst.get(0).getUserId())) {
                        if (pTaskuserInfo3.size() > 0) {
                            pTaskuserInfo3.get(0).setKanryoKensuu(pTaskuserInfo3.get(0).getKanryoKensuu().add(
                                kakoCountOfTaskSummaryByTaskBeanLst.get(0).getCountOfprocessFinToday()));
                        }
                        else {
                            taskuserInfo3Bean.setDisptantounm(kakoCountOfTaskSummaryByTaskBeanLst.get(0).getDispUserNm());
                            taskuserInfo3Bean.setKanryoKensuu(kakoCountOfTaskSummaryByTaskBeanLst.get(0).getCountOfprocessFinToday());

                            pTaskuserInfo3.add(taskuserInfo3Bean);
                        }
                    }
                }

                for (int m = 0 ; m < kakoCountOfTaskSummaryByTaskBeanLst.size(); m++) {
                    if (!BizUtil.isBlank(kakoCountOfTaskSummaryByTaskBeanLst.get(m).getUserId())) {
                        TaskuserInfo3DataSourceBean gmKmkNzHtYouBean = new TaskuserInfo3DataSourceBean();

                        if (!(kakoCountOfTaskSummaryByTaskBeanLst.get(m).getCountOfprocessFinToday().isZeroOrOptional() &&
                            kakoCountOfTaskSummaryByTaskBeanLst.get(m).getCountOfprocessLeftToday().isZeroOrOptional() &&
                            kakoCountOfTaskSummaryByTaskBeanLst.get(m).getCountOfprocessStartToday().isZeroOrOptional())) {
                            gmKmkNzHtYouBean.setDisptantounm(kakoCountOfTaskSummaryByTaskBeanLst.get(m).getDispUserNm());
                            gmKmkNzHtYouBean.setKanryoKensuu(
                                kakoCountOfTaskSummaryByTaskBeanLst.get(m).getCountOfprocessFinToday());
                            gmKmkNzHtYouBean.setUserId(kakoCountOfTaskSummaryByTaskBeanLst.get(m).getUserId());
                            gmKmkNzHtYouBeanList.add(gmKmkNzHtYouBean);
                        }
                    }
                }

                for (int m = 0 ; m < touJituCountOfTaskSummaryByTaskBeanLst.size(); m++) {
                    if (!BizUtil.isBlank(touJituCountOfTaskSummaryByTaskBeanLst.get(m).getUserId())) {
                        boolean kanryouKensuuInsFlg = false;

                        for (TaskuserInfo3DataSourceBean gmKmkNzHtYouBean : gmKmkNzHtYouBeanList) {
                            if (touJituCountOfTaskSummaryByTaskBeanLst.get(m).getUserId().equals(gmKmkNzHtYouBean.getUserId())) {
                                gmKmkNzHtYouBean.setKanryoKensuu(gmKmkNzHtYouBean.getKanryoKensuu().add(
                                    touJituCountOfTaskSummaryByTaskBeanLst.get(m).getCountOfprocessFinToday()));

                                kanryouKensuuInsFlg = true;
                                break;
                            }

                        }

                        if (!kanryouKensuuInsFlg) {
                            TaskuserInfo3DataSourceBean touGmKmkBean = new TaskuserInfo3DataSourceBean();

                            if (!(touJituCountOfTaskSummaryByTaskBeanLst.get(m).getCountOfprocessFinToday().isZeroOrOptional() &&
                                touJituCountOfTaskSummaryByTaskBeanLst.get(m).getCountOfprocessLeftToday().isZeroOrOptional() &&
                                touJituCountOfTaskSummaryByTaskBeanLst.get(m).getCountOfprocessStartToday().isZeroOrOptional())) {
                                touGmKmkBean.setDisptantounm(touJituCountOfTaskSummaryByTaskBeanLst.get(m).getDispUserNm());
                                touGmKmkBean.setKanryoKensuu(touJituCountOfTaskSummaryByTaskBeanLst.get(m).getCountOfprocessFinToday());

                                touGmKmkBeanList.add(touGmKmkBean);
                            }
                        }
                    }
                }
            }
            else {
                for (CountOfTaskSummaryByTaskBean kakoCountOfTaskSummaryByTaskBean : kakoCountOfTaskSummaryByTaskBeanLst) {

                    if (!BizUtil.isBlank(kakoCountOfTaskSummaryByTaskBean.getUserId())) {
                        TaskuserInfo3DataSourceBean gmKmkNzHtYouBean = new TaskuserInfo3DataSourceBean();

                        gmKmkNzHtYouBean.setUserId(kakoCountOfTaskSummaryByTaskBean.getUserId());
                        gmKmkNzHtYouBean.setDisptantounm(kakoCountOfTaskSummaryByTaskBean.getDispUserNm());
                        gmKmkNzHtYouBean.setKanryoKensuu(kakoCountOfTaskSummaryByTaskBean.getCountOfprocessFinToday());

                        gmKmkNzHtYouBeanList.add(gmKmkNzHtYouBean);
                    }
                }

                for (CountOfTaskSummaryByTaskBean touJituCountOfTaskSummaryByTaskBean : touJituCountOfTaskSummaryByTaskBeanLst) {

                    boolean kanryouKensuuInsFlg = false;

                    for (TaskuserInfo3DataSourceBean gmKmkNzHtYouBean : gmKmkNzHtYouBeanList) {

                        if (touJituCountOfTaskSummaryByTaskBean.getUserId().equals(gmKmkNzHtYouBean.getUserId())) {

                            gmKmkNzHtYouBean.setKanryoKensuu(gmKmkNzHtYouBean.getKanryoKensuu().add(
                                touJituCountOfTaskSummaryByTaskBean.getCountOfprocessFinToday()));

                            kanryouKensuuInsFlg = true;
                            break;
                        }
                    }

                    if (!kanryouKensuuInsFlg) {

                        if (!BizUtil.isBlank(touJituCountOfTaskSummaryByTaskBean.getUserId())) {
                            TaskuserInfo3DataSourceBean touGmKmkBean = new TaskuserInfo3DataSourceBean();

                            touGmKmkBean.setDisptantounm(touJituCountOfTaskSummaryByTaskBean.getDispUserNm());
                            touGmKmkBean.setKanryoKensuu(touJituCountOfTaskSummaryByTaskBean.getCountOfprocessFinToday());

                            touGmKmkBeanList.add(touGmKmkBean);
                        }
                    }
                }
            }

            for (TaskuserInfo3DataSourceBean gmKmkNzHtYouBean : gmKmkNzHtYouBeanList) {

                TaskuserInfo3DataSourceBean pTaskuserInfo3DataSource = new TaskuserInfo3DataSourceBean();

                pTaskuserInfo3DataSource.setDisptantounm(gmKmkNzHtYouBean.getDisptantounm());
                pTaskuserInfo3DataSource.setKanryoKensuu(gmKmkNzHtYouBean.getKanryoKensuu());

                pTaskuserInfo3.add(pTaskuserInfo3DataSource);
            }

            for (TaskuserInfo3DataSourceBean touGmKmkBean : touGmKmkBeanList) {

                TaskuserInfo3DataSourceBean pTaskuserInfo3DataSource = new TaskuserInfo3DataSourceBean();

                pTaskuserInfo3DataSource.setDisptantounm(touGmKmkBean.getDisptantounm());
                pTaskuserInfo3DataSource.setKanryoKensuu(touGmKmkBean.getKanryoKensuu());

                pTaskuserInfo3.add(pTaskuserInfo3DataSource);
            }
        }

        uiBean.setTaskuserInfo3(pTaskuserInfo3);
        uiBean.setDisptasknm(uiBean.getTaskuserInfo2DataSource().getSelectedBean().getDisptasknm());
    }

}
