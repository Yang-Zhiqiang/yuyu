package yuyu.def.siharai.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.JT_Outai;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金<br />
 * 申出受付<br />
 * 応対テーブルエンティティ連番最大取得(証券番号)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManagerTest_getOutaiMaxRennoBySyono {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    static String P_SYONO_01 = "11807111118";
    static String P_SYONO_02 = "11807111129";
    static Integer P_RENNO_01 = 10;
    static Integer P_RENNO_02 = 20;
    static Integer P_RENNO_03 = 30;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        Integer maxRenno = siharaiDomManager.getOutaiMaxRennoBySyono(P_SYONO_01);
        Assert.assertNull(maxRenno);

        JT_Outai jt_Outai1 = new JT_Outai(P_SYONO_01, P_RENNO_01);
        siharaiDomManager.insert(jt_Outai1);

        JT_Outai jt_Outai2 = new JT_Outai(P_SYONO_01, P_RENNO_02);
        siharaiDomManager.insert(jt_Outai2);

        JT_Outai jt_Outai3 = new JT_Outai(P_SYONO_01, P_RENNO_03);
        siharaiDomManager.insert(jt_Outai3);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        siharaiDomManager.delete(siharaiDomManager.getAllOutai());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        Integer maxRenno = siharaiDomManager.getOutaiMaxRennoBySyono(P_SYONO_02);
        Assert.assertNull(maxRenno);
    }

    @Test
    @TestOrder(20)
    public void blankCondition() {

        Integer maxRenno = siharaiDomManager.getOutaiMaxRennoBySyono("");
        Assert.assertNull(maxRenno);
    }

    @Test
    @TestOrder(30)
    public void normal1() {

        Integer maxRenno = siharaiDomManager.getOutaiMaxRennoBySyono(P_SYONO_01);
        Assert.assertEquals(30, maxRenno.intValue());
    }
}
