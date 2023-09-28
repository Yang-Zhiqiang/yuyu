package yuyu.common.biz.kaikei;

import java.io.Serializable;

import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Segcd;

/**
 * 業務共通 経理・会計 商品別セグメントマスタ取得結果Bean
 */
public class SyouhinbetuSegmentBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_ErrorKbn errorKbn;

    private C_Segcd segcd1 ;

    private C_Segcd segcd2 ;

    public C_ErrorKbn getErrorKbn() {
        return errorKbn;
    }

    public void setErrorKbn(C_ErrorKbn pErrorKbn) {
        this.errorKbn = pErrorKbn;
    }

    public C_Segcd getSegcd1() {
        return segcd1;
    }

    public void setSegcd1(C_Segcd pSegcd1) {
        this.segcd1 = pSegcd1;
    }

    public C_Segcd getSegcd2() {
        return segcd2;
    }

    public void setSegcd2(C_Segcd pSegcd2) {
        this.segcd2 = pSegcd2;
    }
}
