package yuyu.infrext.encrypt;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.infr.report.EncryptKeyGenerator;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 業務共通　暗号キー生成クラスのメソッド {@link EncryptKeyGenerator#gerenateKey()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EncryptKeyGeneratorTest_gerenateKey {

    @Test
    @TestOrder(10)
    public void testgerenateKey_A1() {

        String value = SWAKInjector.getInstance(EncryptKeyGenerator.class).gerenateKey();
        exStringEquals(value, "UDY3eWV4MlVackxtODR4Vg==", "暗号キー");

    }

    @Test(expected = RuntimeException.class)
    @TestOrder(20)
    public void testgerenateKey_A2() {

        String value = SWAKInjector.getInstance(EncryptKeyGenerator.class).gerenateKey();

    }
}