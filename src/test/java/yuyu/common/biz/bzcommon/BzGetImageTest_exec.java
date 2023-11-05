package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.List;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.workflow.IwfImageClient;
import yuyu.common.biz.workflow.IwfImageClientMockForBiz;
import yuyu.common.biz.workflow.IwfKouteiClient;
import yuyu.common.biz.workflow.IwfKouteiClientMockForBiz;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 業務共通 業務共通イメージ取得クラスのメソッド {@link BzGetImage#exec(String[], String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzGetImageTest_exec {

    @Before
    public void Before () {
        MockModuleBinder.bind(new AbstractModule() {
            @Override
            protected void configure() {
                bind(IwfImageClient.class).to(IwfImageClientMockForBiz.class);
                bind(IwfKouteiClient.class).to(IwfKouteiClientMockForBiz.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        IwfImageClientMockForBiz.caller = "Test";
        IwfImageClientMockForBiz.mode = null;
        IwfKouteiClientMockForBiz.caller = "Test";
        IwfKouteiClientMockForBiz.mode = null;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        IwfImageClientMockForBiz.caller =null;
        IwfImageClientMockForBiz.mode =null;
        IwfKouteiClientMockForBiz.caller = null;
        IwfKouteiClientMockForBiz.mode = null;
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        MockObjectManager.initialize();
        IwfImageClientMockForBiz.mode = "21-01";

        String[] pImageId = new String[]{"ImageId01"};

        String pUserId = "UserId01";

        BzGetImage bzGetImage = SWAKInjector.getInstance(BzGetImage.class);
        BzGetImageOutputBean bzGetImageOutBean = bzGetImage.exec(pImageId, pUserId);

        exStringEquals(bzGetImageOutBean.getSyoriKekkaStatus(), "9", "処理結果ステータス");
        exStringEquals(bzGetImageOutBean.getSyousaiMessageCd(), "IWF0002", "詳細メッセージコード");
        exStringEquals(bzGetImageOutBean.getSyousaiMessage(), "必須入力チェックエラー", "詳細メッセージ");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        MockObjectManager.initialize();
        IwfImageClientMockForBiz.mode = "21-07";

        String[] pImageId = new String[]{"ImageId02", "ImageId03"};

        String pUserId = "UserId02";

        BzGetImage bzGetImage = SWAKInjector.getInstance(BzGetImage.class);
        BzGetImageOutputBean bzGetImageOutBean = bzGetImage.exec(pImageId, pUserId);

        exStringEquals(bzGetImageOutBean.getSyoriKekkaStatus(), "-1", "処理結果ステータス");
        exStringEquals(bzGetImageOutBean.getSyousaiMessageCd(), "IWF0000", "詳細メッセージコード");
        exStringEquals(bzGetImageOutBean.getSyousaiMessage(), "正常終了しました。", "詳細メッセージ");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        MockObjectManager.initialize();

        IwfImageClientMockForBiz.mode = "21-03";
        IwfKouteiClientMockForBiz.mode = "dl-02";

        String[] pImageId = new String[]{"ImageId04"};

        String pUserId = "UserId03";
        BzGetImage bzGetImage = SWAKInjector.getInstance(BzGetImage.class);
        BzGetImageOutputBean bzGetImageOutBean = bzGetImage.exec(pImageId, pUserId);

        exStringEquals(bzGetImageOutBean.getSyoriKekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(bzGetImageOutBean.getSyousaiMessageCd(), "IWF0000", "詳細メッセージコード");
        exStringEquals(bzGetImageOutBean.getSyousaiMessage(), "正常終了しました。", "詳細メッセージ");

        List<BzImageInfoBean> bzGetImageInfoBeanLst = bzGetImageOutBean.getBzImageInfoBeanList();

        exNumericEquals(bzGetImageInfoBeanLst.size(), 1, "件数");
        exStringEquals(bzGetImageInfoBeanLst.get(0).getImageId(), "ImageId01", "イメージID");
        exStringEquals(bzGetImageInfoBeanLst.get(0).getTorikomiSyoruiCd(), "SyoruiCd01", "取込書類コード");
        exStringEquals(bzGetImageInfoBeanLst.get(0).getKengenUmu(), "1", "権限有無");
        exStringEquals(bzGetImageInfoBeanLst.get(0).getMosno(), "780123451", "申込番号");
        exStringEquals(bzGetImageInfoBeanLst.get(0).getSyono(), "12806345672", "証券番号");
        exStringEquals(bzGetImageInfoBeanLst.get(0).getNksysyno(), "12806345661", "年金証書番号");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {
        MockObjectManager.initialize();

        IwfImageClientMockForBiz.mode = "21-11";
        IwfKouteiClientMockForBiz.mode = "dl-16";

        String[] pImageId = new String[]{"ImageId04"};

        String pUserId = "UserId04";
        BzGetImage bzGetImage = SWAKInjector.getInstance(BzGetImage.class);
        BzGetImageOutputBean bzGetImageOutBean = bzGetImage.exec(pImageId, pUserId);

        exStringEquals(bzGetImageOutBean.getSyoriKekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(bzGetImageOutBean.getSyousaiMessageCd(), "IWF0000", "詳細メッセージコード");
        exStringEquals(bzGetImageOutBean.getSyousaiMessage(), "正常終了しました。", "詳細メッセージ");

        List<BzImageInfoBean> bzGetImageInfoBeanLst = bzGetImageOutBean.getBzImageInfoBeanList();

        exNumericEquals(bzGetImageInfoBeanLst.size(), 3, "件数");

        exStringEquals(bzGetImageInfoBeanLst.get(0).getImageId(), "ImageId04", "イメージID");
        exStringEquals(bzGetImageInfoBeanLst.get(0).getTorikomiSyoruiCd(), "SyoruiCd01", "取込書類コード");
        exStringEquals(bzGetImageInfoBeanLst.get(0).getKengenUmu(), "1", "権限有無");
        exStringEquals(bzGetImageInfoBeanLst.get(0).getMosno(), "860000014", "申込番号");
        exStringEquals(bzGetImageInfoBeanLst.get(0).getSyono(), "99900034338", "証券番号");
        exStringEquals(bzGetImageInfoBeanLst.get(0).getNksysyno(), "9990003433801", "年金証書番号");

        exStringEquals(bzGetImageInfoBeanLst.get(1).getImageId(), "ImageId04", "イメージID");
        exStringEquals(bzGetImageInfoBeanLst.get(1).getTorikomiSyoruiCd(), "SyoruiCd02", "取込書類コード");
        exStringEquals(bzGetImageInfoBeanLst.get(1).getKengenUmu(), "1", "権限有無");
        exStringEquals(bzGetImageInfoBeanLst.get(1).getMosno(), "860000014", "申込番号");
        exStringEquals(bzGetImageInfoBeanLst.get(1).getSyono(), "99900034338", "証券番号");
        exStringEquals(bzGetImageInfoBeanLst.get(1).getNksysyno(), "9990003433801", "年金証書番号");

        exStringEquals(bzGetImageInfoBeanLst.get(2).getImageId(), "ImageId04", "イメージID");
        exStringEquals(bzGetImageInfoBeanLst.get(2).getTorikomiSyoruiCd(), "SyoruiCd03", "取込書類コード");
        exStringEquals(bzGetImageInfoBeanLst.get(2).getKengenUmu(), "0", "権限有無");
        exStringEquals(bzGetImageInfoBeanLst.get(2).getMosno(), "860000014", "申込番号");
        exStringEquals(bzGetImageInfoBeanLst.get(2).getSyono(), "99900034338", "証券番号");
        exStringEquals(bzGetImageInfoBeanLst.get(2).getNksysyno(), "9990003433801", "年金証書番号");
    }
}
