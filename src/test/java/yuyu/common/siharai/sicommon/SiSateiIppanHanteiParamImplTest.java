package yuyu.common.siharai.sicommon;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.siharai.edittbl.EditSkTblParam;
import yuyu.common.siharai.edittbl.SiSateiIppanHanteiParam;

/**
 * 保険金給付金支払 保険金給付金支払共通 査定一般判定Paramインターフェース実装クラス（テスト用）
 */
public class SiSateiIppanHanteiParamImplTest implements SiSateiIppanHanteiParam ,EditSkTblParam {

    private String ippanhanteitensuu1;

    private String ippanhanteicomment1;

    private String ippanhanteitensuu2;

    private String ippanhanteicomment2;

    private String ippanhanteitensuu3;

    private String ippanhanteicomment3;

    private String ippanhanteitensuu4;

    private String ippanhanteicomment4;

    private String ippanhanteitensuu5;

    private String ippanhanteicomment5;

    private String ippanhanteitensuu6;

    private String ippanhanteicomment6;

    private String ippanhanteitensuugoukei;

    private String ippanhanteigoukeicomment;

    @Override
    public String getIppanhanteitensuu1() {
        return ippanhanteitensuu1;
    }

    @Override
    public void setIppanhanteitensuu1(String pIppanhanteitensuu1) {
        ippanhanteitensuu1 = pIppanhanteitensuu1;
    }

    @Override
    public String getIppanhanteicomment1() {
        return ippanhanteicomment1;
    }

    @Override
    public void setIppanhanteicomment1(String pIppanhanteicomment1) {
        ippanhanteicomment1 = pIppanhanteicomment1;
    }

    @Override
    public String getIppanhanteitensuu2() {
        return ippanhanteitensuu2;
    }

    @Override
    public void setIppanhanteitensuu2(String pIppanhanteitensuu2) {
        ippanhanteitensuu2 = pIppanhanteitensuu2;
    }

    @Override
    public String getIppanhanteicomment2() {
        return ippanhanteicomment2;
    }

    @Override
    public void setIppanhanteicomment2(String pIppanhanteicomment2) {
        ippanhanteicomment2 = pIppanhanteicomment2;
    }

    @Override
    public String getIppanhanteitensuu3() {
        return ippanhanteitensuu3;
    }

    @Override
    public void setIppanhanteitensuu3(String pIppanhanteitensuu3) {
        ippanhanteitensuu3 = pIppanhanteitensuu3;
    }

    @Override
    public String getIppanhanteicomment3() {
        return ippanhanteicomment3;
    }

    @Override
    public void setIppanhanteicomment3(String pIppanhanteicomment3) {
        ippanhanteicomment3 = pIppanhanteicomment3;
    }

    @Override
    public String getIppanhanteitensuu4() {
        return ippanhanteitensuu4;
    }

    @Override
    public void setIppanhanteitensuu4(String pIppanhanteitensuu4) {
        ippanhanteitensuu4 = pIppanhanteitensuu4;
    }

    @Override
    public String getIppanhanteicomment4() {
        return ippanhanteicomment4;
    }

    @Override
    public void setIppanhanteicomment4(String pIppanhanteicomment4) {
        ippanhanteicomment4 = pIppanhanteicomment4;
    }

    @Override
    public String getIppanhanteitensuu5() {
        return ippanhanteitensuu5;
    }

    @Override
    public void setIppanhanteitensuu5(String pIppanhanteitensuu5) {
        ippanhanteitensuu5 = pIppanhanteitensuu5;
    }

    @Override
    public String getIppanhanteicomment5() {
        return ippanhanteicomment5;
    }

    @Override
    public void setIppanhanteicomment5(String pIppanhanteicomment5) {
        ippanhanteicomment5 = pIppanhanteicomment5;
    }

    @Override
    public String getIppanhanteitensuu6() {
        return ippanhanteitensuu6;
    }

    @Override
    public void setIppanhanteitensuu6(String pIppanhanteitensuu6) {
        ippanhanteitensuu6 = pIppanhanteitensuu6;
    }

    @Override
    public String getIppanhanteicomment6() {
        return ippanhanteicomment6;
    }

    @Override
    public void setIppanhanteicomment6(String pIppanhanteicomment6) {
        ippanhanteicomment6 = pIppanhanteicomment6;
    }

    @Override
    public String getIppanhanteitensuugoukei() {
        return ippanhanteitensuugoukei;
    }

    @Override
    public void setIppanhanteitensuugoukei(String pIppanhanteitensuugoukei) {
        ippanhanteitensuugoukei = pIppanhanteitensuugoukei;
    }

    @Override
    public String getIppanhanteigoukeicomment() {
        return ippanhanteigoukeicomment;
    }

    @Override
    public void setIppanhanteigoukeicomment(String pIppanhanteigoukeicomment) {
        ippanhanteigoukeicomment = pIppanhanteigoukeicomment;
    }

    public boolean isAllBlnk() {

        if (BizUtil.isBlank(ippanhanteitensuu1) && BizUtil.isBlank(ippanhanteicomment1) &&
            BizUtil.isBlank(ippanhanteitensuu2) && BizUtil.isBlank(ippanhanteicomment2) &&
            BizUtil.isBlank(ippanhanteitensuu3) && BizUtil.isBlank(ippanhanteicomment3) &&
            BizUtil.isBlank(ippanhanteitensuu4) && BizUtil.isBlank(ippanhanteicomment4) &&
            BizUtil.isBlank(ippanhanteitensuu5) && BizUtil.isBlank(ippanhanteicomment5) &&
            BizUtil.isBlank(ippanhanteitensuu6) && BizUtil.isBlank(ippanhanteicomment6) &&
            BizUtil.isBlank(ippanhanteitensuugoukei) && BizUtil.isBlank(ippanhanteigoukeicomment)) {
            return true;
        }
        return false;
    }

}
