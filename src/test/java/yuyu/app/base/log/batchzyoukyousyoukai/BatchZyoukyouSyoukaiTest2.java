package yuyu.app.base.log.batchzyoukyousyoukai;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.log.batchjyoukyousyoukai.BatchJyoukyouSyoukaiAction;
import yuyu.app.base.log.batchjyoukyousyoukai.BatchJyoukyouSyoukaiUiBean;
import yuyu.def.classification.C_BatchResultKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * {@link #syousaiTest0040()} ～ {@link #syousaiTest0060()}のケースは、実行前にバッチサーバを起動してください。
 */
@RunWith(OrderedRunner.class)
public class BatchZyoukyouSyoukaiTest2 extends AbstractTest {

    @Inject
    private BatchJyoukyouSyoukaiAction action;

    @Inject
    private BatchJyoukyouSyoukaiUiBean uiBean;

    @Test(expected = BizLogicException.class)
    @TestOrder(1012)
    public void gaiyouTest0012(){

        changeSystemDate(BizDate.valueOf("19600101"));

        try {
            action.init();
        } catch (BizLogicException e) {

            exStringEquals(uiBean.getSubSystemId()      , null                        , "サブシステムID");
            exDateEquals(uiBean.getSyoriYmdFrom()       , BizDate.valueOf("19591231") , "処理年月日（自）");
            exDateEquals(uiBean.getSyoriYmdTo()         , null                        , "処理年月日（至）");
            C_BatchResultKbn[] batchResultKbns = uiBean.getBatchResultKbn();
            exClassificationEquals(batchResultKbns[0]   , C_BatchResultKbn.NORMAL     , "バッチ結果区分_正常");
            exClassificationEquals(batchResultKbns[1]   , C_BatchResultKbn.WARN       , "バッチ結果区分_警告");
            exClassificationEquals(batchResultKbns[2]   , C_BatchResultKbn.ERROR      , "バッチ結果区分_エラー");
            exClassificationEquals(batchResultKbns[3]   , C_BatchResultKbn.INTERRUPT  , "バッチ結果区分_中断");
            exBooleanEquals(uiBean.getBatchJyoutai() ,  true                       , "バッチ状態区分");
            exClassificationEquals(uiBean.getJidouKousinUmuFlg(), C_UmuKbn.ARI, "自動更新有無フラグ");

            changeSystemDate(BizDate.valueOf("20500101"));

            throw e;
        }
        changeSystemDate(BizDate.valueOf("20500101"));
        fail();
    }

    @Test
    @TestOrder(1040)
    public void gaiyouTest0040(){
        changeSystemDate(BizDate.valueOf("20500101"));
        action.init();
        uiBean.setSubSystemId(null);
        uiBean.setSyoriYmdFrom(BizDate.valueOf("19600101"));
        uiBean.setSyoriYmdTo(null);
        C_BatchResultKbn[] batchResults = new C_BatchResultKbn[]{C_BatchResultKbn.NORMAL,
            C_BatchResultKbn.WARN,
            C_BatchResultKbn.ERROR,
            C_BatchResultKbn.INTERRUPT
        };
        uiBean.setBatchResultKbn(batchResults);
        uiBean.setBatchJyoutai(true);
        action.searchBtnOnClick();
        exNumericEquals(uiBean.getBatchJobListDataSource().getAllData().size(), 1000, "バッチジョブ件数");
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1160)
    public void gaiyouTest0160(){

        action.init();
        uiBean.setSubSystemId(null);
        uiBean.setSyoriYmdFrom(null);
        uiBean.setSyoriYmdTo(null);
        C_BatchResultKbn[] batchResults = new C_BatchResultKbn[]{C_BatchResultKbn.NORMAL,
            C_BatchResultKbn.WARN,
            C_BatchResultKbn.ERROR,
            C_BatchResultKbn.INTERRUPT
        };
        uiBean.setBatchResultKbn(batchResults);
        uiBean.setBatchJyoutai(true);

        try {
            action.searchBtnOnClick();
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage()     , "検索結果が多すぎます。条件を絞ってください。"    , "メッセージ");
            throw e;
        }

        fail();
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1190)
    public void gaiyouTest0190(){

        action.init();
        uiBean.setSubSystemId(null);
        uiBean.setSyoriYmdFrom(null);
        uiBean.setSyoriYmdTo(null);
        C_BatchResultKbn[] batchResults = new C_BatchResultKbn[]{C_BatchResultKbn.NORMAL,
            C_BatchResultKbn.WARN,
            C_BatchResultKbn.ERROR,
            C_BatchResultKbn.INTERRUPT
        };
        uiBean.setBatchResultKbn(batchResults);
        uiBean.setBatchJyoutai(true);

        try {
            action.kousinBtnOnClick();
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage()     , "検索結果が多すぎます。条件を絞ってください。"    , "メッセージ");
            throw e;
        }

        fail();
    }
}
