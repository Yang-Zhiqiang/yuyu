package yuyu.app.base.log.batchzyoukyousyoukai;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.bizinfr.message.Message;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateFormat;
import jp.co.slcs.swak.web.message.MessageManager;
import jp.co.slcs.swak.web.ui.LabelValuePair;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.log.batchjyoukyousyoukai.BatchJobListDataSourceBean;
import yuyu.app.base.log.batchjyoukyousyoukai.BatchJyoukyouSyoukaiAction;
import yuyu.app.base.log.batchjyoukyousyoukai.BatchJyoukyouSyoukaiUiBean;
import yuyu.app.base.log.batchjyoukyousyoukai.BatchLogListDataSourceBean;
import yuyu.def.classification.C_BatchJyoutaiKbn;
import yuyu.def.classification.C_BatchKidouKbn;
import yuyu.def.classification.C_BatchResultKbn;
import yuyu.def.classification.C_LogLevelKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AT_BatchJob;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

import com.google.common.collect.Lists;

/**
 * {@link #syousaiTest0040()} ～ {@link #syousaiTest0060()}のケースは、実行前にバッチサーバを起動してください。
 */
@RunWith(OrderedRunner.class)
public class BatchZyoukyouSyoukaiTest extends AbstractTest {

    @Inject
    private BatchJyoukyouSyoukaiAction action;

    @Inject
    private BatchJyoukyouSyoukaiUiBean uiBean;

    @Inject
    private MessageManager messageManager;


    @Test
    @TestOrder(1010)
    public void gaiyouTest0010(){

        changeSystemDate(BizDate.valueOf("20140528"));

        action.init();

        exStringEquals(uiBean.getSubSystemId()      , null                        , "サブシステムID");
        exDateEquals(uiBean.getSyoriYmdFrom()       , BizDate.valueOf("20140527") , "処理年月日（自）");
        exDateEquals(uiBean.getSyoriYmdTo()         , null                        , "処理年月日（至）");
        C_BatchResultKbn[] batchResultKbns = uiBean.getBatchResultKbn();
        exClassificationEquals(batchResultKbns[0]   , C_BatchResultKbn.NORMAL     , "バッチ結果区分_正常");
        exClassificationEquals(batchResultKbns[1]   , C_BatchResultKbn.WARN       , "バッチ結果区分_警告");
        exClassificationEquals(batchResultKbns[2]   , C_BatchResultKbn.ERROR      , "バッチ結果区分_エラー");
        exClassificationEquals(batchResultKbns[3]   , C_BatchResultKbn.INTERRUPT  , "バッチ結果区分_中断");
        exBooleanEquals(uiBean.getBatchJyoutai() ,  true                       , "バッチ状態区分");
        exClassificationEquals(uiBean.getJidouKousinUmuFlg(), C_UmuKbn.ARI, "自動更新有無フラグ");
        //exNumericEquals(uiBean.getSubsystemYuukouHanteiFlg(), 1, "サブシステム有効判定フラグ");
        List<LabelValuePair> targetList = uiBean.getSubSystemIdOptionBeanList();
        List<LabelValuePair> meanList = Lists.newArrayList();
        meanList.add(new LabelValuePair());
        meanList.add(new LabelValuePair("保険募集", "bosyuu"));
        meanList.add(new LabelValuePair("業務共通", "biz"));
        meanList.add(new LabelValuePair("管理機能", "base"));
        int count = 0;
        for (LabelValuePair labelValuePair : targetList) {
            exStringEquals(labelValuePair.getLabel()      , meanList.get(count).getLabel()        , "ラベル");
            exStringEquals(labelValuePair.getValue()      , meanList.get(count).getValue()        , "値");
            count++;
        }
        List<BatchJobListDataSourceBean> batchJobList = uiBean.getBatchJobListDataSource().getAllData();
        exNumericEquals(batchJobList.size()         , 7                           , "バッチジョブ件数");
        BatchJobListDataSourceBean datasource = batchJobList.get(0);
        exStringEquals(datasource.getSubSystemNm()             , "保険募集"                   , "バッチジョブリスト：サブシステム名");
        exStringEquals(datasource.getCategoryNm()              , "保険設計"                   , "バッチジョブリスト：カテゴリ名");
        exStringEquals(datasource.getKinouNm()                 , "設計書作成"                 , "バッチジョブリスト：機能名");
        exStringEquals(datasource.getBatchJobId()              , "000000aaaaa0001"            , "バッチジョブリスト：バッチジョブID");
        exClassificationEquals(datasource.getBatchKidouKbn()   , C_BatchKidouKbn.BATCH        , "バッチジョブリスト：バッチ起動区分");
        exStringEquals(datasource.getBatchStartTime()          , editTime4View("20150601102030100")          , "バッチジョブリスト：開始時間");
        exStringEquals(datasource.getBatchEndTime()            , editTime4View("20150601203040999")          , "バッチジョブリスト：終了時間");
        exClassificationEquals(datasource.getBatchResultKbn()  , C_BatchResultKbn.NORMAL      , "バッチジョブリスト：バッチ結果区分");
        exClassificationEquals(datasource.getBatchJyoutaiKbn() , C_BatchJyoutaiKbn.SYUURYOU   , "バッチジョブリスト：バッチ状態区分");
        exStringEquals(datasource.getTyouhyouSyuturyokuLink()    , "帳票"                       , "バッチジョブリスト：帳票リンク");

        datasource = batchJobList.get(1);
        exStringEquals(datasource.getSubSystemNm()             , "業務共通"                   , "バッチジョブリスト：サブシステム名");
        exStringEquals(datasource.getCategoryNm()              , "郵便番号検索"               , "バッチジョブリスト：カテゴリ名");
        exStringEquals(datasource.getKinouNm()                 , "郵便番号検索機能ＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＺ"                 , "バッチジョブリスト：機能名");
        exStringEquals(datasource.getBatchJobId()              , "000000aaaaa0002"            , "バッチジョブリスト：バッチジョブID");
        exClassificationEquals(datasource.getBatchKidouKbn()   , C_BatchKidouKbn.GAMEN        , "バッチジョブリスト：バッチ起動区分");
        exStringEquals(datasource.getBatchStartTime()          , editTime4View("20140602102030111")          , "バッチジョブリスト：開始時間");
        exStringEquals(datasource.getBatchEndTime()            , editTime4View("20140602203040999")          , "バッチジョブリスト：終了時間");
        exClassificationEquals(datasource.getBatchResultKbn()  , C_BatchResultKbn.WARN        , "バッチジョブリスト：バッチ結果区分");
        exClassificationEquals(datasource.getBatchJyoutaiKbn() , C_BatchJyoutaiKbn.SYUURYOU   , "バッチジョブリスト：バッチ状態区分");
        exStringEquals(datasource.getTyouhyouSyuturyokuLink()    , "帳票"                       , "バッチジョブリスト：帳票リンク");

        datasource = batchJobList.get(2);
        exStringEquals(datasource.getSubSystemNm()             , "管理機能"                   , "バッチジョブリスト：サブシステム名");
        exStringEquals(datasource.getCategoryNm()              , "システム管理バッチ"         , "バッチジョブリスト：カテゴリ名");
        exStringEquals(datasource.getKinouNm()                 , "過去データ整備"             , "バッチジョブリスト：機能名");
        exStringEquals(datasource.getBatchJobId()              , "000000aaaaa0003"            , "バッチジョブリスト：バッチジョブID");
        exClassificationEquals(datasource.getBatchKidouKbn()   , C_BatchKidouKbn.BATCH        , "バッチジョブリスト：バッチ起動区分");
        exStringEquals(datasource.getBatchStartTime()          , editTime4View("20140531102030111")          , "バッチジョブリスト：開始時間");
        exStringEquals(datasource.getBatchEndTime()            , editTime4View("20140531203040999")          , "バッチジョブリスト：終了時間");
        exClassificationEquals(datasource.getBatchResultKbn()  , C_BatchResultKbn.ERROR       , "バッチジョブリスト：バッチ結果区分");
        exClassificationEquals(datasource.getBatchJyoutaiKbn() , C_BatchJyoutaiKbn.SYUURYOU   , "バッチジョブリスト：バッチ状態区分");
        exStringEquals(datasource.getTyouhyouSyuturyokuLink()    , null                         , "バッチジョブリスト：帳票リンク");

        datasource = batchJobList.get(3);
        exStringEquals(datasource.getSubSystemNm()             , "管理機能"                   , "バッチジョブリスト：サブシステム名");
        exStringEquals(datasource.getCategoryNm()              , "ログ管理"                   , "バッチジョブリスト：カテゴリ名");
        exStringEquals(datasource.getKinouNm()                 , "アクセスログ照会"           , "バッチジョブリスト：機能名");
        exStringEquals(datasource.getBatchJobId()              , "000000aaaaa0004"            , "バッチジョブリスト：バッチジョブID");
        exClassificationEquals(datasource.getBatchKidouKbn()   , C_BatchKidouKbn.BATCH        , "バッチジョブリスト：バッチ起動区分");
        exStringEquals(datasource.getBatchStartTime()          , editTime4View("20140530102030111")          , "バッチジョブリスト：開始時間");
        exStringEquals(datasource.getBatchEndTime()            , editTime4View("20140530203040999")          , "バッチジョブリスト：終了時間");
        exClassificationEquals(datasource.getBatchResultKbn()  , C_BatchResultKbn.INTERRUPT   , "バッチジョブリスト：バッチ結果区分");
        exClassificationEquals(datasource.getBatchJyoutaiKbn() , C_BatchJyoutaiKbn.SYUURYOU   , "バッチジョブリスト：バッチ状態区分");

        datasource = batchJobList.get(4);
        exStringEquals(datasource.getSubSystemNm()             , "管理機能"                   , "バッチジョブリスト：サブシステム名");
        exStringEquals(datasource.getCategoryNm()              , "システム管理バッチ"         , "バッチジョブリスト：カテゴリ名");
        exStringEquals(datasource.getKinouNm()                 , "過去データ整備"             , "バッチジョブリスト：機能名");
        exStringEquals(datasource.getBatchJobId()              , "000000aaaaa0005"            , "バッチジョブリスト：バッチジョブID");
        exClassificationEquals(datasource.getBatchKidouKbn()   , C_BatchKidouKbn.BATCH        , "バッチジョブリスト：バッチ起動区分");
        exStringEquals(datasource.getBatchStartTime()          , editTime4View("20140529102030111")          , "バッチジョブリスト：開始時間");
        exStringEquals(datasource.getBatchEndTime()            , editTime4View("20140529203040999")          , "バッチジョブリスト：終了時間");
        exClassificationEquals(datasource.getBatchResultKbn()  , null                         , "バッチジョブリスト：バッチ結果区分");
        exClassificationEquals(datasource.getBatchJyoutaiKbn() , C_BatchJyoutaiKbn.TAIKI      , "バッチジョブリスト：バッチ状態区分");

        datasource = batchJobList.get(5);
        exStringEquals(datasource.getSubSystemNm()             , "管理機能"                   , "バッチジョブリスト：サブシステム名");
        exStringEquals(datasource.getCategoryNm()              , "システム管理バッチ"         , "バッチジョブリスト：カテゴリ名");
        exStringEquals(datasource.getKinouNm()                 , "過去データ整備"             , "バッチジョブリスト：機能名");
        exStringEquals(datasource.getBatchJobId()              , "000000aaaaa0006"            , "バッチジョブリスト：バッチジョブID");
        exClassificationEquals(datasource.getBatchKidouKbn()   , C_BatchKidouKbn.BATCH        , "バッチジョブリスト：バッチ起動区分");
        exStringEquals(datasource.getBatchStartTime()          , editTime4View("20140528102030111")          , "バッチジョブリスト：開始時間");
        exStringEquals(datasource.getBatchEndTime()            , editTime4View("20140528203040999")          , "バッチジョブリスト：終了時間");
        exClassificationEquals(datasource.getBatchResultKbn()  , null                         , "バッチジョブリスト：バッチ結果区分");
        exClassificationEquals(datasource.getBatchJyoutaiKbn() , C_BatchJyoutaiKbn.SYORI      , "バッチジョブリスト：バッチ状態区分");

        datasource = batchJobList.get(6);
        exStringEquals(datasource.getSubSystemNm()             , "管理機能"                   , "バッチジョブリスト：サブシステム名");
        exStringEquals(datasource.getCategoryNm()              , "システム管理バッチ"         , "バッチジョブリスト：カテゴリ名");
        exStringEquals(datasource.getKinouNm()                 , "過去データ整備"             , "バッチジョブリスト：機能名");
        exStringEquals(datasource.getBatchJobId()              , "000000aaaaa0007"            , "バッチジョブリスト：バッチジョブID");
        exClassificationEquals(datasource.getBatchKidouKbn()   , C_BatchKidouKbn.BATCH        , "バッチジョブリスト：バッチ起動区分");
        exStringEquals(datasource.getBatchStartTime()          , editTime4View("20140527102030111")          , "バッチジョブリスト：開始時間");
        exStringEquals(datasource.getBatchEndTime()            , editTime4View("20140527203040999")          , "バッチジョブリスト：終了時間");
        exClassificationEquals(datasource.getBatchResultKbn()  , null                         , "バッチジョブリスト：バッチ結果区分");
        exClassificationEquals(datasource.getBatchJyoutaiKbn() , C_BatchJyoutaiKbn.SYUURYOU_TYU   , "バッチジョブリスト：バッチ状態区分");
    }

    @Test
    @TestOrder(1011)
    public void gaiyouTest0011(){

        changeSystemDate(BizDate.valueOf("20600101"));

        action.init();

        exStringEquals(uiBean.getSubSystemId()      , null                        , "サブシステムID");
        exDateEquals(uiBean.getSyoriYmdFrom()       , BizDate.valueOf("20591231") , "処理年月日（自）");
        exDateEquals(uiBean.getSyoriYmdTo()         , null                        , "処理年月日（至）");
        C_BatchResultKbn[] batchResultKbns = uiBean.getBatchResultKbn();
        exClassificationEquals(batchResultKbns[0]   , C_BatchResultKbn.NORMAL     , "バッチ結果区分_正常");
        exClassificationEquals(batchResultKbns[1]   , C_BatchResultKbn.WARN       , "バッチ結果区分_警告");
        exClassificationEquals(batchResultKbns[2]   , C_BatchResultKbn.ERROR      , "バッチ結果区分_エラー");
        exClassificationEquals(batchResultKbns[3]   , C_BatchResultKbn.INTERRUPT  , "バッチ結果区分_中断");
        exBooleanEquals(uiBean.getBatchJyoutai() ,  true                       , "バッチ状態区分");
        exClassificationEquals(uiBean.getJidouKousinUmuFlg(), C_UmuKbn.ARI, "自動更新有無フラグ");
        //exNumericEquals(uiBean.getSubsystemYuukouHanteiFlg(), 1, "サブシステム有効判定フラグ");
        List<BatchJobListDataSourceBean> batchJobList = uiBean.getBatchJobListDataSource().getAllData();
        exNumericEquals(batchJobList.size()         , 0                           , "バッチジョブ件数");
    }

    @Test
    @TestOrder(1020)
    public void gaiyouTest0020(){

        action.init();
        uiBean.setJidouKousinUmuFlg(C_UmuKbn.ARI);
        action.jidouKousinSinaiBtnOnClick();
        exClassificationEquals(uiBean.getJidouKousinUmuFlg(), C_UmuKbn.NONE   , "自動更新有無フラグ");
    }

    @Test
    @TestOrder(1030)
    public void gaiyouTest0030(){

        action.init();
        uiBean.setJidouKousinUmuFlg(C_UmuKbn.NONE);
        action.jidouKousinSuruBtnOnClick();
        exClassificationEquals(uiBean.getJidouKousinUmuFlg(), C_UmuKbn.ARI   , "自動更新有無フラグ");
    }

    @Test
    @TestOrder(1050)
    public void gaiyouTest0050(){

        action.init();
        uiBean.setSubSystemId("bosyuu");
        uiBean.setSyoriYmdFrom(null);
        uiBean.setSyoriYmdTo(BizDate.valueOf("20140525"));
        C_BatchResultKbn[] batchResults = new C_BatchResultKbn[]{C_BatchResultKbn.NORMAL,
            C_BatchResultKbn.WARN
        };
        uiBean.setBatchResultKbn(batchResults);
        uiBean.setBatchJyoutai(false);
        action.searchBtnOnClick();
        List<BatchJobListDataSourceBean> batchJobList = uiBean.getBatchJobListDataSource().getAllData();
        exNumericEquals(batchJobList.size()         , 6                           , "バッチジョブ件数");
        BatchJobListDataSourceBean datasource = batchJobList.get(0);
        exStringEquals(datasource.getSubSystemNm()             , "保険募集"                   , "バッチジョブリスト：サブシステム名");
        exStringEquals(datasource.getCategoryNm()              , "保険設計"                   , "バッチジョブリスト：カテゴリ名");
        exStringEquals(datasource.getKinouNm()                 , "設計書作成"                 , "バッチジョブリスト：機能名");
        exStringEquals(datasource.getBatchJobId()              , "000000aaaaa0036"            , "バッチジョブリスト：バッチジョブID");
        exClassificationEquals(datasource.getBatchKidouKbn()   , C_BatchKidouKbn.GAMEN        , "バッチジョブリスト：バッチ起動区分");
        exStringEquals(datasource.getBatchStartTime()          , editTime4View("20140525000000001")          , "バッチジョブリスト：開始時間");
        exStringEquals(datasource.getBatchEndTime()            , editTime4View("20140526235959900")          , "バッチジョブリスト：終了時間");
        exClassificationEquals(datasource.getBatchResultKbn()  , C_BatchResultKbn.NORMAL      , "バッチジョブリスト：バッチ結果区分");
        exClassificationEquals(datasource.getBatchJyoutaiKbn() , C_BatchJyoutaiKbn.SYUURYOU   , "バッチジョブリスト：バッチ状態区分");

        datasource = batchJobList.get(1);
        exStringEquals(datasource.getSubSystemNm()             , "保険募集"                   , "バッチジョブリスト：サブシステム名");
        exStringEquals(datasource.getCategoryNm()              , "保険設計"                   , "バッチジョブリスト：カテゴリ名");
        exStringEquals(datasource.getKinouNm()                 , "設計書作成"                 , "バッチジョブリスト：機能名");
        exStringEquals(datasource.getBatchJobId()              , "000000aaaaa0037"            , "バッチジョブリスト：バッチジョブID");
        exClassificationEquals(datasource.getBatchKidouKbn()   , C_BatchKidouKbn.GAMEN        , "バッチジョブリスト：バッチ起動区分");
        exStringEquals(datasource.getBatchStartTime()          , editTime4View("20140525000000002")          , "バッチジョブリスト：開始時間");
        exStringEquals(datasource.getBatchEndTime()            , editTime4View("20140526235959900")          , "バッチジョブリスト：終了時間");
        exClassificationEquals(datasource.getBatchResultKbn()  , C_BatchResultKbn.WARN        , "バッチジョブリスト：バッチ結果区分");
        exClassificationEquals(datasource.getBatchJyoutaiKbn() , C_BatchJyoutaiKbn.SYUURYOU   , "バッチジョブリスト：バッチ状態区分");

        datasource = batchJobList.get(2);
        exStringEquals(datasource.getSubSystemNm()             , "保険募集"                   , "バッチジョブリスト：サブシステム名");
        exStringEquals(datasource.getCategoryNm()              , "保険設計"                   , "バッチジョブリスト：カテゴリ名");
        exStringEquals(datasource.getKinouNm()                 , "設計書作成"                 , "バッチジョブリスト：機能名");
        exStringEquals(datasource.getBatchJobId()              , "000000aaaaa0064"            , "バッチジョブリスト：バッチジョブID");
        exClassificationEquals(datasource.getBatchKidouKbn()   , C_BatchKidouKbn.GAMEN        , "バッチジョブリスト：バッチ起動区分");
        exStringEquals(datasource.getBatchStartTime()          , editTime4View("20140524000000001")          , "バッチジョブリスト：開始時間");
        exStringEquals(datasource.getBatchEndTime()            , editTime4View("20140526235959900")          , "バッチジョブリスト：終了時間");
        exClassificationEquals(datasource.getBatchResultKbn()  , C_BatchResultKbn.NORMAL      , "バッチジョブリスト：バッチ結果区分");
        exClassificationEquals(datasource.getBatchJyoutaiKbn() , C_BatchJyoutaiKbn.SYUURYOU   , "バッチジョブリスト：バッチ状態区分");
    }

    @Test
    @TestOrder(1060)
    public void gaiyouTest0060(){

        action.init();
        uiBean.setSubSystemId("biz");
        uiBean.setSyoriYmdFrom(BizDate.valueOf("20140524"));
        uiBean.setSyoriYmdTo(BizDate.valueOf("20140525"));
        C_BatchResultKbn[] batchResults = new C_BatchResultKbn[]{C_BatchResultKbn.ERROR,
            C_BatchResultKbn.INTERRUPT
        };
        uiBean.setBatchResultKbn(batchResults);
        uiBean.setBatchJyoutai(false);

        action.searchBtnOnClick();

        List<BatchJobListDataSourceBean> batchJobList = uiBean.getBatchJobListDataSource().getAllData();
        exNumericEquals(batchJobList.size()         , 4                           , "バッチジョブ件数");
        BatchJobListDataSourceBean datasource = batchJobList.get(0);
        exStringEquals(datasource.getSubSystemNm()             , "業務共通"                   , "バッチジョブリスト：サブシステム名");
        exStringEquals(datasource.getCategoryNm()              , "郵便番号検索"               , "バッチジョブリスト：カテゴリ名");
        exStringEquals(datasource.getKinouNm()                 , "郵便番号検索機能ＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＺ"                 , "バッチジョブリスト：機能名");
        exStringEquals(datasource.getBatchJobId()              , "000000aaaaa0045"            , "バッチジョブリスト：バッチジョブID");
        exClassificationEquals(datasource.getBatchKidouKbn()   , C_BatchKidouKbn.GAMEN        , "バッチジョブリスト：バッチ起動区分");
        exStringEquals(datasource.getBatchStartTime()          , editTime4View("20140525000000010")          , "バッチジョブリスト：開始時間");
        exStringEquals(datasource.getBatchEndTime()            , editTime4View("20140526235959900")          , "バッチジョブリスト：終了時間");
        exClassificationEquals(datasource.getBatchResultKbn()  , C_BatchResultKbn.ERROR       , "バッチジョブリスト：バッチ結果区分");
        exClassificationEquals(datasource.getBatchJyoutaiKbn() , C_BatchJyoutaiKbn.SYUURYOU   , "バッチジョブリスト：バッチ状態区分");

        datasource = batchJobList.get(1);
        exStringEquals(datasource.getSubSystemNm()             , "業務共通"                   , "バッチジョブリスト：サブシステム名");
        exStringEquals(datasource.getCategoryNm()              , "郵便番号検索"               , "バッチジョブリスト：カテゴリ名");
        exStringEquals(datasource.getKinouNm()                 , "郵便番号検索機能ＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＺ"                 , "バッチジョブリスト：機能名");
        exStringEquals(datasource.getBatchJobId()              , "000000aaaaa0046"            , "バッチジョブリスト：バッチジョブID");
        exClassificationEquals(datasource.getBatchKidouKbn()   , C_BatchKidouKbn.GAMEN        , "バッチジョブリスト：バッチ起動区分");
        exStringEquals(datasource.getBatchStartTime()          , editTime4View("20140525000000011")          , "バッチジョブリスト：開始時間");
        exStringEquals(datasource.getBatchEndTime()            , editTime4View("20140526235959900")          , "バッチジョブリスト：終了時間");
        exClassificationEquals(datasource.getBatchResultKbn()  , C_BatchResultKbn.INTERRUPT       , "バッチジョブリスト：バッチ結果区分");
        exClassificationEquals(datasource.getBatchJyoutaiKbn() , C_BatchJyoutaiKbn.SYUURYOU   , "バッチジョブリスト：バッチ状態区分");

        datasource = batchJobList.get(2);
        exStringEquals(datasource.getSubSystemNm()             , "業務共通"                   , "バッチジョブリスト：サブシステム名");
        exStringEquals(datasource.getCategoryNm()              , "郵便番号検索"               , "バッチジョブリスト：カテゴリ名");
        exStringEquals(datasource.getKinouNm()                 , "郵便番号検索機能ＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＺ"                 , "バッチジョブリスト：機能名");
        exStringEquals(datasource.getBatchJobId()              , "000000aaaaa0073"            , "バッチジョブリスト：バッチジョブID");
        exClassificationEquals(datasource.getBatchKidouKbn()   , C_BatchKidouKbn.GAMEN        , "バッチジョブリスト：バッチ起動区分");
        exStringEquals(datasource.getBatchStartTime()          , editTime4View("20140524000000010")          , "バッチジョブリスト：開始時間");
        exStringEquals(datasource.getBatchEndTime()            , editTime4View("20140526235959900")          , "バッチジョブリスト：終了時間");
        exClassificationEquals(datasource.getBatchResultKbn()  , C_BatchResultKbn.ERROR       , "バッチジョブリスト：バッチ結果区分");
        exClassificationEquals(datasource.getBatchJyoutaiKbn() , C_BatchJyoutaiKbn.SYUURYOU   , "バッチジョブリスト：バッチ状態区分");

        datasource = batchJobList.get(3);
        exStringEquals(datasource.getSubSystemNm()             , "業務共通"                   , "バッチジョブリスト：サブシステム名");
        exStringEquals(datasource.getCategoryNm()              , "郵便番号検索"               , "バッチジョブリスト：カテゴリ名");
        exStringEquals(datasource.getKinouNm()                 , "郵便番号検索機能ＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＺ"                 , "バッチジョブリスト：機能名");
        exStringEquals(datasource.getBatchJobId()              , "000000aaaaa0074"            , "バッチジョブリスト：バッチジョブID");
        exClassificationEquals(datasource.getBatchKidouKbn()   , C_BatchKidouKbn.GAMEN        , "バッチジョブリスト：バッチ起動区分");
        exStringEquals(datasource.getBatchStartTime()          , editTime4View("20140524000000011")          , "バッチジョブリスト：開始時間");
        exStringEquals(datasource.getBatchEndTime()            , editTime4View("20140526235959900")          , "バッチジョブリスト：終了時間");
        exClassificationEquals(datasource.getBatchResultKbn()  , C_BatchResultKbn.INTERRUPT       , "バッチジョブリスト：バッチ結果区分");
        exClassificationEquals(datasource.getBatchJyoutaiKbn() , C_BatchJyoutaiKbn.SYUURYOU   , "バッチジョブリスト：バッチ状態区分");

    }


    @Test
    @TestOrder(1070)
    public void gaiyouTest0070(){

        action.init();
        uiBean.setSubSystemId("base");
        uiBean.setSyoriYmdFrom(null);
        uiBean.setSyoriYmdTo(null);
        C_BatchResultKbn[] batchResults = new C_BatchResultKbn[]{C_BatchResultKbn.WARN  ,
            C_BatchResultKbn.INTERRUPT
        };
        uiBean.setBatchResultKbn(batchResults);
        uiBean.setBatchJyoutai(false);

        action.searchBtnOnClick();

        List<BatchJobListDataSourceBean> batchJobList = uiBean.getBatchJobListDataSource().getAllData();
        exNumericEquals(batchJobList.size()         , 17                           , "バッチジョブ件数");
        BatchJobListDataSourceBean datasource = batchJobList.get(0);
        exStringEquals(datasource.getSubSystemNm()             , "管理機能"                   , "バッチジョブリスト：サブシステム名");
        exStringEquals(datasource.getCategoryNm()              , "ログ管理"                   , "バッチジョブリスト：カテゴリ名");
        exStringEquals(datasource.getKinouNm()                 , "アクセスログ照会"           , "バッチジョブリスト：機能名");
        exStringEquals(datasource.getBatchJobId()              , "000000aaaaa0004"            , "バッチジョブリスト：バッチジョブID");
        exClassificationEquals(datasource.getBatchKidouKbn()   , C_BatchKidouKbn.BATCH        , "バッチジョブリスト：バッチ起動区分");
        exStringEquals(datasource.getBatchStartTime()          , editTime4View("20140530102030111")          , "バッチジョブリスト：開始時間");
        exStringEquals(datasource.getBatchEndTime()            , editTime4View("20140530203040999")          , "バッチジョブリスト：終了時間");
        exClassificationEquals(datasource.getBatchResultKbn()  , C_BatchResultKbn.INTERRUPT   , "バッチジョブリスト：バッチ結果区分");
        exClassificationEquals(datasource.getBatchJyoutaiKbn() , C_BatchJyoutaiKbn.SYUURYOU   , "バッチジョブリスト：バッチ状態区分");
    }

    @Test
    @TestOrder(1080)
    public void gaiyouTest0080(){

        action.init();
        uiBean.setSubSystemId("base");
        uiBean.setSyoriYmdFrom(BizDate.valueOf("20140525"));
        uiBean.setSyoriYmdTo(BizDate.valueOf("20140525"));
        uiBean.setBatchResultKbn(null);
        uiBean.setBatchJyoutai(true);

        action.searchBtnOnClick();

        List<BatchJobListDataSourceBean> batchJobList = uiBean.getBatchJobListDataSource().getAllData();
        exNumericEquals(batchJobList.size()         , 6                           , "バッチジョブ件数");
        BatchJobListDataSourceBean datasource = batchJobList.get(0);
        exStringEquals(datasource.getSubSystemNm()             , "管理機能"                   , "バッチジョブリスト：サブシステム名");
        exStringEquals(datasource.getCategoryNm()              , "システム管理バッチ"         , "バッチジョブリスト：カテゴリ名");
        exStringEquals(datasource.getKinouNm()                 , "過去データ整備"             , "バッチジョブリスト：機能名");
        exStringEquals(datasource.getBatchJobId()              , "000000aaaaa0054"            , "バッチジョブリスト：バッチジョブID");
        exClassificationEquals(datasource.getBatchKidouKbn()   , C_BatchKidouKbn.GAMEN        , "バッチジョブリスト：バッチ起動区分");
        exStringEquals(datasource.getBatchStartTime()          , editTime4View("20140525000000019")          , "バッチジョブリスト：開始時間");
        exStringEquals(datasource.getBatchEndTime()            , editTime4View("20140526235959900")          , "バッチジョブリスト：終了時間");
        exClassificationEquals(datasource.getBatchResultKbn()  , null                         , "バッチジョブリスト：バッチ結果区分");
        exClassificationEquals(datasource.getBatchJyoutaiKbn() , C_BatchJyoutaiKbn.TAIKI      , "バッチジョブリスト：バッチ状態区分");

        datasource = batchJobList.get(1);
        exStringEquals(datasource.getSubSystemNm()             , "管理機能"                   , "バッチジョブリスト：サブシステム名");
        exStringEquals(datasource.getCategoryNm()              , "システム管理バッチ"         , "バッチジョブリスト：カテゴリ名");
        exStringEquals(datasource.getKinouNm()                 , "過去データ整備"             , "バッチジョブリスト：機能名");
        exStringEquals(datasource.getBatchJobId()              , "000000aaaaa0055"            , "バッチジョブリスト：バッチジョブID");
        exClassificationEquals(datasource.getBatchKidouKbn()   , C_BatchKidouKbn.GAMEN        , "バッチジョブリスト：バッチ起動区分");
        exStringEquals(datasource.getBatchStartTime()          , editTime4View("20140525000000020")          , "バッチジョブリスト：開始時間");
        exStringEquals(datasource.getBatchEndTime()            , editTime4View("20140526235959900")          , "バッチジョブリスト：終了時間");
        exClassificationEquals(datasource.getBatchResultKbn()  , null                         , "バッチジョブリスト：バッチ結果区分");
        exClassificationEquals(datasource.getBatchJyoutaiKbn() , C_BatchJyoutaiKbn.SYORI      , "バッチジョブリスト：バッチ状態区分");

        datasource = batchJobList.get(2);
        exStringEquals(datasource.getSubSystemNm()             , "管理機能"                   , "バッチジョブリスト：サブシステム名");
        exStringEquals(datasource.getCategoryNm()              , "システム管理バッチ"         , "バッチジョブリスト：カテゴリ名");
        exStringEquals(datasource.getKinouNm()                 , "過去データ整備"             , "バッチジョブリスト：機能名");
        exStringEquals(datasource.getBatchJobId()              , "000000aaaaa0056"            , "バッチジョブリスト：バッチジョブID");
        exClassificationEquals(datasource.getBatchKidouKbn()   , C_BatchKidouKbn.GAMEN        , "バッチジョブリスト：バッチ起動区分");
        exStringEquals(datasource.getBatchStartTime()          , editTime4View("20140525000000021")          , "バッチジョブリスト：開始時間");
        exStringEquals(datasource.getBatchEndTime()            , editTime4View("20140526235959900")          , "バッチジョブリスト：終了時間");
        exClassificationEquals(datasource.getBatchResultKbn()  , null                         , "バッチジョブリスト：バッチ結果区分");
        exClassificationEquals(datasource.getBatchJyoutaiKbn() , C_BatchJyoutaiKbn.SYUURYOU_TYU      , "バッチジョブリスト：バッチ状態区分");

        datasource = batchJobList.get(3);
        exStringEquals(datasource.getSubSystemNm()             , "管理機能"                   , "バッチジョブリスト：サブシステム名");
        exStringEquals(datasource.getCategoryNm()              , "ログ管理"                   , "バッチジョブリスト：カテゴリ名");
        exStringEquals(datasource.getKinouNm()                 , "アクセスログ照会"           , "バッチジョブリスト：機能名");
        exStringEquals(datasource.getBatchJobId()              , "000000aaaaa0061"            , "バッチジョブリスト：バッチジョブID");
        exClassificationEquals(datasource.getBatchKidouKbn()   , C_BatchKidouKbn.GAMEN        , "バッチジョブリスト：バッチ起動区分");
        exStringEquals(datasource.getBatchStartTime()          , editTime4View("20140525000000026")          , "バッチジョブリスト：開始時間");
        exStringEquals(datasource.getBatchEndTime()            , editTime4View("20140526235959900")          , "バッチジョブリスト：終了時間");
        exClassificationEquals(datasource.getBatchResultKbn()  , null                         , "バッチジョブリスト：バッチ結果区分");
        exClassificationEquals(datasource.getBatchJyoutaiKbn() , C_BatchJyoutaiKbn.TAIKI      , "バッチジョブリスト：バッチ状態区分");
    }

    @Test
    @TestOrder(1090)
    public void gaiyouTest0090(){

        action.init();
        uiBean.setSubSystemId("bosyuu");
        uiBean.setSyoriYmdFrom(BizDate.valueOf("20140525"));
        uiBean.setSyoriYmdTo(BizDate.valueOf("20140525"));
        C_BatchResultKbn[] batchResults = new C_BatchResultKbn[]{C_BatchResultKbn.NORMAL
        };
        uiBean.setBatchResultKbn(batchResults);
        uiBean.setBatchJyoutai(false);

        action.searchBtnOnClick();

        List<BatchJobListDataSourceBean> batchJobList = uiBean.getBatchJobListDataSource().getAllData();
        exNumericEquals(batchJobList.size()         , 1                           , "バッチジョブ件数");
        BatchJobListDataSourceBean datasource = batchJobList.get(0);
        exStringEquals(datasource.getSubSystemNm()             , "保険募集"                   , "バッチジョブリスト：サブシステム名");
        exStringEquals(datasource.getCategoryNm()              , "保険設計"                   , "バッチジョブリスト：カテゴリ名");
        exStringEquals(datasource.getKinouNm()                 , "設計書作成"                 , "バッチジョブリスト：機能名");
        exStringEquals(datasource.getBatchJobId()              , "000000aaaaa0036"            , "バッチジョブリスト：バッチジョブID");
        exClassificationEquals(datasource.getBatchKidouKbn()   , C_BatchKidouKbn.GAMEN        , "バッチジョブリスト：バッチ起動区分");
        exStringEquals(datasource.getBatchStartTime()          , editTime4View("20140525000000001")          , "バッチジョブリスト：開始時間");
        exStringEquals(datasource.getBatchEndTime()            , editTime4View("20140526235959900")          , "バッチジョブリスト：終了時間");
        exClassificationEquals(datasource.getBatchResultKbn()  , C_BatchResultKbn.NORMAL      , "バッチジョブリスト：バッチ結果区分");
        exClassificationEquals(datasource.getBatchJyoutaiKbn() , C_BatchJyoutaiKbn.SYUURYOU   , "バッチジョブリスト：バッチ状態区分");
    }

    @Test
    @TestOrder(1100)
    public void gaiyouTest0100(){

        action.init();
        uiBean.setSubSystemId("bosyuu");
        uiBean.setSyoriYmdFrom(BizDate.valueOf("20140525"));
        uiBean.setSyoriYmdTo(BizDate.valueOf("20140525"));
        C_BatchResultKbn[] batchResults = new C_BatchResultKbn[]{C_BatchResultKbn.WARN
        };
        uiBean.setBatchResultKbn(batchResults);
        uiBean.setBatchJyoutai(false);

        action.searchBtnOnClick();

        List<BatchJobListDataSourceBean> batchJobList = uiBean.getBatchJobListDataSource().getAllData();
        exNumericEquals(batchJobList.size()         , 1                           , "バッチジョブ件数");
        BatchJobListDataSourceBean datasource = batchJobList.get(0);
        exStringEquals(datasource.getSubSystemNm()             , "保険募集"                   , "バッチジョブリスト：サブシステム名");
        exStringEquals(datasource.getCategoryNm()              , "保険設計"                   , "バッチジョブリスト：カテゴリ名");
        exStringEquals(datasource.getKinouNm()                 , "設計書作成"                 , "バッチジョブリスト：機能名");
        exStringEquals(datasource.getBatchJobId()              , "000000aaaaa0037"            , "バッチジョブリスト：バッチジョブID");
        exClassificationEquals(datasource.getBatchKidouKbn()   , C_BatchKidouKbn.GAMEN        , "バッチジョブリスト：バッチ起動区分");
        exStringEquals(datasource.getBatchStartTime()          , editTime4View("20140525000000002")          , "バッチジョブリスト：開始時間");
        exStringEquals(datasource.getBatchEndTime()            , editTime4View("20140526235959900")          , "バッチジョブリスト：終了時間");
        exClassificationEquals(datasource.getBatchResultKbn()  , C_BatchResultKbn.WARN      , "バッチジョブリスト：バッチ結果区分");
        exClassificationEquals(datasource.getBatchJyoutaiKbn() , C_BatchJyoutaiKbn.SYUURYOU   , "バッチジョブリスト：バッチ状態区分");
    }

    @Test
    @TestOrder(1110)
    public void gaiyouTest0110(){

        action.init();
        uiBean.setSubSystemId("bosyuu");
        uiBean.setSyoriYmdFrom(BizDate.valueOf("20140525"));
        uiBean.setSyoriYmdTo(BizDate.valueOf("20140525"));
        C_BatchResultKbn[] batchResults = new C_BatchResultKbn[]{C_BatchResultKbn.ERROR
        };
        uiBean.setBatchResultKbn(batchResults);
        uiBean.setBatchJyoutai(false);

        action.searchBtnOnClick();

        List<BatchJobListDataSourceBean> batchJobList = uiBean.getBatchJobListDataSource().getAllData();
        exNumericEquals(batchJobList.size()         , 1                           , "バッチジョブ件数");
        BatchJobListDataSourceBean datasource = batchJobList.get(0);
        exStringEquals(datasource.getSubSystemNm()             , "保険募集"                   , "バッチジョブリスト：サブシステム名");
        exStringEquals(datasource.getCategoryNm()              , "保険設計"                   , "バッチジョブリスト：カテゴリ名");
        exStringEquals(datasource.getKinouNm()                 , "設計書作成"                 , "バッチジョブリスト：機能名");
        exStringEquals(datasource.getBatchJobId()              , "000000aaaaa0038"            , "バッチジョブリスト：バッチジョブID");
        exClassificationEquals(datasource.getBatchKidouKbn()   , C_BatchKidouKbn.GAMEN        , "バッチジョブリスト：バッチ起動区分");
        exStringEquals(datasource.getBatchStartTime()          , editTime4View("20140525000000003")          , "バッチジョブリスト：開始時間");
        exStringEquals(datasource.getBatchEndTime()            , editTime4View("20140526235959900")          , "バッチジョブリスト：終了時間");
        exClassificationEquals(datasource.getBatchResultKbn()  , C_BatchResultKbn.ERROR      , "バッチジョブリスト：バッチ結果区分");
        exClassificationEquals(datasource.getBatchJyoutaiKbn() , C_BatchJyoutaiKbn.SYUURYOU   , "バッチジョブリスト：バッチ状態区分");
    }

    @Test
    @TestOrder(1120)
    public void gaiyouTest0120(){

        action.init();
        uiBean.setSubSystemId("bosyuu");
        uiBean.setSyoriYmdFrom(BizDate.valueOf("20140525"));
        uiBean.setSyoriYmdTo(BizDate.valueOf("20140525"));
        C_BatchResultKbn[] batchResults = new C_BatchResultKbn[]{C_BatchResultKbn.INTERRUPT
        };
        uiBean.setBatchResultKbn(batchResults);
        uiBean.setBatchJyoutai(false);

        action.searchBtnOnClick();

        List<BatchJobListDataSourceBean> batchJobList = uiBean.getBatchJobListDataSource().getAllData();
        exNumericEquals(batchJobList.size()         , 1                           , "バッチジョブ件数");
        BatchJobListDataSourceBean datasource = batchJobList.get(0);
        exStringEquals(datasource.getSubSystemNm()             , "保険募集"                   , "バッチジョブリスト：サブシステム名");
        exStringEquals(datasource.getCategoryNm()              , "保険設計"                   , "バッチジョブリスト：カテゴリ名");
        exStringEquals(datasource.getKinouNm()                 , "設計書作成"                 , "バッチジョブリスト：機能名");
        exStringEquals(datasource.getBatchJobId()              , "000000aaaaa0039"            , "バッチジョブリスト：バッチジョブID");
        exClassificationEquals(datasource.getBatchKidouKbn()   , C_BatchKidouKbn.GAMEN        , "バッチジョブリスト：バッチ起動区分");
        exStringEquals(datasource.getBatchStartTime()          , editTime4View("20140525000000004")          , "バッチジョブリスト：開始時間");
        exStringEquals(datasource.getBatchEndTime()            , editTime4View("20140526235959900")          , "バッチジョブリスト：終了時間");
        exClassificationEquals(datasource.getBatchResultKbn()  , C_BatchResultKbn.INTERRUPT      , "バッチジョブリスト：バッチ結果区分");
        exClassificationEquals(datasource.getBatchJyoutaiKbn() , C_BatchJyoutaiKbn.SYUURYOU   , "バッチジョブリスト：バッチ状態区分");
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1130)
    public void gaiyouTest0130(){

        action.init();
        uiBean.setSubSystemId("base");
        uiBean.setSyoriYmdFrom(BizDate.valueOf("20140525"));
        uiBean.setSyoriYmdTo(BizDate.valueOf("2014054"));
        C_BatchResultKbn[] batchResults = null;
        uiBean.setBatchResultKbn(batchResults);
        uiBean.setBatchJyoutai(true);

        try {
            action.searchBtnOnClick();
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage()     , "処理年月日（自）と処理年月日（至）の前後関係が不正です。"    , "メッセージ");
            throw e;
        }

        fail();
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1140)
    public void gaiyouTest0140(){

        action.init();
        uiBean.setSubSystemId("base");
        uiBean.setSyoriYmdFrom(BizDate.valueOf("20140524"));
        uiBean.setSyoriYmdTo(BizDate.valueOf("20140525"));
        C_BatchResultKbn[] batchResults = null;
        uiBean.setBatchResultKbn(batchResults);
        uiBean.setBatchJyoutai(false);

        try {
            action.searchBtnOnClick();
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage()     , "結果と状態から1つ以上選択してください。"    , "メッセージ");
            throw e;
        }

        fail();
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1150)
    public void gaiyouTest0150(){

        action.init();
        uiBean.setSubSystemId("base");
        uiBean.setSyoriYmdFrom(BizDate.valueOf("20991231"));
        uiBean.setSyoriYmdTo(BizDate.valueOf("20991231"));
        C_BatchResultKbn[] batchResults = null;
        uiBean.setBatchResultKbn(batchResults);
        uiBean.setBatchJyoutai(true);

        try {
            action.searchBtnOnClick();
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage()     , "指定された抽出条件に合致するデータは存在しません。"    , "メッセージ");
            throw e;
        }

        fail();
    }

    @Test
    @TestOrder(1170)
    public void gaiyouTest0170(){

        action.init();
        uiBean.setSubSystemId("base");
        uiBean.setSyoriYmdFrom(BizDate.valueOf("20140523"));
        uiBean.setSyoriYmdTo(BizDate.valueOf("20140523"));
        C_BatchResultKbn[] batchResults = new C_BatchResultKbn[]{C_BatchResultKbn.INTERRUPT
        };
        uiBean.setBatchResultKbn(batchResults);
        uiBean.setBatchJyoutai(false);

        action.kousinBtnOnClick();

        List<BatchJobListDataSourceBean> batchJobList = uiBean.getBatchJobListDataSource().getAllData();
        exNumericEquals(batchJobList.size()         , 2                           , "バッチジョブ件数");
        BatchJobListDataSourceBean datasource = batchJobList.get(0);
        exStringEquals(datasource.getSubSystemNm()             , "管理機能"                   , "バッチジョブリスト：サブシステム名");
        exStringEquals(datasource.getCategoryNm()              , "システム管理バッチ"         , "バッチジョブリスト：カテゴリ名");
        exStringEquals(datasource.getKinouNm()                 , "過去データ整備"             , "バッチジョブリスト：機能名");
        exStringEquals(datasource.getBatchJobId()              , "000000aaaaa0109"            , "バッチジョブリスト：バッチジョブID");
        exClassificationEquals(datasource.getBatchKidouKbn()   , C_BatchKidouKbn.GAMEN        , "バッチジョブリスト：バッチ起動区分");
        exStringEquals(datasource.getBatchStartTime()          , editTime4View("20140523000000018")          , "バッチジョブリスト：開始時間");
        exStringEquals(datasource.getBatchEndTime()            , editTime4View("20140526235959900")          , "バッチジョブリスト：終了時間");
        exClassificationEquals(datasource.getBatchResultKbn()  , C_BatchResultKbn.INTERRUPT   , "バッチジョブリスト：バッチ結果区分");
        exClassificationEquals(datasource.getBatchJyoutaiKbn() , C_BatchJyoutaiKbn.SYUURYOU   , "バッチジョブリスト：バッチ状態区分");

        datasource = batchJobList.get(1);
        exStringEquals(datasource.getSubSystemNm()             , "管理機能"                   , "バッチジョブリスト：サブシステム名");
        exStringEquals(datasource.getCategoryNm()              , "ログ管理"                   , "バッチジョブリスト：カテゴリ名");
        exStringEquals(datasource.getKinouNm()                 , "アクセスログ照会"           , "バッチジョブリスト：機能名");
        exStringEquals(datasource.getBatchJobId()              , "000000aaaaa0116"            , "バッチジョブリスト：バッチジョブID");
        exClassificationEquals(datasource.getBatchKidouKbn()   , C_BatchKidouKbn.GAMEN        , "バッチジョブリスト：バッチ起動区分");
        exStringEquals(datasource.getBatchStartTime()          , editTime4View("20140523000000025")          , "バッチジョブリスト：開始時間");
        exStringEquals(datasource.getBatchEndTime()            , editTime4View("20140526235959900")          , "バッチジョブリスト：終了時間");
        exClassificationEquals(datasource.getBatchResultKbn()  , C_BatchResultKbn.INTERRUPT                         , "バッチジョブリスト：バッチ結果区分");
        exClassificationEquals(datasource.getBatchJyoutaiKbn() , C_BatchJyoutaiKbn.SYUURYOU      , "バッチジョブリスト：バッチ状態区分");
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1180)
    public void gaiyouTest0180(){

        action.init();
        uiBean.setSubSystemId("base");
        uiBean.setSyoriYmdFrom(BizDate.valueOf("20991231"));
        uiBean.setSyoriYmdTo(BizDate.valueOf("20991231"));
        C_BatchResultKbn[] batchResults = null;
        uiBean.setBatchResultKbn(batchResults);
        uiBean.setBatchJyoutai(true);

        try {
            action.kousinBtnOnClick();
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage()     , "指定された抽出条件に合致するデータは存在しません。"    , "メッセージ");
            throw e;
        }

        fail();
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(1200)
    public void gaiyouTest0200(){

        action.init();
        uiBean.setSubSystemId("bosyuu");
        uiBean.setSyoriYmdFrom(null);
        uiBean.setSyoriYmdTo(BizDate.valueOf("20140525"));
        C_BatchResultKbn[] batchResults = new C_BatchResultKbn[]{C_BatchResultKbn.NORMAL,
            C_BatchResultKbn.WARN
        };
        uiBean.setBatchResultKbn(batchResults);
        uiBean.setBatchJyoutai(false);
        action.searchBtnOnClick();

        pageSeparate();

        uiBean.getBatchJobListDataSource().setSelectedIndex(1);

        action.syousaiLinkOnClick();

        exStringEquals(uiBean.getBatchJobId()           , "000000aaaaa0037"            , "バッチジョブID");
        //exNumericEquals(uiBean.getViewControlFlg()     , 0                            , "中断可否");
        exStringEquals(uiBean.getSubSystemNm(),    "保険募集"    , "サブシステム名");
        exStringEquals(uiBean.getCategoryNm(),     "保険設計"    , "カテゴリ名");
        exStringEquals(uiBean.getKinouNm(),        "設計書作成"  , "機能名");
        AT_BatchJob batchJob4Header = uiBean.getBatchJob();
        exClassificationEquals(batchJob4Header.getBatchKidouKbn(),  C_BatchKidouKbn.GAMEN, "バッチ起動区分");
        exDateEquals(batchJob4Header.getBatchSyoriYmd(), BizDate.valueOf("20140525"), "バッチ処理年月日");
        exStringEquals(batchJob4Header.getBatchStartTime(), editTime4View("20140525000000002")  , "開始");
        exStringEquals(batchJob4Header.getBatchEndTime(), editTime4View("20140526235959900")  , "終了");
        exClassificationEquals(batchJob4Header.getBatchResultKbn()  , C_BatchResultKbn.WARN           , "バッチ結果区分");
        exClassificationEquals(batchJob4Header.getBatchJyoutaiKbn() , C_BatchJyoutaiKbn.SYUURYOU      , "バッチ状態区分");
        exStringEquals(uiBean.getUserNm(), null  , "ユーザー名");
        List<BatchLogListDataSourceBean> logList = uiBean.getBatchLogListDataSource().getAllData();
        exNumericEquals(logList.size()         , 3                          , "バッチログ件数");
        BatchLogListDataSourceBean log = logList.get(0);
        exStringEquals(log.getLogOutputTime()        , editTime4View("20140525000000000")  , "ログ出力時間");
        exClassificationEquals(log.getLogLevelKbn()  , C_LogLevelKbn.INFO   , "ログレベル区分");
        exStringEquals(log.getLogNaiyou()            , "はじまり。"         , "ログ内容");
        log = logList.get(1);
        exStringEquals(log.getLogOutputTime()        , editTime4View("20140526235959700")  , "ログ出力時間");
        exClassificationEquals(log.getLogLevelKbn()  , C_LogLevelKbn.WARN   , "ログレベル区分");
        exStringEquals(log.getLogNaiyou()            , "１９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９" +
            "９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９" +
            "９９９９９９９９９９９９１９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９" +
            "９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９" +
            "９９９１９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９" +
            "９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９１９９９９９９" +
            "９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９" +
            "９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９１９９９９９９９９９９９９９９９９" +
            "９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９" +
            "９９９９９９９９９９９９９９９９９９９９９９９９９９９９１９９９９９９９９９９９９９９９９９９９９９９９９９９" +
            "９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９" +
            "９９９９９９９９９９９９９９９９９９１９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９" +
            "９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９" +
            "９９９９９９９９１９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９" +
            "９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９１９" +
            "９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９" +
            "９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９１９９９９９９９９９９９" +
            "９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９" +
            "９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９"           , "ログ内容");
        log = logList.get(2);
        exStringEquals(log.getLogOutputTime()        , editTime4View("20140526235959800")  , "ログ出力時間");
        exClassificationEquals(log.getLogLevelKbn()  , C_LogLevelKbn.ERROR  , "ログレベル区分");
        exStringEquals(log.getLogNaiyou()            , "おわり。"           , "ログ内容");

        //        List<BatchLogList4PrintDataSourceBean> logList4Print = uiBean.getBatchLogList4PrintDataSource().getAllData();
        //        exNumericEquals(logList4Print.size()         , 3                          , "バッチログ件数");
        //        BatchLogList4PrintDataSourceBean log4Print = logList4Print.get(0);
        //        exStringEquals(log4Print.getLogOutputTime()        , editTime4View("20140525000000000")  , "ログ出力時間");
        //        exClassificationEquals(log4Print.getLogLevelKbn()  , C_LogLevelKbn.INFO   , "ログレベル区分");
        //        exStringEquals(log4Print.getLogNaiyou()            , "はじまり。"         , "ログ内容");
        //        log4Print = logList4Print.get(1);
        //        exStringEquals(log4Print.getLogOutputTime()        , editTime4View("20140526235959700")  , "ログ出力時間");
        //        exClassificationEquals(log4Print.getLogLevelKbn()  , C_LogLevelKbn.WARN   , "ログレベル区分");
        //        exStringEquals(log4Print.getLogNaiyou()            , "１９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９" +
        //                "９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９" +
        //                "９９９９９９９９９９９９１９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９" +
        //                "９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９" +
        //                "９９９１９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９" +
        //                "９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９１９９９９９９" +
        //                "９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９" +
        //                "９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９１９９９９９９９９９９９９９９９９" +
        //                "９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９" +
        //                "９９９９９９９９９９９９９９９９９９９９９９９９９９９９１９９９９９９９９９９９９９９９９９９９９９９９９９９" +
        //                "９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９" +
        //                "９９９９９９９９９９９９９９９９９９１９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９" +
        //                "９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９" +
        //                "９９９９９９９９１９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９" +
        //                "９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９１９" +
        //                "９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９" +
        //                "９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９１９９９９９９９９９９９" +
        //                "９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９" +
        //                "９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９"           , "ログ内容");
        //        log4Print = logList4Print.get(2);
        //        exStringEquals(log4Print.getLogOutputTime()        , editTime4View("20140526235959800")  , "ログ出力時間");
        //        exClassificationEquals(log4Print.getLogLevelKbn()  , C_LogLevelKbn.ERROR  , "ログレベル区分");
        //        exStringEquals(log4Print.getLogNaiyou()            , "おわり。"           , "ログ内容");
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(1210)
    public void gaiyouTest0210(){

        action.init();
        uiBean.setSubSystemId("biz");
        uiBean.setSyoriYmdFrom(BizDate.valueOf("20140524"));
        uiBean.setSyoriYmdTo(BizDate.valueOf("20140525"));
        C_BatchResultKbn[] batchResults = new C_BatchResultKbn[]{C_BatchResultKbn.ERROR,
            C_BatchResultKbn.INTERRUPT
        };
        uiBean.setBatchResultKbn(batchResults);
        uiBean.setBatchJyoutai(false);

        action.searchBtnOnClick();

        pageSeparate();

        uiBean.getBatchJobListDataSource().setSelectedIndex(0);

        action.syousaiLinkOnClick();

        exStringEquals(uiBean.getBatchJobId()           , "000000aaaaa0045"            , "バッチジョブID");
        exStringEquals(uiBean.getSubSystemNm(),    "業務共通"    , "サブシステム名");
        exStringEquals(uiBean.getCategoryNm(),     "郵便番号検索"    , "カテゴリ名");
        exStringEquals(uiBean.getKinouNm(),        "郵便番号検索機能ＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＺ"  , "機能名");
        AT_BatchJob batchJob4Header = uiBean.getBatchJob();
        exClassificationEquals(batchJob4Header.getBatchKidouKbn(),  C_BatchKidouKbn.GAMEN, "バッチ起動区分");
        exDateEquals(batchJob4Header.getBatchSyoriYmd(), BizDate.valueOf("20140525"), "バッチ処理年月日");
        exStringEquals(batchJob4Header.getBatchStartTime(), editTime4View("20140525000000010")  , "開始");
        exStringEquals(batchJob4Header.getBatchEndTime(), editTime4View("20140526235959900")  , "終了");
        exClassificationEquals(batchJob4Header.getBatchResultKbn()  , C_BatchResultKbn.ERROR           , "バッチ結果区分");
        exClassificationEquals(batchJob4Header.getBatchJyoutaiKbn() , C_BatchJyoutaiKbn.SYUURYOU      , "バッチ状態区分");
        exStringEquals(uiBean.getUserNm(), null  , "ユーザー名");
        List<BatchLogListDataSourceBean> logList = uiBean.getBatchLogListDataSource().getAllData();
        exNumericEquals(logList.size()         , 0                          , "バッチログ件数");
        //        List<BatchLogList4PrintDataSourceBean> logList4Print = uiBean.getBatchLogList4PrintDataSource().getAllData();
        //        exNumericEquals(logList4Print.size()         , 0                          , "バッチログ件数");

        List<Message> messageList = messageManager.getMessages();
        exStringEquals(messageList.get(0).toString(), "該当するバッチログデータが存在しません。"  , "メッセージ");

    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(1211)
    public void gaiyouTest0211(){

        action.init();
        uiBean.setSubSystemId("bosyuu");
        uiBean.setSyoriYmdFrom(BizDate.valueOf("20140526"));
        uiBean.setSyoriYmdTo(BizDate.valueOf("20140526"));
        C_BatchResultKbn[] batchResults = null;
        uiBean.setBatchResultKbn(batchResults);
        uiBean.setBatchJyoutai(true);
        action.searchBtnOnClick();

        pageSeparate();

        uiBean.getBatchJobListDataSource().setSelectedIndex(0);

        action.syousaiLinkOnClick();

        exStringEquals(uiBean.getBatchJobId()           , "000000aaaaa0012"            , "バッチジョブID");
        //exNumericEquals(uiBean.getViewControlFlg()     , 1                            , "中断可否");
        exStringEquals(uiBean.getSubSystemNm(),    "保険募集"    , "サブシステム名");
        exStringEquals(uiBean.getCategoryNm(),     "保険設計"    , "カテゴリ名");
        exStringEquals(uiBean.getKinouNm(),        "設計書作成"  , "機能名");
        AT_BatchJob batchJob4Header = uiBean.getBatchJob();
        exClassificationEquals(batchJob4Header.getBatchResultKbn()  , null                         , "バッチ結果区分");
        exClassificationEquals(batchJob4Header.getBatchJyoutaiKbn() , C_BatchJyoutaiKbn.TAIKI      , "バッチ状態区分");
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(1212)
    public void gaiyouTest0212(){

        action.init();
        uiBean.setSubSystemId("base");
        uiBean.setSyoriYmdFrom(BizDate.valueOf("20140526"));
        uiBean.setSyoriYmdTo(BizDate.valueOf("20140526"));
        C_BatchResultKbn[] batchResults = new C_BatchResultKbn[]{C_BatchResultKbn.NORMAL
        };
        uiBean.setBatchResultKbn(batchResults);
        uiBean.setBatchJyoutai(false);
        action.searchBtnOnClick();

        pageSeparate();

        uiBean.getBatchJobListDataSource().setSelectedIndex(1);

        action.syousaiLinkOnClick();

        exStringEquals(uiBean.getBatchJobId()           , "000000aaaaa0029"            , "バッチジョブID");
        //exNumericEquals(uiBean.getViewControlFlg()     , 0                           , "中断可否");
        exStringEquals(uiBean.getSubSystemNm(),    "管理機能"    , "サブシステム名");
        exStringEquals(uiBean.getCategoryNm(),     "ログ管理"    , "カテゴリ名");
        exStringEquals(uiBean.getKinouNm(),        "アクセスログ照会"  , "機能名");
        AT_BatchJob batchJob4Header = uiBean.getBatchJob();
        exClassificationEquals(batchJob4Header.getBatchResultKbn()  , C_BatchResultKbn.NORMAL      , "バッチ結果区分");
        exClassificationEquals(batchJob4Header.getBatchJyoutaiKbn() , C_BatchJyoutaiKbn.SYUURYOU   , "バッチ状態区分");
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(1213)
    public void gaiyouTest0213(){

        action.init();
        uiBean.setSubSystemId("base");
        uiBean.setSyoriYmdFrom(BizDate.valueOf("20140526"));
        uiBean.setSyoriYmdTo(BizDate.valueOf("20140526"));
        C_BatchResultKbn[] batchResults = null;
        uiBean.setBatchResultKbn(batchResults);
        uiBean.setBatchJyoutai(true);
        action.searchBtnOnClick();

        pageSeparate();

        uiBean.getBatchJobListDataSource().setSelectedIndex(4);

        action.syousaiLinkOnClick();

        exStringEquals(uiBean.getBatchJobId()           , "000000aaaaa0034"            , "バッチジョブID");
        //exNumericEquals(uiBean.getViewControlFlg()     , 0                            , "中断可否");
        exStringEquals(uiBean.getSubSystemNm(),    "管理機能"    , "サブシステム名");
        exStringEquals(uiBean.getCategoryNm(),     "ログ管理"    , "カテゴリ名");
        exStringEquals(uiBean.getKinouNm(),        "アクセスログ照会"  , "機能名");
        AT_BatchJob batchJob4Header = uiBean.getBatchJob();
        exClassificationEquals(batchJob4Header.getBatchResultKbn()  , null                         , "バッチ結果区分");
        exClassificationEquals(batchJob4Header.getBatchJyoutaiKbn() , C_BatchJyoutaiKbn.SYORI      , "バッチ状態区分");
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(1220)
    public void gaiyouTest0220(){

        action.init();

        uiBean.setSyoriYmdFrom(BizDate.valueOf("20140527"));

        action.searchBtnOnClick();

        pageSeparate();

        uiBean.getBatchJobListDataSource().setSelectedIndex(0);

        //        String forward = action.tyohyoSyuturyokuLinkOnClick();

        //        exStringEquals(forward          , "Summary"            , "遷移先名称");
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(1230)
    public void gaiyouTest0230(){

        action.init();

        uiBean.setSyoriYmdFrom(BizDate.valueOf("20140527"));

        action.searchBtnOnClick();

        pageSeparate();

        uiBean.getBatchJobListDataSource().setSelectedIndex(1);

        //        String forward = action.tyohyoSyuturyokuLinkOnClick();

        //        exStringEquals(forward          , "ExError"            , "遷移先名称");
        List<Message> messageList = messageManager.getMessages();
        exStringEquals(messageList.get(0).toString(), "対象の帳票は既に削除されています。"  , "メッセージ");
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(2010)
    public void syousaiTest0010(){

        action.init();
        uiBean.setSubSystemId("biz");
        uiBean.setSyoriYmdFrom(BizDate.valueOf("20140524"));
        uiBean.setSyoriYmdTo(BizDate.valueOf("20140525"));
        C_BatchResultKbn[] batchResults = new C_BatchResultKbn[]{C_BatchResultKbn.ERROR,
            C_BatchResultKbn.INTERRUPT
        };
        uiBean.setBatchResultKbn(batchResults);
        uiBean.setBatchJyoutai(false);

        action.searchBtnOnClick();

        pageSeparate();

        uiBean.getBatchJobListDataSource().setSelectedIndex(0);

        action.syousaiLinkOnClick();

        exStringEquals(uiBean.getBatchJobId()           , "000000aaaaa0045"            , "バッチジョブID");

        pageSeparate();

        action.modoruBtnByGaiyouOnClick();

        String forward = action.modoruBtnByGaiyouOnClick();

        exStringEquals(forward          , "Summary"            , "遷移先名称");
        List<BatchJobListDataSourceBean> batchJobList = uiBean.getBatchJobListDataSource().getAllData();
        exNumericEquals(batchJobList.size()         , 4                           , "バッチジョブ件数");
        BatchJobListDataSourceBean datasource = batchJobList.get(0);
        exStringEquals(datasource.getSubSystemNm()             , "業務共通"                   , "バッチジョブリスト：サブシステム名");
        exStringEquals(datasource.getCategoryNm()              , "郵便番号検索"               , "バッチジョブリスト：カテゴリ名");
        exStringEquals(datasource.getKinouNm()                 , "郵便番号検索機能ＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＺ"                 , "バッチジョブリスト：機能名");
        exStringEquals(datasource.getBatchJobId()              , "000000aaaaa0045"            , "バッチジョブリスト：バッチジョブID");
        exClassificationEquals(datasource.getBatchKidouKbn()   , C_BatchKidouKbn.GAMEN        , "バッチジョブリスト：バッチ起動区分");
        exStringEquals(datasource.getBatchStartTime()          , editTime4View("20140525000000010")          , "バッチジョブリスト：開始時間");
        exStringEquals(datasource.getBatchEndTime()            , editTime4View("20140526235959900")          , "バッチジョブリスト：終了時間");
        exClassificationEquals(datasource.getBatchResultKbn()  , C_BatchResultKbn.ERROR       , "バッチジョブリスト：バッチ結果区分");
        exClassificationEquals(datasource.getBatchJyoutaiKbn() , C_BatchJyoutaiKbn.SYUURYOU   , "バッチジョブリスト：バッチ状態区分");

        datasource = batchJobList.get(1);
        exStringEquals(datasource.getSubSystemNm()             , "業務共通"                   , "バッチジョブリスト：サブシステム名");
        exStringEquals(datasource.getCategoryNm()              , "郵便番号検索"               , "バッチジョブリスト：カテゴリ名");
        exStringEquals(datasource.getKinouNm()                 , "郵便番号検索機能ＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＺ"                 , "バッチジョブリスト：機能名");
        exStringEquals(datasource.getBatchJobId()              , "000000aaaaa0046"            , "バッチジョブリスト：バッチジョブID");
        exClassificationEquals(datasource.getBatchKidouKbn()   , C_BatchKidouKbn.GAMEN        , "バッチジョブリスト：バッチ起動区分");
        exStringEquals(datasource.getBatchStartTime()          , editTime4View("20140525000000011")          , "バッチジョブリスト：開始時間");
        exStringEquals(datasource.getBatchEndTime()            , editTime4View("20140526235959900")          , "バッチジョブリスト：終了時間");
        exClassificationEquals(datasource.getBatchResultKbn()  , C_BatchResultKbn.INTERRUPT       , "バッチジョブリスト：バッチ結果区分");
        exClassificationEquals(datasource.getBatchJyoutaiKbn() , C_BatchJyoutaiKbn.SYUURYOU   , "バッチジョブリスト：バッチ状態区分");

        datasource = batchJobList.get(2);
        exStringEquals(datasource.getSubSystemNm()             , "業務共通"                   , "バッチジョブリスト：サブシステム名");
        exStringEquals(datasource.getCategoryNm()              , "郵便番号検索"               , "バッチジョブリスト：カテゴリ名");
        exStringEquals(datasource.getKinouNm()                 , "郵便番号検索機能ＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＺ"                 , "バッチジョブリスト：機能名");
        exStringEquals(datasource.getBatchJobId()              , "000000aaaaa0073"            , "バッチジョブリスト：バッチジョブID");
        exClassificationEquals(datasource.getBatchKidouKbn()   , C_BatchKidouKbn.GAMEN        , "バッチジョブリスト：バッチ起動区分");
        exStringEquals(datasource.getBatchStartTime()          , editTime4View("20140524000000010")          , "バッチジョブリスト：開始時間");
        exStringEquals(datasource.getBatchEndTime()            , editTime4View("20140526235959900")          , "バッチジョブリスト：終了時間");
        exClassificationEquals(datasource.getBatchResultKbn()  , C_BatchResultKbn.ERROR       , "バッチジョブリスト：バッチ結果区分");
        exClassificationEquals(datasource.getBatchJyoutaiKbn() , C_BatchJyoutaiKbn.SYUURYOU   , "バッチジョブリスト：バッチ状態区分");

        datasource = batchJobList.get(3);
        exStringEquals(datasource.getSubSystemNm()             , "業務共通"                   , "バッチジョブリスト：サブシステム名");
        exStringEquals(datasource.getCategoryNm()              , "郵便番号検索"               , "バッチジョブリスト：カテゴリ名");
        exStringEquals(datasource.getKinouNm()                 , "郵便番号検索機能ＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＺ"                 , "バッチジョブリスト：機能名");
        exStringEquals(datasource.getBatchJobId()              , "000000aaaaa0074"            , "バッチジョブリスト：バッチジョブID");
        exClassificationEquals(datasource.getBatchKidouKbn()   , C_BatchKidouKbn.GAMEN        , "バッチジョブリスト：バッチ起動区分");
        exStringEquals(datasource.getBatchStartTime()          , editTime4View("20140524000000011")          , "バッチジョブリスト：開始時間");
        exStringEquals(datasource.getBatchEndTime()            , editTime4View("20140526235959900")          , "バッチジョブリスト：終了時間");
        exClassificationEquals(datasource.getBatchResultKbn()  , C_BatchResultKbn.INTERRUPT       , "バッチジョブリスト：バッチ結果区分");
        exClassificationEquals(datasource.getBatchJyoutaiKbn() , C_BatchJyoutaiKbn.SYUURYOU   , "バッチジョブリスト：バッチ状態区分");

    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(2020)
    public void syousaiTest0020(){

        action.init();
        uiBean.setSubSystemId("bosyuu");
        uiBean.setSyoriYmdFrom(null);
        uiBean.setSyoriYmdTo(BizDate.valueOf("20140525"));
        C_BatchResultKbn[] batchResults = new C_BatchResultKbn[]{C_BatchResultKbn.NORMAL,
            C_BatchResultKbn.WARN
        };
        uiBean.setBatchResultKbn(batchResults);
        uiBean.setBatchJyoutai(false);
        action.searchBtnOnClick();

        pageSeparate();

        uiBean.getBatchJobListDataSource().setSelectedIndex(1);

        action.syousaiLinkOnClick();

        exStringEquals(uiBean.getBatchJobId()           , "000000aaaaa0037"            , "バッチジョブID");

        pageSeparate();

        action.insatuGamenBtnOnClick();

        exStringEquals(uiBean.getBatchJobId()           , "000000aaaaa0037"            , "バッチジョブID");
        exStringEquals(uiBean.getSubSystemNm(),    "保険募集"    , "サブシステム名");
        exStringEquals(uiBean.getCategoryNm(),     "保険設計"    , "カテゴリ名");
        exStringEquals(uiBean.getKinouNm(),        "設計書作成"  , "機能名");
        AT_BatchJob batchJob4Header = uiBean.getBatchJob();
        exClassificationEquals(batchJob4Header.getBatchKidouKbn(),  C_BatchKidouKbn.GAMEN, "バッチ起動区分");
        exDateEquals(batchJob4Header.getBatchSyoriYmd(), BizDate.valueOf("20140525"), "バッチ処理年月日");
        exStringEquals(batchJob4Header.getBatchStartTime(), editTime4View("20140525000000002")  , "開始");
        exStringEquals(batchJob4Header.getBatchEndTime(), editTime4View("20140526235959900")  , "終了");
        exClassificationEquals(batchJob4Header.getBatchResultKbn()  , C_BatchResultKbn.WARN           , "バッチ結果区分");
        exClassificationEquals(batchJob4Header.getBatchJyoutaiKbn() , C_BatchJyoutaiKbn.SYUURYOU      , "バッチ状態区分");
        exStringEquals(uiBean.getUserNm(), null  , "ユーザー名");
        List<BatchLogListDataSourceBean> logList = uiBean.getBatchLogListDataSource().getAllData();
        exNumericEquals(logList.size()         , 3                          , "バッチログ件数");
        BatchLogListDataSourceBean log = logList.get(0);
        exStringEquals(log.getLogOutputTime()        , editTime4View("20140525000000000")  , "ログ出力時間");
        exClassificationEquals(log.getLogLevelKbn()  , C_LogLevelKbn.INFO   , "ログレベル区分");
        exStringEquals(log.getLogNaiyou()            , "はじまり。"         , "ログ内容");
        log = logList.get(1);
        exStringEquals(log.getLogOutputTime()        , editTime4View("20140526235959700")  , "ログ出力時間");
        exClassificationEquals(log.getLogLevelKbn()  , C_LogLevelKbn.WARN   , "ログレベル区分");
        exStringEquals(log.getLogNaiyou()            , "１９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９" +
            "９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９" +
            "９９９９９９９９９９９９１９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９" +
            "９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９" +
            "９９９１９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９" +
            "９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９１９９９９９９" +
            "９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９" +
            "９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９１９９９９９９９９９９９９９９９９" +
            "９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９" +
            "９９９９９９９９９９９９９９９９９９９９９９９９９９９９１９９９９９９９９９９９９９９９９９９９９９９９９９９" +
            "９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９" +
            "９９９９９９９９９９９９９９９９９９１９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９" +
            "９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９" +
            "９９９９９９９９１９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９" +
            "９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９１９" +
            "９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９" +
            "９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９１９９９９９９９９９９９" +
            "９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９" +
            "９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９"           , "ログ内容");
        log = logList.get(2);
        exStringEquals(log.getLogOutputTime()        , editTime4View("20140526235959800")  , "ログ出力時間");
        exClassificationEquals(log.getLogLevelKbn()  , C_LogLevelKbn.ERROR  , "ログレベル区分");
        exStringEquals(log.getLogNaiyou()            , "おわり。"           , "ログ内容");

        //        List<BatchLogList4PrintDataSourceBean> logList4Print = uiBean.getBatchLogList4PrintDataSource().getAllData();
        //        exNumericEquals(logList4Print.size()         , 3                          , "バッチログ件数");
        //        BatchLogList4PrintDataSourceBean log4Print = logList4Print.get(0);
        //        exStringEquals(log4Print.getLogOutputTime()        , editTime4View("20140525000000000")  , "ログ出力時間");
        //        exClassificationEquals(log4Print.getLogLevelKbn()  , C_LogLevelKbn.INFO   , "ログレベル区分");
        //        exStringEquals(log4Print.getLogNaiyou()            , "はじまり。"         , "ログ内容");
        //        log4Print = logList4Print.get(1);
        //        exStringEquals(log4Print.getLogOutputTime()        , editTime4View("20140526235959700")  , "ログ出力時間");
        //        exClassificationEquals(log4Print.getLogLevelKbn()  , C_LogLevelKbn.WARN   , "ログレベル区分");
        //        exStringEquals(log4Print.getLogNaiyou()            , "１９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９" +
        //                "９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９" +
        //                "９９９９９９９９９９９９１９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９" +
        //                "９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９" +
        //                "９９９１９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９" +
        //                "９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９１９９９９９９" +
        //                "９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９" +
        //                "９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９１９９９９９９９９９９９９９９９９" +
        //                "９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９" +
        //                "９９９９９９９９９９９９９９９９９９９９９９９９９９９９１９９９９９９９９９９９９９９９９９９９９９９９９９９" +
        //                "９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９" +
        //                "９９９９９９９９９９９９９９９９９９１９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９" +
        //                "９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９" +
        //                "９９９９９９９９１９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９" +
        //                "９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９１９" +
        //                "９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９" +
        //                "９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９１９９９９９９９９９９９" +
        //                "９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９" +
        //                "９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９９"           , "ログ内容");
        //        log4Print = logList4Print.get(2);
        //        exStringEquals(log4Print.getLogOutputTime()        , editTime4View("20140526235959800")  , "ログ出力時間");
        //        exClassificationEquals(log4Print.getLogLevelKbn()  , C_LogLevelKbn.ERROR  , "ログレベル区分");
        //        exStringEquals(log4Print.getLogNaiyou()            , "おわり。"           , "ログ内容");
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(2030)
    public void syousaiTest0030(){

        action.init();
        uiBean.setSubSystemId("biz");
        uiBean.setSyoriYmdFrom(BizDate.valueOf("20140524"));
        uiBean.setSyoriYmdTo(BizDate.valueOf("20140525"));
        C_BatchResultKbn[] batchResults = new C_BatchResultKbn[]{C_BatchResultKbn.ERROR,
            C_BatchResultKbn.INTERRUPT
        };
        uiBean.setBatchResultKbn(batchResults);
        uiBean.setBatchJyoutai(false);

        action.searchBtnOnClick();

        pageSeparate();

        uiBean.getBatchJobListDataSource().setSelectedIndex(0);

        action.syousaiLinkOnClick();

        exStringEquals(uiBean.getBatchJobId()           , "000000aaaaa0045"            , "バッチジョブID");

        pageSeparate();

        action.insatuGamenBtnOnClick();

        exStringEquals(uiBean.getBatchJobId()           , "000000aaaaa0045"            , "バッチジョブID");
        exStringEquals(uiBean.getSubSystemNm(),    "業務共通"    , "サブシステム名");
        exStringEquals(uiBean.getCategoryNm(),     "郵便番号検索"    , "カテゴリ名");
        exStringEquals(uiBean.getKinouNm(),        "郵便番号検索機能ＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＸＺ"  , "機能名");
        AT_BatchJob batchJob4Header = uiBean.getBatchJob();
        exClassificationEquals(batchJob4Header.getBatchKidouKbn(),  C_BatchKidouKbn.GAMEN, "バッチ起動区分");
        exDateEquals(batchJob4Header.getBatchSyoriYmd(), BizDate.valueOf("20140525"), "バッチ処理年月日");
        exStringEquals(batchJob4Header.getBatchStartTime(), editTime4View("20140525000000010")  , "開始");
        exStringEquals(batchJob4Header.getBatchEndTime(), editTime4View("20140526235959900")  , "終了");
        exClassificationEquals(batchJob4Header.getBatchResultKbn()  , C_BatchResultKbn.ERROR           , "バッチ結果区分");
        exClassificationEquals(batchJob4Header.getBatchJyoutaiKbn() , C_BatchJyoutaiKbn.SYUURYOU      , "バッチ状態区分");
        exStringEquals(uiBean.getUserNm(), null  , "ユーザー名");
        List<BatchLogListDataSourceBean> logList = uiBean.getBatchLogListDataSource().getAllData();
        exNumericEquals(logList.size()         , 0                          , "バッチログ件数");
        //        List<BatchLogList4PrintDataSourceBean> logList4Print = uiBean.getBatchLogList4PrintDataSource().getAllData();
        //        exNumericEquals(logList4Print.size()         , 0                          , "バッチログ件数");
    }


    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(2040)
    public void syousaiTest0040(){


        action.init();

        uiBean.setSyoriYmdFrom(BizDate.valueOf("20140527"));

        action.searchBtnOnClick();

        pageSeparate();

        uiBean.getBatchJobListDataSource().setSelectedIndex(4);

        action.syousaiLinkOnClick();

        exStringEquals(uiBean.getBatchJobId()           , "000000aaaaa0005"            , "バッチジョブID");
        AT_BatchJob batchJob4Header = uiBean.getBatchJob();
        exClassificationEquals(batchJob4Header.getBatchJyoutaiKbn() , C_BatchJyoutaiKbn.TAIKI      , "バッチ状態区分");

        pageSeparate();

        action.tyuudanBtnOnClick();

        List<Message> messageList = messageManager.getMessages();
        exStringEquals(messageList.get(0).toString(), "中断指示が完了しました。しばらく経ってから結果を確認してください。"  , "メッセージ");

    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(2050)
    public void syousaiTest0050(){

        action.init();

        uiBean.setSyoriYmdFrom(BizDate.valueOf("20140527"));

        action.searchBtnOnClick();

        pageSeparate();
        uiBean.getBatchJobListDataSource().setSelectedIndex(5);

        action.syousaiLinkOnClick();

        pageSeparate();

        exStringEquals(uiBean.getBatchJobId()           , "000000aaaaa0006"            , "バッチジョブID");
        AT_BatchJob batchJob4Header = uiBean.getBatchJob();
        exClassificationEquals(batchJob4Header.getBatchJyoutaiKbn() , C_BatchJyoutaiKbn.SYORI      , "バッチ状態区分");

        action.tyuudanBtnOnClick();

        List<Message> messageList = messageManager.getMessages();
        exStringEquals(messageList.get(0).toString(), "中断指示が完了しました。しばらく経ってから結果を確認してください。"  , "メッセージ");

    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(2060)
    public void syousaiTest0060(){

        action.init();

        uiBean.setSyoriYmdFrom(BizDate.valueOf("20140527"));

        action.searchBtnOnClick();

        pageSeparate();

        uiBean.getBatchJobListDataSource().setSelectedIndex(6);

        action.syousaiLinkOnClick();

        pageSeparate();

        exStringEquals(uiBean.getBatchJobId()           , "000000aaaaa0007"            , "バッチジョブID");
        AT_BatchJob batchJob4Header = uiBean.getBatchJob();
        exClassificationEquals(batchJob4Header.getBatchJyoutaiKbn() , C_BatchJyoutaiKbn.SYUURYOU_TYU      , "バッチ状態区分");

        action.tyuudanBtnOnClick();

        List<Message> messageList = messageManager.getMessages();
        exStringEquals(messageList.get(0).toString(), "中断指示が完了しました。しばらく経ってから結果を確認してください。"  , "メッセージ");

    }

    @SuppressWarnings("deprecation")
    @Test(expected = BizLogicException.class)
    @TestOrder(2070)
    public void syousaiTest0070(){

        action.init();

        uiBean.setSyoriYmdFrom(BizDate.valueOf("20140527"));

        action.searchBtnOnClick();

        pageSeparate();

        uiBean.getBatchJobListDataSource().setSelectedIndex(0);

        action.syousaiLinkOnClick();

        pageSeparate();

        exStringEquals(uiBean.getBatchJobId()           , "000000aaaaa0001"            , "バッチジョブID");
        AT_BatchJob batchJob4Header = uiBean.getBatchJob();
        exClassificationEquals(batchJob4Header.getBatchJyoutaiKbn() , C_BatchJyoutaiKbn.SYUURYOU      , "バッチ状態区分");

        try {
            action.tyuudanBtnOnClick();
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "対象のバッチジョブは既に終了しています。"  , "メッセージ");
            throw e;
        }
        fail();
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(4010)
    public void errorTest0010(){

        action.init();
        uiBean.setSubSystemId("base");
        uiBean.setSyoriYmdFrom(BizDate.valueOf("20140525"));
        uiBean.setSyoriYmdTo(BizDate.valueOf("20140525"));
        C_BatchResultKbn[] batchResults = null;
        uiBean.setBatchResultKbn(batchResults);
        uiBean.setBatchJyoutai(true);

        action.searchBtnOnClick();

        pageSeparate();

        uiBean.getBatchJobListDataSource().setSelectedIndex(0);

        //        action.tyohyoSyuturyokuLinkOnClick();

        pageSeparate();

        exStringEquals(uiBean.getBatchJobId()           , "000000aaaaa0054"            , "バッチジョブID");

        action.modoruBtnByGaiyouOnClick();

        List<BatchJobListDataSourceBean> batchJobList = uiBean.getBatchJobListDataSource().getAllData();
        exNumericEquals(batchJobList.size()         , 6                           , "バッチジョブ件数");
        BatchJobListDataSourceBean datasource = batchJobList.get(0);
        exStringEquals(datasource.getSubSystemNm()             , "管理機能"                   , "バッチジョブリスト：サブシステム名");
        exStringEquals(datasource.getCategoryNm()              , "システム管理バッチ"         , "バッチジョブリスト：カテゴリ名");
        exStringEquals(datasource.getKinouNm()                 , "過去データ整備"             , "バッチジョブリスト：機能名");
        exStringEquals(datasource.getBatchJobId()              , "000000aaaaa0054"            , "バッチジョブリスト：バッチジョブID");
        exClassificationEquals(datasource.getBatchKidouKbn()   , C_BatchKidouKbn.GAMEN        , "バッチジョブリスト：バッチ起動区分");
        exStringEquals(datasource.getBatchStartTime()          , editTime4View("20140525000000019")          , "バッチジョブリスト：開始時間");
        exStringEquals(datasource.getBatchEndTime()            , editTime4View("20140526235959900")          , "バッチジョブリスト：終了時間");
        exClassificationEquals(datasource.getBatchResultKbn()  , null                         , "バッチジョブリスト：バッチ結果区分");
        exClassificationEquals(datasource.getBatchJyoutaiKbn() , C_BatchJyoutaiKbn.TAIKI      , "バッチジョブリスト：バッチ状態区分");

        datasource = batchJobList.get(1);
        exStringEquals(datasource.getSubSystemNm()             , "管理機能"                   , "バッチジョブリスト：サブシステム名");
        exStringEquals(datasource.getCategoryNm()              , "システム管理バッチ"         , "バッチジョブリスト：カテゴリ名");
        exStringEquals(datasource.getKinouNm()                 , "過去データ整備"             , "バッチジョブリスト：機能名");
        exStringEquals(datasource.getBatchJobId()              , "000000aaaaa0055"            , "バッチジョブリスト：バッチジョブID");
        exClassificationEquals(datasource.getBatchKidouKbn()   , C_BatchKidouKbn.GAMEN        , "バッチジョブリスト：バッチ起動区分");
        exStringEquals(datasource.getBatchStartTime()          , editTime4View("20140525000000020")          , "バッチジョブリスト：開始時間");
        exStringEquals(datasource.getBatchEndTime()            , editTime4View("20140526235959900")          , "バッチジョブリスト：終了時間");
        exClassificationEquals(datasource.getBatchResultKbn()  , null                         , "バッチジョブリスト：バッチ結果区分");
        exClassificationEquals(datasource.getBatchJyoutaiKbn() , C_BatchJyoutaiKbn.SYORI      , "バッチジョブリスト：バッチ状態区分");

        datasource = batchJobList.get(2);
        exStringEquals(datasource.getSubSystemNm()             , "管理機能"                   , "バッチジョブリスト：サブシステム名");
        exStringEquals(datasource.getCategoryNm()              , "システム管理バッチ"         , "バッチジョブリスト：カテゴリ名");
        exStringEquals(datasource.getKinouNm()                 , "過去データ整備"             , "バッチジョブリスト：機能名");
        exStringEquals(datasource.getBatchJobId()              , "000000aaaaa0056"            , "バッチジョブリスト：バッチジョブID");
        exClassificationEquals(datasource.getBatchKidouKbn()   , C_BatchKidouKbn.GAMEN        , "バッチジョブリスト：バッチ起動区分");
        exStringEquals(datasource.getBatchStartTime()          , editTime4View("20140525000000021")         , "バッチジョブリスト：開始時間");
        exStringEquals(datasource.getBatchEndTime()            , editTime4View("20140526235959900")          , "バッチジョブリスト：終了時間");
        exClassificationEquals(datasource.getBatchResultKbn()  , null                         , "バッチジョブリスト：バッチ結果区分");
        exClassificationEquals(datasource.getBatchJyoutaiKbn() , C_BatchJyoutaiKbn.SYUURYOU_TYU      , "バッチジョブリスト：バッチ状態区分");

        datasource = batchJobList.get(3);
        exStringEquals(datasource.getSubSystemNm()             , "管理機能"                   , "バッチジョブリスト：サブシステム名");
        exStringEquals(datasource.getCategoryNm()              , "ログ管理"                   , "バッチジョブリスト：カテゴリ名");
        exStringEquals(datasource.getKinouNm()                 , "アクセスログ照会"           , "バッチジョブリスト：機能名");
        exStringEquals(datasource.getBatchJobId()              , "000000aaaaa0061"            , "バッチジョブリスト：バッチジョブID");
        exClassificationEquals(datasource.getBatchKidouKbn()   , C_BatchKidouKbn.GAMEN        , "バッチジョブリスト：バッチ起動区分");
        exStringEquals(datasource.getBatchStartTime()          , editTime4View("20140525000000026")          , "バッチジョブリスト：開始時間");
        exStringEquals(datasource.getBatchEndTime()            , editTime4View("20140526235959900")          , "バッチジョブリスト：終了時間");
        exClassificationEquals(datasource.getBatchResultKbn()  , null                         , "バッチジョブリスト：バッチ結果区分");
        exClassificationEquals(datasource.getBatchJyoutaiKbn() , C_BatchJyoutaiKbn.TAIKI      , "バッチジョブリスト：バッチ状態区分");
    }

    private String editTime4View(String pTime) {

        if (pTime == null) {
            return null;
        }

        if (pTime.length() != 17) {
            return null;
        }
        String ymd = pTime.substring(0, 8);
        BizDateFormat format = new BizDateFormat("G.yy/MM/dd");
        ymd = format.format(BizDate.valueOf(ymd));

        return ymd + " " + pTime.substring(8, 10) + ":" + pTime.substring(10, 12) + ":" + pTime.substring(12, 14);
    }
}
