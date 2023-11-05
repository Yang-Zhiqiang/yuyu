package yuyu.def.sinkeiyaku.manager;

import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getSkLincJyusinInfosByMosno() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSkLincJyusinInfosByMosno {

    //    @Inject
    //    SinkeiyakuDomManager sinkeiyakuDomManager;
    //
    //    @BeforeClass
    //    @Transactional
    //    public static void insertTestData() {
    //
    //        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
    //
    //        List<HT_SkLincJyusinInfo> skLincJyusinInfo = sinkeiyakuDomManager.getSkLincJyusinInfosByMosno("791112220");
    //        Assert.assertEquals(0,skLincJyusinInfo.size());
    //
    //        HT_SkLincJyusinInfo skLincJyusinInfo1 = new HT_SkLincJyusinInfo(C_LincsoujyusinsysKbn.valueOf("1"), "1001", BizDate.valueOf(20160429), "791112220", BizNumber.valueOf(1), BizDate.valueOf(20160429));
    //
    //        sinkeiyakuDomManager.insert(skLincJyusinInfo1);
    //
    //        HT_SkLincJyusinInfo skLincJyusinInfo2 = new HT_SkLincJyusinInfo(C_LincsoujyusinsysKbn.valueOf("1"), "1001", BizDate.valueOf(20160429), "791112246", BizNumber.valueOf(1), BizDate.valueOf(20160429));
    //
    //        sinkeiyakuDomManager.insert(skLincJyusinInfo2);
    //
    //        HT_SkLincJyusinInfo skLincJyusinInfo3 = new HT_SkLincJyusinInfo(C_LincsoujyusinsysKbn.valueOf("1"), "1001", BizDate.valueOf(20160429), "791112246", BizNumber.valueOf(2), BizDate.valueOf(20160429));
    //
    //        sinkeiyakuDomManager.insert(skLincJyusinInfo3);
    //
    //        HT_SkLincJyusinInfo skLincJyusinInfo4 = new HT_SkLincJyusinInfo(C_LincsoujyusinsysKbn.valueOf("1"), "1001", BizDate.valueOf(20160429), "791112246", BizNumber.valueOf(3), BizDate.valueOf(20160429));
    //
    //        sinkeiyakuDomManager.insert(skLincJyusinInfo4);
    //
    //        HT_SkLincJyusinInfo skLincJyusinInfo5 = new HT_SkLincJyusinInfo(C_LincsoujyusinsysKbn.valueOf("1"), "1001", BizDate.valueOf(20160429), "791112238", BizNumber.valueOf(1), BizDate.valueOf(20160429));
    //
    //        sinkeiyakuDomManager.insert(skLincJyusinInfo5);
    //
    //
    //    }
    //
    //    @AfterClass
    //    @Transactional
    //    public static void deleteTestData() {
    //        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
    //        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSkLincJyusinInfo());
    //    }
    //
    //    @Test
    //    @TestOrder(10)
    //    public void noResult1() {
    //
    //        List<HT_SkLincJyusinInfo> skLincJyusinInfo = sinkeiyakuDomManager.getSkLincJyusinInfosByMosno("791112219");
    //        Assert.assertEquals(0,skLincJyusinInfo.size());
    //
    //    }
    //
    //    @Test
    //    @TestOrder(20)
    //    public void normal1() {
    //
    //        List<HT_SkLincJyusinInfo> skLincJyusinInfo = sinkeiyakuDomManager.getSkLincJyusinInfosByMosno("791112220");
    //        Assert.assertEquals(1,skLincJyusinInfo.size());
    //
    //        Assert.assertEquals(C_LincsoujyusinsysKbn.valueOf("1"), skLincJyusinInfo.get(0).getLincsoujyusinsyskbn());
    //        Assert.assertEquals("1001", skLincJyusinInfo.get(0).getLinckyknaiykekdatarenno());
    //        Assert.assertEquals(BizDate.valueOf(20160429), skLincJyusinInfo.get(0).getSyoriYmd());
    //        Assert.assertEquals("791112220", skLincJyusinInfo.get(0).getMosno());
    //        Assert.assertEquals(BizNumber.valueOf(1), skLincJyusinInfo.get(0).getRenno2());
    //        Assert.assertEquals(BizDate.valueOf(20160429), skLincJyusinInfo.get(0).getSousinymd());
    //    }
    //
    //    @Test
    //    @TestOrder(30)
    //    public void normal2() {
    //
    //        HashMap<String,String> datamap = new HashMap<String,String>();
    //        datamap.put($(C_LincsoujyusinsysKbn.valueOf("1"),"1001",BizDate.valueOf(20160429),"791112246",BizNumber.valueOf(1),BizDate.valueOf(20160429)), "1");
    //        datamap.put($(C_LincsoujyusinsysKbn.valueOf("1"),"1001",BizDate.valueOf(20160429),"791112246",BizNumber.valueOf(2),BizDate.valueOf(20160429)), "1");
    //        datamap.put($(C_LincsoujyusinsysKbn.valueOf("1"),"1001",BizDate.valueOf(20160429),"791112246",BizNumber.valueOf(3),BizDate.valueOf(20160429)), "1");
    //
    //        List<HT_SkLincJyusinInfo> skLincJyusinInfoLst = sinkeiyakuDomManager.getSkLincJyusinInfosByMosno("791112246");
    //
    //        for(HT_SkLincJyusinInfo skLincJyusinInfo:skLincJyusinInfoLst){
    //            datamap.remove($(
    //                skLincJyusinInfo.getLincsoujyusinsyskbn(),
    //                skLincJyusinInfo.getLinckyknaiykekdatarenno(),
    //                skLincJyusinInfo.getSyoriYmd(),
    //                skLincJyusinInfo.getMosno(),
    //                skLincJyusinInfo.getRenno2(),
    //                skLincJyusinInfo.getSousinymd()));
    //        }
    //
    //        Assert.assertEquals(3,skLincJyusinInfoLst.size());
    //
    //        Assert.assertTrue(datamap.isEmpty());
    //    }
    //
	//    @Test
    //    @TestOrder(40)
    //    public void blank() {
    //
    //        List<HT_SkLincJyusinInfo> skLincJyusinInfo = sinkeiyakuDomManager.getSkLincJyusinInfosByMosno("");
    //        Assert.assertEquals(0,skLincJyusinInfo.size());
    //    }
}
