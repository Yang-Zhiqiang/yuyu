package yuyu.def.biz.bean.param;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）リカバリデータ識別用BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzRecoveryDatasikibetuBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzRecoveryDatasikibetuBean() {
    }

    private String ibKakutyoujobcd;

    public String getIbKakutyoujobcd() {
        return ibKakutyoujobcd;
    }

    public void setIbKakutyoujobcd(String pIbKakutyoujobcd) {
        ibKakutyoujobcd = pIbKakutyoujobcd;
    }

    private String ibTableid;

    public String getIbTableid() {
        return ibTableid;
    }

    public void setIbTableid(String pIbTableid) {
        ibTableid = pIbTableid;
    }

    private String ibRecoveryfilterid;

    public String getIbRecoveryfilterid() {
        return ibRecoveryfilterid;
    }

    public void setIbRecoveryfilterid(String pIbRecoveryfilterid) {
        ibRecoveryfilterid = pIbRecoveryfilterid;
    }

    private String ibRecoveryfilterkey1;

    public String getIbRecoveryfilterkey1() {
        return ibRecoveryfilterkey1;
    }

    public void setIbRecoveryfilterkey1(String pIbRecoveryfilterkey1) {
        ibRecoveryfilterkey1 = pIbRecoveryfilterkey1;
    }

    private String ibRecoveryfilterkey2;

    public String getIbRecoveryfilterkey2() {
        return ibRecoveryfilterkey2;
    }

    public void setIbRecoveryfilterkey2(String pIbRecoveryfilterkey2) {
        ibRecoveryfilterkey2 = pIbRecoveryfilterkey2;
    }

    private String ibRecoveryfilterkey3;

    public String getIbRecoveryfilterkey3() {
        return ibRecoveryfilterkey3;
    }

    public void setIbRecoveryfilterkey3(String pIbRecoveryfilterkey3) {
        ibRecoveryfilterkey3 = pIbRecoveryfilterkey3;
    }

    private String ibRecoveryfilterkey4;

    public String getIbRecoveryfilterkey4() {
        return ibRecoveryfilterkey4;
    }

    public void setIbRecoveryfilterkey4(String pIbRecoveryfilterkey4) {
        ibRecoveryfilterkey4 = pIbRecoveryfilterkey4;
    }

    private String ibRecoveryfilterkey5;

    public String getIbRecoveryfilterkey5() {
        return ibRecoveryfilterkey5;
    }

    public void setIbRecoveryfilterkey5(String pIbRecoveryfilterkey5) {
        ibRecoveryfilterkey5 = pIbRecoveryfilterkey5;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
