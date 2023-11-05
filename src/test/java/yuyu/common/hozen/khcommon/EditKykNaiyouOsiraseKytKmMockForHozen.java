package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.def.MessageId;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.ZT_GaikaKokyakuTuutiTy;

/**
 * {@link EditKykNaiyouOsiraseKytKm}のモッククラスです<br />
 */
public class EditKykNaiyouOsiraseKytKmMockForHozen extends EditKykNaiyouOsiraseKytKm {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    C_ErrorKbn getBizLogicErrorKbn() {
        if (caller == EditKykNaiyouOsiraseTest_editInfo.class) {

            if (TESTPATTERN2.equals(SYORIPTN)) {

                return C_ErrorKbn.ERROR;
            }
        }
        return super.getBizLogicErrorKbn();
    }

    @Override
    public String getBizLogicErrorMsg() {

        if (caller == EditKykNaiyouOsiraseTest_editInfo.class) {

            if (TESTPATTERN2.equals(SYORIPTN)) {

                return MessageUtil.getMessage(MessageId.EBA1048);
            }
        }
        return super.getBizLogicErrorMsg();
    }


    @Override
    public ZT_GaikaKokyakuTuutiTy editDsTourokuJyou(
        String pSyono,
        BizDate pSyoriYmd,
        ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTy) {

        if (caller == EditKykNaiyouOsiraseTest_editInfo.class) {

            pGaikaKokyakuTuutiTy.setZtydstourokujyou("3");
            pGaikaKokyakuTuutiTy.setZtysd1msgcd("07003");
            pGaikaKokyakuTuutiTy.setZtysd2msgcd("07004");
            pGaikaKokyakuTuutiTy.setZtysd3msgcd("07005");
            pGaikaKokyakuTuutiTy.setZtykrpassword("ztykrpassword");
            pGaikaKokyakuTuutiTy.setZtyyuukoukigenwareki("平成30年11月 5日");

            return pGaikaKokyakuTuutiTy;
        }

        return super.editDsTourokuJyou(pSyono, pSyoriYmd, pGaikaKokyakuTuutiTy);
    }

    @Override
    public ZT_GaikaKokyakuTuutiTy editInfo(
        IT_KykKihon pKykKihon,
        BizDate pSyoriYmd,
        BizDate pKykoutoubi,
        String pSyouhnHanmeiKbn,
        ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTy,
        int pYobidasimotoKbn) {

        if (caller == EditKykNaiyouOsiraseTest_editInfo.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                pGaikaKokyakuTuutiTy.setZtytyouhyouymd("20180101");
                pGaikaKokyakuTuutiTy.setZtysyono("17806000013");
                pGaikaKokyakuTuutiTy.setZtysclatosyono("17806000013");
                pGaikaKokyakuTuutiTy.setZtyhassoukbn("1");
                pGaikaKokyakuTuutiTy.setZtydskaiyktirasidouhuukbn("1");
                return pGaikaKokyakuTuutiTy;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                return null;
            }
        }
        return super.editInfo(pKykKihon, pSyoriYmd, pKykoutoubi,pSyouhnHanmeiKbn, pGaikaKokyakuTuutiTy, pYobidasimotoKbn);
    }

}
