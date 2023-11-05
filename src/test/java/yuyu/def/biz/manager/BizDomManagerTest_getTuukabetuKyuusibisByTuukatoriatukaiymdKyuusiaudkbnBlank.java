package yuyu.def.biz.manager;

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

import yuyu.def.classification.C_ToriatukaibiKbn;
import yuyu.def.db.entity.BM_TuukabetuKyuusibi;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getTuukabetuKyuusibisByTuukatoriatukaiymdKyuusiaudkbnBlank() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getTuukabetuKyuusibisByTuukatoriatukaiymdKyuusiaudkbnBlank {

    @Inject
    private BizDomManager bizDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_TuukabetuKyuusibi> tuukabetuKyuusibiLst = bizDomManager.getTuukabetuKyuusibisByTuukatoriatukaiymdKyuusiaudkbnBlank(
                BizDate.valueOf(20160720),BizDate.valueOf(20160721));
        Assert.assertEquals(0, tuukabetuKyuusibiLst.size());

        BM_TuukabetuKyuusibi tuukabetuKyuusibi1 = new BM_TuukabetuKyuusibi(BizDate.valueOf(20160720));
        tuukabetuKyuusibi1.setKyuusiaudkbn(C_ToriatukaibiKbn.valueOf("0"));

        bizDomManager.insert(tuukabetuKyuusibi1);

        BM_TuukabetuKyuusibi tuukabetuKyuusibi2 = new BM_TuukabetuKyuusibi(BizDate.valueOf(20160721));
        tuukabetuKyuusibi2.setKyuusiaudkbn(C_ToriatukaibiKbn.valueOf("1"));

        bizDomManager.insert(tuukabetuKyuusibi2);

        BM_TuukabetuKyuusibi tuukabetuKyuusibi3 = new BM_TuukabetuKyuusibi(BizDate.valueOf(20160719));
        tuukabetuKyuusibi3.setKyuusiaudkbn(C_ToriatukaibiKbn.valueOf("0"));

        bizDomManager.insert(tuukabetuKyuusibi3);

        BM_TuukabetuKyuusibi tuukabetuKyuusibi4 = new BM_TuukabetuKyuusibi(BizDate.valueOf(20160722));
        tuukabetuKyuusibi4.setKyuusiaudkbn(C_ToriatukaibiKbn.valueOf("0"));

        bizDomManager.insert(tuukabetuKyuusibi4);

        BM_TuukabetuKyuusibi tuukabetuKyuusibi5 = new BM_TuukabetuKyuusibi(BizDate.valueOf(20160821));
        tuukabetuKyuusibi5.setKyuusiaudkbn(C_ToriatukaibiKbn.valueOf("0"));

        bizDomManager.insert(tuukabetuKyuusibi5);

        BM_TuukabetuKyuusibi tuukabetuKyuusibi6 = new BM_TuukabetuKyuusibi(BizDate.valueOf(20160820));
        tuukabetuKyuusibi6.setKyuusiaudkbn(C_ToriatukaibiKbn.valueOf("0"));

        bizDomManager.insert(tuukabetuKyuusibi6);

        BM_TuukabetuKyuusibi tuukabetuKyuusibi7 = new BM_TuukabetuKyuusibi(BizDate.valueOf(20160819));
        tuukabetuKyuusibi7.setKyuusiaudkbn(C_ToriatukaibiKbn.valueOf("0"));

        bizDomManager.insert(tuukabetuKyuusibi7);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllTuukabetuKyuusibi());

    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<BM_TuukabetuKyuusibi> tuukabetuKyuusibiLst = bizDomManager.getTuukabetuKyuusibisByTuukatoriatukaiymdKyuusiaudkbnBlank(
                BizDate.valueOf(20150720),BizDate.valueOf(20150722));

        Assert.assertEquals(0, tuukabetuKyuusibiLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<BM_TuukabetuKyuusibi> tuukabetuKyuusibiLst = bizDomManager.getTuukabetuKyuusibisByTuukatoriatukaiymdKyuusiaudkbnBlank(
                BizDate.valueOf(20160720),BizDate.valueOf(20160721));

        Assert.assertEquals(1, tuukabetuKyuusibiLst.size());
        Assert.assertEquals(BizDate.valueOf(20160720), tuukabetuKyuusibiLst.get(0).getTuukatoriatukaiymd());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<BM_TuukabetuKyuusibi> tuukabetuKyuusibiLst = bizDomManager.getTuukabetuKyuusibisByTuukatoriatukaiymdKyuusiaudkbnBlank(
                BizDate.valueOf(20160819),BizDate.valueOf(20160821));

        Assert.assertEquals(3, tuukabetuKyuusibiLst.size());
        Assert.assertEquals(BizDate.valueOf(20160819), tuukabetuKyuusibiLst.get(0).getTuukatoriatukaiymd());
        Assert.assertEquals(BizDate.valueOf(20160820), tuukabetuKyuusibiLst.get(1).getTuukatoriatukaiymd());
        Assert.assertEquals(BizDate.valueOf(20160821), tuukabetuKyuusibiLst.get(2).getTuukatoriatukaiymd());
    }

}