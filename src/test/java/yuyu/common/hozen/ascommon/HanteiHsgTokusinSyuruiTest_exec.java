package yuyu.common.hozen.ascommon;

import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import yuyu.def.classification.C_HsigiTkbtTaiouSyuruiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.hozen.configuration.HsigiTksnTeigiBean;
import yuyu.def.hozen.configuration.YuyuHozenConfig;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

/**
 * 被災害特伸種類判クラスのメソッド {@link HanteiHsgTokusinSyurui#exec(BizDate)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class HanteiHsgTokusinSyuruiTest_exec {

    @Inject
    HanteiHsgTokusinSyurui hanteiHsgTokusinSyurui;

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        BizDate hsgymd = BizDate.valueOf(20200311);

        HsigiTksnInfoBean hsigiTksnInfoBean = hanteiHsgTokusinSyurui.exec(hsgymd);

        exClassificationEquals(hsigiTksnInfoBean.getHsigiTkbtTaiouSyurui(), C_HsigiTkbtTaiouSyuruiKbn.TOKUBETU1, "被災害特別対応種類");
        exClassificationEquals(hsigiTksnInfoBean.getKoujyoSyoumeiTkbtTaiouUmu(), C_UmuKbn.ARI, "控除証明特別対応有無");
        exDateEquals(hsigiTksnInfoBean.getBnktAnnaiKaisiYmd(), BizDate.valueOf(20201101), "分割案内終了日");
        exDateEquals(hsigiTksnInfoBean.getBnktAnnaiEndYmd(), BizDate.valueOf(20210430), "分割案内終了日");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {


        HsigiTksnTeigiBean hsigiTksnTeigiBean2 = new  HsigiTksnTeigiBean();
        HsigiTksnTeigiBean hsigiTksnTeigiBean3 = new  HsigiTksnTeigiBean();

        hsigiTksnTeigiBean2.setSaigainm("災害名２");
        hsigiTksnTeigiBean2.setHsgymd(BizDate.valueOf(20200123));
        hsigiTksnTeigiBean2.setHsigitkbttaiousyurui(C_HsigiTkbtTaiouSyuruiKbn.TOKUBETU1);
        hsigiTksnTeigiBean2.setBnktannaikaisiymd(BizDate.valueOf(20200803));
        hsigiTksnTeigiBean2.setBnktannaiendymd(BizDate.valueOf(20200803));
        hsigiTksnTeigiBean2.setKoujyosyoumeitkbttaiouumu(C_UmuKbn.ARI);

        hsigiTksnTeigiBean3.setSaigainm("災害名３");
        hsigiTksnTeigiBean3.setHsgymd(BizDate.valueOf(20191008));
        hsigiTksnTeigiBean3.setHsigitkbttaiousyurui(C_HsigiTkbtTaiouSyuruiKbn.BLNK);
        hsigiTksnTeigiBean3.setBnktannaikaisiymd(BizDate.valueOf(20000101));
        hsigiTksnTeigiBean3.setBnktannaiendymd(BizDate.valueOf(20000101));
        hsigiTksnTeigiBean3.setKoujyosyoumeitkbttaiouumu(C_UmuKbn.NONE);

        YuyuHozenConfig.getInstance().addHsigiTksnTeigiBean(hsigiTksnTeigiBean2);
        YuyuHozenConfig.getInstance().addHsigiTksnTeigiBean(hsigiTksnTeigiBean3);


        BizDate hsgymd = BizDate.valueOf(20200311);

        HsigiTksnInfoBean hsigiTksnInfoBean = hanteiHsgTokusinSyurui.exec(hsgymd);

        exClassificationEquals(hsigiTksnInfoBean.getHsigiTkbtTaiouSyurui(), C_HsigiTkbtTaiouSyuruiKbn.TOKUBETU1, "被災害特別対応種類");
        exClassificationEquals(hsigiTksnInfoBean.getKoujyoSyoumeiTkbtTaiouUmu(), C_UmuKbn.ARI, "控除証明特別対応有無");
        exDateEquals(hsigiTksnInfoBean.getBnktAnnaiKaisiYmd(), BizDate.valueOf(20201101), "分割案内終了日");
        exDateEquals(hsigiTksnInfoBean.getBnktAnnaiEndYmd(), BizDate.valueOf(20210430), "分割案内終了日");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        BizDate hsgymd = BizDate.valueOf(20200312);

        HsigiTksnInfoBean hsigiTksnInfoBean = hanteiHsgTokusinSyurui.exec(hsgymd);

        exClassificationEquals(hsigiTksnInfoBean.getHsigiTkbtTaiouSyurui(), C_HsigiTkbtTaiouSyuruiKbn.BLNK, "被災害特別対応種類");
        exClassificationEquals(hsigiTksnInfoBean.getKoujyoSyoumeiTkbtTaiouUmu(), C_UmuKbn.NONE, "控除証明特別対応有無");
        exDateEquals(hsigiTksnInfoBean.getBnktAnnaiKaisiYmd(), null, "分割案内終了日");
        exDateEquals(hsigiTksnInfoBean.getBnktAnnaiEndYmd(), null, "分割案内終了日");
    }
}
