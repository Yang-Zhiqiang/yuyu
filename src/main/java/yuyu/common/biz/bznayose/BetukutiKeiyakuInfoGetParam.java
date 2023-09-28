package yuyu.common.biz.bznayose;

import yuyu.def.classification.C_Huho2kyknoKbn;
import yuyu.def.classification.C_SakuintsnTaisyouKbn;

/**
 * 業務共通 名寄せ 別口契約情報取得Paramクラス
 */
public class BetukutiKeiyakuInfoGetParam {
    private C_Huho2kyknoKbn huho2kyknokbn;

    private String huho2kykno ;

    private C_SakuintsnTaisyouKbn skintsntaisyoukbn ;

    public BetukutiKeiyakuInfoGetParam() {

    }

    public C_Huho2kyknoKbn getHuho2kyknokbn() {
        return huho2kyknokbn;
    }

    public void setHuho2kyknokbn(C_Huho2kyknoKbn pHuho2kyknokbn) {
        huho2kyknokbn = pHuho2kyknokbn;
    }

    public String getHuho2kykno () {
        return huho2kykno ;
    }

    public void setHuho2kykno (String pHuho2kykno ) {
        huho2kykno  = pHuho2kykno ;
    }

    public C_SakuintsnTaisyouKbn getSkintsntaisyoukbn () {
        return skintsntaisyoukbn ;
    }

    public void setSkintsntaisyoukbn (C_SakuintsnTaisyouKbn pSkintsntaisyoukbn ) {
        skintsntaisyoukbn  = pSkintsntaisyoukbn ;
    }

}
