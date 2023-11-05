package yuyu.def.sinkeiyaku.manager;

import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getSkLincSousinInfosByMosno() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSkLincSousinInfosByMosno {

    //    @Inject
    //    SinkeiyakuDomManager sinkeiyakuDomManager;
    //
    //    @BeforeClass
    //    @Transactional
    //    public static void insertTestData() {
    //
    //        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
    //        List<HT_SkLincSousinInfo> skLincSousinInfo = sinkeiyakuDomManager.getSkLincSousinInfosByMosno("791112220");
    //
    //        Assert.assertEquals(0,skLincSousinInfo.size());
    //
    //        HT_SkLincSousinInfo skLincSousinInfo1 = new HT_SkLincSousinInfo(C_LincsoujyusinsysKbn.HOZEN, "791112220", 01);
    //
    //        sinkeiyakuDomManager.insert(skLincSousinInfo1);
    //
    //        HT_SkLincSousinInfo skLincSousinInfo2 = new HT_SkLincSousinInfo(C_LincsoujyusinsysKbn.HOZEN, "791112220", 02);
    //
    //        sinkeiyakuDomManager.insert(skLincSousinInfo2);
    //
    //        HT_SkLincSousinInfo skLincSousinInfo3 = new HT_SkLincSousinInfo(C_LincsoujyusinsysKbn.HOZEN, "791112220", 03);
    //
    //        sinkeiyakuDomManager.insert(skLincSousinInfo3);
    //
    //        HT_SkLincSousinInfo skLincSousinInfo4 = new HT_SkLincSousinInfo(C_LincsoujyusinsysKbn.HOZEN, "791112238", 04);
    //
    //        sinkeiyakuDomManager.insert(skLincSousinInfo4);
    //
    //        HT_SkLincSousinInfo skLincSousinInfo5 = new HT_SkLincSousinInfo(C_LincsoujyusinsysKbn.HOZEN, "791112253", 05);
    //
    //        sinkeiyakuDomManager.insert(skLincSousinInfo5);
    //
    //    }
    //
    //    @AfterClass
    //    @Transactional
    //    public static void deleteTestData() {
    //        SinkeiyakuDomManager SinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
    //        SinkeiyakuDomManager.delete(SinkeiyakuDomManager.getAllSkLincSousinInfo());
    //    }
    //
    //
    //    @Test
    //    @TestOrder(10)
    //    public void noResult1() {
    //
    //        List<HT_SkLincSousinInfo> skLincSousinInfo = sinkeiyakuDomManager.getSkLincSousinInfosByMosno("791112246");
    //
    //        Assert.assertEquals(0,skLincSousinInfo.size());
    //    }
    //
    //    @Test
    //    @TestOrder(20)
    //    public void normal1() {
    //
    //        List<HT_SkLincSousinInfo> skLincSousinInfo = sinkeiyakuDomManager.getSkLincSousinInfosByMosno("791112238");
    //
    //        Assert.assertEquals(1,skLincSousinInfo.size());
    //
    //        Assert.assertEquals(C_LincsoujyusinsysKbn.valueOf("1"), skLincSousinInfo.get(0).getLincsoujyusinsyskbn());
    //        Assert.assertEquals("791112238", skLincSousinInfo.get(0).getMosno());
    //        Assert.assertEquals(04, skLincSousinInfo.get(0).getRenno().intValue());
    //    }
    //
    //    @Test
    //    @TestOrder(30)
    //    public void normal2() {
    //
    //        HashMap<String,String> datamap = new HashMap<String,String>();
    //        datamap.put($(C_LincsoujyusinsysKbn.valueOf("1"),"791112220",01), "1");
    //        datamap.put($(C_LincsoujyusinsysKbn.valueOf("1"),"791112220",02), "1");
    //        datamap.put($(C_LincsoujyusinsysKbn.valueOf("1"),"791112220",03), "1");
    //
    //        List<HT_SkLincSousinInfo> skLincSousinInfoLst = sinkeiyakuDomManager.getSkLincSousinInfosByMosno("791112220");
    //
    //        for(HT_SkLincSousinInfo skLincSousinInfo:skLincSousinInfoLst){
    //            datamap.remove($(
    //                skLincSousinInfo.getLincsoujyusinsyskbn(),
    //                skLincSousinInfo.getMosno(),
    //                skLincSousinInfo.getRenno().intValue()));
    //        }
    //
    //        Assert.assertEquals(3,skLincSousinInfoLst.size());
    //        Assert.assertTrue(datamap.isEmpty());
    //
    //    }
    //
	//    @Test
    //    @TestOrder(40)
    //    public void blank1() {
    //
    //        List<HT_SkLincSousinInfo> skLincSousinInfo = sinkeiyakuDomManager.getSkLincSousinInfosByMosno("");
    //
    //        Assert.assertEquals(0,skLincSousinInfo.size());
    //
    //    }
}
