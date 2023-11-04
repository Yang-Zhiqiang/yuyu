package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.number.BizCurrency;
import yuyu.common.hozen.setuibean.SetHaraikomiInfoTest_exec;
import yuyu.def.classification.C_ErrorKbn;

/**
 * {@link SyouhntaniKousingoPkeisan}のモッククラスです。<br />
 */
public class SyouhntaniKousingoPkeisanMockForKhansyuu extends SyouhntaniKousingoPkeisan {

    public static String SYORIPTN = null;

    public static Class<?> caller = null;

    private String syouhnCd;

    public String getSyouhnCd() {
        return syouhnCd;
    }

    @Override
    public void setSyouhncd(String pSyouhncd) {
        syouhnCd = pSyouhncd;
    }

    @Override
    public KousinBean[] getKosnaiymeiskmk() {

        if (caller == SetHaraikomiInfoTest_exec.class) {

            if ("1001".equals(getSyouhnCd())) {

                KousinBean[] kosnaiyMeisKmks1 = new KousinBean[1];

                KousinBean kousinBean = new KousinBean();
                kousinBean.setHknry(BizCurrency.valueOf(1));
                kosnaiyMeisKmks1[0] =kousinBean;

                return kosnaiyMeisKmks1;

            }

            if ("7890".equals(getSyouhnCd())) {

                KousinBean[] kosnaiyMeisKmks2 = new KousinBean[2];

                KousinBean kousinBean1 = new KousinBean();
                kousinBean1.setHknry(BizCurrency.valueOf(2));
                kosnaiyMeisKmks2[0] =kousinBean1;

                KousinBean kousinBean2 = new KousinBean();
                kousinBean2.setHknry(BizCurrency.valueOf(1));
                kosnaiyMeisKmks2[1] =kousinBean2;

                return kosnaiyMeisKmks2;
            }
        }
        return super.getKosnaiymeiskmk();
    }

    @Override
    public int getKoskaisu() {

        if (caller == SetHaraikomiInfoTest_exec.class) {

            if ("1234".equals(getSyouhnCd())) {
                return 0;
            }

            if ("1001".equals(getSyouhnCd())) {
                return 1;
            }

            if ("2345".equals(getSyouhnCd())) {
                return 0;
            }

            if ("1002".equals(getSyouhnCd())) {
                return 0;
            }

            if ("7890".equals(getSyouhnCd())) {
                return 2;
            }
        }
        return super.getKoskaisu();
    }

    @Override
    public C_ErrorKbn exec() {
        if (caller == SetHaraikomiInfoTest_exec.class) {
            return C_ErrorKbn.OK;
        }

        C_ErrorKbn errorKbn = super.exec();

        return errorKbn;
    }

}
