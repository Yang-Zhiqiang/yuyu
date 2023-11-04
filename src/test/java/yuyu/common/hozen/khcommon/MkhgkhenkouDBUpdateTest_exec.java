package yuyu.common.hozen.khcommon;

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
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.base.BaseUserInfo;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_HonninKakninKekkaKbn;
import yuyu.def.classification.C_KinouKbn;
import yuyu.def.classification.C_TargetTkMokuhyoutiKbn;
import yuyu.def.classification.C_UktkJyoutaiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_KhHenkouUktk;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 目標額変更DB更新クラスのメソッド {@link MkhgkhenkouDBUpdate#exec(MkhgkhenkouDBUpdateBean)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class MkhgkhenkouDBUpdateTest_exec extends AbstractTest {

    @Inject
    private MkhgkhenkouDBUpdate khgkhenkouDBUpdate;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BaseUserInfo baseUserInfo;

    private final static String fileName = "UT_SP_単体テスト仕様書_目標額変更DB更新";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(PALKykNaiyouSakuseiTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
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
        hozenDomManager.delete(hozenDomManager.getAllKhHenkouUktk());
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void testExec_A1() {

        changeSystemDate(BizDate.valueOf("20200703"));
        kinou.setKinouId("MkhgkhenkouDBUpdate");
        baseUserInfo.getUser().setUserId("user001");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        MkhgkhenkouDBUpdateBean mkhgkhenkouDBUpdateBean = SWAKInjector.getInstance(MkhgkhenkouDBUpdateBean.class);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001010");
        mkhgkhenkouDBUpdateBean.setKykKihon(kykKihon);
        IT_KhHenkouUktk khHenkouUktk = hozenDomManager.getKhHenkouUktk("99806001010", 1);
        mkhgkhenkouDBUpdateBean.setKhHenkouUktk(khHenkouUktk);
        mkhgkhenkouDBUpdateBean.setTargetTkKykhenkoymd(BizDate.valueOf(20060101));
        mkhgkhenkouDBUpdateBean.setTargettkMkhtkbn(C_TargetTkMokuhyoutiKbn.NOTARGET);
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        mkhgkhenkouDBUpdateBean.setKhCommonParam(khozenCommonParam);
        mkhgkhenkouDBUpdateBean.setHonninKakninKekkaKbn(C_HonninKakninKekkaKbn.SUMI_PASSPORT);
        mkhgkhenkouDBUpdateBean.setKouteiKanriId("00q2kdqhzw5wt75540");
        mkhgkhenkouDBUpdateBean.setHassouKbn(C_HassouKbn.TYOKUSOU);
        mkhgkhenkouDBUpdateBean.setSyoriYmd(BizDate.valueOf(20200708));

        khgkhenkouDBUpdate.exec(mkhgkhenkouDBUpdateBean);

        IT_KykKihon kykKihonUpd = khgkhenkouDBUpdate.getKykKihon();
        exStringEquals(kykKihonUpd.getKbnkey(), "01", "区分キー");
        exStringEquals(kykKihonUpd.getSyono(), "99806001010", "証券番号");
        exDateEquals(kykKihonUpd.getSyhenkouymd(), BizDate.valueOf(20200708), "最終変更日");
        exStringEquals(kykKihonUpd.getGyoumuKousinKinou(), "MkhgkhenkouDBUpdate", "業務用更新機能ＩＤ");
        exStringEquals(kykKihonUpd.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(kykKihonUpd.getGyoumuKousinTime().substring(0, 8), "20200703", "業務用更新時間");

        IT_KykSonotaTkyk kykSonotaTkyk =kykKihonUpd.getKykSonotaTkyk();
        exStringEquals(kykSonotaTkyk.getKbnkey(), "01", "区分キー");
        exStringEquals(kykSonotaTkyk.getSyono(), "99806001010", "証券番号");
        exDateEquals(kykSonotaTkyk.getTargettkykkykhenkoymd(), BizDate.valueOf(20060101), "ターゲット特約契約変更日");
        exNumericEquals(kykSonotaTkyk.getTargettkmokuhyouti(), 0, "ターゲット特約目標値");
        exStringEquals(kykSonotaTkyk.getGyoumuKousinKinou(), "MkhgkhenkouDBUpdate", "業務用更新機能ＩＤ");
        exStringEquals(kykSonotaTkyk.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(kykSonotaTkyk.getGyoumuKousinTime().substring(0, 8), "20200703", "業務用更新時間");

        IT_KhHenkouUktk khHenkouUktkUpd = khgkhenkouDBUpdate.getKhHenkouUktk();
        exStringEquals(khHenkouUktkUpd.getKbnkey(), "01", "区分キー");
        exStringEquals(khHenkouUktkUpd.getSyono(), "99806001010", "証券番号");
        exClassificationEquals(khHenkouUktkUpd.getUktkjyoutaikbn(), C_UktkJyoutaiKbn.MISYORI, "受付状態区分");
        exStringEquals(khHenkouUktkUpd.getGyoumuKousinKinou(), "khmkhgktttyendthnk", "業務用更新機能ＩＤ");
        exStringEquals(khHenkouUktkUpd.getGyoumuKousinsyaId(), "BatchSystem", "業務用更新者ＩＤ");
        exStringEquals(khHenkouUktkUpd.getGyoumuKousinTime(), "20190826092830560","業務用更新時間");
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testExec_A2() {

        changeSystemDate(BizDate.valueOf("20200703"));
        kinou.setKinouId("MkhgkhenkouDBUpdate");
        baseUserInfo.getUser().setUserId("user001");
        kinou.setKinouKbn(C_KinouKbn.BATCH);

        MkhgkhenkouDBUpdateBean mkhgkhenkouDBUpdateBean = SWAKInjector.getInstance(MkhgkhenkouDBUpdateBean.class);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001021");
        mkhgkhenkouDBUpdateBean.setKykKihon(kykKihon);
        IT_KhHenkouUktk khHenkouUktk = hozenDomManager.getKhHenkouUktk("99806001021", 1);
        mkhgkhenkouDBUpdateBean.setKhHenkouUktk(khHenkouUktk);
        mkhgkhenkouDBUpdateBean.setTargetTkKykhenkoymd(BizDate.valueOf(20060101));
        mkhgkhenkouDBUpdateBean.setTargettkMkhtkbn(C_TargetTkMokuhyoutiKbn.TARGET105);
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        mkhgkhenkouDBUpdateBean.setKhCommonParam(khozenCommonParam);
        mkhgkhenkouDBUpdateBean.setHonninKakninKekkaKbn(C_HonninKakninKekkaKbn.SUMI_PASSPORT);
        mkhgkhenkouDBUpdateBean.setKouteiKanriId("00q2kdqhzw5wt75540");
        mkhgkhenkouDBUpdateBean.setHassouKbn(C_HassouKbn.TYOKUSOU);
        mkhgkhenkouDBUpdateBean.setSyoriYmd(BizDate.valueOf(20200708));

        khgkhenkouDBUpdate.exec(mkhgkhenkouDBUpdateBean);

        IT_KykKihon kykKihonUpd = khgkhenkouDBUpdate.getKykKihon();
        exStringEquals(kykKihonUpd.getKbnkey(), "02", "区分キー");
        exStringEquals(kykKihonUpd.getSyono(), "99806001021", "証券番号");
        exDateEquals(kykKihonUpd.getSyhenkouymd(), BizDate.valueOf(20200708), "最終変更日");
        exStringEquals(kykKihonUpd.getGyoumuKousinKinou(), "MkhgkhenkouDBUpdate", "業務用更新機能ＩＤ");
        exStringEquals(kykKihonUpd.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(kykKihonUpd.getGyoumuKousinTime().substring(0, 8), "20200703", "業務用更新時間");

        IT_KykSonotaTkyk kykSonotaTkyk =kykKihonUpd.getKykSonotaTkyk();
        exStringEquals(kykSonotaTkyk.getKbnkey(), "02", "区分キー");
        exStringEquals(kykSonotaTkyk.getSyono(), "99806001021", "証券番号");
        exDateEquals(kykSonotaTkyk.getTargettkykkykhenkoymd(), BizDate.valueOf(20060101), "ターゲット特約契約変更日");
        exNumericEquals(kykSonotaTkyk.getTargettkmokuhyouti(), 105, "ターゲット特約目標値");
        exStringEquals(kykSonotaTkyk.getGyoumuKousinKinou(), "MkhgkhenkouDBUpdate", "業務用更新機能ＩＤ");
        exStringEquals(kykSonotaTkyk.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(kykSonotaTkyk.getGyoumuKousinTime().substring(0, 8), "20200703", "業務用更新時間");

        IT_KhHenkouUktk khHenkouUktkUpd = khgkhenkouDBUpdate.getKhHenkouUktk();
        exStringEquals(khHenkouUktkUpd.getKbnkey(), "02", "区分キー");
        exStringEquals(khHenkouUktkUpd.getSyono(), "99806001021", "証券番号");
        exClassificationEquals(khHenkouUktkUpd.getUktkjyoutaikbn(), C_UktkJyoutaiKbn.SYORIZUMI, "受付状態区分");
        exStringEquals(khHenkouUktkUpd.getGyoumuKousinKinou(), "MkhgkhenkouDBUpdate", "業務用更新機能ＩＤ");
        exStringEquals(khHenkouUktkUpd.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(khHenkouUktkUpd.getGyoumuKousinTime().substring(0, 8), "20200703","業務用更新時間");
    }
}
