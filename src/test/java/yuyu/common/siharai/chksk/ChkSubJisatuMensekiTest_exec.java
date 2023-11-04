package yuyu.common.siharai.chksk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_GeninKbn;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.db.entity.JM_SiSyouhnZokusei;
import yuyu.def.db.entity.JT_SiKykSyouhn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 自殺免責チェックのメソッド{@link ChkSubJisatuMenseki#exec(BizDate, C_GeninKbn, BizDate,
        JT_SiKykSyouhn, JM_SiSyouhnZokusei, List<ChkKekkaBean>)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class ChkSubJisatuMensekiTest_exec {

    @Inject
    private ChkSubJisatuMenseki chkSubJisatuMenseki;

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        C_GeninKbn geninKbn = C_GeninKbn.SG;
        BizDate hanteiKijyunYmd = BizDate.valueOf(20150505);
        BizDate hkSknnKaisiYmd = null;
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setSknnkaisiymd(BizDate.valueOf(20130509));
        JM_SiSyouhnZokusei siSyouhnZokusei = new JM_SiSyouhnZokusei();
        siSyouhnZokusei.setJisatumensekinensuu(2);
        chkSubJisatuMenseki.exec(hanteiKijyunYmd, geninKbn, hkSknnKaisiYmd,
            siKykSyouhn, siSyouhnZokusei, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        C_GeninKbn geninKbn = C_GeninKbn.JS;
        BizDate hanteiKijyunYmd = BizDate.valueOf(20150505);
        BizDate hkSknnKaisiYmd = BizDate.valueOf(20150606);
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setSknnkaisiymd(BizDate.valueOf(20130505));
        JM_SiSyouhnZokusei siSyouhnZokusei = new JM_SiSyouhnZokusei();
        siSyouhnZokusei.setJisatumensekinensuu(2);
        chkSubJisatuMenseki.exec(hanteiKijyunYmd, geninKbn, hkSknnKaisiYmd,
            siKykSyouhn, siSyouhnZokusei, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SATEICHK_JISATUMENSEKI,
            "請求内容チェック区分");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        C_GeninKbn geninKbn = C_GeninKbn.JS;
        BizDate hanteiKijyunYmd = BizDate.valueOf(20150505);
        BizDate hkSknnKaisiYmd = BizDate.valueOf(20150606);
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setSknnkaisiymd(BizDate.valueOf(20130509));
        JM_SiSyouhnZokusei siSyouhnZokusei = new JM_SiSyouhnZokusei();
        siSyouhnZokusei.setJisatumensekinensuu(0);
        chkSubJisatuMenseki.exec(hanteiKijyunYmd, geninKbn, hkSknnKaisiYmd,
            siKykSyouhn, siSyouhnZokusei, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }

}
