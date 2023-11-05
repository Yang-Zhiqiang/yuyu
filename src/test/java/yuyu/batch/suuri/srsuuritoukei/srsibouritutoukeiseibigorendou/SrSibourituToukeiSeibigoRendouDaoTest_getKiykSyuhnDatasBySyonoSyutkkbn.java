package yuyu.batch.suuri.srsuuritoukei.srsibouritutoukeiseibigorendou;

import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;

/**
 * SrSibourituToukeiSeibigoRendouDaoクラスの、<br />
 * getKiykSyuhnDatasBySyonoSyutkkbn() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SrSibourituToukeiSeibigoRendouDaoTest_getKiykSyuhnDatasBySyonoSyutkkbn {

    //    @Inject
    //    private SrSibourituToukeiSeibigoRendouDao srSibourituToukeiSeibigoRendouDao;
    //
    //    @BeforeClass
    //    @Transactional
    //    public static void TestDataInsert() {
    //
    //        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
    //        SrSibourituToukeiSeibigoRendouDao srSibourituToukeiSeibigoRendouDao = SWAKInjector.getInstance(SrSibourituToukeiSeibigoRendouDao.class);
    //
    //        List<SV_KiykSyuhnData> kiykSyuhnDataLst = srSibourituToukeiSeibigoRendouDao.getKiykSyuhnDatasBySyonoSyutkkbn("11807111118", C_SyutkKbn.TK);
    //
    //        Assert.assertEquals(0, kiykSyuhnDataLst.size());
    //
    //        IT_KykKihon kykKihon1 = new IT_KykKihon("01", "11807111118");
    //
    //        IT_KhTtdkRireki khTtdkRireki1 = kykKihon1.createKhTtdkRireki();
    //        khTtdkRireki1.setHenkousikibetukey("H1");
    //
    //        IT_KykSyouhnRireki kykSyouhnRireki1 = khTtdkRireki1.createKykSyouhnRireki();
    //        kykSyouhnRireki1.setSyutkkbn(C_SyutkKbn.NONE);
    //        kykSyouhnRireki1.setSyouhncd("S001");
    //        kykSyouhnRireki1.setSyouhnsdno(1);
    //        kykSyouhnRireki1.setKyksyouhnrenno(1);
    //
    //        IT_KykSyouhnRireki kykSyouhnRireki2 = khTtdkRireki1.createKykSyouhnRireki();
    //        kykSyouhnRireki2.setSyutkkbn(C_SyutkKbn.SYU);
    //        kykSyouhnRireki2.setSyouhncd("S001");
    //        kykSyouhnRireki2.setSyouhnsdno(1);
    //        kykSyouhnRireki2.setKyksyouhnrenno(1);
    //        hozenDomManager.insert(kykKihon1);
    //
    //        IT_KykKihon kykKihon2 = new IT_KykKihon("03", "11807111130");
    //
    //        IT_KhTtdkRireki khTtdkRireki2 = kykKihon2.createKhTtdkRireki();
    //        khTtdkRireki2.setHenkousikibetukey("H1");
    //
    //        IT_KykSyouhnRireki kykSyouhnRireki3 = khTtdkRireki2.createKykSyouhnRireki();
    //        kykSyouhnRireki3.setSyutkkbn(C_SyutkKbn.NONE);
    //        kykSyouhnRireki3.setSyouhncd("S001");
    //        kykSyouhnRireki3.setSyouhnsdno(1);
    //        kykSyouhnRireki3.setKyksyouhnrenno(1);
    //
    //        IT_KhTtdkRireki khTtdkRireki3 = kykKihon2.createKhTtdkRireki();
    //        khTtdkRireki3.setHenkousikibetukey("H2");
    //
    //        IT_KykSyouhnRireki kykSyouhnRireki4 = khTtdkRireki3.createKykSyouhnRireki();
    //        kykSyouhnRireki4.setSyutkkbn(C_SyutkKbn.NONE);
    //        kykSyouhnRireki4.setSyouhncd("S001");
    //        kykSyouhnRireki4.setSyouhnsdno(1);
    //        kykSyouhnRireki4.setKyksyouhnrenno(1);
    //
    //        IT_KhTtdkRireki khTtdkRireki4 = kykKihon2.createKhTtdkRireki();
    //        khTtdkRireki4.setHenkousikibetukey("H3");
    //
    //        IT_KykSyouhnRireki kykSyouhnRireki5 = khTtdkRireki4.createKykSyouhnRireki();
    //        kykSyouhnRireki5.setSyutkkbn(C_SyutkKbn.NONE);
    //        kykSyouhnRireki5.setSyouhncd("S001");
    //        kykSyouhnRireki5.setSyouhnsdno(1);
    //        kykSyouhnRireki5.setKyksyouhnrenno(1);
    //
    //        hozenDomManager.insert(kykKihon2);
    //
    //        IT_KykKihon kykKihon3 = new IT_KykKihon("02", "11807111129");
    //
    //        IT_KhTtdkRireki khTtdkRireki5 = kykKihon3.createKhTtdkRireki();
    //        khTtdkRireki5.setHenkousikibetukey("H1");
    //
    //        IT_KykSyouhnRireki kykSyouhnRireki6 = khTtdkRireki5.createKykSyouhnRireki();
    //        kykSyouhnRireki6.setSyutkkbn(C_SyutkKbn.NONE);
    //        kykSyouhnRireki6.setSyouhncd("S001");
    //        kykSyouhnRireki6.setSyouhnsdno(1);
    //        kykSyouhnRireki6.setKyksyouhnrenno(1);
    //
    //        hozenDomManager.insert(kykKihon3);
    //    }
    //
    //    @AfterClass
    //    @Transactional
    //    public static void deleteTestData() {
    //        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
    //        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    //
    //    }
    //
    //    @Test
    //    @TestOrder(10)
    //    public void noResult1() {
    //
    //        List<SV_KiykSyuhnData> kiykSyuhnDataLst = srSibourituToukeiSeibigoRendouDao.getKiykSyuhnDatasBySyonoSyutkkbn("11807111118", C_SyutkKbn.TK);
    //
    //        Assert.assertEquals(0, kiykSyuhnDataLst.size());
    //    }
    //
    //    @Test
    //    @TestOrder(20)
    //    public void normal1() {
    //        List<SV_KiykSyuhnData> kiykSyuhnDataLst = srSibourituToukeiSeibigoRendouDao.getKiykSyuhnDatasBySyonoSyutkkbn("11807111118", C_SyutkKbn.NONE);
    //
    //        Assert.assertEquals(1, kiykSyuhnDataLst.size());
    //
    //        Assert.assertEquals("11807111118", kiykSyuhnDataLst.get(0).getSyono());
    //        Assert.assertEquals(C_SyutkKbn.NONE, kiykSyuhnDataLst.get(0).getSyutkkbn());
    //        Assert.assertEquals("H1", kiykSyuhnDataLst.get(0).getHenkousikibetukey());
    //        Assert.assertEquals("S001", kiykSyuhnDataLst.get(0).getSyouhncd());
    //        Assert.assertEquals(1, kiykSyuhnDataLst.get(0).getSyouhnsdno().intValue());
    //        Assert.assertEquals(1, kiykSyuhnDataLst.get(0).getKyksyouhnrenno().intValue());
    //    }
    //
    //    @Test
    //    @TestOrder(30)
    //    public void normal2() {
    //        List<SV_KiykSyuhnData> kiykSyuhnDataLst = srSibourituToukeiSeibigoRendouDao.getKiykSyuhnDatasBySyonoSyutkkbn("11807111130", C_SyutkKbn.NONE);
    //
    //        Assert.assertEquals(3, kiykSyuhnDataLst.size());
    //        Map<String,String> map = new HashMap<String,String>();
    //        map.put($("11807111130",C_SyutkKbn.NONE,"H1","S001",1,1), "1");
    //        map.put($("11807111130",C_SyutkKbn.NONE,"H2","S001",1,1), "1");
    //        map.put($("11807111130",C_SyutkKbn.NONE,"H3","S001",1,1), "1");
    //
    //        for(SV_KiykSyuhnData kiykSyuhnData : kiykSyuhnDataLst){
    //            map.remove($(kiykSyuhnData.getSyono(),kiykSyuhnData.getSyutkkbn(),kiykSyuhnData.getHenkousikibetukey(),kiykSyuhnData.getSyouhncd()
    //                ,kiykSyuhnData.getSyouhnsdno().intValue(),kiykSyuhnData.getKyksyouhnrenno().intValue()));
    //        }
    //        assertTrue(map.isEmpty());
    //    }
    //
    //    @Test
    //    @TestOrder(40)
    //    public void blankCondition1() {
    //
    //        List<SV_KiykSyuhnData> kiykSyuhnDataLst = srSibourituToukeiSeibigoRendouDao.getKiykSyuhnDatasBySyonoSyutkkbn("", C_SyutkKbn.NONE);
    //
    //        assertEquals(0, kiykSyuhnDataLst.size());
    //
    //    }
}

