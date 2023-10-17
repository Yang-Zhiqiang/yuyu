package yuyu.def.db.entity;


//@RunWith(SWAKTestRunner.class)
//public class HT_SkLincSousinInfoEntityTest implements EntityTestInterface {
//
//    //    @Inject
//    //    private SinkeiyakuDomManager sinkeiyakuDomManager;
//    //
//    //    @BeforeClass
//    //    @Transactional
//    //    public static void insertTestData() {
//    //
//    //        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
//    //
//    //        Assert.assertEquals(0,sinkeiyakuDomManager.getAllSkLincSousinInfo().size());
//    //
//    //        C_LincsoujyusinsysKbn  pLincsoujyusinsyskbn0 = C_LincsoujyusinsysKbn.SKEI;
//    //        C_LincsoujyusinsysKbn  pLincsoujyusinsyskbn1 = C_LincsoujyusinsysKbn.HOZEN;
//    //        String pMosno1 = "MOSNO1";
//    //        String pMosno2 = "MOSNO2";
//    //        String pMosno3 = "MOSNO3";
//    //        Integer pRenno11 = 11;
//    //        Integer pRenno22 = 22;
//    //        Integer pRenno33 = 33;
//    //
//    //
//    //        HT_SkLincSousinInfo hT_SkLincSousinInfo1 = new HT_SkLincSousinInfo(pLincsoujyusinsyskbn1,pMosno1,pRenno33);
//    //        sinkeiyakuDomManager.insert(hT_SkLincSousinInfo1);
//    //
//    //        HT_SkLincSousinInfo hT_SkLincSousinInfo2 = new HT_SkLincSousinInfo(pLincsoujyusinsyskbn0,pMosno3,pRenno22);
//    //        sinkeiyakuDomManager.insert(hT_SkLincSousinInfo2);
//    //
//    //        HT_SkLincSousinInfo hT_SkLincSousinInfo3 = new HT_SkLincSousinInfo(pLincsoujyusinsyskbn1,pMosno2,pRenno22);
//    //        sinkeiyakuDomManager.insert(hT_SkLincSousinInfo3);
//    //
//    //        HT_SkLincSousinInfo hT_SkLincSousinInfo4 = new HT_SkLincSousinInfo(pLincsoujyusinsyskbn1,pMosno2,pRenno11);
//    //        sinkeiyakuDomManager.insert(hT_SkLincSousinInfo4);
//    //
//    //        HT_SkLincSousinInfo hT_SkLincSousinInfo5 = new HT_SkLincSousinInfo(pLincsoujyusinsyskbn1,pMosno1,pRenno11);
//    //        sinkeiyakuDomManager.insert(hT_SkLincSousinInfo5);
//    //
//    //    }
//    //
//    //    @AfterClass
//    //    @Transactional
//    //    public static void deleteTestData() {
//    //
//    //        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
//    //
//    //        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSkLincSousinInfo());
//    //
//    //    }
//    //
//    //    @Override
//    //    @Test
//    //    @TestOrder(10)
//    //    public void getAll() {
//    //
//    //        C_LincsoujyusinsysKbn  pLincsoujyusinsyskbn0 = C_LincsoujyusinsysKbn.SKEI;
//    //        C_LincsoujyusinsysKbn  pLincsoujyusinsyskbn1 = C_LincsoujyusinsysKbn.HOZEN;
//    //        String pMosno1 = "MOSNO1";
//    //        String pMosno2 = "MOSNO2";
//    //        String pMosno3 = "MOSNO3";
//    //        Integer pRenno11 = 11;
//    //        Integer pRenno22 = 22;
//    //        Integer pRenno33 = 33;
//    //
//    //        List<HT_SkLincSousinInfo> hT_SkLincSousinInfos = sinkeiyakuDomManager.getAllSkLincSousinInfo();
//    //
//    //        Assert.assertEquals(pLincsoujyusinsyskbn0, hT_SkLincSousinInfos.get(0).getLincsoujyusinsyskbn());
//    //        Assert.assertEquals(pMosno3, hT_SkLincSousinInfos.get(0).getMosno());
//    //        Assert.assertEquals(pRenno22, hT_SkLincSousinInfos.get(0).getRenno());
//    //
//    //        Assert.assertEquals(pLincsoujyusinsyskbn1, hT_SkLincSousinInfos.get(1).getLincsoujyusinsyskbn());
//    //        Assert.assertEquals(pMosno1, hT_SkLincSousinInfos.get(1).getMosno());
//    //        Assert.assertEquals(pRenno11, hT_SkLincSousinInfos.get(1).getRenno());
//    //
//    //        Assert.assertEquals(pLincsoujyusinsyskbn1, hT_SkLincSousinInfos.get(2).getLincsoujyusinsyskbn());
//    //        Assert.assertEquals(pMosno1, hT_SkLincSousinInfos.get(2).getMosno());
//    //        Assert.assertEquals(pRenno33, hT_SkLincSousinInfos.get(2).getRenno());
//    //
//    //        Assert.assertEquals(pLincsoujyusinsyskbn1, hT_SkLincSousinInfos.get(3).getLincsoujyusinsyskbn());
//    //        Assert.assertEquals(pMosno2, hT_SkLincSousinInfos.get(3).getMosno());
//    //        Assert.assertEquals(pRenno11, hT_SkLincSousinInfos.get(3).getRenno());
//    //
//    //        Assert.assertEquals(pLincsoujyusinsyskbn1, hT_SkLincSousinInfos.get(4).getLincsoujyusinsyskbn());
//    //        Assert.assertEquals(pMosno2, hT_SkLincSousinInfos.get(4).getMosno());
//    //        Assert.assertEquals(pRenno22, hT_SkLincSousinInfos.get(4).getRenno());
//    //
//    //        Assert.assertEquals(5, hT_SkLincSousinInfos.size());
//    //    }
//    //
//    //    @Override
//    //    @Test
//    //    @TestOrder(20)
//    //    public void getUniqueEntity() {
//    //
//    //        C_LincsoujyusinsysKbn  pLincsoujyusinsyskbn0 = C_LincsoujyusinsysKbn.SKEI;
//    //        String pMosno3 = "MOSNO3";
//    //        Integer pRenno22 = 22;
//    //
//    //        HT_SkLincSousinInfo hT_SkLincSousinInfo = sinkeiyakuDomManager.getSkLincSousinInfo(pLincsoujyusinsyskbn0, pMosno3, pRenno22) ;
//    //
//    //        Assert.assertEquals(pLincsoujyusinsyskbn0, hT_SkLincSousinInfo.getLincsoujyusinsyskbn());
//    //        Assert.assertEquals(pMosno3, hT_SkLincSousinInfo.getMosno());
//    //        Assert.assertEquals(pRenno22, hT_SkLincSousinInfo.getRenno());
//    //    }
//    //
//    //    @Override
//    //    @Test
//    //    @TestOrder(30)
//    //    public void noUniqueEntity() {
//    //
//    //        C_LincsoujyusinsysKbn  pLincsoujyusinsyskbn1 =  C_LincsoujyusinsysKbn.HOZEN;
//    //        String pMosno1 = "MOSNO1";
//    //        Integer pRenno555 = 555;
//    //
//    //        Assert.assertNull(sinkeiyakuDomManager.getSkLincSousinInfo(pLincsoujyusinsyskbn1, pMosno1, pRenno555));
//    //    }
//    //
//    //    @Override
//    //    @Test
//    //    @TestOrder(40)
//    //    public void blankCondition() {
//    //
//    //        C_LincsoujyusinsysKbn  pLincsoujyusinsyskbn22 =  C_LincsoujyusinsysKbn.SKEI;
//    //        String pMosnoBlank = "";
//    //        Integer pRenno22 = 22;
//    //
//    //        HT_SkLincSousinInfo hT_SkLincSousinInfo = sinkeiyakuDomManager.getSkLincSousinInfo(pLincsoujyusinsyskbn22, pMosnoBlank, pRenno22) ;
//    //        Assert.assertNull(hT_SkLincSousinInfo);
//    //
//    //    }
//    //
//    //    @Override
//    //    @Test
//    //    @TestOrder(50)
//    //    public void nullCondition() {
//    //
//    //        Assert.assertTrue(true);
//    //    }
//}
