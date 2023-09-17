package yuyu.def.biz.file.excel;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.excel.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）契約保全手続履歴テーブルレイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzKhTtdkRirekiLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzKhTtdkRirekiLayoutFile() {
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

    @Column(order = 3, label = "henkousikibetukey")
    private String ifeTshenkousikibetukey;

    public String getIfeTshenkousikibetukey() {
        return ifeTshenkousikibetukey;
    }

    public void setIfeTshenkousikibetukey(String pIfeTshenkousikibetukey) {
        ifeTshenkousikibetukey = pIfeTshenkousikibetukey;
    }

    @Column(order = 4, label = "syoriYmd")
    private String ifeTssyoriymd;

    public String getIfeTssyoriymd() {
        return ifeTssyoriymd;
    }

    public void setIfeTssyoriymd(String pIfeTssyoriymd) {
        ifeTssyoriymd = pIfeTssyoriymd;
    }

    @Column(order = 5, label = "syorisosikicd")
    private String ifeTssyorisosikicd;

    public String getIfeTssyorisosikicd() {
        return ifeTssyorisosikicd;
    }

    public void setIfeTssyorisosikicd(String pIfeTssyorisosikicd) {
        ifeTssyorisosikicd = pIfeTssyorisosikicd;
    }

    @Column(order = 6, label = "shrsyousaiumu")
    private String ifeTsshrsyousaiumu;

    public String getIfeTsshrsyousaiumu() {
        return ifeTsshrsyousaiumu;
    }

    public void setIfeTsshrsyousaiumu(String pIfeTsshrsyousaiumu) {
        ifeTsshrsyousaiumu = pIfeTsshrsyousaiumu;
    }

    @Column(order = 7, label = "syorikbn")
    private String ifeTssyorikbn;

    public String getIfeTssyorikbn() {
        return ifeTssyorikbn;
    }

    public void setIfeTssyorikbn(String pIfeTssyorikbn) {
        ifeTssyorikbn = pIfeTssyorikbn;
    }

    @Column(order = 8, label = "honninkakninkekkakbn")
    private String ifeTshonninkakninkekkakbn;

    public String getIfeTshonninkakninkekkakbn() {
        return ifeTshonninkakninkekkakbn;
    }

    public void setIfeTshonninkakninkekkakbn(String pIfeTshonninkakninkekkakbn) {
        ifeTshonninkakninkekkakbn = pIfeTshonninkakninkekkakbn;
    }

    @Column(order = 9, label = "henkourrkumu")
    private String ifeTshenkourrkumu;

    public String getIfeTshenkourrkumu() {
        return ifeTshenkourrkumu;
    }

    public void setIfeTshenkourrkumu(String pIfeTshenkourrkumu) {
        ifeTshenkourrkumu = pIfeTshenkourrkumu;
    }

    @Column(order = 10, label = "smbckanriid")
    private String ifeTssmbckanriid;

    public String getIfeTssmbckanriid() {
        return ifeTssmbckanriid;
    }

    public void setIfeTssmbckanriid(String pIfeTssmbckanriid) {
        ifeTssmbckanriid = pIfeTssmbckanriid;
    }

    @Column(order = 11, label = "nayosekihontblskbtkey")
    private String ifeTsnayosekihontblskbtkey;

    public String getIfeTsnayosekihontblskbtkey() {
        return ifeTsnayosekihontblskbtkey;
    }

    public void setIfeTsnayosekihontblskbtkey(String pIfeTsnayosekihontblskbtkey) {
        ifeTsnayosekihontblskbtkey = pIfeTsnayosekihontblskbtkey;
    }

    @Column(order = 12, label = "kouteikanriid")
    private String ifeTskouteikanriid;

    public String getIfeTskouteikanriid() {
        return ifeTskouteikanriid;
    }

    public void setIfeTskouteikanriid(String pIfeTskouteikanriid) {
        ifeTskouteikanriid = pIfeTskouteikanriid;
    }

    @Column(order = 13, label = "youkyuuno")
    private String ifeTsyoukyuuno;

    public String getIfeTsyoukyuuno() {
        return ifeTsyoukyuuno;
    }

    public void setIfeTsyoukyuuno(String pIfeTsyoukyuuno) {
        ifeTsyoukyuuno = pIfeTsyoukyuuno;
    }

    @Column(order = 14, label = "gyoumuKousinKinou")
    private String ifeTsgyoumukousinkinou;

    public String getIfeTsgyoumukousinkinou() {
        return ifeTsgyoumukousinkinou;
    }

    public void setIfeTsgyoumukousinkinou(String pIfeTsgyoumukousinkinou) {
        ifeTsgyoumukousinkinou = pIfeTsgyoumukousinkinou;
    }

    @Column(order = 15, label = "gyoumuKousinsyaId")
    private String ifeTsgyoumukousinsyaid;

    public String getIfeTsgyoumukousinsyaid() {
        return ifeTsgyoumukousinsyaid;
    }

    public void setIfeTsgyoumukousinsyaid(String pIfeTsgyoumukousinsyaid) {
        ifeTsgyoumukousinsyaid = pIfeTsgyoumukousinsyaid;
    }

    @Column(order = 16, label = "gyoumuKousinTime")
    private String ifeTsgyoumukousintime;

    public String getIfeTsgyoumukousintime() {
        return ifeTsgyoumukousintime;
    }

    public void setIfeTsgyoumukousintime(String pIfeTsgyoumukousintime) {
        ifeTsgyoumukousintime = pIfeTsgyoumukousintime;
    }

    @Column(order = 17, label = "kousinsyaId")
    private String ifeTskousinsyaid;

    public String getIfeTskousinsyaid() {
        return ifeTskousinsyaid;
    }

    public void setIfeTskousinsyaid(String pIfeTskousinsyaid) {
        ifeTskousinsyaid = pIfeTskousinsyaid;
    }

    @Column(order = 18, label = "kousinTime")
    private String ifeTskousintime;

    public String getIfeTskousintime() {
        return ifeTskousintime;
    }

    public void setIfeTskousintime(String pIfeTskousintime) {
        ifeTskousintime = pIfeTskousintime;
    }

    @Column(order = 19, label = "kousinKinou")
    private String ifeTskousinkinou;

    public String getIfeTskousinkinou() {
        return ifeTskousinkinou;
    }

    public void setIfeTskousinkinou(String pIfeTskousinkinou) {
        ifeTskousinkinou = pIfeTskousinkinou;
    }

    @Column(order = 20, label = "version")
    private String ifeTsversion;

    public String getIfeTsversion() {
        return ifeTsversion;
    }

    public void setIfeTsversion(String pIfeTsversion) {
        ifeTsversion = pIfeTsversion;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
