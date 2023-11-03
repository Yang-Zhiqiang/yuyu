package yuyu.common.sinkeiyaku.moschk;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.classification.C_DakuhiktbunruiKbn;
import yuyu.def.classification.C_JiketteiKbn;
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_Ketriyuucd;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SntkinfosakuseiyhKbn;
import yuyu.def.classification.C_SyoubyoujyoutaiKbn;
import yuyu.def.classification.C_TkjysydksyhyKbn;
import yuyu.def.classification.C_TorikesisyousairiyuuCd;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HT_DakuhiKettei;
import yuyu.def.db.entity.HT_JigyouIkkatu;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.def.sinkeiyaku.sorter.SortHT_DakuhiKettei;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 決定処理のメソッド {@link Kettei#exec(MosnaiCheckParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class KetteiTest_exec {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    private final static String fileName = "UT_SP_単体テスト仕様書_決定処理";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData(){
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(KetteiTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        MockObjectManager.initialize();
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllJigyouIkkatu());
    }

    @Test
    @Transactional
    @TestOrder(1010)
    public void testExec_A1() {
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        Kettei kettei = SWAKInjector.getInstance(Kettei.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("881000004");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160218"));
        mosnaiCheckParam.setKosID("TestKosId");
        mosnaiCheckParam.setKosTime("20160218164901001");

        kettei.exec(mosnaiCheckParam);

        syoriCTL = sinkeiyakuDomManager.getSyoriCTL("881000004");

        exStringEquals(syoriCTL.getMosno(), "881000004", "申込番号");
        exClassificationEquals(syoriCTL.getKetteikbn(), C_KetteiKbn.KETTEI_SUMI, "決定状態区分");

        List<HT_DakuhiKettei> dakuhiKetteiLst = syoriCTL.getDakuhiKetteis();

        exNumericEquals(dakuhiKetteiLst.size(), 1, "諾否決定テーブルエンティティリストのサイズ");

        HT_DakuhiKettei dakuhiKettei = dakuhiKetteiLst.get(0);

        exStringEquals(dakuhiKettei.getMosno(), "881000004", "申込番号");
        exNumericEquals(dakuhiKettei.getDakuhiktrenno(), 1, "諾否決定連番");
        exDateEquals(dakuhiKettei.getKetymd(), BizDate.valueOf("20160218"), "決定日");
        exClassificationEquals(dakuhiKettei.getDakuhiktbunruikbn(), C_DakuhiktbunruiKbn.DAKUHIKETTEI, "諾否決定分類区分");
        exClassificationEquals(dakuhiKettei.getKetkekkacd(), C_Ketkekkacd.MUJYOUKEN, "決定結果コード");
        exClassificationEquals(dakuhiKettei.getKetriyuucd1(), C_Ketriyuucd.BLNK, "決定理由コード１");
        exClassificationEquals(dakuhiKettei.getKetriyuucd2(), C_Ketriyuucd.BLNK, "決定理由コード２");
        exClassificationEquals(dakuhiKettei.getKetriyuucd3(), C_Ketriyuucd.BLNK, "決定理由コード３");
        exClassificationEquals(dakuhiKettei.getKetriyuucd4(), C_Ketriyuucd.BLNK, "決定理由コード４");
        exStringEquals(dakuhiKettei.getSyoubyoucd1(), "", "傷病コード１");
        exClassificationEquals(dakuhiKettei.getSyoubyoujyoutaikbn1(), C_SyoubyoujyoutaiKbn.BLNK, "傷病状態区分１");
        exDateYMEquals(dakuhiKettei.getKantiym1(), null, "完治年月１");
        exStringEquals(dakuhiKettei.getSyoubyoucd2(), "", "傷病コード２");
        exClassificationEquals(dakuhiKettei.getSyoubyoujyoutaikbn2(), C_SyoubyoujyoutaiKbn.BLNK, "傷病状態区分２");
        exDateYMEquals(dakuhiKettei.getKantiym2(), null, "完治年月２");
        exStringEquals(dakuhiKettei.getKetsyacd(), "", "決定者コード");
        exStringEquals(dakuhiKettei.getPalketsyacd(), "99", "ＰＡＬ決定者コード");
        exNumericEquals(dakuhiKettei.getTkjysydkno(), 0, "特条承諾番号");
        exDateEquals(dakuhiKettei.getTkjysydkymd(), null, "特条条件付承諾日");
        exClassificationEquals(dakuhiKettei.getTkjysydksyhykbn(), C_TkjysydksyhyKbn.BLNK, "特条承諾書不要区分");
        exClassificationEquals(dakuhiKettei.getSntkinfosakuseiyhkbn(), C_SntkinfosakuseiyhKbn.SAKUSEIHUYOU, "選択情報作成要否区分");
        exClassificationEquals(dakuhiKettei.getTorikesisyousairiyuucd(), C_TorikesisyousairiyuuCd.BLNK, "取消詳細理由コード");
        exStringEquals(dakuhiKettei.getGyoumuKousinsyaId(), "TestKosId", "業務用更新者ＩＤ");
        exStringEquals(dakuhiKettei.getGyoumuKousinTime(), "20160218164901001", "業務用更新時間");

        HT_JigyouIkkatu jigyouIkkatu = sinkeiyakuDomManager.getJigyouIkkatu("881000004");
        assertNull(jigyouIkkatu);
    }

    @Test
    @Transactional
    @TestOrder(1020)
    public void testExec_A2() {
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        Kettei kettei = SWAKInjector.getInstance(Kettei.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("881000012");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160218"));
        mosnaiCheckParam.setKosID("TestKosId");
        mosnaiCheckParam.setKosTime("20160218164901001");

        kettei.exec(mosnaiCheckParam);

        syoriCTL = sinkeiyakuDomManager.getSyoriCTL("881000012");

        exStringEquals(syoriCTL.getMosno(), "881000012", "申込番号");
        exClassificationEquals(syoriCTL.getKetteikbn(), C_KetteiKbn.KETTEI_SUMI, "決定状態区分");

        List<HT_DakuhiKettei> dakuhiKetteiLst = syoriCTL.getDakuhiKetteis();

        exNumericEquals(dakuhiKetteiLst.size(), 4, "諾否決定テーブルエンティティリストのサイズ");

        dakuhiKetteiLst = new SortHT_DakuhiKettei().OrderHT_DakuhiKetteiByPkDesc(dakuhiKetteiLst);
        HT_DakuhiKettei dakuhiKettei = dakuhiKetteiLst.get(0);

        exStringEquals(dakuhiKettei.getMosno(), "881000012", "申込番号");
        exNumericEquals(dakuhiKettei.getDakuhiktrenno(), 4, "諾否決定連番");
        exDateEquals(dakuhiKettei.getKetymd(), BizDate.valueOf("20160218"), "決定日");
        exClassificationEquals(dakuhiKettei.getDakuhiktbunruikbn(), C_DakuhiktbunruiKbn.DAKUHIKETTEI, "諾否決定分類区分");
        exClassificationEquals(dakuhiKettei.getKetkekkacd(), C_Ketkekkacd.MUJYOUKEN, "決定結果コード");
        exClassificationEquals(dakuhiKettei.getKetriyuucd1(), C_Ketriyuucd.HHKN_SYOKUGYOU, "決定理由コード１");
        exClassificationEquals(dakuhiKettei.getKetriyuucd2(), C_Ketriyuucd.SSEIGEN, "決定理由コード２");
        exClassificationEquals(dakuhiKettei.getKetriyuucd3(), C_Ketriyuucd.KYK_DOUTOKUHUAN, "決定理由コード３");
        exClassificationEquals(dakuhiKettei.getKetriyuucd4(), C_Ketriyuucd.KYK_SYOKUGYOU, "決定理由コード４");
        exStringEquals(dakuhiKettei.getSyoubyoucd1(), "", "傷病コード１");
        exClassificationEquals(dakuhiKettei.getSyoubyoujyoutaikbn1(), C_SyoubyoujyoutaiKbn.BLNK, "傷病状態区分１");
        exDateYMEquals(dakuhiKettei.getKantiym1(), null, "完治年月１");
        exStringEquals(dakuhiKettei.getSyoubyoucd2(), "", "傷病コード２");
        exClassificationEquals(dakuhiKettei.getSyoubyoujyoutaikbn2(), C_SyoubyoujyoutaiKbn.BLNK, "傷病状態区分２");
        exDateYMEquals(dakuhiKettei.getKantiym2(), null, "完治年月２");
        exStringEquals(dakuhiKettei.getKetsyacd(), "KnkKtSya01", "決定者コード");
        exStringEquals(dakuhiKettei.getPalketsyacd(), "31", "ＰＡＬ決定者コード");
        exNumericEquals(dakuhiKettei.getTkjysydkno(), 0, "特条承諾番号");
        exDateEquals(dakuhiKettei.getTkjysydkymd(), null, "特条条件付承諾日");
        exClassificationEquals(dakuhiKettei.getTkjysydksyhykbn(), C_TkjysydksyhyKbn.BLNK, "特条承諾書不要区分");
        exClassificationEquals(dakuhiKettei.getSntkinfosakuseiyhkbn(), C_SntkinfosakuseiyhKbn.SAKUSEIHUYOU, "選択情報作成要否区分");
        exClassificationEquals(dakuhiKettei.getTorikesisyousairiyuucd(), C_TorikesisyousairiyuuCd.SIKIN, "取消詳細理由コード");
        exStringEquals(dakuhiKettei.getGyoumuKousinsyaId(), "TestKosId", "業務用更新者ＩＤ");
        exStringEquals(dakuhiKettei.getGyoumuKousinTime(), "20160218164901001", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(1030)
    public void testExec_A3() {
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        Kettei kettei = SWAKInjector.getInstance(Kettei.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("881000020");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160218"));
        mosnaiCheckParam.setKosID("TestKosId");
        mosnaiCheckParam.setKosTime("20160218164901001");

        kettei.exec(mosnaiCheckParam);

        syoriCTL = sinkeiyakuDomManager.getSyoriCTL("881000020");

        exStringEquals(syoriCTL.getMosno(), "881000020", "申込番号");
        exClassificationEquals(syoriCTL.getKetteikbn(), C_KetteiKbn.KETTEI_SUMI, "決定状態区分");

        List<HT_DakuhiKettei> dakuhiKetteiLst = syoriCTL.getDakuhiKetteis();

        exNumericEquals(dakuhiKetteiLst.size(), 1, "諾否決定テーブルエンティティリストのサイズ");

        HT_DakuhiKettei dakuhiKettei = dakuhiKetteiLst.get(0);

        exStringEquals(dakuhiKettei.getMosno(), "881000020", "申込番号");
        exNumericEquals(dakuhiKettei.getDakuhiktrenno(), 1, "諾否決定連番");
        exDateEquals(dakuhiKettei.getKetymd(), BizDate.valueOf("20160218"), "決定日");
        exClassificationEquals(dakuhiKettei.getDakuhiktbunruikbn(), C_DakuhiktbunruiKbn.DAKUHIKETTEI, "諾否決定分類区分");
        exClassificationEquals(dakuhiKettei.getKetkekkacd(), C_Ketkekkacd.BLNK, "決定結果コード");
        exClassificationEquals(dakuhiKettei.getKetriyuucd1(), C_Ketriyuucd.BLNK, "決定理由コード１");
        exClassificationEquals(dakuhiKettei.getKetriyuucd2(), C_Ketriyuucd.BLNK, "決定理由コード２");
        exClassificationEquals(dakuhiKettei.getKetriyuucd3(), C_Ketriyuucd.BLNK, "決定理由コード３");
        exClassificationEquals(dakuhiKettei.getKetriyuucd4(), C_Ketriyuucd.BLNK, "決定理由コード４");
        exStringEquals(dakuhiKettei.getSyoubyoucd1(), "", "傷病コード１");
        exClassificationEquals(dakuhiKettei.getSyoubyoujyoutaikbn1(), C_SyoubyoujyoutaiKbn.BLNK, "傷病状態区分１");
        exDateYMEquals(dakuhiKettei.getKantiym1(), null, "完治年月１");
        exStringEquals(dakuhiKettei.getSyoubyoucd2(), "", "傷病コード２");
        exClassificationEquals(dakuhiKettei.getSyoubyoujyoutaikbn2(), C_SyoubyoujyoutaiKbn.BLNK, "傷病状態区分２");
        exDateYMEquals(dakuhiKettei.getKantiym2(), null, "完治年月２");
        exStringEquals(dakuhiKettei.getKetsyacd(), "", "決定者コード");
        exStringEquals(dakuhiKettei.getPalketsyacd(), "", "ＰＡＬ決定者コード");
        exNumericEquals(dakuhiKettei.getTkjysydkno(), 0, "特条承諾番号");
        exDateEquals(dakuhiKettei.getTkjysydkymd(), null, "特条条件付承諾日");
        exClassificationEquals(dakuhiKettei.getTkjysydksyhykbn(), C_TkjysydksyhyKbn.BLNK, "特条承諾書不要区分");
        exClassificationEquals(dakuhiKettei.getSntkinfosakuseiyhkbn(), C_SntkinfosakuseiyhKbn.SAKUSEIYOU, "選択情報作成要否区分");
        exClassificationEquals(dakuhiKettei.getTorikesisyousairiyuucd(), C_TorikesisyousairiyuuCd.BLNK, "取消詳細理由コード");
        exStringEquals(dakuhiKettei.getGyoumuKousinsyaId(), "TestKosId", "業務用更新者ＩＤ");
        exStringEquals(dakuhiKettei.getGyoumuKousinTime(), "20160218164901001", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(1040)
    public void testExec_A4() {
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        Kettei kettei = SWAKInjector.getInstance(Kettei.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("881000038");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160218"));
        mosnaiCheckParam.setKosID("TestKosId");
        mosnaiCheckParam.setKosTime("20160218164901001");

        kettei.exec(mosnaiCheckParam);

        syoriCTL = sinkeiyakuDomManager.getSyoriCTL("881000038");

        exStringEquals(syoriCTL.getMosno(), "881000038", "申込番号");
        exClassificationEquals(syoriCTL.getKetteikbn(), C_KetteiKbn.KETTEI_SUMI, "決定状態区分");

        List<HT_DakuhiKettei> dakuhiKetteiLst = syoriCTL.getDakuhiKetteis();

        exNumericEquals(dakuhiKetteiLst.size(), 1, "諾否決定テーブルエンティティリストのサイズ");

        HT_DakuhiKettei dakuhiKettei = dakuhiKetteiLst.get(0);

        exStringEquals(dakuhiKettei.getMosno(), "881000038", "申込番号");
        exNumericEquals(dakuhiKettei.getDakuhiktrenno(), 1, "諾否決定連番");
        exDateEquals(dakuhiKettei.getKetymd(), BizDate.valueOf("20160218"), "決定日");
        exClassificationEquals(dakuhiKettei.getDakuhiktbunruikbn(), C_DakuhiktbunruiKbn.DAKUHIKETTEI, "諾否決定分類区分");
        exClassificationEquals(dakuhiKettei.getKetkekkacd(), C_Ketkekkacd.MUJYOUKEN, "決定結果コード");
        exClassificationEquals(dakuhiKettei.getKetriyuucd1(), C_Ketriyuucd.HHKN_TAIKAKU, "決定理由コード１");
        exClassificationEquals(dakuhiKettei.getKetriyuucd2(), C_Ketriyuucd.HHKN_GENSYOU, "決定理由コード２");
        exClassificationEquals(dakuhiKettei.getKetriyuucd3(), C_Ketriyuucd.HHKN_KIOUSYOU, "決定理由コード３");
        exClassificationEquals(dakuhiKettei.getKetriyuucd4(), C_Ketriyuucd.HHKN_NINSIN, "決定理由コード４");
        exStringEquals(dakuhiKettei.getSyoubyoucd1(), "SYBY01", "傷病コード１");
        exClassificationEquals(dakuhiKettei.getSyoubyoujyoutaikbn1(), C_SyoubyoujyoutaiKbn.GENSYOUTYUU, "傷病状態区分１");
        exDateYMEquals(dakuhiKettei.getKantiym1(), BizDateYM.valueOf("201508"), "完治年月１");
        exStringEquals(dakuhiKettei.getSyoubyoucd2(), "SYBY09", "傷病コード２");
        exClassificationEquals(dakuhiKettei.getSyoubyoujyoutaikbn2(), C_SyoubyoujyoutaiKbn.SUUNENMAE, "傷病状態区分２");
        exDateYMEquals(dakuhiKettei.getKantiym2(), BizDateYM.valueOf("201512"), "完治年月２");
        exStringEquals(dakuhiKettei.getKetsyacd(), "ImuKtSya01", "決定者コード");
        exStringEquals(dakuhiKettei.getPalketsyacd(), "37", "ＰＡＬ決定者コード");
        exNumericEquals(dakuhiKettei.getTkjysydkno(), 0, "特条承諾番号");
        exDateEquals(dakuhiKettei.getTkjysydkymd(), null, "特条条件付承諾日");
        exClassificationEquals(dakuhiKettei.getTkjysydksyhykbn(), C_TkjysydksyhyKbn.BLNK, "特条承諾書不要区分");
        exClassificationEquals(dakuhiKettei.getSntkinfosakuseiyhkbn(), C_SntkinfosakuseiyhKbn.SAKUSEIYOU, "選択情報作成要否区分");
        exClassificationEquals(dakuhiKettei.getTorikesisyousairiyuucd(), C_TorikesisyousairiyuuCd.BLNK, "取消詳細理由コード");
        exStringEquals(dakuhiKettei.getGyoumuKousinsyaId(), "TestKosId", "業務用更新者ＩＤ");
        exStringEquals(dakuhiKettei.getGyoumuKousinTime(), "20160218164901001", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(1050)
    public void testExec_A5() {
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        Kettei kettei = SWAKInjector.getInstance(Kettei.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("881000046");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160218"));
        mosnaiCheckParam.setKosID("TestKosId");
        mosnaiCheckParam.setKosTime("20160218164901001");

        kettei.exec(mosnaiCheckParam);

        syoriCTL = sinkeiyakuDomManager.getSyoriCTL("881000046");

        exStringEquals(syoriCTL.getMosno(), "881000046", "申込番号");
        exClassificationEquals(syoriCTL.getKetteikbn(), C_KetteiKbn.KETTEI_SUMI, "決定状態区分");

        List<HT_DakuhiKettei> dakuhiKetteiLst = syoriCTL.getDakuhiKetteis();

        exNumericEquals(dakuhiKetteiLst.size(), 1, "諾否決定テーブルエンティティリストのサイズ");

        HT_DakuhiKettei dakuhiKettei = dakuhiKetteiLst.get(0);

        exStringEquals(dakuhiKettei.getMosno(), "881000046", "申込番号");
        exNumericEquals(dakuhiKettei.getDakuhiktrenno(), 1, "諾否決定連番");
        exDateEquals(dakuhiKettei.getKetymd(), BizDate.valueOf("20160218"), "決定日");
        exClassificationEquals(dakuhiKettei.getDakuhiktbunruikbn(), C_DakuhiktbunruiKbn.DAKUHIKETTEI, "諾否決定分類区分");
        exClassificationEquals(dakuhiKettei.getKetkekkacd(), C_Ketkekkacd.GENKAITAI_SYOUDAKU, "決定結果コード");
        exClassificationEquals(dakuhiKettei.getKetriyuucd1(), C_Ketriyuucd.HHKN_TAIKAKU, "決定理由コード１");
        exClassificationEquals(dakuhiKettei.getKetriyuucd2(), C_Ketriyuucd.HHKN_GENSYOU, "決定理由コード２");
        exClassificationEquals(dakuhiKettei.getKetriyuucd3(), C_Ketriyuucd.HHKN_KIOUSYOU, "決定理由コード３");
        exClassificationEquals(dakuhiKettei.getKetriyuucd4(), C_Ketriyuucd.HHKN_NINSIN, "決定理由コード４");
        exStringEquals(dakuhiKettei.getSyoubyoucd1(), "SYBY01", "傷病コード１");
        exClassificationEquals(dakuhiKettei.getSyoubyoujyoutaikbn1(), C_SyoubyoujyoutaiKbn.GENSYOUTYUU, "傷病状態区分１");
        exDateYMEquals(dakuhiKettei.getKantiym1(), BizDateYM.valueOf("201508"), "完治年月１");
        exStringEquals(dakuhiKettei.getSyoubyoucd2(), "SYBY09", "傷病コード２");
        exClassificationEquals(dakuhiKettei.getSyoubyoujyoutaikbn2(), C_SyoubyoujyoutaiKbn.SUUNENMAE, "傷病状態区分２");
        exDateYMEquals(dakuhiKettei.getKantiym2(), BizDateYM.valueOf("201512"), "完治年月２");
        exStringEquals(dakuhiKettei.getKetsyacd(), "ImuKtSya01", "決定者コード");
        exStringEquals(dakuhiKettei.getPalketsyacd(), "37", "ＰＡＬ決定者コード");
        exNumericEquals(dakuhiKettei.getTkjysydkno(), 0, "特条承諾番号");
        exDateEquals(dakuhiKettei.getTkjysydkymd(), null, "特条条件付承諾日");
        exClassificationEquals(dakuhiKettei.getTkjysydksyhykbn(), C_TkjysydksyhyKbn.BLNK, "特条承諾書不要区分");
        exClassificationEquals(dakuhiKettei.getSntkinfosakuseiyhkbn(), C_SntkinfosakuseiyhKbn.SAKUSEIYOU, "選択情報作成要否区分");
        exClassificationEquals(dakuhiKettei.getTorikesisyousairiyuucd(), C_TorikesisyousairiyuuCd.BLNK, "取消詳細理由コード");
        exStringEquals(dakuhiKettei.getGyoumuKousinsyaId(), "TestKosId", "業務用更新者ＩＤ");
        exStringEquals(dakuhiKettei.getGyoumuKousinTime(), "20160218164901001", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(1060)
    public void testExec_A6() {
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        Kettei kettei = SWAKInjector.getInstance(Kettei.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("881000053");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160218"));
        mosnaiCheckParam.setKosID("TestKosId");
        mosnaiCheckParam.setKosTime("20160218164901001");

        kettei.exec(mosnaiCheckParam);

        syoriCTL = sinkeiyakuDomManager.getSyoriCTL("881000053");

        exStringEquals(syoriCTL.getMosno(), "881000053", "申込番号");
        exClassificationEquals(syoriCTL.getKetteikbn(), C_KetteiKbn.KETTEI_SUMI, "決定状態区分");

        List<HT_DakuhiKettei> dakuhiKetteiLst = syoriCTL.getDakuhiKetteis();

        exNumericEquals(dakuhiKetteiLst.size(), 1, "諾否決定テーブルエンティティリストのサイズ");

        HT_DakuhiKettei dakuhiKettei = dakuhiKetteiLst.get(0);

        exStringEquals(dakuhiKettei.getMosno(), "881000053", "申込番号");
        exNumericEquals(dakuhiKettei.getDakuhiktrenno(), 1, "諾否決定連番");
        exDateEquals(dakuhiKettei.getKetymd(), BizDate.valueOf("20160218"), "決定日");
        exClassificationEquals(dakuhiKettei.getDakuhiktbunruikbn(), C_DakuhiktbunruiKbn.DAKUHIKETTEI, "諾否決定分類区分");
        exClassificationEquals(dakuhiKettei.getKetkekkacd(), C_Ketkekkacd.BLNK, "決定結果コード");
        exClassificationEquals(dakuhiKettei.getKetriyuucd1(), C_Ketriyuucd.BLNK, "決定理由コード１");
        exClassificationEquals(dakuhiKettei.getKetriyuucd2(), C_Ketriyuucd.BLNK, "決定理由コード２");
        exClassificationEquals(dakuhiKettei.getKetriyuucd3(), C_Ketriyuucd.BLNK, "決定理由コード３");
        exClassificationEquals(dakuhiKettei.getKetriyuucd4(), C_Ketriyuucd.BLNK, "決定理由コード４");
        exStringEquals(dakuhiKettei.getSyoubyoucd1(), "", "傷病コード１");
        exClassificationEquals(dakuhiKettei.getSyoubyoujyoutaikbn1(), C_SyoubyoujyoutaiKbn.BLNK, "傷病状態区分１");
        exDateYMEquals(dakuhiKettei.getKantiym1(), null, "完治年月１");
        exStringEquals(dakuhiKettei.getSyoubyoucd2(), "", "傷病コード２");
        exClassificationEquals(dakuhiKettei.getSyoubyoujyoutaikbn2(), C_SyoubyoujyoutaiKbn.BLNK, "傷病状態区分２");
        exDateYMEquals(dakuhiKettei.getKantiym2(), null, "完治年月２");
        exStringEquals(dakuhiKettei.getKetsyacd(), "", "決定者コード");
        exStringEquals(dakuhiKettei.getPalketsyacd(), "", "ＰＡＬ決定者コード");
        exNumericEquals(dakuhiKettei.getTkjysydkno(), 0, "特条承諾番号");
        exDateEquals(dakuhiKettei.getTkjysydkymd(), null, "特条条件付承諾日");
        exClassificationEquals(dakuhiKettei.getTkjysydksyhykbn(), C_TkjysydksyhyKbn.BLNK, "特条承諾書不要区分");
        exClassificationEquals(dakuhiKettei.getSntkinfosakuseiyhkbn(), C_SntkinfosakuseiyhKbn.SAKUSEIYOU, "選択情報作成要否区分");
        exClassificationEquals(dakuhiKettei.getTorikesisyousairiyuucd(), C_TorikesisyousairiyuuCd.BLNK, "取消詳細理由コード");
        exStringEquals(dakuhiKettei.getGyoumuKousinsyaId(), "TestKosId", "業務用更新者ＩＤ");
        exStringEquals(dakuhiKettei.getGyoumuKousinTime(), "20160218164901001", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(1070)
    public void testExec_A7() {
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        Kettei kettei = SWAKInjector.getInstance(Kettei.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("881000061");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160218"));
        mosnaiCheckParam.setKosID("TestKosId");
        mosnaiCheckParam.setKosTime("20160218164901001");

        kettei.exec(mosnaiCheckParam);

        syoriCTL = sinkeiyakuDomManager.getSyoriCTL("881000061");

        exStringEquals(syoriCTL.getMosno(), "881000061", "申込番号");
        exClassificationEquals(syoriCTL.getKetteikbn(), C_KetteiKbn.KETTEI_SUMI, "決定状態区分");

        List<HT_DakuhiKettei> dakuhiKetteiLst = syoriCTL.getDakuhiKetteis();

        exNumericEquals(dakuhiKetteiLst.size(), 1, "諾否決定テーブルエンティティリストのサイズ");

        HT_DakuhiKettei dakuhiKettei = dakuhiKetteiLst.get(0);

        exStringEquals(dakuhiKettei.getMosno(), "881000061", "申込番号");
        exNumericEquals(dakuhiKettei.getDakuhiktrenno(), 1, "諾否決定連番");
        exDateEquals(dakuhiKettei.getKetymd(), BizDate.valueOf("20160218"), "決定日");
        exClassificationEquals(dakuhiKettei.getDakuhiktbunruikbn(), C_DakuhiktbunruiKbn.DAKUHIKETTEI, "諾否決定分類区分");
        exClassificationEquals(dakuhiKettei.getKetkekkacd(), C_Ketkekkacd.MUJYOUKEN, "決定結果コード");
        exClassificationEquals(dakuhiKettei.getKetriyuucd1(), C_Ketriyuucd.HHKN_TAIKAKU, "決定理由コード１");
        exClassificationEquals(dakuhiKettei.getKetriyuucd2(), C_Ketriyuucd.HHKN_GENSYOU, "決定理由コード２");
        exClassificationEquals(dakuhiKettei.getKetriyuucd3(), C_Ketriyuucd.HHKN_KIOUSYOU, "決定理由コード３");
        exClassificationEquals(dakuhiKettei.getKetriyuucd4(), C_Ketriyuucd.HHKN_NINSIN, "決定理由コード４");
        exStringEquals(dakuhiKettei.getSyoubyoucd1(), "SYBY01", "傷病コード１");
        exClassificationEquals(dakuhiKettei.getSyoubyoujyoutaikbn1(), C_SyoubyoujyoutaiKbn.GENSYOUTYUU, "傷病状態区分１");
        exDateYMEquals(dakuhiKettei.getKantiym1(), BizDateYM.valueOf("201508"), "完治年月１");
        exStringEquals(dakuhiKettei.getSyoubyoucd2(), "SYBY09", "傷病コード２");
        exClassificationEquals(dakuhiKettei.getSyoubyoujyoutaikbn2(), C_SyoubyoujyoutaiKbn.SUUNENMAE, "傷病状態区分２");
        exDateYMEquals(dakuhiKettei.getKantiym2(), BizDateYM.valueOf("201512"), "完治年月２");
        exStringEquals(dakuhiKettei.getKetsyacd(), "ImuKtSya01", "決定者コード");
        exStringEquals(dakuhiKettei.getPalketsyacd(), "37", "ＰＡＬ決定者コード");
        exNumericEquals(dakuhiKettei.getTkjysydkno(), 0, "特条承諾番号");
        exDateEquals(dakuhiKettei.getTkjysydkymd(), null, "特条条件付承諾日");
        exClassificationEquals(dakuhiKettei.getTkjysydksyhykbn(), C_TkjysydksyhyKbn.BLNK, "特条承諾書不要区分");
        exClassificationEquals(dakuhiKettei.getSntkinfosakuseiyhkbn(), C_SntkinfosakuseiyhKbn.SAKUSEIYOU, "選択情報作成要否区分");
        exClassificationEquals(dakuhiKettei.getTorikesisyousairiyuucd(), C_TorikesisyousairiyuuCd.BLNK, "取消詳細理由コード");
        exStringEquals(dakuhiKettei.getGyoumuKousinsyaId(), "TestKosId", "業務用更新者ＩＤ");
        exStringEquals(dakuhiKettei.getGyoumuKousinTime(), "20160218164901001", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(1080)
    public void testExec_A8() {
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        Kettei kettei = SWAKInjector.getInstance(Kettei.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("881000079");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160218"));
        mosnaiCheckParam.setKosID("TestKosId");
        mosnaiCheckParam.setKosTime("20160218164901001");

        kettei.exec(mosnaiCheckParam);

        syoriCTL = sinkeiyakuDomManager.getSyoriCTL("881000079");

        exStringEquals(syoriCTL.getMosno(), "881000079", "申込番号");
        exClassificationEquals(syoriCTL.getKetteikbn(), C_KetteiKbn.KETTEI_SUMI, "決定状態区分");

        List<HT_DakuhiKettei> dakuhiKetteiLst = syoriCTL.getDakuhiKetteis();

        exNumericEquals(dakuhiKetteiLst.size(), 1, "諾否決定テーブルエンティティリストのサイズ");

        HT_DakuhiKettei dakuhiKettei = dakuhiKetteiLst.get(0);

        exStringEquals(dakuhiKettei.getMosno(), "881000079", "申込番号");
        exNumericEquals(dakuhiKettei.getDakuhiktrenno(), 1, "諾否決定連番");
        exDateEquals(dakuhiKettei.getKetymd(), BizDate.valueOf("20160218"), "決定日");
        exClassificationEquals(dakuhiKettei.getDakuhiktbunruikbn(), C_DakuhiktbunruiKbn.DAKUHIKETTEI, "諾否決定分類区分");
        exClassificationEquals(dakuhiKettei.getKetkekkacd(), C_Ketkekkacd.GENKAITAI_SYOUDAKU, "決定結果コード");
        exClassificationEquals(dakuhiKettei.getKetriyuucd1(), C_Ketriyuucd.HHKN_TAIKAKU, "決定理由コード１");
        exClassificationEquals(dakuhiKettei.getKetriyuucd2(), C_Ketriyuucd.HHKN_GENSYOU, "決定理由コード２");
        exClassificationEquals(dakuhiKettei.getKetriyuucd3(), C_Ketriyuucd.HHKN_KIOUSYOU, "決定理由コード３");
        exClassificationEquals(dakuhiKettei.getKetriyuucd4(), C_Ketriyuucd.HHKN_NINSIN, "決定理由コード４");
        exStringEquals(dakuhiKettei.getSyoubyoucd1(), "SYBY01", "傷病コード１");
        exClassificationEquals(dakuhiKettei.getSyoubyoujyoutaikbn1(), C_SyoubyoujyoutaiKbn.GENSYOUTYUU, "傷病状態区分１");
        exDateYMEquals(dakuhiKettei.getKantiym1(), BizDateYM.valueOf("201508"), "完治年月１");
        exStringEquals(dakuhiKettei.getSyoubyoucd2(), "SYBY09", "傷病コード２");
        exClassificationEquals(dakuhiKettei.getSyoubyoujyoutaikbn2(), C_SyoubyoujyoutaiKbn.SUUNENMAE, "傷病状態区分２");
        exDateYMEquals(dakuhiKettei.getKantiym2(), BizDateYM.valueOf("201512"), "完治年月２");
        exStringEquals(dakuhiKettei.getKetsyacd(), "KTS456789012345", "決定者コード");
        exStringEquals(dakuhiKettei.getPalketsyacd(), "37", "ＰＡＬ決定者コード");
        exNumericEquals(dakuhiKettei.getTkjysydkno(), 0, "特条承諾番号");
        exDateEquals(dakuhiKettei.getTkjysydkymd(), null, "特条条件付承諾日");
        exClassificationEquals(dakuhiKettei.getTkjysydksyhykbn(), C_TkjysydksyhyKbn.BLNK, "特条承諾書不要区分");
        exClassificationEquals(dakuhiKettei.getSntkinfosakuseiyhkbn(), C_SntkinfosakuseiyhKbn.SAKUSEIYOU, "選択情報作成要否区分");
        exClassificationEquals(dakuhiKettei.getTorikesisyousairiyuucd(), C_TorikesisyousairiyuuCd.BLNK, "取消詳細理由コード");
        exStringEquals(dakuhiKettei.getGyoumuKousinsyaId(), "TestKosId", "業務用更新者ＩＤ");
        exStringEquals(dakuhiKettei.getGyoumuKousinTime(), "20160218164901001", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(1090)
    public void testExec_A9() {
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        Kettei kettei = SWAKInjector.getInstance(Kettei.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("881000087");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160218"));
        mosnaiCheckParam.setKosID("TestKosId");
        mosnaiCheckParam.setKosTime("20160218164901001");

        kettei.exec(mosnaiCheckParam);

        syoriCTL = sinkeiyakuDomManager.getSyoriCTL("881000087");

        exStringEquals(syoriCTL.getMosno(), "881000087", "申込番号");
        exClassificationEquals(syoriCTL.getKetteikbn(), C_KetteiKbn.KETTEI_SUMI, "決定状態区分");

        List<HT_DakuhiKettei> dakuhiKetteiLst = syoriCTL.getDakuhiKetteis();

        exNumericEquals(dakuhiKetteiLst.size(), 1, "諾否決定テーブルエンティティリストのサイズ");

        HT_DakuhiKettei dakuhiKettei = dakuhiKetteiLst.get(0);

        exStringEquals(dakuhiKettei.getMosno(), "881000087", "申込番号");
        exNumericEquals(dakuhiKettei.getDakuhiktrenno(), 1, "諾否決定連番");
        exDateEquals(dakuhiKettei.getKetymd(), BizDate.valueOf("20160218"), "決定日");
        exClassificationEquals(dakuhiKettei.getDakuhiktbunruikbn(), C_DakuhiktbunruiKbn.DAKUHIKETTEI, "諾否決定分類区分");
        exClassificationEquals(dakuhiKettei.getKetkekkacd(), C_Ketkekkacd.BLNK, "決定結果コード");
        exClassificationEquals(dakuhiKettei.getKetriyuucd1(), C_Ketriyuucd.BLNK, "決定理由コード１");
        exClassificationEquals(dakuhiKettei.getKetriyuucd2(), C_Ketriyuucd.BLNK, "決定理由コード２");
        exClassificationEquals(dakuhiKettei.getKetriyuucd3(), C_Ketriyuucd.BLNK, "決定理由コード３");
        exClassificationEquals(dakuhiKettei.getKetriyuucd4(), C_Ketriyuucd.BLNK, "決定理由コード４");
        exStringEquals(dakuhiKettei.getSyoubyoucd1(), "", "傷病コード１");
        exClassificationEquals(dakuhiKettei.getSyoubyoujyoutaikbn1(), C_SyoubyoujyoutaiKbn.BLNK, "傷病状態区分１");
        exDateYMEquals(dakuhiKettei.getKantiym1(), null, "完治年月１");
        exStringEquals(dakuhiKettei.getSyoubyoucd2(), "", "傷病コード２");
        exClassificationEquals(dakuhiKettei.getSyoubyoujyoutaikbn2(), C_SyoubyoujyoutaiKbn.BLNK, "傷病状態区分２");
        exDateYMEquals(dakuhiKettei.getKantiym2(), null, "完治年月２");
        exStringEquals(dakuhiKettei.getKetsyacd(), "", "決定者コード");
        exStringEquals(dakuhiKettei.getPalketsyacd(), "", "ＰＡＬ決定者コード");
        exNumericEquals(dakuhiKettei.getTkjysydkno(), 0, "特条承諾番号");
        exDateEquals(dakuhiKettei.getTkjysydkymd(), null, "特条条件付承諾日");
        exClassificationEquals(dakuhiKettei.getTkjysydksyhykbn(), C_TkjysydksyhyKbn.BLNK, "特条承諾書不要区分");
        exClassificationEquals(dakuhiKettei.getSntkinfosakuseiyhkbn(), C_SntkinfosakuseiyhKbn.SAKUSEIYOU, "選択情報作成要否区分");
        exClassificationEquals(dakuhiKettei.getTorikesisyousairiyuucd(), C_TorikesisyousairiyuuCd.BLNK, "取消詳細理由コード");
        exStringEquals(dakuhiKettei.getGyoumuKousinsyaId(), "TestKosId", "業務用更新者ＩＤ");
        exStringEquals(dakuhiKettei.getGyoumuKousinTime(), "20160218164901001", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(1100)
    public void testExec_A10() {
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        Kettei kettei = SWAKInjector.getInstance(Kettei.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("881000095");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160218"));
        mosnaiCheckParam.setKosID("TestKosId");
        mosnaiCheckParam.setKosTime("20160218164901001");

        kettei.exec(mosnaiCheckParam);

        syoriCTL = sinkeiyakuDomManager.getSyoriCTL("881000095");

        exStringEquals(syoriCTL.getMosno(), "881000095", "申込番号");
        exClassificationEquals(syoriCTL.getKetteikbn(), C_KetteiKbn.KETTEI_SUMI, "決定状態区分");

        List<HT_DakuhiKettei> dakuhiKetteiLst = syoriCTL.getDakuhiKetteis();

        exNumericEquals(dakuhiKetteiLst.size(), 1, "諾否決定テーブルエンティティリストのサイズ");

        HT_DakuhiKettei dakuhiKettei = dakuhiKetteiLst.get(0);

        exStringEquals(dakuhiKettei.getMosno(), "881000095", "申込番号");
        exNumericEquals(dakuhiKettei.getDakuhiktrenno(), 1, "諾否決定連番");
        exDateEquals(dakuhiKettei.getKetymd(), BizDate.valueOf("20160218"), "決定日");
        exClassificationEquals(dakuhiKettei.getDakuhiktbunruikbn(), C_DakuhiktbunruiKbn.DAKUHIKETTEI, "諾否決定分類区分");
        exClassificationEquals(dakuhiKettei.getKetkekkacd(), C_Ketkekkacd.BLNK, "決定結果コード");
        exClassificationEquals(dakuhiKettei.getKetriyuucd1(), C_Ketriyuucd.BLNK, "決定理由コード１");
        exClassificationEquals(dakuhiKettei.getKetriyuucd2(), C_Ketriyuucd.BLNK, "決定理由コード２");
        exClassificationEquals(dakuhiKettei.getKetriyuucd3(), C_Ketriyuucd.BLNK, "決定理由コード３");
        exClassificationEquals(dakuhiKettei.getKetriyuucd4(), C_Ketriyuucd.BLNK, "決定理由コード４");
        exStringEquals(dakuhiKettei.getSyoubyoucd1(), "", "傷病コード１");
        exClassificationEquals(dakuhiKettei.getSyoubyoujyoutaikbn1(), C_SyoubyoujyoutaiKbn.BLNK, "傷病状態区分１");
        exDateYMEquals(dakuhiKettei.getKantiym1(), null, "完治年月１");
        exStringEquals(dakuhiKettei.getSyoubyoucd2(), "", "傷病コード２");
        exClassificationEquals(dakuhiKettei.getSyoubyoujyoutaikbn2(), C_SyoubyoujyoutaiKbn.BLNK, "傷病状態区分２");
        exDateYMEquals(dakuhiKettei.getKantiym2(), null, "完治年月２");
        exStringEquals(dakuhiKettei.getKetsyacd(), "", "決定者コード");
        exStringEquals(dakuhiKettei.getPalketsyacd(), "", "ＰＡＬ決定者コード");
        exNumericEquals(dakuhiKettei.getTkjysydkno(), 0, "特条承諾番号");
        exDateEquals(dakuhiKettei.getTkjysydkymd(), null, "特条条件付承諾日");
        exClassificationEquals(dakuhiKettei.getTkjysydksyhykbn(), C_TkjysydksyhyKbn.BLNK, "特条承諾書不要区分");
        exClassificationEquals(dakuhiKettei.getSntkinfosakuseiyhkbn(), C_SntkinfosakuseiyhKbn.SAKUSEIYOU, "選択情報作成要否区分");
        exClassificationEquals(dakuhiKettei.getTorikesisyousairiyuucd(), C_TorikesisyousairiyuuCd.BLNK, "取消詳細理由コード");
        exStringEquals(dakuhiKettei.getGyoumuKousinsyaId(), "TestKosId", "業務用更新者ＩＤ");
        exStringEquals(dakuhiKettei.getGyoumuKousinTime(), "20160218164901001", "業務用更新時間");
    }

    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(2010)
    public void testExec_B1() {
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        Kettei kettei = SWAKInjector.getInstance(Kettei.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("882000003");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160218"));
        mosnaiCheckParam.setKosID("TestKosId");
        mosnaiCheckParam.setKosTime("20160218164901001");

        try {
            kettei.exec(mosnaiCheckParam);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。代表申込番号=882000003", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @Transactional
    @TestOrder(2020)
    public void testExec_B2() {
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        Kettei kettei = SWAKInjector.getInstance(Kettei.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("882000011");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160218"));
        mosnaiCheckParam.setKosID("TestKosId");
        mosnaiCheckParam.setKosTime("20160218164901001");

        kettei.exec(mosnaiCheckParam);

        syoriCTL = sinkeiyakuDomManager.getSyoriCTL("882000011");

        exStringEquals(syoriCTL.getMosno(), "882000011", "申込番号");
        exClassificationEquals(syoriCTL.getKetteikbn(), C_KetteiKbn.KETTEI_SUMI, "決定状態区分");

        List<HT_DakuhiKettei> dakuhiKetteiLst = syoriCTL.getDakuhiKetteis();

        exNumericEquals(dakuhiKetteiLst.size(), 1, "諾否決定テーブルエンティティリストのサイズ");

        HT_JigyouIkkatu jigyouIkkatu = sinkeiyakuDomManager.getJigyouIkkatu("882000011");

        exStringEquals(jigyouIkkatu.getDaimosno(), "882000011", "代表申込番号");
        exClassificationEquals(jigyouIkkatu.getMosnrkumu(), C_UmuKbn.ARI, "申込書入力有無");
        exClassificationEquals(jigyouIkkatu.getKktnrkumu(), C_UmuKbn.NONE, "告知書入力有無");
        exClassificationEquals(jigyouIkkatu.getHjynrkumu(), C_UmuKbn.ARI, "報状入力有無");
        exClassificationEquals(jigyouIkkatu.getNyknnrkumu(), C_UmuKbn.NONE, "入金入力有無");
        exClassificationEquals(jigyouIkkatu.getNyknwarinrkumu(), C_UmuKbn.NONE, "入金割当入力有無");
        exClassificationEquals(jigyouIkkatu.getItijiketnrkumu(), C_UmuKbn.ARI, "１次決定入力有無");
        exClassificationEquals(jigyouIkkatu.getJiketteikbn(), C_JiketteiKbn.KETTEI_MATI, "事業一括決定状態区分");
        exClassificationEquals(jigyouIkkatu.getJgyiktsrkbn(), C_SeirituKbn.ITIPMATI, "事業一括成立区分");
        exDateEquals(jigyouIkkatu.getJgyiktsrymd(), BizDate.valueOf("19990105"), "事業一括成立日");
        exStringEquals(jigyouIkkatu.getGyoumuKousinsyaId(), "TestKosId", "業務用更新者ＩＤ");
        exStringEquals(jigyouIkkatu.getGyoumuKousinTime(), "20160218164901001", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(2030)
    public void testExec_B3() {
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        Kettei kettei = SWAKInjector.getInstance(Kettei.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("882000029");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160218"));
        mosnaiCheckParam.setKosID("TestKosId");
        mosnaiCheckParam.setKosTime("20160218164901001");

        kettei.exec(mosnaiCheckParam);

        HT_JigyouIkkatu jigyouIkkatu = sinkeiyakuDomManager.getJigyouIkkatu("882000029");

        exStringEquals(jigyouIkkatu.getDaimosno(), "882000029", "代表申込番号");
        exClassificationEquals(jigyouIkkatu.getMosnrkumu(), C_UmuKbn.ARI, "申込書入力有無");
        exClassificationEquals(jigyouIkkatu.getKktnrkumu(), C_UmuKbn.ARI, "告知書入力有無");
        exClassificationEquals(jigyouIkkatu.getHjynrkumu(), C_UmuKbn.NONE, "報状入力有無");
        exClassificationEquals(jigyouIkkatu.getNyknnrkumu(), C_UmuKbn.NONE, "入金入力有無");
        exClassificationEquals(jigyouIkkatu.getNyknwarinrkumu(), C_UmuKbn.NONE, "入金割当入力有無");
        exClassificationEquals(jigyouIkkatu.getItijiketnrkumu(), C_UmuKbn.ARI, "１次決定入力有無");
        exClassificationEquals(jigyouIkkatu.getJiketteikbn(), C_JiketteiKbn.KETTEI_MATI, "事業一括決定状態区分");
        exClassificationEquals(jigyouIkkatu.getJgyiktsrkbn(), C_SeirituKbn.ITIPMATI, "事業一括成立区分");
        exDateEquals(jigyouIkkatu.getJgyiktsrymd(), BizDate.valueOf("19990105"), "事業一括成立日");
        exStringEquals(jigyouIkkatu.getGyoumuKousinsyaId(), "TestKosId", "業務用更新者ＩＤ");
        exStringEquals(jigyouIkkatu.getGyoumuKousinTime(), "20160218164901001", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(2040)
    public void testExec_B4() {
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        Kettei kettei = SWAKInjector.getInstance(Kettei.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("882000037");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160218"));
        mosnaiCheckParam.setKosID("TestKosId");
        mosnaiCheckParam.setKosTime("20160218164901001");

        kettei.exec(mosnaiCheckParam);

        HT_JigyouIkkatu jigyouIkkatu = sinkeiyakuDomManager.getJigyouIkkatu("882000037");

        exStringEquals(jigyouIkkatu.getDaimosno(), "882000037", "代表申込番号");
        exClassificationEquals(jigyouIkkatu.getMosnrkumu(), C_UmuKbn.ARI, "申込書入力有無");
        exClassificationEquals(jigyouIkkatu.getKktnrkumu(), C_UmuKbn.ARI, "告知書入力有無");
        exClassificationEquals(jigyouIkkatu.getHjynrkumu(), C_UmuKbn.NONE, "報状入力有無");
        exClassificationEquals(jigyouIkkatu.getNyknnrkumu(), C_UmuKbn.NONE, "入金入力有無");
        exClassificationEquals(jigyouIkkatu.getNyknwarinrkumu(), C_UmuKbn.NONE, "入金割当入力有無");
        exClassificationEquals(jigyouIkkatu.getItijiketnrkumu(), C_UmuKbn.ARI, "１次決定入力有無");
        exClassificationEquals(jigyouIkkatu.getJiketteikbn(), C_JiketteiKbn.NONE, "事業一括決定状態区分");
        exClassificationEquals(jigyouIkkatu.getJgyiktsrkbn(), C_SeirituKbn.ITIPMATI, "事業一括成立区分");
        exDateEquals(jigyouIkkatu.getJgyiktsrymd(), BizDate.valueOf("19990105"), "事業一括成立日");
        exStringEquals(jigyouIkkatu.getGyoumuKousinsyaId(), "hand", "業務用更新者ＩＤ");
        exStringEquals(jigyouIkkatu.getGyoumuKousinTime(), "19990105010101001", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(2050)
    public void testExec_B5() {
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        Kettei kettei = SWAKInjector.getInstance(Kettei.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("882000045");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160218"));
        mosnaiCheckParam.setKosID("TestKosId");
        mosnaiCheckParam.setKosTime("20160218164901001");

        kettei.exec(mosnaiCheckParam);

        HT_JigyouIkkatu jigyouIkkatu = sinkeiyakuDomManager.getJigyouIkkatu("882000045");

        exStringEquals(jigyouIkkatu.getDaimosno(), "882000045", "代表申込番号");
        exClassificationEquals(jigyouIkkatu.getMosnrkumu(), C_UmuKbn.ARI, "申込書入力有無");
        exClassificationEquals(jigyouIkkatu.getKktnrkumu(), C_UmuKbn.NONE, "告知書入力有無");
        exClassificationEquals(jigyouIkkatu.getHjynrkumu(), C_UmuKbn.ARI, "報状入力有無");
        exClassificationEquals(jigyouIkkatu.getNyknnrkumu(), C_UmuKbn.NONE, "入金入力有無");
        exClassificationEquals(jigyouIkkatu.getNyknwarinrkumu(), C_UmuKbn.NONE, "入金割当入力有無");
        exClassificationEquals(jigyouIkkatu.getItijiketnrkumu(), C_UmuKbn.ARI, "１次決定入力有無");
        exClassificationEquals(jigyouIkkatu.getJiketteikbn(), C_JiketteiKbn.NONE, "事業一括決定状態区分");
        exClassificationEquals(jigyouIkkatu.getJgyiktsrkbn(), C_SeirituKbn.ITIPMATI, "事業一括成立区分");
        exDateEquals(jigyouIkkatu.getJgyiktsrymd(), BizDate.valueOf("19990105"), "事業一括成立日");
        exStringEquals(jigyouIkkatu.getGyoumuKousinsyaId(), "hand", "業務用更新者ＩＤ");
        exStringEquals(jigyouIkkatu.getGyoumuKousinTime(), "19990105010101001", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(2060)
    public void testExec_B6() {
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        Kettei kettei = SWAKInjector.getInstance(Kettei.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("882000052");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160218"));
        mosnaiCheckParam.setKosID("TestKosId");
        mosnaiCheckParam.setKosTime("20160218164901001");

        kettei.exec(mosnaiCheckParam);

        HT_JigyouIkkatu jigyouIkkatu = sinkeiyakuDomManager.getJigyouIkkatu("882000052");

        exStringEquals(jigyouIkkatu.getDaimosno(), "882000052", "代表申込番号");
        exClassificationEquals(jigyouIkkatu.getMosnrkumu(), C_UmuKbn.ARI, "申込書入力有無");
        exClassificationEquals(jigyouIkkatu.getKktnrkumu(), C_UmuKbn.ARI, "告知書入力有無");
        exClassificationEquals(jigyouIkkatu.getHjynrkumu(), C_UmuKbn.ARI, "報状入力有無");
        exClassificationEquals(jigyouIkkatu.getNyknnrkumu(), C_UmuKbn.NONE, "入金入力有無");
        exClassificationEquals(jigyouIkkatu.getNyknwarinrkumu(), C_UmuKbn.NONE, "入金割当入力有無");
        exClassificationEquals(jigyouIkkatu.getItijiketnrkumu(), C_UmuKbn.ARI, "１次決定入力有無");
        exClassificationEquals(jigyouIkkatu.getJiketteikbn(), C_JiketteiKbn.KETTEI_SUMI, "事業一括決定状態区分");
        exClassificationEquals(jigyouIkkatu.getJgyiktsrkbn(), C_SeirituKbn.ITIPMATI, "事業一括成立区分");
        exDateEquals(jigyouIkkatu.getJgyiktsrymd(), BizDate.valueOf("19990105"), "事業一括成立日");
        exStringEquals(jigyouIkkatu.getGyoumuKousinsyaId(), "hand", "業務用更新者ＩＤ");
        exStringEquals(jigyouIkkatu.getGyoumuKousinTime(), "19990105010101001", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(2070)
    public void testExec_B7() {
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        Kettei kettei = SWAKInjector.getInstance(Kettei.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("882000060");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160218"));
        mosnaiCheckParam.setKosID("TestKosId");
        mosnaiCheckParam.setKosTime("20160218164901001");

        kettei.exec(mosnaiCheckParam);

        HT_JigyouIkkatu jigyouIkkatu = sinkeiyakuDomManager.getJigyouIkkatu("882000060");

        exStringEquals(jigyouIkkatu.getDaimosno(), "882000060", "代表申込番号");
        exClassificationEquals(jigyouIkkatu.getMosnrkumu(), C_UmuKbn.NONE, "申込書入力有無");
        exClassificationEquals(jigyouIkkatu.getKktnrkumu(), C_UmuKbn.ARI, "告知書入力有無");
        exClassificationEquals(jigyouIkkatu.getHjynrkumu(), C_UmuKbn.ARI, "報状入力有無");
        exClassificationEquals(jigyouIkkatu.getNyknnrkumu(), C_UmuKbn.NONE, "入金入力有無");
        exClassificationEquals(jigyouIkkatu.getNyknwarinrkumu(), C_UmuKbn.NONE, "入金割当入力有無");
        exClassificationEquals(jigyouIkkatu.getItijiketnrkumu(), C_UmuKbn.ARI, "１次決定入力有無");
        exClassificationEquals(jigyouIkkatu.getJiketteikbn(), C_JiketteiKbn.NONE, "事業一括決定状態区分");
        exClassificationEquals(jigyouIkkatu.getJgyiktsrkbn(), C_SeirituKbn.ITIPMATI, "事業一括成立区分");
        exDateEquals(jigyouIkkatu.getJgyiktsrymd(), BizDate.valueOf("19990105"), "事業一括成立日");
        exStringEquals(jigyouIkkatu.getGyoumuKousinsyaId(), "hand", "業務用更新者ＩＤ");
        exStringEquals(jigyouIkkatu.getGyoumuKousinTime(), "19990105010101001", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(2080)
    public void testExec_B8() {
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        Kettei kettei = SWAKInjector.getInstance(Kettei.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("882000078");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160218"));
        mosnaiCheckParam.setKosID("TestKosId");
        mosnaiCheckParam.setKosTime("20160218164901001");

        kettei.exec(mosnaiCheckParam);

        HT_JigyouIkkatu jigyouIkkatu = sinkeiyakuDomManager.getJigyouIkkatu("882000078");

        exStringEquals(jigyouIkkatu.getDaimosno(), "882000078", "代表申込番号");
        exClassificationEquals(jigyouIkkatu.getMosnrkumu(), C_UmuKbn.ARI, "申込書入力有無");
        exClassificationEquals(jigyouIkkatu.getKktnrkumu(), C_UmuKbn.ARI, "告知書入力有無");
        exClassificationEquals(jigyouIkkatu.getHjynrkumu(), C_UmuKbn.ARI, "報状入力有無");
        exClassificationEquals(jigyouIkkatu.getNyknnrkumu(), C_UmuKbn.NONE, "入金入力有無");
        exClassificationEquals(jigyouIkkatu.getNyknwarinrkumu(), C_UmuKbn.NONE, "入金割当入力有無");
        exClassificationEquals(jigyouIkkatu.getItijiketnrkumu(), C_UmuKbn.NONE, "１次決定入力有無");
        exClassificationEquals(jigyouIkkatu.getJiketteikbn(), C_JiketteiKbn.NONE, "事業一括決定状態区分");
        exClassificationEquals(jigyouIkkatu.getJgyiktsrkbn(), C_SeirituKbn.ITIPMATI, "事業一括成立区分");
        exDateEquals(jigyouIkkatu.getJgyiktsrymd(), BizDate.valueOf("19990105"), "事業一括成立日");
        exStringEquals(jigyouIkkatu.getGyoumuKousinsyaId(), "hand", "業務用更新者ＩＤ");
        exStringEquals(jigyouIkkatu.getGyoumuKousinTime(), "19990105010101001", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(3010)
    public void testExec_C1() {
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        Kettei kettei = SWAKInjector.getInstance(Kettei.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("883000002");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160218"));
        mosnaiCheckParam.setKosID("KOS456789012345");
        mosnaiCheckParam.setKosTime("20160218164901001");

        kettei.exec(mosnaiCheckParam);

        syoriCTL = sinkeiyakuDomManager.getSyoriCTL("883000002");

        List<HT_DakuhiKettei> dakuhiKetteiLst = syoriCTL.getDakuhiKetteis();
        dakuhiKetteiLst = new SortHT_DakuhiKettei().OrderHT_DakuhiKetteiByPkDesc(dakuhiKetteiLst);
        HT_DakuhiKettei dakuhiKettei = dakuhiKetteiLst.get(0);

        exStringEquals(dakuhiKettei.getMosno(), "883000002", "申込番号");
        exNumericEquals(dakuhiKettei.getDakuhiktrenno(), 10, "諾否決定連番");
        exStringEquals(dakuhiKettei.getGyoumuKousinsyaId(), "KOS456789012345", "業務用更新者ＩＤ");
        exStringEquals(dakuhiKettei.getGyoumuKousinTime(), "20160218164901001", "業務用更新時間");

        HT_JigyouIkkatu jigyouIkkatu = sinkeiyakuDomManager.getJigyouIkkatu("883000002");

        exStringEquals(jigyouIkkatu.getDaimosno(), "883000002", "代表申込番号");
        exClassificationEquals(jigyouIkkatu.getJiketteikbn(), C_JiketteiKbn.KETTEI_MATI, "事業一括決定状態区分");
        exStringEquals(jigyouIkkatu.getGyoumuKousinsyaId(), "KOS456789012345", "業務用更新者ＩＤ");
        exStringEquals(jigyouIkkatu.getGyoumuKousinTime(), "20160218164901001", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(3020)
    public void testExec_C2() {
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        Kettei kettei = SWAKInjector.getInstance(Kettei.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("883000010");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        kettei.exec(mosnaiCheckParam);

        syoriCTL = sinkeiyakuDomManager.getSyoriCTL("883000010");

        List<HT_DakuhiKettei> dakuhiKetteiLst = syoriCTL.getDakuhiKetteis();
        dakuhiKetteiLst = new SortHT_DakuhiKettei().OrderHT_DakuhiKetteiByPkDesc(dakuhiKetteiLst);
        HT_DakuhiKettei dakuhiKettei = dakuhiKetteiLst.get(0);

        exStringEquals(dakuhiKettei.getMosno(), "883000010", "申込番号");
        exDateEquals(dakuhiKettei.getKetymd(), null, "決定日");
        exStringEquals(dakuhiKettei.getGyoumuKousinsyaId(), "", "業務用更新者ＩＤ");
        exStringEquals(dakuhiKettei.getGyoumuKousinTime(), "", "業務用更新時間");

        HT_JigyouIkkatu jigyouIkkatu = sinkeiyakuDomManager.getJigyouIkkatu("883000010");

        exStringEquals(jigyouIkkatu.getDaimosno(), "883000010", "代表申込番号");
        exClassificationEquals(jigyouIkkatu.getJiketteikbn(), C_JiketteiKbn.KETTEI_MATI, "事業一括決定状態区分");
        exStringEquals(jigyouIkkatu.getGyoumuKousinsyaId(), "", "業務用更新者ＩＤ");
        exStringEquals(jigyouIkkatu.getGyoumuKousinTime(), "", "業務用更新時間");
    }
}