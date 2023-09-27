package yuyu.common.direct.dscommon;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_ErrorKbn;

/**
 * ダイレクトサービス ダイレクトサービス共通  保険期間情報Bean<br/>
 */
public class HokenKikanBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_ErrorKbn errorKbn;

    private BizDate hknkknkaisiymd1;

    private BizDate hknkknmanryouymd1;

    private Integer dai1hknkkn;

    private BizDate hknkknkaisiymd2;

    private BizDate hknkknmanryouymd2;

    public C_ErrorKbn getErrorKbn() {
        return errorKbn;
    }

    public void setErrorKbn(C_ErrorKbn pErrorKbn) {
        errorKbn = pErrorKbn;
    }

    public BizDate getHknkknkaisiymd1() {
        return hknkknkaisiymd1;
    }

    public void setHknkknkaisiymd1(BizDate pHknkknkaisiymd1) {
        hknkknkaisiymd1 = pHknkknkaisiymd1;
    }

    public BizDate getHknkknmanryouymd1() {
        return hknkknmanryouymd1;
    }

    public void setHknkknmanryouymd1(BizDate pHknkknmanryouymd1) {
        hknkknmanryouymd1 = pHknkknmanryouymd1;
    }

    public Integer getDai1hknkkn() {
        return dai1hknkkn;
    }

    public void setDai1hknkkn(Integer pDai1hknkkn) {
        dai1hknkkn = pDai1hknkkn;
    }

    public BizDate getHknkknkaisiymd2() {
        return hknkknkaisiymd2;
    }

    public void setHknkknkaisiymd2(BizDate pHknkknkaisiymd2) {
        hknkknkaisiymd2 = pHknkknkaisiymd2;
    }

    public BizDate getHknkknmanryouymd2() {
        return hknkknmanryouymd2;
    }

    public void setHknkknmanryouymd2(BizDate pHknkknmanryouymd2) {
        hknkknmanryouymd2 = pHknkknmanryouymd2;
    }


}
