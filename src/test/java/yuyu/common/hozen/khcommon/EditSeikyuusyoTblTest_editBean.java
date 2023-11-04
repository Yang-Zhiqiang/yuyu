package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.bean.report.BzSksKaisyasiyouranBean;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_GengkhouKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_JyudkaigomaebaraiTkykhnkKbn;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_Kaiyakujiyuu;
import yuyu.def.classification.C_KeihiKbn;
import yuyu.def.classification.C_Khhrshrjiyuu;
import yuyu.def.classification.C_Khskssakuseijiyuu;
import yuyu.def.classification.C_KykdrknHtdjytKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Meigihnkjiyuu;
import yuyu.def.classification.C_MousideIkouKbn;
import yuyu.def.classification.C_MousideninKbn;
import yuyu.def.classification.C_NstkhKbn;
import yuyu.def.classification.C_Nstknsyu;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TargetTkHenkouKbn;
import yuyu.def.classification.C_TargetTkKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_Tmttknitenkbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YouhiblnkKbn;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.bean.report.KhSeikyuusyoBean;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.auth.RayBCPBean;
import yuyu.infr.auth.RayCreator;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 請求書TBL編集クラスのメソッド {@link EditSeikyuusyoTbl#editBean(C_SyoruiCdKbn, String, KhozenCommonParam, EditSeikyuusyoParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeikyuusyoTblTest_editBean extends AbstractTest {

    private final static String syono1 = "12806345672";
    private final static String syono2 = "12806345683";
    private final static String syono3 = "12806345694";
    private final static String syono4 = "12806345708";
    private final static String syono5 = "12806345719";
    private final static String syono6 = "12806345720";
    private final static String syono7 = "12806345731";
    private final static String syono8 = "12806345742";
    private final static String syono9 = "12806345753";
    private final static String syono10 = "12806345764";
    private final static String syono11 = "12806345775";
    private final static String syono12 = "12806345786";
    private final static String syono13 = "12806345797";
    private final static String syono14 = "12806345801";
    private final static String syono15 = "12806345812";
    private final static String syono16 = "12806345823";
    private final static String syono17 = "12806345834";
    private final static String syono18 = "12806345845";
    private final static String syono19 = "12806345856";
    private final static String syono20 = "12806345867";
    private final static String syono21 = "12806345878";
    private final static String syono22 = "12806345889";
    private final static String syono23 = "12806345890";
    private final static String syono24 = "12806345904";
    private final static String syono25 = "12806345915";

    @Inject
    private EditSeikyuusyoParam editSeikyuusyoParam;

    @Inject
    private KhozenCommonParam khozenCommonParam;

    @Inject
    private EditSeikyuusyoTbl editSeikyuusyoTbl;

    @Inject
    private BaseUserInfo baseUserInfo;

    private final static String fileName = "UT_SP_単体テスト仕様書_請求書TBL編集";
    private final static String sheetName = "テストデータ";

    private static String Callcentersosikicd;

    @Before
    public void before() {

        MockModuleBinder.bind(new AbstractModule() {
            @Override
            protected void configure() {
                bind(GetKhKykdrInfo.class).to(GetKhKykdrInfoForHozen.class);
            }
        });
    }

    @BeforeClass
    public static void testInit(){
        Callcentersosikicd =  YuyuBizConfig.getInstance().getCallcentersosikicd();
        GetKhKykdrInfoForHozen.caller = EditSeikyuusyoTblTest_editBean.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        YuyuBizConfig.getInstance().setCallcentersosikicd(Callcentersosikicd);
        GetKhKykdrInfoForHozen.caller = null;
        GetKhKykdrInfoForHozen.SYORIPTN = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(EditSeikyuusyoTblTest_editBean.class, fileName, sheetName);

            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {


        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
        baseDomManager.delete(baseDomManager.getAllSyoruiZokuseis());
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(10)
    public void testEditBean_A1() {
        try{
            editSeikyuusyoTbl.editBean(null, "11807111495", khozenCommonParam, null);

        }
        catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。契約基本TBL  証券番号 = 11807111495", "エラーメッセージ");
            throw e;

        }

    }

    @Test(expected = RuntimeException.class)
    @TestOrder(20)
    public void testEditBean_A2() {

        try{
            editSeikyuusyoTbl.editBean(null, syono1, khozenCommonParam, null);

        }
        catch (RuntimeException e) {
            exStringEquals(e.getMessage(), "必要なエンティティが見つかりません。(yuyu.def.db.entity.IT_KykSya with id PKIT_KykSya{ kbnkey:'07', syono:'12806345672' })", "エラーメッセージ");
            throw e;

        }

    }

    @Test(expected = RuntimeException.class)
    @TestOrder(30)
    public void testEditBean_A3() {

        try{
            editSeikyuusyoTbl.editBean(null, syono2, khozenCommonParam, null);

        }
        catch (RuntimeException e) {
            exStringEquals(e.getMessage(), "必要なエンティティが見つかりません。(yuyu.def.db.entity.IT_HhknSya with id PKIT_HhknSya{ kbnkey:'08', syono:'12806345683' })", "エラーメッセージ");
            throw e;

        }

    }

    @Test
    @TestOrder(40)
    public void testEditBean_A4() {

        MockObjectManager.initialize();

        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;

        AM_User aMUser = new AM_User();

        aMUser.setUserId("userId001");
        aMUser.setUserNm("user001");
        changeCurrentUser(baseUserInfo, aMUser);

        editSeikyuusyoParam.setHhknseiymd(BizDate.valueOf(20151026));
        editSeikyuusyoParam.setHhknseiymdhenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setHhknsei(C_Hhknsei.MALE);
        editSeikyuusyoParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setBfrTargettkmokuhyouti(BizNumber.valueOf(101));
        editSeikyuusyoParam.setBfrKihonS(BizCurrency.valueOf(778));
        editSeikyuusyoParam.setBfrP(BizCurrency.valueOf(1566));
        editSeikyuusyoParam.setBfrTokuyakuNenkinsyuKbn(C_Nstknsyu.KAKUTEINENKIN);
        editSeikyuusyoParam.setBfrNkshrtkyknksyukkn(5);
        editSeikyuusyoParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU);
        editSeikyuusyoParam.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editSeikyuusyoParam.setGengkhouKbn(C_GengkhouKbn.SD);
        editSeikyuusyoParam.setHenkankumukbn(C_UmuKbn.ARI);
        editSeikyuusyoParam.setRstuukasyu(C_Tuukasyu.JPY);
        editSeikyuusyoParam.setNkshrtkykhnkkbn(C_NstkhKbn.NAIYOUHENKOU);
        editSeikyuusyoParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);
        editSeikyuusyoParam.setJyudkaigomaebaraiTkykhnkKbn(C_JyudkaigomaebaraiTkykhnkKbn.BLNK);
        editSeikyuusyoParam.setKihonshenkouumu(C_UmuKbn.NONE);
        editSeikyuusyoParam.setTmttknitenkbn(C_Tmttknitenkbn.BLNK);
        editSeikyuusyoParam.setTmttknitenymd(null);
        editSeikyuusyoParam.setKhhrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSeikyuusyoParam.setKhskssakuseijiyuu(C_Khskssakuseijiyuu.BLNK);
        editSeikyuusyoParam.setHenkougokjnkngk(BizCurrency.valueOf(100000));

        ReportServicesBean reSsBean =  editSeikyuusyoTbl.editBean(C_SyoruiCdKbn.KK_MEIGIHNK_SKS, syono3, khozenCommonParam, editSeikyuusyoParam);

        Object[] kSBean = reSsBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_MEIGIHNK_SKS.getValue());

        exNumericEquals(kSBean.length, 2, "パラメータオブジェクトの要素数");

        exNumericEquals(reSsBean.getKensakuKeys().length, 1, "検索キー配列の要素数");
        exStringEquals(reSsBean.getKensakuKeys()[0], "12806345694", "検索キー");

        KhSeikyuusyoBean khSeikyuusyoBean = (KhSeikyuusyoBean)kSBean[0];

        exStringEquals(khSeikyuusyoBean.getIrSyono(), "12806345694", "（ＩＲ）証券番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinyno(), "1234567", "（ＩＲ）通信先郵便番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr1kj(), "通信先住所１", "（ＩＲ）通信先住所１（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr2kj(), "通信先住所２", "（ＩＲ）通信先住所２（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr3kj(), "通信先住所３", "（ＩＲ）通信先住所３（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsintelno(), "023-5677-8999", "（ＩＲ）通信先電話番号");
        exStringEquals(khSeikyuusyoBean.getIrBanknmkj(), "", "（ＩＲ）銀行名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrSitennmkj(), "", "（ＩＲ）支店名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrBankcd(), "", "（ＩＲ）銀行コード");
        exStringEquals(khSeikyuusyoBean.getIrSitencd(), "", "（ＩＲ）支店コード");

        exStringEquals(khSeikyuusyoBean.getIrKzmeiginmkn(), "", "（ＩＲ）口座名義人氏名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkj(), "", "（ＩＲ）契約者名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKkkyktdk(), C_Tdk.HGU, "（ＩＲ）契約管理契約者続柄");
        exStringEquals(khSeikyuusyoBean.getIrHhknnmkj(), "", "（ＩＲ）被保険者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrHhknseiymd(), "", "（ＩＲ）被保険者生年月日");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseiymdhenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者生年月日変更有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknsei(), C_Hhknsei.MALE, "（ＩＲ）被保険者性別");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseihenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者性別変更有無");
        exStringEquals(khSeikyuusyoBean.getIrStdrsknmkj(), "", "（ＩＲ）指定代理請求人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrFatcakakuninyhkbn(), C_YouhiblnkKbn.HUYOU, "（ＩＲ）FATCA確認要否区分");
        exClassificationEquals(khSeikyuusyoBean.getIrAeoikakuninyhkbn(), C_YouhiblnkKbn.YOU, "（ＩＲ）ＡＥＯＩ確認要否区分");

        exClassificationEquals(khSeikyuusyoBean.getIrTargettkkbn(), C_TargetTkKbn.BLNK, "（ＩＲ）ターゲット特約区分");
        exNumericEquals(khSeikyuusyoBean.getIrAftertargettkmokuhyouti(), 101, "（ＩＲ）変更後ターゲット特約目標値");
        exNumericEquals(khSeikyuusyoBean.getIrBeforetargettkmokuhyouti(), 200, "（ＩＲ）変更前ターゲット特約目標値");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforekihons(), BizCurrency.valueOf(100), "（ＩＲ）基本保険金額（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkihons(),  BizCurrency.valueOf(778), "（ＩＲ）基本保険金額（変更後）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforep(), BizCurrency.valueOf(200), "（ＩＲ）保険料（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterp(), BizCurrency.valueOf(1566), "（ＩＲ）保険料（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrKyktuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）契約通貨種類");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj1(), "", "（ＩＲ）死亡受取人名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj2(), "", "（ＩＲ）死亡受取人名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj3(), "", "（ＩＲ）死亡受取人名（漢字）３");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj4(), "", "（ＩＲ）死亡受取人名（漢字）４");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkn(), "", "（ＩＲ）死亡受取人名（カナ）");
        exClassificationEquals(khSeikyuusyoBean.getIrYokinkbn(), C_YokinKbn.BLNK, "（ＩＲ）預金種目区分");
        exStringEquals(khSeikyuusyoBean.getIrKouzano(), "", "（ＩＲ）口座番号");

        exClassificationEquals(khSeikyuusyoBean.getIrAfternkshrtkyknksyukbn(), C_Nstknsyu.KAKUTEINENKIN, "（ＩＲ）変更後年金支払特約年金種類区分");
        exClassificationEquals(khSeikyuusyoBean.getIrBiforenkshrtkyknksyukbn(), C_Nstknsyu.BLNK, "（ＩＲ）変更前年金支払特約年金種類区分");
        exNumericEquals(khSeikyuusyoBean.getIrAfternkshrtkyknkkkn(), 5, "（ＩＲ）変更後年金支払特約年金期間");
        exNumericEquals(khSeikyuusyoBean.getIrBeforenkshrtkyknkkkn(), 10, "（ＩＲ）変更前年金支払特約年金期間");
        exStringEquals(khSeikyuusyoBean.getIrNkuktnm(), "", "（ＩＲ）年金受取人名");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari1(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合１");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari2(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合２");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari3(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合３");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari4(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合４");
        exClassificationEquals(khSeikyuusyoBean.getIrTargettkhnkkbn(), C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU, "（ＩＲ）ターゲット特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKaiyakujiyuu(), C_Kaiyakujiyuu.TUUJYOU, "（ＩＲ）解約事由");
        exClassificationEquals(khSeikyuusyoBean.getIrGengkhoukbn(), C_GengkhouKbn.SD, "（ＩＲ）減額方法区分");
        exNumericEquals(khSeikyuusyoBean.getIrSbuktnin(), 2, "（ＩＲ）死亡受取人人数");
        exClassificationEquals(khSeikyuusyoBean.getIrSbuuktkbn(), C_UktKbn.BLNK, "（ＩＲ）死亡受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrYenshrtkumu(), C_UmuKbn.ARI, "（ＩＲ）円支払特約有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHenkankinumukbn(), C_UmuKbn.ARI, "（ＩＲ）返還金有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrRstuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）領収通貨種類");
        exClassificationEquals(khSeikyuusyoBean.getIrNkshrtkykhnkkbn(), C_NstkhKbn.NAIYOUHENKOU, "（ＩＲ）年金支払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrMeigihnkjiyuu(), C_Meigihnkjiyuu.KYK, "（ＩＲ）名義変更事由");
        exClassificationEquals(khSeikyuusyoBean.getIrNkhknumu(), C_UmuKbn.ARI, "（ＩＲ）年金保険有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSiboukyhkuktumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡給付金受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn1(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分１");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn2(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分２");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn3(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分３");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn4(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分４");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu1(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無１");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu2(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無２");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu3(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無３");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu4(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無４");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyhukaumu(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyuuktmukbn(), C_UmuKbn.NONE, "（ＩＲ）指定代理請求特約受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrStdruktkbn(), C_UktKbn.BLNK, "（ＩＲ）指定代理受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrJyudkaigomaebrtkykhnkkbn(),C_JyudkaigomaebaraiTkykhnkKbn.BLNK, "（ＩＲ）重度介護前払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKeihikbn(),C_KeihiKbn.BLNK,"（ＩＲ）契被区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKihonshenkouumu(),C_UmuKbn.NONE,"（ＩＲ）基本Ｓ変更有無");
        exStringEquals(khSeikyuusyoBean.getIrKihonssyurui(), "基本保険金額", "（ＩＲ）基本Ｓ種類");
        exClassificationEquals(khSeikyuusyoBean.getIrTmttknitenkbn(), C_Tmttknitenkbn.BLNK, "（ＩＲ）積立金移転区分");
        exStringEquals(khSeikyuusyoBean.getIrTmttknitenymd(), null, "（ＩＲ）積立金移転日");
        exClassificationEquals(khSeikyuusyoBean.getIrKhhrshrjiyuu(), C_Khhrshrjiyuu.BLNK, "（ＩＲ）契約保全返戻金支払事由");
        exClassificationEquals(khSeikyuusyoBean.getIrKhskssakuseijiyuu(), C_Khskssakuseijiyuu.BLNK, "（ＩＲ）契約保全請求書作成事由");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkijyunkingaku(), BizCurrency.valueOf(100000), "（ＩＲ）基準金額（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrHrkkeiro(), C_Hrkkeiro.KOUHURI, "（ＩＲ）払込経路");
        exNumericEquals(khSeikyuusyoBean.getIrSyouhnhanteikekka(), 999, "（ＩＲ）商品判定結果");
        exClassificationEquals(khSeikyuusyoBean.getIrKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "（ＩＲ）契約状態");
        exClassificationEquals(khSeikyuusyoBean.getIrZeiseitkkktkykhukaumu(), C_UmuKbn.ARI, "（ＩＲ）税制適格特約付加有無");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn1(), "", "（ＩＲ）登録家族氏名（カナ）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj1(), "", "（ＩＲ）登録家族氏名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj1(), "", "（ＩＲ）登録家族住所１（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj1(), "", "（ＩＲ）登録家族住所２（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj1(), "", "（ＩＲ）登録家族住所３（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno1(), "", "（ＩＲ）登録家族電話番号１");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi1(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn2(), "", "（ＩＲ）登録家族氏名（カナ）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj2(), "", "（ＩＲ）登録家族氏名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj2(), "", "（ＩＲ）登録家族住所１（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj2(), "", "（ＩＲ）登録家族住所２（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj2(), "", "（ＩＲ）登録家族住所３（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno2(), "", "（ＩＲ）登録家族電話番号２");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi2(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否２");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkn(), null, "（ＩＲ）契約者名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKykdairinmkj(), "", "（ＩＲ）契約者代理人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrtkykhukaumu(), null, "（ＩＲ）契約者代理特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrMousideninkbn(), C_MousideninKbn.BLNK, "（ＩＲ）申出人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrknhatudoujyoutai(), C_KykdrknHtdjytKbn.BLNK, "（ＩＲ）契約者代理権発動状態");
        exStringEquals(khSeikyuusyoBean.getIrDrstiskkyknmkj(), null, "（ＩＲ）代理人指定先契約者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTyouhyoutitle(), null, "（ＩＲ）帳票タイトル");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg1(), null, "（ＩＲ）送付案内メッセージ１");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg2(), null, "（ＩＲ）送付案内メッセージ２");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg3(), null, "（ＩＲ）送付案内メッセージ３");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg4(), null, "（ＩＲ）送付案内メッセージ４");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg5(), null, "（ＩＲ）送付案内メッセージ５");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg6(), null, "（ＩＲ）送付案内メッセージ６");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg7(), null, "（ＩＲ）送付案内メッセージ７");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg8(), null, "（ＩＲ）送付案内メッセージ８");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg9(), null, "（ＩＲ）送付案内メッセージ９");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg10(), null, "（ＩＲ）送付案内メッセージ１０");

        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean)kSBean[1];

        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(), null, "（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(), "userId001", "（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(), "user001", "（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(), DateFormatUtil.dateKANJI(BizDate.getSysDate()), "（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(), "3 年", "（ＩＲ）保存期間");
    }

    @Test
    @TestOrder(50)
    public void testEditBean_A5() {

        MockObjectManager.initialize();

        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;

        AM_User aMUser = new AM_User();

        aMUser.setUserId("userId001");
        aMUser.setUserNm("user001");
        changeCurrentUser(baseUserInfo, aMUser);

        editSeikyuusyoParam.setHhknseiymd(BizDate.valueOf(20151026));
        editSeikyuusyoParam.setHhknseiymdhenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setHhknsei(C_Hhknsei.MALE);
        editSeikyuusyoParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setBfrTargettkmokuhyouti(BizNumber.valueOf(101));
        editSeikyuusyoParam.setBfrKihonS(BizCurrency.valueOf(778));
        editSeikyuusyoParam.setBfrP(BizCurrency.valueOf(1566));
        editSeikyuusyoParam.setBfrTokuyakuNenkinsyuKbn(C_Nstknsyu.KAKUTEINENKIN);
        editSeikyuusyoParam.setBfrNkshrtkyknksyukkn(5);
        editSeikyuusyoParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU);
        editSeikyuusyoParam.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editSeikyuusyoParam.setGengkhouKbn(C_GengkhouKbn.SD);
        editSeikyuusyoParam.setHenkankumukbn(C_UmuKbn.ARI);
        editSeikyuusyoParam.setRstuukasyu(C_Tuukasyu.JPY);
        editSeikyuusyoParam.setNkshrtkykhnkkbn(C_NstkhKbn.NAIYOUHENKOU);
        editSeikyuusyoParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);
        editSeikyuusyoParam.setJyudkaigomaebaraiTkykhnkKbn(C_JyudkaigomaebaraiTkykhnkKbn.BLNK);
        editSeikyuusyoParam.setKihonshenkouumu(C_UmuKbn.NONE);
        editSeikyuusyoParam.setTmttknitenkbn(C_Tmttknitenkbn.BLNK);
        editSeikyuusyoParam.setTmttknitenymd(null);
        editSeikyuusyoParam.setKhhrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSeikyuusyoParam.setKhskssakuseijiyuu(C_Khskssakuseijiyuu.BLNK);
        editSeikyuusyoParam.setHenkougokjnkngk(BizCurrency.valueOf(100000));

        ReportServicesBean reSsBean =  editSeikyuusyoTbl.editBean(C_SyoruiCdKbn.KK_MEIGIHNK_SKS, syono4, khozenCommonParam, editSeikyuusyoParam);

        Object[] kSBean = reSsBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_MEIGIHNK_SKS.getValue());

        exNumericEquals(kSBean.length, 2, "パラメータオブジェクトの要素数");

        exNumericEquals(reSsBean.getKensakuKeys().length, 1, "検索キー配列の要素数");
        exStringEquals(reSsBean.getKensakuKeys()[0], "12806345708", "検索キー");

        KhSeikyuusyoBean khSeikyuusyoBean = (KhSeikyuusyoBean)kSBean[0];

        exStringEquals(khSeikyuusyoBean.getIrSyono(), "12806345708", "（ＩＲ）証券番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinyno(), "1234567", "（ＩＲ）通信先郵便番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr1kj(), "通信先住所１", "（ＩＲ）通信先住所１（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr2kj(), "通信先住所２", "（ＩＲ）通信先住所２（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr3kj(), "通信先住所３", "（ＩＲ）通信先住所３（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsintelno(), "023-5677-8999", "（ＩＲ）通信先電話番号");
        exStringEquals(khSeikyuusyoBean.getIrBanknmkj(), "", "（ＩＲ）銀行名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrSitennmkj(), "", "（ＩＲ）支店名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrBankcd(), "", "（ＩＲ）銀行コード");
        exStringEquals(khSeikyuusyoBean.getIrSitencd(), "", "（ＩＲ）支店コード");

        exStringEquals(khSeikyuusyoBean.getIrKzmeiginmkn(), "", "（ＩＲ）口座名義人氏名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkj(), "", "（ＩＲ）契約者名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKkkyktdk(), C_Tdk.HGU, "（ＩＲ）契約管理契約者続柄");
        exStringEquals(khSeikyuusyoBean.getIrHhknnmkj(), "", "（ＩＲ）被保険者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrHhknseiymd(), "", "（ＩＲ）被保険者生年月日");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseiymdhenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者生年月日変更有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknsei(), C_Hhknsei.MALE, "（ＩＲ）被保険者性別");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseihenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者性別変更有無");
        exStringEquals(khSeikyuusyoBean.getIrStdrsknmkj(), "", "（ＩＲ）指定代理請求人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrFatcakakuninyhkbn(), C_YouhiblnkKbn.HUYOU, "（ＩＲ）FATCA確認要否区分");
        exClassificationEquals(khSeikyuusyoBean.getIrAeoikakuninyhkbn(), C_YouhiblnkKbn.YOU, "（ＩＲ）ＡＥＯＩ確認要否区分");

        exClassificationEquals(khSeikyuusyoBean.getIrTargettkkbn(), C_TargetTkKbn.BLNK, "（ＩＲ）ターゲット特約区分");
        exNumericEquals(khSeikyuusyoBean.getIrAftertargettkmokuhyouti(), 101, "（ＩＲ）変更後ターゲット特約目標値");
        exNumericEquals(khSeikyuusyoBean.getIrBeforetargettkmokuhyouti(), 200, "（ＩＲ）変更前ターゲット特約目標値");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforekihons(), BizCurrency.valueOf(100), "（ＩＲ）基本保険金額（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkihons(),  BizCurrency.valueOf(778), "（ＩＲ）基本保険金額（変更後）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforep(), BizCurrency.valueOf(200), "（ＩＲ）保険料（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterp(), BizCurrency.valueOf(1566), "（ＩＲ）保険料（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrKyktuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）契約通貨種類");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj1(), "", "（ＩＲ）死亡受取人名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj2(), "", "（ＩＲ）死亡受取人名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj3(), "", "（ＩＲ）死亡受取人名（漢字）３");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj4(), "", "（ＩＲ）死亡受取人名（漢字）４");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkn(), "", "（ＩＲ）死亡受取人名（カナ）");
        exClassificationEquals(khSeikyuusyoBean.getIrYokinkbn(), C_YokinKbn.BLNK, "（ＩＲ）預金種目区分");
        exStringEquals(khSeikyuusyoBean.getIrKouzano(), "", "（ＩＲ）口座番号");

        exClassificationEquals(khSeikyuusyoBean.getIrAfternkshrtkyknksyukbn(), C_Nstknsyu.KAKUTEINENKIN, "（ＩＲ）変更後年金支払特約年金種類区分");
        exClassificationEquals(khSeikyuusyoBean.getIrBiforenkshrtkyknksyukbn(), C_Nstknsyu.BLNK, "（ＩＲ）変更前年金支払特約年金種類区分");
        exNumericEquals(khSeikyuusyoBean.getIrAfternkshrtkyknkkkn(), 5, "（ＩＲ）変更後年金支払特約年金期間");
        exNumericEquals(khSeikyuusyoBean.getIrBeforenkshrtkyknkkkn(), 10, "（ＩＲ）変更前年金支払特約年金期間");
        exStringEquals(khSeikyuusyoBean.getIrNkuktnm(), "", "（ＩＲ）年金受取人名");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari1(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合１");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari2(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合２");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari3(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合３");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari4(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合４");
        exClassificationEquals(khSeikyuusyoBean.getIrTargettkhnkkbn(), C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU, "（ＩＲ）ターゲット特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKaiyakujiyuu(), C_Kaiyakujiyuu.TUUJYOU, "（ＩＲ）解約事由");
        exClassificationEquals(khSeikyuusyoBean.getIrGengkhoukbn(), C_GengkhouKbn.SD, "（ＩＲ）減額方法区分");
        exNumericEquals(khSeikyuusyoBean.getIrSbuktnin(), 2, "（ＩＲ）死亡受取人人数");
        exClassificationEquals(khSeikyuusyoBean.getIrSbuuktkbn(), C_UktKbn.BLNK, "（ＩＲ）死亡受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrYenshrtkumu(), C_UmuKbn.ARI, "（ＩＲ）円支払特約有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHenkankinumukbn(), C_UmuKbn.ARI, "（ＩＲ）返還金有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrRstuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）領収通貨種類");
        exClassificationEquals(khSeikyuusyoBean.getIrNkshrtkykhnkkbn(), C_NstkhKbn.NAIYOUHENKOU, "（ＩＲ）年金支払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrMeigihnkjiyuu(), C_Meigihnkjiyuu.KYK, "（ＩＲ）名義変更事由");
        exClassificationEquals(khSeikyuusyoBean.getIrNkhknumu(), C_UmuKbn.ARI, "（ＩＲ）年金保険有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSiboukyhkuktumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡給付金受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn1(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分１");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn2(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分２");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn3(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分３");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn4(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分４");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu1(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無１");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu2(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無２");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu3(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無３");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu4(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無４");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyhukaumu(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyuuktmukbn(), C_UmuKbn.NONE, "（ＩＲ）指定代理請求特約受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrStdruktkbn(), C_UktKbn.BLNK, "（ＩＲ）指定代理受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrJyudkaigomaebrtkykhnkkbn(),C_JyudkaigomaebaraiTkykhnkKbn.BLNK, "（ＩＲ）重度介護前払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKeihikbn(),C_KeihiKbn.BLNK,"（ＩＲ）契被区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKihonshenkouumu(),C_UmuKbn.NONE,"（ＩＲ）基本Ｓ変更有無");
        exStringEquals(khSeikyuusyoBean.getIrKihonssyurui(), "基本保険金額", "（ＩＲ）基本Ｓ種類");
        exClassificationEquals(khSeikyuusyoBean.getIrTmttknitenkbn(), C_Tmttknitenkbn.BLNK, "（ＩＲ）積立金移転区分");
        exStringEquals(khSeikyuusyoBean.getIrTmttknitenymd(), null, "（ＩＲ）積立金移転日");
        exClassificationEquals(khSeikyuusyoBean.getIrKhhrshrjiyuu(), C_Khhrshrjiyuu.BLNK, "（ＩＲ）契約保全返戻金支払事由");
        exClassificationEquals(khSeikyuusyoBean.getIrKhskssakuseijiyuu(), C_Khskssakuseijiyuu.BLNK, "（ＩＲ）契約保全請求書作成事由");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkijyunkingaku(), BizCurrency.valueOf(100000), "（ＩＲ）基準金額（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrHrkkeiro(), C_Hrkkeiro.DANTAI, "（ＩＲ）払込経路");
        exNumericEquals(khSeikyuusyoBean.getIrSyouhnhanteikekka(), 999, "（ＩＲ）商品判定結果");
        exClassificationEquals(khSeikyuusyoBean.getIrKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "（ＩＲ）契約状態");
        exClassificationEquals(khSeikyuusyoBean.getIrZeiseitkkktkykhukaumu(), C_UmuKbn.ARI, "（ＩＲ）税制適格特約付加有無");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn1(), "", "（ＩＲ）登録家族氏名（カナ）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj1(), "", "（ＩＲ）登録家族氏名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj1(), "", "（ＩＲ）登録家族住所１（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj1(), "", "（ＩＲ）登録家族住所２（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj1(), "", "（ＩＲ）登録家族住所３（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno1(), "", "（ＩＲ）登録家族電話番号１");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi1(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn2(), "", "（ＩＲ）登録家族氏名（カナ）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj2(), "", "（ＩＲ）登録家族氏名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj2(), "", "（ＩＲ）登録家族住所１（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj2(), "", "（ＩＲ）登録家族住所２（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj2(), "", "（ＩＲ）登録家族住所３（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno2(), "", "（ＩＲ）登録家族電話番号２");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi2(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否２");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkn(), null, "（ＩＲ）契約者名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKykdairinmkj(), "", "（ＩＲ）契約者代理人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrtkykhukaumu(), null, "（ＩＲ）契約者代理特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrMousideninkbn(), C_MousideninKbn.BLNK, "（ＩＲ）申出人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrknhatudoujyoutai(), C_KykdrknHtdjytKbn.BLNK, "（ＩＲ）契約者代理権発動状態");
        exStringEquals(khSeikyuusyoBean.getIrDrstiskkyknmkj(), "契約者名", "（ＩＲ）代理人指定先契約者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTyouhyoutitle(), null, "（ＩＲ）帳票タイトル");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg1(), null, "（ＩＲ）送付案内メッセージ１");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg2(), null, "（ＩＲ）送付案内メッセージ２");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg3(), null, "（ＩＲ）送付案内メッセージ３");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg4(), null, "（ＩＲ）送付案内メッセージ４");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg5(), null, "（ＩＲ）送付案内メッセージ５");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg6(), null, "（ＩＲ）送付案内メッセージ６");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg7(), null, "（ＩＲ）送付案内メッセージ７");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg8(), null, "（ＩＲ）送付案内メッセージ８");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg9(), null, "（ＩＲ）送付案内メッセージ９");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg10(), null, "（ＩＲ）送付案内メッセージ１０");

        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean)kSBean[1];

        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(), null, "（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(), "userId001", "（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(), "user001", "（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(), DateFormatUtil.dateKANJI(BizDate.getSysDate()), "（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(), "3 年", "（ＩＲ）保存期間");
    }

    @Test
    @TestOrder(60)
    public void testEditBean_A6() {

        MockObjectManager.initialize();

        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;

        AM_User aMUser = new AM_User();

        aMUser.setUserId("userId001");
        aMUser.setUserNm("user001");
        changeCurrentUser(baseUserInfo, aMUser);

        editSeikyuusyoParam.setHhknseiymd(BizDate.valueOf(20151026));
        editSeikyuusyoParam.setHhknseiymdhenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setHhknsei(C_Hhknsei.MALE);
        editSeikyuusyoParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setBfrTargettkmokuhyouti(BizNumber.valueOf(101));
        editSeikyuusyoParam.setBfrKihonS(BizCurrency.valueOf(778));
        editSeikyuusyoParam.setBfrP(BizCurrency.valueOf(1566));
        editSeikyuusyoParam.setBfrTokuyakuNenkinsyuKbn(C_Nstknsyu.KAKUTEINENKIN);
        editSeikyuusyoParam.setBfrNkshrtkyknksyukkn(5);
        editSeikyuusyoParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU);
        editSeikyuusyoParam.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editSeikyuusyoParam.setGengkhouKbn(C_GengkhouKbn.SD);
        editSeikyuusyoParam.setHenkankumukbn(C_UmuKbn.ARI);
        editSeikyuusyoParam.setRstuukasyu(C_Tuukasyu.JPY);
        editSeikyuusyoParam.setNkshrtkykhnkkbn(C_NstkhKbn.NAIYOUHENKOU);
        editSeikyuusyoParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);
        editSeikyuusyoParam.setJyudkaigomaebaraiTkykhnkKbn(C_JyudkaigomaebaraiTkykhnkKbn.BLNK);
        editSeikyuusyoParam.setKihonshenkouumu(C_UmuKbn.NONE);
        editSeikyuusyoParam.setTmttknitenkbn(C_Tmttknitenkbn.BLNK);
        editSeikyuusyoParam.setTmttknitenymd(null);
        editSeikyuusyoParam.setKhhrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSeikyuusyoParam.setKhskssakuseijiyuu(C_Khskssakuseijiyuu.BLNK);
        editSeikyuusyoParam.setHenkougokjnkngk(BizCurrency.valueOf(100000));

        ReportServicesBean reSsBean =  editSeikyuusyoTbl.editBean(C_SyoruiCdKbn.KK_MEIGIHNK_SKS, syono5, khozenCommonParam, editSeikyuusyoParam);

        Object[] kSBean = reSsBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_MEIGIHNK_SKS.getValue());

        exNumericEquals(kSBean.length, 2, "パラメータオブジェクトの要素数");

        exNumericEquals(reSsBean.getKensakuKeys().length, 1, "検索キー配列の要素数");
        exStringEquals(reSsBean.getKensakuKeys()[0], "12806345719", "検索キー");

        KhSeikyuusyoBean khSeikyuusyoBean = (KhSeikyuusyoBean)kSBean[0];

        exStringEquals(khSeikyuusyoBean.getIrSyono(), "12806345719", "（ＩＲ）証券番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinyno(), "1234567", "（ＩＲ）通信先郵便番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr1kj(), "通信先住所１", "（ＩＲ）通信先住所１（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr2kj(), "通信先住所２", "（ＩＲ）通信先住所２（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr3kj(), "通信先住所３", "（ＩＲ）通信先住所３（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsintelno(), "023-5677-8999", "（ＩＲ）通信先電話番号");
        exStringEquals(khSeikyuusyoBean.getIrBanknmkj(), "", "（ＩＲ）銀行名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrSitennmkj(), "", "（ＩＲ）支店名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrBankcd(), "", "（ＩＲ）銀行コード");
        exStringEquals(khSeikyuusyoBean.getIrSitencd(), "", "（ＩＲ）支店コード");

        exStringEquals(khSeikyuusyoBean.getIrKzmeiginmkn(), "", "（ＩＲ）口座名義人氏名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkj(), "契約者名", "（ＩＲ）契約者名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKkkyktdk(), C_Tdk.HGU, "（ＩＲ）契約管理契約者続柄");
        exStringEquals(khSeikyuusyoBean.getIrHhknnmkj(), "被保険者名", "（ＩＲ）被保険者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrHhknseiymd(), "", "（ＩＲ）被保険者生年月日");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseiymdhenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者生年月日変更有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknsei(), C_Hhknsei.MALE, "（ＩＲ）被保険者性別");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseihenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者性別変更有無");
        exStringEquals(khSeikyuusyoBean.getIrStdrsknmkj(), "", "（ＩＲ）指定代理請求人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrFatcakakuninyhkbn(), C_YouhiblnkKbn.HUYOU, "（ＩＲ）FATCA確認要否区分");
        exClassificationEquals(khSeikyuusyoBean.getIrAeoikakuninyhkbn(), C_YouhiblnkKbn.YOU, "（ＩＲ）ＡＥＯＩ確認要否区分");

        exClassificationEquals(khSeikyuusyoBean.getIrTargettkkbn(), C_TargetTkKbn.BLNK, "（ＩＲ）ターゲット特約区分");
        exNumericEquals(khSeikyuusyoBean.getIrAftertargettkmokuhyouti(), 101, "（ＩＲ）変更後ターゲット特約目標値");
        exNumericEquals(khSeikyuusyoBean.getIrBeforetargettkmokuhyouti(), 200, "（ＩＲ）変更前ターゲット特約目標値");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforekihons(), BizCurrency.valueOf(100), "（ＩＲ）基本保険金額（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkihons(),  BizCurrency.valueOf(778), "（ＩＲ）基本保険金額（変更後）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforep(), BizCurrency.valueOf(200), "（ＩＲ）保険料（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterp(), BizCurrency.valueOf(1566), "（ＩＲ）保険料（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrKyktuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）契約通貨種類");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj1(), "", "（ＩＲ）死亡受取人名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj2(), "", "（ＩＲ）死亡受取人名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj3(), "", "（ＩＲ）死亡受取人名（漢字）３");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj4(), "", "（ＩＲ）死亡受取人名（漢字）４");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkn(), "", "（ＩＲ）死亡受取人名（カナ）");
        exClassificationEquals(khSeikyuusyoBean.getIrYokinkbn(), C_YokinKbn.BLNK, "（ＩＲ）預金種目区分");
        exStringEquals(khSeikyuusyoBean.getIrKouzano(), "", "（ＩＲ）口座番号");

        exClassificationEquals(khSeikyuusyoBean.getIrAfternkshrtkyknksyukbn(), C_Nstknsyu.KAKUTEINENKIN, "（ＩＲ）変更後年金支払特約年金種類区分");
        exClassificationEquals(khSeikyuusyoBean.getIrBiforenkshrtkyknksyukbn(), C_Nstknsyu.BLNK, "（ＩＲ）変更前年金支払特約年金種類区分");
        exNumericEquals(khSeikyuusyoBean.getIrAfternkshrtkyknkkkn(), 5, "（ＩＲ）変更後年金支払特約年金期間");
        exNumericEquals(khSeikyuusyoBean.getIrBeforenkshrtkyknkkkn(), 10, "（ＩＲ）変更前年金支払特約年金期間");
        exStringEquals(khSeikyuusyoBean.getIrNkuktnm(), "", "（ＩＲ）年金受取人名");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari1(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合１");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari2(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合２");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari3(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合３");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari4(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合４");
        exClassificationEquals(khSeikyuusyoBean.getIrTargettkhnkkbn(), C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU, "（ＩＲ）ターゲット特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKaiyakujiyuu(), C_Kaiyakujiyuu.TUUJYOU, "（ＩＲ）解約事由");
        exClassificationEquals(khSeikyuusyoBean.getIrGengkhoukbn(), C_GengkhouKbn.SD, "（ＩＲ）減額方法区分");
        exNumericEquals(khSeikyuusyoBean.getIrSbuktnin(), 2, "（ＩＲ）死亡受取人人数");
        exClassificationEquals(khSeikyuusyoBean.getIrSbuuktkbn(), C_UktKbn.BLNK, "（ＩＲ）死亡受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrYenshrtkumu(), C_UmuKbn.ARI, "（ＩＲ）円支払特約有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHenkankinumukbn(), C_UmuKbn.ARI, "（ＩＲ）返還金有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrRstuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）領収通貨種類");
        exClassificationEquals(khSeikyuusyoBean.getIrNkshrtkykhnkkbn(), C_NstkhKbn.NAIYOUHENKOU, "（ＩＲ）年金支払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrMeigihnkjiyuu(), C_Meigihnkjiyuu.KYK, "（ＩＲ）名義変更事由");
        exClassificationEquals(khSeikyuusyoBean.getIrNkhknumu(), C_UmuKbn.ARI, "（ＩＲ）年金保険有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSiboukyhkuktumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡給付金受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn1(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分１");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn2(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分２");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn3(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分３");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn4(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分４");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu1(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無１");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu2(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無２");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu3(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無３");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu4(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無４");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyhukaumu(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyuuktmukbn(), C_UmuKbn.NONE, "（ＩＲ）指定代理請求特約受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrStdruktkbn(), C_UktKbn.BLNK, "（ＩＲ）指定代理受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrJyudkaigomaebrtkykhnkkbn(),C_JyudkaigomaebaraiTkykhnkKbn.BLNK, "（ＩＲ）重度介護前払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKeihikbn(),C_KeihiKbn.BLNK,"（ＩＲ）契被区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKihonshenkouumu(),C_UmuKbn.NONE,"（ＩＲ）基本Ｓ変更有無");
        exStringEquals(khSeikyuusyoBean.getIrKihonssyurui(), "基本保険金額", "（ＩＲ）基本Ｓ種類");
        exClassificationEquals(khSeikyuusyoBean.getIrTmttknitenkbn(), C_Tmttknitenkbn.BLNK, "（ＩＲ）積立金移転区分");
        exStringEquals(khSeikyuusyoBean.getIrTmttknitenymd(), null, "（ＩＲ）積立金移転日");
        exClassificationEquals(khSeikyuusyoBean.getIrKhhrshrjiyuu(), C_Khhrshrjiyuu.BLNK, "（ＩＲ）契約保全返戻金支払事由");
        exClassificationEquals(khSeikyuusyoBean.getIrKhskssakuseijiyuu(), C_Khskssakuseijiyuu.BLNK, "（ＩＲ）契約保全請求書作成事由");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkijyunkingaku(), BizCurrency.valueOf(100000), "（ＩＲ）基準金額（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrHrkkeiro(), C_Hrkkeiro.DANTAI, "（ＩＲ）払込経路");
        exNumericEquals(khSeikyuusyoBean.getIrSyouhnhanteikekka(), 999, "（ＩＲ）商品判定結果");
        exClassificationEquals(khSeikyuusyoBean.getIrKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "（ＩＲ）契約状態");
        exClassificationEquals(khSeikyuusyoBean.getIrZeiseitkkktkykhukaumu(), C_UmuKbn.ARI, "（ＩＲ）税制適格特約付加有無");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn1(), "", "（ＩＲ）登録家族氏名（カナ）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj1(), "", "（ＩＲ）登録家族氏名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj1(), "", "（ＩＲ）登録家族住所１（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj1(), "", "（ＩＲ）登録家族住所２（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj1(), "", "（ＩＲ）登録家族住所３（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno1(), "", "（ＩＲ）登録家族電話番号１");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi1(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn2(), "", "（ＩＲ）登録家族氏名（カナ）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj2(), "", "（ＩＲ）登録家族氏名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj2(), "", "（ＩＲ）登録家族住所１（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj2(), "", "（ＩＲ）登録家族住所２（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj2(), "", "（ＩＲ）登録家族住所３（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno2(), "", "（ＩＲ）登録家族電話番号２");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi2(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否２");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkn(), null, "（ＩＲ）契約者名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKykdairinmkj(), "", "（ＩＲ）契約者代理人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrtkykhukaumu(), null, "（ＩＲ）契約者代理特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrMousideninkbn(), C_MousideninKbn.BLNK, "（ＩＲ）申出人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrknhatudoujyoutai(), C_KykdrknHtdjytKbn.BLNK, "（ＩＲ）契約者代理権発動状態");
        exStringEquals(khSeikyuusyoBean.getIrDrstiskkyknmkj(), "契約者名", "（ＩＲ）代理人指定先契約者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTyouhyoutitle(), null, "（ＩＲ）帳票タイトル");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg1(), null, "（ＩＲ）送付案内メッセージ１");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg2(), null, "（ＩＲ）送付案内メッセージ２");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg3(), null, "（ＩＲ）送付案内メッセージ３");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg4(), null, "（ＩＲ）送付案内メッセージ４");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg5(), null, "（ＩＲ）送付案内メッセージ５");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg6(), null, "（ＩＲ）送付案内メッセージ６");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg7(), null, "（ＩＲ）送付案内メッセージ７");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg8(), null, "（ＩＲ）送付案内メッセージ８");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg9(), null, "（ＩＲ）送付案内メッセージ９");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg10(), null, "（ＩＲ）送付案内メッセージ１０");

        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean)kSBean[1];

        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(), null, "（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(), "userId001", "（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(), "user001", "（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(), DateFormatUtil.dateKANJI(BizDate.getSysDate()), "（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(), "3 年", "（ＩＲ）保存期間");
    }

    @Test
    @TestOrder(70)
    public void testEditBean_A7() {

        MockObjectManager.initialize();

        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;

        AM_User aMUser = new AM_User();

        aMUser.setUserId("userId001");
        aMUser.setUserNm("user001");
        changeCurrentUser(baseUserInfo, aMUser);

        editSeikyuusyoParam.setHhknseiymd(BizDate.valueOf(20151026));
        editSeikyuusyoParam.setHhknseiymdhenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setHhknsei(C_Hhknsei.MALE);
        editSeikyuusyoParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setBfrTargettkmokuhyouti(BizNumber.valueOf(101));
        editSeikyuusyoParam.setBfrKihonS(BizCurrency.valueOf(778));
        editSeikyuusyoParam.setBfrP(BizCurrency.valueOf(1566));
        editSeikyuusyoParam.setBfrTokuyakuNenkinsyuKbn(C_Nstknsyu.KAKUTEINENKIN);
        editSeikyuusyoParam.setBfrNkshrtkyknksyukkn(5);
        editSeikyuusyoParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU);
        editSeikyuusyoParam.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editSeikyuusyoParam.setGengkhouKbn(C_GengkhouKbn.SD);
        editSeikyuusyoParam.setHenkankumukbn(C_UmuKbn.ARI);
        editSeikyuusyoParam.setRstuukasyu(C_Tuukasyu.JPY);
        editSeikyuusyoParam.setNkshrtkykhnkkbn(C_NstkhKbn.NAIYOUHENKOU);
        editSeikyuusyoParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);
        editSeikyuusyoParam.setJyudkaigomaebaraiTkykhnkKbn(C_JyudkaigomaebaraiTkykhnkKbn.BLNK);
        editSeikyuusyoParam.setKihonshenkouumu(C_UmuKbn.NONE);
        editSeikyuusyoParam.setTmttknitenkbn(C_Tmttknitenkbn.BLNK);
        editSeikyuusyoParam.setTmttknitenymd(null);
        editSeikyuusyoParam.setKhhrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSeikyuusyoParam.setKhskssakuseijiyuu(C_Khskssakuseijiyuu.BLNK);
        editSeikyuusyoParam.setHenkougokjnkngk(BizCurrency.valueOf(100000));

        ReportServicesBean reSsBean =  editSeikyuusyoTbl.editBean(C_SyoruiCdKbn.KK_MEIGIHNK_SKS, syono6, khozenCommonParam, editSeikyuusyoParam);

        Object[] kSBean = reSsBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_MEIGIHNK_SKS.getValue());

        exNumericEquals(kSBean.length, 2, "パラメータオブジェクトの要素数");

        exNumericEquals(reSsBean.getKensakuKeys().length, 1, "検索キー配列の要素数");
        exStringEquals(reSsBean.getKensakuKeys()[0], "12806345720", "検索キー");

        KhSeikyuusyoBean khSeikyuusyoBean = (KhSeikyuusyoBean)kSBean[0];

        exStringEquals(khSeikyuusyoBean.getIrSyono(), "12806345720", "（ＩＲ）証券番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinyno(), "1234567", "（ＩＲ）通信先郵便番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr1kj(), "通信先住所１", "（ＩＲ）通信先住所１（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr2kj(), "通信先住所２", "（ＩＲ）通信先住所２（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr3kj(), "通信先住所３", "（ＩＲ）通信先住所３（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsintelno(), "023-5677-8999", "（ＩＲ）通信先電話番号");
        exStringEquals(khSeikyuusyoBean.getIrBanknmkj(), "", "（ＩＲ）銀行名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrSitennmkj(), "", "（ＩＲ）支店名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrBankcd(), "", "（ＩＲ）銀行コード");
        exStringEquals(khSeikyuusyoBean.getIrSitencd(), "", "（ＩＲ）支店コード");

        exStringEquals(khSeikyuusyoBean.getIrKzmeiginmkn(), "", "（ＩＲ）口座名義人氏名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkj(), "契約者名", "（ＩＲ）契約者名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKkkyktdk(), C_Tdk.HGU, "（ＩＲ）契約管理契約者続柄");
        exStringEquals(khSeikyuusyoBean.getIrHhknnmkj(), "被保険者名", "（ＩＲ）被保険者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrHhknseiymd(), "", "（ＩＲ）被保険者生年月日");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseiymdhenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者生年月日変更有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknsei(), C_Hhknsei.MALE, "（ＩＲ）被保険者性別");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseihenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者性別変更有無");
        exStringEquals(khSeikyuusyoBean.getIrStdrsknmkj(), "", "（ＩＲ）指定代理請求人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrFatcakakuninyhkbn(), C_YouhiblnkKbn.HUYOU, "（ＩＲ）FATCA確認要否区分");
        exClassificationEquals(khSeikyuusyoBean.getIrAeoikakuninyhkbn(), C_YouhiblnkKbn.YOU, "（ＩＲ）ＡＥＯＩ確認要否区分");

        exClassificationEquals(khSeikyuusyoBean.getIrTargettkkbn(), C_TargetTkKbn.BLNK, "（ＩＲ）ターゲット特約区分");
        exNumericEquals(khSeikyuusyoBean.getIrAftertargettkmokuhyouti(), 101, "（ＩＲ）変更後ターゲット特約目標値");
        exNumericEquals(khSeikyuusyoBean.getIrBeforetargettkmokuhyouti(), 200, "（ＩＲ）変更前ターゲット特約目標値");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforekihons(), BizCurrency.valueOf(100), "（ＩＲ）基本保険金額（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkihons(),  BizCurrency.valueOf(778), "（ＩＲ）基本保険金額（変更後）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforep(), BizCurrency.valueOf(200), "（ＩＲ）保険料（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterp(), BizCurrency.valueOf(1566), "（ＩＲ）保険料（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrKyktuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）契約通貨種類");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj1(), "契約者名", "（ＩＲ）死亡受取人名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj2(), "", "（ＩＲ）死亡受取人名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj3(), "", "（ＩＲ）死亡受取人名（漢字）３");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj4(), "", "（ＩＲ）死亡受取人名（漢字）４");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkn(), "契約者名（カナ）", "（ＩＲ）死亡受取人名（カナ）");
        exClassificationEquals(khSeikyuusyoBean.getIrYokinkbn(), C_YokinKbn.BLNK, "（ＩＲ）預金種目区分");
        exStringEquals(khSeikyuusyoBean.getIrKouzano(), "", "（ＩＲ）口座番号");

        exClassificationEquals(khSeikyuusyoBean.getIrAfternkshrtkyknksyukbn(), C_Nstknsyu.KAKUTEINENKIN, "（ＩＲ）変更後年金支払特約年金種類区分");
        exClassificationEquals(khSeikyuusyoBean.getIrBiforenkshrtkyknksyukbn(), C_Nstknsyu.BLNK, "（ＩＲ）変更前年金支払特約年金種類区分");
        exNumericEquals(khSeikyuusyoBean.getIrAfternkshrtkyknkkkn(), 5, "（ＩＲ）変更後年金支払特約年金期間");
        exNumericEquals(khSeikyuusyoBean.getIrBeforenkshrtkyknkkkn(), 10, "（ＩＲ）変更前年金支払特約年金期間");
        exStringEquals(khSeikyuusyoBean.getIrNkuktnm(), "", "（ＩＲ）年金受取人名");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari1(), BizNumber.valueOf(110), "（ＩＲ）死亡受取人分割割合１");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari2(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合２");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari3(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合３");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari4(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合４");
        exClassificationEquals(khSeikyuusyoBean.getIrTargettkhnkkbn(), C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU, "（ＩＲ）ターゲット特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKaiyakujiyuu(), C_Kaiyakujiyuu.TUUJYOU, "（ＩＲ）解約事由");
        exClassificationEquals(khSeikyuusyoBean.getIrGengkhoukbn(), C_GengkhouKbn.SD, "（ＩＲ）減額方法区分");
        exNumericEquals(khSeikyuusyoBean.getIrSbuktnin(), 2, "（ＩＲ）死亡受取人人数");
        exClassificationEquals(khSeikyuusyoBean.getIrSbuuktkbn(), C_UktKbn.KYK, "（ＩＲ）死亡受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrYenshrtkumu(), C_UmuKbn.ARI, "（ＩＲ）円支払特約有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHenkankinumukbn(), C_UmuKbn.ARI, "（ＩＲ）返還金有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrRstuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）領収通貨種類");
        exClassificationEquals(khSeikyuusyoBean.getIrNkshrtkykhnkkbn(), C_NstkhKbn.NAIYOUHENKOU, "（ＩＲ）年金支払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrMeigihnkjiyuu(), C_Meigihnkjiyuu.KYK, "（ＩＲ）名義変更事由");
        exClassificationEquals(khSeikyuusyoBean.getIrNkhknumu(), C_UmuKbn.ARI, "（ＩＲ）年金保険有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSiboukyhkuktumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡給付金受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn1(), C_UmuKbn.ARI, "（ＩＲ）死亡保険金受取人有無区分１");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn2(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分２");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn3(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分３");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn4(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分４");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu1(), C_UmuKbn.ARI, "（ＩＲ）死亡受取人分割割合有無１");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu2(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無２");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu3(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無３");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu4(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無４");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyhukaumu(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyuuktmukbn(), C_UmuKbn.NONE, "（ＩＲ）指定代理請求特約受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrStdruktkbn(), C_UktKbn.BLNK, "（ＩＲ）指定代理受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrJyudkaigomaebrtkykhnkkbn(),C_JyudkaigomaebaraiTkykhnkKbn.BLNK, "（ＩＲ）重度介護前払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKeihikbn(),C_KeihiKbn.BLNK,"（ＩＲ）契被区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKihonshenkouumu(),C_UmuKbn.NONE,"（ＩＲ）基本Ｓ変更有無");
        exStringEquals(khSeikyuusyoBean.getIrKihonssyurui(), "基本保険金額", "（ＩＲ）基本Ｓ種類");
        exClassificationEquals(khSeikyuusyoBean.getIrTmttknitenkbn(), C_Tmttknitenkbn.BLNK, "（ＩＲ）積立金移転区分");
        exStringEquals(khSeikyuusyoBean.getIrTmttknitenymd(), null, "（ＩＲ）積立金移転日");
        exClassificationEquals(khSeikyuusyoBean.getIrKhhrshrjiyuu(), C_Khhrshrjiyuu.BLNK, "（ＩＲ）契約保全返戻金支払事由");
        exClassificationEquals(khSeikyuusyoBean.getIrKhskssakuseijiyuu(), C_Khskssakuseijiyuu.BLNK, "（ＩＲ）契約保全請求書作成事由");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkijyunkingaku(), BizCurrency.valueOf(100000), "（ＩＲ）基準金額（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrHrkkeiro(), C_Hrkkeiro.DANTAI, "（ＩＲ）払込経路");
        exNumericEquals(khSeikyuusyoBean.getIrSyouhnhanteikekka(), 999, "（ＩＲ）商品判定結果");
        exClassificationEquals(khSeikyuusyoBean.getIrKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "（ＩＲ）契約状態");
        exClassificationEquals(khSeikyuusyoBean.getIrZeiseitkkktkykhukaumu(), C_UmuKbn.ARI, "（ＩＲ）税制適格特約付加有無");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn1(), "", "（ＩＲ）登録家族氏名（カナ）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj1(), "", "（ＩＲ）登録家族氏名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj1(), "", "（ＩＲ）登録家族住所１（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj1(), "", "（ＩＲ）登録家族住所２（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj1(), "", "（ＩＲ）登録家族住所３（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno1(), "", "（ＩＲ）登録家族電話番号１");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi1(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn2(), "", "（ＩＲ）登録家族氏名（カナ）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj2(), "", "（ＩＲ）登録家族氏名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj2(), "", "（ＩＲ）登録家族住所１（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj2(), "", "（ＩＲ）登録家族住所２（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj2(), "", "（ＩＲ）登録家族住所３（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno2(), "", "（ＩＲ）登録家族電話番号２");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi2(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否２");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkn(), "契約者名（カナ）", "（ＩＲ）契約者名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKykdairinmkj(), "", "（ＩＲ）契約者代理人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrtkykhukaumu(), null, "（ＩＲ）契約者代理特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrMousideninkbn(), C_MousideninKbn.BLNK, "（ＩＲ）申出人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrknhatudoujyoutai(), C_KykdrknHtdjytKbn.BLNK, "（ＩＲ）契約者代理権発動状態");
        exStringEquals(khSeikyuusyoBean.getIrDrstiskkyknmkj(), "契約者名", "（ＩＲ）代理人指定先契約者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTyouhyoutitle(), null, "（ＩＲ）帳票タイトル");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg1(), null, "（ＩＲ）送付案内メッセージ１");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg2(), null, "（ＩＲ）送付案内メッセージ２");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg3(), null, "（ＩＲ）送付案内メッセージ３");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg4(), null, "（ＩＲ）送付案内メッセージ４");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg5(), null, "（ＩＲ）送付案内メッセージ５");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg6(), null, "（ＩＲ）送付案内メッセージ６");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg7(), null, "（ＩＲ）送付案内メッセージ７");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg8(), null, "（ＩＲ）送付案内メッセージ８");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg9(), null, "（ＩＲ）送付案内メッセージ９");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg10(), null, "（ＩＲ）送付案内メッセージ１０");

        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean)kSBean[1];

        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(), null, "（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(), "userId001", "（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(), "user001", "（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(), DateFormatUtil.dateKANJI(BizDate.getSysDate()), "（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(), "3 年", "（ＩＲ）保存期間");
    }

    @Test
    @TestOrder(80)
    public void testEditBean_A8() {

        MockObjectManager.initialize();

        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;

        AM_User aMUser = new AM_User();

        aMUser.setUserId("userId001");
        aMUser.setUserNm("user001");
        changeCurrentUser(baseUserInfo, aMUser);

        editSeikyuusyoParam.setHhknseiymd(BizDate.valueOf(20151026));
        editSeikyuusyoParam.setHhknseiymdhenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setHhknsei(C_Hhknsei.MALE);
        editSeikyuusyoParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setBfrTargettkmokuhyouti(BizNumber.valueOf(101));
        editSeikyuusyoParam.setBfrKihonS(BizCurrency.valueOf(778));
        editSeikyuusyoParam.setBfrP(BizCurrency.valueOf(1566));
        editSeikyuusyoParam.setBfrTokuyakuNenkinsyuKbn(C_Nstknsyu.KAKUTEINENKIN);
        editSeikyuusyoParam.setBfrNkshrtkyknksyukkn(5);
        editSeikyuusyoParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU);
        editSeikyuusyoParam.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editSeikyuusyoParam.setGengkhouKbn(C_GengkhouKbn.SD);
        editSeikyuusyoParam.setHenkankumukbn(C_UmuKbn.ARI);
        editSeikyuusyoParam.setRstuukasyu(C_Tuukasyu.JPY);
        editSeikyuusyoParam.setNkshrtkykhnkkbn(C_NstkhKbn.NAIYOUHENKOU);
        editSeikyuusyoParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);
        editSeikyuusyoParam.setJyudkaigomaebaraiTkykhnkKbn(C_JyudkaigomaebaraiTkykhnkKbn.BLNK);
        editSeikyuusyoParam.setKihonshenkouumu(C_UmuKbn.NONE);
        editSeikyuusyoParam.setTmttknitenkbn(C_Tmttknitenkbn.BLNK);
        editSeikyuusyoParam.setTmttknitenymd(null);
        editSeikyuusyoParam.setKhhrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSeikyuusyoParam.setKhskssakuseijiyuu(C_Khskssakuseijiyuu.BLNK);
        editSeikyuusyoParam.setHenkougokjnkngk(BizCurrency.valueOf(100000));

        ReportServicesBean reSsBean =  editSeikyuusyoTbl.editBean(C_SyoruiCdKbn.KK_MEIGIHNK_SKS, syono7, khozenCommonParam, editSeikyuusyoParam);

        Object[] kSBean = reSsBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_MEIGIHNK_SKS.getValue());

        exNumericEquals(kSBean.length, 2, "パラメータオブジェクトの要素数");

        exNumericEquals(reSsBean.getKensakuKeys().length, 1, "検索キー配列の要素数");
        exStringEquals(reSsBean.getKensakuKeys()[0], "12806345731", "検索キー");

        KhSeikyuusyoBean khSeikyuusyoBean = (KhSeikyuusyoBean)kSBean[0];

        exStringEquals(khSeikyuusyoBean.getIrSyono(), "12806345731", "（ＩＲ）証券番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinyno(), "1234567", "（ＩＲ）通信先郵便番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr1kj(), "通信先住所１", "（ＩＲ）通信先住所１（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr2kj(), "通信先住所２", "（ＩＲ）通信先住所２（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr3kj(), "通信先住所３", "（ＩＲ）通信先住所３（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsintelno(), "023-5677-8999", "（ＩＲ）通信先電話番号");
        exStringEquals(khSeikyuusyoBean.getIrBanknmkj(), "", "（ＩＲ）銀行名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrSitennmkj(), "", "（ＩＲ）支店名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrBankcd(), "", "（ＩＲ）銀行コード");
        exStringEquals(khSeikyuusyoBean.getIrSitencd(), "", "（ＩＲ）支店コード");

        exStringEquals(khSeikyuusyoBean.getIrKzmeiginmkn(), "", "（ＩＲ）口座名義人氏名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkj(), "契約者名", "（ＩＲ）契約者名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKkkyktdk(), C_Tdk.HGU, "（ＩＲ）契約管理契約者続柄");
        exStringEquals(khSeikyuusyoBean.getIrHhknnmkj(), "被保険者名", "（ＩＲ）被保険者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrHhknseiymd(), "", "（ＩＲ）被保険者生年月日");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseiymdhenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者生年月日変更有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknsei(), C_Hhknsei.MALE, "（ＩＲ）被保険者性別");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseihenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者性別変更有無");
        exStringEquals(khSeikyuusyoBean.getIrStdrsknmkj(), "", "（ＩＲ）指定代理請求人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrFatcakakuninyhkbn(), C_YouhiblnkKbn.HUYOU, "（ＩＲ）FATCA確認要否区分");
        exClassificationEquals(khSeikyuusyoBean.getIrAeoikakuninyhkbn(), C_YouhiblnkKbn.YOU, "（ＩＲ）ＡＥＯＩ確認要否区分");

        exClassificationEquals(khSeikyuusyoBean.getIrTargettkkbn(), C_TargetTkKbn.BLNK, "（ＩＲ）ターゲット特約区分");
        exNumericEquals(khSeikyuusyoBean.getIrAftertargettkmokuhyouti(), 101, "（ＩＲ）変更後ターゲット特約目標値");
        exNumericEquals(khSeikyuusyoBean.getIrBeforetargettkmokuhyouti(), 200, "（ＩＲ）変更前ターゲット特約目標値");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforekihons(), BizCurrency.valueOf(100), "（ＩＲ）基本保険金額（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkihons(),  BizCurrency.valueOf(778), "（ＩＲ）基本保険金額（変更後）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforep(), BizCurrency.valueOf(200), "（ＩＲ）保険料（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterp(), BizCurrency.valueOf(1566), "（ＩＲ）保険料（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrKyktuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）契約通貨種類");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj1(), "被保険者名", "（ＩＲ）死亡受取人名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj2(), "", "（ＩＲ）死亡受取人名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj3(), "", "（ＩＲ）死亡受取人名（漢字）３");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj4(), "", "（ＩＲ）死亡受取人名（漢字）４");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkn(), "被保険者名（カナ）", "（ＩＲ）死亡受取人名（カナ）");
        exClassificationEquals(khSeikyuusyoBean.getIrYokinkbn(), C_YokinKbn.BLNK, "（ＩＲ）預金種目区分");
        exStringEquals(khSeikyuusyoBean.getIrKouzano(), "", "（ＩＲ）口座番号");

        exClassificationEquals(khSeikyuusyoBean.getIrAfternkshrtkyknksyukbn(), C_Nstknsyu.KAKUTEINENKIN, "（ＩＲ）変更後年金支払特約年金種類区分");
        exClassificationEquals(khSeikyuusyoBean.getIrBiforenkshrtkyknksyukbn(), C_Nstknsyu.BLNK, "（ＩＲ）変更前年金支払特約年金種類区分");
        exNumericEquals(khSeikyuusyoBean.getIrAfternkshrtkyknkkkn(), 5, "（ＩＲ）変更後年金支払特約年金期間");
        exNumericEquals(khSeikyuusyoBean.getIrBeforenkshrtkyknkkkn(), 10, "（ＩＲ）変更前年金支払特約年金期間");
        exStringEquals(khSeikyuusyoBean.getIrNkuktnm(), "", "（ＩＲ）年金受取人名");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari1(), BizNumber.valueOf(120), "（ＩＲ）死亡受取人分割割合１");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari2(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合２");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari3(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合３");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari4(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合４");
        exClassificationEquals(khSeikyuusyoBean.getIrTargettkhnkkbn(), C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU, "（ＩＲ）ターゲット特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKaiyakujiyuu(), C_Kaiyakujiyuu.TUUJYOU, "（ＩＲ）解約事由");
        exClassificationEquals(khSeikyuusyoBean.getIrGengkhoukbn(), C_GengkhouKbn.SD, "（ＩＲ）減額方法区分");
        exNumericEquals(khSeikyuusyoBean.getIrSbuktnin(), 2, "（ＩＲ）死亡受取人人数");
        exClassificationEquals(khSeikyuusyoBean.getIrSbuuktkbn(), C_UktKbn.HHKN, "（ＩＲ）死亡受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrYenshrtkumu(), C_UmuKbn.ARI, "（ＩＲ）円支払特約有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHenkankinumukbn(), C_UmuKbn.ARI, "（ＩＲ）返還金有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrRstuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）領収通貨種類");
        exClassificationEquals(khSeikyuusyoBean.getIrNkshrtkykhnkkbn(), C_NstkhKbn.NAIYOUHENKOU, "（ＩＲ）年金支払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrMeigihnkjiyuu(), C_Meigihnkjiyuu.KYK, "（ＩＲ）名義変更事由");
        exClassificationEquals(khSeikyuusyoBean.getIrNkhknumu(), C_UmuKbn.ARI, "（ＩＲ）年金保険有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSiboukyhkuktumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡給付金受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn1(), C_UmuKbn.ARI, "（ＩＲ）死亡保険金受取人有無区分１");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn2(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分２");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn3(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分３");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn4(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分４");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu1(), C_UmuKbn.ARI, "（ＩＲ）死亡受取人分割割合有無１");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu2(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無２");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu3(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無３");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu4(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無４");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyhukaumu(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyuuktmukbn(), C_UmuKbn.NONE, "（ＩＲ）指定代理請求特約受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrStdruktkbn(), C_UktKbn.BLNK, "（ＩＲ）指定代理受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrJyudkaigomaebrtkykhnkkbn(),C_JyudkaigomaebaraiTkykhnkKbn.BLNK, "（ＩＲ）重度介護前払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKeihikbn(),C_KeihiKbn.BLNK,"（ＩＲ）契被区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKihonshenkouumu(),C_UmuKbn.NONE,"（ＩＲ）基本Ｓ変更有無");
        exStringEquals(khSeikyuusyoBean.getIrKihonssyurui(), "基本保険金額", "（ＩＲ）基本Ｓ種類");
        exClassificationEquals(khSeikyuusyoBean.getIrTmttknitenkbn(), C_Tmttknitenkbn.BLNK, "（ＩＲ）積立金移転区分");
        exStringEquals(khSeikyuusyoBean.getIrTmttknitenymd(), null, "（ＩＲ）積立金移転日");
        exClassificationEquals(khSeikyuusyoBean.getIrKhhrshrjiyuu(), C_Khhrshrjiyuu.BLNK, "（ＩＲ）契約保全返戻金支払事由");
        exClassificationEquals(khSeikyuusyoBean.getIrKhskssakuseijiyuu(), C_Khskssakuseijiyuu.BLNK, "（ＩＲ）契約保全請求書作成事由");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkijyunkingaku(), BizCurrency.valueOf(100000), "（ＩＲ）基準金額（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrHrkkeiro(), C_Hrkkeiro.DANTAI, "（ＩＲ）払込経路");
        exNumericEquals(khSeikyuusyoBean.getIrSyouhnhanteikekka(), 999, "（ＩＲ）商品判定結果");
        exClassificationEquals(khSeikyuusyoBean.getIrKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "（ＩＲ）契約状態");
        exClassificationEquals(khSeikyuusyoBean.getIrZeiseitkkktkykhukaumu(), C_UmuKbn.ARI, "（ＩＲ）税制適格特約付加有無");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn1(), "", "（ＩＲ）登録家族氏名（カナ）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj1(), "", "（ＩＲ）登録家族氏名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj1(), "", "（ＩＲ）登録家族住所１（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj1(), "", "（ＩＲ）登録家族住所２（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj1(), "", "（ＩＲ）登録家族住所３（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno1(), "", "（ＩＲ）登録家族電話番号１");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi1(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn2(), "", "（ＩＲ）登録家族氏名（カナ）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj2(), "", "（ＩＲ）登録家族氏名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj2(), "", "（ＩＲ）登録家族住所１（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj2(), "", "（ＩＲ）登録家族住所２（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj2(), "", "（ＩＲ）登録家族住所３（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno2(), "", "（ＩＲ）登録家族電話番号２");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi2(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否２");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkn(), null, "（ＩＲ）契約者名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKykdairinmkj(), "", "（ＩＲ）契約者代理人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrtkykhukaumu(), null, "（ＩＲ）契約者代理特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrMousideninkbn(), C_MousideninKbn.BLNK, "（ＩＲ）申出人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrknhatudoujyoutai(), C_KykdrknHtdjytKbn.BLNK, "（ＩＲ）契約者代理権発動状態");
        exStringEquals(khSeikyuusyoBean.getIrDrstiskkyknmkj(), "契約者名", "（ＩＲ）代理人指定先契約者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTyouhyoutitle(), null, "（ＩＲ）帳票タイトル");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg1(), null, "（ＩＲ）送付案内メッセージ１");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg2(), null, "（ＩＲ）送付案内メッセージ２");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg3(), null, "（ＩＲ）送付案内メッセージ３");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg4(), null, "（ＩＲ）送付案内メッセージ４");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg5(), null, "（ＩＲ）送付案内メッセージ５");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg6(), null, "（ＩＲ）送付案内メッセージ６");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg7(), null, "（ＩＲ）送付案内メッセージ７");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg8(), null, "（ＩＲ）送付案内メッセージ８");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg9(), null, "（ＩＲ）送付案内メッセージ９");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg10(), null, "（ＩＲ）送付案内メッセージ１０");

        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean)kSBean[1];

        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(), null, "（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(), "userId001", "（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(), "user001", "（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(), DateFormatUtil.dateKANJI(BizDate.getSysDate()), "（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(), "3 年", "（ＩＲ）保存期間");
    }

    @Test
    @TestOrder(90)
    public void testEditBean_A9() {

        MockObjectManager.initialize();

        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;

        AM_User aMUser = new AM_User();

        aMUser.setUserId("userId001");
        aMUser.setUserNm("user001");
        changeCurrentUser(baseUserInfo, aMUser);

        editSeikyuusyoParam.setHhknseiymd(BizDate.valueOf(20151026));
        editSeikyuusyoParam.setHhknseiymdhenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setHhknsei(C_Hhknsei.MALE);
        editSeikyuusyoParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setBfrTargettkmokuhyouti(BizNumber.valueOf(101));
        editSeikyuusyoParam.setBfrKihonS(BizCurrency.valueOf(778));
        editSeikyuusyoParam.setBfrP(BizCurrency.valueOf(1566));
        editSeikyuusyoParam.setBfrTokuyakuNenkinsyuKbn(C_Nstknsyu.KAKUTEINENKIN);
        editSeikyuusyoParam.setBfrNkshrtkyknksyukkn(5);
        editSeikyuusyoParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU);
        editSeikyuusyoParam.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editSeikyuusyoParam.setGengkhouKbn(C_GengkhouKbn.SD);
        editSeikyuusyoParam.setHenkankumukbn(C_UmuKbn.ARI);
        editSeikyuusyoParam.setRstuukasyu(C_Tuukasyu.JPY);
        editSeikyuusyoParam.setNkshrtkykhnkkbn(C_NstkhKbn.NAIYOUHENKOU);
        editSeikyuusyoParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);
        editSeikyuusyoParam.setJyudkaigomaebaraiTkykhnkKbn(C_JyudkaigomaebaraiTkykhnkKbn.BLNK);
        editSeikyuusyoParam.setKihonshenkouumu(C_UmuKbn.NONE);
        editSeikyuusyoParam.setTmttknitenkbn(C_Tmttknitenkbn.BLNK);
        editSeikyuusyoParam.setTmttknitenymd(null);
        editSeikyuusyoParam.setKhhrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSeikyuusyoParam.setKhskssakuseijiyuu(C_Khskssakuseijiyuu.BLNK);
        editSeikyuusyoParam.setHenkougokjnkngk(BizCurrency.valueOf(100000));

        ReportServicesBean reSsBean =  editSeikyuusyoTbl.editBean(C_SyoruiCdKbn.KK_MEIGIHNK_SKS, syono8, khozenCommonParam, editSeikyuusyoParam);

        Object[] kSBean = reSsBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_MEIGIHNK_SKS.getValue());

        exNumericEquals(kSBean.length, 2, "パラメータオブジェクトの要素数");

        exNumericEquals(reSsBean.getKensakuKeys().length, 1, "検索キー配列の要素数");
        exStringEquals(reSsBean.getKensakuKeys()[0], "12806345742", "検索キー");

        KhSeikyuusyoBean khSeikyuusyoBean = (KhSeikyuusyoBean)kSBean[0];

        exStringEquals(khSeikyuusyoBean.getIrSyono(), "12806345742", "（ＩＲ）証券番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinyno(), "1234567", "（ＩＲ）通信先郵便番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr1kj(), "通信先住所１", "（ＩＲ）通信先住所１（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr2kj(), "通信先住所２", "（ＩＲ）通信先住所２（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr3kj(), "通信先住所３", "（ＩＲ）通信先住所３（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsintelno(), "023-5677-8999", "（ＩＲ）通信先電話番号");
        exStringEquals(khSeikyuusyoBean.getIrBanknmkj(), "", "（ＩＲ）銀行名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrSitennmkj(), "", "（ＩＲ）支店名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrBankcd(), "", "（ＩＲ）銀行コード");
        exStringEquals(khSeikyuusyoBean.getIrSitencd(), "", "（ＩＲ）支店コード");

        exStringEquals(khSeikyuusyoBean.getIrKzmeiginmkn(), "", "（ＩＲ）口座名義人氏名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkj(), "契約者名", "（ＩＲ）契約者名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKkkyktdk(), C_Tdk.HGU, "（ＩＲ）契約管理契約者続柄");
        exStringEquals(khSeikyuusyoBean.getIrHhknnmkj(), "被保険者名", "（ＩＲ）被保険者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrHhknseiymd(), "", "（ＩＲ）被保険者生年月日");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseiymdhenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者生年月日変更有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknsei(), C_Hhknsei.MALE, "（ＩＲ）被保険者性別");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseihenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者性別変更有無");
        exStringEquals(khSeikyuusyoBean.getIrStdrsknmkj(), "", "（ＩＲ）指定代理請求人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrFatcakakuninyhkbn(), C_YouhiblnkKbn.HUYOU, "（ＩＲ）FATCA確認要否区分");
        exClassificationEquals(khSeikyuusyoBean.getIrAeoikakuninyhkbn(), C_YouhiblnkKbn.YOU, "（ＩＲ）ＡＥＯＩ確認要否区分");

        exClassificationEquals(khSeikyuusyoBean.getIrTargettkkbn(), C_TargetTkKbn.BLNK, "（ＩＲ）ターゲット特約区分");
        exNumericEquals(khSeikyuusyoBean.getIrAftertargettkmokuhyouti(), 101, "（ＩＲ）変更後ターゲット特約目標値");
        exNumericEquals(khSeikyuusyoBean.getIrBeforetargettkmokuhyouti(), 200, "（ＩＲ）変更前ターゲット特約目標値");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforekihons(), BizCurrency.valueOf(100), "（ＩＲ）基本保険金額（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkihons(),  BizCurrency.valueOf(778), "（ＩＲ）基本保険金額（変更後）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforep(), BizCurrency.valueOf(200), "（ＩＲ）保険料（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterp(), BizCurrency.valueOf(1566), "（ＩＲ）保険料（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrKyktuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）契約通貨種類");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj1(), "小野", "（ＩＲ）死亡受取人名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj2(), "", "（ＩＲ）死亡受取人名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj3(), "契約者名", "（ＩＲ）死亡受取人名（漢字）３");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj4(), "被保険者名", "（ＩＲ）死亡受取人名（漢字）４");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkn(), "受取人名（カナ）", "（ＩＲ）死亡受取人名（カナ）");
        exClassificationEquals(khSeikyuusyoBean.getIrYokinkbn(), C_YokinKbn.BLNK, "（ＩＲ）預金種目区分");
        exStringEquals(khSeikyuusyoBean.getIrKouzano(), "", "（ＩＲ）口座番号");

        exClassificationEquals(khSeikyuusyoBean.getIrAfternkshrtkyknksyukbn(), C_Nstknsyu.KAKUTEINENKIN, "（ＩＲ）変更後年金支払特約年金種類区分");
        exClassificationEquals(khSeikyuusyoBean.getIrBiforenkshrtkyknksyukbn(), C_Nstknsyu.BLNK, "（ＩＲ）変更前年金支払特約年金種類区分");
        exNumericEquals(khSeikyuusyoBean.getIrAfternkshrtkyknkkkn(), 5, "（ＩＲ）変更後年金支払特約年金期間");
        exNumericEquals(khSeikyuusyoBean.getIrBeforenkshrtkyknkkkn(), 10, "（ＩＲ）変更前年金支払特約年金期間");
        exStringEquals(khSeikyuusyoBean.getIrNkuktnm(), "", "（ＩＲ）年金受取人名");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari1(), BizNumber.valueOf(130), "（ＩＲ）死亡受取人分割割合１");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari2(), BizNumber.valueOf(140), "（ＩＲ）死亡受取人分割割合２");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari3(), BizNumber.valueOf(150), "（ＩＲ）死亡受取人分割割合３");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari4(), BizNumber.valueOf(160), "（ＩＲ）死亡受取人分割割合４");
        exClassificationEquals(khSeikyuusyoBean.getIrTargettkhnkkbn(), C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU, "（ＩＲ）ターゲット特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKaiyakujiyuu(), C_Kaiyakujiyuu.TUUJYOU, "（ＩＲ）解約事由");
        exClassificationEquals(khSeikyuusyoBean.getIrGengkhoukbn(), C_GengkhouKbn.SD, "（ＩＲ）減額方法区分");
        exNumericEquals(khSeikyuusyoBean.getIrSbuktnin(), 2, "（ＩＲ）死亡受取人人数");
        exClassificationEquals(khSeikyuusyoBean.getIrSbuuktkbn(), C_UktKbn.BLNK, "（ＩＲ）死亡受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrYenshrtkumu(), C_UmuKbn.ARI, "（ＩＲ）円支払特約有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHenkankinumukbn(), C_UmuKbn.ARI, "（ＩＲ）返還金有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrRstuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）領収通貨種類");
        exClassificationEquals(khSeikyuusyoBean.getIrNkshrtkykhnkkbn(), C_NstkhKbn.NAIYOUHENKOU, "（ＩＲ）年金支払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrMeigihnkjiyuu(), C_Meigihnkjiyuu.KYK, "（ＩＲ）名義変更事由");
        exClassificationEquals(khSeikyuusyoBean.getIrNkhknumu(), C_UmuKbn.ARI, "（ＩＲ）年金保険有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSiboukyhkuktumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡給付金受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn1(), C_UmuKbn.ARI, "（ＩＲ）死亡保険金受取人有無区分１");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn2(), C_UmuKbn.ARI, "（ＩＲ）死亡保険金受取人有無区分２");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn3(), C_UmuKbn.ARI, "（ＩＲ）死亡保険金受取人有無区分３");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn4(), C_UmuKbn.ARI, "（ＩＲ）死亡保険金受取人有無区分４");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu1(), C_UmuKbn.ARI, "（ＩＲ）死亡受取人分割割合有無１");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu2(), C_UmuKbn.ARI, "（ＩＲ）死亡受取人分割割合有無２");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu3(), C_UmuKbn.ARI, "（ＩＲ）死亡受取人分割割合有無３");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu4(), C_UmuKbn.ARI, "（ＩＲ）死亡受取人分割割合有無４");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyhukaumu(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyuuktmukbn(), C_UmuKbn.NONE, "（ＩＲ）指定代理請求特約受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrStdruktkbn(), C_UktKbn.BLNK, "（ＩＲ）指定代理受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrJyudkaigomaebrtkykhnkkbn(),C_JyudkaigomaebaraiTkykhnkKbn.BLNK, "（ＩＲ）重度介護前払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKeihikbn(),C_KeihiKbn.BLNK,"（ＩＲ）契被区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKihonshenkouumu(),C_UmuKbn.NONE,"（ＩＲ）基本Ｓ変更有無");
        exStringEquals(khSeikyuusyoBean.getIrKihonssyurui(), "基本保険金額", "（ＩＲ）基本Ｓ種類");
        exClassificationEquals(khSeikyuusyoBean.getIrTmttknitenkbn(), C_Tmttknitenkbn.BLNK, "（ＩＲ）積立金移転区分");
        exStringEquals(khSeikyuusyoBean.getIrTmttknitenymd(), null, "（ＩＲ）積立金移転日");
        exClassificationEquals(khSeikyuusyoBean.getIrKhhrshrjiyuu(), C_Khhrshrjiyuu.BLNK, "（ＩＲ）契約保全返戻金支払事由");
        exClassificationEquals(khSeikyuusyoBean.getIrKhskssakuseijiyuu(), C_Khskssakuseijiyuu.BLNK, "（ＩＲ）契約保全請求書作成事由");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkijyunkingaku(), BizCurrency.valueOf(100000), "（ＩＲ）基準金額（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrHrkkeiro(), C_Hrkkeiro.DANTAI, "（ＩＲ）払込経路");
        exNumericEquals(khSeikyuusyoBean.getIrSyouhnhanteikekka(), 999, "（ＩＲ）商品判定結果");
        exClassificationEquals(khSeikyuusyoBean.getIrKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "（ＩＲ）契約状態");
        exClassificationEquals(khSeikyuusyoBean.getIrZeiseitkkktkykhukaumu(), C_UmuKbn.ARI, "（ＩＲ）税制適格特約付加有無");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn1(), "", "（ＩＲ）登録家族氏名（カナ）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj1(), "", "（ＩＲ）登録家族氏名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj1(), "", "（ＩＲ）登録家族住所１（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj1(), "", "（ＩＲ）登録家族住所２（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj1(), "", "（ＩＲ）登録家族住所３（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno1(), "", "（ＩＲ）登録家族電話番号１");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi1(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn2(), "", "（ＩＲ）登録家族氏名（カナ）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj2(), "", "（ＩＲ）登録家族氏名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj2(), "", "（ＩＲ）登録家族住所１（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj2(), "", "（ＩＲ）登録家族住所２（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj2(), "", "（ＩＲ）登録家族住所３（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno2(), "", "（ＩＲ）登録家族電話番号２");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi2(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否２");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkn(), "契約者名（カナ）", "（ＩＲ）契約者名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKykdairinmkj(), "", "（ＩＲ）契約者代理人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrtkykhukaumu(), null, "（ＩＲ）契約者代理特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrMousideninkbn(), C_MousideninKbn.BLNK, "（ＩＲ）申出人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrknhatudoujyoutai(), C_KykdrknHtdjytKbn.BLNK, "（ＩＲ）契約者代理権発動状態");
        exStringEquals(khSeikyuusyoBean.getIrDrstiskkyknmkj(), "契約者名", "（ＩＲ）代理人指定先契約者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTyouhyoutitle(), null, "（ＩＲ）帳票タイトル");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg1(), null, "（ＩＲ）送付案内メッセージ１");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg2(), null, "（ＩＲ）送付案内メッセージ２");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg3(), null, "（ＩＲ）送付案内メッセージ３");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg4(), null, "（ＩＲ）送付案内メッセージ４");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg5(), null, "（ＩＲ）送付案内メッセージ５");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg6(), null, "（ＩＲ）送付案内メッセージ６");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg7(), null, "（ＩＲ）送付案内メッセージ７");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg8(), null, "（ＩＲ）送付案内メッセージ８");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg9(), null, "（ＩＲ）送付案内メッセージ９");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg10(), null, "（ＩＲ）送付案内メッセージ１０");

        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean)kSBean[1];

        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(), null, "（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(), "userId001", "（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(), "user001", "（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(), DateFormatUtil.dateKANJI(BizDate.getSysDate()), "（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(), "3 年", "（ＩＲ）保存期間");
    }

    @Test
    @TestOrder(100)
    public void testEditBean_A10() {

        MockObjectManager.initialize();

        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;

        AM_User aMUser = new AM_User();

        aMUser.setUserId("userId001");
        aMUser.setUserNm("user001");
        changeCurrentUser(baseUserInfo, aMUser);

        editSeikyuusyoParam.setHhknseiymd(BizDate.valueOf(20151026));
        editSeikyuusyoParam.setHhknseiymdhenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setHhknsei(C_Hhknsei.MALE);
        editSeikyuusyoParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setBfrTargettkmokuhyouti(BizNumber.valueOf(101));
        editSeikyuusyoParam.setBfrKihonS(BizCurrency.valueOf(778));
        editSeikyuusyoParam.setBfrP(BizCurrency.valueOf(1566));
        editSeikyuusyoParam.setBfrTokuyakuNenkinsyuKbn(C_Nstknsyu.KAKUTEINENKIN);
        editSeikyuusyoParam.setBfrNkshrtkyknksyukkn(5);
        editSeikyuusyoParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU);
        editSeikyuusyoParam.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editSeikyuusyoParam.setGengkhouKbn(C_GengkhouKbn.SD);
        editSeikyuusyoParam.setHenkankumukbn(C_UmuKbn.ARI);
        editSeikyuusyoParam.setRstuukasyu(C_Tuukasyu.JPY);
        editSeikyuusyoParam.setNkshrtkykhnkkbn(C_NstkhKbn.NAIYOUHENKOU);
        editSeikyuusyoParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);
        editSeikyuusyoParam.setJyudkaigomaebaraiTkykhnkKbn(C_JyudkaigomaebaraiTkykhnkKbn.BLNK);
        editSeikyuusyoParam.setKihonshenkouumu(C_UmuKbn.NONE);
        editSeikyuusyoParam.setTmttknitenkbn(C_Tmttknitenkbn.BLNK);
        editSeikyuusyoParam.setTmttknitenymd(null);
        editSeikyuusyoParam.setKhhrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSeikyuusyoParam.setKhskssakuseijiyuu(C_Khskssakuseijiyuu.BLNK);
        editSeikyuusyoParam.setHenkougokjnkngk(BizCurrency.valueOf(100000));

        ReportServicesBean reSsBean =  editSeikyuusyoTbl.editBean(C_SyoruiCdKbn.KK_MEIGIHNK_SKS, syono9, khozenCommonParam, editSeikyuusyoParam);

        Object[] kSBean = reSsBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_MEIGIHNK_SKS.getValue());

        exNumericEquals(kSBean.length, 2, "パラメータオブジェクトの要素数");

        exNumericEquals(reSsBean.getKensakuKeys().length, 1, "検索キー配列の要素数");
        exStringEquals(reSsBean.getKensakuKeys()[0], "12806345753", "検索キー");

        KhSeikyuusyoBean khSeikyuusyoBean = (KhSeikyuusyoBean)kSBean[0];

        exStringEquals(khSeikyuusyoBean.getIrSyono(), "12806345753", "（ＩＲ）証券番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinyno(), "1234567", "（ＩＲ）通信先郵便番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr1kj(), "通信先住所１", "（ＩＲ）通信先住所１（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr2kj(), "通信先住所２", "（ＩＲ）通信先住所２（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr3kj(), "通信先住所３", "（ＩＲ）通信先住所３（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsintelno(), "023-5677-8999", "（ＩＲ）通信先電話番号");
        exStringEquals(khSeikyuusyoBean.getIrBanknmkj(), "", "（ＩＲ）銀行名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrSitennmkj(), "", "（ＩＲ）支店名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrBankcd(), "", "（ＩＲ）銀行コード");
        exStringEquals(khSeikyuusyoBean.getIrSitencd(), "", "（ＩＲ）支店コード");

        exStringEquals(khSeikyuusyoBean.getIrKzmeiginmkn(), "", "（ＩＲ）口座名義人氏名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkj(), "契約者名", "（ＩＲ）契約者名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKkkyktdk(), C_Tdk.HGU, "（ＩＲ）契約管理契約者続柄");
        exStringEquals(khSeikyuusyoBean.getIrHhknnmkj(), "被保険者名", "（ＩＲ）被保険者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrHhknseiymd(), "", "（ＩＲ）被保険者生年月日");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseiymdhenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者生年月日変更有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknsei(), C_Hhknsei.MALE, "（ＩＲ）被保険者性別");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseihenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者性別変更有無");
        exStringEquals(khSeikyuusyoBean.getIrStdrsknmkj(), "契約者名", "（ＩＲ）指定代理請求人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrFatcakakuninyhkbn(), C_YouhiblnkKbn.HUYOU, "（ＩＲ）FATCA確認要否区分");
        exClassificationEquals(khSeikyuusyoBean.getIrAeoikakuninyhkbn(), C_YouhiblnkKbn.YOU, "（ＩＲ）ＡＥＯＩ確認要否区分");

        exClassificationEquals(khSeikyuusyoBean.getIrTargettkkbn(), C_TargetTkKbn.BLNK, "（ＩＲ）ターゲット特約区分");
        exNumericEquals(khSeikyuusyoBean.getIrAftertargettkmokuhyouti(), 101, "（ＩＲ）変更後ターゲット特約目標値");
        exNumericEquals(khSeikyuusyoBean.getIrBeforetargettkmokuhyouti(), 200, "（ＩＲ）変更前ターゲット特約目標値");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforekihons(), BizCurrency.valueOf(100), "（ＩＲ）基本保険金額（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkihons(),  BizCurrency.valueOf(778), "（ＩＲ）基本保険金額（変更後）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforep(), BizCurrency.valueOf(200), "（ＩＲ）保険料（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterp(), BizCurrency.valueOf(1566), "（ＩＲ）保険料（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrKyktuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）契約通貨種類");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj1(), "小野", "（ＩＲ）死亡受取人名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj2(), "", "（ＩＲ）死亡受取人名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj3(), "契約者名", "（ＩＲ）死亡受取人名（漢字）３");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj4(), "被保険者名", "（ＩＲ）死亡受取人名（漢字）４");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkn(), "受取人名（カナ）", "（ＩＲ）死亡受取人名（カナ）");
        exClassificationEquals(khSeikyuusyoBean.getIrYokinkbn(), C_YokinKbn.BLNK, "（ＩＲ）預金種目区分");
        exStringEquals(khSeikyuusyoBean.getIrKouzano(), "", "（ＩＲ）口座番号");

        exClassificationEquals(khSeikyuusyoBean.getIrAfternkshrtkyknksyukbn(), C_Nstknsyu.KAKUTEINENKIN, "（ＩＲ）変更後年金支払特約年金種類区分");
        exClassificationEquals(khSeikyuusyoBean.getIrBiforenkshrtkyknksyukbn(), C_Nstknsyu.BLNK, "（ＩＲ）変更前年金支払特約年金種類区分");
        exNumericEquals(khSeikyuusyoBean.getIrAfternkshrtkyknkkkn(), 5, "（ＩＲ）変更後年金支払特約年金期間");
        exNumericEquals(khSeikyuusyoBean.getIrBeforenkshrtkyknkkkn(), 10, "（ＩＲ）変更前年金支払特約年金期間");
        exStringEquals(khSeikyuusyoBean.getIrNkuktnm(), "契約者名", "（ＩＲ）年金受取人名");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari1(), BizNumber.valueOf(170), "（ＩＲ）死亡受取人分割割合１");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari2(), BizNumber.valueOf(180), "（ＩＲ）死亡受取人分割割合２");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari3(), BizNumber.valueOf(190), "（ＩＲ）死亡受取人分割割合３");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari4(), BizNumber.valueOf(200), "（ＩＲ）死亡受取人分割割合４");
        exClassificationEquals(khSeikyuusyoBean.getIrTargettkhnkkbn(), C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU, "（ＩＲ）ターゲット特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKaiyakujiyuu(), C_Kaiyakujiyuu.TUUJYOU, "（ＩＲ）解約事由");
        exClassificationEquals(khSeikyuusyoBean.getIrGengkhoukbn(), C_GengkhouKbn.SD, "（ＩＲ）減額方法区分");
        exNumericEquals(khSeikyuusyoBean.getIrSbuktnin(), 2, "（ＩＲ）死亡受取人人数");
        exClassificationEquals(khSeikyuusyoBean.getIrSbuuktkbn(), C_UktKbn.BLNK, "（ＩＲ）死亡受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrYenshrtkumu(), C_UmuKbn.ARI, "（ＩＲ）円支払特約有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHenkankinumukbn(), C_UmuKbn.ARI, "（ＩＲ）返還金有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrRstuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）領収通貨種類");
        exClassificationEquals(khSeikyuusyoBean.getIrNkshrtkykhnkkbn(), C_NstkhKbn.NAIYOUHENKOU, "（ＩＲ）年金支払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrMeigihnkjiyuu(), C_Meigihnkjiyuu.KYK, "（ＩＲ）名義変更事由");
        exClassificationEquals(khSeikyuusyoBean.getIrNkhknumu(), C_UmuKbn.ARI, "（ＩＲ）年金保険有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSiboukyhkuktumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡給付金受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn1(), C_UmuKbn.ARI, "（ＩＲ）死亡保険金受取人有無区分１");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn2(), C_UmuKbn.ARI, "（ＩＲ）死亡保険金受取人有無区分２");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn3(), C_UmuKbn.ARI, "（ＩＲ）死亡保険金受取人有無区分３");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn4(), C_UmuKbn.ARI, "（ＩＲ）死亡保険金受取人有無区分４");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu1(), C_UmuKbn.ARI, "（ＩＲ）死亡受取人分割割合有無１");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu2(), C_UmuKbn.ARI, "（ＩＲ）死亡受取人分割割合有無２");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu3(), C_UmuKbn.ARI, "（ＩＲ）死亡受取人分割割合有無３");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu4(), C_UmuKbn.ARI, "（ＩＲ）死亡受取人分割割合有無４");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyhukaumu(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyuuktmukbn(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrStdruktkbn(), C_UktKbn.KYK, "（ＩＲ）指定代理受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrJyudkaigomaebrtkykhnkkbn(),C_JyudkaigomaebaraiTkykhnkKbn.BLNK, "（ＩＲ）重度介護前払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKeihikbn(),C_KeihiKbn.BLNK,"（ＩＲ）契被区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKihonshenkouumu(),C_UmuKbn.NONE,"（ＩＲ）基本Ｓ変更有無");
        exStringEquals(khSeikyuusyoBean.getIrKihonssyurui(), "基本保険金額", "（ＩＲ）基本Ｓ種類");
        exClassificationEquals(khSeikyuusyoBean.getIrTmttknitenkbn(), C_Tmttknitenkbn.BLNK, "（ＩＲ）積立金移転区分");
        exStringEquals(khSeikyuusyoBean.getIrTmttknitenymd(), null, "（ＩＲ）積立金移転日");
        exClassificationEquals(khSeikyuusyoBean.getIrKhhrshrjiyuu(), C_Khhrshrjiyuu.BLNK, "（ＩＲ）契約保全返戻金支払事由");
        exClassificationEquals(khSeikyuusyoBean.getIrKhskssakuseijiyuu(), C_Khskssakuseijiyuu.BLNK, "（ＩＲ）契約保全請求書作成事由");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkijyunkingaku(), BizCurrency.valueOf(100000), "（ＩＲ）基準金額（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrHrkkeiro(), C_Hrkkeiro.DANTAI, "（ＩＲ）払込経路");
        exNumericEquals(khSeikyuusyoBean.getIrSyouhnhanteikekka(), 999, "（ＩＲ）商品判定結果");
        exClassificationEquals(khSeikyuusyoBean.getIrKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "（ＩＲ）契約状態");
        exClassificationEquals(khSeikyuusyoBean.getIrZeiseitkkktkykhukaumu(), C_UmuKbn.ARI, "（ＩＲ）税制適格特約付加有無");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn1(), "", "（ＩＲ）登録家族氏名（カナ）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj1(), "", "（ＩＲ）登録家族氏名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj1(), "", "（ＩＲ）登録家族住所１（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj1(), "", "（ＩＲ）登録家族住所２（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj1(), "", "（ＩＲ）登録家族住所３（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno1(), "", "（ＩＲ）登録家族電話番号１");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi1(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn2(), "", "（ＩＲ）登録家族氏名（カナ）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj2(), "", "（ＩＲ）登録家族氏名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj2(), "", "（ＩＲ）登録家族住所１（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj2(), "", "（ＩＲ）登録家族住所２（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj2(), "", "（ＩＲ）登録家族住所３（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno2(), "", "（ＩＲ）登録家族電話番号２");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi2(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否２");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkn(), "契約者名（カナ）", "（ＩＲ）契約者名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKykdairinmkj(), "", "（ＩＲ）契約者代理人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrtkykhukaumu(), null, "（ＩＲ）契約者代理特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrMousideninkbn(), C_MousideninKbn.BLNK, "（ＩＲ）申出人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrknhatudoujyoutai(), C_KykdrknHtdjytKbn.BLNK, "（ＩＲ）契約者代理権発動状態");
        exStringEquals(khSeikyuusyoBean.getIrDrstiskkyknmkj(), "契約者名", "（ＩＲ）代理人指定先契約者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTyouhyoutitle(), null, "（ＩＲ）帳票タイトル");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg1(), null, "（ＩＲ）送付案内メッセージ１");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg2(), null, "（ＩＲ）送付案内メッセージ２");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg3(), null, "（ＩＲ）送付案内メッセージ３");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg4(), null, "（ＩＲ）送付案内メッセージ４");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg5(), null, "（ＩＲ）送付案内メッセージ５");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg6(), null, "（ＩＲ）送付案内メッセージ６");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg7(), null, "（ＩＲ）送付案内メッセージ７");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg8(), null, "（ＩＲ）送付案内メッセージ８");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg9(), null, "（ＩＲ）送付案内メッセージ９");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg10(), null, "（ＩＲ）送付案内メッセージ１０");

        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean)kSBean[1];

        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(), null, "（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(), "userId001", "（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(), "user001", "（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(), DateFormatUtil.dateKANJI(BizDate.getSysDate()), "（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(), "3 年", "（ＩＲ）保存期間");
    }

    @Test
    @TestOrder(110)
    public void testEditBean_A11() {

        MockObjectManager.initialize();

        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;

        AM_User aMUser = new AM_User();

        aMUser.setUserId("userId001");
        aMUser.setUserNm("user001");
        changeCurrentUser(baseUserInfo, aMUser);

        editSeikyuusyoParam.setHhknseiymd(BizDate.valueOf(20151026));
        editSeikyuusyoParam.setHhknseiymdhenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setHhknsei(C_Hhknsei.MALE);
        editSeikyuusyoParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setBfrTargettkmokuhyouti(BizNumber.valueOf(101));
        editSeikyuusyoParam.setBfrKihonS(BizCurrency.valueOf(778));
        editSeikyuusyoParam.setBfrP(BizCurrency.valueOf(1566));
        editSeikyuusyoParam.setBfrTokuyakuNenkinsyuKbn(C_Nstknsyu.KAKUTEINENKIN);
        editSeikyuusyoParam.setBfrNkshrtkyknksyukkn(5);
        editSeikyuusyoParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU);
        editSeikyuusyoParam.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editSeikyuusyoParam.setGengkhouKbn(C_GengkhouKbn.SD);
        editSeikyuusyoParam.setHenkankumukbn(C_UmuKbn.ARI);
        editSeikyuusyoParam.setRstuukasyu(C_Tuukasyu.JPY);
        editSeikyuusyoParam.setNkshrtkykhnkkbn(C_NstkhKbn.NAIYOUHENKOU);
        editSeikyuusyoParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);
        editSeikyuusyoParam.setJyudkaigomaebaraiTkykhnkKbn(C_JyudkaigomaebaraiTkykhnkKbn.BLNK);
        editSeikyuusyoParam.setKihonshenkouumu(C_UmuKbn.NONE);
        editSeikyuusyoParam.setTmttknitenkbn(C_Tmttknitenkbn.BLNK);
        editSeikyuusyoParam.setTmttknitenymd(null);
        editSeikyuusyoParam.setKhhrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSeikyuusyoParam.setKhskssakuseijiyuu(C_Khskssakuseijiyuu.BLNK);
        editSeikyuusyoParam.setHenkougokjnkngk(BizCurrency.valueOf(100000));

        ReportServicesBean reSsBean =  editSeikyuusyoTbl.editBean(C_SyoruiCdKbn.KK_MEIGIHNK_SKS, syono10, khozenCommonParam, editSeikyuusyoParam);

        Object[] kSBean = reSsBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_MEIGIHNK_SKS.getValue());

        exNumericEquals(kSBean.length, 2, "パラメータオブジェクトの要素数");

        exNumericEquals(reSsBean.getKensakuKeys().length, 1, "検索キー配列の要素数");
        exStringEquals(reSsBean.getKensakuKeys()[0], "12806345764", "検索キー");

        KhSeikyuusyoBean khSeikyuusyoBean = (KhSeikyuusyoBean)kSBean[0];

        exStringEquals(khSeikyuusyoBean.getIrSyono(), "12806345764", "（ＩＲ）証券番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinyno(), "1234567", "（ＩＲ）通信先郵便番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr1kj(), "通信先住所１", "（ＩＲ）通信先住所１（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr2kj(), "通信先住所２", "（ＩＲ）通信先住所２（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr3kj(), "通信先住所３", "（ＩＲ）通信先住所３（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsintelno(), "023-5677-8999", "（ＩＲ）通信先電話番号");
        exStringEquals(khSeikyuusyoBean.getIrBanknmkj(), "", "（ＩＲ）銀行名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrSitennmkj(), "", "（ＩＲ）支店名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrBankcd(), "", "（ＩＲ）銀行コード");
        exStringEquals(khSeikyuusyoBean.getIrSitencd(), "", "（ＩＲ）支店コード");

        exStringEquals(khSeikyuusyoBean.getIrKzmeiginmkn(), "", "（ＩＲ）口座名義人氏名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkj(), "契約者名", "（ＩＲ）契約者名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKkkyktdk(), C_Tdk.HGU, "（ＩＲ）契約管理契約者続柄");
        exStringEquals(khSeikyuusyoBean.getIrHhknnmkj(), "被保険者名", "（ＩＲ）被保険者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrHhknseiymd(), "", "（ＩＲ）被保険者生年月日");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseiymdhenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者生年月日変更有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknsei(), C_Hhknsei.MALE, "（ＩＲ）被保険者性別");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseihenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者性別変更有無");
        exStringEquals(khSeikyuusyoBean.getIrStdrsknmkj(), "被保険者名", "（ＩＲ）指定代理請求人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrFatcakakuninyhkbn(), C_YouhiblnkKbn.HUYOU, "（ＩＲ）FATCA確認要否区分");
        exClassificationEquals(khSeikyuusyoBean.getIrAeoikakuninyhkbn(), C_YouhiblnkKbn.YOU, "（ＩＲ）ＡＥＯＩ確認要否区分");

        exClassificationEquals(khSeikyuusyoBean.getIrTargettkkbn(), C_TargetTkKbn.BLNK, "（ＩＲ）ターゲット特約区分");
        exNumericEquals(khSeikyuusyoBean.getIrAftertargettkmokuhyouti(), 101, "（ＩＲ）変更後ターゲット特約目標値");
        exNumericEquals(khSeikyuusyoBean.getIrBeforetargettkmokuhyouti(), 200, "（ＩＲ）変更前ターゲット特約目標値");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforekihons(), BizCurrency.valueOf(100), "（ＩＲ）基本保険金額（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkihons(),  BizCurrency.valueOf(778), "（ＩＲ）基本保険金額（変更後）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforep(), BizCurrency.valueOf(200), "（ＩＲ）保険料（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterp(), BizCurrency.valueOf(1566), "（ＩＲ）保険料（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrKyktuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）契約通貨種類");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj1(), "小野", "（ＩＲ）死亡受取人名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj2(), "", "（ＩＲ）死亡受取人名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj3(), "", "（ＩＲ）死亡受取人名（漢字）３");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj4(), "", "（ＩＲ）死亡受取人名（漢字）４");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkn(), "受取人名（カナ）", "（ＩＲ）死亡受取人名（カナ）");
        exClassificationEquals(khSeikyuusyoBean.getIrYokinkbn(), C_YokinKbn.BLNK, "（ＩＲ）預金種目区分");
        exStringEquals(khSeikyuusyoBean.getIrKouzano(), "", "（ＩＲ）口座番号");

        exClassificationEquals(khSeikyuusyoBean.getIrAfternkshrtkyknksyukbn(), C_Nstknsyu.KAKUTEINENKIN, "（ＩＲ）変更後年金支払特約年金種類区分");
        exClassificationEquals(khSeikyuusyoBean.getIrBiforenkshrtkyknksyukbn(), C_Nstknsyu.BLNK, "（ＩＲ）変更前年金支払特約年金種類区分");
        exNumericEquals(khSeikyuusyoBean.getIrAfternkshrtkyknkkkn(), 5, "（ＩＲ）変更後年金支払特約年金期間");
        exNumericEquals(khSeikyuusyoBean.getIrBeforenkshrtkyknkkkn(), 10, "（ＩＲ）変更前年金支払特約年金期間");
        exStringEquals(khSeikyuusyoBean.getIrNkuktnm(), "被保険者名", "（ＩＲ）年金受取人名");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari1(), BizNumber.valueOf(230), "（ＩＲ）死亡受取人分割割合１");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari2(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合２");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari3(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合３");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari4(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合４");
        exClassificationEquals(khSeikyuusyoBean.getIrTargettkhnkkbn(), C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU, "（ＩＲ）ターゲット特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKaiyakujiyuu(), C_Kaiyakujiyuu.TUUJYOU, "（ＩＲ）解約事由");
        exClassificationEquals(khSeikyuusyoBean.getIrGengkhoukbn(), C_GengkhouKbn.SD, "（ＩＲ）減額方法区分");
        exNumericEquals(khSeikyuusyoBean.getIrSbuktnin(), 2, "（ＩＲ）死亡受取人人数");
        exClassificationEquals(khSeikyuusyoBean.getIrSbuuktkbn(), C_UktKbn.BLNK, "（ＩＲ）死亡受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrYenshrtkumu(), C_UmuKbn.ARI, "（ＩＲ）円支払特約有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHenkankinumukbn(), C_UmuKbn.ARI, "（ＩＲ）返還金有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrRstuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）領収通貨種類");
        exClassificationEquals(khSeikyuusyoBean.getIrNkshrtkykhnkkbn(), C_NstkhKbn.NAIYOUHENKOU, "（ＩＲ）年金支払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrMeigihnkjiyuu(), C_Meigihnkjiyuu.KYK, "（ＩＲ）名義変更事由");
        exClassificationEquals(khSeikyuusyoBean.getIrNkhknumu(), C_UmuKbn.ARI, "（ＩＲ）年金保険有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSiboukyhkuktumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡給付金受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn1(), C_UmuKbn.ARI, "（ＩＲ）死亡保険金受取人有無区分１");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn2(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分２");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn3(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分３");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn4(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分４");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu1(), C_UmuKbn.ARI, "（ＩＲ）死亡受取人分割割合有無１");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu2(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無２");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu3(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無３");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu4(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無４");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyhukaumu(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyuuktmukbn(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrStdruktkbn(), C_UktKbn.HHKN, "（ＩＲ）指定代理受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrJyudkaigomaebrtkykhnkkbn(),C_JyudkaigomaebaraiTkykhnkKbn.BLNK, "（ＩＲ）重度介護前払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKeihikbn(),C_KeihiKbn.BLNK,"（ＩＲ）契被区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKihonshenkouumu(),C_UmuKbn.NONE,"（ＩＲ）基本Ｓ変更有無");
        exStringEquals(khSeikyuusyoBean.getIrKihonssyurui(), "基本保険金額", "（ＩＲ）基本Ｓ種類");
        exClassificationEquals(khSeikyuusyoBean.getIrTmttknitenkbn(), C_Tmttknitenkbn.BLNK, "（ＩＲ）積立金移転区分");
        exStringEquals(khSeikyuusyoBean.getIrTmttknitenymd(), null, "（ＩＲ）積立金移転日");
        exClassificationEquals(khSeikyuusyoBean.getIrKhhrshrjiyuu(), C_Khhrshrjiyuu.BLNK, "（ＩＲ）契約保全返戻金支払事由");
        exClassificationEquals(khSeikyuusyoBean.getIrKhskssakuseijiyuu(), C_Khskssakuseijiyuu.BLNK, "（ＩＲ）契約保全請求書作成事由");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkijyunkingaku(), BizCurrency.valueOf(100000), "（ＩＲ）基準金額（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrHrkkeiro(), C_Hrkkeiro.DANTAI, "（ＩＲ）払込経路");
        exNumericEquals(khSeikyuusyoBean.getIrSyouhnhanteikekka(), 999, "（ＩＲ）商品判定結果");
        exClassificationEquals(khSeikyuusyoBean.getIrKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "（ＩＲ）契約状態");
        exClassificationEquals(khSeikyuusyoBean.getIrZeiseitkkktkykhukaumu(), C_UmuKbn.ARI, "（ＩＲ）税制適格特約付加有無");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn1(), "", "（ＩＲ）登録家族氏名（カナ）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj1(), "", "（ＩＲ）登録家族氏名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj1(), "", "（ＩＲ）登録家族住所１（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj1(), "", "（ＩＲ）登録家族住所２（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj1(), "", "（ＩＲ）登録家族住所３（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno1(), "", "（ＩＲ）登録家族電話番号１");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi1(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn2(), "", "（ＩＲ）登録家族氏名（カナ）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj2(), "", "（ＩＲ）登録家族氏名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj2(), "", "（ＩＲ）登録家族住所１（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj2(), "", "（ＩＲ）登録家族住所２（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj2(), "", "（ＩＲ）登録家族住所３（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno2(), "", "（ＩＲ）登録家族電話番号２");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi2(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否２");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkn(), "契約者名（カナ）", "（ＩＲ）契約者名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKykdairinmkj(), "", "（ＩＲ）契約者代理人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrtkykhukaumu(), null, "（ＩＲ）契約者代理特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrMousideninkbn(), C_MousideninKbn.BLNK, "（ＩＲ）申出人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrknhatudoujyoutai(), C_KykdrknHtdjytKbn.BLNK, "（ＩＲ）契約者代理権発動状態");
        exStringEquals(khSeikyuusyoBean.getIrDrstiskkyknmkj(), "契約者名", "（ＩＲ）代理人指定先契約者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTyouhyoutitle(), null, "（ＩＲ）帳票タイトル");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg1(), null, "（ＩＲ）送付案内メッセージ１");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg2(), null, "（ＩＲ）送付案内メッセージ２");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg3(), null, "（ＩＲ）送付案内メッセージ３");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg4(), null, "（ＩＲ）送付案内メッセージ４");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg5(), null, "（ＩＲ）送付案内メッセージ５");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg6(), null, "（ＩＲ）送付案内メッセージ６");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg7(), null, "（ＩＲ）送付案内メッセージ７");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg8(), null, "（ＩＲ）送付案内メッセージ８");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg9(), null, "（ＩＲ）送付案内メッセージ９");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg10(), null, "（ＩＲ）送付案内メッセージ１０");

        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean)kSBean[1];

        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(), null, "（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(), "userId001", "（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(), "user001", "（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(), DateFormatUtil.dateKANJI(BizDate.getSysDate()), "（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(), "3 年", "（ＩＲ）保存期間");
    }

    @Test
    @TestOrder(120)
    public void testEditBean_A12() {

        MockObjectManager.initialize();

        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;

        AM_User aMUser = new AM_User();

        aMUser.setUserId("userId001");
        aMUser.setUserNm("user001");
        changeCurrentUser(baseUserInfo, aMUser);

        editSeikyuusyoParam.setHhknseiymd(BizDate.valueOf(20151026));
        editSeikyuusyoParam.setHhknseiymdhenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setHhknsei(C_Hhknsei.MALE);
        editSeikyuusyoParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setBfrTargettkmokuhyouti(BizNumber.valueOf(101));
        editSeikyuusyoParam.setBfrKihonS(BizCurrency.valueOf(778));
        editSeikyuusyoParam.setBfrP(BizCurrency.valueOf(1566));
        editSeikyuusyoParam.setBfrTokuyakuNenkinsyuKbn(C_Nstknsyu.KAKUTEINENKIN);
        editSeikyuusyoParam.setBfrNkshrtkyknksyukkn(5);
        editSeikyuusyoParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU);
        editSeikyuusyoParam.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editSeikyuusyoParam.setGengkhouKbn(C_GengkhouKbn.SD);
        editSeikyuusyoParam.setHenkankumukbn(C_UmuKbn.ARI);
        editSeikyuusyoParam.setRstuukasyu(C_Tuukasyu.JPY);
        editSeikyuusyoParam.setNkshrtkykhnkkbn(C_NstkhKbn.NAIYOUHENKOU);
        editSeikyuusyoParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);
        editSeikyuusyoParam.setJyudkaigomaebaraiTkykhnkKbn(C_JyudkaigomaebaraiTkykhnkKbn.BLNK);
        editSeikyuusyoParam.setKihonshenkouumu(C_UmuKbn.NONE);
        editSeikyuusyoParam.setTmttknitenkbn(C_Tmttknitenkbn.BLNK);
        editSeikyuusyoParam.setTmttknitenymd(null);
        editSeikyuusyoParam.setKhhrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSeikyuusyoParam.setKhskssakuseijiyuu(C_Khskssakuseijiyuu.BLNK);
        editSeikyuusyoParam.setHenkougokjnkngk(BizCurrency.valueOf(100000));

        ReportServicesBean reSsBean =  editSeikyuusyoTbl.editBean(C_SyoruiCdKbn.KK_MEIGIHNK_SKS, syono17, khozenCommonParam, editSeikyuusyoParam);

        Object[] kSBean = reSsBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_MEIGIHNK_SKS.getValue());

        exNumericEquals(kSBean.length, 2, "パラメータオブジェクトの要素数");

        exNumericEquals(reSsBean.getKensakuKeys().length, 1, "検索キー配列の要素数");
        exStringEquals(reSsBean.getKensakuKeys()[0], "12806345834", "検索キー");

        KhSeikyuusyoBean khSeikyuusyoBean = (KhSeikyuusyoBean)kSBean[0];

        exStringEquals(khSeikyuusyoBean.getIrSyono(), "12806345834", "（ＩＲ）証券番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinyno(), "1234567", "（ＩＲ）通信先郵便番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr1kj(), "通信先住所１", "（ＩＲ）通信先住所１（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr2kj(), "通信先住所２", "（ＩＲ）通信先住所２（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr3kj(), "通信先住所３", "（ＩＲ）通信先住所３（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsintelno(), "023-5677-8999", "（ＩＲ）通信先電話番号");
        exStringEquals(khSeikyuusyoBean.getIrBanknmkj(), "", "（ＩＲ）銀行名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrSitennmkj(), "", "（ＩＲ）支店名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrBankcd(), "", "（ＩＲ）銀行コード");
        exStringEquals(khSeikyuusyoBean.getIrSitencd(), "", "（ＩＲ）支店コード");

        exStringEquals(khSeikyuusyoBean.getIrKzmeiginmkn(), "", "（ＩＲ）口座名義人氏名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkj(), "契約者名", "（ＩＲ）契約者名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKkkyktdk(), C_Tdk.HGU, "（ＩＲ）契約管理契約者続柄");
        exStringEquals(khSeikyuusyoBean.getIrHhknnmkj(), "被保険者名", "（ＩＲ）被保険者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrHhknseiymd(), "", "（ＩＲ）被保険者生年月日");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseiymdhenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者生年月日変更有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknsei(), C_Hhknsei.MALE, "（ＩＲ）被保険者性別");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseihenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者性別変更有無");
        exStringEquals(khSeikyuusyoBean.getIrStdrsknmkj(), "小野", "（ＩＲ）指定代理請求人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrFatcakakuninyhkbn(), C_YouhiblnkKbn.HUYOU, "（ＩＲ）FATCA確認要否区分");
        exClassificationEquals(khSeikyuusyoBean.getIrAeoikakuninyhkbn(), C_YouhiblnkKbn.YOU, "（ＩＲ）ＡＥＯＩ確認要否区分");

        exClassificationEquals(khSeikyuusyoBean.getIrTargettkkbn(), C_TargetTkKbn.BLNK, "（ＩＲ）ターゲット特約区分");
        exNumericEquals(khSeikyuusyoBean.getIrAftertargettkmokuhyouti(), 101, "（ＩＲ）変更後ターゲット特約目標値");
        exNumericEquals(khSeikyuusyoBean.getIrBeforetargettkmokuhyouti(), 200, "（ＩＲ）変更前ターゲット特約目標値");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforekihons(), BizCurrency.valueOf(100), "（ＩＲ）基本保険金額（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkihons(),  BizCurrency.valueOf(778), "（ＩＲ）基本保険金額（変更後）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforep(), BizCurrency.valueOf(200), "（ＩＲ）保険料（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterp(), BizCurrency.valueOf(1566), "（ＩＲ）保険料（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrKyktuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）契約通貨種類");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj1(), "小野", "（ＩＲ）死亡受取人名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj2(), "", "（ＩＲ）死亡受取人名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj3(), "", "（ＩＲ）死亡受取人名（漢字）３");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj4(), "", "（ＩＲ）死亡受取人名（漢字）４");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkn(), "受取人名（カナ）", "（ＩＲ）死亡受取人名（カナ）");
        exClassificationEquals(khSeikyuusyoBean.getIrYokinkbn(), C_YokinKbn.BLNK, "（ＩＲ）預金種目区分");
        exStringEquals(khSeikyuusyoBean.getIrKouzano(), "", "（ＩＲ）口座番号");

        exClassificationEquals(khSeikyuusyoBean.getIrAfternkshrtkyknksyukbn(), C_Nstknsyu.KAKUTEINENKIN, "（ＩＲ）変更後年金支払特約年金種類区分");
        exClassificationEquals(khSeikyuusyoBean.getIrBiforenkshrtkyknksyukbn(), C_Nstknsyu.BLNK, "（ＩＲ）変更前年金支払特約年金種類区分");
        exNumericEquals(khSeikyuusyoBean.getIrAfternkshrtkyknkkkn(), 5, "（ＩＲ）変更後年金支払特約年金期間");
        exNumericEquals(khSeikyuusyoBean.getIrBeforenkshrtkyknkkkn(), 10, "（ＩＲ）変更前年金支払特約年金期間");
        exStringEquals(khSeikyuusyoBean.getIrNkuktnm(), "被保険者名", "（ＩＲ）年金受取人名");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari1(), BizNumber.valueOf(230), "（ＩＲ）死亡受取人分割割合１");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari2(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合２");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari3(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合３");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari4(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合４");
        exClassificationEquals(khSeikyuusyoBean.getIrTargettkhnkkbn(), C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU, "（ＩＲ）ターゲット特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKaiyakujiyuu(), C_Kaiyakujiyuu.TUUJYOU, "（ＩＲ）解約事由");
        exClassificationEquals(khSeikyuusyoBean.getIrGengkhoukbn(), C_GengkhouKbn.SD, "（ＩＲ）減額方法区分");
        exNumericEquals(khSeikyuusyoBean.getIrSbuktnin(), 2, "（ＩＲ）死亡受取人人数");
        exClassificationEquals(khSeikyuusyoBean.getIrSbuuktkbn(), C_UktKbn.BLNK, "（ＩＲ）死亡受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrYenshrtkumu(), C_UmuKbn.ARI, "（ＩＲ）円支払特約有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHenkankinumukbn(), C_UmuKbn.ARI, "（ＩＲ）返還金有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrRstuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）領収通貨種類");
        exClassificationEquals(khSeikyuusyoBean.getIrNkshrtkykhnkkbn(), C_NstkhKbn.NAIYOUHENKOU, "（ＩＲ）年金支払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrMeigihnkjiyuu(), C_Meigihnkjiyuu.KYK, "（ＩＲ）名義変更事由");
        exClassificationEquals(khSeikyuusyoBean.getIrNkhknumu(), C_UmuKbn.ARI, "（ＩＲ）年金保険有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSiboukyhkuktumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡給付金受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn1(), C_UmuKbn.ARI, "（ＩＲ）死亡保険金受取人有無区分１");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn2(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分２");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn3(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分３");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn4(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分４");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu1(), C_UmuKbn.ARI, "（ＩＲ）死亡受取人分割割合有無１");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu2(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無２");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu3(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無３");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu4(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無４");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyhukaumu(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyuuktmukbn(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrStdruktkbn(), C_UktKbn.SBUK, "（ＩＲ）指定代理受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrJyudkaigomaebrtkykhnkkbn(),C_JyudkaigomaebaraiTkykhnkKbn.BLNK, "（ＩＲ）重度介護前払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKeihikbn(),C_KeihiKbn.BLNK,"（ＩＲ）契被区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKihonshenkouumu(),C_UmuKbn.NONE,"（ＩＲ）基本Ｓ変更有無");
        exStringEquals(khSeikyuusyoBean.getIrKihonssyurui(), "基本保険金額", "（ＩＲ）基本Ｓ種類");
        exClassificationEquals(khSeikyuusyoBean.getIrTmttknitenkbn(), C_Tmttknitenkbn.BLNK, "（ＩＲ）積立金移転区分");
        exStringEquals(khSeikyuusyoBean.getIrTmttknitenymd(), null, "（ＩＲ）積立金移転日");
        exClassificationEquals(khSeikyuusyoBean.getIrKhhrshrjiyuu(), C_Khhrshrjiyuu.BLNK, "（ＩＲ）契約保全返戻金支払事由");
        exClassificationEquals(khSeikyuusyoBean.getIrKhskssakuseijiyuu(), C_Khskssakuseijiyuu.BLNK, "（ＩＲ）契約保全請求書作成事由");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkijyunkingaku(), BizCurrency.valueOf(100000), "（ＩＲ）基準金額（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrHrkkeiro(), C_Hrkkeiro.DANTAI, "（ＩＲ）払込経路");
        exNumericEquals(khSeikyuusyoBean.getIrSyouhnhanteikekka(), 999, "（ＩＲ）商品判定結果");
        exClassificationEquals(khSeikyuusyoBean.getIrKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "（ＩＲ）契約状態");
        exClassificationEquals(khSeikyuusyoBean.getIrZeiseitkkktkykhukaumu(), C_UmuKbn.ARI, "（ＩＲ）税制適格特約付加有無");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn1(), "", "（ＩＲ）登録家族氏名（カナ）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj1(), "", "（ＩＲ）登録家族氏名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj1(), "", "（ＩＲ）登録家族住所１（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj1(), "", "（ＩＲ）登録家族住所２（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj1(), "", "（ＩＲ）登録家族住所３（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno1(), "", "（ＩＲ）登録家族電話番号１");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi1(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn2(), "", "（ＩＲ）登録家族氏名（カナ）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj2(), "", "（ＩＲ）登録家族氏名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj2(), "", "（ＩＲ）登録家族住所１（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj2(), "", "（ＩＲ）登録家族住所２（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj2(), "", "（ＩＲ）登録家族住所３（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno2(), "", "（ＩＲ）登録家族電話番号２");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi2(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否２");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkn(), "契約者名（カナ）", "（ＩＲ）契約者名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKykdairinmkj(), "", "（ＩＲ）契約者代理人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrtkykhukaumu(), null, "（ＩＲ）契約者代理特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrMousideninkbn(), C_MousideninKbn.BLNK, "（ＩＲ）申出人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrknhatudoujyoutai(), C_KykdrknHtdjytKbn.BLNK, "（ＩＲ）契約者代理権発動状態");
        exStringEquals(khSeikyuusyoBean.getIrDrstiskkyknmkj(), "契約者名", "（ＩＲ）代理人指定先契約者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTyouhyoutitle(), null, "（ＩＲ）帳票タイトル");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg1(), null, "（ＩＲ）送付案内メッセージ１");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg2(), null, "（ＩＲ）送付案内メッセージ２");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg3(), null, "（ＩＲ）送付案内メッセージ３");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg4(), null, "（ＩＲ）送付案内メッセージ４");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg5(), null, "（ＩＲ）送付案内メッセージ５");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg6(), null, "（ＩＲ）送付案内メッセージ６");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg7(), null, "（ＩＲ）送付案内メッセージ７");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg8(), null, "（ＩＲ）送付案内メッセージ８");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg9(), null, "（ＩＲ）送付案内メッセージ９");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg10(), null, "（ＩＲ）送付案内メッセージ１０");

        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean)kSBean[1];

        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(), null, "（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(), "userId001", "（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(), "user001", "（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(), DateFormatUtil.dateKANJI(BizDate.getSysDate()), "（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(), "3 年", "（ＩＲ）保存期間");
    }

    @Test
    @TestOrder(130)
    public void testEditBean_A13() {

        MockObjectManager.initialize();

        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;

        AM_User aMUser = new AM_User();

        aMUser.setUserId("userId001");
        aMUser.setUserNm("user001");
        changeCurrentUser(baseUserInfo, aMUser);

        editSeikyuusyoParam.setHhknseiymd(BizDate.valueOf(20151026));
        editSeikyuusyoParam.setHhknseiymdhenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setHhknsei(C_Hhknsei.MALE);
        editSeikyuusyoParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setBfrTargettkmokuhyouti(BizNumber.valueOf(101));
        editSeikyuusyoParam.setBfrKihonS(BizCurrency.valueOf(778));
        editSeikyuusyoParam.setBfrP(BizCurrency.valueOf(1566));
        editSeikyuusyoParam.setBfrTokuyakuNenkinsyuKbn(C_Nstknsyu.KAKUTEINENKIN);
        editSeikyuusyoParam.setBfrNkshrtkyknksyukkn(5);
        editSeikyuusyoParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU);
        editSeikyuusyoParam.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editSeikyuusyoParam.setGengkhouKbn(C_GengkhouKbn.SD);
        editSeikyuusyoParam.setHenkankumukbn(C_UmuKbn.ARI);
        editSeikyuusyoParam.setRstuukasyu(C_Tuukasyu.JPY);
        editSeikyuusyoParam.setNkshrtkykhnkkbn(C_NstkhKbn.NAIYOUHENKOU);
        editSeikyuusyoParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);
        editSeikyuusyoParam.setJyudkaigomaebaraiTkykhnkKbn(C_JyudkaigomaebaraiTkykhnkKbn.BLNK);
        editSeikyuusyoParam.setKihonshenkouumu(C_UmuKbn.NONE);
        editSeikyuusyoParam.setTmttknitenkbn(C_Tmttknitenkbn.BLNK);
        editSeikyuusyoParam.setTmttknitenymd(null);
        editSeikyuusyoParam.setKhhrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSeikyuusyoParam.setKhskssakuseijiyuu(C_Khskssakuseijiyuu.BLNK);
        editSeikyuusyoParam.setHenkougokjnkngk(BizCurrency.valueOf(100000));

        ReportServicesBean reSsBean =  editSeikyuusyoTbl.editBean(C_SyoruiCdKbn.KK_MEIGIHNK_SKS, syono11, khozenCommonParam, editSeikyuusyoParam);

        Object[] kSBean = reSsBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_MEIGIHNK_SKS.getValue());

        exNumericEquals(kSBean.length, 2, "パラメータオブジェクトの要素数");

        exNumericEquals(reSsBean.getKensakuKeys().length, 1, "検索キー配列の要素数");
        exStringEquals(reSsBean.getKensakuKeys()[0], "12806345775", "検索キー");

        KhSeikyuusyoBean khSeikyuusyoBean = (KhSeikyuusyoBean)kSBean[0];

        exStringEquals(khSeikyuusyoBean.getIrSyono(), "12806345775", "（ＩＲ）証券番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinyno(), "1234567", "（ＩＲ）通信先郵便番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr1kj(), "通信先住所１", "（ＩＲ）通信先住所１（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr2kj(), "通信先住所２", "（ＩＲ）通信先住所２（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr3kj(), "通信先住所３", "（ＩＲ）通信先住所３（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsintelno(), "023-5677-8999", "（ＩＲ）通信先電話番号");
        exStringEquals(khSeikyuusyoBean.getIrBanknmkj(), "", "（ＩＲ）銀行名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrSitennmkj(), "", "（ＩＲ）支店名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrBankcd(), "", "（ＩＲ）銀行コード");
        exStringEquals(khSeikyuusyoBean.getIrSitencd(), "", "（ＩＲ）支店コード");

        exStringEquals(khSeikyuusyoBean.getIrKzmeiginmkn(), "", "（ＩＲ）口座名義人氏名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkj(), "契約者名", "（ＩＲ）契約者名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKkkyktdk(), C_Tdk.HGU, "（ＩＲ）契約管理契約者続柄");
        exStringEquals(khSeikyuusyoBean.getIrHhknnmkj(), "被保険者名", "（ＩＲ）被保険者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrHhknseiymd(), "", "（ＩＲ）被保険者生年月日");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseiymdhenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者生年月日変更有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknsei(), C_Hhknsei.MALE, "（ＩＲ）被保険者性別");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseihenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者性別変更有無");
        exStringEquals(khSeikyuusyoBean.getIrStdrsknmkj(), "", "（ＩＲ）指定代理請求人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrFatcakakuninyhkbn(), C_YouhiblnkKbn.HUYOU, "（ＩＲ）FATCA確認要否区分");
        exClassificationEquals(khSeikyuusyoBean.getIrAeoikakuninyhkbn(), C_YouhiblnkKbn.YOU, "（ＩＲ）ＡＥＯＩ確認要否区分");

        exClassificationEquals(khSeikyuusyoBean.getIrTargettkkbn(), C_TargetTkKbn.BLNK, "（ＩＲ）ターゲット特約区分");
        exNumericEquals(khSeikyuusyoBean.getIrAftertargettkmokuhyouti(), 101, "（ＩＲ）変更後ターゲット特約目標値");
        exNumericEquals(khSeikyuusyoBean.getIrBeforetargettkmokuhyouti(), 200, "（ＩＲ）変更前ターゲット特約目標値");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforekihons(), BizCurrency.valueOf(100), "（ＩＲ）基本保険金額（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkihons(),  BizCurrency.valueOf(778), "（ＩＲ）基本保険金額（変更後）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforep(), BizCurrency.valueOf(200), "（ＩＲ）保険料（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterp(), BizCurrency.valueOf(1566), "（ＩＲ）保険料（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrKyktuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）契約通貨種類");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj1(), "小野", "（ＩＲ）死亡受取人名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj2(), "", "（ＩＲ）死亡受取人名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj3(), "", "（ＩＲ）死亡受取人名（漢字）３");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj4(), "", "（ＩＲ）死亡受取人名（漢字）４");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkn(), "受取人名（カナ）", "（ＩＲ）死亡受取人名（カナ）");
        exClassificationEquals(khSeikyuusyoBean.getIrYokinkbn(), C_YokinKbn.BLNK, "（ＩＲ）預金種目区分");
        exStringEquals(khSeikyuusyoBean.getIrKouzano(), "", "（ＩＲ）口座番号");

        exClassificationEquals(khSeikyuusyoBean.getIrAfternkshrtkyknksyukbn(), C_Nstknsyu.KAKUTEINENKIN, "（ＩＲ）変更後年金支払特約年金種類区分");
        exClassificationEquals(khSeikyuusyoBean.getIrBiforenkshrtkyknksyukbn(), C_Nstknsyu.BLNK, "（ＩＲ）変更前年金支払特約年金種類区分");
        exNumericEquals(khSeikyuusyoBean.getIrAfternkshrtkyknkkkn(), 5, "（ＩＲ）変更後年金支払特約年金期間");
        exNumericEquals(khSeikyuusyoBean.getIrBeforenkshrtkyknkkkn(), 10, "（ＩＲ）変更前年金支払特約年金期間");
        exStringEquals(khSeikyuusyoBean.getIrNkuktnm(), "", "（ＩＲ）年金受取人名");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari1(), BizNumber.valueOf(230), "（ＩＲ）死亡受取人分割割合１");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari2(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合２");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari3(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合３");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari4(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合４");
        exClassificationEquals(khSeikyuusyoBean.getIrTargettkhnkkbn(), C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU, "（ＩＲ）ターゲット特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKaiyakujiyuu(), C_Kaiyakujiyuu.TUUJYOU, "（ＩＲ）解約事由");
        exClassificationEquals(khSeikyuusyoBean.getIrGengkhoukbn(), C_GengkhouKbn.SD, "（ＩＲ）減額方法区分");
        exNumericEquals(khSeikyuusyoBean.getIrSbuktnin(), 2, "（ＩＲ）死亡受取人人数");
        exClassificationEquals(khSeikyuusyoBean.getIrSbuuktkbn(), C_UktKbn.BLNK, "（ＩＲ）死亡受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrYenshrtkumu(), C_UmuKbn.ARI, "（ＩＲ）円支払特約有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHenkankinumukbn(), C_UmuKbn.ARI, "（ＩＲ）返還金有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrRstuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）領収通貨種類");
        exClassificationEquals(khSeikyuusyoBean.getIrNkshrtkykhnkkbn(), C_NstkhKbn.NAIYOUHENKOU, "（ＩＲ）年金支払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrMeigihnkjiyuu(), C_Meigihnkjiyuu.KYK, "（ＩＲ）名義変更事由");
        exClassificationEquals(khSeikyuusyoBean.getIrNkhknumu(), C_UmuKbn.ARI, "（ＩＲ）年金保険有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSiboukyhkuktumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡給付金受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn1(), C_UmuKbn.ARI, "（ＩＲ）死亡保険金受取人有無区分１");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn2(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分２");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn3(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分３");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn4(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分４");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu1(), C_UmuKbn.ARI, "（ＩＲ）死亡受取人分割割合有無１");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu2(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無２");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu3(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無３");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu4(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無４");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyhukaumu(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyuuktmukbn(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrStdruktkbn(), C_UktKbn.BLNK, "（ＩＲ）指定代理受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrJyudkaigomaebrtkykhnkkbn(),C_JyudkaigomaebaraiTkykhnkKbn.BLNK, "（ＩＲ）重度介護前払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKeihikbn(),C_KeihiKbn.BLNK,"（ＩＲ）契被区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKihonshenkouumu(),C_UmuKbn.NONE,"（ＩＲ）基本Ｓ変更有無");
        exStringEquals(khSeikyuusyoBean.getIrKihonssyurui(), "基本保険金額", "（ＩＲ）基本Ｓ種類");
        exClassificationEquals(khSeikyuusyoBean.getIrTmttknitenkbn(), C_Tmttknitenkbn.BLNK, "（ＩＲ）積立金移転区分");
        exStringEquals(khSeikyuusyoBean.getIrTmttknitenymd(), null, "（ＩＲ）積立金移転日");
        exClassificationEquals(khSeikyuusyoBean.getIrKhhrshrjiyuu(), C_Khhrshrjiyuu.BLNK, "（ＩＲ）契約保全返戻金支払事由");
        exClassificationEquals(khSeikyuusyoBean.getIrKhskssakuseijiyuu(), C_Khskssakuseijiyuu.BLNK, "（ＩＲ）契約保全請求書作成事由");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkijyunkingaku(), BizCurrency.valueOf(100000), "（ＩＲ）基準金額（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrHrkkeiro(), C_Hrkkeiro.DANTAI, "（ＩＲ）払込経路");
        exNumericEquals(khSeikyuusyoBean.getIrSyouhnhanteikekka(), 999, "（ＩＲ）商品判定結果");
        exClassificationEquals(khSeikyuusyoBean.getIrKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "（ＩＲ）契約状態");
        exClassificationEquals(khSeikyuusyoBean.getIrZeiseitkkktkykhukaumu(), C_UmuKbn.ARI, "（ＩＲ）税制適格特約付加有無");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn1(), "", "（ＩＲ）登録家族氏名（カナ）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj1(), "", "（ＩＲ）登録家族氏名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj1(), "", "（ＩＲ）登録家族住所１（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj1(), "", "（ＩＲ）登録家族住所２（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj1(), "", "（ＩＲ）登録家族住所３（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno1(), "", "（ＩＲ）登録家族電話番号１");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi1(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn2(), "", "（ＩＲ）登録家族氏名（カナ）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj2(), "", "（ＩＲ）登録家族氏名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj2(), "", "（ＩＲ）登録家族住所１（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj2(), "", "（ＩＲ）登録家族住所２（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj2(), "", "（ＩＲ）登録家族住所３（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno2(), "", "（ＩＲ）登録家族電話番号２");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi2(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否２");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkn(), "契約者名（カナ）", "（ＩＲ）契約者名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKykdairinmkj(), "", "（ＩＲ）契約者代理人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrtkykhukaumu(), null, "（ＩＲ）契約者代理特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrMousideninkbn(), C_MousideninKbn.BLNK, "（ＩＲ）申出人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrknhatudoujyoutai(), C_KykdrknHtdjytKbn.BLNK, "（ＩＲ）契約者代理権発動状態");
        exStringEquals(khSeikyuusyoBean.getIrDrstiskkyknmkj(), "契約者名", "（ＩＲ）代理人指定先契約者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTyouhyoutitle(), null, "（ＩＲ）帳票タイトル");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg1(), null, "（ＩＲ）送付案内メッセージ１");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg2(), null, "（ＩＲ）送付案内メッセージ２");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg3(), null, "（ＩＲ）送付案内メッセージ３");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg4(), null, "（ＩＲ）送付案内メッセージ４");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg5(), null, "（ＩＲ）送付案内メッセージ５");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg6(), null, "（ＩＲ）送付案内メッセージ６");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg7(), null, "（ＩＲ）送付案内メッセージ７");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg8(), null, "（ＩＲ）送付案内メッセージ８");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg9(), null, "（ＩＲ）送付案内メッセージ９");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg10(), null, "（ＩＲ）送付案内メッセージ１０");

        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean)kSBean[1];

        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(), null, "（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(), "userId001", "（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(), "user001", "（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(), DateFormatUtil.dateKANJI(BizDate.getSysDate()), "（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(), "3 年", "（ＩＲ）保存期間");
    }

    @Test
    @TestOrder(140)
    public void testEditBean_A14() {

        MockObjectManager.initialize();

        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;

        AM_User aMUser = new AM_User();

        aMUser.setUserId("userId001");
        aMUser.setUserNm("user001");
        changeCurrentUser(baseUserInfo, aMUser);

        editSeikyuusyoParam.setHhknseiymd(BizDate.valueOf(20151026));
        editSeikyuusyoParam.setHhknseiymdhenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setHhknsei(C_Hhknsei.MALE);
        editSeikyuusyoParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setBfrTargettkmokuhyouti(BizNumber.valueOf(101));
        editSeikyuusyoParam.setBfrKihonS(BizCurrency.valueOf(778));
        editSeikyuusyoParam.setBfrP(BizCurrency.valueOf(1566));
        editSeikyuusyoParam.setBfrTokuyakuNenkinsyuKbn(C_Nstknsyu.KAKUTEINENKIN);
        editSeikyuusyoParam.setBfrNkshrtkyknksyukkn(5);
        editSeikyuusyoParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU);
        editSeikyuusyoParam.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editSeikyuusyoParam.setGengkhouKbn(C_GengkhouKbn.SD);
        editSeikyuusyoParam.setHenkankumukbn(C_UmuKbn.ARI);
        editSeikyuusyoParam.setRstuukasyu(C_Tuukasyu.JPY);
        editSeikyuusyoParam.setNkshrtkykhnkkbn(C_NstkhKbn.NAIYOUHENKOU);
        editSeikyuusyoParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);
        editSeikyuusyoParam.setJyudkaigomaebaraiTkykhnkKbn(C_JyudkaigomaebaraiTkykhnkKbn.BLNK);
        editSeikyuusyoParam.setKihonshenkouumu(C_UmuKbn.NONE);
        editSeikyuusyoParam.setTmttknitenkbn(C_Tmttknitenkbn.BLNK);
        editSeikyuusyoParam.setTmttknitenymd(null);
        editSeikyuusyoParam.setKhhrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSeikyuusyoParam.setKhskssakuseijiyuu(C_Khskssakuseijiyuu.BLNK);
        editSeikyuusyoParam.setHenkougokjnkngk(BizCurrency.valueOf(100000));

        ReportServicesBean reSsBean =  editSeikyuusyoTbl.editBean(C_SyoruiCdKbn.KK_MEIGIHNK_SKS, syono12, khozenCommonParam, editSeikyuusyoParam);

        Object[] kSBean = reSsBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_MEIGIHNK_SKS.getValue());

        exNumericEquals(kSBean.length, 2, "パラメータオブジェクトの要素数");

        exNumericEquals(reSsBean.getKensakuKeys().length, 1, "検索キー配列の要素数");
        exStringEquals(reSsBean.getKensakuKeys()[0], "12806345786", "検索キー");

        KhSeikyuusyoBean khSeikyuusyoBean = (KhSeikyuusyoBean)kSBean[0];

        exStringEquals(khSeikyuusyoBean.getIrSyono(), "12806345786", "（ＩＲ）証券番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinyno(), "1234567", "（ＩＲ）通信先郵便番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr1kj(), "通信先住所１", "（ＩＲ）通信先住所１（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr2kj(), "通信先住所２", "（ＩＲ）通信先住所２（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr3kj(), "通信先住所３", "（ＩＲ）通信先住所３（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsintelno(), "023-5677-8999", "（ＩＲ）通信先電話番号");
        exStringEquals(khSeikyuusyoBean.getIrBanknmkj(), "", "（ＩＲ）銀行名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrSitennmkj(), "", "（ＩＲ）支店名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrBankcd(), "", "（ＩＲ）銀行コード");
        exStringEquals(khSeikyuusyoBean.getIrSitencd(), "", "（ＩＲ）支店コード");

        exStringEquals(khSeikyuusyoBean.getIrKzmeiginmkn(), "", "（ＩＲ）口座名義人氏名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkj(), "契約者名", "（ＩＲ）契約者名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKkkyktdk(), C_Tdk.HGU, "（ＩＲ）契約管理契約者続柄");
        exStringEquals(khSeikyuusyoBean.getIrHhknnmkj(), "被保険者名", "（ＩＲ）被保険者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrHhknseiymd(), "", "（ＩＲ）被保険者生年月日");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseiymdhenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者生年月日変更有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknsei(), C_Hhknsei.MALE, "（ＩＲ）被保険者性別");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseihenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者性別変更有無");
        exStringEquals(khSeikyuusyoBean.getIrStdrsknmkj(), "長島", "（ＩＲ）指定代理請求人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrFatcakakuninyhkbn(), C_YouhiblnkKbn.HUYOU, "（ＩＲ）FATCA確認要否区分");
        exClassificationEquals(khSeikyuusyoBean.getIrAeoikakuninyhkbn(), C_YouhiblnkKbn.YOU, "（ＩＲ）ＡＥＯＩ確認要否区分");

        exClassificationEquals(khSeikyuusyoBean.getIrTargettkkbn(), C_TargetTkKbn.BLNK, "（ＩＲ）ターゲット特約区分");
        exNumericEquals(khSeikyuusyoBean.getIrAftertargettkmokuhyouti(), 101, "（ＩＲ）変更後ターゲット特約目標値");
        exNumericEquals(khSeikyuusyoBean.getIrBeforetargettkmokuhyouti(), 200, "（ＩＲ）変更前ターゲット特約目標値");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforekihons(), BizCurrency.valueOf(100), "（ＩＲ）基本保険金額（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkihons(),  BizCurrency.valueOf(778), "（ＩＲ）基本保険金額（変更後）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforep(), BizCurrency.valueOf(200), "（ＩＲ）保険料（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterp(), BizCurrency.valueOf(1566), "（ＩＲ）保険料（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrKyktuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）契約通貨種類");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj1(), "小野", "（ＩＲ）死亡受取人名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj2(), "", "（ＩＲ）死亡受取人名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj3(), "", "（ＩＲ）死亡受取人名（漢字）３");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj4(), "", "（ＩＲ）死亡受取人名（漢字）４");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkn(), "受取人名（カナ）", "（ＩＲ）死亡受取人名（カナ）");
        exClassificationEquals(khSeikyuusyoBean.getIrYokinkbn(), C_YokinKbn.BLNK, "（ＩＲ）預金種目区分");
        exStringEquals(khSeikyuusyoBean.getIrKouzano(), "", "（ＩＲ）口座番号");

        exClassificationEquals(khSeikyuusyoBean.getIrAfternkshrtkyknksyukbn(), C_Nstknsyu.KAKUTEINENKIN, "（ＩＲ）変更後年金支払特約年金種類区分");
        exClassificationEquals(khSeikyuusyoBean.getIrBiforenkshrtkyknksyukbn(), C_Nstknsyu.BLNK, "（ＩＲ）変更前年金支払特約年金種類区分");
        exNumericEquals(khSeikyuusyoBean.getIrAfternkshrtkyknkkkn(), 5, "（ＩＲ）変更後年金支払特約年金期間");
        exNumericEquals(khSeikyuusyoBean.getIrBeforenkshrtkyknkkkn(), 10, "（ＩＲ）変更前年金支払特約年金期間");
        exStringEquals(khSeikyuusyoBean.getIrNkuktnm(), "森君", "（ＩＲ）年金受取人名");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari1(), BizNumber.valueOf(230), "（ＩＲ）死亡受取人分割割合１");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari2(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合２");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari3(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合３");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari4(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合４");
        exClassificationEquals(khSeikyuusyoBean.getIrTargettkhnkkbn(), C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU, "（ＩＲ）ターゲット特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKaiyakujiyuu(), C_Kaiyakujiyuu.TUUJYOU, "（ＩＲ）解約事由");
        exClassificationEquals(khSeikyuusyoBean.getIrGengkhoukbn(), C_GengkhouKbn.SD, "（ＩＲ）減額方法区分");
        exNumericEquals(khSeikyuusyoBean.getIrSbuktnin(), 2, "（ＩＲ）死亡受取人人数");
        exClassificationEquals(khSeikyuusyoBean.getIrSbuuktkbn(), C_UktKbn.BLNK, "（ＩＲ）死亡受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrYenshrtkumu(), C_UmuKbn.ARI, "（ＩＲ）円支払特約有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHenkankinumukbn(), C_UmuKbn.ARI, "（ＩＲ）返還金有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrRstuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）領収通貨種類");
        exClassificationEquals(khSeikyuusyoBean.getIrNkshrtkykhnkkbn(), C_NstkhKbn.NAIYOUHENKOU, "（ＩＲ）年金支払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrMeigihnkjiyuu(), C_Meigihnkjiyuu.KYK, "（ＩＲ）名義変更事由");
        exClassificationEquals(khSeikyuusyoBean.getIrNkhknumu(), C_UmuKbn.ARI, "（ＩＲ）年金保険有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSiboukyhkuktumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡給付金受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn1(), C_UmuKbn.ARI, "（ＩＲ）死亡保険金受取人有無区分１");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn2(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分２");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn3(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分３");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn4(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分４");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu1(), C_UmuKbn.ARI, "（ＩＲ）死亡受取人分割割合有無１");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu2(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無２");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu3(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無３");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu4(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無４");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyhukaumu(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyuuktmukbn(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrStdruktkbn(), C_UktKbn.BLNK, "（ＩＲ）指定代理受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrJyudkaigomaebrtkykhnkkbn(),C_JyudkaigomaebaraiTkykhnkKbn.BLNK, "（ＩＲ）重度介護前払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKeihikbn(),C_KeihiKbn.BLNK,"（ＩＲ）契被区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKihonshenkouumu(),C_UmuKbn.NONE,"（ＩＲ）基本Ｓ変更有無");
        exStringEquals(khSeikyuusyoBean.getIrKihonssyurui(), "基本保険金額", "（ＩＲ）基本Ｓ種類");
        exClassificationEquals(khSeikyuusyoBean.getIrTmttknitenkbn(), C_Tmttknitenkbn.BLNK, "（ＩＲ）積立金移転区分");
        exStringEquals(khSeikyuusyoBean.getIrTmttknitenymd(), null, "（ＩＲ）積立金移転日");
        exClassificationEquals(khSeikyuusyoBean.getIrKhhrshrjiyuu(), C_Khhrshrjiyuu.BLNK, "（ＩＲ）契約保全返戻金支払事由");
        exClassificationEquals(khSeikyuusyoBean.getIrKhskssakuseijiyuu(), C_Khskssakuseijiyuu.BLNK, "（ＩＲ）契約保全請求書作成事由");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkijyunkingaku(), BizCurrency.valueOf(100000), "（ＩＲ）基準金額（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrHrkkeiro(), C_Hrkkeiro.DANTAI, "（ＩＲ）払込経路");
        exNumericEquals(khSeikyuusyoBean.getIrSyouhnhanteikekka(), 999, "（ＩＲ）商品判定結果");
        exClassificationEquals(khSeikyuusyoBean.getIrKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "（ＩＲ）契約状態");
        exClassificationEquals(khSeikyuusyoBean.getIrZeiseitkkktkykhukaumu(), C_UmuKbn.ARI, "（ＩＲ）税制適格特約付加有無");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn1(), "", "（ＩＲ）登録家族氏名（カナ）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj1(), "", "（ＩＲ）登録家族氏名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj1(), "", "（ＩＲ）登録家族住所１（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj1(), "", "（ＩＲ）登録家族住所２（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj1(), "", "（ＩＲ）登録家族住所３（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno1(), "", "（ＩＲ）登録家族電話番号１");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi1(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn2(), "", "（ＩＲ）登録家族氏名（カナ）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj2(), "", "（ＩＲ）登録家族氏名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj2(), "", "（ＩＲ）登録家族住所１（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj2(), "", "（ＩＲ）登録家族住所２（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj2(), "", "（ＩＲ）登録家族住所３（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno2(), "", "（ＩＲ）登録家族電話番号２");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi2(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否２");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkn(), "契約者名（カナ）", "（ＩＲ）契約者名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKykdairinmkj(), "", "（ＩＲ）契約者代理人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrtkykhukaumu(), null, "（ＩＲ）契約者代理特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrMousideninkbn(), C_MousideninKbn.BLNK, "（ＩＲ）申出人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrknhatudoujyoutai(), C_KykdrknHtdjytKbn.BLNK, "（ＩＲ）契約者代理権発動状態");
        exStringEquals(khSeikyuusyoBean.getIrDrstiskkyknmkj(), "契約者名", "（ＩＲ）代理人指定先契約者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTyouhyoutitle(), null, "（ＩＲ）帳票タイトル");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg1(), null, "（ＩＲ）送付案内メッセージ１");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg2(), null, "（ＩＲ）送付案内メッセージ２");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg3(), null, "（ＩＲ）送付案内メッセージ３");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg4(), null, "（ＩＲ）送付案内メッセージ４");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg5(), null, "（ＩＲ）送付案内メッセージ５");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg6(), null, "（ＩＲ）送付案内メッセージ６");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg7(), null, "（ＩＲ）送付案内メッセージ７");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg8(), null, "（ＩＲ）送付案内メッセージ８");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg9(), null, "（ＩＲ）送付案内メッセージ９");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg10(), null, "（ＩＲ）送付案内メッセージ１０");

        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean)kSBean[1];

        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(), null, "（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(), "userId001", "（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(), "user001", "（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(), DateFormatUtil.dateKANJI(BizDate.getSysDate()), "（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(), "3 年", "（ＩＲ）保存期間");
    }

    @Test
    @TestOrder(150)
    public void testEditBean_A15() {

        MockObjectManager.initialize();

        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;

        AM_User aMUser = new AM_User();

        aMUser.setUserId("userId001");
        aMUser.setUserNm("user001");
        changeCurrentUser(baseUserInfo, aMUser);

        editSeikyuusyoParam.setHhknseiymd(BizDate.valueOf(20151026));
        editSeikyuusyoParam.setHhknseiymdhenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setHhknsei(C_Hhknsei.MALE);
        editSeikyuusyoParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setBfrTargettkmokuhyouti(BizNumber.valueOf(101));
        editSeikyuusyoParam.setBfrKihonS(BizCurrency.valueOf(778));
        editSeikyuusyoParam.setBfrP(BizCurrency.valueOf(1566));
        editSeikyuusyoParam.setBfrTokuyakuNenkinsyuKbn(C_Nstknsyu.KAKUTEINENKIN);
        editSeikyuusyoParam.setBfrNkshrtkyknksyukkn(5);
        editSeikyuusyoParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU);
        editSeikyuusyoParam.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editSeikyuusyoParam.setGengkhouKbn(C_GengkhouKbn.SD);
        editSeikyuusyoParam.setHenkankumukbn(C_UmuKbn.ARI);
        editSeikyuusyoParam.setRstuukasyu(C_Tuukasyu.JPY);
        editSeikyuusyoParam.setNkshrtkykhnkkbn(C_NstkhKbn.NAIYOUHENKOU);
        editSeikyuusyoParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);
        editSeikyuusyoParam.setJyudkaigomaebaraiTkykhnkKbn(C_JyudkaigomaebaraiTkykhnkKbn.BLNK);
        editSeikyuusyoParam.setKihonshenkouumu(C_UmuKbn.NONE);
        editSeikyuusyoParam.setTmttknitenkbn(C_Tmttknitenkbn.BLNK);
        editSeikyuusyoParam.setTmttknitenymd(null);
        editSeikyuusyoParam.setKhhrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSeikyuusyoParam.setKhskssakuseijiyuu(C_Khskssakuseijiyuu.BLNK);
        editSeikyuusyoParam.setHenkougokjnkngk(BizCurrency.valueOf(100000));

        ReportServicesBean reSsBean =  editSeikyuusyoTbl.editBean(C_SyoruiCdKbn.KK_SHRKZHNK_SKS, syono13, khozenCommonParam, editSeikyuusyoParam);

        Object[] kSBean = reSsBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_SHRKZHNK_SKS.getValue());

        exNumericEquals(kSBean.length, 2, "パラメータオブジェクトの要素数");

        exNumericEquals(reSsBean.getKensakuKeys().length, 1, "検索キー配列の要素数");
        exStringEquals(reSsBean.getKensakuKeys()[0], "12806345797", "検索キー");

        KhSeikyuusyoBean khSeikyuusyoBean = (KhSeikyuusyoBean)kSBean[0];

        exStringEquals(khSeikyuusyoBean.getIrSyono(), "12806345797", "（ＩＲ）証券番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinyno(), "1234567", "（ＩＲ）通信先郵便番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr1kj(), "通信先住所１", "（ＩＲ）通信先住所１（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr2kj(), "通信先住所２", "（ＩＲ）通信先住所２（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr3kj(), "通信先住所３", "（ＩＲ）通信先住所３（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsintelno(), "023-5677-8999", "（ＩＲ）通信先電話番号");
        exStringEquals(khSeikyuusyoBean.getIrBanknmkj(), "みずほ銀行", "（ＩＲ）銀行名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrSitennmkj(), "東京営業部", "（ＩＲ）支店名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrBankcd(), "0001", "（ＩＲ）銀行コード");
        exStringEquals(khSeikyuusyoBean.getIrSitencd(), "001", "（ＩＲ）支店コード");

        exStringEquals(khSeikyuusyoBean.getIrKzmeiginmkn(), "口座名義人氏名（カナ）", "（ＩＲ）口座名義人氏名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkj(), "契約者名", "（ＩＲ）契約者名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKkkyktdk(), C_Tdk.HGU, "（ＩＲ）契約管理契約者続柄");
        exStringEquals(khSeikyuusyoBean.getIrHhknnmkj(), "被保険者名", "（ＩＲ）被保険者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrHhknseiymd(), "", "（ＩＲ）被保険者生年月日");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseiymdhenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者生年月日変更有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknsei(), C_Hhknsei.MALE, "（ＩＲ）被保険者性別");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseihenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者性別変更有無");
        exStringEquals(khSeikyuusyoBean.getIrStdrsknmkj(), "長島", "（ＩＲ）指定代理請求人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrFatcakakuninyhkbn(), C_YouhiblnkKbn.HUYOU, "（ＩＲ）FATCA確認要否区分");
        exClassificationEquals(khSeikyuusyoBean.getIrAeoikakuninyhkbn(), C_YouhiblnkKbn.HUYOU, "（ＩＲ）ＡＥＯＩ確認要否区分");

        exClassificationEquals(khSeikyuusyoBean.getIrTargettkkbn(), C_TargetTkKbn.BLNK, "（ＩＲ）ターゲット特約区分");
        exNumericEquals(khSeikyuusyoBean.getIrAftertargettkmokuhyouti(), 101, "（ＩＲ）変更後ターゲット特約目標値");
        exNumericEquals(khSeikyuusyoBean.getIrBeforetargettkmokuhyouti(), 200, "（ＩＲ）変更前ターゲット特約目標値");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforekihons(), BizCurrency.valueOf(100), "（ＩＲ）基本保険金額（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkihons(),  BizCurrency.valueOf(778), "（ＩＲ）基本保険金額（変更後）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforep(), BizCurrency.valueOf(200), "（ＩＲ）保険料（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterp(), BizCurrency.valueOf(1566), "（ＩＲ）保険料（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrKyktuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）契約通貨種類");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj1(), "小野", "（ＩＲ）死亡受取人名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj2(), "", "（ＩＲ）死亡受取人名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj3(), "", "（ＩＲ）死亡受取人名（漢字）３");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj4(), "", "（ＩＲ）死亡受取人名（漢字）４");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkn(), "受取人名（カナ）", "（ＩＲ）死亡受取人名（カナ）");
        exClassificationEquals(khSeikyuusyoBean.getIrYokinkbn(), C_YokinKbn.HUTUU, "（ＩＲ）預金種目区分");
        exStringEquals(khSeikyuusyoBean.getIrKouzano(), "10101***", "（ＩＲ）口座番号");

        exClassificationEquals(khSeikyuusyoBean.getIrAfternkshrtkyknksyukbn(), C_Nstknsyu.KAKUTEINENKIN, "（ＩＲ）変更後年金支払特約年金種類区分");
        exClassificationEquals(khSeikyuusyoBean.getIrBiforenkshrtkyknksyukbn(), C_Nstknsyu.BLNK, "（ＩＲ）変更前年金支払特約年金種類区分");
        exNumericEquals(khSeikyuusyoBean.getIrAfternkshrtkyknkkkn(), 5, "（ＩＲ）変更後年金支払特約年金期間");
        exNumericEquals(khSeikyuusyoBean.getIrBeforenkshrtkyknkkkn(), 10, "（ＩＲ）変更前年金支払特約年金期間");
        exStringEquals(khSeikyuusyoBean.getIrNkuktnm(), "森君", "（ＩＲ）年金受取人名");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari1(), BizNumber.valueOf(230), "（ＩＲ）死亡受取人分割割合１");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari2(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合２");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari3(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合３");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari4(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合４");
        exClassificationEquals(khSeikyuusyoBean.getIrTargettkhnkkbn(), C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU, "（ＩＲ）ターゲット特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKaiyakujiyuu(), C_Kaiyakujiyuu.TUUJYOU, "（ＩＲ）解約事由");
        exClassificationEquals(khSeikyuusyoBean.getIrGengkhoukbn(), C_GengkhouKbn.SD, "（ＩＲ）減額方法区分");
        exNumericEquals(khSeikyuusyoBean.getIrSbuktnin(), 2, "（ＩＲ）死亡受取人人数");
        exClassificationEquals(khSeikyuusyoBean.getIrSbuuktkbn(), C_UktKbn.BLNK, "（ＩＲ）死亡受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrYenshrtkumu(), C_UmuKbn.ARI, "（ＩＲ）円支払特約有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHenkankinumukbn(), C_UmuKbn.ARI, "（ＩＲ）返還金有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrRstuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）領収通貨種類");
        exClassificationEquals(khSeikyuusyoBean.getIrNkshrtkykhnkkbn(), C_NstkhKbn.NAIYOUHENKOU, "（ＩＲ）年金支払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrMeigihnkjiyuu(), C_Meigihnkjiyuu.KYK, "（ＩＲ）名義変更事由");
        exClassificationEquals(khSeikyuusyoBean.getIrNkhknumu(), C_UmuKbn.ARI, "（ＩＲ）年金保険有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSiboukyhkuktumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡給付金受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn1(), C_UmuKbn.ARI, "（ＩＲ）死亡保険金受取人有無区分１");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn2(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分２");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn3(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分３");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn4(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分４");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu1(), C_UmuKbn.ARI, "（ＩＲ）死亡受取人分割割合有無１");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu2(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無２");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu3(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無３");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu4(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無４");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyhukaumu(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyuuktmukbn(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrStdruktkbn(), C_UktKbn.BLNK, "（ＩＲ）指定代理受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrJyudkaigomaebrtkykhnkkbn(),C_JyudkaigomaebaraiTkykhnkKbn.BLNK, "（ＩＲ）重度介護前払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKeihikbn(),C_KeihiKbn.BLNK,"（ＩＲ）契被区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKihonshenkouumu(),C_UmuKbn.NONE,"（ＩＲ）基本Ｓ変更有無");
        exStringEquals(khSeikyuusyoBean.getIrKihonssyurui(), "基本保険金額", "（ＩＲ）基本Ｓ種類");
        exClassificationEquals(khSeikyuusyoBean.getIrTmttknitenkbn(), C_Tmttknitenkbn.BLNK, "（ＩＲ）積立金移転区分");
        exStringEquals(khSeikyuusyoBean.getIrTmttknitenymd(), null, "（ＩＲ）積立金移転日");
        exClassificationEquals(khSeikyuusyoBean.getIrKhhrshrjiyuu(), C_Khhrshrjiyuu.BLNK, "（ＩＲ）契約保全返戻金支払事由");
        exClassificationEquals(khSeikyuusyoBean.getIrKhskssakuseijiyuu(), C_Khskssakuseijiyuu.BLNK, "（ＩＲ）契約保全請求書作成事由");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkijyunkingaku(), BizCurrency.valueOf(100000), "（ＩＲ）基準金額（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrHrkkeiro(), C_Hrkkeiro.DANTAI, "（ＩＲ）払込経路");
        exNumericEquals(khSeikyuusyoBean.getIrSyouhnhanteikekka(), 999, "（ＩＲ）商品判定結果");
        exClassificationEquals(khSeikyuusyoBean.getIrKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "（ＩＲ）契約状態");
        exClassificationEquals(khSeikyuusyoBean.getIrZeiseitkkktkykhukaumu(), C_UmuKbn.ARI, "（ＩＲ）税制適格特約付加有無");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn1(), "", "（ＩＲ）登録家族氏名（カナ）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj1(), "", "（ＩＲ）登録家族氏名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj1(), "", "（ＩＲ）登録家族住所１（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj1(), "", "（ＩＲ）登録家族住所２（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj1(), "", "（ＩＲ）登録家族住所３（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno1(), "", "（ＩＲ）登録家族電話番号１");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi1(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn2(), "", "（ＩＲ）登録家族氏名（カナ）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj2(), "", "（ＩＲ）登録家族氏名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj2(), "", "（ＩＲ）登録家族住所１（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj2(), "", "（ＩＲ）登録家族住所２（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj2(), "", "（ＩＲ）登録家族住所３（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno2(), "", "（ＩＲ）登録家族電話番号２");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi2(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否２");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkn(), "契約者名（カナ）", "（ＩＲ）契約者名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKykdairinmkj(), "", "（ＩＲ）契約者代理人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrtkykhukaumu(), null, "（ＩＲ）契約者代理特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrMousideninkbn(), C_MousideninKbn.BLNK, "（ＩＲ）申出人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrknhatudoujyoutai(), C_KykdrknHtdjytKbn.BLNK, "（ＩＲ）契約者代理権発動状態");
        exStringEquals(khSeikyuusyoBean.getIrDrstiskkyknmkj(), "契約者名", "（ＩＲ）代理人指定先契約者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTyouhyoutitle(), null, "（ＩＲ）帳票タイトル");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg1(), null, "（ＩＲ）送付案内メッセージ１");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg2(), null, "（ＩＲ）送付案内メッセージ２");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg3(), null, "（ＩＲ）送付案内メッセージ３");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg4(), null, "（ＩＲ）送付案内メッセージ４");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg5(), null, "（ＩＲ）送付案内メッセージ５");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg6(), null, "（ＩＲ）送付案内メッセージ６");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg7(), null, "（ＩＲ）送付案内メッセージ７");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg8(), null, "（ＩＲ）送付案内メッセージ８");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg9(), null, "（ＩＲ）送付案内メッセージ９");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg10(), null, "（ＩＲ）送付案内メッセージ１０");

        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean)kSBean[1];

        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(), null, "（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(), "userId001", "（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(), "user001", "（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(), DateFormatUtil.dateKANJI(BizDate.getSysDate()), "（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(), "3 年", "（ＩＲ）保存期間");
    }

    @Test
    @TestOrder(160)
    public void testEditBean_A16() {

        MockObjectManager.initialize();

        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;

        AM_User aMUser = new AM_User();

        aMUser.setUserId("userId001");
        aMUser.setUserNm("user001");
        changeCurrentUser(baseUserInfo, aMUser);

        editSeikyuusyoParam.setHhknseiymd(BizDate.valueOf(20151026));
        editSeikyuusyoParam.setHhknseiymdhenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setHhknsei(C_Hhknsei.MALE);
        editSeikyuusyoParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setBfrTargettkmokuhyouti(BizNumber.valueOf(101));
        editSeikyuusyoParam.setBfrKihonS(BizCurrency.valueOf(778));
        editSeikyuusyoParam.setBfrP(BizCurrency.valueOf(1566));
        editSeikyuusyoParam.setBfrTokuyakuNenkinsyuKbn(C_Nstknsyu.KAKUTEINENKIN);
        editSeikyuusyoParam.setBfrNkshrtkyknksyukkn(5);
        editSeikyuusyoParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU);
        editSeikyuusyoParam.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editSeikyuusyoParam.setGengkhouKbn(C_GengkhouKbn.SD);
        editSeikyuusyoParam.setHenkankumukbn(C_UmuKbn.ARI);
        editSeikyuusyoParam.setRstuukasyu(C_Tuukasyu.JPY);
        editSeikyuusyoParam.setNkshrtkykhnkkbn(C_NstkhKbn.NAIYOUHENKOU);
        editSeikyuusyoParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);
        editSeikyuusyoParam.setJyudkaigomaebaraiTkykhnkKbn(C_JyudkaigomaebaraiTkykhnkKbn.BLNK);
        editSeikyuusyoParam.setKihonshenkouumu(C_UmuKbn.NONE);
        editSeikyuusyoParam.setTmttknitenkbn(C_Tmttknitenkbn.BLNK);
        editSeikyuusyoParam.setTmttknitenymd(null);
        editSeikyuusyoParam.setKhhrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSeikyuusyoParam.setKhskssakuseijiyuu(C_Khskssakuseijiyuu.BLNK);
        editSeikyuusyoParam.setHenkougokjnkngk(BizCurrency.valueOf(100000));

        ReportServicesBean reSsBean =  editSeikyuusyoTbl.editBean(C_SyoruiCdKbn.KK_SEINENGAPPISEI_SKS, syono14, khozenCommonParam, editSeikyuusyoParam);

        Object[] kSBean = reSsBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_SEINENGAPPISEI_SKS.getValue());

        exNumericEquals(kSBean.length, 2, "パラメータオブジェクトの要素数");

        exNumericEquals(reSsBean.getKensakuKeys().length, 1, "検索キー配列の要素数");
        exStringEquals(reSsBean.getKensakuKeys()[0], "12806345801", "検索キー");

        KhSeikyuusyoBean khSeikyuusyoBean = (KhSeikyuusyoBean)kSBean[0];

        exStringEquals(khSeikyuusyoBean.getIrSyono(), "12806345801", "（ＩＲ）証券番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinyno(), "1234567", "（ＩＲ）通信先郵便番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr1kj(), "通信先住所１", "（ＩＲ）通信先住所１（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr2kj(), "通信先住所２", "（ＩＲ）通信先住所２（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr3kj(), "通信先住所３", "（ＩＲ）通信先住所３（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsintelno(), "023-5677-8999", "（ＩＲ）通信先電話番号");
        exStringEquals(khSeikyuusyoBean.getIrBanknmkj(), "三井住友銀行", "（ＩＲ）銀行名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrSitennmkj(), "", "（ＩＲ）支店名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrBankcd(), "", "（ＩＲ）銀行コード");
        exStringEquals(khSeikyuusyoBean.getIrSitencd(), "", "（ＩＲ）支店コード");

        exStringEquals(khSeikyuusyoBean.getIrKzmeiginmkn(), "ユヒメイ　ナナイチア", "（ＩＲ）口座名義人氏名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkj(), "契約者名", "（ＩＲ）契約者名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKkkyktdk(), C_Tdk.HGU, "（ＩＲ）契約管理契約者続柄");
        exStringEquals(khSeikyuusyoBean.getIrHhknnmkj(), "被保険者名", "（ＩＲ）被保険者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrHhknseiymd(), "平成27年10月26日", "（ＩＲ）被保険者生年月日");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseiymdhenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者生年月日変更有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknsei(), C_Hhknsei.MALE, "（ＩＲ）被保険者性別");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseihenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者性別変更有無");
        exStringEquals(khSeikyuusyoBean.getIrStdrsknmkj(), "長島", "（ＩＲ）指定代理請求人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrFatcakakuninyhkbn(), C_YouhiblnkKbn.HUYOU, "（ＩＲ）FATCA確認要否区分");
        exClassificationEquals(khSeikyuusyoBean.getIrAeoikakuninyhkbn(), C_YouhiblnkKbn.HUYOU, "（ＩＲ）ＡＥＯＩ確認要否区分");

        exClassificationEquals(khSeikyuusyoBean.getIrTargettkkbn(), C_TargetTkKbn.BLNK, "（ＩＲ）ターゲット特約区分");
        exNumericEquals(khSeikyuusyoBean.getIrAftertargettkmokuhyouti(), 101, "（ＩＲ）変更後ターゲット特約目標値");
        exNumericEquals(khSeikyuusyoBean.getIrBeforetargettkmokuhyouti(), 200, "（ＩＲ）変更前ターゲット特約目標値");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforekihons(), BizCurrency.valueOf(100), "（ＩＲ）基本保険金額（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkihons(),  BizCurrency.valueOf(778), "（ＩＲ）基本保険金額（変更後）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforep(), BizCurrency.valueOf(200), "（ＩＲ）保険料（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterp(), BizCurrency.valueOf(1566), "（ＩＲ）保険料（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrKyktuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）契約通貨種類");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj1(), "小野", "（ＩＲ）死亡受取人名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj2(), "", "（ＩＲ）死亡受取人名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj3(), "", "（ＩＲ）死亡受取人名（漢字）３");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj4(), "", "（ＩＲ）死亡受取人名（漢字）４");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkn(), "受取人名（カナ）", "（ＩＲ）死亡受取人名（カナ）");
        exClassificationEquals(khSeikyuusyoBean.getIrYokinkbn(), C_YokinKbn.BLNK, "（ＩＲ）預金種目区分");
        exStringEquals(khSeikyuusyoBean.getIrKouzano(), "", "（ＩＲ）口座番号");

        exClassificationEquals(khSeikyuusyoBean.getIrAfternkshrtkyknksyukbn(), C_Nstknsyu.KAKUTEINENKIN, "（ＩＲ）変更後年金支払特約年金種類区分");
        exClassificationEquals(khSeikyuusyoBean.getIrBiforenkshrtkyknksyukbn(), C_Nstknsyu.BLNK, "（ＩＲ）変更前年金支払特約年金種類区分");
        exNumericEquals(khSeikyuusyoBean.getIrAfternkshrtkyknkkkn(), 5, "（ＩＲ）変更後年金支払特約年金期間");
        exNumericEquals(khSeikyuusyoBean.getIrBeforenkshrtkyknkkkn(), 10, "（ＩＲ）変更前年金支払特約年金期間");
        exStringEquals(khSeikyuusyoBean.getIrNkuktnm(), "森君", "（ＩＲ）年金受取人名");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari1(), BizNumber.valueOf(230), "（ＩＲ）死亡受取人分割割合１");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari2(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合２");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari3(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合３");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari4(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合４");
        exClassificationEquals(khSeikyuusyoBean.getIrTargettkhnkkbn(), C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU, "（ＩＲ）ターゲット特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKaiyakujiyuu(), C_Kaiyakujiyuu.TUUJYOU, "（ＩＲ）解約事由");
        exClassificationEquals(khSeikyuusyoBean.getIrGengkhoukbn(), C_GengkhouKbn.SD, "（ＩＲ）減額方法区分");
        exNumericEquals(khSeikyuusyoBean.getIrSbuktnin(), 2, "（ＩＲ）死亡受取人人数");
        exClassificationEquals(khSeikyuusyoBean.getIrSbuuktkbn(), C_UktKbn.BLNK, "（ＩＲ）死亡受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrYenshrtkumu(), C_UmuKbn.ARI, "（ＩＲ）円支払特約有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHenkankinumukbn(), C_UmuKbn.ARI, "（ＩＲ）返還金有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrRstuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）領収通貨種類");
        exClassificationEquals(khSeikyuusyoBean.getIrNkshrtkykhnkkbn(), C_NstkhKbn.NAIYOUHENKOU, "（ＩＲ）年金支払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrMeigihnkjiyuu(), C_Meigihnkjiyuu.KYK, "（ＩＲ）名義変更事由");
        exClassificationEquals(khSeikyuusyoBean.getIrNkhknumu(), C_UmuKbn.ARI, "（ＩＲ）年金保険有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSiboukyhkuktumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡給付金受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn1(), C_UmuKbn.ARI, "（ＩＲ）死亡保険金受取人有無区分１");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn2(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分２");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn3(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分３");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn4(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分４");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu1(), C_UmuKbn.ARI, "（ＩＲ）死亡受取人分割割合有無１");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu2(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無２");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu3(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無３");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu4(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無４");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyhukaumu(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyuuktmukbn(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrStdruktkbn(), C_UktKbn.BLNK, "（ＩＲ）指定代理受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrJyudkaigomaebrtkykhnkkbn(),C_JyudkaigomaebaraiTkykhnkKbn.BLNK, "（ＩＲ）重度介護前払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKeihikbn(),C_KeihiKbn.BLNK,"（ＩＲ）契被区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKihonshenkouumu(),C_UmuKbn.NONE,"（ＩＲ）基本Ｓ変更有無");
        exStringEquals(khSeikyuusyoBean.getIrKihonssyurui(), "基本保険金額", "（ＩＲ）基本Ｓ種類");
        exClassificationEquals(khSeikyuusyoBean.getIrTmttknitenkbn(), C_Tmttknitenkbn.BLNK, "（ＩＲ）積立金移転区分");
        exStringEquals(khSeikyuusyoBean.getIrTmttknitenymd(), null, "（ＩＲ）積立金移転日");
        exClassificationEquals(khSeikyuusyoBean.getIrKhhrshrjiyuu(), C_Khhrshrjiyuu.BLNK, "（ＩＲ）契約保全返戻金支払事由");
        exClassificationEquals(khSeikyuusyoBean.getIrKhskssakuseijiyuu(), C_Khskssakuseijiyuu.BLNK, "（ＩＲ）契約保全請求書作成事由");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkijyunkingaku(), BizCurrency.valueOf(100000), "（ＩＲ）基準金額（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrHrkkeiro(), C_Hrkkeiro.DANTAI, "（ＩＲ）払込経路");
        exNumericEquals(khSeikyuusyoBean.getIrSyouhnhanteikekka(), 999, "（ＩＲ）商品判定結果");
        exClassificationEquals(khSeikyuusyoBean.getIrKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "（ＩＲ）契約状態");
        exClassificationEquals(khSeikyuusyoBean.getIrZeiseitkkktkykhukaumu(), C_UmuKbn.ARI, "（ＩＲ）税制適格特約付加有無");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn1(), "", "（ＩＲ）登録家族氏名（カナ）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj1(), "", "（ＩＲ）登録家族氏名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj1(), "", "（ＩＲ）登録家族住所１（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj1(), "", "（ＩＲ）登録家族住所２（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj1(), "", "（ＩＲ）登録家族住所３（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno1(), "", "（ＩＲ）登録家族電話番号１");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi1(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn2(), "", "（ＩＲ）登録家族氏名（カナ）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj2(), "", "（ＩＲ）登録家族氏名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj2(), "", "（ＩＲ）登録家族住所１（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj2(), "", "（ＩＲ）登録家族住所２（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj2(), "", "（ＩＲ）登録家族住所３（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno2(), "", "（ＩＲ）登録家族電話番号２");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi2(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否２");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkn(), "契約者名（カナ）", "（ＩＲ）契約者名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKykdairinmkj(), "", "（ＩＲ）契約者代理人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrtkykhukaumu(), null, "（ＩＲ）契約者代理特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrMousideninkbn(), C_MousideninKbn.BLNK, "（ＩＲ）申出人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrknhatudoujyoutai(), C_KykdrknHtdjytKbn.BLNK, "（ＩＲ）契約者代理権発動状態");
        exStringEquals(khSeikyuusyoBean.getIrDrstiskkyknmkj(), "契約者名", "（ＩＲ）代理人指定先契約者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTyouhyoutitle(), null, "（ＩＲ）帳票タイトル");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg1(), null, "（ＩＲ）送付案内メッセージ１");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg2(), null, "（ＩＲ）送付案内メッセージ２");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg3(), null, "（ＩＲ）送付案内メッセージ３");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg4(), null, "（ＩＲ）送付案内メッセージ４");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg5(), null, "（ＩＲ）送付案内メッセージ５");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg6(), null, "（ＩＲ）送付案内メッセージ６");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg7(), null, "（ＩＲ）送付案内メッセージ７");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg8(), null, "（ＩＲ）送付案内メッセージ８");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg9(), null, "（ＩＲ）送付案内メッセージ９");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg10(), null, "（ＩＲ）送付案内メッセージ１０");

        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean)kSBean[1];

        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(), null, "（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(), "userId001", "（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(), "user001", "（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(), DateFormatUtil.dateKANJI(BizDate.getSysDate()), "（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(), "　消滅後 3 年", "（ＩＲ）保存期間");
    }

    @Test
    @TestOrder(170)
    public void testEditBean_A17() {

        MockObjectManager.initialize();

        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;

        AM_User aMUser = new AM_User();

        aMUser.setUserId("userId001");
        aMUser.setUserNm("user001");
        changeCurrentUser(baseUserInfo, aMUser);

        editSeikyuusyoParam.setHhknseiymd(BizDate.valueOf(20151026));
        editSeikyuusyoParam.setHhknseiymdhenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setHhknsei(C_Hhknsei.MALE);
        editSeikyuusyoParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setBfrTargettkmokuhyouti(BizNumber.valueOf(101));
        editSeikyuusyoParam.setBfrKihonS(BizCurrency.valueOf(778));
        editSeikyuusyoParam.setBfrP(BizCurrency.valueOf(1566));
        editSeikyuusyoParam.setBfrTokuyakuNenkinsyuKbn(C_Nstknsyu.KAKUTEINENKIN);
        editSeikyuusyoParam.setBfrNkshrtkyknksyukkn(5);
        editSeikyuusyoParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU);
        editSeikyuusyoParam.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editSeikyuusyoParam.setGengkhouKbn(C_GengkhouKbn.SD);
        editSeikyuusyoParam.setHenkankumukbn(C_UmuKbn.ARI);
        editSeikyuusyoParam.setRstuukasyu(C_Tuukasyu.JPY);
        editSeikyuusyoParam.setNkshrtkykhnkkbn(C_NstkhKbn.NAIYOUHENKOU);
        editSeikyuusyoParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);
        editSeikyuusyoParam.setJyudkaigomaebaraiTkykhnkKbn(C_JyudkaigomaebaraiTkykhnkKbn.BLNK);
        editSeikyuusyoParam.setKihonshenkouumu(C_UmuKbn.NONE);
        editSeikyuusyoParam.setTmttknitenkbn(C_Tmttknitenkbn.BLNK);
        editSeikyuusyoParam.setTmttknitenymd(null);
        editSeikyuusyoParam.setKhhrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSeikyuusyoParam.setKhskssakuseijiyuu(C_Khskssakuseijiyuu.BLNK);
        editSeikyuusyoParam.setHenkougokjnkngk(BizCurrency.valueOf(100000));

        ReportServicesBean reSsBean =  editSeikyuusyoTbl.editBean(C_SyoruiCdKbn.KK_KAIYAKU_SKS, syono15, khozenCommonParam, editSeikyuusyoParam);

        Object[] kSBean = reSsBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_KAIYAKU_SKS.getValue());

        exNumericEquals(kSBean.length, 2, "パラメータオブジェクトの要素数");

        exNumericEquals(reSsBean.getKensakuKeys().length, 1, "検索キー配列の要素数");
        exStringEquals(reSsBean.getKensakuKeys()[0], "12806345812", "検索キー");

        KhSeikyuusyoBean khSeikyuusyoBean = (KhSeikyuusyoBean)kSBean[0];

        exStringEquals(khSeikyuusyoBean.getIrSyono(), "12806345812", "（ＩＲ）証券番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinyno(), "1234567", "（ＩＲ）通信先郵便番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr1kj(), "通信先住所１", "（ＩＲ）通信先住所１（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr2kj(), "通信先住所２", "（ＩＲ）通信先住所２（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr3kj(), "通信先住所３", "（ＩＲ）通信先住所３（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsintelno(), "023-5677-8999", "（ＩＲ）通信先電話番号");
        exStringEquals(khSeikyuusyoBean.getIrBanknmkj(), "", "（ＩＲ）銀行名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrSitennmkj(), "", "（ＩＲ）支店名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrBankcd(), "", "（ＩＲ）銀行コード");
        exStringEquals(khSeikyuusyoBean.getIrSitencd(), "", "（ＩＲ）支店コード");

        exStringEquals(khSeikyuusyoBean.getIrKzmeiginmkn(), "", "（ＩＲ）口座名義人氏名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkj(), "契約者名", "（ＩＲ）契約者名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKkkyktdk(), C_Tdk.HONNIN, "（ＩＲ）契約管理契約者続柄");
        exStringEquals(khSeikyuusyoBean.getIrHhknnmkj(), "被保険者名", "（ＩＲ）被保険者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrHhknseiymd(), "", "（ＩＲ）被保険者生年月日");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseiymdhenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者生年月日変更有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknsei(), C_Hhknsei.MALE, "（ＩＲ）被保険者性別");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseihenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者性別変更有無");
        exStringEquals(khSeikyuusyoBean.getIrStdrsknmkj(), "長島", "（ＩＲ）指定代理請求人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrFatcakakuninyhkbn(), C_YouhiblnkKbn.HUYOU, "（ＩＲ）FATCA確認要否区分");
        exClassificationEquals(khSeikyuusyoBean.getIrAeoikakuninyhkbn(), C_YouhiblnkKbn.HUYOU, "（ＩＲ）ＡＥＯＩ確認要否区分");

        exClassificationEquals(khSeikyuusyoBean.getIrTargettkkbn(), C_TargetTkKbn.BLNK, "（ＩＲ）ターゲット特約区分");
        exNumericEquals(khSeikyuusyoBean.getIrAftertargettkmokuhyouti(), 101, "（ＩＲ）変更後ターゲット特約目標値");
        exNumericEquals(khSeikyuusyoBean.getIrBeforetargettkmokuhyouti(), 200, "（ＩＲ）変更前ターゲット特約目標値");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforekihons(), BizCurrency.valueOf(100), "（ＩＲ）基本保険金額（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkihons(),  BizCurrency.valueOf(778), "（ＩＲ）基本保険金額（変更後）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforep(), BizCurrency.valueOf(200), "（ＩＲ）保険料（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterp(), BizCurrency.valueOf(1566), "（ＩＲ）保険料（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrKyktuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）契約通貨種類");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj1(), "小野", "（ＩＲ）死亡受取人名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj2(), "", "（ＩＲ）死亡受取人名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj3(), "", "（ＩＲ）死亡受取人名（漢字）３");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj4(), "", "（ＩＲ）死亡受取人名（漢字）４");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkn(), "受取人名（カナ）", "（ＩＲ）死亡受取人名（カナ）");
        exClassificationEquals(khSeikyuusyoBean.getIrYokinkbn(), C_YokinKbn.BLNK, "（ＩＲ）預金種目区分");
        exStringEquals(khSeikyuusyoBean.getIrKouzano(), "", "（ＩＲ）口座番号");

        exClassificationEquals(khSeikyuusyoBean.getIrAfternkshrtkyknksyukbn(), C_Nstknsyu.KAKUTEINENKIN, "（ＩＲ）変更後年金支払特約年金種類区分");
        exClassificationEquals(khSeikyuusyoBean.getIrBiforenkshrtkyknksyukbn(), C_Nstknsyu.BLNK, "（ＩＲ）変更前年金支払特約年金種類区分");
        exNumericEquals(khSeikyuusyoBean.getIrAfternkshrtkyknkkkn(), 5, "（ＩＲ）変更後年金支払特約年金期間");
        exNumericEquals(khSeikyuusyoBean.getIrBeforenkshrtkyknkkkn(), 10, "（ＩＲ）変更前年金支払特約年金期間");
        exStringEquals(khSeikyuusyoBean.getIrNkuktnm(), "森君", "（ＩＲ）年金受取人名");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari1(), BizNumber.valueOf(230), "（ＩＲ）死亡受取人分割割合１");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari2(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合２");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari3(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合３");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari4(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合４");
        exClassificationEquals(khSeikyuusyoBean.getIrTargettkhnkkbn(), C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU, "（ＩＲ）ターゲット特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKaiyakujiyuu(), C_Kaiyakujiyuu.TUUJYOU, "（ＩＲ）解約事由");
        exClassificationEquals(khSeikyuusyoBean.getIrGengkhoukbn(), C_GengkhouKbn.SD, "（ＩＲ）減額方法区分");
        exNumericEquals(khSeikyuusyoBean.getIrSbuktnin(), 2, "（ＩＲ）死亡受取人人数");
        exClassificationEquals(khSeikyuusyoBean.getIrSbuuktkbn(), C_UktKbn.BLNK, "（ＩＲ）死亡受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrYenshrtkumu(), C_UmuKbn.ARI, "（ＩＲ）円支払特約有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHenkankinumukbn(), C_UmuKbn.ARI, "（ＩＲ）返還金有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrRstuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）領収通貨種類");
        exClassificationEquals(khSeikyuusyoBean.getIrNkshrtkykhnkkbn(), C_NstkhKbn.NAIYOUHENKOU, "（ＩＲ）年金支払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrMeigihnkjiyuu(), C_Meigihnkjiyuu.KYK, "（ＩＲ）名義変更事由");
        exClassificationEquals(khSeikyuusyoBean.getIrNkhknumu(), C_UmuKbn.ARI, "（ＩＲ）年金保険有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSiboukyhkuktumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡給付金受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn1(), C_UmuKbn.ARI, "（ＩＲ）死亡保険金受取人有無区分１");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn2(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分２");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn3(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分３");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn4(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分４");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu1(), C_UmuKbn.ARI, "（ＩＲ）死亡受取人分割割合有無１");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu2(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無２");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu3(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無３");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu4(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無４");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyhukaumu(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyuuktmukbn(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrStdruktkbn(), C_UktKbn.BLNK, "（ＩＲ）指定代理受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrJyudkaigomaebrtkykhnkkbn(),C_JyudkaigomaebaraiTkykhnkKbn.BLNK, "（ＩＲ）重度介護前払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKeihikbn(),C_KeihiKbn.KEIHIDOUITU,"（ＩＲ）契被区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKihonshenkouumu(),C_UmuKbn.NONE,"（ＩＲ）基本Ｓ変更有無");
        exStringEquals(khSeikyuusyoBean.getIrKihonssyurui(), "基本保険金額", "（ＩＲ）基本Ｓ種類");
        exClassificationEquals(khSeikyuusyoBean.getIrTmttknitenkbn(), C_Tmttknitenkbn.BLNK, "（ＩＲ）積立金移転区分");
        exStringEquals(khSeikyuusyoBean.getIrTmttknitenymd(), null, "（ＩＲ）積立金移転日");
        exClassificationEquals(khSeikyuusyoBean.getIrKhhrshrjiyuu(), C_Khhrshrjiyuu.BLNK, "（ＩＲ）契約保全返戻金支払事由");
        exClassificationEquals(khSeikyuusyoBean.getIrKhskssakuseijiyuu(), C_Khskssakuseijiyuu.BLNK, "（ＩＲ）契約保全請求書作成事由");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkijyunkingaku(), BizCurrency.valueOf(100000), "（ＩＲ）基準金額（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrHrkkeiro(), C_Hrkkeiro.DANTAI, "（ＩＲ）払込経路");
        exNumericEquals(khSeikyuusyoBean.getIrSyouhnhanteikekka(), 999, "（ＩＲ）商品判定結果");
        exClassificationEquals(khSeikyuusyoBean.getIrKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "（ＩＲ）契約状態");
        exClassificationEquals(khSeikyuusyoBean.getIrZeiseitkkktkykhukaumu(), C_UmuKbn.ARI, "（ＩＲ）税制適格特約付加有無");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn1(), "", "（ＩＲ）登録家族氏名（カナ）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj1(), "", "（ＩＲ）登録家族氏名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj1(), "", "（ＩＲ）登録家族住所１（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj1(), "", "（ＩＲ）登録家族住所２（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj1(), "", "（ＩＲ）登録家族住所３（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno1(), "", "（ＩＲ）登録家族電話番号１");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi1(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn2(), "", "（ＩＲ）登録家族氏名（カナ）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj2(), "", "（ＩＲ）登録家族氏名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj2(), "", "（ＩＲ）登録家族住所１（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj2(), "", "（ＩＲ）登録家族住所２（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj2(), "", "（ＩＲ）登録家族住所３（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno2(), "", "（ＩＲ）登録家族電話番号２");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi2(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否２");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkn(), "契約者名（カナ）", "（ＩＲ）契約者名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKykdairinmkj(), "", "（ＩＲ）契約者代理人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrtkykhukaumu(), null, "（ＩＲ）契約者代理特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrMousideninkbn(), C_MousideninKbn.BLNK, "（ＩＲ）申出人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrknhatudoujyoutai(), C_KykdrknHtdjytKbn.BLNK, "（ＩＲ）契約者代理権発動状態");
        exStringEquals(khSeikyuusyoBean.getIrDrstiskkyknmkj(), "契約者名", "（ＩＲ）代理人指定先契約者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTyouhyoutitle(), null, "（ＩＲ）帳票タイトル");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg1(), null, "（ＩＲ）送付案内メッセージ１");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg2(), null, "（ＩＲ）送付案内メッセージ２");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg3(), null, "（ＩＲ）送付案内メッセージ３");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg4(), null, "（ＩＲ）送付案内メッセージ４");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg5(), null, "（ＩＲ）送付案内メッセージ５");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg6(), null, "（ＩＲ）送付案内メッセージ６");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg7(), null, "（ＩＲ）送付案内メッセージ７");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg8(), null, "（ＩＲ）送付案内メッセージ８");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg9(), null, "（ＩＲ）送付案内メッセージ９");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg10(), null, "（ＩＲ）送付案内メッセージ１０");

        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean)kSBean[1];

        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(), null, "（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(), "userId001", "（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(), "user001", "（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(), DateFormatUtil.dateKANJI(BizDate.getSysDate()), "（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(), "", "（ＩＲ）保存期間");
    }

    @Test
    @TestOrder(180)
    public void testEditBean_A18() {

        MockObjectManager.initialize();

        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;

        AM_User aMUser = new AM_User();

        aMUser.setUserId("userId001");
        aMUser.setUserNm("user001");
        changeCurrentUser(baseUserInfo, aMUser);

        editSeikyuusyoParam.setHhknseiymd(BizDate.valueOf(20151026));
        editSeikyuusyoParam.setHhknseiymdhenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setHhknsei(C_Hhknsei.MALE);
        editSeikyuusyoParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setBfrTargettkmokuhyouti(BizNumber.valueOf(101));
        editSeikyuusyoParam.setBfrKihonS(BizCurrency.valueOf(778));
        editSeikyuusyoParam.setBfrP(BizCurrency.valueOf(1566));
        editSeikyuusyoParam.setBfrTokuyakuNenkinsyuKbn(C_Nstknsyu.KAKUTEINENKIN);
        editSeikyuusyoParam.setBfrNkshrtkyknksyukkn(5);
        editSeikyuusyoParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU);
        editSeikyuusyoParam.setKaiyakujiyuu(C_Kaiyakujiyuu.KYKSB);
        editSeikyuusyoParam.setGengkhouKbn(C_GengkhouKbn.SD);
        editSeikyuusyoParam.setHenkankumukbn(C_UmuKbn.ARI);
        editSeikyuusyoParam.setRstuukasyu(C_Tuukasyu.JPY);
        editSeikyuusyoParam.setNkshrtkykhnkkbn(C_NstkhKbn.NAIYOUHENKOU);
        editSeikyuusyoParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);
        editSeikyuusyoParam.setJyudkaigomaebaraiTkykhnkKbn(C_JyudkaigomaebaraiTkykhnkKbn.KAIYAKU);
        editSeikyuusyoParam.setKihonshenkouumu(C_UmuKbn.NONE);
        editSeikyuusyoParam.setTmttknitenkbn(C_Tmttknitenkbn.BLNK);
        editSeikyuusyoParam.setTmttknitenymd(null);
        editSeikyuusyoParam.setKhhrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSeikyuusyoParam.setKhskssakuseijiyuu(C_Khskssakuseijiyuu.BLNK);
        editSeikyuusyoParam.setHenkougokjnkngk(BizCurrency.valueOf(100000));

        ReportServicesBean reSsBean =  editSeikyuusyoTbl.editBean(C_SyoruiCdKbn.KK_KAIYAKU_SKS, syono16, khozenCommonParam, editSeikyuusyoParam);

        Object[] kSBean = reSsBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_KAIYAKU_SKS.getValue());

        exNumericEquals(kSBean.length, 2, "パラメータオブジェクトの要素数");

        exNumericEquals(reSsBean.getKensakuKeys().length, 1, "検索キー配列の要素数");
        exStringEquals(reSsBean.getKensakuKeys()[0], "12806345823", "検索キー");

        KhSeikyuusyoBean khSeikyuusyoBean = (KhSeikyuusyoBean)kSBean[0];

        exStringEquals(khSeikyuusyoBean.getIrSyono(), "12806345823", "（ＩＲ）証券番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinyno(), "1234567", "（ＩＲ）通信先郵便番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr1kj(), "通信先住所１", "（ＩＲ）通信先住所１（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr2kj(), "通信先住所２", "（ＩＲ）通信先住所２（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr3kj(), "通信先住所３", "（ＩＲ）通信先住所３（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsintelno(), "023-5677-8999", "（ＩＲ）通信先電話番号");
        exStringEquals(khSeikyuusyoBean.getIrBanknmkj(), "りそな銀行", "（ＩＲ）銀行名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrSitennmkj(), "", "（ＩＲ）支店名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrBankcd(), "", "（ＩＲ）銀行コード");
        exStringEquals(khSeikyuusyoBean.getIrSitencd(), "", "（ＩＲ）支店コード");

        exStringEquals(khSeikyuusyoBean.getIrKzmeiginmkn(), "口座名義人氏名口座名義人氏名", "（ＩＲ）口座名義人氏名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkj(), "契約者名", "（ＩＲ）契約者名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKkkyktdk(), C_Tdk.HGU, "（ＩＲ）契約管理契約者続柄");
        exStringEquals(khSeikyuusyoBean.getIrHhknnmkj(), "被保険者名", "（ＩＲ）被保険者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrHhknseiymd(), "", "（ＩＲ）被保険者生年月日");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseiymdhenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者生年月日変更有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknsei(), C_Hhknsei.MALE, "（ＩＲ）被保険者性別");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseihenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者性別変更有無");
        exStringEquals(khSeikyuusyoBean.getIrStdrsknmkj(), "長島", "（ＩＲ）指定代理請求人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrFatcakakuninyhkbn(), C_YouhiblnkKbn.YOU, "（ＩＲ）FATCA確認要否区分");
        exClassificationEquals(khSeikyuusyoBean.getIrAeoikakuninyhkbn(), C_YouhiblnkKbn.HUYOU, "（ＩＲ）ＡＥＯＩ確認要否区分");

        exClassificationEquals(khSeikyuusyoBean.getIrTargettkkbn(), C_TargetTkKbn.BLNK, "（ＩＲ）ターゲット特約区分");
        exNumericEquals(khSeikyuusyoBean.getIrAftertargettkmokuhyouti(), 101, "（ＩＲ）変更後ターゲット特約目標値");
        exNumericEquals(khSeikyuusyoBean.getIrBeforetargettkmokuhyouti(), 200, "（ＩＲ）変更前ターゲット特約目標値");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforekihons(), BizCurrency.valueOf(100), "（ＩＲ）基本保険金額（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkihons(),  BizCurrency.valueOf(778), "（ＩＲ）基本保険金額（変更後）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforep(), BizCurrency.valueOf(200), "（ＩＲ）保険料（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterp(), BizCurrency.valueOf(1566), "（ＩＲ）保険料（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrKyktuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）契約通貨種類");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj1(), "小野", "（ＩＲ）死亡受取人名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj2(), "", "（ＩＲ）死亡受取人名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj3(), "", "（ＩＲ）死亡受取人名（漢字）３");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj4(), "", "（ＩＲ）死亡受取人名（漢字）４");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkn(), "受取人名（カナ）", "（ＩＲ）死亡受取人名（カナ）");
        exClassificationEquals(khSeikyuusyoBean.getIrYokinkbn(), C_YokinKbn.BLNK, "（ＩＲ）預金種目区分");
        exStringEquals(khSeikyuusyoBean.getIrKouzano(), "", "（ＩＲ）口座番号");

        exClassificationEquals(khSeikyuusyoBean.getIrAfternkshrtkyknksyukbn(), C_Nstknsyu.KAKUTEINENKIN, "（ＩＲ）変更後年金支払特約年金種類区分");
        exClassificationEquals(khSeikyuusyoBean.getIrBiforenkshrtkyknksyukbn(), C_Nstknsyu.BLNK, "（ＩＲ）変更前年金支払特約年金種類区分");
        exNumericEquals(khSeikyuusyoBean.getIrAfternkshrtkyknkkkn(), 5, "（ＩＲ）変更後年金支払特約年金期間");
        exNumericEquals(khSeikyuusyoBean.getIrBeforenkshrtkyknkkkn(), 10, "（ＩＲ）変更前年金支払特約年金期間");
        exStringEquals(khSeikyuusyoBean.getIrNkuktnm(), "森君", "（ＩＲ）年金受取人名");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari1(), BizNumber.valueOf(230), "（ＩＲ）死亡受取人分割割合１");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari2(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合２");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari3(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合３");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari4(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合４");
        exClassificationEquals(khSeikyuusyoBean.getIrTargettkhnkkbn(), C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU, "（ＩＲ）ターゲット特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKaiyakujiyuu(), C_Kaiyakujiyuu.KYKSB, "（ＩＲ）解約事由");
        exClassificationEquals(khSeikyuusyoBean.getIrGengkhoukbn(), C_GengkhouKbn.SD, "（ＩＲ）減額方法区分");
        exNumericEquals(khSeikyuusyoBean.getIrSbuktnin(), 2, "（ＩＲ）死亡受取人人数");
        exClassificationEquals(khSeikyuusyoBean.getIrSbuuktkbn(), C_UktKbn.BLNK, "（ＩＲ）死亡受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrYenshrtkumu(), C_UmuKbn.ARI, "（ＩＲ）円支払特約有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHenkankinumukbn(), C_UmuKbn.ARI, "（ＩＲ）返還金有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrRstuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）領収通貨種類");
        exClassificationEquals(khSeikyuusyoBean.getIrNkshrtkykhnkkbn(), C_NstkhKbn.NAIYOUHENKOU, "（ＩＲ）年金支払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrMeigihnkjiyuu(), C_Meigihnkjiyuu.KYK, "（ＩＲ）名義変更事由");
        exClassificationEquals(khSeikyuusyoBean.getIrNkhknumu(), C_UmuKbn.ARI, "（ＩＲ）年金保険有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSiboukyhkuktumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡給付金受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn1(), C_UmuKbn.ARI, "（ＩＲ）死亡保険金受取人有無区分１");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn2(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分２");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn3(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分３");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn4(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分４");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu1(), C_UmuKbn.ARI, "（ＩＲ）死亡受取人分割割合有無１");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu2(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無２");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu3(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無３");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu4(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無４");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyhukaumu(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyuuktmukbn(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrStdruktkbn(), C_UktKbn.BLNK, "（ＩＲ）指定代理受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrJyudkaigomaebrtkykhnkkbn(),C_JyudkaigomaebaraiTkykhnkKbn.KAIYAKU, "（ＩＲ）重度介護前払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKeihikbn(),C_KeihiKbn.BLNK,"（ＩＲ）契被区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKihonshenkouumu(),C_UmuKbn.NONE,"（ＩＲ）基本Ｓ変更有無");
        exStringEquals(khSeikyuusyoBean.getIrKihonssyurui(), "給付日額", "（ＩＲ）基本Ｓ種類");
        exClassificationEquals(khSeikyuusyoBean.getIrTmttknitenkbn(), C_Tmttknitenkbn.BLNK, "（ＩＲ）積立金移転区分");
        exStringEquals(khSeikyuusyoBean.getIrTmttknitenymd(), null, "（ＩＲ）積立金移転日");
        exClassificationEquals(khSeikyuusyoBean.getIrKhhrshrjiyuu(), C_Khhrshrjiyuu.BLNK, "（ＩＲ）契約保全返戻金支払事由");
        exClassificationEquals(khSeikyuusyoBean.getIrKhskssakuseijiyuu(), C_Khskssakuseijiyuu.BLNK, "（ＩＲ）契約保全請求書作成事由");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkijyunkingaku(), BizCurrency.valueOf(100000), "（ＩＲ）基準金額（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrHrkkeiro(), C_Hrkkeiro.DANTAI, "（ＩＲ）払込経路");
        exNumericEquals(khSeikyuusyoBean.getIrSyouhnhanteikekka(), 999, "（ＩＲ）商品判定結果");
        exClassificationEquals(khSeikyuusyoBean.getIrKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "（ＩＲ）契約状態");
        exClassificationEquals(khSeikyuusyoBean.getIrZeiseitkkktkykhukaumu(), C_UmuKbn.ARI, "（ＩＲ）税制適格特約付加有無");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn1(), "", "（ＩＲ）登録家族氏名（カナ）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj1(), "", "（ＩＲ）登録家族氏名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj1(), "", "（ＩＲ）登録家族住所１（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj1(), "", "（ＩＲ）登録家族住所２（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj1(), "", "（ＩＲ）登録家族住所３（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno1(), "", "（ＩＲ）登録家族電話番号１");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi1(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn2(), "", "（ＩＲ）登録家族氏名（カナ）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj2(), "", "（ＩＲ）登録家族氏名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj2(), "", "（ＩＲ）登録家族住所１（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj2(), "", "（ＩＲ）登録家族住所２（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj2(), "", "（ＩＲ）登録家族住所３（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno2(), "", "（ＩＲ）登録家族電話番号２");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi2(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否２");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkn(), "契約者名（カナ）", "（ＩＲ）契約者名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKykdairinmkj(), "", "（ＩＲ）契約者代理人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrtkykhukaumu(), null, "（ＩＲ）契約者代理特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrMousideninkbn(), C_MousideninKbn.BLNK, "（ＩＲ）申出人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrknhatudoujyoutai(), C_KykdrknHtdjytKbn.BLNK, "（ＩＲ）契約者代理権発動状態");
        exStringEquals(khSeikyuusyoBean.getIrDrstiskkyknmkj(), "契約者名", "（ＩＲ）代理人指定先契約者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTyouhyoutitle(), null, "（ＩＲ）帳票タイトル");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg1(), null, "（ＩＲ）送付案内メッセージ１");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg2(), null, "（ＩＲ）送付案内メッセージ２");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg3(), null, "（ＩＲ）送付案内メッセージ３");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg4(), null, "（ＩＲ）送付案内メッセージ４");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg5(), null, "（ＩＲ）送付案内メッセージ５");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg6(), null, "（ＩＲ）送付案内メッセージ６");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg7(), null, "（ＩＲ）送付案内メッセージ７");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg8(), null, "（ＩＲ）送付案内メッセージ８");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg9(), null, "（ＩＲ）送付案内メッセージ９");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg10(), null, "（ＩＲ）送付案内メッセージ１０");

        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean)kSBean[1];

        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(), null, "（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(), "userId001", "（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(), "user001", "（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(), DateFormatUtil.dateKANJI(BizDate.getSysDate()), "（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(), "", "（ＩＲ）保存期間");
    }

    @Test
    @TestOrder(190)
    public void testEditBean_A19() {

        MockObjectManager.initialize();

        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;

        AM_User aMUser = new AM_User();

        aMUser.setUserId("userId001");
        aMUser.setUserNm("user001");
        changeCurrentUser(baseUserInfo, aMUser);

        editSeikyuusyoParam.setHhknseiymd(BizDate.valueOf(20151026));
        editSeikyuusyoParam.setHhknseiymdhenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setHhknsei(C_Hhknsei.MALE);
        editSeikyuusyoParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setBfrTargettkmokuhyouti(BizNumber.valueOf(101));
        editSeikyuusyoParam.setBfrKihonS(BizCurrency.valueOf(778));
        editSeikyuusyoParam.setBfrP(BizCurrency.valueOf(1566));
        editSeikyuusyoParam.setBfrTokuyakuNenkinsyuKbn(C_Nstknsyu.KAKUTEINENKIN);
        editSeikyuusyoParam.setBfrNkshrtkyknksyukkn(5);
        editSeikyuusyoParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU);
        editSeikyuusyoParam.setKaiyakujiyuu(C_Kaiyakujiyuu.KYKSB);
        editSeikyuusyoParam.setGengkhouKbn(C_GengkhouKbn.SD);
        editSeikyuusyoParam.setHenkankumukbn(C_UmuKbn.ARI);
        editSeikyuusyoParam.setRstuukasyu(C_Tuukasyu.JPY);
        editSeikyuusyoParam.setNkshrtkykhnkkbn(C_NstkhKbn.NAIYOUHENKOU);
        editSeikyuusyoParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);
        editSeikyuusyoParam.setJyudkaigomaebaraiTkykhnkKbn(C_JyudkaigomaebaraiTkykhnkKbn.KAIYAKU);
        editSeikyuusyoParam.setKihonshenkouumu(C_UmuKbn.NONE);
        editSeikyuusyoParam.setTmttknitenkbn(C_Tmttknitenkbn.BLNK);
        editSeikyuusyoParam.setTmttknitenymd(null);
        editSeikyuusyoParam.setKhhrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSeikyuusyoParam.setKhskssakuseijiyuu(C_Khskssakuseijiyuu.BLNK);
        editSeikyuusyoParam.setHenkougokjnkngk(BizCurrency.valueOf(100000));

        ReportServicesBean reSsBean =  editSeikyuusyoTbl.editBean(C_SyoruiCdKbn.KK_MEIGIHNK_SKS, syono16, khozenCommonParam, editSeikyuusyoParam);

        Object[] kSBean = reSsBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_MEIGIHNK_SKS.getValue());

        exNumericEquals(kSBean.length, 2, "パラメータオブジェクトの要素数");

        exNumericEquals(reSsBean.getKensakuKeys().length, 1, "検索キー配列の要素数");
        exStringEquals(reSsBean.getKensakuKeys()[0], "12806345823", "検索キー");

        KhSeikyuusyoBean khSeikyuusyoBean = (KhSeikyuusyoBean)kSBean[0];

        exStringEquals(khSeikyuusyoBean.getIrSyono(), "12806345823", "（ＩＲ）証券番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinyno(), "1234567", "（ＩＲ）通信先郵便番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr1kj(), "通信先住所１", "（ＩＲ）通信先住所１（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr2kj(), "通信先住所２", "（ＩＲ）通信先住所２（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr3kj(), "通信先住所３", "（ＩＲ）通信先住所３（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsintelno(), "023-5677-8999", "（ＩＲ）通信先電話番号");
        exStringEquals(khSeikyuusyoBean.getIrBanknmkj(), "", "（ＩＲ）銀行名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrSitennmkj(), "", "（ＩＲ）支店名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrBankcd(), "", "（ＩＲ）銀行コード");
        exStringEquals(khSeikyuusyoBean.getIrSitencd(), "", "（ＩＲ）支店コード");

        exStringEquals(khSeikyuusyoBean.getIrKzmeiginmkn(), "", "（ＩＲ）口座名義人氏名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkj(), "契約者名", "（ＩＲ）契約者名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKkkyktdk(), C_Tdk.HGU, "（ＩＲ）契約管理契約者続柄");
        exStringEquals(khSeikyuusyoBean.getIrHhknnmkj(), "被保険者名", "（ＩＲ）被保険者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrHhknseiymd(), "", "（ＩＲ）被保険者生年月日");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseiymdhenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者生年月日変更有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknsei(), C_Hhknsei.MALE, "（ＩＲ）被保険者性別");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseihenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者性別変更有無");
        exStringEquals(khSeikyuusyoBean.getIrStdrsknmkj(), "長島", "（ＩＲ）指定代理請求人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrFatcakakuninyhkbn(), C_YouhiblnkKbn.YOU, "（ＩＲ）FATCA確認要否区分");
        exClassificationEquals(khSeikyuusyoBean.getIrAeoikakuninyhkbn(), C_YouhiblnkKbn.HUYOU, "（ＩＲ）ＡＥＯＩ確認要否区分");

        exClassificationEquals(khSeikyuusyoBean.getIrTargettkkbn(), C_TargetTkKbn.BLNK, "（ＩＲ）ターゲット特約区分");
        exNumericEquals(khSeikyuusyoBean.getIrAftertargettkmokuhyouti(), 101, "（ＩＲ）変更後ターゲット特約目標値");
        exNumericEquals(khSeikyuusyoBean.getIrBeforetargettkmokuhyouti(), 200, "（ＩＲ）変更前ターゲット特約目標値");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforekihons(), BizCurrency.valueOf(100), "（ＩＲ）基本保険金額（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkihons(),  BizCurrency.valueOf(778), "（ＩＲ）基本保険金額（変更後）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforep(), BizCurrency.valueOf(200), "（ＩＲ）保険料（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterp(), BizCurrency.valueOf(1566), "（ＩＲ）保険料（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrKyktuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）契約通貨種類");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj1(), "小野", "（ＩＲ）死亡受取人名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj2(), "", "（ＩＲ）死亡受取人名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj3(), "", "（ＩＲ）死亡受取人名（漢字）３");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj4(), "", "（ＩＲ）死亡受取人名（漢字）４");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkn(), "受取人名（カナ）", "（ＩＲ）死亡受取人名（カナ）");
        exClassificationEquals(khSeikyuusyoBean.getIrYokinkbn(), C_YokinKbn.BLNK, "（ＩＲ）預金種目区分");
        exStringEquals(khSeikyuusyoBean.getIrKouzano(), "", "（ＩＲ）口座番号");

        exClassificationEquals(khSeikyuusyoBean.getIrAfternkshrtkyknksyukbn(), C_Nstknsyu.KAKUTEINENKIN, "（ＩＲ）変更後年金支払特約年金種類区分");
        exClassificationEquals(khSeikyuusyoBean.getIrBiforenkshrtkyknksyukbn(), C_Nstknsyu.BLNK, "（ＩＲ）変更前年金支払特約年金種類区分");
        exNumericEquals(khSeikyuusyoBean.getIrAfternkshrtkyknkkkn(), 5, "（ＩＲ）変更後年金支払特約年金期間");
        exNumericEquals(khSeikyuusyoBean.getIrBeforenkshrtkyknkkkn(), 10, "（ＩＲ）変更前年金支払特約年金期間");
        exStringEquals(khSeikyuusyoBean.getIrNkuktnm(), "森君", "（ＩＲ）年金受取人名");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari1(), BizNumber.valueOf(230), "（ＩＲ）死亡受取人分割割合１");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari2(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合２");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari3(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合３");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari4(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合４");
        exClassificationEquals(khSeikyuusyoBean.getIrTargettkhnkkbn(), C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU, "（ＩＲ）ターゲット特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKaiyakujiyuu(), C_Kaiyakujiyuu.KYKSB, "（ＩＲ）解約事由");
        exClassificationEquals(khSeikyuusyoBean.getIrGengkhoukbn(), C_GengkhouKbn.SD, "（ＩＲ）減額方法区分");
        exNumericEquals(khSeikyuusyoBean.getIrSbuktnin(), 2, "（ＩＲ）死亡受取人人数");
        exClassificationEquals(khSeikyuusyoBean.getIrSbuuktkbn(), C_UktKbn.BLNK, "（ＩＲ）死亡受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrYenshrtkumu(), C_UmuKbn.ARI, "（ＩＲ）円支払特約有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHenkankinumukbn(), C_UmuKbn.ARI, "（ＩＲ）返還金有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrRstuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）領収通貨種類");
        exClassificationEquals(khSeikyuusyoBean.getIrNkshrtkykhnkkbn(), C_NstkhKbn.NAIYOUHENKOU, "（ＩＲ）年金支払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrMeigihnkjiyuu(), C_Meigihnkjiyuu.KYK, "（ＩＲ）名義変更事由");
        exClassificationEquals(khSeikyuusyoBean.getIrNkhknumu(), C_UmuKbn.ARI, "（ＩＲ）年金保険有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSiboukyhkuktumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡給付金受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn1(), C_UmuKbn.ARI, "（ＩＲ）死亡保険金受取人有無区分１");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn2(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分２");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn3(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分３");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn4(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分４");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu1(), C_UmuKbn.ARI, "（ＩＲ）死亡受取人分割割合有無１");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu2(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無２");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu3(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無３");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu4(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無４");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyhukaumu(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyuuktmukbn(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrStdruktkbn(), C_UktKbn.BLNK, "（ＩＲ）指定代理受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrJyudkaigomaebrtkykhnkkbn(),C_JyudkaigomaebaraiTkykhnkKbn.KAIYAKU, "（ＩＲ）重度介護前払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKeihikbn(),C_KeihiKbn.BLNK,"（ＩＲ）契被区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKihonshenkouumu(),C_UmuKbn.NONE,"（ＩＲ）基本Ｓ変更有無");
        exStringEquals(khSeikyuusyoBean.getIrKihonssyurui(), "給付日額", "（ＩＲ）基本Ｓ種類");
        exClassificationEquals(khSeikyuusyoBean.getIrTmttknitenkbn(), C_Tmttknitenkbn.BLNK, "（ＩＲ）積立金移転区分");
        exStringEquals(khSeikyuusyoBean.getIrTmttknitenymd(), null, "（ＩＲ）積立金移転日");
        exClassificationEquals(khSeikyuusyoBean.getIrKhhrshrjiyuu(), C_Khhrshrjiyuu.BLNK, "（ＩＲ）契約保全返戻金支払事由");
        exClassificationEquals(khSeikyuusyoBean.getIrKhskssakuseijiyuu(), C_Khskssakuseijiyuu.BLNK, "（ＩＲ）契約保全請求書作成事由");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkijyunkingaku(), BizCurrency.valueOf(100000), "（ＩＲ）基準金額（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrHrkkeiro(), C_Hrkkeiro.DANTAI, "（ＩＲ）払込経路");
        exNumericEquals(khSeikyuusyoBean.getIrSyouhnhanteikekka(), 999, "（ＩＲ）商品判定結果");
        exClassificationEquals(khSeikyuusyoBean.getIrKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "（ＩＲ）契約状態");
        exClassificationEquals(khSeikyuusyoBean.getIrZeiseitkkktkykhukaumu(), C_UmuKbn.ARI, "（ＩＲ）税制適格特約付加有無");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn1(), "", "（ＩＲ）登録家族氏名（カナ）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj1(), "", "（ＩＲ）登録家族氏名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj1(), "", "（ＩＲ）登録家族住所１（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj1(), "", "（ＩＲ）登録家族住所２（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj1(), "", "（ＩＲ）登録家族住所３（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno1(), "", "（ＩＲ）登録家族電話番号１");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi1(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn2(), "", "（ＩＲ）登録家族氏名（カナ）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj2(), "", "（ＩＲ）登録家族氏名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj2(), "", "（ＩＲ）登録家族住所１（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj2(), "", "（ＩＲ）登録家族住所２（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj2(), "", "（ＩＲ）登録家族住所３（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno2(), "", "（ＩＲ）登録家族電話番号２");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi2(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否２");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkn(), "契約者名（カナ）", "（ＩＲ）契約者名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKykdairinmkj(), "", "（ＩＲ）契約者代理人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrtkykhukaumu(), null, "（ＩＲ）契約者代理特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrMousideninkbn(), C_MousideninKbn.BLNK, "（ＩＲ）申出人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrknhatudoujyoutai(), C_KykdrknHtdjytKbn.BLNK, "（ＩＲ）契約者代理権発動状態");
        exStringEquals(khSeikyuusyoBean.getIrDrstiskkyknmkj(), "契約者名", "（ＩＲ）代理人指定先契約者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTyouhyoutitle(), null, "（ＩＲ）帳票タイトル");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg1(), null, "（ＩＲ）送付案内メッセージ１");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg2(), null, "（ＩＲ）送付案内メッセージ２");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg3(), null, "（ＩＲ）送付案内メッセージ３");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg4(), null, "（ＩＲ）送付案内メッセージ４");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg5(), null, "（ＩＲ）送付案内メッセージ５");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg6(), null, "（ＩＲ）送付案内メッセージ６");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg7(), null, "（ＩＲ）送付案内メッセージ７");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg8(), null, "（ＩＲ）送付案内メッセージ８");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg9(), null, "（ＩＲ）送付案内メッセージ９");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg10(), null, "（ＩＲ）送付案内メッセージ１０");

        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean)kSBean[1];

        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(), null, "（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(), "userId001", "（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(), "user001", "（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(), DateFormatUtil.dateKANJI(BizDate.getSysDate()), "（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(), "3 年", "（ＩＲ）保存期間");
    }

    @Test
    @TestOrder(200)
    public void testEditBean_A20() {

        MockObjectManager.initialize();

        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;

        AM_User aMUser = new AM_User();

        aMUser.setUserId("userId001");
        aMUser.setUserNm("user001");
        changeCurrentUser(baseUserInfo, aMUser);

        editSeikyuusyoParam.setHhknseiymd(BizDate.valueOf(20151026));
        editSeikyuusyoParam.setHhknseiymdhenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setHhknsei(C_Hhknsei.MALE);
        editSeikyuusyoParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setBfrTargettkmokuhyouti(BizNumber.valueOf(101));
        editSeikyuusyoParam.setBfrKihonS(BizCurrency.valueOf(778));
        editSeikyuusyoParam.setBfrP(BizCurrency.valueOf(1566));
        editSeikyuusyoParam.setBfrTokuyakuNenkinsyuKbn(C_Nstknsyu.KAKUTEINENKIN);
        editSeikyuusyoParam.setBfrNkshrtkyknksyukkn(5);
        editSeikyuusyoParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU);
        editSeikyuusyoParam.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editSeikyuusyoParam.setGengkhouKbn(C_GengkhouKbn.SD);
        editSeikyuusyoParam.setHenkankumukbn(C_UmuKbn.ARI);
        editSeikyuusyoParam.setRstuukasyu(C_Tuukasyu.JPY);
        editSeikyuusyoParam.setNkshrtkykhnkkbn(C_NstkhKbn.NAIYOUHENKOU);
        editSeikyuusyoParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);
        editSeikyuusyoParam.setJyudkaigomaebaraiTkykhnkKbn(C_JyudkaigomaebaraiTkykhnkKbn.KAIYAKU);
        editSeikyuusyoParam.setKihonshenkouumu(C_UmuKbn.NONE);
        editSeikyuusyoParam.setTmttknitenkbn(C_Tmttknitenkbn.BLNK);
        editSeikyuusyoParam.setTmttknitenymd(null);
        editSeikyuusyoParam.setKhhrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSeikyuusyoParam.setKhskssakuseijiyuu(C_Khskssakuseijiyuu.BLNK);
        editSeikyuusyoParam.setHenkougokjnkngk(BizCurrency.valueOf(100000));

        ReportServicesBean reSsBean =  editSeikyuusyoTbl.editBean(C_SyoruiCdKbn.KK_SYOSAIHK_SKS, syono16, khozenCommonParam, editSeikyuusyoParam);

        Object[] kSBean = reSsBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_SYOSAIHK_SKS.getValue());

        exNumericEquals(kSBean.length, 2, "パラメータオブジェクトの要素数");

        exNumericEquals(reSsBean.getKensakuKeys().length, 1, "検索キー配列の要素数");
        exStringEquals(reSsBean.getKensakuKeys()[0], "12806345823", "検索キー");

        KhSeikyuusyoBean khSeikyuusyoBean = (KhSeikyuusyoBean)kSBean[0];

        exStringEquals(khSeikyuusyoBean.getIrSyono(), "12806345823", "（ＩＲ）証券番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinyno(), "1234567", "（ＩＲ）通信先郵便番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr1kj(), "通信先住所１", "（ＩＲ）通信先住所１（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr2kj(), "通信先住所２", "（ＩＲ）通信先住所２（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr3kj(), "通信先住所３", "（ＩＲ）通信先住所３（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsintelno(), "023-5677-8999", "（ＩＲ）通信先電話番号");
        exStringEquals(khSeikyuusyoBean.getIrBanknmkj(), "", "（ＩＲ）銀行名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrSitennmkj(), "", "（ＩＲ）支店名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrBankcd(), "", "（ＩＲ）銀行コード");
        exStringEquals(khSeikyuusyoBean.getIrSitencd(), "", "（ＩＲ）支店コード");

        exStringEquals(khSeikyuusyoBean.getIrKzmeiginmkn(), "", "（ＩＲ）口座名義人氏名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkj(), "契約者名", "（ＩＲ）契約者名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKkkyktdk(), C_Tdk.HGU, "（ＩＲ）契約管理契約者続柄");
        exStringEquals(khSeikyuusyoBean.getIrHhknnmkj(), "被保険者名", "（ＩＲ）被保険者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrHhknseiymd(), "", "（ＩＲ）被保険者生年月日");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseiymdhenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者生年月日変更有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknsei(), C_Hhknsei.MALE, "（ＩＲ）被保険者性別");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseihenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者性別変更有無");
        exStringEquals(khSeikyuusyoBean.getIrStdrsknmkj(), "長島", "（ＩＲ）指定代理請求人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrFatcakakuninyhkbn(), C_YouhiblnkKbn.HUYOU, "（ＩＲ）FATCA確認要否区分");
        exClassificationEquals(khSeikyuusyoBean.getIrAeoikakuninyhkbn(), C_YouhiblnkKbn.HUYOU, "（ＩＲ）ＡＥＯＩ確認要否区分");

        exClassificationEquals(khSeikyuusyoBean.getIrTargettkkbn(), C_TargetTkKbn.BLNK, "（ＩＲ）ターゲット特約区分");
        exNumericEquals(khSeikyuusyoBean.getIrAftertargettkmokuhyouti(), 101, "（ＩＲ）変更後ターゲット特約目標値");
        exNumericEquals(khSeikyuusyoBean.getIrBeforetargettkmokuhyouti(), 200, "（ＩＲ）変更前ターゲット特約目標値");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforekihons(), BizCurrency.valueOf(100), "（ＩＲ）基本保険金額（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkihons(),  BizCurrency.valueOf(778), "（ＩＲ）基本保険金額（変更後）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforep(), BizCurrency.valueOf(200), "（ＩＲ）保険料（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterp(), BizCurrency.valueOf(1566), "（ＩＲ）保険料（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrKyktuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）契約通貨種類");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj1(), "小野", "（ＩＲ）死亡受取人名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj2(), "", "（ＩＲ）死亡受取人名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj3(), "", "（ＩＲ）死亡受取人名（漢字）３");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj4(), "", "（ＩＲ）死亡受取人名（漢字）４");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkn(), "受取人名（カナ）", "（ＩＲ）死亡受取人名（カナ）");
        exClassificationEquals(khSeikyuusyoBean.getIrYokinkbn(), C_YokinKbn.BLNK, "（ＩＲ）預金種目区分");
        exStringEquals(khSeikyuusyoBean.getIrKouzano(), "", "（ＩＲ）口座番号");

        exClassificationEquals(khSeikyuusyoBean.getIrAfternkshrtkyknksyukbn(), C_Nstknsyu.KAKUTEINENKIN, "（ＩＲ）変更後年金支払特約年金種類区分");
        exClassificationEquals(khSeikyuusyoBean.getIrBiforenkshrtkyknksyukbn(), C_Nstknsyu.BLNK, "（ＩＲ）変更前年金支払特約年金種類区分");
        exNumericEquals(khSeikyuusyoBean.getIrAfternkshrtkyknkkkn(), 5, "（ＩＲ）変更後年金支払特約年金期間");
        exNumericEquals(khSeikyuusyoBean.getIrBeforenkshrtkyknkkkn(), 10, "（ＩＲ）変更前年金支払特約年金期間");
        exStringEquals(khSeikyuusyoBean.getIrNkuktnm(), "森君", "（ＩＲ）年金受取人名");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari1(), BizNumber.valueOf(230), "（ＩＲ）死亡受取人分割割合１");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari2(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合２");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari3(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合３");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari4(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合４");
        exClassificationEquals(khSeikyuusyoBean.getIrTargettkhnkkbn(), C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU, "（ＩＲ）ターゲット特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKaiyakujiyuu(), C_Kaiyakujiyuu.TUUJYOU, "（ＩＲ）解約事由");
        exClassificationEquals(khSeikyuusyoBean.getIrGengkhoukbn(), C_GengkhouKbn.SD, "（ＩＲ）減額方法区分");
        exNumericEquals(khSeikyuusyoBean.getIrSbuktnin(), 2, "（ＩＲ）死亡受取人人数");
        exClassificationEquals(khSeikyuusyoBean.getIrSbuuktkbn(), C_UktKbn.BLNK, "（ＩＲ）死亡受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrYenshrtkumu(), C_UmuKbn.ARI, "（ＩＲ）円支払特約有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHenkankinumukbn(), C_UmuKbn.ARI, "（ＩＲ）返還金有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrRstuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）領収通貨種類");
        exClassificationEquals(khSeikyuusyoBean.getIrNkshrtkykhnkkbn(), C_NstkhKbn.NAIYOUHENKOU, "（ＩＲ）年金支払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrMeigihnkjiyuu(), C_Meigihnkjiyuu.KYK, "（ＩＲ）名義変更事由");
        exClassificationEquals(khSeikyuusyoBean.getIrNkhknumu(), C_UmuKbn.ARI, "（ＩＲ）年金保険有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSiboukyhkuktumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡給付金受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn1(), C_UmuKbn.ARI, "（ＩＲ）死亡保険金受取人有無区分１");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn2(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分２");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn3(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分３");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn4(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分４");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu1(), C_UmuKbn.ARI, "（ＩＲ）死亡受取人分割割合有無１");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu2(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無２");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu3(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無３");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu4(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無４");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyhukaumu(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyuuktmukbn(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrStdruktkbn(), C_UktKbn.BLNK, "（ＩＲ）指定代理受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrJyudkaigomaebrtkykhnkkbn(),C_JyudkaigomaebaraiTkykhnkKbn.KAIYAKU, "（ＩＲ）重度介護前払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKeihikbn(),C_KeihiKbn.BLNK,"（ＩＲ）契被区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKihonshenkouumu(),C_UmuKbn.NONE,"（ＩＲ）基本Ｓ変更有無");
        exStringEquals(khSeikyuusyoBean.getIrKihonssyurui(), "給付日額", "（ＩＲ）基本Ｓ種類");
        exClassificationEquals(khSeikyuusyoBean.getIrTmttknitenkbn(), C_Tmttknitenkbn.BLNK, "（ＩＲ）積立金移転区分");
        exStringEquals(khSeikyuusyoBean.getIrTmttknitenymd(), null, "（ＩＲ）積立金移転日");
        exClassificationEquals(khSeikyuusyoBean.getIrKhhrshrjiyuu(), C_Khhrshrjiyuu.BLNK, "（ＩＲ）契約保全返戻金支払事由");
        exClassificationEquals(khSeikyuusyoBean.getIrKhskssakuseijiyuu(), C_Khskssakuseijiyuu.BLNK, "（ＩＲ）契約保全請求書作成事由");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkijyunkingaku(), BizCurrency.valueOf(100000), "（ＩＲ）基準金額（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrHrkkeiro(), C_Hrkkeiro.DANTAI, "（ＩＲ）払込経路");
        exNumericEquals(khSeikyuusyoBean.getIrSyouhnhanteikekka(), 999, "（ＩＲ）商品判定結果");
        exClassificationEquals(khSeikyuusyoBean.getIrKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "（ＩＲ）契約状態");
        exClassificationEquals(khSeikyuusyoBean.getIrZeiseitkkktkykhukaumu(), C_UmuKbn.ARI, "（ＩＲ）税制適格特約付加有無");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn1(), "", "（ＩＲ）登録家族氏名（カナ）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj1(), "", "（ＩＲ）登録家族氏名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj1(), "", "（ＩＲ）登録家族住所１（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj1(), "", "（ＩＲ）登録家族住所２（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj1(), "", "（ＩＲ）登録家族住所３（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno1(), "", "（ＩＲ）登録家族電話番号１");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi1(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn2(), "", "（ＩＲ）登録家族氏名（カナ）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj2(), "", "（ＩＲ）登録家族氏名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj2(), "", "（ＩＲ）登録家族住所１（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj2(), "", "（ＩＲ）登録家族住所２（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj2(), "", "（ＩＲ）登録家族住所３（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno2(), "", "（ＩＲ）登録家族電話番号２");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi2(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否２");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkn(), "契約者名（カナ）", "（ＩＲ）契約者名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKykdairinmkj(), "", "（ＩＲ）契約者代理人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrtkykhukaumu(), null, "（ＩＲ）契約者代理特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrMousideninkbn(), C_MousideninKbn.BLNK, "（ＩＲ）申出人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrknhatudoujyoutai(), C_KykdrknHtdjytKbn.BLNK, "（ＩＲ）契約者代理権発動状態");
        exStringEquals(khSeikyuusyoBean.getIrDrstiskkyknmkj(), "契約者名", "（ＩＲ）代理人指定先契約者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTyouhyoutitle(), null, "（ＩＲ）帳票タイトル");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg1(), null, "（ＩＲ）送付案内メッセージ１");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg2(), null, "（ＩＲ）送付案内メッセージ２");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg3(), null, "（ＩＲ）送付案内メッセージ３");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg4(), null, "（ＩＲ）送付案内メッセージ４");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg5(), null, "（ＩＲ）送付案内メッセージ５");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg6(), null, "（ＩＲ）送付案内メッセージ６");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg7(), null, "（ＩＲ）送付案内メッセージ７");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg8(), null, "（ＩＲ）送付案内メッセージ８");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg9(), null, "（ＩＲ）送付案内メッセージ９");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg10(), null, "（ＩＲ）送付案内メッセージ１０");

        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean)kSBean[1];

        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(), null, "（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(), "userId001", "（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(), "user001", "（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(), DateFormatUtil.dateKANJI(BizDate.getSysDate()), "（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(), "　消滅後 3ヵ月", "（ＩＲ）保存期間");
    }

    @Test
    @TestOrder(210)
    public void testEditBean_A21() {

        MockObjectManager.initialize();

        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;

        AM_User aMUser = new AM_User();

        aMUser.setUserId("userId001");
        aMUser.setUserNm("user001");

        changeCurrentUser(baseUserInfo, aMUser);

        editSeikyuusyoParam.setHhknseiymd(BizDate.valueOf(20151026));
        editSeikyuusyoParam.setHhknseiymdhenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setHhknsei(C_Hhknsei.MALE);
        editSeikyuusyoParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setBfrTargettkmokuhyouti(BizNumber.valueOf(101));
        editSeikyuusyoParam.setBfrKihonS(BizCurrency.valueOf(778));
        editSeikyuusyoParam.setBfrP(BizCurrency.valueOf(1566));
        editSeikyuusyoParam.setBfrTokuyakuNenkinsyuKbn(C_Nstknsyu.KAKUTEINENKIN);
        editSeikyuusyoParam.setBfrNkshrtkyknksyukkn(5);
        editSeikyuusyoParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU);
        editSeikyuusyoParam.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editSeikyuusyoParam.setGengkhouKbn(C_GengkhouKbn.SD);
        editSeikyuusyoParam.setHenkankumukbn(C_UmuKbn.ARI);
        editSeikyuusyoParam.setRstuukasyu(C_Tuukasyu.JPY);
        editSeikyuusyoParam.setNkshrtkykhnkkbn(C_NstkhKbn.NAIYOUHENKOU);
        editSeikyuusyoParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);
        editSeikyuusyoParam.setJyudkaigomaebaraiTkykhnkKbn(C_JyudkaigomaebaraiTkykhnkKbn.KAIYAKU);
        editSeikyuusyoParam.setKihonshenkouumu(C_UmuKbn.NONE);
        editSeikyuusyoParam.setTmttknitenkbn(C_Tmttknitenkbn.BLNK);
        editSeikyuusyoParam.setTmttknitenymd(null);
        editSeikyuusyoParam.setKhhrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSeikyuusyoParam.setKhskssakuseijiyuu(C_Khskssakuseijiyuu.BLNK);
        editSeikyuusyoParam.setHenkougokjnkngk(BizCurrency.valueOf(100000));

        ReportServicesBean reSsBean =  editSeikyuusyoTbl.editBean(C_SyoruiCdKbn.KK_STDRHNK_SKS, syono16, khozenCommonParam, editSeikyuusyoParam);

        Object[] kSBean = reSsBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_STDRHNK_SKS.getValue());

        exNumericEquals(kSBean.length, 2, "パラメータオブジェクトの要素数");

        exNumericEquals(reSsBean.getKensakuKeys().length, 1, "検索キー配列の要素数");
        exStringEquals(reSsBean.getKensakuKeys()[0], "12806345823", "検索キー");

        KhSeikyuusyoBean khSeikyuusyoBean = (KhSeikyuusyoBean)kSBean[0];

        exStringEquals(khSeikyuusyoBean.getIrSyono(), "12806345823", "（ＩＲ）証券番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinyno(), "1234567", "（ＩＲ）通信先郵便番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr1kj(), "通信先住所１", "（ＩＲ）通信先住所１（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr2kj(), "通信先住所２", "（ＩＲ）通信先住所２（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr3kj(), "通信先住所３", "（ＩＲ）通信先住所３（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsintelno(), "023-5677-8999", "（ＩＲ）通信先電話番号");
        exStringEquals(khSeikyuusyoBean.getIrBanknmkj(), "", "（ＩＲ）銀行名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrSitennmkj(), "", "（ＩＲ）支店名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrBankcd(), "", "（ＩＲ）銀行コード");
        exStringEquals(khSeikyuusyoBean.getIrSitencd(), "", "（ＩＲ）支店コード");

        exStringEquals(khSeikyuusyoBean.getIrKzmeiginmkn(), "", "（ＩＲ）口座名義人氏名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkj(), "契約者名", "（ＩＲ）契約者名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKkkyktdk(), C_Tdk.HGU, "（ＩＲ）契約管理契約者続柄");
        exStringEquals(khSeikyuusyoBean.getIrHhknnmkj(), "被保険者名", "（ＩＲ）被保険者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrHhknseiymd(), "", "（ＩＲ）被保険者生年月日");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseiymdhenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者生年月日変更有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknsei(), C_Hhknsei.MALE, "（ＩＲ）被保険者性別");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseihenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者性別変更有無");
        exStringEquals(khSeikyuusyoBean.getIrStdrsknmkj(), "長島", "（ＩＲ）指定代理請求人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrFatcakakuninyhkbn(), C_YouhiblnkKbn.HUYOU, "（ＩＲ）FATCA確認要否区分");
        exClassificationEquals(khSeikyuusyoBean.getIrAeoikakuninyhkbn(), C_YouhiblnkKbn.HUYOU, "（ＩＲ）ＡＥＯＩ確認要否区分");

        exClassificationEquals(khSeikyuusyoBean.getIrTargettkkbn(), C_TargetTkKbn.BLNK, "（ＩＲ）ターゲット特約区分");
        exNumericEquals(khSeikyuusyoBean.getIrAftertargettkmokuhyouti(), 101, "（ＩＲ）変更後ターゲット特約目標値");
        exNumericEquals(khSeikyuusyoBean.getIrBeforetargettkmokuhyouti(), 200, "（ＩＲ）変更前ターゲット特約目標値");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforekihons(), BizCurrency.valueOf(100), "（ＩＲ）基本保険金額（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkihons(),  BizCurrency.valueOf(778), "（ＩＲ）基本保険金額（変更後）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforep(), BizCurrency.valueOf(200), "（ＩＲ）保険料（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterp(), BizCurrency.valueOf(1566), "（ＩＲ）保険料（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrKyktuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）契約通貨種類");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj1(), "小野", "（ＩＲ）死亡受取人名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj2(), "", "（ＩＲ）死亡受取人名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj3(), "", "（ＩＲ）死亡受取人名（漢字）３");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj4(), "", "（ＩＲ）死亡受取人名（漢字）４");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkn(), "受取人名（カナ）", "（ＩＲ）死亡受取人名（カナ）");
        exClassificationEquals(khSeikyuusyoBean.getIrYokinkbn(), C_YokinKbn.BLNK, "（ＩＲ）預金種目区分");
        exStringEquals(khSeikyuusyoBean.getIrKouzano(), "", "（ＩＲ）口座番号");

        exClassificationEquals(khSeikyuusyoBean.getIrAfternkshrtkyknksyukbn(), C_Nstknsyu.KAKUTEINENKIN, "（ＩＲ）変更後年金支払特約年金種類区分");
        exClassificationEquals(khSeikyuusyoBean.getIrBiforenkshrtkyknksyukbn(), C_Nstknsyu.BLNK, "（ＩＲ）変更前年金支払特約年金種類区分");
        exNumericEquals(khSeikyuusyoBean.getIrAfternkshrtkyknkkkn(), 5, "（ＩＲ）変更後年金支払特約年金期間");
        exNumericEquals(khSeikyuusyoBean.getIrBeforenkshrtkyknkkkn(), 10, "（ＩＲ）変更前年金支払特約年金期間");
        exStringEquals(khSeikyuusyoBean.getIrNkuktnm(), "森君", "（ＩＲ）年金受取人名");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari1(), BizNumber.valueOf(230), "（ＩＲ）死亡受取人分割割合１");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari2(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合２");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari3(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合３");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari4(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合４");
        exClassificationEquals(khSeikyuusyoBean.getIrTargettkhnkkbn(), C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU, "（ＩＲ）ターゲット特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKaiyakujiyuu(), C_Kaiyakujiyuu.TUUJYOU, "（ＩＲ）解約事由");
        exClassificationEquals(khSeikyuusyoBean.getIrGengkhoukbn(), C_GengkhouKbn.SD, "（ＩＲ）減額方法区分");
        exNumericEquals(khSeikyuusyoBean.getIrSbuktnin(), 2, "（ＩＲ）死亡受取人人数");
        exClassificationEquals(khSeikyuusyoBean.getIrSbuuktkbn(), C_UktKbn.BLNK, "（ＩＲ）死亡受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrYenshrtkumu(), C_UmuKbn.ARI, "（ＩＲ）円支払特約有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHenkankinumukbn(), C_UmuKbn.ARI, "（ＩＲ）返還金有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrRstuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）領収通貨種類");
        exClassificationEquals(khSeikyuusyoBean.getIrNkshrtkykhnkkbn(), C_NstkhKbn.NAIYOUHENKOU, "（ＩＲ）年金支払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrMeigihnkjiyuu(), C_Meigihnkjiyuu.KYK, "（ＩＲ）名義変更事由");
        exClassificationEquals(khSeikyuusyoBean.getIrNkhknumu(), C_UmuKbn.ARI, "（ＩＲ）年金保険有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSiboukyhkuktumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡給付金受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn1(), C_UmuKbn.ARI, "（ＩＲ）死亡保険金受取人有無区分１");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn2(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分２");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn3(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分３");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn4(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分４");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu1(), C_UmuKbn.ARI, "（ＩＲ）死亡受取人分割割合有無１");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu2(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無２");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu3(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無３");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu4(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無４");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyhukaumu(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyuuktmukbn(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrStdruktkbn(), C_UktKbn.BLNK, "（ＩＲ）指定代理受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrJyudkaigomaebrtkykhnkkbn(),C_JyudkaigomaebaraiTkykhnkKbn.KAIYAKU, "（ＩＲ）重度介護前払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKeihikbn(),C_KeihiKbn.BLNK,"（ＩＲ）契被区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKihonshenkouumu(),C_UmuKbn.NONE,"（ＩＲ）基本Ｓ変更有無");
        exStringEquals(khSeikyuusyoBean.getIrKihonssyurui(), "給付日額", "（ＩＲ）基本Ｓ種類");
        exClassificationEquals(khSeikyuusyoBean.getIrTmttknitenkbn(), C_Tmttknitenkbn.BLNK, "（ＩＲ）積立金移転区分");
        exStringEquals(khSeikyuusyoBean.getIrTmttknitenymd(), null, "（ＩＲ）積立金移転日");
        exClassificationEquals(khSeikyuusyoBean.getIrKhhrshrjiyuu(), C_Khhrshrjiyuu.BLNK, "（ＩＲ）契約保全返戻金支払事由");
        exClassificationEquals(khSeikyuusyoBean.getIrKhskssakuseijiyuu(), C_Khskssakuseijiyuu.BLNK, "（ＩＲ）契約保全請求書作成事由");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkijyunkingaku(), BizCurrency.valueOf(100000), "（ＩＲ）基準金額（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrHrkkeiro(), C_Hrkkeiro.DANTAI, "（ＩＲ）払込経路");
        exNumericEquals(khSeikyuusyoBean.getIrSyouhnhanteikekka(), 999, "（ＩＲ）商品判定結果");
        exClassificationEquals(khSeikyuusyoBean.getIrKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "（ＩＲ）契約状態");
        exClassificationEquals(khSeikyuusyoBean.getIrZeiseitkkktkykhukaumu(), C_UmuKbn.ARI, "（ＩＲ）税制適格特約付加有無");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn1(), "", "（ＩＲ）登録家族氏名（カナ）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj1(), "", "（ＩＲ）登録家族氏名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj1(), "", "（ＩＲ）登録家族住所１（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj1(), "", "（ＩＲ）登録家族住所２（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj1(), "", "（ＩＲ）登録家族住所３（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno1(), "", "（ＩＲ）登録家族電話番号１");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi1(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn2(), "", "（ＩＲ）登録家族氏名（カナ）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj2(), "", "（ＩＲ）登録家族氏名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj2(), "", "（ＩＲ）登録家族住所１（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj2(), "", "（ＩＲ）登録家族住所２（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj2(), "", "（ＩＲ）登録家族住所３（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno2(), "", "（ＩＲ）登録家族電話番号２");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi2(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否２");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkn(), "契約者名（カナ）", "（ＩＲ）契約者名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKykdairinmkj(), "", "（ＩＲ）契約者代理人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrtkykhukaumu(), null, "（ＩＲ）契約者代理特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrMousideninkbn(), C_MousideninKbn.BLNK, "（ＩＲ）申出人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrknhatudoujyoutai(), C_KykdrknHtdjytKbn.BLNK, "（ＩＲ）契約者代理権発動状態");
        exStringEquals(khSeikyuusyoBean.getIrDrstiskkyknmkj(), "契約者名", "（ＩＲ）代理人指定先契約者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTyouhyoutitle(), null, "（ＩＲ）帳票タイトル");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg1(), null, "（ＩＲ）送付案内メッセージ１");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg2(), null, "（ＩＲ）送付案内メッセージ２");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg3(), null, "（ＩＲ）送付案内メッセージ３");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg4(), null, "（ＩＲ）送付案内メッセージ４");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg5(), null, "（ＩＲ）送付案内メッセージ５");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg6(), null, "（ＩＲ）送付案内メッセージ６");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg7(), null, "（ＩＲ）送付案内メッセージ７");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg8(), null, "（ＩＲ）送付案内メッセージ８");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg9(), null, "（ＩＲ）送付案内メッセージ９");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg10(), null, "（ＩＲ）送付案内メッセージ１０");

        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean)kSBean[1];

        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(), null, "（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(), "userId001", "（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(), "user001", "（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(), DateFormatUtil.dateKANJI(BizDate.getSysDate()), "（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(), "　消滅後 4ヵ月", "（ＩＲ）保存期間");
    }

    @Test
    @TestOrder(220)
    public void testEditBean_A22() {

        MockObjectManager.initialize();

        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;

        AM_User aMUser = new AM_User();

        aMUser.setUserId("userId001");
        aMUser.setUserNm("user001");
        changeCurrentUser(baseUserInfo, aMUser);

        editSeikyuusyoParam.setHhknseiymd(BizDate.valueOf(20151026));
        editSeikyuusyoParam.setHhknseiymdhenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setHhknsei(C_Hhknsei.MALE);
        editSeikyuusyoParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setBfrTargettkmokuhyouti(BizNumber.valueOf(101));
        editSeikyuusyoParam.setBfrKihonS(BizCurrency.valueOf(778));
        editSeikyuusyoParam.setBfrP(BizCurrency.valueOf(1566));
        editSeikyuusyoParam.setBfrTokuyakuNenkinsyuKbn(C_Nstknsyu.KAKUTEINENKIN);
        editSeikyuusyoParam.setBfrNkshrtkyknksyukkn(5);
        editSeikyuusyoParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU);
        editSeikyuusyoParam.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editSeikyuusyoParam.setGengkhouKbn(C_GengkhouKbn.SD);
        editSeikyuusyoParam.setHenkankumukbn(C_UmuKbn.ARI);
        editSeikyuusyoParam.setRstuukasyu(C_Tuukasyu.JPY);
        editSeikyuusyoParam.setNkshrtkykhnkkbn(C_NstkhKbn.NAIYOUHENKOU);
        editSeikyuusyoParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);
        editSeikyuusyoParam.setJyudkaigomaebaraiTkykhnkKbn(C_JyudkaigomaebaraiTkykhnkKbn.KAIYAKU);
        editSeikyuusyoParam.setKihonshenkouumu(C_UmuKbn.NONE);
        editSeikyuusyoParam.setTmttknitenkbn(C_Tmttknitenkbn.BLNK);
        editSeikyuusyoParam.setTmttknitenymd(null);
        editSeikyuusyoParam.setKhhrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSeikyuusyoParam.setKhskssakuseijiyuu(C_Khskssakuseijiyuu.BLNK);
        editSeikyuusyoParam.setHenkougokjnkngk(BizCurrency.valueOf(100000));

        ReportServicesBean reSsBean =  editSeikyuusyoTbl.editBean(C_SyoruiCdKbn.KK_GENGAKU_SKS, syono16, khozenCommonParam, editSeikyuusyoParam);

        Object[] kSBean = reSsBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_GENGAKU_SKS.getValue());

        exNumericEquals(kSBean.length, 2, "パラメータオブジェクトの要素数");

        exNumericEquals(reSsBean.getKensakuKeys().length, 1, "検索キー配列の要素数");
        exStringEquals(reSsBean.getKensakuKeys()[0], "12806345823", "検索キー");

        KhSeikyuusyoBean khSeikyuusyoBean = (KhSeikyuusyoBean)kSBean[0];

        exStringEquals(khSeikyuusyoBean.getIrSyono(), "12806345823", "（ＩＲ）証券番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinyno(), "1234567", "（ＩＲ）通信先郵便番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr1kj(), "通信先住所１", "（ＩＲ）通信先住所１（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr2kj(), "通信先住所２", "（ＩＲ）通信先住所２（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr3kj(), "通信先住所３", "（ＩＲ）通信先住所３（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsintelno(), "023-5677-8999", "（ＩＲ）通信先電話番号");
        exStringEquals(khSeikyuusyoBean.getIrBanknmkj(), "りそな銀行", "（ＩＲ）銀行名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrSitennmkj(), "", "（ＩＲ）支店名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrBankcd(), "", "（ＩＲ）銀行コード");
        exStringEquals(khSeikyuusyoBean.getIrSitencd(), "", "（ＩＲ）支店コード");

        exStringEquals(khSeikyuusyoBean.getIrKzmeiginmkn(), "口座名義人氏名口座名義人氏名", "（ＩＲ）口座名義人氏名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkj(), "契約者名", "（ＩＲ）契約者名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKkkyktdk(), C_Tdk.HGU, "（ＩＲ）契約管理契約者続柄");
        exStringEquals(khSeikyuusyoBean.getIrHhknnmkj(), "被保険者名", "（ＩＲ）被保険者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrHhknseiymd(), "", "（ＩＲ）被保険者生年月日");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseiymdhenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者生年月日変更有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknsei(), C_Hhknsei.MALE, "（ＩＲ）被保険者性別");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseihenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者性別変更有無");
        exStringEquals(khSeikyuusyoBean.getIrStdrsknmkj(), "長島", "（ＩＲ）指定代理請求人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrFatcakakuninyhkbn(), C_YouhiblnkKbn.HUYOU, "（ＩＲ）FATCA確認要否区分");
        exClassificationEquals(khSeikyuusyoBean.getIrAeoikakuninyhkbn(), C_YouhiblnkKbn.HUYOU, "（ＩＲ）ＡＥＯＩ確認要否区分");

        exClassificationEquals(khSeikyuusyoBean.getIrTargettkkbn(), C_TargetTkKbn.BLNK, "（ＩＲ）ターゲット特約区分");
        exNumericEquals(khSeikyuusyoBean.getIrAftertargettkmokuhyouti(), 101, "（ＩＲ）変更後ターゲット特約目標値");
        exNumericEquals(khSeikyuusyoBean.getIrBeforetargettkmokuhyouti(), 200, "（ＩＲ）変更前ターゲット特約目標値");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforekihons(), BizCurrency.valueOf(100), "（ＩＲ）基本保険金額（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkihons(),  BizCurrency.valueOf(778), "（ＩＲ）基本保険金額（変更後）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforep(), BizCurrency.valueOf(200), "（ＩＲ）保険料（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterp(), BizCurrency.valueOf(1566), "（ＩＲ）保険料（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrKyktuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）契約通貨種類");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj1(), "小野", "（ＩＲ）死亡受取人名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj2(), "", "（ＩＲ）死亡受取人名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj3(), "", "（ＩＲ）死亡受取人名（漢字）３");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj4(), "", "（ＩＲ）死亡受取人名（漢字）４");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkn(), "受取人名（カナ）", "（ＩＲ）死亡受取人名（カナ）");
        exClassificationEquals(khSeikyuusyoBean.getIrYokinkbn(), C_YokinKbn.BLNK, "（ＩＲ）預金種目区分");
        exStringEquals(khSeikyuusyoBean.getIrKouzano(), "", "（ＩＲ）口座番号");

        exClassificationEquals(khSeikyuusyoBean.getIrAfternkshrtkyknksyukbn(), C_Nstknsyu.KAKUTEINENKIN, "（ＩＲ）変更後年金支払特約年金種類区分");
        exClassificationEquals(khSeikyuusyoBean.getIrBiforenkshrtkyknksyukbn(), C_Nstknsyu.BLNK, "（ＩＲ）変更前年金支払特約年金種類区分");
        exNumericEquals(khSeikyuusyoBean.getIrAfternkshrtkyknkkkn(), 5, "（ＩＲ）変更後年金支払特約年金期間");
        exNumericEquals(khSeikyuusyoBean.getIrBeforenkshrtkyknkkkn(), 10, "（ＩＲ）変更前年金支払特約年金期間");
        exStringEquals(khSeikyuusyoBean.getIrNkuktnm(), "森君", "（ＩＲ）年金受取人名");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari1(), BizNumber.valueOf(230), "（ＩＲ）死亡受取人分割割合１");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari2(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合２");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari3(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合３");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari4(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合４");
        exClassificationEquals(khSeikyuusyoBean.getIrTargettkhnkkbn(), C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU, "（ＩＲ）ターゲット特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKaiyakujiyuu(), C_Kaiyakujiyuu.TUUJYOU, "（ＩＲ）解約事由");
        exClassificationEquals(khSeikyuusyoBean.getIrGengkhoukbn(), C_GengkhouKbn.SD, "（ＩＲ）減額方法区分");
        exNumericEquals(khSeikyuusyoBean.getIrSbuktnin(), 2, "（ＩＲ）死亡受取人人数");
        exClassificationEquals(khSeikyuusyoBean.getIrSbuuktkbn(), C_UktKbn.BLNK, "（ＩＲ）死亡受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrYenshrtkumu(), C_UmuKbn.ARI, "（ＩＲ）円支払特約有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHenkankinumukbn(), C_UmuKbn.ARI, "（ＩＲ）返還金有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrRstuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）領収通貨種類");
        exClassificationEquals(khSeikyuusyoBean.getIrNkshrtkykhnkkbn(), C_NstkhKbn.NAIYOUHENKOU, "（ＩＲ）年金支払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrMeigihnkjiyuu(), C_Meigihnkjiyuu.KYK, "（ＩＲ）名義変更事由");
        exClassificationEquals(khSeikyuusyoBean.getIrNkhknumu(), C_UmuKbn.ARI, "（ＩＲ）年金保険有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSiboukyhkuktumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡給付金受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn1(), C_UmuKbn.ARI, "（ＩＲ）死亡保険金受取人有無区分１");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn2(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分２");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn3(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分３");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn4(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分４");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu1(), C_UmuKbn.ARI, "（ＩＲ）死亡受取人分割割合有無１");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu2(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無２");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu3(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無３");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu4(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無４");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyhukaumu(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyuuktmukbn(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrStdruktkbn(), C_UktKbn.BLNK, "（ＩＲ）指定代理受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrJyudkaigomaebrtkykhnkkbn(),C_JyudkaigomaebaraiTkykhnkKbn.KAIYAKU, "（ＩＲ）重度介護前払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKeihikbn(),C_KeihiKbn.BLNK,"（ＩＲ）契被区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKihonshenkouumu(),C_UmuKbn.NONE,"（ＩＲ）基本Ｓ変更有無");
        exStringEquals(khSeikyuusyoBean.getIrKihonssyurui(), "給付日額", "（ＩＲ）基本Ｓ種類");
        exClassificationEquals(khSeikyuusyoBean.getIrTmttknitenkbn(), C_Tmttknitenkbn.BLNK, "（ＩＲ）積立金移転区分");
        exStringEquals(khSeikyuusyoBean.getIrTmttknitenymd(), null, "（ＩＲ）積立金移転日");
        exClassificationEquals(khSeikyuusyoBean.getIrKhhrshrjiyuu(), C_Khhrshrjiyuu.BLNK, "（ＩＲ）契約保全返戻金支払事由");
        exClassificationEquals(khSeikyuusyoBean.getIrKhskssakuseijiyuu(), C_Khskssakuseijiyuu.BLNK, "（ＩＲ）契約保全請求書作成事由");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkijyunkingaku(), BizCurrency.valueOf(100000), "（ＩＲ）基準金額（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrHrkkeiro(), C_Hrkkeiro.DANTAI, "（ＩＲ）払込経路");
        exNumericEquals(khSeikyuusyoBean.getIrSyouhnhanteikekka(), 999, "（ＩＲ）商品判定結果");
        exClassificationEquals(khSeikyuusyoBean.getIrKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "（ＩＲ）契約状態");
        exClassificationEquals(khSeikyuusyoBean.getIrZeiseitkkktkykhukaumu(), C_UmuKbn.ARI, "（ＩＲ）税制適格特約付加有無");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn1(), "", "（ＩＲ）登録家族氏名（カナ）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj1(), "", "（ＩＲ）登録家族氏名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj1(), "", "（ＩＲ）登録家族住所１（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj1(), "", "（ＩＲ）登録家族住所２（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj1(), "", "（ＩＲ）登録家族住所３（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno1(), "", "（ＩＲ）登録家族電話番号１");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi1(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn2(), "", "（ＩＲ）登録家族氏名（カナ）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj2(), "", "（ＩＲ）登録家族氏名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj2(), "", "（ＩＲ）登録家族住所１（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj2(), "", "（ＩＲ）登録家族住所２（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj2(), "", "（ＩＲ）登録家族住所３（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno2(), "", "（ＩＲ）登録家族電話番号２");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi2(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否２");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkn(), "契約者名（カナ）", "（ＩＲ）契約者名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKykdairinmkj(), "", "（ＩＲ）契約者代理人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrtkykhukaumu(), null, "（ＩＲ）契約者代理特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrMousideninkbn(), C_MousideninKbn.BLNK, "（ＩＲ）申出人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrknhatudoujyoutai(), C_KykdrknHtdjytKbn.BLNK, "（ＩＲ）契約者代理権発動状態");
        exStringEquals(khSeikyuusyoBean.getIrDrstiskkyknmkj(), "契約者名", "（ＩＲ）代理人指定先契約者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTyouhyoutitle(), null, "（ＩＲ）帳票タイトル");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg1(), null, "（ＩＲ）送付案内メッセージ１");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg2(), null, "（ＩＲ）送付案内メッセージ２");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg3(), null, "（ＩＲ）送付案内メッセージ３");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg4(), null, "（ＩＲ）送付案内メッセージ４");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg5(), null, "（ＩＲ）送付案内メッセージ５");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg6(), null, "（ＩＲ）送付案内メッセージ６");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg7(), null, "（ＩＲ）送付案内メッセージ７");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg8(), null, "（ＩＲ）送付案内メッセージ８");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg9(), null, "（ＩＲ）送付案内メッセージ９");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg10(), null, "（ＩＲ）送付案内メッセージ１０");

        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean)kSBean[1];

        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(), null, "（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(), "userId001", "（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(), "user001", "（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(), DateFormatUtil.dateKANJI(BizDate.getSysDate()), "（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(), "　消滅後 5 年", "（ＩＲ）保存期間");
    }

    @Test
    @TestOrder(230)
    public void testEditBean_A23() {

        MockObjectManager.initialize();

        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;

        AM_User aMUser = new AM_User();

        aMUser.setUserId("userId001");
        aMUser.setUserNm("user001");

        changeCurrentUser(baseUserInfo, aMUser);

        YuyuBizConfig.getInstance().setCallcentersosikicd("6620000");

        editSeikyuusyoParam.setHhknseiymd(BizDate.valueOf(20151026));
        editSeikyuusyoParam.setHhknseiymdhenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setHhknsei(C_Hhknsei.MALE);
        editSeikyuusyoParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setBfrTargettkmokuhyouti(BizNumber.valueOf(101));
        editSeikyuusyoParam.setBfrKihonS(BizCurrency.valueOf(778));
        editSeikyuusyoParam.setBfrP(BizCurrency.valueOf(1566));
        editSeikyuusyoParam.setBfrTokuyakuNenkinsyuKbn(C_Nstknsyu.KAKUTEINENKIN);
        editSeikyuusyoParam.setBfrNkshrtkyknksyukkn(5);
        editSeikyuusyoParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU);
        editSeikyuusyoParam.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editSeikyuusyoParam.setGengkhouKbn(C_GengkhouKbn.SD);
        editSeikyuusyoParam.setHenkankumukbn(C_UmuKbn.ARI);
        editSeikyuusyoParam.setRstuukasyu(C_Tuukasyu.JPY);
        editSeikyuusyoParam.setNkshrtkykhnkkbn(C_NstkhKbn.NAIYOUHENKOU);
        editSeikyuusyoParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);
        editSeikyuusyoParam.setJyudkaigomaebaraiTkykhnkKbn(C_JyudkaigomaebaraiTkykhnkKbn.KAIYAKU);
        editSeikyuusyoParam.setKihonshenkouumu(C_UmuKbn.NONE);
        editSeikyuusyoParam.setTmttknitenkbn(C_Tmttknitenkbn.BLNK);
        editSeikyuusyoParam.setTmttknitenymd(null);
        editSeikyuusyoParam.setKhhrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSeikyuusyoParam.setKhskssakuseijiyuu(C_Khskssakuseijiyuu.BLNK);
        editSeikyuusyoParam.setHenkougokjnkngk(BizCurrency.valueOf(100000));

        ReportServicesBean reSsBean =  editSeikyuusyoTbl.editBean(C_SyoruiCdKbn.KK_KAIGOMAETKHNK_SKS, syono16, khozenCommonParam, editSeikyuusyoParam);

        Object[] kSBean = reSsBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_KAIGOMAETKHNK_SKS.getValue());

        exNumericEquals(kSBean.length, 2, "パラメータオブジェクトの要素数");

        exNumericEquals(reSsBean.getKensakuKeys().length, 1, "検索キー配列の要素数");
        exStringEquals(reSsBean.getKensakuKeys()[0], "12806345823", "検索キー");

        KhSeikyuusyoBean khSeikyuusyoBean = (KhSeikyuusyoBean)kSBean[0];

        exStringEquals(khSeikyuusyoBean.getIrSyono(), "12806345823", "（ＩＲ）証券番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinyno(), "1234567", "（ＩＲ）通信先郵便番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr1kj(), "通信先住所１", "（ＩＲ）通信先住所１（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr2kj(), "通信先住所２", "（ＩＲ）通信先住所２（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr3kj(), "通信先住所３", "（ＩＲ）通信先住所３（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsintelno(), "023-5677-8999", "（ＩＲ）通信先電話番号");
        exStringEquals(khSeikyuusyoBean.getIrBanknmkj(), "", "（ＩＲ）銀行名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrSitennmkj(), "", "（ＩＲ）支店名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrBankcd(), "", "（ＩＲ）銀行コード");
        exStringEquals(khSeikyuusyoBean.getIrSitencd(), "", "（ＩＲ）支店コード");

        exStringEquals(khSeikyuusyoBean.getIrKzmeiginmkn(), "", "（ＩＲ）口座名義人氏名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkj(), "契約者名", "（ＩＲ）契約者名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKkkyktdk(), C_Tdk.HGU, "（ＩＲ）契約管理契約者続柄");
        exStringEquals(khSeikyuusyoBean.getIrHhknnmkj(), "被保険者名", "（ＩＲ）被保険者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrHhknseiymd(), "", "（ＩＲ）被保険者生年月日");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseiymdhenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者生年月日変更有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknsei(), C_Hhknsei.MALE, "（ＩＲ）被保険者性別");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseihenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者性別変更有無");
        exStringEquals(khSeikyuusyoBean.getIrStdrsknmkj(), "長島", "（ＩＲ）指定代理請求人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrFatcakakuninyhkbn(), C_YouhiblnkKbn.HUYOU, "（ＩＲ）FATCA確認要否区分");
        exClassificationEquals(khSeikyuusyoBean.getIrAeoikakuninyhkbn(), C_YouhiblnkKbn.HUYOU, "（ＩＲ）ＡＥＯＩ確認要否区分");

        exClassificationEquals(khSeikyuusyoBean.getIrTargettkkbn(), C_TargetTkKbn.BLNK, "（ＩＲ）ターゲット特約区分");
        exNumericEquals(khSeikyuusyoBean.getIrAftertargettkmokuhyouti(), 101, "（ＩＲ）変更後ターゲット特約目標値");
        exNumericEquals(khSeikyuusyoBean.getIrBeforetargettkmokuhyouti(), 200, "（ＩＲ）変更前ターゲット特約目標値");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforekihons(), BizCurrency.valueOf(100), "（ＩＲ）基本保険金額（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkihons(),  BizCurrency.valueOf(778), "（ＩＲ）基本保険金額（変更後）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforep(), BizCurrency.valueOf(200), "（ＩＲ）保険料（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterp(), BizCurrency.valueOf(1566), "（ＩＲ）保険料（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrKyktuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）契約通貨種類");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj1(), "小野", "（ＩＲ）死亡受取人名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj2(), "", "（ＩＲ）死亡受取人名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj3(), "", "（ＩＲ）死亡受取人名（漢字）３");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj4(), "", "（ＩＲ）死亡受取人名（漢字）４");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkn(), "受取人名（カナ）", "（ＩＲ）死亡受取人名（カナ）");
        exClassificationEquals(khSeikyuusyoBean.getIrYokinkbn(), C_YokinKbn.BLNK, "（ＩＲ）預金種目区分");
        exStringEquals(khSeikyuusyoBean.getIrKouzano(), "", "（ＩＲ）口座番号");

        exClassificationEquals(khSeikyuusyoBean.getIrAfternkshrtkyknksyukbn(), C_Nstknsyu.KAKUTEINENKIN, "（ＩＲ）変更後年金支払特約年金種類区分");
        exClassificationEquals(khSeikyuusyoBean.getIrBiforenkshrtkyknksyukbn(), C_Nstknsyu.BLNK, "（ＩＲ）変更前年金支払特約年金種類区分");
        exNumericEquals(khSeikyuusyoBean.getIrAfternkshrtkyknkkkn(), 5, "（ＩＲ）変更後年金支払特約年金期間");
        exNumericEquals(khSeikyuusyoBean.getIrBeforenkshrtkyknkkkn(), 10, "（ＩＲ）変更前年金支払特約年金期間");
        exStringEquals(khSeikyuusyoBean.getIrNkuktnm(), "森君", "（ＩＲ）年金受取人名");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari1(), BizNumber.valueOf(230), "（ＩＲ）死亡受取人分割割合１");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari2(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合２");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari3(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合３");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari4(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合４");
        exClassificationEquals(khSeikyuusyoBean.getIrTargettkhnkkbn(), C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU, "（ＩＲ）ターゲット特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKaiyakujiyuu(), C_Kaiyakujiyuu.TUUJYOU, "（ＩＲ）解約事由");
        exClassificationEquals(khSeikyuusyoBean.getIrGengkhoukbn(), C_GengkhouKbn.SD, "（ＩＲ）減額方法区分");
        exNumericEquals(khSeikyuusyoBean.getIrSbuktnin(), 2, "（ＩＲ）死亡受取人人数");
        exClassificationEquals(khSeikyuusyoBean.getIrSbuuktkbn(), C_UktKbn.BLNK, "（ＩＲ）死亡受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrYenshrtkumu(), C_UmuKbn.ARI, "（ＩＲ）円支払特約有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHenkankinumukbn(), C_UmuKbn.ARI, "（ＩＲ）返還金有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrRstuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）領収通貨種類");
        exClassificationEquals(khSeikyuusyoBean.getIrNkshrtkykhnkkbn(), C_NstkhKbn.NAIYOUHENKOU, "（ＩＲ）年金支払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrMeigihnkjiyuu(), C_Meigihnkjiyuu.KYK, "（ＩＲ）名義変更事由");
        exClassificationEquals(khSeikyuusyoBean.getIrNkhknumu(), C_UmuKbn.ARI, "（ＩＲ）年金保険有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSiboukyhkuktumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡給付金受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn1(), C_UmuKbn.ARI, "（ＩＲ）死亡保険金受取人有無区分１");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn2(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分２");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn3(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分３");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn4(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分４");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu1(), C_UmuKbn.ARI, "（ＩＲ）死亡受取人分割割合有無１");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu2(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無２");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu3(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無３");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu4(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無４");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyhukaumu(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyuuktmukbn(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrStdruktkbn(), C_UktKbn.BLNK, "（ＩＲ）指定代理受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrJyudkaigomaebrtkykhnkkbn(),C_JyudkaigomaebaraiTkykhnkKbn.KAIYAKU, "（ＩＲ）重度介護前払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKeihikbn(),C_KeihiKbn.BLNK,"（ＩＲ）契被区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKihonshenkouumu(),C_UmuKbn.NONE,"（ＩＲ）基本Ｓ変更有無");
        exStringEquals(khSeikyuusyoBean.getIrKihonssyurui(), "給付日額", "（ＩＲ）基本Ｓ種類");
        exClassificationEquals(khSeikyuusyoBean.getIrTmttknitenkbn(), C_Tmttknitenkbn.BLNK, "（ＩＲ）積立金移転区分");
        exStringEquals(khSeikyuusyoBean.getIrTmttknitenymd(), null, "（ＩＲ）積立金移転日");
        exClassificationEquals(khSeikyuusyoBean.getIrKhhrshrjiyuu(), C_Khhrshrjiyuu.BLNK, "（ＩＲ）契約保全返戻金支払事由");
        exClassificationEquals(khSeikyuusyoBean.getIrKhskssakuseijiyuu(), C_Khskssakuseijiyuu.BLNK, "（ＩＲ）契約保全請求書作成事由");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkijyunkingaku(), BizCurrency.valueOf(100000), "（ＩＲ）基準金額（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrHrkkeiro(), C_Hrkkeiro.DANTAI, "（ＩＲ）払込経路");
        exNumericEquals(khSeikyuusyoBean.getIrSyouhnhanteikekka(), 999, "（ＩＲ）商品判定結果");
        exClassificationEquals(khSeikyuusyoBean.getIrKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "（ＩＲ）契約状態");
        exClassificationEquals(khSeikyuusyoBean.getIrZeiseitkkktkykhukaumu(), C_UmuKbn.ARI, "（ＩＲ）税制適格特約付加有無");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn1(), "", "（ＩＲ）登録家族氏名（カナ）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj1(), "", "（ＩＲ）登録家族氏名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj1(), "", "（ＩＲ）登録家族住所１（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj1(), "", "（ＩＲ）登録家族住所２（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj1(), "", "（ＩＲ）登録家族住所３（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno1(), "", "（ＩＲ）登録家族電話番号１");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi1(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn2(), "", "（ＩＲ）登録家族氏名（カナ）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj2(), "", "（ＩＲ）登録家族氏名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj2(), "", "（ＩＲ）登録家族住所１（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj2(), "", "（ＩＲ）登録家族住所２（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj2(), "", "（ＩＲ）登録家族住所３（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno2(), "", "（ＩＲ）登録家族電話番号２");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi2(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否２");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkn(), "契約者名（カナ）", "（ＩＲ）契約者名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKykdairinmkj(), "", "（ＩＲ）契約者代理人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrtkykhukaumu(), null, "（ＩＲ）契約者代理特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrMousideninkbn(), C_MousideninKbn.BLNK, "（ＩＲ）申出人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrknhatudoujyoutai(), C_KykdrknHtdjytKbn.BLNK, "（ＩＲ）契約者代理権発動状態");
        exStringEquals(khSeikyuusyoBean.getIrDrstiskkyknmkj(), "契約者名", "（ＩＲ）代理人指定先契約者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTyouhyoutitle(), null, "（ＩＲ）帳票タイトル");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg1(), null, "（ＩＲ）送付案内メッセージ１");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg2(), null, "（ＩＲ）送付案内メッセージ２");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg3(), null, "（ＩＲ）送付案内メッセージ３");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg4(), null, "（ＩＲ）送付案内メッセージ４");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg5(), null, "（ＩＲ）送付案内メッセージ５");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg6(), null, "（ＩＲ）送付案内メッセージ６");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg7(), null, "（ＩＲ）送付案内メッセージ７");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg8(), null, "（ＩＲ）送付案内メッセージ８");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg9(), null, "（ＩＲ）送付案内メッセージ９");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg10(), null, "（ＩＲ）送付案内メッセージ１０");

        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean)kSBean[1];

        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(), null, "（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(), DateFormatUtil.dateKANJI(BizDate.getSysDate()), "（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(), "userId001", "（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(), "user001", "（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(), "　消滅後 3ヵ月", "（ＩＲ）保存期間");
    }

    @Test
    @TestOrder(240)
    public void testEditBean_A24() {

        MockObjectManager.initialize();

        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;

        AM_User aMUser = new AM_User();

        aMUser.setUserId("userId001");
        aMUser.setUserNm("user001");

        changeCurrentUser(baseUserInfo, aMUser);

        YuyuBizConfig.getInstance().setCallcentersosikicd("6620000");

        editSeikyuusyoParam.setHhknseiymd(BizDate.valueOf(20151026));
        editSeikyuusyoParam.setHhknseiymdhenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setHhknsei(C_Hhknsei.MALE);
        editSeikyuusyoParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setBfrTargettkmokuhyouti(BizNumber.valueOf(101));
        editSeikyuusyoParam.setBfrKihonS(BizCurrency.valueOf(778));
        editSeikyuusyoParam.setBfrP(BizCurrency.valueOf(1566));
        editSeikyuusyoParam.setBfrTokuyakuNenkinsyuKbn(C_Nstknsyu.KAKUTEINENKIN);
        editSeikyuusyoParam.setBfrNkshrtkyknksyukkn(5);
        editSeikyuusyoParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU);
        editSeikyuusyoParam.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editSeikyuusyoParam.setGengkhouKbn(C_GengkhouKbn.SD);
        editSeikyuusyoParam.setHenkankumukbn(C_UmuKbn.ARI);
        editSeikyuusyoParam.setRstuukasyu(C_Tuukasyu.JPY);
        editSeikyuusyoParam.setNkshrtkykhnkkbn(C_NstkhKbn.NAIYOUHENKOU);
        editSeikyuusyoParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);
        editSeikyuusyoParam.setJyudkaigomaebaraiTkykhnkKbn(C_JyudkaigomaebaraiTkykhnkKbn.KAIYAKU);
        editSeikyuusyoParam.setKihonshenkouumu(C_UmuKbn.NONE);
        editSeikyuusyoParam.setTmttknitenkbn(C_Tmttknitenkbn.BLNK);
        editSeikyuusyoParam.setTmttknitenymd(null);
        editSeikyuusyoParam.setKhhrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSeikyuusyoParam.setKhskssakuseijiyuu(C_Khskssakuseijiyuu.BLNK);
        editSeikyuusyoParam.setHenkougokjnkngk(BizCurrency.valueOf(100000));

        ReportServicesBean reSsBean =  editSeikyuusyoTbl.editBean(C_SyoruiCdKbn.KK_MKHGKHNK_SKS, syono16, khozenCommonParam, editSeikyuusyoParam);

        Object[] kSBean = reSsBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_MKHGKHNK_SKS.getValue());

        exNumericEquals(kSBean.length, 2, "パラメータオブジェクトの要素数");

        exNumericEquals(reSsBean.getKensakuKeys().length, 1, "検索キー配列の要素数");
        exStringEquals(reSsBean.getKensakuKeys()[0], "12806345823", "検索キー");

        KhSeikyuusyoBean khSeikyuusyoBean = (KhSeikyuusyoBean)kSBean[0];

        exStringEquals(khSeikyuusyoBean.getIrSyono(), "12806345823", "（ＩＲ）証券番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinyno(), "1234567", "（ＩＲ）通信先郵便番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr1kj(), "通信先住所１", "（ＩＲ）通信先住所１（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr2kj(), "通信先住所２", "（ＩＲ）通信先住所２（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr3kj(), "通信先住所３", "（ＩＲ）通信先住所３（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsintelno(), "023-5677-8999", "（ＩＲ）通信先電話番号");
        exStringEquals(khSeikyuusyoBean.getIrBanknmkj(), "", "（ＩＲ）銀行名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrSitennmkj(), "", "（ＩＲ）支店名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrBankcd(), "", "（ＩＲ）銀行コード");
        exStringEquals(khSeikyuusyoBean.getIrSitencd(), "", "（ＩＲ）支店コード");

        exStringEquals(khSeikyuusyoBean.getIrKzmeiginmkn(), "", "（ＩＲ）口座名義人氏名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkj(), "契約者名", "（ＩＲ）契約者名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKkkyktdk(), C_Tdk.HGU, "（ＩＲ）契約管理契約者続柄");
        exStringEquals(khSeikyuusyoBean.getIrHhknnmkj(), "被保険者名", "（ＩＲ）被保険者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrHhknseiymd(), "", "（ＩＲ）被保険者生年月日");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseiymdhenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者生年月日変更有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknsei(), C_Hhknsei.MALE, "（ＩＲ）被保険者性別");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseihenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者性別変更有無");
        exStringEquals(khSeikyuusyoBean.getIrStdrsknmkj(), "長島", "（ＩＲ）指定代理請求人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrFatcakakuninyhkbn(), C_YouhiblnkKbn.HUYOU, "（ＩＲ）FATCA確認要否区分");
        exClassificationEquals(khSeikyuusyoBean.getIrAeoikakuninyhkbn(), C_YouhiblnkKbn.HUYOU, "（ＩＲ）ＡＥＯＩ確認要否区分");

        exClassificationEquals(khSeikyuusyoBean.getIrTargettkkbn(), C_TargetTkKbn.BLNK, "（ＩＲ）ターゲット特約区分");
        exNumericEquals(khSeikyuusyoBean.getIrAftertargettkmokuhyouti(), 101, "（ＩＲ）変更後ターゲット特約目標値");
        exNumericEquals(khSeikyuusyoBean.getIrBeforetargettkmokuhyouti(), 200, "（ＩＲ）変更前ターゲット特約目標値");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforekihons(), BizCurrency.valueOf(100), "（ＩＲ）基本保険金額（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkihons(),  BizCurrency.valueOf(778), "（ＩＲ）基本保険金額（変更後）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforep(), BizCurrency.valueOf(200), "（ＩＲ）保険料（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterp(), BizCurrency.valueOf(1566), "（ＩＲ）保険料（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrKyktuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）契約通貨種類");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj1(), "小野", "（ＩＲ）死亡受取人名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj2(), "", "（ＩＲ）死亡受取人名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj3(), "", "（ＩＲ）死亡受取人名（漢字）３");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj4(), "", "（ＩＲ）死亡受取人名（漢字）４");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkn(), "受取人名（カナ）", "（ＩＲ）死亡受取人名（カナ）");
        exClassificationEquals(khSeikyuusyoBean.getIrYokinkbn(), C_YokinKbn.BLNK, "（ＩＲ）預金種目区分");
        exStringEquals(khSeikyuusyoBean.getIrKouzano(), "", "（ＩＲ）口座番号");

        exClassificationEquals(khSeikyuusyoBean.getIrAfternkshrtkyknksyukbn(), C_Nstknsyu.KAKUTEINENKIN, "（ＩＲ）変更後年金支払特約年金種類区分");
        exClassificationEquals(khSeikyuusyoBean.getIrBiforenkshrtkyknksyukbn(), C_Nstknsyu.BLNK, "（ＩＲ）変更前年金支払特約年金種類区分");
        exNumericEquals(khSeikyuusyoBean.getIrAfternkshrtkyknkkkn(), 5, "（ＩＲ）変更後年金支払特約年金期間");
        exNumericEquals(khSeikyuusyoBean.getIrBeforenkshrtkyknkkkn(), 10, "（ＩＲ）変更前年金支払特約年金期間");
        exStringEquals(khSeikyuusyoBean.getIrNkuktnm(), "森君", "（ＩＲ）年金受取人名");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari1(), BizNumber.valueOf(230), "（ＩＲ）死亡受取人分割割合１");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari2(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合２");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari3(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合３");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari4(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合４");
        exClassificationEquals(khSeikyuusyoBean.getIrTargettkhnkkbn(), C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU, "（ＩＲ）ターゲット特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKaiyakujiyuu(), C_Kaiyakujiyuu.TUUJYOU, "（ＩＲ）解約事由");
        exClassificationEquals(khSeikyuusyoBean.getIrGengkhoukbn(), C_GengkhouKbn.SD, "（ＩＲ）減額方法区分");
        exNumericEquals(khSeikyuusyoBean.getIrSbuktnin(), 2, "（ＩＲ）死亡受取人人数");
        exClassificationEquals(khSeikyuusyoBean.getIrSbuuktkbn(), C_UktKbn.BLNK, "（ＩＲ）死亡受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrYenshrtkumu(), C_UmuKbn.ARI, "（ＩＲ）円支払特約有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHenkankinumukbn(), C_UmuKbn.ARI, "（ＩＲ）返還金有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrRstuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）領収通貨種類");
        exClassificationEquals(khSeikyuusyoBean.getIrNkshrtkykhnkkbn(), C_NstkhKbn.NAIYOUHENKOU, "（ＩＲ）年金支払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrMeigihnkjiyuu(), C_Meigihnkjiyuu.KYK, "（ＩＲ）名義変更事由");
        exClassificationEquals(khSeikyuusyoBean.getIrNkhknumu(), C_UmuKbn.ARI, "（ＩＲ）年金保険有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSiboukyhkuktumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡給付金受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn1(), C_UmuKbn.ARI, "（ＩＲ）死亡保険金受取人有無区分１");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn2(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分２");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn3(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分３");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn4(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分４");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu1(), C_UmuKbn.ARI, "（ＩＲ）死亡受取人分割割合有無１");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu2(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無２");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu3(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無３");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu4(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無４");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyhukaumu(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyuuktmukbn(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrStdruktkbn(), C_UktKbn.BLNK, "（ＩＲ）指定代理受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrJyudkaigomaebrtkykhnkkbn(),C_JyudkaigomaebaraiTkykhnkKbn.KAIYAKU, "（ＩＲ）重度介護前払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKeihikbn(),C_KeihiKbn.BLNK,"（ＩＲ）契被区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKihonshenkouumu(),C_UmuKbn.NONE,"（ＩＲ）基本Ｓ変更有無");
        exStringEquals(khSeikyuusyoBean.getIrKihonssyurui(), "給付日額", "（ＩＲ）基本Ｓ種類");
        exClassificationEquals(khSeikyuusyoBean.getIrTmttknitenkbn(), C_Tmttknitenkbn.BLNK, "（ＩＲ）積立金移転区分");
        exStringEquals(khSeikyuusyoBean.getIrTmttknitenymd(), null, "（ＩＲ）積立金移転日");
        exClassificationEquals(khSeikyuusyoBean.getIrKhhrshrjiyuu(), C_Khhrshrjiyuu.BLNK, "（ＩＲ）契約保全返戻金支払事由");
        exClassificationEquals(khSeikyuusyoBean.getIrKhskssakuseijiyuu(), C_Khskssakuseijiyuu.BLNK, "（ＩＲ）契約保全請求書作成事由");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkijyunkingaku(), BizCurrency.valueOf(100000), "（ＩＲ）基準金額（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrHrkkeiro(), C_Hrkkeiro.DANTAI, "（ＩＲ）払込経路");
        exNumericEquals(khSeikyuusyoBean.getIrSyouhnhanteikekka(), 999, "（ＩＲ）商品判定結果");
        exClassificationEquals(khSeikyuusyoBean.getIrKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "（ＩＲ）契約状態");
        exClassificationEquals(khSeikyuusyoBean.getIrZeiseitkkktkykhukaumu(), C_UmuKbn.ARI, "（ＩＲ）税制適格特約付加有無");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn1(), "", "（ＩＲ）登録家族氏名（カナ）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj1(), "", "（ＩＲ）登録家族氏名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj1(), "", "（ＩＲ）登録家族住所１（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj1(), "", "（ＩＲ）登録家族住所２（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj1(), "", "（ＩＲ）登録家族住所３（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno1(), "", "（ＩＲ）登録家族電話番号１");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi1(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn2(), "", "（ＩＲ）登録家族氏名（カナ）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj2(), "", "（ＩＲ）登録家族氏名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj2(), "", "（ＩＲ）登録家族住所１（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj2(), "", "（ＩＲ）登録家族住所２（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj2(), "", "（ＩＲ）登録家族住所３（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno2(), "", "（ＩＲ）登録家族電話番号２");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi2(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否２");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkn(), "契約者名（カナ）", "（ＩＲ）契約者名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKykdairinmkj(), "", "（ＩＲ）契約者代理人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrtkykhukaumu(), null, "（ＩＲ）契約者代理特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrMousideninkbn(), C_MousideninKbn.BLNK, "（ＩＲ）申出人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrknhatudoujyoutai(), C_KykdrknHtdjytKbn.BLNK, "（ＩＲ）契約者代理権発動状態");
        exStringEquals(khSeikyuusyoBean.getIrDrstiskkyknmkj(), "契約者名", "（ＩＲ）代理人指定先契約者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTyouhyoutitle(), null, "（ＩＲ）帳票タイトル");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg1(), null, "（ＩＲ）送付案内メッセージ１");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg2(), null, "（ＩＲ）送付案内メッセージ２");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg3(), null, "（ＩＲ）送付案内メッセージ３");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg4(), null, "（ＩＲ）送付案内メッセージ４");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg5(), null, "（ＩＲ）送付案内メッセージ５");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg6(), null, "（ＩＲ）送付案内メッセージ６");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg7(), null, "（ＩＲ）送付案内メッセージ７");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg8(), null, "（ＩＲ）送付案内メッセージ８");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg9(), null, "（ＩＲ）送付案内メッセージ９");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg10(), null, "（ＩＲ）送付案内メッセージ１０");

        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean)kSBean[1];

        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(), null, "（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(), DateFormatUtil.dateKANJI(BizDate.getSysDate()), "（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(), "userId001", "（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(), "user001", "（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(), "　消滅後 3ヵ月", "（ＩＲ）保存期間");
    }

    @Test
    @TestOrder(250)
    public void testEditBean_A25() {

        MockObjectManager.initialize();

        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;

        AM_User aMUser = new AM_User();

        aMUser.setUserId("userId001");
        aMUser.setUserNm("user001");
        changeCurrentUser(baseUserInfo, aMUser);

        editSeikyuusyoParam.setHhknseiymd(BizDate.valueOf(20151026));
        editSeikyuusyoParam.setHhknseiymdhenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setHhknsei(C_Hhknsei.MALE);
        editSeikyuusyoParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setBfrTargettkmokuhyouti(BizNumber.valueOf(101));
        editSeikyuusyoParam.setBfrKihonS(BizCurrency.valueOf(778));
        editSeikyuusyoParam.setBfrP(BizCurrency.valueOf(1566));
        editSeikyuusyoParam.setBfrTokuyakuNenkinsyuKbn(C_Nstknsyu.KAKUTEINENKIN);
        editSeikyuusyoParam.setBfrNkshrtkyknksyukkn(5);
        editSeikyuusyoParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU);
        editSeikyuusyoParam.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editSeikyuusyoParam.setGengkhouKbn(C_GengkhouKbn.SD);
        editSeikyuusyoParam.setHenkankumukbn(C_UmuKbn.ARI);
        editSeikyuusyoParam.setRstuukasyu(C_Tuukasyu.JPY);
        editSeikyuusyoParam.setNkshrtkykhnkkbn(C_NstkhKbn.NAIYOUHENKOU);
        editSeikyuusyoParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);
        editSeikyuusyoParam.setJyudkaigomaebaraiTkykhnkKbn(C_JyudkaigomaebaraiTkykhnkKbn.KAIYAKU);
        editSeikyuusyoParam.setKihonshenkouumu(C_UmuKbn.NONE);
        editSeikyuusyoParam.setTmttknitenkbn(C_Tmttknitenkbn.ITEN);
        editSeikyuusyoParam.setTmttknitenymd(BizDate.valueOf(20171231));
        editSeikyuusyoParam.setKhhrshrjiyuu(C_Khhrshrjiyuu.TUUJYOU);
        editSeikyuusyoParam.setKhskssakuseijiyuu(C_Khskssakuseijiyuu.OKYAKUSAMAMOUSIDE);
        editSeikyuusyoParam.setHenkougokjnkngk(BizCurrency.valueOf(100000));

        ReportServicesBean reSsBean = editSeikyuusyoTbl.editBean(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_SKS, syono16,
            khozenCommonParam, editSeikyuusyoParam);

        Object[] kSBean = reSsBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_SKS.getValue());

        exNumericEquals(kSBean.length, 2, "パラメータオブジェクトの要素数");

        exNumericEquals(reSsBean.getKensakuKeys().length, 1, "検索キー配列の要素数");
        exStringEquals(reSsBean.getKensakuKeys()[0], "12806345823", "検索キー");

        KhSeikyuusyoBean khSeikyuusyoBean = (KhSeikyuusyoBean) kSBean[0];

        exStringEquals(khSeikyuusyoBean.getIrSyono(), "12806345823", "（ＩＲ）証券番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinyno(), "1234567", "（ＩＲ）通信先郵便番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr1kj(), "通信先住所１", "（ＩＲ）通信先住所１（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr2kj(), "通信先住所２", "（ＩＲ）通信先住所２（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr3kj(), "通信先住所３", "（ＩＲ）通信先住所３（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsintelno(), "023-5677-8999", "（ＩＲ）通信先電話番号");
        exStringEquals(khSeikyuusyoBean.getIrBanknmkj(), "", "（ＩＲ）銀行名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrSitennmkj(), "", "（ＩＲ）支店名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrBankcd(), "", "（ＩＲ）銀行コード");
        exStringEquals(khSeikyuusyoBean.getIrSitencd(), "", "（ＩＲ）支店コード");

        exStringEquals(khSeikyuusyoBean.getIrKzmeiginmkn(), "", "（ＩＲ）口座名義人氏名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkj(), "契約者名", "（ＩＲ）契約者名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKkkyktdk(), C_Tdk.HGU, "（ＩＲ）契約管理契約者続柄");
        exStringEquals(khSeikyuusyoBean.getIrHhknnmkj(), "被保険者名", "（ＩＲ）被保険者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrHhknseiymd(), "", "（ＩＲ）被保険者生年月日");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseiymdhenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者生年月日変更有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknsei(), C_Hhknsei.MALE, "（ＩＲ）被保険者性別");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseihenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者性別変更有無");
        exStringEquals(khSeikyuusyoBean.getIrStdrsknmkj(), "長島", "（ＩＲ）指定代理請求人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrFatcakakuninyhkbn(), C_YouhiblnkKbn.YOU, "（ＩＲ）FATCA確認要否区分");
        exClassificationEquals(khSeikyuusyoBean.getIrAeoikakuninyhkbn(), C_YouhiblnkKbn.HUYOU, "（ＩＲ）ＡＥＯＩ確認要否区分");

        exClassificationEquals(khSeikyuusyoBean.getIrTargettkkbn(), C_TargetTkKbn.BLNK, "（ＩＲ）ターゲット特約区分");
        exNumericEquals(khSeikyuusyoBean.getIrAftertargettkmokuhyouti(), 101, "（ＩＲ）変更後ターゲット特約目標値");
        exNumericEquals(khSeikyuusyoBean.getIrBeforetargettkmokuhyouti(), 200, "（ＩＲ）変更前ターゲット特約目標値");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforekihons(), BizCurrency.valueOf(100), "（ＩＲ）基本保険金額（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkihons(), BizCurrency.valueOf(778), "（ＩＲ）基本保険金額（変更後）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforep(), BizCurrency.valueOf(200), "（ＩＲ）保険料（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterp(), BizCurrency.valueOf(1566), "（ＩＲ）保険料（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrKyktuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）契約通貨種類");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj1(), "小野", "（ＩＲ）死亡受取人名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj2(), "", "（ＩＲ）死亡受取人名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj3(), "", "（ＩＲ）死亡受取人名（漢字）３");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj4(), "", "（ＩＲ）死亡受取人名（漢字）４");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkn(), "受取人名（カナ）", "（ＩＲ）死亡受取人名（カナ）");
        exClassificationEquals(khSeikyuusyoBean.getIrYokinkbn(), C_YokinKbn.BLNK, "（ＩＲ）預金種目区分");
        exStringEquals(khSeikyuusyoBean.getIrKouzano(), "", "（ＩＲ）口座番号");

        exClassificationEquals(khSeikyuusyoBean.getIrAfternkshrtkyknksyukbn(), C_Nstknsyu.KAKUTEINENKIN,
            "（ＩＲ）変更後年金支払特約年金種類区分");
        exClassificationEquals(khSeikyuusyoBean.getIrBiforenkshrtkyknksyukbn(), C_Nstknsyu.BLNK, "（ＩＲ）変更前年金支払特約年金種類区分");
        exNumericEquals(khSeikyuusyoBean.getIrAfternkshrtkyknkkkn(), 5, "（ＩＲ）変更後年金支払特約年金期間");
        exNumericEquals(khSeikyuusyoBean.getIrBeforenkshrtkyknkkkn(), 10, "（ＩＲ）変更前年金支払特約年金期間");
        exStringEquals(khSeikyuusyoBean.getIrNkuktnm(), "森君", "（ＩＲ）年金受取人名");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari1(), BizNumber.valueOf(230), "（ＩＲ）死亡受取人分割割合１");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari2(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合２");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari3(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合３");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari4(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合４");
        exClassificationEquals(khSeikyuusyoBean.getIrTargettkhnkkbn(), C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU,
            "（ＩＲ）ターゲット特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKaiyakujiyuu(), C_Kaiyakujiyuu.TUUJYOU, "（ＩＲ）解約事由");
        exClassificationEquals(khSeikyuusyoBean.getIrGengkhoukbn(), C_GengkhouKbn.SD, "（ＩＲ）減額方法区分");
        exNumericEquals(khSeikyuusyoBean.getIrSbuktnin(), 2, "（ＩＲ）死亡受取人人数");
        exClassificationEquals(khSeikyuusyoBean.getIrSbuuktkbn(), C_UktKbn.BLNK, "（ＩＲ）死亡受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrYenshrtkumu(), C_UmuKbn.ARI, "（ＩＲ）円支払特約有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHenkankinumukbn(), C_UmuKbn.ARI, "（ＩＲ）返還金有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrRstuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）領収通貨種類");
        exClassificationEquals(khSeikyuusyoBean.getIrNkshrtkykhnkkbn(), C_NstkhKbn.NAIYOUHENKOU, "（ＩＲ）年金支払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrMeigihnkjiyuu(), C_Meigihnkjiyuu.KYK, "（ＩＲ）名義変更事由");
        exClassificationEquals(khSeikyuusyoBean.getIrNkhknumu(), C_UmuKbn.ARI, "（ＩＲ）年金保険有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSiboukyhkuktumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡給付金受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn1(), C_UmuKbn.ARI, "（ＩＲ）死亡保険金受取人有無区分１");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn2(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分２");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn3(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分３");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn4(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分４");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu1(), C_UmuKbn.ARI, "（ＩＲ）死亡受取人分割割合有無１");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu2(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無２");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu3(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無３");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu4(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無４");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyhukaumu(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyuuktmukbn(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrStdruktkbn(), C_UktKbn.BLNK, "（ＩＲ）指定代理受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrJyudkaigomaebrtkykhnkkbn(), C_JyudkaigomaebaraiTkykhnkKbn.KAIYAKU,
            "（ＩＲ）重度介護前払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKeihikbn(), C_KeihiKbn.BLNK, "（ＩＲ）契被区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKihonshenkouumu(), C_UmuKbn.NONE, "（ＩＲ）基本Ｓ変更有無");
        exStringEquals(khSeikyuusyoBean.getIrKihonssyurui(), "給付日額", "（ＩＲ）基本Ｓ種類");
        exClassificationEquals(khSeikyuusyoBean.getIrTmttknitenkbn(), C_Tmttknitenkbn.ITEN, "（ＩＲ）積立金移転区分");
        exStringEquals(khSeikyuusyoBean.getIrTmttknitenymd(), "2017年12月31日", "（ＩＲ）積立金移転日");
        exClassificationEquals(khSeikyuusyoBean.getIrKhhrshrjiyuu(), C_Khhrshrjiyuu.TUUJYOU, "（ＩＲ）契約保全返戻金支払事由");
        exClassificationEquals(khSeikyuusyoBean.getIrKhskssakuseijiyuu(), C_Khskssakuseijiyuu.OKYAKUSAMAMOUSIDE,
            "（ＩＲ）契約保全請求書作成事由");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkijyunkingaku(), BizCurrency.valueOf(100000), "（ＩＲ）基準金額（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrHrkkeiro(), C_Hrkkeiro.DANTAI, "（ＩＲ）払込経路");
        exNumericEquals(khSeikyuusyoBean.getIrSyouhnhanteikekka(), 999, "（ＩＲ）商品判定結果");
        exClassificationEquals(khSeikyuusyoBean.getIrKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "（ＩＲ）契約状態");
        exClassificationEquals(khSeikyuusyoBean.getIrZeiseitkkktkykhukaumu(), C_UmuKbn.ARI, "（ＩＲ）税制適格特約付加有無");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn1(), "", "（ＩＲ）登録家族氏名（カナ）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj1(), "", "（ＩＲ）登録家族氏名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj1(), "", "（ＩＲ）登録家族住所１（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj1(), "", "（ＩＲ）登録家族住所２（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj1(), "", "（ＩＲ）登録家族住所３（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno1(), "", "（ＩＲ）登録家族電話番号１");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi1(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn2(), "", "（ＩＲ）登録家族氏名（カナ）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj2(), "", "（ＩＲ）登録家族氏名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj2(), "", "（ＩＲ）登録家族住所１（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj2(), "", "（ＩＲ）登録家族住所２（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj2(), "", "（ＩＲ）登録家族住所３（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno2(), "", "（ＩＲ）登録家族電話番号２");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi2(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否２");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkn(), "契約者名（カナ）", "（ＩＲ）契約者名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKykdairinmkj(), "", "（ＩＲ）契約者代理人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrtkykhukaumu(), null, "（ＩＲ）契約者代理特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrMousideninkbn(), C_MousideninKbn.BLNK, "（ＩＲ）申出人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrknhatudoujyoutai(), C_KykdrknHtdjytKbn.BLNK, "（ＩＲ）契約者代理権発動状態");
        exStringEquals(khSeikyuusyoBean.getIrDrstiskkyknmkj(), "契約者名", "（ＩＲ）代理人指定先契約者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTyouhyoutitle(), null, "（ＩＲ）帳票タイトル");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg1(), null, "（ＩＲ）送付案内メッセージ１");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg2(), null, "（ＩＲ）送付案内メッセージ２");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg3(), null, "（ＩＲ）送付案内メッセージ３");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg4(), null, "（ＩＲ）送付案内メッセージ４");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg5(), null, "（ＩＲ）送付案内メッセージ５");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg6(), null, "（ＩＲ）送付案内メッセージ６");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg7(), null, "（ＩＲ）送付案内メッセージ７");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg8(), null, "（ＩＲ）送付案内メッセージ８");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg9(), null, "（ＩＲ）送付案内メッセージ９");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg10(), null, "（ＩＲ）送付案内メッセージ１０");

        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean) kSBean[1];

        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(), null, "（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(), "userId001", "（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(), "user001", "（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(),
            DateFormatUtil.dateKANJI(BizDate.getSysDate()), "（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(), "永久", "（ＩＲ）保存期間");
    }

    @Test
    @TestOrder(260)
    public void testEditBean_A26() {

        MockObjectManager.initialize();

        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;

        AM_User aMUser = new AM_User();

        aMUser.setUserId("userId001");
        aMUser.setUserNm("user001");
        changeCurrentUser(baseUserInfo, aMUser);

        editSeikyuusyoParam.setHhknseiymd(BizDate.valueOf(20151026));
        editSeikyuusyoParam.setHhknseiymdhenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setHhknsei(C_Hhknsei.MALE);
        editSeikyuusyoParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setBfrTargettkmokuhyouti(BizNumber.valueOf(101));
        editSeikyuusyoParam.setBfrKihonS(BizCurrency.valueOf(778));
        editSeikyuusyoParam.setBfrP(BizCurrency.valueOf(1566));
        editSeikyuusyoParam.setBfrTokuyakuNenkinsyuKbn(C_Nstknsyu.KAKUTEINENKIN);
        editSeikyuusyoParam.setBfrNkshrtkyknksyukkn(5);
        editSeikyuusyoParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU);
        editSeikyuusyoParam.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editSeikyuusyoParam.setGengkhouKbn(C_GengkhouKbn.SD);
        editSeikyuusyoParam.setHenkankumukbn(C_UmuKbn.ARI);
        editSeikyuusyoParam.setRstuukasyu(C_Tuukasyu.JPY);
        editSeikyuusyoParam.setNkshrtkykhnkkbn(C_NstkhKbn.NAIYOUHENKOU);
        editSeikyuusyoParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);
        editSeikyuusyoParam.setJyudkaigomaebaraiTkykhnkKbn(C_JyudkaigomaebaraiTkykhnkKbn.BLNK);
        editSeikyuusyoParam.setKihonshenkouumu(C_UmuKbn.NONE);
        editSeikyuusyoParam.setTmttknitenkbn(C_Tmttknitenkbn.ITEN_TORIKESI);
        editSeikyuusyoParam.setTmttknitenymd(BizDate.valueOf(20180201));
        editSeikyuusyoParam.setKhhrshrjiyuu(C_Khhrshrjiyuu.TUUJYOU);
        editSeikyuusyoParam.setKhskssakuseijiyuu(C_Khskssakuseijiyuu.KOBETUKANSYOU);
        editSeikyuusyoParam.setHenkougokjnkngk(BizCurrency.valueOf(100000));

        ReportServicesBean reSsBean = editSeikyuusyoTbl.editBean(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_SKS, syono15,
            khozenCommonParam, editSeikyuusyoParam);

        Object[] kSBean = reSsBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_SKS.getValue());

        exNumericEquals(kSBean.length, 2, "パラメータオブジェクトの要素数");

        exNumericEquals(reSsBean.getKensakuKeys().length, 1, "検索キー配列の要素数");
        exStringEquals(reSsBean.getKensakuKeys()[0], "12806345812", "検索キー");

        KhSeikyuusyoBean khSeikyuusyoBean = (KhSeikyuusyoBean) kSBean[0];

        exStringEquals(khSeikyuusyoBean.getIrSyono(), "12806345812", "（ＩＲ）証券番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinyno(), "1234567", "（ＩＲ）通信先郵便番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr1kj(), "通信先住所１", "（ＩＲ）通信先住所１（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr2kj(), "通信先住所２", "（ＩＲ）通信先住所２（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr3kj(), "通信先住所３", "（ＩＲ）通信先住所３（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsintelno(), "023-5677-8999", "（ＩＲ）通信先電話番号");
        exStringEquals(khSeikyuusyoBean.getIrBanknmkj(), "", "（ＩＲ）銀行名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrSitennmkj(), "", "（ＩＲ）支店名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrBankcd(), "", "（ＩＲ）銀行コード");
        exStringEquals(khSeikyuusyoBean.getIrSitencd(), "", "（ＩＲ）支店コード");

        exStringEquals(khSeikyuusyoBean.getIrKzmeiginmkn(), "", "（ＩＲ）口座名義人氏名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkj(), "契約者名", "（ＩＲ）契約者名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKkkyktdk(), C_Tdk.HONNIN, "（ＩＲ）契約管理契約者続柄");
        exStringEquals(khSeikyuusyoBean.getIrHhknnmkj(), "被保険者名", "（ＩＲ）被保険者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrHhknseiymd(), "", "（ＩＲ）被保険者生年月日");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseiymdhenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者生年月日変更有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknsei(), C_Hhknsei.MALE, "（ＩＲ）被保険者性別");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseihenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者性別変更有無");
        exStringEquals(khSeikyuusyoBean.getIrStdrsknmkj(), "長島", "（ＩＲ）指定代理請求人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrFatcakakuninyhkbn(), C_YouhiblnkKbn.HUYOU, "（ＩＲ）FATCA確認要否区分");
        exClassificationEquals(khSeikyuusyoBean.getIrAeoikakuninyhkbn(), C_YouhiblnkKbn.HUYOU, "（ＩＲ）ＡＥＯＩ確認要否区分");

        exClassificationEquals(khSeikyuusyoBean.getIrTargettkkbn(), C_TargetTkKbn.BLNK, "（ＩＲ）ターゲット特約区分");
        exNumericEquals(khSeikyuusyoBean.getIrAftertargettkmokuhyouti(), 101, "（ＩＲ）変更後ターゲット特約目標値");
        exNumericEquals(khSeikyuusyoBean.getIrBeforetargettkmokuhyouti(), 200, "（ＩＲ）変更前ターゲット特約目標値");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforekihons(), BizCurrency.valueOf(100), "（ＩＲ）基本保険金額（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkihons(), BizCurrency.valueOf(778), "（ＩＲ）基本保険金額（変更後）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforep(), BizCurrency.valueOf(200), "（ＩＲ）保険料（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterp(), BizCurrency.valueOf(1566), "（ＩＲ）保険料（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrKyktuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）契約通貨種類");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj1(), "小野", "（ＩＲ）死亡受取人名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj2(), "", "（ＩＲ）死亡受取人名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj3(), "", "（ＩＲ）死亡受取人名（漢字）３");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj4(), "", "（ＩＲ）死亡受取人名（漢字）４");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkn(), "受取人名（カナ）", "（ＩＲ）死亡受取人名（カナ）");
        exClassificationEquals(khSeikyuusyoBean.getIrYokinkbn(), C_YokinKbn.BLNK, "（ＩＲ）預金種目区分");
        exStringEquals(khSeikyuusyoBean.getIrKouzano(), "", "（ＩＲ）口座番号");

        exClassificationEquals(khSeikyuusyoBean.getIrAfternkshrtkyknksyukbn(), C_Nstknsyu.KAKUTEINENKIN,
            "（ＩＲ）変更後年金支払特約年金種類区分");
        exClassificationEquals(khSeikyuusyoBean.getIrBiforenkshrtkyknksyukbn(), C_Nstknsyu.BLNK, "（ＩＲ）変更前年金支払特約年金種類区分");
        exNumericEquals(khSeikyuusyoBean.getIrAfternkshrtkyknkkkn(), 5, "（ＩＲ）変更後年金支払特約年金期間");
        exNumericEquals(khSeikyuusyoBean.getIrBeforenkshrtkyknkkkn(), 10, "（ＩＲ）変更前年金支払特約年金期間");
        exStringEquals(khSeikyuusyoBean.getIrNkuktnm(), "森君", "（ＩＲ）年金受取人名");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari1(), BizNumber.valueOf(230), "（ＩＲ）死亡受取人分割割合１");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari2(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合２");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari3(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合３");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari4(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合４");
        exClassificationEquals(khSeikyuusyoBean.getIrTargettkhnkkbn(), C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU,
            "（ＩＲ）ターゲット特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKaiyakujiyuu(), C_Kaiyakujiyuu.TUUJYOU, "（ＩＲ）解約事由");
        exClassificationEquals(khSeikyuusyoBean.getIrGengkhoukbn(), C_GengkhouKbn.SD, "（ＩＲ）減額方法区分");
        exNumericEquals(khSeikyuusyoBean.getIrSbuktnin(), 2, "（ＩＲ）死亡受取人人数");
        exClassificationEquals(khSeikyuusyoBean.getIrSbuuktkbn(), C_UktKbn.BLNK, "（ＩＲ）死亡受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrYenshrtkumu(), C_UmuKbn.ARI, "（ＩＲ）円支払特約有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHenkankinumukbn(), C_UmuKbn.ARI, "（ＩＲ）返還金有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrRstuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）領収通貨種類");
        exClassificationEquals(khSeikyuusyoBean.getIrNkshrtkykhnkkbn(), C_NstkhKbn.NAIYOUHENKOU, "（ＩＲ）年金支払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrMeigihnkjiyuu(), C_Meigihnkjiyuu.KYK, "（ＩＲ）名義変更事由");
        exClassificationEquals(khSeikyuusyoBean.getIrNkhknumu(), C_UmuKbn.ARI, "（ＩＲ）年金保険有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSiboukyhkuktumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡給付金受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn1(), C_UmuKbn.ARI, "（ＩＲ）死亡保険金受取人有無区分１");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn2(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分２");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn3(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分３");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn4(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分４");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu1(), C_UmuKbn.ARI, "（ＩＲ）死亡受取人分割割合有無１");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu2(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無２");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu3(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無３");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu4(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無４");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyhukaumu(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyuuktmukbn(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrStdruktkbn(), C_UktKbn.BLNK, "（ＩＲ）指定代理受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrJyudkaigomaebrtkykhnkkbn(), C_JyudkaigomaebaraiTkykhnkKbn.BLNK,
            "（ＩＲ）重度介護前払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKeihikbn(), C_KeihiKbn.KEIHIDOUITU, "（ＩＲ）契被区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKihonshenkouumu(), C_UmuKbn.NONE, "（ＩＲ）基本Ｓ変更有無");
        exStringEquals(khSeikyuusyoBean.getIrKihonssyurui(), "基本保険金額", "（ＩＲ）基本Ｓ種類");
        exClassificationEquals(khSeikyuusyoBean.getIrTmttknitenkbn(), C_Tmttknitenkbn.ITEN_TORIKESI, "（ＩＲ）積立金移転区分");
        exStringEquals(khSeikyuusyoBean.getIrTmttknitenymd(), "2018年 2月 1日", "（ＩＲ）積立金移転日");
        exClassificationEquals(khSeikyuusyoBean.getIrKhhrshrjiyuu(), C_Khhrshrjiyuu.TUUJYOU, "（ＩＲ）契約保全返戻金支払事由");
        exClassificationEquals(khSeikyuusyoBean.getIrKhskssakuseijiyuu(), C_Khskssakuseijiyuu.KOBETUKANSYOU,
            "（ＩＲ）契約保全請求書作成事由");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkijyunkingaku(), BizCurrency.valueOf(100000), "（ＩＲ）基準金額（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrHrkkeiro(), C_Hrkkeiro.DANTAI, "（ＩＲ）払込経路");
        exNumericEquals(khSeikyuusyoBean.getIrSyouhnhanteikekka(), 999, "（ＩＲ）商品判定結果");
        exClassificationEquals(khSeikyuusyoBean.getIrKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "（ＩＲ）契約状態");
        exClassificationEquals(khSeikyuusyoBean.getIrZeiseitkkktkykhukaumu(), C_UmuKbn.ARI, "（ＩＲ）税制適格特約付加有無");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn1(), "", "（ＩＲ）登録家族氏名（カナ）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj1(), "", "（ＩＲ）登録家族氏名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj1(), "", "（ＩＲ）登録家族住所１（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj1(), "", "（ＩＲ）登録家族住所２（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj1(), "", "（ＩＲ）登録家族住所３（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno1(), "", "（ＩＲ）登録家族電話番号１");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi1(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn2(), "", "（ＩＲ）登録家族氏名（カナ）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj2(), "", "（ＩＲ）登録家族氏名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj2(), "", "（ＩＲ）登録家族住所１（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj2(), "", "（ＩＲ）登録家族住所２（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj2(), "", "（ＩＲ）登録家族住所３（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno2(), "", "（ＩＲ）登録家族電話番号２");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi2(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否２");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkn(), "契約者名（カナ）", "（ＩＲ）契約者名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKykdairinmkj(), "", "（ＩＲ）契約者代理人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrtkykhukaumu(), null, "（ＩＲ）契約者代理特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrMousideninkbn(), C_MousideninKbn.BLNK, "（ＩＲ）申出人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrknhatudoujyoutai(), C_KykdrknHtdjytKbn.BLNK, "（ＩＲ）契約者代理権発動状態");
        exStringEquals(khSeikyuusyoBean.getIrDrstiskkyknmkj(), "契約者名", "（ＩＲ）代理人指定先契約者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTyouhyoutitle(), null, "（ＩＲ）帳票タイトル");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg1(), null, "（ＩＲ）送付案内メッセージ１");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg2(), null, "（ＩＲ）送付案内メッセージ２");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg3(), null, "（ＩＲ）送付案内メッセージ３");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg4(), null, "（ＩＲ）送付案内メッセージ４");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg5(), null, "（ＩＲ）送付案内メッセージ５");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg6(), null, "（ＩＲ）送付案内メッセージ６");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg7(), null, "（ＩＲ）送付案内メッセージ７");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg8(), null, "（ＩＲ）送付案内メッセージ８");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg9(), null, "（ＩＲ）送付案内メッセージ９");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg10(), null, "（ＩＲ）送付案内メッセージ１０");

        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean) kSBean[1];

        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(), null, "（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(), "userId001", "（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(), "user001", "（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(),
            DateFormatUtil.dateKANJI(BizDate.getSysDate()), "（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(), "永久", "（ＩＲ）保存期間");
    }

    @Test
    @TestOrder(270)
    public void testEditBean_A27() {

        MockObjectManager.initialize();

        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;

        AM_User aMUser = new AM_User();

        aMUser.setUserId("userId001");
        aMUser.setUserNm("user001");

        changeCurrentUser(baseUserInfo, aMUser);

        YuyuBizConfig.getInstance().setCallcentersosikicd("6620000");
        baseUserInfo.refresh();

        RayBCPBean bcpBean = SWAKInjector.getInstance(RayBCPBean.class);
        bcpBean.setBcp(true);
        bcpBean.setDaikouSosikiCd("6620000");
        RayCreator.create();

        editSeikyuusyoParam.setHhknseiymd(BizDate.valueOf(20151026));
        editSeikyuusyoParam.setHhknseiymdhenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setHhknsei(C_Hhknsei.MALE);
        editSeikyuusyoParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setBfrTargettkmokuhyouti(BizNumber.valueOf(101));
        editSeikyuusyoParam.setBfrKihonS(BizCurrency.valueOf(778));
        editSeikyuusyoParam.setBfrP(BizCurrency.valueOf(1566));
        editSeikyuusyoParam.setBfrTokuyakuNenkinsyuKbn(C_Nstknsyu.KAKUTEINENKIN);
        editSeikyuusyoParam.setBfrNkshrtkyknksyukkn(5);
        editSeikyuusyoParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU);
        editSeikyuusyoParam.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editSeikyuusyoParam.setGengkhouKbn(C_GengkhouKbn.SD);
        editSeikyuusyoParam.setHenkankumukbn(C_UmuKbn.ARI);
        editSeikyuusyoParam.setRstuukasyu(C_Tuukasyu.JPY);
        editSeikyuusyoParam.setNkshrtkykhnkkbn(C_NstkhKbn.NAIYOUHENKOU);
        editSeikyuusyoParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);
        editSeikyuusyoParam.setJyudkaigomaebaraiTkykhnkKbn(C_JyudkaigomaebaraiTkykhnkKbn.KAIYAKU);
        editSeikyuusyoParam.setKihonshenkouumu(C_UmuKbn.NONE);
        editSeikyuusyoParam.setTmttknitenkbn(C_Tmttknitenkbn.ITEN_TORIKESI);
        editSeikyuusyoParam.setTmttknitenymd(null);
        editSeikyuusyoParam.setKhhrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSeikyuusyoParam.setKhskssakuseijiyuu(C_Khskssakuseijiyuu.BLNK);
        editSeikyuusyoParam.setHenkougokjnkngk(BizCurrency.valueOf(100000));

        ReportServicesBean reSsBean =  editSeikyuusyoTbl.editBean(C_SyoruiCdKbn.KK_TUMITATEKINITEN_SKS, syono16,
            khozenCommonParam, editSeikyuusyoParam);

        Object[] kSBean = reSsBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_TUMITATEKINITEN_SKS.getValue());

        exNumericEquals(kSBean.length, 2, "パラメータオブジェクトの要素数");

        exNumericEquals(reSsBean.getKensakuKeys().length, 1, "検索キー配列の要素数");
        exStringEquals(reSsBean.getKensakuKeys()[0], "12806345823", "検索キー");

        KhSeikyuusyoBean khSeikyuusyoBean = (KhSeikyuusyoBean)kSBean[0];

        exStringEquals(khSeikyuusyoBean.getIrSyono(), "12806345823", "（ＩＲ）証券番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinyno(), "1234567", "（ＩＲ）通信先郵便番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr1kj(), "通信先住所１", "（ＩＲ）通信先住所１（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr2kj(), "通信先住所２", "（ＩＲ）通信先住所２（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr3kj(), "通信先住所３", "（ＩＲ）通信先住所３（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsintelno(), "023-5677-8999", "（ＩＲ）通信先電話番号");
        exStringEquals(khSeikyuusyoBean.getIrBanknmkj(), "", "（ＩＲ）銀行名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrSitennmkj(), "", "（ＩＲ）支店名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrBankcd(), "", "（ＩＲ）銀行コード");
        exStringEquals(khSeikyuusyoBean.getIrSitencd(), "", "（ＩＲ）支店コード");

        exStringEquals(khSeikyuusyoBean.getIrKzmeiginmkn(), "", "（ＩＲ）口座名義人氏名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkj(), "契約者名", "（ＩＲ）契約者名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKkkyktdk(), C_Tdk.HGU, "（ＩＲ）契約管理契約者続柄");
        exStringEquals(khSeikyuusyoBean.getIrHhknnmkj(), "被保険者名", "（ＩＲ）被保険者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrHhknseiymd(), "", "（ＩＲ）被保険者生年月日");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseiymdhenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者生年月日変更有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknsei(), C_Hhknsei.MALE, "（ＩＲ）被保険者性別");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseihenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者性別変更有無");
        exStringEquals(khSeikyuusyoBean.getIrStdrsknmkj(), "長島", "（ＩＲ）指定代理請求人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrFatcakakuninyhkbn(), C_YouhiblnkKbn.HUYOU, "（ＩＲ）FATCA確認要否区分");
        exClassificationEquals(khSeikyuusyoBean.getIrAeoikakuninyhkbn(), C_YouhiblnkKbn.HUYOU, "（ＩＲ）ＡＥＯＩ確認要否区分");

        exClassificationEquals(khSeikyuusyoBean.getIrTargettkkbn(), C_TargetTkKbn.BLNK, "（ＩＲ）ターゲット特約区分");
        exNumericEquals(khSeikyuusyoBean.getIrAftertargettkmokuhyouti(), 101, "（ＩＲ）変更後ターゲット特約目標値");
        exNumericEquals(khSeikyuusyoBean.getIrBeforetargettkmokuhyouti(), 200, "（ＩＲ）変更前ターゲット特約目標値");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforekihons(), BizCurrency.valueOf(100), "（ＩＲ）基本保険金額（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkihons(),  BizCurrency.valueOf(778), "（ＩＲ）基本保険金額（変更後）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforep(), BizCurrency.valueOf(200), "（ＩＲ）保険料（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterp(), BizCurrency.valueOf(1566), "（ＩＲ）保険料（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrKyktuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）契約通貨種類");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj1(), "小野", "（ＩＲ）死亡受取人名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj2(), "", "（ＩＲ）死亡受取人名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj3(), "", "（ＩＲ）死亡受取人名（漢字）３");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj4(), "", "（ＩＲ）死亡受取人名（漢字）４");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkn(), "受取人名（カナ）", "（ＩＲ）死亡受取人名（カナ）");
        exClassificationEquals(khSeikyuusyoBean.getIrYokinkbn(), C_YokinKbn.BLNK, "（ＩＲ）預金種目区分");
        exStringEquals(khSeikyuusyoBean.getIrKouzano(), "", "（ＩＲ）口座番号");

        exClassificationEquals(khSeikyuusyoBean.getIrAfternkshrtkyknksyukbn(), C_Nstknsyu.KAKUTEINENKIN, "（ＩＲ）変更後年金支払特約年金種類区分");
        exClassificationEquals(khSeikyuusyoBean.getIrBiforenkshrtkyknksyukbn(), C_Nstknsyu.BLNK, "（ＩＲ）変更前年金支払特約年金種類区分");
        exNumericEquals(khSeikyuusyoBean.getIrAfternkshrtkyknkkkn(), 5, "（ＩＲ）変更後年金支払特約年金期間");
        exNumericEquals(khSeikyuusyoBean.getIrBeforenkshrtkyknkkkn(), 10, "（ＩＲ）変更前年金支払特約年金期間");
        exStringEquals(khSeikyuusyoBean.getIrNkuktnm(), "森君", "（ＩＲ）年金受取人名");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari1(), BizNumber.valueOf(230), "（ＩＲ）死亡受取人分割割合１");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari2(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合２");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari3(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合３");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari4(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合４");
        exClassificationEquals(khSeikyuusyoBean.getIrTargettkhnkkbn(), C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU, "（ＩＲ）ターゲット特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKaiyakujiyuu(), C_Kaiyakujiyuu.TUUJYOU, "（ＩＲ）解約事由");
        exClassificationEquals(khSeikyuusyoBean.getIrGengkhoukbn(), C_GengkhouKbn.SD, "（ＩＲ）減額方法区分");
        exNumericEquals(khSeikyuusyoBean.getIrSbuktnin(), 2, "（ＩＲ）死亡受取人人数");
        exClassificationEquals(khSeikyuusyoBean.getIrSbuuktkbn(), C_UktKbn.BLNK, "（ＩＲ）死亡受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrYenshrtkumu(), C_UmuKbn.ARI, "（ＩＲ）円支払特約有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHenkankinumukbn(), C_UmuKbn.ARI, "（ＩＲ）返還金有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrRstuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）領収通貨種類");
        exClassificationEquals(khSeikyuusyoBean.getIrNkshrtkykhnkkbn(), C_NstkhKbn.NAIYOUHENKOU, "（ＩＲ）年金支払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrMeigihnkjiyuu(), C_Meigihnkjiyuu.KYK, "（ＩＲ）名義変更事由");
        exClassificationEquals(khSeikyuusyoBean.getIrNkhknumu(), C_UmuKbn.ARI, "（ＩＲ）年金保険有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSiboukyhkuktumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡給付金受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn1(), C_UmuKbn.ARI, "（ＩＲ）死亡保険金受取人有無区分１");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn2(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分２");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn3(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分３");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn4(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分４");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu1(), C_UmuKbn.ARI, "（ＩＲ）死亡受取人分割割合有無１");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu2(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無２");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu3(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無３");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu4(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無４");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyhukaumu(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyuuktmukbn(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrStdruktkbn(), C_UktKbn.BLNK, "（ＩＲ）指定代理受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrJyudkaigomaebrtkykhnkkbn(),C_JyudkaigomaebaraiTkykhnkKbn.KAIYAKU, "（ＩＲ）重度介護前払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKeihikbn(),C_KeihiKbn.BLNK,"（ＩＲ）契被区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKihonshenkouumu(),C_UmuKbn.NONE,"（ＩＲ）基本Ｓ変更有無");
        exStringEquals(khSeikyuusyoBean.getIrKihonssyurui(), "給付日額", "（ＩＲ）基本Ｓ種類");
        exClassificationEquals(khSeikyuusyoBean.getIrTmttknitenkbn(), C_Tmttknitenkbn.ITEN_TORIKESI, "（ＩＲ）積立金移転区分");
        exStringEquals(khSeikyuusyoBean.getIrTmttknitenymd(), null, "（ＩＲ）積立金移転日");
        exClassificationEquals(khSeikyuusyoBean.getIrKhhrshrjiyuu(), C_Khhrshrjiyuu.BLNK, "（ＩＲ）契約保全返戻金支払事由");
        exClassificationEquals(khSeikyuusyoBean.getIrKhskssakuseijiyuu(), C_Khskssakuseijiyuu.BLNK, "（ＩＲ）契約保全請求書作成事由");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkijyunkingaku(), BizCurrency.valueOf(100000), "（ＩＲ）基準金額（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrHrkkeiro(), C_Hrkkeiro.DANTAI, "（ＩＲ）払込経路");
        exNumericEquals(khSeikyuusyoBean.getIrSyouhnhanteikekka(), 999, "（ＩＲ）商品判定結果");
        exClassificationEquals(khSeikyuusyoBean.getIrKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "（ＩＲ）契約状態");
        exClassificationEquals(khSeikyuusyoBean.getIrZeiseitkkktkykhukaumu(), C_UmuKbn.ARI, "（ＩＲ）税制適格特約付加有無");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn1(), "", "（ＩＲ）登録家族氏名（カナ）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj1(), "", "（ＩＲ）登録家族氏名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj1(), "", "（ＩＲ）登録家族住所１（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj1(), "", "（ＩＲ）登録家族住所２（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj1(), "", "（ＩＲ）登録家族住所３（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno1(), "", "（ＩＲ）登録家族電話番号１");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi1(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn2(), "", "（ＩＲ）登録家族氏名（カナ）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj2(), "", "（ＩＲ）登録家族氏名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj2(), "", "（ＩＲ）登録家族住所１（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj2(), "", "（ＩＲ）登録家族住所２（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj2(), "", "（ＩＲ）登録家族住所３（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno2(), "", "（ＩＲ）登録家族電話番号２");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi2(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否２");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkn(), "契約者名（カナ）", "（ＩＲ）契約者名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKykdairinmkj(), "", "（ＩＲ）契約者代理人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrtkykhukaumu(), null, "（ＩＲ）契約者代理特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrMousideninkbn(), C_MousideninKbn.BLNK, "（ＩＲ）申出人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrknhatudoujyoutai(), C_KykdrknHtdjytKbn.BLNK, "（ＩＲ）契約者代理権発動状態");
        exStringEquals(khSeikyuusyoBean.getIrDrstiskkyknmkj(), "契約者名", "（ＩＲ）代理人指定先契約者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTyouhyoutitle(), null, "（ＩＲ）帳票タイトル");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg1(), null, "（ＩＲ）送付案内メッセージ１");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg2(), null, "（ＩＲ）送付案内メッセージ２");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg3(), null, "（ＩＲ）送付案内メッセージ３");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg4(), null, "（ＩＲ）送付案内メッセージ４");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg5(), null, "（ＩＲ）送付案内メッセージ５");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg6(), null, "（ＩＲ）送付案内メッセージ６");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg7(), null, "（ＩＲ）送付案内メッセージ７");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg8(), null, "（ＩＲ）送付案内メッセージ８");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg9(), null, "（ＩＲ）送付案内メッセージ９");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg10(), null, "（ＩＲ）送付案内メッセージ１０");

        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean)kSBean[1];

        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(), "スミセイコ－ルセンタ－", "（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(), DateFormatUtil.dateKANJI(BizDate.getSysDate()), "（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(), null, "（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(), null, "（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(), "　消滅後 5 年", "（ＩＲ）保存期間");
    }

    @Test
    @TestOrder(280)
    public void testEditBean_A28() {

        MockObjectManager.initialize();

        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;

        AM_User aMUser = new AM_User();

        aMUser.setUserId("userId001");
        aMUser.setUserNm("user001");

        changeCurrentUser(baseUserInfo, aMUser);

        YuyuBizConfig.getInstance().setCallcentersosikicd("6620000");
        baseUserInfo.refresh();

        RayBCPBean bcpBean = SWAKInjector.getInstance(RayBCPBean.class);
        bcpBean.setBcp(true);
        bcpBean.setDaikouSosikiCd("6620000");
        RayCreator.create();

        editSeikyuusyoParam.setHhknseiymd(BizDate.valueOf(20151026));
        editSeikyuusyoParam.setHhknseiymdhenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setHhknsei(C_Hhknsei.MALE);
        editSeikyuusyoParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setBfrTargettkmokuhyouti(BizNumber.valueOf(101));
        editSeikyuusyoParam.setBfrKihonS(BizCurrency.valueOf(778));
        editSeikyuusyoParam.setBfrP(BizCurrency.valueOf(1566));
        editSeikyuusyoParam.setBfrTokuyakuNenkinsyuKbn(C_Nstknsyu.KAKUTEINENKIN);
        editSeikyuusyoParam.setBfrNkshrtkyknksyukkn(5);
        editSeikyuusyoParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU);
        editSeikyuusyoParam.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editSeikyuusyoParam.setGengkhouKbn(C_GengkhouKbn.SD);
        editSeikyuusyoParam.setHenkankumukbn(C_UmuKbn.ARI);
        editSeikyuusyoParam.setRstuukasyu(C_Tuukasyu.JPY);
        editSeikyuusyoParam.setNkshrtkykhnkkbn(C_NstkhKbn.NAIYOUHENKOU);
        editSeikyuusyoParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);
        editSeikyuusyoParam.setJyudkaigomaebaraiTkykhnkKbn(C_JyudkaigomaebaraiTkykhnkKbn.KAIYAKU);
        editSeikyuusyoParam.setKihonshenkouumu(C_UmuKbn.NONE);
        editSeikyuusyoParam.setTmttknitenkbn(C_Tmttknitenkbn.ITEN_TORIKESI);
        editSeikyuusyoParam.setTmttknitenymd(null);
        editSeikyuusyoParam.setKhhrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSeikyuusyoParam.setKhskssakuseijiyuu(C_Khskssakuseijiyuu.BLNK);
        editSeikyuusyoParam.setHenkougokjnkngk(BizCurrency.valueOf(100000));

        ReportServicesBean reSsBean =  editSeikyuusyoTbl.editBean(C_SyoruiCdKbn.KK_ADRHNK_SKS, syono16,
            khozenCommonParam, editSeikyuusyoParam);

        Object[] kSBean = reSsBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_ADRHNK_SKS.getValue());

        exNumericEquals(kSBean.length, 2, "パラメータオブジェクトの要素数");

        exNumericEquals(reSsBean.getKensakuKeys().length, 1, "検索キー配列の要素数");
        exStringEquals(reSsBean.getKensakuKeys()[0], "12806345823", "検索キー");

        KhSeikyuusyoBean khSeikyuusyoBean = (KhSeikyuusyoBean)kSBean[0];

        exStringEquals(khSeikyuusyoBean.getIrSyono(), "12806345823", "（ＩＲ）証券番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinyno(), "1234567", "（ＩＲ）通信先郵便番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr1kj(), "通信先住所１", "（ＩＲ）通信先住所１（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr2kj(), "通信先住所２", "（ＩＲ）通信先住所２（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr3kj(), "通信先住所３", "（ＩＲ）通信先住所３（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsintelno(), "023-5677-8999", "（ＩＲ）通信先電話番号");
        exStringEquals(khSeikyuusyoBean.getIrBanknmkj(), "", "（ＩＲ）銀行名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrSitennmkj(), "", "（ＩＲ）支店名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrBankcd(), "", "（ＩＲ）銀行コード");
        exStringEquals(khSeikyuusyoBean.getIrSitencd(), "", "（ＩＲ）支店コード");

        exStringEquals(khSeikyuusyoBean.getIrKzmeiginmkn(), "", "（ＩＲ）口座名義人氏名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkj(), "契約者名", "（ＩＲ）契約者名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKkkyktdk(), C_Tdk.HGU, "（ＩＲ）契約管理契約者続柄");
        exStringEquals(khSeikyuusyoBean.getIrHhknnmkj(), "被保険者名", "（ＩＲ）被保険者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrHhknseiymd(), "", "（ＩＲ）被保険者生年月日");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseiymdhenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者生年月日変更有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknsei(), C_Hhknsei.MALE, "（ＩＲ）被保険者性別");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseihenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者性別変更有無");
        exStringEquals(khSeikyuusyoBean.getIrStdrsknmkj(), "長島", "（ＩＲ）指定代理請求人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrFatcakakuninyhkbn(), C_YouhiblnkKbn.HUYOU, "（ＩＲ）FATCA確認要否区分");
        exClassificationEquals(khSeikyuusyoBean.getIrAeoikakuninyhkbn(), C_YouhiblnkKbn.HUYOU, "（ＩＲ）ＡＥＯＩ確認要否区分");

        exClassificationEquals(khSeikyuusyoBean.getIrTargettkkbn(), C_TargetTkKbn.BLNK, "（ＩＲ）ターゲット特約区分");
        exNumericEquals(khSeikyuusyoBean.getIrAftertargettkmokuhyouti(), 101, "（ＩＲ）変更後ターゲット特約目標値");
        exNumericEquals(khSeikyuusyoBean.getIrBeforetargettkmokuhyouti(), 200, "（ＩＲ）変更前ターゲット特約目標値");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforekihons(), BizCurrency.valueOf(100), "（ＩＲ）基本保険金額（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkihons(),  BizCurrency.valueOf(778), "（ＩＲ）基本保険金額（変更後）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforep(), BizCurrency.valueOf(200), "（ＩＲ）保険料（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterp(), BizCurrency.valueOf(1566), "（ＩＲ）保険料（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrKyktuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）契約通貨種類");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj1(), "小野", "（ＩＲ）死亡受取人名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj2(), "", "（ＩＲ）死亡受取人名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj3(), "", "（ＩＲ）死亡受取人名（漢字）３");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj4(), "", "（ＩＲ）死亡受取人名（漢字）４");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkn(), "受取人名（カナ）", "（ＩＲ）死亡受取人名（カナ）");
        exClassificationEquals(khSeikyuusyoBean.getIrYokinkbn(), C_YokinKbn.BLNK, "（ＩＲ）預金種目区分");
        exStringEquals(khSeikyuusyoBean.getIrKouzano(), "", "（ＩＲ）口座番号");

        exClassificationEquals(khSeikyuusyoBean.getIrAfternkshrtkyknksyukbn(), C_Nstknsyu.KAKUTEINENKIN, "（ＩＲ）変更後年金支払特約年金種類区分");
        exClassificationEquals(khSeikyuusyoBean.getIrBiforenkshrtkyknksyukbn(), C_Nstknsyu.BLNK, "（ＩＲ）変更前年金支払特約年金種類区分");
        exNumericEquals(khSeikyuusyoBean.getIrAfternkshrtkyknkkkn(), 5, "（ＩＲ）変更後年金支払特約年金期間");
        exNumericEquals(khSeikyuusyoBean.getIrBeforenkshrtkyknkkkn(), 10, "（ＩＲ）変更前年金支払特約年金期間");
        exStringEquals(khSeikyuusyoBean.getIrNkuktnm(), "森君", "（ＩＲ）年金受取人名");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari1(), BizNumber.valueOf(230), "（ＩＲ）死亡受取人分割割合１");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari2(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合２");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari3(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合３");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari4(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合４");
        exClassificationEquals(khSeikyuusyoBean.getIrTargettkhnkkbn(), C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU, "（ＩＲ）ターゲット特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKaiyakujiyuu(), C_Kaiyakujiyuu.TUUJYOU, "（ＩＲ）解約事由");
        exClassificationEquals(khSeikyuusyoBean.getIrGengkhoukbn(), C_GengkhouKbn.SD, "（ＩＲ）減額方法区分");
        exNumericEquals(khSeikyuusyoBean.getIrSbuktnin(), 2, "（ＩＲ）死亡受取人人数");
        exClassificationEquals(khSeikyuusyoBean.getIrSbuuktkbn(), C_UktKbn.BLNK, "（ＩＲ）死亡受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrYenshrtkumu(), C_UmuKbn.ARI, "（ＩＲ）円支払特約有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHenkankinumukbn(), C_UmuKbn.ARI, "（ＩＲ）返還金有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrRstuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）領収通貨種類");
        exClassificationEquals(khSeikyuusyoBean.getIrNkshrtkykhnkkbn(), C_NstkhKbn.NAIYOUHENKOU, "（ＩＲ）年金支払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrMeigihnkjiyuu(), C_Meigihnkjiyuu.KYK, "（ＩＲ）名義変更事由");
        exClassificationEquals(khSeikyuusyoBean.getIrNkhknumu(), C_UmuKbn.ARI, "（ＩＲ）年金保険有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSiboukyhkuktumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡給付金受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn1(), C_UmuKbn.ARI, "（ＩＲ）死亡保険金受取人有無区分１");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn2(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分２");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn3(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分３");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn4(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分４");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu1(), C_UmuKbn.ARI, "（ＩＲ）死亡受取人分割割合有無１");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu2(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無２");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu3(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無３");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu4(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無４");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyhukaumu(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyuuktmukbn(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrStdruktkbn(), C_UktKbn.BLNK, "（ＩＲ）指定代理受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrJyudkaigomaebrtkykhnkkbn(),C_JyudkaigomaebaraiTkykhnkKbn.KAIYAKU, "（ＩＲ）重度介護前払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKeihikbn(),C_KeihiKbn.BLNK,"（ＩＲ）契被区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKihonshenkouumu(),C_UmuKbn.NONE,"（ＩＲ）基本Ｓ変更有無");
        exStringEquals(khSeikyuusyoBean.getIrKihonssyurui(), "給付日額", "（ＩＲ）基本Ｓ種類");
        exClassificationEquals(khSeikyuusyoBean.getIrTmttknitenkbn(), C_Tmttknitenkbn.ITEN_TORIKESI, "（ＩＲ）積立金移転区分");
        exStringEquals(khSeikyuusyoBean.getIrTmttknitenymd(), null, "（ＩＲ）積立金移転日");
        exClassificationEquals(khSeikyuusyoBean.getIrKhhrshrjiyuu(), C_Khhrshrjiyuu.BLNK, "（ＩＲ）契約保全返戻金支払事由");
        exClassificationEquals(khSeikyuusyoBean.getIrKhskssakuseijiyuu(), C_Khskssakuseijiyuu.BLNK, "（ＩＲ）契約保全請求書作成事由");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkijyunkingaku(), BizCurrency.valueOf(100000), "（ＩＲ）基準金額（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrHrkkeiro(), C_Hrkkeiro.DANTAI, "（ＩＲ）払込経路");
        exNumericEquals(khSeikyuusyoBean.getIrSyouhnhanteikekka(), 999, "（ＩＲ）商品判定結果");
        exClassificationEquals(khSeikyuusyoBean.getIrKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "（ＩＲ）契約状態");
        exClassificationEquals(khSeikyuusyoBean.getIrZeiseitkkktkykhukaumu(), C_UmuKbn.ARI, "（ＩＲ）税制適格特約付加有無");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn1(), "", "（ＩＲ）登録家族氏名（カナ）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj1(), "", "（ＩＲ）登録家族氏名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj1(), "", "（ＩＲ）登録家族住所１（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj1(), "", "（ＩＲ）登録家族住所２（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj1(), "", "（ＩＲ）登録家族住所３（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno1(), "", "（ＩＲ）登録家族電話番号１");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi1(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn2(), "", "（ＩＲ）登録家族氏名（カナ）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj2(), "", "（ＩＲ）登録家族氏名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj2(), "", "（ＩＲ）登録家族住所１（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj2(), "", "（ＩＲ）登録家族住所２（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj2(), "", "（ＩＲ）登録家族住所３（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno2(), "", "（ＩＲ）登録家族電話番号２");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi2(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否２");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkn(), "契約者名（カナ）", "（ＩＲ）契約者名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKykdairinmkj(), "", "（ＩＲ）契約者代理人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrtkykhukaumu(), null, "（ＩＲ）契約者代理特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrMousideninkbn(), C_MousideninKbn.BLNK, "（ＩＲ）申出人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrknhatudoujyoutai(), C_KykdrknHtdjytKbn.BLNK, "（ＩＲ）契約者代理権発動状態");
        exStringEquals(khSeikyuusyoBean.getIrDrstiskkyknmkj(), "契約者名", "（ＩＲ）代理人指定先契約者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTyouhyoutitle(), null, "（ＩＲ）帳票タイトル");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg1(), null, "（ＩＲ）送付案内メッセージ１");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg2(), null, "（ＩＲ）送付案内メッセージ２");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg3(), null, "（ＩＲ）送付案内メッセージ３");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg4(), null, "（ＩＲ）送付案内メッセージ４");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg5(), null, "（ＩＲ）送付案内メッセージ５");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg6(), null, "（ＩＲ）送付案内メッセージ６");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg7(), null, "（ＩＲ）送付案内メッセージ７");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg8(), null, "（ＩＲ）送付案内メッセージ８");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg9(), null, "（ＩＲ）送付案内メッセージ９");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg10(), null, "（ＩＲ）送付案内メッセージ１０");

        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean)kSBean[1];

        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(), "スミセイコ－ルセンタ－", "（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(), DateFormatUtil.dateKANJI(BizDate.getSysDate()), "（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(), null, "（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(), null, "（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(), "5 年", "（ＩＲ）保存期間");
    }

    @Test
    @TestOrder(290)
    public void testEditBean_A29() {

        MockObjectManager.initialize();

        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;

        AM_User aMUser = new AM_User();

        aMUser.setUserId("userId001");
        aMUser.setUserNm("user001");

        changeCurrentUser(baseUserInfo, aMUser);

        YuyuBizConfig.getInstance().setCallcentersosikicd("6620000");
        baseUserInfo.refresh();

        RayBCPBean bcpBean = SWAKInjector.getInstance(RayBCPBean.class);
        bcpBean.setBcp(true);
        bcpBean.setDaikouSosikiCd("6620000");
        RayCreator.create();

        editSeikyuusyoParam.setHhknseiymd(BizDate.valueOf(20151026));
        editSeikyuusyoParam.setHhknseiymdhenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setHhknsei(C_Hhknsei.MALE);
        editSeikyuusyoParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setBfrTargettkmokuhyouti(BizNumber.valueOf(101));
        editSeikyuusyoParam.setBfrKihonS(BizCurrency.valueOf(778));
        editSeikyuusyoParam.setBfrP(BizCurrency.valueOf(1566));
        editSeikyuusyoParam.setBfrTokuyakuNenkinsyuKbn(C_Nstknsyu.KAKUTEINENKIN);
        editSeikyuusyoParam.setBfrNkshrtkyknksyukkn(5);
        editSeikyuusyoParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU);
        editSeikyuusyoParam.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editSeikyuusyoParam.setGengkhouKbn(C_GengkhouKbn.SD);
        editSeikyuusyoParam.setHenkankumukbn(C_UmuKbn.ARI);
        editSeikyuusyoParam.setRstuukasyu(C_Tuukasyu.JPY);
        editSeikyuusyoParam.setNkshrtkykhnkkbn(C_NstkhKbn.NAIYOUHENKOU);
        editSeikyuusyoParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);
        editSeikyuusyoParam.setJyudkaigomaebaraiTkykhnkKbn(C_JyudkaigomaebaraiTkykhnkKbn.KAIYAKU);
        editSeikyuusyoParam.setKihonshenkouumu(C_UmuKbn.NONE);
        editSeikyuusyoParam.setTmttknitenkbn(C_Tmttknitenkbn.ITEN_TORIKESI);
        editSeikyuusyoParam.setTmttknitenymd(null);
        editSeikyuusyoParam.setKhhrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSeikyuusyoParam.setKhskssakuseijiyuu(C_Khskssakuseijiyuu.BLNK);
        editSeikyuusyoParam.setHenkougokjnkngk(BizCurrency.valueOf(100000));
        editSeikyuusyoParam.setYuuyokkntyoukaumu(C_UmuKbn.ARI);

        ReportServicesBean reSsBean =  editSeikyuusyoTbl.editBean(C_SyoruiCdKbn.KK_YENDTHNK_SKS, syono16,
            khozenCommonParam, editSeikyuusyoParam);

        Object[] kSBean = reSsBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_YENDTHNK_SKS.getValue());

        exNumericEquals(kSBean.length, 2, "パラメータオブジェクトの要素数");

        exNumericEquals(reSsBean.getKensakuKeys().length, 1, "検索キー配列の要素数");
        exStringEquals(reSsBean.getKensakuKeys()[0], "12806345823", "検索キー");

        KhSeikyuusyoBean khSeikyuusyoBean = (KhSeikyuusyoBean)kSBean[0];

        exStringEquals(khSeikyuusyoBean.getIrSyono(), "12806345823", "（ＩＲ）証券番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinyno(), "1234567", "（ＩＲ）通信先郵便番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr1kj(), "通信先住所１", "（ＩＲ）通信先住所１（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr2kj(), "通信先住所２", "（ＩＲ）通信先住所２（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr3kj(), "通信先住所３", "（ＩＲ）通信先住所３（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsintelno(), "023-5677-8999", "（ＩＲ）通信先電話番号");
        exStringEquals(khSeikyuusyoBean.getIrBanknmkj(), "", "（ＩＲ）銀行名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrSitennmkj(), "", "（ＩＲ）支店名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrBankcd(), "", "（ＩＲ）銀行コード");
        exStringEquals(khSeikyuusyoBean.getIrSitencd(), "", "（ＩＲ）支店コード");

        exStringEquals(khSeikyuusyoBean.getIrKzmeiginmkn(), "", "（ＩＲ）口座名義人氏名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkj(), "契約者名", "（ＩＲ）契約者名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKkkyktdk(), C_Tdk.HGU, "（ＩＲ）契約管理契約者続柄");
        exStringEquals(khSeikyuusyoBean.getIrHhknnmkj(), "被保険者名", "（ＩＲ）被保険者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrHhknseiymd(), "", "（ＩＲ）被保険者生年月日");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseiymdhenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者生年月日変更有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknsei(), C_Hhknsei.MALE, "（ＩＲ）被保険者性別");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseihenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者性別変更有無");
        exStringEquals(khSeikyuusyoBean.getIrStdrsknmkj(), "長島", "（ＩＲ）指定代理請求人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrFatcakakuninyhkbn(), C_YouhiblnkKbn.HUYOU, "（ＩＲ）FATCA確認要否区分");
        exClassificationEquals(khSeikyuusyoBean.getIrAeoikakuninyhkbn(), C_YouhiblnkKbn.HUYOU, "（ＩＲ）ＡＥＯＩ確認要否区分");

        exClassificationEquals(khSeikyuusyoBean.getIrTargettkkbn(), C_TargetTkKbn.BLNK, "（ＩＲ）ターゲット特約区分");
        exNumericEquals(khSeikyuusyoBean.getIrAftertargettkmokuhyouti(), 101, "（ＩＲ）変更後ターゲット特約目標値");
        exNumericEquals(khSeikyuusyoBean.getIrBeforetargettkmokuhyouti(), 200, "（ＩＲ）変更前ターゲット特約目標値");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforekihons(), BizCurrency.valueOf(100), "（ＩＲ）基本保険金額（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkihons(),  BizCurrency.valueOf(778), "（ＩＲ）基本保険金額（変更後）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforep(), BizCurrency.valueOf(200), "（ＩＲ）保険料（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterp(), BizCurrency.valueOf(1566), "（ＩＲ）保険料（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrKyktuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）契約通貨種類");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj1(), "小野", "（ＩＲ）死亡受取人名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj2(), "", "（ＩＲ）死亡受取人名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj3(), "", "（ＩＲ）死亡受取人名（漢字）３");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj4(), "", "（ＩＲ）死亡受取人名（漢字）４");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkn(), "受取人名（カナ）", "（ＩＲ）死亡受取人名（カナ）");
        exClassificationEquals(khSeikyuusyoBean.getIrYokinkbn(), C_YokinKbn.BLNK, "（ＩＲ）預金種目区分");
        exStringEquals(khSeikyuusyoBean.getIrKouzano(), "", "（ＩＲ）口座番号");

        exClassificationEquals(khSeikyuusyoBean.getIrAfternkshrtkyknksyukbn(), C_Nstknsyu.KAKUTEINENKIN, "（ＩＲ）変更後年金支払特約年金種類区分");
        exClassificationEquals(khSeikyuusyoBean.getIrBiforenkshrtkyknksyukbn(), C_Nstknsyu.BLNK, "（ＩＲ）変更前年金支払特約年金種類区分");
        exNumericEquals(khSeikyuusyoBean.getIrAfternkshrtkyknkkkn(), 5, "（ＩＲ）変更後年金支払特約年金期間");
        exNumericEquals(khSeikyuusyoBean.getIrBeforenkshrtkyknkkkn(), 10, "（ＩＲ）変更前年金支払特約年金期間");
        exStringEquals(khSeikyuusyoBean.getIrNkuktnm(), "森君", "（ＩＲ）年金受取人名");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari1(), BizNumber.valueOf(230), "（ＩＲ）死亡受取人分割割合１");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari2(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合２");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari3(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合３");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari4(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合４");
        exClassificationEquals(khSeikyuusyoBean.getIrTargettkhnkkbn(), C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU, "（ＩＲ）ターゲット特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKaiyakujiyuu(), C_Kaiyakujiyuu.TUUJYOU, "（ＩＲ）解約事由");
        exClassificationEquals(khSeikyuusyoBean.getIrGengkhoukbn(), C_GengkhouKbn.SD, "（ＩＲ）減額方法区分");
        exNumericEquals(khSeikyuusyoBean.getIrSbuktnin(), 2, "（ＩＲ）死亡受取人人数");
        exClassificationEquals(khSeikyuusyoBean.getIrSbuuktkbn(), C_UktKbn.BLNK, "（ＩＲ）死亡受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrYenshrtkumu(), C_UmuKbn.ARI, "（ＩＲ）円支払特約有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHenkankinumukbn(), C_UmuKbn.ARI, "（ＩＲ）返還金有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrRstuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）領収通貨種類");
        exClassificationEquals(khSeikyuusyoBean.getIrNkshrtkykhnkkbn(), C_NstkhKbn.NAIYOUHENKOU, "（ＩＲ）年金支払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrMeigihnkjiyuu(), C_Meigihnkjiyuu.KYK, "（ＩＲ）名義変更事由");
        exClassificationEquals(khSeikyuusyoBean.getIrNkhknumu(), C_UmuKbn.ARI, "（ＩＲ）年金保険有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSiboukyhkuktumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡給付金受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn1(), C_UmuKbn.ARI, "（ＩＲ）死亡保険金受取人有無区分１");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn2(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分２");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn3(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分３");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn4(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分４");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu1(), C_UmuKbn.ARI, "（ＩＲ）死亡受取人分割割合有無１");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu2(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無２");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu3(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無３");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu4(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無４");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyhukaumu(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyuuktmukbn(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrStdruktkbn(), C_UktKbn.BLNK, "（ＩＲ）指定代理受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrJyudkaigomaebrtkykhnkkbn(),C_JyudkaigomaebaraiTkykhnkKbn.KAIYAKU, "（ＩＲ）重度介護前払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKeihikbn(),C_KeihiKbn.BLNK,"（ＩＲ）契被区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKihonshenkouumu(),C_UmuKbn.NONE,"（ＩＲ）基本Ｓ変更有無");
        exStringEquals(khSeikyuusyoBean.getIrKihonssyurui(), "給付日額", "（ＩＲ）基本Ｓ種類");
        exClassificationEquals(khSeikyuusyoBean.getIrTmttknitenkbn(), C_Tmttknitenkbn.ITEN_TORIKESI, "（ＩＲ）積立金移転区分");
        exStringEquals(khSeikyuusyoBean.getIrTmttknitenymd(), null, "（ＩＲ）積立金移転日");
        exClassificationEquals(khSeikyuusyoBean.getIrKhhrshrjiyuu(), C_Khhrshrjiyuu.BLNK, "（ＩＲ）契約保全返戻金支払事由");
        exClassificationEquals(khSeikyuusyoBean.getIrKhskssakuseijiyuu(), C_Khskssakuseijiyuu.BLNK, "（ＩＲ）契約保全請求書作成事由");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkijyunkingaku(), BizCurrency.valueOf(100000), "（ＩＲ）基準金額（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrHrkkeiro(), C_Hrkkeiro.DANTAI, "（ＩＲ）払込経路");
        exNumericEquals(khSeikyuusyoBean.getIrSyouhnhanteikekka(), 999, "（ＩＲ）商品判定結果");
        exClassificationEquals(khSeikyuusyoBean.getIrKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "（ＩＲ）契約状態");
        exClassificationEquals(khSeikyuusyoBean.getIrZeiseitkkktkykhukaumu(), C_UmuKbn.ARI, "（ＩＲ）税制適格特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrYuuyokkntyoukaumu(), C_UmuKbn.ARI, "（ＩＲ）猶予期間超過有無");
        exClassificationEquals(khSeikyuusyoBean.getIrMousideikoukbn(), C_MousideIkouKbn.YENNENKIN, "（ＩＲ）申出移行区分");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn1(), "", "（ＩＲ）登録家族氏名（カナ）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj1(), "", "（ＩＲ）登録家族氏名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj1(), "", "（ＩＲ）登録家族住所１（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj1(), "", "（ＩＲ）登録家族住所２（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj1(), "", "（ＩＲ）登録家族住所３（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno1(), "", "（ＩＲ）登録家族電話番号１");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi1(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn2(), "", "（ＩＲ）登録家族氏名（カナ）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj2(), "", "（ＩＲ）登録家族氏名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj2(), "", "（ＩＲ）登録家族住所１（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj2(), "", "（ＩＲ）登録家族住所２（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj2(), "", "（ＩＲ）登録家族住所３（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno2(), "", "（ＩＲ）登録家族電話番号２");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi2(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否２");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkn(), "契約者名（カナ）", "（ＩＲ）契約者名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKykdairinmkj(), "", "（ＩＲ）契約者代理人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrtkykhukaumu(), null, "（ＩＲ）契約者代理特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrMousideninkbn(), C_MousideninKbn.BLNK, "（ＩＲ）申出人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrknhatudoujyoutai(), C_KykdrknHtdjytKbn.BLNK, "（ＩＲ）契約者代理権発動状態");
        exStringEquals(khSeikyuusyoBean.getIrDrstiskkyknmkj(), "契約者名", "（ＩＲ）代理人指定先契約者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTyouhyoutitle(), null, "（ＩＲ）帳票タイトル");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg1(), null, "（ＩＲ）送付案内メッセージ１");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg2(), null, "（ＩＲ）送付案内メッセージ２");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg3(), null, "（ＩＲ）送付案内メッセージ３");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg4(), null, "（ＩＲ）送付案内メッセージ４");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg5(), null, "（ＩＲ）送付案内メッセージ５");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg6(), null, "（ＩＲ）送付案内メッセージ６");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg7(), null, "（ＩＲ）送付案内メッセージ７");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg8(), null, "（ＩＲ）送付案内メッセージ８");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg9(), null, "（ＩＲ）送付案内メッセージ９");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg10(), null, "（ＩＲ）送付案内メッセージ１０");

        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean)kSBean[1];

        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(), "スミセイコ－ルセンタ－", "（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(), DateFormatUtil.dateKANJI(BizDate.getSysDate()), "（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(), null, "（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(), null, "（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(), "　消滅後 6 年", "（ＩＲ）保存期間");
    }

    @Test
    @TestOrder(300)
    public void testEditBean_A30() {

        MockObjectManager.initialize();

        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN2;

        AM_User aMUser = new AM_User();

        aMUser.setUserId("userId001");
        aMUser.setUserNm("user001");
        changeCurrentUser(baseUserInfo, aMUser);

        RayBCPBean bcpBean = SWAKInjector.getInstance(RayBCPBean.class);
        bcpBean.setBcp(false);
        bcpBean.setDaikouSosikiCd("6620000");
        RayCreator.create();

        editSeikyuusyoParam.setHhknseiymd(BizDate.valueOf(20151026));
        editSeikyuusyoParam.setHhknseiymdhenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setHhknsei(C_Hhknsei.MALE);
        editSeikyuusyoParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setBfrTargettkmokuhyouti(BizNumber.valueOf(101));
        editSeikyuusyoParam.setBfrKihonS(BizCurrency.valueOf(778));
        editSeikyuusyoParam.setBfrP(BizCurrency.valueOf(1566));
        editSeikyuusyoParam.setBfrTokuyakuNenkinsyuKbn(C_Nstknsyu.KAKUTEINENKIN);
        editSeikyuusyoParam.setBfrNkshrtkyknksyukkn(5);
        editSeikyuusyoParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU);
        editSeikyuusyoParam.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editSeikyuusyoParam.setGengkhouKbn(C_GengkhouKbn.SD);
        editSeikyuusyoParam.setHenkankumukbn(C_UmuKbn.ARI);
        editSeikyuusyoParam.setRstuukasyu(C_Tuukasyu.JPY);
        editSeikyuusyoParam.setNkshrtkykhnkkbn(C_NstkhKbn.NAIYOUHENKOU);
        editSeikyuusyoParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);
        editSeikyuusyoParam.setJyudkaigomaebaraiTkykhnkKbn(C_JyudkaigomaebaraiTkykhnkKbn.BLNK);
        editSeikyuusyoParam.setKihonshenkouumu(C_UmuKbn.NONE);
        editSeikyuusyoParam.setTmttknitenkbn(C_Tmttknitenkbn.BLNK);
        editSeikyuusyoParam.setTmttknitenymd(null);
        editSeikyuusyoParam.setKhhrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSeikyuusyoParam.setKhskssakuseijiyuu(C_Khskssakuseijiyuu.BLNK);
        editSeikyuusyoParam.setHenkougokjnkngk(BizCurrency.valueOf(100000));
        editSeikyuusyoParam.setYuuyokkntyoukaumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setMousideninkbn(C_MousideninKbn.UKTHONNIN);

        ReportServicesBean reSsBean =  editSeikyuusyoTbl.editBean(C_SyoruiCdKbn.KK_SHRKZHNK_SKS, syono18, khozenCommonParam, editSeikyuusyoParam);

        Object[] kSBean = reSsBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_SHRKZHNK_SKS.getValue());

        exNumericEquals(kSBean.length, 2, "パラメータオブジェクトの要素数");

        exNumericEquals(reSsBean.getKensakuKeys().length, 1, "検索キー配列の要素数");
        exStringEquals(reSsBean.getKensakuKeys()[0], "12806345845", "検索キー");

        KhSeikyuusyoBean khSeikyuusyoBean = (KhSeikyuusyoBean)kSBean[0];

        exStringEquals(khSeikyuusyoBean.getIrSyono(), "12806345845", "（ＩＲ）証券番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinyno(), "4354001", "（ＩＲ）通信先郵便番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr1kj(), "住所１", "（ＩＲ）通信先住所１（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr2kj(), "住所２", "（ＩＲ）通信先住所２（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr3kj(), "住所３", "（ＩＲ）通信先住所３（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsintelno(), "023-5677-7999", "（ＩＲ）通信先電話番号");
        exStringEquals(khSeikyuusyoBean.getIrBanknmkj(), "みずほ銀行", "（ＩＲ）銀行名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrSitennmkj(), "東京営業部", "（ＩＲ）支店名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrBankcd(), "0001", "（ＩＲ）銀行コード");
        exStringEquals(khSeikyuusyoBean.getIrSitencd(), "001", "（ＩＲ）支店コード");

        exStringEquals(khSeikyuusyoBean.getIrKzmeiginmkn(), "口座名義人氏名（カナ）", "（ＩＲ）口座名義人氏名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkj(), "ユ受名　一あ", "（ＩＲ）契約者名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKkkyktdk(), C_Tdk.HGU, "（ＩＲ）契約管理契約者続柄");
        exStringEquals(khSeikyuusyoBean.getIrHhknnmkj(), "被保険者名", "（ＩＲ）被保険者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrHhknseiymd(), "", "（ＩＲ）被保険者生年月日");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseiymdhenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者生年月日変更有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknsei(), C_Hhknsei.MALE, "（ＩＲ）被保険者性別");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseihenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者性別変更有無");
        exStringEquals(khSeikyuusyoBean.getIrStdrsknmkj(), "ユ受名　一あ", "（ＩＲ）指定代理請求人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrFatcakakuninyhkbn(), C_YouhiblnkKbn.HUYOU, "（ＩＲ）FATCA確認要否区分");
        exClassificationEquals(khSeikyuusyoBean.getIrAeoikakuninyhkbn(), C_YouhiblnkKbn.HUYOU, "（ＩＲ）ＡＥＯＩ確認要否区分");

        exClassificationEquals(khSeikyuusyoBean.getIrTargettkkbn(), C_TargetTkKbn.BLNK, "（ＩＲ）ターゲット特約区分");
        exNumericEquals(khSeikyuusyoBean.getIrAftertargettkmokuhyouti(), 101, "（ＩＲ）変更後ターゲット特約目標値");
        exNumericEquals(khSeikyuusyoBean.getIrBeforetargettkmokuhyouti(), 200, "（ＩＲ）変更前ターゲット特約目標値");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforekihons(), BizCurrency.valueOf(100), "（ＩＲ）基本保険金額（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkihons(),  BizCurrency.valueOf(778), "（ＩＲ）基本保険金額（変更後）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforep(), BizCurrency.valueOf(200), "（ＩＲ）保険料（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterp(), BizCurrency.valueOf(1566), "（ＩＲ）保険料（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrKyktuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）契約通貨種類");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj1(), "小野", "（ＩＲ）死亡受取人名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj2(), "", "（ＩＲ）死亡受取人名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj3(), "", "（ＩＲ）死亡受取人名（漢字）３");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj4(), "", "（ＩＲ）死亡受取人名（漢字）４");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkn(), "受取人名（カナ）", "（ＩＲ）死亡受取人名（カナ）");
        exClassificationEquals(khSeikyuusyoBean.getIrYokinkbn(), C_YokinKbn.HUTUU, "（ＩＲ）預金種目区分");
        exStringEquals(khSeikyuusyoBean.getIrKouzano(), "10101***", "（ＩＲ）口座番号");

        exClassificationEquals(khSeikyuusyoBean.getIrAfternkshrtkyknksyukbn(), C_Nstknsyu.KAKUTEINENKIN, "（ＩＲ）変更後年金支払特約年金種類区分");
        exClassificationEquals(khSeikyuusyoBean.getIrBiforenkshrtkyknksyukbn(), C_Nstknsyu.BLNK, "（ＩＲ）変更前年金支払特約年金種類区分");
        exNumericEquals(khSeikyuusyoBean.getIrAfternkshrtkyknkkkn(), 5, "（ＩＲ）変更後年金支払特約年金期間");
        exNumericEquals(khSeikyuusyoBean.getIrBeforenkshrtkyknkkkn(), 10, "（ＩＲ）変更前年金支払特約年金期間");
        exStringEquals(khSeikyuusyoBean.getIrNkuktnm(), "森君", "（ＩＲ）年金受取人名");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari1(), BizNumber.valueOf(230), "（ＩＲ）死亡受取人分割割合１");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari2(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合２");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari3(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合３");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari4(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合４");
        exClassificationEquals(khSeikyuusyoBean.getIrTargettkhnkkbn(), C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU, "（ＩＲ）ターゲット特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKaiyakujiyuu(), C_Kaiyakujiyuu.TUUJYOU, "（ＩＲ）解約事由");
        exClassificationEquals(khSeikyuusyoBean.getIrGengkhoukbn(), C_GengkhouKbn.SD, "（ＩＲ）減額方法区分");
        exNumericEquals(khSeikyuusyoBean.getIrSbuktnin(), 2, "（ＩＲ）死亡受取人人数");
        exClassificationEquals(khSeikyuusyoBean.getIrSbuuktkbn(), C_UktKbn.BLNK, "（ＩＲ）死亡受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrYenshrtkumu(), C_UmuKbn.ARI, "（ＩＲ）円支払特約有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHenkankinumukbn(), C_UmuKbn.ARI, "（ＩＲ）返還金有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrRstuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）領収通貨種類");
        exClassificationEquals(khSeikyuusyoBean.getIrNkshrtkykhnkkbn(), C_NstkhKbn.NAIYOUHENKOU, "（ＩＲ）年金支払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrMeigihnkjiyuu(), C_Meigihnkjiyuu.KYK, "（ＩＲ）名義変更事由");
        exClassificationEquals(khSeikyuusyoBean.getIrNkhknumu(), C_UmuKbn.ARI, "（ＩＲ）年金保険有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSiboukyhkuktumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡給付金受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn1(), C_UmuKbn.ARI, "（ＩＲ）死亡保険金受取人有無区分１");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn2(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分２");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn3(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分３");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn4(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分４");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu1(), C_UmuKbn.ARI, "（ＩＲ）死亡受取人分割割合有無１");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu2(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無２");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu3(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無３");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu4(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無４");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyhukaumu(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyuuktmukbn(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrStdruktkbn(), C_UktKbn.TOUROKUKAZOKU1, "（ＩＲ）指定代理受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrJyudkaigomaebrtkykhnkkbn(),C_JyudkaigomaebaraiTkykhnkKbn.BLNK, "（ＩＲ）重度介護前払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKeihikbn(),C_KeihiKbn.BLNK,"（ＩＲ）契被区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKihonshenkouumu(),C_UmuKbn.NONE,"（ＩＲ）基本Ｓ変更有無");
        exStringEquals(khSeikyuusyoBean.getIrKihonssyurui(), "基本保険金額", "（ＩＲ）基本Ｓ種類");
        exClassificationEquals(khSeikyuusyoBean.getIrTmttknitenkbn(), C_Tmttknitenkbn.BLNK, "（ＩＲ）積立金移転区分");
        exStringEquals(khSeikyuusyoBean.getIrTmttknitenymd(), null, "（ＩＲ）積立金移転日");
        exClassificationEquals(khSeikyuusyoBean.getIrKhhrshrjiyuu(), C_Khhrshrjiyuu.BLNK, "（ＩＲ）契約保全返戻金支払事由");
        exClassificationEquals(khSeikyuusyoBean.getIrKhskssakuseijiyuu(), C_Khskssakuseijiyuu.BLNK, "（ＩＲ）契約保全請求書作成事由");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkijyunkingaku(), BizCurrency.valueOf(100000), "（ＩＲ）基準金額（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrHrkkeiro(), C_Hrkkeiro.DANTAI, "（ＩＲ）払込経路");
        exNumericEquals(khSeikyuusyoBean.getIrSyouhnhanteikekka(), 999, "（ＩＲ）商品判定結果");
        exClassificationEquals(khSeikyuusyoBean.getIrKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "（ＩＲ）契約状態");
        exClassificationEquals(khSeikyuusyoBean.getIrZeiseitkkktkykhukaumu(), C_UmuKbn.ARI, "（ＩＲ）税制適格特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrYuuyokkntyoukaumu(), C_UmuKbn.ARI, "（ＩＲ）猶予期間超過有無");
        exClassificationEquals(khSeikyuusyoBean.getIrMousideikoukbn(), null, "（ＩＲ）申出移行区分");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn1(), "ユウケメイ　イチア", "（ＩＲ）登録家族氏名（カナ）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj1(), "ユ受名　一あ", "（ＩＲ）登録家族氏名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj1(), "住所１", "（ＩＲ）登録家族住所１（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj1(), "住所２", "（ＩＲ）登録家族住所２（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj1(), "住所３", "（ＩＲ）登録家族住所３（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno1(), "023-5677-8999", "（ＩＲ）登録家族電話番号１");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi1(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn2(), "", "（ＩＲ）登録家族氏名（カナ）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj2(), "", "（ＩＲ）登録家族氏名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj2(), "", "（ＩＲ）登録家族住所１（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj2(), "", "（ＩＲ）登録家族住所２（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj2(), "", "（ＩＲ）登録家族住所３（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno2(), "", "（ＩＲ）登録家族電話番号２");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi2(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否２");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkn(), "契約者名（カナ）", "（ＩＲ）契約者名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKykdairinmkj(), "ユ受名　一あ", "（ＩＲ）契約者代理人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrtkykhukaumu(), C_UmuKbn.NONE, "（ＩＲ）契約者代理特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrMousideninkbn(), C_MousideninKbn.UKTHONNIN, "（ＩＲ）申出人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrknhatudoujyoutai(), C_KykdrknHtdjytKbn.SETTEI, "（ＩＲ）契約者代理権発動状態");
        exStringEquals(khSeikyuusyoBean.getIrDrstiskkyknmkj(), "契約者名", "（ＩＲ）代理人指定先契約者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTyouhyoutitle(), null, "（ＩＲ）帳票タイトル");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg1(), null, "（ＩＲ）送付案内メッセージ１");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg2(), null, "（ＩＲ）送付案内メッセージ２");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg3(), null, "（ＩＲ）送付案内メッセージ３");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg4(), null, "（ＩＲ）送付案内メッセージ４");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg5(), null, "（ＩＲ）送付案内メッセージ５");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg6(), null, "（ＩＲ）送付案内メッセージ６");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg7(), null, "（ＩＲ）送付案内メッセージ７");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg8(), null, "（ＩＲ）送付案内メッセージ８");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg9(), null, "（ＩＲ）送付案内メッセージ９");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg10(), null, "（ＩＲ）送付案内メッセージ１０");

        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean)kSBean[1];

        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(), null, "（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(), "userId001", "（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(), "user001", "（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(), DateFormatUtil.dateKANJI(BizDate.getSysDate()), "（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(), "3 年", "（ＩＲ）保存期間");

        IT_KykKihon kykKihon = (IT_KykKihon)MockObjectManager.getArgument(GetKhKykdrInfoForHozen.class, "exec", 0, 0);
        exStringEquals(kykKihon.getSyono(), "12806345845", "証券番号");
        exStringEquals(kykKihon.getKbnkey(), "04", "区分キー");
    }

    @Test
    @TestOrder(310)
    public void testEditBean_A31() {

        MockObjectManager.initialize();

        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN2;

        AM_User aMUser = new AM_User();

        aMUser.setUserId("userId001");
        aMUser.setUserNm("user001");
        changeCurrentUser(baseUserInfo, aMUser);

        RayBCPBean bcpBean = SWAKInjector.getInstance(RayBCPBean.class);
        bcpBean.setBcp(false);
        bcpBean.setDaikouSosikiCd("6620000");
        RayCreator.create();

        editSeikyuusyoParam.setHhknseiymd(BizDate.valueOf(20151026));
        editSeikyuusyoParam.setHhknseiymdhenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setHhknsei(C_Hhknsei.MALE);
        editSeikyuusyoParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setBfrTargettkmokuhyouti(BizNumber.valueOf(101));
        editSeikyuusyoParam.setBfrKihonS(BizCurrency.valueOf(778));
        editSeikyuusyoParam.setBfrP(BizCurrency.valueOf(1566));
        editSeikyuusyoParam.setBfrTokuyakuNenkinsyuKbn(C_Nstknsyu.KAKUTEINENKIN);
        editSeikyuusyoParam.setBfrNkshrtkyknksyukkn(5);
        editSeikyuusyoParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU);
        editSeikyuusyoParam.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editSeikyuusyoParam.setGengkhouKbn(C_GengkhouKbn.SD);
        editSeikyuusyoParam.setHenkankumukbn(C_UmuKbn.ARI);
        editSeikyuusyoParam.setRstuukasyu(C_Tuukasyu.JPY);
        editSeikyuusyoParam.setNkshrtkykhnkkbn(C_NstkhKbn.NAIYOUHENKOU);
        editSeikyuusyoParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);
        editSeikyuusyoParam.setJyudkaigomaebaraiTkykhnkKbn(C_JyudkaigomaebaraiTkykhnkKbn.BLNK);
        editSeikyuusyoParam.setKihonshenkouumu(C_UmuKbn.NONE);
        editSeikyuusyoParam.setTmttknitenkbn(C_Tmttknitenkbn.BLNK);
        editSeikyuusyoParam.setTmttknitenymd(null);
        editSeikyuusyoParam.setKhhrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSeikyuusyoParam.setKhskssakuseijiyuu(C_Khskssakuseijiyuu.BLNK);
        editSeikyuusyoParam.setHenkougokjnkngk(BizCurrency.valueOf(100000));
        editSeikyuusyoParam.setYuuyokkntyoukaumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setMousideninkbn(C_MousideninKbn.UKTHONNIN);

        ReportServicesBean reSsBean =  editSeikyuusyoTbl.editBean(C_SyoruiCdKbn.KK_SHRKZHNK_SKS, syono19, khozenCommonParam, editSeikyuusyoParam);

        Object[] kSBean = reSsBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_SHRKZHNK_SKS.getValue());

        exNumericEquals(kSBean.length, 2, "パラメータオブジェクトの要素数");

        exNumericEquals(reSsBean.getKensakuKeys().length, 1, "検索キー配列の要素数");
        exStringEquals(reSsBean.getKensakuKeys()[0], "12806345856", "検索キー");

        KhSeikyuusyoBean khSeikyuusyoBean = (KhSeikyuusyoBean)kSBean[0];

        exStringEquals(khSeikyuusyoBean.getIrSyono(), "12806345856", "（ＩＲ）証券番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinyno(), "4354001", "（ＩＲ）通信先郵便番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr1kj(), "住所１", "（ＩＲ）通信先住所１（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr2kj(), "住所２", "（ＩＲ）通信先住所２（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr3kj(), "住所３", "（ＩＲ）通信先住所３（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsintelno(), "023-5677-7999", "（ＩＲ）通信先電話番号");
        exStringEquals(khSeikyuusyoBean.getIrBanknmkj(), "みずほ銀行", "（ＩＲ）銀行名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrSitennmkj(), "東京営業部", "（ＩＲ）支店名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrBankcd(), "0001", "（ＩＲ）銀行コード");
        exStringEquals(khSeikyuusyoBean.getIrSitencd(), "001", "（ＩＲ）支店コード");

        exStringEquals(khSeikyuusyoBean.getIrKzmeiginmkn(), "口座名義人氏名（カナ）", "（ＩＲ）口座名義人氏名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkj(), "ユ受名　一あ", "（ＩＲ）契約者名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKkkyktdk(), C_Tdk.HGU, "（ＩＲ）契約管理契約者続柄");
        exStringEquals(khSeikyuusyoBean.getIrHhknnmkj(), "被保険者名", "（ＩＲ）被保険者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrHhknseiymd(), "", "（ＩＲ）被保険者生年月日");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseiymdhenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者生年月日変更有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknsei(), C_Hhknsei.MALE, "（ＩＲ）被保険者性別");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseihenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者性別変更有無");
        exStringEquals(khSeikyuusyoBean.getIrStdrsknmkj(), "ユ受名　一え", "（ＩＲ）指定代理請求人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrFatcakakuninyhkbn(), C_YouhiblnkKbn.HUYOU, "（ＩＲ）FATCA確認要否区分");
        exClassificationEquals(khSeikyuusyoBean.getIrAeoikakuninyhkbn(), C_YouhiblnkKbn.HUYOU, "（ＩＲ）ＡＥＯＩ確認要否区分");

        exClassificationEquals(khSeikyuusyoBean.getIrTargettkkbn(), C_TargetTkKbn.BLNK, "（ＩＲ）ターゲット特約区分");
        exNumericEquals(khSeikyuusyoBean.getIrAftertargettkmokuhyouti(), 101, "（ＩＲ）変更後ターゲット特約目標値");
        exNumericEquals(khSeikyuusyoBean.getIrBeforetargettkmokuhyouti(), 200, "（ＩＲ）変更前ターゲット特約目標値");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforekihons(), BizCurrency.valueOf(100), "（ＩＲ）基本保険金額（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkihons(),  BizCurrency.valueOf(778), "（ＩＲ）基本保険金額（変更後）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforep(), BizCurrency.valueOf(200), "（ＩＲ）保険料（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterp(), BizCurrency.valueOf(1566), "（ＩＲ）保険料（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrKyktuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）契約通貨種類");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj1(), "小野", "（ＩＲ）死亡受取人名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj2(), "", "（ＩＲ）死亡受取人名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj3(), "", "（ＩＲ）死亡受取人名（漢字）３");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj4(), "", "（ＩＲ）死亡受取人名（漢字）４");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkn(), "受取人名（カナ）", "（ＩＲ）死亡受取人名（カナ）");
        exClassificationEquals(khSeikyuusyoBean.getIrYokinkbn(), C_YokinKbn.HUTUU, "（ＩＲ）預金種目区分");
        exStringEquals(khSeikyuusyoBean.getIrKouzano(), "10101***", "（ＩＲ）口座番号");

        exClassificationEquals(khSeikyuusyoBean.getIrAfternkshrtkyknksyukbn(), C_Nstknsyu.KAKUTEINENKIN, "（ＩＲ）変更後年金支払特約年金種類区分");
        exClassificationEquals(khSeikyuusyoBean.getIrBiforenkshrtkyknksyukbn(), C_Nstknsyu.BLNK, "（ＩＲ）変更前年金支払特約年金種類区分");
        exNumericEquals(khSeikyuusyoBean.getIrAfternkshrtkyknkkkn(), 5, "（ＩＲ）変更後年金支払特約年金期間");
        exNumericEquals(khSeikyuusyoBean.getIrBeforenkshrtkyknkkkn(), 10, "（ＩＲ）変更前年金支払特約年金期間");
        exStringEquals(khSeikyuusyoBean.getIrNkuktnm(), "森君", "（ＩＲ）年金受取人名");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari1(), BizNumber.valueOf(230), "（ＩＲ）死亡受取人分割割合１");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari2(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合２");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari3(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合３");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari4(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合４");
        exClassificationEquals(khSeikyuusyoBean.getIrTargettkhnkkbn(), C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU, "（ＩＲ）ターゲット特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKaiyakujiyuu(), C_Kaiyakujiyuu.TUUJYOU, "（ＩＲ）解約事由");
        exClassificationEquals(khSeikyuusyoBean.getIrGengkhoukbn(), C_GengkhouKbn.SD, "（ＩＲ）減額方法区分");
        exNumericEquals(khSeikyuusyoBean.getIrSbuktnin(), 2, "（ＩＲ）死亡受取人人数");
        exClassificationEquals(khSeikyuusyoBean.getIrSbuuktkbn(), C_UktKbn.BLNK, "（ＩＲ）死亡受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrYenshrtkumu(), C_UmuKbn.ARI, "（ＩＲ）円支払特約有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHenkankinumukbn(), C_UmuKbn.ARI, "（ＩＲ）返還金有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrRstuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）領収通貨種類");
        exClassificationEquals(khSeikyuusyoBean.getIrNkshrtkykhnkkbn(), C_NstkhKbn.NAIYOUHENKOU, "（ＩＲ）年金支払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrMeigihnkjiyuu(), C_Meigihnkjiyuu.KYK, "（ＩＲ）名義変更事由");
        exClassificationEquals(khSeikyuusyoBean.getIrNkhknumu(), C_UmuKbn.ARI, "（ＩＲ）年金保険有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSiboukyhkuktumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡給付金受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn1(), C_UmuKbn.ARI, "（ＩＲ）死亡保険金受取人有無区分１");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn2(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分２");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn3(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分３");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn4(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分４");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu1(), C_UmuKbn.ARI, "（ＩＲ）死亡受取人分割割合有無１");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu2(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無２");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu3(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無３");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu4(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無４");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyhukaumu(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyuuktmukbn(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrStdruktkbn(), C_UktKbn.TOUROKUKAZOKU2, "（ＩＲ）指定代理受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrJyudkaigomaebrtkykhnkkbn(),C_JyudkaigomaebaraiTkykhnkKbn.BLNK, "（ＩＲ）重度介護前払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKeihikbn(),C_KeihiKbn.BLNK,"（ＩＲ）契被区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKihonshenkouumu(),C_UmuKbn.NONE,"（ＩＲ）基本Ｓ変更有無");
        exStringEquals(khSeikyuusyoBean.getIrKihonssyurui(), "基本保険金額", "（ＩＲ）基本Ｓ種類");
        exClassificationEquals(khSeikyuusyoBean.getIrTmttknitenkbn(), C_Tmttknitenkbn.BLNK, "（ＩＲ）積立金移転区分");
        exStringEquals(khSeikyuusyoBean.getIrTmttknitenymd(), null, "（ＩＲ）積立金移転日");
        exClassificationEquals(khSeikyuusyoBean.getIrKhhrshrjiyuu(), C_Khhrshrjiyuu.BLNK, "（ＩＲ）契約保全返戻金支払事由");
        exClassificationEquals(khSeikyuusyoBean.getIrKhskssakuseijiyuu(), C_Khskssakuseijiyuu.BLNK, "（ＩＲ）契約保全請求書作成事由");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkijyunkingaku(), BizCurrency.valueOf(100000), "（ＩＲ）基準金額（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrHrkkeiro(), C_Hrkkeiro.DANTAI, "（ＩＲ）払込経路");
        exNumericEquals(khSeikyuusyoBean.getIrSyouhnhanteikekka(), 999, "（ＩＲ）商品判定結果");
        exClassificationEquals(khSeikyuusyoBean.getIrKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "（ＩＲ）契約状態");
        exClassificationEquals(khSeikyuusyoBean.getIrZeiseitkkktkykhukaumu(), C_UmuKbn.ARI, "（ＩＲ）税制適格特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrYuuyokkntyoukaumu(), C_UmuKbn.ARI, "（ＩＲ）猶予期間超過有無");
        exClassificationEquals(khSeikyuusyoBean.getIrMousideikoukbn(), null, "（ＩＲ）申出移行区分");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn1(), "ユウケメイ　イチウ", "（ＩＲ）登録家族氏名（カナ）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj1(), "ユ受名　一う", "（ＩＲ）登録家族氏名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj1(), "住所１", "（ＩＲ）登録家族住所１（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj1(), "住所２", "（ＩＲ）登録家族住所２（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj1(), "住所３", "（ＩＲ）登録家族住所３（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno1(), "023-5677-8999", "（ＩＲ）登録家族電話番号１");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi1(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn2(), "ユウケメイ　イチエ", "（ＩＲ）登録家族氏名（カナ）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj2(), "ユ受名　一え", "（ＩＲ）登録家族氏名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj2(), "住所１", "（ＩＲ）登録家族住所１（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj2(), "住所２", "（ＩＲ）登録家族住所２（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj2(), "住所３", "（ＩＲ）登録家族住所３（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno2(), "023-5677-8999", "（ＩＲ）登録家族電話番号２");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi2(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否２");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkn(), "契約者名（カナ）", "（ＩＲ）契約者名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKykdairinmkj(), "ユ受名　一あ", "（ＩＲ）契約者代理人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrtkykhukaumu(), C_UmuKbn.ARI, "（ＩＲ）契約者代理特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrMousideninkbn(), C_MousideninKbn.UKTHONNIN, "（ＩＲ）申出人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrknhatudoujyoutai(), C_KykdrknHtdjytKbn.SETTEI, "（ＩＲ）契約者代理権発動状態");
        exStringEquals(khSeikyuusyoBean.getIrDrstiskkyknmkj(), "契約者名", "（ＩＲ）代理人指定先契約者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTyouhyoutitle(), null, "（ＩＲ）帳票タイトル");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg1(), null, "（ＩＲ）送付案内メッセージ１");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg2(), null, "（ＩＲ）送付案内メッセージ２");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg3(), null, "（ＩＲ）送付案内メッセージ３");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg4(), null, "（ＩＲ）送付案内メッセージ４");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg5(), null, "（ＩＲ）送付案内メッセージ５");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg6(), null, "（ＩＲ）送付案内メッセージ６");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg7(), null, "（ＩＲ）送付案内メッセージ７");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg8(), null, "（ＩＲ）送付案内メッセージ８");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg9(), null, "（ＩＲ）送付案内メッセージ９");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg10(), null, "（ＩＲ）送付案内メッセージ１０");

        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean)kSBean[1];

        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(), null, "（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(), "userId001", "（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(), "user001", "（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(), DateFormatUtil.dateKANJI(BizDate.getSysDate()), "（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(), "3 年", "（ＩＲ）保存期間");

    }

    @Test
    @TestOrder(320)
    public void testEditBean_A32() {

        MockObjectManager.initialize();

        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN2;

        AM_User aMUser = new AM_User();

        aMUser.setUserId("userId001");
        aMUser.setUserNm("user001");
        changeCurrentUser(baseUserInfo, aMUser);

        RayBCPBean bcpBean = SWAKInjector.getInstance(RayBCPBean.class);
        bcpBean.setBcp(false);
        bcpBean.setDaikouSosikiCd("6620000");
        RayCreator.create();

        editSeikyuusyoParam.setHhknseiymd(BizDate.valueOf(20151026));
        editSeikyuusyoParam.setHhknseiymdhenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setHhknsei(C_Hhknsei.MALE);
        editSeikyuusyoParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setBfrTargettkmokuhyouti(BizNumber.valueOf(101));
        editSeikyuusyoParam.setBfrKihonS(BizCurrency.valueOf(778));
        editSeikyuusyoParam.setBfrP(BizCurrency.valueOf(1566));
        editSeikyuusyoParam.setBfrTokuyakuNenkinsyuKbn(C_Nstknsyu.KAKUTEINENKIN);
        editSeikyuusyoParam.setBfrNkshrtkyknksyukkn(5);
        editSeikyuusyoParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU);
        editSeikyuusyoParam.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editSeikyuusyoParam.setGengkhouKbn(C_GengkhouKbn.SD);
        editSeikyuusyoParam.setHenkankumukbn(C_UmuKbn.ARI);
        editSeikyuusyoParam.setRstuukasyu(C_Tuukasyu.JPY);
        editSeikyuusyoParam.setNkshrtkykhnkkbn(C_NstkhKbn.NAIYOUHENKOU);
        editSeikyuusyoParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);
        editSeikyuusyoParam.setJyudkaigomaebaraiTkykhnkKbn(C_JyudkaigomaebaraiTkykhnkKbn.BLNK);
        editSeikyuusyoParam.setKihonshenkouumu(C_UmuKbn.NONE);
        editSeikyuusyoParam.setTmttknitenkbn(C_Tmttknitenkbn.BLNK);
        editSeikyuusyoParam.setTmttknitenymd(null);
        editSeikyuusyoParam.setKhhrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSeikyuusyoParam.setKhskssakuseijiyuu(C_Khskssakuseijiyuu.BLNK);
        editSeikyuusyoParam.setHenkougokjnkngk(BizCurrency.valueOf(100000));
        editSeikyuusyoParam.setYuuyokkntyoukaumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setMousideninkbn(C_MousideninKbn.HHKNHONNIN);
        editSeikyuusyoParam.setTrkkzksakujyokahi1(C_KahiKbn.HUKA);
        editSeikyuusyoParam.setTrkkzksakujyokahi2(C_KahiKbn.KA);

        ReportServicesBean reSsBean =  editSeikyuusyoTbl.editBean(C_SyoruiCdKbn.KK_KZKTRKKYKDRTKYKHNK_SKS, syono20, khozenCommonParam, editSeikyuusyoParam);

        Object[] kSBean = reSsBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_KZKTRKKYKDRTKYKHNK_SKS.getValue());

        exNumericEquals(kSBean.length, 2, "パラメータオブジェクトの要素数");

        exNumericEquals(reSsBean.getKensakuKeys().length, 1, "検索キー配列の要素数");
        exStringEquals(reSsBean.getKensakuKeys()[0], "12806345867", "検索キー");

        KhSeikyuusyoBean khSeikyuusyoBean = (KhSeikyuusyoBean)kSBean[0];

        exStringEquals(khSeikyuusyoBean.getIrSyono(), "12806345867", "（ＩＲ）証券番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinyno(), "4354001", "（ＩＲ）通信先郵便番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr1kj(), "住所１", "（ＩＲ）通信先住所１（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr2kj(), "住所２", "（ＩＲ）通信先住所２（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr3kj(), "住所３", "（ＩＲ）通信先住所３（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsintelno(), "023-5677-7999", "（ＩＲ）通信先電話番号");
        exStringEquals(khSeikyuusyoBean.getIrBanknmkj(), "", "（ＩＲ）銀行名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrSitennmkj(), "", "（ＩＲ）支店名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrBankcd(), "", "（ＩＲ）銀行コード");
        exStringEquals(khSeikyuusyoBean.getIrSitencd(), "", "（ＩＲ）支店コード");

        exStringEquals(khSeikyuusyoBean.getIrKzmeiginmkn(), "", "（ＩＲ）口座名義人氏名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkj(), "ユ受名　一あ", "（ＩＲ）契約者名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKkkyktdk(), C_Tdk.HGU, "（ＩＲ）契約管理契約者続柄");
        exStringEquals(khSeikyuusyoBean.getIrHhknnmkj(), "被保険者名", "（ＩＲ）被保険者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrHhknseiymd(), "", "（ＩＲ）被保険者生年月日");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseiymdhenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者生年月日変更有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknsei(), C_Hhknsei.MALE, "（ＩＲ）被保険者性別");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseihenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者性別変更有無");
        exStringEquals(khSeikyuusyoBean.getIrStdrsknmkj(), "", "（ＩＲ）指定代理請求人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrFatcakakuninyhkbn(), C_YouhiblnkKbn.HUYOU, "（ＩＲ）FATCA確認要否区分");
        exClassificationEquals(khSeikyuusyoBean.getIrAeoikakuninyhkbn(), C_YouhiblnkKbn.HUYOU, "（ＩＲ）ＡＥＯＩ確認要否区分");

        exClassificationEquals(khSeikyuusyoBean.getIrTargettkkbn(), C_TargetTkKbn.BLNK, "（ＩＲ）ターゲット特約区分");
        exNumericEquals(khSeikyuusyoBean.getIrAftertargettkmokuhyouti(), 101, "（ＩＲ）変更後ターゲット特約目標値");
        exNumericEquals(khSeikyuusyoBean.getIrBeforetargettkmokuhyouti(), 200, "（ＩＲ）変更前ターゲット特約目標値");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforekihons(), BizCurrency.valueOf(100), "（ＩＲ）基本保険金額（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkihons(),  BizCurrency.valueOf(778), "（ＩＲ）基本保険金額（変更後）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforep(), BizCurrency.valueOf(200), "（ＩＲ）保険料（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterp(), BizCurrency.valueOf(1566), "（ＩＲ）保険料（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrKyktuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）契約通貨種類");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj1(), "", "（ＩＲ）死亡受取人名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj2(), "", "（ＩＲ）死亡受取人名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj3(), "", "（ＩＲ）死亡受取人名（漢字）３");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj4(), "", "（ＩＲ）死亡受取人名（漢字）４");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkn(), "", "（ＩＲ）死亡受取人名（カナ）");
        exClassificationEquals(khSeikyuusyoBean.getIrYokinkbn(), C_YokinKbn.BLNK, "（ＩＲ）預金種目区分");
        exStringEquals(khSeikyuusyoBean.getIrKouzano(), "", "（ＩＲ）口座番号");

        exClassificationEquals(khSeikyuusyoBean.getIrAfternkshrtkyknksyukbn(), C_Nstknsyu.KAKUTEINENKIN, "（ＩＲ）変更後年金支払特約年金種類区分");
        exClassificationEquals(khSeikyuusyoBean.getIrBiforenkshrtkyknksyukbn(), C_Nstknsyu.BLNK, "（ＩＲ）変更前年金支払特約年金種類区分");
        exNumericEquals(khSeikyuusyoBean.getIrAfternkshrtkyknkkkn(), 5, "（ＩＲ）変更後年金支払特約年金期間");
        exNumericEquals(khSeikyuusyoBean.getIrBeforenkshrtkyknkkkn(), 10, "（ＩＲ）変更前年金支払特約年金期間");
        exStringEquals(khSeikyuusyoBean.getIrNkuktnm(), "", "（ＩＲ）年金受取人名");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari1(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合１");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari2(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合２");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari3(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合３");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari4(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合４");
        exClassificationEquals(khSeikyuusyoBean.getIrTargettkhnkkbn(), C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU, "（ＩＲ）ターゲット特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKaiyakujiyuu(), C_Kaiyakujiyuu.TUUJYOU, "（ＩＲ）解約事由");
        exClassificationEquals(khSeikyuusyoBean.getIrGengkhoukbn(), C_GengkhouKbn.SD, "（ＩＲ）減額方法区分");
        exNumericEquals(khSeikyuusyoBean.getIrSbuktnin(), 2, "（ＩＲ）死亡受取人人数");
        exClassificationEquals(khSeikyuusyoBean.getIrSbuuktkbn(), C_UktKbn.BLNK, "（ＩＲ）死亡受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrYenshrtkumu(), C_UmuKbn.ARI, "（ＩＲ）円支払特約有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHenkankinumukbn(), C_UmuKbn.ARI, "（ＩＲ）返還金有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrRstuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）領収通貨種類");
        exClassificationEquals(khSeikyuusyoBean.getIrNkshrtkykhnkkbn(), C_NstkhKbn.NAIYOUHENKOU, "（ＩＲ）年金支払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrMeigihnkjiyuu(), C_Meigihnkjiyuu.KYK, "（ＩＲ）名義変更事由");
        exClassificationEquals(khSeikyuusyoBean.getIrNkhknumu(), C_UmuKbn.ARI, "（ＩＲ）年金保険有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSiboukyhkuktumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡給付金受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn1(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分１");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn2(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分２");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn3(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分３");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn4(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分４");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu1(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無１");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu2(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無２");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu3(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無３");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu4(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無４");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyhukaumu(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyuuktmukbn(), C_UmuKbn.NONE, "（ＩＲ）指定代理請求特約受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrStdruktkbn(), C_UktKbn.BLNK, "（ＩＲ）指定代理受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrJyudkaigomaebrtkykhnkkbn(),C_JyudkaigomaebaraiTkykhnkKbn.BLNK, "（ＩＲ）重度介護前払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKeihikbn(),C_KeihiKbn.BLNK,"（ＩＲ）契被区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKihonshenkouumu(),C_UmuKbn.NONE,"（ＩＲ）基本Ｓ変更有無");
        exStringEquals(khSeikyuusyoBean.getIrKihonssyurui(), "基本保険金額", "（ＩＲ）基本Ｓ種類");
        exClassificationEquals(khSeikyuusyoBean.getIrTmttknitenkbn(), C_Tmttknitenkbn.BLNK, "（ＩＲ）積立金移転区分");
        exStringEquals(khSeikyuusyoBean.getIrTmttknitenymd(), null, "（ＩＲ）積立金移転日");
        exClassificationEquals(khSeikyuusyoBean.getIrKhhrshrjiyuu(), C_Khhrshrjiyuu.BLNK, "（ＩＲ）契約保全返戻金支払事由");
        exClassificationEquals(khSeikyuusyoBean.getIrKhskssakuseijiyuu(), C_Khskssakuseijiyuu.BLNK, "（ＩＲ）契約保全請求書作成事由");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkijyunkingaku(), BizCurrency.valueOf(100000), "（ＩＲ）基準金額（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrHrkkeiro(), C_Hrkkeiro.DANTAI, "（ＩＲ）払込経路");
        exNumericEquals(khSeikyuusyoBean.getIrSyouhnhanteikekka(), 999, "（ＩＲ）商品判定結果");
        exClassificationEquals(khSeikyuusyoBean.getIrKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "（ＩＲ）契約状態");
        exClassificationEquals(khSeikyuusyoBean.getIrZeiseitkkktkykhukaumu(), C_UmuKbn.ARI, "（ＩＲ）税制適格特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrYuuyokkntyoukaumu(), C_UmuKbn.ARI, "（ＩＲ）猶予期間超過有無");
        exClassificationEquals(khSeikyuusyoBean.getIrMousideikoukbn(), null, "（ＩＲ）申出移行区分");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn1(), "ユウケメイ　イチア", "（ＩＲ）登録家族氏名（カナ）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj1(), "ユ受名　一あ　様", "（ＩＲ）登録家族氏名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj1(), "住所１", "（ＩＲ）登録家族住所１（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj1(), "住所２", "（ＩＲ）登録家族住所２（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj1(), "住所３", "（ＩＲ）登録家族住所３（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno1(), "023-5677-8888", "（ＩＲ）登録家族電話番号１");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi1(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn2(), "ユウケメイ　イチア", "（ＩＲ）登録家族氏名（カナ）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj2(), "ユ受名　一い　様", "（ＩＲ）登録家族氏名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj2(), "住所１", "（ＩＲ）登録家族住所１（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj2(), "住所２", "（ＩＲ）登録家族住所２（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj2(), "住所３", "（ＩＲ）登録家族住所３（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno2(), "023-5677-9999", "（ＩＲ）登録家族電話番号２");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi2(), C_KahiKbn.KA, "（ＩＲ）登録家族削除可否２");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkn(), "契約者名（カナ）", "（ＩＲ）契約者名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKykdairinmkj(), "ユ受名　一あ", "（ＩＲ）契約者代理人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrtkykhukaumu(), C_UmuKbn.NONE, "（ＩＲ）契約者代理特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrMousideninkbn(), C_MousideninKbn.HHKNHONNIN, "（ＩＲ）申出人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrknhatudoujyoutai(), C_KykdrknHtdjytKbn.SETTEI, "（ＩＲ）契約者代理権発動状態");
        exStringEquals(khSeikyuusyoBean.getIrDrstiskkyknmkj(), "契約者名", "（ＩＲ）代理人指定先契約者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTyouhyoutitle(), "ご家族登録サービス変更請求書", "（ＩＲ）帳票タイトル");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg1(), "被保険者様がご記入ください", "（ＩＲ）送付案内メッセージ１");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg2(), "ご家族登録サービスに登録されている情報を削除します。", "（ＩＲ）送付案内メッセージ２");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg3(), "削除する家族情報を選択し、レ印をご記入ください。", "（ＩＲ）送付案内メッセージ３");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg4(), "送付案内メッセージ４", "（ＩＲ）送付案内メッセージ４");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg5(), "送付案内メッセージ５", "（ＩＲ）送付案内メッセージ５");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg6(), "送付案内メッセージ６", "（ＩＲ）送付案内メッセージ６");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg7(), "送付案内メッセージ７", "（ＩＲ）送付案内メッセージ７");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg8(), "送付案内メッセージ８", "（ＩＲ）送付案内メッセージ８");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg9(), "送付案内メッセージ９", "（ＩＲ）送付案内メッセージ９");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg10(), "送付案内メッセージ１０", "（ＩＲ）送付案内メッセージ１０");

        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean)kSBean[1];

        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(), null, "（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(), "userId001", "（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(), "user001", "（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(), DateFormatUtil.dateKANJI(BizDate.getSysDate()), "（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(), "　消滅後 2 年", "（ＩＲ）保存期間");

        IT_KykKihon kykKihon = (IT_KykKihon)MockObjectManager.getArgument(GetKhKykdrInfoForHozen.class, "exec", 0, 0);
        exStringEquals(kykKihon.getSyono(), "12806345867", "証券番号");
        exStringEquals(kykKihon.getKbnkey(), "06", "区分キー");
    }

    @Test
    @TestOrder(330)
    public void testEditBean_A33() {

        MockObjectManager.initialize();

        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN3;

        AM_User aMUser = new AM_User();

        aMUser.setUserId("userId001");
        aMUser.setUserNm("user001");
        changeCurrentUser(baseUserInfo, aMUser);

        RayBCPBean bcpBean = SWAKInjector.getInstance(RayBCPBean.class);
        bcpBean.setBcp(false);
        bcpBean.setDaikouSosikiCd("6620000");
        RayCreator.create();

        editSeikyuusyoParam.setHhknseiymd(BizDate.valueOf(20151026));
        editSeikyuusyoParam.setHhknseiymdhenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setHhknsei(C_Hhknsei.MALE);
        editSeikyuusyoParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setBfrTargettkmokuhyouti(BizNumber.valueOf(101));
        editSeikyuusyoParam.setBfrKihonS(BizCurrency.valueOf(778));
        editSeikyuusyoParam.setBfrP(BizCurrency.valueOf(1566));
        editSeikyuusyoParam.setBfrTokuyakuNenkinsyuKbn(C_Nstknsyu.KAKUTEINENKIN);
        editSeikyuusyoParam.setBfrNkshrtkyknksyukkn(5);
        editSeikyuusyoParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU);
        editSeikyuusyoParam.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editSeikyuusyoParam.setGengkhouKbn(C_GengkhouKbn.SD);
        editSeikyuusyoParam.setHenkankumukbn(C_UmuKbn.ARI);
        editSeikyuusyoParam.setRstuukasyu(C_Tuukasyu.JPY);
        editSeikyuusyoParam.setNkshrtkykhnkkbn(C_NstkhKbn.NAIYOUHENKOU);
        editSeikyuusyoParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);
        editSeikyuusyoParam.setJyudkaigomaebaraiTkykhnkKbn(C_JyudkaigomaebaraiTkykhnkKbn.BLNK);
        editSeikyuusyoParam.setKihonshenkouumu(C_UmuKbn.NONE);
        editSeikyuusyoParam.setTmttknitenkbn(C_Tmttknitenkbn.BLNK);
        editSeikyuusyoParam.setTmttknitenymd(null);
        editSeikyuusyoParam.setKhhrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSeikyuusyoParam.setKhskssakuseijiyuu(C_Khskssakuseijiyuu.BLNK);
        editSeikyuusyoParam.setHenkougokjnkngk(BizCurrency.valueOf(100000));
        editSeikyuusyoParam.setYuuyokkntyoukaumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setMousideninkbn(C_MousideninKbn.KYKHONNIN);
        editSeikyuusyoParam.setTrkkzksakujyokahi1(C_KahiKbn.KA);
        editSeikyuusyoParam.setTrkkzksakujyokahi2(C_KahiKbn.HUKA);

        ReportServicesBean reSsBean =  editSeikyuusyoTbl.editBean(C_SyoruiCdKbn.KK_KZKTRKKYKDRTKYKHNK_SKS, syono21, khozenCommonParam, editSeikyuusyoParam);

        Object[] kSBean = reSsBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_KZKTRKKYKDRTKYKHNK_SKS.getValue());

        exNumericEquals(kSBean.length, 2, "パラメータオブジェクトの要素数");

        exNumericEquals(reSsBean.getKensakuKeys().length, 1, "検索キー配列の要素数");
        exStringEquals(reSsBean.getKensakuKeys()[0], "12806345878", "検索キー");

        KhSeikyuusyoBean khSeikyuusyoBean = (KhSeikyuusyoBean)kSBean[0];

        exStringEquals(khSeikyuusyoBean.getIrSyono(), "12806345878", "（ＩＲ）証券番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinyno(), "1234567", "（ＩＲ）通信先郵便番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr1kj(), "通信先住所１", "（ＩＲ）通信先住所１（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr2kj(), "通信先住所２", "（ＩＲ）通信先住所２（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr3kj(), "通信先住所３", "（ＩＲ）通信先住所３（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsintelno(), "023-5677-8999", "（ＩＲ）通信先電話番号");
        exStringEquals(khSeikyuusyoBean.getIrBanknmkj(), "", "（ＩＲ）銀行名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrSitennmkj(), "", "（ＩＲ）支店名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrBankcd(), "", "（ＩＲ）銀行コード");
        exStringEquals(khSeikyuusyoBean.getIrSitencd(), "", "（ＩＲ）支店コード");

        exStringEquals(khSeikyuusyoBean.getIrKzmeiginmkn(), "", "（ＩＲ）口座名義人氏名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkj(), "契約者名", "（ＩＲ）契約者名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKkkyktdk(), C_Tdk.HGU, "（ＩＲ）契約管理契約者続柄");
        exStringEquals(khSeikyuusyoBean.getIrHhknnmkj(), "被保険者名", "（ＩＲ）被保険者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrHhknseiymd(), "", "（ＩＲ）被保険者生年月日");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseiymdhenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者生年月日変更有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknsei(), C_Hhknsei.MALE, "（ＩＲ）被保険者性別");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseihenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者性別変更有無");
        exStringEquals(khSeikyuusyoBean.getIrStdrsknmkj(), "", "（ＩＲ）指定代理請求人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrFatcakakuninyhkbn(), C_YouhiblnkKbn.HUYOU, "（ＩＲ）FATCA確認要否区分");
        exClassificationEquals(khSeikyuusyoBean.getIrAeoikakuninyhkbn(), C_YouhiblnkKbn.HUYOU, "（ＩＲ）ＡＥＯＩ確認要否区分");

        exClassificationEquals(khSeikyuusyoBean.getIrTargettkkbn(), C_TargetTkKbn.BLNK, "（ＩＲ）ターゲット特約区分");
        exNumericEquals(khSeikyuusyoBean.getIrAftertargettkmokuhyouti(), 101, "（ＩＲ）変更後ターゲット特約目標値");
        exNumericEquals(khSeikyuusyoBean.getIrBeforetargettkmokuhyouti(), 200, "（ＩＲ）変更前ターゲット特約目標値");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforekihons(), BizCurrency.valueOf(100), "（ＩＲ）基本保険金額（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkihons(),  BizCurrency.valueOf(778), "（ＩＲ）基本保険金額（変更後）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforep(), BizCurrency.valueOf(200), "（ＩＲ）保険料（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterp(), BizCurrency.valueOf(1566), "（ＩＲ）保険料（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrKyktuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）契約通貨種類");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj1(), "", "（ＩＲ）死亡受取人名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj2(), "", "（ＩＲ）死亡受取人名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj3(), "", "（ＩＲ）死亡受取人名（漢字）３");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj4(), "", "（ＩＲ）死亡受取人名（漢字）４");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkn(), "", "（ＩＲ）死亡受取人名（カナ）");
        exClassificationEquals(khSeikyuusyoBean.getIrYokinkbn(), C_YokinKbn.BLNK, "（ＩＲ）預金種目区分");
        exStringEquals(khSeikyuusyoBean.getIrKouzano(), "", "（ＩＲ）口座番号");

        exClassificationEquals(khSeikyuusyoBean.getIrAfternkshrtkyknksyukbn(), C_Nstknsyu.KAKUTEINENKIN, "（ＩＲ）変更後年金支払特約年金種類区分");
        exClassificationEquals(khSeikyuusyoBean.getIrBiforenkshrtkyknksyukbn(), C_Nstknsyu.BLNK, "（ＩＲ）変更前年金支払特約年金種類区分");
        exNumericEquals(khSeikyuusyoBean.getIrAfternkshrtkyknkkkn(), 5, "（ＩＲ）変更後年金支払特約年金期間");
        exNumericEquals(khSeikyuusyoBean.getIrBeforenkshrtkyknkkkn(), 10, "（ＩＲ）変更前年金支払特約年金期間");
        exStringEquals(khSeikyuusyoBean.getIrNkuktnm(), "", "（ＩＲ）年金受取人名");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari1(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合１");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari2(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合２");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari3(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合３");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari4(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合４");
        exClassificationEquals(khSeikyuusyoBean.getIrTargettkhnkkbn(), C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU, "（ＩＲ）ターゲット特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKaiyakujiyuu(), C_Kaiyakujiyuu.TUUJYOU, "（ＩＲ）解約事由");
        exClassificationEquals(khSeikyuusyoBean.getIrGengkhoukbn(), C_GengkhouKbn.SD, "（ＩＲ）減額方法区分");
        exNumericEquals(khSeikyuusyoBean.getIrSbuktnin(), 2, "（ＩＲ）死亡受取人人数");
        exClassificationEquals(khSeikyuusyoBean.getIrSbuuktkbn(), C_UktKbn.BLNK, "（ＩＲ）死亡受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrYenshrtkumu(), C_UmuKbn.ARI, "（ＩＲ）円支払特約有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHenkankinumukbn(), C_UmuKbn.ARI, "（ＩＲ）返還金有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrRstuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）領収通貨種類");
        exClassificationEquals(khSeikyuusyoBean.getIrNkshrtkykhnkkbn(), C_NstkhKbn.NAIYOUHENKOU, "（ＩＲ）年金支払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrMeigihnkjiyuu(), C_Meigihnkjiyuu.KYK, "（ＩＲ）名義変更事由");
        exClassificationEquals(khSeikyuusyoBean.getIrNkhknumu(), C_UmuKbn.ARI, "（ＩＲ）年金保険有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSiboukyhkuktumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡給付金受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn1(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分１");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn2(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分２");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn3(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分３");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn4(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分４");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu1(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無１");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu2(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無２");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu3(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無３");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu4(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無４");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyhukaumu(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyuuktmukbn(), C_UmuKbn.NONE, "（ＩＲ）指定代理請求特約受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrStdruktkbn(), C_UktKbn.BLNK, "（ＩＲ）指定代理受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrJyudkaigomaebrtkykhnkkbn(),C_JyudkaigomaebaraiTkykhnkKbn.BLNK, "（ＩＲ）重度介護前払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKeihikbn(),C_KeihiKbn.BLNK,"（ＩＲ）契被区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKihonshenkouumu(),C_UmuKbn.NONE,"（ＩＲ）基本Ｓ変更有無");
        exStringEquals(khSeikyuusyoBean.getIrKihonssyurui(), "基本保険金額", "（ＩＲ）基本Ｓ種類");
        exClassificationEquals(khSeikyuusyoBean.getIrTmttknitenkbn(), C_Tmttknitenkbn.BLNK, "（ＩＲ）積立金移転区分");
        exStringEquals(khSeikyuusyoBean.getIrTmttknitenymd(), null, "（ＩＲ）積立金移転日");
        exClassificationEquals(khSeikyuusyoBean.getIrKhhrshrjiyuu(), C_Khhrshrjiyuu.BLNK, "（ＩＲ）契約保全返戻金支払事由");
        exClassificationEquals(khSeikyuusyoBean.getIrKhskssakuseijiyuu(), C_Khskssakuseijiyuu.BLNK, "（ＩＲ）契約保全請求書作成事由");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkijyunkingaku(), BizCurrency.valueOf(100000), "（ＩＲ）基準金額（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrHrkkeiro(), C_Hrkkeiro.DANTAI, "（ＩＲ）払込経路");
        exNumericEquals(khSeikyuusyoBean.getIrSyouhnhanteikekka(), 999, "（ＩＲ）商品判定結果");
        exClassificationEquals(khSeikyuusyoBean.getIrKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "（ＩＲ）契約状態");
        exClassificationEquals(khSeikyuusyoBean.getIrZeiseitkkktkykhukaumu(), C_UmuKbn.ARI, "（ＩＲ）税制適格特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrYuuyokkntyoukaumu(), C_UmuKbn.ARI, "（ＩＲ）猶予期間超過有無");
        exClassificationEquals(khSeikyuusyoBean.getIrMousideikoukbn(), null, "（ＩＲ）申出移行区分");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn1(), "ユウケメイ　イチア", "（ＩＲ）登録家族氏名（カナ）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj1(), "未登録", "（ＩＲ）登録家族氏名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj1(), "未登録", "（ＩＲ）登録家族住所１（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj1(), "住所２", "（ＩＲ）登録家族住所２（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj1(), "住所３", "（ＩＲ）登録家族住所３（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno1(), "未登録", "（ＩＲ）登録家族電話番号１");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi1(), C_KahiKbn.KA, "（ＩＲ）登録家族削除可否１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn2(), "ユウケメイ　イチア", "（ＩＲ）登録家族氏名（カナ）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj2(), "未登録", "（ＩＲ）登録家族氏名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj2(), "未登録", "（ＩＲ）登録家族住所１（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj2(), "住所２", "（ＩＲ）登録家族住所２（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj2(), "住所３", "（ＩＲ）登録家族住所３（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno2(), "未登録", "（ＩＲ）登録家族電話番号２");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi2(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否２");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkn(), "契約者名（カナ）", "（ＩＲ）契約者名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKykdairinmkj(), "未登録", "（ＩＲ）契約者代理人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrtkykhukaumu(), C_UmuKbn.NONE, "（ＩＲ）契約者代理特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrMousideninkbn(), C_MousideninKbn.KYKHONNIN, "（ＩＲ）申出人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrknhatudoujyoutai(), C_KykdrknHtdjytKbn.BLNK, "（ＩＲ）契約者代理権発動状態");
        exStringEquals(khSeikyuusyoBean.getIrDrstiskkyknmkj(), "契約者名", "（ＩＲ）代理人指定先契約者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTyouhyoutitle(), "ご家族登録サービス　兼　保険契約者代理特約変更請求書", "（ＩＲ）帳票タイトル");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg1(), "契約者様がご記入ください", "（ＩＲ）送付案内メッセージ１");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg2(), "ご家族登録サービスおよび保険契約者代理特約について、次のとおり変更します。", "（ＩＲ）送付案内メッセージ２");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg3(), "（詳細は２／２ページのとおり）", "（ＩＲ）送付案内メッセージ３");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg4(), "□登録　□変更　□削除", "（ＩＲ）送付案内メッセージ４");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg5(), "□　１／２ページに記載の請求者現住所に同じ", "（ＩＲ）送付案内メッセージ５");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg6(), "送付案内メッセージ６", "（ＩＲ）送付案内メッセージ６");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg7(), "送付案内メッセージ７", "（ＩＲ）送付案内メッセージ７");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg8(), "送付案内メッセージ８", "（ＩＲ）送付案内メッセージ８");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg9(), "送付案内メッセージ９", "（ＩＲ）送付案内メッセージ９");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg10(), "送付案内メッセージ１０", "（ＩＲ）送付案内メッセージ１０");

        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean)kSBean[1];

        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(), null, "（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(), "userId001", "（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(), "user001", "（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(), DateFormatUtil.dateKANJI(BizDate.getSysDate()), "（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(), "　消滅後 2 年", "（ＩＲ）保存期間");

        IT_KykKihon kykKihon = (IT_KykKihon)MockObjectManager.getArgument(GetKhKykdrInfoForHozen.class, "exec", 0, 0);
        exStringEquals(kykKihon.getSyono(), "12806345878", "証券番号");
        exStringEquals(kykKihon.getKbnkey(), "07", "区分キー");
    }

    @Test
    @TestOrder(340)
    public void testEditBean_A34() {

        MockObjectManager.initialize();

        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN2;

        AM_User aMUser = new AM_User();

        aMUser.setUserId("userId001");
        aMUser.setUserNm("user001");
        changeCurrentUser(baseUserInfo, aMUser);

        RayBCPBean bcpBean = SWAKInjector.getInstance(RayBCPBean.class);
        bcpBean.setBcp(false);
        bcpBean.setDaikouSosikiCd("6620000");
        RayCreator.create();

        editSeikyuusyoParam.setHhknseiymd(BizDate.valueOf(20151026));
        editSeikyuusyoParam.setHhknseiymdhenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setHhknsei(C_Hhknsei.MALE);
        editSeikyuusyoParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setBfrTargettkmokuhyouti(BizNumber.valueOf(101));
        editSeikyuusyoParam.setBfrKihonS(BizCurrency.valueOf(778));
        editSeikyuusyoParam.setBfrP(BizCurrency.valueOf(1566));
        editSeikyuusyoParam.setBfrTokuyakuNenkinsyuKbn(C_Nstknsyu.KAKUTEINENKIN);
        editSeikyuusyoParam.setBfrNkshrtkyknksyukkn(5);
        editSeikyuusyoParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU);
        editSeikyuusyoParam.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editSeikyuusyoParam.setGengkhouKbn(C_GengkhouKbn.SD);
        editSeikyuusyoParam.setHenkankumukbn(C_UmuKbn.ARI);
        editSeikyuusyoParam.setRstuukasyu(C_Tuukasyu.JPY);
        editSeikyuusyoParam.setNkshrtkykhnkkbn(C_NstkhKbn.NAIYOUHENKOU);
        editSeikyuusyoParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);
        editSeikyuusyoParam.setJyudkaigomaebaraiTkykhnkKbn(C_JyudkaigomaebaraiTkykhnkKbn.BLNK);
        editSeikyuusyoParam.setKihonshenkouumu(C_UmuKbn.NONE);
        editSeikyuusyoParam.setTmttknitenkbn(C_Tmttknitenkbn.BLNK);
        editSeikyuusyoParam.setTmttknitenymd(null);
        editSeikyuusyoParam.setKhhrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSeikyuusyoParam.setKhskssakuseijiyuu(C_Khskssakuseijiyuu.BLNK);
        editSeikyuusyoParam.setHenkougokjnkngk(BizCurrency.valueOf(100000));
        editSeikyuusyoParam.setYuuyokkntyoukaumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setMousideninkbn(C_MousideninKbn.KYKHONNIN);
        editSeikyuusyoParam.setTrkkzksakujyokahi1(C_KahiKbn.KA);
        editSeikyuusyoParam.setTrkkzksakujyokahi2(C_KahiKbn.HUKA);

        ReportServicesBean reSsBean =  editSeikyuusyoTbl.editBean(C_SyoruiCdKbn.KK_KZKTRKKYKDRTKYKHNK_SKS, syono22, khozenCommonParam, editSeikyuusyoParam);

        Object[] kSBean = reSsBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_KZKTRKKYKDRTKYKHNK_SKS.getValue());

        exNumericEquals(kSBean.length, 2, "パラメータオブジェクトの要素数");

        exNumericEquals(reSsBean.getKensakuKeys().length, 1, "検索キー配列の要素数");
        exStringEquals(reSsBean.getKensakuKeys()[0], "12806345889", "検索キー");

        KhSeikyuusyoBean khSeikyuusyoBean = (KhSeikyuusyoBean)kSBean[0];

        exStringEquals(khSeikyuusyoBean.getIrSyono(), "12806345889", "（ＩＲ）証券番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinyno(), "4354001", "（ＩＲ）通信先郵便番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr1kj(), "住所１", "（ＩＲ）通信先住所１（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr2kj(), "住所２", "（ＩＲ）通信先住所２（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr3kj(), "住所３", "（ＩＲ）通信先住所３（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsintelno(), "023-5677-7999", "（ＩＲ）通信先電話番号");
        exStringEquals(khSeikyuusyoBean.getIrBanknmkj(), "", "（ＩＲ）銀行名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrSitennmkj(), "", "（ＩＲ）支店名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrBankcd(), "", "（ＩＲ）銀行コード");
        exStringEquals(khSeikyuusyoBean.getIrSitencd(), "", "（ＩＲ）支店コード");

        exStringEquals(khSeikyuusyoBean.getIrKzmeiginmkn(), "", "（ＩＲ）口座名義人氏名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkj(), "ユ受名　一あ", "（ＩＲ）契約者名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKkkyktdk(), C_Tdk.HGU, "（ＩＲ）契約管理契約者続柄");
        exStringEquals(khSeikyuusyoBean.getIrHhknnmkj(), "被保険者名", "（ＩＲ）被保険者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrHhknseiymd(), "", "（ＩＲ）被保険者生年月日");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseiymdhenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者生年月日変更有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknsei(), C_Hhknsei.MALE, "（ＩＲ）被保険者性別");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseihenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者性別変更有無");
        exStringEquals(khSeikyuusyoBean.getIrStdrsknmkj(), "", "（ＩＲ）指定代理請求人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrFatcakakuninyhkbn(), C_YouhiblnkKbn.HUYOU, "（ＩＲ）FATCA確認要否区分");
        exClassificationEquals(khSeikyuusyoBean.getIrAeoikakuninyhkbn(), C_YouhiblnkKbn.HUYOU, "（ＩＲ）ＡＥＯＩ確認要否区分");

        exClassificationEquals(khSeikyuusyoBean.getIrTargettkkbn(), C_TargetTkKbn.BLNK, "（ＩＲ）ターゲット特約区分");
        exNumericEquals(khSeikyuusyoBean.getIrAftertargettkmokuhyouti(), 101, "（ＩＲ）変更後ターゲット特約目標値");
        exNumericEquals(khSeikyuusyoBean.getIrBeforetargettkmokuhyouti(), 200, "（ＩＲ）変更前ターゲット特約目標値");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforekihons(), BizCurrency.valueOf(100), "（ＩＲ）基本保険金額（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkihons(),  BizCurrency.valueOf(778), "（ＩＲ）基本保険金額（変更後）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforep(), BizCurrency.valueOf(200), "（ＩＲ）保険料（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterp(), BizCurrency.valueOf(1566), "（ＩＲ）保険料（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrKyktuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）契約通貨種類");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj1(), "", "（ＩＲ）死亡受取人名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj2(), "", "（ＩＲ）死亡受取人名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj3(), "", "（ＩＲ）死亡受取人名（漢字）３");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj4(), "", "（ＩＲ）死亡受取人名（漢字）４");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkn(), "", "（ＩＲ）死亡受取人名（カナ）");
        exClassificationEquals(khSeikyuusyoBean.getIrYokinkbn(), C_YokinKbn.BLNK, "（ＩＲ）預金種目区分");
        exStringEquals(khSeikyuusyoBean.getIrKouzano(), "", "（ＩＲ）口座番号");

        exClassificationEquals(khSeikyuusyoBean.getIrAfternkshrtkyknksyukbn(), C_Nstknsyu.KAKUTEINENKIN, "（ＩＲ）変更後年金支払特約年金種類区分");
        exClassificationEquals(khSeikyuusyoBean.getIrBiforenkshrtkyknksyukbn(), C_Nstknsyu.BLNK, "（ＩＲ）変更前年金支払特約年金種類区分");
        exNumericEquals(khSeikyuusyoBean.getIrAfternkshrtkyknkkkn(), 5, "（ＩＲ）変更後年金支払特約年金期間");
        exNumericEquals(khSeikyuusyoBean.getIrBeforenkshrtkyknkkkn(), 10, "（ＩＲ）変更前年金支払特約年金期間");
        exStringEquals(khSeikyuusyoBean.getIrNkuktnm(), "", "（ＩＲ）年金受取人名");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari1(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合１");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari2(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合２");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari3(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合３");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari4(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合４");
        exClassificationEquals(khSeikyuusyoBean.getIrTargettkhnkkbn(), C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU, "（ＩＲ）ターゲット特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKaiyakujiyuu(), C_Kaiyakujiyuu.TUUJYOU, "（ＩＲ）解約事由");
        exClassificationEquals(khSeikyuusyoBean.getIrGengkhoukbn(), C_GengkhouKbn.SD, "（ＩＲ）減額方法区分");
        exNumericEquals(khSeikyuusyoBean.getIrSbuktnin(), 2, "（ＩＲ）死亡受取人人数");
        exClassificationEquals(khSeikyuusyoBean.getIrSbuuktkbn(), C_UktKbn.BLNK, "（ＩＲ）死亡受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrYenshrtkumu(), C_UmuKbn.ARI, "（ＩＲ）円支払特約有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHenkankinumukbn(), C_UmuKbn.ARI, "（ＩＲ）返還金有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrRstuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）領収通貨種類");
        exClassificationEquals(khSeikyuusyoBean.getIrNkshrtkykhnkkbn(), C_NstkhKbn.NAIYOUHENKOU, "（ＩＲ）年金支払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrMeigihnkjiyuu(), C_Meigihnkjiyuu.KYK, "（ＩＲ）名義変更事由");
        exClassificationEquals(khSeikyuusyoBean.getIrNkhknumu(), C_UmuKbn.ARI, "（ＩＲ）年金保険有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSiboukyhkuktumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡給付金受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn1(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分１");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn2(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分２");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn3(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分３");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn4(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分４");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu1(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無１");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu2(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無２");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu3(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無３");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu4(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無４");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyhukaumu(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyuuktmukbn(), C_UmuKbn.NONE, "（ＩＲ）指定代理請求特約受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrStdruktkbn(), C_UktKbn.BLNK, "（ＩＲ）指定代理受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrJyudkaigomaebrtkykhnkkbn(),C_JyudkaigomaebaraiTkykhnkKbn.BLNK, "（ＩＲ）重度介護前払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKeihikbn(),C_KeihiKbn.BLNK,"（ＩＲ）契被区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKihonshenkouumu(),C_UmuKbn.NONE,"（ＩＲ）基本Ｓ変更有無");
        exStringEquals(khSeikyuusyoBean.getIrKihonssyurui(), "基本保険金額", "（ＩＲ）基本Ｓ種類");
        exClassificationEquals(khSeikyuusyoBean.getIrTmttknitenkbn(), C_Tmttknitenkbn.BLNK, "（ＩＲ）積立金移転区分");
        exStringEquals(khSeikyuusyoBean.getIrTmttknitenymd(), null, "（ＩＲ）積立金移転日");
        exClassificationEquals(khSeikyuusyoBean.getIrKhhrshrjiyuu(), C_Khhrshrjiyuu.BLNK, "（ＩＲ）契約保全返戻金支払事由");
        exClassificationEquals(khSeikyuusyoBean.getIrKhskssakuseijiyuu(), C_Khskssakuseijiyuu.BLNK, "（ＩＲ）契約保全請求書作成事由");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkijyunkingaku(), BizCurrency.valueOf(100000), "（ＩＲ）基準金額（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrHrkkeiro(), C_Hrkkeiro.DANTAI, "（ＩＲ）払込経路");
        exNumericEquals(khSeikyuusyoBean.getIrSyouhnhanteikekka(), 999, "（ＩＲ）商品判定結果");
        exClassificationEquals(khSeikyuusyoBean.getIrKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "（ＩＲ）契約状態");
        exClassificationEquals(khSeikyuusyoBean.getIrZeiseitkkktkykhukaumu(), C_UmuKbn.ARI, "（ＩＲ）税制適格特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrYuuyokkntyoukaumu(), C_UmuKbn.ARI, "（ＩＲ）猶予期間超過有無");
        exClassificationEquals(khSeikyuusyoBean.getIrMousideikoukbn(), null, "（ＩＲ）申出移行区分");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn1(), "ユウケメイ　イチア", "（ＩＲ）登録家族氏名（カナ）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj1(), "右記欄にご記入ください→", "（ＩＲ）登録家族氏名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj1(), "住所１", "（ＩＲ）登録家族住所１（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj1(), "住所２", "（ＩＲ）登録家族住所２（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj1(), "住所３", "（ＩＲ）登録家族住所３（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno1(), "023-5677-8888", "（ＩＲ）登録家族電話番号１");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi1(), C_KahiKbn.KA, "（ＩＲ）登録家族削除可否１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn2(), "ユウケメイ　イチア", "（ＩＲ）登録家族氏名（カナ）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj2(), "右記欄にご記入ください→", "（ＩＲ）登録家族氏名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj2(), "住所１", "（ＩＲ）登録家族住所１（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj2(), "住所２", "（ＩＲ）登録家族住所２（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj2(), "住所３", "（ＩＲ）登録家族住所３（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno2(), "023-5677-9999", "（ＩＲ）登録家族電話番号２");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi2(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否２");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkn(), "契約者名（カナ）", "（ＩＲ）契約者名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKykdairinmkj(), "右記欄にご記入ください→", "（ＩＲ）契約者代理人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrtkykhukaumu(), C_UmuKbn.NONE, "（ＩＲ）契約者代理特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrMousideninkbn(), C_MousideninKbn.KYKHONNIN, "（ＩＲ）申出人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrknhatudoujyoutai(), C_KykdrknHtdjytKbn.SETTEI, "（ＩＲ）契約者代理権発動状態");
        exStringEquals(khSeikyuusyoBean.getIrDrstiskkyknmkj(), "契約者名", "（ＩＲ）代理人指定先契約者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTyouhyoutitle(), "ご家族登録サービス変更請求書", "（ＩＲ）帳票タイトル");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg1(), "契約者代理人様がご記入ください", "（ＩＲ）送付案内メッセージ１");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg2(), "ご家族登録サービスについて、次のとおり変更します。", "（ＩＲ）送付案内メッセージ２");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg3(), "（詳細は２／２ページのとおり）", "（ＩＲ）送付案内メッセージ３");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg4(), "□登録　□変更　□削除", "（ＩＲ）送付案内メッセージ４");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg5(), "送付案内メッセージ５", "（ＩＲ）送付案内メッセージ５");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg6(), "送付案内メッセージ６", "（ＩＲ）送付案内メッセージ６");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg7(), "送付案内メッセージ７", "（ＩＲ）送付案内メッセージ７");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg8(), "送付案内メッセージ８", "（ＩＲ）送付案内メッセージ８");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg9(), "送付案内メッセージ９", "（ＩＲ）送付案内メッセージ９");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg10(), "送付案内メッセージ１０", "（ＩＲ）送付案内メッセージ１０");

        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean)kSBean[1];

        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(), null, "（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(), "userId001", "（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(), "user001", "（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(), DateFormatUtil.dateKANJI(BizDate.getSysDate()), "（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(), "　消滅後 2 年", "（ＩＲ）保存期間");

        IT_KykKihon kykKihon = (IT_KykKihon)MockObjectManager.getArgument(GetKhKykdrInfoForHozen.class, "exec", 0, 0);
        exStringEquals(kykKihon.getSyono(), "12806345889", "証券番号");
        exStringEquals(kykKihon.getKbnkey(), "08", "区分キー");
    }

    @Test
    @TestOrder(350)
    public void testEditBean_A35() {

        MockObjectManager.initialize();

        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN4;

        AM_User aMUser = new AM_User();

        aMUser.setUserId("userId001");
        aMUser.setUserNm("user001");
        changeCurrentUser(baseUserInfo, aMUser);

        RayBCPBean bcpBean = SWAKInjector.getInstance(RayBCPBean.class);
        bcpBean.setBcp(false);
        bcpBean.setDaikouSosikiCd("6620000");
        RayCreator.create();

        editSeikyuusyoParam.setHhknseiymd(BizDate.valueOf(20151026));
        editSeikyuusyoParam.setHhknseiymdhenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setHhknsei(C_Hhknsei.MALE);
        editSeikyuusyoParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setBfrTargettkmokuhyouti(BizNumber.valueOf(101));
        editSeikyuusyoParam.setBfrKihonS(BizCurrency.valueOf(778));
        editSeikyuusyoParam.setBfrP(BizCurrency.valueOf(1566));
        editSeikyuusyoParam.setBfrTokuyakuNenkinsyuKbn(C_Nstknsyu.KAKUTEINENKIN);
        editSeikyuusyoParam.setBfrNkshrtkyknksyukkn(5);
        editSeikyuusyoParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU);
        editSeikyuusyoParam.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editSeikyuusyoParam.setGengkhouKbn(C_GengkhouKbn.SD);
        editSeikyuusyoParam.setHenkankumukbn(C_UmuKbn.ARI);
        editSeikyuusyoParam.setRstuukasyu(C_Tuukasyu.JPY);
        editSeikyuusyoParam.setNkshrtkykhnkkbn(C_NstkhKbn.NAIYOUHENKOU);
        editSeikyuusyoParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);
        editSeikyuusyoParam.setJyudkaigomaebaraiTkykhnkKbn(C_JyudkaigomaebaraiTkykhnkKbn.BLNK);
        editSeikyuusyoParam.setKihonshenkouumu(C_UmuKbn.NONE);
        editSeikyuusyoParam.setTmttknitenkbn(C_Tmttknitenkbn.BLNK);
        editSeikyuusyoParam.setTmttknitenymd(null);
        editSeikyuusyoParam.setKhhrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSeikyuusyoParam.setKhskssakuseijiyuu(C_Khskssakuseijiyuu.BLNK);
        editSeikyuusyoParam.setHenkougokjnkngk(BizCurrency.valueOf(100000));
        editSeikyuusyoParam.setYuuyokkntyoukaumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setMousideninkbn(C_MousideninKbn.HOUJIN);
        editSeikyuusyoParam.setTrkkzksakujyokahi1(C_KahiKbn.KA);
        editSeikyuusyoParam.setTrkkzksakujyokahi2(C_KahiKbn.HUKA);

        ReportServicesBean reSsBean =  editSeikyuusyoTbl.editBean(C_SyoruiCdKbn.KK_KZKTRKKYKDRTKYKHNK_SKS, syono23, khozenCommonParam, editSeikyuusyoParam);

        Object[] kSBean = reSsBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_KZKTRKKYKDRTKYKHNK_SKS.getValue());

        exNumericEquals(kSBean.length, 2, "パラメータオブジェクトの要素数");

        exNumericEquals(reSsBean.getKensakuKeys().length, 1, "検索キー配列の要素数");
        exStringEquals(reSsBean.getKensakuKeys()[0], "12806345890", "検索キー");

        KhSeikyuusyoBean khSeikyuusyoBean = (KhSeikyuusyoBean)kSBean[0];

        exStringEquals(khSeikyuusyoBean.getIrSyono(), "12806345890", "（ＩＲ）証券番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinyno(), "4354001", "（ＩＲ）通信先郵便番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr1kj(), "住所１", "（ＩＲ）通信先住所１（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr2kj(), "住所２", "（ＩＲ）通信先住所２（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr3kj(), "住所３", "（ＩＲ）通信先住所３（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsintelno(), "023-5677-7999", "（ＩＲ）通信先電話番号");
        exStringEquals(khSeikyuusyoBean.getIrBanknmkj(), "", "（ＩＲ）銀行名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrSitennmkj(), "", "（ＩＲ）支店名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrBankcd(), "", "（ＩＲ）銀行コード");
        exStringEquals(khSeikyuusyoBean.getIrSitencd(), "", "（ＩＲ）支店コード");

        exStringEquals(khSeikyuusyoBean.getIrKzmeiginmkn(), "", "（ＩＲ）口座名義人氏名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkj(), "ユ受名　一あ", "（ＩＲ）契約者名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKkkyktdk(), C_Tdk.HGU, "（ＩＲ）契約管理契約者続柄");
        exStringEquals(khSeikyuusyoBean.getIrHhknnmkj(), "被保険者名", "（ＩＲ）被保険者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrHhknseiymd(), "", "（ＩＲ）被保険者生年月日");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseiymdhenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者生年月日変更有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknsei(), C_Hhknsei.MALE, "（ＩＲ）被保険者性別");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseihenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者性別変更有無");
        exStringEquals(khSeikyuusyoBean.getIrStdrsknmkj(), "", "（ＩＲ）指定代理請求人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrFatcakakuninyhkbn(), C_YouhiblnkKbn.HUYOU, "（ＩＲ）FATCA確認要否区分");
        exClassificationEquals(khSeikyuusyoBean.getIrAeoikakuninyhkbn(), C_YouhiblnkKbn.HUYOU, "（ＩＲ）ＡＥＯＩ確認要否区分");

        exClassificationEquals(khSeikyuusyoBean.getIrTargettkkbn(), C_TargetTkKbn.BLNK, "（ＩＲ）ターゲット特約区分");
        exNumericEquals(khSeikyuusyoBean.getIrAftertargettkmokuhyouti(), 101, "（ＩＲ）変更後ターゲット特約目標値");
        exNumericEquals(khSeikyuusyoBean.getIrBeforetargettkmokuhyouti(), 200, "（ＩＲ）変更前ターゲット特約目標値");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforekihons(), BizCurrency.valueOf(100), "（ＩＲ）基本保険金額（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkihons(),  BizCurrency.valueOf(778), "（ＩＲ）基本保険金額（変更後）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforep(), BizCurrency.valueOf(200), "（ＩＲ）保険料（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterp(), BizCurrency.valueOf(1566), "（ＩＲ）保険料（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrKyktuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）契約通貨種類");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj1(), "", "（ＩＲ）死亡受取人名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj2(), "", "（ＩＲ）死亡受取人名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj3(), "", "（ＩＲ）死亡受取人名（漢字）３");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj4(), "", "（ＩＲ）死亡受取人名（漢字）４");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkn(), "", "（ＩＲ）死亡受取人名（カナ）");
        exClassificationEquals(khSeikyuusyoBean.getIrYokinkbn(), C_YokinKbn.BLNK, "（ＩＲ）預金種目区分");
        exStringEquals(khSeikyuusyoBean.getIrKouzano(), "", "（ＩＲ）口座番号");

        exClassificationEquals(khSeikyuusyoBean.getIrAfternkshrtkyknksyukbn(), C_Nstknsyu.KAKUTEINENKIN, "（ＩＲ）変更後年金支払特約年金種類区分");
        exClassificationEquals(khSeikyuusyoBean.getIrBiforenkshrtkyknksyukbn(), C_Nstknsyu.BLNK, "（ＩＲ）変更前年金支払特約年金種類区分");
        exNumericEquals(khSeikyuusyoBean.getIrAfternkshrtkyknkkkn(), 5, "（ＩＲ）変更後年金支払特約年金期間");
        exNumericEquals(khSeikyuusyoBean.getIrBeforenkshrtkyknkkkn(), 10, "（ＩＲ）変更前年金支払特約年金期間");
        exStringEquals(khSeikyuusyoBean.getIrNkuktnm(), "", "（ＩＲ）年金受取人名");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari1(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合１");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari2(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合２");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari3(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合３");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari4(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合４");
        exClassificationEquals(khSeikyuusyoBean.getIrTargettkhnkkbn(), C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU, "（ＩＲ）ターゲット特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKaiyakujiyuu(), C_Kaiyakujiyuu.TUUJYOU, "（ＩＲ）解約事由");
        exClassificationEquals(khSeikyuusyoBean.getIrGengkhoukbn(), C_GengkhouKbn.SD, "（ＩＲ）減額方法区分");
        exNumericEquals(khSeikyuusyoBean.getIrSbuktnin(), 2, "（ＩＲ）死亡受取人人数");
        exClassificationEquals(khSeikyuusyoBean.getIrSbuuktkbn(), C_UktKbn.BLNK, "（ＩＲ）死亡受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrYenshrtkumu(), C_UmuKbn.ARI, "（ＩＲ）円支払特約有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHenkankinumukbn(), C_UmuKbn.ARI, "（ＩＲ）返還金有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrRstuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）領収通貨種類");
        exClassificationEquals(khSeikyuusyoBean.getIrNkshrtkykhnkkbn(), C_NstkhKbn.NAIYOUHENKOU, "（ＩＲ）年金支払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrMeigihnkjiyuu(), C_Meigihnkjiyuu.KYK, "（ＩＲ）名義変更事由");
        exClassificationEquals(khSeikyuusyoBean.getIrNkhknumu(), C_UmuKbn.ARI, "（ＩＲ）年金保険有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSiboukyhkuktumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡給付金受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn1(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分１");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn2(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分２");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn3(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分３");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn4(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分４");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu1(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無１");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu2(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無２");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu3(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無３");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu4(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無４");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyhukaumu(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyuuktmukbn(), C_UmuKbn.NONE, "（ＩＲ）指定代理請求特約受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrStdruktkbn(), C_UktKbn.BLNK, "（ＩＲ）指定代理受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrJyudkaigomaebrtkykhnkkbn(),C_JyudkaigomaebaraiTkykhnkKbn.BLNK, "（ＩＲ）重度介護前払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKeihikbn(),C_KeihiKbn.BLNK,"（ＩＲ）契被区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKihonshenkouumu(),C_UmuKbn.NONE,"（ＩＲ）基本Ｓ変更有無");
        exStringEquals(khSeikyuusyoBean.getIrKihonssyurui(), "基本保険金額", "（ＩＲ）基本Ｓ種類");
        exClassificationEquals(khSeikyuusyoBean.getIrTmttknitenkbn(), C_Tmttknitenkbn.BLNK, "（ＩＲ）積立金移転区分");
        exStringEquals(khSeikyuusyoBean.getIrTmttknitenymd(), null, "（ＩＲ）積立金移転日");
        exClassificationEquals(khSeikyuusyoBean.getIrKhhrshrjiyuu(), C_Khhrshrjiyuu.BLNK, "（ＩＲ）契約保全返戻金支払事由");
        exClassificationEquals(khSeikyuusyoBean.getIrKhskssakuseijiyuu(), C_Khskssakuseijiyuu.BLNK, "（ＩＲ）契約保全請求書作成事由");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkijyunkingaku(), BizCurrency.valueOf(100000), "（ＩＲ）基準金額（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrHrkkeiro(), C_Hrkkeiro.DANTAI, "（ＩＲ）払込経路");
        exNumericEquals(khSeikyuusyoBean.getIrSyouhnhanteikekka(), 999, "（ＩＲ）商品判定結果");
        exClassificationEquals(khSeikyuusyoBean.getIrKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "（ＩＲ）契約状態");
        exClassificationEquals(khSeikyuusyoBean.getIrZeiseitkkktkykhukaumu(), C_UmuKbn.ARI, "（ＩＲ）税制適格特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrYuuyokkntyoukaumu(), C_UmuKbn.ARI, "（ＩＲ）猶予期間超過有無");
        exClassificationEquals(khSeikyuusyoBean.getIrMousideikoukbn(), null, "（ＩＲ）申出移行区分");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn1(), "ユウケメイ　イチア", "（ＩＲ）登録家族氏名（カナ）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj1(), "ユ受名　一あ　様", "（ＩＲ）登録家族氏名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj1(), "住所１", "（ＩＲ）登録家族住所１（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj1(), "住所２", "（ＩＲ）登録家族住所２（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj1(), "住所３", "（ＩＲ）登録家族住所３（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno1(), "023-5677-8888", "（ＩＲ）登録家族電話番号１");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi1(), C_KahiKbn.KA, "（ＩＲ）登録家族削除可否１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn2(), "ユウケメイ　イチア", "（ＩＲ）登録家族氏名（カナ）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj2(), "ユ受名　一い　様", "（ＩＲ）登録家族氏名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj2(), "住所１", "（ＩＲ）登録家族住所１（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj2(), "住所２", "（ＩＲ）登録家族住所２（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj2(), "住所３", "（ＩＲ）登録家族住所３（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno2(), "023-5677-9999", "（ＩＲ）登録家族電話番号２");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi2(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否２");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkn(), "契約者名（カナ）", "（ＩＲ）契約者名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKykdairinmkj(), "ユ受名　一あ　様", "（ＩＲ）契約者代理人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrtkykhukaumu(), C_UmuKbn.NONE, "（ＩＲ）契約者代理特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrMousideninkbn(), C_MousideninKbn.HOUJIN, "（ＩＲ）申出人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrknhatudoujyoutai(), C_KykdrknHtdjytKbn.SETTEI, "（ＩＲ）契約者代理権発動状態");
        exStringEquals(khSeikyuusyoBean.getIrDrstiskkyknmkj(), "契約者名", "（ＩＲ）代理人指定先契約者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTyouhyoutitle(), "ご家族登録サービス変更請求書", "（ＩＲ）帳票タイトル");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg1(), "登録家族様がご記入ください", "（ＩＲ）送付案内メッセージ１");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg2(), "ご家族登録サービスについて、次のとおり変更します。", "（ＩＲ）送付案内メッセージ２");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg3(), "（詳細は２／２ページのとおり）", "（ＩＲ）送付案内メッセージ３");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg4(), "□変更　□削除", "（ＩＲ）送付案内メッセージ４");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg5(), "□　契約者現住所に同じ", "（ＩＲ）送付案内メッセージ５");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg6(), "送付案内メッセージ６", "（ＩＲ）送付案内メッセージ６");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg7(), "送付案内メッセージ７", "（ＩＲ）送付案内メッセージ７");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg8(), "送付案内メッセージ８", "（ＩＲ）送付案内メッセージ８");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg9(), "送付案内メッセージ９", "（ＩＲ）送付案内メッセージ９");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg10(), "送付案内メッセージ１０", "（ＩＲ）送付案内メッセージ１０");

        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean)kSBean[1];

        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(), null, "（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(), "userId001", "（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(), "user001", "（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(), DateFormatUtil.dateKANJI(BizDate.getSysDate()), "（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(), "　消滅後 2 年", "（ＩＲ）保存期間");

        IT_KykKihon kykKihon = (IT_KykKihon)MockObjectManager.getArgument(GetKhKykdrInfoForHozen.class, "exec", 0, 0);
        exStringEquals(kykKihon.getSyono(), "12806345890", "証券番号");
        exStringEquals(kykKihon.getKbnkey(), "09", "区分キー");
    }

    @Test
    @TestOrder(360)
    public void testEditBean_A36() {

        MockObjectManager.initialize();

        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;

        AM_User aMUser = new AM_User();

        aMUser.setUserId("userId001");
        aMUser.setUserNm("user001");
        changeCurrentUser(baseUserInfo, aMUser);

        RayBCPBean bcpBean = SWAKInjector.getInstance(RayBCPBean.class);
        bcpBean.setBcp(false);
        bcpBean.setDaikouSosikiCd("6620000");
        RayCreator.create();

        editSeikyuusyoParam.setHhknseiymd(BizDate.valueOf(20151026));
        editSeikyuusyoParam.setHhknseiymdhenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setHhknsei(C_Hhknsei.MALE);
        editSeikyuusyoParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setBfrTargettkmokuhyouti(BizNumber.valueOf(101));
        editSeikyuusyoParam.setBfrKihonS(BizCurrency.valueOf(778));
        editSeikyuusyoParam.setBfrP(BizCurrency.valueOf(1566));
        editSeikyuusyoParam.setBfrTokuyakuNenkinsyuKbn(C_Nstknsyu.KAKUTEINENKIN);
        editSeikyuusyoParam.setBfrNkshrtkyknksyukkn(5);
        editSeikyuusyoParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU);
        editSeikyuusyoParam.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editSeikyuusyoParam.setGengkhouKbn(C_GengkhouKbn.SD);
        editSeikyuusyoParam.setHenkankumukbn(C_UmuKbn.ARI);
        editSeikyuusyoParam.setRstuukasyu(C_Tuukasyu.JPY);
        editSeikyuusyoParam.setNkshrtkykhnkkbn(C_NstkhKbn.NAIYOUHENKOU);
        editSeikyuusyoParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);
        editSeikyuusyoParam.setJyudkaigomaebaraiTkykhnkKbn(C_JyudkaigomaebaraiTkykhnkKbn.BLNK);
        editSeikyuusyoParam.setKihonshenkouumu(C_UmuKbn.NONE);
        editSeikyuusyoParam.setTmttknitenkbn(C_Tmttknitenkbn.BLNK);
        editSeikyuusyoParam.setTmttknitenymd(null);
        editSeikyuusyoParam.setKhhrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSeikyuusyoParam.setKhskssakuseijiyuu(C_Khskssakuseijiyuu.BLNK);
        editSeikyuusyoParam.setHenkougokjnkngk(BizCurrency.valueOf(100000));
        editSeikyuusyoParam.setYuuyokkntyoukaumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setMousideninkbn(C_MousideninKbn.HOUJIN);
        editSeikyuusyoParam.setTrkkzksakujyokahi1(C_KahiKbn.KA);
        editSeikyuusyoParam.setTrkkzksakujyokahi2(C_KahiKbn.HUKA);

        ReportServicesBean reSsBean =  editSeikyuusyoTbl.editBean(C_SyoruiCdKbn.KK_MEIGIHNK_SKS, syono24, khozenCommonParam, editSeikyuusyoParam);

        Object[] kSBean = reSsBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_MEIGIHNK_SKS.getValue());

        exNumericEquals(kSBean.length, 2, "パラメータオブジェクトの要素数");

        exNumericEquals(reSsBean.getKensakuKeys().length, 1, "検索キー配列の要素数");
        exStringEquals(reSsBean.getKensakuKeys()[0], "12806345904", "検索キー");

        KhSeikyuusyoBean khSeikyuusyoBean = (KhSeikyuusyoBean)kSBean[0];

        exStringEquals(khSeikyuusyoBean.getIrSyono(), "12806345904", "（ＩＲ）証券番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinyno(), "1234567", "（ＩＲ）通信先郵便番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr1kj(), "通信先住所１", "（ＩＲ）通信先住所１（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr2kj(), "通信先住所２", "（ＩＲ）通信先住所２（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr3kj(), "通信先住所３", "（ＩＲ）通信先住所３（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsintelno(), "023-5677-8999", "（ＩＲ）通信先電話番号");
        exStringEquals(khSeikyuusyoBean.getIrBanknmkj(), "", "（ＩＲ）銀行名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrSitennmkj(), "", "（ＩＲ）支店名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrBankcd(), "", "（ＩＲ）銀行コード");
        exStringEquals(khSeikyuusyoBean.getIrSitencd(), "", "（ＩＲ）支店コード");

        exStringEquals(khSeikyuusyoBean.getIrKzmeiginmkn(), "", "（ＩＲ）口座名義人氏名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkj(), "契約者名", "（ＩＲ）契約者名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKkkyktdk(), C_Tdk.HGU, "（ＩＲ）契約管理契約者続柄");
        exStringEquals(khSeikyuusyoBean.getIrHhknnmkj(), "被保険者名", "（ＩＲ）被保険者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrHhknseiymd(), "", "（ＩＲ）被保険者生年月日");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseiymdhenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者生年月日変更有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknsei(), C_Hhknsei.MALE, "（ＩＲ）被保険者性別");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseihenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者性別変更有無");
        exStringEquals(khSeikyuusyoBean.getIrStdrsknmkj(), "", "（ＩＲ）指定代理請求人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrFatcakakuninyhkbn(), C_YouhiblnkKbn.HUYOU, "（ＩＲ）FATCA確認要否区分");
        exClassificationEquals(khSeikyuusyoBean.getIrAeoikakuninyhkbn(), C_YouhiblnkKbn.YOU, "（ＩＲ）ＡＥＯＩ確認要否区分");

        exClassificationEquals(khSeikyuusyoBean.getIrTargettkkbn(), C_TargetTkKbn.BLNK, "（ＩＲ）ターゲット特約区分");
        exNumericEquals(khSeikyuusyoBean.getIrAftertargettkmokuhyouti(), 101, "（ＩＲ）変更後ターゲット特約目標値");
        exNumericEquals(khSeikyuusyoBean.getIrBeforetargettkmokuhyouti(), 200, "（ＩＲ）変更前ターゲット特約目標値");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforekihons(), BizCurrency.valueOf(100), "（ＩＲ）基本保険金額（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkihons(),  BizCurrency.valueOf(778), "（ＩＲ）基本保険金額（変更後）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforep(), BizCurrency.valueOf(200), "（ＩＲ）保険料（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterp(), BizCurrency.valueOf(1566), "（ＩＲ）保険料（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrKyktuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）契約通貨種類");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj1(), "", "（ＩＲ）死亡受取人名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj2(), "", "（ＩＲ）死亡受取人名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj3(), "", "（ＩＲ）死亡受取人名（漢字）３");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj4(), "", "（ＩＲ）死亡受取人名（漢字）４");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkn(), "", "（ＩＲ）死亡受取人名（カナ）");
        exClassificationEquals(khSeikyuusyoBean.getIrYokinkbn(), C_YokinKbn.BLNK, "（ＩＲ）預金種目区分");
        exStringEquals(khSeikyuusyoBean.getIrKouzano(), "", "（ＩＲ）口座番号");

        exClassificationEquals(khSeikyuusyoBean.getIrAfternkshrtkyknksyukbn(), C_Nstknsyu.KAKUTEINENKIN, "（ＩＲ）変更後年金支払特約年金種類区分");
        exClassificationEquals(khSeikyuusyoBean.getIrBiforenkshrtkyknksyukbn(), C_Nstknsyu.BLNK, "（ＩＲ）変更前年金支払特約年金種類区分");
        exNumericEquals(khSeikyuusyoBean.getIrAfternkshrtkyknkkkn(), 5, "（ＩＲ）変更後年金支払特約年金期間");
        exNumericEquals(khSeikyuusyoBean.getIrBeforenkshrtkyknkkkn(), 10, "（ＩＲ）変更前年金支払特約年金期間");
        exStringEquals(khSeikyuusyoBean.getIrNkuktnm(), "", "（ＩＲ）年金受取人名");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari1(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合１");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari2(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合２");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari3(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合３");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari4(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合４");
        exClassificationEquals(khSeikyuusyoBean.getIrTargettkhnkkbn(), C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU, "（ＩＲ）ターゲット特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKaiyakujiyuu(), C_Kaiyakujiyuu.TUUJYOU, "（ＩＲ）解約事由");
        exClassificationEquals(khSeikyuusyoBean.getIrGengkhoukbn(), C_GengkhouKbn.SD, "（ＩＲ）減額方法区分");
        exNumericEquals(khSeikyuusyoBean.getIrSbuktnin(), 2, "（ＩＲ）死亡受取人人数");
        exClassificationEquals(khSeikyuusyoBean.getIrSbuuktkbn(), C_UktKbn.BLNK, "（ＩＲ）死亡受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrYenshrtkumu(), C_UmuKbn.ARI, "（ＩＲ）円支払特約有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHenkankinumukbn(), C_UmuKbn.ARI, "（ＩＲ）返還金有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrRstuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）領収通貨種類");
        exClassificationEquals(khSeikyuusyoBean.getIrNkshrtkykhnkkbn(), C_NstkhKbn.NAIYOUHENKOU, "（ＩＲ）年金支払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrMeigihnkjiyuu(), C_Meigihnkjiyuu.KYK, "（ＩＲ）名義変更事由");
        exClassificationEquals(khSeikyuusyoBean.getIrNkhknumu(), C_UmuKbn.ARI, "（ＩＲ）年金保険有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSiboukyhkuktumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡給付金受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn1(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分１");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn2(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分２");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn3(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分３");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn4(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分４");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu1(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無１");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu2(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無２");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu3(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無３");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu4(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無４");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyhukaumu(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyuuktmukbn(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrStdruktkbn(), C_UktKbn.TOUROKUKAZOKU1, "（ＩＲ）指定代理受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrJyudkaigomaebrtkykhnkkbn(),C_JyudkaigomaebaraiTkykhnkKbn.BLNK, "（ＩＲ）重度介護前払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKeihikbn(),C_KeihiKbn.BLNK,"（ＩＲ）契被区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKihonshenkouumu(),C_UmuKbn.NONE,"（ＩＲ）基本Ｓ変更有無");
        exStringEquals(khSeikyuusyoBean.getIrKihonssyurui(), "基本保険金額", "（ＩＲ）基本Ｓ種類");
        exClassificationEquals(khSeikyuusyoBean.getIrTmttknitenkbn(), C_Tmttknitenkbn.BLNK, "（ＩＲ）積立金移転区分");
        exStringEquals(khSeikyuusyoBean.getIrTmttknitenymd(), null, "（ＩＲ）積立金移転日");
        exClassificationEquals(khSeikyuusyoBean.getIrKhhrshrjiyuu(), C_Khhrshrjiyuu.BLNK, "（ＩＲ）契約保全返戻金支払事由");
        exClassificationEquals(khSeikyuusyoBean.getIrKhskssakuseijiyuu(), C_Khskssakuseijiyuu.BLNK, "（ＩＲ）契約保全請求書作成事由");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkijyunkingaku(), BizCurrency.valueOf(100000), "（ＩＲ）基準金額（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrHrkkeiro(), C_Hrkkeiro.DANTAI, "（ＩＲ）払込経路");
        exNumericEquals(khSeikyuusyoBean.getIrSyouhnhanteikekka(), 999, "（ＩＲ）商品判定結果");
        exClassificationEquals(khSeikyuusyoBean.getIrKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "（ＩＲ）契約状態");
        exClassificationEquals(khSeikyuusyoBean.getIrZeiseitkkktkykhukaumu(), C_UmuKbn.ARI, "（ＩＲ）税制適格特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrYuuyokkntyoukaumu(), C_UmuKbn.ARI, "（ＩＲ）猶予期間超過有無");
        exClassificationEquals(khSeikyuusyoBean.getIrMousideikoukbn(), null, "（ＩＲ）申出移行区分");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn1(), "ユウケメイ　イチア", "（ＩＲ）登録家族氏名（カナ）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj1(), "ユ受名　一あ", "（ＩＲ）登録家族氏名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj1(), "住所１", "（ＩＲ）登録家族住所１（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj1(), "住所２", "（ＩＲ）登録家族住所２（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj1(), "住所３", "（ＩＲ）登録家族住所３（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno1(), "023-5677-8888", "（ＩＲ）登録家族電話番号１");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi1(), C_KahiKbn.KA, "（ＩＲ）登録家族削除可否１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn2(), "ユウケメイ　イチア", "（ＩＲ）登録家族氏名（カナ）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj2(), "ユ受名　一い", "（ＩＲ）登録家族氏名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj2(), "住所１", "（ＩＲ）登録家族住所１（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj2(), "住所２", "（ＩＲ）登録家族住所２（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj2(), "住所３", "（ＩＲ）登録家族住所３（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno2(), "023-5677-9999", "（ＩＲ）登録家族電話番号２");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi2(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否２");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkn(), "契約者名（カナ）", "（ＩＲ）契約者名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKykdairinmkj(), "", "（ＩＲ）契約者代理人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrtkykhukaumu(), C_UmuKbn.NONE, "（ＩＲ）契約者代理特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrMousideninkbn(), C_MousideninKbn.HOUJIN, "（ＩＲ）申出人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrknhatudoujyoutai(), C_KykdrknHtdjytKbn.SETTEI, "（ＩＲ）契約者代理権発動状態");
        exStringEquals(khSeikyuusyoBean.getIrDrstiskkyknmkj(), "契約者名", "（ＩＲ）代理人指定先契約者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTyouhyoutitle(), null, "（ＩＲ）帳票タイトル");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg1(), null, "（ＩＲ）送付案内メッセージ１");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg2(), null, "（ＩＲ）送付案内メッセージ２");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg3(), null, "（ＩＲ）送付案内メッセージ３");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg4(), null, "（ＩＲ）送付案内メッセージ４");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg5(), null, "（ＩＲ）送付案内メッセージ５");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg6(), null, "（ＩＲ）送付案内メッセージ６");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg7(), null, "（ＩＲ）送付案内メッセージ７");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg8(), null, "（ＩＲ）送付案内メッセージ８");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg9(), null, "（ＩＲ）送付案内メッセージ９");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg10(), null, "（ＩＲ）送付案内メッセージ１０");

        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean)kSBean[1];

        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(), null, "（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(), "userId001", "（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(), "user001", "（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(), DateFormatUtil.dateKANJI(BizDate.getSysDate()), "（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(), "3 年", "（ＩＲ）保存期間");
    }

    @Test
    @TestOrder(370)
    public void testEditBean_A37() {

        MockObjectManager.initialize();

        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;

        AM_User aMUser = new AM_User();

        aMUser.setUserId("userId001");
        aMUser.setUserNm("user001");
        changeCurrentUser(baseUserInfo, aMUser);

        RayBCPBean bcpBean = SWAKInjector.getInstance(RayBCPBean.class);
        bcpBean.setBcp(false);
        bcpBean.setDaikouSosikiCd("6620000");
        RayCreator.create();

        editSeikyuusyoParam.setHhknseiymd(BizDate.valueOf(20151026));
        editSeikyuusyoParam.setHhknseiymdhenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setHhknsei(C_Hhknsei.MALE);
        editSeikyuusyoParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setBfrTargettkmokuhyouti(BizNumber.valueOf(101));
        editSeikyuusyoParam.setBfrKihonS(BizCurrency.valueOf(778));
        editSeikyuusyoParam.setBfrP(BizCurrency.valueOf(1566));
        editSeikyuusyoParam.setBfrTokuyakuNenkinsyuKbn(C_Nstknsyu.KAKUTEINENKIN);
        editSeikyuusyoParam.setBfrNkshrtkyknksyukkn(5);
        editSeikyuusyoParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU);
        editSeikyuusyoParam.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editSeikyuusyoParam.setGengkhouKbn(C_GengkhouKbn.SD);
        editSeikyuusyoParam.setHenkankumukbn(C_UmuKbn.ARI);
        editSeikyuusyoParam.setRstuukasyu(C_Tuukasyu.JPY);
        editSeikyuusyoParam.setNkshrtkykhnkkbn(C_NstkhKbn.NAIYOUHENKOU);
        editSeikyuusyoParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);
        editSeikyuusyoParam.setJyudkaigomaebaraiTkykhnkKbn(C_JyudkaigomaebaraiTkykhnkKbn.BLNK);
        editSeikyuusyoParam.setKihonshenkouumu(C_UmuKbn.NONE);
        editSeikyuusyoParam.setTmttknitenkbn(C_Tmttknitenkbn.BLNK);
        editSeikyuusyoParam.setTmttknitenymd(null);
        editSeikyuusyoParam.setKhhrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSeikyuusyoParam.setKhskssakuseijiyuu(C_Khskssakuseijiyuu.BLNK);
        editSeikyuusyoParam.setHenkougokjnkngk(BizCurrency.valueOf(100000));
        editSeikyuusyoParam.setYuuyokkntyoukaumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setMousideninkbn(C_MousideninKbn.HOUJIN);
        editSeikyuusyoParam.setTrkkzksakujyokahi1(C_KahiKbn.KA);
        editSeikyuusyoParam.setTrkkzksakujyokahi2(C_KahiKbn.HUKA);

        ReportServicesBean reSsBean =  editSeikyuusyoTbl.editBean(C_SyoruiCdKbn.KK_MEIGIHNK_SKS, syono25, khozenCommonParam, editSeikyuusyoParam);

        Object[] kSBean = reSsBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_MEIGIHNK_SKS.getValue());

        exNumericEquals(kSBean.length, 2, "パラメータオブジェクトの要素数");

        exNumericEquals(reSsBean.getKensakuKeys().length, 1, "検索キー配列の要素数");
        exStringEquals(reSsBean.getKensakuKeys()[0], "12806345915", "検索キー");

        KhSeikyuusyoBean khSeikyuusyoBean = (KhSeikyuusyoBean)kSBean[0];

        exStringEquals(khSeikyuusyoBean.getIrSyono(), "12806345915", "（ＩＲ）証券番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinyno(), "1234567", "（ＩＲ）通信先郵便番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr1kj(), "通信先住所１", "（ＩＲ）通信先住所１（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr2kj(), "通信先住所２", "（ＩＲ）通信先住所２（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr3kj(), "通信先住所３", "（ＩＲ）通信先住所３（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsintelno(), "023-5677-8999", "（ＩＲ）通信先電話番号");
        exStringEquals(khSeikyuusyoBean.getIrBanknmkj(), "", "（ＩＲ）銀行名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrSitennmkj(), "", "（ＩＲ）支店名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrBankcd(), "", "（ＩＲ）銀行コード");
        exStringEquals(khSeikyuusyoBean.getIrSitencd(), "", "（ＩＲ）支店コード");

        exStringEquals(khSeikyuusyoBean.getIrKzmeiginmkn(), "", "（ＩＲ）口座名義人氏名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkj(), "契約者名", "（ＩＲ）契約者名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKkkyktdk(), C_Tdk.HGU, "（ＩＲ）契約管理契約者続柄");
        exStringEquals(khSeikyuusyoBean.getIrHhknnmkj(), "被保険者名", "（ＩＲ）被保険者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrHhknseiymd(), "", "（ＩＲ）被保険者生年月日");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseiymdhenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者生年月日変更有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknsei(), C_Hhknsei.MALE, "（ＩＲ）被保険者性別");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseihenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者性別変更有無");
        exStringEquals(khSeikyuusyoBean.getIrStdrsknmkj(), "", "（ＩＲ）指定代理請求人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrFatcakakuninyhkbn(), C_YouhiblnkKbn.HUYOU, "（ＩＲ）FATCA確認要否区分");
        exClassificationEquals(khSeikyuusyoBean.getIrAeoikakuninyhkbn(), C_YouhiblnkKbn.YOU, "（ＩＲ）ＡＥＯＩ確認要否区分");

        exClassificationEquals(khSeikyuusyoBean.getIrTargettkkbn(), C_TargetTkKbn.BLNK, "（ＩＲ）ターゲット特約区分");
        exNumericEquals(khSeikyuusyoBean.getIrAftertargettkmokuhyouti(), 101, "（ＩＲ）変更後ターゲット特約目標値");
        exNumericEquals(khSeikyuusyoBean.getIrBeforetargettkmokuhyouti(), 200, "（ＩＲ）変更前ターゲット特約目標値");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforekihons(), BizCurrency.valueOf(100), "（ＩＲ）基本保険金額（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkihons(),  BizCurrency.valueOf(778), "（ＩＲ）基本保険金額（変更後）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforep(), BizCurrency.valueOf(200), "（ＩＲ）保険料（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterp(), BizCurrency.valueOf(1566), "（ＩＲ）保険料（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrKyktuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）契約通貨種類");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj1(), "", "（ＩＲ）死亡受取人名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj2(), "", "（ＩＲ）死亡受取人名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj3(), "", "（ＩＲ）死亡受取人名（漢字）３");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj4(), "", "（ＩＲ）死亡受取人名（漢字）４");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkn(), "", "（ＩＲ）死亡受取人名（カナ）");
        exClassificationEquals(khSeikyuusyoBean.getIrYokinkbn(), C_YokinKbn.BLNK, "（ＩＲ）預金種目区分");
        exStringEquals(khSeikyuusyoBean.getIrKouzano(), "", "（ＩＲ）口座番号");

        exClassificationEquals(khSeikyuusyoBean.getIrAfternkshrtkyknksyukbn(), C_Nstknsyu.KAKUTEINENKIN, "（ＩＲ）変更後年金支払特約年金種類区分");
        exClassificationEquals(khSeikyuusyoBean.getIrBiforenkshrtkyknksyukbn(), C_Nstknsyu.BLNK, "（ＩＲ）変更前年金支払特約年金種類区分");
        exNumericEquals(khSeikyuusyoBean.getIrAfternkshrtkyknkkkn(), 5, "（ＩＲ）変更後年金支払特約年金期間");
        exNumericEquals(khSeikyuusyoBean.getIrBeforenkshrtkyknkkkn(), 10, "（ＩＲ）変更前年金支払特約年金期間");
        exStringEquals(khSeikyuusyoBean.getIrNkuktnm(), "", "（ＩＲ）年金受取人名");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari1(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合１");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari2(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合２");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari3(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合３");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari4(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合４");
        exClassificationEquals(khSeikyuusyoBean.getIrTargettkhnkkbn(), C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU, "（ＩＲ）ターゲット特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKaiyakujiyuu(), C_Kaiyakujiyuu.TUUJYOU, "（ＩＲ）解約事由");
        exClassificationEquals(khSeikyuusyoBean.getIrGengkhoukbn(), C_GengkhouKbn.SD, "（ＩＲ）減額方法区分");
        exNumericEquals(khSeikyuusyoBean.getIrSbuktnin(), 2, "（ＩＲ）死亡受取人人数");
        exClassificationEquals(khSeikyuusyoBean.getIrSbuuktkbn(), C_UktKbn.BLNK, "（ＩＲ）死亡受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrYenshrtkumu(), C_UmuKbn.ARI, "（ＩＲ）円支払特約有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHenkankinumukbn(), C_UmuKbn.ARI, "（ＩＲ）返還金有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrRstuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）領収通貨種類");
        exClassificationEquals(khSeikyuusyoBean.getIrNkshrtkykhnkkbn(), C_NstkhKbn.NAIYOUHENKOU, "（ＩＲ）年金支払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrMeigihnkjiyuu(), C_Meigihnkjiyuu.KYK, "（ＩＲ）名義変更事由");
        exClassificationEquals(khSeikyuusyoBean.getIrNkhknumu(), C_UmuKbn.ARI, "（ＩＲ）年金保険有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSiboukyhkuktumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡給付金受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn1(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分１");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn2(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分２");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn3(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分３");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn4(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分４");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu1(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無１");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu2(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無２");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu3(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無３");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu4(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無４");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyhukaumu(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyuuktmukbn(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrStdruktkbn(), C_UktKbn.TOUROKUKAZOKU2, "（ＩＲ）指定代理受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrJyudkaigomaebrtkykhnkkbn(),C_JyudkaigomaebaraiTkykhnkKbn.BLNK, "（ＩＲ）重度介護前払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKeihikbn(),C_KeihiKbn.BLNK,"（ＩＲ）契被区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKihonshenkouumu(),C_UmuKbn.NONE,"（ＩＲ）基本Ｓ変更有無");
        exStringEquals(khSeikyuusyoBean.getIrKihonssyurui(), "基本保険金額", "（ＩＲ）基本Ｓ種類");
        exClassificationEquals(khSeikyuusyoBean.getIrTmttknitenkbn(), C_Tmttknitenkbn.BLNK, "（ＩＲ）積立金移転区分");
        exStringEquals(khSeikyuusyoBean.getIrTmttknitenymd(), null, "（ＩＲ）積立金移転日");
        exClassificationEquals(khSeikyuusyoBean.getIrKhhrshrjiyuu(), C_Khhrshrjiyuu.BLNK, "（ＩＲ）契約保全返戻金支払事由");
        exClassificationEquals(khSeikyuusyoBean.getIrKhskssakuseijiyuu(), C_Khskssakuseijiyuu.BLNK, "（ＩＲ）契約保全請求書作成事由");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkijyunkingaku(), BizCurrency.valueOf(100000), "（ＩＲ）基準金額（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrHrkkeiro(), C_Hrkkeiro.DANTAI, "（ＩＲ）払込経路");
        exNumericEquals(khSeikyuusyoBean.getIrSyouhnhanteikekka(), 999, "（ＩＲ）商品判定結果");
        exClassificationEquals(khSeikyuusyoBean.getIrKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "（ＩＲ）契約状態");
        exClassificationEquals(khSeikyuusyoBean.getIrZeiseitkkktkykhukaumu(), C_UmuKbn.ARI, "（ＩＲ）税制適格特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrYuuyokkntyoukaumu(), C_UmuKbn.ARI, "（ＩＲ）猶予期間超過有無");
        exClassificationEquals(khSeikyuusyoBean.getIrMousideikoukbn(), null, "（ＩＲ）申出移行区分");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn1(), "ユウケメイ　イチア", "（ＩＲ）登録家族氏名（カナ）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj1(), "ユ受名　一あ", "（ＩＲ）登録家族氏名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj1(), "住所１", "（ＩＲ）登録家族住所１（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj1(), "住所２", "（ＩＲ）登録家族住所２（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj1(), "住所３", "（ＩＲ）登録家族住所３（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno1(), "023-5677-8888", "（ＩＲ）登録家族電話番号１");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi1(), C_KahiKbn.KA, "（ＩＲ）登録家族削除可否１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn2(), "ユウケメイ　イチア", "（ＩＲ）登録家族氏名（カナ）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj2(), "ユ受名　一い", "（ＩＲ）登録家族氏名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj2(), "住所１", "（ＩＲ）登録家族住所１（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj2(), "住所２", "（ＩＲ）登録家族住所２（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj2(), "住所３", "（ＩＲ）登録家族住所３（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno2(), "023-5677-9999", "（ＩＲ）登録家族電話番号２");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi2(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否２");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkn(), "契約者名（カナ）", "（ＩＲ）契約者名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKykdairinmkj(), "", "（ＩＲ）契約者代理人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrtkykhukaumu(), C_UmuKbn.NONE, "（ＩＲ）契約者代理特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrMousideninkbn(), C_MousideninKbn.HOUJIN, "（ＩＲ）申出人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrknhatudoujyoutai(), C_KykdrknHtdjytKbn.SETTEI, "（ＩＲ）契約者代理権発動状態");
        exStringEquals(khSeikyuusyoBean.getIrDrstiskkyknmkj(), "契約者名", "（ＩＲ）代理人指定先契約者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTyouhyoutitle(), null, "（ＩＲ）帳票タイトル");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg1(), null, "（ＩＲ）送付案内メッセージ１");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg2(), null, "（ＩＲ）送付案内メッセージ２");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg3(), null, "（ＩＲ）送付案内メッセージ３");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg4(), null, "（ＩＲ）送付案内メッセージ４");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg5(), null, "（ＩＲ）送付案内メッセージ５");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg6(), null, "（ＩＲ）送付案内メッセージ６");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg7(), null, "（ＩＲ）送付案内メッセージ７");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg8(), null, "（ＩＲ）送付案内メッセージ８");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg9(), null, "（ＩＲ）送付案内メッセージ９");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg10(), null, "（ＩＲ）送付案内メッセージ１０");

        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean)kSBean[1];

        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(), null, "（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(), "userId001", "（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(), "user001", "（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(), DateFormatUtil.dateKANJI(BizDate.getSysDate()), "（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(), "3 年", "（ＩＲ）保存期間");
    }

    @Test
    @TestOrder(380)
    public void testEditBean_A38() {

        MockObjectManager.initialize();

        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN2;

        AM_User aMUser = new AM_User();

        aMUser.setUserId("userId001");
        aMUser.setUserNm("user001");
        changeCurrentUser(baseUserInfo, aMUser);

        RayBCPBean bcpBean = SWAKInjector.getInstance(RayBCPBean.class);
        bcpBean.setBcp(false);
        bcpBean.setDaikouSosikiCd("6620000");
        RayCreator.create();

        editSeikyuusyoParam.setHhknseiymd(BizDate.valueOf(20151026));
        editSeikyuusyoParam.setHhknseiymdhenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setHhknsei(C_Hhknsei.MALE);
        editSeikyuusyoParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setBfrTargettkmokuhyouti(BizNumber.valueOf(101));
        editSeikyuusyoParam.setBfrKihonS(BizCurrency.valueOf(778));
        editSeikyuusyoParam.setBfrP(BizCurrency.valueOf(1566));
        editSeikyuusyoParam.setBfrTokuyakuNenkinsyuKbn(C_Nstknsyu.KAKUTEINENKIN);
        editSeikyuusyoParam.setBfrNkshrtkyknksyukkn(5);
        editSeikyuusyoParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU);
        editSeikyuusyoParam.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editSeikyuusyoParam.setGengkhouKbn(C_GengkhouKbn.SD);
        editSeikyuusyoParam.setHenkankumukbn(C_UmuKbn.ARI);
        editSeikyuusyoParam.setRstuukasyu(C_Tuukasyu.JPY);
        editSeikyuusyoParam.setNkshrtkykhnkkbn(C_NstkhKbn.NAIYOUHENKOU);
        editSeikyuusyoParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);
        editSeikyuusyoParam.setJyudkaigomaebaraiTkykhnkKbn(C_JyudkaigomaebaraiTkykhnkKbn.BLNK);
        editSeikyuusyoParam.setKihonshenkouumu(C_UmuKbn.NONE);
        editSeikyuusyoParam.setTmttknitenkbn(C_Tmttknitenkbn.BLNK);
        editSeikyuusyoParam.setTmttknitenymd(null);
        editSeikyuusyoParam.setKhhrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSeikyuusyoParam.setKhskssakuseijiyuu(C_Khskssakuseijiyuu.BLNK);
        editSeikyuusyoParam.setHenkougokjnkngk(BizCurrency.valueOf(100000));
        editSeikyuusyoParam.setYuuyokkntyoukaumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setMousideninkbn(C_MousideninKbn.HOUJIN);
        editSeikyuusyoParam.setTrkkzksakujyokahi1(C_KahiKbn.KA);
        editSeikyuusyoParam.setTrkkzksakujyokahi2(C_KahiKbn.HUKA);

        ReportServicesBean reSsBean =  editSeikyuusyoTbl.editBean(C_SyoruiCdKbn.KK_MEIGIHNK_SKS, syono25, khozenCommonParam, editSeikyuusyoParam);

        Object[] kSBean = reSsBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_MEIGIHNK_SKS.getValue());

        exNumericEquals(kSBean.length, 2, "パラメータオブジェクトの要素数");

        exNumericEquals(reSsBean.getKensakuKeys().length, 1, "検索キー配列の要素数");
        exStringEquals(reSsBean.getKensakuKeys()[0], "12806345915", "検索キー");

        KhSeikyuusyoBean khSeikyuusyoBean = (KhSeikyuusyoBean)kSBean[0];

        exStringEquals(khSeikyuusyoBean.getIrSyono(), "12806345915", "（ＩＲ）証券番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinyno(), "1234567", "（ＩＲ）通信先郵便番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr1kj(), "通信先住所１", "（ＩＲ）通信先住所１（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr2kj(), "通信先住所２", "（ＩＲ）通信先住所２（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr3kj(), "通信先住所３", "（ＩＲ）通信先住所３（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsintelno(), "023-5677-8999", "（ＩＲ）通信先電話番号");
        exStringEquals(khSeikyuusyoBean.getIrBanknmkj(), "", "（ＩＲ）銀行名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrSitennmkj(), "", "（ＩＲ）支店名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrBankcd(), "", "（ＩＲ）銀行コード");
        exStringEquals(khSeikyuusyoBean.getIrSitencd(), "", "（ＩＲ）支店コード");

        exStringEquals(khSeikyuusyoBean.getIrKzmeiginmkn(), "", "（ＩＲ）口座名義人氏名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkj(), "契約者名", "（ＩＲ）契約者名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKkkyktdk(), C_Tdk.HGU, "（ＩＲ）契約管理契約者続柄");
        exStringEquals(khSeikyuusyoBean.getIrHhknnmkj(), "被保険者名", "（ＩＲ）被保険者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrHhknseiymd(), "", "（ＩＲ）被保険者生年月日");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseiymdhenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者生年月日変更有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknsei(), C_Hhknsei.MALE, "（ＩＲ）被保険者性別");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseihenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者性別変更有無");
        exStringEquals(khSeikyuusyoBean.getIrStdrsknmkj(), "", "（ＩＲ）指定代理請求人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrFatcakakuninyhkbn(), C_YouhiblnkKbn.HUYOU, "（ＩＲ）FATCA確認要否区分");
        exClassificationEquals(khSeikyuusyoBean.getIrAeoikakuninyhkbn(), C_YouhiblnkKbn.YOU, "（ＩＲ）ＡＥＯＩ確認要否区分");

        exClassificationEquals(khSeikyuusyoBean.getIrTargettkkbn(), C_TargetTkKbn.BLNK, "（ＩＲ）ターゲット特約区分");
        exNumericEquals(khSeikyuusyoBean.getIrAftertargettkmokuhyouti(), 101, "（ＩＲ）変更後ターゲット特約目標値");
        exNumericEquals(khSeikyuusyoBean.getIrBeforetargettkmokuhyouti(), 200, "（ＩＲ）変更前ターゲット特約目標値");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforekihons(), BizCurrency.valueOf(100), "（ＩＲ）基本保険金額（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkihons(),  BizCurrency.valueOf(778), "（ＩＲ）基本保険金額（変更後）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforep(), BizCurrency.valueOf(200), "（ＩＲ）保険料（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterp(), BizCurrency.valueOf(1566), "（ＩＲ）保険料（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrKyktuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）契約通貨種類");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj1(), "", "（ＩＲ）死亡受取人名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj2(), "", "（ＩＲ）死亡受取人名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj3(), "", "（ＩＲ）死亡受取人名（漢字）３");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj4(), "", "（ＩＲ）死亡受取人名（漢字）４");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkn(), "", "（ＩＲ）死亡受取人名（カナ）");
        exClassificationEquals(khSeikyuusyoBean.getIrYokinkbn(), C_YokinKbn.BLNK, "（ＩＲ）預金種目区分");
        exStringEquals(khSeikyuusyoBean.getIrKouzano(), "", "（ＩＲ）口座番号");

        exClassificationEquals(khSeikyuusyoBean.getIrAfternkshrtkyknksyukbn(), C_Nstknsyu.KAKUTEINENKIN, "（ＩＲ）変更後年金支払特約年金種類区分");
        exClassificationEquals(khSeikyuusyoBean.getIrBiforenkshrtkyknksyukbn(), C_Nstknsyu.BLNK, "（ＩＲ）変更前年金支払特約年金種類区分");
        exNumericEquals(khSeikyuusyoBean.getIrAfternkshrtkyknkkkn(), 5, "（ＩＲ）変更後年金支払特約年金期間");
        exNumericEquals(khSeikyuusyoBean.getIrBeforenkshrtkyknkkkn(), 10, "（ＩＲ）変更前年金支払特約年金期間");
        exStringEquals(khSeikyuusyoBean.getIrNkuktnm(), "", "（ＩＲ）年金受取人名");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari1(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合１");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari2(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合２");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari3(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合３");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari4(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合４");
        exClassificationEquals(khSeikyuusyoBean.getIrTargettkhnkkbn(), C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU, "（ＩＲ）ターゲット特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKaiyakujiyuu(), C_Kaiyakujiyuu.TUUJYOU, "（ＩＲ）解約事由");
        exClassificationEquals(khSeikyuusyoBean.getIrGengkhoukbn(), C_GengkhouKbn.SD, "（ＩＲ）減額方法区分");
        exNumericEquals(khSeikyuusyoBean.getIrSbuktnin(), 2, "（ＩＲ）死亡受取人人数");
        exClassificationEquals(khSeikyuusyoBean.getIrSbuuktkbn(), C_UktKbn.BLNK, "（ＩＲ）死亡受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrYenshrtkumu(), C_UmuKbn.ARI, "（ＩＲ）円支払特約有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHenkankinumukbn(), C_UmuKbn.ARI, "（ＩＲ）返還金有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrRstuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）領収通貨種類");
        exClassificationEquals(khSeikyuusyoBean.getIrNkshrtkykhnkkbn(), C_NstkhKbn.NAIYOUHENKOU, "（ＩＲ）年金支払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrMeigihnkjiyuu(), C_Meigihnkjiyuu.KYK, "（ＩＲ）名義変更事由");
        exClassificationEquals(khSeikyuusyoBean.getIrNkhknumu(), C_UmuKbn.ARI, "（ＩＲ）年金保険有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSiboukyhkuktumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡給付金受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn1(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分１");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn2(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分２");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn3(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分３");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn4(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分４");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu1(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無１");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu2(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無２");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu3(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無３");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu4(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無４");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyhukaumu(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyuuktmukbn(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrStdruktkbn(), C_UktKbn.TOUROKUKAZOKU2, "（ＩＲ）指定代理受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrJyudkaigomaebrtkykhnkkbn(),C_JyudkaigomaebaraiTkykhnkKbn.BLNK, "（ＩＲ）重度介護前払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKeihikbn(),C_KeihiKbn.BLNK,"（ＩＲ）契被区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKihonshenkouumu(),C_UmuKbn.NONE,"（ＩＲ）基本Ｓ変更有無");
        exStringEquals(khSeikyuusyoBean.getIrKihonssyurui(), "基本保険金額", "（ＩＲ）基本Ｓ種類");
        exClassificationEquals(khSeikyuusyoBean.getIrTmttknitenkbn(), C_Tmttknitenkbn.BLNK, "（ＩＲ）積立金移転区分");
        exStringEquals(khSeikyuusyoBean.getIrTmttknitenymd(), null, "（ＩＲ）積立金移転日");
        exClassificationEquals(khSeikyuusyoBean.getIrKhhrshrjiyuu(), C_Khhrshrjiyuu.BLNK, "（ＩＲ）契約保全返戻金支払事由");
        exClassificationEquals(khSeikyuusyoBean.getIrKhskssakuseijiyuu(), C_Khskssakuseijiyuu.BLNK, "（ＩＲ）契約保全請求書作成事由");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkijyunkingaku(), BizCurrency.valueOf(100000), "（ＩＲ）基準金額（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrHrkkeiro(), C_Hrkkeiro.DANTAI, "（ＩＲ）払込経路");
        exNumericEquals(khSeikyuusyoBean.getIrSyouhnhanteikekka(), 999, "（ＩＲ）商品判定結果");
        exClassificationEquals(khSeikyuusyoBean.getIrKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "（ＩＲ）契約状態");
        exClassificationEquals(khSeikyuusyoBean.getIrZeiseitkkktkykhukaumu(), C_UmuKbn.ARI, "（ＩＲ）税制適格特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrYuuyokkntyoukaumu(), C_UmuKbn.ARI, "（ＩＲ）猶予期間超過有無");
        exClassificationEquals(khSeikyuusyoBean.getIrMousideikoukbn(), null, "（ＩＲ）申出移行区分");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn1(), "ユウケメイ　イチア", "（ＩＲ）登録家族氏名（カナ）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj1(), "ユ受名　一あ", "（ＩＲ）登録家族氏名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj1(), "住所１", "（ＩＲ）登録家族住所１（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj1(), "住所２", "（ＩＲ）登録家族住所２（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj1(), "住所３", "（ＩＲ）登録家族住所３（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno1(), "023-5677-8888", "（ＩＲ）登録家族電話番号１");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi1(), C_KahiKbn.KA, "（ＩＲ）登録家族削除可否１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn2(), "ユウケメイ　イチア", "（ＩＲ）登録家族氏名（カナ）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj2(), "ユ受名　一い", "（ＩＲ）登録家族氏名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj2(), "住所１", "（ＩＲ）登録家族住所１（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj2(), "住所２", "（ＩＲ）登録家族住所２（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj2(), "住所３", "（ＩＲ）登録家族住所３（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno2(), "023-5677-9999", "（ＩＲ）登録家族電話番号２");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi2(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否２");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkn(), "契約者名（カナ）", "（ＩＲ）契約者名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKykdairinmkj(), "ユ受名　一あ", "（ＩＲ）契約者代理人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrtkykhukaumu(), C_UmuKbn.NONE, "（ＩＲ）契約者代理特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrMousideninkbn(), C_MousideninKbn.HOUJIN, "（ＩＲ）申出人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrknhatudoujyoutai(), C_KykdrknHtdjytKbn.SETTEI, "（ＩＲ）契約者代理権発動状態");
        exStringEquals(khSeikyuusyoBean.getIrDrstiskkyknmkj(), "契約者名", "（ＩＲ）代理人指定先契約者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTyouhyoutitle(), null, "（ＩＲ）帳票タイトル");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg1(), null, "（ＩＲ）送付案内メッセージ１");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg2(), null, "（ＩＲ）送付案内メッセージ２");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg3(), null, "（ＩＲ）送付案内メッセージ３");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg4(), null, "（ＩＲ）送付案内メッセージ４");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg5(), null, "（ＩＲ）送付案内メッセージ５");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg6(), null, "（ＩＲ）送付案内メッセージ６");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg7(), null, "（ＩＲ）送付案内メッセージ７");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg8(), null, "（ＩＲ）送付案内メッセージ８");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg9(), null, "（ＩＲ）送付案内メッセージ９");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg10(), null, "（ＩＲ）送付案内メッセージ１０");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrkbn(), C_UktKbn.TOKUTEIMEIGI, "（ＩＲ）契約者代理人区分");

        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean)kSBean[1];

        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(), null, "（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(), "userId001", "（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(), "user001", "（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(), DateFormatUtil.dateKANJI(BizDate.getSysDate()), "（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(), "3 年", "（ＩＲ）保存期間");
    }

    @Test
    @TestOrder(390)
    public void testEditBean_A39() {

        MockObjectManager.initialize();

        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN2;

        AM_User aMUser = new AM_User();

        aMUser.setUserId("userId001");
        aMUser.setUserNm("user001");
        changeCurrentUser(baseUserInfo, aMUser);

        RayBCPBean bcpBean = SWAKInjector.getInstance(RayBCPBean.class);
        bcpBean.setBcp(false);
        bcpBean.setDaikouSosikiCd("6620000");
        RayCreator.create();

        editSeikyuusyoParam.setHhknseiymd(BizDate.valueOf(20151026));
        editSeikyuusyoParam.setHhknseiymdhenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setHhknsei(C_Hhknsei.MALE);
        editSeikyuusyoParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setBfrTargettkmokuhyouti(BizNumber.valueOf(101));
        editSeikyuusyoParam.setBfrKihonS(BizCurrency.valueOf(778));
        editSeikyuusyoParam.setBfrP(BizCurrency.valueOf(1566));
        editSeikyuusyoParam.setBfrTokuyakuNenkinsyuKbn(C_Nstknsyu.KAKUTEINENKIN);
        editSeikyuusyoParam.setBfrNkshrtkyknksyukkn(5);
        editSeikyuusyoParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU);
        editSeikyuusyoParam.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editSeikyuusyoParam.setGengkhouKbn(C_GengkhouKbn.SD);
        editSeikyuusyoParam.setHenkankumukbn(C_UmuKbn.ARI);
        editSeikyuusyoParam.setRstuukasyu(C_Tuukasyu.JPY);
        editSeikyuusyoParam.setNkshrtkykhnkkbn(C_NstkhKbn.NAIYOUHENKOU);
        editSeikyuusyoParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);
        editSeikyuusyoParam.setJyudkaigomaebaraiTkykhnkKbn(C_JyudkaigomaebaraiTkykhnkKbn.BLNK);
        editSeikyuusyoParam.setKihonshenkouumu(C_UmuKbn.NONE);
        editSeikyuusyoParam.setTmttknitenkbn(C_Tmttknitenkbn.BLNK);
        editSeikyuusyoParam.setTmttknitenymd(null);
        editSeikyuusyoParam.setKhhrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSeikyuusyoParam.setKhskssakuseijiyuu(C_Khskssakuseijiyuu.BLNK);
        editSeikyuusyoParam.setHenkougokjnkngk(BizCurrency.valueOf(100000));
        editSeikyuusyoParam.setYuuyokkntyoukaumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setMousideninkbn(C_MousideninKbn.KYKHONNIN);
        editSeikyuusyoParam.setTrkkzksakujyokahi1(C_KahiKbn.KA);
        editSeikyuusyoParam.setTrkkzksakujyokahi2(C_KahiKbn.HUKA);

        ReportServicesBean reSsBean =  editSeikyuusyoTbl.editBean(C_SyoruiCdKbn.KK_KZKTRKKYKDRTKYKHNK_SKS, syono21, khozenCommonParam, editSeikyuusyoParam);

        Object[] kSBean = reSsBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_KZKTRKKYKDRTKYKHNK_SKS.getValue());

        exNumericEquals(kSBean.length, 2, "パラメータオブジェクトの要素数");

        exNumericEquals(reSsBean.getKensakuKeys().length, 1, "検索キー配列の要素数");
        exStringEquals(reSsBean.getKensakuKeys()[0], "12806345878", "検索キー");

        KhSeikyuusyoBean khSeikyuusyoBean = (KhSeikyuusyoBean)kSBean[0];

        exStringEquals(khSeikyuusyoBean.getIrSyono(), "12806345878", "（ＩＲ）証券番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinyno(), "1234567", "（ＩＲ）通信先郵便番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr1kj(), "通信先住所１", "（ＩＲ）通信先住所１（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr2kj(), "通信先住所２", "（ＩＲ）通信先住所２（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr3kj(), "通信先住所３", "（ＩＲ）通信先住所３（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsintelno(), "023-5677-8999", "（ＩＲ）通信先電話番号");
        exStringEquals(khSeikyuusyoBean.getIrBanknmkj(), "", "（ＩＲ）銀行名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrSitennmkj(), "", "（ＩＲ）支店名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrBankcd(), "", "（ＩＲ）銀行コード");
        exStringEquals(khSeikyuusyoBean.getIrSitencd(), "", "（ＩＲ）支店コード");

        exStringEquals(khSeikyuusyoBean.getIrKzmeiginmkn(), "", "（ＩＲ）口座名義人氏名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkj(), "契約者名", "（ＩＲ）契約者名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKkkyktdk(), C_Tdk.HGU, "（ＩＲ）契約管理契約者続柄");
        exStringEquals(khSeikyuusyoBean.getIrHhknnmkj(), "被保険者名", "（ＩＲ）被保険者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrHhknseiymd(), "", "（ＩＲ）被保険者生年月日");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseiymdhenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者生年月日変更有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknsei(), C_Hhknsei.MALE, "（ＩＲ）被保険者性別");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseihenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者性別変更有無");
        exStringEquals(khSeikyuusyoBean.getIrStdrsknmkj(), "", "（ＩＲ）指定代理請求人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrFatcakakuninyhkbn(), C_YouhiblnkKbn.HUYOU, "（ＩＲ）FATCA確認要否区分");
        exClassificationEquals(khSeikyuusyoBean.getIrAeoikakuninyhkbn(), C_YouhiblnkKbn.HUYOU, "（ＩＲ）ＡＥＯＩ確認要否区分");

        exClassificationEquals(khSeikyuusyoBean.getIrTargettkkbn(), C_TargetTkKbn.BLNK, "（ＩＲ）ターゲット特約区分");
        exNumericEquals(khSeikyuusyoBean.getIrAftertargettkmokuhyouti(), 101, "（ＩＲ）変更後ターゲット特約目標値");
        exNumericEquals(khSeikyuusyoBean.getIrBeforetargettkmokuhyouti(), 200, "（ＩＲ）変更前ターゲット特約目標値");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforekihons(), BizCurrency.valueOf(100), "（ＩＲ）基本保険金額（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkihons(),  BizCurrency.valueOf(778), "（ＩＲ）基本保険金額（変更後）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforep(), BizCurrency.valueOf(200), "（ＩＲ）保険料（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterp(), BizCurrency.valueOf(1566), "（ＩＲ）保険料（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrKyktuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）契約通貨種類");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj1(), "", "（ＩＲ）死亡受取人名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj2(), "", "（ＩＲ）死亡受取人名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj3(), "", "（ＩＲ）死亡受取人名（漢字）３");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj4(), "", "（ＩＲ）死亡受取人名（漢字）４");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkn(), "", "（ＩＲ）死亡受取人名（カナ）");
        exClassificationEquals(khSeikyuusyoBean.getIrYokinkbn(), C_YokinKbn.BLNK, "（ＩＲ）預金種目区分");
        exStringEquals(khSeikyuusyoBean.getIrKouzano(), "", "（ＩＲ）口座番号");

        exClassificationEquals(khSeikyuusyoBean.getIrAfternkshrtkyknksyukbn(), C_Nstknsyu.KAKUTEINENKIN, "（ＩＲ）変更後年金支払特約年金種類区分");
        exClassificationEquals(khSeikyuusyoBean.getIrBiforenkshrtkyknksyukbn(), C_Nstknsyu.BLNK, "（ＩＲ）変更前年金支払特約年金種類区分");
        exNumericEquals(khSeikyuusyoBean.getIrAfternkshrtkyknkkkn(), 5, "（ＩＲ）変更後年金支払特約年金期間");
        exNumericEquals(khSeikyuusyoBean.getIrBeforenkshrtkyknkkkn(), 10, "（ＩＲ）変更前年金支払特約年金期間");
        exStringEquals(khSeikyuusyoBean.getIrNkuktnm(), "", "（ＩＲ）年金受取人名");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari1(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合１");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari2(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合２");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari3(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合３");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari4(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合４");
        exClassificationEquals(khSeikyuusyoBean.getIrTargettkhnkkbn(), C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU, "（ＩＲ）ターゲット特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKaiyakujiyuu(), C_Kaiyakujiyuu.TUUJYOU, "（ＩＲ）解約事由");
        exClassificationEquals(khSeikyuusyoBean.getIrGengkhoukbn(), C_GengkhouKbn.SD, "（ＩＲ）減額方法区分");
        exNumericEquals(khSeikyuusyoBean.getIrSbuktnin(), 2, "（ＩＲ）死亡受取人人数");
        exClassificationEquals(khSeikyuusyoBean.getIrSbuuktkbn(), C_UktKbn.BLNK, "（ＩＲ）死亡受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrYenshrtkumu(), C_UmuKbn.ARI, "（ＩＲ）円支払特約有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHenkankinumukbn(), C_UmuKbn.ARI, "（ＩＲ）返還金有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrRstuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）領収通貨種類");
        exClassificationEquals(khSeikyuusyoBean.getIrNkshrtkykhnkkbn(), C_NstkhKbn.NAIYOUHENKOU, "（ＩＲ）年金支払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrMeigihnkjiyuu(), C_Meigihnkjiyuu.KYK, "（ＩＲ）名義変更事由");
        exClassificationEquals(khSeikyuusyoBean.getIrNkhknumu(), C_UmuKbn.ARI, "（ＩＲ）年金保険有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSiboukyhkuktumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡給付金受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn1(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分１");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn2(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分２");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn3(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分３");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn4(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分４");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu1(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無１");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu2(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無２");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu3(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無３");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu4(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無４");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyhukaumu(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyuuktmukbn(), C_UmuKbn.NONE, "（ＩＲ）指定代理請求特約受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrStdruktkbn(), C_UktKbn.BLNK, "（ＩＲ）指定代理受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrJyudkaigomaebrtkykhnkkbn(),C_JyudkaigomaebaraiTkykhnkKbn.BLNK, "（ＩＲ）重度介護前払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKeihikbn(),C_KeihiKbn.BLNK,"（ＩＲ）契被区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKihonshenkouumu(),C_UmuKbn.NONE,"（ＩＲ）基本Ｓ変更有無");
        exStringEquals(khSeikyuusyoBean.getIrKihonssyurui(), "基本保険金額", "（ＩＲ）基本Ｓ種類");
        exClassificationEquals(khSeikyuusyoBean.getIrTmttknitenkbn(), C_Tmttknitenkbn.BLNK, "（ＩＲ）積立金移転区分");
        exStringEquals(khSeikyuusyoBean.getIrTmttknitenymd(), null, "（ＩＲ）積立金移転日");
        exClassificationEquals(khSeikyuusyoBean.getIrKhhrshrjiyuu(), C_Khhrshrjiyuu.BLNK, "（ＩＲ）契約保全返戻金支払事由");
        exClassificationEquals(khSeikyuusyoBean.getIrKhskssakuseijiyuu(), C_Khskssakuseijiyuu.BLNK, "（ＩＲ）契約保全請求書作成事由");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkijyunkingaku(), BizCurrency.valueOf(100000), "（ＩＲ）基準金額（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrHrkkeiro(), C_Hrkkeiro.DANTAI, "（ＩＲ）払込経路");
        exNumericEquals(khSeikyuusyoBean.getIrSyouhnhanteikekka(), 999, "（ＩＲ）商品判定結果");
        exClassificationEquals(khSeikyuusyoBean.getIrKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "（ＩＲ）契約状態");
        exClassificationEquals(khSeikyuusyoBean.getIrZeiseitkkktkykhukaumu(), C_UmuKbn.ARI, "（ＩＲ）税制適格特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrYuuyokkntyoukaumu(), C_UmuKbn.ARI, "（ＩＲ）猶予期間超過有無");
        exClassificationEquals(khSeikyuusyoBean.getIrMousideikoukbn(), null, "（ＩＲ）申出移行区分");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn1(), "ユウケメイ　イチア", "（ＩＲ）登録家族氏名（カナ）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj1(), "未登録", "（ＩＲ）登録家族氏名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj1(), "未登録", "（ＩＲ）登録家族住所１（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj1(), "住所２", "（ＩＲ）登録家族住所２（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj1(), "住所３", "（ＩＲ）登録家族住所３（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno1(), "未登録", "（ＩＲ）登録家族電話番号１");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi1(), C_KahiKbn.KA, "（ＩＲ）登録家族削除可否１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn2(), "ユウケメイ　イチア", "（ＩＲ）登録家族氏名（カナ）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj2(), "未登録", "（ＩＲ）登録家族氏名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj2(), "未登録", "（ＩＲ）登録家族住所１（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj2(), "住所２", "（ＩＲ）登録家族住所２（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj2(), "住所３", "（ＩＲ）登録家族住所３（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno2(), "未登録", "（ＩＲ）登録家族電話番号２");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi2(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否２");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkn(), "契約者名（カナ）", "（ＩＲ）契約者名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKykdairinmkj(), "右記欄にご記入ください→", "（ＩＲ）契約者代理人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrtkykhukaumu(), C_UmuKbn.NONE, "（ＩＲ）契約者代理特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrMousideninkbn(), C_MousideninKbn.KYKHONNIN, "（ＩＲ）申出人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrknhatudoujyoutai(), C_KykdrknHtdjytKbn.BLNK, "（ＩＲ）契約者代理権発動状態");
        exStringEquals(khSeikyuusyoBean.getIrDrstiskkyknmkj(), "契約者名", "（ＩＲ）代理人指定先契約者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTyouhyoutitle(), "ご家族登録サービス　兼　保険契約者代理特約変更請求書", "（ＩＲ）帳票タイトル");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg1(), "契約者様がご記入ください", "（ＩＲ）送付案内メッセージ１");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg2(), "ご家族登録サービスおよび保険契約者代理特約について、次のとおり変更します。", "（ＩＲ）送付案内メッセージ２");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg3(), "（詳細は２／２ページのとおり）", "（ＩＲ）送付案内メッセージ３");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg4(), "□登録　□変更　□削除", "（ＩＲ）送付案内メッセージ４");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg5(), "□　１／２ページに記載の請求者現住所に同じ", "（ＩＲ）送付案内メッセージ５");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg6(), "送付案内メッセージ６", "（ＩＲ）送付案内メッセージ６");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg7(), "送付案内メッセージ７", "（ＩＲ）送付案内メッセージ７");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg8(), "送付案内メッセージ８", "（ＩＲ）送付案内メッセージ８");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg9(), "送付案内メッセージ９", "（ＩＲ）送付案内メッセージ９");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg10(), "送付案内メッセージ１０", "（ＩＲ）送付案内メッセージ１０");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrkbn(), C_UktKbn.BLNK, "（ＩＲ）契約者代理人区分");

        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean)kSBean[1];

        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(), null, "（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(), "userId001", "（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(), "user001", "（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(), DateFormatUtil.dateKANJI(BizDate.getSysDate()), "（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(), "　消滅後 2 年", "（ＩＲ）保存期間");

        IT_KykKihon kykKihon = (IT_KykKihon)MockObjectManager.getArgument(GetKhKykdrInfoForHozen.class, "exec", 0, 0);
        exStringEquals(kykKihon.getSyono(), "12806345878", "証券番号");
        exStringEquals(kykKihon.getKbnkey(), "07", "区分キー");
    }

    @Test
    @TestOrder(400)
    public void testEditBean_A40() {

        MockObjectManager.initialize();

        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN3;

        AM_User aMUser = new AM_User();

        aMUser.setUserId("userId001");
        aMUser.setUserNm("user001");
        changeCurrentUser(baseUserInfo, aMUser);

        RayBCPBean bcpBean = SWAKInjector.getInstance(RayBCPBean.class);
        bcpBean.setBcp(false);
        bcpBean.setDaikouSosikiCd("6620000");
        RayCreator.create();

        editSeikyuusyoParam.setHhknseiymd(BizDate.valueOf(20151026));
        editSeikyuusyoParam.setHhknseiymdhenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setHhknsei(C_Hhknsei.MALE);
        editSeikyuusyoParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setBfrTargettkmokuhyouti(BizNumber.valueOf(101));
        editSeikyuusyoParam.setBfrKihonS(BizCurrency.valueOf(778));
        editSeikyuusyoParam.setBfrP(BizCurrency.valueOf(1566));
        editSeikyuusyoParam.setBfrTokuyakuNenkinsyuKbn(C_Nstknsyu.KAKUTEINENKIN);
        editSeikyuusyoParam.setBfrNkshrtkyknksyukkn(5);
        editSeikyuusyoParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU);
        editSeikyuusyoParam.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editSeikyuusyoParam.setGengkhouKbn(C_GengkhouKbn.SD);
        editSeikyuusyoParam.setHenkankumukbn(C_UmuKbn.ARI);
        editSeikyuusyoParam.setRstuukasyu(C_Tuukasyu.JPY);
        editSeikyuusyoParam.setNkshrtkykhnkkbn(C_NstkhKbn.NAIYOUHENKOU);
        editSeikyuusyoParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);
        editSeikyuusyoParam.setJyudkaigomaebaraiTkykhnkKbn(C_JyudkaigomaebaraiTkykhnkKbn.BLNK);
        editSeikyuusyoParam.setKihonshenkouumu(C_UmuKbn.NONE);
        editSeikyuusyoParam.setTmttknitenkbn(C_Tmttknitenkbn.BLNK);
        editSeikyuusyoParam.setTmttknitenymd(null);
        editSeikyuusyoParam.setKhhrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSeikyuusyoParam.setKhskssakuseijiyuu(C_Khskssakuseijiyuu.BLNK);
        editSeikyuusyoParam.setHenkougokjnkngk(BizCurrency.valueOf(100000));
        editSeikyuusyoParam.setYuuyokkntyoukaumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setMousideninkbn(C_MousideninKbn.KYKHONNIN);
        editSeikyuusyoParam.setTrkkzksakujyokahi1(C_KahiKbn.KA);
        editSeikyuusyoParam.setTrkkzksakujyokahi2(C_KahiKbn.HUKA);

        ReportServicesBean reSsBean =  editSeikyuusyoTbl.editBean(C_SyoruiCdKbn.KK_KZKTRKKYKDRTKYKHNK_SKS, syono21, khozenCommonParam, editSeikyuusyoParam);

        Object[] kSBean = reSsBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_KZKTRKKYKDRTKYKHNK_SKS.getValue());

        exNumericEquals(kSBean.length, 2, "パラメータオブジェクトの要素数");

        exNumericEquals(reSsBean.getKensakuKeys().length, 1, "検索キー配列の要素数");
        exStringEquals(reSsBean.getKensakuKeys()[0], "12806345878", "検索キー");

        KhSeikyuusyoBean khSeikyuusyoBean = (KhSeikyuusyoBean)kSBean[0];

        exStringEquals(khSeikyuusyoBean.getIrSyono(), "12806345878", "（ＩＲ）証券番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinyno(), "1234567", "（ＩＲ）通信先郵便番号");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr1kj(), "通信先住所１", "（ＩＲ）通信先住所１（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr2kj(), "通信先住所２", "（ＩＲ）通信先住所２（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsinadr3kj(), "通信先住所３", "（ＩＲ）通信先住所３（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTsintelno(), "023-5677-8999", "（ＩＲ）通信先電話番号");
        exStringEquals(khSeikyuusyoBean.getIrBanknmkj(), "", "（ＩＲ）銀行名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrSitennmkj(), "", "（ＩＲ）支店名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrBankcd(), "", "（ＩＲ）銀行コード");
        exStringEquals(khSeikyuusyoBean.getIrSitencd(), "", "（ＩＲ）支店コード");

        exStringEquals(khSeikyuusyoBean.getIrKzmeiginmkn(), "", "（ＩＲ）口座名義人氏名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkj(), "契約者名", "（ＩＲ）契約者名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKkkyktdk(), C_Tdk.HGU, "（ＩＲ）契約管理契約者続柄");
        exStringEquals(khSeikyuusyoBean.getIrHhknnmkj(), "被保険者名", "（ＩＲ）被保険者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrHhknseiymd(), "", "（ＩＲ）被保険者生年月日");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseiymdhenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者生年月日変更有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknsei(), C_Hhknsei.MALE, "（ＩＲ）被保険者性別");
        exClassificationEquals(khSeikyuusyoBean.getIrHhknseihenkouumu(), C_UmuKbn.ARI, "（ＩＲ）被保険者性別変更有無");
        exStringEquals(khSeikyuusyoBean.getIrStdrsknmkj(), "", "（ＩＲ）指定代理請求人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrFatcakakuninyhkbn(), C_YouhiblnkKbn.HUYOU, "（ＩＲ）FATCA確認要否区分");
        exClassificationEquals(khSeikyuusyoBean.getIrAeoikakuninyhkbn(), C_YouhiblnkKbn.HUYOU, "（ＩＲ）ＡＥＯＩ確認要否区分");

        exClassificationEquals(khSeikyuusyoBean.getIrTargettkkbn(), C_TargetTkKbn.BLNK, "（ＩＲ）ターゲット特約区分");
        exNumericEquals(khSeikyuusyoBean.getIrAftertargettkmokuhyouti(), 101, "（ＩＲ）変更後ターゲット特約目標値");
        exNumericEquals(khSeikyuusyoBean.getIrBeforetargettkmokuhyouti(), 200, "（ＩＲ）変更前ターゲット特約目標値");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforekihons(), BizCurrency.valueOf(100), "（ＩＲ）基本保険金額（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkihons(),  BizCurrency.valueOf(778), "（ＩＲ）基本保険金額（変更後）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrBeforep(), BizCurrency.valueOf(200), "（ＩＲ）保険料（変更前）");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterp(), BizCurrency.valueOf(1566), "（ＩＲ）保険料（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrKyktuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）契約通貨種類");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj1(), "", "（ＩＲ）死亡受取人名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj2(), "", "（ＩＲ）死亡受取人名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj3(), "", "（ＩＲ）死亡受取人名（漢字）３");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkj4(), "", "（ＩＲ）死亡受取人名（漢字）４");
        exStringEquals(khSeikyuusyoBean.getIrSbuktnmkn(), "", "（ＩＲ）死亡受取人名（カナ）");
        exClassificationEquals(khSeikyuusyoBean.getIrYokinkbn(), C_YokinKbn.BLNK, "（ＩＲ）預金種目区分");
        exStringEquals(khSeikyuusyoBean.getIrKouzano(), "", "（ＩＲ）口座番号");

        exClassificationEquals(khSeikyuusyoBean.getIrAfternkshrtkyknksyukbn(), C_Nstknsyu.KAKUTEINENKIN, "（ＩＲ）変更後年金支払特約年金種類区分");
        exClassificationEquals(khSeikyuusyoBean.getIrBiforenkshrtkyknksyukbn(), C_Nstknsyu.BLNK, "（ＩＲ）変更前年金支払特約年金種類区分");
        exNumericEquals(khSeikyuusyoBean.getIrAfternkshrtkyknkkkn(), 5, "（ＩＲ）変更後年金支払特約年金期間");
        exNumericEquals(khSeikyuusyoBean.getIrBeforenkshrtkyknkkkn(), 10, "（ＩＲ）変更前年金支払特約年金期間");
        exStringEquals(khSeikyuusyoBean.getIrNkuktnm(), "", "（ＩＲ）年金受取人名");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari1(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合１");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari2(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合２");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari3(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合３");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrSbubnwari4(), BizNumber.valueOf(0), "（ＩＲ）死亡受取人分割割合４");
        exClassificationEquals(khSeikyuusyoBean.getIrTargettkhnkkbn(), C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU, "（ＩＲ）ターゲット特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKaiyakujiyuu(), C_Kaiyakujiyuu.TUUJYOU, "（ＩＲ）解約事由");
        exClassificationEquals(khSeikyuusyoBean.getIrGengkhoukbn(), C_GengkhouKbn.SD, "（ＩＲ）減額方法区分");
        exNumericEquals(khSeikyuusyoBean.getIrSbuktnin(), 2, "（ＩＲ）死亡受取人人数");
        exClassificationEquals(khSeikyuusyoBean.getIrSbuuktkbn(), C_UktKbn.BLNK, "（ＩＲ）死亡受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrYenshrtkumu(), C_UmuKbn.ARI, "（ＩＲ）円支払特約有無");
        exClassificationEquals(khSeikyuusyoBean.getIrHenkankinumukbn(), C_UmuKbn.ARI, "（ＩＲ）返還金有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrRstuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）領収通貨種類");
        exClassificationEquals(khSeikyuusyoBean.getIrNkshrtkykhnkkbn(), C_NstkhKbn.NAIYOUHENKOU, "（ＩＲ）年金支払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrMeigihnkjiyuu(), C_Meigihnkjiyuu.KYK, "（ＩＲ）名義変更事由");
        exClassificationEquals(khSeikyuusyoBean.getIrNkhknumu(), C_UmuKbn.ARI, "（ＩＲ）年金保険有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSiboukyhkuktumukbn(), C_UmuKbn.ARI, "（ＩＲ）死亡給付金受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn1(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分１");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn2(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分２");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn3(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分３");
        exClassificationEquals(khSeikyuusyoBean.getIrSibousuktumukbn4(), C_UmuKbn.NONE, "（ＩＲ）死亡保険金受取人有無区分４");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu1(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無１");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu2(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無２");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu3(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無３");
        exClassificationEquals(khSeikyuusyoBean.getIrSbubnwariumu4(), C_UmuKbn.NONE, "（ＩＲ）死亡受取人分割割合有無４");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyhukaumu(), C_UmuKbn.ARI, "（ＩＲ）指定代理請求特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrStdrsktkyuuktmukbn(), C_UmuKbn.NONE, "（ＩＲ）指定代理請求特約受取人有無区分");
        exClassificationEquals(khSeikyuusyoBean.getIrStdruktkbn(), C_UktKbn.BLNK, "（ＩＲ）指定代理受取人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrJyudkaigomaebrtkykhnkkbn(),C_JyudkaigomaebaraiTkykhnkKbn.BLNK, "（ＩＲ）重度介護前払特約変更区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKeihikbn(),C_KeihiKbn.BLNK,"（ＩＲ）契被区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKihonshenkouumu(),C_UmuKbn.NONE,"（ＩＲ）基本Ｓ変更有無");
        exStringEquals(khSeikyuusyoBean.getIrKihonssyurui(), "基本保険金額", "（ＩＲ）基本Ｓ種類");
        exClassificationEquals(khSeikyuusyoBean.getIrTmttknitenkbn(), C_Tmttknitenkbn.BLNK, "（ＩＲ）積立金移転区分");
        exStringEquals(khSeikyuusyoBean.getIrTmttknitenymd(), null, "（ＩＲ）積立金移転日");
        exClassificationEquals(khSeikyuusyoBean.getIrKhhrshrjiyuu(), C_Khhrshrjiyuu.BLNK, "（ＩＲ）契約保全返戻金支払事由");
        exClassificationEquals(khSeikyuusyoBean.getIrKhskssakuseijiyuu(), C_Khskssakuseijiyuu.BLNK, "（ＩＲ）契約保全請求書作成事由");
        exBizCalcbleEquals(khSeikyuusyoBean.getIrAfterkijyunkingaku(), BizCurrency.valueOf(100000), "（ＩＲ）基準金額（変更後）");
        exClassificationEquals(khSeikyuusyoBean.getIrHrkkeiro(), C_Hrkkeiro.DANTAI, "（ＩＲ）払込経路");
        exNumericEquals(khSeikyuusyoBean.getIrSyouhnhanteikekka(), 999, "（ＩＲ）商品判定結果");
        exClassificationEquals(khSeikyuusyoBean.getIrKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "（ＩＲ）契約状態");
        exClassificationEquals(khSeikyuusyoBean.getIrZeiseitkkktkykhukaumu(), C_UmuKbn.ARI, "（ＩＲ）税制適格特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrYuuyokkntyoukaumu(), C_UmuKbn.ARI, "（ＩＲ）猶予期間超過有無");
        exClassificationEquals(khSeikyuusyoBean.getIrMousideikoukbn(), null, "（ＩＲ）申出移行区分");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn1(), "ユウケメイ　イチア", "（ＩＲ）登録家族氏名（カナ）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj1(), "未登録", "（ＩＲ）登録家族氏名（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj1(), "未登録", "（ＩＲ）登録家族住所１（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj1(), "住所２", "（ＩＲ）登録家族住所２（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj1(), "住所３", "（ＩＲ）登録家族住所３（漢字）１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno1(), "未登録", "（ＩＲ）登録家族電話番号１");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi1(), C_KahiKbn.KA, "（ＩＲ）登録家族削除可否１");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkn2(), "ユウケメイ　イチア", "（ＩＲ）登録家族氏名（カナ）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzknmkj2(), "未登録", "（ＩＲ）登録家族氏名（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr1kj2(), "未登録", "（ＩＲ）登録家族住所１（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr2kj2(), "住所２", "（ＩＲ）登録家族住所２（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzkadr3kj2(), "住所３", "（ＩＲ）登録家族住所３（漢字）２");
        exStringEquals(khSeikyuusyoBean.getIrTrkkzktelno2(), "未登録", "（ＩＲ）登録家族電話番号２");
        exClassificationEquals(khSeikyuusyoBean.getIrTrkkzksakujyokahi2(), C_KahiKbn.HUKA, "（ＩＲ）登録家族削除可否２");
        exStringEquals(khSeikyuusyoBean.getIrKyknmkn(), "契約者名（カナ）", "（ＩＲ）契約者名（カナ）");
        exStringEquals(khSeikyuusyoBean.getIrKykdairinmkj(), "未登録", "（ＩＲ）契約者代理人名（漢字）");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrtkykhukaumu(), C_UmuKbn.NONE, "（ＩＲ）契約者代理特約付加有無");
        exClassificationEquals(khSeikyuusyoBean.getIrMousideninkbn(), C_MousideninKbn.KYKHONNIN, "（ＩＲ）申出人区分");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrknhatudoujyoutai(), C_KykdrknHtdjytKbn.BLNK, "（ＩＲ）契約者代理権発動状態");
        exStringEquals(khSeikyuusyoBean.getIrDrstiskkyknmkj(), "契約者名", "（ＩＲ）代理人指定先契約者名（漢字）");
        exStringEquals(khSeikyuusyoBean.getIrTyouhyoutitle(), "ご家族登録サービス　兼　保険契約者代理特約変更請求書", "（ＩＲ）帳票タイトル");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg1(), "契約者様がご記入ください", "（ＩＲ）送付案内メッセージ１");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg2(), "ご家族登録サービスおよび保険契約者代理特約について、次のとおり変更します。", "（ＩＲ）送付案内メッセージ２");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg3(), "（詳細は２／２ページのとおり）", "（ＩＲ）送付案内メッセージ３");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg4(), "□登録　□変更　□削除", "（ＩＲ）送付案内メッセージ４");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg5(), "□　１／２ページに記載の請求者現住所に同じ", "（ＩＲ）送付案内メッセージ５");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg6(), "送付案内メッセージ６", "（ＩＲ）送付案内メッセージ６");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg7(), "送付案内メッセージ７", "（ＩＲ）送付案内メッセージ７");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg8(), "送付案内メッセージ８", "（ＩＲ）送付案内メッセージ８");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg9(), "送付案内メッセージ９", "（ＩＲ）送付案内メッセージ９");
        exStringEquals(khSeikyuusyoBean.getIrSouhuannaimsg10(), "送付案内メッセージ１０", "（ＩＲ）送付案内メッセージ１０");
        exClassificationEquals(khSeikyuusyoBean.getIrKykdrkbn(), C_UktKbn.TOUROKUKAZOKU1, "（ＩＲ）契約者代理人区分");

        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean)kSBean[1];

        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(), null, "（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(), "userId001", "（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(), "user001", "（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(), DateFormatUtil.dateKANJI(BizDate.getSysDate()), "（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(), "　消滅後 2 年", "（ＩＲ）保存期間");

        IT_KykKihon kykKihon = (IT_KykKihon)MockObjectManager.getArgument(GetKhKykdrInfoForHozen.class, "exec", 0, 0);
        exStringEquals(kykKihon.getSyono(), "12806345878", "証券番号");
        exStringEquals(kykKihon.getKbnkey(), "07", "区分キー");
    }

    @Test
    @TestOrder(410)
    public void testEditBean_A41() {

        MockObjectManager.initialize();

        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;

        AM_User aMUser = new AM_User();

        aMUser.setUserId("userId001");
        aMUser.setUserNm("user001");
        changeCurrentUser(baseUserInfo, aMUser);

        editSeikyuusyoParam.setHhknseiymd(BizDate.valueOf(20151026));
        editSeikyuusyoParam.setHhknseiymdhenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setHhknsei(C_Hhknsei.MALE);
        editSeikyuusyoParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setBfrTargettkmokuhyouti(BizNumber.valueOf(101));
        editSeikyuusyoParam.setBfrKihonS(BizCurrency.valueOf(778));
        editSeikyuusyoParam.setBfrP(BizCurrency.valueOf(1566));
        editSeikyuusyoParam.setBfrTokuyakuNenkinsyuKbn(C_Nstknsyu.KAKUTEINENKIN);
        editSeikyuusyoParam.setBfrNkshrtkyknksyukkn(5);
        editSeikyuusyoParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU);
        editSeikyuusyoParam.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editSeikyuusyoParam.setGengkhouKbn(C_GengkhouKbn.SD);
        editSeikyuusyoParam.setHenkankumukbn(C_UmuKbn.ARI);
        editSeikyuusyoParam.setRstuukasyu(C_Tuukasyu.JPY);
        editSeikyuusyoParam.setNkshrtkykhnkkbn(C_NstkhKbn.NAIYOUHENKOU);
        editSeikyuusyoParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);
        editSeikyuusyoParam.setJyudkaigomaebaraiTkykhnkKbn(C_JyudkaigomaebaraiTkykhnkKbn.BLNK);
        editSeikyuusyoParam.setKihonshenkouumu(C_UmuKbn.NONE);
        editSeikyuusyoParam.setTmttknitenkbn(C_Tmttknitenkbn.BLNK);
        editSeikyuusyoParam.setTmttknitenymd(null);
        editSeikyuusyoParam.setKhhrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSeikyuusyoParam.setKhskssakuseijiyuu(C_Khskssakuseijiyuu.BLNK);
        editSeikyuusyoParam.setHenkougokjnkngk(BizCurrency.valueOf(100000));

        ReportServicesBean reSsBean =  editSeikyuusyoTbl.editBean(C_SyoruiCdKbn.KK_SEINENGAPPISEI_SKS, syono14, khozenCommonParam, editSeikyuusyoParam);

        Object[] kSBean = reSsBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_SEINENGAPPISEI_SKS.getValue());

        KhSeikyuusyoBean khSeikyuusyoBean = (KhSeikyuusyoBean)kSBean[0];

        exClassificationEquals(khSeikyuusyoBean.getIrSaikensetumu(), C_UmuKbn.ARI, "（ＩＲ）債権設定有無");
    }

    @Test
    @TestOrder(420)
    public void testEditBean_A42() {

        MockObjectManager.initialize();

        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;

        AM_User aMUser = new AM_User();

        aMUser.setUserId("userId001");
        aMUser.setUserNm("user001");
        changeCurrentUser(baseUserInfo, aMUser);

        editSeikyuusyoParam.setHhknseiymd(BizDate.valueOf(20151026));
        editSeikyuusyoParam.setHhknseiymdhenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setHhknsei(C_Hhknsei.MALE);
        editSeikyuusyoParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setBfrTargettkmokuhyouti(BizNumber.valueOf(101));
        editSeikyuusyoParam.setBfrKihonS(BizCurrency.valueOf(778));
        editSeikyuusyoParam.setBfrP(BizCurrency.valueOf(1566));
        editSeikyuusyoParam.setBfrTokuyakuNenkinsyuKbn(C_Nstknsyu.KAKUTEINENKIN);
        editSeikyuusyoParam.setBfrNkshrtkyknksyukkn(5);
        editSeikyuusyoParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU);
        editSeikyuusyoParam.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editSeikyuusyoParam.setGengkhouKbn(C_GengkhouKbn.SD);
        editSeikyuusyoParam.setHenkankumukbn(C_UmuKbn.ARI);
        editSeikyuusyoParam.setRstuukasyu(C_Tuukasyu.JPY);
        editSeikyuusyoParam.setNkshrtkykhnkkbn(C_NstkhKbn.NAIYOUHENKOU);
        editSeikyuusyoParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);
        editSeikyuusyoParam.setJyudkaigomaebaraiTkykhnkKbn(C_JyudkaigomaebaraiTkykhnkKbn.BLNK);
        editSeikyuusyoParam.setKihonshenkouumu(C_UmuKbn.NONE);
        editSeikyuusyoParam.setTmttknitenkbn(C_Tmttknitenkbn.BLNK);
        editSeikyuusyoParam.setTmttknitenymd(null);
        editSeikyuusyoParam.setKhhrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSeikyuusyoParam.setKhskssakuseijiyuu(C_Khskssakuseijiyuu.BLNK);
        editSeikyuusyoParam.setHenkougokjnkngk(BizCurrency.valueOf(100000));

        ReportServicesBean reSsBean =  editSeikyuusyoTbl.editBean(C_SyoruiCdKbn.KK_KAIYAKU_SKS, syono15, khozenCommonParam, editSeikyuusyoParam);

        Object[] kSBean = reSsBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_KAIYAKU_SKS.getValue());

        KhSeikyuusyoBean khSeikyuusyoBean = (KhSeikyuusyoBean)kSBean[0];

        exClassificationEquals(khSeikyuusyoBean.getIrSaikensetumu(), C_UmuKbn.ARI, "（ＩＲ）債権設定有無");

    }

    @Test
    @TestOrder(430)
    public void testEditBean_A43() {

        MockObjectManager.initialize();

        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;

        AM_User aMUser = new AM_User();

        aMUser.setUserId("userId001");
        aMUser.setUserNm("user001");
        changeCurrentUser(baseUserInfo, aMUser);

        editSeikyuusyoParam.setHhknseiymd(BizDate.valueOf(20151026));
        editSeikyuusyoParam.setHhknseiymdhenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setHhknsei(C_Hhknsei.MALE);
        editSeikyuusyoParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setBfrTargettkmokuhyouti(BizNumber.valueOf(101));
        editSeikyuusyoParam.setBfrKihonS(BizCurrency.valueOf(778));
        editSeikyuusyoParam.setBfrP(BizCurrency.valueOf(1566));
        editSeikyuusyoParam.setBfrTokuyakuNenkinsyuKbn(C_Nstknsyu.KAKUTEINENKIN);
        editSeikyuusyoParam.setBfrNkshrtkyknksyukkn(5);
        editSeikyuusyoParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU);
        editSeikyuusyoParam.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editSeikyuusyoParam.setGengkhouKbn(C_GengkhouKbn.SD);
        editSeikyuusyoParam.setHenkankumukbn(C_UmuKbn.ARI);
        editSeikyuusyoParam.setRstuukasyu(C_Tuukasyu.JPY);
        editSeikyuusyoParam.setNkshrtkykhnkkbn(C_NstkhKbn.NAIYOUHENKOU);
        editSeikyuusyoParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);
        editSeikyuusyoParam.setJyudkaigomaebaraiTkykhnkKbn(C_JyudkaigomaebaraiTkykhnkKbn.BLNK);
        editSeikyuusyoParam.setKihonshenkouumu(C_UmuKbn.NONE);
        editSeikyuusyoParam.setTmttknitenkbn(C_Tmttknitenkbn.BLNK);
        editSeikyuusyoParam.setTmttknitenymd(null);
        editSeikyuusyoParam.setKhhrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSeikyuusyoParam.setKhskssakuseijiyuu(C_Khskssakuseijiyuu.BLNK);
        editSeikyuusyoParam.setHenkougokjnkngk(BizCurrency.valueOf(100000));

        ReportServicesBean reSsBean =  editSeikyuusyoTbl.editBean(C_SyoruiCdKbn.KK_KAIYAKU_SKS, syono16, khozenCommonParam, editSeikyuusyoParam);

        Object[] kSBean = reSsBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_KAIYAKU_SKS.getValue());

        KhSeikyuusyoBean khSeikyuusyoBean = (KhSeikyuusyoBean)kSBean[0];

        exClassificationEquals(khSeikyuusyoBean.getIrSaikensetumu(), C_UmuKbn.ARI, "（ＩＲ）債権設定有無");

    }

    @Test
    @TestOrder(440)
    public void testEditBean_A44() {

        MockObjectManager.initialize();

        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;

        AM_User aMUser = new AM_User();

        aMUser.setUserId("userId001");
        aMUser.setUserNm("user001");
        changeCurrentUser(baseUserInfo, aMUser);

        editSeikyuusyoParam.setHhknseiymd(BizDate.valueOf(20151026));
        editSeikyuusyoParam.setHhknseiymdhenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setHhknsei(C_Hhknsei.MALE);
        editSeikyuusyoParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setBfrTargettkmokuhyouti(BizNumber.valueOf(101));
        editSeikyuusyoParam.setBfrKihonS(BizCurrency.valueOf(778));
        editSeikyuusyoParam.setBfrP(BizCurrency.valueOf(1566));
        editSeikyuusyoParam.setBfrTokuyakuNenkinsyuKbn(C_Nstknsyu.KAKUTEINENKIN);
        editSeikyuusyoParam.setBfrNkshrtkyknksyukkn(5);
        editSeikyuusyoParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU);
        editSeikyuusyoParam.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editSeikyuusyoParam.setGengkhouKbn(C_GengkhouKbn.SD);
        editSeikyuusyoParam.setHenkankumukbn(C_UmuKbn.ARI);
        editSeikyuusyoParam.setRstuukasyu(C_Tuukasyu.JPY);
        editSeikyuusyoParam.setNkshrtkykhnkkbn(C_NstkhKbn.NAIYOUHENKOU);
        editSeikyuusyoParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);
        editSeikyuusyoParam.setJyudkaigomaebaraiTkykhnkKbn(C_JyudkaigomaebaraiTkykhnkKbn.BLNK);
        editSeikyuusyoParam.setKihonshenkouumu(C_UmuKbn.NONE);
        editSeikyuusyoParam.setTmttknitenkbn(C_Tmttknitenkbn.BLNK);
        editSeikyuusyoParam.setTmttknitenymd(null);
        editSeikyuusyoParam.setKhhrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSeikyuusyoParam.setKhskssakuseijiyuu(C_Khskssakuseijiyuu.BLNK);
        editSeikyuusyoParam.setHenkougokjnkngk(BizCurrency.valueOf(100000));

        ReportServicesBean reSsBean =  editSeikyuusyoTbl.editBean(C_SyoruiCdKbn.KK_KAIYAKU_SKS, syono17, khozenCommonParam, editSeikyuusyoParam);

        Object[] kSBean = reSsBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_KAIYAKU_SKS.getValue());

        KhSeikyuusyoBean khSeikyuusyoBean = (KhSeikyuusyoBean)kSBean[0];

        exClassificationEquals(khSeikyuusyoBean.getIrSaikensetumu(), C_UmuKbn.ARI, "（ＩＲ）債権設定有無");

    }

    @Test
    @TestOrder(450)
    public void testEditBean_A45() {

        MockObjectManager.initialize();

        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;

        AM_User aMUser = new AM_User();

        aMUser.setUserId("userId001");
        aMUser.setUserNm("user001");
        changeCurrentUser(baseUserInfo, aMUser);

        editSeikyuusyoParam.setHhknseiymd(BizDate.valueOf(20151026));
        editSeikyuusyoParam.setHhknseiymdhenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setHhknsei(C_Hhknsei.MALE);
        editSeikyuusyoParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setBfrTargettkmokuhyouti(BizNumber.valueOf(101));
        editSeikyuusyoParam.setBfrKihonS(BizCurrency.valueOf(778));
        editSeikyuusyoParam.setBfrP(BizCurrency.valueOf(1566));
        editSeikyuusyoParam.setBfrTokuyakuNenkinsyuKbn(C_Nstknsyu.KAKUTEINENKIN);
        editSeikyuusyoParam.setBfrNkshrtkyknksyukkn(5);
        editSeikyuusyoParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU);
        editSeikyuusyoParam.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editSeikyuusyoParam.setGengkhouKbn(C_GengkhouKbn.SD);
        editSeikyuusyoParam.setHenkankumukbn(C_UmuKbn.ARI);
        editSeikyuusyoParam.setRstuukasyu(C_Tuukasyu.JPY);
        editSeikyuusyoParam.setNkshrtkykhnkkbn(C_NstkhKbn.NAIYOUHENKOU);
        editSeikyuusyoParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);
        editSeikyuusyoParam.setJyudkaigomaebaraiTkykhnkKbn(C_JyudkaigomaebaraiTkykhnkKbn.BLNK);
        editSeikyuusyoParam.setKihonshenkouumu(C_UmuKbn.NONE);
        editSeikyuusyoParam.setTmttknitenkbn(C_Tmttknitenkbn.BLNK);
        editSeikyuusyoParam.setTmttknitenymd(null);
        editSeikyuusyoParam.setKhhrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSeikyuusyoParam.setKhskssakuseijiyuu(C_Khskssakuseijiyuu.BLNK);
        editSeikyuusyoParam.setHenkougokjnkngk(BizCurrency.valueOf(100000));

        ReportServicesBean reSsBean =  editSeikyuusyoTbl.editBean(C_SyoruiCdKbn.KK_KAIYAKU_SKS, syono18, khozenCommonParam, editSeikyuusyoParam);

        Object[] kSBean = reSsBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_KAIYAKU_SKS.getValue());

        KhSeikyuusyoBean khSeikyuusyoBean = (KhSeikyuusyoBean)kSBean[0];

        exClassificationEquals(khSeikyuusyoBean.getIrSaikensetumu(), C_UmuKbn.ARI, "（ＩＲ）債権設定有無");

    }

    @Test
    @TestOrder(460)
    public void testEditBean_A46() {

        MockObjectManager.initialize();

        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;

        AM_User aMUser = new AM_User();

        aMUser.setUserId("userId001");
        aMUser.setUserNm("user001");
        changeCurrentUser(baseUserInfo, aMUser);

        editSeikyuusyoParam.setHhknseiymd(BizDate.valueOf(20151026));
        editSeikyuusyoParam.setHhknseiymdhenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setHhknsei(C_Hhknsei.MALE);
        editSeikyuusyoParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setBfrTargettkmokuhyouti(BizNumber.valueOf(101));
        editSeikyuusyoParam.setBfrKihonS(BizCurrency.valueOf(778));
        editSeikyuusyoParam.setBfrP(BizCurrency.valueOf(1566));
        editSeikyuusyoParam.setBfrTokuyakuNenkinsyuKbn(C_Nstknsyu.KAKUTEINENKIN);
        editSeikyuusyoParam.setBfrNkshrtkyknksyukkn(5);
        editSeikyuusyoParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU);
        editSeikyuusyoParam.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editSeikyuusyoParam.setGengkhouKbn(C_GengkhouKbn.SD);
        editSeikyuusyoParam.setHenkankumukbn(C_UmuKbn.ARI);
        editSeikyuusyoParam.setRstuukasyu(C_Tuukasyu.JPY);
        editSeikyuusyoParam.setNkshrtkykhnkkbn(C_NstkhKbn.NAIYOUHENKOU);
        editSeikyuusyoParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);
        editSeikyuusyoParam.setJyudkaigomaebaraiTkykhnkKbn(C_JyudkaigomaebaraiTkykhnkKbn.BLNK);
        editSeikyuusyoParam.setKihonshenkouumu(C_UmuKbn.NONE);
        editSeikyuusyoParam.setTmttknitenkbn(C_Tmttknitenkbn.BLNK);
        editSeikyuusyoParam.setTmttknitenymd(null);
        editSeikyuusyoParam.setKhhrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSeikyuusyoParam.setKhskssakuseijiyuu(C_Khskssakuseijiyuu.BLNK);
        editSeikyuusyoParam.setHenkougokjnkngk(BizCurrency.valueOf(100000));

        ReportServicesBean reSsBean =  editSeikyuusyoTbl.editBean(C_SyoruiCdKbn.KK_KAIYAKU_SKS, syono19, khozenCommonParam, editSeikyuusyoParam);

        Object[] kSBean = reSsBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_KAIYAKU_SKS.getValue());

        KhSeikyuusyoBean khSeikyuusyoBean = (KhSeikyuusyoBean)kSBean[0];

        exClassificationEquals(khSeikyuusyoBean.getIrSaikensetumu(), C_UmuKbn.ARI, "（ＩＲ）債権設定有無");

    }

    @Test
    @TestOrder(470)
    public void testEditBean_A47() {

        MockObjectManager.initialize();

        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;

        AM_User aMUser = new AM_User();

        aMUser.setUserId("userId001");
        aMUser.setUserNm("user001");
        changeCurrentUser(baseUserInfo, aMUser);

        editSeikyuusyoParam.setHhknseiymd(BizDate.valueOf(20151026));
        editSeikyuusyoParam.setHhknseiymdhenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setHhknsei(C_Hhknsei.MALE);
        editSeikyuusyoParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setBfrTargettkmokuhyouti(BizNumber.valueOf(101));
        editSeikyuusyoParam.setBfrKihonS(BizCurrency.valueOf(778));
        editSeikyuusyoParam.setBfrP(BizCurrency.valueOf(1566));
        editSeikyuusyoParam.setBfrTokuyakuNenkinsyuKbn(C_Nstknsyu.KAKUTEINENKIN);
        editSeikyuusyoParam.setBfrNkshrtkyknksyukkn(5);
        editSeikyuusyoParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU);
        editSeikyuusyoParam.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editSeikyuusyoParam.setGengkhouKbn(C_GengkhouKbn.SD);
        editSeikyuusyoParam.setHenkankumukbn(C_UmuKbn.ARI);
        editSeikyuusyoParam.setRstuukasyu(C_Tuukasyu.JPY);
        editSeikyuusyoParam.setNkshrtkykhnkkbn(C_NstkhKbn.NAIYOUHENKOU);
        editSeikyuusyoParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);
        editSeikyuusyoParam.setJyudkaigomaebaraiTkykhnkKbn(C_JyudkaigomaebaraiTkykhnkKbn.BLNK);
        editSeikyuusyoParam.setKihonshenkouumu(C_UmuKbn.NONE);
        editSeikyuusyoParam.setTmttknitenkbn(C_Tmttknitenkbn.BLNK);
        editSeikyuusyoParam.setTmttknitenymd(null);
        editSeikyuusyoParam.setKhhrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSeikyuusyoParam.setKhskssakuseijiyuu(C_Khskssakuseijiyuu.BLNK);
        editSeikyuusyoParam.setHenkougokjnkngk(BizCurrency.valueOf(100000));

        ReportServicesBean reSsBean =  editSeikyuusyoTbl.editBean(C_SyoruiCdKbn.KK_KAIYAKU_SKS, syono20, khozenCommonParam, editSeikyuusyoParam);

        Object[] kSBean = reSsBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_KAIYAKU_SKS.getValue());

        KhSeikyuusyoBean khSeikyuusyoBean = (KhSeikyuusyoBean)kSBean[0];

        exClassificationEquals(khSeikyuusyoBean.getIrSaikensetumu(), C_UmuKbn.ARI, "（ＩＲ）債権設定有無");

    }

    @Test
    @TestOrder(480)
    public void testEditBean_A48() {

        MockObjectManager.initialize();

        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;

        AM_User aMUser = new AM_User();

        aMUser.setUserId("userId001");
        aMUser.setUserNm("user001");
        changeCurrentUser(baseUserInfo, aMUser);

        editSeikyuusyoParam.setHhknseiymd(BizDate.valueOf(20151026));
        editSeikyuusyoParam.setHhknseiymdhenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setHhknsei(C_Hhknsei.MALE);
        editSeikyuusyoParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setBfrTargettkmokuhyouti(BizNumber.valueOf(101));
        editSeikyuusyoParam.setBfrKihonS(BizCurrency.valueOf(778));
        editSeikyuusyoParam.setBfrP(BizCurrency.valueOf(1566));
        editSeikyuusyoParam.setBfrTokuyakuNenkinsyuKbn(C_Nstknsyu.KAKUTEINENKIN);
        editSeikyuusyoParam.setBfrNkshrtkyknksyukkn(5);
        editSeikyuusyoParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU);
        editSeikyuusyoParam.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editSeikyuusyoParam.setGengkhouKbn(C_GengkhouKbn.SD);
        editSeikyuusyoParam.setHenkankumukbn(C_UmuKbn.ARI);
        editSeikyuusyoParam.setRstuukasyu(C_Tuukasyu.JPY);
        editSeikyuusyoParam.setNkshrtkykhnkkbn(C_NstkhKbn.NAIYOUHENKOU);
        editSeikyuusyoParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);
        editSeikyuusyoParam.setJyudkaigomaebaraiTkykhnkKbn(C_JyudkaigomaebaraiTkykhnkKbn.BLNK);
        editSeikyuusyoParam.setKihonshenkouumu(C_UmuKbn.NONE);
        editSeikyuusyoParam.setTmttknitenkbn(C_Tmttknitenkbn.BLNK);
        editSeikyuusyoParam.setTmttknitenymd(null);
        editSeikyuusyoParam.setKhhrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSeikyuusyoParam.setKhskssakuseijiyuu(C_Khskssakuseijiyuu.BLNK);
        editSeikyuusyoParam.setHenkougokjnkngk(BizCurrency.valueOf(100000));

        ReportServicesBean reSsBean =  editSeikyuusyoTbl.editBean(C_SyoruiCdKbn.KK_KAIYAKU_SKS, syono21, khozenCommonParam, editSeikyuusyoParam);

        Object[] kSBean = reSsBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_KAIYAKU_SKS.getValue());

        KhSeikyuusyoBean khSeikyuusyoBean = (KhSeikyuusyoBean)kSBean[0];

        exClassificationEquals(khSeikyuusyoBean.getIrSaikensetumu(), C_UmuKbn.ARI, "（ＩＲ）債権設定有無");

    }

    @Test
    @TestOrder(490)
    public void testEditBean_A49() {

        MockObjectManager.initialize();

        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;

        AM_User aMUser = new AM_User();

        aMUser.setUserId("userId001");
        aMUser.setUserNm("user001");
        changeCurrentUser(baseUserInfo, aMUser);

        editSeikyuusyoParam.setHhknseiymd(BizDate.valueOf(20151026));
        editSeikyuusyoParam.setHhknseiymdhenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setHhknsei(C_Hhknsei.MALE);
        editSeikyuusyoParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setBfrTargettkmokuhyouti(BizNumber.valueOf(101));
        editSeikyuusyoParam.setBfrKihonS(BizCurrency.valueOf(778));
        editSeikyuusyoParam.setBfrP(BizCurrency.valueOf(1566));
        editSeikyuusyoParam.setBfrTokuyakuNenkinsyuKbn(C_Nstknsyu.KAKUTEINENKIN);
        editSeikyuusyoParam.setBfrNkshrtkyknksyukkn(5);
        editSeikyuusyoParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU);
        editSeikyuusyoParam.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editSeikyuusyoParam.setGengkhouKbn(C_GengkhouKbn.SD);
        editSeikyuusyoParam.setHenkankumukbn(C_UmuKbn.ARI);
        editSeikyuusyoParam.setRstuukasyu(C_Tuukasyu.JPY);
        editSeikyuusyoParam.setNkshrtkykhnkkbn(C_NstkhKbn.NAIYOUHENKOU);
        editSeikyuusyoParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);
        editSeikyuusyoParam.setJyudkaigomaebaraiTkykhnkKbn(C_JyudkaigomaebaraiTkykhnkKbn.BLNK);
        editSeikyuusyoParam.setKihonshenkouumu(C_UmuKbn.NONE);
        editSeikyuusyoParam.setTmttknitenkbn(C_Tmttknitenkbn.BLNK);
        editSeikyuusyoParam.setTmttknitenymd(null);
        editSeikyuusyoParam.setKhhrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSeikyuusyoParam.setKhskssakuseijiyuu(C_Khskssakuseijiyuu.BLNK);
        editSeikyuusyoParam.setHenkougokjnkngk(BizCurrency.valueOf(100000));

        ReportServicesBean reSsBean =  editSeikyuusyoTbl.editBean(C_SyoruiCdKbn.KK_KAIYAKU_SKS, syono22, khozenCommonParam, editSeikyuusyoParam);

        Object[] kSBean = reSsBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_KAIYAKU_SKS.getValue());

        KhSeikyuusyoBean khSeikyuusyoBean = (KhSeikyuusyoBean)kSBean[0];

        exClassificationEquals(khSeikyuusyoBean.getIrSaikensetumu(), C_UmuKbn.ARI, "（ＩＲ）債権設定有無");

    }

    @Test
    @TestOrder(500)
    public void testEditBean_A50() {

        MockObjectManager.initialize();

        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;

        AM_User aMUser = new AM_User();

        aMUser.setUserId("userId001");
        aMUser.setUserNm("user001");
        changeCurrentUser(baseUserInfo, aMUser);

        editSeikyuusyoParam.setHhknseiymd(BizDate.valueOf(20151026));
        editSeikyuusyoParam.setHhknseiymdhenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setHhknsei(C_Hhknsei.MALE);
        editSeikyuusyoParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setBfrTargettkmokuhyouti(BizNumber.valueOf(101));
        editSeikyuusyoParam.setBfrKihonS(BizCurrency.valueOf(778));
        editSeikyuusyoParam.setBfrP(BizCurrency.valueOf(1566));
        editSeikyuusyoParam.setBfrTokuyakuNenkinsyuKbn(C_Nstknsyu.KAKUTEINENKIN);
        editSeikyuusyoParam.setBfrNkshrtkyknksyukkn(5);
        editSeikyuusyoParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU);
        editSeikyuusyoParam.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editSeikyuusyoParam.setGengkhouKbn(C_GengkhouKbn.SD);
        editSeikyuusyoParam.setHenkankumukbn(C_UmuKbn.ARI);
        editSeikyuusyoParam.setRstuukasyu(C_Tuukasyu.JPY);
        editSeikyuusyoParam.setNkshrtkykhnkkbn(C_NstkhKbn.NAIYOUHENKOU);
        editSeikyuusyoParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);
        editSeikyuusyoParam.setJyudkaigomaebaraiTkykhnkKbn(C_JyudkaigomaebaraiTkykhnkKbn.BLNK);
        editSeikyuusyoParam.setKihonshenkouumu(C_UmuKbn.NONE);
        editSeikyuusyoParam.setTmttknitenkbn(C_Tmttknitenkbn.BLNK);
        editSeikyuusyoParam.setTmttknitenymd(null);
        editSeikyuusyoParam.setKhhrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSeikyuusyoParam.setKhskssakuseijiyuu(C_Khskssakuseijiyuu.BLNK);
        editSeikyuusyoParam.setHenkougokjnkngk(BizCurrency.valueOf(100000));

        ReportServicesBean reSsBean =  editSeikyuusyoTbl.editBean(C_SyoruiCdKbn.KK_KAIYAKU_SKS, syono23, khozenCommonParam, editSeikyuusyoParam);

        Object[] kSBean = reSsBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_KAIYAKU_SKS.getValue());

        KhSeikyuusyoBean khSeikyuusyoBean = (KhSeikyuusyoBean)kSBean[0];

        exClassificationEquals(khSeikyuusyoBean.getIrSaikensetumu(), C_UmuKbn.ARI, "（ＩＲ）債権設定有無");

    }

    @Test
    @TestOrder(510)
    public void testEditBean_A51() {

        MockObjectManager.initialize();

        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;

        AM_User aMUser = new AM_User();

        aMUser.setUserId("userId001");
        aMUser.setUserNm("user001");
        changeCurrentUser(baseUserInfo, aMUser);

        editSeikyuusyoParam.setHhknseiymd(BizDate.valueOf(20151026));
        editSeikyuusyoParam.setHhknseiymdhenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setHhknsei(C_Hhknsei.MALE);
        editSeikyuusyoParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setBfrTargettkmokuhyouti(BizNumber.valueOf(101));
        editSeikyuusyoParam.setBfrKihonS(BizCurrency.valueOf(778));
        editSeikyuusyoParam.setBfrP(BizCurrency.valueOf(1566));
        editSeikyuusyoParam.setBfrTokuyakuNenkinsyuKbn(C_Nstknsyu.KAKUTEINENKIN);
        editSeikyuusyoParam.setBfrNkshrtkyknksyukkn(5);
        editSeikyuusyoParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU);
        editSeikyuusyoParam.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editSeikyuusyoParam.setGengkhouKbn(C_GengkhouKbn.SD);
        editSeikyuusyoParam.setHenkankumukbn(C_UmuKbn.ARI);
        editSeikyuusyoParam.setRstuukasyu(C_Tuukasyu.JPY);
        editSeikyuusyoParam.setNkshrtkykhnkkbn(C_NstkhKbn.NAIYOUHENKOU);
        editSeikyuusyoParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);
        editSeikyuusyoParam.setJyudkaigomaebaraiTkykhnkKbn(C_JyudkaigomaebaraiTkykhnkKbn.BLNK);
        editSeikyuusyoParam.setKihonshenkouumu(C_UmuKbn.NONE);
        editSeikyuusyoParam.setTmttknitenkbn(C_Tmttknitenkbn.BLNK);
        editSeikyuusyoParam.setTmttknitenymd(null);
        editSeikyuusyoParam.setKhhrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSeikyuusyoParam.setKhskssakuseijiyuu(C_Khskssakuseijiyuu.BLNK);
        editSeikyuusyoParam.setHenkougokjnkngk(BizCurrency.valueOf(100000));

        ReportServicesBean reSsBean =  editSeikyuusyoTbl.editBean(C_SyoruiCdKbn.KK_KAIYAKU_SKS, syono24, khozenCommonParam, editSeikyuusyoParam);

        Object[] kSBean = reSsBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_KAIYAKU_SKS.getValue());

        KhSeikyuusyoBean khSeikyuusyoBean = (KhSeikyuusyoBean)kSBean[0];

        exClassificationEquals(khSeikyuusyoBean.getIrSaikensetumu(), C_UmuKbn.NONE, "（ＩＲ）債権設定有無");

    }

    @Test
    @TestOrder(520)
    public void testEditBean_A52() {

        MockObjectManager.initialize();

        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;

        AM_User aMUser = new AM_User();

        aMUser.setUserId("userId001");
        aMUser.setUserNm("user001");
        changeCurrentUser(baseUserInfo, aMUser);

        editSeikyuusyoParam.setHhknseiymd(BizDate.valueOf(20151026));
        editSeikyuusyoParam.setHhknseiymdhenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setHhknsei(C_Hhknsei.MALE);
        editSeikyuusyoParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        editSeikyuusyoParam.setBfrTargettkmokuhyouti(BizNumber.valueOf(101));
        editSeikyuusyoParam.setBfrKihonS(BizCurrency.valueOf(778));
        editSeikyuusyoParam.setBfrP(BizCurrency.valueOf(1566));
        editSeikyuusyoParam.setBfrTokuyakuNenkinsyuKbn(C_Nstknsyu.KAKUTEINENKIN);
        editSeikyuusyoParam.setBfrNkshrtkyknksyukkn(5);
        editSeikyuusyoParam.setTargetTkHenkouKbn(C_TargetTkHenkouKbn.MOKUHYOCHIHENKOU);
        editSeikyuusyoParam.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editSeikyuusyoParam.setGengkhouKbn(C_GengkhouKbn.SD);
        editSeikyuusyoParam.setHenkankumukbn(C_UmuKbn.ARI);
        editSeikyuusyoParam.setRstuukasyu(C_Tuukasyu.JPY);
        editSeikyuusyoParam.setNkshrtkykhnkkbn(C_NstkhKbn.NAIYOUHENKOU);
        editSeikyuusyoParam.setMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);
        editSeikyuusyoParam.setJyudkaigomaebaraiTkykhnkKbn(C_JyudkaigomaebaraiTkykhnkKbn.BLNK);
        editSeikyuusyoParam.setKihonshenkouumu(C_UmuKbn.NONE);
        editSeikyuusyoParam.setTmttknitenkbn(C_Tmttknitenkbn.BLNK);
        editSeikyuusyoParam.setTmttknitenymd(null);
        editSeikyuusyoParam.setKhhrshrjiyuu(C_Khhrshrjiyuu.BLNK);
        editSeikyuusyoParam.setKhskssakuseijiyuu(C_Khskssakuseijiyuu.BLNK);
        editSeikyuusyoParam.setHenkougokjnkngk(BizCurrency.valueOf(100000));

        ReportServicesBean reSsBean =  editSeikyuusyoTbl.editBean(C_SyoruiCdKbn.KK_KAIYAKU_SKS, syono25, khozenCommonParam, editSeikyuusyoParam);

        Object[] kSBean = reSsBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_KAIYAKU_SKS.getValue());

        KhSeikyuusyoBean khSeikyuusyoBean = (KhSeikyuusyoBean)kSBean[0];

        exClassificationEquals(khSeikyuusyoBean.getIrSaikensetumu(), C_UmuKbn.NONE, "（ＩＲ）債権設定有無");

    }
}
