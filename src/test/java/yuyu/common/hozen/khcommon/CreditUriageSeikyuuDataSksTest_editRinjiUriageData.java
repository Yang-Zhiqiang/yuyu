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
import yuyu.def.db.entity.IT_UriageSeikyuuData;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全 契約保全共通 クレカ売上請求データ作成のメソッド {@link CreditUriageSeikyuuDataSks
 * #editRinjiUriageData(KhozenCommonParam,UriageSeikyuuDataSksParam)}
 * テスト用クラスです<br />
 */
@RunWith(SWAKTestRunner.class)
public class CreditUriageSeikyuuDataSksTest_editRinjiUriageData extends AbstractTest{

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

            testDataAndTblMap = testDataMaker.getInData(CreditUriageSeikyuuDataSksTest_editRinjiUriageData.class, fileName, sheetName);

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
    public void testExec_B1() {

        String syoNo = "99806027274";

        String gyoumuKousinTime = BizDate.getSysDateTimeMilli();
        asKinou.setKinouId("CreditUriageSeikyuuDataSks");
        baseUserInfo.getUser().setUserId("JUnit");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        UriageSeikyuuDataSksParam uriageSeikyuuDataSksParam = SWAKInjector.getInstance(UriageSeikyuuDataSksParam.class);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo);

        uriageSeikyuuDataSksParam.setAnsyuKihonTblentity(ansyuKihon);
        uriageSeikyuuDataSksParam.setKessaiyouno("00000000005");
        uriageSeikyuuDataSksParam.setUriagenengappi(BizDate.valueOf(20181019));
        uriageSeikyuuDataSksParam.setNyknaiyoukbn(C_NyknaiyouKbn.ZENNOUP);
        uriageSeikyuuDataSksParam.setSyoriYmd(BizDate.valueOf(20181020));
        uriageSeikyuuDataSksParam.setUriagegk(BizCurrency.valueOf(99999));

        IT_UriageSeikyuuData uriageSeikyuuData =  creditUriageSeikyuuDataSks.editRinjiUriageData(khozenCommonParam,
            uriageSeikyuuDataSksParam);

        exStringEquals(uriageSeikyuuData.getSyono(),"99806027274","証券番号");
        exStringEquals(uriageSeikyuuData.getCreditkessaiyouno(),"00000000005","クレジットカード決済用番号");
        exDateEquals(uriageSeikyuuData.getUriagenengappi(),BizDate.valueOf(20181019),"売上年月日");
        exNumericEquals(uriageSeikyuuData.getRenno3keta(),4,"連番（３桁）");
        exStringEquals(uriageSeikyuuData.getRecordno(),"11","レコード番号");
        exDateEquals(uriageSeikyuuData.getSyoriYmd(), BizDate.valueOf(20181020), "処理年月日");
        exClassificationEquals(uriageSeikyuuData.getCredituriageseikyuukbn(), C_CreditUriageSeikyuuKbn.RINJI, "クレジットカード売上請求区分");
        exClassificationEquals(uriageSeikyuuData.getAuthorikbn(),C_AuthoriKbn.AUTHORIJISSI , "オーソリ区分");
        exBizCalcbleEquals(uriageSeikyuuData.getCredituriagegk(), BizCurrency.valueOf(99999), "クレジットカード売上金額");
        exStringEquals(uriageSeikyuuData.getFukusuukameitennokey(),"1300010","複数加盟店番号設定キー情報");
        exDateYMEquals(uriageSeikyuuData.getJyuutouym(), null, "充当年月");
        exNumericEquals(uriageSeikyuuData.getJyutoukaisuuy(), 0, "充当回数（年）");
        exNumericEquals(uriageSeikyuuData.getJyutoukaisuum(), 0, "充当回数（月）");
        exClassificationEquals(uriageSeikyuuData.getHrkkaisuu(), C_Hrkkaisuu.BLNK, "払込回数");
        exClassificationEquals(uriageSeikyuuData.getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.BLNK, "定期一括払種類区分");
        exClassificationEquals(uriageSeikyuuData.getNyknaiyoukbn(), C_NyknaiyouKbn.ZENNOUP, "入金内容区分");
        exNumericEquals(uriageSeikyuuData.getAnnaino(), 0, "案内番号");
        exStringEquals(uriageSeikyuuData.getGyoumuKousinKinou(),"CreditUriageSeikyuuDataSks","業務用更新機能ID");
        exStringEquals(uriageSeikyuuData.getGyoumuKousinsyaId(),"JUnit","業務用更新者ID");
        exStringEquals(uriageSeikyuuData.getGyoumuKousinTime().substring(0, 8), gyoumuKousinTime.substring(0, 8),
            "業務用更新時間");
    }

}
