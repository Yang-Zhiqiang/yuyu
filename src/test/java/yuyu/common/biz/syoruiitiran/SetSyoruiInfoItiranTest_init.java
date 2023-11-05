package yuyu.common.biz.syoruiitiran;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 書類情報一覧設定クラスのメソッド {@link SetSyoruiInfoItiran#init(SetSyoruiInfoItiranExecUiBeanParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetSyoruiInfoItiranTest_init {

    @Inject
    private SetSyoruiInfoItiran setSyoruiInfoItiran;

    @Test
    @TestOrder(10)
    public void testInit_A1() {

        SetSyoruiInfoItiranExecUiBeanParamImpl setSyoruiInfoItiranExecUiBeanParamImpl = SWAKInjector.getInstance(SetSyoruiInfoItiranExecUiBeanParamImpl.class);

        setSyoruiInfoItiran.init(setSyoruiInfoItiranExecUiBeanParamImpl);

        List<SyoruiInfoItiranDataSourceBeanCommonParam> paramLst = setSyoruiInfoItiranExecUiBeanParamImpl.getSyoruiInfoItiranDataSourceBeanCommonParamLst();

        exNumericEquals(paramLst.size(), 0, "インタフェース型から進捗履歴情報データソース情報リスト件数");


    }
}
