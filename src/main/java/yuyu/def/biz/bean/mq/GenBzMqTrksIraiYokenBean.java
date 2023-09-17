package yuyu.def.biz.bean.mq;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）ＭＱ取消依頼与件BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzMqTrksIraiYokenBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzMqTrksIraiYokenBean() {
    }

    @Column(order = 1, length = 4)
    @NotNull
    private String iwsSyoricd;

    public String getIwsSyoricd() {
        return iwsSyoricd;
    }

    public void setIwsSyoricd(String pIwsSyoricd) {
        iwsSyoricd = pIwsSyoricd;
    }

    @Column(order = 2, length = 1)
    @NotNull
    private String iwsKugirihugou;

    public String getIwsKugirihugou() {
        return iwsKugirihugou;
    }

    public void setIwsKugirihugou(String pIwsKugirihugou) {
        iwsKugirihugou = pIwsKugirihugou;
    }

    @Column(order = 3, length = 18)
    @NotNull
    private String iwsYoukyuuno;

    public String getIwsYoukyuuno() {
        return iwsYoukyuuno;
    }

    public void setIwsYoukyuuno(String pIwsYoukyuuno) {
        iwsYoukyuuno = pIwsYoukyuuno;
    }

    @Column(order = 4, length = 1)
    @NotNull
    private String iwsHuho2kyknokbn;

    public String getIwsHuho2kyknokbn() {
        return iwsHuho2kyknokbn;
    }

    public void setIwsHuho2kyknokbn(String pIwsHuho2kyknokbn) {
        iwsHuho2kyknokbn = pIwsHuho2kyknokbn;
    }

    @Column(order = 5, length = 11)
    @NotNull
    private String iwsHuho2kykno;

    public String getIwsHuho2kykno() {
        return iwsHuho2kykno;
    }

    public void setIwsHuho2kykno(String pIwsHuho2kykno) {
        iwsHuho2kykno = pIwsHuho2kykno;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
