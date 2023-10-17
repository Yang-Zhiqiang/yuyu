package yuyu.def.siharai.manager;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金<br />
 * 申出受付<br />
 * 請求基本テーブルエンティティリスト取得(証券番号、請求種別)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManagerTest_getSkKihonsBySyonoSeikyuusyubetu {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    static String P_SKNO_01 = "001";
    static String P_SKNO_02 = "002";
    static String P_SKNO_03 = "003";
    static String P_SKNO_04 = "004";
    static String P_SKNO_05 = "005";
    static String P_SKNO_06 = "006";
    static String P_SYONO_01 = "11807111118";
    static String P_SYONO_02 = "11807111129";
    static String P_SYONO_03 = "11807111141";

    @BeforeClass
    @Transactional
    public static void TestDataInsert() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        assertEquals(0, siharaiDomManager.getSkKihonsBySyonoSeikyuusyubetu(P_SYONO_01, C_SeikyuuSyubetu.KYH).size());

        JT_SkKihon jt_SkKihon1 = new JT_SkKihon(P_SKNO_01, P_SYONO_01);
        jt_SkKihon1.setSeikyuusyubetu(C_SeikyuuSyubetu.KYH);
        siharaiDomManager.insert(jt_SkKihon1);

        JT_SkKihon jt_SkKihon2 = new JT_SkKihon(P_SKNO_02, P_SYONO_02);
        jt_SkKihon2.setSeikyuusyubetu(C_SeikyuuSyubetu.LN);
        siharaiDomManager.insert(jt_SkKihon2);

        JT_SkKihon jt_SkKihon3 = new JT_SkKihon(P_SKNO_03, P_SYONO_02);
        jt_SkKihon3.setSeikyuusyubetu(C_SeikyuuSyubetu.KOUSG);
        siharaiDomManager.insert(jt_SkKihon3);

        JT_SkKihon jt_SkKihon4 = new JT_SkKihon(P_SKNO_04, P_SYONO_02);
        jt_SkKihon4.setSeikyuusyubetu(C_SeikyuuSyubetu.KOUSG);
        siharaiDomManager.insert(jt_SkKihon4);

        JT_SkKihon jt_SkKihon5 = new JT_SkKihon(P_SKNO_05, P_SYONO_02);
        jt_SkKihon5.setSeikyuusyubetu(C_SeikyuuSyubetu.KOUSG);
        siharaiDomManager.insert(jt_SkKihon5);

        JT_SkKihon jt_SkKihon6 = new JT_SkKihon(P_SKNO_06, P_SYONO_03);
        jt_SkKihon6.setSeikyuusyubetu(C_SeikyuuSyubetu.KOUSG);
        siharaiDomManager.insert(jt_SkKihon6);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        siharaiDomManager.delete(siharaiDomManager.getAllSkKihon());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        assertEquals(0, siharaiDomManager.getSkKihonsBySyonoSeikyuusyubetu(P_SYONO_03, C_SeikyuuSyubetu.KYH).size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<JT_SkKihon> skKihonsList = siharaiDomManager.getSkKihonsBySyonoSeikyuusyubetu(P_SYONO_01, C_SeikyuuSyubetu.KYH);
        assertEquals(1, skKihonsList.size());

        assertEquals(P_SKNO_01, skKihonsList.get(0).getSkno());
        assertEquals(P_SYONO_01, skKihonsList.get(0).getSyono());
        assertEquals(C_SeikyuuSyubetu.KYH, skKihonsList.get(0).getSeikyuusyubetu());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<JT_SkKihon> skKihonsList = siharaiDomManager.getSkKihonsBySyonoSeikyuusyubetu(P_SYONO_02, C_SeikyuuSyubetu.KOUSG);
        assertEquals(3, skKihonsList.size());

        assertEquals(P_SKNO_05, skKihonsList.get(0).getSkno());
        assertEquals(P_SYONO_02, skKihonsList.get(0).getSyono());
        assertEquals(C_SeikyuuSyubetu.KOUSG, skKihonsList.get(0).getSeikyuusyubetu());

        assertEquals(P_SKNO_04, skKihonsList.get(1).getSkno());
        assertEquals(P_SYONO_02, skKihonsList.get(1).getSyono());
        assertEquals(C_SeikyuuSyubetu.KOUSG, skKihonsList.get(1).getSeikyuusyubetu());

        assertEquals(P_SKNO_03, skKihonsList.get(2).getSkno());
        assertEquals(P_SYONO_02, skKihonsList.get(2).getSyono());
        assertEquals(C_SeikyuuSyubetu.KOUSG, skKihonsList.get(2).getSeikyuusyubetu());
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<JT_SkKihon> skKihonsList = siharaiDomManager.getSkKihonsBySyonoSeikyuusyubetu("", C_SeikyuuSyubetu.KYH);
        assertEquals(0, skKihonsList.size());
    }
}
