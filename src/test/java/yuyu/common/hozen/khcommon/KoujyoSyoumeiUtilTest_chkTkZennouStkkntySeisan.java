package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateYM;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 控除証明ユーティリティクラスのメソッド {@link KoujyoSyoumeiUtil#chkTkZennouStkkntySeisan(IT_KykKihon, BizDateYM, BizDateYM)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class KoujyoSyoumeiUtilTest_chkTkZennouStkkntySeisan {

    @Inject
    private KoujyoSyoumeiUtil koujyoSyoumeiUtil;

    @Inject
    private HozenDomManager hozenDomManager;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_控除証明ユーティリティ";
    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(KoujyoSyoumeiUtilTest_chkTkZennouStkkntySeisan.class, fileName, sheetName);

            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());

    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void testChkTkZennouStkkntySeisan_A1() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000013");
        BizDateYM syoumeistartYm = BizDateYM.valueOf(201808);
        BizDateYM syoumeiendYm = BizDateYM.valueOf(201810);
        Integer kihrkpSeisanRenno = 11;
        BizDateYM kihrkpSeisanJytYm = BizDateYM.valueOf(201901);
        String keisanhukariyuuCd = koujyoSyoumeiUtil.chkTkZennouStkkntySeisan(kykKihon, syoumeistartYm, syoumeiendYm,
            kihrkpSeisanRenno, kihrkpSeisanJytYm);

        exStringEquals(keisanhukariyuuCd, "", "計算不可理由コード");
    }

    @Test
    @TestOrder(20)
    public void testChkTkZennouStkkntySeisan_A2(){
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000024");
        BizDateYM syoumeistartYm = BizDateYM.valueOf(201808);
        BizDateYM syoumeiendYm = BizDateYM.valueOf(201810);
        Integer kihrkpSeisanRenno = 11;
        BizDateYM kihrkpSeisanJytYm = BizDateYM.valueOf(201901);
        String keisanhukariyuuCd = koujyoSyoumeiUtil.chkTkZennouStkkntySeisan(kykKihon, syoumeistartYm, syoumeiendYm,
            kihrkpSeisanRenno, kihrkpSeisanJytYm);

        exStringEquals(keisanhukariyuuCd, KeisanKoujyogakuConstants.KEISANHUKARIYUUCD_TKBRIZENHUKUSUUKAISEISAN,
            "計算不可理由コード");
    }

    @Test
    @TestOrder(30)
    public void testChkTkZennouStkkntySeisan_A3(){
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000035");
        BizDateYM syoumeistartYm = BizDateYM.valueOf(201809);
        BizDateYM syoumeiendYm = BizDateYM.valueOf(201809);
        Integer kihrkpSeisanRenno = 11;
        BizDateYM kihrkpSeisanJytYm = BizDateYM.valueOf(201901);
        String keisanhukariyuuCd = koujyoSyoumeiUtil.chkTkZennouStkkntySeisan(kykKihon, syoumeistartYm, syoumeiendYm,
            kihrkpSeisanRenno, kihrkpSeisanJytYm);

        exStringEquals(keisanhukariyuuCd, KeisanKoujyogakuConstants.KEISANHUKARIYUUCD_TKBRIZENHUKUSUUKAISEISAN,
            "計算不可理由コード");
    }

    @Test
    @TestOrder(40)
    public void testChkTkZennouStkkntySeisan_A4(){
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000046");
        BizDateYM syoumeistartYm = BizDateYM.valueOf(201808);
        BizDateYM syoumeiendYm = BizDateYM.valueOf(201810);
        Integer kihrkpSeisanRenno = 11;
        BizDateYM kihrkpSeisanJytYm = BizDateYM.valueOf(201901);
        String keisanhukariyuuCd = koujyoSyoumeiUtil.chkTkZennouStkkntySeisan(kykKihon, syoumeistartYm, syoumeiendYm,
            kihrkpSeisanRenno, kihrkpSeisanJytYm);

        exStringEquals(keisanhukariyuuCd, KeisanKoujyogakuConstants.KEISANHUKARIYUUCD_TKBRIZENHUKUSUUKAISEISAN,
            "計算不可理由コード");
    }

    @Test
    @TestOrder(50)
    public void testChkTkZennouStkkntySeisan_A5 (){
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000057");
        BizDateYM syoumeistartYm = BizDateYM.valueOf(201808);
        BizDateYM syoumeiendYm = BizDateYM.valueOf(201810);
        Integer kihrkpSeisanRenno = 11;
        BizDateYM kihrkpSeisanJytYm = BizDateYM.valueOf(201901);
        String keisanhukariyuuCd = koujyoSyoumeiUtil.chkTkZennouStkkntySeisan(kykKihon, syoumeistartYm, syoumeiendYm,
            kihrkpSeisanRenno, kihrkpSeisanJytYm);

        exStringEquals(keisanhukariyuuCd, KeisanKoujyogakuConstants.KEISANHUKARIYUUCD_TKBRIZENHUKUSUUKAISEISAN,
            "計算不可理由コード");
    }
}
