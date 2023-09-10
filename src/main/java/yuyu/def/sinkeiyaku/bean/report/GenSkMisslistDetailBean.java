package yuyu.def.sinkeiyaku.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （新契約）ミスリスト明細帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSkMisslistDetailBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenSkMisslistDetailBean() {
    }

    private String irMosno;

    public String getIrMosno() {
        return irMosno;
    }

    public void setIrMosno(String pIrMosno) {
        irMosno = pIrMosno;
    }

    private String irMisslistmsg;

    public String getIrMisslistmsg() {
        return irMisslistmsg;
    }

    public void setIrMisslistmsg(String pIrMisslistmsg) {
        irMisslistmsg = pIrMisslistmsg;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
