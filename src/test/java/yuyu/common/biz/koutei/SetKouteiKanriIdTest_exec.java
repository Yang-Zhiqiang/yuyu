package yuyu.common.biz.koutei;

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
import yuyu.common.base.BaseUserInfo;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 工程管理ＩＤ設定クラスのメソッド {@link SetKouteiKanriId#exec(SetKouteiKanriIdInBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetKouteiKanriIdTest_exec {

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    AS_Kinou asKinou;

    private final static String fileName = "UT_SP_単体テスト仕様書_工程管理ID設定";
    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {

            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SetKouteiKanriIdTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllGyoumuKouteiInfo());
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        baseDomManager.delete(baseDomManager.getAllCategories());
        baseDomManager.delete(baseDomManager.getAllSubSystems());

    }

    @Test
    @Transactional
    @TestOrder(10)
    public void testExec_A1() {

        SetKouteiKanriIdInBean setKouteiKanriIdInBean = SWAKInjector.getInstance(SetKouteiKanriIdInBean.class);
        SetKouteiKanriId setKouteiKanriId = SWAKInjector.getInstance(SetKouteiKanriId.class);

        asKinou.setKinouId("koutei");

        setKouteiKanriIdInBean.setOyaKouteiKanriId(null);
        setKouteiKanriIdInBean.setOyaKouteiJimutetuzukiCd("303");
        setKouteiKanriIdInBean.setSubSystemId("1001");
        setKouteiKanriIdInBean.setJimutetuzukiCd("2002");
        setKouteiKanriIdInBean.setMosNo("791112220");
        setKouteiKanriIdInBean.setSyoNo("11810111118");
        setKouteiKanriIdInBean.setSkNo("0001");
        setKouteiKanriIdInBean.setNkSysyNo("11807111129");

        String kouteiKanriId = setKouteiKanriId.exec(setKouteiKanriIdInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo(kouteiKanriId);

        exStringEquals(gyoumuKouteiInfo.getKouteikanriid(), kouteiKanriId, "工程管理ID");
        exStringEquals(gyoumuKouteiInfo.getSubSystemId(), "1001", "サブシステムID");
        exStringEquals(gyoumuKouteiInfo.getJimutetuzukicd(), "2002", "事務手続コード");
        exStringEquals(gyoumuKouteiInfo.getMosno(), "791112220", "申込番号");
        exStringEquals(gyoumuKouteiInfo.getSyono(), "11810111118", "証券番号");
        exStringEquals(gyoumuKouteiInfo.getSkno(), "0001", "請求番号");
        exStringEquals(gyoumuKouteiInfo.getNksysyno(), "11807111129", "年金証書番号");
        exStringEquals(gyoumuKouteiInfo.getSyukouteikanriid(), kouteiKanriId, "主工程管理ID");
        exStringEquals(gyoumuKouteiInfo.getSyukouteijimutetuzukicd(), "2002", "主工程事務手続コード");
        exStringEquals(gyoumuKouteiInfo.getGyoumuKousinKinou(), "koutei", "業務用更新機能ID");
        exStringEquals(gyoumuKouteiInfo.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testExec_A2() {

        SetKouteiKanriIdInBean setKouteiKanriIdInBean = SWAKInjector.getInstance(SetKouteiKanriIdInBean.class);
        SetKouteiKanriId setKouteiKanriId = SWAKInjector.getInstance(SetKouteiKanriId.class);

        asKinou.setKinouId("koutei");

        setKouteiKanriIdInBean.setOyaKouteiKanriId("");
        setKouteiKanriIdInBean.setOyaKouteiJimutetuzukiCd("303");
        setKouteiKanriIdInBean.setSubSystemId("1001");
        setKouteiKanriIdInBean.setJimutetuzukiCd("2002");
        setKouteiKanriIdInBean.setMosNo("791112220");
        setKouteiKanriIdInBean.setSyoNo("11810111118");
        setKouteiKanriIdInBean.setSkNo("0001");
        setKouteiKanriIdInBean.setNkSysyNo("11807111129");

        String kouteiKanriId = setKouteiKanriId.exec(setKouteiKanriIdInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo(kouteiKanriId);

        exStringEquals(gyoumuKouteiInfo.getKouteikanriid(), kouteiKanriId, "工程管理ID");
        exStringEquals(gyoumuKouteiInfo.getSubSystemId(), "1001", "サブシステムID");
        exStringEquals(gyoumuKouteiInfo.getJimutetuzukicd(), "2002", "事務手続コード");
        exStringEquals(gyoumuKouteiInfo.getMosno(), "791112220", "申込番号");
        exStringEquals(gyoumuKouteiInfo.getSyono(), "11810111118", "証券番号");
        exStringEquals(gyoumuKouteiInfo.getSkno(), "0001", "請求番号");
        exStringEquals(gyoumuKouteiInfo.getNksysyno(), "11807111129", "年金証書番号");
        exStringEquals(gyoumuKouteiInfo.getSyukouteikanriid(), kouteiKanriId, "主工程管理ID");
        exStringEquals(gyoumuKouteiInfo.getSyukouteijimutetuzukicd(), "2002", "主工程事務手続コード");
        exStringEquals(gyoumuKouteiInfo.getGyoumuKousinKinou(), "koutei", "業務用更新機能ID");
        exStringEquals(gyoumuKouteiInfo.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testExec_A3() {

        SetKouteiKanriIdInBean setKouteiKanriIdInBean = SWAKInjector.getInstance(SetKouteiKanriIdInBean.class);
        SetKouteiKanriId setKouteiKanriId = SWAKInjector.getInstance(SetKouteiKanriId.class);

        asKinou.setKinouId("koutei");

        setKouteiKanriIdInBean.setOyaKouteiKanriId("303");
        setKouteiKanriIdInBean.setOyaKouteiJimutetuzukiCd(null);
        setKouteiKanriIdInBean.setSubSystemId("1001");
        setKouteiKanriIdInBean.setJimutetuzukiCd("2002");
        setKouteiKanriIdInBean.setMosNo("791112220");
        setKouteiKanriIdInBean.setSyoNo("11810111118");
        setKouteiKanriIdInBean.setSkNo("0001");
        setKouteiKanriIdInBean.setNkSysyNo("11807111129");

        String kouteiKanriId = setKouteiKanriId.exec(setKouteiKanriIdInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo(kouteiKanriId);

        exStringEquals(gyoumuKouteiInfo.getKouteikanriid(), kouteiKanriId, "工程管理ID");
        exStringEquals(gyoumuKouteiInfo.getSubSystemId(), "1001", "サブシステムID");
        exStringEquals(gyoumuKouteiInfo.getJimutetuzukicd(), "2002", "事務手続コード");
        exStringEquals(gyoumuKouteiInfo.getMosno(), "791112220", "申込番号");
        exStringEquals(gyoumuKouteiInfo.getSyono(), "11810111118", "証券番号");
        exStringEquals(gyoumuKouteiInfo.getSkno(), "0001", "請求番号");
        exStringEquals(gyoumuKouteiInfo.getNksysyno(), "11807111129", "年金証書番号");
        exStringEquals(gyoumuKouteiInfo.getSyukouteikanriid(), kouteiKanriId, "主工程管理ID");
        exStringEquals(gyoumuKouteiInfo.getSyukouteijimutetuzukicd(), "2002", "主工程事務手続コード");
        exStringEquals(gyoumuKouteiInfo.getGyoumuKousinKinou(), "koutei", "業務用更新機能ID");
        exStringEquals(gyoumuKouteiInfo.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testExec_A4() {

        SetKouteiKanriIdInBean setKouteiKanriIdInBean = SWAKInjector.getInstance(SetKouteiKanriIdInBean.class);
        SetKouteiKanriId setKouteiKanriId = SWAKInjector.getInstance(SetKouteiKanriId.class);

        asKinou.setKinouId("koutei");

        setKouteiKanriIdInBean.setOyaKouteiKanriId("303");
        setKouteiKanriIdInBean.setOyaKouteiJimutetuzukiCd("");
        setKouteiKanriIdInBean.setSubSystemId("1001");
        setKouteiKanriIdInBean.setJimutetuzukiCd("2002");
        setKouteiKanriIdInBean.setMosNo("791112220");
        setKouteiKanriIdInBean.setSyoNo("11810111118");
        setKouteiKanriIdInBean.setSkNo("0001");
        setKouteiKanriIdInBean.setNkSysyNo("11807111129");

        String kouteiKanriId = setKouteiKanriId.exec(setKouteiKanriIdInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo(kouteiKanriId);

        exStringEquals(gyoumuKouteiInfo.getKouteikanriid(), kouteiKanriId, "工程管理ID");
        exStringEquals(gyoumuKouteiInfo.getSubSystemId(), "1001", "サブシステムID");
        exStringEquals(gyoumuKouteiInfo.getJimutetuzukicd(), "2002", "事務手続コード");
        exStringEquals(gyoumuKouteiInfo.getMosno(), "791112220", "申込番号");
        exStringEquals(gyoumuKouteiInfo.getSyono(), "11810111118", "証券番号");
        exStringEquals(gyoumuKouteiInfo.getSkno(), "0001", "請求番号");
        exStringEquals(gyoumuKouteiInfo.getNksysyno(), "11807111129", "年金証書番号");
        exStringEquals(gyoumuKouteiInfo.getSyukouteikanriid(), kouteiKanriId, "主工程管理ID");
        exStringEquals(gyoumuKouteiInfo.getSyukouteijimutetuzukicd(), "2002", "主工程事務手続コード");
        exStringEquals(gyoumuKouteiInfo.getGyoumuKousinKinou(), "koutei", "業務用更新機能ID");
        exStringEquals(gyoumuKouteiInfo.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testExec_A5() {

        SetKouteiKanriIdInBean setKouteiKanriIdInBean = SWAKInjector.getInstance(SetKouteiKanriIdInBean.class);
        SetKouteiKanriId setKouteiKanriId = SWAKInjector.getInstance(SetKouteiKanriId.class);

        asKinou.setKinouId("koutei");

        setKouteiKanriIdInBean.setOyaKouteiKanriId("303");
        setKouteiKanriIdInBean.setOyaKouteiJimutetuzukiCd("202");
        setKouteiKanriIdInBean.setSubSystemId("1001");
        setKouteiKanriIdInBean.setJimutetuzukiCd("2002");
        setKouteiKanriIdInBean.setMosNo("791112220");
        setKouteiKanriIdInBean.setSyoNo("11810111118");
        setKouteiKanriIdInBean.setSkNo("0001");
        setKouteiKanriIdInBean.setNkSysyNo("11807111129");

        String kouteiKanriId = setKouteiKanriId.exec(setKouteiKanriIdInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo(kouteiKanriId);

        exStringEquals(gyoumuKouteiInfo.getKouteikanriid(), kouteiKanriId, "工程管理ID");
        exStringEquals(gyoumuKouteiInfo.getSubSystemId(), "1001", "サブシステムID");
        exStringEquals(gyoumuKouteiInfo.getJimutetuzukicd(), "2002", "事務手続コード");
        exStringEquals(gyoumuKouteiInfo.getMosno(), "791112220", "申込番号");
        exStringEquals(gyoumuKouteiInfo.getSyono(), "11810111118", "証券番号");
        exStringEquals(gyoumuKouteiInfo.getSkno(), "0001", "請求番号");
        exStringEquals(gyoumuKouteiInfo.getNksysyno(), "11807111129", "年金証書番号");
        exStringEquals(gyoumuKouteiInfo.getSyukouteikanriid(), "303", "主工程管理ID");
        exStringEquals(gyoumuKouteiInfo.getSyukouteijimutetuzukicd(), "202", "主工程事務手続コード");
        exStringEquals(gyoumuKouteiInfo.getGyoumuKousinKinou(), "koutei", "業務用更新機能ID");
        exStringEquals(gyoumuKouteiInfo.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testExec_A6() {

        SetKouteiKanriIdInBean setKouteiKanriIdInBean = SWAKInjector.getInstance(SetKouteiKanriIdInBean.class);
        SetKouteiKanriId setKouteiKanriId = SWAKInjector.getInstance(SetKouteiKanriId.class);

        asKinou.setKinouId("koutei");

        setKouteiKanriIdInBean.setOyaKouteiKanriId("404");
        setKouteiKanriIdInBean.setOyaKouteiJimutetuzukiCd("303");
        setKouteiKanriIdInBean.setSubSystemId("1001");
        setKouteiKanriIdInBean.setJimutetuzukiCd("2002");
        setKouteiKanriIdInBean.setMosNo("");
        setKouteiKanriIdInBean.setSyoNo("");
        setKouteiKanriIdInBean.setSkNo("");
        setKouteiKanriIdInBean.setNkSysyNo("");

        String kouteiKanriId = setKouteiKanriId.exec(setKouteiKanriIdInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo(kouteiKanriId);

        exStringEquals(gyoumuKouteiInfo.getKouteikanriid(), kouteiKanriId, "工程管理ID");
        exStringEquals(gyoumuKouteiInfo.getSubSystemId(), "1001", "サブシステムID");
        exStringEquals(gyoumuKouteiInfo.getJimutetuzukicd(), "2002", "事務手続コード");
        exStringEquals(gyoumuKouteiInfo.getMosno(), "", "申込番号");
        exStringEquals(gyoumuKouteiInfo.getSyono(), "", "証券番号");
        exStringEquals(gyoumuKouteiInfo.getSkno(), "", "請求番号");
        exStringEquals(gyoumuKouteiInfo.getNksysyno(), "", "年金証書番号");
        exStringEquals(gyoumuKouteiInfo.getSyukouteikanriid(), "404", "主工程管理ID");
        exStringEquals(gyoumuKouteiInfo.getSyukouteijimutetuzukicd(), "303", "主工程事務手続コード");
        exStringEquals(gyoumuKouteiInfo.getGyoumuKousinKinou(), "koutei", "業務用更新機能ID");
        exStringEquals(gyoumuKouteiInfo.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

    }

    @Test
    @Transactional
    @TestOrder(70)
    public void testExec_A7() {

        AM_User aMUser = new AM_User();
        aMUser.setUserId("qa123qa123qa123");
        changeCurrentUser(baseUserInfo, aMUser);

        asKinou.setKinouId("quen1quen1quen1quen1quen1quen1quen1quen1quen1quen1");

        SetKouteiKanriIdInBean setKouteiKanriIdInBean = SWAKInjector.getInstance(SetKouteiKanriIdInBean.class);
        SetKouteiKanriId setKouteiKanriId = SWAKInjector.getInstance(SetKouteiKanriId.class);

        setKouteiKanriIdInBean.setOyaKouteiKanriId("k1234k1234k1234k1234");
        setKouteiKanriIdInBean.setOyaKouteiJimutetuzukiCd("a1234a1234a1234a123");
        setKouteiKanriIdInBean.setSubSystemId("s1234s1234s1234s1234s1234s1234s1234s1234s1234s1234");
        setKouteiKanriIdInBean.setJimutetuzukiCd("a1234a1234a1234a123");
        setKouteiKanriIdInBean.setMosNo("791112220");
        setKouteiKanriIdInBean.setSyoNo("11810111118");
        setKouteiKanriIdInBean.setSkNo("012345678901234567");
        setKouteiKanriIdInBean.setNkSysyNo("11807111129");

        String kouteiKanriId = setKouteiKanriId.exec(setKouteiKanriIdInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo(kouteiKanriId);

        exStringEquals(gyoumuKouteiInfo.getKouteikanriid(), kouteiKanriId, "工程管理ID");
        exStringEquals(gyoumuKouteiInfo.getSubSystemId()
            , "s1234s1234s1234s1234s1234s1234s1234s1234s1234s1234", "サブシステムID");
        exStringEquals(gyoumuKouteiInfo.getJimutetuzukicd(), "a1234a1234a1234a123", "事務手続コード");
        exStringEquals(gyoumuKouteiInfo.getMosno(), "791112220", "申込番号");
        exStringEquals(gyoumuKouteiInfo.getSyono(), "11810111118", "証券番号");
        exStringEquals(gyoumuKouteiInfo.getSkno(), "012345678901234567", "請求番号");
        exStringEquals(gyoumuKouteiInfo.getNksysyno(), "11807111129", "年金証書番号");
        exStringEquals(gyoumuKouteiInfo.getSyukouteikanriid(), "k1234k1234k1234k1234", "主工程管理ID");
        exStringEquals(gyoumuKouteiInfo.getSyukouteijimutetuzukicd(), "a1234a1234a1234a123", "主工程事務手続コード");
        exStringEquals(gyoumuKouteiInfo.getGyoumuKousinKinou()
            , "quen1quen1quen1quen1quen1quen1quen1quen1quen1quen1", "業務用更新機能ID");
        exStringEquals(gyoumuKouteiInfo.getGyoumuKousinsyaId(), "qa123qa123qa123", "業務用更新者ID");
        exNumericEquals(gyoumuKouteiInfo.getGyoumuKousinTime().length(), 17, "業務用更新時間");
    }
}
