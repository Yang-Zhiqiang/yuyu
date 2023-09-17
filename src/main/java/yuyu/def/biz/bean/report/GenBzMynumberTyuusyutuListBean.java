package yuyu.def.biz.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）マイナンバー帳票抽出リスト帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzMynumberTyuusyutuListBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzMynumberTyuusyutuListBean() {
    }

    private String irTantousitunm;

    public String getIrTantousitunm() {
        return irTantousitunm;
    }

    public void setIrTantousitunm(String pIrTantousitunm) {
        irTantousitunm = pIrTantousitunm;
    }

    private String irSakuseiymd;

    public String getIrSakuseiymd() {
        return irSakuseiymd;
    }

    public void setIrSakuseiymd(String pIrSakuseiymd) {
        irSakuseiymd = pIrSakuseiymd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
