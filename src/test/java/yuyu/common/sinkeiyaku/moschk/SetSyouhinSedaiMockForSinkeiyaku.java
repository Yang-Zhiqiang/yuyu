package yuyu.common.sinkeiyaku.moschk;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;

/**
 * {@link SetSyouhinSedai}のモッククラスです。<br />
 */
public class SetSyouhinSedaiMockForSinkeiyaku extends SetSyouhinSedai{

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    @Override
    public void exec(MosnaiCheckParam pMp, BizDate pKykYmd) {

        if (caller == SetKisoKoumokuTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
                HT_SyoriCTL syoriCTL15 = sinkeiyakuDomManager.getSyoriCTL("791112360");
                HT_MosSyouhn mosSyouhn = syoriCTL15.createMosSyouhn();
                mosSyouhn.setSyouhncd("ｱ1");
                mosSyouhn.setSyouhnsdno(2);
                mosSyouhn.setSyutkkbn(C_SyutkKbn.SYU);

                return;
            }

            return;
        }

        super.exec(pMp, pKykYmd);
    }

}
