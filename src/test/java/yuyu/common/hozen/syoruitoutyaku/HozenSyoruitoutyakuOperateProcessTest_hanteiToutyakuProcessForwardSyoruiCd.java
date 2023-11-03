package yuyu.common.hozen.syoruitoutyaku;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全書類到着時工程操作処理クラスのメソッド {@link HozenSyoruitoutyakuOperateProcess#hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class HozenSyoruitoutyakuOperateProcessTest_hanteiToutyakuProcessForwardSyoruiCd {

    @Test
    @TestOrder(10)
    public void testhanteiToutyakuProcessForwardSyoruiCd_A1() {

        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess =  SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        boolean flg = hozenSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.KK_SYOSAIHK_SKS);

        exBooleanEquals(flg,true,"判定結果");

        exStringEquals(hozenSyoruitoutyakuOperateProcess.getSyoruitoutyakuNodeId(),"state-syoruitoutyaku","書類到着ノードID");
    }

    @Test
    @TestOrder(20)
    public void testhanteiToutyakuProcessForwardSyoruiCd_A2() {

        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess =  SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        boolean flg = hozenSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.KK_MEIGIHNK_SKS);

        exBooleanEquals(flg,true,"判定結果");

        exStringEquals(hozenSyoruitoutyakuOperateProcess.getSyoruitoutyakuNodeId(),"state-syoruitoutyaku","書類到着ノードID");
    }

    @Test
    @TestOrder(30)
    public void testhanteiToutyakuProcessForwardSyoruiCd_A3() {

        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess =  SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        boolean flg = hozenSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.KK_SEINENGAPPISEI_SKS);

        exBooleanEquals(flg,true,"判定結果");

        exStringEquals(hozenSyoruitoutyakuOperateProcess.getSyoruitoutyakuNodeId(),"state-syoruitoutyaku","書類到着ノードID");
    }

    @Test
    @TestOrder(40)
    public void testhanteiToutyakuProcessForwardSyoruiCd_A4() {

        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess =  SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        boolean flg = hozenSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.KK_GENGAKU_SKS);

        exBooleanEquals(flg,true,"判定結果");

        exStringEquals(hozenSyoruitoutyakuOperateProcess.getSyoruitoutyakuNodeId(),"state-syoruitoutyaku","書類到着ノードID");
    }

    @Test
    @TestOrder(50)
    public void testhanteiToutyakuProcessForwardSyoruiCd_A5() {

        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess =  SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        boolean flg = hozenSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.KK_KAIYAKU_SKS);

        exBooleanEquals(flg,true,"判定結果");

        exStringEquals(hozenSyoruitoutyakuOperateProcess.getSyoruitoutyakuNodeId(),"state-syoruitoutyaku","書類到着ノードID");
    }

    @Test
    @TestOrder(60)
    public void testhanteiToutyakuProcessForwardSyoruiCd_A6() {

        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess =  SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        boolean flg = hozenSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.KK_HRIHEN_SKS);

        exBooleanEquals(flg,false,"判定結果");

        exStringEquals(hozenSyoruitoutyakuOperateProcess.getSyoruitoutyakuNodeId(),"","書類到着ノードID");
    }

    @Test
    @TestOrder(70)
    public void testhanteiToutyakuProcessForwardSyoruiCd_A7() {

        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess =  SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        boolean flg = hozenSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.KK_HRIKAIHEN_SKS);

        exBooleanEquals(flg,false,"判定結果");

        exStringEquals(hozenSyoruitoutyakuOperateProcess.getSyoruitoutyakuNodeId(),"","書類到着ノードID");
    }

    @Test
    @TestOrder(80)
    public void testhanteiToutyakuProcessForwardSyoruiCd_A8() {

        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess =  SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        boolean flg = hozenSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.KK_HUKKATU_SKS);

        exBooleanEquals(flg,false,"判定結果");

        exStringEquals(hozenSyoruitoutyakuOperateProcess.getSyoruitoutyakuNodeId(),"","書類到着ノードID");
    }

    @Test
    @TestOrder(90)
    public void testhanteiToutyakuProcessForwardSyoruiCd_A9() {

        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess =  SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        boolean flg = hozenSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.KK_ADRHNK_SKS);

        exBooleanEquals(flg,true,"判定結果");

        exStringEquals(hozenSyoruitoutyakuOperateProcess.getSyoruitoutyakuNodeId(),"state-syoruitoutyaku","書類到着ノードID");
    }

    @Test
    @TestOrder(110)
    public void testhanteiToutyakuProcessForwardSyoruiCd_A11() {

        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess =  SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        boolean flg = hozenSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.KK_KAIJYO_SKS);

        exBooleanEquals(flg,false,"判定結果");

        exStringEquals(hozenSyoruitoutyakuOperateProcess.getSyoruitoutyakuNodeId(),"","書類到着ノードID");
    }

    @Test
    @TestOrder(120)
    public void testhanteiToutyakuProcessForwardSyoruiCd_A12() {

        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess =  SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        boolean flg = hozenSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.KK_SBKAIJYO_SKS);

        exBooleanEquals(flg,false,"判定結果");

        exStringEquals(hozenSyoruitoutyakuOperateProcess.getSyoruitoutyakuNodeId(),"","書類到着ノードID");
    }

    @Test
    @TestOrder(130)
    public void testhanteiToutyakuProcessForwardSyoruiCd_A13() {

        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess =  SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        boolean flg = hozenSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.KK_SBMENSEKI_SKS);

        exBooleanEquals(flg,false,"判定結果");

        exStringEquals(hozenSyoruitoutyakuOperateProcess.getSyoruitoutyakuNodeId(),"","書類到着ノードID");
    }

    @Test
    @TestOrder(140)
    public void testhanteiToutyakuProcessForwardSyoruiCd_A14() {

        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess =  SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        boolean flg = hozenSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.KK_GANMUKOU_SKS);

        exBooleanEquals(flg,false,"判定結果");

        exStringEquals(hozenSyoruitoutyakuOperateProcess.getSyoruitoutyakuNodeId(),"","書類到着ノードID");
    }

    @Test
    @TestOrder(150)
    public void testhanteiToutyakuProcessForwardSyoruiCd_A15() {

        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess =  SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        boolean flg = hozenSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.KK_MOUSIDEMUKOU_SKS);

        exBooleanEquals(flg,false,"判定結果");

        exStringEquals(hozenSyoruitoutyakuOperateProcess.getSyoruitoutyakuNodeId(),"","書類到着ノードID");
    }

    @Test
    @TestOrder(160)
    public void testhanteiToutyakuProcessForwardSyoruiCd_A16() {

        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess =  SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        boolean flg = hozenSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.KK_STDRHNK_SKS);

        exBooleanEquals(flg,true,"判定結果");

        exStringEquals(hozenSyoruitoutyakuOperateProcess.getSyoruitoutyakuNodeId(),"state-syoruitoutyaku","書類到着ノードID");
    }

    @Test
    @TestOrder(170)
    public void testhanteiToutyakuProcessForwardSyoruiCd_A17() {

        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess =  SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        boolean flg = hozenSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.KK_NKTKYKHNK_SKS);

        exBooleanEquals(flg,false,"判定結果");

        exStringEquals(hozenSyoruitoutyakuOperateProcess.getSyoruitoutyakuNodeId(),"","書類到着ノードID");
    }

    @Test
    @TestOrder(180)
    public void testhanteiToutyakuProcessForwardSyoruiCd_A18() {

        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess =  SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        boolean flg = hozenSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.KK_TARGETHNK_SKS);

        exBooleanEquals(flg,false,"判定結果");

        exStringEquals(hozenSyoruitoutyakuOperateProcess.getSyoruitoutyakuNodeId(),"","書類到着ノードID");
    }

    @Test
    @TestOrder(190)
    public void testhanteiToutyakuProcessForwardSyoruiCd_A19() {

        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess =  SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        boolean flg = hozenSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.KK_SHRKZHNK_SKS);

        exBooleanEquals(flg,false,"判定結果");

        exStringEquals(hozenSyoruitoutyakuOperateProcess.getSyoruitoutyakuNodeId(),"","書類到着ノードID");
    }

    @Test
    @TestOrder(200)
    public void testhanteiToutyakuProcessForwardSyoruiCd_A20() {

        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess =  SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        boolean flg = hozenSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.KK_SYOSAIHK_HB);

        exBooleanEquals(flg,true,"判定結果");

        exStringEquals(hozenSyoruitoutyakuOperateProcess.getSyoruitoutyakuNodeId(),"hubikaitoumati","書類到着ノードID");
    }

    @Test
    @TestOrder(210)
    public void testhanteiToutyakuProcessForwardSyoruiCd_A21() {

        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess =  SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        boolean flg = hozenSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.KK_MEIGIHNK_HB);

        exBooleanEquals(flg,true,"判定結果");

        exStringEquals(hozenSyoruitoutyakuOperateProcess.getSyoruitoutyakuNodeId(),"hubikaitoumati","書類到着ノードID");
    }

    @Test
    @TestOrder(220)
    public void testhanteiToutyakuProcessForwardSyoruiCd_A22() {

        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess =  SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        boolean flg = hozenSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.KK_SEINENGAPPISEI_HB);

        exBooleanEquals(flg,true,"判定結果");

        exStringEquals(hozenSyoruitoutyakuOperateProcess.getSyoruitoutyakuNodeId(),"hubikaitoumati","書類到着ノードID");
    }

    @Test
    @TestOrder(230)
    public void testhanteiToutyakuProcessForwardSyoruiCd_A23() {

        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess =  SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        boolean flg = hozenSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.KK_GENGAKU_HB);

        exBooleanEquals(flg,true,"判定結果");

        exStringEquals(hozenSyoruitoutyakuOperateProcess.getSyoruitoutyakuNodeId(),"hubikaitoumati","書類到着ノードID");
    }

    @Test
    @TestOrder(240)
    public void testhanteiToutyakuProcessForwardSyoruiCd_A24() {

        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess =  SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        boolean flg = hozenSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.KK_KAIYAKU_HB);

        exBooleanEquals(flg,true,"判定結果");

        exStringEquals(hozenSyoruitoutyakuOperateProcess.getSyoruitoutyakuNodeId(),"hubikaitoumati","書類到着ノードID");
    }

    @Test
    @TestOrder(270)
    public void testhanteiToutyakuProcessForwardSyoruiCd_A27() {

        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess =  SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        boolean flg = hozenSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.KK_ADRHNK_HB);

        exBooleanEquals(flg,true,"判定結果");

        exStringEquals(hozenSyoruitoutyakuOperateProcess.getSyoruitoutyakuNodeId(),"hubikaitoumati","書類到着ノードID");
    }

    @Test
    @TestOrder(280)
    public void testhanteiToutyakuProcessForwardSyoruiCd_A28() {

        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess =  SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        boolean flg = hozenSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.KK_KYKTORIKESI_HB);

        exBooleanEquals(flg,true,"判定結果");

        exStringEquals(hozenSyoruitoutyakuOperateProcess.getSyoruitoutyakuNodeId(),"hubikaitoumati","書類到着ノードID");
    }

    @Test
    @TestOrder(290)
    public void testhanteiToutyakuProcessForwardSyoruiCd_A29() {

        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess =  SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        boolean flg = hozenSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.KK_CLGOFF_HB);

        exBooleanEquals(flg,true,"判定結果");

        exStringEquals(hozenSyoruitoutyakuOperateProcess.getSyoruitoutyakuNodeId(),"hubikaitoumati","書類到着ノードID");
    }

    @Test
    @TestOrder(300)
    public void testhanteiToutyakuProcessForwardSyoruiCd_A30() {

        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess =  SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        boolean flg = hozenSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.KK_KAIJYO_HB);

        exBooleanEquals(flg,true,"判定結果");

        exStringEquals(hozenSyoruitoutyakuOperateProcess.getSyoruitoutyakuNodeId(),"hubikaitoumati","書類到着ノードID");
    }

    @Test
    @TestOrder(310)
    public void testhanteiToutyakuProcessForwardSyoruiCd_A31() {

        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess =  SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        boolean flg = hozenSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.KK_MUKOU_HB);

        exBooleanEquals(flg,true,"判定結果");

        exStringEquals(hozenSyoruitoutyakuOperateProcess.getSyoruitoutyakuNodeId(),"hubikaitoumati","書類到着ノードID");
    }

    @Test
    @TestOrder(320)
    public void testhanteiToutyakuProcessForwardSyoruiCd_A32() {

        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess =  SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        boolean flg = hozenSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.KK_SBKAIJYO_HB);

        exBooleanEquals(flg,true,"判定結果");

        exStringEquals(hozenSyoruitoutyakuOperateProcess.getSyoruitoutyakuNodeId(),"hubikaitoumati","書類到着ノードID");
    }

    @Test
    @TestOrder(330)
    public void testhanteiToutyakuProcessForwardSyoruiCd_A33() {

        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess =  SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        boolean flg = hozenSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.KK_SBMENSEKI_HB);

        exBooleanEquals(flg,true,"判定結果");

        exStringEquals(hozenSyoruitoutyakuOperateProcess.getSyoruitoutyakuNodeId(),"hubikaitoumati","書類到着ノードID");
    }

    @Test
    @TestOrder(340)
    public void testhanteiToutyakuProcessForwardSyoruiCd_A34() {

        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess =  SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        boolean flg = hozenSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.KK_STDRHNK_HB);

        exBooleanEquals(flg,true,"判定結果");

        exStringEquals(hozenSyoruitoutyakuOperateProcess.getSyoruitoutyakuNodeId(),"hubikaitoumati","書類到着ノードID");
    }

    @Test
    @TestOrder(350)
    public void testhanteiToutyakuProcessForwardSyoruiCd_A35() {

        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess =  SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        boolean flg = hozenSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.KK_NKTKYKHNK_HB);

        exBooleanEquals(flg,false,"判定結果");

        exStringEquals(hozenSyoruitoutyakuOperateProcess.getSyoruitoutyakuNodeId(),"","書類到着ノードID");
    }

    @Test
    @TestOrder(360)
    public void testhanteiToutyakuProcessForwardSyoruiCd_A36() {

        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess =  SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        boolean flg = hozenSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.KK_TARGETHNK_HB);

        exBooleanEquals(flg,false,"判定結果");

        exStringEquals(hozenSyoruitoutyakuOperateProcess.getSyoruitoutyakuNodeId(),"","書類到着ノードID");
    }

    @Test
    @TestOrder(370)
    public void testhanteiToutyakuProcessForwardSyoruiCd_A37() {

        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess =  SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        boolean flg = hozenSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.KK_SHRKZHNK_HB);

        exBooleanEquals(flg,false,"判定結果");

        exStringEquals(hozenSyoruitoutyakuOperateProcess.getSyoruitoutyakuNodeId(),"","書類到着ノードID");
    }

    @Test
    @TestOrder(380)
    public void testhanteiToutyakuProcessForwardSyoruiCd_A38() {

        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess =  SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        boolean flg = hozenSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.BLNK);

        exBooleanEquals(flg,false,"判定結果");

        exStringEquals(hozenSyoruitoutyakuOperateProcess.getSyoruitoutyakuNodeId(),"","書類到着ノードID");

        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(390)
    public void testhanteiToutyakuProcessForwardSyoruiCd_A39() {

        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess =  SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        boolean flg = hozenSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.KK_KAIGOMAETKHNK_SKS);

        exBooleanEquals(flg,true,"判定結果");

        exStringEquals(hozenSyoruitoutyakuOperateProcess.getSyoruitoutyakuNodeId(),"state-syoruitoutyaku","書類到着ノードID");

    }

    @Test
    @TestOrder(400)
    public void testhanteiToutyakuProcessForwardSyoruiCd_A40() {

        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess =  SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        boolean flg = hozenSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.KK_KAIGOMAETKHNK_HB);

        exBooleanEquals(flg,true,"判定結果");

        exStringEquals(hozenSyoruitoutyakuOperateProcess.getSyoruitoutyakuNodeId(),"hubikaitoumati","書類到着ノードID");

    }

    @Test
    @TestOrder(410)
    public void testhanteiToutyakuProcessForwardSyoruiCd_A41() {

        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess =  SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        boolean flg = hozenSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.KK_SBMUKOU_HB);

        exBooleanEquals(flg,true,"判定結果");

        exStringEquals(hozenSyoruitoutyakuOperateProcess.getSyoruitoutyakuNodeId(),"hubikaitoumati","書類到着ノードID");

    }

    @Test
    @TestOrder(420)
    public void testhanteiToutyakuProcessForwardSyoruiCd_A42() {

        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess =  SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        boolean flg = hozenSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.KK_SBMUKOUNOSHR_HB);

        exBooleanEquals(flg,true,"判定結果");

        exStringEquals(hozenSyoruitoutyakuOperateProcess.getSyoruitoutyakuNodeId(),"hubikaitoumati","書類到着ノードID");

    }

    @Test
    @TestOrder(430)
    public void testhanteiToutyakuProcessForwardSyoruiCd_A43() {

        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess =  SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        boolean flg = hozenSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.KK_SBMENSEKINOSHR_HB);

        exBooleanEquals(flg,true,"判定結果");

        exStringEquals(hozenSyoruitoutyakuOperateProcess.getSyoruitoutyakuNodeId(),"hubikaitoumati","書類到着ノードID");

    }

    @Test
    @TestOrder(440)
    public void testhanteiToutyakuProcessForwardSyoruiCd_A44() {

        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess =  SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        boolean flg = hozenSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.KK_MKHGKHNK_SKS);

        exBooleanEquals(flg,true,"判定結果");

        exStringEquals(hozenSyoruitoutyakuOperateProcess.getSyoruitoutyakuNodeId(),"state-syoruitoutyaku","書類到着ノードID");

    }

    @Test
    @TestOrder(450)
    public void testhanteiToutyakuProcessForwardSyoruiCd_A45() {

        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess =  SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        boolean flg = hozenSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.KK_MKHGKHNK_HB);

        exBooleanEquals(flg,true,"判定結果");

        exStringEquals(hozenSyoruitoutyakuOperateProcess.getSyoruitoutyakuNodeId(),"hubikaitoumati","書類到着ノードID");

    }

    @Test
    @TestOrder(460)
    public void testhanteiToutyakuProcessForwardSyoruiCd_A46() {

        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess =  SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        boolean flg = hozenSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_SKS);

        exBooleanEquals(flg,true,"判定結果");

        exStringEquals(hozenSyoruitoutyakuOperateProcess.getSyoruitoutyakuNodeId(),"state-syoruitoutyaku","書類到着ノードID");

    }

    @Test
    @TestOrder(470)
    public void testhanteiToutyakuProcessForwardSyoruiCd_A47() {

        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess =  SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        boolean flg = hozenSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.KK_TUMITATEKINITEN_SKS);

        exBooleanEquals(flg,true,"判定結果");

        exStringEquals(hozenSyoruitoutyakuOperateProcess.getSyoruitoutyakuNodeId(),"state-syoruitoutyaku","書類到着ノードID");

    }

    @Test
    @TestOrder(480)
    public void testhanteiToutyakuProcessForwardSyoruiCd_A48() {

        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess =  SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        boolean flg = hozenSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_HB);

        exBooleanEquals(flg,true,"判定結果");

        exStringEquals(hozenSyoruitoutyakuOperateProcess.getSyoruitoutyakuNodeId(),"hubikaitoumati","書類到着ノードID");

    }

    @Test
    @TestOrder(490)
    public void testhanteiToutyakuProcessForwardSyoruiCd_A49() {

        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess =  SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        boolean flg = hozenSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.KK_TUMITATEKINITEN_HB);

        exBooleanEquals(flg,true,"判定結果");

        exStringEquals(hozenSyoruitoutyakuOperateProcess.getSyoruitoutyakuNodeId(),"hubikaitoumati","書類到着ノードID");

    }

    @Test
    @TestOrder(500)
    public void testhanteiToutyakuProcessForwardSyoruiCd_A50() {

        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess =  SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        boolean flg = hozenSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.KK_DSHR_SKS);

        exBooleanEquals(flg,true,"判定結果");

        exStringEquals(hozenSyoruitoutyakuOperateProcess.getSyoruitoutyakuNodeId(),"state-syoruitoutyaku","書類到着ノードID");

    }
    @Test
    @TestOrder(510)
    public void testhanteiToutyakuProcessForwardSyoruiCd_A51() {

        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess =  SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        boolean flg = hozenSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.AS_PKZHRIKEIRAI);

        exBooleanEquals(flg,true,"判定結果");

        exStringEquals(hozenSyoruitoutyakuOperateProcess.getSyoruitoutyakuNodeId(),"state-syoruitoutyaku","書類到着ノードID");

    }
    @Test
    @TestOrder(520)
    public void testhanteiToutyakuProcessForwardSyoruiCd_A52() {

        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess =  SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        boolean flg = hozenSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.AS_PHRKKAISUUHENKOUMOS);

        exBooleanEquals(flg,true,"判定結果");

        exStringEquals(hozenSyoruitoutyakuOperateProcess.getSyoruitoutyakuNodeId(),"state-syoruitoutyaku","書類到着ノードID");

    }
    @Test
    @TestOrder(530)
    public void testhanteiToutyakuProcessForwardSyoruiCd_A53() {

        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess =  SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        boolean flg = hozenSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.KK_DSHR_HB);

        exBooleanEquals(flg,true,"判定結果");

        exStringEquals(hozenSyoruitoutyakuOperateProcess.getSyoruitoutyakuNodeId(),"hubikaitoumati","書類到着ノードID");

    }
    @Test
    @TestOrder(540)
    public void testhanteiToutyakuProcessForwardSyoruiCd_A54() {

        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess =  SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        boolean flg = hozenSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.AS_HRHN_HB);

        exBooleanEquals(flg,true,"判定結果");

        exStringEquals(hozenSyoruitoutyakuOperateProcess.getSyoruitoutyakuNodeId(),"hubikaitoumati","書類到着ノードID");

    }
    @Test
    @TestOrder(550)
    public void testhanteiToutyakuProcessForwardSyoruiCd_A55() {

        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess =  SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        boolean flg = hozenSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.KK_YENDTHNK_SKS);

        exBooleanEquals(flg,true,"判定結果");

        exStringEquals(hozenSyoruitoutyakuOperateProcess.getSyoruitoutyakuNodeId(),"state-syoruitoutyaku","書類到着ノードID");

    }
    @Test
    @TestOrder(560)
    public void testhanteiToutyakuProcessForwardSyoruiCd_A56() {

        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess =  SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        boolean flg = hozenSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.KK_YENDTHNK_NINI_HB);

        exBooleanEquals(flg,true,"判定結果");

        exStringEquals(hozenSyoruitoutyakuOperateProcess.getSyoruitoutyakuNodeId(),"hubikaitoumati","書類到着ノードID");

    }
    @Test
    @TestOrder(570)
    public void testhanteiToutyakuProcessForwardSyoruiCd_A57() {

        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess =  SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        boolean flg = hozenSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.AS_CREDITCARDMOS);

        exBooleanEquals(flg,true,"判定結果");

        exStringEquals(hozenSyoruitoutyakuOperateProcess.getSyoruitoutyakuNodeId(),"state-syoruitoutyaku","書類到着ノードID");

    }
    @Test
    @TestOrder(580)
    public void testhanteiToutyakuProcessForwardSyoruiCd_A58() {

        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess =  SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        boolean flg = hozenSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.KK_KZKTRKKYKDRTKYKHNK_SKS);

        exBooleanEquals(flg,true,"判定結果");

        exStringEquals(hozenSyoruitoutyakuOperateProcess.getSyoruitoutyakuNodeId(),"state-syoruitoutyaku","書類到着ノードID");

    }
    @Test
    @TestOrder(590)
    public void testhanteiToutyakuProcessForwardSyoruiCd_A59() {

        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess =  SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        boolean flg = hozenSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.KK_KZKTRK_KYKDRTKYKHNK_HB);

        exBooleanEquals(flg,true,"判定結果");

        exStringEquals(hozenSyoruitoutyakuOperateProcess.getSyoruitoutyakuNodeId(),"hubikaitoumati","書類到着ノードID");

    }
}
