package yuyu.common.siharai.syoruitoutyaku;

import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.workflow.IwfImageClient;
import yuyu.common.biz.workflow.IwfImageClientMockForSiharai;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 保険金給付金支払書類到着時工程操作処理クラスのメソッド {@link SiharaiSyoruitoutyakuOperateProcess#doujiSeikyuu(String, String, C_SyoruiCdKbn)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SiharaiSyoruitoutyakuOperateProcessTest_doujiSeikyuu {

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(IwfImageClient.class).to(IwfImageClientMockForSiharai.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        IwfImageClientMockForSiharai.caller = "Test";
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        IwfImageClientMockForSiharai.caller = null;
        IwfImageClientMockForSiharai.mode = null;
    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testDoujiSeikyuu_A3() {
        IwfImageClientMockForSiharai.mode = "dl01-01";

        String pImageId = "101";
        String pKouteiKanriId = "10071";

        SiharaiSyoruitoutyakuOperateProcess siharaiSyoruitoutyakuOperateProcess = SWAKInjector.getInstance(
            SiharaiSyoruitoutyakuOperateProcess.class);
        siharaiSyoruitoutyakuOperateProcess.doujiSeikyuu(pImageId, pKouteiKanriId, C_SyoruiCdKbn.HK_KD_JIKOJKS);
    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testDoujiSeikyuu_A4() {
        IwfImageClientMockForSiharai.mode = "dl01-01";

        String pImageId = "101";
        String pKouteiKanriId = "10051";

        SiharaiSyoruitoutyakuOperateProcess siharaiSyoruitoutyakuOperateProcess = SWAKInjector.getInstance(
            SiharaiSyoruitoutyakuOperateProcess.class);
        siharaiSyoruitoutyakuOperateProcess.doujiSeikyuu(pImageId, pKouteiKanriId, C_SyoruiCdKbn.HK_KD_JIKOJKS);
    }
}
