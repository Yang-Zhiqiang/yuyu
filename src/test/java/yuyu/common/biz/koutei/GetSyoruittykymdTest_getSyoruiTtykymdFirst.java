package yuyu.common.biz.koutei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.workflow.IwfImageClient;
import yuyu.common.biz.workflow.IwfImageClientMockForBiz;
import yuyu.common.biz.workflow.io.image.GetImagePropsInBean;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 書類到着日取得のメソッド {@link GetSyoruittykymd#getSyoruiTtykymdFirst(String, C_SyoruiCdKbn)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class GetSyoruittykymdTest_getSyoruiTtykymdFirst {
    private GetSyoruittykymd getSyoruittykymd;

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(IwfImageClient.class).to(IwfImageClientMockForBiz.class);

            }
        });
        getSyoruittykymd = SWAKInjector.getInstance(GetSyoruittykymd.class);
    }

    @BeforeClass
    public static void testInit() {
        IwfImageClientMockForBiz.caller = "Test";

    }
    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        IwfImageClientMockForBiz.caller = null;
        IwfImageClientMockForBiz.mode = null;
    }

    @Test
    @TestOrder(10)
    public void testGetSyoruiTtykymdFirst_A1() {
        MockObjectManager.initialize();
        IwfImageClientMockForBiz.mode = "dl-04";

        String pKouteiKanriId = "1001";
        C_SyoruiCdKbn pSyoruiCd = C_SyoruiCdKbn.BLNK;

        BizDate syoruiTtykYmd = getSyoruittykymd.getSyoruiTtykymdFirst(pKouteiKanriId, pSyoruiCd);

        exDateEquals(syoruiTtykYmd, null, "書類到着日");
        GetImagePropsInBean getImagePropsInBean = (GetImagePropsInBean) MockObjectManager
            .getArgument(IwfImageClient.class, "execGetImageProps", 0, 0);
        exStringEquals(getImagePropsInBean.getGyoumukey(), "1001", "業務キー");
        exStringEquals(getImagePropsInBean.getAccountid(), "JUnit", "アカウントID");
        exStringEquals(getImagePropsInBean.getTorikomisyoruicd(), C_SyoruiCdKbn.BLNK.getValue(), "取込書類コード");

    }

    @Test
    @TestOrder(20)
    public void testGetSyoruiTtykymdFirst_A2() {
        IwfImageClientMockForBiz.mode = "dl-05";

        String pKouteiKanriId = "1001";
        C_SyoruiCdKbn pSyoruiCd = C_SyoruiCdKbn.BLNK;

        BizDate syoruiTtykYmd = getSyoruittykymd.getSyoruiTtykymdFirst(pKouteiKanriId, pSyoruiCd);

        exDateEquals(syoruiTtykYmd, null, "書類到着日");

    }

    @Test
    @TestOrder(30)
    public void testGetSyoruiTtykymdFirst_A3() {
        IwfImageClientMockForBiz.mode = "dl-01";

        String pKouteiKanriId = "1001";
        C_SyoruiCdKbn pSyoruiCd = C_SyoruiCdKbn.BLNK;

        BizDate syoruiTtykYmd = getSyoruittykymd.getSyoruiTtykymdFirst(pKouteiKanriId, pSyoruiCd);

        exDateEquals(syoruiTtykYmd, BizDate.valueOf("20150716"), "書類到着日");
    }

    @Test
    @TestOrder(40)
    public void testGetSyoruiTtykymdFirst_A4() {
        IwfImageClientMockForBiz.mode = "dl-06";

        String pKouteiKanriId = "1001";
        C_SyoruiCdKbn pSyoruiCd = C_SyoruiCdKbn.BLNK;

        BizDate syoruiTtykYmd = getSyoruittykymd.getSyoruiTtykymdFirst(pKouteiKanriId, pSyoruiCd);

        exDateEquals(syoruiTtykYmd, BizDate.valueOf("20150715"), "書類到着日");

    }

    @Test(expected = BizAppException.class)
    @TestOrder(50)
    public void testGetSyoruiTtykymdFirst_A5() {
        IwfImageClientMockForBiz.mode = "dl-03";

        String pKouteiKanriId = "1001";
        C_SyoruiCdKbn pSyoruiCd = C_SyoruiCdKbn.BLNK;

        try {
            getSyoruittykymd.getSyoruiTtykymdFirst(pKouteiKanriId, pSyoruiCd);

        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "IWFエラーです。機能＝書類到着日取得、API＝イメージプロパティ取得、エラーコード＝IWF0002", "エラーメッセージ");
            throw e;
        }
    }
}
