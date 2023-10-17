package yuyu.def.siharai.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.classification.C_BknrigiKbn;
import yuyu.def.db.entity.JT_SiBikinkanri;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金<br />
 * 保険金給付金備金情報抽出<br />
 * 保険金給付金備金管理テーブルエンティティリスト取得　備金例外区分以外のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManagerTest_getSiBikinkanrisByKessankijyunymdBknrigikbnNe {

    @Inject
    SiharaiDomManager siharaiDomManager;

    static String P_SKNO_01 = "11807111111";
    static String P_SYONO_01 = "11807111118";
    static BizDate P_KESSANKIJYUNYMD_001 = BizDate.valueOf("20160414");
    static BizDate P_KESSANKIJYUNYMD_002 = BizDate.valueOf("20160415");
    static BizDate P_KESSANKIJYUNYMD_003 = BizDate.valueOf("20160412");
    static BizDate P_BKNKKTYMD_001 = BizDate.valueOf("20160412");
    static String P_KYUUHUCD_01 = "1111";
    static String P_KYUUHUCD_02 = "1112";
    static String P_KYUUHUCD_03 = "1113";
    static String P_KYUUHUCD_04 = "1114";
    static String P_KYUUHUCD_05 = "1115";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        List<JT_SiBikinkanri> sibikinkanriLst = siharaiDomManager.getSiBikinkanrisByKessankijyunymdBknrigikbnNe(P_KESSANKIJYUNYMD_002, C_BknrigiKbn.DEL);
        Assert.assertEquals(0, sibikinkanriLst.size());

        JT_SiBikinkanri siBikinkanri1 = new JT_SiBikinkanri(P_SKNO_01, P_SYONO_01, P_KESSANKIJYUNYMD_001, C_BkncdKbn.GENGK, P_BKNKKTYMD_001, P_KYUUHUCD_01);
        siBikinkanri1.setBknrigikbn(C_BknrigiKbn.ADD);

        siharaiDomManager.insert(siBikinkanri1);

        JT_SiBikinkanri siBikinkanri2 = new JT_SiBikinkanri(P_SKNO_01, P_SYONO_01, P_KESSANKIJYUNYMD_001, C_BkncdKbn.GENGK, P_BKNKKTYMD_001, P_KYUUHUCD_02);
        siBikinkanri2.setBknrigikbn(C_BknrigiKbn.DEL);

        siharaiDomManager.insert(siBikinkanri2);

        JT_SiBikinkanri siBikinkanri3 = new JT_SiBikinkanri(P_SKNO_01, P_SYONO_01, P_KESSANKIJYUNYMD_001, C_BkncdKbn.GENGK, P_BKNKKTYMD_001, P_KYUUHUCD_03);
        siBikinkanri3.setBknrigikbn(C_BknrigiKbn.DEL);

        siharaiDomManager.insert(siBikinkanri3);

        JT_SiBikinkanri siBikinkanri4 = new JT_SiBikinkanri(P_SKNO_01, P_SYONO_01, P_KESSANKIJYUNYMD_001, C_BkncdKbn.GENGK, P_BKNKKTYMD_001, P_KYUUHUCD_04);
        siBikinkanri4.setBknrigikbn(C_BknrigiKbn.DEL);

        siharaiDomManager.insert(siBikinkanri4);

        JT_SiBikinkanri siBikinkanri5 = new JT_SiBikinkanri(P_SKNO_01, P_SYONO_01, P_KESSANKIJYUNYMD_002, C_BkncdKbn.GENGK, P_BKNKKTYMD_001, P_KYUUHUCD_05);
        siBikinkanri5.setBknrigikbn(C_BknrigiKbn.ADD);

        siharaiDomManager.insert(siBikinkanri5);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData(){

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        siharaiDomManager.delete(siharaiDomManager.getAllSiBikinkanri());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        List<JT_SiBikinkanri> sibikinkanriLst = siharaiDomManager.getSiBikinkanrisByKessankijyunymdBknrigikbnNe(P_KESSANKIJYUNYMD_003, C_BknrigiKbn.BLNK);

        Assert.assertEquals(0, sibikinkanriLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<JT_SiBikinkanri> sibikinkanriLst = siharaiDomManager.getSiBikinkanrisByKessankijyunymdBknrigikbnNe(P_KESSANKIJYUNYMD_002, C_BknrigiKbn.DEL);

        Assert.assertEquals(1, sibikinkanriLst.size());

        Assert.assertEquals(P_SKNO_01, sibikinkanriLst.get(0).getSkno());
        Assert.assertEquals(P_SYONO_01, sibikinkanriLst.get(0).getSyono());
        Assert.assertEquals(P_KESSANKIJYUNYMD_002, sibikinkanriLst.get(0).getKessankijyunymd());
        Assert.assertEquals(C_BkncdKbn.GENGK, sibikinkanriLst.get(0).getBkncdkbn());
        Assert.assertEquals(P_BKNKKTYMD_001, sibikinkanriLst.get(0).getBknkktymd());
        Assert.assertEquals(P_KYUUHUCD_05, sibikinkanriLst.get(0).getKyuuhucd());
        Assert.assertEquals(C_BknrigiKbn.ADD, sibikinkanriLst.get(0).getBknrigikbn());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($(P_SKNO_01,P_SYONO_01,P_KESSANKIJYUNYMD_001,C_BkncdKbn.GENGK,P_BKNKKTYMD_001,P_KYUUHUCD_02,C_BknrigiKbn.DEL), "1");
        datamap.put($(P_SKNO_01,P_SYONO_01,P_KESSANKIJYUNYMD_001,C_BkncdKbn.GENGK,P_BKNKKTYMD_001,P_KYUUHUCD_03,C_BknrigiKbn.DEL), "1");
        datamap.put($(P_SKNO_01,P_SYONO_01,P_KESSANKIJYUNYMD_001,C_BkncdKbn.GENGK,P_BKNKKTYMD_001,P_KYUUHUCD_04,C_BknrigiKbn.DEL), "1");

        List<JT_SiBikinkanri> sibikinkanriLst = siharaiDomManager.getSiBikinkanrisByKessankijyunymdBknrigikbnNe(P_KESSANKIJYUNYMD_001, C_BknrigiKbn.ADD);
        for(JT_SiBikinkanri siBikinkanri:sibikinkanriLst){
            datamap.remove($(
                siBikinkanri.getSkno(),
                siBikinkanri.getSyono(),
                siBikinkanri.getKessankijyunymd(),
                siBikinkanri.getBkncdkbn(),
                siBikinkanri.getBknkktymd(),
                siBikinkanri.getKyuuhucd(),
                siBikinkanri.getBknrigikbn()));
        }

        Assert.assertEquals(3, sibikinkanriLst.size());

        Assert.assertTrue(datamap.isEmpty());
    }
}
