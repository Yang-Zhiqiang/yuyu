package yuyu.common.direct.dscommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.classification.C_DsKokyakuJtKbn;
import yuyu.def.classification.C_DsSyoriKbn;
import yuyu.def.classification.C_HnkSyuruiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.MT_BAK_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsHenkouRireki;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsTtdkRireki;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＤＳ手続履歴テーブル編集クラスのメソッド {@link DsTetudukiRirekiTableEdit#editDSTtdkRirekiTblBatch()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblBatch {

    private final static String DSKOKNO1 = "2000000001";

    private final static String DSKOKNO2 = "2000000002";

    private final static String DSKOKNO3 = "2000000003";

    private final static String DSKOKNO4 = "2000000004";

    private final static String DSKOKNO5 = "2000000005";

    @Inject
    private DsTetudukiRirekiTableEdit editDSTtdkRirekiTbl;

    @Inject
    private DirectDomManager directDomManager;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_ＤＳ手続履歴テーブル編集";

    private final static String sheetName = "INデータ_20170803";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblBatch.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("準備データ１", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);
        directDomManager.delete(directDomManager.getAllDsKokyakuKanri());
        directDomManager.delete(directDomManager.getAllBAKDsKokyakuKanri());
    }

    @Test(expected = BizAppException.class)
    @Transactional
    @TestOrder(10)
    public void testEditDSTtdkRirekiTblBatch_A1() {

        DsTetudukiRirekiTableEditParam dsTetudukiRirekiTableEditParam = new DsTetudukiRirekiTableEditParamImpl();
        dsTetudukiRirekiTableEditParam.setDskokno("2000000000");
        dsTetudukiRirekiTableEditParam.setHenkouRrkYouhi(C_YouhiKbn.HUYOU);

        try{
            editDSTtdkRirekiTbl.editDSTtdkRirekiTblBatch(dsTetudukiRirekiTableEditParam);
        }
        catch (BizAppException e) {
            exStringEquals(e.getMessage(), "テーブル取得エラー　MT_DsKokyakuKanri　key:dskokno=2000000000", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testEditDSTtdkRirekiTblBatch_A2() {

        DsTetudukiRirekiTableEditParam dsTetudukiRirekiTableEditParam = new DsTetudukiRirekiTableEditParamImpl();
        dsTetudukiRirekiTableEditParam.setDskokno("2000000001");
        dsTetudukiRirekiTableEditParam.setHenkousikibetukey("400000000000000001");
        dsTetudukiRirekiTableEditParam.setSyoriYmd(BizDate.valueOf("2016/04/13"));
        dsTetudukiRirekiTableEditParam.setDssyorikbn(C_DsSyoriKbn.LOGIN_SEIKOU);
        dsTetudukiRirekiTableEditParam.setHenkouRrkYouhi(C_YouhiKbn.HUYOU);
        dsTetudukiRirekiTableEditParam.setDsKokyakuKanri(directDomManager.getDsKokyakuKanri(DSKOKNO1));

        editDSTtdkRirekiTbl.editDSTtdkRirekiTblBatch(dsTetudukiRirekiTableEditParam);

        MT_DsKokyakuKanri dsKokyakuKanri = directDomManager.getDsKokyakuKanri(dsTetudukiRirekiTableEditParam.getDskokno());

        List<MT_DsTtdkRireki> dsTtdkRirekiLst = dsKokyakuKanri.getDsTtdkRirekis();

        exNumericEquals(dsTtdkRirekiLst.size(), 1, "ＤＳ手続履歴情報件数");

        MT_DsTtdkRireki dsTtdkRireki = dsTtdkRirekiLst.get(0);
        exStringEquals(dsTtdkRireki.getDskokno(), "2000000001", "ＤＳ手続履歴テーブルエンティティ．ＤＳ顧客番号");
        exStringEquals(dsTtdkRireki.getHenkousikibetukey(), "400000000000000001", "ＤＳ手続履歴テーブルエンティティ．変更識別キー");
        exDateEquals(dsTtdkRireki.getSyoriYmd(), BizDate.valueOf("2016/04/13"), "ＤＳ手続履歴テーブルエンティティ．処理年月日");
        exClassificationEquals(dsTtdkRireki.getDssyorikbn(), C_DsSyoriKbn.LOGIN_SEIKOU, "ＤＳ手続履歴テーブルエンティティ．ＤＳ処理区分");
        exClassificationEquals(dsTtdkRireki.getHenkourrkumu(), C_UmuKbn.NONE, "ＤＳ手続履歴テーブルエンティティ．変更履歴有無");
        exStringEquals(dsTtdkRireki.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "ＤＳ手続履歴テーブルエンティティ．業務用更新機能ＩＤ");
        exStringEquals(dsTtdkRireki.getGyoumuKousinsyaId(), "JUnit", "ＤＳ手続履歴テーブルエンティティ．業務用更新者ＩＤ");

        List<MT_DsHenkouRireki> dsHenkouRirekiLst = dsTtdkRireki.getDsHenkouRirekis();
        exNumericEquals(dsHenkouRirekiLst.size(), 0, "ＤＳ変更履歴情報件数");
    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testEditDSTtdkRirekiTblBatch_A3() {

        DsTetudukiRirekiTableEditParam dsTetudukiRirekiTableEditParam = new DsTetudukiRirekiTableEditParamImpl();
        dsTetudukiRirekiTableEditParam.setDskokno("2000000002");
        dsTetudukiRirekiTableEditParam.setHenkousikibetukey("400000000000000002");
        dsTetudukiRirekiTableEditParam.setSyoriYmd(BizDate.valueOf("2016/04/13"));
        dsTetudukiRirekiTableEditParam.setDssyorikbn(C_DsSyoriKbn.LOGIN_SEIKOU);
        dsTetudukiRirekiTableEditParam.setHenkouRrkYouhi(C_YouhiKbn.YOU);
        dsTetudukiRirekiTableEditParam.setDsKokyakuKanri(directDomManager.getDsKokyakuKanri(DSKOKNO2));

        editDSTtdkRirekiTbl.editDSTtdkRirekiTblBatch(dsTetudukiRirekiTableEditParam);

        MT_DsKokyakuKanri dsKokyakuKanri = directDomManager.getDsKokyakuKanri(dsTetudukiRirekiTableEditParam.getDskokno());

        List<MT_DsTtdkRireki> dsTtdkRirekiLst = dsKokyakuKanri.getDsTtdkRirekis();

        exNumericEquals(dsTtdkRirekiLst.size(), 1, "ＤＳ手続履歴情報件数");

        MT_DsTtdkRireki dsTtdkRireki = dsTtdkRirekiLst.get(0);
        exStringEquals(dsTtdkRireki.getDskokno(), "2000000002", "ＤＳ手続履歴テーブルエンティティ．ＤＳ顧客番号");
        exStringEquals(dsTtdkRireki.getHenkousikibetukey(), "400000000000000002", "ＤＳ手続履歴テーブルエンティティ．変更識別キー");
        exDateEquals(dsTtdkRireki.getSyoriYmd(), BizDate.valueOf("2016/04/13"), "ＤＳ手続履歴テーブルエンティティ．処理年月日");
        exClassificationEquals(dsTtdkRireki.getDssyorikbn(), C_DsSyoriKbn.LOGIN_SEIKOU, "ＤＳ手続履歴テーブルエンティティ．ＤＳ処理区分");
        exClassificationEquals(dsTtdkRireki.getHenkourrkumu(), C_UmuKbn.ARI, "ＤＳ手続履歴テーブルエンティティ．変更履歴有無");
        exStringEquals(dsTtdkRireki.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "ＤＳ手続履歴テーブルエンティティ．業務用更新機能ＩＤ");
        exStringEquals(dsTtdkRireki.getGyoumuKousinsyaId(), "JUnit", "ＤＳ手続履歴テーブルエンティティ．業務用更新者ＩＤ");

        List<MT_DsHenkouRireki> dsHenkouRirekiLst = dsTtdkRireki.getDsHenkouRirekis();
        exNumericEquals(dsHenkouRirekiLst.size(), 5, "ＤＳ変更履歴情報件数");

        MT_DsHenkouRireki dsHenkouRireki1 = dsHenkouRirekiLst.get(0);
        exStringEquals(dsHenkouRireki1.getDskokno(), "2000000002", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki1.getHenkousikibetukey(), "400000000000000002", "変更識別キー");
        exNumericEquals(dsHenkouRireki1.getRenno(), 1, "連番");
        exStringEquals(dsHenkouRireki1.getTablenm(), "ＤＳ顧客管理テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki1.getTableid(), "MT_DsKokyakuKanri", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki1.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki1.getHanbetukoumokunm(), "ＤＳ顧客管理情報", "判別項目名");
        exStringEquals(dsHenkouRireki1.getHenkoukoumokuid(), "dskokno", "変更項目ID");
        exStringEquals(dsHenkouRireki1.getHenkoukoumokunm(), "ＤＳ顧客番号", "変更項目名");
        exStringEquals(dsHenkouRireki1.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki1.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki1.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki1.getNewnaiyou(), "2000000002", "変更後内容");
        exStringEquals(dsHenkouRireki1.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki1.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki2 = dsHenkouRirekiLst.get(1);
        exStringEquals(dsHenkouRireki2.getDskokno(), "2000000002", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki2.getHenkousikibetukey(), "400000000000000002", "変更識別キー");
        exNumericEquals(dsHenkouRireki2.getRenno(), 2, "連番");
        exStringEquals(dsHenkouRireki2.getTablenm(), "ＤＳ顧客契約テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki2.getTableid(), "MT_DsKokyakuKeiyaku", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki2.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki2.getHanbetukoumokunm(), "ＤＳ顧客契約情報　証券番号：17806000091", "判別項目名");
        exStringEquals(dsHenkouRireki2.getHenkoukoumokuid(), "syono", "変更項目ID");
        exStringEquals(dsHenkouRireki2.getHenkoukoumokunm(), "証券番号", "変更項目名");
        exStringEquals(dsHenkouRireki2.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki2.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki2.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki2.getNewnaiyou(), "証券番号：17806000091", "変更後内容");
        exStringEquals(dsHenkouRireki2.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki2.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki3 = dsHenkouRirekiLst.get(2);
        exStringEquals(dsHenkouRireki3.getDskokno(), "2000000002", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki3.getHenkousikibetukey(), "400000000000000002", "変更識別キー");
        exNumericEquals(dsHenkouRireki3.getRenno(), 3, "連番");
        exStringEquals(dsHenkouRireki3.getTablenm(), "ＤＳ本人確認コードテーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki3.getTableid(), "MT_DsHonninKakuninCd", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki3.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki3.getHanbetukoumokunm(), "ＤＳ本人確認コード情報", "判別項目名");
        exStringEquals(dsHenkouRireki3.getHenkoukoumokuid(), "dskokno", "変更項目ID");
        exStringEquals(dsHenkouRireki3.getHenkoukoumokunm(), "ＤＳ顧客番号", "変更項目名");
        exStringEquals(dsHenkouRireki3.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki3.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki3.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki3.getNewnaiyou(), "2000000002", "変更後内容");
        exStringEquals(dsHenkouRireki3.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki3.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki4 = dsHenkouRirekiLst.get(3);
        exStringEquals(dsHenkouRireki4.getDskokno(), "2000000002", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki4.getHenkousikibetukey(), "400000000000000002", "変更識別キー");
        exNumericEquals(dsHenkouRireki4.getRenno(), 4, "連番");
        exStringEquals(dsHenkouRireki4.getTablenm(), "ＤＳログイン管理テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki4.getTableid(), "MT_DsLoginKanri", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki4.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki4.getHanbetukoumokunm(), "ＤＳログイン管理情報", "判別項目名");
        exStringEquals(dsHenkouRireki4.getHenkoukoumokuid(), "dskokno", "変更項目ID");
        exStringEquals(dsHenkouRireki4.getHenkoukoumokunm(), "ＤＳ顧客番号", "変更項目名");
        exStringEquals(dsHenkouRireki4.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki4.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki4.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki4.getNewnaiyou(), "2000000002", "変更後内容");
        exStringEquals(dsHenkouRireki4.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki4.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki5 = dsHenkouRirekiLst.get(4);
        exStringEquals(dsHenkouRireki5.getDskokno(), "2000000002", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki5.getHenkousikibetukey(), "400000000000000002", "変更識別キー");
        exNumericEquals(dsHenkouRireki5.getRenno(), 5, "連番");
        exStringEquals(dsHenkouRireki5.getTablenm(), "ＤＳメールアドレステーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki5.getTableid(), "MT_DsMailAddress", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki5.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki5.getHanbetukoumokunm(), "ＤＳメールアドレス情報　ＤＳメールアドレス連番：100000016", "判別項目名");
        exStringEquals(dsHenkouRireki5.getHenkoukoumokuid(), "dskokno", "変更項目ID");
        exStringEquals(dsHenkouRireki5.getHenkoukoumokunm(), "ＤＳ顧客番号", "変更項目名");
        exStringEquals(dsHenkouRireki5.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki5.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki5.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki5.getNewnaiyou(), "ＤＳ顧客番号：2000000002", "変更後内容");
        exStringEquals(dsHenkouRireki5.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki5.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testEditDSTtdkRirekiTblBatch_A4() {

        DsTetudukiRirekiTableEditParam dsTetudukiRirekiTableEditParam = new DsTetudukiRirekiTableEditParamImpl();
        dsTetudukiRirekiTableEditParam.setDskokno("2000000003");
        dsTetudukiRirekiTableEditParam.setHenkousikibetukey("400000000000000003");
        dsTetudukiRirekiTableEditParam.setSyoriYmd(BizDate.valueOf("2016/04/13"));
        dsTetudukiRirekiTableEditParam.setDssyorikbn(C_DsSyoriKbn.LOGIN_SEIKOU);
        dsTetudukiRirekiTableEditParam.setHenkouRrkYouhi(C_YouhiKbn.YOU);
        MT_DsKokyakuKanri entity = directDomManager.getDsKokyakuKanri(DSKOKNO3);
        entity.setDskokyakujtkbn(C_DsKokyakuJtKbn.ITIJI_TEISI);
        dsTetudukiRirekiTableEditParam.setDsKokyakuKanri(entity);
        MT_BAK_DsKokyakuKanri bakEntity = directDomManager.getBAKDsKokyakuKanri(DSKOKNO3, "400000000000000003");
        bakEntity.setDskokyakujtkbn(C_DsKokyakuJtKbn.YUUKOU);
        dsTetudukiRirekiTableEditParam.setBakDsKokyakuKanri(bakEntity);

        editDSTtdkRirekiTbl.editDSTtdkRirekiTblBatch(dsTetudukiRirekiTableEditParam);

        MT_DsKokyakuKanri dsKokyakuKanri = directDomManager.getDsKokyakuKanri(dsTetudukiRirekiTableEditParam.getDskokno());

        List<MT_DsTtdkRireki> dsTtdkRirekiLst = dsKokyakuKanri.getDsTtdkRirekis();

        exNumericEquals(dsTtdkRirekiLst.size(), 1, "ＤＳ手続履歴情報件数");

        MT_DsTtdkRireki dsTtdkRireki = dsTtdkRirekiLst.get(0);
        exStringEquals(dsTtdkRireki.getDskokno(), "2000000003", "ＤＳ手続履歴テーブルエンティティ．ＤＳ顧客番号");
        exStringEquals(dsTtdkRireki.getHenkousikibetukey(), "400000000000000003", "ＤＳ手続履歴テーブルエンティティ．変更識別キー");
        exDateEquals(dsTtdkRireki.getSyoriYmd(), BizDate.valueOf("2016/04/13"), "ＤＳ手続履歴テーブルエンティティ．処理年月日");
        exClassificationEquals(dsTtdkRireki.getDssyorikbn(), C_DsSyoriKbn.LOGIN_SEIKOU, "ＤＳ手続履歴テーブルエンティティ．ＤＳ処理区分");
        exClassificationEquals(dsTtdkRireki.getHenkourrkumu(), C_UmuKbn.ARI, "ＤＳ手続履歴テーブルエンティティ．変更履歴有無");
        exStringEquals(dsTtdkRireki.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "ＤＳ手続履歴テーブルエンティティ．業務用更新機能ＩＤ");
        exStringEquals(dsTtdkRireki.getGyoumuKousinsyaId(), "JUnit", "ＤＳ手続履歴テーブルエンティティ．業務用更新者ＩＤ");

        List<MT_DsHenkouRireki> dsHenkouRirekiLst = dsTtdkRireki.getDsHenkouRirekis();
        exNumericEquals(dsHenkouRirekiLst.size(), 11, "ＤＳ変更履歴情報件数");

        MT_DsHenkouRireki dsHenkouRireki1 = dsHenkouRirekiLst.get(0);
        exStringEquals(dsHenkouRireki1.getDskokno(), "2000000003", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki1.getHenkousikibetukey(), "400000000000000003", "変更識別キー");
        exNumericEquals(dsHenkouRireki1.getRenno(), 1, "連番");
        exStringEquals(dsHenkouRireki1.getTablenm(), "ＤＳ顧客管理テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki1.getTableid(), "MT_DsKokyakuKanri", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki1.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki1.getHanbetukoumokunm(), "ＤＳ顧客管理情報", "判別項目名");
        exStringEquals(dsHenkouRireki1.getHenkoukoumokuid(), "dskokyakujtkbn", "変更項目ID");
        exStringEquals(dsHenkouRireki1.getHenkoukoumokunm(), "ＤＳ顧客状態区分", "変更項目名");
        exStringEquals(dsHenkouRireki1.getBfrnaiyouoriginal(), "1", "変更前内容原本");
        exStringEquals(dsHenkouRireki1.getBfrnaiyou(), "有効取引中", "変更前内容");
        exStringEquals(dsHenkouRireki1.getNewnaiyouoriginal(), "2", "変更後内容原本");
        exStringEquals(dsHenkouRireki1.getNewnaiyou(), "一時停止", "変更後内容");
        exStringEquals(dsHenkouRireki1.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki1.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki2 = dsHenkouRirekiLst.get(1);
        exStringEquals(dsHenkouRireki2.getDskokno(), "2000000003", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki2.getHenkousikibetukey(), "400000000000000003", "変更識別キー");
        exNumericEquals(dsHenkouRireki2.getRenno(), 2, "連番");
        exStringEquals(dsHenkouRireki2.getTablenm(), "ＤＳ顧客管理テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki2.getTableid(), "MT_DsKokyakuKanri", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki2.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki2.getHanbetukoumokunm(), "ＤＳ顧客管理情報", "判別項目名");
        exStringEquals(dsHenkouRireki2.getHenkoukoumokuid(), "dskanyuukeirokbn", "変更項目ID");
        exStringEquals(dsHenkouRireki2.getHenkoukoumokunm(), "ＤＳ加入経路区分", "変更項目名");
        exStringEquals(dsHenkouRireki2.getBfrnaiyouoriginal(), "1", "変更前内容原本");
        exStringEquals(dsHenkouRireki2.getBfrnaiyou(), "新契約同時", "変更前内容");
        exStringEquals(dsHenkouRireki2.getNewnaiyouoriginal(), "2", "変更後内容原本");
        exStringEquals(dsHenkouRireki2.getNewnaiyou(), "中途加入", "変更後内容");
        exStringEquals(dsHenkouRireki2.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki2.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki3 = dsHenkouRirekiLst.get(2);
        exStringEquals(dsHenkouRireki3.getDskokno(), "2000000003", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki3.getHenkousikibetukey(), "400000000000000003", "変更識別キー");
        exNumericEquals(dsHenkouRireki3.getRenno(), 3, "連番");
        exStringEquals(dsHenkouRireki3.getTablenm(), "ＤＳ顧客契約テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki3.getTableid(), "MT_DsKokyakuKeiyaku", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki3.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki3.getHanbetukoumokunm(), "ＤＳ顧客契約情報　証券番号：17806000105", "判別項目名");
        exStringEquals(dsHenkouRireki3.getHenkoukoumokuid(), "dskykkanyuuymd", "変更項目ID");
        exStringEquals(dsHenkouRireki3.getHenkoukoumokunm(), "ＤＳ契約加入年月日", "変更項目名");
        exStringEquals(dsHenkouRireki3.getBfrnaiyouoriginal(), "20160313", "変更前内容原本");
        exStringEquals(dsHenkouRireki3.getBfrnaiyou(), "20160313", "変更前内容");
        exStringEquals(dsHenkouRireki3.getNewnaiyouoriginal(), "20160317", "変更後内容原本");
        exStringEquals(dsHenkouRireki3.getNewnaiyou(), "20160317", "変更後内容");
        exStringEquals(dsHenkouRireki3.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki3.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki4 = dsHenkouRirekiLst.get(3);
        exStringEquals(dsHenkouRireki4.getDskokno(), "2000000003", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki4.getHenkousikibetukey(), "400000000000000003", "変更識別キー");
        exNumericEquals(dsHenkouRireki4.getRenno(), 4, "連番");
        exStringEquals(dsHenkouRireki4.getTablenm(), "ＤＳ顧客契約テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki4.getTableid(), "MT_DsKokyakuKeiyaku", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki4.getHnksyuruikbn(), C_HnkSyuruiKbn.SAKUJYO, "変更種類区分");
        exStringEquals(dsHenkouRireki4.getHanbetukoumokunm(), "ＤＳ顧客契約情報　証券番号：17806000127", "判別項目名");
        exStringEquals(dsHenkouRireki4.getHenkoukoumokuid(), "syono", "変更項目ID");
        exStringEquals(dsHenkouRireki4.getHenkoukoumokunm(), "証券番号", "変更項目名");
        exStringEquals(dsHenkouRireki4.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki4.getBfrnaiyou(), "証券番号：17806000127", "変更前内容");
        exStringEquals(dsHenkouRireki4.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki4.getNewnaiyou(), "", "変更後内容");
        exStringEquals(dsHenkouRireki4.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki4.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki5 = dsHenkouRirekiLst.get(4);
        exStringEquals(dsHenkouRireki5.getDskokno(), "2000000003", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki5.getHenkousikibetukey(), "400000000000000003", "変更識別キー");
        exNumericEquals(dsHenkouRireki5.getRenno(), 5, "連番");
        exStringEquals(dsHenkouRireki5.getTablenm(), "ＤＳ顧客契約テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki5.getTableid(), "MT_DsKokyakuKeiyaku", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki5.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki5.getHanbetukoumokunm(), "ＤＳ顧客契約情報　証券番号：17806000116", "判別項目名");
        exStringEquals(dsHenkouRireki5.getHenkoukoumokuid(), "syono", "変更項目ID");
        exStringEquals(dsHenkouRireki5.getHenkoukoumokunm(), "証券番号", "変更項目名");
        exStringEquals(dsHenkouRireki5.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki5.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki5.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki5.getNewnaiyou(), "証券番号：17806000116", "変更後内容");
        exStringEquals(dsHenkouRireki5.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki5.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki6 = dsHenkouRirekiLst.get(5);
        exStringEquals(dsHenkouRireki6.getDskokno(), "2000000003", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki6.getHenkousikibetukey(), "400000000000000003", "変更識別キー");
        exNumericEquals(dsHenkouRireki6.getRenno(), 6, "連番");
        exStringEquals(dsHenkouRireki6.getTablenm(), "ＤＳ本人確認コードテーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki6.getTableid(), "MT_DsHonninKakuninCd", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki6.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki6.getHanbetukoumokunm(), "ＤＳ本人確認コード情報", "判別項目名");
        exStringEquals(dsHenkouRireki6.getHenkoukoumokuid(), "dskrhnnkakcd", "変更項目ID");
        exStringEquals(dsHenkouRireki6.getHenkoukoumokunm(), "ＤＳ仮本人確認コード", "変更項目名");
        exStringEquals(dsHenkouRireki6.getBfrnaiyouoriginal(), "***", "変更前内容原本");
        exStringEquals(dsHenkouRireki6.getBfrnaiyou(), "***", "変更前内容");
        exStringEquals(dsHenkouRireki6.getNewnaiyouoriginal(), "***", "変更後内容原本");
        exStringEquals(dsHenkouRireki6.getNewnaiyou(), "***", "変更後内容");
        exStringEquals(dsHenkouRireki6.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki6.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki7 = dsHenkouRirekiLst.get(6);
        exStringEquals(dsHenkouRireki7.getDskokno(), "2000000003", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki7.getHenkousikibetukey(), "400000000000000003", "変更識別キー");
        exNumericEquals(dsHenkouRireki7.getRenno(), 7, "連番");
        exStringEquals(dsHenkouRireki7.getTablenm(), "ＤＳ本人確認コードテーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki7.getTableid(), "MT_DsHonninKakuninCd", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki7.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki7.getHanbetukoumokunm(), "ＤＳ本人確認コード情報", "判別項目名");
        exStringEquals(dsHenkouRireki7.getHenkoukoumokuid(), "dskrhnnkakcdttyhkbn", "変更項目ID");
        exStringEquals(dsHenkouRireki7.getHenkoukoumokunm(), "ＤＳ仮本人確認コード通知要否区分", "変更項目名");
        exStringEquals(dsHenkouRireki7.getBfrnaiyouoriginal(), "1", "変更前内容原本");
        exStringEquals(dsHenkouRireki7.getBfrnaiyou(), "要", "変更前内容");
        exStringEquals(dsHenkouRireki7.getNewnaiyouoriginal(), "2", "変更後内容原本");
        exStringEquals(dsHenkouRireki7.getNewnaiyou(), "中断", "変更後内容");
        exStringEquals(dsHenkouRireki7.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki7.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki8 = dsHenkouRirekiLst.get(7);
        exStringEquals(dsHenkouRireki8.getDskokno(), "2000000003", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki8.getHenkousikibetukey(), "400000000000000003", "変更識別キー");
        exNumericEquals(dsHenkouRireki8.getRenno(), 8, "連番");
        exStringEquals(dsHenkouRireki8.getTablenm(), "ＤＳ本人確認コードテーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki8.getTableid(), "MT_DsHonninKakuninCd", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki8.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki8.getHanbetukoumokunm(), "ＤＳ本人確認コード情報", "判別項目名");
        exStringEquals(dsHenkouRireki8.getHenkoukoumokuid(), "dskrhnnkakcdtttydnjykbn", "変更項目ID");
        exStringEquals(dsHenkouRireki8.getHenkoukoumokunm(), "ＤＳ仮本人確認コード通知中断事由区分", "変更項目名");
        exStringEquals(dsHenkouRireki8.getBfrnaiyouoriginal(), "11", "変更前内容原本");
        exStringEquals(dsHenkouRireki8.getBfrnaiyou(), "名寄せ不可（住所変更中）", "変更前内容");
        exStringEquals(dsHenkouRireki8.getNewnaiyouoriginal(), "12", "変更後内容原本");
        exStringEquals(dsHenkouRireki8.getNewnaiyou(), "名寄せ不可（住所変更中、名義変更中）", "変更後内容");
        exStringEquals(dsHenkouRireki8.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki8.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki9 = dsHenkouRirekiLst.get(8);
        exStringEquals(dsHenkouRireki9.getDskokno(), "2000000003", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki9.getHenkousikibetukey(), "400000000000000003", "変更識別キー");
        exNumericEquals(dsHenkouRireki9.getRenno(), 9, "連番");
        exStringEquals(dsHenkouRireki9.getTablenm(), "ＤＳログイン管理テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki9.getTableid(), "MT_DsLoginKanri", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki9.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki9.getHanbetukoumokunm(), "ＤＳログイン管理情報", "判別項目名");
        exStringEquals(dsHenkouRireki9.getHenkoukoumokuid(), "syokailoginymd", "変更項目ID");
        exStringEquals(dsHenkouRireki9.getHenkoukoumokunm(), "初回ログイン年月日", "変更項目名");
        exStringEquals(dsHenkouRireki9.getBfrnaiyouoriginal(), "20150419", "変更前内容原本");
        exStringEquals(dsHenkouRireki9.getBfrnaiyou(), "20150419", "変更前内容");
        exStringEquals(dsHenkouRireki9.getNewnaiyouoriginal(), "20150519", "変更後内容原本");
        exStringEquals(dsHenkouRireki9.getNewnaiyou(), "20150519", "変更後内容");
        exStringEquals(dsHenkouRireki9.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki9.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki10 = dsHenkouRirekiLst.get(9);
        exStringEquals(dsHenkouRireki10.getDskokno(), "2000000003", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki10.getHenkousikibetukey(), "400000000000000003", "変更識別キー");
        exNumericEquals(dsHenkouRireki10.getRenno(), 10, "連番");
        exStringEquals(dsHenkouRireki10.getTablenm(), "ＤＳメールアドレステーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki10.getTableid(), "MT_DsMailAddress", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki10.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki10.getHanbetukoumokunm(), "ＤＳメールアドレス情報　ＤＳメールアドレス連番：200000007", "判別項目名");
        exStringEquals(dsHenkouRireki10.getHenkoukoumokuid(), "dsmailaddress", "変更項目ID");
        exStringEquals(dsHenkouRireki10.getHenkoukoumokunm(), "ＤＳメールアドレス", "変更項目名");
        exStringEquals(dsHenkouRireki10.getBfrnaiyouoriginal(), "bbbb@co.jp", "変更前内容原本");
        exStringEquals(dsHenkouRireki10.getBfrnaiyou(), "bbbb@co.jp", "変更前内容");
        exStringEquals(dsHenkouRireki10.getNewnaiyouoriginal(), "aaaa@co.jp", "変更後内容原本");
        exStringEquals(dsHenkouRireki10.getNewnaiyou(), "aaaa@co.jp", "変更後内容");
        exStringEquals(dsHenkouRireki10.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki10.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki11 = dsHenkouRirekiLst.get(10);
        exStringEquals(dsHenkouRireki11.getDskokno(), "2000000003", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki11.getHenkousikibetukey(), "400000000000000003", "変更識別キー");
        exNumericEquals(dsHenkouRireki11.getRenno(), 11, "連番");
        exStringEquals(dsHenkouRireki11.getTablenm(), "ＤＳメールアドレステーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki11.getTableid(), "MT_DsMailAddress", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki11.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki11.getHanbetukoumokunm(), "ＤＳメールアドレス情報　ＤＳメールアドレス連番：200000008", "判別項目名");
        exStringEquals(dsHenkouRireki11.getHenkoukoumokuid(), "dskokno", "変更項目ID");
        exStringEquals(dsHenkouRireki11.getHenkoukoumokunm(), "ＤＳ顧客番号", "変更項目名");
        exStringEquals(dsHenkouRireki11.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki11.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki11.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki11.getNewnaiyou(), "ＤＳ顧客番号：2000000003", "変更後内容");
        exStringEquals(dsHenkouRireki11.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki11.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testEditDSTtdkRirekiTblBatch_A5() {

        DsTetudukiRirekiTableEditParam dsTetudukiRirekiTableEditParam = new DsTetudukiRirekiTableEditParamImpl();
        dsTetudukiRirekiTableEditParam.setDskokno("2000000004");
        dsTetudukiRirekiTableEditParam.setHenkousikibetukey("400000000000000004");
        dsTetudukiRirekiTableEditParam.setSyoriYmd(BizDate.valueOf("2016/04/13"));
        dsTetudukiRirekiTableEditParam.setDssyorikbn(C_DsSyoriKbn.LOGIN_SEIKOU);
        dsTetudukiRirekiTableEditParam.setHenkouRrkYouhi(C_YouhiKbn.YOU);
        dsTetudukiRirekiTableEditParam.setDsKokyakuKanri(directDomManager.getDsKokyakuKanri(DSKOKNO4));

        editDSTtdkRirekiTbl.editDSTtdkRirekiTblBatch(dsTetudukiRirekiTableEditParam);

        MT_DsKokyakuKanri dsKokyakuKanri = directDomManager.getDsKokyakuKanri(dsTetudukiRirekiTableEditParam.getDskokno());

        List<MT_DsTtdkRireki> dsTtdkRirekiLst = dsKokyakuKanri.getDsTtdkRirekis();

        exNumericEquals(dsTtdkRirekiLst.size(), 1, "ＤＳ手続履歴情報件数");

        MT_DsTtdkRireki dsTtdkRireki = dsTtdkRirekiLst.get(0);
        exStringEquals(dsTtdkRireki.getDskokno(), "2000000004", "ＤＳ手続履歴テーブルエンティティ．ＤＳ顧客番号");
        exStringEquals(dsTtdkRireki.getHenkousikibetukey(), "400000000000000004", "ＤＳ手続履歴テーブルエンティティ．変更識別キー");
        exDateEquals(dsTtdkRireki.getSyoriYmd(), BizDate.valueOf("2016/04/13"), "ＤＳ手続履歴テーブルエンティティ．処理年月日");
        exClassificationEquals(dsTtdkRireki.getDssyorikbn(), C_DsSyoriKbn.LOGIN_SEIKOU, "ＤＳ手続履歴テーブルエンティティ．ＤＳ処理区分");
        exClassificationEquals(dsTtdkRireki.getHenkourrkumu(), C_UmuKbn.ARI, "ＤＳ手続履歴テーブルエンティティ．変更履歴有無");
        exStringEquals(dsTtdkRireki.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "ＤＳ手続履歴テーブルエンティティ．業務用更新機能ＩＤ");
        exStringEquals(dsTtdkRireki.getGyoumuKousinsyaId(), "JUnit", "ＤＳ手続履歴テーブルエンティティ．業務用更新者ＩＤ");

        List<MT_DsHenkouRireki> dsHenkouRirekiLst = dsTtdkRireki.getDsHenkouRirekis();
        exNumericEquals(dsHenkouRirekiLst.size(), 9, "ＤＳ変更履歴情報件数");

        MT_DsHenkouRireki dsHenkouRireki1 = dsHenkouRirekiLst.get(0);
        exStringEquals(dsHenkouRireki1.getDskokno(), "2000000004", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki1.getHenkousikibetukey(), "400000000000000004", "変更識別キー");
        exNumericEquals(dsHenkouRireki1.getRenno(), 1, "連番");
        exStringEquals(dsHenkouRireki1.getTablenm(), "ＤＳ顧客管理テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki1.getTableid(), "MT_DsKokyakuKanri", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki1.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki1.getHanbetukoumokunm(), "ＤＳ顧客管理情報", "判別項目名");
        exStringEquals(dsHenkouRireki1.getHenkoukoumokuid(), "dskokno", "変更項目ID");
        exStringEquals(dsHenkouRireki1.getHenkoukoumokunm(), "ＤＳ顧客番号", "変更項目名");
        exStringEquals(dsHenkouRireki1.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki1.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki1.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki1.getNewnaiyou(), "2000000004", "変更後内容");
        exStringEquals(dsHenkouRireki1.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki1.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki2 = dsHenkouRirekiLst.get(1);
        exStringEquals(dsHenkouRireki2.getDskokno(), "2000000004", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki2.getHenkousikibetukey(), "400000000000000004", "変更識別キー");
        exNumericEquals(dsHenkouRireki2.getRenno(), 2, "連番");
        exStringEquals(dsHenkouRireki2.getTablenm(), "ＤＳ顧客契約テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki2.getTableid(), "MT_DsKokyakuKeiyaku", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki2.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki2.getHanbetukoumokunm(), "ＤＳ顧客契約情報　証券番号：17806000138", "判別項目名");
        exStringEquals(dsHenkouRireki2.getHenkoukoumokuid(), "syono", "変更項目ID");
        exStringEquals(dsHenkouRireki2.getHenkoukoumokunm(), "証券番号", "変更項目名");
        exStringEquals(dsHenkouRireki2.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki2.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki2.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki2.getNewnaiyou(), "証券番号：17806000138", "変更後内容");
        exStringEquals(dsHenkouRireki2.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki2.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki3 = dsHenkouRirekiLst.get(2);
        exStringEquals(dsHenkouRireki3.getDskokno(), "2000000004", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki3.getHenkousikibetukey(), "400000000000000004", "変更識別キー");
        exNumericEquals(dsHenkouRireki3.getRenno(), 3, "連番");
        exStringEquals(dsHenkouRireki3.getTablenm(), "ＤＳ顧客契約テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki3.getTableid(), "MT_DsKokyakuKeiyaku", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki3.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki3.getHanbetukoumokunm(), "ＤＳ顧客契約情報　証券番号：17806000149", "判別項目名");
        exStringEquals(dsHenkouRireki3.getHenkoukoumokuid(), "syono", "変更項目ID");
        exStringEquals(dsHenkouRireki3.getHenkoukoumokunm(), "証券番号", "変更項目名");
        exStringEquals(dsHenkouRireki3.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki3.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki3.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki3.getNewnaiyou(), "証券番号：17806000149", "変更後内容");
        exStringEquals(dsHenkouRireki3.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki3.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki4 = dsHenkouRirekiLst.get(3);
        exStringEquals(dsHenkouRireki4.getDskokno(), "2000000004", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki4.getHenkousikibetukey(), "400000000000000004", "変更識別キー");
        exNumericEquals(dsHenkouRireki4.getRenno(), 4, "連番");
        exStringEquals(dsHenkouRireki4.getTablenm(), "ＤＳ顧客契約テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki4.getTableid(), "MT_DsKokyakuKeiyaku", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki4.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki4.getHanbetukoumokunm(), "ＤＳ顧客契約情報　証券番号：17806000150", "判別項目名");
        exStringEquals(dsHenkouRireki4.getHenkoukoumokuid(), "syono", "変更項目ID");
        exStringEquals(dsHenkouRireki4.getHenkoukoumokunm(), "証券番号", "変更項目名");
        exStringEquals(dsHenkouRireki4.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki4.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki4.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki4.getNewnaiyou(), "証券番号：17806000150", "変更後内容");
        exStringEquals(dsHenkouRireki4.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki4.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki5 = dsHenkouRirekiLst.get(4);
        exStringEquals(dsHenkouRireki5.getDskokno(), "2000000004", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki5.getHenkousikibetukey(), "400000000000000004", "変更識別キー");
        exNumericEquals(dsHenkouRireki5.getRenno(), 5, "連番");
        exStringEquals(dsHenkouRireki5.getTablenm(), "ＤＳ本人確認コードテーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki5.getTableid(), "MT_DsHonninKakuninCd", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki5.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki5.getHanbetukoumokunm(), "ＤＳ本人確認コード情報", "判別項目名");
        exStringEquals(dsHenkouRireki5.getHenkoukoumokuid(), "dskokno", "変更項目ID");
        exStringEquals(dsHenkouRireki5.getHenkoukoumokunm(), "ＤＳ顧客番号", "変更項目名");
        exStringEquals(dsHenkouRireki5.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki5.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki5.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki5.getNewnaiyou(), "2000000004", "変更後内容");
        exStringEquals(dsHenkouRireki5.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki5.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki6 = dsHenkouRirekiLst.get(5);
        exStringEquals(dsHenkouRireki6.getDskokno(), "2000000004", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki6.getHenkousikibetukey(), "400000000000000004", "変更識別キー");
        exNumericEquals(dsHenkouRireki6.getRenno(), 6, "連番");
        exStringEquals(dsHenkouRireki6.getTablenm(), "ＤＳログイン管理テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki6.getTableid(), "MT_DsLoginKanri", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki6.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki6.getHanbetukoumokunm(), "ＤＳログイン管理情報", "判別項目名");
        exStringEquals(dsHenkouRireki6.getHenkoukoumokuid(), "dskokno", "変更項目ID");
        exStringEquals(dsHenkouRireki6.getHenkoukoumokunm(), "ＤＳ顧客番号", "変更項目名");
        exStringEquals(dsHenkouRireki6.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki6.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki6.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki6.getNewnaiyou(), "2000000004", "変更後内容");
        exStringEquals(dsHenkouRireki6.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki6.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki7 = dsHenkouRirekiLst.get(6);
        exStringEquals(dsHenkouRireki7.getDskokno(), "2000000004", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki7.getHenkousikibetukey(), "400000000000000004", "変更識別キー");
        exNumericEquals(dsHenkouRireki7.getRenno(), 7, "連番");
        exStringEquals(dsHenkouRireki7.getTablenm(), "ＤＳメールアドレステーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki7.getTableid(), "MT_DsMailAddress", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki7.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki7.getHanbetukoumokunm(), "ＤＳメールアドレス情報　ＤＳメールアドレス連番：300000009", "判別項目名");
        exStringEquals(dsHenkouRireki7.getHenkoukoumokuid(), "dskokno", "変更項目ID");
        exStringEquals(dsHenkouRireki7.getHenkoukoumokunm(), "ＤＳ顧客番号", "変更項目名");
        exStringEquals(dsHenkouRireki7.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki7.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki7.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki7.getNewnaiyou(), "ＤＳ顧客番号：2000000004", "変更後内容");
        exStringEquals(dsHenkouRireki7.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki7.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki8 = dsHenkouRirekiLst.get(7);
        exStringEquals(dsHenkouRireki8.getDskokno(), "2000000004", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki8.getHenkousikibetukey(), "400000000000000004", "変更識別キー");
        exNumericEquals(dsHenkouRireki8.getRenno(), 8, "連番");
        exStringEquals(dsHenkouRireki8.getTablenm(), "ＤＳメールアドレステーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki8.getTableid(), "MT_DsMailAddress", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki8.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki8.getHanbetukoumokunm(), "ＤＳメールアドレス情報　ＤＳメールアドレス連番：300000010", "判別項目名");
        exStringEquals(dsHenkouRireki8.getHenkoukoumokuid(), "dskokno", "変更項目ID");
        exStringEquals(dsHenkouRireki8.getHenkoukoumokunm(), "ＤＳ顧客番号", "変更項目名");
        exStringEquals(dsHenkouRireki8.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki8.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki8.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki8.getNewnaiyou(), "ＤＳ顧客番号：2000000004", "変更後内容");
        exStringEquals(dsHenkouRireki8.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki8.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki9 = dsHenkouRirekiLst.get(8);
        exStringEquals(dsHenkouRireki9.getDskokno(), "2000000004", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki9.getHenkousikibetukey(), "400000000000000004", "変更識別キー");
        exNumericEquals(dsHenkouRireki9.getRenno(), 9, "連番");
        exStringEquals(dsHenkouRireki9.getTablenm(), "ＤＳメールアドレステーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki9.getTableid(), "MT_DsMailAddress", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki9.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki9.getHanbetukoumokunm(), "ＤＳメールアドレス情報　ＤＳメールアドレス連番：300000011", "判別項目名");
        exStringEquals(dsHenkouRireki9.getHenkoukoumokuid(), "dskokno", "変更項目ID");
        exStringEquals(dsHenkouRireki9.getHenkoukoumokunm(), "ＤＳ顧客番号", "変更項目名");
        exStringEquals(dsHenkouRireki9.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki9.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki9.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki9.getNewnaiyou(), "ＤＳ顧客番号：2000000004", "変更後内容");
        exStringEquals(dsHenkouRireki9.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki9.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testEditDSTtdkRirekiTblBatch_A6() {

        DsTetudukiRirekiTableEditParam dsTetudukiRirekiTableEditParam = new DsTetudukiRirekiTableEditParamImpl();
        dsTetudukiRirekiTableEditParam.setDskokno("2000000005");
        dsTetudukiRirekiTableEditParam.setHenkousikibetukey("400000000000000005");
        dsTetudukiRirekiTableEditParam.setSyoriYmd(BizDate.valueOf("2016/04/13"));
        dsTetudukiRirekiTableEditParam.setDssyorikbn(C_DsSyoriKbn.LOGIN_SEIKOU);
        dsTetudukiRirekiTableEditParam.setHenkouRrkYouhi(C_YouhiKbn.YOU);
        dsTetudukiRirekiTableEditParam.setDsKokyakuKanri(directDomManager.getDsKokyakuKanri(DSKOKNO5));

        editDSTtdkRirekiTbl.editDSTtdkRirekiTblBatch(dsTetudukiRirekiTableEditParam);

        MT_DsKokyakuKanri dsKokyakuKanri = directDomManager.getDsKokyakuKanri(dsTetudukiRirekiTableEditParam.getDskokno());

        List<MT_DsTtdkRireki> dsTtdkRirekiLst = dsKokyakuKanri.getDsTtdkRirekis();

        exNumericEquals(dsTtdkRirekiLst.size(), 1, "ＤＳ手続履歴情報件数");

        MT_DsTtdkRireki dsTtdkRireki = dsTtdkRirekiLst.get(0);
        exStringEquals(dsTtdkRireki.getDskokno(), "2000000005", "ＤＳ手続履歴テーブルエンティティ．ＤＳ顧客番号");
        exStringEquals(dsTtdkRireki.getHenkousikibetukey(), "400000000000000005", "ＤＳ手続履歴テーブルエンティティ．変更識別キー");
        exDateEquals(dsTtdkRireki.getSyoriYmd(), BizDate.valueOf("2016/04/13"), "ＤＳ手続履歴テーブルエンティティ．処理年月日");
        exClassificationEquals(dsTtdkRireki.getDssyorikbn(), C_DsSyoriKbn.LOGIN_SEIKOU, "ＤＳ手続履歴テーブルエンティティ．ＤＳ処理区分");
        exClassificationEquals(dsTtdkRireki.getHenkourrkumu(), C_UmuKbn.ARI, "ＤＳ手続履歴テーブルエンティティ．変更履歴有無");
        exStringEquals(dsTtdkRireki.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "ＤＳ手続履歴テーブルエンティティ．業務用更新機能ＩＤ");
        exStringEquals(dsTtdkRireki.getGyoumuKousinsyaId(), "JUnit", "ＤＳ手続履歴テーブルエンティティ．業務用更新者ＩＤ");

        List<MT_DsHenkouRireki> dsHenkouRirekiLst = dsTtdkRireki.getDsHenkouRirekis();
        exNumericEquals(dsHenkouRirekiLst.size(), 3, "ＤＳ変更履歴情報件数");

        MT_DsHenkouRireki dsHenkouRireki1 = dsHenkouRirekiLst.get(0);
        exStringEquals(dsHenkouRireki1.getDskokno(), "2000000005", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki1.getHenkousikibetukey(), "400000000000000005", "変更識別キー");
        exNumericEquals(dsHenkouRireki1.getRenno(), 1, "連番");
        exStringEquals(dsHenkouRireki1.getTablenm(), "ＤＳ顧客管理テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki1.getTableid(), "MT_DsKokyakuKanri", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki1.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki1.getHanbetukoumokunm(), "ＤＳ顧客管理情報", "判別項目名");
        exStringEquals(dsHenkouRireki1.getHenkoukoumokuid(), "dskokno", "変更項目ID");
        exStringEquals(dsHenkouRireki1.getHenkoukoumokunm(), "ＤＳ顧客番号", "変更項目名");
        exStringEquals(dsHenkouRireki1.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki1.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki1.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki1.getNewnaiyou(), "2000000005", "変更後内容");
        exStringEquals(dsHenkouRireki1.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki1.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki2 = dsHenkouRirekiLst.get(1);
        exStringEquals(dsHenkouRireki2.getDskokno(), "2000000005", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki2.getHenkousikibetukey(), "400000000000000005", "変更識別キー");
        exNumericEquals(dsHenkouRireki2.getRenno(), 2, "連番");
        exStringEquals(dsHenkouRireki2.getTablenm(), "ＤＳ本人確認コードテーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki2.getTableid(), "MT_DsHonninKakuninCd", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki2.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki2.getHanbetukoumokunm(), "ＤＳ本人確認コード情報", "判別項目名");
        exStringEquals(dsHenkouRireki2.getHenkoukoumokuid(), "dskokno", "変更項目ID");
        exStringEquals(dsHenkouRireki2.getHenkoukoumokunm(), "ＤＳ顧客番号", "変更項目名");
        exStringEquals(dsHenkouRireki2.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki2.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki2.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki2.getNewnaiyou(), "2000000005", "変更後内容");
        exStringEquals(dsHenkouRireki2.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki2.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki3 = dsHenkouRirekiLst.get(2);
        exStringEquals(dsHenkouRireki3.getDskokno(), "2000000005", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki3.getHenkousikibetukey(), "400000000000000005", "変更識別キー");
        exNumericEquals(dsHenkouRireki3.getRenno(), 3, "連番");
        exStringEquals(dsHenkouRireki3.getTablenm(), "ＤＳログイン管理テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki3.getTableid(), "MT_DsLoginKanri", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki3.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki3.getHanbetukoumokunm(), "ＤＳログイン管理情報", "判別項目名");
        exStringEquals(dsHenkouRireki3.getHenkoukoumokuid(), "dskokno", "変更項目ID");
        exStringEquals(dsHenkouRireki3.getHenkoukoumokunm(), "ＤＳ顧客番号", "変更項目名");
        exStringEquals(dsHenkouRireki3.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki3.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki3.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki3.getNewnaiyou(), "2000000005", "変更後内容");
        exStringEquals(dsHenkouRireki3.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki3.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @Transactional
    @TestOrder(70)
    public void testEditDSTtdkRirekiTblBatch_A7() {

        DsTetudukiRirekiTableEditParam dsTetudukiRirekiTableEditParam = new DsTetudukiRirekiTableEditParamImpl();
        dsTetudukiRirekiTableEditParam.setDskokno("2000000006");
        dsTetudukiRirekiTableEditParam.setHenkousikibetukey("400000000000000004");
        dsTetudukiRirekiTableEditParam.setSyoriYmd(BizDate.valueOf("2016/04/13"));
        dsTetudukiRirekiTableEditParam.setDssyorikbn(C_DsSyoriKbn.LOGIN_SEIKOU);
        dsTetudukiRirekiTableEditParam.setHenkouRrkYouhi(C_YouhiKbn.YOU);
        dsTetudukiRirekiTableEditParam.setDsKokyakuKanri(directDomManager.getDsKokyakuKanri("2000000006"));

        editDSTtdkRirekiTbl.editDSTtdkRirekiTblBatch(dsTetudukiRirekiTableEditParam);

        MT_DsKokyakuKanri dsKokyakuKanri = directDomManager.getDsKokyakuKanri(dsTetudukiRirekiTableEditParam.getDskokno());

        List<MT_DsTtdkRireki> dsTtdkRirekiLst = dsKokyakuKanri.getDsTtdkRirekis();
        exNumericEquals(dsTtdkRirekiLst.size(), 1, "ＤＳ手続履歴情報件数");
        MT_DsTtdkRireki dsTtdkRireki = dsTtdkRirekiLst.get(0);
        List<MT_DsHenkouRireki> dsHenkouRirekiLst = dsTtdkRireki.getDsHenkouRirekis();

        exNumericEquals(dsHenkouRirekiLst.size(), 12, "ＤＳ変更履歴情報件数");
        MT_DsHenkouRireki dsHenkouRireki1 = dsHenkouRirekiLst.get(0);
        exStringEquals(dsHenkouRireki1.getDskokno(), "2000000006", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki1.getHenkousikibetukey(), "400000000000000004", "変更識別キー");
        exNumericEquals(dsHenkouRireki1.getRenno(), 1, "連番");
        exStringEquals(dsHenkouRireki1.getTablenm(), "ＤＳ顧客管理テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki1.getTableid(), "MT_DsKokyakuKanri", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki1.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki1.getHanbetukoumokunm(), "ＤＳ顧客管理情報", "判別項目名");
        exStringEquals(dsHenkouRireki1.getHenkoukoumokuid(), "dskokno", "変更項目ID");
        exStringEquals(dsHenkouRireki1.getHenkoukoumokunm(), "ＤＳ顧客番号", "変更項目名");
        exStringEquals(dsHenkouRireki1.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki1.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki1.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki1.getNewnaiyou(), "2000000006", "変更後内容");
        exStringEquals(dsHenkouRireki1.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki1.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki2 = dsHenkouRirekiLst.get(1);
        exStringEquals(dsHenkouRireki2.getDskokno(), "2000000006", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki2.getHenkousikibetukey(), "400000000000000004", "変更識別キー");
        exNumericEquals(dsHenkouRireki2.getRenno(), 2, "連番");
        exStringEquals(dsHenkouRireki2.getTablenm(), "ＤＳ顧客契約テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki2.getTableid(), "MT_DsKokyakuKeiyaku", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki2.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki2.getHanbetukoumokunm(), "ＤＳ顧客契約情報　証券番号：17806000161", "判別項目名");
        exStringEquals(dsHenkouRireki2.getHenkoukoumokuid(), "syono", "変更項目ID");
        exStringEquals(dsHenkouRireki2.getHenkoukoumokunm(), "証券番号", "変更項目名");
        exStringEquals(dsHenkouRireki2.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki2.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki2.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki2.getNewnaiyou(), "証券番号：17806000161", "変更後内容");
        exStringEquals(dsHenkouRireki2.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki2.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki3 = dsHenkouRirekiLst.get(2);
        exStringEquals(dsHenkouRireki3.getDskokno(), "2000000006", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki3.getHenkousikibetukey(), "400000000000000004", "変更識別キー");
        exNumericEquals(dsHenkouRireki3.getRenno(), 3, "連番");
        exStringEquals(dsHenkouRireki3.getTablenm(), "ＤＳ顧客契約テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki3.getTableid(), "MT_DsKokyakuKeiyaku", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki3.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki3.getHanbetukoumokunm(), "ＤＳ顧客契約情報　証券番号：17806000172", "判別項目名");
        exStringEquals(dsHenkouRireki3.getHenkoukoumokuid(), "syono", "変更項目ID");
        exStringEquals(dsHenkouRireki3.getHenkoukoumokunm(), "証券番号", "変更項目名");
        exStringEquals(dsHenkouRireki3.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki3.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki3.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki3.getNewnaiyou(), "証券番号：17806000172", "変更後内容");
        exStringEquals(dsHenkouRireki3.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki3.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki4 = dsHenkouRirekiLst.get(3);
        exStringEquals(dsHenkouRireki4.getDskokno(), "2000000006", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki4.getHenkousikibetukey(), "400000000000000004", "変更識別キー");
        exNumericEquals(dsHenkouRireki4.getRenno(), 4, "連番");
        exStringEquals(dsHenkouRireki4.getTablenm(), "ＤＳ顧客契約テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki4.getTableid(), "MT_DsKokyakuKeiyaku", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki4.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki4.getHanbetukoumokunm(), "ＤＳ顧客契約情報　証券番号：17806000183", "判別項目名");
        exStringEquals(dsHenkouRireki4.getHenkoukoumokuid(), "syono", "変更項目ID");
        exStringEquals(dsHenkouRireki4.getHenkoukoumokunm(), "証券番号", "変更項目名");
        exStringEquals(dsHenkouRireki4.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki4.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki4.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki4.getNewnaiyou(), "証券番号：17806000183", "変更後内容");
        exStringEquals(dsHenkouRireki4.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki4.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki5 = dsHenkouRirekiLst.get(4);
        exStringEquals(dsHenkouRireki5.getDskokno(), "2000000006", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki5.getHenkousikibetukey(), "400000000000000004", "変更識別キー");
        exNumericEquals(dsHenkouRireki5.getRenno(), 5, "連番");
        exStringEquals(dsHenkouRireki5.getTablenm(), "ＤＳ本人確認コードテーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki5.getTableid(), "MT_DsHonninKakuninCd", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki5.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki5.getHanbetukoumokunm(), "ＤＳ本人確認コード情報", "判別項目名");
        exStringEquals(dsHenkouRireki5.getHenkoukoumokuid(), "dskokno", "変更項目ID");
        exStringEquals(dsHenkouRireki5.getHenkoukoumokunm(), "ＤＳ顧客番号", "変更項目名");
        exStringEquals(dsHenkouRireki5.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki5.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki5.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki5.getNewnaiyou(), "2000000006", "変更後内容");
        exStringEquals(dsHenkouRireki5.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki5.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki6 = dsHenkouRirekiLst.get(5);
        exStringEquals(dsHenkouRireki6.getDskokno(), "2000000006", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki6.getHenkousikibetukey(), "400000000000000004", "変更識別キー");
        exNumericEquals(dsHenkouRireki6.getRenno(), 6, "連番");
        exStringEquals(dsHenkouRireki6.getTablenm(), "ＤＳログイン管理テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki6.getTableid(), "MT_DsLoginKanri", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki6.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki6.getHanbetukoumokunm(), "ＤＳログイン管理情報", "判別項目名");
        exStringEquals(dsHenkouRireki6.getHenkoukoumokuid(), "dskokno", "変更項目ID");
        exStringEquals(dsHenkouRireki6.getHenkoukoumokunm(), "ＤＳ顧客番号", "変更項目名");
        exStringEquals(dsHenkouRireki6.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki6.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki6.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki6.getNewnaiyou(), "2000000006", "変更後内容");
        exStringEquals(dsHenkouRireki6.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki6.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki7 = dsHenkouRirekiLst.get(6);
        exStringEquals(dsHenkouRireki7.getDskokno(), "2000000006", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki7.getHenkousikibetukey(), "400000000000000004", "変更識別キー");
        exNumericEquals(dsHenkouRireki7.getRenno(), 7, "連番");
        exStringEquals(dsHenkouRireki7.getTablenm(), "ＤＳメールアドレステーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki7.getTableid(), "MT_DsMailAddress", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki7.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki7.getHanbetukoumokunm(), "ＤＳメールアドレス情報　ＤＳメールアドレス連番：300000012", "判別項目名");
        exStringEquals(dsHenkouRireki7.getHenkoukoumokuid(), "dskokno", "変更項目ID");
        exStringEquals(dsHenkouRireki7.getHenkoukoumokunm(), "ＤＳ顧客番号", "変更項目名");
        exStringEquals(dsHenkouRireki7.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki7.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki7.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki7.getNewnaiyou(), "ＤＳ顧客番号：2000000006", "変更後内容");
        exStringEquals(dsHenkouRireki7.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki7.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki8 = dsHenkouRirekiLst.get(7);
        exStringEquals(dsHenkouRireki8.getDskokno(), "2000000006", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki8.getHenkousikibetukey(), "400000000000000004", "変更識別キー");
        exNumericEquals(dsHenkouRireki8.getRenno(), 8, "連番");
        exStringEquals(dsHenkouRireki8.getTablenm(), "ＤＳ取引サービス管理テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki8.getTableid(), "MT_DsTorihikiServiceKanri", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki8.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki8.getHanbetukoumokunm(), "ＤＳ取引サービス管理情報　証券番号：17806000161", "判別項目名");
        exStringEquals(dsHenkouRireki8.getHenkoukoumokuid(), "syono", "変更項目ID");
        exStringEquals(dsHenkouRireki8.getHenkoukoumokunm(), "証券番号", "変更項目名");
        exStringEquals(dsHenkouRireki8.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki8.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki8.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki8.getNewnaiyou(), "証券番号：17806000161", "変更後内容");
        exStringEquals(dsHenkouRireki8.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki8.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki9 = dsHenkouRirekiLst.get(8);
        exStringEquals(dsHenkouRireki9.getDskokno(), "2000000006", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki9.getHenkousikibetukey(), "400000000000000004", "変更識別キー");
        exNumericEquals(dsHenkouRireki9.getRenno(), 9, "連番");
        exStringEquals(dsHenkouRireki9.getTablenm(), "ＤＳ送金用口座テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki9.getTableid(), "MT_DsSoukinyouKouza", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki9.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki9.getHanbetukoumokunm(), "ＤＳ送金用口座情報　証券番号：17806000161　ＤＳ送金用口座情報　口座種類区分：", "判別項目名");
        exStringEquals(dsHenkouRireki9.getHenkoukoumokuid(), "syono, kzsyuruikbn", "変更項目ID");
        exStringEquals(dsHenkouRireki9.getHenkoukoumokunm(), "証券番号、口座種類区分", "変更項目名");
        exStringEquals(dsHenkouRireki9.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki9.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki9.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki9.getNewnaiyou(), "証券番号：17806000161　口座種類区分：", "変更後内容");
        exStringEquals(dsHenkouRireki9.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki9.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki10 = dsHenkouRirekiLst.get(9);
        exStringEquals(dsHenkouRireki10.getDskokno(), "2000000006", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki10.getHenkousikibetukey(), "400000000000000004", "変更識別キー");
        exNumericEquals(dsHenkouRireki10.getRenno(), 10, "連番");
        exStringEquals(dsHenkouRireki10.getTablenm(), "ＤＳ送金用口座テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki10.getTableid(), "MT_DsSoukinyouKouza", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki10.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki10.getHanbetukoumokunm(), "ＤＳ送金用口座情報　証券番号：17806000161　ＤＳ送金用口座情報　口座種類区分：円口座", "判別項目名");
        exStringEquals(dsHenkouRireki10.getHenkoukoumokuid(), "syono, kzsyuruikbn", "変更項目ID");
        exStringEquals(dsHenkouRireki10.getHenkoukoumokunm(), "証券番号、口座種類区分", "変更項目名");
        exStringEquals(dsHenkouRireki10.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki10.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki10.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki10.getNewnaiyou(), "証券番号：17806000161　口座種類区分：円口座", "変更後内容");
        exStringEquals(dsHenkouRireki10.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki10.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki11 = dsHenkouRirekiLst.get(10);
        exStringEquals(dsHenkouRireki11.getDskokno(), "2000000006", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki11.getHenkousikibetukey(), "400000000000000004", "変更識別キー");
        exNumericEquals(dsHenkouRireki11.getRenno(), 11, "連番");
        exStringEquals(dsHenkouRireki11.getTablenm(), "ＤＳ送金用口座テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki11.getTableid(), "MT_DsSoukinyouKouza", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki11.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki11.getHanbetukoumokunm(), "ＤＳ送金用口座情報　証券番号：17806000161　ＤＳ送金用口座情報　口座種類区分：外貨口座", "判別項目名");
        exStringEquals(dsHenkouRireki11.getHenkoukoumokuid(), "syono, kzsyuruikbn", "変更項目ID");
        exStringEquals(dsHenkouRireki11.getHenkoukoumokunm(), "証券番号、口座種類区分", "変更項目名");
        exStringEquals(dsHenkouRireki11.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki11.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki11.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki11.getNewnaiyou(), "証券番号：17806000161　口座種類区分：外貨口座", "変更後内容");
        exStringEquals(dsHenkouRireki11.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki11.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki12 = dsHenkouRirekiLst.get(11);
        exStringEquals(dsHenkouRireki12.getDskokno(), "2000000006", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki12.getHenkousikibetukey(), "400000000000000004", "変更識別キー");
        exNumericEquals(dsHenkouRireki12.getRenno(), 12, "連番");
        exStringEquals(dsHenkouRireki12.getTablenm(), "ＤＳ特定取引用暗証番号テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki12.getTableid(), "MT_DsTorihikiyouAnsyono", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki12.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki12.getHanbetukoumokunm(), "ＤＳ特定取引用暗証番号情報　証券番号：17806000161", "判別項目名");
        exStringEquals(dsHenkouRireki12.getHenkoukoumokuid(), "syono", "変更項目ID");
        exStringEquals(dsHenkouRireki12.getHenkoukoumokunm(), "証券番号", "変更項目名");
        exStringEquals(dsHenkouRireki12.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki12.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki12.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki12.getNewnaiyou(), "証券番号：17806000161", "変更後内容");
        exStringEquals(dsHenkouRireki12.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki12.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @Transactional
    @TestOrder(90)
    public void testEditDSTtdkRirekiTblBatch_A8() {

        DsTetudukiRirekiTableEditParam dsTetudukiRirekiTableEditParam = new DsTetudukiRirekiTableEditParamImpl();
        dsTetudukiRirekiTableEditParam.setDskokno("2000000007");
        dsTetudukiRirekiTableEditParam.setHenkousikibetukey("400000000000000005");
        dsTetudukiRirekiTableEditParam.setSyoriYmd(BizDate.valueOf("2016/04/13"));
        dsTetudukiRirekiTableEditParam.setDssyorikbn(C_DsSyoriKbn.LOGIN_SEIKOU);
        dsTetudukiRirekiTableEditParam.setHenkouRrkYouhi(C_YouhiKbn.YOU);
        dsTetudukiRirekiTableEditParam.setDsKokyakuKanri(directDomManager.getDsKokyakuKanri("2000000007"));

        editDSTtdkRirekiTbl.editDSTtdkRirekiTblBatch(dsTetudukiRirekiTableEditParam);

        MT_DsKokyakuKanri dsKokyakuKanri = directDomManager.getDsKokyakuKanri(dsTetudukiRirekiTableEditParam.getDskokno());

        List<MT_DsTtdkRireki> dsTtdkRirekiLst = dsKokyakuKanri.getDsTtdkRirekis();
        exNumericEquals(dsTtdkRirekiLst.size(), 1, "ＤＳ手続履歴情報件数");
        MT_DsTtdkRireki dsTtdkRireki = dsTtdkRirekiLst.get(0);
        List<MT_DsHenkouRireki> dsHenkouRirekiLst = dsTtdkRireki.getDsHenkouRirekis();

        exNumericEquals(dsHenkouRirekiLst.size(), 8, "ＤＳ変更履歴情報件数");
        MT_DsHenkouRireki dsHenkouRireki1 = dsHenkouRirekiLst.get(0);
        exStringEquals(dsHenkouRireki1.getDskokno(), "2000000007", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki1.getHenkousikibetukey(), "400000000000000005", "変更識別キー");
        exNumericEquals(dsHenkouRireki1.getRenno(), 1, "連番");
        exStringEquals(dsHenkouRireki1.getTablenm(), "ＤＳ顧客管理テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki1.getTableid(), "MT_DsKokyakuKanri", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki1.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki1.getHanbetukoumokunm(), "ＤＳ顧客管理情報", "判別項目名");
        exStringEquals(dsHenkouRireki1.getHenkoukoumokuid(), "dskokno", "変更項目ID");
        exStringEquals(dsHenkouRireki1.getHenkoukoumokunm(), "ＤＳ顧客番号", "変更項目名");
        exStringEquals(dsHenkouRireki1.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki1.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki1.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki1.getNewnaiyou(), "2000000007", "変更後内容");
        exStringEquals(dsHenkouRireki1.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki1.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki2 = dsHenkouRirekiLst.get(1);
        exStringEquals(dsHenkouRireki2.getDskokno(), "2000000007", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki2.getHenkousikibetukey(), "400000000000000005", "変更識別キー");
        exNumericEquals(dsHenkouRireki2.getRenno(), 2, "連番");
        exStringEquals(dsHenkouRireki2.getTablenm(), "ＤＳ顧客契約テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki2.getTableid(), "MT_DsKokyakuKeiyaku", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki2.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki2.getHanbetukoumokunm(), "ＤＳ顧客契約情報　証券番号：17806000194", "判別項目名");
        exStringEquals(dsHenkouRireki2.getHenkoukoumokuid(), "syono", "変更項目ID");
        exStringEquals(dsHenkouRireki2.getHenkoukoumokunm(), "証券番号", "変更項目名");
        exStringEquals(dsHenkouRireki2.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki2.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki2.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki2.getNewnaiyou(), "証券番号：17806000194", "変更後内容");
        exStringEquals(dsHenkouRireki2.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki2.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki3 = dsHenkouRirekiLst.get(2);
        exStringEquals(dsHenkouRireki3.getDskokno(), "2000000007", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki3.getHenkousikibetukey(), "400000000000000005", "変更識別キー");
        exNumericEquals(dsHenkouRireki3.getRenno(), 3, "連番");
        exStringEquals(dsHenkouRireki3.getTablenm(), "ＤＳ本人確認コードテーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki3.getTableid(), "MT_DsHonninKakuninCd", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki3.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki3.getHanbetukoumokunm(), "ＤＳ本人確認コード情報", "判別項目名");
        exStringEquals(dsHenkouRireki3.getHenkoukoumokuid(), "dskokno", "変更項目ID");
        exStringEquals(dsHenkouRireki3.getHenkoukoumokunm(), "ＤＳ顧客番号", "変更項目名");
        exStringEquals(dsHenkouRireki3.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki3.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki3.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki3.getNewnaiyou(), "2000000007", "変更後内容");
        exStringEquals(dsHenkouRireki3.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki3.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki4 = dsHenkouRirekiLst.get(3);
        exStringEquals(dsHenkouRireki4.getDskokno(), "2000000007", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki4.getHenkousikibetukey(), "400000000000000005", "変更識別キー");
        exNumericEquals(dsHenkouRireki4.getRenno(), 4, "連番");
        exStringEquals(dsHenkouRireki4.getTablenm(), "ＤＳログイン管理テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki4.getTableid(), "MT_DsLoginKanri", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki4.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki4.getHanbetukoumokunm(), "ＤＳログイン管理情報", "判別項目名");
        exStringEquals(dsHenkouRireki4.getHenkoukoumokuid(), "dskokno", "変更項目ID");
        exStringEquals(dsHenkouRireki4.getHenkoukoumokunm(), "ＤＳ顧客番号", "変更項目名");
        exStringEquals(dsHenkouRireki4.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki4.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki4.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki4.getNewnaiyou(), "2000000007", "変更後内容");
        exStringEquals(dsHenkouRireki4.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki4.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki5 = dsHenkouRirekiLst.get(4);
        exStringEquals(dsHenkouRireki5.getDskokno(), "2000000007", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki5.getHenkousikibetukey(), "400000000000000005", "変更識別キー");
        exNumericEquals(dsHenkouRireki5.getRenno(), 5, "連番");
        exStringEquals(dsHenkouRireki5.getTablenm(), "ＤＳメールアドレステーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki5.getTableid(), "MT_DsMailAddress", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki5.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki5.getHanbetukoumokunm(), "ＤＳメールアドレス情報　ＤＳメールアドレス連番：300000013", "判別項目名");
        exStringEquals(dsHenkouRireki5.getHenkoukoumokuid(), "dskokno", "変更項目ID");
        exStringEquals(dsHenkouRireki5.getHenkoukoumokunm(), "ＤＳ顧客番号", "変更項目名");
        exStringEquals(dsHenkouRireki5.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki5.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki5.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki5.getNewnaiyou(), "ＤＳ顧客番号：2000000007", "変更後内容");
        exStringEquals(dsHenkouRireki5.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki5.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki6 = dsHenkouRirekiLst.get(5);
        exStringEquals(dsHenkouRireki6.getDskokno(), "2000000007", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki6.getHenkousikibetukey(), "400000000000000005", "変更識別キー");
        exNumericEquals(dsHenkouRireki6.getRenno(), 6, "連番");
        exStringEquals(dsHenkouRireki6.getTablenm(), "ＤＳ取引サービス管理テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki6.getTableid(), "MT_DsTorihikiServiceKanri", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki6.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki6.getHanbetukoumokunm(), "ＤＳ取引サービス管理情報　証券番号：17806000194", "判別項目名");
        exStringEquals(dsHenkouRireki6.getHenkoukoumokuid(), "syono", "変更項目ID");
        exStringEquals(dsHenkouRireki6.getHenkoukoumokunm(), "証券番号", "変更項目名");
        exStringEquals(dsHenkouRireki6.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki6.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki6.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki6.getNewnaiyou(), "証券番号：17806000194", "変更後内容");
        exStringEquals(dsHenkouRireki6.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki6.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki7 = dsHenkouRirekiLst.get(6);
        exStringEquals(dsHenkouRireki7.getDskokno(), "2000000007", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki7.getHenkousikibetukey(), "400000000000000005", "変更識別キー");
        exNumericEquals(dsHenkouRireki7.getRenno(), 7, "連番");
        exStringEquals(dsHenkouRireki7.getTablenm(), "ＤＳ送金用口座テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki7.getTableid(), "MT_DsSoukinyouKouza", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki7.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki7.getHanbetukoumokunm(), "ＤＳ送金用口座情報　証券番号：17806000194　ＤＳ送金用口座情報　口座種類区分：外貨口座", "判別項目名");
        exStringEquals(dsHenkouRireki7.getHenkoukoumokuid(), "syono, kzsyuruikbn", "変更項目ID");
        exStringEquals(dsHenkouRireki7.getHenkoukoumokunm(), "証券番号、口座種類区分", "変更項目名");
        exStringEquals(dsHenkouRireki7.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki7.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki7.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki7.getNewnaiyou(), "証券番号：17806000194　口座種類区分：外貨口座", "変更後内容");
        exStringEquals(dsHenkouRireki7.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki7.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki8 = dsHenkouRirekiLst.get(7);
        exStringEquals(dsHenkouRireki8.getDskokno(), "2000000007", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki8.getHenkousikibetukey(), "400000000000000005", "変更識別キー");
        exNumericEquals(dsHenkouRireki8.getRenno(), 8, "連番");
        exStringEquals(dsHenkouRireki8.getTablenm(), "ＤＳ特定取引用暗証番号テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki8.getTableid(), "MT_DsTorihikiyouAnsyono", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki8.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki8.getHanbetukoumokunm(), "ＤＳ特定取引用暗証番号情報　証券番号：17806000194", "判別項目名");
        exStringEquals(dsHenkouRireki8.getHenkoukoumokuid(), "syono", "変更項目ID");
        exStringEquals(dsHenkouRireki8.getHenkoukoumokunm(), "証券番号", "変更項目名");
        exStringEquals(dsHenkouRireki8.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki8.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki8.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki8.getNewnaiyou(), "証券番号：17806000194", "変更後内容");
        exStringEquals(dsHenkouRireki8.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki8.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @Transactional
    @TestOrder(90)
    public void testEditDSTtdkRirekiTblBatch_A9() {

        DsTetudukiRirekiTableEditParam dsTetudukiRirekiTableEditParam = new DsTetudukiRirekiTableEditParamImpl();
        dsTetudukiRirekiTableEditParam.setDskokno("2000000008");
        dsTetudukiRirekiTableEditParam.setHenkousikibetukey("400000000000000006");
        dsTetudukiRirekiTableEditParam.setSyoriYmd(BizDate.valueOf("2016/04/13"));
        dsTetudukiRirekiTableEditParam.setDssyorikbn(C_DsSyoriKbn.LOGIN_SEIKOU);
        dsTetudukiRirekiTableEditParam.setHenkouRrkYouhi(C_YouhiKbn.YOU);
        dsTetudukiRirekiTableEditParam.setDsKokyakuKanri(directDomManager.getDsKokyakuKanri("2000000008"));

        editDSTtdkRirekiTbl.editDSTtdkRirekiTblBatch(dsTetudukiRirekiTableEditParam);

        MT_DsKokyakuKanri dsKokyakuKanri = directDomManager.getDsKokyakuKanri(dsTetudukiRirekiTableEditParam.getDskokno());

        List<MT_DsTtdkRireki> dsTtdkRirekiLst = dsKokyakuKanri.getDsTtdkRirekis();
        exNumericEquals(dsTtdkRirekiLst.size(), 1, "ＤＳ手続履歴情報件数");
        MT_DsTtdkRireki dsTtdkRireki = dsTtdkRirekiLst.get(0);
        List<MT_DsHenkouRireki> dsHenkouRirekiLst = dsTtdkRireki.getDsHenkouRirekis();

        exNumericEquals(dsHenkouRirekiLst.size(), 5, "ＤＳ変更履歴情報件数");
        MT_DsHenkouRireki dsHenkouRireki1 = dsHenkouRirekiLst.get(0);
        exStringEquals(dsHenkouRireki1.getDskokno(), "2000000008", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki1.getHenkousikibetukey(), "400000000000000006", "変更識別キー");
        exNumericEquals(dsHenkouRireki1.getRenno(), 1, "連番");
        exStringEquals(dsHenkouRireki1.getTablenm(), "ＤＳ顧客管理テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki1.getTableid(), "MT_DsKokyakuKanri", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki1.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki1.getHanbetukoumokunm(), "ＤＳ顧客管理情報", "判別項目名");
        exStringEquals(dsHenkouRireki1.getHenkoukoumokuid(), "dskokno", "変更項目ID");
        exStringEquals(dsHenkouRireki1.getHenkoukoumokunm(), "ＤＳ顧客番号", "変更項目名");
        exStringEquals(dsHenkouRireki1.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki1.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki1.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki1.getNewnaiyou(), "2000000008", "変更後内容");
        exStringEquals(dsHenkouRireki1.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki1.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki2 = dsHenkouRirekiLst.get(1);
        exStringEquals(dsHenkouRireki2.getDskokno(), "2000000008", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki2.getHenkousikibetukey(), "400000000000000006", "変更識別キー");
        exNumericEquals(dsHenkouRireki2.getRenno(), 2, "連番");
        exStringEquals(dsHenkouRireki2.getTablenm(), "ＤＳ顧客契約テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki2.getTableid(), "MT_DsKokyakuKeiyaku", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki2.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki2.getHanbetukoumokunm(), "ＤＳ顧客契約情報　証券番号：17806000208", "判別項目名");
        exStringEquals(dsHenkouRireki2.getHenkoukoumokuid(), "syono", "変更項目ID");
        exStringEquals(dsHenkouRireki2.getHenkoukoumokunm(), "証券番号", "変更項目名");
        exStringEquals(dsHenkouRireki2.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki2.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki2.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki2.getNewnaiyou(), "証券番号：17806000208", "変更後内容");
        exStringEquals(dsHenkouRireki2.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki2.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki3 = dsHenkouRirekiLst.get(2);
        exStringEquals(dsHenkouRireki3.getDskokno(), "2000000008", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki3.getHenkousikibetukey(), "400000000000000006", "変更識別キー");
        exNumericEquals(dsHenkouRireki3.getRenno(), 3, "連番");
        exStringEquals(dsHenkouRireki3.getTablenm(), "ＤＳ本人確認コードテーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki3.getTableid(), "MT_DsHonninKakuninCd", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki3.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki3.getHanbetukoumokunm(), "ＤＳ本人確認コード情報", "判別項目名");
        exStringEquals(dsHenkouRireki3.getHenkoukoumokuid(), "dskokno", "変更項目ID");
        exStringEquals(dsHenkouRireki3.getHenkoukoumokunm(), "ＤＳ顧客番号", "変更項目名");
        exStringEquals(dsHenkouRireki3.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki3.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki3.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki3.getNewnaiyou(), "2000000008", "変更後内容");
        exStringEquals(dsHenkouRireki3.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki3.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki4 = dsHenkouRirekiLst.get(3);
        exStringEquals(dsHenkouRireki4.getDskokno(), "2000000008", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki4.getHenkousikibetukey(), "400000000000000006", "変更識別キー");
        exNumericEquals(dsHenkouRireki4.getRenno(), 4, "連番");
        exStringEquals(dsHenkouRireki4.getTablenm(), "ＤＳログイン管理テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki4.getTableid(), "MT_DsLoginKanri", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki4.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki4.getHanbetukoumokunm(), "ＤＳログイン管理情報", "判別項目名");
        exStringEquals(dsHenkouRireki4.getHenkoukoumokuid(), "dskokno", "変更項目ID");
        exStringEquals(dsHenkouRireki4.getHenkoukoumokunm(), "ＤＳ顧客番号", "変更項目名");
        exStringEquals(dsHenkouRireki4.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki4.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki4.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki4.getNewnaiyou(), "2000000008", "変更後内容");
        exStringEquals(dsHenkouRireki4.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki4.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki5 = dsHenkouRirekiLst.get(4);
        exStringEquals(dsHenkouRireki5.getDskokno(), "2000000008", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki5.getHenkousikibetukey(), "400000000000000006", "変更識別キー");
        exNumericEquals(dsHenkouRireki5.getRenno(), 5, "連番");
        exStringEquals(dsHenkouRireki5.getTablenm(), "ＤＳメールアドレステーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki5.getTableid(), "MT_DsMailAddress", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki5.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki5.getHanbetukoumokunm(), "ＤＳメールアドレス情報　ＤＳメールアドレス連番：300000014", "判別項目名");
        exStringEquals(dsHenkouRireki5.getHenkoukoumokuid(), "dskokno", "変更項目ID");
        exStringEquals(dsHenkouRireki5.getHenkoukoumokunm(), "ＤＳ顧客番号", "変更項目名");
        exStringEquals(dsHenkouRireki5.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki5.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki5.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki5.getNewnaiyou(), "ＤＳ顧客番号：2000000008", "変更後内容");
        exStringEquals(dsHenkouRireki5.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki5.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @Transactional
    @TestOrder(100)
    public void testEditDSTtdkRirekiTblBatch_A10() {

        DsTetudukiRirekiTableEditParam dsTetudukiRirekiTableEditParam = new DsTetudukiRirekiTableEditParamImpl();
        dsTetudukiRirekiTableEditParam.setDskokno("2000000009");
        dsTetudukiRirekiTableEditParam.setHenkousikibetukey("400000000000000007");
        dsTetudukiRirekiTableEditParam.setSyoriYmd(BizDate.valueOf("2016/04/13"));
        dsTetudukiRirekiTableEditParam.setDssyorikbn(C_DsSyoriKbn.LOGIN_SEIKOU);
        dsTetudukiRirekiTableEditParam.setHenkouRrkYouhi(C_YouhiKbn.YOU);
        dsTetudukiRirekiTableEditParam.setDsKokyakuKanri(directDomManager.getDsKokyakuKanri("2000000009"));

        editDSTtdkRirekiTbl.editDSTtdkRirekiTblBatch(dsTetudukiRirekiTableEditParam);

        MT_DsKokyakuKanri dsKokyakuKanri = directDomManager.getDsKokyakuKanri(dsTetudukiRirekiTableEditParam.getDskokno());

        List<MT_DsTtdkRireki> dsTtdkRirekiLst = dsKokyakuKanri.getDsTtdkRirekis();
        exNumericEquals(dsTtdkRirekiLst.size(), 1, "ＤＳ手続履歴情報件数");
        MT_DsTtdkRireki dsTtdkRireki = dsTtdkRirekiLst.get(0);
        List<MT_DsHenkouRireki> dsHenkouRirekiLst = dsTtdkRireki.getDsHenkouRirekis();

        exNumericEquals(dsHenkouRirekiLst.size(), 4, "ＤＳ変更履歴情報件数");
        MT_DsHenkouRireki dsHenkouRireki1 = dsHenkouRirekiLst.get(0);
        exStringEquals(dsHenkouRireki1.getDskokno(), "2000000009", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki1.getHenkousikibetukey(), "400000000000000007", "変更識別キー");
        exNumericEquals(dsHenkouRireki1.getRenno(), 1, "連番");
        exStringEquals(dsHenkouRireki1.getTablenm(), "ＤＳ顧客管理テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki1.getTableid(), "MT_DsKokyakuKanri", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki1.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki1.getHanbetukoumokunm(), "ＤＳ顧客管理情報", "判別項目名");
        exStringEquals(dsHenkouRireki1.getHenkoukoumokuid(), "dskokno", "変更項目ID");
        exStringEquals(dsHenkouRireki1.getHenkoukoumokunm(), "ＤＳ顧客番号", "変更項目名");
        exStringEquals(dsHenkouRireki1.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki1.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki1.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki1.getNewnaiyou(), "2000000009", "変更後内容");
        exStringEquals(dsHenkouRireki1.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki1.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki2 = dsHenkouRirekiLst.get(1);
        exStringEquals(dsHenkouRireki2.getDskokno(), "2000000009", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki2.getHenkousikibetukey(), "400000000000000007", "変更識別キー");
        exNumericEquals(dsHenkouRireki2.getRenno(), 2, "連番");
        exStringEquals(dsHenkouRireki2.getTablenm(), "ＤＳ本人確認コードテーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki2.getTableid(), "MT_DsHonninKakuninCd", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki2.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki2.getHanbetukoumokunm(), "ＤＳ本人確認コード情報", "判別項目名");
        exStringEquals(dsHenkouRireki2.getHenkoukoumokuid(), "dskokno", "変更項目ID");
        exStringEquals(dsHenkouRireki2.getHenkoukoumokunm(), "ＤＳ顧客番号", "変更項目名");
        exStringEquals(dsHenkouRireki2.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki2.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki2.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki2.getNewnaiyou(), "2000000009", "変更後内容");
        exStringEquals(dsHenkouRireki2.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki2.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki3 = dsHenkouRirekiLst.get(2);
        exStringEquals(dsHenkouRireki3.getDskokno(), "2000000009", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki3.getHenkousikibetukey(), "400000000000000007", "変更識別キー");
        exNumericEquals(dsHenkouRireki3.getRenno(), 3, "連番");
        exStringEquals(dsHenkouRireki3.getTablenm(), "ＤＳログイン管理テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki3.getTableid(), "MT_DsLoginKanri", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki3.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki3.getHanbetukoumokunm(), "ＤＳログイン管理情報", "判別項目名");
        exStringEquals(dsHenkouRireki3.getHenkoukoumokuid(), "dskokno", "変更項目ID");
        exStringEquals(dsHenkouRireki3.getHenkoukoumokunm(), "ＤＳ顧客番号", "変更項目名");
        exStringEquals(dsHenkouRireki3.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki3.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki3.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki3.getNewnaiyou(), "2000000009", "変更後内容");
        exStringEquals(dsHenkouRireki3.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki3.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki4 = dsHenkouRirekiLst.get(3);
        exStringEquals(dsHenkouRireki4.getDskokno(), "2000000009", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki4.getHenkousikibetukey(), "400000000000000007", "変更識別キー");
        exNumericEquals(dsHenkouRireki4.getRenno(), 4, "連番");
        exStringEquals(dsHenkouRireki4.getTablenm(), "ＤＳメールアドレステーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki4.getTableid(), "MT_DsMailAddress", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki4.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki4.getHanbetukoumokunm(), "ＤＳメールアドレス情報　ＤＳメールアドレス連番：300000015", "判別項目名");
        exStringEquals(dsHenkouRireki4.getHenkoukoumokuid(), "dskokno", "変更項目ID");
        exStringEquals(dsHenkouRireki4.getHenkoukoumokunm(), "ＤＳ顧客番号", "変更項目名");
        exStringEquals(dsHenkouRireki4.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki4.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki4.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki4.getNewnaiyou(), "ＤＳ顧客番号：2000000009", "変更後内容");
        exStringEquals(dsHenkouRireki4.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki4.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

    }

    @Test
    @Transactional
    @TestOrder(110)
    public void testEditDSTtdkRirekiTblBatch_A11() {

        DsTetudukiRirekiTableEditParam dsTetudukiRirekiTableEditParam = new DsTetudukiRirekiTableEditParamImpl();
        dsTetudukiRirekiTableEditParam.setDskokno("2000000010");
        dsTetudukiRirekiTableEditParam.setHenkousikibetukey("400000000000000008");
        dsTetudukiRirekiTableEditParam.setSyoriYmd(BizDate.valueOf("2016/04/13"));
        dsTetudukiRirekiTableEditParam.setDssyorikbn(C_DsSyoriKbn.LOGIN_SEIKOU);
        dsTetudukiRirekiTableEditParam.setHenkouRrkYouhi(C_YouhiKbn.YOU);
        dsTetudukiRirekiTableEditParam.setDsKokyakuKanri(directDomManager.getDsKokyakuKanri("2000000010"));

        editDSTtdkRirekiTbl.editDSTtdkRirekiTblBatch(dsTetudukiRirekiTableEditParam);

        MT_DsKokyakuKanri dsKokyakuKanri = directDomManager.getDsKokyakuKanri(dsTetudukiRirekiTableEditParam.getDskokno());

        List<MT_DsTtdkRireki> dsTtdkRirekiLst = dsKokyakuKanri.getDsTtdkRirekis();
        exNumericEquals(dsTtdkRirekiLst.size(), 1, "ＤＳ手続履歴情報件数");
        MT_DsTtdkRireki dsTtdkRireki = dsTtdkRirekiLst.get(0);
        List<MT_DsHenkouRireki> dsHenkouRirekiLst = dsTtdkRireki.getDsHenkouRirekis();

        exNumericEquals(dsHenkouRirekiLst.size(), 7, "ＤＳ変更履歴情報件数");
        MT_DsHenkouRireki dsHenkouRireki1 = dsHenkouRirekiLst.get(0);
        exStringEquals(dsHenkouRireki1.getDskokno(), "2000000010", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki1.getHenkousikibetukey(), "400000000000000008", "変更識別キー");
        exNumericEquals(dsHenkouRireki1.getRenno(), 1, "連番");
        exStringEquals(dsHenkouRireki1.getTablenm(), "ＤＳ顧客管理テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki1.getTableid(), "MT_DsKokyakuKanri", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki1.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki1.getHanbetukoumokunm(), "ＤＳ顧客管理情報", "判別項目名");
        exStringEquals(dsHenkouRireki1.getHenkoukoumokuid(), "dskokno", "変更項目ID");
        exStringEquals(dsHenkouRireki1.getHenkoukoumokunm(), "ＤＳ顧客番号", "変更項目名");
        exStringEquals(dsHenkouRireki1.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki1.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki1.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki1.getNewnaiyou(), "2000000010", "変更後内容");
        exStringEquals(dsHenkouRireki1.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki1.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki2 = dsHenkouRirekiLst.get(1);
        exStringEquals(dsHenkouRireki2.getDskokno(), "2000000010", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki2.getHenkousikibetukey(), "400000000000000008", "変更識別キー");
        exNumericEquals(dsHenkouRireki2.getRenno(), 2, "連番");
        exStringEquals(dsHenkouRireki2.getTablenm(), "ＤＳ顧客契約テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki2.getTableid(), "MT_DsKokyakuKeiyaku", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki2.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki2.getHanbetukoumokunm(), "ＤＳ顧客契約情報　証券番号：17806000220", "判別項目名");
        exStringEquals(dsHenkouRireki2.getHenkoukoumokuid(), "syono", "変更項目ID");
        exStringEquals(dsHenkouRireki2.getHenkoukoumokunm(), "証券番号", "変更項目名");
        exStringEquals(dsHenkouRireki2.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki2.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki2.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki2.getNewnaiyou(), "証券番号：17806000220", "変更後内容");
        exStringEquals(dsHenkouRireki2.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki2.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki3 = dsHenkouRirekiLst.get(2);
        exStringEquals(dsHenkouRireki3.getDskokno(), "2000000010", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki3.getHenkousikibetukey(), "400000000000000008", "変更識別キー");
        exNumericEquals(dsHenkouRireki3.getRenno(), 3, "連番");
        exStringEquals(dsHenkouRireki3.getTablenm(), "ＤＳ本人確認コードテーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki3.getTableid(), "MT_DsHonninKakuninCd", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki3.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki3.getHanbetukoumokunm(), "ＤＳ本人確認コード情報", "判別項目名");
        exStringEquals(dsHenkouRireki3.getHenkoukoumokuid(), "dskokno", "変更項目ID");
        exStringEquals(dsHenkouRireki3.getHenkoukoumokunm(), "ＤＳ顧客番号", "変更項目名");
        exStringEquals(dsHenkouRireki3.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki3.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki3.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki3.getNewnaiyou(), "2000000010", "変更後内容");
        exStringEquals(dsHenkouRireki3.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki3.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki4 = dsHenkouRirekiLst.get(3);
        exStringEquals(dsHenkouRireki4.getDskokno(), "2000000010", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki4.getHenkousikibetukey(), "400000000000000008", "変更識別キー");
        exNumericEquals(dsHenkouRireki4.getRenno(), 4, "連番");
        exStringEquals(dsHenkouRireki4.getTablenm(), "ＤＳログイン管理テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki4.getTableid(), "MT_DsLoginKanri", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki4.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki4.getHanbetukoumokunm(), "ＤＳログイン管理情報", "判別項目名");
        exStringEquals(dsHenkouRireki4.getHenkoukoumokuid(), "dskokno", "変更項目ID");
        exStringEquals(dsHenkouRireki4.getHenkoukoumokunm(), "ＤＳ顧客番号", "変更項目名");
        exStringEquals(dsHenkouRireki4.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki4.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki4.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki4.getNewnaiyou(), "2000000010", "変更後内容");
        exStringEquals(dsHenkouRireki4.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki4.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki5 = dsHenkouRirekiLst.get(4);
        exStringEquals(dsHenkouRireki5.getDskokno(), "2000000010", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki5.getHenkousikibetukey(), "400000000000000008", "変更識別キー");
        exNumericEquals(dsHenkouRireki5.getRenno(), 5, "連番");
        exStringEquals(dsHenkouRireki5.getTablenm(), "ＤＳメールアドレステーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki5.getTableid(), "MT_DsMailAddress", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki5.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki5.getHanbetukoumokunm(), "ＤＳメールアドレス情報　ＤＳメールアドレス連番：300000016", "判別項目名");
        exStringEquals(dsHenkouRireki5.getHenkoukoumokuid(), "dskokno", "変更項目ID");
        exStringEquals(dsHenkouRireki5.getHenkoukoumokunm(), "ＤＳ顧客番号", "変更項目名");
        exStringEquals(dsHenkouRireki5.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki5.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki5.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki5.getNewnaiyou(), "ＤＳ顧客番号：2000000010", "変更後内容");
        exStringEquals(dsHenkouRireki5.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki5.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki6 = dsHenkouRirekiLst.get(5);
        exStringEquals(dsHenkouRireki6.getDskokno(), "2000000010", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki6.getHenkousikibetukey(), "400000000000000008", "変更識別キー");
        exNumericEquals(dsHenkouRireki6.getRenno(), 6, "連番");
        exStringEquals(dsHenkouRireki6.getTablenm(), "ＤＳ取引サービス管理テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki6.getTableid(), "MT_DsTorihikiServiceKanri", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki6.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki6.getHanbetukoumokunm(), "ＤＳ取引サービス管理情報　証券番号：17806000220", "判別項目名");
        exStringEquals(dsHenkouRireki6.getHenkoukoumokuid(), "syono", "変更項目ID");
        exStringEquals(dsHenkouRireki6.getHenkoukoumokunm(), "証券番号", "変更項目名");
        exStringEquals(dsHenkouRireki6.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki6.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki6.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki6.getNewnaiyou(), "証券番号：17806000220", "変更後内容");
        exStringEquals(dsHenkouRireki6.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki6.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki7 = dsHenkouRirekiLst.get(6);
        exStringEquals(dsHenkouRireki7.getDskokno(), "2000000010", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki7.getHenkousikibetukey(), "400000000000000008", "変更識別キー");
        exNumericEquals(dsHenkouRireki7.getRenno(), 7, "連番");
        exStringEquals(dsHenkouRireki7.getTablenm(), "ＤＳ特定取引用暗証番号テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki7.getTableid(), "MT_DsTorihikiyouAnsyono", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki7.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki7.getHanbetukoumokunm(), "ＤＳ特定取引用暗証番号情報　証券番号：17806000220", "判別項目名");
        exStringEquals(dsHenkouRireki7.getHenkoukoumokuid(), "syono", "変更項目ID");
        exStringEquals(dsHenkouRireki7.getHenkoukoumokunm(), "証券番号", "変更項目名");
        exStringEquals(dsHenkouRireki7.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki7.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki7.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki7.getNewnaiyou(), "証券番号：17806000220", "変更後内容");
        exStringEquals(dsHenkouRireki7.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki7.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @Transactional
    @TestOrder(120)
    public void testEditDSTtdkRirekiTblBatch_A12() {

        DsTetudukiRirekiTableEditParam dsTetudukiRirekiTableEditParam = new DsTetudukiRirekiTableEditParamImpl();
        dsTetudukiRirekiTableEditParam.setDskokno("2000000011");
        dsTetudukiRirekiTableEditParam.setHenkousikibetukey("400000000000000009");
        dsTetudukiRirekiTableEditParam.setSyoriYmd(BizDate.valueOf("2016/04/13"));
        dsTetudukiRirekiTableEditParam.setDssyorikbn(C_DsSyoriKbn.LOGIN_SEIKOU);
        dsTetudukiRirekiTableEditParam.setHenkouRrkYouhi(C_YouhiKbn.YOU);
        MT_DsKokyakuKanri entity = directDomManager.getDsKokyakuKanri("2000000011");
        entity.setDskokyakujtkbn(C_DsKokyakuJtKbn.ITIJI_TEISI);
        dsTetudukiRirekiTableEditParam.setDsKokyakuKanri(entity);
        MT_BAK_DsKokyakuKanri bakEntity = directDomManager.getBAKDsKokyakuKanri("2000000011", "400000000000000009");
        bakEntity.setDskokyakujtkbn(C_DsKokyakuJtKbn.YUUKOU);
        dsTetudukiRirekiTableEditParam.setBakDsKokyakuKanri(bakEntity);

        editDSTtdkRirekiTbl.editDSTtdkRirekiTblBatch(dsTetudukiRirekiTableEditParam);

        MT_DsKokyakuKanri dsKokyakuKanri = directDomManager.getDsKokyakuKanri(dsTetudukiRirekiTableEditParam.getDskokno());

        List<MT_DsTtdkRireki> dsTtdkRirekiLst = dsKokyakuKanri.getDsTtdkRirekis();

        exNumericEquals(dsTtdkRirekiLst.size(), 1, "ＤＳ手続履歴情報件数");

        MT_DsTtdkRireki dsTtdkRireki = dsTtdkRirekiLst.get(0);
        exStringEquals(dsTtdkRireki.getDskokno(), "2000000011", "ＤＳ手続履歴テーブルエンティティ．ＤＳ顧客番号");
        exStringEquals(dsTtdkRireki.getHenkousikibetukey(), "400000000000000009", "ＤＳ手続履歴テーブルエンティティ．変更識別キー");
        exDateEquals(dsTtdkRireki.getSyoriYmd(), BizDate.valueOf("2016/04/13"), "ＤＳ手続履歴テーブルエンティティ．処理年月日");
        exClassificationEquals(dsTtdkRireki.getDssyorikbn(), C_DsSyoriKbn.LOGIN_SEIKOU, "ＤＳ手続履歴テーブルエンティティ．ＤＳ処理区分");
        exClassificationEquals(dsTtdkRireki.getHenkourrkumu(), C_UmuKbn.ARI, "ＤＳ手続履歴テーブルエンティティ．変更履歴有無");
        exStringEquals(dsTtdkRireki.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "ＤＳ手続履歴テーブルエンティティ．業務用更新機能ＩＤ");
        exStringEquals(dsTtdkRireki.getGyoumuKousinsyaId(), "JUnit", "ＤＳ手続履歴テーブルエンティティ．業務用更新者ＩＤ");

        List<MT_DsHenkouRireki> dsHenkouRirekiLst = dsTtdkRireki.getDsHenkouRirekis();
        exNumericEquals(dsHenkouRirekiLst.size(), 11, "ＤＳ変更履歴情報件数");
        MT_DsHenkouRireki dsHenkouRireki1 = dsHenkouRirekiLst.get(0);
        exStringEquals(dsHenkouRireki1.getDskokno(), "2000000011", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki1.getHenkousikibetukey(), "400000000000000009", "変更識別キー");
        exNumericEquals(dsHenkouRireki1.getRenno(), 1, "連番");
        exStringEquals(dsHenkouRireki1.getTablenm(), "ＤＳ顧客管理テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki1.getTableid(), "MT_DsKokyakuKanri", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki1.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki1.getHanbetukoumokunm(), "ＤＳ顧客管理情報", "判別項目名");
        exStringEquals(dsHenkouRireki1.getHenkoukoumokuid(), "dskokyakujtkbn", "変更項目ID");
        exStringEquals(dsHenkouRireki1.getHenkoukoumokunm(), "ＤＳ顧客状態区分", "変更項目名");
        exStringEquals(dsHenkouRireki1.getBfrnaiyouoriginal(), "1", "変更前内容原本");
        exStringEquals(dsHenkouRireki1.getBfrnaiyou(), "有効取引中", "変更前内容");
        exStringEquals(dsHenkouRireki1.getNewnaiyouoriginal(), "2", "変更後内容原本");
        exStringEquals(dsHenkouRireki1.getNewnaiyou(), "一時停止", "変更後内容");
        exStringEquals(dsHenkouRireki1.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki1.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki2 = dsHenkouRirekiLst.get(1);
        exStringEquals(dsHenkouRireki2.getDskokno(), "2000000011", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki2.getHenkousikibetukey(), "400000000000000009", "変更識別キー");
        exNumericEquals(dsHenkouRireki2.getRenno(), 2, "連番");
        exStringEquals(dsHenkouRireki2.getTablenm(), "ＤＳ顧客管理テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki2.getTableid(), "MT_DsKokyakuKanri", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki2.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki2.getHanbetukoumokunm(), "ＤＳ顧客管理情報", "判別項目名");
        exStringEquals(dsHenkouRireki2.getHenkoukoumokuid(), "dskanyuukeirokbn", "変更項目ID");
        exStringEquals(dsHenkouRireki2.getHenkoukoumokunm(), "ＤＳ加入経路区分", "変更項目名");
        exStringEquals(dsHenkouRireki2.getBfrnaiyouoriginal(), "1", "変更前内容原本");
        exStringEquals(dsHenkouRireki2.getBfrnaiyou(), "新契約同時", "変更前内容");
        exStringEquals(dsHenkouRireki2.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki2.getNewnaiyou(), "", "変更後内容");
        exStringEquals(dsHenkouRireki2.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki2.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki3 = dsHenkouRirekiLst.get(2);
        exStringEquals(dsHenkouRireki3.getDskokno(), "2000000011", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki3.getHenkousikibetukey(), "400000000000000009", "変更識別キー");
        exNumericEquals(dsHenkouRireki3.getRenno(), 3, "連番");
        exStringEquals(dsHenkouRireki3.getTablenm(), "ＤＳ本人確認コードテーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki3.getTableid(), "MT_DsHonninKakuninCd", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki3.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki3.getHanbetukoumokunm(), "ＤＳ本人確認コード情報", "判別項目名");
        exStringEquals(dsHenkouRireki3.getHenkoukoumokuid(), "dskrhnnkakcd", "変更項目ID");
        exStringEquals(dsHenkouRireki3.getHenkoukoumokunm(), "ＤＳ仮本人確認コード", "変更項目名");
        exStringEquals(dsHenkouRireki3.getBfrnaiyouoriginal(), "***", "変更前内容原本");
        exStringEquals(dsHenkouRireki3.getBfrnaiyou(), "***", "変更前内容");
        exStringEquals(dsHenkouRireki3.getNewnaiyouoriginal(), "***", "変更後内容原本");
        exStringEquals(dsHenkouRireki3.getNewnaiyou(), "***", "変更後内容");
        exStringEquals(dsHenkouRireki3.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki3.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki4 = dsHenkouRirekiLst.get(3);
        exStringEquals(dsHenkouRireki4.getDskokno(), "2000000011", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki4.getHenkousikibetukey(), "400000000000000009", "変更識別キー");
        exNumericEquals(dsHenkouRireki4.getRenno(), 4, "連番");
        exStringEquals(dsHenkouRireki4.getTablenm(), "ＤＳ本人確認コードテーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki4.getTableid(), "MT_DsHonninKakuninCd", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki4.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki4.getHanbetukoumokunm(), "ＤＳ本人確認コード情報", "判別項目名");
        exStringEquals(dsHenkouRireki4.getHenkoukoumokuid(), "dskrhnnkakcdttyhkbn", "変更項目ID");
        exStringEquals(dsHenkouRireki4.getHenkoukoumokunm(), "ＤＳ仮本人確認コード通知要否区分", "変更項目名");
        exStringEquals(dsHenkouRireki4.getBfrnaiyouoriginal(), "1", "変更前内容原本");
        exStringEquals(dsHenkouRireki4.getBfrnaiyou(), "要", "変更前内容");
        exStringEquals(dsHenkouRireki4.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki4.getNewnaiyou(), "", "変更後内容");
        exStringEquals(dsHenkouRireki4.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki4.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki5 = dsHenkouRirekiLst.get(4);
        exStringEquals(dsHenkouRireki5.getDskokno(), "2000000011", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki5.getHenkousikibetukey(), "400000000000000009", "変更識別キー");
        exNumericEquals(dsHenkouRireki5.getRenno(), 5, "連番");
        exStringEquals(dsHenkouRireki5.getTablenm(), "ＤＳ本人確認コードテーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki5.getTableid(), "MT_DsHonninKakuninCd", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki5.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki5.getHanbetukoumokunm(), "ＤＳ本人確認コード情報", "判別項目名");
        exStringEquals(dsHenkouRireki5.getHenkoukoumokuid(), "dskrhnnkakcdtttydnjykbn", "変更項目ID");
        exStringEquals(dsHenkouRireki5.getHenkoukoumokunm(), "ＤＳ仮本人確認コード通知中断事由区分", "変更項目名");
        exStringEquals(dsHenkouRireki5.getBfrnaiyouoriginal(), "11", "変更前内容原本");
        exStringEquals(dsHenkouRireki5.getBfrnaiyou(), "名寄せ不可（住所変更中）", "変更前内容");
        exStringEquals(dsHenkouRireki5.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki5.getNewnaiyou(), "", "変更後内容");
        exStringEquals(dsHenkouRireki5.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki5.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki6 = dsHenkouRirekiLst.get(5);
        exStringEquals(dsHenkouRireki6.getDskokno(), "2000000011", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki6.getHenkousikibetukey(), "400000000000000009", "変更識別キー");
        exNumericEquals(dsHenkouRireki6.getRenno(), 6, "連番");
        exStringEquals(dsHenkouRireki6.getTablenm(), "ＤＳログイン管理テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki6.getTableid(), "MT_DsLoginKanri", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki6.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki6.getHanbetukoumokunm(), "ＤＳログイン管理情報", "判別項目名");
        exStringEquals(dsHenkouRireki6.getHenkoukoumokuid(), "syokailoginymd", "変更項目ID");
        exStringEquals(dsHenkouRireki6.getHenkoukoumokunm(), "初回ログイン年月日", "変更項目名");
        exStringEquals(dsHenkouRireki6.getBfrnaiyouoriginal(), "20150419", "変更前内容原本");
        exStringEquals(dsHenkouRireki6.getBfrnaiyou(), "20150419", "変更前内容");
        exStringEquals(dsHenkouRireki6.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki6.getNewnaiyou(), "", "変更後内容");
        exStringEquals(dsHenkouRireki6.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki6.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki7 = dsHenkouRirekiLst.get(6);
        exStringEquals(dsHenkouRireki7.getDskokno(), "2000000011", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki7.getHenkousikibetukey(), "400000000000000009", "変更識別キー");
        exNumericEquals(dsHenkouRireki7.getRenno(), 7, "連番");
        exStringEquals(dsHenkouRireki7.getTablenm(), "ＤＳメールアドレステーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki7.getTableid(), "MT_DsMailAddress", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki7.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki7.getHanbetukoumokunm(), "ＤＳメールアドレス情報　ＤＳメールアドレス連番：300000017", "判別項目名");
        exStringEquals(dsHenkouRireki7.getHenkoukoumokuid(), "dskokno", "変更項目ID");
        exStringEquals(dsHenkouRireki7.getHenkoukoumokunm(), "ＤＳ顧客番号", "変更項目名");
        exStringEquals(dsHenkouRireki7.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki7.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki7.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki7.getNewnaiyou(), "ＤＳ顧客番号：2000000011", "変更後内容");
        exStringEquals(dsHenkouRireki7.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki7.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki8 = dsHenkouRirekiLst.get(7);
        exStringEquals(dsHenkouRireki8.getDskokno(), "2000000011", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki8.getHenkousikibetukey(), "400000000000000009", "変更識別キー");
        exNumericEquals(dsHenkouRireki8.getRenno(), 8, "連番");
        exStringEquals(dsHenkouRireki8.getTablenm(), "ＤＳ取引サービス管理テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki8.getTableid(), "MT_DsTorihikiServiceKanri", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki8.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki8.getHanbetukoumokunm(), "ＤＳ取引サービス管理情報　証券番号：17806000242", "判別項目名");
        exStringEquals(dsHenkouRireki8.getHenkoukoumokuid(), "syono", "変更項目ID");
        exStringEquals(dsHenkouRireki8.getHenkoukoumokunm(), "証券番号", "変更項目名");
        exStringEquals(dsHenkouRireki8.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki8.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki8.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki8.getNewnaiyou(), "証券番号：17806000242", "変更後内容");
        exStringEquals(dsHenkouRireki8.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki8.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki9 = dsHenkouRirekiLst.get(8);
        exStringEquals(dsHenkouRireki9.getDskokno(), "2000000011", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki9.getHenkousikibetukey(), "400000000000000009", "変更識別キー");
        exNumericEquals(dsHenkouRireki9.getRenno(), 9, "連番");
        exStringEquals(dsHenkouRireki9.getTablenm(), "ＤＳ取引サービス管理テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki9.getTableid(), "MT_DsTorihikiServiceKanri", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki9.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki9.getHanbetukoumokunm(), "ＤＳ取引サービス管理情報　証券番号：17806000253", "判別項目名");
        exStringEquals(dsHenkouRireki9.getHenkoukoumokuid(), "syono", "変更項目ID");
        exStringEquals(dsHenkouRireki9.getHenkoukoumokunm(), "証券番号", "変更項目名");
        exStringEquals(dsHenkouRireki9.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki9.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki9.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki9.getNewnaiyou(), "証券番号：17806000253", "変更後内容");
        exStringEquals(dsHenkouRireki9.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki9.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki10 = dsHenkouRirekiLst.get(9);
        exStringEquals(dsHenkouRireki10.getDskokno(), "2000000011", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki10.getHenkousikibetukey(), "400000000000000009", "変更識別キー");
        exNumericEquals(dsHenkouRireki10.getRenno(), 10, "連番");
        exStringEquals(dsHenkouRireki10.getTablenm(), "ＤＳ特定取引用暗証番号テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki10.getTableid(), "MT_DsTorihikiyouAnsyono", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki10.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki10.getHanbetukoumokunm(), "ＤＳ特定取引用暗証番号情報　証券番号：17806000242", "判別項目名");
        exStringEquals(dsHenkouRireki10.getHenkoukoumokuid(), "syono", "変更項目ID");
        exStringEquals(dsHenkouRireki10.getHenkoukoumokunm(), "証券番号", "変更項目名");
        exStringEquals(dsHenkouRireki10.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki10.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki10.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki10.getNewnaiyou(), "証券番号：17806000242", "変更後内容");
        exStringEquals(dsHenkouRireki10.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki10.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki11 = dsHenkouRirekiLst.get(10);
        exStringEquals(dsHenkouRireki11.getDskokno(), "2000000011", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki11.getHenkousikibetukey(), "400000000000000009", "変更識別キー");
        exNumericEquals(dsHenkouRireki11.getRenno(), 11, "連番");
        exStringEquals(dsHenkouRireki11.getTablenm(), "ＤＳ特定取引用暗証番号テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki11.getTableid(), "MT_DsTorihikiyouAnsyono", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki11.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki11.getHanbetukoumokunm(), "ＤＳ特定取引用暗証番号情報　証券番号：17806000253", "判別項目名");
        exStringEquals(dsHenkouRireki11.getHenkoukoumokuid(), "syono", "変更項目ID");
        exStringEquals(dsHenkouRireki11.getHenkoukoumokunm(), "証券番号", "変更項目名");
        exStringEquals(dsHenkouRireki11.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki11.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki11.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki11.getNewnaiyou(), "証券番号：17806000253", "変更後内容");
        exStringEquals(dsHenkouRireki11.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki11.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @Transactional
    @TestOrder(130)
    public void testEditDSTtdkRirekiTblBatch_A13() {

        DsTetudukiRirekiTableEditParam dsTetudukiRirekiTableEditParam = new DsTetudukiRirekiTableEditParamImpl();
        dsTetudukiRirekiTableEditParam.setDskokno("2000000012");
        dsTetudukiRirekiTableEditParam.setHenkousikibetukey("400000000000000012");
        dsTetudukiRirekiTableEditParam.setSyoriYmd(BizDate.valueOf("2016/04/13"));
        dsTetudukiRirekiTableEditParam.setDssyorikbn(C_DsSyoriKbn.LOGIN_SEIKOU);
        dsTetudukiRirekiTableEditParam.setHenkouRrkYouhi(C_YouhiKbn.YOU);
        MT_DsKokyakuKanri entity = directDomManager.getDsKokyakuKanri("2000000012");
        entity.setDskokyakujtkbn(C_DsKokyakuJtKbn.ITIJI_TEISI);
        dsTetudukiRirekiTableEditParam.setDsKokyakuKanri(entity);
        MT_BAK_DsKokyakuKanri bakEntity = directDomManager.getBAKDsKokyakuKanri("2000000012", "400000000000000012");
        bakEntity.setDskokyakujtkbn(C_DsKokyakuJtKbn.YUUKOU);
        dsTetudukiRirekiTableEditParam.setBakDsKokyakuKanri(bakEntity);

        editDSTtdkRirekiTbl.editDSTtdkRirekiTblBatch(dsTetudukiRirekiTableEditParam);

        MT_DsKokyakuKanri dsKokyakuKanri = directDomManager.getDsKokyakuKanri(dsTetudukiRirekiTableEditParam.getDskokno());

        List<MT_DsTtdkRireki> dsTtdkRirekiLst = dsKokyakuKanri.getDsTtdkRirekis();

        exNumericEquals(dsTtdkRirekiLst.size(), 1, "ＤＳ手続履歴情報件数");

        MT_DsTtdkRireki dsTtdkRireki = dsTtdkRirekiLst.get(0);

        List<MT_DsHenkouRireki> dsHenkouRirekiLst = dsTtdkRireki.getDsHenkouRirekis();
        exNumericEquals(dsHenkouRirekiLst.size(), 7, "ＤＳ変更履歴情報件数");
        MT_DsHenkouRireki dsHenkouRireki1 = dsHenkouRirekiLst.get(0);
        exStringEquals(dsHenkouRireki1.getDskokno(), "2000000012", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki1.getHenkousikibetukey(), "400000000000000012", "変更識別キー");
        exNumericEquals(dsHenkouRireki1.getRenno(), 1, "連番");
        exStringEquals(dsHenkouRireki1.getTablenm(), "ＤＳ顧客管理テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki1.getTableid(), "MT_DsKokyakuKanri", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki1.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki1.getHanbetukoumokunm(), "ＤＳ顧客管理情報", "判別項目名");
        exStringEquals(dsHenkouRireki1.getHenkoukoumokuid(), "dskokyakujtkbn", "変更項目ID");
        exStringEquals(dsHenkouRireki1.getHenkoukoumokunm(), "ＤＳ顧客状態区分", "変更項目名");
        exStringEquals(dsHenkouRireki1.getBfrnaiyouoriginal(), "1", "変更前内容原本");
        exStringEquals(dsHenkouRireki1.getBfrnaiyou(), "有効取引中", "変更前内容");
        exStringEquals(dsHenkouRireki1.getNewnaiyouoriginal(), "2", "変更後内容原本");
        exStringEquals(dsHenkouRireki1.getNewnaiyou(), "一時停止", "変更後内容");
        exStringEquals(dsHenkouRireki1.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki1.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki2 = dsHenkouRirekiLst.get(1);
        exStringEquals(dsHenkouRireki2.getDskokno(), "2000000012", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki2.getHenkousikibetukey(), "400000000000000012", "変更識別キー");
        exNumericEquals(dsHenkouRireki2.getRenno(), 2, "連番");
        exStringEquals(dsHenkouRireki2.getTablenm(), "ＤＳ顧客管理テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki2.getTableid(), "MT_DsKokyakuKanri", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki2.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki2.getHanbetukoumokunm(), "ＤＳ顧客管理情報", "判別項目名");
        exStringEquals(dsHenkouRireki2.getHenkoukoumokuid(), "dskanyuukeirokbn", "変更項目ID");
        exStringEquals(dsHenkouRireki2.getHenkoukoumokunm(), "ＤＳ加入経路区分", "変更項目名");
        exStringEquals(dsHenkouRireki2.getBfrnaiyouoriginal(), "1", "変更前内容原本");
        exStringEquals(dsHenkouRireki2.getBfrnaiyou(), "新契約同時", "変更前内容");
        exStringEquals(dsHenkouRireki2.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki2.getNewnaiyou(), "", "変更後内容");
        exStringEquals(dsHenkouRireki2.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki2.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki3 = dsHenkouRirekiLst.get(2);
        exStringEquals(dsHenkouRireki3.getDskokno(), "2000000012", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki3.getHenkousikibetukey(), "400000000000000012", "変更識別キー");
        exNumericEquals(dsHenkouRireki3.getRenno(), 3, "連番");
        exStringEquals(dsHenkouRireki3.getTablenm(), "ＤＳ本人確認コードテーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki3.getTableid(), "MT_DsHonninKakuninCd", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki3.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki3.getHanbetukoumokunm(), "ＤＳ本人確認コード情報", "判別項目名");
        exStringEquals(dsHenkouRireki3.getHenkoukoumokuid(), "dskrhnnkakcd", "変更項目ID");
        exStringEquals(dsHenkouRireki3.getHenkoukoumokunm(), "ＤＳ仮本人確認コード", "変更項目名");
        exStringEquals(dsHenkouRireki3.getBfrnaiyouoriginal(), "***", "変更前内容原本");
        exStringEquals(dsHenkouRireki3.getBfrnaiyou(), "***", "変更前内容");
        exStringEquals(dsHenkouRireki3.getNewnaiyouoriginal(), "***", "変更後内容原本");
        exStringEquals(dsHenkouRireki3.getNewnaiyou(), "***", "変更後内容");
        exStringEquals(dsHenkouRireki3.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki3.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki4 = dsHenkouRirekiLst.get(3);
        exStringEquals(dsHenkouRireki4.getDskokno(), "2000000012", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki4.getHenkousikibetukey(), "400000000000000012", "変更識別キー");
        exNumericEquals(dsHenkouRireki4.getRenno(), 4, "連番");
        exStringEquals(dsHenkouRireki4.getTablenm(), "ＤＳ本人確認コードテーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki4.getTableid(), "MT_DsHonninKakuninCd", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki4.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki4.getHanbetukoumokunm(), "ＤＳ本人確認コード情報", "判別項目名");
        exStringEquals(dsHenkouRireki4.getHenkoukoumokuid(), "dskrhnnkakcdttyhkbn", "変更項目ID");
        exStringEquals(dsHenkouRireki4.getHenkoukoumokunm(), "ＤＳ仮本人確認コード通知要否区分", "変更項目名");
        exStringEquals(dsHenkouRireki4.getBfrnaiyouoriginal(), "1", "変更前内容原本");
        exStringEquals(dsHenkouRireki4.getBfrnaiyou(), "要", "変更前内容");
        exStringEquals(dsHenkouRireki4.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki4.getNewnaiyou(), "", "変更後内容");
        exStringEquals(dsHenkouRireki4.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki4.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki5 = dsHenkouRirekiLst.get(4);
        exStringEquals(dsHenkouRireki5.getDskokno(), "2000000012", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki5.getHenkousikibetukey(), "400000000000000012", "変更識別キー");
        exNumericEquals(dsHenkouRireki5.getRenno(), 5, "連番");
        exStringEquals(dsHenkouRireki5.getTablenm(), "ＤＳ本人確認コードテーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki5.getTableid(), "MT_DsHonninKakuninCd", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki5.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki5.getHanbetukoumokunm(), "ＤＳ本人確認コード情報", "判別項目名");
        exStringEquals(dsHenkouRireki5.getHenkoukoumokuid(), "dskrhnnkakcdtttydnjykbn", "変更項目ID");
        exStringEquals(dsHenkouRireki5.getHenkoukoumokunm(), "ＤＳ仮本人確認コード通知中断事由区分", "変更項目名");
        exStringEquals(dsHenkouRireki5.getBfrnaiyouoriginal(), "11", "変更前内容原本");
        exStringEquals(dsHenkouRireki5.getBfrnaiyou(), "名寄せ不可（住所変更中）", "変更前内容");
        exStringEquals(dsHenkouRireki5.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki5.getNewnaiyou(), "", "変更後内容");
        exStringEquals(dsHenkouRireki5.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki5.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki6 = dsHenkouRirekiLst.get(5);
        exStringEquals(dsHenkouRireki6.getDskokno(), "2000000012", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki6.getHenkousikibetukey(), "400000000000000012", "変更識別キー");
        exNumericEquals(dsHenkouRireki6.getRenno(), 6, "連番");
        exStringEquals(dsHenkouRireki6.getTablenm(), "ＤＳログイン管理テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki6.getTableid(), "MT_DsLoginKanri", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki6.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki6.getHanbetukoumokunm(), "ＤＳログイン管理情報", "判別項目名");
        exStringEquals(dsHenkouRireki6.getHenkoukoumokuid(), "syokailoginymd", "変更項目ID");
        exStringEquals(dsHenkouRireki6.getHenkoukoumokunm(), "初回ログイン年月日", "変更項目名");
        exStringEquals(dsHenkouRireki6.getBfrnaiyouoriginal(), "20150419", "変更前内容原本");
        exStringEquals(dsHenkouRireki6.getBfrnaiyou(), "20150419", "変更前内容");
        exStringEquals(dsHenkouRireki6.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki6.getNewnaiyou(), "", "変更後内容");
        exStringEquals(dsHenkouRireki6.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki6.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki7 = dsHenkouRirekiLst.get(6);
        exStringEquals(dsHenkouRireki7.getDskokno(), "2000000012", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki7.getHenkousikibetukey(), "400000000000000012", "変更識別キー");
        exNumericEquals(dsHenkouRireki7.getRenno(), 7, "連番");
        exStringEquals(dsHenkouRireki7.getTablenm(), "ＤＳメールアドレステーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki7.getTableid(), "MT_DsMailAddress", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki7.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki7.getHanbetukoumokunm(), "ＤＳメールアドレス情報　ＤＳメールアドレス連番：300000018", "判別項目名");
        exStringEquals(dsHenkouRireki7.getHenkoukoumokuid(), "dskokno", "変更項目ID");
        exStringEquals(dsHenkouRireki7.getHenkoukoumokunm(), "ＤＳ顧客番号", "変更項目名");
        exStringEquals(dsHenkouRireki7.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki7.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki7.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki7.getNewnaiyou(), "ＤＳ顧客番号：2000000012", "変更後内容");
        exStringEquals(dsHenkouRireki7.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki7.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @Transactional
    @TestOrder(140)
    public void testEditDSTtdkRirekiTblBatch_A14() {

        DsTetudukiRirekiTableEditParam dsTetudukiRirekiTableEditParam = new DsTetudukiRirekiTableEditParamImpl();
        dsTetudukiRirekiTableEditParam.setDskokno("2000000013");
        dsTetudukiRirekiTableEditParam.setHenkousikibetukey("400000000000000013");
        dsTetudukiRirekiTableEditParam.setSyoriYmd(BizDate.valueOf("2016/04/13"));
        dsTetudukiRirekiTableEditParam.setDssyorikbn(C_DsSyoriKbn.LOGIN_SEIKOU);
        dsTetudukiRirekiTableEditParam.setHenkouRrkYouhi(C_YouhiKbn.YOU);
        MT_DsKokyakuKanri entity = directDomManager.getDsKokyakuKanri("2000000013");
        entity.setDskokyakujtkbn(C_DsKokyakuJtKbn.ITIJI_TEISI);
        dsTetudukiRirekiTableEditParam.setDsKokyakuKanri(entity);
        MT_BAK_DsKokyakuKanri bakEntity = directDomManager.getBAKDsKokyakuKanri("2000000013", "400000000000000013");
        bakEntity.setDskokyakujtkbn(C_DsKokyakuJtKbn.YUUKOU);
        dsTetudukiRirekiTableEditParam.setBakDsKokyakuKanri(bakEntity);

        editDSTtdkRirekiTbl.editDSTtdkRirekiTblBatch(dsTetudukiRirekiTableEditParam);

        MT_DsKokyakuKanri dsKokyakuKanri = directDomManager.getDsKokyakuKanri(dsTetudukiRirekiTableEditParam.getDskokno());

        List<MT_DsTtdkRireki> dsTtdkRirekiLst = dsKokyakuKanri.getDsTtdkRirekis();

        exNumericEquals(dsTtdkRirekiLst.size(), 1, "ＤＳ手続履歴情報件数");

        MT_DsTtdkRireki dsTtdkRireki = dsTtdkRirekiLst.get(0);

        List<MT_DsHenkouRireki> dsHenkouRirekiLst = dsTtdkRireki.getDsHenkouRirekis();
        exNumericEquals(dsHenkouRirekiLst.size(), 7, "ＤＳ変更履歴情報件数");
        MT_DsHenkouRireki dsHenkouRireki1 = dsHenkouRirekiLst.get(0);
        exStringEquals(dsHenkouRireki1.getDskokno(), "2000000013", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki1.getHenkousikibetukey(), "400000000000000013", "変更識別キー");
        exNumericEquals(dsHenkouRireki1.getRenno(), 1, "連番");
        exStringEquals(dsHenkouRireki1.getTablenm(), "ＤＳ顧客管理テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki1.getTableid(), "MT_DsKokyakuKanri", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki1.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki1.getHanbetukoumokunm(), "ＤＳ顧客管理情報", "判別項目名");
        exStringEquals(dsHenkouRireki1.getHenkoukoumokuid(), "dskokyakujtkbn", "変更項目ID");
        exStringEquals(dsHenkouRireki1.getHenkoukoumokunm(), "ＤＳ顧客状態区分", "変更項目名");
        exStringEquals(dsHenkouRireki1.getBfrnaiyouoriginal(), "1", "変更前内容原本");
        exStringEquals(dsHenkouRireki1.getBfrnaiyou(), "有効取引中", "変更前内容");
        exStringEquals(dsHenkouRireki1.getNewnaiyouoriginal(), "2", "変更後内容原本");
        exStringEquals(dsHenkouRireki1.getNewnaiyou(), "一時停止", "変更後内容");
        exStringEquals(dsHenkouRireki1.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki1.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki2 = dsHenkouRirekiLst.get(1);
        exStringEquals(dsHenkouRireki2.getDskokno(), "2000000013", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki2.getHenkousikibetukey(), "400000000000000013", "変更識別キー");
        exNumericEquals(dsHenkouRireki2.getRenno(), 2, "連番");
        exStringEquals(dsHenkouRireki2.getTablenm(), "ＤＳ顧客管理テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki2.getTableid(), "MT_DsKokyakuKanri", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki2.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki2.getHanbetukoumokunm(), "ＤＳ顧客管理情報", "判別項目名");
        exStringEquals(dsHenkouRireki2.getHenkoukoumokuid(), "dskanyuukeirokbn", "変更項目ID");
        exStringEquals(dsHenkouRireki2.getHenkoukoumokunm(), "ＤＳ加入経路区分", "変更項目名");
        exStringEquals(dsHenkouRireki2.getBfrnaiyouoriginal(), "1", "変更前内容原本");
        exStringEquals(dsHenkouRireki2.getBfrnaiyou(), "新契約同時", "変更前内容");
        exStringEquals(dsHenkouRireki2.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki2.getNewnaiyou(), "", "変更後内容");
        exStringEquals(dsHenkouRireki2.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki2.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki3 = dsHenkouRirekiLst.get(2);
        exStringEquals(dsHenkouRireki3.getDskokno(), "2000000013", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki3.getHenkousikibetukey(), "400000000000000013", "変更識別キー");
        exNumericEquals(dsHenkouRireki3.getRenno(), 3, "連番");
        exStringEquals(dsHenkouRireki3.getTablenm(), "ＤＳ本人確認コードテーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki3.getTableid(), "MT_DsHonninKakuninCd", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki3.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki3.getHanbetukoumokunm(), "ＤＳ本人確認コード情報", "判別項目名");
        exStringEquals(dsHenkouRireki3.getHenkoukoumokuid(), "dskrhnnkakcd", "変更項目ID");
        exStringEquals(dsHenkouRireki3.getHenkoukoumokunm(), "ＤＳ仮本人確認コード", "変更項目名");
        exStringEquals(dsHenkouRireki3.getBfrnaiyouoriginal(), "***", "変更前内容原本");
        exStringEquals(dsHenkouRireki3.getBfrnaiyou(), "***", "変更前内容");
        exStringEquals(dsHenkouRireki3.getNewnaiyouoriginal(), "***", "変更後内容原本");
        exStringEquals(dsHenkouRireki3.getNewnaiyou(), "***", "変更後内容");
        exStringEquals(dsHenkouRireki3.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki3.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki4 = dsHenkouRirekiLst.get(3);
        exStringEquals(dsHenkouRireki4.getDskokno(), "2000000013", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki4.getHenkousikibetukey(), "400000000000000013", "変更識別キー");
        exNumericEquals(dsHenkouRireki4.getRenno(), 4, "連番");
        exStringEquals(dsHenkouRireki4.getTablenm(), "ＤＳ本人確認コードテーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki4.getTableid(), "MT_DsHonninKakuninCd", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki4.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki4.getHanbetukoumokunm(), "ＤＳ本人確認コード情報", "判別項目名");
        exStringEquals(dsHenkouRireki4.getHenkoukoumokuid(), "dskrhnnkakcdttyhkbn", "変更項目ID");
        exStringEquals(dsHenkouRireki4.getHenkoukoumokunm(), "ＤＳ仮本人確認コード通知要否区分", "変更項目名");
        exStringEquals(dsHenkouRireki4.getBfrnaiyouoriginal(), "1", "変更前内容原本");
        exStringEquals(dsHenkouRireki4.getBfrnaiyou(), "要", "変更前内容");
        exStringEquals(dsHenkouRireki4.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki4.getNewnaiyou(), "", "変更後内容");
        exStringEquals(dsHenkouRireki4.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki4.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki5 = dsHenkouRirekiLst.get(4);
        exStringEquals(dsHenkouRireki5.getDskokno(), "2000000013", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki5.getHenkousikibetukey(), "400000000000000013", "変更識別キー");
        exNumericEquals(dsHenkouRireki5.getRenno(), 5, "連番");
        exStringEquals(dsHenkouRireki5.getTablenm(), "ＤＳ本人確認コードテーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki5.getTableid(), "MT_DsHonninKakuninCd", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki5.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki5.getHanbetukoumokunm(), "ＤＳ本人確認コード情報", "判別項目名");
        exStringEquals(dsHenkouRireki5.getHenkoukoumokuid(), "dskrhnnkakcdtttydnjykbn", "変更項目ID");
        exStringEquals(dsHenkouRireki5.getHenkoukoumokunm(), "ＤＳ仮本人確認コード通知中断事由区分", "変更項目名");
        exStringEquals(dsHenkouRireki5.getBfrnaiyouoriginal(), "11", "変更前内容原本");
        exStringEquals(dsHenkouRireki5.getBfrnaiyou(), "名寄せ不可（住所変更中）", "変更前内容");
        exStringEquals(dsHenkouRireki5.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki5.getNewnaiyou(), "", "変更後内容");
        exStringEquals(dsHenkouRireki5.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki5.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki6 = dsHenkouRirekiLst.get(5);
        exStringEquals(dsHenkouRireki6.getDskokno(), "2000000013", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki6.getHenkousikibetukey(), "400000000000000013", "変更識別キー");
        exNumericEquals(dsHenkouRireki6.getRenno(), 6, "連番");
        exStringEquals(dsHenkouRireki6.getTablenm(), "ＤＳログイン管理テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki6.getTableid(), "MT_DsLoginKanri", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki6.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki6.getHanbetukoumokunm(), "ＤＳログイン管理情報", "判別項目名");
        exStringEquals(dsHenkouRireki6.getHenkoukoumokuid(), "syokailoginymd", "変更項目ID");
        exStringEquals(dsHenkouRireki6.getHenkoukoumokunm(), "初回ログイン年月日", "変更項目名");
        exStringEquals(dsHenkouRireki6.getBfrnaiyouoriginal(), "20150419", "変更前内容原本");
        exStringEquals(dsHenkouRireki6.getBfrnaiyou(), "20150419", "変更前内容");
        exStringEquals(dsHenkouRireki6.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki6.getNewnaiyou(), "", "変更後内容");
        exStringEquals(dsHenkouRireki6.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki6.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki7 = dsHenkouRirekiLst.get(6);
        exStringEquals(dsHenkouRireki7.getDskokno(), "2000000013", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki7.getHenkousikibetukey(), "400000000000000013", "変更識別キー");
        exNumericEquals(dsHenkouRireki7.getRenno(), 7, "連番");
        exStringEquals(dsHenkouRireki7.getTablenm(), "ＤＳメールアドレステーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki7.getTableid(), "MT_DsMailAddress", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki7.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki7.getHanbetukoumokunm(), "ＤＳメールアドレス情報　ＤＳメールアドレス連番：300000019", "判別項目名");
        exStringEquals(dsHenkouRireki7.getHenkoukoumokuid(), "dskokno", "変更項目ID");
        exStringEquals(dsHenkouRireki7.getHenkoukoumokunm(), "ＤＳ顧客番号", "変更項目名");
        exStringEquals(dsHenkouRireki7.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki7.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki7.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki7.getNewnaiyou(), "ＤＳ顧客番号：2000000013", "変更後内容");
        exStringEquals(dsHenkouRireki7.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki7.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @Transactional
    @TestOrder(150)
    public void testEditDSTtdkRirekiTblBatch_A15() {

        DsTetudukiRirekiTableEditParam dsTetudukiRirekiTableEditParam = new DsTetudukiRirekiTableEditParamImpl();
        dsTetudukiRirekiTableEditParam.setDskokno("2000000014");
        dsTetudukiRirekiTableEditParam.setHenkousikibetukey("400000000000000014");
        dsTetudukiRirekiTableEditParam.setSyoriYmd(BizDate.valueOf("2016/04/13"));
        dsTetudukiRirekiTableEditParam.setDssyorikbn(C_DsSyoriKbn.LOGIN_SEIKOU);
        dsTetudukiRirekiTableEditParam.setHenkouRrkYouhi(C_YouhiKbn.YOU);
        MT_DsKokyakuKanri entity = directDomManager.getDsKokyakuKanri("2000000014");
        entity.setDskokyakujtkbn(C_DsKokyakuJtKbn.ITIJI_TEISI);
        dsTetudukiRirekiTableEditParam.setDsKokyakuKanri(entity);
        MT_BAK_DsKokyakuKanri bakEntity = directDomManager.getBAKDsKokyakuKanri("2000000014", "400000000000000014");
        bakEntity.setDskokyakujtkbn(C_DsKokyakuJtKbn.YUUKOU);
        dsTetudukiRirekiTableEditParam.setBakDsKokyakuKanri(bakEntity);

        editDSTtdkRirekiTbl.editDSTtdkRirekiTblBatch(dsTetudukiRirekiTableEditParam);

        MT_DsKokyakuKanri dsKokyakuKanri = directDomManager.getDsKokyakuKanri(dsTetudukiRirekiTableEditParam.getDskokno());

        List<MT_DsTtdkRireki> dsTtdkRirekiLst = dsKokyakuKanri.getDsTtdkRirekis();

        exNumericEquals(dsTtdkRirekiLst.size(), 1, "ＤＳ手続履歴情報件数");

        MT_DsTtdkRireki dsTtdkRireki = dsTtdkRirekiLst.get(0);

        List<MT_DsHenkouRireki> dsHenkouRirekiLst = dsTtdkRireki.getDsHenkouRirekis();
        exNumericEquals(dsHenkouRirekiLst.size(), 7, "ＤＳ変更履歴情報件数");
        MT_DsHenkouRireki dsHenkouRireki1 = dsHenkouRirekiLst.get(0);
        exStringEquals(dsHenkouRireki1.getDskokno(), "2000000014", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki1.getHenkousikibetukey(), "400000000000000014", "変更識別キー");
        exNumericEquals(dsHenkouRireki1.getRenno(), 1, "連番");
        exStringEquals(dsHenkouRireki1.getTablenm(), "ＤＳ顧客管理テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki1.getTableid(), "MT_DsKokyakuKanri", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki1.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki1.getHanbetukoumokunm(), "ＤＳ顧客管理情報", "判別項目名");
        exStringEquals(dsHenkouRireki1.getHenkoukoumokuid(), "dskokyakujtkbn", "変更項目ID");
        exStringEquals(dsHenkouRireki1.getHenkoukoumokunm(), "ＤＳ顧客状態区分", "変更項目名");
        exStringEquals(dsHenkouRireki1.getBfrnaiyouoriginal(), "1", "変更前内容原本");
        exStringEquals(dsHenkouRireki1.getBfrnaiyou(), "有効取引中", "変更前内容");
        exStringEquals(dsHenkouRireki1.getNewnaiyouoriginal(), "2", "変更後内容原本");
        exStringEquals(dsHenkouRireki1.getNewnaiyou(), "一時停止", "変更後内容");
        exStringEquals(dsHenkouRireki1.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki1.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki2 = dsHenkouRirekiLst.get(1);
        exStringEquals(dsHenkouRireki2.getDskokno(), "2000000014", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki2.getHenkousikibetukey(), "400000000000000014", "変更識別キー");
        exNumericEquals(dsHenkouRireki2.getRenno(), 2, "連番");
        exStringEquals(dsHenkouRireki2.getTablenm(), "ＤＳ顧客管理テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki2.getTableid(), "MT_DsKokyakuKanri", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki2.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki2.getHanbetukoumokunm(), "ＤＳ顧客管理情報", "判別項目名");
        exStringEquals(dsHenkouRireki2.getHenkoukoumokuid(), "dskanyuukeirokbn", "変更項目ID");
        exStringEquals(dsHenkouRireki2.getHenkoukoumokunm(), "ＤＳ加入経路区分", "変更項目名");
        exStringEquals(dsHenkouRireki2.getBfrnaiyouoriginal(), "1", "変更前内容原本");
        exStringEquals(dsHenkouRireki2.getBfrnaiyou(), "新契約同時", "変更前内容");
        exStringEquals(dsHenkouRireki2.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki2.getNewnaiyou(), "", "変更後内容");
        exStringEquals(dsHenkouRireki2.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki2.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki3 = dsHenkouRirekiLst.get(2);
        exStringEquals(dsHenkouRireki3.getDskokno(), "2000000014", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki3.getHenkousikibetukey(), "400000000000000014", "変更識別キー");
        exNumericEquals(dsHenkouRireki3.getRenno(), 3, "連番");
        exStringEquals(dsHenkouRireki3.getTablenm(), "ＤＳ本人確認コードテーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki3.getTableid(), "MT_DsHonninKakuninCd", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki3.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki3.getHanbetukoumokunm(), "ＤＳ本人確認コード情報", "判別項目名");
        exStringEquals(dsHenkouRireki3.getHenkoukoumokuid(), "dskrhnnkakcd", "変更項目ID");
        exStringEquals(dsHenkouRireki3.getHenkoukoumokunm(), "ＤＳ仮本人確認コード", "変更項目名");
        exStringEquals(dsHenkouRireki3.getBfrnaiyouoriginal(), "***", "変更前内容原本");
        exStringEquals(dsHenkouRireki3.getBfrnaiyou(), "***", "変更前内容");
        exStringEquals(dsHenkouRireki3.getNewnaiyouoriginal(), "***", "変更後内容原本");
        exStringEquals(dsHenkouRireki3.getNewnaiyou(), "***", "変更後内容");
        exStringEquals(dsHenkouRireki3.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki3.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki4 = dsHenkouRirekiLst.get(3);
        exStringEquals(dsHenkouRireki4.getDskokno(), "2000000014", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki4.getHenkousikibetukey(), "400000000000000014", "変更識別キー");
        exNumericEquals(dsHenkouRireki4.getRenno(), 4, "連番");
        exStringEquals(dsHenkouRireki4.getTablenm(), "ＤＳ本人確認コードテーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki4.getTableid(), "MT_DsHonninKakuninCd", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki4.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki4.getHanbetukoumokunm(), "ＤＳ本人確認コード情報", "判別項目名");
        exStringEquals(dsHenkouRireki4.getHenkoukoumokuid(), "dskrhnnkakcdttyhkbn", "変更項目ID");
        exStringEquals(dsHenkouRireki4.getHenkoukoumokunm(), "ＤＳ仮本人確認コード通知要否区分", "変更項目名");
        exStringEquals(dsHenkouRireki4.getBfrnaiyouoriginal(), "1", "変更前内容原本");
        exStringEquals(dsHenkouRireki4.getBfrnaiyou(), "要", "変更前内容");
        exStringEquals(dsHenkouRireki4.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki4.getNewnaiyou(), "", "変更後内容");
        exStringEquals(dsHenkouRireki4.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki4.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki5 = dsHenkouRirekiLst.get(4);
        exStringEquals(dsHenkouRireki5.getDskokno(), "2000000014", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki5.getHenkousikibetukey(), "400000000000000014", "変更識別キー");
        exNumericEquals(dsHenkouRireki5.getRenno(), 5, "連番");
        exStringEquals(dsHenkouRireki5.getTablenm(), "ＤＳ本人確認コードテーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki5.getTableid(), "MT_DsHonninKakuninCd", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki5.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki5.getHanbetukoumokunm(), "ＤＳ本人確認コード情報", "判別項目名");
        exStringEquals(dsHenkouRireki5.getHenkoukoumokuid(), "dskrhnnkakcdtttydnjykbn", "変更項目ID");
        exStringEquals(dsHenkouRireki5.getHenkoukoumokunm(), "ＤＳ仮本人確認コード通知中断事由区分", "変更項目名");
        exStringEquals(dsHenkouRireki5.getBfrnaiyouoriginal(), "11", "変更前内容原本");
        exStringEquals(dsHenkouRireki5.getBfrnaiyou(), "名寄せ不可（住所変更中）", "変更前内容");
        exStringEquals(dsHenkouRireki5.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki5.getNewnaiyou(), "", "変更後内容");
        exStringEquals(dsHenkouRireki5.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki5.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki6 = dsHenkouRirekiLst.get(5);
        exStringEquals(dsHenkouRireki6.getDskokno(), "2000000014", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki6.getHenkousikibetukey(), "400000000000000014", "変更識別キー");
        exNumericEquals(dsHenkouRireki6.getRenno(), 6, "連番");
        exStringEquals(dsHenkouRireki6.getTablenm(), "ＤＳログイン管理テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki6.getTableid(), "MT_DsLoginKanri", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki6.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki6.getHanbetukoumokunm(), "ＤＳログイン管理情報", "判別項目名");
        exStringEquals(dsHenkouRireki6.getHenkoukoumokuid(), "syokailoginymd", "変更項目ID");
        exStringEquals(dsHenkouRireki6.getHenkoukoumokunm(), "初回ログイン年月日", "変更項目名");
        exStringEquals(dsHenkouRireki6.getBfrnaiyouoriginal(), "20150419", "変更前内容原本");
        exStringEquals(dsHenkouRireki6.getBfrnaiyou(), "20150419", "変更前内容");
        exStringEquals(dsHenkouRireki6.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki6.getNewnaiyou(), "", "変更後内容");
        exStringEquals(dsHenkouRireki6.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki6.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki7 = dsHenkouRirekiLst.get(6);
        exStringEquals(dsHenkouRireki7.getDskokno(), "2000000014", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki7.getHenkousikibetukey(), "400000000000000014", "変更識別キー");
        exNumericEquals(dsHenkouRireki7.getRenno(), 7, "連番");
        exStringEquals(dsHenkouRireki7.getTablenm(), "ＤＳメールアドレステーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki7.getTableid(), "MT_DsMailAddress", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki7.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki7.getHanbetukoumokunm(), "ＤＳメールアドレス情報　ＤＳメールアドレス連番：300000020", "判別項目名");
        exStringEquals(dsHenkouRireki7.getHenkoukoumokuid(), "dskokno", "変更項目ID");
        exStringEquals(dsHenkouRireki7.getHenkoukoumokunm(), "ＤＳ顧客番号", "変更項目名");
        exStringEquals(dsHenkouRireki7.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki7.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki7.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki7.getNewnaiyou(), "ＤＳ顧客番号：2000000014", "変更後内容");
        exStringEquals(dsHenkouRireki7.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki7.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @Transactional
    @TestOrder(160)
    public void testEditDSTtdkRirekiTblBatch_A16() {

        DsTetudukiRirekiTableEditParam dsTetudukiRirekiTableEditParam = new DsTetudukiRirekiTableEditParamImpl();
        dsTetudukiRirekiTableEditParam.setDskokno("2000000015");
        dsTetudukiRirekiTableEditParam.setHenkousikibetukey("400000000000000015");
        dsTetudukiRirekiTableEditParam.setSyoriYmd(BizDate.valueOf("2016/04/13"));
        dsTetudukiRirekiTableEditParam.setDssyorikbn(C_DsSyoriKbn.LOGIN_SEIKOU);
        dsTetudukiRirekiTableEditParam.setHenkouRrkYouhi(C_YouhiKbn.YOU);
        MT_DsKokyakuKanri entity = directDomManager.getDsKokyakuKanri("2000000015");
        entity.setDskokyakujtkbn(C_DsKokyakuJtKbn.ITIJI_TEISI);
        dsTetudukiRirekiTableEditParam.setDsKokyakuKanri(entity);
        MT_BAK_DsKokyakuKanri bakEntity = directDomManager.getBAKDsKokyakuKanri("2000000015", "400000000000000015");
        bakEntity.setDskokyakujtkbn(C_DsKokyakuJtKbn.YUUKOU);
        dsTetudukiRirekiTableEditParam.setBakDsKokyakuKanri(bakEntity);

        editDSTtdkRirekiTbl.editDSTtdkRirekiTblBatch(dsTetudukiRirekiTableEditParam);

        MT_DsKokyakuKanri dsKokyakuKanri = directDomManager.getDsKokyakuKanri(dsTetudukiRirekiTableEditParam.getDskokno());

        List<MT_DsTtdkRireki> dsTtdkRirekiLst = dsKokyakuKanri.getDsTtdkRirekis();

        exNumericEquals(dsTtdkRirekiLst.size(), 1, "ＤＳ手続履歴情報件数");

        MT_DsTtdkRireki dsTtdkRireki = dsTtdkRirekiLst.get(0);

        List<MT_DsHenkouRireki> dsHenkouRirekiLst = dsTtdkRireki.getDsHenkouRirekis();
        exNumericEquals(dsHenkouRirekiLst.size(), 8, "ＤＳ変更履歴情報件数");
        MT_DsHenkouRireki dsHenkouRireki1 = dsHenkouRirekiLst.get(0);
        exStringEquals(dsHenkouRireki1.getDskokno(), "2000000015", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki1.getHenkousikibetukey(), "400000000000000015", "変更識別キー");
        exNumericEquals(dsHenkouRireki1.getRenno(), 1, "連番");
        exStringEquals(dsHenkouRireki1.getTablenm(), "ＤＳ顧客管理テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki1.getTableid(), "MT_DsKokyakuKanri", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki1.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki1.getHanbetukoumokunm(), "ＤＳ顧客管理情報", "判別項目名");
        exStringEquals(dsHenkouRireki1.getHenkoukoumokuid(), "dskokyakujtkbn", "変更項目ID");
        exStringEquals(dsHenkouRireki1.getHenkoukoumokunm(), "ＤＳ顧客状態区分", "変更項目名");
        exStringEquals(dsHenkouRireki1.getBfrnaiyouoriginal(), "1", "変更前内容原本");
        exStringEquals(dsHenkouRireki1.getBfrnaiyou(), "有効取引中", "変更前内容");
        exStringEquals(dsHenkouRireki1.getNewnaiyouoriginal(), "2", "変更後内容原本");
        exStringEquals(dsHenkouRireki1.getNewnaiyou(), "一時停止", "変更後内容");
        exStringEquals(dsHenkouRireki1.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki1.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki2 = dsHenkouRirekiLst.get(1);
        exStringEquals(dsHenkouRireki2.getDskokno(), "2000000015", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki2.getHenkousikibetukey(), "400000000000000015", "変更識別キー");
        exNumericEquals(dsHenkouRireki2.getRenno(), 2, "連番");
        exStringEquals(dsHenkouRireki2.getTablenm(), "ＤＳ顧客管理テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki2.getTableid(), "MT_DsKokyakuKanri", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki2.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki2.getHanbetukoumokunm(), "ＤＳ顧客管理情報", "判別項目名");
        exStringEquals(dsHenkouRireki2.getHenkoukoumokuid(), "dskanyuukeirokbn", "変更項目ID");
        exStringEquals(dsHenkouRireki2.getHenkoukoumokunm(), "ＤＳ加入経路区分", "変更項目名");
        exStringEquals(dsHenkouRireki2.getBfrnaiyouoriginal(), "1", "変更前内容原本");
        exStringEquals(dsHenkouRireki2.getBfrnaiyou(), "新契約同時", "変更前内容");
        exStringEquals(dsHenkouRireki2.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki2.getNewnaiyou(), "", "変更後内容");
        exStringEquals(dsHenkouRireki2.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki2.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki3 = dsHenkouRirekiLst.get(2);
        exStringEquals(dsHenkouRireki3.getDskokno(), "2000000015", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki3.getHenkousikibetukey(), "400000000000000015", "変更識別キー");
        exNumericEquals(dsHenkouRireki3.getRenno(), 3, "連番");
        exStringEquals(dsHenkouRireki3.getTablenm(), "ＤＳ本人確認コードテーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki3.getTableid(), "MT_DsHonninKakuninCd", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki3.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki3.getHanbetukoumokunm(), "ＤＳ本人確認コード情報", "判別項目名");
        exStringEquals(dsHenkouRireki3.getHenkoukoumokuid(), "dskrhnnkakcd", "変更項目ID");
        exStringEquals(dsHenkouRireki3.getHenkoukoumokunm(), "ＤＳ仮本人確認コード", "変更項目名");
        exStringEquals(dsHenkouRireki3.getBfrnaiyouoriginal(), "***", "変更前内容原本");
        exStringEquals(dsHenkouRireki3.getBfrnaiyou(), "***", "変更前内容");
        exStringEquals(dsHenkouRireki3.getNewnaiyouoriginal(), "***", "変更後内容原本");
        exStringEquals(dsHenkouRireki3.getNewnaiyou(), "***", "変更後内容");
        exStringEquals(dsHenkouRireki3.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki3.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki4 = dsHenkouRirekiLst.get(3);
        exStringEquals(dsHenkouRireki4.getDskokno(), "2000000015", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki4.getHenkousikibetukey(), "400000000000000015", "変更識別キー");
        exNumericEquals(dsHenkouRireki4.getRenno(), 4, "連番");
        exStringEquals(dsHenkouRireki4.getTablenm(), "ＤＳ本人確認コードテーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki4.getTableid(), "MT_DsHonninKakuninCd", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki4.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki4.getHanbetukoumokunm(), "ＤＳ本人確認コード情報", "判別項目名");
        exStringEquals(dsHenkouRireki4.getHenkoukoumokuid(), "dskrhnnkakcdttyhkbn", "変更項目ID");
        exStringEquals(dsHenkouRireki4.getHenkoukoumokunm(), "ＤＳ仮本人確認コード通知要否区分", "変更項目名");
        exStringEquals(dsHenkouRireki4.getBfrnaiyouoriginal(), "1", "変更前内容原本");
        exStringEquals(dsHenkouRireki4.getBfrnaiyou(), "要", "変更前内容");
        exStringEquals(dsHenkouRireki4.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki4.getNewnaiyou(), "", "変更後内容");
        exStringEquals(dsHenkouRireki4.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki4.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki5 = dsHenkouRirekiLst.get(4);
        exStringEquals(dsHenkouRireki5.getDskokno(), "2000000015", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki5.getHenkousikibetukey(), "400000000000000015", "変更識別キー");
        exNumericEquals(dsHenkouRireki5.getRenno(), 5, "連番");
        exStringEquals(dsHenkouRireki5.getTablenm(), "ＤＳ本人確認コードテーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki5.getTableid(), "MT_DsHonninKakuninCd", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki5.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki5.getHanbetukoumokunm(), "ＤＳ本人確認コード情報", "判別項目名");
        exStringEquals(dsHenkouRireki5.getHenkoukoumokuid(), "dskrhnnkakcdtttydnjykbn", "変更項目ID");
        exStringEquals(dsHenkouRireki5.getHenkoukoumokunm(), "ＤＳ仮本人確認コード通知中断事由区分", "変更項目名");
        exStringEquals(dsHenkouRireki5.getBfrnaiyouoriginal(), "11", "変更前内容原本");
        exStringEquals(dsHenkouRireki5.getBfrnaiyou(), "名寄せ不可（住所変更中）", "変更前内容");
        exStringEquals(dsHenkouRireki5.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki5.getNewnaiyou(), "", "変更後内容");
        exStringEquals(dsHenkouRireki5.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki5.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki6 = dsHenkouRirekiLst.get(5);
        exStringEquals(dsHenkouRireki6.getDskokno(), "2000000015", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki6.getHenkousikibetukey(), "400000000000000015", "変更識別キー");
        exNumericEquals(dsHenkouRireki6.getRenno(), 6, "連番");
        exStringEquals(dsHenkouRireki6.getTablenm(), "ＤＳログイン管理テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki6.getTableid(), "MT_DsLoginKanri", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki6.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki6.getHanbetukoumokunm(), "ＤＳログイン管理情報", "判別項目名");
        exStringEquals(dsHenkouRireki6.getHenkoukoumokuid(), "syokailoginymd", "変更項目ID");
        exStringEquals(dsHenkouRireki6.getHenkoukoumokunm(), "初回ログイン年月日", "変更項目名");
        exStringEquals(dsHenkouRireki6.getBfrnaiyouoriginal(), "20150419", "変更前内容原本");
        exStringEquals(dsHenkouRireki6.getBfrnaiyou(), "20150419", "変更前内容");
        exStringEquals(dsHenkouRireki6.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki6.getNewnaiyou(), "", "変更後内容");
        exStringEquals(dsHenkouRireki6.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki6.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki7 = dsHenkouRirekiLst.get(6);
        exStringEquals(dsHenkouRireki7.getDskokno(), "2000000015", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki7.getHenkousikibetukey(), "400000000000000015", "変更識別キー");
        exNumericEquals(dsHenkouRireki7.getRenno(), 7, "連番");
        exStringEquals(dsHenkouRireki7.getTablenm(), "ＤＳメールアドレステーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki7.getTableid(), "MT_DsMailAddress", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki7.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki7.getHanbetukoumokunm(), "ＤＳメールアドレス情報　ＤＳメールアドレス連番：300000021", "判別項目名");
        exStringEquals(dsHenkouRireki7.getHenkoukoumokuid(), "dskokno", "変更項目ID");
        exStringEquals(dsHenkouRireki7.getHenkoukoumokunm(), "ＤＳ顧客番号", "変更項目名");
        exStringEquals(dsHenkouRireki7.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki7.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki7.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki7.getNewnaiyou(), "ＤＳ顧客番号：2000000015", "変更後内容");
        exStringEquals(dsHenkouRireki7.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki7.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki8 = dsHenkouRirekiLst.get(7);
        exStringEquals(dsHenkouRireki8.getDskokno(), "2000000015", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki8.getHenkousikibetukey(), "400000000000000015", "変更識別キー");
        exNumericEquals(dsHenkouRireki8.getRenno(), 8, "連番");
        exStringEquals(dsHenkouRireki8.getTablenm(), "ＤＳ送金用口座テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki8.getTableid(), "MT_DsSoukinyouKouza", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki8.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki8.getHanbetukoumokunm(), "ＤＳ送金用口座情報　証券番号：17806000356　ＤＳ送金用口座情報　口座種類区分：外貨口座", "判別項目名");
        exStringEquals(dsHenkouRireki8.getHenkoukoumokuid(), "syono, kzsyuruikbn", "変更項目ID");
        exStringEquals(dsHenkouRireki8.getHenkoukoumokunm(), "証券番号、口座種類区分", "変更項目名");
        exStringEquals(dsHenkouRireki8.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki8.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki8.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki8.getNewnaiyou(), "証券番号：17806000356　口座種類区分：外貨口座", "変更後内容");
        exStringEquals(dsHenkouRireki8.getGyoumuKousinKinou(), "DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblB", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki8.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }
}
