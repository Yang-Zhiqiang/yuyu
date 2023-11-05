package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhnRireki;
import yuyu.def.db.entity.IT_SyouhnTokujouRireki;

/**
 * 契約商品履歴TBL編集{@link EditKykSyhnRirekiTbl}のモッククラスです<br />
 */
public class EditKykSyhnRirekiTblMockForHozen extends EditKykSyhnRirekiTbl {

    public static final String TESTPATTERN1 = "1";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public void exec(KhozenCommonParam pKCParm, String pSyoNo, C_SyutkKbn pSyuTkKbn,
        String pSyouhnCd, int pSyouhnSdNo, int pSyouhnRenNo) {

        super.exec(pKCParm, pSyoNo, pSyuTkKbn, pSyouhnCd, pSyouhnSdNo, pSyouhnRenNo);
    }

    @Override
    public void exec(KhozenCommonParam pKCParm, String pSyoNo) {

        if (caller == EditKaiyakuTblUpdateTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                IT_KykKihon kykKihon = pKCParm.getBatchKeiyakuKihon();
                if (kykKihon != null) {
                    IT_KykSyouhnRireki kykSyouhnRireki = kykKihon.getKhTtdkRirekis().get(0).createKykSyouhnRireki();
                    kykSyouhnRireki.setSyutkkbn(C_SyutkKbn.SYU);
                    kykSyouhnRireki.setSyouhncd("ﾕﾁ");
                    kykSyouhnRireki.setSyouhnsdno(1);
                    kykSyouhnRireki.setKyksyouhnrenno(2);
                    IT_SyouhnTokujouRireki syouhnTokujouRireki = kykKihon.getKhTtdkRirekis().get(0)
                        .createSyouhnTokujouRireki();
                    syouhnTokujouRireki.setSyutkkbn(C_SyutkKbn.SYU);
                    syouhnTokujouRireki.setSyouhncd("ﾕﾁ");
                    syouhnTokujouRireki.setSyouhnsdno(1);
                    syouhnTokujouRireki.setKyksyouhnrenno(2);
                }
                return;
            }
        }

        super.exec(pKCParm, pSyoNo);
    }

    @Override
    public void exec(KhozenCommonParam pKCParm,
        String pSyoNo,
        C_SyutkKbn pSyuTkKbn,
        String pSyouhnCd,
        int pSyouhnSdNo,
        int pSyouhnRenNo,
        C_Syoumetujiyuu pSyoumetuJiyuu,
        BizDate pSyoumetuYmd,
        BizDate pKouryokuhasseiYmd) {

        super.exec(pKCParm, pSyoNo, pSyuTkKbn, pSyouhnCd, pSyouhnSdNo, pSyouhnRenNo, pSyoumetuJiyuu, pSyoumetuYmd,
            pKouryokuhasseiYmd);
    }
}
