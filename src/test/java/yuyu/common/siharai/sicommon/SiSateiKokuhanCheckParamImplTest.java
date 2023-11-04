package yuyu.common.siharai.sicommon;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.siharai.edittbl.EditSkTblParam;
import yuyu.common.siharai.edittbl.SiSateiKokuhanCheckParam;
import yuyu.def.classification.C_UmuKbn;

/**
 * 保険金給付金支払 保険金給付金支払共通 査定告反チェックParamインターフェース実装クラス（テスト用）
 */
public class SiSateiKokuhanCheckParamImplTest implements SiSateiKokuhanCheckParam ,EditSkTblParam {

    private C_UmuKbn kokuhancheckkbn1;

    private String kokuhanchecomment1;

    private C_UmuKbn kokuhancheckkbn2;

    private String kokuhanchecomment2;

    private C_UmuKbn kokuhancheckkbn3;

    private String kokuhanchecomment3;

    private C_UmuKbn kokuhancheckkbn4;

    private String kokuhanchecomment4;

    private C_UmuKbn kokuhancheckkbn5;

    private String kokuhanchecomment5;

    private C_UmuKbn kokuhancheckkbn6;

    private String kokuhanchecomment6;

    private C_UmuKbn kokuhancheckkbn7;

    private String kokuhanchecomment7;

    private C_UmuKbn kokuhancheckkbn8;

    private String kokuhanchecomment8;

    @Override
    public C_UmuKbn getKokuhancheckkbn1() {
        return kokuhancheckkbn1;
    }

    @Override
    public void setKokuhancheckkbn1(C_UmuKbn pKokuhancheckkbn1) {
        kokuhancheckkbn1 = pKokuhancheckkbn1;
    }

    @Override
    public String getKokuhanchecomment1() {
        return kokuhanchecomment1;
    }

    @Override
    public void setKokuhanchecomment1(String pKokuhanchecomment1) {
        kokuhanchecomment1 = pKokuhanchecomment1;
    }

    @Override
    public C_UmuKbn getKokuhancheckkbn2() {
        return kokuhancheckkbn2;
    }

    @Override
    public void setKokuhancheckkbn2(C_UmuKbn pKokuhancheckkbn2) {
        kokuhancheckkbn2 = pKokuhancheckkbn2;
    }

    @Override
    public String getKokuhanchecomment2() {
        return kokuhanchecomment2;
    }

    @Override
    public void setKokuhanchecomment2(String pKokuhanchecomment2) {
        kokuhanchecomment2 = pKokuhanchecomment2;
    }

    @Override
    public C_UmuKbn getKokuhancheckkbn3() {
        return kokuhancheckkbn3;
    }

    @Override
    public void setKokuhancheckkbn3(C_UmuKbn pKokuhancheckkbn3) {
        kokuhancheckkbn3 = pKokuhancheckkbn3;
    }

    @Override
    public String getKokuhanchecomment3() {
        return kokuhanchecomment3;
    }

    @Override
    public void setKokuhanchecomment3(String pKokuhanchecomment3) {
        kokuhanchecomment3 = pKokuhanchecomment3;
    }

    @Override
    public C_UmuKbn getKokuhancheckkbn4() {
        return kokuhancheckkbn4;
    }

    @Override
    public void setKokuhancheckkbn4(C_UmuKbn pKokuhancheckkbn4) {
        kokuhancheckkbn4 = pKokuhancheckkbn4;
    }

    @Override
    public String getKokuhanchecomment4() {
        return kokuhanchecomment4;
    }

    @Override
    public void setKokuhanchecomment4(String pKokuhanchecomment4) {
        kokuhanchecomment4 = pKokuhanchecomment4;
    }

    @Override
    public C_UmuKbn getKokuhancheckkbn5() {
        return kokuhancheckkbn5;
    }

    @Override
    public void setKokuhancheckkbn5(C_UmuKbn pKokuhancheckkbn5) {
        kokuhancheckkbn5 = pKokuhancheckkbn5;
    }

    @Override
    public String getKokuhanchecomment5() {
        return kokuhanchecomment5;
    }

    @Override
    public void setKokuhanchecomment5(String pKokuhanchecomment5) {
        kokuhanchecomment5 = pKokuhanchecomment5;
    }

    @Override
    public C_UmuKbn getKokuhancheckkbn6() {
        return kokuhancheckkbn6;
    }

    @Override
    public void setKokuhancheckkbn6(C_UmuKbn pKokuhancheckkbn6) {
        kokuhancheckkbn6 = pKokuhancheckkbn6;
    }

    @Override
    public String getKokuhanchecomment6() {
        return kokuhanchecomment6;
    }

    @Override
    public void setKokuhanchecomment6(String pKokuhanchecomment6) {
        kokuhanchecomment6 = pKokuhanchecomment6;
    }

    @Override
    public C_UmuKbn getKokuhancheckkbn7() {
        return kokuhancheckkbn7;
    }

    @Override
    public void setKokuhancheckkbn7(C_UmuKbn pKokuhancheckkbn7) {
        kokuhancheckkbn7 = pKokuhancheckkbn7;
    }

    @Override
    public String getKokuhanchecomment7() {
        return kokuhanchecomment7;
    }

    @Override
    public void setKokuhanchecomment7(String pKokuhanchecomment7) {
        kokuhanchecomment7 = pKokuhanchecomment7;
    }

    @Override
    public C_UmuKbn getKokuhancheckkbn8() {
        return kokuhancheckkbn8;
    }

    @Override
    public void setKokuhancheckkbn8(C_UmuKbn pKokuhancheckkbn8) {
        kokuhancheckkbn8 = pKokuhancheckkbn8;
    }

    @Override
    public String getKokuhanchecomment8() {
        return kokuhanchecomment8;
    }

    @Override
    public void setKokuhanchecomment8(String pKokuhanchecomment8) {
        kokuhanchecomment8 = pKokuhanchecomment8;
    }

    public boolean isAllBlnk() {

        if (C_UmuKbn.NONE.eq(kokuhancheckkbn1) && BizUtil.isBlank(kokuhanchecomment1) &&
            C_UmuKbn.NONE.eq(kokuhancheckkbn2) && BizUtil.isBlank(kokuhanchecomment2) &&
            C_UmuKbn.NONE.eq(kokuhancheckkbn3) && BizUtil.isBlank(kokuhanchecomment3) &&
            C_UmuKbn.NONE.eq(kokuhancheckkbn4) && BizUtil.isBlank(kokuhanchecomment4) &&
            C_UmuKbn.NONE.eq(kokuhancheckkbn5) && BizUtil.isBlank(kokuhanchecomment5) &&
            C_UmuKbn.NONE.eq(kokuhancheckkbn6) && BizUtil.isBlank(kokuhanchecomment6) &&
            C_UmuKbn.NONE.eq(kokuhancheckkbn7) && BizUtil.isBlank(kokuhanchecomment7) &&
            C_UmuKbn.NONE.eq(kokuhancheckkbn8) && BizUtil.isBlank(kokuhanchecomment8)) {
            return true;
        }
        return false;
    }

}
