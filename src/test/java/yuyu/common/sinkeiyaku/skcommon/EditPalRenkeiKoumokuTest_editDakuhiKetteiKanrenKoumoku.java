package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_Ketriyuucd;
import yuyu.def.classification.C_TorikesisyousairiyuuCd;
import yuyu.def.db.entity.HT_DakuhiKettei;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＰＡＬ連携項目編集クラスのメソッド {@link EditPalRenkeiKoumoku#editDakuhiKetteiKanrenKoumoku(List)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditPalRenkeiKoumokuTest_editDakuhiKetteiKanrenKoumoku {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private EditPalRenkeiKoumoku editPalRenkeiKoumoku;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_ＰＡＬ連携項目編集";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData(){
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditPalRenkeiKoumokuTest_editDakuhiKetteiKanrenKoumoku.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
    }

    @Test
    @TestOrder(10)
    public void testEditDakuhiKetteiKanrenKoumoku_A1() {

        HT_SyoriCTL soriCTL = sinkeiyakuDomManager.getSyoriCTL("860000017");
        List<HT_DakuhiKettei> dakuhiKetteiLst = soriCTL.getDakuhiKetteis();

        editPalRenkeiKoumoku.editDakuhiKetteiKanrenKoumoku(dakuhiKetteiLst);

        exClassificationEquals(editPalRenkeiKoumoku.getSaisinKetkekkaCd(), C_Ketkekkacd.BLNK, "（最新）決定結果コード");
        exClassificationEquals(editPalRenkeiKoumoku.getSaisinTorikesiSyousaiRiyuuCd(), C_TorikesisyousairiyuuCd.BLNK,
            "（最新）取消詳細理由コード");
        exStringEquals(editPalRenkeiKoumoku.getSaisinPalKetsyaCd(), "",
            "（最新）ＰＡＬ決定者コード");
        exClassificationEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCd(), C_Ketkekkacd.BLNK,
            "（諾否決定最新）決定結果コード");
        exDateEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetteiYmd(), null, "（諾否決定最新）決定日");
        exClassificationEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCd1(), C_Ketriyuucd.BLNK,
            "（諾否決定最新）決定理由コード１");
        exClassificationEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCd2(), C_Ketriyuucd.BLNK,
            "（諾否決定最新）決定理由コード２");
        exClassificationEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCd3(), C_Ketriyuucd.BLNK,
            "（諾否決定最新）決定理由コード３");
        exClassificationEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCd4(), C_Ketriyuucd.BLNK,
            "（諾否決定最新）決定理由コード４");
        exNumericEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCdLst().size(), 6,
            "（諾否決定）決定結果コードリストの件数");
        exClassificationEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCdLst().get(0), C_Ketkekkacd.BLNK,
            "（諾否決定）決定結果コードリスト[0]");
        exClassificationEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCdLst().get(1), C_Ketkekkacd.BLNK,
            "（諾否決定）決定結果コードリスト[1");
        exClassificationEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCdLst().get(2), C_Ketkekkacd.BLNK,
            "（諾否決定）決定結果コードリスト[2]");
        exClassificationEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCdLst().get(3), C_Ketkekkacd.BLNK,
            "（諾否決定）決定結果コードリスト[3]");
        exClassificationEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCdLst().get(4), C_Ketkekkacd.BLNK,
            "（諾否決定）決定結果コードリスト[4]");
        exClassificationEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCdLst().get(5), C_Ketkekkacd.BLNK,
            "（諾否決定）決定結果コードリスト[5]");
        exNumericEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetteiMdLst().size(), 6,
            "（諾否決定）決定月日リストの件数");
        exStringEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetteiMdLst().get(0), "0000",
            "（諾否決定）決定月日リスト[0]");
        exStringEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetteiMdLst().get(1), "0000",
            "（諾否決定）決定月日リスト[1]");
        exStringEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetteiMdLst().get(2), "0000",
            "（諾否決定）決定月日リスト[2]");
        exStringEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetteiMdLst().get(3), "0000",
            "（諾否決定）決定月日リスト[3]");
        exStringEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetteiMdLst().get(4), "0000",
            "（諾否決定）決定月日リスト[4]");
        exStringEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetteiMdLst().get(5), "0000",
            "（諾否決定）決定月日リスト[5]");
    }

    @Test
    @TestOrder(20)
    public void testEditDakuhiKetteiKanrenKoumoku_A2() {

        HT_SyoriCTL soriCTL = sinkeiyakuDomManager.getSyoriCTL("860000025");
        List<HT_DakuhiKettei> dakuhiKetteiLst = soriCTL.getDakuhiKetteis();

        editPalRenkeiKoumoku.editDakuhiKetteiKanrenKoumoku(dakuhiKetteiLst);

        exClassificationEquals(editPalRenkeiKoumoku.getSaisinKetkekkaCd(), C_Ketkekkacd.KYOUSEIHAND_KETTEI,
            "（最新）決定結果コード");
        exClassificationEquals(editPalRenkeiKoumoku.getSaisinTorikesiSyousaiRiyuuCd(), C_TorikesisyousairiyuuCd.HUMEI_MADOHAN,
            "（最新）取消詳細理由コード");
        exStringEquals(editPalRenkeiKoumoku.getSaisinPalKetsyaCd(), "01",
            "（最新）ＰＡＬ決定者コード");
        exClassificationEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCd(), C_Ketkekkacd.KYOUSEIHAND_KETTEI,
            "（諾否決定最新）決定結果コード");
        exDateEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetteiYmd(), BizDate.valueOf(20160101),
            "（諾否決定最新）決定日");
        exClassificationEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCd1(), C_Ketriyuucd.HHKN_TAIKAKU,
            "（諾否決定最新）決定理由コード１");
        exClassificationEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCd2(), C_Ketriyuucd.HHKN_GENSYOU,
            "（諾否決定最新）決定理由コード２");
        exClassificationEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCd3(), C_Ketriyuucd.HHKN_KIOUSYOU,
            "（諾否決定最新）決定理由コード３");
        exClassificationEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCd4(), C_Ketriyuucd.HHKN_NINSIN,
            "（諾否決定最新）決定理由コード４");
        exNumericEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCdLst().size(), 6,
            "（諾否決定）決定結果コードリストの件数");
        exClassificationEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCdLst().get(0), C_Ketkekkacd.KYOUSEIHAND_KETTEI,
            "（諾否決定）決定結果コードリスト[0]");
        exClassificationEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCdLst().get(1), C_Ketkekkacd.BLNK,
            "（諾否決定）決定結果コードリスト[1");
        exClassificationEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCdLst().get(2), C_Ketkekkacd.BLNK,
            "（諾否決定）決定結果コードリスト[2]");
        exClassificationEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCdLst().get(3), C_Ketkekkacd.BLNK,
            "（諾否決定）決定結果コードリスト[3]");
        exClassificationEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCdLst().get(4), C_Ketkekkacd.BLNK,
            "（諾否決定）決定結果コードリスト[4]");
        exClassificationEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCdLst().get(5), C_Ketkekkacd.BLNK,
            "（諾否決定）決定結果コードリスト[5]");
        exNumericEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetteiMdLst().size(), 6,
            "（諾否決定）決定月日リストの件数");
        exStringEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetteiMdLst().get(0), "0101",
            "（諾否決定）決定月日リスト[0]");
        exStringEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetteiMdLst().get(1), "0000",
            "（諾否決定）決定月日リスト[1]");
        exStringEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetteiMdLst().get(2), "0000",
            "（諾否決定）決定月日リスト[2]");
        exStringEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetteiMdLst().get(3), "0000",
            "（諾否決定）決定月日リスト[3]");
        exStringEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetteiMdLst().get(4), "0000",
            "（諾否決定）決定月日リスト[4]");
        exStringEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetteiMdLst().get(5), "0000",
            "（諾否決定）決定月日リスト[5]");
    }

    @Test
    @TestOrder(30)
    public void testEditDakuhiKetteiKanrenKoumoku_A3() {

        HT_SyoriCTL soriCTL = sinkeiyakuDomManager.getSyoriCTL("860000033");
        List<HT_DakuhiKettei> dakuhiKetteiLst = soriCTL.getDakuhiKetteis();

        editPalRenkeiKoumoku.editDakuhiKetteiKanrenKoumoku(dakuhiKetteiLst);

        exClassificationEquals(editPalRenkeiKoumoku.getSaisinKetkekkaCd(), C_Ketkekkacd.HAND_KETTEI,
            "（最新）決定結果コード");
        exClassificationEquals(editPalRenkeiKoumoku.getSaisinTorikesiSyousaiRiyuuCd(), C_TorikesisyousairiyuuCd.SYOUHINNAIYOU,
            "（最新）取消詳細理由コード");
        exStringEquals(editPalRenkeiKoumoku.getSaisinPalKetsyaCd(), "02",
            "（最新）ＰＡＬ決定者コード");
        exClassificationEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCd(), C_Ketkekkacd.BLNK,
            "（諾否決定最新）決定結果コード");
        exDateEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetteiYmd(), null, "（諾否決定最新）決定日");
        exClassificationEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCd1(), C_Ketriyuucd.BLNK,
            "（諾否決定最新）決定理由コード１");
        exClassificationEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCd2(), C_Ketriyuucd.BLNK,
            "（諾否決定最新）決定理由コード２");
        exClassificationEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCd3(), C_Ketriyuucd.BLNK,
            "（諾否決定最新）決定理由コード３");
        exClassificationEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCd4(), C_Ketriyuucd.BLNK,
            "（諾否決定最新）決定理由コード４");
        exNumericEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCdLst().size(), 6,
            "（諾否決定）決定結果コードリストの件数");
        exClassificationEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCdLst().get(0), C_Ketkekkacd.BLNK,
            "（諾否決定）決定結果コードリスト[0]");
        exClassificationEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCdLst().get(1), C_Ketkekkacd.BLNK,
            "（諾否決定）決定結果コードリスト[1");
        exClassificationEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCdLst().get(2), C_Ketkekkacd.BLNK,
            "（諾否決定）決定結果コードリスト[2]");
        exClassificationEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCdLst().get(3), C_Ketkekkacd.BLNK,
            "（諾否決定）決定結果コードリスト[3]");
        exClassificationEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCdLst().get(4), C_Ketkekkacd.BLNK,
            "（諾否決定）決定結果コードリスト[4]");
        exClassificationEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCdLst().get(5), C_Ketkekkacd.BLNK,
            "（諾否決定）決定結果コードリスト[5]");
        exNumericEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetteiMdLst().size(), 6,
            "（諾否決定）決定月日リストの件数");
        exStringEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetteiMdLst().get(0), "0000",
            "（諾否決定）決定月日リスト[0]");
        exStringEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetteiMdLst().get(1), "0000",
            "（諾否決定）決定月日リスト[1]");
        exStringEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetteiMdLst().get(2), "0000",
            "（諾否決定）決定月日リスト[2]");
        exStringEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetteiMdLst().get(3), "0000",
            "（諾否決定）決定月日リスト[3]");
        exStringEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetteiMdLst().get(4), "0000",
            "（諾否決定）決定月日リスト[4]");
        exStringEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetteiMdLst().get(5), "0000",
            "（諾否決定）決定月日リスト[5]");
    }

    @Test
    @TestOrder(40)
    public void testEditDakuhiKetteiKanrenKoumoku_A4() {

        HT_SyoriCTL soriCTL = sinkeiyakuDomManager.getSyoriCTL("860000041");
        List<HT_DakuhiKettei> dakuhiKetteiLst = soriCTL.getDakuhiKetteis();

        editPalRenkeiKoumoku.editDakuhiKetteiKanrenKoumoku(dakuhiKetteiLst);

        exClassificationEquals(editPalRenkeiKoumoku.getSaisinKetkekkaCd(), C_Ketkekkacd.MOS_TORIKESI,
            "（最新）決定結果コード");
        exClassificationEquals(editPalRenkeiKoumoku.getSaisinTorikesiSyousaiRiyuuCd(), C_TorikesisyousairiyuuCd.SYOUHINNAIYOU,
            "（最新）取消詳細理由コード");
        exStringEquals(editPalRenkeiKoumoku.getSaisinPalKetsyaCd(), "08",
            "（最新）ＰＡＬ決定者コード");
        exClassificationEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCd(), C_Ketkekkacd.MOS_TORIKESI,
            "（諾否決定最新）決定結果コード");
        exDateEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetteiYmd(), BizDate.valueOf(20160108),
            "（諾否決定最新）決定日");
        exClassificationEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCd1(), C_Ketriyuucd.HHKN_DOUTOKUHUAN,
            "（諾否決定最新）決定理由コード１");
        exClassificationEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCd2(), C_Ketriyuucd.HHKN_SYOKUGYOU,
            "（諾否決定最新）決定理由コード２");
        exClassificationEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCd3(), C_Ketriyuucd.HHKN_TOUSYAKYUUHUREKI,
            "（諾否決定最新）決定理由コード３");
        exClassificationEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCd4(), C_Ketriyuucd.KYK_DOUTOKUHUAN,
            "（諾否決定最新）決定理由コード４");
        exNumericEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCdLst().size(), 6,
            "（諾否決定）決定結果コードリストの件数");
        exClassificationEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCdLst().get(0), C_Ketkekkacd.ENKI_SUUNENGOSAISIN,
            "（諾否決定）決定結果コードリスト[0]");
        exClassificationEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCdLst().get(1), C_Ketkekkacd.ENKI_SIJINASI,
            "（諾否決定）決定結果コードリスト[1");
        exClassificationEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCdLst().get(2), C_Ketkekkacd.HUBI_MATI,
            "（諾否決定）決定結果コードリスト[2]");
        exClassificationEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCdLst().get(3), C_Ketkekkacd.SYOKAIPKOUHUNOU,
            "（諾否決定）決定結果コードリスト[3]");
        exClassificationEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCdLst().get(4), C_Ketkekkacd.YUUKOUKKNKKA,
            "（諾否決定）決定結果コードリスト[4]");
        exClassificationEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCdLst().get(5), C_Ketkekkacd.MOS_TORIKESI,
            "（諾否決定）決定結果コードリスト[5]");
        exNumericEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetteiMdLst().size(), 6,
            "（諾否決定）決定月日リストの件数");
        exStringEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetteiMdLst().get(0), "0103",
            "（諾否決定）決定月日リスト[0]");
        exStringEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetteiMdLst().get(1), "0104",
            "（諾否決定）決定月日リスト[1]");
        exStringEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetteiMdLst().get(2), "0105",
            "（諾否決定）決定月日リスト[2]");
        exStringEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetteiMdLst().get(3), "0106",
            "（諾否決定）決定月日リスト[3]");
        exStringEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetteiMdLst().get(4), "0107",
            "（諾否決定）決定月日リスト[4]");
        exStringEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetteiMdLst().get(5), "0108",
            "（諾否決定）決定月日リスト[5]");
    }

    @Test
    @TestOrder(50)
    public void testEditDakuhiKetteiKanrenKoumoku_A5() {

        HT_SyoriCTL soriCTL = sinkeiyakuDomManager.getSyoriCTL("860000058");
        List<HT_DakuhiKettei> dakuhiKetteiLst = soriCTL.getDakuhiKetteis();

        editPalRenkeiKoumoku.editDakuhiKetteiKanrenKoumoku(dakuhiKetteiLst);

        exClassificationEquals(editPalRenkeiKoumoku.getSaisinKetkekkaCd(), C_Ketkekkacd.GENKAITAI_SYOUDAKU,
            "（最新）決定結果コード");
        exClassificationEquals(editPalRenkeiKoumoku.getSaisinTorikesiSyousaiRiyuuCd(), C_TorikesisyousairiyuuCd.SIKIN,
            "（最新）取消詳細理由コード");
        exStringEquals(editPalRenkeiKoumoku.getSaisinPalKetsyaCd(), "15",
            "（最新）ＰＡＬ決定者コード");
        exClassificationEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCd(), C_Ketkekkacd.GENKAITAI_SYOUDAKU,
            "（諾否決定最新）決定結果コード");
        exDateEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetteiYmd(), BizDate.valueOf(20160115),
            "（諾否決定最新）決定日");
        exClassificationEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCd1(), C_Ketriyuucd.HHKN_DOUTOKUHUAN,
            "（諾否決定最新）決定理由コード１");
        exClassificationEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCd2(), C_Ketriyuucd.HHKN_SYOKUGYOU,
            "（諾否決定最新）決定理由コード２");
        exClassificationEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCd3(), C_Ketriyuucd.HHKN_TOUSYAKYUUHUREKI,
            "（諾否決定最新）決定理由コード３");
        exClassificationEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCd4(), C_Ketriyuucd.KYK_DOUTOKUHUAN,
            "（諾否決定最新）決定理由コード４");
        exNumericEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCdLst().size(), 6,
            "（諾否決定）決定結果コードリストの件数");
        exClassificationEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCdLst().get(0), C_Ketkekkacd.COOLINGOFF,
            "（諾否決定）決定結果コードリスト[0]");
        exClassificationEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCdLst().get(1), C_Ketkekkacd.MIAWASE,
            "（諾否決定）決定結果コードリスト[1");
        exClassificationEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCdLst().get(2), C_Ketkekkacd.ENKI_SIJINASI,
            "（諾否決定）決定結果コードリスト[2]");
        exClassificationEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCdLst().get(3), C_Ketkekkacd.TKJY_JYOUKENTUKI_HEI,
            "（諾否決定）決定結果コードリスト[3]");
        exClassificationEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCdLst().get(4), C_Ketkekkacd.TOKUBETUJYOUKEN,
            "（諾否決定）決定結果コードリスト[4]");
        exClassificationEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetKekkaCdLst().get(5), C_Ketkekkacd.JYOUKENTUKI,
            "（諾否決定）決定結果コードリスト[5]");

        exNumericEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetteiMdLst().size(), 6,
            "（諾否決定）決定月日リストの件数");
        exStringEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetteiMdLst().get(0), "0109",
            "（諾否決定）決定月日リスト[0]");
        exStringEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetteiMdLst().get(1), "0110",
            "（諾否決定）決定月日リスト[1]");
        exStringEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetteiMdLst().get(2), "0111",
            "（諾否決定）決定月日リスト[2]");
        exStringEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetteiMdLst().get(3), "0112",
            "（諾否決定）決定月日リスト[3]");
        exStringEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetteiMdLst().get(4), "0113",
            "（諾否決定）決定月日リスト[4]");
        exStringEquals(editPalRenkeiKoumoku.getDakuhiKetSaisinKetteiMdLst().get(5), "0114",
            "（諾否決定）決定月日リスト[5]");
    }
}