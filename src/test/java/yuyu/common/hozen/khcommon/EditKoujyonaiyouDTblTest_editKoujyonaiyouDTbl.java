package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.number.BizCurrency;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.classification.C_Delflag;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HaitoukinsksKbn;
import yuyu.def.classification.C_HaitoumeisaiKbn;
import yuyu.def.classification.C_Kjsmhakkouzumiflg;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KhHaitouKanri;
import yuyu.def.db.entity.IT_KoujyoSymNaiyouD;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.TestOrder;

/**
 * 控除証明内容ＤＴＢＬ編集クラスの控除証明内容ＤＴＢＬ編集メソッド {@link EditKoujyonaiyouDTbl#editTBL(
 * KhozenCommonParam,KoujyonaiyouDTBLSksParam)} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class EditKoujyonaiyouDTblTest_editKoujyonaiyouDTbl extends AbstractTest{

    @Inject
    EditKoujyonaiyouDTbl editKoujyonaiyouDTbl;

    @Inject
    private HozenDomManager hozenDomManager;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_控除証明内容ＤＴＢＬ編集";
    private final static String sheetName = "INデータ";

    private static HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            testDataAndTblMap = testDataMaker.getInData(
                EditKoujyonaiyouDTblTest_editKoujyonaiyouDTbl.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void testEditKoujyonaiyouDTbl_A1() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditKoujyonaiyouDTbl");

        KoujyonaiyouDTBLSksParam koujyonaiyouDTBLSksParam = SWAKInjector.getInstance(KoujyonaiyouDTBLSksParam.class);

        IT_KykSyouhn kykSyouhn = SWAKInjector.getInstance(IT_KykSyouhn.class);
        kykSyouhn.setSyono("17806000208");
        kykSyouhn.setSyouhncd("0011");

        IT_KhHaitouKanri khHaitouKanri = SWAKInjector.getInstance(IT_KhHaitouKanri.class);
        khHaitouKanri.setKariwariatedshrymd(BizDate.valueOf(20200101));
        khHaitouKanri.setKariwariatedshrgk(BizCurrency.valueOf(0));
        khHaitouKanri.setHaitounendo(BizDateY.valueOf(2020));
        khHaitouKanri.setRenno(10);
        khHaitouKanri.setHaitoukinskskbn(C_HaitoukinsksKbn.KARIWARIATE1);
        khHaitouKanri.setHaitoumeisaikbn(C_HaitoumeisaiKbn.SYU);

        koujyonaiyouDTBLSksParam.setKykSyouhn(kykSyouhn);
        koujyonaiyouDTBLSksParam.setKhHaitouKanri(khHaitouKanri);
        koujyonaiyouDTBLSksParam.setZeiseiTkkktkykhukaUmu(C_UmuKbn.NONE);

        C_ErrorKbn errorKbn = editKoujyonaiyouDTbl.editTBL(khozenCommonParam, koujyonaiyouDTBLSksParam);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000208");

        List<IT_KoujyoSymNaiyouD> koujyoSymNaiyouDList = kykKihon.getKoujyoSymNaiyouDs();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exNumericEquals(koujyoSymNaiyouDList.size(), 3, "控除証明内容Dテーブルリストのサイズ");
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testEditKoujyonaiyouDTbl_A2() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditKoujyonaiyouDTbl");

        KoujyonaiyouDTBLSksParam koujyonaiyouDTBLSksParam = SWAKInjector.getInstance(KoujyonaiyouDTBLSksParam.class);

        IT_KykSyouhn kykSyouhn = SWAKInjector.getInstance(IT_KykSyouhn.class);
        kykSyouhn.setSyono("17806000208");
        kykSyouhn.setSyouhncd("0011");

        IT_KhHaitouKanri khHaitouKanri = SWAKInjector.getInstance(IT_KhHaitouKanri.class);
        khHaitouKanri.setKariwariatedshrymd(BizDate.valueOf(20200101));
        khHaitouKanri.setKariwariatedshrgk(BizCurrency.valueOf(1));
        khHaitouKanri.setHaitounendo(BizDateY.valueOf(2020));
        khHaitouKanri.setRenno(10);
        khHaitouKanri.setHaitoukinskskbn(C_HaitoukinsksKbn.KARIWARIATE1);
        khHaitouKanri.setHaitoumeisaikbn(C_HaitoumeisaiKbn.SYU);

        koujyonaiyouDTBLSksParam.setKykSyouhn(kykSyouhn);
        koujyonaiyouDTBLSksParam.setKhHaitouKanri(khHaitouKanri);
        koujyonaiyouDTBLSksParam.setZeiseiTkkktkykhukaUmu(C_UmuKbn.ARI);

        C_ErrorKbn errorKbn = editKoujyonaiyouDTbl.editTBL(khozenCommonParam, koujyonaiyouDTBLSksParam);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000208");

        List<IT_KoujyoSymNaiyouD> koujyoSymNaiyouDList = kykKihon.getKoujyoSymNaiyouDs();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exNumericEquals(koujyoSymNaiyouDList.size(), 3, "控除証明内容Dテーブルリストのサイズ");
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testEditKoujyonaiyouDTbl_A3() {

        changeSystemDate(BizDate.valueOf(20201111));

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditKoujyonaiyouDTbl");

        KoujyonaiyouDTBLSksParam koujyonaiyouDTBLSksParam = SWAKInjector.getInstance(KoujyonaiyouDTBLSksParam.class);

        IT_KykSyouhn kykSyouhn = SWAKInjector.getInstance(IT_KykSyouhn.class);
        kykSyouhn.setSyono("17806000286");
        kykSyouhn.setSyouhncd("0088");

        IT_KhHaitouKanri khHaitouKanri = SWAKInjector.getInstance(IT_KhHaitouKanri.class);
        khHaitouKanri.setKariwariatedshrymd(BizDate.valueOf(20200101));
        khHaitouKanri.setKariwariatedshrgk(BizCurrency.valueOf(1));
        khHaitouKanri.setHaitounendo(BizDateY.valueOf(2019));
        khHaitouKanri.setRenno(10);
        khHaitouKanri.setHaitoukinskskbn(C_HaitoukinsksKbn.KARIWARIATE1);
        khHaitouKanri.setHaitoumeisaikbn(C_HaitoumeisaiKbn.SYU);

        koujyonaiyouDTBLSksParam.setKykSyouhn(kykSyouhn);
        koujyonaiyouDTBLSksParam.setKhHaitouKanri(khHaitouKanri);
        koujyonaiyouDTBLSksParam.setZeiseiTkkktkykhukaUmu(C_UmuKbn.NONE);

        C_ErrorKbn errorKbn = editKoujyonaiyouDTbl.editTBL(khozenCommonParam, koujyonaiyouDTBLSksParam);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000286");

        List<IT_KoujyoSymNaiyouD> koujyoSymNaiyouDList = kykKihon.getKoujyoSymNaiyouDs();
        IT_KoujyoSymNaiyouD koujyoSymNaiyouD = koujyoSymNaiyouDList.get(0);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exNumericEquals(koujyoSymNaiyouDList.size(), 1, "控除証明内容Dテーブルリストのサイズ");
        exStringEquals(koujyoSymNaiyouD.getSyono(), "17806000286", "証券番号");
        exStringEquals(koujyoSymNaiyouD.getSyouhncd(), "0088", "商品コード");
        exNumericEquals(koujyoSymNaiyouD.getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouD.getKoujyosyoumeinnd(), "2020", "控除証明年度");
        exBizCalcbleEquals(koujyoSymNaiyouD.getKoujyosyoumeid(), BizCurrency.valueOf(1), "控除証明Ｄ");
        exDateYEquals(koujyoSymNaiyouD.getHaitounendo(), BizDateY.valueOf(2019), "配当年度");
        exNumericEquals(koujyoSymNaiyouD.getHaitoukanrirenno(), 10, "配当管理連番");
        exClassificationEquals(koujyoSymNaiyouD.getHaitoukinskskbn(), C_HaitoukinsksKbn.KARIWARIATE1, "配当金作成区分");
        exClassificationEquals(koujyoSymNaiyouD.getHaitoumeisaikbn(), C_HaitoumeisaiKbn.SYU, "配当明細区分");
        exClassificationEquals(koujyoSymNaiyouD.getKjsmhakkouzumiflg(), C_Kjsmhakkouzumiflg.BLNK, "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouD.getSakujyoflg(), C_Delflag.BLNK, "削除フラグ");
        exStringEquals(koujyoSymNaiyouD.getGyoumuKousinKinou(), "EditKoujyonaiyouDTbl", "業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouD.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exStringEquals(koujyoSymNaiyouD.getGyoumuKousinTime().substring(0,8), "20201111", "業務用更新時間");
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testEditKoujyonaiyouDTbl_A4() {

        changeSystemDate(BizDate.valueOf(20201111));

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditKoujyonaiyouDTbl");

        KoujyonaiyouDTBLSksParam koujyonaiyouDTBLSksParam = SWAKInjector.getInstance(KoujyonaiyouDTBLSksParam.class);

        IT_KykSyouhn kykSyouhn = SWAKInjector.getInstance(IT_KykSyouhn.class);
        kykSyouhn.setSyono("17806000208");
        kykSyouhn.setSyouhncd("0011");

        IT_KhHaitouKanri khHaitouKanri = SWAKInjector.getInstance(IT_KhHaitouKanri.class);
        khHaitouKanri.setKariwariatedshrymd(BizDate.valueOf(20200101));
        khHaitouKanri.setKariwariatedshrgk(BizCurrency.valueOf(1234567890123l));
        khHaitouKanri.setHaitounendo(BizDateY.valueOf(2019));
        khHaitouKanri.setRenno(99);
        khHaitouKanri.setHaitoukinskskbn(C_HaitoukinsksKbn.YENDTHNKSEISIKI);
        khHaitouKanri.setHaitoumeisaikbn(C_HaitoumeisaiKbn.SYU);

        koujyonaiyouDTBLSksParam.setKykSyouhn(kykSyouhn);
        koujyonaiyouDTBLSksParam.setKhHaitouKanri(khHaitouKanri);
        koujyonaiyouDTBLSksParam.setZeiseiTkkktkykhukaUmu(C_UmuKbn.NONE);

        C_ErrorKbn errorKbn = editKoujyonaiyouDTbl.editTBL(khozenCommonParam, koujyonaiyouDTBLSksParam);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000208");

        List<IT_KoujyoSymNaiyouD> koujyoSymNaiyouDList = kykKihon.getKoujyoSymNaiyouDs();
        IT_KoujyoSymNaiyouD koujyoSymNaiyouD = koujyoSymNaiyouDList.get(3);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exNumericEquals(koujyoSymNaiyouDList.size(), 4, "控除証明内容Dテーブルリストのサイズ");
        exStringEquals(koujyoSymNaiyouD.getSyono(), "17806000208", "証券番号");
        exStringEquals(koujyoSymNaiyouD.getSyouhncd(), "0011", "商品コード");
        exNumericEquals(koujyoSymNaiyouD.getRenno3keta(), 999, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouD.getKoujyosyoumeinnd(), "2020", "控除証明年度");
        exBizCalcbleEquals(koujyoSymNaiyouD.getKoujyosyoumeid(), BizCurrency.valueOf(1234567890123l), "控除証明Ｄ");
        exDateYEquals(koujyoSymNaiyouD.getHaitounendo(), BizDateY.valueOf(2019), "配当年度");
        exNumericEquals(koujyoSymNaiyouD.getHaitoukanrirenno(), 99, "配当管理連番");
        exClassificationEquals(koujyoSymNaiyouD.getHaitoukinskskbn(), C_HaitoukinsksKbn.YENDTHNKSEISIKI, "配当金作成区分");
        exClassificationEquals(koujyoSymNaiyouD.getHaitoumeisaikbn(), C_HaitoumeisaiKbn.SYU, "配当明細区分");
        exClassificationEquals(koujyoSymNaiyouD.getKjsmhakkouzumiflg(), C_Kjsmhakkouzumiflg.BLNK, "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouD.getSakujyoflg(), C_Delflag.BLNK, "削除フラグ");
        exStringEquals(koujyoSymNaiyouD.getGyoumuKousinKinou(), "EditKoujyonaiyouDTbl", "業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouD.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exStringEquals(koujyoSymNaiyouD.getGyoumuKousinTime().substring(0,8), "20201111", "業務用更新時間");
    }
}
