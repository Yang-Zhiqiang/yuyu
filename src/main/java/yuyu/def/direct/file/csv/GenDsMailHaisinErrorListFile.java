package yuyu.def.direct.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （ダイレクト）メール配信エラーリストファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenDsMailHaisinErrorListFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenDsMailHaisinErrorListFile() {
    }

    @Column(order = 1, label = "（ＩＦｃ）ＤＳ顧客メールアドレス識別キー")
    private String ifcDskokmailaddressskbtkey;

    public String getIfcDskokmailaddressskbtkey() {
        return ifcDskokmailaddressskbtkey;
    }

    public void setIfcDskokmailaddressskbtkey(String pIfcDskokmailaddressskbtkey) {
        ifcDskokmailaddressskbtkey = pIfcDskokmailaddressskbtkey;
    }

    @Column(order = 2, label = "（ＩＦｃ）ＤＳ送信メール種別区分")
    private String ifcDssousinmailsyubetukbn;

    public String getIfcDssousinmailsyubetukbn() {
        return ifcDssousinmailsyubetukbn;
    }

    public void setIfcDssousinmailsyubetukbn(String pIfcDssousinmailsyubetukbn) {
        ifcDssousinmailsyubetukbn = pIfcDssousinmailsyubetukbn;
    }

    @Column(order = 3, label = "（ＩＦｃ）ＤＳ送信番号")
    private String ifcDssousinno;

    public String getIfcDssousinno() {
        return ifcDssousinno;
    }

    public void setIfcDssousinno(String pIfcDssousinno) {
        ifcDssousinno = pIfcDssousinno;
    }

    @Column(order = 4, label = "（ＩＦｃ）証券番号")
    private String ifcSyono;

    public String getIfcSyono() {
        return ifcSyono;
    }

    public void setIfcSyono(String pIfcSyono) {
        ifcSyono = pIfcSyono;
    }

    @Column(order = 5, label = "（ＩＦｃ）ＤＳメールアドレス")
    private String ifcDsmailaddress;

    public String getIfcDsmailaddress() {
        return ifcDsmailaddress;
    }

    public void setIfcDsmailaddress(String pIfcDsmailaddress) {
        ifcDsmailaddress = pIfcDsmailaddress;
    }

    @Column(order = 6, label = "（ＩＦｃ）送信日")
    private String ifcSousinymd;

    public String getIfcSousinymd() {
        return ifcSousinymd;
    }

    public void setIfcSousinymd(String pIfcSousinymd) {
        ifcSousinymd = pIfcSousinymd;
    }

    @Column(order = 7, label = "（ＩＦｃ）削除日")
    private String ifcSakujyoymd;

    public String getIfcSakujyoymd() {
        return ifcSakujyoymd;
    }

    public void setIfcSakujyoymd(String pIfcSakujyoymd) {
        ifcSakujyoymd = pIfcSakujyoymd;
    }

    @Column(order = 8, label = "（ＩＦｃ）配信エラーカウント")
    private String ifcHaisinerrorcount;

    public String getIfcHaisinerrorcount() {
        return ifcHaisinerrorcount;
    }

    public void setIfcHaisinerrorcount(String pIfcHaisinerrorcount) {
        ifcHaisinerrorcount = pIfcHaisinerrorcount;
    }

    @Column(order = 9, label = "（ＩＦｃ）配信エラーカウント２")
    private String ifcHaisinerrorcount2;

    public String getIfcHaisinerrorcount2() {
        return ifcHaisinerrorcount2;
    }

    public void setIfcHaisinerrorcount2(String pIfcHaisinerrorcount2) {
        ifcHaisinerrorcount2 = pIfcHaisinerrorcount2;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
