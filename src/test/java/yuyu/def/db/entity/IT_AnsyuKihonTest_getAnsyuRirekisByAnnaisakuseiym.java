package yuyu.def.db.entity;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 案内収納履歴テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class IT_AnsyuKihonTest_getAnsyuRirekisByAnnaisakuseiym {

    @Inject
    private HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_AnsyuKihon ansyuKihon1 = hozenDomManager.getAnsyuKihon("11807111118");
        if (ansyuKihon1 == null) {
            ansyuKihon1 = new IT_AnsyuKihon("10","11807111118");
            List<IT_AnsyuRireki> ansyuRirekiLst = ansyuKihon1.getAnsyuRirekisByAnnaisakuseiym(BizDateYM.valueOf(201602));
            Assert.assertEquals(0, ansyuRirekiLst.size());

            IT_AnsyuRireki ansyuRireki1 = ansyuKihon1.createAnsyuRireki();
            ansyuRireki1.setNyknaiyoukbn(C_NyknaiyouKbn.valueOf("1"));
            ansyuRireki1.setJyuutouym(BizDateYM.valueOf(201602));
            ansyuRireki1.setAnnaino(10);
            ansyuRireki1.setAnnaisakuseiymd(BizDate.valueOf(20160225));

            IT_AnsyuRireki ansyuRireki2 = ansyuKihon1.createAnsyuRireki();
            ansyuRireki2.setNyknaiyoukbn(C_NyknaiyouKbn.valueOf("1"));
            ansyuRireki2.setJyuutouym(BizDateYM.valueOf(201602));
            ansyuRireki2.setAnnaino(11);
            ansyuRireki2.setAnnaisakuseiymd(BizDate.valueOf(20160125));

            hozenDomManager.insert(ansyuKihon1);

            IT_AnsyuKihon ansyuKihon2 = new IT_AnsyuKihon("10", "11807111129");

            IT_AnsyuRireki ansyuRireki3 = ansyuKihon2.createAnsyuRireki();
            ansyuRireki3.setNyknaiyoukbn(C_NyknaiyouKbn.valueOf("1"));
            ansyuRireki3.setJyuutouym(BizDateYM.valueOf(201602));
            ansyuRireki3.setAnnaino(12);
            ansyuRireki3.setAnnaisakuseiymd(BizDate.valueOf(20160201));

            IT_AnsyuRireki ansyuRireki4 = ansyuKihon2.createAnsyuRireki();
            ansyuRireki4.setNyknaiyoukbn(C_NyknaiyouKbn.valueOf("1"));
            ansyuRireki4.setJyuutouym(BizDateYM.valueOf(201602));
            ansyuRireki4.setAnnaino(13);
            ansyuRireki4.setAnnaisakuseiymd(BizDate.valueOf(20160325));

            IT_AnsyuRireki ansyuRireki5 = ansyuKihon2.createAnsyuRireki();
            ansyuRireki5.setNyknaiyoukbn(C_NyknaiyouKbn.valueOf("1"));
            ansyuRireki5.setJyuutouym(BizDateYM.valueOf(201602));
            ansyuRireki5.setAnnaino(14);
            ansyuRireki5.setAnnaisakuseiymd(BizDate.valueOf(20160425));

            IT_AnsyuRireki ansyuRireki6 = ansyuKihon2.createAnsyuRireki();
            ansyuRireki6.setNyknaiyoukbn(C_NyknaiyouKbn.valueOf("1"));
            ansyuRireki6.setJyuutouym(BizDateYM.valueOf(201602));
            ansyuRireki6.setAnnaino(15);

            hozenDomManager.insert(ansyuKihon2);


        }
    }
    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllAnsyuKihon());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        IT_AnsyuKihon ansyuKihon1 = hozenDomManager.getAnsyuKihon("11807111118");
        List<IT_AnsyuRireki> ansyuRirekiLst = ansyuKihon1.getAnsyuRirekisByAnnaisakuseiym(BizDateYM.valueOf(201606));
        Assert.assertEquals(0, ansyuRirekiLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        IT_AnsyuKihon ansyuKihon1 = hozenDomManager.getAnsyuKihon("11807111118");
        List<IT_AnsyuRireki> ansyuRirekiLst = ansyuKihon1.getAnsyuRirekisByAnnaisakuseiym(BizDateYM.valueOf(201602));
        Assert.assertEquals(1, ansyuRirekiLst.size());

        Assert.assertEquals("10", ansyuRirekiLst.get(0).getKbnkey());
        Assert.assertEquals("11807111118", ansyuRirekiLst.get(0).getSyono());
        Assert.assertEquals(C_NyknaiyouKbn.KEIZOKUP, ansyuRirekiLst.get(0).getNyknaiyoukbn());
        Assert.assertEquals(BizDateYM.valueOf(201602), ansyuRirekiLst.get(0).getJyuutouym());
        Assert.assertEquals(10, ansyuRirekiLst.get(0).getAnnaino().intValue());
        Assert.assertEquals(BizDate.valueOf(20160225), ansyuRirekiLst.get(0).getAnnaisakuseiymd());

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal2() {

        IT_AnsyuKihon ansyuKihon1 = hozenDomManager.getAnsyuKihon("11807111129");
        List<IT_AnsyuRireki> ansyuRirekiLst = ansyuKihon1.getAnsyuRirekisByAnnaisakuseiym(BizDateYM.valueOf(201602));
        Assert.assertEquals(3, ansyuRirekiLst.size());

        Assert.assertEquals("10", ansyuRirekiLst.get(0).getKbnkey());
        Assert.assertEquals("11807111129", ansyuRirekiLst.get(0).getSyono());
        Assert.assertEquals(C_NyknaiyouKbn.KEIZOKUP, ansyuRirekiLst.get(0).getNyknaiyoukbn());
        Assert.assertEquals(BizDateYM.valueOf(201602), ansyuRirekiLst.get(0).getJyuutouym());
        Assert.assertEquals(12, ansyuRirekiLst.get(0).getAnnaino().intValue());
        Assert.assertEquals(BizDate.valueOf(20160201), ansyuRirekiLst.get(0).getAnnaisakuseiymd());

        Assert.assertEquals("10", ansyuRirekiLst.get(1).getKbnkey());
        Assert.assertEquals("11807111129", ansyuRirekiLst.get(1).getSyono());
        Assert.assertEquals(C_NyknaiyouKbn.KEIZOKUP, ansyuRirekiLst.get(1).getNyknaiyoukbn());
        Assert.assertEquals(BizDateYM.valueOf(201602), ansyuRirekiLst.get(1).getJyuutouym());
        Assert.assertEquals(13, ansyuRirekiLst.get(1).getAnnaino().intValue());
        Assert.assertEquals(BizDate.valueOf(20160325), ansyuRirekiLst.get(1).getAnnaisakuseiymd());

        Assert.assertEquals("10", ansyuRirekiLst.get(2).getKbnkey());
        Assert.assertEquals("11807111129", ansyuRirekiLst.get(2).getSyono());
        Assert.assertEquals(C_NyknaiyouKbn.KEIZOKUP, ansyuRirekiLst.get(2).getNyknaiyoukbn());
        Assert.assertEquals(BizDateYM.valueOf(201602), ansyuRirekiLst.get(2).getJyuutouym());
        Assert.assertEquals(14, ansyuRirekiLst.get(2).getAnnaino().intValue());
        Assert.assertEquals(BizDate.valueOf(20160425), ansyuRirekiLst.get(2).getAnnaisakuseiymd());
    }

}
