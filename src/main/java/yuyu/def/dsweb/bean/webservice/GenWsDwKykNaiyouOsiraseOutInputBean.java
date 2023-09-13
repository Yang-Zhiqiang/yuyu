package yuyu.def.dsweb.bean.webservice;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * （ＤＳＷｅｂ）ＤＳご契約内容のお知らせ出力入力ＢＥＡＮ データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenWsDwKykNaiyouOsiraseOutInputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenWsDwKykNaiyouOsiraseOutInputBean() {
    }

    @Column(order = 1, length = 11)
    @SyoukenNo
    private String iwsSyono11keta;

    public String getIwsSyono11keta() {
        return iwsSyono11keta;
    }

    public void setIwsSyono11keta(String pIwsSyono11keta) {
        iwsSyono11keta = pIwsSyono11keta;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
