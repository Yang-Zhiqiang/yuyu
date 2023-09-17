package yuyu.def.biz.file.excel;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.excel.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）医的統計用情報テーブルレイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzItekiToukeiInfoLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzItekiToukeiInfoLayoutFile() {
    }

    @Column(order = 1, label = "syono")
    private String ifeTssyono;

    public String getIfeTssyono() {
        return ifeTssyono;
    }

    public void setIfeTssyono(String pIfeTssyono) {
        ifeTssyono = pIfeTssyono;
    }

    @Column(order = 2, label = "ketkekkacd")
    private String ifeTsketkekkacd;

    public String getIfeTsketkekkacd() {
        return ifeTsketkekkacd;
    }

    public void setIfeTsketkekkacd(String pIfeTsketkekkacd) {
        ifeTsketkekkacd = pIfeTsketkekkacd;
    }

    @Column(order = 3, label = "palketsyacd")
    private String ifeTspalketsyacd;

    public String getIfeTspalketsyacd() {
        return ifeTspalketsyacd;
    }

    public void setIfeTspalketsyacd(String pIfeTspalketsyacd) {
        ifeTspalketsyacd = pIfeTspalketsyacd;
    }

    @Column(order = 4, label = "kousinsyaId")
    private String ifeTskousinsyaid;

    public String getIfeTskousinsyaid() {
        return ifeTskousinsyaid;
    }

    public void setIfeTskousinsyaid(String pIfeTskousinsyaid) {
        ifeTskousinsyaid = pIfeTskousinsyaid;
    }

    @Column(order = 5, label = "kousinTime")
    private String ifeTskousintime;

    public String getIfeTskousintime() {
        return ifeTskousintime;
    }

    public void setIfeTskousintime(String pIfeTskousintime) {
        ifeTskousintime = pIfeTskousintime;
    }

    @Column(order = 6, label = "kousinKinou")
    private String ifeTskousinkinou;

    public String getIfeTskousinkinou() {
        return ifeTskousinkinou;
    }

    public void setIfeTskousinkinou(String pIfeTskousinkinou) {
        ifeTskousinkinou = pIfeTskousinkinou;
    }

    @Column(order = 7, label = "version")
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
