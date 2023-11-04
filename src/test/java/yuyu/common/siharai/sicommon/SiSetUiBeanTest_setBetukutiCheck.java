package yuyu.common.siharai.sicommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.common.siharai.siview.viewbetukutichecksibou.ViewBetukutiCheckSibouUiBeanParamImpl;
import yuyu.common.siharai.siview.viewskkihon.ViewSkKihonUiBeanParamImpl;
import yuyu.def.classification.C_NoinitUmuKbn;
import yuyu.def.db.entity.JT_BetukutiSateiInfo;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金給付金支払共通UiBean設定のメソッド{@link SiSetUiBean#setBetukutiCheck(CommonViewUiBeanParam, JT_BetukutiSateiInfo)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SiSetUiBeanTest_setBetukutiCheck {

    @Test
    @TestOrder(10)
    public void testSetBetukutiCheck_A1() {

        JT_BetukutiSateiInfo betukutiSateiInfo = new JT_BetukutiSateiInfo();
        CommonViewUiBeanParam commonViewUiBeanParam = null;
        SiSetUiBean.setBetukutiCheck(commonViewUiBeanParam, betukutiSateiInfo);

        assertNull(commonViewUiBeanParam);

    }

    @Test
    @TestOrder(20)
    public void testSetBetukutiCheck_A2() {

        ViewBetukutiCheckSibouUiBeanParamImpl viewBetukutiCheckSibouUiBeanParamImpl = SWAKInjector
            .getInstance(ViewBetukutiCheckSibouUiBeanParamImpl.class);
        viewBetukutiCheckSibouUiBeanParamImpl.setBetusibouumukbn(C_NoinitUmuKbn.BLNK);

        JT_BetukutiSateiInfo betukutiSateiInfo = null;

        SiSetUiBean.setBetukutiCheck(viewBetukutiCheckSibouUiBeanParamImpl, betukutiSateiInfo);

        exClassificationEquals(viewBetukutiCheckSibouUiBeanParamImpl.getBetusibouumukbn(), null,
            "別口死亡有無区分");

    }

    @Test
    @TestOrder(30)
    public void testSetBetukutiCheck_A3() {

        ViewBetukutiCheckSibouUiBeanParamImpl viewBetukutiCheckSibouUiBeanParamImpl = SWAKInjector
            .getInstance(ViewBetukutiCheckSibouUiBeanParamImpl.class);
        viewBetukutiCheckSibouUiBeanParamImpl.setBetusibouumukbn(C_NoinitUmuKbn.BLNK);
        viewBetukutiCheckSibouUiBeanParamImpl.setBetusiboucomment("AAA");
        viewBetukutiCheckSibouUiBeanParamImpl.setBetusoukiumukbn(C_NoinitUmuKbn.BLNK);
        viewBetukutiCheckSibouUiBeanParamImpl.setBetusoukicomment("BBB");

        JT_BetukutiSateiInfo betukutiSateiInfo = new JT_BetukutiSateiInfo();
        betukutiSateiInfo.setBetusibouumukbn(C_NoinitUmuKbn.ARI);
        betukutiSateiInfo.setBetusiboucomment("AAA");
        betukutiSateiInfo.setBetusoukiumukbn(C_NoinitUmuKbn.NONE);
        betukutiSateiInfo.setBetusoukicomment("BBB");

        SiSetUiBean.setBetukutiCheck(viewBetukutiCheckSibouUiBeanParamImpl, betukutiSateiInfo);

        exClassificationEquals(viewBetukutiCheckSibouUiBeanParamImpl.getBetusibouumukbn(), C_NoinitUmuKbn.ARI,
            "別口死亡有無区分");
        exStringEquals(viewBetukutiCheckSibouUiBeanParamImpl.getBetusiboucomment(), "AAA", "別口死亡コメント");
        exClassificationEquals(viewBetukutiCheckSibouUiBeanParamImpl.getBetusoukiumukbn(), C_NoinitUmuKbn.NONE,
            "別口早期有無区分");
        exStringEquals(viewBetukutiCheckSibouUiBeanParamImpl.getBetusoukicomment(), "BBB", "別口早期コメント");

    }

    @Test
    @TestOrder(40)
    public void testSetBetukutiCheck_A4() {

        ViewSkKihonUiBeanParamImpl viewSkKihonUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSkKihonUiBeanParamImpl.class);
        viewSkKihonUiBeanParamImpl.setSkno("1002");

        JT_BetukutiSateiInfo betukutiSateiInfo = new JT_BetukutiSateiInfo();
        betukutiSateiInfo.setSkno("2002");

        SiSetUiBean.setBetukutiCheck(viewSkKihonUiBeanParamImpl, betukutiSateiInfo);

        exStringEquals(viewSkKihonUiBeanParamImpl.getSkno(), "1002", "請求番号");

    }

}
