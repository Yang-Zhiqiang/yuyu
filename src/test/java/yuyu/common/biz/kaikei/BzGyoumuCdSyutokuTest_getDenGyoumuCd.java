package yuyu.common.biz.kaikei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * {@link BzGyoumuCdSyutoku#getDenGyoumuCd(C_ShrhousiteiKbn, String, String, Integer, C_Tuukasyu)}
 * クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzGyoumuCdSyutokuTest_getDenGyoumuCd extends AbstractTest {

    @Test
    @TestOrder(10)
    public void testGetDenGyoumuCd_A1() {

        BzGyoumuCdSyutoku bzGyoumuCdSyutoku = SWAKInjector.getInstance(BzGyoumuCdSyutoku.class);

        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;
        C_ShrhousiteiKbn shrhousiteiKbn = C_ShrhousiteiKbn.FB_YOKUJITU;
        String syoricd = "RA43";
        String syouhncd = "";
        int syouhnsdno = 0;
        C_TantouCdKbn pTantouCd = null;

        String denGyoumuCd = bzGyoumuCdSyutoku.getDenGyoumuCd(shrhousiteiKbn, syoricd, syouhncd, syouhnsdno, tuukasyu, pTantouCd);
        exStringEquals(denGyoumuCd, "5650", "伝票用業務コード");
    }

    @Test
    @TestOrder(20)
    public void testGetDenGyoumuCd_A2() {

        BzGyoumuCdSyutoku bzGyoumuCdSyutoku = SWAKInjector.getInstance(BzGyoumuCdSyutoku.class);

        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;
        C_ShrhousiteiKbn shrhousiteiKbn = C_ShrhousiteiKbn.FB_YOKUJITU;
        String syoricd = "RB30";
        String syouhncd = "";
        int syouhnsdno = 0;
        C_TantouCdKbn pTantouCd = null;

        String denGyoumuCd = bzGyoumuCdSyutoku.getDenGyoumuCd(shrhousiteiKbn, syoricd, syouhncd, syouhnsdno, tuukasyu, pTantouCd);
        exStringEquals(denGyoumuCd, "9943", "伝票用業務コード");
    }

    @Test
    @TestOrder(30)
    public void testGetDenGyoumuCd_A3() {

        BzGyoumuCdSyutoku bzGyoumuCdSyutoku = SWAKInjector.getInstance(BzGyoumuCdSyutoku.class);

        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;
        C_ShrhousiteiKbn shrhousiteiKbn = C_ShrhousiteiKbn.FB_YOKUJITU;
        String syoricd = "RB10";
        String syouhncd = "";
        int syouhnsdno = 0;
        C_TantouCdKbn pTantouCd = null;

        String denGyoumuCd = bzGyoumuCdSyutoku.getDenGyoumuCd(shrhousiteiKbn, syoricd, syouhncd, syouhnsdno, tuukasyu, pTantouCd);
        exStringEquals(denGyoumuCd, "9943", "伝票用業務コード");
    }

    @Test
    @TestOrder(40)
    public void testGetDenGyoumuCd_A4() {

        BzGyoumuCdSyutoku bzGyoumuCdSyutoku = SWAKInjector.getInstance(BzGyoumuCdSyutoku.class);

        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;
        C_ShrhousiteiKbn shrhousiteiKbn = C_ShrhousiteiKbn.FB_YOKUJITU;
        String syoricd = "RB31";
        String syouhncd = "";
        int syouhnsdno = 0;
        C_TantouCdKbn pTantouCd = null;

        String denGyoumuCd = bzGyoumuCdSyutoku.getDenGyoumuCd(shrhousiteiKbn, syoricd, syouhncd, syouhnsdno, tuukasyu, pTantouCd);
        exStringEquals(denGyoumuCd, "9943", "伝票用業務コード");
    }

    @Test
    @TestOrder(50)
    public void testGetDenGyoumuCd_A5() {

        BzGyoumuCdSyutoku bzGyoumuCdSyutoku = SWAKInjector.getInstance(BzGyoumuCdSyutoku.class);

        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;
        C_ShrhousiteiKbn shrhousiteiKbn = C_ShrhousiteiKbn.FB_YOKUJITU;
        String syoricd = "RC06";
        String syouhncd = "";
        int syouhnsdno = 0;
        C_TantouCdKbn pTantouCd = null;

        String denGyoumuCd = bzGyoumuCdSyutoku.getDenGyoumuCd(shrhousiteiKbn, syoricd, syouhncd, syouhnsdno, tuukasyu, pTantouCd);
        exStringEquals(denGyoumuCd, "9943", "伝票用業務コード");
    }

    @Test
    @TestOrder(60)
    public void testGetDenGyoumuCd_A6() {

        BzGyoumuCdSyutoku bzGyoumuCdSyutoku = SWAKInjector.getInstance(BzGyoumuCdSyutoku.class);

        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;
        C_ShrhousiteiKbn shrhousiteiKbn = C_ShrhousiteiKbn.FB_YOKUJITU;
        String syoricd = "RC05";
        String syouhncd = "";
        int syouhnsdno = 0;
        C_TantouCdKbn pTantouCd = null;

        String denGyoumuCd = bzGyoumuCdSyutoku.getDenGyoumuCd(shrhousiteiKbn, syoricd, syouhncd, syouhnsdno, tuukasyu, pTantouCd);
        exStringEquals(denGyoumuCd, "9943", "伝票用業務コード");
    }

    @Test
    @TestOrder(70)
    public void testGetDenGyoumuCd_A7() {

        BzGyoumuCdSyutoku bzGyoumuCdSyutoku = SWAKInjector.getInstance(BzGyoumuCdSyutoku.class);

        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;
        C_ShrhousiteiKbn shrhousiteiKbn = C_ShrhousiteiKbn.FB_YOKUJITU;
        String syoricd = "RB75";
        String syouhncd = "";
        int syouhnsdno = 0;
        C_TantouCdKbn pTantouCd = null;

        String denGyoumuCd = bzGyoumuCdSyutoku.getDenGyoumuCd(shrhousiteiKbn, syoricd, syouhncd, syouhnsdno, tuukasyu, pTantouCd);
        exStringEquals(denGyoumuCd, "9943", "伝票用業務コード");
    }

    @Test
    @TestOrder(80)
    public void testGetDenGyoumuCd_A8() {

        BzGyoumuCdSyutoku bzGyoumuCdSyutoku = SWAKInjector.getInstance(BzGyoumuCdSyutoku.class);

        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;
        C_ShrhousiteiKbn shrhousiteiKbn = C_ShrhousiteiKbn.FB_YOKUJITU;
        String syoricd = "RBA2";
        String syouhncd = "";
        int syouhnsdno = 0;
        C_TantouCdKbn pTantouCd = null;

        String denGyoumuCd = bzGyoumuCdSyutoku.getDenGyoumuCd(shrhousiteiKbn, syoricd, syouhncd, syouhnsdno, tuukasyu, pTantouCd);
        exStringEquals(denGyoumuCd, "00000", "伝票用業務コード");
    }

    @Test
    @TestOrder(90)
    public void testGetDenGyoumuCd_A9() {

        BzGyoumuCdSyutoku bzGyoumuCdSyutoku = SWAKInjector.getInstance(BzGyoumuCdSyutoku.class);

        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;
        C_ShrhousiteiKbn shrhousiteiKbn = C_ShrhousiteiKbn.FB_3EIGYOUBI;
        String syoricd = "RBA2";
        String syouhncd = "";
        int syouhnsdno = 0;
        C_TantouCdKbn pTantouCd = null;

        String denGyoumuCd = bzGyoumuCdSyutoku.getDenGyoumuCd(shrhousiteiKbn, syoricd, syouhncd, syouhnsdno, tuukasyu, pTantouCd);
        exStringEquals(denGyoumuCd, "7270", "伝票用業務コード");
    }

    @Test
    @TestOrder(100)
    public void testGetDenGyoumuCd_A10() {

        BzGyoumuCdSyutoku bzGyoumuCdSyutoku = SWAKInjector.getInstance(BzGyoumuCdSyutoku.class);

        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;
        C_ShrhousiteiKbn shrhousiteiKbn = C_ShrhousiteiKbn.FB_3EIGYOUBI;
        String syoricd = "RB30";
        String syouhncd = "";
        int syouhnsdno = 0;
        C_TantouCdKbn pTantouCd = null;

        String denGyoumuCd = bzGyoumuCdSyutoku.getDenGyoumuCd(shrhousiteiKbn, syoricd, syouhncd, syouhnsdno, tuukasyu, pTantouCd);
        exStringEquals(denGyoumuCd, "00000", "伝票用業務コード");
    }

    @Test
    @TestOrder(110)
    public void testGetDenGyoumuCd_A11() {

        BzGyoumuCdSyutoku bzGyoumuCdSyutoku = SWAKInjector.getInstance(BzGyoumuCdSyutoku.class);

        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;
        C_ShrhousiteiKbn shrhousiteiKbn = C_ShrhousiteiKbn.FB_2EIGYOUBI;
        String syoricd = "RB31";
        String syouhncd = "";
        int syouhnsdno = 0;
        C_TantouCdKbn pTantouCd = null;

        String denGyoumuCd = bzGyoumuCdSyutoku.getDenGyoumuCd(shrhousiteiKbn, syoricd, syouhncd, syouhnsdno, tuukasyu, pTantouCd);
        exStringEquals(denGyoumuCd, "00000", "伝票用業務コード");
    }

    @Test
    @TestOrder(120)
    public void testGetDenGyoumuCd_A12() {

        BzGyoumuCdSyutoku bzGyoumuCdSyutoku = SWAKInjector.getInstance(BzGyoumuCdSyutoku.class);

        C_Tuukasyu tuukasyu = C_Tuukasyu.USD;
        C_ShrhousiteiKbn shrhousiteiKbn = C_ShrhousiteiKbn.FB_2EIGYOUBI;
        String syoricd = "RA43";
        String syouhncd = "";
        int syouhnsdno = 0;
        C_TantouCdKbn pTantouCd = null;

        String denGyoumuCd = bzGyoumuCdSyutoku.getDenGyoumuCd(shrhousiteiKbn, syoricd, syouhncd, syouhnsdno, tuukasyu, pTantouCd);
        exStringEquals(denGyoumuCd, "56500", "伝票用業務コード");
    }

    @Test
    @TestOrder(130)
    public void testGetDenGyoumuCd_A13() {

        BzGyoumuCdSyutoku bzGyoumuCdSyutoku = SWAKInjector.getInstance(BzGyoumuCdSyutoku.class);

        C_Tuukasyu tuukasyu = C_Tuukasyu.USD;
        C_ShrhousiteiKbn shrhousiteiKbn = C_ShrhousiteiKbn.FB_2EIGYOUBI;
        String syoricd = "RB30";
        String syouhncd = "";
        int syouhnsdno = 0;
        C_TantouCdKbn pTantouCd = null;

        String denGyoumuCd = bzGyoumuCdSyutoku.getDenGyoumuCd(shrhousiteiKbn, syoricd, syouhncd, syouhnsdno, tuukasyu, pTantouCd);
        exStringEquals(denGyoumuCd, "51600", "伝票用業務コード");
    }

    @Test
    @TestOrder(140)
    public void testGetDenGyoumuCd_A14() {

        BzGyoumuCdSyutoku bzGyoumuCdSyutoku = SWAKInjector.getInstance(BzGyoumuCdSyutoku.class);

        C_Tuukasyu tuukasyu = C_Tuukasyu.USD;
        C_ShrhousiteiKbn shrhousiteiKbn = C_ShrhousiteiKbn.FB_2EIGYOUBI;
        String syoricd = "RB10";
        String syouhncd = "";
        int syouhnsdno = 0;
        C_TantouCdKbn pTantouCd = null;

        String denGyoumuCd = bzGyoumuCdSyutoku.getDenGyoumuCd(shrhousiteiKbn, syoricd, syouhncd, syouhnsdno, tuukasyu, pTantouCd);
        exStringEquals(denGyoumuCd, "51600", "伝票用業務コード");
    }

    @Test
    @TestOrder(150)
    public void testGetDenGyoumuCd_A15() {

        BzGyoumuCdSyutoku bzGyoumuCdSyutoku = SWAKInjector.getInstance(BzGyoumuCdSyutoku.class);

        C_Tuukasyu tuukasyu = C_Tuukasyu.AUD;
        C_ShrhousiteiKbn shrhousiteiKbn = C_ShrhousiteiKbn.FB_2EIGYOUBI;
        String syoricd = "RB31";
        String syouhncd = "";
        int syouhnsdno = 0;
        C_TantouCdKbn pTantouCd = null;

        String denGyoumuCd = bzGyoumuCdSyutoku.getDenGyoumuCd(shrhousiteiKbn, syoricd, syouhncd, syouhnsdno, tuukasyu, pTantouCd);
        exStringEquals(denGyoumuCd, "51600", "伝票用業務コード");
    }

    @Test
    @TestOrder(160)
    public void testGetDenGyoumuCd_A16() {

        BzGyoumuCdSyutoku bzGyoumuCdSyutoku = SWAKInjector.getInstance(BzGyoumuCdSyutoku.class);

        C_Tuukasyu tuukasyu = C_Tuukasyu.AUD;
        C_ShrhousiteiKbn shrhousiteiKbn = C_ShrhousiteiKbn.FB_2EIGYOUBI;
        String syoricd = "RC06";
        String syouhncd = "";
        int syouhnsdno = 0;
        C_TantouCdKbn pTantouCd = null;

        String denGyoumuCd = bzGyoumuCdSyutoku.getDenGyoumuCd(shrhousiteiKbn, syoricd, syouhncd, syouhnsdno, tuukasyu, pTantouCd);
        exStringEquals(denGyoumuCd, "51600", "伝票用業務コード");
    }

    @Test
    @TestOrder(170)
    public void testGetDenGyoumuCd_A17() {

        BzGyoumuCdSyutoku bzGyoumuCdSyutoku = SWAKInjector.getInstance(BzGyoumuCdSyutoku.class);

        C_Tuukasyu tuukasyu = C_Tuukasyu.AUD;
        C_ShrhousiteiKbn shrhousiteiKbn = C_ShrhousiteiKbn.FB_2EIGYOUBI;
        String syoricd = "RC05";
        String syouhncd = "";
        int syouhnsdno = 0;
        C_TantouCdKbn pTantouCd = null;

        String denGyoumuCd = bzGyoumuCdSyutoku.getDenGyoumuCd(shrhousiteiKbn, syoricd, syouhncd, syouhnsdno, tuukasyu, pTantouCd);
        exStringEquals(denGyoumuCd, "51600", "伝票用業務コード");
    }

    @Test
    @TestOrder(180)
    public void testGetDenGyoumuCd_A18() {

        BzGyoumuCdSyutoku bzGyoumuCdSyutoku = SWAKInjector.getInstance(BzGyoumuCdSyutoku.class);

        C_Tuukasyu tuukasyu = C_Tuukasyu.AUD;
        C_ShrhousiteiKbn shrhousiteiKbn = C_ShrhousiteiKbn.FB_2EIGYOUBI;
        String syoricd = "RB75";
        String syouhncd = "";
        int syouhnsdno = 0;
        C_TantouCdKbn pTantouCd = null;

        String denGyoumuCd = bzGyoumuCdSyutoku.getDenGyoumuCd(shrhousiteiKbn, syoricd, syouhncd, syouhnsdno, tuukasyu, pTantouCd);
        exStringEquals(denGyoumuCd, "00000", "伝票用業務コード");
    }

    @Test
    @TestOrder(190)
    public void testGetDenGyoumuCd_A19() {

        BzGyoumuCdSyutoku bzGyoumuCdSyutoku = SWAKInjector.getInstance(BzGyoumuCdSyutoku.class);

        C_Tuukasyu tuukasyu = C_Tuukasyu.AUD;
        C_ShrhousiteiKbn shrhousiteiKbn = C_ShrhousiteiKbn.FB_3EIGYOUBI;
        String syoricd = "RA43";
        String syouhncd = "";
        int syouhnsdno = 0;
        C_TantouCdKbn pTantouCd = null;

        String denGyoumuCd = bzGyoumuCdSyutoku.getDenGyoumuCd(shrhousiteiKbn, syoricd, syouhncd, syouhnsdno, tuukasyu, pTantouCd);
        exStringEquals(denGyoumuCd, "00000", "伝票用業務コード");
    }

    @Test
    @TestOrder(200)
    public void testGetDenGyoumuCd_A20() {

        BzGyoumuCdSyutoku bzGyoumuCdSyutoku = SWAKInjector.getInstance(BzGyoumuCdSyutoku.class);

        C_Tuukasyu tuukasyu = C_Tuukasyu.EUR;
        C_ShrhousiteiKbn shrhousiteiKbn = C_ShrhousiteiKbn.FB_3EIGYOUBI;
        String syoricd = "RA43";
        String syouhncd = "";
        int syouhnsdno = 0;
        C_TantouCdKbn pTantouCd = null;

        String denGyoumuCd = bzGyoumuCdSyutoku.getDenGyoumuCd(shrhousiteiKbn, syoricd, syouhncd, syouhnsdno, tuukasyu, pTantouCd);
        exStringEquals(denGyoumuCd, "00000", "伝票用業務コード");
    }

    @Test
    @TestOrder(210)
    public void testGetDenGyoumuCd_A21() {

        BzGyoumuCdSyutoku bzGyoumuCdSyutoku = SWAKInjector.getInstance(BzGyoumuCdSyutoku.class);

        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;
        C_ShrhousiteiKbn shrhousiteiKbn = C_ShrhousiteiKbn.FB_YOKUJITU;
        String syoricd = "RB76";
        String syouhncd = "";
        int syouhnsdno = 0;
        C_TantouCdKbn pTantouCd = null;

        String denGyoumuCd = bzGyoumuCdSyutoku.getDenGyoumuCd(shrhousiteiKbn, syoricd, syouhncd, syouhnsdno, tuukasyu, pTantouCd);
        exStringEquals(denGyoumuCd, "9943", "伝票用業務コード");
    }

    @Test
    @TestOrder(220)
    public void testGetDenGyoumuCd_A22() {

        BzGyoumuCdSyutoku bzGyoumuCdSyutoku = SWAKInjector.getInstance(BzGyoumuCdSyutoku.class);

        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;
        C_ShrhousiteiKbn shrhousiteiKbn = C_ShrhousiteiKbn.FB_YOKUJITU;
        String syoricd = "RD36";
        String syouhncd = "";
        int syouhnsdno = 0;
        C_TantouCdKbn pTantouCd = null;

        String denGyoumuCd = bzGyoumuCdSyutoku.getDenGyoumuCd(shrhousiteiKbn, syoricd, syouhncd, syouhnsdno, tuukasyu, pTantouCd);
        exStringEquals(denGyoumuCd, "9943", "伝票用業務コード");
    }

    @Test
    @TestOrder(230)
    public void testGetDenGyoumuCd_A23() {

        BzGyoumuCdSyutoku bzGyoumuCdSyutoku = SWAKInjector.getInstance(BzGyoumuCdSyutoku.class);

        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;
        C_ShrhousiteiKbn shrhousiteiKbn = C_ShrhousiteiKbn.FB_3EIGYOUBI;
        String syoricd = "RDHU";
        String syouhncd = "";
        int syouhnsdno = 0;
        C_TantouCdKbn pTantouCd = null;

        String denGyoumuCd = bzGyoumuCdSyutoku.getDenGyoumuCd(shrhousiteiKbn, syoricd, syouhncd, syouhnsdno, tuukasyu, pTantouCd);
        exStringEquals(denGyoumuCd, "5536", "伝票用業務コード");
    }

    @Test
    @TestOrder(240)
    public void testGetDenGyoumuCd_A24() {

        BzGyoumuCdSyutoku bzGyoumuCdSyutoku = SWAKInjector.getInstance(BzGyoumuCdSyutoku.class);

        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;
        C_ShrhousiteiKbn shrhousiteiKbn = C_ShrhousiteiKbn.FB_3EIGYOUBI;
        String syoricd = "RDMU";
        String syouhncd = "";
        int syouhnsdno = 0;
        C_TantouCdKbn pTantouCd = null;

        String denGyoumuCd = bzGyoumuCdSyutoku.getDenGyoumuCd(shrhousiteiKbn, syoricd, syouhncd, syouhnsdno, tuukasyu, pTantouCd);
        exStringEquals(denGyoumuCd, "9942", "伝票用業務コード");
    }

    @Test
    @TestOrder(250)
    public void testGetDenGyoumuCd_A25() {

        BzGyoumuCdSyutoku bzGyoumuCdSyutoku = SWAKInjector.getInstance(BzGyoumuCdSyutoku.class);

        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;
        C_ShrhousiteiKbn shrhousiteiKbn = C_ShrhousiteiKbn.FB_SOUDAIKAI_YOKUEI;
        String syoricd = "RBD4";
        String syouhncd = "";
        int syouhnsdno = 0;
        C_TantouCdKbn pTantouCd = C_TantouCdKbn.KAIYAKU;

        String denGyoumuCd = bzGyoumuCdSyutoku.getDenGyoumuCd(shrhousiteiKbn, syoricd, syouhncd, syouhnsdno, tuukasyu, pTantouCd);
        exStringEquals(denGyoumuCd, "9944", "伝票用業務コード");
    }

    @Test
    @TestOrder(260)
    public void testGetDenGyoumuCd_A26() {

        BzGyoumuCdSyutoku bzGyoumuCdSyutoku = SWAKInjector.getInstance(BzGyoumuCdSyutoku.class);

        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;
        C_ShrhousiteiKbn shrhousiteiKbn = C_ShrhousiteiKbn.FB_SOUDAIKAI_YOKUEI;
        String syoricd = "RBD4";
        String syouhncd = "";
        int syouhnsdno = 0;
        C_TantouCdKbn pTantouCd = C_TantouCdKbn.SIBOUTETUZUKI;

        String denGyoumuCd = bzGyoumuCdSyutoku.getDenGyoumuCd(shrhousiteiKbn, syoricd, syouhncd, syouhnsdno, tuukasyu, pTantouCd);
        exStringEquals(denGyoumuCd, "9961", "伝票用業務コード");
    }

    @Test
    @TestOrder(270)
    public void testGetDenGyoumuCd_A27() {

        BzGyoumuCdSyutoku bzGyoumuCdSyutoku = SWAKInjector.getInstance(BzGyoumuCdSyutoku.class);

        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;
        C_ShrhousiteiKbn shrhousiteiKbn = C_ShrhousiteiKbn.FB_SOUDAIKAI_YOKUEI;
        String syoricd = "RBD4";
        String syouhncd = "";
        int syouhnsdno = 0;
        C_TantouCdKbn pTantouCd = C_TantouCdKbn.NENKIN;

        String denGyoumuCd = bzGyoumuCdSyutoku.getDenGyoumuCd(shrhousiteiKbn, syoricd, syouhncd, syouhnsdno, tuukasyu, pTantouCd);
        exStringEquals(denGyoumuCd, "00000", "伝票用業務コード");
    }

    @Test
    @TestOrder(280)
    public void testGetDenGyoumuCd_A28() {

        BzGyoumuCdSyutoku bzGyoumuCdSyutoku = SWAKInjector.getInstance(BzGyoumuCdSyutoku.class);

        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;
        C_ShrhousiteiKbn shrhousiteiKbn = C_ShrhousiteiKbn.FB_SOUDAIKAI_YOKUEI;
        String syoricd = "RB30";
        String syouhncd = "";
        int syouhnsdno = 0;
        C_TantouCdKbn pTantouCd = null;

        String denGyoumuCd = bzGyoumuCdSyutoku.getDenGyoumuCd(shrhousiteiKbn, syoricd, syouhncd, syouhnsdno, tuukasyu, pTantouCd);
        exStringEquals(denGyoumuCd, "00000", "伝票用業務コード");
    }

    @Test
    @TestOrder(290)
    public void testGetDenGyoumuCd_A29() {

        BzGyoumuCdSyutoku bzGyoumuCdSyutoku = SWAKInjector.getInstance(BzGyoumuCdSyutoku.class);

        C_Tuukasyu tuukasyu = C_Tuukasyu.AUD;
        C_ShrhousiteiKbn shrhousiteiKbn = C_ShrhousiteiKbn.FB_SOUDAIKAI_YOKUEI;
        String syoricd = "RBD4";
        String syouhncd = "";
        int syouhnsdno = 0;
        C_TantouCdKbn pTantouCd = C_TantouCdKbn.KAIYAKU;

        String denGyoumuCd = bzGyoumuCdSyutoku.getDenGyoumuCd(shrhousiteiKbn, syoricd, syouhncd, syouhnsdno, tuukasyu, pTantouCd);
        exStringEquals(denGyoumuCd, "51601", "伝票用業務コード");
    }

    @Test
    @TestOrder(300)
    public void testGetDenGyoumuCd_A30() {

        BzGyoumuCdSyutoku bzGyoumuCdSyutoku = SWAKInjector.getInstance(BzGyoumuCdSyutoku.class);

        C_Tuukasyu tuukasyu = C_Tuukasyu.AUD;
        C_ShrhousiteiKbn shrhousiteiKbn = C_ShrhousiteiKbn.FB_SOUDAIKAI_YOKUEI;
        String syoricd = "RBD4";
        String syouhncd = "";
        int syouhnsdno = 0;
        C_TantouCdKbn pTantouCd = C_TantouCdKbn.SIBOUTETUZUKI;

        String denGyoumuCd = bzGyoumuCdSyutoku.getDenGyoumuCd(shrhousiteiKbn, syoricd, syouhncd, syouhnsdno, tuukasyu, pTantouCd);
        exStringEquals(denGyoumuCd, "56400", "伝票用業務コード");
    }

    @Test
    @TestOrder(310)
    public void testGetDenGyoumuCd_A31() {

        BzGyoumuCdSyutoku bzGyoumuCdSyutoku = SWAKInjector.getInstance(BzGyoumuCdSyutoku.class);

        C_Tuukasyu tuukasyu = C_Tuukasyu.AUD;
        C_ShrhousiteiKbn shrhousiteiKbn = C_ShrhousiteiKbn.FB_SOUDAIKAI_YOKUEI;
        String syoricd = "RBD4";
        String syouhncd = "";
        int syouhnsdno = 0;
        C_TantouCdKbn pTantouCd = C_TantouCdKbn.NENKIN;

        String denGyoumuCd = bzGyoumuCdSyutoku.getDenGyoumuCd(shrhousiteiKbn, syoricd, syouhncd, syouhnsdno, tuukasyu, pTantouCd);
        exStringEquals(denGyoumuCd, "00000", "伝票用業務コード");
    }

    @Test
    @TestOrder(320)
    public void testGetDenGyoumuCd_A32() {

        BzGyoumuCdSyutoku bzGyoumuCdSyutoku = SWAKInjector.getInstance(BzGyoumuCdSyutoku.class);

        C_Tuukasyu tuukasyu = C_Tuukasyu.AUD;
        C_ShrhousiteiKbn shrhousiteiKbn = C_ShrhousiteiKbn.FB_SOUDAIKAI_YOKUEI;
        String syoricd = "RB30";
        String syouhncd = "";
        int syouhnsdno = 0;
        C_TantouCdKbn pTantouCd = null;

        String denGyoumuCd = bzGyoumuCdSyutoku.getDenGyoumuCd(shrhousiteiKbn, syoricd, syouhncd, syouhnsdno, tuukasyu, pTantouCd);
        exStringEquals(denGyoumuCd, "00000", "伝票用業務コード");
    }

    @Test
    @TestOrder(330)
    public void testGetDenGyoumuCd_A33() {

        BzGyoumuCdSyutoku bzGyoumuCdSyutoku = SWAKInjector.getInstance(BzGyoumuCdSyutoku.class);

        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;
        C_ShrhousiteiKbn shrhousiteiKbn = C_ShrhousiteiKbn.FB_YOKUJITU;
        String syoricd = "RB32";
        String syouhncd = "";
        int syouhnsdno = 0;
        C_TantouCdKbn pTantouCd = null;

        String denGyoumuCd = bzGyoumuCdSyutoku.getDenGyoumuCd(shrhousiteiKbn, syoricd, syouhncd, syouhnsdno, tuukasyu, pTantouCd);
        exStringEquals(denGyoumuCd, "9943", "伝票用業務コード");
    }

    @Test
    @TestOrder(340)
    public void testGetDenGyoumuCd_A34() {

        BzGyoumuCdSyutoku bzGyoumuCdSyutoku = SWAKInjector.getInstance(BzGyoumuCdSyutoku.class);

        C_Tuukasyu tuukasyu = C_Tuukasyu.USD;
        C_ShrhousiteiKbn shrhousiteiKbn = C_ShrhousiteiKbn.FB_2EIGYOUBI;
        String syoricd = "RB32";
        String syouhncd = "";
        int syouhnsdno = 0;
        C_TantouCdKbn pTantouCd = null;

        String denGyoumuCd = bzGyoumuCdSyutoku.getDenGyoumuCd(shrhousiteiKbn, syoricd, syouhncd, syouhnsdno, tuukasyu, pTantouCd);
        exStringEquals(denGyoumuCd, "51600", "伝票用業務コード");
    }
}
