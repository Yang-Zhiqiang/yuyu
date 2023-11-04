package yuyu.common.siharai.chksk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_SaisateiKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 消滅チェックのメソッド{@link ChkSubSyoumetu#exec(C_SaisateiKbn, JT_SiKykKihon, List<ChkKekkaBean>)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class ChkSubSyoumetuTest_exec {

    @Inject
    private ChkSubSyoumetu chkSubSyoumetu;


    @Test
    @TestOrder(10)
    public void testExec_A1() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
        chkKekkaBean.setMsgHikisuu1("メッセージ引数1");
        chkKekkaBean.setMsgHikisuu2("メッセージ引数2");
        chkKekkaBean.setMsgHikisuu3("メッセージ引数3");
        chkKekkaBean.setMsgHikisuu4("メッセージ引数4");
        chkKekkaBean.setMsgHikisuu5("メッセージ引数5");
        chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSKINFO_CHK);
        chkKekkaBeanLst.add(chkKekkaBean);
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setYuukousyoumetukbn(C_YuukousyoumetuKbn.SYOUMETU);
        C_SaisateiKbn saisateiKbn = C_SaisateiKbn.BLNK;
        chkSubSyoumetu.exec(saisateiKbn, siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 2, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SKSKINFO_CHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "メッセージ引数1", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "メッセージ引数2", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "メッセージ引数3", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "メッセージ引数4", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "メッセージ引数5", "メッセージ引数5");
        exClassificationEquals(chkKekkaBeanLst.get(1).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SYOUMETU_CHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu1(), "消滅", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu5(), "", "メッセージ引数5");
    }


    @Test
    @TestOrder(20)
    public void testExec_A2() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setYuukousyoumetukbn(C_YuukousyoumetuKbn.SYOUMETU);
        C_SaisateiKbn saisateiKbn = C_SaisateiKbn.BLNK;
        chkSubSyoumetu.exec(saisateiKbn, siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SYOUMETU_CHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "消滅", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
    }


    @Test
    @TestOrder(30)
    public void testExec_A3() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setYuukousyoumetukbn(C_YuukousyoumetuKbn.BLNK);
        C_SaisateiKbn saisateiKbn = C_SaisateiKbn.BLNK;
        chkSubSyoumetu.exec(saisateiKbn, siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");

    }


    @Test
    @TestOrder(40)
    public void testExec_A4() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        C_SaisateiKbn saisateiKbn = C_SaisateiKbn.BLNK;
        chkSubSyoumetu.exec(saisateiKbn, siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");

        MockObjectManager.initialize();
    }
}
