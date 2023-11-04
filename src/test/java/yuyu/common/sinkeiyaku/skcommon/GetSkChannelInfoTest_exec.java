package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.classification.C_Channelcd;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約チャネル情報取得クラスのメソッド {@link GetSkChannelInfo#exec(C_Channelcd, String)} テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class GetSkChannelInfoTest_exec {

    @Inject
    private GetSkChannelInfo getSkChannelInfo;

    @Inject
    private ExDBEntityManager em;

    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(10)
    public void testExec_A1() {

        String jpql = "delete from " + "HM_SkChannel";
        em.createJPQL(jpql).executeUpdate();

        try {

            getSkChannelInfo.exec(null, "");
        } catch (CommonBizAppException e) {

            exStringEquals(e.getMessage(), "システム整合性エラーです。", "エラーメッセージ");

            throw e;
        }
    }
}