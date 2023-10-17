package yuyu.batch.biz.bzinterf.bzrenkeihenkankyouyuudisc;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.exception.ExIllegalArgumentException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.batch.biz.bzinterf.bzrenkeihenkankyouyuudisc.BzRenkeiHenkanKyouyuuDiscDao;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.AS_KinouMode;
import yuyu.def.db.entity.AS_KinouModeSiborikomi;
import yuyu.def.db.entity.ZT_DsKariPasswordTuutiTy;
import yuyu.def.db.entity.ZT_TokuteiKankeiHoujinRn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 連携項目変換処理（共有ディスク方式）DAOクラスの<br />
 * getAllByTableid のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BzRenkeiHenkanKyouyuuDiscDaoTest_getAllByTableid {

    @Inject
    private BzRenkeiHenkanKyouyuuDiscDao bzRenkeiHenkanKyouyuuDiscDao;

    @BeforeClass
    @Transactional
    public static void TestDataInsert() {

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        BzRenkeiHenkanKyouyuuDiscDao bzRenkeiHenkanKyouyuuDiscDao = SWAKInjector.getInstance(BzRenkeiHenkanKyouyuuDiscDao.class);

        try(ExDBResults<ZT_DsKariPasswordTuutiTy> rs =  bzRenkeiHenkanKyouyuuDiscDao.getAllByTableid("ZT_DsKariPasswordTuutiTy")){
            Assert.assertFalse(rs.iterator().hasNext());
        }

        ZT_DsKariPasswordTuutiTy dsKariPasswordTuutiTy3 = new ZT_DsKariPasswordTuutiTy("abc231");

        em.persist(dsKariPasswordTuutiTy3);

        ZT_DsKariPasswordTuutiTy dsKariPasswordTuutiTy4 = new ZT_DsKariPasswordTuutiTy("abc321");

        em.persist(dsKariPasswordTuutiTy4);
        ZT_DsKariPasswordTuutiTy dsKariPasswordTuutiTy1 = new ZT_DsKariPasswordTuutiTy("abc123");

        em.persist(dsKariPasswordTuutiTy1);

        ZT_DsKariPasswordTuutiTy dsKariPasswordTuutiTy2 = new ZT_DsKariPasswordTuutiTy("abc132");

        em.persist(dsKariPasswordTuutiTy2);

        ZT_TokuteiKankeiHoujinRn tokuteiKankeiHoujinRn1 = new ZT_TokuteiKankeiHoujinRn("ab23", "ab12");
        tokuteiKankeiHoujinRn1.setZrnmarukinhyouji("1");
        tokuteiKankeiHoujinRn1.setZrntkhjnkjdrtennm("店名");
        tokuteiKankeiHoujinRn1.setZrndairitenbetutuuban("0001");
        tokuteiKankeiHoujinRn1.setZrnkanjitokuteikankeinm("人名");
        tokuteiKankeiHoujinRn1.setZrntokuteikankeihoujinnm("法人名");
        tokuteiKankeiHoujinRn1.setZrnkousinymd("20160411");
        tokuteiKankeiHoujinRn1.setZrnyobiv79("v79");

        em.persist(tokuteiKankeiHoujinRn1);

        ZT_TokuteiKankeiHoujinRn tokuteiKankeiHoujinRn2 = new ZT_TokuteiKankeiHoujinRn("ab12", "ab12");
        tokuteiKankeiHoujinRn2.setZrnmarukinhyouji("1");
        tokuteiKankeiHoujinRn2.setZrntkhjnkjdrtennm("店名");
        tokuteiKankeiHoujinRn2.setZrndairitenbetutuuban("0002");
        tokuteiKankeiHoujinRn2.setZrnkanjitokuteikankeinm("人名");
        tokuteiKankeiHoujinRn2.setZrntokuteikankeihoujinnm("法人名");
        tokuteiKankeiHoujinRn2.setZrnkousinymd("20160412");
        tokuteiKankeiHoujinRn2.setZrnyobiv79("v79");

        em.persist(tokuteiKankeiHoujinRn2);

        ZT_TokuteiKankeiHoujinRn tokuteiKankeiHoujinRn3 = new ZT_TokuteiKankeiHoujinRn("ab23", "ab32");
        tokuteiKankeiHoujinRn3.setZrnmarukinhyouji("1");
        tokuteiKankeiHoujinRn3.setZrntkhjnkjdrtennm("店名");
        tokuteiKankeiHoujinRn3.setZrndairitenbetutuuban("0003");
        tokuteiKankeiHoujinRn3.setZrnkanjitokuteikankeinm("人名");
        tokuteiKankeiHoujinRn3.setZrntokuteikankeihoujinnm("法人名");
        tokuteiKankeiHoujinRn3.setZrnkousinymd("20160413");
        tokuteiKankeiHoujinRn3.setZrnyobiv79("v79");

        em.persist(tokuteiKankeiHoujinRn3);

        ZT_TokuteiKankeiHoujinRn tokuteiKankeiHoujinRn4 = new ZT_TokuteiKankeiHoujinRn("ab23", "ab11");
        tokuteiKankeiHoujinRn4.setZrnmarukinhyouji("1");
        tokuteiKankeiHoujinRn4.setZrntkhjnkjdrtennm("店名");
        tokuteiKankeiHoujinRn4.setZrndairitenbetutuuban("0004");
        tokuteiKankeiHoujinRn4.setZrnkanjitokuteikankeinm("人名");
        tokuteiKankeiHoujinRn4.setZrntokuteikankeihoujinnm("法人名");
        tokuteiKankeiHoujinRn4.setZrnkousinymd("20160414");
        tokuteiKankeiHoujinRn4.setZrnyobiv79("v79");

        em.persist(tokuteiKankeiHoujinRn4);

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        AS_Kinou kinou1 = new AS_Kinou("10002");
        AS_KinouMode kinouMode1 = kinou1.createKinouMode();
        kinouMode1.setKinouModeId("B");
        AS_KinouModeSiborikomi kinouModeSiborikomi1 = kinouMode1.createKinouModeSiborikomi();
        kinouModeSiborikomi1.setSiborikomiId("2");
        baseDomManager.insert(kinou1);

        AS_Kinou kinou2 = new AS_Kinou("10001");
        AS_KinouMode kinouMode2 = kinou2.createKinouMode();
        kinouMode2.setKinouModeId("A");
        AS_KinouModeSiborikomi kinouModeSiborikomi2 = kinouMode2.createKinouModeSiborikomi();
        kinouModeSiborikomi2.setSiborikomiId("3");
        baseDomManager.insert(kinou2);

        AS_Kinou kinou3 = new AS_Kinou("10003");
        AS_KinouMode kinouMode4 = kinou3.createKinouMode();
        kinouMode4.setKinouModeId("B");
        AS_KinouModeSiborikomi kinouModeSiborikomi4 = kinouMode4.createKinouModeSiborikomi();
        kinouModeSiborikomi4.setSiborikomiId("1");

        AS_KinouMode kinouMode3 = kinou3.createKinouMode();
        kinouMode3.setKinouModeId("A");
        AS_KinouModeSiborikomi kinouModeSiborikomi3 = kinouMode3.createKinouModeSiborikomi();
        kinouModeSiborikomi3.setSiborikomiId("1");

        AS_KinouMode kinouMode5 = kinou3.createKinouMode();
        kinouMode5.setKinouModeId("C");
        AS_KinouModeSiborikomi kinouModeSiborikomi5 = kinouMode5.createKinouModeSiborikomi();
        kinouModeSiborikomi5.setSiborikomiId("3");
        AS_KinouModeSiborikomi kinouModeSiborikomi6 = kinouMode5.createKinouModeSiborikomi();
        kinouModeSiborikomi6.setSiborikomiId("1");
        AS_KinouModeSiborikomi kinouModeSiborikomi7 = kinouMode5.createKinouModeSiborikomi();
        kinouModeSiborikomi7.setSiborikomiId("2");
        baseDomManager.insert(kinou3);
    }


    @AfterClass
    @Transactional
    public static void deleteTestData(){
        BzRenkeiHenkanKyouyuuDiscDao bzRenkeiHenkanKyouyuuDiscDao = SWAKInjector.getInstance(BzRenkeiHenkanKyouyuuDiscDao.class);
        bzRenkeiHenkanKyouyuuDiscDao.deleteByTableid("ZT_DsKariPasswordTuutiTy");
        bzRenkeiHenkanKyouyuuDiscDao.deleteByTableid("ZT_TokuteiKankeiHoujinRn");

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        baseDomManager.delete(baseDomManager.getAllKinous());
    }



    @Test
    @TestOrder(10)
    public void Test_001() {
        int count = 0;
        try(ExDBResults<ZT_DsKariPasswordTuutiTy> rs =  bzRenkeiHenkanKyouyuuDiscDao.getAllByTableid("ZT_DsKariPasswordTuutiTy");){
            for(ZT_DsKariPasswordTuutiTy zt  : rs){

                count ++ ;
                if(count == 1){
                    assertEquals(zt.getZtykrpasswordtuutikey(),"abc123");
                }else if(count == 2){
                    assertEquals(zt.getZtykrpasswordtuutikey(),"abc132");
                }else if(count == 3){
                    assertEquals(zt.getZtykrpasswordtuutikey(),"abc231");
                }else if(count == 4){
                    assertEquals(zt.getZtykrpasswordtuutikey(),"abc321");
                }
            }
        }

        assertEquals(count, 4);
    }

    @Test
    @TestOrder(10)
    public void Test_002() {
        int count = 0;
        try(ExDBResults<ZT_TokuteiKankeiHoujinRn> rs =  bzRenkeiHenkanKyouyuuDiscDao.getAllByTableid("ZT_TokuteiKankeiHoujinRn");){
            for(ZT_TokuteiKankeiHoujinRn zt  : rs){

                count ++ ;
                if(count == 1){
                    assertEquals(zt.getZrnkinyuukikancd(),"ab12");
                    assertEquals(zt.getZrnmeisaibangou(),"ab12");
                }else if(count == 2){
                    assertEquals(zt.getZrnkinyuukikancd(),"ab23");
                    assertEquals(zt.getZrnmeisaibangou(),"ab11");
                }else if(count == 3){
                    assertEquals(zt.getZrnkinyuukikancd(),"ab23");
                    assertEquals(zt.getZrnmeisaibangou(),"ab12");
                }else if(count == 4){
                    assertEquals(zt.getZrnkinyuukikancd(),"ab23");
                    assertEquals(zt.getZrnmeisaibangou(),"ab32");
                }
            }
        }

        assertEquals(count, 4);
    }

    @Test
    @TestOrder(30)
    public void Test_003() {
        int count = 0;
        try(ExDBResults<AS_KinouModeSiborikomi> rs =  bzRenkeiHenkanKyouyuuDiscDao.getAllByTableid("AS_KinouModeSiborikomi");){
            for(AS_KinouModeSiborikomi zt  : rs){

                count ++ ;
                if(count == 1){
                    assertEquals(zt.getKinouId(),"10001");
                    assertEquals(zt.getKinouModeId(),"A");
                    assertEquals(zt.getSiborikomiId(),"3");
                }else if(count == 2){
                    assertEquals(zt.getKinouId(),"10002");
                    assertEquals(zt.getKinouModeId(),"B");
                    assertEquals(zt.getSiborikomiId(),"2");
                }else if(count == 3){
                    assertEquals(zt.getKinouId(),"10003");
                    assertEquals(zt.getKinouModeId(),"A");
                    assertEquals(zt.getSiborikomiId(),"1");
                }else if(count == 4){
                    assertEquals(zt.getKinouId(),"10003");
                    assertEquals(zt.getKinouModeId(),"B");
                    assertEquals(zt.getSiborikomiId(),"1");
                }else if(count == 5){
                    assertEquals(zt.getKinouId(),"10003");
                    assertEquals(zt.getKinouModeId(),"C");
                    assertEquals(zt.getSiborikomiId(),"1");

                }else if(count == 6){
                    assertEquals(zt.getKinouId(),"10003");
                    assertEquals(zt.getKinouModeId(),"C");
                    assertEquals(zt.getSiborikomiId(),"2");
                }else if(count == 7){
                    assertEquals(zt.getKinouId(),"10003");
                    assertEquals(zt.getKinouModeId(),"C");
                    assertEquals(zt.getSiborikomiId(),"3");
                }
            }
        }

        assertEquals(count, 7);
    }

    @Test
    @TestOrder(40)
    public void Test_004() {
        try{
            bzRenkeiHenkanKyouyuuDiscDao.getAllByTableid("ZT_DsKariPassword");
        }catch (ExIllegalArgumentException e) {
            assertEquals(e.getMessage(),"引数が異常です。(指定されたテーブルID[ZT_DsKariPassword]は不正です。)");
        }

    }
}
