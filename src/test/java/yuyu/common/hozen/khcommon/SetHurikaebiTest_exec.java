package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 口座振替日設定処理のメソッド{@link SetHurikaebi#exec(BizDate)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetHurikaebiTest_exec {

    @Test
    @TestOrder(10)
    @Transactional
    public void testExec_A1() {

        SetHurikaebi setHurikaebi = SWAKInjector.getInstance(SetHurikaebi.class);

        setHurikaebi.exec(BizDate.valueOf("20181016"));

        exDateEquals(setHurikaebi.getTyokuzenHurikaebi(), BizDate.valueOf("20180927"), "前月振替日");

        exDateEquals(setHurikaebi.getTyokugoHurikaebi(), BizDate.valueOf("20181029"), "当月振替日");

        exDateEquals(setHurikaebi.getTyokuzenAnnaibi(), BizDate.valueOf("20180912"), "前月案内日");

        exDateEquals(setHurikaebi.getTyokugoAnnaibi(), BizDate.valueOf("20181016"), "当月案内日");
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testExec_A2() {

        SetHurikaebi setHurikaebi = SWAKInjector.getInstance(SetHurikaebi.class);

        setHurikaebi.exec(BizDate.valueOf("20181015"));

        exDateEquals(setHurikaebi.getTyokuzenHurikaebi(), BizDate.valueOf("20180927"), "前月振替日");

        exDateEquals(setHurikaebi.getTyokugoHurikaebi(), BizDate.valueOf("20181029"), "当月振替日");

        exDateEquals(setHurikaebi.getTyokuzenAnnaibi(), BizDate.valueOf("20180912"), "前月案内日");

        exDateEquals(setHurikaebi.getTyokugoAnnaibi(), BizDate.valueOf("20181016"), "当月案内日");
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testExec_A3() {

        SetHurikaebi setHurikaebi = SWAKInjector.getInstance(SetHurikaebi.class);

        setHurikaebi.exec(BizDate.valueOf("20181029"));

        exDateEquals(setHurikaebi.getTyokuzenHurikaebi(), BizDate.valueOf("20180927"), "前月振替日");

        exDateEquals(setHurikaebi.getTyokugoHurikaebi(), BizDate.valueOf("20181029"), "当月振替日");

        exDateEquals(setHurikaebi.getTyokuzenAnnaibi(), BizDate.valueOf("20181016"), "当月案内日");

        exDateEquals(setHurikaebi.getTyokugoAnnaibi(), BizDate.valueOf("20181113"), "翌月案内日");
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testExec_A4() {

        SetHurikaebi setHurikaebi = SWAKInjector.getInstance(SetHurikaebi.class);

        setHurikaebi.exec(BizDate.valueOf("20181030"));

        exDateEquals(setHurikaebi.getTyokuzenHurikaebi(), BizDate.valueOf("20181029"), "当月振替日");

        exDateEquals(setHurikaebi.getTyokugoHurikaebi(), BizDate.valueOf("20181127"), "翌月振替日");

        exDateEquals(setHurikaebi.getTyokuzenAnnaibi(), BizDate.valueOf("20181016"), "当月案内日");

        exDateEquals(setHurikaebi.getTyokugoAnnaibi(), BizDate.valueOf("20181113"), "翌月案内日");
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testExec_A5() {

        SetHurikaebi setHurikaebi = SWAKInjector.getInstance(SetHurikaebi.class);

        setHurikaebi.exec(BizDate.valueOf("20181113"));

        exDateEquals(setHurikaebi.getTyokuzenHurikaebi(), BizDate.valueOf("20181029"), "前月振替日");

        exDateEquals(setHurikaebi.getTyokugoHurikaebi(), BizDate.valueOf("20181127"), "当月振替日");

        exDateEquals(setHurikaebi.getTyokuzenAnnaibi(), BizDate.valueOf("20181016"), "前月案内日");

        exDateEquals(setHurikaebi.getTyokugoAnnaibi(), BizDate.valueOf("20181113"), "当月案内日");
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testExec_A6() {

        SetHurikaebi setHurikaebi = SWAKInjector.getInstance(SetHurikaebi.class);

        setHurikaebi.exec(BizDate.valueOf("20181112"));

        exDateEquals(setHurikaebi.getTyokuzenHurikaebi(), BizDate.valueOf("20181029"), "前月振替日");

        exDateEquals(setHurikaebi.getTyokugoHurikaebi(), BizDate.valueOf("20181127"), "当月振替日");

        exDateEquals(setHurikaebi.getTyokuzenAnnaibi(), BizDate.valueOf("20181016"), "前月案内日");

        exDateEquals(setHurikaebi.getTyokugoAnnaibi(), BizDate.valueOf("20181113"), "当月案内日");
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testExec_A7() {

        SetHurikaebi setHurikaebi = SWAKInjector.getInstance(SetHurikaebi.class);

        setHurikaebi.exec(BizDate.valueOf("20181127"));

        exDateEquals(setHurikaebi.getTyokuzenHurikaebi(), BizDate.valueOf("20181029"), "前月振替日");

        exDateEquals(setHurikaebi.getTyokugoHurikaebi(), BizDate.valueOf("20181127"), "当月振替日");

        exDateEquals(setHurikaebi.getTyokuzenAnnaibi(), BizDate.valueOf("20181113"), "当月案内日");

        exDateEquals(setHurikaebi.getTyokugoAnnaibi(), BizDate.valueOf("20181213"), "翌月案内日");
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testExec_A8() {

        SetHurikaebi setHurikaebi = SWAKInjector.getInstance(SetHurikaebi.class);

        setHurikaebi.exec(BizDate.valueOf("20181128"));

        exDateEquals(setHurikaebi.getTyokuzenHurikaebi(), BizDate.valueOf("20181127"), "当月振替日");

        exDateEquals(setHurikaebi.getTyokugoHurikaebi(), BizDate.valueOf("20181227"), "翌月振替日");

        exDateEquals(setHurikaebi.getTyokuzenAnnaibi(), BizDate.valueOf("20181113"), "当月案内日");

        exDateEquals(setHurikaebi.getTyokugoAnnaibi(), BizDate.valueOf("20181213"), "翌月案内日");
    }
}