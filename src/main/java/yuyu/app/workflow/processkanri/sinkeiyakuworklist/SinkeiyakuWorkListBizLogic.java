package yuyu.app.workflow.processkanri.sinkeiyakuworklist;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
import yuyu.common.workflow.workflowutility.GetExecutableTasksForWorkListSkResultBean;
import yuyu.common.workflow.workflowutility.GetLockInfoResultBean;
import yuyu.common.workflow.workflowutility.GetTasksForWorkListSkResultBean;
import yuyu.common.workflow.workflowutility.TaskSummaryForWorkListBean;
import yuyu.common.workflow.workflowutility.WorkFlowResultConstants;
import yuyu.common.workflow.workflowutility.WorkFlowUtility;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_TaskKbn;
import yuyu.def.db.entity.BM_Dairiten;
import yuyu.def.db.entity.DT_WfSentakujyotaiHozon;
import yuyu.def.db.entity.HM_SkHokenSyuruiNo;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.def.workflow.manager.WorkflowDomManager;

import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.common.collect.Sets;

/**
 * 新契約工程ワークリスト のビジネスロジックです。
 */
public class SinkeiyakuWorkListBizLogic {

    @Inject
    private static Logger logger;

    @Inject
    private SinkeiyakuWorkListUiBean uiBean;

    @Inject
    private SinkeiyakuWorkListSearchKeyInputBean searchKeyInputBean;

    @Inject
    BaseDomManager baseDomManager;

    @Inject
    BizDomManager bizDomManager;

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

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

        List<HM_SkHokenSyuruiNo> skHokenSyuruiNoLst =
            sinkeiyakuDomManager.getSkHokenSyuruiNosBySysdate(BizDate.getSysDate());

        UserDefsList list = new UserDefsList();

        list.addAll(
            ImmutableList.<LabelValuePair>builder()
            .addAll(
                Iterables.transform(
                    skHokenSyuruiNoLst,
                    new Function<HM_SkHokenSyuruiNo, LabelValuePair>() {
                        @Override
                        public LabelValuePair apply(HM_SkHokenSyuruiNo skHokenSyuruiNo) {
                            return new LabelValuePair(skHokenSyuruiNo.getHknsyuruino().getContent(
                                C_HknsyuruiNo.PATTERN_AISYOUMEI),
                                skHokenSyuruiNo.getHknsyuruino().getValue());
                        }
                    }
                    )
                ).build());

        uiBean.setDisphknsyuruiworklistOptionBeanList(
            list);

        DT_WfSentakujyotaiHozon searchCond = getSearchCond(baseUserInfo.getUserId());

        if(searchCond != null){

            List<String> dairitenCdList = Lists.newArrayList();
            if(!Strings.isNullOrEmpty(searchCond.getDairitencd1())){
                dairitenCdList.add(searchCond.getDairitencd1());
            }
            if(!Strings.isNullOrEmpty(searchCond.getDairitencd2())){
                dairitenCdList.add(searchCond.getDairitencd2());
            }
            if(!Strings.isNullOrEmpty(searchCond.getDrtencd3())){
                dairitenCdList.add(searchCond.getDrtencd3());
            }
            if(!Strings.isNullOrEmpty(searchCond.getDrtencd4())){
                dairitenCdList.add(searchCond.getDrtencd4());
            }
            if(!Strings.isNullOrEmpty(searchCond.getDrtencd5())){
                dairitenCdList.add(searchCond.getDrtencd5());
            }

            String[] dairitenCd = null;
            List<BM_Dairiten> bmDairitenLst = null;
            if(dairitenCdList.size() > 0){
                dairitenCd = dairitenCdList.toArray(new String[dairitenCdList.size()]);
                bmDairitenLst = bizDomManager.getDairitensByDrtencds(dairitenCd);
            }

            setSearchCondToUiBean(searchCond, bmDairitenLst);

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

        uiBean.getResultInfoTskSntkBaseDataSource().setDatas(null);
        uiBean.getResultInfoTskSntkDataSource().setDatas(null);
        uiBean.getResultInfoItiranDataSource().setDatas(null);

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

        if(searchCond != null){
            List<String> dairitenCdList = Lists.newArrayList();
            if(!Strings.isNullOrEmpty(searchCond.getDairitencd1())){
                dairitenCdList.add(searchCond.getDairitencd1());
            }
            if(!Strings.isNullOrEmpty(searchCond.getDairitencd2())){
                dairitenCdList.add(searchCond.getDairitencd2());
            }
            if(!Strings.isNullOrEmpty(searchCond.getDrtencd3())){
                dairitenCdList.add(searchCond.getDrtencd3());
            }
            if(!Strings.isNullOrEmpty(searchCond.getDrtencd4())){
                dairitenCdList.add(searchCond.getDrtencd4());
            }
            if(!Strings.isNullOrEmpty(searchCond.getDrtencd5())){
                dairitenCdList.add(searchCond.getDrtencd5());
            }

            String[] dairitenCd = null;
            List<BM_Dairiten> bmDairitenLst = null;
            if(dairitenCdList.size() > 0){
                dairitenCd = dairitenCdList.toArray(new String[dairitenCdList.size()]);
                bmDairitenLst = bizDomManager.getDairitensByDrtencds(dairitenCd);
            }

            uiBean.setDairitenkinyuukikancd1(null);
            uiBean.setDairitenkinyuukikancd2(null);
            uiBean.setDairitenkinyuukikancd3(null);
            uiBean.setDairitenkinyuukikancd4(null);
            uiBean.setDairitenkinyuukikancd5(null);
            uiBean.setDispdrtennm1(null);
            uiBean.setDispdrtennm2(null);
            uiBean.setDispdrtennm3(null);
            uiBean.setDispdrtennm4(null);
            uiBean.setDispdrtennm5(null);

            setSearchCondToUiBean(searchCond, bmDairitenLst);

        } else {
            throw new BizLogicException(MessageId.EDF0012);
        }
    }

    @SuppressWarnings("null")
    void searchBtnOnClick() {
        logger.info("工程ワークリスト機能 検索を起動しました。");

        checkInputDate();

        checkInputJimucode();

        checkInputKinyuuDairitencd();

        List<BM_Dairiten> bmDairitenLstKinyuu = checkOyadairitencdExist();

        List<String> dairitenCdList = Lists.newArrayList();
        if(!Strings.isNullOrEmpty(uiBean.getDairitencd1())){
            dairitenCdList.add(uiBean.getDairitencd1());
        }
        if(!Strings.isNullOrEmpty(uiBean.getDairitencd2())){
            dairitenCdList.add(uiBean.getDairitencd2());
        }
        if(!Strings.isNullOrEmpty(uiBean.getDrtencd3())){
            dairitenCdList.add(uiBean.getDrtencd3());
        }
        if(!Strings.isNullOrEmpty(uiBean.getDrtencd4())){
            dairitenCdList.add(uiBean.getDrtencd4());
        }
        if(!Strings.isNullOrEmpty(uiBean.getDrtencd5())){
            dairitenCdList.add(uiBean.getDrtencd5());
        }

        String[] dairitenCd = null;
        List<BM_Dairiten> bmDairitenLstDairi = null;
        if(dairitenCdList.size() > 0){
            dairitenCd = dairitenCdList.toArray(new String[dairitenCdList.size()]);
            bmDairitenLstDairi = bizDomManager.getDairitensByDrtencds(dairitenCd);
        }

        String wkDispdrtennm1 = null;
        String wkDispdrtennm2 = null;
        String wkDispdrtennm3 = null;
        String wkDispdrtennm4 = null;
        String wkDispdrtennm5 = null;

        if(!Strings.isNullOrEmpty(uiBean.getDairitencd1())){
            for (int i = 0; i < bmDairitenLstDairi.size(); i++) {
                if (uiBean.getDairitencd1().equals(bmDairitenLstDairi.get(i).getDrtencd())) {
                    wkDispdrtennm1 = bmDairitenLstDairi.get(i).getKanjidairitennm();
                }
            }
        }

        if(!Strings.isNullOrEmpty(uiBean.getDairitencd2())){
            for (int i = 0; i < bmDairitenLstDairi.size(); i++) {
                if (uiBean.getDairitencd2().equals(bmDairitenLstDairi.get(i).getDrtencd())) {
                    wkDispdrtennm2 = bmDairitenLstDairi.get(i).getKanjidairitennm();
                }
            }
        }

        if(!Strings.isNullOrEmpty(uiBean.getDrtencd3())){
            for (int i = 0; i < bmDairitenLstDairi.size(); i++) {
                if (uiBean.getDrtencd3().equals(bmDairitenLstDairi.get(i).getDrtencd())) {
                    wkDispdrtennm3 = bmDairitenLstDairi.get(i).getKanjidairitennm();
                }
            }
        }

        if(!Strings.isNullOrEmpty(uiBean.getDrtencd4())){
            for (int i = 0; i < bmDairitenLstDairi.size(); i++) {
                if (uiBean.getDrtencd4().equals(bmDairitenLstDairi.get(i).getDrtencd())) {
                    wkDispdrtennm4 = bmDairitenLstDairi.get(i).getKanjidairitennm();
                }
            }
        }

        if(!Strings.isNullOrEmpty(uiBean.getDrtencd5())){
            for (int i = 0; i < bmDairitenLstDairi.size(); i++) {
                if (uiBean.getDrtencd5().equals(bmDairitenLstDairi.get(i).getDrtencd())) {
                    wkDispdrtennm5 = bmDairitenLstDairi.get(i).getKanjidairitennm();
                }
            }
        }

        if(!Strings.isNullOrEmpty(uiBean.getDairitenkinyuukikancd1())){
            uiBean.setDairitencd1(bmDairitenLstKinyuu.get(0).getDrtencd());
        }
        if(!Strings.isNullOrEmpty(uiBean.getDairitenkinyuukikancd2())){
            uiBean.setDairitencd2(bmDairitenLstKinyuu.get(1).getDrtencd());
        }
        if(!Strings.isNullOrEmpty(uiBean.getDairitenkinyuukikancd3())){
            uiBean.setDrtencd3(bmDairitenLstKinyuu.get(2).getDrtencd());
        }
        if(!Strings.isNullOrEmpty(uiBean.getDairitenkinyuukikancd4())){
            uiBean.setDrtencd4(bmDairitenLstKinyuu.get(3).getDrtencd());
        }
        if(!Strings.isNullOrEmpty(uiBean.getDairitenkinyuukikancd5())){
            uiBean.setDrtencd5(bmDairitenLstKinyuu.get(4).getDrtencd());
        }

        if(!Strings.isNullOrEmpty(uiBean.getDairitenkinyuukikancd1())){
            uiBean.setDispdrtennm1(bmDairitenLstKinyuu.get(0).getKanjidairitennm());
        } else if (!Strings.isNullOrEmpty(uiBean.getDairitencd1())) {
            uiBean.setDispdrtennm1(wkDispdrtennm1);
        } else {
            uiBean.setDispdrtennm1("");
        }
        if(!Strings.isNullOrEmpty(uiBean.getDairitenkinyuukikancd2())){
            uiBean.setDispdrtennm2(bmDairitenLstKinyuu.get(1).getKanjidairitennm());
        } else if (!Strings.isNullOrEmpty(uiBean.getDairitencd2())) {
            uiBean.setDispdrtennm2(wkDispdrtennm2);
        } else {
            uiBean.setDispdrtennm2("");
        }
        if(!Strings.isNullOrEmpty(uiBean.getDairitenkinyuukikancd3())){
            uiBean.setDispdrtennm3(bmDairitenLstKinyuu.get(2).getKanjidairitennm());
        } else if (!Strings.isNullOrEmpty(uiBean.getDrtencd3())) {
            uiBean.setDispdrtennm3(wkDispdrtennm3);
        } else {
            uiBean.setDispdrtennm3("");
        }
        if(!Strings.isNullOrEmpty(uiBean.getDairitenkinyuukikancd4())){
            uiBean.setDispdrtennm4(bmDairitenLstKinyuu.get(3).getKanjidairitennm());
        } else if (!Strings.isNullOrEmpty(uiBean.getDrtencd4())) {
            uiBean.setDispdrtennm4(wkDispdrtennm4);
        } else {
            uiBean.setDispdrtennm4("");
        }
        if(!Strings.isNullOrEmpty(uiBean.getDairitenkinyuukikancd5())){
            uiBean.setDispdrtennm5(bmDairitenLstKinyuu.get(4).getKanjidairitennm());
        } else if (!Strings.isNullOrEmpty(uiBean.getDrtencd5())) {
            uiBean.setDispdrtennm5(wkDispdrtennm5);
        } else {
            uiBean.setDispdrtennm5("");
        }

        uiBean.setDairitenkinyuukikancd1(null);
        uiBean.setDairitenkinyuukikancd2(null);
        uiBean.setDairitenkinyuukikancd3(null);
        uiBean.setDairitenkinyuukikancd4(null);
        uiBean.setDairitenkinyuukikancd5(null);

        DT_WfSentakujyotaiHozon searchCond = getSearchKeyInputInfo();

        getSearchResult(searchCond);

    }

    String taskSntkNyuuryokuLinkOnClick(C_TaskKbn pTasksentakujoutai) {

        uiBean.setTasksentakujoutai(pTasksentakujoutai);

        String jimutetuzukiCd = uiBean.getResultInfoTskSntkDataSource().getSelectedBean().getJimutetuzukicd();
        String taskId = uiBean.getResultInfoTskSntkDataSource().getSelectedBean().getTskId();

        if(!SinkeiyakuWorkListConstants.SINKEIYAKU_KINOUIDMAP.containsKey(jimutetuzukiCd + taskId)){
            throw new BizAppException(MessageId.EAS0037);
        }
        if(SinkeiyakuWorkListConstants.SINKEIYAKU_KINOUIDMAP.get(jimutetuzukiCd + taskId) == null){
            throw new BizLogicException(MessageId.EDF1001);
        }

        GetTasksForWorkListSkResultBean itiranresult = getTasksForWorkListSk();

        if(WorkFlowResultConstants.RESULT_NODATA.equals(itiranresult.getSyorikekkaStatus())){
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

        List<TaskSummaryForWorkListBean> taskSummaryForWorkListBeanList = itiranresult.getTaskSummaryForWorkListBeanList();

        String key = "";
        TaskSummaryForWorkListBean tempresult = null;
        for(int i = 0; i < taskSummaryForWorkListBeanList.size(); i++){
            if(taskSummaryForWorkListBeanList.get(i).getNyuuryokuKahi()){
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
            if(taskSummaryForWorkListBeanList.get(0).getNyuuryokuKahi()){
                String tempJimuTetuzukiCd = taskSummaryForWorkListBeanList.get(0).getJimutetuzukiCd();
                renkeiInfo.setJimuTetuzukiCd(tempJimuTetuzukiCd);

                String tempTaskId = taskSummaryForWorkListBeanList.get(0).getNowTaskNm();
                renkeiInfo.setTaskId(tempTaskId);

                renkeiInfo.setGyoumuKey(taskSummaryForWorkListBeanList.get(0).getKouteiKnrId());

                key = tempJimuTetuzukiCd + tempTaskId;
            }
        }

        if(tempresult == null){
            messageManager.addMessageId(MessageId.IDF0001);
            return null;
        }

        return SinkeiyakuWorkListConstants.SINKEIYAKU_KINOUIDMAP.get(key);

    }

    String itiranLinkOnClick(C_TaskKbn pTasksentakujoutai) {

        uiBean.setTasksentakujoutai(pTasksentakujoutai);

        uiBean.setTaskId(uiBean.getResultInfoTskSntkDataSource().getSelectedBean().getTskId());

        uiBean.setDispTaskName(uiBean.getResultInfoTskSntkDataSource().getSelectedBean().getWorkflowTskNm());

        uiBean.setJimutetuzukicd(uiBean.getResultInfoTskSntkDataSource().getSelectedBean().getJimutetuzukicd());

        uiBean.setDispjimutetuzukinm(uiBean.getResultInfoTskSntkDataSource().getSelectedBean().getDispjimutetuzukinm());

        GetTasksForWorkListSkResultBean itiranresult = getTasksForWorkListSk();

        if(WorkFlowResultConstants.RESULT_NODATA.equals(itiranresult.getSyorikekkaStatus())){
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

        if(uiBean.getDjmskmKeiyakuKbn()){
            List<ResultInfoItiranDataSourceBean> wkResultInfoItiran = getViewValues(itiranresult.getTaskSummaryForWorkListBeanList());

            Ordering<ResultInfoItiranDataSourceBean> ordering = Ordering.natural().nullsFirst().onResultOf(new SinkeiyakuWorkListKyknmknSortFunction ());
            List<ResultInfoItiranDataSourceBean> sortedInfoItiran = ordering.sortedCopy(wkResultInfoItiran);

            uiBean.setResultInfoItiran(sortedInfoItiran);
        } else {
            List<ResultInfoItiranDataSourceBean> wkResultInfoItiran = toListResultInfoItiranDSBean(itiranresult.getTaskSummaryForWorkListBeanList());

            uiBean.setResultInfoItiran(wkResultInfoItiran);

            logger.debug("同時申込無 一覧リンク押下時");
            logger.debug("uiBean.getResultInfoItiran()の値");
            for(ResultInfoItiranDataSourceBean temp:uiBean.getResultInfoItiran()){
                logger.debug(BeanUtil.toString(temp));
            }

            getViewValuesByPage(uiBean.getResultInfoItiran());

            logger.debug("getViewValuesByPage後の値");
            for(ResultInfoItiranDataSourceBean temp:uiBean.getResultInfoItiran()){
                logger.debug(BeanUtil.toString(temp));
            }
        }

        uiBean.setMosno(searchKeyInputBean.getMosno());

        return SinkeiyakuWorkListConstants.FORWARDNAME_INPUTKEYANKNITRNSNKYK;
    }

    String anknItrnNyuuryokuLinkOnClick() {


        ResultInfoItiranDataSourceBean tempBean = uiBean.getResultInfoItiranDataSource().getSelectedBean();

        String tempJimuTetuzukiCd = uiBean.getJimutetuzukicd();
        renkeiInfo.setJimuTetuzukiCd(tempJimuTetuzukiCd);

        String tempTaskId = uiBean.getTaskId();
        renkeiInfo.setTaskId(tempTaskId);

        renkeiInfo.setGyoumuKey(tempBean.getKouteiKnrId());

        if(!SinkeiyakuWorkListConstants.SINKEIYAKU_KINOUIDMAP.containsKey(tempJimuTetuzukiCd + tempTaskId)){
            throw new BizAppException(MessageId.EAS0037);
        }
        if(SinkeiyakuWorkListConstants.SINKEIYAKU_KINOUIDMAP.get(tempJimuTetuzukiCd + tempTaskId) == null){
            throw new BizLogicException(MessageId.EDF1001);
        }

        return SinkeiyakuWorkListConstants.SINKEIYAKU_KINOUIDMAP.get(tempJimuTetuzukiCd + tempTaskId);

    }

    @SuppressWarnings("deprecation")
    void modorubtnOnClick() {

        BizUiBeanBackupUtil.restore(uiBean, searchKeyInputBean);

        uiBean.setPageNo(SinkeiyakuWorkListConstants.PAGENO_INPUTKEYTSKSNTKSNKYK);

        getSearchResult(getSearchKeyInputInfo());

    }

    void resultInfoItiranPagerOnClick(){
        logger.debug("ページャークリック時　ビジネスロジック");
        logger.debug("uiBean.getResultInfoItiran()の値");
        for(ResultInfoItiranDataSourceBean temp:uiBean.getResultInfoItiran()){
            logger.debug(BeanUtil.toString(temp));
        }

        getViewValuesByPage(uiBean.getResultInfoItiran());

        logger.debug("getViewValuesByPage後の値");
        for(ResultInfoItiranDataSourceBean temp:uiBean.getResultInfoItiran()){
            logger.debug(BeanUtil.toString(temp));
        }
    }

    private void getSearchResult(DT_WfSentakujyotaiHozon pSearchCond){

        int pageNo = uiBean.getPageNo();

        if(pageNo == SinkeiyakuWorkListConstants.PAGENO_INPUTKEYTSKSNTKSNKYK){

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

    private GetTasksForWorkListSkResultBean getTasksForWorkListSk(){
        String taskSentaku = uiBean.getTasksentakujoutai() == C_TaskKbn.KOJIN ? "0" : "1";

        String jimutetuzukiCd;
        if(uiBean.getPageNo() == SinkeiyakuWorkListConstants.PAGENO_INPUTKEYTSKSNTKSNKYK){
            jimutetuzukiCd = uiBean.getResultInfoTskSntkDataSource().getSelectedBean().getJimutetuzukicd();
        }else{
            jimutetuzukiCd = uiBean.getJimutetuzukicd();
        }

        String taskId;
        if(uiBean.getPageNo() == SinkeiyakuWorkListConstants.PAGENO_INPUTKEYTSKSNTKSNKYK){
            taskId = uiBean.getResultInfoTskSntkDataSource().getSelectedBean().getTskId();
        }else{
            taskId = uiBean.getTaskId();
        }

        C_SkeijimuKbn[] skeiJimuKbn = searchKeyInputBean.getSkeijimukbn();
        String[] skeiJimuKbnHzn = null;

        if(skeiJimuKbn != null){
            skeiJimuKbnHzn = new String[skeiJimuKbn.length];

            for(int i = 0;i<skeiJimuKbn.length;i++){
                skeiJimuKbnHzn[i] = skeiJimuKbn[i].getValue();
            }
        }

        C_MosUketukeKbn[] mosUketukeKbn = searchKeyInputBean.getMosuketukekbn();
        String[] mosUketukeKbnHzn = null;

        if(mosUketukeKbn != null){
            mosUketukeKbnHzn = new String[mosUketukeKbn.length];

            for(int i = 0; i < mosUketukeKbn.length; i++) {
                mosUketukeKbnHzn[i] = mosUketukeKbn[i].getValue();
            }
        }

        List<String> hknsyuruiList =  searchKeyInputBean.getDisphknsyuruiworklist();
        String[] hknsyuruiCdHozon = null;

        if(hknsyuruiList != null){
            hknsyuruiCdHozon = hknsyuruiList.toArray(new String[hknsyuruiList.size()]);
        }

        List<String> dairitenCdList = Lists.newArrayList();
        if(!Strings.isNullOrEmpty(searchKeyInputBean.getDairitencd1())){
            dairitenCdList.add(searchKeyInputBean.getDairitencd1());
        }
        if(!Strings.isNullOrEmpty(searchKeyInputBean.getDairitencd2())){
            dairitenCdList.add(searchKeyInputBean.getDairitencd2());
        }
        if(!Strings.isNullOrEmpty(searchKeyInputBean.getDrtencd3())){
            dairitenCdList.add(searchKeyInputBean.getDrtencd3());
        }
        if(!Strings.isNullOrEmpty(searchKeyInputBean.getDrtencd4())){
            dairitenCdList.add(searchKeyInputBean.getDrtencd4());
        }
        if(!Strings.isNullOrEmpty(searchKeyInputBean.getDrtencd5())){
            dairitenCdList.add(searchKeyInputBean.getDrtencd5());
        }

        String[] dairitenCd = null;
        if(dairitenCdList.size() > 0){
            dairitenCd = dairitenCdList.toArray(new String[dairitenCdList.size()]);
        }

        String jimuyouCdKbn = searchKeyInputBean.getJmycdMisetteiKbn() ? "0" : "1";

        String doujimskm = searchKeyInputBean.getDjmskmKeiyakuKbn() ? "1" : null;

        String kodairitentaisyou = null;

        String pJimuKaisiYmdFrom = "";
        if( searchKeyInputBean.getJimustartYmdFrom() != null ){
            pJimuKaisiYmdFrom = searchKeyInputBean.getJimustartYmdFrom().toString();
        }
        String pJimuKaisiYmdTo = "";
        if( searchKeyInputBean.getJimustartYmdTo() != null ){
            pJimuKaisiYmdTo = searchKeyInputBean.getJimustartYmdTo().toString();
        }
        String pMosYmdFrom = "";
        if( searchKeyInputBean.getSrchmosfromymd() != null ){
            pMosYmdFrom = searchKeyInputBean.getSrchmosfromymd().toString();
        }
        String pMosYmdTo = "";
        if( searchKeyInputBean.getSrchmostoymd() != null ){
            pMosYmdTo = searchKeyInputBean.getSrchmostoymd().toString();
        }

        GetTasksForWorkListSkResultBean itiranresult =
            WorkFlowUtility.getTasksForWorkListSk(
                SinkeiyakuWorkListConstants.SINKEIYAKU,
                searchKeyInputBean.getMosno(),
                null,
                null,
                jimutetuzukiCd,
                pJimuKaisiYmdFrom,
                pJimuKaisiYmdTo,
                pMosYmdFrom,
                pMosYmdTo,
                searchKeyInputBean.getJimuyoucd(),
                jimuyouCdKbn,
                baseUserInfo.getUserId(),
                taskSentaku,
                taskId,
                skeiJimuKbnHzn,
                mosUketukeKbnHzn,
                hknsyuruiCdHozon,
                dairitenCd,
                kodairitentaisyou,
                doujimskm);

        return itiranresult;
    }

    private void getSearchResultTskSntk(DT_WfSentakujyotaiHozon pSearchCond) {
        List<ResultInfoTskSntkDataSourceBean> wkResultInfo = new ArrayList<ResultInfoTskSntkDataSourceBean>();

        C_SkeijimuKbn[] skeiJimuKbn = searchKeyInputBean.getSkeijimukbn();
        String[] skeiJimuKbnHzn = null;
        if(skeiJimuKbn != null){
            skeiJimuKbnHzn = new String[skeiJimuKbn.length];
            for(int i = 0;i<skeiJimuKbn.length;i++){
                skeiJimuKbnHzn[i] = skeiJimuKbn[i].getValue();
            }
        }

        C_MosUketukeKbn[] mosUketukeKbn = searchKeyInputBean.getMosuketukekbn();
        String[] mosUketukeKbnHzn = null;
        if(mosUketukeKbn != null){
            mosUketukeKbnHzn = new String[mosUketukeKbn.length];
            for(int i = 0; i < mosUketukeKbn.length; i++) {
                mosUketukeKbnHzn[i] = mosUketukeKbn[i].getValue();
            }
        }

        List<String> hknsyuruiList =  searchKeyInputBean.getDisphknsyuruiworklist();
        String[] hknsyuruiListCdHozon = null;

        if(hknsyuruiList != null){
            hknsyuruiListCdHozon = hknsyuruiList.toArray(new String[hknsyuruiList.size()]);
        }

        List<String> dairitenCdList = Lists.newArrayList();
        if(!Strings.isNullOrEmpty(searchKeyInputBean.getDairitencd1())){
            dairitenCdList.add(searchKeyInputBean.getDairitencd1());
        }
        if(!Strings.isNullOrEmpty(searchKeyInputBean.getDairitencd2())){
            dairitenCdList.add(searchKeyInputBean.getDairitencd2());
        }
        if(!Strings.isNullOrEmpty(searchKeyInputBean.getDrtencd3())){
            dairitenCdList.add(searchKeyInputBean.getDrtencd3());
        }
        if(!Strings.isNullOrEmpty(searchKeyInputBean.getDrtencd4())){
            dairitenCdList.add(searchKeyInputBean.getDrtencd4());
        }
        if(!Strings.isNullOrEmpty(searchKeyInputBean.getDrtencd5())){
            dairitenCdList.add(searchKeyInputBean.getDrtencd5());
        }

        String[] dairitenCd = null;
        if(dairitenCdList.size() > 0){
            dairitenCd = dairitenCdList.toArray(new String[dairitenCdList.size()]);
        }

        String jimuyouCdKbn = searchKeyInputBean.getJmycdMisetteiKbn() ? "0" : "1";

        String doujimskm = searchKeyInputBean.getDjmskmKeiyakuKbn() ? "1" : null;

        String kodairitentaisyou = searchKeyInputBean.getKoDairitenTaisyouKbn() ? "0" : "";

        String pJimuKaisiYmdFrom = "";
        if( searchKeyInputBean.getJimustartYmdFrom() != null ){
            pJimuKaisiYmdFrom = searchKeyInputBean.getJimustartYmdFrom().toString();
        }
        String pJimuKaisiYmdTo = "";
        if( searchKeyInputBean.getJimustartYmdTo() != null ){
            pJimuKaisiYmdTo = searchKeyInputBean.getJimustartYmdTo().toString();
        }
        String pMosYmdFrom = "";
        if( searchKeyInputBean.getSrchmosfromymd() != null ){
            pMosYmdFrom = searchKeyInputBean.getSrchmosfromymd().toString();
        }
        String pMosYmdTo = "";
        if( searchKeyInputBean.getSrchmostoymd() != null ){
            pMosYmdTo = searchKeyInputBean.getSrchmostoymd().toString();
        }

        GetExecutableTasksForWorkListSkResultBean searchresult =
            WorkFlowUtility.getExecutableTasksForWorkListSk(
                SinkeiyakuWorkListConstants.SINKEIYAKU,
                searchKeyInputBean.getMosno(),
                null,
                null,
                null,
                pJimuKaisiYmdFrom,
                pJimuKaisiYmdTo,
                pMosYmdFrom,
                pMosYmdTo,
                searchKeyInputBean.getJimuyoucd(),
                jimuyouCdKbn,
                baseUserInfo.getUserId(),
                null,
                skeiJimuKbnHzn,
                mosUketukeKbnHzn,
                hknsyuruiListCdHozon,
                dairitenCd,
                kodairitentaisyou,
                doujimskm
                );

        if (searchresult.getSyorikekkaStatus().equals(WorkFlowResultConstants.RESULT_NG)) {
            throw new BizAppException(MessageId.EAS0037);
        }

        List<ResultInfoTskSntkBaseDataSourceBean> wkResultInfoBase = Lists.newArrayList();

        Set<String> jimutetuzukiSet = Sets.newLinkedHashSet();

        if(searchresult.getExecutableTaskInfoBeanList().size() > 0){
            for (ExecutableTaskInfoBean tempresult:searchresult.getExecutableTaskInfoBeanList()) {
                ResultInfoTskSntkDataSourceBean taskResultInfoDataSourceBean = new ResultInfoTskSntkDataSourceBean();

                taskResultInfoDataSourceBean.setJimutetuzukicd(tempresult.getJimutetuzukiCd());
                taskResultInfoDataSourceBean.setDispjimutetuzukinm(tempresult.getJimutetuzukiNm());
                taskResultInfoDataSourceBean.setTskId(tempresult.getTaskNm());
                taskResultInfoDataSourceBean.setWorkflowTskNm(tempresult.getDispTaskNm());
                taskResultInfoDataSourceBean.setKjnTskKensuu(tempresult.getPersonalizedTaskNum());

                if(tempresult.getPersonalizedTaskNum().compareTo(BizNumber.valueOf(0)) > 0){
                    taskResultInfoDataSourceBean.setKojinNyuuryokuLink(SinkeiyakuWorkListConstants.NYUURYOKU_LINK);
                    taskResultInfoDataSourceBean.setKojinItiranLink(SinkeiyakuWorkListConstants.ITIRAN_LINK);
                }

                taskResultInfoDataSourceBean.setKyyTskKensuu(tempresult.getSharedTaskNum());

                if(tempresult.getSharedTaskNum().compareTo(BizNumber.valueOf(0)) > 0){
                    taskResultInfoDataSourceBean.setKyouyouNyuuryokuLink(SinkeiyakuWorkListConstants.NYUURYOKU_LINK);
                    taskResultInfoDataSourceBean.setKyouyouItiranLink(SinkeiyakuWorkListConstants.ITIRAN_LINK);
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

        GetTasksForWorkListSkResultBean itiranresult = getTasksForWorkListSk();

        if(WorkFlowResultConstants.RESULT_NG.equals(itiranresult.getSyorikekkaStatus()) &&
            itiranresult.getSyousaiMessageCd().equals("IWF2160")){
            messageManager.addMessageId(MessageId.IBF0024);
            return;
        }

        if(WorkFlowResultConstants.RESULT_NODATA.equals(itiranresult.getSyorikekkaStatus())){
            messageManager.addMessageId(MessageId.IDF0001);
            return;
        }

        if (!itiranresult.getSyorikekkaStatus().equals(WorkFlowResultConstants.RESULT_OK)) {
            throw new BizAppException(MessageId.EAS0037);
        }

        if(uiBean.getDjmskmKeiyakuKbn()){

            List<ResultInfoItiranDataSourceBean> wkResultInfoItiran = getViewValues(itiranresult.getTaskSummaryForWorkListBeanList());

            Ordering<ResultInfoItiranDataSourceBean> ordering = Ordering.natural().nullsLast().onResultOf(new SinkeiyakuWorkListKyknmknSortFunction ());
            List<ResultInfoItiranDataSourceBean> sortedInfoItiran = ordering.sortedCopy(wkResultInfoItiran);

            uiBean.setResultInfoItiran(sortedInfoItiran);
        } else {
            List<ResultInfoItiranDataSourceBean> wkResultInfoItiran = toListResultInfoItiranDSBean(itiranresult.getTaskSummaryForWorkListBeanList());

            uiBean.setResultInfoItiran(wkResultInfoItiran);

            logger.debug("同時申込無 案件一覧検索時");
            logger.debug("uiBean.getResultInfoItiran()の値");
            for(ResultInfoItiranDataSourceBean temp:uiBean.getResultInfoItiran()){
                logger.debug(BeanUtil.toString(temp));
            }

            getViewValuesByPage(uiBean.getResultInfoItiran());

            logger.debug("getViewValuesByPage後の値");
            for(ResultInfoItiranDataSourceBean temp:uiBean.getResultInfoItiran()){
                logger.debug(BeanUtil.toString(temp));
            }
        }

    }

    private DT_WfSentakujyotaiHozon getSearchCond(String wkUserId) {
        DT_WfSentakujyotaiHozon searchCond = workflowDomManager.getWfSentakujyotaiHozon(wkUserId, SinkeiyakuWorkListConstants.SINKEIYAKU);

        return searchCond;
    }

    private void setSearchCondToUiBean(DT_WfSentakujyotaiHozon pSearchCond, List<BM_Dairiten> pBmDairitenLst) {

        if(!"".equals(pSearchCond.getSkeiJimuKbnHzn())){
            String[] skeiJimuKbnHzn = pSearchCond.getSkeiJimuKbnHzn().split(",");

            C_SkeijimuKbn[] skeiJimuKbn = new C_SkeijimuKbn[skeiJimuKbnHzn.length];

            for(int i = 0;i<skeiJimuKbnHzn.length;i++){
                skeiJimuKbn[i] = C_SkeijimuKbn.valueOf(skeiJimuKbnHzn[i]);
            }

            uiBean.setSkeijimukbn(skeiJimuKbn);
        } else {
            uiBean.setSkeijimukbn(null);
        }

        if(!"".equals(pSearchCond.getMosUketukeKbnHzn())){
            String[] mosUketukeKbnHzn = pSearchCond.getMosUketukeKbnHzn().split(",");

            C_MosUketukeKbn[] mosUketukeKbn = new C_MosUketukeKbn[mosUketukeKbnHzn.length] ;

            for(int i = 0;i<mosUketukeKbnHzn.length;i++){
                mosUketukeKbn[i] = C_MosUketukeKbn.valueOf(mosUketukeKbnHzn[i]);
            }

            uiBean.setMosuketukekbn(mosUketukeKbn);
        } else {
            uiBean.setMosuketukekbn(null);
        }

        if(pSearchCond.getHokensyuruinohozon() != null){
            uiBean.setDisphknsyuruiworklist(Arrays.asList(pSearchCond.getHokensyuruinohozon().split(",")));
        }

        String wkDispdrtennm1 = null;
        String wkDispdrtennm2 = null;
        String wkDispdrtennm3 = null;
        String wkDispdrtennm4 = null;
        String wkDispdrtennm5 = null;

        if(!(pBmDairitenLst == null || pBmDairitenLst.size() == 0)){
            int sizeCnt = pBmDairitenLst.size();

            for (int i = 0; i < sizeCnt; i++) {
                if (pSearchCond.getDairitencd1().equals(pBmDairitenLst.get(i).getDrtencd())) {
                    wkDispdrtennm1 = pBmDairitenLst.get(i).getKanjidairitennm();
                }
            }

            for (int i = 0; i < sizeCnt; i++) {
                if (pSearchCond.getDairitencd2().equals(pBmDairitenLst.get(i).getDrtencd())) {
                    wkDispdrtennm2 = pBmDairitenLst.get(i).getKanjidairitennm();
                }
            }

            for (int i = 0; i < sizeCnt; i++) {
                if (pSearchCond.getDrtencd3().equals(pBmDairitenLst.get(i).getDrtencd())) {
                    wkDispdrtennm3 = pBmDairitenLst.get(i).getKanjidairitennm();
                }
            }

            for (int i = 0; i < sizeCnt; i++) {
                if (pSearchCond.getDrtencd4().equals(pBmDairitenLst.get(i).getDrtencd())) {
                    wkDispdrtennm4 = pBmDairitenLst.get(i).getKanjidairitennm();
                }
            }

            for (int i = 0; i < sizeCnt; i++) {
                if (pSearchCond.getDrtencd5().equals(pBmDairitenLst.get(i).getDrtencd())) {
                    wkDispdrtennm5 = pBmDairitenLst.get(i).getKanjidairitennm();
                }
            }
        }

        uiBean.setDairitencd1(pSearchCond.getDairitencd1());

        uiBean.setDairitencd2(pSearchCond.getDairitencd2());

        uiBean.setDrtencd3(pSearchCond.getDrtencd3());

        uiBean.setDrtencd4(pSearchCond.getDrtencd4());

        uiBean.setDrtencd5(pSearchCond.getDrtencd5());

        uiBean.setDispdrtennm1(wkDispdrtennm1);

        uiBean.setDispdrtennm2(wkDispdrtennm2);

        uiBean.setDispdrtennm3(wkDispdrtennm3);

        uiBean.setDispdrtennm4(wkDispdrtennm4);

        uiBean.setDispdrtennm5(wkDispdrtennm5);

        uiBean.setJimuyoucd(pSearchCond.getJimuyoucd());

        uiBean.setJmycdMisetteiKbn(pSearchCond.getJmycdMisetteiKbn());

        uiBean.setJimustartYmdFrom(pSearchCond.getJimustartYmdFrom());

        uiBean.setJimustartYmdTo(pSearchCond.getJimustartYmdTo());

        uiBean.setSrchmosfromymd(pSearchCond.getMosYmdFrom());

        uiBean.setSrchmostoymd(pSearchCond.getMosYmdTo());

        uiBean.setDjmskmKeiyakuKbn(pSearchCond.getDjmskmKeiyakuKbn());

        uiBean.setMosno(pSearchCond.getMosno());

    }

    private void checkInputDate() {

        final BizDate jimustartymdfrom = uiBean.getJimustartYmdFrom();

        final BizDate jimustartymdto = uiBean.getJimustartYmdTo();

        final BizDate searchmlsfromymd = uiBean.getSrchmosfromymd();

        final BizDate searchmlstoymd = uiBean.getSrchmostoymd();

        if(jimustartymdfrom != null && jimustartymdto != null){
            if( jimustartymdfrom.intValue() > jimustartymdto.intValue() ){
                throw new BizLogicException(MessageId.EDF0003,
                    new Item[]{GenSinkeiyakuWorkListConstants.DDID_SEARCHKEYINPUT_JIMUSTARTYMDFROM,
                    GenSinkeiyakuWorkListConstants.DDID_SEARCHKEYINPUT_JIMUSTARTYMDTO},
                    "事務開始日" );
            }
        }

        if(searchmlsfromymd != null && searchmlstoymd != null){
            if( searchmlsfromymd.intValue() > searchmlstoymd.intValue()){
                throw new BizLogicException(MessageId.EDF0003,
                    new Item[]{GenSinkeiyakuWorkListConstants.DDID_SEARCHKEYINPUT_SRCHMOSFROMYMD,
                    GenSinkeiyakuWorkListConstants.DDID_SEARCHKEYINPUT_SRCHMOSTOYMD},
                    "申込日" );
            }
        }
    }

    private void checkInputJimucode() {

        final String jimuyoucd = uiBean.getJimuyoucd();
        final Boolean commonCheckBox = uiBean.getJmycdMisetteiKbn();

        if( (!"".equals(jimuyoucd)) && commonCheckBox ){
            throw new BizLogicException(MessageId.EDF0006,
                GenSinkeiyakuWorkListConstants.DDID_SEARCHKEYINPUT_JIMUYOUCD,
                GenSinkeiyakuWorkListConstants.DDID_SEARCHKEYINPUT_JMYCDMISETTEIKBN );
        }
    }

    private void checkInputKinyuuDairitencd() {

        final String dairitenkinyuukikancd1 = uiBean.getDairitenkinyuukikancd1();
        final String dairitencd1 = uiBean.getDairitencd1();

        if (!Strings.isNullOrEmpty(dairitenkinyuukikancd1) && !Strings.isNullOrEmpty(dairitencd1)) {

            throw new BizLogicException(MessageId.EDF1002,
                GenSinkeiyakuWorkListConstants.DDID_SEARCHKEYINPUT_DAIRITENKINYUUKIKANCD1,
                GenSinkeiyakuWorkListConstants.DDID_SEARCHKEYINPUT_DAIRITENCD1);
        }

        final String dairitenkinyuukikancd2 = uiBean.getDairitenkinyuukikancd2();
        final String dairitencd2 = uiBean.getDairitencd2();

        if (!Strings.isNullOrEmpty(dairitenkinyuukikancd2) && !Strings.isNullOrEmpty(dairitencd2)) {

            throw new BizLogicException(MessageId.EDF1002,
                GenSinkeiyakuWorkListConstants.DDID_SEARCHKEYINPUT_DAIRITENKINYUUKIKANCD2,
                GenSinkeiyakuWorkListConstants.DDID_SEARCHKEYINPUT_DAIRITENCD2);
        }

        final String dairitenkinyuukikancd3 = uiBean.getDairitenkinyuukikancd3();
        final String dairitencd3 = uiBean.getDrtencd3();

        if (!Strings.isNullOrEmpty(dairitenkinyuukikancd3) && !Strings.isNullOrEmpty(dairitencd3)) {

            throw new BizLogicException(MessageId.EDF1002,
                GenSinkeiyakuWorkListConstants.DDID_SEARCHKEYINPUT_DAIRITENKINYUUKIKANCD3,
                GenSinkeiyakuWorkListConstants.DDID_SEARCHKEYINPUT_DRTENCD3);
        }

        final String dairitenkinyuukikancd4 = uiBean.getDairitenkinyuukikancd4();
        final String dairitencd4 = uiBean.getDrtencd4();

        if (!Strings.isNullOrEmpty(dairitenkinyuukikancd4) && !Strings.isNullOrEmpty(dairitencd4)) {

            throw new BizLogicException(MessageId.EDF1002,
                GenSinkeiyakuWorkListConstants.DDID_SEARCHKEYINPUT_DAIRITENKINYUUKIKANCD4,
                GenSinkeiyakuWorkListConstants.DDID_SEARCHKEYINPUT_DRTENCD4);
        }

        final String dairitenkinyuukikancd5 = uiBean.getDairitenkinyuukikancd5();
        final String dairitencd5 = uiBean.getDrtencd5();

        if (!Strings.isNullOrEmpty(dairitenkinyuukikancd5) && !Strings.isNullOrEmpty(dairitencd5)) {

            throw new BizLogicException(MessageId.EDF1002,
                GenSinkeiyakuWorkListConstants.DDID_SEARCHKEYINPUT_DAIRITENKINYUUKIKANCD5,
                GenSinkeiyakuWorkListConstants.DDID_SEARCHKEYINPUT_DRTENCD5);
        }
    }

    private List<BM_Dairiten> checkOyadairitencdExist() {

        List<BM_Dairiten> rstBmDairitenLst =  new ArrayList<BM_Dairiten>();

        final String dairitenkinyuukikancd1 = uiBean.getDairitenkinyuukikancd1();
        if (!Strings.isNullOrEmpty(dairitenkinyuukikancd1)) {

            List<BM_Dairiten> bmDairitenLst = bizDomManager.getDairitensByKinyuucd(dairitenkinyuukikancd1);

            if (bmDairitenLst.size() == 0) {
                uiBean.setDispdrtennm1(null);
                throw new BizLogicException(MessageId.EDF1003,
                    GenSinkeiyakuWorkListConstants.DDID_SEARCHKEYINPUT_DAIRITENKINYUUKIKANCD1);
            }

            rstBmDairitenLst.add(bmDairitenLst.get(0));
        } else {
            rstBmDairitenLst.add(null);
        }

        final String dairitenkinyuukikancd2 = uiBean.getDairitenkinyuukikancd2();
        if (!Strings.isNullOrEmpty(dairitenkinyuukikancd2)) {

            List<BM_Dairiten> bmDairitenLst = bizDomManager.getDairitensByKinyuucd(dairitenkinyuukikancd2);

            if (bmDairitenLst.size() == 0) {
                uiBean.setDispdrtennm1(null);
                throw new BizLogicException(MessageId.EDF1003,
                    GenSinkeiyakuWorkListConstants.DDID_SEARCHKEYINPUT_DAIRITENKINYUUKIKANCD2);
            }

            rstBmDairitenLst.add(bmDairitenLst.get(0));
        } else {
            rstBmDairitenLst.add(null);
        }

        final String dairitenkinyuukikancd3 = uiBean.getDairitenkinyuukikancd3();
        if (!Strings.isNullOrEmpty(dairitenkinyuukikancd3)) {

            List<BM_Dairiten> bmDairitenLst = bizDomManager.getDairitensByKinyuucd(dairitenkinyuukikancd3);

            if (bmDairitenLst.size() == 0) {
                uiBean.setDispdrtennm1(null);
                throw new BizLogicException(MessageId.EDF1003,
                    GenSinkeiyakuWorkListConstants.DDID_SEARCHKEYINPUT_DAIRITENKINYUUKIKANCD3);
            }

            rstBmDairitenLst.add(bmDairitenLst.get(0));
        } else {
            rstBmDairitenLst.add(null);
        }

        final String dairitenkinyuukikancd4 = uiBean.getDairitenkinyuukikancd4();
        if (!Strings.isNullOrEmpty(dairitenkinyuukikancd4)) {

            List<BM_Dairiten> bmDairitenLst = bizDomManager.getDairitensByKinyuucd(dairitenkinyuukikancd4);

            if (bmDairitenLst.size() == 0) {
                uiBean.setDispdrtennm1(null);
                throw new BizLogicException(MessageId.EDF1003,
                    GenSinkeiyakuWorkListConstants.DDID_SEARCHKEYINPUT_DAIRITENKINYUUKIKANCD4);
            }

            rstBmDairitenLst.add(bmDairitenLst.get(0));
        } else {
            rstBmDairitenLst.add(null);
        }

        final String dairitenkinyuukikancd5 = uiBean.getDairitenkinyuukikancd5();
        if (!Strings.isNullOrEmpty(dairitenkinyuukikancd5)) {

            List<BM_Dairiten> bmDairitenLst = bizDomManager.getDairitensByKinyuucd(dairitenkinyuukikancd5);

            if (bmDairitenLst.size() == 0) {
                uiBean.setDispdrtennm1(null);
                throw new BizLogicException(MessageId.EDF1003,
                    GenSinkeiyakuWorkListConstants.DDID_SEARCHKEYINPUT_DAIRITENKINYUUKIKANCD5);
            }

            rstBmDairitenLst.add(bmDairitenLst.get(0));
        } else {
            rstBmDairitenLst.add(null);
        }

        return rstBmDairitenLst;
    }

    private void saveSearchCond() {

        DT_WfSentakujyotaiHozon searchCond = workflowDomManager.getWfSentakujyotaiHozon(baseUserInfo.getUserId(), SinkeiyakuWorkListConstants.SINKEIYAKU);

        if(searchCond == null){
            searchCond = new DT_WfSentakujyotaiHozon();

            searchCond.setUserId(baseUserInfo.getUserId());
            searchCond.setSubSystemId(SinkeiyakuWorkListConstants.SINKEIYAKU);

            C_SkeijimuKbn[] skeiJimuKbn = uiBean.getSkeijimukbn();

            StringBuilder skeiJimuKbnHzn = new StringBuilder();

            if(skeiJimuKbn != null){
                for(int i = 0;i<skeiJimuKbn.length;i++){
                    if(i == 0){
                        skeiJimuKbnHzn.append(skeiJimuKbn[i].getValue());
                    }
                    else {
                        skeiJimuKbnHzn.append(",").append(skeiJimuKbn[i].getValue());
                    }
                }
            }

            searchCond.setSkeiJimuKbnHzn(skeiJimuKbnHzn.toString());

            C_MosUketukeKbn[] mosUketukeKbn = uiBean.getMosuketukekbn();

            StringBuilder mosUketukeKbnHzn = new StringBuilder();

            if(mosUketukeKbn != null){
                for(int i = 0; i < mosUketukeKbn.length; i++) {
                    if(i == 0) {
                        mosUketukeKbnHzn.append(mosUketukeKbn[i].getValue());
                    } else {
                        mosUketukeKbnHzn.append(",").append(mosUketukeKbn[i].getValue());
                    }
                }
            }

            searchCond.setMosUketukeKbnHzn(mosUketukeKbnHzn.toString());

            List<String> hknsyuruiList =  uiBean.getDisphknsyuruiworklist();

            StringBuilder hknsyuruiCdHozon = new StringBuilder();

            if(hknsyuruiList != null){
                for(int i = 0; i < hknsyuruiList.size(); i++) {
                    if(i == 0) {
                        hknsyuruiCdHozon.append(hknsyuruiList.get(i));
                    } else {
                        hknsyuruiCdHozon.append(",").append(hknsyuruiList.get(i));
                    }
                }
            }

            searchCond.setHokensyuruinohozon(hknsyuruiCdHozon.toString());

            searchCond.setDairitencd1(uiBean.getDairitencd1());

            searchCond.setDairitencd2(uiBean.getDairitencd2());

            searchCond.setDrtencd3(uiBean.getDrtencd3());

            searchCond.setDrtencd4(uiBean.getDrtencd4());

            searchCond.setDrtencd5(uiBean.getDrtencd5());

            searchCond.setJimuyoucd(uiBean.getJimuyoucd());

            searchCond.setJmycdMisetteiKbn(uiBean.getJmycdMisetteiKbn());

            searchCond.setJimustartYmdFrom(uiBean.getJimustartYmdFrom());

            searchCond.setJimustartYmdTo(uiBean.getJimustartYmdTo());

            searchCond.setMosYmdFrom(uiBean.getSrchmosfromymd());

            searchCond.setMosYmdTo(uiBean.getSrchmostoymd());

            searchCond.setDjmskmKeiyakuKbn(uiBean.getDjmskmKeiyakuKbn());

            searchCond.setMosno(uiBean.getMosno());

            BizPropertyInitializer.initialize(searchCond);

            workflowDomManager.insert(searchCond);

        } else {
            C_SkeijimuKbn[] skeiJimuKbn = uiBean.getSkeijimukbn();

            StringBuilder skeiJimuKbnHzn = new StringBuilder();

            if(skeiJimuKbn != null){
                for(int i = 0;i<skeiJimuKbn.length;i++){
                    if( i == 0){
                        skeiJimuKbnHzn.append(skeiJimuKbn[i].getValue());
                    }
                    else {
                        skeiJimuKbnHzn.append(",").append(skeiJimuKbn[i].getValue());
                    }
                }
            }

            searchCond.setSkeiJimuKbnHzn(skeiJimuKbnHzn.toString());

            C_MosUketukeKbn[] mosUketukeKbn = uiBean.getMosuketukekbn();

            StringBuilder mosUketukeKbnHzn = new StringBuilder();

            if(mosUketukeKbn != null){
                for(int i = 0;i<mosUketukeKbn.length;i++){
                    if( i == 0){
                        mosUketukeKbnHzn.append(mosUketukeKbn[i].getValue());
                    }
                    else {
                        mosUketukeKbnHzn.append(",").append(mosUketukeKbn[i].getValue());
                    }
                }
            }

            searchCond.setMosUketukeKbnHzn(mosUketukeKbnHzn.toString());

            List<String> hknsyuruiList =  uiBean.getDisphknsyuruiworklist();

            StringBuilder hknsyuruiCdHozon = new StringBuilder();

            if(hknsyuruiList != null){
                for(int i = 0; i < hknsyuruiList.size(); i++) {
                    if(i == 0) {
                        hknsyuruiCdHozon.append(hknsyuruiList.get(i));
                    } else {
                        hknsyuruiCdHozon.append(",").append(hknsyuruiList.get(i));
                    }
                }
            }

            searchCond.setHokensyuruinohozon(hknsyuruiCdHozon.toString());

            searchCond.setDairitencd1(uiBean.getDairitencd1());

            searchCond.setDairitencd2(uiBean.getDairitencd2());

            searchCond.setDrtencd3(uiBean.getDrtencd3());

            searchCond.setDrtencd4(uiBean.getDrtencd4());

            searchCond.setDrtencd5(uiBean.getDrtencd5());

            searchCond.setJimuyoucd(uiBean.getJimuyoucd());

            searchCond.setJmycdMisetteiKbn(uiBean.getJmycdMisetteiKbn());

            searchCond.setJimustartYmdFrom(uiBean.getJimustartYmdFrom());

            searchCond.setJimustartYmdTo(uiBean.getJimustartYmdTo());

            searchCond.setMosYmdFrom(uiBean.getSrchmosfromymd());

            searchCond.setMosYmdTo(uiBean.getSrchmostoymd());

            searchCond.setDjmskmKeiyakuKbn(uiBean.getDjmskmKeiyakuKbn());

            searchCond.setMosno(uiBean.getMosno());

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

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        for(TaskSummaryForWorkListBean tempresult: pList){

            WorklistViewValuesBean tempbean = new WorklistViewValuesBean();

            if (!Strings.isNullOrEmpty(tempresult.getJimuStartYmd())) {
                try {
                    tempbean.setDispjimustartymdtime(sdf2.format(sdf1.parse(tempresult.getJimuStartYmd())));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

            tempbean.setMosno(tempresult.getMosNo());

            tempbean.setDispzenkaisyoritantounm(tempresult.getDispPreSyoriTantouNm());

            tempbean.setDispzenkaisyoritask(tempresult.getDispPreTaskNm());

            tempbean.setJimutetuzukiCd(tempresult.getJimutetuzukiCd());

            tempbean.setKouteiKnrId(tempresult.getKouteiKnrId());

            tempbean.setHknsyuruiNo(tempresult.getHknsyuruino());

            wkList.add(tempbean);
        }

        List<WorklistViewValuesBean> retList = WorklistViewValuesCreator.createValues(
            SinkeiyakuWorkListConstants.SINKEIYAKU, wkList);

        for(int cnt = 0;cnt < retList.size();cnt++){
            ResultInfoItiranDataSourceBean tempItiranBean = new ResultInfoItiranDataSourceBean();

            tempItiranBean.setDispjimustartymdtime(retList.get(cnt).getDispjimustartymdtime());

            tempItiranBean.setMosno(retList.get(cnt).getMosno());

            String dispzenkaisyoritask = retList.get(cnt).getDispzenkaisyoritask();

            if(dispzenkaisyoritask != null){
                tempItiranBean.setDispzenkaisyoritask(dispzenkaisyoritask.length() > 20 ? dispzenkaisyoritask.substring(0, 20) : dispzenkaisyoritask);
            }

            tempItiranBean.setDispzenkaisyoritantounm(retList.get(cnt).getDispzenkaisyoritantounm());

            tempItiranBean.setKouteiKnrId(retList.get(cnt).getKouteiKnrId());

            tempItiranBean.setDisphknsyuruiworklist(retList.get(cnt).getHknsyuruiWorklist());

            String kyknmkj = retList.get(cnt).getKyknmkj();

            if(kyknmkj != null){
                tempItiranBean.setKyknmkj(kyknmkj.length() > 20 ? kyknmkj.substring(0, 20) : kyknmkj);
            }

            tempItiranBean.setKyknmkn(retList.get(cnt).getKyknmkn());

            if(pList.get(cnt).getNyuuryokuKahi()){
                tempItiranBean.setNyuuryokuLink(SinkeiyakuWorkListConstants.NYUURYOKU_LINK);
            }

            retResultInfoItiran.add(tempItiranBean);
        }

        return retResultInfoItiran;
    }



    private void getViewValuesByPage(List<ResultInfoItiranDataSourceBean> pList) {

        List<WorklistViewValuesBean> wkList = Lists.newArrayList();

        if(!isHknSyuruiConvertChk(pList.get(0).getDisphknsyuruiworklist())){
            for(ResultInfoItiranDataSourceBean tempresult: pList){

                WorklistViewValuesBean tempbean = new WorklistViewValuesBean();

                tempbean.setDispjimustartymdtime(tempresult.getDispjimustartymdtime());

                tempbean.setMosno(tempresult.getMosno());

                tempbean.setDispzenkaisyoritantounm(tempresult.getDispzenkaisyoritantounm());

                tempbean.setDispzenkaisyoritask(tempresult.getDispzenkaisyoritask());

                tempbean.setKouteiKnrId(tempresult.getKouteiKnrId());

                tempbean.setHknsyuruiNo(tempresult.getDisphknsyuruiworklist());

                wkList.add(tempbean);
            }

            List<WorklistViewValuesBean> retList = WorklistViewValuesCreator.createValues(
                SinkeiyakuWorkListConstants.SINKEIYAKU, wkList);

            for(int cnt = 0;cnt < retList.size();cnt++){
                ResultInfoItiranDataSourceBean tempItiranBean = new ResultInfoItiranDataSourceBean();

                tempItiranBean.setDispjimustartymdtime(retList.get(cnt).getDispjimustartymdtime());

                tempItiranBean.setMosno(retList.get(cnt).getMosno());

                String dispzenkaisyoritask = retList.get(cnt).getDispzenkaisyoritask();

                if(dispzenkaisyoritask != null){
                    tempItiranBean.setDispzenkaisyoritask(dispzenkaisyoritask.length() > 20 ? dispzenkaisyoritask.substring(0, 20) : dispzenkaisyoritask);
                }

                tempItiranBean.setDispzenkaisyoritantounm(retList.get(cnt).getDispzenkaisyoritantounm());

                tempItiranBean.setKouteiKnrId(retList.get(cnt).getKouteiKnrId());

                tempItiranBean.setDisphknsyuruiworklist(retList.get(cnt).getHknsyuruiWorklist());

                String kyknmkj = retList.get(cnt).getKyknmkj();

                if(kyknmkj != null){
                    tempItiranBean.setKyknmkj(kyknmkj.length() > 20 ? kyknmkj.substring(0, 20) : kyknmkj);
                }

                tempItiranBean.setKyknmkn(retList.get(cnt).getKyknmkn());

                tempItiranBean.setNyuuryokuLink(pList.get(cnt).getNyuuryokuLink());

                pList.set(cnt, tempItiranBean);
            }
        }

    }

    private List<ResultInfoItiranDataSourceBean> toListResultInfoItiranDSBean(List<TaskSummaryForWorkListBean> pList) {

        List<ResultInfoItiranDataSourceBean> retResultInfoItiran = Lists.newArrayList();

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        for(int cnt = 0;cnt < pList.size();cnt++){

            TaskSummaryForWorkListBean tempresult = pList.get(cnt);

            ResultInfoItiranDataSourceBean tempItiranBean = new ResultInfoItiranDataSourceBean();

            if (!Strings.isNullOrEmpty(pList.get(cnt).getJimuStartYmd())) {
                try {
                    tempItiranBean.setDispjimustartymdtime(sdf2.format(sdf1.parse(pList.get(cnt).getJimuStartYmd())));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

            tempItiranBean.setMosno(tempresult.getMosNo());

            tempItiranBean.setDispzenkaisyoritantounm(tempresult.getDispPreSyoriTantouNm());

            tempItiranBean.setDispzenkaisyoritask(tempresult.getDispPreTaskNm());

            tempItiranBean.setKouteiKnrId(tempresult.getKouteiKnrId());

            tempItiranBean.setDisphknsyuruiworklist(tempresult.getHknsyuruino());

            if(tempresult.getNyuuryokuKahi()){
                tempItiranBean.setNyuuryokuLink(SinkeiyakuWorkListConstants.NYUURYOKU_LINK);
            }

            retResultInfoItiran.add(tempItiranBean);
        }

        return retResultInfoItiran;
    }

    private boolean isHknSyuruiConvertChk(String pHknSyurui){
        boolean flg = false;
        try{
            C_HknsyuruiNo.valueOf(pHknSyurui);
        } catch(Exception e){
            flg = true;
        }
        return flg;
    }

}
