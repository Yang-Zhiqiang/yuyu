package yuyu.def.direct.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （ダイレクト）メールエラーリストファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenDsMailErrorListFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenDsMailErrorListFile() {
    }

    @Column(order = 1, label = "（ＩＦｃ）ＤＳ顧客メールアドレス識別キー")
    private String ifcDskokmailaddressskbtkey;

    public String getIfcDskokmailaddressskbtkey() {
        return ifcDskokmailaddressskbtkey;
    }

    public void setIfcDskokmailaddressskbtkey(String pIfcDskokmailaddressskbtkey) {
        ifcDskokmailaddressskbtkey = pIfcDskokmailaddressskbtkey;
    }

    @Column(order = 2, label = "（ＩＦｃ）ＤＳメールアドレス")
    private String ifcDsmailaddress;

    public String getIfcDsmailaddress() {
        return ifcDsmailaddress;
    }

    public void setIfcDsmailaddress(String pIfcDsmailaddress) {
        ifcDsmailaddress = pIfcDsmailaddress;
    }

    @Column(order = 3, label = "（ＩＦｃ）サンキューメール送信番号")
    private String ifcThanksmailsousinno;

    public String getIfcThanksmailsousinno() {
        return ifcThanksmailsousinno;
    }

    public void setIfcThanksmailsousinno(String pIfcThanksmailsousinno) {
        ifcThanksmailsousinno = pIfcThanksmailsousinno;
    }

    @Column(order = 4, label = "（ＩＦｃ）配信メール区分１")
    private String ifcHaisinmailkbn1;

    public String getIfcHaisinmailkbn1() {
        return ifcHaisinmailkbn1;
    }

    public void setIfcHaisinmailkbn1(String pIfcHaisinmailkbn1) {
        ifcHaisinmailkbn1 = pIfcHaisinmailkbn1;
    }

    @Column(order = 5, label = "（ＩＦｃ）配信メール区分２")
    private String ifcHaisinmailkbn2;

    public String getIfcHaisinmailkbn2() {
        return ifcHaisinmailkbn2;
    }

    public void setIfcHaisinmailkbn2(String pIfcHaisinmailkbn2) {
        ifcHaisinmailkbn2 = pIfcHaisinmailkbn2;
    }

    @Column(order = 6, label = "（ＩＦｃ）配信メール区分３")
    private String ifcHaisinmailkbn3;

    public String getIfcHaisinmailkbn3() {
        return ifcHaisinmailkbn3;
    }

    public void setIfcHaisinmailkbn3(String pIfcHaisinmailkbn3) {
        ifcHaisinmailkbn3 = pIfcHaisinmailkbn3;
    }

    @Column(order = 7, label = "（ＩＦｃ）配信メール区分４")
    private String ifcHaisinmailkbn4;

    public String getIfcHaisinmailkbn4() {
        return ifcHaisinmailkbn4;
    }

    public void setIfcHaisinmailkbn4(String pIfcHaisinmailkbn4) {
        ifcHaisinmailkbn4 = pIfcHaisinmailkbn4;
    }

    @Column(order = 8, label = "（ＩＦｃ）配信メール区分")
    private String ifcHaisinmailkbn5;

    public String getIfcHaisinmailkbn5() {
        return ifcHaisinmailkbn5;
    }

    public void setIfcHaisinmailkbn5(String pIfcHaisinmailkbn5) {
        ifcHaisinmailkbn5 = pIfcHaisinmailkbn5;
    }

    @Column(order = 9, label = "（ＩＦｃ）配信エラーカウント")
    private String ifcHaisinerrorcount;

    public String getIfcHaisinerrorcount() {
        return ifcHaisinerrorcount;
    }

    public void setIfcHaisinerrorcount(String pIfcHaisinerrorcount) {
        ifcHaisinerrorcount = pIfcHaisinerrorcount;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
