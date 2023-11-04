package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.number.BizCurrency;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_KoujyosyoumeipKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 前納控除証明額計算クラスのメソッド {@link KeisanZennouKoujyogaku#getKhShgtZennouKoujyogakuBean(String,String,
 * List<KhShgtZennouKoujyogakuBean>)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanZennouKoujyogakuTest_getKhShgtZennouKoujyogakuBean {

    @Inject
    private KeisanZennouKoujyogaku keisanZennouKoujyogaku;

    @Test
    @TestOrder(10)
    public void testGetKhShgtZennouKoujyogakuBean_A1() {

        String syouhncd = "ｱｲ";
        String syouhnsdno = "9000";
        List<KhShgtZennouKoujyogakuBean> khShgtZennouKoujyogakuBeanLst = new ArrayList<>();

        KhShgtZennouKoujyogakuBean khShgtZennouKoujyogakuBean = keisanZennouKoujyogaku.getKhShgtZennouKoujyogakuBean(
            syouhncd, syouhnsdno, khShgtZennouKoujyogakuBeanLst);

        exBooleanEquals(khShgtZennouKoujyogakuBean == null, true, "商品毎控除証明情報Bean");
    }

    @Test
    @TestOrder(20)
    public void testGetKhShgtZennouKoujyogakuBean_A2() {

        String syouhncd = "ｱｲ";
        String syouhnsdno = "9000";
        List<KhShgtZennouKoujyogakuBean> khShgtZennouKoujyogakuBeanLst = new ArrayList<>();
        KhShgtZennouKoujyogakuBean khShgtZennouKoujyogakuBean1 = new KhShgtZennouKoujyogakuBean();
        khShgtZennouKoujyogakuBean1.setSyouhncd("ｱ1");
        khShgtZennouKoujyogakuBean1.setSyouhnsdno("9001");
        khShgtZennouKoujyogakuBean1.setSyutkkbn(C_SyutkKbn.SYU);
        khShgtZennouKoujyogakuBean1.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.IPPAN);
        khShgtZennouKoujyogakuBean1.setKhShgtZennouKoujyogaku(BizCurrency.valueOf(10000));
        khShgtZennouKoujyogakuBeanLst.add(khShgtZennouKoujyogakuBean1);

        KhShgtZennouKoujyogakuBean KhShgtZennouKoujyogakuBean = keisanZennouKoujyogaku.getKhShgtZennouKoujyogakuBean(
            syouhncd, syouhnsdno, khShgtZennouKoujyogakuBeanLst);

        exBooleanEquals(KhShgtZennouKoujyogakuBean == null, true, "商品毎控除証明情報Bean");
    }

    @Test
    @TestOrder(30)
    public void testGetKhShgtZennouKoujyogakuBean_A3() {

        String syouhncd = "ｱｲ";
        String syouhnsdno = "9000";
        List<KhShgtZennouKoujyogakuBean> khShgtZennouKoujyogakuBeanLst = new ArrayList<>();
        KhShgtZennouKoujyogakuBean khShgtZennouKoujyogakuBean1 = new KhShgtZennouKoujyogakuBean();
        KhShgtZennouKoujyogakuBean khShgtZennouKoujyogakuBean2 = new KhShgtZennouKoujyogakuBean();
        KhShgtZennouKoujyogakuBean khShgtZennouKoujyogakuBean3 = new KhShgtZennouKoujyogakuBean();
        khShgtZennouKoujyogakuBean1.setSyouhncd("ｱｲ");
        khShgtZennouKoujyogakuBean1.setSyouhnsdno("9001");
        khShgtZennouKoujyogakuBean1.setSyutkkbn(C_SyutkKbn.SYU);
        khShgtZennouKoujyogakuBean1.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.IPPAN);
        khShgtZennouKoujyogakuBean1.setKhShgtZennouKoujyogaku(BizCurrency.valueOf(10000));
        khShgtZennouKoujyogakuBean2.setSyouhncd("ｱ1");
        khShgtZennouKoujyogakuBean2.setSyouhnsdno("9000");
        khShgtZennouKoujyogakuBean2.setSyutkkbn(C_SyutkKbn.NONE);
        khShgtZennouKoujyogakuBean2.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.KAIGOIRYOU);
        khShgtZennouKoujyogakuBean2.setKhShgtZennouKoujyogaku(BizCurrency.valueOf(20000));
        khShgtZennouKoujyogakuBean3.setSyouhncd("ｱｲ");
        khShgtZennouKoujyogakuBean3.setSyouhnsdno("9000");
        khShgtZennouKoujyogakuBean3.setSyutkkbn(C_SyutkKbn.TK);
        khShgtZennouKoujyogakuBean3.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.NENKIN);
        khShgtZennouKoujyogakuBean3.setKhShgtZennouKoujyogaku(BizCurrency.valueOf(30000));

        khShgtZennouKoujyogakuBeanLst.add(khShgtZennouKoujyogakuBean1);
        khShgtZennouKoujyogakuBeanLst.add(khShgtZennouKoujyogakuBean2);
        khShgtZennouKoujyogakuBeanLst.add(khShgtZennouKoujyogakuBean3);

        KhShgtZennouKoujyogakuBean KhShgtZennouKoujyogakuBean = keisanZennouKoujyogaku.getKhShgtZennouKoujyogakuBean(
            syouhncd, syouhnsdno, khShgtZennouKoujyogakuBeanLst);

        exStringEquals(KhShgtZennouKoujyogakuBean.getSyouhncd(), "ｱｲ", "商品コード");
        exStringEquals(KhShgtZennouKoujyogakuBean.getSyouhnsdno(), "9000", "商品世代番号");
        exClassificationEquals(KhShgtZennouKoujyogakuBean.getSyutkkbn(), C_SyutkKbn.TK, "主契約特約区分");
        exClassificationEquals(KhShgtZennouKoujyogakuBean.getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.NENKIN,
            "控除証明保険料区分");
        exBizCalcbleEquals(KhShgtZennouKoujyogakuBean.getKhShgtZennouKoujyogaku(), BizCurrency.valueOf(30000),
            "商品毎控除証明額");
    }
}
