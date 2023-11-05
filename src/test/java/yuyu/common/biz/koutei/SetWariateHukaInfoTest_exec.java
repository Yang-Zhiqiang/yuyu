package yuyu.common.biz.koutei;

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
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.base.BaseUserInfo;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_WariateHukaInfo;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 割当不可情報設定取得クラスのメソッド {@link SetWariateHukaInfo#exec(String, String, String, String,
            String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetWariateHukaInfoTest_exec extends AbstractTest{

    @Inject
    private SetWariateHukaInfo setWariateHukaInfo;
    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private AS_Kinou asKinou;

    private final static String fileName = "UT_SP_単体テスト仕様書_割当不可情報設定";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {

            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SetWariateHukaInfoTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllWariateHukaInfoKanri());
        bizDomManager.delete(bizDomManager.getAllWariateHukaInfo());
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        baseDomManager.delete(baseDomManager.getAllCategories());
        baseDomManager.delete(baseDomManager.getAllSubSystems());

        MockObjectManager.initialize();
    }

    @Test()
    @TestOrder(10)
    public void testExec_A1() {

        String pKouteiKanriId = "10000000001";
        String pSubSystemId = "0012";

        String pJimuTetuzukiCd = "001";
        String pCurrentTaskId = "20150701";
        String pNextTaskId = "20150801";
        setWariateHukaInfo.exec(pKouteiKanriId, pSubSystemId, pJimuTetuzukiCd, pCurrentTaskId, pNextTaskId);

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        String pKouteiKanriId = "10000000001";
        String pSubSystemId = "001";
        String pJimuTetuzukiCd = "001";
        String pCurrentTaskId = "20150701";
        String pNextTaskId = "20150801";


        setWariateHukaInfo.exec(pKouteiKanriId, pSubSystemId, pJimuTetuzukiCd, pCurrentTaskId, pNextTaskId);

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        String pKouteiKanriId = "10000000001";
        String pSubSystemId = "001";

        String pJimuTetuzukiCd = "001";
        String pCurrentTaskId = "20150705";
        String pNextTaskId = "20150802";


        setWariateHukaInfo.exec(pKouteiKanriId, pSubSystemId, pJimuTetuzukiCd, pCurrentTaskId, pNextTaskId);
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testExec_A4() {

        String pKouteiKanriId = "10000000001";
        String pSubSystemId = "001";

        String pJimuTetuzukiCd = "001";
        String pCurrentTaskId = "20150703";
        String pNextTaskId = "20150803";

        baseUserInfo.getUser().setUserId("JUnit");

        asKinou.setKinouId("koutei");

        changeSystemDate(BizDate.valueOf(2015,10,12));

        setWariateHukaInfo.exec(pKouteiKanriId, pSubSystemId, pJimuTetuzukiCd, pCurrentTaskId, pNextTaskId);

        bizDomManager.flush();

        List<BT_WariateHukaInfo> list = bizDomManager.getAllWariateHukaInfo();
        exStringEquals(list.get(0).getKouteikanriid(),"10000000001","工程管理ＩＤ");
        exStringEquals(list.get(0).getSubSystemId(),"001","サブシステムＩＤ");

        exStringEquals(list.get(0).getJimutetuzukicd(),"001","事務手続コード");
        exStringEquals(list.get(0).getWrthukatskid(),"001","割当不可タスクID");
        exStringEquals(list.get(0).getUserId(),"JUnit","ユーザーＩＤ");
        exStringEquals(list.get(0).getWrthukakaijyotskid(),"20150703","割当不可解除用タスクID");
        exStringEquals(list.get(0).getGyoumuKousinKinou(),"koutei","業務用更新機能ＩＤ");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(),"JUnit","業務用更新者ＩＤ");

    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testExec_A5() {

        String pKouteiKanriId = "10000000001";
        String pSubSystemId = "001";

        String pJimuTetuzukiCd = "001";
        String pCurrentTaskId = "20150704";
        String pNextTaskId = "20150804";


        setWariateHukaInfo.exec(pKouteiKanriId, pSubSystemId, pJimuTetuzukiCd, pCurrentTaskId, pNextTaskId);

        List<BT_WariateHukaInfo> list = bizDomManager.getAllWariateHukaInfo();

        exNumericEquals(list.size(), 4, "割当不可情報テーブル エンティティ件数");

    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testExec_A6() {

        String pKouteiKanriId = "10000000001";
        String pSubSystemId = "001";

        String pJimuTetuzukiCd = "001";
        String pCurrentTaskId = "20150705";
        String pNextTaskId = "20150805";

        AM_User aMUser = new AM_User();
        aMUser.setUserId("JUnit");
        changeCurrentUser(baseUserInfo, aMUser);

        asKinou.setKinouId("koutei");


        setWariateHukaInfo.exec(pKouteiKanriId, pSubSystemId, pJimuTetuzukiCd, pCurrentTaskId, pNextTaskId);

        bizDomManager.flush();

        List<BT_WariateHukaInfo> list = bizDomManager.getAllWariateHukaInfo();
        exStringEquals(list.get(1).getKouteikanriid(),"10000000001","工程管理ＩＤ");
        exStringEquals(list.get(1).getSubSystemId(),"001","サブシステムＩＤ");

        exStringEquals(list.get(1).getJimutetuzukicd(),"001","事務手続コード");
        exStringEquals(list.get(1).getWrthukatskid(),"007","割当不可タスクID");
        exStringEquals(list.get(1).getUserId(),"JUnit","ユーザーＩＤ");
        exStringEquals(list.get(1).getWrthukakaijyotskid(),"20150705","割当不可解除用タスクID");
        exStringEquals(list.get(1).getGyoumuKousinKinou(),"koutei","業務用更新機能ＩＤ");
        exStringEquals(list.get(1).getGyoumuKousinsyaId(),"JUnit","業務用更新者ＩＤ");

        exStringEquals(list.get(2).getKouteikanriid(),"10000000001","工程管理ＩＤ");
        exStringEquals(list.get(2).getSubSystemId(),"001","サブシステムＩＤ");

        exStringEquals(list.get(2).getJimutetuzukicd(),"001","事務手続コード");
        exStringEquals(list.get(2).getWrthukatskid(),"008","割当不可タスクID");
        exStringEquals(list.get(2).getUserId(),"JUnit","ユーザーＩＤ");
        exStringEquals(list.get(2).getWrthukakaijyotskid(),"20150705","割当不可解除用タスクID");
        exStringEquals(list.get(2).getGyoumuKousinKinou(),"koutei","業務用更新機能ＩＤ");
        exStringEquals(list.get(2).getGyoumuKousinsyaId(),"JUnit","業務用更新者ＩＤ");

        exStringEquals(list.get(3).getKouteikanriid(),"10000000001","工程管理ＩＤ");
        exStringEquals(list.get(3).getSubSystemId(),"001","サブシステムＩＤ");
        exStringEquals(list.get(3).getJimutetuzukicd(),"001","事務手続コード");
        exStringEquals(list.get(3).getWrthukatskid(),"009","割当不可タスクID");
        exStringEquals(list.get(3).getUserId(),"JUnit","ユーザーＩＤ");
        exStringEquals(list.get(3).getWrthukakaijyotskid(),"20150705","割当不可解除用タスクID");
        exStringEquals(list.get(3).getGyoumuKousinKinou(),"koutei","業務用更新機能ＩＤ");
        exStringEquals(list.get(3).getGyoumuKousinsyaId(),"JUnit","業務用更新者ＩＤ");
        exNumericEquals(list.size(), 4, "割当不可情報テーブル エンティティ件数");

    }
}
