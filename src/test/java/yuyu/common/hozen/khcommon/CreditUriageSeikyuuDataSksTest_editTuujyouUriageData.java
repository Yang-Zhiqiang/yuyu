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
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.base.BaseUserInfo;
import yuyu.def.classification.C_AuthoriKbn;
import yuyu.def.classification.C_CreditUriageSeikyuuKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_AnsyuRireki;
import yuyu.def.db.entity.IT_UriageSeikyuuData;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全 契約保全共通 クレカ売上請求データ作成のメソッド {@link CreditUriageSeikyuuDataSks
 * #editTuujyouUriageData(KhozenCommonParam,UriageSeikyuuDataSksParam)}
 * テスト用クラスです<br />
 */
@RunWith(SWAKTestRunner.class)
public class CreditUriageSeikyuuDataSksTest_editTuujyouUriageData extends AbstractTest{

    @Inject
    CreditUriageSeikyuuDataSks creditUriageSeikyuuDataSks;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_クレカ売上請求データ作成";
    private final static String sheetName = "INデータ";

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    BaseUserInfo baseUserInfo;

    @Inject
    private AS_Kinou asKinou;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(CreditUriageSeikyuuDataSksTest_editTuujyouUriageData.class, fileName, sheetName);

            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllAnsyuKihon());

    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        String syoNo = "99806031307";

        String gyoumuKousinTime = BizDate.getSysDateTimeMilli();
        asKinou.setKinouId("CreditUriageSeikyuuDataSks");
        baseUserInfo.getUser().setUserId("JUnit");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        UriageSeikyuuDataSksParam uriageSeikyuuDataSksParam = SWAKInjector.getInstance(UriageSeikyuuDataSksParam.class);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo);
        IT_AnsyuRireki ansyuRirek = ansyuKihon.getAnsyuRirekis().get(0);

        uriageSeikyuuDataSksParam.setAnsyuKihonTblentity(ansyuKihon);
        uriageSeikyuuDataSksParam.setAnsyuRirekiTblentity(ansyuRirek);
        uriageSeikyuuDataSksParam.setKessaiyouno("00000000001");
        uriageSeikyuuDataSksParam.setUriagenengappi(BizDate.valueOf(20181015));
        uriageSeikyuuDataSksParam.setSyoriYmd(BizDate.valueOf(20181016));
        uriageSeikyuuDataSksParam.setUriagegk(BizCurrency.valueOf(100001));

        IT_UriageSeikyuuData uriageSeikyuuData =  creditUriageSeikyuuDataSks.editTuujyouUriageData(khozenCommonParam,
            uriageSeikyuuDataSksParam);

        exStringEquals(uriageSeikyuuData.getSyono(),"99806031307","証券番号");
        exStringEquals(uriageSeikyuuData.getCreditkessaiyouno(),"00000000001","クレジットカード決済用番号");
        exDateEquals(uriageSeikyuuData.getUriagenengappi(),BizDate.valueOf(20181015),"売上年月日");
        exNumericEquals(uriageSeikyuuData.getRenno3keta(),1,"連番（３桁）");
        exStringEquals(uriageSeikyuuData.getRecordno(),"01","レコード番号");
        exDateEquals(uriageSeikyuuData.getSyoriYmd(), BizDate.valueOf(20181016), "処理年月日");
        exClassificationEquals(uriageSeikyuuData.getCredituriageseikyuukbn(), C_CreditUriageSeikyuuKbn.TUUJYOU, "クレジットカード売上請求区分");
        exClassificationEquals(uriageSeikyuuData.getAuthorikbn(),C_AuthoriKbn.AUTHORIJISSI , "オーソリ区分");
        exBizCalcbleEquals(uriageSeikyuuData.getCredituriagegk(), BizCurrency.valueOf(100001), "クレジットカード売上金額");
        exStringEquals(uriageSeikyuuData.getFukusuukameitennokey(),"1200010","複数加盟店番号設定キー情報");
        exDateYMEquals(uriageSeikyuuData.getJyuutouym(),BizDateYM.valueOf(2019, 02),"充当年月");
        exNumericEquals(uriageSeikyuuData.getJyutoukaisuuy(),18,"充当回数（年）");
        exNumericEquals(uriageSeikyuuData.getJyutoukaisuum(),3,"充当回数（月）");
        exClassificationEquals(uriageSeikyuuData.getHrkkaisuu(), C_Hrkkaisuu.BLNK, "払込回数");
        exClassificationEquals(uriageSeikyuuData.getTikiktbrisyuruikbn(),C_TkiktbrisyuruiKbn.NONE,"定期一括払種類区分");
        exClassificationEquals(uriageSeikyuuData.getNyknaiyoukbn(), C_NyknaiyouKbn.ZENNOUP, "入金内容区分");
        exNumericEquals(uriageSeikyuuData.getAnnaino(), 1, "案内番号");
        exStringEquals(uriageSeikyuuData.getGyoumuKousinKinou(),"CreditUriageSeikyuuDataSks","業務用更新機能ID");
        exStringEquals(uriageSeikyuuData.getGyoumuKousinsyaId(),"JUnit","業務用更新者ID");
        exStringEquals(uriageSeikyuuData.getGyoumuKousinTime().substring(0, 8), gyoumuKousinTime.substring(0, 8),
            "業務用更新時間");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        String syoNo = "99806027230";

        String gyoumuKousinTime = BizDate.getSysDateTimeMilli();
        asKinou.setKinouId("CreditUriageSeikyuuDataSks");
        baseUserInfo.getUser().setUserId("JUnit");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        UriageSeikyuuDataSksParam uriageSeikyuuDataSksParam = SWAKInjector.getInstance(UriageSeikyuuDataSksParam.class);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo);
        IT_AnsyuRireki ansyuRirek = ansyuKihon.getAnsyuRirekis().get(0);

        uriageSeikyuuDataSksParam.setAnsyuKihonTblentity(ansyuKihon);
        uriageSeikyuuDataSksParam.setAnsyuRirekiTblentity(ansyuRirek);
        uriageSeikyuuDataSksParam.setKessaiyouno("00000000002");
        uriageSeikyuuDataSksParam.setUriagenengappi(BizDate.valueOf(20181016));
        uriageSeikyuuDataSksParam.setSyoriYmd(BizDate.valueOf(20181017));
        uriageSeikyuuDataSksParam.setUriagegk(BizCurrency.valueOf(100002));

        IT_UriageSeikyuuData uriageSeikyuuData =  creditUriageSeikyuuDataSks.editTuujyouUriageData(khozenCommonParam,
            uriageSeikyuuDataSksParam);

        exStringEquals(uriageSeikyuuData.getSyono(),"99806027230","証券番号");
        exStringEquals(uriageSeikyuuData.getCreditkessaiyouno(),"00000000002","クレジットカード決済用番号");
        exDateEquals(uriageSeikyuuData.getUriagenengappi(),BizDate.valueOf(20181016),"売上年月日");
        exNumericEquals(uriageSeikyuuData.getRenno3keta(),1,"連番（３桁）");
        exStringEquals(uriageSeikyuuData.getRecordno(),"01","レコード番号");
        exDateEquals(uriageSeikyuuData.getSyoriYmd(), BizDate.valueOf(20181017), "処理年月日");
        exClassificationEquals(uriageSeikyuuData.getCredituriageseikyuukbn(), C_CreditUriageSeikyuuKbn.TUUJYOU, "クレジットカード売上請求区分");
        exClassificationEquals(uriageSeikyuuData.getAuthorikbn(),C_AuthoriKbn.AUTHORIJISSI , "オーソリ区分");
        exBizCalcbleEquals(uriageSeikyuuData.getCredituriagegk(), BizCurrency.valueOf(100002), "クレジットカード売上金額");
        exStringEquals(uriageSeikyuuData.getFukusuukameitennokey(),"1200010","複数加盟店番号設定キー情報");
        exDateYMEquals(uriageSeikyuuData.getJyuutouym(),BizDateYM.valueOf(2019, 03),"充当年月");
        exNumericEquals(uriageSeikyuuData.getJyutoukaisuuy(),19,"充当回数（年）");
        exNumericEquals(uriageSeikyuuData.getJyutoukaisuum(),4,"充当回数（月）");
        exClassificationEquals(uriageSeikyuuData.getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exClassificationEquals(uriageSeikyuuData.getTikiktbrisyuruikbn(),C_TkiktbrisyuruiKbn.TEIKI_6MONTHS,"定期一括払種類区分");
        exClassificationEquals(uriageSeikyuuData.getNyknaiyoukbn(), C_NyknaiyouKbn.HENKOUGOP, "入金内容区分");
        exNumericEquals(uriageSeikyuuData.getAnnaino(), 2, "案内番号");
        exStringEquals(uriageSeikyuuData.getGyoumuKousinKinou(),"CreditUriageSeikyuuDataSks","業務用更新機能ID");
        exStringEquals(uriageSeikyuuData.getGyoumuKousinsyaId(),"JUnit","業務用更新者ID");
        exStringEquals(uriageSeikyuuData.getGyoumuKousinTime().substring(0, 8), gyoumuKousinTime.substring(0, 8),
            "業務用更新時間");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        String syoNo = "99806031341";

        String gyoumuKousinTime = BizDate.getSysDateTimeMilli();
        asKinou.setKinouId("CreditUriageSeikyuuDataSks");
        baseUserInfo.getUser().setUserId("JUnit");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        UriageSeikyuuDataSksParam uriageSeikyuuDataSksParam = SWAKInjector.getInstance(UriageSeikyuuDataSksParam.class);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo);
        IT_AnsyuRireki ansyuRirek = ansyuKihon.getAnsyuRirekis().get(0);

        uriageSeikyuuDataSksParam.setAnsyuKihonTblentity(ansyuKihon);
        uriageSeikyuuDataSksParam.setAnsyuRirekiTblentity(ansyuRirek);
        uriageSeikyuuDataSksParam.setKessaiyouno("00000000003");
        uriageSeikyuuDataSksParam.setUriagenengappi(BizDate.valueOf(20181017));
        uriageSeikyuuDataSksParam.setSyoriYmd(BizDate.valueOf(20181018));
        uriageSeikyuuDataSksParam.setUriagegk(BizCurrency.valueOf(100003));

        IT_UriageSeikyuuData uriageSeikyuuData =  creditUriageSeikyuuDataSks.editTuujyouUriageData(khozenCommonParam,
            uriageSeikyuuDataSksParam);

        exStringEquals(uriageSeikyuuData.getSyono(),"99806031341","証券番号");
        exStringEquals(uriageSeikyuuData.getCreditkessaiyouno(),"00000000003","クレジットカード決済用番号");
        exDateEquals(uriageSeikyuuData.getUriagenengappi(),BizDate.valueOf(20181017),"売上年月日");
        exNumericEquals(uriageSeikyuuData.getRenno3keta(),1,"連番（３桁）");
        exStringEquals(uriageSeikyuuData.getRecordno(),"01","レコード番号");
        exDateEquals(uriageSeikyuuData.getSyoriYmd(), BizDate.valueOf(20181018), "処理年月日");
        exClassificationEquals(uriageSeikyuuData.getCredituriageseikyuukbn(), C_CreditUriageSeikyuuKbn.TUUJYOU, "クレジットカード売上請求区分");
        exClassificationEquals(uriageSeikyuuData.getAuthorikbn(),C_AuthoriKbn.AUTHORIJISSI , "オーソリ区分");
        exBizCalcbleEquals(uriageSeikyuuData.getCredituriagegk(), BizCurrency.valueOf(100003), "クレジットカード売上金額");
        exStringEquals(uriageSeikyuuData.getFukusuukameitennokey(),"1200010","複数加盟店番号設定キー情報");
        exDateYMEquals(uriageSeikyuuData.getJyuutouym(),BizDateYM.valueOf(2019, 04),"充当年月");
        exNumericEquals(uriageSeikyuuData.getJyutoukaisuuy(),20,"充当回数（年）");
        exNumericEquals(uriageSeikyuuData.getJyutoukaisuum(),5,"充当回数（月）");
        exClassificationEquals(uriageSeikyuuData.getHrkkaisuu(), C_Hrkkaisuu.HALFY, "払込回数");
        exClassificationEquals(uriageSeikyuuData.getTikiktbrisyuruikbn(),C_TkiktbrisyuruiKbn.TEIKI_12MONTHS,"定期一括払種類区分");
        exClassificationEquals(uriageSeikyuuData.getNyknaiyoukbn(), C_NyknaiyouKbn.HUKKATUYOUP, "入金内容区分");
        exNumericEquals(uriageSeikyuuData.getAnnaino(), 3, "案内番号");
        exStringEquals(uriageSeikyuuData.getGyoumuKousinKinou(),"CreditUriageSeikyuuDataSks","業務用更新機能ID");
        exStringEquals(uriageSeikyuuData.getGyoumuKousinsyaId(),"JUnit","業務用更新者ID");
        exStringEquals(uriageSeikyuuData.getGyoumuKousinTime().substring(0, 8), gyoumuKousinTime.substring(0, 8),
            "業務用更新時間");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        String syoNo = "99806031259";

        String gyoumuKousinTime = BizDate.getSysDateTimeMilli();
        asKinou.setKinouId("CreditUriageSeikyuuDataSks");
        baseUserInfo.getUser().setUserId("JUnit");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        UriageSeikyuuDataSksParam uriageSeikyuuDataSksParam = SWAKInjector.getInstance(UriageSeikyuuDataSksParam.class);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo);
        IT_AnsyuRireki ansyuRirek = ansyuKihon.getAnsyuRirekis().get(0);

        uriageSeikyuuDataSksParam.setAnsyuKihonTblentity(ansyuKihon);
        uriageSeikyuuDataSksParam.setAnsyuRirekiTblentity(ansyuRirek);
        uriageSeikyuuDataSksParam.setKessaiyouno("00000000004");
        uriageSeikyuuDataSksParam.setUriagenengappi(BizDate.valueOf(20181018));
        uriageSeikyuuDataSksParam.setSyoriYmd(BizDate.valueOf(20181019));
        uriageSeikyuuDataSksParam.setUriagegk(BizCurrency.valueOf(100000));

        IT_UriageSeikyuuData uriageSeikyuuData =  creditUriageSeikyuuDataSks.editTuujyouUriageData(khozenCommonParam,
            uriageSeikyuuDataSksParam);

        exStringEquals(uriageSeikyuuData.getSyono(),"99806031259","証券番号");
        exStringEquals(uriageSeikyuuData.getCreditkessaiyouno(),"00000000004","クレジットカード決済用番号");
        exDateEquals(uriageSeikyuuData.getUriagenengappi(),BizDate.valueOf(20181018),"売上年月日");
        exNumericEquals(uriageSeikyuuData.getRenno3keta(),2,"連番（３桁）");
        exStringEquals(uriageSeikyuuData.getRecordno(),"01","レコード番号");
        exDateEquals(uriageSeikyuuData.getSyoriYmd(), BizDate.valueOf(20181019), "処理年月日");
        exClassificationEquals(uriageSeikyuuData.getCredituriageseikyuukbn(), C_CreditUriageSeikyuuKbn.TUUJYOU, "クレジットカード売上請求区分");
        exClassificationEquals(uriageSeikyuuData.getAuthorikbn(),C_AuthoriKbn.AUTHORINASI , "オーソリ区分");
        exBizCalcbleEquals(uriageSeikyuuData.getCredituriagegk(), BizCurrency.valueOf(100000), "クレジットカード売上金額");
        exStringEquals(uriageSeikyuuData.getFukusuukameitennokey(),"1200010","複数加盟店番号設定キー情報");
        exDateYMEquals(uriageSeikyuuData.getJyuutouym(),BizDateYM.valueOf(2019, 05),"充当年月");
        exNumericEquals(uriageSeikyuuData.getJyutoukaisuuy(),21,"充当回数（年）");
        exNumericEquals(uriageSeikyuuData.getJyutoukaisuum(),6,"充当回数（月）");
        exClassificationEquals(uriageSeikyuuData.getHrkkaisuu(), C_Hrkkaisuu.NEN, "払込回数");
        exClassificationEquals(uriageSeikyuuData.getTikiktbrisyuruikbn(),C_TkiktbrisyuruiKbn.BLNK,"定期一括払種類区分");
        exClassificationEquals(uriageSeikyuuData.getNyknaiyoukbn(), C_NyknaiyouKbn.SYOKAIP, "入金内容区分");
        exNumericEquals(uriageSeikyuuData.getAnnaino(), 4, "案内番号");
        exStringEquals(uriageSeikyuuData.getGyoumuKousinKinou(),"CreditUriageSeikyuuDataSks","業務用更新機能ID");
        exStringEquals(uriageSeikyuuData.getGyoumuKousinsyaId(),"JUnit","業務用更新者ID");
        exStringEquals(uriageSeikyuuData.getGyoumuKousinTime().substring(0, 8), gyoumuKousinTime.substring(0, 8),
            "業務用更新時間");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        String syoNo = "99806027274";

        String gyoumuKousinTime = BizDate.getSysDateTimeMilli();
        asKinou.setKinouId("CreditUriageSeikyuuDataSks");
        baseUserInfo.getUser().setUserId("JUnit");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        UriageSeikyuuDataSksParam uriageSeikyuuDataSksParam = SWAKInjector.getInstance(UriageSeikyuuDataSksParam.class);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo);
        IT_AnsyuRireki ansyuRirek = ansyuKihon.getAnsyuRirekis().get(0);

        uriageSeikyuuDataSksParam.setAnsyuKihonTblentity(ansyuKihon);
        uriageSeikyuuDataSksParam.setAnsyuRirekiTblentity(ansyuRirek);
        uriageSeikyuuDataSksParam.setKessaiyouno("00000000005");
        uriageSeikyuuDataSksParam.setUriagenengappi(BizDate.valueOf(20181019));
        uriageSeikyuuDataSksParam.setSyoriYmd(BizDate.valueOf(20181020));
        uriageSeikyuuDataSksParam.setUriagegk(BizCurrency.valueOf(99999));

        IT_UriageSeikyuuData uriageSeikyuuData =  creditUriageSeikyuuDataSks.editTuujyouUriageData(khozenCommonParam,
            uriageSeikyuuDataSksParam);

        exStringEquals(uriageSeikyuuData.getSyono(),"99806027274","証券番号");
        exStringEquals(uriageSeikyuuData.getCreditkessaiyouno(),"00000000005","クレジットカード決済用番号");
        exDateEquals(uriageSeikyuuData.getUriagenengappi(),BizDate.valueOf(20181019),"売上年月日");
        exNumericEquals(uriageSeikyuuData.getRenno3keta(),4,"連番（３桁）");
        exStringEquals(uriageSeikyuuData.getRecordno(),"04","レコード番号");
        exDateEquals(uriageSeikyuuData.getSyoriYmd(), BizDate.valueOf(20181020), "処理年月日");
        exClassificationEquals(uriageSeikyuuData.getCredituriageseikyuukbn(), C_CreditUriageSeikyuuKbn.TUUJYOU, "クレジットカード売上請求区分");
        exClassificationEquals(uriageSeikyuuData.getAuthorikbn(),C_AuthoriKbn.AUTHORINASI , "オーソリ区分");
        exBizCalcbleEquals(uriageSeikyuuData.getCredituriagegk(), BizCurrency.valueOf(99999), "クレジットカード売上金額");
        exStringEquals(uriageSeikyuuData.getFukusuukameitennokey(),"1200010","複数加盟店番号設定キー情報");
        exDateYMEquals(uriageSeikyuuData.getJyuutouym(),BizDateYM.valueOf(2019, 06),"充当年月");
        exNumericEquals(uriageSeikyuuData.getJyutoukaisuuy(),22,"充当回数（年）");
        exNumericEquals(uriageSeikyuuData.getJyutoukaisuum(),7,"充当回数（月）");
        exClassificationEquals(uriageSeikyuuData.getHrkkaisuu(), C_Hrkkaisuu.BLNK, "払込回数");
        exClassificationEquals(uriageSeikyuuData.getTikiktbrisyuruikbn(),C_TkiktbrisyuruiKbn.NONE,"定期一括払種類区分");
        exClassificationEquals(uriageSeikyuuData.getNyknaiyoukbn(), C_NyknaiyouKbn.ZENNOUP, "入金内容区分");
        exNumericEquals(uriageSeikyuuData.getAnnaino(), 5, "案内番号");
        exStringEquals(uriageSeikyuuData.getGyoumuKousinKinou(),"CreditUriageSeikyuuDataSks","業務用更新機能ID");
        exStringEquals(uriageSeikyuuData.getGyoumuKousinsyaId(),"JUnit","業務用更新者ID");
        exStringEquals(uriageSeikyuuData.getGyoumuKousinTime().substring(0, 8), gyoumuKousinTime.substring(0, 8),
            "業務用更新時間");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        String syoNo = "99806031282";

        String gyoumuKousinTime = BizDate.getSysDateTimeMilli();
        asKinou.setKinouId("CreditUriageSeikyuuDataSks");
        baseUserInfo.getUser().setUserId("JUnit");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        UriageSeikyuuDataSksParam uriageSeikyuuDataSksParam = SWAKInjector.getInstance(UriageSeikyuuDataSksParam.class);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo);
        IT_AnsyuRireki ansyuRirek = ansyuKihon.getAnsyuRirekis().get(0);

        uriageSeikyuuDataSksParam.setAnsyuKihonTblentity(ansyuKihon);
        uriageSeikyuuDataSksParam.setAnsyuRirekiTblentity(ansyuRirek);
        uriageSeikyuuDataSksParam.setKessaiyouno("00000000006");
        uriageSeikyuuDataSksParam.setUriagenengappi(BizDate.valueOf(20181020));
        uriageSeikyuuDataSksParam.setSyoriYmd(BizDate.valueOf(20181021));
        uriageSeikyuuDataSksParam.setUriagegk(BizCurrency.valueOf(99998));

        IT_UriageSeikyuuData uriageSeikyuuData =  creditUriageSeikyuuDataSks.editTuujyouUriageData(khozenCommonParam,
            uriageSeikyuuDataSksParam);

        exStringEquals(uriageSeikyuuData.getSyono(),"99806031282","証券番号");
        exStringEquals(uriageSeikyuuData.getCreditkessaiyouno(),"00000000006","クレジットカード決済用番号");
        exDateEquals(uriageSeikyuuData.getUriagenengappi(),BizDate.valueOf(20181020),"売上年月日");
        exNumericEquals(uriageSeikyuuData.getRenno3keta(),999,"連番（３桁）");
        exStringEquals(uriageSeikyuuData.getRecordno(),"10","レコード番号");
        exDateEquals(uriageSeikyuuData.getSyoriYmd(), BizDate.valueOf(20181021), "処理年月日");
        exClassificationEquals(uriageSeikyuuData.getCredituriageseikyuukbn(), C_CreditUriageSeikyuuKbn.TUUJYOU, "クレジットカード売上請求区分");
        exClassificationEquals(uriageSeikyuuData.getAuthorikbn(),C_AuthoriKbn.AUTHORINASI , "オーソリ区分");
        exBizCalcbleEquals(uriageSeikyuuData.getCredituriagegk(), BizCurrency.valueOf(99998), "クレジットカード売上金額");
        exStringEquals(uriageSeikyuuData.getFukusuukameitennokey(),"1200010","複数加盟店番号設定キー情報");
        exDateYMEquals(uriageSeikyuuData.getJyuutouym(),BizDateYM.valueOf(2019, 07),"充当年月");
        exNumericEquals(uriageSeikyuuData.getJyutoukaisuuy(),23,"充当回数（年）");
        exNumericEquals(uriageSeikyuuData.getJyutoukaisuum(),8,"充当回数（月）");
        exClassificationEquals(uriageSeikyuuData.getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exClassificationEquals(uriageSeikyuuData.getTikiktbrisyuruikbn(),C_TkiktbrisyuruiKbn.TEIKI_6MONTHS,"定期一括払種類区分");
        exClassificationEquals(uriageSeikyuuData.getNyknaiyoukbn(), C_NyknaiyouKbn.HENKOUGOP, "入金内容区分");
        exNumericEquals(uriageSeikyuuData.getAnnaino(), 6, "案内番号");
        exStringEquals(uriageSeikyuuData.getGyoumuKousinKinou(),"CreditUriageSeikyuuDataSks","業務用更新機能ID");
        exStringEquals(uriageSeikyuuData.getGyoumuKousinsyaId(),"JUnit","業務用更新者ID");
        exStringEquals(uriageSeikyuuData.getGyoumuKousinTime().substring(0, 8), gyoumuKousinTime.substring(0, 8),
            "業務用更新時間");
    }
}
