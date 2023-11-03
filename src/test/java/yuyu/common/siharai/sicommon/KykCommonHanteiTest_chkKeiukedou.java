package yuyu.common.siharai.sicommon;


import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Hkuktsyu;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.entity.JT_SiUkt;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約内容共通判定クラスの契受同一判定メソッド {@link KykCommonHantei#chkKeiukedou(JT_SiKykKihon)}テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class KykCommonHanteiTest_chkKeiukedou {

    @Inject
    private KykCommonHantei kykCommonHantei;

    @Test
    @TestOrder(10)
    public void testChkKeiukedou_A1() {

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSyono("20808000082");
        siKykKihon.setSbuktnin(1);
        List<JT_SiUkt> siUktList = new ArrayList<>();
        JT_SiUkt siUkt = new JT_SiUkt();
        siUkt.setSyono("20808000082");
        siUkt.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt.setUktkbn(C_UktKbn.KYK);
        siUktList.add(siUkt);
        siKykKihon.setSiUkts(siUktList);

        boolean result = kykCommonHantei.chkKeiukedou(siKykKihon);

        exBooleanEquals(result, true, "判定結果フラグ");
    }

    @Test
    @TestOrder(20)
    public void testChkKeiukedou_A2() {

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSyono("20808000093");
        siKykKihon.setSbuktnin(1);
        List<JT_SiUkt> siUktList = new ArrayList<>();
        JT_SiUkt siUkt = new JT_SiUkt();
        siUkt.setSyono("20808000093");
        siUkt.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt.setUktkbn(C_UktKbn.SBUK);
        siUktList.add(siUkt);
        siKykKihon.setSiUkts(siUktList);

        boolean result = kykCommonHantei.chkKeiukedou(siKykKihon);

        exBooleanEquals(result, false, "判定結果フラグ");
    }

    @Test
    @TestOrder(30)
    public void testChkKeiukedou_A3() {

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSyono("20808000104");
        siKykKihon.setSbuktnin(1);
        List<JT_SiUkt> siUktList = new ArrayList<>();
        JT_SiUkt siUkt = new JT_SiUkt();
        siUkt.setSyono("20808000104");
        siUkt.setHkuktsyu(C_Hkuktsyu.SBKYFKUKT);
        siUkt.setUktkbn(C_UktKbn.KYK);
        siUktList.add(siUkt);
        siKykKihon.setSiUkts(siUktList);

        boolean result = kykCommonHantei.chkKeiukedou(siKykKihon);

        exBooleanEquals(result, false, "判定結果フラグ");
    }

    @Test
    @TestOrder(40)
    public void testChkKeiukedou_A4() {

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSyono("20808000115");
        siKykKihon.setSbuktnin(1);
        List<JT_SiUkt> siUktList = new ArrayList<>();
        JT_SiUkt siUkt = new JT_SiUkt();
        siUkt.setSyono("20808000115");
        siUkt.setHkuktsyu(C_Hkuktsyu.SBKYFKUKT);
        siUkt.setUktkbn(C_UktKbn.SBUK);
        siUktList.add(siUkt);
        siKykKihon.setSiUkts(siUktList);

        boolean result = kykCommonHantei.chkKeiukedou(siKykKihon);

        exBooleanEquals(result, false, "判定結果フラグ");
    }

    @Test
    @TestOrder(50)
    public void testChkKeiukedou_A5() {

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSyono("20808000126");
        siKykKihon.setSbuktnin(2);
        List<JT_SiUkt> siUktList = new ArrayList<>();
        JT_SiUkt siUkt = new JT_SiUkt();
        siUkt.setSyono("20808000126");
        siUkt.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt.setUktkbn(C_UktKbn.KYK);
        siUktList.add(siUkt);
        siKykKihon.setSiUkts(siUktList);
        List<JT_SiUkt> siUktList1 = new ArrayList<>();
        JT_SiUkt siUkt1 = new JT_SiUkt();
        siUkt1.setSyono("20808000126");
        siUkt1.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt1.setUktkbn(C_UktKbn.SBUK);
        siUktList1.add(siUkt1);
        siKykKihon.setSiUkts(siUktList1);

        boolean result = kykCommonHantei.chkKeiukedou(siKykKihon);

        exBooleanEquals(result, false, "判定結果フラグ");
    }

}
