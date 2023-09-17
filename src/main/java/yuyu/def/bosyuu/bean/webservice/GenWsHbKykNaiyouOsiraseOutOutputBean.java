package yuyu.def.bosyuu.bean.webservice;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.annotations.MultiByte;
import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保険募集）生保Ｗｅｂご契約内容のお知らせ出力出力BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenWsHbKykNaiyouOsiraseOutOutputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenWsHbKykNaiyouOsiraseOutOutputBean() {
    }

    @Column(order = 1, length = 1)
    private String iwsErrkbn;

    public String getIwsErrkbn() {
        return iwsErrkbn;
    }

    public void setIwsErrkbn(String pIwsErrkbn) {
        iwsErrkbn = pIwsErrkbn;
    }

    @Column(order = 2, length = 60)
    @MultiByte
    private String iwsErrormsgv60;

    public String getIwsErrormsgv60() {
        return iwsErrormsgv60;
    }

    public void setIwsErrormsgv60(String pIwsErrormsgv60) {
        iwsErrormsgv60 = pIwsErrormsgv60;
    }

    @Column(order = 3, length = 8)
    private String iwsTanmatutyouhyoucd;

    public String getIwsTanmatutyouhyoucd() {
        return iwsTanmatutyouhyoucd;
    }

    public void setIwsTanmatutyouhyoucd(String pIwsTanmatutyouhyoucd) {
        iwsTanmatutyouhyoucd = pIwsTanmatutyouhyoucd;
    }

    @Column(order = 4, length = 1398104)
    private String iwsPdfdata;

    public String getIwsPdfdata() {
        return iwsPdfdata;
    }

    public void setIwsPdfdata(String pIwsPdfdata) {
        iwsPdfdata = pIwsPdfdata;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
