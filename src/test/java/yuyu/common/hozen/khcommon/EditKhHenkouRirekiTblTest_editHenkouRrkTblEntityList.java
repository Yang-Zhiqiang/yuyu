package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.classification.C_HnkSyuruiKbn;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_BAK_AnsyuKihon;
import yuyu.def.db.entity.IT_BAK_KykKihon;
import yuyu.def.db.entity.IT_KhHenkouRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全変更履歴TBL編集クラスの変更項目リスト編集処理メソッド {@link EditKhHenkouRirekiTbl#editHenkouRrkTblEntityList(String,String,C_HnkSyuruiKbn,String,LinkedList<String[]>)} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class EditKhHenkouRirekiTblTest_editHenkouRrkTblEntityList extends AbstractTest{

    @Inject
    private HozenDomManager hozenManager;

    @Inject
    private EditKhHenkouRirekiTbl editKhHenkouRirekiTbl;

    private final static String fileName = "UT_SP_単体テスト仕様書_契約保全変更履歴TBL編集";

    private final static String sheetName = "テストデータ";

    @Test
    @TestOrder(2010)
    @Transactional
    public void EditKhHenkouRirekiTbl_editHenkouRrkTblEntityList_2_1() {
        IT_KykKihon kykkihon = hozenManager.getKykKihon("30806223459");
        IT_BAK_KykKihon bakKykkihon = hozenManager.getBAKKykKihon("30806223459","123");
        IT_AnsyuKihon ansyukihon = hozenManager.getAnsyuKihon("30806223459");
        IT_BAK_AnsyuKihon bakAnsyukihon = hozenManager.getBAKAnsyuKihon("30806223459","123");

        List<IT_KhHenkouRireki> result = editKhHenkouRirekiTbl.exec(kykkihon, bakKykkihon, ansyukihon, bakAnsyukihon, null, "100");

        exStringEquals(result.get(0).getSyono(),"30806223459","証券番号");
        exStringEquals(result.get(0).getHenkousikibetukey(),"100","変更識別キー");
        exNumericEquals(result.get(0).getRenno3keta(),1,"連番");
        exStringEquals(result.get(0).getTablenm(),"契約基本テーブル","テーブル名称");
        exStringEquals(result.get(0).getTableid(),"IT_KykKihon","テーブルＩＤ");
        exClassificationEquals(result.get(0).getHnksyuruikbn(),C_HnkSyuruiKbn.valueOf("2"),"変更種類区分");
        exStringEquals(result.get(0).getHanbetukoumokunm(),"契約基本情報","判別項目名");
        exStringEquals(result.get(0).getHenkoukoumokuid(),"haitoukbn","変更項目ID");
        exStringEquals(result.get(0).getHenkoukoumokunm(),"配当区分","変更項目名");
        exStringEquals(result.get(0).getBfrnaiyouoriginal(),"1","変更前内容原本");
        exStringEquals(result.get(0).getBfrnaiyou(),"有配","変更前内容");
        exStringEquals(result.get(0).getNewnaiyouoriginal(),"2","変更後内容原本");
        exStringEquals(result.get(0).getNewnaiyou(),"利差配","変更後内容");
        exStringEquals(result.get(0).getGyoumuKousinKinou(),"EditKhHenkouRirekiTblTest_editHenkouRrkTblEntityLi","業務用更新機能ＩＤ");
        exStringEquals(result.get(0).getGyoumuKousinsyaId(),"JUnit","業務用更新者ＩＤ");
        exStringEquals(result.get(1).getSyono(),"30806223459","証券番号");
        exStringEquals(result.get(1).getHenkousikibetukey(),"100","変更識別キー");
        exNumericEquals(result.get(1).getRenno3keta(),2,"連番");
        exStringEquals(result.get(1).getTablenm(),"契約者テーブル","テーブル名称");
        exStringEquals(result.get(1).getTableid(),"IT_KykSya","テーブルＩＤ");
        exClassificationEquals(result.get(1).getHnksyuruikbn(),C_HnkSyuruiKbn.valueOf("2"),"変更種類区分");
        exStringEquals(result.get(1).getHanbetukoumokunm(),"契約基本情報","判別項目名");
        exStringEquals(result.get(1).getHenkoukoumokuid(),"kyknmkn","変更項目ID");
        exStringEquals(result.get(1).getHenkoukoumokunm(),"契約者名（カナ）","変更項目名");
        exStringEquals(result.get(1).getBfrnaiyouoriginal(),"契約名カナ（本ＴＢＬ）","変更前内容原本");
        exStringEquals(result.get(1).getBfrnaiyou(),"契約名カナ（本ＴＢＬ）","変更前内容");
        exStringEquals(result.get(1).getNewnaiyouoriginal(),"契約名カナ（ＢＴＢＬ）","変更後内容原本");
        exStringEquals(result.get(1).getNewnaiyou(),"契約名カナ（ＢＴＢＬ）","変更後内容");
        exStringEquals(result.get(1).getGyoumuKousinKinou(),"EditKhHenkouRirekiTblTest_editHenkouRrkTblEntityLi","業務用更新機能ＩＤ");
        exStringEquals(result.get(1).getGyoumuKousinsyaId(),"JUnit","業務用更新者ＩＤ");
        exStringEquals(result.get(2).getSyono(),"30806223459","証券番号");
        exStringEquals(result.get(2).getHenkousikibetukey(),"100","変更識別キー");
        exNumericEquals(result.get(2).getRenno3keta(),3,"連番");
        exStringEquals(result.get(2).getTablenm(),"契約者テーブル","テーブル名称");
        exStringEquals(result.get(2).getTableid(),"IT_KykSya","テーブルＩＤ");
        exClassificationEquals(result.get(2).getHnksyuruikbn(),C_HnkSyuruiKbn.valueOf("2"),"変更種類区分");
        exStringEquals(result.get(2).getHanbetukoumokunm(),"契約基本情報","判別項目名");
        exStringEquals(result.get(2).getHenkoukoumokuid(),"kyknmkjkhukakbn","変更項目ID");
        exStringEquals(result.get(2).getHenkoukoumokunm(),"契約者名漢字化不可区分","変更項目名");
        exStringEquals(result.get(2).getBfrnaiyouoriginal(),"0","変更前内容原本");
        exStringEquals(result.get(2).getBfrnaiyou(),"","変更前内容");
        exStringEquals(result.get(2).getNewnaiyouoriginal(),"1","変更後内容原本");
        exStringEquals(result.get(2).getNewnaiyou(),"漢字化不可","変更後内容");
        exStringEquals(result.get(2).getGyoumuKousinKinou(),"EditKhHenkouRirekiTblTest_editHenkouRrkTblEntityLi","業務用更新機能ＩＤ");
        exStringEquals(result.get(2).getGyoumuKousinsyaId(),"JUnit","業務用更新者ＩＤ");
        exStringEquals(result.get(3).getSyono(),"30806223459","証券番号");
        exStringEquals(result.get(3).getHenkousikibetukey(),"100","変更識別キー");
        exNumericEquals(result.get(3).getRenno3keta(),4,"連番");
        exStringEquals(result.get(3).getTablenm(),"被保険者テーブル","テーブル名称");
        exStringEquals(result.get(3).getTableid(),"IT_HhknSya","テーブルＩＤ");
        exClassificationEquals(result.get(3).getHnksyuruikbn(),C_HnkSyuruiKbn.valueOf("2"),"変更種類区分");
        exStringEquals(result.get(3).getHanbetukoumokunm(),"契約基本情報","判別項目名");
        exStringEquals(result.get(3).getHenkoukoumokuid(),"hhknnmkjkhukakbn","変更項目ID");
        exStringEquals(result.get(3).getHenkoukoumokunm(),"被保険者名漢字化不可区分","変更項目名");
        exStringEquals(result.get(3).getBfrnaiyouoriginal(),"0","変更前内容原本");
        exStringEquals(result.get(3).getBfrnaiyou(),"","変更前内容");
        exStringEquals(result.get(3).getNewnaiyouoriginal(),"1","変更後内容原本");
        exStringEquals(result.get(3).getNewnaiyou(),"漢字化不可","変更後内容");
        exStringEquals(result.get(3).getGyoumuKousinKinou(),"EditKhHenkouRirekiTblTest_editHenkouRrkTblEntityLi","業務用更新機能ＩＤ");
        exStringEquals(result.get(3).getGyoumuKousinsyaId(),"JUnit","業務用更新者ＩＤ");
        exStringEquals(result.get(4).getSyono(),"30806223459","証券番号");
        exStringEquals(result.get(4).getHenkousikibetukey(),"100","変更識別キー");
        exNumericEquals(result.get(4).getRenno3keta(),5,"連番");
        exStringEquals(result.get(4).getTablenm(),"被保険者テーブル","テーブル名称");
        exStringEquals(result.get(4).getTableid(),"IT_HhknSya","テーブルＩＤ");
        exClassificationEquals(result.get(4).getHnksyuruikbn(),C_HnkSyuruiKbn.valueOf("2"),"変更種類区分");
        exStringEquals(result.get(4).getHanbetukoumokunm(),"契約基本情報","判別項目名");
        exStringEquals(result.get(4).getHenkoukoumokuid(),"hhknnmkn","変更項目ID");
        exStringEquals(result.get(4).getHenkoukoumokunm(),"被保険者名（カナ）","変更項目名");
        exStringEquals(result.get(4).getBfrnaiyouoriginal(),"被保険者名（ＴＢＬ）","変更前内容原本");
        exStringEquals(result.get(4).getBfrnaiyou(),"被保険者名（ＴＢＬ）","変更前内容");
        exStringEquals(result.get(4).getNewnaiyouoriginal(),"被保険者名（本ＴＢＬ）","変更後内容原本");
        exStringEquals(result.get(4).getNewnaiyou(),"被保険者名（本ＴＢＬ）","変更後内容");
        exStringEquals(result.get(4).getGyoumuKousinKinou(),"EditKhHenkouRirekiTblTest_editHenkouRrkTblEntityLi","業務用更新機能ＩＤ");
        exStringEquals(result.get(4).getGyoumuKousinsyaId(),"JUnit","業務用更新者ＩＤ");
        exStringEquals(result.get(5).getSyono(),"30806223459","証券番号");
        exStringEquals(result.get(5).getHenkousikibetukey(),"100","変更識別キー");
        exNumericEquals(result.get(5).getRenno3keta(),6,"連番");
        exStringEquals(result.get(5).getTablenm(),"被保険者テーブル","テーブル名称");
        exStringEquals(result.get(5).getTableid(),"IT_HhknSya","テーブルＩＤ");
        exClassificationEquals(result.get(5).getHnksyuruikbn(),C_HnkSyuruiKbn.valueOf("2"),"変更種類区分");
        exStringEquals(result.get(5).getHanbetukoumokunm(),"契約基本情報","判別項目名");
        exStringEquals(result.get(5).getHenkoukoumokuid(),"hhknsei","変更項目ID");
        exStringEquals(result.get(5).getHenkoukoumokunm(),"被保険者性別","変更項目名");
        exStringEquals(result.get(5).getBfrnaiyouoriginal(),"1","変更前内容原本");
        exStringEquals(result.get(5).getBfrnaiyou(),"男性","変更前内容");
        exStringEquals(result.get(5).getNewnaiyouoriginal(),"2","変更後内容原本");
        exStringEquals(result.get(5).getNewnaiyou(),"女性","変更後内容");
        exStringEquals(result.get(5).getGyoumuKousinKinou(),"EditKhHenkouRirekiTblTest_editHenkouRrkTblEntityLi","業務用更新機能ＩＤ");
        exStringEquals(result.get(5).getGyoumuKousinsyaId(),"JUnit","業務用更新者ＩＤ");
        exStringEquals(result.get(6).getSyono(),"30806223459","証券番号");
        exStringEquals(result.get(6).getHenkousikibetukey(),"100","変更識別キー");
        exNumericEquals(result.get(6).getRenno3keta(),7,"連番");
        exStringEquals(result.get(6).getTablenm(),"契約その他特約テーブル","テーブル名称");
        exStringEquals(result.get(6).getTableid(),"IT_KykSonotaTkyk","テーブルＩＤ");
        exClassificationEquals(result.get(6).getHnksyuruikbn(),C_HnkSyuruiKbn.valueOf("2"),"変更種類区分");
        exStringEquals(result.get(6).getHanbetukoumokunm(),"その他特約情報","判別項目名");
        exStringEquals(result.get(6).getHenkoukoumokuid(),"stdrsktkyhkymd","変更項目ID");
        exStringEquals(result.get(6).getHenkoukoumokunm(),"被保険者代理特約付加日","変更項目名");
        exStringEquals(result.get(6).getBfrnaiyouoriginal(),"20161028","変更前内容原本");
        exStringEquals(result.get(6).getBfrnaiyou(),"20161028","変更前内容");
        exStringEquals(result.get(6).getNewnaiyouoriginal(),"20161027","変更後内容原本");
        exStringEquals(result.get(6).getNewnaiyou(),"20161027","変更後内容");
        exStringEquals(result.get(6).getGyoumuKousinKinou(),"EditKhHenkouRirekiTblTest_editHenkouRrkTblEntityLi","業務用更新機能ＩＤ");
        exStringEquals(result.get(6).getGyoumuKousinsyaId(),"JUnit","業務用更新者ＩＤ");
        exStringEquals(result.get(7).getSyono(),"30806223459","証券番号");
        exStringEquals(result.get(7).getHenkousikibetukey(),"100","変更識別キー");
        exNumericEquals(result.get(7).getRenno3keta(),8,"連番");
        exStringEquals(result.get(7).getTablenm(),"契約その他特約テーブル","テーブル名称");
        exStringEquals(result.get(7).getTableid(),"IT_KykSonotaTkyk","テーブルＩＤ");
        exClassificationEquals(result.get(7).getHnksyuruikbn(),C_HnkSyuruiKbn.valueOf("2"),"変更種類区分");
        exStringEquals(result.get(7).getHanbetukoumokunm(),"その他特約情報","判別項目名");
        exStringEquals(result.get(7).getHenkoukoumokuid(),"livingneedshukaumu","変更項目ID");
        exStringEquals(result.get(7).getHenkoukoumokunm(),"リビングニーズ特約付加有無","変更項目名");
        exStringEquals(result.get(7).getBfrnaiyouoriginal(),"0","変更前内容原本");
        exStringEquals(result.get(7).getBfrnaiyou(),"なし","変更前内容");
        exStringEquals(result.get(7).getNewnaiyouoriginal(),"1","変更後内容原本");
        exStringEquals(result.get(7).getNewnaiyou(),"あり","変更後内容");
        exStringEquals(result.get(7).getGyoumuKousinKinou(),"EditKhHenkouRirekiTblTest_editHenkouRrkTblEntityLi","業務用更新機能ＩＤ");
        exStringEquals(result.get(7).getGyoumuKousinsyaId(),"JUnit","業務用更新者ＩＤ");
        exStringEquals(result.get(8).getSyono(),"30806223459","証券番号");
        exStringEquals(result.get(8).getHenkousikibetukey(),"100","変更識別キー");
        exNumericEquals(result.get(8).getRenno3keta(),9,"連番");
        exStringEquals(result.get(8).getTablenm(),"契約その他特約テーブル","テーブル名称");
        exStringEquals(result.get(8).getTableid(),"IT_KykSonotaTkyk","テーブルＩＤ");
        exClassificationEquals(result.get(8).getHnksyuruikbn(),C_HnkSyuruiKbn.valueOf("2"),"変更種類区分");
        exStringEquals(result.get(8).getHanbetukoumokunm(),"その他特約情報","判別項目名");
        exStringEquals(result.get(8).getHenkoukoumokuid(),"yennykntkhkumu","変更項目ID");
        exStringEquals(result.get(8).getHenkoukoumokunm(),"円入金特約付加有無","変更項目名");
        exStringEquals(result.get(8).getBfrnaiyouoriginal(),"0","変更前内容原本");
        exStringEquals(result.get(8).getBfrnaiyou(),"なし","変更前内容");
        exStringEquals(result.get(8).getNewnaiyouoriginal(),"1","変更後内容原本");
        exStringEquals(result.get(8).getNewnaiyou(),"あり","変更後内容");
        exStringEquals(result.get(8).getGyoumuKousinKinou(),"EditKhHenkouRirekiTblTest_editHenkouRrkTblEntityLi","業務用更新機能ＩＤ");
        exStringEquals(result.get(8).getGyoumuKousinsyaId(),"JUnit","業務用更新者ＩＤ");
        exStringEquals(result.get(9).getSyono(),"30806223459","証券番号");
        exStringEquals(result.get(9).getHenkousikibetukey(),"100","変更識別キー");
        exNumericEquals(result.get(9).getRenno3keta(),10,"連番");
        exStringEquals(result.get(9).getTablenm(),"契約その他特約テーブル","テーブル名称");
        exStringEquals(result.get(9).getTableid(),"IT_KykSonotaTkyk","テーブルＩＤ");
        exClassificationEquals(result.get(9).getHnksyuruikbn(),C_HnkSyuruiKbn.valueOf("2"),"変更種類区分");
        exStringEquals(result.get(9).getHanbetukoumokunm(),"その他特約情報","判別項目名");
        exStringEquals(result.get(9).getHenkoukoumokuid(),"stdrsktkyhkumu","変更項目ID");
        exStringEquals(result.get(9).getHenkoukoumokunm(),"被保険者代理特約付加有無","変更項目名");
        exStringEquals(result.get(9).getBfrnaiyouoriginal(),"0","変更前内容原本");
        exStringEquals(result.get(9).getBfrnaiyou(),"なし","変更前内容");
        exStringEquals(result.get(9).getNewnaiyouoriginal(),"1","変更後内容原本");
        exStringEquals(result.get(9).getNewnaiyou(),"あり","変更後内容");
        exStringEquals(result.get(9).getGyoumuKousinKinou(),"EditKhHenkouRirekiTblTest_editHenkouRrkTblEntityLi","業務用更新機能ＩＤ");
        exStringEquals(result.get(9).getGyoumuKousinsyaId(),"JUnit","業務用更新者ＩＤ");
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditKhHenkouRirekiTblTest_editHenkouRrkTblEntityList.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ003", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        deleteTestDatas();
        MockObjectManager.initialize();
    }

    public static void deleteTestDatas() {

        HozenDomManager hozenManager = SWAKInjector.getInstance(HozenDomManager.class);

        String[] syonos = {"30806223459"};

        for (String syono:syonos) {
            IT_KykKihon kykkihon = hozenManager.getKykKihon(syono);
            if(kykkihon != null){
                hozenManager.delete(kykkihon);
            }
            IT_BAK_KykKihon bakkykkihon = hozenManager.getBAKKykKihon(syono,"123");
            if(bakkykkihon != null){
                hozenManager.delete(bakkykkihon);
            }
            IT_AnsyuKihon ansyukihon = hozenManager.getAnsyuKihon(syono);
            if(ansyukihon != null){
                hozenManager.delete(ansyukihon);
            }
            IT_BAK_AnsyuKihon bakansyukihon = hozenManager.getBAKAnsyuKihon(syono,"123");
            if(bakansyukihon != null){
                hozenManager.delete(bakansyukihon);
            }
        }
    }

}
