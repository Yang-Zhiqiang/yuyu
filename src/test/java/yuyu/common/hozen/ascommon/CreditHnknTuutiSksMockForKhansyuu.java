package yuyu.common.hozen.ascommon;

import yuyu.common.hozen.khcommon.CommonNyuukinTest_exec3;
import yuyu.common.hozen.khcommon.CommonNyuukinTest_exec4;
import yuyu.common.hozen.khcommon.CommonNyuukinTest_exec5;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.db.entity.IT_SyuunouHenknRireki;

/**
 * {@link CreditHnknTuutiSks}のモッククラスです。<br />
 */
public class CreditHnknTuutiSksMockForKhansyuu extends CreditHnknTuutiSks {

    private IT_SyuunouHenknRireki syuunouHenknRireki;

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    @Override
    public IT_SyuunouHenknRireki getSyuunouHenknRireki() {

        if (caller == CommonNyuukinTest_exec3.class ||
            caller == CommonNyuukinTest_exec4.class ||
            caller == CommonNyuukinTest_exec5.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return syuunouHenknRireki;
            }
        }
        return super.getSyuunouHenknRireki();
    }
    @Override
    public void exec(KhozenCommonParam pKhozenCommonParam, CreditHnknTuutiSksParam pCreditHnknTuutiSksParam) {

        if (caller == CommonNyuukinTest_exec3.class ||
            caller == CommonNyuukinTest_exec4.class ||
            caller == CommonNyuukinTest_exec5.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                syuunouHenknRireki = new IT_SyuunouHenknRireki();
                syuunouHenknRireki.setSyono(pCreditHnknTuutiSksParam.getKykKihon().getSyono());
                syuunouHenknRireki.setDenrenno("100001");
                syuunouHenknRireki.setEdano(pCreditHnknTuutiSksParam.getEdano());
                syuunouHenknRireki.setDenkihyouymd(pCreditHnknTuutiSksParam.getDenymd());
                syuunouHenknRireki.setShrymd(pCreditHnknTuutiSksParam.getUriageseikyuuymd());
                syuunouHenknRireki.setKanjyoukmkcd(pCreditHnknTuutiSksParam.getKanjyoukmkcd());
                syuunouHenknRireki.setHnkngk(pCreditHnknTuutiSksParam.getHnkngk());
                syuunouHenknRireki.setCreditkessaiyouno(pCreditHnknTuutiSksParam.getCreditkessaiyouno());
            }
        }
        super.exec(pKhozenCommonParam, pCreditHnknTuutiSksParam);
    }
}
