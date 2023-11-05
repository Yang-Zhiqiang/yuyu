package yuyu.common.hozen.setuibean;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 定期支払金支払先口座情報設定のメソッド{@link SetKhTkshrSiharaiKouza#init(SetKhTkshrSiharaiKouzaExecUiBeanParam)}
                                   テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetKhTkshrSiharaiKouzaTest_init {

    private SetKhTkshrSiharaiKouzaExecUiBeanParamImpl setKhTkshrSiharaiKouzaExecUiBeanParamImpl;

    @Test
    @TestOrder(10)
    public void testInit_A1() {

        setKhTkshrSiharaiKouzaExecUiBeanParamImpl = SWAKInjector.getInstance(SetKhTkshrSiharaiKouzaExecUiBeanParamImpl.class);

        SetKhTkshrSiharaiKouza.init(setKhTkshrSiharaiKouzaExecUiBeanParamImpl);

        exClassificationEquals(setKhTkshrSiharaiKouzaExecUiBeanParamImpl.getVktikskzkzsyuruikbn(), C_KouzasyuruiKbn.BLNK, "（定期支払金支払先口座情報）口座種類区分");
        exStringEquals(setKhTkshrSiharaiKouzaExecUiBeanParamImpl.getVktikskzbankcd(), "", "（定期支払金支払先口座情報）銀行コード");
        exStringEquals(setKhTkshrSiharaiKouzaExecUiBeanParamImpl.getVktikskzbanknmkj(), "", "（定期支払金支払先口座情報）銀行名（漢字）");
        exStringEquals(setKhTkshrSiharaiKouzaExecUiBeanParamImpl.getVktikskzsitencd(), "", "（定期支払金支払先口座情報）支店コード");
        exStringEquals(setKhTkshrSiharaiKouzaExecUiBeanParamImpl.getVktikskzsitennmkj(), "", "（定期支払金支払先口座情報）支店名（漢字）");
        exClassificationEquals(setKhTkshrSiharaiKouzaExecUiBeanParamImpl.getVktikskzyokinkbn(), C_YokinKbn.BLNK, "（定期支払金支払先口座情報）預金種目区分");
        exStringEquals(setKhTkshrSiharaiKouzaExecUiBeanParamImpl.getVktikskzkouzano(), "", "（定期支払金支払先口座情報）口座番号");
        exStringEquals(setKhTkshrSiharaiKouzaExecUiBeanParamImpl.getVktikskzkzmeiginmkn(), "", "（定期支払金支払先口座情報）口座名義人氏名（カナ）");
        exClassificationEquals(setKhTkshrSiharaiKouzaExecUiBeanParamImpl.getTeikishrtkykhukaumu(), C_UmuKbn.NONE, "定期支払特約付加有無");
    }

}
