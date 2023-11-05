package yuyu.common.biz.kaikei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 振替伝票情報クラスのメソッド {@link BzFurikaeDenpyouJouhou#getInjiTrhkno()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzFurikaeDenpyouJouhouTest_getInjiTrhkno{

    @Inject
    private BzFurikaeDenpyouJouhou bzFurikaeDenpyouJouhou;

    @Test
    @TestOrder(10)
    public void testGetInjiTrhkno_A1() {
        bzFurikaeDenpyouJouhou.setTorihikiNo("10001");
        bzFurikaeDenpyouJouhou.setLastGroupDispFlg(true);

        bzFurikaeDenpyouJouhou.getInjiTrhkno();

        exStringEquals(bzFurikaeDenpyouJouhou.getInjiTrhkno(), "10001L", "印字用取引番号");
    }

    @Test
    @TestOrder(20)
    public void testGetInjiTrhkno_A2() {
        bzFurikaeDenpyouJouhou.setTorihikiNo("10001");
        bzFurikaeDenpyouJouhou.setLastGroupDispFlg(false);

        bzFurikaeDenpyouJouhou.getInjiTrhkno();

        exStringEquals(bzFurikaeDenpyouJouhou.getInjiTrhkno(), "10001", "印字用取引番号");
    }
}
