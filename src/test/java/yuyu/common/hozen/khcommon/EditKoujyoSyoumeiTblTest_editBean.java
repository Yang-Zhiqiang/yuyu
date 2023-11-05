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

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.biz.bean.report.BzKokyakuAtesakiBean;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.IT_KoujyoSym;
import yuyu.def.hozen.bean.report.KhKoujyosyoumeisyoBean;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 控除証明書TBL編集クラスのメソッド {@link EditKoujyoSyoumeiTbl#editBean(KhozenCommonParam,IT_KoujyoSym,BizDate)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditKoujyoSyoumeiTblTest_editBean {

    @Inject
    private EditKoujyoSyoumeiTbl editKoujyoSyoumeiTbl;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private KhozenCommonParam khozenCommonParam;

    private final static String syoNo1 = "20806000019";

    private final static String syoNo2 = "20806000020";

    private final static String syoNo3 = "20806000031";

    private final static String syoNo4 = "20806000042";

    private final static String syoNo5 = "20806000053";

    private final static String syoNo6 = "20806000064";

    private final static String syoNo7 = "20806000075";

    private final static String syoNo8 = "20806000086";

    private final static String syoNo9 = "20806000097";

    private final static String syoNo10 = "20806000101";

    private final static String fileName = "UT_SP_単体テスト仕様書_控除証明書TBL編集";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData(){

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(KeisanIkkatuWaribikiPTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);

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
    public void testEditBean_A1() {

        IT_KoujyoSym koujyoSym = null;
        BizDate syoriYMD = BizDate.valueOf(20160418);

        ReportServicesBean reportServicesBean = editKoujyoSyoumeiTbl.editBean(khozenCommonParam, koujyoSym, syoriYMD);

        Assert.assertNull(null, reportServicesBean);
    }


    @Test
    @TestOrder(20)
    public void testEditBean_A2() {

        IT_KoujyoSym koujyoSym = hozenDomManager.getKykKihon(syoNo1).getKoujyoSyms().get(0);
        BizDate syoriYMD = BizDate.valueOf(20160418);

        ReportServicesBean reportServicesBean = editKoujyoSyoumeiTbl.editBean(khozenCommonParam, koujyoSym, syoriYMD);

        Object[] kHSBean = reportServicesBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_KOUJYOSYOUMEIS.getValue());

        exNumericEquals(kHSBean.length, 2, "パラメータオブジェクトの要素数");

        KhKoujyosyoumeisyoBean khKoujyosyoumeisyoBean = (KhKoujyosyoumeisyoBean)kHSBean[0];

        exStringEquals(khKoujyosyoumeisyoBean.getIrKyknmkj(), "契約者名", "（ＩＲ）契約者名（漢字）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrSyoumeinnd(), "2016年", "（ＩＲ）証明年度");
        exStringEquals(khKoujyosyoumeisyoBean.getIrUktnm(), "受取人名", "（ＩＲ）受取人氏名");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNenkinuktseiymd(), "＊＊＊＊＊＊＊＊＊＊＊", "（ＩＲ）年金受取人生年月日");
        exStringEquals(khKoujyosyoumeisyoBean.getIrSyono(), syoNo1, "（ＩＲ）証券番号");
        exStringEquals(khKoujyosyoumeisyoBean.getIrHknsyuruikoujyosyoumei(), "保険略称", "（ＩＲ）保険種類（控除証明書）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNkshrkknkoujyosyoumei(), "＊＊＊", "（ＩＲ）年金支払期間（控除証明書）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrKeiyakuymd(), "2016年 4月 2日", "（ＩＲ）契約年月日");
        exStringEquals(khKoujyosyoumeisyoBean.getIrHaitoukinuketorihoukbn(), "積立", "（ＩＲ）配当金受取方法区分");
        exStringEquals(khKoujyosyoumeisyoBean.getIrHknkkn(), "終身", "（ＩＲ）保険期間");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNkshrstartymd(), "＊＊＊＊＊＊＊＊＊＊＊", "（ＩＲ）年金支払開始日");
        exStringEquals(khKoujyosyoumeisyoBean.getIrPhrkkkn(), "**", "（ＩＲ）保険料払込期間");
        exStringEquals(khKoujyosyoumeisyoBean.getIrHrkhou(), "月払", "（ＩＲ）払込方法");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewippanseimeip(), "111", "（ＩＲ）一般生命保険料（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewippanhaitoukin(), "222", "（ＩＲ）一般配当金（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewippansyoumeigk(), "*******333", "（ＩＲ）一般証明額（新制度）");

        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnenkanippanseimeip(), "444", "（ＩＲ）年間一般生命保険料（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnenkanippanhaitoukin(), "555", "（ＩＲ）年間一般配当金（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewippansinkokugk(), "*******666", "（ＩＲ）一般申告額（新制度）");

        exStringEquals(khKoujyosyoumeisyoBean.getIrNewiryouseimeip(), "112", "（ＩＲ）介護医療保険料（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewiryouhaitoukin(), "223", "（ＩＲ）介護医療配当金（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewiryousyoumeigk(), "*******334", "（ＩＲ）介護医療証明額（新制度）");

        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnenkaniryouseimeip(), "445", "（ＩＲ）年間介護医療保険料（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnenkaniryouhaitoukin(), "556", "（ＩＲ）年間介護医療配当金（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewiryousinkokugk(), "*******667", "（ＩＲ）介護医療申告額（新制度）");

        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnkseimeip(), "777", "（ＩＲ）個人年金保険料（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnkhaitoukin(), "888", "（ＩＲ）年金配当金（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnksyoumeigk(), "*******999", "（ＩＲ）個人年金証明額（新制度）");

        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnenkannkseimeip(), "778", "（ＩＲ）年間個人年金保険料（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnenkannkhaitoukin(), "889", "（ＩＲ）年間年金配当金（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnksinkokugk(), "*******997", "（ＩＲ）個人年金申告額（新制度）");

        exStringEquals(khKoujyosyoumeisyoBean.getIrNewhknjytuKikan(), "終身", "（ＩＲ）保険充当期間（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrPhrkkknjyoutai(), "払込停止", "（ＩＲ）保険料払込状態");
        exStringEquals(khKoujyosyoumeisyoBean.getIrSyoumeiymd(), "2016年 4月 3日", "（ＩＲ）証明日");
        exStringEquals(khKoujyosyoumeisyoBean.getIrUktmidasi(), "保険金", "（ＩＲ）受取人見出し");
        exStringEquals(khKoujyosyoumeisyoBean.getIrMidasisub(), "", "（ＩＲ）見出し副題");
        exStringEquals(khKoujyosyoumeisyoBean.getIrKoujyosyoumeifreearea1(), "", "（ＩＲ）控除証明フリーエリア１");


        BzKokyakuAtesakiBean kokyakuAtesakiBean = (BzKokyakuAtesakiBean)kHSBean[1];

        exStringEquals(kokyakuAtesakiBean.getIrTyouhyousakuseiymd(), "2016年 4月18日", "（ＩＲ）帳票作成日");
        exStringEquals(kokyakuAtesakiBean.getIrShsyno(), "1234567", "（ＩＲ）送付先郵便番号");
        exStringEquals(kokyakuAtesakiBean.getIrShadr1kj(), "通信先住所１", "（ＩＲ）送付先住所１（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrShadr2kj(), "通信先住所２", "（ＩＲ）送付先住所２（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrShadr3kj(), "通信先住所３", "（ＩＲ）送付先住所３（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrShsnmkj(), "契約者名", "（ＩＲ）送付先氏名（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrToiawaseyno(), "7654321", "（ＩＲ）問合せ先郵便番号");
        exStringEquals(kokyakuAtesakiBean.getIrToiawaseadr1kj(), "問合せ先住所１", "（ＩＲ）問合せ先住所１（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrToiawaseadr2kj(), "問合せ先住所２", "（ＩＲ）問合せ先住所２（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrToiawaseadr3kj(), "問合せ先住所３", "（ＩＲ）問合せ先住所３（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrHknkisynm(), "住友生命保険相互会社", "（ＩＲ）保険会社名称");
        exStringEquals(kokyakuAtesakiBean.getIrToiawasesosiki(), "漢字組織名", "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrToiawasetelno(), "111-2222-3333", "（ＩＲ）問合せ先電話番号");

    }


    @Test
    @TestOrder(30)
    public void testEditBean_A3() {

        IT_KoujyoSym koujyoSym = hozenDomManager.getKykKihon(syoNo2).getKoujyoSyms().get(0);
        BizDate syoriYMD = BizDate.valueOf(20160418);

        ReportServicesBean reportServicesBean = editKoujyoSyoumeiTbl.editBean(khozenCommonParam, koujyoSym, syoriYMD);

        Object[] kHSBean = reportServicesBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_KOUJYOSYOUMEIS.getValue());

        exNumericEquals(kHSBean.length, 2, "パラメータオブジェクトの要素数");

        KhKoujyosyoumeisyoBean khKoujyosyoumeisyoBean = (KhKoujyosyoumeisyoBean)kHSBean[0];

        exStringEquals(khKoujyosyoumeisyoBean.getIrKyknmkj(), "契約者名", "（ＩＲ）契約者名（漢字）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrSyoumeinnd(), "2016年", "（ＩＲ）証明年度");
        exStringEquals(khKoujyosyoumeisyoBean.getIrUktnm(), "受取人名", "（ＩＲ）受取人氏名");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNenkinuktseiymd(), "＊＊＊＊＊＊＊＊＊＊＊", "（ＩＲ）年金受取人生年月日");
        exStringEquals(khKoujyosyoumeisyoBean.getIrSyono(), syoNo2, "（ＩＲ）証券番号");
        exStringEquals(khKoujyosyoumeisyoBean.getIrHknsyuruikoujyosyoumei(), "保険略称", "（ＩＲ）保険種類（控除証明書）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNkshrkknkoujyosyoumei(), "＊＊＊", "（ＩＲ）年金支払期間（控除証明書）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrKeiyakuymd(), "2016年 4月 2日", "（ＩＲ）契約年月日");
        exStringEquals(khKoujyosyoumeisyoBean.getIrHaitoukinuketorihoukbn(), "無配当", "（ＩＲ）配当金受取方法区分");
        exStringEquals(khKoujyosyoumeisyoBean.getIrHknkkn(), "12年", "（ＩＲ）保険期間");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNkshrstartymd(), "＊＊＊＊＊＊＊＊＊＊＊", "（ＩＲ）年金支払開始日");
        exStringEquals(khKoujyosyoumeisyoBean.getIrPhrkkkn(), "**", "（ＩＲ）保険料払込期間");
        exStringEquals(khKoujyosyoumeisyoBean.getIrHrkhou(), "年２回払", "（ＩＲ）払込方法");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewippanseimeip(), "111", "（ＩＲ）一般生命保険料（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewippanhaitoukin(), "222", "（ＩＲ）一般配当金（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewippansyoumeigk(), "**********", "（ＩＲ）一般証明額（新制度）");

        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnenkanippanseimeip(), "444", "（ＩＲ）年間一般生命保険料（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnenkanippanhaitoukin(), "555", "（ＩＲ）年間一般配当金（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewippansinkokugk(), "**********", "（ＩＲ）一般申告額（新制度）");

        exStringEquals(khKoujyosyoumeisyoBean.getIrNewiryouseimeip(), "112", "（ＩＲ）介護医療保険料（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewiryouhaitoukin(), "223", "（ＩＲ）介護医療配当金（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewiryousyoumeigk(), "**********", "（ＩＲ）介護医療証明額（新制度）");

        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnenkaniryouseimeip(), "445", "（ＩＲ）年間介護医療保険料（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnenkaniryouhaitoukin(), "556", "（ＩＲ）年間介護医療配当金（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewiryousinkokugk(), "**********", "（ＩＲ）介護医療申告額（新制度）");

        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnkseimeip(), "777", "（ＩＲ）個人年金保険料（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnkhaitoukin(), "888", "（ＩＲ）年金配当金（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnksyoumeigk(), "*******999", "（ＩＲ）個人年金証明額（新制度）");

        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnenkannkseimeip(), "778", "（ＩＲ）年間個人年金保険料（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnenkannkhaitoukin(), "889", "（ＩＲ）年間年金配当金（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnksinkokugk(), "*******997", "（ＩＲ）個人年金申告額（新制度）");

        exStringEquals(khKoujyosyoumeisyoBean.getIrNewhknjytuKikan(), "入金なし", "（ＩＲ）保険充当期間（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrPhrkkknjyoutai(), "＊＊＊＊", "（ＩＲ）保険料払込状態");
        exStringEquals(khKoujyosyoumeisyoBean.getIrSyoumeiymd(), "2016年 4月 3日", "（ＩＲ）証明日");
        exStringEquals(khKoujyosyoumeisyoBean.getIrUktmidasi(), "保険金", "（ＩＲ）受取人見出し");
        exStringEquals(khKoujyosyoumeisyoBean.getIrMidasisub(), "", "（ＩＲ）見出し副題");
        exStringEquals(khKoujyosyoumeisyoBean.getIrKoujyosyoumeifreearea1(), "", "（ＩＲ）控除証明フリーエリア１");

        BzKokyakuAtesakiBean kokyakuAtesakiBean = (BzKokyakuAtesakiBean)kHSBean[1];

        exStringEquals(kokyakuAtesakiBean.getIrTyouhyousakuseiymd(), "2016年 4月18日", "（ＩＲ）帳票作成日");
        exStringEquals(kokyakuAtesakiBean.getIrShsyno(), "1234567", "（ＩＲ）送付先郵便番号");
        exStringEquals(kokyakuAtesakiBean.getIrShadr1kj(), "通信先住所１", "（ＩＲ）送付先住所１（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrShadr2kj(), "通信先住所２", "（ＩＲ）送付先住所２（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrShadr3kj(), "通信先住所３", "（ＩＲ）送付先住所３（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrShsnmkj(), "契約者名", "（ＩＲ）送付先氏名（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrToiawaseyno(), "7654321", "（ＩＲ）問合せ先郵便番号");
        exStringEquals(kokyakuAtesakiBean.getIrToiawaseadr1kj(), "問合せ先住所１", "（ＩＲ）問合せ先住所１（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrToiawaseadr2kj(), "問合せ先住所２", "（ＩＲ）問合せ先住所２（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrToiawaseadr3kj(), "問合せ先住所３", "（ＩＲ）問合せ先住所３（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrHknkisynm(), "住友生命保険相互会社", "（ＩＲ）保険会社名称");
        exStringEquals(kokyakuAtesakiBean.getIrToiawasesosiki(), "漢字組織名", "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrToiawasetelno(), "111-2222-3333", "（ＩＲ）問合せ先電話番号");
    }

    @Test
    @TestOrder(40)
    public void testEditBean_A4() {

        IT_KoujyoSym koujyoSym = hozenDomManager.getKykKihon(syoNo3).getKoujyoSyms().get(0);
        BizDate syoriYMD = BizDate.valueOf(20160418);

        ReportServicesBean reportServicesBean = editKoujyoSyoumeiTbl.editBean(khozenCommonParam, koujyoSym, syoriYMD);

        Object[] kHSBean = reportServicesBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_KOUJYOSYOUMEIS.getValue());

        exNumericEquals(kHSBean.length, 2, "パラメータオブジェクトの要素数");

        KhKoujyosyoumeisyoBean khKoujyosyoumeisyoBean = (KhKoujyosyoumeisyoBean)kHSBean[0];

        exStringEquals(khKoujyosyoumeisyoBean.getIrKyknmkj(), "契約者名", "（ＩＲ）契約者名（漢字）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrSyoumeinnd(), "2016年", "（ＩＲ）証明年度");
        exStringEquals(khKoujyosyoumeisyoBean.getIrUktnm(), "受取人名", "（ＩＲ）受取人氏名");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNenkinuktseiymd(), "2015年 2月23日", "（ＩＲ）年金受取人生年月日");
        exStringEquals(khKoujyosyoumeisyoBean.getIrSyono(), syoNo3, "（ＩＲ）証券番号");
        exStringEquals(khKoujyosyoumeisyoBean.getIrHknsyuruikoujyosyoumei(), "保険略称", "（ＩＲ）保険種類（控除証明書）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNkshrkknkoujyosyoumei(), "終身", "（ＩＲ）年金支払期間（控除証明書）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrKeiyakuymd(), "2016年 4月 2日", "（ＩＲ）契約年月日");
        exStringEquals(khKoujyosyoumeisyoBean.getIrHaitoukinuketorihoukbn(), "＊＊", "（ＩＲ）配当金受取方法区分");
        exStringEquals(khKoujyosyoumeisyoBean.getIrHknkkn(), "＊＊＊", "（ＩＲ）保険期間");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNkshrstartymd(), "2015年 4月 3日", "（ＩＲ）年金支払開始日");
        exStringEquals(khKoujyosyoumeisyoBean.getIrPhrkkkn(), "1", "（ＩＲ）保険料払込期間");
        exStringEquals(khKoujyosyoumeisyoBean.getIrHrkhou(), "年１回払", "（ＩＲ）払込方法");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewippanseimeip(), "", "（ＩＲ）一般生命保険料（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewippanhaitoukin(), "", "（ＩＲ）一般配当金（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewippansyoumeigk(), "**********", "（ＩＲ）一般証明額（新制度）");

        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnenkanippanseimeip(), "", "（ＩＲ）年間一般生命保険料（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnenkanippanhaitoukin(), "", "（ＩＲ）年間一般配当金（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewippansinkokugk(), "**********", "（ＩＲ）一般申告額（新制度）");

        exStringEquals(khKoujyosyoumeisyoBean.getIrNewiryouseimeip(), "", "（ＩＲ）介護医療保険料（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewiryouhaitoukin(), "", "（ＩＲ）介護医療配当金（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewiryousyoumeigk(), "**********", "（ＩＲ）介護医療証明額（新制度）");

        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnenkaniryouseimeip(), "", "（ＩＲ）年間介護医療保険料（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnenkaniryouhaitoukin(), "", "（ＩＲ）年間介護医療配当金（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewiryousinkokugk(), "**********", "（ＩＲ）介護医療申告額（新制度）");

        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnkseimeip(), "", "（ＩＲ）個人年金保険料（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnkhaitoukin(), "", "（ＩＲ）年金配当金（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnksyoumeigk(), "**********", "（ＩＲ）個人年金証明額（新制度）");

        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnenkannkseimeip(), "", "（ＩＲ）年間個人年金保険料（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnenkannkhaitoukin(), "", "（ＩＲ）年間年金配当金（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnksinkokugk(), "**********", "（ＩＲ）個人年金申告額（新制度）");

        exStringEquals(khKoujyosyoumeisyoBean.getIrNewhknjytuKikan(), "＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊", "（ＩＲ）保険充当期間（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrPhrkkknjyoutai(), "＊＊＊＊", "（ＩＲ）保険料払込状態");
        exStringEquals(khKoujyosyoumeisyoBean.getIrSyoumeiymd(), "2016年 4月 3日", "（ＩＲ）証明日");
        exStringEquals(khKoujyosyoumeisyoBean.getIrUktmidasi(), "年金", "（ＩＲ）受取人見出し");
        exStringEquals(khKoujyosyoumeisyoBean.getIrMidasisub(), "", "（ＩＲ）見出し副題");
        exStringEquals(khKoujyosyoumeisyoBean.getIrKoujyosyoumeifreearea1(), "", "（ＩＲ）控除証明フリーエリア１");
        BzKokyakuAtesakiBean kokyakuAtesakiBean = (BzKokyakuAtesakiBean)kHSBean[1];

        exStringEquals(kokyakuAtesakiBean.getIrTyouhyousakuseiymd(), "2016年 4月18日", "（ＩＲ）帳票作成日");
        exStringEquals(kokyakuAtesakiBean.getIrShsyno(), "1234567", "（ＩＲ）送付先郵便番号");
        exStringEquals(kokyakuAtesakiBean.getIrShadr1kj(), "通信先住所１", "（ＩＲ）送付先住所１（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrShadr2kj(), "通信先住所２", "（ＩＲ）送付先住所２（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrShadr3kj(), "通信先住所３", "（ＩＲ）送付先住所３（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrShsnmkj(), "契約者名", "（ＩＲ）送付先氏名（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrToiawaseyno(), "7654321", "（ＩＲ）問合せ先郵便番号");
        exStringEquals(kokyakuAtesakiBean.getIrToiawaseadr1kj(), "問合せ先住所１", "（ＩＲ）問合せ先住所１（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrToiawaseadr2kj(), "問合せ先住所２", "（ＩＲ）問合せ先住所２（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrToiawaseadr3kj(), "問合せ先住所３", "（ＩＲ）問合せ先住所３（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrHknkisynm(), "住友生命保険相互会社", "（ＩＲ）保険会社名称");
        exStringEquals(kokyakuAtesakiBean.getIrToiawasesosiki(), "漢字組織名", "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrToiawasetelno(), "111-2222-3333", "（ＩＲ）問合せ先電話番号");
    }

    @Test
    @TestOrder(50)
    public void testEditBean_A5() {

        IT_KoujyoSym koujyoSym = hozenDomManager.getKykKihon(syoNo4).getKoujyoSyms().get(0);
        BizDate syoriYMD = BizDate.valueOf(20160418);

        ReportServicesBean reportServicesBean = editKoujyoSyoumeiTbl.editBean(khozenCommonParam, koujyoSym, syoriYMD);

        Object[] kHSBean = reportServicesBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_KOUJYOSYOUMEIS.getValue());

        exNumericEquals(kHSBean.length, 2, "パラメータオブジェクトの要素数");

        KhKoujyosyoumeisyoBean khKoujyosyoumeisyoBean = (KhKoujyosyoumeisyoBean)kHSBean[0];

        exStringEquals(khKoujyosyoumeisyoBean.getIrKyknmkj(), "契約者名", "（ＩＲ）契約者名（漢字）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrSyoumeinnd(), "2016年", "（ＩＲ）証明年度");
        exStringEquals(khKoujyosyoumeisyoBean.getIrUktnm(), "受取人名", "（ＩＲ）受取人氏名");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNenkinuktseiymd(), "2015年 2月24日", "（ＩＲ）年金受取人生年月日");
        exStringEquals(khKoujyosyoumeisyoBean.getIrSyono(), syoNo4, "（ＩＲ）証券番号");
        exStringEquals(khKoujyosyoumeisyoBean.getIrHknsyuruikoujyosyoumei(), "保険略称", "（ＩＲ）保険種類（控除証明書）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNkshrkknkoujyosyoumei(), "12年", "（ＩＲ）年金支払期間（控除証明書）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrKeiyakuymd(), "2016年 4月 2日", "（ＩＲ）契約年月日");
        exStringEquals(khKoujyosyoumeisyoBean.getIrHaitoukinuketorihoukbn(), "＊＊", "（ＩＲ）配当金受取方法区分");
        exStringEquals(khKoujyosyoumeisyoBean.getIrHknkkn(), "＊＊＊", "（ＩＲ）保険期間");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNkshrstartymd(), "2015年 4月 4日", "（ＩＲ）年金支払開始日");
        exStringEquals(khKoujyosyoumeisyoBean.getIrPhrkkkn(), "99", "（ＩＲ）保険料払込期間");
        exStringEquals(khKoujyosyoumeisyoBean.getIrHrkhou(), "＊＊", "（ＩＲ）払込方法");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewippanseimeip(), "", "（ＩＲ）一般生命保険料（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewippanhaitoukin(), "", "（ＩＲ）一般配当金（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewippansyoumeigk(), "**********", "（ＩＲ）一般証明額（新制度）");

        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnenkanippanseimeip(), "", "（ＩＲ）年間一般生命保険料（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnenkanippanhaitoukin(), "", "（ＩＲ）年間一般配当金（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewippansinkokugk(), "**********", "（ＩＲ）一般申告額（新制度）");

        exStringEquals(khKoujyosyoumeisyoBean.getIrNewiryouseimeip(), "", "（ＩＲ）介護医療保険料（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewiryouhaitoukin(), "", "（ＩＲ）介護医療配当金（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewiryousyoumeigk(), "**********", "（ＩＲ）介護医療証明額（新制度）");

        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnenkaniryouseimeip(), "", "（ＩＲ）年間介護医療保険料（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnenkaniryouhaitoukin(), "", "（ＩＲ）年間介護医療配当金（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewiryousinkokugk(), "**********", "（ＩＲ）介護医療申告額（新制度）");

        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnkseimeip(), "", "（ＩＲ）個人年金保険料（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnkhaitoukin(), "", "（ＩＲ）年金配当金（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnksyoumeigk(), "**********", "（ＩＲ）個人年金証明額（新制度）");

        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnenkannkseimeip(), "", "（ＩＲ）年間個人年金保険料（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnenkannkhaitoukin(), "", "（ＩＲ）年間年金配当金（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnksinkokugk(), "**********", "（ＩＲ）個人年金申告額（新制度）");

        exStringEquals(khKoujyosyoumeisyoBean.getIrNewhknjytuKikan(), "＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊", "（ＩＲ）保険充当期間（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrPhrkkknjyoutai(), "＊＊＊＊", "（ＩＲ）保険料払込状態");
        exStringEquals(khKoujyosyoumeisyoBean.getIrSyoumeiymd(), "2016年 4月 3日", "（ＩＲ）証明日");
        exStringEquals(khKoujyosyoumeisyoBean.getIrUktmidasi(), "年金", "（ＩＲ）受取人見出し");
        exStringEquals(khKoujyosyoumeisyoBean.getIrMidasisub(), "－再発行－", "（ＩＲ）見出し副題");
        exStringEquals(khKoujyosyoumeisyoBean.getIrKoujyosyoumeifreearea1(),"","（ＩＲ）控除証明フリーエリア１");

        BzKokyakuAtesakiBean kokyakuAtesakiBean = (BzKokyakuAtesakiBean)kHSBean[1];

        exStringEquals(kokyakuAtesakiBean.getIrTyouhyousakuseiymd(), "2016年 4月18日", "（ＩＲ）帳票作成日");
        exStringEquals(kokyakuAtesakiBean.getIrShsyno(), "1234567", "（ＩＲ）送付先郵便番号");
        exStringEquals(kokyakuAtesakiBean.getIrShadr1kj(), "通信先住所１", "（ＩＲ）送付先住所１（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrShadr2kj(), "通信先住所２", "（ＩＲ）送付先住所２（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrShadr3kj(), "通信先住所３", "（ＩＲ）送付先住所３（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrShsnmkj(), "契約者名", "（ＩＲ）送付先氏名（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrToiawaseyno(), "7654321", "（ＩＲ）問合せ先郵便番号");
        exStringEquals(kokyakuAtesakiBean.getIrToiawaseadr1kj(), "問合せ先住所１", "（ＩＲ）問合せ先住所１（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrToiawaseadr2kj(), "問合せ先住所２", "（ＩＲ）問合せ先住所２（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrToiawaseadr3kj(), "問合せ先住所３", "（ＩＲ）問合せ先住所３（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrHknkisynm(), "住友生命保険相互会社", "（ＩＲ）保険会社名称");
        exStringEquals(kokyakuAtesakiBean.getIrToiawasesosiki(), "漢字組織名", "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrToiawasetelno(), "111-2222-3333", "（ＩＲ）問合せ先電話番号");
    }


    @Test
    @TestOrder(60)
    public void testEditBean_A6() {

        IT_KoujyoSym koujyoSym = hozenDomManager.getKykKihon(syoNo5).getKoujyoSyms().get(0);
        BizDate syoriYMD = BizDate.valueOf(20160418);

        ReportServicesBean reportServicesBean = editKoujyoSyoumeiTbl.editBean(khozenCommonParam, koujyoSym, syoriYMD);

        Object[] kHSBean = reportServicesBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_KOUJYOSYOUMEIS.getValue());

        exNumericEquals(kHSBean.length, 2, "パラメータオブジェクトの要素数");

        KhKoujyosyoumeisyoBean khKoujyosyoumeisyoBean = (KhKoujyosyoumeisyoBean)kHSBean[0];

        exStringEquals(khKoujyosyoumeisyoBean.getIrKyknmkj(), "契約者名", "（ＩＲ）契約者名（漢字）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrSyoumeinnd(), "2016年", "（ＩＲ）証明年度");
        exStringEquals(khKoujyosyoumeisyoBean.getIrUktnm(), "受取人名", "（ＩＲ）受取人氏名");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNenkinuktseiymd(), "2015年 2月25日", "（ＩＲ）年金受取人生年月日");
        exStringEquals(khKoujyosyoumeisyoBean.getIrSyono(), syoNo5, "（ＩＲ）証券番号");
        exStringEquals(khKoujyosyoumeisyoBean.getIrHknsyuruikoujyosyoumei(), "保険略称", "（ＩＲ）保険種類（控除証明書）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNkshrkknkoujyosyoumei(), "終身", "（ＩＲ）年金支払期間（控除証明書）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrKeiyakuymd(), "2016年 4月 2日", "（ＩＲ）契約年月日");
        exStringEquals(khKoujyosyoumeisyoBean.getIrHaitoukinuketorihoukbn(), "＊＊", "（ＩＲ）配当金受取方法区分");
        exStringEquals(khKoujyosyoumeisyoBean.getIrHknkkn(), "＊＊＊", "（ＩＲ）保険期間");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNkshrstartymd(), "2015年 4月 5日", "（ＩＲ）年金支払開始日");
        exStringEquals(khKoujyosyoumeisyoBean.getIrPhrkkkn(), "12", "（ＩＲ）保険料払込期間");
        exStringEquals(khKoujyosyoumeisyoBean.getIrHrkhou(), "月払", "（ＩＲ）払込方法");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewippanseimeip(), "111", "（ＩＲ）一般生命保険料（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewippanhaitoukin(), "222", "（ＩＲ）一般配当金（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewippansyoumeigk(), "       -20", "（ＩＲ）一般証明額（新制度）");

        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnenkanippanseimeip(), "444", "（ＩＲ）年間一般生命保険料（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnenkanippanhaitoukin(), "555", "（ＩＲ）年間一般配当金（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewippansinkokugk(), "       -20", "（ＩＲ）一般申告額（新制度）");

        exStringEquals(khKoujyosyoumeisyoBean.getIrNewiryouseimeip(), "112", "（ＩＲ）介護医療保険料（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewiryouhaitoukin(), "223", "（ＩＲ）介護医療配当金（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewiryousyoumeigk(), "       -20", "（ＩＲ）介護医療証明額（新制度）");

        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnenkaniryouseimeip(), "445", "（ＩＲ）年間介護医療保険料（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnenkaniryouhaitoukin(), "556", "（ＩＲ）年間介護医療配当金（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewiryousinkokugk(), "       -20", "（ＩＲ）介護医療申告額（新制度）");

        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnkseimeip(), "777", "（ＩＲ）個人年金保険料（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnkhaitoukin(), "888", "（ＩＲ）年金配当金（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnksyoumeigk(), "*******999", "（ＩＲ）個人年金証明額（新制度）");

        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnenkannkseimeip(), "778", "（ＩＲ）年間個人年金保険料（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnenkannkhaitoukin(), "889", "（ＩＲ）年間年金配当金（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnksinkokugk(), "*******997", "（ＩＲ）個人年金申告額（新制度）");

        exStringEquals(khKoujyosyoumeisyoBean.getIrNewhknjytuKikan(), "2017年12月から入金なし", "（ＩＲ）保険充当期間（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrPhrkkknjyoutai(), "払込停止", "（ＩＲ）保険料払込状態");
        exStringEquals(khKoujyosyoumeisyoBean.getIrSyoumeiymd(), "2016年 4月 3日", "（ＩＲ）証明日");
        exStringEquals(khKoujyosyoumeisyoBean.getIrUktmidasi(), "年金", "（ＩＲ）受取人見出し");
        exStringEquals(khKoujyosyoumeisyoBean.getIrMidasisub(), "", "（ＩＲ）見出し副題");
        exStringEquals(khKoujyosyoumeisyoBean.getIrKoujyosyoumeifreearea1(),
            "本商品は、円貨払込保険料が変動するため、申告予定額は記載しておりません。",
            "（ＩＲ）控除証明フリーエリア１");

        BzKokyakuAtesakiBean kokyakuAtesakiBean = (BzKokyakuAtesakiBean)kHSBean[1];

        exStringEquals(kokyakuAtesakiBean.getIrTyouhyousakuseiymd(), "2016年 4月18日", "（ＩＲ）帳票作成日");
        exStringEquals(kokyakuAtesakiBean.getIrShsyno(), "1234567", "（ＩＲ）送付先郵便番号");
        exStringEquals(kokyakuAtesakiBean.getIrShadr1kj(), "通信先住所１", "（ＩＲ）送付先住所１（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrShadr2kj(), "通信先住所２", "（ＩＲ）送付先住所２（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrShadr3kj(), "通信先住所３", "（ＩＲ）送付先住所３（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrShsnmkj(), "契約者名", "（ＩＲ）送付先氏名（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrToiawaseyno(), "7654321", "（ＩＲ）問合せ先郵便番号");
        exStringEquals(kokyakuAtesakiBean.getIrToiawaseadr1kj(), "問合せ先住所１", "（ＩＲ）問合せ先住所１（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrToiawaseadr2kj(), "問合せ先住所２", "（ＩＲ）問合せ先住所２（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrToiawaseadr3kj(), "問合せ先住所３", "（ＩＲ）問合せ先住所３（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrHknkisynm(), "住友生命保険相互会社", "（ＩＲ）保険会社名称");
        exStringEquals(kokyakuAtesakiBean.getIrToiawasesosiki(), "漢字組織名", "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrToiawasetelno(), "111-2222-3333", "（ＩＲ）問合せ先電話番号");

    }


    @Test
    @TestOrder(70)
    public void testEditBean_A7() {

        IT_KoujyoSym koujyoSym = hozenDomManager.getKykKihon(syoNo6).getKoujyoSyms().get(0);
        BizDate syoriYMD = BizDate.valueOf(20160418);

        ReportServicesBean reportServicesBean = editKoujyoSyoumeiTbl.editBean(khozenCommonParam, koujyoSym, syoriYMD);

        Object[] kHSBean = reportServicesBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_KOUJYOSYOUMEIS.getValue());

        exNumericEquals(kHSBean.length, 2, "パラメータオブジェクトの要素数");

        KhKoujyosyoumeisyoBean khKoujyosyoumeisyoBean = (KhKoujyosyoumeisyoBean)kHSBean[0];

        exStringEquals(khKoujyosyoumeisyoBean.getIrKyknmkj(), "契約者名", "（ＩＲ）契約者名（漢字）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrSyoumeinnd(), "2016年", "（ＩＲ）証明年度");
        exStringEquals(khKoujyosyoumeisyoBean.getIrUktnm(), "受取人名", "（ＩＲ）受取人氏名");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNenkinuktseiymd(), "＊＊＊＊＊＊＊＊＊＊＊", "（ＩＲ）年金受取人生年月日");
        exStringEquals(khKoujyosyoumeisyoBean.getIrSyono(), syoNo6, "（ＩＲ）証券番号");
        exStringEquals(khKoujyosyoumeisyoBean.getIrHknsyuruikoujyosyoumei(), "保険略称", "（ＩＲ）保険種類（控除証明書）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNkshrkknkoujyosyoumei(), "＊＊＊", "（ＩＲ）年金支払期間（控除証明書）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrKeiyakuymd(), "2016年 4月 2日", "（ＩＲ）契約年月日");
        exStringEquals(khKoujyosyoumeisyoBean.getIrHaitoukinuketorihoukbn(), "積立", "（ＩＲ）配当金受取方法区分");
        exStringEquals(khKoujyosyoumeisyoBean.getIrHknkkn(), "12年", "（ＩＲ）保険期間");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNkshrstartymd(), "＊＊＊＊＊＊＊＊＊＊＊", "（ＩＲ）年金支払開始日");
        exStringEquals(khKoujyosyoumeisyoBean.getIrPhrkkkn(), "**", "（ＩＲ）保険料払込期間");
        exStringEquals(khKoujyosyoumeisyoBean.getIrHrkhou(), "月払", "（ＩＲ）払込方法");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewippanseimeip(), "111", "（ＩＲ）一般生命保険料（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewippanhaitoukin(), "222", "（ＩＲ）一般配当金（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewippansyoumeigk(), "*******333", "（ＩＲ）一般証明額（新制度）");

        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnenkanippanseimeip(), "444", "（ＩＲ）年間一般生命保険料（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnenkanippanhaitoukin(), "555", "（ＩＲ）年間一般配当金（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewippansinkokugk(), "*******666", "（ＩＲ）一般申告額（新制度）");

        exStringEquals(khKoujyosyoumeisyoBean.getIrNewiryouseimeip(), "112", "（ＩＲ）介護医療保険料（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewiryouhaitoukin(), "223", "（ＩＲ）介護医療配当金（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewiryousyoumeigk(), "*******334", "（ＩＲ）介護医療証明額（新制度）");

        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnenkaniryouseimeip(), "445", "（ＩＲ）年間介護医療保険料（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnenkaniryouhaitoukin(), "556", "（ＩＲ）年間介護医療配当金（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewiryousinkokugk(), "*******667", "（ＩＲ）介護医療申告額（新制度）");

        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnkseimeip(), "777", "（ＩＲ）個人年金保険料（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnkhaitoukin(), "888", "（ＩＲ）年金配当金（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnksyoumeigk(), "*******999", "（ＩＲ）個人年金証明額（新制度）");

        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnenkannkseimeip(), "778", "（ＩＲ）年間個人年金保険料（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnenkannkhaitoukin(), "889", "（ＩＲ）年間年金配当金（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnksinkokugk(), "*******997", "（ＩＲ）個人年金申告額（新制度）");

        exStringEquals(khKoujyosyoumeisyoBean.getIrNewhknjytuKikan(), "2017年12月から1か月分", "（ＩＲ）保険充当期間（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrPhrkkknjyoutai(), "払込中", "（ＩＲ）保険料払込状態");
        exStringEquals(khKoujyosyoumeisyoBean.getIrSyoumeiymd(), "2016年 4月 3日", "（ＩＲ）証明日");
        exStringEquals(khKoujyosyoumeisyoBean.getIrUktmidasi(), "保険金", "（ＩＲ）受取人見出し");
        exStringEquals(khKoujyosyoumeisyoBean.getIrMidasisub(), "", "（ＩＲ）見出し副題");
        exStringEquals(khKoujyosyoumeisyoBean.getIrKoujyosyoumeifreearea1(), "", "（ＩＲ）控除証明フリーエリア１");

        BzKokyakuAtesakiBean kokyakuAtesakiBean = (BzKokyakuAtesakiBean)kHSBean[1];

        exStringEquals(kokyakuAtesakiBean.getIrTyouhyousakuseiymd(), "2016年 4月18日", "（ＩＲ）帳票作成日");
        exStringEquals(kokyakuAtesakiBean.getIrShsyno(), "1234567", "（ＩＲ）送付先郵便番号");
        exStringEquals(kokyakuAtesakiBean.getIrShadr1kj(), "通信先住所１", "（ＩＲ）送付先住所１（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrShadr2kj(), "通信先住所２", "（ＩＲ）送付先住所２（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrShadr3kj(), "通信先住所３", "（ＩＲ）送付先住所３（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrShsnmkj(), "契約者名", "（ＩＲ）送付先氏名（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrToiawaseyno(), "7654321", "（ＩＲ）問合せ先郵便番号");
        exStringEquals(kokyakuAtesakiBean.getIrToiawaseadr1kj(), "問合せ先住所１", "（ＩＲ）問合せ先住所１（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrToiawaseadr2kj(), "問合せ先住所２", "（ＩＲ）問合せ先住所２（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrToiawaseadr3kj(), "問合せ先住所３", "（ＩＲ）問合せ先住所３（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrHknkisynm(), "住友生命保険相互会社", "（ＩＲ）保険会社名称");
        exStringEquals(kokyakuAtesakiBean.getIrToiawasesosiki(), "漢字組織名", "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrToiawasetelno(), "111-2222-3333", "（ＩＲ）問合せ先電話番号");

    }


    @Test
    @TestOrder(80)
    public void testEditBean_A8() {

        IT_KoujyoSym koujyoSym = hozenDomManager.getKykKihon(syoNo7).getKoujyoSyms().get(0);
        BizDate syoriYMD = BizDate.valueOf(20160418);

        ReportServicesBean reportServicesBean = editKoujyoSyoumeiTbl.editBean(khozenCommonParam, koujyoSym, syoriYMD);

        Object[] kHSBean = reportServicesBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_KOUJYOSYOUMEIS.getValue());

        exNumericEquals(kHSBean.length, 2, "パラメータオブジェクトの要素数");

        KhKoujyosyoumeisyoBean khKoujyosyoumeisyoBean = (KhKoujyosyoumeisyoBean)kHSBean[0];

        exStringEquals(khKoujyosyoumeisyoBean.getIrKyknmkj(), "契約者名", "（ＩＲ）契約者名（漢字）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrSyoumeinnd(), "2016年", "（ＩＲ）証明年度");
        exStringEquals(khKoujyosyoumeisyoBean.getIrUktnm(), "受取人名", "（ＩＲ）受取人氏名");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNenkinuktseiymd(), "＊＊＊＊＊＊＊＊＊＊＊", "（ＩＲ）年金受取人生年月日");
        exStringEquals(khKoujyosyoumeisyoBean.getIrSyono(), syoNo7, "（ＩＲ）証券番号");
        exStringEquals(khKoujyosyoumeisyoBean.getIrHknsyuruikoujyosyoumei(), "保険略称", "（ＩＲ）保険種類（控除証明書）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNkshrkknkoujyosyoumei(), "＊＊＊", "（ＩＲ）年金支払期間（控除証明書）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrKeiyakuymd(), "2016年 4月 2日", "（ＩＲ）契約年月日");
        exStringEquals(khKoujyosyoumeisyoBean.getIrHaitoukinuketorihoukbn(), "積立", "（ＩＲ）配当金受取方法区分");
        exStringEquals(khKoujyosyoumeisyoBean.getIrHknkkn(), "12年", "（ＩＲ）保険期間");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNkshrstartymd(), "＊＊＊＊＊＊＊＊＊＊＊", "（ＩＲ）年金支払開始日");
        exStringEquals(khKoujyosyoumeisyoBean.getIrPhrkkkn(), "**", "（ＩＲ）保険料払込期間");
        exStringEquals(khKoujyosyoumeisyoBean.getIrHrkhou(), "月払", "（ＩＲ）払込方法");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewippanseimeip(), "111", "（ＩＲ）一般生命保険料（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewippanhaitoukin(), "222", "（ＩＲ）一般配当金（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewippansyoumeigk(), "*******333", "（ＩＲ）一般証明額（新制度）");

        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnenkanippanseimeip(), "444", "（ＩＲ）年間一般生命保険料（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnenkanippanhaitoukin(), "555", "（ＩＲ）年間一般配当金（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewippansinkokugk(), "*******666", "（ＩＲ）一般申告額（新制度）");

        exStringEquals(khKoujyosyoumeisyoBean.getIrNewiryouseimeip(), "112", "（ＩＲ）介護医療保険料（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewiryouhaitoukin(), "223", "（ＩＲ）介護医療配当金（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewiryousyoumeigk(), "*******334", "（ＩＲ）介護医療証明額（新制度）");

        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnenkaniryouseimeip(), "445", "（ＩＲ）年間介護医療保険料（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnenkaniryouhaitoukin(), "556", "（ＩＲ）年間介護医療配当金（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewiryousinkokugk(), "*******667", "（ＩＲ）介護医療申告額（新制度）");

        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnkseimeip(), "777", "（ＩＲ）個人年金保険料（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnkhaitoukin(), "888", "（ＩＲ）年金配当金（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnksyoumeigk(), "*******999", "（ＩＲ）個人年金証明額（新制度）");

        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnenkannkseimeip(), "778", "（ＩＲ）年間個人年金保険料（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnenkannkhaitoukin(), "889", "（ＩＲ）年間年金配当金（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnksinkokugk(), "*******997", "（ＩＲ）個人年金申告額（新制度）");

        exStringEquals(khKoujyosyoumeisyoBean.getIrNewhknjytuKikan(), "2017年12月から1年分", "（ＩＲ）保険充当期間（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrPhrkkknjyoutai(), "払込中", "（ＩＲ）保険料払込状態");
        exStringEquals(khKoujyosyoumeisyoBean.getIrSyoumeiymd(), "2016年 4月 3日", "（ＩＲ）証明日");
        exStringEquals(khKoujyosyoumeisyoBean.getIrUktmidasi(), "保険金", "（ＩＲ）受取人見出し");
        exStringEquals(khKoujyosyoumeisyoBean.getIrMidasisub(), "", "（ＩＲ）見出し副題");
        exStringEquals(khKoujyosyoumeisyoBean.getIrKoujyosyoumeifreearea1(), "", "（ＩＲ）控除証明フリーエリア１");

        BzKokyakuAtesakiBean kokyakuAtesakiBean = (BzKokyakuAtesakiBean)kHSBean[1];

        exStringEquals(kokyakuAtesakiBean.getIrTyouhyousakuseiymd(), "2016年 4月18日", "（ＩＲ）帳票作成日");
        exStringEquals(kokyakuAtesakiBean.getIrShsyno(), "1234567", "（ＩＲ）送付先郵便番号");
        exStringEquals(kokyakuAtesakiBean.getIrShadr1kj(), "通信先住所１", "（ＩＲ）送付先住所１（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrShadr2kj(), "通信先住所２", "（ＩＲ）送付先住所２（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrShadr3kj(), "通信先住所３", "（ＩＲ）送付先住所３（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrShsnmkj(), "契約者名", "（ＩＲ）送付先氏名（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrToiawaseyno(), "7654321", "（ＩＲ）問合せ先郵便番号");
        exStringEquals(kokyakuAtesakiBean.getIrToiawaseadr1kj(), "問合せ先住所１", "（ＩＲ）問合せ先住所１（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrToiawaseadr2kj(), "問合せ先住所２", "（ＩＲ）問合せ先住所２（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrToiawaseadr3kj(), "問合せ先住所３", "（ＩＲ）問合せ先住所３（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrHknkisynm(), "住友生命保険相互会社", "（ＩＲ）保険会社名称");
        exStringEquals(kokyakuAtesakiBean.getIrToiawasesosiki(), "漢字組織名", "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrToiawasetelno(), "111-2222-3333", "（ＩＲ）問合せ先電話番号");

    }

    @Test
    @TestOrder(90)
    public void testEditBean_A9() {

        IT_KoujyoSym koujyoSym = hozenDomManager.getKykKihon(syoNo8).getKoujyoSyms().get(0);
        BizDate syoriYMD = BizDate.valueOf(20160418);

        ReportServicesBean reportServicesBean = editKoujyoSyoumeiTbl.editBean(khozenCommonParam, koujyoSym, syoriYMD);

        Object[] kHSBean = reportServicesBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_KOUJYOSYOUMEIS.getValue());

        exNumericEquals(kHSBean.length, 2, "パラメータオブジェクトの要素数");

        KhKoujyosyoumeisyoBean khKoujyosyoumeisyoBean = (KhKoujyosyoumeisyoBean)kHSBean[0];

        exStringEquals(khKoujyosyoumeisyoBean.getIrKyknmkj(), "契約者名", "（ＩＲ）契約者名（漢字）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrSyoumeinnd(), "2016年", "（ＩＲ）証明年度");
        exStringEquals(khKoujyosyoumeisyoBean.getIrUktnm(), "受取人名", "（ＩＲ）受取人氏名");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNenkinuktseiymd(), "2015年 2月28日", "（ＩＲ）年金受取人生年月日");
        exStringEquals(khKoujyosyoumeisyoBean.getIrSyono(), syoNo8, "（ＩＲ）証券番号");
        exStringEquals(khKoujyosyoumeisyoBean.getIrHknsyuruikoujyosyoumei(), "保険略称", "（ＩＲ）保険種類（控除証明書）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNkshrkknkoujyosyoumei(), "終身", "（ＩＲ）年金支払期間（控除証明書）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrKeiyakuymd(), "2016年 4月 2日", "（ＩＲ）契約年月日");
        exStringEquals(khKoujyosyoumeisyoBean.getIrHaitoukinuketorihoukbn(), "＊＊", "（ＩＲ）配当金受取方法区分");
        exStringEquals(khKoujyosyoumeisyoBean.getIrHknkkn(), "＊＊＊", "（ＩＲ）保険期間");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNkshrstartymd(), "2015年 4月 8日", "（ＩＲ）年金支払開始日");
        exStringEquals(khKoujyosyoumeisyoBean.getIrPhrkkkn(), "12", "（ＩＲ）保険料払込期間");
        exStringEquals(khKoujyosyoumeisyoBean.getIrHrkhou(), "月払", "（ＩＲ）払込方法");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewippanseimeip(), "111", "（ＩＲ）一般生命保険料（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewippanhaitoukin(), "222", "（ＩＲ）一般配当金（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewippansyoumeigk(), "*******333", "（ＩＲ）一般証明額（新制度）");

        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnenkanippanseimeip(), "444", "（ＩＲ）年間一般生命保険料（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnenkanippanhaitoukin(), "555", "（ＩＲ）年間一般配当金（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewippansinkokugk(), "*******666", "（ＩＲ）一般申告額（新制度）");

        exStringEquals(khKoujyosyoumeisyoBean.getIrNewiryouseimeip(), "112", "（ＩＲ）介護医療保険料（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewiryouhaitoukin(), "223", "（ＩＲ）介護医療配当金（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewiryousyoumeigk(), "*******334", "（ＩＲ）介護医療証明額（新制度）");

        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnenkaniryouseimeip(), "445", "（ＩＲ）年間介護医療保険料（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnenkaniryouhaitoukin(), "556", "（ＩＲ）年間介護医療配当金（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewiryousinkokugk(), "*******667", "（ＩＲ）介護医療申告額（新制度）");

        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnkseimeip(), "777", "（ＩＲ）個人年金保険料（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnkhaitoukin(), "888", "（ＩＲ）年金配当金（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnksyoumeigk(), "**********", "（ＩＲ）個人年金証明額（新制度）");

        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnenkannkseimeip(), "778", "（ＩＲ）年間個人年金保険料（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnenkannkhaitoukin(), "889", "（ＩＲ）年間年金配当金（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnksinkokugk(), "**********", "（ＩＲ）個人年金申告額（新制度）");

        exStringEquals(khKoujyosyoumeisyoBean.getIrNewhknjytuKikan(), "2016年 4月から12年分", "（ＩＲ）保険充当期間（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrPhrkkknjyoutai(), "払込停止", "（ＩＲ）保険料払込状態");
        exStringEquals(khKoujyosyoumeisyoBean.getIrSyoumeiymd(), "2016年 4月 3日", "（ＩＲ）証明日");
        exStringEquals(khKoujyosyoumeisyoBean.getIrUktmidasi(), "年金", "（ＩＲ）受取人見出し");
        exStringEquals(khKoujyosyoumeisyoBean.getIrMidasisub(), "", "（ＩＲ）見出し副題");
        exStringEquals(khKoujyosyoumeisyoBean.getIrKoujyosyoumeifreearea1(), "", "（ＩＲ）控除証明フリーエリア１");

        BzKokyakuAtesakiBean kokyakuAtesakiBean = (BzKokyakuAtesakiBean)kHSBean[1];

        exStringEquals(kokyakuAtesakiBean.getIrTyouhyousakuseiymd(), "2016年 4月18日", "（ＩＲ）帳票作成日");
        exStringEquals(kokyakuAtesakiBean.getIrShsyno(), "1234567", "（ＩＲ）送付先郵便番号");
        exStringEquals(kokyakuAtesakiBean.getIrShadr1kj(), "通信先住所１", "（ＩＲ）送付先住所１（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrShadr2kj(), "通信先住所２", "（ＩＲ）送付先住所２（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrShadr3kj(), "通信先住所３", "（ＩＲ）送付先住所３（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrShsnmkj(), "契約者名", "（ＩＲ）送付先氏名（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrToiawaseyno(), "7654321", "（ＩＲ）問合せ先郵便番号");
        exStringEquals(kokyakuAtesakiBean.getIrToiawaseadr1kj(), "問合せ先住所１", "（ＩＲ）問合せ先住所１（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrToiawaseadr2kj(), "問合せ先住所２", "（ＩＲ）問合せ先住所２（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrToiawaseadr3kj(), "問合せ先住所３", "（ＩＲ）問合せ先住所３（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrHknkisynm(), "住友生命保険相互会社", "（ＩＲ）保険会社名称");
        exStringEquals(kokyakuAtesakiBean.getIrToiawasesosiki(), "漢字組織名", "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrToiawasetelno(), "111-2222-3333", "（ＩＲ）問合せ先電話番号");
    }

    @Test
    @TestOrder(100)
    public void testEditBean_A10() {

        IT_KoujyoSym koujyoSym = hozenDomManager.getKykKihon(syoNo9).getKoujyoSyms().get(0);
        BizDate syoriYMD = BizDate.valueOf(20160418);

        ReportServicesBean reportServicesBean = editKoujyoSyoumeiTbl.editBean(khozenCommonParam, koujyoSym, syoriYMD);

        Object[] kHSBean = reportServicesBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_KOUJYOSYOUMEIS.getValue());

        exNumericEquals(kHSBean.length, 2, "パラメータオブジェクトの要素数");

        KhKoujyosyoumeisyoBean khKoujyosyoumeisyoBean = (KhKoujyosyoumeisyoBean)kHSBean[0];

        exStringEquals(khKoujyosyoumeisyoBean.getIrKyknmkj(), "契約者名", "（ＩＲ）契約者名（漢字）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrSyoumeinnd(), "2016年", "（ＩＲ）証明年度");
        exStringEquals(khKoujyosyoumeisyoBean.getIrUktnm(), "受取人名", "（ＩＲ）受取人氏名");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNenkinuktseiymd(), "2015年 3月 1日", "（ＩＲ）年金受取人生年月日");
        exStringEquals(khKoujyosyoumeisyoBean.getIrSyono(), syoNo9, "（ＩＲ）証券番号");
        exStringEquals(khKoujyosyoumeisyoBean.getIrHknsyuruikoujyosyoumei(), "保険略称", "（ＩＲ）保険種類（控除証明書）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNkshrkknkoujyosyoumei(), "終身", "（ＩＲ）年金支払期間（控除証明書）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrKeiyakuymd(), "2016年 4月 2日", "（ＩＲ）契約年月日");
        exStringEquals(khKoujyosyoumeisyoBean.getIrHaitoukinuketorihoukbn(), "＊＊", "（ＩＲ）配当金受取方法区分");
        exStringEquals(khKoujyosyoumeisyoBean.getIrHknkkn(), "＊＊＊", "（ＩＲ）保険期間");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNkshrstartymd(), "2015年 4月 9日", "（ＩＲ）年金支払開始日");
        exStringEquals(khKoujyosyoumeisyoBean.getIrPhrkkkn(), "12", "（ＩＲ）保険料払込期間");
        exStringEquals(khKoujyosyoumeisyoBean.getIrHrkhou(), "月払", "（ＩＲ）払込方法");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewippanseimeip(), "111", "（ＩＲ）一般生命保険料（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewippanhaitoukin(), "222", "（ＩＲ）一般配当金（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewippansyoumeigk(), "*******333", "（ＩＲ）一般証明額（新制度）");

        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnenkanippanseimeip(), "444", "（ＩＲ）年間一般生命保険料（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnenkanippanhaitoukin(), "555", "（ＩＲ）年間一般配当金（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewippansinkokugk(), "*******666", "（ＩＲ）一般申告額（新制度）");

        exStringEquals(khKoujyosyoumeisyoBean.getIrNewiryouseimeip(), "112", "（ＩＲ）介護医療保険料（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewiryouhaitoukin(), "223", "（ＩＲ）介護医療配当金（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewiryousyoumeigk(), "*******334", "（ＩＲ）介護医療証明額（新制度）");

        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnenkaniryouseimeip(), "445", "（ＩＲ）年間介護医療保険料（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnenkaniryouhaitoukin(), "556", "（ＩＲ）年間介護医療配当金（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewiryousinkokugk(), "*******667", "（ＩＲ）介護医療申告額（新制度）");

        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnkseimeip(), "777", "（ＩＲ）個人年金保険料（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnkhaitoukin(), "888", "（ＩＲ）年金配当金（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnksyoumeigk(), "       -30", "（ＩＲ）個人年金証明額（新制度）");

        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnenkannkseimeip(), "778", "（ＩＲ）年間個人年金保険料（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnenkannkhaitoukin(), "889", "（ＩＲ）年間年金配当金（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnksinkokugk(), "       -30", "（ＩＲ）個人年金申告額（新制度）");

        exStringEquals(khKoujyosyoumeisyoBean.getIrNewhknjytuKikan(), "2016年 4月から12年分", "（ＩＲ）保険充当期間（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrPhrkkknjyoutai(), "払込停止", "（ＩＲ）保険料払込状態");
        exStringEquals(khKoujyosyoumeisyoBean.getIrSyoumeiymd(), "2016年 4月 3日", "（ＩＲ）証明日");
        exStringEquals(khKoujyosyoumeisyoBean.getIrUktmidasi(), "年金", "（ＩＲ）受取人見出し");
        exStringEquals(khKoujyosyoumeisyoBean.getIrMidasisub(), "", "（ＩＲ）見出し副題");
        exStringEquals(khKoujyosyoumeisyoBean.getIrKoujyosyoumeifreearea1(), "", "（ＩＲ）控除証明フリーエリア１");

        BzKokyakuAtesakiBean kokyakuAtesakiBean = (BzKokyakuAtesakiBean)kHSBean[1];

        exStringEquals(kokyakuAtesakiBean.getIrTyouhyousakuseiymd(), "2016年 4月18日", "（ＩＲ）帳票作成日");
        exStringEquals(kokyakuAtesakiBean.getIrShsyno(), "1234567", "（ＩＲ）送付先郵便番号");
        exStringEquals(kokyakuAtesakiBean.getIrShadr1kj(), "通信先住所１", "（ＩＲ）送付先住所１（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrShadr2kj(), "通信先住所２", "（ＩＲ）送付先住所２（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrShadr3kj(), "通信先住所３", "（ＩＲ）送付先住所３（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrShsnmkj(), "契約者名", "（ＩＲ）送付先氏名（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrToiawaseyno(), "7654321", "（ＩＲ）問合せ先郵便番号");
        exStringEquals(kokyakuAtesakiBean.getIrToiawaseadr1kj(), "問合せ先住所１", "（ＩＲ）問合せ先住所１（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrToiawaseadr2kj(), "問合せ先住所２", "（ＩＲ）問合せ先住所２（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrToiawaseadr3kj(), "問合せ先住所３", "（ＩＲ）問合せ先住所３（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrHknkisynm(), "住友生命保険相互会社", "（ＩＲ）保険会社名称");
        exStringEquals(kokyakuAtesakiBean.getIrToiawasesosiki(), "漢字組織名", "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrToiawasetelno(), "111-2222-3333", "（ＩＲ）問合せ先電話番号");

    }

    @Test
    @TestOrder(110)
    public void testEditBean_A11() {

        IT_KoujyoSym koujyoSym = hozenDomManager.getKykKihon(syoNo10).getKoujyoSyms().get(0);
        BizDate syoriYMD = BizDate.valueOf(20160418);

        ReportServicesBean reportServicesBean = editKoujyoSyoumeiTbl.editBean(khozenCommonParam, koujyoSym, syoriYMD);

        Object[] kHSBean = reportServicesBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_KOUJYOSYOUMEIS.getValue());

        exNumericEquals(kHSBean.length, 2, "パラメータオブジェクトの要素数");

        KhKoujyosyoumeisyoBean khKoujyosyoumeisyoBean = (KhKoujyosyoumeisyoBean)kHSBean[0];

        exStringEquals(khKoujyosyoumeisyoBean.getIrKyknmkj(), "契約者名", "（ＩＲ）契約者名（漢字）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrSyoumeinnd(), "2016年", "（ＩＲ）証明年度");
        exStringEquals(khKoujyosyoumeisyoBean.getIrUktnm(), "受取人名", "（ＩＲ）受取人氏名");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNenkinuktseiymd(), "2015年 3月 1日", "（ＩＲ）年金受取人生年月日");
        exStringEquals(khKoujyosyoumeisyoBean.getIrSyono(), syoNo10, "（ＩＲ）証券番号");
        exStringEquals(khKoujyosyoumeisyoBean.getIrHknsyuruikoujyosyoumei(), "保険略称", "（ＩＲ）保険種類（控除証明書）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNkshrkknkoujyosyoumei(), "終身", "（ＩＲ）年金支払期間（控除証明書）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrKeiyakuymd(), "2016年 4月 2日", "（ＩＲ）契約年月日");
        exStringEquals(khKoujyosyoumeisyoBean.getIrHaitoukinuketorihoukbn(), "＊＊", "（ＩＲ）配当金受取方法区分");
        exStringEquals(khKoujyosyoumeisyoBean.getIrHknkkn(), "＊＊＊", "（ＩＲ）保険期間");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNkshrstartymd(), "2015年 4月 9日", "（ＩＲ）年金支払開始日");
        exStringEquals(khKoujyosyoumeisyoBean.getIrPhrkkkn(), "12", "（ＩＲ）保険料払込期間");
        exStringEquals(khKoujyosyoumeisyoBean.getIrHrkhou(), "月払", "（ＩＲ）払込方法");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewippanseimeip(), "", "（ＩＲ）一般生命保険料（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewippanhaitoukin(), "", "（ＩＲ）一般配当金（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewippansyoumeigk(), "**********", "（ＩＲ）一般証明額（新制度）");

        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnenkanippanseimeip(), "", "（ＩＲ）年間一般生命保険料（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnenkanippanhaitoukin(), "", "（ＩＲ）年間一般配当金（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewippansinkokugk(), "**********", "（ＩＲ）一般申告額（新制度）");

        exStringEquals(khKoujyosyoumeisyoBean.getIrNewiryouseimeip(), "", "（ＩＲ）介護医療保険料（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewiryouhaitoukin(), "", "（ＩＲ）介護医療配当金（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewiryousyoumeigk(), "**********", "（ＩＲ）介護医療証明額（新制度）");

        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnenkaniryouseimeip(), "", "（ＩＲ）年間介護医療保険料（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnenkaniryouhaitoukin(), "", "（ＩＲ）年間介護医療配当金（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewiryousinkokugk(), "**********", "（ＩＲ）介護医療申告額（新制度）");

        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnkseimeip(), "", "（ＩＲ）個人年金保険料（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnkhaitoukin(), "", "（ＩＲ）年金配当金（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnksyoumeigk(), "**********", "（ＩＲ）個人年金証明額（新制度）");

        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnenkannkseimeip(), "", "（ＩＲ）年間個人年金保険料（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnenkannkhaitoukin(), "", "（ＩＲ）年間年金配当金（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrNewnksinkokugk(), "**********", "（ＩＲ）個人年金申告額（新制度）");

        exStringEquals(khKoujyosyoumeisyoBean.getIrNewhknjytuKikan(), "2016年 4月から12年分", "（ＩＲ）保険充当期間（新制度）");
        exStringEquals(khKoujyosyoumeisyoBean.getIrPhrkkknjyoutai(), "払込停止", "（ＩＲ）保険料払込状態");
        exStringEquals(khKoujyosyoumeisyoBean.getIrSyoumeiymd(), "2016年 4月 3日", "（ＩＲ）証明日");
        exStringEquals(khKoujyosyoumeisyoBean.getIrUktmidasi(), "年金", "（ＩＲ）受取人見出し");
        exStringEquals(khKoujyosyoumeisyoBean.getIrMidasisub(), "", "（ＩＲ）見出し副題");
        exStringEquals(khKoujyosyoumeisyoBean.getIrKoujyosyoumeifreearea1(), "", "（ＩＲ）控除証明フリーエリア１");

        BzKokyakuAtesakiBean kokyakuAtesakiBean = (BzKokyakuAtesakiBean)kHSBean[1];

        exStringEquals(kokyakuAtesakiBean.getIrTyouhyousakuseiymd(), "2016年 4月18日", "（ＩＲ）帳票作成日");
        exStringEquals(kokyakuAtesakiBean.getIrShsyno(), "1234567", "（ＩＲ）送付先郵便番号");
        exStringEquals(kokyakuAtesakiBean.getIrShadr1kj(), "通信先住所１", "（ＩＲ）送付先住所１（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrShadr2kj(), "通信先住所２", "（ＩＲ）送付先住所２（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrShadr3kj(), "通信先住所３", "（ＩＲ）送付先住所３（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrShsnmkj(), "契約者名", "（ＩＲ）送付先氏名（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrToiawaseyno(), "7654321", "（ＩＲ）問合せ先郵便番号");
        exStringEquals(kokyakuAtesakiBean.getIrToiawaseadr1kj(), "問合せ先住所１", "（ＩＲ）問合せ先住所１（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrToiawaseadr2kj(), "問合せ先住所２", "（ＩＲ）問合せ先住所２（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrToiawaseadr3kj(), "問合せ先住所３", "（ＩＲ）問合せ先住所３（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrHknkisynm(), "住友生命保険相互会社", "（ＩＲ）保険会社名称");
        exStringEquals(kokyakuAtesakiBean.getIrToiawasesosiki(), "漢字組織名", "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(kokyakuAtesakiBean.getIrToiawasetelno(), "111-2222-3333", "（ＩＲ）問合せ先電話番号");

    }
}
