package yuyu.common.siharai.siview;

import yuyu.def.classification.C_SyorikekkaKbn;

/**
 * 保険金給付金支払 保険金給付金支払共通 結果入力設定UiBeanパラメータインタフェース実装クラス
 */
public class ViewKekkaInputUiBeanParamImpl implements ViewKekkaInputUiBeanParam {

    private C_SyorikekkaKbn syorikekkakbn;

    private String tennousakisousasyacd;

    private String syanaicomment;

    @Override
    public C_SyorikekkaKbn getSyorikekkakbn() {
        return syorikekkakbn;
    }

    @Override
    public void setSyorikekkakbn(C_SyorikekkaKbn pSyorikekkakbn) {
        syorikekkakbn = pSyorikekkakbn;
    }

    @Override
    public String getTennousakisousasyacd() {
        return tennousakisousasyacd;
    }

    @Override
    public void setTennousakisousasyacd(String pTennousakisousasyacd) {
        tennousakisousasyacd = pTennousakisousasyacd;
    }

    @Override
    public String getSyanaicomment() {
        return syanaicomment;
    }

    @Override
    public void setSyanaicomment(String pSyanaicomment) {
        syanaicomment = pSyanaicomment;
    }

}
