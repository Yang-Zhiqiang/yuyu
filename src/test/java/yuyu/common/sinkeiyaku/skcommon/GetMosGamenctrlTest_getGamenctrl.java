package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.web.ui.LabelValuePair;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_HaitouKbn;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_Nstkumu;
import yuyu.def.classification.C_PtratkituukasiteiKbn;
import yuyu.def.classification.C_TargetTkHukaKanouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 申込書入力画面制御リスト取得クラスのメソッド {@link GetMosGamenctrl#getGamenctrl(java.util.List)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class GetMosGamenctrlTest_getGamenctrl {

    @Inject
    private GetMosGamenctrl getMosGamenctrl;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_申込書入力画面制御リスト取得";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(GetMosGamenctrlTest_getGamenctrl.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());

        MockObjectManager.initialize();
    }

    @Test
    @Transactional
    @TestOrder(10)
    public void testGetGamenctrl_A1() {

        List<GetSyouhnZokuseiCtrlInBean> getSyouhnZokuseiCtrlInBeanLst = new ArrayList<>();

        List<GetSyouhnZokuseiCtrlOutBean> getSyouhnZokuseiCtrlOutBeanLst = getMosGamenctrl.getGamenctrl(getSyouhnZokuseiCtrlInBeanLst);

        exNumericEquals(getSyouhnZokuseiCtrlOutBeanLst.size(), 0, "制御用商品属性取得出力Beanリスト．サイズ");
    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testGetGamenctrl_A2() {
        List<GetSyouhnZokuseiCtrlInBean> getSyouhnZokuseiCtrlInBeanLst = new ArrayList<>();

        GetSyouhnZokuseiCtrlInBean getSyouhnZokuseiCtrlInBean = new GetSyouhnZokuseiCtrlInBean();
        getSyouhnZokuseiCtrlInBean.setHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_YOKUSEI);
        getSyouhnZokuseiCtrlInBean.setHknsyuruinosd(100);
        getSyouhnZokuseiCtrlInBean.setInputctrlSyouhnCd("0001");
        getSyouhnZokuseiCtrlInBean.setInputctrlSyouhnSdNo(10);
        getSyouhnZokuseiCtrlInBeanLst.add(getSyouhnZokuseiCtrlInBean);

        List<GetSyouhnZokuseiCtrlOutBean> getSyouhnZokuseiCtrlOutBeanLst = getMosGamenctrl.getGamenctrl(getSyouhnZokuseiCtrlInBeanLst);

        exNumericEquals(getSyouhnZokuseiCtrlOutBeanLst.size(), 1, "制御用商品属性取得出力Beanリスト．サイズ");

        GetSyouhnZokuseiCtrlOutBean getSyouhnZokuseiCtrlOutBean = getSyouhnZokuseiCtrlOutBeanLst.get(0);

        exClassificationEquals(getSyouhnZokuseiCtrlOutBean.getHknsyuruino(),C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_YOKUSEI, "保険種類番号");
        exNumericEquals(getSyouhnZokuseiCtrlOutBean.getHknsyuruinosd(), 100, "保険種類番号世代");
        exStringEquals(getSyouhnZokuseiCtrlOutBean.getInputctrlsyouhncd(), "0001", "入力制御用商品コード");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean.getSbuktumu(), C_UmuKbn.NONE, "死亡受取有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean.getKktumu(), C_UmuKbn.NONE, "告知有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean.getMusenumu(), C_UmuKbn.NONE, " 無選択有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean.getSyokugyoukktumu(), C_UmuKbn.NONE, "職業告知有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean.getHaitoukbn(), C_HaitouKbn.YUUHAI, "配当区分");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean.getTeikisiharaikinumu(), C_UmuKbn.NONE, "定期支払金有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean.getItijibrumu(), C_UmuKbn.NONE, "一時払有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean.getGaikatatkiumu(), C_UmuKbn.NONE, "外貨取扱有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean.getHengakuumu(), C_UmuKbn.NONE, "変額保険有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean.getNstkumu(), C_Nstkumu.BLNK, "年金支払特約有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean.getKykdrtentuusanumu(), C_UmuKbn.NONE, "契約者同一代理店通算有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean.getPyennykntktekiumu(), C_UmuKbn.NONE, "保険料円入金特約適用有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean.getGaikanyuukintktekiumu(), C_UmuKbn.NONE, "外貨入金特約適用有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean.getSyuusinhknumu(), C_UmuKbn.NONE, "終身保険有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean.getNkhknumu(), C_UmuKbn.NONE, "年金保険有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean.getSyksbyensitihsyutktekiumu(), C_UmuKbn.NONE,"初期死亡時円換算最低保証特約適用有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean.getJyudkaigomehrtktekiumu(), C_UmuKbn.NONE, "重度介護前払特約適用有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean.getStdrsktkumu(), C_UmuKbn.NONE, "被保険者代理特約有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean.getAeoitaisyouumu(), C_UmuKbn.NONE, "ＡＥＯＩ対象有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean.getHokenkngkyakujyouumu(), C_UmuKbn.NONE, "保険金額約定有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean.getTargettkhukakanoukbn(), C_TargetTkHukaKanouKbn.NONE,"ターゲット特約付加可能区分");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean.getTmttknhaibunwarisiteiumu(), C_UmuKbn.NONE, "積立金配分割合指定有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean.getNkuktumu(), C_UmuKbn.NONE, "年金受取有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean.getHeijyunbaraiumu(), C_UmuKbn.NONE, "平準払有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean.getZennouumu(), C_UmuKbn.NONE, "前納有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean.getItibuzennoutekiumu(), C_UmuKbn.NONE, "一部前納適用有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean.getKouzahurikaebaraitekiumu(), C_UmuKbn.NONE, "口座振替払適用有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean.getZeiseitekikakuumu(), C_UmuKbn.NONE, "税制適格有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean.getKzktourokuserviceumu(), C_UmuKbn.NONE, "家族登録サービス有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean.getKykdrtkykumu(), C_UmuKbn.NONE, "契約者代理特約有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean.getPtratkituukasiteikbn(),C_PtratkituukasiteiKbn.BLNK , "保険料取扱通貨指定区分");
        exNumericEquals(getSyouhnZokuseiCtrlOutBean.getDai1HknkknSelect().size(), 3, "第１保険期間選択肢の件数");
        LabelValuePair outPair = getSyouhnZokuseiCtrlOutBean.getDai1HknkknSelect().get(0);
        exStringEquals(outPair.getLabel(), "", "第１保険期間選択肢．ラベル");
        exStringEquals(outPair.getValue(), "0", "第１保険期間選択肢．バリュー");
        LabelValuePair outPair2 = getSyouhnZokuseiCtrlOutBean.getDai1HknkknSelect().get(1);
        exStringEquals(outPair2.getLabel(), "5", "第１保険期間選択肢．ラベル");
        exStringEquals(outPair2.getValue(), "5", "第１保険期間選択肢．バリュー");
        LabelValuePair outPair3 = getSyouhnZokuseiCtrlOutBean.getDai1HknkknSelect().get(2);
        exStringEquals(outPair3.getLabel(), "10", "第１保険期間選択肢．ラベル");
        exStringEquals(outPair3.getValue(), "10", "第１保険期間選択肢．バリュー");

        exNumericEquals(getSyouhnZokuseiCtrlOutBean.getTargettkmkhtSelect().size(), 12, "ターゲット特約目標値選択肢mapの件数");
        LabelValuePair targettkmkhtSelectoutPair = getSyouhnZokuseiCtrlOutBean.getTargettkmkhtSelect().get(0);
        exStringEquals(targettkmkhtSelectoutPair.getValue(), "0", "ターゲット特約目標値選択肢map．バリュー");
        exStringEquals(targettkmkhtSelectoutPair.getLabel(), "", "ターゲット特約目標値選択肢map．ラベル");
        LabelValuePair targettkmkhtSelectoutPair2 = getSyouhnZokuseiCtrlOutBean.getTargettkmkhtSelect().get(1);
        exStringEquals(targettkmkhtSelectoutPair2.getValue(), "110", "ターゲット特約目標値選択肢map．バリュー");
        exStringEquals(targettkmkhtSelectoutPair2.getLabel(), "１１０％", "ターゲット特約目標値選択肢map．ラベル");
        LabelValuePair targettkmkhtSelectoutPair3 = getSyouhnZokuseiCtrlOutBean.getTargettkmkhtSelect().get(2);
        exStringEquals(targettkmkhtSelectoutPair3.getValue(), "120", "ターゲット特約目標値選択肢map．バリュー");
        exStringEquals(targettkmkhtSelectoutPair3.getLabel(), "１２０％", "ターゲット特約目標値選択肢map．ラベル");
        LabelValuePair targettkmkhtSelectoutPair4 = getSyouhnZokuseiCtrlOutBean.getTargettkmkhtSelect().get(3);
        exStringEquals(targettkmkhtSelectoutPair4.getValue(), "130", "ターゲット特約目標値選択肢map．バリュー");
        exStringEquals(targettkmkhtSelectoutPair4.getLabel(), "１３０％", "ターゲット特約目標値選択肢map．ラベル");
        LabelValuePair targettkmkhtSelectoutPair5 = getSyouhnZokuseiCtrlOutBean.getTargettkmkhtSelect().get(4);
        exStringEquals(targettkmkhtSelectoutPair5.getValue(), "140", "ターゲット特約目標値選択肢map．バリュー");
        exStringEquals(targettkmkhtSelectoutPair5.getLabel(), "１４０％", "ターゲット特約目標値選択肢map．ラベル");
        LabelValuePair targettkmkhtSelectoutPair6 = getSyouhnZokuseiCtrlOutBean.getTargettkmkhtSelect().get(5);
        exStringEquals(targettkmkhtSelectoutPair6.getValue(), "150", "ターゲット特約目標値選択肢map．バリュー");
        exStringEquals(targettkmkhtSelectoutPair6.getLabel(), "１５０％", "ターゲット特約目標値選択肢map．ラベル");
        LabelValuePair targettkmkhtSelectoutPair7 = getSyouhnZokuseiCtrlOutBean.getTargettkmkhtSelect().get(6);
        exStringEquals(targettkmkhtSelectoutPair7.getValue(), "160", "ターゲット特約目標値選択肢map．バリュー");
        exStringEquals(targettkmkhtSelectoutPair7.getLabel(), "１６０％", "ターゲット特約目標値選択肢map．ラベル");
        LabelValuePair targettkmkhtSelectoutPair8 = getSyouhnZokuseiCtrlOutBean.getTargettkmkhtSelect().get(7);
        exStringEquals(targettkmkhtSelectoutPair8.getValue(), "170", "ターゲット特約目標値選択肢map．バリュー");
        exStringEquals(targettkmkhtSelectoutPair8.getLabel(), "１７０％", "ターゲット特約目標値選択肢map．ラベル");
        LabelValuePair targettkmkhtSelectoutPair9 = getSyouhnZokuseiCtrlOutBean.getTargettkmkhtSelect().get(8);
        exStringEquals(targettkmkhtSelectoutPair9.getValue(), "180", "ターゲット特約目標値選択肢map．バリュー");
        exStringEquals(targettkmkhtSelectoutPair9.getLabel(), "１８０％", "ターゲット特約目標値選択肢map．ラベル");
        LabelValuePair targettkmkhtSelectoutPair10 = getSyouhnZokuseiCtrlOutBean.getTargettkmkhtSelect().get(9);
        exStringEquals(targettkmkhtSelectoutPair10.getValue(), "190", "ターゲット特約目標値選択肢map．バリュー");
        exStringEquals(targettkmkhtSelectoutPair10.getLabel(), "１９０％", "ターゲット特約目標値選択肢map．ラベル");
        LabelValuePair targettkmkhtSelectoutPair11 = getSyouhnZokuseiCtrlOutBean.getTargettkmkhtSelect().get(10);
        exStringEquals(targettkmkhtSelectoutPair11.getValue(), "200", "ターゲット特約目標値選択肢map．バリュー");
        exStringEquals(targettkmkhtSelectoutPair11.getLabel(), "２００％", "ターゲット特約目標値選択肢map．ラベル");
        LabelValuePair targettkmkhtSelectoutPair12 = getSyouhnZokuseiCtrlOutBean.getTargettkmkhtSelect().get(11);
        exStringEquals(targettkmkhtSelectoutPair12.getValue(), "999", "ターゲット特約目標値選択肢map．バリュー");
        exStringEquals(targettkmkhtSelectoutPair12.getLabel(), "設定しない", "ターゲット特約目標値選択肢map．ラベル");

        exNumericEquals(getSyouhnZokuseiCtrlOutBean.getNenkinsyuSelect().size(), 0, "年金種類選択肢の件数");
        exNumericEquals(getSyouhnZokuseiCtrlOutBean.getSueokikknSelect().size(), 0, "据置期間選択肢の件数");

        exNumericEquals(getSyouhnZokuseiCtrlOutBean.getHrktuukaSelect().size(),4, "払込通貨選択肢の件数");
        LabelValuePair hrktuukaSelecttoutPair = getSyouhnZokuseiCtrlOutBean.getHrktuukaSelect().get(0);
        exStringEquals(hrktuukaSelecttoutPair.getValue(), "0", "払込通貨選択肢map．バリュー");
        exStringEquals(hrktuukaSelecttoutPair.getLabel(), "", "払込通貨選択肢map．ラベル");
        LabelValuePair hrktuukaSelecttoutPair1 = getSyouhnZokuseiCtrlOutBean.getHrktuukaSelect().get(1);
        exStringEquals(hrktuukaSelecttoutPair1.getValue(), "JPY", "払込通貨選択肢map．バリュー");
        exStringEquals(hrktuukaSelecttoutPair1.getLabel(), "円", "払込通貨選択肢map．ラベル");
        LabelValuePair hrktuukaSelecttoutPair2 = getSyouhnZokuseiCtrlOutBean.getHrktuukaSelect().get(2);
        exStringEquals(hrktuukaSelecttoutPair2.getValue(), "USD", "払込通貨選択肢map．バリュー");
        exStringEquals(hrktuukaSelecttoutPair2.getLabel(), "米ドル", "払込通貨選択肢map．ラベル");
        LabelValuePair hrktuukaSelecttoutPair3 = getSyouhnZokuseiCtrlOutBean.getHrktuukaSelect().get(3);
        exStringEquals(hrktuukaSelecttoutPair3.getValue(), "AUD", "払込通貨選択肢map．バリュー");
        exStringEquals(hrktuukaSelecttoutPair3.getLabel(), "豪ドル", "払込通貨選択肢map．ラベル");

        exNumericEquals(getSyouhnZokuseiCtrlOutBean.getHrkkeiroSelect().size(), 0, "払込経路選択肢の件数");

        exClassificationEquals(getSyouhnZokuseiCtrlOutBean.getHknkknsmnKbn(), C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean.getHrkkknsmnkbn(), C_HrkkknsmnKbn.BLNK, "払込期間歳満期区分");

    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testGetGamenctrl_A3() {

        List<GetSyouhnZokuseiCtrlInBean> getSyouhnZokuseiCtrlInBeanLst = new ArrayList<>();

        GetSyouhnZokuseiCtrlInBean getSyouhnZokuseiCtrlInBean1 = new GetSyouhnZokuseiCtrlInBean();
        getSyouhnZokuseiCtrlInBean1.setHknsyuruino(C_HknsyuruiNo.GAIKAINDEXNK_SISUU);
        getSyouhnZokuseiCtrlInBean1.setHknsyuruinosd(100);
        getSyouhnZokuseiCtrlInBean1.setInputctrlSyouhnCd("0002");
        getSyouhnZokuseiCtrlInBean1.setInputctrlSyouhnSdNo(10);
        getSyouhnZokuseiCtrlInBeanLst.add(getSyouhnZokuseiCtrlInBean1);

        GetSyouhnZokuseiCtrlInBean getSyouhnZokuseiCtrlInBean2 = new GetSyouhnZokuseiCtrlInBean();
        getSyouhnZokuseiCtrlInBean2.setHknsyuruino(C_HknsyuruiNo.GAIKAINDEXNK);
        getSyouhnZokuseiCtrlInBean2.setHknsyuruinosd(200);
        getSyouhnZokuseiCtrlInBean2.setInputctrlSyouhnCd("0003");
        getSyouhnZokuseiCtrlInBean2.setInputctrlSyouhnSdNo(20);
        getSyouhnZokuseiCtrlInBeanLst.add(getSyouhnZokuseiCtrlInBean2);

        GetSyouhnZokuseiCtrlInBean getSyouhnZokuseiCtrlInBean3 = new GetSyouhnZokuseiCtrlInBean();
        getSyouhnZokuseiCtrlInBean3.setHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        getSyouhnZokuseiCtrlInBean3.setHknsyuruinosd(300);
        getSyouhnZokuseiCtrlInBean3.setInputctrlSyouhnCd("0004");
        getSyouhnZokuseiCtrlInBean3.setInputctrlSyouhnSdNo(30);
        getSyouhnZokuseiCtrlInBeanLst.add(getSyouhnZokuseiCtrlInBean3);

        List<GetSyouhnZokuseiCtrlOutBean> getSyouhnZokuseiCtrlOutBeanLst = getMosGamenctrl.getGamenctrl(getSyouhnZokuseiCtrlInBeanLst);

        exNumericEquals(getSyouhnZokuseiCtrlOutBeanLst.size(), 2, "制御用商品属性取得出力Beanリスト．サイズ");

        GetSyouhnZokuseiCtrlOutBean getSyouhnZokuseiCtrlOutBean1 = getSyouhnZokuseiCtrlOutBeanLst.get(0);
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean1.getHknsyuruino(), C_HknsyuruiNo.GAIKAINDEXNK, "保険種類番号");
        exNumericEquals(getSyouhnZokuseiCtrlOutBean1.getHknsyuruinosd(), 200, "保険種類番号世代");
        exStringEquals(getSyouhnZokuseiCtrlOutBean1.getInputctrlsyouhncd(), "0003", "入力制御用商品コード");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean1.getSbuktumu(), C_UmuKbn.NONE, "死亡受取有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean1.getKktumu(), C_UmuKbn.NONE, "告知有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean1.getMusenumu(), C_UmuKbn.NONE, " 無選択有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean1.getSyokugyoukktumu(), C_UmuKbn.NONE, "職業告知有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean1.getHaitoukbn(), C_HaitouKbn.RISAHAI, "配当区分");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean1.getTeikisiharaikinumu(), C_UmuKbn.NONE, "定期支払金有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean1.getItijibrumu(), C_UmuKbn.NONE, "一時払有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean1.getGaikatatkiumu(), C_UmuKbn.NONE, "外貨取扱有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean1.getHengakuumu(), C_UmuKbn.NONE, "変額保険有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean1.getNstkumu(), C_Nstkumu.ST_ARI, "年金支払特約有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean1.getKykdrtentuusanumu(), C_UmuKbn.NONE, "契約者同一代理店通算有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean1.getPyennykntktekiumu(), C_UmuKbn.NONE, "保険料円入金特約適用有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean1.getGaikanyuukintktekiumu(), C_UmuKbn.NONE, "外貨入金特約適用有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean1.getSyuusinhknumu(), C_UmuKbn.NONE, "終身保険有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean1.getNkhknumu(), C_UmuKbn.NONE, "年金保険有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean1.getSyksbyensitihsyutktekiumu(), C_UmuKbn.NONE,"初期死亡時円換算最低保証特約適用有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean1.getJyudkaigomehrtktekiumu(), C_UmuKbn.NONE, "重度介護前払特約適用有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean1.getStdrsktkumu(), C_UmuKbn.NONE, "被保険者代理特約有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean1.getTuukasyu(), C_Tuukasyu.USD, "通貨種類");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean1.getAeoitaisyouumu(), C_UmuKbn.NONE, "ＡＥＯＩ対象有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean1.getHokenkngkyakujyouumu(), C_UmuKbn.ARI, "保険金額約定有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean1.getTargettkhukakanoukbn(),C_TargetTkHukaKanouKbn.YENSYUUSIN, "ターゲット特約付加可能区分");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean1.getTmttknhaibunwarisiteiumu(), C_UmuKbn.ARI, "積立金配分割合指定有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean1.getNkuktumu(), C_UmuKbn.ARI, "年金受取有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean1.getHeijyunbaraiumu(), C_UmuKbn.ARI, "平準払有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean1.getZennouumu(), C_UmuKbn.ARI, "前納有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean1.getItibuzennoutekiumu(), C_UmuKbn.ARI, "一部前納適用有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean1.getKouzahurikaebaraitekiumu(), C_UmuKbn.ARI, "口座振替払適用有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean1.getZeiseitekikakuumu(), C_UmuKbn.ARI, "税制適格有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean1.getKzktourokuserviceumu(), C_UmuKbn.ARI, "家族登録サービス有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean1.getKykdrtkykumu(), C_UmuKbn.ARI, "契約者代理特約有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean1.getPtratkituukasiteikbn(),C_PtratkituukasiteiKbn.SITEITUUKA , "保険料取扱通貨指定区分");
        exNumericEquals(getSyouhnZokuseiCtrlOutBean1.getDai1HknkknSelect().size(), 0, "第１保険期間選択肢の件数");

        exNumericEquals(getSyouhnZokuseiCtrlOutBean1.getTargettkmkhtSelect().size(), 13, "ターゲット特約目標値選択肢mapの件数");
        LabelValuePair targettkmkhtSelectoutPair = getSyouhnZokuseiCtrlOutBean1.getTargettkmkhtSelect().get(0);
        exStringEquals(targettkmkhtSelectoutPair.getValue(), "0", "ターゲット特約目標値選択肢map．バリュー");
        exStringEquals(targettkmkhtSelectoutPair.getLabel(), "", "ターゲット特約目標値選択肢map．ラベル");
        LabelValuePair targettkmkhtSelectoutPair2 = getSyouhnZokuseiCtrlOutBean1.getTargettkmkhtSelect().get(1);
        exStringEquals(targettkmkhtSelectoutPair2.getValue(), "105", "ターゲット特約目標値選択肢map．バリュー");
        exStringEquals(targettkmkhtSelectoutPair2.getLabel(), "１０５％", "ターゲット特約目標値選択肢map．ラベル");
        LabelValuePair targettkmkhtSelectoutPair3 = getSyouhnZokuseiCtrlOutBean1.getTargettkmkhtSelect().get(2);
        exStringEquals(targettkmkhtSelectoutPair3.getValue(), "110", "ターゲット特約目標値選択肢map．バリュー");
        exStringEquals(targettkmkhtSelectoutPair3.getLabel(), "１１０％", "ターゲット特約目標値選択肢map．ラベル");
        LabelValuePair targettkmkhtSelectoutPair4 = getSyouhnZokuseiCtrlOutBean1.getTargettkmkhtSelect().get(3);
        exStringEquals(targettkmkhtSelectoutPair4.getValue(), "120", "ターゲット特約目標値選択肢map．バリュー");
        exStringEquals(targettkmkhtSelectoutPair4.getLabel(), "１２０％", "ターゲット特約目標値選択肢map．ラベル");
        LabelValuePair targettkmkhtSelectoutPair5 = getSyouhnZokuseiCtrlOutBean1.getTargettkmkhtSelect().get(4);
        exStringEquals(targettkmkhtSelectoutPair5.getValue(), "130", "ターゲット特約目標値選択肢map．バリュー");
        exStringEquals(targettkmkhtSelectoutPair5.getLabel(), "１３０％", "ターゲット特約目標値選択肢map．ラベル");
        LabelValuePair targettkmkhtSelectoutPair6 = getSyouhnZokuseiCtrlOutBean1.getTargettkmkhtSelect().get(5);
        exStringEquals(targettkmkhtSelectoutPair6.getValue(), "140", "ターゲット特約目標値選択肢map．バリュー");
        exStringEquals(targettkmkhtSelectoutPair6.getLabel(), "１４０％", "ターゲット特約目標値選択肢map．ラベル");
        LabelValuePair targettkmkhtSelectoutPair7 = getSyouhnZokuseiCtrlOutBean1.getTargettkmkhtSelect().get(6);
        exStringEquals(targettkmkhtSelectoutPair7.getValue(), "150", "ターゲット特約目標値選択肢map．バリュー");
        exStringEquals(targettkmkhtSelectoutPair7.getLabel(), "１５０％", "ターゲット特約目標値選択肢map．ラベル");
        LabelValuePair targettkmkhtSelectoutPair8 = getSyouhnZokuseiCtrlOutBean1.getTargettkmkhtSelect().get(7);
        exStringEquals(targettkmkhtSelectoutPair8.getValue(), "160", "ターゲット特約目標値選択肢map．バリュー");
        exStringEquals(targettkmkhtSelectoutPair8.getLabel(), "１６０％", "ターゲット特約目標値選択肢map．ラベル");
        LabelValuePair targettkmkhtSelectoutPair9 = getSyouhnZokuseiCtrlOutBean1.getTargettkmkhtSelect().get(8);
        exStringEquals(targettkmkhtSelectoutPair9.getValue(), "170", "ターゲット特約目標値選択肢map．バリュー");
        exStringEquals(targettkmkhtSelectoutPair9.getLabel(), "１７０％", "ターゲット特約目標値選択肢map．ラベル");
        LabelValuePair targettkmkhtSelectoutPair10 = getSyouhnZokuseiCtrlOutBean1.getTargettkmkhtSelect().get(9);
        exStringEquals(targettkmkhtSelectoutPair10.getValue(), "180", "ターゲット特約目標値選択肢map．バリュー");
        exStringEquals(targettkmkhtSelectoutPair10.getLabel(), "１８０％", "ターゲット特約目標値選択肢map．ラベル");
        LabelValuePair targettkmkhtSelectoutPair11 = getSyouhnZokuseiCtrlOutBean1.getTargettkmkhtSelect().get(10);
        exStringEquals(targettkmkhtSelectoutPair11.getValue(), "190", "ターゲット特約目標値選択肢map．バリュー");
        exStringEquals(targettkmkhtSelectoutPair11.getLabel(), "１９０％", "ターゲット特約目標値選択肢map．ラベル");
        LabelValuePair targettkmkhtSelectoutPair12 = getSyouhnZokuseiCtrlOutBean1.getTargettkmkhtSelect().get(11);
        exStringEquals(targettkmkhtSelectoutPair12.getValue(), "200", "ターゲット特約目標値選択肢map．バリュー");
        exStringEquals(targettkmkhtSelectoutPair12.getLabel(), "２００％", "ターゲット特約目標値選択肢map．ラベル");
        LabelValuePair targettkmkhtSelectoutPair13 = getSyouhnZokuseiCtrlOutBean1.getTargettkmkhtSelect().get(12);
        exStringEquals(targettkmkhtSelectoutPair13.getValue(), "999", "ターゲット特約目標値選択肢map．バリュー");
        exStringEquals(targettkmkhtSelectoutPair13.getLabel(), "設定しない", "ターゲット特約目標値選択肢map．ラベル");

        exNumericEquals(getSyouhnZokuseiCtrlOutBean1.getNenkinsyuSelect().size(), 5, "年金種類選択肢の件数");
        LabelValuePair enkinsyuSelectoutPair = getSyouhnZokuseiCtrlOutBean1.getNenkinsyuSelect().get(0);
        exStringEquals(enkinsyuSelectoutPair.getValue(), "0", "年金種類選択肢．バリュー");
        exStringEquals(enkinsyuSelectoutPair.getLabel(), "", "年金種類選択肢．ラベル");
        LabelValuePair enkinsyuSelectoutPair2 = getSyouhnZokuseiCtrlOutBean1.getNenkinsyuSelect().get(1);
        exStringEquals(enkinsyuSelectoutPair2.getValue(), "1", "年金種類選択肢．バリュー");
        exStringEquals(enkinsyuSelectoutPair2.getLabel(), "５年確定", "年金種類選択肢．ラベル");
        LabelValuePair enkinsyuSelectoutPair3 = getSyouhnZokuseiCtrlOutBean1.getNenkinsyuSelect().get(2);
        exStringEquals(enkinsyuSelectoutPair3.getValue(), "2", "年金種類選択肢．バリュー");
        exStringEquals(enkinsyuSelectoutPair3.getLabel(), "１０年確定", "年金種類選択肢．ラベル");
        LabelValuePair enkinsyuSelectoutPair4 = getSyouhnZokuseiCtrlOutBean1.getNenkinsyuSelect().get(3);
        exStringEquals(enkinsyuSelectoutPair4.getValue(), "3", "年金種類選択肢．バリュー");
        exStringEquals(enkinsyuSelectoutPair4.getLabel(), "１５年確定", "年金種類選択肢．ラベル");
        LabelValuePair enkinsyuSelectoutPair5 = getSyouhnZokuseiCtrlOutBean1.getNenkinsyuSelect().get(4);
        exStringEquals(enkinsyuSelectoutPair5.getValue(), "8", "年金種類選択肢．バリュー");
        exStringEquals(enkinsyuSelectoutPair5.getLabel(), "年金総額保証付終身", "年金種類選択肢．ラベル");

        exNumericEquals(getSyouhnZokuseiCtrlOutBean1.getSueokikknSelect().size(), 3, "据置期間選択肢の件数");
        LabelValuePair sueokikknSelectoutPair = getSyouhnZokuseiCtrlOutBean1.getSueokikknSelect().get(0);
        exStringEquals(sueokikknSelectoutPair.getValue(), "0", "年金種類選択肢．バリュー");
        exStringEquals(sueokikknSelectoutPair.getLabel(), "", "年金種類選択肢．ラベル");
        LabelValuePair sueokikknSelectoutPair2 = getSyouhnZokuseiCtrlOutBean1.getSueokikknSelect().get(1);
        exStringEquals(sueokikknSelectoutPair2.getValue(), "5", "年金種類選択肢．バリュー");
        exStringEquals(sueokikknSelectoutPair2.getLabel(), "５年", "年金種類選択肢．ラベル");
        LabelValuePair sueokikknSelectoutPair3 = getSyouhnZokuseiCtrlOutBean1.getSueokikknSelect().get(2);
        exStringEquals(sueokikknSelectoutPair3.getValue(), "10", "年金種類選択肢．バリュー");
        exStringEquals(sueokikknSelectoutPair3.getLabel(), "１０年", "年金種類選択肢．ラベル");

        exNumericEquals(getSyouhnZokuseiCtrlOutBean1.getHrktuukaSelect().size(),4, "払込通貨選択肢の件数");
        LabelValuePair hrktuukaSelecttoutPair = getSyouhnZokuseiCtrlOutBean1.getHrktuukaSelect().get(0);
        exStringEquals(hrktuukaSelecttoutPair.getValue(), "0", "払込通貨選択肢map．バリュー");
        exStringEquals(hrktuukaSelecttoutPair.getLabel(), "", "払込通貨選択肢map．ラベル");
        LabelValuePair hrktuukaSelecttoutPair1 = getSyouhnZokuseiCtrlOutBean1.getHrktuukaSelect().get(1);
        exStringEquals(hrktuukaSelecttoutPair1.getValue(), "JPY", "払込通貨選択肢map．バリュー");
        exStringEquals(hrktuukaSelecttoutPair1.getLabel(), "円", "払込通貨選択肢map．ラベル");
        LabelValuePair hrktuukaSelecttoutPair2 = getSyouhnZokuseiCtrlOutBean1.getHrktuukaSelect().get(2);
        exStringEquals(hrktuukaSelecttoutPair2.getValue(), "USD", "払込通貨選択肢map．バリュー");
        exStringEquals(hrktuukaSelecttoutPair2.getLabel(), "米ドル", "払込通貨選択肢map．ラベル");
        LabelValuePair hrktuukaSelecttoutPair3 = getSyouhnZokuseiCtrlOutBean1.getHrktuukaSelect().get(3);
        exStringEquals(hrktuukaSelecttoutPair3.getValue(), "AUD", "払込通貨選択肢map．バリュー");
        exStringEquals(hrktuukaSelecttoutPair3.getLabel(), "豪ドル", "払込通貨選択肢map．ラベル");

        exNumericEquals(getSyouhnZokuseiCtrlOutBean1.getHrkkeiroSelect().size(), 0, "払込経路選択肢の件数");

        exClassificationEquals(getSyouhnZokuseiCtrlOutBean1.getHknkknsmnKbn(), C_HknkknsmnKbn.NENMANKI, "保険期間歳満期区分");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean1.getHrkkknsmnkbn(), C_HrkkknsmnKbn.BLNK, "払込期間歳満期区分");

        GetSyouhnZokuseiCtrlOutBean getSyouhnZokuseiCtrlOutBean2 = getSyouhnZokuseiCtrlOutBeanLst.get(1);
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean2.getHknsyuruino(),C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, "保険種類番号");
        exNumericEquals(getSyouhnZokuseiCtrlOutBean2.getHknsyuruinosd(), 300, "保険種類番号世代");
        exStringEquals(getSyouhnZokuseiCtrlOutBean2.getInputctrlsyouhncd(), "0004", "入力制御用商品コード");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean2.getSbuktumu(), C_UmuKbn.ARI, "死亡受取有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean2.getKktumu(), C_UmuKbn.ARI, "告知有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean2.getMusenumu(), C_UmuKbn.ARI, " 無選択有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean2.getSyokugyoukktumu(), C_UmuKbn.ARI, "職業告知有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean2.getHaitoukbn(), C_HaitouKbn.NONE, "配当区分");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean2.getTeikisiharaikinumu(), C_UmuKbn.ARI, "定期支払金有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean2.getItijibrumu(), C_UmuKbn.ARI, "一時払有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean2.getGaikatatkiumu(), C_UmuKbn.ARI, "外貨取扱有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean2.getHengakuumu(), C_UmuKbn.ARI, "変額保険有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean2.getNstkumu(), C_Nstkumu.ST_NASI, "年金支払特約有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean2.getKykdrtentuusanumu(), C_UmuKbn.ARI, "契約者同一代理店通算有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean2.getPyennykntktekiumu(), C_UmuKbn.ARI, "保険料円入金特約適用有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean2.getGaikanyuukintktekiumu(), C_UmuKbn.ARI, "外貨入金特約適用有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean2.getSyuusinhknumu(), C_UmuKbn.ARI, "終身保険有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean2.getNkhknumu(), C_UmuKbn.ARI, "年金保険有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean2.getSyksbyensitihsyutktekiumu(), C_UmuKbn.ARI,"初期死亡時円換算最低保証特約適用有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean2.getJyudkaigomehrtktekiumu(), C_UmuKbn.ARI, "重度介護前払特約適用有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean2.getStdrsktkumu(), C_UmuKbn.ARI, "被保険者代理特約有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean2.getTuukasyu(), C_Tuukasyu.EUR, "通貨種類");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean2.getAeoitaisyouumu(), C_UmuKbn.ARI, "ＡＥＯＩ対象有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean2.getHokenkngkyakujyouumu(), C_UmuKbn.ARI, "保険金額約定有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean2.getTargettkhukakanoukbn(),C_TargetTkHukaKanouKbn.YENNENKIN, "ターゲット特約付加可能区分");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean2.getTmttknhaibunwarisiteiumu(), C_UmuKbn.ARI, "積立金配分割合指定有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean2.getNkuktumu(), C_UmuKbn.ARI, "年金受取有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean2.getHeijyunbaraiumu(), C_UmuKbn.NONE, "平準払有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean2.getZennouumu(), C_UmuKbn.NONE, "前納有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean2.getItibuzennoutekiumu(), C_UmuKbn.NONE, "一部前納適用有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean2.getKouzahurikaebaraitekiumu(), C_UmuKbn.NONE, "口座振替払適用有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean2.getZeiseitekikakuumu(), C_UmuKbn.NONE, "税制適格有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean2.getKzktourokuserviceumu(), C_UmuKbn.NONE, "家族登録サービス有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean2.getKykdrtkykumu(), C_UmuKbn.NONE, "契約者代理特約有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean2.getPtratkituukasiteikbn(),C_PtratkituukasiteiKbn.HRKTUUKA , "保険料取扱通貨指定区分");
        exNumericEquals(getSyouhnZokuseiCtrlOutBean2.getDai1HknkknSelect().size(), 0, "第１保険期間選択肢の件数");
        exNumericEquals(getSyouhnZokuseiCtrlOutBean2.getTargettkmkhtSelect().size(), 0, "ターゲット特約目標値選択肢mapの件数");
        exNumericEquals(getSyouhnZokuseiCtrlOutBean2.getNenkinsyuSelect().size(), 0, "年金種類選択肢の件数");
        exNumericEquals(getSyouhnZokuseiCtrlOutBean2.getSueokikknSelect().size(), 0, "据置期間選択肢の件数");
        exNumericEquals(getSyouhnZokuseiCtrlOutBean2.getHrktuukaSelect().size(),0, "払込通貨選択肢の件数");

        exNumericEquals(getSyouhnZokuseiCtrlOutBean2.getHrkkeiroSelect().size(), 0, "払込経路選択肢の件数");

        exClassificationEquals(getSyouhnZokuseiCtrlOutBean2.getHknkknsmnKbn(), C_HknkknsmnKbn.BLNK, "保険期間歳満期区分");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean2.getHrkkknsmnkbn(), C_HrkkknsmnKbn.BLNK, "払込期間歳満期区分");

    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testGetGamenctrl_A4() {
        List<GetSyouhnZokuseiCtrlInBean> getSyouhnZokuseiCtrlInBeanLst = new ArrayList<>();

        GetSyouhnZokuseiCtrlInBean getSyouhnZokuseiCtrlInBean = new GetSyouhnZokuseiCtrlInBean();
        getSyouhnZokuseiCtrlInBean.setHknsyuruino(C_HknsyuruiNo.GAIKARIRITUHENDOUNK);
        getSyouhnZokuseiCtrlInBean.setHknsyuruinosd(100);
        getSyouhnZokuseiCtrlInBean.setInputctrlSyouhnCd("0001");
        getSyouhnZokuseiCtrlInBean.setInputctrlSyouhnSdNo(10);
        getSyouhnZokuseiCtrlInBean.setMos2hyoujiumuKbn(C_UmuKbn.ARI);
        getSyouhnZokuseiCtrlInBeanLst.add(getSyouhnZokuseiCtrlInBean);

        List<GetSyouhnZokuseiCtrlOutBean> getSyouhnZokuseiCtrlOutBeanLst = getMosGamenctrl.getGamenctrl(getSyouhnZokuseiCtrlInBeanLst);

        exNumericEquals(getSyouhnZokuseiCtrlOutBeanLst.size(), 1, "制御用商品属性取得出力Beanリスト．サイズ");

        GetSyouhnZokuseiCtrlOutBean getSyouhnZokuseiCtrlOutBean = getSyouhnZokuseiCtrlOutBeanLst.get(0);

        exNumericEquals(getSyouhnZokuseiCtrlOutBean.getHrkkeiroSelect().size(), 2, "払込経路選択肢の件数");

        LabelValuePair hrkkeiroSelecttoutPair = getSyouhnZokuseiCtrlOutBean.getHrkkeiroSelect().get(0);
        exStringEquals(hrkkeiroSelecttoutPair.getValue(), "1", "払込経路選択肢map．バリュー");
        exStringEquals(hrkkeiroSelecttoutPair.getLabel(), "口座振替", "払込経路選択肢map．ラベル");
        LabelValuePair hrkkeiroSelecttoutPair1 = getSyouhnZokuseiCtrlOutBean.getHrkkeiroSelect().get(1);
        exStringEquals(hrkkeiroSelecttoutPair1.getValue(), "4", "払込経路選択肢map．バリュー");
        exStringEquals(hrkkeiroSelecttoutPair1.getLabel(), "振替", "払込経路選択肢map．ラベル");

        exClassificationEquals(getSyouhnZokuseiCtrlOutBean.getHrkkknsmnkbn(), C_HrkkknsmnKbn.SAIMANKI, "払込期間歳満期区分");

        exClassificationEquals(getSyouhnZokuseiCtrlOutBean.getTeikiikkatubaraiumu(), C_UmuKbn.ARI, "定期一括払有無");
        exClassificationEquals(getSyouhnZokuseiCtrlOutBean.getMos2hyoujiumuKbn(), C_UmuKbn.ARI, "申込２表示有無区分");
        exNumericEquals(getSyouhnZokuseiCtrlOutBean.getKyktuukasyuSelect().size(), 1, "契約通貨種類選択肢の件数");
        LabelValuePair kyktuukasyuSelecttoutPair = getSyouhnZokuseiCtrlOutBean.getKyktuukasyuSelect().get(0);
        exStringEquals(kyktuukasyuSelecttoutPair.getValue(), "USD", "契約通貨種類選択肢map．バリュー");
        exStringEquals(kyktuukasyuSelecttoutPair.getLabel(), "米ドル", "契約通貨種類選択肢map．ラベル");
        exNumericEquals(getSyouhnZokuseiCtrlOutBean.getKyktuukasyu2Select().size(), 1, "契約通貨種類＿２選択肢の件数");
        LabelValuePair kyktuukasyu2SelecttoutPair = getSyouhnZokuseiCtrlOutBean.getKyktuukasyu2Select().get(0);
        exStringEquals(kyktuukasyu2SelecttoutPair.getValue(), "AUD", "契約通貨種類＿２選択肢map．バリュー");
        exStringEquals(kyktuukasyu2SelecttoutPair.getLabel(), "豪ドル", "契約通貨種類＿２選択肢map．ラベル");
        exNumericEquals(getSyouhnZokuseiCtrlOutBean.getHrkkaisuuSelect().size(), 1, "払込回数選択肢の件数");
        LabelValuePair hrkkaisuuSelecttoutPair = getSyouhnZokuseiCtrlOutBean.getHrkkaisuuSelect().get(0);
        exStringEquals(hrkkaisuuSelecttoutPair.getValue(), "1", "払込回数選択肢map．バリュー");
        exStringEquals(hrkkaisuuSelecttoutPair.getLabel(), "月払", "払込回数選択肢map．ラベル");
        exNumericEquals(getSyouhnZokuseiCtrlOutBean.getIkkatubaraikaisuuSelect().size(), 3, "一括払回数選択肢の件数");
        LabelValuePair ikkatubaraikaisuuSelecttoutPair1 = getSyouhnZokuseiCtrlOutBean.getIkkatubaraikaisuuSelect().get(0);
        exStringEquals(ikkatubaraikaisuuSelecttoutPair1.getValue(), "0", "一括払回数選択肢map．バリュー");
        exStringEquals(ikkatubaraikaisuuSelecttoutPair1.getLabel(), "", "一括払回数選択肢map．ラベル");
        LabelValuePair ikkatubaraikaisuuSelecttoutPair2 = getSyouhnZokuseiCtrlOutBean.getIkkatubaraikaisuuSelect().get(1);
        exStringEquals(ikkatubaraikaisuuSelecttoutPair2.getValue(), "6", "一括払回数選択肢map．バリュー");
        exStringEquals(ikkatubaraikaisuuSelecttoutPair2.getLabel(), "６か月定期一括払", "一括払回数選択肢map．ラベル");
        LabelValuePair ikkatubaraikaisuuSelecttoutPair3 = getSyouhnZokuseiCtrlOutBean.getIkkatubaraikaisuuSelect().get(2);
        exStringEquals(ikkatubaraikaisuuSelecttoutPair3.getValue(), "12", "一括払回数選択肢map．バリュー");
        exStringEquals(ikkatubaraikaisuuSelecttoutPair3.getLabel(), "１２か月定期一括払", "一括払回数選択肢map．ラベル");
        exNumericEquals(getSyouhnZokuseiCtrlOutBean.getZenkizennouSelect().size(), 2, "全期前納選択肢の件数");
        LabelValuePair zenkizennouSelecttoutPair1 = getSyouhnZokuseiCtrlOutBean.getZenkizennouSelect().get(0);
        exStringEquals(zenkizennouSelecttoutPair1.getValue(), "1", "全期前納選択肢map．バリュー");
        exStringEquals(zenkizennouSelecttoutPair1.getLabel(), "あり", "全期前納選択肢map．ラベル");
        LabelValuePair zenkizennouSelecttoutPair2 = getSyouhnZokuseiCtrlOutBean.getZenkizennouSelect().get(1);
        exStringEquals(zenkizennouSelecttoutPair2.getValue(), "2", "全期前納選択肢map．バリュー");
        exStringEquals(zenkizennouSelecttoutPair2.getLabel(), "なし", "全期前納選択肢map．ラベル");

    }
}
