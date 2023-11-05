package yuyu.common.hozen.setuibean;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 別契約情報設定クラスのメソッド {@link SetBetukyk#init(SetBetukykExecUiBeanParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetBetukykTest_init {

    @Inject
    SetBetukyk setBetukyk;

    @Inject
    private SetBetukykExecUiBeanParamImpl setBetukykExecUiBeanParamImpl;

    @Test
    @TestOrder(10)
    public void testInit_A1() {

        setBetukykExecUiBeanParamImpl = SWAKInjector.getInstance(SetBetukykExecUiBeanParamImpl.class);

        setBetukyk.init(setBetukykExecUiBeanParamImpl);

        exNumericEquals(setBetukykExecUiBeanParamImpl.getKikeiyakuInfoDataSourceBeanList().size(), 0, "別契約（既契約）の件数");
        exNumericEquals(setBetukykExecUiBeanParamImpl.getNenkinsiharaiInfoDataSourceBeanList().size(), 0, "別契約（年金支払契約） の件数");
        exNumericEquals(setBetukykExecUiBeanParamImpl.getPalkikeiyakuInfoDataSourceBeanList().size(), 0, "別契約（ＰＡＬ既契約）の件数");
        exNumericEquals(setBetukykExecUiBeanParamImpl.getPalNenkinsiharaiInfoDataSourceBeanList().size(), 0, "別契約（ＰＡＬ年金支払契約）の件数 ");
        exNumericEquals(setBetukykExecUiBeanParamImpl.getPalsueokiInfoDataSourceBeanList().size(), 0, "別契約（ＰＡＬ保険金据置契約）の件数");
        exNumericEquals(setBetukykExecUiBeanParamImpl.getWarningMessageIdList().size(), 0, "ワーニングメッセージIDリストの件数");
        exNumericEquals(setBetukykExecUiBeanParamImpl.getWarningMessageList().size(), 0, "ワーニングメッセージリストの件数");

    }

    @Test
    @TestOrder(20)
    public void testInit_A2() {

        setBetukykExecUiBeanParamImpl = SWAKInjector.getInstance(SetBetukykExecUiBeanParamImpl.class);

        List<KikeiyakuInfoDataSourceBeanCommonParam> kikeiyakuInfoDataSourceBeanList = new ArrayList<>();

        KikeiyakuInfoDataSourceBeanCommonParamImpl kikeiyakuInfoDataSourceBean =
            SWAKInjector.getInstance(KikeiyakuInfoDataSourceBeanCommonParamImpl.class);

        kikeiyakuInfoDataSourceBean.setVbtkkdispbtkyksyono("12806345672");

        kikeiyakuInfoDataSourceBeanList.add(kikeiyakuInfoDataSourceBean);

        setBetukykExecUiBeanParamImpl.convertKikeiyakuInfoForCommonParam(kikeiyakuInfoDataSourceBeanList);

        List<NenkinsiharaiInfoDataSourceBeanCommonParam> nenkinsiharaiInfoDataSourceBeanList = new ArrayList<>();

        NenkinsiharaiInfoDataSourceBeanCommonParamImpl nenkinsiharaiInfoDataSourceBean =
            SWAKInjector.getInstance(NenkinsiharaiInfoDataSourceBeanCommonParamImpl.class);

        nenkinsiharaiInfoDataSourceBean.setVbtkkdispbtkyknksysyno("12806345672");

        setBetukykExecUiBeanParamImpl.convertNenkinsiharaiInfoForCommonParam(nenkinsiharaiInfoDataSourceBeanList);

        List<PalkikeiyakuInfoDataSourceBeanCommonParam> palkikeiyakuInfoDataSourceBeanList = new ArrayList<>();

        PalkikeiyakuInfoDataSourceBeanCommonParamImpl palkikeiyakuInfoDataSourceBean =
            SWAKInjector.getInstance(PalkikeiyakuInfoDataSourceBeanCommonParamImpl.class);

        palkikeiyakuInfoDataSourceBean.setVbtkkdisppalbtkyksyono("12806345672");

        setBetukykExecUiBeanParamImpl.convertPalkikeiyakuInfoForCommonParam(palkikeiyakuInfoDataSourceBeanList);

        List<PalNenkinsiharaiInfoDataSourceBeanCommonParam> palNenkinsiharaiInfoDataSourceBeanList = new ArrayList<>();

        PalNenkinsiharaiInfoDataSourceBeanCommonParamImpl palNenkinsiharaiInfoDataSourceBean =
            SWAKInjector.getInstance(PalNenkinsiharaiInfoDataSourceBeanCommonParamImpl.class);

        palNenkinsiharaiInfoDataSourceBean.setVbtkkdisppalbtkyknksysyno("12806345672");

        setBetukykExecUiBeanParamImpl.convertPalNenkinsiharaiInfoForCommonParam(palNenkinsiharaiInfoDataSourceBeanList);

        List<PalsueokiInfoDataSourceBeanCommonParam> palsueokiInfoDataSourceBeanList = new ArrayList<>();

        PalsueokiInfoDataSourceBeanCommonParamImpl palsueokiInfoDataSourceBean =
            SWAKInjector.getInstance(PalsueokiInfoDataSourceBeanCommonParamImpl.class);

        palsueokiInfoDataSourceBean.setVbtkkdisppalbtkyksosysyno("12806345672");

        setBetukykExecUiBeanParamImpl.convertPalsueokiInfoForCommonParam(palsueokiInfoDataSourceBeanList);

        List<String> List = new ArrayList<>();
        List.add("1");

        setBetukykExecUiBeanParamImpl.setWarningMessageIdList(List);
        setBetukykExecUiBeanParamImpl.setWarningMessageList(List);

        setBetukyk.init(setBetukykExecUiBeanParamImpl);

        exNumericEquals(setBetukykExecUiBeanParamImpl.getKikeiyakuInfoDataSourceBeanList().size(), 0, "別契約（既契約）の件数");
        exNumericEquals(setBetukykExecUiBeanParamImpl.getNenkinsiharaiInfoDataSourceBeanList().size(), 0, "別契約（年金支払契約）の件数");
        exNumericEquals(setBetukykExecUiBeanParamImpl.getPalkikeiyakuInfoDataSourceBeanList().size(), 0, "別契約（ＰＡＬ既契約）の件数 ");
        exNumericEquals(setBetukykExecUiBeanParamImpl.getPalNenkinsiharaiInfoDataSourceBeanList().size(), 0, "別契約（ＰＡＬ年金支払契約）の件数");
        exNumericEquals(setBetukykExecUiBeanParamImpl.getPalsueokiInfoDataSourceBeanList().size(), 0, "別契約（ＰＡＬ保険金据置契約）の件数");
        exNumericEquals(setBetukykExecUiBeanParamImpl.getWarningMessageIdList().size(), 0, "ワーニングメッセージIDリストの件数");
        exNumericEquals(setBetukykExecUiBeanParamImpl.getWarningMessageList().size(), 0, "ワーニングメッセージリストの件数");

    }
}
