package yuyu.common.direct.dscommon;

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
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.classification.C_DsKrPswdGnkTtStrkHnCdKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.direct.configuration.YuyuDirectConfig;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 現況通知用仮パスワード発行のメソッド {@link GenkyouTuutiKariPasswordHakkou#exec(String,BizDate} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class GenkyouTuutiKariPasswordHakkouTest_exec {

    @Inject
    private GenkyouTuutiKariPasswordHakkou genkyouTuutiKariPasswordHakkou;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_現況通知用仮パスワード発行";

    private final static String sheetName = "INデータ";

    private static HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

    @Before
    public void Before () {
        MockModuleBinder.bind(new AbstractModule() {
            @Override
            protected void configure() {
                bind(HozenKeiyakuIdouJyoutaiSyutoku.class).to(HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {

        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.caller = GenkyouTuutiKariPasswordHakkouTest_exec.class;
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.caller = null;
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {

            TestDataMaker testDataMaker = new TestDataMaker();
            testDataAndTblMap = testDataMaker.getInData(GenkyouTuutiKariPasswordHakkouTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        directDomManager.delete(directDomManager.getAllDsKokyakuKanri());
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        String syoNo = "11807000010";
        BizDate syoriYmd = BizDate.valueOf("20170712");
        GenkyouTuutiyouKariPasswordBean genkyouTuutiyouKariPasswordBean = genkyouTuutiKariPasswordHakkou.exec(syoNo,syoriYmd);
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getErrorkbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKanyuuUmu(), C_UmuKbn.NONE, "ＤＳ加入有無");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdGnkTtkahikbn(),
            C_KahiKbn.HUKA, "仮パスワード現況通知出力可否");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdGnkTtStrkHnCdKbn(),
            C_DsKrPswdGnkTtStrkHnCdKbn.DSMIKANYUU, "仮パスワード現況通知出力不能コード");
        exStringEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdYoken(), "", "仮パスワード与件");
        exDateEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdyuukouymd(),null, "仮パスワード有効年月日");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKaiykServiceTourokuUmu(), C_UmuKbn.NONE, "ＤＳ解約サービス登録有無");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        String syoNo = "11807000032";
        BizDate syoriYmd = BizDate.valueOf("20170712");
        GenkyouTuutiyouKariPasswordBean genkyouTuutiyouKariPasswordBean = genkyouTuutiKariPasswordHakkou.exec(syoNo,syoriYmd);
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getErrorkbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKanyuuUmu(), C_UmuKbn.NONE, "ＤＳ加入有無");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdGnkTtkahikbn(),
            C_KahiKbn.HUKA, "仮パスワード現況通知出力可否");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdGnkTtStrkHnCdKbn(),
            C_DsKrPswdGnkTtStrkHnCdKbn.DSMIKANYUU, "仮パスワード現況通知出力不能コード");
        exStringEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdYoken(), "", "仮パスワード与件");
        exDateEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdyuukouymd(),null, "仮パスワード有効年月日");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKaiykServiceTourokuUmu(), C_UmuKbn.NONE, "ＤＳ解約サービス登録有無");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        String syoNo = "11807000043";
        BizDate syoriYmd = BizDate.valueOf("20170712");
        GenkyouTuutiyouKariPasswordBean genkyouTuutiyouKariPasswordBean = genkyouTuutiKariPasswordHakkou.exec(syoNo,syoriYmd);
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getErrorkbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKanyuuUmu(), C_UmuKbn.NONE, "ＤＳ加入有無");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdGnkTtkahikbn(),
            C_KahiKbn.HUKA, "仮パスワード現況通知出力可否");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdGnkTtStrkHnCdKbn(),
            C_DsKrPswdGnkTtStrkHnCdKbn.DSMIKANYUU, "仮パスワード現況通知出力不能コード");
        exStringEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdYoken(), "", "仮パスワード与件");
        exDateEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdyuukouymd(),null, "仮パスワード有効年月日");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKaiykServiceTourokuUmu(), C_UmuKbn.NONE, "ＤＳ解約サービス登録有無");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        String syoNo = "11807000054";
        BizDate syoriYmd = BizDate.valueOf("20170712");
        GenkyouTuutiyouKariPasswordBean genkyouTuutiyouKariPasswordBean = genkyouTuutiKariPasswordHakkou.exec(syoNo,syoriYmd);
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getErrorkbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKanyuuUmu(), C_UmuKbn.NONE, "ＤＳ加入有無");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdGnkTtkahikbn(),
            C_KahiKbn.HUKA, "仮パスワード現況通知出力可否");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdGnkTtStrkHnCdKbn(),
            C_DsKrPswdGnkTtStrkHnCdKbn.DSMIKANYUU, "仮パスワード現況通知出力不能コード");
        exStringEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdYoken(), "", "仮パスワード与件");
        exDateEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdyuukouymd(),null, "仮パスワード有効年月日");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKaiykServiceTourokuUmu(), C_UmuKbn.NONE, "ＤＳ解約サービス登録有無");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        String syoNo = "11807000065";
        BizDate syoriYmd = BizDate.valueOf("20170712");
        GenkyouTuutiyouKariPasswordBean genkyouTuutiyouKariPasswordBean = genkyouTuutiKariPasswordHakkou.exec(syoNo,syoriYmd);
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getErrorkbn(), C_ErrorKbn.ERROR, "エラー区分");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKanyuuUmu(), null, "ＤＳ加入有無");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdGnkTtkahikbn(),
            C_KahiKbn.HUKA, "仮パスワード現況通知出力可否");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdGnkTtStrkHnCdKbn(),
            C_DsKrPswdGnkTtStrkHnCdKbn.BLNK, "仮パスワード現況通知出力不能コード");
        exStringEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdYoken(), "", "仮パスワード与件");
        exDateEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdyuukouymd(),null, "仮パスワード有効年月日");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKaiykServiceTourokuUmu(), null, "ＤＳ解約サービス登録有無");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        String syoNo = "11807000076";
        BizDate syoriYmd = BizDate.valueOf("20170712");
        GenkyouTuutiyouKariPasswordBean genkyouTuutiyouKariPasswordBean = genkyouTuutiKariPasswordHakkou.exec(syoNo,syoriYmd);
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getErrorkbn(), C_ErrorKbn.ERROR, "エラー区分");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKanyuuUmu(), null, "ＤＳ加入有無");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdGnkTtkahikbn(),
            C_KahiKbn.HUKA, "仮パスワード現況通知出力可否");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdGnkTtStrkHnCdKbn(),
            C_DsKrPswdGnkTtStrkHnCdKbn.BLNK, "仮パスワード現況通知出力不能コード");
        exStringEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdYoken(), "", "仮パスワード与件");
        exDateEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdyuukouymd(),null, "仮パスワード有効年月日");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKaiykServiceTourokuUmu(), null, "ＤＳ解約サービス登録有無");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        String syoNo = "11807000087";
        BizDate syoriYmd = BizDate.valueOf("20170712");
        GenkyouTuutiyouKariPasswordBean genkyouTuutiyouKariPasswordBean = genkyouTuutiKariPasswordHakkou.exec(syoNo,syoriYmd);
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getErrorkbn(), C_ErrorKbn.ERROR, "エラー区分");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKanyuuUmu(), null, "ＤＳ加入有無");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdGnkTtkahikbn(),
            C_KahiKbn.HUKA, "仮パスワード現況通知出力可否");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdGnkTtStrkHnCdKbn(),
            C_DsKrPswdGnkTtStrkHnCdKbn.BLNK, "仮パスワード現況通知出力不能コード");
        exStringEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdYoken(), "", "仮パスワード与件");
        exDateEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdyuukouymd(),null, "仮パスワード有効年月日");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKaiykServiceTourokuUmu(), null, "ＤＳ解約サービス登録有無");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        String syoNo = "11807000098";
        BizDate syoriYmd = BizDate.valueOf("20170712");
        GenkyouTuutiyouKariPasswordBean genkyouTuutiyouKariPasswordBean = genkyouTuutiKariPasswordHakkou.exec(syoNo,syoriYmd);
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getErrorkbn(), C_ErrorKbn.ERROR, "エラー区分");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKanyuuUmu(), null, "ＤＳ加入有無");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdGnkTtkahikbn(),
            C_KahiKbn.HUKA, "仮パスワード現況通知出力可否");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdGnkTtStrkHnCdKbn(),
            C_DsKrPswdGnkTtStrkHnCdKbn.BLNK, "仮パスワード現況通知出力不能コード");
        exStringEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdYoken(), "", "仮パスワード与件");
        exDateEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdyuukouymd(),null, "仮パスワード有効年月日");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKaiykServiceTourokuUmu(), null, "ＤＳ解約サービス登録有無");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        String syoNo = "11807000102";
        BizDate syoriYmd = BizDate.valueOf("20170712");
        GenkyouTuutiyouKariPasswordBean genkyouTuutiyouKariPasswordBean = genkyouTuutiKariPasswordHakkou.exec(syoNo,syoriYmd);
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getErrorkbn(), C_ErrorKbn.ERROR, "エラー区分");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKanyuuUmu(), null, "ＤＳ加入有無");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdGnkTtkahikbn(),
            C_KahiKbn.HUKA, "仮パスワード現況通知出力可否");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdGnkTtStrkHnCdKbn(),
            C_DsKrPswdGnkTtStrkHnCdKbn.BLNK, "仮パスワード現況通知出力不能コード");
        exStringEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdYoken(), "", "仮パスワード与件");
        exDateEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdyuukouymd(),null, "仮パスワード有効年月日");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKaiykServiceTourokuUmu(), null, "ＤＳ解約サービス登録有無");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        String syoNo = "11807000021";
        BizDate syoriYmd = BizDate.valueOf("20170712");
        GenkyouTuutiyouKariPasswordBean genkyouTuutiyouKariPasswordBean = genkyouTuutiKariPasswordHakkou.exec(syoNo,syoriYmd);
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getErrorkbn(), C_ErrorKbn.ERROR, "エラー区分");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKanyuuUmu(), null, "ＤＳ加入有無");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdGnkTtkahikbn(),
            C_KahiKbn.HUKA, "仮パスワード現況通知出力可否");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdGnkTtStrkHnCdKbn(),
            C_DsKrPswdGnkTtStrkHnCdKbn.BLNK, "仮パスワード現況通知出力不能コード");
        exStringEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdYoken(), "", "仮パスワード与件");
        exDateEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdyuukouymd(),null, "仮パスワード有効年月日");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKaiykServiceTourokuUmu(), null, "ＤＳ解約サービス登録有無");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        String syoNo = "11807000113";
        BizDate syoriYmd = BizDate.valueOf("20170712");
        GenkyouTuutiyouKariPasswordBean genkyouTuutiyouKariPasswordBean = genkyouTuutiKariPasswordHakkou.exec(syoNo,syoriYmd);
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getErrorkbn(), C_ErrorKbn.ERROR, "エラー区分");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKanyuuUmu(), null, "ＤＳ加入有無");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdGnkTtkahikbn(),
            C_KahiKbn.HUKA, "仮パスワード現況通知出力可否");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdGnkTtStrkHnCdKbn(),
            C_DsKrPswdGnkTtStrkHnCdKbn.BLNK, "仮パスワード現況通知出力不能コード");
        exStringEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdYoken(), "", "仮パスワード与件");
        exDateEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdyuukouymd(),null, "仮パスワード有効年月日");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKaiykServiceTourokuUmu(), null, "ＤＳ解約サービス登録有無");
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        MockObjectManager.initialize();
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN1;
        String syoNo = "11807000124";
        BizDate syoriYmd = BizDate.valueOf("20170712");
        GenkyouTuutiyouKariPasswordBean genkyouTuutiyouKariPasswordBean = genkyouTuutiKariPasswordHakkou.exec(syoNo,syoriYmd);
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getErrorkbn(), C_ErrorKbn.ERROR, "エラー区分");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKanyuuUmu(), null, "ＤＳ加入有無");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdGnkTtkahikbn(),
            C_KahiKbn.HUKA, "仮パスワード現況通知出力可否");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdGnkTtStrkHnCdKbn(),
            C_DsKrPswdGnkTtStrkHnCdKbn.BLNK, "仮パスワード現況通知出力不能コード");
        exStringEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdYoken(), "", "仮パスワード与件");
        exDateEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdyuukouymd(),null, "仮パスワード有効年月日");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKaiykServiceTourokuUmu(), C_UmuKbn.ARI, "ＤＳ解約サービス登録有無");
    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {

        MockObjectManager.initialize();
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN2;
        String syoNo = "11807000135";
        BizDate syoriYmd = BizDate.valueOf("20170712");
        GenkyouTuutiyouKariPasswordBean genkyouTuutiyouKariPasswordBean = genkyouTuutiKariPasswordHakkou.exec(syoNo,syoriYmd);
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getErrorkbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKanyuuUmu(), C_UmuKbn.ARI, "ＤＳ加入有無");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdGnkTtkahikbn(),
            C_KahiKbn.HUKA, "仮パスワード現況通知出力可否");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdGnkTtStrkHnCdKbn(),
            C_DsKrPswdGnkTtStrkHnCdKbn.IDOUSYORITYUU, "仮パスワード現況通知出力不能コード");
        exStringEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdYoken(), "", "仮パスワード与件");
        exDateEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdyuukouymd(),null, "仮パスワード有効年月日");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKaiykServiceTourokuUmu(), C_UmuKbn.ARI, "ＤＳ解約サービス登録有無");
    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {
        String syoNo = "11807000146";
        BizDate syoriYmd = BizDate.valueOf("20170712");
        GenkyouTuutiyouKariPasswordBean genkyouTuutiyouKariPasswordBean = genkyouTuutiKariPasswordHakkou.exec(syoNo,syoriYmd);
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getErrorkbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKanyuuUmu(), C_UmuKbn.NONE, "ＤＳ加入有無");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdGnkTtkahikbn(),
            C_KahiKbn.HUKA, "仮パスワード現況通知出力可否");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdGnkTtStrkHnCdKbn(),
            C_DsKrPswdGnkTtStrkHnCdKbn.DSKAIYAKU, "仮パスワード現況通知出力不能コード");
        exStringEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdYoken(), "", "仮パスワード与件");
        exDateEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdyuukouymd(),null, "仮パスワード有効年月日");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKaiykServiceTourokuUmu(), C_UmuKbn.NONE, "ＤＳ解約サービス登録有無");
    }

    @Test
    @TestOrder(150)
    public void testExec_A15() {

        MockObjectManager.initialize();
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;
        String syoNo = "11807000157";
        BizDate syoriYmd = BizDate.valueOf("20170712");
        GenkyouTuutiyouKariPasswordBean genkyouTuutiyouKariPasswordBean = genkyouTuutiKariPasswordHakkou.exec(syoNo,syoriYmd);
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getErrorkbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKanyuuUmu(), C_UmuKbn.ARI, "ＤＳ加入有無");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdGnkTtkahikbn(),
            C_KahiKbn.HUKA, "仮パスワード現況通知出力可否");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdGnkTtStrkHnCdKbn(),
            C_DsKrPswdGnkTtStrkHnCdKbn.HONPASSWORDTOUROKUZUMI, "仮パスワード現況通知出力不能コード");
        exStringEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdYoken(), "", "仮パスワード与件");
        exDateEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdyuukouymd(),null, "仮パスワード有効年月日");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKaiykServiceTourokuUmu(), C_UmuKbn.ARI, "ＤＳ解約サービス登録有無");
    }

    @Test
    @TestOrder(160)
    public void testExec_A16() {

        MockObjectManager.initialize();
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;
        String syoNo = "11807000168";
        BizDate syoriYmd = BizDate.valueOf("20170712");
        GenkyouTuutiyouKariPasswordBean genkyouTuutiyouKariPasswordBean = genkyouTuutiKariPasswordHakkou.exec(syoNo,syoriYmd);
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getErrorkbn(), C_ErrorKbn.ERROR, "エラー区分");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKanyuuUmu(), null, "ＤＳ加入有無");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdGnkTtkahikbn(),
            C_KahiKbn.HUKA, "仮パスワード現況通知出力可否");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdGnkTtStrkHnCdKbn(),
            C_DsKrPswdGnkTtStrkHnCdKbn.BLNK, "仮パスワード現況通知出力不能コード");
        exStringEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdYoken(), "", "仮パスワード与件");
        exDateEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdyuukouymd(),null, "仮パスワード有効年月日");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKaiykServiceTourokuUmu(), C_UmuKbn.ARI, "ＤＳ解約サービス登録有無");
    }

    @Test
    @TestOrder(170)
    public void testExec_A17() {

        MockObjectManager.initialize();
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;
        String syoNo = "11807000179";
        BizDate syoriYmd = BizDate.valueOf("20170712");
        GenkyouTuutiyouKariPasswordBean genkyouTuutiyouKariPasswordBean = genkyouTuutiKariPasswordHakkou.exec(syoNo,syoriYmd);
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getErrorkbn(), C_ErrorKbn.ERROR, "エラー区分");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKanyuuUmu(), null, "ＤＳ加入有無");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdGnkTtkahikbn(),
            C_KahiKbn.HUKA, "仮パスワード現況通知出力可否");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdGnkTtStrkHnCdKbn(),
            C_DsKrPswdGnkTtStrkHnCdKbn.BLNK, "仮パスワード現況通知出力不能コード");
        exStringEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdYoken(), "", "仮パスワード与件");
        exDateEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdyuukouymd(),null, "仮パスワード有効年月日");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKaiykServiceTourokuUmu(), C_UmuKbn.ARI, "ＤＳ解約サービス登録有無");
    }

    @Test
    @TestOrder(180)
    public void testExec_A18() {

        MockObjectManager.initialize();
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;
        String syoNo = "11807000180";
        BizDate syoriYmd = BizDate.valueOf("20170712");
        GenkyouTuutiyouKariPasswordBean genkyouTuutiyouKariPasswordBean = genkyouTuutiKariPasswordHakkou.exec(syoNo,syoriYmd);
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getErrorkbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKanyuuUmu(), C_UmuKbn.ARI, "ＤＳ加入有無");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdGnkTtkahikbn(),
            C_KahiKbn.HUKA, "仮パスワード現況通知出力可否");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdGnkTtStrkHnCdKbn(),
            C_DsKrPswdGnkTtStrkHnCdKbn.LOCKOUTTYUU, "仮パスワード現況通知出力不能コード");
        exStringEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdYoken(), "", "仮パスワード与件");
        exDateEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdyuukouymd(),null, "仮パスワード有効年月日");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKaiykServiceTourokuUmu(), C_UmuKbn.ARI, "ＤＳ解約サービス登録有無");
    }

    @Test
    @TestOrder(190)
    public void testExec_A19() {

        MockObjectManager.initialize();
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;
        String syoNo = "11807000191";
        BizDate syoriYmd = BizDate.valueOf("20170712");
        GenkyouTuutiyouKariPasswordBean genkyouTuutiyouKariPasswordBean = genkyouTuutiKariPasswordHakkou.exec(syoNo,syoriYmd);
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getErrorkbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKanyuuUmu(), C_UmuKbn.ARI, "ＤＳ加入有無");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdGnkTtkahikbn(),
            C_KahiKbn.HUKA, "仮パスワード現況通知出力可否");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdGnkTtStrkHnCdKbn(),
            C_DsKrPswdGnkTtStrkHnCdKbn.SERVICETEISITYUU, "仮パスワード現況通知出力不能コード");
        exStringEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdYoken(), "", "仮パスワード与件");
        exDateEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdyuukouymd(),null, "仮パスワード有効年月日");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKaiykServiceTourokuUmu(), C_UmuKbn.ARI, "ＤＳ解約サービス登録有無");
    }

    @Test
    @TestOrder(200)
    public void testExec_A20() {

        MockObjectManager.initialize();
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;
        String syoNo = "11807000205";
        BizDate syoriYmd = BizDate.valueOf("20170712");
        GenkyouTuutiyouKariPasswordBean genkyouTuutiyouKariPasswordBean = genkyouTuutiKariPasswordHakkou.exec(syoNo,syoriYmd);
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getErrorkbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKanyuuUmu(), C_UmuKbn.ARI, "ＤＳ加入有無");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdGnkTtkahikbn(),
            C_KahiKbn.HUKA, "仮パスワード現況通知出力可否");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdGnkTtStrkHnCdKbn(),
            C_DsKrPswdGnkTtStrkHnCdKbn.SERVICETEISITYUU, "仮パスワード現況通知出力不能コード");
        exStringEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdYoken(), "", "仮パスワード与件");
        exDateEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdyuukouymd(),null, "仮パスワード有効年月日");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKaiykServiceTourokuUmu(), C_UmuKbn.ARI, "ＤＳ解約サービス登録有無");
    }

    @Test
    @TestOrder(210)
    public void testExec_A21() {

        MockObjectManager.initialize();
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;
        String syoNo = "11807000216";
        BizDate syoriYmd = BizDate.valueOf("20170712");
        GenkyouTuutiyouKariPasswordBean genkyouTuutiyouKariPasswordBean = genkyouTuutiKariPasswordHakkou.exec(syoNo,syoriYmd);
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getErrorkbn(), C_ErrorKbn.ERROR, "エラー区分");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKanyuuUmu(), null, "ＤＳ加入有無");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdGnkTtkahikbn(),
            C_KahiKbn.HUKA, "仮パスワード現況通知出力可否");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdGnkTtStrkHnCdKbn(),
            C_DsKrPswdGnkTtStrkHnCdKbn.BLNK, "仮パスワード現況通知出力不能コード");
        exStringEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdYoken(), "", "仮パスワード与件");
        exDateEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdyuukouymd(),null, "仮パスワード有効年月日");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKaiykServiceTourokuUmu(), C_UmuKbn.ARI, "ＤＳ解約サービス登録有無");
    }

    @Test
    @TestOrder(220)
    public void testExec_A22() {

        MockObjectManager.initialize();
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;
        String syoNo = "11807000227";
        BizDate syoriYmd = BizDate.valueOf("20170712");
        GenkyouTuutiyouKariPasswordBean genkyouTuutiyouKariPasswordBean = genkyouTuutiKariPasswordHakkou.exec(syoNo,syoriYmd);
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getErrorkbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKanyuuUmu(), C_UmuKbn.ARI, "ＤＳ加入有無");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdGnkTtkahikbn(),
            C_KahiKbn.HUKA, "仮パスワード現況通知出力可否");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdGnkTtStrkHnCdKbn(),
            C_DsKrPswdGnkTtStrkHnCdKbn.SAIHAKKOUSEIKYUUZUMI, "仮パスワード現況通知出力不能コード");
        exStringEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdYoken(), "", "仮パスワード与件");
        exDateEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdyuukouymd(),null, "仮パスワード有効年月日");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKaiykServiceTourokuUmu(), C_UmuKbn.ARI, "ＤＳ解約サービス登録有無");
    }

    @Test
    @TestOrder(230)
    public void testExec_A23() {

        MockObjectManager.initialize();
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;
        String syoNo = "11807000238";
        BizDate syoriYmd = BizDate.valueOf("20170712");
        GenkyouTuutiyouKariPasswordBean genkyouTuutiyouKariPasswordBean = genkyouTuutiKariPasswordHakkou.exec(syoNo,syoriYmd);
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getErrorkbn(), C_ErrorKbn.ERROR, "エラー区分");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKanyuuUmu(), null, "ＤＳ加入有無");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdGnkTtkahikbn(),
            C_KahiKbn.HUKA, "仮パスワード現況通知出力可否");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdGnkTtStrkHnCdKbn(),
            C_DsKrPswdGnkTtStrkHnCdKbn.BLNK, "仮パスワード現況通知出力不能コード");
        exStringEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdYoken(), "", "仮パスワード与件");
        exDateEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdyuukouymd(),null, "仮パスワード有効年月日");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKaiykServiceTourokuUmu(), C_UmuKbn.ARI, "ＤＳ解約サービス登録有無");
    }

    @Test
    @TestOrder(240)
    public void testExec_A24() {

        MockObjectManager.initialize();
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;
        String syoNo = "11807000249";
        BizDate syoriYmd = BizDate.valueOf("20170712");
        YuyuDirectConfig config = YuyuDirectConfig.getInstance();
        config.setGenkyoutuutiKrpasswordtuutiKanouYuukouKikan(Integer.valueOf(1));
        GenkyouTuutiyouKariPasswordBean genkyouTuutiyouKariPasswordBean = genkyouTuutiKariPasswordHakkou.exec(syoNo,syoriYmd);
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getErrorkbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKanyuuUmu(), C_UmuKbn.ARI, "ＤＳ加入有無");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdGnkTtkahikbn(),
            C_KahiKbn.HUKA, "仮パスワード現況通知出力可否");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdGnkTtStrkHnCdKbn(),
            C_DsKrPswdGnkTtStrkHnCdKbn.KRPASSWORDMIHAKKOU, "仮パスワード現況通知出力不能コード");
        exStringEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdYoken(), "", "仮パスワード与件");
        exDateEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdyuukouymd(),null, "仮パスワード有効年月日");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKaiykServiceTourokuUmu(), C_UmuKbn.ARI, "ＤＳ解約サービス登録有無");
    }

    @Test
    @TestOrder(250)
    public void testExec_A25() {
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;
        String syoNo = "11807000250";
        BizDate syoriYmd = BizDate.valueOf("20180130");
        YuyuDirectConfig config = YuyuDirectConfig.getInstance();
        config.setGenkyoutuutiKrpasswordtuutiKanouYuukouKikan(Integer.valueOf(1));
        GenkyouTuutiyouKariPasswordBean genkyouTuutiyouKariPasswordBean = genkyouTuutiKariPasswordHakkou.exec(syoNo,syoriYmd);
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getErrorkbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKanyuuUmu(), C_UmuKbn.ARI, "ＤＳ加入有無");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdGnkTtkahikbn(),
            C_KahiKbn.HUKA, "仮パスワード現況通知出力可否");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdGnkTtStrkHnCdKbn(),
            C_DsKrPswdGnkTtStrkHnCdKbn.ZANZONKIKANSUKUNAI, "仮パスワード現況通知出力不能コード");
        exStringEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdYoken(), "", "仮パスワード与件");
        exDateEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdyuukouymd(),null, "仮パスワード有効年月日");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKaiykServiceTourokuUmu(), C_UmuKbn.ARI, "ＤＳ解約サービス登録有無");
    }

    @Test
    @TestOrder(260)
    public void testExec_A26() {

        MockObjectManager.initialize();
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;
        String syoNo = "11807000261";
        BizDate syoriYmd = BizDate.valueOf("20171201");
        YuyuDirectConfig config = YuyuDirectConfig.getInstance();
        config.setGenkyoutuutiKrpasswordtuutiKanouYuukouKikan(Integer.valueOf(1));
        GenkyouTuutiyouKariPasswordBean genkyouTuutiyouKariPasswordBean = genkyouTuutiKariPasswordHakkou.exec(syoNo,syoriYmd);
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getErrorkbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKanyuuUmu(), C_UmuKbn.ARI, "ＤＳ加入有無");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdGnkTtkahikbn(),
            C_KahiKbn.HUKA, "仮パスワード現況通知出力可否");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdGnkTtStrkHnCdKbn(),
            C_DsKrPswdGnkTtStrkHnCdKbn.ZANZONKIKANSUKUNAI, "仮パスワード現況通知出力不能コード");
        exStringEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdYoken(), "", "仮パスワード与件");
        exDateEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdyuukouymd(),null, "仮パスワード有効年月日");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKaiykServiceTourokuUmu(), C_UmuKbn.ARI, "ＤＳ解約サービス登録有無");
    }

    @Test
    @TestOrder(270)
    public void testExec_A27() {

        MockObjectManager.initialize();
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;
        String syoNo = "11807000272";
        BizDate syoriYmd = BizDate.valueOf("20171201");
        YuyuDirectConfig config = YuyuDirectConfig.getInstance();
        config.setGenkyoutuutiKrpasswordtuutiKanouYuukouKikan(Integer.valueOf(1));
        GenkyouTuutiyouKariPasswordBean genkyouTuutiyouKariPasswordBean = genkyouTuutiKariPasswordHakkou.exec(syoNo,syoriYmd);
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getErrorkbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKanyuuUmu(), C_UmuKbn.ARI, "ＤＳ加入有無");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdGnkTtkahikbn(),
            C_KahiKbn.HUKA, "仮パスワード現況通知出力可否");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdGnkTtStrkHnCdKbn(),
            C_DsKrPswdGnkTtStrkHnCdKbn.BLNK, "仮パスワード現況通知出力不能コード");
        exStringEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdYoken(), "", "仮パスワード与件");
        exDateEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdyuukouymd(),null, "仮パスワード有効年月日");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKaiykServiceTourokuUmu(), C_UmuKbn.ARI, "ＤＳ解約サービス登録有無");
    }

    @Test
    @TestOrder(280)
    public void testExec_A28() {

        MockObjectManager.initialize();
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;
        String syoNo = "11807000283";
        BizDate syoriYmd = BizDate.valueOf("20170712");
        GenkyouTuutiyouKariPasswordBean genkyouTuutiyouKariPasswordBean = genkyouTuutiKariPasswordHakkou.exec(syoNo,syoriYmd);
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getErrorkbn(), C_ErrorKbn.ERROR, "エラー区分");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKanyuuUmu(), null, "ＤＳ加入有無");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdGnkTtkahikbn(),
            C_KahiKbn.HUKA, "仮パスワード現況通知出力可否");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdGnkTtStrkHnCdKbn(),
            C_DsKrPswdGnkTtStrkHnCdKbn.BLNK, "仮パスワード現況通知出力不能コード");
        exStringEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdYoken(), "", "仮パスワード与件");
        exDateEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdyuukouymd(),null, "仮パスワード有効年月日");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKaiykServiceTourokuUmu(), C_UmuKbn.ARI, "ＤＳ解約サービス登録有無");
    }

    @Test
    @TestOrder(290)
    public void testExec_A29() {

        MockObjectManager.initialize();
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;
        String syoNo = "11807000294";
        BizDate syoriYmd = BizDate.valueOf("20171201");
        YuyuDirectConfig config = YuyuDirectConfig.getInstance();
        config.setGenkyoutuutiKrpasswordtuutiKanouYuukouKikan(Integer.valueOf(1));
        GenkyouTuutiyouKariPasswordBean genkyouTuutiyouKariPasswordBean = genkyouTuutiKariPasswordHakkou.exec(syoNo,syoriYmd);
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getErrorkbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKanyuuUmu(), C_UmuKbn.ARI, "ＤＳ加入有無");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdGnkTtkahikbn(),
            C_KahiKbn.HUKA, "仮パスワード現況通知出力可否");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdGnkTtStrkHnCdKbn(),
            C_DsKrPswdGnkTtStrkHnCdKbn.BLNK, "仮パスワード現況通知出力不能コード");
        exStringEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdYoken(), "", "仮パスワード与件");
        exDateEquals(genkyouTuutiyouKariPasswordBean.getDsKrPswdyuukouymd(),null, "仮パスワード有効年月日");
        exClassificationEquals(genkyouTuutiyouKariPasswordBean.getDsKaiykServiceTourokuUmu(), C_UmuKbn.NONE, "ＤＳ解約サービス登録有無");
    }
}