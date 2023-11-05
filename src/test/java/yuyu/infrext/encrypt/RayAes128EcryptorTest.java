package yuyu.infrext.encrypt;

import static org.junit.Assert.*;
import static yuyu.def.YuyuStandardCharsets.*;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;

@RunWith(SWAKTestRunner.class)
public class RayAes128EcryptorTest {

    @Inject
    Logger logger;

    @Test
    public void testEncrypt(){
        RayAes128Ecryptor encriptor = SWAKInjector.getInstance(RayAes128Ecryptor.class);
        String testData = new String("yuyuseiho-s");
        byte[] encriptedBinary = encriptor.encrypt(testData.getBytes(SHIFT_JIS));

        String encriptedData = new String(encriptedBinary, SHIFT_JIS);
        logger.debug("暗号化文字列：{}",encriptedData);

        String decriptedData = new String (encriptor.decrypt(encriptedBinary), SHIFT_JIS);

        assertEquals(testData,decriptedData);
    }
}
