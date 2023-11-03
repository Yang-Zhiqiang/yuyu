package yuyu.common.direct.dscommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.classification.C_YuukshantkekKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保全契約異動状態取得のメソッド{@link HozenKeiyakuIdouJyoutaiSyutoku#keiyakuJyoutaiYuukouseiHantei(String)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class HozenKeiyakuIdouJyoutaiSyutokuTest_Yuukousei {

    @Inject
    private HozenKeiyakuIdouJyoutaiSyutoku idouJyoutaiSyutoku;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon kykKihon1 = new IT_KykKihon("01", "17806000013");

        IT_KykSyouhn kykSyouhn1 = kykKihon1.createKykSyouhn();
        kykSyouhn1.setSyutkkbn(C_SyutkKbn.valueOf("0"));
        kykSyouhn1.setSyouhncd("0001");
        kykSyouhn1.setSyouhnsdno(10);
        kykSyouhn1.setKyksyouhnrenno(10);
        kykSyouhn1.setYuukousyoumetukbn(C_YuukousyoumetuKbn.valueOf("1"));

        hozenDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("02", "17806000024");

        IT_KykSyouhn kykSyouhn2 = kykKihon2.createKykSyouhn();
        kykSyouhn2.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn2.setSyouhncd("0002");
        kykSyouhn2.setSyouhnsdno(11);
        kykSyouhn2.setKyksyouhnrenno(11);
        kykSyouhn2.setYuukousyoumetukbn(C_YuukousyoumetuKbn.valueOf("1"));

        hozenDomManager.insert(kykKihon2);

        IT_KykKihon kykKihon3 = new IT_KykKihon("03", "17806000035");

        IT_KykSyouhn kykSyouhn3 = kykKihon3.createKykSyouhn();
        kykSyouhn3.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn3.setSyouhncd("0003");
        kykSyouhn3.setSyouhnsdno(12);
        kykSyouhn3.setKyksyouhnrenno(12);
        kykSyouhn3.setYuukousyoumetukbn(C_YuukousyoumetuKbn.valueOf("2"));

        hozenDomManager.insert(kykKihon3);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @TestOrder(10)
    public void testKeiyakuJyoutaiYuukouseiHantei_A1() {
        String pSyoNo = "11111111111";

        C_YuukshantkekKbn yuukshantkekKbn = idouJyoutaiSyutoku.keiyakuJyoutaiYuukouseiHantei(pSyoNo);

        exClassificationEquals(yuukshantkekKbn, C_YuukshantkekKbn.ERROR, "有効性区分");
    }
    @Test
    @TestOrder(20)
    public void testKeiyakuJyoutaiYuukouseiHantei_A2() {
        String pSyoNo = "17806000013";

        C_YuukshantkekKbn yuukshantkekKbn = idouJyoutaiSyutoku.keiyakuJyoutaiYuukouseiHantei(pSyoNo);

        exClassificationEquals(yuukshantkekKbn, C_YuukshantkekKbn.ERROR, "有効性区分");
    }

    @Test
    @TestOrder(30)
    public void testKeiyakuJyoutaiYuukouseiHantei_A3() {
        String pSyoNo = "17806000024";

        C_YuukshantkekKbn yuukshantkekKbn = idouJyoutaiSyutoku.keiyakuJyoutaiYuukouseiHantei(pSyoNo);

        exClassificationEquals(yuukshantkekKbn, C_YuukshantkekKbn.OK, "有効性区分");
    }

    @Test
    @TestOrder(40)
    public void testKeiyakuJyoutaiYuukouseiHantei_A4() {
        String pSyoNo = "17806000035";

        C_YuukshantkekKbn yuukshantkekKbn = idouJyoutaiSyutoku.keiyakuJyoutaiYuukouseiHantei(pSyoNo);

        exClassificationEquals(yuukshantkekKbn, C_YuukshantkekKbn.NG, "有効性区分");
    }
}