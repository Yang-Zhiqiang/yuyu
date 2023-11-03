package yuyu.common.hozen.setuibean;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.hozen.khozen.khkeiyakusyoukai.KariukekinInfoDataSourceBean;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KrkriyuuKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 仮受金情報設定クラスのメソッド {@link SetKariukekin#init(SetKariukekinExecUiBeanParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetKariukekinTest_init {

    @Inject
    private SetKariukekin setKariukekin;

    @Inject
    private SetKariukekinExecUiBeanParamImpl setKariukekinUiBeanParamImpl;




    @Test
    @TestOrder(10)
    public void testInit_A1() {

        setKariukekinUiBeanParamImpl = SWAKInjector.getInstance(SetKariukekinExecUiBeanParamImpl.class);

        setKariukekin.init(setKariukekinUiBeanParamImpl);

        exNumericEquals(setKariukekinUiBeanParamImpl.getKariukekinInfo().size(), 0, "仮受金情報の件数");
    }

    @Test
    @TestOrder(20)
    public void testInit_A2() {

        setKariukekinUiBeanParamImpl = SWAKInjector.getInstance(SetKariukekinExecUiBeanParamImpl.class);

        List<KariukekinInfoDataSourceBeanCommonParam> kariukekinInfo = new ArrayList<>();

        KariukekinInfoDataSourceBeanCommonParam kariukekinInfoDataSourceBeanCommonParam = SWAKInjector.getInstance(KariukekinInfoDataSourceBean.class);

        kariukekinInfoDataSourceBeanCommonParam.setVkukkrkno(1);
        kariukekinInfoDataSourceBeanCommonParam.setVkukkrkkeijyoymd(BizDate.valueOf(20181001));
        kariukekinInfoDataSourceBeanCommonParam.setVkukkrkriyuukbn(C_KrkriyuuKbn.HENKOUMATI);
        kariukekinInfoDataSourceBeanCommonParam.setVkukhrkkaisuu(C_Hrkkaisuu.NEN);
        kariukekinInfoDataSourceBeanCommonParam.setVkuknykkeiro(C_Nykkeiro.CREDIT);
        kariukekinInfoDataSourceBeanCommonParam.setVkuknyknaiyoukbn(C_NyknaiyouKbn.HARAIHENYOUP);
        kariukekinInfoDataSourceBeanCommonParam.setVkukjyuutouym(BizDateYM.valueOf(201812));
        kariukekinInfoDataSourceBeanCommonParam.setVkukjyutoukaisuu("１２か月");
        kariukekinInfoDataSourceBeanCommonParam.setVkukryosyuymd(BizDate.valueOf(20181012));
        kariukekinInfoDataSourceBeanCommonParam.setVkukkrkgk(BizCurrency.valueOf(100000000));
        kariukekinInfo.add(kariukekinInfoDataSourceBeanCommonParam);
        setKariukekinUiBeanParamImpl.convertKariukekinInfoForCommonParam(kariukekinInfo);
        setKariukekin.init(setKariukekinUiBeanParamImpl);
        exNumericEquals(setKariukekinUiBeanParamImpl.getKariukekinInfo().size(), 0, "仮受金情報の件数");

    }
}
