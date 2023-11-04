package yuyu.common.hozen.renkei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.biz.bean.webservice.IwssnSyanaiAnsyuInfoOutputBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_IwssnKykSyoukaiKekkaKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

import com.google.inject.Inject;

/**
 * 契約保全 サブシステム連携 社内Web用案内収納契約内容情報取得クラスのメソッド
 *  {@link KhansyuuGetSyanaiWebKeiyakuInfo#exec(String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class KhansyuuGetSyanaiWebKeiyakuInfoTest_exec extends AbstractTest {
    @Inject
    private KhansyuuGetSyanaiWebKeiyakuInfo keiyakuInfo;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_社内Web用案内収納契約内容情報取得";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(KhansyuuGetSyanaiWebKeiyakuInfoTest_exec.class, fileName, sheetName);
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
        bizDomManager.delete(bizDomManager.getAllSosikiMadoguti());
        bizDomManager.delete(bizDomManager.getAllGinkou());

        MockObjectManager.initialize();
    }

    @Test
    @TestOrder(10)
    public void testEditTBL_A1() {

        C_IwssnKykSyoukaiKekkaKbn syoriKekkaKbn = keiyakuInfo.exec("99806034159");
        IwssnSyanaiAnsyuInfoOutputBean infoOutputBean = keiyakuInfo.getIwssnSyanaiAnsyuInfoOutputBean();

        exClassificationEquals(syoriKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.NORMAL, "処理結果区分");
        exStringEquals(infoOutputBean.getIwssnHeijyunjkipjytym(), null, "（ＩＷＳＳＮ）平準払次回Ｐ充当年月");
        exStringEquals(infoOutputBean.getIwssnHeijyunanjoannaiym1(), null, "（ＩＷＳＳＮ）平準払案内状況案内月１");
        exStringEquals(infoOutputBean.getIwssnHeijyunanjoannaiym2(), null, "（ＩＷＳＳＮ）平準払案内状況案内月２");
        exStringEquals(infoOutputBean.getIwssnHeijyunanjoannaiym3(), null, "（ＩＷＳＳＮ）平準払案内状況案内月３");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijytym1(), null, "（ＩＷＳＳＮ）平準払案内状況案内充当年月１");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijytym2(), null, "（ＩＷＳＳＮ）平準払案内状況案内充当年月２");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijytym3(), null, "（ＩＷＳＳＮ）平準払案内状況案内充当年月３");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbn1(), null, "（ＩＷＳＳＮ）平準払案内状況案内状況区分１");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbn2(), null, "（ＩＷＳＳＮ）平準払案内状況案内状況区分２");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbn3(), null, "（ＩＷＳＳＮ）平準払案内状況案内状況区分３");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbnnm1(), null, "（ＩＷＳＳＮ）平準払案内状況案内状況区分（区分名称）１");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbnnm2(), null, "（ＩＷＳＳＮ）平準払案内状況案内状況区分（区分名称）２");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbnnm3(), null, "（ＩＷＳＳＮ）平準払案内状況案内状況区分（区分名称）３");
        exStringEquals(infoOutputBean.getIwssnHijynannaijytkaisuuy(), null, "（ＩＷＳＳＮ）平準払案内充当回数（年）（預振口座案内情報）");
        exStringEquals(infoOutputBean.getIwssnHijynannaijytkaisuum(), null, "（ＩＷＳＳＮ）平準払案内充当回数（月）（預振口座案内情報）");
        exStringEquals(infoOutputBean.getIwssnHeijyunannaigk(), null, "（ＩＷＳＳＮ）平準払案内金額（預振口座案内情報）");
        exStringEquals(infoOutputBean.getIwssnTeikiikkatubaraijkkbn(), null, "（ＩＷＳＳＮ）定期一括払状況区分");
        exStringEquals(infoOutputBean.getIwssnTikiktbrjkkbnnm(), null, "（ＩＷＳＳＮ）定期一括払状況（区分名称）");
        exStringEquals(infoOutputBean.getIwssnHrkkeirokbn(), "6", "（ＩＷＳＳＮ）払込経路区分");
        exStringEquals(infoOutputBean.getIwssnHrkkeirokbnnm(), "クレジットカード扱い", "（ＩＷＳＳＮ）払込経路（区分名称）");
        exStringEquals(infoOutputBean.getIwssnHrkkaisuukbn(), "12", "（ＩＷＳＳＮ）払込回数区分");
        exStringEquals(infoOutputBean.getIwssnHrkkaisuukbnnm(), "年１回払", "（ＩＷＳＳＮ）払込回数（区分名称）");
        exStringEquals(infoOutputBean.getIwssnHrkp(), null, "（ＩＷＳＳＮ）払込保険料");
        exStringEquals(infoOutputBean.getIwssnHrkptuukasyu(), null, "（ＩＷＳＳＮ）払込保険料（通貨種類）");
        exStringEquals(infoOutputBean.getIwssnDattairiyuukbn(), null, "（ＩＷＳＳＮ）脱退理由区分");
        exStringEquals(infoOutputBean.getIwssnDattairiyuukbnnm(), null, "（ＩＷＳＳＮ）脱退理由（区分名称）");
        exStringEquals(infoOutputBean.getIwssnYfrjkouzano(), null, "（ＩＷＳＳＮ）預振情報口座番号");
        exStringEquals(infoOutputBean.getIwssnYfrjkzmeigikn(), null, "（ＩＷＳＳＮ）預振情報口座名義人（カナ）");
        exStringEquals(infoOutputBean.getIwssnYfrjbanknm(), null, "（ＩＷＳＳＮ）預振情報銀行名称");
        exStringEquals(infoOutputBean.getIwssnYfrjsitennm(), null, "（ＩＷＳＳＮ）預振情報支店名称");
        exStringEquals(infoOutputBean.getIwssnYfrjyokinkbnnm(), null, "（ＩＷＳＳＮ）預振情報預金種目（区分名称）");
        exStringEquals(infoOutputBean.getIwssnYfrjbankcd(), null, "（ＩＷＳＳＮ）預振情報銀行コード");
        exStringEquals(infoOutputBean.getIwssnYfrjsitencd(), null, "（ＩＷＳＳＮ）預振情報支店コード");
        exStringEquals(infoOutputBean.getIwssnYfrjyokinkbn(), null, "（ＩＷＳＳＮ）預振情報預金種目区分");
        exStringEquals(infoOutputBean.getIwssnDattaisyoriymd(), null, "（ＩＷＳＳＮ）脱退処理日");
        exStringEquals(infoOutputBean.getIwssnDtjcomment(), null, "（ＩＷＳＳＮ）脱退情報コメント");
        exStringEquals(infoOutputBean.getIwssnHeijyunannaiym(), null, "（ＩＷＳＳＮ）平準払案内月");
        exStringEquals(infoOutputBean.getIwssnHeijyunannaijyutouym(), null, "（ＩＷＳＳＮ）平準払案内充当年月");
        exStringEquals(infoOutputBean.getIwssnCreyuukoukakkekka(), null, "（ＩＷＳＳＮ）クレジットカード有効確認結果");
        exStringEquals(infoOutputBean.getIwssnCreyuukoukakkekkakbnnm(), null, "（ＩＷＳＳＮ）クレジットカード有効確認結果（区分名称）");
        exStringEquals(infoOutputBean.getIwssnCredityuukoukakym(), null, "（ＩＷＳＳＮ）クレジットカード有効確認年月");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbn1(), null, "（ＩＷＳＳＮ）売上請求ＮＧ事由区分１");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbn2(), null, "（ＩＷＳＳＮ）売上請求ＮＧ事由区分２");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbn3(), null, "（ＩＷＳＳＮ）売上請求ＮＧ事由区分３");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbnnm1(), null, "（ＩＷＳＳＮ）売上請求ＮＧ事由区分（区分名称）１");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbnnm2(), null, "（ＩＷＳＳＮ）売上請求ＮＧ事由区分（区分名称）２");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbnnm3(), null, "（ＩＷＳＳＮ）売上請求ＮＧ事由区分（区分名称）３");
        exStringEquals(infoOutputBean.getIwssnYenkansanp(), null, "（ＩＷＳＳＮ）円換算保険料");
        exStringEquals(infoOutputBean.getIwssnYenkansanptuukasyu(), null, "（ＩＷＳＳＮ）円換算保険料（通貨種類）");
        exStringEquals(infoOutputBean.getIwssnKktikwsrate(), null, "（ＩＷＳＳＮ）確定為替レート");
        exStringEquals(infoOutputBean.getIwssnKnsnkijyunymd(), null, "（ＩＷＳＳＮ）換算基準日");
        exStringEquals(infoOutputBean.getIwssnYykknmnryymd(), null, "（ＩＷＳＳＮ）猶予期間満了日");

    }

    @Test
    @TestOrder(20)
    public void testEditTBL_A2() {

        C_IwssnKykSyoukaiKekkaKbn syoriKekkaKbn = keiyakuInfo.exec("99806034160");
        IwssnSyanaiAnsyuInfoOutputBean infoOutputBean = keiyakuInfo.getIwssnSyanaiAnsyuInfoOutputBean();

        exClassificationEquals(syoriKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.SONOTAHENSYUU_ERROR, "処理結果区分");
        exStringEquals(infoOutputBean.getIwssnHeijyunjkipjytym(), "000000", "（ＩＷＳＳＮ）平準払次回Ｐ充当年月");
        exStringEquals(infoOutputBean.getIwssnHeijyunanjoannaiym1(), "000000", "（ＩＷＳＳＮ）平準払案内状況案内月１");
        exStringEquals(infoOutputBean.getIwssnHeijyunanjoannaiym2(), "000000", "（ＩＷＳＳＮ）平準払案内状況案内月２");
        exStringEquals(infoOutputBean.getIwssnHeijyunanjoannaiym3(), "000000", "（ＩＷＳＳＮ）平準払案内状況案内月３");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijytym1(), "000000", "（ＩＷＳＳＮ）平準払案内状況案内充当年月１");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijytym2(), "000000", "（ＩＷＳＳＮ）平準払案内状況案内充当年月２");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijytym3(), "000000", "（ＩＷＳＳＮ）平準払案内状況案内充当年月３");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbn1(), " ", "（ＩＷＳＳＮ）平準払案内状況案内状況区分１");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbn2(), " ", "（ＩＷＳＳＮ）平準払案内状況案内状況区分２");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbn3(), " ", "（ＩＷＳＳＮ）平準払案内状況案内状況区分３");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbnnm1(), "　", "（ＩＷＳＳＮ）平準払案内状況案内状況区分（区分名称）１");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbnnm2(), "　", "（ＩＷＳＳＮ）平準払案内状況案内状況区分（区分名称）２");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbnnm3(), "　", "（ＩＷＳＳＮ）平準払案内状況案内状況区分（区分名称）３");
        exStringEquals(infoOutputBean.getIwssnHijynannaijytkaisuuy(), "0", "（ＩＷＳＳＮ）平準払案内充当回数（年）（預振口座案内情報）");
        exStringEquals(infoOutputBean.getIwssnHijynannaijytkaisuum(), "0", "（ＩＷＳＳＮ）平準払案内充当回数（月）（預振口座案内情報）");
        exStringEquals(infoOutputBean.getIwssnHeijyunannaigk(), "0", "（ＩＷＳＳＮ）平準払案内金額（預振口座案内情報）");
        exStringEquals(infoOutputBean.getIwssnTeikiikkatubaraijkkbn(), " ", "（ＩＷＳＳＮ）定期一括払状況区分");
        exStringEquals(infoOutputBean.getIwssnTikiktbrjkkbnnm(), "　", "（ＩＷＳＳＮ）定期一括払状況（区分名称）");
        exStringEquals(infoOutputBean.getIwssnHrkkaisuukbn(), "12", "（ＩＷＳＳＮ）払込回数区分");
        exStringEquals(infoOutputBean.getIwssnHrkkaisuukbnnm(), "年１回払", "（ＩＷＳＳＮ）払込回数（区分名称）");
        exStringEquals(infoOutputBean.getIwssnHrkkeirokbn(), "4", "（ＩＷＳＳＮ）払込経路区分");
        exStringEquals(infoOutputBean.getIwssnHrkkeirokbnnm(), "振替", "（ＩＷＳＳＮ）払込経路（区分名称）");
        exStringEquals(infoOutputBean.getIwssnHrkp(), "0", "（ＩＷＳＳＮ）払込保険料");
        exStringEquals(infoOutputBean.getIwssnHrkptuukasyu(), " ", "（ＩＷＳＳＮ）払込保険料（通貨種類）");
        exStringEquals(infoOutputBean.getIwssnDattairiyuukbn(), " ", "（ＩＷＳＳＮ）脱退理由区分");
        exStringEquals(infoOutputBean.getIwssnDattairiyuukbnnm(), "　", "（ＩＷＳＳＮ）脱退理由（区分名称）");
        exStringEquals(infoOutputBean.getIwssnYfrjkouzano(), " ", "（ＩＷＳＳＮ）預振情報口座番号");
        exStringEquals(infoOutputBean.getIwssnYfrjkzmeigikn(), " ", "（ＩＷＳＳＮ）預振情報口座名義人（カナ）");
        exStringEquals(infoOutputBean.getIwssnYfrjbanknm(), "　", "（ＩＷＳＳＮ）預振情報銀行名称");
        exStringEquals(infoOutputBean.getIwssnYfrjsitennm(), "　", "（ＩＷＳＳＮ）預振情報支店名称");
        exStringEquals(infoOutputBean.getIwssnYfrjyokinkbnnm(), "　", "（ＩＷＳＳＮ）預振情報預金種目（区分名称）");
        exStringEquals(infoOutputBean.getIwssnYfrjbankcd(), " ", "（ＩＷＳＳＮ）預振情報銀行コード");
        exStringEquals(infoOutputBean.getIwssnYfrjsitencd(), " ", "（ＩＷＳＳＮ）預振情報支店コード");
        exStringEquals(infoOutputBean.getIwssnYfrjyokinkbn(), " ", "（ＩＷＳＳＮ）預振情報預金種目区分");
        exStringEquals(infoOutputBean.getIwssnDattaisyoriymd(), "00000000", "（ＩＷＳＳＮ）脱退処理日");
        exStringEquals(infoOutputBean.getIwssnDtjcomment(), "　", "（ＩＷＳＳＮ）脱退情報コメント");
        exStringEquals(infoOutputBean.getIwssnHeijyunannaiym(), "000000", "（ＩＷＳＳＮ）平準払案内月");
        exStringEquals(infoOutputBean.getIwssnHeijyunannaijyutouym(), "000000", "（ＩＷＳＳＮ）平準払案内充当年月");
        exStringEquals(infoOutputBean.getIwssnCreyuukoukakkekka(), " ", "（ＩＷＳＳＮ）クレジットカード有効確認結果");
        exStringEquals(infoOutputBean.getIwssnCreyuukoukakkekkakbnnm(),"　", "（ＩＷＳＳＮ）クレジットカード有効確認結果（区分名称）");
        exStringEquals(infoOutputBean.getIwssnCredityuukoukakym(), "000000", "（ＩＷＳＳＮ）クレジットカード有効確認年月");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbn1(), " ", "（ＩＷＳＳＮ）売上請求ＮＧ事由区分１");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbn2(), " ", "（ＩＷＳＳＮ）売上請求ＮＧ事由区分２");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbn3(), " ", "（ＩＷＳＳＮ）売上請求ＮＧ事由区分３");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbnnm1(), "　", "（ＩＷＳＳＮ）売上請求ＮＧ事由区分（区分名称）１");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbnnm2(), "　", "（ＩＷＳＳＮ）売上請求ＮＧ事由区分（区分名称）２");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbnnm3(), "　", "（ＩＷＳＳＮ）売上請求ＮＧ事由区分（区分名称）３");
        exStringEquals(infoOutputBean.getIwssnYenkansanp(), null, "（ＩＷＳＳＮ）円換算保険料");
        exStringEquals(infoOutputBean.getIwssnYenkansanptuukasyu(), null, "（ＩＷＳＳＮ）円換算保険料（通貨種類）");
        exStringEquals(infoOutputBean.getIwssnKktikwsrate(), null, "（ＩＷＳＳＮ）確定為替レート");
        exStringEquals(infoOutputBean.getIwssnKnsnkijyunymd(), null, "（ＩＷＳＳＮ）換算基準日");
        exStringEquals(infoOutputBean.getIwssnYykknmnryymd(), null, "（ＩＷＳＳＮ）猶予期間満了日");

    }

    @Test
    @TestOrder(30)
    public void testEditTBL_A3() {

        C_IwssnKykSyoukaiKekkaKbn syoriKekkaKbn = keiyakuInfo.exec("99806034171");
        IwssnSyanaiAnsyuInfoOutputBean infoOutputBean = keiyakuInfo.getIwssnSyanaiAnsyuInfoOutputBean();

        exClassificationEquals(syoriKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.NORMAL, "処理結果区分");
        exStringEquals(infoOutputBean.getIwssnHeijyunjkipjytym(), "201901", "（ＩＷＳＳＮ）平準払次回Ｐ充当年月");
        exStringEquals(infoOutputBean.getIwssnHeijyunanjoannaiym1(), "202007", "（ＩＷＳＳＮ）平準払案内状況案内月１");
        exStringEquals(infoOutputBean.getIwssnHeijyunanjoannaiym2(), "202006", "（ＩＷＳＳＮ）平準払案内状況案内月２");
        exStringEquals(infoOutputBean.getIwssnHeijyunanjoannaiym3(), "202005", "（ＩＷＳＳＮ）平準払案内状況案内月３");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijytym1(), "201908", "（ＩＷＳＳＮ）平準払案内状況案内充当年月１");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijytym2(), "201907", "（ＩＷＳＳＮ）平準払案内状況案内充当年月２");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijytym3(), "201906", "（ＩＷＳＳＮ）平準払案内状況案内充当年月３");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbn1(), "3", "（ＩＷＳＳＮ）平準払案内状況案内状況区分１");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbn2(), "1", "（ＩＷＳＳＮ）平準払案内状況案内状況区分２");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbn3(), "1", "（ＩＷＳＳＮ）平準払案内状況案内状況区分３");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbnnm1(), "未入", "（ＩＷＳＳＮ）平準払案内状況案内状況区分（区分名称）１");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbnnm2(), "案内中", "（ＩＷＳＳＮ）平準払案内状況案内状況区分（区分名称）２");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbnnm3(), "案内中", "（ＩＷＳＳＮ）平準払案内状況案内状況区分（区分名称）３");
        exStringEquals(infoOutputBean.getIwssnHijynannaijytkaisuuy(), "0", "（ＩＷＳＳＮ）平準払案内充当回数（年）（預振口座案内情報）");
        exStringEquals(infoOutputBean.getIwssnHijynannaijytkaisuum(), "6", "（ＩＷＳＳＮ）平準払案内充当回数（月）（預振口座案内情報）");
        exStringEquals(infoOutputBean.getIwssnHeijyunannaigk(), "60000", "（ＩＷＳＳＮ）平準払案内金額（預振口座案内情報）");
        exStringEquals(infoOutputBean.getIwssnTeikiikkatubaraijkkbn(), "1", "（ＩＷＳＳＮ）定期一括払状況区分");
        exStringEquals(infoOutputBean.getIwssnTikiktbrjkkbnnm(), "定期一括なし", "（ＩＷＳＳＮ）定期一括払状況（区分名称）");
        exStringEquals(infoOutputBean.getIwssnHrkkaisuukbn(), "12", "（ＩＷＳＳＮ）払込回数区分");
        exStringEquals(infoOutputBean.getIwssnHrkkaisuukbnnm(), "年１回払", "（ＩＷＳＳＮ）払込回数（区分名称）");
        exStringEquals(infoOutputBean.getIwssnHrkkeirokbn(), "1", "（ＩＷＳＳＮ）払込経路区分");
        exStringEquals(infoOutputBean.getIwssnHrkkeirokbnnm(), "口座振替扱い", "（ＩＷＳＳＮ）払込経路（区分名称）");
        exStringEquals(infoOutputBean.getIwssnHrkp(), "10000007", "（ＩＷＳＳＮ）払込保険料");
        exStringEquals(infoOutputBean.getIwssnHrkptuukasyu(), "YEN", "（ＩＷＳＳＮ）払込保険料（通貨種類）");
        exStringEquals(infoOutputBean.getIwssnDattairiyuukbn(), "2", "（ＩＷＳＳＮ）脱退理由区分");
        exStringEquals(infoOutputBean.getIwssnDattairiyuukbnnm(), "解約希望", "（ＩＷＳＳＮ）脱退理由（区分名称）");
        exStringEquals(infoOutputBean.getIwssnYfrjkouzano(), " ", "（ＩＷＳＳＮ）預振情報口座番号");
        exStringEquals(infoOutputBean.getIwssnYfrjkzmeigikn(), " ", "（ＩＷＳＳＮ）預振情報口座名義人（カナ）");
        exStringEquals(infoOutputBean.getIwssnYfrjbanknm(), "　", "（ＩＷＳＳＮ）預振情報銀行名称");
        exStringEquals(infoOutputBean.getIwssnYfrjsitennm(), "　", "（ＩＷＳＳＮ）預振情報支店名称");
        exStringEquals(infoOutputBean.getIwssnYfrjyokinkbnnm(), "　", "（ＩＷＳＳＮ）預振情報預金種目（区分名称）");
        exStringEquals(infoOutputBean.getIwssnYfrjbankcd(), " ", "（ＩＷＳＳＮ）預振情報銀行コード");
        exStringEquals(infoOutputBean.getIwssnYfrjsitencd(), " ", "（ＩＷＳＳＮ）預振情報支店コード");
        exStringEquals(infoOutputBean.getIwssnYfrjyokinkbn(), " ", "（ＩＷＳＳＮ）預振情報預金種目区分");
        exStringEquals(infoOutputBean.getIwssnDattaisyoriymd(), "20200201", "（ＩＷＳＳＮ）脱退処理日");
        exStringEquals(infoOutputBean.getIwssnDtjcomment(), "振替不能理由区分：収納結果脱退 委託者都合/振替日：2019年8月14日", "（ＩＷＳＳＮ）脱退情報コメント");
        exStringEquals(infoOutputBean.getIwssnHeijyunannaiym(), "202007", "（ＩＷＳＳＮ）平準払案内月");
        exStringEquals(infoOutputBean.getIwssnHeijyunannaijyutouym(), "201908", "（ＩＷＳＳＮ）平準払案内充当年月");
        exStringEquals(infoOutputBean.getIwssnCreyuukoukakkekka(), " ", "（ＩＷＳＳＮ）クレジットカード有効確認結果");
        exStringEquals(infoOutputBean.getIwssnCreyuukoukakkekkakbnnm(),"　", "（ＩＷＳＳＮ）クレジットカード有効確認結果（区分名称）");
        exStringEquals(infoOutputBean.getIwssnCredityuukoukakym(), "000000", "（ＩＷＳＳＮ）クレジットカード有効確認年月");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbn1(), "0", "（ＩＷＳＳＮ）売上請求ＮＧ事由区分１");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbn2(), "0", "（ＩＷＳＳＮ）売上請求ＮＧ事由区分２");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbn3(), "0", "（ＩＷＳＳＮ）売上請求ＮＧ事由区分３");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbnnm1(), "　", "（ＩＷＳＳＮ）売上請求ＮＧ事由区分（区分名称）１");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbnnm2(), "　", "（ＩＷＳＳＮ）売上請求ＮＧ事由区分（区分名称）２");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbnnm3(), "　", "（ＩＷＳＳＮ）売上請求ＮＧ事由区分（区分名称）３");
        exStringEquals(infoOutputBean.getIwssnYenkansanp(), null, "（ＩＷＳＳＮ）円換算保険料");
        exStringEquals(infoOutputBean.getIwssnYenkansanptuukasyu(), null, "（ＩＷＳＳＮ）円換算保険料（通貨種類）");
        exStringEquals(infoOutputBean.getIwssnKktikwsrate(), null, "（ＩＷＳＳＮ）確定為替レート");
        exStringEquals(infoOutputBean.getIwssnKnsnkijyunymd(), null, "（ＩＷＳＳＮ）換算基準日");
        exStringEquals(infoOutputBean.getIwssnYykknmnryymd(), null, "（ＩＷＳＳＮ）猶予期間満了日");

    }

    @Test
    @TestOrder(40)
    public void testEditTBL_A4() {

        C_IwssnKykSyoukaiKekkaKbn syoriKekkaKbn = keiyakuInfo.exec("99806034182");
        IwssnSyanaiAnsyuInfoOutputBean infoOutputBean = keiyakuInfo.getIwssnSyanaiAnsyuInfoOutputBean();

        exClassificationEquals(syoriKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.SONOTAHENSYUU_ERROR, "処理結果区分");
        exStringEquals(infoOutputBean.getIwssnHeijyunjkipjytym(), "201901", "（ＩＷＳＳＮ）平準払次回Ｐ充当年月");
        exStringEquals(infoOutputBean.getIwssnHeijyunanjoannaiym1(), "202001", "（ＩＷＳＳＮ）平準払案内状況案内月１");
        exStringEquals(infoOutputBean.getIwssnHeijyunanjoannaiym2(), "000000", "（ＩＷＳＳＮ）平準払案内状況案内月２");
        exStringEquals(infoOutputBean.getIwssnHeijyunanjoannaiym3(), "000000", "（ＩＷＳＳＮ）平準払案内状況案内月３");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijytym1(), "201908", "（ＩＷＳＳＮ）平準払案内状況案内充当年月１");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijytym2(), "000000", "（ＩＷＳＳＮ）平準払案内状況案内充当年月２");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijytym3(), "000000", "（ＩＷＳＳＮ）平準払案内状況案内充当年月３");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbn1(), "3", "（ＩＷＳＳＮ）平準払案内状況案内状況区分１");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbn2(), " ", "（ＩＷＳＳＮ）平準払案内状況案内状況区分２");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbn3(), " ", "（ＩＷＳＳＮ）平準払案内状況案内状況区分３");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbnnm1(), "未入", "（ＩＷＳＳＮ）平準払案内状況案内状況区分（区分名称）１");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbnnm2(), "　", "（ＩＷＳＳＮ）平準払案内状況案内状況区分（区分名称）２");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbnnm3(), "　", "（ＩＷＳＳＮ）平準払案内状況案内状況区分（区分名称）３");
        exStringEquals(infoOutputBean.getIwssnHijynannaijytkaisuuy(), "0", "（ＩＷＳＳＮ）平準払案内充当回数（年）（預振口座案内情報）");
        exStringEquals(infoOutputBean.getIwssnHijynannaijytkaisuum(), "6", "（ＩＷＳＳＮ）平準払案内充当回数（月）（預振口座案内情報）");
        exStringEquals(infoOutputBean.getIwssnHeijyunannaigk(), "60000", "（ＩＷＳＳＮ）平準払案内金額（預振口座案内情報）");
        exStringEquals(infoOutputBean.getIwssnTeikiikkatubaraijkkbn(), " ", "（ＩＷＳＳＮ）定期一括払状況区分");
        exStringEquals(infoOutputBean.getIwssnTikiktbrjkkbnnm(), "　", "（ＩＷＳＳＮ）定期一括払状況（区分名称）");
        exStringEquals(infoOutputBean.getIwssnHrkkaisuukbn(), "6", "（ＩＷＳＳＮ）払込回数区分");
        exStringEquals(infoOutputBean.getIwssnHrkkaisuukbnnm(), "年２回払", "（ＩＷＳＳＮ）払込回数（区分名称）");
        exStringEquals(infoOutputBean.getIwssnHrkkeirokbn(), "2", "（ＩＷＳＳＮ）払込経路区分");
        exStringEquals(infoOutputBean.getIwssnHrkkeirokbnnm(), "団体", "（ＩＷＳＳＮ）払込経路（区分名称）");
        exStringEquals(infoOutputBean.getIwssnHrkp(), "0", "（ＩＷＳＳＮ）払込保険料");
        exStringEquals(infoOutputBean.getIwssnHrkptuukasyu(), " ", "（ＩＷＳＳＮ）払込保険料（通貨種類）");
        exStringEquals(infoOutputBean.getIwssnDattairiyuukbn(), " ", "（ＩＷＳＳＮ）脱退理由区分");
        exStringEquals(infoOutputBean.getIwssnDattairiyuukbnnm(), "　", "（ＩＷＳＳＮ）脱退理由（区分名称）");
        exStringEquals(infoOutputBean.getIwssnYfrjkouzano(), " ", "（ＩＷＳＳＮ）預振情報口座番号");
        exStringEquals(infoOutputBean.getIwssnYfrjkzmeigikn(), " ", "（ＩＷＳＳＮ）預振情報口座名義人（カナ）");
        exStringEquals(infoOutputBean.getIwssnYfrjbanknm(), "　", "（ＩＷＳＳＮ）預振情報銀行名称");
        exStringEquals(infoOutputBean.getIwssnYfrjsitennm(), "　", "（ＩＷＳＳＮ）預振情報支店名称");
        exStringEquals(infoOutputBean.getIwssnYfrjyokinkbnnm(), "　", "（ＩＷＳＳＮ）預振情報預金種目（区分名称）");
        exStringEquals(infoOutputBean.getIwssnYfrjbankcd(), " ", "（ＩＷＳＳＮ）預振情報銀行コード");
        exStringEquals(infoOutputBean.getIwssnYfrjsitencd(), " ", "（ＩＷＳＳＮ）預振情報支店コード");
        exStringEquals(infoOutputBean.getIwssnYfrjyokinkbn(), " ", "（ＩＷＳＳＮ）預振情報預金種目区分");
        exStringEquals(infoOutputBean.getIwssnDattaisyoriymd(), "00000000", "（ＩＷＳＳＮ）脱退処理日");
        exStringEquals(infoOutputBean.getIwssnDtjcomment(), "　", "（ＩＷＳＳＮ）脱退情報コメント");
        exStringEquals(infoOutputBean.getIwssnHeijyunannaiym(), "202001", "（ＩＷＳＳＮ）平準払案内月");
        exStringEquals(infoOutputBean.getIwssnHeijyunannaijyutouym(), "201908", "（ＩＷＳＳＮ）平準払案内充当年月");
        exStringEquals(infoOutputBean.getIwssnCreyuukoukakkekka(), " ", "（ＩＷＳＳＮ）クレジットカード有効確認結果");
        exStringEquals(infoOutputBean.getIwssnCreyuukoukakkekkakbnnm(),"　", "（ＩＷＳＳＮ）クレジットカード有効確認結果（区分名称）");
        exStringEquals(infoOutputBean.getIwssnCredityuukoukakym(), "000000", "（ＩＷＳＳＮ）クレジットカード有効確認年月");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbn1(), "1", "（ＩＷＳＳＮ）売上請求ＮＧ事由区分１");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbn2(), " ", "（ＩＷＳＳＮ）売上請求ＮＧ事由区分２");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbn3(), " ", "（ＩＷＳＳＮ）売上請求ＮＧ事由区分３");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbnnm1(), "限度額超過", "（ＩＷＳＳＮ）売上請求ＮＧ事由区分（区分名称）１");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbnnm2(), "　", "（ＩＷＳＳＮ）売上請求ＮＧ事由区分（区分名称）２");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbnnm3(), "　", "（ＩＷＳＳＮ）売上請求ＮＧ事由区分（区分名称）３");
        exStringEquals(infoOutputBean.getIwssnYenkansanp(), null, "（ＩＷＳＳＮ）円換算保険料");
        exStringEquals(infoOutputBean.getIwssnYenkansanptuukasyu(), null, "（ＩＷＳＳＮ）円換算保険料（通貨種類）");
        exStringEquals(infoOutputBean.getIwssnKktikwsrate(), null, "（ＩＷＳＳＮ）確定為替レート");
        exStringEquals(infoOutputBean.getIwssnKnsnkijyunymd(), null, "（ＩＷＳＳＮ）換算基準日");
        exStringEquals(infoOutputBean.getIwssnYykknmnryymd(), null, "（ＩＷＳＳＮ）猶予期間満了日");

    }

    @Test
    @TestOrder(50)
    public void testEditTBL_A5() {

        C_IwssnKykSyoukaiKekkaKbn syoriKekkaKbn = keiyakuInfo.exec("99806034193");
        IwssnSyanaiAnsyuInfoOutputBean infoOutputBean = keiyakuInfo.getIwssnSyanaiAnsyuInfoOutputBean();

        exClassificationEquals(syoriKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.NORMAL, "処理結果区分");
        exStringEquals(infoOutputBean.getIwssnHeijyunjkipjytym(), "201901", "（ＩＷＳＳＮ）平準払次回Ｐ充当年月");
        exStringEquals(infoOutputBean.getIwssnHeijyunanjoannaiym1(), "202005", "（ＩＷＳＳＮ）平準払案内状況案内月１");
        exStringEquals(infoOutputBean.getIwssnHeijyunanjoannaiym2(), "202005", "（ＩＷＳＳＮ）平準払案内状況案内月２");
        exStringEquals(infoOutputBean.getIwssnHeijyunanjoannaiym3(), "000000", "（ＩＷＳＳＮ）平準払案内状況案内月３");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijytym1(), "201907", "（ＩＷＳＳＮ）平準払案内状況案内充当年月１");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijytym2(), "201908", "（ＩＷＳＳＮ）平準払案内状況案内充当年月２");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijytym3(), "000000", "（ＩＷＳＳＮ）平準払案内状況案内充当年月３");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbn1(), "2", "（ＩＷＳＳＮ）平準払案内状況案内状況区分１");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbn2(), "3", "（ＩＷＳＳＮ）平準払案内状況案内状況区分２");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbn3(), " ", "（ＩＷＳＳＮ）平準払案内状況案内状況区分３");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbnnm1(), "入金", "（ＩＷＳＳＮ）平準払案内状況案内状況区分（区分名称）１");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbnnm2(), "未入", "（ＩＷＳＳＮ）平準払案内状況案内状況区分（区分名称）２");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbnnm3(), "　", "（ＩＷＳＳＮ）平準払案内状況案内状況区分（区分名称）３");
        exStringEquals(infoOutputBean.getIwssnHijynannaijytkaisuuy(), "0", "（ＩＷＳＳＮ）平準払案内充当回数（年）（預振口座案内情報）");
        exStringEquals(infoOutputBean.getIwssnHijynannaijytkaisuum(), "6", "（ＩＷＳＳＮ）平準払案内充当回数（月）（預振口座案内情報）");
        exStringEquals(infoOutputBean.getIwssnHeijyunannaigk(), "60000", "（ＩＷＳＳＮ）平準払案内金額（預振口座案内情報）");
        exStringEquals(infoOutputBean.getIwssnTeikiikkatubaraijkkbn(), "12", "（ＩＷＳＳＮ）定期一括払状況区分");
        exStringEquals(infoOutputBean.getIwssnTikiktbrjkkbnnm(), "１２か月定期一括", "（ＩＷＳＳＮ）定期一括払状況（区分名称）");
        exStringEquals(infoOutputBean.getIwssnHrkkaisuukbn(), "6", "（ＩＷＳＳＮ）払込回数区分");
        exStringEquals(infoOutputBean.getIwssnHrkkaisuukbnnm(), "年２回払", "（ＩＷＳＳＮ）払込回数（区分名称）");
        exStringEquals(infoOutputBean.getIwssnHrkkeirokbn(), "3", "（ＩＷＳＳＮ）払込経路区分");
        exStringEquals(infoOutputBean.getIwssnHrkkeirokbnnm(), "集団", "（ＩＷＳＳＮ）払込経路（区分名称）");
        exStringEquals(infoOutputBean.getIwssnHrkp(), "10000008", "（ＩＷＳＳＮ）払込保険料");
        exStringEquals(infoOutputBean.getIwssnHrkptuukasyu(), "YEN", "（ＩＷＳＳＮ）払込保険料（通貨種類）");
        exStringEquals(infoOutputBean.getIwssnDattairiyuukbn(), " ", "（ＩＷＳＳＮ）脱退理由区分");
        exStringEquals(infoOutputBean.getIwssnDattairiyuukbnnm(), "　", "（ＩＷＳＳＮ）脱退理由（区分名称）");
        exStringEquals(infoOutputBean.getIwssnYfrjkouzano(), "1006018", "（ＩＷＳＳＮ）預振情報口座番号");
        exStringEquals(infoOutputBean.getIwssnYfrjkzmeigikn(), "ﾕﾋﾒｲ ﾅﾅｲﾁｵ", "（ＩＷＳＳＮ）預振情報口座名義人（カナ）");
        exStringEquals(infoOutputBean.getIwssnYfrjbanknm(), "ゆうちょ銀行", "（ＩＷＳＳＮ）預振情報銀行名称");
        exStringEquals(infoOutputBean.getIwssnYfrjsitennm(), "１００１０", "（ＩＷＳＳＮ）預振情報支店名称");
        exStringEquals(infoOutputBean.getIwssnYfrjyokinkbnnm(), "　", "（ＩＷＳＳＮ）預振情報預金種目（区分名称）");
        exStringEquals(infoOutputBean.getIwssnYfrjbankcd(), "9900", "（ＩＷＳＳＮ）預振情報銀行コード");
        exStringEquals(infoOutputBean.getIwssnYfrjsitencd(), "001", "（ＩＷＳＳＮ）預振情報支店コード");
        exStringEquals(infoOutputBean.getIwssnYfrjyokinkbn(), " ", "（ＩＷＳＳＮ）預振情報預金種目区分");
        exStringEquals(infoOutputBean.getIwssnDattaisyoriymd(), "00000000", "（ＩＷＳＳＮ）脱退処理日");
        exStringEquals(infoOutputBean.getIwssnDtjcomment(), "　", "（ＩＷＳＳＮ）脱退情報コメント");
        exStringEquals(infoOutputBean.getIwssnHeijyunannaiym(), "202005", "（ＩＷＳＳＮ）平準払案内月");
        exStringEquals(infoOutputBean.getIwssnHeijyunannaijyutouym(), "201907", "（ＩＷＳＳＮ）平準払案内充当年月");
        exStringEquals(infoOutputBean.getIwssnCreyuukoukakkekka(), " ", "（ＩＷＳＳＮ）クレジットカード有効確認結果");
        exStringEquals(infoOutputBean.getIwssnCreyuukoukakkekkakbnnm(),"　", "（ＩＷＳＳＮ）クレジットカード有効確認結果（区分名称）");
        exStringEquals(infoOutputBean.getIwssnCredityuukoukakym(), "000000", "（ＩＷＳＳＮ）クレジットカード有効確認年月");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbn1(), "0", "（ＩＷＳＳＮ）売上請求ＮＧ事由区分１");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbn2(), "0", "（ＩＷＳＳＮ）売上請求ＮＧ事由区分２");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbn3(), " ", "（ＩＷＳＳＮ）売上請求ＮＧ事由区分３");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbnnm1(), "　", "（ＩＷＳＳＮ）売上請求ＮＧ事由区分（区分名称）１");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbnnm2(), "　", "（ＩＷＳＳＮ）売上請求ＮＧ事由区分（区分名称）２");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbnnm3(), "　", "（ＩＷＳＳＮ）売上請求ＮＧ事由区分（区分名称）３");
        exStringEquals(infoOutputBean.getIwssnYenkansanp(), null, "（ＩＷＳＳＮ）円換算保険料");
        exStringEquals(infoOutputBean.getIwssnYenkansanptuukasyu(), null, "（ＩＷＳＳＮ）円換算保険料（通貨種類）");
        exStringEquals(infoOutputBean.getIwssnKktikwsrate(), null, "（ＩＷＳＳＮ）確定為替レート");
        exStringEquals(infoOutputBean.getIwssnKnsnkijyunymd(), null, "（ＩＷＳＳＮ）換算基準日");
        exStringEquals(infoOutputBean.getIwssnYykknmnryymd(), null, "（ＩＷＳＳＮ）猶予期間満了日");

    }

    @Test
    @TestOrder(60)
    public void testEditTBL_A6() {

        C_IwssnKykSyoukaiKekkaKbn syoriKekkaKbn = keiyakuInfo.exec("99806034207");
        IwssnSyanaiAnsyuInfoOutputBean infoOutputBean = keiyakuInfo.getIwssnSyanaiAnsyuInfoOutputBean();

        exClassificationEquals(syoriKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.NORMAL, "処理結果区分");
        exStringEquals(infoOutputBean.getIwssnHeijyunjkipjytym(), "201901", "（ＩＷＳＳＮ）平準払次回Ｐ充当年月");
        exStringEquals(infoOutputBean.getIwssnHeijyunanjoannaiym1(), "202005", "（ＩＷＳＳＮ）平準払案内状況案内月１");
        exStringEquals(infoOutputBean.getIwssnHeijyunanjoannaiym2(), "202005", "（ＩＷＳＳＮ）平準払案内状況案内月２");
        exStringEquals(infoOutputBean.getIwssnHeijyunanjoannaiym3(), "202005", "（ＩＷＳＳＮ）平準払案内状況案内月３");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijytym1(), "201906", "（ＩＷＳＳＮ）平準払案内状況案内充当年月１");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijytym2(), "201907", "（ＩＷＳＳＮ）平準払案内状況案内充当年月２");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijytym3(), "201908", "（ＩＷＳＳＮ）平準払案内状況案内充当年月３");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbn1(), "1", "（ＩＷＳＳＮ）平準払案内状況案内状況区分１");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbn2(), "2", "（ＩＷＳＳＮ）平準払案内状況案内状況区分２");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbn3(), "0", "（ＩＷＳＳＮ）平準払案内状況案内状況区分３");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbnnm1(), "案内中", "（ＩＷＳＳＮ）平準払案内状況案内状況区分（区分名称）１");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbnnm2(), "入金", "（ＩＷＳＳＮ）平準払案内状況案内状況区分（区分名称）２");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbnnm3(), "　", "（ＩＷＳＳＮ）平準払案内状況案内状況区分（区分名称）３");
        exStringEquals(infoOutputBean.getIwssnHijynannaijytkaisuuy(), "0", "（ＩＷＳＳＮ）平準払案内充当回数（年）（預振口座案内情報）");
        exStringEquals(infoOutputBean.getIwssnHijynannaijytkaisuum(), "6", "（ＩＷＳＳＮ）平準払案内充当回数（月）（預振口座案内情報）");
        exStringEquals(infoOutputBean.getIwssnHeijyunannaigk(), "60000", "（ＩＷＳＳＮ）平準払案内金額（預振口座案内情報）");
        exStringEquals(infoOutputBean.getIwssnTeikiikkatubaraijkkbn(), "1", "（ＩＷＳＳＮ）定期一括払状況区分");
        exStringEquals(infoOutputBean.getIwssnTikiktbrjkkbnnm(), "定期一括なし", "（ＩＷＳＳＮ）定期一括払状況（区分名称）");
        exStringEquals(infoOutputBean.getIwssnHrkkaisuukbn(), "1", "（ＩＷＳＳＮ）払込回数区分");
        exStringEquals(infoOutputBean.getIwssnHrkkaisuukbnnm(), "月払", "（ＩＷＳＳＮ）払込回数（区分名称）");
        exStringEquals(infoOutputBean.getIwssnHrkkeirokbn(), "4", "（ＩＷＳＳＮ）払込経路区分");
        exStringEquals(infoOutputBean.getIwssnHrkkeirokbnnm(), "振替", "（ＩＷＳＳＮ）払込経路（区分名称）");
        exStringEquals(infoOutputBean.getIwssnHrkp(), "10000007", "（ＩＷＳＳＮ）払込保険料");
        exStringEquals(infoOutputBean.getIwssnHrkptuukasyu(), "YEN", "（ＩＷＳＳＮ）払込保険料（通貨種類）");
        exStringEquals(infoOutputBean.getIwssnDattairiyuukbn(), "1", "（ＩＷＳＳＮ）脱退理由区分");
        exStringEquals(infoOutputBean.getIwssnDattairiyuukbnnm(), "払変希望", "（ＩＷＳＳＮ）脱退理由（区分名称）");
        exStringEquals(infoOutputBean.getIwssnYfrjkouzano(), "2323232101", "（ＩＷＳＳＮ）預振情報口座番号");
        exStringEquals(infoOutputBean.getIwssnYfrjkzmeigikn(), "ﾕﾋﾒｲ ﾅﾅｲﾁｶ", "（ＩＷＳＳＮ）預振情報口座名義人（カナ）");
        exStringEquals(infoOutputBean.getIwssnYfrjbanknm(), "銀行名（漢字）", "（ＩＷＳＳＮ）預振情報銀行名称");
        exStringEquals(infoOutputBean.getIwssnYfrjsitennm(), "支店名（漢字）", "（ＩＷＳＳＮ）預振情報支店名称");
        exStringEquals(infoOutputBean.getIwssnYfrjyokinkbnnm(), "普通", "（ＩＷＳＳＮ）預振情報預金種目（区分名称）");
        exStringEquals(infoOutputBean.getIwssnYfrjbankcd(), "0018", "（ＩＷＳＳＮ）預振情報銀行コード");
        exStringEquals(infoOutputBean.getIwssnYfrjsitencd(), "001", "（ＩＷＳＳＮ）預振情報支店コード");
        exStringEquals(infoOutputBean.getIwssnYfrjyokinkbn(), "1", "（ＩＷＳＳＮ）預振情報預金種目区分");
        exStringEquals(infoOutputBean.getIwssnDattaisyoriymd(), "20200525", "（ＩＷＳＳＮ）脱退処理日");
        exStringEquals(infoOutputBean.getIwssnDtjcomment(), null, "（ＩＷＳＳＮ）脱退情報コメント");
        exStringEquals(infoOutputBean.getIwssnHeijyunannaiym(), "202005", "（ＩＷＳＳＮ）平準払案内月");
        exStringEquals(infoOutputBean.getIwssnHeijyunannaijyutouym(), "201906", "（ＩＷＳＳＮ）平準払案内充当年月");
        exStringEquals(infoOutputBean.getIwssnCreyuukoukakkekka(), "0", "（ＩＷＳＳＮ）クレジットカード有効確認結果");
        exStringEquals(infoOutputBean.getIwssnCreyuukoukakkekkakbnnm(),"　", "（ＩＷＳＳＮ）クレジットカード有効確認結果（区分名称）");
        exStringEquals(infoOutputBean.getIwssnCredityuukoukakym(), "201901", "（ＩＷＳＳＮ）クレジットカード有効確認年月");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbn1(), "2", "（ＩＷＳＳＮ）売上請求ＮＧ事由区分１");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbn2(), "0", "（ＩＷＳＳＮ）売上請求ＮＧ事由区分２");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbn3(), "1", "（ＩＷＳＳＮ）売上請求ＮＧ事由区分３");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbnnm1(), "売上処理未完了", "（ＩＷＳＳＮ）売上請求ＮＧ事由区分（区分名称）１");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbnnm2(), "　", "（ＩＷＳＳＮ）売上請求ＮＧ事由区分（区分名称）２");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbnnm3(), "限度額超過", "（ＩＷＳＳＮ）売上請求ＮＧ事由区分（区分名称）３");
        exStringEquals(infoOutputBean.getIwssnYenkansanp(), null, "（ＩＷＳＳＮ）円換算保険料");
        exStringEquals(infoOutputBean.getIwssnYenkansanptuukasyu(), null, "（ＩＷＳＳＮ）円換算保険料（通貨種類）");
        exStringEquals(infoOutputBean.getIwssnKktikwsrate(), null, "（ＩＷＳＳＮ）確定為替レート");
        exStringEquals(infoOutputBean.getIwssnKnsnkijyunymd(), null, "（ＩＷＳＳＮ）換算基準日");
        exStringEquals(infoOutputBean.getIwssnYykknmnryymd(), null, "（ＩＷＳＳＮ）猶予期間満了日");

    }

    @Test
    @TestOrder(70)
    public void testEditTBL_A7() {

        C_IwssnKykSyoukaiKekkaKbn syoriKekkaKbn = keiyakuInfo.exec("99806034791");
        IwssnSyanaiAnsyuInfoOutputBean infoOutputBean = keiyakuInfo.getIwssnSyanaiAnsyuInfoOutputBean();

        exClassificationEquals(syoriKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.NORMAL, "処理結果区分");
        exStringEquals(infoOutputBean.getIwssnHeijyunjkipjytym(), null, "（ＩＷＳＳＮ）平準払次回Ｐ充当年月");
        exStringEquals(infoOutputBean.getIwssnHeijyunanjoannaiym1(), null, "（ＩＷＳＳＮ）平準払案内状況案内月１");
        exStringEquals(infoOutputBean.getIwssnHeijyunanjoannaiym2(), null, "（ＩＷＳＳＮ）平準払案内状況案内月２");
        exStringEquals(infoOutputBean.getIwssnHeijyunanjoannaiym3(), null, "（ＩＷＳＳＮ）平準払案内状況案内月３");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijytym1(), null, "（ＩＷＳＳＮ）平準払案内状況案内充当年月１");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijytym2(), null, "（ＩＷＳＳＮ）平準払案内状況案内充当年月２");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijytym3(), null, "（ＩＷＳＳＮ）平準払案内状況案内充当年月３");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbn1(), null, "（ＩＷＳＳＮ）平準払案内状況案内状況区分１");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbn2(), null, "（ＩＷＳＳＮ）平準払案内状況案内状況区分２");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbn3(), null, "（ＩＷＳＳＮ）平準払案内状況案内状況区分３");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbnnm1(), null, "（ＩＷＳＳＮ）平準払案内状況案内状況区分（区分名称）１");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbnnm2(), null, "（ＩＷＳＳＮ）平準払案内状況案内状況区分（区分名称）２");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbnnm3(), null, "（ＩＷＳＳＮ）平準払案内状況案内状況区分（区分名称）３");
        exStringEquals(infoOutputBean.getIwssnHijynannaijytkaisuuy(), null, "（ＩＷＳＳＮ）平準払案内充当回数（年）（預振口座案内情報）");
        exStringEquals(infoOutputBean.getIwssnHijynannaijytkaisuum(), null, "（ＩＷＳＳＮ）平準払案内充当回数（月）（預振口座案内情報）");
        exStringEquals(infoOutputBean.getIwssnHeijyunannaigk(), null, "（ＩＷＳＳＮ）平準払案内金額（預振口座案内情報）");
        exStringEquals(infoOutputBean.getIwssnTeikiikkatubaraijkkbn(), null, "（ＩＷＳＳＮ）定期一括払状況区分");
        exStringEquals(infoOutputBean.getIwssnTikiktbrjkkbnnm(), null, "（ＩＷＳＳＮ）定期一括払状況（区分名称）");
        exStringEquals(infoOutputBean.getIwssnHrkkeirokbn(), "6", "（ＩＷＳＳＮ）払込経路区分");
        exStringEquals(infoOutputBean.getIwssnHrkkeirokbnnm(), "クレジットカード扱い", "（ＩＷＳＳＮ）払込経路（区分名称）");
        exStringEquals(infoOutputBean.getIwssnHrkkaisuukbn(), "12", "（ＩＷＳＳＮ）払込回数区分");
        exStringEquals(infoOutputBean.getIwssnHrkkaisuukbnnm(), "年１回払", "（ＩＷＳＳＮ）払込回数（区分名称）");
        exStringEquals(infoOutputBean.getIwssnHrkp(), null, "（ＩＷＳＳＮ）払込保険料");
        exStringEquals(infoOutputBean.getIwssnHrkptuukasyu(), null, "（ＩＷＳＳＮ）払込保険料（通貨種類）");
        exStringEquals(infoOutputBean.getIwssnDattairiyuukbn(), null, "（ＩＷＳＳＮ）脱退理由区分");
        exStringEquals(infoOutputBean.getIwssnDattairiyuukbnnm(), null, "（ＩＷＳＳＮ）脱退理由（区分名称）");
        exStringEquals(infoOutputBean.getIwssnYfrjkouzano(), null, "（ＩＷＳＳＮ）預振情報口座番号");
        exStringEquals(infoOutputBean.getIwssnYfrjkzmeigikn(), null, "（ＩＷＳＳＮ）預振情報口座名義人（カナ）");
        exStringEquals(infoOutputBean.getIwssnYfrjbanknm(), null, "（ＩＷＳＳＮ）預振情報銀行名称");
        exStringEquals(infoOutputBean.getIwssnYfrjsitennm(), null, "（ＩＷＳＳＮ）預振情報支店名称");
        exStringEquals(infoOutputBean.getIwssnYfrjyokinkbnnm(), null, "（ＩＷＳＳＮ）預振情報預金種目（区分名称）");
        exStringEquals(infoOutputBean.getIwssnYfrjbankcd(), null, "（ＩＷＳＳＮ）預振情報銀行コード");
        exStringEquals(infoOutputBean.getIwssnYfrjsitencd(), null, "（ＩＷＳＳＮ）預振情報支店コード");
        exStringEquals(infoOutputBean.getIwssnYfrjyokinkbn(), null, "（ＩＷＳＳＮ）預振情報預金種目区分");
        exStringEquals(infoOutputBean.getIwssnDattaisyoriymd(), null, "（ＩＷＳＳＮ）脱退処理日");
        exStringEquals(infoOutputBean.getIwssnDtjcomment(), null, "（ＩＷＳＳＮ）脱退情報コメント");
        exStringEquals(infoOutputBean.getIwssnHeijyunannaiym(), null, "（ＩＷＳＳＮ）平準払案内月");
        exStringEquals(infoOutputBean.getIwssnHeijyunannaijyutouym(), null, "（ＩＷＳＳＮ）平準払案内充当年月");
        exStringEquals(infoOutputBean.getIwssnCreyuukoukakkekka(), null, "（ＩＷＳＳＮ）クレジットカード有効確認結果");
        exStringEquals(infoOutputBean.getIwssnCreyuukoukakkekkakbnnm(), null, "（ＩＷＳＳＮ）クレジットカード有効確認結果（区分名称）");
        exStringEquals(infoOutputBean.getIwssnCredityuukoukakym(), null, "（ＩＷＳＳＮ）クレジットカード有効確認年月");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbn1(), null, "（ＩＷＳＳＮ）売上請求ＮＧ事由区分１");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbn2(), null, "（ＩＷＳＳＮ）売上請求ＮＧ事由区分２");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbn3(), null, "（ＩＷＳＳＮ）売上請求ＮＧ事由区分３");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbnnm1(), null, "（ＩＷＳＳＮ）売上請求ＮＧ事由区分（区分名称）１");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbnnm2(), null, "（ＩＷＳＳＮ）売上請求ＮＧ事由区分（区分名称）２");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbnnm3(), null, "（ＩＷＳＳＮ）売上請求ＮＧ事由区分（区分名称）３");
        exStringEquals(infoOutputBean.getIwssnYenkansanp(), null, "（ＩＷＳＳＮ）円換算保険料");
        exStringEquals(infoOutputBean.getIwssnYenkansanptuukasyu(), null, "（ＩＷＳＳＮ）円換算保険料（通貨種類）");
        exStringEquals(infoOutputBean.getIwssnKktikwsrate(), null, "（ＩＷＳＳＮ）確定為替レート");
        exStringEquals(infoOutputBean.getIwssnKnsnkijyunymd(), null, "（ＩＷＳＳＮ）換算基準日");
        exStringEquals(infoOutputBean.getIwssnYykknmnryymd(), null, "（ＩＷＳＳＮ）猶予期間満了日");

    }

    @Test
    @TestOrder(80)
    public void testEditTBL_A8() {

        C_IwssnKykSyoukaiKekkaKbn syoriKekkaKbn = keiyakuInfo.exec("99806001113");
        IwssnSyanaiAnsyuInfoOutputBean infoOutputBean = keiyakuInfo.getIwssnSyanaiAnsyuInfoOutputBean();

        exClassificationEquals(syoriKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.EXCEPTION, "処理結果区分");
        exStringEquals(infoOutputBean.getIwssnHeijyunjkipjytym(), null, "（ＩＷＳＳＮ）平準払次回Ｐ充当年月");
        exStringEquals(infoOutputBean.getIwssnHeijyunanjoannaiym1(), null, "（ＩＷＳＳＮ）平準払案内状況案内月１");
        exStringEquals(infoOutputBean.getIwssnHeijyunanjoannaiym2(), null, "（ＩＷＳＳＮ）平準払案内状況案内月２");
        exStringEquals(infoOutputBean.getIwssnHeijyunanjoannaiym3(), null, "（ＩＷＳＳＮ）平準払案内状況案内月３");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijytym1(), null, "（ＩＷＳＳＮ）平準払案内状況案内充当年月１");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijytym2(), null, "（ＩＷＳＳＮ）平準払案内状況案内充当年月２");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijytym3(), null, "（ＩＷＳＳＮ）平準払案内状況案内充当年月３");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbn1(), null, "（ＩＷＳＳＮ）平準払案内状況案内状況区分１");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbn2(), null, "（ＩＷＳＳＮ）平準払案内状況案内状況区分２");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbn3(), null, "（ＩＷＳＳＮ）平準払案内状況案内状況区分３");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbnnm1(), null, "（ＩＷＳＳＮ）平準払案内状況案内状況区分（区分名称）１");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbnnm2(), null, "（ＩＷＳＳＮ）平準払案内状況案内状況区分（区分名称）２");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbnnm3(), null, "（ＩＷＳＳＮ）平準払案内状況案内状況区分（区分名称）３");
        exStringEquals(infoOutputBean.getIwssnHijynannaijytkaisuuy(), null, "（ＩＷＳＳＮ）平準払案内充当回数（年）（預振口座案内情報）");
        exStringEquals(infoOutputBean.getIwssnHijynannaijytkaisuum(), null, "（ＩＷＳＳＮ）平準払案内充当回数（月）（預振口座案内情報）");
        exStringEquals(infoOutputBean.getIwssnHeijyunannaigk(), null, "（ＩＷＳＳＮ）平準払案内金額（預振口座案内情報）");
        exStringEquals(infoOutputBean.getIwssnTeikiikkatubaraijkkbn(), null, "（ＩＷＳＳＮ）定期一括払状況区分");
        exStringEquals(infoOutputBean.getIwssnTikiktbrjkkbnnm(), null, "（ＩＷＳＳＮ）定期一括払状況（区分名称）");
        exStringEquals(infoOutputBean.getIwssnHrkkeirokbn(), null, "（ＩＷＳＳＮ）払込経路区分");
        exStringEquals(infoOutputBean.getIwssnHrkkeirokbnnm(), null, "（ＩＷＳＳＮ）払込経路（区分名称）");
        exStringEquals(infoOutputBean.getIwssnHrkkaisuukbn(), null, "（ＩＷＳＳＮ）払込回数区分");
        exStringEquals(infoOutputBean.getIwssnHrkkaisuukbnnm(), null, "（ＩＷＳＳＮ）払込回数（区分名称）");
        exStringEquals(infoOutputBean.getIwssnHrkp(), null, "（ＩＷＳＳＮ）払込保険料");
        exStringEquals(infoOutputBean.getIwssnHrkptuukasyu(), null, "（ＩＷＳＳＮ）払込保険料（通貨種類）");
        exStringEquals(infoOutputBean.getIwssnDattairiyuukbn(), null, "（ＩＷＳＳＮ）脱退理由区分");
        exStringEquals(infoOutputBean.getIwssnDattairiyuukbnnm(), null, "（ＩＷＳＳＮ）脱退理由（区分名称）");
        exStringEquals(infoOutputBean.getIwssnYfrjkouzano(), null, "（ＩＷＳＳＮ）預振情報口座番号");
        exStringEquals(infoOutputBean.getIwssnYfrjkzmeigikn(), null, "（ＩＷＳＳＮ）預振情報口座名義人（カナ）");
        exStringEquals(infoOutputBean.getIwssnYfrjbanknm(), null, "（ＩＷＳＳＮ）預振情報銀行名称");
        exStringEquals(infoOutputBean.getIwssnYfrjsitennm(), null, "（ＩＷＳＳＮ）預振情報支店名称");
        exStringEquals(infoOutputBean.getIwssnYfrjyokinkbnnm(), null, "（ＩＷＳＳＮ）預振情報預金種目（区分名称）");
        exStringEquals(infoOutputBean.getIwssnYfrjbankcd(), null, "（ＩＷＳＳＮ）預振情報銀行コード");
        exStringEquals(infoOutputBean.getIwssnYfrjsitencd(), null, "（ＩＷＳＳＮ）預振情報支店コード");
        exStringEquals(infoOutputBean.getIwssnYfrjyokinkbn(), null, "（ＩＷＳＳＮ）預振情報預金種目区分");
        exStringEquals(infoOutputBean.getIwssnDattaisyoriymd(), null, "（ＩＷＳＳＮ）脱退処理日");
        exStringEquals(infoOutputBean.getIwssnDtjcomment(), null, "（ＩＷＳＳＮ）脱退情報コメント");
        exStringEquals(infoOutputBean.getIwssnHeijyunannaiym(), null, "（ＩＷＳＳＮ）平準払案内月");
        exStringEquals(infoOutputBean.getIwssnHeijyunannaijyutouym(), null, "（ＩＷＳＳＮ）平準払案内充当年月");
        exStringEquals(infoOutputBean.getIwssnCreyuukoukakkekka(), null, "（ＩＷＳＳＮ）クレジットカード有効確認結果");
        exStringEquals(infoOutputBean.getIwssnCreyuukoukakkekkakbnnm(), null, "（ＩＷＳＳＮ）クレジットカード有効確認結果（区分名称）");
        exStringEquals(infoOutputBean.getIwssnCredityuukoukakym(), null, "（ＩＷＳＳＮ）クレジットカード有効確認年月");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbn1(), null, "（ＩＷＳＳＮ）売上請求ＮＧ事由区分１");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbn2(), null, "（ＩＷＳＳＮ）売上請求ＮＧ事由区分２");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbn3(), null, "（ＩＷＳＳＮ）売上請求ＮＧ事由区分３");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbnnm1(), null, "（ＩＷＳＳＮ）売上請求ＮＧ事由区分（区分名称）１");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbnnm2(), null, "（ＩＷＳＳＮ）売上請求ＮＧ事由区分（区分名称）２");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbnnm3(), null, "（ＩＷＳＳＮ）売上請求ＮＧ事由区分（区分名称）３");
        exStringEquals(infoOutputBean.getIwssnYenkansanp(), null, "（ＩＷＳＳＮ）円換算保険料");
        exStringEquals(infoOutputBean.getIwssnYenkansanptuukasyu(), null, "（ＩＷＳＳＮ）円換算保険料（通貨種類）");
        exStringEquals(infoOutputBean.getIwssnKktikwsrate(), null, "（ＩＷＳＳＮ）確定為替レート");
        exStringEquals(infoOutputBean.getIwssnKnsnkijyunymd(), null, "（ＩＷＳＳＮ）換算基準日");
        exStringEquals(infoOutputBean.getIwssnYykknmnryymd(), null, "（ＩＷＳＳＮ）猶予期間満了日");

    }

    @Test
    @TestOrder(90)
    public void testEditTBL_A9() {

        C_IwssnKykSyoukaiKekkaKbn syoriKekkaKbn = keiyakuInfo.exec("17806000013");
        IwssnSyanaiAnsyuInfoOutputBean infoOutputBean = keiyakuInfo.getIwssnSyanaiAnsyuInfoOutputBean();

        exClassificationEquals(syoriKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.NORMAL, "処理結果区分");
        exStringEquals(infoOutputBean.getIwssnHeijyunjkipjytym(), "201901", "（ＩＷＳＳＮ）平準払次回Ｐ充当年月");
        exStringEquals(infoOutputBean.getIwssnHeijyunanjoannaiym1(), "202005", "（ＩＷＳＳＮ）平準払案内状況案内月１");
        exStringEquals(infoOutputBean.getIwssnHeijyunanjoannaiym2(), "202005", "（ＩＷＳＳＮ）平準払案内状況案内月２");
        exStringEquals(infoOutputBean.getIwssnHeijyunanjoannaiym3(), "202005", "（ＩＷＳＳＮ）平準払案内状況案内月３");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijytym1(), "201906", "（ＩＷＳＳＮ）平準払案内状況案内充当年月１");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijytym2(), "201907", "（ＩＷＳＳＮ）平準払案内状況案内充当年月２");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijytym3(), "201908", "（ＩＷＳＳＮ）平準払案内状況案内充当年月３");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbn1(), "0", "（ＩＷＳＳＮ）平準払案内状況案内状況区分１");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbn2(), "1", "（ＩＷＳＳＮ）平準払案内状況案内状況区分２");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbn3(), "2", "（ＩＷＳＳＮ）平準払案内状況案内状況区分３");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbnnm1(), "　", "（ＩＷＳＳＮ）平準払案内状況案内状況区分（区分名称）１");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbnnm2(), "案内中", "（ＩＷＳＳＮ）平準払案内状況案内状況区分（区分名称）２");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbnnm3(), "入金", "（ＩＷＳＳＮ）平準払案内状況案内状況区分（区分名称）３");
        exStringEquals(infoOutputBean.getIwssnHijynannaijytkaisuuy(), "0", "（ＩＷＳＳＮ）平準払案内充当回数（年）（預振口座案内情報）");
        exStringEquals(infoOutputBean.getIwssnHijynannaijytkaisuum(), "6", "（ＩＷＳＳＮ）平準払案内充当回数（月）（預振口座案内情報）");
        exStringEquals(infoOutputBean.getIwssnHeijyunannaigk(), "60000", "（ＩＷＳＳＮ）平準払案内金額（預振口座案内情報）");
        exStringEquals(infoOutputBean.getIwssnTeikiikkatubaraijkkbn(), "0", "（ＩＷＳＳＮ）定期一括払状況区分");
        exStringEquals(infoOutputBean.getIwssnTikiktbrjkkbnnm(), "　", "（ＩＷＳＳＮ）定期一括払状況（区分名称）");
        exStringEquals(infoOutputBean.getIwssnHrkkaisuukbn(), "1", "（ＩＷＳＳＮ）払込回数区分");
        exStringEquals(infoOutputBean.getIwssnHrkkaisuukbnnm(), "月払", "（ＩＷＳＳＮ）払込回数（区分名称）");
        exStringEquals(infoOutputBean.getIwssnHrkkeirokbn(), "0", "（ＩＷＳＳＮ）払込経路区分");
        exStringEquals(infoOutputBean.getIwssnHrkkeirokbnnm(), "　", "（ＩＷＳＳＮ）払込経路（区分名称）");
        exStringEquals(infoOutputBean.getIwssnHrkp(), "10000007", "（ＩＷＳＳＮ）払込保険料");
        exStringEquals(infoOutputBean.getIwssnHrkptuukasyu(), "YEN", "（ＩＷＳＳＮ）払込保険料（通貨種類）");
        exStringEquals(infoOutputBean.getIwssnDattairiyuukbn(), "0", "（ＩＷＳＳＮ）脱退理由区分");
        exStringEquals(infoOutputBean.getIwssnDattairiyuukbnnm(), "　", "（ＩＷＳＳＮ）脱退理由（区分名称）");
        exStringEquals(infoOutputBean.getIwssnYfrjkouzano(), "2323232101", "（ＩＷＳＳＮ）預振情報口座番号");
        exStringEquals(infoOutputBean.getIwssnYfrjkzmeigikn(), "ﾕﾋﾒｲ ﾅﾅｲﾁｶ", "（ＩＷＳＳＮ）預振情報口座名義人（カナ）");
        exStringEquals(infoOutputBean.getIwssnYfrjbanknm(), "銀行名（漢字）", "（ＩＷＳＳＮ）預振情報銀行名称");
        exStringEquals(infoOutputBean.getIwssnYfrjsitennm(), "支店名（漢字）", "（ＩＷＳＳＮ）預振情報支店名称");
        exStringEquals(infoOutputBean.getIwssnYfrjyokinkbnnm(), "　", "（ＩＷＳＳＮ）預振情報預金種目（区分名称）");
        exStringEquals(infoOutputBean.getIwssnYfrjbankcd(), "0018", "（ＩＷＳＳＮ）預振情報銀行コード");
        exStringEquals(infoOutputBean.getIwssnYfrjsitencd(), "001", "（ＩＷＳＳＮ）預振情報支店コード");
        exStringEquals(infoOutputBean.getIwssnYfrjyokinkbn(), "0", "（ＩＷＳＳＮ）預振情報預金種目区分");
        exStringEquals(infoOutputBean.getIwssnDattaisyoriymd(), "20200525", "（ＩＷＳＳＮ）脱退処理日");
        exStringEquals(infoOutputBean.getIwssnDtjcomment(), null, "（ＩＷＳＳＮ）脱退情報コメント");
        exStringEquals(infoOutputBean.getIwssnHeijyunannaiym(), "202005", "（ＩＷＳＳＮ）平準払案内月");
        exStringEquals(infoOutputBean.getIwssnHeijyunannaijyutouym(), "201906", "（ＩＷＳＳＮ）平準払案内充当年月");
        exStringEquals(infoOutputBean.getIwssnCreyuukoukakkekka(), "3", "（ＩＷＳＳＮ）クレジットカード有効確認結果");
        exStringEquals(infoOutputBean.getIwssnCreyuukoukakkekkakbnnm(),"照合エラー", "（ＩＷＳＳＮ）クレジットカード有効確認結果（区分名称）");
        exStringEquals(infoOutputBean.getIwssnCredityuukoukakym(), "201902", "（ＩＷＳＳＮ）クレジットカード有効確認年月");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbn1(), "1", "（ＩＷＳＳＮ）売上請求ＮＧ事由区分１");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbn2(), "2", "（ＩＷＳＳＮ）売上請求ＮＧ事由区分２");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbn3(), "0", "（ＩＷＳＳＮ）売上請求ＮＧ事由区分３");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbnnm1(), "限度額超過", "（ＩＷＳＳＮ）売上請求ＮＧ事由区分（区分名称）１");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbnnm2(), "売上処理未完了", "（ＩＷＳＳＮ）売上請求ＮＧ事由区分（区分名称）２");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbnnm3(), "　", "（ＩＷＳＳＮ）売上請求ＮＧ事由区分（区分名称）３");
        exStringEquals(infoOutputBean.getIwssnYenkansanp(), null, "（ＩＷＳＳＮ）円換算保険料");
        exStringEquals(infoOutputBean.getIwssnYenkansanptuukasyu(), null, "（ＩＷＳＳＮ）円換算保険料（通貨種類）");
        exStringEquals(infoOutputBean.getIwssnKktikwsrate(), null, "（ＩＷＳＳＮ）確定為替レート");
        exStringEquals(infoOutputBean.getIwssnKnsnkijyunymd(), null, "（ＩＷＳＳＮ）換算基準日");
        exStringEquals(infoOutputBean.getIwssnYykknmnryymd(), null, "（ＩＷＳＳＮ）猶予期間満了日");

    }


    @Test
    @TestOrder(100)
    public void testEditTBL_A10() {

        C_IwssnKykSyoukaiKekkaKbn syoriKekkaKbn = keiyakuInfo.exec("17806000024");
        IwssnSyanaiAnsyuInfoOutputBean infoOutputBean = keiyakuInfo.getIwssnSyanaiAnsyuInfoOutputBean();

        exClassificationEquals(syoriKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.NORMAL, "処理結果区分");
        exStringEquals(infoOutputBean.getIwssnHeijyunjkipjytym(), "201901", "（ＩＷＳＳＮ）平準払次回Ｐ充当年月");
        exStringEquals(infoOutputBean.getIwssnHeijyunanjoannaiym1(), "202005", "（ＩＷＳＳＮ）平準払案内状況案内月１");
        exStringEquals(infoOutputBean.getIwssnHeijyunanjoannaiym2(), "202005", "（ＩＷＳＳＮ）平準払案内状況案内月２");
        exStringEquals(infoOutputBean.getIwssnHeijyunanjoannaiym3(), "202005", "（ＩＷＳＳＮ）平準払案内状況案内月３");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijytym1(), "201906", "（ＩＷＳＳＮ）平準払案内状況案内充当年月１");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijytym2(), "201907", "（ＩＷＳＳＮ）平準払案内状況案内充当年月２");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijytym3(), "201908", "（ＩＷＳＳＮ）平準払案内状況案内充当年月３");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbn1(), "1", "（ＩＷＳＳＮ）平準払案内状況案内状況区分１");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbn2(), "0", "（ＩＷＳＳＮ）平準払案内状況案内状況区分２");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbn3(), "2", "（ＩＷＳＳＮ）平準払案内状況案内状況区分３");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbnnm1(), "案内中", "（ＩＷＳＳＮ）平準払案内状況案内状況区分（区分名称）１");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbnnm2(), "　", "（ＩＷＳＳＮ）平準払案内状況案内状況区分（区分名称）２");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbnnm3(), "入金", "（ＩＷＳＳＮ）平準払案内状況案内状況区分（区分名称）３");
        exStringEquals(infoOutputBean.getIwssnHijynannaijytkaisuuy(), "0", "（ＩＷＳＳＮ）平準払案内充当回数（年）（預振口座案内情報）");
        exStringEquals(infoOutputBean.getIwssnHijynannaijytkaisuum(), "6", "（ＩＷＳＳＮ）平準払案内充当回数（月）（預振口座案内情報）");
        exStringEquals(infoOutputBean.getIwssnHeijyunannaigk(), "60000", "（ＩＷＳＳＮ）平準払案内金額（預振口座案内情報）");
        exStringEquals(infoOutputBean.getIwssnTeikiikkatubaraijkkbn(), "6", "（ＩＷＳＳＮ）定期一括払状況区分");
        exStringEquals(infoOutputBean.getIwssnTikiktbrjkkbnnm(), "６か月定期一括", "（ＩＷＳＳＮ）定期一括払状況（区分名称）");
        exStringEquals(infoOutputBean.getIwssnHrkkaisuukbn(), "0", "（ＩＷＳＳＮ）払込回数区分");
        exStringEquals(infoOutputBean.getIwssnHrkkaisuukbnnm(), "　", "（ＩＷＳＳＮ）払込回数（区分名称）");
        exStringEquals(infoOutputBean.getIwssnHrkkeirokbn(), "4", "（ＩＷＳＳＮ）払込経路区分");
        exStringEquals(infoOutputBean.getIwssnHrkkeirokbnnm(), "振替", "（ＩＷＳＳＮ）払込経路（区分名称）");
        exStringEquals(infoOutputBean.getIwssnHrkp(), "10000007", "（ＩＷＳＳＮ）払込保険料");
        exStringEquals(infoOutputBean.getIwssnHrkptuukasyu(), "YEN", "（ＩＷＳＳＮ）払込保険料（通貨種類）");
        exStringEquals(infoOutputBean.getIwssnDattairiyuukbn(), "1", "（ＩＷＳＳＮ）脱退理由区分");
        exStringEquals(infoOutputBean.getIwssnDattairiyuukbnnm(), "払変希望", "（ＩＷＳＳＮ）脱退理由（区分名称）");
        exStringEquals(infoOutputBean.getIwssnYfrjkouzano(), "2323232", "（ＩＷＳＳＮ）預振情報口座番号");
        exStringEquals(infoOutputBean.getIwssnYfrjkzmeigikn(), "ﾕﾋﾒｲ ﾅﾅｲﾁｶ", "（ＩＷＳＳＮ）預振情報口座名義人（カナ）");
        exStringEquals(infoOutputBean.getIwssnYfrjbanknm(), "ゆうちょ銀行", "（ＩＷＳＳＮ）預振情報銀行名称");
        exStringEquals(infoOutputBean.getIwssnYfrjsitennm(), "１００１０", "（ＩＷＳＳＮ）預振情報支店名称");
        exStringEquals(infoOutputBean.getIwssnYfrjyokinkbnnm(), "　", "（ＩＷＳＳＮ）預振情報預金種目（区分名称）");
        exStringEquals(infoOutputBean.getIwssnYfrjbankcd(), "9900", "（ＩＷＳＳＮ）預振情報銀行コード");
        exStringEquals(infoOutputBean.getIwssnYfrjsitencd(), "001", "（ＩＷＳＳＮ）預振情報支店コード");
        exStringEquals(infoOutputBean.getIwssnYfrjyokinkbn(), " ", "（ＩＷＳＳＮ）預振情報預金種目区分");
        exStringEquals(infoOutputBean.getIwssnDattaisyoriymd(), "20200525", "（ＩＷＳＳＮ）脱退処理日");
        exStringEquals(infoOutputBean.getIwssnDtjcomment(), null, "（ＩＷＳＳＮ）脱退情報コメント");
        exStringEquals(infoOutputBean.getIwssnHeijyunannaiym(), "202005", "（ＩＷＳＳＮ）平準払案内月");
        exStringEquals(infoOutputBean.getIwssnHeijyunannaijyutouym(), "201906", "（ＩＷＳＳＮ）平準払案内充当年月");
        exStringEquals(infoOutputBean.getIwssnCreyuukoukakkekka(), "0", "（ＩＷＳＳＮ）クレジットカード有効確認結果");
        exStringEquals(infoOutputBean.getIwssnCreyuukoukakkekkakbnnm(),"　", "（ＩＷＳＳＮ）クレジットカード有効確認結果（区分名称）");
        exStringEquals(infoOutputBean.getIwssnCredityuukoukakym(), "201903", "（ＩＷＳＳＮ）クレジットカード有効確認年月");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbn1(), "0", "（ＩＷＳＳＮ）売上請求ＮＧ事由区分１");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbn2(), "2", "（ＩＷＳＳＮ）売上請求ＮＧ事由区分２");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbn3(), "1", "（ＩＷＳＳＮ）売上請求ＮＧ事由区分３");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbnnm1(), "　", "（ＩＷＳＳＮ）売上請求ＮＧ事由区分（区分名称）１");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbnnm2(), "売上処理未完了", "（ＩＷＳＳＮ）売上請求ＮＧ事由区分（区分名称）２");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbnnm3(), "限度額超過", "（ＩＷＳＳＮ）売上請求ＮＧ事由区分（区分名称）３");
        exStringEquals(infoOutputBean.getIwssnYenkansanp(), null, "（ＩＷＳＳＮ）円換算保険料");
        exStringEquals(infoOutputBean.getIwssnYenkansanptuukasyu(), null, "（ＩＷＳＳＮ）円換算保険料（通貨種類）");
        exStringEquals(infoOutputBean.getIwssnKktikwsrate(), null, "（ＩＷＳＳＮ）確定為替レート");
        exStringEquals(infoOutputBean.getIwssnKnsnkijyunymd(), null, "（ＩＷＳＳＮ）換算基準日");
        exStringEquals(infoOutputBean.getIwssnYykknmnryymd(), null, "（ＩＷＳＳＮ）猶予期間満了日");

    }

    @Test
    @TestOrder(110)
    public void testEditTBL_A11() {

        changeSystemDate(BizDate.valueOf(20210128));
        C_IwssnKykSyoukaiKekkaKbn syoriKekkaKbn = keiyakuInfo.exec("99806001010");
        IwssnSyanaiAnsyuInfoOutputBean infoOutputBean = keiyakuInfo.getIwssnSyanaiAnsyuInfoOutputBean();

        exClassificationEquals(syoriKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.NORMAL, "処理結果区分");
        exStringEquals(infoOutputBean.getIwssnHeijyunjkipjytym(), "201901", "（ＩＷＳＳＮ）平準払次回Ｐ充当年月");
        exStringEquals(infoOutputBean.getIwssnHeijyunanjoannaiym1(), "202005", "（ＩＷＳＳＮ）平準払案内状況案内月１");
        exStringEquals(infoOutputBean.getIwssnHeijyunanjoannaiym2(), "202005", "（ＩＷＳＳＮ）平準払案内状況案内月２");
        exStringEquals(infoOutputBean.getIwssnHeijyunanjoannaiym3(), "202005", "（ＩＷＳＳＮ）平準払案内状況案内月３");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijytym1(), "201906", "（ＩＷＳＳＮ）平準払案内状況案内充当年月１");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijytym2(), "201907", "（ＩＷＳＳＮ）平準払案内状況案内充当年月２");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijytym3(), "201908", "（ＩＷＳＳＮ）平準払案内状況案内充当年月３");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbn1(), "1", "（ＩＷＳＳＮ）平準払案内状況案内状況区分１");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbn2(), "2", "（ＩＷＳＳＮ）平準払案内状況案内状況区分２");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbn3(), "3", "（ＩＷＳＳＮ）平準払案内状況案内状況区分３");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbnnm1(), "案内中", "（ＩＷＳＳＮ）平準払案内状況案内状況区分（区分名称）１");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbnnm2(), "入金", "（ＩＷＳＳＮ）平準払案内状況案内状況区分（区分名称）２");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbnnm3(), "未入", "（ＩＷＳＳＮ）平準払案内状況案内状況区分（区分名称）３");
        exStringEquals(infoOutputBean.getIwssnHijynannaijytkaisuuy(), "0", "（ＩＷＳＳＮ）平準払案内充当回数（年）（預振口座案内情報）");
        exStringEquals(infoOutputBean.getIwssnHijynannaijytkaisuum(), "6", "（ＩＷＳＳＮ）平準払案内充当回数（月）（預振口座案内情報）");
        exStringEquals(infoOutputBean.getIwssnHeijyunannaigk(), "60000", "（ＩＷＳＳＮ）平準払案内金額（預振口座案内情報）");
        exStringEquals(infoOutputBean.getIwssnTeikiikkatubaraijkkbn(), null, "（ＩＷＳＳＮ）定期一括払状況区分");
        exStringEquals(infoOutputBean.getIwssnTikiktbrjkkbnnm(), null, "（ＩＷＳＳＮ）定期一括払状況（区分名称）");
        exStringEquals(infoOutputBean.getIwssnHrkkaisuukbn(), "12", "（ＩＷＳＳＮ）払込回数区分");
        exStringEquals(infoOutputBean.getIwssnHrkkaisuukbnnm(), "年１回払", "（ＩＷＳＳＮ）払込回数（区分名称）");
        exStringEquals(infoOutputBean.getIwssnHrkkeirokbnnm(), "クレジットカード扱い", "（ＩＷＳＳＮ）払込経路（区分名称）");
        exStringEquals(infoOutputBean.getIwssnHrkkeirokbn(), "6", "（ＩＷＳＳＮ）払込経路区分");
        exStringEquals(infoOutputBean.getIwssnHrkp(), "10000007", "（ＩＷＳＳＮ）払込保険料");
        exStringEquals(infoOutputBean.getIwssnHrkptuukasyu(), "YEN", "（ＩＷＳＳＮ）払込保険料（通貨種類）");
        exStringEquals(infoOutputBean.getIwssnDattairiyuukbn(), "1", "（ＩＷＳＳＮ）脱退理由区分");
        exStringEquals(infoOutputBean.getIwssnDattairiyuukbnnm(), "払変希望", "（ＩＷＳＳＮ）脱退理由（区分名称）");
        exStringEquals(infoOutputBean.getIwssnYfrjkouzano(), "2323232101", "（ＩＷＳＳＮ）預振情報口座番号");
        exStringEquals(infoOutputBean.getIwssnYfrjkzmeigikn(), "ﾕﾋﾒｲ ﾅﾅｲﾁｶ", "（ＩＷＳＳＮ）預振情報口座名義人（カナ）");
        exStringEquals(infoOutputBean.getIwssnYfrjbanknm(), "銀行名（漢字）", "（ＩＷＳＳＮ）預振情報銀行名称");
        exStringEquals(infoOutputBean.getIwssnYfrjsitennm(), "支店名（漢字）", "（ＩＷＳＳＮ）預振情報支店名称");
        exStringEquals(infoOutputBean.getIwssnYfrjyokinkbnnm(), "普通", "（ＩＷＳＳＮ）預振情報預金種目（区分名称）");
        exStringEquals(infoOutputBean.getIwssnYfrjbankcd(), "0018", "（ＩＷＳＳＮ）預振情報銀行コード");
        exStringEquals(infoOutputBean.getIwssnYfrjsitencd(), "001", "（ＩＷＳＳＮ）預振情報支店コード");
        exStringEquals(infoOutputBean.getIwssnYfrjyokinkbn(), "1", "（ＩＷＳＳＮ）預振情報預金種目区分");
        exStringEquals(infoOutputBean.getIwssnDattaisyoriymd(), "20200525", "（ＩＷＳＳＮ）脱退処理日");
        exStringEquals(infoOutputBean.getIwssnDtjcomment(), null, "（ＩＷＳＳＮ）脱退情報コメント");
        exStringEquals(infoOutputBean.getIwssnHeijyunannaiym(), "202005", "（ＩＷＳＳＮ）平準払案内月");
        exStringEquals(infoOutputBean.getIwssnHeijyunannaijyutouym(), "201906", "（ＩＷＳＳＮ）平準払案内充当年月");
        exStringEquals(infoOutputBean.getIwssnCreyuukoukakkekka(), null, "（ＩＷＳＳＮ）クレジットカード有効確認結果");
        exStringEquals(infoOutputBean.getIwssnCreyuukoukakkekkakbnnm(), null, "（ＩＷＳＳＮ）クレジットカード有効確認結果（区分名称）");
        exStringEquals(infoOutputBean.getIwssnCredityuukoukakym(), null, "（ＩＷＳＳＮ）クレジットカード有効確認年月");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbn1(), null, "（ＩＷＳＳＮ）売上請求ＮＧ事由区分１");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbn2(), null, "（ＩＷＳＳＮ）売上請求ＮＧ事由区分２");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbn3(), null, "（ＩＷＳＳＮ）売上請求ＮＧ事由区分３");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbnnm1(), null, "（ＩＷＳＳＮ）売上請求ＮＧ事由区分（区分名称）１");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbnnm2(), null, "（ＩＷＳＳＮ）売上請求ＮＧ事由区分（区分名称）２");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbnnm3(), null, "（ＩＷＳＳＮ）売上請求ＮＧ事由区分（区分名称）３");
        exStringEquals(infoOutputBean.getIwssnYenkansanp(), "62275000", "（ＩＷＳＳＮ）円換算保険料");
        exStringEquals(infoOutputBean.getIwssnYenkansanptuukasyu(), "YEN", "（ＩＷＳＳＮ）円換算保険料（通貨種類）");
        exStringEquals(infoOutputBean.getIwssnKktikwsrate(), "124.55", "（ＩＷＳＳＮ）確定為替レート");
        exStringEquals(infoOutputBean.getIwssnKnsnkijyunymd(), "20201230", "（ＩＷＳＳＮ）換算基準日");
        exStringEquals(infoOutputBean.getIwssnYykknmnryymd(), "20190401", "（ＩＷＳＳＮ）猶予期間満了日");

    }

    @Test
    @TestOrder(120)
    public void testEditTBL_A12() {

        changeSystemDate(BizDate.valueOf(20210128));
        C_IwssnKykSyoukaiKekkaKbn syoriKekkaKbn = keiyakuInfo.exec("99806001021");
        IwssnSyanaiAnsyuInfoOutputBean infoOutputBean = keiyakuInfo.getIwssnSyanaiAnsyuInfoOutputBean();

        exClassificationEquals(syoriKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.NORMAL, "処理結果区分");
        exStringEquals(infoOutputBean.getIwssnHeijyunjkipjytym(), "201901", "（ＩＷＳＳＮ）平準払次回Ｐ充当年月");
        exStringEquals(infoOutputBean.getIwssnHeijyunanjoannaiym1(), "202005", "（ＩＷＳＳＮ）平準払案内状況案内月１");
        exStringEquals(infoOutputBean.getIwssnHeijyunanjoannaiym2(), "202005", "（ＩＷＳＳＮ）平準払案内状況案内月２");
        exStringEquals(infoOutputBean.getIwssnHeijyunanjoannaiym3(), "202005", "（ＩＷＳＳＮ）平準払案内状況案内月３");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijytym1(), "201906", "（ＩＷＳＳＮ）平準払案内状況案内充当年月１");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijytym2(), "201907", "（ＩＷＳＳＮ）平準払案内状況案内充当年月２");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijytym3(), "201908", "（ＩＷＳＳＮ）平準払案内状況案内充当年月３");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbn1(), "1", "（ＩＷＳＳＮ）平準払案内状況案内状況区分１");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbn2(), "2", "（ＩＷＳＳＮ）平準払案内状況案内状況区分２");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbn3(), "3", "（ＩＷＳＳＮ）平準払案内状況案内状況区分３");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbnnm1(), "案内中", "（ＩＷＳＳＮ）平準払案内状況案内状況区分（区分名称）１");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbnnm2(), "入金", "（ＩＷＳＳＮ）平準払案内状況案内状況区分（区分名称）２");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbnnm3(), "未入", "（ＩＷＳＳＮ）平準払案内状況案内状況区分（区分名称）３");
        exStringEquals(infoOutputBean.getIwssnHijynannaijytkaisuuy(), "0", "（ＩＷＳＳＮ）平準払案内充当回数（年）（預振口座案内情報）");
        exStringEquals(infoOutputBean.getIwssnHijynannaijytkaisuum(), "6", "（ＩＷＳＳＮ）平準払案内充当回数（月）（預振口座案内情報）");
        exStringEquals(infoOutputBean.getIwssnHeijyunannaigk(), "60000", "（ＩＷＳＳＮ）平準払案内金額（預振口座案内情報）");
        exStringEquals(infoOutputBean.getIwssnTeikiikkatubaraijkkbn(), null, "（ＩＷＳＳＮ）定期一括払状況区分");
        exStringEquals(infoOutputBean.getIwssnTikiktbrjkkbnnm(), null, "（ＩＷＳＳＮ）定期一括払状況（区分名称）");
        exStringEquals(infoOutputBean.getIwssnHrkkaisuukbn(), "6", "（ＩＷＳＳＮ）払込回数区分");
        exStringEquals(infoOutputBean.getIwssnHrkkaisuukbnnm(), "年２回払", "（ＩＷＳＳＮ）払込回数（区分名称）");
        exStringEquals(infoOutputBean.getIwssnHrkkeirokbnnm(), "クレジットカード扱い", "（ＩＷＳＳＮ）払込経路（区分名称）");
        exStringEquals(infoOutputBean.getIwssnHrkkeirokbn(), "6", "（ＩＷＳＳＮ）払込経路区分");
        exStringEquals(infoOutputBean.getIwssnHrkp(), "10000007", "（ＩＷＳＳＮ）払込保険料");
        exStringEquals(infoOutputBean.getIwssnHrkptuukasyu(), "YEN", "（ＩＷＳＳＮ）払込保険料（通貨種類）");
        exStringEquals(infoOutputBean.getIwssnDattairiyuukbn(), "1", "（ＩＷＳＳＮ）脱退理由区分");
        exStringEquals(infoOutputBean.getIwssnDattairiyuukbnnm(), "払変希望", "（ＩＷＳＳＮ）脱退理由（区分名称）");
        exStringEquals(infoOutputBean.getIwssnYfrjkouzano(), "2323232101", "（ＩＷＳＳＮ）預振情報口座番号");
        exStringEquals(infoOutputBean.getIwssnYfrjkzmeigikn(), "ﾕﾋﾒｲ ﾅﾅｲﾁｶ", "（ＩＷＳＳＮ）預振情報口座名義人（カナ）");
        exStringEquals(infoOutputBean.getIwssnYfrjbanknm(), "銀行名（漢字）", "（ＩＷＳＳＮ）預振情報銀行名称");
        exStringEquals(infoOutputBean.getIwssnYfrjsitennm(), "支店名（漢字）", "（ＩＷＳＳＮ）預振情報支店名称");
        exStringEquals(infoOutputBean.getIwssnYfrjyokinkbnnm(), "普通", "（ＩＷＳＳＮ）預振情報預金種目（区分名称）");
        exStringEquals(infoOutputBean.getIwssnYfrjbankcd(), "0018", "（ＩＷＳＳＮ）預振情報銀行コード");
        exStringEquals(infoOutputBean.getIwssnYfrjsitencd(), "001", "（ＩＷＳＳＮ）預振情報支店コード");
        exStringEquals(infoOutputBean.getIwssnYfrjyokinkbn(), "1", "（ＩＷＳＳＮ）預振情報預金種目区分");
        exStringEquals(infoOutputBean.getIwssnDattaisyoriymd(), "20200525", "（ＩＷＳＳＮ）脱退処理日");
        exStringEquals(infoOutputBean.getIwssnDtjcomment(), null, "（ＩＷＳＳＮ）脱退情報コメント");
        exStringEquals(infoOutputBean.getIwssnHeijyunannaiym(), "202005", "（ＩＷＳＳＮ）平準払案内月");
        exStringEquals(infoOutputBean.getIwssnHeijyunannaijyutouym(), "201906", "（ＩＷＳＳＮ）平準払案内充当年月");
        exStringEquals(infoOutputBean.getIwssnCreyuukoukakkekka(), null, "（ＩＷＳＳＮ）クレジットカード有効確認結果");
        exStringEquals(infoOutputBean.getIwssnCreyuukoukakkekkakbnnm(), null, "（ＩＷＳＳＮ）クレジットカード有効確認結果（区分名称）");
        exStringEquals(infoOutputBean.getIwssnCredityuukoukakym(), null, "（ＩＷＳＳＮ）クレジットカード有効確認年月");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbn1(), null, "（ＩＷＳＳＮ）売上請求ＮＧ事由区分１");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbn2(), null, "（ＩＷＳＳＮ）売上請求ＮＧ事由区分２");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbn3(), null, "（ＩＷＳＳＮ）売上請求ＮＧ事由区分３");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbnnm1(), null, "（ＩＷＳＳＮ）売上請求ＮＧ事由区分（区分名称）１");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbnnm2(), null, "（ＩＷＳＳＮ）売上請求ＮＧ事由区分（区分名称）２");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbnnm3(), null, "（ＩＷＳＳＮ）売上請求ＮＧ事由区分（区分名称）３");
        exStringEquals(infoOutputBean.getIwssnYenkansanp(), "62275000", "（ＩＷＳＳＮ）円換算保険料");
        exStringEquals(infoOutputBean.getIwssnYenkansanptuukasyu(), "YEN", "（ＩＷＳＳＮ）円換算保険料（通貨種類）");
        exStringEquals(infoOutputBean.getIwssnKktikwsrate(), "124.55", "（ＩＷＳＳＮ）確定為替レート");
        exStringEquals(infoOutputBean.getIwssnKnsnkijyunymd(), "20201230", "（ＩＷＳＳＮ）換算基準日");
        exStringEquals(infoOutputBean.getIwssnYykknmnryymd(), "20190401", "（ＩＷＳＳＮ）猶予期間満了日");

    }

    @Test
    @TestOrder(130)
    public void testEditTBL_A13() {

        changeSystemDate(BizDate.valueOf(20210128));
        C_IwssnKykSyoukaiKekkaKbn syoriKekkaKbn = keiyakuInfo.exec("99806001032");
        IwssnSyanaiAnsyuInfoOutputBean infoOutputBean = keiyakuInfo.getIwssnSyanaiAnsyuInfoOutputBean();

        exClassificationEquals(syoriKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.NORMAL, "処理結果区分");
        exStringEquals(infoOutputBean.getIwssnHeijyunjkipjytym(), "201901", "（ＩＷＳＳＮ）平準払次回Ｐ充当年月");
        exStringEquals(infoOutputBean.getIwssnHeijyunanjoannaiym1(), "202005", "（ＩＷＳＳＮ）平準払案内状況案内月１");
        exStringEquals(infoOutputBean.getIwssnHeijyunanjoannaiym2(), "202005", "（ＩＷＳＳＮ）平準払案内状況案内月２");
        exStringEquals(infoOutputBean.getIwssnHeijyunanjoannaiym3(), "202005", "（ＩＷＳＳＮ）平準払案内状況案内月３");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijytym1(), "201906", "（ＩＷＳＳＮ）平準払案内状況案内充当年月１");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijytym2(), "201907", "（ＩＷＳＳＮ）平準払案内状況案内充当年月２");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijytym3(), "201908", "（ＩＷＳＳＮ）平準払案内状況案内充当年月３");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbn1(), "1", "（ＩＷＳＳＮ）平準払案内状況案内状況区分１");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbn2(), "2", "（ＩＷＳＳＮ）平準払案内状況案内状況区分２");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbn3(), "3", "（ＩＷＳＳＮ）平準払案内状況案内状況区分３");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbnnm1(), "案内中", "（ＩＷＳＳＮ）平準払案内状況案内状況区分（区分名称）１");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbnnm2(), "入金", "（ＩＷＳＳＮ）平準払案内状況案内状況区分（区分名称）２");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbnnm3(), "未入", "（ＩＷＳＳＮ）平準払案内状況案内状況区分（区分名称）３");
        exStringEquals(infoOutputBean.getIwssnHijynannaijytkaisuuy(), "0", "（ＩＷＳＳＮ）平準払案内充当回数（年）（預振口座案内情報）");
        exStringEquals(infoOutputBean.getIwssnHijynannaijytkaisuum(), "6", "（ＩＷＳＳＮ）平準払案内充当回数（月）（預振口座案内情報）");
        exStringEquals(infoOutputBean.getIwssnHeijyunannaigk(), "60000", "（ＩＷＳＳＮ）平準払案内金額（預振口座案内情報）");
        exStringEquals(infoOutputBean.getIwssnTeikiikkatubaraijkkbn(), null, "（ＩＷＳＳＮ）定期一括払状況区分");
        exStringEquals(infoOutputBean.getIwssnTikiktbrjkkbnnm(), null, "（ＩＷＳＳＮ）定期一括払状況（区分名称）");
        exStringEquals(infoOutputBean.getIwssnHrkkaisuukbn(), "1", "（ＩＷＳＳＮ）払込回数区分");
        exStringEquals(infoOutputBean.getIwssnHrkkaisuukbnnm(), "月払", "（ＩＷＳＳＮ）払込回数（区分名称）");
        exStringEquals(infoOutputBean.getIwssnHrkkeirokbnnm(), "クレジットカード扱い", "（ＩＷＳＳＮ）払込経路（区分名称）");
        exStringEquals(infoOutputBean.getIwssnHrkkeirokbn(), "6", "（ＩＷＳＳＮ）払込経路区分");
        exStringEquals(infoOutputBean.getIwssnHrkp(), "10000007", "（ＩＷＳＳＮ）払込保険料");
        exStringEquals(infoOutputBean.getIwssnHrkptuukasyu(), "YEN", "（ＩＷＳＳＮ）払込保険料（通貨種類）");
        exStringEquals(infoOutputBean.getIwssnDattairiyuukbn(), "1", "（ＩＷＳＳＮ）脱退理由区分");
        exStringEquals(infoOutputBean.getIwssnDattairiyuukbnnm(), "払変希望", "（ＩＷＳＳＮ）脱退理由（区分名称）");
        exStringEquals(infoOutputBean.getIwssnYfrjkouzano(), "2323232101", "（ＩＷＳＳＮ）預振情報口座番号");
        exStringEquals(infoOutputBean.getIwssnYfrjkzmeigikn(), "ﾕﾋﾒｲ ﾅﾅｲﾁｶ", "（ＩＷＳＳＮ）預振情報口座名義人（カナ）");
        exStringEquals(infoOutputBean.getIwssnYfrjbanknm(), "銀行名（漢字）", "（ＩＷＳＳＮ）預振情報銀行名称");
        exStringEquals(infoOutputBean.getIwssnYfrjsitennm(), "支店名（漢字）", "（ＩＷＳＳＮ）預振情報支店名称");
        exStringEquals(infoOutputBean.getIwssnYfrjyokinkbnnm(), "普通", "（ＩＷＳＳＮ）預振情報預金種目（区分名称）");
        exStringEquals(infoOutputBean.getIwssnYfrjbankcd(), "0018", "（ＩＷＳＳＮ）預振情報銀行コード");
        exStringEquals(infoOutputBean.getIwssnYfrjsitencd(), "001", "（ＩＷＳＳＮ）預振情報支店コード");
        exStringEquals(infoOutputBean.getIwssnYfrjyokinkbn(), "1", "（ＩＷＳＳＮ）預振情報預金種目区分");
        exStringEquals(infoOutputBean.getIwssnDattaisyoriymd(), "20200525", "（ＩＷＳＳＮ）脱退処理日");
        exStringEquals(infoOutputBean.getIwssnDtjcomment(), null, "（ＩＷＳＳＮ）脱退情報コメント");
        exStringEquals(infoOutputBean.getIwssnHeijyunannaiym(), "202005", "（ＩＷＳＳＮ）平準払案内月");
        exStringEquals(infoOutputBean.getIwssnHeijyunannaijyutouym(), "201906", "（ＩＷＳＳＮ）平準払案内充当年月");
        exStringEquals(infoOutputBean.getIwssnCreyuukoukakkekka(), null, "（ＩＷＳＳＮ）クレジットカード有効確認結果");
        exStringEquals(infoOutputBean.getIwssnCreyuukoukakkekkakbnnm(), null, "（ＩＷＳＳＮ）クレジットカード有効確認結果（区分名称）");
        exStringEquals(infoOutputBean.getIwssnCredityuukoukakym(), null, "（ＩＷＳＳＮ）クレジットカード有効確認年月");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbn1(), null, "（ＩＷＳＳＮ）売上請求ＮＧ事由区分１");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbn2(), null, "（ＩＷＳＳＮ）売上請求ＮＧ事由区分２");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbn3(), null, "（ＩＷＳＳＮ）売上請求ＮＧ事由区分３");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbnnm1(), null, "（ＩＷＳＳＮ）売上請求ＮＧ事由区分（区分名称）１");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbnnm2(), null, "（ＩＷＳＳＮ）売上請求ＮＧ事由区分（区分名称）２");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbnnm3(), null, "（ＩＷＳＳＮ）売上請求ＮＧ事由区分（区分名称）３");
        exStringEquals(infoOutputBean.getIwssnYenkansanp(), "62275000", "（ＩＷＳＳＮ）円換算保険料");
        exStringEquals(infoOutputBean.getIwssnYenkansanptuukasyu(), "YEN", "（ＩＷＳＳＮ）円換算保険料（通貨種類）");
        exStringEquals(infoOutputBean.getIwssnKktikwsrate(), "124.55", "（ＩＷＳＳＮ）確定為替レート");
        exStringEquals(infoOutputBean.getIwssnKnsnkijyunymd(), "20201230", "（ＩＷＳＳＮ）換算基準日");
        exStringEquals(infoOutputBean.getIwssnYykknmnryymd(), "20190401", "（ＩＷＳＳＮ）猶予期間満了日");

    }

    @Test
    @TestOrder(140)
    public void testEditTBL_A14() {

        changeSystemDate(BizDate.valueOf(20210128));
        C_IwssnKykSyoukaiKekkaKbn syoriKekkaKbn = keiyakuInfo.exec("99806001043");
        IwssnSyanaiAnsyuInfoOutputBean infoOutputBean = keiyakuInfo.getIwssnSyanaiAnsyuInfoOutputBean();

        exClassificationEquals(syoriKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.EXCEPTION, "処理結果区分");
        exStringEquals(infoOutputBean.getIwssnHeijyunjkipjytym(), "201901", "（ＩＷＳＳＮ）平準払次回Ｐ充当年月");
        exStringEquals(infoOutputBean.getIwssnHeijyunanjoannaiym1(), "202005", "（ＩＷＳＳＮ）平準払案内状況案内月１");
        exStringEquals(infoOutputBean.getIwssnHeijyunanjoannaiym2(), "202005", "（ＩＷＳＳＮ）平準払案内状況案内月２");
        exStringEquals(infoOutputBean.getIwssnHeijyunanjoannaiym3(), "202005", "（ＩＷＳＳＮ）平準払案内状況案内月３");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijytym1(), "201906", "（ＩＷＳＳＮ）平準払案内状況案内充当年月１");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijytym2(), "201907", "（ＩＷＳＳＮ）平準払案内状況案内充当年月２");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijytym3(), "201908", "（ＩＷＳＳＮ）平準払案内状況案内充当年月３");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbn1(), "1", "（ＩＷＳＳＮ）平準払案内状況案内状況区分１");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbn2(), "2", "（ＩＷＳＳＮ）平準払案内状況案内状況区分２");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbn3(), "3", "（ＩＷＳＳＮ）平準払案内状況案内状況区分３");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbnnm1(), "案内中", "（ＩＷＳＳＮ）平準払案内状況案内状況区分（区分名称）１");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbnnm2(), "入金", "（ＩＷＳＳＮ）平準払案内状況案内状況区分（区分名称）２");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbnnm3(), "未入", "（ＩＷＳＳＮ）平準払案内状況案内状況区分（区分名称）３");
        exStringEquals(infoOutputBean.getIwssnHijynannaijytkaisuuy(), "0", "（ＩＷＳＳＮ）平準払案内充当回数（年）（預振口座案内情報）");
        exStringEquals(infoOutputBean.getIwssnHijynannaijytkaisuum(), "6", "（ＩＷＳＳＮ）平準払案内充当回数（月）（預振口座案内情報）");
        exStringEquals(infoOutputBean.getIwssnHeijyunannaigk(), "60000", "（ＩＷＳＳＮ）平準払案内金額（預振口座案内情報）");
        exStringEquals(infoOutputBean.getIwssnTeikiikkatubaraijkkbn(), null, "（ＩＷＳＳＮ）定期一括払状況区分");
        exStringEquals(infoOutputBean.getIwssnTikiktbrjkkbnnm(), null, "（ＩＷＳＳＮ）定期一括払状況（区分名称）");
        exStringEquals(infoOutputBean.getIwssnHrkkaisuukbn(), "99", "（ＩＷＳＳＮ）払込回数区分");
        exStringEquals(infoOutputBean.getIwssnHrkkaisuukbnnm(), "一時払い", "（ＩＷＳＳＮ）払込回数（区分名称）");
        exStringEquals(infoOutputBean.getIwssnHrkkeirokbnnm(), "クレジットカード扱い", "（ＩＷＳＳＮ）払込経路（区分名称）");
        exStringEquals(infoOutputBean.getIwssnHrkkeirokbn(), "6", "（ＩＷＳＳＮ）払込経路区分");
        exStringEquals(infoOutputBean.getIwssnHrkp(), "10000007", "（ＩＷＳＳＮ）払込保険料");
        exStringEquals(infoOutputBean.getIwssnHrkptuukasyu(), "YEN", "（ＩＷＳＳＮ）払込保険料（通貨種類）");
        exStringEquals(infoOutputBean.getIwssnDattairiyuukbn(), "1", "（ＩＷＳＳＮ）脱退理由区分");
        exStringEquals(infoOutputBean.getIwssnDattairiyuukbnnm(), "払変希望", "（ＩＷＳＳＮ）脱退理由（区分名称）");
        exStringEquals(infoOutputBean.getIwssnYfrjkouzano(), "2323232101", "（ＩＷＳＳＮ）預振情報口座番号");
        exStringEquals(infoOutputBean.getIwssnYfrjkzmeigikn(), "ﾕﾋﾒｲ ﾅﾅｲﾁｶ", "（ＩＷＳＳＮ）預振情報口座名義人（カナ）");
        exStringEquals(infoOutputBean.getIwssnYfrjbanknm(), "銀行名（漢字）", "（ＩＷＳＳＮ）預振情報銀行名称");
        exStringEquals(infoOutputBean.getIwssnYfrjsitennm(), "支店名（漢字）", "（ＩＷＳＳＮ）預振情報支店名称");
        exStringEquals(infoOutputBean.getIwssnYfrjyokinkbnnm(), "普通", "（ＩＷＳＳＮ）預振情報預金種目（区分名称）");
        exStringEquals(infoOutputBean.getIwssnYfrjbankcd(), "0018", "（ＩＷＳＳＮ）預振情報銀行コード");
        exStringEquals(infoOutputBean.getIwssnYfrjsitencd(), "001", "（ＩＷＳＳＮ）預振情報支店コード");
        exStringEquals(infoOutputBean.getIwssnYfrjyokinkbn(), "1", "（ＩＷＳＳＮ）預振情報預金種目区分");
        exStringEquals(infoOutputBean.getIwssnDattaisyoriymd(), "20200525", "（ＩＷＳＳＮ）脱退処理日");
        exStringEquals(infoOutputBean.getIwssnDtjcomment(), null, "（ＩＷＳＳＮ）脱退情報コメント");
        exStringEquals(infoOutputBean.getIwssnHeijyunannaiym(), "202005", "（ＩＷＳＳＮ）平準払案内月");
        exStringEquals(infoOutputBean.getIwssnHeijyunannaijyutouym(), "201906", "（ＩＷＳＳＮ）平準払案内充当年月");
        exStringEquals(infoOutputBean.getIwssnCreyuukoukakkekka(), null, "（ＩＷＳＳＮ）クレジットカード有効確認結果");
        exStringEquals(infoOutputBean.getIwssnCreyuukoukakkekkakbnnm(), null, "（ＩＷＳＳＮ）クレジットカード有効確認結果（区分名称）");
        exStringEquals(infoOutputBean.getIwssnCredityuukoukakym(), null, "（ＩＷＳＳＮ）クレジットカード有効確認年月");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbn1(), null, "（ＩＷＳＳＮ）売上請求ＮＧ事由区分１");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbn2(), null, "（ＩＷＳＳＮ）売上請求ＮＧ事由区分２");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbn3(), null, "（ＩＷＳＳＮ）売上請求ＮＧ事由区分３");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbnnm1(), null, "（ＩＷＳＳＮ）売上請求ＮＧ事由区分（区分名称）１");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbnnm2(), null, "（ＩＷＳＳＮ）売上請求ＮＧ事由区分（区分名称）２");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbnnm3(), null, "（ＩＷＳＳＮ）売上請求ＮＧ事由区分（区分名称）３");
        exStringEquals(infoOutputBean.getIwssnYenkansanp(), "0", "（ＩＷＳＳＮ）円換算保険料");
        exStringEquals(infoOutputBean.getIwssnYenkansanptuukasyu(), " ", "（ＩＷＳＳＮ）円換算保険料（通貨種類）");
        exStringEquals(infoOutputBean.getIwssnKktikwsrate(), "000.0000", "（ＩＷＳＳＮ）確定為替レート");
        exStringEquals(infoOutputBean.getIwssnKnsnkijyunymd(), "00000000", "（ＩＷＳＳＮ）換算基準日");
        exStringEquals(infoOutputBean.getIwssnYykknmnryymd(), "00000000", "（ＩＷＳＳＮ）猶予期間満了日");

    }

    @Test
    @TestOrder(150)
    public void testEditTBL_A15() {

        C_IwssnKykSyoukaiKekkaKbn syoriKekkaKbn = keiyakuInfo.exec("99806001054");
        IwssnSyanaiAnsyuInfoOutputBean infoOutputBean = keiyakuInfo.getIwssnSyanaiAnsyuInfoOutputBean();

        exClassificationEquals(syoriKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.NORMAL, "処理結果区分");
        exStringEquals(infoOutputBean.getIwssnHeijyunjkipjytym(), "201901", "（ＩＷＳＳＮ）平準払次回Ｐ充当年月");
        exStringEquals(infoOutputBean.getIwssnHeijyunanjoannaiym1(), "202005", "（ＩＷＳＳＮ）平準払案内状況案内月１");
        exStringEquals(infoOutputBean.getIwssnHeijyunanjoannaiym2(), "202005", "（ＩＷＳＳＮ）平準払案内状況案内月２");
        exStringEquals(infoOutputBean.getIwssnHeijyunanjoannaiym3(), "202005", "（ＩＷＳＳＮ）平準払案内状況案内月３");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijytym1(), "201906", "（ＩＷＳＳＮ）平準払案内状況案内充当年月１");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijytym2(), "201907", "（ＩＷＳＳＮ）平準払案内状況案内充当年月２");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijytym3(), "201908", "（ＩＷＳＳＮ）平準払案内状況案内充当年月３");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbn1(), "1", "（ＩＷＳＳＮ）平準払案内状況案内状況区分１");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbn2(), "2", "（ＩＷＳＳＮ）平準払案内状況案内状況区分２");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbn3(), "3", "（ＩＷＳＳＮ）平準払案内状況案内状況区分３");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbnnm1(), "案内中", "（ＩＷＳＳＮ）平準払案内状況案内状況区分（区分名称）１");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbnnm2(), "入金", "（ＩＷＳＳＮ）平準払案内状況案内状況区分（区分名称）２");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbnnm3(), "未入", "（ＩＷＳＳＮ）平準払案内状況案内状況区分（区分名称）３");
        exStringEquals(infoOutputBean.getIwssnHijynannaijytkaisuuy(), "0", "（ＩＷＳＳＮ）平準払案内充当回数（年）（預振口座案内情報）");
        exStringEquals(infoOutputBean.getIwssnHijynannaijytkaisuum(), "6", "（ＩＷＳＳＮ）平準払案内充当回数（月）（預振口座案内情報）");
        exStringEquals(infoOutputBean.getIwssnHeijyunannaigk(), "60000", "（ＩＷＳＳＮ）平準払案内金額（預振口座案内情報）");
        exStringEquals(infoOutputBean.getIwssnTeikiikkatubaraijkkbn(), null, "（ＩＷＳＳＮ）定期一括払状況区分");
        exStringEquals(infoOutputBean.getIwssnTikiktbrjkkbnnm(), null, "（ＩＷＳＳＮ）定期一括払状況（区分名称）");
        exStringEquals(infoOutputBean.getIwssnHrkkaisuukbn(), "99", "（ＩＷＳＳＮ）払込回数区分");
        exStringEquals(infoOutputBean.getIwssnHrkkaisuukbnnm(), "一時払い", "（ＩＷＳＳＮ）払込回数（区分名称）");
        exStringEquals(infoOutputBean.getIwssnHrkkeirokbnnm(), "クレジットカード扱い", "（ＩＷＳＳＮ）払込経路（区分名称）");
        exStringEquals(infoOutputBean.getIwssnHrkkeirokbn(), "6", "（ＩＷＳＳＮ）払込経路区分");
        exStringEquals(infoOutputBean.getIwssnHrkp(), "10000007", "（ＩＷＳＳＮ）払込保険料");
        exStringEquals(infoOutputBean.getIwssnHrkptuukasyu(), "YEN", "（ＩＷＳＳＮ）払込保険料（通貨種類）");
        exStringEquals(infoOutputBean.getIwssnDattairiyuukbn(), "1", "（ＩＷＳＳＮ）脱退理由区分");
        exStringEquals(infoOutputBean.getIwssnDattairiyuukbnnm(), "払変希望", "（ＩＷＳＳＮ）脱退理由（区分名称）");
        exStringEquals(infoOutputBean.getIwssnYfrjkouzano(), "2323232101", "（ＩＷＳＳＮ）預振情報口座番号");
        exStringEquals(infoOutputBean.getIwssnYfrjkzmeigikn(), "ﾕﾋﾒｲ ﾅﾅｲﾁｶ", "（ＩＷＳＳＮ）預振情報口座名義人（カナ）");
        exStringEquals(infoOutputBean.getIwssnYfrjbanknm(), "銀行名（漢字）", "（ＩＷＳＳＮ）預振情報銀行名称");
        exStringEquals(infoOutputBean.getIwssnYfrjsitennm(), "支店名（漢字）", "（ＩＷＳＳＮ）預振情報支店名称");
        exStringEquals(infoOutputBean.getIwssnYfrjyokinkbnnm(), "普通", "（ＩＷＳＳＮ）預振情報預金種目（区分名称）");
        exStringEquals(infoOutputBean.getIwssnYfrjbankcd(), "0018", "（ＩＷＳＳＮ）預振情報銀行コード");
        exStringEquals(infoOutputBean.getIwssnYfrjsitencd(), "001", "（ＩＷＳＳＮ）預振情報支店コード");
        exStringEquals(infoOutputBean.getIwssnYfrjyokinkbn(), "1", "（ＩＷＳＳＮ）預振情報預金種目区分");
        exStringEquals(infoOutputBean.getIwssnDattaisyoriymd(), "20200525", "（ＩＷＳＳＮ）脱退処理日");
        exStringEquals(infoOutputBean.getIwssnDtjcomment(), null, "（ＩＷＳＳＮ）脱退情報コメント");
        exStringEquals(infoOutputBean.getIwssnHeijyunannaiym(), "202005", "（ＩＷＳＳＮ）平準払案内月");
        exStringEquals(infoOutputBean.getIwssnHeijyunannaijyutouym(), "201906", "（ＩＷＳＳＮ）平準払案内充当年月");
        exStringEquals(infoOutputBean.getIwssnCreyuukoukakkekka(), null, "（ＩＷＳＳＮ）クレジットカード有効確認結果");
        exStringEquals(infoOutputBean.getIwssnCreyuukoukakkekkakbnnm(), null, "（ＩＷＳＳＮ）クレジットカード有効確認結果（区分名称）");
        exStringEquals(infoOutputBean.getIwssnCredityuukoukakym(), null, "（ＩＷＳＳＮ）クレジットカード有効確認年月");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbn1(), null, "（ＩＷＳＳＮ）売上請求ＮＧ事由区分１");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbn2(), null, "（ＩＷＳＳＮ）売上請求ＮＧ事由区分２");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbn3(), null, "（ＩＷＳＳＮ）売上請求ＮＧ事由区分３");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbnnm1(), null, "（ＩＷＳＳＮ）売上請求ＮＧ事由区分（区分名称）１");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbnnm2(), null, "（ＩＷＳＳＮ）売上請求ＮＧ事由区分（区分名称）２");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbnnm3(), null, "（ＩＷＳＳＮ）売上請求ＮＧ事由区分（区分名称）３");
        exStringEquals(infoOutputBean.getIwssnYenkansanp(), "0", "（ＩＷＳＳＮ）円換算保険料");
        exStringEquals(infoOutputBean.getIwssnYenkansanptuukasyu(), " ", "（ＩＷＳＳＮ）円換算保険料（通貨種類）");
        exStringEquals(infoOutputBean.getIwssnKktikwsrate(), "000.0000", "（ＩＷＳＳＮ）確定為替レート");
        exStringEquals(infoOutputBean.getIwssnKnsnkijyunymd(), "00000000", "（ＩＷＳＳＮ）換算基準日");
        exStringEquals(infoOutputBean.getIwssnYykknmnryymd(), "00000000", "（ＩＷＳＳＮ）猶予期間満了日");

    }

    @Test
    @TestOrder(160)
    public void testEditTBL_A16() {

        changeSystemDate(BizDate.valueOf(20210218));
        C_IwssnKykSyoukaiKekkaKbn syoriKekkaKbn = keiyakuInfo.exec("99806001065");
        IwssnSyanaiAnsyuInfoOutputBean infoOutputBean = keiyakuInfo.getIwssnSyanaiAnsyuInfoOutputBean();

        exClassificationEquals(syoriKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.SONOTAHENSYUU_ERROR, "処理結果区分");
        exStringEquals(infoOutputBean.getIwssnHeijyunjkipjytym(), "201901", "（ＩＷＳＳＮ）平準払次回Ｐ充当年月");
        exStringEquals(infoOutputBean.getIwssnHeijyunanjoannaiym1(), "202005", "（ＩＷＳＳＮ）平準払案内状況案内月１");
        exStringEquals(infoOutputBean.getIwssnHeijyunanjoannaiym2(), "202005", "（ＩＷＳＳＮ）平準払案内状況案内月２");
        exStringEquals(infoOutputBean.getIwssnHeijyunanjoannaiym3(), "202005", "（ＩＷＳＳＮ）平準払案内状況案内月３");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijytym1(), "201906", "（ＩＷＳＳＮ）平準払案内状況案内充当年月１");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijytym2(), "201907", "（ＩＷＳＳＮ）平準払案内状況案内充当年月２");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijytym3(), "201908", "（ＩＷＳＳＮ）平準払案内状況案内充当年月３");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbn1(), "1", "（ＩＷＳＳＮ）平準払案内状況案内状況区分１");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbn2(), "2", "（ＩＷＳＳＮ）平準払案内状況案内状況区分２");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbn3(), "3", "（ＩＷＳＳＮ）平準払案内状況案内状況区分３");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbnnm1(), "案内中", "（ＩＷＳＳＮ）平準払案内状況案内状況区分（区分名称）１");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbnnm2(), "入金", "（ＩＷＳＳＮ）平準払案内状況案内状況区分（区分名称）２");
        exStringEquals(infoOutputBean.getIwssnHijynanjoannaijokbnnm3(), "未入", "（ＩＷＳＳＮ）平準払案内状況案内状況区分（区分名称）３");
        exStringEquals(infoOutputBean.getIwssnHijynannaijytkaisuuy(), "0", "（ＩＷＳＳＮ）平準払案内充当回数（年）（預振口座案内情報）");
        exStringEquals(infoOutputBean.getIwssnHijynannaijytkaisuum(), "6", "（ＩＷＳＳＮ）平準払案内充当回数（月）（預振口座案内情報）");
        exStringEquals(infoOutputBean.getIwssnHeijyunannaigk(), "60000", "（ＩＷＳＳＮ）平準払案内金額（預振口座案内情報）");
        exStringEquals(infoOutputBean.getIwssnTeikiikkatubaraijkkbn(), null, "（ＩＷＳＳＮ）定期一括払状況区分");
        exStringEquals(infoOutputBean.getIwssnTikiktbrjkkbnnm(), null, "（ＩＷＳＳＮ）定期一括払状況（区分名称）");
        exStringEquals(infoOutputBean.getIwssnHrkkaisuukbn(), "12", "（ＩＷＳＳＮ）払込回数区分");
        exStringEquals(infoOutputBean.getIwssnHrkkaisuukbnnm(), "年１回払", "（ＩＷＳＳＮ）払込回数（区分名称）");
        exStringEquals(infoOutputBean.getIwssnHrkkeirokbnnm(), "クレジットカード扱い", "（ＩＷＳＳＮ）払込経路（区分名称）");
        exStringEquals(infoOutputBean.getIwssnHrkkeirokbn(), "6", "（ＩＷＳＳＮ）払込経路区分");
        exStringEquals(infoOutputBean.getIwssnHrkp(), "10000007", "（ＩＷＳＳＮ）払込保険料");
        exStringEquals(infoOutputBean.getIwssnHrkptuukasyu(), "YEN", "（ＩＷＳＳＮ）払込保険料（通貨種類）");
        exStringEquals(infoOutputBean.getIwssnDattairiyuukbn(), "1", "（ＩＷＳＳＮ）脱退理由区分");
        exStringEquals(infoOutputBean.getIwssnDattairiyuukbnnm(), "払変希望", "（ＩＷＳＳＮ）脱退理由（区分名称）");
        exStringEquals(infoOutputBean.getIwssnYfrjkouzano(), "2323232101", "（ＩＷＳＳＮ）預振情報口座番号");
        exStringEquals(infoOutputBean.getIwssnYfrjkzmeigikn(), "ﾕﾋﾒｲ ﾅﾅｲﾁｶ", "（ＩＷＳＳＮ）預振情報口座名義人（カナ）");
        exStringEquals(infoOutputBean.getIwssnYfrjbanknm(), "銀行名（漢字）", "（ＩＷＳＳＮ）預振情報銀行名称");
        exStringEquals(infoOutputBean.getIwssnYfrjsitennm(), "支店名（漢字）", "（ＩＷＳＳＮ）預振情報支店名称");
        exStringEquals(infoOutputBean.getIwssnYfrjyokinkbnnm(), "普通", "（ＩＷＳＳＮ）預振情報預金種目（区分名称）");
        exStringEquals(infoOutputBean.getIwssnYfrjbankcd(), "0018", "（ＩＷＳＳＮ）預振情報銀行コード");
        exStringEquals(infoOutputBean.getIwssnYfrjsitencd(), "001", "（ＩＷＳＳＮ）預振情報支店コード");
        exStringEquals(infoOutputBean.getIwssnYfrjyokinkbn(), "1", "（ＩＷＳＳＮ）預振情報預金種目区分");
        exStringEquals(infoOutputBean.getIwssnDattaisyoriymd(), "20200525", "（ＩＷＳＳＮ）脱退処理日");
        exStringEquals(infoOutputBean.getIwssnDtjcomment(), null, "（ＩＷＳＳＮ）脱退情報コメント");
        exStringEquals(infoOutputBean.getIwssnHeijyunannaiym(), "202005", "（ＩＷＳＳＮ）平準払案内月");
        exStringEquals(infoOutputBean.getIwssnHeijyunannaijyutouym(), "201906", "（ＩＷＳＳＮ）平準払案内充当年月");
        exStringEquals(infoOutputBean.getIwssnCreyuukoukakkekka(), null, "（ＩＷＳＳＮ）クレジットカード有効確認結果");
        exStringEquals(infoOutputBean.getIwssnCreyuukoukakkekkakbnnm(), null, "（ＩＷＳＳＮ）クレジットカード有効確認結果（区分名称）");
        exStringEquals(infoOutputBean.getIwssnCredityuukoukakym(), null, "（ＩＷＳＳＮ）クレジットカード有効確認年月");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbn1(), null, "（ＩＷＳＳＮ）売上請求ＮＧ事由区分１");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbn2(), null, "（ＩＷＳＳＮ）売上請求ＮＧ事由区分２");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbn3(), null, "（ＩＷＳＳＮ）売上請求ＮＧ事由区分３");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbnnm1(), null, "（ＩＷＳＳＮ）売上請求ＮＧ事由区分（区分名称）１");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbnnm2(), null, "（ＩＷＳＳＮ）売上請求ＮＧ事由区分（区分名称）２");
        exStringEquals(infoOutputBean.getIwssnUragngjiyuukbnnm3(), null, "（ＩＷＳＳＮ）売上請求ＮＧ事由区分（区分名称）３");
        exStringEquals(infoOutputBean.getIwssnYenkansanp(), "0", "（ＩＷＳＳＮ）円換算保険料");
        exStringEquals(infoOutputBean.getIwssnYenkansanptuukasyu(), " ", "（ＩＷＳＳＮ）円換算保険料（通貨種類）");
        exStringEquals(infoOutputBean.getIwssnKktikwsrate(), "000.0000", "（ＩＷＳＳＮ）確定為替レート");
        exStringEquals(infoOutputBean.getIwssnKnsnkijyunymd(), "00000000", "（ＩＷＳＳＮ）換算基準日");
        exStringEquals(infoOutputBean.getIwssnYykknmnryymd(), "00000000", "（ＩＷＳＳＮ）猶予期間満了日");

    }
}
