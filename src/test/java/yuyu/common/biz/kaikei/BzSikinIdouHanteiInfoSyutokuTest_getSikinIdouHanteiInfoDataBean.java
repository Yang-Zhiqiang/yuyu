package yuyu.common.biz.kaikei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_GkhnkzidourtKbn;
import yuyu.def.classification.C_HijynnykzndkkouzaKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_UmuKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 資金移動判定情報取得クラスのメソッド {@link BzSikinIdouHanteiInfoSyutoku#getSikinIdouHanteiInfoDataBean(C_Segcd)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class BzSikinIdouHanteiInfoSyutokuTest_getSikinIdouHanteiInfoDataBean {

    @Inject
    private BzSikinIdouHanteiInfoSyutoku bzSikinIdouHanteiInfoSyutoku;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_資金移動判定情報取得";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BzSikinIdouHanteiInfoSyutokuTest_getSikinIdouHanteiInfoDataBean.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSegmentSikinidou());
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
    }

    @Test
    @TestOrder(10)
    public void testGetSikinIdouHanteiInfoDataBean_A1() {

        C_Segcd segcd = C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI;

        SikinIdouHanteiInfoDataBean sikinIdouHanteiInfoDataBean = bzSikinIdouHanteiInfoSyutoku.getSikinIdouHanteiInfoDataBean(segcd);

        exClassificationEquals(sikinIdouHanteiInfoDataBean.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
        exClassificationEquals(sikinIdouHanteiInfoDataBean.getSegCd(), null, "セグメントコード");
        exClassificationEquals(sikinIdouHanteiInfoDataBean.getHijynnykZndkkouzaKbn(), null, "平準払入金額残高口座区分");
        exClassificationEquals(sikinIdouHanteiInfoDataBean.getFstpGkhnkzidouRt(), null, "初回Ｐ外貨本口座移動ルート");
        exClassificationEquals(sikinIdouHanteiInfoDataBean.getZenkiZennouGkhnkzidouRt(), null, "全期前納外貨本口座移動ルート");
        exClassificationEquals(sikinIdouHanteiInfoDataBean.getKeizokupGkhnkzidouRt(), null, "継続Ｐ外貨本口座移動ルート");
        exClassificationEquals(sikinIdouHanteiInfoDataBean.getSeiymdSeitstuityouhnknUmu(), null, "生年月日性訂正追徴返還有無");
        exClassificationEquals(sikinIdouHanteiInfoDataBean.getZeiseiTekikakuUmu(), null, "税制適格有無");
        exClassificationEquals(sikinIdouHanteiInfoDataBean.getItijibrUmu(), null, "一時払有無");
        exClassificationEquals(sikinIdouHanteiInfoDataBean.getSbHkuktUmu(), null, "死亡保険金受取有無");
        exClassificationEquals(sikinIdouHanteiInfoDataBean.getSbKyuuhukinuktUmu(), null, "死亡給付金受取有無");
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void insertTestData1() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BzSikinIdouHanteiInfoSyutokuTest_getMultipleSikinIdouHanteiInfoBean.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(30)
    public void testGetSikinIdouHanteiInfoDataBean_A2() {

        C_Segcd segcd = C_Segcd.USDSISUURENDOUNENKINITIJIJYUNYUU;

        SikinIdouHanteiInfoDataBean sikinIdouHanteiInfoDataBean = bzSikinIdouHanteiInfoSyutoku.getSikinIdouHanteiInfoDataBean(segcd);

        exClassificationEquals(sikinIdouHanteiInfoDataBean.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(sikinIdouHanteiInfoDataBean.getSegCd(), C_Segcd.USDSISUURENDOUNENKINITIJIJYUNYUU, "セグメントコード");
        exClassificationEquals(sikinIdouHanteiInfoDataBean.getHijynnykZndkkouzaKbn(), C_HijynnykzndkkouzaKbn.YENHONKZ, "平準払入金額残高口座区分");
        exClassificationEquals(sikinIdouHanteiInfoDataBean.getFstpGkhnkzidouRt(), C_GkhnkzidourtKbn.GKKZDIRECT, "初回Ｐ外貨本口座移動ルート");
        exClassificationEquals(sikinIdouHanteiInfoDataBean.getZenkiZennouGkhnkzidouRt(), C_GkhnkzidourtKbn.YENKZKEIYUGKKZ, "全期前納外貨本口座移動ルート");
        exClassificationEquals(sikinIdouHanteiInfoDataBean.getKeizokupGkhnkzidouRt(), C_GkhnkzidourtKbn.NONE, "継続Ｐ外貨本口座移動ルート");
        exClassificationEquals(sikinIdouHanteiInfoDataBean.getSeiymdSeitstuityouhnknUmu(), C_UmuKbn.ARI, "生年月日性訂正追徴返還有無");
        exClassificationEquals(sikinIdouHanteiInfoDataBean.getZeiseiTekikakuUmu(), C_UmuKbn.NONE, "税制適格有無");
        exClassificationEquals(sikinIdouHanteiInfoDataBean.getItijibrUmu(), C_UmuKbn.ARI, "一時払有無");
        exClassificationEquals(sikinIdouHanteiInfoDataBean.getSbHkuktUmu(), C_UmuKbn.ARI, "死亡保険金受取有無");
        exClassificationEquals(sikinIdouHanteiInfoDataBean.getSbKyuuhukinuktUmu(), C_UmuKbn.NONE, "死亡給付金受取有無");
    }

    @Test
    @TestOrder(40)
    public void testGetSikinIdouHanteiInfoDataBean_A3() {

        C_Segcd segcd = C_Segcd.USDSYUUSINITIJIBARAI19JYUNYUUHAI;

        SikinIdouHanteiInfoDataBean sikinIdouHanteiInfoDataBean = bzSikinIdouHanteiInfoSyutoku.getSikinIdouHanteiInfoDataBean(segcd);

        exClassificationEquals(sikinIdouHanteiInfoDataBean.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
        exClassificationEquals(sikinIdouHanteiInfoDataBean.getSegCd(), null, "セグメントコード");
        exClassificationEquals(sikinIdouHanteiInfoDataBean.getHijynnykZndkkouzaKbn(), null, "平準払入金額残高口座区分");
        exClassificationEquals(sikinIdouHanteiInfoDataBean.getFstpGkhnkzidouRt(), null, "初回Ｐ外貨本口座移動ルート");
        exClassificationEquals(sikinIdouHanteiInfoDataBean.getZenkiZennouGkhnkzidouRt(), null, "全期前納外貨本口座移動ルート");
        exClassificationEquals(sikinIdouHanteiInfoDataBean.getKeizokupGkhnkzidouRt(), null, "継続Ｐ外貨本口座移動ルート");
        exClassificationEquals(sikinIdouHanteiInfoDataBean.getSeiymdSeitstuityouhnknUmu(), null, "生年月日性訂正追徴返還有無");
        exClassificationEquals(sikinIdouHanteiInfoDataBean.getZeiseiTekikakuUmu(), null, "税制適格有無");
        exClassificationEquals(sikinIdouHanteiInfoDataBean.getItijibrUmu(), null, "一時払有無");
        exClassificationEquals(sikinIdouHanteiInfoDataBean.getSbHkuktUmu(), null, "死亡保険金受取有無");
        exClassificationEquals(sikinIdouHanteiInfoDataBean.getSbKyuuhukinuktUmu(), null, "死亡給付金受取有無");
    }
}
