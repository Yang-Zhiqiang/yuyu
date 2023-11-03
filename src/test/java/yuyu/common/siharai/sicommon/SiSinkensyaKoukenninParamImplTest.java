package yuyu.common.siharai.sicommon;

import yuyu.common.siharai.edittbl.EditSkTblParam;
import yuyu.common.siharai.edittbl.SiSinkensyaKoukenninParam;
import yuyu.def.classification.C_SkskknsyubetuKbn;

/**
 * 保険金給付金支払 保険金給付金支払共通 親権者後見人情報Paramインターフェース実装クラス（テスト用）
 */
public class SiSinkensyaKoukenninParamImplTest implements SiSinkensyaKoukenninParam ,EditSkTblParam {

    private String skskknnmkn;

    private String skskknnmkj;

    private C_SkskknsyubetuKbn skskknsyubetu;

    @Override
    public String getSkskknnmkn() {
        return skskknnmkn;
    }

    @Override
    public void setSkskknnmkn(String pSkskknnmkn) {
        skskknnmkn = pSkskknnmkn;
    }

    @Override
    public String getSkskknnmkj() {
        return skskknnmkj;
    }

    @Override
    public void setSkskknnmkj(String pSkskknnmkj) {
        skskknnmkj = pSkskknnmkj;
    }

    @Override
    public C_SkskknsyubetuKbn getSkskknsyubetu() {
        return skskknsyubetu;
    }

    @Override
    public void setSkskknsyubetu(C_SkskknsyubetuKbn pSkskknsyubetu) {
        skskknsyubetu = pSkskknsyubetu;
    }

}
