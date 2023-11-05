package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_TsrysyoriKbn;
import yuyu.def.db.entity.IT_BAK_KykKihon;

/**
 * 代理店手数料情報TBL編集のモッククラスです。<br />
 */
public class EditDairitenTesuuryouTblMockForKhansyuu extends EditDairitenTesuuryouTbl {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    private BizDate batchSyoriYmd;

    @Override
    public void setBatchSyoriYmd(BizDate pBatchSyoriYmd) {
        batchSyoriYmd = pBatchSyoriYmd;
    }

    @Override
    public void exec(KhozenCommonParam pKhozenCommonParam, String pSyoNo, C_TsrysyoriKbn pTsrySyoriKbn,
        BizDateYM pKouryokuHasseiYM, int pNyknKaisuuY, int pNyknKaisuuM, BizCurrency pMikeikaP,
        BizCurrency pIktP, IT_BAK_KykKihon pBakKykKihon) {

        exec(pKhozenCommonParam, pSyoNo, pTsrySyoriKbn, pKouryokuHasseiYM, pNyknKaisuuY, pNyknKaisuuM,
            pMikeikaP, pIktP, null, pBakKykKihon);
    }

    @Override
    public void exec(KhozenCommonParam pKhozenCommonParam, String pSyoNo, C_TsrysyoriKbn pTsrySyoriKbn,
        BizDateYM pKouryokuHasseiYM, int pNyknKaisuuY, int pNyknKaisuuM, BizCurrency pMikeikaP,
        BizCurrency pIktP, BizDate pNyknYMD, IT_BAK_KykKihon pBakKykKihon) {

        if (caller == CommonNyuukinTest_exec1.class ||
            caller == CommonNyuukinTest_exec3.class ||
            caller == CommonNyuukinTest_exec4.class ||
            caller == CommonNyuukinTest_exec5.class ||
            caller == CommonNyuukinTest_exec7.class ||
            caller == EditKaiyakuTblUpdateTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                return;
            }
        }

        super.exec(pKhozenCommonParam, pSyoNo, pTsrySyoriKbn, pKouryokuHasseiYM, pNyknKaisuuY, pNyknKaisuuM, pMikeikaP, pIktP, pNyknYMD, pBakKykKihon);
    }
}
