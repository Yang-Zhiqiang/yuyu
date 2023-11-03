package yuyu.common.siharai.sicommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.siharai.edittbl.SiSiDetailParamBean;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金給付金保障判定クラスのメソッド {@link SiHosyouHantei#chkSaigaiHosyou(List<SiSiDetailParamBean>)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SiHosyouHanteiTest_chkSaigaiHosyou {

    @Inject
    private SiHosyouHantei siHosyouHantei;

    @Test
    @TestOrder(10)
    public void testChkSaigaiHosyou_A1() {
        MockObjectManager.initialize();

        boolean hanteiKekkaFlag = siHosyouHantei.chkSaigaiHosyou(null);

        exBooleanEquals(hanteiKekkaFlag, false, "判定結果フラグ");

    }

    @Test
    @TestOrder(20)
    public void testChkSaigaiHosyou_A2() {
        boolean hanteiKekkaFlag = siHosyouHantei.chkSaigaiHosyou(new ArrayList<SiSiDetailParamBean>());

        exBooleanEquals(hanteiKekkaFlag, false, "判定結果フラグ");
    }

    @Test
    @TestOrder(30)
    public void testChkSaigaiHosyou_A3() {
        List<SiSiDetailParamBean> siSiDetailParamBeanList = new ArrayList<>();
        SiSiDetailParamBean siSiDetailParamBean = new SiSiDetailParamBean();
        siSiDetailParamBean.setHokenkinsyuruikbn(C_HokenkinsyuruiKbn.SBHOKENKIN);
        siSiDetailParamBeanList.add(siSiDetailParamBean);

        boolean hanteiKekkaFlag = siHosyouHantei.chkSaigaiHosyou(siSiDetailParamBeanList);

        exBooleanEquals(hanteiKekkaFlag, false, "判定結果フラグ");
    }

    @Test
    @TestOrder(40)
    public void testChkSaigaiHosyou_A4() {
        List<SiSiDetailParamBean> siSiDetailParamBeanList = new ArrayList<>();
        SiSiDetailParamBean siSiDetailParamBean1 = new SiSiDetailParamBean();
        siSiDetailParamBean1.setHokenkinsyuruikbn(C_HokenkinsyuruiKbn.SBHOKENKIN);
        siSiDetailParamBeanList.add(siSiDetailParamBean1);

        SiSiDetailParamBean siSiDetailParamBean2 = new SiSiDetailParamBean();
        siSiDetailParamBean2.setHokenkinsyuruikbn(C_HokenkinsyuruiKbn.SAIGAIHOKENKIN);
        siSiDetailParamBeanList.add(siSiDetailParamBean2);

        SiSiDetailParamBean siSiDetailParamBean3 = new SiSiDetailParamBean();
        siSiDetailParamBean3.setHokenkinsyuruikbn(C_HokenkinsyuruiKbn.SBKYUUHUKIN);
        siSiDetailParamBeanList.add(siSiDetailParamBean3);

        boolean hanteiKekkaFlag = siHosyouHantei.chkSaigaiHosyou(siSiDetailParamBeanList);

        exBooleanEquals(hanteiKekkaFlag, true, "判定結果フラグ");
    }
}
