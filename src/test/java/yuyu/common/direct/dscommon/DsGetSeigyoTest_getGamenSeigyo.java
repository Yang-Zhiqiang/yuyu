package yuyu.common.direct.dscommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_DsSyouhnbunruiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＤＳ制御情報取得クラスのメソッド {@link DsGetSeigyo#getGamenSeigyo(DsSyouhinBean pDsSyouhinBean)} テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class DsGetSeigyoTest_getGamenSeigyo {

    @Inject
    private DsGetSeigyo dsGetSeigyo;

    @Test
    @TestOrder(10)
    public void testGetGamenSeigyo_A1() {

        DsSyouhinBean dsSyouhinBean = new DsSyouhinBean();
        dsSyouhinBean.setDsSyouhnbunruiKbn(C_DsSyouhnbunruiKbn.YENDTITIJIBRSYSN);

        GamenSeigyoBean gamenSeigyoBean = dsGetSeigyo.getGamenSeigyo(dsSyouhinBean);

        exClassificationEquals(gamenSeigyoBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(gamenSeigyoBean.getTutakinUmukbn(), C_UmuKbn.ARI, "積立金有無区分");
        exClassificationEquals(gamenSeigyoBean.getKaiyakuHrsuiiUmuKbn(), C_UmuKbn.NONE, "解約返戻金推移有無区分");
    }

    @Test
    @TestOrder(20)
    public void testGetGamenSeigyo_A2() {

        DsSyouhinBean dsSyouhinBean = new DsSyouhinBean();
        dsSyouhinBean.setDsSyouhnbunruiKbn(C_DsSyouhnbunruiKbn.GKDTITIJIBRNK);

        GamenSeigyoBean gamenSeigyoBean = dsGetSeigyo.getGamenSeigyo(dsSyouhinBean);

        exClassificationEquals(gamenSeigyoBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(gamenSeigyoBean.getTutakinUmukbn(), C_UmuKbn.ARI, "積立金有無区分");
        exClassificationEquals(gamenSeigyoBean.getKaiyakuHrsuiiUmuKbn(), C_UmuKbn.NONE, "解約返戻金推移有無区分");
    }

    @Test
    @TestOrder(30)
    public void testGetGamenSeigyo_A3() {

        DsSyouhinBean dsSyouhinBean = new DsSyouhinBean();
        dsSyouhinBean.setDsSyouhnbunruiKbn(C_DsSyouhnbunruiKbn.BLNK);

        GamenSeigyoBean gamenSeigyoBean = dsGetSeigyo.getGamenSeigyo(dsSyouhinBean);

        exClassificationEquals(gamenSeigyoBean.getErrorKbn(), C_ErrorKbn.ERROR, "結果区分");
        assertNull(gamenSeigyoBean.getTutakinUmukbn());
        assertNull(gamenSeigyoBean.getKaiyakuHrsuiiUmuKbn());
    }

    @Test
    @TestOrder(40)
    public void testGetGamenSeigyo_A4() {

        DsSyouhinBean dsSyouhinBean = new DsSyouhinBean();
        dsSyouhinBean.setDsSyouhnbunruiKbn(C_DsSyouhnbunruiKbn.GKDTHIJYNBRNK);

        GamenSeigyoBean gamenSeigyoBean = dsGetSeigyo.getGamenSeigyo(dsSyouhinBean);

        exClassificationEquals(gamenSeigyoBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(gamenSeigyoBean.getTutakinUmukbn(), C_UmuKbn.ARI, "積立金有無区分");
        exClassificationEquals(gamenSeigyoBean.getKaiyakuHrsuiiUmuKbn(), C_UmuKbn.NONE, "解約返戻金推移有無区分");
    }

    @Test
    @TestOrder(50)
    public void testGetGamenSeigyo_A5() {

        DsSyouhinBean dsSyouhinBean = new DsSyouhinBean();
        dsSyouhinBean.setDsSyouhnbunruiKbn(C_DsSyouhnbunruiKbn.YENDTITIJIBRNK);

        GamenSeigyoBean gamenSeigyoBean = dsGetSeigyo.getGamenSeigyo(dsSyouhinBean);

        exClassificationEquals(gamenSeigyoBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(gamenSeigyoBean.getTutakinUmukbn(), C_UmuKbn.ARI, "積立金有無区分");
        exClassificationEquals(gamenSeigyoBean.getKaiyakuHrsuiiUmuKbn(), C_UmuKbn.NONE, "解約返戻金推移有無区分");
    }

    @Test
    @TestOrder(60)
    public void testGetGamenSeigyo_A6() {

        DsSyouhinBean dsSyouhinBean = new DsSyouhinBean();
        dsSyouhinBean.setDsSyouhnbunruiKbn(C_DsSyouhnbunruiKbn.SNTKDTHIJYNBRSYSN);

        GamenSeigyoBean gamenSeigyoBean = dsGetSeigyo.getGamenSeigyo(dsSyouhinBean);

        exClassificationEquals(gamenSeigyoBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(gamenSeigyoBean.getTutakinUmukbn(), C_UmuKbn.ARI, "積立金有無区分");
        exClassificationEquals(gamenSeigyoBean.getKaiyakuHrsuiiUmuKbn(), C_UmuKbn.NONE, "解約返戻金推移有無区分");
    }
}
