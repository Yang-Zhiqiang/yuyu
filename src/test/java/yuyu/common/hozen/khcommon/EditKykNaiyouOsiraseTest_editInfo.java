package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.MessageId;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.ZT_GaikaKokyakuTuutiTy;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 契約内容のお知らせ編集クラスのメソッド {@link EditKykNaiyouOsirase#editInfo(String, BizDate,BizDate,String, KawaseRateBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditKykNaiyouOsiraseTest_editInfo {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_契約内容のお知らせ編集";

    private final static String sheetName = "INデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(EditKykNaiyouOsiraseKytKm.class).to(EditKykNaiyouOsiraseKytKmMockForHozen.class);
                bind(EditKykNaiyouOsirase1.class).to(EditKykNaiyouOsirase1MockForHozen.class);
                bind(EditKykNaiyouOsirase2.class).to(EditKykNaiyouOsirase2MockForHozen.class);
                bind(EditKykNaiyouOsirase3.class).to(EditKykNaiyouOsirase3MockForHozen.class);
                bind(EditKykNaiyouOsirase4.class).to(EditKykNaiyouOsirase4MockForHozen.class);
                bind(EditKykNaiyouOsirase5.class).to(EditKykNaiyouOsirase5MockForHozen.class);
                bind(EditKykNaiyouOsirase6.class).to(EditKykNaiyouOsirase6MockForHozen.class);
                bind(EditKykNaiyouOsirase7.class).to(EditKykNaiyouOsirase7MockForHozen.class);
            }
        });
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(EditKykNaiyouOsiraseTest_editInfo.class, fileName, sheetName);

            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {
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

    @Test
    @TestOrder(10)
    public void testEditKykNaiyouOsirase_A1() {

        MockObjectManager.initialize();

        EditKykNaiyouOsiraseKytKmMockForHozen.caller = EditKykNaiyouOsiraseTest_editInfo.class;

        EditKykNaiyouOsirase1MockForHozen.caller = EditKykNaiyouOsiraseTest_editInfo.class;

        EditKykNaiyouOsiraseKytKmMockForHozen.SYORIPTN = EditKykNaiyouOsiraseKytKmMockForHozen.TESTPATTERN1;

        EditKykNaiyouOsirase editKykNaiyouOsirase = SWAKInjector.getInstance(EditKykNaiyouOsirase.class);

        String syono = "17806000013";
        BizDate syoriYmd = BizDate.valueOf(20180101);
        BizDate kykoutoubi = BizDate.valueOf(20190101);
        String syouhnHanmeiKbn = "01";
        KawaseRateBean kawaseRateBean = SWAKInjector.getInstance(KawaseRateBean.class);

        String campaignFlg = "1";

        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = editKykNaiyouOsirase.editInfo(syono, syoriYmd, kykoutoubi,
            syouhnHanmeiKbn, campaignFlg,kawaseRateBean, 1);

        exStringEquals(gaikaKokyakuTuutiTy.getZtydstourokujyou(), "3", "（中継用）ＤＳ登録状況");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysd1msgcd(), "07003", "（中継用）スミセイダイレクト１メッセージコード ");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysd2msgcd(), "07004", "（中継用）スミセイダイレクト２メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysd3msgcd(), "07005", "（中継用）スミセイダイレクト３メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykrpassword(), "ztykrpassword", "（中継用）仮パスワード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyyuukoukigenwareki(), "平成30年11月 5日", "（中継用）有効期限（和暦）");

        exStringEquals(gaikaKokyakuTuutiTy.getZtytyouhyouymd(), "20180101", "（中継用）帳票作成日");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysyono(), "17806000013", "（中継用）証券番号");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysclatosyono(), "17806000013", "（中継用）スクランブル後証券番号");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyhassoukbn(), "1", "（中継用）発送区分");
        exStringEquals(gaikaKokyakuTuutiTy.getZtydskaiyktirasidouhuukbn(), "1", "（中継用）ＤＳ解約チラシ同封区分");

        exStringEquals(gaikaKokyakuTuutiTy.getZtysyoruicd(), C_SyoruiCdKbn.KK_GAIKA_KOKYAKUTUUTI.getValue().toUpperCase(), "（中継用）書類コード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyosirasemsgcd1(), "08011", "（中継用）お知らせメッセージコード１");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyosirasemsgcd2(), "08012", "（中継用）お知らせメッセージコード２");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyosirasemsgcd3(), "", "（中継用）お知らせメッセージコード３");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyosirasemsgcd4(), "", "（中継用）お知らせメッセージコード４");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyosirasemsgcd5(), "", "（中継用）お知らせメッセージコード５");

        exStringEquals(gaikaKokyakuTuutiTy.getZtyaisatumsgcd1(), "03003", "（中継用）挨拶文メッセージコード１");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyaisatumsgcd2(), "03004", "（中継用）挨拶文メッセージコード２");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyaisatumsgcd3(), "", "（中継用）挨拶文メッセージコード３");

        String pSyono1 = (String) MockObjectManager.getArgument(EditKykNaiyouOsiraseKytKmMockForHozen.class,
            "editDsTourokuJyou", 0, 0);
        exStringEquals(pSyono1, "17806000013", "証券番号");
        BizDate pSyoriYmd1 = (BizDate) MockObjectManager.getArgument(EditKykNaiyouOsiraseKytKmMockForHozen.class,
            "editDsTourokuJyou", 0, 1);
        exDateEquals(pSyoriYmd1, BizDate.valueOf(20180101), "処理年月日");

        BizDate pSyoriYmd2 = (BizDate) MockObjectManager.getArgument(EditKykNaiyouOsiraseKytKmMockForHozen.class,
            "editInfo", 0, 1);
        exDateEquals(pSyoriYmd2, BizDate.valueOf(20180101), "処理年月日");
        BizDate pKykoutoubi2 = (BizDate) MockObjectManager.getArgument(EditKykNaiyouOsiraseKytKmMockForHozen.class,
            "editInfo", 0, 2);
        exDateEquals(pKykoutoubi2, BizDate.valueOf(20190101), "契約応当日");

        BizDate pSyoriYmd3 = (BizDate) MockObjectManager.getArgument(EditKykNaiyouOsirase1MockForHozen.class,
            "editInfo", 0, 1);
        exDateEquals(pSyoriYmd3, BizDate.valueOf(20180101), "処理年月日");
        BizDate pKykoutoubi3 = (BizDate) MockObjectManager.getArgument(EditKykNaiyouOsirase1MockForHozen.class,
            "editInfo", 0, 2);
        exDateEquals(pKykoutoubi3, BizDate.valueOf(20190101), "契約応当日");
        exClassificationEquals(editKykNaiyouOsirase.getBizLogicErrorKbn(), C_ErrorKbn.OK, "エラー区分（業務）");
        exStringEquals(editKykNaiyouOsirase.getBizLogicErrorMsg(), "", "エラーメッセージ（業務）");

    }

    @Test
    @TestOrder(20)
    public void testEditKykNaiyouOsirase_A2() {

        MockObjectManager.initialize();

        EditKykNaiyouOsiraseKytKmMockForHozen.SYORIPTN = EditKykNaiyouOsiraseKytKmMockForHozen.TESTPATTERN1;

        EditKykNaiyouOsiraseKytKmMockForHozen.caller = EditKykNaiyouOsiraseTest_editInfo.class;

        EditKykNaiyouOsirase4MockForHozen.caller = EditKykNaiyouOsiraseTest_editInfo.class;

        EditKykNaiyouOsirase editKykNaiyouOsirase = SWAKInjector.getInstance(EditKykNaiyouOsirase.class);

        String syono = "17806000013";
        BizDate syoriYmd = BizDate.valueOf(20180101);
        BizDate kykoutoubi = BizDate.valueOf(20190101);
        String syouhnHanmeiKbn = "02";
        KawaseRateBean kawaseRateBean = SWAKInjector.getInstance(KawaseRateBean.class);

        String campaignFlg = "1";

        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = editKykNaiyouOsirase.editInfo(syono, syoriYmd, kykoutoubi,
            syouhnHanmeiKbn, campaignFlg,kawaseRateBean, 1);

        exStringEquals(gaikaKokyakuTuutiTy.getZtydstourokujyou(), "3", "（中継用）ＤＳ登録状況");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysd1msgcd(), "07003", "（中継用）スミセイダイレクト１メッセージコード ");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysd2msgcd(), "07004", "（中継用）スミセイダイレクト２メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysd3msgcd(), "07005", "（中継用）スミセイダイレクト３メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykrpassword(), "ztykrpassword", "（中継用）仮パスワード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyyuukoukigenwareki(), "平成30年11月 5日", "（中継用）有効期限（和暦）");

        exStringEquals(gaikaKokyakuTuutiTy.getZtytyouhyouymd(), "20180101", "（中継用）帳票作成日");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysyono(), "17806000013", "（中継用）証券番号");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysclatosyono(), "17806000013", "（中継用）スクランブル後証券番号");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyhassoukbn(), "1", "（中継用）発送区分");
        exStringEquals(gaikaKokyakuTuutiTy.getZtydskaiyktirasidouhuukbn(), "1", "（中継用）ＤＳ解約チラシ同封区分");

        exStringEquals(gaikaKokyakuTuutiTy.getZtysyoruicd(), C_SyoruiCdKbn.KK_GAIKA_KOKYAKUTUUTI.getValue().toUpperCase(), "（中継用）書類コード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyosirasemsgcd1(), "08011", "（中継用）お知らせメッセージコード１");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyosirasemsgcd2(), "08012", "（中継用）お知らせメッセージコード２");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyosirasemsgcd3(), "08005", "（中継用）お知らせメッセージコード３");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyosirasemsgcd4(), "08009", "（中継用）お知らせメッセージコード４");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyosirasemsgcd5(), "", "（中継用）お知らせメッセージコード５");

        exStringEquals(gaikaKokyakuTuutiTy.getZtyaisatumsgcd1(), "03003", "（中継用）挨拶文メッセージコード１");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyaisatumsgcd2(), "03005", "（中継用）挨拶文メッセージコード２");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyaisatumsgcd3(), "", "（中継用）挨拶文メッセージコード３");
    }

    @Test
    @TestOrder(30)
    public void testEditKykNaiyouOsirase_A3() {

        MockObjectManager.initialize();

        EditKykNaiyouOsiraseKytKmMockForHozen.SYORIPTN = EditKykNaiyouOsiraseKytKmMockForHozen.TESTPATTERN1;

        EditKykNaiyouOsiraseKytKmMockForHozen.caller = EditKykNaiyouOsiraseTest_editInfo.class;

        EditKykNaiyouOsirase2MockForHozen.caller = EditKykNaiyouOsiraseTest_editInfo.class;

        EditKykNaiyouOsirase editKykNaiyouOsirase = SWAKInjector.getInstance(EditKykNaiyouOsirase.class);

        String syono = "17806000013";
        BizDate syoriYmd = BizDate.valueOf(20180101);
        BizDate kykoutoubi = BizDate.valueOf(20190101);
        String syouhnHanmeiKbn = "03";
        KawaseRateBean kawaseRateBean = SWAKInjector.getInstance(KawaseRateBean.class);

        String campaignFlg = "1";

        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = editKykNaiyouOsirase.editInfo(syono, syoriYmd, kykoutoubi,
            syouhnHanmeiKbn, campaignFlg,kawaseRateBean, 1);

        exStringEquals(gaikaKokyakuTuutiTy.getZtydstourokujyou(), "3", "（中継用）ＤＳ登録状況");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysd1msgcd(), "07003", "（中継用）スミセイダイレクト１メッセージコード ");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysd2msgcd(), "07004", "（中継用）スミセイダイレクト２メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysd3msgcd(), "07005", "（中継用）スミセイダイレクト３メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykrpassword(), "ztykrpassword", "（中継用）仮パスワード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyyuukoukigenwareki(), "平成30年11月 5日", "（中継用）有効期限（和暦）");

        exStringEquals(gaikaKokyakuTuutiTy.getZtytyouhyouymd(), "20180101", "（中継用）帳票作成日");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysyono(), "17806000013", "（中継用）証券番号");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysclatosyono(), "17806000013", "（中継用）スクランブル後証券番号");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyhassoukbn(), "1", "（中継用）発送区分");
        exStringEquals(gaikaKokyakuTuutiTy.getZtydskaiyktirasidouhuukbn(), "1", "（中継用）ＤＳ解約チラシ同封区分");

        exStringEquals(gaikaKokyakuTuutiTy.getZtysyoruicd(), C_SyoruiCdKbn.KK_DSHR_SKS.getValue().toUpperCase(), "（中継用）書類コード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyosirasemsgcd1(), "08011", "（中継用）お知らせメッセージコード１");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyosirasemsgcd2(), "", "（中継用）お知らせメッセージコード２");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyosirasemsgcd3(), "", "（中継用）お知らせメッセージコード３");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyosirasemsgcd4(), "", "（中継用）お知らせメッセージコード４");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyosirasemsgcd5(), "", "（中継用）お知らせメッセージコード５");

        exStringEquals(gaikaKokyakuTuutiTy.getZtyaisatumsgcd1(), "03003", "（中継用）挨拶文メッセージコード１");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyaisatumsgcd2(), "03006", "（中継用）挨拶文メッセージコード２");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyaisatumsgcd3(), "", "（中継用）挨拶文メッセージコード３");

    }


    @Test
    @TestOrder(40)
    public void testEditKykNaiyouOsirase_A4() {

        MockObjectManager.initialize();

        EditKykNaiyouOsiraseKytKmMockForHozen.SYORIPTN = EditKykNaiyouOsiraseKytKmMockForHozen.TESTPATTERN1;

        EditKykNaiyouOsiraseKytKmMockForHozen.caller = EditKykNaiyouOsiraseTest_editInfo.class;

        EditKykNaiyouOsirase2MockForHozen.caller = EditKykNaiyouOsiraseTest_editInfo.class;

        EditKykNaiyouOsirase editKykNaiyouOsirase = SWAKInjector.getInstance(EditKykNaiyouOsirase.class);

        String syono = "17806000013";
        BizDate syoriYmd = BizDate.valueOf(20180101);
        BizDate kykoutoubi = BizDate.valueOf(20190101);
        String syouhnHanmeiKbn = "04";
        KawaseRateBean kawaseRateBean = SWAKInjector.getInstance(KawaseRateBean.class);

        String campaignFlg = "0";

        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = editKykNaiyouOsirase.editInfo(syono, syoriYmd, kykoutoubi,
            syouhnHanmeiKbn, campaignFlg,kawaseRateBean, 1);


        exStringEquals(gaikaKokyakuTuutiTy.getZtydstourokujyou(), "3", "（中継用）ＤＳ登録状況");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysd1msgcd(), "07003", "（中継用）スミセイダイレクト１メッセージコード ");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysd2msgcd(), "07004", "（中継用）スミセイダイレクト２メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysd3msgcd(), "07005", "（中継用）スミセイダイレクト３メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykrpassword(), "ztykrpassword", "（中継用）仮パスワード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyyuukoukigenwareki(), "平成30年11月 5日", "（中継用）有効期限（和暦）");

        exStringEquals(gaikaKokyakuTuutiTy.getZtytyouhyouymd(), "20180101", "（中継用）帳票作成日");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysyono(), "17806000013", "（中継用）証券番号");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysclatosyono(), "17806000013", "（中継用）スクランブル後証券番号");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyhassoukbn(), "1", "（中継用）発送区分");
        exStringEquals(gaikaKokyakuTuutiTy.getZtydskaiyktirasidouhuukbn(), "1", "（中継用）ＤＳ解約チラシ同封区分");

        exStringEquals(gaikaKokyakuTuutiTy.getZtysyoruicd(), C_SyoruiCdKbn.KK_DSHR_SKS.getValue().toUpperCase(), "（中継用）書類コード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyosirasemsgcd1(), "", "（中継用）お知らせメッセージコード１");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyosirasemsgcd2(), "", "（中継用）お知らせメッセージコード２");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyosirasemsgcd3(), "", "（中継用）お知らせメッセージコード３");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyosirasemsgcd4(), "", "（中継用）お知らせメッセージコード４");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyosirasemsgcd5(), "", "（中継用）お知らせメッセージコード５");

        exStringEquals(gaikaKokyakuTuutiTy.getZtyaisatumsgcd1(), "03003", "（中継用）挨拶文メッセージコード１");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyaisatumsgcd2(), "03007", "（中継用）挨拶文メッセージコード２");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyaisatumsgcd3(), "", "（中継用）挨拶文メッセージコード３");

    }

    @Test
    @TestOrder(50)
    public void testEditKykNaiyouOsirase_A5() {

        MockObjectManager.initialize();

        EditKykNaiyouOsiraseKytKmMockForHozen.SYORIPTN = EditKykNaiyouOsiraseKytKmMockForHozen.TESTPATTERN1;

        EditKykNaiyouOsiraseKytKmMockForHozen.caller = EditKykNaiyouOsiraseTest_editInfo.class;

        EditKykNaiyouOsirase editKykNaiyouOsirase = SWAKInjector.getInstance(EditKykNaiyouOsirase.class);

        String syono = "17806000013";
        BizDate syoriYmd = BizDate.valueOf(20180101);
        BizDate kykoutoubi = BizDate.valueOf(20190101);
        String syouhnHanmeiKbn = "05";
        KawaseRateBean kawaseRateBean = SWAKInjector.getInstance(KawaseRateBean.class);

        String campaignFlg = "1";

        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = editKykNaiyouOsirase.editInfo(syono, syoriYmd, kykoutoubi,
            syouhnHanmeiKbn, campaignFlg,kawaseRateBean, 1);


        exStringEquals(gaikaKokyakuTuutiTy.getZtydstourokujyou(), "3", "（中継用）ＤＳ登録状況");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysd1msgcd(), "07003", "（中継用）スミセイダイレクト１メッセージコード ");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysd2msgcd(), "07004", "（中継用）スミセイダイレクト２メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysd3msgcd(), "07005", "（中継用）スミセイダイレクト３メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykrpassword(), "ztykrpassword", "（中継用）仮パスワード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyyuukoukigenwareki(), "平成30年11月 5日", "（中継用）有効期限（和暦）");

        exStringEquals(gaikaKokyakuTuutiTy.getZtytyouhyouymd(), "20180101", "（中継用）帳票作成日");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysyono(), "17806000013", "（中継用）証券番号");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysclatosyono(), "17806000013", "（中継用）スクランブル後証券番号");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyhassoukbn(), "1", "（中継用）発送区分");
        exStringEquals(gaikaKokyakuTuutiTy.getZtydskaiyktirasidouhuukbn(), "1", "（中継用）ＤＳ解約チラシ同封区分");

        exStringEquals(gaikaKokyakuTuutiTy.getZtysyoruicd(), C_SyoruiCdKbn.KK_DSHR_SKS.getValue().toUpperCase(), "（中継用）書類コード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyosirasemsgcd1(), "08011", "（中継用）お知らせメッセージコード１");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyosirasemsgcd2(), "", "（中継用）お知らせメッセージコード２");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyosirasemsgcd3(), "", "（中継用）お知らせメッセージコード３");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyosirasemsgcd4(), "", "（中継用）お知らせメッセージコード４");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyosirasemsgcd5(), "", "（中継用）お知らせメッセージコード５");

        exStringEquals(gaikaKokyakuTuutiTy.getZtyaisatumsgcd1(), "03003", "（中継用）挨拶文メッセージコード１");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyaisatumsgcd2(), "03001", "（中継用）挨拶文メッセージコード２");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyaisatumsgcd3(), "", "（中継用）挨拶文メッセージコード３");

    }

    @Test
    @TestOrder(60)
    public void testEditKykNaiyouOsirase_A6() {

        MockObjectManager.initialize();

        EditKykNaiyouOsiraseKytKmMockForHozen.SYORIPTN = EditKykNaiyouOsiraseKytKmMockForHozen.TESTPATTERN1;

        EditKykNaiyouOsiraseKytKmMockForHozen.caller = EditKykNaiyouOsiraseTest_editInfo.class;

        EditKykNaiyouOsirase2MockForHozen.caller = EditKykNaiyouOsiraseTest_editInfo.class;

        EditKykNaiyouOsirase editKykNaiyouOsirase = SWAKInjector.getInstance(EditKykNaiyouOsirase.class);

        String syono = "17806000013";
        BizDate syoriYmd = BizDate.valueOf(20180101);
        BizDate kykoutoubi = BizDate.valueOf(20190101);
        String syouhnHanmeiKbn = "06";
        KawaseRateBean kawaseRateBean = SWAKInjector.getInstance(KawaseRateBean.class);

        String campaignFlg = "1";

        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = editKykNaiyouOsirase.editInfo(syono, syoriYmd, kykoutoubi,
            syouhnHanmeiKbn, campaignFlg,kawaseRateBean, 1);

        exStringEquals(gaikaKokyakuTuutiTy.getZtydstourokujyou(), "3", "（中継用）ＤＳ登録状況");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysd1msgcd(), "07003", "（中継用）スミセイダイレクト１メッセージコード ");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysd2msgcd(), "07004", "（中継用）スミセイダイレクト２メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysd3msgcd(), "07005", "（中継用）スミセイダイレクト３メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykrpassword(), "ztykrpassword", "（中継用）仮パスワード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyyuukoukigenwareki(), "平成30年11月 5日", "（中継用）有効期限（和暦）");

        exStringEquals(gaikaKokyakuTuutiTy.getZtytyouhyouymd(), "20180101", "（中継用）帳票作成日");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysyono(), "17806000013", "（中継用）証券番号");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysclatosyono(), "17806000013", "（中継用）スクランブル後証券番号");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyhassoukbn(), "1", "（中継用）発送区分");
        exStringEquals(gaikaKokyakuTuutiTy.getZtydskaiyktirasidouhuukbn(), "1", "（中継用）ＤＳ解約チラシ同封区分");

        exStringEquals(gaikaKokyakuTuutiTy.getZtysyoruicd(), C_SyoruiCdKbn.KK_DSHR_SKS.getValue().toUpperCase(), "（中継用）書類コード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyosirasemsgcd1(), "08011", "（中継用）お知らせメッセージコード１");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyosirasemsgcd2(), "", "（中継用）お知らせメッセージコード２");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyosirasemsgcd3(), "", "（中継用）お知らせメッセージコード３");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyosirasemsgcd4(), "", "（中継用）お知らせメッセージコード４");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyosirasemsgcd5(), "", "（中継用）お知らせメッセージコード５");

        exStringEquals(gaikaKokyakuTuutiTy.getZtyaisatumsgcd1(), "03003", "（中継用）挨拶文メッセージコード１");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyaisatumsgcd2(), "03007", "（中継用）挨拶文メッセージコード２");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyaisatumsgcd3(), "", "（中継用）挨拶文メッセージコード３");
    }


    @Test
    @TestOrder(70)
    public void testEditKykNaiyouOsirase_A7() {

        MockObjectManager.initialize();

        EditKykNaiyouOsiraseKytKmMockForHozen.SYORIPTN = EditKykNaiyouOsiraseKytKmMockForHozen.TESTPATTERN1;

        EditKykNaiyouOsiraseKytKmMockForHozen.caller = EditKykNaiyouOsiraseTest_editInfo.class;

        EditKykNaiyouOsirase3MockForHozen.caller = EditKykNaiyouOsiraseTest_editInfo.class;

        EditKykNaiyouOsirase editKykNaiyouOsirase = SWAKInjector.getInstance(EditKykNaiyouOsirase.class);

        String syono = "17806000013";
        BizDate syoriYmd = BizDate.valueOf(20180101);
        BizDate kykoutoubi = BizDate.valueOf(20190101);
        String syouhnHanmeiKbn = "07";
        KawaseRateBean kawaseRateBean = SWAKInjector.getInstance(KawaseRateBean.class);

        String campaignFlg = "1";

        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = editKykNaiyouOsirase.editInfo(syono, syoriYmd, kykoutoubi,
            syouhnHanmeiKbn, campaignFlg,kawaseRateBean, 1);

        exStringEquals(gaikaKokyakuTuutiTy.getZtydstourokujyou(), "3", "（中継用）ＤＳ登録状況");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysd1msgcd(), "07003", "（中継用）スミセイダイレクト１メッセージコード ");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysd2msgcd(), "07004", "（中継用）スミセイダイレクト２メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysd3msgcd(), "07005", "（中継用）スミセイダイレクト３メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykrpassword(), "ztykrpassword", "（中継用）仮パスワード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyyuukoukigenwareki(), "平成30年11月 5日", "（中継用）有効期限（和暦）");

        exStringEquals(gaikaKokyakuTuutiTy.getZtytyouhyouymd(), "20180101", "（中継用）帳票作成日");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysyono(), "17806000013", "（中継用）証券番号");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysclatosyono(), "17806000013", "（中継用）スクランブル後証券番号");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyhassoukbn(), "1", "（中継用）発送区分");
        exStringEquals(gaikaKokyakuTuutiTy.getZtydskaiyktirasidouhuukbn(), "1", "（中継用）ＤＳ解約チラシ同封区分");

        exStringEquals(gaikaKokyakuTuutiTy.getZtysyoruicd(), C_SyoruiCdKbn.KK_GAIKA_KOKYAKUTUUTI.getValue().toUpperCase(), "（中継用）書類コード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyosirasemsgcd1(), "08011", "（中継用）お知らせメッセージコード１");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyosirasemsgcd2(), "", "（中継用）お知らせメッセージコード２");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyosirasemsgcd3(), "", "（中継用）お知らせメッセージコード３");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyosirasemsgcd4(), "", "（中継用）お知らせメッセージコード４");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyosirasemsgcd5(), "", "（中継用）お知らせメッセージコード５");

        exStringEquals(gaikaKokyakuTuutiTy.getZtyaisatumsgcd1(), "03003", "（中継用）挨拶文メッセージコード１");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyaisatumsgcd2(), "03008", "（中継用）挨拶文メッセージコード２");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyaisatumsgcd3(), "", "（中継用）挨拶文メッセージコード３");

        exClassificationEquals(editKykNaiyouOsirase.getCommonErrorKbn(), C_ErrorKbn.OK, "エラー区分（共有）");

        IT_KykKihon kykKihon = (IT_KykKihon)MockObjectManager.getArgument(EditKykNaiyouOsirase3MockForHozen.class, "editInfo", 0, 0);
        BizDate pSyoriYmd1 = (BizDate) MockObjectManager.getArgument(EditKykNaiyouOsirase3MockForHozen.class,
            "editInfo", 0, 1);
        exDateEquals(pSyoriYmd1, BizDate.valueOf(20180101), "処理年月日");
        BizDate pKykoutoubi1 = (BizDate) MockObjectManager.getArgument(EditKykNaiyouOsirase3MockForHozen.class,
            "editInfo", 0, 2);
        exDateEquals(pKykoutoubi1, BizDate.valueOf(20190101), "契約応当日");
        String pSyouhnHanmeiKbn1 = (String) MockObjectManager.getArgument(EditKykNaiyouOsirase3MockForHozen.class,
            "editInfo", 0, 3);
        exStringEquals(pSyouhnHanmeiKbn1, "07", "商品判明区分");
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy1 = (ZT_GaikaKokyakuTuutiTy)MockObjectManager.getArgument(EditKykNaiyouOsirase3MockForHozen.class, "editInfo", 0, 4);
        exStringEquals(kykKihon.getKbnkey(), "01", "区分キー");
        exStringEquals(kykKihon.getSyono(), "17806000013", "証券番号");
        exStringEquals(gaikaKokyakuTuutiTy1.getZtytyouhyouymd(), "20180101", "（中継用）帳票作成日");
        exStringEquals(gaikaKokyakuTuutiTy1.getZtysyono(), "17806000013", "（中継用）証券番号");
        exStringEquals(gaikaKokyakuTuutiTy1.getZtysclatosyono(), "17806000013", "（中継用）スクランブル後証券番号");
        exStringEquals(gaikaKokyakuTuutiTy1.getZtyhassoukbn(), "1", "（中継用）発送区分");
        exStringEquals(gaikaKokyakuTuutiTy1.getZtydskaiyktirasidouhuukbn(), "1", "（中継用）ＤＳ解約チラシ同封区分");

        exClassificationEquals(editKykNaiyouOsirase.getBizLogicErrorKbn(), C_ErrorKbn.OK, "エラー区分（業務）");
        exStringEquals(editKykNaiyouOsirase.getBizLogicErrorMsg(), "", "エラーメッセージ（業務）");
    }

    @Test
    @TestOrder(80)
    public void testEditKykNaiyouOsirase_A8() {

        MockObjectManager.initialize();

        EditKykNaiyouOsiraseKytKmMockForHozen.SYORIPTN = EditKykNaiyouOsiraseKytKmMockForHozen.TESTPATTERN1;

        EditKykNaiyouOsiraseKytKmMockForHozen.caller = EditKykNaiyouOsiraseTest_editInfo.class;

        EditKykNaiyouOsirase5MockForHozen.caller = EditKykNaiyouOsiraseTest_editInfo.class;

        EditKykNaiyouOsirase editKykNaiyouOsirase = SWAKInjector.getInstance(EditKykNaiyouOsirase.class);

        String syono = "17806000013";
        BizDate syoriYmd = BizDate.valueOf(20180101);
        BizDate kykoutoubi = BizDate.valueOf(20190101);
        String syouhnHanmeiKbn = "08";
        KawaseRateBean kawaseRateBean = SWAKInjector.getInstance(KawaseRateBean.class);

        String campaignFlg = "1";

        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = editKykNaiyouOsirase.editInfo(syono, syoriYmd, kykoutoubi,
            syouhnHanmeiKbn, campaignFlg,kawaseRateBean, 1);


        exStringEquals(gaikaKokyakuTuutiTy.getZtydstourokujyou(), "3", "（中継用）ＤＳ登録状況");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysd1msgcd(), "07003", "（中継用）スミセイダイレクト１メッセージコード ");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysd2msgcd(), "07004", "（中継用）スミセイダイレクト２メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysd3msgcd(), "07005", "（中継用）スミセイダイレクト３メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykrpassword(), "ztykrpassword", "（中継用）仮パスワード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyyuukoukigenwareki(), "平成30年11月 5日", "（中継用）有効期限（和暦）");

        exStringEquals(gaikaKokyakuTuutiTy.getZtytyouhyouymd(), "20180101", "（中継用）帳票作成日");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysyono(), "17806000013", "（中継用）証券番号");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysclatosyono(), "17806000013", "（中継用）スクランブル後証券番号");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyhassoukbn(), "1", "（中継用）発送区分");
        exStringEquals(gaikaKokyakuTuutiTy.getZtydskaiyktirasidouhuukbn(), "1", "（中継用）ＤＳ解約チラシ同封区分");

        exStringEquals(gaikaKokyakuTuutiTy.getZtysyoruicd(), C_SyoruiCdKbn.KK_GAIKA_KOKYAKUTUUTI.getValue().toUpperCase(), "（中継用）書類コード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyosirasemsgcd1(), "08011", "（中継用）お知らせメッセージコード１");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyosirasemsgcd2(), "08008", "（中継用）お知らせメッセージコード２");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyosirasemsgcd3(), "", "（中継用）お知らせメッセージコード３");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyosirasemsgcd4(), "", "（中継用）お知らせメッセージコード４");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyosirasemsgcd5(), "", "（中継用）お知らせメッセージコード５");

        exStringEquals(gaikaKokyakuTuutiTy.getZtyaisatumsgcd1(), "03003", "（中継用）挨拶文メッセージコード１");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyaisatumsgcd2(), "03005", "（中継用）挨拶文メッセージコード２");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyaisatumsgcd3(), "", "（中継用）挨拶文メッセージコード３");


    }

    @Test
    @TestOrder(90)
    public void testEditKykNaiyouOsirase_A9() {

        MockObjectManager.initialize();

        EditKykNaiyouOsiraseKytKmMockForHozen.SYORIPTN = EditKykNaiyouOsiraseKytKmMockForHozen.TESTPATTERN1;

        EditKykNaiyouOsiraseKytKmMockForHozen.caller = EditKykNaiyouOsiraseTest_editInfo.class;

        EditKykNaiyouOsirase6MockForHozen.caller = EditKykNaiyouOsiraseTest_editInfo.class;

        EditKykNaiyouOsirase editKykNaiyouOsirase = SWAKInjector.getInstance(EditKykNaiyouOsirase.class);

        String syono = "17806000013";
        BizDate syoriYmd = BizDate.valueOf(20180101);
        BizDate kykoutoubi = BizDate.valueOf(20190101);
        String syouhnHanmeiKbn = "09";
        KawaseRateBean kawaseRateBean = SWAKInjector.getInstance(KawaseRateBean.class);

        String campaignFlg = "1";

        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = editKykNaiyouOsirase.editInfo(syono, syoriYmd, kykoutoubi,
            syouhnHanmeiKbn, campaignFlg,kawaseRateBean, 1);

        exStringEquals(gaikaKokyakuTuutiTy.getZtydstourokujyou(), "3", "（中継用）ＤＳ登録状況");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysd1msgcd(), "07003", "（中継用）スミセイダイレクト１メッセージコード ");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysd2msgcd(), "07004", "（中継用）スミセイダイレクト２メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysd3msgcd(), "07005", "（中継用）スミセイダイレクト３メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykrpassword(), "ztykrpassword", "（中継用）仮パスワード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyyuukoukigenwareki(), "平成30年11月 5日", "（中継用）有効期限（和暦）");

        exStringEquals(gaikaKokyakuTuutiTy.getZtytyouhyouymd(), "20180101", "（中継用）帳票作成日");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysyono(), "17806000013", "（中継用）証券番号");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysclatosyono(), "17806000013", "（中継用）スクランブル後証券番号");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyhassoukbn(), "1", "（中継用）発送区分");
        exStringEquals(gaikaKokyakuTuutiTy.getZtydskaiyktirasidouhuukbn(), "1", "（中継用）ＤＳ解約チラシ同封区分");

        exStringEquals(gaikaKokyakuTuutiTy.getZtysyoruicd(), C_SyoruiCdKbn.KK_GAIKA_KOKYAKUTUUTI.getValue().toUpperCase(), "（中継用）書類コード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyosirasemsgcd1(), "08011", "（中継用）お知らせメッセージコード１");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyosirasemsgcd2(), "08012", "（中継用）お知らせメッセージコード２");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyosirasemsgcd3(), "", "（中継用）お知らせメッセージコード３");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyosirasemsgcd4(), "", "（中継用）お知らせメッセージコード４");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyosirasemsgcd5(), "", "（中継用）お知らせメッセージコード５");

        exStringEquals(gaikaKokyakuTuutiTy.getZtyaisatumsgcd1(), "03003", "（中継用）挨拶文メッセージコード１");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyaisatumsgcd2(), "03004", "（中継用）挨拶文メッセージコード２");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyaisatumsgcd3(), "", "（中継用）挨拶文メッセージコード３");
    }

    @Test
    @TestOrder(100)
    public void testEditKykNaiyouOsirase_A10() {

        MockObjectManager.initialize();

        EditKykNaiyouOsiraseKytKmMockForHozen.SYORIPTN = EditKykNaiyouOsiraseKytKmMockForHozen.TESTPATTERN1;

        EditKykNaiyouOsiraseKytKmMockForHozen.caller = EditKykNaiyouOsiraseTest_editInfo.class;

        EditKykNaiyouOsirase7MockForHozen.caller = EditKykNaiyouOsiraseTest_editInfo.class;

        EditKykNaiyouOsirase editKykNaiyouOsirase = SWAKInjector.getInstance(EditKykNaiyouOsirase.class);

        String syono = "17806000013";
        BizDate syoriYmd = BizDate.valueOf(20180101);
        BizDate kykoutoubi = BizDate.valueOf(20190101);
        String syouhnHanmeiKbn = "10";
        KawaseRateBean kawaseRateBean = SWAKInjector.getInstance(KawaseRateBean.class);

        String campaignFlg = "1";

        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = editKykNaiyouOsirase.editInfo(syono, syoriYmd, kykoutoubi,
            syouhnHanmeiKbn, campaignFlg,kawaseRateBean, 1);

        exStringEquals(gaikaKokyakuTuutiTy.getZtydstourokujyou(), "3", "（中継用）ＤＳ登録状況");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysd1msgcd(), "07003", "（中継用）スミセイダイレクト１メッセージコード ");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysd2msgcd(), "07004", "（中継用）スミセイダイレクト２メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysd3msgcd(), "07005", "（中継用）スミセイダイレクト３メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykrpassword(), "ztykrpassword", "（中継用）仮パスワード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyyuukoukigenwareki(), "平成30年11月 5日", "（中継用）有効期限（和暦）");

        exStringEquals(gaikaKokyakuTuutiTy.getZtytyouhyouymd(), "20180101", "（中継用）帳票作成日");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysyono(), "17806000013", "（中継用）証券番号");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysclatosyono(), "17806000013", "（中継用）スクランブル後証券番号");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyhassoukbn(), "1", "（中継用）発送区分");
        exStringEquals(gaikaKokyakuTuutiTy.getZtydskaiyktirasidouhuukbn(), "1", "（中継用）ＤＳ解約チラシ同封区分");

        exStringEquals(gaikaKokyakuTuutiTy.getZtysyoruicd(), C_SyoruiCdKbn.KK_GAIKA_KOKYAKUTUUTI.getValue().toUpperCase(), "（中継用）書類コード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyosirasemsgcd1(), "08011", "（中継用）お知らせメッセージコード１");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyosirasemsgcd2(), "08005", "（中継用）お知らせメッセージコード２");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyosirasemsgcd3(), "", "（中継用）お知らせメッセージコード３");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyosirasemsgcd4(), "", "（中継用）お知らせメッセージコード４");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyosirasemsgcd5(), "", "（中継用）お知らせメッセージコード５");

        exStringEquals(gaikaKokyakuTuutiTy.getZtyaisatumsgcd1(), "03003", "（中継用）挨拶文メッセージコード１");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyaisatumsgcd2(), "03005", "（中継用）挨拶文メッセージコード２");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyaisatumsgcd3(), "", "（中継用）挨拶文メッセージコード３");
        exClassificationEquals(editKykNaiyouOsirase.getCommonErrorKbn(), C_ErrorKbn.OK, "エラー区分（共有）");

        IT_KykKihon kykKihon = (IT_KykKihon)MockObjectManager.getArgument(EditKykNaiyouOsirase7MockForHozen.class, "editInfo", 0, 0);
        exStringEquals(kykKihon.getSyono(), "17806000013", "証券番号");
        exDateEquals((BizDate) MockObjectManager.getArgument(EditKykNaiyouOsirase7MockForHozen.class, "editInfo", 0, 1), BizDate.valueOf(20180101), "処理年月日");
        exDateEquals((BizDate) MockObjectManager.getArgument(EditKykNaiyouOsirase7MockForHozen.class, "editInfo", 0, 2), BizDate.valueOf(20190101), "契約応当日");

        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy1 = (ZT_GaikaKokyakuTuutiTy)MockObjectManager.getArgument(EditKykNaiyouOsirase7MockForHozen.class, "editInfo", 0, 3);
        exStringEquals(gaikaKokyakuTuutiTy1.getZtysyono(), "17806000013", "（中継用）証券番号");
    }


    @Test
    @TestOrder(110)
    public void testEditKykNaiyouOsirase_A11() {

        MockObjectManager.initialize();

        EditKykNaiyouOsiraseKytKmMockForHozen.SYORIPTN = EditKykNaiyouOsiraseKytKmMockForHozen.TESTPATTERN2;

        EditKykNaiyouOsiraseKytKmMockForHozen.caller = EditKykNaiyouOsiraseTest_editInfo.class;

        String syono = "17806000080";
        BizDate syoriYmd = BizDate.valueOf("20190802");
        BizDate kykoutoubi = BizDate.valueOf("20181001");
        String syouhnHanmeiKbn = "02";
        String campaignFlg = "1";
        KawaseRateBean kawaseRateBean = SWAKInjector.getInstance(KawaseRateBean.class);

        EditKykNaiyouOsirase editKykNaiyouOsirase = SWAKInjector.getInstance(EditKykNaiyouOsirase.class);

        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = editKykNaiyouOsirase.editInfo(syono, syoriYmd, kykoutoubi,
            syouhnHanmeiKbn, campaignFlg,kawaseRateBean, 2);

        exClassificationEquals(editKykNaiyouOsirase.getBizLogicErrorKbn(), C_ErrorKbn.ERROR, "エラー区分（業務）");
        exStringEquals(editKykNaiyouOsirase.getBizLogicErrorMsg(), MessageUtil.getMessage(MessageId.EBA1048), "エラーメッセージ（業務）");
        exBooleanEquals(gaikaKokyakuTuutiTy == null, true, "外貨建顧客通知Ｆテーブル（中）");

    }

}