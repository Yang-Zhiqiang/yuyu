package yuyu.common.siharai.chksk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.testinfr.TestOrder;

/**
 * 捜査照会チェッククラスのメソッド {@link ChkSubSousasyoukai#exec(JT_SiKykKihon,List<ChkKekkaBean>)} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class ChkSubSousasyoukaiTest_exec {

    @Inject
    private ChkSubSousasyoukai chkSubSousasyoukai;

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    @Transactional
    public void testExec_A1() {

        JT_SiKykKihon pSiKykKihon = new JT_SiKykKihon();

        pSiKykKihon.setTtdktyuuikbn1(C_TtdktyuuiKbn.HASANOYOBITOUSAN);
        pSiKykKihon.setTtdktyuuikbn2(C_TtdktyuuiKbn.HASANOYOBITOUSAN);
        pSiKykKihon.setTtdktyuuikbn3(C_TtdktyuuiKbn.HASANOYOBITOUSAN);
        pSiKykKihon.setTtdktyuuikbn4(C_TtdktyuuiKbn.HASANOYOBITOUSAN);
        pSiKykKihon.setTtdktyuuikbn5(C_TtdktyuuiKbn.HASANOYOBITOUSAN);

        List<ChkKekkaBean> pChkKekkaBeanList = new ArrayList<>();

        chkSubSousasyoukai.exec(pSiKykKihon, pChkKekkaBeanList);

        exNumericEquals(pChkKekkaBeanList.size(), 0, "チェック結果Beanリスト件数");
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testExec_A2() {

        JT_SiKykKihon pSiKykKihon = new JT_SiKykKihon();

        pSiKykKihon.setTtdktyuuikbn1(C_TtdktyuuiKbn.KYKSYASOUSASYOUKAI);

        pSiKykKihon.setTtdktyuuikbn2(C_TtdktyuuiKbn.HASANOYOBITOUSAN);
        pSiKykKihon.setTtdktyuuikbn3(C_TtdktyuuiKbn.HASANOYOBITOUSAN);
        pSiKykKihon.setTtdktyuuikbn4(C_TtdktyuuiKbn.HASANOYOBITOUSAN);
        pSiKykKihon.setTtdktyuuikbn5(C_TtdktyuuiKbn.HASANOYOBITOUSAN);

        List<ChkKekkaBean> pChkKekkaBeanList = new ArrayList<>();

        ChkKekkaBean pChkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);

        pChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK);
        pChkKekkaBean.setMsgHikisuu1("1");
        pChkKekkaBean.setMsgHikisuu2("2");
        pChkKekkaBean.setMsgHikisuu3("3");
        pChkKekkaBean.setMsgHikisuu4("4");
        pChkKekkaBean.setMsgHikisuu5("5");

        pChkKekkaBeanList.add(pChkKekkaBean);

        chkSubSousasyoukai.exec(pSiKykKihon, pChkKekkaBeanList);

        exNumericEquals(pChkKekkaBeanList.size(), 2, "チェック結果Beanリスト件数");

        exClassificationEquals(pChkKekkaBeanList.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK, "請求内容チェック区分");
        exStringEquals(pChkKekkaBeanList.get(0).getMsgHikisuu1(), "1", "メッセージ引数1");
        exStringEquals(pChkKekkaBeanList.get(0).getMsgHikisuu2(), "2", "メッセージ引数2");
        exStringEquals(pChkKekkaBeanList.get(0).getMsgHikisuu3(), "3", "メッセージ引数3");
        exStringEquals(pChkKekkaBeanList.get(0).getMsgHikisuu4(), "4", "メッセージ引数4");
        exStringEquals(pChkKekkaBeanList.get(0).getMsgHikisuu5(), "5", "メッセージ引数5");

        exClassificationEquals(pChkKekkaBeanList.get(1).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SATEICHK_SOUSASYOUKAI, "請求内容チェック区分");
        exStringEquals(pChkKekkaBeanList.get(1).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(pChkKekkaBeanList.get(1).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(pChkKekkaBeanList.get(1).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(pChkKekkaBeanList.get(1).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(pChkKekkaBeanList.get(1).getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testExec_A3() {

        JT_SiKykKihon pSiKykKihon = new JT_SiKykKihon();

        pSiKykKihon.setTtdktyuuikbn1(C_TtdktyuuiKbn.HHKNSYASOUSASYOUKAI);

        pSiKykKihon.setTtdktyuuikbn2(C_TtdktyuuiKbn.HASANOYOBITOUSAN);
        pSiKykKihon.setTtdktyuuikbn3(C_TtdktyuuiKbn.HASANOYOBITOUSAN);
        pSiKykKihon.setTtdktyuuikbn4(C_TtdktyuuiKbn.HASANOYOBITOUSAN);
        pSiKykKihon.setTtdktyuuikbn5(C_TtdktyuuiKbn.HASANOYOBITOUSAN);

        List<ChkKekkaBean> pChkKekkaBeanList = new ArrayList<>();

        chkSubSousasyoukai.exec(pSiKykKihon, pChkKekkaBeanList);

        exNumericEquals(pChkKekkaBeanList.size(), 1, "チェック結果Beanリスト件数");

        exClassificationEquals(pChkKekkaBeanList.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SATEICHK_SOUSASYOUKAI, "請求内容チェック区分");
        exStringEquals(pChkKekkaBeanList.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(pChkKekkaBeanList.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(pChkKekkaBeanList.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(pChkKekkaBeanList.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(pChkKekkaBeanList.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testExec_A4() {

        JT_SiKykKihon pSiKykKihon = new JT_SiKykKihon();

        pSiKykKihon.setTtdktyuuikbn2(C_TtdktyuuiKbn.KYKSYASOUSASYOUKAI);

        pSiKykKihon.setTtdktyuuikbn1(C_TtdktyuuiKbn.HASANOYOBITOUSAN);
        pSiKykKihon.setTtdktyuuikbn3(C_TtdktyuuiKbn.HASANOYOBITOUSAN);
        pSiKykKihon.setTtdktyuuikbn4(C_TtdktyuuiKbn.HASANOYOBITOUSAN);
        pSiKykKihon.setTtdktyuuikbn5(C_TtdktyuuiKbn.HASANOYOBITOUSAN);

        List<ChkKekkaBean> pChkKekkaBeanList = new ArrayList<>();

        chkSubSousasyoukai.exec(pSiKykKihon, pChkKekkaBeanList);

        exNumericEquals(pChkKekkaBeanList.size(), 1, "チェック結果Beanリスト件数");

        exClassificationEquals(pChkKekkaBeanList.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SATEICHK_SOUSASYOUKAI, "請求内容チェック区分");
        exStringEquals(pChkKekkaBeanList.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(pChkKekkaBeanList.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(pChkKekkaBeanList.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(pChkKekkaBeanList.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(pChkKekkaBeanList.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testExec_A5() {

        JT_SiKykKihon pSiKykKihon = new JT_SiKykKihon();

        pSiKykKihon.setTtdktyuuikbn2(C_TtdktyuuiKbn.HHKNSYASOUSASYOUKAI);

        pSiKykKihon.setTtdktyuuikbn1(C_TtdktyuuiKbn.HASANOYOBITOUSAN);
        pSiKykKihon.setTtdktyuuikbn3(C_TtdktyuuiKbn.HASANOYOBITOUSAN);
        pSiKykKihon.setTtdktyuuikbn4(C_TtdktyuuiKbn.HASANOYOBITOUSAN);
        pSiKykKihon.setTtdktyuuikbn5(C_TtdktyuuiKbn.HASANOYOBITOUSAN);

        List<ChkKekkaBean> pChkKekkaBeanList = new ArrayList<>();

        chkSubSousasyoukai.exec(pSiKykKihon, pChkKekkaBeanList);

        exNumericEquals(pChkKekkaBeanList.size(), 1, "チェック結果Beanリスト件数");

        exClassificationEquals(pChkKekkaBeanList.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SATEICHK_SOUSASYOUKAI, "請求内容チェック区分");
        exStringEquals(pChkKekkaBeanList.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(pChkKekkaBeanList.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(pChkKekkaBeanList.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(pChkKekkaBeanList.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(pChkKekkaBeanList.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testExec_A6() {

        JT_SiKykKihon pSiKykKihon = new JT_SiKykKihon();

        pSiKykKihon.setTtdktyuuikbn3(C_TtdktyuuiKbn.KYKSYASOUSASYOUKAI);

        pSiKykKihon.setTtdktyuuikbn1(C_TtdktyuuiKbn.HASANOYOBITOUSAN);
        pSiKykKihon.setTtdktyuuikbn2(C_TtdktyuuiKbn.HASANOYOBITOUSAN);
        pSiKykKihon.setTtdktyuuikbn4(C_TtdktyuuiKbn.HASANOYOBITOUSAN);
        pSiKykKihon.setTtdktyuuikbn5(C_TtdktyuuiKbn.HASANOYOBITOUSAN);

        List<ChkKekkaBean> pChkKekkaBeanList = new ArrayList<>();

        chkSubSousasyoukai.exec(pSiKykKihon, pChkKekkaBeanList);

        exNumericEquals(pChkKekkaBeanList.size(), 1, "チェック結果Beanリスト件数");

        exClassificationEquals(pChkKekkaBeanList.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SATEICHK_SOUSASYOUKAI, "請求内容チェック区分");
        exStringEquals(pChkKekkaBeanList.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(pChkKekkaBeanList.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(pChkKekkaBeanList.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(pChkKekkaBeanList.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(pChkKekkaBeanList.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testExec_A7() {

        JT_SiKykKihon pSiKykKihon = new JT_SiKykKihon();

        pSiKykKihon.setTtdktyuuikbn3(C_TtdktyuuiKbn.HHKNSYASOUSASYOUKAI);

        pSiKykKihon.setTtdktyuuikbn1(C_TtdktyuuiKbn.HASANOYOBITOUSAN);
        pSiKykKihon.setTtdktyuuikbn2(C_TtdktyuuiKbn.HASANOYOBITOUSAN);
        pSiKykKihon.setTtdktyuuikbn4(C_TtdktyuuiKbn.HASANOYOBITOUSAN);
        pSiKykKihon.setTtdktyuuikbn5(C_TtdktyuuiKbn.HASANOYOBITOUSAN);

        List<ChkKekkaBean> pChkKekkaBeanList = new ArrayList<>();

        chkSubSousasyoukai.exec(pSiKykKihon, pChkKekkaBeanList);

        exNumericEquals(pChkKekkaBeanList.size(), 1, "チェック結果Beanリスト件数");

        exClassificationEquals(pChkKekkaBeanList.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SATEICHK_SOUSASYOUKAI, "請求内容チェック区分");
        exStringEquals(pChkKekkaBeanList.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(pChkKekkaBeanList.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(pChkKekkaBeanList.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(pChkKekkaBeanList.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(pChkKekkaBeanList.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
    }


    @Test
    @TestOrder(80)
    @Transactional
    public void testExec_A8() {

        JT_SiKykKihon pSiKykKihon = new JT_SiKykKihon();

        pSiKykKihon.setTtdktyuuikbn4(C_TtdktyuuiKbn.KYKSYASOUSASYOUKAI);

        pSiKykKihon.setTtdktyuuikbn1(C_TtdktyuuiKbn.HASANOYOBITOUSAN);
        pSiKykKihon.setTtdktyuuikbn2(C_TtdktyuuiKbn.HASANOYOBITOUSAN);
        pSiKykKihon.setTtdktyuuikbn3(C_TtdktyuuiKbn.HASANOYOBITOUSAN);
        pSiKykKihon.setTtdktyuuikbn5(C_TtdktyuuiKbn.HASANOYOBITOUSAN);

        List<ChkKekkaBean> pChkKekkaBeanList = new ArrayList<>();

        chkSubSousasyoukai.exec(pSiKykKihon, pChkKekkaBeanList);

        exNumericEquals(pChkKekkaBeanList.size(), 1, "チェック結果Beanリスト件数");

        exClassificationEquals(pChkKekkaBeanList.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SATEICHK_SOUSASYOUKAI, "請求内容チェック区分");
        exStringEquals(pChkKekkaBeanList.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(pChkKekkaBeanList.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(pChkKekkaBeanList.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(pChkKekkaBeanList.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(pChkKekkaBeanList.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testExec_A9() {

        JT_SiKykKihon pSiKykKihon = new JT_SiKykKihon();

        pSiKykKihon.setTtdktyuuikbn4(C_TtdktyuuiKbn.HHKNSYASOUSASYOUKAI);

        pSiKykKihon.setTtdktyuuikbn1(C_TtdktyuuiKbn.HASANOYOBITOUSAN);
        pSiKykKihon.setTtdktyuuikbn2(C_TtdktyuuiKbn.HASANOYOBITOUSAN);
        pSiKykKihon.setTtdktyuuikbn3(C_TtdktyuuiKbn.HASANOYOBITOUSAN);
        pSiKykKihon.setTtdktyuuikbn5(C_TtdktyuuiKbn.HASANOYOBITOUSAN);

        List<ChkKekkaBean> pChkKekkaBeanList = new ArrayList<>();

        chkSubSousasyoukai.exec(pSiKykKihon, pChkKekkaBeanList);

        exNumericEquals(pChkKekkaBeanList.size(), 1, "チェック結果Beanリスト件数");

        exClassificationEquals(pChkKekkaBeanList.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SATEICHK_SOUSASYOUKAI, "請求内容チェック区分");
        exStringEquals(pChkKekkaBeanList.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(pChkKekkaBeanList.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(pChkKekkaBeanList.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(pChkKekkaBeanList.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(pChkKekkaBeanList.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testExec_A10() {

        JT_SiKykKihon pSiKykKihon = new JT_SiKykKihon();

        pSiKykKihon.setTtdktyuuikbn5(C_TtdktyuuiKbn.KYKSYASOUSASYOUKAI);

        pSiKykKihon.setTtdktyuuikbn1(C_TtdktyuuiKbn.HASANOYOBITOUSAN);
        pSiKykKihon.setTtdktyuuikbn2(C_TtdktyuuiKbn.HASANOYOBITOUSAN);
        pSiKykKihon.setTtdktyuuikbn3(C_TtdktyuuiKbn.HASANOYOBITOUSAN);
        pSiKykKihon.setTtdktyuuikbn4(C_TtdktyuuiKbn.HASANOYOBITOUSAN);

        List<ChkKekkaBean> pChkKekkaBeanList = new ArrayList<>();

        chkSubSousasyoukai.exec(pSiKykKihon, pChkKekkaBeanList);

        exNumericEquals(pChkKekkaBeanList.size(), 1, "チェック結果Beanリスト件数");

        exClassificationEquals(pChkKekkaBeanList.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SATEICHK_SOUSASYOUKAI, "請求内容チェック区分");
        exStringEquals(pChkKekkaBeanList.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(pChkKekkaBeanList.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(pChkKekkaBeanList.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(pChkKekkaBeanList.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(pChkKekkaBeanList.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testExec_A11() {

        JT_SiKykKihon pSiKykKihon = new JT_SiKykKihon();

        pSiKykKihon.setTtdktyuuikbn5(C_TtdktyuuiKbn.HHKNSYASOUSASYOUKAI);

        pSiKykKihon.setTtdktyuuikbn1(C_TtdktyuuiKbn.HASANOYOBITOUSAN);
        pSiKykKihon.setTtdktyuuikbn2(C_TtdktyuuiKbn.HASANOYOBITOUSAN);
        pSiKykKihon.setTtdktyuuikbn3(C_TtdktyuuiKbn.HASANOYOBITOUSAN);
        pSiKykKihon.setTtdktyuuikbn4(C_TtdktyuuiKbn.HASANOYOBITOUSAN);

        List<ChkKekkaBean> pChkKekkaBeanList = new ArrayList<>();

        chkSubSousasyoukai.exec(pSiKykKihon, pChkKekkaBeanList);

        exNumericEquals(pChkKekkaBeanList.size(), 1, "チェック結果Beanリスト件数");

        exClassificationEquals(pChkKekkaBeanList.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SATEICHK_SOUSASYOUKAI, "請求内容チェック区分");
        exStringEquals(pChkKekkaBeanList.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(pChkKekkaBeanList.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(pChkKekkaBeanList.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(pChkKekkaBeanList.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(pChkKekkaBeanList.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
    }
}
