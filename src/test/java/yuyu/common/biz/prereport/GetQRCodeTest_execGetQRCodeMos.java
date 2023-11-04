package yuyu.common.biz.prereport;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;

/**
 * {@link GetQRCode}クラスに含まれる、{@link GetQRCode#execGetQRCodeMos (String)} メソッドのテストです。
 * <br />
 */
@RunWith(OrderedRunner.class)
public class GetQRCodeTest_execGetQRCodeMos {

    @Test
    public void testExecGetQRCodeMos_A1(){
        GetQRCode.execGetQRCodeMos();
        MockObjectManager.initialize();
    }
}
