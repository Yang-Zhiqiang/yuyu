package yuyu.def.dsweb.bean.webservice;

import java.io.Serializable;
import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import yuyu.infr.validation.constraints.SyoukenNo;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （ＤＳＷｅｂ）ログイン認証入力BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenWsDwLoginInputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenWsDwLoginInputBean() {
    }

    @Column(order = 1, length = 20)
    @SyoukenNo
    private String iwsSyono;

    public String getIwsSyono() {
        return iwsSyono;
    }

    public void setIwsSyono(String pIwsSyono) {
        iwsSyono = pIwsSyono;
    }

    @Column(order = 2, length = 128)
    private String iwsPassword;

    public String getIwsPassword() {
        return iwsPassword;
    }

    public void setIwsPassword(String pIwsPassword) {
        iwsPassword = pIwsPassword;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
