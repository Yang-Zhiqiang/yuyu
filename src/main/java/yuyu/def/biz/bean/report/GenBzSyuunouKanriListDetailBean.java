package yuyu.def.biz.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）収納管理リスト明細帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzSyuunouKanriListDetailBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzSyuunouKanriListDetailBean() {
    }

    private String irMidasi;

    public String getIrMidasi() {
        return irMidasi;
    }

    public void setIrMidasi(String pIrMidasi) {
        irMidasi = pIrMidasi;
    }

    private String irAnnaikensuu;

    public String getIrAnnaikensuu() {
        return irAnnaikensuu;
    }

    public void setIrAnnaikensuu(String pIrAnnaikensuu) {
        irAnnaikensuu = pIrAnnaikensuu;
    }

    private String irAnnaigk;

    public String getIrAnnaigk() {
        return irAnnaigk;
    }

    public void setIrAnnaigk(String pIrAnnaigk) {
        irAnnaigk = pIrAnnaigk;
    }

    private String irHurizumikensuu;

    public String getIrHurizumikensuu() {
        return irHurizumikensuu;
    }

    public void setIrHurizumikensuu(String pIrHurizumikensuu) {
        irHurizumikensuu = pIrHurizumikensuu;
    }

    private String irHurizumigk;

    public String getIrHurizumigk() {
        return irHurizumigk;
    }

    public void setIrHurizumigk(String pIrHurizumigk) {
        irHurizumigk = pIrHurizumigk;
    }

    private String irHurihunokensuu;

    public String getIrHurihunokensuu() {
        return irHurihunokensuu;
    }

    public void setIrHurihunokensuu(String pIrHurihunokensuu) {
        irHurihunokensuu = pIrHurihunokensuu;
    }

    private String irHurihunogk;

    public String getIrHurihunogk() {
        return irHurihunogk;
    }

    public void setIrHurihunogk(String pIrHurihunogk) {
        irHurihunogk = pIrHurihunogk;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
