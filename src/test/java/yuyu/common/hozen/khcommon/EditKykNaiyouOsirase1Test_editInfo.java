package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.configuration.CoreConfig;
import jp.co.slcs.swak.core.configuration.ProductMode;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.siharai.sicommon.CalcHkShrKngk;
import yuyu.common.siharai.sicommon.CalcHkShrKngkMockForHozen;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.ZT_GaikaKokyakuTuutiTy;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 契約内容のお知らせ編集１クラスのメソッド {@link EditKykNaiyouOsirase1#editInfo(IT_KykKihon,BizDate,BizDate,KawaseRateBean,ZT_GaikaKokyakuTuutiTy)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class EditKykNaiyouOsirase1Test_editInfo {

    @Inject
    private EditKykNaiyouOsirase1 editKykNaiyouOsirase1;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_契約内容のお知らせ編集１";
    private final static String sheetName = "INデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(CalcHkShrKngk.class).to(CalcHkShrKngkMockForHozen.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {

        CalcHkShrKngkMockForHozen.caller = EditKykNaiyouOsirase1Test_editInfo.class;
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.caller = null;
        CalcHkShrKngkMockForHozen.SYORIPTN = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(EditDairitenTesuuryouTblTest_exec_A2.class, fileName, sheetName);

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

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
    }

    @Test
    @TestOrder(10)
    public void testEditInfo_A1() {
        CoreConfig.getInstance().setProductMode(ProductMode.BATCH);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000013");
        BizDate syoriYmd = BizDate.valueOf("20170101");
        BizDate kykoutoubi = BizDate.valueOf("20170101");
        KawaseRateBean kawaseRateBean = new KawaseRateBean();
        kawaseRateBean.setKwsrateKijyunymd1mae(BizDate.valueOf("20180101"));
        kawaseRateBean.setKwsrateUsdjpy1mae(BizNumber.valueOf(10000));
        kawaseRateBean.setKwsrateAudjpy1mae(BizNumber.valueOf(20000));
        kawaseRateBean.setKwsrateKijyunymd2mae(BizDate.valueOf("20180201"));
        kawaseRateBean.setKwsrateUsdjpy2mae(BizNumber.valueOf(30000));
        kawaseRateBean.setKwsrateAudjpy2mae(BizNumber.valueOf(40000));
        kawaseRateBean.setKwsrateKijyunymd3mae(BizDate.valueOf("20180301"));
        kawaseRateBean.setKwsrateUsdjpy3mae(BizNumber.valueOf(50000));
        kawaseRateBean.setKwsrateAudjpy3mae(BizNumber.valueOf(60000));
        kawaseRateBean.setKwsrateKijyunymd4mae(BizDate.valueOf("20180401"));
        kawaseRateBean.setKwsrateUsdjpy4mae(BizNumber.valueOf(70000));
        kawaseRateBean.setKwsrateAudjpy4mae(BizNumber.valueOf(80000));
        kawaseRateBean.setKwsrateKijyunymd5mae(BizDate.valueOf("20180501"));
        kawaseRateBean.setKwsrateUsdjpy5mae(BizNumber.valueOf(90000));
        kawaseRateBean.setKwsrateAudjpy5mae(BizNumber.valueOf(11000));
        kawaseRateBean.setKwsrateKijyunymd6mae(BizDate.valueOf("20180601"));
        kawaseRateBean.setKwsrateUsdjpy6mae(BizNumber.valueOf(22000));
        kawaseRateBean.setKwsrateAudjpy6mae(BizNumber.valueOf(33000));
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;

        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsirase1.editInfo(kykKihon,syoriYmd,kykoutoubi,kawaseRateBean,gaikaKokyakuTuutiTy);

        String syoNo = (String)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "execByKeisanWExt", 0, 0);
        exStringEquals(syoNo, "17806000013", "証券番号");

        BizDate calckijyunYmd = (BizDate)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "execByKeisanWExt", 0, 1);
        exDateEquals(calckijyunYmd, BizDate.valueOf(20170101), "計算基準日");

        C_SiinKbn siinKbn = (C_SiinKbn)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "execByKeisanWExt", 0, 2);
        exClassificationEquals(siinKbn, C_SiinKbn.SP, "死因区分");

        C_HokenkinsyuruiKbn hokenkinsyuruiKbn = (C_HokenkinsyuruiKbn)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "execByKeisanWExt", 0, 3);
        exClassificationEquals(hokenkinsyuruiKbn, C_HokenkinsyuruiKbn.SBHOKENKIN, "保険金種類区分");

        C_Sdpd sdpd =  (C_Sdpd)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "execByKeisanWExt", 0, 4);
        exClassificationEquals(sdpd, C_Sdpd.PD, "Ｓ建Ｐ建区分");

        C_Hrkkeiro hrkkeiro =  (C_Hrkkeiro)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "execByKeisanWExt", 0, 5);
        exClassificationEquals(hrkkeiro, C_Hrkkeiro.BLNK, "払込経路");

        exStringEquals(newGaikaKokyakuTuutiTy.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyaisatumsgcd1(), "03004", "（中継用）挨拶文メッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasetuutisakuseiymwa(), "２０１７年　１月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai1hknkknfromwa(), "２０１７年　９月３０日", "（中継用）第１保険期間至（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai1hknkkn(), "01", "（中継用）第１保険期間");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai2hknkknfromwa(), "２０１７年１０月　１日", "（中継用）第２保険期間自（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai2hknkkntowa(), "２０２６年　９月３０日", "（中継用）第２保険期間至（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai3hknkknfromwa(), "２０２６年１０月　１日", "（中継用）第３保険期間自（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai3hknkknto(), "以降（終身）", "（中継用）第３保険期間至");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyitijibrpkyktuuka(), "100000", "（中継用）一時払保険料（契約通貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykihonsktuuka(), "200000", "（中継用）基本保険金額（契約通貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyenhrkgk(), "10000", "（中継用）円貨払込額");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtystigituukahrkgk(), "", "（中継用）指定外通貨払込額");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhrktuukasyuzn(), "円", "（中継用）払込通貨種類（全）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhrktuukatype(), "JPY", "（中継用）払込通貨タイプ");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyenkhrikmrate(), "3023", "（中継用）円貨払込特約レート");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtystigikwsrate(), "", "（中継用）指定外通貨払込特約レート");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhrkgkhyoujikbn(), "1", "（中継用）払込額表示区分");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykijyunkingaku(), "10000", "（中継用）基準金額");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykjnkngkkawaserate(), "", "（中継用）基準金額為替レート");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykjnkngkhyoujikbn(), "1", "（中継用）基準金額表示区分");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysakuseikijyunymdkwsrate(), "3023", "（中継用）作成基準日時点為替レート");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkhknkkn(), "1", "（中継用）死亡保険金額保険期間");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkhknkknfromwa(), "２０１６年１０月　１日", "（中継用）死亡保険金額保険期間自（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkhknkkntowa(), "２０１７年　９月３０日", "（中継用）死亡保険金額保険期間至（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkkyktuuka(), "1000100", "（中継用）死亡保険金額（契約通貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkyen(), "10001", "（中継用）死亡保険金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysaigaisbhknkngakuumu(), "1", "（中継用）災害死亡保険金額表示有無");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkhyoujikbn(), "2", "（中継用）死亡保険金額表示区分");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysaigaisbhknkngakuktuuka(), "999900", "（中継用）災害死亡保険金額（契約通貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysaigaisbhknkngakukyen(), "9999", "（中継用）災害死亡保険金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitatekngkktuuka(), "444400", "（中継用）保険料積立金額（契約通貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitatekngkkyen(), "4444", "（中継用）保険料積立金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykaiyakuhrkngakkyktuuka(), "333300", "（中継用）解約返戻金額（契約通貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykaiyakuhrkngakyen(), "3333", "（中継用）解約返戻金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtymkhgkyen(), "", "（中継用）目標額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtymkhgkwari(), "", "（中継用）目標額割合");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtymkhgkhyoujikbn(), "0", "（中継用）目標額表示区分");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd1(), "05001", "（中継用）保障内容補足メッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd2(), "05003", "（中継用）保障内容補足メッセージコード２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd3(), "", "（中継用）保障内容補足メッセージコード３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd4(), "05004", "（中継用）保障内容補足メッセージコード４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd5(), "05005", "（中継用）保障内容補足メッセージコード５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd6(), "05007", "（中継用）保障内容補足メッセージコード６");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd1(), "08012", "（中継用）お知らせメッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratekijyunymd1maewa(), "２０１８年　１月　１日", "（中継用）為替レート基準日１ヶ月前（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateusdjpy1mae(), "1000000", "（中継用）為替レート米ドル（円）１ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateaudjpy1mae(), "2000000", "（中継用）為替レート豪ドル（円）１ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratekijyunymd2maewa(), "２０１８年　２月　１日", "（中継用）為替レート基準日２ヶ月前（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateusdjpy2mae(), "3000000", "（中継用）為替レート米ドル（円）２ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateaudjpy2mae(), "4000000", "（中継用）為替レート豪ドル（円）２ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratekijyunymd3maewa(), "２０１８年　３月　１日", "（中継用）為替レート基準日３ヶ月前（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateusdjpy3mae(), "5000000", "（中継用）為替レート米ドル（円）３ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateaudjpy3mae(), "6000000", "（中継用）為替レート豪ドル（円）３ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratekijyunymd4maewa(), "２０１８年　４月　１日", "（中継用）為替レート基準日４ヶ月前（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateusdjpy4mae(), "7000000", "（中継用）為替レート米ドル（円）４ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateaudjpy4mae(), "8000000", "（中継用）為替レート豪ドル（円）４ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratekijyunymd5maewa(), "２０１８年　５月　１日", "（中継用）為替レート基準日５ヶ月前（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateusdjpy5mae(), "9000000", "（中継用）為替レート米ドル（円）５ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateaudjpy5mae(), "1100000", "（中継用）為替レート豪ドル（円）５ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratekijyunymd6maewa(), "２０１８年　６月　１日", "（中継用）為替レート基準日６ヶ月前（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateusdjpy6mae(), "2200000", "（中継用）為替レート米ドル（円）６ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateaudjpy6mae(), "3300000", "（中継用）為替レート豪ドル（円）６ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratemsgcd(), "06001", "（中継用）為替レートメッセージコード");

    }

    @Test
    @TestOrder(20)
    public void testEditInfo_A2() {
        CoreConfig.getInstance().setProductMode(ProductMode.WEB);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000024");
        BizDate syoriYmd = BizDate.valueOf("20170101");
        BizDate kykoutoubi = BizDate.valueOf("20170101");
        KawaseRateBean kawaseRateBean = new KawaseRateBean();
        kawaseRateBean.setKwsrateKijyunymd1mae(BizDate.valueOf("20180101"));
        kawaseRateBean.setKwsrateUsdjpy1mae(BizNumber.valueOf(10000));
        kawaseRateBean.setKwsrateAudjpy1mae(BizNumber.valueOf(20000));
        kawaseRateBean.setKwsrateKijyunymd2mae(BizDate.valueOf("20180201"));
        kawaseRateBean.setKwsrateUsdjpy2mae(BizNumber.valueOf(30000));
        kawaseRateBean.setKwsrateAudjpy2mae(BizNumber.valueOf(40000));
        kawaseRateBean.setKwsrateKijyunymd3mae(BizDate.valueOf("20180301"));
        kawaseRateBean.setKwsrateUsdjpy3mae(BizNumber.valueOf(50000));
        kawaseRateBean.setKwsrateAudjpy3mae(BizNumber.valueOf(60000));
        kawaseRateBean.setKwsrateKijyunymd4mae(BizDate.valueOf("20180401"));
        kawaseRateBean.setKwsrateUsdjpy4mae(BizNumber.valueOf(70000));
        kawaseRateBean.setKwsrateAudjpy4mae(BizNumber.valueOf(80000));
        kawaseRateBean.setKwsrateKijyunymd5mae(BizDate.valueOf("20180501"));
        kawaseRateBean.setKwsrateUsdjpy5mae(BizNumber.valueOf(90000));
        kawaseRateBean.setKwsrateAudjpy5mae(BizNumber.valueOf(11000));
        kawaseRateBean.setKwsrateKijyunymd6mae(BizDate.valueOf("20180601"));
        kawaseRateBean.setKwsrateUsdjpy6mae(BizNumber.valueOf(22000));
        kawaseRateBean.setKwsrateAudjpy6mae(BizNumber.valueOf(33000));
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN2;

        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsirase1.editInfo(kykKihon,syoriYmd,kykoutoubi,kawaseRateBean,gaikaKokyakuTuutiTy);

        exStringEquals(newGaikaKokyakuTuutiTy.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasetuutisakuseiymwa(), "２０１７年　１月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai1hknkknfromwa(), "２０１７年　９月３０日", "（中継用）第１保険期間至（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai1hknkkn(), "01", "（中継用）第１保険期間");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai2hknkknfromwa(), "２０１７年１０月　１日", "（中継用）第２保険期間自（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai2hknkkntowa(), "２０２６年　９月３０日", "（中継用）第２保険期間至（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai3hknkknfromwa(), "２０２６年１０月　１日", "（中継用）第３保険期間自（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai3hknkknto(), "以降（終身）", "（中継用）第３保険期間至");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyitijibrpkyktuuka(), "100000", "（中継用）一時払保険料（契約通貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykihonsktuuka(), "200000", "（中継用）基本保険金額（契約通貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyenhrkgk(), "", "（中継用）円貨払込額");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtystigituukahrkgk(), "1000000", "（中継用）指定外通貨払込額");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhrktuukasyuzn(), "円", "（中継用）払込通貨種類（全）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhrktuukatype(), "JPY", "（中継用）払込通貨タイプ");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyenkhrikmrate(), "", "（中継用）円貨払込特約レート");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtystigikwsrate(), "302350", "（中継用）指定外通貨払込特約レート");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhrkgkhyoujikbn(), "2", "（中継用）払込額表示区分");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykijyunkingaku(), "10000", "（中継用）基準金額");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykjnkngkkawaserate(), "3023", "（中継用）基準金額為替レート");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykjnkngkhyoujikbn(), "2", "（中継用）基準金額表示区分");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysakuseikijyunymdkwsrate(), "3023", "（中継用）作成基準日時点為替レート");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkhknkkn(), "2", "（中継用）死亡保険金額保険期間");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkhknkknfromwa(), "２０１７年１０月　１日", "（中継用）死亡保険金額保険期間自（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkhknkkntowa(), "２０２６年　９月３０日", "（中継用）死亡保険金額保険期間至（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkkyktuuka(), "111100", "（中継用）死亡保険金額（契約通貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkyen(), "1111", "（中継用）死亡保険金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysaigaisbhknkngakuumu(), "0", "（中継用）災害死亡保険金額表示有無");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkhyoujikbn(), "2", "（中継用）死亡保険金額表示区分");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysaigaisbhknkngakuktuuka(), "222200", "（中継用）災害死亡保険金額（契約通貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysaigaisbhknkngakukyen(), "2222", "（中継用）災害死亡保険金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitatekngkktuuka(), "444400", "（中継用）保険料積立金額（契約通貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitatekngkkyen(), "4444", "（中継用）保険料積立金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykaiyakuhrkngakkyktuuka(), "333300", "（中継用）解約返戻金額（契約通貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykaiyakuhrkngakyen(), "3333", "（中継用）解約返戻金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtymkhgkyen(), "10000", "（中継用）目標額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtymkhgkwari(), "0", "（中継用）目標額割合");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtymkhgkhyoujikbn(), "2", "（中継用）目標額表示区分");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd1(), "05001", "（中継用）保障内容補足メッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd2(), "05003", "（中継用）保障内容補足メッセージコード２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd3(), "", "（中継用）保障内容補足メッセージコード３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd4(), "05004", "（中継用）保障内容補足メッセージコード４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd5(), "05007", "（中継用）保障内容補足メッセージコード５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd6(), "", "（中継用）保障内容補足メッセージコード６");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd1(), null, "（中継用）お知らせメッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratekijyunymd1maewa(), "２０１８年　１月　１日", "（中継用）為替レート基準日１ヶ月前（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateusdjpy1mae(), "1000000", "（中継用）為替レート米ドル（円）１ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateaudjpy1mae(), "2000000", "（中継用）為替レート豪ドル（円）１ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratekijyunymd2maewa(), "２０１８年　２月　１日", "（中継用）為替レート基準日２ヶ月前（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateusdjpy2mae(), "3000000", "（中継用）為替レート米ドル（円）２ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateaudjpy2mae(), "4000000", "（中継用）為替レート豪ドル（円）２ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratekijyunymd3maewa(), "２０１８年　３月　１日", "（中継用）為替レート基準日３ヶ月前（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateusdjpy3mae(), "5000000", "（中継用）為替レート米ドル（円）３ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateaudjpy3mae(), "6000000", "（中継用）為替レート豪ドル（円）３ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratekijyunymd4maewa(), "２０１８年　４月　１日", "（中継用）為替レート基準日４ヶ月前（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateusdjpy4mae(), "7000000", "（中継用）為替レート米ドル（円）４ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateaudjpy4mae(), "8000000", "（中継用）為替レート豪ドル（円）４ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratekijyunymd5maewa(), "２０１８年　５月　１日", "（中継用）為替レート基準日５ヶ月前（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateusdjpy5mae(), "9000000", "（中継用）為替レート米ドル（円）５ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateaudjpy5mae(), "1100000", "（中継用）為替レート豪ドル（円）５ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratekijyunymd6maewa(), "２０１８年　６月　１日", "（中継用）為替レート基準日６ヶ月前（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateusdjpy6mae(), "2200000", "（中継用）為替レート米ドル（円）６ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateaudjpy6mae(), "3300000", "（中継用）為替レート豪ドル（円）６ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratemsgcd(), "06001", "（中継用）為替レートメッセージコード");

    }

    @Test
    @TestOrder(30)
    public void testEditInfo_A3() {
        CoreConfig.getInstance().setProductMode(ProductMode.BATCH);

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000035");
        BizDate syoriYmd = BizDate.valueOf("20170201");
        BizDate kykoutoubi = BizDate.valueOf("20170101");
        KawaseRateBean kawaseRateBean = new KawaseRateBean();
        kawaseRateBean.setKwsrateKijyunymd1mae(BizDate.valueOf("20180101"));
        kawaseRateBean.setKwsrateUsdjpy1mae(BizNumber.valueOf(10000));
        kawaseRateBean.setKwsrateAudjpy1mae(BizNumber.valueOf(20000));
        kawaseRateBean.setKwsrateKijyunymd2mae(BizDate.valueOf("20180201"));
        kawaseRateBean.setKwsrateUsdjpy2mae(BizNumber.valueOf(30000));
        kawaseRateBean.setKwsrateAudjpy2mae(BizNumber.valueOf(40000));
        kawaseRateBean.setKwsrateKijyunymd3mae(BizDate.valueOf("20180301"));
        kawaseRateBean.setKwsrateUsdjpy3mae(BizNumber.valueOf(50000));
        kawaseRateBean.setKwsrateAudjpy3mae(BizNumber.valueOf(60000));
        kawaseRateBean.setKwsrateKijyunymd4mae(BizDate.valueOf("20180401"));
        kawaseRateBean.setKwsrateUsdjpy4mae(BizNumber.valueOf(70000));
        kawaseRateBean.setKwsrateAudjpy4mae(BizNumber.valueOf(80000));
        kawaseRateBean.setKwsrateKijyunymd5mae(BizDate.valueOf("20180501"));
        kawaseRateBean.setKwsrateUsdjpy5mae(BizNumber.valueOf(90000));
        kawaseRateBean.setKwsrateAudjpy5mae(BizNumber.valueOf(11000));
        kawaseRateBean.setKwsrateKijyunymd6mae(BizDate.valueOf("20180601"));
        kawaseRateBean.setKwsrateUsdjpy6mae(BizNumber.valueOf(22000));
        kawaseRateBean.setKwsrateAudjpy6mae(BizNumber.valueOf(33000));
        kawaseRateBean.setKwsrateKijyunymd7mae(BizDate.valueOf("20180701"));
        kawaseRateBean.setKwsrateUsdjpy7mae(BizNumber.valueOf(44000));
        kawaseRateBean.setKwsrateAudjpy7mae(BizNumber.valueOf(55000));
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN3;

        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsirase1.editInfo(kykKihon,syoriYmd,kykoutoubi,kawaseRateBean,gaikaKokyakuTuutiTy);

        exStringEquals(newGaikaKokyakuTuutiTy.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasetuutisakuseiymwa(), "２０１７年　１月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai1hknkknfromwa(), "２０１７年　９月３０日", "（中継用）第１保険期間至（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai1hknkkn(), "01", "（中継用）第１保険期間");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai2hknkknfromwa(), "２０１７年１０月　１日", "（中継用）第２保険期間自（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai2hknkkntowa(), "２０２６年　９月３０日", "（中継用）第２保険期間至（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai3hknkknfromwa(), "２０２６年１０月　１日", "（中継用）第３保険期間自（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai3hknkknto(), "以降（終身）", "（中継用）第３保険期間至");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyitijibrpkyktuuka(), "100000", "（中継用）一時払保険料（契約通貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykihonsktuuka(), "200000", "（中継用）基本保険金額（契約通貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyenhrkgk(), "10000", "（中継用）円貨払込額");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtystigituukahrkgk(), "", "（中継用）指定外通貨払込額");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhrktuukasyuzn(), "円", "（中継用）払込通貨種類（全）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhrktuukatype(), "JPY", "（中継用）払込通貨タイプ");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyenkhrikmrate(), "3023", "（中継用）円貨払込特約レート");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtystigikwsrate(), "302350", "（中継用）指定外通貨払込特約レート");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhrkgkhyoujikbn(), "1", "（中継用）払込額表示区分");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykijyunkingaku(), "9999", "（中継用）基準金額");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykjnkngkkawaserate(), "", "（中継用）基準金額為替レート");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykjnkngkhyoujikbn(), "2", "（中継用）基準金額表示区分");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysakuseikijyunymdkwsrate(), "3023", "（中継用）作成基準日時点為替レート");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkhknkkn(), "3", "（中継用）死亡保険金額保険期間");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkhknkknfromwa(), "２０２６年１０月　１日", "（中継用）死亡保険金額保険期間自（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkhknkkntowa(), "以降（終身）", "（中継用）死亡保険金額保険期間至（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkkyktuuka(), "111100", "（中継用）死亡保険金額（契約通貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkyen(), "1111", "（中継用）死亡保険金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysaigaisbhknkngakuumu(), "0", "（中継用）災害死亡保険金額表示有無");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkhyoujikbn(), "2", "（中継用）死亡保険金額表示区分");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysaigaisbhknkngakuktuuka(), "222200", "（中継用）災害死亡保険金額（契約通貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysaigaisbhknkngakukyen(), "2222", "（中継用）災害死亡保険金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitatekngkktuuka(), "444400", "（中継用）保険料積立金額（契約通貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitatekngkkyen(), "4444", "（中継用）保険料積立金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykaiyakuhrkngakkyktuuka(), "333300", "（中継用）解約返戻金額（契約通貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykaiyakuhrkngakyen(), "3333", "（中継用）解約返戻金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtymkhgkyen(), "9999", "（中継用）目標額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtymkhgkwari(), "100", "（中継用）目標額割合");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtymkhgkhyoujikbn(), "1", "（中継用）目標額表示区分");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd1(), "05001", "（中継用）保障内容補足メッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd2(), "05003", "（中継用）保障内容補足メッセージコード２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd3(), "", "（中継用）保障内容補足メッセージコード３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd4(), "05004", "（中継用）保障内容補足メッセージコード４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd5(), "05007", "（中継用）保障内容補足メッセージコード５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd6(), "", "（中継用）保障内容補足メッセージコード６");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd1(), null, "（中継用）お知らせメッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratekijyunymd1maewa(), "２０１８年　２月　１日", "（中継用）為替レート基準日１ヶ月前（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateusdjpy1mae(), "3000000", "（中継用）為替レート米ドル（円）１ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateaudjpy1mae(), "4000000", "（中継用）為替レート豪ドル（円）１ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratekijyunymd2maewa(), "２０１８年　３月　１日", "（中継用）為替レート基準日２ヶ月前（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateusdjpy2mae(), "5000000", "（中継用）為替レート米ドル（円）２ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateaudjpy2mae(), "6000000", "（中継用）為替レート豪ドル（円）２ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratekijyunymd3maewa(), "２０１８年　４月　１日", "（中継用）為替レート基準日３ヶ月前（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateusdjpy3mae(), "7000000", "（中継用）為替レート米ドル（円）３ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateaudjpy3mae(), "8000000", "（中継用）為替レート豪ドル（円）３ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratekijyunymd4maewa(), "２０１８年　５月　１日", "（中継用）為替レート基準日４ヶ月前（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateusdjpy4mae(), "9000000", "（中継用）為替レート米ドル（円）４ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateaudjpy4mae(), "1100000", "（中継用）為替レート豪ドル（円）４ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratekijyunymd5maewa(), "２０１８年　６月　１日", "（中継用）為替レート基準日５ヶ月前（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateusdjpy5mae(), "2200000", "（中継用）為替レート米ドル（円）５ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateaudjpy5mae(), "3300000", "（中継用）為替レート豪ドル（円）５ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratekijyunymd6maewa(), "２０１８年　７月　１日", "（中継用）為替レート基準日６ヶ月前（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateusdjpy6mae(), "4400000", "（中継用）為替レート米ドル（円）６ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateaudjpy6mae(), "5500000", "（中継用）為替レート豪ドル（円）６ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratemsgcd(), "06001", "（中継用）為替レートメッセージコード");

    }

    @Test
    @TestOrder(40)
    public void testEditInfo_A4() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000046");
        BizDate syoriYmd = BizDate.valueOf("20170201");
        BizDate kykoutoubi = BizDate.valueOf("20170101");
        KawaseRateBean kawaseRateBean = new KawaseRateBean();
        kawaseRateBean = null;

        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN3;

        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsirase1.editInfo(kykKihon,syoriYmd,kykoutoubi,kawaseRateBean,gaikaKokyakuTuutiTy);

        exStringEquals(newGaikaKokyakuTuutiTy.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasetuutisakuseiymwa(), "２０１７年　１月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai1hknkknfromwa(), "２０１７年　９月３０日", "（中継用）第１保険期間至（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai1hknkkn(), "01", "（中継用）第１保険期間");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai2hknkknfromwa(), "２０１７年１０月　１日", "（中継用）第２保険期間自（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai2hknkkntowa(), "２０２６年　９月３０日", "（中継用）第２保険期間至（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai3hknkknfromwa(), "２０２６年１０月　１日", "（中継用）第３保険期間自（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai3hknkknto(), "以降（終身）", "（中継用）第３保険期間至");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyitijibrpkyktuuka(), "100000", "（中継用）一時払保険料（契約通貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykihonsktuuka(), "200000", "（中継用）基本保険金額（契約通貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyenhrkgk(), "", "（中継用）円貨払込額");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtystigituukahrkgk(), "", "（中継用）指定外通貨払込額");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhrktuukasyuzn(), "円", "（中継用）払込通貨種類（全）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhrktuukatype(), "JPY", "（中継用）払込通貨タイプ");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyenkhrikmrate(), "", "（中継用）円貨払込特約レート");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtystigikwsrate(), "", "（中継用）指定外通貨払込特約レート");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhrkgkhyoujikbn(), "0", "（中継用）払込額表示区分");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykijyunkingaku(), "", "（中継用）基準金額");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykjnkngkkawaserate(), "3023", "（中継用）基準金額為替レート");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykjnkngkhyoujikbn(), "0", "（中継用）基準金額表示区分");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysakuseikijyunymdkwsrate(), "3023", "（中継用）作成基準日時点為替レート");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkhknkkn(), "3", "（中継用）死亡保険金額保険期間");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkhknkknfromwa(), "２０２６年１０月　１日", "（中継用）死亡保険金額保険期間自（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkhknkkntowa(), "以降（終身）", "（中継用）死亡保険金額保険期間至（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkkyktuuka(), "111100", "（中継用）死亡保険金額（契約通貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkyen(), "1111", "（中継用）死亡保険金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysaigaisbhknkngakuumu(), "0", "（中継用）災害死亡保険金額表示有無");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkhyoujikbn(), "2", "（中継用）死亡保険金額表示区分");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysaigaisbhknkngakuktuuka(), "222200", "（中継用）災害死亡保険金額（契約通貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysaigaisbhknkngakukyen(), "2222", "（中継用）災害死亡保険金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitatekngkktuuka(), "444400", "（中継用）保険料積立金額（契約通貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitatekngkkyen(), "4444", "（中継用）保険料積立金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykaiyakuhrkngakkyktuuka(), "333300", "（中継用）解約返戻金額（契約通貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykaiyakuhrkngakyen(), "3333", "（中継用）解約返戻金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtymkhgkyen(), "", "（中継用）目標額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtymkhgkwari(), "", "（中継用）目標額割合");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtymkhgkhyoujikbn(), "0", "（中継用）目標額表示区分");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd1(), "", "（中継用）保障内容補足メッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd2(), "", "（中継用）保障内容補足メッセージコード２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd3(), "", "（中継用）保障内容補足メッセージコード３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd4(), "05004", "（中継用）保障内容補足メッセージコード４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd5(), "05007", "（中継用）保障内容補足メッセージコード５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd6(), "", "（中継用）保障内容補足メッセージコード６");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd1(), null, "（中継用）お知らせメッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratekijyunymd1maewa(), null, "（中継用）為替レート基準日１ヶ月前（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateusdjpy1mae(), null, "（中継用）為替レート米ドル（円）１ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateaudjpy1mae(), null, "（中継用）為替レート豪ドル（円）１ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratekijyunymd2maewa(), null, "（中継用）為替レート基準日２ヶ月前（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateusdjpy2mae(), null, "（中継用）為替レート米ドル（円）２ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateaudjpy2mae(), null, "（中継用）為替レート豪ドル（円）２ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratekijyunymd3maewa(), null, "（中継用）為替レート基準日３ヶ月前（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateusdjpy3mae(), null, "（中継用）為替レート米ドル（円）３ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateaudjpy3mae(), null, "（中継用）為替レート豪ドル（円）３ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratekijyunymd4maewa(), null, "（中継用）為替レート基準日４ヶ月前（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateusdjpy4mae(), null, "（中継用）為替レート米ドル（円）４ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateaudjpy4mae(), null, "（中継用）為替レート豪ドル（円）４ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratekijyunymd5maewa(), null, "（中継用）為替レート基準日５ヶ月前（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateusdjpy5mae(), null, "（中継用）為替レート米ドル（円）５ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateaudjpy5mae(), null, "（中継用）為替レート豪ドル（円）５ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratekijyunymd6maewa(), null, "（中継用）為替レート基準日６ヶ月前（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateusdjpy6mae(), null, "（中継用）為替レート米ドル（円）６ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateaudjpy6mae(), null, "（中継用）為替レート豪ドル（円）６ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratemsgcd(), null, "（中継用）為替レートメッセージコード");

    }

    @Test
    @TestOrder(50)
    public void testEditInfo_A5() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000057");
        BizDate syoriYmd = BizDate.valueOf("20170201");
        BizDate kykoutoubi = BizDate.valueOf("20170101");
        KawaseRateBean kawaseRateBean = new KawaseRateBean();
        kawaseRateBean = null;

        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN3;

        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsirase1.editInfo(kykKihon,syoriYmd,kykoutoubi,kawaseRateBean,gaikaKokyakuTuutiTy);

        exStringEquals(newGaikaKokyakuTuutiTy.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasetuutisakuseiymwa(), "２０１７年　１月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai1hknkknfromwa(), "２０１７年　９月３０日", "（中継用）第１保険期間至（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai1hknkkn(), "01", "（中継用）第１保険期間");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai2hknkknfromwa(), "２０１７年１０月　１日", "（中継用）第２保険期間自（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai2hknkkntowa(), "２０２６年　９月３０日", "（中継用）第２保険期間至（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai3hknkknfromwa(), "２０２６年１０月　１日", "（中継用）第３保険期間自（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai3hknkknto(), "以降（終身）", "（中継用）第３保険期間至");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyitijibrpkyktuuka(), "100000", "（中継用）一時払保険料（契約通貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykihonsktuuka(), "200000", "（中継用）基本保険金額（契約通貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyenhrkgk(), "", "（中継用）円貨払込額");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtystigituukahrkgk(), "", "（中継用）指定外通貨払込額");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhrktuukasyuzn(), "円", "（中継用）払込通貨種類（全）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhrktuukatype(), "JPY", "（中継用）払込通貨タイプ");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyenkhrikmrate(), "", "（中継用）円貨払込特約レート");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtystigikwsrate(), "", "（中継用）指定外通貨払込特約レート");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhrkgkhyoujikbn(), "0", "（中継用）払込額表示区分");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykijyunkingaku(), "10000", "（中継用）基準金額");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykjnkngkkawaserate(), "3023", "（中継用）基準金額為替レート");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykjnkngkhyoujikbn(), "2", "（中継用）基準金額表示区分");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysakuseikijyunymdkwsrate(), "3023", "（中継用）作成基準日時点為替レート");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkhknkkn(), "3", "（中継用）死亡保険金額保険期間");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkhknkknfromwa(), "２０２６年１０月　１日", "（中継用）死亡保険金額保険期間自（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkhknkkntowa(), "以降（終身）", "（中継用）死亡保険金額保険期間至（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkkyktuuka(), "111100", "（中継用）死亡保険金額（契約通貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkyen(), "1111", "（中継用）死亡保険金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysaigaisbhknkngakuumu(), "0", "（中継用）災害死亡保険金額表示有無");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkhyoujikbn(), "2", "（中継用）死亡保険金額表示区分");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysaigaisbhknkngakuktuuka(), "222200", "（中継用）災害死亡保険金額（契約通貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysaigaisbhknkngakukyen(), "2222", "（中継用）災害死亡保険金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitatekngkktuuka(), "444400", "（中継用）保険料積立金額（契約通貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitatekngkkyen(), "4444", "（中継用）保険料積立金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykaiyakuhrkngakkyktuuka(), "333300", "（中継用）解約返戻金額（契約通貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykaiyakuhrkngakyen(), "3333", "（中継用）解約返戻金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtymkhgkyen(), "", "（中継用）目標額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtymkhgkwari(), "", "（中継用）目標額割合");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtymkhgkhyoujikbn(), "0", "（中継用）目標額表示区分");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd1(), "05002", "（中継用）保障内容補足メッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd2(), "", "（中継用）保障内容補足メッセージコード２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd3(), "", "（中継用）保障内容補足メッセージコード３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd4(), "05004", "（中継用）保障内容補足メッセージコード４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd5(), "05007", "（中継用）保障内容補足メッセージコード５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd6(), "", "（中継用）保障内容補足メッセージコード６");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd1(), null, "（中継用）お知らせメッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratekijyunymd1maewa(), null, "（中継用）為替レート基準日１ヶ月前（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateusdjpy1mae(), null, "（中継用）為替レート米ドル（円）１ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateaudjpy1mae(), null, "（中継用）為替レート豪ドル（円）１ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratekijyunymd2maewa(), null, "（中継用）為替レート基準日２ヶ月前（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateusdjpy2mae(), null, "（中継用）為替レート米ドル（円）２ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateaudjpy2mae(), null, "（中継用）為替レート豪ドル（円）２ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratekijyunymd3maewa(), null, "（中継用）為替レート基準日３ヶ月前（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateusdjpy3mae(), null, "（中継用）為替レート米ドル（円）３ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateaudjpy3mae(), null, "（中継用）為替レート豪ドル（円）３ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratekijyunymd4maewa(), null, "（中継用）為替レート基準日４ヶ月前（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateusdjpy4mae(), null, "（中継用）為替レート米ドル（円）４ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateaudjpy4mae(), null, "（中継用）為替レート豪ドル（円）４ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratekijyunymd5maewa(), null, "（中継用）為替レート基準日５ヶ月前（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateusdjpy5mae(), null, "（中継用）為替レート米ドル（円）５ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateaudjpy5mae(), null, "（中継用）為替レート豪ドル（円）５ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratekijyunymd6maewa(), null, "（中継用）為替レート基準日６ヶ月前（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateusdjpy6mae(), null, "（中継用）為替レート米ドル（円）６ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateaudjpy6mae(), null, "（中継用）為替レート豪ドル（円）６ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratemsgcd(), null, "（中継用）為替レートメッセージコード");

    }

    @Test
    @TestOrder(60)
    public void testEditInfo_A6() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000068");
        BizDate syoriYmd = BizDate.valueOf("20170201");
        BizDate kykoutoubi = BizDate.valueOf("20170101");
        KawaseRateBean kawaseRateBean = new KawaseRateBean();
        kawaseRateBean = null;

        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN5;

        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsirase1.editInfo(kykKihon,syoriYmd,kykoutoubi,kawaseRateBean,gaikaKokyakuTuutiTy);

        exStringEquals(newGaikaKokyakuTuutiTy.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasetuutisakuseiymwa(), "２０１７年　１月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai1hknkknfromwa(), "２０１７年　９月３０日", "（中継用）第１保険期間至（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai1hknkkn(), "01", "（中継用）第１保険期間");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai2hknkknfromwa(), "２０１７年１０月　１日", "（中継用）第２保険期間自（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai2hknkkntowa(), "２０２６年　９月３０日", "（中継用）第２保険期間至（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai3hknkknfromwa(), "２０２６年１０月　１日", "（中継用）第３保険期間自（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai3hknkknto(), "以降（終身）", "（中継用）第３保険期間至");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyitijibrpkyktuuka(), "100000", "（中継用）一時払保険料（契約通貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykihonsktuuka(), "200000", "（中継用）基本保険金額（契約通貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyenhrkgk(), "10000", "（中継用）円貨払込額");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtystigituukahrkgk(), "", "（中継用）指定外通貨払込額");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhrktuukasyuzn(), "円", "（中継用）払込通貨種類（全）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhrktuukatype(), "JPY", "（中継用）払込通貨タイプ");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyenkhrikmrate(), "3023", "（中継用）円貨払込特約レート");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtystigikwsrate(), "", "（中継用）指定外通貨払込特約レート");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhrkgkhyoujikbn(), "1", "（中継用）払込額表示区分");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykijyunkingaku(), "", "（中継用）基準金額");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykjnkngkkawaserate(), "", "（中継用）基準金額為替レート");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykjnkngkhyoujikbn(), "0", "（中継用）基準金額表示区分");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysakuseikijyunymdkwsrate(), "3023", "（中継用）作成基準日時点為替レート");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkhknkkn(), "1", "（中継用）死亡保険金額保険期間");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkhknkknfromwa(), "２０１６年１０月　１日", "（中継用）死亡保険金額保険期間自（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkhknkkntowa(), "２０１７年　９月３０日", "（中継用）死亡保険金額保険期間至（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkkyktuuka(), "999900", "（中継用）死亡保険金額（契約通貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkyen(), "9999", "（中継用）死亡保険金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysaigaisbhknkngakuumu(), "2", "（中継用）災害死亡保険金額表示有無");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkhyoujikbn(), "2", "（中継用）死亡保険金額表示区分");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysaigaisbhknkngakuktuuka(), "1000000", "（中継用）災害死亡保険金額（契約通貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysaigaisbhknkngakukyen(), "10000", "（中継用）災害死亡保険金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitatekngkktuuka(), "444400", "（中継用）保険料積立金額（契約通貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitatekngkkyen(), "4444", "（中継用）保険料積立金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykaiyakuhrkngakkyktuuka(), "333300", "（中継用）解約返戻金額（契約通貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykaiyakuhrkngakyen(), "3333", "（中継用）解約返戻金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtymkhgkyen(), "", "（中継用）目標額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtymkhgkwari(), "", "（中継用）目標額割合");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtymkhgkhyoujikbn(), "0", "（中継用）目標額表示区分");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd1(), "05001", "（中継用）保障内容補足メッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd2(), "", "（中継用）保障内容補足メッセージコード２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd3(), "", "（中継用）保障内容補足メッセージコード３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd4(), "05004", "（中継用）保障内容補足メッセージコード４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd5(), "05005", "（中継用）保障内容補足メッセージコード５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd6(), "05007", "（中継用）保障内容補足メッセージコード６");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd1(), "08012", "（中継用）お知らせメッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratekijyunymd1maewa(), null, "（中継用）為替レート基準日１ヶ月前（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateusdjpy1mae(), null, "（中継用）為替レート米ドル（円）１ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateaudjpy1mae(), null, "（中継用）為替レート豪ドル（円）１ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratekijyunymd2maewa(), null, "（中継用）為替レート基準日２ヶ月前（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateusdjpy2mae(), null, "（中継用）為替レート米ドル（円）２ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateaudjpy2mae(), null, "（中継用）為替レート豪ドル（円）２ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratekijyunymd3maewa(), null, "（中継用）為替レート基準日３ヶ月前（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateusdjpy3mae(), null, "（中継用）為替レート米ドル（円）３ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateaudjpy3mae(), null, "（中継用）為替レート豪ドル（円）３ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratekijyunymd4maewa(), null, "（中継用）為替レート基準日４ヶ月前（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateusdjpy4mae(), null, "（中継用）為替レート米ドル（円）４ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateaudjpy4mae(), null, "（中継用）為替レート豪ドル（円）４ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratekijyunymd5maewa(), null, "（中継用）為替レート基準日５ヶ月前（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateusdjpy5mae(), null, "（中継用）為替レート米ドル（円）５ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateaudjpy5mae(), null, "（中継用）為替レート豪ドル（円）５ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratekijyunymd6maewa(), null, "（中継用）為替レート基準日６ヶ月前（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateusdjpy6mae(), null, "（中継用）為替レート米ドル（円）６ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateaudjpy6mae(), null, "（中継用）為替レート豪ドル（円）６ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratemsgcd(), null, "（中継用）為替レートメッセージコード");

    }

    @Test
    @TestOrder(70)
    public void testEditInfo_A7() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000079");
        BizDate syoriYmd = BizDate.valueOf("20170201");
        BizDate kykoutoubi = BizDate.valueOf("20170101");
        KawaseRateBean kawaseRateBean = new KawaseRateBean();
        kawaseRateBean = null;

        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN5;

        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsirase1.editInfo(kykKihon,syoriYmd,kykoutoubi,kawaseRateBean,gaikaKokyakuTuutiTy);

        exStringEquals(newGaikaKokyakuTuutiTy.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasetuutisakuseiymwa(), "２０１７年　１月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai1hknkknfromwa(), "２０１７年　９月３０日", "（中継用）第１保険期間至（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai1hknkkn(), "01", "（中継用）第１保険期間");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai2hknkknfromwa(), "２０１７年１０月　１日", "（中継用）第２保険期間自（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai2hknkkntowa(), "２０２６年　９月３０日", "（中継用）第２保険期間至（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai3hknkknfromwa(), "２０２６年１０月　１日", "（中継用）第３保険期間自（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai3hknkknto(), "以降（終身）", "（中継用）第３保険期間至");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyitijibrpkyktuuka(), "100000", "（中継用）一時払保険料（契約通貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykihonsktuuka(), "200000", "（中継用）基本保険金額（契約通貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyenhrkgk(), "10000", "（中継用）円貨払込額");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtystigituukahrkgk(), "", "（中継用）指定外通貨払込額");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhrktuukasyuzn(), "円", "（中継用）払込通貨種類（全）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhrktuukatype(), "JPY", "（中継用）払込通貨タイプ");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyenkhrikmrate(), "3023", "（中継用）円貨払込特約レート");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtystigikwsrate(), "", "（中継用）指定外通貨払込特約レート");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhrkgkhyoujikbn(), "1", "（中継用）払込額表示区分");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykijyunkingaku(), "10000", "（中継用）基準金額");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykjnkngkkawaserate(), "", "（中継用）基準金額為替レート");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykjnkngkhyoujikbn(), "1", "（中継用）基準金額表示区分");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysakuseikijyunymdkwsrate(), "3023", "（中継用）作成基準日時点為替レート");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkhknkkn(), "1", "（中継用）死亡保険金額保険期間");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkhknkknfromwa(), "２０１６年１０月　１日", "（中継用）死亡保険金額保険期間自（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkhknkkntowa(), "２０１７年　９月３０日", "（中継用）死亡保険金額保険期間至（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkkyktuuka(), "999900", "（中継用）死亡保険金額（契約通貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkyen(), "9999", "（中継用）死亡保険金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysaigaisbhknkngakuumu(), "1", "（中継用）災害死亡保険金額表示有無");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkhyoujikbn(), "1", "（中継用）死亡保険金額表示区分");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysaigaisbhknkngakuktuuka(), "1000000", "（中継用）災害死亡保険金額（契約通貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysaigaisbhknkngakukyen(), "10000", "（中継用）災害死亡保険金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitatekngkktuuka(), "444400", "（中継用）保険料積立金額（契約通貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitatekngkkyen(), "4444", "（中継用）保険料積立金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykaiyakuhrkngakkyktuuka(), "333300", "（中継用）解約返戻金額（契約通貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykaiyakuhrkngakyen(), "3333", "（中継用）解約返戻金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtymkhgkyen(), "", "（中継用）目標額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtymkhgkwari(), "", "（中継用）目標額割合");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtymkhgkhyoujikbn(), "0", "（中継用）目標額表示区分");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd1(), "05001", "（中継用）保障内容補足メッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd2(), "05003", "（中継用）保障内容補足メッセージコード２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd3(), "", "（中継用）保障内容補足メッセージコード３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd4(), "05004", "（中継用）保障内容補足メッセージコード４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd5(), "05005", "（中継用）保障内容補足メッセージコード５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd6(), "05007", "（中継用）保障内容補足メッセージコード６");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd1(), "08012", "（中継用）お知らせメッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratekijyunymd1maewa(), null, "（中継用）為替レート基準日１ヶ月前（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateusdjpy1mae(), null, "（中継用）為替レート米ドル（円）１ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateaudjpy1mae(), null, "（中継用）為替レート豪ドル（円）１ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratekijyunymd2maewa(), null, "（中継用）為替レート基準日２ヶ月前（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateusdjpy2mae(), null, "（中継用）為替レート米ドル（円）２ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateaudjpy2mae(), null, "（中継用）為替レート豪ドル（円）２ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratekijyunymd3maewa(), null, "（中継用）為替レート基準日３ヶ月前（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateusdjpy3mae(), null, "（中継用）為替レート米ドル（円）３ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateaudjpy3mae(), null, "（中継用）為替レート豪ドル（円）３ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratekijyunymd4maewa(), null, "（中継用）為替レート基準日４ヶ月前（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateusdjpy4mae(), null, "（中継用）為替レート米ドル（円）４ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateaudjpy4mae(), null, "（中継用）為替レート豪ドル（円）４ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratekijyunymd5maewa(), null, "（中継用）為替レート基準日５ヶ月前（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateusdjpy5mae(), null, "（中継用）為替レート米ドル（円）５ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateaudjpy5mae(), null, "（中継用）為替レート豪ドル（円）５ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratekijyunymd6maewa(), null, "（中継用）為替レート基準日６ヶ月前（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateusdjpy6mae(), null, "（中継用）為替レート米ドル（円）６ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateaudjpy6mae(), null, "（中継用）為替レート豪ドル（円）６ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratemsgcd(), null, "（中継用）為替レートメッセージコード");

    }

    @Test
    @TestOrder(80)
    public void testEditInfo_A8() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000080");
        BizDate syoriYmd = BizDate.valueOf("20170201");
        BizDate kykoutoubi = BizDate.valueOf("20170101");
        KawaseRateBean kawaseRateBean = new KawaseRateBean();
        kawaseRateBean = null;

        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN6;

        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsirase1.editInfo(kykKihon,syoriYmd,kykoutoubi,kawaseRateBean,gaikaKokyakuTuutiTy);

        exStringEquals(newGaikaKokyakuTuutiTy.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasetuutisakuseiymwa(), "２０１７年　１月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai1hknkknfromwa(), "２０１７年　９月３０日", "（中継用）第１保険期間至（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai1hknkkn(), "01", "（中継用）第１保険期間");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai2hknkknfromwa(), "２０１７年１０月　１日", "（中継用）第２保険期間自（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai2hknkkntowa(), "２０２６年　９月３０日", "（中継用）第２保険期間至（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai3hknkknfromwa(), "２０２６年１０月　１日", "（中継用）第３保険期間自（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai3hknkknto(), "以降（終身）", "（中継用）第３保険期間至");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyitijibrpkyktuuka(), "100000", "（中継用）一時払保険料（契約通貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykihonsktuuka(), "200000", "（中継用）基本保険金額（契約通貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyenhrkgk(), "10000", "（中継用）円貨払込額");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtystigituukahrkgk(), "", "（中継用）指定外通貨払込額");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhrktuukasyuzn(), "円", "（中継用）払込通貨種類（全）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhrktuukatype(), "JPY", "（中継用）払込通貨タイプ");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyenkhrikmrate(), "3023", "（中継用）円貨払込特約レート");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtystigikwsrate(), "", "（中継用）指定外通貨払込特約レート");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhrkgkhyoujikbn(), "1", "（中継用）払込額表示区分");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykijyunkingaku(), "10000", "（中継用）基準金額");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykjnkngkkawaserate(), "", "（中継用）基準金額為替レート");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykjnkngkhyoujikbn(), "1", "（中継用）基準金額表示区分");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysakuseikijyunymdkwsrate(), "3023", "（中継用）作成基準日時点為替レート");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkhknkkn(), "1", "（中継用）死亡保険金額保険期間");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkhknkknfromwa(), "２０１６年１０月　１日", "（中継用）死亡保険金額保険期間自（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkhknkkntowa(), "２０１７年　９月３０日", "（中継用）死亡保険金額保険期間至（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkkyktuuka(), "1000000", "（中継用）死亡保険金額（契約通貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkyen(), "10000", "（中継用）死亡保険金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysaigaisbhknkngakuumu(), "2", "（中継用）災害死亡保険金額表示有無");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkhyoujikbn(), "1", "（中継用）死亡保険金額表示区分");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysaigaisbhknkngakuktuuka(), "1000100", "（中継用）災害死亡保険金額（契約通貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysaigaisbhknkngakukyen(), "10001", "（中継用）災害死亡保険金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitatekngkktuuka(), "444400", "（中継用）保険料積立金額（契約通貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitatekngkkyen(), "4444", "（中継用）保険料積立金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykaiyakuhrkngakkyktuuka(), "333300", "（中継用）解約返戻金額（契約通貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykaiyakuhrkngakyen(), "3333", "（中継用）解約返戻金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtymkhgkyen(), "", "（中継用）目標額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtymkhgkwari(), "", "（中継用）目標額割合");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtymkhgkhyoujikbn(), "0", "（中継用）目標額表示区分");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd1(), "05001", "（中継用）保障内容補足メッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd2(), "05003", "（中継用）保障内容補足メッセージコード２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd3(), "", "（中継用）保障内容補足メッセージコード３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd4(), "05004", "（中継用）保障内容補足メッセージコード４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd5(), "05005", "（中継用）保障内容補足メッセージコード５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd6(), "05007", "（中継用）保障内容補足メッセージコード６");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd1(), "08012", "（中継用）お知らせメッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratekijyunymd1maewa(), null, "（中継用）為替レート基準日１ヶ月前（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateusdjpy1mae(), null, "（中継用）為替レート米ドル（円）１ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateaudjpy1mae(), null, "（中継用）為替レート豪ドル（円）１ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratekijyunymd2maewa(), null, "（中継用）為替レート基準日２ヶ月前（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateusdjpy2mae(), null, "（中継用）為替レート米ドル（円）２ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateaudjpy2mae(), null, "（中継用）為替レート豪ドル（円）２ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratekijyunymd3maewa(), null, "（中継用）為替レート基準日３ヶ月前（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateusdjpy3mae(), null, "（中継用）為替レート米ドル（円）３ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateaudjpy3mae(), null, "（中継用）為替レート豪ドル（円）３ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratekijyunymd4maewa(), null, "（中継用）為替レート基準日４ヶ月前（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateusdjpy4mae(), null, "（中継用）為替レート米ドル（円）４ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateaudjpy4mae(), null, "（中継用）為替レート豪ドル（円）４ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratekijyunymd5maewa(), null, "（中継用）為替レート基準日５ヶ月前（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateusdjpy5mae(), null, "（中継用）為替レート米ドル（円）５ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateaudjpy5mae(), null, "（中継用）為替レート豪ドル（円）５ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratekijyunymd6maewa(), null, "（中継用）為替レート基準日６ヶ月前（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateusdjpy6mae(), null, "（中継用）為替レート米ドル（円）６ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateaudjpy6mae(), null, "（中継用）為替レート豪ドル（円）６ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratemsgcd(), null, "（中継用）為替レートメッセージコード");

    }

    @Test
    @TestOrder(90)
    public void testEditInfo_A9() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000091");
        BizDate syoriYmd = BizDate.valueOf("20170201");
        BizDate kykoutoubi = BizDate.valueOf("20170101");
        KawaseRateBean kawaseRateBean = new KawaseRateBean();
        kawaseRateBean = null;

        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN3;

        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsirase1.editInfo(kykKihon,syoriYmd,kykoutoubi,kawaseRateBean,gaikaKokyakuTuutiTy);

        exStringEquals(newGaikaKokyakuTuutiTy.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasetuutisakuseiymwa(), "２０１７年　１月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai1hknkknfromwa(), "２０１７年　９月３０日", "（中継用）第１保険期間至（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai1hknkkn(), "01", "（中継用）第１保険期間");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai2hknkknfromwa(), "２０１７年１０月　１日", "（中継用）第２保険期間自（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai2hknkkntowa(), "２０２６年　９月３０日", "（中継用）第２保険期間至（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai3hknkknfromwa(), "２０２６年１０月　１日", "（中継用）第３保険期間自（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai3hknkknto(), "以降（終身）", "（中継用）第３保険期間至");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyitijibrpkyktuuka(), "100000", "（中継用）一時払保険料（契約通貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykihonsktuuka(), "200000", "（中継用）基本保険金額（契約通貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyenhrkgk(), "10000", "（中継用）円貨払込額");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtystigituukahrkgk(), "", "（中継用）指定外通貨払込額");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhrktuukasyuzn(), "円", "（中継用）払込通貨種類（全）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhrktuukatype(), "JPY", "（中継用）払込通貨タイプ");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyenkhrikmrate(), "3023", "（中継用）円貨払込特約レート");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtystigikwsrate(), "", "（中継用）指定外通貨払込特約レート");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhrkgkhyoujikbn(), "1", "（中継用）払込額表示区分");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykijyunkingaku(), "", "（中継用）基準金額");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykjnkngkkawaserate(), "", "（中継用）基準金額為替レート");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykjnkngkhyoujikbn(), "0", "（中継用）基準金額表示区分");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysakuseikijyunymdkwsrate(), "3023", "（中継用）作成基準日時点為替レート");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkhknkkn(), "3", "（中継用）死亡保険金額保険期間");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkhknkknfromwa(), "２０２６年１０月　１日", "（中継用）死亡保険金額保険期間自（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkhknkkntowa(), "以降（終身）", "（中継用）死亡保険金額保険期間至（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkkyktuuka(), "111100", "（中継用）死亡保険金額（契約通貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkyen(), "1111", "（中継用）死亡保険金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysaigaisbhknkngakuumu(), "0", "（中継用）災害死亡保険金額表示有無");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkhyoujikbn(), "2", "（中継用）死亡保険金額表示区分");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysaigaisbhknkngakuktuuka(), "222200", "（中継用）災害死亡保険金額（契約通貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysaigaisbhknkngakukyen(), "2222", "（中継用）災害死亡保険金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitatekngkktuuka(), "444400", "（中継用）保険料積立金額（契約通貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitatekngkkyen(), "4444", "（中継用）保険料積立金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykaiyakuhrkngakkyktuuka(), "333300", "（中継用）解約返戻金額（契約通貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykaiyakuhrkngakyen(), "3333", "（中継用）解約返戻金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtymkhgkyen(), "", "（中継用）目標額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtymkhgkwari(), "", "（中継用）目標額割合");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtymkhgkhyoujikbn(), "0", "（中継用）目標額表示区分");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd1(), "05001", "（中継用）保障内容補足メッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd2(), "", "（中継用）保障内容補足メッセージコード２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd3(), "", "（中継用）保障内容補足メッセージコード３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd4(), "05004", "（中継用）保障内容補足メッセージコード４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd5(), "05007", "（中継用）保障内容補足メッセージコード５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd6(), "", "（中継用）保障内容補足メッセージコード６");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd1(), null, "（中継用）お知らせメッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratekijyunymd1maewa(), null, "（中継用）為替レート基準日１ヶ月前（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateusdjpy1mae(), null, "（中継用）為替レート米ドル（円）１ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateaudjpy1mae(), null, "（中継用）為替レート豪ドル（円）１ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratekijyunymd2maewa(), null, "（中継用）為替レート基準日２ヶ月前（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateusdjpy2mae(), null, "（中継用）為替レート米ドル（円）２ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateaudjpy2mae(), null, "（中継用）為替レート豪ドル（円）２ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratekijyunymd3maewa(), null, "（中継用）為替レート基準日３ヶ月前（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateusdjpy3mae(), null, "（中継用）為替レート米ドル（円）３ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateaudjpy3mae(), null, "（中継用）為替レート豪ドル（円）３ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratekijyunymd4maewa(), null, "（中継用）為替レート基準日４ヶ月前（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateusdjpy4mae(), null, "（中継用）為替レート米ドル（円）４ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateaudjpy4mae(), null, "（中継用）為替レート豪ドル（円）４ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratekijyunymd5maewa(), null, "（中継用）為替レート基準日５ヶ月前（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateusdjpy5mae(), null, "（中継用）為替レート米ドル（円）５ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateaudjpy5mae(), null, "（中継用）為替レート豪ドル（円）５ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratekijyunymd6maewa(), null, "（中継用）為替レート基準日６ヶ月前（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateusdjpy6mae(), null, "（中継用）為替レート米ドル（円）６ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateaudjpy6mae(), null, "（中継用）為替レート豪ドル（円）６ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratemsgcd(), null, "（中継用）為替レートメッセージコード");

    }

    @Test
    @TestOrder(100)
    public void testEditInfo_A10() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000105");
        BizDate syoriYmd = BizDate.valueOf("20170201");
        BizDate kykoutoubi = BizDate.valueOf("20170101");
        KawaseRateBean kawaseRateBean = new KawaseRateBean();
        kawaseRateBean = null;

        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN3;

        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsirase1.editInfo(kykKihon,syoriYmd,kykoutoubi,kawaseRateBean,gaikaKokyakuTuutiTy);

        exStringEquals(newGaikaKokyakuTuutiTy.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasetuutisakuseiymwa(), "２０１７年　１月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai1hknkknfromwa(), "２０１７年　９月３０日", "（中継用）第１保険期間至（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai1hknkkn(), "01", "（中継用）第１保険期間");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai2hknkknfromwa(), "２０１７年１０月　１日", "（中継用）第２保険期間自（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai2hknkkntowa(), "２０２６年　９月３０日", "（中継用）第２保険期間至（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai3hknkknfromwa(), "２０２６年１０月　１日", "（中継用）第３保険期間自（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai3hknkknto(), "以降（終身）", "（中継用）第３保険期間至");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyitijibrpkyktuuka(), "100000", "（中継用）一時払保険料（契約通貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykihonsktuuka(), "200000", "（中継用）基本保険金額（契約通貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyenhrkgk(), "10000", "（中継用）円貨払込額");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtystigituukahrkgk(), "", "（中継用）指定外通貨払込額");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhrktuukasyuzn(), "円", "（中継用）払込通貨種類（全）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhrktuukatype(), "JPY", "（中継用）払込通貨タイプ");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyenkhrikmrate(), "3023", "（中継用）円貨払込特約レート");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtystigikwsrate(), "", "（中継用）指定外通貨払込特約レート");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhrkgkhyoujikbn(), "1", "（中継用）払込額表示区分");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykijyunkingaku(), "", "（中継用）基準金額");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykjnkngkkawaserate(), "", "（中継用）基準金額為替レート");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykjnkngkhyoujikbn(), "0", "（中継用）基準金額表示区分");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysakuseikijyunymdkwsrate(), "3023", "（中継用）作成基準日時点為替レート");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkhknkkn(), "3", "（中継用）死亡保険金額保険期間");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkhknkknfromwa(), "２０２６年１０月　１日", "（中継用）死亡保険金額保険期間自（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkhknkkntowa(), "以降（終身）", "（中継用）死亡保険金額保険期間至（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkkyktuuka(), "111100", "（中継用）死亡保険金額（契約通貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkyen(), "1111", "（中継用）死亡保険金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysaigaisbhknkngakuumu(), "0", "（中継用）災害死亡保険金額表示有無");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkhyoujikbn(), "2", "（中継用）死亡保険金額表示区分");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysaigaisbhknkngakuktuuka(), "222200", "（中継用）災害死亡保険金額（契約通貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysaigaisbhknkngakukyen(), "2222", "（中継用）災害死亡保険金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitatekngkktuuka(), "444400", "（中継用）保険料積立金額（契約通貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitatekngkkyen(), "4444", "（中継用）保険料積立金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykaiyakuhrkngakkyktuuka(), "333300", "（中継用）解約返戻金額（契約通貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykaiyakuhrkngakyen(), "3333", "（中継用）解約返戻金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtymkhgkyen(), "", "（中継用）目標額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtymkhgkwari(), "", "（中継用）目標額割合");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtymkhgkhyoujikbn(), "0", "（中継用）目標額表示区分");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd1(), "05001", "（中継用）保障内容補足メッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd2(), "", "（中継用）保障内容補足メッセージコード２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd3(), "", "（中継用）保障内容補足メッセージコード３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd4(), "05004", "（中継用）保障内容補足メッセージコード４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd5(), "05007", "（中継用）保障内容補足メッセージコード５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd6(), "", "（中継用）保障内容補足メッセージコード６");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd1(), null, "（中継用）お知らせメッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratekijyunymd1maewa(), null, "（中継用）為替レート基準日１ヶ月前（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateusdjpy1mae(), null, "（中継用）為替レート米ドル（円）１ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateaudjpy1mae(), null, "（中継用）為替レート豪ドル（円）１ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratekijyunymd2maewa(), null, "（中継用）為替レート基準日２ヶ月前（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateusdjpy2mae(), null, "（中継用）為替レート米ドル（円）２ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateaudjpy2mae(), null, "（中継用）為替レート豪ドル（円）２ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratekijyunymd3maewa(), null, "（中継用）為替レート基準日３ヶ月前（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateusdjpy3mae(), null, "（中継用）為替レート米ドル（円）３ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateaudjpy3mae(), null, "（中継用）為替レート豪ドル（円）３ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratekijyunymd4maewa(), null, "（中継用）為替レート基準日４ヶ月前（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateusdjpy4mae(), null, "（中継用）為替レート米ドル（円）４ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateaudjpy4mae(), null, "（中継用）為替レート豪ドル（円）４ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratekijyunymd5maewa(), null, "（中継用）為替レート基準日５ヶ月前（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateusdjpy5mae(), null, "（中継用）為替レート米ドル（円）５ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateaudjpy5mae(), null, "（中継用）為替レート豪ドル（円）５ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratekijyunymd6maewa(), null, "（中継用）為替レート基準日６ヶ月前（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateusdjpy6mae(), null, "（中継用）為替レート米ドル（円）６ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsrateaudjpy6mae(), null, "（中継用）為替レート豪ドル（円）６ヶ月前");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykwsratemsgcd(), null, "（中継用）為替レートメッセージコード");

    }

    @Test
    @TestOrder(110)
    public void testEditInfo_A11() {
        CoreConfig.getInstance().setProductMode(ProductMode.BATCH);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000091");
        BizDate syoriYmd = BizDate.valueOf("20170201");
        BizDate kykoutoubi = BizDate.valueOf("20170101");
        KawaseRateBean kawaseRateBean = new KawaseRateBean();
        kawaseRateBean = null;

        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN4;

        editKykNaiyouOsirase1.editInfo(kykKihon,syoriYmd,kykoutoubi,kawaseRateBean,gaikaKokyakuTuutiTy);

        C_ErrorKbn errkbn = editKykNaiyouOsirase1.getCommonErrorKbn();

        exClassificationEquals(errkbn, C_ErrorKbn.ERROR, "エラー区分（共有）");

    }

    @Test
    @TestOrder(120)
    public void testEditInfo_A12() {
        CoreConfig.getInstance().setProductMode(ProductMode.WEB);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000091");
        BizDate syoriYmd = BizDate.valueOf("20170201");
        BizDate kykoutoubi = BizDate.valueOf("20170101");
        KawaseRateBean kawaseRateBean = new KawaseRateBean();
        kawaseRateBean = null;

        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN4;

        String message = "";

        try {
            editKykNaiyouOsirase1.editInfo(kykKihon,syoriYmd,kykoutoubi,kawaseRateBean,gaikaKokyakuTuutiTy);

        } catch (Exception e) {
            message = e.getMessage();
        }
        exStringEquals(message, "システム整合性エラーです。金額チェックエラーです。システム管理者にお問い合わせください。", "メッセージ内容");
    }
}


