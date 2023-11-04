package yuyu.common.suuri.srcommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_HaitoukinsksKbn;
import yuyu.def.classification.C_HaitoumeisaiKbn;
import yuyu.def.db.entity.IT_KhHaitouKanri;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 特定時点配当管理テーブル取得のメソッド {@link SrGetTokutejitenKhHaitouKanri#exec(List<IT_KhHaitouKanri>, BizDate )}
 * テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class SrGetTokutejitenKhHaitouKanriTest_exec {

    @Inject
    SrGetTokutejitenKhHaitouKanri srGetTokutejitenKhHaitouKanri;

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        BizDate kijyunYmd = BizDate.valueOf("20191216");

        List<IT_KhHaitouKanri> khHaitouKanriList = new ArrayList<>();

        IT_KhHaitouKanri khHaitouKanri1 = srGetTokutejitenKhHaitouKanri.exec(khHaitouKanriList, kijyunYmd);

        assertNull("配当管理テーブルエンティティ", khHaitouKanri1);
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        BizDate kijyunYmd = BizDate.valueOf("20191216");

        List<IT_KhHaitouKanri> khHaitouKanriList = new ArrayList<>();

        IT_KhHaitouKanri khHaitouKanri = new IT_KhHaitouKanri();

        khHaitouKanri.setKbnkey("01");
        khHaitouKanri.setSyono("17806000013");
        khHaitouKanri.setHaitounendo(BizDateY.valueOf("2019"));
        khHaitouKanri.setRenno(1);
        khHaitouKanri.setHaitoukinskskbn(C_HaitoukinsksKbn.KARIWARIATE1);
        khHaitouKanri.setHaitoumeisaikbn(C_HaitoumeisaiKbn.SYU);
        khHaitouKanri.setKariwariatedshrymd(BizDate.valueOf("20191215"));

        khHaitouKanriList.add(khHaitouKanri);

        IT_KhHaitouKanri khHaitouKanri1 = srGetTokutejitenKhHaitouKanri.exec(khHaitouKanriList, kijyunYmd);

        exStringEquals(khHaitouKanri1.getKbnkey(), "01", "区分キー");
        exStringEquals(khHaitouKanri1.getSyono(), "17806000013", "証券番号");
        exDateYEquals(khHaitouKanri1.getHaitounendo(), BizDateY.valueOf("2019"), "配当年度");
        exNumericEquals(khHaitouKanri1.getRenno(), 1, "連番");
        exClassificationEquals(khHaitouKanri1.getHaitoukinskskbn(), C_HaitoukinsksKbn.KARIWARIATE1, "配当金作成区分");
        exClassificationEquals(khHaitouKanri1.getHaitoumeisaikbn(), C_HaitoumeisaiKbn.SYU, "配当明細区分");
        exDateEquals(khHaitouKanri1.getKariwariatedshrymd(), BizDate.valueOf("20191215"), "仮割当Ｄ支払年月日");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        BizDate kijyunYmd = BizDate.valueOf("20191216");

        List<IT_KhHaitouKanri> khHaitouKanriList = new ArrayList<>();

        IT_KhHaitouKanri khHaitouKanri1 = new IT_KhHaitouKanri();

        khHaitouKanri1.setKbnkey("01");
        khHaitouKanri1.setSyono("17806000013");
        khHaitouKanri1.setHaitounendo(BizDateY.valueOf("2019"));
        khHaitouKanri1.setRenno(1);
        khHaitouKanri1.setHaitoukinskskbn(C_HaitoukinsksKbn.KARIWARIATE1);
        khHaitouKanri1.setHaitoumeisaikbn(C_HaitoumeisaiKbn.SYU);
        khHaitouKanri1.setKariwariatedshrymd(BizDate.valueOf("20191217"));

        IT_KhHaitouKanri khHaitouKanri2 = new IT_KhHaitouKanri();

        khHaitouKanri2.setKbnkey("02");
        khHaitouKanri2.setSyono("17806000024");
        khHaitouKanri2.setHaitounendo(BizDateY.valueOf("2019"));
        khHaitouKanri2.setRenno(2);
        khHaitouKanri2.setHaitoukinskskbn(C_HaitoukinsksKbn.KARIWARIATE1);
        khHaitouKanri2.setHaitoumeisaikbn(C_HaitoumeisaiKbn.SYU);
        khHaitouKanri2.setKariwariatedshrymd(BizDate.valueOf("20191216"));

        IT_KhHaitouKanri khHaitouKanri3 = new IT_KhHaitouKanri();

        khHaitouKanri3.setKbnkey("03");
        khHaitouKanri3.setSyono("17806000035");
        khHaitouKanri3.setHaitounendo(BizDateY.valueOf("2019"));
        khHaitouKanri3.setRenno(3);
        khHaitouKanri3.setHaitoukinskskbn(C_HaitoukinsksKbn.KARIWARIATE1);
        khHaitouKanri3.setHaitoumeisaikbn(C_HaitoumeisaiKbn.SYU);
        khHaitouKanri3.setKariwariatedshrymd(BizDate.valueOf("20191217"));

        khHaitouKanriList.add(khHaitouKanri1);
        khHaitouKanriList.add(khHaitouKanri2);
        khHaitouKanriList.add(khHaitouKanri3);

        IT_KhHaitouKanri khHaitouKanri4 = srGetTokutejitenKhHaitouKanri.exec(khHaitouKanriList, kijyunYmd);

        exStringEquals(khHaitouKanri4.getKbnkey(), "02", "区分キー");
        exStringEquals(khHaitouKanri4.getSyono(), "17806000024", "証券番号");
        exDateYEquals(khHaitouKanri4.getHaitounendo(), BizDateY.valueOf("2019"), "配当年度");
        exNumericEquals(khHaitouKanri4.getRenno(), 2, "連番");
        exClassificationEquals(khHaitouKanri4.getHaitoukinskskbn(), C_HaitoukinsksKbn.KARIWARIATE1, "配当金作成区分");
        exClassificationEquals(khHaitouKanri4.getHaitoumeisaikbn(), C_HaitoumeisaiKbn.SYU, "配当明細区分");
        exDateEquals(khHaitouKanri4.getKariwariatedshrymd(), BizDate.valueOf("20191216"), "仮割当Ｄ支払年月日");
    }

}
