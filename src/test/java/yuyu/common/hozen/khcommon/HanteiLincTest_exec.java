package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.base.BaseUserInfo;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_SousinKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.IT_BAK_KykKihon;
import yuyu.def.db.entity.IT_KhLincSousinData;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＬＩＮＣ該当判定クラスのメソッド {@link HanteiLinc#exec(HanteiLincBean, KhozenCommonParam)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class HanteiLincTest_exec extends AbstractTest {

    @Inject
    private HanteiLinc hanteiLinc;

    @Inject
    private BaseUserInfo baseUserInfo;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_ＬＩＮＣ該当判定";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(HanteiLincTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllBAKKykKihon());
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
        hozenDomManager.delete(hozenDomManager.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU));
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
        bizDomManager.delete(bizDomManager.getAllKijyungkHanteiKawaseRate());
        bizDomManager.delete(bizDomManager.getAllAddress());
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void testExec_A1() {

        HanteiLincBean pHanteiLincBean = SWAKInjector.getInstance(HanteiLincBean.class);

        KhozenCommonParam pKhozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_BAK_KykKihon bakKykKihon = hozenDomManager.getBAKKykKihon("99806001010", "0000000010");
        pHanteiLincBean.setBakKykKihon(bakKykKihon);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001010");
        pHanteiLincBean.setKykKihon(kykKihon);

        C_ErrorKbn errorKbn = hanteiLinc.exec(pHanteiLincBean, pKhozenCommonParam);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        IT_KykKihon kykkihon = hanteiLinc.getKykkihon();
        exDateEquals(kykkihon.getMosymd(), BizDate.valueOf("20191216"), "申込日");
        exStringEquals(kykkihon.getSyono(), "99806001010", "証券番号");
        exStringEquals(kykkihon.getSkjmosno(), "991027202", "新契約時申込番号");

        exNumericEquals(kykkihon.getKhLincSousinDatas().size(), 0, "契約保全ＬＩＮＣ送信データテーブルエンティティリストの件数");
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testExec_A2() {

        HanteiLincBean pHanteiLincBean = SWAKInjector.getInstance(HanteiLincBean.class);
        pHanteiLincBean.setSyoriYmd(BizDate.valueOf("20201215"));
        pHanteiLincBean.setKanyuusyaNo(Long.valueOf(0));

        KhozenCommonParam pKhozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        pKhozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);
        baseUserInfo.getUser().setUserId("user001");

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001021");
        pHanteiLincBean.setKykKihon(kykKihon);

        changeSystemDate(BizDate.valueOf("20201215"));

        C_ErrorKbn errorKbn = hanteiLinc.exec(pHanteiLincBean, pKhozenCommonParam);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        IT_KykKihon kykkihon = hanteiLinc.getKykkihon();
        exDateEquals(kykkihon.getMosymd(), BizDate.valueOf("20190216"), "申込日");
        exStringEquals(kykkihon.getSyono(), "99806001021", "証券番号");
        exStringEquals(kykkihon.getSkjmosno(), "991027210", "新契約時申込番号");

        exNumericEquals(kykkihon.getKhLincSousinDatas().size(), 1, "契約保全ＬＩＮＣ送信データテーブルエンティティリストの件数");
        IT_KhLincSousinData khLincSousinData = kykkihon.getKhLincSousinDatas().get(0);
        exStringEquals(khLincSousinData.getMosno(), "991027210", "申込番号");
        exStringEquals(khLincSousinData.getSyono(), "99806001021", "証券番号");
        exDateEquals(khLincSousinData.getSyoriYmd(), BizDate.valueOf("20201215"), "処理年月日");
        exNumericEquals(khLincSousinData.getRenno(), 1, "連番");
        exClassificationEquals(khLincSousinData.getLincsousinkbn(), C_SousinKbn.SOUSINMATI, "ＬＩＮＣ送信区分");
        exNumericEquals(khLincSousinData.getLincrecordsyubetu(), 3, "ＬＩＮＣ＿レコード種別");
        exStringEquals(khLincSousinData.getLinchenkoutype(), "", "ＬＩＮＣ＿変更タイプ");
        exNumericEquals(khLincSousinData.getLinckanyuusyano(), 0, "ＬＩＮＣ＿加入者番号");
        exStringEquals(khLincSousinData.getLinchhknnmkn(), "ｷﾞｷﾞｷﾞｷﾞｷﾞｶﾞｶﾞｶﾞｶﾞｶﾞｶﾞｶﾞｶﾞｶﾞｶﾞｶﾞ", "ＬＩＮＣ＿被保険者名（カナ）");
        exStringEquals(khLincSousinData.getLinchhknnmkj(), "ユ被名　一い", "ＬＩＮＣ＿被保険者名（漢字）");
        exNumericEquals(khLincSousinData.getLinchhknsei(), 1, "ＬＩＮＣ＿被保険者性別");
        exDateEquals(khLincSousinData.getLinchhknseiymd(), BizDate.valueOf("19770101"), "ＬＩＮＣ＿被保険者生年月日");
        exStringEquals(khLincSousinData.getLinchhknadrkn(), "", "ＬＩＮＣ＿被保険者住所（カナ）");
        exClassificationEquals(khLincSousinData.getLinckeihidjnhyouji(), C_KykKbn.KEIHI_DOUITU, "ＬＩＮＣ＿契被同人表示");
        exStringEquals(khLincSousinData.getLinckyknmkn(), "ｷﾞｷﾞｷﾞｷﾞｷﾞｶﾞｶﾞｶﾞｶﾞｶﾞｶﾞｶﾞｶﾞｶﾞｶﾞｶﾞｶﾞｶﾞ", "ＬＩＮＣ＿契約者名（カナ）");
        exStringEquals(khLincSousinData.getLinckyknmkj(), "ユ被名　一い", "ＬＩＮＣ＿契約者名（漢字）");
        exNumericEquals(khLincSousinData.getLinckyksei(), 1, "ＬＩＮＣ＿契約者性別");
        exDateEquals(khLincSousinData.getLinckykseiymd(), BizDate.valueOf("19770101"), "ＬＩＮＣ＿契約者生年月日");
        exStringEquals(khLincSousinData.getLinckykadrkn(), "", "ＬＩＮＣ＿契約者住所（カナ）");
        exDateEquals(khLincSousinData.getLinctrkmousideymd(), BizDate.valueOf("20201215"), "ＬＩＮＣ＿登録申出年月日");
        exDateEquals(khLincSousinData.getLinckykymd(), BizDate.valueOf("20180901"), "ＬＩＮＣ＿契約年月日");
        exBizCalcbleEquals(khLincSousinData.getLinchutuusbs(), BizCurrency.valueOf(10000000), "ＬＩＮＣ＿普通死亡保険金額");
        exStringEquals(khLincSousinData.getLinckakusyasiyouran(), "99806001021991027210                  HS", "ＬＩＮＣ＿各社使用欄");
        exStringEquals(khLincSousinData.getGyoumuKousinKinou(), "khkeiyakuinfotorikomi", "業務用更新機能ＩＤ");
        exStringEquals(khLincSousinData.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(khLincSousinData.getGyoumuKousinTime().substring(0, 8), "20201215", "業務用更新時間");
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testExec_A3() {

        HanteiLincBean pHanteiLincBean = SWAKInjector.getInstance(HanteiLincBean.class);
        pHanteiLincBean.setSyoriYmd(BizDate.valueOf("20201215"));
        pHanteiLincBean.setKanyuusyaNo(Long.valueOf(0));

        KhozenCommonParam pKhozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        pKhozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_MSYPTORIKOMI);
        baseUserInfo.getUser().setUserId("user001");

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_BAK_KykKihon bakKykKihon = hozenDomManager.getBAKKykKihon("99806001032", "0000000010");
        pHanteiLincBean.setBakKykKihon(bakKykKihon);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001032");
        pHanteiLincBean.setKykKihon(kykKihon);

        changeSystemDate(BizDate.valueOf("20201215"));

        C_ErrorKbn errorKbn = hanteiLinc.exec(pHanteiLincBean, pKhozenCommonParam);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        IT_KykKihon kykkihon = hanteiLinc.getKykkihon();
        exDateEquals(kykkihon.getMosymd(), BizDate.valueOf("20190316"), "申込日");
        exStringEquals(kykkihon.getSyono(), "99806001032", "証券番号");
        exStringEquals(kykkihon.getSkjmosno(), "991027228", "新契約時申込番号");

        exNumericEquals(kykkihon.getKhLincSousinDatas().size(), 1, "契約保全ＬＩＮＣ送信データテーブルエンティティリストの件数");
        IT_KhLincSousinData khLincSousinData = kykkihon.getKhLincSousinDatas().get(0);
        exStringEquals(khLincSousinData.getMosno(), "991027228", "申込番号");
        exStringEquals(khLincSousinData.getSyono(), "99806001032", "証券番号");
        exDateEquals(khLincSousinData.getSyoriYmd(), BizDate.valueOf("20201215"), "処理年月日");
        exNumericEquals(khLincSousinData.getRenno(), 1, "連番");
        exClassificationEquals(khLincSousinData.getLincsousinkbn(), C_SousinKbn.SOUSINMATI, "ＬＩＮＣ送信区分");
        exNumericEquals(khLincSousinData.getLincrecordsyubetu(), 21, "ＬＩＮＣ＿レコード種別");
        exStringEquals(khLincSousinData.getLinchenkoutype(), "I", "ＬＩＮＣ＿変更タイプ");
        exNumericEquals(khLincSousinData.getLinckanyuusyano(), 0, "ＬＩＮＣ＿加入者番号");
        exStringEquals(khLincSousinData.getLinchhknnmkn(), "ｷﾞｷﾞｷﾞｷﾞｷﾞｶﾞｶﾞｶﾞｶﾞｶﾞｶﾞｶﾞｶﾞｶﾞｶﾞﾕ", "ＬＩＮＣ＿被保険者名（カナ）");
        exStringEquals(khLincSousinData.getLinchhknnmkj(), "ユ被名　一う", "ＬＩＮＣ＿被保険者名（漢字）");
        exNumericEquals(khLincSousinData.getLinchhknsei(), 2, "ＬＩＮＣ＿被保険者性別");
        exDateEquals(khLincSousinData.getLinchhknseiymd(), BizDate.valueOf("19770101"), "ＬＩＮＣ＿被保険者生年月日");
        exStringEquals(khLincSousinData.getLinchhknadrkn(), "ｱｷﾀｼ", "ＬＩＮＣ＿被保険者住所（カナ）");
        exClassificationEquals(khLincSousinData.getLinckeihidjnhyouji(), C_KykKbn.KEIHI_DOUITU, "ＬＩＮＣ＿契被同人表示");
        exStringEquals(khLincSousinData.getLinckyknmkn(), "ｷﾞｷﾞｷﾞｷﾞｷﾞｶﾞｶﾞｶﾞｶﾞｶﾞｶﾞｶﾞｶﾞｶﾞｶﾞﾕ", "ＬＩＮＣ＿契約者名（カナ）");
        exStringEquals(khLincSousinData.getLinckyknmkj(), "ユ被名　一う", "ＬＩＮＣ＿契約者名（漢字）");
        exNumericEquals(khLincSousinData.getLinckyksei(), 2, "ＬＩＮＣ＿契約者性別");
        exDateEquals(khLincSousinData.getLinckykseiymd(), BizDate.valueOf("19770101"), "ＬＩＮＣ＿契約者生年月日");
        exStringEquals(khLincSousinData.getLinckykadrkn(), "ｱｷﾀｼ", "ＬＩＮＣ＿契約者住所（カナ）");
        exDateEquals(khLincSousinData.getLinctrkmousideymd(), BizDate.valueOf("20201215"), "ＬＩＮＣ＿登録申出年月日");
        exDateEquals(khLincSousinData.getLinckykymd(), BizDate.valueOf("20180901"), "ＬＩＮＣ＿契約年月日");
        exBizCalcbleEquals(khLincSousinData.getLinchutuusbs(), BizCurrency.valueOf(20000000), "ＬＩＮＣ＿普通死亡保険金額");
        exStringEquals(khLincSousinData.getLinckakusyasiyouran(), "99806001032                           H ", "ＬＩＮＣ＿各社使用欄");
        exStringEquals(khLincSousinData.getGyoumuKousinKinou(), "khmisyuuptorikomi", "業務用更新機能ＩＤ");
        exStringEquals(khLincSousinData.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(khLincSousinData.getGyoumuKousinTime().substring(0, 8), "20201215", "業務用更新時間");
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testExec_A4() {

        HanteiLincBean pHanteiLincBean = SWAKInjector.getInstance(HanteiLincBean.class);
        pHanteiLincBean.setSyoriYmd(BizDate.valueOf("20201214"));

        KhozenCommonParam pKhozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        pKhozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_MSYPTORIKOMI);

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_BAK_KykKihon bakKykKihon = hozenDomManager.getBAKKykKihon("99806001043", "0000000010");
        pHanteiLincBean.setBakKykKihon(bakKykKihon);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001043");
        pHanteiLincBean.setKykKihon(kykKihon);

        changeSystemDate(BizDate.valueOf("20201215"));

        C_ErrorKbn errorKbn = hanteiLinc.exec(pHanteiLincBean, pKhozenCommonParam);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        IT_KykKihon kykkihon = hanteiLinc.getKykkihon();
        exDateEquals(kykkihon.getMosymd(), BizDate.valueOf("20190416"), "申込日");
        exStringEquals(kykkihon.getSyono(), "99806001043", "証券番号");
        exStringEquals(kykkihon.getSkjmosno(), "991027236", "新契約時申込番号");

        exNumericEquals(kykkihon.getKhLincSousinDatas().size(), 0, "契約保全ＬＩＮＣ送信データテーブルエンティティリストの件数");
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testExec_A5() {

        HanteiLincBean pHanteiLincBean = SWAKInjector.getInstance(HanteiLincBean.class);
        pHanteiLincBean.setSyoriYmd(BizDate.valueOf("20201214"));

        KhozenCommonParam pKhozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        pKhozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_MSYPTORIKOMI);

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_BAK_KykKihon bakKykKihon = hozenDomManager.getBAKKykKihon("99806001054", "0000000010");
        pHanteiLincBean.setBakKykKihon(bakKykKihon);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001054");
        pHanteiLincBean.setKykKihon(kykKihon);

        changeSystemDate(BizDate.valueOf("20201215"));

        C_ErrorKbn errorKbn = hanteiLinc.exec(pHanteiLincBean, pKhozenCommonParam);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        IT_KykKihon kykkihon = hanteiLinc.getKykkihon();
        exDateEquals(kykkihon.getMosymd(), BizDate.valueOf("20191216"), "申込日");
        exStringEquals(kykkihon.getSyono(), "99806001054", "証券番号");
        exStringEquals(kykkihon.getSkjmosno(), "991027244", "新契約時申込番号");

        exNumericEquals(kykkihon.getKhLincSousinDatas().size(), 0, "契約保全ＬＩＮＣ送信データテーブルエンティティリストの件数");

    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testExec_A6() {

        HanteiLincBean pHanteiLincBean = SWAKInjector.getInstance(HanteiLincBean.class);
        pHanteiLincBean.setSyoriYmd(BizDate.valueOf("20201214"));
        pHanteiLincBean.setKanyuusyaNo(Long.valueOf(0));

        KhozenCommonParam pKhozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        pKhozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_MSYPTORIKOMI);
        baseUserInfo.getUser().setUserId("user001");

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_BAK_KykKihon bakKykKihon = hozenDomManager.getBAKKykKihon("99806001065", "0000000010");
        pHanteiLincBean.setBakKykKihon(bakKykKihon);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001065");
        pHanteiLincBean.setKykKihon(kykKihon);

        changeSystemDate(BizDate.valueOf("20201215"));

        C_ErrorKbn errorKbn = hanteiLinc.exec(pHanteiLincBean, pKhozenCommonParam);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        IT_KykKihon kykkihon = hanteiLinc.getKykkihon();
        exDateEquals(kykkihon.getMosymd(), BizDate.valueOf("20191216"), "申込日");
        exStringEquals(kykkihon.getSyono(), "99806001065", "証券番号");
        exStringEquals(kykkihon.getSkjmosno(), "991027251", "新契約時申込番号");

        exNumericEquals(kykkihon.getKhLincSousinDatas().size(), 2, "契約保全ＬＩＮＣ送信データテーブルエンティティリストの件数");
        IT_KhLincSousinData khLincSousinData = kykkihon.getKhLincSousinDatas().get(1);
        exStringEquals(khLincSousinData.getMosno(), "991027251", "申込番号");
        exStringEquals(khLincSousinData.getSyono(), "99806001065", "証券番号");
        exDateEquals(khLincSousinData.getSyoriYmd(), BizDate.valueOf("20201214"), "処理年月日");
        exNumericEquals(khLincSousinData.getRenno(), 3, "連番");
        exClassificationEquals(khLincSousinData.getLincsousinkbn(), C_SousinKbn.MISOUSIN, "ＬＩＮＣ送信区分");
        exNumericEquals(khLincSousinData.getLincrecordsyubetu(), 21, "ＬＩＮＣ＿レコード種別");
        exStringEquals(khLincSousinData.getLinchenkoutype(), "D", "ＬＩＮＣ＿変更タイプ");
        exNumericEquals(khLincSousinData.getLinckanyuusyano(), 0, "ＬＩＮＣ＿加入者番号");
        exStringEquals(khLincSousinData.getLinchhknnmkn(), "ｷﾞｷﾞｷﾞｷﾞｷﾞｶﾞｶﾞｶﾞｶﾞｶﾞｶﾞｶﾞｶﾞｶﾞｶﾞｶﾞ", "ＬＩＮＣ＿被保険者名（カナ）");
        exStringEquals(khLincSousinData.getLinchhknnmkj(), "ユ被名　一か", "ＬＩＮＣ＿被保険者名（漢字）");
        exNumericEquals(khLincSousinData.getLinchhknsei(), 1, "ＬＩＮＣ＿被保険者性別");
        exDateEquals(khLincSousinData.getLinchhknseiymd(), BizDate.valueOf("19770101"), "ＬＩＮＣ＿被保険者生年月日");
        exStringEquals(khLincSousinData.getLinchhknadrkn(), "ｱｷﾀｼ ｱﾗﾔｱｻﾋﾁﾖｳ ｱｱｱｱｱｱｱｱｱｱｱｱｱｱｱ", "ＬＩＮＣ＿被保険者住所（カナ）");
        exClassificationEquals(khLincSousinData.getLinckeihidjnhyouji(), C_KykKbn.KEIHI_BETU, "ＬＩＮＣ＿契被同人表示");
        exStringEquals(khLincSousinData.getLinckyknmkn(), "ﾕﾋﾒｲ ｲﾁｵ", "ＬＩＮＣ＿契約者名（カナ）");
        exStringEquals(khLincSousinData.getLinckyknmkj(), "ユ被名　一か", "ＬＩＮＣ＿契約者名（漢字）");
        exNumericEquals(khLincSousinData.getLinckyksei(), 0, "ＬＩＮＣ＿契約者性別");
        exDateEquals(khLincSousinData.getLinckykseiymd(), BizDate.valueOf("19770101"), "ＬＩＮＣ＿契約者生年月日");
        exStringEquals(khLincSousinData.getLinckykadrkn(), "ｱｷﾀｼ ｱﾗﾔｱｻﾋﾁﾖｳ ｱｱｱｱｱｱｱｱｱｱｱｱｱｱｱ", "ＬＩＮＣ＿契約者住所（カナ）");
        exDateEquals(khLincSousinData.getLinctrkmousideymd(), BizDate.valueOf("20201214"), "ＬＩＮＣ＿登録申出年月日");
        exDateEquals(khLincSousinData.getLinckykymd(), BizDate.valueOf("20180901"), "ＬＩＮＣ＿契約年月日");
        exBizCalcbleEquals(khLincSousinData.getLinchutuusbs(), BizCurrency.valueOf(10000000), "ＬＩＮＣ＿普通死亡保険金額");
        exStringEquals(khLincSousinData.getLinckakusyasiyouran(), "99806001065                           H ", "ＬＩＮＣ＿各社使用欄");
        exStringEquals(khLincSousinData.getGyoumuKousinKinou(), "khmisyuuptorikomi", "業務用更新機能ＩＤ");
        exStringEquals(khLincSousinData.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(khLincSousinData.getGyoumuKousinTime().substring(0, 8), "20201215", "業務用更新時間");
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testExec_A7() {

        HanteiLincBean pHanteiLincBean = SWAKInjector.getInstance(HanteiLincBean.class);
        pHanteiLincBean.setSyoriYmd(BizDate.valueOf("20201214"));
        pHanteiLincBean.setKanyuusyaNo(Long.valueOf(0));

        KhozenCommonParam pKhozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        pKhozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_MSYPTORIKOMI);
        baseUserInfo.getUser().setUserId("user001");

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_BAK_KykKihon bakKykKihon = hozenDomManager.getBAKKykKihon("99806001076", "0000000010");
        pHanteiLincBean.setBakKykKihon(bakKykKihon);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001076");
        pHanteiLincBean.setKykKihon(kykKihon);

        changeSystemDate(BizDate.valueOf("20201215"));

        C_ErrorKbn errorKbn = hanteiLinc.exec(pHanteiLincBean, pKhozenCommonParam);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        IT_KykKihon kykkihon = hanteiLinc.getKykkihon();
        exDateEquals(kykkihon.getMosymd(), BizDate.valueOf("20191216"), "申込日");
        exStringEquals(kykkihon.getSyono(), "99806001076", "証券番号");
        exStringEquals(kykkihon.getSkjmosno(), "991027269", "新契約時申込番号");

        exNumericEquals(kykkihon.getKhLincSousinDatas().size(), 1, "契約保全ＬＩＮＣ送信データテーブルエンティティリストの件数");
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testExec_A8() {

        HanteiLincBean pHanteiLincBean = SWAKInjector.getInstance(HanteiLincBean.class);
        pHanteiLincBean.setSyoriYmd(BizDate.valueOf("20201215"));

        KhozenCommonParam pKhozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        pKhozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_MSYPTORIKOMI);

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_BAK_KykKihon bakKykKihon = hozenDomManager.getBAKKykKihon("99806001087", "0000000010");
        pHanteiLincBean.setBakKykKihon(bakKykKihon);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001087");
        pHanteiLincBean.setKykKihon(kykKihon);

        changeSystemDate(BizDate.valueOf("20201215"));

        C_ErrorKbn errorKbn = hanteiLinc.exec(pHanteiLincBean, pKhozenCommonParam);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        IT_KykKihon kykkihon = hanteiLinc.getKykkihon();
        exDateEquals(kykkihon.getMosymd(), BizDate.valueOf("20191216"), "申込日");
        exStringEquals(kykkihon.getSyono(), "99806001087", "証券番号");
        exStringEquals(kykkihon.getSkjmosno(), "991027277", "新契約時申込番号");

        exNumericEquals(kykkihon.getKhLincSousinDatas().size(), 0, "契約保全ＬＩＮＣ送信データテーブルエンティティリストの件数");
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testExec_A9() {

        HanteiLincBean pHanteiLincBean = SWAKInjector.getInstance(HanteiLincBean.class);
        pHanteiLincBean.setSyoriYmd(BizDate.valueOf("20201214"));

        KhozenCommonParam pKhozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        pKhozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_MSYPTORIKOMI);

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_BAK_KykKihon bakKykKihon = hozenDomManager.getBAKKykKihon("99806001098", "0000000010");
        pHanteiLincBean.setBakKykKihon(bakKykKihon);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001098");
        pHanteiLincBean.setKykKihon(kykKihon);

        changeSystemDate(BizDate.valueOf("20201215"));

        C_ErrorKbn errorKbn = hanteiLinc.exec(pHanteiLincBean, pKhozenCommonParam);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        IT_KykKihon kykkihon = hanteiLinc.getKykkihon();
        exDateEquals(kykkihon.getMosymd(), BizDate.valueOf("20191216"), "申込日");
        exStringEquals(kykkihon.getSyono(), "99806001098", "証券番号");
        exStringEquals(kykkihon.getSkjmosno(), "991027285", "新契約時申込番号");

        exNumericEquals(kykkihon.getKhLincSousinDatas().size(), 0, "契約保全ＬＩＮＣ送信データテーブルエンティティリストの件数");
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testExec_A10() {

        HanteiLincBean pHanteiLincBean = SWAKInjector.getInstance(HanteiLincBean.class);
        pHanteiLincBean.setSyoriYmd(BizDate.valueOf("20201214"));
        pHanteiLincBean.setKanyuusyaNo(Long.valueOf(0));

        KhozenCommonParam pKhozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        pKhozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_MSYPTORIKOMI);
        baseUserInfo.getUser().setUserId("user001");

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_BAK_KykKihon bakKykKihon = hozenDomManager.getBAKKykKihon("99806001102", "0000000010");
        pHanteiLincBean.setBakKykKihon(bakKykKihon);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001102");
        pHanteiLincBean.setKykKihon(kykKihon);

        changeSystemDate(BizDate.valueOf("20201215"));

        C_ErrorKbn errorKbn = hanteiLinc.exec(pHanteiLincBean, pKhozenCommonParam);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        IT_KykKihon kykkihon = hanteiLinc.getKykkihon();
        exDateEquals(kykkihon.getMosymd(), BizDate.valueOf("20191216"), "申込日");
        exStringEquals(kykkihon.getSyono(), "99806001102", "証券番号");
        exStringEquals(kykkihon.getSkjmosno(), "991027293", "新契約時申込番号");

        exNumericEquals(kykkihon.getKhLincSousinDatas().size(), 1, "契約保全ＬＩＮＣ送信データテーブルエンティティリストの件数");
        IT_KhLincSousinData khLincSousinData = kykkihon.getKhLincSousinDatas().get(0);
        exStringEquals(khLincSousinData.getMosno(), "991027293", "申込番号");
        exStringEquals(khLincSousinData.getSyono(), "99806001102", "証券番号");
        exDateEquals(khLincSousinData.getSyoriYmd(), BizDate.valueOf("20201214"), "処理年月日");
        exNumericEquals(khLincSousinData.getRenno(), 1, "連番");
        exClassificationEquals(khLincSousinData.getLincsousinkbn(), C_SousinKbn.MISOUSIN, "ＬＩＮＣ送信区分");
        exNumericEquals(khLincSousinData.getLincrecordsyubetu(), 21, "ＬＩＮＣ＿レコード種別");
        exStringEquals(khLincSousinData.getLinchenkoutype(), "D", "ＬＩＮＣ＿変更タイプ");
        exNumericEquals(khLincSousinData.getLinckanyuusyano(), 0, "ＬＩＮＣ＿加入者番号");
        exStringEquals(khLincSousinData.getLinchhknnmkn(), "ｷﾞｷﾞｷﾞｷﾞｷﾞｶﾞｶﾞｶﾞｶﾞｶﾞｶﾞｶﾞｶﾞｶﾞｶﾞｶﾞ", "ＬＩＮＣ＿被保険者名（カナ）");
        exStringEquals(khLincSousinData.getLinchhknnmkj(), "ユ被名　一こ", "ＬＩＮＣ＿被保険者名（漢字）");
        exNumericEquals(khLincSousinData.getLinchhknsei(), 2, "ＬＩＮＣ＿被保険者性別");
        exDateEquals(khLincSousinData.getLinchhknseiymd(), BizDate.valueOf("19770101"), "ＬＩＮＣ＿被保険者生年月日");
        exStringEquals(khLincSousinData.getLinchhknadrkn(), "ｱｷﾀｼ ｱﾗﾔﾃﾝﾋﾞﾝﾉ ｱｱｱｱｱｱｱｱｱｱｱｱｱｱｱ", "ＬＩＮＣ＿被保険者住所（カナ）");
        exClassificationEquals(khLincSousinData.getLinckeihidjnhyouji(), C_KykKbn.KEIHI_BETU, "ＬＩＮＣ＿契被同人表示");
        exStringEquals(khLincSousinData.getLinckyknmkn(), "ﾕﾋﾒｲ ｲﾁｵ", "ＬＩＮＣ＿契約者名（カナ）");
        exStringEquals(khLincSousinData.getLinckyknmkj(), "ユ被名　一こ", "ＬＩＮＣ＿契約者名（漢字）");
        exNumericEquals(khLincSousinData.getLinckyksei(), 1, "ＬＩＮＣ＿契約者性別");
        exDateEquals(khLincSousinData.getLinckykseiymd(), BizDate.valueOf("19770101"), "ＬＩＮＣ＿契約者生年月日");
        exStringEquals(khLincSousinData.getLinckykadrkn(), "ｱｷﾀｼ ｱﾗﾔﾃﾝﾋﾞﾝﾉ ｱｱｱｱｱｱｱｱｱｱｱｱｱｱｱ", "ＬＩＮＣ＿契約者住所（カナ）");
        exDateEquals(khLincSousinData.getLinctrkmousideymd(), BizDate.valueOf("20201214"), "ＬＩＮＣ＿登録申出年月日");
        exDateEquals(khLincSousinData.getLinckykymd(), BizDate.valueOf("20180901"), "ＬＩＮＣ＿契約年月日");
        exBizCalcbleEquals(khLincSousinData.getLinchutuusbs(), BizCurrency.valueOf(20000001), "ＬＩＮＣ＿普通死亡保険金額");
        exStringEquals(khLincSousinData.getLinckakusyasiyouran(), "99806001102                           H ", "ＬＩＮＣ＿各社使用欄");
        exStringEquals(khLincSousinData.getGyoumuKousinKinou(), "khmisyuuptorikomi", "業務用更新機能ＩＤ");
        exStringEquals(khLincSousinData.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(khLincSousinData.getGyoumuKousinTime().substring(0, 8), "20201215", "業務用更新時間");
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testExec_A11() {

        HanteiLincBean pHanteiLincBean = SWAKInjector.getInstance(HanteiLincBean.class);
        pHanteiLincBean.setSyoriYmd(BizDate.valueOf("20201214"));
        pHanteiLincBean.setKanyuusyaNo(Long.valueOf(1));

        KhozenCommonParam pKhozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        pKhozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_MSYPTORIKOMI);
        baseUserInfo.getUser().setUserId("user001");

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_BAK_KykKihon bakKykKihon = hozenDomManager.getBAKKykKihon("99806001113", "0000000010");
        pHanteiLincBean.setBakKykKihon(bakKykKihon);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001113");
        pHanteiLincBean.setKykKihon(kykKihon);

        changeSystemDate(BizDate.valueOf("20201215"));

        C_ErrorKbn errorKbn = hanteiLinc.exec(pHanteiLincBean, pKhozenCommonParam);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        IT_KykKihon kykkihon = hanteiLinc.getKykkihon();
        exDateEquals(kykkihon.getMosymd(), BizDate.valueOf("20191216"), "申込日");
        exStringEquals(kykkihon.getSyono(), "99806001113", "証券番号");
        exStringEquals(kykkihon.getSkjmosno(), "991027301", "新契約時申込番号");

        exNumericEquals(kykkihon.getKhLincSousinDatas().size(), 1, "契約保全ＬＩＮＣ送信データテーブルエンティティリストの件数");
        IT_KhLincSousinData khLincSousinData = kykkihon.getKhLincSousinDatas().get(0);
        exStringEquals(khLincSousinData.getMosno(), "991027301", "申込番号");
        exStringEquals(khLincSousinData.getSyono(), "99806001113", "証券番号");
        exDateEquals(khLincSousinData.getSyoriYmd(), BizDate.valueOf("20201214"), "処理年月日");
        exNumericEquals(khLincSousinData.getRenno(), 1, "連番");
        exClassificationEquals(khLincSousinData.getLincsousinkbn(), C_SousinKbn.SOUSINMATI, "ＬＩＮＣ送信区分");
        exNumericEquals(khLincSousinData.getLincrecordsyubetu(), 21, "ＬＩＮＣ＿レコード種別");
        exStringEquals(khLincSousinData.getLinchenkoutype(), "U", "ＬＩＮＣ＿変更タイプ");
        exNumericEquals(khLincSousinData.getLinckanyuusyano(), 1, "ＬＩＮＣ＿加入者番号");
        exStringEquals(khLincSousinData.getLinchhknnmkn(), "ﾕﾋﾒｲ ｲﾁｻ", "ＬＩＮＣ＿被保険者名（カナ）");
        exStringEquals(khLincSousinData.getLinchhknnmkj(), "ユ被名　一さ", "ＬＩＮＣ＿被保険者名（漢字）");
        exNumericEquals(khLincSousinData.getLinchhknsei(), 0, "ＬＩＮＣ＿被保険者性別");
        exDateEquals(khLincSousinData.getLinchhknseiymd(), BizDate.valueOf("19770101"), "ＬＩＮＣ＿被保険者生年月日");
        exStringEquals(khLincSousinData.getLinchhknadrkn(), "ｱｷﾀｼ ｱﾗﾔﾏﾂﾐｶﾞｵｶｷﾀﾁﾖｳ ｱｱｱｱｱｱｱｱ", "ＬＩＮＣ＿被保険者住所（カナ）");
        exClassificationEquals(khLincSousinData.getLinckeihidjnhyouji(), C_KykKbn.KEIHI_BETU, "ＬＩＮＣ＿契被同人表示");
        exStringEquals(khLincSousinData.getLinckyknmkn(), "ﾕﾋﾒｲ ｲﾁｵ", "ＬＩＮＣ＿契約者名（カナ）");
        exStringEquals(khLincSousinData.getLinckyknmkj(), "ユ被名　一さ", "ＬＩＮＣ＿契約者名（漢字）");
        exNumericEquals(khLincSousinData.getLinckyksei(), 1, "ＬＩＮＣ＿契約者性別");
        exDateEquals(khLincSousinData.getLinckykseiymd(), BizDate.valueOf("19770101"), "ＬＩＮＣ＿契約者生年月日");
        exStringEquals(khLincSousinData.getLinckykadrkn(), "ｱｷﾀｼ ｱﾗﾔﾏﾂﾐｶﾞｵｶｷﾀﾁﾖｳ ｱｱｱｱｱｱｱｱ", "ＬＩＮＣ＿契約者住所（カナ）");
        exDateEquals(khLincSousinData.getLinctrkmousideymd(), BizDate.valueOf("20201214"), "ＬＩＮＣ＿登録申出年月日");
        exDateEquals(khLincSousinData.getLinckykymd(), BizDate.valueOf("20151215"), "ＬＩＮＣ＿契約年月日");
        exBizCalcbleEquals(khLincSousinData.getLinchutuusbs(), BizCurrency.valueOf(20000001), "ＬＩＮＣ＿普通死亡保険金額");
        exStringEquals(khLincSousinData.getLinckakusyasiyouran(), "99806001113                           H ", "ＬＩＮＣ＿各社使用欄");
        exStringEquals(khLincSousinData.getGyoumuKousinKinou(), "khmisyuuptorikomi", "業務用更新機能ＩＤ");
        exStringEquals(khLincSousinData.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(khLincSousinData.getGyoumuKousinTime().substring(0, 8), "20201215", "業務用更新時間");
    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testExec_A12() {

        HanteiLincBean pHanteiLincBean = SWAKInjector.getInstance(HanteiLincBean.class);
        pHanteiLincBean.setSyoriYmd(BizDate.valueOf("20201214"));
        pHanteiLincBean.setKanyuusyaNo(Long.valueOf(1));

        KhozenCommonParam pKhozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        pKhozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_MSYPTORIKOMI);
        baseUserInfo.getUser().setUserId("user001");

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_BAK_KykKihon bakKykKihon = hozenDomManager.getBAKKykKihon("99806001124", "0000000010");
        pHanteiLincBean.setBakKykKihon(bakKykKihon);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001124");
        pHanteiLincBean.setKykKihon(kykKihon);

        changeSystemDate(BizDate.valueOf("20201215"));

        C_ErrorKbn errorKbn = hanteiLinc.exec(pHanteiLincBean, pKhozenCommonParam);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        IT_KykKihon kykkihon = hanteiLinc.getKykkihon();
        exDateEquals(kykkihon.getMosymd(), BizDate.valueOf("20191216"), "申込日");
        exStringEquals(kykkihon.getSyono(), "99806001124", "証券番号");
        exStringEquals(kykkihon.getSkjmosno(), "991027319", "新契約時申込番号");

        exNumericEquals(kykkihon.getKhLincSousinDatas().size(), 2, "契約保全ＬＩＮＣ送信データテーブルエンティティリストの件数");
        IT_KhLincSousinData khLincSousinData = kykkihon.getKhLincSousinDatas().get(1);
        exStringEquals(khLincSousinData.getMosno(), "991027319", "申込番号");
        exStringEquals(khLincSousinData.getSyono(), "99806001124", "証券番号");
        exDateEquals(khLincSousinData.getSyoriYmd(), BizDate.valueOf("20201214"), "処理年月日");
        exNumericEquals(khLincSousinData.getRenno(), 3, "連番");
        exClassificationEquals(khLincSousinData.getLincsousinkbn(), C_SousinKbn.SOUSINMATI, "ＬＩＮＣ送信区分");
        exNumericEquals(khLincSousinData.getLincrecordsyubetu(), 21, "ＬＩＮＣ＿レコード種別");
        exStringEquals(khLincSousinData.getLinchenkoutype(), "I", "ＬＩＮＣ＿変更タイプ");
        exNumericEquals(khLincSousinData.getLinckanyuusyano(), 1, "ＬＩＮＣ＿加入者番号");
        exStringEquals(khLincSousinData.getLinchhknnmkn(), "ﾕﾋﾒｲ ｲﾁｼ", "ＬＩＮＣ＿被保険者名（カナ）");
        exStringEquals(khLincSousinData.getLinchhknnmkj(), "ユ被名　一し", "ＬＩＮＣ＿被保険者名（漢字）");
        exNumericEquals(khLincSousinData.getLinchhknsei(), 2, "ＬＩＮＣ＿被保険者性別");
        exDateEquals(khLincSousinData.getLinchhknseiymd(), BizDate.valueOf("19770101"), "ＬＩＮＣ＿被保険者生年月日");
        exStringEquals(khLincSousinData.getLinchhknadrkn(), "ｱｷﾀｼ", "ＬＩＮＣ＿被保険者住所（カナ）");
        exClassificationEquals(khLincSousinData.getLinckeihidjnhyouji(), C_KykKbn.KEIHI_BETU, "ＬＩＮＣ＿契被同人表示");
        exStringEquals(khLincSousinData.getLinckyknmkn(), "ﾕﾋﾒｲ ｲﾁｵ", "ＬＩＮＣ＿契約者名（カナ）");
        exStringEquals(khLincSousinData.getLinckyknmkj(), "ユ被名　一し", "ＬＩＮＣ＿契約者名（漢字）");
        exNumericEquals(khLincSousinData.getLinckyksei(), 1, "ＬＩＮＣ＿契約者性別");
        exDateEquals(khLincSousinData.getLinckykseiymd(), BizDate.valueOf("19770101"), "ＬＩＮＣ＿契約者生年月日");
        exStringEquals(khLincSousinData.getLinckykadrkn(), "ｱｷﾀｼ", "ＬＩＮＣ＿契約者住所（カナ）");
        exDateEquals(khLincSousinData.getLinctrkmousideymd(), BizDate.valueOf("20201214"), "ＬＩＮＣ＿登録申出年月日");
        exDateEquals(khLincSousinData.getLinckykymd(), BizDate.valueOf("20151215"), "ＬＩＮＣ＿契約年月日");
        exBizCalcbleEquals(khLincSousinData.getLinchutuusbs(), BizCurrency.valueOf(20000001), "ＬＩＮＣ＿普通死亡保険金額");
        exStringEquals(khLincSousinData.getLinckakusyasiyouran(), "99806001124                           H ", "ＬＩＮＣ＿各社使用欄");
        exStringEquals(khLincSousinData.getGyoumuKousinKinou(), "khmisyuuptorikomi", "業務用更新機能ＩＤ");
        exStringEquals(khLincSousinData.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(khLincSousinData.getGyoumuKousinTime().substring(0, 8), "20201215", "業務用更新時間");
    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testExec_A13() {

        HanteiLincBean pHanteiLincBean = SWAKInjector.getInstance(HanteiLincBean.class);
        pHanteiLincBean.setSyoriYmd(BizDate.valueOf("20201214"));
        pHanteiLincBean.setKanyuusyaNo(null);

        KhozenCommonParam pKhozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        pKhozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_MSYPTORIKOMI);
        baseUserInfo.getUser().setUserId("user001");

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_BAK_KykKihon bakKykKihon = hozenDomManager.getBAKKykKihon("99806001135", "0000000010");
        pHanteiLincBean.setBakKykKihon(bakKykKihon);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001135");
        pHanteiLincBean.setKykKihon(kykKihon);

        changeSystemDate(BizDate.valueOf("20201215"));

        C_ErrorKbn errorKbn = hanteiLinc.exec(pHanteiLincBean, pKhozenCommonParam);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        IT_KykKihon kykkihon = hanteiLinc.getKykkihon();
        exDateEquals(kykkihon.getMosymd(), BizDate.valueOf("20191216"), "申込日");
        exStringEquals(kykkihon.getSyono(), "99806001135", "証券番号");
        exStringEquals(kykkihon.getSkjmosno(), "991027327", "新契約時申込番号");

        exNumericEquals(kykkihon.getKhLincSousinDatas().size(), 2, "契約保全ＬＩＮＣ送信データテーブルエンティティリストの件数");
        IT_KhLincSousinData khLincSousinData = kykkihon.getKhLincSousinDatas().get(1);
        exStringEquals(khLincSousinData.getMosno(), "991027327", "申込番号");
        exStringEquals(khLincSousinData.getSyono(), "99806001135", "証券番号");
        exDateEquals(khLincSousinData.getSyoriYmd(), BizDate.valueOf("20201214"), "処理年月日");
        exNumericEquals(khLincSousinData.getRenno(), 3, "連番");
        exClassificationEquals(khLincSousinData.getLincsousinkbn(), C_SousinKbn.MISOUSIN, "ＬＩＮＣ送信区分");
        exNumericEquals(khLincSousinData.getLincrecordsyubetu(), 21, "ＬＩＮＣ＿レコード種別");
        exStringEquals(khLincSousinData.getLinchenkoutype(), "U", "ＬＩＮＣ＿変更タイプ");
        exNumericEquals(khLincSousinData.getLinckanyuusyano(), 0, "ＬＩＮＣ＿加入者番号");
        exStringEquals(khLincSousinData.getLinchhknnmkn(), "ﾕﾋﾒｲ ｲﾁｼ", "ＬＩＮＣ＿被保険者名（カナ）");
        exStringEquals(khLincSousinData.getLinchhknnmkj(), "ユ被名　一し", "ＬＩＮＣ＿被保険者名（漢字）");
        exNumericEquals(khLincSousinData.getLinchhknsei(), 2, "ＬＩＮＣ＿被保険者性別");
        exDateEquals(khLincSousinData.getLinchhknseiymd(), BizDate.valueOf("19770101"), "ＬＩＮＣ＿被保険者生年月日");
        exStringEquals(khLincSousinData.getLinchhknadrkn(), "ｱｷﾀｼ", "ＬＩＮＣ＿被保険者住所（カナ）");
        exClassificationEquals(khLincSousinData.getLinckeihidjnhyouji(), C_KykKbn.KEIHI_BETU, "ＬＩＮＣ＿契被同人表示");
        exStringEquals(khLincSousinData.getLinckyknmkn(), "ﾕﾋﾒｲ ｲﾁｵ", "ＬＩＮＣ＿契約者名（カナ）");
        exStringEquals(khLincSousinData.getLinckyknmkj(), "ユ被名　一し", "ＬＩＮＣ＿契約者名（漢字）");
        exNumericEquals(khLincSousinData.getLinckyksei(), 1, "ＬＩＮＣ＿契約者性別");
        exDateEquals(khLincSousinData.getLinckykseiymd(), BizDate.valueOf("19770101"), "ＬＩＮＣ＿契約者生年月日");
        exStringEquals(khLincSousinData.getLinckykadrkn(), "ｱｷﾀｼ", "ＬＩＮＣ＿契約者住所（カナ）");
        exDateEquals(khLincSousinData.getLinctrkmousideymd(), BizDate.valueOf("20201214"), "ＬＩＮＣ＿登録申出年月日");
        exDateEquals(khLincSousinData.getLinckykymd(), BizDate.valueOf("20151215"), "ＬＩＮＣ＿契約年月日");
        exBizCalcbleEquals(khLincSousinData.getLinchutuusbs(), BizCurrency.valueOf(20000001), "ＬＩＮＣ＿普通死亡保険金額");
        exStringEquals(khLincSousinData.getLinckakusyasiyouran(), "99806001135                           H ", "ＬＩＮＣ＿各社使用欄");
        exStringEquals(khLincSousinData.getGyoumuKousinKinou(), "khmisyuuptorikomi", "業務用更新機能ＩＤ");
        exStringEquals(khLincSousinData.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(khLincSousinData.getGyoumuKousinTime().substring(0, 8), "20201215", "業務用更新時間");
    }

    @Test
    @TestOrder(140)
    @Transactional
    public void testExec_A14() {

        HanteiLincBean pHanteiLincBean = SWAKInjector.getInstance(HanteiLincBean.class);
        pHanteiLincBean.setSyoriYmd(BizDate.valueOf("20201214"));
        pHanteiLincBean.setKanyuusyaNo(Long.valueOf(1));

        KhozenCommonParam pKhozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        pKhozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_MSYPTORIKOMI);
        baseUserInfo.getUser().setUserId("user001");

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_BAK_KykKihon bakKykKihon = hozenDomManager.getBAKKykKihon("99806001146", "0000000010");
        pHanteiLincBean.setBakKykKihon(bakKykKihon);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001146");
        pHanteiLincBean.setKykKihon(kykKihon);

        changeSystemDate(BizDate.valueOf("20201215"));

        C_ErrorKbn errorKbn = hanteiLinc.exec(pHanteiLincBean, pKhozenCommonParam);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        IT_KykKihon kykkihon = hanteiLinc.getKykkihon();
        exDateEquals(kykkihon.getMosymd(), BizDate.valueOf("20191216"), "申込日");
        exStringEquals(kykkihon.getSyono(), "99806001146", "証券番号");
        exStringEquals(kykkihon.getSkjmosno(), "991027335", "新契約時申込番号");

        exNumericEquals(kykkihon.getKhLincSousinDatas().size(), 2, "契約保全ＬＩＮＣ送信データテーブルエンティティリストの件数");
        IT_KhLincSousinData khLincSousinData = kykkihon.getKhLincSousinDatas().get(1);
        exStringEquals(khLincSousinData.getMosno(), "991027335", "申込番号");
        exStringEquals(khLincSousinData.getSyono(), "99806001146", "証券番号");
        exDateEquals(khLincSousinData.getSyoriYmd(), BizDate.valueOf("20201214"), "処理年月日");
        exNumericEquals(khLincSousinData.getRenno(), 3, "連番");
        exClassificationEquals(khLincSousinData.getLincsousinkbn(), C_SousinKbn.SOUSINMATI, "ＬＩＮＣ送信区分");
        exNumericEquals(khLincSousinData.getLincrecordsyubetu(), 21, "ＬＩＮＣ＿レコード種別");
        exStringEquals(khLincSousinData.getLinchenkoutype(), "U", "ＬＩＮＣ＿変更タイプ");
        exNumericEquals(khLincSousinData.getLinckanyuusyano(), 1, "ＬＩＮＣ＿加入者番号");
        exStringEquals(khLincSousinData.getLinchhknnmkn(), "ﾕﾋﾒｲ ｲﾁｼ", "ＬＩＮＣ＿被保険者名（カナ）");
        exStringEquals(khLincSousinData.getLinchhknnmkj(), "ユ被名　一し", "ＬＩＮＣ＿被保険者名（漢字）");
        exNumericEquals(khLincSousinData.getLinchhknsei(), 2, "ＬＩＮＣ＿被保険者性別");
        exDateEquals(khLincSousinData.getLinchhknseiymd(), BizDate.valueOf("19770101"), "ＬＩＮＣ＿被保険者生年月日");
        exStringEquals(khLincSousinData.getLinchhknadrkn(), "ｱｷﾀｼ", "ＬＩＮＣ＿被保険者住所（カナ）");
        exClassificationEquals(khLincSousinData.getLinckeihidjnhyouji(), C_KykKbn.KEIHI_BETU, "ＬＩＮＣ＿契被同人表示");
        exStringEquals(khLincSousinData.getLinckyknmkn(), "ﾕﾋﾒｲ ｲﾁｵ", "ＬＩＮＣ＿契約者名（カナ）");
        exStringEquals(khLincSousinData.getLinckyknmkj(), "ユ被名　一し", "ＬＩＮＣ＿契約者名（漢字）");
        exNumericEquals(khLincSousinData.getLinckyksei(), 1, "ＬＩＮＣ＿契約者性別");
        exDateEquals(khLincSousinData.getLinckykseiymd(), BizDate.valueOf("19770101"), "ＬＩＮＣ＿契約者生年月日");
        exStringEquals(khLincSousinData.getLinckykadrkn(), "ｱｷﾀｼ", "ＬＩＮＣ＿契約者住所（カナ）");
        exDateEquals(khLincSousinData.getLinctrkmousideymd(), BizDate.valueOf("20201214"), "ＬＩＮＣ＿登録申出年月日");
        exDateEquals(khLincSousinData.getLinckykymd(), BizDate.valueOf("20151215"), "ＬＩＮＣ＿契約年月日");
        exBizCalcbleEquals(khLincSousinData.getLinchutuusbs(), BizCurrency.valueOf(20000001), "ＬＩＮＣ＿普通死亡保険金額");
        exStringEquals(khLincSousinData.getLinckakusyasiyouran(), "99806001146                           H ", "ＬＩＮＣ＿各社使用欄");
        exStringEquals(khLincSousinData.getGyoumuKousinKinou(), "khmisyuuptorikomi", "業務用更新機能ＩＤ");
        exStringEquals(khLincSousinData.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(khLincSousinData.getGyoumuKousinTime().substring(0, 8), "20201215", "業務用更新時間");
    }

    @Test
    @TestOrder(150)
    @Transactional
    public void testExec_A15() {

        HanteiLincBean pHanteiLincBean = SWAKInjector.getInstance(HanteiLincBean.class);
        pHanteiLincBean.setSyoriYmd(BizDate.valueOf("20201214"));
        pHanteiLincBean.setKanyuusyaNo(Long.valueOf(1));

        KhozenCommonParam pKhozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        pKhozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);

        baseUserInfo.getUser().setUserId("user001");

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001157");
        pHanteiLincBean.setKykKihon(kykKihon);

        changeSystemDate(BizDate.valueOf("20201215"));

        C_ErrorKbn errorKbn = hanteiLinc.exec(pHanteiLincBean, pKhozenCommonParam);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        IT_KykKihon kykkihon = hanteiLinc.getKykkihon();
        exDateEquals(kykkihon.getMosymd(), BizDate.valueOf("20191216"), "申込日");
        exStringEquals(kykkihon.getSyono(), "99806001157", "証券番号");
        exStringEquals(kykkihon.getSkjmosno(), "991027343", "新契約時申込番号");

        exNumericEquals(kykkihon.getKhLincSousinDatas().size(), 1, "契約保全ＬＩＮＣ送信データテーブルエンティティリストの件数");
        IT_KhLincSousinData khLincSousinData = kykkihon.getKhLincSousinDatas().get(0);
        exStringEquals(khLincSousinData.getMosno(), "991027343", "申込番号");
        exStringEquals(khLincSousinData.getSyono(), "99806001157", "証券番号");
        exDateEquals(khLincSousinData.getSyoriYmd(), BizDate.valueOf("20201214"), "処理年月日");
        exNumericEquals(khLincSousinData.getRenno(), 1, "連番");
        exClassificationEquals(khLincSousinData.getLincsousinkbn(), C_SousinKbn.SOUSINMATI, "ＬＩＮＣ送信区分");
        exNumericEquals(khLincSousinData.getLincrecordsyubetu(), 3, "ＬＩＮＣ＿レコード種別");
        exStringEquals(khLincSousinData.getLinchenkoutype(), "", "ＬＩＮＣ＿変更タイプ");
        exNumericEquals(khLincSousinData.getLinckanyuusyano(), 1, "ＬＩＮＣ＿加入者番号");
        exStringEquals(khLincSousinData.getLinchhknnmkn(), "ﾕﾋﾒｲ ｲﾁｼ", "ＬＩＮＣ＿被保険者名（カナ）");
        exStringEquals(khLincSousinData.getLinchhknnmkj(), "ユ被名　一し", "ＬＩＮＣ＿被保険者名（漢字）");
        exNumericEquals(khLincSousinData.getLinchhknsei(), 2, "ＬＩＮＣ＿被保険者性別");
        exDateEquals(khLincSousinData.getLinchhknseiymd(), BizDate.valueOf("19770101"), "ＬＩＮＣ＿被保険者生年月日");
        exStringEquals(khLincSousinData.getLinchhknadrkn(), "ｱｷﾀｼ", "ＬＩＮＣ＿被保険者住所（カナ）");
        exClassificationEquals(khLincSousinData.getLinckeihidjnhyouji(), C_KykKbn.KEIHI_BETU, "ＬＩＮＣ＿契被同人表示");
        exStringEquals(khLincSousinData.getLinckyknmkn(), "ﾕﾋﾒｲ ｲﾁｵ", "ＬＩＮＣ＿契約者名（カナ）");
        exStringEquals(khLincSousinData.getLinckyknmkj(), "ユ被名　一し", "ＬＩＮＣ＿契約者名（漢字）");
        exNumericEquals(khLincSousinData.getLinckyksei(), 1, "ＬＩＮＣ＿契約者性別");
        exDateEquals(khLincSousinData.getLinckykseiymd(), BizDate.valueOf("19770101"), "ＬＩＮＣ＿契約者生年月日");
        exStringEquals(khLincSousinData.getLinckykadrkn(), "ｱｷﾀｼ", "ＬＩＮＣ＿契約者住所（カナ）");
        exDateEquals(khLincSousinData.getLinctrkmousideymd(), BizDate.valueOf("20201214"), "ＬＩＮＣ＿登録申出年月日");
        exDateEquals(khLincSousinData.getLinckykymd(), BizDate.valueOf("20151215"), "ＬＩＮＣ＿契約年月日");
        exBizCalcbleEquals(khLincSousinData.getLinchutuusbs(), BizCurrency.valueOf(20000001), "ＬＩＮＣ＿普通死亡保険金額");
        exStringEquals(khLincSousinData.getLinckakusyasiyouran(), "99806001157991027343                  HS", "ＬＩＮＣ＿各社使用欄");
        exStringEquals(khLincSousinData.getGyoumuKousinKinou(), "khkeiyakuinfotorikomi", "業務用更新機能ＩＤ");
        exStringEquals(khLincSousinData.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(khLincSousinData.getGyoumuKousinTime().substring(0, 8), "20201215", "業務用更新時間");
    }

    @Test
    @TestOrder(160)
    @Transactional
    public void testExec_A16() {

        HanteiLincBean pHanteiLincBean = SWAKInjector.getInstance(HanteiLincBean.class);
        pHanteiLincBean.setSyoriYmd(BizDate.valueOf("20201214"));
        pHanteiLincBean.setKanyuusyaNo(Long.valueOf(1));

        KhozenCommonParam pKhozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        pKhozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_SEINENGAPPISEI);
        baseUserInfo.getUser().setUserId("user001");

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_BAK_KykKihon bakKykKihon = hozenDomManager.getBAKKykKihon("99806001168", "0000000010");
        pHanteiLincBean.setBakKykKihon(bakKykKihon);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001168");
        pHanteiLincBean.setKykKihon(kykKihon);

        changeSystemDate(BizDate.valueOf("20201215"));

        C_ErrorKbn errorKbn = hanteiLinc.exec(pHanteiLincBean, pKhozenCommonParam);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        IT_KykKihon kykkihon = hanteiLinc.getKykkihon();
        exDateEquals(kykkihon.getMosymd(), BizDate.valueOf("20191216"), "申込日");
        exStringEquals(kykkihon.getSyono(), "99806001168", "証券番号");
        exStringEquals(kykkihon.getSkjmosno(), "991027301", "新契約時申込番号");
        exNumericEquals(kykkihon.getKhLincSousinDatas().size(), 1, "契約保全ＬＩＮＣ送信データテーブルエンティティリストの件数");
        IT_KhLincSousinData khLincSousinData = kykkihon.getKhLincSousinDatas().get(0);
        exStringEquals(khLincSousinData.getMosno(), "991027301", "申込番号");
        exStringEquals(khLincSousinData.getSyono(), "99806001168", "証券番号");
        exDateEquals(khLincSousinData.getSyoriYmd(), BizDate.valueOf("20201214"), "処理年月日");
        exNumericEquals(khLincSousinData.getRenno(), 1, "連番");
        exClassificationEquals(khLincSousinData.getLincsousinkbn(), C_SousinKbn.SOUSINMATI, "ＬＩＮＣ送信区分");
        exNumericEquals(khLincSousinData.getLincrecordsyubetu(), 21, "ＬＩＮＣ＿レコード種別");
        exStringEquals(khLincSousinData.getLinchenkoutype(), "U", "ＬＩＮＣ＿変更タイプ");
        exNumericEquals(khLincSousinData.getLinckanyuusyano(), 1, "ＬＩＮＣ＿加入者番号");
        exStringEquals(khLincSousinData.getLinchhknnmkn(), "ﾕﾋﾒｲ ｲﾁｻ", "ＬＩＮＣ＿被保険者名（カナ）");
        exStringEquals(khLincSousinData.getLinchhknnmkj(), "ユ被名　一さ", "ＬＩＮＣ＿被保険者名（漢字）");
        exNumericEquals(khLincSousinData.getLinchhknsei(), 0, "ＬＩＮＣ＿被保険者性別");
        exDateEquals(khLincSousinData.getLinchhknseiymd(), BizDate.valueOf("19770101"), "ＬＩＮＣ＿被保険者生年月日");
        exStringEquals(khLincSousinData.getLinchhknadrkn(), "", "ＬＩＮＣ＿被保険者住所（カナ）");
        exClassificationEquals(khLincSousinData.getLinckeihidjnhyouji(), C_KykKbn.KEIHI_BETU, "ＬＩＮＣ＿契被同人表示");
        exStringEquals(khLincSousinData.getLinckyknmkn(), "ﾕﾋﾒｲ ｲﾁｵ", "ＬＩＮＣ＿契約者名（カナ）");
        exStringEquals(khLincSousinData.getLinckyknmkj(), "ユ被名　一さ", "ＬＩＮＣ＿契約者名（漢字）");
        exNumericEquals(khLincSousinData.getLinckyksei(), 1, "ＬＩＮＣ＿契約者性別");
        exDateEquals(khLincSousinData.getLinckykseiymd(), BizDate.valueOf("19770101"), "ＬＩＮＣ＿契約者生年月日");
        exStringEquals(khLincSousinData.getLinckykadrkn(), "", "ＬＩＮＣ＿契約者住所（カナ）");
        exDateEquals(khLincSousinData.getLinctrkmousideymd(), BizDate.valueOf("20201214"), "ＬＩＮＣ＿登録申出年月日");
        exDateEquals(khLincSousinData.getLinckykymd(), BizDate.valueOf("20151215"), "ＬＩＮＣ＿契約年月日");
        exBizCalcbleEquals(khLincSousinData.getLinchutuusbs(), BizCurrency.valueOf(20000001), "ＬＩＮＣ＿普通死亡保険金額");
        exStringEquals(khLincSousinData.getLinckakusyasiyouran(), "99806001168                           H ", "ＬＩＮＣ＿各社使用欄");
        exStringEquals(khLincSousinData.getGyoumuKousinKinou(), "khseinengappiseiteisei", "業務用更新機能ＩＤ");
        exStringEquals(khLincSousinData.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(khLincSousinData.getGyoumuKousinTime().substring(0, 8), "20201215", "業務用更新時間");
    }
}
