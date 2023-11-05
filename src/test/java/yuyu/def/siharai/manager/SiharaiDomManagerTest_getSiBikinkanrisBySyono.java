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
import yuyu.def.db.entity.JT_SiBikinkanri;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 数理<br />
 * 解約返戻金相当額情報作成<br />
 * 保険金給付金備金管理テーブルエンティティリスト取得(証券番号)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManagerTest_getSiBikinkanrisBySyono {

    @Inject
    SiharaiDomManager siharaiDomManager;

    static String P_SYONO_01 = "11807111118";
    static String P_SYONO_02 = "11807111303";
    static String P_SYONO_03 = "11807111392";
    static String P_SYONO_04 = "11807111222";
    static String P_SYONO_05 = "";
    static String P_SKNO = "111111111111111111";
    static BizDate P_KESSANKIJYUNYMD = BizDate.valueOf("20160303");
    static BizDate P_BKNKKTYMD = BizDate.valueOf("20160304");

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        List<JT_SiBikinkanri> sibikinkanriLst = siharaiDomManager.getSiBikinkanrisBySyono(P_SYONO_01);
        Assert.assertEquals(0,sibikinkanriLst.size());

        JT_SiBikinkanri sibikinkanri1 = new JT_SiBikinkanri(P_SKNO, P_SYONO_01, P_KESSANKIJYUNYMD, C_BkncdKbn.BLNK, P_BKNKKTYMD,"test");
        siharaiDomManager.insert(sibikinkanri1);

        JT_SiBikinkanri sibikinkanri2 = new JT_SiBikinkanri(P_SKNO, P_SYONO_04, P_KESSANKIJYUNYMD, C_BkncdKbn.GENGK, P_BKNKKTYMD,"test");
        siharaiDomManager.insert(sibikinkanri2);

        JT_SiBikinkanri sibikinkanri3 = new JT_SiBikinkanri(P_SKNO, P_SYONO_03, P_KESSANKIJYUNYMD, C_BkncdKbn.KAIYAKU, P_BKNKKTYMD,"test");
        siharaiDomManager.insert(sibikinkanri3);

        JT_SiBikinkanri sibikinkanri4 = new JT_SiBikinkanri(P_SKNO, P_SYONO_03, P_KESSANKIJYUNYMD, C_BkncdKbn.SIBOUUKETUKE, P_BKNKKTYMD,"test");
        siharaiDomManager.insert(sibikinkanri4);

        JT_SiBikinkanri sibikinkanri5 = new JT_SiBikinkanri(P_SKNO, P_SYONO_03, P_KESSANKIJYUNYMD, C_BkncdKbn.KOUDOSYOUGAIUKETUKE, P_BKNKKTYMD,"test");
        siharaiDomManager.insert(sibikinkanri5);
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

        List<JT_SiBikinkanri> sibikinkanriLst = siharaiDomManager.getSiBikinkanrisBySyono(P_SYONO_02);

        Assert.assertEquals(0,sibikinkanriLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<JT_SiBikinkanri> sibikinkanriLst = siharaiDomManager.getSiBikinkanrisBySyono(P_SYONO_01);

        Assert.assertEquals(1,sibikinkanriLst.size());

        Assert.assertEquals(P_SKNO, sibikinkanriLst.get(0).getSkno());
        Assert.assertEquals(P_SYONO_01, sibikinkanriLst.get(0).getSyono());
        Assert.assertEquals(P_KESSANKIJYUNYMD, sibikinkanriLst.get(0).getKessankijyunymd());
        Assert.assertEquals(C_BkncdKbn.BLNK, sibikinkanriLst.get(0).getBkncdkbn());
        Assert.assertEquals(P_BKNKKTYMD, sibikinkanriLst.get(0).getBknkktymd());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($(P_SKNO,P_SYONO_03,P_KESSANKIJYUNYMD,C_BkncdKbn.KAIYAKU,P_BKNKKTYMD), "1");
        datamap.put($(P_SKNO,P_SYONO_03,P_KESSANKIJYUNYMD,C_BkncdKbn.SIBOUUKETUKE,P_BKNKKTYMD), "1");
        datamap.put($(P_SKNO,P_SYONO_03,P_KESSANKIJYUNYMD,C_BkncdKbn.KOUDOSYOUGAIUKETUKE,P_BKNKKTYMD), "1");

        List<JT_SiBikinkanri> sibikinkanriLst = siharaiDomManager.getSiBikinkanrisBySyono(P_SYONO_03);

        for(JT_SiBikinkanri siBikinkanri:sibikinkanriLst){
            datamap.remove($(
                siBikinkanri.getSkno(),
                siBikinkanri.getSyono(),
                siBikinkanri.getKessankijyunymd(),
                siBikinkanri.getBkncdkbn(),
                siBikinkanri.getBknkktymd()));
        }

        Assert.assertEquals(3,sibikinkanriLst.size());

        Assert.assertTrue(datamap.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blank1() {

        List<JT_SiBikinkanri> sibikinkanriLst = siharaiDomManager.getSiBikinkanrisBySyono(P_SYONO_05);

        Assert.assertEquals(0,sibikinkanriLst.size());
    }
}
