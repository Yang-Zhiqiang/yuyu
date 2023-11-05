package yuyu.common.siharai.chksk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.bznayose.BzSakuinTsnSyoukaiMqMock;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＭＲ情報チェックのメソッド{@link ChkSubMrInfo#exec(JT_SiKykKihon, List<ChkKekkaBean>)} テスト用クラスです。
 * <br/>
 */
@RunWith(OrderedRunner.class)
public class ChkSubMrInfoTest_exec {

    @Inject
    private ChkSubMrInfo chkSubMrInfo;

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMock.caller = ChkSubMrInfoTest_exec.class;
        BzSakuinTsnSyoukaiMqMock.SYORIPTN = "1";

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSyono("SN001");

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
        chkKekkaBean.setMsgHikisuu1("1");
        chkKekkaBean.setMsgHikisuu2("2");
        chkKekkaBean.setMsgHikisuu3("3");
        chkKekkaBean.setMsgHikisuu4("4");
        chkKekkaBean.setMsgHikisuu5("5");
        chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYANMKJ_MINYUCHK);
        chkKekkaBeanLst.add(chkKekkaBean);

        chkSubMrInfo.exec(siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 2, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SKSYANMKJ_MINYUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "1", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "2", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "3", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "4", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "5", "メッセージ引数5");
        exClassificationEquals(chkKekkaBeanLst.get(1).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SATEICHK_MRINFO,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu5(), "", "メッセージ引数5");
        //
        //        BzSakuinTsnSyoukaiYokenBean bzSakuinTsnSyoukaiYokenBean =
        //            (BzSakuinTsnSyoukaiYokenBean) MockObjectManager.getArgument(BzSakuinTsnSyoukaiMq.class, "exec", 0, 0);
        //
        //        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsnsyoukaikbn(), C_SakuintsnSyoukaiKbn.KYKKEYSYOUKAI,
        //            "索引通算照会区分");
        //        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getHuho2kyknokbn(), C_Huho2kyknoKbn.SYONO,
        //            "普保Ⅱ契約番号区分");
        //        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getHuho2kykno(), "SN001", "普保Ⅱ契約番号");
        //        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsntaisyoukbn(), C_SakuintsnTaisyouKbn.HHKN,
        //            "索引通算対象者区分");
        //        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getMrsignalsyoukaiyhkbn(), C_YouhiKbn.YOU, "ＭＲシグナル照会要否区分");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMock.caller = ChkSubMrInfoTest_exec.class;
        BzSakuinTsnSyoukaiMqMock.SYORIPTN = "2";

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSyono("SN002");

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubMrInfo.exec(siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");

    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();

        BzSakuinTsnSyoukaiMqMock.caller = null;
        BzSakuinTsnSyoukaiMqMock.SYORIPTN = null;
    }
}
