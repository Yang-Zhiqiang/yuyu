package yuyu.common.hozen.setuibean;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_HjndaiykKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_Tdk;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;


/**
 *  契約者情報設定のメソッド {@link SetKeiyakusya#init(SetKeiyakusyaExecUiBeanParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetKeiyakusyaTest_init {

    @Inject
    private SetKeiyakusyaExecUiBeanParamImpl setKeiyakusyaExecUiBeanParamImpl;

    @Test
    @TestOrder(10)
    public void testInit_A1() {

        setKeiyakusyaExecUiBeanParamImpl = SWAKInjector.getInstance(SetKeiyakusyaExecUiBeanParamImpl.class);


        SetKeiyakusya.init(setKeiyakusyaExecUiBeanParamImpl);


        exStringEquals(setKeiyakusyaExecUiBeanParamImpl.getVkykskyknmkn(), "", "契約者名（カナ）");

        exStringEquals(setKeiyakusyaExecUiBeanParamImpl.getVkykskyknmkj(), "", "契約者名（漢字）");

        exClassificationEquals(setKeiyakusyaExecUiBeanParamImpl.getVkykskyknmkjkhukakbn(), C_KjkhukaKbn.BLNK, "契約者名漢字化不可区分");
        exDateEquals(setKeiyakusyaExecUiBeanParamImpl.getVkykskykseiymd(), null, "契約者生年月日");
        exClassificationEquals(setKeiyakusyaExecUiBeanParamImpl.getVkykskyksei(), C_Kyksei.BLNK, "契約者性別");
        exClassificationEquals(setKeiyakusyaExecUiBeanParamImpl.getVkykskkkyktdk(), C_Tdk.BLNK, "契約管理契約者続柄");

        exClassificationEquals(setKeiyakusyaExecUiBeanParamImpl.getVkykshjndaiykkbn(), C_HjndaiykKbn.BLNK, "法人代表者役職区分");

        exStringEquals(setKeiyakusyaExecUiBeanParamImpl.getVkykshjndaiyknm(), "", "法人代表者役職名");

        exStringEquals(setKeiyakusyaExecUiBeanParamImpl.getVkykshjndainmkn(), "", "法人代表者名（カナ）");

        exStringEquals(setKeiyakusyaExecUiBeanParamImpl.getVkykshjndainmkj(), "", "法人代表者名（漢字）");
    }

    @Test
    @TestOrder(10)
    public void testInit_A2() {

        setKeiyakusyaExecUiBeanParamImpl = SWAKInjector.getInstance(SetKeiyakusyaExecUiBeanParamImpl.class);


        setKeiyakusyaExecUiBeanParamImpl.setVkykskyknmkn("カナ");

        setKeiyakusyaExecUiBeanParamImpl.setVkykskyknmkj("山田");

        setKeiyakusyaExecUiBeanParamImpl.setVkykskyknmkjkhukakbn(C_KjkhukaKbn.KJKHUKA);
        setKeiyakusyaExecUiBeanParamImpl.setVkykskykseiymd(BizDate.valueOf(20151219));
        setKeiyakusyaExecUiBeanParamImpl.setVkykskyksei(C_Kyksei.HJNKYK);
        setKeiyakusyaExecUiBeanParamImpl.setVkykskkkyktdk(C_Tdk.HGU);

        setKeiyakusyaExecUiBeanParamImpl.setVkykshjndaiykkbn(C_HjndaiykKbn.SYATYOU);

        setKeiyakusyaExecUiBeanParamImpl.setVkykshjndaiyknm("社長");

        setKeiyakusyaExecUiBeanParamImpl.setVkykshjndainmkn("カナ");

        setKeiyakusyaExecUiBeanParamImpl.setVkykshjndainmkj("山田");


        SetKeiyakusya.init(setKeiyakusyaExecUiBeanParamImpl);


        exStringEquals(setKeiyakusyaExecUiBeanParamImpl.getVkykskyknmkn(), "", "契約者名（カナ）");

        exStringEquals(setKeiyakusyaExecUiBeanParamImpl.getVkykskyknmkj(), "", "契約者名（漢字）");

        exClassificationEquals(setKeiyakusyaExecUiBeanParamImpl.getVkykskyknmkjkhukakbn(), C_KjkhukaKbn.BLNK, "契約者名漢字化不可区分");
        exDateEquals(setKeiyakusyaExecUiBeanParamImpl.getVkykskykseiymd(), null, "契約者生年月日");
        exClassificationEquals(setKeiyakusyaExecUiBeanParamImpl.getVkykskyksei(), C_Kyksei.BLNK, "契約者性別");
        exClassificationEquals(setKeiyakusyaExecUiBeanParamImpl.getVkykskkkyktdk(), C_Tdk.BLNK, "契約管理契約者続柄");

        exClassificationEquals(setKeiyakusyaExecUiBeanParamImpl.getVkykshjndaiykkbn(), C_HjndaiykKbn.BLNK, "法人代表者役職区分");

        exStringEquals(setKeiyakusyaExecUiBeanParamImpl.getVkykshjndaiyknm(), "", "法人代表者役職名");

        exStringEquals(setKeiyakusyaExecUiBeanParamImpl.getVkykshjndainmkn(), "", "法人代表者名（カナ）");

        exStringEquals(setKeiyakusyaExecUiBeanParamImpl.getVkykshjndainmkj(), "", "法人代表者名（漢字）");

        MockObjectManager.initialize();
    }
}
