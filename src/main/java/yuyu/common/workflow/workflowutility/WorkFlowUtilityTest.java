package yuyu.common.workflow.workflowutility;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.GengouInfo;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.string.ConvertUtil;
import yuyu.common.workflow.collection.WorkListJimutetuzukiCdTaskIdSortComparator;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettorikomisyoruimst.WSGetTorikomiSyoruiMstResponse.TorikomiSyoruiBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.db.entity.DM_Jimutetuzuki;
import yuyu.def.db.entity.DM_JimutetuzukiTask;
import yuyu.def.workflow.manager.WorkflowDomManager;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;

/**
 * ワークフロー呼出ユーティリティクラス スタブ使用です。<br/>
 * YuyuWorkflowConfigのデバッグモードがtrueの場合に呼び出されます。
 */
public class WorkFlowUtilityTest {

    @Inject
    BizDomManager bizDomManager;

    @Inject
    WorkflowDomManager workflowDomManager;

    public static GetLockedTaskListResultBean getLockedTasksInfoList(
        String[] pMosNo,
        String[] pSyoNo,
        String[] pNkSysyNo,
        String[] pJimutetuzukiCd,
        String pUserId,
        List<Map<String, String>> pAdditionalParam) {

        GetLockedTaskListResultBean resultBean = new GetLockedTaskListResultBean();
        List<LockedTaskSummaryBean> beanList = new ArrayList<LockedTaskSummaryBean>();
        LockedTaskSummaryBean bean;


        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssSSS");

        String str = "";

        try {
            final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("検証№を入力:検証パターンの結果を返却\n");
            System.out.print("default:100件データ\n");

            System.out.print("1 :3件データ申込番号＝780123451，780123469，780123477\n");
            System.out.print("2 :1件データ申込番号＝780123451\n");
            System.out.print("3 :3件データ証券番号＝12806345672，12806345683，12806345694\n");
            System.out.print("4 :1件データ証券番号＝12806345672\n");
            System.out.print("5 :3件データ証券番号＝22806345675，22806345686，22806345697\n");
            System.out.print("6 :1件データ証券番号＝22806345675\n");
            System.out.print("7 :3件データ年金証書番号＝32806345678，32806345689，32806345690\n");
            System.out.print("8 :1件データ年金証書番号＝32806345678\n");
            System.out.print("10,11,12 :1件データ申込番号,証券番号,年金証書番号＝ブランクの確認\n");

            System.out.print("★★★入力してください⇒");
            str = br.readLine();
        } catch (final IOException e) {
            e.printStackTrace();
        }
        System.out.println("入力値は：" + str);

        switch(str){
            case "1":

                for (int i = 0; i <= 2; i++){
                    bean = new LockedTaskSummaryBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);

                    bean.setJimutetuzukiCd("JimuTetuzukiCd_1");
                    bean.setMosNo("MonNo_1");
                    bean.setSyoNo("SyoNo_1");
                    bean.setNkSysyNo("NkSysyNo_1");
                    bean.setKouteiKnrId("KouteiKnrId_1");
                    bean.setJimuStartYmd(BizDate.getSysDate().addBusinessDays(-3));
                    bean.setKouteiKaisiYmd(BizDate.getSysDate().addBusinessDays(-2));
                    bean.setKouteiKanryouYmd(BizDate.getSysDate().addBusinessDays(-1));
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setLastUpdateTime(sdf.format(cal.getTime()));
                    bean.setNowSyoriTantouId("TantoId_1");
                    bean.setDispNowSyoriTantouNm("担当者_1");
                    bean.setNowTaskNm("TaskNm_1");
                    bean.setNowTaskLocalNm("タスク_1");
                    beanList.add(bean);
                }
                beanList.get(0).setMosNo("780123451");
                beanList.get(1).setMosNo("780123469");
                beanList.get(2).setMosNo("780123477");

                resultBean.setLockedTaskSummaryBeanList(beanList);
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWF0000");
                resultBean.setSyousaiMessage("正常終了しました。");
                break;
            case "2":

                for (int i = 0; i <= 0; i++){
                    bean = new LockedTaskSummaryBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);

                    bean.setJimutetuzukiCd("JimuTetuzukiCd_1");
                    bean.setMosNo("MonNo_1");
                    bean.setSyoNo("SyoNo_1");
                    bean.setNkSysyNo("NkSysyNo_1");
                    bean.setKouteiKnrId("KouteiKnrId_1");
                    bean.setJimuStartYmd(BizDate.getSysDate().addBusinessDays(-3));
                    bean.setKouteiKaisiYmd(BizDate.getSysDate().addBusinessDays(-2));
                    bean.setKouteiKanryouYmd(BizDate.getSysDate().addBusinessDays(-1));
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setLastUpdateTime(sdf.format(cal.getTime()));
                    bean.setNowSyoriTantouId("TantoId_1");
                    bean.setDispNowSyoriTantouNm("担当者_1");
                    bean.setNowTaskNm("TaskNm_1");
                    bean.setNowTaskLocalNm("タスク_1");
                    beanList.add(bean);
                }
                beanList.get(0).setMosNo("780123451");

                resultBean.setLockedTaskSummaryBeanList(beanList);
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWF0000");
                resultBean.setSyousaiMessage("正常終了しました。");
                break;

            case "3":

                for (int i = 0; i <= 2; i++){
                    bean = new LockedTaskSummaryBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);

                    bean.setJimutetuzukiCd("JimuTetuzukiCd_1");
                    bean.setMosNo("MonNo_1");
                    bean.setSyoNo("SyoNo_1");
                    bean.setNkSysyNo("NkSysyNo_1");
                    bean.setKouteiKnrId("KouteiKnrId_1");
                    bean.setJimuStartYmd(BizDate.getSysDate().addBusinessDays(-3));
                    bean.setKouteiKaisiYmd(BizDate.getSysDate().addBusinessDays(-2));
                    bean.setKouteiKanryouYmd(BizDate.getSysDate().addBusinessDays(-1));
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setLastUpdateTime(sdf.format(cal.getTime()));
                    bean.setNowSyoriTantouId("TantoId_1");
                    bean.setDispNowSyoriTantouNm("担当者_1");
                    bean.setNowTaskNm("TaskNm_1");
                    bean.setNowTaskLocalNm("タスク_1");
                    beanList.add(bean);
                }
                beanList.get(0).setSyoNo("12806345672");
                beanList.get(1).setSyoNo("12806345683");
                beanList.get(2).setSyoNo("12806345694");

                resultBean.setLockedTaskSummaryBeanList(beanList);
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWF0000");
                resultBean.setSyousaiMessage("正常終了しました。");
                break;
            case "4":

                for (int i = 0; i <= 0; i++){
                    bean = new LockedTaskSummaryBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);

                    bean.setJimutetuzukiCd("JimuTetuzukiCd_1");
                    bean.setMosNo("MonNo_1");
                    bean.setSyoNo("SyoNo_1");
                    bean.setNkSysyNo("NkSysyNo_1");
                    bean.setKouteiKnrId("KouteiKnrId_1");
                    bean.setJimuStartYmd(BizDate.getSysDate().addBusinessDays(-3));
                    bean.setKouteiKaisiYmd(BizDate.getSysDate().addBusinessDays(-2));
                    bean.setKouteiKanryouYmd(BizDate.getSysDate().addBusinessDays(-1));
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setLastUpdateTime(sdf.format(cal.getTime()));
                    bean.setNowSyoriTantouId("TantoId_1");
                    bean.setDispNowSyoriTantouNm("担当者_1");
                    bean.setNowTaskNm("TaskNm_1");
                    bean.setNowTaskLocalNm("タスク_1");
                    beanList.add(bean);
                }
                beanList.get(0).setSyoNo("12806345672");

                resultBean.setLockedTaskSummaryBeanList(beanList);
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWF0000");
                resultBean.setSyousaiMessage("正常終了しました。");
                break;

            case "5":

                for (int i = 0; i <= 2; i++){
                    bean = new LockedTaskSummaryBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);

                    bean.setJimutetuzukiCd("JimuTetuzukiCd_1");
                    bean.setMosNo("MonNo_1");
                    bean.setSyoNo("SyoNo_1");
                    bean.setNkSysyNo("NkSysyNo_1");
                    bean.setKouteiKnrId("KouteiKnrId_1");
                    bean.setJimuStartYmd(BizDate.getSysDate().addBusinessDays(-3));
                    bean.setKouteiKaisiYmd(BizDate.getSysDate().addBusinessDays(-2));
                    bean.setKouteiKanryouYmd(BizDate.getSysDate().addBusinessDays(-1));
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setLastUpdateTime(sdf.format(cal.getTime()));
                    bean.setNowSyoriTantouId("TantoId_1");
                    bean.setDispNowSyoriTantouNm("担当者_1");
                    bean.setNowTaskNm("TaskNm_1");
                    bean.setNowTaskLocalNm("タスク_1");
                    beanList.add(bean);
                }
                beanList.get(0).setSyoNo("22806345675");
                beanList.get(1).setSyoNo("22806345686");
                beanList.get(2).setSyoNo("22806345697");

                resultBean.setLockedTaskSummaryBeanList(beanList);
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWF0000");
                resultBean.setSyousaiMessage("正常終了しました。");
                break;
            case "6":

                for (int i = 0; i <= 0; i++){
                    bean = new LockedTaskSummaryBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);

                    bean.setJimutetuzukiCd("JimuTetuzukiCd_1");
                    bean.setMosNo("MonNo_1");
                    bean.setSyoNo("SyoNo_1");
                    bean.setNkSysyNo("NkSysyNo_1");
                    bean.setKouteiKnrId("KouteiKnrId_1");
                    bean.setJimuStartYmd(BizDate.getSysDate().addBusinessDays(-3));
                    bean.setKouteiKaisiYmd(BizDate.getSysDate().addBusinessDays(-2));
                    bean.setKouteiKanryouYmd(BizDate.getSysDate().addBusinessDays(-1));
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setLastUpdateTime(sdf.format(cal.getTime()));
                    bean.setNowSyoriTantouId("TantoId_1");
                    bean.setDispNowSyoriTantouNm("担当者_1");
                    bean.setNowTaskNm("TaskNm_1");
                    bean.setNowTaskLocalNm("タスク_1");
                    beanList.add(bean);
                }
                beanList.get(0).setSyoNo("22806345675");

                resultBean.setLockedTaskSummaryBeanList(beanList);
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWF0000");
                resultBean.setSyousaiMessage("正常終了しました。");
                break;
            case "7":

                for (int i = 0; i <= 2; i++){
                    bean = new LockedTaskSummaryBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);

                    bean.setJimutetuzukiCd("JimuTetuzukiCd_1");
                    bean.setMosNo("MonNo_1");
                    bean.setSyoNo("SyoNo_1");
                    bean.setNkSysyNo("NkSysyNo_1");
                    bean.setKouteiKnrId("KouteiKnrId_1");
                    bean.setJimuStartYmd(BizDate.getSysDate().addBusinessDays(-3));
                    bean.setKouteiKaisiYmd(BizDate.getSysDate().addBusinessDays(-2));
                    bean.setKouteiKanryouYmd(BizDate.getSysDate().addBusinessDays(-1));
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setLastUpdateTime(sdf.format(cal.getTime()));
                    bean.setNowSyoriTantouId("TantoId_1");
                    bean.setDispNowSyoriTantouNm("担当者_1");
                    bean.setNowTaskNm("TaskNm_1");
                    bean.setNowTaskLocalNm("タスク_1");
                    beanList.add(bean);
                }
                beanList.get(0).setNkSysyNo("32806345678");
                beanList.get(1).setNkSysyNo("32806345689");
                beanList.get(2).setNkSysyNo("32806345690");

                resultBean.setLockedTaskSummaryBeanList(beanList);
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWF0000");
                resultBean.setSyousaiMessage("正常終了しました。");
                break;
            case "8":

                for (int i = 0; i <= 0; i++){
                    bean = new LockedTaskSummaryBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);

                    bean.setJimutetuzukiCd("JimuTetuzukiCd_1");
                    bean.setMosNo("MonNo_1");
                    bean.setSyoNo("SyoNo_1");
                    bean.setNkSysyNo("NkSysyNo_1");
                    bean.setKouteiKnrId("KouteiKnrId_1");
                    bean.setJimuStartYmd(BizDate.getSysDate().addBusinessDays(-3));
                    bean.setKouteiKaisiYmd(BizDate.getSysDate().addBusinessDays(-2));
                    bean.setKouteiKanryouYmd(BizDate.getSysDate().addBusinessDays(-1));
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setLastUpdateTime(sdf.format(cal.getTime()));
                    bean.setNowSyoriTantouId("TantoId_1");
                    bean.setDispNowSyoriTantouNm("担当者_1");
                    bean.setNowTaskNm("TaskNm_1");
                    bean.setNowTaskLocalNm("タスク_1");
                    beanList.add(bean);
                }
                beanList.get(0).setNkSysyNo("32806345678");

                resultBean.setLockedTaskSummaryBeanList(beanList);
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWF0000");
                resultBean.setSyousaiMessage("正常終了しました。");
                break;
            case "10":
            case "11":
            case "12":

                for (int i = 0; i <= 0; i++){
                    bean = new LockedTaskSummaryBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);
                    bean.setJimutetuzukiCd("JimuTetuzukiCd_1");
                    bean.setKouteiKnrId("KouteiKnrId_1");
                    bean.setJimuStartYmd(BizDate.getSysDate().addBusinessDays(-3));
                    bean.setKouteiKaisiYmd(BizDate.getSysDate().addBusinessDays(-2));
                    bean.setKouteiKanryouYmd(BizDate.getSysDate().addBusinessDays(-1));
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setLastUpdateTime(sdf.format(cal.getTime()));
                    bean.setNowSyoriTantouId("TantoId_1");
                    bean.setDispNowSyoriTantouNm("担当者_1");
                    bean.setNowTaskNm("TaskNm_1");
                    bean.setNowTaskLocalNm("タスク_1");
                    beanList.add(bean);
                }

                resultBean.setLockedTaskSummaryBeanList(beanList);
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWF0000");
                resultBean.setSyousaiMessage("正常終了しました。");
                break;

            case "01-024":
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NODATA);
                resultBean.setSyousaiMessageCd("IWF0000");
                resultBean.setSyousaiMessage("正常終了しました。");
                break;

            case "01-025":
                bean = new LockedTaskSummaryBean();
                cal.add(Calendar.DAY_OF_MONTH, -1);

                bean.setJimutetuzukiCd("JimuTetuzukiCd_1");
                bean.setMosNo("MonNo_1");
                bean.setSyoNo("SyoNo_1");
                bean.setNkSysyNo("NkSysyNo_1");
                bean.setKouteiKnrId("KouteiKnrId_1");
                bean.setJimuStartYmd(BizDate.getSysDate().addBusinessDays(-3));
                bean.setKouteiKaisiYmd(BizDate.getSysDate().addBusinessDays(-2));
                bean.setKouteiKanryouYmd(BizDate.getSysDate().addBusinessDays(-1));
                bean.setKouteiStatus("10");
                bean.setDispKouteiStatus("処理中");
                bean.setLastUpdateTime(sdf.format(cal.getTime()));
                bean.setNowSyoriTantouId("TantoId_1");
                bean.setDispNowSyoriTantouNm("担当者_1");
                bean.setNowTaskNm("TaskNm_1");
                bean.setNowTaskLocalNm("タスク_1");
                beanList.add(bean);

                resultBean.setLockedTaskSummaryBeanList(beanList);
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWF0000");
                resultBean.setSyousaiMessage("正常終了しました。");
                break;

            case "01-026":
                for (int i = 1; i <= 10; i++) {
                    bean = new LockedTaskSummaryBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);

                    bean.setJimutetuzukiCd("JimuTetuzukiCd_" + Integer.toString(i));
                    bean.setMosNo("MosNo_" + Integer.toString(i));
                    bean.setSyoNo("SyoNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    bean.setKouteiKnrId("KouteiKnrId_" + Integer.toString(i));
                    bean.setJimuStartYmd(BizDate.getSysDate().addBusinessDays(i));
                    bean.setKouteiKaisiYmd(BizDate.getSysDate().addBusinessDays(i+1));
                    bean.setKouteiKanryouYmd(BizDate.getSysDate().addBusinessDays(i+2));
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setLastUpdateTime(sdf.format(cal.getTime()));
                    bean.setNowSyoriTantouId("TantoId_" + Integer.toString(i));
                    bean.setDispNowSyoriTantouNm("担当者_" + Integer.toString(i));
                    bean.setNowTaskNm("TaskNm_" + Integer.toString(i));
                    bean.setNowTaskLocalNm("タスク_" + Integer.toString(i));

                    beanList.add(bean);
                }
                resultBean.setLockedTaskSummaryBeanList(beanList);
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWF0000");
                resultBean.setSyousaiMessage("正常終了しました。");
                break;

            case "01-027":
                for (int i = 1; i <= 11; i++) {
                    bean = new LockedTaskSummaryBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);

                    bean.setJimutetuzukiCd("JimuTetuzukiCd_" + Integer.toString(i));
                    bean.setMosNo("MosNo_" + Integer.toString(i));
                    bean.setSyoNo("SyoNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    bean.setKouteiKnrId("KouteiKnrId_" + Integer.toString(i));
                    bean.setJimuStartYmd(BizDate.getSysDate().addBusinessDays(i));
                    bean.setKouteiKaisiYmd(BizDate.getSysDate().addBusinessDays(i+1));
                    bean.setKouteiKanryouYmd(BizDate.getSysDate().addBusinessDays(i+2));
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setLastUpdateTime(sdf.format(cal.getTime()));
                    bean.setNowSyoriTantouId("TantoId_" + Integer.toString(i));
                    bean.setDispNowSyoriTantouNm("担当者_" + Integer.toString(i));
                    bean.setNowTaskNm("TaskNm_" + Integer.toString(i));
                    bean.setNowTaskLocalNm("タスク_" + Integer.toString(i));

                    beanList.add(bean);
                }
                resultBean.setLockedTaskSummaryBeanList(beanList);
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWF0000");
                resultBean.setSyousaiMessage("正常終了しました。");
                break;

            case "01-028":
                for (int i = 1; i <= 999; i++) {
                    bean = new LockedTaskSummaryBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);

                    bean.setJimutetuzukiCd("JimuTetuzukiCd_" + Integer.toString(i));
                    bean.setMosNo("MosNo_" + Integer.toString(i));
                    bean.setSyoNo("SyoNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    bean.setKouteiKnrId("KouteiKnrId_" + Integer.toString(i));
                    bean.setJimuStartYmd(BizDate.getSysDate().addBusinessDays(i));
                    bean.setKouteiKaisiYmd(BizDate.getSysDate().addBusinessDays(i+1));
                    bean.setKouteiKanryouYmd(BizDate.getSysDate().addBusinessDays(i+2));
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setLastUpdateTime(sdf.format(cal.getTime()));
                    bean.setNowSyoriTantouId("TantoId_" + Integer.toString(i));
                    bean.setDispNowSyoriTantouNm("担当者_" + Integer.toString(i));
                    bean.setNowTaskNm("TaskNm_" + Integer.toString(i));
                    bean.setNowTaskLocalNm("タスク_" + Integer.toString(i));

                    beanList.add(bean);
                }
                resultBean.setLockedTaskSummaryBeanList(beanList);
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWF0000");
                resultBean.setSyousaiMessage("正常終了しました。");
                break;

            case "01-029":
                for (int i = 1; i <= 1000; i++) {
                    bean = new LockedTaskSummaryBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);

                    bean.setJimutetuzukiCd("JimuTetuzukiCd_" + Integer.toString(i));
                    bean.setMosNo("MosNo_" + Integer.toString(i));
                    bean.setSyoNo("SyoNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    bean.setKouteiKnrId("KouteiKnrId_" + Integer.toString(i));
                    bean.setJimuStartYmd(BizDate.getSysDate().addBusinessDays(i));
                    bean.setKouteiKaisiYmd(BizDate.getSysDate().addBusinessDays(i+1));
                    bean.setKouteiKanryouYmd(BizDate.getSysDate().addBusinessDays(i+2));
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setLastUpdateTime(sdf.format(cal.getTime()));
                    bean.setNowSyoriTantouId("TantoId_" + Integer.toString(i));
                    bean.setDispNowSyoriTantouNm("担当者_" + Integer.toString(i));
                    bean.setNowTaskNm("TaskNm_" + Integer.toString(i));
                    bean.setNowTaskLocalNm("タスク_" + Integer.toString(i));

                    beanList.add(bean);
                }
                resultBean.setLockedTaskSummaryBeanList(beanList);
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWF0000");
                resultBean.setSyousaiMessage("正常終了しました。");
                break;

            case "01-030":
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NG);
                resultBean.setSyousaiMessageCd("IWF2160");
                resultBean.setSyousaiMessage("取得数が、上限件数を超えています。");
                break;

            case "06-003":
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NG);
                resultBean.setSyousaiMessageCd("IWF2201");
                resultBean.setSyousaiMessage("対象のトークンはロックされていません。");
                break;

            default:
                for (int i = 0; i <= 99; i++) {
                    bean = new LockedTaskSummaryBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);

                    bean.setJimutetuzukiCd("JimuTetuzukiCd_" + Integer.toString(i));
                    bean.setMosNo("MosNo_" + Integer.toString(i));
                    bean.setSyoNo("SyoNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    bean.setKouteiKnrId("KouteiKnrId_" + Integer.toString(i));
                    bean.setJimuStartYmd(BizDate.getSysDate().addBusinessDays(i));
                    bean.setKouteiKaisiYmd(BizDate.getSysDate().addBusinessDays(i+1));
                    bean.setKouteiKanryouYmd(BizDate.getSysDate().addBusinessDays(i+2));
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setLastUpdateTime(sdf.format(cal.getTime()));
                    bean.setNowSyoriTantouId("TantoId_" + Integer.toString(i));
                    bean.setDispNowSyoriTantouNm("担当者_" + Integer.toString(i));
                    bean.setNowTaskNm("TaskNm_" + Integer.toString(i));
                    bean.setNowTaskLocalNm("タスク_" + Integer.toString(i));

                    beanList.add(bean);
                }

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

                resultBean.setSyousaiMessageCd("IWFXXXX");

                resultBean.setSyousaiMessage("処理終了");

                resultBean.setLockedTaskSummaryBeanList(beanList);
                break;
        }

        return resultBean;
    }

    public static UnlockProcessForceResultBean unlockProcessForce(String pKouteiKnrId, String pJimutetuzukiCd) {

        UnlockProcessForceResultBean resultBean = new UnlockProcessForceResultBean();

        resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

        resultBean.setSyousaiMessageCd("IWFXXXX");

        resultBean.setSyousaiMessage("処理終了");

        resultBean.setSyoNo("SyoNo_1");
        resultBean.setNkSysyNo("NkSysyNo_1");

        return resultBean;
    }

    public static GetTaskTantoNmResultBean getTaskTantoNm(String[] pJimutetuzukiCd) {

        GetTaskTantoNmResultBean resultBean = new GetTaskTantoNmResultBean();
        List<TaskTantoNmBean> beanList = new ArrayList<TaskTantoNmBean>();
        TaskTantoNmBean bean;

        for (int i = 0; i <= 99; i++) {
            bean = new TaskTantoNmBean();
            bean.setTantId("TantId_" + Integer.toString(i));
            bean.setDispTntNm("担当者名_" + Integer.toString(i));

            beanList.add(bean);
        }

        resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

        resultBean.setSyousaiMessageCd("IWFXXXX");

        resultBean.setSyousaiMessage("処理終了");

        resultBean.setTaskTantoNmBeanList(beanList);


        return resultBean;
    }

    public static GetTaskTantoInfoListResultBean getTaskTantoInfoList(String pSubsystemId, String[] pJimutetuzukiCd,
        String pUserId,String pTaskNm) {
        GetTaskTantoInfoListResultBean resultBean = new GetTaskTantoInfoListResultBean();
        List<TaskTantoInfoBean> beanList = new ArrayList<TaskTantoInfoBean>();
        TaskTantoInfoBean bean;

        String str = "";

        try {
            final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("0:0件データ\n");
            System.out.print("1:1件データ\n");
            System.out.print("11、12、13、14:1件データ\n");
            System.out.print("2:10件データ\n");
            System.out.print("3:11件データ\n");
            System.out.print("4:999件データ\n");
            System.out.print("5:1000件データ\n");
            System.out.print("6:1001件データ 異常系 IWF2160（取得数が、上限件数を超えています ）\n");
            System.out.print("7:異常系 IWF0001（異常終了しました）\n");
            System.out.print("-------------------\n");
            System.out.print("default:100件データ\n");
            System.out.print("★★★入力してください⇒");
            str = br.readLine();
        } catch (final IOException e) {
            e.printStackTrace();
        }
        System.out.println("入力値は：" + str);


        switch(str){
            case "0":
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NODATA);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;

            case "11":
            case "12":
            case "13":
            case "14":
                for (int i = 1; i <= 1; i++) {
                    bean = new TaskTantoInfoBean();
                    bean.setMosNo("780123451");
                    bean.setSyoNo("12806345672");
                    bean.setNkSysyNo("12806345661");
                    bean.setKouteiKnrId("KouteiKnrId" + Integer.toString(i));
                    bean.setJimuStartYmd(BizDate.getSysDate().addDays(i - 99).toString());
                    bean.setNowSyoriTantouId("TantId_" + Integer.toString(i));
                    if(Strings.isNullOrEmpty(pUserId)){
                        bean.setDispNowSyoriTantouNm("担当者名_" + Integer.toString(i));
                    }else{
                        String[] splitUserId = pUserId.split("_");
                        bean.setDispNowSyoriTantouNm("担当者名_" + splitUserId[1]);
                    }
                    bean.setNowTaskNm("TaskNm_" + Integer.toString(i));

                    beanList.add(bean);
                }
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;

            case "1":
                for (int i = 1; i <= 1; i++) {
                    bean = new TaskTantoInfoBean();
                    bean.setSyoNo("SyoNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    bean.setKouteiKnrId("KouteiKnrId" + Integer.toString(i));
                    bean.setJimuStartYmd(BizDate.getSysDate().addDays(i - 99).toString());
                    bean.setNowSyoriTantouId("TantId_" + Integer.toString(i));
                    if(Strings.isNullOrEmpty(pUserId)){
                        bean.setDispNowSyoriTantouNm("担当者名_" + Integer.toString(i));
                    }else{
                        String[] splitUserId = pUserId.split("_");
                        bean.setDispNowSyoriTantouNm("担当者名_" + splitUserId[1]);
                    }
                    bean.setNowTaskNm("TaskNm_" + Integer.toString(i));

                    beanList.add(bean);
                }
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;

            case "2":
                for (int i = 1; i <= 10; i++) {
                    bean = new TaskTantoInfoBean();
                    bean.setSyoNo("SyoNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    bean.setKouteiKnrId("KouteiKnrId" + Integer.toString(i));
                    bean.setJimuStartYmd(BizDate.getSysDate().addDays(i - 99).toString());
                    bean.setNowSyoriTantouId("TantId_" + Integer.toString(i));
                    if(Strings.isNullOrEmpty(pUserId)){
                        bean.setDispNowSyoriTantouNm("担当者名_" + Integer.toString(i));
                    }else{
                        String[] splitUserId = pUserId.split("_");
                        bean.setDispNowSyoriTantouNm("担当者名_" + splitUserId[1]);
                    }
                    bean.setNowTaskNm("TaskNm_" + Integer.toString(i));

                    beanList.add(bean);
                }
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;

            case "3":
                for (int i = 1; i <= 11; i++) {
                    bean = new TaskTantoInfoBean();
                    bean.setSyoNo("SyoNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    bean.setKouteiKnrId("KouteiKnrId" + Integer.toString(i));
                    bean.setJimuStartYmd(BizDate.getSysDate().addDays(i - 99).toString());
                    bean.setNowSyoriTantouId("TantId_" + Integer.toString(i));
                    if(Strings.isNullOrEmpty(pUserId)){
                        bean.setDispNowSyoriTantouNm("担当者名_" + Integer.toString(i));
                    }else{
                        String[] splitUserId = pUserId.split("_");
                        bean.setDispNowSyoriTantouNm("担当者名_" + splitUserId[1]);
                    }
                    bean.setNowTaskNm("TaskNm_" + Integer.toString(i));
                    beanList.add(bean);
                }
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;

            case "4":
                for (int i = 1; i <= 999; i++) {
                    bean = new TaskTantoInfoBean();
                    bean.setSyoNo("SyoNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    bean.setKouteiKnrId("KouteiKnrId" + Integer.toString(i));
                    bean.setJimuStartYmd(BizDate.getSysDate().addDays(i - 99).toString());
                    bean.setNowSyoriTantouId("TantId_" + Integer.toString(i));
                    if(Strings.isNullOrEmpty(pUserId)){
                        bean.setDispNowSyoriTantouNm("担当者名_" + Integer.toString(i));
                    }else{
                        String[] splitUserId = pUserId.split("_");
                        bean.setDispNowSyoriTantouNm("担当者名_" + splitUserId[1]);
                    }
                    bean.setNowTaskNm("TaskNm_" + Integer.toString(i));
                    beanList.add(bean);
                }
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;

            case "5":
                for (int i = 1; i <= 1000; i++) {
                    bean = new TaskTantoInfoBean();
                    bean.setSyoNo("SyoNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    bean.setKouteiKnrId("KouteiKnrId" + Integer.toString(i));
                    bean.setJimuStartYmd(BizDate.getSysDate().addDays(i - 99).toString());
                    bean.setNowSyoriTantouId("TantId_" + Integer.toString(i));
                    if(Strings.isNullOrEmpty(pUserId)){
                        bean.setDispNowSyoriTantouNm("担当者名_" + Integer.toString(i));
                    }else{
                        String[] splitUserId = pUserId.split("_");
                        bean.setDispNowSyoriTantouNm("担当者名_" + splitUserId[1]);
                    }
                    bean.setNowTaskNm("TaskNm_" + Integer.toString(i));

                    beanList.add(bean);
                }
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;

            case "6":
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NG);
                resultBean.setSyousaiMessageCd("IWF2160");
                resultBean.setSyousaiMessage("取得数が、上限件数を超えています");
                break;

            case "7":
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NG);
                resultBean.setSyousaiMessageCd("IWF0001");
                resultBean.setSyousaiMessage("異常終了しました");
                break;

            default:
                for (int i = 1; i <= 100; i++) {
                    bean = new TaskTantoInfoBean();
                    bean.setSyoNo("SyoNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    bean.setKouteiKnrId("KouteiKnrId" + Integer.toString(i));
                    bean.setJimuStartYmd(BizDate.getSysDate().addDays(i - 99).toString());
                    bean.setNowSyoriTantouId("TantId_" + Integer.toString(i));
                    if(Strings.isNullOrEmpty(pUserId)){
                        bean.setDispNowSyoriTantouNm("担当者名_" + Integer.toString(i));
                    }else{
                        String[] splitUserId = pUserId.split("_");
                        bean.setDispNowSyoriTantouNm("担当者名_" + splitUserId[1]);
                    }
                    bean.setNowTaskNm("TaskNm_" + Integer.toString(i));
                    beanList.add(bean);
                }
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;

        }
        resultBean.setTaskTantoInfoBeanList(beanList);

        return resultBean;
    }

    public static WorkListUnassignTaskResultBean unassignTask(String pKouteiKnrId, String pJimutetuzukiCd,String pTaskNm, String pUserId, String pRirekiUserId){

        WorkListUnassignTaskResultBean resultBean = new WorkListUnassignTaskResultBean();

        resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

        resultBean.setSyousaiMessageCd("IWFXXXX");

        resultBean.setSyousaiMessage("処理終了");

        resultBean.setErrorApiName("");

        return resultBean;
    }

    public static GetTasksForCancelResultBean getTasksForCancel(
        String pSubsystemId,
        String pMosNo,
        String pSyoNo,
        String pNkSysyNo,
        String pJimutetuzukiCd){

        GetTasksForCancelResultBean resultBean = new GetTasksForCancelResultBean();
        List<TaskForCancelBean> beanList = new ArrayList<TaskForCancelBean>();
        TaskForCancelBean bean;

        String str = "";

        try {
            final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("0:0件データ\n");
            System.out.print("1:1件データ証券番号=12806345672　\n");
            System.out.print("2:1件データ年金証書番号=32345678901　\n");

            System.out.print("default:1件以上データ\n");
            System.out.print("★★★入力してください⇒");
            str = br.readLine();
        } catch (final IOException e) {
            e.printStackTrace();
        }
        System.out.println("入力値は：" + str);

        switch(str){
            case "0":
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("正常終了しました。");
                break;

            case "1":
                bean = new TaskForCancelBean();
                bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(0));
                bean.setJimutetuzukiNm("事務手続名_" + Integer.toString(0));
                bean.setSyoNo("12806345672");
                bean.setJimuStartYmd(BizDate.getSysDate().addBusinessDays(0).toString());
                bean.setKouteiKaisiYmd(BizDate.getSysDate().addBusinessDays(0).toString());
                bean.setKouteiStatus("10");
                bean.setDispKouteiStatus("処理中");
                bean.setTantouId("TantoId_" + Integer.toString(0));
                bean.setDispTantouNm("担当者_" + Integer.toString(0));
                bean.setKouteiKnrId("KouteiKnrId_" + Integer.toString(0));

                beanList.add(bean);

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

                resultBean.setSyousaiMessageCd("IWFXXXX");

                resultBean.setSyousaiMessage("処理終了");

                resultBean.setTaskForCancelBeanList(beanList);
                break;

            case "2":
                bean = new TaskForCancelBean();
                bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(0));
                bean.setJimutetuzukiNm("事務手続名_" + Integer.toString(0));
                bean.setNkSysyNo("32345678901");
                bean.setJimuStartYmd(BizDate.getSysDate().addBusinessDays(0).toString());
                bean.setKouteiKaisiYmd(BizDate.getSysDate().addBusinessDays(0).toString());
                bean.setKouteiStatus("10");
                bean.setDispKouteiStatus("処理中");
                bean.setTantouId("TantoId_" + Integer.toString(0));
                bean.setDispTantouNm("担当者_" + Integer.toString(0));
                bean.setKouteiKnrId("KouteiKnrId_" + Integer.toString(0));

                beanList.add(bean);

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

                resultBean.setSyousaiMessageCd("IWFXXXX");

                resultBean.setSyousaiMessage("処理終了");

                resultBean.setTaskForCancelBeanList(beanList);
                break;

            default:
                for (int i = 0; i <= 99; i++) {
                    bean = new TaskForCancelBean();
                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setJimutetuzukiNm("事務手続名_" + Integer.toString(i));
                    bean.setSyoNo("SyoNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    bean.setJimuStartYmd(BizDate.getSysDate().addBusinessDays(i).toString());
                    bean.setKouteiKaisiYmd(BizDate.getSysDate().addBusinessDays(i+1).toString());
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setTantouId("TantoId_" + Integer.toString(i));
                    bean.setDispTantouNm("担当者_" + Integer.toString(i));
                    bean.setKouteiKnrId("KouteiKnrId_" + Integer.toString(i));

                    beanList.add(bean);
                }
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

                resultBean.setSyousaiMessageCd("IWFXXXX");

                resultBean.setSyousaiMessage("処理終了");

                resultBean.setTaskForCancelBeanList(beanList);

                break;
        }


        return resultBean;
    }

    public static GetTasksForPutImageResultBean getTasksForPutImage(
        String pJimutetuzukiCd,
        String pMosNo,
        String pSyoNo,
        String pNkSysyNo,
        String pJimuKaisiYmdFrom,
        String pJimuKaisiYmdTo,
        String pSyoriStatus,
        String pJimuyouCd,
        String pWariateSousasyaId,
        String pIsWariate,
        String pSousasyaId){

        GetTasksForPutImageResultBean resultBean = new GetTasksForPutImageResultBean();
        List<TaskSummaryForPutImageBean> taskSummaryBeanList = new ArrayList<TaskSummaryForPutImageBean>();
        TaskSummaryForPutImageBean taskSummaryBean;

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssSSS");


        String str = "";

        try {
            final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("0:0件データ\n");
            System.out.print("1:1件データ\n");
            System.out.print("2:10件データ\n");
            System.out.print("3:11件データ\n");
            System.out.print("4:999件データ\n");
            System.out.print("5:1000件データ\n");
            System.out.print("6:1001件 異常系 IWF2160（取得数が、上限件数を超えています ）\n");
            System.out.print("7:異常系 IWF0001（異常終了しました）\n");
            System.out.print("-------------------\n");
            System.out.print("default:100件データ\n");
            System.out.print("★★★入力してください⇒");
            str = br.readLine();
        } catch (final IOException e) {
            e.printStackTrace();
        }
        System.out.println("入力値は：" + str);

        switch(str){
            case "0":
                System.out.println("CASE 0\n");
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;

            case "1":
                System.out.println("CASE 1\n");
                taskSummaryBean = new TaskSummaryForPutImageBean();
                cal.add(Calendar.DAY_OF_MONTH, -1);

                taskSummaryBean.setSyoNo("SyoNo_" + Integer.toString(0));
                taskSummaryBean.setNkSysyNo("NkSysyNo_" + Integer.toString(0));
                taskSummaryBean.setKouteiKnrId("KouteiKnrId_" + Integer.toString(0));
                taskSummaryBean.setJimuStartYmd(BizDate.getSysDate().addBusinessDays(0));
                taskSummaryBean.setKouteiKaisiYmd(BizDate.getSysDate().addBusinessDays(1));
                taskSummaryBean.setKouteiKanryouYmd(BizDate.getSysDate().addBusinessDays(2));
                taskSummaryBean.setKouteiStatus("10");
                taskSummaryBean.setDispKouteiStatus("処理中");
                taskSummaryBean.setLastUpdateTime(sdf.format(cal.getTime()));
                taskSummaryBean.setNowSyoriTantouId("TantoId_" + Integer.toString(0));
                taskSummaryBean.setDispNowSyoriTantouNm("担当者_" + Integer.toString(0));
                taskSummaryBean.setNowTaskNm("TaskNm_" + Integer.toString(0));
                taskSummaryBean.setNowTaskLocalNm("タスク_" + Integer.toString(0));

                taskSummaryBeanList.add(taskSummaryBean);
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;

            case "2":
                System.out.println("CASE 2\n");

                for (int i = 0; i <= 9; i++) {
                    taskSummaryBean = new TaskSummaryForPutImageBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);

                    taskSummaryBean.setSyoNo("SyoNo_" + Integer.toString(i));
                    taskSummaryBean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    taskSummaryBean.setKouteiKnrId("KouteiKnrId_" + Integer.toString(i));
                    taskSummaryBean.setJimuStartYmd(BizDate.getSysDate().addBusinessDays(i));
                    taskSummaryBean.setKouteiKaisiYmd(BizDate.getSysDate().addBusinessDays(i+1));
                    taskSummaryBean.setKouteiKanryouYmd(BizDate.getSysDate().addBusinessDays(i+2));
                    taskSummaryBean.setKouteiStatus("10");
                    taskSummaryBean.setDispKouteiStatus("処理中");
                    taskSummaryBean.setLastUpdateTime(sdf.format(cal.getTime()));
                    taskSummaryBean.setNowSyoriTantouId("TantoId_" + Integer.toString(i));
                    taskSummaryBean.setDispNowSyoriTantouNm("担当者_" + Integer.toString(i));
                    taskSummaryBean.setNowTaskNm("TaskNm_" + Integer.toString(i));
                    taskSummaryBean.setNowTaskLocalNm("タスク_" + Integer.toString(i));

                    taskSummaryBeanList.add(taskSummaryBean);
                }
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;

            case "3":
                System.out.println("CASE 3\n");

                for (int i = 0; i <= 10; i++) {
                    taskSummaryBean = new TaskSummaryForPutImageBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);

                    taskSummaryBean.setSyoNo("SyoNo_" + Integer.toString(i));
                    taskSummaryBean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    taskSummaryBean.setKouteiKnrId("KouteiKnrId_" + Integer.toString(i));
                    taskSummaryBean.setJimuStartYmd(BizDate.getSysDate().addBusinessDays(i));
                    taskSummaryBean.setKouteiKaisiYmd(BizDate.getSysDate().addBusinessDays(i+1));
                    taskSummaryBean.setKouteiKanryouYmd(BizDate.getSysDate().addBusinessDays(i+2));
                    taskSummaryBean.setKouteiStatus("10");
                    taskSummaryBean.setDispKouteiStatus("処理中");
                    taskSummaryBean.setLastUpdateTime(sdf.format(cal.getTime()));
                    taskSummaryBean.setNowSyoriTantouId("TantoId_" + Integer.toString(i));
                    taskSummaryBean.setDispNowSyoriTantouNm("担当者_" + Integer.toString(i));
                    taskSummaryBean.setNowTaskNm("TaskNm_" + Integer.toString(i));
                    taskSummaryBean.setNowTaskLocalNm("タスク_" + Integer.toString(i));

                    taskSummaryBeanList.add(taskSummaryBean);
                }
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;

            case "4":
                System.out.println("CASE 4\n");

                for (int i = 0; i <= 998; i++) {
                    taskSummaryBean = new TaskSummaryForPutImageBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);

                    taskSummaryBean.setSyoNo("SyoNo_" + Integer.toString(i));
                    taskSummaryBean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    taskSummaryBean.setKouteiKnrId("KouteiKnrId_" + Integer.toString(i));
                    taskSummaryBean.setJimuStartYmd(BizDate.getSysDate().addBusinessDays(i));
                    taskSummaryBean.setKouteiKaisiYmd(BizDate.getSysDate().addBusinessDays(i+1));
                    taskSummaryBean.setKouteiKanryouYmd(BizDate.getSysDate().addBusinessDays(i+2));
                    taskSummaryBean.setKouteiStatus("10");
                    taskSummaryBean.setDispKouteiStatus("処理中");
                    taskSummaryBean.setLastUpdateTime(sdf.format(cal.getTime()));
                    taskSummaryBean.setNowSyoriTantouId("TantoId_" + Integer.toString(i));
                    taskSummaryBean.setDispNowSyoriTantouNm("担当者_" + Integer.toString(i));
                    taskSummaryBean.setNowTaskNm("TaskNm_" + Integer.toString(i));
                    taskSummaryBean.setNowTaskLocalNm("タスク_" + Integer.toString(i));

                    taskSummaryBeanList.add(taskSummaryBean);
                }
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;

            case "5":
                System.out.println("CASE 5\n");

                for (int i = 0; i <= 999; i++) {
                    taskSummaryBean = new TaskSummaryForPutImageBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);

                    taskSummaryBean.setSyoNo("SyoNo_" + Integer.toString(i));
                    taskSummaryBean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    taskSummaryBean.setKouteiKnrId("KouteiKnrId_" + Integer.toString(i));
                    taskSummaryBean.setJimuStartYmd(BizDate.getSysDate().addBusinessDays(i));
                    taskSummaryBean.setKouteiKaisiYmd(BizDate.getSysDate().addBusinessDays(i+1));
                    taskSummaryBean.setKouteiKanryouYmd(BizDate.getSysDate().addBusinessDays(i+2));
                    taskSummaryBean.setKouteiStatus("10");
                    taskSummaryBean.setDispKouteiStatus("処理中");
                    taskSummaryBean.setLastUpdateTime(sdf.format(cal.getTime()));
                    taskSummaryBean.setNowSyoriTantouId("TantoId_" + Integer.toString(i));
                    taskSummaryBean.setDispNowSyoriTantouNm("担当者_" + Integer.toString(i));
                    taskSummaryBean.setNowTaskNm("TaskNm_" + Integer.toString(i));
                    taskSummaryBean.setNowTaskLocalNm("タスク_" + Integer.toString(i));

                    taskSummaryBeanList.add(taskSummaryBean);
                }
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;

            case "6":
                System.out.print("CASE 6\n");
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NG);
                resultBean.setSyousaiMessageCd("IWF2160");
                resultBean.setSyousaiMessage("取得数が、上限件数を超えています");
                break;

            case "7":
                System.out.print("CASE 7\n");
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NG);
                resultBean.setSyousaiMessageCd("IWF0001");
                resultBean.setSyousaiMessage("異常終了しました");
                break;

            default:
                System.out.print("default  100件\n");
                for (int i = 0; i <= 99; i++) {
                    taskSummaryBean = new TaskSummaryForPutImageBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);

                    taskSummaryBean.setSyoNo("SyoNo_" + Integer.toString(i));
                    taskSummaryBean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    taskSummaryBean.setKouteiKnrId("KouteiKnrId_" + Integer.toString(i));
                    taskSummaryBean.setJimuStartYmd(BizDate.getSysDate().addBusinessDays(i));
                    taskSummaryBean.setKouteiKaisiYmd(BizDate.getSysDate().addBusinessDays(i+1));
                    taskSummaryBean.setKouteiKanryouYmd(BizDate.getSysDate().addBusinessDays(i+2));
                    taskSummaryBean.setKouteiStatus("10");
                    taskSummaryBean.setDispKouteiStatus("処理中");
                    taskSummaryBean.setLastUpdateTime(sdf.format(cal.getTime()));
                    taskSummaryBean.setNowSyoriTantouId("TantoId_" + Integer.toString(i));
                    taskSummaryBean.setDispNowSyoriTantouNm("担当者_" + Integer.toString(i));
                    taskSummaryBean.setNowTaskNm("TaskNm_" + Integer.toString(i));
                    taskSummaryBean.setNowTaskLocalNm("タスク_" + Integer.toString(i));

                    taskSummaryBeanList.add(taskSummaryBean);
                }
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;

        }


        resultBean.setTaskSummaryBeanList(taskSummaryBeanList);

        return resultBean;
    }

    public static GetTasksForHyousiResultBean getTasksForHyousi(
        String pSubsystemId,
        String pJimutetuzukiCd,
        String pMosNo,
        String pSyoNo,
        String pNkSysyNo,
        String pUserId) {
        GetTasksForHyousiResultBean resultBean = new GetTasksForHyousiResultBean();
        List<TaskSummaryForHyousiBean> beanList = new ArrayList<TaskSummaryForHyousiBean>();
        TaskSummaryForHyousiBean bean;

        String str = "";

        try {
            final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("0:0件データ\n");
            System.out.print("1:1件データ\n");
            System.out.print("2:10件データ\n");
            System.out.print("3:11件データ\n");
            System.out.print("4:999件データ\n");

            System.out.print("12,15,18,21:0件データ\n");
            System.out.print("13:1件データ 申込番号　＝　890123466\n");
            System.out.print("16:1件データ 証券番号　＝　12806345683\n");
            System.out.print("19:1件データ 証券番号　＝　12806345708\n");
            System.out.print("22:1件データ 年金証書番号　＝　12806345720\n");

            System.out.print("5:異常系 IWF0001（異常終了しました）\n");
            System.out.print("6:完了/処理中 \n");
            System.out.print("-------------------\n");
            System.out.print("default:100件データ\n");
            System.out.print("★★★入力してください⇒");
            str = br.readLine();
        } catch (final IOException e) {
            e.printStackTrace();
        }
        System.out.println("入力値は：" + str);

        switch(str) {

            case "12":
            case "15":
            case "18":
            case "21":
                System.out.print("CASE  12,15,18,21\n");
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                resultBean.setTaskSummaryForHyousiBeanList(beanList);
                break;

            case "13":
                System.out.print("CASE  13\n");
                bean = new TaskSummaryForHyousiBean();
                bean.setMosNo("890123466");
                bean.setKouteiKnrId("KouteiKnrId" + Integer.toString(0));
                bean.setJimuStartYmd(BizDate.getSysDate().addBusinessDays(0).toString());
                bean.setKouteiKaisiYmd(BizDate.getSysDate().addBusinessDays(1).toString());
                bean.setKouteiKanryouYmd(BizDate.getSysDate().addBusinessDays(2).toString());
                bean.setKouteiStatus("10");
                bean.setDispKouteiStatus("処理中");

                beanList.add(bean);

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;
            case "16":
                System.out.print("CASE  16\n");
                bean = new TaskSummaryForHyousiBean();
                bean.setSyoNo("12806345683");
                bean.setKouteiKnrId("KouteiKnrId" + Integer.toString(0));
                bean.setJimuStartYmd(BizDate.getSysDate().addBusinessDays(0).toString());
                bean.setKouteiKaisiYmd(BizDate.getSysDate().addBusinessDays(1).toString());
                bean.setKouteiKanryouYmd(BizDate.getSysDate().addBusinessDays(2).toString());
                bean.setKouteiStatus("10");
                bean.setDispKouteiStatus("処理中");

                beanList.add(bean);

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;
            case "19":
                System.out.print("CASE  19\n");
                bean = new TaskSummaryForHyousiBean();
                bean.setSyoNo("12806345708");
                bean.setKouteiKnrId("KouteiKnrId" + Integer.toString(0));
                bean.setJimuStartYmd(BizDate.getSysDate().addBusinessDays(0).toString());
                bean.setKouteiKaisiYmd(BizDate.getSysDate().addBusinessDays(1).toString());
                bean.setKouteiKanryouYmd(BizDate.getSysDate().addBusinessDays(2).toString());
                bean.setKouteiStatus("10");
                bean.setDispKouteiStatus("処理中");

                beanList.add(bean);

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;
            case "22":
                System.out.print("CASE  22\n");
                bean = new TaskSummaryForHyousiBean();
                bean.setNkSysyNo("12806345720");
                bean.setKouteiKnrId("KouteiKnrId" + Integer.toString(0));
                bean.setJimuStartYmd(BizDate.getSysDate().addBusinessDays(0).toString());
                bean.setKouteiKaisiYmd(BizDate.getSysDate().addBusinessDays(1).toString());
                bean.setKouteiKanryouYmd(BizDate.getSysDate().addBusinessDays(2).toString());
                bean.setKouteiStatus("10");
                bean.setDispKouteiStatus("処理中");

                beanList.add(bean);

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;
            case "0":
                System.out.print("CASE  0\n");
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                resultBean.setTaskSummaryForHyousiBeanList(beanList);
                break;

            case "1":
                System.out.print("CASE  1\n");
                bean = new TaskSummaryForHyousiBean();
                bean.setSyoNo("SyoNo_" + Integer.toString(0));
                bean.setNkSysyNo("NkSysyNo_" + Integer.toString(0));
                bean.setKouteiKnrId("KouteiKnrId" + Integer.toString(0));
                bean.setJimuStartYmd(BizDate.getSysDate().addBusinessDays(0).toString());
                bean.setKouteiKaisiYmd(BizDate.getSysDate().addBusinessDays(1).toString());
                bean.setKouteiKanryouYmd(BizDate.getSysDate().addBusinessDays(2).toString());
                bean.setKouteiStatus("10");
                bean.setDispKouteiStatus("処理中");

                beanList.add(bean);

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;

            case "2":
                System.out.print("CASE  2\n");
                for (int i = 0; i <= 9; i++) {
                    bean = new TaskSummaryForHyousiBean();
                    bean.setSyoNo("SyoNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    bean.setKouteiKnrId("KouteiKnrId" + Integer.toString(i));
                    bean.setJimuStartYmd(BizDate.getSysDate().addBusinessDays(i).toString());
                    bean.setKouteiKaisiYmd(BizDate.getSysDate().addBusinessDays(i+1).toString());
                    bean.setKouteiKanryouYmd(BizDate.getSysDate().addBusinessDays(i+2).toString());
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");

                    beanList.add(bean);
                }
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;

            case "3":
                System.out.print("CASE  3\n");
                for (int i = 0; i <= 10; i++) {
                    bean = new TaskSummaryForHyousiBean();
                    bean.setSyoNo("SyoNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    bean.setKouteiKnrId("KouteiKnrId" + Integer.toString(i));
                    bean.setJimuStartYmd(BizDate.getSysDate().addBusinessDays(i).toString());
                    bean.setKouteiKaisiYmd(BizDate.getSysDate().addBusinessDays(i+1).toString());
                    bean.setKouteiKanryouYmd(BizDate.getSysDate().addBusinessDays(i+2).toString());
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");

                    beanList.add(bean);
                }
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;

            case "4":
                System.out.print("CASE  4\n");
                for (int i = 0; i <= 998; i++) {
                    bean = new TaskSummaryForHyousiBean();
                    bean.setSyoNo("SyoNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    bean.setKouteiKnrId("KouteiKnrId" + Integer.toString(i));
                    bean.setJimuStartYmd(BizDate.getSysDate().addBusinessDays(i).toString());
                    bean.setKouteiKaisiYmd(BizDate.getSysDate().addBusinessDays(i+1).toString());
                    bean.setKouteiKanryouYmd(BizDate.getSysDate().addBusinessDays(i+2).toString());
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");

                    beanList.add(bean);
                }
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;

            case "5":
                System.out.print("CASE 5\n");
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NG);
                resultBean.setSyousaiMessageCd("IWF0001");
                resultBean.setSyousaiMessage("異常終了しました");
                break;

            case "6":
                System.out.print("CASE6 100件\n");
                for (int i = 0; i <= 99; i++) {
                    bean = new TaskSummaryForHyousiBean();
                    bean.setSyoNo("SyoNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    bean.setKouteiKnrId("KouteiKnrId" + Integer.toString(i));
                    bean.setJimuStartYmd(BizDate.getSysDate().addBusinessDays(i).toString());
                    bean.setKouteiKaisiYmd(BizDate.getSysDate().addBusinessDays(i+1).toString());
                    if ((i%2) == 1) {
                        bean.setKouteiKanryouYmd(BizDate.getSysDate().addBusinessDays(i+2).toString());
                        bean.setKouteiStatus("90");
                        bean.setDispKouteiStatus("完了");
                    } else {
                        bean.setKouteiKanryouYmd(null);
                        bean.setKouteiStatus("10");
                        bean.setDispKouteiStatus("処理中");
                    }
                    bean.setKouteiKanryouYmd(BizDate.getSysDate().addBusinessDays(i+2).toString());
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");

                    beanList.add(bean);
                }
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;

            default:
                System.out.print("DEFAULT 100件\n");
                for (int i = 0; i <= 99; i++) {
                    bean = new TaskSummaryForHyousiBean();
                    bean.setSyoNo("SyoNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    bean.setKouteiKnrId("KouteiKnrId" + Integer.toString(i));
                    bean.setJimuStartYmd(BizDate.getSysDate().addBusinessDays(i).toString());
                    bean.setKouteiKaisiYmd(BizDate.getSysDate().addBusinessDays(i+1).toString());
                    bean.setKouteiKanryouYmd(BizDate.getSysDate().addBusinessDays(i+2).toString());
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");

                    beanList.add(bean);
                }
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;

        }

        resultBean.setTaskSummaryForHyousiBeanList(beanList);


        return resultBean;
    }


    public static GetTasksForKouteiStatusResultBean getTasksForKouteiStatus(
        String pSubsystemId,
        String[] pMosNo,
        String[] pSyoNo,
        String[] pNkSysyNo,
        String[] pJimutetuzukiCd,
        String pJimuKaisiYmdFrom,
        String pJimuKaisiYmdTo,
        String pKouteiKanryouYmdFrom,
        String pKouteiKanryouYmdTo,
        String pLastUpdateYmdFrom,
        String pLastUpdateYmdTo,
        String[] pSyoriStatus,
        String pJimuyouCd,
        String pJimuyouCdUmu,
        String pWariateUserId,
        String pIsWariate,
        String pUserId,
        String pTaskNm,
        boolean pSubflowincludeCheckBox) {

        final GetTasksForKouteiStatusResultBean resultBean = new GetTasksForKouteiStatusResultBean();
        final List<TaskSummaryForKouteiStatusBean> beanList = new ArrayList<TaskSummaryForKouteiStatusBean>();
        TaskSummaryForKouteiStatusBean bean;

        final Calendar cal = Calendar.getInstance();
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssSSS");

        String str = "";
        try {
            final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("0 :0件データ IWF0000（正常終了しました）\n");
            System.out.print("1 :10件データ\n");
            System.out.print("2 :11件データ\n");
            System.out.print("3 :100件データ\n");
            System.out.print("4 :101件データ\n");
            System.out.print("5 :1000件データ\n");
            System.out.print("6 :1件データ\n");
            System.out.print("10 :異常系 1000件超過 IWF2160\n");
            System.out.print("11 :異常系 異常発生\n");

            System.out.print("21 :3件データ申込番号＝890123458，890123466，890123474\n");
            System.out.print("22 :1件データ申込番号＝890123458\n");
            System.out.print("23 :3件データ証券番号＝12806345672，12806345683，12806345694\n");
            System.out.print("24 :1件データ証券番号＝12806345672\n");
            System.out.print("25 :3件データ証券番号＝32806345612，32806345623，32806345634\n");
            System.out.print("26 :1件データ証券番号＝32806345612\n");
            System.out.print("27 :3件データ年金証書番号＝42806345637，42806345648，42806345659\n");
            System.out.print("28 :1件データ年金証書番号＝42806345637\n");
            System.out.print("29 :1件データ申込番号，証券番号，年金証書番号＝ブランクの確認\n");
            System.out.print("d :defalt 100件+区分値\n");

            System.out.print("入力してください⇒");
            str = br.readLine();
        } catch (final IOException e) {
            e.printStackTrace();
        }
        System.out.println("入力値は：" + str);

        switch(str){
            case "21":
                System.out.println("CASE 21");
                for (int i = 0; i <= 2; i++) {
                    bean = new TaskSummaryForKouteiStatusBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);
                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setJimutetuzukiNm("事務手続名_" + Integer.toString(i));
                    bean.setSyoNo("SyoNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    bean.setKouteiKnrId("KouteiKnrId" + Integer.toString(i));
                    bean.setJimuStartYmd(BizDate.getSysDate().addBusinessDays(i).toString());
                    bean.setKouteiKaisiYmd(BizDate.getSysDate().addBusinessDays(i+1).toString());
                    bean.setKouteiKanryouYmd(BizDate.getSysDate().addBusinessDays(i+2).toString());
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setLastUpdateTime(sdf.format(cal.getTime()));
                    bean.setNowSyoriTantouId("TantoId_" + Integer.toString(i));
                    bean.setDispNowSyoriTantouNm("担当者_" + Integer.toString(i));
                    bean.setNowTaskNm("TaskNm_" + Integer.toString(i));
                    bean.setNowTaskLocalNm("タスク_" + Integer.toString(i));

                    beanList.add(bean);
                }
                beanList.get(0).setMosNo("890123458");
                beanList.get(1).setMosNo("890123466");
                beanList.get(2).setMosNo("890123474");

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWF0000");
                resultBean.setSyousaiMessage("処理終了");
                break;
            case "22":
                System.out.println("CASE 22");
                for (int i = 0; i <= 0; i++) {
                    bean = new TaskSummaryForKouteiStatusBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);
                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setJimutetuzukiNm("事務手続名_" + Integer.toString(i));
                    bean.setSyoNo("SyoNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    bean.setKouteiKnrId("KouteiKnrId" + Integer.toString(i));
                    bean.setJimuStartYmd(BizDate.getSysDate().addBusinessDays(i).toString());
                    bean.setKouteiKaisiYmd(BizDate.getSysDate().addBusinessDays(i+1).toString());
                    bean.setKouteiKanryouYmd(BizDate.getSysDate().addBusinessDays(i+2).toString());
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setLastUpdateTime(sdf.format(cal.getTime()));
                    bean.setNowSyoriTantouId("TantoId_" + Integer.toString(i));
                    bean.setDispNowSyoriTantouNm("担当者_" + Integer.toString(i));
                    bean.setNowTaskNm("TaskNm_" + Integer.toString(i));
                    bean.setNowTaskLocalNm("タスク_" + Integer.toString(i));

                    beanList.add(bean);
                }
                beanList.get(0).setMosNo("890123458");

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWF0000");
                resultBean.setSyousaiMessage("処理終了");
                break;
            case "23":
                System.out.println("CASE 23");
                for (int i = 0; i <= 2; i++) {
                    bean = new TaskSummaryForKouteiStatusBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);
                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setJimutetuzukiNm("事務手続名_" + Integer.toString(i));
                    bean.setSyoNo("SyoNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    bean.setKouteiKnrId("KouteiKnrId" + Integer.toString(i));
                    bean.setJimuStartYmd(BizDate.getSysDate().addBusinessDays(i).toString());
                    bean.setKouteiKaisiYmd(BizDate.getSysDate().addBusinessDays(i+1).toString());
                    bean.setKouteiKanryouYmd(BizDate.getSysDate().addBusinessDays(i+2).toString());
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setLastUpdateTime(sdf.format(cal.getTime()));
                    bean.setNowSyoriTantouId("TantoId_" + Integer.toString(i));
                    bean.setDispNowSyoriTantouNm("担当者_" + Integer.toString(i));
                    bean.setNowTaskNm("TaskNm_" + Integer.toString(i));
                    bean.setNowTaskLocalNm("タスク_" + Integer.toString(i));

                    beanList.add(bean);
                }
                beanList.get(0).setSyoNo("12806345672");
                beanList.get(1).setSyoNo("12806345683");
                beanList.get(2).setSyoNo("12806345694");

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWF0000");
                resultBean.setSyousaiMessage("処理終了");
                break;
            case "24":
                System.out.println("CASE 24");
                for (int i = 0; i <= 0; i++) {
                    bean = new TaskSummaryForKouteiStatusBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);
                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setJimutetuzukiNm("事務手続名_" + Integer.toString(i));
                    bean.setSyoNo("SyoNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    bean.setKouteiKnrId("KouteiKnrId" + Integer.toString(i));
                    bean.setJimuStartYmd(BizDate.getSysDate().addBusinessDays(i).toString());
                    bean.setKouteiKaisiYmd(BizDate.getSysDate().addBusinessDays(i+1).toString());
                    bean.setKouteiKanryouYmd(BizDate.getSysDate().addBusinessDays(i+2).toString());
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setLastUpdateTime(sdf.format(cal.getTime()));
                    bean.setNowSyoriTantouId("TantoId_" + Integer.toString(i));
                    bean.setDispNowSyoriTantouNm("担当者_" + Integer.toString(i));
                    bean.setNowTaskNm("TaskNm_" + Integer.toString(i));
                    bean.setNowTaskLocalNm("タスク_" + Integer.toString(i));

                    beanList.add(bean);
                }
                beanList.get(0).setSyoNo("12806345672");

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWF0000");
                resultBean.setSyousaiMessage("処理終了");
                break;
            case "25":
                System.out.println("CASE 25");
                for (int i = 0; i <= 2; i++) {
                    bean = new TaskSummaryForKouteiStatusBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);
                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setJimutetuzukiNm("事務手続名_" + Integer.toString(i));
                    bean.setSyoNo("SyoNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    bean.setKouteiKnrId("KouteiKnrId" + Integer.toString(i));
                    bean.setJimuStartYmd(BizDate.getSysDate().addBusinessDays(i).toString());
                    bean.setKouteiKaisiYmd(BizDate.getSysDate().addBusinessDays(i+1).toString());
                    bean.setKouteiKanryouYmd(BizDate.getSysDate().addBusinessDays(i+2).toString());
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setLastUpdateTime(sdf.format(cal.getTime()));
                    bean.setNowSyoriTantouId("TantoId_" + Integer.toString(i));
                    bean.setDispNowSyoriTantouNm("担当者_" + Integer.toString(i));
                    bean.setNowTaskNm("TaskNm_" + Integer.toString(i));
                    bean.setNowTaskLocalNm("タスク_" + Integer.toString(i));

                    beanList.add(bean);
                }
                beanList.get(0).setSyoNo("32806345612");
                beanList.get(1).setSyoNo("32806345623");
                beanList.get(2).setSyoNo("32806345634");

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWF0000");
                resultBean.setSyousaiMessage("処理終了");
                break;
            case "26":
                System.out.println("CASE 26");
                for (int i = 0; i <= 0; i++) {
                    bean = new TaskSummaryForKouteiStatusBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);
                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setJimutetuzukiNm("事務手続名_" + Integer.toString(i));
                    bean.setSyoNo("SyoNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    bean.setKouteiKnrId("KouteiKnrId" + Integer.toString(i));
                    bean.setJimuStartYmd(BizDate.getSysDate().addBusinessDays(i).toString());
                    bean.setKouteiKaisiYmd(BizDate.getSysDate().addBusinessDays(i+1).toString());
                    bean.setKouteiKanryouYmd(BizDate.getSysDate().addBusinessDays(i+2).toString());
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setLastUpdateTime(sdf.format(cal.getTime()));
                    bean.setNowSyoriTantouId("TantoId_" + Integer.toString(i));
                    bean.setDispNowSyoriTantouNm("担当者_" + Integer.toString(i));
                    bean.setNowTaskNm("TaskNm_" + Integer.toString(i));
                    bean.setNowTaskLocalNm("タスク_" + Integer.toString(i));

                    beanList.add(bean);
                }
                beanList.get(0).setSyoNo("32806345612");

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWF0000");
                resultBean.setSyousaiMessage("処理終了");
                break;
            case "27":
                System.out.println("CASE 27");
                for (int i = 0; i <= 2; i++) {
                    bean = new TaskSummaryForKouteiStatusBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);
                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setJimutetuzukiNm("事務手続名_" + Integer.toString(i));
                    bean.setSyoNo("SyoNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    bean.setKouteiKnrId("KouteiKnrId" + Integer.toString(i));
                    bean.setJimuStartYmd(BizDate.getSysDate().addBusinessDays(i).toString());
                    bean.setKouteiKaisiYmd(BizDate.getSysDate().addBusinessDays(i+1).toString());
                    bean.setKouteiKanryouYmd(BizDate.getSysDate().addBusinessDays(i+2).toString());
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setLastUpdateTime(sdf.format(cal.getTime()));
                    bean.setNowSyoriTantouId("TantoId_" + Integer.toString(i));
                    bean.setDispNowSyoriTantouNm("担当者_" + Integer.toString(i));
                    bean.setNowTaskNm("TaskNm_" + Integer.toString(i));
                    bean.setNowTaskLocalNm("タスク_" + Integer.toString(i));

                    beanList.add(bean);
                }
                beanList.get(0).setNkSysyNo("42806345637");
                beanList.get(1).setNkSysyNo("42806345648");
                beanList.get(2).setNkSysyNo("42806345659");

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWF0000");
                resultBean.setSyousaiMessage("処理終了");
                break;
            case "28":
                System.out.println("CASE 28");
                for (int i = 0; i <= 0; i++) {
                    bean = new TaskSummaryForKouteiStatusBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);
                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setJimutetuzukiNm("事務手続名_" + Integer.toString(i));
                    bean.setSyoNo("SyoNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    bean.setKouteiKnrId("KouteiKnrId" + Integer.toString(i));
                    bean.setJimuStartYmd(BizDate.getSysDate().addBusinessDays(i).toString());
                    bean.setKouteiKaisiYmd(BizDate.getSysDate().addBusinessDays(i+1).toString());
                    bean.setKouteiKanryouYmd(BizDate.getSysDate().addBusinessDays(i+2).toString());
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setLastUpdateTime(sdf.format(cal.getTime()));
                    bean.setNowSyoriTantouId("TantoId_" + Integer.toString(i));
                    bean.setDispNowSyoriTantouNm("担当者_" + Integer.toString(i));
                    bean.setNowTaskNm("TaskNm_" + Integer.toString(i));
                    bean.setNowTaskLocalNm("タスク_" + Integer.toString(i));

                    beanList.add(bean);
                }
                beanList.get(0).setNkSysyNo("42806345637");

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWF0000");
                resultBean.setSyousaiMessage("処理終了");
                break;
            case "29":
                System.out.println("CASE 29");
                for (int i = 0; i <= 2; i++) {
                    bean = new TaskSummaryForKouteiStatusBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);
                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setJimutetuzukiNm("事務手続名_" + Integer.toString(i));
                    bean.setKouteiKnrId("KouteiKnrId" + Integer.toString(i));
                    bean.setJimuStartYmd(BizDate.getSysDate().addBusinessDays(i).toString());
                    bean.setKouteiKaisiYmd(BizDate.getSysDate().addBusinessDays(i+1).toString());
                    bean.setKouteiKanryouYmd(BizDate.getSysDate().addBusinessDays(i+2).toString());
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setLastUpdateTime(sdf.format(cal.getTime()));
                    bean.setNowSyoriTantouId("TantoId_" + Integer.toString(i));
                    bean.setDispNowSyoriTantouNm("担当者_" + Integer.toString(i));
                    bean.setNowTaskNm("TaskNm_" + Integer.toString(i));
                    bean.setNowTaskLocalNm("タスク_" + Integer.toString(i));

                    beanList.add(bean);
                }

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWF0000");
                resultBean.setSyousaiMessage("処理終了");
                break;
            case "0":
                System.out.println("CASE 0");
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NODATA);
                resultBean.setSyousaiMessageCd("IWF0000");
                resultBean.setSyousaiMessage("処理終了");
                break;

            case "1":
                System.out.println("CASE 1");
                for (int i = 0; i <= 9; i++) {
                    bean = new TaskSummaryForKouteiStatusBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);

                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setJimutetuzukiNm("事務手続名_" + Integer.toString(i));
                    bean.setSyoNo("SyoNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    bean.setKouteiKnrId("KouteiKnrId" + Integer.toString(i));
                    bean.setJimuStartYmd(BizDate.getSysDate().addBusinessDays(i).toString());
                    bean.setKouteiKaisiYmd(BizDate.getSysDate().addBusinessDays(i+1).toString());
                    bean.setKouteiKanryouYmd(BizDate.getSysDate().addBusinessDays(i+2).toString());
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setLastUpdateTime(sdf.format(cal.getTime()));
                    bean.setNowSyoriTantouId("TantoId_" + Integer.toString(i));
                    bean.setDispNowSyoriTantouNm("担当者_" + Integer.toString(i));
                    bean.setNowTaskNm("TaskNm_" + Integer.toString(i));
                    bean.setNowTaskLocalNm("タスク_" + Integer.toString(i));

                    beanList.add(bean);
                }
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWF0000");
                resultBean.setSyousaiMessage("処理終了");
                break;


            case "2":
                System.out.println("CASE 1");
                for (int i = 0; i <= 10; i++) {
                    bean = new TaskSummaryForKouteiStatusBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);

                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setJimutetuzukiNm("事務手続名_" + Integer.toString(i));
                    bean.setSyoNo("SyoNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    bean.setKouteiKnrId("KouteiKnrId" + Integer.toString(i));
                    bean.setJimuStartYmd(BizDate.getSysDate().addBusinessDays(i).toString());
                    bean.setKouteiKaisiYmd(BizDate.getSysDate().addBusinessDays(i+1).toString());
                    bean.setKouteiKanryouYmd(BizDate.getSysDate().addBusinessDays(i+2).toString());
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setLastUpdateTime(sdf.format(cal.getTime()));
                    bean.setNowSyoriTantouId("TantoId_" + Integer.toString(i));
                    bean.setDispNowSyoriTantouNm("担当者_" + Integer.toString(i));
                    bean.setNowTaskNm("TaskNm_" + Integer.toString(i));
                    bean.setNowTaskLocalNm("タスク_" + Integer.toString(i));

                    beanList.add(bean);
                }
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWF0000");
                resultBean.setSyousaiMessage("処理終了");
                break;

            case "3":
                System.out.println("CASE 1");
                for (int i = 0; i <= 99; i++) {
                    bean = new TaskSummaryForKouteiStatusBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);

                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setJimutetuzukiNm("事務手続名_" + Integer.toString(i));
                    bean.setSyoNo("SyoNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    bean.setKouteiKnrId("KouteiKnrId" + Integer.toString(i));
                    bean.setJimuStartYmd(BizDate.getSysDate().addBusinessDays(i).toString());
                    bean.setKouteiKaisiYmd(BizDate.getSysDate().addBusinessDays(i+1).toString());
                    bean.setKouteiKanryouYmd(BizDate.getSysDate().addBusinessDays(i+2).toString());
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setLastUpdateTime(sdf.format(cal.getTime()));
                    bean.setNowSyoriTantouId("TantoId_" + Integer.toString(i));
                    bean.setDispNowSyoriTantouNm("担当者_" + Integer.toString(i));
                    bean.setNowTaskNm("TaskNm_" + Integer.toString(i));
                    bean.setNowTaskLocalNm("タスク_" + Integer.toString(i));

                    beanList.add(bean);
                }
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWF0000");
                resultBean.setSyousaiMessage("処理終了");
                break;

            case "4":
                System.out.println("CASE 1");
                for (int i = 0; i <= 100; i++) {
                    bean = new TaskSummaryForKouteiStatusBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);

                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setJimutetuzukiNm("事務手続名_" + Integer.toString(i));
                    bean.setSyoNo("SyoNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    bean.setKouteiKnrId("KouteiKnrId" + Integer.toString(i));
                    bean.setJimuStartYmd(BizDate.getSysDate().addBusinessDays(i).toString());
                    bean.setKouteiKaisiYmd(BizDate.getSysDate().addBusinessDays(i+1).toString());
                    bean.setKouteiKanryouYmd(BizDate.getSysDate().addBusinessDays(i+2).toString());
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setLastUpdateTime(sdf.format(cal.getTime()));
                    bean.setNowSyoriTantouId("TantoId_" + Integer.toString(i));
                    bean.setDispNowSyoriTantouNm("担当者_" + Integer.toString(i));
                    bean.setNowTaskNm("TaskNm_" + Integer.toString(i));
                    bean.setNowTaskLocalNm("タスク_" + Integer.toString(i));

                    beanList.add(bean);
                }
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWF0000");
                resultBean.setSyousaiMessage("処理終了");
                break;

            case "5":
                System.out.println("CASE 1");
                for (int i = 0; i <= 999; i++) {
                    bean = new TaskSummaryForKouteiStatusBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);

                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setJimutetuzukiNm("事務手続名_" + Integer.toString(i));
                    bean.setSyoNo("SyoNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    bean.setKouteiKnrId("KouteiKnrId" + Integer.toString(i));
                    bean.setJimuStartYmd(BizDate.getSysDate().addBusinessDays(i).toString());
                    bean.setKouteiKaisiYmd(BizDate.getSysDate().addBusinessDays(i+1).toString());
                    bean.setKouteiKanryouYmd(BizDate.getSysDate().addBusinessDays(i+2).toString());
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setLastUpdateTime(sdf.format(cal.getTime()));
                    bean.setNowSyoriTantouId("TantoId_" + Integer.toString(i));
                    bean.setDispNowSyoriTantouNm("担当者_" + Integer.toString(i));
                    bean.setNowTaskNm("TaskNm_" + Integer.toString(i));
                    bean.setNowTaskLocalNm("タスク_" + Integer.toString(i));

                    beanList.add(bean);
                }
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWF0000");
                resultBean.setSyousaiMessage("処理終了");
                break;

            case "6":
                System.out.println("CASE 6");
                for (int i = 0; i <= 0; i++) {
                    bean = new TaskSummaryForKouteiStatusBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);

                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setJimutetuzukiNm("事務手続名_" + Integer.toString(i));
                    bean.setSyoNo("SyoNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    bean.setJimuStartYmd(BizDate.getSysDate().addBusinessDays(i).toString());
                    bean.setKouteiKaisiYmd(BizDate.getSysDate().addBusinessDays(i+1).toString());
                    bean.setKouteiKanryouYmd(BizDate.getSysDate().addBusinessDays(i+2).toString());
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setLastUpdateTime(sdf.format(cal.getTime()));
                    bean.setNowSyoriTantouId("TantoId_" + Integer.toString(i));
                    bean.setDispNowSyoriTantouNm("担当者_" + Integer.toString(i));
                    bean.setNowTaskNm("TaskNm_" + Integer.toString(i));
                    bean.setNowTaskLocalNm("タスク_" + Integer.toString(i));

                    beanList.add(bean);
                }
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWF0000");
                resultBean.setSyousaiMessage("処理終了");
                break;

            case "10":
                System.out.println("CASE 1");

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NG);
                resultBean.setSyousaiMessageCd("IWF2160");
                resultBean.setSyousaiMessage("異常終了");
                break;

            case "11":
                System.out.println("CASE 1");
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NG);
                resultBean.setSyousaiMessageCd("IWF0001");
                resultBean.setSyousaiMessage("異常終了");

                break;

            default:


                for (int j = 0; j <= 99; j++) {
                    String.valueOf(j%3);
                    System.out.println("j=" + j + " :" +String.valueOf(j%3));
                }

                for (int i = 0; i <= 99; i++) {
                    bean = new TaskSummaryForKouteiStatusBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);

                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setJimutetuzukiNm("事務手続名_" + Integer.toString(i));
                    bean.setSyoNo("SyoNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    bean.setKouteiKnrId("KouteiKnrId" + Integer.toString(i));
                    bean.setJimuStartYmd(BizDate.getSysDate().addBusinessDays(i).toString());
                    bean.setKouteiKaisiYmd(BizDate.getSysDate().addBusinessDays(i+1).toString());
                    bean.setKouteiKanryouYmd(BizDate.getSysDate().addBusinessDays(i+2).toString());
                    String a1 = "";
                    if(String.valueOf(i%3).equals("0")){
                        a1 = "10";
                    }else if(String.valueOf(i%3).equals("1")){
                        a1 = "90";
                    }else{
                        a1 = "99";
                    }
                    bean.setKouteiStatus(a1);
                    bean.setDispKouteiStatus("処理中");
                    bean.setLastUpdateTime(sdf.format(cal.getTime()));
                    bean.setNowSyoriTantouId("TantoId_" + Integer.toString(i));
                    bean.setDispNowSyoriTantouNm("担当者_" + Integer.toString(i));
                    bean.setNowTaskNm("TaskNm_" + Integer.toString(i));
                    bean.setNowTaskLocalNm("タスク_" + Integer.toString(i));

                    beanList.add(bean);
                }
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWF0000");
                resultBean.setSyousaiMessage("処理終了");
                break;

        }
        resultBean.setTaskSummaryForKouteiStatusBeanList(beanList);

        return resultBean;

    }

    public static GetTasksForQrSealResultBean getTasksForQrSeal(
        String[] pMosNo,
        String[] pSyoNo,
        String[] pNkSysyNo) {
        GetTasksForQrSealResultBean resultBean = new GetTasksForQrSealResultBean();
        List<TaskSummaryForQrSealBean> beanList = new ArrayList<TaskSummaryForQrSealBean>();
        TaskSummaryForQrSealBean bean;

        String str = "";
        try {
            final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("0 :証券番号に紐づく案件が存在しない（NO DATA）\n");
            System.out.print("1 :異常系 異常発生\n");
            System.out.print("2 :指定された申込番号は存在しません。（NO DATA）\n");
            System.out.print("-------------------\n");
            System.out.print("default:正常データ\n");

            System.out.print("入力してください⇒");
            str = br.readLine();
        } catch (final IOException e) {
            e.printStackTrace();
        }
        System.out.println("入力値は：" + str);

        switch(str){
            case "0":
                System.out.println("CASE 0");
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NODATA);
                resultBean.setSyousaiMessageCd("IWF0000");
                resultBean.setSyousaiMessage("処理終了");
                break;

            case "2":
                System.out.println("CASE 2");
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NODATA);
                resultBean.setSyousaiMessageCd("IWF0000");
                resultBean.setSyousaiMessage("処理終了");
                break;

            case "1":
                System.out.println("CASE 1");
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NG);
                resultBean.setSyousaiMessageCd("IWF0000");
                resultBean.setSyousaiMessage("異常終了");
                break;

            default :
                for (int i = 0; i <= 99; i++) {
                    bean = new TaskSummaryForQrSealBean();
                    bean.setSyoNo("SyoNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    bean.setKouteiKnrId("KouteiKnrId" + Integer.toString(i));

                    beanList.add(bean);
                }

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                resultBean.setTaskSummaryForQrSealBeanList(beanList);
        }



        return resultBean;
    }

    public static GetExecutableTasksForWorkListSkResultBean getExecutableTasksForWorkListSk(
        String pSubsystemId,
        String pMosNo,
        String pSyoNo,
        String pNkSysyNo,
        String pJimutetuzukiCd,
        String pJimuKaisiYmdFrom,
        String pJimuKaisiYmdTo,
        String pMousikomiYmdFrom,
        String pMousikomiYmdTo,
        String pJimuyouCd,
        String pJimuyouCdUmu,
        String pWariateUserId,
        String pTaskNm,
        String[] pChannel,
        String[] pMousikomiHou,
        String[] pSyouhinCd,
        String[] pDairiten,
        String pChildDairitenUmu,
        String pDoujiMousikomi) {

        GetExecutableTasksForWorkListSkResultBean resultBean = new GetExecutableTasksForWorkListSkResultBean();
        List<ExecutableTaskInfoBean> beanList = new ArrayList<ExecutableTaskInfoBean>();
        ExecutableTaskInfoBean bean;

        String[] jimutetuzukiArray = null;

        Map<String,String> jimutetuzukiNmMap = Maps.newHashMap();
        Map<String,String> taskNmMap = Maps.newHashMap();

        Map<String,Integer> jimutetuzukiOrderMap = Maps.newHashMap();

        Map<String,Integer> taskOrderMap = Maps.newHashMap();

        WorkflowDomManager workflowDomManager = SWAKInjector.getInstance(WorkflowDomManager.class);

        List<DM_Jimutetuzuki> jimutetuzukiList = Lists.newArrayList();


        jimutetuzukiArray = new String[jimutetuzukiList.size()];
        for (int i = 0; i < jimutetuzukiList.size(); i++) {
            jimutetuzukiArray[i] = jimutetuzukiList.get(i).getJimutetuzukicd();
            if(!jimutetuzukiNmMap.containsKey(jimutetuzukiList.get(i).getJimutetuzukicd())){
                jimutetuzukiNmMap.put(
                    jimutetuzukiList.get(i).getJimutetuzukicd(),
                    jimutetuzukiList.get(i).getJimutetuzukinm());
            }

            if(!jimutetuzukiOrderMap.containsKey(jimutetuzukiList.get(i).getJimutetuzukicd())){
                jimutetuzukiOrderMap.put(
                    jimutetuzukiList.get(i).getJimutetuzukicd(),
                    jimutetuzukiList.get(i).getHyoujijyun());
            }
        }

        List<DM_JimutetuzukiTask> taskList = Lists.newArrayList();


        for (int i = 0; i < taskList.size(); i++) {
            if(!taskNmMap.containsKey(taskList.get(i).getWorkflowTskId())){
                taskNmMap.put(
                    taskList.get(i).getWorkflowTskId(),
                    taskList.get(i).getWorkflowTskNm());
            }

            if(!taskOrderMap.containsKey(taskList.get(i).getWorkflowTskId())){
                taskOrderMap.put(
                    taskList.get(i).getWorkflowTskId(),
                    taskList.get(i).getHyoujijyun());
            }
        }

        Ordering<ExecutableTaskInfoBean> ordering = Ordering.from(new WorkListJimutetuzukiCdTaskIdSortComparator());
        List<ExecutableTaskInfoBean> sortedBean;

        String str = "";

        try {
            final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("0 :権限なし データなし\n");
            System.out.print("1 :権限あり データ　0件\n");

            System.out.print("6 :データ3新契約 \n");
            System.out.print("7 :データ1新契約 \n");
            System.out.print("8 :データ3新契約 \n");
            System.out.print("9 :データ1新契約 \n");
            System.out.print("その他 :データあり\n");

            System.out.print("入力してください⇒");
            str = br.readLine();
        } catch (final IOException e) {
            e.printStackTrace();
        }
        System.out.println("入力値は：" + str);

        switch(str){

            case "6":

                for (int i = 0; i < 3; i++) {
                    bean = new ExecutableTaskInfoBean();
                    bean.setJimutetuzukiCd("10000000000000000" + (i + 1));
                    bean.setTaskNm("TASK1" + i);
                    bean.setDispTaskNm("DISPTASK1" + i);
                    bean.setJimutetuzukiNm("事務手続名" + (i + 1) );
                    bean.setSharedTaskNum(BizNumber.valueOf(1000 + i));
                    bean.setPersonalizedTaskNum(BizNumber.valueOf(1000 + 1 + i));

                    bean.setJimutetuzukiDispOrder(15);
                    bean.setTaskDispOrder(15);

                    beanList.add(bean);
                }

                sortedBean = ordering.sortedCopy(beanList);

                resultBean.setExecutableTaskInfoBeanList(sortedBean);

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");

                break;

            case "7":

                for (int i = 0; i < 1; i++) {
                    bean = new ExecutableTaskInfoBean();
                    bean.setJimutetuzukiCd("100000000000000004");
                    bean.setTaskNm("TASK4");
                    bean.setDispTaskNm("DISPTASK4");
                    bean.setJimutetuzukiNm("事務手続名4");
                    bean.setSharedTaskNum(BizNumber.valueOf(1000 + i));
                    bean.setPersonalizedTaskNum(BizNumber.valueOf(1000 + 1 + i));

                    bean.setJimutetuzukiDispOrder(15);
                    bean.setTaskDispOrder(15);

                    beanList.add(bean);
                }

                sortedBean = ordering.sortedCopy(beanList);

                resultBean.setExecutableTaskInfoBeanList(sortedBean);

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");

                break;

            case "8":

                for (int i = 0; i < 3; i++) {
                    bean = new ExecutableTaskInfoBean();
                    bean.setJimutetuzukiCd("10000000000000000" + (i + 5) );
                    bean.setTaskNm("TASK" + (i + 5)  );
                    bean.setDispTaskNm("DISPTASK" + (i + 5) );
                    bean.setJimutetuzukiNm("事務手続名" + (i + 5) );
                    bean.setSharedTaskNum(BizNumber.valueOf(1000 + i));
                    bean.setPersonalizedTaskNum(BizNumber.valueOf(1000 + 1 + i));

                    bean.setJimutetuzukiDispOrder(15);
                    bean.setTaskDispOrder(15);

                    beanList.add(bean);
                }

                sortedBean = ordering.sortedCopy(beanList);

                resultBean.setExecutableTaskInfoBeanList(sortedBean);

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");

                break;

            case "9":

                for (int i = 0; i < 1; i++) {
                    bean = new ExecutableTaskInfoBean();
                    bean.setJimutetuzukiCd("10000000000000000" + (i + 8) );
                    bean.setTaskNm("TASK" + (i + 8)  );
                    bean.setDispTaskNm("DISPTASK" + (i + 8) );
                    bean.setJimutetuzukiNm("事務手続名" + (i + 8) );
                    bean.setSharedTaskNum(BizNumber.valueOf(1000 + i));
                    bean.setPersonalizedTaskNum(BizNumber.valueOf(1000 + 1 + i));

                    bean.setJimutetuzukiDispOrder(15);
                    bean.setTaskDispOrder(15);

                    beanList.add(bean);
                }

                sortedBean = ordering.sortedCopy(beanList);

                resultBean.setExecutableTaskInfoBeanList(sortedBean);

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");

                break;

            case "0":

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NODATA);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");

                resultBean.setExecutableTaskInfoBeanList(beanList);
                break;


            case "1":

                for (int i = 0; i < taskList.size(); i++) {
                    bean = new ExecutableTaskInfoBean();
                    bean.setJimutetuzukiCd(taskList.get(i).getJimutetuzukicd());
                    bean.setTaskNm(taskList.get(i).getWorkflowTskId());
                    bean.setDispTaskNm(taskNmMap.get(bean.getTaskNm()));
                    bean.setJimutetuzukiNm(jimutetuzukiNmMap.get(bean.getJimutetuzukiCd()));
                    bean.setSharedTaskNum(BizNumber.valueOf(0));
                    bean.setPersonalizedTaskNum(BizNumber.valueOf(0));

                    bean.setJimutetuzukiDispOrder(jimutetuzukiOrderMap.get(bean.getJimutetuzukiCd()));
                    bean.setTaskDispOrder(taskOrderMap.get(bean.getTaskNm()));

                    beanList.add(bean);
                }


                sortedBean = ordering.sortedCopy(beanList);

                resultBean.setExecutableTaskInfoBeanList(sortedBean);

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");

                break;

            default:

                for (int i = 0; i < taskList.size(); i++) {
                    bean = new ExecutableTaskInfoBean();
                    bean.setJimutetuzukiCd(taskList.get(i).getJimutetuzukicd());
                    bean.setTaskNm(taskList.get(i).getWorkflowTskId());
                    bean.setDispTaskNm(taskNmMap.get(bean.getTaskNm()));
                    bean.setJimutetuzukiNm(jimutetuzukiNmMap.get(bean.getJimutetuzukiCd()));
                    bean.setSharedTaskNum(BizNumber.valueOf(i * 1000));
                    bean.setPersonalizedTaskNum(BizNumber.valueOf(i * 1000 + 1));

                    bean.setJimutetuzukiDispOrder(jimutetuzukiOrderMap.get(bean.getJimutetuzukiCd()));
                    bean.setTaskDispOrder(taskOrderMap.get(bean.getTaskNm()));

                    beanList.add(bean);
                }

                sortedBean = ordering.sortedCopy(beanList);

                resultBean.setExecutableTaskInfoBeanList(sortedBean);

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");

                break;
        }

        return resultBean;

    }


    public static GetExecutableTasksForWorkListResultBean getExecutableTasksForWorkList(
        String pSubsystemId,
        String pMosNo,
        String pSyoNo,
        String pNkSysyNo,
        String pJimutetuzukiCd,
        String pJimuKaisiYmdFrom,
        String pJimuKaisiYmdTo,
        String pJimuyouCd,
        String pJimuyouCdUmu,
        String pWariateUserId) {

        GetExecutableTasksForWorkListResultBean resultBean = new GetExecutableTasksForWorkListResultBean();
        List<ExecutableTaskInfoBean> beanList = new ArrayList<ExecutableTaskInfoBean>();
        ExecutableTaskInfoBean bean;

        String[] jimutetuzukiArray = null;

        Map<String,String> jimutetuzukiNmMap = Maps.newHashMap();
        Map<String,String> taskNmMap = Maps.newHashMap();

        Map<String,Integer> jimutetuzukiOrderMap = Maps.newHashMap();

        Map<String,Integer> taskOrderMap = Maps.newHashMap();


        WorkflowDomManager workflowDomManager = SWAKInjector.getInstance(WorkflowDomManager.class);

        List<DM_Jimutetuzuki> jimutetuzukiList = Lists.newArrayList();


        jimutetuzukiArray = new String[jimutetuzukiList.size()];
        for (int i = 0; i < jimutetuzukiList.size(); i++) {
            jimutetuzukiArray[i] = jimutetuzukiList.get(i).getJimutetuzukicd();
            if(!jimutetuzukiNmMap.containsKey(jimutetuzukiList.get(i).getJimutetuzukicd())){
                jimutetuzukiNmMap.put(
                    jimutetuzukiList.get(i).getJimutetuzukicd(),
                    jimutetuzukiList.get(i).getJimutetuzukinm());
            }

            if(!jimutetuzukiOrderMap.containsKey(jimutetuzukiList.get(i).getJimutetuzukicd())){
                jimutetuzukiOrderMap.put(
                    jimutetuzukiList.get(i).getJimutetuzukicd(),
                    jimutetuzukiList.get(i).getHyoujijyun());
            }
        }

        List<DM_JimutetuzukiTask> taskList = Lists.newArrayList();


        for (int i = 0; i < taskList.size(); i++) {
            if(!taskNmMap.containsKey(taskList.get(i).getWorkflowTskId())){
                taskNmMap.put(
                    taskList.get(i).getWorkflowTskId(),
                    taskList.get(i).getWorkflowTskNm());
            }

            if(!taskOrderMap.containsKey(taskList.get(i).getWorkflowTskId())){
                taskOrderMap.put(
                    taskList.get(i).getWorkflowTskId(),
                    taskList.get(i).getHyoujijyun());
            }
        }

        Ordering<ExecutableTaskInfoBean> ordering = Ordering.from(new WorkListJimutetuzukiCdTaskIdSortComparator());
        List<ExecutableTaskInfoBean> sortedBean;

        String str = "";
        try {
            final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("0 :権限なし データなし\n");
            System.out.print("1 :権限あり データ　0件\n");
            System.out.print("その他 :データあり\n");

            System.out.print("10 :権限あり 契約保全、年金、保険金　データ　1件\n");
            System.out.print("11 :住所変更-入力　データ　1件\n");

            System.out.print("入力してください⇒");
            str = br.readLine();
        } catch (final IOException e) {
            e.printStackTrace();
        }
        System.out.println("入力値は：" + str);

        switch(str){
            case "0":

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NODATA);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                resultBean.setExecutableTaskInfoBeanList(beanList);
                break;


            case "1":
                for (int i = 0; i < taskList.size(); i++) {
                    bean = new ExecutableTaskInfoBean();
                    bean.setJimutetuzukiCd(taskList.get(i).getJimutetuzukicd());
                    bean.setTaskNm(taskList.get(i).getWorkflowTskId());
                    bean.setDispTaskNm(taskNmMap.get(bean.getTaskNm()));
                    bean.setJimutetuzukiNm(jimutetuzukiNmMap.get(bean.getJimutetuzukiCd()));
                    bean.setSharedTaskNum(BizNumber.valueOf(0));
                    bean.setPersonalizedTaskNum(BizNumber.valueOf(0));

                    bean.setJimutetuzukiDispOrder(jimutetuzukiOrderMap.get(bean.getJimutetuzukiCd()));
                    bean.setTaskDispOrder(taskOrderMap.get(bean.getTaskNm()));

                    beanList.add(bean);
                }

                sortedBean = ordering.sortedCopy(beanList);

                resultBean.setExecutableTaskInfoBeanList(sortedBean);

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");

                break;

            case "10":

                for (int i = 0; i < 1; i++) {
                    bean = new ExecutableTaskInfoBean();
                    bean.setJimutetuzukiCd("1000000000000000015");
                    bean.setTaskNm("TASK15");
                    bean.setDispTaskNm("DISPTASK15");
                    bean.setJimutetuzukiNm("事務手続名15");
                    bean.setSharedTaskNum(BizNumber.valueOf(1000));
                    bean.setPersonalizedTaskNum(BizNumber.valueOf(1000 + 1));

                    bean.setJimutetuzukiDispOrder(15);
                    bean.setTaskDispOrder(15);

                    beanList.add(bean);
                }

                sortedBean = ordering.sortedCopy(beanList);

                resultBean.setExecutableTaskInfoBeanList(sortedBean);

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");

                break;

            case "11":

                for (int i = 0; i < 1; i++) {
                    bean = new ExecutableTaskInfoBean();
                    bean.setJimutetuzukiCd("khjyuusyohenkou");
                    bean.setTaskNm("input");
                    bean.setDispTaskNm("住所変更-入力");
                    bean.setJimutetuzukiNm("住所変更");
                    bean.setSharedTaskNum(BizNumber.valueOf(1000));
                    bean.setPersonalizedTaskNum(BizNumber.valueOf(1000 + 1));

                    bean.setJimutetuzukiDispOrder(15);
                    bean.setTaskDispOrder(15);

                    beanList.add(bean);
                }

                sortedBean = ordering.sortedCopy(beanList);

                resultBean.setExecutableTaskInfoBeanList(sortedBean);

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");

                break;

            default:


                for (int i = 0; i < taskList.size(); i++) {
                    bean = new ExecutableTaskInfoBean();
                    bean.setJimutetuzukiCd(taskList.get(i).getJimutetuzukicd());
                    bean.setTaskNm(taskList.get(i).getWorkflowTskId());
                    bean.setDispTaskNm(taskNmMap.get(bean.getTaskNm()));
                    bean.setJimutetuzukiNm(jimutetuzukiNmMap.get(bean.getJimutetuzukiCd()));
                    bean.setSharedTaskNum(BizNumber.valueOf(i * 1000));
                    bean.setPersonalizedTaskNum(BizNumber.valueOf(i * 1000 + 1));

                    bean.setJimutetuzukiDispOrder(jimutetuzukiOrderMap.get(bean.getJimutetuzukiCd()));
                    bean.setTaskDispOrder(taskOrderMap.get(bean.getTaskNm()));

                    beanList.add(bean);
                }

                sortedBean = ordering.sortedCopy(beanList);

                resultBean.setExecutableTaskInfoBeanList(sortedBean);

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");

                break;
        }

        return resultBean;

    }


    public static GetTasksForWorkListSkResultBean getTasksForWorkListSk(
        String pSubsystemId,
        String pMosNo,
        String pSyoNo,
        String pNkSysyNo,
        String pJimutetuzukiCd,
        String pJimuKaisiYmdFrom,
        String pJimuKaisiYmdTo,
        String pMousikomiYmdFrom,
        String pMousikomiYmdTo,
        String pJimuyouCd,
        String pJimuyouCdUmu,
        String pWariateUserId,
        String pIsWariate,
        String pTaskNm,
        String[] pChannel,
        String[] pMousikomiHou,
        String[] pSyouhinCd,
        String[] pDairiten,
        String pChildDairitenUmu,
        String pDoujiMousikomi) {

        GetTasksForWorkListSkResultBean resultBean = new GetTasksForWorkListSkResultBean();
        List<TaskSummaryForWorkListBean> beanList = new ArrayList<TaskSummaryForWorkListBean>();
        TaskSummaryForWorkListBean bean = new TaskSummaryForWorkListBean();

        String str = "";
        try {
            final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("0 :0件データ\n");
            System.out.print("1 :100件データ（前回タスク名20,21文字チェック、前回担当者8,9文字チェック）\n");
            System.out.print("2 :1000件データ\n");

            System.out.print("3 :15件データ（前回タスク名20,21文字チェック、前回担当者名15,16文字チェック、奇数番目入力可）\n");
            System.out.print("4 :16件データ（前回タスク名20,21文字チェック、前回担当者名15,16文字チェック）\n");
            System.out.print("5 :14件データ（前回タスク名20,21文字チェック、前回担当者名15,16文字チェック）\n");
            System.out.print("6 :15件データ（前回タスク名20,21文字チェック、前回担当者名15,16文字チェック、偶数番目入力可）\n");
            System.out.print("7 :15件データ（前回タスク名20,21文字チェック、前回担当者名15,16文字チェック、全て入力不可）\n");

            System.out.print("10 :異常系 1000件超過 IWF2160\n");
            System.out.print("11 :異常系 異常発生\n");
            System.out.print("12 :3件データ新契約 申込番号　＝　991234550，991234568，991234576 保険種類　＝外貨建て一時払終身保険（即時保障型"
                + "外貨建て一時払終身保険（毎年受取型），外貨建て一時払変額年金保険（ブレンド型）\n");
            System.out.print("13 :1件データ新契約 申込番号　＝　991234550\n");
            System.out.print("14 :1件データ新契約 申込番号　＝　991234568\n");
            System.out.print("15 :1件データ新契約 申込番号　＝　991234576\n");
            System.out.print("16 :0件データ新契約 \n");

            System.out.print("d :defalt 100件\n");

            System.out.print("入力してください⇒");
            str = br.readLine();
        } catch (final IOException e) {
            e.printStackTrace();
        }
        System.out.println("入力値は：" + str);

        switch(str){
            case "12":
                for (int i = 0; i <= 2; i++) {
                    bean = new TaskSummaryForWorkListBean();
                    bean.setJimutetuzukiCd("1000000000000000015");
                    bean.setJimutetuzukiNm("事務手続名15");
                    bean.setKouteiKnrId("KouteiKnrId15");
                    bean.setSyoNo("12806345683");
                    bean.setNkSysyNo("12806345683");
                    BizDate tmpJmStartYmd = BizDate.getSysDate().addDays(i - 99);

                    GengouInfo gengouInfo = tmpJmStartYmd.getLatestGengouInfo();
                    bean.setJimuStartYmd(
                        String.format( "%s%02d/%02d/%02d %02d:%02d:%02d" ,
                            gengouInfo.getGengouSymbol(),
                            tmpJmStartYmd.getYearW(gengouInfo),
                            tmpJmStartYmd.getMonth(),
                            tmpJmStartYmd.getDay(),
                            0,0,0
                            ));
                    bean.setPreSyoriTantouId("PreSyoriTantouId_" + Integer.toString(i));
                    String preSyoriTantouNm = new String("前回担当者名" + ConvertUtil.toZenNumeric(Integer.toString(i)));
                    bean.setKeiyakusyaNm("契約者名１契約者名１契約者名１契約者名１");
                    bean.setDispPreSyoriTantouNm(preSyoriTantouNm.length() > 15 ? preSyoriTantouNm.substring(0, 15) : preSyoriTantouNm);
                    bean.setPreTaskNm("PreTaskNm_" + Integer.toString(i));
                    String preTaskNm = new String("前回タスク名＿２０文字＿１２３４５＿" + ConvertUtil.toZenNumeric(Integer.toString(i+1)));
                    bean.setDispPreTaskNm(preTaskNm.length() > 20 ? preTaskNm.substring(0,20) : preTaskNm);
                    bean.setNowSyoriTantouId("NowSyoriTantouId_" + Integer.toString(i));
                    bean.setDispNowSyoriTantouNm("現在担当者名" + Integer.toString(i));
                    bean.setNowTaskNm("NowTaskNm_" + Integer.toString(i));
                    bean.setDispNowTaskNm("現在タスク名" + ConvertUtil.toZenNumeric(Integer.toString(i)));
                    bean.setSyouhinCd("SyouhinCd_" + Integer.toString(i % 15));
                    if (i % 2 == 0) {
                        bean.setNyuuryokuKahi(true);
                    } else {
                        bean.setNyuuryokuKahi(false);
                    }

                    beanList.add(bean);
                }

                beanList.get(0).setMosNo("991234550");
                beanList.get(1).setMosNo("991234568");
                beanList.get(2).setMosNo("991234576");

                beanList.get(0).setHknsyuruino("外貨建て一時払終身保険（即時保障型）");
                beanList.get(1).setHknsyuruino("外貨建て一時払終身保険（毎年受取型）");
                beanList.get(2).setHknsyuruino("外貨建て一時払変額年金保険（ブレンド型）");

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

                resultBean.setSyousaiMessageCd("IWFXXXX");

                resultBean.setSyousaiMessage("処理終了");

                resultBean.setTaskSummaryForWorkListBeanList(beanList);

                break;

            case "13":
                for (int i = 0; i <= 0; i++) {
                    bean = new TaskSummaryForWorkListBean();
                    bean.setJimutetuzukiCd("1000000000000000012");
                    bean.setJimutetuzukiNm("事務手続名12");
                    bean.setKouteiKnrId("KouteiKnrId12");
                    bean.setSyoNo("12806345683");
                    bean.setNkSysyNo("12806345683");
                    bean.setMosNo("991234550");
                    bean.setHknsyuruino("外貨建て一時払終身保険（毎年受取型）");
                    BizDate tmpJmStartYmd = BizDate.getSysDate().addDays(i - 99);

                    GengouInfo gengouInfo = tmpJmStartYmd.getLatestGengouInfo();
                    bean.setJimuStartYmd(
                        String.format( "%s%02d/%02d/%02d %02d:%02d:%02d" ,
                            gengouInfo.getGengouSymbol(),
                            tmpJmStartYmd.getYearW(gengouInfo),
                            tmpJmStartYmd.getMonth(),
                            tmpJmStartYmd.getDay(),
                            0,0,0
                            ));
                    bean.setPreSyoriTantouId("PreSyoriTantouId_" + Integer.toString(i));
                    String preSyoriTantouNm = new String("前回担当者名" + ConvertUtil.toZenNumeric(Integer.toString(i)));
                    bean.setKeiyakusyaNm("契約者名１契約者名１契約者名１契約者名１");
                    bean.setDispPreSyoriTantouNm(preSyoriTantouNm.length() > 15 ? preSyoriTantouNm.substring(0, 15) : preSyoriTantouNm);
                    bean.setPreTaskNm("PreTaskNm_" + Integer.toString(i));
                    String preTaskNm = new String("前回タスク名＿２０文字＿１２３４５＿" + ConvertUtil.toZenNumeric(Integer.toString(i+1)));
                    bean.setDispPreTaskNm(preTaskNm.length() > 20 ? preTaskNm.substring(0,20) : preTaskNm);
                    bean.setNowSyoriTantouId("NowSyoriTantouId_" + Integer.toString(i));
                    bean.setDispNowSyoriTantouNm("現在担当者名" + Integer.toString(i));
                    bean.setNowTaskNm("NowTaskNm_" + Integer.toString(i));
                    bean.setDispNowTaskNm("現在タスク名" + ConvertUtil.toZenNumeric(Integer.toString(i)));
                    bean.setSyouhinCd("SyouhinCd_" + Integer.toString(i % 15));
                    if (i % 2 == 0) {
                        bean.setNyuuryokuKahi(true);
                    } else {
                        bean.setNyuuryokuKahi(false);
                    }

                    beanList.add(bean);
                }

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

                resultBean.setSyousaiMessageCd("IWFXXXX");

                resultBean.setSyousaiMessage("処理終了");

                resultBean.setTaskSummaryForWorkListBeanList(beanList);

                break;

            case "14":
                for (int i = 0; i <= 0; i++) {
                    bean = new TaskSummaryForWorkListBean();
                    bean.setJimutetuzukiCd("1000000000000000013");
                    bean.setJimutetuzukiNm("事務手続名13");
                    bean.setKouteiKnrId("KouteiKnrId13");
                    bean.setSyoNo("12806345683");
                    bean.setNkSysyNo("12806345683");
                    bean.setMosNo("991234568");
                    bean.setHknsyuruino("外貨建て一時払終身保険（即時保障型）");

                    BizDate tmpJmStartYmd = BizDate.getSysDate().addDays(i - 99);

                    GengouInfo gengouInfo = tmpJmStartYmd.getLatestGengouInfo();
                    bean.setJimuStartYmd(
                        String.format( "%s%02d/%02d/%02d %02d:%02d:%02d" ,
                            gengouInfo.getGengouSymbol(),
                            tmpJmStartYmd.getYearW(gengouInfo),
                            tmpJmStartYmd.getMonth(),
                            tmpJmStartYmd.getDay(),
                            0,0,0
                            ));
                    bean.setPreSyoriTantouId("PreSyoriTantouId_" + Integer.toString(i));
                    String preSyoriTantouNm = new String("前回担当者名" + ConvertUtil.toZenNumeric(Integer.toString(i)));
                    bean.setKeiyakusyaNm("契約者名１契約者名１契約者名１契約者名１");
                    bean.setDispPreSyoriTantouNm(preSyoriTantouNm.length() > 15 ? preSyoriTantouNm.substring(0, 15) : preSyoriTantouNm);
                    bean.setPreTaskNm("PreTaskNm_" + Integer.toString(i));
                    String preTaskNm = new String("前回タスク名＿２０文字＿１２３４５＿" + ConvertUtil.toZenNumeric(Integer.toString(i+1)));
                    bean.setDispPreTaskNm(preTaskNm.length() > 20 ? preTaskNm.substring(0,20) : preTaskNm);
                    bean.setNowSyoriTantouId("NowSyoriTantouId_" + Integer.toString(i));
                    bean.setDispNowSyoriTantouNm("現在担当者名" + Integer.toString(i));
                    bean.setNowTaskNm("NowTaskNm_" + Integer.toString(i));
                    bean.setDispNowTaskNm("現在タスク名" + ConvertUtil.toZenNumeric(Integer.toString(i)));
                    bean.setSyouhinCd("SyouhinCd_" + Integer.toString(i % 15));
                    if (i % 2 == 0) {
                        bean.setNyuuryokuKahi(true);
                    } else {
                        bean.setNyuuryokuKahi(false);
                    }

                    beanList.add(bean);
                }

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

                resultBean.setSyousaiMessageCd("IWFXXXX");

                resultBean.setSyousaiMessage("処理終了");

                resultBean.setTaskSummaryForWorkListBeanList(beanList);

                break;

            case "15":
                for (int i = 0; i <= 0; i++) {
                    bean = new TaskSummaryForWorkListBean();
                    bean.setJimutetuzukiCd("1000000000000000014");
                    bean.setJimutetuzukiNm("事務手続名14");
                    bean.setKouteiKnrId("KouteiKnrId14");
                    bean.setSyoNo("12806345683");
                    bean.setNkSysyNo("12806345683");
                    bean.setMosNo("991234576");
                    bean.setHknsyuruino("外貨建て一時払変額年金保険（ブレンド型）");
                    BizDate tmpJmStartYmd = BizDate.getSysDate().addDays(i - 99);

                    GengouInfo gengouInfo = tmpJmStartYmd.getLatestGengouInfo();
                    bean.setJimuStartYmd(
                        String.format( "%s%02d/%02d/%02d %02d:%02d:%02d" ,
                            gengouInfo.getGengouSymbol(),
                            tmpJmStartYmd.getYearW(gengouInfo),
                            tmpJmStartYmd.getMonth(),
                            tmpJmStartYmd.getDay(),
                            0,0,0
                            ));
                    bean.setPreSyoriTantouId("PreSyoriTantouId_" + Integer.toString(i));
                    String preSyoriTantouNm = new String("前回担当者名" + ConvertUtil.toZenNumeric(Integer.toString(i)));
                    bean.setKeiyakusyaNm("契約者名１契約者名１契約者名１契約者名１");
                    bean.setDispPreSyoriTantouNm(preSyoriTantouNm.length() > 15 ? preSyoriTantouNm.substring(0, 15) : preSyoriTantouNm);
                    bean.setPreTaskNm("PreTaskNm_" + Integer.toString(i));
                    String preTaskNm = new String("前回タスク名＿２０文字＿１２３４５＿" + ConvertUtil.toZenNumeric(Integer.toString(i+1)));
                    bean.setDispPreTaskNm(preTaskNm.length() > 20 ? preTaskNm.substring(0,20) : preTaskNm);
                    bean.setNowSyoriTantouId("NowSyoriTantouId_" + Integer.toString(i));
                    bean.setDispNowSyoriTantouNm("現在担当者名" + Integer.toString(i));
                    bean.setNowTaskNm("NowTaskNm_" + Integer.toString(i));
                    bean.setDispNowTaskNm("現在タスク名" + ConvertUtil.toZenNumeric(Integer.toString(i)));
                    bean.setSyouhinCd("SyouhinCd_" + Integer.toString(i % 15));
                    if (i % 2 == 0) {
                        bean.setNyuuryokuKahi(true);
                    } else {
                        bean.setNyuuryokuKahi(false);
                    }

                    beanList.add(bean);
                }

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

                resultBean.setSyousaiMessageCd("IWFXXXX");

                resultBean.setSyousaiMessage("処理終了");

                resultBean.setTaskSummaryForWorkListBeanList(beanList);

                break;

            case "16":

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

                resultBean.setSyousaiMessageCd("IWFXXXX");

                resultBean.setSyousaiMessage("処理終了");

                resultBean.setTaskSummaryForWorkListBeanList(beanList);

                break;
            case "0":
                for (int i = 0; i <= 99; i++) {
                    bean = new TaskSummaryForWorkListBean();
                    bean.setJimutetuzukiCd(String.format("00%02d", i % 25));
                    bean.setJimutetuzukiNm(String.format("事務手続名_%02d", i % 25));
                    bean.setKouteiKnrId("KouteiKnrId" + Integer.toString(i % 15));
                    bean.setSyoNo("SyousyoNo" + Integer.toString(i % 15));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i % 15));
                    BizDate tmpJmStartYmd = BizDate.getSysDate().addDays(i - 99);

                    GengouInfo gengouInfo = tmpJmStartYmd.getLatestGengouInfo();
                    bean.setJimuStartYmd(
                        String.format( "%s%02d/%02d/%02d %02d:%02d:%02d" ,
                            gengouInfo.getGengouSymbol(),
                            tmpJmStartYmd.getYearW(gengouInfo),
                            tmpJmStartYmd.getMonth(),
                            tmpJmStartYmd.getDay(),
                            0,0,0
                            ));
                    bean.setPreSyoriTantouId("PreSyoriTantouId_" + Integer.toString(i));
                    String preSyoriTantouNm = new String("前回担当者名" + ConvertUtil.toZenNumeric(Integer.toString(i)));
                    bean.setDispPreSyoriTantouNm(preSyoriTantouNm.length() > 15 ? preSyoriTantouNm.substring(0, 15) : preSyoriTantouNm);
                    bean.setPreTaskNm("PreTaskNm_" + Integer.toString(i));
                    String preTaskNm = new String("前回タスク名" + ConvertUtil.toZenNumeric(Integer.toString(i)));
                    bean.setDispPreTaskNm(preTaskNm.length() > 20 ? preTaskNm.substring(0,20) : preTaskNm);
                    bean.setNowSyoriTantouId("NowSyoriTantouId_" + Integer.toString(i));
                    bean.setDispNowSyoriTantouNm("現在担当者名" + Integer.toString(i));
                    bean.setNowTaskNm("NowTaskNm_" + Integer.toString(i));
                    bean.setDispNowTaskNm("現在タスク名" + ConvertUtil.toZenNumeric(Integer.toString(i)));
                    bean.setSyouhinCd("SyouhinCd_" + Integer.toString(i % 15));
                    if (i % 2 == 0) {
                        bean.setNyuuryokuKahi(true);
                    } else {
                        bean.setNyuuryokuKahi(false);
                    }

                    beanList.add(bean);
                }

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NODATA);

                resultBean.setSyousaiMessageCd("IWFXXXX");

                resultBean.setSyousaiMessage("処理終了");

                resultBean.setTaskSummaryForWorkListBeanList(beanList);

                break;

            case "1":

            case "2":
                for (int i = 0; i <= 999; i++) {
                    bean = new TaskSummaryForWorkListBean();
                    bean.setJimutetuzukiCd(String.format("00%02d", i % 25));
                    bean.setJimutetuzukiNm(String.format("事務手続名_%02d", i % 25));
                    bean.setKouteiKnrId("KouteiKnrId" + Integer.toString(i % 15));
                    bean.setSyoNo("SyousyoNo" + Integer.toString(i % 15));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i % 15));
                    BizDate tmpJmStartYmd = BizDate.getSysDate().addDays(i - 99);

                    GengouInfo gengouInfo = tmpJmStartYmd.getLatestGengouInfo();
                    bean.setJimuStartYmd(
                        String.format( "%s%02d/%02d/%02d %02d:%02d:%02d" ,
                            gengouInfo.getGengouSymbol(),
                            tmpJmStartYmd.getYearW(gengouInfo),
                            tmpJmStartYmd.getMonth(),
                            tmpJmStartYmd.getDay(),
                            0,0,0
                            ));
                    bean.setPreSyoriTantouId("PreSyoriTantouId_" + Integer.toString(i));
                    String preSyoriTantouNm = new String("前回担当者名" + ConvertUtil.toZenNumeric(Integer.toString(i)));
                    bean.setDispPreSyoriTantouNm(preSyoriTantouNm.length() > 15 ? preSyoriTantouNm.substring(0, 15) : preSyoriTantouNm);
                    bean.setPreTaskNm("PreTaskNm_" + Integer.toString(i));
                    String preTaskNm = new String("前回タスク名＿２０文字＿１２３４５＿" + ConvertUtil.toZenNumeric(Integer.toString(i+1)));
                    bean.setDispPreTaskNm(preTaskNm.length() > 20 ? preTaskNm.substring(0,20) : preTaskNm);
                    bean.setNowSyoriTantouId("NowSyoriTantouId_" + Integer.toString(i));
                    bean.setDispNowSyoriTantouNm("現在担当者名" + Integer.toString(i));
                    bean.setNowTaskNm("NowTaskNm_" + Integer.toString(i));
                    bean.setDispNowTaskNm("現在タスク名" + ConvertUtil.toZenNumeric(Integer.toString(i)));
                    bean.setSyouhinCd("SyouhinCd_" + Integer.toString(i % 15));
                    if (i % 2 == 0) {
                        bean.setNyuuryokuKahi(true);
                    } else {
                        bean.setNyuuryokuKahi(false);
                    }

                    beanList.add(bean);
                }

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

                resultBean.setSyousaiMessageCd("IWFXXXX");

                resultBean.setSyousaiMessage("処理終了");

                resultBean.setTaskSummaryForWorkListBeanList(beanList);

                break;

            case "3":
                for (int i = 0; i <= 14; i++) {
                    bean = new TaskSummaryForWorkListBean();
                    bean.setJimutetuzukiCd(String.format("00%02d", i % 25));
                    bean.setJimutetuzukiNm(String.format("事務手続名_%02d", i % 25));
                    bean.setKouteiKnrId("KouteiKnrId" + Integer.toString(i));
                    bean.setSyoNo("SyoNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    BizDate tmpJmStartYmd = BizDate.getSysDate().addDays(i - 99);

                    GengouInfo gengouInfo = tmpJmStartYmd.getLatestGengouInfo();
                    bean.setJimuStartYmd(
                        String.format( "%s%02d/%02d/%02d %02d:%02d:%02d" ,
                            gengouInfo.getGengouSymbol(),
                            tmpJmStartYmd.getYearW(gengouInfo),
                            tmpJmStartYmd.getMonth(),
                            tmpJmStartYmd.getDay(),
                            0,0,0
                            ));
                    bean.setPreSyoriTantouId("PreSyoriTantouId_" + Integer.toString(i));
                    String preSyoriTantouNm = new String("前回担当者名＿１５文字＿３４" + ConvertUtil.toZenNumeric(Integer.toString(i+1)));
                    bean.setDispPreSyoriTantouNm(preSyoriTantouNm.length() > 15 ? preSyoriTantouNm.substring(0, 15) : preSyoriTantouNm);
                    bean.setPreTaskNm("PreTaskNm_" + Integer.toString(i));
                    String preTaskNm = new String("前回タスク名＿２０文字＿１２３４５＿" + ConvertUtil.toZenNumeric(Integer.toString(i+1)));
                    bean.setDispPreTaskNm(preTaskNm.length() > 20 ? preTaskNm.substring(0,20) : preTaskNm);
                    bean.setNowSyoriTantouId("NowSyoriTantouId_" + Integer.toString(i));
                    bean.setDispNowSyoriTantouNm("現在担当者名" + Integer.toString(i));
                    bean.setNowTaskNm("NowTaskNm_" + Integer.toString(i));
                    bean.setDispNowTaskNm("現在タスク名" + ConvertUtil.toZenNumeric(Integer.toString(i)));
                    bean.setSyouhinCd("SyouhinCd_" + Integer.toString(i % 15));
                    if (i % 2 == 0) {
                        bean.setNyuuryokuKahi(true);
                    } else {
                        bean.setNyuuryokuKahi(false);
                    }

                    beanList.add(bean);
                }

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

                resultBean.setSyousaiMessageCd("IWFXXXX");

                resultBean.setSyousaiMessage("処理終了");

                resultBean.setTaskSummaryForWorkListBeanList(beanList);

                break;

            case "4":
                for (int i = 0; i <= 15; i++) {
                    bean = new TaskSummaryForWorkListBean();
                    bean.setJimutetuzukiCd(String.format("00%02d", i % 25));
                    bean.setJimutetuzukiNm(String.format("事務手続名_%02d", i % 25));
                    bean.setKouteiKnrId("KouteiKnrId" + Integer.toString(i));
                    bean.setSyoNo("SyoNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    BizDate tmpJmStartYmd = BizDate.getSysDate().addDays(i - 99);

                    GengouInfo gengouInfo = tmpJmStartYmd.getLatestGengouInfo();
                    bean.setJimuStartYmd(
                        String.format( "%s%02d/%02d/%02d %02d:%02d:%02d" ,
                            gengouInfo.getGengouSymbol(),
                            tmpJmStartYmd.getYearW(gengouInfo),
                            tmpJmStartYmd.getMonth(),
                            tmpJmStartYmd.getDay(),
                            0,0,0
                            ));
                    bean.setPreSyoriTantouId("PreSyoriTantouId_" + Integer.toString(i));
                    String preSyoriTantouNm = new String("前回担当者名＿１５文字＿３４" + ConvertUtil.toZenNumeric(Integer.toString(i+1)));
                    bean.setDispPreSyoriTantouNm(preSyoriTantouNm.length() > 15 ? preSyoriTantouNm.substring(0, 15) : preSyoriTantouNm);
                    bean.setPreTaskNm("PreTaskNm_" + Integer.toString(i));
                    String preTaskNm = new String("前回タスク名＿２０文字＿１２３４５＿" + ConvertUtil.toZenNumeric(Integer.toString(i+1)));
                    bean.setDispPreTaskNm(preTaskNm.length() > 20 ? preTaskNm.substring(0,20) : preTaskNm);
                    bean.setNowSyoriTantouId("NowSyoriTantouId_" + Integer.toString(i));
                    bean.setDispNowSyoriTantouNm("現在担当者名" + Integer.toString(i));
                    bean.setNowTaskNm("NowTaskNm_" + Integer.toString(i));
                    bean.setDispNowTaskNm("現在タスク名" + ConvertUtil.toZenNumeric(Integer.toString(i)));
                    bean.setSyouhinCd("SyouhinCd_" + Integer.toString(i % 15));
                    if (i % 2 == 0) {
                        bean.setNyuuryokuKahi(true);
                    } else {
                        bean.setNyuuryokuKahi(false);
                    }

                    beanList.add(bean);
                }

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

                resultBean.setSyousaiMessageCd("IWFXXXX");

                resultBean.setSyousaiMessage("処理終了");

                resultBean.setTaskSummaryForWorkListBeanList(beanList);

                break;

            case "5":
                for (int i = 0; i <= 13; i++) {
                    bean = new TaskSummaryForWorkListBean();
                    bean.setJimutetuzukiCd(String.format("00%02d", i % 25));
                    bean.setJimutetuzukiNm(String.format("事務手続名_%02d", i % 25));
                    bean.setKouteiKnrId("KouteiKnrId" + Integer.toString(i));
                    bean.setSyoNo("SyoNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    BizDate tmpJmStartYmd = BizDate.getSysDate().addDays(i - 99);

                    GengouInfo gengouInfo = tmpJmStartYmd.getLatestGengouInfo();
                    bean.setJimuStartYmd(
                        String.format( "%s%02d/%02d/%02d %02d:%02d:%02d" ,
                            gengouInfo.getGengouSymbol(),
                            tmpJmStartYmd.getYearW(gengouInfo),
                            tmpJmStartYmd.getMonth(),
                            tmpJmStartYmd.getDay(),
                            0,0,0
                            ));
                    bean.setPreSyoriTantouId("PreSyoriTantouId_" + Integer.toString(i));
                    String preSyoriTantouNm = new String("前回担当者名＿１５文字＿３４" + ConvertUtil.toZenNumeric(Integer.toString(i+1)));
                    bean.setDispPreSyoriTantouNm(preSyoriTantouNm.length() > 15 ? preSyoriTantouNm.substring(0, 15) : preSyoriTantouNm);
                    bean.setPreTaskNm("PreTaskNm_" + Integer.toString(i));
                    String preTaskNm = new String("前回タスク名＿２０文字＿１２３４５＿" + ConvertUtil.toZenNumeric(Integer.toString(i+1)));
                    bean.setDispPreTaskNm(preTaskNm.length() > 20 ? preTaskNm.substring(0,20) : preTaskNm);
                    bean.setNowSyoriTantouId("NowSyoriTantouId_" + Integer.toString(i));
                    bean.setDispNowSyoriTantouNm("現在担当者名" + Integer.toString(i));
                    bean.setNowTaskNm("NowTaskNm_" + Integer.toString(i));
                    bean.setDispNowTaskNm("現在タスク名" + ConvertUtil.toZenNumeric(Integer.toString(i)));
                    bean.setSyouhinCd("SyouhinCd_" + Integer.toString(i % 15));
                    if (i % 2 == 0) {
                        bean.setNyuuryokuKahi(true);
                    } else {
                        bean.setNyuuryokuKahi(false);
                    }

                    beanList.add(bean);
                }

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

                resultBean.setSyousaiMessageCd("IWFXXXX");

                resultBean.setSyousaiMessage("処理終了");

                resultBean.setTaskSummaryForWorkListBeanList(beanList);

                break;

            case "6":
                for (int i = 0; i <= 14; i++) {
                    bean = new TaskSummaryForWorkListBean();
                    bean.setJimutetuzukiCd(String.format("00%02d", i % 25));
                    bean.setJimutetuzukiNm(String.format("事務手続名_%02d", i % 25));
                    bean.setKouteiKnrId("KouteiKnrId" + Integer.toString(i));
                    bean.setSyoNo("SyoNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    BizDate tmpJmStartYmd = BizDate.getSysDate().addDays(i - 99);

                    GengouInfo gengouInfo = tmpJmStartYmd.getLatestGengouInfo();
                    bean.setJimuStartYmd(
                        String.format( "%s%02d/%02d/%02d %02d:%02d:%02d" ,
                            gengouInfo.getGengouSymbol(),
                            tmpJmStartYmd.getYearW(gengouInfo),
                            tmpJmStartYmd.getMonth(),
                            tmpJmStartYmd.getDay(),
                            0,0,0
                            ));
                    bean.setPreSyoriTantouId("PreSyoriTantouId_" + Integer.toString(i));
                    String preSyoriTantouNm = new String("前回担当者名＿１５文字＿３４" + ConvertUtil.toZenNumeric(Integer.toString(i+1)));
                    bean.setDispPreSyoriTantouNm(preSyoriTantouNm.length() > 15 ? preSyoriTantouNm.substring(0, 15) : preSyoriTantouNm);
                    bean.setPreTaskNm("PreTaskNm_" + Integer.toString(i));
                    String preTaskNm = new String("前回タスク名＿２０文字＿１２３４５＿" + ConvertUtil.toZenNumeric(Integer.toString(i+1)));
                    bean.setDispPreTaskNm(preTaskNm.length() > 20 ? preTaskNm.substring(0,20) : preTaskNm);
                    bean.setNowSyoriTantouId("NowSyoriTantouId_" + Integer.toString(i));
                    bean.setDispNowSyoriTantouNm("現在担当者名" + Integer.toString(i));
                    bean.setNowTaskNm("NowTaskNm_" + Integer.toString(i));
                    bean.setDispNowTaskNm("現在タスク名" + ConvertUtil.toZenNumeric(Integer.toString(i)));
                    bean.setSyouhinCd("SyouhinCd_" + Integer.toString(i % 15));
                    if (i % 2 != 0) {
                        bean.setNyuuryokuKahi(true);
                    } else {
                        bean.setNyuuryokuKahi(false);
                    }

                    beanList.add(bean);
                }

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

                resultBean.setSyousaiMessageCd("IWFXXXX");

                resultBean.setSyousaiMessage("処理終了");

                resultBean.setTaskSummaryForWorkListBeanList(beanList);

                break;

            case "7":
                for (int i = 0; i <= 14; i++) {
                    bean = new TaskSummaryForWorkListBean();
                    bean.setJimutetuzukiCd(String.format("00%02d", i % 25));
                    bean.setJimutetuzukiNm(String.format("事務手続名_%02d", i % 25));
                    bean.setKouteiKnrId("KouteiKnrId" + Integer.toString(i));
                    bean.setSyoNo("SyoNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    BizDate tmpJmStartYmd = BizDate.getSysDate().addDays(i - 99);

                    GengouInfo gengouInfo = tmpJmStartYmd.getLatestGengouInfo();
                    bean.setJimuStartYmd(
                        String.format( "%s%02d/%02d/%02d %02d:%02d:%02d" ,
                            gengouInfo.getGengouSymbol(),
                            tmpJmStartYmd.getYearW(gengouInfo),
                            tmpJmStartYmd.getMonth(),
                            tmpJmStartYmd.getDay(),
                            0,0,0
                            ));
                    bean.setPreSyoriTantouId("PreSyoriTantouId_" + Integer.toString(i));
                    String preSyoriTantouNm = new String("前回担当者名＿１５文字＿３４" + ConvertUtil.toZenNumeric(Integer.toString(i+1)));
                    bean.setDispPreSyoriTantouNm(preSyoriTantouNm.length() > 15 ? preSyoriTantouNm.substring(0, 15) : preSyoriTantouNm);
                    bean.setPreTaskNm("PreTaskNm_" + Integer.toString(i));
                    String preTaskNm = new String("前回タスク名＿２０文字＿１２３４５＿" + ConvertUtil.toZenNumeric(Integer.toString(i+1)));
                    bean.setDispPreTaskNm(preTaskNm.length() > 20 ? preTaskNm.substring(0,20) : preTaskNm);
                    bean.setNowSyoriTantouId("NowSyoriTantouId_" + Integer.toString(i));
                    bean.setDispNowSyoriTantouNm("現在担当者名" + Integer.toString(i));
                    bean.setNowTaskNm("NowTaskNm_" + Integer.toString(i));
                    bean.setDispNowTaskNm("現在タスク名" + ConvertUtil.toZenNumeric(Integer.toString(i)));
                    bean.setSyouhinCd("SyouhinCd_" + Integer.toString(i % 15));
                    bean.setNyuuryokuKahi(false);

                    beanList.add(bean);
                }

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

                resultBean.setSyousaiMessageCd("IWFXXXX");

                resultBean.setSyousaiMessage("処理終了");

                resultBean.setTaskSummaryForWorkListBeanList(beanList);

                break;

            case "10":
                for (int i = 0; i <= 1000; i++) {
                    bean = new TaskSummaryForWorkListBean();
                    bean.setJimutetuzukiCd(String.format("00%02d", i % 25));
                    bean.setJimutetuzukiNm(String.format("事務手続名_%02d", i % 25));
                    bean.setKouteiKnrId("KouteiKnrId" + Integer.toString(i % 15));
                    bean.setSyoNo("SyousyoNo" + Integer.toString(i % 15));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i % 15));
                    BizDate tmpJmStartYmd = BizDate.getSysDate().addDays(i - 99);

                    GengouInfo gengouInfo = tmpJmStartYmd.getLatestGengouInfo();
                    bean.setJimuStartYmd(
                        String.format( "%s%02d/%02d/%02d %02d:%02d:%02d" ,
                            gengouInfo.getGengouSymbol(),
                            tmpJmStartYmd.getYearW(gengouInfo),
                            tmpJmStartYmd.getMonth(),
                            tmpJmStartYmd.getDay(),
                            0,0,0
                            ));
                    bean.setPreSyoriTantouId("PreSyoriTantouId_" + Integer.toString(i));
                    String preSyoriTantouNm = new String("前回担当者名" + ConvertUtil.toZenNumeric(Integer.toString(i)));
                    bean.setDispPreSyoriTantouNm(preSyoriTantouNm.length() > 15 ? preSyoriTantouNm.substring(0, 15) : preSyoriTantouNm);
                    bean.setPreTaskNm("PreTaskNm_" + Integer.toString(i));
                    String preTaskNm = new String("前回タスク名＿２０文字＿１２３４５＿" + ConvertUtil.toZenNumeric(Integer.toString(i+1)));
                    bean.setDispPreTaskNm(preTaskNm.length() > 20 ? preTaskNm.substring(0,20) : preTaskNm);
                    bean.setNowSyoriTantouId("NowSyoriTantouId_" + Integer.toString(i));
                    bean.setDispNowSyoriTantouNm("現在担当者名" + Integer.toString(i));
                    bean.setNowTaskNm("NowTaskNm_" + Integer.toString(i));
                    bean.setDispNowTaskNm("現在タスク名" + ConvertUtil.toZenNumeric(Integer.toString(i)));
                    bean.setSyouhinCd("SyouhinCd_" + Integer.toString(i % 15));
                    if (i % 2 == 0) {
                        bean.setNyuuryokuKahi(true);
                    } else {
                        bean.setNyuuryokuKahi(false);
                    }

                    beanList.add(bean);
                }

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NG);

                resultBean.setSyousaiMessageCd("IWF2160");

                resultBean.setSyousaiMessage("処理終了");

                resultBean.setTaskSummaryForWorkListBeanList(beanList);

                break;

            case "11":
                beanList.add(bean);

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NG);

                resultBean.setSyousaiMessageCd("IWFXXXX");

                resultBean.setSyousaiMessage("処理終了");

                resultBean.setTaskSummaryForWorkListBeanList(beanList);

                break;

            default:
                for (int i = 0; i <= 99; i++) {
                    bean = new TaskSummaryForWorkListBean();
                    bean.setJimutetuzukiCd(String.format("00%02d", i % 25));
                    bean.setJimutetuzukiNm(String.format("事務手続名_%02d", i % 25));
                    bean.setKouteiKnrId("KouteiKnrId" + Integer.toString(i % 15));
                    bean.setSyoNo("SyousyoNo" + Integer.toString(i % 15));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i % 15));
                    BizDate tmpJmStartYmd = BizDate.getSysDate().addDays(i - 99);

                    GengouInfo gengouInfo = tmpJmStartYmd.getLatestGengouInfo();
                    bean.setJimuStartYmd(
                        String.format( "%s%02d/%02d/%02d %02d:%02d:%02d" ,
                            gengouInfo.getGengouSymbol(),
                            tmpJmStartYmd.getYearW(gengouInfo),
                            tmpJmStartYmd.getMonth(),
                            tmpJmStartYmd.getDay(),
                            0,0,0
                            ));
                    bean.setPreSyoriTantouId("PreSyoriTantouId_" + Integer.toString(i));
                    String preSyoriTantouNm = new String("前回担当者名" + ConvertUtil.toZenNumeric(Integer.toString(i+1)));
                    bean.setDispPreSyoriTantouNm(preSyoriTantouNm.length() > 15 ? preSyoriTantouNm.substring(0, 15) : preSyoriTantouNm);
                    bean.setPreTaskNm("PreTaskNm_" + Integer.toString(i));
                    String preTaskNm = new String("前回タスク名＿２０文字＿１２３４５＿" + ConvertUtil.toZenNumeric(Integer.toString(i+1)));
                    bean.setDispPreTaskNm(preTaskNm.length() > 20 ? preTaskNm.substring(0,20) : preTaskNm);
                    bean.setNowSyoriTantouId("NowSyoriTantouId_" + Integer.toString(i));
                    bean.setDispNowSyoriTantouNm("現在担当者名" + Integer.toString(i));
                    bean.setNowTaskNm("NowTaskNm_" + Integer.toString(i));
                    bean.setDispNowTaskNm("現在タスク名" + ConvertUtil.toZenNumeric(Integer.toString(i)));
                    bean.setSyouhinCd("SyouhinCd_" + Integer.toString(i % 15));
                    if (i % 2 == 0) {
                        bean.setNyuuryokuKahi(true);
                    } else {
                        bean.setNyuuryokuKahi(false);
                    }

                    beanList.add(bean);
                }

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

                resultBean.setSyousaiMessageCd("IWFXXXX");

                resultBean.setSyousaiMessage("処理終了");

                resultBean.setTaskSummaryForWorkListBeanList(beanList);

                break;
        }
        return resultBean;
    }


    public static GetTasksForWorkListResultBean getTasksForWorkList(
        String pSubsystemId,
        String pMosNo,
        String pSyoNo,
        String pNkSysyNo,
        String pJimutetuzukiCd,
        String pJimuKaisiYmdFrom,
        String pJimuKaisiYmdTo,
        String pJimuyouCd,
        String pJimuyouCdUmu,
        String pWariateUserId,
        String pIsWariate,
        String pTaskNm) {

        GetTasksForWorkListResultBean resultBean = new GetTasksForWorkListResultBean();
        List<TaskSummaryForWorkListBean> beanList = new ArrayList<TaskSummaryForWorkListBean>();
        TaskSummaryForWorkListBean bean = new TaskSummaryForWorkListBean();

        String str = "";
        try {
            final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("0 :0件データ\n");
            System.out.print("1 :100件データ（前回タスク名20,21文字チェック、前回担当者名7,8文字チェック）\n");
            System.out.print("2 :1000件データ\n");

            System.out.print("3 :15件データ（前回タスク名20,21文字チェック、前回担当者名15,16文字チェック、奇数番目入力可）\n");
            System.out.print("4 :16件データ（前回タスク名20,21文字チェック、前回担当者名15,16文字チェック）\n");
            System.out.print("5 :14件データ（前回タスク名20,21文字チェック、前回担当者名15,16文字チェック）\n");
            System.out.print("6 :15件データ（前回タスク名20,21文字チェック、前回担当者名15,16文字チェック、偶数番目入力可）\n");
            System.out.print("7 :15件データ（前回タスク名20,21文字チェック、前回担当者名15,16文字チェック、全て入力不可）\n");

            System.out.print("10 :異常系 1000件超過 IWF2160\n");
            System.out.print("11 :異常系 異常発生\n");
            System.out.print("20 :1件　保全、年金、保険金データ\n");
            System.out.print("21 :0件　保全、年金、保険金一覧表示するデータ＝null\n");
            System.out.print("22 :1件　住所変更に遷移する\n");

            System.out.print("d :defalt 100件\n");

            System.out.print("入力してください⇒");
            str = br.readLine();
        } catch (final IOException e) {
            e.printStackTrace();
        }
        System.out.println("入力値は：" + str);

        switch(str){

            case "22":
                for (int i = 0; i <= 0; i++) {
                    bean = new TaskSummaryForWorkListBean();
                    bean.setJimutetuzukiCd("khjyuusyohenkou");
                    bean.setJimutetuzukiNm("住所変更");
                    bean.setKouteiKnrId("KouteiKnrId15");
                    bean.setSyoNo("12806345683");
                    bean.setNkSysyNo("12806345683");
                    BizDate tmpJmStartYmd = BizDate.getSysDate().addDays(i - 99);

                    GengouInfo gengouInfo = tmpJmStartYmd.getLatestGengouInfo();
                    bean.setJimuStartYmd(
                        String.format( "%s%02d/%02d/%02d %02d:%02d:%02d" ,
                            gengouInfo.getGengouSymbol(),
                            tmpJmStartYmd.getYearW(gengouInfo),
                            tmpJmStartYmd.getMonth(),
                            tmpJmStartYmd.getDay(),
                            0,0,0
                            ));
                    bean.setPreSyoriTantouId("PreSyoriTantouId_" + Integer.toString(i));
                    String preSyoriTantouNm = new String("前回担当者名" + ConvertUtil.toZenNumeric(Integer.toString(i)));
                    bean.setKeiyakusyaNm("契約者名１契約者名１契約者名１契約者名１");
                    bean.setDispPreSyoriTantouNm(preSyoriTantouNm.length() > 15 ? preSyoriTantouNm.substring(0, 15) : preSyoriTantouNm);
                    bean.setPreTaskNm("PreTaskNm_" + Integer.toString(i));
                    String preTaskNm = new String("前回タスク名＿２０文字＿１２３４５＿" + ConvertUtil.toZenNumeric(Integer.toString(i+1)));
                    bean.setDispPreTaskNm(preTaskNm.length() > 20 ? preTaskNm.substring(0,20) : preTaskNm);
                    bean.setNowSyoriTantouId("NowSyoriTantouId_" + Integer.toString(i));
                    bean.setDispNowSyoriTantouNm("現在担当者名" + Integer.toString(i));
                    bean.setNowTaskNm("input");
                    bean.setDispNowTaskNm("現在タスク名" + ConvertUtil.toZenNumeric(Integer.toString(i)));
                    bean.setSyouhinCd("SyouhinCd_" + Integer.toString(i % 15));
                    if (i % 2 == 0) {
                        bean.setNyuuryokuKahi(true);
                    } else {
                        bean.setNyuuryokuKahi(false);
                    }

                    beanList.add(bean);
                }

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

                resultBean.setSyousaiMessageCd("IWFXXXX");

                resultBean.setSyousaiMessage("処理終了");

                resultBean.setTaskSummaryForWorkListBeanList(beanList);

                break;

            case "20":
                for (int i = 0; i <= 0; i++) {
                    bean = new TaskSummaryForWorkListBean();
                    bean.setJimutetuzukiCd("1000000000000000015");
                    bean.setJimutetuzukiNm("事務手続名15");
                    bean.setKouteiKnrId("KouteiKnrId15");
                    bean.setSyoNo("12806345683");
                    bean.setNkSysyNo("12806345683");
                    BizDate tmpJmStartYmd = BizDate.getSysDate().addDays(i - 99);

                    GengouInfo gengouInfo = tmpJmStartYmd.getLatestGengouInfo();
                    bean.setJimuStartYmd(
                        String.format( "%s%02d/%02d/%02d %02d:%02d:%02d" ,
                            gengouInfo.getGengouSymbol(),
                            tmpJmStartYmd.getYearW(gengouInfo),
                            tmpJmStartYmd.getMonth(),
                            tmpJmStartYmd.getDay(),
                            0,0,0
                            ));
                    bean.setPreSyoriTantouId("PreSyoriTantouId_" + Integer.toString(i));
                    String preSyoriTantouNm = new String("前回担当者名" + ConvertUtil.toZenNumeric(Integer.toString(i)));
                    bean.setKeiyakusyaNm("契約者名１契約者名１契約者名１契約者名１");
                    bean.setDispPreSyoriTantouNm(preSyoriTantouNm.length() > 15 ? preSyoriTantouNm.substring(0, 15) : preSyoriTantouNm);
                    bean.setPreTaskNm("PreTaskNm_" + Integer.toString(i));
                    String preTaskNm = new String("前回タスク名＿２０文字＿１２３４５＿" + ConvertUtil.toZenNumeric(Integer.toString(i+1)));
                    bean.setDispPreTaskNm(preTaskNm.length() > 20 ? preTaskNm.substring(0,20) : preTaskNm);
                    bean.setNowSyoriTantouId("NowSyoriTantouId_" + Integer.toString(i));
                    bean.setDispNowSyoriTantouNm("現在担当者名" + Integer.toString(i));
                    bean.setNowTaskNm("NowTaskNm_" + Integer.toString(i));
                    bean.setDispNowTaskNm("現在タスク名" + ConvertUtil.toZenNumeric(Integer.toString(i)));
                    bean.setSyouhinCd("SyouhinCd_" + Integer.toString(i % 15));
                    if (i % 2 == 0) {
                        bean.setNyuuryokuKahi(true);
                    } else {
                        bean.setNyuuryokuKahi(false);
                    }

                    beanList.add(bean);
                }

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

                resultBean.setSyousaiMessageCd("IWFXXXX");

                resultBean.setSyousaiMessage("処理終了");

                resultBean.setTaskSummaryForWorkListBeanList(beanList);

                break;

            case "21":

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

                resultBean.setSyousaiMessageCd("IWFXXXX");

                resultBean.setSyousaiMessage("処理終了");

                resultBean.setTaskSummaryForWorkListBeanList(beanList);

                break;

            case "0":
                for (int i = 0; i < 0; i++) {
                    bean = new TaskSummaryForWorkListBean();
                    bean.setJimutetuzukiCd(String.format("00%02d", i % 25));
                    bean.setJimutetuzukiNm(String.format("事務手続名_%02d", i % 25));
                    bean.setKouteiKnrId("KouteiKnrId" + Integer.toString(i % 15));
                    bean.setSyoNo("SyousyoNo" + Integer.toString(i % 15));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i % 15));
                    BizDate tmpJmStartYmd = BizDate.getSysDate().addDays(i - 99);

                    GengouInfo gengouInfo = tmpJmStartYmd.getLatestGengouInfo();
                    bean.setJimuStartYmd(
                        String.format( "%s%02d/%02d/%02d %02d:%02d:%02d" ,
                            gengouInfo.getGengouSymbol(),
                            tmpJmStartYmd.getYearW(gengouInfo),
                            tmpJmStartYmd.getMonth(),
                            tmpJmStartYmd.getDay(),
                            0,0,0
                            ));
                    bean.setPreSyoriTantouId("PreSyoriTantouId_" + Integer.toString(i));
                    String preSyoriTantouNm = new String("前回担当者名" + ConvertUtil.toZenNumeric(Integer.toString(i)));
                    bean.setDispPreSyoriTantouNm(preSyoriTantouNm.length() > 15 ? preSyoriTantouNm.substring(0, 15) : preSyoriTantouNm);
                    bean.setPreTaskNm("PreTaskNm_" + Integer.toString(i));
                    String preTaskNm = new String("前回タスク名" + ConvertUtil.toZenNumeric(Integer.toString(i)));
                    bean.setDispPreTaskNm(preTaskNm.length() > 20 ? preTaskNm.substring(0,20) : preTaskNm);
                    bean.setNowSyoriTantouId("NowSyoriTantouId_" + Integer.toString(i));
                    bean.setDispNowSyoriTantouNm("現在担当者名" + Integer.toString(i));
                    bean.setNowTaskNm("NowTaskNm_" + Integer.toString(i));
                    bean.setDispNowTaskNm("現在タスク名" + ConvertUtil.toZenNumeric(Integer.toString(i)));
                    bean.setSyouhinCd("SyouhinCd_" + Integer.toString(i % 15));
                    if (i % 2 == 0) {
                        bean.setNyuuryokuKahi(true);
                    } else {
                        bean.setNyuuryokuKahi(false);
                    }

                    beanList.add(bean);
                }

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NODATA);

                resultBean.setSyousaiMessageCd("IWFXXXX");

                resultBean.setSyousaiMessage("処理終了");

                resultBean.setTaskSummaryForWorkListBeanList(beanList);

                break;

            case "1":

            case "2":
                for (int i = 0; i <= 999; i++) {
                    bean = new TaskSummaryForWorkListBean();
                    bean.setJimutetuzukiCd(String.format("00%02d", i % 25));
                    bean.setJimutetuzukiNm(String.format("事務手続名_%02d", i % 25));
                    bean.setKouteiKnrId("KouteiKnrId" + Integer.toString(i % 15));
                    bean.setSyoNo("SyousyoNo" + Integer.toString(i % 15));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i % 15));
                    BizDate tmpJmStartYmd = BizDate.getSysDate().addDays(i - 99);

                    GengouInfo gengouInfo = tmpJmStartYmd.getLatestGengouInfo();
                    bean.setJimuStartYmd(
                        String.format( "%s%02d/%02d/%02d %02d:%02d:%02d" ,
                            gengouInfo.getGengouSymbol(),
                            tmpJmStartYmd.getYearW(gengouInfo),
                            tmpJmStartYmd.getMonth(),
                            tmpJmStartYmd.getDay(),
                            0,0,0
                            ));
                    bean.setPreSyoriTantouId("PreSyoriTantouId_" + Integer.toString(i));
                    String preSyoriTantouNm = new String("前回担当者名" + ConvertUtil.toZenNumeric(Integer.toString(i)));
                    bean.setDispPreSyoriTantouNm(preSyoriTantouNm.length() > 15 ? preSyoriTantouNm.substring(0, 15) : preSyoriTantouNm);
                    bean.setPreTaskNm("PreTaskNm_" + Integer.toString(i));
                    String preTaskNm = new String("前回タスク名＿２０文字＿１２３４５＿" + ConvertUtil.toZenNumeric(Integer.toString(i+1)));
                    bean.setDispPreTaskNm(preTaskNm.length() > 20 ? preTaskNm.substring(0,20) : preTaskNm);
                    bean.setNowSyoriTantouId("NowSyoriTantouId_" + Integer.toString(i));
                    bean.setDispNowSyoriTantouNm("現在担当者名" + Integer.toString(i));
                    bean.setNowTaskNm("NowTaskNm_" + Integer.toString(i));
                    bean.setDispNowTaskNm("現在タスク名" + ConvertUtil.toZenNumeric(Integer.toString(i)));
                    bean.setSyouhinCd("SyouhinCd_" + Integer.toString(i % 15));
                    if (i % 2 == 0) {
                        bean.setNyuuryokuKahi(true);
                    } else {
                        bean.setNyuuryokuKahi(false);
                    }

                    beanList.add(bean);
                }

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

                resultBean.setSyousaiMessageCd("IWFXXXX");

                resultBean.setSyousaiMessage("処理終了");

                resultBean.setTaskSummaryForWorkListBeanList(beanList);

                break;

            case "3":
                for (int i = 0; i <= 14; i++) {
                    bean = new TaskSummaryForWorkListBean();
                    bean.setJimutetuzukiCd(String.format("00%02d", i % 25));
                    bean.setJimutetuzukiNm(String.format("事務手続名_%02d", i % 25));
                    bean.setKouteiKnrId("KouteiKnrId" + Integer.toString(i));
                    bean.setSyoNo("SyoNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    BizDate tmpJmStartYmd = BizDate.getSysDate().addDays(i - 99);

                    GengouInfo gengouInfo = tmpJmStartYmd.getLatestGengouInfo();
                    bean.setJimuStartYmd(
                        String.format( "%s%02d/%02d/%02d %02d:%02d:%02d" ,
                            gengouInfo.getGengouSymbol(),
                            tmpJmStartYmd.getYearW(gengouInfo),
                            tmpJmStartYmd.getMonth(),
                            tmpJmStartYmd.getDay(),
                            0,0,0
                            ));
                    bean.setPreSyoriTantouId("PreSyoriTantouId_" + Integer.toString(i));
                    String preSyoriTantouNm = new String("前回担当者名＿１５文字＿３４" + ConvertUtil.toZenNumeric(Integer.toString(i+1)));
                    bean.setDispPreSyoriTantouNm(preSyoriTantouNm.length() > 15 ? preSyoriTantouNm.substring(0, 15) : preSyoriTantouNm);
                    bean.setPreTaskNm("PreTaskNm_" + Integer.toString(i));
                    String preTaskNm = new String("前回タスク名＿２０文字＿１２３４５＿" + ConvertUtil.toZenNumeric(Integer.toString(i+1)));
                    bean.setDispPreTaskNm(preTaskNm.length() > 20 ? preTaskNm.substring(0,20) : preTaskNm);
                    bean.setNowSyoriTantouId("NowSyoriTantouId_" + Integer.toString(i));
                    bean.setDispNowSyoriTantouNm("現在担当者名" + Integer.toString(i));
                    bean.setNowTaskNm("NowTaskNm_" + Integer.toString(i));
                    bean.setDispNowTaskNm("現在タスク名" + ConvertUtil.toZenNumeric(Integer.toString(i)));
                    bean.setSyouhinCd("SyouhinCd_" + Integer.toString(i % 15));
                    if (i % 2 == 0) {
                        bean.setNyuuryokuKahi(true);
                    } else {
                        bean.setNyuuryokuKahi(false);
                    }

                    beanList.add(bean);
                }

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

                resultBean.setSyousaiMessageCd("IWFXXXX");

                resultBean.setSyousaiMessage("処理終了");

                resultBean.setTaskSummaryForWorkListBeanList(beanList);

                break;

            case "4":
                for (int i = 0; i <= 15; i++) {
                    bean = new TaskSummaryForWorkListBean();
                    bean.setJimutetuzukiCd(String.format("00%02d", i % 25));
                    bean.setJimutetuzukiNm(String.format("事務手続名_%02d", i % 25));
                    bean.setKouteiKnrId("KouteiKnrId" + Integer.toString(i));
                    bean.setSyoNo("SyoNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    BizDate tmpJmStartYmd = BizDate.getSysDate().addDays(i - 99);

                    GengouInfo gengouInfo = tmpJmStartYmd.getLatestGengouInfo();
                    bean.setJimuStartYmd(
                        String.format( "%s%02d/%02d/%02d %02d:%02d:%02d" ,
                            gengouInfo.getGengouSymbol(),
                            tmpJmStartYmd.getYearW(gengouInfo),
                            tmpJmStartYmd.getMonth(),
                            tmpJmStartYmd.getDay(),
                            0,0,0
                            ));
                    bean.setPreSyoriTantouId("PreSyoriTantouId_" + Integer.toString(i));
                    String preSyoriTantouNm = new String("前回担当者名＿１５文字＿３４" + ConvertUtil.toZenNumeric(Integer.toString(i+1)));
                    bean.setDispPreSyoriTantouNm(preSyoriTantouNm.length() > 15 ? preSyoriTantouNm.substring(0, 15) : preSyoriTantouNm);
                    bean.setPreTaskNm("PreTaskNm_" + Integer.toString(i));
                    String preTaskNm = new String("前回タスク名＿２０文字＿１２３４５＿" + ConvertUtil.toZenNumeric(Integer.toString(i+1)));
                    bean.setDispPreTaskNm(preTaskNm.length() > 20 ? preTaskNm.substring(0,20) : preTaskNm);
                    bean.setNowSyoriTantouId("NowSyoriTantouId_" + Integer.toString(i));
                    bean.setDispNowSyoriTantouNm("現在担当者名" + Integer.toString(i));
                    bean.setNowTaskNm("NowTaskNm_" + Integer.toString(i));
                    bean.setDispNowTaskNm("現在タスク名" + ConvertUtil.toZenNumeric(Integer.toString(i)));
                    bean.setSyouhinCd("SyouhinCd_" + Integer.toString(i % 15));
                    if (i % 2 == 0) {
                        bean.setNyuuryokuKahi(true);
                    } else {
                        bean.setNyuuryokuKahi(false);
                    }

                    beanList.add(bean);
                }

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

                resultBean.setSyousaiMessageCd("IWFXXXX");

                resultBean.setSyousaiMessage("処理終了");

                resultBean.setTaskSummaryForWorkListBeanList(beanList);

                break;

            case "5":
                for (int i = 0; i <= 13; i++) {
                    bean = new TaskSummaryForWorkListBean();
                    bean.setJimutetuzukiCd(String.format("00%02d", i % 25));
                    bean.setJimutetuzukiNm(String.format("事務手続名_%02d", i % 25));
                    bean.setKouteiKnrId("KouteiKnrId" + Integer.toString(i));
                    bean.setSyoNo("SyoNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    BizDate tmpJmStartYmd = BizDate.getSysDate().addDays(i - 99);

                    GengouInfo gengouInfo = tmpJmStartYmd.getLatestGengouInfo();
                    bean.setJimuStartYmd(
                        String.format( "%s%02d/%02d/%02d %02d:%02d:%02d" ,
                            gengouInfo.getGengouSymbol(),
                            tmpJmStartYmd.getYearW(gengouInfo),
                            tmpJmStartYmd.getMonth(),
                            tmpJmStartYmd.getDay(),
                            0,0,0
                            ));
                    bean.setPreSyoriTantouId("PreSyoriTantouId_" + Integer.toString(i));
                    String preSyoriTantouNm = new String("前回担当者名＿１５文字＿３４" + ConvertUtil.toZenNumeric(Integer.toString(i+1)));
                    bean.setDispPreSyoriTantouNm(preSyoriTantouNm.length() > 15 ? preSyoriTantouNm.substring(0, 15) : preSyoriTantouNm);
                    bean.setPreTaskNm("PreTaskNm_" + Integer.toString(i));
                    String preTaskNm = new String("前回タスク名＿２０文字＿１２３４５＿" + ConvertUtil.toZenNumeric(Integer.toString(i+1)));
                    bean.setDispPreTaskNm(preTaskNm.length() > 20 ? preTaskNm.substring(0,20) : preTaskNm);
                    bean.setNowSyoriTantouId("NowSyoriTantouId_" + Integer.toString(i));
                    bean.setDispNowSyoriTantouNm("現在担当者名" + Integer.toString(i));
                    bean.setNowTaskNm("NowTaskNm_" + Integer.toString(i));
                    bean.setDispNowTaskNm("現在タスク名" + ConvertUtil.toZenNumeric(Integer.toString(i)));
                    bean.setSyouhinCd("SyouhinCd_" + Integer.toString(i % 15));
                    if (i % 2 == 0) {
                        bean.setNyuuryokuKahi(true);
                    } else {
                        bean.setNyuuryokuKahi(false);
                    }

                    beanList.add(bean);
                }

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

                resultBean.setSyousaiMessageCd("IWFXXXX");

                resultBean.setSyousaiMessage("処理終了");

                resultBean.setTaskSummaryForWorkListBeanList(beanList);

                break;

            case "6":
                for (int i = 0; i <= 14; i++) {
                    bean = new TaskSummaryForWorkListBean();
                    bean.setJimutetuzukiCd(String.format("00%02d", i % 25));
                    bean.setJimutetuzukiNm(String.format("事務手続名_%02d", i % 25));
                    bean.setKouteiKnrId("KouteiKnrId" + Integer.toString(i));
                    bean.setSyoNo("SyoNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    BizDate tmpJmStartYmd = BizDate.getSysDate().addDays(i - 99);

                    GengouInfo gengouInfo = tmpJmStartYmd.getLatestGengouInfo();
                    bean.setJimuStartYmd(
                        String.format( "%s%02d/%02d/%02d %02d:%02d:%02d" ,
                            gengouInfo.getGengouSymbol(),
                            tmpJmStartYmd.getYearW(gengouInfo),
                            tmpJmStartYmd.getMonth(),
                            tmpJmStartYmd.getDay(),
                            0,0,0
                            ));
                    bean.setPreSyoriTantouId("PreSyoriTantouId_" + Integer.toString(i));
                    String preSyoriTantouNm = new String("前回担当者名＿１５文字＿３４" + ConvertUtil.toZenNumeric(Integer.toString(i+1)));
                    bean.setDispPreSyoriTantouNm(preSyoriTantouNm.length() > 15 ? preSyoriTantouNm.substring(0, 15) : preSyoriTantouNm);
                    bean.setPreTaskNm("PreTaskNm_" + Integer.toString(i));
                    String preTaskNm = new String("前回タスク名＿２０文字＿１２３４５＿" + ConvertUtil.toZenNumeric(Integer.toString(i+1)));
                    bean.setDispPreTaskNm(preTaskNm.length() > 20 ? preTaskNm.substring(0,20) : preTaskNm);
                    bean.setNowSyoriTantouId("NowSyoriTantouId_" + Integer.toString(i));
                    bean.setDispNowSyoriTantouNm("現在担当者名" + Integer.toString(i));
                    bean.setNowTaskNm("NowTaskNm_" + Integer.toString(i));
                    bean.setDispNowTaskNm("現在タスク名" + ConvertUtil.toZenNumeric(Integer.toString(i)));
                    bean.setSyouhinCd("SyouhinCd_" + Integer.toString(i % 15));
                    if (i % 2 != 0) {
                        bean.setNyuuryokuKahi(true);
                    } else {
                        bean.setNyuuryokuKahi(false);
                    }

                    beanList.add(bean);
                }

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

                resultBean.setSyousaiMessageCd("IWFXXXX");

                resultBean.setSyousaiMessage("処理終了");

                resultBean.setTaskSummaryForWorkListBeanList(beanList);

                break;

            case "7":
                for (int i = 0; i <= 14; i++) {
                    bean = new TaskSummaryForWorkListBean();
                    bean.setJimutetuzukiCd(String.format("00%02d", i % 25));
                    bean.setJimutetuzukiNm(String.format("事務手続名_%02d", i % 25));
                    bean.setKouteiKnrId("KouteiKnrId" + Integer.toString(i));
                    bean.setSyoNo("SyoNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    BizDate tmpJmStartYmd = BizDate.getSysDate().addDays(i - 99);

                    GengouInfo gengouInfo = tmpJmStartYmd.getLatestGengouInfo();
                    bean.setJimuStartYmd(
                        String.format( "%s%02d/%02d/%02d %02d:%02d:%02d" ,
                            gengouInfo.getGengouSymbol(),
                            tmpJmStartYmd.getYearW(gengouInfo),
                            tmpJmStartYmd.getMonth(),
                            tmpJmStartYmd.getDay(),
                            0,0,0
                            ));
                    bean.setPreSyoriTantouId("PreSyoriTantouId_" + Integer.toString(i));
                    String preSyoriTantouNm = new String("前回担当者名＿１５文字＿３４" + ConvertUtil.toZenNumeric(Integer.toString(i+1)));
                    bean.setDispPreSyoriTantouNm(preSyoriTantouNm.length() > 15 ? preSyoriTantouNm.substring(0, 15) : preSyoriTantouNm);
                    bean.setPreTaskNm("PreTaskNm_" + Integer.toString(i));
                    String preTaskNm = new String("前回タスク名＿２０文字＿１２３４５＿" + ConvertUtil.toZenNumeric(Integer.toString(i+1)));
                    bean.setDispPreTaskNm(preTaskNm.length() > 20 ? preTaskNm.substring(0,20) : preTaskNm);
                    bean.setNowSyoriTantouId("NowSyoriTantouId_" + Integer.toString(i));
                    bean.setDispNowSyoriTantouNm("現在担当者名" + Integer.toString(i));
                    bean.setNowTaskNm("NowTaskNm_" + Integer.toString(i));
                    bean.setDispNowTaskNm("現在タスク名" + ConvertUtil.toZenNumeric(Integer.toString(i)));
                    bean.setSyouhinCd("SyouhinCd_" + Integer.toString(i % 15));
                    bean.setNyuuryokuKahi(false);

                    beanList.add(bean);
                }

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

                resultBean.setSyousaiMessageCd("IWFXXXX");

                resultBean.setSyousaiMessage("処理終了");

                resultBean.setTaskSummaryForWorkListBeanList(beanList);

                break;

            case "10":
                for (int i = 0; i <= 1000; i++) {
                    bean = new TaskSummaryForWorkListBean();
                    bean.setJimutetuzukiCd(String.format("00%02d", i % 25));
                    bean.setJimutetuzukiNm(String.format("事務手続名_%02d", i % 25));
                    bean.setKouteiKnrId("KouteiKnrId" + Integer.toString(i % 15));
                    bean.setSyoNo("SyousyoNo" + Integer.toString(i % 15));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i % 15));
                    BizDate tmpJmStartYmd = BizDate.getSysDate().addDays(i - 99);

                    GengouInfo gengouInfo = tmpJmStartYmd.getLatestGengouInfo();
                    bean.setJimuStartYmd(
                        String.format( "%s%02d/%02d/%02d %02d:%02d:%02d" ,
                            gengouInfo.getGengouSymbol(),
                            tmpJmStartYmd.getYearW(gengouInfo),
                            tmpJmStartYmd.getMonth(),
                            tmpJmStartYmd.getDay(),
                            0,0,0
                            ));
                    bean.setPreSyoriTantouId("PreSyoriTantouId_" + Integer.toString(i));
                    String preSyoriTantouNm = new String("前回担当者名" + ConvertUtil.toZenNumeric(Integer.toString(i)));
                    bean.setDispPreSyoriTantouNm(preSyoriTantouNm.length() > 15 ? preSyoriTantouNm.substring(0, 15) : preSyoriTantouNm);
                    bean.setPreTaskNm("PreTaskNm_" + Integer.toString(i));
                    String preTaskNm = new String("前回タスク名" + ConvertUtil.toZenNumeric(Integer.toString(i)));
                    bean.setDispPreTaskNm(preTaskNm.length() > 20 ? preTaskNm.substring(0,20) : preTaskNm);
                    bean.setNowSyoriTantouId("NowSyoriTantouId_" + Integer.toString(i));
                    bean.setDispNowSyoriTantouNm("現在担当者名" + Integer.toString(i));
                    bean.setNowTaskNm("NowTaskNm_" + Integer.toString(i));
                    bean.setDispNowTaskNm("現在タスク名" + ConvertUtil.toZenNumeric(Integer.toString(i)));
                    bean.setSyouhinCd("SyouhinCd_" + Integer.toString(i % 15));
                    if (i % 2 == 0) {
                        bean.setNyuuryokuKahi(true);
                    } else {
                        bean.setNyuuryokuKahi(false);
                    }

                    beanList.add(bean);
                }

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NG);

                resultBean.setSyousaiMessageCd("IWF2160");

                resultBean.setSyousaiMessage("処理終了");

                resultBean.setTaskSummaryForWorkListBeanList(beanList);

                break;

            case "11":
                beanList.add(bean);

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NG);

                resultBean.setSyousaiMessageCd("IWFXXXX");

                resultBean.setSyousaiMessage("処理終了");

                resultBean.setTaskSummaryForWorkListBeanList(beanList);

                break;
            default:
                for (int i = 0; i <= 99; i++) {
                    bean = new TaskSummaryForWorkListBean();
                    bean.setJimutetuzukiCd(String.format("00%02d", i % 25));
                    bean.setJimutetuzukiNm(String.format("事務手続名_%02d", i % 25));
                    bean.setKouteiKnrId("KouteiKnrId" + Integer.toString(i % 15));
                    bean.setSyoNo("SyousyoNo" + Integer.toString(i % 15));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i % 15));
                    BizDate tmpJmStartYmd = BizDate.getSysDate().addDays(i - 99);

                    GengouInfo gengouInfo = tmpJmStartYmd.getLatestGengouInfo();
                    bean.setJimuStartYmd(
                        String.format( "%s%02d/%02d/%02d %02d:%02d:%02d" ,
                            gengouInfo.getGengouSymbol(),
                            tmpJmStartYmd.getYearW(gengouInfo),
                            tmpJmStartYmd.getMonth(),
                            tmpJmStartYmd.getDay(),
                            0,0,0
                            ));
                    bean.setPreSyoriTantouId("PreSyoriTantouId_" + Integer.toString(i));
                    String preSyoriTantouNm = new String("前回担当者名＿" + ConvertUtil.toZenNumeric(Integer.toString(i+1)));
                    bean.setDispPreSyoriTantouNm(preSyoriTantouNm.length() > 15 ? preSyoriTantouNm.substring(0, 15) : preSyoriTantouNm);
                    bean.setPreTaskNm("PreTaskNm_" + Integer.toString(i));
                    String preTaskNm = new String("前回タスク名＿２０文字＿１２３４５＿" + ConvertUtil.toZenNumeric(Integer.toString(i+1)));
                    bean.setDispPreTaskNm(preTaskNm.length() > 20 ? preTaskNm.substring(0,20) : preTaskNm);
                    bean.setNowSyoriTantouId("NowSyoriTantouId_" + Integer.toString(i));
                    bean.setDispNowSyoriTantouNm("現在担当者名" + Integer.toString(i));
                    bean.setNowTaskNm("NowTaskNm_" + Integer.toString(i));
                    bean.setDispNowTaskNm("現在タスク名" + ConvertUtil.toZenNumeric(Integer.toString(i)));
                    bean.setSyouhinCd("SyouhinCd_" + Integer.toString(i % 15));
                    if (i % 2 == 0) {
                        bean.setNyuuryokuKahi(true);
                    } else {
                        bean.setNyuuryokuKahi(false);
                    }

                    beanList.add(bean);
                }

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

                resultBean.setSyousaiMessageCd("IWFXXXX");

                resultBean.setSyousaiMessage("処理終了");

                resultBean.setTaskSummaryForWorkListBeanList(beanList);
                break;

        }
        return resultBean;
    }


    public static GetTasksForJimuyouCdResultBean getTasksForJimuyouCd(
        String[] pSyoNo,
        String[] pMosNo,
        String[] pNkSysyNo,
        String[] pJimutetuzukiCd) {

        GetTasksForJimuyouCdResultBean resultBean = new GetTasksForJimuyouCdResultBean();
        List<TaskSummaryForJimuyouCdBean> beanList = new ArrayList<TaskSummaryForJimuyouCdBean>();
        TaskSummaryForJimuyouCdBean bean;

        String str = "";

        try {
            final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("4:異常系 IWF0001（異常終了しました）\n");
            System.out.print("0:0件データ \n");
            System.out.print("1:工程状況 完了 \n");
            System.out.print("2:工程状況 取消 \n");
            System.out.print("3:事務用コード 登録なし\n");

            System.out.print("8,11,14:890123458,001 \n");
            System.out.print("9,12,15:12806345672,002\n");
            System.out.print("10,13,16:12806345672,003\n");

            System.out.print("-------------------\n");
            System.out.print("default:1件データ\n");
            System.out.print("★★★入力してください⇒");
            str = br.readLine();
        } catch (final IOException e) {
            e.printStackTrace();
        }
        System.out.println("入力値は：" + str);


        switch(str) {
            case "4":
                System.out.print("CASE1 異常\n");
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NG);
                resultBean.setSyousaiMessageCd("IWF0001");
                resultBean.setSyousaiMessage("異常終了");
                break;

            case "0":
                System.out.print("CASE2 0件\n");
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NODATA);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;

            case "1":
                System.out.print("CASE1 完了\n");
                bean = new TaskSummaryForJimuyouCdBean();
                bean.setSyoNo("SyoNo_" + Integer.toString(0));
                bean.setNkSysyNo("NkSysyNo_" + Integer.toString(0));
                bean.setKouteiKnrId("KouteiKnrId" + Integer.toString(0));
                bean.setKouteiStatus("90");
                bean.setDispKouteiStatus("完了");
                bean.setJimuyouCd("JimuyouCd_" + Integer.toString(0));
                beanList.add(bean);

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;

            case "2":
                System.out.print("CASE1 取消\n");
                bean = new TaskSummaryForJimuyouCdBean();
                bean.setSyoNo("SyoNo_" + Integer.toString(0));
                bean.setNkSysyNo("NkSysyNo_" + Integer.toString(0));
                bean.setKouteiKnrId("KouteiKnrId" + Integer.toString(0));
                bean.setKouteiStatus("99");
                bean.setDispKouteiStatus("取消");
                bean.setJimuyouCd("JimuyouCd_" + Integer.toString(0));
                beanList.add(bean);

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;


            case "3":
                System.out.print("CASE3 事務用コード登録無し\n");
                bean = new TaskSummaryForJimuyouCdBean();
                bean.setSyoNo("SyoNo_" + Integer.toString(0));
                bean.setNkSysyNo("NkSysyNo_" + Integer.toString(0));
                bean.setKouteiKnrId("KouteiKnrId" + Integer.toString(0));
                bean.setKouteiStatus("10");
                bean.setDispKouteiStatus("処理中");
                beanList.add(bean);

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;

            case "8":
            case "11":
            case "14":
                bean = new TaskSummaryForJimuyouCdBean();
                bean.setMosNo("890123458");
                bean.setKouteiKnrId("KouteiKnrId" + Integer.toString(0));
                bean.setKouteiStatus("10");
                bean.setDispKouteiStatus("処理中");
                bean.setJimuyouCd("001");
                beanList.add(bean);

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;
            case "9":
            case "12":
            case "15":
                bean = new TaskSummaryForJimuyouCdBean();
                bean.setMosNo("12806345672");
                bean.setKouteiKnrId("KouteiKnrId" + Integer.toString(0));
                bean.setKouteiStatus("10");
                bean.setDispKouteiStatus("処理中");
                bean.setJimuyouCd("002");
                beanList.add(bean);

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;
            case "10":
            case "13":
            case "16":
                bean = new TaskSummaryForJimuyouCdBean();
                bean.setMosNo("12806345672");
                bean.setKouteiKnrId("KouteiKnrId" + Integer.toString(0));
                bean.setKouteiStatus("10");
                bean.setDispKouteiStatus("処理中");
                bean.setJimuyouCd("003");
                beanList.add(bean);

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;

            default:
                bean = new TaskSummaryForJimuyouCdBean();
                bean.setSyoNo("SyoNo_" + Integer.toString(0));
                bean.setNkSysyNo("NkSysyNo_" + Integer.toString(0));
                bean.setKouteiKnrId("KouteiKnrId" + Integer.toString(0));
                bean.setKouteiStatus("10");
                bean.setDispKouteiStatus("処理中");
                bean.setJimuyouCd("JimuyouCd_" + Integer.toString(0));
                beanList.add(bean);

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;

        }

        resultBean.setTaskSummaryForJimuyouCdBeanList(beanList);

        return resultBean;
    }


    public static CancelProcessResultBean cancelProcess(String pKouteiKnrId, String pJimutetuzukiCd, String pUserId, String pComment) {

        CancelProcessResultBean resultBean = new CancelProcessResultBean();

        resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

        resultBean.setSyousaiMessageCd("IWFXXXX");

        resultBean.setSyousaiMessage("処理終了");

        resultBean.setErrorApiName(null);
        resultBean.setErrorApiName("LockProcess");
        resultBean.setErrorApiName("ProcessCancel");
        resultBean.setErrorApiName("UnlockProcess");

        return resultBean;
    }

    public static GetProcessHistoryResultBean getProcessHistory(String pKouteiKnrId, String pJimutetuzukiCd) {
        final GetProcessHistoryResultBean resultBean = new GetProcessHistoryResultBean();
        final List<ProcessHistoryBean> beanList = new ArrayList<ProcessHistoryBean>();
        ProcessHistoryBean bean;

        final Calendar cal = Calendar.getInstance();
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssSSS");
        final DecimalFormat df = new DecimalFormat("00");

        String str = "";
        try {
            final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("0 :0件データ\n");
            System.out.print("1 :1件データ\n");
            System.out.print("2 :10件データ\n");
            System.out.print("3 :1件データ\n");
            System.out.print("10:異常系 異常発生\n");
            System.out.print("d :defalt 100件\n");

            System.out.print("入力してください⇒");
            str = br.readLine();
        } catch (final IOException e) {
            e.printStackTrace();
        }
        System.out.println("入力値は：" + str);


        switch(str){
            case "0":
                System.out.println("CASE 0");

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NODATA);
                resultBean.setSyousaiMessageCd("IWF0000");
                resultBean.setSyousaiMessage("処理終了");
                break;

            case "1":
                System.out.println("CASE 1");

                for (int i = 0; i <= 0; i++) {
                    bean = new ProcessHistoryBean();
                    cal.add(Calendar.DATE, i);
                    bean.setProcessYmdTime(sdf.format(cal.getTime()));
                    bean.setTaskNm("TaskNm_" + Integer.toString(i));
                    bean.setDispTaskNm("タスク名_" + Integer.toString(i));
                    bean.setProcessResult("10");
                    bean.setTantouId("TantouId_" + Integer.toString(i));
                    bean.setTantouNm("担当者名_" + Integer.toString(i));
                    bean.setHistoryMessage("履歴メッセージ_" + Integer.toString(i));

                    beanList.add(bean);
                }
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWF0000");
                resultBean.setSyousaiMessage("処理終了");
                resultBean.setProcessHistoryBeanList(beanList);
                break;

            case "3":
                System.out.println("CASE 1");

                for (int i = 0; i <= 0; i++) {
                    bean = new ProcessHistoryBean();
                    cal.add(Calendar.DATE, i);
                    bean.setProcessYmdTime(sdf.format(cal.getTime()));
                    bean.setTaskNm("TaskNm_" + Integer.toString(i));
                    bean.setDispTaskNm("タスク名_" + Integer.toString(i));
                    bean.setProcessResult(C_SyorikekkaKbn.HORYUU.toString());
                    bean.setTantouId("TantouId_" + Integer.toString(i));
                    bean.setTantouNm("担当者名_" + Integer.toString(i));
                    bean.setHistoryMessage("履歴メッセージ_" + Integer.toString(i));

                    beanList.add(bean);
                }
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWF0000");
                resultBean.setSyousaiMessage("処理終了");
                resultBean.setProcessHistoryBeanList(beanList);
                break;

            case "2":
                System.out.println("CASE 0");

                for (int i = 0; i <= 9; i++) {
                    bean = new ProcessHistoryBean();
                    cal.add(Calendar.DATE, i);
                    bean.setProcessYmdTime(sdf.format(cal.getTime()));
                    bean.setTaskNm("TaskNm_" + Integer.toString(i));
                    bean.setDispTaskNm("タスク名_" + Integer.toString(i));
                    String a1 = "";
                    if(String.valueOf(i%3).equals("0")){
                        a1 = "10";
                    }else if(String.valueOf(i%3).equals("1")){
                        a1 = "20";
                    }else{
                        a1 = "90";
                    }
                    bean.setProcessResult(a1);
                    bean.setProcessResult("90");
                    bean.setTantouId("TantouId_" + Integer.toString(i));
                    bean.setTantouNm("担当者名_" + Integer.toString(i));
                    bean.setHistoryMessage("履歴メッセージ_" + Integer.toString(i));

                    beanList.add(bean);
                }
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWF0000");
                resultBean.setSyousaiMessage("処理終了");
                resultBean.setProcessHistoryBeanList(beanList);
                break;

            case "10":
                System.out.println("CASE 10");
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NG);
                resultBean.setSyousaiMessageCd("IWF0000");
                resultBean.setSyousaiMessage("処理終了");
                break;

            default:
                System.out.println("CASE default");
                for (int i = 0; i <= 99; i++) {
                    bean = new ProcessHistoryBean();
                    cal.add(Calendar.DATE, i);
                    bean.setProcessYmdTime(sdf.format(cal.getTime()));
                    bean.setTaskNm("TaskNm_" + Integer.toString(i));
                    bean.setDispTaskNm("タスク名_" + Integer.toString(i));
                    String a1 = "";
                    if(String.valueOf(i%3).equals("0")){
                        a1 = "10";
                    }else if(String.valueOf(i%3).equals("1")){
                        a1 = "20";
                    }else{
                        a1 = "90";
                    }
                    bean.setProcessResult(a1);
                    bean.setTantouId("TantouId_" + Integer.toString(i));
                    bean.setTantouNm("担当者名_" + Integer.toString(i));
                    bean.setHistoryMessage("履歴メッセージ_" + Integer.toString(i));

                    beanList.add(bean);
                }
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                resultBean.setProcessHistoryBeanList(beanList);
                break;
        }

        return resultBean;
    }


    public static GetTorikomiSyoruiMstResultBean getTorikomiSyoruiMst(String[] pJimutetuzukiCd) {
        GetTorikomiSyoruiMstResultBean resultBean = new GetTorikomiSyoruiMstResultBean();
        List<TorikomiSyoruiMstBean> beanList = new ArrayList<TorikomiSyoruiMstBean>();
        TorikomiSyoruiMstBean bean;

        String str = "";

        try {
            final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("0:異常系 IWF0001（異常終了しました）\n");
            System.out.print("-------------------\n");
            System.out.print("defaultデータ\n");
            System.out.print("★★★入力してください⇒");
            str = br.readLine();
        } catch (final IOException e) {
            e.printStackTrace();
        }
        System.out.println("入力値は：" + str);

        switch(str) {
            case "0":
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NG);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("異常終了しました。");
                break;
            default:
                System.out.println("DEFAULT\n");
                for (int i = 0; i <= 2; i++) {
                    bean = new TorikomiSyoruiMstBean();
                    bean.setSyoruiCd("wf00" + Integer.toString(i));
                    bean.setSyoruiNm("書類名_wf00" + Integer.toString(i));
                    bean.setSyoruiRyakuNm("書類略称_" + Integer.toString(i));
                    bean.setSyzkSyouBunruiId("SyzkSyouBunruiId_" + Integer.toString(i));
                    bean.setSyzkDaiBunruiId("SyzkDaiBunruiId_" + Integer.toString(i));
                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setZipHozonKbn(Integer.toString(i % 2));
                    bean.setKouteiSeigyoUmuKbn(Integer.toString(i % 2));
                    bean.setTaskNm("TaskNm_" + Integer.toString(i));

                    beanList.add(bean);
                }
                for (int i = 0; i <= 90; i++) {
                    bean = new TorikomiSyoruiMstBean();
                    bean.setSyoruiCd("sk00" + Integer.toString(i));
                    bean.setSyoruiNm("書類名_sk00" + Integer.toString(i));
                    bean.setSyoruiRyakuNm("書類略称_" + Integer.toString(i));
                    bean.setSyzkSyouBunruiId("SyzkSyouBunruiId_" + Integer.toString(i));
                    bean.setSyzkDaiBunruiId("SyzkDaiBunruiId_" + Integer.toString(i));
                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setZipHozonKbn(Integer.toString(i % 2));
                    bean.setKouteiSeigyoUmuKbn(Integer.toString(i % 2));
                    bean.setTaskNm("TaskNm_" + Integer.toString(i));

                    beanList.add(bean);
                }
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;
        }

        resultBean.setTorikomiSyoruiMstBeanList(beanList);


        return resultBean;
    }


    public static GetImagePropsListResultBean getImagePropsList(
        String pSubsystemId,
        String pUserId,
        String[] pJimutetuzukiCd,
        String pMosNo,
        String pSyoNo,
        String pNkSysyNo,
        String pSyoruiCd,
        String pToutyakuYmdTimeFrom,
        String pToutyakuYmdTimeTo,
        String pKouteiStatus) {

        GetImagePropsListResultBean resultBean = new GetImagePropsListResultBean();
        List<ImagePropsBean> beanList = new ArrayList<ImagePropsBean>();
        ImagePropsBean bean;

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssSSS");

        String str = "";

        try {
            final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("0:書類が登録済　表示リンク権限：あり\n");
            System.out.print("1:書類が登録済　表示リンク権限：なし\n");
            System.out.print("2:書類が未登録　表示リンク権限：あり\n");
            System.out.print("3:書類が未登録　表示リンク権限：なし\n");
            System.out.print("4:異常系 IWF0001（異常終了しました）\n");
            System.out.print("5:　0件データ\n");
            System.out.print("6:　1000件超えデータ\n");
            System.out.print("7:　1件データ\n");
            System.out.print("8:　10件データ\n");
            System.out.print("9:　11件データ\n");
            System.out.print("10:　999件データ\n");
            System.out.print("11:　1000件データ\n");
            System.out.print("12:　11件中、1件が機械取込\n");
            System.out.print("13:　事務手続が11文字以上\n");
            System.out.print("14:　事務手続が10文字\n");

            System.out.print("21:　4件データ（imagesyoukai申込番号＝890123458，890123466，890123474，890123482）\n");
            System.out.print("22:　2件データ（imagesyoukai申込番号＝890123458，890123474）\n");
            System.out.print("23:　1件データ（imagesyoukai申込番号＝890123458）\n");
            System.out.print("24:　1件データ（imagesyoukai申込番号＝890123458）\n");
            System.out.print("25:　3件データ（imagesyoukai証券番号＝12806345672，12806345683，12806345694）\n");
            System.out.print("26:　1件データ（imagesyoukai証券番号＝12806345672）\n");
            System.out.print("27:　3件データ（imagesyoukai証券番号＝32806345612，32806345623，32806345634）\n");
            System.out.print("28:　1件データ（imagesyoukai証券番号＝32806345612）\n");
            System.out.print("29:　3件データ（imagesyoukai年金証書番号＝42806345637，42806345648，42806345659）\n");
            System.out.print("30:　1件データ（imagesyoukai年金証書番号＝42806345637）\n");
            System.out.print("31:　1件データ（一覧表示項目：申込番号,証券番号,年金証書番号＝ブランクの確認）\n");

            System.out.print("41:　3件データ（imagesakujyo申込番号＝890123458、証券番号＝12806345672,申込番号＝890123466、証券番号＝12806345683，申込番号＝890123474、証券番号＝12806345694，）\n");
            System.out.print("42:　1件データ（imagesakujyo申込番号＝890123458、証券番号＝12806345672）\n");
            System.out.print("43:　1件データ（imagesakujyo申込番号＝890123466、証券番号＝12806345683）\n");
            System.out.print("44:　0件データ（imagesakujyo指定された抽出条件に合致するイメージは存在しません。(EDF0009)）\n");
            System.out.print("45:　2件データ（imagesakujyo申込番号＝890123482、証券番号＝12806345708，申込番号＝890123490、証券番号＝12806345708）\n");
            System.out.print("46:　3件データ（imagesakujyo証券番号＝12806345672，12806345683，12806345694）\n");
            System.out.print("47:　0件データ（imagesakujyo指定された抽出条件に合致するイメージは存在しません。(EDF0009)）\n");
            System.out.print("48:　1件データ（imagesakujyo証券番号＝12806345731）\n");
            System.out.print("49:　3件データ（imagesakujyo証券番号＝12806345742，12806345753，12806345764）\n");
            System.out.print("50:　0件データ（imagesakujyo指定された抽出条件に合致するイメージは存在しません。(EDF0009)）\n");
            System.out.print("51:　1件データ（imagesakujyo証券番号＝12806345786）\n");
            System.out.print("52:　3件データ（imagesakujyo年金証書番号＝12806345797，12806345801，12806345812）\n");
            System.out.print("53:　0件データ（imagesakujyo指定された抽出条件に合致するイメージは存在しません。(EDF0009)）\n");
            System.out.print("54:　1件データ（imagesakujyo年金証書番号＝12806345834）\n");
            System.out.print("55:　1件データ（一覧表示項目：申込番号,証券番号,年金証書番号＝ブランクの確認）\n");

            System.out.print("-------------------\n");
            System.out.print("default:100件データ\n");
            System.out.print("★★★入力してください⇒");
            str = br.readLine();
        } catch (final IOException e) {
            e.printStackTrace();
        }
        System.out.println("入力値は：" + str);

        switch(str){
            case "41":
                System.out.println("CASE 41\n");
                for (int i = 0; i <= 2; i++) {
                    bean = new ImagePropsBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);

                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setJimutetuzukiNm("事務手続名abc_" + Integer.toString(i));
                    bean.setImageId("ImageId_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    bean.setTorikomiSyoruiCd("TorikomiSyoruiCd_" + Integer.toString(i));
                    bean.setDispTorikomiSyoruiNm("取込書類名_" + Integer.toString(i));
                    bean.setSyoruiTtykYmdTime(sdf.format(cal.getTime()));
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setKengenUmu(Integer.toString(1));
                    bean.setTourokuUserNm("登録者_" + Integer.toString(i));
                    bean.setSyoruiTorikomiHouKbn("1");

                    beanList.add(bean);
                }

                beanList.get(0).setMosNo("890123458");
                beanList.get(1).setMosNo("890123466");
                beanList.get(2).setMosNo("890123474");

                beanList.get(0).setSyoNo("12806345672");
                beanList.get(1).setSyoNo("12806345683");
                beanList.get(2).setSyoNo("12806345694");

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;

            case "42":
                System.out.println("CASE 42\n");
                for (int i = 0; i <= 0; i++) {
                    bean = new ImagePropsBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);

                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setJimutetuzukiNm("事務手続名abc_" + Integer.toString(i));
                    bean.setImageId("ImageId_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    bean.setTorikomiSyoruiCd("TorikomiSyoruiCd_" + Integer.toString(i));
                    bean.setDispTorikomiSyoruiNm("取込書類名_" + Integer.toString(i));
                    bean.setSyoruiTtykYmdTime(sdf.format(cal.getTime()));
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setKengenUmu(Integer.toString(1));
                    bean.setTourokuUserNm("登録者_" + Integer.toString(i));
                    bean.setSyoruiTorikomiHouKbn("1");

                    beanList.add(bean);
                }

                beanList.get(0).setMosNo("890123458");

                beanList.get(0).setSyoNo("12806345672");

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;

            case "43":
                System.out.println("CASE 43\n");
                for (int i = 0; i <= 0; i++) {
                    bean = new ImagePropsBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);

                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setJimutetuzukiNm("事務手続名abc_" + Integer.toString(i));
                    bean.setImageId("ImageId_" + Integer.toString(i));
                    bean.setTorikomiSyoruiCd("TorikomiSyoruiCd_" + Integer.toString(i));
                    bean.setDispTorikomiSyoruiNm("取込書類名_" + Integer.toString(i));
                    bean.setSyoruiTtykYmdTime(sdf.format(cal.getTime()));
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setKengenUmu(Integer.toString(1));
                    bean.setTourokuUserNm("登録者_" + Integer.toString(i));
                    bean.setSyoruiTorikomiHouKbn("1");

                    beanList.add(bean);
                }

                beanList.get(0).setMosNo("890123466");

                beanList.get(0).setSyoNo("12806345683");

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;

            case "44":
            case "47":
            case "50":
            case "53":
                System.out.println("CASE 44,47,50,53\n");

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;

            case "45":
                System.out.println("CASE 45\n");
                for (int i = 0; i <= 1; i++) {
                    bean = new ImagePropsBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);

                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setJimutetuzukiNm("事務手続名abc_" + Integer.toString(i));
                    bean.setImageId("ImageId_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    bean.setTorikomiSyoruiCd("TorikomiSyoruiCd_" + Integer.toString(i));
                    bean.setDispTorikomiSyoruiNm("取込書類名_" + Integer.toString(i));
                    bean.setSyoruiTtykYmdTime(sdf.format(cal.getTime()));
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setKengenUmu(Integer.toString(1));
                    bean.setTourokuUserNm("登録者_" + Integer.toString(i));
                    bean.setSyoruiTorikomiHouKbn("1");

                    beanList.add(bean);
                }

                beanList.get(0).setMosNo("890123482");
                beanList.get(1).setMosNo("890123490");

                beanList.get(0).setSyoNo("12806345708");
                beanList.get(1).setSyoNo("12806345708");

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;
            case "46":
                System.out.println("CASE 46\n");
                for (int i = 0; i <= 2; i++) {
                    bean = new ImagePropsBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);

                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setJimutetuzukiNm("事務手続名abc_" + Integer.toString(i));
                    bean.setImageId("ImageId_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    bean.setTorikomiSyoruiCd("TorikomiSyoruiCd_" + Integer.toString(i));
                    bean.setDispTorikomiSyoruiNm("取込書類名_" + Integer.toString(i));
                    bean.setSyoruiTtykYmdTime(sdf.format(cal.getTime()));
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setKengenUmu(Integer.toString(1));
                    bean.setTourokuUserNm("登録者_" + Integer.toString(i));
                    bean.setSyoruiTorikomiHouKbn("1");

                    beanList.add(bean);
                }

                beanList.get(0).setSyoNo("12806345672");
                beanList.get(1).setSyoNo("12806345683");
                beanList.get(2).setSyoNo("12806345694");
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;
            case "48":
                System.out.println("CASE 48\n");
                for (int i = 0; i <= 0; i++) {
                    bean = new ImagePropsBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);

                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setJimutetuzukiNm("事務手続名abc_" + Integer.toString(i));
                    bean.setImageId("ImageId_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    bean.setTorikomiSyoruiCd("TorikomiSyoruiCd_" + Integer.toString(i));
                    bean.setDispTorikomiSyoruiNm("取込書類名_" + Integer.toString(i));
                    bean.setSyoruiTtykYmdTime(sdf.format(cal.getTime()));
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setKengenUmu(Integer.toString(1));
                    bean.setTourokuUserNm("登録者_" + Integer.toString(i));
                    bean.setSyoruiTorikomiHouKbn("1");

                    beanList.add(bean);
                }

                beanList.get(0).setSyoNo("12806345731");
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;
            case "49":
                System.out.println("CASE 49\n");
                for (int i = 0; i <= 2; i++) {
                    bean = new ImagePropsBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);

                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setJimutetuzukiNm("事務手続名abc_" + Integer.toString(i));
                    bean.setImageId("ImageId_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    bean.setTorikomiSyoruiCd("TorikomiSyoruiCd_" + Integer.toString(i));
                    bean.setDispTorikomiSyoruiNm("取込書類名_" + Integer.toString(i));
                    bean.setSyoruiTtykYmdTime(sdf.format(cal.getTime()));
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setKengenUmu(Integer.toString(1));
                    bean.setTourokuUserNm("登録者_" + Integer.toString(i));
                    bean.setSyoruiTorikomiHouKbn("1");

                    beanList.add(bean);
                }

                beanList.get(0).setSyoNo("12806345742");
                beanList.get(1).setSyoNo("12806345753");
                beanList.get(2).setSyoNo("12806345764");
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;
            case "51":
                System.out.println("CASE 51\n");
                for (int i = 0; i <= 0; i++) {
                    bean = new ImagePropsBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);

                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setJimutetuzukiNm("事務手続名abc_" + Integer.toString(i));
                    bean.setImageId("ImageId_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    bean.setTorikomiSyoruiCd("TorikomiSyoruiCd_" + Integer.toString(i));
                    bean.setDispTorikomiSyoruiNm("取込書類名_" + Integer.toString(i));
                    bean.setSyoruiTtykYmdTime(sdf.format(cal.getTime()));
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setKengenUmu(Integer.toString(1));
                    bean.setTourokuUserNm("登録者_" + Integer.toString(i));
                    bean.setSyoruiTorikomiHouKbn("1");

                    beanList.add(bean);
                }

                beanList.get(0).setSyoNo("12806345786");
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;
            case "52":
                System.out.println("CASE 52\n");
                for (int i = 0; i <= 2; i++) {
                    bean = new ImagePropsBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);

                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setJimutetuzukiNm("事務手続名abc_" + Integer.toString(i));
                    bean.setImageId("ImageId_" + Integer.toString(i));
                    bean.setTorikomiSyoruiCd("TorikomiSyoruiCd_" + Integer.toString(i));
                    bean.setDispTorikomiSyoruiNm("取込書類名_" + Integer.toString(i));
                    bean.setSyoruiTtykYmdTime(sdf.format(cal.getTime()));
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setKengenUmu(Integer.toString(1));
                    bean.setTourokuUserNm("登録者_" + Integer.toString(i));
                    bean.setSyoruiTorikomiHouKbn("1");

                    beanList.add(bean);
                }

                beanList.get(0).setNkSysyNo("12806345797");
                beanList.get(1).setNkSysyNo("12806345801");
                beanList.get(2).setNkSysyNo("12806345812");
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;
            case "54":
                System.out.println("CASE 55\n");
                for (int i = 0; i <= 0; i++) {
                    bean = new ImagePropsBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);

                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setJimutetuzukiNm("事務手続名abc_" + Integer.toString(i));
                    bean.setImageId("ImageId_" + Integer.toString(i));
                    bean.setTorikomiSyoruiCd("TorikomiSyoruiCd_" + Integer.toString(i));
                    bean.setDispTorikomiSyoruiNm("取込書類名_" + Integer.toString(i));
                    bean.setSyoruiTtykYmdTime(sdf.format(cal.getTime()));
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setKengenUmu(Integer.toString(1));
                    bean.setTourokuUserNm("登録者_" + Integer.toString(i));
                    bean.setSyoruiTorikomiHouKbn("1");

                    beanList.add(bean);
                }

                beanList.get(0).setNkSysyNo("12806345834");
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;

            case "55":
                System.out.println("CASE 54\n");
                for (int i = 0; i <= 0; i++) {
                    bean = new ImagePropsBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);

                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setJimutetuzukiNm("事務手続名abc_" + Integer.toString(i));
                    bean.setImageId("ImageId_" + Integer.toString(i));
                    bean.setTorikomiSyoruiCd("TorikomiSyoruiCd_" + Integer.toString(i));
                    bean.setDispTorikomiSyoruiNm("取込書類名_" + Integer.toString(i));
                    bean.setSyoruiTtykYmdTime(sdf.format(cal.getTime()));
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setKengenUmu(Integer.toString(1));
                    bean.setTourokuUserNm("登録者_" + Integer.toString(i));
                    bean.setSyoruiTorikomiHouKbn("1");

                    beanList.add(bean);
                }
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;


            case "21":
                System.out.println("CASE 21\n");

                for (int i = 0; i <= 3; i++) {
                    bean = new ImagePropsBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);

                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setJimutetuzukiNm("事務手続名abc_" + Integer.toString(i));
                    bean.setImageId("ImageId_" + Integer.toString(i));
                    bean.setSyoNo("SyoNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    bean.setTorikomiSyoruiCd("TorikomiSyoruiCd_" + Integer.toString(i));
                    bean.setDispTorikomiSyoruiNm("取込書類名_" + Integer.toString(i));
                    bean.setSyoruiTtykYmdTime(sdf.format(cal.getTime()));
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setKengenUmu(Integer.toString(i%2));
                    bean.setTourokuUserNm("登録者_" + Integer.toString(i));
                    bean.setSyoruiTorikomiHouKbn("1");

                    beanList.add(bean);
                }

                beanList.get(0).setMosNo("890123458");
                beanList.get(1).setMosNo("890123466");
                beanList.get(2).setMosNo("890123474");
                beanList.get(3).setMosNo("890123482");

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;

            case "22":
                System.out.println("CASE 22\n");

                for (int i = 0; i <= 1; i++) {
                    bean = new ImagePropsBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);

                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setJimutetuzukiNm("事務手続名abc_" + Integer.toString(i));
                    bean.setImageId("ImageId_" + Integer.toString(i));
                    bean.setSyoNo("SyoNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    bean.setTorikomiSyoruiCd("TorikomiSyoruiCd_" + Integer.toString(i));
                    bean.setDispTorikomiSyoruiNm("取込書類名_" + Integer.toString(i));
                    bean.setSyoruiTtykYmdTime(sdf.format(cal.getTime()));
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setKengenUmu(Integer.toString(i%2));
                    bean.setTourokuUserNm("登録者_" + Integer.toString(i));
                    bean.setSyoruiTorikomiHouKbn("1");

                    beanList.add(bean);
                }

                beanList.get(0).setMosNo("890123458");
                beanList.get(1).setMosNo("890123474");

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;

            case "23":

            case "24":
                System.out.println("CASE 24\n");

                for (int i = 0; i <= 0; i++) {
                    bean = new ImagePropsBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);

                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setJimutetuzukiNm("事務手続名abc_" + Integer.toString(i));
                    bean.setImageId("ImageId_" + Integer.toString(i));
                    bean.setSyoNo("SyoNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    bean.setTorikomiSyoruiCd("TorikomiSyoruiCd_" + Integer.toString(i));
                    bean.setDispTorikomiSyoruiNm("取込書類名_" + Integer.toString(i));
                    bean.setSyoruiTtykYmdTime(sdf.format(cal.getTime()));
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setKengenUmu(Integer.toString(i%2));
                    bean.setTourokuUserNm("登録者_" + Integer.toString(i));
                    bean.setSyoruiTorikomiHouKbn("1");

                    beanList.add(bean);
                }

                beanList.get(0).setMosNo("890123458");

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;

            case "25":
                System.out.println("CASE 25\n");

                for (int i = 0; i <= 2; i++) {
                    bean = new ImagePropsBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);

                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setJimutetuzukiNm("事務手続名abc_" + Integer.toString(i));
                    bean.setImageId("ImageId_" + Integer.toString(i));
                    bean.setMosNo("MosNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    bean.setTorikomiSyoruiCd("TorikomiSyoruiCd_" + Integer.toString(i));
                    bean.setDispTorikomiSyoruiNm("取込書類名_" + Integer.toString(i));
                    bean.setSyoruiTtykYmdTime(sdf.format(cal.getTime()));
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setKengenUmu(Integer.toString(i%2));
                    bean.setTourokuUserNm("登録者_" + Integer.toString(i));
                    bean.setSyoruiTorikomiHouKbn("1");

                    beanList.add(bean);
                }

                beanList.get(0).setSyoNo("12806345672");
                beanList.get(1).setSyoNo("12806345683");
                beanList.get(2).setSyoNo("12806345694");

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;

            case "26":
                System.out.println("CASE 26\n");

                for (int i = 0; i <= 0; i++) {
                    bean = new ImagePropsBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);

                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setJimutetuzukiNm("事務手続名abc_" + Integer.toString(i));
                    bean.setImageId("ImageId_" + Integer.toString(i));
                    bean.setMosNo("MosNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    bean.setTorikomiSyoruiCd("TorikomiSyoruiCd_" + Integer.toString(i));
                    bean.setDispTorikomiSyoruiNm("取込書類名_" + Integer.toString(i));
                    bean.setSyoruiTtykYmdTime(sdf.format(cal.getTime()));
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setKengenUmu(Integer.toString(i%2));
                    bean.setTourokuUserNm("登録者_" + Integer.toString(i));
                    bean.setSyoruiTorikomiHouKbn("1");

                    beanList.add(bean);
                }

                beanList.get(0).setSyoNo("12806345672");

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;
            case "27":
                System.out.println("CASE 27\n");

                for (int i = 0; i <= 2; i++) {
                    bean = new ImagePropsBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);

                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setJimutetuzukiNm("事務手続名abc_" + Integer.toString(i));
                    bean.setImageId("ImageId_" + Integer.toString(i));
                    bean.setMosNo("MosNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    bean.setTorikomiSyoruiCd("TorikomiSyoruiCd_" + Integer.toString(i));
                    bean.setDispTorikomiSyoruiNm("取込書類名_" + Integer.toString(i));
                    bean.setSyoruiTtykYmdTime(sdf.format(cal.getTime()));
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setKengenUmu(Integer.toString(i%2));
                    bean.setTourokuUserNm("登録者_" + Integer.toString(i));
                    bean.setSyoruiTorikomiHouKbn("1");

                    beanList.add(bean);
                }

                beanList.get(0).setSyoNo("32806345612");
                beanList.get(1).setSyoNo("32806345623");
                beanList.get(2).setSyoNo("32806345634");

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;

            case "28":
                System.out.println("CASE 28\n");

                for (int i = 0; i <= 0; i++) {
                    bean = new ImagePropsBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);

                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setJimutetuzukiNm("事務手続名abc_" + Integer.toString(i));
                    bean.setImageId("ImageId_" + Integer.toString(i));
                    bean.setMosNo("MosNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    bean.setTorikomiSyoruiCd("TorikomiSyoruiCd_" + Integer.toString(i));
                    bean.setDispTorikomiSyoruiNm("取込書類名_" + Integer.toString(i));
                    bean.setSyoruiTtykYmdTime(sdf.format(cal.getTime()));
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setKengenUmu(Integer.toString(i%2));
                    bean.setTourokuUserNm("登録者_" + Integer.toString(i));
                    bean.setSyoruiTorikomiHouKbn("1");

                    beanList.add(bean);
                }

                beanList.get(0).setSyoNo("32806345612");

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;

            case "29":
                System.out.println("CASE 29\n");

                for (int i = 0; i <= 2; i++) {
                    bean = new ImagePropsBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);

                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setJimutetuzukiNm("事務手続名abc_" + Integer.toString(i));
                    bean.setImageId("ImageId_" + Integer.toString(i));
                    bean.setMosNo("MosNo_" + Integer.toString(i));
                    bean.setSyoNo("SyoNo_" + Integer.toString(i));
                    bean.setTorikomiSyoruiCd("TorikomiSyoruiCd_" + Integer.toString(i));
                    bean.setDispTorikomiSyoruiNm("取込書類名_" + Integer.toString(i));
                    bean.setSyoruiTtykYmdTime(sdf.format(cal.getTime()));
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setKengenUmu(Integer.toString(i%2));
                    bean.setTourokuUserNm("登録者_" + Integer.toString(i));
                    bean.setSyoruiTorikomiHouKbn("1");

                    beanList.add(bean);
                }

                beanList.get(0).setNkSysyNo("42806345637");
                beanList.get(1).setNkSysyNo("42806345648");
                beanList.get(2).setNkSysyNo("42806345659");

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;

            case "30":
                System.out.println("CASE 30\n");

                for (int i = 0; i <= 0; i++) {
                    bean = new ImagePropsBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);

                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setJimutetuzukiNm("事務手続名abc_" + Integer.toString(i));
                    bean.setImageId("ImageId_" + Integer.toString(i));
                    bean.setMosNo("MosNo_" + Integer.toString(i));
                    bean.setSyoNo("SyoNo_" + Integer.toString(i));
                    bean.setTorikomiSyoruiCd("TorikomiSyoruiCd_" + Integer.toString(i));
                    bean.setDispTorikomiSyoruiNm("取込書類名_" + Integer.toString(i));
                    bean.setSyoruiTtykYmdTime(sdf.format(cal.getTime()));
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setKengenUmu(Integer.toString(i%2));
                    bean.setTourokuUserNm("登録者_" + Integer.toString(i));
                    bean.setSyoruiTorikomiHouKbn("1");

                    beanList.add(bean);
                }

                beanList.get(0).setNkSysyNo("42806345637");

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;

            case "31":
                System.out.println("CASE 31\n");

                for (int i = 0; i <= 0; i++) {
                    bean = new ImagePropsBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);

                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setJimutetuzukiNm("事務手続名abc_" + Integer.toString(i));
                    bean.setImageId("ImageId_" + Integer.toString(i));
                    bean.setTorikomiSyoruiCd("TorikomiSyoruiCd_" + Integer.toString(i));
                    bean.setDispTorikomiSyoruiNm("取込書類名_" + Integer.toString(i));
                    bean.setSyoruiTtykYmdTime(sdf.format(cal.getTime()));
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setKengenUmu(Integer.toString(i%2));
                    bean.setTourokuUserNm("登録者_" + Integer.toString(i));
                    bean.setSyoruiTorikomiHouKbn("1");

                    beanList.add(bean);
                }

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;

            case "0":
                System.out.println("CASE 0\n");

                for (int i = 0; i <= 99; i++) {
                    bean = new ImagePropsBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);

                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setJimutetuzukiNm("事務手続名_" + Integer.toString(i));
                    bean.setImageId("ImageId_" + Integer.toString(i));
                    bean.setMosNo("MosNo_" + Integer.toString(i));
                    bean.setSyoNo("SyoNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    bean.setTorikomiSyoruiCd("TorikomiSyoruiCd_" + Integer.toString(i));
                    bean.setDispTorikomiSyoruiNm("取込書類名_" + Integer.toString(i));
                    bean.setSyoruiTtykYmdTime(sdf.format(cal.getTime()));
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setKengenUmu(Integer.toString(1));
                    bean.setTourokuUserNm("登録者_" + Integer.toString(i));
                    bean.setSyoruiTorikomiHouKbn("1");

                    beanList.add(bean);
                }
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;

            case "1":
                System.out.println("CASE 1\n");

                for (int i = 0; i <= 99; i++) {
                    bean = new ImagePropsBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);

                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setJimutetuzukiNm("事務手続名_" + Integer.toString(i));
                    bean.setImageId("ImageId_" + Integer.toString(i));
                    bean.setMosNo("MosNo_" + Integer.toString(i));
                    bean.setSyoNo("SyoNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    bean.setTorikomiSyoruiCd("TorikomiSyoruiCd_" + Integer.toString(i));
                    bean.setDispTorikomiSyoruiNm("取込書類名_" + Integer.toString(i));
                    bean.setSyoruiTtykYmdTime(sdf.format(cal.getTime()));
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setKengenUmu(Integer.toString(0));
                    bean.setTourokuUserNm("登録者_" + Integer.toString(i));
                    bean.setSyoruiTorikomiHouKbn("1");

                    beanList.add(bean);
                }
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;

            case "2":
                System.out.println("CASE 2\n");

                for (int i = 0; i <= 99; i++) {
                    bean = new ImagePropsBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);

                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setJimutetuzukiNm("事務手続名_" + Integer.toString(i));
                    bean.setImageId("ImageId_" + Integer.toString(i));
                    bean.setMosNo("MosNo_" + Integer.toString(i));
                    bean.setSyoNo("SyoNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    bean.setTorikomiSyoruiCd("TorikomiSyoruiCd_dummy" + Integer.toString(i));
                    bean.setDispTorikomiSyoruiNm("取込書類名_" + Integer.toString(i));
                    bean.setSyoruiTtykYmdTime(sdf.format(cal.getTime()));
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setKengenUmu(Integer.toString(1));
                    bean.setTourokuUserNm("登録者_" + Integer.toString(i));
                    bean.setSyoruiTorikomiHouKbn("1");

                    beanList.add(bean);
                }
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;

            case "3":
                System.out.println("CASE 3\n");

                for (int i = 0; i <= 99; i++) {
                    bean = new ImagePropsBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);

                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setJimutetuzukiNm("事務手続名_" + Integer.toString(i));
                    bean.setImageId("ImageId_" + Integer.toString(i));
                    bean.setMosNo("MosNo_" + Integer.toString(i));
                    bean.setSyoNo("SyoNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    bean.setTorikomiSyoruiCd("TorikomiSyoruiCd_dummy" + Integer.toString(i));
                    bean.setDispTorikomiSyoruiNm("取込書類名_" + Integer.toString(i));
                    bean.setSyoruiTtykYmdTime(sdf.format(cal.getTime()));
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setKengenUmu(Integer.toString(0));
                    bean.setTourokuUserNm("登録者_" + Integer.toString(i));
                    bean.setSyoruiTorikomiHouKbn("1");

                    beanList.add(bean);
                }
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;

            case "4":
                System.out.print("CASE 4\n");
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NG);
                resultBean.setSyousaiMessageCd("IWF0001");
                resultBean.setSyousaiMessage("異常終了しました");
                break;

            case "5":
                System.out.print("CASE 5\n");
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("正常終了しました");
                break;

            case "6":
                System.out.println("CASE 6\n");

                for (int i = 0; i <= 1000; i++) {
                    bean = new ImagePropsBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);

                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setJimutetuzukiNm("事務手続名_" + Integer.toString(i));
                    bean.setImageId("ImageId_" + Integer.toString(i));
                    bean.setMosNo("MosNo_" + Integer.toString(i));
                    bean.setSyoNo("SyoNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    bean.setTorikomiSyoruiCd("TorikomiSyoruiCd_" + Integer.toString(i));
                    bean.setDispTorikomiSyoruiNm("取込書類名_" + Integer.toString(i));
                    bean.setSyoruiTtykYmdTime(sdf.format(cal.getTime()));
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setKengenUmu(Integer.toString(i%2));
                    bean.setTourokuUserNm("登録者_" + Integer.toString(i));
                    bean.setSyoruiTorikomiHouKbn("1");

                    beanList.add(bean);
                }
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;

            case "7":
                System.out.println("CASE 7\n");

                for (int i = 0; i <= 0; i++) {
                    bean = new ImagePropsBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);

                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setJimutetuzukiNm("事務手続名_" + Integer.toString(i));
                    bean.setImageId("ImageId_" + Integer.toString(i));
                    bean.setMosNo("MosNo_" + Integer.toString(i));
                    bean.setSyoNo("SyoNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    bean.setTorikomiSyoruiCd("TorikomiSyoruiCd_" + Integer.toString(i));
                    bean.setDispTorikomiSyoruiNm("取込書類名_" + Integer.toString(i));
                    bean.setSyoruiTtykYmdTime(sdf.format(cal.getTime()));
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setKengenUmu(Integer.toString(i%2));
                    bean.setTourokuUserNm("登録者_" + Integer.toString(i));
                    bean.setSyoruiTorikomiHouKbn("1");

                    beanList.add(bean);
                }
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;

            case "8":
                System.out.println("CASE 8\n");

                for (int i = 0; i <= 9; i++) {
                    bean = new ImagePropsBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);

                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setJimutetuzukiNm("事務手続名_" + Integer.toString(i));
                    bean.setImageId("ImageId_" + Integer.toString(i));
                    bean.setMosNo("MosNo_" + Integer.toString(i));
                    bean.setSyoNo("SyoNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    bean.setTorikomiSyoruiCd("TorikomiSyoruiCd_" + Integer.toString(i));
                    bean.setDispTorikomiSyoruiNm("取込書類名_" + Integer.toString(i));
                    bean.setSyoruiTtykYmdTime(sdf.format(cal.getTime()));
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setKengenUmu(Integer.toString(i%2));
                    bean.setTourokuUserNm("登録者_" + Integer.toString(i));
                    bean.setSyoruiTorikomiHouKbn("1");

                    beanList.add(bean);
                }
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;

            case "9":
                System.out.println("CASE 9\n");

                for (int i = 0; i <= 10; i++) {
                    bean = new ImagePropsBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);

                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setJimutetuzukiNm("事務手続名_" + Integer.toString(i));
                    bean.setImageId("ImageId_" + Integer.toString(i));
                    bean.setMosNo("MosNo_" + Integer.toString(i));
                    bean.setSyoNo("SyoNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    bean.setTorikomiSyoruiCd("TorikomiSyoruiCd_" + Integer.toString(i));
                    bean.setDispTorikomiSyoruiNm("取込書類名_" + Integer.toString(i));
                    bean.setSyoruiTtykYmdTime(sdf.format(cal.getTime()));
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setKengenUmu(Integer.toString(i%2));
                    bean.setTourokuUserNm("登録者_" + Integer.toString(i));
                    bean.setSyoruiTorikomiHouKbn("1");

                    beanList.add(bean);
                }
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;

            case "10":
                System.out.println("CASE 10\n");

                for (int i = 0; i <= 998; i++) {
                    bean = new ImagePropsBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);

                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setJimutetuzukiNm("事務手続名_" + Integer.toString(i));
                    bean.setImageId("ImageId_" + Integer.toString(i));
                    bean.setMosNo("MosNo_" + Integer.toString(i));
                    bean.setSyoNo("SyoNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    bean.setTorikomiSyoruiCd("TorikomiSyoruiCd_" + Integer.toString(i));
                    bean.setDispTorikomiSyoruiNm("取込書類名_" + Integer.toString(i));
                    bean.setSyoruiTtykYmdTime(sdf.format(cal.getTime()));
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setKengenUmu(Integer.toString(i%2));
                    bean.setTourokuUserNm("登録者_" + Integer.toString(i));
                    bean.setSyoruiTorikomiHouKbn("1");

                    beanList.add(bean);
                }
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;

            case "11":
                System.out.println("CASE 11\n");

                for (int i = 0; i <= 999; i++) {
                    bean = new ImagePropsBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);

                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setJimutetuzukiNm("事務手続名_" + Integer.toString(i));
                    bean.setImageId("ImageId_" + Integer.toString(i));
                    bean.setMosNo("MosNo_" + Integer.toString(i));
                    bean.setSyoNo("SyoNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    bean.setTorikomiSyoruiCd("TorikomiSyoruiCd_" + Integer.toString(i));
                    bean.setDispTorikomiSyoruiNm("取込書類名_" + Integer.toString(i));
                    bean.setSyoruiTtykYmdTime(sdf.format(cal.getTime()));
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setKengenUmu(Integer.toString(i%2));
                    bean.setTourokuUserNm("登録者_" + Integer.toString(i));
                    bean.setSyoruiTorikomiHouKbn("1");

                    beanList.add(bean);
                }
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;

            case "12":
                System.out.println("CASE 12\n");

                for (int i = 0; i <= 10; i++) {
                    bean = new ImagePropsBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);

                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setJimutetuzukiNm("事務手続名_" + Integer.toString(i));
                    bean.setImageId("ImageId_" + Integer.toString(i));
                    bean.setMosNo("MosNo_" + Integer.toString(i));
                    bean.setSyoNo("SyoNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    bean.setTorikomiSyoruiCd("TorikomiSyoruiCd_" + Integer.toString(i));
                    bean.setDispTorikomiSyoruiNm("取込書類名_" + Integer.toString(i));
                    bean.setSyoruiTtykYmdTime(sdf.format(cal.getTime()));
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setKengenUmu(Integer.toString(i%2));
                    bean.setTourokuUserNm("登録者_" + Integer.toString(i));
                    bean.setSyoruiTorikomiHouKbn(Integer.toString(i));

                    beanList.add(bean);
                }
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;

            case "13":
                System.out.println("CASE 13\n");

                for (int i = 0; i <= 99; i++) {
                    bean = new ImagePropsBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);

                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setJimutetuzukiNm("事務手続名abcde_" + Integer.toString(i));
                    bean.setImageId("ImageId_" + Integer.toString(i));
                    bean.setMosNo("MosNo_" + Integer.toString(i));
                    bean.setSyoNo("SyoNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    bean.setTorikomiSyoruiCd("TorikomiSyoruiCd_" + Integer.toString(i));
                    bean.setDispTorikomiSyoruiNm("取込書類名_" + Integer.toString(i));
                    bean.setSyoruiTtykYmdTime(sdf.format(cal.getTime()));
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setKengenUmu(Integer.toString(i%2));
                    bean.setTourokuUserNm("登録者_" + Integer.toString(i));
                    bean.setSyoruiTorikomiHouKbn("1");

                    beanList.add(bean);
                }
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;

            case "14":
                System.out.println("CASE 14\n");

                for (int i = 0; i <= 99; i++) {
                    bean = new ImagePropsBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);

                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setJimutetuzukiNm("事務手続名abc_" + Integer.toString(i));
                    bean.setImageId("ImageId_" + Integer.toString(i));
                    bean.setMosNo("MosNo_" + Integer.toString(i));
                    bean.setSyoNo("SyoNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    bean.setTorikomiSyoruiCd("TorikomiSyoruiCd_" + Integer.toString(i));
                    bean.setDispTorikomiSyoruiNm("取込書類名_" + Integer.toString(i));
                    bean.setSyoruiTtykYmdTime(sdf.format(cal.getTime()));
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setKengenUmu(Integer.toString(i%2));
                    bean.setTourokuUserNm("登録者_" + Integer.toString(i));
                    bean.setSyoruiTorikomiHouKbn("1");

                    beanList.add(bean);
                }
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;

            default:
                System.out.println("CASE 0\n");

                for (int i = 0; i <= 99; i++) {
                    bean = new ImagePropsBean();
                    cal.add(Calendar.DAY_OF_MONTH, -1);

                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setJimutetuzukiNm("事務手続名_" + Integer.toString(i));
                    bean.setImageId("ImageId_" + Integer.toString(i));
                    bean.setMosNo("MosNo_" + Integer.toString(i));
                    bean.setSyoNo("SyoNo_" + Integer.toString(i));
                    bean.setNkSysyNo("NkSysyNo_" + Integer.toString(i));
                    bean.setTorikomiSyoruiCd("TorikomiSyoruiCd_" + Integer.toString(i));
                    bean.setDispTorikomiSyoruiNm("取込書類名_" + Integer.toString(i));
                    bean.setSyoruiTtykYmdTime(sdf.format(cal.getTime()));
                    bean.setKouteiStatus("10");
                    bean.setDispKouteiStatus("処理中");
                    bean.setKengenUmu(Integer.toString(i%2));
                    bean.setTourokuUserNm("登録者_" + Integer.toString(i));
                    bean.setSyoruiTorikomiHouKbn("1");

                    beanList.add(bean);
                }
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;
        }


        resultBean.setImagePropsBeanList(beanList);

        return resultBean;
    }

    public static GetImageInfoListResultBean getImage(String pImageId, String pUserId) {
        GetImageInfoListResultBean resultBean = new GetImageInfoListResultBean();
        ImageInfoBean bean = new ImageInfoBean();
        List<ImageInfoBean> beanList = new ArrayList<ImageInfoBean>();

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssSSS");
        cal.add(Calendar.DAY_OF_MONTH, -10);

        String str = "";

        try {
            final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("0:異常系 IWF0001（異常終了しました）\n");
            System.out.print("-------------------\n");
            System.out.print("default:正常データ\n");
            System.out.print("★★★入力してください⇒");
            str = br.readLine();
        } catch (final IOException e) {
            e.printStackTrace();
        }
        System.out.println("入力値は：" + str);

        switch(str){
            case "0":
                System.out.println("CASE 0\n");
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NG);
                resultBean.setSyousaiMessageCd("IWF0001");
                resultBean.setSyousaiMessage("異常終了しました");
                break;

            default:

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

                resultBean.setSyousaiMessageCd("IWFXXXX");

                resultBean.setSyousaiMessage("処理終了");

                bean.setImageid(pImageId);
                bean.setSyoNo("SyoNo_1");
                bean.setNkSysyNo("NkSysyNo_1");
                bean.setTorikomisyoruicd("TorikomiSyoruiCd_1");
                bean.setSyoruittykymdtime(sdf.format(cal.getTime()));
                bean.setKouteistatus("10");
                bean.setKengenumu("1");

                byte[] b = new byte[102400];
                DataInputStream dataInStream = null;
                try {
                    dataInStream =
                        new DataInputStream(
                            new BufferedInputStream(
                                new FileInputStream("D:/develop/temp/dummy.pdf")));
                    dataInStream.readFully(b);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (dataInStream != null){
                        try {
                            dataInStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

                bean.setPdfImage(b);
                beanList.add(bean);
                break;
        }

        resultBean.setImageInfoBeanList(beanList);

        return resultBean;
    }

    public static PutImageResultBean putImage(
        String pTorikomiSyoruiCd,
        String pUserId,
        String pJimutetuzukiCd,
        byte[] pImage,
        String pKouteiKnrId,
        String pToutyakuYmdTime,
        String pTourokuYmdTime,
        String pRyouikiSakuseiUmu) {

        PutImageResultBean resultBean = new PutImageResultBean();

        String str = "";

        try {
            final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("0:異常系 IWF0001（異常終了しました）タ\n");
            System.out.print("-------------------\n");
            System.out.print("default:正常データ\n");
            System.out.print("★★★入力してください⇒");
            str = br.readLine();
        } catch (final IOException e) {
            e.printStackTrace();
        }
        System.out.println("入力値は：" + str);

        switch(str){
            case "0":
                System.out.println("CASE 0\n");
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NG);
                resultBean.setSyousaiMessageCd("IWF0001");
                resultBean.setSyousaiMessage("異常終了しました");
                break;

            default:
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                resultBean.setImageId("ImageId_1");
        }


        return resultBean;
    }

    public static DropImageResultBean dropImage(String pImageId, String pUserId) {
        DropImageResultBean resultBean = new DropImageResultBean();

        String str = "";

        try {
            final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("0:異常系 IWF0001（異常終了しました）タ\n");
            System.out.print("-------------------\n");
            System.out.print("default:正常データ\n");
            System.out.print("★★★入力してください⇒");
            str = br.readLine();
        } catch (final IOException e) {
            e.printStackTrace();
        }
        System.out.println("入力値は：" + str);

        switch(str){
            case "0":
                System.out.println("CASE 0\n");
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NG);
                resultBean.setSyousaiMessageCd("IWF0001");
                resultBean.setSyousaiMessage("異常終了しました");
                break;

            default:
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
        }


        return resultBean;
    }

    public static CreateProcessIkkatuResultBean createProcessIkkatu(List<CreateProcessIkkatuInBean> pInBeanList) {
        CreateProcessIkkatuResultBean resultBean = new CreateProcessIkkatuResultBean();

        resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

        resultBean.setSyousaiMessageCd("IWFXXXX");

        resultBean.setSyousaiMessage("処理終了");

        return resultBean;
    }


    public static GetSyoruiKengenResultBean getSyoruiKengen(String pRollCd, String[] pJimutetuzukiCd, String pUserId) {
        GetSyoruiKengenResultBean resultBean = new GetSyoruiKengenResultBean();
        List<SyoruiKengenBean> beanList = new ArrayList<SyoruiKengenBean>();
        SyoruiKengenBean bean;

        String str = "";

        try {
            final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("0:NO DATA\n");
            System.out.print("00:異常系 IWF0001（異常終了しました）\n");
            System.out.print("000:警告系 \n");
            System.out.print("-------------------\n");
            System.out.print("default:正常データ\n");
            System.out.print("★★★入力してください⇒");
            str = br.readLine();
        } catch (final IOException e) {
            e.printStackTrace();
        }
        System.out.println("入力値は：" + str);

        switch(str){
            case "0":
                System.out.println("CASE 0\n");
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NODATA);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("対象無し");
                break;
            case "00":
                System.out.println("CASE 00\n");
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NG);
                resultBean.setSyousaiMessageCd("IWF0001");
                resultBean.setSyousaiMessage("異常終了しました");
                break;
            case "000":
                System.out.println("CASE 00\n");
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_WARN);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("警告終了しました");
                break;
            default:
                for (int i = 0; i < pJimutetuzukiCd.length; i++) {
                    bean = new SyoruiKengenBean();
                    bean.setKengenId("KengenId_" + Integer.toString(i));
                    bean.setSyoruiCd("取込書類コード_" + Integer.toString(i));
                    bean.setSyoruiNm("取込書類名_" + Integer.toString(i));
                    bean.setJimutetuzukiCd(pJimutetuzukiCd[i]);
                    if(i%2 == 0){
                        bean.setKengenFlg("0");
                    }else{
                        bean.setKengenFlg("1");
                    }
                    beanList.add(bean);
                }

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

                resultBean.setSyousaiMessageCd("IWFXXXX");

                resultBean.setSyousaiMessage("処理終了");
        }
        resultBean.setSyoruiKengenBeanList(beanList);

        return resultBean;
    }


    public static PutSyoruiKengenResultBean putSyoruiKengen(
        String pRollCd,
        String[] pSyoruiCd) {

        PutSyoruiKengenResultBean resultBean = new PutSyoruiKengenResultBean();

        resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

        resultBean.setSyousaiMessageCd("IWFXXXX");

        resultBean.setSyousaiMessage("処理終了");

        return resultBean;
    }


    public static DropSyoruiKengenResultBean dropSyoruiKengen(
        String pRollCd) {

        DropSyoruiKengenResultBean resultBean = new DropSyoruiKengenResultBean();

        resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

        resultBean.setSyousaiMessageCd("IWFXXXX");

        resultBean.setSyousaiMessage("処理終了");

        return resultBean;
    }


    public static GetCountOfTaskSummaryBySubsystemResultBean getCountOfTaskSummaryBySubsystem(String[] pSubsystemId, String pUserId){
        GetCountOfTaskSummaryBySubsystemResultBean resultBean = new GetCountOfTaskSummaryBySubsystemResultBean();
        List<CountOfTaskSummaryBySubsystemBean> countOfTaskSummaryBeanList = new ArrayList<CountOfTaskSummaryBySubsystemBean>();
        CountOfTaskSummaryBySubsystemBean countOfTaskSummaryBean;

        String str = "";

        try {
            final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("1:1件データ\n");
            System.out.print("11:11件データ\n");
            System.out.print("1001:1001件データ\n");
            System.out.print("00:タスクの本日開始件数・本日残件数・本日完了件数0件あり\n");

            System.out.print("21:新契約2件データ\n");
            System.out.print("22:保全2件データ\n");
            System.out.print("23:保険金2件データ\n");
            System.out.print("24:年金2件データ\n");

            System.out.print("-------------------\n");
            System.out.print("default:100件データ\n");
            System.out.print("★★★入力してください⇒");
            str = br.readLine();
        } catch (final IOException e) {
            e.printStackTrace();
        }
        System.out.println("入力値は：" + str);

        switch(str){

            case "21":
                countOfTaskSummaryBean = new CountOfTaskSummaryBySubsystemBean();
                countOfTaskSummaryBean.setJimutetuzukiCd("A10001010");
                countOfTaskSummaryBean.setJimutetuzukiNm("事務手続名_" + Integer.toString(0));
                countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(1010));
                countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(1000));
                countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(10));
                countOfTaskSummaryBeanList.add(countOfTaskSummaryBean);

                CountOfTaskSummaryBySubsystemBean countOfTaskSummaryBean1 = new CountOfTaskSummaryBySubsystemBean();
                countOfTaskSummaryBean1.setJimutetuzukiCd("A10001011");
                countOfTaskSummaryBean1.setJimutetuzukiNm("事務手続名_" + Integer.toString(1));
                countOfTaskSummaryBean1.setCountOfprocessStartToday(BizNumber.valueOf(2020));
                countOfTaskSummaryBean1.setCountOfprocessLeftToday(BizNumber.valueOf(2000));
                countOfTaskSummaryBean1.setCountOfprocessFinToday(BizNumber.valueOf(20));
                countOfTaskSummaryBeanList.add(countOfTaskSummaryBean1);
                break;
            case "22":
                CountOfTaskSummaryBySubsystemBean countOfTaskSummaryBean2 = new CountOfTaskSummaryBySubsystemBean();
                countOfTaskSummaryBean2.setJimutetuzukiCd("A10001012");
                countOfTaskSummaryBean2.setJimutetuzukiNm("事務手続名_" + Integer.toString(0));
                countOfTaskSummaryBean2.setCountOfprocessStartToday(BizNumber.valueOf(1010));
                countOfTaskSummaryBean2.setCountOfprocessLeftToday(BizNumber.valueOf(1000));
                countOfTaskSummaryBean2.setCountOfprocessFinToday(BizNumber.valueOf(10));
                countOfTaskSummaryBeanList.add(countOfTaskSummaryBean2);

                CountOfTaskSummaryBySubsystemBean countOfTaskSummaryBean3 = new CountOfTaskSummaryBySubsystemBean();
                countOfTaskSummaryBean3.setJimutetuzukiCd("A10001013");
                countOfTaskSummaryBean3.setJimutetuzukiNm("事務手続名_" + Integer.toString(1));
                countOfTaskSummaryBean3.setCountOfprocessStartToday(BizNumber.valueOf(2020));
                countOfTaskSummaryBean3.setCountOfprocessLeftToday(BizNumber.valueOf(2000));
                countOfTaskSummaryBean3.setCountOfprocessFinToday(BizNumber.valueOf(20));
                countOfTaskSummaryBeanList.add(countOfTaskSummaryBean3);

                break;
            case "23":
                CountOfTaskSummaryBySubsystemBean countOfTaskSummaryBean4 = new CountOfTaskSummaryBySubsystemBean();
                countOfTaskSummaryBean4.setJimutetuzukiCd("A10001014");
                countOfTaskSummaryBean4.setJimutetuzukiNm("事務手続名_" + Integer.toString(0));
                countOfTaskSummaryBean4.setCountOfprocessStartToday(BizNumber.valueOf(1010));
                countOfTaskSummaryBean4.setCountOfprocessLeftToday(BizNumber.valueOf(10));
                countOfTaskSummaryBean4.setCountOfprocessFinToday(BizNumber.valueOf(1000));
                countOfTaskSummaryBeanList.add(countOfTaskSummaryBean4);

                CountOfTaskSummaryBySubsystemBean countOfTaskSummaryBean5 = new CountOfTaskSummaryBySubsystemBean();
                countOfTaskSummaryBean5.setJimutetuzukiCd("A10001015");
                countOfTaskSummaryBean5.setJimutetuzukiNm("事務手続名_" + Integer.toString(1));
                countOfTaskSummaryBean5.setCountOfprocessStartToday(BizNumber.valueOf(2020));
                countOfTaskSummaryBean5.setCountOfprocessLeftToday(BizNumber.valueOf(20));
                countOfTaskSummaryBean5.setCountOfprocessFinToday(BizNumber.valueOf(2000));
                countOfTaskSummaryBeanList.add(countOfTaskSummaryBean5);
                break;
            case "24":
                CountOfTaskSummaryBySubsystemBean countOfTaskSummaryBean6 = new CountOfTaskSummaryBySubsystemBean();
                countOfTaskSummaryBean6.setJimutetuzukiCd("A10001016");
                countOfTaskSummaryBean6.setJimutetuzukiNm("事務手続名_" + Integer.toString(0));
                countOfTaskSummaryBean6.setCountOfprocessStartToday(BizNumber.valueOf(1010));
                countOfTaskSummaryBean6.setCountOfprocessLeftToday(BizNumber.valueOf(10));
                countOfTaskSummaryBean6.setCountOfprocessFinToday(BizNumber.valueOf(1000));
                countOfTaskSummaryBeanList.add(countOfTaskSummaryBean6);

                CountOfTaskSummaryBySubsystemBean countOfTaskSummaryBean7 = new CountOfTaskSummaryBySubsystemBean();
                countOfTaskSummaryBean7.setJimutetuzukiCd("A10001017");
                countOfTaskSummaryBean7.setJimutetuzukiNm("事務手続名_" + Integer.toString(1));
                countOfTaskSummaryBean7.setCountOfprocessStartToday(BizNumber.valueOf(2020));
                countOfTaskSummaryBean7.setCountOfprocessLeftToday(BizNumber.valueOf(20));
                countOfTaskSummaryBean7.setCountOfprocessFinToday(BizNumber.valueOf(2000));
                countOfTaskSummaryBeanList.add(countOfTaskSummaryBean7);
                break;

            case "1":
                for (int i = 0; i < Integer.valueOf(str); i++) {
                    countOfTaskSummaryBean = new CountOfTaskSummaryBySubsystemBean();
                    countOfTaskSummaryBean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    countOfTaskSummaryBean.setJimutetuzukiNm("事務手続名_" + Integer.toString(i));
                    countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(i));
                    countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(i+1));
                    countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(i+2));
                    countOfTaskSummaryBeanList.add(countOfTaskSummaryBean);
                }
                break;
            case "11":
                for (int i = 0; i < Integer.valueOf(str); i++) {
                    countOfTaskSummaryBean = new CountOfTaskSummaryBySubsystemBean();
                    countOfTaskSummaryBean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    countOfTaskSummaryBean.setJimutetuzukiNm("事務手続名_" + Integer.toString(i));
                    countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(i));
                    countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(i+1));
                    countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(i+2));
                    countOfTaskSummaryBeanList.add(countOfTaskSummaryBean);
                }
                break;
            case "1001":
                for (int i = 0; i < Integer.valueOf(str); i++) {
                    countOfTaskSummaryBean = new CountOfTaskSummaryBySubsystemBean();
                    countOfTaskSummaryBean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    countOfTaskSummaryBean.setJimutetuzukiNm("事務手続名_" + Integer.toString(i));
                    countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(i));
                    countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(i+1));
                    countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(i+2));
                    countOfTaskSummaryBeanList.add(countOfTaskSummaryBean);
                }
                break;
            case "00":
                for (int i = 0; i <= 99; i++) {
                    if(i ==0){
                        countOfTaskSummaryBean = new CountOfTaskSummaryBySubsystemBean();
                        countOfTaskSummaryBean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                        countOfTaskSummaryBean.setJimutetuzukiNm("事務手続名_" + Integer.toString(i));
                        countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(i));
                        countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(i));
                        countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(i));
                    }else{
                        countOfTaskSummaryBean = new CountOfTaskSummaryBySubsystemBean();
                        countOfTaskSummaryBean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                        countOfTaskSummaryBean.setJimutetuzukiNm("事務手続名_" + Integer.toString(i));
                        countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(i+1));
                        countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(i));
                        countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(i-1));
                    }

                    countOfTaskSummaryBeanList.add(countOfTaskSummaryBean);
                }
                break;
            default:
                for (int i = 0; i <= 99; i++) {
                    countOfTaskSummaryBean = new CountOfTaskSummaryBySubsystemBean();
                    countOfTaskSummaryBean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    countOfTaskSummaryBean.setJimutetuzukiNm("事務手続名_" + Integer.toString(i));
                    countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(i));
                    countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(i+1));
                    countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(i+2));
                    countOfTaskSummaryBeanList.add(countOfTaskSummaryBean);
                }
        }

        resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

        resultBean.setSyousaiMessageCd("IWFXXXX");

        resultBean.setSyousaiMessage("処理終了");

        resultBean.setCountOfTaskSummaryBean(countOfTaskSummaryBeanList);

        return resultBean;
    }

    public static GetCountOfTaskSummaryByJimutetuzukiResultBean getCountOfTaskSummaryByJimutetuzuki(String pSubsystemId, String pJimutetuzukiCd, String pUserId){

        GetCountOfTaskSummaryByJimutetuzukiResultBean resultBean = new GetCountOfTaskSummaryByJimutetuzukiResultBean();
        List<CountOfTaskSummaryByJimutetuzukiBean> countOfTaskSummaryBeanList = new ArrayList<CountOfTaskSummaryByJimutetuzukiBean>();
        CountOfTaskSummaryByJimutetuzukiBean countOfTaskSummaryBean;

        String str = "";

        try {
            final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("1:1件データ\n");
            System.out.print("5:5件データ\n");
            System.out.print("11:11件データ\n");

            System.out.print("21:1件データ\n");
            System.out.print("1001:1001件データ\n");
            System.out.print("00:タスクの本日開始件数・本日残件数・本日完了件数0件あり\n");
            System.out.print("-------------------\n");
            System.out.print("default:100件データ\n");
            System.out.print("★★★入力してください⇒");
            str = br.readLine();
        } catch (final IOException e) {
            e.printStackTrace();
        }
        System.out.println("入力値は：" + str);

        switch(str){
            case "21":
                countOfTaskSummaryBean = new CountOfTaskSummaryByJimutetuzukiBean();
                countOfTaskSummaryBean.setJimutetuzukiCd("A10001010");
                countOfTaskSummaryBean.setTaskNm("TaskNm_" + Integer.toString(0));
                countOfTaskSummaryBean.setDispTaskNm("タスク名_" + Integer.toString(0));
                countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(1010));
                countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(1000));
                countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(10));
                countOfTaskSummaryBeanList.add(countOfTaskSummaryBean);
                break;
            case "1":
                for (int i = 0; i < Integer.valueOf(str); i++) {
                    countOfTaskSummaryBean = new CountOfTaskSummaryByJimutetuzukiBean();
                    countOfTaskSummaryBean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    countOfTaskSummaryBean.setTaskNm("TaskNm_" + Integer.toString(i));
                    countOfTaskSummaryBean.setDispTaskNm("タスク名_" + Integer.toString(i));
                    countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(i));
                    countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(i+1));
                    countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(i+2));
                    countOfTaskSummaryBeanList.add(countOfTaskSummaryBean);
                }
                break;
            case "5":
                for (int i = 0; i < Integer.valueOf(str); i++) {
                    countOfTaskSummaryBean = new CountOfTaskSummaryByJimutetuzukiBean();
                    countOfTaskSummaryBean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    countOfTaskSummaryBean.setTaskNm("TaskNm_" + Integer.toString(i));
                    countOfTaskSummaryBean.setDispTaskNm("タスク名_" + Integer.toString(i));
                    countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(i));
                    countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(i+1));
                    countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(i+2));
                    countOfTaskSummaryBeanList.add(countOfTaskSummaryBean);
                }
                break;
            case "11":
                for (int i = 0; i < Integer.valueOf(str); i++) {
                    countOfTaskSummaryBean = new CountOfTaskSummaryByJimutetuzukiBean();
                    countOfTaskSummaryBean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    countOfTaskSummaryBean.setTaskNm("TaskNm_" + Integer.toString(i));
                    countOfTaskSummaryBean.setDispTaskNm("タスク名_" + Integer.toString(i));
                    countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(i));
                    countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(i+1));
                    countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(i+2));
                    countOfTaskSummaryBeanList.add(countOfTaskSummaryBean);
                }
                break;
            case "1001":
                for (int i = 0; i < Integer.valueOf(str); i++) {
                    countOfTaskSummaryBean = new CountOfTaskSummaryByJimutetuzukiBean();
                    countOfTaskSummaryBean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    countOfTaskSummaryBean.setTaskNm("TaskNm_" + Integer.toString(i));
                    countOfTaskSummaryBean.setDispTaskNm("タスク名_" + Integer.toString(i));
                    countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(i));
                    countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(i+1));
                    countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(i+2));
                    countOfTaskSummaryBeanList.add(countOfTaskSummaryBean);
                }
                break;
            case "00":
                for (int i = 0; i <= 99; i++) {
                    countOfTaskSummaryBean = new CountOfTaskSummaryByJimutetuzukiBean();
                    if(i==0){
                        countOfTaskSummaryBean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                        countOfTaskSummaryBean.setTaskNm("TaskNm_" + Integer.toString(i));
                        countOfTaskSummaryBean.setDispTaskNm("タスク名_" + Integer.toString(i));
                        countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(i));
                        countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(i));
                        countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(i));
                    }else{
                        countOfTaskSummaryBean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                        countOfTaskSummaryBean.setTaskNm("TaskNm_" + Integer.toString(i));
                        countOfTaskSummaryBean.setDispTaskNm("タスク名_" + Integer.toString(i));
                        countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(i));
                        countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(i+1));
                        countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(i-1));
                    }
                    countOfTaskSummaryBeanList.add(countOfTaskSummaryBean);
                }
                break;
            default:
                for (int i = 0; i <= 99; i++) {
                    countOfTaskSummaryBean = new CountOfTaskSummaryByJimutetuzukiBean();
                    countOfTaskSummaryBean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    countOfTaskSummaryBean.setTaskNm("TaskNm_" + Integer.toString(i));
                    countOfTaskSummaryBean.setDispTaskNm("タスク名_" + Integer.toString(i));
                    countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(i));
                    countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(i+1));
                    countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(i+2));
                    countOfTaskSummaryBeanList.add(countOfTaskSummaryBean);
                }
        }

        resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

        resultBean.setSyousaiMessageCd("IWFXXXX");

        resultBean.setSyousaiMessage("処理終了");

        resultBean.setCountOfTaskSummaryBean(countOfTaskSummaryBeanList);

        return resultBean;
    }

    public static GetCountOfTaskSummaryByTaskResultBean getCountOfTaskSummaryByTask(String pJimutetuzukiCd, String pTaskNm,String pUserId){

        GetCountOfTaskSummaryByTaskResultBean resultBean = new GetCountOfTaskSummaryByTaskResultBean();
        List<CountOfTaskSummaryByTaskBean> countOfTaskSummaryBeanList = new ArrayList<CountOfTaskSummaryByTaskBean>();
        CountOfTaskSummaryByTaskBean countOfTaskSummaryBean;

        String str = "";

        try {
            final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("0:共用タスクに0件データ、ユーザ指定ある場合はALL0件データ\n");
            System.out.print("00:共用タスクに0件データ、1つのユーザにALL0件データ（ユーザ1）\n");
            System.out.print("1:1件データ\n");
            System.out.print("5:5件データ\n");
            System.out.print("11:11件データ\n");

            System.out.print("21:1件データ 1010 1000 10\n");
            System.out.print("1001:1001件データ\n");
            System.out.print("-------------------\n");
            System.out.print("default:\n");
            System.out.print("★★★入力してください⇒");
            str = br.readLine();
        } catch (final IOException e) {
            e.printStackTrace();
        }
        System.out.println("入力値は：" + str);

        switch(str){

            case "21":
                if(!Strings.isNullOrEmpty(pUserId)){
                    countOfTaskSummaryBean = new CountOfTaskSummaryByTaskBean();
                    countOfTaskSummaryBean.setUserId("UserId_" + Integer.toString(1));
                    countOfTaskSummaryBean.setDispUserNm("ユーザー名_" + Integer.toString(1));
                    countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(1010));
                    countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(1000));
                    countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(10));
                    countOfTaskSummaryBeanList.add(countOfTaskSummaryBean);
                }else{
                    for (int i = 0; i < Integer.valueOf(1); i++) {
                        countOfTaskSummaryBean = new CountOfTaskSummaryByTaskBean();
                        if (i == 0) {
                            countOfTaskSummaryBean.setUserId("");
                            countOfTaskSummaryBean.setDispUserNm("");
                            countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(i));
                            countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(i+1));
                            countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(i+1));
                        } else {
                            countOfTaskSummaryBean.setUserId("UserId_" + Integer.toString(i));
                            countOfTaskSummaryBean.setDispUserNm("ユーザー名_" + Integer.toString(i));
                            countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(1010));
                            countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(1000));
                            countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(10));
                        }
                        countOfTaskSummaryBeanList.add(countOfTaskSummaryBean);
                    }
                }
                break;

            case "0":
                if(!Strings.isNullOrEmpty(pUserId)){
                    countOfTaskSummaryBean = new CountOfTaskSummaryByTaskBean();
                    countOfTaskSummaryBean.setUserId("UserId_" + Integer.toString(1));
                    countOfTaskSummaryBean.setDispUserNm("ユーザー名_" + Integer.toString(1));
                    countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(0));
                    countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(0));
                    countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(0));
                    countOfTaskSummaryBeanList.add(countOfTaskSummaryBean);
                }else{
                    for (int i = 0; i <= 99; i++) {
                        countOfTaskSummaryBean = new CountOfTaskSummaryByTaskBean();
                        if (i == 0) {
                            countOfTaskSummaryBean.setUserId("");
                            countOfTaskSummaryBean.setDispUserNm("");
                            countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(i));
                            countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(i));
                            countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(i));
                        } else {
                            countOfTaskSummaryBean.setUserId("UserId_" + Integer.toString(i));
                            countOfTaskSummaryBean.setDispUserNm("ユーザー名_" + Integer.toString(i));
                            countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(i-1));
                            countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(i-1));
                            countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(i-1));
                        }
                        countOfTaskSummaryBeanList.add(countOfTaskSummaryBean);
                    }
                }
                break;
            case "00":
                if(!Strings.isNullOrEmpty(pUserId)){
                    countOfTaskSummaryBean = new CountOfTaskSummaryByTaskBean();
                    countOfTaskSummaryBean.setUserId("UserId_" + Integer.toString(1));
                    countOfTaskSummaryBean.setDispUserNm("ユーザー名_" + Integer.toString(1));
                    countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(0));
                    countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(0));
                    countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(0));
                    countOfTaskSummaryBeanList.add(countOfTaskSummaryBean);
                }else{
                    for (int i = 0; i <= 99; i++) {
                        countOfTaskSummaryBean = new CountOfTaskSummaryByTaskBean();
                        if (i == 0) {
                            countOfTaskSummaryBean.setUserId("");
                            countOfTaskSummaryBean.setDispUserNm("");
                            countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(i));
                            countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(i));
                            countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(i));
                        } else if(i == 1){
                            countOfTaskSummaryBean.setUserId("UserId_" + Integer.toString(i));
                            countOfTaskSummaryBean.setDispUserNm("ユーザー名_" + Integer.toString(i));
                            countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(i-1));
                            countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(i-1));
                            countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(i-1));
                        }else {
                            countOfTaskSummaryBean.setUserId("UserId_" + Integer.toString(i));
                            countOfTaskSummaryBean.setDispUserNm("ユーザー名_" + Integer.toString(i));
                            countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(i-2));
                            countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(i-1));
                            countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(i));
                        }
                        countOfTaskSummaryBeanList.add(countOfTaskSummaryBean);
                    }
                }
                break;

            case "1":
                if(!Strings.isNullOrEmpty(pUserId)){
                    countOfTaskSummaryBean = new CountOfTaskSummaryByTaskBean();
                    countOfTaskSummaryBean.setUserId("UserId_" + Integer.toString(1));
                    countOfTaskSummaryBean.setDispUserNm("ユーザー名_" + Integer.toString(1));
                    countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(1));
                    countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(1));
                    countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(1));
                    countOfTaskSummaryBeanList.add(countOfTaskSummaryBean);
                }else{
                    for (int i = 0; i < Integer.valueOf(str); i++) {
                        countOfTaskSummaryBean = new CountOfTaskSummaryByTaskBean();
                        if (i == 0) {
                            countOfTaskSummaryBean.setUserId("");
                            countOfTaskSummaryBean.setDispUserNm("");
                            countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(i));
                            countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(i+1));
                            countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(i+1));
                        } else {
                            countOfTaskSummaryBean.setUserId("UserId_" + Integer.toString(i));
                            countOfTaskSummaryBean.setDispUserNm("ユーザー名_" + Integer.toString(i));
                            countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(i-1));
                            countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(i));
                            countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(i+1));
                        }
                        countOfTaskSummaryBeanList.add(countOfTaskSummaryBean);
                    }
                }
                break;
            case "5":
                if(!Strings.isNullOrEmpty(pUserId)){
                    countOfTaskSummaryBean = new CountOfTaskSummaryByTaskBean();
                    countOfTaskSummaryBean.setUserId("UserId_" + Integer.toString(1));
                    countOfTaskSummaryBean.setDispUserNm("ユーザー名_" + Integer.toString(1));
                    countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(1));
                    countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(1));
                    countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(1));
                    countOfTaskSummaryBeanList.add(countOfTaskSummaryBean);
                }else{
                    for (int i = 0; i < Integer.valueOf(str); i++) {
                        countOfTaskSummaryBean = new CountOfTaskSummaryByTaskBean();
                        if (i == 0) {
                            countOfTaskSummaryBean.setUserId("");
                            countOfTaskSummaryBean.setDispUserNm("");
                            countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(i));
                            countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(i+1));
                            countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(i+1));
                        } else {
                            countOfTaskSummaryBean.setUserId("UserId_" + Integer.toString(i));
                            countOfTaskSummaryBean.setDispUserNm("ユーザー名_" + Integer.toString(i));
                            countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(i-1));
                            countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(i));
                            countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(i+1));
                        }
                        countOfTaskSummaryBeanList.add(countOfTaskSummaryBean);
                    }
                }
                break;
            case "11":
                if(!Strings.isNullOrEmpty(pUserId)){
                    countOfTaskSummaryBean = new CountOfTaskSummaryByTaskBean();
                    countOfTaskSummaryBean.setUserId("UserId_" + Integer.toString(1));
                    countOfTaskSummaryBean.setDispUserNm("ユーザー名_" + Integer.toString(1));
                    countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(1));
                    countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(1));
                    countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(1));
                    countOfTaskSummaryBeanList.add(countOfTaskSummaryBean);
                }else{
                    for (int i = 0; i < Integer.valueOf(str); i++) {
                        countOfTaskSummaryBean = new CountOfTaskSummaryByTaskBean();
                        if (i == 0) {
                            countOfTaskSummaryBean.setUserId("");
                            countOfTaskSummaryBean.setDispUserNm("");
                            countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(i));
                            countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(i+1));
                            countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(i+1));
                        } else {
                            countOfTaskSummaryBean.setUserId("UserId_" + Integer.toString(i));
                            countOfTaskSummaryBean.setDispUserNm("ユーザー名_" + Integer.toString(i));
                            countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(i-1));
                            countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(i));
                            countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(i+1));
                        }
                        countOfTaskSummaryBeanList.add(countOfTaskSummaryBean);
                    }
                }
                break;
            case "1001":
                if(!Strings.isNullOrEmpty(pUserId)){
                    countOfTaskSummaryBean = new CountOfTaskSummaryByTaskBean();
                    countOfTaskSummaryBean.setUserId("UserId_" + Integer.toString(1));
                    countOfTaskSummaryBean.setDispUserNm("ユーザー名_" + Integer.toString(1));
                    countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(1));
                    countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(1));
                    countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(1));
                    countOfTaskSummaryBeanList.add(countOfTaskSummaryBean);
                }else{
                    for (int i = 0; i < Integer.valueOf(str); i++) {
                        countOfTaskSummaryBean = new CountOfTaskSummaryByTaskBean();
                        if (i == 0) {
                            countOfTaskSummaryBean.setUserId("");
                            countOfTaskSummaryBean.setDispUserNm("");
                            countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(i+1));
                            countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(i+1));
                            countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(i+1));
                        } else {
                            countOfTaskSummaryBean.setUserId("UserId_" + Integer.toString(i));
                            countOfTaskSummaryBean.setDispUserNm("ユーザー名_" + Integer.toString(i));
                            countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(i-1));
                            countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(i));
                            countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(i+1));
                        }
                        countOfTaskSummaryBeanList.add(countOfTaskSummaryBean);
                    }
                }
                break;
            default:
                if(!Strings.isNullOrEmpty(pUserId)){
                    countOfTaskSummaryBean = new CountOfTaskSummaryByTaskBean();
                    countOfTaskSummaryBean.setUserId("UserId_" + Integer.toString(1));
                    countOfTaskSummaryBean.setDispUserNm("ユーザー名_" + Integer.toString(1));
                    countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(1));
                    countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(1));
                    countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(1));
                    countOfTaskSummaryBeanList.add(countOfTaskSummaryBean);
                }else{
                    for (int i = 0; i < 99; i++) {
                        countOfTaskSummaryBean = new CountOfTaskSummaryByTaskBean();
                        if (i == 0) {
                            countOfTaskSummaryBean.setUserId("");
                            countOfTaskSummaryBean.setDispUserNm("");
                            countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(i+1));
                            countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(i+1));
                            countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(i+1));
                        } else {
                            countOfTaskSummaryBean.setUserId("UserId_" + Integer.toString(i));
                            countOfTaskSummaryBean.setDispUserNm("ユーザー名_" + Integer.toString(i));
                            countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(i-1));
                            countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(i));
                            countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(i+1));
                        }
                        countOfTaskSummaryBeanList.add(countOfTaskSummaryBean);
                    }
                }
        }


        resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

        resultBean.setSyousaiMessageCd("IWFXXXX");

        resultBean.setSyousaiMessage("処理終了");

        resultBean.setCountOfTaskSummaryBean(countOfTaskSummaryBeanList);

        return resultBean;
    }

    public static MakeCountOfTaskSummaryResultBean makeCountOfTaskSummary(){

        MakeCountOfTaskSummaryResultBean resultBean = new MakeCountOfTaskSummaryResultBean();

        String str = "";
        try {
            final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("入力してください⇒");
            str = br.readLine();
        } catch (final IOException e) {
            e.printStackTrace();
        }
        System.out.println("入力値は：" + str);

        switch(str){
            case "0":
                System.out.println("CASE 0");
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NG);
                resultBean.setSyousaiMessageCd("EDF0013");
                resultBean.setSyousaiMessage("異常終了しました");
                break;
            case "1":
                System.out.println("CASE 1");
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NG);
                resultBean.setSyousaiMessageCd("EDF0013");
                resultBean.setSyousaiMessage("このサービスの最大取得件数を超えました");
                break;
            case "2":
                System.out.println("CASE 2");
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NG);
                resultBean.setSyousaiMessageCd("EDF0013");
                resultBean.setSyousaiMessage("必須入力チェックエラー");
                break;
            case "3":
                System.out.println("CASE 3");
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NG);
                resultBean.setSyousaiMessageCd("EDF0013");
                resultBean.setSyousaiMessage("整数値入力チェックエラー");
                break;
            case "4":
                System.out.println("CASE 4");
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NG);
                resultBean.setSyousaiMessageCd("EDF0013");
                resultBean.setSyousaiMessage("稼働時間外エラーか、認証エラーが発生しました");
                break;
            default:
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                break;

        }


        return resultBean;
    }



    public static PutJimuyouCdResultBean putJimuyouCd(String pJimutetuzukiCd, String pUserId,
        List<PutJimuyouCdBean> pPutJimuyouCdBeanLst){

        PutJimuyouCdResultBean resultBean = new PutJimuyouCdResultBean();

        String str = "";

        try {
            final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("0:異常終了\n");
            System.out.print("-------------------\n");
            System.out.print("default:\n");
            System.out.print("★★★入力してください⇒");
            str = br.readLine();
        } catch (final IOException e) {
            e.printStackTrace();
        }
        System.out.println("入力値は：" + str);

        switch(str){

            case "0":
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NG);
                resultBean.setSyousaiMessageCd("IWF0001");
                resultBean.setSyousaiMessage("異常終了終了");
                break;

            default:
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;

        }


        return resultBean;
    }


    public static GetTorikomiSyoruiMstAndKengenResultBean getTorikomiSyoruiMstAndKengen(String[] pJimutetuzukiCd, String pUserId) {
        GetTorikomiSyoruiMstAndKengenResultBean resultBean = new GetTorikomiSyoruiMstAndKengenResultBean();
        List<TorikomiSyoruiMstAndKengenBean> beanList = new ArrayList<TorikomiSyoruiMstAndKengenBean>();
        TorikomiSyoruiMstAndKengenBean bean;

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssSSS");


        String str = "";

        try {
            final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("0:書類が登録済　取込リンク権限：あり\n");
            System.out.print("1:書類が登録済　取込リンク権限：なし\n");
            System.out.print("2:書類が未登録　取込リンク権限：あり\n");
            System.out.print("3:書類が未登録　取込リンク権限：なし\n");
            System.out.print("4:異常系 IWF0001（異常終了しました）\n");
            System.out.print("-------------------\n");
            System.out.print("default:100件データ\n");
            System.out.print("★★★入力してください⇒");
            str = br.readLine();
        } catch (final IOException e) {
            e.printStackTrace();
        }
        System.out.println("入力値は：" + str);

        switch(str){
            case "0":
                System.out.println("CASE 0\n");
                for (int i = 0; i <= 99; i++) {
                    bean = new TorikomiSyoruiMstAndKengenBean();
                    bean.setSyoruiCd("TorikomiSyoruiCd_" + Integer.toString(i));
                    bean.setSyoruiNm("書類名_" + Integer.toString(i));
                    bean.setSyoruiRyakuNm("書類略称_" + Integer.toString(i));
                    bean.setSyzkSyouBunruiId("SyzkSyouBunruiId_" + Integer.toString(i));
                    bean.setSyzkDaiBunruiId("SyzkDaiBunruiId_" + Integer.toString(i));
                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setZipHozonKbn(Integer.toString(i % 2));
                    bean.setKouteiSeigyoUmuKbn(Integer.toString(i % 2));
                    bean.setTaskNm("TaskNm_" + Integer.toString(i));
                    bean.setKengenUmu(Integer.toString(1));

                    beanList.add(bean);
                }
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;

            case "1":
                System.out.println("CASE 1\n");
                for (int i = 0; i <= 99; i++) {
                    bean = new TorikomiSyoruiMstAndKengenBean();
                    bean.setSyoruiCd("TorikomiSyoruiCd_" + Integer.toString(i));
                    bean.setSyoruiNm("書類名_" + Integer.toString(i));
                    bean.setSyoruiRyakuNm("書類略称_" + Integer.toString(i));
                    bean.setSyzkSyouBunruiId("SyzkSyouBunruiId_" + Integer.toString(i));
                    bean.setSyzkDaiBunruiId("SyzkDaiBunruiId_" + Integer.toString(i));
                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setZipHozonKbn(Integer.toString(i % 2));
                    bean.setKouteiSeigyoUmuKbn(Integer.toString(i % 2));
                    bean.setTaskNm("TaskNm_" + Integer.toString(i));
                    bean.setKengenUmu(Integer.toString(0));

                    beanList.add(bean);
                }
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;

            case "2":
                System.out.println("CASE 2\n");
                for (int i = 0; i <= 99; i++) {
                    bean = new TorikomiSyoruiMstAndKengenBean();
                    bean.setSyoruiCd("TorikomiSyoruiCd_d" + Integer.toString(i));
                    bean.setSyoruiNm("書類名_" + Integer.toString(i));
                    bean.setSyoruiRyakuNm("書類略称_" + Integer.toString(i));
                    bean.setSyzkSyouBunruiId("SyzkSyouBunruiId_" + Integer.toString(i));
                    bean.setSyzkDaiBunruiId("SyzkDaiBunruiId_" + Integer.toString(i));
                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setZipHozonKbn(Integer.toString(i % 2));
                    bean.setKouteiSeigyoUmuKbn(Integer.toString(i % 2));
                    bean.setTaskNm("TaskNm_" + Integer.toString(i));
                    bean.setKengenUmu(Integer.toString(1));

                    beanList.add(bean);
                }
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;

            case "3":
                System.out.println("CASE 3\n");
                for (int i = 0; i <= 99; i++) {
                    bean = new TorikomiSyoruiMstAndKengenBean();
                    bean.setSyoruiCd("TorikomiSyoruiCd_d" + Integer.toString(i));
                    bean.setSyoruiNm("書類名_" + Integer.toString(i));
                    bean.setSyoruiRyakuNm("書類略称_" + Integer.toString(i));
                    bean.setSyzkSyouBunruiId("SyzkSyouBunruiId_" + Integer.toString(i));
                    bean.setSyzkDaiBunruiId("SyzkDaiBunruiId_" + Integer.toString(i));
                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setZipHozonKbn(Integer.toString(i % 2));
                    bean.setKouteiSeigyoUmuKbn(Integer.toString(i % 2));
                    bean.setTaskNm("TaskNm_" + Integer.toString(i));
                    bean.setKengenUmu(Integer.toString(0));

                    beanList.add(bean);
                }
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;

            case "4":
                System.out.print("CASE 7\n");
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NG);
                resultBean.setSyousaiMessageCd("IWF0001");
                resultBean.setSyousaiMessage("異常終了しました");
                break;

            default:
                System.out.println("CASE 3\n");
                for (int i = 0; i <= 99; i++) {
                    bean = new TorikomiSyoruiMstAndKengenBean();
                    bean.setSyoruiCd("TorikomiSyoruiCd_" + Integer.toString(i));
                    bean.setSyoruiNm("書類名_" + Integer.toString(i));
                    bean.setSyoruiRyakuNm("書類略称_" + Integer.toString(i));
                    bean.setSyzkSyouBunruiId("SyzkSyouBunruiId_" + Integer.toString(i));
                    bean.setSyzkDaiBunruiId("SyzkDaiBunruiId_" + Integer.toString(i));
                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setZipHozonKbn(Integer.toString(i % 2));
                    bean.setKouteiSeigyoUmuKbn(Integer.toString(i % 2));
                    bean.setTaskNm("TaskNm_" + Integer.toString(i));
                    bean.setKengenUmu(Integer.toString(i%2));

                    beanList.add(bean);
                }
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;
        }


        resultBean.setTorikomiSyoruiMstAndKengenBeanList(beanList);

        return resultBean;
    }


    public static PutExpectedArrivalNoticeResultBean putExpectedArrivalNotice(String pKouteiKnrId, String pQrCd, String pSyoruiCd, String pJimutetuzukiCd, String pSubSystemId) {

        PutExpectedArrivalNoticeResultBean resultBean = new PutExpectedArrivalNoticeResultBean();

        resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

        resultBean.setSyousaiMessageCd("IWFXXXX");

        resultBean.setSyousaiMessage("処理終了");

        return resultBean;
    }

    public static GetExpectedArrivalNoticeResultBean getExpectedArrivalNotice(String[] pQrCds) {
        GetExpectedArrivalNoticeResultBean resultBean = new GetExpectedArrivalNoticeResultBean();
        List<ExpectedArrivalNoticeBean> beanList = new ArrayList<ExpectedArrivalNoticeBean>();
        ExpectedArrivalNoticeBean bean;

        String str = "";
        try {
            final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("0 :1件  正常\n");
            System.out.print("1 :10件  正常\n");
            System.out.print("2 :異常\n");
            System.out.print("d :defalt 10件\n");

            System.out.print("入力してください⇒");
            str = br.readLine();
        } catch (final IOException e) {
            e.printStackTrace();
        }
        System.out.println("入力値は：" + str);

        switch(str){

            case "0":
                System.out.println("CASE 0 :1件  正常\n");
                for (int i = 0; i <= 0; i++) {
                    bean = new ExpectedArrivalNoticeBean();
                    bean.setQrCd("QrCode_" + Integer.toString(i));
                    bean.setKouteiKnrId("KouteiKnrId_" + Integer.toString(i));
                    bean.setSyoruiCd("TorikomiSyoruiCd_" + Integer.toString(i));
                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setSubSystemId("SubSystemId_" + Integer.toString(i));

                    beanList.add(bean);
                }
                resultBean.setExpectedArrivalNoticeBeanList(beanList);
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;

            case "1":
                System.out.println("CASE 1 :10件  正常\n");
                for (int i = 0; i <= 9; i++) {
                    bean = new ExpectedArrivalNoticeBean();
                    bean.setQrCd("QrCode_" + Integer.toString(i));
                    bean.setKouteiKnrId("KouteiKnrId_" + Integer.toString(i));
                    bean.setSyoruiCd("TorikomiSyoruiCd_" + Integer.toString(i));
                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setSubSystemId("SubSystemId_" + Integer.toString(i));

                    beanList.add(bean);
                }
                resultBean.setExpectedArrivalNoticeBeanList(beanList);
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;

            case "2":
                System.out.println("CASE 2 :異常\n");
                for (int i = 0; i <= 0; i++) {
                    bean = new ExpectedArrivalNoticeBean();
                    bean.setQrCd("QrCode_" + Integer.toString(i));
                    bean.setKouteiKnrId("KouteiKnrId_" + Integer.toString(i));
                    bean.setSyoruiCd("TorikomiSyoruiCd_" + Integer.toString(i));
                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setSubSystemId("SubSystemId_" + Integer.toString(i));

                    beanList.add(bean);
                }
                resultBean.setExpectedArrivalNoticeBeanList(beanList);
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NG);
                resultBean.setSyousaiMessageCd("IWF0001");
                resultBean.setSyousaiMessage("異常終了");
                break;

            default:
                System.out.println("CASE default 10件\n");
                for (int i = 0; i <= 9; i++) {
                    bean = new ExpectedArrivalNoticeBean();
                    bean.setQrCd("QrCode_" + Integer.toString(i));
                    bean.setKouteiKnrId("KouteiKnrId_" + Integer.toString(i));
                    bean.setSyoruiCd("TorikomiSyoruiCd_" + Integer.toString(i));
                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setSubSystemId("SubSystemId_" + Integer.toString(i));

                    beanList.add(bean);
                }
                resultBean.setExpectedArrivalNoticeBeanList(beanList);
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;
        }

        return resultBean;

    }


    public static PutArrivalImageResultBean putArrivalImage(String pQrCd, byte[] pImage, String pKouteikanriId) {

        PutArrivalImageResultBean resultBean = new PutArrivalImageResultBean();

        String str = "";
        try {
            final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("0 :1件  正常\n");
            System.out.print("1 :異常\n");
            System.out.print("d :正常\n");

            System.out.print("入力してください⇒");
            str = br.readLine();
        } catch (final IOException e) {
            e.printStackTrace();
        }
        System.out.println("入力値は：" + str);

        switch(str){

            case "0":
                System.out.println("CASE 0 :正常\n");
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;

            case "1":
                System.out.println("CASE 1 :異常\n");
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NG);
                resultBean.setSyousaiMessageCd("IWF0001");
                resultBean.setSyousaiMessage("異常終了");
                break;

            default:
                System.out.println("CASE default 正常\n");
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;
        }


        return resultBean;
    }

    public static GetTorikomiSyoruiMstBySyoruiCdResultBean getTorikomiSyoruiMstBySyoruiCd(String pSyoruiCd) {
        GetTorikomiSyoruiMstBySyoruiCdResultBean resultBean = new GetTorikomiSyoruiMstBySyoruiCdResultBean();
        List<TorikomiSyoruiBean> beanList = new ArrayList<TorikomiSyoruiBean>();
        TorikomiSyoruiBean bean;

        for (int i = 0; i <= 0; i++) {
            bean = new TorikomiSyoruiBean();

            bean.setTorikomisyoruicd("TorikomiSyoruiCd_" + Integer.toString(i));
            bean.setTorikomisyoruinm("取込書類名_" + Integer.toString(i));
            bean.setTorikomisyoruiryaku("取込書類略称_" + Integer.toString(i));
            bean.setSyzksyoubunruiid("SyouBunruiId_" + Integer.toString(i));
            bean.setSyzkdaibunruiid("DaiBunruiId_" + Integer.toString(i));
            bean.setFlowid("FlowId_" + Integer.toString(i));
            bean.setZiphozonkbn("ZipKbn_" + Integer.toString(i));
            bean.setKouteiseigyoumukbn("KouteiKbn_" + Integer.toString(i));
            bean.setNodeid("NodeId_" + Integer.toString(i));

            beanList.add(bean);
        }
        resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

        resultBean.setSyousaiMessageCd("IWFXXXX");

        resultBean.setSyousaiMessage("処理終了");

        resultBean.setTorikomiSyoruiMstBeanList(beanList);

        return resultBean;
    }

    public static GetScanTorikomiSyoruiMstResultBean getScanTorikomiSyoruiMst(String pJimutetuzukiCd) {
        GetScanTorikomiSyoruiMstResultBean resultBean = new GetScanTorikomiSyoruiMstResultBean();
        List<TorikomiSyoruiMstBean> beanList = new ArrayList<TorikomiSyoruiMstBean>();
        TorikomiSyoruiMstBean bean;

        String str = "";

        try {
            final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("0:異常系 IWF0001（異常終了しました）\n");
            System.out.print("1:正常系 書類名データの設定\n");
            System.out.print("-------------------\n");
            System.out.print("default:6件データ\n");
            System.out.print("★★★入力してください⇒");
            str = br.readLine();
        } catch (final IOException e) {
            e.printStackTrace();
        }
        System.out.println("入力値は：" + str);

        switch(str) {
            case "0":
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NG);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("異常終了しました。");
                break;

            case "1":
                System.out.println("case1 16件\n");
                for (int i = 0; i <= 0; i++) {
                    bean = new TorikomiSyoruiMstBean();
                    bean.setSyoruiCd("sk001");
                    bean.setSyoruiNm("①申込書");
                    bean.setSyoruiRyakuNm("書類略称_①申込書");
                    bean.setSyzkSyouBunruiId("SyzkSyouBunruiId_" + Integer.toString(i));
                    bean.setSyzkDaiBunruiId("SyzkDaiBunruiId_" + Integer.toString(i));
                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(1));
                    bean.setZipHozonKbn(Integer.toString(i % 2));
                    bean.setKouteiSeigyoUmuKbn(Integer.toString(i % 2));
                    bean.setTaskNm("TaskNm_" + Integer.toString(i));

                    beanList.add(bean);
                }

                for (int i = 0; i <= 0; i++) {
                    bean = new TorikomiSyoruiMstBean();
                    bean.setSyoruiCd("sk002");
                    bean.setSyoruiNm("②告知書");
                    bean.setSyoruiRyakuNm("書類略称_②告知書");
                    bean.setSyzkSyouBunruiId("SyzkSyouBunruiId_" + Integer.toString(i));
                    bean.setSyzkDaiBunruiId("SyzkDaiBunruiId_" + Integer.toString(i));
                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(2));
                    bean.setZipHozonKbn(Integer.toString(i % 2));
                    bean.setKouteiSeigyoUmuKbn(Integer.toString(i % 2));
                    bean.setTaskNm("TaskNm_" + Integer.toString(i));

                    beanList.add(bean);
                }
                for (int i = 0; i <= 0; i++) {
                    bean = new TorikomiSyoruiMstBean();
                    bean.setSyoruiCd("sk003");
                    bean.setSyoruiNm("③意向確認書");
                    bean.setSyoruiRyakuNm("書類略称_③意向確認書");
                    bean.setSyzkSyouBunruiId("SyzkSyouBunruiId_" + Integer.toString(i));
                    bean.setSyzkDaiBunruiId("SyzkDaiBunruiId_" + Integer.toString(i));
                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(3));
                    bean.setZipHozonKbn(Integer.toString(i % 2));
                    bean.setKouteiSeigyoUmuKbn(Integer.toString(i % 2));
                    bean.setTaskNm("TaskNm_" + Integer.toString(i));

                    beanList.add(bean);
                }
                for (int i = 0; i <= 0; i++) {
                    bean = new TorikomiSyoruiMstBean();
                    bean.setSyoruiCd("sk004");
                    bean.setSyoruiNm("④意向確認書（訂正用）");
                    bean.setSyoruiRyakuNm("書類略称_④意向確認書（訂正用）");
                    bean.setSyzkSyouBunruiId("SyzkSyouBunruiId_" + Integer.toString(i));
                    bean.setSyzkDaiBunruiId("SyzkDaiBunruiId_" + Integer.toString(i));
                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(4));
                    bean.setZipHozonKbn(Integer.toString(i % 2));
                    bean.setKouteiSeigyoUmuKbn(Integer.toString(i % 2));
                    bean.setTaskNm("TaskNm_" + Integer.toString(i));

                    beanList.add(bean);
                }
                for (int i = 0; i <= 0; i++) {
                    bean = new TorikomiSyoruiMstBean();
                    bean.setSyoruiCd("sk005");
                    bean.setSyoruiNm("⑤受取人複数指定書");
                    bean.setSyoruiRyakuNm("書類略称_⑤受取人複数指定書");
                    bean.setSyzkSyouBunruiId("SyzkSyouBunruiId_" + Integer.toString(i));
                    bean.setSyzkDaiBunruiId("SyzkDaiBunruiId_" + Integer.toString(i));
                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(5));
                    bean.setZipHozonKbn(Integer.toString(i % 2));
                    bean.setKouteiSeigyoUmuKbn(Integer.toString(i % 2));
                    bean.setTaskNm("TaskNm_" + Integer.toString(i));

                    beanList.add(bean);
                }
                for (int i = 0; i <= 0; i++) {
                    bean = new TorikomiSyoruiMstBean();
                    bean.setSyoruiCd("sk006");
                    bean.setSyoruiNm("⑥受取人事前照会票");
                    bean.setSyoruiRyakuNm("書類略称_⑥受取人事前照会票");
                    bean.setSyzkSyouBunruiId("SyzkSyouBunruiId_" + Integer.toString(i));
                    bean.setSyzkDaiBunruiId("SyzkDaiBunruiId_" + Integer.toString(i));
                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(6));
                    bean.setZipHozonKbn(Integer.toString(i % 2));
                    bean.setKouteiSeigyoUmuKbn(Integer.toString(i % 2));
                    bean.setTaskNm("TaskNm_" + Integer.toString(i));

                    beanList.add(bean);
                }
                for (int i = 0; i <= 0; i++) {
                    bean = new TorikomiSyoruiMstBean();
                    bean.setSyoruiCd("sk007");
                    bean.setSyoruiNm("⑦第三者受取報告書");
                    bean.setSyoruiRyakuNm("書類略称_⑦第三者受取報告書");
                    bean.setSyzkSyouBunruiId("SyzkSyouBunruiId_" + Integer.toString(i));
                    bean.setSyzkDaiBunruiId("SyzkDaiBunruiId_" + Integer.toString(i));
                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(7));
                    bean.setZipHozonKbn(Integer.toString(i % 2));
                    bean.setKouteiSeigyoUmuKbn(Integer.toString(i % 2));
                    bean.setTaskNm("TaskNm_" + Integer.toString(i));

                    beanList.add(bean);
                }
                for (int i = 0; i <= 0; i++) {
                    bean = new TorikomiSyoruiMstBean();
                    bean.setSyoruiCd("sk008");
                    bean.setSyoruiNm("⑧FATCA確認書");
                    bean.setSyoruiRyakuNm("書類略称_⑧FATCA確認書");
                    bean.setSyzkSyouBunruiId("SyzkSyouBunruiId_" + Integer.toString(i));
                    bean.setSyzkDaiBunruiId("SyzkDaiBunruiId_" + Integer.toString(i));
                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(8));
                    bean.setZipHozonKbn(Integer.toString(i % 2));
                    bean.setKouteiSeigyoUmuKbn(Integer.toString(i % 2));
                    bean.setTaskNm("TaskNm_" + Integer.toString(i));

                    beanList.add(bean);
                }
                for (int i = 0; i <= 0; i++) {
                    bean = new TorikomiSyoruiMstBean();
                    bean.setSyoruiCd("sk009");
                    bean.setSyoruiNm("⑨取扱報告書");
                    bean.setSyoruiRyakuNm("書類略称_⑨取扱報告書");
                    bean.setSyzkSyouBunruiId("SyzkSyouBunruiId_" + Integer.toString(i));
                    bean.setSyzkDaiBunruiId("SyzkDaiBunruiId_" + Integer.toString(i));
                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(9));
                    bean.setZipHozonKbn(Integer.toString(i % 2));
                    bean.setKouteiSeigyoUmuKbn(Integer.toString(i % 2));
                    bean.setTaskNm("TaskNm_" + Integer.toString(i));

                    beanList.add(bean);
                }
                for (int i = 0; i <= 0; i++) {
                    bean = new TorikomiSyoruiMstBean();
                    bean.setSyoruiCd("sk010");
                    bean.setSyoruiNm("⑩その他付属書類");
                    bean.setSyoruiRyakuNm("書類略称_⑩その他付属書類");
                    bean.setSyzkSyouBunruiId("SyzkSyouBunruiId_" + Integer.toString(i));
                    bean.setSyzkDaiBunruiId("SyzkDaiBunruiId_" + Integer.toString(i));
                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(10));
                    bean.setZipHozonKbn(Integer.toString(i % 2));
                    bean.setKouteiSeigyoUmuKbn(Integer.toString(i % 2));
                    bean.setTaskNm("TaskNm_" + Integer.toString(i));

                    beanList.add(bean);
                }
                for (int i = 0; i <= 0; i++) {
                    bean = new TorikomiSyoruiMstBean();
                    bean.setSyoruiCd("sk011");
                    bean.setSyoruiNm("⑪変更訂正書");
                    bean.setSyoruiRyakuNm("書類略称_⑪変更訂正書");
                    bean.setSyzkSyouBunruiId("SyzkSyouBunruiId_" + Integer.toString(i));
                    bean.setSyzkDaiBunruiId("SyzkDaiBunruiId_" + Integer.toString(i));
                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(11));
                    bean.setZipHozonKbn(Integer.toString(i % 2));
                    bean.setKouteiSeigyoUmuKbn(Integer.toString(i % 2));
                    bean.setTaskNm("TaskNm_" + Integer.toString(i));

                    beanList.add(bean);
                }
                for (int i = 0; i <= 0; i++) {
                    bean = new TorikomiSyoruiMstBean();
                    bean.setSyoruiCd("sk012");
                    bean.setSyoruiNm("⑫不備通知書");
                    bean.setSyoruiRyakuNm("書類略称_⑫不備通知書");
                    bean.setSyzkSyouBunruiId("SyzkSyouBunruiId_" + Integer.toString(i));
                    bean.setSyzkDaiBunruiId("SyzkDaiBunruiId_" + Integer.toString(i));
                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(12));
                    bean.setZipHozonKbn(Integer.toString(i % 2));
                    bean.setKouteiSeigyoUmuKbn(Integer.toString(i % 2));
                    bean.setTaskNm("TaskNm_" + Integer.toString(i));

                    beanList.add(bean);
                }
                for (int i = 0; i <= 0; i++) {
                    bean = new TorikomiSyoruiMstBean();
                    bean.setSyoruiCd("sk013");
                    bean.setSyoruiNm("⑬契約確認依頼書");
                    bean.setSyoruiRyakuNm("書類略称_⑬契約確認依頼書");
                    bean.setSyzkSyouBunruiId("SyzkSyouBunruiId_" + Integer.toString(i));
                    bean.setSyzkDaiBunruiId("SyzkDaiBunruiId_" + Integer.toString(i));
                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(13));
                    bean.setZipHozonKbn(Integer.toString(i % 2));
                    bean.setKouteiSeigyoUmuKbn(Integer.toString(i % 2));
                    bean.setTaskNm("TaskNm_" + Integer.toString(i));

                    beanList.add(bean);
                }

                for (int i = 0; i <= 0; i++) {
                    bean = new TorikomiSyoruiMstBean();
                    bean.setSyoruiCd("sk014");
                    bean.setSyoruiNm("⑭契約確認回答書");
                    bean.setSyoruiRyakuNm("書類略称_⑭契約確認回答書");
                    bean.setSyzkSyouBunruiId("SyzkSyouBunruiId_" + Integer.toString(i));
                    bean.setSyzkDaiBunruiId("SyzkDaiBunruiId_" + Integer.toString(i));
                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(14));
                    bean.setZipHozonKbn(Integer.toString(i % 2));
                    bean.setKouteiSeigyoUmuKbn(Integer.toString(i % 2));
                    bean.setTaskNm("TaskNm_" + Integer.toString(i));

                    beanList.add(bean);
                }
                for (int i = 0; i <= 0; i++) {
                    bean = new TorikomiSyoruiMstBean();
                    bean.setSyoruiCd("sk015");
                    bean.setSyoruiNm("⑮取消請求書");
                    bean.setSyoruiRyakuNm("書類略称_⑮取消請求書");
                    bean.setSyzkSyouBunruiId("SyzkSyouBunruiId_" + Integer.toString(i));
                    bean.setSyzkDaiBunruiId("SyzkDaiBunruiId_" + Integer.toString(i));
                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(15));
                    bean.setZipHozonKbn(Integer.toString(i % 2));
                    bean.setKouteiSeigyoUmuKbn(Integer.toString(i % 2));
                    bean.setTaskNm("TaskNm_" + Integer.toString(i));

                    beanList.add(bean);
                }
                for (int i = 0; i <= 0; i++) {
                    bean = new TorikomiSyoruiMstBean();
                    bean.setSyoruiCd("sk016");
                    bean.setSyoruiNm("⑯返金依頼書");
                    bean.setSyoruiRyakuNm("書類略称_⑯返金依頼書");
                    bean.setSyzkSyouBunruiId("SyzkSyouBunruiId_" + Integer.toString(i));
                    bean.setSyzkDaiBunruiId("SyzkDaiBunruiId_" + Integer.toString(i));
                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(16));
                    bean.setZipHozonKbn(Integer.toString(i % 2));
                    bean.setKouteiSeigyoUmuKbn(Integer.toString(i % 2));
                    bean.setTaskNm("TaskNm_" + Integer.toString(i));

                    beanList.add(bean);
                }
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;
            default:
                System.out.println("DEFAULT 6件\n");
                for (int i = 0; i <= 16; i++) {
                    bean = new TorikomiSyoruiMstBean();
                    bean.setSyoruiCd("wf00" + Integer.toString(i));
                    bean.setSyoruiNm("書類名_wf00" + Integer.toString(i));
                    bean.setSyoruiRyakuNm("書類略称_" + Integer.toString(i));
                    bean.setSyzkSyouBunruiId("SyzkSyouBunruiId_" + Integer.toString(i));
                    bean.setSyzkDaiBunruiId("SyzkDaiBunruiId_" + Integer.toString(i));
                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setZipHozonKbn(Integer.toString(i % 2));
                    bean.setKouteiSeigyoUmuKbn(Integer.toString(i % 2));
                    bean.setTaskNm("TaskNm_" + Integer.toString(i));

                    beanList.add(bean);
                }
                beanList.get(13).setJimutetuzukiCd("sk013");
                for (int i = 0; i <= 2; i++) {
                    bean = new TorikomiSyoruiMstBean();
                    bean.setSyoruiCd("sk00" + Integer.toString(i));
                    bean.setSyoruiNm("書類名_sk00" + Integer.toString(i));
                    bean.setSyoruiRyakuNm("書類略称_" + Integer.toString(i));
                    bean.setSyzkSyouBunruiId("SyzkSyouBunruiId_" + Integer.toString(i));
                    bean.setSyzkDaiBunruiId("SyzkDaiBunruiId_" + Integer.toString(i));
                    bean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    bean.setZipHozonKbn(Integer.toString(i % 2));
                    bean.setKouteiSeigyoUmuKbn(Integer.toString(i % 2));
                    bean.setTaskNm("TaskNm_" + Integer.toString(i));

                    beanList.add(bean);
                }

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                resultBean.setSyousaiMessageCd("IWFXXXX");
                resultBean.setSyousaiMessage("処理終了");
                break;
        }

        resultBean.setTorikomiSyoruiMstBeanList(beanList);

        return resultBean;
    }

    public static GetLockInfoResultBean getLockInfo(String pKouteiKnrId) {

        GetLockInfoResultBean resultBean = SWAKInjector.getInstance(GetLockInfoResultBean.class);


        return resultBean;
    }

    public static MakeCountOfKakoJissekiTaskSummaryResultBean makeCountOfKakoJissekiTaskSummary(BizDate pSyoriYmd){

        MakeCountOfKakoJissekiTaskSummaryResultBean resultBean = new MakeCountOfKakoJissekiTaskSummaryResultBean();

        String str = "";
        try {
            final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("入力してください⇒");
            str = br.readLine();
        } catch (final IOException e) {
            e.printStackTrace();
        }
        System.out.println("入力値は：" + str);

        switch(str){
            case "0":
                System.out.println("CASE 0");
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NG);
                resultBean.setSyousaiMessageCd("EDF0013");
                resultBean.setSyousaiMessage("異常終了しました");
                resultBean.setErrHasseiSyoriNm("TaskSummaryByActor");
                break;
            case "1":
                System.out.println("CASE 1");
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NG);
                resultBean.setSyousaiMessageCd("EBF0130");
                resultBean.setSyousaiMessage("キーが重複している為、登録されません。（処理件数保管（事務手続別）テーブル）");
                resultBean.setErrHasseiSyoriNm("DT_SyoriKensuuHokanJimu");
                break;
            case "2":
                System.out.println("CASE 2");
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NG);
                resultBean.setSyousaiMessageCd("EBF0130");
                resultBean.setSyousaiMessage("キーが重複している為、登録されません。（処理件数保管（タスク別）テーブル）");
                resultBean.setErrHasseiSyoriNm("DT_SyoriKensuuHokanTask");
                break;
            default:
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
                break;

        }

        return resultBean;
    }

    public static GetCountOfTaskSummaryBySubsystemResultBean getCountOfKakoJissekiTaskSummaryBySubsystem(
        String[] pSubsystemId, BizDate pSyoriYmd, String pUserId) {
        GetCountOfTaskSummaryBySubsystemResultBean resultBean = new GetCountOfTaskSummaryBySubsystemResultBean();
        List<CountOfTaskSummaryBySubsystemBean> countOfTaskSummaryBeanList = new ArrayList<CountOfTaskSummaryBySubsystemBean>();
        CountOfTaskSummaryBySubsystemBean countOfTaskSummaryBean;

        String str = "";

        try {
            final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("1:1件データ\n");
            System.out.print("11:11件データ\n");
            System.out.print("1001:1001件データ\n");
            System.out.print("00:タスクの本日開始件数・本日残件数・本日完了件数0件あり\n");

            System.out.print("21:新契約2件データ\n");
            System.out.print("22:保全2件データ\n");
            System.out.print("23:保険金2件データ\n");
            System.out.print("24:年金2件データ\n");

            System.out.print("-------------------\n");
            System.out.print("default:100件データ\n");
            System.out.print("★★★入力してください⇒");
            str = br.readLine();
        } catch (final IOException e) {
            e.printStackTrace();
        }
        System.out.println("入力値は：" + str);

        switch(str){

            case "21":
                countOfTaskSummaryBean = new CountOfTaskSummaryBySubsystemBean();
                countOfTaskSummaryBean.setJimutetuzukiCd("A10001010");
                countOfTaskSummaryBean.setJimutetuzukiNm("事務手続名_" + Integer.toString(0));
                countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(1010));
                countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(1000));
                countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(10));
                countOfTaskSummaryBeanList.add(countOfTaskSummaryBean);

                CountOfTaskSummaryBySubsystemBean countOfTaskSummaryBean1 = new CountOfTaskSummaryBySubsystemBean();
                countOfTaskSummaryBean1.setJimutetuzukiCd("A10001011");
                countOfTaskSummaryBean1.setJimutetuzukiNm("事務手続名_" + Integer.toString(1));
                countOfTaskSummaryBean1.setCountOfprocessStartToday(BizNumber.valueOf(2020));
                countOfTaskSummaryBean1.setCountOfprocessLeftToday(BizNumber.valueOf(2000));
                countOfTaskSummaryBean1.setCountOfprocessFinToday(BizNumber.valueOf(20));
                countOfTaskSummaryBeanList.add(countOfTaskSummaryBean1);
                break;
            case "22":
                CountOfTaskSummaryBySubsystemBean countOfTaskSummaryBean2 = new CountOfTaskSummaryBySubsystemBean();
                countOfTaskSummaryBean2.setJimutetuzukiCd("A10001012");
                countOfTaskSummaryBean2.setJimutetuzukiNm("事務手続名_" + Integer.toString(0));
                countOfTaskSummaryBean2.setCountOfprocessStartToday(BizNumber.valueOf(1010));
                countOfTaskSummaryBean2.setCountOfprocessLeftToday(BizNumber.valueOf(1000));
                countOfTaskSummaryBean2.setCountOfprocessFinToday(BizNumber.valueOf(10));
                countOfTaskSummaryBeanList.add(countOfTaskSummaryBean2);

                CountOfTaskSummaryBySubsystemBean countOfTaskSummaryBean3 = new CountOfTaskSummaryBySubsystemBean();
                countOfTaskSummaryBean3.setJimutetuzukiCd("A10001013");
                countOfTaskSummaryBean3.setJimutetuzukiNm("事務手続名_" + Integer.toString(1));
                countOfTaskSummaryBean3.setCountOfprocessStartToday(BizNumber.valueOf(2020));
                countOfTaskSummaryBean3.setCountOfprocessLeftToday(BizNumber.valueOf(2000));
                countOfTaskSummaryBean3.setCountOfprocessFinToday(BizNumber.valueOf(20));
                countOfTaskSummaryBeanList.add(countOfTaskSummaryBean3);

                break;
            case "23":
                CountOfTaskSummaryBySubsystemBean countOfTaskSummaryBean4 = new CountOfTaskSummaryBySubsystemBean();
                countOfTaskSummaryBean4.setJimutetuzukiCd("A10001014");
                countOfTaskSummaryBean4.setJimutetuzukiNm("事務手続名_" + Integer.toString(0));
                countOfTaskSummaryBean4.setCountOfprocessStartToday(BizNumber.valueOf(1010));
                countOfTaskSummaryBean4.setCountOfprocessLeftToday(BizNumber.valueOf(10));
                countOfTaskSummaryBean4.setCountOfprocessFinToday(BizNumber.valueOf(1000));
                countOfTaskSummaryBeanList.add(countOfTaskSummaryBean4);

                CountOfTaskSummaryBySubsystemBean countOfTaskSummaryBean5 = new CountOfTaskSummaryBySubsystemBean();
                countOfTaskSummaryBean5.setJimutetuzukiCd("A10001015");
                countOfTaskSummaryBean5.setJimutetuzukiNm("事務手続名_" + Integer.toString(1));
                countOfTaskSummaryBean5.setCountOfprocessStartToday(BizNumber.valueOf(2020));
                countOfTaskSummaryBean5.setCountOfprocessLeftToday(BizNumber.valueOf(20));
                countOfTaskSummaryBean5.setCountOfprocessFinToday(BizNumber.valueOf(2000));
                countOfTaskSummaryBeanList.add(countOfTaskSummaryBean5);
                break;
            case "24":
                CountOfTaskSummaryBySubsystemBean countOfTaskSummaryBean6 = new CountOfTaskSummaryBySubsystemBean();
                countOfTaskSummaryBean6.setJimutetuzukiCd("A10001016");
                countOfTaskSummaryBean6.setJimutetuzukiNm("事務手続名_" + Integer.toString(0));
                countOfTaskSummaryBean6.setCountOfprocessStartToday(BizNumber.valueOf(1010));
                countOfTaskSummaryBean6.setCountOfprocessLeftToday(BizNumber.valueOf(10));
                countOfTaskSummaryBean6.setCountOfprocessFinToday(BizNumber.valueOf(1000));
                countOfTaskSummaryBeanList.add(countOfTaskSummaryBean6);

                CountOfTaskSummaryBySubsystemBean countOfTaskSummaryBean7 = new CountOfTaskSummaryBySubsystemBean();
                countOfTaskSummaryBean7.setJimutetuzukiCd("A10001017");
                countOfTaskSummaryBean7.setJimutetuzukiNm("事務手続名_" + Integer.toString(1));
                countOfTaskSummaryBean7.setCountOfprocessStartToday(BizNumber.valueOf(2020));
                countOfTaskSummaryBean7.setCountOfprocessLeftToday(BizNumber.valueOf(20));
                countOfTaskSummaryBean7.setCountOfprocessFinToday(BizNumber.valueOf(2000));
                countOfTaskSummaryBeanList.add(countOfTaskSummaryBean7);
                break;

            case "1":
                for (int i = 0; i < Integer.valueOf(str); i++) {
                    countOfTaskSummaryBean = new CountOfTaskSummaryBySubsystemBean();
                    countOfTaskSummaryBean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    countOfTaskSummaryBean.setJimutetuzukiNm("事務手続名_" + Integer.toString(i));
                    countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(i));
                    countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(i+1));
                    countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(i+2));
                    countOfTaskSummaryBeanList.add(countOfTaskSummaryBean);
                }
                break;
            case "11":
                for (int i = 0; i < Integer.valueOf(str); i++) {
                    countOfTaskSummaryBean = new CountOfTaskSummaryBySubsystemBean();
                    countOfTaskSummaryBean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    countOfTaskSummaryBean.setJimutetuzukiNm("事務手続名_" + Integer.toString(i));
                    countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(i));
                    countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(i+1));
                    countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(i+2));
                    countOfTaskSummaryBeanList.add(countOfTaskSummaryBean);
                }
                break;
            case "1001":
                for (int i = 0; i < Integer.valueOf(str); i++) {
                    countOfTaskSummaryBean = new CountOfTaskSummaryBySubsystemBean();
                    countOfTaskSummaryBean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    countOfTaskSummaryBean.setJimutetuzukiNm("事務手続名_" + Integer.toString(i));
                    countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(i));
                    countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(i+1));
                    countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(i+2));
                    countOfTaskSummaryBeanList.add(countOfTaskSummaryBean);
                }
                break;
            case "00":
                for (int i = 0; i <= 99; i++) {
                    if(i ==0){
                        countOfTaskSummaryBean = new CountOfTaskSummaryBySubsystemBean();
                        countOfTaskSummaryBean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                        countOfTaskSummaryBean.setJimutetuzukiNm("事務手続名_" + Integer.toString(i));
                        countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(i));
                        countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(i));
                        countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(i));
                    }else{
                        countOfTaskSummaryBean = new CountOfTaskSummaryBySubsystemBean();
                        countOfTaskSummaryBean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                        countOfTaskSummaryBean.setJimutetuzukiNm("事務手続名_" + Integer.toString(i));
                        countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(i+1));
                        countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(i));
                        countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(i-1));
                    }

                    countOfTaskSummaryBeanList.add(countOfTaskSummaryBean);
                }
                break;
            default:
                for (int i = 0; i <= 99; i++) {
                    countOfTaskSummaryBean = new CountOfTaskSummaryBySubsystemBean();
                    countOfTaskSummaryBean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    countOfTaskSummaryBean.setJimutetuzukiNm("事務手続名_" + Integer.toString(i));
                    countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(i));
                    countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(i+1));
                    countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(i+2));
                    countOfTaskSummaryBeanList.add(countOfTaskSummaryBean);
                }
        }

        resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

        resultBean.setSyousaiMessageCd("IWFXXXX");

        resultBean.setSyousaiMessage("処理終了");

        resultBean.setCountOfTaskSummaryBean(countOfTaskSummaryBeanList);

        return resultBean;
    }

    public static GetCountOfTaskSummaryByJimutetuzukiResultBean getCountOfKakoJissekiTaskSummaryByJimutetuzuki(
        String[] pSubsystemId, BizDate pSyoriYmd, String pJimutetuzukiCd, String pUserId) {

        GetCountOfTaskSummaryByJimutetuzukiResultBean resultBean = new GetCountOfTaskSummaryByJimutetuzukiResultBean();
        List<CountOfTaskSummaryByJimutetuzukiBean> countOfTaskSummaryBeanList = new ArrayList<CountOfTaskSummaryByJimutetuzukiBean>();
        CountOfTaskSummaryByJimutetuzukiBean countOfTaskSummaryBean;

        String str = "";

        try {
            final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("1:1件データ\n");
            System.out.print("5:5件データ\n");
            System.out.print("11:11件データ\n");

            System.out.print("21:1件データ\n");
            System.out.print("1001:1001件データ\n");
            System.out.print("00:タスクの本日開始件数・本日残件数・本日完了件数0件あり\n");
            System.out.print("-------------------\n");
            System.out.print("default:100件データ\n");
            System.out.print("★★★入力してください⇒");
            str = br.readLine();
        } catch (final IOException e) {
            e.printStackTrace();
        }
        System.out.println("入力値は：" + str);

        switch(str){
            case "21":
                countOfTaskSummaryBean = new CountOfTaskSummaryByJimutetuzukiBean();
                countOfTaskSummaryBean.setJimutetuzukiCd("A10001010");
                countOfTaskSummaryBean.setTaskNm("TaskNm_" + Integer.toString(0));
                countOfTaskSummaryBean.setDispTaskNm("タスク名_" + Integer.toString(0));
                countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(1010));
                countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(1000));
                countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(10));
                countOfTaskSummaryBeanList.add(countOfTaskSummaryBean);
                break;
            case "1":
                for (int i = 0; i < Integer.valueOf(str); i++) {
                    countOfTaskSummaryBean = new CountOfTaskSummaryByJimutetuzukiBean();
                    countOfTaskSummaryBean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    countOfTaskSummaryBean.setTaskNm("TaskNm_" + Integer.toString(i));
                    countOfTaskSummaryBean.setDispTaskNm("タスク名_" + Integer.toString(i));
                    countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(i));
                    countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(i+1));
                    countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(i+2));
                    countOfTaskSummaryBeanList.add(countOfTaskSummaryBean);
                }
                break;
            case "5":
                for (int i = 0; i < Integer.valueOf(str); i++) {
                    countOfTaskSummaryBean = new CountOfTaskSummaryByJimutetuzukiBean();
                    countOfTaskSummaryBean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    countOfTaskSummaryBean.setTaskNm("TaskNm_" + Integer.toString(i));
                    countOfTaskSummaryBean.setDispTaskNm("タスク名_" + Integer.toString(i));
                    countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(i));
                    countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(i+1));
                    countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(i+2));
                    countOfTaskSummaryBeanList.add(countOfTaskSummaryBean);
                }
                break;
            case "11":
                for (int i = 0; i < Integer.valueOf(str); i++) {
                    countOfTaskSummaryBean = new CountOfTaskSummaryByJimutetuzukiBean();
                    countOfTaskSummaryBean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    countOfTaskSummaryBean.setTaskNm("TaskNm_" + Integer.toString(i));
                    countOfTaskSummaryBean.setDispTaskNm("タスク名_" + Integer.toString(i));
                    countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(i));
                    countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(i+1));
                    countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(i+2));
                    countOfTaskSummaryBeanList.add(countOfTaskSummaryBean);
                }
                break;
            case "1001":
                for (int i = 0; i < Integer.valueOf(str); i++) {
                    countOfTaskSummaryBean = new CountOfTaskSummaryByJimutetuzukiBean();
                    countOfTaskSummaryBean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    countOfTaskSummaryBean.setTaskNm("TaskNm_" + Integer.toString(i));
                    countOfTaskSummaryBean.setDispTaskNm("タスク名_" + Integer.toString(i));
                    countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(i));
                    countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(i+1));
                    countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(i+2));
                    countOfTaskSummaryBeanList.add(countOfTaskSummaryBean);
                }
                break;
            case "00":
                for (int i = 0; i <= 99; i++) {
                    countOfTaskSummaryBean = new CountOfTaskSummaryByJimutetuzukiBean();
                    if(i==0){
                        countOfTaskSummaryBean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                        countOfTaskSummaryBean.setTaskNm("TaskNm_" + Integer.toString(i));
                        countOfTaskSummaryBean.setDispTaskNm("タスク名_" + Integer.toString(i));
                        countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(i));
                        countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(i));
                        countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(i));
                    }else{
                        countOfTaskSummaryBean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                        countOfTaskSummaryBean.setTaskNm("TaskNm_" + Integer.toString(i));
                        countOfTaskSummaryBean.setDispTaskNm("タスク名_" + Integer.toString(i));
                        countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(i));
                        countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(i+1));
                        countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(i-1));
                    }
                    countOfTaskSummaryBeanList.add(countOfTaskSummaryBean);
                }
                break;
            default:
                for (int i = 0; i <= 99; i++) {
                    countOfTaskSummaryBean = new CountOfTaskSummaryByJimutetuzukiBean();
                    countOfTaskSummaryBean.setJimutetuzukiCd("JimutetuzukiCd_" + Integer.toString(i));
                    countOfTaskSummaryBean.setTaskNm("TaskNm_" + Integer.toString(i));
                    countOfTaskSummaryBean.setDispTaskNm("タスク名_" + Integer.toString(i));
                    countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(i));
                    countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(i+1));
                    countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(i+2));
                    countOfTaskSummaryBeanList.add(countOfTaskSummaryBean);
                }
        }

        resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

        resultBean.setSyousaiMessageCd("IWFXXXX");

        resultBean.setSyousaiMessage("処理終了");

        resultBean.setCountOfTaskSummaryBean(countOfTaskSummaryBeanList);

        return resultBean;
    }

    public static GetCountOfTaskSummaryByTaskResultBean getCountOfKakoJissekiTaskSummaryByTask(
        BizDate pSyoriYmd, String pJimutetuzukiCd, String[] pTaskId, String pUserId) {

        GetCountOfTaskSummaryByTaskResultBean resultBean = new GetCountOfTaskSummaryByTaskResultBean();
        List<CountOfTaskSummaryByTaskBean> countOfTaskSummaryBeanList = new ArrayList<CountOfTaskSummaryByTaskBean>();
        CountOfTaskSummaryByTaskBean countOfTaskSummaryBean;

        String str = "";

        try {
            final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("0:共用タスクに0件データ、ユーザ指定ある場合はALL0件データ\n");
            System.out.print("00:共用タスクに0件データ、1つのユーザにALL0件データ（ユーザ1）\n");
            System.out.print("1:1件データ\n");
            System.out.print("5:5件データ\n");
            System.out.print("11:11件データ\n");

            System.out.print("21:1件データ 1010 1000 10\n");
            System.out.print("1001:1001件データ\n");
            System.out.print("-------------------\n");
            System.out.print("default:\n");
            System.out.print("★★★入力してください⇒");
            str = br.readLine();
        } catch (final IOException e) {
            e.printStackTrace();
        }
        System.out.println("入力値は：" + str);

        switch(str){

            case "21":
                if(!Strings.isNullOrEmpty(pUserId)){
                    countOfTaskSummaryBean = new CountOfTaskSummaryByTaskBean();
                    countOfTaskSummaryBean.setUserId("UserId_" + Integer.toString(1));
                    countOfTaskSummaryBean.setDispUserNm("ユーザー名_" + Integer.toString(1));
                    countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(1010));
                    countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(1000));
                    countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(10));
                    countOfTaskSummaryBeanList.add(countOfTaskSummaryBean);
                }else{
                    for (int i = 0; i < Integer.valueOf(1); i++) {
                        countOfTaskSummaryBean = new CountOfTaskSummaryByTaskBean();
                        if (i == 0) {
                            countOfTaskSummaryBean.setUserId("");
                            countOfTaskSummaryBean.setDispUserNm("");
                            countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(i));
                            countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(i+1));
                            countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(i+1));
                        } else {
                            countOfTaskSummaryBean.setUserId("UserId_" + Integer.toString(i));
                            countOfTaskSummaryBean.setDispUserNm("ユーザー名_" + Integer.toString(i));
                            countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(1010));
                            countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(1000));
                            countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(10));
                        }
                        countOfTaskSummaryBeanList.add(countOfTaskSummaryBean);
                    }
                }
                break;

            case "0":
                if(!Strings.isNullOrEmpty(pUserId)){
                    countOfTaskSummaryBean = new CountOfTaskSummaryByTaskBean();
                    countOfTaskSummaryBean.setUserId("UserId_" + Integer.toString(1));
                    countOfTaskSummaryBean.setDispUserNm("ユーザー名_" + Integer.toString(1));
                    countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(0));
                    countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(0));
                    countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(0));
                    countOfTaskSummaryBeanList.add(countOfTaskSummaryBean);
                }else{
                    for (int i = 0; i <= 99; i++) {
                        countOfTaskSummaryBean = new CountOfTaskSummaryByTaskBean();
                        if (i == 0) {
                            countOfTaskSummaryBean.setUserId("");
                            countOfTaskSummaryBean.setDispUserNm("");
                            countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(i));
                            countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(i));
                            countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(i));
                        } else {
                            countOfTaskSummaryBean.setUserId("UserId_" + Integer.toString(i));
                            countOfTaskSummaryBean.setDispUserNm("ユーザー名_" + Integer.toString(i));
                            countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(i-1));
                            countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(i-1));
                            countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(i-1));
                        }
                        countOfTaskSummaryBeanList.add(countOfTaskSummaryBean);
                    }
                }
                break;
            case "00":
                if(!Strings.isNullOrEmpty(pUserId)){
                    countOfTaskSummaryBean = new CountOfTaskSummaryByTaskBean();
                    countOfTaskSummaryBean.setUserId("UserId_" + Integer.toString(1));
                    countOfTaskSummaryBean.setDispUserNm("ユーザー名_" + Integer.toString(1));
                    countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(0));
                    countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(0));
                    countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(0));
                    countOfTaskSummaryBeanList.add(countOfTaskSummaryBean);
                }else{
                    for (int i = 0; i <= 99; i++) {
                        countOfTaskSummaryBean = new CountOfTaskSummaryByTaskBean();
                        if (i == 0) {
                            countOfTaskSummaryBean.setUserId("");
                            countOfTaskSummaryBean.setDispUserNm("");
                            countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(i));
                            countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(i));
                            countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(i));
                        } else if(i == 1){
                            countOfTaskSummaryBean.setUserId("UserId_" + Integer.toString(i));
                            countOfTaskSummaryBean.setDispUserNm("ユーザー名_" + Integer.toString(i));
                            countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(i-1));
                            countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(i-1));
                            countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(i-1));
                        }else {
                            countOfTaskSummaryBean.setUserId("UserId_" + Integer.toString(i));
                            countOfTaskSummaryBean.setDispUserNm("ユーザー名_" + Integer.toString(i));
                            countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(i-2));
                            countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(i-1));
                            countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(i));
                        }
                        countOfTaskSummaryBeanList.add(countOfTaskSummaryBean);
                    }
                }
                break;

            case "1":
                if(!Strings.isNullOrEmpty(pUserId)){
                    countOfTaskSummaryBean = new CountOfTaskSummaryByTaskBean();
                    countOfTaskSummaryBean.setUserId("UserId_" + Integer.toString(1));
                    countOfTaskSummaryBean.setDispUserNm("ユーザー名_" + Integer.toString(1));
                    countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(1));
                    countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(1));
                    countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(1));
                    countOfTaskSummaryBeanList.add(countOfTaskSummaryBean);
                }else{
                    for (int i = 0; i < Integer.valueOf(str); i++) {
                        countOfTaskSummaryBean = new CountOfTaskSummaryByTaskBean();
                        if (i == 0) {
                            countOfTaskSummaryBean.setUserId("");
                            countOfTaskSummaryBean.setDispUserNm("");
                            countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(i));
                            countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(i+1));
                            countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(i+1));
                        } else {
                            countOfTaskSummaryBean.setUserId("UserId_" + Integer.toString(i));
                            countOfTaskSummaryBean.setDispUserNm("ユーザー名_" + Integer.toString(i));
                            countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(i-1));
                            countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(i));
                            countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(i+1));
                        }
                        countOfTaskSummaryBeanList.add(countOfTaskSummaryBean);
                    }
                }
                break;
            case "5":
                if(!Strings.isNullOrEmpty(pUserId)){
                    countOfTaskSummaryBean = new CountOfTaskSummaryByTaskBean();
                    countOfTaskSummaryBean.setUserId("UserId_" + Integer.toString(1));
                    countOfTaskSummaryBean.setDispUserNm("ユーザー名_" + Integer.toString(1));
                    countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(1));
                    countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(1));
                    countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(1));
                    countOfTaskSummaryBeanList.add(countOfTaskSummaryBean);
                }else{
                    for (int i = 0; i < Integer.valueOf(str); i++) {
                        countOfTaskSummaryBean = new CountOfTaskSummaryByTaskBean();
                        if (i == 0) {
                            countOfTaskSummaryBean.setUserId("");
                            countOfTaskSummaryBean.setDispUserNm("");
                            countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(i));
                            countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(i+1));
                            countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(i+1));
                        } else {
                            countOfTaskSummaryBean.setUserId("UserId_" + Integer.toString(i));
                            countOfTaskSummaryBean.setDispUserNm("ユーザー名_" + Integer.toString(i));
                            countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(i-1));
                            countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(i));
                            countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(i+1));
                        }
                        countOfTaskSummaryBeanList.add(countOfTaskSummaryBean);
                    }
                }
                break;
            case "11":
                if(!Strings.isNullOrEmpty(pUserId)){
                    countOfTaskSummaryBean = new CountOfTaskSummaryByTaskBean();
                    countOfTaskSummaryBean.setUserId("UserId_" + Integer.toString(1));
                    countOfTaskSummaryBean.setDispUserNm("ユーザー名_" + Integer.toString(1));
                    countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(1));
                    countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(1));
                    countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(1));
                    countOfTaskSummaryBeanList.add(countOfTaskSummaryBean);
                }else{
                    for (int i = 0; i < Integer.valueOf(str); i++) {
                        countOfTaskSummaryBean = new CountOfTaskSummaryByTaskBean();
                        if (i == 0) {
                            countOfTaskSummaryBean.setUserId("");
                            countOfTaskSummaryBean.setDispUserNm("");
                            countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(i));
                            countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(i+1));
                            countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(i+1));
                        } else {
                            countOfTaskSummaryBean.setUserId("UserId_" + Integer.toString(i));
                            countOfTaskSummaryBean.setDispUserNm("ユーザー名_" + Integer.toString(i));
                            countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(i-1));
                            countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(i));
                            countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(i+1));
                        }
                        countOfTaskSummaryBeanList.add(countOfTaskSummaryBean);
                    }
                }
                break;
            case "1001":
                if(!Strings.isNullOrEmpty(pUserId)){
                    countOfTaskSummaryBean = new CountOfTaskSummaryByTaskBean();
                    countOfTaskSummaryBean.setUserId("UserId_" + Integer.toString(1));
                    countOfTaskSummaryBean.setDispUserNm("ユーザー名_" + Integer.toString(1));
                    countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(1));
                    countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(1));
                    countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(1));
                    countOfTaskSummaryBeanList.add(countOfTaskSummaryBean);
                }else{
                    for (int i = 0; i < Integer.valueOf(str); i++) {
                        countOfTaskSummaryBean = new CountOfTaskSummaryByTaskBean();
                        if (i == 0) {
                            countOfTaskSummaryBean.setUserId("");
                            countOfTaskSummaryBean.setDispUserNm("");
                            countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(i+1));
                            countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(i+1));
                            countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(i+1));
                        } else {
                            countOfTaskSummaryBean.setUserId("UserId_" + Integer.toString(i));
                            countOfTaskSummaryBean.setDispUserNm("ユーザー名_" + Integer.toString(i));
                            countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(i-1));
                            countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(i));
                            countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(i+1));
                        }
                        countOfTaskSummaryBeanList.add(countOfTaskSummaryBean);
                    }
                }
                break;
            default:
                if(!Strings.isNullOrEmpty(pUserId)){
                    countOfTaskSummaryBean = new CountOfTaskSummaryByTaskBean();
                    countOfTaskSummaryBean.setUserId("UserId_" + Integer.toString(1));
                    countOfTaskSummaryBean.setDispUserNm("ユーザー名_" + Integer.toString(1));
                    countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(1));
                    countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(1));
                    countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(1));
                    countOfTaskSummaryBeanList.add(countOfTaskSummaryBean);
                }else{
                    for (int i = 0; i < 99; i++) {
                        countOfTaskSummaryBean = new CountOfTaskSummaryByTaskBean();
                        if (i == 0) {
                            countOfTaskSummaryBean.setUserId("");
                            countOfTaskSummaryBean.setDispUserNm("");
                            countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(i+1));
                            countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(i+1));
                            countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(i+1));
                        } else {
                            countOfTaskSummaryBean.setUserId("UserId_" + Integer.toString(i));
                            countOfTaskSummaryBean.setDispUserNm("ユーザー名_" + Integer.toString(i));
                            countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(i-1));
                            countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(i));
                            countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(i+1));
                        }
                        countOfTaskSummaryBeanList.add(countOfTaskSummaryBean);
                    }
                }
        }


        resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

        resultBean.setSyousaiMessageCd("IWFXXXX");

        resultBean.setSyousaiMessage("処理終了");

        resultBean.setCountOfTaskSummaryBean(countOfTaskSummaryBeanList);

        return resultBean;
    }

    public static GetCountOfTaskSummaryBySubsystemResultBean getCountOfKakoJissekiTaskSummaryBySubsystem(
        String[] pSubsystemId, BizDate pSyoriYmdFrom, BizDate pSyoriYmdTo, String pUserId) {

        GetCountOfTaskSummaryBySubsystemResultBean resultBean = new GetCountOfTaskSummaryBySubsystemResultBean();
        return resultBean;
    }

    public static GetCountOfTaskSummaryByJimutetuzukiResultBean getCountOfTaskSummaryByJimutetuzuki(
        String[] pSubsystemId, BizDate pSyoriYmdFrom, BizDate pSyoriYmdTo, String pJimutetuzukiCd, String pUserId) {

        GetCountOfTaskSummaryByJimutetuzukiResultBean resultBean = new GetCountOfTaskSummaryByJimutetuzukiResultBean();
        return resultBean;
    }

    public static GetCountOfTaskSummaryByTaskResultBean getCountOfKakoJissekiTaskSummaryByTask(
        BizDate pSyoriYmdFrom, BizDate pSyoriYmdTo, String pJimutetuzukiCd, String[] pTaskId, String pUserId) {

        GetCountOfTaskSummaryByTaskResultBean resultBean = new GetCountOfTaskSummaryByTaskResultBean();
        return resultBean;
    }

    public static GetSumiTaskByUserResultBean getSumiTask(String pSubSystemId, String pUserId,
        BizDate pSyoriYmdFrom, BizDate pSyoriYmdTo) {

        GetSumiTaskByUserResultBean resultBean = new GetSumiTaskByUserResultBean();
        return resultBean;
    }

}