package yuyu.def.dsweb.bean.webservice;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （ＤＳＷｅｂ）リアルタイムメール送信出力BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenWsDwRealTimeMailSousinOutputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenWsDwRealTimeMailSousinOutputBean() {
    }

    @NotNull
    private String iwsDsmsgcd;

    public String getIwsDsmsgcd() {
        return iwsDsmsgcd;
    }

    public void setIwsDsmsgcd(String pIwsDsmsgcd) {
        iwsDsmsgcd = pIwsDsmsgcd;
    }

    private String iwsSousinymd;

    public String getIwsSousinymd() {
        return iwsSousinymd;
    }

    public void setIwsSousinymd(String pIwsSousinymd) {
        iwsSousinymd = pIwsSousinymd;
    }

    private String iwsSakujyoymd;

    public String getIwsSakujyoymd() {
        return iwsSakujyoymd;
    }

    public void setIwsSakujyoymd(String pIwsSakujyoymd) {
        iwsSakujyoymd = pIwsSakujyoymd;
    }

    private String iwsDssousinno;

    public String getIwsDssousinno() {
        return iwsDssousinno;
    }

    public void setIwsDssousinno(String pIwsDssousinno) {
        iwsDssousinno = pIwsDssousinno;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
