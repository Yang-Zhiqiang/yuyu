package yuyu.common.siharai.chksk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金給付金支払 請求内容チェック 円建変更日チェッククラス
 */
@RunWith(OrderedRunner.class)
public class ChkSubEndtHenkouYmdTest_exec {

    @Inject
    private ChkSubEndtHenkouYmd chkSubEndtHenkouYmd;

    @Test
    @TestOrder(10)
    @Transactional
    public void testExec1(){
        BizDate hanteiKijyunYmd = null;
        BizDate yenHenkoYmd = BizDate.valueOf("20180118");
        List<ChkKekkaBean> chkKekkaBeanList = new ArrayList<>();
        ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);

        chkKekkaBeanList.add(chkKekkaBean);
        chkSubEndtHenkouYmd.exec(hanteiKijyunYmd, yenHenkoYmd, chkKekkaBeanList);

        exNumericEquals(chkKekkaBeanList.size(), 1, "件数");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu2(), "","メッセージ引数2");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu3(), "","メッセージ引数3");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu4(), "","メッセージ引数4");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu5(), "","メッセージ引数5");
        exClassificationEquals(chkKekkaBeanList.get(0).getSKNaiyouChkKbn(), null,"請求内容チェック区分");

    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testExec2(){
        BizDate hanteiKijyunYmd = BizDate.valueOf("20180118");
        BizDate yenHenkoYmd = null;
        List<ChkKekkaBean> chkKekkaBeanList = new ArrayList<>();
        ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);

        chkKekkaBeanList.add(chkKekkaBean);
        chkSubEndtHenkouYmd.exec(hanteiKijyunYmd, yenHenkoYmd, chkKekkaBeanList);

        exNumericEquals(chkKekkaBeanList.size(), 1, "件数");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu1(), "","メッセージ引数1");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu2(), "","メッセージ引数2");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu3(), "","メッセージ引数3");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu4(), "","メッセージ引数4");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu5(), "","メッセージ引数5");
        exClassificationEquals(chkKekkaBeanList.get(0).getSKNaiyouChkKbn(), null,"請求内容チェック区分");

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testExec3(){
        BizDate hanteiKijyunYmd = BizDate.valueOf("20180118");
        BizDate yenHenkoYmd = BizDate.valueOf("20180119");
        List<ChkKekkaBean> chkKekkaBeanList = new ArrayList<>();
        ChkKekkaBean chkKekkaBean1 = SWAKInjector.getInstance(ChkKekkaBean.class);
        ChkKekkaBean chkKekkaBean2 = SWAKInjector.getInstance(ChkKekkaBean.class);

        chkKekkaBeanList.add(chkKekkaBean1);
        chkKekkaBeanList.add(chkKekkaBean2);
        chkSubEndtHenkouYmd.exec(hanteiKijyunYmd, yenHenkoYmd, chkKekkaBeanList);

        exNumericEquals(chkKekkaBeanList.size(), 3, "件数");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu1(), "","メッセージ引数1");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu2(), "","メッセージ引数2");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu3(), "","メッセージ引数3");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu4(), "","メッセージ引数4");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu5(), "","メッセージ引数5");
        exClassificationEquals(chkKekkaBeanList.get(0).getSKNaiyouChkKbn(), null,"請求内容チェック区分");

        exStringEquals(chkKekkaBeanList.get(1).getMsgHikisuu1(), "","メッセージ引数1");
        exStringEquals(chkKekkaBeanList.get(1).getMsgHikisuu2(), "","メッセージ引数2");
        exStringEquals(chkKekkaBeanList.get(1).getMsgHikisuu3(), "","メッセージ引数3");
        exStringEquals(chkKekkaBeanList.get(1).getMsgHikisuu4(), "","メッセージ引数4");
        exStringEquals(chkKekkaBeanList.get(1).getMsgHikisuu5(), "","メッセージ引数5");
        exClassificationEquals(chkKekkaBeanList.get(1).getSKNaiyouChkKbn(), null,"請求内容チェック区分");

        exStringEquals(chkKekkaBeanList.get(2).getMsgHikisuu1(), "","メッセージ引数1");
        exStringEquals(chkKekkaBeanList.get(2).getMsgHikisuu2(), "","メッセージ引数2");
        exStringEquals(chkKekkaBeanList.get(2).getMsgHikisuu3(), "","メッセージ引数3");
        exStringEquals(chkKekkaBeanList.get(2).getMsgHikisuu4(), "","メッセージ引数4");
        exStringEquals(chkKekkaBeanList.get(2).getMsgHikisuu5(), "","メッセージ引数5");
        exClassificationEquals(chkKekkaBeanList.get(2).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.ENDTHNKYMDCHECK_CHK,"請求内容チェック区分");
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testExec4(){
        BizDate hanteiKijyunYmd = BizDate.valueOf("20180118");
        BizDate yenHenkoYmd = BizDate.valueOf("20180118");
        List<ChkKekkaBean> chkKekkaBeanList = new ArrayList<>();
        ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);

        chkKekkaBeanList.add(chkKekkaBean);
        chkSubEndtHenkouYmd.exec(hanteiKijyunYmd, yenHenkoYmd, chkKekkaBeanList);

        exNumericEquals(chkKekkaBeanList.size(), 1, "件数");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu1(), "","メッセージ引数1");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu2(), "","メッセージ引数2");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu3(), "","メッセージ引数3");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu4(), "","メッセージ引数4");
        exStringEquals(chkKekkaBeanList.get(0).getMsgHikisuu5(), "","メッセージ引数5");
        exClassificationEquals(chkKekkaBeanList.get(0).getSKNaiyouChkKbn(), null,"請求内容チェック区分");

    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testExec5(){
        BizDate hanteiKijyunYmd = BizDate.valueOf("20180118");
        BizDate yenHenkoYmd = BizDate.valueOf("20180117");
        List<ChkKekkaBean> chkKekkaBeanList = new ArrayList<>();
        chkSubEndtHenkouYmd.exec(hanteiKijyunYmd, yenHenkoYmd, chkKekkaBeanList);

        exNumericEquals(chkKekkaBeanList.size(), 0, "件数");

    }
}
