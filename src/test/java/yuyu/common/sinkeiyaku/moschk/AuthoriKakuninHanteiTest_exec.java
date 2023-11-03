package yuyu.common.sinkeiyaku.moschk;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.dao.HT_SyoriCTLDao;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * オーソリ確認判定クラスのメソッド {@link AuthoriKakuninHantei#exec(MosnaiCheckParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class AuthoriKakuninHanteiTest_exec {

    @Inject
    private AuthoriKakuninHantei authoriKakuninHantei;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    private final static String mosNo1 = "791112220";

    private final static String mosNo2 = "791112238";

    private final static String mosNo3 = "791112246";

    private final static String mosNo4 = "791112253";

    private final static String mosNo5 = "791112261";

    private final static String mosNo6 = "791112279";

    private final static String mosNo7 = "791112287";

    private final static String mosNo8 = "791112295";

    private final static String mosNo9 = "791112303";

    private final static String mosNo10 = "791112311";

    private final static String mosNo11 = "791112329";

    private final static String mosNo12 = "791112337";

    private final static String mosNo13 = "791112345";

    private final static String mosNo14 = "791112352";

    private final static String fileName = "UT_SP_単体テスト仕様書_オーソリ確認判定";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(AuthoriKakuninHanteiTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTLDao syoriCTLDao = SWAKInjector.getInstance(HT_SyoriCTLDao.class);
        sinkeiyakuDomManager.delete(syoriCTLDao.selectAll());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        MosnaiCheckParam pMp = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo1);

        pMp.setDataSyoriControl(syoriCTL);
        pMp.setCreditCardInfoTblChkErrUmu(C_UmuKbn.NONE);

        authoriKakuninHantei.exec(pMp);
        //        exClassificationEquals(pMp.getDataSyoriControl().getAuthorisousinkhkbn(), C_KahiKbn.KA, "オーソリ送信可否区分");
        //        exClassificationEquals(pMp.getDataSyoriControl().getAuthorijkkbn(), C_AuthorijkKbn.IRAIMATI, "オーソリ状況区分");
        //        exDateEquals(pMp.getDataSyoriControl().getFstauthorikanryoymd(), BizDate.valueOf("20150624"), "初回オーソリ完了日");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        MosnaiCheckParam pMp = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo2);

        pMp.setDataSyoriControl(syoriCTL);
        pMp.setCreditCardInfoTblChkErrUmu(C_UmuKbn.NONE);

        authoriKakuninHantei.exec(pMp);
        //        exClassificationEquals(pMp.getDataSyoriControl().getAuthorisousinkhkbn(), C_KahiKbn.HUKA, "オーソリ送信可否区分");
        //        exClassificationEquals(pMp.getDataSyoriControl().getAuthorijkkbn(), C_AuthorijkKbn.HUYOU, "オーソリ状況区分");
        //        exDateEquals(pMp.getDataSyoriControl().getFstauthorikanryoymd(), null, "初回オーソリ完了日");

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        MosnaiCheckParam pMp = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo3);

        pMp.setDataSyoriControl(syoriCTL);
        pMp.setCreditCardInfoTblChkErrUmu(C_UmuKbn.NONE);

        authoriKakuninHantei.exec(pMp);
        //        exClassificationEquals(pMp.getDataSyoriControl().getAuthorisousinkhkbn(), C_KahiKbn.HUKA, "オーソリ送信可否区分");
        //        exClassificationEquals(pMp.getDataSyoriControl().getAuthorijkkbn(), C_AuthorijkKbn.HUYOU, "オーソリ状況区分");
        //        exDateEquals(pMp.getDataSyoriControl().getFstauthorikanryoymd(), null, "初回オーソリ完了日");

    }

    @Test
    @TestOrder(40)
    public void testExec_B1() {

        MosnaiCheckParam pMp = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo4);

        pMp.setDataSyoriControl(syoriCTL);
        pMp.setCreditCardInfoTblChkErrUmu(C_UmuKbn.NONE);

        authoriKakuninHantei.exec(pMp);
        //        exClassificationEquals(pMp.getDataSyoriControl().getAuthorisousinkhkbn(), C_KahiKbn.HUKA, "オーソリ送信可否区分");
        //        exClassificationEquals(pMp.getDataSyoriControl().getAuthorijkkbn(), C_AuthorijkKbn.HUYOU, "オーソリ状況区分");
        //        exDateEquals(pMp.getDataSyoriControl().getFstauthorikanryoymd(), null, "初回オーソリ完了日");

    }

    @Test
    @TestOrder(50)
    public void testExec_B2() {

        MosnaiCheckParam pMp = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo5);

        pMp.setDataSyoriControl(syoriCTL);
        pMp.setCreditCardInfoTblChkErrUmu(C_UmuKbn.NONE);

        authoriKakuninHantei.exec(pMp);
        //        exClassificationEquals(pMp.getDataSyoriControl().getAuthorisousinkhkbn(), C_KahiKbn.HUKA, "オーソリ送信可否区分");
        //        exClassificationEquals(pMp.getDataSyoriControl().getAuthorijkkbn(), C_AuthorijkKbn.HUYOU, "オーソリ状況区分");
        //        exDateEquals(pMp.getDataSyoriControl().getFstauthorikanryoymd(), null, "初回オーソリ完了日");

    }

    @Test
    @TestOrder(60)
    public void testExec_B3() {

        MosnaiCheckParam pMp = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo6);

        pMp.setDataSyoriControl(syoriCTL);
        pMp.setCreditCardInfoTblChkErrUmu(C_UmuKbn.NONE);

        authoriKakuninHantei.exec(pMp);
        //        exClassificationEquals(pMp.getDataSyoriControl().getAuthorisousinkhkbn(), C_KahiKbn.HUKA, "オーソリ送信可否区分");
        //        exClassificationEquals(pMp.getDataSyoriControl().getAuthorijkkbn(), C_AuthorijkKbn.OK, "オーソリ状況区分");
        //        exDateEquals(pMp.getDataSyoriControl().getFstauthorikanryoymd(), BizDate.valueOf("20150628"), "初回オーソリ完了日");
    }

    @Test
    @TestOrder(70)
    public void testExec_B4() {

        MosnaiCheckParam pMp = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo7);

        pMp.setDataSyoriControl(syoriCTL);
        pMp.setCreditCardInfoTblChkErrUmu(C_UmuKbn.NONE);

        authoriKakuninHantei.exec(pMp);
        //        exClassificationEquals(pMp.getDataSyoriControl().getAuthorisousinkhkbn(), C_KahiKbn.HUKA, "オーソリ送信可否区分");
        //        exClassificationEquals(pMp.getDataSyoriControl().getAuthorijkkbn(), C_AuthorijkKbn.IRAITYUU, "オーソリ状況区分");
        //        exDateEquals(pMp.getDataSyoriControl().getFstauthorikanryoymd(), BizDate.valueOf("20150630"), "初回オーソリ完了日");
    }

    @Test
    @TestOrder(80)
    public void testExec_B5() {

        MosnaiCheckParam pMp = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo8);

        pMp.setDataSyoriControl(syoriCTL);
        pMp.setCreditCardInfoTblChkErrUmu(C_UmuKbn.NONE);

        authoriKakuninHantei.exec(pMp);
        //        exClassificationEquals(pMp.getDataSyoriControl().getAuthorisousinkhkbn(), C_KahiKbn.HUKA, "オーソリ送信可否区分");
        //        exClassificationEquals(pMp.getDataSyoriControl().getAuthorijkkbn(), C_AuthorijkKbn.IRAIMATI, "オーソリ状況区分");
        //        exDateEquals(pMp.getDataSyoriControl().getFstauthorikanryoymd(), BizDate.valueOf("20150701"), "初回オーソリ完了日");
    }

    @Test
    @TestOrder(90)
    public void testExec_B6() {

        MosnaiCheckParam pMp = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo9);

        pMp.setDataSyoriControl(syoriCTL);
        pMp.setCreditCardInfoTblChkErrUmu(C_UmuKbn.NONE);

        authoriKakuninHantei.exec(pMp);
        //        exClassificationEquals(pMp.getDataSyoriControl().getAuthorisousinkhkbn(), C_KahiKbn.HUKA, "オーソリ送信可否区分");
        //        exClassificationEquals(pMp.getDataSyoriControl().getAuthorijkkbn(), C_AuthorijkKbn.IRAIMATI, "オーソリ状況区分");
        //        exDateEquals(pMp.getDataSyoriControl().getFstauthorikanryoymd(), BizDate.valueOf("20150702"), "初回オーソリ完了日");
    }

    @Test
    @TestOrder(100)
    public void testExec_B7() {

        MosnaiCheckParam pMp = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo10);

        pMp.setDataSyoriControl(syoriCTL);
        pMp.setCreditCardInfoTblChkErrUmu(C_UmuKbn.ARI);

        authoriKakuninHantei.exec(pMp);
        //        exClassificationEquals(pMp.getDataSyoriControl().getAuthorisousinkhkbn(), C_KahiKbn.HUKA, "オーソリ送信可否区分");
        //        exClassificationEquals(pMp.getDataSyoriControl().getAuthorijkkbn(), C_AuthorijkKbn.OK, "オーソリ状況区分");
        //        exDateEquals(pMp.getDataSyoriControl().getFstauthorikanryoymd(), BizDate.valueOf("20150703"), "初回オーソリ完了日");
    }

    @Test
    @TestOrder(110)
    public void testExec_B8() {

        MosnaiCheckParam pMp = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo11);

        pMp.setDataSyoriControl(syoriCTL);
        pMp.setCreditCardInfoTblChkErrUmu(C_UmuKbn.NONE);

        authoriKakuninHantei.exec(pMp);
        //        exClassificationEquals(pMp.getDataSyoriControl().getAuthorisousinkhkbn(), C_KahiKbn.KA, "オーソリ送信可否区分");
        //        exClassificationEquals(pMp.getDataSyoriControl().getAuthorijkkbn(), C_AuthorijkKbn.OK, "オーソリ状況区分");
        //        exDateEquals(pMp.getDataSyoriControl().getFstauthorikanryoymd(), BizDate.valueOf("20150704"), "初回オーソリ完了日");
    }

    @Test
    @TestOrder(120)
    public void testExec_B9() {

        MosnaiCheckParam pMp = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo12);

        pMp.setDataSyoriControl(syoriCTL);
        pMp.setCreditCardInfoTblChkErrUmu(C_UmuKbn.NONE);

        authoriKakuninHantei.exec(pMp);
        //        exClassificationEquals(pMp.getDataSyoriControl().getAuthorisousinkhkbn(), C_KahiKbn.KA, "オーソリ送信可否区分");
        //        exClassificationEquals(pMp.getDataSyoriControl().getAuthorijkkbn(), C_AuthorijkKbn.IRAIMATI, "オーソリ状況区分");
        //        exDateEquals(pMp.getDataSyoriControl().getFstauthorikanryoymd(), BizDate.valueOf("20150705"), "初回オーソリ完了日");
    }

    @Test
    @TestOrder(130)
    public void testExec_B10() {

        MosnaiCheckParam pMp = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo13);

        pMp.setDataSyoriControl(syoriCTL);
        pMp.setCreditCardInfoTblChkErrUmu(C_UmuKbn.NONE);

        authoriKakuninHantei.exec(pMp);
        //        exClassificationEquals(pMp.getDataSyoriControl().getAuthorisousinkhkbn(), C_KahiKbn.KA, "オーソリ送信可否区分");
        //        exClassificationEquals(pMp.getDataSyoriControl().getAuthorijkkbn(), C_AuthorijkKbn.NG, "オーソリ状況区分");
        //        exDateEquals(pMp.getDataSyoriControl().getFstauthorikanryoymd(), BizDate.valueOf("20150706"), "初回オーソリ完了日");
    }

    @Test
    @TestOrder(140)
    public void testExec_B11() {

        MosnaiCheckParam pMp = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo14);

        pMp.setDataSyoriControl(syoriCTL);
        pMp.setCreditCardInfoTblChkErrUmu(C_UmuKbn.NONE);

        authoriKakuninHantei.exec(pMp);
        //        exClassificationEquals(pMp.getDataSyoriControl().getAuthorisousinkhkbn(), C_KahiKbn.KA, "オーソリ送信可否区分");
        //        exClassificationEquals(pMp.getDataSyoriControl().getAuthorijkkbn(), C_AuthorijkKbn.IRAIMATI, "オーソリ状況区分");
        //        exDateEquals(pMp.getDataSyoriControl().getFstauthorikanryoymd(), BizDate.valueOf("20150708"), "初回オーソリ完了日");
    }
}
