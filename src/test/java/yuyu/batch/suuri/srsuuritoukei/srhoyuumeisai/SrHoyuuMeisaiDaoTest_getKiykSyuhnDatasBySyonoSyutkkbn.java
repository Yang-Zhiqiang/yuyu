package yuyu.batch.suuri.srsuuritoukei.srhoyuumeisai;

import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;

/**
 * 数理<br />
 * 保有明細情報作成<br />
 * 契約商品情報ビューエンティティリスト取得（証券番号、主契約特約区分）<br />
 */
@RunWith(OrderedRunner.class)
public class SrHoyuuMeisaiDaoTest_getKiykSyuhnDatasBySyonoSyutkkbn {

    //    @Inject
    //    private SrHoyuuMeisaiDao srHoyuuMeisaiDao;
    //
    //    static String P_SYONO_01 = "11807111118";
    //    static String P_SYONO_02 = "11807111129";
    //    static String P_SYONO_03 = "11807111130";
    //    static String P_SYOUHNCD_01 = "SH01";
    //    static Integer P_SYOUHNSDNO_01 = new Integer(11);
    //    static Integer P_KYKSYOUHNRENNO_01 = new Integer(1);
    //    static Integer P_KYKSYOUHNRENNO_02 = new Integer(2);
    //    static String P_HENKOUSIKIBETUKEY_01 = "HK000000001";
    //    static String P_HENKOUSIKIBETUKEY_02 = "HK000000002";
    //    static String P_HENKOUSIKIBETUKEY_03 = "HK000000003";
    //    static String P_HENKOUSIKIBETUKEY_04 = "HK000000004";
    //
    //    @BeforeClass
    //    @Transactional
    //    public static void TestDataInsert() {
    //
    //        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
    //
    //        SrHoyuuMeisaiDao srHoyuuMeisaiDao = SWAKInjector.getInstance(SrHoyuuMeisaiDao.class);
    //
    //        List<SV_KiykSyuhnData> sV_KiykSyuhnDataLst = srHoyuuMeisaiDao.getKiykSyuhnDatasBySyonoSyutkkbn(P_SYONO_02, C_SyutkKbn.NONE);
    //        Assert.assertEquals(0, sV_KiykSyuhnDataLst.size());
    //
    //        IT_KykKihon iT_KykKihon1 = new IT_KykKihon(P_SYONO_01);
    //
    //        IT_KykSyouhn iT_KykSyouhn11 = iT_KykKihon1.createKykSyouhn();
    //        iT_KykSyouhn11.setSyutkkbn(C_SyutkKbn.NONE);
    //        iT_KykSyouhn11.setSyouhncd(P_SYOUHNCD_01);
    //        iT_KykSyouhn11.setSyouhnsdno(P_SYOUHNSDNO_01);
    //        iT_KykSyouhn11.setKyksyouhnrenno(P_KYKSYOUHNRENNO_01);
    //        iT_KykSyouhn11.setHenkousikibetukey(P_HENKOUSIKIBETUKEY_01);
    //
    //        IT_KykSyouhn iT_KykSyouhn12 = iT_KykKihon1.createKykSyouhn();
    //        iT_KykSyouhn12.setSyutkkbn(C_SyutkKbn.NONE);
    //        iT_KykSyouhn12.setSyouhncd(P_SYOUHNCD_01);
    //        iT_KykSyouhn12.setSyouhnsdno(P_SYOUHNSDNO_01);
    //        iT_KykSyouhn12.setKyksyouhnrenno(P_KYKSYOUHNRENNO_02);
    //        iT_KykSyouhn12.setHenkousikibetukey(P_HENKOUSIKIBETUKEY_02);
    //
    //        IT_KykSyouhn iT_KykSyouhn13 = iT_KykKihon1.createKykSyouhn();
    //        iT_KykSyouhn13.setSyutkkbn(C_SyutkKbn.SYU);
    //        iT_KykSyouhn13.setSyouhncd(P_SYOUHNCD_01);
    //        iT_KykSyouhn13.setSyouhnsdno(P_SYOUHNSDNO_01);
    //        iT_KykSyouhn13.setKyksyouhnrenno(P_KYKSYOUHNRENNO_01);
    //        iT_KykSyouhn13.setHenkousikibetukey(P_HENKOUSIKIBETUKEY_03);
    //
    //        IT_KhTtdkRireki iT_KhTtdkRireki11 = iT_KykKihon1.createKhTtdkRireki();
    //        iT_KhTtdkRireki11.setHenkousikibetukey(P_HENKOUSIKIBETUKEY_01);
    //
    //        IT_KhTtdkRireki iT_KhTtdkRireki12 = iT_KykKihon1.createKhTtdkRireki();
    //        iT_KhTtdkRireki12.setHenkousikibetukey(P_HENKOUSIKIBETUKEY_02);
    //
    //        IT_KhTtdkRireki iT_KhTtdkRireki13 = iT_KykKihon1.createKhTtdkRireki();
    //        iT_KhTtdkRireki13.setHenkousikibetukey(P_HENKOUSIKIBETUKEY_03);
    //
    //        IT_KhTtdkRireki iT_KhTtdkRireki14 = iT_KykKihon1.createKhTtdkRireki();
    //        iT_KhTtdkRireki14.setHenkousikibetukey(P_HENKOUSIKIBETUKEY_04);
    //
    //        IT_KykSyouhnRireki iT_KykSyouhnRireki141 = iT_KhTtdkRireki14.createKykSyouhnRireki();
    //        iT_KykSyouhnRireki141.setSyutkkbn(C_SyutkKbn.NONE);
    //        iT_KykSyouhnRireki141.setSyouhncd(P_SYOUHNCD_01);
    //        iT_KykSyouhnRireki141.setSyouhnsdno(P_SYOUHNSDNO_01);
    //        iT_KykSyouhnRireki141.setKyksyouhnrenno(P_KYKSYOUHNRENNO_01);
    //        iT_KykSyouhnRireki141.setHenkousikibetukey(P_HENKOUSIKIBETUKEY_04);
    //
    //        hozenDomManager.insert(iT_KykKihon1);
    //
    //        IT_KykKihon iT_KykKihon2 = new IT_KykKihon(P_SYONO_02);
    //
    //        IT_KykSyouhn iT_KykSyouhn21 = iT_KykKihon2.createKykSyouhn();
    //        iT_KykSyouhn21.setSyutkkbn(C_SyutkKbn.NONE);
    //        iT_KykSyouhn21.setSyouhncd(P_SYOUHNCD_01);
    //        iT_KykSyouhn21.setSyouhnsdno(P_SYOUHNSDNO_01);
    //        iT_KykSyouhn21.setKyksyouhnrenno(P_KYKSYOUHNRENNO_01);
    //        iT_KykSyouhn21.setHenkousikibetukey(P_HENKOUSIKIBETUKEY_01);
    //
    //        IT_KhTtdkRireki iT_KhTtdkRireki21 = iT_KykKihon2.createKhTtdkRireki();
    //        iT_KhTtdkRireki21.setHenkousikibetukey(P_HENKOUSIKIBETUKEY_01);
    //
    //        hozenDomManager.insert(iT_KykKihon2);
    //
    //        IT_KykKihon iT_KykKihon3 = new IT_KykKihon(P_SYONO_03);
    //
    //        IT_KhTtdkRireki iT_KhTtdkRireki31 = iT_KykKihon3.createKhTtdkRireki();
    //        iT_KhTtdkRireki31.setHenkousikibetukey(P_HENKOUSIKIBETUKEY_01);
    //
    //        hozenDomManager.insert(iT_KykKihon3);
    //    }
    //
    //    @AfterClass
    //    @Transactional
    //    public static void deleteTestData() {
    //
    //        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
    //
    //        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    //    }
    //
    //    @Test
    //    @TestOrder(10)
    //    public void noResult1(){
    //
    //        List<SV_KiykSyuhnData> sV_KiykSyuhnDataLst = srHoyuuMeisaiDao.getKiykSyuhnDatasBySyonoSyutkkbn(P_SYONO_03, C_SyutkKbn.SYU);
    //
    //        Assert.assertEquals(0, sV_KiykSyuhnDataLst.size());
    //    }
    //
    //    @Test
    //    @TestOrder(20)
    //    public void normal1(){
    //
    //        List<SV_KiykSyuhnData> sV_KiykSyuhnDataLst = srHoyuuMeisaiDao.getKiykSyuhnDatasBySyonoSyutkkbn(P_SYONO_02, C_SyutkKbn.NONE);
    //
    //        Assert.assertEquals(1, sV_KiykSyuhnDataLst.size());
    //
    //        Assert.assertEquals(P_SYONO_02, sV_KiykSyuhnDataLst.get(0).getSyono());
    //        Assert.assertEquals(C_SyutkKbn.NONE, sV_KiykSyuhnDataLst.get(0).getSyutkkbn());
    //        Assert.assertEquals(P_SYOUHNCD_01, sV_KiykSyuhnDataLst.get(0).getSyouhncd());
    //        Assert.assertEquals(P_SYOUHNSDNO_01, sV_KiykSyuhnDataLst.get(0).getSyouhnsdno());
    //        Assert.assertEquals(P_KYKSYOUHNRENNO_01, sV_KiykSyuhnDataLst.get(0).getKyksyouhnrenno());
    //        Assert.assertEquals(P_HENKOUSIKIBETUKEY_01, sV_KiykSyuhnDataLst.get(0).getHenkousikibetukey());
    //    }
    //
    //    @Test
    //    @TestOrder(30)
    //    public void normal2(){
    //
    //        List<SV_KiykSyuhnData> sV_KiykSyuhnDataLst = srHoyuuMeisaiDao.getKiykSyuhnDatasBySyonoSyutkkbn(P_SYONO_01, C_SyutkKbn.NONE);
    //
    //        Assert.assertEquals(3, sV_KiykSyuhnDataLst.size());
    //
    //        Map<String,String> map = new HashMap<String,String>();
    //        map.put($(P_SYONO_01,C_SyutkKbn.NONE,P_SYOUHNCD_01,P_SYOUHNSDNO_01,P_KYKSYOUHNRENNO_01,P_HENKOUSIKIBETUKEY_01), "1");
    //        map.put($(P_SYONO_01,C_SyutkKbn.NONE,P_SYOUHNCD_01,P_SYOUHNSDNO_01,P_KYKSYOUHNRENNO_02,P_HENKOUSIKIBETUKEY_02), "1");
    //        map.put($(P_SYONO_01,C_SyutkKbn.NONE,P_SYOUHNCD_01,P_SYOUHNSDNO_01,P_KYKSYOUHNRENNO_01,P_HENKOUSIKIBETUKEY_04), "1");
    //
    //        for(SV_KiykSyuhnData kiykSyuhnData : sV_KiykSyuhnDataLst){
    //            map.remove($(kiykSyuhnData.getSyono(),kiykSyuhnData.getSyutkkbn(),kiykSyuhnData.getSyouhncd(),kiykSyuhnData.getSyouhnsdno(),kiykSyuhnData.getKyksyouhnrenno(),kiykSyuhnData.getHenkousikibetukey()));
    //
    //        }
    //    }
}
