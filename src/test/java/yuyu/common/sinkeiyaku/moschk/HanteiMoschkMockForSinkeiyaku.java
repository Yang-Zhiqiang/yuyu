package yuyu.common.sinkeiyaku.moschk;

import java.util.List;

import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_MosKihon;

/**
 * {@link HanteiMoschk}のモッククラスです。<br />
 */
public class HanteiMoschkMockForSinkeiyaku extends HanteiMoschk {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static final String TESTPATTERN7 = "7";

    public static final String TESTPATTERN8 = "8";

    public static final String TESTPATTERN9 = "9";

    public static final String TESTPATTERN10 = "10";

    public static final String TESTPATTERN11 = "11";

    @Override
    public C_BlnktkumuKbn hanteiSpCheckKingakuSouiJissiyouhi(BM_SyouhnZokusei pSyouhnZokuseiSyu,
        List<BM_SyouhnZokusei> pSyouhnZokuseiTkList, HT_MosKihon pMosKihon) {

        if (caller == CheckHokenRyouYuukouKigenTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                return C_BlnktkumuKbn.ARI;
            }
            else if (TESTPATTERN11.equals(SYORIPTN)) {

                return C_BlnktkumuKbn.BLNK;
            }

            return C_BlnktkumuKbn.NONE;
        }

        if (caller == CheckSPTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_BlnktkumuKbn.ARI;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_BlnktkumuKbn.NONE;
            }
            else if (TESTPATTERN5.equals(SYORIPTN) || TESTPATTERN6.equals(SYORIPTN)) {
                return C_BlnktkumuKbn.NONE;
            }

        }
        return super.hanteiSpCheckKingakuSouiJissiyouhi(pSyouhnZokuseiSyu, pSyouhnZokuseiTkList, pMosKihon);
    }

    @Override
    public C_YouhiKbn hanteiKykNenreiUpSekininkaisiNasiTyuui(BM_SyouhnZokusei pSyouhnZokuseiSyu,
        List<BM_SyouhnZokusei> pSyouhnZokuseiTkList, HT_MosKihon pMosKihon) {

        if (caller == CheckHokenRyouYuukouKigenTest_exec.class) {

            if (TESTPATTERN3.equals(SYORIPTN) || TESTPATTERN4.equals(SYORIPTN)) {

                return C_YouhiKbn.YOU;
            }

            return C_YouhiKbn.HUYOU;

        }

        return super.hanteiKykNenreiUpSekininkaisiNasiTyuui(pSyouhnZokuseiSyu, pSyouhnZokuseiTkList, pMosKihon);
    }

    @Override
    public C_YouhiKbn hanteiKykNenreiUpSekininkaisiNasiKeikoku(BM_SyouhnZokusei pSyouhnZokuseiSyu,
        List<BM_SyouhnZokusei> pSyouhnZokuseiTkList, HT_MosKihon pMosKihon) {

        if (caller == CheckHokenRyouYuukouKigenTest_exec.class) {

            if (TESTPATTERN4.equals(SYORIPTN) || TESTPATTERN5.equals(SYORIPTN)) {
                return C_YouhiKbn.YOU;
            }

            return C_YouhiKbn.HUYOU;
        }
        return super.hanteiKykNenreiUpSekininkaisiNasiKeikoku(pSyouhnZokuseiSyu, pSyouhnZokuseiTkList, pMosKihon);
    }

    @Override
    public C_YouhiKbn hanteiYoteirirituHendouGetYoteiriritu(BM_SyouhnZokusei pSyouhnZokuseiSyu,
        List<BM_SyouhnZokusei> pSyouhnZokuseiTkList) {

        if (caller == CheckHokenRyouYuukouKigenTest_exec.class) {
            if (TESTPATTERN6.equals(SYORIPTN)) {

                return C_YouhiKbn.YOU;
            }

            return C_YouhiKbn.HUYOU;
        }
        return super.hanteiYoteirirituHendouGetYoteiriritu(pSyouhnZokuseiSyu, pSyouhnZokuseiTkList);
    }

    @Override
    public C_YouhiKbn hanteiYoteirirituHendouGetTumitateriritu(BM_SyouhnZokusei pSyouhnZokuseiSyu,
        List<BM_SyouhnZokusei> pSyouhnZokuseiTkList) {

        if (caller == CheckHokenRyouYuukouKigenTest_exec.class) {
            if (TESTPATTERN7.equals(SYORIPTN) || TESTPATTERN8.equals(SYORIPTN) || TESTPATTERN9.equals(SYORIPTN) ||
                TESTPATTERN10.equals(SYORIPTN)) {

                return C_YouhiKbn.YOU;
            }

            return C_YouhiKbn.HUYOU;
        }
        return super.hanteiYoteirirituHendouGetTumitateriritu(pSyouhnZokuseiSyu, pSyouhnZokuseiTkList);
    }

    @Override
    public C_YouhiKbn hanteiYoteirirituHendouYoteirirituUpDown(BM_SyouhnZokusei pSyouhnZokuseiSyu,
        List<BM_SyouhnZokusei> pSyouhnZokuseiTkList) {

        if (caller == CheckHokenRyouYuukouKigenTest_exec.class) {

            if (TESTPATTERN6.equals(SYORIPTN)) {

                return C_YouhiKbn.YOU;
            }

            return C_YouhiKbn.HUYOU;
        }
        return super.hanteiYoteirirituHendouYoteirirituUpDown(pSyouhnZokuseiSyu, pSyouhnZokuseiTkList);
    }

    @Override
    public C_YouhiKbn hanteiYoteirirituHendouTumitaterirituUpDown(BM_SyouhnZokusei pSyouhnZokuseiSyu,
        List<BM_SyouhnZokusei> pSyouhnZokuseiTkList) {

        if (caller == CheckHokenRyouYuukouKigenTest_exec.class) {
            if (TESTPATTERN7.equals(SYORIPTN)) {

                return C_YouhiKbn.YOU;
            }

            return C_YouhiKbn.HUYOU;
        }
        return super.hanteiYoteirirituHendouTumitaterirituUpDown(pSyouhnZokuseiSyu, pSyouhnZokuseiTkList);
    }

    @Override
    public C_YouhiKbn hanteiYoteirirituHendouTumitatekinZoukarituJyougenUpDown(BM_SyouhnZokusei pSyouhnZokuseiSyu,
        List<BM_SyouhnZokusei> pSyouhnZokuseiTkList) {

        if (caller == CheckHokenRyouYuukouKigenTest_exec.class) {

            if (TESTPATTERN8.equals(SYORIPTN)) {

                return C_YouhiKbn.YOU;
            }

            return C_YouhiKbn.HUYOU;

        }
        return super.hanteiYoteirirituHendouTumitatekinZoukarituJyougenUpDown(pSyouhnZokuseiSyu, pSyouhnZokuseiTkList);
    }

    @Override
    public C_YouhiKbn hanteiYoteirirituHendouSetteibairituUpDown(BM_SyouhnZokusei pSyouhnZokuseiSyu,
        List<BM_SyouhnZokusei> pSyouhnZokuseiTkList) {

        if (caller == CheckHokenRyouYuukouKigenTest_exec.class) {

            if (TESTPATTERN9.equals(SYORIPTN)) {

                return C_YouhiKbn.YOU;
            }

            return C_YouhiKbn.HUYOU;
        }
        return super.hanteiYoteirirituHendouSetteibairituUpDown(pSyouhnZokuseiSyu, pSyouhnZokuseiTkList);
    }

    @Override
    public C_YouhiKbn hanteiSpSaiteiS(BM_SyouhnZokusei pSyouhnZokuseiSyu,
        List<BM_SyouhnZokusei> pSyouhnZokuseiTkList) {

        if (caller == CheckSPTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_YouhiKbn.YOU;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_YouhiKbn.HUYOU;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_YouhiKbn.HUYOU;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return C_YouhiKbn.HUYOU;
            }
            else if (TESTPATTERN5.equals(SYORIPTN) || TESTPATTERN6.equals(SYORIPTN)) {
                return C_YouhiKbn.HUYOU;
            }
        }

        return super.hanteiSpSaiteiS(pSyouhnZokuseiSyu, pSyouhnZokuseiTkList);
    }

    @Override
    public C_YouhiKbn hanteiSpSaikouS(BM_SyouhnZokusei pSyouhnZokuseiSyu,
        List<BM_SyouhnZokusei> pSyouhnZokuseiTkList) {

        if (caller == CheckSPTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_YouhiKbn.HUYOU ;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_YouhiKbn.YOU;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_YouhiKbn.YOU;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return C_YouhiKbn.HUYOU;
            }
            else if (TESTPATTERN5.equals(SYORIPTN) || TESTPATTERN6.equals(SYORIPTN)) {
                return C_YouhiKbn.HUYOU ;
            }
        }

        return super.hanteiSpSaikouS(pSyouhnZokuseiSyu, pSyouhnZokuseiTkList);
    }

    @Override
    public C_YouhiKbn hanteiSpSaikouNenkinGensiGendo(BM_SyouhnZokusei pSyouhnZokuseiSyu,
        List<BM_SyouhnZokusei> pSyouhnZokuseiTkList) {

        if (caller == CheckSPTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_YouhiKbn.HUYOU;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_YouhiKbn.YOU;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_YouhiKbn.HUYOU;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return C_YouhiKbn.HUYOU;
            }
            else if (TESTPATTERN5.equals(SYORIPTN) || TESTPATTERN6.equals(SYORIPTN)) {
                return C_YouhiKbn.HUYOU;
            }
        }

        return super.hanteiSpSaikouNenkinGensiGendo(pSyouhnZokuseiSyu, pSyouhnZokuseiTkList);
    }

    @Override
    public C_YouhiKbn hanteiYoteirirituHendouRendourituUpDown(BM_SyouhnZokusei pSyouhnZokuseiSyu,
        List<BM_SyouhnZokusei> pSyouhnZokuseiTkList) {

        if (caller == CheckHokenRyouYuukouKigenTest_exec.class) {

            if (TESTPATTERN10.equals(SYORIPTN)) {

                return C_YouhiKbn.YOU;
            }

            return C_YouhiKbn.HUYOU;
        }
        return super.hanteiYoteirirituHendouSetteibairituUpDown(pSyouhnZokuseiSyu, pSyouhnZokuseiTkList);
    }

    @Override
    public C_YouhiKbn hanteiItijiSaikouP(BM_SyouhnZokusei pSyouhnZokuseiSyu,
        List<BM_SyouhnZokusei> pSyouhnZokuseiTkList) {

        if ((caller == CheckTblMosSyouhinTest_exec.class || caller == CheckTblMosSyouhinTest_exec1.class
            || caller == CheckTblMosSyouhinTest_exec2.class || caller == CheckTblMosSyouhinTest_exec3.class
            || caller == CheckTblMosSyouhinTest_exec4.class || caller == CheckTblMosSyouhinTest_exec5.class)) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return C_YouhiKbn.YOU;
            }

            if (TESTPATTERN2.equals(SYORIPTN)) {

                return C_YouhiKbn.HUYOU;
            }
        }

        return super.hanteiItijiSaikouP(pSyouhnZokuseiSyu, pSyouhnZokuseiTkList);
    }

    @Override
    public C_YouhiKbn hanteiSueokiKikan(BM_SyouhnZokusei pSyouhnZokuseiSyu,
        List<BM_SyouhnZokusei> pSyouhnZokuseiTkList) {

        if ((caller == CheckTblMosSyouhinTest_exec.class || caller == CheckTblMosSyouhinTest_exec1.class
            || caller == CheckTblMosSyouhinTest_exec2.class || caller == CheckTblMosSyouhinTest_exec3.class
            || caller == CheckTblMosSyouhinTest_exec4.class || caller == CheckTblMosSyouhinTest_exec5.class)) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return C_YouhiKbn.YOU;
            }

            if (TESTPATTERN2.equals(SYORIPTN)) {

                return C_YouhiKbn.HUYOU;
            }
        }

        return super.hanteiSueokiKikan(pSyouhnZokuseiSyu, pSyouhnZokuseiTkList);
    }


    @Override
    public C_YouhiKbn hanteiMosSyouhnSaiteiP(BM_SyouhnZokusei pSyouhnZokuseiSyu,
        List<BM_SyouhnZokusei> pSyouhnZokuseiTkList) {

        if (caller == CheckSPTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN) || TESTPATTERN2.equals(SYORIPTN)||
                TESTPATTERN3.equals(SYORIPTN)|| TESTPATTERN4.equals(SYORIPTN)||TESTPATTERN5.equals(SYORIPTN)) {
                return C_YouhiKbn.YOU;
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                return C_YouhiKbn.HUYOU;
            }
        }
        return super.hanteiMosSyouhnSaiteiP(pSyouhnZokuseiSyu, pSyouhnZokuseiTkList);
    }
}
