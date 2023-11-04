package yuyu.common.hozen.setuibean;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.bizinfr.message.Message;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.web.message.MessageManager;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.hozen.khcommon.KhMessageGroupConstants;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 取扱注意設定のメソッド {@link SetToriatukaiTyuui#exec(KhozenCommonParam,SetToriatukaiTyuuiExecUiBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetToriatukaiTyuuiTest_exec {

    @Inject
    private KhozenCommonParam pKhozenCommonParam;

    @Inject
    private SetToriatukaiTyuui setToriatukaiTyuui;

    @Inject
    private SetToriatukaiTyuuiExecUiBeanImpl setToriatukaiTyuuiExecUiBeanImpl;

    @Inject
    private MessageManager messageManager;

    private final static String sysyNo1 = "17806000013";

    private final static String sysyNo2 = "17806000024";

    private final static String fileName = "UT_SP_単体テスト仕様書_取扱注意設定";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() { try {
        TestDataMaker testDataMaker = new TestDataMaker();
        HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
        testDataAndTblMap = testDataMaker.getInData(SetToriatukaiTyuuiTest_exec.class, fileName, sheetName);
        testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
    } catch (Exception e) {
        e.printStackTrace();
    }}

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        MockObjectManager.initialize();
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void testExec_A1() {

        setToriatukaiTyuuiExecUiBeanImpl.setSyono(sysyNo1);
        boolean result = setToriatukaiTyuui.exec(pKhozenCommonParam,setToriatukaiTyuuiExecUiBeanImpl);
        List<Message> messageManagerLst = messageManager.getConversationMessages();

        exNumericEquals(messageManagerLst.size(),1,"取扱注意メッセージ件数");
        exNumericEquals(messageManagerLst.get(0).getGroup(),100,"グループ");
        exStringEquals(messageManagerLst.get(0).getMessageId(),"KBC0001","取扱注意メッセージID");
        exStringEquals(messageManagerLst.get(0).getMessageArgs()[0].toString(),"取扱注意内容1","取扱注意内容");
        exBooleanEquals(result,true,"処理結果");
        messageManager.removeConversationMessage(KhMessageGroupConstants.GROUP_TORIATUKAITYUUI);

    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testExec_A2() {

        setToriatukaiTyuuiExecUiBeanImpl.setSyono(sysyNo2);
        boolean result = setToriatukaiTyuui.exec(pKhozenCommonParam,setToriatukaiTyuuiExecUiBeanImpl);
        List<Message> messageManagerLst = messageManager.getConversationMessages();

        exNumericEquals(messageManagerLst.size(),0,"取扱注意メッセージ件数");
        exBooleanEquals(result,true,"処理結果");

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testExec_A3() {

        setToriatukaiTyuuiExecUiBeanImpl.setSyono(sysyNo1);
        boolean result = setToriatukaiTyuui.exec(pKhozenCommonParam,setToriatukaiTyuuiExecUiBeanImpl);

        setToriatukaiTyuui.init(setToriatukaiTyuuiExecUiBeanImpl);

        List<Message> messageManagerLst = messageManager.getConversationMessages();

        exNumericEquals(messageManagerLst.size(),0,"取扱注意メッセージ件数");
        exBooleanEquals(result,true,"処理結果");

    }

}
