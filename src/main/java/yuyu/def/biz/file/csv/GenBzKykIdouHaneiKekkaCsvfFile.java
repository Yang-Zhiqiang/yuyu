package yuyu.def.biz.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）普保Ⅱ契約異動反映結果ＣＳＶＦファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzKykIdouHaneiKekkaCsvfFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzKykIdouHaneiKekkaCsvfFile() {
    }

    @Column(order = 1, label = "（ＩＦｃ）普保Ⅱ契約番号区分")
    private String ifcHuho2kyknokbn;

    public String getIfcHuho2kyknokbn() {
        return ifcHuho2kyknokbn;
    }

    public void setIfcHuho2kyknokbn(String pIfcHuho2kyknokbn) {
        ifcHuho2kyknokbn = pIfcHuho2kyknokbn;
    }

    @Column(order = 2, label = "（ＩＦｃ）普保Ⅱ契約番号")
    private String ifcHuho2kykno;

    public String getIfcHuho2kykno() {
        return ifcHuho2kykno;
    }

    public void setIfcHuho2kykno(String pIfcHuho2kykno) {
        ifcHuho2kykno = pIfcHuho2kykno;
    }

    @Column(order = 3, label = "（ＩＦｃ）契約内容反映エラー区分")
    private String ifcKyknaiyouhaneierrkbn;

    public String getIfcKyknaiyouhaneierrkbn() {
        return ifcKyknaiyouhaneierrkbn;
    }

    public void setIfcKyknaiyouhaneierrkbn(String pIfcKyknaiyouhaneierrkbn) {
        ifcKyknaiyouhaneierrkbn = pIfcKyknaiyouhaneierrkbn;
    }

    @Column(order = 4, label = "（ＩＦｃ）通算基準超過表示")
    private String ifcTsnkijyuntyoukahyj;

    public String getIfcTsnkijyuntyoukahyj() {
        return ifcTsnkijyuntyoukahyj;
    }

    public void setIfcTsnkijyuntyoukahyj(String pIfcTsnkijyuntyoukahyj) {
        ifcTsnkijyuntyoukahyj = pIfcTsnkijyuntyoukahyj;
    }

    @Column(order = 5, label = "（ＩＦｃ）被保険者名寄せ不明表示")
    private String ifcHhknnayosehumeihyj;

    public String getIfcHhknnayosehumeihyj() {
        return ifcHhknnayosehumeihyj;
    }

    public void setIfcHhknnayosehumeihyj(String pIfcHhknnayosehumeihyj) {
        ifcHhknnayosehumeihyj = pIfcHhknnayosehumeihyj;
    }

    @Column(order = 6, label = "（ＩＦｃ）契約者名寄せ不明表示")
    private String ifcKyknayosehumeihyj;

    public String getIfcKyknayosehumeihyj() {
        return ifcKyknayosehumeihyj;
    }

    public void setIfcKyknayosehumeihyj(String pIfcKyknayosehumeihyj) {
        ifcKyknayosehumeihyj = pIfcKyknayosehumeihyj;
    }

    @Column(order = 7, label = "（ＩＦｃ）年金受取人名寄せ不明表示")
    private String ifcNkuktnayosehumeihyj;

    public String getIfcNkuktnayosehumeihyj() {
        return ifcNkuktnayosehumeihyj;
    }

    public void setIfcNkuktnayosehumeihyj(String pIfcNkuktnayosehumeihyj) {
        ifcNkuktnayosehumeihyj = pIfcNkuktnayosehumeihyj;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
