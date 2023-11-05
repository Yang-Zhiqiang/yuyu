package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

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
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_HnkSyuruiKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_Kariukekin;
import yuyu.def.db.entity.IT_KhHenkouRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_NyuukinKakusyouData;
import yuyu.def.db.entity.IT_SyuunouHenknRireki;
import yuyu.def.db.entity.IT_Tokusin;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 案内収納用契約保全変更履歴TBL編集のメソッド {@link AnsyuuEditKhHenkouRirekiTbl#editKhHenkouRirekiTblForNyuukin(
 * EditKhHenkouRirekiTblForNyuukinBean)} テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class AnsyuuEditKhHenkouRirekiTblTest_editKhHenkouRirekiTblForNyuukin {

    @Inject
    private AnsyuuEditKhHenkouRirekiTbl ansyuuEditKhHenkouRirekiTbl;

    @Inject
    HozenDomManager hozenDomManager;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_案内収納用契約保全変更履歴TBL編集";

    private final static String sheetName = "INデータ";

    private static HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataAndTblMap = testDataMaker.getInData(
                AnsyuuEditKhHenkouRirekiTblTest_editKhHenkouRirekiTblForNyuukin.class, fileName, sheetName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
        hozenDomManager.delete(hozenDomManager.getAllKhBikinkanri());
        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        siharaiDomManager.delete(siharaiDomManager.getAllSiBikinkanri());

    }

    @Test
    @TestOrder(10)
    @Transactional
    public void testExec_inData1() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testExec_A1() {

        String henkouSikibetuKey = "0010";
        String syoNo = "17806000013";

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo);
        IT_Tokusin tokusinSyoriMae = ansyuKihon.getTokusin();

        EditKhHenkouRirekiTblForNyuukinBean editKhHkRrkTblForNyknBean = new EditKhHenkouRirekiTblForNyuukinBean();

        editKhHkRrkTblForNyknBean.setHenkouSikibetuKey(henkouSikibetuKey);
        editKhHkRrkTblForNyknBean.setKykKihonSyoriAto(kykKihon);
        editKhHkRrkTblForNyknBean.setAnsyuKihonSyoriAto(ansyuKihon);
        editKhHkRrkTblForNyknBean.setNyuukinKakusyouDataSyoriAto(null);
        editKhHkRrkTblForNyknBean.setAnsyuKihonSyoriMae(ansyuKihon);
        editKhHkRrkTblForNyknBean.setKykSyouhnSyoriMae(null);
        editKhHkRrkTblForNyknBean.setTokusinSyoriMae(tokusinSyoriMae);
        editKhHkRrkTblForNyknBean.setSyuunouHenknRirekiSyoriAto(null);
        editKhHkRrkTblForNyknBean.setKariukekinSyoriAto(null);

        List<IT_KhHenkouRireki> henkouRirekiList =
            ansyuuEditKhHenkouRirekiTbl.editKhHenkouRirekiTblForNyuukin(editKhHkRrkTblForNyknBean);

        exNumericEquals(0, henkouRirekiList.size(), "契約保全変更履歴TBLエンティティリスト件数");
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testExec_A2() {

        String henkouSikibetuKey = "0020";
        String syoNo = "17806000024";

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo);
        IT_KykSyouhn kykSyouhnSyoriMae = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);

        EditKhHenkouRirekiTblForNyuukinBean editKhHkRrkTblForNyknBean = new EditKhHenkouRirekiTblForNyuukinBean();

        editKhHkRrkTblForNyknBean.setHenkouSikibetuKey(henkouSikibetuKey);
        editKhHkRrkTblForNyknBean.setKykKihonSyoriAto(kykKihon);
        editKhHkRrkTblForNyknBean.setAnsyuKihonSyoriAto(ansyuKihon);
        editKhHkRrkTblForNyknBean.setNyuukinKakusyouDataSyoriAto(null);
        editKhHkRrkTblForNyknBean.setAnsyuKihonSyoriMae(ansyuKihon);
        editKhHkRrkTblForNyknBean.setKykSyouhnSyoriMae(kykSyouhnSyoriMae);
        editKhHkRrkTblForNyknBean.setTokusinSyoriMae(null);
        editKhHkRrkTblForNyknBean.setSyuunouHenknRirekiSyoriAto(null);
        editKhHkRrkTblForNyknBean.setKariukekinSyoriAto(null);

        List<IT_KhHenkouRireki> henkouRirekiList =
            ansyuuEditKhHenkouRirekiTbl.editKhHenkouRirekiTblForNyuukin(editKhHkRrkTblForNyknBean);

        exNumericEquals(0, henkouRirekiList.size(), "契約保全変更履歴TBLエンティティリスト件数");
    }


    @Test
    @TestOrder(40)
    @Transactional
    public void testExec_inData2() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }

    }


    @Test
    @TestOrder(50)
    @Transactional
    public void testExec_A3() {

        String pHenkouSikibetuKey = "0020";
        String syoNoAto = "17806000024";
        String syoNoMae = "17806000013";

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNoAto);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNoAto);
        IT_AnsyuKihon pAnsyuKihonSyoriMae = hozenDomManager.getAnsyuKihon(syoNoMae);
        IT_SyuunouHenknRireki pSyuunouHenknRirekiSyoriAto = ansyuKihon.getSyuunouHenknRirekis().get(0);
        IT_NyuukinKakusyouData nyuukinKakusyouData = hozenDomManager.getNyuukinKakusyouDataBySyono(syoNoMae).get(0);
        IT_KykSyouhn pKykSyouhnSyoriMae = hozenDomManager.getKykKihon(syoNoMae).getKykSyouhns().get(0);
        IT_Tokusin pTokusinSyoriMae = hozenDomManager.getAnsyuKihon(syoNoMae).getTokusin();
        IT_Kariukekin pKariukekinSyoriAto = kykKihon.getKariukekins().get(2);

        EditKhHenkouRirekiTblForNyuukinBean pEditKhHkRrkTblForNyknBean = new EditKhHenkouRirekiTblForNyuukinBean();
        pEditKhHkRrkTblForNyknBean.setHenkouSikibetuKey(pHenkouSikibetuKey);
        pEditKhHkRrkTblForNyknBean.setKykKihonSyoriAto(kykKihon);
        pEditKhHkRrkTblForNyknBean.setAnsyuKihonSyoriAto(ansyuKihon);
        pEditKhHkRrkTblForNyknBean.setNyuukinKakusyouDataSyoriAto(nyuukinKakusyouData);
        pEditKhHkRrkTblForNyknBean.setAnsyuKihonSyoriMae(pAnsyuKihonSyoriMae);
        pEditKhHkRrkTblForNyknBean.setKykSyouhnSyoriMae(pKykSyouhnSyoriMae);
        pEditKhHkRrkTblForNyknBean.setTokusinSyoriMae(pTokusinSyoriMae);
        pEditKhHkRrkTblForNyknBean.setSyuunouHenknRirekiSyoriAto(pSyuunouHenknRirekiSyoriAto);
        pEditKhHkRrkTblForNyknBean.setKariukekinSyoriAto(pKariukekinSyoriAto);

        List<IT_KhHenkouRireki> henkouRirekiList =
            ansyuuEditKhHenkouRirekiTbl.editKhHenkouRirekiTblForNyuukin(pEditKhHkRrkTblForNyknBean);

        exNumericEquals(henkouRirekiList.size(), 10, "契約保全変更履歴TBLエンティティリスト件数");

        exStringEquals(henkouRirekiList.get(0).getSyono(),"17806000024", "証券番号");
        exStringEquals(henkouRirekiList.get(0).getHenkousikibetukey(),"0020", "変更識別キー");
        exNumericEquals(henkouRirekiList.get(0).getRenno3keta(), 1, "連番");
        exStringEquals(henkouRirekiList.get(0).getTablenm(),"案内収納基本テーブル", "テーブル名称");
        exStringEquals(henkouRirekiList.get(0).getTableid(),"IT_AnsyuKihon", "テーブルＩＤ");
        exClassificationEquals(henkouRirekiList.get(0).getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(henkouRirekiList.get(0).getHanbetukoumokunm(),"契約基本情報", "判別項目名");
        exStringEquals(henkouRirekiList.get(0).getHenkoukoumokuid(),"tkiktannaitukisuu", "変更項目ID");
        exStringEquals(henkouRirekiList.get(0).getHenkoukoumokunm(),"定期一括案内月数", "変更項目名");
        exStringEquals(henkouRirekiList.get(0).getBfrnaiyouoriginal(),"6", "変更前内容原本");
        exStringEquals(henkouRirekiList.get(0).getBfrnaiyou(),"６ヶ月一括", "変更前内容");
        exStringEquals(henkouRirekiList.get(0).getNewnaiyouoriginal(),"", "変更後内容原本");
        exStringEquals(henkouRirekiList.get(0).getNewnaiyou(),"", "変更後内容");
        exStringEquals(henkouRirekiList.get(0).getGyoumuKousinKinou(),"AnsyuuEditKhHenkouRirekiTbl", "業務用更新機能ＩＤ");
        exStringEquals(henkouRirekiList.get(0).getGyoumuKousinsyaId(),"junit", "業務用更新者ＩＤ");

        exStringEquals(henkouRirekiList.get(1).getSyono(),"17806000024", "証券番号");
        exStringEquals(henkouRirekiList.get(1).getHenkousikibetukey(),"0020", "変更識別キー");
        exNumericEquals(henkouRirekiList.get(1).getRenno3keta(), 2, "連番");
        exStringEquals(henkouRirekiList.get(1).getTablenm(),"案内収納基本テーブル", "テーブル名称");
        exStringEquals(henkouRirekiList.get(1).getTableid(),"IT_AnsyuKihon", "テーブルＩＤ");
        exClassificationEquals(henkouRirekiList.get(1).getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(henkouRirekiList.get(1).getHanbetukoumokunm(),"契約基本情報", "判別項目名");
        exStringEquals(henkouRirekiList.get(1).getHenkoukoumokuid(),"kjsmhakkouzumiflg", "変更項目ID");
        exStringEquals(henkouRirekiList.get(1).getHenkoukoumokunm(),"控除証明書発行済フラグ", "変更項目名");
        exStringEquals(henkouRirekiList.get(1).getBfrnaiyouoriginal(),"", "変更前内容原本");
        exStringEquals(henkouRirekiList.get(1).getBfrnaiyou(),"", "変更前内容");
        exStringEquals(henkouRirekiList.get(1).getNewnaiyouoriginal(),"1", "変更後内容原本");
        exStringEquals(henkouRirekiList.get(1).getNewnaiyou(),"控除証明書発行済", "変更後内容");
        exStringEquals(henkouRirekiList.get(1).getGyoumuKousinKinou(),"AnsyuuEditKhHenkouRirekiTbl", "業務用更新機能ＩＤ");
        exStringEquals(henkouRirekiList.get(1).getGyoumuKousinsyaId(),"junit", "業務用更新者ＩＤ");

        exStringEquals(henkouRirekiList.get(2).getSyono(),"17806000024", "証券番号");
        exStringEquals(henkouRirekiList.get(2).getHenkousikibetukey(),"0020", "変更識別キー");
        exNumericEquals(henkouRirekiList.get(2).getRenno3keta(), 3, "連番");
        exStringEquals(henkouRirekiList.get(2).getTablenm(),"案内収納基本テーブル", "テーブル名称");
        exStringEquals(henkouRirekiList.get(2).getTableid(),"IT_AnsyuKihon", "テーブルＩＤ");
        exClassificationEquals(henkouRirekiList.get(2).getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(henkouRirekiList.get(2).getHanbetukoumokunm(),"契約基本情報", "判別項目名");
        exStringEquals(henkouRirekiList.get(2).getHenkoukoumokuid(),"syuharaimanymd", "変更項目ID");
        exStringEquals(henkouRirekiList.get(2).getHenkoukoumokunm(),"主契約払満日", "変更項目名");
        exStringEquals(henkouRirekiList.get(2).getBfrnaiyouoriginal(),"20180505", "変更前内容原本");
        exStringEquals(henkouRirekiList.get(2).getBfrnaiyou(),"20180505", "変更前内容");
        exStringEquals(henkouRirekiList.get(2).getNewnaiyouoriginal(),"20180506", "変更後内容原本");
        exStringEquals(henkouRirekiList.get(2).getNewnaiyou(),"20180506", "変更後内容");
        exStringEquals(henkouRirekiList.get(2).getGyoumuKousinKinou(),"AnsyuuEditKhHenkouRirekiTbl", "業務用更新機能ＩＤ");
        exStringEquals(henkouRirekiList.get(2).getGyoumuKousinsyaId(),"junit", "業務用更新者ＩＤ");

        exStringEquals(henkouRirekiList.get(3).getSyono(),"17806000024", "証券番号");
        exStringEquals(henkouRirekiList.get(3).getHenkousikibetukey(),"0020", "変更識別キー");
        exNumericEquals(henkouRirekiList.get(3).getRenno3keta(), 4, "連番");
        exStringEquals(henkouRirekiList.get(3).getTablenm(),"案内収納基本テーブル", "テーブル名称");
        exStringEquals(henkouRirekiList.get(3).getTableid(),"IT_AnsyuKihon", "テーブルＩＤ");
        exClassificationEquals(henkouRirekiList.get(3).getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(henkouRirekiList.get(3).getHanbetukoumokunm(),"契約基本情報", "判別項目名");
        exStringEquals(henkouRirekiList.get(3).getHenkoukoumokuid(),"kbnkey", "変更項目ID");
        exStringEquals(henkouRirekiList.get(3).getHenkoukoumokunm(),"区分キー", "変更項目名");
        exStringEquals(henkouRirekiList.get(3).getBfrnaiyouoriginal(),"01", "変更前内容原本");
        exStringEquals(henkouRirekiList.get(3).getBfrnaiyou(),"01", "変更前内容");
        exStringEquals(henkouRirekiList.get(3).getNewnaiyouoriginal(),"02", "変更後内容原本");
        exStringEquals(henkouRirekiList.get(3).getNewnaiyou(),"02", "変更後内容");
        exStringEquals(henkouRirekiList.get(3).getGyoumuKousinKinou(),"AnsyuuEditKhHenkouRirekiTbl", "業務用更新機能ＩＤ");
        exStringEquals(henkouRirekiList.get(3).getGyoumuKousinsyaId(),"junit", "業務用更新者ＩＤ");

        exStringEquals(henkouRirekiList.get(4).getSyono(),"17806000024", "証券番号");
        exStringEquals(henkouRirekiList.get(4).getHenkousikibetukey(),"0020", "変更識別キー");
        exNumericEquals(henkouRirekiList.get(4).getRenno3keta(), 5, "連番");
        exStringEquals(henkouRirekiList.get(4).getTablenm(),"案内収納基本テーブル", "テーブル名称");
        exStringEquals(henkouRirekiList.get(4).getTableid(),"IT_AnsyuKihon", "テーブルＩＤ");
        exClassificationEquals(henkouRirekiList.get(4).getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(henkouRirekiList.get(4).getHanbetukoumokunm(),"契約基本情報", "判別項目名");
        exStringEquals(henkouRirekiList.get(4).getHenkoukoumokuid(),"jkipjytym", "変更項目ID");
        exStringEquals(henkouRirekiList.get(4).getHenkoukoumokunm(),"次回Ｐ充当年月", "変更項目名");
        exStringEquals(henkouRirekiList.get(4).getBfrnaiyouoriginal(),"201801", "変更前内容原本");
        exStringEquals(henkouRirekiList.get(4).getBfrnaiyou(),"201801", "変更前内容");
        exStringEquals(henkouRirekiList.get(4).getNewnaiyouoriginal(),"201802", "変更後内容原本");
        exStringEquals(henkouRirekiList.get(4).getNewnaiyou(),"201802", "変更後内容");
        exStringEquals(henkouRirekiList.get(4).getGyoumuKousinKinou(),"AnsyuuEditKhHenkouRirekiTbl", "業務用更新機能ＩＤ");
        exStringEquals(henkouRirekiList.get(4).getGyoumuKousinsyaId(),"junit", "業務用更新者ＩＤ");

        exStringEquals(henkouRirekiList.get(5).getSyono(),"17806000024", "証券番号");
        exStringEquals(henkouRirekiList.get(5).getHenkousikibetukey(),"0020", "変更識別キー");
        exNumericEquals(henkouRirekiList.get(5).getRenno3keta(),6, "連番");
        exStringEquals(henkouRirekiList.get(5).getTablenm(),"入金確証データテーブル", "テーブル名称");
        exStringEquals(henkouRirekiList.get(5).getTableid(),"IT_NyuukinKakusyouData", "テーブルＩＤ");
        exClassificationEquals(henkouRirekiList.get(5).getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(henkouRirekiList.get(5).getHanbetukoumokunm(),"入金確証情報（入金確証番号：12345678901）", "判別項目名");
        exStringEquals(henkouRirekiList.get(5).getHenkoukoumokuid(),"", "変更項目ID");
        exStringEquals(henkouRirekiList.get(5).getHenkoukoumokunm(),"", "変更項目名");
        exStringEquals(henkouRirekiList.get(5).getBfrnaiyouoriginal(),"", "変更前内容原本");
        exStringEquals(henkouRirekiList.get(5).getBfrnaiyou(),"", "変更前内容");
        exStringEquals(henkouRirekiList.get(5).getNewnaiyouoriginal(),"", "変更後内容原本");
        exStringEquals(henkouRirekiList.get(5).getNewnaiyou(),
            "入金伝票日付：20180501／"
                + "束仮勘定番号：01／"
                + "入金経路：新契約／"
                + "充当年月：201805／"
                + "充当回数（年）：18／"
                + "充当回数（月）：1／"
                + "領収日：20180601", "変更後内容");
        exStringEquals(henkouRirekiList.get(5).getGyoumuKousinKinou(),"AnsyuuEditKhHenkouRirekiTbl", "業務用更新機能ＩＤ");
        exStringEquals(henkouRirekiList.get(5).getGyoumuKousinsyaId(),"junit", "業務用更新者ＩＤ");

        exStringEquals(henkouRirekiList.get(6).getSyono(),"17806000024", "証券番号");
        exStringEquals(henkouRirekiList.get(6).getHenkousikibetukey(),"0020", "変更識別キー");
        exNumericEquals(henkouRirekiList.get(6).getRenno3keta(), 7, "連番");
        exStringEquals(henkouRirekiList.get(6).getTablenm(),"契約商品テーブル", "テーブル名称");
        exStringEquals(henkouRirekiList.get(6).getTableid(),"IT_KykSyouhn", "テーブルＩＤ");
        exClassificationEquals(henkouRirekiList.get(6).getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(henkouRirekiList.get(6).getHanbetukoumokunm(),"商品名（略称）", "判別項目名");
        exStringEquals(henkouRirekiList.get(6).getHenkoukoumokuid(),"kbnkey", "変更項目ID");
        exStringEquals(henkouRirekiList.get(6).getHenkoukoumokunm(),"区分キー", "変更項目名");
        exStringEquals(henkouRirekiList.get(6).getBfrnaiyouoriginal(),"01", "変更前内容原本");
        exStringEquals(henkouRirekiList.get(6).getBfrnaiyou(),"01", "変更前内容");
        exStringEquals(henkouRirekiList.get(6).getNewnaiyouoriginal(),"02", "変更後内容原本");
        exStringEquals(henkouRirekiList.get(6).getNewnaiyou(), "02", "変更後内容");
        exStringEquals(henkouRirekiList.get(6).getGyoumuKousinKinou(),"AnsyuuEditKhHenkouRirekiTbl", "業務用更新機能ＩＤ");
        exStringEquals(henkouRirekiList.get(6).getGyoumuKousinsyaId(),"junit", "業務用更新者ＩＤ");

        exStringEquals(henkouRirekiList.get(7).getSyono(),"17806000024", "証券番号");
        exStringEquals(henkouRirekiList.get(7).getHenkousikibetukey(),"0020", "変更識別キー");
        exNumericEquals(henkouRirekiList.get(7).getRenno3keta(), 8, "連番");
        exStringEquals(henkouRirekiList.get(7).getTablenm(),"仮受金テーブル", "テーブル名称");
        exStringEquals(henkouRirekiList.get(7).getTableid(),"IT_Kariukekin", "テーブルＩＤ");
        exClassificationEquals(henkouRirekiList.get(7).getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(henkouRirekiList.get(7).getHanbetukoumokunm(),"仮受金情報（仮受番号：10003）", "判別項目名");
        exStringEquals(henkouRirekiList.get(7).getHenkoukoumokuid(),"", "変更項目ID");
        exStringEquals(henkouRirekiList.get(7).getHenkoukoumokunm(),"", "変更項目名");
        exStringEquals(henkouRirekiList.get(7).getBfrnaiyouoriginal(),"", "変更前内容原本");
        exStringEquals(henkouRirekiList.get(7).getBfrnaiyou(),"", "変更前内容");
        exStringEquals(henkouRirekiList.get(7).getNewnaiyouoriginal(),"", "変更後内容原本");
        exStringEquals(henkouRirekiList.get(7).getNewnaiyou(),
            "計上日：20180502／"
                + "金額：1000000000002／"
                + "仮受理由：消滅後入金／継続Ｐ／"
                + "経路：保険金／"
                + "充当年月：／"
                + "年数：18／"
                + "月数：5／"
                + "領収日：20180601", "変更後内容");
        exStringEquals(henkouRirekiList.get(7).getGyoumuKousinKinou(),"AnsyuuEditKhHenkouRirekiTbl", "業務用更新機能ＩＤ");
        exStringEquals(henkouRirekiList.get(7).getGyoumuKousinsyaId(),"junit", "業務用更新者ＩＤ");

        exStringEquals(henkouRirekiList.get(8).getSyono(),"17806000024", "証券番号");
        exStringEquals(henkouRirekiList.get(8).getHenkousikibetukey(),"0020", "変更識別キー");
        exNumericEquals(henkouRirekiList.get(8).getRenno3keta(), 9, "連番");
        exStringEquals(henkouRirekiList.get(8).getTablenm(),"収納返金履歴テーブル", "テーブル名称");
        exStringEquals(henkouRirekiList.get(8).getTableid(),"IT_SyuunouHenknRireki", "テーブルＩＤ");
        exClassificationEquals(henkouRirekiList.get(8).getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(henkouRirekiList.get(8).getHanbetukoumokunm(),"収納返金履歴情報（伝票データ連番：10000000002　枝番号：2）", "判別項目名");
        exStringEquals(henkouRirekiList.get(8).getHenkoukoumokuid(),"", "変更項目ID");
        exStringEquals(henkouRirekiList.get(8).getHenkoukoumokunm(),"", "変更項目名");
        exStringEquals(henkouRirekiList.get(8).getBfrnaiyouoriginal(),"", "変更前内容原本");
        exStringEquals(henkouRirekiList.get(8).getBfrnaiyou(),"", "変更前内容");
        exStringEquals(henkouRirekiList.get(8).getNewnaiyouoriginal(),"", "変更後内容原本");
        exStringEquals(henkouRirekiList.get(8).getNewnaiyou(),
            "支払日：20180502／"
                + "返金額：1000000000002／"
                + "理由：払込方法変更後入金／"
                + "銀行：1002／"
                + "支店：202／普通／"
                + "口座番号：100000000001／口座名義人氏名（カナ）口座名義人氏", "変更後内容");
        exStringEquals(henkouRirekiList.get(8).getGyoumuKousinKinou(),"AnsyuuEditKhHenkouRirekiTbl", "業務用更新機能ＩＤ");
        exStringEquals(henkouRirekiList.get(8).getGyoumuKousinsyaId(),"junit", "業務用更新者ＩＤ");

        exStringEquals(henkouRirekiList.get(9).getSyono(),"17806000024", "証券番号");
        exStringEquals(henkouRirekiList.get(9).getHenkousikibetukey(),"0020", "変更識別キー");
        exNumericEquals(henkouRirekiList.get(9).getRenno3keta(), 10, "連番");
        exStringEquals(henkouRirekiList.get(9).getTablenm(),"特伸テーブル", "テーブル名称");
        exStringEquals(henkouRirekiList.get(9).getTableid(),"IT_Tokusin", "テーブルＩＤ");
        exClassificationEquals(henkouRirekiList.get(9).getHnksyuruikbn(), C_HnkSyuruiKbn.SAKUJYO, "変更種類区分");
        exStringEquals(henkouRirekiList.get(9).getHanbetukoumokunm(),"特伸情報", "判別項目名");
        exStringEquals(henkouRirekiList.get(9).getHenkoukoumokuid(),"", "変更項目ID");
        exStringEquals(henkouRirekiList.get(9).getHenkoukoumokunm(),"", "変更項目名");
        exStringEquals(henkouRirekiList.get(9).getBfrnaiyouoriginal(),"", "変更前内容原本");
        exStringEquals(henkouRirekiList.get(9).getBfrnaiyou(),
            "特伸区分：被災害特伸／"
                + "特伸処理年月日：20180501／"
                + "特伸終了年月日：20180701／"
                + "被災害年月日：20180601", "変更前内容");
        exStringEquals(henkouRirekiList.get(9).getNewnaiyouoriginal(),"", "変更後内容原本");
        exStringEquals(henkouRirekiList.get(9).getNewnaiyou(), "", "変更後内容");
        exStringEquals(henkouRirekiList.get(9).getGyoumuKousinKinou(),"AnsyuuEditKhHenkouRirekiTbl", "業務用更新機能ＩＤ");
        exStringEquals(henkouRirekiList.get(9).getGyoumuKousinsyaId(),"junit", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testExec_A4() {

        String pHenkouSikibetuKey = "0030";
        String syoNo1 = "17806000035";
        String syoNo2 = "17806000046";

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo1);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo1);
        IT_SyuunouHenknRireki syuunouHenknRireki = ansyuKihon.getSyuunouHenknRirekis().get(0);
        IT_NyuukinKakusyouData nyuukinKakusyouData = hozenDomManager.getNyuukinKakusyouDataBySyono(syoNo1).get(0);
        IT_Tokusin tokusin = hozenDomManager.getAnsyuKihon(syoNo2).getTokusin();
        IT_Kariukekin kariukekin = kykKihon.getKariukekins().get(0);

        EditKhHenkouRirekiTblForNyuukinBean pEditKhHkRrkTblForNyknBean = new EditKhHenkouRirekiTblForNyuukinBean();

        pEditKhHkRrkTblForNyknBean.setHenkouSikibetuKey(pHenkouSikibetuKey);
        pEditKhHkRrkTblForNyknBean.setKykKihonSyoriAto(kykKihon);
        pEditKhHkRrkTblForNyknBean.setAnsyuKihonSyoriAto(ansyuKihon);
        pEditKhHkRrkTblForNyknBean.setNyuukinKakusyouDataSyoriAto(nyuukinKakusyouData);
        pEditKhHkRrkTblForNyknBean.setAnsyuKihonSyoriMae(ansyuKihon);
        pEditKhHkRrkTblForNyknBean.setKykSyouhnSyoriMae(null);
        pEditKhHkRrkTblForNyknBean.setTokusinSyoriMae(tokusin);
        pEditKhHkRrkTblForNyknBean.setSyuunouHenknRirekiSyoriAto(syuunouHenknRireki);
        pEditKhHkRrkTblForNyknBean.setKariukekinSyoriAto(kariukekin);

        List<IT_KhHenkouRireki> henkouRirekiList =
            ansyuuEditKhHenkouRirekiTbl.editKhHenkouRirekiTblForNyuukin(pEditKhHkRrkTblForNyknBean);

        exNumericEquals(4, henkouRirekiList.size(), "契約保全変更履歴TBLエンティティリスト件数");

        exStringEquals(henkouRirekiList.get(0).getSyono(),"17806000035", "証券番号");
        exStringEquals(henkouRirekiList.get(0).getHenkousikibetukey(),"0030", "変更識別キー");
        exNumericEquals(henkouRirekiList.get(0).getRenno3keta(),1, "連番");
        exStringEquals(henkouRirekiList.get(0).getTablenm(),"入金確証データテーブル", "テーブル名称");
        exStringEquals(henkouRirekiList.get(0).getTableid(),"IT_NyuukinKakusyouData", "テーブルＩＤ");
        exClassificationEquals(henkouRirekiList.get(0).getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(henkouRirekiList.get(0).getHanbetukoumokunm(),"入金確証情報（入金確証番号：12345678903）", "判別項目名");
        exStringEquals(henkouRirekiList.get(0).getHenkoukoumokuid(),"", "変更項目ID");
        exStringEquals(henkouRirekiList.get(0).getHenkoukoumokunm(),"", "変更項目名");
        exStringEquals(henkouRirekiList.get(0).getBfrnaiyouoriginal(),"", "変更前内容原本");
        exStringEquals(henkouRirekiList.get(0).getBfrnaiyou(),"", "変更前内容");
        exStringEquals(henkouRirekiList.get(0).getNewnaiyouoriginal(),"", "変更後内容原本");
        exStringEquals(henkouRirekiList.get(0).getNewnaiyou(),
            "入金伝票日付：20180503／"
                + "束仮勘定番号：03／"
                + "入金経路：本社口座振込／"
                + "充当年月：／"
                + "充当回数（年）：18／"
                + "充当回数（月）：1／"
                + "領収日：20180601", "変更後内容");
        exStringEquals(henkouRirekiList.get(0).getGyoumuKousinKinou(),"AnsyuuEditKhHenkouRirekiTbl", "業務用更新機能ＩＤ");
        exStringEquals(henkouRirekiList.get(0).getGyoumuKousinsyaId(),"junit", "業務用更新者ＩＤ");

        exStringEquals(henkouRirekiList.get(1).getSyono(),"17806000035", "証券番号");
        exStringEquals(henkouRirekiList.get(1).getHenkousikibetukey(),"0030", "変更識別キー");
        exNumericEquals(henkouRirekiList.get(1).getRenno3keta(), 2, "連番");
        exStringEquals(henkouRirekiList.get(1).getTablenm(),"仮受金テーブル", "テーブル名称");
        exStringEquals(henkouRirekiList.get(1).getTableid(),"IT_Kariukekin", "テーブルＩＤ");
        exClassificationEquals(henkouRirekiList.get(1).getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(henkouRirekiList.get(1).getHanbetukoumokunm(),"仮受金情報（仮受番号：10003）", "判別項目名");
        exStringEquals(henkouRirekiList.get(1).getHenkoukoumokuid(),"", "変更項目ID");
        exStringEquals(henkouRirekiList.get(1).getHenkoukoumokunm(),"", "変更項目名");
        exStringEquals(henkouRirekiList.get(1).getBfrnaiyouoriginal(),"", "変更前内容原本");
        exStringEquals(henkouRirekiList.get(1).getBfrnaiyou(),"", "変更前内容");
        exStringEquals(henkouRirekiList.get(1).getNewnaiyouoriginal(),"", "変更後内容原本");
        exStringEquals(henkouRirekiList.get(1).getNewnaiyou(),
            "計上日：20180503／"
                + "金額：1000000000003／"
                + "仮受理由：充当回数相違／払方変更要Ｐ／"
                + "経路：本社口座振込／"
                + "充当年月：201807／"
                + "年数：18／"
                + "月数：5／"
                + "領収日：20180601", "変更後内容");
        exStringEquals(henkouRirekiList.get(1).getGyoumuKousinKinou(),"AnsyuuEditKhHenkouRirekiTbl", "業務用更新機能ＩＤ");
        exStringEquals(henkouRirekiList.get(1).getGyoumuKousinsyaId(),"junit", "業務用更新者ＩＤ");

        exStringEquals(henkouRirekiList.get(2).getSyono(),"17806000035", "証券番号");
        exStringEquals(henkouRirekiList.get(2).getHenkousikibetukey(),"0030", "変更識別キー");
        exNumericEquals(henkouRirekiList.get(2).getRenno3keta(), 3, "連番");
        exStringEquals(henkouRirekiList.get(2).getTablenm(),"収納返金履歴テーブル", "テーブル名称");
        exStringEquals(henkouRirekiList.get(2).getTableid(),"IT_SyuunouHenknRireki", "テーブルＩＤ");
        exClassificationEquals(henkouRirekiList.get(2).getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(henkouRirekiList.get(2).getHanbetukoumokunm(),"収納返金履歴情報（伝票データ連番：10000000003　枝番号：3）", "判別項目名");
        exStringEquals(henkouRirekiList.get(2).getHenkoukoumokuid(),"", "変更項目ID");
        exStringEquals(henkouRirekiList.get(2).getHenkoukoumokunm(),"", "変更項目名");
        exStringEquals(henkouRirekiList.get(2).getBfrnaiyouoriginal(),"", "変更前内容原本");
        exStringEquals(henkouRirekiList.get(2).getBfrnaiyou(),"", "変更前内容");
        exStringEquals(henkouRirekiList.get(2).getNewnaiyouoriginal(),"", "変更後内容原本");
        exStringEquals(henkouRirekiList.get(2).getNewnaiyou(),
            "支払日：20180503／"
                + "返金額：1000000000003／"
                + "理由：その他（申し出返金）／"
                + "銀行：1003／"
                + "支店：203／通知／"
                + "口座番号：100000000001／口座名義人氏名（カナ）口座名義人氏名", "変更後内容");
        exStringEquals(henkouRirekiList.get(2).getGyoumuKousinKinou(),"AnsyuuEditKhHenkouRirekiTbl", "業務用更新機能ＩＤ");
        exStringEquals(henkouRirekiList.get(2).getGyoumuKousinsyaId(),"junit", "業務用更新者ＩＤ");

        exStringEquals(henkouRirekiList.get(3).getSyono(),"17806000035", "証券番号");
        exStringEquals(henkouRirekiList.get(3).getHenkousikibetukey(),"0030", "変更識別キー");
        exNumericEquals(henkouRirekiList.get(3).getRenno3keta(), 4, "連番");
        exStringEquals(henkouRirekiList.get(3).getTablenm(),"特伸テーブル", "テーブル名称");
        exStringEquals(henkouRirekiList.get(3).getTableid(),"IT_Tokusin", "テーブルＩＤ");
        exClassificationEquals(henkouRirekiList.get(3).getHnksyuruikbn(), C_HnkSyuruiKbn.SAKUJYO, "変更種類区分");
        exStringEquals(henkouRirekiList.get(3).getHanbetukoumokunm(),"特伸情報", "判別項目名");
        exStringEquals(henkouRirekiList.get(3).getHenkoukoumokuid(),"", "変更項目ID");
        exStringEquals(henkouRirekiList.get(3).getHenkoukoumokunm(),"", "変更項目名");
        exStringEquals(henkouRirekiList.get(3).getBfrnaiyouoriginal(),"", "変更前内容原本");
        exStringEquals(henkouRirekiList.get(3).getBfrnaiyou(),
            "特伸区分：その他（猶予期間延長）／"
                + "特伸処理年月日：20180501／"
                + "特伸終了年月日：20180701", "変更前内容");
        exStringEquals(henkouRirekiList.get(3).getNewnaiyouoriginal(),"", "変更後内容原本");
        exStringEquals(henkouRirekiList.get(3).getNewnaiyou(), "", "変更後内容");
        exStringEquals(henkouRirekiList.get(3).getGyoumuKousinKinou(),"AnsyuuEditKhHenkouRirekiTbl", "業務用更新機能ＩＤ");
        exStringEquals(henkouRirekiList.get(3).getGyoumuKousinsyaId(),"junit", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testExec_A5() {

        String pHenkouSikibetuKey = "0050";
        String syoNo = "17806000057";
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo);
        IT_SyuunouHenknRireki pSyuunouHenknRirekiSyoriAto = ansyuKihon.getSyuunouHenknRirekis().get(0);
        IT_Kariukekin pKariukekinSyoriAto = kykKihon.getKariukekins().get(0);

        EditKhHenkouRirekiTblForNyuukinBean pEditKhHkRrkTblForNyknBean = new EditKhHenkouRirekiTblForNyuukinBean();

        pEditKhHkRrkTblForNyknBean.setHenkouSikibetuKey(pHenkouSikibetuKey);
        pEditKhHkRrkTblForNyknBean.setKykKihonSyoriAto(kykKihon);
        pEditKhHkRrkTblForNyknBean.setAnsyuKihonSyoriAto(ansyuKihon);
        pEditKhHkRrkTblForNyknBean.setNyuukinKakusyouDataSyoriAto(null);
        pEditKhHkRrkTblForNyknBean.setAnsyuKihonSyoriMae(ansyuKihon);
        pEditKhHkRrkTblForNyknBean.setKykSyouhnSyoriMae(null);
        pEditKhHkRrkTblForNyknBean.setTokusinSyoriMae(null);
        pEditKhHkRrkTblForNyknBean.setSyuunouHenknRirekiSyoriAto(pSyuunouHenknRirekiSyoriAto);
        pEditKhHkRrkTblForNyknBean.setKariukekinSyoriAto(pKariukekinSyoriAto);

        List<IT_KhHenkouRireki> henkouRirekiList =
            ansyuuEditKhHenkouRirekiTbl.editKhHenkouRirekiTblForNyuukin(pEditKhHkRrkTblForNyknBean);

        exNumericEquals(2, henkouRirekiList.size(), "契約保全変更履歴TBLエンティティリスト件数");

        exStringEquals(henkouRirekiList.get(0).getSyono(),"17806000057", "証券番号");
        exStringEquals(henkouRirekiList.get(0).getHenkousikibetukey(),"0050", "変更識別キー");
        exNumericEquals(henkouRirekiList.get(0).getRenno3keta(), 1, "連番");
        exStringEquals(henkouRirekiList.get(0).getTablenm(),"仮受金テーブル", "テーブル名称");
        exStringEquals(henkouRirekiList.get(0).getTableid(),"IT_Kariukekin", "テーブルＩＤ");
        exClassificationEquals(henkouRirekiList.get(0).getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(henkouRirekiList.get(0).getHanbetukoumokunm(),"仮受金情報（仮受番号：10005）", "判別項目名");
        exStringEquals(henkouRirekiList.get(0).getHenkoukoumokuid(),"", "変更項目ID");
        exStringEquals(henkouRirekiList.get(0).getHenkoukoumokunm(),"", "変更項目名");
        exStringEquals(henkouRirekiList.get(0).getBfrnaiyouoriginal(),"", "変更前内容原本");
        exStringEquals(henkouRirekiList.get(0).getBfrnaiyou(),"", "変更前内容");
        exStringEquals(henkouRirekiList.get(0).getNewnaiyouoriginal(),"", "変更後内容原本");
        exStringEquals(henkouRirekiList.get(0).getNewnaiyou(),
            "計上日：20180505／"
                + "金額：1000000000005／"
                + "仮受理由：猶予期間後入／保全変更による追徴金／"
                + "経路：機械作成／"
                + "充当年月：201805／"
                + "年数：18／"
                + "月数：5／"
                + "領収日：20180601", "変更後内容");
        exStringEquals(henkouRirekiList.get(0).getGyoumuKousinKinou(),"AnsyuuEditKhHenkouRirekiTbl", "業務用更新機能ＩＤ");
        exStringEquals(henkouRirekiList.get(0).getGyoumuKousinsyaId(),"junit", "業務用更新者ＩＤ");

        exStringEquals(henkouRirekiList.get(1).getSyono(),"17806000057", "証券番号");
        exStringEquals(henkouRirekiList.get(1).getHenkousikibetukey(),"0050", "変更識別キー");
        exNumericEquals(henkouRirekiList.get(1).getRenno3keta(), 2, "連番");
        exStringEquals(henkouRirekiList.get(1).getTablenm(),"収納返金履歴テーブル", "テーブル名称");
        exStringEquals(henkouRirekiList.get(1).getTableid(),"IT_SyuunouHenknRireki", "テーブルＩＤ");
        exClassificationEquals(henkouRirekiList.get(1).getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(henkouRirekiList.get(1).getHanbetukoumokunm(),"収納返金履歴情報（伝票データ連番：10000000005　枝番号：5）", "判別項目名");
        exStringEquals(henkouRirekiList.get(1).getHenkoukoumokuid(),"", "変更項目ID");
        exStringEquals(henkouRirekiList.get(1).getHenkoukoumokunm(),"", "変更項目名");
        exStringEquals(henkouRirekiList.get(1).getBfrnaiyouoriginal(),"", "変更前内容原本");
        exStringEquals(henkouRirekiList.get(1).getBfrnaiyou(),"", "変更前内容");
        exStringEquals(henkouRirekiList.get(1).getNewnaiyouoriginal(),"", "変更後内容原本");
        exStringEquals(henkouRirekiList.get(1).getNewnaiyou(),
            "支払日：20180505／"
                + "返金額：1000000000005／"
                + "理由：その他（申し出返金）／"
                + "銀行：1005／"
                + "支店：205／定期／"
                + "口座番号：100000000001／口座名義人氏名口座名義人氏名（カナ）", "変更後内容");
        exStringEquals(henkouRirekiList.get(1).getGyoumuKousinKinou(),"AnsyuuEditKhHenkouRirekiTbl", "業務用更新機能ＩＤ");
        exStringEquals(henkouRirekiList.get(1).getGyoumuKousinsyaId(),"junit", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testExec_A6() {

        String pHenkouSikibetuKey = "0060";
        String syoNo = "17806000068";
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo);
        IT_SyuunouHenknRireki pSyuunouHenknRirekiSyoriAto = ansyuKihon.getSyuunouHenknRirekis().get(0);
        IT_Kariukekin pKariukekinSyoriAto = null;

        EditKhHenkouRirekiTblForNyuukinBean pEditKhHkRrkTblForNyknBean = new EditKhHenkouRirekiTblForNyuukinBean();

        pEditKhHkRrkTblForNyknBean.setHenkouSikibetuKey(pHenkouSikibetuKey);
        pEditKhHkRrkTblForNyknBean.setKykKihonSyoriAto(kykKihon);
        pEditKhHkRrkTblForNyknBean.setAnsyuKihonSyoriAto(ansyuKihon);
        pEditKhHkRrkTblForNyknBean.setNyuukinKakusyouDataSyoriAto(null);
        pEditKhHkRrkTblForNyknBean.setAnsyuKihonSyoriMae(ansyuKihon);
        pEditKhHkRrkTblForNyknBean.setKykSyouhnSyoriMae(null);
        pEditKhHkRrkTblForNyknBean.setKariukekinSyoriAto(null);
        pEditKhHkRrkTblForNyknBean.setTokusinSyoriMae(null);
        pEditKhHkRrkTblForNyknBean.setSyuunouHenknRirekiSyoriAto(pSyuunouHenknRirekiSyoriAto);

        List<IT_KhHenkouRireki> henkouRirekiList =
            ansyuuEditKhHenkouRirekiTbl.editKhHenkouRirekiTblForNyuukin(pEditKhHkRrkTblForNyknBean);

        exNumericEquals(1, henkouRirekiList.size(), "契約保全変更履歴TBLエンティティリスト件数");

        exStringEquals(henkouRirekiList.get(0).getSyono(),"17806000068", "証券番号");
        exStringEquals(henkouRirekiList.get(0).getHenkousikibetukey(),"0060", "変更識別キー");
        exNumericEquals(henkouRirekiList.get(0).getRenno3keta(), 1, "連番");
        exStringEquals(henkouRirekiList.get(0).getTablenm(),"収納返金履歴テーブル", "テーブル名称");
        exStringEquals(henkouRirekiList.get(0).getTableid(),"IT_SyuunouHenknRireki", "テーブルＩＤ");
        exClassificationEquals(henkouRirekiList.get(0).getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(henkouRirekiList.get(0).getHanbetukoumokunm(),"収納返金履歴情報（伝票データ連番：10000000006　枝番号：5）", "判別項目名");
        exStringEquals(henkouRirekiList.get(0).getHenkoukoumokuid(),"", "変更項目ID");
        exStringEquals(henkouRirekiList.get(0).getHenkoukoumokunm(),"", "変更項目名");
        exStringEquals(henkouRirekiList.get(0).getBfrnaiyouoriginal(),"", "変更前内容原本");
        exStringEquals(henkouRirekiList.get(0).getBfrnaiyou(),"", "変更前内容");
        exStringEquals(henkouRirekiList.get(0).getNewnaiyouoriginal(),"", "変更後内容原本");
        exStringEquals(henkouRirekiList.get(0).getNewnaiyou(),
            "支払日：20180505／"
                + "返金額：1000000000005／"
                + "理由：その他（申し出返金）／"
                + "クレカ決済用番号：6212263400001110121", "変更後内容");
        exStringEquals(henkouRirekiList.get(0).getGyoumuKousinKinou(),"AnsyuuEditKhHenkouRirekiTbl", "業務用更新機能ＩＤ");
        exStringEquals(henkouRirekiList.get(0).getGyoumuKousinsyaId(),"junit", "業務用更新者ＩＤ");
    }
}
