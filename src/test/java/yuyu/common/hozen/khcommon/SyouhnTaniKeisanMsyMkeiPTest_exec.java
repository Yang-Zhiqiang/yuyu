package yuyu.common.hozen.khcommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_6daiLdKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_KataKbn;
import yuyu.def.classification.C_KhnkyhkgbairituKbn;
import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_PmnjtkKbn;
import yuyu.def.classification.C_SyukyhkinkataKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * （商品単位）未収Ｐ・未経過Ｐ計算クラスのメソッド{@link SyouhnTaniKeisanMsyMkeiP#exec()} テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class SyouhnTaniKeisanMsyMkeiPTest_exec {

    @Inject
    private SyouhnTaniKeisanMsyMkeiP syouhnTaniKeisanMsyMkeiP;

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        syouhnTaniKeisanMsyMkeiP.setKeiyakubi(BizDate.valueOf(20150727));
        syouhnTaniKeisanMsyMkeiP.setKeisanYMD(BizDate.valueOf(20150727));
        syouhnTaniKeisanMsyMkeiP.setSyono("17806000013");
        syouhnTaniKeisanMsyMkeiP.setJkipJytYM(BizDateYM.valueOf(201507));
        syouhnTaniKeisanMsyMkeiP.setJskJkipJytYM(BizDateYM.valueOf(201601));
        syouhnTaniKeisanMsyMkeiP.setP(BizCurrency.valueOf(400));
        syouhnTaniKeisanMsyMkeiP.setDenymd(BizDate.valueOf(20150727));
        syouhnTaniKeisanMsyMkeiP.setHaraimanYMD(BizDate.valueOf(20151231));
        syouhnTaniKeisanMsyMkeiP.setHrkKaisuu(C_Hrkkaisuu.NEN);
        syouhnTaniKeisanMsyMkeiP.setHoseihrkkgt(null);
        syouhnTaniKeisanMsyMkeiP.setYuukousyoumetukbn(C_YuukousyoumetuKbn.SYOUMETU);
        syouhnTaniKeisanMsyMkeiP.setKykjyoutai(C_Kykjyoutai.HRKMTYUU);
        syouhnTaniKeisanMsyMkeiP.setHrkKeiro(C_Hrkkeiro.DANTAI);

        syouhnTaniKeisanMsyMkeiP.setSyouhncd("T110");
        syouhnTaniKeisanMsyMkeiP.setSyouhnSdno(Integer.valueOf(1));
        syouhnTaniKeisanMsyMkeiP.setKatakbn(C_KataKbn.HONNIN_TUMA);
        syouhnTaniKeisanMsyMkeiP.setSyukyhkinKatakbn(C_SyukyhkinkataKbn.SYU2);
        syouhnTaniKeisanMsyMkeiP.setKhnkyhkgbairituKbn(C_KhnkyhkgbairituKbn.NIBAI);
        syouhnTaniKeisanMsyMkeiP.setRokuDaisktsyknTuikakyhKatakbn(C_6daiLdKbn.NONE);
        syouhnTaniKeisanMsyMkeiP.setPmnjtkhukaKbn(C_PmnjtkKbn.SANDAISIPPMNJTOK);
        syouhnTaniKeisanMsyMkeiP.setKyhgndKatakbn(C_KyhgndkataKbn.TYPE120);
        syouhnTaniKeisanMsyMkeiP.setHknkknSmnkbn(C_HknkknsmnKbn.NENMANKI);
        syouhnTaniKeisanMsyMkeiP.setHknkkn(Integer.valueOf(8));
        syouhnTaniKeisanMsyMkeiP.setHrkkknSmnkbn(C_HrkkknsmnKbn.NENMANKI);
        syouhnTaniKeisanMsyMkeiP.setHrkkkn(Integer.valueOf(7));
        syouhnTaniKeisanMsyMkeiP.setHhknNen(Integer.valueOf(26));
        syouhnTaniKeisanMsyMkeiP.setHhknSei(C_Hhknsei.FEMALE);
        syouhnTaniKeisanMsyMkeiP.setS(BizCurrency.valueOf(100000));

        syouhnTaniKeisanMsyMkeiP.exec();

        exBizCalcbleEquals(syouhnTaniKeisanMsyMkeiP.getMisyuP(), BizCurrency.valueOf(0), "未収Ｐ");
        exNumericEquals(syouhnTaniKeisanMsyMkeiP.getMisyuPJyutouKaisuuY(), 0, "未収Ｐ充当回数（年）");
        exNumericEquals(syouhnTaniKeisanMsyMkeiP.getMisyuPJyutouKaisuuM(), 0, "未収Ｐ充当回数（月）");
        exDateYMEquals(syouhnTaniKeisanMsyMkeiP.getMisyuPJyutouYM(), null, "未収Ｐ充当年月");
        assertNull(syouhnTaniKeisanMsyMkeiP.getMisyuuPBeans());

        exBizCalcbleEquals(syouhnTaniKeisanMsyMkeiP.getMikeikaP(), BizCurrency.valueOf(0), "未経過Ｐ");
        exNumericEquals(syouhnTaniKeisanMsyMkeiP.getMikeikaPJyutouKaisuuY(), 0, "未経過Ｐ充当回数（年）");
        exNumericEquals(syouhnTaniKeisanMsyMkeiP.getMikeikaPJyutouKaisuuM(), 0, "未経過Ｐ充当回数（月）");
        exDateYMEquals(syouhnTaniKeisanMsyMkeiP.getMikeikaPJyutouYM(), null, "未経過Ｐ充当年月");
        assertNull(syouhnTaniKeisanMsyMkeiP.getMiKeikaPBeans());
    }
}
