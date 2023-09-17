package yuyu.def.biz.bean.mq;

import java.io.Serializable;
import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）ＭＱ契約内容反映結果BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzMqKykNaiyouHaneiKekkaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzMqKykNaiyouHaneiKekkaBean() {
    }

    @Column(order = 1, length = 4)
    private String iwsAcserrcd;

    public String getIwsAcserrcd() {
        return iwsAcserrcd;
    }

    public void setIwsAcserrcd(String pIwsAcserrcd) {
        iwsAcserrcd = pIwsAcserrcd;
    }

    @Column(order = 2, length = 1)
    private String iwsKyknaiyouhaneierrkbn;

    public String getIwsKyknaiyouhaneierrkbn() {
        return iwsKyknaiyouhaneierrkbn;
    }

    public void setIwsKyknaiyouhaneierrkbn(String pIwsKyknaiyouhaneierrkbn) {
        iwsKyknaiyouhaneierrkbn = pIwsKyknaiyouhaneierrkbn;
    }

    @Column(order = 3, length = 1)
    private String iwsHhknnysjissikekkakbn;

    public String getIwsHhknnysjissikekkakbn() {
        return iwsHhknnysjissikekkakbn;
    }

    public void setIwsHhknnysjissikekkakbn(String pIwsHhknnysjissikekkakbn) {
        iwsHhknnysjissikekkakbn = pIwsHhknnysjissikekkakbn;
    }

    @Column(order = 4, length = 10)
    private String iwsHhknsakuinnmno;

    public String getIwsHhknsakuinnmno() {
        return iwsHhknsakuinnmno;
    }

    public void setIwsHhknsakuinnmno(String pIwsHhknsakuinnmno) {
        iwsHhknsakuinnmno = pIwsHhknsakuinnmno;
    }

    @Column(order = 5, length = 1)
    private String iwsKyknysjissikekkakbn;

    public String getIwsKyknysjissikekkakbn() {
        return iwsKyknysjissikekkakbn;
    }

    public void setIwsKyknysjissikekkakbn(String pIwsKyknysjissikekkakbn) {
        iwsKyknysjissikekkakbn = pIwsKyknysjissikekkakbn;
    }

    @Column(order = 6, length = 10)
    private String iwsKyksyaskinnmno;

    public String getIwsKyksyaskinnmno() {
        return iwsKyksyaskinnmno;
    }

    public void setIwsKyksyaskinnmno(String pIwsKyksyaskinnmno) {
        iwsKyksyaskinnmno = pIwsKyksyaskinnmno;
    }

    @Column(order = 7, length = 1)
    private String iwsNkuktnysjissikekkakbn;

    public String getIwsNkuktnysjissikekkakbn() {
        return iwsNkuktnysjissikekkakbn;
    }

    public void setIwsNkuktnysjissikekkakbn(String pIwsNkuktnysjissikekkakbn) {
        iwsNkuktnysjissikekkakbn = pIwsNkuktnysjissikekkakbn;
    }

    @Column(order = 8, length = 10)
    private String iwsNkuketorininsakuinno;

    public String getIwsNkuketorininsakuinno() {
        return iwsNkuketorininsakuinno;
    }

    public void setIwsNkuketorininsakuinno(String pIwsNkuketorininsakuinno) {
        iwsNkuketorininsakuinno = pIwsNkuketorininsakuinno;
    }

    @Column(order = 9, length = 18)
    private String iwsYoukyuuno;

    public String getIwsYoukyuuno() {
        return iwsYoukyuuno;
    }

    public void setIwsYoukyuuno(String pIwsYoukyuuno) {
        iwsYoukyuuno = pIwsYoukyuuno;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
