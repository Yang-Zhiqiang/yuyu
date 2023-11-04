package yuyu.common.siharai.chksk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.db.entity.JT_SiKykSyouhn;
import yuyu.testinfr.TestOrder;

/**
 * 保険期間チェッククラスのメソッド {@link ChkSubHknKkn#exec(BizDate, JT_SiKykSyouhn, List<ChkKekkaBean>)}
 *     テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class ChkSubHknKknTest_exec {

    @Inject
    private ChkSubHknKkn chkSubHknKkn;

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    @Transactional
    public void testExec_A1() {

        BizDate hanteiKijyunYmd = BizDate.valueOf(20151118);

        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();

        siKykSyouhn.setHknkknmanryouymd(BizDate.valueOf(20151117));

        List<ChkKekkaBean> chkKekkaBeanList = new ArrayList<>();

        ChkKekkaBean chkKekkaBean = new ChkKekkaBean();

        chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK);
        chkKekkaBean.setMsgHikisuu1("1");
        chkKekkaBean.setMsgHikisuu2("2");
        chkKekkaBean.setMsgHikisuu3("3");
        chkKekkaBean.setMsgHikisuu4("4");
        chkKekkaBean.setMsgHikisuu5("5");

        chkKekkaBeanList.add(chkKekkaBean);

        chkSubHknKkn.exec(hanteiKijyunYmd, siKykSyouhn, chkKekkaBeanList);

        exNumericEquals(chkKekkaBeanList.size(), 2, "チェック結果Beanリスト件数");

        exClassificationEquals(chkKekkaBeanList.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK, "請求内容チェック区分");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu1(), "1", "メッセージ引数1");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu2(), "2", "メッセージ引数2");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu3(), "3", "メッセージ引数3");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu4(), "4", "メッセージ引数4");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu5(), "5", "メッセージ引数5");

        exClassificationEquals(chkKekkaBeanList.get(1).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.HKNKKN_CHK, "請求内容チェック区分");
        exStringEquals(chkKekkaBeanList.get(1).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanList.get(1).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanList.get(1).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanList.get(1).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanList.get(1).getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testExec_A2() {

        BizDate hanteiKijyunYmd = BizDate.valueOf(20151118);

        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();

        siKykSyouhn.setHknkknmanryouymd(BizDate.valueOf(20151119));

        List<ChkKekkaBean> chkKekkaBeanList = new ArrayList<>();

        chkSubHknKkn.exec(hanteiKijyunYmd, siKykSyouhn, chkKekkaBeanList);

        exNumericEquals(chkKekkaBeanList.size(), 0, "チェック結果Beanリスト件数");
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testExec_A3() {

        BizDate hanteiKijyunYmd = BizDate.valueOf(20151118);

        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();

        siKykSyouhn.setHknkknmanryouymd(BizDate.valueOf(20151118));

        List<ChkKekkaBean> chkKekkaBeanList = new ArrayList<>();

        chkSubHknKkn.exec(hanteiKijyunYmd, siKykSyouhn, chkKekkaBeanList);

        exNumericEquals(chkKekkaBeanList.size(), 0, "チェック結果Beanリスト件数");
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testExec_A4() {

        BizDate hanteiKijyunYmd = null;

        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();

        List<ChkKekkaBean> chkKekkaBeanList = new ArrayList<>();

        chkSubHknKkn.exec(hanteiKijyunYmd, siKykSyouhn, chkKekkaBeanList);

        exNumericEquals(chkKekkaBeanList.size(), 0, "チェック結果Beanリスト件数");
    }

}