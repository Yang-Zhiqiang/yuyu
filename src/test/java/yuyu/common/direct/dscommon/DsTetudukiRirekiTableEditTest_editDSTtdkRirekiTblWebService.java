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
import yuyu.def.classification.C_DsKinouidKbn;
import yuyu.def.classification.C_DsSyoriKbn;
import yuyu.def.classification.C_HnkSyuruiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.MT_DsHenkouRireki;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsTtdkRireki;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＤＳ手続履歴テーブル編集クラスのメソッド {@link DsTetudukiRirekiTableEdit#editDSTtdkRirekiTblWebService()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblWebService {

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
            testDataAndTblMap = testDataMaker.getInData(DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblWebService.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("準備データ３", testDataAndTblMap);
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
    public void testEditDSTtdkRirekiTblWebService_A1() {

        DsTetudukiRirekiTableEditParam dsTetudukiRirekiTableEditParam = new DsTetudukiRirekiTableEditParamImpl();
        dsTetudukiRirekiTableEditParam.setDskokno("1000000000");
        dsTetudukiRirekiTableEditParam.setHenkouRrkYouhi(C_YouhiKbn.YOU);
        AS_Kinou kinou = SWAKInjector.getInstance(AS_Kinou.class);
        kinou.setKinouId(C_DsKinouidKbn.PASSWORDHENKOU.getValue());

        try{
            editDSTtdkRirekiTbl.editDSTtdkRirekiTblWebService(dsTetudukiRirekiTableEditParam, kinou);
        }
        catch (BizAppException e) {
            exStringEquals(e.getMessage(), "テーブル取得エラー　MT_DsKokyakuKanri　key:dskokno=1000000000", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testEditDSTtdkRirekiTblWebService_A2() {

        DsTetudukiRirekiTableEditParam dsTetudukiRirekiTableEditParam = new DsTetudukiRirekiTableEditParamImpl();
        dsTetudukiRirekiTableEditParam.setDskokno("1000000001");
        dsTetudukiRirekiTableEditParam.setHenkousikibetukey("200000000000000001");
        dsTetudukiRirekiTableEditParam.setSyoriYmd(BizDate.valueOf("2016/04/13"));
        dsTetudukiRirekiTableEditParam.setDssyorikbn(C_DsSyoriKbn.LOGIN_SEIKOU);
        dsTetudukiRirekiTableEditParam.setHenkouRrkYouhi(C_YouhiKbn.YOU);

        AS_Kinou kinou = SWAKInjector.getInstance(AS_Kinou.class);
        kinou.setKinouId(C_DsKinouidKbn.PASSWORDHENKOU.getValue());

        editDSTtdkRirekiTbl.editDSTtdkRirekiTblWebService(dsTetudukiRirekiTableEditParam, kinou);

        MT_DsKokyakuKanri dsKokyakuKanri = directDomManager.getDsKokyakuKanri(dsTetudukiRirekiTableEditParam.getDskokno());

        List<MT_DsTtdkRireki> dsTtdkRirekiLst = dsKokyakuKanri.getDsTtdkRirekis();

        exNumericEquals(dsTtdkRirekiLst.size(), 1, "ＤＳ手続履歴情報件数");

        MT_DsTtdkRireki dsTtdkRireki = dsTtdkRirekiLst.get(0);
        exStringEquals(dsTtdkRireki.getDskokno(), "1000000001", "ＤＳ手続履歴テーブルエンティティ．ＤＳ顧客番号");
        exStringEquals(dsTtdkRireki.getHenkousikibetukey(), "200000000000000001", "ＤＳ手続履歴テーブルエンティティ．変更識別キー");
        exDateEquals(dsTtdkRireki.getSyoriYmd(), BizDate.valueOf("2016/04/13"), "ＤＳ手続履歴テーブルエンティティ．処理年月日");
        exClassificationEquals(dsTtdkRireki.getDssyorikbn(), C_DsSyoriKbn.LOGIN_SEIKOU, "ＤＳ手続履歴テーブルエンティティ．ＤＳ処理区分");
        exClassificationEquals(dsTtdkRireki.getHenkourrkumu(), C_UmuKbn.ARI, "ＤＳ手続履歴テーブルエンティティ．変更履歴有無");
        exStringEquals(dsTtdkRireki.getGyoumuKousinKinou(), "dwpasswordhenkou", "ＤＳ手続履歴テーブルエンティティ．業務用更新機能ＩＤ");
        exStringEquals(dsTtdkRireki.getGyoumuKousinsyaId(), "JUnit", "ＤＳ手続履歴テーブルエンティティ．業務用更新者ＩＤ");

        List<MT_DsHenkouRireki> dsHenkouRirekiLst = dsTtdkRireki.getDsHenkouRirekis();
        exNumericEquals(dsHenkouRirekiLst.size(), 5, "ＤＳ変更履歴情報件数");

        MT_DsHenkouRireki dsHenkouRireki1 = dsHenkouRirekiLst.get(0);
        exStringEquals(dsHenkouRireki1.getDskokno(), "1000000001", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki1.getHenkousikibetukey(), "200000000000000001", "変更識別キー");
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
        exStringEquals(dsHenkouRireki1.getNewnaiyou(), "1000000001", "変更後内容");
        exStringEquals(dsHenkouRireki1.getGyoumuKousinKinou(), "dwpasswordhenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki1.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki2 = dsHenkouRirekiLst.get(1);
        exStringEquals(dsHenkouRireki2.getDskokno(), "1000000001", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki2.getHenkousikibetukey(), "200000000000000001", "変更識別キー");
        exNumericEquals(dsHenkouRireki2.getRenno(), 2, "連番");
        exStringEquals(dsHenkouRireki2.getTablenm(), "ＤＳ顧客契約テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki2.getTableid(), "MT_DsKokyakuKeiyaku", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki2.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki2.getHanbetukoumokunm(), "ＤＳ顧客契約情報　証券番号：17806000013", "判別項目名");
        exStringEquals(dsHenkouRireki2.getHenkoukoumokuid(), "syono", "変更項目ID");
        exStringEquals(dsHenkouRireki2.getHenkoukoumokunm(), "証券番号", "変更項目名");
        exStringEquals(dsHenkouRireki2.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki2.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki2.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki2.getNewnaiyou(), "証券番号：17806000013", "変更後内容");
        exStringEquals(dsHenkouRireki2.getGyoumuKousinKinou(), "dwpasswordhenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki2.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki3 = dsHenkouRirekiLst.get(2);
        exStringEquals(dsHenkouRireki3.getDskokno(), "1000000001", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki3.getHenkousikibetukey(), "200000000000000001", "変更識別キー");
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
        exStringEquals(dsHenkouRireki3.getNewnaiyou(), "1000000001", "変更後内容");
        exStringEquals(dsHenkouRireki3.getGyoumuKousinKinou(), "dwpasswordhenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki3.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki4 = dsHenkouRirekiLst.get(3);
        exStringEquals(dsHenkouRireki4.getDskokno(), "1000000001", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki4.getHenkousikibetukey(), "200000000000000001", "変更識別キー");
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
        exStringEquals(dsHenkouRireki4.getNewnaiyou(), "1000000001", "変更後内容");
        exStringEquals(dsHenkouRireki4.getGyoumuKousinKinou(), "dwpasswordhenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki4.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki5 = dsHenkouRirekiLst.get(4);
        exStringEquals(dsHenkouRireki5.getDskokno(), "1000000001", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki5.getHenkousikibetukey(), "200000000000000001", "変更識別キー");
        exNumericEquals(dsHenkouRireki5.getRenno(), 5, "連番");
        exStringEquals(dsHenkouRireki5.getTablenm(), "ＤＳメールアドレステーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki5.getTableid(), "MT_DsMailAddress", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki5.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki5.getHanbetukoumokunm(), "ＤＳメールアドレス情報　ＤＳメールアドレス連番：100000001", "判別項目名");
        exStringEquals(dsHenkouRireki5.getHenkoukoumokuid(), "dskokno", "変更項目ID");
        exStringEquals(dsHenkouRireki5.getHenkoukoumokunm(), "ＤＳ顧客番号", "変更項目名");
        exStringEquals(dsHenkouRireki5.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki5.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki5.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki5.getNewnaiyou(), "ＤＳ顧客番号：1000000001", "変更後内容");
        exStringEquals(dsHenkouRireki5.getGyoumuKousinKinou(), "dwpasswordhenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki5.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testEditDSTtdkRirekiTblWebService_A3() {

        DsTetudukiRirekiTableEditParam dsTetudukiRirekiTableEditParam = new DsTetudukiRirekiTableEditParamImpl();
        dsTetudukiRirekiTableEditParam.setDskokno("1000000002");
        dsTetudukiRirekiTableEditParam.setHenkousikibetukey("200000000000000002");
        dsTetudukiRirekiTableEditParam.setSyoriYmd(BizDate.valueOf("2016/04/13"));
        dsTetudukiRirekiTableEditParam.setDssyorikbn(C_DsSyoriKbn.LOGIN_SEIKOU);
        dsTetudukiRirekiTableEditParam.setHenkouRrkYouhi(C_YouhiKbn.YOU);
        AS_Kinou kinou = SWAKInjector.getInstance(AS_Kinou.class);
        kinou.setKinouId(C_DsKinouidKbn.PASSWORDHENKOU.getValue());


        editDSTtdkRirekiTbl.editDSTtdkRirekiTblWebService(dsTetudukiRirekiTableEditParam, kinou);

        MT_DsKokyakuKanri dsKokyakuKanri = directDomManager.getDsKokyakuKanri(dsTetudukiRirekiTableEditParam.getDskokno());

        List<MT_DsTtdkRireki> dsTtdkRirekiLst = dsKokyakuKanri.getDsTtdkRirekis();

        exNumericEquals(dsTtdkRirekiLst.size(), 1, "ＤＳ手続履歴情報件数");

        MT_DsTtdkRireki dsTtdkRireki = dsTtdkRirekiLst.get(0);
        exStringEquals(dsTtdkRireki.getDskokno(), "1000000002", "ＤＳ手続履歴テーブルエンティティ．ＤＳ顧客番号");
        exStringEquals(dsTtdkRireki.getHenkousikibetukey(), "200000000000000002", "ＤＳ手続履歴テーブルエンティティ．変更識別キー");
        exDateEquals(dsTtdkRireki.getSyoriYmd(), BizDate.valueOf("2016/04/13"), "ＤＳ手続履歴テーブルエンティティ．処理年月日");
        exClassificationEquals(dsTtdkRireki.getDssyorikbn(), C_DsSyoriKbn.LOGIN_SEIKOU, "ＤＳ手続履歴テーブルエンティティ．ＤＳ処理区分");
        exClassificationEquals(dsTtdkRireki.getHenkourrkumu(), C_UmuKbn.ARI, "ＤＳ手続履歴テーブルエンティティ．変更履歴有無");
        exStringEquals(dsTtdkRireki.getGyoumuKousinKinou(), "dwpasswordhenkou", "ＤＳ手続履歴テーブルエンティティ．業務用更新機能ＩＤ");
        exStringEquals(dsTtdkRireki.getGyoumuKousinsyaId(), "JUnit", "ＤＳ手続履歴テーブルエンティティ．業務用更新者ＩＤ");

        List<MT_DsHenkouRireki> dsHenkouRirekiLst = dsTtdkRireki.getDsHenkouRirekis();
        exNumericEquals(dsHenkouRirekiLst.size(), 39, "ＤＳ変更履歴情報件数");

        MT_DsHenkouRireki dsHenkouRireki1 = dsHenkouRirekiLst.get(0);
        exStringEquals(dsHenkouRireki1.getDskokno(), "1000000002", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki1.getHenkousikibetukey(), "200000000000000002", "変更識別キー");
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
        exStringEquals(dsHenkouRireki1.getGyoumuKousinKinou(), "dwpasswordhenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki1.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki2 = dsHenkouRirekiLst.get(1);
        exStringEquals(dsHenkouRireki2.getDskokno(), "1000000002", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki2.getHenkousikibetukey(), "200000000000000002", "変更識別キー");
        exNumericEquals(dsHenkouRireki2.getRenno(), 2, "連番");
        exStringEquals(dsHenkouRireki2.getTablenm(), "ＤＳ顧客管理テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki2.getTableid(), "MT_DsKokyakuKanri", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki2.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki2.getHanbetukoumokunm(), "ＤＳ顧客管理情報", "判別項目名");
        exStringEquals(dsHenkouRireki2.getHenkoukoumokuid(), "dskokyakusakuseiymd", "変更項目ID");
        exStringEquals(dsHenkouRireki2.getHenkoukoumokunm(), "ＤＳ顧客作成年月日", "変更項目名");
        exStringEquals(dsHenkouRireki2.getBfrnaiyouoriginal(), "20160401", "変更前内容原本");
        exStringEquals(dsHenkouRireki2.getBfrnaiyou(), "20160401", "変更前内容");
        exStringEquals(dsHenkouRireki2.getNewnaiyouoriginal(), "20160301", "変更後内容原本");
        exStringEquals(dsHenkouRireki2.getNewnaiyou(), "20160301", "変更後内容");
        exStringEquals(dsHenkouRireki2.getGyoumuKousinKinou(), "dwpasswordhenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki2.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki3 = dsHenkouRirekiLst.get(2);
        exStringEquals(dsHenkouRireki3.getDskokno(), "1000000002", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki3.getHenkousikibetukey(), "200000000000000002", "変更識別キー");
        exNumericEquals(dsHenkouRireki3.getRenno(), 3, "連番");
        exStringEquals(dsHenkouRireki3.getTablenm(), "ＤＳ顧客管理テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki3.getTableid(), "MT_DsKokyakuKanri", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki3.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki3.getHanbetukoumokunm(), "ＤＳ顧客管理情報", "判別項目名");
        exStringEquals(dsHenkouRireki3.getHenkoukoumokuid(), "dsteisiriyuukbn", "変更項目ID");
        exStringEquals(dsHenkouRireki3.getHenkoukoumokunm(), "ＤＳ停止理由区分", "変更項目名");
        exStringEquals(dsHenkouRireki3.getBfrnaiyouoriginal(), "0", "変更前内容原本");
        exStringEquals(dsHenkouRireki3.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki3.getNewnaiyouoriginal(), "2", "変更後内容原本");
        exStringEquals(dsHenkouRireki3.getNewnaiyou(), "お申し出", "変更後内容");
        exStringEquals(dsHenkouRireki3.getGyoumuKousinKinou(), "dwpasswordhenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki3.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki4 = dsHenkouRirekiLst.get(3);
        exStringEquals(dsHenkouRireki4.getDskokno(), "1000000002", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki4.getHenkousikibetukey(), "200000000000000002", "変更識別キー");
        exNumericEquals(dsHenkouRireki4.getRenno(), 4, "連番");
        exStringEquals(dsHenkouRireki4.getTablenm(), "ＤＳ顧客管理テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki4.getTableid(), "MT_DsKokyakuKanri", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki4.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki4.getHanbetukoumokunm(), "ＤＳ顧客管理情報", "判別項目名");
        exStringEquals(dsHenkouRireki4.getHenkoukoumokuid(), "dskokyakumukouymd", "変更項目ID");
        exStringEquals(dsHenkouRireki4.getHenkoukoumokunm(), "ＤＳ顧客無効年月日", "変更項目名");
        exStringEquals(dsHenkouRireki4.getBfrnaiyouoriginal(), "20170601", "変更前内容原本");
        exStringEquals(dsHenkouRireki4.getBfrnaiyou(), "20170601", "変更前内容");
        exStringEquals(dsHenkouRireki4.getNewnaiyouoriginal(), "20180601", "変更後内容原本");
        exStringEquals(dsHenkouRireki4.getNewnaiyou(), "20180601", "変更後内容");
        exStringEquals(dsHenkouRireki4.getGyoumuKousinKinou(), "dwpasswordhenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki4.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki5 = dsHenkouRirekiLst.get(4);
        exStringEquals(dsHenkouRireki5.getDskokno(), "1000000002", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki5.getHenkousikibetukey(), "200000000000000002", "変更識別キー");
        exNumericEquals(dsHenkouRireki5.getRenno(), 5, "連番");
        exStringEquals(dsHenkouRireki5.getTablenm(), "ＤＳ顧客管理テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki5.getTableid(), "MT_DsKokyakuKanri", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki5.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki5.getHanbetukoumokunm(), "ＤＳ顧客管理情報", "判別項目名");
        exStringEquals(dsHenkouRireki5.getHenkoukoumokuid(), "seisahuyouhyj", "変更項目ID");
        exStringEquals(dsHenkouRireki5.getHenkoukoumokunm(), "精査不要表示", "変更項目名");
        exStringEquals(dsHenkouRireki5.getBfrnaiyouoriginal(), "0", "変更前内容原本");
        exStringEquals(dsHenkouRireki5.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki5.getNewnaiyouoriginal(), "1", "変更後内容原本");
        exStringEquals(dsHenkouRireki5.getNewnaiyou(), "精査不要", "変更後内容");
        exStringEquals(dsHenkouRireki5.getGyoumuKousinKinou(), "dwpasswordhenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki5.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki6 = dsHenkouRirekiLst.get(5);
        exStringEquals(dsHenkouRireki6.getDskokno(), "1000000002", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki6.getHenkousikibetukey(), "200000000000000002", "変更識別キー");
        exNumericEquals(dsHenkouRireki6.getRenno(), 6, "連番");
        exStringEquals(dsHenkouRireki6.getTablenm(), "ＤＳ顧客管理テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki6.getTableid(), "MT_DsKokyakuKanri", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki6.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki6.getHanbetukoumokunm(), "ＤＳ顧客管理情報", "判別項目名");
        exStringEquals(dsHenkouRireki6.getHenkoukoumokuid(), "dskokyakunmkn", "変更項目ID");
        exStringEquals(dsHenkouRireki6.getHenkoukoumokunm(), "ＤＳ顧客名（カナ）", "変更項目名");
        exStringEquals(dsHenkouRireki6.getBfrnaiyouoriginal(), "アイウエオカキクケコアイウエオカキクケコアイウエオカキクケコ", "変更前内容原本");
        exStringEquals(dsHenkouRireki6.getBfrnaiyou(), "アイウエオカキクケコアイウエオカキクケコアイウエオカキクケコ", "変更前内容");
        exStringEquals(dsHenkouRireki6.getNewnaiyouoriginal(), "アイウエオカキクケコアイウエオカキクケコアイウエオカキアアア", "変更後内容原本");
        exStringEquals(dsHenkouRireki6.getNewnaiyou(), "アイウエオカキクケコアイウエオカキクケコアイウエオカキアアア", "変更後内容");
        exStringEquals(dsHenkouRireki6.getGyoumuKousinKinou(), "dwpasswordhenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki6.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki7 = dsHenkouRirekiLst.get(6);
        exStringEquals(dsHenkouRireki7.getDskokno(), "1000000002", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki7.getHenkousikibetukey(), "200000000000000002", "変更識別キー");
        exNumericEquals(dsHenkouRireki7.getRenno(), 7, "連番");
        exStringEquals(dsHenkouRireki7.getTablenm(), "ＤＳ顧客管理テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki7.getTableid(), "MT_DsKokyakuKanri", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki7.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki7.getHanbetukoumokunm(), "ＤＳ顧客管理情報", "判別項目名");
        exStringEquals(dsHenkouRireki7.getHenkoukoumokuid(), "dskokyakunmkj", "変更項目ID");
        exStringEquals(dsHenkouRireki7.getHenkoukoumokunm(), "ＤＳ顧客名（漢字）", "変更項目名");
        exStringEquals(dsHenkouRireki7.getBfrnaiyouoriginal(), "あいうえおかきくけこあいうえおかきくけこあいうえおかきくけこ", "変更前内容原本");
        exStringEquals(dsHenkouRireki7.getBfrnaiyou(), "あいうえおかきくけこあいうえおかきくけこあいうえおかきくけこ", "変更前内容");
        exStringEquals(dsHenkouRireki7.getNewnaiyouoriginal(), "あいうえおかきくけこあいうえおかきくけこあいうえおかきあああ", "変更後内容原本");
        exStringEquals(dsHenkouRireki7.getNewnaiyou(), "あいうえおかきくけこあいうえおかきくけこあいうえおかきあああ", "変更後内容");
        exStringEquals(dsHenkouRireki7.getGyoumuKousinKinou(), "dwpasswordhenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki7.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki8 = dsHenkouRirekiLst.get(7);
        exStringEquals(dsHenkouRireki8.getDskokno(), "1000000002", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki8.getHenkousikibetukey(), "200000000000000002", "変更識別キー");
        exNumericEquals(dsHenkouRireki8.getRenno(), 8, "連番");
        exStringEquals(dsHenkouRireki8.getTablenm(), "ＤＳ顧客管理テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki8.getTableid(), "MT_DsKokyakuKanri", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki8.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki8.getHanbetukoumokunm(), "ＤＳ顧客管理情報", "判別項目名");
        exStringEquals(dsHenkouRireki8.getHenkoukoumokuid(), "dskokyakuseiymd", "変更項目ID");
        exStringEquals(dsHenkouRireki8.getHenkoukoumokunm(), "ＤＳ顧客生年月日", "変更項目名");
        exStringEquals(dsHenkouRireki8.getBfrnaiyouoriginal(), "19720607", "変更前内容原本");
        exStringEquals(dsHenkouRireki8.getBfrnaiyou(), "19720607", "変更前内容");
        exStringEquals(dsHenkouRireki8.getNewnaiyouoriginal(), "19730806", "変更後内容原本");
        exStringEquals(dsHenkouRireki8.getNewnaiyou(), "19730806", "変更後内容");
        exStringEquals(dsHenkouRireki8.getGyoumuKousinKinou(), "dwpasswordhenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki8.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki9 = dsHenkouRirekiLst.get(8);
        exStringEquals(dsHenkouRireki9.getDskokno(), "1000000002", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki9.getHenkousikibetukey(), "200000000000000002", "変更識別キー");
        exNumericEquals(dsHenkouRireki9.getRenno(), 9, "連番");
        exStringEquals(dsHenkouRireki9.getTablenm(), "ＤＳ顧客管理テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki9.getTableid(), "MT_DsKokyakuKanri", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki9.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki9.getHanbetukoumokunm(), "ＤＳ顧客管理情報", "判別項目名");
        exStringEquals(dsHenkouRireki9.getHenkoukoumokuid(), "dskokyakuyno", "変更項目ID");
        exStringEquals(dsHenkouRireki9.getHenkoukoumokunm(), "ＤＳ顧客郵便番号", "変更項目名");
        exStringEquals(dsHenkouRireki9.getBfrnaiyouoriginal(), "1234567", "変更前内容原本");
        exStringEquals(dsHenkouRireki9.getBfrnaiyou(), "1234567", "変更前内容");
        exStringEquals(dsHenkouRireki9.getNewnaiyouoriginal(), "7654321", "変更後内容原本");
        exStringEquals(dsHenkouRireki9.getNewnaiyou(), "7654321", "変更後内容");
        exStringEquals(dsHenkouRireki9.getGyoumuKousinKinou(), "dwpasswordhenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki9.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki10 = dsHenkouRirekiLst.get(9);
        exStringEquals(dsHenkouRireki10.getDskokno(), "1000000002", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki10.getHenkousikibetukey(), "200000000000000002", "変更識別キー");
        exNumericEquals(dsHenkouRireki10.getRenno(), 10, "連番");
        exStringEquals(dsHenkouRireki10.getTablenm(), "ＤＳ顧客契約テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki10.getTableid(), "MT_DsKokyakuKeiyaku", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki10.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki10.getHanbetukoumokunm(), "ＤＳ顧客契約情報　証券番号：17806000024", "判別項目名");
        exStringEquals(dsHenkouRireki10.getHenkoukoumokuid(), "dskykkanyuuymd", "変更項目ID");
        exStringEquals(dsHenkouRireki10.getHenkoukoumokunm(), "ＤＳ契約加入年月日", "変更項目名");
        exStringEquals(dsHenkouRireki10.getBfrnaiyouoriginal(), "20160311", "変更前内容原本");
        exStringEquals(dsHenkouRireki10.getBfrnaiyou(), "20160311", "変更前内容");
        exStringEquals(dsHenkouRireki10.getNewnaiyouoriginal(), "20160315", "変更後内容原本");
        exStringEquals(dsHenkouRireki10.getNewnaiyou(), "20160315", "変更後内容");
        exStringEquals(dsHenkouRireki10.getGyoumuKousinKinou(), "dwpasswordhenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki10.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki11 = dsHenkouRirekiLst.get(10);
        exStringEquals(dsHenkouRireki11.getDskokno(), "1000000002", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki11.getHenkousikibetukey(), "200000000000000002", "変更識別キー");
        exNumericEquals(dsHenkouRireki11.getRenno(), 11, "連番");
        exStringEquals(dsHenkouRireki11.getTablenm(), "ＤＳ顧客契約テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki11.getTableid(), "MT_DsKokyakuKeiyaku", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki11.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki11.getHanbetukoumokunm(), "ＤＳ顧客契約情報　証券番号：17806000024", "判別項目名");
        exStringEquals(dsHenkouRireki11.getHenkoukoumokuid(), "dskykhenkouymd", "変更項目ID");
        exStringEquals(dsHenkouRireki11.getHenkoukoumokunm(), "ＤＳ契約変更年月日", "変更項目名");
        exStringEquals(dsHenkouRireki11.getBfrnaiyouoriginal(), "20160415", "変更前内容原本");
        exStringEquals(dsHenkouRireki11.getBfrnaiyou(), "20160415", "変更前内容");
        exStringEquals(dsHenkouRireki11.getNewnaiyouoriginal(), "20160420", "変更後内容原本");
        exStringEquals(dsHenkouRireki11.getNewnaiyou(), "20160420", "変更後内容");
        exStringEquals(dsHenkouRireki11.getGyoumuKousinKinou(), "dwpasswordhenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki11.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki12 = dsHenkouRirekiLst.get(11);
        exStringEquals(dsHenkouRireki12.getDskokno(), "1000000002", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki12.getHenkousikibetukey(), "200000000000000002", "変更識別キー");
        exNumericEquals(dsHenkouRireki12.getRenno(), 12, "連番");
        exStringEquals(dsHenkouRireki12.getTablenm(), "ＤＳ顧客契約テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki12.getTableid(), "MT_DsKokyakuKeiyaku", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki12.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki12.getHanbetukoumokunm(), "ＤＳ顧客契約情報　証券番号：17806000024", "判別項目名");
        exStringEquals(dsHenkouRireki12.getHenkoukoumokuid(), "dskykmukouhyj", "変更項目ID");
        exStringEquals(dsHenkouRireki12.getHenkoukoumokunm(), "ＤＳ契約無効表示", "変更項目名");
        exStringEquals(dsHenkouRireki12.getBfrnaiyouoriginal(), "1", "変更前内容原本");
        exStringEquals(dsHenkouRireki12.getBfrnaiyou(), "無効", "変更前内容");
        exStringEquals(dsHenkouRireki12.getNewnaiyouoriginal(), "0", "変更後内容原本");
        exStringEquals(dsHenkouRireki12.getNewnaiyou(), "", "変更後内容");
        exStringEquals(dsHenkouRireki12.getGyoumuKousinKinou(), "dwpasswordhenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki12.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki13 = dsHenkouRirekiLst.get(12);
        exStringEquals(dsHenkouRireki13.getDskokno(), "1000000002", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki13.getHenkousikibetukey(), "200000000000000002", "変更識別キー");
        exNumericEquals(dsHenkouRireki13.getRenno(), 13, "連番");
        exStringEquals(dsHenkouRireki13.getTablenm(), "ＤＳ顧客契約テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki13.getTableid(), "MT_DsKokyakuKeiyaku", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki13.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki13.getHanbetukoumokunm(), "ＤＳ顧客契約情報　証券番号：17806000024", "判別項目名");
        exStringEquals(dsHenkouRireki13.getHenkoukoumokuid(), "dskykmukouymd", "変更項目ID");
        exStringEquals(dsHenkouRireki13.getHenkoukoumokunm(), "ＤＳ契約無効年月日", "変更項目名");
        exStringEquals(dsHenkouRireki13.getBfrnaiyouoriginal(), "20160416", "変更前内容原本");
        exStringEquals(dsHenkouRireki13.getBfrnaiyou(), "20160416", "変更前内容");
        exStringEquals(dsHenkouRireki13.getNewnaiyouoriginal(), "20160521", "変更後内容原本");
        exStringEquals(dsHenkouRireki13.getNewnaiyou(), "20160521", "変更後内容");
        exStringEquals(dsHenkouRireki13.getGyoumuKousinKinou(), "dwpasswordhenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki13.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki14 = dsHenkouRirekiLst.get(13);
        exStringEquals(dsHenkouRireki14.getDskokno(), "1000000002", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki14.getHenkousikibetukey(), "200000000000000002", "変更識別キー");
        exNumericEquals(dsHenkouRireki14.getRenno(), 14, "連番");
        exStringEquals(dsHenkouRireki14.getTablenm(), "ＤＳ顧客契約テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki14.getTableid(), "MT_DsKokyakuKeiyaku", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki14.getHnksyuruikbn(), C_HnkSyuruiKbn.SAKUJYO, "変更種類区分");
        exStringEquals(dsHenkouRireki14.getHanbetukoumokunm(), "ＤＳ顧客契約情報　証券番号：17806000035", "判別項目名");
        exStringEquals(dsHenkouRireki14.getHenkoukoumokuid(), "syono", "変更項目ID");
        exStringEquals(dsHenkouRireki14.getHenkoukoumokunm(), "証券番号", "変更項目名");
        exStringEquals(dsHenkouRireki14.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki14.getBfrnaiyou(), "証券番号：17806000035", "変更前内容");
        exStringEquals(dsHenkouRireki14.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki14.getNewnaiyou(), "", "変更後内容");
        exStringEquals(dsHenkouRireki14.getGyoumuKousinKinou(), "dwpasswordhenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki14.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki15 = dsHenkouRirekiLst.get(14);
        exStringEquals(dsHenkouRireki15.getDskokno(), "1000000002", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki15.getHenkousikibetukey(), "200000000000000002", "変更識別キー");
        exNumericEquals(dsHenkouRireki15.getRenno(), 15, "連番");
        exStringEquals(dsHenkouRireki15.getTablenm(), "ＤＳ顧客契約テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki15.getTableid(), "MT_DsKokyakuKeiyaku", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki15.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
        exStringEquals(dsHenkouRireki15.getHanbetukoumokunm(), "ＤＳ顧客契約情報　証券番号：17806000046", "判別項目名");
        exStringEquals(dsHenkouRireki15.getHenkoukoumokuid(), "syono", "変更項目ID");
        exStringEquals(dsHenkouRireki15.getHenkoukoumokunm(), "証券番号", "変更項目名");
        exStringEquals(dsHenkouRireki15.getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRireki15.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki15.getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRireki15.getNewnaiyou(), "証券番号：17806000046", "変更後内容");
        exStringEquals(dsHenkouRireki15.getGyoumuKousinKinou(), "dwpasswordhenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki15.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki16 = dsHenkouRirekiLst.get(15);
        exStringEquals(dsHenkouRireki16.getDskokno(), "1000000002", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki16.getHenkousikibetukey(), "200000000000000002", "変更識別キー");
        exNumericEquals(dsHenkouRireki16.getRenno(), 16, "連番");
        exStringEquals(dsHenkouRireki16.getTablenm(), "ＤＳ本人確認コードテーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki16.getTableid(), "MT_DsHonninKakuninCd", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki16.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki16.getHanbetukoumokunm(), "ＤＳ本人確認コード情報", "判別項目名");
        exStringEquals(dsHenkouRireki16.getHenkoukoumokuid(), "dskrhnnkakcd", "変更項目ID");
        exStringEquals(dsHenkouRireki16.getHenkoukoumokunm(), "ＤＳ仮本人確認コード", "変更項目名");
        exStringEquals(dsHenkouRireki16.getBfrnaiyouoriginal(), "***", "変更前内容原本");
        exStringEquals(dsHenkouRireki16.getBfrnaiyou(), "***", "変更前内容");
        exStringEquals(dsHenkouRireki16.getNewnaiyouoriginal(), "***", "変更後内容原本");
        exStringEquals(dsHenkouRireki16.getNewnaiyou(), "***", "変更後内容");
        exStringEquals(dsHenkouRireki16.getGyoumuKousinKinou(), "dwpasswordhenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki16.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki17 = dsHenkouRirekiLst.get(16);
        exStringEquals(dsHenkouRireki17.getDskokno(), "1000000002", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki17.getHenkousikibetukey(), "200000000000000002", "変更識別キー");
        exNumericEquals(dsHenkouRireki17.getRenno(), 17, "連番");
        exStringEquals(dsHenkouRireki17.getTablenm(), "ＤＳ本人確認コードテーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki17.getTableid(), "MT_DsHonninKakuninCd", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki17.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki17.getHanbetukoumokunm(), "ＤＳ本人確認コード情報", "判別項目名");
        exStringEquals(dsHenkouRireki17.getHenkoukoumokuid(), "dskrhnnkakcdsetkbn", "変更項目ID");
        exStringEquals(dsHenkouRireki17.getHenkoukoumokunm(), "ＤＳ仮本人確認コード設定区分", "変更項目名");
        exStringEquals(dsHenkouRireki17.getBfrnaiyouoriginal(), "1", "変更前内容原本");
        exStringEquals(dsHenkouRireki17.getBfrnaiyou(), "ＤＳ新規登録時", "変更前内容");
        exStringEquals(dsHenkouRireki17.getNewnaiyouoriginal(), "2", "変更後内容原本");
        exStringEquals(dsHenkouRireki17.getNewnaiyou(), "仮パスワードの再発行時", "変更後内容");
        exStringEquals(dsHenkouRireki17.getGyoumuKousinKinou(), "dwpasswordhenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki17.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki18 = dsHenkouRirekiLst.get(17);
        exStringEquals(dsHenkouRireki18.getDskokno(), "1000000002", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki18.getHenkousikibetukey(), "200000000000000002", "変更識別キー");
        exNumericEquals(dsHenkouRireki18.getRenno(), 18, "連番");
        exStringEquals(dsHenkouRireki18.getTablenm(), "ＤＳ本人確認コードテーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki18.getTableid(), "MT_DsHonninKakuninCd", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki18.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki18.getHanbetukoumokunm(), "ＤＳ本人確認コード情報", "判別項目名");
        exStringEquals(dsHenkouRireki18.getHenkoukoumokuid(), "dskrhnnkakcdsetymd", "変更項目ID");
        exStringEquals(dsHenkouRireki18.getHenkoukoumokunm(), "ＤＳ仮本人確認コード設定年月日", "変更項目名");
        exStringEquals(dsHenkouRireki18.getBfrnaiyouoriginal(), "20160301", "変更前内容原本");
        exStringEquals(dsHenkouRireki18.getBfrnaiyou(), "20160301", "変更前内容");
        exStringEquals(dsHenkouRireki18.getNewnaiyouoriginal(), "20160316", "変更後内容原本");
        exStringEquals(dsHenkouRireki18.getNewnaiyou(), "20160316", "変更後内容");
        exStringEquals(dsHenkouRireki18.getGyoumuKousinKinou(), "dwpasswordhenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki18.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki19 = dsHenkouRirekiLst.get(18);
        exStringEquals(dsHenkouRireki19.getDskokno(), "1000000002", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki19.getHenkousikibetukey(), "200000000000000002", "変更識別キー");
        exNumericEquals(dsHenkouRireki19.getRenno(), 19, "連番");
        exStringEquals(dsHenkouRireki19.getTablenm(), "ＤＳ本人確認コードテーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki19.getTableid(), "MT_DsHonninKakuninCd", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki19.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki19.getHanbetukoumokunm(), "ＤＳ本人確認コード情報", "判別項目名");
        exStringEquals(dsHenkouRireki19.getHenkoukoumokuid(), "dskrhnnkakcdyuukouymd", "変更項目ID");
        exStringEquals(dsHenkouRireki19.getHenkoukoumokunm(), "ＤＳ仮本人確認コード有効年月日", "変更項目名");
        exStringEquals(dsHenkouRireki19.getBfrnaiyouoriginal(), "20160501", "変更前内容原本");
        exStringEquals(dsHenkouRireki19.getBfrnaiyou(), "20160501", "変更前内容");
        exStringEquals(dsHenkouRireki19.getNewnaiyouoriginal(), "20160517", "変更後内容原本");
        exStringEquals(dsHenkouRireki19.getNewnaiyou(), "20160517", "変更後内容");
        exStringEquals(dsHenkouRireki19.getGyoumuKousinKinou(), "dwpasswordhenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki19.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki20 = dsHenkouRirekiLst.get(19);
        exStringEquals(dsHenkouRireki20.getDskokno(), "1000000002", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki20.getHenkousikibetukey(), "200000000000000002", "変更識別キー");
        exNumericEquals(dsHenkouRireki20.getRenno(), 20, "連番");
        exStringEquals(dsHenkouRireki20.getTablenm(), "ＤＳ本人確認コードテーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki20.getTableid(), "MT_DsHonninKakuninCd", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki20.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki20.getHanbetukoumokunm(), "ＤＳ本人確認コード情報", "判別項目名");
        exStringEquals(dsHenkouRireki20.getHenkoukoumokuid(), "dshnnkakcd", "変更項目ID");
        exStringEquals(dsHenkouRireki20.getHenkoukoumokunm(), "ＤＳ本人確認コード", "変更項目名");
        exStringEquals(dsHenkouRireki20.getBfrnaiyouoriginal(), "***", "変更前内容原本");
        exStringEquals(dsHenkouRireki20.getBfrnaiyou(), "***", "変更前内容");
        exStringEquals(dsHenkouRireki20.getNewnaiyouoriginal(), "***", "変更後内容原本");
        exStringEquals(dsHenkouRireki20.getNewnaiyou(), "***", "変更後内容");
        exStringEquals(dsHenkouRireki20.getGyoumuKousinKinou(), "dwpasswordhenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki20.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki21 = dsHenkouRirekiLst.get(20);
        exStringEquals(dsHenkouRireki21.getDskokno(), "1000000002", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki21.getHenkousikibetukey(), "200000000000000002", "変更識別キー");
        exNumericEquals(dsHenkouRireki21.getRenno(), 21, "連番");
        exStringEquals(dsHenkouRireki21.getTablenm(), "ＤＳ本人確認コードテーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki21.getTableid(), "MT_DsHonninKakuninCd", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki21.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki21.getHanbetukoumokunm(), "ＤＳ本人確認コード情報", "判別項目名");
        exStringEquals(dsHenkouRireki21.getHenkoukoumokuid(), "dshnnkakcdsetymd", "変更項目ID");
        exStringEquals(dsHenkouRireki21.getHenkoukoumokunm(), "ＤＳ本人確認コード設定年月日", "変更項目名");
        exStringEquals(dsHenkouRireki21.getBfrnaiyouoriginal(), "20160419", "変更前内容原本");
        exStringEquals(dsHenkouRireki21.getBfrnaiyou(), "20160419", "変更前内容");
        exStringEquals(dsHenkouRireki21.getNewnaiyouoriginal(), "20160420", "変更後内容原本");
        exStringEquals(dsHenkouRireki21.getNewnaiyou(), "20160420", "変更後内容");
        exStringEquals(dsHenkouRireki21.getGyoumuKousinKinou(), "dwpasswordhenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki21.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki22 = dsHenkouRirekiLst.get(21);
        exStringEquals(dsHenkouRireki22.getDskokno(), "1000000002", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki22.getHenkousikibetukey(), "200000000000000002", "変更識別キー");
        exNumericEquals(dsHenkouRireki22.getRenno(), 22, "連番");
        exStringEquals(dsHenkouRireki22.getTablenm(), "ＤＳ本人確認コードテーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki22.getTableid(), "MT_DsHonninKakuninCd", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki22.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki22.getHanbetukoumokunm(), "ＤＳ本人確認コード情報", "判別項目名");
        exStringEquals(dsHenkouRireki22.getHenkoukoumokuid(), "zenkaidskrhnnkakcd", "変更項目ID");
        exStringEquals(dsHenkouRireki22.getHenkoukoumokunm(), "前回ＤＳ仮本人確認コード", "変更項目名");
        exStringEquals(dsHenkouRireki22.getBfrnaiyouoriginal(), "***", "変更前内容原本");
        exStringEquals(dsHenkouRireki22.getBfrnaiyou(), "***", "変更前内容");
        exStringEquals(dsHenkouRireki22.getNewnaiyouoriginal(), "***", "変更後内容原本");
        exStringEquals(dsHenkouRireki22.getNewnaiyou(), "***", "変更後内容");
        exStringEquals(dsHenkouRireki22.getGyoumuKousinKinou(), "dwpasswordhenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki22.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki23 = dsHenkouRirekiLst.get(22);
        exStringEquals(dsHenkouRireki23.getDskokno(), "1000000002", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki23.getHenkousikibetukey(), "200000000000000002", "変更識別キー");
        exNumericEquals(dsHenkouRireki23.getRenno(), 23, "連番");
        exStringEquals(dsHenkouRireki23.getTablenm(), "ＤＳログイン管理テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki23.getTableid(), "MT_DsLoginKanri", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki23.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki23.getHanbetukoumokunm(), "ＤＳログイン管理情報", "判別項目名");
        exStringEquals(dsHenkouRireki23.getHenkoukoumokuid(), "syokailoginymd", "変更項目ID");
        exStringEquals(dsHenkouRireki23.getHenkoukoumokunm(), "初回ログイン年月日", "変更項目名");
        exStringEquals(dsHenkouRireki23.getBfrnaiyouoriginal(), "20150418", "変更前内容原本");
        exStringEquals(dsHenkouRireki23.getBfrnaiyou(), "20150418", "変更前内容");
        exStringEquals(dsHenkouRireki23.getNewnaiyouoriginal(), "20150518", "変更後内容原本");
        exStringEquals(dsHenkouRireki23.getNewnaiyou(), "20150518", "変更後内容");
        exStringEquals(dsHenkouRireki23.getGyoumuKousinKinou(), "dwpasswordhenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki23.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki24 = dsHenkouRirekiLst.get(23);
        exStringEquals(dsHenkouRireki24.getDskokno(), "1000000002", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki24.getHenkousikibetukey(), "200000000000000002", "変更識別キー");
        exNumericEquals(dsHenkouRireki24.getRenno(), 24, "連番");
        exStringEquals(dsHenkouRireki24.getTablenm(), "ＤＳログイン管理テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki24.getTableid(), "MT_DsLoginKanri", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki24.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki24.getHanbetukoumokunm(), "ＤＳログイン管理情報", "判別項目名");
        exStringEquals(dsHenkouRireki24.getHenkoukoumokuid(), "syokailogintime", "変更項目ID");
        exStringEquals(dsHenkouRireki24.getHenkoukoumokunm(), "初回ログイン時刻", "変更項目名");
        exStringEquals(dsHenkouRireki24.getBfrnaiyouoriginal(), "082514", "変更前内容原本");
        exStringEquals(dsHenkouRireki24.getBfrnaiyou(), "082514", "変更前内容");
        exStringEquals(dsHenkouRireki24.getNewnaiyouoriginal(), "093420", "変更後内容原本");
        exStringEquals(dsHenkouRireki24.getNewnaiyou(), "093420", "変更後内容");
        exStringEquals(dsHenkouRireki24.getGyoumuKousinKinou(), "dwpasswordhenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki24.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki25 = dsHenkouRirekiLst.get(24);
        exStringEquals(dsHenkouRireki25.getDskokno(), "1000000002", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki25.getHenkousikibetukey(), "200000000000000002", "変更識別キー");
        exNumericEquals(dsHenkouRireki25.getRenno(), 25, "連番");
        exStringEquals(dsHenkouRireki25.getTablenm(), "ＤＳログイン管理テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki25.getTableid(), "MT_DsLoginKanri", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki25.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki25.getHanbetukoumokunm(), "ＤＳログイン管理情報", "判別項目名");
        exStringEquals(dsHenkouRireki25.getHenkoukoumokuid(), "syokailoginbaitaikbn", "変更項目ID");
        exStringEquals(dsHenkouRireki25.getHenkoukoumokunm(), "初回ログイン媒体区分", "変更項目名");
        exStringEquals(dsHenkouRireki25.getBfrnaiyouoriginal(), "0", "変更前内容原本");
        exStringEquals(dsHenkouRireki25.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki25.getNewnaiyouoriginal(), "1", "変更後内容原本");
        exStringEquals(dsHenkouRireki25.getNewnaiyou(), "ＰＣ", "変更後内容");
        exStringEquals(dsHenkouRireki25.getGyoumuKousinKinou(), "dwpasswordhenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki25.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki26 = dsHenkouRirekiLst.get(25);
        exStringEquals(dsHenkouRireki26.getDskokno(), "1000000002", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki26.getHenkousikibetukey(), "200000000000000002", "変更識別キー");
        exNumericEquals(dsHenkouRireki26.getRenno(), 26, "連番");
        exStringEquals(dsHenkouRireki26.getTablenm(), "ＤＳログイン管理テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki26.getTableid(), "MT_DsLoginKanri", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki26.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki26.getHanbetukoumokunm(), "ＤＳログイン管理情報", "判別項目名");
        exStringEquals(dsHenkouRireki26.getHenkoukoumokuid(), "saisinloginymd", "変更項目ID");
        exStringEquals(dsHenkouRireki26.getHenkoukoumokunm(), "最新ログイン年月日", "変更項目名");
        exStringEquals(dsHenkouRireki26.getBfrnaiyouoriginal(), "20160415", "変更前内容原本");
        exStringEquals(dsHenkouRireki26.getBfrnaiyou(), "20160415", "変更前内容");
        exStringEquals(dsHenkouRireki26.getNewnaiyouoriginal(), "20160427", "変更後内容原本");
        exStringEquals(dsHenkouRireki26.getNewnaiyou(), "20160427", "変更後内容");
        exStringEquals(dsHenkouRireki26.getGyoumuKousinKinou(), "dwpasswordhenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki26.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki27 = dsHenkouRirekiLst.get(26);
        exStringEquals(dsHenkouRireki27.getDskokno(), "1000000002", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki27.getHenkousikibetukey(), "200000000000000002", "変更識別キー");
        exNumericEquals(dsHenkouRireki27.getRenno(), 27, "連番");
        exStringEquals(dsHenkouRireki27.getTablenm(), "ＤＳログイン管理テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki27.getTableid(), "MT_DsLoginKanri", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki27.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki27.getHanbetukoumokunm(), "ＤＳログイン管理情報", "判別項目名");
        exStringEquals(dsHenkouRireki27.getHenkoukoumokuid(), "saisinlogintime", "変更項目ID");
        exStringEquals(dsHenkouRireki27.getHenkoukoumokunm(), "最新ログイン時刻", "変更項目名");
        exStringEquals(dsHenkouRireki27.getBfrnaiyouoriginal(), "124517", "変更前内容原本");
        exStringEquals(dsHenkouRireki27.getBfrnaiyou(), "124517", "変更前内容");
        exStringEquals(dsHenkouRireki27.getNewnaiyouoriginal(), "142836", "変更後内容原本");
        exStringEquals(dsHenkouRireki27.getNewnaiyou(), "142836", "変更後内容");
        exStringEquals(dsHenkouRireki27.getGyoumuKousinKinou(), "dwpasswordhenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki27.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki28 = dsHenkouRirekiLst.get(27);
        exStringEquals(dsHenkouRireki28.getDskokno(), "1000000002", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki28.getHenkousikibetukey(), "200000000000000002", "変更識別キー");
        exNumericEquals(dsHenkouRireki28.getRenno(), 28, "連番");
        exStringEquals(dsHenkouRireki28.getTablenm(), "ＤＳログイン管理テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki28.getTableid(), "MT_DsLoginKanri", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki28.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki28.getHanbetukoumokunm(), "ＤＳログイン管理情報", "判別項目名");
        exStringEquals(dsHenkouRireki28.getHenkoukoumokuid(), "saisinloginbaitaikbn", "変更項目ID");
        exStringEquals(dsHenkouRireki28.getHenkoukoumokunm(), "最新ログイン媒体区分", "変更項目名");
        exStringEquals(dsHenkouRireki28.getBfrnaiyouoriginal(), "0", "変更前内容原本");
        exStringEquals(dsHenkouRireki28.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki28.getNewnaiyouoriginal(), "1", "変更後内容原本");
        exStringEquals(dsHenkouRireki28.getNewnaiyou(), "ＰＣ", "変更後内容");
        exStringEquals(dsHenkouRireki28.getGyoumuKousinKinou(), "dwpasswordhenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki28.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki29 = dsHenkouRirekiLst.get(28);
        exStringEquals(dsHenkouRireki29.getDskokno(), "1000000002", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki29.getHenkousikibetukey(), "200000000000000002", "変更識別キー");
        exNumericEquals(dsHenkouRireki29.getRenno(), 29, "連番");
        exStringEquals(dsHenkouRireki29.getTablenm(), "ＤＳログイン管理テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki29.getTableid(), "MT_DsLoginKanri", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki29.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki29.getHanbetukoumokunm(), "ＤＳログイン管理情報", "判別項目名");
        exStringEquals(dsHenkouRireki29.getHenkoukoumokuid(), "dshnnkakcderrorkaisuu", "変更項目ID");
        exStringEquals(dsHenkouRireki29.getHenkoukoumokunm(), "ＤＳ本人確認コードエラー回数", "変更項目名");
        exStringEquals(dsHenkouRireki29.getBfrnaiyouoriginal(), "1", "変更前内容原本");
        exStringEquals(dsHenkouRireki29.getBfrnaiyou(), "1", "変更前内容");
        exStringEquals(dsHenkouRireki29.getNewnaiyouoriginal(), "2", "変更後内容原本");
        exStringEquals(dsHenkouRireki29.getNewnaiyou(), "2", "変更後内容");
        exStringEquals(dsHenkouRireki29.getGyoumuKousinKinou(), "dwpasswordhenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki29.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki30 = dsHenkouRirekiLst.get(29);
        exStringEquals(dsHenkouRireki30.getDskokno(), "1000000002", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki30.getHenkousikibetukey(), "200000000000000002", "変更識別キー");
        exNumericEquals(dsHenkouRireki30.getRenno(), 30, "連番");
        exStringEquals(dsHenkouRireki30.getTablenm(), "ＤＳログイン管理テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki30.getTableid(), "MT_DsLoginKanri", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki30.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki30.getHanbetukoumokunm(), "ＤＳログイン管理情報", "判別項目名");
        exStringEquals(dsHenkouRireki30.getHenkoukoumokuid(), "dskokyakunmerrorkaisuu", "変更項目ID");
        exStringEquals(dsHenkouRireki30.getHenkoukoumokunm(), "ＤＳ顧客名エラー回数", "変更項目名");
        exStringEquals(dsHenkouRireki30.getBfrnaiyouoriginal(), "3", "変更前内容原本");
        exStringEquals(dsHenkouRireki30.getBfrnaiyou(), "3", "変更前内容");
        exStringEquals(dsHenkouRireki30.getNewnaiyouoriginal(), "4", "変更後内容原本");
        exStringEquals(dsHenkouRireki30.getNewnaiyou(), "4", "変更後内容");
        exStringEquals(dsHenkouRireki30.getGyoumuKousinKinou(), "dwpasswordhenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki30.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki31 = dsHenkouRirekiLst.get(30);
        exStringEquals(dsHenkouRireki31.getDskokno(), "1000000002", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki31.getHenkousikibetukey(), "200000000000000002", "変更識別キー");
        exNumericEquals(dsHenkouRireki31.getRenno(), 31, "連番");
        exStringEquals(dsHenkouRireki31.getTablenm(), "ＤＳログイン管理テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki31.getTableid(), "MT_DsLoginKanri", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki31.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki31.getHanbetukoumokunm(), "ＤＳログイン管理情報", "判別項目名");
        exStringEquals(dsHenkouRireki31.getHenkoukoumokuid(), "dskokyakuseiymderrorkaisuu", "変更項目ID");
        exStringEquals(dsHenkouRireki31.getHenkoukoumokunm(), "ＤＳ顧客生年月日エラー回数", "変更項目名");
        exStringEquals(dsHenkouRireki31.getBfrnaiyouoriginal(), "5", "変更前内容原本");
        exStringEquals(dsHenkouRireki31.getBfrnaiyou(), "5", "変更前内容");
        exStringEquals(dsHenkouRireki31.getNewnaiyouoriginal(), "6", "変更後内容原本");
        exStringEquals(dsHenkouRireki31.getNewnaiyou(), "6", "変更後内容");
        exStringEquals(dsHenkouRireki31.getGyoumuKousinKinou(), "dwpasswordhenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki31.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki32 = dsHenkouRirekiLst.get(31);
        exStringEquals(dsHenkouRireki32.getDskokno(), "1000000002", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki32.getHenkousikibetukey(), "200000000000000002", "変更識別キー");
        exNumericEquals(dsHenkouRireki32.getRenno(), 32, "連番");
        exStringEquals(dsHenkouRireki32.getTablenm(), "ＤＳログイン管理テーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki32.getTableid(), "MT_DsLoginKanri", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki32.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki32.getHanbetukoumokunm(), "ＤＳログイン管理情報", "判別項目名");
        exStringEquals(dsHenkouRireki32.getHenkoukoumokuid(), "dskokyakutelnoerrorkaisuu", "変更項目ID");
        exStringEquals(dsHenkouRireki32.getHenkoukoumokunm(), "ＤＳ顧客電話番号エラー回数", "変更項目名");
        exStringEquals(dsHenkouRireki32.getBfrnaiyouoriginal(), "7", "変更前内容原本");
        exStringEquals(dsHenkouRireki32.getBfrnaiyou(), "7", "変更前内容");
        exStringEquals(dsHenkouRireki32.getNewnaiyouoriginal(), "8", "変更後内容原本");
        exStringEquals(dsHenkouRireki32.getNewnaiyou(), "8", "変更後内容");
        exStringEquals(dsHenkouRireki32.getGyoumuKousinKinou(), "dwpasswordhenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki32.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki33 = dsHenkouRirekiLst.get(32);
        exStringEquals(dsHenkouRireki33.getDskokno(), "1000000002", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki33.getHenkousikibetukey(), "200000000000000002", "変更識別キー");
        exNumericEquals(dsHenkouRireki33.getRenno(), 33, "連番");
        exStringEquals(dsHenkouRireki33.getTablenm(), "ＤＳメールアドレステーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki33.getTableid(), "MT_DsMailAddress", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki33.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki33.getHanbetukoumokunm(), "ＤＳメールアドレス情報　ＤＳメールアドレス連番：100000002", "判別項目名");
        exStringEquals(dsHenkouRireki33.getHenkoukoumokuid(), "dsmailtourokujyoutaikbn", "変更項目ID");
        exStringEquals(dsHenkouRireki33.getHenkoukoumokunm(), "ＤＳメール登録状態区分", "変更項目名");
        exStringEquals(dsHenkouRireki33.getBfrnaiyouoriginal(), "2", "変更前内容原本");
        exStringEquals(dsHenkouRireki33.getBfrnaiyou(), "削除", "変更前内容");
        exStringEquals(dsHenkouRireki33.getNewnaiyouoriginal(), "0", "変更後内容原本");
        exStringEquals(dsHenkouRireki33.getNewnaiyou(), "未登録", "変更後内容");
        exStringEquals(dsHenkouRireki33.getGyoumuKousinKinou(), "dwpasswordhenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki33.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki34 = dsHenkouRirekiLst.get(33);
        exStringEquals(dsHenkouRireki34.getDskokno(), "1000000002", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki34.getHenkousikibetukey(), "200000000000000002", "変更識別キー");
        exNumericEquals(dsHenkouRireki34.getRenno(), 34, "連番");
        exStringEquals(dsHenkouRireki34.getTablenm(), "ＤＳメールアドレステーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki34.getTableid(), "MT_DsMailAddress", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki34.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki34.getHanbetukoumokunm(), "ＤＳメールアドレス情報　ＤＳメールアドレス連番：100000002", "判別項目名");
        exStringEquals(dsHenkouRireki34.getHenkoukoumokuid(), "dsmailaddress", "変更項目ID");
        exStringEquals(dsHenkouRireki34.getHenkoukoumokunm(), "ＤＳメールアドレス", "変更項目名");
        exStringEquals(dsHenkouRireki34.getBfrnaiyouoriginal(), "def@co.jp", "変更前内容原本");
        exStringEquals(dsHenkouRireki34.getBfrnaiyou(), "def@co.jp", "変更前内容");
        exStringEquals(dsHenkouRireki34.getNewnaiyouoriginal(), "abc@co.jp", "変更後内容原本");
        exStringEquals(dsHenkouRireki34.getNewnaiyou(), "abc@co.jp", "変更後内容");
        exStringEquals(dsHenkouRireki34.getGyoumuKousinKinou(), "dwpasswordhenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki34.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki35 = dsHenkouRirekiLst.get(34);
        exStringEquals(dsHenkouRireki35.getDskokno(), "1000000002", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki35.getHenkousikibetukey(), "200000000000000002", "変更識別キー");
        exNumericEquals(dsHenkouRireki35.getRenno(), 35, "連番");
        exStringEquals(dsHenkouRireki35.getTablenm(), "ＤＳメールアドレステーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki35.getTableid(), "MT_DsMailAddress", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki35.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki35.getHanbetukoumokunm(), "ＤＳメールアドレス情報　ＤＳメールアドレス連番：100000002", "判別項目名");
        exStringEquals(dsHenkouRireki35.getHenkoukoumokuid(), "dsmailsousinjyoutaikbn", "変更項目ID");
        exStringEquals(dsHenkouRireki35.getHenkoukoumokunm(), "ＤＳメール送信状態区分", "変更項目名");
        exStringEquals(dsHenkouRireki35.getBfrnaiyouoriginal(), "2", "変更前内容原本");
        exStringEquals(dsHenkouRireki35.getBfrnaiyou(), "停止", "変更前内容");
        exStringEquals(dsHenkouRireki35.getNewnaiyouoriginal(), "0", "変更後内容原本");
        exStringEquals(dsHenkouRireki35.getNewnaiyou(), "", "変更後内容");
        exStringEquals(dsHenkouRireki35.getGyoumuKousinKinou(), "dwpasswordhenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki35.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki36 = dsHenkouRirekiLst.get(35);
        exStringEquals(dsHenkouRireki36.getDskokno(), "1000000002", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki36.getHenkousikibetukey(), "200000000000000002", "変更識別キー");
        exNumericEquals(dsHenkouRireki36.getRenno(), 36, "連番");
        exStringEquals(dsHenkouRireki36.getTablenm(), "ＤＳメールアドレステーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki36.getTableid(), "MT_DsMailAddress", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki36.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki36.getHanbetukoumokunm(), "ＤＳメールアドレス情報　ＤＳメールアドレス連番：100000002", "判別項目名");
        exStringEquals(dsHenkouRireki36.getHenkoukoumokuid(), "dsmailsousintisrykbn", "変更項目ID");
        exStringEquals(dsHenkouRireki36.getHenkoukoumokunm(), "ＤＳメール送信停止理由区分", "変更項目名");
        exStringEquals(dsHenkouRireki36.getBfrnaiyouoriginal(), "0", "変更前内容原本");
        exStringEquals(dsHenkouRireki36.getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRireki36.getNewnaiyouoriginal(), "3", "変更後内容原本");
        exStringEquals(dsHenkouRireki36.getNewnaiyou(), "顧客消滅", "変更後内容");
        exStringEquals(dsHenkouRireki36.getGyoumuKousinKinou(), "dwpasswordhenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki36.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki37 = dsHenkouRirekiLst.get(36);
        exStringEquals(dsHenkouRireki37.getDskokno(), "1000000002", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki37.getHenkousikibetukey(), "200000000000000002", "変更識別キー");
        exNumericEquals(dsHenkouRireki37.getRenno(), 37, "連番");
        exStringEquals(dsHenkouRireki37.getTablenm(), "ＤＳメールアドレステーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki37.getTableid(), "MT_DsMailAddress", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki37.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki37.getHanbetukoumokunm(), "ＤＳメールアドレス情報　ＤＳメールアドレス連番：100000002", "判別項目名");
        exStringEquals(dsHenkouRireki37.getHenkoukoumokuid(), "dstourokuymdtime", "変更項目ID");
        exStringEquals(dsHenkouRireki37.getHenkoukoumokunm(), "ＤＳ登録日時", "変更項目名");
        exStringEquals(dsHenkouRireki37.getBfrnaiyouoriginal(), "20161013", "変更前内容原本");
        exStringEquals(dsHenkouRireki37.getBfrnaiyou(), "20161013", "変更前内容");
        exStringEquals(dsHenkouRireki37.getNewnaiyouoriginal(), "20161012", "変更後内容原本");
        exStringEquals(dsHenkouRireki37.getNewnaiyou(), "20161012", "変更後内容");
        exStringEquals(dsHenkouRireki37.getGyoumuKousinKinou(), "dwpasswordhenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki37.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki38 = dsHenkouRirekiLst.get(37);
        exStringEquals(dsHenkouRireki38.getDskokno(), "1000000002", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRireki38.getHenkousikibetukey(), "200000000000000002", "変更識別キー");
        exNumericEquals(dsHenkouRireki38.getRenno(), 38, "連番");
        exStringEquals(dsHenkouRireki38.getTablenm(), "ＤＳメールアドレステーブル", "テーブル名称");
        exStringEquals(dsHenkouRireki38.getTableid(), "MT_DsMailAddress", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRireki38.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRireki38.getHanbetukoumokunm(), "ＤＳメールアドレス情報　ＤＳメールアドレス連番：100000002", "判別項目名");
        exStringEquals(dsHenkouRireki38.getHenkoukoumokuid(), "dskousinymdtime", "変更項目ID");
        exStringEquals(dsHenkouRireki38.getHenkoukoumokunm(), "ＤＳ更新日時", "変更項目名");
        exStringEquals(dsHenkouRireki38.getBfrnaiyouoriginal(), "20161013", "変更前内容原本");
        exStringEquals(dsHenkouRireki38.getBfrnaiyou(), "20161013", "変更前内容");
        exStringEquals(dsHenkouRireki38.getNewnaiyouoriginal(), "20161012", "変更後内容原本");
        exStringEquals(dsHenkouRireki38.getNewnaiyou(), "20161012", "変更後内容");
        exStringEquals(dsHenkouRireki38.getGyoumuKousinKinou(), "dwpasswordhenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRireki38.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

}
