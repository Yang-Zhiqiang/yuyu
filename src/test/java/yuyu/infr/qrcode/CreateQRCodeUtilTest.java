package yuyu.infr.qrcode;

import static org.junit.Assert.*;

import java.util.Map;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * QRコード生成テスト用クラス
 */
@RunWith(OrderedRunner.class)
public class CreateQRCodeUtilTest extends AbstractTest {

    @Inject
    private CreateQRCode createQRCode;

    CreateQRCodeTestData testData = new CreateQRCodeTestData();

    //private static Logger logger = LoggerFactory.getLogger(CreateQRCodeUtil.class);

    @Test
    @TestOrder(10)
    public void testCreateReport_OK10() {
        try {

            Map<String, Object> optionsMap = testData.setDataTest10();

            byte[] qrBytes = createQRCode.getQRCodeImgBytes(optionsMap);

            System.out.println(qrBytes.toString());

        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);

    }

    @Test
    @TestOrder(11)
    public void testCreateReport_OK11() {
        try {

            Map<String, Object> optionsMap = testData.setDataTest10();

            byte[] qrBytes = createQRCode.getQRCodeImgBytes(optionsMap);

            createQRCode.createQRCodeImg(qrBytes);

        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);

    }

    @Test
    @TestOrder(12)
    public void testCreateReport_OK12() {
        try {

            Map<String, Object> optionsMap = testData.setDataTest11();

            byte[] qrBytes = createQRCode.getQRCodeImgBytes(optionsMap);

            CreateQRCode createQRCode2 = new CreateQRCode();
            createQRCode2.createQRCodeImg(qrBytes);

            System.out.println(qrBytes.toString());

        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);

    }

    @Test
    @TestOrder(13)
    public void testCreateReport_OK13(){
        try {

            Map<String, Object> optionsMap = testData.setDataTest13();

            byte[] qrBytes = createQRCode.getQRCodeImgBytes(optionsMap);

            createQRCode.createQRCodeImg(qrBytes,optionsMap);

            System.out.println(qrBytes.toString());

        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);

    }

    @Test
    @TestOrder(14)
    public void testCreateReport_OK14() {
        try {

            Map<String, Object> optionsMap = testData.setDataTest10();

            byte[] qrBytes = createQRCode.getQRCodeImgBytes("YuyuQrCodeString");

            createQRCode.createQRCodeImg(qrBytes,optionsMap);

        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);

    }

    @Test
    @TestOrder(15)
    public void testCreateReport_OK15() {
        try {

            Map<String, Object> optionsMap = testData.setDataTest15();

            byte[] qrBytes = createQRCode.getQRCodeImgBytes(optionsMap);

            createQRCode.createQRCodeImg(qrBytes,optionsMap);

        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);

    }

    @Test
    @TestOrder(16)
    public void testCreateReport_OK16() {
        try {

            Map<String, Object> optionsMap = testData.setDataTest16();

            byte[] qrBytes = createQRCode.getQRCodeImgBytes(optionsMap);

            createQRCode.createQRCodeImg(qrBytes,optionsMap);

        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);

    }


    @Test
    @TestOrder(20)
    public void testCreateReport_ERROR20() {
        try {

            Map<String, Object> optionsMap = testData.setDataTest20();

            createQRCode.getQRCodeImgBytes(optionsMap);

        } catch (QRCodeCreateException e) {
            assertTrue(true);
            return;
        }
        assertTrue(false);

    }

    @Test
    @TestOrder(21)
    public void testCreateReport_ERROR21() {
        try {

            Map<String, Object> optionsMap = testData.setDataTest21();

            createQRCode.getQRCodeImgBytes(optionsMap);

        } catch (QRCodeCreateException e) {
            assertTrue(true);
            return;
        }
        assertTrue(false);

    }

    @Test
    @TestOrder(22)
    public void testCreateReport_ERROR22() {
        try {

            Map<String, Object> optionsMap = testData.setDataTest22();

            createQRCode.getQRCodeImgBytes(optionsMap);

        } catch (QRCodeCreateException e) {
            assertTrue(true);
            return;
        }
        assertTrue(false);

    }

    @Test
    @TestOrder(23)
    public void testCreateReport_ERROR23() {
        try {

            Map<String, Object> optionsMap = testData.setDataTest23();

            createQRCode.getQRCodeImgBytes(optionsMap);

        } catch (QRCodeCreateException e) {
            assertTrue(true);
            return;
        }
        assertTrue(false);

    }

    @Test
    @TestOrder(24)
    public void testCreateReport_ERROR24() {
        try {

            createQRCode.createQRCodeImg(testData.setDataTest24());

        } catch (QRCodeCreateException e) {
            assertTrue(true);
            return;
        }
        assertTrue(false);

    }

    @Test
    @TestOrder(25)
    public void testCreateReport_ERROR25() {
        try {

            Map<String, Object> optionsMap = testData.setDataTest25();

            createQRCode.getQRCodeImgBytes(optionsMap);

        } catch (QRCodeCreateException e) {
            assertTrue(true);
            return;
        }
        assertTrue(false);

    }
}