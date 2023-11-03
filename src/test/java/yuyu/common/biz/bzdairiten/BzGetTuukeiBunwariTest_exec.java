package yuyu.common.biz.bzdairiten;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_DiritenplannmKbn;
import yuyu.def.classification.C_DrtSyouhinSikibetuKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.db.entity.BT_BuntanInfo;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 通計用代理店分担割合取得クラスのメソッド {@link BzGetTuukeiBunwari#exec(String, String, BizNumber, String, String,
 * BizNumber, BizDateYM, C_DrtSyouhinSikibetuKbn, C_Hrkkaisuu, C_DiritenplannmKbn)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzGetTuukeiBunwariTest_exec {

    @Inject
    private BzGetTuukeiBunwari bzGetTuukeiBunwari;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        BT_BuntanInfo buntanInfo1 = new BT_BuntanInfo();
        buntanInfo1.setDrtencd("5100001");
        buntanInfo1.setDairitensyouhincd("64200");
        buntanInfo1.setTesuuryoubuntandrtencd("5100002");
        buntanInfo1.setTesuuryoubuntanstartym(BizDateYM.valueOf(201601));
        buntanInfo1.setTesuuryoubuntanendym(BizDateYM.valueOf(201601));
        buntanInfo1.setTesuuryoubuntanwariai(BizNumber.valueOf(66));
        bizDomManager.insert(buntanInfo1);

        BT_BuntanInfo buntanInfo2 = new BT_BuntanInfo();
        buntanInfo2.setDrtencd("5100005");
        buntanInfo2.setDairitensyouhincd("64200");
        buntanInfo2.setTesuuryoubuntandrtencd("5100006");
        buntanInfo2.setTesuuryoubuntanstartym(BizDateYM.valueOf(201601));
        buntanInfo2.setTesuuryoubuntanendym(BizDateYM.valueOf(201601));
        buntanInfo2.setTesuuryoubuntanwariai(BizNumber.valueOf(80));
        bizDomManager.insert(buntanInfo2);

        BT_BuntanInfo buntanInfo3 = new BT_BuntanInfo();
        buntanInfo3.setDrtencd("5100037");
        buntanInfo3.setDairitensyouhincd("64200");
        buntanInfo3.setTesuuryoubuntandrtencd("1200069");
        buntanInfo3.setTesuuryoubuntanstartym(BizDateYM.valueOf(201602));
        buntanInfo3.setTesuuryoubuntanendym(BizDateYM.valueOf(201603));
        buntanInfo3.setTesuuryoubuntanwariai(BizNumber.valueOf(90));
        bizDomManager.insert(buntanInfo3);

        BT_BuntanInfo buntanInfo4 = new BT_BuntanInfo();
        buntanInfo4.setDrtencd("5200001");
        buntanInfo4.setDairitensyouhincd("64200");
        buntanInfo4.setTesuuryoubuntandrtencd("1200031");
        buntanInfo4.setTesuuryoubuntanstartym(BizDateYM.valueOf(201602));
        buntanInfo4.setTesuuryoubuntanendym(BizDateYM.valueOf(201603));
        buntanInfo4.setTesuuryoubuntanwariai(BizNumber.valueOf(90));
        bizDomManager.insert(buntanInfo4);

        BT_BuntanInfo buntanInfo5 = new BT_BuntanInfo();
        buntanInfo5.setDrtencd("5100001");
        buntanInfo5.setDairitensyouhincd("64200");
        buntanInfo5.setTesuuryoubuntandrtencd("5303613");
        buntanInfo5.setTesuuryoubuntanstartym(BizDateYM.valueOf(201601));
        buntanInfo5.setTesuuryoubuntanendym(BizDateYM.valueOf(201601));
        buntanInfo5.setTesuuryoubuntanwariai(BizNumber.valueOf(67));
        bizDomManager.insert(buntanInfo5);

        BT_BuntanInfo buntanInfo6 = new BT_BuntanInfo();
        buntanInfo6.setDrtencd("5100005");
        buntanInfo6.setDairitensyouhincd("64200");
        buntanInfo6.setTesuuryoubuntandrtencd("5303613");
        buntanInfo6.setTesuuryoubuntanstartym(BizDateYM.valueOf(201601));
        buntanInfo6.setTesuuryoubuntanendym(BizDateYM.valueOf(201601));
        buntanInfo6.setTesuuryoubuntanwariai(BizNumber.valueOf(81));
        bizDomManager.insert(buntanInfo6);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllBuntanInfo());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        String drtenCd1 = "5100001";

        String oyaDrtenCd1 = "A000001";

        BizNumber buntanwariai1 = BizNumber.valueOf(100);

        String drtenCd2 = "5100037";

        String oyaDrtenCd2 = "A000002";

        BizNumber buntanwariai2 = BizNumber.valueOf(0);

        BizDateYM kijyunYm = null;

        C_DrtSyouhinSikibetuKbn drtSyouhinSikibetuKbn = C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI;

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;

        C_DiritenplannmKbn diritenplannmKbn = C_DiritenplannmKbn.BLNK;

        bzGetTuukeiBunwari.exec(drtenCd1
            , oyaDrtenCd1
            , buntanwariai1
            , drtenCd2
            , oyaDrtenCd2
            , buntanwariai2
            , kijyunYm
            , drtSyouhinSikibetuKbn
            , hrkkaisuu
            , diritenplannmKbn);

        exClassificationEquals(bzGetTuukeiBunwari.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        String drtenCd1 = "5100001";

        String oyaDrtenCd1 = "A000001";

        BizNumber buntanwariai1 = BizNumber.valueOf(100);

        String drtenCd2 = "5100037";

        String oyaDrtenCd2 = "A000002";

        BizNumber buntanwariai2 = BizNumber.valueOf(0);

        BizDateYM kijyunYm = BizDateYM.valueOf(201601);

        C_DrtSyouhinSikibetuKbn drtSyouhinSikibetuKbn = null;

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;

        C_DiritenplannmKbn diritenplannmKbn = C_DiritenplannmKbn.BLNK;

        bzGetTuukeiBunwari.exec(drtenCd1
            , oyaDrtenCd1
            , buntanwariai1
            , drtenCd2
            , oyaDrtenCd2
            , buntanwariai2
            , kijyunYm
            , drtSyouhinSikibetuKbn
            , hrkkaisuu
            , diritenplannmKbn);

        exClassificationEquals(bzGetTuukeiBunwari.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        String drtenCd1 = "5100001";

        String oyaDrtenCd1 = "5303630";

        BizNumber buntanwariai1 = BizNumber.valueOf(100);

        String drtenCd2 = "5100002";

        String oyaDrtenCd2 = "5303613";

        BizNumber buntanwariai2 = BizNumber.valueOf(0);

        BizDateYM kijyunYm = BizDateYM.valueOf(201601);

        C_DrtSyouhinSikibetuKbn drtSyouhinSikibetuKbn = C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI;

        C_Hrkkaisuu hrkkaisuu = null;

        C_DiritenplannmKbn diritenplannmKbn = C_DiritenplannmKbn.BLNK;

        bzGetTuukeiBunwari.exec(drtenCd1
            , oyaDrtenCd1
            , buntanwariai1
            , drtenCd2
            , oyaDrtenCd2
            , buntanwariai2
            , kijyunYm
            , drtSyouhinSikibetuKbn
            , hrkkaisuu
            , diritenplannmKbn);

        exClassificationEquals(bzGetTuukeiBunwari.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        String drtenCd1 = "5100001";

        String oyaDrtenCd1 = "5303630";

        BizNumber buntanwariai1 = BizNumber.valueOf(100);

        String drtenCd2 = "5100002";

        String oyaDrtenCd2 = "5303613";

        BizNumber buntanwariai2 = BizNumber.valueOf(0);

        BizDateYM kijyunYm = BizDateYM.valueOf(201601);

        C_DrtSyouhinSikibetuKbn drtSyouhinSikibetuKbn = C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI;

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;

        C_DiritenplannmKbn diritenplannmKbn = null;

        bzGetTuukeiBunwari.exec(drtenCd1
            , oyaDrtenCd1
            , buntanwariai1
            , drtenCd2
            , oyaDrtenCd2
            , buntanwariai2
            , kijyunYm
            , drtSyouhinSikibetuKbn
            , hrkkaisuu
            , diritenplannmKbn);

        exClassificationEquals(bzGetTuukeiBunwari.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
    }
    @Test
    @TestOrder(50)
    public void testExec_A5() {

        String drtenCd1 = "";

        String oyaDrtenCd1 = "5303630";

        BizNumber buntanwariai1 = BizNumber.valueOf(100);

        String drtenCd2 = "5100002";

        String oyaDrtenCd2 = "5303613";

        BizNumber buntanwariai2 = BizNumber.valueOf(0);

        BizDateYM kijyunYm = BizDateYM.valueOf(201601);

        C_DrtSyouhinSikibetuKbn drtSyouhinSikibetuKbn = C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI;

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;

        C_DiritenplannmKbn diritenplannmKbn = C_DiritenplannmKbn.BLNK;

        bzGetTuukeiBunwari.exec(drtenCd1
            , oyaDrtenCd1
            , buntanwariai1
            , drtenCd2
            , oyaDrtenCd2
            , buntanwariai2
            , kijyunYm
            , drtSyouhinSikibetuKbn
            , hrkkaisuu
            , diritenplannmKbn);

        exStringEquals(bzGetTuukeiBunwari.getDrtencd1(), "", "代理店コード１");
        exStringEquals(bzGetTuukeiBunwari.getBuntanWariai1().toString(), "0", "分担割合１");
        exStringEquals(bzGetTuukeiBunwari.getDrtencd2(), "", "代理店コード２");
        exStringEquals(bzGetTuukeiBunwari.getBuntanWariai2().toString(), "0", "分担割合２");
        exClassificationEquals(bzGetTuukeiBunwari.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
    }


    @Test
    @TestOrder(60)
    public void testExec_A6() {

        String drtenCd1 = null;

        String oyaDrtenCd1 = "5303630";

        BizNumber buntanwariai1 = BizNumber.valueOf(100);

        String drtenCd2 = "5100002";

        String oyaDrtenCd2 = "5303613";

        BizNumber buntanwariai2 = BizNumber.valueOf(0);

        BizDateYM kijyunYm = BizDateYM.valueOf(201601);

        C_DrtSyouhinSikibetuKbn drtSyouhinSikibetuKbn = C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI;

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;

        C_DiritenplannmKbn diritenplannmKbn = C_DiritenplannmKbn.BLNK;

        bzGetTuukeiBunwari.exec(drtenCd1
            , oyaDrtenCd1
            , buntanwariai1
            , drtenCd2
            , oyaDrtenCd2
            , buntanwariai2
            , kijyunYm
            , drtSyouhinSikibetuKbn
            , hrkkaisuu
            , diritenplannmKbn);

        exStringEquals(bzGetTuukeiBunwari.getDrtencd1(), "", "代理店コード１");
        exStringEquals(bzGetTuukeiBunwari.getBuntanWariai1().toString(), "0", "分担割合１");
        exStringEquals(bzGetTuukeiBunwari.getDrtencd2(), "", "代理店コード２");
        exStringEquals(bzGetTuukeiBunwari.getBuntanWariai2().toString(), "0", "分担割合２");
        exClassificationEquals(bzGetTuukeiBunwari.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        String drtenCd1 = "5100001";

        String oyaDrtenCd1 = "5303630";

        BizNumber buntanwariai1 = BizNumber.valueOf(55);

        String drtenCd2 = "";

        String oyaDrtenCd2 = "5303613";

        BizNumber buntanwariai2 = BizNumber.valueOf(45);

        BizDateYM kijyunYm = BizDateYM.valueOf(201601);

        C_DrtSyouhinSikibetuKbn drtSyouhinSikibetuKbn = C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI;

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;

        C_DiritenplannmKbn diritenplannmKbn = C_DiritenplannmKbn.BLNK;

        bzGetTuukeiBunwari.exec(drtenCd1
            , oyaDrtenCd1
            , buntanwariai1
            , drtenCd2
            , oyaDrtenCd2
            , buntanwariai2
            , kijyunYm
            , drtSyouhinSikibetuKbn
            , hrkkaisuu
            , diritenplannmKbn);

        exStringEquals(bzGetTuukeiBunwari.getDrtencd1(), "5100001", "代理店コード１");
        exStringEquals(bzGetTuukeiBunwari.getBuntanWariai1().toString(), "55", "分担割合１");
        exStringEquals(bzGetTuukeiBunwari.getDrtencd2(), "", "代理店コード２");
        exStringEquals(bzGetTuukeiBunwari.getBuntanWariai2().toString(), "45", "分担割合２");
        exClassificationEquals(bzGetTuukeiBunwari.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        String drtenCd1 = "5100001";

        String oyaDrtenCd1 = "5303630";

        BizNumber buntanwariai1 = BizNumber.valueOf(64);

        String drtenCd2 = null;

        String oyaDrtenCd2 = "5303613";

        BizNumber buntanwariai2 = BizNumber.valueOf(36);

        BizDateYM kijyunYm = BizDateYM.valueOf(201601);

        C_DrtSyouhinSikibetuKbn drtSyouhinSikibetuKbn = C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI;

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;

        C_DiritenplannmKbn diritenplannmKbn = C_DiritenplannmKbn.BLNK;

        bzGetTuukeiBunwari.exec(drtenCd1
            , oyaDrtenCd1
            , buntanwariai1
            , drtenCd2
            , oyaDrtenCd2
            , buntanwariai2
            , kijyunYm
            , drtSyouhinSikibetuKbn
            , hrkkaisuu
            , diritenplannmKbn);

        exStringEquals(bzGetTuukeiBunwari.getDrtencd1(), "5100001", "代理店コード１");
        exStringEquals(bzGetTuukeiBunwari.getBuntanWariai1().toString(), "64", "分担割合１");
        exStringEquals(bzGetTuukeiBunwari.getDrtencd2(), "", "代理店コード２");
        exStringEquals(bzGetTuukeiBunwari.getBuntanWariai2().toString(), "36", "分担割合２");
        exClassificationEquals(bzGetTuukeiBunwari.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        String drtenCd1 = "5100001";

        String oyaDrtenCd1 = "5303630";

        BizNumber buntanwariai1 = BizNumber.valueOf(64);

        String drtenCd2 = "5100001";

        String oyaDrtenCd2 = "5303613";

        BizNumber buntanwariai2 = BizNumber.valueOf(36);

        BizDateYM kijyunYm = BizDateYM.valueOf(201601);

        C_DrtSyouhinSikibetuKbn drtSyouhinSikibetuKbn = C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI;

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;

        C_DiritenplannmKbn diritenplannmKbn = C_DiritenplannmKbn.BLNK;

        bzGetTuukeiBunwari.exec(drtenCd1
            , oyaDrtenCd1
            , buntanwariai1
            , drtenCd2
            , oyaDrtenCd2
            , buntanwariai2
            , kijyunYm
            , drtSyouhinSikibetuKbn
            , hrkkaisuu
            , diritenplannmKbn);

        exStringEquals(bzGetTuukeiBunwari.getDrtencd1(), "5100001", "代理店コード１");
        exStringEquals(bzGetTuukeiBunwari.getBuntanWariai1().toString(), "100", "分担割合１");
        exStringEquals(bzGetTuukeiBunwari.getDrtencd2(), "", "代理店コード２");
        exStringEquals(bzGetTuukeiBunwari.getBuntanWariai2().toString(), "0", "分担割合２");
        exClassificationEquals(bzGetTuukeiBunwari.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        String drtenCd1 = "5100001";

        String oyaDrtenCd1 = "5303630";

        BizNumber buntanwariai1 = BizNumber.valueOf(64);

        String drtenCd2 = "5100002";

        String oyaDrtenCd2 = "5303613";

        BizNumber buntanwariai2 = BizNumber.valueOf(36);

        BizDateYM kijyunYm = BizDateYM.valueOf(201601);

        C_DrtSyouhinSikibetuKbn drtSyouhinSikibetuKbn = C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI;

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;

        C_DiritenplannmKbn diritenplannmKbn = C_DiritenplannmKbn.BLNK;

        bzGetTuukeiBunwari.exec(drtenCd1
            , oyaDrtenCd1
            , buntanwariai1
            , drtenCd2
            , oyaDrtenCd2
            , buntanwariai2
            , kijyunYm
            , drtSyouhinSikibetuKbn
            , hrkkaisuu
            , diritenplannmKbn);

        exStringEquals(bzGetTuukeiBunwari.getDrtencd1(), "5100001", "代理店コード１");
        exStringEquals(bzGetTuukeiBunwari.getBuntanWariai1().toString(), "64", "分担割合１");
        exStringEquals(bzGetTuukeiBunwari.getDrtencd2(), "5100002", "代理店コード２");
        exStringEquals(bzGetTuukeiBunwari.getBuntanWariai2().toString(), "36", "分担割合２");
        exClassificationEquals(bzGetTuukeiBunwari.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        String drtenCd1 = "5100001";

        String oyaDrtenCd1 = "5303630";

        BizNumber buntanwariai1 = BizNumber.valueOf(0);

        String drtenCd2 = "5100002";

        String oyaDrtenCd2 = "5303613";

        BizNumber buntanwariai2 = BizNumber.valueOf(70);

        BizDateYM kijyunYm = BizDateYM.valueOf(201601);

        C_DrtSyouhinSikibetuKbn drtSyouhinSikibetuKbn = C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI;

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;

        C_DiritenplannmKbn diritenplannmKbn = C_DiritenplannmKbn.BLNK;

        bzGetTuukeiBunwari.exec(drtenCd1
            , oyaDrtenCd1
            , buntanwariai1
            , drtenCd2
            , oyaDrtenCd2
            , buntanwariai2
            , kijyunYm
            , drtSyouhinSikibetuKbn
            , hrkkaisuu
            , diritenplannmKbn);

        exStringEquals(bzGetTuukeiBunwari.getDrtencd1(), "5100001", "代理店コード１");
        exStringEquals(bzGetTuukeiBunwari.getBuntanWariai1().toString(), "67", "分担割合１");
        exStringEquals(bzGetTuukeiBunwari.getDrtencd2(), "5100002", "代理店コード２");
        exStringEquals(bzGetTuukeiBunwari.getBuntanWariai2().toString(), "33", "分担割合２");
        exClassificationEquals(bzGetTuukeiBunwari.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        String drtenCd1 = "5100003";

        String oyaDrtenCd1 = "5100005";

        BizNumber buntanwariai1 = BizNumber.valueOf(0);

        String drtenCd2 = "5100006";

        String oyaDrtenCd2 = "5303613";

        BizNumber buntanwariai2 = BizNumber.valueOf(70);

        BizDateYM kijyunYm = BizDateYM.valueOf(201601);

        C_DrtSyouhinSikibetuKbn drtSyouhinSikibetuKbn = C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI;

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;

        C_DiritenplannmKbn diritenplannmKbn = C_DiritenplannmKbn.BLNK;

        bzGetTuukeiBunwari.exec(drtenCd1
            , oyaDrtenCd1
            , buntanwariai1
            , drtenCd2
            , oyaDrtenCd2
            , buntanwariai2
            , kijyunYm
            , drtSyouhinSikibetuKbn
            , hrkkaisuu
            , diritenplannmKbn);

        exStringEquals(bzGetTuukeiBunwari.getDrtencd1(), "5100003", "代理店コード１");
        exStringEquals(bzGetTuukeiBunwari.getBuntanWariai1().toString(), "81", "分担割合１");
        exStringEquals(bzGetTuukeiBunwari.getDrtencd2(), "5100006", "代理店コード２");
        exStringEquals(bzGetTuukeiBunwari.getBuntanWariai2().toString(), "19", "分担割合２");
        exClassificationEquals(bzGetTuukeiBunwari.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {

        String drtenCd1 = "5100037";

        String oyaDrtenCd1 = "5200001";

        BizNumber buntanwariai1 = BizNumber.valueOf(0);

        String drtenCd2 = "1200069";

        String oyaDrtenCd2 = "5303613";

        BizNumber buntanwariai2 = BizNumber.valueOf(70);

        BizDateYM kijyunYm = BizDateYM.valueOf(201601);

        C_DrtSyouhinSikibetuKbn drtSyouhinSikibetuKbn = C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKASYSNITIJI;

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;

        C_DiritenplannmKbn diritenplannmKbn = C_DiritenplannmKbn.BLNK;

        bzGetTuukeiBunwari.exec(drtenCd1
            , oyaDrtenCd1
            , buntanwariai1
            , drtenCd2
            , oyaDrtenCd2
            , buntanwariai2
            , kijyunYm
            , drtSyouhinSikibetuKbn
            , hrkkaisuu
            , diritenplannmKbn);

        exStringEquals(bzGetTuukeiBunwari.getDrtencd1(), "5100037", "代理店コード１");
        exStringEquals(bzGetTuukeiBunwari.getBuntanWariai1().toString(), "50", "分担割合１");
        exStringEquals(bzGetTuukeiBunwari.getDrtencd2(), "1200069", "代理店コード２");
        exStringEquals(bzGetTuukeiBunwari.getBuntanWariai2().toString(), "50", "分担割合２");
        exClassificationEquals(bzGetTuukeiBunwari.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
    }
}
