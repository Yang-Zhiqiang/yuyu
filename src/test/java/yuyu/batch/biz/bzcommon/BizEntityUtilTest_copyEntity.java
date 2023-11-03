package yuyu.batch.biz.bzcommon;


import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.bzcommon.BizEntityUtil;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.db.entity.BM_Syoritanto;
import yuyu.def.db.entity.BM_TantouCd;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.BT_HituyouSyoruiKanri;
import yuyu.def.db.entity.BT_IdouKhBosyuudr;
import yuyu.def.db.entity.BT_IdouKhMeigi;
import yuyu.def.db.entity.BT_TjtIdouNyKh;
import yuyu.def.db.entity.BT_TyouhyouOutputKengen;

@RunWith(SWAKTestRunner.class)
public class BizEntityUtilTest_copyEntity {

    @Inject
    private ExDBEntityManager em;

    @Inject
    private BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void prepairData(){
        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        BT_TyouhyouOutputKengen kengen1 = new BT_TyouhyouOutputKengen("T001",C_SyoruiCdKbn.CM_BATCH_FBSOUKINMEISAI_4);
        kengen1.setIkkatuoutputkahikbn(C_KahiKbn.HUKA);
        kengen1.setKobetuoutputkahikbn(C_KahiKbn.KA);
        kengen1.setGyoumuKousinsyaId("dan");
        kengen1.setGyoumuKousinTime("20160100606060600");
        em.persist(kengen1);


        BM_Syoritanto tanto1 = new BM_Syoritanto("S001");
        tanto1.setTantocd(C_TantouCdKbn.BLNK10);
        BM_TantouCd tantoucd1 = new BM_TantouCd(C_TantouCdKbn.BLNK10);
        tantoucd1.setBusitucd("B01");
        tantoucd1.setTantounm("複製");
        tantoucd1.setBusitunm("DOMチーム");
        em.persist(tanto1);
        em.persist(tantoucd1);


        BT_GyoumuKouteiInfo info1 = new BT_GyoumuKouteiInfo("KR001");
        info1.setSubSystemId("biz");
        info1.setJimutetuzukicd("JIMUCD001");
        BT_HituyouSyoruiKanri kanri2 = info1.createHituyouSyoruiKanri();
        kanri2.setSyoruiCd(C_SyoruiCdKbn.CM_BATCH_FBSOUKINMEISAI_4);
        kanri2.setGyoumuKousinsyaId("ID01");
        kanri2.setGyoumuKousinTime("2016100609090900");
        BT_HituyouSyoruiKanri kanri1 = info1.createHituyouSyoruiKanri();
        kanri1.setSyoruiCd(C_SyoruiCdKbn.CM_BATCH_GKFBFURIKOMIKEI);
        kanri1.setGyoumuKousinsyaId("ID01");
        kanri1.setGyoumuKousinTime("2016100609090900");
        em.persist(info1);



        BT_TjtIdouNyKh nykh1 = new BT_TjtIdouNyKh("SYONO0001",10);
        BT_IdouKhMeigi meigi1 = nykh1.createIdouKhMeigi();
        BT_IdouKhBosyuudr syuudr1 = nykh1.createIdouKhBosyuudr();
        em.persist(nykh1);


    }

    @AfterClass
    @Transactional
    public static void clearData(){
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getTyouhyouOutputKengen("T001",C_SyoruiCdKbn.CM_BATCH_FBSOUKINMEISAI_4));
        bizDomManager.delete(bizDomManager.getSyoritanto("S001"));
        bizDomManager.delete(bizDomManager.getGyoumuKouteiInfo("KR001"));
        bizDomManager.delete(bizDomManager.getTjtIdouNyKh("SYONO0001",10));
        bizDomManager.delete(bizDomManager.getTantouCd(C_TantouCdKbn.BLNK10));
    }



    @Test
    @Transactional
    public void test01(){
        System.out.println("test01 start---------------------------------------------------");
        BT_TyouhyouOutputKengen kengen1 = bizDomManager.getTyouhyouOutputKengen("T001",C_SyoruiCdKbn.CM_BATCH_FBSOUKINMEISAI_4);
        BT_TyouhyouOutputKengen kengen2 = BizEntityUtil.copyEntity(kengen1);
        System.out.println("コピー前：" + kengen1.toString());
        System.out.println("コピー後：" + kengen2.toString());
        Assert.assertEquals(kengen1, kengen2);

        System.out.println("test01 end-----------------------------------------------------");
    }

    @Test
    @Transactional
    public void test02(){
        System.out.println("test02 start---------------------------------------------------");
        BT_TyouhyouOutputKengen kengen1 = bizDomManager.getTyouhyouOutputKengen("T001",C_SyoruiCdKbn.CM_BATCH_FBSOUKINMEISAI_4);
        BT_TyouhyouOutputKengen kengen2 = BizEntityUtil.copyEntity(kengen1);
        Assert.assertEquals(kengen1, kengen2);
        kengen2.setIkkatuoutputkahikbn(C_KahiKbn.KA);
        System.out.println("コピー前：" + kengen1.toString());
        System.out.println("コピー後：" + kengen2.toString());
        Assert.assertNotEquals(kengen1, kengen2);
        System.out.println("test02 end-----------------------------------------------------");
    }

    @Test
    @Transactional
    public void test03(){
        System.out.println("test03 start---------------------------------------------------");
        BT_TyouhyouOutputKengen kengen1 = bizDomManager.getTyouhyouOutputKengen("T001",C_SyoruiCdKbn.CM_BATCH_FBSOUKINMEISAI_4);
        BT_TyouhyouOutputKengen kengen2 = BizEntityUtil.copyEntity(kengen1);
        Assert.assertEquals(kengen1, kengen2);
        kengen1.setIkkatuoutputkahikbn(C_KahiKbn.KA);
        System.out.println("コピー前：" + kengen1.toString());
        System.out.println("コピー後：" + kengen2.toString());
        Assert.assertNotEquals(kengen1, kengen2);
        System.out.println("test03 end-----------------------------------------------------");
    }



    @Test
    @Transactional
    public void test04(){
        System.out.println("test04 start---------------------------------------------------");
        BM_Syoritanto tanto1 = bizDomManager.getSyoritanto("S001");
        BM_Syoritanto tanto2  = BizEntityUtil.copyEntity(tanto1);
        System.out.println("コピー前：" + tanto1.toString());
        System.out.println("コピー後：" + tanto2.toString());
        Assert.assertEquals(tanto1, tanto2);
        System.out.println("コピー前：" + tanto1.getTantouCd().toString());
        System.out.println("コピー後：" + tanto2.getTantouCd().toString());
        Assert.assertEquals(tanto1.getTantouCd(), tanto2.getTantouCd());
        System.out.println("test04 end-----------------------------------------------------");
    }

    @Test
    @Transactional
    public void test05(){
        System.out.println("test05 start---------------------------------------------------");
        BM_Syoritanto tanto1 = bizDomManager.getSyoritanto("S001");
        BM_Syoritanto tanto2  = BizEntityUtil.copyEntity(tanto1);
        Assert.assertEquals(tanto1, tanto2);
        tanto2.setTantocd(C_TantouCdKbn.BLNK11);
        System.out.println("コピー前：" + tanto1.toString());
        System.out.println("コピー後：" + tanto2.toString());
        Assert.assertNotEquals(tanto1, tanto2);
        Assert.assertEquals(tanto1.getTantouCd(), tanto2.getTantouCd());
        tanto2.getTantouCd().setBusitucd("33");
        System.out.println("コピー前：" + tanto1.getTantouCd().toString());
        System.out.println("コピー後：" + tanto2.getTantouCd().toString());
        Assert.assertNotEquals(tanto1.getTantouCd(), tanto2.getTantouCd());
        System.out.println("test05 end-----------------------------------------------------");
    }

    @Test
    @Transactional
    public void test06(){
        System.out.println("test06 start---------------------------------------------------");
        BM_Syoritanto tanto1 = bizDomManager.getSyoritanto("S001");
        BM_Syoritanto tanto2  = BizEntityUtil.copyEntity(tanto1);
        Assert.assertEquals(tanto1, tanto2);
        tanto1.setTantocd(C_TantouCdKbn.BLNK11);
        System.out.println("コピー前：" + tanto1.toString());
        System.out.println("コピー後：" + tanto2.toString());
        Assert.assertNotEquals(tanto1, tanto2);
        Assert.assertEquals(tanto1.getTantouCd(), tanto2.getTantouCd());
        tanto1.getTantouCd().setBusitucd("33");
        System.out.println("コピー前：" + tanto1.getTantouCd().toString());
        System.out.println("コピー後：" + tanto2.getTantouCd().toString());
        Assert.assertNotEquals(tanto1.getTantouCd(), tanto2.getTantouCd());
        System.out.println("test06 end-----------------------------------------------------");
    }




    @Test
    @Transactional
    public void test07(){
        System.out.println("test07 start---------------------------------------------------");
        BT_HituyouSyoruiKanri condition = new BT_HituyouSyoruiKanri("KR001",C_SyoruiCdKbn.CM_BATCH_FBSOUKINMEISAI_4);
        BT_HituyouSyoruiKanri koutei1 = em.findByPK(condition);
        BT_HituyouSyoruiKanri koutei2 = BizEntityUtil.copyEntity(koutei1);
        Assert.assertEquals(koutei1, koutei2);
        Assert.assertEquals(koutei1.getGyoumuKouteiInfo(), koutei2.getGyoumuKouteiInfo());
        System.out.println("コピー元.get親.getコピー元s().size　＝ " + koutei1.getGyoumuKouteiInfo().getHituyouSyoruiKanris().size());

        System.out.println("test07 end-----------------------------------------------------");
    }


    @Test
    @Transactional
    public void test08(){
        System.out.println("test08 start---------------------------------------------------");
        BT_HituyouSyoruiKanri condition = new BT_HituyouSyoruiKanri("KR001",C_SyoruiCdKbn.CM_BATCH_FBSOUKINMEISAI_4);
        BT_HituyouSyoruiKanri koutei1 = em.findByPK(condition);
        BT_HituyouSyoruiKanri koutei2 = BizEntityUtil.copyEntity(koutei1);
        Assert.assertEquals(koutei1, koutei2);
        Assert.assertEquals(koutei1.getGyoumuKouteiInfo(), koutei2.getGyoumuKouteiInfo());
        koutei2.getGyoumuKouteiInfo().setSyono("222");
        Assert.assertNotEquals(koutei1.getGyoumuKouteiInfo(), koutei2.getGyoumuKouteiInfo());
        System.out.println("test08 end-----------------------------------------------------");
    }

    @Test
    public void test08_end(){
        System.out.println("test08_end start---------------------------------------------------");
        BT_HituyouSyoruiKanri condition = new BT_HituyouSyoruiKanri("KR001",C_SyoruiCdKbn.CM_BATCH_FBSOUKINMEISAI_4);
        BT_HituyouSyoruiKanri koutei1 = em.findByPK(condition);
        Assert.assertNotEquals(koutei1.getGyoumuKouteiInfo().getSyono(), "222");
        System.out.println("test08_end end-----------------------------------------------------");
    }

    @Test
    @Transactional
    public void test09(){
        System.out.println("test09 start---------------------------------------------------");
        BT_HituyouSyoruiKanri condition = new BT_HituyouSyoruiKanri("KR001",C_SyoruiCdKbn.CM_BATCH_FBSOUKINMEISAI_4);
        BT_HituyouSyoruiKanri koutei1 = em.findByPK(condition);
        BT_HituyouSyoruiKanri koutei2 = BizEntityUtil.copyEntity(koutei1);
        Assert.assertEquals(koutei1, koutei2);
        Assert.assertEquals(koutei1.getGyoumuKouteiInfo(), koutei2.getGyoumuKouteiInfo());
        koutei1.getGyoumuKouteiInfo().setSyono("222");
        Assert.assertNotEquals(koutei1.getGyoumuKouteiInfo(), koutei2.getGyoumuKouteiInfo());
        System.out.println("test09 end-----------------------------------------------------");
    }

    @Test
    public void test09_end(){
        System.out.println("test09_end start---------------------------------------------------");
        BT_HituyouSyoruiKanri condition = new BT_HituyouSyoruiKanri("KR001",C_SyoruiCdKbn.CM_BATCH_FBSOUKINMEISAI_4);
        BT_HituyouSyoruiKanri koutei1 = em.findByPK(condition);
        Assert.assertEquals(koutei1.getGyoumuKouteiInfo().getSyono(), "222");
        System.out.println("test09_end end-----------------------------------------------------");
    }


    @Test
    @Transactional
    public void test10(){
        System.out.println("test10 start---------------------------------------------------");
        BT_TjtIdouNyKh nykh1 =bizDomManager.getTjtIdouNyKh("SYONO0001",10);
        nykh1.getIdouKhMeigi();
        nykh1.getIdouKhBosyuudr();
        BT_TjtIdouNyKh nykh2 = BizEntityUtil.copyEntity(nykh1);
        Assert.assertEquals(nykh1, nykh2);
        Assert.assertEquals(nykh1.getIdouKhMeigi(), nykh2.getIdouKhMeigi());
        Assert.assertEquals(nykh1.getIdouKhBosyuudr(), nykh2.getIdouKhBosyuudr());
        System.out.println("test10 end-----------------------------------------------------");
    }

    @Test
    @Transactional
    public void test11(){
        System.out.println("test11 start---------------------------------------------------");
        BT_TjtIdouNyKh nykh1 =bizDomManager.getTjtIdouNyKh("SYONO0001",10);
        nykh1.getIdouKhMeigi();
        nykh1.getIdouKhBosyuudr();
        BT_TjtIdouNyKh nykh2 = BizEntityUtil.copyEntity(nykh1);

        nykh2.getIdouKhBosyuudrs().clear();
        nykh2.getIdouKhMeigi().setHhknadr1kj("漢字");
        Assert.assertNotEquals(nykh1.getIdouKhMeigi(), nykh2.getIdouKhMeigi());
        Assert.assertNotEquals(nykh1.getIdouKhBosyuudrs(), nykh2.getIdouKhBosyuudrs());
        System.out.println("test11 end-----------------------------------------------------");
    }
    @Test
    public void test11_end(){
        System.out.println("test11_end start---------------------------------------------------");
        BT_TjtIdouNyKh nykh1 =bizDomManager.getTjtIdouNyKh("SYONO0001",10);
        Assert.assertEquals(nykh1.getIdouKhMeigi().getHhknadr1kj(), null);
        Assert.assertEquals(nykh1.getIdouKhBosyuudr().getRenno3keta(), Integer.valueOf(10));
        System.out.println("test11_end end-----------------------------------------------------");
    }

    @Test
    @Transactional
    public void test12(){
        System.out.println("test12 start---------------------------------------------------");
        BT_TjtIdouNyKh nykh1 =bizDomManager.getTjtIdouNyKh("SYONO0001",10);
        nykh1.getIdouKhMeigi();
        nykh1.getIdouKhBosyuudr();
        BT_TjtIdouNyKh nykh2 = BizEntityUtil.copyEntity(nykh1);
        Assert.assertEquals(nykh1.getIdouKhMeigi(), nykh2.getIdouKhMeigi());
        nykh1.getIdouKhMeigi().setHhknadr1kj("幹事");
        Assert.assertNotEquals(nykh1.getIdouKhMeigi(), nykh2.getIdouKhMeigi());
        System.out.println("test12 end-----------------------------------------------------");
    }
    @Test
    public void test12_end(){
        System.out.println("test12_end start---------------------------------------------------");
        BT_TjtIdouNyKh nykh1 =bizDomManager.getTjtIdouNyKh("SYONO0001",10);
        Assert.assertEquals(nykh1.getIdouKhMeigi().getHhknadr1kj(),"幹事");
        System.out.println("test12_end end-----------------------------------------------------");
    }


    @Test
    @Transactional
    public void test13(){
        System.out.println("test13 start---------------------------------------------------");
        BT_GyoumuKouteiInfo info1 = bizDomManager.getGyoumuKouteiInfo("KR001");
        List<BT_HituyouSyoruiKanri> list = info1.getHituyouSyoruiKanris();
        list.size();
        BT_GyoumuKouteiInfo info2 = BizEntityUtil.copyEntity(info1);
        Assert.assertEquals(info1, info2);
        BT_HituyouSyoruiKanri tmp =  list.get(0);
        list.set(0, list.get(1));
        list.set(1, tmp);
        Assert.assertNotEquals(info1.getHituyouSyoruiKanris(),info2.getHituyouSyoruiKanris());
        System.out.println("test13 end-----------------------------------------------------");
    }

    @Test
    @Transactional
    public void test14(){
        System.out.println("test14 start---------------------------------------------------");
        BT_GyoumuKouteiInfo info1 = bizDomManager.getGyoumuKouteiInfo("KR001");
        List<BT_HituyouSyoruiKanri> list = info1.getHituyouSyoruiKanris();
        list.size();
        BT_GyoumuKouteiInfo info2 = BizEntityUtil.copyEntity(info1);
        Assert.assertEquals(info1, info2);
        BT_HituyouSyoruiKanri tmp =  new BT_HituyouSyoruiKanri("KR001",C_SyoruiCdKbn.CM_GKHURIKOMIERRINFOLIST);
        list.add(tmp);
        Assert.assertNotEquals(info1.getHituyouSyoruiKanris(),info2.getHituyouSyoruiKanris());
        System.out.println("test14 end-----------------------------------------------------");
    }

    @Test
    @Transactional
    public void test14_end(){
        System.out.println("test14_end start---------------------------------------------------");
        BT_GyoumuKouteiInfo info1 = bizDomManager.getGyoumuKouteiInfo("KR001");
        List<BT_HituyouSyoruiKanri> list = info1.getHituyouSyoruiKanris();
        Assert.assertEquals(list.size(), 3);
        System.out.println("test14_end end-----------------------------------------------------");
    }

}
