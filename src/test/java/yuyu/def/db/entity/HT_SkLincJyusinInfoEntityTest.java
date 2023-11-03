package yuyu.def.db.entity;

//@RunWith(SWAKTestRunner.class)
//public class HT_SkLincJyusinInfoEntityTest implements EntityTestInterface {

//    @Inject
//    private SinkeiyakuDomManager sinkeiyakuDomManager;
//
//    @BeforeClass
//    @Transactional
//    public static void insertTestData() {
//
//        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
//
//        Assert.assertEquals(0, sinkeiyakuDomManager.getAllSkLincJyusinInfo().size());
//
//        C_LincsoujyusinsysKbn Lincsoujyusinsyskbn1 = C_LincsoujyusinsysKbn.SKEI;
//        C_LincsoujyusinsysKbn Lincsoujyusinsyskbn2 = C_LincsoujyusinsysKbn.HOZEN;
//        String pLinckyknaiykekdatarenno1 = "1";
//        String pLinckyknaiykekdatarenno2 = "2";
//        BizDate pSyoriYmd1 = BizDate.MIN_VALID_DATE;
//        BizDate pSyoriYmd2 = BizDate.MAX_VALID_DATE;
//        String pMosno1 = "Mosno0001";
//        String pMosno2 = "Mosno0002";
//        BizNumber renno21 = BizNumber.valueOf(1);
//        BizNumber renno22 = BizNumber.valueOf(2);
//        BizDate pSousinymd1 = BizDate.valueOf("20150201");
//        BizDate pSousinymd2 = BizDate.valueOf("20150301");
//
//        HT_SkLincJyusinInfo hT_SkLincJyusinInfo7 = new HT_SkLincJyusinInfo();
//        hT_SkLincJyusinInfo7.setLincsoujyusinsyskbn(Lincsoujyusinsyskbn2);
//        hT_SkLincJyusinInfo7.setLinckyknaiykekdatarenno(pLinckyknaiykekdatarenno2);
//        hT_SkLincJyusinInfo7.setSyoriYmd(pSyoriYmd2);
//        hT_SkLincJyusinInfo7.setMosno(pMosno2);
//        hT_SkLincJyusinInfo7.setRenno2(renno22);
//        hT_SkLincJyusinInfo7.setSousinymd(pSousinymd2);
//        sinkeiyakuDomManager.insert(hT_SkLincJyusinInfo7);
//
//        HT_SkLincJyusinInfo hT_SkLincJyusinInfo6 = new HT_SkLincJyusinInfo();
//        hT_SkLincJyusinInfo6.setLincsoujyusinsyskbn(Lincsoujyusinsyskbn2);
//        hT_SkLincJyusinInfo6.setLinckyknaiykekdatarenno(pLinckyknaiykekdatarenno2);
//        hT_SkLincJyusinInfo6.setSyoriYmd(pSyoriYmd2);
//        hT_SkLincJyusinInfo6.setMosno(pMosno2);
//        hT_SkLincJyusinInfo6.setRenno2(renno22);
//        hT_SkLincJyusinInfo6.setSousinymd(pSousinymd1);
//        sinkeiyakuDomManager.insert(hT_SkLincJyusinInfo6);
//
//        HT_SkLincJyusinInfo hT_SkLincJyusinInfo5 = new HT_SkLincJyusinInfo();
//        hT_SkLincJyusinInfo5.setLincsoujyusinsyskbn(Lincsoujyusinsyskbn2);
//        hT_SkLincJyusinInfo5.setLinckyknaiykekdatarenno(pLinckyknaiykekdatarenno2);
//        hT_SkLincJyusinInfo5.setSyoriYmd(pSyoriYmd2);
//        hT_SkLincJyusinInfo5.setMosno(pMosno2);
//        hT_SkLincJyusinInfo5.setRenno2(renno21);
//        hT_SkLincJyusinInfo5.setSousinymd(pSousinymd1);
//        sinkeiyakuDomManager.insert(hT_SkLincJyusinInfo5);
//
//        HT_SkLincJyusinInfo hT_SkLincJyusinInfo4 = new HT_SkLincJyusinInfo();
//        hT_SkLincJyusinInfo4.setLincsoujyusinsyskbn(Lincsoujyusinsyskbn2);
//        hT_SkLincJyusinInfo4.setLinckyknaiykekdatarenno(pLinckyknaiykekdatarenno2);
//        hT_SkLincJyusinInfo4.setSyoriYmd(pSyoriYmd2);
//        hT_SkLincJyusinInfo4.setMosno(pMosno1);
//        hT_SkLincJyusinInfo4.setRenno2(renno21);
//        hT_SkLincJyusinInfo4.setSousinymd(pSousinymd1);
//        sinkeiyakuDomManager.insert(hT_SkLincJyusinInfo4);
//
//        HT_SkLincJyusinInfo hT_SkLincJyusinInfo3 = new HT_SkLincJyusinInfo();
//        hT_SkLincJyusinInfo3.setLincsoujyusinsyskbn(Lincsoujyusinsyskbn2);
//        hT_SkLincJyusinInfo3.setLinckyknaiykekdatarenno(pLinckyknaiykekdatarenno2);
//        hT_SkLincJyusinInfo3.setSyoriYmd(pSyoriYmd1);
//        hT_SkLincJyusinInfo3.setMosno(pMosno1);
//        hT_SkLincJyusinInfo3.setRenno2(renno21);
//        hT_SkLincJyusinInfo3.setSousinymd(pSousinymd1);
//        sinkeiyakuDomManager.insert(hT_SkLincJyusinInfo3);
//
//        HT_SkLincJyusinInfo hT_SkLincJyusinInfo2 = new HT_SkLincJyusinInfo();
//        hT_SkLincJyusinInfo2.setLincsoujyusinsyskbn(Lincsoujyusinsyskbn2);
//        hT_SkLincJyusinInfo2.setLinckyknaiykekdatarenno(pLinckyknaiykekdatarenno1);
//        hT_SkLincJyusinInfo2.setSyoriYmd(pSyoriYmd1);
//        hT_SkLincJyusinInfo2.setMosno(pMosno1);
//        hT_SkLincJyusinInfo2.setRenno2(renno21);
//        hT_SkLincJyusinInfo2.setSousinymd(pSousinymd1);
//        sinkeiyakuDomManager.insert(hT_SkLincJyusinInfo2);
//
//        HT_SkLincJyusinInfo hT_SkLincJyusinInfo1 = new HT_SkLincJyusinInfo();
//        hT_SkLincJyusinInfo1.setLincsoujyusinsyskbn(Lincsoujyusinsyskbn1);
//        hT_SkLincJyusinInfo1.setLinckyknaiykekdatarenno(pLinckyknaiykekdatarenno1);
//        hT_SkLincJyusinInfo1.setSyoriYmd(pSyoriYmd1);
//        hT_SkLincJyusinInfo1.setMosno(pMosno1);
//        hT_SkLincJyusinInfo1.setRenno2(renno21);
//        hT_SkLincJyusinInfo1.setSousinymd(pSousinymd1);
//        sinkeiyakuDomManager.insert(hT_SkLincJyusinInfo1);
//
//    }
//
//    @AfterClass
//    @Transactional
//    public static void deleteTestData() {
//
//        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
//
//        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSkLincJyusinInfo());
//
//    }
//
//    @Override
//    @Test
//    @TestOrder(10)
//    public void getAll() {
//
//        C_LincsoujyusinsysKbn Lincsoujyusinsyskbn1 = C_LincsoujyusinsysKbn.SKEI;
//        C_LincsoujyusinsysKbn Lincsoujyusinsyskbn2 = C_LincsoujyusinsysKbn.HOZEN;
//        String pLinckyknaiykekdatarenno1 = "1";
//        String pLinckyknaiykekdatarenno2 = "2";
//        BizDate pSyoriYmd1 = BizDate.MIN_VALID_DATE;
//        BizDate pSyoriYmd2 = BizDate.MAX_VALID_DATE;
//        String pMosno1 = "Mosno0001";
//        String pMosno2 = "Mosno0002";
//        BizNumber renno21 = BizNumber.valueOf(1);
//        BizNumber renno22 = BizNumber.valueOf(2);
//        BizDate pSousinymd1 = BizDate.valueOf("20150201");
//        BizDate pSousinymd2 = BizDate.valueOf("20150301");
//
//        List<HT_SkLincJyusinInfo> hT_SkLincJyusinInfos = sinkeiyakuDomManager.getAllSkLincJyusinInfo();
//        Assert.assertEquals(Lincsoujyusinsyskbn1, hT_SkLincJyusinInfos.get(0).getLincsoujyusinsyskbn());
//        Assert.assertEquals(pLinckyknaiykekdatarenno1, hT_SkLincJyusinInfos.get(0).getLinckyknaiykekdatarenno());
//        Assert.assertEquals(pSyoriYmd1, hT_SkLincJyusinInfos.get(0).getSyoriYmd());
//        Assert.assertEquals(pMosno1, hT_SkLincJyusinInfos.get(0).getMosno());
//        Assert.assertEquals(renno21, hT_SkLincJyusinInfos.get(0).getRenno2());
//        Assert.assertEquals(pSousinymd1, hT_SkLincJyusinInfos.get(0).getSousinymd());
//
//        Assert.assertEquals(Lincsoujyusinsyskbn2, hT_SkLincJyusinInfos.get(1).getLincsoujyusinsyskbn());
//        Assert.assertEquals(pLinckyknaiykekdatarenno1, hT_SkLincJyusinInfos.get(1).getLinckyknaiykekdatarenno());
//        Assert.assertEquals(pSyoriYmd1, hT_SkLincJyusinInfos.get(1).getSyoriYmd());
//        Assert.assertEquals(pMosno1, hT_SkLincJyusinInfos.get(1).getMosno());
//        Assert.assertEquals(renno21, hT_SkLincJyusinInfos.get(1).getRenno2());
//        Assert.assertEquals(pSousinymd1, hT_SkLincJyusinInfos.get(1).getSousinymd());
//
//        Assert.assertEquals(Lincsoujyusinsyskbn2, hT_SkLincJyusinInfos.get(2).getLincsoujyusinsyskbn());
//        Assert.assertEquals(pLinckyknaiykekdatarenno2, hT_SkLincJyusinInfos.get(2).getLinckyknaiykekdatarenno());
//        Assert.assertEquals(pSyoriYmd1, hT_SkLincJyusinInfos.get(2).getSyoriYmd());
//        Assert.assertEquals(pMosno1, hT_SkLincJyusinInfos.get(2).getMosno());
//        Assert.assertEquals(renno21, hT_SkLincJyusinInfos.get(2).getRenno2());
//        Assert.assertEquals(pSousinymd1, hT_SkLincJyusinInfos.get(2).getSousinymd());
//
//        Assert.assertEquals(Lincsoujyusinsyskbn2, hT_SkLincJyusinInfos.get(3).getLincsoujyusinsyskbn());
//        Assert.assertEquals(pLinckyknaiykekdatarenno2, hT_SkLincJyusinInfos.get(3).getLinckyknaiykekdatarenno());
//        Assert.assertEquals(pSyoriYmd2, hT_SkLincJyusinInfos.get(3).getSyoriYmd());
//        Assert.assertEquals(pMosno1, hT_SkLincJyusinInfos.get(3).getMosno());
//        Assert.assertEquals(renno21, hT_SkLincJyusinInfos.get(3).getRenno2());
//        Assert.assertEquals(pSousinymd1, hT_SkLincJyusinInfos.get(3).getSousinymd());
//
//        Assert.assertEquals(Lincsoujyusinsyskbn2, hT_SkLincJyusinInfos.get(4).getLincsoujyusinsyskbn());
//        Assert.assertEquals(pLinckyknaiykekdatarenno2, hT_SkLincJyusinInfos.get(4).getLinckyknaiykekdatarenno());
//        Assert.assertEquals(pSyoriYmd2, hT_SkLincJyusinInfos.get(4).getSyoriYmd());
//        Assert.assertEquals(pMosno2, hT_SkLincJyusinInfos.get(4).getMosno());
//        Assert.assertEquals(renno21, hT_SkLincJyusinInfos.get(4).getRenno2());
//        Assert.assertEquals(pSousinymd1, hT_SkLincJyusinInfos.get(4).getSousinymd());
//
//        Assert.assertEquals(Lincsoujyusinsyskbn2, hT_SkLincJyusinInfos.get(5).getLincsoujyusinsyskbn());
//        Assert.assertEquals(pLinckyknaiykekdatarenno2, hT_SkLincJyusinInfos.get(5).getLinckyknaiykekdatarenno());
//        Assert.assertEquals(pSyoriYmd2, hT_SkLincJyusinInfos.get(5).getSyoriYmd());
//        Assert.assertEquals(pMosno2, hT_SkLincJyusinInfos.get(5).getMosno());
//        Assert.assertEquals(renno22, hT_SkLincJyusinInfos.get(5).getRenno2());
//        Assert.assertEquals(pSousinymd1, hT_SkLincJyusinInfos.get(5).getSousinymd());
//
//        Assert.assertEquals(Lincsoujyusinsyskbn2, hT_SkLincJyusinInfos.get(6).getLincsoujyusinsyskbn());
//        Assert.assertEquals(pLinckyknaiykekdatarenno2, hT_SkLincJyusinInfos.get(6).getLinckyknaiykekdatarenno());
//        Assert.assertEquals(pSyoriYmd2, hT_SkLincJyusinInfos.get(6).getSyoriYmd());
//        Assert.assertEquals(pMosno2, hT_SkLincJyusinInfos.get(6).getMosno());
//        Assert.assertEquals(renno22, hT_SkLincJyusinInfos.get(6).getRenno2());
//        Assert.assertEquals(pSousinymd2, hT_SkLincJyusinInfos.get(6).getSousinymd());
//
//        Assert.assertEquals(7, hT_SkLincJyusinInfos.size());
//
//    }
//
//    @Override
//    @Test
//    @TestOrder(20)
//    public void getUniqueEntity() {
//        C_LincsoujyusinsysKbn Lincsoujyusinsyskbn1 = C_LincsoujyusinsysKbn.SKEI;
//        String pLinckyknaiykekdatarenno1 = "1";
//        BizDate pSyoriYmd1 = BizDate.MIN_VALID_DATE;
//        String pMosno1 = "Mosno0001";
//        BizNumber renno21 = BizNumber.valueOf(1);
//        BizDate pSousinymd1 = BizDate.valueOf("20150201");
//        HT_SkLincJyusinInfo hT_SkLincJyusinInfo = sinkeiyakuDomManager.getSkLincJyusinInfo(Lincsoujyusinsyskbn1,
//            pLinckyknaiykekdatarenno1, pSyoriYmd1,pMosno1, renno21, pSousinymd1);
//
//        Assert.assertEquals(Lincsoujyusinsyskbn1, hT_SkLincJyusinInfo.getLincsoujyusinsyskbn());
//        Assert.assertEquals(pLinckyknaiykekdatarenno1, hT_SkLincJyusinInfo.getLinckyknaiykekdatarenno());
//        Assert.assertEquals(pSyoriYmd1, hT_SkLincJyusinInfo.getSyoriYmd());
//        Assert.assertEquals(pMosno1, hT_SkLincJyusinInfo.getMosno());
//        Assert.assertEquals(renno21, hT_SkLincJyusinInfo.getRenno2());
//        Assert.assertEquals(pSousinymd1, hT_SkLincJyusinInfo.getSousinymd());
//
//    }
//
//    @Override
//    @Test
//    @TestOrder(30)
//    public void noUniqueEntity() {
//        C_LincsoujyusinsysKbn Lincsoujyusinsyskbn1 = C_LincsoujyusinsysKbn.HOZEN;
//        String pLinckyknaiykekdatarenno1 = "2";
//        BizDate pSyoriYmd1 = BizDate.valueOf("20110101");
//        String pMosno1 = "Mosno0111";
//        BizNumber renno21 = BizNumber.valueOf(1);
//        BizDate pSousinymd1 = BizDate.valueOf("20150401");
//
//        HT_SkLincJyusinInfo hT_SkLincJyusinInfo = sinkeiyakuDomManager.getSkLincJyusinInfo(Lincsoujyusinsyskbn1,
//            pLinckyknaiykekdatarenno1, pSyoriYmd1,pMosno1, renno21, pSousinymd1);
//        Assert.assertNull(hT_SkLincJyusinInfo);
//
//    }
//
//    @Override
//    @Test
//    @TestOrder(40)
//    public void blankCondition() {
//
//        C_LincsoujyusinsysKbn Lincsoujyusinsyskbn1 = C_LincsoujyusinsysKbn.HOZEN;
//        String pLinckyknaiykekdatarenno1 = "2";
//        BizDate pSyoriYmd1 = BizDate.valueOf("20110101");
//        String pMosnoBlank = "";
//        BizNumber renno21 = BizNumber.valueOf(1);
//        BizDate pSousinymd1 = BizDate.valueOf("20150401");
//        HT_SkLincJyusinInfo hT_SkLincJyusinInfo = sinkeiyakuDomManager.getSkLincJyusinInfo(Lincsoujyusinsyskbn1,
//            pLinckyknaiykekdatarenno1, pSyoriYmd1,pMosnoBlank, renno21, pSousinymd1);
//        Assert.assertNull(hT_SkLincJyusinInfo);
//
//    }
//
//    @Override
//    @Test
//    @TestOrder(50)
//    public void nullCondition() {
//        Assert.assertTrue(true);
//    }


//}