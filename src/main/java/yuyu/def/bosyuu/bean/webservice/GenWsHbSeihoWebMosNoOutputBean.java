package yuyu.def.bosyuu.bean.webservice;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * （保険募集）生保Ｗｅｂ申込番号取得出力BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenWsHbSeihoWebMosNoOutputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenWsHbSeihoWebMosNoOutputBean() {
    }

    @Column(order = 1, length = 1)
    private String iwsErrkbn;

    public String getIwsErrkbn() {
        return iwsErrkbn;
    }

    public void setIwsErrkbn(String pIwsErrkbn) {
        iwsErrkbn = pIwsErrkbn;
    }

    @Column(order = 2, length = 9)
    @MousikomiNo
    private String iwsMosno;

    public String getIwsMosno() {
        return iwsMosno;
    }

    public void setIwsMosno(String pIwsMosno) {
        iwsMosno = pIwsMosno;
    }

    @Column(order = 3, length = 21)
    private String iwsDocumentid1;

    public String getIwsDocumentid1() {
        return iwsDocumentid1;
    }

    public void setIwsDocumentid1(String pIwsDocumentid1) {
        iwsDocumentid1 = pIwsDocumentid1;
    }

    @Column(order = 4, length = 21)
    private String iwsDocumentid2;

    public String getIwsDocumentid2() {
        return iwsDocumentid2;
    }

    public void setIwsDocumentid2(String pIwsDocumentid2) {
        iwsDocumentid2 = pIwsDocumentid2;
    }

    @Column(order = 5, length = 21)
    private String iwsDocumentid3;

    public String getIwsDocumentid3() {
        return iwsDocumentid3;
    }

    public void setIwsDocumentid3(String pIwsDocumentid3) {
        iwsDocumentid3 = pIwsDocumentid3;
    }

    @Column(order = 6, length = 21)
    private String iwsDocumentid4;

    public String getIwsDocumentid4() {
        return iwsDocumentid4;
    }

    public void setIwsDocumentid4(String pIwsDocumentid4) {
        iwsDocumentid4 = pIwsDocumentid4;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
