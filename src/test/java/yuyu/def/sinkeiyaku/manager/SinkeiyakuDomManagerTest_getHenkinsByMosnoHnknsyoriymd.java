package yuyu.def.sinkeiyaku.manager;

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

import yuyu.def.db.entity.HT_Henkin;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getHenkinsByMosnoHnknsyoriymd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getHenkinsByMosnoHnknsyoriymd {
    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);


        List<HT_Henkin> henkinLst = sinkeiyakuDomManager.getHenkinsByMosnoHnknsyoriymd("791112220", BizDate.valueOf(20160407));

        Assert.assertEquals(0,henkinLst.size());

        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL("791112220");
        if( syoriCTL1 == null ) {
            syoriCTL1 = new HT_SyoriCTL("791112220");

            HT_Henkin henkin1 = syoriCTL1.createHenkin();
            henkin1.setRenno(1);
            henkin1.setHnknsyoriymd(BizDate.valueOf(20160408));

            sinkeiyakuDomManager.insert(syoriCTL1);
        }

        HT_SyoriCTL syoriCTL2 = sinkeiyakuDomManager.getSyoriCTL("791112410");
        if( syoriCTL2 == null ) {
            syoriCTL2 = new HT_SyoriCTL("791112410");

            HT_Henkin henkin2 = syoriCTL2.createHenkin();
            henkin2.setRenno(1);
            henkin2.setHnknsyoriymd(BizDate.valueOf(20160408));

            HT_Henkin henkin3 = syoriCTL2.createHenkin();
            henkin3.setRenno(2);
            henkin3.setHnknsyoriymd(BizDate.valueOf(20160407));

            HT_Henkin henkin4 = syoriCTL2.createHenkin();
            henkin4.setRenno(3);
            henkin4.setHnknsyoriymd(BizDate.valueOf(20160406));

            HT_Henkin henkin5 = syoriCTL2.createHenkin();
            henkin5.setRenno(4);
            henkin5.setHnknsyoriymd(BizDate.valueOf(20160405));

            HT_Henkin henkin6 = syoriCTL2.createHenkin();
            henkin6.setRenno(5);

            HT_Henkin henkin7 = syoriCTL2.createHenkin();
            henkin7.setRenno(6);
            henkin7.setHnknsyoriymd(BizDate.valueOf(20160408));

            sinkeiyakuDomManager.insert(syoriCTL2);
        }

        HT_SyoriCTL syoriCTL3 = sinkeiyakuDomManager.getSyoriCTL("791112501");
        if( syoriCTL3 == null ) {
            syoriCTL3 = new HT_SyoriCTL("791112501");

            HT_Henkin henkin1 = syoriCTL3.createHenkin();
            henkin1.setRenno(1);
            henkin1.setHnknsyoriymd(BizDate.valueOf(20160408));

            sinkeiyakuDomManager.insert(syoriCTL3);
        }

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
    }

    @Test
    @TestOrder(40)
    public void noResult1(){

        List<HT_Henkin> henkinLst = sinkeiyakuDomManager.getHenkinsByMosnoHnknsyoriymd("791112519", BizDate.valueOf(20160406));

        Assert.assertEquals(0, henkinLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<HT_Henkin> henkinLst = sinkeiyakuDomManager.getHenkinsByMosnoHnknsyoriymd("791112220", BizDate.valueOf(20160407));
        Assert.assertEquals(1, henkinLst.size());

        Assert.assertEquals("791112220", henkinLst.get(0).getMosno());
        Assert.assertEquals(1, henkinLst.get(0).getRenno().intValue());
        Assert.assertEquals(BizDate.valueOf(20160408), henkinLst.get(0).getHnknsyoriymd());
    }
    @Test
    @TestOrder(30)
    public void normal2(){



        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("791112410",1,"20160408"), "1");
        datamap.put($("791112410",2,"20160407"), "1");
        datamap.put($("791112410",3,"20160406"), "1");
        datamap.put($("791112410",5,"null"), "1");

        List<HT_Henkin> henkinLst = sinkeiyakuDomManager.getHenkinsByMosnoHnknsyoriymd("791112410", BizDate.valueOf(20160406));

        for(HT_Henkin henkin:henkinLst){

            String hnknsyoriymd = "null";
            if(!(henkin.getHnknsyoriymd()==null)){
                hnknsyoriymd = henkin.getHnknsyoriymd().toString();
            }

            datamap.remove($(
                henkin.getMosno(),
                henkin.getRenno().intValue(),
                hnknsyoriymd));

        }

        Assert.assertEquals(3, henkinLst.size());

        Assert.assertTrue(datamap.isEmpty());

    }

    @Test
    @TestOrder(40)
    public void blank() {

        List<HT_Henkin> henkinLst = sinkeiyakuDomManager.getHenkinsByMosnoHnknsyoriymd("", BizDate.valueOf(20160407));
        Assert.assertEquals(0, henkinLst.size());

    }
}
