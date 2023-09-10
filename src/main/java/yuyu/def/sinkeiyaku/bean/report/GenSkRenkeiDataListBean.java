package yuyu.def.sinkeiyaku.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （新契約）連携データ結果確認リスト帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSkRenkeiDataListBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenSkRenkeiDataListBean() {
    }

    private String irDrtentrkno;

    public String getIrDrtentrkno() {
        return irDrtentrkno;
    }

    public void setIrDrtentrkno(String pIrDrtentrkno) {
        irDrtentrkno = pIrDrtentrkno;
    }

    private Long irInputkensuu;

    public Long getIrInputkensuu() {
        return irInputkensuu;
    }

    public void setIrInputkensuu(Long pIrInputkensuu) {
        irInputkensuu = pIrInputkensuu;
    }

    private Long irUpdatekensuu;

    public Long getIrUpdatekensuu() {
        return irUpdatekensuu;
    }

    public void setIrUpdatekensuu(Long pIrUpdatekensuu) {
        irUpdatekensuu = pIrUpdatekensuu;
    }

    private Long irWarningkensu;

    public Long getIrWarningkensu() {
        return irWarningkensu;
    }

    public void setIrWarningkensu(Long pIrWarningkensu) {
        irWarningkensu = pIrWarningkensu;
    }

    private Long irTsgkensuu;

    public Long getIrTsgkensuu() {
        return irTsgkensuu;
    }

    public void setIrTsgkensuu(Long pIrTsgkensuu) {
        irTsgkensuu = pIrTsgkensuu;
    }

    private Long irErrorkensuu;

    public Long getIrErrorkensuu() {
        return irErrorkensuu;
    }

    public void setIrErrorkensuu(Long pIrErrorkensuu) {
        irErrorkensuu = pIrErrorkensuu;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
