package yuyu.common.siharai.siedittyouhyou;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.bean.report.BzSksKaisyasiyouranBean;
import yuyu.def.classification.C_HassinsakiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.siharai.bean.report.SiHubiteiseiBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 不備訂正書編集のメソッド{@link EditHubiTeiseisyo#exec(HubiTeiseisyoBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditHubiTeiseisyoTest_exec {
    @Inject
    private EditHubiTeiseisyo editHubiTeiseisyo;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_不備訂正書編集";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
            baseDomManager.delete(baseDomManager.getAllSequences());

            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditHubiTeiseisyoTest_exec.class, fileName, sheetName);
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

        baseDomManager.delete(baseDomManager.getSyoruiZokusei(C_SyoruiCdKbn.KK_SBKAIJYO_HB));
    }

    @Test(expected = BizAppException.class)
    @TestOrder(10)
    public void testExec_A1() {
        HubiTeiseisyoBean editHubiTeiseisyoBean = SWAKInjector.getInstance(HubiTeiseisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(null);
        editHubiTeiseisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        try {
            editHubiTeiseisyo.exec(editHubiTeiseisyoBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='syoriYmd'", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(20)
    public void testExec_A2() {
        HubiTeiseisyoBean editHubiTeiseisyoBean = SWAKInjector.getInstance(HubiTeiseisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151218));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(null);
        editHubiTeiseisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        try {
            editHubiTeiseisyo.exec(editHubiTeiseisyoBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='syoruiCd'", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(30)
    public void testExec_A3() {
        HubiTeiseisyoBean editHubiTeiseisyoBean = SWAKInjector.getInstance(HubiTeiseisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151218));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.BLNK);
        editHubiTeiseisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        try {
            editHubiTeiseisyo.exec(editHubiTeiseisyoBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='syoruiCd'", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(40)
    public void testExec_B1() {
        HubiTeiseisyoBean hubiTeiseisyoBean = SWAKInjector.getInstance(HubiTeiseisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151218));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.KK_SBKAIJYO_HB);
        hubiTeiseisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        hubiTeiseisyoBean.setSyono("11807111118");
        hubiTeiseisyoBean.setSeikyuusyanmKj("請求者漢字");
        hubiTeiseisyoBean.setHubiTeiseisyoItiranLst(new ArrayList<EditHubiTeiseisyoItiranBean>());
        hubiTeiseisyoBean.setKarisakusei(false);
        hubiTeiseisyoBean.setToritsugisyakjncd("110001");
        hubiTeiseisyoBean.setToritsugisyakjnmei("取次者個人名");
        hubiTeiseisyoBean.setToritsugisyaSosikinm("取次者組織名");

        EditHubiTeiseisyoBean editHubiTeiseisyoBean = editHubiTeiseisyo.exec(hubiTeiseisyoBean);
        assertNull("帳票サービスBean（顧客）",editHubiTeiseisyoBean.getReportServicesBeanKok());
        assertNull("帳票サービスBean（支社）",editHubiTeiseisyoBean.getReportServicesBeanSisya());
        assertNull("帳票サービスBean（本社事務部門）",editHubiTeiseisyoBean.getReportServicesBeanHonsya());
    }

    @Test
    @TestOrder(50)
    public void testExec_B2() {
        HubiTeiseisyoBean hubiTeiseisyoBean = SWAKInjector.getInstance(HubiTeiseisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151218));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.KK_SBKAIJYO_HB);
        hubiTeiseisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        hubiTeiseisyoBean.setSyono("11807111118");
        hubiTeiseisyoBean.setSeikyuusyanmKj("請求者漢字");
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean.setHubinaiyoumsg("不備内容メッセージ1");
        editHubiTeiseisyoItiranBean.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean.setHassinsakiKbn(C_HassinsakiKbn.KOK);
        List<EditHubiTeiseisyoItiranBean> list = new ArrayList<>();
        list.add(editHubiTeiseisyoItiranBean);
        hubiTeiseisyoBean.setHubiTeiseisyoItiranLst(list);
        hubiTeiseisyoBean.setKarisakusei(false);
        hubiTeiseisyoBean.setToritsugisyakjncd("110001");
        hubiTeiseisyoBean.setToritsugisyakjnmei("取次者個人名");
        hubiTeiseisyoBean.setToritsugisyaSosikinm("取次者組織名");

        EditHubiTeiseisyoBean editHubiTeiseisyoBean = editHubiTeiseisyo.exec(hubiTeiseisyoBean);
        ReportServicesBean reportServicesBeanKok = editHubiTeiseisyoBean.getReportServicesBeanKok();
        assertNull("帳票サービスBean（支社）",editHubiTeiseisyoBean.getReportServicesBeanSisya());
        assertNull("帳票サービスBean（本社事務部門）",editHubiTeiseisyoBean.getReportServicesBeanHonsya());
        exStringEquals(reportServicesBeanKok.getKensakuKeys()[0], "11807111118", "検索キー[0]");
        exDateEquals(reportServicesBeanKok.getSyoriYmd(),BizDate.valueOf(20151218),"処理日付");
        SiHubiteiseiBean siHubiteiseiBean = (SiHubiteiseiBean) reportServicesBeanKok.getParamObjectsData()
            .get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[0];
        exStringEquals(siHubiteiseiBean.getIrSyono(),"11807111118","（ＩＲ）証券番号");
        exStringEquals(siHubiteiseiBean.getIrSeikyuusyanmkj(),"請求者漢字","（ＩＲ）請求者（漢字）");
        exNumericEquals(siHubiteiseiBean.getIrRenno1(),1,"（ＩＲ）連番１");
        assertNull("（ＩＲ）連番２",siHubiteiseiBean.getIrRenno2());
        assertNull("（ＩＲ）連番３",siHubiteiseiBean.getIrRenno3());
        assertNull("（ＩＲ）連番４",siHubiteiseiBean.getIrRenno4());
        assertNull("（ＩＲ）連番５",siHubiteiseiBean.getIrRenno5());
        assertNull("（ＩＲ）連番６",siHubiteiseiBean.getIrRenno6());
        assertNull("（ＩＲ）連番７",siHubiteiseiBean.getIrRenno7());
        assertNull("（ＩＲ）連番８",siHubiteiseiBean.getIrRenno8());
        assertNull("（ＩＲ）連番９",siHubiteiseiBean.getIrRenno9());
        assertNull("（ＩＲ）連番１０",siHubiteiseiBean.getIrRenno10());
        exStringEquals(siHubiteiseiBean.getIrHubimsg1(),"不備内容メッセージ1","（ＩＲ）不備メッセージ１");
        exStringEquals(siHubiteiseiBean.getIrHubimsg2(),null,"（ＩＲ）不備メッセージ２");
        exStringEquals(siHubiteiseiBean.getIrHubimsg3(),null,"（ＩＲ）不備メッセージ３");
        exStringEquals(siHubiteiseiBean.getIrHubimsg4(),null,"（ＩＲ）不備メッセージ４");
        exStringEquals(siHubiteiseiBean.getIrHubimsg5(),null,"（ＩＲ）不備メッセージ５");
        exStringEquals(siHubiteiseiBean.getIrHubimsg6(),null,"（ＩＲ）不備メッセージ６");
        exStringEquals(siHubiteiseiBean.getIrHubimsg7(),null,"（ＩＲ）不備メッセージ７");
        exStringEquals(siHubiteiseiBean.getIrHubimsg8(),null,"（ＩＲ）不備メッセージ８");
        exStringEquals(siHubiteiseiBean.getIrHubimsg9(),null,"（ＩＲ）不備メッセージ９");
        exStringEquals(siHubiteiseiBean.getIrHubimsg10(),null,"（ＩＲ）不備メッセージ１０");
        exClassificationEquals(siHubiteiseiBean.getIrPageinfohyoujiumu(),C_UmuKbn.NONE,"（ＩＲ）ページ情報表示有無");
        exClassificationEquals(siHubiteiseiBean.getIrKarisakuseiumu(),C_UmuKbn.NONE,"（ＩＲ）仮作成有無");
        exClassificationEquals(siHubiteiseiBean.getIrGenponhnkykumu(),C_UmuKbn.NONE,"（ＩＲ）原本返却有無");
        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean) reportServicesBeanKok
            .getParamObjectsData().get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[1];
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(),"取次者組織名","（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(),"110001","（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(),"取次者個人名","（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(),"2015年12月18日","（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(),"5 年","（ＩＲ）保存期間");
    }

    @Test
    @TestOrder(60)
    public void testExec_B3() {
        HubiTeiseisyoBean hubiTeiseisyoBean = SWAKInjector.getInstance(HubiTeiseisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151218));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.KK_SBKAIJYO_HB);
        hubiTeiseisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        hubiTeiseisyoBean.setSyono("11807111118");
        hubiTeiseisyoBean.setSeikyuusyanmKj("請求者漢字");
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean.setHubinaiyoumsg("不備内容メッセージ1");
        editHubiTeiseisyoItiranBean.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean.setHassinsakiKbn(C_HassinsakiKbn.KOK);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean2 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean2.setHubinaiyoumsg("不備内容メッセージ2");
        editHubiTeiseisyoItiranBean2.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean2.setHassinsakiKbn(C_HassinsakiKbn.KOK);
        List<EditHubiTeiseisyoItiranBean> list = new ArrayList<>();
        list.add(editHubiTeiseisyoItiranBean);
        list.add(editHubiTeiseisyoItiranBean2);
        hubiTeiseisyoBean.setHubiTeiseisyoItiranLst(list);
        hubiTeiseisyoBean.setKarisakusei(false);
        hubiTeiseisyoBean.setToritsugisyakjncd("110001");
        hubiTeiseisyoBean.setToritsugisyakjnmei("取次者個人名");
        hubiTeiseisyoBean.setToritsugisyaSosikinm("取次者組織名");

        EditHubiTeiseisyoBean editHubiTeiseisyoBean = editHubiTeiseisyo.exec(hubiTeiseisyoBean);
        ReportServicesBean reportServicesBeanKok = editHubiTeiseisyoBean.getReportServicesBeanKok();
        assertNull("帳票サービスBean（支社）",editHubiTeiseisyoBean.getReportServicesBeanSisya());
        assertNull("帳票サービスBean（本社事務部門）",editHubiTeiseisyoBean.getReportServicesBeanHonsya());
        exStringEquals(reportServicesBeanKok.getKensakuKeys()[0], "11807111118", "検索キー[0]");
        exDateEquals(reportServicesBeanKok.getSyoriYmd(),BizDate.valueOf(20151218),"処理日付");
        SiHubiteiseiBean siHubiteiseiBean = (SiHubiteiseiBean) reportServicesBeanKok.getParamObjectsData()
            .get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[0];
        exStringEquals(siHubiteiseiBean.getIrSyono(),"11807111118","（ＩＲ）証券番号");
        exStringEquals(siHubiteiseiBean.getIrSeikyuusyanmkj(),"請求者漢字","（ＩＲ）請求者（漢字）");
        exNumericEquals(siHubiteiseiBean.getIrRenno1(),1,"（ＩＲ）連番１");
        exNumericEquals(siHubiteiseiBean.getIrRenno2(),2,"（ＩＲ）連番２");
        assertNull("（ＩＲ）連番３",siHubiteiseiBean.getIrRenno3());
        assertNull("（ＩＲ）連番４",siHubiteiseiBean.getIrRenno4());
        assertNull("（ＩＲ）連番５",siHubiteiseiBean.getIrRenno5());
        assertNull("（ＩＲ）連番６",siHubiteiseiBean.getIrRenno6());
        assertNull("（ＩＲ）連番７",siHubiteiseiBean.getIrRenno7());
        assertNull("（ＩＲ）連番８",siHubiteiseiBean.getIrRenno8());
        assertNull("（ＩＲ）連番９",siHubiteiseiBean.getIrRenno9());
        assertNull("（ＩＲ）連番１０",siHubiteiseiBean.getIrRenno10());
        exStringEquals(siHubiteiseiBean.getIrHubimsg1(),"不備内容メッセージ1","（ＩＲ）不備メッセージ１");
        exStringEquals(siHubiteiseiBean.getIrHubimsg2(),"不備内容メッセージ2","（ＩＲ）不備メッセージ２");
        exStringEquals(siHubiteiseiBean.getIrHubimsg3(),null,"（ＩＲ）不備メッセージ３");
        exStringEquals(siHubiteiseiBean.getIrHubimsg4(),null,"（ＩＲ）不備メッセージ４");
        exStringEquals(siHubiteiseiBean.getIrHubimsg5(),null,"（ＩＲ）不備メッセージ５");
        exStringEquals(siHubiteiseiBean.getIrHubimsg6(),null,"（ＩＲ）不備メッセージ６");
        exStringEquals(siHubiteiseiBean.getIrHubimsg7(),null,"（ＩＲ）不備メッセージ７");
        exStringEquals(siHubiteiseiBean.getIrHubimsg8(),null,"（ＩＲ）不備メッセージ８");
        exStringEquals(siHubiteiseiBean.getIrHubimsg9(),null,"（ＩＲ）不備メッセージ９");
        exStringEquals(siHubiteiseiBean.getIrHubimsg10(),null,"（ＩＲ）不備メッセージ１０");
        exClassificationEquals(siHubiteiseiBean.getIrPageinfohyoujiumu(),C_UmuKbn.NONE,"（ＩＲ）ページ情報表示有無");
        exClassificationEquals(siHubiteiseiBean.getIrKarisakuseiumu(),C_UmuKbn.NONE,"（ＩＲ）仮作成有無");
        exClassificationEquals(siHubiteiseiBean.getIrGenponhnkykumu(),C_UmuKbn.NONE,"（ＩＲ）原本返却有無");
        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean) reportServicesBeanKok
            .getParamObjectsData().get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[1];
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(),"取次者組織名","（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(),"110001","（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(),"取次者個人名","（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(),"2015年12月18日","（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(),"5 年","（ＩＲ）保存期間");
    }

    @Test
    @TestOrder(70)
    public void testExec_B4() {
        HubiTeiseisyoBean hubiTeiseisyoBean = SWAKInjector.getInstance(HubiTeiseisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151218));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.KK_SBKAIJYO_HB);
        hubiTeiseisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        hubiTeiseisyoBean.setSyono("11807111118");
        hubiTeiseisyoBean.setSeikyuusyanmKj("請求者漢字");
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean.setHubinaiyoumsg("不備内容メッセージ1");
        editHubiTeiseisyoItiranBean.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean.setHassinsakiKbn(C_HassinsakiKbn.KOK);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean2 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean2.setHubinaiyoumsg("不備内容メッセージ2");
        editHubiTeiseisyoItiranBean2.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean2.setHassinsakiKbn(C_HassinsakiKbn.KOK);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean3 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean3.setHubinaiyoumsg("不備内容メッセージ3");
        editHubiTeiseisyoItiranBean3.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean3.setHassinsakiKbn(C_HassinsakiKbn.KOK);
        List<EditHubiTeiseisyoItiranBean> list = new ArrayList<>();
        list.add(editHubiTeiseisyoItiranBean);
        list.add(editHubiTeiseisyoItiranBean2);
        list.add(editHubiTeiseisyoItiranBean3);
        hubiTeiseisyoBean.setHubiTeiseisyoItiranLst(list);
        hubiTeiseisyoBean.setKarisakusei(false);
        hubiTeiseisyoBean.setToritsugisyakjncd("110001");
        hubiTeiseisyoBean.setToritsugisyakjnmei("取次者個人名");
        hubiTeiseisyoBean.setToritsugisyaSosikinm("取次者組織名");

        EditHubiTeiseisyoBean editHubiTeiseisyoBean = editHubiTeiseisyo.exec(hubiTeiseisyoBean);
        ReportServicesBean reportServicesBeanKok = editHubiTeiseisyoBean.getReportServicesBeanKok();
        assertNull("帳票サービスBean（支社）",editHubiTeiseisyoBean.getReportServicesBeanSisya());
        assertNull("帳票サービスBean（本社事務部門）",editHubiTeiseisyoBean.getReportServicesBeanHonsya());
        exStringEquals(reportServicesBeanKok.getKensakuKeys()[0], "11807111118", "検索キー[0]");
        exDateEquals(reportServicesBeanKok.getSyoriYmd(),BizDate.valueOf(20151218),"処理日付");
        SiHubiteiseiBean siHubiteiseiBean = (SiHubiteiseiBean) reportServicesBeanKok.getParamObjectsData()
            .get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[0];
        exStringEquals(siHubiteiseiBean.getIrSyono(),"11807111118","（ＩＲ）証券番号");
        exStringEquals(siHubiteiseiBean.getIrSeikyuusyanmkj(),"請求者漢字","（ＩＲ）請求者（漢字）");
        exNumericEquals(siHubiteiseiBean.getIrRenno1(),1,"（ＩＲ）連番１");
        exNumericEquals(siHubiteiseiBean.getIrRenno2(),2,"（ＩＲ）連番２");
        exNumericEquals(siHubiteiseiBean.getIrRenno3(),3,"（ＩＲ）連番３");
        assertNull("（ＩＲ）連番４",siHubiteiseiBean.getIrRenno4());
        assertNull("（ＩＲ）連番５",siHubiteiseiBean.getIrRenno5());
        assertNull("（ＩＲ）連番６",siHubiteiseiBean.getIrRenno6());
        assertNull("（ＩＲ）連番７",siHubiteiseiBean.getIrRenno7());
        assertNull("（ＩＲ）連番８",siHubiteiseiBean.getIrRenno8());
        assertNull("（ＩＲ）連番９",siHubiteiseiBean.getIrRenno9());
        assertNull("（ＩＲ）連番１０",siHubiteiseiBean.getIrRenno10());
        exStringEquals(siHubiteiseiBean.getIrHubimsg1(),"不備内容メッセージ1","（ＩＲ）不備メッセージ１");
        exStringEquals(siHubiteiseiBean.getIrHubimsg2(),"不備内容メッセージ2","（ＩＲ）不備メッセージ２");
        exStringEquals(siHubiteiseiBean.getIrHubimsg3(),"不備内容メッセージ3","（ＩＲ）不備メッセージ３");
        exStringEquals(siHubiteiseiBean.getIrHubimsg4(),null,"（ＩＲ）不備メッセージ４");
        exStringEquals(siHubiteiseiBean.getIrHubimsg5(),null,"（ＩＲ）不備メッセージ５");
        exStringEquals(siHubiteiseiBean.getIrHubimsg6(),null,"（ＩＲ）不備メッセージ６");
        exStringEquals(siHubiteiseiBean.getIrHubimsg7(),null,"（ＩＲ）不備メッセージ７");
        exStringEquals(siHubiteiseiBean.getIrHubimsg8(),null,"（ＩＲ）不備メッセージ８");
        exStringEquals(siHubiteiseiBean.getIrHubimsg9(),null,"（ＩＲ）不備メッセージ９");
        exStringEquals(siHubiteiseiBean.getIrHubimsg10(),null,"（ＩＲ）不備メッセージ１０");
        exClassificationEquals(siHubiteiseiBean.getIrPageinfohyoujiumu(),C_UmuKbn.NONE,"（ＩＲ）ページ情報表示有無");
        exClassificationEquals(siHubiteiseiBean.getIrKarisakuseiumu(),C_UmuKbn.NONE,"（ＩＲ）仮作成有無");
        exClassificationEquals(siHubiteiseiBean.getIrGenponhnkykumu(),C_UmuKbn.NONE,"（ＩＲ）原本返却有無");
        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean) reportServicesBeanKok
            .getParamObjectsData().get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[1];
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(),"取次者組織名","（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(),"110001","（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(),"取次者個人名","（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(),"2015年12月18日","（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(),"5 年","（ＩＲ）保存期間");
    }

    @Test
    @TestOrder(80)
    public void testExec_B5() {
        HubiTeiseisyoBean hubiTeiseisyoBean = SWAKInjector.getInstance(HubiTeiseisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151218));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.KK_SBKAIJYO_HB);
        hubiTeiseisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        hubiTeiseisyoBean.setSyono("11807111118");
        hubiTeiseisyoBean.setSeikyuusyanmKj("請求者漢字");
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean.setHubinaiyoumsg("不備内容メッセージ1");
        editHubiTeiseisyoItiranBean.setGenponhnkykumu(C_UmuKbn.ARI);
        editHubiTeiseisyoItiranBean.setHassinsakiKbn(C_HassinsakiKbn.KOK);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean2 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean2.setHubinaiyoumsg("不備内容メッセージ2");
        editHubiTeiseisyoItiranBean2.setGenponhnkykumu(C_UmuKbn.ARI);
        editHubiTeiseisyoItiranBean2.setHassinsakiKbn(C_HassinsakiKbn.KOK);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean3 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean3.setHubinaiyoumsg("不備内容メッセージ3");
        editHubiTeiseisyoItiranBean3.setGenponhnkykumu(C_UmuKbn.ARI);
        editHubiTeiseisyoItiranBean3.setHassinsakiKbn(C_HassinsakiKbn.KOK);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean4 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean4.setHubinaiyoumsg("不備内容メッセージ4");
        editHubiTeiseisyoItiranBean4.setGenponhnkykumu(C_UmuKbn.ARI);
        editHubiTeiseisyoItiranBean4.setHassinsakiKbn(C_HassinsakiKbn.KOK);
        List<EditHubiTeiseisyoItiranBean> list = new ArrayList<>();
        list.add(editHubiTeiseisyoItiranBean);
        list.add(editHubiTeiseisyoItiranBean2);
        list.add(editHubiTeiseisyoItiranBean3);
        list.add(editHubiTeiseisyoItiranBean4);
        hubiTeiseisyoBean.setHubiTeiseisyoItiranLst(list);
        hubiTeiseisyoBean.setKarisakusei(true);
        hubiTeiseisyoBean.setToritsugisyakjncd("110001");
        hubiTeiseisyoBean.setToritsugisyakjnmei("取次者個人名");
        hubiTeiseisyoBean.setToritsugisyaSosikinm("取次者組織名");

        EditHubiTeiseisyoBean editHubiTeiseisyoBean = editHubiTeiseisyo.exec(hubiTeiseisyoBean);
        ReportServicesBean reportServicesBeanKok = editHubiTeiseisyoBean.getReportServicesBeanKok();
        assertNull("帳票サービスBean（支社）",editHubiTeiseisyoBean.getReportServicesBeanSisya());
        assertNull("帳票サービスBean（本社事務部門）",editHubiTeiseisyoBean.getReportServicesBeanHonsya());
        exStringEquals(reportServicesBeanKok.getKensakuKeys()[0], "11807111118", "検索キー[0]");
        exDateEquals(reportServicesBeanKok.getSyoriYmd(),BizDate.valueOf(20151218),"処理日付");
        SiHubiteiseiBean siHubiteiseiBean = (SiHubiteiseiBean) reportServicesBeanKok.getParamObjectsData()
            .get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[0];
        exStringEquals(siHubiteiseiBean.getIrSyono(),"11807111118","（ＩＲ）証券番号");
        exStringEquals(siHubiteiseiBean.getIrSeikyuusyanmkj(),"請求者漢字","（ＩＲ）請求者（漢字）");
        exNumericEquals(siHubiteiseiBean.getIrRenno1(),1,"（ＩＲ）連番１");
        exNumericEquals(siHubiteiseiBean.getIrRenno2(),2,"（ＩＲ）連番２");
        exNumericEquals(siHubiteiseiBean.getIrRenno3(),3,"（ＩＲ）連番３");
        exNumericEquals(siHubiteiseiBean.getIrRenno4(),4,"（ＩＲ）連番４");
        assertNull("（ＩＲ）連番５",siHubiteiseiBean.getIrRenno5());
        assertNull("（ＩＲ）連番６",siHubiteiseiBean.getIrRenno6());
        assertNull("（ＩＲ）連番７",siHubiteiseiBean.getIrRenno7());
        assertNull("（ＩＲ）連番８",siHubiteiseiBean.getIrRenno8());
        assertNull("（ＩＲ）連番９",siHubiteiseiBean.getIrRenno9());
        assertNull("（ＩＲ）連番１０",siHubiteiseiBean.getIrRenno10());
        exStringEquals(siHubiteiseiBean.getIrHubimsg1(),"不備内容メッセージ1","（ＩＲ）不備メッセージ１");
        exStringEquals(siHubiteiseiBean.getIrHubimsg2(),"不備内容メッセージ2","（ＩＲ）不備メッセージ２");
        exStringEquals(siHubiteiseiBean.getIrHubimsg3(),"不備内容メッセージ3","（ＩＲ）不備メッセージ３");
        exStringEquals(siHubiteiseiBean.getIrHubimsg4(),"不備内容メッセージ4","（ＩＲ）不備メッセージ４");
        exStringEquals(siHubiteiseiBean.getIrHubimsg5(),null,"（ＩＲ）不備メッセージ５");
        exStringEquals(siHubiteiseiBean.getIrHubimsg6(),null,"（ＩＲ）不備メッセージ６");
        exStringEquals(siHubiteiseiBean.getIrHubimsg7(),null,"（ＩＲ）不備メッセージ７");
        exStringEquals(siHubiteiseiBean.getIrHubimsg8(),null,"（ＩＲ）不備メッセージ８");
        exStringEquals(siHubiteiseiBean.getIrHubimsg9(),null,"（ＩＲ）不備メッセージ９");
        exStringEquals(siHubiteiseiBean.getIrHubimsg10(),null,"（ＩＲ）不備メッセージ１０");
        exClassificationEquals(siHubiteiseiBean.getIrPageinfohyoujiumu(),C_UmuKbn.NONE,"（ＩＲ）ページ情報表示有無");
        exClassificationEquals(siHubiteiseiBean.getIrKarisakuseiumu(),C_UmuKbn.ARI,"（ＩＲ）仮作成有無");
        exClassificationEquals(siHubiteiseiBean.getIrGenponhnkykumu(),C_UmuKbn.ARI,"（ＩＲ）原本返却有無");
        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean) reportServicesBeanKok
            .getParamObjectsData().get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[1];
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(),"取次者組織名","（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(),"110001","（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(),"取次者個人名","（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(),"2015年12月18日","（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(),"5 年","（ＩＲ）保存期間");
    }

    @Test
    @TestOrder(90)
    public void testExec_B6() {
        HubiTeiseisyoBean hubiTeiseisyoBean = SWAKInjector.getInstance(HubiTeiseisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151218));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.KK_SBKAIJYO_HB);
        hubiTeiseisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        hubiTeiseisyoBean.setSyono("11807111118");
        hubiTeiseisyoBean.setSeikyuusyanmKj("請求者漢字");
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean.setHubinaiyoumsg("不備内容メッセージ1");
        editHubiTeiseisyoItiranBean.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean.setHassinsakiKbn(C_HassinsakiKbn.KOK);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean2 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean2.setHubinaiyoumsg("不備内容メッセージ2");
        editHubiTeiseisyoItiranBean2.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean2.setHassinsakiKbn(C_HassinsakiKbn.KOK);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean3 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean3.setHubinaiyoumsg("不備内容メッセージ3");
        editHubiTeiseisyoItiranBean3.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean3.setHassinsakiKbn(C_HassinsakiKbn.KOK);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean4 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean4.setHubinaiyoumsg("不備内容メッセージ4");
        editHubiTeiseisyoItiranBean4.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean4.setHassinsakiKbn(C_HassinsakiKbn.KOK);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean5 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean5.setHubinaiyoumsg("不備内容メッセージ5");
        editHubiTeiseisyoItiranBean5.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean5.setHassinsakiKbn(C_HassinsakiKbn.KOK);
        List<EditHubiTeiseisyoItiranBean> list = new ArrayList<>();
        list.add(editHubiTeiseisyoItiranBean);
        list.add(editHubiTeiseisyoItiranBean2);
        list.add(editHubiTeiseisyoItiranBean3);
        list.add(editHubiTeiseisyoItiranBean4);
        list.add(editHubiTeiseisyoItiranBean5);
        hubiTeiseisyoBean.setHubiTeiseisyoItiranLst(list);
        hubiTeiseisyoBean.setKarisakusei(false);
        hubiTeiseisyoBean.setToritsugisyakjncd("110001");
        hubiTeiseisyoBean.setToritsugisyakjnmei("取次者個人名");
        hubiTeiseisyoBean.setToritsugisyaSosikinm("取次者組織名");

        EditHubiTeiseisyoBean editHubiTeiseisyoBean = editHubiTeiseisyo.exec(hubiTeiseisyoBean);
        ReportServicesBean reportServicesBeanKok = editHubiTeiseisyoBean.getReportServicesBeanKok();
        assertNull("帳票サービスBean（支社）",editHubiTeiseisyoBean.getReportServicesBeanSisya());
        assertNull("帳票サービスBean（本社事務部門）",editHubiTeiseisyoBean.getReportServicesBeanHonsya());
        exStringEquals(reportServicesBeanKok.getKensakuKeys()[0], "11807111118", "検索キー[0]");
        exDateEquals(reportServicesBeanKok.getSyoriYmd(),BizDate.valueOf(20151218),"処理日付");
        SiHubiteiseiBean siHubiteiseiBean = (SiHubiteiseiBean) reportServicesBeanKok.getParamObjectsData()
            .get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[0];
        exStringEquals(siHubiteiseiBean.getIrSyono(),"11807111118","（ＩＲ）証券番号");
        exStringEquals(siHubiteiseiBean.getIrSeikyuusyanmkj(),"請求者漢字","（ＩＲ）請求者（漢字）");
        exNumericEquals(siHubiteiseiBean.getIrRenno1(),1,"（ＩＲ）連番１");
        exNumericEquals(siHubiteiseiBean.getIrRenno2(),2,"（ＩＲ）連番２");
        exNumericEquals(siHubiteiseiBean.getIrRenno3(),3,"（ＩＲ）連番３");
        exNumericEquals(siHubiteiseiBean.getIrRenno4(),4,"（ＩＲ）連番４");
        exNumericEquals(siHubiteiseiBean.getIrRenno5(),5,"（ＩＲ）連番５");
        assertNull("（ＩＲ）連番６",siHubiteiseiBean.getIrRenno6());
        assertNull("（ＩＲ）連番７",siHubiteiseiBean.getIrRenno7());
        assertNull("（ＩＲ）連番８",siHubiteiseiBean.getIrRenno8());
        assertNull("（ＩＲ）連番９",siHubiteiseiBean.getIrRenno9());
        assertNull("（ＩＲ）連番１０",siHubiteiseiBean.getIrRenno10());
        exStringEquals(siHubiteiseiBean.getIrHubimsg1(),"不備内容メッセージ1","（ＩＲ）不備メッセージ１");
        exStringEquals(siHubiteiseiBean.getIrHubimsg2(),"不備内容メッセージ2","（ＩＲ）不備メッセージ２");
        exStringEquals(siHubiteiseiBean.getIrHubimsg3(),"不備内容メッセージ3","（ＩＲ）不備メッセージ３");
        exStringEquals(siHubiteiseiBean.getIrHubimsg4(),"不備内容メッセージ4","（ＩＲ）不備メッセージ４");
        exStringEquals(siHubiteiseiBean.getIrHubimsg5(),"不備内容メッセージ5","（ＩＲ）不備メッセージ５");
        exStringEquals(siHubiteiseiBean.getIrHubimsg6(),null,"（ＩＲ）不備メッセージ６");
        exStringEquals(siHubiteiseiBean.getIrHubimsg7(),null,"（ＩＲ）不備メッセージ７");
        exStringEquals(siHubiteiseiBean.getIrHubimsg8(),null,"（ＩＲ）不備メッセージ８");
        exStringEquals(siHubiteiseiBean.getIrHubimsg9(),null,"（ＩＲ）不備メッセージ９");
        exStringEquals(siHubiteiseiBean.getIrHubimsg10(),null,"（ＩＲ）不備メッセージ１０");
        exClassificationEquals(siHubiteiseiBean.getIrPageinfohyoujiumu(),C_UmuKbn.NONE,"（ＩＲ）ページ情報表示有無");
        exClassificationEquals(siHubiteiseiBean.getIrKarisakuseiumu(),C_UmuKbn.NONE,"（ＩＲ）仮作成有無");
        exClassificationEquals(siHubiteiseiBean.getIrGenponhnkykumu(),C_UmuKbn.NONE,"（ＩＲ）原本返却有無");
        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean) reportServicesBeanKok
            .getParamObjectsData().get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[1];
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(),"取次者組織名","（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(),"110001","（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(),"取次者個人名","（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(),"2015年12月18日","（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(),"5 年","（ＩＲ）保存期間");
    }

    @Test
    @TestOrder(100)
    public void testExec_B7() {
        HubiTeiseisyoBean hubiTeiseisyoBean = SWAKInjector.getInstance(HubiTeiseisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151218));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.KK_SBKAIJYO_HB);
        hubiTeiseisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        hubiTeiseisyoBean.setSyono("11807111118");
        hubiTeiseisyoBean.setSeikyuusyanmKj("請求者漢字");
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean.setHubinaiyoumsg("不備内容メッセージ1");
        editHubiTeiseisyoItiranBean.setGenponhnkykumu(C_UmuKbn.ARI);
        editHubiTeiseisyoItiranBean.setHassinsakiKbn(C_HassinsakiKbn.KOK);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean2 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean2.setHubinaiyoumsg("不備内容メッセージ2");
        editHubiTeiseisyoItiranBean2.setGenponhnkykumu(C_UmuKbn.ARI);
        editHubiTeiseisyoItiranBean2.setHassinsakiKbn(C_HassinsakiKbn.KOK);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean3 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean3.setHubinaiyoumsg("不備内容メッセージ3");
        editHubiTeiseisyoItiranBean3.setGenponhnkykumu(C_UmuKbn.ARI);
        editHubiTeiseisyoItiranBean3.setHassinsakiKbn(C_HassinsakiKbn.KOK);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean4 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean4.setHubinaiyoumsg("不備内容メッセージ4");
        editHubiTeiseisyoItiranBean4.setGenponhnkykumu(C_UmuKbn.ARI);
        editHubiTeiseisyoItiranBean4.setHassinsakiKbn(C_HassinsakiKbn.KOK);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean5 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean5.setHubinaiyoumsg("不備内容メッセージ5");
        editHubiTeiseisyoItiranBean5.setGenponhnkykumu(C_UmuKbn.ARI);
        editHubiTeiseisyoItiranBean5.setHassinsakiKbn(C_HassinsakiKbn.KOK);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean6 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean6.setHubinaiyoumsg("不備内容メッセージ6");
        editHubiTeiseisyoItiranBean6.setGenponhnkykumu(C_UmuKbn.ARI);
        editHubiTeiseisyoItiranBean6.setHassinsakiKbn(C_HassinsakiKbn.KOK);
        List<EditHubiTeiseisyoItiranBean> list = new ArrayList<>();
        list.add(editHubiTeiseisyoItiranBean);
        list.add(editHubiTeiseisyoItiranBean2);
        list.add(editHubiTeiseisyoItiranBean3);
        list.add(editHubiTeiseisyoItiranBean4);
        list.add(editHubiTeiseisyoItiranBean5);
        list.add(editHubiTeiseisyoItiranBean6);
        hubiTeiseisyoBean.setHubiTeiseisyoItiranLst(list);
        hubiTeiseisyoBean.setKarisakusei(true);
        hubiTeiseisyoBean.setToritsugisyakjncd("110001");
        hubiTeiseisyoBean.setToritsugisyakjnmei("取次者個人名");
        hubiTeiseisyoBean.setToritsugisyaSosikinm("取次者組織名");

        EditHubiTeiseisyoBean editHubiTeiseisyoBean = editHubiTeiseisyo.exec(hubiTeiseisyoBean);
        ReportServicesBean reportServicesBeanKok = editHubiTeiseisyoBean.getReportServicesBeanKok();
        assertNull("帳票サービスBean（支社）",editHubiTeiseisyoBean.getReportServicesBeanSisya());
        assertNull("帳票サービスBean（本社事務部門）",editHubiTeiseisyoBean.getReportServicesBeanHonsya());
        exStringEquals(reportServicesBeanKok.getKensakuKeys()[0], "11807111118", "検索キー[0]");
        exDateEquals(reportServicesBeanKok.getSyoriYmd(),BizDate.valueOf(20151218),"処理日付");
        SiHubiteiseiBean siHubiteiseiBean = (SiHubiteiseiBean) reportServicesBeanKok.getParamObjectsData()
            .get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[0];
        exStringEquals(siHubiteiseiBean.getIrSyono(),"11807111118","（ＩＲ）証券番号");
        exStringEquals(siHubiteiseiBean.getIrSeikyuusyanmkj(),"請求者漢字","（ＩＲ）請求者（漢字）");
        exNumericEquals(siHubiteiseiBean.getIrRenno1(),1,"（ＩＲ）連番１");
        exNumericEquals(siHubiteiseiBean.getIrRenno2(),2,"（ＩＲ）連番２");
        exNumericEquals(siHubiteiseiBean.getIrRenno3(),3,"（ＩＲ）連番３");
        exNumericEquals(siHubiteiseiBean.getIrRenno4(),4,"（ＩＲ）連番４");
        exNumericEquals(siHubiteiseiBean.getIrRenno5(),5,"（ＩＲ）連番５");
        exNumericEquals(siHubiteiseiBean.getIrRenno6(),6,"（ＩＲ）連番６");
        assertNull("（ＩＲ）連番７",siHubiteiseiBean.getIrRenno7());
        assertNull("（ＩＲ）連番８",siHubiteiseiBean.getIrRenno8());
        assertNull("（ＩＲ）連番９",siHubiteiseiBean.getIrRenno9());
        assertNull("（ＩＲ）連番１０",siHubiteiseiBean.getIrRenno10());
        exStringEquals(siHubiteiseiBean.getIrHubimsg1(),"不備内容メッセージ1","（ＩＲ）不備メッセージ１");
        exStringEquals(siHubiteiseiBean.getIrHubimsg2(),"不備内容メッセージ2","（ＩＲ）不備メッセージ２");
        exStringEquals(siHubiteiseiBean.getIrHubimsg3(),"不備内容メッセージ3","（ＩＲ）不備メッセージ３");
        exStringEquals(siHubiteiseiBean.getIrHubimsg4(),"不備内容メッセージ4","（ＩＲ）不備メッセージ４");
        exStringEquals(siHubiteiseiBean.getIrHubimsg5(),"不備内容メッセージ5","（ＩＲ）不備メッセージ５");
        exStringEquals(siHubiteiseiBean.getIrHubimsg6(),"不備内容メッセージ6","（ＩＲ）不備メッセージ６");
        exStringEquals(siHubiteiseiBean.getIrHubimsg7(),null,"（ＩＲ）不備メッセージ７");
        exStringEquals(siHubiteiseiBean.getIrHubimsg8(),null,"（ＩＲ）不備メッセージ８");
        exStringEquals(siHubiteiseiBean.getIrHubimsg9(),null,"（ＩＲ）不備メッセージ９");
        exStringEquals(siHubiteiseiBean.getIrHubimsg10(),null,"（ＩＲ）不備メッセージ１０");
        exClassificationEquals(siHubiteiseiBean.getIrPageinfohyoujiumu(),C_UmuKbn.ARI,"（ＩＲ）ページ情報表示有無");
        exClassificationEquals(siHubiteiseiBean.getIrKarisakuseiumu(),C_UmuKbn.ARI,"（ＩＲ）仮作成有無");
        exClassificationEquals(siHubiteiseiBean.getIrGenponhnkykumu(),C_UmuKbn.ARI,"（ＩＲ）原本返却有無");
        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean) reportServicesBeanKok
            .getParamObjectsData().get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[1];
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(),"取次者組織名","（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(),"110001","（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(),"取次者個人名","（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(),"2015年12月18日","（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(),"5 年","（ＩＲ）保存期間");
    }

    @Test
    @TestOrder(110)
    public void testExec_B8() {
        HubiTeiseisyoBean hubiTeiseisyoBean = SWAKInjector.getInstance(HubiTeiseisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151218));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.KK_SBKAIJYO_HB);
        hubiTeiseisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        hubiTeiseisyoBean.setSyono("11807111118");
        hubiTeiseisyoBean.setSeikyuusyanmKj("請求者漢字");
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean.setHubinaiyoumsg("不備内容メッセージ1");
        editHubiTeiseisyoItiranBean.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean.setHassinsakiKbn(C_HassinsakiKbn.KOK);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean2 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean2.setHubinaiyoumsg("不備内容メッセージ2");
        editHubiTeiseisyoItiranBean2.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean2.setHassinsakiKbn(C_HassinsakiKbn.KOK);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean3 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean3.setHubinaiyoumsg("不備内容メッセージ3");
        editHubiTeiseisyoItiranBean3.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean3.setHassinsakiKbn(C_HassinsakiKbn.KOK);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean4 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean4.setHubinaiyoumsg("不備内容メッセージ4");
        editHubiTeiseisyoItiranBean4.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean4.setHassinsakiKbn(C_HassinsakiKbn.KOK);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean5 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean5.setHubinaiyoumsg("不備内容メッセージ5");
        editHubiTeiseisyoItiranBean5.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean5.setHassinsakiKbn(C_HassinsakiKbn.KOK);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean6 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean6.setHubinaiyoumsg("不備内容メッセージ6");
        editHubiTeiseisyoItiranBean6.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean6.setHassinsakiKbn(C_HassinsakiKbn.KOK);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean7 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean7.setHubinaiyoumsg("不備内容メッセージ7");
        editHubiTeiseisyoItiranBean7.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean7.setHassinsakiKbn(C_HassinsakiKbn.KOK);
        List<EditHubiTeiseisyoItiranBean> list = new ArrayList<>();
        list.add(editHubiTeiseisyoItiranBean);
        list.add(editHubiTeiseisyoItiranBean2);
        list.add(editHubiTeiseisyoItiranBean3);
        list.add(editHubiTeiseisyoItiranBean4);
        list.add(editHubiTeiseisyoItiranBean5);
        list.add(editHubiTeiseisyoItiranBean6);
        list.add(editHubiTeiseisyoItiranBean7);
        hubiTeiseisyoBean.setHubiTeiseisyoItiranLst(list);
        hubiTeiseisyoBean.setKarisakusei(false);
        hubiTeiseisyoBean.setToritsugisyakjncd("110001");
        hubiTeiseisyoBean.setToritsugisyakjnmei("取次者個人名");
        hubiTeiseisyoBean.setToritsugisyaSosikinm("取次者組織名");

        EditHubiTeiseisyoBean editHubiTeiseisyoBean = editHubiTeiseisyo.exec(hubiTeiseisyoBean);
        ReportServicesBean reportServicesBeanKok = editHubiTeiseisyoBean.getReportServicesBeanKok();
        assertNull("帳票サービスBean（支社）",editHubiTeiseisyoBean.getReportServicesBeanSisya());
        assertNull("帳票サービスBean（本社事務部門）",editHubiTeiseisyoBean.getReportServicesBeanHonsya());
        exStringEquals(reportServicesBeanKok.getKensakuKeys()[0], "11807111118", "検索キー[0]");
        exDateEquals(reportServicesBeanKok.getSyoriYmd(),BizDate.valueOf(20151218),"処理日付");
        SiHubiteiseiBean siHubiteiseiBean = (SiHubiteiseiBean) reportServicesBeanKok.getParamObjectsData()
            .get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[0];
        exStringEquals(siHubiteiseiBean.getIrSyono(),"11807111118","（ＩＲ）証券番号");
        exStringEquals(siHubiteiseiBean.getIrSeikyuusyanmkj(),"請求者漢字","（ＩＲ）請求者（漢字）");
        exNumericEquals(siHubiteiseiBean.getIrRenno1(),1,"（ＩＲ）連番１");
        exNumericEquals(siHubiteiseiBean.getIrRenno2(),2,"（ＩＲ）連番２");
        exNumericEquals(siHubiteiseiBean.getIrRenno3(),3,"（ＩＲ）連番３");
        exNumericEquals(siHubiteiseiBean.getIrRenno4(),4,"（ＩＲ）連番４");
        exNumericEquals(siHubiteiseiBean.getIrRenno5(),5,"（ＩＲ）連番５");
        exNumericEquals(siHubiteiseiBean.getIrRenno6(),6,"（ＩＲ）連番６");
        exNumericEquals(siHubiteiseiBean.getIrRenno7(),7,"（ＩＲ）連番７");
        assertNull("（ＩＲ）連番８",siHubiteiseiBean.getIrRenno8());
        assertNull("（ＩＲ）連番９",siHubiteiseiBean.getIrRenno9());
        assertNull("（ＩＲ）連番１０",siHubiteiseiBean.getIrRenno10());
        exStringEquals(siHubiteiseiBean.getIrHubimsg1(),"不備内容メッセージ1","（ＩＲ）不備メッセージ１");
        exStringEquals(siHubiteiseiBean.getIrHubimsg2(),"不備内容メッセージ2","（ＩＲ）不備メッセージ２");
        exStringEquals(siHubiteiseiBean.getIrHubimsg3(),"不備内容メッセージ3","（ＩＲ）不備メッセージ３");
        exStringEquals(siHubiteiseiBean.getIrHubimsg4(),"不備内容メッセージ4","（ＩＲ）不備メッセージ４");
        exStringEquals(siHubiteiseiBean.getIrHubimsg5(),"不備内容メッセージ5","（ＩＲ）不備メッセージ５");
        exStringEquals(siHubiteiseiBean.getIrHubimsg6(),"不備内容メッセージ6","（ＩＲ）不備メッセージ６");
        exStringEquals(siHubiteiseiBean.getIrHubimsg7(),"不備内容メッセージ7","（ＩＲ）不備メッセージ７");
        exStringEquals(siHubiteiseiBean.getIrHubimsg8(),null,"（ＩＲ）不備メッセージ８");
        exStringEquals(siHubiteiseiBean.getIrHubimsg9(),null,"（ＩＲ）不備メッセージ９");
        exStringEquals(siHubiteiseiBean.getIrHubimsg10(),null,"（ＩＲ）不備メッセージ１０");
        exClassificationEquals(siHubiteiseiBean.getIrPageinfohyoujiumu(),C_UmuKbn.ARI,"（ＩＲ）ページ情報表示有無");
        exClassificationEquals(siHubiteiseiBean.getIrKarisakuseiumu(),C_UmuKbn.NONE,"（ＩＲ）仮作成有無");
        exClassificationEquals(siHubiteiseiBean.getIrGenponhnkykumu(),C_UmuKbn.NONE,"（ＩＲ）原本返却有無");
        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean) reportServicesBeanKok
            .getParamObjectsData().get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[1];
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(),"取次者組織名","（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(),"110001","（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(),"取次者個人名","（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(),"2015年12月18日","（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(),"5 年","（ＩＲ）保存期間");
    }

    @Test
    @TestOrder(120)
    public void testExec_B9() {
        HubiTeiseisyoBean hubiTeiseisyoBean = SWAKInjector.getInstance(HubiTeiseisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151218));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.KK_SBKAIJYO_HB);
        hubiTeiseisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        hubiTeiseisyoBean.setSyono("11807111118");
        hubiTeiseisyoBean.setSeikyuusyanmKj("請求者漢字");
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean.setHubinaiyoumsg("不備内容メッセージ1");
        editHubiTeiseisyoItiranBean.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean.setHassinsakiKbn(C_HassinsakiKbn.KOK);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean2 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean2.setHubinaiyoumsg("不備内容メッセージ2");
        editHubiTeiseisyoItiranBean2.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean2.setHassinsakiKbn(C_HassinsakiKbn.KOK);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean3 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean3.setHubinaiyoumsg("不備内容メッセージ3");
        editHubiTeiseisyoItiranBean3.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean3.setHassinsakiKbn(C_HassinsakiKbn.KOK);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean4 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean4.setHubinaiyoumsg("不備内容メッセージ4");
        editHubiTeiseisyoItiranBean4.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean4.setHassinsakiKbn(C_HassinsakiKbn.KOK);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean5 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean5.setHubinaiyoumsg("不備内容メッセージ5");
        editHubiTeiseisyoItiranBean5.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean5.setHassinsakiKbn(C_HassinsakiKbn.KOK);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean6 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean6.setHubinaiyoumsg("不備内容メッセージ6");
        editHubiTeiseisyoItiranBean6.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean6.setHassinsakiKbn(C_HassinsakiKbn.KOK);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean7 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean7.setHubinaiyoumsg("不備内容メッセージ7");
        editHubiTeiseisyoItiranBean7.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean7.setHassinsakiKbn(C_HassinsakiKbn.KOK);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean8 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean8.setHubinaiyoumsg("不備内容メッセージ8");
        editHubiTeiseisyoItiranBean8.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean8.setHassinsakiKbn(C_HassinsakiKbn.KOK);
        List<EditHubiTeiseisyoItiranBean> list = new ArrayList<>();
        list.add(editHubiTeiseisyoItiranBean);
        list.add(editHubiTeiseisyoItiranBean2);
        list.add(editHubiTeiseisyoItiranBean3);
        list.add(editHubiTeiseisyoItiranBean4);
        list.add(editHubiTeiseisyoItiranBean5);
        list.add(editHubiTeiseisyoItiranBean6);
        list.add(editHubiTeiseisyoItiranBean7);
        list.add(editHubiTeiseisyoItiranBean8);
        hubiTeiseisyoBean.setHubiTeiseisyoItiranLst(list);
        hubiTeiseisyoBean.setKarisakusei(false);
        hubiTeiseisyoBean.setToritsugisyakjncd("110001");
        hubiTeiseisyoBean.setToritsugisyakjnmei("取次者個人名");
        hubiTeiseisyoBean.setToritsugisyaSosikinm("取次者組織名");

        EditHubiTeiseisyoBean editHubiTeiseisyoBean = editHubiTeiseisyo.exec(hubiTeiseisyoBean);
        ReportServicesBean reportServicesBeanKok = editHubiTeiseisyoBean.getReportServicesBeanKok();
        assertNull("帳票サービスBean（支社）",editHubiTeiseisyoBean.getReportServicesBeanSisya());
        assertNull("帳票サービスBean（本社事務部門）",editHubiTeiseisyoBean.getReportServicesBeanHonsya());
        exStringEquals(reportServicesBeanKok.getKensakuKeys()[0], "11807111118", "検索キー[0]");
        exDateEquals(reportServicesBeanKok.getSyoriYmd(),BizDate.valueOf(20151218),"処理日付");
        SiHubiteiseiBean siHubiteiseiBean = (SiHubiteiseiBean) reportServicesBeanKok.getParamObjectsData()
            .get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[0];
        exStringEquals(siHubiteiseiBean.getIrSyono(),"11807111118","（ＩＲ）証券番号");
        exStringEquals(siHubiteiseiBean.getIrSeikyuusyanmkj(),"請求者漢字","（ＩＲ）請求者（漢字）");
        exNumericEquals(siHubiteiseiBean.getIrRenno1(),1,"（ＩＲ）連番１");
        exNumericEquals(siHubiteiseiBean.getIrRenno2(),2,"（ＩＲ）連番２");
        exNumericEquals(siHubiteiseiBean.getIrRenno3(),3,"（ＩＲ）連番３");
        exNumericEquals(siHubiteiseiBean.getIrRenno4(),4,"（ＩＲ）連番４");
        exNumericEquals(siHubiteiseiBean.getIrRenno5(),5,"（ＩＲ）連番５");
        exNumericEquals(siHubiteiseiBean.getIrRenno6(),6,"（ＩＲ）連番６");
        exNumericEquals(siHubiteiseiBean.getIrRenno7(),7,"（ＩＲ）連番７");
        exNumericEquals(siHubiteiseiBean.getIrRenno8(),8,"（ＩＲ）連番８");
        assertNull("（ＩＲ）連番９",siHubiteiseiBean.getIrRenno9());
        assertNull("（ＩＲ）連番１０",siHubiteiseiBean.getIrRenno10());
        exStringEquals(siHubiteiseiBean.getIrHubimsg1(),"不備内容メッセージ1","（ＩＲ）不備メッセージ１");
        exStringEquals(siHubiteiseiBean.getIrHubimsg2(),"不備内容メッセージ2","（ＩＲ）不備メッセージ２");
        exStringEquals(siHubiteiseiBean.getIrHubimsg3(),"不備内容メッセージ3","（ＩＲ）不備メッセージ３");
        exStringEquals(siHubiteiseiBean.getIrHubimsg4(),"不備内容メッセージ4","（ＩＲ）不備メッセージ４");
        exStringEquals(siHubiteiseiBean.getIrHubimsg5(),"不備内容メッセージ5","（ＩＲ）不備メッセージ５");
        exStringEquals(siHubiteiseiBean.getIrHubimsg6(),"不備内容メッセージ6","（ＩＲ）不備メッセージ６");
        exStringEquals(siHubiteiseiBean.getIrHubimsg7(),"不備内容メッセージ7","（ＩＲ）不備メッセージ７");
        exStringEquals(siHubiteiseiBean.getIrHubimsg8(),"不備内容メッセージ8","（ＩＲ）不備メッセージ８");
        exStringEquals(siHubiteiseiBean.getIrHubimsg9(),null,"（ＩＲ）不備メッセージ９");
        exStringEquals(siHubiteiseiBean.getIrHubimsg10(),null,"（ＩＲ）不備メッセージ１０");
        exClassificationEquals(siHubiteiseiBean.getIrPageinfohyoujiumu(),C_UmuKbn.ARI,"（ＩＲ）ページ情報表示有無");
        exClassificationEquals(siHubiteiseiBean.getIrKarisakuseiumu(),C_UmuKbn.NONE,"（ＩＲ）仮作成有無");
        exClassificationEquals(siHubiteiseiBean.getIrGenponhnkykumu(),C_UmuKbn.NONE,"（ＩＲ）原本返却有無");
        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean) reportServicesBeanKok
            .getParamObjectsData().get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[1];
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(),"取次者組織名","（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(),"110001","（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(),"取次者個人名","（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(),"2015年12月18日","（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(),"5 年","（ＩＲ）保存期間");
    }

    @Test
    @TestOrder(130)
    public void testExec_B10() {
        HubiTeiseisyoBean hubiTeiseisyoBean = SWAKInjector.getInstance(HubiTeiseisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151218));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.KK_SBKAIJYO_HB);
        hubiTeiseisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        hubiTeiseisyoBean.setSyono("11807111118");
        hubiTeiseisyoBean.setSeikyuusyanmKj("請求者漢字");
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean.setHubinaiyoumsg("不備内容メッセージ1");
        editHubiTeiseisyoItiranBean.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean.setHassinsakiKbn(C_HassinsakiKbn.KOK);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean2 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean2.setHubinaiyoumsg("不備内容メッセージ2");
        editHubiTeiseisyoItiranBean2.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean2.setHassinsakiKbn(C_HassinsakiKbn.KOK);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean3 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean3.setHubinaiyoumsg("不備内容メッセージ3");
        editHubiTeiseisyoItiranBean3.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean3.setHassinsakiKbn(C_HassinsakiKbn.KOK);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean4 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean4.setHubinaiyoumsg("不備内容メッセージ4");
        editHubiTeiseisyoItiranBean4.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean4.setHassinsakiKbn(C_HassinsakiKbn.KOK);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean5 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean5.setHubinaiyoumsg("不備内容メッセージ5");
        editHubiTeiseisyoItiranBean5.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean5.setHassinsakiKbn(C_HassinsakiKbn.KOK);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean6 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean6.setHubinaiyoumsg("不備内容メッセージ6");
        editHubiTeiseisyoItiranBean6.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean6.setHassinsakiKbn(C_HassinsakiKbn.KOK);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean7 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean7.setHubinaiyoumsg("不備内容メッセージ7");
        editHubiTeiseisyoItiranBean7.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean7.setHassinsakiKbn(C_HassinsakiKbn.KOK);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean8 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean8.setHubinaiyoumsg("不備内容メッセージ8");
        editHubiTeiseisyoItiranBean8.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean8.setHassinsakiKbn(C_HassinsakiKbn.KOK);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean9 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean9.setHubinaiyoumsg("不備内容メッセージ9");
        editHubiTeiseisyoItiranBean9.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean9.setHassinsakiKbn(C_HassinsakiKbn.KOK);
        List<EditHubiTeiseisyoItiranBean> list = new ArrayList<>();
        list.add(editHubiTeiseisyoItiranBean);
        list.add(editHubiTeiseisyoItiranBean2);
        list.add(editHubiTeiseisyoItiranBean3);
        list.add(editHubiTeiseisyoItiranBean4);
        list.add(editHubiTeiseisyoItiranBean5);
        list.add(editHubiTeiseisyoItiranBean6);
        list.add(editHubiTeiseisyoItiranBean7);
        list.add(editHubiTeiseisyoItiranBean8);
        list.add(editHubiTeiseisyoItiranBean9);
        hubiTeiseisyoBean.setHubiTeiseisyoItiranLst(list);
        hubiTeiseisyoBean.setKarisakusei(false);
        hubiTeiseisyoBean.setToritsugisyakjncd("110001");
        hubiTeiseisyoBean.setToritsugisyakjnmei("取次者個人名");
        hubiTeiseisyoBean.setToritsugisyaSosikinm("取次者組織名");

        EditHubiTeiseisyoBean editHubiTeiseisyoBean = editHubiTeiseisyo.exec(hubiTeiseisyoBean);
        ReportServicesBean reportServicesBeanKok = editHubiTeiseisyoBean.getReportServicesBeanKok();
        assertNull("帳票サービスBean（支社）",editHubiTeiseisyoBean.getReportServicesBeanSisya());
        assertNull("帳票サービスBean（本社事務部門）",editHubiTeiseisyoBean.getReportServicesBeanHonsya());
        exStringEquals(reportServicesBeanKok.getKensakuKeys()[0], "11807111118", "検索キー[0]");
        exDateEquals(reportServicesBeanKok.getSyoriYmd(),BizDate.valueOf(20151218),"処理日付");
        SiHubiteiseiBean siHubiteiseiBean = (SiHubiteiseiBean) reportServicesBeanKok.getParamObjectsData()
            .get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[0];
        exStringEquals(siHubiteiseiBean.getIrSyono(),"11807111118","（ＩＲ）証券番号");
        exStringEquals(siHubiteiseiBean.getIrSeikyuusyanmkj(),"請求者漢字","（ＩＲ）請求者（漢字）");
        exNumericEquals(siHubiteiseiBean.getIrRenno1(),1,"（ＩＲ）連番１");
        exNumericEquals(siHubiteiseiBean.getIrRenno2(),2,"（ＩＲ）連番２");
        exNumericEquals(siHubiteiseiBean.getIrRenno3(),3,"（ＩＲ）連番３");
        exNumericEquals(siHubiteiseiBean.getIrRenno4(),4,"（ＩＲ）連番４");
        exNumericEquals(siHubiteiseiBean.getIrRenno5(),5,"（ＩＲ）連番５");
        exNumericEquals(siHubiteiseiBean.getIrRenno6(),6,"（ＩＲ）連番６");
        exNumericEquals(siHubiteiseiBean.getIrRenno8(),8,"（ＩＲ）連番８");
        exNumericEquals(siHubiteiseiBean.getIrRenno9(),9,"（ＩＲ）連番９");
        assertNull("（ＩＲ）連番１０",siHubiteiseiBean.getIrRenno10());
        exStringEquals(siHubiteiseiBean.getIrHubimsg1(),"不備内容メッセージ1","（ＩＲ）不備メッセージ１");
        exStringEquals(siHubiteiseiBean.getIrHubimsg2(),"不備内容メッセージ2","（ＩＲ）不備メッセージ２");
        exStringEquals(siHubiteiseiBean.getIrHubimsg3(),"不備内容メッセージ3","（ＩＲ）不備メッセージ３");
        exStringEquals(siHubiteiseiBean.getIrHubimsg4(),"不備内容メッセージ4","（ＩＲ）不備メッセージ４");
        exStringEquals(siHubiteiseiBean.getIrHubimsg5(),"不備内容メッセージ5","（ＩＲ）不備メッセージ５");
        exStringEquals(siHubiteiseiBean.getIrHubimsg6(),"不備内容メッセージ6","（ＩＲ）不備メッセージ６");
        exStringEquals(siHubiteiseiBean.getIrHubimsg7(),"不備内容メッセージ7","（ＩＲ）不備メッセージ７");
        exStringEquals(siHubiteiseiBean.getIrHubimsg8(),"不備内容メッセージ8","（ＩＲ）不備メッセージ８");
        exStringEquals(siHubiteiseiBean.getIrHubimsg9(),"不備内容メッセージ9","（ＩＲ）不備メッセージ９");
        exStringEquals(siHubiteiseiBean.getIrHubimsg10(),null,"（ＩＲ）不備メッセージ１０");
        exClassificationEquals(siHubiteiseiBean.getIrPageinfohyoujiumu(),C_UmuKbn.ARI,"（ＩＲ）ページ情報表示有無");
        exClassificationEquals(siHubiteiseiBean.getIrKarisakuseiumu(),C_UmuKbn.NONE,"（ＩＲ）仮作成有無");
        exClassificationEquals(siHubiteiseiBean.getIrGenponhnkykumu(),C_UmuKbn.NONE,"（ＩＲ）原本返却有無");
        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean) reportServicesBeanKok
            .getParamObjectsData().get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[1];
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(),"取次者組織名","（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(),"110001","（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(),"取次者個人名","（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(),"2015年12月18日","（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(),"5 年","（ＩＲ）保存期間");
    }

    @Test
    @TestOrder(140)
    public void testExec_B11() {
        HubiTeiseisyoBean hubiTeiseisyoBean = SWAKInjector.getInstance(HubiTeiseisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151218));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.KK_SBKAIJYO_HB);
        hubiTeiseisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        hubiTeiseisyoBean.setSyono("11807111118");
        hubiTeiseisyoBean.setSeikyuusyanmKj("請求者漢字");
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean.setHubinaiyoumsg("不備内容メッセージ1");
        editHubiTeiseisyoItiranBean.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean.setHassinsakiKbn(C_HassinsakiKbn.KOK);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean2 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean2.setHubinaiyoumsg("不備内容メッセージ2");
        editHubiTeiseisyoItiranBean2.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean2.setHassinsakiKbn(C_HassinsakiKbn.KOK);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean3 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean3.setHubinaiyoumsg("不備内容メッセージ3");
        editHubiTeiseisyoItiranBean3.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean3.setHassinsakiKbn(C_HassinsakiKbn.KOK);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean4 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean4.setHubinaiyoumsg("不備内容メッセージ4");
        editHubiTeiseisyoItiranBean4.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean4.setHassinsakiKbn(C_HassinsakiKbn.KOK);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean5 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean5.setHubinaiyoumsg("不備内容メッセージ5");
        editHubiTeiseisyoItiranBean5.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean5.setHassinsakiKbn(C_HassinsakiKbn.KOK);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean6 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean6.setHubinaiyoumsg("不備内容メッセージ6");
        editHubiTeiseisyoItiranBean6.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean6.setHassinsakiKbn(C_HassinsakiKbn.KOK);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean7 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean7.setHubinaiyoumsg("不備内容メッセージ7");
        editHubiTeiseisyoItiranBean7.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean7.setHassinsakiKbn(C_HassinsakiKbn.KOK);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean8 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean8.setHubinaiyoumsg("不備内容メッセージ8");
        editHubiTeiseisyoItiranBean8.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean8.setHassinsakiKbn(C_HassinsakiKbn.KOK);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean9 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean9.setHubinaiyoumsg("不備内容メッセージ9");
        editHubiTeiseisyoItiranBean9.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean9.setHassinsakiKbn(C_HassinsakiKbn.KOK);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean10 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean10.setHubinaiyoumsg("不備内容メッセージ10");
        editHubiTeiseisyoItiranBean10.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean10.setHassinsakiKbn(C_HassinsakiKbn.KOK);
        List<EditHubiTeiseisyoItiranBean> list = new ArrayList<>();
        list.add(editHubiTeiseisyoItiranBean);
        list.add(editHubiTeiseisyoItiranBean2);
        list.add(editHubiTeiseisyoItiranBean3);
        list.add(editHubiTeiseisyoItiranBean4);
        list.add(editHubiTeiseisyoItiranBean5);
        list.add(editHubiTeiseisyoItiranBean6);
        list.add(editHubiTeiseisyoItiranBean7);
        list.add(editHubiTeiseisyoItiranBean8);
        list.add(editHubiTeiseisyoItiranBean9);
        list.add(editHubiTeiseisyoItiranBean10);
        hubiTeiseisyoBean.setHubiTeiseisyoItiranLst(list);
        hubiTeiseisyoBean.setKarisakusei(false);
        hubiTeiseisyoBean.setToritsugisyakjncd("110001");
        hubiTeiseisyoBean.setToritsugisyakjnmei("取次者個人名");
        hubiTeiseisyoBean.setToritsugisyaSosikinm("取次者組織名");

        EditHubiTeiseisyoBean editHubiTeiseisyoBean = editHubiTeiseisyo.exec(hubiTeiseisyoBean);
        ReportServicesBean reportServicesBeanKok = editHubiTeiseisyoBean.getReportServicesBeanKok();
        assertNull("帳票サービスBean（支社）",editHubiTeiseisyoBean.getReportServicesBeanSisya());
        assertNull("帳票サービスBean（本社事務部門）",editHubiTeiseisyoBean.getReportServicesBeanHonsya());
        exStringEquals(reportServicesBeanKok.getKensakuKeys()[0], "11807111118", "検索キー[0]");
        exDateEquals(reportServicesBeanKok.getSyoriYmd(),BizDate.valueOf(20151218),"処理日付");
        SiHubiteiseiBean siHubiteiseiBean = (SiHubiteiseiBean) reportServicesBeanKok.getParamObjectsData()
            .get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[0];
        exStringEquals(siHubiteiseiBean.getIrSyono(),"11807111118","（ＩＲ）証券番号");
        exStringEquals(siHubiteiseiBean.getIrSeikyuusyanmkj(),"請求者漢字","（ＩＲ）請求者（漢字）");
        exNumericEquals(siHubiteiseiBean.getIrRenno1(),1,"（ＩＲ）連番１");
        exNumericEquals(siHubiteiseiBean.getIrRenno2(),2,"（ＩＲ）連番２");
        exNumericEquals(siHubiteiseiBean.getIrRenno3(),3,"（ＩＲ）連番３");
        exNumericEquals(siHubiteiseiBean.getIrRenno4(),4,"（ＩＲ）連番４");
        exNumericEquals(siHubiteiseiBean.getIrRenno5(),5,"（ＩＲ）連番５");
        exNumericEquals(siHubiteiseiBean.getIrRenno6(),6,"（ＩＲ）連番６");
        exNumericEquals(siHubiteiseiBean.getIrRenno8(),8,"（ＩＲ）連番８");
        exNumericEquals(siHubiteiseiBean.getIrRenno9(),9,"（ＩＲ）連番９");
        exNumericEquals(siHubiteiseiBean.getIrRenno10(),10,"（ＩＲ）連番１０");
        exStringEquals(siHubiteiseiBean.getIrHubimsg1(),"不備内容メッセージ1","（ＩＲ）不備メッセージ１");
        exStringEquals(siHubiteiseiBean.getIrHubimsg2(),"不備内容メッセージ2","（ＩＲ）不備メッセージ２");
        exStringEquals(siHubiteiseiBean.getIrHubimsg3(),"不備内容メッセージ3","（ＩＲ）不備メッセージ３");
        exStringEquals(siHubiteiseiBean.getIrHubimsg4(),"不備内容メッセージ4","（ＩＲ）不備メッセージ４");
        exStringEquals(siHubiteiseiBean.getIrHubimsg5(),"不備内容メッセージ5","（ＩＲ）不備メッセージ５");
        exStringEquals(siHubiteiseiBean.getIrHubimsg6(),"不備内容メッセージ6","（ＩＲ）不備メッセージ６");
        exStringEquals(siHubiteiseiBean.getIrHubimsg7(),"不備内容メッセージ7","（ＩＲ）不備メッセージ７");
        exStringEquals(siHubiteiseiBean.getIrHubimsg8(),"不備内容メッセージ8","（ＩＲ）不備メッセージ８");
        exStringEquals(siHubiteiseiBean.getIrHubimsg9(),"不備内容メッセージ9","（ＩＲ）不備メッセージ９");
        exStringEquals(siHubiteiseiBean.getIrHubimsg10(),"不備内容メッセージ10","（ＩＲ）不備メッセージ１０");
        exClassificationEquals(siHubiteiseiBean.getIrPageinfohyoujiumu(),C_UmuKbn.ARI,"（ＩＲ）ページ情報表示有無");
        exClassificationEquals(siHubiteiseiBean.getIrKarisakuseiumu(),C_UmuKbn.NONE,"（ＩＲ）仮作成有無");
        exClassificationEquals(siHubiteiseiBean.getIrGenponhnkykumu(),C_UmuKbn.NONE,"（ＩＲ）原本返却有無");
        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean) reportServicesBeanKok
            .getParamObjectsData().get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[1];
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(),"取次者組織名","（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(),"110001","（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(),"取次者個人名","（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(),"2015年12月18日","（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(),"5 年","（ＩＲ）保存期間");
    }

    @Test
    @TestOrder(150)
    public void testExec_B12() {
        HubiTeiseisyoBean hubiTeiseisyoBean = SWAKInjector.getInstance(HubiTeiseisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151218));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.KK_SBKAIJYO_HB);
        hubiTeiseisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        hubiTeiseisyoBean.setSyono("11807111118");
        hubiTeiseisyoBean.setSeikyuusyanmKj("請求者漢字");
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean.setHubinaiyoumsg("不備内容メッセージ1");
        editHubiTeiseisyoItiranBean.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean.setHassinsakiKbn(C_HassinsakiKbn.SISYA);
        List<EditHubiTeiseisyoItiranBean> list = new ArrayList<>();
        list.add(editHubiTeiseisyoItiranBean);
        hubiTeiseisyoBean.setHubiTeiseisyoItiranLst(list);
        hubiTeiseisyoBean.setKarisakusei(false);
        hubiTeiseisyoBean.setToritsugisyakjncd("110001");
        hubiTeiseisyoBean.setToritsugisyakjnmei("取次者個人名");
        hubiTeiseisyoBean.setToritsugisyaSosikinm("取次者組織名");

        EditHubiTeiseisyoBean editHubiTeiseisyoBean = editHubiTeiseisyo.exec(hubiTeiseisyoBean);
        assertNull("帳票サービスBean（顧客）",editHubiTeiseisyoBean.getReportServicesBeanKok());
        ReportServicesBean reportServicesBeanSisya = editHubiTeiseisyoBean.getReportServicesBeanSisya();
        assertNull("帳票サービスBean（本社事務部門）",editHubiTeiseisyoBean.getReportServicesBeanHonsya());
        exStringEquals(reportServicesBeanSisya.getKensakuKeys()[0], "11807111118", "検索キー[0]");
        exDateEquals(reportServicesBeanSisya.getSyoriYmd(),BizDate.valueOf(20151218),"処理日付");
        SiHubiteiseiBean siHubiteiseiBean = (SiHubiteiseiBean) reportServicesBeanSisya.getParamObjectsData()
            .get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[0];
        exStringEquals(siHubiteiseiBean.getIrSyono(),"11807111118","（ＩＲ）証券番号");
        exStringEquals(siHubiteiseiBean.getIrSeikyuusyanmkj(),"請求者漢字","（ＩＲ）請求者（漢字）");
        exNumericEquals(siHubiteiseiBean.getIrRenno1(),1,"（ＩＲ）連番１");
        assertNull("（ＩＲ）連番２",siHubiteiseiBean.getIrRenno2());
        assertNull("（ＩＲ）連番３",siHubiteiseiBean.getIrRenno3());
        assertNull("（ＩＲ）連番４",siHubiteiseiBean.getIrRenno4());
        assertNull("（ＩＲ）連番５",siHubiteiseiBean.getIrRenno5());
        assertNull("（ＩＲ）連番６",siHubiteiseiBean.getIrRenno6());
        assertNull("（ＩＲ）連番７",siHubiteiseiBean.getIrRenno7());
        assertNull("（ＩＲ）連番８",siHubiteiseiBean.getIrRenno8());
        assertNull("（ＩＲ）連番９",siHubiteiseiBean.getIrRenno9());
        assertNull("（ＩＲ）連番１０",siHubiteiseiBean.getIrRenno10());
        exStringEquals(siHubiteiseiBean.getIrHubimsg1(),"不備内容メッセージ1","（ＩＲ）不備メッセージ１");
        exStringEquals(siHubiteiseiBean.getIrHubimsg2(),null,"（ＩＲ）不備メッセージ２");
        exStringEquals(siHubiteiseiBean.getIrHubimsg3(),null,"（ＩＲ）不備メッセージ３");
        exStringEquals(siHubiteiseiBean.getIrHubimsg4(),null,"（ＩＲ）不備メッセージ４");
        exStringEquals(siHubiteiseiBean.getIrHubimsg5(),null,"（ＩＲ）不備メッセージ５");
        exStringEquals(siHubiteiseiBean.getIrHubimsg6(),null,"（ＩＲ）不備メッセージ６");
        exStringEquals(siHubiteiseiBean.getIrHubimsg7(),null,"（ＩＲ）不備メッセージ７");
        exStringEquals(siHubiteiseiBean.getIrHubimsg8(),null,"（ＩＲ）不備メッセージ８");
        exStringEquals(siHubiteiseiBean.getIrHubimsg9(),null,"（ＩＲ）不備メッセージ９");
        exStringEquals(siHubiteiseiBean.getIrHubimsg10(),null,"（ＩＲ）不備メッセージ１０");
        exClassificationEquals(siHubiteiseiBean.getIrPageinfohyoujiumu(),C_UmuKbn.NONE,"（ＩＲ）ページ情報表示有無");
        exClassificationEquals(siHubiteiseiBean.getIrKarisakuseiumu(),C_UmuKbn.NONE,"（ＩＲ）仮作成有無");
        exClassificationEquals(siHubiteiseiBean.getIrGenponhnkykumu(),C_UmuKbn.NONE,"（ＩＲ）原本返却有無");
        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean) reportServicesBeanSisya
            .getParamObjectsData().get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[1];
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(),"取次者組織名","（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(),"110001","（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(),"取次者個人名","（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(),"2015年12月18日","（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(),"5 年","（ＩＲ）保存期間");
    }

    @Test
    @TestOrder(160)
    public void testExec_B13() {
        HubiTeiseisyoBean hubiTeiseisyoBean = SWAKInjector.getInstance(HubiTeiseisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151218));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.KK_SBKAIJYO_HB);
        hubiTeiseisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        hubiTeiseisyoBean.setSyono("11807111118");
        hubiTeiseisyoBean.setSeikyuusyanmKj("請求者漢字");
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean.setHubinaiyoumsg("不備内容メッセージ1");
        editHubiTeiseisyoItiranBean.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean.setHassinsakiKbn(C_HassinsakiKbn.SISYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean2 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean2.setHubinaiyoumsg("不備内容メッセージ2");
        editHubiTeiseisyoItiranBean2.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean2.setHassinsakiKbn(C_HassinsakiKbn.SISYA);
        List<EditHubiTeiseisyoItiranBean> list = new ArrayList<>();
        list.add(editHubiTeiseisyoItiranBean);
        list.add(editHubiTeiseisyoItiranBean2);
        hubiTeiseisyoBean.setHubiTeiseisyoItiranLst(list);
        hubiTeiseisyoBean.setKarisakusei(false);
        hubiTeiseisyoBean.setToritsugisyakjncd("110001");
        hubiTeiseisyoBean.setToritsugisyakjnmei("取次者個人名");
        hubiTeiseisyoBean.setToritsugisyaSosikinm("取次者組織名");

        EditHubiTeiseisyoBean editHubiTeiseisyoBean = editHubiTeiseisyo.exec(hubiTeiseisyoBean);
        assertNull("帳票サービスBean（顧客）",editHubiTeiseisyoBean.getReportServicesBeanKok());
        ReportServicesBean reportServicesBeanSisya = editHubiTeiseisyoBean.getReportServicesBeanSisya();
        assertNull("帳票サービスBean（本社事務部門）",editHubiTeiseisyoBean.getReportServicesBeanHonsya());
        exStringEquals(reportServicesBeanSisya.getKensakuKeys()[0], "11807111118", "検索キー[0]");
        exDateEquals(reportServicesBeanSisya.getSyoriYmd(),BizDate.valueOf(20151218),"処理日付");
        SiHubiteiseiBean siHubiteiseiBean = (SiHubiteiseiBean) reportServicesBeanSisya.getParamObjectsData()
            .get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[0];
        exStringEquals(siHubiteiseiBean.getIrSyono(),"11807111118","（ＩＲ）証券番号");
        exStringEquals(siHubiteiseiBean.getIrSeikyuusyanmkj(),"請求者漢字","（ＩＲ）請求者（漢字）");
        exNumericEquals(siHubiteiseiBean.getIrRenno1(),1,"（ＩＲ）連番１");
        exNumericEquals(siHubiteiseiBean.getIrRenno2(),2,"（ＩＲ）連番２");
        assertNull("（ＩＲ）連番３",siHubiteiseiBean.getIrRenno3());
        assertNull("（ＩＲ）連番４",siHubiteiseiBean.getIrRenno4());
        assertNull("（ＩＲ）連番５",siHubiteiseiBean.getIrRenno5());
        assertNull("（ＩＲ）連番６",siHubiteiseiBean.getIrRenno6());
        assertNull("（ＩＲ）連番７",siHubiteiseiBean.getIrRenno7());
        assertNull("（ＩＲ）連番８",siHubiteiseiBean.getIrRenno8());
        assertNull("（ＩＲ）連番９",siHubiteiseiBean.getIrRenno9());
        assertNull("（ＩＲ）連番１０",siHubiteiseiBean.getIrRenno10());
        exStringEquals(siHubiteiseiBean.getIrHubimsg1(),"不備内容メッセージ1","（ＩＲ）不備メッセージ１");
        exStringEquals(siHubiteiseiBean.getIrHubimsg2(),"不備内容メッセージ2","（ＩＲ）不備メッセージ２");
        exStringEquals(siHubiteiseiBean.getIrHubimsg3(),null,"（ＩＲ）不備メッセージ３");
        exStringEquals(siHubiteiseiBean.getIrHubimsg4(),null,"（ＩＲ）不備メッセージ４");
        exStringEquals(siHubiteiseiBean.getIrHubimsg5(),null,"（ＩＲ）不備メッセージ５");
        exStringEquals(siHubiteiseiBean.getIrHubimsg6(),null,"（ＩＲ）不備メッセージ６");
        exStringEquals(siHubiteiseiBean.getIrHubimsg7(),null,"（ＩＲ）不備メッセージ７");
        exStringEquals(siHubiteiseiBean.getIrHubimsg8(),null,"（ＩＲ）不備メッセージ８");
        exStringEquals(siHubiteiseiBean.getIrHubimsg9(),null,"（ＩＲ）不備メッセージ９");
        exStringEquals(siHubiteiseiBean.getIrHubimsg10(),null,"（ＩＲ）不備メッセージ１０");
        exClassificationEquals(siHubiteiseiBean.getIrPageinfohyoujiumu(),C_UmuKbn.NONE,"（ＩＲ）ページ情報表示有無");
        exClassificationEquals(siHubiteiseiBean.getIrKarisakuseiumu(),C_UmuKbn.NONE,"（ＩＲ）仮作成有無");
        exClassificationEquals(siHubiteiseiBean.getIrGenponhnkykumu(),C_UmuKbn.NONE,"（ＩＲ）原本返却有無");
        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean) reportServicesBeanSisya
            .getParamObjectsData().get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[1];
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(),"取次者組織名","（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(),"110001","（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(),"取次者個人名","（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(),"2015年12月18日","（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(),"5 年","（ＩＲ）保存期間");
    }

    @Test
    @TestOrder(170)
    public void testExec_B14() {
        HubiTeiseisyoBean hubiTeiseisyoBean = SWAKInjector.getInstance(HubiTeiseisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151218));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.KK_SBKAIJYO_HB);
        hubiTeiseisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        hubiTeiseisyoBean.setSyono("11807111118");
        hubiTeiseisyoBean.setSeikyuusyanmKj("請求者漢字");
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean.setHubinaiyoumsg("不備内容メッセージ1");
        editHubiTeiseisyoItiranBean.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean.setHassinsakiKbn(C_HassinsakiKbn.SISYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean2 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean2.setHubinaiyoumsg("不備内容メッセージ2");
        editHubiTeiseisyoItiranBean2.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean2.setHassinsakiKbn(C_HassinsakiKbn.SISYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean3 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean3.setHubinaiyoumsg("不備内容メッセージ3");
        editHubiTeiseisyoItiranBean3.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean3.setHassinsakiKbn(C_HassinsakiKbn.SISYA);
        List<EditHubiTeiseisyoItiranBean> list = new ArrayList<>();
        list.add(editHubiTeiseisyoItiranBean);
        list.add(editHubiTeiseisyoItiranBean2);
        list.add(editHubiTeiseisyoItiranBean3);
        hubiTeiseisyoBean.setHubiTeiseisyoItiranLst(list);
        hubiTeiseisyoBean.setKarisakusei(false);
        hubiTeiseisyoBean.setToritsugisyakjncd("110001");
        hubiTeiseisyoBean.setToritsugisyakjnmei("取次者個人名");
        hubiTeiseisyoBean.setToritsugisyaSosikinm("取次者組織名");

        EditHubiTeiseisyoBean editHubiTeiseisyoBean = editHubiTeiseisyo.exec(hubiTeiseisyoBean);
        assertNull("帳票サービスBean（顧客）",editHubiTeiseisyoBean.getReportServicesBeanKok());
        ReportServicesBean reportServicesBeanSisya = editHubiTeiseisyoBean.getReportServicesBeanSisya();
        assertNull("帳票サービスBean（本社事務部門）",editHubiTeiseisyoBean.getReportServicesBeanHonsya());
        exStringEquals(reportServicesBeanSisya.getKensakuKeys()[0], "11807111118", "検索キー[0]");
        exDateEquals(reportServicesBeanSisya.getSyoriYmd(),BizDate.valueOf(20151218),"処理日付");
        SiHubiteiseiBean siHubiteiseiBean = (SiHubiteiseiBean) reportServicesBeanSisya.getParamObjectsData()
            .get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[0];
        exStringEquals(siHubiteiseiBean.getIrSyono(),"11807111118","（ＩＲ）証券番号");
        exStringEquals(siHubiteiseiBean.getIrSeikyuusyanmkj(),"請求者漢字","（ＩＲ）請求者（漢字）");
        exNumericEquals(siHubiteiseiBean.getIrRenno1(),1,"（ＩＲ）連番１");
        exNumericEquals(siHubiteiseiBean.getIrRenno2(),2,"（ＩＲ）連番２");
        exNumericEquals(siHubiteiseiBean.getIrRenno3(),3,"（ＩＲ）連番３");
        assertNull("（ＩＲ）連番４",siHubiteiseiBean.getIrRenno4());
        assertNull("（ＩＲ）連番５",siHubiteiseiBean.getIrRenno5());
        assertNull("（ＩＲ）連番６",siHubiteiseiBean.getIrRenno6());
        assertNull("（ＩＲ）連番７",siHubiteiseiBean.getIrRenno7());
        assertNull("（ＩＲ）連番８",siHubiteiseiBean.getIrRenno8());
        assertNull("（ＩＲ）連番９",siHubiteiseiBean.getIrRenno9());
        assertNull("（ＩＲ）連番１０",siHubiteiseiBean.getIrRenno10());
        exStringEquals(siHubiteiseiBean.getIrHubimsg1(),"不備内容メッセージ1","（ＩＲ）不備メッセージ１");
        exStringEquals(siHubiteiseiBean.getIrHubimsg2(),"不備内容メッセージ2","（ＩＲ）不備メッセージ２");
        exStringEquals(siHubiteiseiBean.getIrHubimsg3(),"不備内容メッセージ3","（ＩＲ）不備メッセージ３");
        exStringEquals(siHubiteiseiBean.getIrHubimsg4(),null,"（ＩＲ）不備メッセージ４");
        exStringEquals(siHubiteiseiBean.getIrHubimsg5(),null,"（ＩＲ）不備メッセージ５");
        exStringEquals(siHubiteiseiBean.getIrHubimsg6(),null,"（ＩＲ）不備メッセージ６");
        exStringEquals(siHubiteiseiBean.getIrHubimsg7(),null,"（ＩＲ）不備メッセージ７");
        exStringEquals(siHubiteiseiBean.getIrHubimsg8(),null,"（ＩＲ）不備メッセージ８");
        exStringEquals(siHubiteiseiBean.getIrHubimsg9(),null,"（ＩＲ）不備メッセージ９");
        exStringEquals(siHubiteiseiBean.getIrHubimsg10(),null,"（ＩＲ）不備メッセージ１０");
        exClassificationEquals(siHubiteiseiBean.getIrPageinfohyoujiumu(),C_UmuKbn.NONE,"（ＩＲ）ページ情報表示有無");
        exClassificationEquals(siHubiteiseiBean.getIrKarisakuseiumu(),C_UmuKbn.NONE,"（ＩＲ）仮作成有無");
        exClassificationEquals(siHubiteiseiBean.getIrGenponhnkykumu(),C_UmuKbn.NONE,"（ＩＲ）原本返却有無");
        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean) reportServicesBeanSisya
            .getParamObjectsData().get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[1];
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(),"取次者組織名","（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(),"110001","（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(),"取次者個人名","（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(),"2015年12月18日","（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(),"5 年","（ＩＲ）保存期間");
    }

    @Test
    @TestOrder(180)
    public void testExec_B15() {
        HubiTeiseisyoBean hubiTeiseisyoBean = SWAKInjector.getInstance(HubiTeiseisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151218));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.KK_SBKAIJYO_HB);
        hubiTeiseisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        hubiTeiseisyoBean.setSyono("11807111118");
        hubiTeiseisyoBean.setSeikyuusyanmKj("請求者漢字");
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean.setHubinaiyoumsg("不備内容メッセージ1");
        editHubiTeiseisyoItiranBean.setGenponhnkykumu(C_UmuKbn.ARI);
        editHubiTeiseisyoItiranBean.setHassinsakiKbn(C_HassinsakiKbn.SISYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean2 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean2.setHubinaiyoumsg("不備内容メッセージ2");
        editHubiTeiseisyoItiranBean2.setGenponhnkykumu(C_UmuKbn.ARI);
        editHubiTeiseisyoItiranBean2.setHassinsakiKbn(C_HassinsakiKbn.SISYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean3 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean3.setHubinaiyoumsg("不備内容メッセージ3");
        editHubiTeiseisyoItiranBean3.setGenponhnkykumu(C_UmuKbn.ARI);
        editHubiTeiseisyoItiranBean3.setHassinsakiKbn(C_HassinsakiKbn.SISYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean4 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean4.setHubinaiyoumsg("不備内容メッセージ4");
        editHubiTeiseisyoItiranBean4.setGenponhnkykumu(C_UmuKbn.ARI);
        editHubiTeiseisyoItiranBean4.setHassinsakiKbn(C_HassinsakiKbn.SISYA);
        List<EditHubiTeiseisyoItiranBean> list = new ArrayList<>();
        list.add(editHubiTeiseisyoItiranBean);
        list.add(editHubiTeiseisyoItiranBean2);
        list.add(editHubiTeiseisyoItiranBean3);
        list.add(editHubiTeiseisyoItiranBean4);
        hubiTeiseisyoBean.setHubiTeiseisyoItiranLst(list);
        hubiTeiseisyoBean.setKarisakusei(true);
        hubiTeiseisyoBean.setToritsugisyakjncd("110001");
        hubiTeiseisyoBean.setToritsugisyakjnmei("取次者個人名");
        hubiTeiseisyoBean.setToritsugisyaSosikinm("取次者組織名");

        EditHubiTeiseisyoBean editHubiTeiseisyoBean = editHubiTeiseisyo.exec(hubiTeiseisyoBean);
        assertNull("帳票サービスBean（顧客）",editHubiTeiseisyoBean.getReportServicesBeanKok());
        ReportServicesBean reportServicesBeanSisya = editHubiTeiseisyoBean.getReportServicesBeanSisya();
        assertNull("帳票サービスBean（本社事務部門）",editHubiTeiseisyoBean.getReportServicesBeanHonsya());
        exStringEquals(reportServicesBeanSisya.getKensakuKeys()[0], "11807111118", "検索キー[0]");
        exDateEquals(reportServicesBeanSisya.getSyoriYmd(),BizDate.valueOf(20151218),"処理日付");
        SiHubiteiseiBean siHubiteiseiBean = (SiHubiteiseiBean) reportServicesBeanSisya.getParamObjectsData()
            .get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[0];
        exStringEquals(siHubiteiseiBean.getIrSyono(),"11807111118","（ＩＲ）証券番号");
        exStringEquals(siHubiteiseiBean.getIrSeikyuusyanmkj(),"請求者漢字","（ＩＲ）請求者（漢字）");
        exNumericEquals(siHubiteiseiBean.getIrRenno1(),1,"（ＩＲ）連番１");
        exNumericEquals(siHubiteiseiBean.getIrRenno2(),2,"（ＩＲ）連番２");
        exNumericEquals(siHubiteiseiBean.getIrRenno3(),3,"（ＩＲ）連番３");
        exNumericEquals(siHubiteiseiBean.getIrRenno4(),4,"（ＩＲ）連番４");
        assertNull("（ＩＲ）連番５",siHubiteiseiBean.getIrRenno5());
        assertNull("（ＩＲ）連番６",siHubiteiseiBean.getIrRenno6());
        assertNull("（ＩＲ）連番７",siHubiteiseiBean.getIrRenno7());
        assertNull("（ＩＲ）連番８",siHubiteiseiBean.getIrRenno8());
        assertNull("（ＩＲ）連番９",siHubiteiseiBean.getIrRenno9());
        assertNull("（ＩＲ）連番１０",siHubiteiseiBean.getIrRenno10());
        exStringEquals(siHubiteiseiBean.getIrHubimsg1(),"不備内容メッセージ1","（ＩＲ）不備メッセージ１");
        exStringEquals(siHubiteiseiBean.getIrHubimsg2(),"不備内容メッセージ2","（ＩＲ）不備メッセージ２");
        exStringEquals(siHubiteiseiBean.getIrHubimsg3(),"不備内容メッセージ3","（ＩＲ）不備メッセージ３");
        exStringEquals(siHubiteiseiBean.getIrHubimsg4(),"不備内容メッセージ4","（ＩＲ）不備メッセージ４");
        exStringEquals(siHubiteiseiBean.getIrHubimsg5(),null,"（ＩＲ）不備メッセージ５");
        exStringEquals(siHubiteiseiBean.getIrHubimsg6(),null,"（ＩＲ）不備メッセージ６");
        exStringEquals(siHubiteiseiBean.getIrHubimsg7(),null,"（ＩＲ）不備メッセージ７");
        exStringEquals(siHubiteiseiBean.getIrHubimsg8(),null,"（ＩＲ）不備メッセージ８");
        exStringEquals(siHubiteiseiBean.getIrHubimsg9(),null,"（ＩＲ）不備メッセージ９");
        exStringEquals(siHubiteiseiBean.getIrHubimsg10(),null,"（ＩＲ）不備メッセージ１０");
        exClassificationEquals(siHubiteiseiBean.getIrPageinfohyoujiumu(),C_UmuKbn.NONE,"（ＩＲ）ページ情報表示有無");
        exClassificationEquals(siHubiteiseiBean.getIrKarisakuseiumu(),C_UmuKbn.ARI,"（ＩＲ）仮作成有無");
        exClassificationEquals(siHubiteiseiBean.getIrGenponhnkykumu(),C_UmuKbn.ARI,"（ＩＲ）原本返却有無");
        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean) reportServicesBeanSisya
            .getParamObjectsData().get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[1];
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(),"取次者組織名","（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(),"110001","（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(),"取次者個人名","（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(),"2015年12月18日","（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(),"5 年","（ＩＲ）保存期間");
    }

    @Test
    @TestOrder(190)
    public void testExec_B16() {
        HubiTeiseisyoBean hubiTeiseisyoBean = SWAKInjector.getInstance(HubiTeiseisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151218));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.KK_SBKAIJYO_HB);
        hubiTeiseisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        hubiTeiseisyoBean.setSyono("11807111118");
        hubiTeiseisyoBean.setSeikyuusyanmKj("請求者漢字");
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean.setHubinaiyoumsg("不備内容メッセージ1");
        editHubiTeiseisyoItiranBean.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean.setHassinsakiKbn(C_HassinsakiKbn.SISYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean2 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean2.setHubinaiyoumsg("不備内容メッセージ2");
        editHubiTeiseisyoItiranBean2.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean2.setHassinsakiKbn(C_HassinsakiKbn.SISYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean3 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean3.setHubinaiyoumsg("不備内容メッセージ3");
        editHubiTeiseisyoItiranBean3.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean3.setHassinsakiKbn(C_HassinsakiKbn.SISYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean4 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean4.setHubinaiyoumsg("不備内容メッセージ4");
        editHubiTeiseisyoItiranBean4.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean4.setHassinsakiKbn(C_HassinsakiKbn.SISYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean5 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean5.setHubinaiyoumsg("不備内容メッセージ5");
        editHubiTeiseisyoItiranBean5.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean5.setHassinsakiKbn(C_HassinsakiKbn.SISYA);
        List<EditHubiTeiseisyoItiranBean> list = new ArrayList<>();
        list.add(editHubiTeiseisyoItiranBean);
        list.add(editHubiTeiseisyoItiranBean2);
        list.add(editHubiTeiseisyoItiranBean3);
        list.add(editHubiTeiseisyoItiranBean4);
        list.add(editHubiTeiseisyoItiranBean5);
        hubiTeiseisyoBean.setHubiTeiseisyoItiranLst(list);
        hubiTeiseisyoBean.setKarisakusei(false);
        hubiTeiseisyoBean.setToritsugisyakjncd("110001");
        hubiTeiseisyoBean.setToritsugisyakjnmei("取次者個人名");
        hubiTeiseisyoBean.setToritsugisyaSosikinm("取次者組織名");

        EditHubiTeiseisyoBean editHubiTeiseisyoBean = editHubiTeiseisyo.exec(hubiTeiseisyoBean);
        assertNull("帳票サービスBean（顧客）",editHubiTeiseisyoBean.getReportServicesBeanKok());
        ReportServicesBean reportServicesBeanSisya = editHubiTeiseisyoBean.getReportServicesBeanSisya();
        assertNull("帳票サービスBean（本社事務部門）",editHubiTeiseisyoBean.getReportServicesBeanHonsya());
        exStringEquals(reportServicesBeanSisya.getKensakuKeys()[0], "11807111118", "検索キー[0]");
        exDateEquals(reportServicesBeanSisya.getSyoriYmd(),BizDate.valueOf(20151218),"処理日付");
        SiHubiteiseiBean siHubiteiseiBean = (SiHubiteiseiBean) reportServicesBeanSisya.getParamObjectsData()
            .get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[0];
        exStringEquals(siHubiteiseiBean.getIrSyono(),"11807111118","（ＩＲ）証券番号");
        exStringEquals(siHubiteiseiBean.getIrSeikyuusyanmkj(),"請求者漢字","（ＩＲ）請求者（漢字）");
        exNumericEquals(siHubiteiseiBean.getIrRenno1(),1,"（ＩＲ）連番１");
        exNumericEquals(siHubiteiseiBean.getIrRenno2(),2,"（ＩＲ）連番２");
        exNumericEquals(siHubiteiseiBean.getIrRenno3(),3,"（ＩＲ）連番３");
        exNumericEquals(siHubiteiseiBean.getIrRenno4(),4,"（ＩＲ）連番４");
        exNumericEquals(siHubiteiseiBean.getIrRenno5(),5,"（ＩＲ）連番５");
        assertNull("（ＩＲ）連番６",siHubiteiseiBean.getIrRenno6());
        assertNull("（ＩＲ）連番７",siHubiteiseiBean.getIrRenno7());
        assertNull("（ＩＲ）連番８",siHubiteiseiBean.getIrRenno8());
        assertNull("（ＩＲ）連番９",siHubiteiseiBean.getIrRenno9());
        assertNull("（ＩＲ）連番１０",siHubiteiseiBean.getIrRenno10());
        exStringEquals(siHubiteiseiBean.getIrHubimsg1(),"不備内容メッセージ1","（ＩＲ）不備メッセージ１");
        exStringEquals(siHubiteiseiBean.getIrHubimsg2(),"不備内容メッセージ2","（ＩＲ）不備メッセージ２");
        exStringEquals(siHubiteiseiBean.getIrHubimsg3(),"不備内容メッセージ3","（ＩＲ）不備メッセージ３");
        exStringEquals(siHubiteiseiBean.getIrHubimsg4(),"不備内容メッセージ4","（ＩＲ）不備メッセージ４");
        exStringEquals(siHubiteiseiBean.getIrHubimsg5(),"不備内容メッセージ5","（ＩＲ）不備メッセージ５");
        exStringEquals(siHubiteiseiBean.getIrHubimsg6(),null,"（ＩＲ）不備メッセージ６");
        exStringEquals(siHubiteiseiBean.getIrHubimsg7(),null,"（ＩＲ）不備メッセージ７");
        exStringEquals(siHubiteiseiBean.getIrHubimsg8(),null,"（ＩＲ）不備メッセージ８");
        exStringEquals(siHubiteiseiBean.getIrHubimsg9(),null,"（ＩＲ）不備メッセージ９");
        exStringEquals(siHubiteiseiBean.getIrHubimsg10(),null,"（ＩＲ）不備メッセージ１０");
        exClassificationEquals(siHubiteiseiBean.getIrPageinfohyoujiumu(),C_UmuKbn.NONE,"（ＩＲ）ページ情報表示有無");
        exClassificationEquals(siHubiteiseiBean.getIrKarisakuseiumu(),C_UmuKbn.NONE,"（ＩＲ）仮作成有無");
        exClassificationEquals(siHubiteiseiBean.getIrGenponhnkykumu(),C_UmuKbn.NONE,"（ＩＲ）原本返却有無");
        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean) reportServicesBeanSisya
            .getParamObjectsData().get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[1];
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(),"取次者組織名","（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(),"110001","（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(),"取次者個人名","（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(),"2015年12月18日","（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(),"5 年","（ＩＲ）保存期間");
    }

    @Test
    @TestOrder(200)
    public void testExec_B17() {
        HubiTeiseisyoBean hubiTeiseisyoBean = SWAKInjector.getInstance(HubiTeiseisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151218));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.KK_SBKAIJYO_HB);
        hubiTeiseisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        hubiTeiseisyoBean.setSyono("11807111118");
        hubiTeiseisyoBean.setSeikyuusyanmKj("請求者漢字");
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean.setHubinaiyoumsg("不備内容メッセージ1");
        editHubiTeiseisyoItiranBean.setGenponhnkykumu(C_UmuKbn.ARI);
        editHubiTeiseisyoItiranBean.setHassinsakiKbn(C_HassinsakiKbn.SISYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean2 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean2.setHubinaiyoumsg("不備内容メッセージ2");
        editHubiTeiseisyoItiranBean2.setGenponhnkykumu(C_UmuKbn.ARI);
        editHubiTeiseisyoItiranBean2.setHassinsakiKbn(C_HassinsakiKbn.SISYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean3 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean3.setHubinaiyoumsg("不備内容メッセージ3");
        editHubiTeiseisyoItiranBean3.setGenponhnkykumu(C_UmuKbn.ARI);
        editHubiTeiseisyoItiranBean3.setHassinsakiKbn(C_HassinsakiKbn.SISYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean4 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean4.setHubinaiyoumsg("不備内容メッセージ4");
        editHubiTeiseisyoItiranBean4.setGenponhnkykumu(C_UmuKbn.ARI);
        editHubiTeiseisyoItiranBean4.setHassinsakiKbn(C_HassinsakiKbn.SISYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean5 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean5.setHubinaiyoumsg("不備内容メッセージ5");
        editHubiTeiseisyoItiranBean5.setGenponhnkykumu(C_UmuKbn.ARI);
        editHubiTeiseisyoItiranBean5.setHassinsakiKbn(C_HassinsakiKbn.SISYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean6 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean6.setHubinaiyoumsg("不備内容メッセージ6");
        editHubiTeiseisyoItiranBean6.setGenponhnkykumu(C_UmuKbn.ARI);
        editHubiTeiseisyoItiranBean6.setHassinsakiKbn(C_HassinsakiKbn.SISYA);
        List<EditHubiTeiseisyoItiranBean> list = new ArrayList<>();
        list.add(editHubiTeiseisyoItiranBean);
        list.add(editHubiTeiseisyoItiranBean2);
        list.add(editHubiTeiseisyoItiranBean3);
        list.add(editHubiTeiseisyoItiranBean4);
        list.add(editHubiTeiseisyoItiranBean5);
        list.add(editHubiTeiseisyoItiranBean6);
        hubiTeiseisyoBean.setHubiTeiseisyoItiranLst(list);
        hubiTeiseisyoBean.setKarisakusei(true);
        hubiTeiseisyoBean.setToritsugisyakjncd("110001");
        hubiTeiseisyoBean.setToritsugisyakjnmei("取次者個人名");
        hubiTeiseisyoBean.setToritsugisyaSosikinm("取次者組織名");

        EditHubiTeiseisyoBean editHubiTeiseisyoBean = editHubiTeiseisyo.exec(hubiTeiseisyoBean);
        assertNull("帳票サービスBean（顧客）",editHubiTeiseisyoBean.getReportServicesBeanKok());
        ReportServicesBean reportServicesBeanSisya = editHubiTeiseisyoBean.getReportServicesBeanSisya();
        assertNull("帳票サービスBean（本社事務部門）",editHubiTeiseisyoBean.getReportServicesBeanHonsya());
        exStringEquals(reportServicesBeanSisya.getKensakuKeys()[0], "11807111118", "検索キー[0]");
        exDateEquals(reportServicesBeanSisya.getSyoriYmd(),BizDate.valueOf(20151218),"処理日付");
        SiHubiteiseiBean siHubiteiseiBean = (SiHubiteiseiBean) reportServicesBeanSisya.getParamObjectsData()
            .get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[0];
        exStringEquals(siHubiteiseiBean.getIrSyono(),"11807111118","（ＩＲ）証券番号");
        exStringEquals(siHubiteiseiBean.getIrSeikyuusyanmkj(),"請求者漢字","（ＩＲ）請求者（漢字）");
        exNumericEquals(siHubiteiseiBean.getIrRenno1(),1,"（ＩＲ）連番１");
        exNumericEquals(siHubiteiseiBean.getIrRenno2(),2,"（ＩＲ）連番２");
        exNumericEquals(siHubiteiseiBean.getIrRenno3(),3,"（ＩＲ）連番３");
        exNumericEquals(siHubiteiseiBean.getIrRenno4(),4,"（ＩＲ）連番４");
        exNumericEquals(siHubiteiseiBean.getIrRenno5(),5,"（ＩＲ）連番５");
        exNumericEquals(siHubiteiseiBean.getIrRenno6(),6,"（ＩＲ）連番６");
        assertNull("（ＩＲ）連番７",siHubiteiseiBean.getIrRenno7());
        assertNull("（ＩＲ）連番８",siHubiteiseiBean.getIrRenno8());
        assertNull("（ＩＲ）連番９",siHubiteiseiBean.getIrRenno9());
        assertNull("（ＩＲ）連番１０",siHubiteiseiBean.getIrRenno10());
        exStringEquals(siHubiteiseiBean.getIrHubimsg1(),"不備内容メッセージ1","（ＩＲ）不備メッセージ１");
        exStringEquals(siHubiteiseiBean.getIrHubimsg2(),"不備内容メッセージ2","（ＩＲ）不備メッセージ２");
        exStringEquals(siHubiteiseiBean.getIrHubimsg3(),"不備内容メッセージ3","（ＩＲ）不備メッセージ３");
        exStringEquals(siHubiteiseiBean.getIrHubimsg4(),"不備内容メッセージ4","（ＩＲ）不備メッセージ４");
        exStringEquals(siHubiteiseiBean.getIrHubimsg5(),"不備内容メッセージ5","（ＩＲ）不備メッセージ５");
        exStringEquals(siHubiteiseiBean.getIrHubimsg6(),"不備内容メッセージ6","（ＩＲ）不備メッセージ６");
        exStringEquals(siHubiteiseiBean.getIrHubimsg7(),null,"（ＩＲ）不備メッセージ７");
        exStringEquals(siHubiteiseiBean.getIrHubimsg8(),null,"（ＩＲ）不備メッセージ８");
        exStringEquals(siHubiteiseiBean.getIrHubimsg9(),null,"（ＩＲ）不備メッセージ９");
        exStringEquals(siHubiteiseiBean.getIrHubimsg10(),null,"（ＩＲ）不備メッセージ１０");
        exClassificationEquals(siHubiteiseiBean.getIrPageinfohyoujiumu(),C_UmuKbn.ARI,"（ＩＲ）ページ情報表示有無");
        exClassificationEquals(siHubiteiseiBean.getIrKarisakuseiumu(),C_UmuKbn.ARI,"（ＩＲ）仮作成有無");
        exClassificationEquals(siHubiteiseiBean.getIrGenponhnkykumu(),C_UmuKbn.ARI,"（ＩＲ）原本返却有無");
        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean) reportServicesBeanSisya
            .getParamObjectsData().get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[1];
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(),"取次者組織名","（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(),"110001","（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(),"取次者個人名","（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(),"2015年12月18日","（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(),"5 年","（ＩＲ）保存期間");
    }

    @Test
    @TestOrder(210)
    public void testExec_B18() {
        HubiTeiseisyoBean hubiTeiseisyoBean = SWAKInjector.getInstance(HubiTeiseisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151218));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.KK_SBKAIJYO_HB);
        hubiTeiseisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        hubiTeiseisyoBean.setSyono("11807111118");
        hubiTeiseisyoBean.setSeikyuusyanmKj("請求者漢字");
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean.setHubinaiyoumsg("不備内容メッセージ1");
        editHubiTeiseisyoItiranBean.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean.setHassinsakiKbn(C_HassinsakiKbn.SISYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean2 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean2.setHubinaiyoumsg("不備内容メッセージ2");
        editHubiTeiseisyoItiranBean2.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean2.setHassinsakiKbn(C_HassinsakiKbn.SISYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean3 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean3.setHubinaiyoumsg("不備内容メッセージ3");
        editHubiTeiseisyoItiranBean3.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean3.setHassinsakiKbn(C_HassinsakiKbn.SISYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean4 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean4.setHubinaiyoumsg("不備内容メッセージ4");
        editHubiTeiseisyoItiranBean4.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean4.setHassinsakiKbn(C_HassinsakiKbn.SISYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean5 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean5.setHubinaiyoumsg("不備内容メッセージ5");
        editHubiTeiseisyoItiranBean5.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean5.setHassinsakiKbn(C_HassinsakiKbn.SISYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean6 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean6.setHubinaiyoumsg("不備内容メッセージ6");
        editHubiTeiseisyoItiranBean6.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean6.setHassinsakiKbn(C_HassinsakiKbn.SISYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean7 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean7.setHubinaiyoumsg("不備内容メッセージ7");
        editHubiTeiseisyoItiranBean7.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean7.setHassinsakiKbn(C_HassinsakiKbn.SISYA);
        List<EditHubiTeiseisyoItiranBean> list = new ArrayList<>();
        list.add(editHubiTeiseisyoItiranBean);
        list.add(editHubiTeiseisyoItiranBean2);
        list.add(editHubiTeiseisyoItiranBean3);
        list.add(editHubiTeiseisyoItiranBean4);
        list.add(editHubiTeiseisyoItiranBean5);
        list.add(editHubiTeiseisyoItiranBean6);
        list.add(editHubiTeiseisyoItiranBean7);
        hubiTeiseisyoBean.setHubiTeiseisyoItiranLst(list);
        hubiTeiseisyoBean.setKarisakusei(false);
        hubiTeiseisyoBean.setToritsugisyakjncd("110001");
        hubiTeiseisyoBean.setToritsugisyakjnmei("取次者個人名");
        hubiTeiseisyoBean.setToritsugisyaSosikinm("取次者組織名");

        EditHubiTeiseisyoBean editHubiTeiseisyoBean = editHubiTeiseisyo.exec(hubiTeiseisyoBean);
        assertNull("帳票サービスBean（顧客）",editHubiTeiseisyoBean.getReportServicesBeanKok());
        ReportServicesBean reportServicesBeanSisya = editHubiTeiseisyoBean.getReportServicesBeanSisya();
        assertNull("帳票サービスBean（本社事務部門）",editHubiTeiseisyoBean.getReportServicesBeanHonsya());
        exStringEquals(reportServicesBeanSisya.getKensakuKeys()[0], "11807111118", "検索キー[0]");
        exDateEquals(reportServicesBeanSisya.getSyoriYmd(),BizDate.valueOf(20151218),"処理日付");
        SiHubiteiseiBean siHubiteiseiBean = (SiHubiteiseiBean) reportServicesBeanSisya.getParamObjectsData()
            .get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[0];
        exStringEquals(siHubiteiseiBean.getIrSyono(),"11807111118","（ＩＲ）証券番号");
        exStringEquals(siHubiteiseiBean.getIrSeikyuusyanmkj(),"請求者漢字","（ＩＲ）請求者（漢字）");
        exNumericEquals(siHubiteiseiBean.getIrRenno1(),1,"（ＩＲ）連番１");
        exNumericEquals(siHubiteiseiBean.getIrRenno2(),2,"（ＩＲ）連番２");
        exNumericEquals(siHubiteiseiBean.getIrRenno3(),3,"（ＩＲ）連番３");
        exNumericEquals(siHubiteiseiBean.getIrRenno4(),4,"（ＩＲ）連番４");
        exNumericEquals(siHubiteiseiBean.getIrRenno5(),5,"（ＩＲ）連番５");
        exNumericEquals(siHubiteiseiBean.getIrRenno6(),6,"（ＩＲ）連番６");
        exNumericEquals(siHubiteiseiBean.getIrRenno7(),7,"（ＩＲ）連番７");
        assertNull("（ＩＲ）連番８",siHubiteiseiBean.getIrRenno8());
        assertNull("（ＩＲ）連番９",siHubiteiseiBean.getIrRenno9());
        assertNull("（ＩＲ）連番１０",siHubiteiseiBean.getIrRenno10());
        exStringEquals(siHubiteiseiBean.getIrHubimsg1(),"不備内容メッセージ1","（ＩＲ）不備メッセージ１");
        exStringEquals(siHubiteiseiBean.getIrHubimsg2(),"不備内容メッセージ2","（ＩＲ）不備メッセージ２");
        exStringEquals(siHubiteiseiBean.getIrHubimsg3(),"不備内容メッセージ3","（ＩＲ）不備メッセージ３");
        exStringEquals(siHubiteiseiBean.getIrHubimsg4(),"不備内容メッセージ4","（ＩＲ）不備メッセージ４");
        exStringEquals(siHubiteiseiBean.getIrHubimsg5(),"不備内容メッセージ5","（ＩＲ）不備メッセージ５");
        exStringEquals(siHubiteiseiBean.getIrHubimsg6(),"不備内容メッセージ6","（ＩＲ）不備メッセージ６");
        exStringEquals(siHubiteiseiBean.getIrHubimsg7(),"不備内容メッセージ7","（ＩＲ）不備メッセージ７");
        exStringEquals(siHubiteiseiBean.getIrHubimsg8(),null,"（ＩＲ）不備メッセージ８");
        exStringEquals(siHubiteiseiBean.getIrHubimsg9(),null,"（ＩＲ）不備メッセージ９");
        exStringEquals(siHubiteiseiBean.getIrHubimsg10(),null,"（ＩＲ）不備メッセージ１０");
        exClassificationEquals(siHubiteiseiBean.getIrPageinfohyoujiumu(),C_UmuKbn.ARI,"（ＩＲ）ページ情報表示有無");
        exClassificationEquals(siHubiteiseiBean.getIrKarisakuseiumu(),C_UmuKbn.NONE,"（ＩＲ）仮作成有無");
        exClassificationEquals(siHubiteiseiBean.getIrGenponhnkykumu(),C_UmuKbn.NONE,"（ＩＲ）原本返却有無");
        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean) reportServicesBeanSisya
            .getParamObjectsData().get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[1];
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(),"取次者組織名","（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(),"110001","（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(),"取次者個人名","（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(),"2015年12月18日","（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(),"5 年","（ＩＲ）保存期間");
    }

    @Test
    @TestOrder(220)
    public void testExec_B19() {
        HubiTeiseisyoBean hubiTeiseisyoBean = SWAKInjector.getInstance(HubiTeiseisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151218));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.KK_SBKAIJYO_HB);
        hubiTeiseisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        hubiTeiseisyoBean.setSyono("11807111118");
        hubiTeiseisyoBean.setSeikyuusyanmKj("請求者漢字");
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean.setHubinaiyoumsg("不備内容メッセージ1");
        editHubiTeiseisyoItiranBean.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean.setHassinsakiKbn(C_HassinsakiKbn.SISYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean2 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean2.setHubinaiyoumsg("不備内容メッセージ2");
        editHubiTeiseisyoItiranBean2.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean2.setHassinsakiKbn(C_HassinsakiKbn.SISYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean3 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean3.setHubinaiyoumsg("不備内容メッセージ3");
        editHubiTeiseisyoItiranBean3.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean3.setHassinsakiKbn(C_HassinsakiKbn.SISYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean4 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean4.setHubinaiyoumsg("不備内容メッセージ4");
        editHubiTeiseisyoItiranBean4.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean4.setHassinsakiKbn(C_HassinsakiKbn.SISYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean5 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean5.setHubinaiyoumsg("不備内容メッセージ5");
        editHubiTeiseisyoItiranBean5.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean5.setHassinsakiKbn(C_HassinsakiKbn.SISYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean6 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean6.setHubinaiyoumsg("不備内容メッセージ6");
        editHubiTeiseisyoItiranBean6.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean6.setHassinsakiKbn(C_HassinsakiKbn.SISYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean7 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean7.setHubinaiyoumsg("不備内容メッセージ7");
        editHubiTeiseisyoItiranBean7.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean7.setHassinsakiKbn(C_HassinsakiKbn.SISYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean8 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean8.setHubinaiyoumsg("不備内容メッセージ8");
        editHubiTeiseisyoItiranBean8.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean8.setHassinsakiKbn(C_HassinsakiKbn.SISYA);
        List<EditHubiTeiseisyoItiranBean> list = new ArrayList<>();
        list.add(editHubiTeiseisyoItiranBean);
        list.add(editHubiTeiseisyoItiranBean2);
        list.add(editHubiTeiseisyoItiranBean3);
        list.add(editHubiTeiseisyoItiranBean4);
        list.add(editHubiTeiseisyoItiranBean5);
        list.add(editHubiTeiseisyoItiranBean6);
        list.add(editHubiTeiseisyoItiranBean7);
        list.add(editHubiTeiseisyoItiranBean8);
        hubiTeiseisyoBean.setHubiTeiseisyoItiranLst(list);
        hubiTeiseisyoBean.setKarisakusei(false);
        hubiTeiseisyoBean.setToritsugisyakjncd("110001");
        hubiTeiseisyoBean.setToritsugisyakjnmei("取次者個人名");
        hubiTeiseisyoBean.setToritsugisyaSosikinm("取次者組織名");

        EditHubiTeiseisyoBean editHubiTeiseisyoBean = editHubiTeiseisyo.exec(hubiTeiseisyoBean);
        assertNull("帳票サービスBean（顧客）",editHubiTeiseisyoBean.getReportServicesBeanKok());
        ReportServicesBean reportServicesBeanSisya = editHubiTeiseisyoBean.getReportServicesBeanSisya();
        assertNull("帳票サービスBean（本社事務部門）",editHubiTeiseisyoBean.getReportServicesBeanHonsya());
        exStringEquals(reportServicesBeanSisya.getKensakuKeys()[0], "11807111118", "検索キー[0]");
        exDateEquals(reportServicesBeanSisya.getSyoriYmd(),BizDate.valueOf(20151218),"処理日付");
        SiHubiteiseiBean siHubiteiseiBean = (SiHubiteiseiBean) reportServicesBeanSisya.getParamObjectsData()
            .get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[0];
        exStringEquals(siHubiteiseiBean.getIrSyono(),"11807111118","（ＩＲ）証券番号");
        exStringEquals(siHubiteiseiBean.getIrSeikyuusyanmkj(),"請求者漢字","（ＩＲ）請求者（漢字）");
        exNumericEquals(siHubiteiseiBean.getIrRenno1(),1,"（ＩＲ）連番１");
        exNumericEquals(siHubiteiseiBean.getIrRenno2(),2,"（ＩＲ）連番２");
        exNumericEquals(siHubiteiseiBean.getIrRenno3(),3,"（ＩＲ）連番３");
        exNumericEquals(siHubiteiseiBean.getIrRenno4(),4,"（ＩＲ）連番４");
        exNumericEquals(siHubiteiseiBean.getIrRenno5(),5,"（ＩＲ）連番５");
        exNumericEquals(siHubiteiseiBean.getIrRenno6(),6,"（ＩＲ）連番６");
        exNumericEquals(siHubiteiseiBean.getIrRenno7(),7,"（ＩＲ）連番７");
        exNumericEquals(siHubiteiseiBean.getIrRenno8(),8,"（ＩＲ）連番８");
        assertNull("（ＩＲ）連番９",siHubiteiseiBean.getIrRenno9());
        assertNull("（ＩＲ）連番１０",siHubiteiseiBean.getIrRenno10());
        exStringEquals(siHubiteiseiBean.getIrHubimsg1(),"不備内容メッセージ1","（ＩＲ）不備メッセージ１");
        exStringEquals(siHubiteiseiBean.getIrHubimsg2(),"不備内容メッセージ2","（ＩＲ）不備メッセージ２");
        exStringEquals(siHubiteiseiBean.getIrHubimsg3(),"不備内容メッセージ3","（ＩＲ）不備メッセージ３");
        exStringEquals(siHubiteiseiBean.getIrHubimsg4(),"不備内容メッセージ4","（ＩＲ）不備メッセージ４");
        exStringEquals(siHubiteiseiBean.getIrHubimsg5(),"不備内容メッセージ5","（ＩＲ）不備メッセージ５");
        exStringEquals(siHubiteiseiBean.getIrHubimsg6(),"不備内容メッセージ6","（ＩＲ）不備メッセージ６");
        exStringEquals(siHubiteiseiBean.getIrHubimsg7(),"不備内容メッセージ7","（ＩＲ）不備メッセージ７");
        exStringEquals(siHubiteiseiBean.getIrHubimsg8(),"不備内容メッセージ8","（ＩＲ）不備メッセージ８");
        exStringEquals(siHubiteiseiBean.getIrHubimsg9(),null,"（ＩＲ）不備メッセージ９");
        exStringEquals(siHubiteiseiBean.getIrHubimsg10(),null,"（ＩＲ）不備メッセージ１０");
        exClassificationEquals(siHubiteiseiBean.getIrPageinfohyoujiumu(),C_UmuKbn.ARI,"（ＩＲ）ページ情報表示有無");
        exClassificationEquals(siHubiteiseiBean.getIrKarisakuseiumu(),C_UmuKbn.NONE,"（ＩＲ）仮作成有無");
        exClassificationEquals(siHubiteiseiBean.getIrGenponhnkykumu(),C_UmuKbn.NONE,"（ＩＲ）原本返却有無");
        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean) reportServicesBeanSisya
            .getParamObjectsData().get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[1];
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(),"取次者組織名","（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(),"110001","（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(),"取次者個人名","（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(),"2015年12月18日","（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(),"5 年","（ＩＲ）保存期間");
    }

    @Test
    @TestOrder(230)
    public void testExec_B20() {
        HubiTeiseisyoBean hubiTeiseisyoBean = SWAKInjector.getInstance(HubiTeiseisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151218));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.KK_SBKAIJYO_HB);
        hubiTeiseisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        hubiTeiseisyoBean.setSyono("11807111118");
        hubiTeiseisyoBean.setSeikyuusyanmKj("請求者漢字");
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean.setHubinaiyoumsg("不備内容メッセージ1");
        editHubiTeiseisyoItiranBean.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean.setHassinsakiKbn(C_HassinsakiKbn.SISYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean2 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean2.setHubinaiyoumsg("不備内容メッセージ2");
        editHubiTeiseisyoItiranBean2.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean2.setHassinsakiKbn(C_HassinsakiKbn.SISYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean3 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean3.setHubinaiyoumsg("不備内容メッセージ3");
        editHubiTeiseisyoItiranBean3.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean3.setHassinsakiKbn(C_HassinsakiKbn.SISYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean4 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean4.setHubinaiyoumsg("不備内容メッセージ4");
        editHubiTeiseisyoItiranBean4.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean4.setHassinsakiKbn(C_HassinsakiKbn.SISYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean5 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean5.setHubinaiyoumsg("不備内容メッセージ5");
        editHubiTeiseisyoItiranBean5.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean5.setHassinsakiKbn(C_HassinsakiKbn.SISYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean6 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean6.setHubinaiyoumsg("不備内容メッセージ6");
        editHubiTeiseisyoItiranBean6.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean6.setHassinsakiKbn(C_HassinsakiKbn.SISYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean7 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean7.setHubinaiyoumsg("不備内容メッセージ7");
        editHubiTeiseisyoItiranBean7.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean7.setHassinsakiKbn(C_HassinsakiKbn.SISYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean8 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean8.setHubinaiyoumsg("不備内容メッセージ8");
        editHubiTeiseisyoItiranBean8.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean8.setHassinsakiKbn(C_HassinsakiKbn.SISYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean9 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean9.setHubinaiyoumsg("不備内容メッセージ9");
        editHubiTeiseisyoItiranBean9.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean9.setHassinsakiKbn(C_HassinsakiKbn.SISYA);
        List<EditHubiTeiseisyoItiranBean> list = new ArrayList<>();
        list.add(editHubiTeiseisyoItiranBean);
        list.add(editHubiTeiseisyoItiranBean2);
        list.add(editHubiTeiseisyoItiranBean3);
        list.add(editHubiTeiseisyoItiranBean4);
        list.add(editHubiTeiseisyoItiranBean5);
        list.add(editHubiTeiseisyoItiranBean6);
        list.add(editHubiTeiseisyoItiranBean7);
        list.add(editHubiTeiseisyoItiranBean8);
        list.add(editHubiTeiseisyoItiranBean9);
        hubiTeiseisyoBean.setHubiTeiseisyoItiranLst(list);
        hubiTeiseisyoBean.setKarisakusei(false);
        hubiTeiseisyoBean.setToritsugisyakjncd("110001");
        hubiTeiseisyoBean.setToritsugisyakjnmei("取次者個人名");
        hubiTeiseisyoBean.setToritsugisyaSosikinm("取次者組織名");

        EditHubiTeiseisyoBean editHubiTeiseisyoBean = editHubiTeiseisyo.exec(hubiTeiseisyoBean);
        assertNull("帳票サービスBean（顧客）",editHubiTeiseisyoBean.getReportServicesBeanKok());
        ReportServicesBean reportServicesBeanSisya = editHubiTeiseisyoBean.getReportServicesBeanSisya();
        assertNull("帳票サービスBean（本社事務部門）",editHubiTeiseisyoBean.getReportServicesBeanHonsya());
        exStringEquals(reportServicesBeanSisya.getKensakuKeys()[0], "11807111118", "検索キー[0]");
        exDateEquals(reportServicesBeanSisya.getSyoriYmd(),BizDate.valueOf(20151218),"処理日付");
        SiHubiteiseiBean siHubiteiseiBean = (SiHubiteiseiBean) reportServicesBeanSisya.getParamObjectsData()
            .get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[0];
        exStringEquals(siHubiteiseiBean.getIrSyono(),"11807111118","（ＩＲ）証券番号");
        exStringEquals(siHubiteiseiBean.getIrSeikyuusyanmkj(),"請求者漢字","（ＩＲ）請求者（漢字）");
        exNumericEquals(siHubiteiseiBean.getIrRenno1(),1,"（ＩＲ）連番１");
        exNumericEquals(siHubiteiseiBean.getIrRenno2(),2,"（ＩＲ）連番２");
        exNumericEquals(siHubiteiseiBean.getIrRenno3(),3,"（ＩＲ）連番３");
        exNumericEquals(siHubiteiseiBean.getIrRenno4(),4,"（ＩＲ）連番４");
        exNumericEquals(siHubiteiseiBean.getIrRenno5(),5,"（ＩＲ）連番５");
        exNumericEquals(siHubiteiseiBean.getIrRenno6(),6,"（ＩＲ）連番６");
        exNumericEquals(siHubiteiseiBean.getIrRenno8(),8,"（ＩＲ）連番８");
        exNumericEquals(siHubiteiseiBean.getIrRenno9(),9,"（ＩＲ）連番９");
        assertNull("（ＩＲ）連番１０",siHubiteiseiBean.getIrRenno10());
        exStringEquals(siHubiteiseiBean.getIrHubimsg1(),"不備内容メッセージ1","（ＩＲ）不備メッセージ１");
        exStringEquals(siHubiteiseiBean.getIrHubimsg2(),"不備内容メッセージ2","（ＩＲ）不備メッセージ２");
        exStringEquals(siHubiteiseiBean.getIrHubimsg3(),"不備内容メッセージ3","（ＩＲ）不備メッセージ３");
        exStringEquals(siHubiteiseiBean.getIrHubimsg4(),"不備内容メッセージ4","（ＩＲ）不備メッセージ４");
        exStringEquals(siHubiteiseiBean.getIrHubimsg5(),"不備内容メッセージ5","（ＩＲ）不備メッセージ５");
        exStringEquals(siHubiteiseiBean.getIrHubimsg6(),"不備内容メッセージ6","（ＩＲ）不備メッセージ６");
        exStringEquals(siHubiteiseiBean.getIrHubimsg7(),"不備内容メッセージ7","（ＩＲ）不備メッセージ７");
        exStringEquals(siHubiteiseiBean.getIrHubimsg8(),"不備内容メッセージ8","（ＩＲ）不備メッセージ８");
        exStringEquals(siHubiteiseiBean.getIrHubimsg9(),"不備内容メッセージ9","（ＩＲ）不備メッセージ９");
        exStringEquals(siHubiteiseiBean.getIrHubimsg10(),null,"（ＩＲ）不備メッセージ１０");
        exClassificationEquals(siHubiteiseiBean.getIrPageinfohyoujiumu(),C_UmuKbn.ARI,"（ＩＲ）ページ情報表示有無");
        exClassificationEquals(siHubiteiseiBean.getIrKarisakuseiumu(),C_UmuKbn.NONE,"（ＩＲ）仮作成有無");
        exClassificationEquals(siHubiteiseiBean.getIrGenponhnkykumu(),C_UmuKbn.NONE,"（ＩＲ）原本返却有無");
        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean) reportServicesBeanSisya
            .getParamObjectsData().get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[1];
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(),"取次者組織名","（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(),"110001","（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(),"取次者個人名","（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(),"2015年12月18日","（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(),"5 年","（ＩＲ）保存期間");
    }

    @Test
    @TestOrder(240)
    public void testExec_B21() {
        HubiTeiseisyoBean hubiTeiseisyoBean = SWAKInjector.getInstance(HubiTeiseisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151218));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.KK_SBKAIJYO_HB);
        hubiTeiseisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        hubiTeiseisyoBean.setSyono("11807111118");
        hubiTeiseisyoBean.setSeikyuusyanmKj("請求者漢字");
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean.setHubinaiyoumsg("不備内容メッセージ1");
        editHubiTeiseisyoItiranBean.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean.setHassinsakiKbn(C_HassinsakiKbn.SISYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean2 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean2.setHubinaiyoumsg("不備内容メッセージ2");
        editHubiTeiseisyoItiranBean2.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean2.setHassinsakiKbn(C_HassinsakiKbn.SISYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean3 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean3.setHubinaiyoumsg("不備内容メッセージ3");
        editHubiTeiseisyoItiranBean3.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean3.setHassinsakiKbn(C_HassinsakiKbn.SISYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean4 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean4.setHubinaiyoumsg("不備内容メッセージ4");
        editHubiTeiseisyoItiranBean4.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean4.setHassinsakiKbn(C_HassinsakiKbn.SISYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean5 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean5.setHubinaiyoumsg("不備内容メッセージ5");
        editHubiTeiseisyoItiranBean5.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean5.setHassinsakiKbn(C_HassinsakiKbn.SISYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean6 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean6.setHubinaiyoumsg("不備内容メッセージ6");
        editHubiTeiseisyoItiranBean6.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean6.setHassinsakiKbn(C_HassinsakiKbn.SISYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean7 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean7.setHubinaiyoumsg("不備内容メッセージ7");
        editHubiTeiseisyoItiranBean7.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean7.setHassinsakiKbn(C_HassinsakiKbn.SISYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean8 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean8.setHubinaiyoumsg("不備内容メッセージ8");
        editHubiTeiseisyoItiranBean8.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean8.setHassinsakiKbn(C_HassinsakiKbn.SISYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean9 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean9.setHubinaiyoumsg("不備内容メッセージ9");
        editHubiTeiseisyoItiranBean9.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean9.setHassinsakiKbn(C_HassinsakiKbn.SISYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean10 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean10.setHubinaiyoumsg("不備内容メッセージ10");
        editHubiTeiseisyoItiranBean10.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean10.setHassinsakiKbn(C_HassinsakiKbn.SISYA);
        List<EditHubiTeiseisyoItiranBean> list = new ArrayList<>();
        list.add(editHubiTeiseisyoItiranBean);
        list.add(editHubiTeiseisyoItiranBean2);
        list.add(editHubiTeiseisyoItiranBean3);
        list.add(editHubiTeiseisyoItiranBean4);
        list.add(editHubiTeiseisyoItiranBean5);
        list.add(editHubiTeiseisyoItiranBean6);
        list.add(editHubiTeiseisyoItiranBean7);
        list.add(editHubiTeiseisyoItiranBean8);
        list.add(editHubiTeiseisyoItiranBean9);
        list.add(editHubiTeiseisyoItiranBean10);
        hubiTeiseisyoBean.setHubiTeiseisyoItiranLst(list);
        hubiTeiseisyoBean.setKarisakusei(false);
        hubiTeiseisyoBean.setToritsugisyakjncd("110001");
        hubiTeiseisyoBean.setToritsugisyakjnmei("取次者個人名");
        hubiTeiseisyoBean.setToritsugisyaSosikinm("取次者組織名");

        EditHubiTeiseisyoBean editHubiTeiseisyoBean = editHubiTeiseisyo.exec(hubiTeiseisyoBean);
        assertNull("帳票サービスBean（顧客）",editHubiTeiseisyoBean.getReportServicesBeanKok());
        ReportServicesBean reportServicesBeanSisya = editHubiTeiseisyoBean.getReportServicesBeanSisya();
        assertNull("帳票サービスBean（本社事務部門）",editHubiTeiseisyoBean.getReportServicesBeanHonsya());
        exStringEquals(reportServicesBeanSisya.getKensakuKeys()[0], "11807111118", "検索キー[0]");
        exDateEquals(reportServicesBeanSisya.getSyoriYmd(),BizDate.valueOf(20151218),"処理日付");
        SiHubiteiseiBean siHubiteiseiBean = (SiHubiteiseiBean) reportServicesBeanSisya.getParamObjectsData()
            .get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[0];
        exStringEquals(siHubiteiseiBean.getIrSyono(),"11807111118","（ＩＲ）証券番号");
        exStringEquals(siHubiteiseiBean.getIrSeikyuusyanmkj(),"請求者漢字","（ＩＲ）請求者（漢字）");
        exNumericEquals(siHubiteiseiBean.getIrRenno1(),1,"（ＩＲ）連番１");
        exNumericEquals(siHubiteiseiBean.getIrRenno2(),2,"（ＩＲ）連番２");
        exNumericEquals(siHubiteiseiBean.getIrRenno3(),3,"（ＩＲ）連番３");
        exNumericEquals(siHubiteiseiBean.getIrRenno4(),4,"（ＩＲ）連番４");
        exNumericEquals(siHubiteiseiBean.getIrRenno5(),5,"（ＩＲ）連番５");
        exNumericEquals(siHubiteiseiBean.getIrRenno6(),6,"（ＩＲ）連番６");
        exNumericEquals(siHubiteiseiBean.getIrRenno8(),8,"（ＩＲ）連番８");
        exNumericEquals(siHubiteiseiBean.getIrRenno9(),9,"（ＩＲ）連番９");
        exNumericEquals(siHubiteiseiBean.getIrRenno10(),10,"（ＩＲ）連番１０");
        exStringEquals(siHubiteiseiBean.getIrHubimsg1(),"不備内容メッセージ1","（ＩＲ）不備メッセージ１");
        exStringEquals(siHubiteiseiBean.getIrHubimsg2(),"不備内容メッセージ2","（ＩＲ）不備メッセージ２");
        exStringEquals(siHubiteiseiBean.getIrHubimsg3(),"不備内容メッセージ3","（ＩＲ）不備メッセージ３");
        exStringEquals(siHubiteiseiBean.getIrHubimsg4(),"不備内容メッセージ4","（ＩＲ）不備メッセージ４");
        exStringEquals(siHubiteiseiBean.getIrHubimsg5(),"不備内容メッセージ5","（ＩＲ）不備メッセージ５");
        exStringEquals(siHubiteiseiBean.getIrHubimsg6(),"不備内容メッセージ6","（ＩＲ）不備メッセージ６");
        exStringEquals(siHubiteiseiBean.getIrHubimsg7(),"不備内容メッセージ7","（ＩＲ）不備メッセージ７");
        exStringEquals(siHubiteiseiBean.getIrHubimsg8(),"不備内容メッセージ8","（ＩＲ）不備メッセージ８");
        exStringEquals(siHubiteiseiBean.getIrHubimsg9(),"不備内容メッセージ9","（ＩＲ）不備メッセージ９");
        exStringEquals(siHubiteiseiBean.getIrHubimsg10(),"不備内容メッセージ10","（ＩＲ）不備メッセージ１０");
        exClassificationEquals(siHubiteiseiBean.getIrPageinfohyoujiumu(),C_UmuKbn.ARI,"（ＩＲ）ページ情報表示有無");
        exClassificationEquals(siHubiteiseiBean.getIrKarisakuseiumu(),C_UmuKbn.NONE,"（ＩＲ）仮作成有無");
        exClassificationEquals(siHubiteiseiBean.getIrGenponhnkykumu(),C_UmuKbn.NONE,"（ＩＲ）原本返却有無");
        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean) reportServicesBeanSisya
            .getParamObjectsData().get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[1];
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(),"取次者組織名","（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(),"110001","（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(),"取次者個人名","（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(),"2015年12月18日","（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(),"5 年","（ＩＲ）保存期間");
    }

    @Test
    @TestOrder(250)
    public void testExec_B22() {
        HubiTeiseisyoBean hubiTeiseisyoBean = SWAKInjector.getInstance(HubiTeiseisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151218));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.KK_SBKAIJYO_HB);
        hubiTeiseisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        hubiTeiseisyoBean.setSyono("11807111118");
        hubiTeiseisyoBean.setSeikyuusyanmKj("請求者漢字");
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean.setHubinaiyoumsg("不備内容メッセージ1");
        editHubiTeiseisyoItiranBean.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean.setHassinsakiKbn(C_HassinsakiKbn.SYA);
        List<EditHubiTeiseisyoItiranBean> list = new ArrayList<>();
        list.add(editHubiTeiseisyoItiranBean);
        hubiTeiseisyoBean.setHubiTeiseisyoItiranLst(list);
        hubiTeiseisyoBean.setKarisakusei(false);
        hubiTeiseisyoBean.setToritsugisyakjncd("110001");
        hubiTeiseisyoBean.setToritsugisyakjnmei("取次者個人名");
        hubiTeiseisyoBean.setToritsugisyaSosikinm("取次者組織名");

        EditHubiTeiseisyoBean editHubiTeiseisyoBean = editHubiTeiseisyo.exec(hubiTeiseisyoBean);
        assertNull("帳票サービスBean（顧客）",editHubiTeiseisyoBean.getReportServicesBeanKok());
        assertNull("帳票サービスBean（支社）",editHubiTeiseisyoBean.getReportServicesBeanSisya());
        ReportServicesBean reportServicesBeanHonsya = editHubiTeiseisyoBean.getReportServicesBeanHonsya();
        exStringEquals(reportServicesBeanHonsya.getKensakuKeys()[0], "11807111118", "検索キー[0]");
        exDateEquals(reportServicesBeanHonsya.getSyoriYmd(),BizDate.valueOf(20151218),"処理日付");
        SiHubiteiseiBean siHubiteiseiBean = (SiHubiteiseiBean) reportServicesBeanHonsya.getParamObjectsData()
            .get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[0];
        exStringEquals(siHubiteiseiBean.getIrSyono(),"11807111118","（ＩＲ）証券番号");
        exStringEquals(siHubiteiseiBean.getIrSeikyuusyanmkj(),"請求者漢字","（ＩＲ）請求者（漢字）");
        exNumericEquals(siHubiteiseiBean.getIrRenno1(),1,"（ＩＲ）連番１");
        assertNull("（ＩＲ）連番２",siHubiteiseiBean.getIrRenno2());
        assertNull("（ＩＲ）連番３",siHubiteiseiBean.getIrRenno3());
        assertNull("（ＩＲ）連番４",siHubiteiseiBean.getIrRenno4());
        assertNull("（ＩＲ）連番５",siHubiteiseiBean.getIrRenno5());
        assertNull("（ＩＲ）連番６",siHubiteiseiBean.getIrRenno6());
        assertNull("（ＩＲ）連番７",siHubiteiseiBean.getIrRenno7());
        assertNull("（ＩＲ）連番８",siHubiteiseiBean.getIrRenno8());
        assertNull("（ＩＲ）連番９",siHubiteiseiBean.getIrRenno9());
        assertNull("（ＩＲ）連番１０",siHubiteiseiBean.getIrRenno10());
        exStringEquals(siHubiteiseiBean.getIrHubimsg1(),"不備内容メッセージ1","（ＩＲ）不備メッセージ１");
        exStringEquals(siHubiteiseiBean.getIrHubimsg2(),null,"（ＩＲ）不備メッセージ２");
        exStringEquals(siHubiteiseiBean.getIrHubimsg3(),null,"（ＩＲ）不備メッセージ３");
        exStringEquals(siHubiteiseiBean.getIrHubimsg4(),null,"（ＩＲ）不備メッセージ４");
        exStringEquals(siHubiteiseiBean.getIrHubimsg5(),null,"（ＩＲ）不備メッセージ５");
        exStringEquals(siHubiteiseiBean.getIrHubimsg6(),null,"（ＩＲ）不備メッセージ６");
        exStringEquals(siHubiteiseiBean.getIrHubimsg7(),null,"（ＩＲ）不備メッセージ７");
        exStringEquals(siHubiteiseiBean.getIrHubimsg8(),null,"（ＩＲ）不備メッセージ８");
        exStringEquals(siHubiteiseiBean.getIrHubimsg9(),null,"（ＩＲ）不備メッセージ９");
        exStringEquals(siHubiteiseiBean.getIrHubimsg10(),null,"（ＩＲ）不備メッセージ１０");
        exClassificationEquals(siHubiteiseiBean.getIrPageinfohyoujiumu(),C_UmuKbn.NONE,"（ＩＲ）ページ情報表示有無");
        exClassificationEquals(siHubiteiseiBean.getIrKarisakuseiumu(),C_UmuKbn.NONE,"（ＩＲ）仮作成有無");
        exClassificationEquals(siHubiteiseiBean.getIrGenponhnkykumu(),C_UmuKbn.NONE,"（ＩＲ）原本返却有無");
        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean) reportServicesBeanHonsya
            .getParamObjectsData().get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[1];
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(),"取次者組織名","（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(),"110001","（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(),"取次者個人名","（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(),"2015年12月18日","（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(),"5 年","（ＩＲ）保存期間");
    }

    @Test
    @TestOrder(260)
    public void testExec_B23() {
        HubiTeiseisyoBean hubiTeiseisyoBean = SWAKInjector.getInstance(HubiTeiseisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151218));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.KK_SBKAIJYO_HB);
        hubiTeiseisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        hubiTeiseisyoBean.setSyono("11807111118");
        hubiTeiseisyoBean.setSeikyuusyanmKj("請求者漢字");
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean.setHubinaiyoumsg("不備内容メッセージ1");
        editHubiTeiseisyoItiranBean.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean.setHassinsakiKbn(C_HassinsakiKbn.SYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean2 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean2.setHubinaiyoumsg("不備内容メッセージ2");
        editHubiTeiseisyoItiranBean2.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean2.setHassinsakiKbn(C_HassinsakiKbn.SYA);
        List<EditHubiTeiseisyoItiranBean> list = new ArrayList<>();
        list.add(editHubiTeiseisyoItiranBean);
        list.add(editHubiTeiseisyoItiranBean2);
        hubiTeiseisyoBean.setHubiTeiseisyoItiranLst(list);
        hubiTeiseisyoBean.setKarisakusei(false);
        hubiTeiseisyoBean.setToritsugisyakjncd("110001");
        hubiTeiseisyoBean.setToritsugisyakjnmei("取次者個人名");
        hubiTeiseisyoBean.setToritsugisyaSosikinm("取次者組織名");

        EditHubiTeiseisyoBean editHubiTeiseisyoBean = editHubiTeiseisyo.exec(hubiTeiseisyoBean);
        assertNull("帳票サービスBean（顧客）",editHubiTeiseisyoBean.getReportServicesBeanKok());
        assertNull("帳票サービスBean（支社）",editHubiTeiseisyoBean.getReportServicesBeanSisya());
        ReportServicesBean reportServicesBeanHonsya = editHubiTeiseisyoBean.getReportServicesBeanHonsya();
        exStringEquals(reportServicesBeanHonsya.getKensakuKeys()[0], "11807111118", "検索キー[0]");
        exDateEquals(reportServicesBeanHonsya.getSyoriYmd(),BizDate.valueOf(20151218),"処理日付");
        SiHubiteiseiBean siHubiteiseiBean = (SiHubiteiseiBean) reportServicesBeanHonsya.getParamObjectsData()
            .get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[0];
        exStringEquals(siHubiteiseiBean.getIrSyono(),"11807111118","（ＩＲ）証券番号");
        exStringEquals(siHubiteiseiBean.getIrSeikyuusyanmkj(),"請求者漢字","（ＩＲ）請求者（漢字）");
        exNumericEquals(siHubiteiseiBean.getIrRenno1(),1,"（ＩＲ）連番１");
        exNumericEquals(siHubiteiseiBean.getIrRenno2(),2,"（ＩＲ）連番２");
        assertNull("（ＩＲ）連番３",siHubiteiseiBean.getIrRenno3());
        assertNull("（ＩＲ）連番４",siHubiteiseiBean.getIrRenno4());
        assertNull("（ＩＲ）連番５",siHubiteiseiBean.getIrRenno5());
        assertNull("（ＩＲ）連番６",siHubiteiseiBean.getIrRenno6());
        assertNull("（ＩＲ）連番７",siHubiteiseiBean.getIrRenno7());
        assertNull("（ＩＲ）連番８",siHubiteiseiBean.getIrRenno8());
        assertNull("（ＩＲ）連番９",siHubiteiseiBean.getIrRenno9());
        assertNull("（ＩＲ）連番１０",siHubiteiseiBean.getIrRenno10());
        exStringEquals(siHubiteiseiBean.getIrHubimsg1(),"不備内容メッセージ1","（ＩＲ）不備メッセージ１");
        exStringEquals(siHubiteiseiBean.getIrHubimsg2(),"不備内容メッセージ2","（ＩＲ）不備メッセージ２");
        exStringEquals(siHubiteiseiBean.getIrHubimsg3(),null,"（ＩＲ）不備メッセージ３");
        exStringEquals(siHubiteiseiBean.getIrHubimsg4(),null,"（ＩＲ）不備メッセージ４");
        exStringEquals(siHubiteiseiBean.getIrHubimsg5(),null,"（ＩＲ）不備メッセージ５");
        exStringEquals(siHubiteiseiBean.getIrHubimsg6(),null,"（ＩＲ）不備メッセージ６");
        exStringEquals(siHubiteiseiBean.getIrHubimsg7(),null,"（ＩＲ）不備メッセージ７");
        exStringEquals(siHubiteiseiBean.getIrHubimsg8(),null,"（ＩＲ）不備メッセージ８");
        exStringEquals(siHubiteiseiBean.getIrHubimsg9(),null,"（ＩＲ）不備メッセージ９");
        exStringEquals(siHubiteiseiBean.getIrHubimsg10(),null,"（ＩＲ）不備メッセージ１０");
        exClassificationEquals(siHubiteiseiBean.getIrPageinfohyoujiumu(),C_UmuKbn.NONE,"（ＩＲ）ページ情報表示有無");
        exClassificationEquals(siHubiteiseiBean.getIrKarisakuseiumu(),C_UmuKbn.NONE,"（ＩＲ）仮作成有無");
        exClassificationEquals(siHubiteiseiBean.getIrGenponhnkykumu(),C_UmuKbn.NONE,"（ＩＲ）原本返却有無");
        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean) reportServicesBeanHonsya
            .getParamObjectsData().get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[1];
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(),"取次者組織名","（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(),"110001","（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(),"取次者個人名","（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(),"2015年12月18日","（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(),"5 年","（ＩＲ）保存期間");
    }

    @Test
    @TestOrder(270)
    public void testExec_B24() {
        HubiTeiseisyoBean hubiTeiseisyoBean = SWAKInjector.getInstance(HubiTeiseisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151218));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.KK_SBKAIJYO_HB);
        hubiTeiseisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        hubiTeiseisyoBean.setSyono("11807111118");
        hubiTeiseisyoBean.setSeikyuusyanmKj("請求者漢字");
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean.setHubinaiyoumsg("不備内容メッセージ1");
        editHubiTeiseisyoItiranBean.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean.setHassinsakiKbn(C_HassinsakiKbn.SYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean2 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean2.setHubinaiyoumsg("不備内容メッセージ2");
        editHubiTeiseisyoItiranBean2.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean2.setHassinsakiKbn(C_HassinsakiKbn.SYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean3 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean3.setHubinaiyoumsg("不備内容メッセージ3");
        editHubiTeiseisyoItiranBean3.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean3.setHassinsakiKbn(C_HassinsakiKbn.SYA);
        List<EditHubiTeiseisyoItiranBean> list = new ArrayList<>();
        list.add(editHubiTeiseisyoItiranBean);
        list.add(editHubiTeiseisyoItiranBean2);
        list.add(editHubiTeiseisyoItiranBean3);
        hubiTeiseisyoBean.setHubiTeiseisyoItiranLst(list);
        hubiTeiseisyoBean.setKarisakusei(false);
        hubiTeiseisyoBean.setToritsugisyakjncd("110001");
        hubiTeiseisyoBean.setToritsugisyakjnmei("取次者個人名");
        hubiTeiseisyoBean.setToritsugisyaSosikinm("取次者組織名");

        EditHubiTeiseisyoBean editHubiTeiseisyoBean = editHubiTeiseisyo.exec(hubiTeiseisyoBean);
        assertNull("帳票サービスBean（顧客）",editHubiTeiseisyoBean.getReportServicesBeanKok());
        assertNull("帳票サービスBean（支社）",editHubiTeiseisyoBean.getReportServicesBeanSisya());
        ReportServicesBean reportServicesBeanHonsya = editHubiTeiseisyoBean.getReportServicesBeanHonsya();
        exStringEquals(reportServicesBeanHonsya.getKensakuKeys()[0], "11807111118", "検索キー[0]");
        exDateEquals(reportServicesBeanHonsya.getSyoriYmd(),BizDate.valueOf(20151218),"処理日付");
        SiHubiteiseiBean siHubiteiseiBean = (SiHubiteiseiBean) reportServicesBeanHonsya.getParamObjectsData()
            .get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[0];
        exStringEquals(siHubiteiseiBean.getIrSyono(),"11807111118","（ＩＲ）証券番号");
        exStringEquals(siHubiteiseiBean.getIrSeikyuusyanmkj(),"請求者漢字","（ＩＲ）請求者（漢字）");
        exNumericEquals(siHubiteiseiBean.getIrRenno1(),1,"（ＩＲ）連番１");
        exNumericEquals(siHubiteiseiBean.getIrRenno2(),2,"（ＩＲ）連番２");
        exNumericEquals(siHubiteiseiBean.getIrRenno3(),3,"（ＩＲ）連番３");
        assertNull("（ＩＲ）連番４",siHubiteiseiBean.getIrRenno4());
        assertNull("（ＩＲ）連番５",siHubiteiseiBean.getIrRenno5());
        assertNull("（ＩＲ）連番６",siHubiteiseiBean.getIrRenno6());
        assertNull("（ＩＲ）連番７",siHubiteiseiBean.getIrRenno7());
        assertNull("（ＩＲ）連番８",siHubiteiseiBean.getIrRenno8());
        assertNull("（ＩＲ）連番９",siHubiteiseiBean.getIrRenno9());
        assertNull("（ＩＲ）連番１０",siHubiteiseiBean.getIrRenno10());
        exStringEquals(siHubiteiseiBean.getIrHubimsg1(),"不備内容メッセージ1","（ＩＲ）不備メッセージ１");
        exStringEquals(siHubiteiseiBean.getIrHubimsg2(),"不備内容メッセージ2","（ＩＲ）不備メッセージ２");
        exStringEquals(siHubiteiseiBean.getIrHubimsg3(),"不備内容メッセージ3","（ＩＲ）不備メッセージ３");
        exStringEquals(siHubiteiseiBean.getIrHubimsg4(),null,"（ＩＲ）不備メッセージ４");
        exStringEquals(siHubiteiseiBean.getIrHubimsg5(),null,"（ＩＲ）不備メッセージ５");
        exStringEquals(siHubiteiseiBean.getIrHubimsg6(),null,"（ＩＲ）不備メッセージ６");
        exStringEquals(siHubiteiseiBean.getIrHubimsg7(),null,"（ＩＲ）不備メッセージ７");
        exStringEquals(siHubiteiseiBean.getIrHubimsg8(),null,"（ＩＲ）不備メッセージ８");
        exStringEquals(siHubiteiseiBean.getIrHubimsg9(),null,"（ＩＲ）不備メッセージ９");
        exStringEquals(siHubiteiseiBean.getIrHubimsg10(),null,"（ＩＲ）不備メッセージ１０");
        exClassificationEquals(siHubiteiseiBean.getIrPageinfohyoujiumu(),C_UmuKbn.NONE,"（ＩＲ）ページ情報表示有無");
        exClassificationEquals(siHubiteiseiBean.getIrKarisakuseiumu(),C_UmuKbn.NONE,"（ＩＲ）仮作成有無");
        exClassificationEquals(siHubiteiseiBean.getIrGenponhnkykumu(),C_UmuKbn.NONE,"（ＩＲ）原本返却有無");
        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean) reportServicesBeanHonsya
            .getParamObjectsData().get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[1];
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(),"取次者組織名","（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(),"110001","（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(),"取次者個人名","（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(),"2015年12月18日","（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(),"5 年","（ＩＲ）保存期間");
    }

    @Test
    @TestOrder(280)
    public void testExec_B25() {
        HubiTeiseisyoBean hubiTeiseisyoBean = SWAKInjector.getInstance(HubiTeiseisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151218));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.KK_SBKAIJYO_HB);
        hubiTeiseisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        hubiTeiseisyoBean.setSyono("11807111118");
        hubiTeiseisyoBean.setSeikyuusyanmKj("請求者漢字");
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean.setHubinaiyoumsg("不備内容メッセージ1");
        editHubiTeiseisyoItiranBean.setGenponhnkykumu(C_UmuKbn.ARI);
        editHubiTeiseisyoItiranBean.setHassinsakiKbn(C_HassinsakiKbn.SYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean2 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean2.setHubinaiyoumsg("不備内容メッセージ2");
        editHubiTeiseisyoItiranBean2.setGenponhnkykumu(C_UmuKbn.ARI);
        editHubiTeiseisyoItiranBean2.setHassinsakiKbn(C_HassinsakiKbn.SYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean3 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean3.setHubinaiyoumsg("不備内容メッセージ3");
        editHubiTeiseisyoItiranBean3.setGenponhnkykumu(C_UmuKbn.ARI);
        editHubiTeiseisyoItiranBean3.setHassinsakiKbn(C_HassinsakiKbn.SYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean4 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean4.setHubinaiyoumsg("不備内容メッセージ4");
        editHubiTeiseisyoItiranBean4.setGenponhnkykumu(C_UmuKbn.ARI);
        editHubiTeiseisyoItiranBean4.setHassinsakiKbn(C_HassinsakiKbn.SYA);
        List<EditHubiTeiseisyoItiranBean> list = new ArrayList<>();
        list.add(editHubiTeiseisyoItiranBean);
        list.add(editHubiTeiseisyoItiranBean2);
        list.add(editHubiTeiseisyoItiranBean3);
        list.add(editHubiTeiseisyoItiranBean4);
        hubiTeiseisyoBean.setHubiTeiseisyoItiranLst(list);
        hubiTeiseisyoBean.setKarisakusei(true);
        hubiTeiseisyoBean.setToritsugisyakjncd("110001");
        hubiTeiseisyoBean.setToritsugisyakjnmei("取次者個人名");
        hubiTeiseisyoBean.setToritsugisyaSosikinm("取次者組織名");

        EditHubiTeiseisyoBean editHubiTeiseisyoBean = editHubiTeiseisyo.exec(hubiTeiseisyoBean);
        assertNull("帳票サービスBean（顧客）",editHubiTeiseisyoBean.getReportServicesBeanKok());
        assertNull("帳票サービスBean（支社）",editHubiTeiseisyoBean.getReportServicesBeanSisya());
        ReportServicesBean reportServicesBeanHonsya = editHubiTeiseisyoBean.getReportServicesBeanHonsya();
        exStringEquals(reportServicesBeanHonsya.getKensakuKeys()[0], "11807111118", "検索キー[0]");
        exDateEquals(reportServicesBeanHonsya.getSyoriYmd(),BizDate.valueOf(20151218),"処理日付");
        SiHubiteiseiBean siHubiteiseiBean = (SiHubiteiseiBean) reportServicesBeanHonsya.getParamObjectsData()
            .get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[0];
        exStringEquals(siHubiteiseiBean.getIrSyono(),"11807111118","（ＩＲ）証券番号");
        exStringEquals(siHubiteiseiBean.getIrSeikyuusyanmkj(),"請求者漢字","（ＩＲ）請求者（漢字）");
        exNumericEquals(siHubiteiseiBean.getIrRenno1(),1,"（ＩＲ）連番１");
        exNumericEquals(siHubiteiseiBean.getIrRenno2(),2,"（ＩＲ）連番２");
        exNumericEquals(siHubiteiseiBean.getIrRenno3(),3,"（ＩＲ）連番３");
        exNumericEquals(siHubiteiseiBean.getIrRenno4(),4,"（ＩＲ）連番４");
        assertNull("（ＩＲ）連番５",siHubiteiseiBean.getIrRenno5());
        assertNull("（ＩＲ）連番６",siHubiteiseiBean.getIrRenno6());
        assertNull("（ＩＲ）連番７",siHubiteiseiBean.getIrRenno7());
        assertNull("（ＩＲ）連番８",siHubiteiseiBean.getIrRenno8());
        assertNull("（ＩＲ）連番９",siHubiteiseiBean.getIrRenno9());
        assertNull("（ＩＲ）連番１０",siHubiteiseiBean.getIrRenno10());
        exStringEquals(siHubiteiseiBean.getIrHubimsg1(),"不備内容メッセージ1","（ＩＲ）不備メッセージ１");
        exStringEquals(siHubiteiseiBean.getIrHubimsg2(),"不備内容メッセージ2","（ＩＲ）不備メッセージ２");
        exStringEquals(siHubiteiseiBean.getIrHubimsg3(),"不備内容メッセージ3","（ＩＲ）不備メッセージ３");
        exStringEquals(siHubiteiseiBean.getIrHubimsg4(),"不備内容メッセージ4","（ＩＲ）不備メッセージ４");
        exStringEquals(siHubiteiseiBean.getIrHubimsg5(),null,"（ＩＲ）不備メッセージ５");
        exStringEquals(siHubiteiseiBean.getIrHubimsg6(),null,"（ＩＲ）不備メッセージ６");
        exStringEquals(siHubiteiseiBean.getIrHubimsg7(),null,"（ＩＲ）不備メッセージ７");
        exStringEquals(siHubiteiseiBean.getIrHubimsg8(),null,"（ＩＲ）不備メッセージ８");
        exStringEquals(siHubiteiseiBean.getIrHubimsg9(),null,"（ＩＲ）不備メッセージ９");
        exStringEquals(siHubiteiseiBean.getIrHubimsg10(),null,"（ＩＲ）不備メッセージ１０");
        exClassificationEquals(siHubiteiseiBean.getIrPageinfohyoujiumu(),C_UmuKbn.NONE,"（ＩＲ）ページ情報表示有無");
        exClassificationEquals(siHubiteiseiBean.getIrKarisakuseiumu(),C_UmuKbn.ARI,"（ＩＲ）仮作成有無");
        exClassificationEquals(siHubiteiseiBean.getIrGenponhnkykumu(),C_UmuKbn.ARI,"（ＩＲ）原本返却有無");
        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean) reportServicesBeanHonsya
            .getParamObjectsData().get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[1];
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(),"取次者組織名","（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(),"110001","（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(),"取次者個人名","（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(),"2015年12月18日","（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(),"5 年","（ＩＲ）保存期間");
    }

    @Test
    @TestOrder(290)
    public void testExec_B26() {
        HubiTeiseisyoBean hubiTeiseisyoBean = SWAKInjector.getInstance(HubiTeiseisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151218));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.KK_SBKAIJYO_HB);
        hubiTeiseisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        hubiTeiseisyoBean.setSyono("11807111118");
        hubiTeiseisyoBean.setSeikyuusyanmKj("請求者漢字");
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean.setHubinaiyoumsg("不備内容メッセージ1");
        editHubiTeiseisyoItiranBean.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean.setHassinsakiKbn(C_HassinsakiKbn.SYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean2 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean2.setHubinaiyoumsg("不備内容メッセージ2");
        editHubiTeiseisyoItiranBean2.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean2.setHassinsakiKbn(C_HassinsakiKbn.SYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean3 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean3.setHubinaiyoumsg("不備内容メッセージ3");
        editHubiTeiseisyoItiranBean3.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean3.setHassinsakiKbn(C_HassinsakiKbn.SYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean4 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean4.setHubinaiyoumsg("不備内容メッセージ4");
        editHubiTeiseisyoItiranBean4.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean4.setHassinsakiKbn(C_HassinsakiKbn.SYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean5 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean5.setHubinaiyoumsg("不備内容メッセージ5");
        editHubiTeiseisyoItiranBean5.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean5.setHassinsakiKbn(C_HassinsakiKbn.SYA);
        List<EditHubiTeiseisyoItiranBean> list = new ArrayList<>();
        list.add(editHubiTeiseisyoItiranBean);
        list.add(editHubiTeiseisyoItiranBean2);
        list.add(editHubiTeiseisyoItiranBean3);
        list.add(editHubiTeiseisyoItiranBean4);
        list.add(editHubiTeiseisyoItiranBean5);
        hubiTeiseisyoBean.setHubiTeiseisyoItiranLst(list);
        hubiTeiseisyoBean.setKarisakusei(false);
        hubiTeiseisyoBean.setToritsugisyakjncd("110001");
        hubiTeiseisyoBean.setToritsugisyakjnmei("取次者個人名");
        hubiTeiseisyoBean.setToritsugisyaSosikinm("取次者組織名");

        EditHubiTeiseisyoBean editHubiTeiseisyoBean = editHubiTeiseisyo.exec(hubiTeiseisyoBean);
        assertNull("帳票サービスBean（顧客）",editHubiTeiseisyoBean.getReportServicesBeanKok());
        assertNull("帳票サービスBean（支社）",editHubiTeiseisyoBean.getReportServicesBeanSisya());
        ReportServicesBean reportServicesBeanHonsya = editHubiTeiseisyoBean.getReportServicesBeanHonsya();
        exStringEquals(reportServicesBeanHonsya.getKensakuKeys()[0], "11807111118", "検索キー[0]");
        exDateEquals(reportServicesBeanHonsya.getSyoriYmd(),BizDate.valueOf(20151218),"処理日付");
        SiHubiteiseiBean siHubiteiseiBean = (SiHubiteiseiBean) reportServicesBeanHonsya.getParamObjectsData()
            .get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[0];
        exStringEquals(siHubiteiseiBean.getIrSyono(),"11807111118","（ＩＲ）証券番号");
        exStringEquals(siHubiteiseiBean.getIrSeikyuusyanmkj(),"請求者漢字","（ＩＲ）請求者（漢字）");
        exNumericEquals(siHubiteiseiBean.getIrRenno1(),1,"（ＩＲ）連番１");
        exNumericEquals(siHubiteiseiBean.getIrRenno2(),2,"（ＩＲ）連番２");
        exNumericEquals(siHubiteiseiBean.getIrRenno3(),3,"（ＩＲ）連番３");
        exNumericEquals(siHubiteiseiBean.getIrRenno4(),4,"（ＩＲ）連番４");
        exNumericEquals(siHubiteiseiBean.getIrRenno5(),5,"（ＩＲ）連番５");
        assertNull("（ＩＲ）連番６",siHubiteiseiBean.getIrRenno6());
        assertNull("（ＩＲ）連番７",siHubiteiseiBean.getIrRenno7());
        assertNull("（ＩＲ）連番８",siHubiteiseiBean.getIrRenno8());
        assertNull("（ＩＲ）連番９",siHubiteiseiBean.getIrRenno9());
        assertNull("（ＩＲ）連番１０",siHubiteiseiBean.getIrRenno10());
        exStringEquals(siHubiteiseiBean.getIrHubimsg1(),"不備内容メッセージ1","（ＩＲ）不備メッセージ１");
        exStringEquals(siHubiteiseiBean.getIrHubimsg2(),"不備内容メッセージ2","（ＩＲ）不備メッセージ２");
        exStringEquals(siHubiteiseiBean.getIrHubimsg3(),"不備内容メッセージ3","（ＩＲ）不備メッセージ３");
        exStringEquals(siHubiteiseiBean.getIrHubimsg4(),"不備内容メッセージ4","（ＩＲ）不備メッセージ４");
        exStringEquals(siHubiteiseiBean.getIrHubimsg5(),"不備内容メッセージ5","（ＩＲ）不備メッセージ５");
        exStringEquals(siHubiteiseiBean.getIrHubimsg6(),null,"（ＩＲ）不備メッセージ６");
        exStringEquals(siHubiteiseiBean.getIrHubimsg7(),null,"（ＩＲ）不備メッセージ７");
        exStringEquals(siHubiteiseiBean.getIrHubimsg8(),null,"（ＩＲ）不備メッセージ８");
        exStringEquals(siHubiteiseiBean.getIrHubimsg9(),null,"（ＩＲ）不備メッセージ９");
        exStringEquals(siHubiteiseiBean.getIrHubimsg10(),null,"（ＩＲ）不備メッセージ１０");
        exClassificationEquals(siHubiteiseiBean.getIrPageinfohyoujiumu(),C_UmuKbn.NONE,"（ＩＲ）ページ情報表示有無");
        exClassificationEquals(siHubiteiseiBean.getIrKarisakuseiumu(),C_UmuKbn.NONE,"（ＩＲ）仮作成有無");
        exClassificationEquals(siHubiteiseiBean.getIrGenponhnkykumu(),C_UmuKbn.NONE,"（ＩＲ）原本返却有無");
        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean) reportServicesBeanHonsya
            .getParamObjectsData().get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[1];
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(),"取次者組織名","（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(),"110001","（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(),"取次者個人名","（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(),"2015年12月18日","（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(),"5 年","（ＩＲ）保存期間");
    }

    @Test
    @TestOrder(300)
    public void testExec_B27() {
        HubiTeiseisyoBean hubiTeiseisyoBean = SWAKInjector.getInstance(HubiTeiseisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151218));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.KK_SBKAIJYO_HB);
        hubiTeiseisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        hubiTeiseisyoBean.setSyono("11807111118");
        hubiTeiseisyoBean.setSeikyuusyanmKj("請求者漢字");
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean.setHubinaiyoumsg("不備内容メッセージ1");
        editHubiTeiseisyoItiranBean.setGenponhnkykumu(C_UmuKbn.ARI);
        editHubiTeiseisyoItiranBean.setHassinsakiKbn(C_HassinsakiKbn.SYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean2 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean2.setHubinaiyoumsg("不備内容メッセージ2");
        editHubiTeiseisyoItiranBean2.setGenponhnkykumu(C_UmuKbn.ARI);
        editHubiTeiseisyoItiranBean2.setHassinsakiKbn(C_HassinsakiKbn.SYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean3 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean3.setHubinaiyoumsg("不備内容メッセージ3");
        editHubiTeiseisyoItiranBean3.setGenponhnkykumu(C_UmuKbn.ARI);
        editHubiTeiseisyoItiranBean3.setHassinsakiKbn(C_HassinsakiKbn.SYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean4 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean4.setHubinaiyoumsg("不備内容メッセージ4");
        editHubiTeiseisyoItiranBean4.setGenponhnkykumu(C_UmuKbn.ARI);
        editHubiTeiseisyoItiranBean4.setHassinsakiKbn(C_HassinsakiKbn.SYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean5 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean5.setHubinaiyoumsg("不備内容メッセージ5");
        editHubiTeiseisyoItiranBean5.setGenponhnkykumu(C_UmuKbn.ARI);
        editHubiTeiseisyoItiranBean5.setHassinsakiKbn(C_HassinsakiKbn.SYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean6 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean6.setHubinaiyoumsg("不備内容メッセージ6");
        editHubiTeiseisyoItiranBean6.setGenponhnkykumu(C_UmuKbn.ARI);
        editHubiTeiseisyoItiranBean6.setHassinsakiKbn(C_HassinsakiKbn.SYA);
        List<EditHubiTeiseisyoItiranBean> list = new ArrayList<>();
        list.add(editHubiTeiseisyoItiranBean);
        list.add(editHubiTeiseisyoItiranBean2);
        list.add(editHubiTeiseisyoItiranBean3);
        list.add(editHubiTeiseisyoItiranBean4);
        list.add(editHubiTeiseisyoItiranBean5);
        list.add(editHubiTeiseisyoItiranBean6);
        hubiTeiseisyoBean.setHubiTeiseisyoItiranLst(list);
        hubiTeiseisyoBean.setKarisakusei(true);
        hubiTeiseisyoBean.setToritsugisyakjncd("110001");
        hubiTeiseisyoBean.setToritsugisyakjnmei("取次者個人名");
        hubiTeiseisyoBean.setToritsugisyaSosikinm("取次者組織名");

        EditHubiTeiseisyoBean editHubiTeiseisyoBean = editHubiTeiseisyo.exec(hubiTeiseisyoBean);
        assertNull("帳票サービスBean（顧客）",editHubiTeiseisyoBean.getReportServicesBeanKok());
        assertNull("帳票サービスBean（支社）",editHubiTeiseisyoBean.getReportServicesBeanSisya());
        ReportServicesBean reportServicesBeanHonsya = editHubiTeiseisyoBean.getReportServicesBeanHonsya();
        exStringEquals(reportServicesBeanHonsya.getKensakuKeys()[0], "11807111118", "検索キー[0]");
        exDateEquals(reportServicesBeanHonsya.getSyoriYmd(),BizDate.valueOf(20151218),"処理日付");
        SiHubiteiseiBean siHubiteiseiBean = (SiHubiteiseiBean) reportServicesBeanHonsya.getParamObjectsData()
            .get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[0];
        exStringEquals(siHubiteiseiBean.getIrSyono(),"11807111118","（ＩＲ）証券番号");
        exStringEquals(siHubiteiseiBean.getIrSeikyuusyanmkj(),"請求者漢字","（ＩＲ）請求者（漢字）");
        exNumericEquals(siHubiteiseiBean.getIrRenno1(),1,"（ＩＲ）連番１");
        exNumericEquals(siHubiteiseiBean.getIrRenno2(),2,"（ＩＲ）連番２");
        exNumericEquals(siHubiteiseiBean.getIrRenno3(),3,"（ＩＲ）連番３");
        exNumericEquals(siHubiteiseiBean.getIrRenno4(),4,"（ＩＲ）連番４");
        exNumericEquals(siHubiteiseiBean.getIrRenno5(),5,"（ＩＲ）連番５");
        exNumericEquals(siHubiteiseiBean.getIrRenno6(),6,"（ＩＲ）連番６");
        assertNull("（ＩＲ）連番７",siHubiteiseiBean.getIrRenno7());
        assertNull("（ＩＲ）連番８",siHubiteiseiBean.getIrRenno8());
        assertNull("（ＩＲ）連番９",siHubiteiseiBean.getIrRenno9());
        assertNull("（ＩＲ）連番１０",siHubiteiseiBean.getIrRenno10());
        exStringEquals(siHubiteiseiBean.getIrHubimsg1(),"不備内容メッセージ1","（ＩＲ）不備メッセージ１");
        exStringEquals(siHubiteiseiBean.getIrHubimsg2(),"不備内容メッセージ2","（ＩＲ）不備メッセージ２");
        exStringEquals(siHubiteiseiBean.getIrHubimsg3(),"不備内容メッセージ3","（ＩＲ）不備メッセージ３");
        exStringEquals(siHubiteiseiBean.getIrHubimsg4(),"不備内容メッセージ4","（ＩＲ）不備メッセージ４");
        exStringEquals(siHubiteiseiBean.getIrHubimsg5(),"不備内容メッセージ5","（ＩＲ）不備メッセージ５");
        exStringEquals(siHubiteiseiBean.getIrHubimsg6(),"不備内容メッセージ6","（ＩＲ）不備メッセージ６");
        exStringEquals(siHubiteiseiBean.getIrHubimsg7(),null,"（ＩＲ）不備メッセージ７");
        exStringEquals(siHubiteiseiBean.getIrHubimsg8(),null,"（ＩＲ）不備メッセージ８");
        exStringEquals(siHubiteiseiBean.getIrHubimsg9(),null,"（ＩＲ）不備メッセージ９");
        exStringEquals(siHubiteiseiBean.getIrHubimsg10(),null,"（ＩＲ）不備メッセージ１０");
        exClassificationEquals(siHubiteiseiBean.getIrPageinfohyoujiumu(),C_UmuKbn.ARI,"（ＩＲ）ページ情報表示有無");
        exClassificationEquals(siHubiteiseiBean.getIrKarisakuseiumu(),C_UmuKbn.ARI,"（ＩＲ）仮作成有無");
        exClassificationEquals(siHubiteiseiBean.getIrGenponhnkykumu(),C_UmuKbn.ARI,"（ＩＲ）原本返却有無");
        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean) reportServicesBeanHonsya
            .getParamObjectsData().get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[1];
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(),"取次者組織名","（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(),"110001","（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(),"取次者個人名","（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(),"2015年12月18日","（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(),"5 年","（ＩＲ）保存期間");
    }

    @Test
    @TestOrder(310)
    public void testExec_B28() {
        HubiTeiseisyoBean hubiTeiseisyoBean = SWAKInjector.getInstance(HubiTeiseisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151218));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.KK_SBKAIJYO_HB);
        hubiTeiseisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        hubiTeiseisyoBean.setSyono("11807111118");
        hubiTeiseisyoBean.setSeikyuusyanmKj("請求者漢字");
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean.setHubinaiyoumsg("不備内容メッセージ1");
        editHubiTeiseisyoItiranBean.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean.setHassinsakiKbn(C_HassinsakiKbn.SYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean2 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean2.setHubinaiyoumsg("不備内容メッセージ2");
        editHubiTeiseisyoItiranBean2.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean2.setHassinsakiKbn(C_HassinsakiKbn.SYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean3 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean3.setHubinaiyoumsg("不備内容メッセージ3");
        editHubiTeiseisyoItiranBean3.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean3.setHassinsakiKbn(C_HassinsakiKbn.SYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean4 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean4.setHubinaiyoumsg("不備内容メッセージ4");
        editHubiTeiseisyoItiranBean4.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean4.setHassinsakiKbn(C_HassinsakiKbn.SYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean5 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean5.setHubinaiyoumsg("不備内容メッセージ5");
        editHubiTeiseisyoItiranBean5.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean5.setHassinsakiKbn(C_HassinsakiKbn.SYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean6 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean6.setHubinaiyoumsg("不備内容メッセージ6");
        editHubiTeiseisyoItiranBean6.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean6.setHassinsakiKbn(C_HassinsakiKbn.SYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean7 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean7.setHubinaiyoumsg("不備内容メッセージ7");
        editHubiTeiseisyoItiranBean7.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean7.setHassinsakiKbn(C_HassinsakiKbn.SYA);
        List<EditHubiTeiseisyoItiranBean> list = new ArrayList<>();
        list.add(editHubiTeiseisyoItiranBean);
        list.add(editHubiTeiseisyoItiranBean2);
        list.add(editHubiTeiseisyoItiranBean3);
        list.add(editHubiTeiseisyoItiranBean4);
        list.add(editHubiTeiseisyoItiranBean5);
        list.add(editHubiTeiseisyoItiranBean6);
        list.add(editHubiTeiseisyoItiranBean7);
        hubiTeiseisyoBean.setHubiTeiseisyoItiranLst(list);
        hubiTeiseisyoBean.setKarisakusei(false);
        hubiTeiseisyoBean.setToritsugisyakjncd("110001");
        hubiTeiseisyoBean.setToritsugisyakjnmei("取次者個人名");
        hubiTeiseisyoBean.setToritsugisyaSosikinm("取次者組織名");

        EditHubiTeiseisyoBean editHubiTeiseisyoBean = editHubiTeiseisyo.exec(hubiTeiseisyoBean);
        assertNull("帳票サービスBean（顧客）",editHubiTeiseisyoBean.getReportServicesBeanKok());
        assertNull("帳票サービスBean（支社）",editHubiTeiseisyoBean.getReportServicesBeanSisya());
        ReportServicesBean reportServicesBeanHonsya = editHubiTeiseisyoBean.getReportServicesBeanHonsya();
        exStringEquals(reportServicesBeanHonsya.getKensakuKeys()[0], "11807111118", "検索キー[0]");
        exDateEquals(reportServicesBeanHonsya.getSyoriYmd(),BizDate.valueOf(20151218),"処理日付");
        SiHubiteiseiBean siHubiteiseiBean = (SiHubiteiseiBean) reportServicesBeanHonsya.getParamObjectsData()
            .get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[0];
        exStringEquals(siHubiteiseiBean.getIrSyono(),"11807111118","（ＩＲ）証券番号");
        exStringEquals(siHubiteiseiBean.getIrSeikyuusyanmkj(),"請求者漢字","（ＩＲ）請求者（漢字）");
        exNumericEquals(siHubiteiseiBean.getIrRenno1(),1,"（ＩＲ）連番１");
        exNumericEquals(siHubiteiseiBean.getIrRenno2(),2,"（ＩＲ）連番２");
        exNumericEquals(siHubiteiseiBean.getIrRenno3(),3,"（ＩＲ）連番３");
        exNumericEquals(siHubiteiseiBean.getIrRenno4(),4,"（ＩＲ）連番４");
        exNumericEquals(siHubiteiseiBean.getIrRenno5(),5,"（ＩＲ）連番５");
        exNumericEquals(siHubiteiseiBean.getIrRenno6(),6,"（ＩＲ）連番６");
        exNumericEquals(siHubiteiseiBean.getIrRenno7(),7,"（ＩＲ）連番７");
        assertNull("（ＩＲ）連番８",siHubiteiseiBean.getIrRenno8());
        assertNull("（ＩＲ）連番９",siHubiteiseiBean.getIrRenno9());
        assertNull("（ＩＲ）連番１０",siHubiteiseiBean.getIrRenno10());
        exStringEquals(siHubiteiseiBean.getIrHubimsg1(),"不備内容メッセージ1","（ＩＲ）不備メッセージ１");
        exStringEquals(siHubiteiseiBean.getIrHubimsg2(),"不備内容メッセージ2","（ＩＲ）不備メッセージ２");
        exStringEquals(siHubiteiseiBean.getIrHubimsg3(),"不備内容メッセージ3","（ＩＲ）不備メッセージ３");
        exStringEquals(siHubiteiseiBean.getIrHubimsg4(),"不備内容メッセージ4","（ＩＲ）不備メッセージ４");
        exStringEquals(siHubiteiseiBean.getIrHubimsg5(),"不備内容メッセージ5","（ＩＲ）不備メッセージ５");
        exStringEquals(siHubiteiseiBean.getIrHubimsg6(),"不備内容メッセージ6","（ＩＲ）不備メッセージ６");
        exStringEquals(siHubiteiseiBean.getIrHubimsg7(),"不備内容メッセージ7","（ＩＲ）不備メッセージ７");
        exStringEquals(siHubiteiseiBean.getIrHubimsg8(),null,"（ＩＲ）不備メッセージ８");
        exStringEquals(siHubiteiseiBean.getIrHubimsg9(),null,"（ＩＲ）不備メッセージ９");
        exStringEquals(siHubiteiseiBean.getIrHubimsg10(),null,"（ＩＲ）不備メッセージ１０");
        exClassificationEquals(siHubiteiseiBean.getIrPageinfohyoujiumu(),C_UmuKbn.ARI,"（ＩＲ）ページ情報表示有無");
        exClassificationEquals(siHubiteiseiBean.getIrKarisakuseiumu(),C_UmuKbn.NONE,"（ＩＲ）仮作成有無");
        exClassificationEquals(siHubiteiseiBean.getIrGenponhnkykumu(),C_UmuKbn.NONE,"（ＩＲ）原本返却有無");
        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean) reportServicesBeanHonsya
            .getParamObjectsData().get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[1];
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(),"取次者組織名","（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(),"110001","（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(),"取次者個人名","（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(),"2015年12月18日","（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(),"5 年","（ＩＲ）保存期間");
    }

    @Test
    @TestOrder(320)
    public void testExec_B29() {
        HubiTeiseisyoBean hubiTeiseisyoBean = SWAKInjector.getInstance(HubiTeiseisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151218));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.KK_SBKAIJYO_HB);
        hubiTeiseisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        hubiTeiseisyoBean.setSyono("11807111118");
        hubiTeiseisyoBean.setSeikyuusyanmKj("請求者漢字");
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean.setHubinaiyoumsg("不備内容メッセージ1");
        editHubiTeiseisyoItiranBean.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean.setHassinsakiKbn(C_HassinsakiKbn.SYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean2 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean2.setHubinaiyoumsg("不備内容メッセージ2");
        editHubiTeiseisyoItiranBean2.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean2.setHassinsakiKbn(C_HassinsakiKbn.SYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean3 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean3.setHubinaiyoumsg("不備内容メッセージ3");
        editHubiTeiseisyoItiranBean3.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean3.setHassinsakiKbn(C_HassinsakiKbn.SYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean4 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean4.setHubinaiyoumsg("不備内容メッセージ4");
        editHubiTeiseisyoItiranBean4.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean4.setHassinsakiKbn(C_HassinsakiKbn.SYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean5 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean5.setHubinaiyoumsg("不備内容メッセージ5");
        editHubiTeiseisyoItiranBean5.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean5.setHassinsakiKbn(C_HassinsakiKbn.SYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean6 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean6.setHubinaiyoumsg("不備内容メッセージ6");
        editHubiTeiseisyoItiranBean6.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean6.setHassinsakiKbn(C_HassinsakiKbn.SYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean7 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean7.setHubinaiyoumsg("不備内容メッセージ7");
        editHubiTeiseisyoItiranBean7.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean7.setHassinsakiKbn(C_HassinsakiKbn.SYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean8 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean8.setHubinaiyoumsg("不備内容メッセージ8");
        editHubiTeiseisyoItiranBean8.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean8.setHassinsakiKbn(C_HassinsakiKbn.SYA);
        List<EditHubiTeiseisyoItiranBean> list = new ArrayList<>();
        list.add(editHubiTeiseisyoItiranBean);
        list.add(editHubiTeiseisyoItiranBean2);
        list.add(editHubiTeiseisyoItiranBean3);
        list.add(editHubiTeiseisyoItiranBean4);
        list.add(editHubiTeiseisyoItiranBean5);
        list.add(editHubiTeiseisyoItiranBean6);
        list.add(editHubiTeiseisyoItiranBean7);
        list.add(editHubiTeiseisyoItiranBean8);
        hubiTeiseisyoBean.setHubiTeiseisyoItiranLst(list);
        hubiTeiseisyoBean.setKarisakusei(false);
        hubiTeiseisyoBean.setToritsugisyakjncd("110001");
        hubiTeiseisyoBean.setToritsugisyakjnmei("取次者個人名");
        hubiTeiseisyoBean.setToritsugisyaSosikinm("取次者組織名");

        EditHubiTeiseisyoBean editHubiTeiseisyoBean = editHubiTeiseisyo.exec(hubiTeiseisyoBean);
        assertNull("帳票サービスBean（顧客）",editHubiTeiseisyoBean.getReportServicesBeanKok());
        assertNull("帳票サービスBean（支社）",editHubiTeiseisyoBean.getReportServicesBeanSisya());
        ReportServicesBean reportServicesBeanHonsya = editHubiTeiseisyoBean.getReportServicesBeanHonsya();
        exStringEquals(reportServicesBeanHonsya.getKensakuKeys()[0], "11807111118", "検索キー[0]");
        exDateEquals(reportServicesBeanHonsya.getSyoriYmd(),BizDate.valueOf(20151218),"処理日付");
        SiHubiteiseiBean siHubiteiseiBean = (SiHubiteiseiBean) reportServicesBeanHonsya.getParamObjectsData()
            .get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[0];
        exStringEquals(siHubiteiseiBean.getIrSyono(),"11807111118","（ＩＲ）証券番号");
        exStringEquals(siHubiteiseiBean.getIrSeikyuusyanmkj(),"請求者漢字","（ＩＲ）請求者（漢字）");
        exNumericEquals(siHubiteiseiBean.getIrRenno1(),1,"（ＩＲ）連番１");
        exNumericEquals(siHubiteiseiBean.getIrRenno2(),2,"（ＩＲ）連番２");
        exNumericEquals(siHubiteiseiBean.getIrRenno3(),3,"（ＩＲ）連番３");
        exNumericEquals(siHubiteiseiBean.getIrRenno4(),4,"（ＩＲ）連番４");
        exNumericEquals(siHubiteiseiBean.getIrRenno5(),5,"（ＩＲ）連番５");
        exNumericEquals(siHubiteiseiBean.getIrRenno6(),6,"（ＩＲ）連番６");
        exNumericEquals(siHubiteiseiBean.getIrRenno7(),7,"（ＩＲ）連番７");
        exNumericEquals(siHubiteiseiBean.getIrRenno8(),8,"（ＩＲ）連番８");
        assertNull("（ＩＲ）連番９",siHubiteiseiBean.getIrRenno9());
        assertNull("（ＩＲ）連番１０",siHubiteiseiBean.getIrRenno10());
        exStringEquals(siHubiteiseiBean.getIrHubimsg1(),"不備内容メッセージ1","（ＩＲ）不備メッセージ１");
        exStringEquals(siHubiteiseiBean.getIrHubimsg2(),"不備内容メッセージ2","（ＩＲ）不備メッセージ２");
        exStringEquals(siHubiteiseiBean.getIrHubimsg3(),"不備内容メッセージ3","（ＩＲ）不備メッセージ３");
        exStringEquals(siHubiteiseiBean.getIrHubimsg4(),"不備内容メッセージ4","（ＩＲ）不備メッセージ４");
        exStringEquals(siHubiteiseiBean.getIrHubimsg5(),"不備内容メッセージ5","（ＩＲ）不備メッセージ５");
        exStringEquals(siHubiteiseiBean.getIrHubimsg6(),"不備内容メッセージ6","（ＩＲ）不備メッセージ６");
        exStringEquals(siHubiteiseiBean.getIrHubimsg7(),"不備内容メッセージ7","（ＩＲ）不備メッセージ７");
        exStringEquals(siHubiteiseiBean.getIrHubimsg8(),"不備内容メッセージ8","（ＩＲ）不備メッセージ８");
        exStringEquals(siHubiteiseiBean.getIrHubimsg9(),null,"（ＩＲ）不備メッセージ９");
        exStringEquals(siHubiteiseiBean.getIrHubimsg10(),null,"（ＩＲ）不備メッセージ１０");
        exClassificationEquals(siHubiteiseiBean.getIrPageinfohyoujiumu(),C_UmuKbn.ARI,"（ＩＲ）ページ情報表示有無");
        exClassificationEquals(siHubiteiseiBean.getIrKarisakuseiumu(),C_UmuKbn.NONE,"（ＩＲ）仮作成有無");
        exClassificationEquals(siHubiteiseiBean.getIrGenponhnkykumu(),C_UmuKbn.NONE,"（ＩＲ）原本返却有無");
        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean) reportServicesBeanHonsya
            .getParamObjectsData().get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[1];
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(),"取次者組織名","（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(),"110001","（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(),"取次者個人名","（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(),"2015年12月18日","（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(),"5 年","（ＩＲ）保存期間");
    }

    @Test
    @TestOrder(330)
    public void testExec_B30() {
        HubiTeiseisyoBean hubiTeiseisyoBean = SWAKInjector.getInstance(HubiTeiseisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151218));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.KK_SBKAIJYO_HB);
        hubiTeiseisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        hubiTeiseisyoBean.setSyono("11807111118");
        hubiTeiseisyoBean.setSeikyuusyanmKj("請求者漢字");
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean.setHubinaiyoumsg("不備内容メッセージ1");
        editHubiTeiseisyoItiranBean.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean.setHassinsakiKbn(C_HassinsakiKbn.SYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean2 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean2.setHubinaiyoumsg("不備内容メッセージ2");
        editHubiTeiseisyoItiranBean2.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean2.setHassinsakiKbn(C_HassinsakiKbn.SYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean3 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean3.setHubinaiyoumsg("不備内容メッセージ3");
        editHubiTeiseisyoItiranBean3.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean3.setHassinsakiKbn(C_HassinsakiKbn.SYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean4 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean4.setHubinaiyoumsg("不備内容メッセージ4");
        editHubiTeiseisyoItiranBean4.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean4.setHassinsakiKbn(C_HassinsakiKbn.SYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean5 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean5.setHubinaiyoumsg("不備内容メッセージ5");
        editHubiTeiseisyoItiranBean5.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean5.setHassinsakiKbn(C_HassinsakiKbn.SYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean6 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean6.setHubinaiyoumsg("不備内容メッセージ6");
        editHubiTeiseisyoItiranBean6.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean6.setHassinsakiKbn(C_HassinsakiKbn.SYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean7 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean7.setHubinaiyoumsg("不備内容メッセージ7");
        editHubiTeiseisyoItiranBean7.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean7.setHassinsakiKbn(C_HassinsakiKbn.SYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean8 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean8.setHubinaiyoumsg("不備内容メッセージ8");
        editHubiTeiseisyoItiranBean8.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean8.setHassinsakiKbn(C_HassinsakiKbn.SYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean9 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean9.setHubinaiyoumsg("不備内容メッセージ9");
        editHubiTeiseisyoItiranBean9.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean9.setHassinsakiKbn(C_HassinsakiKbn.SYA);
        List<EditHubiTeiseisyoItiranBean> list = new ArrayList<>();
        list.add(editHubiTeiseisyoItiranBean);
        list.add(editHubiTeiseisyoItiranBean2);
        list.add(editHubiTeiseisyoItiranBean3);
        list.add(editHubiTeiseisyoItiranBean4);
        list.add(editHubiTeiseisyoItiranBean5);
        list.add(editHubiTeiseisyoItiranBean6);
        list.add(editHubiTeiseisyoItiranBean7);
        list.add(editHubiTeiseisyoItiranBean8);
        list.add(editHubiTeiseisyoItiranBean9);
        hubiTeiseisyoBean.setHubiTeiseisyoItiranLst(list);
        hubiTeiseisyoBean.setKarisakusei(false);
        hubiTeiseisyoBean.setToritsugisyakjncd("110001");
        hubiTeiseisyoBean.setToritsugisyakjnmei("取次者個人名");
        hubiTeiseisyoBean.setToritsugisyaSosikinm("取次者組織名");

        EditHubiTeiseisyoBean editHubiTeiseisyoBean = editHubiTeiseisyo.exec(hubiTeiseisyoBean);
        assertNull("帳票サービスBean（顧客）",editHubiTeiseisyoBean.getReportServicesBeanKok());
        assertNull("帳票サービスBean（支社）",editHubiTeiseisyoBean.getReportServicesBeanSisya());
        ReportServicesBean reportServicesBeanHonsya = editHubiTeiseisyoBean.getReportServicesBeanHonsya();
        exStringEquals(reportServicesBeanHonsya.getKensakuKeys()[0], "11807111118", "検索キー[0]");
        exDateEquals(reportServicesBeanHonsya.getSyoriYmd(),BizDate.valueOf(20151218),"処理日付");
        SiHubiteiseiBean siHubiteiseiBean = (SiHubiteiseiBean) reportServicesBeanHonsya.getParamObjectsData()
            .get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[0];
        exStringEquals(siHubiteiseiBean.getIrSyono(),"11807111118","（ＩＲ）証券番号");
        exStringEquals(siHubiteiseiBean.getIrSeikyuusyanmkj(),"請求者漢字","（ＩＲ）請求者（漢字）");
        exNumericEquals(siHubiteiseiBean.getIrRenno1(),1,"（ＩＲ）連番１");
        exNumericEquals(siHubiteiseiBean.getIrRenno2(),2,"（ＩＲ）連番２");
        exNumericEquals(siHubiteiseiBean.getIrRenno3(),3,"（ＩＲ）連番３");
        exNumericEquals(siHubiteiseiBean.getIrRenno4(),4,"（ＩＲ）連番４");
        exNumericEquals(siHubiteiseiBean.getIrRenno5(),5,"（ＩＲ）連番５");
        exNumericEquals(siHubiteiseiBean.getIrRenno6(),6,"（ＩＲ）連番６");
        exNumericEquals(siHubiteiseiBean.getIrRenno7(),7,"（ＩＲ）連番７");
        exNumericEquals(siHubiteiseiBean.getIrRenno8(),8,"（ＩＲ）連番８");
        exNumericEquals(siHubiteiseiBean.getIrRenno9(),9,"（ＩＲ）連番９");
        assertNull("（ＩＲ）連番１０",siHubiteiseiBean.getIrRenno10());
        exStringEquals(siHubiteiseiBean.getIrHubimsg1(),"不備内容メッセージ1","（ＩＲ）不備メッセージ１");
        exStringEquals(siHubiteiseiBean.getIrHubimsg2(),"不備内容メッセージ2","（ＩＲ）不備メッセージ２");
        exStringEquals(siHubiteiseiBean.getIrHubimsg3(),"不備内容メッセージ3","（ＩＲ）不備メッセージ３");
        exStringEquals(siHubiteiseiBean.getIrHubimsg4(),"不備内容メッセージ4","（ＩＲ）不備メッセージ４");
        exStringEquals(siHubiteiseiBean.getIrHubimsg5(),"不備内容メッセージ5","（ＩＲ）不備メッセージ５");
        exStringEquals(siHubiteiseiBean.getIrHubimsg6(),"不備内容メッセージ6","（ＩＲ）不備メッセージ６");
        exStringEquals(siHubiteiseiBean.getIrHubimsg7(),"不備内容メッセージ7","（ＩＲ）不備メッセージ７");
        exStringEquals(siHubiteiseiBean.getIrHubimsg8(),"不備内容メッセージ8","（ＩＲ）不備メッセージ８");
        exStringEquals(siHubiteiseiBean.getIrHubimsg9(),"不備内容メッセージ9","（ＩＲ）不備メッセージ９");
        exStringEquals(siHubiteiseiBean.getIrHubimsg10(),null,"（ＩＲ）不備メッセージ１０");
        exClassificationEquals(siHubiteiseiBean.getIrPageinfohyoujiumu(),C_UmuKbn.ARI,"（ＩＲ）ページ情報表示有無");
        exClassificationEquals(siHubiteiseiBean.getIrKarisakuseiumu(),C_UmuKbn.NONE,"（ＩＲ）仮作成有無");
        exClassificationEquals(siHubiteiseiBean.getIrGenponhnkykumu(),C_UmuKbn.NONE,"（ＩＲ）原本返却有無");
        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean) reportServicesBeanHonsya
            .getParamObjectsData().get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[1];
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(),"取次者組織名","（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(),"110001","（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(),"取次者個人名","（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(),"2015年12月18日","（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(),"5 年","（ＩＲ）保存期間");
    }

    @Test
    @TestOrder(340)
    public void testExec_B31() {
        HubiTeiseisyoBean hubiTeiseisyoBean = SWAKInjector.getInstance(HubiTeiseisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151218));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.KK_SBKAIJYO_HB);
        hubiTeiseisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        hubiTeiseisyoBean.setSyono("11807111118");
        hubiTeiseisyoBean.setSeikyuusyanmKj("請求者漢字");
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean.setHubinaiyoumsg("不備内容メッセージ1");
        editHubiTeiseisyoItiranBean.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean.setHassinsakiKbn(C_HassinsakiKbn.SYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean2 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean2.setHubinaiyoumsg("不備内容メッセージ2");
        editHubiTeiseisyoItiranBean2.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean2.setHassinsakiKbn(C_HassinsakiKbn.SYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean3 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean3.setHubinaiyoumsg("不備内容メッセージ3");
        editHubiTeiseisyoItiranBean3.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean3.setHassinsakiKbn(C_HassinsakiKbn.SYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean4 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean4.setHubinaiyoumsg("不備内容メッセージ4");
        editHubiTeiseisyoItiranBean4.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean4.setHassinsakiKbn(C_HassinsakiKbn.SYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean5 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean5.setHubinaiyoumsg("不備内容メッセージ5");
        editHubiTeiseisyoItiranBean5.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean5.setHassinsakiKbn(C_HassinsakiKbn.SYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean6 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean6.setHubinaiyoumsg("不備内容メッセージ6");
        editHubiTeiseisyoItiranBean6.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean6.setHassinsakiKbn(C_HassinsakiKbn.SYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean7 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean7.setHubinaiyoumsg("不備内容メッセージ7");
        editHubiTeiseisyoItiranBean7.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean7.setHassinsakiKbn(C_HassinsakiKbn.SYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean8 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean8.setHubinaiyoumsg("不備内容メッセージ8");
        editHubiTeiseisyoItiranBean8.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean8.setHassinsakiKbn(C_HassinsakiKbn.SYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean9 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean9.setHubinaiyoumsg("不備内容メッセージ9");
        editHubiTeiseisyoItiranBean9.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean9.setHassinsakiKbn(C_HassinsakiKbn.SYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean10 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean10.setHubinaiyoumsg("不備内容メッセージ10");
        editHubiTeiseisyoItiranBean10.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean10.setHassinsakiKbn(C_HassinsakiKbn.SYA);
        List<EditHubiTeiseisyoItiranBean> list = new ArrayList<>();
        list.add(editHubiTeiseisyoItiranBean);
        list.add(editHubiTeiseisyoItiranBean2);
        list.add(editHubiTeiseisyoItiranBean3);
        list.add(editHubiTeiseisyoItiranBean4);
        list.add(editHubiTeiseisyoItiranBean5);
        list.add(editHubiTeiseisyoItiranBean6);
        list.add(editHubiTeiseisyoItiranBean7);
        list.add(editHubiTeiseisyoItiranBean8);
        list.add(editHubiTeiseisyoItiranBean9);
        list.add(editHubiTeiseisyoItiranBean10);
        hubiTeiseisyoBean.setHubiTeiseisyoItiranLst(list);
        hubiTeiseisyoBean.setKarisakusei(false);
        hubiTeiseisyoBean.setToritsugisyakjncd("110001");
        hubiTeiseisyoBean.setToritsugisyakjnmei("取次者個人名");
        hubiTeiseisyoBean.setToritsugisyaSosikinm("取次者組織名");

        EditHubiTeiseisyoBean editHubiTeiseisyoBean = editHubiTeiseisyo.exec(hubiTeiseisyoBean);
        assertNull("帳票サービスBean（顧客）",editHubiTeiseisyoBean.getReportServicesBeanKok());
        assertNull("帳票サービスBean（支社）",editHubiTeiseisyoBean.getReportServicesBeanSisya());
        ReportServicesBean reportServicesBeanHonsya = editHubiTeiseisyoBean.getReportServicesBeanHonsya();
        exStringEquals(reportServicesBeanHonsya.getKensakuKeys()[0], "11807111118", "検索キー[0]");
        exDateEquals(reportServicesBeanHonsya.getSyoriYmd(),BizDate.valueOf(20151218),"処理日付");
        SiHubiteiseiBean siHubiteiseiBean = (SiHubiteiseiBean) reportServicesBeanHonsya.getParamObjectsData()
            .get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[0];
        exStringEquals(siHubiteiseiBean.getIrSyono(),"11807111118","（ＩＲ）証券番号");
        exStringEquals(siHubiteiseiBean.getIrSeikyuusyanmkj(),"請求者漢字","（ＩＲ）請求者（漢字）");
        exNumericEquals(siHubiteiseiBean.getIrRenno1(),1,"（ＩＲ）連番１");
        exNumericEquals(siHubiteiseiBean.getIrRenno2(),2,"（ＩＲ）連番２");
        exNumericEquals(siHubiteiseiBean.getIrRenno3(),3,"（ＩＲ）連番３");
        exNumericEquals(siHubiteiseiBean.getIrRenno4(),4,"（ＩＲ）連番４");
        exNumericEquals(siHubiteiseiBean.getIrRenno5(),5,"（ＩＲ）連番５");
        exNumericEquals(siHubiteiseiBean.getIrRenno6(),6,"（ＩＲ）連番６");
        exNumericEquals(siHubiteiseiBean.getIrRenno7(),7,"（ＩＲ）連番７");
        exNumericEquals(siHubiteiseiBean.getIrRenno8(),8,"（ＩＲ）連番８");
        exNumericEquals(siHubiteiseiBean.getIrRenno9(),9,"（ＩＲ）連番９");
        exNumericEquals(siHubiteiseiBean.getIrRenno10(),10,"（ＩＲ）連番１０");
        exStringEquals(siHubiteiseiBean.getIrHubimsg1(),"不備内容メッセージ1","（ＩＲ）不備メッセージ１");
        exStringEquals(siHubiteiseiBean.getIrHubimsg2(),"不備内容メッセージ2","（ＩＲ）不備メッセージ２");
        exStringEquals(siHubiteiseiBean.getIrHubimsg3(),"不備内容メッセージ3","（ＩＲ）不備メッセージ３");
        exStringEquals(siHubiteiseiBean.getIrHubimsg4(),"不備内容メッセージ4","（ＩＲ）不備メッセージ４");
        exStringEquals(siHubiteiseiBean.getIrHubimsg5(),"不備内容メッセージ5","（ＩＲ）不備メッセージ５");
        exStringEquals(siHubiteiseiBean.getIrHubimsg6(),"不備内容メッセージ6","（ＩＲ）不備メッセージ６");
        exStringEquals(siHubiteiseiBean.getIrHubimsg7(),"不備内容メッセージ7","（ＩＲ）不備メッセージ７");
        exStringEquals(siHubiteiseiBean.getIrHubimsg8(),"不備内容メッセージ8","（ＩＲ）不備メッセージ８");
        exStringEquals(siHubiteiseiBean.getIrHubimsg9(),"不備内容メッセージ9","（ＩＲ）不備メッセージ９");
        exStringEquals(siHubiteiseiBean.getIrHubimsg10(),"不備内容メッセージ10","（ＩＲ）不備メッセージ１０");
        exClassificationEquals(siHubiteiseiBean.getIrPageinfohyoujiumu(),C_UmuKbn.ARI,"（ＩＲ）ページ情報表示有無");
        exClassificationEquals(siHubiteiseiBean.getIrKarisakuseiumu(),C_UmuKbn.NONE,"（ＩＲ）仮作成有無");
        exClassificationEquals(siHubiteiseiBean.getIrGenponhnkykumu(),C_UmuKbn.NONE,"（ＩＲ）原本返却有無");
        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean = (BzSksKaisyasiyouranBean) reportServicesBeanHonsya
            .getParamObjectsData().get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[1];
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyasyozokunm(),"取次者組織名","（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyakjncd(),"110001","（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBean.getIrToritsugisyanm(),"取次者個人名","（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBean.getIrTyouhyousakuseiymd(),"2015年12月18日","（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBean.getIrHozonkkn(),"5 年","（ＩＲ）保存期間");
    }
    @Test
    @TestOrder(350)
    public void testExec_B32() {
        HubiTeiseisyoBean hubiTeiseisyoBean = SWAKInjector.getInstance(HubiTeiseisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151218));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.KK_SBKAIJYO_HB);
        hubiTeiseisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        hubiTeiseisyoBean.setSyono("11807111118");
        hubiTeiseisyoBean.setSeikyuusyanmKj("請求者漢字");
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean.setHubinaiyoumsg("不備内容メッセージ1");
        editHubiTeiseisyoItiranBean.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean.setHassinsakiKbn(C_HassinsakiKbn.KOK);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean2 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean2.setHubinaiyoumsg("不備内容メッセージ2");
        editHubiTeiseisyoItiranBean2.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean2.setHassinsakiKbn(C_HassinsakiKbn.SISYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean3 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean3.setHubinaiyoumsg("不備内容メッセージ3");
        editHubiTeiseisyoItiranBean3.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean3.setHassinsakiKbn(C_HassinsakiKbn.SYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean4 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean4.setHubinaiyoumsg("不備内容メッセージ4");
        editHubiTeiseisyoItiranBean4.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean4.setHassinsakiKbn(C_HassinsakiKbn.SISYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean5 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean5.setHubinaiyoumsg("不備内容メッセージ5");
        editHubiTeiseisyoItiranBean5.setGenponhnkykumu(C_UmuKbn.ARI);
        editHubiTeiseisyoItiranBean5.setHassinsakiKbn(C_HassinsakiKbn.SYA);
        EditHubiTeiseisyoItiranBean editHubiTeiseisyoItiranBean6 = new EditHubiTeiseisyoItiranBean();
        editHubiTeiseisyoItiranBean6.setHubinaiyoumsg("不備内容メッセージ6");
        editHubiTeiseisyoItiranBean6.setGenponhnkykumu(C_UmuKbn.NONE);
        editHubiTeiseisyoItiranBean6.setHassinsakiKbn(C_HassinsakiKbn.SYA);
        List<EditHubiTeiseisyoItiranBean> list = new ArrayList<>();
        list.add(editHubiTeiseisyoItiranBean);
        list.add(editHubiTeiseisyoItiranBean2);
        list.add(editHubiTeiseisyoItiranBean3);
        list.add(editHubiTeiseisyoItiranBean4);
        list.add(editHubiTeiseisyoItiranBean5);
        list.add(editHubiTeiseisyoItiranBean6);
        hubiTeiseisyoBean.setHubiTeiseisyoItiranLst(list);
        hubiTeiseisyoBean.setKarisakusei(false);
        hubiTeiseisyoBean.setToritsugisyakjncd("110001");
        hubiTeiseisyoBean.setToritsugisyakjnmei("取次者個人名");
        hubiTeiseisyoBean.setToritsugisyaSosikinm("取次者組織名");

        EditHubiTeiseisyoBean editHubiTeiseisyoBean = editHubiTeiseisyo.exec(hubiTeiseisyoBean);
        ReportServicesBean reportServicesBeanKok = editHubiTeiseisyoBean.getReportServicesBeanKok();
        ReportServicesBean reportServicesBeanSisya = editHubiTeiseisyoBean.getReportServicesBeanSisya();
        ReportServicesBean reportServicesBeanHonsya = editHubiTeiseisyoBean.getReportServicesBeanHonsya();
        exStringEquals(reportServicesBeanKok.getKensakuKeys()[0], "11807111118", "検索キー[0]");
        exDateEquals(reportServicesBeanKok.getSyoriYmd(),BizDate.valueOf(20151218),"処理日付");
        SiHubiteiseiBean siHubiteiseiBeanKok = (SiHubiteiseiBean) reportServicesBeanKok.getParamObjectsData()
            .get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[0];
        exStringEquals(siHubiteiseiBeanKok.getIrSyono(),"11807111118","（ＩＲ）証券番号");
        exStringEquals(siHubiteiseiBeanKok.getIrSeikyuusyanmkj(),"請求者漢字","（ＩＲ）請求者（漢字）");
        exNumericEquals(siHubiteiseiBeanKok.getIrRenno1(),1,"（ＩＲ）連番１");
        assertNull("（ＩＲ）連番２",siHubiteiseiBeanKok.getIrRenno2());
        assertNull("（ＩＲ）連番３",siHubiteiseiBeanKok.getIrRenno3());
        assertNull("（ＩＲ）連番４",siHubiteiseiBeanKok.getIrRenno4());
        assertNull("（ＩＲ）連番５",siHubiteiseiBeanKok.getIrRenno5());
        assertNull("（ＩＲ）連番６",siHubiteiseiBeanKok.getIrRenno6());
        assertNull("（ＩＲ）連番７",siHubiteiseiBeanKok.getIrRenno7());
        assertNull("（ＩＲ）連番８",siHubiteiseiBeanKok.getIrRenno8());
        assertNull("（ＩＲ）連番９",siHubiteiseiBeanKok.getIrRenno9());
        assertNull("（ＩＲ）連番１０",siHubiteiseiBeanKok.getIrRenno10());
        exStringEquals(siHubiteiseiBeanKok.getIrHubimsg1(),"不備内容メッセージ1","（ＩＲ）不備メッセージ１");
        assertNull("（ＩＲ）不備メッセージ２",siHubiteiseiBeanKok.getIrHubimsg2());
        assertNull("（ＩＲ）不備メッセージ３",siHubiteiseiBeanKok.getIrHubimsg3());
        assertNull("（ＩＲ）不備メッセージ４",siHubiteiseiBeanKok.getIrHubimsg4());
        assertNull("（ＩＲ）不備メッセージ５",siHubiteiseiBeanKok.getIrHubimsg5());
        assertNull("（ＩＲ）不備メッセージ６",siHubiteiseiBeanKok.getIrHubimsg6());
        assertNull("（ＩＲ）不備メッセージ７",siHubiteiseiBeanKok.getIrHubimsg7());
        assertNull("（ＩＲ）不備メッセージ８",siHubiteiseiBeanKok.getIrHubimsg8());
        assertNull("（ＩＲ）不備メッセージ９",siHubiteiseiBeanKok.getIrHubimsg9());
        assertNull("（ＩＲ）不備メッセージ１０",siHubiteiseiBeanKok.getIrHubimsg10());
        exClassificationEquals(siHubiteiseiBeanKok.getIrPageinfohyoujiumu(),C_UmuKbn.NONE,"（ＩＲ）ページ情報表示有無");
        exClassificationEquals(siHubiteiseiBeanKok.getIrKarisakuseiumu(),C_UmuKbn.NONE,"（ＩＲ）仮作成有無");
        exClassificationEquals(siHubiteiseiBeanKok.getIrGenponhnkykumu(),C_UmuKbn.NONE,"（ＩＲ）原本返却有無");
        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBeanKok = (BzSksKaisyasiyouranBean) reportServicesBeanKok
            .getParamObjectsData().get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[1];
        exStringEquals(bzSksKaisyasiyouranBeanKok.getIrToritsugisyasyozokunm(),"取次者組織名","（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBeanKok.getIrToritsugisyakjncd(),"110001","（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBeanKok.getIrToritsugisyanm(),"取次者個人名","（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBeanKok.getIrTyouhyousakuseiymd(),"2015年12月18日","（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBeanKok.getIrHozonkkn(),"5 年","（ＩＲ）保存期間");
        exStringEquals(reportServicesBeanSisya.getKensakuKeys()[0], "11807111118", "検索キー[0]");
        exDateEquals(reportServicesBeanSisya.getSyoriYmd(),BizDate.valueOf(20151218),"処理日付");
        SiHubiteiseiBean siHubiteiseiBeanSisya = (SiHubiteiseiBean) reportServicesBeanSisya.getParamObjectsData()
            .get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[0];
        exStringEquals(siHubiteiseiBeanSisya.getIrSyono(),"11807111118","（ＩＲ）証券番号");
        exStringEquals(siHubiteiseiBeanSisya.getIrSeikyuusyanmkj(),"請求者漢字","（ＩＲ）請求者（漢字）");
        exNumericEquals(siHubiteiseiBeanSisya.getIrRenno1(),1,"（ＩＲ）連番１");
        exNumericEquals(siHubiteiseiBeanSisya.getIrRenno2(),2,"（ＩＲ）連番２");
        assertNull("（ＩＲ）連番３",siHubiteiseiBeanSisya.getIrRenno3());
        assertNull("（ＩＲ）連番４",siHubiteiseiBeanSisya.getIrRenno4());
        assertNull("（ＩＲ）連番５",siHubiteiseiBeanSisya.getIrRenno5());
        assertNull("（ＩＲ）連番６",siHubiteiseiBeanSisya.getIrRenno6());
        assertNull("（ＩＲ）連番７",siHubiteiseiBeanSisya.getIrRenno7());
        assertNull("（ＩＲ）連番８",siHubiteiseiBeanSisya.getIrRenno8());
        assertNull("（ＩＲ）連番９",siHubiteiseiBeanSisya.getIrRenno9());
        assertNull("（ＩＲ）連番１０",siHubiteiseiBeanSisya.getIrRenno10());
        exStringEquals(siHubiteiseiBeanSisya.getIrHubimsg1(),"不備内容メッセージ2","（ＩＲ）不備メッセージ１");
        exStringEquals(siHubiteiseiBeanSisya.getIrHubimsg2(),"不備内容メッセージ4","（ＩＲ）不備メッセージ２");
        assertNull("（ＩＲ）不備メッセージ３",siHubiteiseiBeanSisya.getIrHubimsg3());
        assertNull("（ＩＲ）不備メッセージ４",siHubiteiseiBeanSisya.getIrHubimsg4());
        assertNull("（ＩＲ）不備メッセージ５",siHubiteiseiBeanSisya.getIrHubimsg5());
        assertNull("（ＩＲ）不備メッセージ６",siHubiteiseiBeanSisya.getIrHubimsg6());
        assertNull("（ＩＲ）不備メッセージ７",siHubiteiseiBeanSisya.getIrHubimsg7());
        assertNull("（ＩＲ）不備メッセージ８",siHubiteiseiBeanSisya.getIrHubimsg8());
        assertNull("（ＩＲ）不備メッセージ９",siHubiteiseiBeanSisya.getIrHubimsg9());
        assertNull("（ＩＲ）不備メッセージ１０",siHubiteiseiBeanSisya.getIrHubimsg10());
        exClassificationEquals(siHubiteiseiBeanSisya.getIrPageinfohyoujiumu(),C_UmuKbn.NONE,"（ＩＲ）ページ情報表示有無");
        exClassificationEquals(siHubiteiseiBeanSisya.getIrKarisakuseiumu(),C_UmuKbn.NONE,"（ＩＲ）仮作成有無");
        exClassificationEquals(siHubiteiseiBeanSisya.getIrGenponhnkykumu(),C_UmuKbn.NONE,"（ＩＲ）原本返却有無");
        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBeanSisya = (BzSksKaisyasiyouranBean) reportServicesBeanSisya
            .getParamObjectsData().get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[1];
        exStringEquals(bzSksKaisyasiyouranBeanSisya.getIrToritsugisyasyozokunm(),"取次者組織名","（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBeanSisya.getIrToritsugisyakjncd(),"110001","（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBeanSisya.getIrToritsugisyanm(),"取次者個人名","（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBeanSisya.getIrTyouhyousakuseiymd(),"2015年12月18日","（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBeanSisya.getIrHozonkkn(),"5 年","（ＩＲ）保存期間");
        exStringEquals(reportServicesBeanHonsya.getKensakuKeys()[0], "11807111118", "検索キー[0]");
        exDateEquals(reportServicesBeanHonsya.getSyoriYmd(),BizDate.valueOf(20151218),"処理日付");
        SiHubiteiseiBean siHubiteiseiBeanHonsya = (SiHubiteiseiBean) reportServicesBeanHonsya.getParamObjectsData()
            .get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[0];
        exStringEquals(siHubiteiseiBeanHonsya.getIrSyono(),"11807111118","（ＩＲ）証券番号");
        exStringEquals(siHubiteiseiBeanHonsya.getIrSeikyuusyanmkj(),"請求者漢字","（ＩＲ）請求者（漢字）");
        exNumericEquals(siHubiteiseiBeanHonsya.getIrRenno1(),1,"（ＩＲ）連番１");
        exNumericEquals(siHubiteiseiBeanHonsya.getIrRenno2(),2,"（ＩＲ）連番２");
        exNumericEquals(siHubiteiseiBeanHonsya.getIrRenno3(),3,"（ＩＲ）連番３");
        assertNull("（ＩＲ）連番４",siHubiteiseiBeanHonsya.getIrRenno4());
        assertNull("（ＩＲ）連番５",siHubiteiseiBeanHonsya.getIrRenno5());
        assertNull("（ＩＲ）連番６",siHubiteiseiBeanHonsya.getIrRenno6());
        assertNull("（ＩＲ）連番７",siHubiteiseiBeanHonsya.getIrRenno7());
        assertNull("（ＩＲ）連番８",siHubiteiseiBeanHonsya.getIrRenno8());
        assertNull("（ＩＲ）連番９",siHubiteiseiBeanHonsya.getIrRenno9());
        assertNull("（ＩＲ）連番１０",siHubiteiseiBeanHonsya.getIrRenno10());
        exStringEquals(siHubiteiseiBeanHonsya.getIrHubimsg1(),"不備内容メッセージ3","（ＩＲ）不備メッセージ１");
        exStringEquals(siHubiteiseiBeanHonsya.getIrHubimsg2(),"不備内容メッセージ5","（ＩＲ）不備メッセージ２");
        exStringEquals(siHubiteiseiBeanHonsya.getIrHubimsg3(),"不備内容メッセージ6","（ＩＲ）不備メッセージ３");
        assertNull("（ＩＲ）不備メッセージ４",siHubiteiseiBeanHonsya.getIrHubimsg4());
        assertNull("（ＩＲ）不備メッセージ５",siHubiteiseiBeanHonsya.getIrHubimsg5());
        assertNull("（ＩＲ）不備メッセージ６",siHubiteiseiBeanHonsya.getIrHubimsg6());
        assertNull("（ＩＲ）不備メッセージ７",siHubiteiseiBeanHonsya.getIrHubimsg7());
        assertNull("（ＩＲ）不備メッセージ８",siHubiteiseiBeanHonsya.getIrHubimsg8());
        assertNull("（ＩＲ）不備メッセージ９",siHubiteiseiBeanHonsya.getIrHubimsg9());
        assertNull("（ＩＲ）不備メッセージ１０",siHubiteiseiBeanHonsya.getIrHubimsg10());
        exClassificationEquals(siHubiteiseiBeanHonsya.getIrPageinfohyoujiumu(),C_UmuKbn.NONE,"（ＩＲ）ページ情報表示有無");
        exClassificationEquals(siHubiteiseiBeanHonsya.getIrKarisakuseiumu(),C_UmuKbn.NONE,"（ＩＲ）仮作成有無");
        exClassificationEquals(siHubiteiseiBeanHonsya.getIrGenponhnkykumu(),C_UmuKbn.ARI,"（ＩＲ）原本返却有無");
        BzSksKaisyasiyouranBean bzSksKaisyasiyouranBeanHonsya = (BzSksKaisyasiyouranBean) reportServicesBeanHonsya
            .getParamObjectsData().get(C_SyoruiCdKbn.KK_SBKAIJYO_HB.getValue())[1];
        exStringEquals(bzSksKaisyasiyouranBeanHonsya.getIrToritsugisyasyozokunm(),"取次者組織名","（ＩＲ）取次者所属名");
        exStringEquals(bzSksKaisyasiyouranBeanHonsya.getIrToritsugisyakjncd(),"110001","（ＩＲ）取次者個人コード");
        exStringEquals(bzSksKaisyasiyouranBeanHonsya.getIrToritsugisyanm(),"取次者個人名","（ＩＲ）取次者氏名");
        exStringEquals(bzSksKaisyasiyouranBeanHonsya.getIrTyouhyousakuseiymd(),"2015年12月18日","（ＩＲ）帳票作成日");
        exStringEquals(bzSksKaisyasiyouranBeanHonsya.getIrHozonkkn(),"5 年","（ＩＲ）保存期間");
    }
}
