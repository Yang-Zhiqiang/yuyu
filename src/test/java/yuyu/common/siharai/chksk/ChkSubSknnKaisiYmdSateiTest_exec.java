package yuyu.common.siharai.chksk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.db.entity.JT_SiKykSyouhn;
import yuyu.def.siharai.configuration.YuyuSiharaiConfig;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 査定項目＿責任開始日チェックのメソッド{@link ChkSubSknnKaisiYmdSatei#exec(BizDate,JT_SiKykSyouhn, List<ChkKekkaBean>)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class ChkSubSknnKaisiYmdSateiTest_exec {

    @Inject
    private ChkSubSknnKaisiYmdSatei chkSubSknnKaisiYmdSatei;

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @Transactional
    @TestOrder(10)
    public void testExec_A1() {
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubSknnKaisiYmdSatei.exec(null, siKykSyouhn, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testExec_A2() {
        BizDate hanteiKijyunYmd = BizDate.valueOf("20150505");

        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();

        siKykSyouhn.setSknnkaisiymd(BizDate.valueOf("20130506"));

        YuyuSiharaiConfig.getInstance().setSoukiKyhNensuu(2);

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        ChkKekkaBean chkKekkaBean = new ChkKekkaBean();

        chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK);

        chkKekkaBean.setMsgHikisuu1("1");

        chkKekkaBean.setMsgHikisuu2("2");

        chkKekkaBean.setMsgHikisuu3("3");

        chkKekkaBean.setMsgHikisuu4("4");

        chkKekkaBean.setMsgHikisuu5("5");

        chkKekkaBeanLst.add(chkKekkaBean);

        chkSubSknnKaisiYmdSatei.exec(hanteiKijyunYmd, siKykSyouhn, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 2, "件数");

        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK,
            "請求内容チェック区分");

        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "1", "メッセージ引数1");

        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "2", "メッセージ引数2");

        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "3", "メッセージ引数3");

        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "4", "メッセージ引数4");

        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "5", "メッセージ引数5");

        exClassificationEquals(chkKekkaBeanLst.get(1).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SATEICHK_SKNNKAISIYMD,
            "請求内容チェック区分");

        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu1(), "", "メッセージ引数1");

        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu2(), "", "メッセージ引数2");

        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu3(), "", "メッセージ引数3");

        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu4(), "", "メッセージ引数4");

        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testExec_A3() {
        BizDate hanteiKijyunYmd = BizDate.valueOf("20150505");

        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();

        siKykSyouhn.setSknnkaisiymd(BizDate.valueOf("20130505"));

        YuyuSiharaiConfig.getInstance().setSoukiKyhNensuu(2);

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubSknnKaisiYmdSatei.exec(hanteiKijyunYmd, siKykSyouhn, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testExec_A4() {
        BizDate hanteiKijyunYmd = BizDate.valueOf("20150505");

        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();

        siKykSyouhn.setSknnkaisiymd(BizDate.valueOf("20130501"));

        YuyuSiharaiConfig.getInstance().setSoukiKyhNensuu(2);

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubSknnKaisiYmdSatei.exec(hanteiKijyunYmd, siKykSyouhn, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testExec_A5() {
        BizDate hanteiKijyunYmd = BizDate.valueOf("20140228");

        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();

        siKykSyouhn.setSknnkaisiymd(BizDate.valueOf("20120229"));

        YuyuSiharaiConfig.getInstance().setSoukiKyhNensuu(2);

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubSknnKaisiYmdSatei.exec(hanteiKijyunYmd, siKykSyouhn, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        ChkKekkaBean chkKekkaBean = chkKekkaBeanLst.get(0);
        exClassificationEquals(chkKekkaBean.getSKNaiyouChkKbn(),C_SKNaiyouChkKbn.SATEICHK_SKNNKAISIYMD,"請求内容チェック区分");
        exStringEquals(chkKekkaBean.getMsgHikisuu1(),"","メッセージ引数1");
        exStringEquals(chkKekkaBean.getMsgHikisuu2(),"","メッセージ引数2");
        exStringEquals(chkKekkaBean.getMsgHikisuu3(),"","メッセージ引数3");
        exStringEquals(chkKekkaBean.getMsgHikisuu4(),"","メッセージ引数4");
        exStringEquals(chkKekkaBean.getMsgHikisuu5(),"","メッセージ引数5");
    }
}
