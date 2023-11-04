package yuyu.def.siharai.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.JT_SateiSyouninRireki;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金<br />
 * 保険金給付金備金情報抽出<br />
 * 査定承認履歴テーブルの最大査定承認識別キー取得　請求番号かつ証券番号のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManagerTest_getSateiSyouninRirekiMaxSateisyouninskbtkeyBySknoSyono {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    static String P_SKNO_001 = "B001";
    static String P_SKNO_002 = "B002";
    static String P_SKNO_003 = "B003";
    static String P_SYONO_001 = "11807111118";
    static String P_SYONO_002 = "11807111129";
    static String P_SYONO_003 = "11807111141";
    static String P_SATEISYOUNINSKBTKEY_001 = "1";
    static String P_SATEISYOUNINSKBTKEY_002 = "2";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        Assert.assertEquals(null, siharaiDomManager.getSateiSyouninRirekiMaxSateisyouninskbtkeyBySknoSyono(P_SKNO_001, P_SYONO_001));

        JT_SkKihon skKihon1 = new JT_SkKihon(P_SKNO_001, P_SYONO_001);

        JT_SateiSyouninRireki siRireki1 = skKihon1.createSateiSyouninRireki();
        siRireki1.setSateisyouninskbtkey(P_SATEISYOUNINSKBTKEY_001);

        JT_SateiSyouninRireki siRireki2 = skKihon1.createSateiSyouninRireki();
        siRireki2.setSateisyouninskbtkey(P_SATEISYOUNINSKBTKEY_002);

        siharaiDomManager.insert(skKihon1);

        JT_SkKihon skKihon2 = new JT_SkKihon(P_SKNO_001, P_SYONO_002);

        JT_SateiSyouninRireki siRireki3 = skKihon2.createSateiSyouninRireki();
        siRireki3.setSateisyouninskbtkey(P_SATEISYOUNINSKBTKEY_001);

        siharaiDomManager.insert(skKihon2);

        JT_SkKihon skKihon3 = new JT_SkKihon(P_SKNO_002, P_SYONO_001);

        JT_SateiSyouninRireki siRireki4 = skKihon3.createSateiSyouninRireki();
        siRireki4.setSateisyouninskbtkey(P_SATEISYOUNINSKBTKEY_001);

        siharaiDomManager.insert(skKihon3);
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

        Assert.assertEquals(null, siharaiDomManager.getSateiSyouninRirekiMaxSateisyouninskbtkeyBySknoSyono(P_SKNO_003, P_SYONO_003));
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        Assert.assertEquals(P_SATEISYOUNINSKBTKEY_002, siharaiDomManager.getSateiSyouninRirekiMaxSateisyouninskbtkeyBySknoSyono(P_SKNO_001, P_SYONO_001));
    }

    @Test
    @TestOrder(30)
    public void blank1() {

        Assert.assertEquals(null, siharaiDomManager.getSateiSyouninRirekiMaxSateisyouninskbtkeyBySknoSyono("", P_SYONO_001));
    }

    @Test
    @TestOrder(40)
    public void blank2() {

        Assert.assertEquals(null, siharaiDomManager.getSateiSyouninRirekiMaxSateisyouninskbtkeyBySknoSyono(P_SKNO_001, ""));
    }
}
