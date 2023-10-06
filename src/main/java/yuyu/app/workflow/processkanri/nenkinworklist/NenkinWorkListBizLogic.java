package yuyu.app.workflow.processkanri.nenkinworklist;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.bizinfr.message.Message;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.web.message.MessageManager;
import jp.co.slcs.swak.web.ui.LabelValuePair;
import jp.co.slcs.swak.web.ui.UserDefsList;

import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUiBeanBackupUtil;
import yuyu.common.biz.renkei.WorklistViewValuesBean;
import yuyu.common.biz.renkei.WorklistViewValuesCreator;
import yuyu.common.biz.workflow.WorkflowRenkeiInfo;
import yuyu.common.workflow.workflowutility.ExecutableTaskInfoBean;
import yuyu.common.workflow.workflowutility.GetExecutableTasksForWorkListResultBean;
import yuyu.common.workflow.workflowutility.GetLockInfoResultBean;
import yuyu.common.workflow.workflowutility.GetTasksForWorkListResultBean;
import yuyu.common.workflow.workflowutility.TaskSummaryForWorkListBean;
import yuyu.common.workflow.workflowutility.WorkFlowResultConstants;
import yuyu.common.workflow.workflowutility.WorkFlowUtility;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_TaskKbn;
import yuyu.def.db.entity.DM_Jimutetuzuki;
import yuyu.def.db.entity.DT_WfSentakujyotaiHozon;
import yuyu.def.workflow.manager.WorkflowDomManager;

import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * 年金支払工程ワークリスト のビジネスロジックです。
 */
public class NenkinWorkListBizLogic {

    @Inject
    private static Logger logger;

    @Inject
    private NenkinWorkListUiBean uiBean;

    @Inject
    private NenkinWorkListSearchKeyInputBean searchKeyInputBean;

    @Inject
    BaseDomManager baseDomManager;

    @Inject
    WorkflowDomManager workflowDomManager;

    @Inject
    private MessageManager messageManager;

    @Inject
    BaseUserInfo baseUserInfo;

    @Inject
    private WorkflowRenkeiInfo renkeiInfo;

    void init() {
        clear();
        BizPropertyInitializer.initialize(uiBean);

        String[] pSubSystemId = { NenkinWorkListConstants.NENKIN };

        setJimuTetuzukiInfoList(pSubSystemId);

        DT_WfSentakujyotaiHozon searchCond = getSearchCond(baseUserInfo.getUserId());

        if (searchCond != null) {

            setSearchCondToUiBean(searchCond);

        } else {
            searchCond = new DT_WfSentakujyotaiHozon();
        }

        getSearchResult(searchCond);

    }

    void fromHozenWorkListTest() {

        renkeiInfo.setJimuTetuzukiCd("");
        renkeiInfo.setGyoumuKey("");
        renkeiInfo.setTaskId("");

        BizUiBeanBackupUtil.restore(uiBean, searchKeyInputBean);

        getSearchResult(getSearchKeyInputInfo());

    }

    void dispErrorMessages() {
        if (isError()) {
            for (Message message : renkeiInfo.getExceptionInstance().getMessages()) {
                messageManager.addMessage(message);
            }
        }
    }

    boolean isError() {
        return renkeiInfo.getExceptionInstance() != null;
    }

    void setExceptionInstance(BizLogicException pExeptioninstance) {
        renkeiInfo.setExceptionInstance(pExeptioninstance);
    }

    void messageManagerClear() {
        messageManager.clear();
    }

    void clear() {
        uiBean.setJimutetuzukicd(null);

        uiBean.clearJimutetuzukicdOptionBeanList();

        uiBean.getResultInfoTskSntkBaseDataSource().setDatas(null);
    }

    @Transactional
    void joukenHozonBtnOnClick() {
        logger.info("工程ワークリスト機能 条件保存を起動しました。");

        checkInputDate();

        checkInputJimucode();

        saveSearchCond();

    }

    void saisetteiBtnOnClick() {
        logger.info("工程ワークリスト機能 検索条件再取得を起動しました。");

        DT_WfSentakujyotaiHozon searchCond = getSearchCond(baseUserInfo.getUserId());

        if (searchCond != null) {
            setSearchCondToUiBean(searchCond);

        } else {
            throw new BizLogicException(MessageId.EDF0012);
        }
    }

    void searchBtnOnClick() {
        logger.info("工程ワークリスト機能 検索を起動しました。");

        checkInputDate();

        checkInputJimucode();

        DT_WfSentakujyotaiHozon searchCond = getSearchKeyInputInfo();

        getSearchResult(searchCond);

    }

    String taskSntkNyuuryokuLinkOnClick(C_TaskKbn pTasksentakujoutai) {

        uiBean.setTasksentakujoutai(pTasksentakujoutai);

        String jimutetuzukiCd = uiBean.getResultInfoTskSntkDataSource().getSelectedBean().getJimutetuzukicd();
        String taskId = uiBean.getResultInfoTskSntkDataSource().getSelectedBean().getTskId();

        if (!NenkinWorkListConstants.NENKIN_KINOUIDMAP.containsKey(jimutetuzukiCd + taskId)) {
            throw new BizAppException(MessageId.EAS0037);
        }
        if (NenkinWorkListConstants.NENKIN_KINOUIDMAP.get(jimutetuzukiCd + taskId) == null) {
            throw new BizLogicException(MessageId.EDF1001);
        }

        GetTasksForWorkListResultBean itiranresult = getTasksForWorkList();

        if (WorkFlowResultConstants.RESULT_NODATA.equals(itiranresult.getSyorikekkaStatus())) {
            messageManager.addMessageId(MessageId.IDF0001);
            return null;
        }
        if(!WorkFlowResultConstants.RESULT_OK.equals(itiranresult.getSyorikekkaStatus())) {
            if (itiranresult.getSyousaiMessageCd().equals("IWF2160")) {
                messageManager.addMessageId(MessageId.IBF0024);
                return null;
            }
            throw new BizAppException(MessageId.EAS0037);
        }

        List<TaskSummaryForWorkListBean> taskSummaryForWorkListBeanList = itiranresult
            .getTaskSummaryForWorkListBeanList();

        String key = "";
        TaskSummaryForWorkListBean tempresult = null;
        for (int i = 0; i < taskSummaryForWorkListBeanList.size(); i++) {
            if (taskSummaryForWorkListBeanList.get(i).getNyuuryokuKahi()) {
                tempresult = taskSummaryForWorkListBeanList.get(i);

                GetLockInfoResultBean lockResult = WorkFlowUtility.getLockInfo(tempresult.getKouteiKnrId());

                if (WorkFlowResultConstants.RESULT_OK.equals(lockResult.getSyorikekkaStatus())) {
                    String tempJimuTetuzukiCd = tempresult.getJimutetuzukiCd();
                    renkeiInfo.setJimuTetuzukiCd(tempJimuTetuzukiCd);

                    String tempTaskId = tempresult.getNowTaskNm();
                    renkeiInfo.setTaskId(tempTaskId);

                    renkeiInfo.setGyoumuKey(tempresult.getKouteiKnrId());

                    key = tempJimuTetuzukiCd + tempTaskId;
                    break;
                }
            }
        }
        if (key.equals("")) {
            if (taskSummaryForWorkListBeanList.get(0).getNyuuryokuKahi()) {
                String tempJimuTetuzukiCd = taskSummaryForWorkListBeanList.get(0).getJimutetuzukiCd();
                renkeiInfo.setJimuTetuzukiCd(tempJimuTetuzukiCd);

                String tempTaskId = taskSummaryForWorkListBeanList.get(0).getNowTaskNm();
                renkeiInfo.setTaskId(tempTaskId);

                renkeiInfo.setGyoumuKey(taskSummaryForWorkListBeanList.get(0).getKouteiKnrId());

                key = tempJimuTetuzukiCd + tempTaskId;
            }
        }

        if (tempresult == null) {
            messageManager.addMessageId(MessageId.IDF0001);
            return null;
        }

        return NenkinWorkListConstants.NENKIN_KINOUIDMAP.get(key);

    }

    String itiranLinkOnClick(C_TaskKbn pTasksentakujoutai) {

        uiBean.setTasksentakujoutai(pTasksentakujoutai);

        GetTasksForWorkListResultBean itiranresult = getTasksForWorkList();

        if (WorkFlowResultConstants.RESULT_NODATA.equals(itiranresult.getSyorikekkaStatus())) {
            messageManager.addMessageId(MessageId.IDF0001);
            return null;
        }
        if (!WorkFlowResultConstants.RESULT_OK.equals(itiranresult.getSyorikekkaStatus())) {
            if (itiranresult.getSyousaiMessageCd().equals("IWF2160")) {
                messageManager.addMessageId(MessageId.IBF0024);
                return null;
            }
            throw new BizAppException(MessageId.EAS0037);
        }

        List<ResultInfoItiranDataSourceBean> wkResultInfoItiran = getViewValues(itiranresult
            .getTaskSummaryForWorkListBeanList());

        uiBean.setResultInfoItiran(wkResultInfoItiran);

        uiBean.setTaskId(uiBean.getResultInfoTskSntkDataSource().getSelectedBean().getTskId());

        uiBean.setDispTaskName(uiBean.getResultInfoTskSntkDataSource().getSelectedBean().getWorkflowTskNm());

        uiBean.setItiranJimutetuzukicd(uiBean.getResultInfoTskSntkDataSource().getSelectedBean().getJimutetuzukicd());

        uiBean.setDispjimutetuzukinm(uiBean.getResultInfoTskSntkDataSource().getSelectedBean().getDispjimutetuzukinm());

        uiBean.setNksysyno(searchKeyInputBean.getNksysyno());

        return NenkinWorkListConstants.FORWARDNAME_INPUTKEYANKNITRNNKSHR;

    }

    String anknItrnNyuuryokuLinkOnClick() {


        ResultInfoItiranDataSourceBean tempBean = uiBean.getResultInfoItiranDataSource().getSelectedBean();

        String tempJimuTetuzukiCd = uiBean.getItiranJimutetuzukicd();
        renkeiInfo.setJimuTetuzukiCd(tempJimuTetuzukiCd);

        String tempTaskId = uiBean.getTaskId();
        renkeiInfo.setTaskId(tempTaskId);

        renkeiInfo.setGyoumuKey(tempBean.getKouteiKnrId());

        if (!NenkinWorkListConstants.NENKIN_KINOUIDMAP.containsKey(tempJimuTetuzukiCd + tempTaskId)) {
            throw new BizAppException(MessageId.EAS0037);
        }
        if (NenkinWorkListConstants.NENKIN_KINOUIDMAP.get(tempJimuTetuzukiCd + tempTaskId) == null) {
            throw new BizLogicException(MessageId.EDF1001);
        }

        return NenkinWorkListConstants.NENKIN_KINOUIDMAP.get(tempJimuTetuzukiCd + tempTaskId);

    }

    @SuppressWarnings("deprecation")
    void modorubtnOnClick() {

        BizUiBeanBackupUtil.restore(uiBean, searchKeyInputBean);

        uiBean.setPageNo(NenkinWorkListConstants.PAGENO_INPUTKEYTSKSNTKNKSHR);

        getSearchResult(getSearchKeyInputInfo());

    }

    private static UserDefsList insertBlank(Iterable<LabelValuePair> optionList) {
        UserDefsList list = new UserDefsList();
        list.addAll(
            ImmutableList.<LabelValuePair> builder()
            .add(
                new LabelValuePair(
                    NenkinWorkListConstants.BLANK,
                    NenkinWorkListConstants.BLANK
                    )
                )
                .addAll(optionList)
                .build()
            );
        return list;
    }

    private void setJimuTetuzukiInfoList(String[] pSubSystemId) {
        uiBean.setJimutetuzukicdOptionBeanList(
            insertBlank(
                Iterables.transform(
                    workflowDomManager.getJimutetuzukisBySubSystemIds(pSubSystemId)
                    ,
                    new Function<DM_Jimutetuzuki, LabelValuePair>() {
                        @Override
                        public LabelValuePair apply(DM_Jimutetuzuki jimutetuzuki) {
                            return new LabelValuePair(
                                jimutetuzuki.getJimutetuzukinm(),
                                jimutetuzuki.getJimutetuzukicd()
                                );
                        }
                    }
                    )
                )
            );

    }

    private void getSearchResult(DT_WfSentakujyotaiHozon pSearchCond) {

        int pageNo = uiBean.getPageNo();

        if (pageNo == NenkinWorkListConstants.PAGENO_INPUTKEYTSKSNTKNKSHR) {

            uiBean.setResultInfoTskSntk(null);
            uiBean.setResultInfoTskSntkBase(null);

            BizUiBeanBackupUtil.backup(uiBean, searchKeyInputBean);

            getSearchResultTskSntk(pSearchCond);

        } else {

            uiBean.setResultInfoItiran(null);

            BizUiBeanBackupUtil.backup(uiBean, searchKeyInputBean);

            getSearchResultAnknItrn(pSearchCond);

        }
    }

    private GetTasksForWorkListResultBean getTasksForWorkList() {
        String taskSentaku = uiBean.getTasksentakujoutai() == C_TaskKbn.KOJIN ? "0" : "1";

        String jimutetuzukiCd;
        if (uiBean.getPageNo() == NenkinWorkListConstants.PAGENO_INPUTKEYTSKSNTKNKSHR) {
            jimutetuzukiCd = uiBean.getResultInfoTskSntkDataSource().getSelectedBean().getJimutetuzukicd();
        } else {
            jimutetuzukiCd = uiBean.getItiranJimutetuzukicd();
        }

        String taskId;
        if (uiBean.getPageNo() == NenkinWorkListConstants.PAGENO_INPUTKEYTSKSNTKNKSHR) {
            taskId = uiBean.getResultInfoTskSntkDataSource().getSelectedBean().getTskId();
        } else {
            taskId = uiBean.getTaskId();
        }
        String jimuyouCdKbn = searchKeyInputBean.getJmycdMisetteiKbn() ? "0" : "1";

        String pJimuKaisiYmdFrom = "";
        if (searchKeyInputBean.getJimustartYmdFrom() != null) {
            pJimuKaisiYmdFrom = searchKeyInputBean.getJimustartYmdFrom().toString();
        }
        String pJimuKaisiYmdTo = "";
        if (searchKeyInputBean.getJimustartYmdTo() != null) {
            pJimuKaisiYmdTo = searchKeyInputBean.getJimustartYmdTo().toString();
        }

        GetTasksForWorkListResultBean itiranresult =
            WorkFlowUtility.getTasksForWorkList(
                NenkinWorkListConstants.NENKIN,
                null,
                null,
                searchKeyInputBean.getNksysyno(),
                jimutetuzukiCd,
                pJimuKaisiYmdFrom,
                pJimuKaisiYmdTo,
                searchKeyInputBean.getJimuyoucd(),
                jimuyouCdKbn,
                baseUserInfo.getUserId(),
                taskSentaku,
                taskId);

        return itiranresult;
    }

    private void getSearchResultTskSntk(DT_WfSentakujyotaiHozon pSearchCond) {
        List<ResultInfoTskSntkDataSourceBean> wkResultInfo = new ArrayList<ResultInfoTskSntkDataSourceBean>();

        String jimuyouCdKbn = searchKeyInputBean.getJmycdMisetteiKbn() ? "0" : "1";

        String pJimuKaisiYmdFrom = "";
        if (searchKeyInputBean.getJimustartYmdFrom() != null) {
            pJimuKaisiYmdFrom = searchKeyInputBean.getJimustartYmdFrom().toString();
        }
        String pJimuKaisiYmdTo = "";
        if (searchKeyInputBean.getJimustartYmdTo() != null) {
            pJimuKaisiYmdTo = searchKeyInputBean.getJimustartYmdTo().toString();
        }
        GetExecutableTasksForWorkListResultBean searchresult =
            WorkFlowUtility.getExecutableTasksForWorkList(
                NenkinWorkListConstants.NENKIN,
                null,
                null,
                searchKeyInputBean.getNksysyno(),
                searchKeyInputBean.getJimutetuzukicd(),
                pJimuKaisiYmdFrom,
                pJimuKaisiYmdTo,
                searchKeyInputBean.getJimuyoucd(),
                jimuyouCdKbn,
                baseUserInfo.getUserId());

        if (searchresult.getSyorikekkaStatus().equals(WorkFlowResultConstants.RESULT_NG)) {
            throw new BizAppException(MessageId.EAS0037);
        }

        List<ResultInfoTskSntkBaseDataSourceBean> wkResultInfoBase = Lists.newArrayList();

        Set<String> jimutetuzukiSet = Sets.newLinkedHashSet();

        if (searchresult.getExecutableTaskInfoBeanList().size() > 0) {
            for (ExecutableTaskInfoBean tempresult : searchresult.getExecutableTaskInfoBeanList()) {
                ResultInfoTskSntkDataSourceBean taskResultInfoDataSourceBean = new ResultInfoTskSntkDataSourceBean();

                taskResultInfoDataSourceBean.setJimutetuzukicd(tempresult.getJimutetuzukiCd());
                taskResultInfoDataSourceBean.setDispjimutetuzukinm(tempresult.getJimutetuzukiNm());
                taskResultInfoDataSourceBean.setTskId(tempresult.getTaskNm());
                taskResultInfoDataSourceBean.setWorkflowTskNm(tempresult.getDispTaskNm());
                taskResultInfoDataSourceBean.setKjnTskKensuu(tempresult.getPersonalizedTaskNum());

                if (tempresult.getPersonalizedTaskNum().compareTo(BizNumber.valueOf(0)) > 0) {
                    taskResultInfoDataSourceBean.setKojinNyuuryokuLink(NenkinWorkListConstants.NYUURYOKU_LINK);
                    taskResultInfoDataSourceBean.setKojinItiranLink(NenkinWorkListConstants.ITIRAN_LINK);
                }

                taskResultInfoDataSourceBean.setKyyTskKensuu(tempresult.getSharedTaskNum());

                if (tempresult.getSharedTaskNum().compareTo(BizNumber.valueOf(0)) > 0) {
                    taskResultInfoDataSourceBean.setKyouyouNyuuryokuLink(NenkinWorkListConstants.NYUURYOKU_LINK);
                    taskResultInfoDataSourceBean.setKyouyouItiranLink(NenkinWorkListConstants.ITIRAN_LINK);
                }

                wkResultInfo.add(taskResultInfoDataSourceBean);

                if (!jimutetuzukiSet.contains(tempresult.getJimutetuzukiCd())) {
                    ResultInfoTskSntkBaseDataSourceBean taskResultInfoBaseDataSourceBean = new ResultInfoTskSntkBaseDataSourceBean();
                    taskResultInfoBaseDataSourceBean.setJimutetuzukicd(tempresult.getJimutetuzukiCd());
                    wkResultInfoBase.add(taskResultInfoBaseDataSourceBean);
                    jimutetuzukiSet.add(tempresult.getJimutetuzukiCd());
                }
            }

            uiBean.setResultInfoTskSntk(wkResultInfo);
            uiBean.setResultInfoTskSntkBase(wkResultInfoBase);
        }
    }

    private void getSearchResultAnknItrn(DT_WfSentakujyotaiHozon pSearchCond) {

        GetTasksForWorkListResultBean itiranresult = getTasksForWorkList();

        if (WorkFlowResultConstants.RESULT_NG.equals(itiranresult.getSyorikekkaStatus()) &&
            itiranresult.getSyousaiMessageCd().equals("IWF2160")) {
            messageManager.addMessageId(MessageId.IBF0024);
            return;
        }

        if (WorkFlowResultConstants.RESULT_NODATA.equals(itiranresult.getSyorikekkaStatus())) {
            messageManager.addMessageId(MessageId.IDF0001);
            return;
        }

        if (!itiranresult.getSyorikekkaStatus().equals(WorkFlowResultConstants.RESULT_OK)) {
            throw new BizAppException(MessageId.EAS0037);
        }

        List<ResultInfoItiranDataSourceBean> wkResultInfoItiran = getViewValues(itiranresult
            .getTaskSummaryForWorkListBeanList());

        uiBean.setResultInfoItiran(wkResultInfoItiran);

    }

    private DT_WfSentakujyotaiHozon getSearchCond(String wkUserId) {
        DT_WfSentakujyotaiHozon searchCond = workflowDomManager.getWfSentakujyotaiHozon(wkUserId,
            NenkinWorkListConstants.NENKIN);

        return searchCond;
    }

    private void setSearchCondToUiBean(DT_WfSentakujyotaiHozon pSearchCond) {

        uiBean.setJimutetuzukicd(pSearchCond.getJimutetuzukicd());

        uiBean.setJimuyoucd(pSearchCond.getJimuyoucd());

        uiBean.setJmycdMisetteiKbn(pSearchCond.getJmycdMisetteiKbn());

        uiBean.setJimustartYmdFrom(pSearchCond.getJimustartYmdFrom());

        uiBean.setJimustartYmdTo(pSearchCond.getJimustartYmdTo());

        uiBean.setNksysyno(pSearchCond.getNksysyno());

    }

    private void checkInputDate() {

        final BizDate jimustartymdfrom = uiBean.getJimustartYmdFrom();

        final BizDate jimustartymdto = uiBean.getJimustartYmdTo();

        if (jimustartymdfrom != null && jimustartymdto != null) {
            if (jimustartymdfrom.intValue() > jimustartymdto.intValue()) {
                throw new BizLogicException(MessageId.EDF0003,
                    new Item[] { GenNenkinWorkListConstants.DDID_SEARCHKEYINPUT_JIMUSTARTYMDFROM,
                    GenNenkinWorkListConstants.DDID_SEARCHKEYINPUT_JIMUSTARTYMDTO },
                    "事務開始日");
            }
        }
    }

    private void checkInputJimucode() {

        final String jimuyoucd = uiBean.getJimuyoucd();
        final Boolean commonCheckBox = uiBean.getJmycdMisetteiKbn();

        if ((!"".equals(jimuyoucd)) && commonCheckBox) {
            throw new BizLogicException(MessageId.EDF0006,
                GenNenkinWorkListConstants.DDID_SEARCHKEYINPUT_JIMUYOUCD,
                GenNenkinWorkListConstants.DDID_SEARCHKEYINPUT_JMYCDMISETTEIKBN);
        }
    }

    private void saveSearchCond() {

        DT_WfSentakujyotaiHozon searchCond = workflowDomManager.getWfSentakujyotaiHozon(baseUserInfo.getUserId(),
            NenkinWorkListConstants.NENKIN);

        if (searchCond == null) {
            searchCond = new DT_WfSentakujyotaiHozon();

            searchCond.setUserId(baseUserInfo.getUserId());
            searchCond.setSubSystemId(NenkinWorkListConstants.NENKIN);

            searchCond.setJimutetuzukicd(uiBean.getJimutetuzukicd());

            searchCond.setJimuyoucd(uiBean.getJimuyoucd());

            searchCond.setJmycdMisetteiKbn(uiBean.getJmycdMisetteiKbn());

            searchCond.setJimustartYmdFrom(uiBean.getJimustartYmdFrom());

            searchCond.setJimustartYmdTo(uiBean.getJimustartYmdTo());

            searchCond.setNksysyno(uiBean.getNksysyno());

            BizPropertyInitializer.initialize(searchCond);

            workflowDomManager.insert(searchCond);

        } else {
            searchCond.setJimutetuzukicd(uiBean.getJimutetuzukicd());

            searchCond.setJimuyoucd(uiBean.getJimuyoucd());

            searchCond.setJmycdMisetteiKbn(uiBean.getJmycdMisetteiKbn());

            searchCond.setJimustartYmdFrom(uiBean.getJimustartYmdFrom());

            searchCond.setJimustartYmdTo(uiBean.getJimustartYmdTo());

            searchCond.setNksysyno(uiBean.getNksysyno());

            BizPropertyInitializer.initialize(searchCond);

            workflowDomManager.update(searchCond);
        }
    }

    private DT_WfSentakujyotaiHozon getSearchKeyInputInfo() {
        DT_WfSentakujyotaiHozon retSearchCond = new DT_WfSentakujyotaiHozon();

        BeanUtil.copyProperties(retSearchCond, uiBean);

        return retSearchCond;
    }

    private List<ResultInfoItiranDataSourceBean> getViewValues(List<TaskSummaryForWorkListBean> pList) {
        List<ResultInfoItiranDataSourceBean> retResultInfoItiran = Lists.newArrayList();

        List<WorklistViewValuesBean> wkList = Lists.newArrayList();

        Locale locale = new Locale("ja","JP","JP");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        SimpleDateFormat sdf2 = new SimpleDateFormat("Gyy/MM/dd HH:mm:ss",locale);

        for (TaskSummaryForWorkListBean tempresult : pList) {

            WorklistViewValuesBean tempbean = new WorklistViewValuesBean();

            if (!Strings.isNullOrEmpty(tempresult.getJimuStartYmd())) {
                try {
                    tempbean.setDispjimustartymdtime(sdf2.format(sdf1.parse(tempresult.getJimuStartYmd())));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

            tempbean.setNksysyno(tempresult.getNkSysyNo());

            tempbean.setMosno(tempresult.getMosNo());

            tempbean.setDispzenkaisyoritantounm(tempresult.getDispPreSyoriTantouNm());

            tempbean.setDispzenkaisyoritask(tempresult.getDispPreTaskNm());

            tempbean.setJimutetuzukiCd(tempresult.getJimutetuzukiCd());

            tempbean.setKouteiKnrId(tempresult.getKouteiKnrId());

            tempbean.setSyouhinCd(tempresult.getSyouhinCd());

            wkList.add(tempbean);
        }

        List<WorklistViewValuesBean> retList = WorklistViewValuesCreator.createValues(
            NenkinWorkListConstants.NENKIN, wkList);

        for (int cnt = 0; cnt < retList.size(); cnt++) {
            ResultInfoItiranDataSourceBean tempItiranBean = new ResultInfoItiranDataSourceBean();

            tempItiranBean.setDispjimustartymdtime(retList.get(cnt).getDispjimustartymdtime());

            tempItiranBean.setNksysyno(retList.get(cnt).getNksysyno());

            String dispzenkaisyoritask = retList.get(cnt).getDispzenkaisyoritask();

            if (dispzenkaisyoritask != null) {
                tempItiranBean.setDispzenkaisyoritask(dispzenkaisyoritask.length() > 20 ? dispzenkaisyoritask
                    .substring(0, 20) : dispzenkaisyoritask);
            }

            tempItiranBean.setDispzenkaisyoritantounm(retList.get(cnt).getDispzenkaisyoritantounm());

            tempItiranBean.setKouteiKnrId(retList.get(cnt).getKouteiKnrId());

            String nenKinuktnmKanji = retList.get(cnt).getNenkinuktnmkanji();
            tempItiranBean.setNenkinuktnmkanji(nenKinuktnmKanji.length() > 20 ? nenKinuktnmKanji.substring(0, 20)
                : nenKinuktnmKanji);

            if (pList.get(cnt).getNyuuryokuKahi()) {
                tempItiranBean.setNyuuryokuLink(NenkinWorkListConstants.NYUURYOKU_LINK);
            }

            retResultInfoItiran.add(tempItiranBean);
        }

        return retResultInfoItiran;
    }

}
