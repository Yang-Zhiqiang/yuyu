package yuyu.def.biz.file.excel;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.excel.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）契約受取人テーブルレイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzKykUktLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzKykUktLayoutFile() {
    }

    @Column(order = 1, label = "kbnkey")
    private String ifeTskbnkey;

    public String getIfeTskbnkey() {
        return ifeTskbnkey;
    }

    public void setIfeTskbnkey(String pIfeTskbnkey) {
        ifeTskbnkey = pIfeTskbnkey;
    }

    @Column(order = 2, label = "syono")
    private String ifeTssyono;

    public String getIfeTssyono() {
        return ifeTssyono;
    }

    public void setIfeTssyono(String pIfeTssyono) {
        ifeTssyono = pIfeTssyono;
    }

    @Column(order = 3, label = "uktsyukbn")
    private String ifeTsuktsyukbn;

    public String getIfeTsuktsyukbn() {
        return ifeTsuktsyukbn;
    }

    public void setIfeTsuktsyukbn(String pIfeTsuktsyukbn) {
        ifeTsuktsyukbn = pIfeTsuktsyukbn;
    }

    @Column(order = 4, label = "uktsyurenno")
    private String ifeTsuktsyurenno;

    public String getIfeTsuktsyurenno() {
        return ifeTsuktsyurenno;
    }

    public void setIfeTsuktsyurenno(String pIfeTsuktsyurenno) {
        ifeTsuktsyurenno = pIfeTsuktsyurenno;
    }

    @Column(order = 5, label = "kokno")
    private String ifeTskokno;

    public String getIfeTskokno() {
        return ifeTskokno;
    }

    public void setIfeTskokno(String pIfeTskokno) {
        ifeTskokno = pIfeTskokno;
    }

    @Column(order = 6, label = "uktkbn")
    private String ifeTsuktkbn;

    public String getIfeTsuktkbn() {
        return ifeTsuktkbn;
    }

    public void setIfeTsuktkbn(String pIfeTsuktkbn) {
        ifeTsuktkbn = pIfeTsuktkbn;
    }

    @Column(order = 7, label = "uktnmkn")
    private String ifeTsuktnmkn;

    public String getIfeTsuktnmkn() {
        return ifeTsuktnmkn;
    }

    public void setIfeTsuktnmkn(String pIfeTsuktnmkn) {
        ifeTsuktnmkn = pIfeTsuktnmkn;
    }

    @Column(order = 8, label = "uktnmkj")
    private String ifeTsuktnmkj;

    public String getIfeTsuktnmkj() {
        return ifeTsuktnmkj;
    }

    public void setIfeTsuktnmkj(String pIfeTsuktnmkj) {
        ifeTsuktnmkj = pIfeTsuktnmkj;
    }

    @Column(order = 9, label = "uktnmkjkhukakbn")
    private String ifeTsuktnmkjkhukakbn;

    public String getIfeTsuktnmkjkhukakbn() {
        return ifeTsuktnmkjkhukakbn;
    }

    public void setIfeTsuktnmkjkhukakbn(String pIfeTsuktnmkjkhukakbn) {
        ifeTsuktnmkjkhukakbn = pIfeTsuktnmkjkhukakbn;
    }

    @Column(order = 10, label = "uktseiymd")
    private String ifeTsuktseiymd;

    public String getIfeTsuktseiymd() {
        return ifeTsuktseiymd;
    }

    public void setIfeTsuktseiymd(String pIfeTsuktseiymd) {
        ifeTsuktseiymd = pIfeTsuktseiymd;
    }

    @Column(order = 11, label = "ukttdk")
    private String ifeTsukttdk;

    public String getIfeTsukttdk() {
        return ifeTsukttdk;
    }

    public void setIfeTsukttdk(String pIfeTsukttdk) {
        ifeTsukttdk = pIfeTsukttdk;
    }

    @Column(order = 12, label = "uktbnwari")
    private String ifeTsuktbnwari;

    public String getIfeTsuktbnwari() {
        return ifeTsuktbnwari;
    }

    public void setIfeTsuktbnwari(String pIfeTsuktbnwari) {
        ifeTsuktbnwari = pIfeTsuktbnwari;
    }

    @Column(order = 13, label = "gyoumuKousinKinou")
    private String ifeTsgyoumukousinkinou;

    public String getIfeTsgyoumukousinkinou() {
        return ifeTsgyoumukousinkinou;
    }

    public void setIfeTsgyoumukousinkinou(String pIfeTsgyoumukousinkinou) {
        ifeTsgyoumukousinkinou = pIfeTsgyoumukousinkinou;
    }

    @Column(order = 14, label = "gyoumuKousinsyaId")
    private String ifeTsgyoumukousinsyaid;

    public String getIfeTsgyoumukousinsyaid() {
        return ifeTsgyoumukousinsyaid;
    }

    public void setIfeTsgyoumukousinsyaid(String pIfeTsgyoumukousinsyaid) {
        ifeTsgyoumukousinsyaid = pIfeTsgyoumukousinsyaid;
    }

    @Column(order = 15, label = "gyoumuKousinTime")
    private String ifeTsgyoumukousintime;

    public String getIfeTsgyoumukousintime() {
        return ifeTsgyoumukousintime;
    }

    public void setIfeTsgyoumukousintime(String pIfeTsgyoumukousintime) {
        ifeTsgyoumukousintime = pIfeTsgyoumukousintime;
    }

    @Column(order = 16, label = "kousinsyaId")
    private String ifeTskousinsyaid;

    public String getIfeTskousinsyaid() {
        return ifeTskousinsyaid;
    }

    public void setIfeTskousinsyaid(String pIfeTskousinsyaid) {
        ifeTskousinsyaid = pIfeTskousinsyaid;
    }

    @Column(order = 17, label = "kousinTime")
    private String ifeTskousintime;

    public String getIfeTskousintime() {
        return ifeTskousintime;
    }

    public void setIfeTskousintime(String pIfeTskousintime) {
        ifeTskousintime = pIfeTskousintime;
    }

    @Column(order = 18, label = "kousinKinou")
    private String ifeTskousinkinou;

    public String getIfeTskousinkinou() {
        return ifeTskousinkinou;
    }

    public void setIfeTskousinkinou(String pIfeTskousinkinou) {
        ifeTskousinkinou = pIfeTskousinkinou;
    }

    @Column(order = 19, label = "version")
    private String ifeTsversion;

    public String getIfeTsversion() {
        return ifeTsversion;
    }

    public void setIfeTsversion(String pIfeTsversion) {
        ifeTsversion = pIfeTsversion;
    }

    @Column(order = 20, label = "uktyno")
    private String ifeTsuktyno;

    public String getIfeTsuktyno() {
        return ifeTsuktyno;
    }

    public void setIfeTsuktyno(String pIfeTsuktyno) {
        ifeTsuktyno = pIfeTsuktyno;
    }

    @Column(order = 21, label = "uktadr1kj")
    private String ifeTsuktadr1kj;

    public String getIfeTsuktadr1kj() {
        return ifeTsuktadr1kj;
    }

    public void setIfeTsuktadr1kj(String pIfeTsuktadr1kj) {
        ifeTsuktadr1kj = pIfeTsuktadr1kj;
    }

    @Column(order = 22, label = "uktadr2kj")
    private String ifeTsuktadr2kj;

    public String getIfeTsuktadr2kj() {
        return ifeTsuktadr2kj;
    }

    public void setIfeTsuktadr2kj(String pIfeTsuktadr2kj) {
        ifeTsuktadr2kj = pIfeTsuktadr2kj;
    }

    @Column(order = 23, label = "uktadr3kj")
    private String ifeTsuktadr3kj;

    public String getIfeTsuktadr3kj() {
        return ifeTsuktadr3kj;
    }

    public void setIfeTsuktadr3kj(String pIfeTsuktadr3kj) {
        ifeTsuktadr3kj = pIfeTsuktadr3kj;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
