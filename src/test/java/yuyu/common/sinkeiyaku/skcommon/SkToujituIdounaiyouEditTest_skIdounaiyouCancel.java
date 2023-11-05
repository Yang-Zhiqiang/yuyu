package yuyu.common.sinkeiyaku.skcommon;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約当日異動内容編集クラスのメソッド {@link SkToujituIdounaiyouEdit#skIdounaiyouCancel()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SkToujituIdounaiyouEditTest_skIdounaiyouCancel{

    @Inject
    private SkToujituIdounaiyouEdit skToujituIdounaiyouEdit;

    @Test
    @Transactional
    @TestOrder(10)
    public void testSkIdounaiyouCancel_A1() {

        assertNull(skToujituIdounaiyouEdit.skIdounaiyouCancel());
    }
}
