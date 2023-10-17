package yuyu.app.workflow.processkanri.tantousyabetusyoritasksyoukai;

import static yuyu.app.workflow.processkanri.tantousyabetusyoritasksyoukai.GenTantousyabetuSyoriTaskSyoukaiConstants.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.workflow.wfcommon.GetExecutableSubSystemsSelectInBean;
import yuyu.common.workflow.wfcommon.GetExecutableSubSystemsSelectOutBean;
import yuyu.common.workflow.wfcommon.WfUserSelectCommon;
import yuyu.common.workflow.workflowutility.GetSumiTaskByUserResultBean;
import yuyu.common.workflow.workflowutility.WorkFlowResultConstants;
import yuyu.common.workflow.workflowutility.WorkFlowUtility;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.entity.AM_User;

/**
 * 担当者別処理タスク照会 のビジネスロジックです。
 */
public class TantousyabetuSyoriTaskSyoukaiBizLogic {

    @Inject
    private static Logger logger;

    @Inject
    private TantousyabetuSyoriTaskSyoukaiUiBean uiBean;

    @Inject
    BaseDomManager baseDomManager;

    @Inject
    BaseUserInfo baseUserInfo;

    void init() {

        logger.info("担当者別処理タスク照会機能を起動しました。");

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

        uiBean.setSyoriYmdFrom(BizDate.getSysDate());
        uiBean.setSyoriYmdTo(BizDate.getSysDate());
    }

    void clear() {


        uiBean.setSubSystemId(null);
        uiBean.setUserId(null);
        uiBean.setUserNm(null);
        uiBean.setSyoriYmdFrom(null);
        uiBean.setSyoriYmdTo(null);

        uiBean.clearSubSystemIdOptionBeanList();

    }

    void searchBtnOnClick() {

        logger.info("担当者別処理タスク照会機能 検索を起動しました。");


        if (BizDateUtil.compareYmd(uiBean.getSyoriYmdFrom(), uiBean.getSyoriYmdTo()) == BizDateUtil.COMPARE_GREATER) {
            throw new BizLogicException(MessageId.EDF0003, new Item[] { DDID_SEARCHKEYINPUT_SYORIYMDFROM
                , DDID_SEARCHKEYINPUT_SYORIYMDTO },
                MessageUtil.getMessage(DDID_SEARCHKEYINPUT_SYORIYMDFROM.getErrorResourceKey()
                    , DDID_SEARCHKEYINPUT_SYORIYMDTO.getErrorResourceKey()));
        }

        if (BizDateUtil.compareYmd(uiBean.getSyoriYmdFrom(), BizDate.getSysDate()) == BizDateUtil.COMPARE_GREATER) {
            throw new BizLogicException(MessageId.EBA0026, new Item[] { DDID_SEARCHKEYINPUT_SYORIYMDFROM
                , DDID_SEARCHKEYINPUT_SYORIYMDTO },
                MessageUtil.getMessage(DDID_SEARCHKEYINPUT_SYORIYMDFROM.getErrorResourceKey()
                    , DDID_SEARCHKEYINPUT_SYORIYMDTO.getErrorResourceKey()));
        }

        if (BizDateUtil.compareYmd(uiBean.getSyoriYmdTo(), BizDate.getSysDate()) == BizDateUtil.COMPARE_GREATER) {
            throw new BizLogicException(MessageId.EBA0026, new Item[] { DDID_SEARCHKEYINPUT_SYORIYMDTO },
                MessageUtil.getMessage(DDID_SEARCHKEYINPUT_SYORIYMDTO.getErrorResourceKey()));
        }

        if (BizDateUtil.compareYmd(uiBean.getSyoriYmdFrom().addMonths(1), uiBean.getSyoriYmdTo()) == BizDateUtil.COMPARE_LESSER) {
            throw new BizLogicException(MessageId.EDF1014, new Item[] { DDID_SEARCHKEYINPUT_SYORIYMDFROM
                , DDID_SEARCHKEYINPUT_SYORIYMDTO },
                MessageUtil.getMessage(DDID_SEARCHKEYINPUT_SYORIYMDFROM.getErrorResourceKey()
                    , DDID_SEARCHKEYINPUT_SYORIYMDTO.getErrorResourceKey()));

        }
        if (BizDateUtil.compareYmd(uiBean.getSyoriYmdTo(), BizDate.getSysDate().addYears(-1)) == BizDateUtil.COMPARE_LESSER
            || BizDateUtil.compareYmd(uiBean.getSyoriYmdTo(), BizDate.getSysDate().addYears(-1)) == BizDateUtil.COMPARE_EQUAL) {
            throw new BizLogicException(MessageId.EDF1015, new Item[] { DDID_SEARCHKEYINPUT_SYORIYMDFROM
                , DDID_SEARCHKEYINPUT_SYORIYMDTO },
                MessageUtil.getMessage(DDID_SEARCHKEYINPUT_SYORIYMDFROM.getErrorResourceKey()
                    , DDID_SEARCHKEYINPUT_SYORIYMDTO.getErrorResourceKey()));
            }
        if (BizDateUtil.compareYmd(uiBean.getSyoriYmdFrom(), BizDate.getSysDate().addYears(-1)) == BizDateUtil.COMPARE_LESSER
            || BizDateUtil.compareYmd(uiBean.getSyoriYmdFrom(), BizDate.getSysDate().addYears(-1)) == BizDateUtil.COMPARE_EQUAL) {
            throw new BizLogicException(MessageId.EDF1015, new Item[] { DDID_SEARCHKEYINPUT_SYORIYMDFROM },
                MessageUtil.getMessage(DDID_SEARCHKEYINPUT_SYORIYMDFROM.getErrorResourceKey()));
        }


        String wkSubSystemId = uiBean.getSubSystemId();
        String wkUserId = uiBean.getUserId();
        String wkUserNm = uiBean.getUserNm();

        AM_User amUser = baseDomManager.getUser(wkUserId);
        if (amUser != null) {
            wkUserNm = amUser.getUserNm();
        }
        else{
            wkUserNm = "";
        }


        List<TaskserInfoDataSourceBean> taskuserInfoLst = new ArrayList<>();
        List<GetSumiTaskByUserResultBean> sumiTaskDataBeanLst = new ArrayList<>();



        logger.info("【ワークフロー呼出Utility#処理済みタスク取得(ユーザーID・フローIDリスト・処理年月日（自）・処理年月日（至）指定)】実施");

        GetSumiTaskByUserResultBean result =
            WorkFlowUtility.getSumiTaskByUser(wkSubSystemId, wkUserId, uiBean.getSyoriYmdFrom(),
                uiBean.getSyoriYmdTo());

        if (WorkFlowResultConstants.RESULT_NODATA.equals(result.getSyorikekkaStatus())) {
            uiBean.getTaskserInfoDataSource().setDatas(null);
            throw new BizLogicException(MessageId.EAC0014);
        }
        else if (WorkFlowResultConstants.RESULT_OK.equals(result.getSyorikekkaStatus())) {
            sumiTaskDataBeanLst = result.getSumiTaskBeanList();
        }
        else {
            logger.error("ワークフロー呼出Utility#処理済みタスク取得(ユーザーID・フローIDリスト・処理年月日（自）・処理年月日（至）指定)");
            logger.error("エラーコード：" + result.getSyousaiMessageCd());
            logger.error("エラーメッセージ：" + result.getSyousaiMessage());
            throw new BizAppException(MessageId.EAS0037);
        }

        for (GetSumiTaskByUserResultBean sumiTaskDataBean : sumiTaskDataBeanLst) {
            TaskserInfoDataSourceBean taskuserInfo = new TaskserInfoDataSourceBean();

            taskuserInfo.setDispjimutetuzukinm(sumiTaskDataBean.getJimutetuzukinm());
            taskuserInfo.setDispGyoumuKey(sumiTaskDataBean.getGyoumuKey());
            taskuserInfo.setDispsyoritime(sumiTaskDataBean.getSyoritime());
            taskuserInfo.setDisptasknm(sumiTaskDataBean.getTasknm());
            taskuserInfo.setDisphknsyuruiworklist(sumiTaskDataBean.getHknsyuruiworklist());
            taskuserInfo.setDisptratkiagnm1(sumiTaskDataBean.getTratkiagnm1());
            taskuserInfo.setDispkyknmkj(sumiTaskDataBean.getKyknmkj());
            taskuserInfo.setDispkyknmkn(sumiTaskDataBean.getKyknmkn());

            taskuserInfoLst.add(taskuserInfo);

        }
        uiBean.setSubSystemId(wkSubSystemId);
        uiBean.setUserId(wkUserId);
        uiBean.setUserNm(wkUserNm);
        uiBean.setTaskserInfo(taskuserInfoLst);

        if (wkSubSystemId.equals(TantousyabetuSyoriTaskSyoukaiConstants.E_SubSystem.SINKEIYAKU.getName())) {
            uiBean.setGyoumukeylbl(TantousyabetuSyoriTaskSyoukaiConstants.LBL_GYOUMUKEY_SINKEIYAKU);
        } else if (wkSubSystemId.equals(TantousyabetuSyoriTaskSyoukaiConstants.E_SubSystem.KEIYAKUHOZEN.getName())) {
            uiBean.setGyoumukeylbl(TantousyabetuSyoriTaskSyoukaiConstants.LBL_GYOUMUKEY_KEIYAKUHOZEN);
        } else if (wkSubSystemId.equals(TantousyabetuSyoriTaskSyoukaiConstants.E_SubSystem.HOKENKYUHUSIHARAI.getName())) {
            uiBean.setGyoumukeylbl(TantousyabetuSyoriTaskSyoukaiConstants.LBL_GYOUMUKEY_HOKENKYUHUSIHARAI);
        } else {
            uiBean.setGyoumukeylbl(TantousyabetuSyoriTaskSyoukaiConstants.LBL_GYOUMUKEY_NENKINSIHARAI);
        }

    }
}
