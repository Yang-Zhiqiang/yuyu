package yuyu.common.sinkeiyaku.moschk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 基礎項目設定クラスのメソッド {@link SetKisoKoumoku#getNextkykymd(HT_MosKihon, HT_MosSyouhn, BizDate )} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetKisoKoumokuTest_getNextkykymd {

    @Inject
    private SetKisoKoumoku setKisoKoumoku;

    @Test
    @TestOrder(10)
    public void testGetNextkykymd_A1() {

        HT_MosKihon mosKihon = new HT_MosKihon();
        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setSyouhncd("ﾕﾍ");

        BizDate nextKykymd = setKisoKoumoku.getNextkykymd(mosKihon, mosSyouhn, BizDate.valueOf("20160414"));

        exDateEquals(nextKykymd, BizDate.valueOf("20160416"), "次回契約日");
    }

    @Test
    @TestOrder(20)
    public void testGetNextkykymd_A2() {

        HT_MosKihon mosKihon = new HT_MosKihon();
        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setSyouhncd("ﾕｹ");

        BizDate nextKykymd = setKisoKoumoku.getNextkykymd(mosKihon, mosSyouhn, BizDate.valueOf("20160415"));

        exDateEquals(nextKykymd, BizDate.valueOf("20160416"), "次回契約日");
    }

    @Test
    @TestOrder(30)
    public void testGetNextkykymd_A3() {

        HT_MosKihon mosKihon = new HT_MosKihon();
        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setSyouhncd("ﾕｹ");

        BizDate nextKykymd = setKisoKoumoku.getNextkykymd(mosKihon, mosSyouhn, BizDate.valueOf("20160416"));

        exDateEquals(nextKykymd, BizDate.valueOf("20160501"), "次回契約日");
    }

    @Test
    @TestOrder(40)
    public void testGetNextkykymd_A4() {

        HT_MosKihon mosKihon = new HT_MosKihon();
        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setSyouhncd("ﾕﾁ");

        BizDate nextKykymd = setKisoKoumoku.getNextkykymd(mosKihon, mosSyouhn, BizDate.valueOf("20160410"));

        exDateEquals(nextKykymd, BizDate.valueOf("20160501"), "次回契約日");
    }

    @Test
    @TestOrder(50)
    public void testGetNextkykymd_A5() {

        HT_MosKihon mosKihon = new HT_MosKihon();
        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setSyouhncd("ﾕｱ");
        mosKihon.setHrkkaisuu(C_Hrkkaisuu.TUKI);

        BizDate nextKykymd = setKisoKoumoku.getNextkykymd(mosKihon, mosSyouhn, BizDate.valueOf("20160410"));

        exDateEquals(nextKykymd, BizDate.valueOf("20160501"), "次回契約日");
    }

    @Test
    @TestOrder(60)
    public void testGetNextkykymd_A6() {

        HT_MosKihon mosKihon = new HT_MosKihon();
        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setSyouhncd("ﾕｱ");
        mosKihon.setHrkkaisuu(C_Hrkkaisuu.ITIJI);

        BizDate nextKykymd = setKisoKoumoku.getNextkykymd(mosKihon, mosSyouhn, BizDate.valueOf("20160410"));

        exDateEquals(nextKykymd, BizDate.valueOf("20160411"), "次回契約日");
    }
}
