package yuyu.def.siharai.detacher;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.db.entity.JT_SiBikinkanri;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 数理<br />
 * 異動明細情報作成<br />
 * 保険金給付金備金管理テーブルエンティティリストをアンマネージド取得のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class JT_SiBikinkanriDetacherTest_detachSiBikinkanritouched {

    @Inject
    SiharaiDomManager siharaiDomManager;

    static String P_SKON_01 = "001";
    static String P_SKON_02 = "002";
    static String P_SKON_03 = "003";
    static String P_SYONO_01 = "11807111118";
    static BizDate P_KESSANKIJYUNYMD_01 = BizDate.valueOf("20160101");

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        siharaiDomManager.insert(new JT_SiBikinkanri(P_SKON_01, P_SYONO_01, P_KESSANKIJYUNYMD_01, C_BkncdKbn.SIBOUKARIUKETUKE, P_KESSANKIJYUNYMD_01,"test"));

        siharaiDomManager.insert(new JT_SiBikinkanri(P_SKON_02, P_SYONO_01, P_KESSANKIJYUNYMD_01, C_BkncdKbn.SIBOUKARIUKETUKE, P_KESSANKIJYUNYMD_01,"test"));

        siharaiDomManager.insert(new JT_SiBikinkanri(P_SKON_03, P_SYONO_01, P_KESSANKIJYUNYMD_01, C_BkncdKbn.SIBOUKARIUKETUKE, P_KESSANKIJYUNYMD_01,"test"));
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        siharaiDomManager.delete(siharaiDomManager.getAllSiBikinkanri());
    }

    @Test
    @TestOrder(10)
    public void testDetach1() {

        List<JT_SiBikinkanri> jT_SiBikinkanri = siharaiDomManager.getAllSiBikinkanri();

        List<JT_SiBikinkanri> entityList = JT_SiBikinkanriDetacher.detachSiBikinkanritouched(jT_SiBikinkanri);

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        for(JT_SiBikinkanri entity : entityList) {

            Assert.assertFalse(em.getEntityManager().contains(entity));
        }
    }

    @Test
    @TestOrder(20)
    public void testDetach2() {

        List<JT_SiBikinkanri> jT_SiBikinkanri = new ArrayList<>();

        jT_SiBikinkanri.add(null);
        jT_SiBikinkanri.add(null);

        List<JT_SiBikinkanri> entityList = JT_SiBikinkanriDetacher.detachSiBikinkanritouched(jT_SiBikinkanri);

        for(JT_SiBikinkanri entity : entityList) {

            Assert.assertNull(entity);
        }
    }
}
