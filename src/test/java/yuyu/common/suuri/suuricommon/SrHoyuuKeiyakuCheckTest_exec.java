package yuyu.common.suuri.suuricommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.classification.C_BknrigiKbn;
import yuyu.def.classification.C_HoyuuCheckKekkaKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.IT_KhBikinkanri;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.JT_SiBikinkanri;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SrHoyuuKeiyakuCheckクラスのメソッド {@link SrHoyuuKeiyakuCheck#exec(BizDate,String,BizDateYM,IT_KykSyouhn,List<IT_KhBikinkanri>,List<JT_SiBikinkanri>)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class SrHoyuuKeiyakuCheckTest_exec {

    @Inject
    private SrHoyuuKeiyakuCheck srHoyuuKeiyakuCheck;

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        BizDate kijyunYmd = BizDate.valueOf("20140401");
        String syono = "";
        BizDateYM skeikeijyouYm = BizDateYM.valueOf("201504");
        IT_KykSyouhn kykSyouhn = new IT_KykSyouhn();
        IT_KhTtdkRireki khTtdkRireki = new IT_KhTtdkRireki();
        List<IT_KhBikinkanri> khBikinkanriLst = new ArrayList<>();
        List<JT_SiBikinkanri> siBikinkanriLst = new ArrayList<>();

        C_HoyuuCheckKekkaKbn hoyuuCheckKekkaKbn = srHoyuuKeiyakuCheck.exec(kijyunYmd, syono, skeikeijyouYm, kykSyouhn,
            khTtdkRireki, khBikinkanriLst, siBikinkanriLst);

        exClassificationEquals(hoyuuCheckKekkaKbn, C_HoyuuCheckKekkaKbn.HOYUUTAISYOUGAI, "保有判定結果区分");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        BizDate kijyunYmd = BizDate.valueOf("20150521");
        String syono = "";
        BizDateYM skeikeijyouYm = BizDateYM.valueOf("201503");
        IT_KykSyouhn kykSyouhn = new IT_KykSyouhn();
        kykSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn.setYuukousyoumetukbn(C_YuukousyoumetuKbn.SYOUMETU);
        kykSyouhn.setSyoumetuymd(BizDate.valueOf("20140208"));
        IT_KhTtdkRireki khTtdkRireki = new IT_KhTtdkRireki();
        khTtdkRireki.setSyoriYmd(BizDate.valueOf("20150201"));

        List<IT_KhBikinkanri> khBikinkanriLst = new ArrayList<>();
        List<JT_SiBikinkanri> siBikinkanriLst = new ArrayList<>();

        C_HoyuuCheckKekkaKbn hoyuuCheckKekkaKbn = srHoyuuKeiyakuCheck.exec(kijyunYmd, syono, skeikeijyouYm, kykSyouhn,
            khTtdkRireki, khBikinkanriLst, siBikinkanriLst);

        exClassificationEquals(hoyuuCheckKekkaKbn, C_HoyuuCheckKekkaKbn.HOYUUTAISYOUGAI, "保有判定結果区分");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        BizDate kijyunYmd = BizDate.valueOf("20150521");
        String syono = "";
        BizDateYM skeikeijyouYm = BizDateYM.valueOf("201503");
        IT_KykSyouhn kykSyouhn = new IT_KykSyouhn();
        kykSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn.setYuukousyoumetukbn(C_YuukousyoumetuKbn.SYOUMETU);
        kykSyouhn.setSyoumetuymd(BizDate.valueOf("20150521"));

        IT_KhTtdkRireki khTtdkRireki = new IT_KhTtdkRireki();
        khTtdkRireki.setSyoriYmd(BizDate.valueOf("20150521"));

        List<IT_KhBikinkanri> khBikinkanriLst = new ArrayList<>();
        List<JT_SiBikinkanri> siBikinkanriLst = new ArrayList<>();

        C_HoyuuCheckKekkaKbn hoyuuCheckKekkaKbn = srHoyuuKeiyakuCheck.exec(kijyunYmd, syono, skeikeijyouYm, kykSyouhn,
            khTtdkRireki, khBikinkanriLst, siBikinkanriLst);

        exClassificationEquals(hoyuuCheckKekkaKbn, C_HoyuuCheckKekkaKbn.HOYUUTAISYOUGAI, "保有判定結果区分");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        BizDate kijyunYmd = BizDate.valueOf("20150921");
        IT_KykSyouhn kykSyouhn = new IT_KykSyouhn();
        IT_KhTtdkRireki khTtdkRireki = new IT_KhTtdkRireki();
        kykSyouhn.setSyutkkbn(C_SyutkKbn.TK);
        BizDateYM skeikeijyouYm = BizDateYM.valueOf("201503");

        C_HoyuuCheckKekkaKbn hoyuuCheckKekkaKbn = srHoyuuKeiyakuCheck.exec(kijyunYmd, "", skeikeijyouYm, kykSyouhn,
            khTtdkRireki, null, null);

        exClassificationEquals(hoyuuCheckKekkaKbn, C_HoyuuCheckKekkaKbn.HOYUUTAISYOU, "保有判定結果区分");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        BizDate kijyunYmd = BizDate.valueOf("20150321");
        IT_KykSyouhn kykSyouhn = new IT_KykSyouhn();
        IT_KhTtdkRireki khTtdkRireki = new IT_KhTtdkRireki();
        kykSyouhn.setSyutkkbn(C_SyutkKbn.TK);
        BizDateYM skeikeijyouYm = BizDateYM.valueOf("201503");

        C_HoyuuCheckKekkaKbn hoyuuCheckKekkaKbn = srHoyuuKeiyakuCheck.exec(kijyunYmd, "", skeikeijyouYm, kykSyouhn,
            khTtdkRireki, null, null);

        exClassificationEquals(hoyuuCheckKekkaKbn, C_HoyuuCheckKekkaKbn.HOYUUTAISYOU, "保有判定結果区分");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        BizDate kijyunYmd = BizDate.valueOf("20150604");
        IT_KykSyouhn kykSyouhn = new IT_KykSyouhn();
        kykSyouhn.setSyutkkbn(C_SyutkKbn.TK);
        IT_KhTtdkRireki khTtdkRireki = new IT_KhTtdkRireki();
        BizDateYM skeikeijyouYm = BizDateYM.valueOf("201503");
        List<IT_KhBikinkanri> khBikinkanriLst = new ArrayList<>();

        IT_KhBikinkanri khBikinkanri1 = new IT_KhBikinkanri();
        khBikinkanri1.setKessankijyunymd(BizDate.valueOf("20150604"));
        khBikinkanri1.setBkncdkbn(C_BkncdKbn.SIBOUKARIUKETUKE);
        khBikinkanri1.setBknrigikbn(C_BknrigiKbn.ADD);

        IT_KhBikinkanri khBikinkanri2 = new IT_KhBikinkanri();
        khBikinkanri2.setKessankijyunymd(BizDate.valueOf("20150604"));
        khBikinkanri2.setBkncdkbn(C_BkncdKbn.KAIYAKU);
        khBikinkanri2.setBkncdkbn(C_BkncdKbn.SIBOUKARIUKETUKE);
        khBikinkanri2.setBknrigikbn(C_BknrigiKbn.DEL);

        khBikinkanriLst.add(khBikinkanri1);
        khBikinkanriLst.add(khBikinkanri2);

        C_HoyuuCheckKekkaKbn hoyuuCheckKekkaKbn = srHoyuuKeiyakuCheck.exec(kijyunYmd, "", skeikeijyouYm, kykSyouhn,
            khTtdkRireki, khBikinkanriLst, null);

        exClassificationEquals(hoyuuCheckKekkaKbn, C_HoyuuCheckKekkaKbn.HOYUUTAISYOU, "保有判定結果区分");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        BizDate kijyunYmd = BizDate.valueOf("20150405");
        BizDateYM skeikeijyouYm = BizDateYM.valueOf("201503");
        IT_KykSyouhn kykSyouhn = new IT_KykSyouhn();
        IT_KhTtdkRireki khTtdkRireki = new IT_KhTtdkRireki();
        List<IT_KhBikinkanri> khBikinkanriLst = new ArrayList<>();

        IT_KhBikinkanri khBikinkanri1 = new IT_KhBikinkanri();
        khBikinkanri1.setKessankijyunymd(BizDate.valueOf("20150311"));
        khBikinkanri1.setBkncdkbn(C_BkncdKbn.KAIYAKU);
        khBikinkanri1.setBknrigikbn(C_BknrigiKbn.ADD);
        khBikinkanriLst.add(khBikinkanri1);


        List<JT_SiBikinkanri> siBikinkanriLst = new ArrayList<>();

        JT_SiBikinkanri siBikinkanri = new JT_SiBikinkanri();
        siBikinkanri.setKessankijyunymd(BizDate.valueOf("20150331"));
        siBikinkanri.setBkncdkbn(C_BkncdKbn.SIBOUUKETUKE);
        siBikinkanri.setBknrigikbn(C_BknrigiKbn.ADD);
        siBikinkanriLst.add(siBikinkanri);

        C_HoyuuCheckKekkaKbn hoyuuCheckKekkaKbn = srHoyuuKeiyakuCheck.exec(kijyunYmd, "", skeikeijyouYm, kykSyouhn,
            khTtdkRireki, khBikinkanriLst, siBikinkanriLst);

        exClassificationEquals(hoyuuCheckKekkaKbn, C_HoyuuCheckKekkaKbn.HOYUUTAISYOUGAI, "保有判定結果区分");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        BizDate kijyunYmd = BizDate.valueOf("20151205");
        BizDateYM skeikeijyouYm = BizDateYM.valueOf("201503");
        IT_KykSyouhn kykSyouhn = new IT_KykSyouhn();
        IT_KhTtdkRireki khTtdkRireki = new IT_KhTtdkRireki();
        List<IT_KhBikinkanri> khBikinkanriLst = new ArrayList<>();
        List<JT_SiBikinkanri> siBikinkanriLst = new ArrayList<>();

        JT_SiBikinkanri siBikinkanri1 = new JT_SiBikinkanri();
        siBikinkanri1.setKessankijyunymd(BizDate.valueOf("20150311"));
        siBikinkanri1.setBkncdkbn(C_BkncdKbn.SIBOUKARIUKETUKE);
        siBikinkanri1.setBknrigikbn(C_BknrigiKbn.ADD);

        JT_SiBikinkanri siBikinkanri2 = new JT_SiBikinkanri();
        siBikinkanri2.setKessankijyunymd(BizDate.valueOf("20151205"));
        siBikinkanri2.setBkncdkbn(C_BkncdKbn.GENGK);
        siBikinkanri2.setBknrigikbn(C_BknrigiKbn.ADD);

        siBikinkanriLst.add(siBikinkanri1);
        siBikinkanriLst.add(siBikinkanri2);

        C_HoyuuCheckKekkaKbn hoyuuCheckKekkaKbn = srHoyuuKeiyakuCheck.exec(kijyunYmd, "", skeikeijyouYm, kykSyouhn,
            khTtdkRireki, khBikinkanriLst, siBikinkanriLst);

        exClassificationEquals(hoyuuCheckKekkaKbn, C_HoyuuCheckKekkaKbn.HOYUUTAISYOU, "保有判定結果区分");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        BizDate kijyunYmd = BizDate.valueOf("20150405");
        BizDateYM skeikeijyouYm = BizDateYM.valueOf("201503");
        IT_KykSyouhn kykSyouhn = new IT_KykSyouhn();
        IT_KhTtdkRireki khTtdkRireki = new IT_KhTtdkRireki();

        List<JT_SiBikinkanri> siBikinkanriLst = new ArrayList<>();

        JT_SiBikinkanri siBikinkanri = new JT_SiBikinkanri();
        siBikinkanri.setKessankijyunymd(BizDate.valueOf("20150331"));
        siBikinkanri.setBkncdkbn(C_BkncdKbn.SIBOUKARIUKETUKE);
        siBikinkanri.setBknrigikbn(C_BknrigiKbn.ADD);
        siBikinkanriLst.add(siBikinkanri);

        C_HoyuuCheckKekkaKbn hoyuuCheckKekkaKbn = srHoyuuKeiyakuCheck.exec(kijyunYmd, "", skeikeijyouYm, kykSyouhn,
            khTtdkRireki, null, siBikinkanriLst);

        exClassificationEquals(hoyuuCheckKekkaKbn, C_HoyuuCheckKekkaKbn.HOYUUTAISYOUGAI, "保有判定結果区分");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        BizDate kijyunYmd = BizDate.valueOf("20150305");
        BizDateYM skeikeijyouYm = BizDateYM.valueOf("201503");
        IT_KykSyouhn kykSyouhn = new IT_KykSyouhn();
        IT_KhTtdkRireki khTtdkRireki = new IT_KhTtdkRireki();
        List<JT_SiBikinkanri> siBikinkanriLst = new ArrayList<>();

        JT_SiBikinkanri siBikinkanri = new JT_SiBikinkanri();
        siBikinkanri.setKessankijyunymd(BizDate.valueOf("20150305"));
        siBikinkanri.setBkncdkbn(C_BkncdKbn.SIBOUKAIJYO);
        siBikinkanri.setBknrigikbn(C_BknrigiKbn.ADD);
        siBikinkanriLst.add(siBikinkanri);

        C_HoyuuCheckKekkaKbn hoyuuCheckKekkaKbn = srHoyuuKeiyakuCheck.exec(kijyunYmd, "", skeikeijyouYm, kykSyouhn,
            khTtdkRireki, null, siBikinkanriLst);

        exClassificationEquals(hoyuuCheckKekkaKbn, C_HoyuuCheckKekkaKbn.HOYUUTAISYOUGAI, "保有判定結果区分");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        BizDate kijyunYmd = BizDate.valueOf("20160331");
        BizDateYM skeikeijyouYm = BizDateYM.valueOf("201503");

        IT_KykSyouhn kykSyouhn = new IT_KykSyouhn();
        kykSyouhn.setSyutkkbn(C_SyutkKbn.TK);
        IT_KhTtdkRireki khTtdkRireki = new IT_KhTtdkRireki();

        List<IT_KhBikinkanri> khBikinkanriLst = new ArrayList<>();

        IT_KhBikinkanri khBikinkanri = new IT_KhBikinkanri();
        khBikinkanri.setKessankijyunymd(BizDate.valueOf("20160331"));
        khBikinkanri.setBkncdkbn(C_BkncdKbn.KAIYAKU);
        khBikinkanri.setBknrigikbn(C_BknrigiKbn.ADD);
        khBikinkanriLst.add(khBikinkanri);

        C_HoyuuCheckKekkaKbn hoyuuCheckKekkaKbn = srHoyuuKeiyakuCheck.exec(kijyunYmd, "", skeikeijyouYm, kykSyouhn,
            khTtdkRireki, khBikinkanriLst, null);

        exClassificationEquals(hoyuuCheckKekkaKbn, C_HoyuuCheckKekkaKbn.HOYUUTAISYOUGAI, "保有判定結果区分");
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        BizDate kijyunYmd = BizDate.valueOf("20161231");
        BizDateYM skeikeijyouYm = BizDateYM.valueOf("201503");

        IT_KykSyouhn kykSyouhn = new IT_KykSyouhn();
        kykSyouhn.setSyutkkbn(C_SyutkKbn.TK);
        IT_KhTtdkRireki khTtdkRireki = new IT_KhTtdkRireki();

        List<IT_KhBikinkanri> khBikinkanriLst = new ArrayList<>();

        List<JT_SiBikinkanri> siBikinkanriLst = new ArrayList<>();
        JT_SiBikinkanri siBikinkanri = new JT_SiBikinkanri();
        siBikinkanri.setKessankijyunymd(BizDate.valueOf("20150331"));
        siBikinkanri.setBkncdkbn(C_BkncdKbn.SIBOUKARIUKETUKE);
        siBikinkanri.setBknrigikbn(C_BknrigiKbn.DEL);
        siBikinkanriLst.add(siBikinkanri);

        C_HoyuuCheckKekkaKbn hoyuuCheckKekkaKbn = srHoyuuKeiyakuCheck.exec(kijyunYmd, "", skeikeijyouYm, kykSyouhn,
            khTtdkRireki, khBikinkanriLst, siBikinkanriLst);

        exClassificationEquals(hoyuuCheckKekkaKbn, C_HoyuuCheckKekkaKbn.HOYUUTAISYOU, "保有判定結果区分");
    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {

        BizDate kijyunYmd = BizDate.valueOf("20160131");
        BizDateYM skeikeijyouYm = BizDateYM.valueOf("201503");

        IT_KykSyouhn kykSyouhn = new IT_KykSyouhn();
        kykSyouhn.setSyutkkbn(C_SyutkKbn.TK);
        IT_KhTtdkRireki khTtdkRireki = new IT_KhTtdkRireki();

        List<IT_KhBikinkanri> khBikinkanriLst = new ArrayList<>();

        List<JT_SiBikinkanri> siBikinkanriLst = new ArrayList<>();
        JT_SiBikinkanri siBikinkanri = new JT_SiBikinkanri();
        siBikinkanri.setKessankijyunymd(BizDate.valueOf("20150331"));
        siBikinkanri.setBkncdkbn(C_BkncdKbn.KAIYAKU);
        siBikinkanri.setBknrigikbn(C_BknrigiKbn.ADD);
        siBikinkanriLst.add(siBikinkanri);

        C_HoyuuCheckKekkaKbn hoyuuCheckKekkaKbn = srHoyuuKeiyakuCheck.exec(kijyunYmd, "", skeikeijyouYm, kykSyouhn,
            khTtdkRireki, khBikinkanriLst, siBikinkanriLst);

        exClassificationEquals(hoyuuCheckKekkaKbn, C_HoyuuCheckKekkaKbn.HOYUUTAISYOU, "保有判定結果区分");
    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {

        BizDate kijyunYmd = BizDate.valueOf("20160131");
        BizDateYM skeikeijyouYm = BizDateYM.valueOf("201503");

        IT_KykSyouhn kykSyouhn = new IT_KykSyouhn();
        kykSyouhn.setSyutkkbn(C_SyutkKbn.TK);
        IT_KhTtdkRireki khTtdkRireki = new IT_KhTtdkRireki();

        List<IT_KhBikinkanri> khBikinkanriLst = new ArrayList<>();

        List<JT_SiBikinkanri> siBikinkanriLst = new ArrayList<>();
        JT_SiBikinkanri siBikinkanri = new JT_SiBikinkanri();
        siBikinkanri.setKessankijyunymd(BizDate.valueOf("20150331"));
        siBikinkanri.setBkncdkbn(C_BkncdKbn.GENGK);
        siBikinkanri.setBknrigikbn(C_BknrigiKbn.DEL);
        siBikinkanriLst.add(siBikinkanri);

        C_HoyuuCheckKekkaKbn hoyuuCheckKekkaKbn = srHoyuuKeiyakuCheck.exec(kijyunYmd, "", skeikeijyouYm, kykSyouhn,
            khTtdkRireki, khBikinkanriLst, siBikinkanriLst);

        exClassificationEquals(hoyuuCheckKekkaKbn, C_HoyuuCheckKekkaKbn.HOYUUTAISYOU, "保有判定結果区分");

        MockObjectManager.initialize();
    }
}
