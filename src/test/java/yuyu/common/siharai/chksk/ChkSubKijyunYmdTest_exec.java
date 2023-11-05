package yuyu.common.siharai.chksk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryMockForSiharai;
import yuyu.common.siharai.sicommon.TeisuuSiharai;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * ChkSubKijyunYmdクラスのメソッド {@link ChkSubKijyunYmd#exec(BizDate,BizDate,BizDate,JT_SiKykKihon,List<ChkKekkaBean>)}テスト用クラスです<br />
 */
@RunWith(SWAKTestRunner.class)
public class ChkSubKijyunYmdTest_exec extends AbstractTest {

    @Inject
    private ChkSubKijyunYmd chkSubKijyunYmd;


    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(BzGetProcessSummary.class).to(BzGetProcessSummaryMockForSiharai.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        BzGetProcessSummaryMockForSiharai.caller = ChkSubKijyunYmdTest_exec.class;

    }

    @AfterClass
    public static void testClear() {

        BzGetProcessSummaryMockForSiharai.caller = null;
        BzGetProcessSummaryMockForSiharai.SYORIPTN = null;
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        BizDate syoruiUketukeYmd = BizDate.valueOf("20201111");

        BizDate hanteiKijyunYmd = null;

        BizDate hubiKanryouYmd = null;

        String skno = "";

        String syono = "";

        changeSystemDate(BizDate.valueOf(2020, 11, 11));

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();

        siKykKihon = null;

        ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);

        chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK);
        chkKekkaBean.setMsgHikisuu1("1");
        chkKekkaBean.setMsgHikisuu2("2");
        chkKekkaBean.setMsgHikisuu3("3");
        chkKekkaBean.setMsgHikisuu4("4");
        chkKekkaBean.setMsgHikisuu5("5");

        List<ChkKekkaBean> chkKekkaBeanList = new ArrayList<>();

        chkKekkaBeanList.add(chkKekkaBean);

        chkSubKijyunYmd.exec(syoruiUketukeYmd, hanteiKijyunYmd, hubiKanryouYmd, skno, syono, siKykKihon, chkKekkaBeanList);

        exNumericEquals(chkKekkaBeanList.size(), 2, "チェック結果Beanリスト件数");

        exClassificationEquals(chkKekkaBeanList.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu1(), "1", "メッセージ引数1");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu2(), "2", "メッセージ引数2");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu3(), "3", "メッセージ引数3");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu4(), "4", "メッセージ引数4");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu5(), "5", "メッセージ引数5");

        exClassificationEquals(chkKekkaBeanList.get(1).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.KIJYUNYMD_MINYUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanList.get(1).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanList.get(1).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanList.get(1).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanList.get(1).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanList.get(1).getMsgHikisuu5(), "", "メッセージ引数5");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        BizDate syoruiUketukeYmd = BizDate.valueOf("20151119");

        BizDate hanteiKijyunYmd = BizDate.valueOf("20151120");

        BizDate hubiKanryouYmd = null;

        String skno = "";

        String syono = "";

        changeSystemDate(BizDate.valueOf(2015, 11, 19));

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();

        siKykKihon.setSykyknyhenkouymd(BizDate.valueOf("20151120"));
        siKykKihon.setLasthkhenkouymd(BizDate.valueOf("20151120"));

        List<ChkKekkaBean> chkKekkaBeanList = new ArrayList<>();

        chkSubKijyunYmd.exec(syoruiUketukeYmd, hanteiKijyunYmd, hubiKanryouYmd, skno, syono, siKykKihon, chkKekkaBeanList);

        exNumericEquals(chkKekkaBeanList.size(), 1, "チェック結果Beanリスト件数");

        exClassificationEquals(chkKekkaBeanList.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.KIJYUN_SYORUIUKE_SKCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu5(), "", "メッセージ引数5");

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        BizDate syoruiUketukeYmd = BizDate.valueOf("20151121");

        BizDate hanteiKijyunYmd = BizDate.valueOf("20151120");

        BizDate hubiKanryouYmd = null;

        String skno = "";

        String syono = "";

        changeSystemDate(BizDate.valueOf(2015, 11, 21));

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();

        siKykKihon.setSykyknyhenkouymd(BizDate.valueOf("20151120"));
        siKykKihon.setLasthkhenkouymd(BizDate.valueOf("20151120"));

        List<ChkKekkaBean> chkKekkaBeanList = new ArrayList<>();

        chkSubKijyunYmd.exec(syoruiUketukeYmd, hanteiKijyunYmd, hubiKanryouYmd, skno, syono, siKykKihon, chkKekkaBeanList);

        exNumericEquals(chkKekkaBeanList.size(), 0, "チェック結果Beanリスト件数");

    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        BizDate syoruiUketukeYmd = BizDate.valueOf("20151120");

        BizDate hanteiKijyunYmd = BizDate.valueOf("20151120");

        BizDate hubiKanryouYmd = null;

        String skno = "";

        String syono = "";

        changeSystemDate(BizDate.valueOf(2015, 11, 20));

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();

        siKykKihon.setSykyknyhenkouymd(BizDate.valueOf("20151120"));
        siKykKihon.setLasthkhenkouymd(BizDate.valueOf("20151120"));

        List<ChkKekkaBean> chkKekkaBeanList = new ArrayList<>();

        chkSubKijyunYmd.exec(syoruiUketukeYmd, hanteiKijyunYmd, hubiKanryouYmd, skno, syono, siKykKihon, chkKekkaBeanList);

        exNumericEquals(chkKekkaBeanList.size(), 1, "チェック結果Beanリスト件数");

        exClassificationEquals(chkKekkaBeanList.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.KIJYUN_SYORUIUKE_SKCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu5(), "", "メッセージ引数5");

    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        BizDate syoruiUketukeYmd = BizDate.valueOf("20151120");

        BizDate hanteiKijyunYmd = BizDate.valueOf("20151119");

        BizDate hubiKanryouYmd = null;

        String skno = "";

        String syono = "";

        changeSystemDate(BizDate.valueOf(2015, 11, 20));

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();

        siKykKihon.setSykyknyhenkouymd(BizDate.valueOf("20151120"));
        siKykKihon.setLasthkhenkouymd(BizDate.valueOf("20151119"));

        List<ChkKekkaBean> chkKekkaBeanList = new ArrayList<>();

        chkSubKijyunYmd.exec(syoruiUketukeYmd, hanteiKijyunYmd, hubiKanryouYmd, skno, syono, siKykKihon, chkKekkaBeanList);

        exNumericEquals(chkKekkaBeanList.size(), 1, "チェック結果Beanリスト件数");

        exClassificationEquals(chkKekkaBeanList.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.KIJYUN_KHENKOU_SKCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu5(), "", "メッセージ引数5");

    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        BizDate syoruiUketukeYmd = BizDate.valueOf("20151120");

        BizDate hanteiKijyunYmd = BizDate.valueOf("20151119");

        BizDate hubiKanryouYmd = null;

        String skno = "";

        String syono = "";

        changeSystemDate(BizDate.valueOf(2015, 11, 20));

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();

        siKykKihon.setSykyknyhenkouymd(BizDate.valueOf("20151118"));
        siKykKihon.setLasthkhenkouymd(BizDate.valueOf("20151119"));

        List<ChkKekkaBean> chkKekkaBeanList = new ArrayList<>();

        chkSubKijyunYmd.exec(syoruiUketukeYmd, hanteiKijyunYmd, hubiKanryouYmd, skno, syono, siKykKihon, chkKekkaBeanList);

        exNumericEquals(chkKekkaBeanList.size(), 0, "チェック結果Beanリスト件数");

    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        BizDate syoruiUketukeYmd = BizDate.valueOf("20151120");

        BizDate hanteiKijyunYmd = BizDate.valueOf("20151119");

        BizDate hubiKanryouYmd = null;

        String skno = "";

        String syono = "";

        changeSystemDate(BizDate.valueOf(2015, 11, 20));

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();

        siKykKihon.setSykyknyhenkouymd(BizDate.valueOf("20151119"));
        siKykKihon.setLasthkhenkouymd(BizDate.valueOf("20151119"));

        List<ChkKekkaBean> chkKekkaBeanList = new ArrayList<>();

        chkSubKijyunYmd.exec(syoruiUketukeYmd, hanteiKijyunYmd, hubiKanryouYmd, skno, syono, siKykKihon, chkKekkaBeanList);

        exNumericEquals(chkKekkaBeanList.size(), 0, "チェック結果Beanリスト件数");

    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        BizDate syoruiUketukeYmd = BizDate.valueOf("20151120");

        BizDate hanteiKijyunYmd = BizDate.valueOf("20151119");

        BizDate hubiKanryouYmd = null;

        String skno = "";

        String syono = "";

        changeSystemDate(BizDate.valueOf(2015, 11, 20));

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();

        siKykKihon.setSykyknyhenkouymd(BizDate.valueOf("20151119"));
        siKykKihon.setLasthkhenkouymd(BizDate.valueOf("20151120"));

        List<ChkKekkaBean> chkKekkaBeanList = new ArrayList<>();

        chkSubKijyunYmd.exec(syoruiUketukeYmd, hanteiKijyunYmd, hubiKanryouYmd, skno, syono, siKykKihon, chkKekkaBeanList);

        exNumericEquals(chkKekkaBeanList.size(), 1, "チェック結果Beanリスト件数");

        exClassificationEquals(chkKekkaBeanList.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.KIJYUN_HHENKOU_SKCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu5(), "", "メッセージ引数5");

    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        BizDate syoruiUketukeYmd = BizDate.valueOf("20151120");

        BizDate hanteiKijyunYmd = BizDate.valueOf("20151119");

        BizDate hubiKanryouYmd = null;

        String skno = "";

        String syono = "";

        changeSystemDate(BizDate.valueOf(2015, 11, 20));

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();

        siKykKihon.setSykyknyhenkouymd(BizDate.valueOf("20151119"));
        siKykKihon.setLasthkhenkouymd(BizDate.valueOf("20151118"));

        List<ChkKekkaBean> chkKekkaBeanList = new ArrayList<>();

        chkSubKijyunYmd.exec(syoruiUketukeYmd, hanteiKijyunYmd, hubiKanryouYmd, skno, syono, siKykKihon, chkKekkaBeanList);

        exNumericEquals(chkKekkaBeanList.size(), 0, "チェック結果Beanリスト件数");

    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        BizDate syoruiUketukeYmd = BizDate.valueOf("20151120");

        BizDate hanteiKijyunYmd = BizDate.valueOf("20151119");

        BizDate hubiKanryouYmd = null;

        String skno = "";

        String syono = "";

        changeSystemDate(BizDate.valueOf(2015, 11, 20));

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();

        siKykKihon.setSykyknyhenkouymd(BizDate.valueOf("20151119"));
        siKykKihon.setLasthkhenkouymd(BizDate.valueOf("20151119"));

        List<ChkKekkaBean> chkKekkaBeanList = new ArrayList<>();

        chkSubKijyunYmd.exec(syoruiUketukeYmd, hanteiKijyunYmd, hubiKanryouYmd, skno, syono, siKykKihon, chkKekkaBeanList);

        exNumericEquals(chkKekkaBeanList.size(), 0, "チェック結果Beanリスト件数");

    }

    @Test
    @TestOrder(110)
    public void testExec_B1() {

        BizDate syoruiUketukeYmd = BizDate.valueOf("20151120");

        BizDate hanteiKijyunYmd = BizDate.valueOf("20151119");

        BizDate hubiKanryouYmd = null;

        String skno = "";

        String syono = "";

        changeSystemDate(BizDate.valueOf(2015, 11, 18));

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();

        siKykKihon.setSykyknyhenkouymd(BizDate.valueOf("20151119"));
        siKykKihon.setLasthkhenkouymd(BizDate.valueOf("20151119"));

        List<ChkKekkaBean> chkKekkaBeanList = new ArrayList<>();

        chkSubKijyunYmd.exec(syoruiUketukeYmd, hanteiKijyunYmd, hubiKanryouYmd, skno, syono, siKykKihon, chkKekkaBeanList);

        exNumericEquals(chkKekkaBeanList.size(), 1, "チェック結果Beanリスト件数");

        exClassificationEquals(chkKekkaBeanList.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SYORUIUKEYMD_SAKICHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu5(), "", "メッセージ引数5");

    }

    @Test
    @TestOrder(120)
    public void testExec_B2() {

        BizDate syoruiUketukeYmd = BizDate.valueOf("20151120");

        BizDate hanteiKijyunYmd = BizDate.valueOf("20151119");

        BizDate hubiKanryouYmd = null;

        String skno = "";

        String syono = "";

        changeSystemDate(BizDate.valueOf(2015, 11, 21));

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();

        siKykKihon.setSykyknyhenkouymd(BizDate.valueOf("20151119"));
        siKykKihon.setLasthkhenkouymd(BizDate.valueOf("20151119"));

        List<ChkKekkaBean> chkKekkaBeanList = new ArrayList<>();

        chkSubKijyunYmd.exec(syoruiUketukeYmd, hanteiKijyunYmd, hubiKanryouYmd, skno, syono, siKykKihon, chkKekkaBeanList);

        exNumericEquals(chkKekkaBeanList.size(), 0, "チェック結果Beanリスト件数");

    }

    @Test
    @TestOrder(130)
    public void testExec_B3() {

        BizDate syoruiUketukeYmd = BizDate.valueOf("20151120");

        BizDate hanteiKijyunYmd = BizDate.valueOf("20151119");

        BizDate hubiKanryouYmd = null;

        String skno = "";

        String syono = "";

        changeSystemDate(BizDate.valueOf(2015, 11, 20));

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();

        siKykKihon.setSykyknyhenkouymd(BizDate.valueOf("20151119"));
        siKykKihon.setLasthkhenkouymd(BizDate.valueOf("20151119"));

        List<ChkKekkaBean> chkKekkaBeanList = new ArrayList<>();

        chkSubKijyunYmd.exec(syoruiUketukeYmd, hanteiKijyunYmd, hubiKanryouYmd, skno, syono, siKykKihon, chkKekkaBeanList);

        exNumericEquals(chkKekkaBeanList.size(), 0, "チェック結果Beanリスト件数");

    }

    @Test
    @TestOrder(140)
    public void testExec_C1() {

        BizDate syoruiUketukeYmd = BizDate.valueOf("20151119");

        BizDate hanteiKijyunYmd = BizDate.valueOf("20151118");

        BizDate hubiKanryouYmd = BizDate.valueOf("20151120");

        String skno = "";

        String syono = "";

        changeSystemDate(BizDate.valueOf(2015, 11, 19));

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();

        siKykKihon.setSykyknyhenkouymd(BizDate.valueOf("20151118"));
        siKykKihon.setLasthkhenkouymd(BizDate.valueOf("20151118"));

        List<ChkKekkaBean> chkKekkaBeanList = new ArrayList<>();

        chkSubKijyunYmd.exec(syoruiUketukeYmd, hanteiKijyunYmd, hubiKanryouYmd, skno, syono, siKykKihon, chkKekkaBeanList);

        exNumericEquals(chkKekkaBeanList.size(), 1, "チェック結果Beanリスト件数");

        exClassificationEquals(chkKekkaBeanList.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.HUBIKANRYOUYMD_SAKICHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu5(), "", "メッセージ引数5");

    }

    @Test
    @TestOrder(150)
    public void testExec_C2() {

        BizDate syoruiUketukeYmd = BizDate.valueOf("20151119");

        BizDate hanteiKijyunYmd = BizDate.valueOf("20151118");

        BizDate hubiKanryouYmd = BizDate.valueOf("20151119");

        String skno = "";

        String syono = "";

        changeSystemDate(BizDate.valueOf(2015, 11, 20));

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();

        siKykKihon.setSykyknyhenkouymd(BizDate.valueOf("20151118"));
        siKykKihon.setLasthkhenkouymd(BizDate.valueOf("20151118"));

        List<ChkKekkaBean> chkKekkaBeanList = new ArrayList<>();

        chkSubKijyunYmd.exec(syoruiUketukeYmd, hanteiKijyunYmd, hubiKanryouYmd, skno, syono, siKykKihon, chkKekkaBeanList);

        exNumericEquals(chkKekkaBeanList.size(), 0, "チェック結果Beanリスト件数");

    }

    @Test
    @TestOrder(160)
    public void testExec_C3() {

        BizDate syoruiUketukeYmd = BizDate.valueOf("20151119");

        BizDate hanteiKijyunYmd = BizDate.valueOf("20151118");

        BizDate hubiKanryouYmd = BizDate.valueOf("20151119");

        String skno = "";

        String syono = "";

        changeSystemDate(BizDate.valueOf(2015, 11, 19));

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();

        siKykKihon.setSykyknyhenkouymd(BizDate.valueOf("20151118"));
        siKykKihon.setLasthkhenkouymd(BizDate.valueOf("20151118"));

        List<ChkKekkaBean> chkKekkaBeanList = new ArrayList<>();

        chkSubKijyunYmd.exec(syoruiUketukeYmd, hanteiKijyunYmd, hubiKanryouYmd, skno, syono, siKykKihon, chkKekkaBeanList);

        exNumericEquals(chkKekkaBeanList.size(), 0, "チェック結果Beanリスト件数");

    }

    @Test
    @TestOrder(170)
    public void testExec_C4() {

        BizDate syoruiUketukeYmd = BizDate.valueOf("20151119");

        BizDate hanteiKijyunYmd = BizDate.valueOf("20151118");

        BizDate hubiKanryouYmd = BizDate.valueOf("20151118");

        String skno = "";

        String syono = "";

        changeSystemDate(BizDate.valueOf(2015, 11, 19));

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();

        siKykKihon.setSykyknyhenkouymd(BizDate.valueOf("20151118"));
        siKykKihon.setLasthkhenkouymd(BizDate.valueOf("20151118"));

        List<ChkKekkaBean> chkKekkaBeanList = new ArrayList<>();

        chkSubKijyunYmd.exec(syoruiUketukeYmd, hanteiKijyunYmd, hubiKanryouYmd, skno, syono, siKykKihon, chkKekkaBeanList);

        exNumericEquals(chkKekkaBeanList.size(), 1, "チェック結果Beanリスト件数");

        exClassificationEquals(chkKekkaBeanList.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.HUBI_SYORUIUKE_SKCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu5(), "", "メッセージ引数5");

    }

    @Test
    @TestOrder(180)
    public void testExec_C5() {

        BizDate syoruiUketukeYmd = BizDate.valueOf("20151119");

        BizDate hanteiKijyunYmd = BizDate.valueOf("20151118");

        BizDate hubiKanryouYmd = BizDate.valueOf("20151120");

        String skno = "";

        String syono = "";

        changeSystemDate(BizDate.valueOf(2015, 11, 29));

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();

        siKykKihon.setSykyknyhenkouymd(BizDate.valueOf("20151118"));
        siKykKihon.setLasthkhenkouymd(BizDate.valueOf("20151118"));

        List<ChkKekkaBean> chkKekkaBeanList = new ArrayList<>();

        chkSubKijyunYmd.exec(syoruiUketukeYmd, hanteiKijyunYmd, hubiKanryouYmd, skno, syono, siKykKihon, chkKekkaBeanList);

        exNumericEquals(chkKekkaBeanList.size(), 0, "チェック結果Beanリスト件数");

    }

    @Test
    @TestOrder(190)
    public void testExec_C6() {

        BizDate syoruiUketukeYmd = BizDate.valueOf("20151120");

        BizDate hanteiKijyunYmd = BizDate.valueOf("20151119");

        BizDate hubiKanryouYmd = BizDate.valueOf("20151120");

        String skno = "";

        String syono = "";

        changeSystemDate(BizDate.valueOf(2015, 11, 29));

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();

        siKykKihon.setSykyknyhenkouymd(BizDate.valueOf("20151119"));
        siKykKihon.setLasthkhenkouymd(BizDate.valueOf("20151119"));

        List<ChkKekkaBean> chkKekkaBeanList = new ArrayList<>();

        chkSubKijyunYmd.exec(syoruiUketukeYmd, hanteiKijyunYmd, hubiKanryouYmd, skno, syono, siKykKihon, chkKekkaBeanList);

        exNumericEquals(chkKekkaBeanList.size(), 0, "チェック結果Beanリスト件数");

    }

    @Test
    @TestOrder(200)
    public void testExec_C7() {

        BizDate syoruiUketukeYmd = BizDate.valueOf("20151120");

        BizDate hanteiKijyunYmd = BizDate.valueOf("20151119");

        BizDate hubiKanryouYmd = null;

        String skno = "";

        String syono = "";

        changeSystemDate(BizDate.valueOf(2015, 11, 29));

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();

        siKykKihon.setSykyknyhenkouymd(BizDate.valueOf("20151119"));
        siKykKihon.setLasthkhenkouymd(BizDate.valueOf("20151119"));

        List<ChkKekkaBean> chkKekkaBeanList = new ArrayList<>();

        chkSubKijyunYmd.exec(syoruiUketukeYmd, hanteiKijyunYmd, hubiKanryouYmd, skno, syono, siKykKihon, chkKekkaBeanList);

        exNumericEquals(chkKekkaBeanList.size(), 0, "チェック結果Beanリスト件数");

    }

    @Test
    @TestOrder(210)
    public void testExec_D1() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN1;

        BizDate syoruiUketukeYmd = BizDate.valueOf("20151120");

        BizDate hanteiKijyunYmd = BizDate.valueOf("20151119");

        BizDate hubiKanryouYmd = null;

        String skno = "000000000000000020";

        String syono = "17806000013";

        changeSystemDate(BizDate.valueOf(2015, 11, 29));

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();

        siKykKihon.setSykyknyhenkouymd(BizDate.valueOf("20151119"));
        siKykKihon.setLasthkhenkouymd(BizDate.valueOf("20151119"));

        List<ChkKekkaBean> chkKekkaBeanList = new ArrayList<>();

        chkSubKijyunYmd.exec(syoruiUketukeYmd, hanteiKijyunYmd, hubiKanryouYmd, skno, syono, siKykKihon, chkKekkaBeanList);

        exNumericEquals(chkKekkaBeanList.size(), 0, "チェック結果Beanリスト件数");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager.
            getArgument(BzGetProcessSummaryMockForSiharai.class, "exec", 0, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), TeisuuSiharai.JIMUTETUZUKICD_SIHUBISIBOU, "事務手続コード");
        exStringEquals(bzGetProcessSummaryInBean.getSyoNo(), "17806000013", "証券番号");
        exStringEquals(bzGetProcessSummaryInBean.getSubSystemId(), TeisuuSiharai.SUBSYSTEMID_SIHARAI, "サブシステムID");


    }

    @Test
    @TestOrder(220)
    public void testExec_D2() {
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN1;

        BizDate syoruiUketukeYmd = BizDate.valueOf("20151120");

        BizDate hanteiKijyunYmd = BizDate.valueOf("20151119");

        BizDate hubiKanryouYmd = null;

        String skno = "000000000000001450";

        String syono = "18806001462";

        changeSystemDate(BizDate.valueOf(2015, 11, 29));

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();

        siKykKihon.setSykyknyhenkouymd(BizDate.valueOf("20151119"));
        siKykKihon.setLasthkhenkouymd(BizDate.valueOf("20151119"));

        List<ChkKekkaBean> chkKekkaBeanList = new ArrayList<>();

        chkSubKijyunYmd.exec(syoruiUketukeYmd, hanteiKijyunYmd, hubiKanryouYmd, skno, syono, siKykKihon, chkKekkaBeanList);

        exNumericEquals(chkKekkaBeanList.size(), 0, "チェック結果Beanリスト件数");

    }

    @Test
    @TestOrder(230)
    public void testExec_D3() {
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN2;

        BizDate syoruiUketukeYmd = BizDate.valueOf("20151120");

        BizDate hanteiKijyunYmd = BizDate.valueOf("20151119");

        BizDate hubiKanryouYmd = null;

        String skno = "000000000000000820";

        String syono = "17806000389";

        changeSystemDate(BizDate.valueOf(2015, 11, 29));

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();

        siKykKihon.setSykyknyhenkouymd(BizDate.valueOf("20151119"));
        siKykKihon.setLasthkhenkouymd(BizDate.valueOf("20151119"));

        List<ChkKekkaBean> chkKekkaBeanList = new ArrayList<>();

        chkSubKijyunYmd.exec(syoruiUketukeYmd, hanteiKijyunYmd, hubiKanryouYmd, skno, syono, siKykKihon, chkKekkaBeanList);

        exNumericEquals(chkKekkaBeanList.size(), 1, "チェック結果Beanリスト件数");

        exClassificationEquals(chkKekkaBeanList.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.HUBIKANRYOUYMD_MINYUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu5(), "", "メッセージ引数5");

    }

    @Test
    @TestOrder(240)
    public void testExec_D4() {

        BizDate syoruiUketukeYmd = BizDate.valueOf("20151120");

        BizDate hanteiKijyunYmd = BizDate.valueOf("20151119");

        BizDate hubiKanryouYmd = null;

        String skno = "000000000000000820";

        String syono = "";

        changeSystemDate(BizDate.valueOf(2015, 11, 29));

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();

        siKykKihon.setSykyknyhenkouymd(BizDate.valueOf("20151119"));
        siKykKihon.setLasthkhenkouymd(BizDate.valueOf("20151119"));

        List<ChkKekkaBean> chkKekkaBeanList = new ArrayList<>();

        chkSubKijyunYmd.exec(syoruiUketukeYmd, hanteiKijyunYmd, hubiKanryouYmd, skno, syono, siKykKihon, chkKekkaBeanList);

        exNumericEquals(chkKekkaBeanList.size(), 0, "チェック結果Beanリスト件数");

    }

    @Test
    @TestOrder(250)
    public void testExec_D5() {

        BizDate syoruiUketukeYmd = BizDate.valueOf("20151120");

        BizDate hanteiKijyunYmd = BizDate.valueOf("20151119");

        BizDate hubiKanryouYmd = null;

        String skno = "";

        String syono = "17806000389";

        changeSystemDate(BizDate.valueOf(2015, 11, 29));

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();

        siKykKihon.setSykyknyhenkouymd(BizDate.valueOf("20151119"));
        siKykKihon.setLasthkhenkouymd(BizDate.valueOf("20151119"));

        List<ChkKekkaBean> chkKekkaBeanList = new ArrayList<>();

        chkSubKijyunYmd.exec(syoruiUketukeYmd, hanteiKijyunYmd, hubiKanryouYmd, skno, syono, siKykKihon, chkKekkaBeanList);

        exNumericEquals(chkKekkaBeanList.size(), 0, "チェック結果Beanリスト件数");

    }
}
