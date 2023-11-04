package yuyu.common.siharai.chksk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.bznayose.BzSakuinTsnSyoukaiKekkaBean;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 反社チェックのメソッド{@link ChkSubHansya#exec(JT_SkKihon, List<ChkKekkaBean>)} テスト用クラスです。
 * <br/>
 */
@RunWith(OrderedRunner.class)
public class ChkSubHansyaTest_exec {

    @Inject
    private ChkSubHansya chkSubHansya;

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        C_SeikyuuSyubetu seikyuuSyubetu = C_SeikyuuSyubetu.BLNK;

        BzSakuinTsnSyoukaiKekkaBean bzSakuinTsnSyoukaiKekkaBean = null;

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubHansya.exec(seikyuuSyubetu, bzSakuinTsnSyoukaiKekkaBean, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        C_SeikyuuSyubetu seikyuuSyubetu = C_SeikyuuSyubetu.SB;

        BzSakuinTsnSyoukaiKekkaBean bzSakuinTsnSyoukaiKekkaBean = null;

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubHansya.exec(seikyuuSyubetu, bzSakuinTsnSyoukaiKekkaBean, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        C_SeikyuuSyubetu seikyuuSyubetu = C_SeikyuuSyubetu.SB;

        BzSakuinTsnSyoukaiKekkaBean bzSakuinTsnSyoukaiKekkaBean = new BzSakuinTsnSyoukaiKekkaBean();
        bzSakuinTsnSyoukaiKekkaBean.setSinsntkhnsyumukbn(C_BlnktkumuKbn.NONE);

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubHansya.exec(seikyuuSyubetu, bzSakuinTsnSyoukaiKekkaBean,chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");

    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        C_SeikyuuSyubetu seikyuuSyubetu = C_SeikyuuSyubetu.SB;

        BzSakuinTsnSyoukaiKekkaBean bzSakuinTsnSyoukaiKekkaBean = new BzSakuinTsnSyoukaiKekkaBean();
        bzSakuinTsnSyoukaiKekkaBean.setSinsntkhnsyumukbn(C_BlnktkumuKbn.ARI);

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
        chkKekkaBean.setMsgHikisuu1("1");
        chkKekkaBean.setMsgHikisuu2("2");
        chkKekkaBean.setMsgHikisuu3("3");
        chkKekkaBean.setMsgHikisuu4("4");
        chkKekkaBean.setMsgHikisuu5("5");
        chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK);
        chkKekkaBeanLst.add(chkKekkaBean);

        chkSubHansya.exec(seikyuuSyubetu, bzSakuinTsnSyoukaiKekkaBean, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 2, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK, "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "1", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "2", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "3", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "4", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "5", "メッセージ引数5");
        exClassificationEquals(chkKekkaBeanLst.get(1).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SATEICHK_HANSYA, "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu5(), "", "メッセージ引数5");
        MockObjectManager.initialize();
    }
}
