package yuyu.common.suuri.srcommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.db.entity.IT_KhHenkouRireki;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 特定時点指数連動型積立金情報取得のメソッド {@link SrGetTokutejitenSisuurendoTmttknInfo#exec(String, BizDate,
        ,String )} テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class SrGetTokutejitenSisuurendoTmttknInfoTest_exec {

    private final static String fileName = "UT-SP_単体テスト仕様書_特定時点指数連動型積立金情報取得";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SrGetTokutejitenKykKihonInfoTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @BeforeClass
    public static void testInit() {

    }

    @AfterClass
    public static void testClear() {
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        SrGetTokutejitenSisuurendoTmttknInfo srGetTokutejitenSisuurendoTmttknInfo =
            SWAKInjector.getInstance(SrGetTokutejitenSisuurendoTmttknInfo.class);

        String pSyono = "17806000013";
        BizDate pKijyunYmd = BizDate.valueOf(20180808);

        List<SrGetTokutejitenTmttknInfoBean> srGetTokutejitenTmttknInfoBeanList =
            srGetTokutejitenSisuurendoTmttknInfo.exec(pSyono, pKijyunYmd, null, null);

        exNumericEquals(srGetTokutejitenTmttknInfoBeanList.size(), 0, "件数");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        MockObjectManager.initialize();


        SrGetTokutejitenSisuurendoTmttknInfo srGetTokutejitenSisuurendoTmttknInfo =
            SWAKInjector.getInstance(SrGetTokutejitenSisuurendoTmttknInfo.class);

        String pSyono = "17806000024";
        BizDate pKijyunYmd = BizDate.valueOf(20180101);

        List<SrGetTokutejitenTmttknInfoBean> srGetTokutejitenTmttknInfoBeanList =
            srGetTokutejitenSisuurendoTmttknInfo.exec(pSyono, pKijyunYmd, null, null);

        exNumericEquals(srGetTokutejitenTmttknInfoBeanList.size(), 8, "件数");
        SrGetTokutejitenTmttknInfoBean srGetTokutejitenTmttknInfoBean1 = srGetTokutejitenTmttknInfoBeanList.get(0);
        exStringEquals(srGetTokutejitenTmttknInfoBean1.getKbnkey(), "02", "区分キー");
        exStringEquals(srGetTokutejitenTmttknInfoBean1.getSyono(), "17806000024", "証券番号");
        exDateYMEquals(srGetTokutejitenTmttknInfoBean1.getTmttkntaisyouym(), BizDateYM.valueOf("201804"), "積立金対象年月");
        exNumericEquals(srGetTokutejitenTmttknInfoBean1.getRenno(), 4, "連番");
        exDateEquals(srGetTokutejitenTmttknInfoBean1.getTmttknkouryokukaisiymd(), BizDate.valueOf("20180104"), "積立金効力開始日");
        exBizCalcbleEquals(srGetTokutejitenTmttknInfoBean1.getTeiritutmttkngk(), BizCurrency.valueOf(123456792), "定率積立金額");
        exBizCalcbleEquals(srGetTokutejitenTmttknInfoBean1.getSisuurendoutmttkngk(), BizCurrency.valueOf(234567894), "指数連動積立金額");
        exBizCalcbleEquals(srGetTokutejitenTmttknInfoBean1.getSisuuupritu(), BizNumber.valueOf(3.4570), "指数上昇率");
        exBizCalcbleEquals(srGetTokutejitenTmttknInfoBean1.getTmttknzoukaritu(), BizNumber.valueOf(4.5681), "積立金増加率");
        exDateEquals(srGetTokutejitenTmttknInfoBean1.getTmttknhaneitmmshanteiymd(), BizDate.valueOf("20180204"), "積立金反映時積増判定日");
        exBizCalcbleEquals(srGetTokutejitenTmttknInfoBean1.getTmttknhaneisisuu(), BizNumber.valueOf(12345.12348), "積立金反映時指数");
        exStringEquals(srGetTokutejitenTmttknInfoBean1.getGyoumuKousinKinou(), "khsisuurendotmttknhanei", "業務用更新機能ＩＤ");
        exStringEquals(srGetTokutejitenTmttknInfoBean1.getGyoumuKousinsyaId(), "user004", "業務用更新者ＩＤ");
        exStringEquals(srGetTokutejitenTmttknInfoBean1.getGyoumuKousinTime(), "20180618210926126", "業務用更新時間");
        exStringEquals(srGetTokutejitenTmttknInfoBean1.getKousinsyaId(), "user104", "更新者ＩＤ");
        exNumericEquals(srGetTokutejitenTmttknInfoBean1.getVersion(), 4, "バージョン");
        exBizCalcbleEquals(srGetTokutejitenTmttknInfoBean1.getItenmaeteiritutmttkngk(), BizCurrency.valueOf(5678901237L), "移転前定率積立金額");
        exBizCalcbleEquals(srGetTokutejitenTmttknInfoBean1.getItenmaesisuurendoutmttkngk(), BizCurrency.valueOf(6789012348L), "移転前指数連動積立金額");
        exStringEquals(srGetTokutejitenTmttknInfoBean1.getHenkousikibetukey(), "007", "変更識別キー");
        exDateEquals(srGetTokutejitenTmttknInfoBean1.getSyoriYmd(), BizDate.valueOf("20180101"), "処理年月日");
        SrGetTokutejitenTmttknInfoBean srGetTokutejitenTmttknInfoBean2 = srGetTokutejitenTmttknInfoBeanList.get(1);
        exStringEquals(srGetTokutejitenTmttknInfoBean2.getKbnkey(), "02", "区分キー");
        exStringEquals(srGetTokutejitenTmttknInfoBean2.getSyono(), "17806000024", "証券番号");
        exDateYMEquals(srGetTokutejitenTmttknInfoBean2.getTmttkntaisyouym(), BizDateYM.valueOf("201803"), "積立金対象年月");
        exNumericEquals(srGetTokutejitenTmttknInfoBean2.getRenno(), 3, "連番");
        exDateEquals(srGetTokutejitenTmttknInfoBean2.getTmttknkouryokukaisiymd(), BizDate.valueOf("20180103"), "積立金効力開始日");
        exBizCalcbleEquals(srGetTokutejitenTmttknInfoBean2.getTeiritutmttkngk(), BizCurrency.valueOf(123456791), "定率積立金額");
        exBizCalcbleEquals(srGetTokutejitenTmttknInfoBean2.getSisuurendoutmttkngk(), BizCurrency.valueOf(234567893), "指数連動積立金額");
        exBizCalcbleEquals(srGetTokutejitenTmttknInfoBean2.getSisuuupritu(), BizNumber.valueOf(3.4569), "指数上昇率");
        exBizCalcbleEquals(srGetTokutejitenTmttknInfoBean2.getTmttknzoukaritu(), BizNumber.valueOf(4.5680), "積立金増加率");
        exDateEquals(srGetTokutejitenTmttknInfoBean2.getTmttknhaneitmmshanteiymd(), BizDate.valueOf("20180203"), "積立金反映時積増判定日");
        exBizCalcbleEquals(srGetTokutejitenTmttknInfoBean2.getTmttknhaneisisuu(), BizNumber.valueOf(12345.12347), "積立金反映時指数");
        exStringEquals(srGetTokutejitenTmttknInfoBean2.getGyoumuKousinKinou(), "khsisuurendotmttknhanei", "業務用更新機能ＩＤ");
        exStringEquals(srGetTokutejitenTmttknInfoBean2.getGyoumuKousinsyaId(), "user003", "業務用更新者ＩＤ");
        exStringEquals(srGetTokutejitenTmttknInfoBean2.getGyoumuKousinTime(), "20180618210926125", "業務用更新時間");
        exStringEquals(srGetTokutejitenTmttknInfoBean2.getKousinsyaId(), "user103", "更新者ＩＤ");
        exNumericEquals(srGetTokutejitenTmttknInfoBean2.getVersion(), 3, "バージョン");
        exBizCalcbleEquals(srGetTokutejitenTmttknInfoBean2.getItenmaeteiritutmttkngk(), BizCurrency.valueOf(5678901236L), "移転前定率積立金額");
        exBizCalcbleEquals(srGetTokutejitenTmttknInfoBean2.getItenmaesisuurendoutmttkngk(), BizCurrency.valueOf(6789012347L), "移転前指数連動積立金額");
        exStringEquals(srGetTokutejitenTmttknInfoBean2.getHenkousikibetukey(), "008", "変更識別キー");
        exDateEquals(srGetTokutejitenTmttknInfoBean2.getSyoriYmd(), BizDate.valueOf("20180101"), "処理年月日");
        SrGetTokutejitenTmttknInfoBean srGetTokutejitenTmttknInfoBean3 = srGetTokutejitenTmttknInfoBeanList.get(2);
        assertNull("区分キー", srGetTokutejitenTmttknInfoBean3.getKbnkey());
        assertNull("証券番号", srGetTokutejitenTmttknInfoBean3.getSyono());
        assertNull("積立金対象年月", srGetTokutejitenTmttknInfoBean3.getTmttkntaisyouym());
        assertNull("連番", srGetTokutejitenTmttknInfoBean3.getRenno());
        assertNull("積立金効力開始日", srGetTokutejitenTmttknInfoBean3.getTmttknkouryokukaisiymd());
        assertNull("定率積立金額", srGetTokutejitenTmttknInfoBean3.getTeiritutmttkngk());
        assertNull("指数連動積立金額", srGetTokutejitenTmttknInfoBean3.getSisuurendoutmttkngk());
        assertNull("指数上昇率", srGetTokutejitenTmttknInfoBean3.getSisuuupritu());
        assertNull("積立金増加率", srGetTokutejitenTmttknInfoBean3.getTmttknzoukaritu());
        assertNull("積立金反映時積増判定日", srGetTokutejitenTmttknInfoBean3.getTmttknhaneitmmshanteiymd());
        assertNull("積立金反映時指数", srGetTokutejitenTmttknInfoBean3.getTmttknhaneisisuu());
        exStringEquals(srGetTokutejitenTmttknInfoBean3.getGyoumuKousinKinou(), "SrGetTokutejitenSisuurendoTmttknInfoHaneiTrks", "業務用更新機能ＩＤ");
        assertNull("業務用更新者ＩＤ", srGetTokutejitenTmttknInfoBean3.getGyoumuKousinsyaId());
        assertNull("業務用更新時間", srGetTokutejitenTmttknInfoBean3.getGyoumuKousinTime());
        assertNull("更新者ＩＤ", srGetTokutejitenTmttknInfoBean3.getKousinsyaId());
        assertNull("バージョン", srGetTokutejitenTmttknInfoBean3.getVersion());
        assertNull("移転前定率積立金額", srGetTokutejitenTmttknInfoBean3.getItenmaeteiritutmttkngk());
        assertNull("移転前指数連動積立金額", srGetTokutejitenTmttknInfoBean3.getItenmaesisuurendoutmttkngk());
        exStringEquals(srGetTokutejitenTmttknInfoBean3.getHenkousikibetukey(), "009", "変更識別キー");
        exDateEquals(srGetTokutejitenTmttknInfoBean3.getSyoriYmd(), BizDate.valueOf("20180101"), "処理年月日");
        SrGetTokutejitenTmttknInfoBean srGetTokutejitenTmttknInfoBean4 = srGetTokutejitenTmttknInfoBeanList.get(3);
        exStringEquals(srGetTokutejitenTmttknInfoBean4.getKbnkey(), "02", "区分キー");
        exStringEquals(srGetTokutejitenTmttknInfoBean4.getSyono(), "17806000024", "証券番号");
        exDateYMEquals(srGetTokutejitenTmttknInfoBean4.getTmttkntaisyouym(), BizDateYM.valueOf("201805"), "積立金対象年月");
        exNumericEquals(srGetTokutejitenTmttknInfoBean4.getRenno(), 6, "連番");
        exDateEquals(srGetTokutejitenTmttknInfoBean4.getTmttknkouryokukaisiymd(), BizDate.valueOf("20180105"), "積立金効力開始日");
        exBizCalcbleEquals(srGetTokutejitenTmttknInfoBean4.getTeiritutmttkngk(), BizCurrency.valueOf(123456793), "定率積立金額");
        exBizCalcbleEquals(srGetTokutejitenTmttknInfoBean4.getSisuurendoutmttkngk(), BizCurrency.valueOf(234567895), "指数連動積立金額");
        exBizCalcbleEquals(srGetTokutejitenTmttknInfoBean4.getSisuuupritu(), BizNumber.valueOf(3.4571), "指数上昇率");
        exBizCalcbleEquals(srGetTokutejitenTmttknInfoBean4.getTmttknzoukaritu(), BizNumber.valueOf(4.5682), "積立金増加率");
        exDateEquals(srGetTokutejitenTmttknInfoBean4.getTmttknhaneitmmshanteiymd(), BizDate.valueOf("20180205"), "積立金反映時積増判定日");
        exBizCalcbleEquals(srGetTokutejitenTmttknInfoBean4.getTmttknhaneisisuu(), BizNumber.valueOf(12345.12349), "積立金反映時指数");
        exStringEquals(srGetTokutejitenTmttknInfoBean4.getGyoumuKousinKinou(), "SrGetTokutejitenSisuurendoTmttknInfoHanei", "業務用更新機能ＩＤ");
        exStringEquals(srGetTokutejitenTmttknInfoBean4.getGyoumuKousinsyaId(), "user005", "業務用更新者ＩＤ");
        exStringEquals(srGetTokutejitenTmttknInfoBean4.getGyoumuKousinTime(), "20180618210926126", "業務用更新時間");
        exStringEquals(srGetTokutejitenTmttknInfoBean4.getKousinsyaId(), "user105", "更新者ＩＤ");
        exNumericEquals(srGetTokutejitenTmttknInfoBean4.getVersion(), 5, "バージョン");
        exBizCalcbleEquals(srGetTokutejitenTmttknInfoBean4.getItenmaeteiritutmttkngk(), BizCurrency.valueOf(5678901238L), "移転前定率積立金額");
        exBizCalcbleEquals(srGetTokutejitenTmttknInfoBean4.getItenmaesisuurendoutmttkngk(), BizCurrency.valueOf(6789012349L), "移転前指数連動積立金額");
        exStringEquals(srGetTokutejitenTmttknInfoBean4.getHenkousikibetukey(), "010", "変更識別キー");
        exDateEquals(srGetTokutejitenTmttknInfoBean4.getSyoriYmd(), BizDate.valueOf("20180101"), "処理年月日");
        SrGetTokutejitenTmttknInfoBean srGetTokutejitenTmttknInfoBean5 = srGetTokutejitenTmttknInfoBeanList.get(4);
        assertNull("区分キー", srGetTokutejitenTmttknInfoBean5.getKbnkey());
        assertNull("証券番号", srGetTokutejitenTmttknInfoBean5.getSyono());
        assertNull("積立金対象年月", srGetTokutejitenTmttknInfoBean5.getTmttkntaisyouym());
        assertNull("連番", srGetTokutejitenTmttknInfoBean5.getRenno());
        assertNull("積立金効力開始日", srGetTokutejitenTmttknInfoBean5.getTmttknkouryokukaisiymd());
        assertNull("定率積立金額", srGetTokutejitenTmttknInfoBean5.getTeiritutmttkngk());
        assertNull("指数連動積立金額", srGetTokutejitenTmttknInfoBean5.getSisuurendoutmttkngk());
        assertNull("指数上昇率", srGetTokutejitenTmttknInfoBean5.getSisuuupritu());
        assertNull("積立金増加率", srGetTokutejitenTmttknInfoBean5.getTmttknzoukaritu());
        assertNull("積立金反映時積増判定日", srGetTokutejitenTmttknInfoBean5.getTmttknhaneitmmshanteiymd());
        assertNull("積立金反映時指数", srGetTokutejitenTmttknInfoBean5.getTmttknhaneisisuu());
        exStringEquals(srGetTokutejitenTmttknInfoBean5.getGyoumuKousinKinou(), "SrGetTokutejitenSisuurendoTmttknInfoHaneiTrks", "業務用更新機能ＩＤ");
        assertNull("業務用更新者ＩＤ", srGetTokutejitenTmttknInfoBean5.getGyoumuKousinsyaId());
        assertNull("業務用更新時間", srGetTokutejitenTmttknInfoBean5.getGyoumuKousinTime());
        assertNull("更新者ＩＤ", srGetTokutejitenTmttknInfoBean5.getKousinsyaId());
        assertNull("バージョン", srGetTokutejitenTmttknInfoBean5.getVersion());
        assertNull("移転前定率積立金額", srGetTokutejitenTmttknInfoBean5.getItenmaeteiritutmttkngk());
        assertNull("移転前指数連動積立金額", srGetTokutejitenTmttknInfoBean5.getItenmaesisuurendoutmttkngk());
        exStringEquals(srGetTokutejitenTmttknInfoBean5.getHenkousikibetukey(), "010", "変更識別キー");
        exDateEquals(srGetTokutejitenTmttknInfoBean5.getSyoriYmd(), BizDate.valueOf("20180101"), "処理年月日");
        SrGetTokutejitenTmttknInfoBean srGetTokutejitenTmttknInfoBean6 = srGetTokutejitenTmttknInfoBeanList.get(5);
        exStringEquals(srGetTokutejitenTmttknInfoBean6.getKbnkey(), "02", "区分キー");
        exStringEquals(srGetTokutejitenTmttknInfoBean6.getSyono(), "17806000024", "証券番号");
        exDateYMEquals(srGetTokutejitenTmttknInfoBean6.getTmttkntaisyouym(), BizDateYM.valueOf("201805"), "積立金対象年月");
        exNumericEquals(srGetTokutejitenTmttknInfoBean6.getRenno(), 6, "連番");
        exDateEquals(srGetTokutejitenTmttknInfoBean6.getTmttknkouryokukaisiymd(), BizDate.valueOf("20180105"), "積立金効力開始日");
        exBizCalcbleEquals(srGetTokutejitenTmttknInfoBean6.getTeiritutmttkngk(), BizCurrency.valueOf(123456793), "定率積立金額");
        exBizCalcbleEquals(srGetTokutejitenTmttknInfoBean6.getSisuurendoutmttkngk(), BizCurrency.valueOf(234567895), "指数連動積立金額");
        exBizCalcbleEquals(srGetTokutejitenTmttknInfoBean6.getSisuuupritu(), BizNumber.valueOf(3.4571), "指数上昇率");
        exBizCalcbleEquals(srGetTokutejitenTmttknInfoBean6.getTmttknzoukaritu(), BizNumber.valueOf(4.5682), "積立金増加率");
        exDateEquals(srGetTokutejitenTmttknInfoBean6.getTmttknhaneitmmshanteiymd(), BizDate.valueOf("20180205"), "積立金反映時積増判定日");
        exBizCalcbleEquals(srGetTokutejitenTmttknInfoBean6.getTmttknhaneisisuu(), BizNumber.valueOf(12345.12349), "積立金反映時指数");
        exStringEquals(srGetTokutejitenTmttknInfoBean6.getGyoumuKousinKinou(), "SrGetTokutejitenSisuurendoTmttknInfoHanei", "業務用更新機能ＩＤ");
        exStringEquals(srGetTokutejitenTmttknInfoBean6.getGyoumuKousinsyaId(), "user005", "業務用更新者ＩＤ");
        exStringEquals(srGetTokutejitenTmttknInfoBean6.getGyoumuKousinTime(), "20180618210926126", "業務用更新時間");
        exStringEquals(srGetTokutejitenTmttknInfoBean6.getKousinsyaId(), "user105", "更新者ＩＤ");
        exNumericEquals(srGetTokutejitenTmttknInfoBean6.getVersion(), 5, "バージョン");
        exBizCalcbleEquals(srGetTokutejitenTmttknInfoBean6.getItenmaeteiritutmttkngk(), BizCurrency.valueOf(5678901238L), "移転前定率積立金額");
        exBizCalcbleEquals(srGetTokutejitenTmttknInfoBean6.getItenmaesisuurendoutmttkngk(), BizCurrency.valueOf(6789012349L), "移転前指数連動積立金額");
        exStringEquals(srGetTokutejitenTmttknInfoBean6.getHenkousikibetukey(), "011", "変更識別キー");
        exDateEquals(srGetTokutejitenTmttknInfoBean6.getSyoriYmd(), BizDate.valueOf("20180101"), "処理年月日");
        SrGetTokutejitenTmttknInfoBean srGetTokutejitenTmttknInfoBean7 = srGetTokutejitenTmttknInfoBeanList.get(6);
        exStringEquals(srGetTokutejitenTmttknInfoBean7.getKbnkey(), "02", "区分キー");
        exStringEquals(srGetTokutejitenTmttknInfoBean7.getSyono(), "17806000024", "証券番号");
        exDateYMEquals(srGetTokutejitenTmttknInfoBean7.getTmttkntaisyouym(), BizDateYM.valueOf("201802"), "積立金対象年月");
        exNumericEquals(srGetTokutejitenTmttknInfoBean7.getRenno(), 2, "連番");
        exDateEquals(srGetTokutejitenTmttknInfoBean7.getTmttknkouryokukaisiymd(), BizDate.valueOf("20180102"), "積立金効力開始日");
        exBizCalcbleEquals(srGetTokutejitenTmttknInfoBean7.getTeiritutmttkngk(), BizCurrency.valueOf(123456790), "定率積立金額");
        exBizCalcbleEquals(srGetTokutejitenTmttknInfoBean7.getSisuurendoutmttkngk(), BizCurrency.valueOf(234567892), "指数連動積立金額");
        exBizCalcbleEquals(srGetTokutejitenTmttknInfoBean7.getSisuuupritu(), BizNumber.valueOf(3.4568), "指数上昇率");
        exBizCalcbleEquals(srGetTokutejitenTmttknInfoBean7.getTmttknzoukaritu(), BizNumber.valueOf(4.5679), "積立金増加率");
        exDateEquals(srGetTokutejitenTmttknInfoBean7.getTmttknhaneitmmshanteiymd(), BizDate.valueOf("20180202"), "積立金反映時積増判定日");
        exBizCalcbleEquals(srGetTokutejitenTmttknInfoBean7.getTmttknhaneisisuu(), BizNumber.valueOf(12345.12346), "積立金反映時指数");
        exStringEquals(srGetTokutejitenTmttknInfoBean7.getGyoumuKousinKinou(), "khsisuurendotmttknhanei", "業務用更新機能ＩＤ");
        exStringEquals(srGetTokutejitenTmttknInfoBean7.getGyoumuKousinsyaId(), "user002", "業務用更新者ＩＤ");
        exStringEquals(srGetTokutejitenTmttknInfoBean7.getGyoumuKousinTime(), "20180618210926124", "業務用更新時間");
        exStringEquals(srGetTokutejitenTmttknInfoBean7.getKousinsyaId(), "user102", "更新者ＩＤ");
        exNumericEquals(srGetTokutejitenTmttknInfoBean7.getVersion(), 2, "バージョン");
        exBizCalcbleEquals(srGetTokutejitenTmttknInfoBean7.getItenmaeteiritutmttkngk(), BizCurrency.valueOf(5678901235L), "移転前定率積立金額");
        exBizCalcbleEquals(srGetTokutejitenTmttknInfoBean7.getItenmaesisuurendoutmttkngk(), BizCurrency.valueOf(6789012346L), "移転前指数連動積立金額");
        assertNull("変更識別キー", srGetTokutejitenTmttknInfoBean7.getHenkousikibetukey());
        assertNull("処理年月日", srGetTokutejitenTmttknInfoBean7.getSyoriYmd());
        SrGetTokutejitenTmttknInfoBean srGetTokutejitenTmttknInfoBean8 = srGetTokutejitenTmttknInfoBeanList.get(7);
        exStringEquals(srGetTokutejitenTmttknInfoBean8.getKbnkey(), "02", "区分キー");
        exStringEquals(srGetTokutejitenTmttknInfoBean8.getSyono(), "17806000024", "証券番号");
        exDateYMEquals(srGetTokutejitenTmttknInfoBean8.getTmttkntaisyouym(), BizDateYM.valueOf("201801"), "積立金対象年月");
        exNumericEquals(srGetTokutejitenTmttknInfoBean8.getRenno(), 1, "連番");
        exDateEquals(srGetTokutejitenTmttknInfoBean8.getTmttknkouryokukaisiymd(), BizDate.valueOf("20180101"), "積立金効力開始日");
        exBizCalcbleEquals(srGetTokutejitenTmttknInfoBean8.getTeiritutmttkngk(), BizCurrency.valueOf(123456789), "定率積立金額");
        exBizCalcbleEquals(srGetTokutejitenTmttknInfoBean8.getSisuurendoutmttkngk(), BizCurrency.valueOf(234567891), "指数連動積立金額");
        exBizCalcbleEquals(srGetTokutejitenTmttknInfoBean8.getSisuuupritu(), BizNumber.valueOf(3.4567), "指数上昇率");
        exBizCalcbleEquals(srGetTokutejitenTmttknInfoBean8.getTmttknzoukaritu(), BizNumber.valueOf(4.5678), "積立金増加率");
        exDateEquals(srGetTokutejitenTmttknInfoBean8.getTmttknhaneitmmshanteiymd(), BizDate.valueOf("20180201"), "積立金反映時積増判定日");
        exBizCalcbleEquals(srGetTokutejitenTmttknInfoBean8.getTmttknhaneisisuu(), BizNumber.valueOf(12345.12345), "積立金反映時指数");
        exStringEquals(srGetTokutejitenTmttknInfoBean8.getGyoumuKousinKinou(), "khsisuurendotmttknhanei", "業務用更新機能ＩＤ");
        exStringEquals(srGetTokutejitenTmttknInfoBean8.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(srGetTokutejitenTmttknInfoBean8.getGyoumuKousinTime(), "20180618210926123", "業務用更新時間");
        exStringEquals(srGetTokutejitenTmttknInfoBean8.getKousinsyaId(), "user101", "更新者ＩＤ");
        exNumericEquals(srGetTokutejitenTmttknInfoBean8.getVersion(), 1, "バージョン");
        exBizCalcbleEquals(srGetTokutejitenTmttknInfoBean8.getItenmaeteiritutmttkngk(), BizCurrency.valueOf(5678901234L), "移転前定率積立金額");
        exBizCalcbleEquals(srGetTokutejitenTmttknInfoBean8.getItenmaesisuurendoutmttkngk(), BizCurrency.valueOf(6789012345L), "移転前指数連動積立金額");
        assertNull("変更識別キー", srGetTokutejitenTmttknInfoBean8.getHenkousikibetukey());
        assertNull("処理年月日", srGetTokutejitenTmttknInfoBean8.getSyoriYmd());

        IT_KhHenkouRireki khHenkouRireki2 = null;
        exStringEquals(khHenkouRireki2.getSyono(), "17806000024", "証券番号");
        exStringEquals(khHenkouRireki2.getHenkousikibetukey(), "010", "変更識別キー");
        exNumericEquals(khHenkouRireki2.getRenno3keta(), 102, "連番（３桁）");


    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        SrGetTokutejitenSisuurendoTmttknInfo srGetTokutejitenSisuurendoTmttknInfo =
            SWAKInjector.getInstance(SrGetTokutejitenSisuurendoTmttknInfo.class);

        String pSyono = "17806000035";
        BizDate pKijyunYmd = BizDate.valueOf(20180808);
        String pHenkouSikibetuKey = "001";

        List<SrGetTokutejitenTmttknInfoBean> srGetTokutejitenTmttknInfoBeanList =
            srGetTokutejitenSisuurendoTmttknInfo.exec(pSyono, pKijyunYmd, pHenkouSikibetuKey, null);

        exNumericEquals(srGetTokutejitenTmttknInfoBeanList.size(), 1, "件数");
        SrGetTokutejitenTmttknInfoBean srGetTokutejitenTmttknInfoBean1 = srGetTokutejitenTmttknInfoBeanList.get(0);
        exStringEquals(srGetTokutejitenTmttknInfoBean1.getKbnkey(), "03", "区分キー");
        exStringEquals(srGetTokutejitenTmttknInfoBean1.getSyono(), "17806000035", "証券番号");
        exDateYMEquals(srGetTokutejitenTmttknInfoBean1.getTmttkntaisyouym(), BizDateYM.valueOf("201801"), "積立金対象年月");
        exNumericEquals(srGetTokutejitenTmttknInfoBean1.getRenno(), 1, "連番");
        exDateEquals(srGetTokutejitenTmttknInfoBean1.getTmttknkouryokukaisiymd(), BizDate.valueOf("20180101"), "積立金効力開始日");
        exBizCalcbleEquals(srGetTokutejitenTmttknInfoBean1.getTeiritutmttkngk(), BizCurrency.valueOf(123456789), "定率積立金額");
        exBizCalcbleEquals(srGetTokutejitenTmttknInfoBean1.getSisuurendoutmttkngk(), BizCurrency.valueOf(234567891), "指数連動積立金額");
        exBizCalcbleEquals(srGetTokutejitenTmttknInfoBean1.getSisuuupritu(), BizNumber.valueOf(3.4567), "指数上昇率");
        exBizCalcbleEquals(srGetTokutejitenTmttknInfoBean1.getTmttknzoukaritu(), BizNumber.valueOf(4.5678), "積立金増加率");
        exDateEquals(srGetTokutejitenTmttknInfoBean1.getTmttknhaneitmmshanteiymd(), BizDate.valueOf("20180201"), "積立金反映時積増判定日");
        exBizCalcbleEquals(srGetTokutejitenTmttknInfoBean1.getTmttknhaneisisuu(), BizNumber.valueOf(12345.12345), "積立金反映時指数");
        exStringEquals(srGetTokutejitenTmttknInfoBean1.getGyoumuKousinKinou(), "khgengaku", "業務用更新機能ＩＤ");
        exStringEquals(srGetTokutejitenTmttknInfoBean1.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(srGetTokutejitenTmttknInfoBean1.getGyoumuKousinTime(), "20180618210926123", "業務用更新時間");
        exStringEquals(srGetTokutejitenTmttknInfoBean1.getKousinsyaId(), "user101", "更新者ＩＤ");
        exNumericEquals(srGetTokutejitenTmttknInfoBean1.getVersion(), 1, "バージョン");
        exBizCalcbleEquals(srGetTokutejitenTmttknInfoBean1.getItenmaeteiritutmttkngk(), BizCurrency.valueOf(5678901234L), "移転前定率積立金額");
        exBizCalcbleEquals(srGetTokutejitenTmttknInfoBean1.getItenmaesisuurendoutmttkngk(), BizCurrency.valueOf(6789012345L), "移転前指数連動積立金額");
        exStringEquals(srGetTokutejitenTmttknInfoBean1.getHenkousikibetukey(), "001", "変更識別キー");
        exDateEquals(srGetTokutejitenTmttknInfoBean1.getSyoriYmd(), BizDate.valueOf("20180112"), "処理年月日");

    }

}
