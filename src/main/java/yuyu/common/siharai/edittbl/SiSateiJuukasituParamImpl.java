package yuyu.common.siharai.edittbl;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.classification.C_UmuKbn;

/**
 * 保険金給付金支払 保険金給付金支払共通 査定重過失チェックParamインターフェース実装クラス
 */
public class SiSateiJuukasituParamImpl implements SiSateiJuukasituParam {

    private C_UmuKbn juukasitucheckkbn1;

    private String juukasitucheckcomment1;

    private C_UmuKbn juukasitucheckkbn2;

    private String juukasitucheckcomment2;

    private C_UmuKbn juukasitucheckkbn3;

    private String juukasitucheckcomment3;

    private C_UmuKbn juukasitucheckkbn4;

    private String juukasitucheckcomment4;

    @Override
    public C_UmuKbn getJuukasitucheckkbn1() {
        return juukasitucheckkbn1;
    }

    @Override
    public void setJuukasitucheckkbn1(C_UmuKbn pJuukasitucheckkbn1) {
        juukasitucheckkbn1 = pJuukasitucheckkbn1;
    }

    @Override
    public String getJuukasitucheckcomment1() {
        return juukasitucheckcomment1;
    }

    @Override
    public void setJuukasitucheckcomment1(String pJuukasitucheckcomment1) {
        juukasitucheckcomment1 = pJuukasitucheckcomment1;
    }

    @Override
    public C_UmuKbn getJuukasitucheckkbn2() {
        return juukasitucheckkbn2;
    }

    @Override
    public void setJuukasitucheckkbn2(C_UmuKbn pJuukasitucheckkbn2) {
        juukasitucheckkbn2 = pJuukasitucheckkbn2;
    }

    @Override
    public String getJuukasitucheckcomment2() {
        return juukasitucheckcomment2;
    }

    @Override
    public void setJuukasitucheckcomment2(String pJuukasitucheckcomment2) {
        juukasitucheckcomment2 = pJuukasitucheckcomment2;
    }

    @Override
    public C_UmuKbn getJuukasitucheckkbn3() {
        return juukasitucheckkbn3;
    }

    @Override
    public void setJuukasitucheckkbn3(C_UmuKbn pJuukasitucheckkbn3) {
        juukasitucheckkbn3 = pJuukasitucheckkbn3;
    }

    @Override
    public String getJuukasitucheckcomment3() {
        return juukasitucheckcomment3;
    }

    @Override
    public void setJuukasitucheckcomment3(String pJuukasitucheckcomment3) {
        juukasitucheckcomment3 = pJuukasitucheckcomment3;
    }

    @Override
    public C_UmuKbn getJuukasitucheckkbn4() {
        return juukasitucheckkbn4;
    }

    @Override
    public void setJuukasitucheckkbn4(C_UmuKbn pJuukasitucheckkbn4) {
        juukasitucheckkbn4 = pJuukasitucheckkbn4;
    }

    @Override
    public String getJuukasitucheckcomment4() {
        return juukasitucheckcomment4;
    }

    @Override
    public void setJuukasitucheckcomment4(String pJuukasitucheckcomment4) {
        juukasitucheckcomment4 = pJuukasitucheckcomment4;
    }

    public boolean isAllBlnk() {

        if (C_UmuKbn.NONE.eq(juukasitucheckkbn1) && BizUtil.isBlank(juukasitucheckcomment1) &&
            C_UmuKbn.NONE.eq(juukasitucheckkbn2) && BizUtil.isBlank(juukasitucheckcomment2) &&
            C_UmuKbn.NONE.eq(juukasitucheckkbn3) && BizUtil.isBlank(juukasitucheckcomment3) &&
            C_UmuKbn.NONE.eq(juukasitucheckkbn4) && BizUtil.isBlank(juukasitucheckcomment4)) {
            return true;
        }
        return false;
    }
}
