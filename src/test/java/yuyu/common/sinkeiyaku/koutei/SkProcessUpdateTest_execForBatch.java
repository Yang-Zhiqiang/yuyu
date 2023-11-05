package yuyu.common.sinkeiyaku.koutei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.bzcommon.BzProcessUpdateForBatch;
import yuyu.common.biz.bzcommon.BzProcessUpdateForBatchInputBean;
import yuyu.common.biz.bzcommon.BzProcessUpdateForBatchMockForSinkeiyaku;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.classification.C_UmuKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * SkProcessUpdateクラスのメソッド {@link SkProcessUpdate#execForBatch(List<BzProcessUpdateForBatchInputBean>)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class SkProcessUpdateTest_execForBatch {

    @Inject
    private SkProcessUpdate skProcessUpdate;

    @Before
    public void Before () {
        MockModuleBinder.bind(new AbstractModule() {
            @Override
            protected void configure() {

                bind(BzProcessUpdateForBatch.class).to(BzProcessUpdateForBatchMockForSinkeiyaku.class);

            }
        });
    }
    @BeforeClass
    public static void testInit() {
        BzProcessUpdateForBatchMockForSinkeiyaku.caller = SkProcessUpdateTest_execForBatch.class;

    }

    @AfterClass
    public static void testClear() {

        BzProcessUpdateForBatchMockForSinkeiyaku.caller = null;
        BzProcessUpdateForBatchMockForSinkeiyaku.SYORIPTN = null;
        MockObjectManager.initialize();
    }

    @Test
    @TestOrder(10)
    public void testExecForBatch_A1() {
        List<BzProcessUpdateForBatchInputBean> bzProcessUpdateForBatchInputBeanList = null;

        skProcessUpdate.execForBatch(bzProcessUpdateForBatchInputBeanList);

        MockObjectManager.assertNotCalled(BzProcessUpdateForBatch.class, "exec");

    }

    @Test
    @TestOrder(20)
    public void testExecForBatch_A2() {
        List<BzProcessUpdateForBatchInputBean> bzProcessUpdateForBatchInputBeanList = new ArrayList<>();

        skProcessUpdate.execForBatch(bzProcessUpdateForBatchInputBeanList);

        MockObjectManager.assertNotCalled(BzProcessUpdateForBatch.class, "exec");

    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(30)
    public void testExecForBatch_A3() {

        BzProcessUpdateForBatchMockForSinkeiyaku.SYORIPTN = BzProcessUpdateForBatchMockForSinkeiyaku.TESTPATTERN1;

        List<BzProcessUpdateForBatchInputBean> bzProcessUpdateForBatchInputBeanList = new ArrayList<>();
        BzProcessUpdateForBatchInputBean bzProcessUpdateForBatchInputBean = new BzProcessUpdateForBatchInputBean();
        bzProcessUpdateForBatchInputBean.setKokouteiUpdumu(C_UmuKbn.NONE);
        bzProcessUpdateForBatchInputBean.setKouteiKanriId("1003");
        bzProcessUpdateForBatchInputBean.setJimuTetuzukiCd("skmaindairiten");

        bzProcessUpdateForBatchInputBeanList.add(bzProcessUpdateForBatchInputBean);

        try {

            skProcessUpdate.execForBatch(bzProcessUpdateForBatchInputBeanList);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。詳細メッセージコード=IWF9999 詳細メッセージ=異常終了 工程管理ＩＤ=1113", "エラーメッセージ");
            throw e;
        }

    }

    @Test
    @TestOrder(40)
    public void testExecForBatch_A4() {
        MockObjectManager.initialize();
        BzProcessUpdateForBatchMockForSinkeiyaku.SYORIPTN = BzProcessUpdateForBatchMockForSinkeiyaku.TESTPATTERN2;

        List<BzProcessUpdateForBatchInputBean> bzProcessUpdateForBatchInputBeanList = new ArrayList<>();
        BzProcessUpdateForBatchInputBean bzProcessUpdateForBatchInputBean1 = new BzProcessUpdateForBatchInputBean();
        bzProcessUpdateForBatchInputBean1.setKokouteiUpdumu(C_UmuKbn.NONE);
        bzProcessUpdateForBatchInputBean1.setKouteiKanriId("1004");
        bzProcessUpdateForBatchInputBean1.setJimuTetuzukiCd("skmaindairiten");
        bzProcessUpdateForBatchInputBeanList.add(bzProcessUpdateForBatchInputBean1);

        BzProcessUpdateForBatchInputBean bzProcessUpdateForBatchInputBean2 = new BzProcessUpdateForBatchInputBean();
        bzProcessUpdateForBatchInputBean2.setKokouteiUpdumu(C_UmuKbn.ARI);
        bzProcessUpdateForBatchInputBean2.setKouteiKanriId("2004");
        bzProcessUpdateForBatchInputBean2.setJimuTetuzukiCd("skinputmos");
        bzProcessUpdateForBatchInputBeanList.add(bzProcessUpdateForBatchInputBean2);

        BzProcessUpdateForBatchInputBean bzProcessUpdateForBatchInputBean3 = new BzProcessUpdateForBatchInputBean();
        bzProcessUpdateForBatchInputBean3.setKokouteiUpdumu(C_UmuKbn.NONE);
        bzProcessUpdateForBatchInputBean3.setKouteiKanriId("3004");
        bzProcessUpdateForBatchInputBean3.setJimuTetuzukiCd("sktenken");
        bzProcessUpdateForBatchInputBeanList.add(bzProcessUpdateForBatchInputBean3);

        skProcessUpdate.execForBatch(bzProcessUpdateForBatchInputBeanList);

        List<BzProcessUpdateForBatchInputBean> inputBeanList = (List<BzProcessUpdateForBatchInputBean>)MockObjectManager.getArgument(BzProcessUpdateForBatchMockForSinkeiyaku.class, "exec", 0, 0);

        exClassificationEquals(inputBeanList.get(0).getKokouteiUpdumu(), C_UmuKbn.NONE, "子工程更新有無区分");
        exStringEquals(inputBeanList.get(0).getKouteiKanriId(), "1004", "工程管理ID");
        exStringEquals(inputBeanList.get(0).getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");

        exClassificationEquals(inputBeanList.get(1).getKokouteiUpdumu(), C_UmuKbn.ARI, "子工程更新有無区分");
        exStringEquals(inputBeanList.get(1).getKouteiKanriId(), "2004", "工程管理ID");
        exStringEquals(inputBeanList.get(1).getJimuTetuzukiCd(), "skinputmos", "事務手続コード");

        exClassificationEquals(inputBeanList.get(2).getKokouteiUpdumu(), C_UmuKbn.NONE, "子工程更新有無区分");
        exStringEquals(inputBeanList.get(2).getKouteiKanriId(), "3004", "工程管理ID");
        exStringEquals(inputBeanList.get(2).getJimuTetuzukiCd(), "sktenken", "事務手続コード");

    }
}
