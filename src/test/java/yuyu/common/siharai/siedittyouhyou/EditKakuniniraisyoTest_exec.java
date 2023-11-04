package yuyu.common.siharai.siedittyouhyou;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.siharai.bean.report.SiEditKakuniniraisyoBean;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 確認依頼書編集のメソッド{@link EditKakuniniraisyo#exec(EditKakuniniraisyoBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditKakuniniraisyoTest_exec {

    @Inject
    private EditKakuniniraisyo editKakuniniraisyo;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_確認依頼書編集";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditKakuniniraisyoTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        baseDomManager.delete(baseDomManager.getSyoruiZokusei(C_SyoruiCdKbn.HK_SB_KAKUNINIRAIS));
        baseDomManager.delete(baseDomManager.getSyoruiZokusei(C_SyoruiCdKbn.HK_SB_KAKUNINHKS));
        baseDomManager.delete(baseDomManager.getSyoruiZokusei(C_SyoruiCdKbn.HK_SOUHU));

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        siharaiDomManager.delete(siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2("hk401", "TITLE_SB"));
        siharaiDomManager.delete(siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2("hk411", "TITLE_KD"));
        siharaiDomManager.delete(siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2("hk090", "TITLE_KD"));
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        EditKakuniniraisyoBean editKakuniniraisyoBean = SWAKInjector.getInstance(EditKakuniniraisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(null);
        editKakuniniraisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        try {
            editKakuniniraisyo.exec(editKakuniniraisyoBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='syoriymd'", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        EditKakuniniraisyoBean editKakuniniraisyoBean = SWAKInjector.getInstance(EditKakuniniraisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean =
            SWAKInjector.getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151218));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(null);
        editKakuniniraisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

        try {
            editKakuniniraisyo.exec(editKakuniniraisyoBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='syoruiCd'", "エラーメッセージ");
        }

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        EditKakuniniraisyoBean editKakuniniraisyoBean = SWAKInjector.getInstance(EditKakuniniraisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean =
            SWAKInjector.getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151218));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.BLNK);
        editKakuniniraisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

        try {
            editKakuniniraisyo.exec(editKakuniniraisyoBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='syoruiCd'", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {
        EditKakuniniraisyoBean editKakuniniraisyoBean = SWAKInjector.getInstance(EditKakuniniraisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean =
            SWAKInjector.getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151218));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SB_KAKUNINIRAIS);
        editKakuniniraisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        editKakuniniraisyoBean.setSeikyuusyubetu(null);

        try {
            editKakuniniraisyo.exec(editKakuniniraisyoBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='seikyuuSyubetu'", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {
        EditKakuniniraisyoBean editKakuniniraisyoBean = SWAKInjector.getInstance(EditKakuniniraisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean =
            SWAKInjector.getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151218));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SB_KAKUNINIRAIS);
        editKakuniniraisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        editKakuniniraisyoBean.setSeikyuusyubetu(C_SeikyuuSyubetu.BLNK);

        try {
            editKakuniniraisyo.exec(editKakuniniraisyoBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='seikyuuSyubetu'", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {
        EditKakuniniraisyoBean editKakuniniraisyoBean = SWAKInjector.getInstance(EditKakuniniraisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean =
            SWAKInjector.getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151218));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SB_KAKUNINIRAIS);
        editKakuniniraisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        editKakuniniraisyoBean.setSeikyuusyubetu(C_SeikyuuSyubetu.SB);
        editKakuniniraisyoBean.setSeikyuusyaInfoBean(null);

        try {
            editKakuniniraisyo.exec(editKakuniniraisyoBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='seikyuusyaInfoBean'", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testExec_B1() {
        EditKakuniniraisyoBean editKakuniniraisyoBean = SWAKInjector.getInstance(EditKakuniniraisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151214));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SB_KAKUNINIRAIS);
        editKakuniniraisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

        editKakuniniraisyoBean.setSeikyuusyubetu(C_SeikyuuSyubetu.SB);
        editKakuniniraisyoBean.setSyono("17806000080");
        editKakuniniraisyoBean.setKykYmd(BizDate.valueOf(20111011));
        editKakuniniraisyoBean.setSibouYmd(BizDate.valueOf(20151120));
        editKakuniniraisyoBean.setSyoruiukeYmd(BizDate.valueOf(20150506));
        editKakuniniraisyoBean.setSikkouYmd(BizDate.valueOf(20161011));
        editKakuniniraisyoBean.setHksknnkaisiYmd(BizDate.valueOf(20111013));
        editKakuniniraisyoBean.setLastmeihenYmd(BizDate.valueOf(20150501));
        editKakuniniraisyoBean.setHhknNmkn("加藤");
        editKakuniniraisyoBean.setHhknNmkj("菓子");
        editKakuniniraisyoBean.setKyknmkn("氏楽");
        editKakuniniraisyoBean.setKyknmkj("有馬");
        editKakuniniraisyoBean.setHokenknGk(BizCurrency.valueOf(100000));
        editKakuniniraisyoBean.setHyojitelno("010-1123-4567");
        editKakuniniraisyoBean.setSaigais(BizCurrency.valueOf(0));

        SeikyuusyaInfoBean seikyuusyaInfoBean = SWAKInjector.getInstance(SeikyuusyaInfoBean.class);
        seikyuusyaInfoBean.setSeikyuusyanmKn("根城");
        seikyuusyaInfoBean.setSeikyuusyanmKj("加奈");
        seikyuusyaInfoBean.setTsinyno("0101234");
        seikyuusyaInfoBean.setTsinadr1kj("京都");
        seikyuusyaInfoBean.setTsinadr2kj("戸京");
        seikyuusyaInfoBean.setTsinadr3kj("加奈機");
        seikyuusyaInfoBean.setTsintelno("010-1234-5678");
        editKakuniniraisyoBean.setSeikyuusyaInfoBean(seikyuusyaInfoBean);

        ReportServicesBean reportServicesBean = editKakuniniraisyo.exec(editKakuniniraisyoBean);
        exStringEquals(reportServicesBean.getKensakuKeys()[0], "17806000080", "検索キー[0]");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf(20151214), "処理日付");

        SiEditKakuniniraisyoBean siEditKakuniniraisyoBean = (SiEditKakuniniraisyoBean) (reportServicesBean
            .getParamObjectsData()
            .get(C_SyoruiCdKbn.HK_SB_KAKUNINIRAIS.getValue()))[0];

        exStringEquals(siEditKakuniniraisyoBean.getIrTyouhyoutitle(), "死亡　保険金確認依頼書", "（ＩＲ）帳票タイトル");
        exStringEquals(siEditKakuniniraisyoBean.getIrIraisyohyojitelno(), "010-1123-4567", "（ＩＲ）確認依頼書表示電話番号");
        exStringEquals(siEditKakuniniraisyoBean.getIrSyono(), "17806000080", "（ＩＲ）証券番号");
        exStringEquals(siEditKakuniniraisyoBean.getIrKykymd(), "２０１１年１０月１１日", "（ＩＲ）契約日");
        exStringEquals(siEditKakuniniraisyoBean.getIrSbymdkoteiymd(), "２０１５年１１月２０日", "（ＩＲ）死亡日または固定日");
        exStringEquals(siEditKakuniniraisyoBean.getIrSyoruiukeymd(), "２０１５年 ５月 ６日", "（ＩＲ）書類受付日");
        exStringEquals(siEditKakuniniraisyoBean.getIrSikkouymd(), "２０１６年１０月１１日", "（ＩＲ）失効日");
        exStringEquals(siEditKakuniniraisyoBean.getIrHksknnkaisiymd(), "２０１１年１０月１３日", "（ＩＲ）復活責任開始日");
        exStringEquals(siEditKakuniniraisyoBean.getIrLastmeihenymd(), "２０１５年 ５月 １日", "（ＩＲ）最終名義変更日");
        exStringEquals(siEditKakuniniraisyoBean.getIrHhknnmkn(), "加藤", "（ＩＲ）被保険者名（カナ）");
        exStringEquals(siEditKakuniniraisyoBean.getIrHhknnmkj(), "菓子", "（ＩＲ）被保険者名（漢字）");
        exStringEquals(siEditKakuniniraisyoBean.getIrKyknmkn(), "氏楽", "（ＩＲ）契約者名（カナ）");
        exStringEquals(siEditKakuniniraisyoBean.getIrKyknmkj(), "有馬", "（ＩＲ）契約者名（漢字）");
        exStringEquals(siEditKakuniniraisyoBean.getIrSeikyuusyanmkn(), "根城", "（ＩＲ）請求者（カナ）");
        exStringEquals(siEditKakuniniraisyoBean.getIrSeikyuusyanmkj(), "加奈", "（ＩＲ）請求者（漢字）");
        exStringEquals(siEditKakuniniraisyoBean.getIrTsinyno(), "0101234", "（ＩＲ）通信先郵便番号");
        exStringEquals(siEditKakuniniraisyoBean.getIrTsintelno(), "010-1234-5678", "（ＩＲ）通信先電話番号");
        exStringEquals(siEditKakuniniraisyoBean.getIrTsinadr1kj(), "京都戸京加奈機", "（ＩＲ）通信先住所１（漢字）");
        exStringEquals(siEditKakuniniraisyoBean.getIrTsinadr2kj(), null, "（ＩＲ）通信先住所２（漢字）");
        exStringEquals(siEditKakuniniraisyoBean.getIrTsinadr3kj(), null, "（ＩＲ）通信先住所３（漢字）");
        exStringEquals(siEditKakuniniraisyoBean.getIrHkgk(), "100,000", "保険金額");
        exStringEquals(siEditKakuniniraisyoBean.getIrHozonkkn(), "5", "（ＩＲ）保存期間");

    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testExec_B2() {
        EditKakuniniraisyoBean editKakuniniraisyoBean = SWAKInjector.getInstance(EditKakuniniraisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151214));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SB_KAKUNINHKS);
        editKakuniniraisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

        editKakuniniraisyoBean.setSeikyuusyubetu(C_SeikyuuSyubetu.KOUSG);
        editKakuniniraisyoBean.setSyono("17806000080");
        editKakuniniraisyoBean.setKykYmd(BizDate.valueOf(20111011));
        editKakuniniraisyoBean.setSibouYmd(null);
        editKakuniniraisyoBean.setSyoruiukeYmd(BizDate.valueOf(20150506));
        editKakuniniraisyoBean.setSikkouYmd(BizDate.valueOf(20161011));
        editKakuniniraisyoBean.setHksknnkaisiYmd(BizDate.valueOf(20111013));
        editKakuniniraisyoBean.setLastmeihenYmd(BizDate.valueOf(20150501));
        editKakuniniraisyoBean.setHhknNmkn("加藤");
        editKakuniniraisyoBean.setHhknNmkj("菓子");
        editKakuniniraisyoBean.setKyknmkn("氏楽");
        editKakuniniraisyoBean.setKyknmkj("有馬");
        editKakuniniraisyoBean.setHokenknGk(BizCurrency.valueOf(100000));
        editKakuniniraisyoBean.setHyojitelno("010-1123-4567");
        editKakuniniraisyoBean.setSaigais(BizCurrency.valueOf(0));

        SeikyuusyaInfoBean seikyuusyaInfoBean = SWAKInjector.getInstance(SeikyuusyaInfoBean.class);
        seikyuusyaInfoBean.setSeikyuusyanmKn("根城");
        seikyuusyaInfoBean.setSeikyuusyanmKj("加奈");
        seikyuusyaInfoBean.setTsinyno("0101234");
        seikyuusyaInfoBean.setTsinadr1kj("京都");
        seikyuusyaInfoBean.setTsinadr2kj("戸京");
        seikyuusyaInfoBean.setTsinadr3kj("加奈機");
        seikyuusyaInfoBean.setTsintelno("010-1234-5678");
        editKakuniniraisyoBean.setSeikyuusyaInfoBean(seikyuusyaInfoBean);

        ReportServicesBean reportServicesBean = editKakuniniraisyo.exec(editKakuniniraisyoBean);
        exStringEquals(reportServicesBean.getKensakuKeys()[0], "17806000080", "検索キー[0]");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf(20151214), "処理日付");

        SiEditKakuniniraisyoBean siEditKakuniniraisyoBean = (SiEditKakuniniraisyoBean) (reportServicesBean
            .getParamObjectsData()
            .get(C_SyoruiCdKbn.HK_SB_KAKUNINHKS.getValue()))[0];

        exStringEquals(siEditKakuniniraisyoBean.getIrTyouhyoutitle(), "", "（ＩＲ）帳票タイトル");
        exStringEquals(siEditKakuniniraisyoBean.getIrIraisyohyojitelno(), "010-1123-4567", "（ＩＲ）確認依頼書表示電話番号");
        exStringEquals(siEditKakuniniraisyoBean.getIrSyono(), "17806000080", "（ＩＲ）証券番号");
        exStringEquals(siEditKakuniniraisyoBean.getIrKykymd(), "２０１１年１０月１１日", "（ＩＲ）契約日");
        exStringEquals(siEditKakuniniraisyoBean.getIrSbymdkoteiymd(), null, "（ＩＲ）死亡日または固定日");
        exStringEquals(siEditKakuniniraisyoBean.getIrSyoruiukeymd(), "２０１５年 ５月 ６日", "（ＩＲ）書類受付日");
        exStringEquals(siEditKakuniniraisyoBean.getIrSikkouymd(), "２０１６年１０月１１日", "（ＩＲ）失効日");
        exStringEquals(siEditKakuniniraisyoBean.getIrHksknnkaisiymd(), "２０１１年１０月１３日", "（ＩＲ）復活責任開始日");
        exStringEquals(siEditKakuniniraisyoBean.getIrLastmeihenymd(), "２０１５年 ５月 １日", "（ＩＲ）最終名義変更日");
        exStringEquals(siEditKakuniniraisyoBean.getIrHhknnmkn(), "加藤", "（ＩＲ）被保険者名（カナ）");
        exStringEquals(siEditKakuniniraisyoBean.getIrHhknnmkj(), "菓子", "（ＩＲ）被保険者名（漢字）");
        exStringEquals(siEditKakuniniraisyoBean.getIrKyknmkn(), "氏楽", "（ＩＲ）契約者名（カナ）");
        exStringEquals(siEditKakuniniraisyoBean.getIrKyknmkj(), "有馬", "（ＩＲ）契約者名（漢字）");
        exStringEquals(siEditKakuniniraisyoBean.getIrSeikyuusyanmkn(), "根城", "（ＩＲ）請求者（カナ）");
        exStringEquals(siEditKakuniniraisyoBean.getIrSeikyuusyanmkj(), "加奈", "（ＩＲ）請求者（漢字）");
        exStringEquals(siEditKakuniniraisyoBean.getIrTsinyno(), "0101234", "（ＩＲ）通信先郵便番号");
        exStringEquals(siEditKakuniniraisyoBean.getIrTsintelno(), "010-1234-5678", "（ＩＲ）通信先電話番号");
        exStringEquals(siEditKakuniniraisyoBean.getIrTsinadr1kj(), "京都戸京加奈機", "（ＩＲ）通信先住所１（漢字）");
        exStringEquals(siEditKakuniniraisyoBean.getIrTsinadr2kj(), null, "（ＩＲ）通信先住所２（漢字）");
        exStringEquals(siEditKakuniniraisyoBean.getIrTsinadr3kj(), null, "（ＩＲ）通信先住所３（漢字）");
        exStringEquals(siEditKakuniniraisyoBean.getIrHkgk(), "100,000", "（ＩＲ）保険金額");
        exStringEquals(siEditKakuniniraisyoBean.getIrHozonkkn(), "5", "（ＩＲ）保存期間");

    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testExec_B3() {
        EditKakuniniraisyoBean editKakuniniraisyoBean = SWAKInjector.getInstance(EditKakuniniraisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151214));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SOUHU);
        editKakuniniraisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

        editKakuniniraisyoBean.setSeikyuusyubetu(C_SeikyuuSyubetu.PM);
        editKakuniniraisyoBean.setSyono("17806000080");
        editKakuniniraisyoBean.setKykYmd(BizDate.valueOf(20111011));
        editKakuniniraisyoBean.setSibouYmd(null);
        editKakuniniraisyoBean.setSyoruiukeYmd(BizDate.valueOf(20150506));
        editKakuniniraisyoBean.setSikkouYmd(null);
        editKakuniniraisyoBean.setHksknnkaisiYmd(BizDate.valueOf(20111013));
        editKakuniniraisyoBean.setLastmeihenYmd(BizDate.valueOf(20150501));
        editKakuniniraisyoBean.setHhknNmkn("加藤");
        editKakuniniraisyoBean.setHhknNmkj("菓子");
        editKakuniniraisyoBean.setKyknmkn("氏楽");
        editKakuniniraisyoBean.setKyknmkj("有馬");
        editKakuniniraisyoBean.setHokenknGk(BizCurrency.valueOf(100000));
        editKakuniniraisyoBean.setHyojitelno("010-1123-4567");
        editKakuniniraisyoBean.setSaigais(BizCurrency.valueOf(0));

        SeikyuusyaInfoBean seikyuusyaInfoBean = SWAKInjector.getInstance(SeikyuusyaInfoBean.class);
        seikyuusyaInfoBean.setSeikyuusyanmKn("根城");
        seikyuusyaInfoBean.setSeikyuusyanmKj("加奈");
        seikyuusyaInfoBean.setTsinyno("0101234");
        seikyuusyaInfoBean.setTsinadr1kj("京都");
        seikyuusyaInfoBean.setTsinadr2kj("戸京");
        seikyuusyaInfoBean.setTsinadr3kj("加奈機");
        seikyuusyaInfoBean.setTsintelno("010-1234-5678");
        editKakuniniraisyoBean.setSeikyuusyaInfoBean(seikyuusyaInfoBean);

        ReportServicesBean reportServicesBean = editKakuniniraisyo.exec(editKakuniniraisyoBean);
        exStringEquals(reportServicesBean.getKensakuKeys()[0], "17806000080", "検索キー[0]");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf(20151214), "処理日付");

        SiEditKakuniniraisyoBean siEditKakuniniraisyoBean = (SiEditKakuniniraisyoBean) (reportServicesBean
            .getParamObjectsData().get(C_SyoruiCdKbn.HK_SOUHU.getValue()))[0];

        exStringEquals(siEditKakuniniraisyoBean.getIrTyouhyoutitle(), "", "（ＩＲ）帳票タイトル");
        exStringEquals(siEditKakuniniraisyoBean.getIrIraisyohyojitelno(), "010-1123-4567", "（ＩＲ）確認依頼書表示電話番号");
        exStringEquals(siEditKakuniniraisyoBean.getIrSyono(), "17806000080", "（ＩＲ）証券番号");
        exStringEquals(siEditKakuniniraisyoBean.getIrKykymd(), "２０１１年１０月１１日", "（ＩＲ）契約日");
        exStringEquals(siEditKakuniniraisyoBean.getIrSbymdkoteiymd(), null, "（ＩＲ）死亡日または固定日");
        exStringEquals(siEditKakuniniraisyoBean.getIrSyoruiukeymd(), "２０１５年 ５月 ６日", "（ＩＲ）書類受付日");
        exStringEquals(siEditKakuniniraisyoBean.getIrSikkouymd(), null, "（ＩＲ）失効日");
        exStringEquals(siEditKakuniniraisyoBean.getIrHksknnkaisiymd(), "２０１１年１０月１３日", "（ＩＲ）復活責任開始日");
        exStringEquals(siEditKakuniniraisyoBean.getIrLastmeihenymd(), "２０１５年 ５月 １日", "（ＩＲ）最終名義変更日");
        exStringEquals(siEditKakuniniraisyoBean.getIrHhknnmkn(), "加藤", "（ＩＲ）被保険者名（カナ）");
        exStringEquals(siEditKakuniniraisyoBean.getIrHhknnmkj(), "菓子", "（ＩＲ）被保険者名（漢字）");
        exStringEquals(siEditKakuniniraisyoBean.getIrKyknmkn(), "氏楽", "（ＩＲ）契約者名（カナ）");
        exStringEquals(siEditKakuniniraisyoBean.getIrKyknmkj(), "有馬", "（ＩＲ）契約者名（漢字）");
        exStringEquals(siEditKakuniniraisyoBean.getIrSeikyuusyanmkn(), "根城", "（ＩＲ）請求者（カナ）");
        exStringEquals(siEditKakuniniraisyoBean.getIrSeikyuusyanmkj(), "加奈", "（ＩＲ）請求者（漢字）");
        exStringEquals(siEditKakuniniraisyoBean.getIrTsinyno(), "0101234", "（ＩＲ）通信先郵便番号");
        exStringEquals(siEditKakuniniraisyoBean.getIrTsintelno(), "010-1234-5678", "（ＩＲ）通信先電話番号");
        exStringEquals(siEditKakuniniraisyoBean.getIrTsinadr1kj(), "京都戸京加奈機", "（ＩＲ）通信先住所１（漢字）");
        exStringEquals(siEditKakuniniraisyoBean.getIrTsinadr2kj(), null, "（ＩＲ）通信先住所２（漢字）");
        exStringEquals(siEditKakuniniraisyoBean.getIrTsinadr3kj(), null, "（ＩＲ）通信先住所３（漢字）");
        exStringEquals(siEditKakuniniraisyoBean.getIrHkgk(), "100,000", "（ＩＲ）保険金額");
        exStringEquals(siEditKakuniniraisyoBean.getIrHozonkkn(), "5", "（ＩＲ）保存期間");

    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testExec_B4() {
        EditKakuniniraisyoBean editKakuniniraisyoBean = SWAKInjector.getInstance(EditKakuniniraisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151214));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SOUHU);
        editKakuniniraisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

        editKakuniniraisyoBean.setSeikyuusyubetu(C_SeikyuuSyubetu.PM);
        editKakuniniraisyoBean.setSyono("17806000080");
        editKakuniniraisyoBean.setKykYmd(BizDate.valueOf(20111011));
        editKakuniniraisyoBean.setSibouYmd(null);
        editKakuniniraisyoBean.setSyoruiukeYmd(BizDate.valueOf(20150506));
        editKakuniniraisyoBean.setSikkouYmd(null);
        editKakuniniraisyoBean.setHksknnkaisiYmd(null);
        editKakuniniraisyoBean.setLastmeihenYmd(null);
        editKakuniniraisyoBean.setHhknNmkn("加藤");
        editKakuniniraisyoBean.setHhknNmkj("菓子");
        editKakuniniraisyoBean.setKyknmkn("氏楽");
        editKakuniniraisyoBean.setKyknmkj("有馬");
        editKakuniniraisyoBean.setHokenknGk(BizCurrency.valueOf(100000));
        editKakuniniraisyoBean.setHyojitelno("010-1123-4567");
        editKakuniniraisyoBean.setSaigais(BizCurrency.valueOf(0));

        SeikyuusyaInfoBean seikyuusyaInfoBean = SWAKInjector.getInstance(SeikyuusyaInfoBean.class);
        seikyuusyaInfoBean.setSeikyuusyanmKn("根城");
        seikyuusyaInfoBean.setSeikyuusyanmKj("加奈");
        seikyuusyaInfoBean.setTsinyno("0101234");
        seikyuusyaInfoBean.setTsinadr1kj("京都");
        seikyuusyaInfoBean.setTsinadr2kj("戸京");
        seikyuusyaInfoBean.setTsinadr3kj("加奈機");
        seikyuusyaInfoBean.setTsintelno("010-1234-5678");
        editKakuniniraisyoBean.setSeikyuusyaInfoBean(seikyuusyaInfoBean);

        ReportServicesBean reportServicesBean = editKakuniniraisyo.exec(editKakuniniraisyoBean);
        exStringEquals(reportServicesBean.getKensakuKeys()[0], "17806000080", "検索キー[0]");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf(20151214), "処理日付");

        SiEditKakuniniraisyoBean siEditKakuniniraisyoBean = (SiEditKakuniniraisyoBean) (reportServicesBean
            .getParamObjectsData().get(C_SyoruiCdKbn.HK_SOUHU.getValue()))[0];

        exStringEquals(siEditKakuniniraisyoBean.getIrTyouhyoutitle(), "", "（ＩＲ）帳票タイトル");
        exStringEquals(siEditKakuniniraisyoBean.getIrIraisyohyojitelno(), "010-1123-4567", "（ＩＲ）確認依頼書表示電話番号");
        exStringEquals(siEditKakuniniraisyoBean.getIrSyono(), "17806000080", "（ＩＲ）証券番号");
        exStringEquals(siEditKakuniniraisyoBean.getIrKykymd(), "２０１１年１０月１１日", "（ＩＲ）契約日");
        exStringEquals(siEditKakuniniraisyoBean.getIrSbymdkoteiymd(), null, "（ＩＲ）死亡日または固定日");
        exStringEquals(siEditKakuniniraisyoBean.getIrSyoruiukeymd(), "２０１５年 ５月 ６日", "（ＩＲ）書類受付日");
        exStringEquals(siEditKakuniniraisyoBean.getIrSikkouymd(), null, "（ＩＲ）失効日");
        exStringEquals(siEditKakuniniraisyoBean.getIrHksknnkaisiymd(), null, "（ＩＲ）復活責任開始日");
        exStringEquals(siEditKakuniniraisyoBean.getIrLastmeihenymd(), null, "（ＩＲ）最終名義変更日");
        exStringEquals(siEditKakuniniraisyoBean.getIrHhknnmkn(), "加藤", "（ＩＲ）被保険者名（カナ）");
        exStringEquals(siEditKakuniniraisyoBean.getIrHhknnmkj(), "菓子", "（ＩＲ）被保険者名（漢字）");
        exStringEquals(siEditKakuniniraisyoBean.getIrKyknmkn(), "氏楽", "（ＩＲ）契約者名（カナ）");
        exStringEquals(siEditKakuniniraisyoBean.getIrKyknmkj(), "有馬", "（ＩＲ）契約者名（漢字）");
        exStringEquals(siEditKakuniniraisyoBean.getIrSeikyuusyanmkn(), "根城", "（ＩＲ）請求者（カナ）");
        exStringEquals(siEditKakuniniraisyoBean.getIrSeikyuusyanmkj(), "加奈", "（ＩＲ）請求者（漢字）");
        exStringEquals(siEditKakuniniraisyoBean.getIrTsinyno(), "0101234", "（ＩＲ）通信先郵便番号");
        exStringEquals(siEditKakuniniraisyoBean.getIrTsintelno(), "010-1234-5678", "（ＩＲ）通信先電話番号");
        exStringEquals(siEditKakuniniraisyoBean.getIrTsinadr1kj(), "京都戸京加奈機", "（ＩＲ）通信先住所１（漢字）");
        exStringEquals(siEditKakuniniraisyoBean.getIrTsinadr2kj(), null, "（ＩＲ）通信先住所２（漢字）");
        exStringEquals(siEditKakuniniraisyoBean.getIrTsinadr3kj(), null, "（ＩＲ）通信先住所３（漢字）");
        exStringEquals(siEditKakuniniraisyoBean.getIrHkgk(), "100,000", "（ＩＲ）保険金額");
        exStringEquals(siEditKakuniniraisyoBean.getIrHozonkkn(), "5", "（ＩＲ）保存期間");

    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testExec_D1() {

        EditKakuniniraisyoBean editKakuniniraisyoBean = SWAKInjector.getInstance(EditKakuniniraisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151214));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SOUHU);
        editKakuniniraisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

        editKakuniniraisyoBean.setSeikyuusyubetu(C_SeikyuuSyubetu.KYH);
        editKakuniniraisyoBean.setSyono("17806000080");
        editKakuniniraisyoBean.setKykYmd(BizDate.valueOf(20111011));
        editKakuniniraisyoBean.setSyoruiukeYmd(BizDate.valueOf(20111012));
        editKakuniniraisyoBean.setHokenknGk(BizCurrency.valueOf(0));
        editKakuniniraisyoBean.setSaigais(BizCurrency.optional());

        SeikyuusyaInfoBean seikyuusyaInfoBean = SWAKInjector.getInstance(SeikyuusyaInfoBean.class);
        seikyuusyaInfoBean.setTsinadr1kj("AAAAAAAAAAAAAAAAAAAAAAAAAAAAB");
        editKakuniniraisyoBean.setSeikyuusyaInfoBean(seikyuusyaInfoBean);

        ReportServicesBean reportServicesBean = editKakuniniraisyo.exec(editKakuniniraisyoBean);

        SiEditKakuniniraisyoBean siEditKakuniniraisyoBean = (SiEditKakuniniraisyoBean) (reportServicesBean
            .getParamObjectsData().get(C_SyoruiCdKbn.HK_SOUHU.getValue()))[0];

        exStringEquals(siEditKakuniniraisyoBean.getIrSaigais(), "", "（ＩＲ）災害保険金");
        exStringEquals(siEditKakuniniraisyoBean.getIrSaigaistani(), "", "（ＩＲ）災害Ｓ単位");
        exStringEquals(siEditKakuniniraisyoBean.getIrTsinadr1kj(), "AAAAAAAAAAAAAAAAAAAAAAAAAAAA", "（ＩＲ）通信先住所１（漢字）");
        exStringEquals(siEditKakuniniraisyoBean.getIrTsinadr2kj(), "B", "（ＩＲ）通信先住所２（漢字）");
        exStringEquals(siEditKakuniniraisyoBean.getIrTsinadr3kj(), null, "（ＩＲ）通信先住所３（漢字）");

    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testExec_D2() {

        EditKakuniniraisyoBean editKakuniniraisyoBean = SWAKInjector.getInstance(EditKakuniniraisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151214));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SOUHU);
        editKakuniniraisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

        editKakuniniraisyoBean.setSeikyuusyubetu(C_SeikyuuSyubetu.KYH);
        editKakuniniraisyoBean.setSyono("17806000080");
        editKakuniniraisyoBean.setKykYmd(BizDate.valueOf(20111011));
        editKakuniniraisyoBean.setSyoruiukeYmd(BizDate.valueOf(20111012));
        editKakuniniraisyoBean.setHokenknGk(BizCurrency.valueOf(0));
        editKakuniniraisyoBean.setSaigais(BizCurrency.valueOf(0));

        SeikyuusyaInfoBean seikyuusyaInfoBean = SWAKInjector.getInstance(SeikyuusyaInfoBean.class);
        seikyuusyaInfoBean.setTsinadr1kj("AAAAAAAAAAAAAAAAAAAAAAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBBBBC");
        editKakuniniraisyoBean.setSeikyuusyaInfoBean(seikyuusyaInfoBean);

        ReportServicesBean reportServicesBean = editKakuniniraisyo.exec(editKakuniniraisyoBean);

        SiEditKakuniniraisyoBean siEditKakuniniraisyoBean = (SiEditKakuniniraisyoBean) (reportServicesBean
            .getParamObjectsData().get(C_SyoruiCdKbn.HK_SOUHU.getValue()))[0];

        exStringEquals(siEditKakuniniraisyoBean.getIrSaigais(), "", "（ＩＲ）災害保険金");
        exStringEquals(siEditKakuniniraisyoBean.getIrSaigaistani(), "", "（ＩＲ）災害Ｓ単位");
        exStringEquals(siEditKakuniniraisyoBean.getIrTsinadr1kj(), "AAAAAAAAAAAAAAAAAAAAAAAAAAAB", "（ＩＲ）通信先住所１（漢字）");
        exStringEquals(siEditKakuniniraisyoBean.getIrTsinadr2kj(), "BBBBBBBBBBBBBBBBBBBBBBBBBBBB", "（ＩＲ）通信先住所２（漢字）");
        exStringEquals(siEditKakuniniraisyoBean.getIrTsinadr3kj(), "BC", "（ＩＲ）通信先住所３（漢字）");

    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testExec_D3() {

        EditKakuniniraisyoBean editKakuniniraisyoBean = SWAKInjector.getInstance(EditKakuniniraisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151214));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SOUHU);
        editKakuniniraisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

        editKakuniniraisyoBean.setSeikyuusyubetu(C_SeikyuuSyubetu.KYH);
        editKakuniniraisyoBean.setSyono("17806000080");
        editKakuniniraisyoBean.setKykYmd(BizDate.valueOf(20111011));
        editKakuniniraisyoBean.setSyoruiukeYmd(BizDate.valueOf(20111012));
        editKakuniniraisyoBean.setHokenknGk(BizCurrency.valueOf(0));
        editKakuniniraisyoBean.setSaigais(BizCurrency.valueOf(1));

        SeikyuusyaInfoBean seikyuusyaInfoBean = SWAKInjector.getInstance(SeikyuusyaInfoBean.class);
        editKakuniniraisyoBean.setSeikyuusyaInfoBean(seikyuusyaInfoBean);

        ReportServicesBean reportServicesBean = editKakuniniraisyo.exec(editKakuniniraisyoBean);

        SiEditKakuniniraisyoBean siEditKakuniniraisyoBean = (SiEditKakuniniraisyoBean) (reportServicesBean
            .getParamObjectsData().get(C_SyoruiCdKbn.HK_SOUHU.getValue()))[0];

        exStringEquals(siEditKakuniniraisyoBean.getIrSaigais(), "1", "（ＩＲ）災害保険金");
        exStringEquals(siEditKakuniniraisyoBean.getIrSaigaistani(), "円", "（ＩＲ）災害Ｓ単位");

    }
}
