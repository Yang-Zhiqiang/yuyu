package yuyu.common.sinkeiyaku.skcommon;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約当日異動内容編集クラスのメソッド {@link SkToujituIdounaiyouEdit#setSkIdounaiyouInit()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SkToujituIdounaiyouEditTest_setSkIdounaiyouInit{

    @Inject
    private SkToujituIdounaiyouEdit skToujituIdounaiyouEdit;

    @Test
    @Transactional
    @TestOrder(10)
    public void testSetSkIdounaiyouInit_A1() {

        skToujituIdounaiyouEdit.setSkIdounaiyouInit();
    }
}
