package yuyu.def.db.entity;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateYM;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_AnnaijkKbn;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.sorter.SortIT_AnsyuRireki;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 案内収納履歴テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class IT_AnsyuKihonTest_getAnsyuRirekisByAnnaijkkbn {

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    SortIT_AnsyuRireki  sortIT_AnsyuRireki;

    private final static String syono1 = "11807111118";
    private final static String syono2 = "11807111129";

    private final static C_NyknaiyouKbn yknaiyouKbn1 = C_NyknaiyouKbn.KEIZOKUP;
    private final static C_NyknaiyouKbn yknaiyouKbn2 = C_NyknaiyouKbn.ZENNOUP;
    private final static C_NyknaiyouKbn yknaiyouKbn3 = C_NyknaiyouKbn.HENKOUGOP;
    private final static C_NyknaiyouKbn yknaiyouKbn4 = C_NyknaiyouKbn.HUKKATUYOUP;
    private final static C_NyknaiyouKbn yknaiyouKbn5 = C_NyknaiyouKbn.SYOKAIP;

    private final static BizDateYM jyuutouym1 = BizDateYM.valueOf("201505");
    private final static BizDateYM jyuutouym2 = BizDateYM.valueOf("201506");
    private final static BizDateYM jyuutouym3 = BizDateYM.valueOf("201507");
    private final static BizDateYM jyuutouym4 = BizDateYM.valueOf("201508");
    private final static BizDateYM jyuutouym5 = BizDateYM.valueOf("201509");
    private final static BizDateYM jyuutouym6 = BizDateYM.valueOf("201510");

    private final static int annaino1 = 1;
    private final static int annaino2 = 2;
    private final static int annaino3 = 3;
    private final static int annaino4 = 4;
    private final static int annaino5 = 5;
    private final static int annaino6 = 6;

    private final static C_AnnaijkKbn annaijkKbn1 = C_AnnaijkKbn.ANNAI;
    private final static C_AnnaijkKbn annaijkKbn2 = C_AnnaijkKbn.NYUUKIN;
    private final static C_AnnaijkKbn annaijkKbn3 = C_AnnaijkKbn.MINYUU;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syono1);

        if (ansyuKihon == null) {

            ansyuKihon = new IT_AnsyuKihon(syono1);

            Assert.assertEquals(0, ansyuKihon.getAnsyuRirekisByAnnaijkkbn(annaijkKbn1).size());

            IT_AnsyuRireki ansyuRireki1 = ansyuKihon.createAnsyuRireki();

            ansyuRireki1.setNyknaiyoukbn(yknaiyouKbn1);
            ansyuRireki1.setJyuutouym(jyuutouym1);
            ansyuRireki1.setAnnaino(annaino1);
            ansyuRireki1.setAnnaijkkbn(annaijkKbn1);

            IT_AnsyuRireki ansyuRireki2 = ansyuKihon.createAnsyuRireki();

            ansyuRireki2.setNyknaiyoukbn(yknaiyouKbn2);
            ansyuRireki2.setJyuutouym(jyuutouym2);
            ansyuRireki2.setAnnaino(annaino2);
            ansyuRireki2.setAnnaijkkbn(annaijkKbn2);

            IT_AnsyuRireki ansyuRireki3 = ansyuKihon.createAnsyuRireki();

            ansyuRireki3.setNyknaiyoukbn(yknaiyouKbn3);
            ansyuRireki3.setJyuutouym(jyuutouym3);
            ansyuRireki3.setAnnaino(annaino3);
            ansyuRireki3.setAnnaijkkbn(annaijkKbn2);

            IT_AnsyuRireki ansyuRireki4 = ansyuKihon.createAnsyuRireki();

            ansyuRireki4.setNyknaiyoukbn(yknaiyouKbn2);
            ansyuRireki4.setJyuutouym(jyuutouym4);
            ansyuRireki4.setAnnaino(annaino4);
            ansyuRireki4.setAnnaijkkbn(annaijkKbn2);

            hozenDomManager.insert(ansyuKihon);
        }

        IT_AnsyuKihon ansyuKihon2 = hozenDomManager.getAnsyuKihon(syono2);

        if (ansyuKihon2 == null) {

            ansyuKihon2 = new IT_AnsyuKihon(syono2);

            Assert.assertEquals(0, ansyuKihon2.getAnsyuRirekisByAnnaijkkbn(annaijkKbn1).size());

            IT_AnsyuRireki ansyuRireki1 = ansyuKihon2.createAnsyuRireki();

            ansyuRireki1.setNyknaiyoukbn(yknaiyouKbn4);
            ansyuRireki1.setJyuutouym(jyuutouym5);
            ansyuRireki1.setAnnaino(annaino5);
            ansyuRireki1.setAnnaijkkbn(annaijkKbn3);

            IT_AnsyuRireki ansyuRireki2 = ansyuKihon2.createAnsyuRireki();

            ansyuRireki2.setNyknaiyoukbn(yknaiyouKbn5);
            ansyuRireki2.setJyuutouym(jyuutouym6);
            ansyuRireki2.setAnnaino(annaino6);
            ansyuRireki2.setAnnaijkkbn(annaijkKbn1);

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
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syono2);
        Assert.assertEquals(0, ansyuKihon.getAnsyuRirekisByAnnaijkkbn(annaijkKbn2).size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syono2);
        Assert.assertEquals(1, ansyuKihon.getAnsyuRirekisByAnnaijkkbn(annaijkKbn3).size());

        Assert.assertEquals(syono2, ansyuKihon.getAnsyuRirekisByAnnaijkkbn(annaijkKbn3).get(0).getSyono());
        Assert.assertEquals(yknaiyouKbn4, ansyuKihon.getAnsyuRirekisByAnnaijkkbn(annaijkKbn3).get(0).getNyknaiyoukbn());
        Assert.assertEquals(jyuutouym5, ansyuKihon.getAnsyuRirekisByAnnaijkkbn(annaijkKbn3).get(0).getJyuutouym());
        Assert.assertEquals(annaino5, ansyuKihon.getAnsyuRirekisByAnnaijkkbn(annaijkKbn3).get(0).getAnnaino().intValue());
    }

    @Test
    @TestOrder(30)
    public void normal2() {
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syono1);
        List<IT_AnsyuRireki> ansyuRirekiList = ansyuKihon.getAnsyuRirekisByAnnaijkkbn(annaijkKbn2);
        Assert.assertEquals(3, ansyuRirekiList.size());

        Assert.assertEquals(syono1, ansyuRirekiList.get(1).getSyono());
        Assert.assertEquals(yknaiyouKbn2, ansyuRirekiList.get(1).getNyknaiyoukbn());
        Assert.assertEquals(jyuutouym4, ansyuRirekiList.get(1).getJyuutouym());
        Assert.assertEquals(annaino4, ansyuRirekiList.get(1).getAnnaino().intValue());

        Assert.assertEquals(syono1, ansyuRirekiList.get(2).getSyono());
        Assert.assertEquals(yknaiyouKbn3, ansyuRirekiList.get(2).getNyknaiyoukbn());
        Assert.assertEquals(jyuutouym3, ansyuRirekiList.get(2).getJyuutouym());
        Assert.assertEquals(annaino3, ansyuRirekiList.get(2).getAnnaino().intValue());

        Assert.assertEquals(syono1, ansyuRirekiList.get(0).getSyono());
        Assert.assertEquals(yknaiyouKbn2, ansyuRirekiList.get(0).getNyknaiyoukbn());
        Assert.assertEquals(jyuutouym2, ansyuRirekiList.get(0).getJyuutouym());
        Assert.assertEquals(annaino2, ansyuRirekiList.get(0).getAnnaino().intValue());
    }
}
