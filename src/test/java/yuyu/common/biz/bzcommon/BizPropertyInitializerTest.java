package yuyu.common.biz.bzcommon;

import static org.junit.Assert.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateMD;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.BizRate;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_KadouTimeSiteiKbn;
import yuyu.def.db.mapping.AbstractExDBEntityForZDB;

/**
 * BizPropertyInitializerテストクラスです<br/>
 */
@RunWith(SWAKTestRunner.class)
public class BizPropertyInitializerTest {

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
    }

    @Test
    public void test001() {
        BizPropertyInitializerTestBean bean = new BizPropertyInitializerTestBean();
        BizPropertyInitializer.initialize(bean);

        exClassificationEquals(bean.getKbn(), C_KadouTimeSiteiKbn.BLNK, "区分");
        exClassificationEquals(bean.getKbnChild(), C_KadouTimeSiteiKbn.BLNK, "区分Child");

        exDateMDEquals(bean.getBizDateMD(), null, "ビズデート(月日)");
        exDateMDEquals(bean.getBizDateMDChild(), null, "ビズデート(月日)Child");

        exDateYEquals(bean.getBizDateY(), null, "ビズデート(年) ");
        exDateYEquals(bean.getBizDateYChild(), null, "ビズデート(年)Child ");

        exDateYMEquals(bean.getBizDateYM(), null, "ビズデート(年月)");
        exDateYMEquals(bean.getBizDateYMChild(), null, "ビズデート(年月)Child");

        exDateEquals(bean.getBizDate(), null, "ビズデート(年月日)");
        exDateEquals(bean.getBizDateChild(), null, "ビズデート(年月日)Child");

        exBizCalcbleEquals(bean.getBizCurrency(), BizCurrency.optional(), "ビズカレンシー");
        exBizCalcbleEquals(bean.getBizCurrencyChild(), BizCurrency.optional(), "ビズカレンシーChild");

        exBizCalcbleEquals(bean.getBizRate(), null, "ビズレート");
        exBizCalcbleEquals(bean.getBizRateChild(), null, "ビズレートChild");

        exBizCalcbleEquals(bean.getBizNumber(), BizNumber.optional(), "ビズナンバー");
        exBizCalcbleEquals(bean.getBizNumberChild(), BizNumber.optional(), "ビズナンバーChild");

        assertEquals("ブーリアン", null, bean.getBool());
        assertEquals("ブーリアンChild", null, bean.getBoolChild());

        assertEquals("バイトリスト", null, bean.getByteList());
        assertEquals("バイトリストChild", null, bean.getByteListChild());

        assertEquals("バイト", null, bean.getByt());
        assertEquals("バイトChild", null, bean.getBytChild());

        exStringEquals(bean.getString(), "", "ストリング");
        exStringEquals(bean.getStringChild(), "", "ストリングChild");

        assertEquals("ロング", null, bean.getLon());
        assertEquals("ロングChild", null, bean.getLonChild());

        assertEquals("整数", null, bean.getInte());
        assertEquals("整数Child", null, bean.getInteChild());

        assertEquals("ダブル", null, bean.getDoubl());
        assertEquals("ダブルChild", null, bean.getDoublChild());
    }

    @Test
    public void test002() {
        BizPropertyInitializerTestBean bean = new BizPropertyInitializerTestBean();
        bean.setKbn(C_KadouTimeSiteiKbn.HYOUJUN);
        bean.setKbnChild(C_KadouTimeSiteiKbn.SITEI);
        bean.setBizDateMD(BizDateMD.valueOf("0910"));
        bean.setBizDateMDChild(BizDateMD.valueOf("0911"));
        bean.setBizDateY(BizDateY.valueOf(2016));
        bean.setBizDateYChild(BizDateY.valueOf(2017));
        bean.setBizDateYM(BizDateYM.valueOf("201709"));
        bean.setBizDateYMChild(BizDateYM.valueOf("201710"));
        bean.setBizDate(BizDate.valueOf("20170910"));
        bean.setBizDateChild(BizDate.valueOf("20170911"));
        bean.setBizCurrency(BizCurrency.optional());
        bean.setBizCurrencyChild(BizCurrency.optional());
        bean.setBizRate(BizRate.valueOf(1.1));
        bean.setBizRateChild(BizRate.valueOf(1.2));
        bean.setBizNumber(BizNumber.optional());
        bean.setBizNumberChild(BizNumber.optional());
        bean.setBool(true);
        bean.setBoolChild(false);
        bean.setByteList(new byte[]{11,22});
        bean.setByteListChild(new byte[]{33,44});
        bean.setByt((byte)1);
        bean.setBytChild((byte)2);
        bean.setString("111");
        bean.setStringChild("222");
        bean.setLon((long)100);
        bean.setLonChild((long)200);
        bean.setInte(333);
        bean.setInteChild(444);
        bean.setDoubl(Double.valueOf("997"));
        bean.setDoublChild(Double.valueOf("998"));
        BizPropertyInitializer.initialize(bean);

        exClassificationEquals(bean.getKbn(), C_KadouTimeSiteiKbn.HYOUJUN, "区分");
        exClassificationEquals(bean.getKbnChild(), C_KadouTimeSiteiKbn.SITEI, "区分Child");

        exDateMDEquals(bean.getBizDateMD(), BizDateMD.valueOf("0910"), "ビズデート(月日)");
        exDateMDEquals(bean.getBizDateMDChild(), BizDateMD.valueOf("0911"), "ビズデート(月日)Child");

        exDateYEquals(bean.getBizDateY(), BizDateY.valueOf(2016), "ビズデート(年) ");
        exDateYEquals(bean.getBizDateYChild(), BizDateY.valueOf(2017), "ビズデート(年)Child ");

        exDateYMEquals(bean.getBizDateYM(), BizDateYM.valueOf("201709"), "ビズデート(年月)");
        exDateYMEquals(bean.getBizDateYMChild(), BizDateYM.valueOf("201710"), "ビズデート(年月)Child");

        exDateEquals(bean.getBizDate(), BizDate.valueOf("20170910"), "ビズデート(年月日)");
        exDateEquals(bean.getBizDateChild(), BizDate.valueOf("20170911"), "ビズデート(年月日)Child");

        exBizCalcbleEquals(bean.getBizCurrency(), BizCurrency.optional(), "ビズカレンシー");
        exBizCalcbleEquals(bean.getBizCurrencyChild(), BizCurrency.optional(), "ビズカレンシーChild");

        exBizCalcbleEquals(bean.getBizRate(), BizRate.valueOf(1.1), "ビズレート");
        exBizCalcbleEquals(bean.getBizRateChild(), BizRate.valueOf(1.2), "ビズレートChild");

        exBizCalcbleEquals(bean.getBizNumber(), BizNumber.optional(), "ビズナンバー");
        exBizCalcbleEquals(bean.getBizNumberChild(), BizNumber.optional(), "ビズナンバーChild");

        assertEquals("ブーリアン", true, bean.getBool());
        assertEquals("ブーリアンChild", false, bean.getBoolChild());

        assertEquals("バイトリスト件数", 2, bean.getByteList().length);
        assertEquals("バイトリストChild件数", 2, bean.getByteListChild().length);

        assertEquals("バイトリスト[0]", 11, bean.getByteList()[0]);
        assertEquals("バイトリストChild[0]", 33, bean.getByteListChild()[0]);

        assertEquals("バイトリスト[1]", 22, bean.getByteList()[1]);
        assertEquals("バイトリストChild[1]", 44, bean.getByteListChild()[1]);

        exNumericEquals(bean.getByt(), (byte)1, "バイト");
        exNumericEquals(bean.getBytChild(), (byte)2, "バイトChild");

        exStringEquals(bean.getString(), "111", "ストリング");
        exStringEquals(bean.getStringChild(), "222", "ストリングChild");

        exNumericEquals(bean.getLon(), 100, "ロング");
        exNumericEquals(bean.getLonChild(), 200, "ロングChild");

        exNumericEquals(bean.getInte(), 333, "整数");
        exNumericEquals(bean.getInteChild(), 444, "整数Child");

        exNumericEquals(bean.getDoubl(), 997, "ダブル");
        exNumericEquals(bean.getDoublChild(), 998, "ダブルChild");

    }

    @Test
    public void test003() {

        BizPropertyInitializerTestEntity entity = BizPropertyInitializer
            .createInitializedEntity(BizPropertyInitializerTestEntity.class);

        exClassificationEquals(entity.getKbn(), C_KadouTimeSiteiKbn.BLNK, "区分");
        exClassificationEquals(entity.getKbnChild(), C_KadouTimeSiteiKbn.BLNK, "区分Child");

        exDateMDEquals(entity.getBizDateMD(), null, "ビズデート(月日)");
        exDateMDEquals(entity.getBizDateMDChild(), null, "ビズデート(月日)Child");

        exDateYEquals(entity.getBizDateY(), null, "ビズデート(年) ");
        exDateYEquals(entity.getBizDateYChild(), null, "ビズデート(年)Child ");

        exDateYMEquals(entity.getBizDateYM(), null, "ビズデート(年月)");
        exDateYMEquals(entity.getBizDateYMChild(), null, "ビズデート(年月)Child");

        exDateEquals(entity.getBizDate(), null, "ビズデート(年月日)");
        exDateEquals(entity.getBizDateChild(), null, "ビズデート(年月日)Child");

        exBizCalcbleEquals(entity.getBizCurrency(), BizCurrency.valueOf(0), "ビズカレンシー");
        exBizCalcbleEquals(entity.getBizCurrencyChild(), BizCurrency.valueOf(0), "ビズカレンシーChild");

        exBizCalcbleEquals(entity.getBizRate(), null, "ビズレート");
        exBizCalcbleEquals(entity.getBizRateChild(), null, "ビズレートChild");

        exBizCalcbleEquals(entity.getBizNumber(), BizNumber.valueOf(0), "ビズナンバー");
        exBizCalcbleEquals(entity.getBizNumberChild(), BizNumber.valueOf(0), "ビズナンバーChild");

        assertEquals("ブーリアン", false, entity.getBool());
        assertEquals("ブーリアンChild", false, entity.getBoolChild());

        assertEquals("バイトリスト", null, entity.getByteList());
        assertEquals("バイトリストChild", null, entity.getByteListChild());

        exNumericEquals(entity.getByt(), (byte)0, "バイト");
        exNumericEquals(entity.getBytChild(), (byte)0, "バイトChild");

        exStringEquals(entity.getString(), "", "ストリング");
        exStringEquals(entity.getStringChild(), "", "ストリングChild");

        exNumericEquals(entity.getLon(), 0, "ロング");
        exNumericEquals(entity.getLonChild(), 0, "ロングChild");

        exNumericEquals(entity.getInte(), 0, "整数");
        exNumericEquals(entity.getInteChild(), 0, "整数Child");

        exNumericEquals(entity.getDoubl(), 0, "ダブル");
        exNumericEquals(entity.getDoublChild(), 0, "ダブルChild");

    }

    @Test
    public void test004() {

        BizPropertyInitializerTestEntity entity1 = new BizPropertyInitializerTestEntity();
        entity1.setKbn(C_KadouTimeSiteiKbn.HYOUJUN);
        entity1.setKbnChild(C_KadouTimeSiteiKbn.SITEI);
        entity1.setBizDateMD(BizDateMD.valueOf("0910"));
        entity1.setBizDateMDChild(BizDateMD.valueOf("0911"));
        entity1.setBizDateY(BizDateY.valueOf(2016));
        entity1.setBizDateYChild(BizDateY.valueOf(2017));
        entity1.setBizDateYM(BizDateYM.valueOf("201709"));
        entity1.setBizDateYMChild(BizDateYM.valueOf("201710"));
        entity1.setBizDate(BizDate.valueOf("20170910"));
        entity1.setBizDateChild(BizDate.valueOf("20170911"));
        entity1.setBizCurrency(BizCurrency.optional());
        entity1.setBizCurrencyChild(BizCurrency.optional());
        entity1.setBizRate(BizRate.valueOf(1.1));
        entity1.setBizRateChild(BizRate.valueOf(1.2));
        entity1.setBizNumber(BizNumber.optional());
        entity1.setBizNumberChild(BizNumber.optional());
        entity1.setBool(true);
        entity1.setBoolChild(true);
        entity1.setByteList(new byte[]{11,22});
        entity1.setByteListChild(new byte[]{33,44});
        entity1.setByt((byte)1);
        entity1.setBytChild((byte)2);
        entity1.setString("111");
        entity1.setStringChild("222");
        entity1.setLon((long)100);
        entity1.setLonChild((long)200);
        entity1.setInte(333);
        entity1.setInteChild(444);
        entity1.setDoubl(Double.valueOf("997"));
        entity1.setDoublChild(Double.valueOf("998"));
        BizPropertyInitializer.initialize(entity1);

        exClassificationEquals(entity1.getKbn(), C_KadouTimeSiteiKbn.HYOUJUN, "区分");
        exClassificationEquals(entity1.getKbnChild(), C_KadouTimeSiteiKbn.SITEI, "区分Child");

        exDateMDEquals(entity1.getBizDateMD(), BizDateMD.valueOf("0910"), "ビズデート(月日)");
        exDateMDEquals(entity1.getBizDateMDChild(), BizDateMD.valueOf("0911"), "ビズデート(月日)Child");

        exDateYEquals(entity1.getBizDateY(), BizDateY.valueOf(2016), "ビズデート(年) ");
        exDateYEquals(entity1.getBizDateYChild(), BizDateY.valueOf(2017), "ビズデート(年)Child ");

        exDateYMEquals(entity1.getBizDateYM(), BizDateYM.valueOf("201709"), "ビズデート(年月)");
        exDateYMEquals(entity1.getBizDateYMChild(), BizDateYM.valueOf("201710"), "ビズデート(年月)Child");

        exDateEquals(entity1.getBizDate(), BizDate.valueOf("20170910"), "ビズデート(年月日)");
        exDateEquals(entity1.getBizDateChild(), BizDate.valueOf("20170911"), "ビズデート(年月日)Child");

        exBizCalcbleEquals(entity1.getBizCurrency(), BizCurrency.valueOf(0), "ビズカレンシー");
        exBizCalcbleEquals(entity1.getBizCurrencyChild(), BizCurrency.valueOf(0), "ビズカレンシーChild");

        exBizCalcbleEquals(entity1.getBizRate(), BizRate.valueOf(1.1), "ビズレート");
        exBizCalcbleEquals(entity1.getBizRateChild(), BizRate.valueOf(1.2), "ビズレートChild");

        exBizCalcbleEquals(entity1.getBizNumber(), BizNumber.valueOf(0), "ビズナンバー");
        exBizCalcbleEquals(entity1.getBizNumberChild(), BizNumber.valueOf(0), "ビズナンバーChild");

        assertEquals("ブーリアン", true, entity1.getBool());
        assertEquals("ブーリアンChild", true, entity1.getBoolChild());

        assertEquals("バイトリスト件数", 2, entity1.getByteList().length);
        assertEquals("バイトリストChild件数", 2, entity1.getByteListChild().length);

        assertEquals("バイトリスト[0]", 11, entity1.getByteList()[0]);
        assertEquals("バイトリストChild[0]", 33, entity1.getByteListChild()[0]);

        assertEquals("バイトリスト[1]", 22, entity1.getByteList()[1]);
        assertEquals("バイトリストChild[1]", 44, entity1.getByteListChild()[1]);

        exNumericEquals(entity1.getByt(), (byte)1, "バイト");
        exNumericEquals(entity1.getBytChild(), (byte)2, "バイトChild");

        exStringEquals(entity1.getString(), "111", "ストリング");
        exStringEquals(entity1.getStringChild(), "222", "ストリングChild");

        exNumericEquals(entity1.getLon(), 100, "ロング");
        exNumericEquals(entity1.getLonChild(), 200, "ロングChild");

        exNumericEquals(entity1.getInte(), 333, "整数");
        exNumericEquals(entity1.getInteChild(), 444, "整数Child");

        exNumericEquals(entity1.getDoubl(), 997, "ダブル");
        exNumericEquals(entity1.getDoublChild(), 998, "ダブルChild");
    }

    @Test(expected = BizAppException.class)
    public void test005() {
        try {
            BizPropertyInitializer
            .createInitializedEntity(null);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage()
                , "UIBean或はエンティティ初期化の時、想定外の異常が発生しました。"
                , "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    public void test006() {
        try {
            AbstractExDBEntityForZDB<?, ?> entity = null;
            BizPropertyInitializer.initialize(entity);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage()
                , "UIBean或はエンティティ初期化の時、想定外の異常が発生しました。"
                , "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    public void test007() {
        try {
            AbstractUiBean bean = null;
            BizPropertyInitializer.initialize(bean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage()
                , "UIBean或はエンティティ初期化の時、想定外の異常が発生しました。"
                , "エラーメッセージ");
            throw e;
        }
    }
}
