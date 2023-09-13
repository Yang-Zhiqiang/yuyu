package yuyu.def.dsweb.bean.webservice;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * （ＤＳＷｅｂ）不可文字チェック入力BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenWsDwHukamojiCheckInputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenWsDwHukamojiCheckInputBean() {
    }

    @InvalidCharacter
    private String iwsCheckmojiretu;

    public String getIwsCheckmojiretu() {
        return iwsCheckmojiretu;
    }

    public void setIwsCheckmojiretu(String pIwsCheckmojiretu) {
        iwsCheckmojiretu = pIwsCheckmojiretu;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
