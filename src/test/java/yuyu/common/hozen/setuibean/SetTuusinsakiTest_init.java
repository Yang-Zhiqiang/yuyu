package yuyu.common.hozen.setuibean;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 通信先情報設定クラスのメソッド {@link SetTuusinsaki#init(SetTuusinsakiExecUiBeanParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetTuusinsakiTest_init {

    private SetTuusinsakiExecUiBeanParamImpl setTuusinsakiExecUiBeanParamImpl;

    @Test
    @TestOrder(10)
    public void testInit_A1() {
        setTuusinsakiExecUiBeanParamImpl = SWAKInjector.getInstance(SetTuusinsakiExecUiBeanParamImpl.class);

        SetTuusinsaki.init(setTuusinsakiExecUiBeanParamImpl);

        exStringEquals(setTuusinsakiExecUiBeanParamImpl.getVtssktsinyno(), "", "（通信先情報）通信先郵便番号");
        exStringEquals(setTuusinsakiExecUiBeanParamImpl.getVtssktsinadr1kj(), "", "（通信先情報）通信先住所１（漢字）");
        exStringEquals(setTuusinsakiExecUiBeanParamImpl.getVtssktsinadr2kj(), "", "（通信先情報）通信先住所２（漢字）");
        exStringEquals(setTuusinsakiExecUiBeanParamImpl.getVtssktsinadr3kj(), "", "（通信先情報）通信先住所３（漢字）");
        exStringEquals(setTuusinsakiExecUiBeanParamImpl.getVtssktsintelno(), "", "（通信先情報）通信先電話番号");
        exStringEquals(setTuusinsakiExecUiBeanParamImpl.getVtsskdai2tsintelno(), "", "（通信先情報）第２通信先電話番号");
    }

    @Test
    @TestOrder(20)
    public void testInit_A2() {
        setTuusinsakiExecUiBeanParamImpl = SWAKInjector.getInstance(SetTuusinsakiExecUiBeanParamImpl.class);

        setTuusinsakiExecUiBeanParamImpl.setVtssktsinyno("1234567");

        setTuusinsakiExecUiBeanParamImpl.setVtssktsinadr1kj("山田");

        setTuusinsakiExecUiBeanParamImpl.setVtssktsinadr2kj("銀座");

        setTuusinsakiExecUiBeanParamImpl.setVtssktsinadr3kj("新区");
        setTuusinsakiExecUiBeanParamImpl.setVtssktsintelno("055012345678");
        setTuusinsakiExecUiBeanParamImpl.setVtsskdai2tsintelno("055112345678");

        SetTuusinsaki.init(setTuusinsakiExecUiBeanParamImpl);

        exStringEquals(setTuusinsakiExecUiBeanParamImpl.getVtssktsinyno(), "", "（通信先情報）通信先郵便番号");
        exStringEquals(setTuusinsakiExecUiBeanParamImpl.getVtssktsinadr1kj(), "", "（通信先情報）通信先住所１（漢字）");
        exStringEquals(setTuusinsakiExecUiBeanParamImpl.getVtssktsinadr2kj(), "", "（通信先情報）通信先住所２（漢字）");
        exStringEquals(setTuusinsakiExecUiBeanParamImpl.getVtssktsinadr3kj(), "", "（通信先情報）通信先住所３（漢字）");
        exStringEquals(setTuusinsakiExecUiBeanParamImpl.getVtssktsintelno(), "", "（通信先情報）通信先電話番号");
        exStringEquals(setTuusinsakiExecUiBeanParamImpl.getVtsskdai2tsintelno(), "", "（通信先情報）第２通信先電話番号");

        MockObjectManager.initialize();
    }
}
