package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_KinouKbn;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 支払日計算クラスのメソッド {@link KeisanSiharaibi#exec(BizDate,C_InputShrhousiteiKbn,C_Tuukasyu)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanSiharaibiTest_Exec {

    @Inject
    private AS_Kinou kinou;

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        KeisanSiharaibi keisanSiharaibi = SWAKInjector.getInstance(KeisanSiharaibi.class);

        BizDate bizDate = keisanSiharaibi.exec(BizDate.valueOf("20160301"), C_InputShrhousiteiKbn.FBSOUKIN, C_Tuukasyu.JPY,"0009");

        C_ShrhousiteiKbn shrhousiteiKbn = keisanSiharaibi.getShrhousiteiKbn();

        exDateEquals(bizDate, BizDate.valueOf("20160302"),"支払日");
        exClassificationEquals(shrhousiteiKbn, C_ShrhousiteiKbn.FB_YOKUJITU, "支払方法指定区分");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        KeisanSiharaibi keisanSiharaibi = SWAKInjector.getInstance(KeisanSiharaibi.class);

        BizDate bizDate = keisanSiharaibi.exec(BizDate.valueOf("20160301"), C_InputShrhousiteiKbn.FBSOUKIN, C_Tuukasyu.USD,"0009");

        C_ShrhousiteiKbn shrhousiteiKbn = keisanSiharaibi.getShrhousiteiKbn();

        exDateEquals(bizDate, BizDate.valueOf("20160303"),"支払日");
        exClassificationEquals(shrhousiteiKbn, C_ShrhousiteiKbn.FB_2EIGYOUBI, "支払方法指定区分");

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        KeisanSiharaibi keisanSiharaibi = SWAKInjector.getInstance(KeisanSiharaibi.class);

        BizDate bizDate = keisanSiharaibi.exec(BizDate.valueOf("20160301"), C_InputShrhousiteiKbn.KARIUKE_RISOKU_ARI, C_Tuukasyu.JPY,"0009");

        C_ShrhousiteiKbn shrhousiteiKbn = keisanSiharaibi.getShrhousiteiKbn();

        exDateEquals(bizDate, BizDate.valueOf("20160302"),"支払日");
        exClassificationEquals(shrhousiteiKbn, C_ShrhousiteiKbn.KARIUKE_RISOKU_ARI, "支払方法指定区分");

    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        KeisanSiharaibi keisanSiharaibi = SWAKInjector.getInstance(KeisanSiharaibi.class);

        BizDate bizDate = keisanSiharaibi.exec(BizDate.valueOf("20160301"), C_InputShrhousiteiKbn.KARIUKE_RISOKU_NASI, C_Tuukasyu.JPY,"0009");

        C_ShrhousiteiKbn shrhousiteiKbn = keisanSiharaibi.getShrhousiteiKbn();

        exDateEquals(bizDate, BizDate.valueOf("20160302"),"支払日");
        exClassificationEquals(shrhousiteiKbn, C_ShrhousiteiKbn.KARIUKE_RISOKU_NASI, "支払方法指定区分");

    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        KeisanSiharaibi keisanSiharaibi = SWAKInjector.getInstance(KeisanSiharaibi.class);

        BizDate bizDate = keisanSiharaibi.exec(BizDate.valueOf("20160301"), C_InputShrhousiteiKbn.BLNK, C_Tuukasyu.JPY,"0009");

        C_ShrhousiteiKbn shrhousiteiKbn = keisanSiharaibi.getShrhousiteiKbn();

        exDateEquals(bizDate, null, "支払日");
        exClassificationEquals(shrhousiteiKbn, C_ShrhousiteiKbn.BLNK, "支払方法指定区分");

    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        KeisanSiharaibi keisanSiharaibi = SWAKInjector.getInstance(KeisanSiharaibi.class);

        C_ShrhousiteiKbn shrhousiteiKbn = keisanSiharaibi.getShrhousiteiKbn();

        exClassificationEquals(shrhousiteiKbn, C_ShrhousiteiKbn.BLNK, "支払方法指定区分");

    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        kinou.setKinouKbn(C_KinouKbn.BATCH);

        KeisanSiharaibi keisanSiharaibi = SWAKInjector.getInstance(KeisanSiharaibi.class);

        BizDate bizDate = keisanSiharaibi.exec(BizDate.valueOf("20160301"), C_InputShrhousiteiKbn.FBSOUKIN,
            C_Tuukasyu.JPY, "0009");

        C_ShrhousiteiKbn shrhousiteiKbn = keisanSiharaibi.getShrhousiteiKbn();

        exDateEquals(bizDate, BizDate.valueOf("20160304"),"支払日");
        exClassificationEquals(shrhousiteiKbn, C_ShrhousiteiKbn.FB_3EIGYOUBI, "支払方法指定区分");

    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        kinou.setKinouKbn(C_KinouKbn.ONLINEBATCH);

        KeisanSiharaibi keisanSiharaibi = SWAKInjector.getInstance(KeisanSiharaibi.class);

        BizDate bizDate = keisanSiharaibi.exec(BizDate.valueOf("20160302"), C_InputShrhousiteiKbn.FBSOUKIN,
            C_Tuukasyu.JPY, "0010");

        C_ShrhousiteiKbn shrhousiteiKbn = keisanSiharaibi.getShrhousiteiKbn();

        exDateEquals(bizDate, null, "支払日");
        exClassificationEquals(shrhousiteiKbn, C_ShrhousiteiKbn.BLNK, "支払方法指定区分");

    }
}
