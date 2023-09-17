package yuyu.def.biz.file.excel;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.excel.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）案内収納基本テーブルレイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzAnsyuKihonLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzAnsyuKihonLayoutFile() {
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

    @Column(order = 3, label = "jkipjytym")
    private String ifeTsjkipjytym;

    public String getIfeTsjkipjytym() {
        return ifeTsjkipjytym;
    }

    public void setIfeTsjkipjytym(String pIfeTsjkipjytym) {
        ifeTsjkipjytym = pIfeTsjkipjytym;
    }

    @Column(order = 4, label = "tkiktannaitukisuu")
    private String ifeTstkiktannaitukisuu;

    public String getIfeTstkiktannaitukisuu() {
        return ifeTstkiktannaitukisuu;
    }

    public void setIfeTstkiktannaitukisuu(String pIfeTstkiktannaitukisuu) {
        ifeTstkiktannaitukisuu = pIfeTstkiktannaitukisuu;
    }

    @Column(order = 5, label = "kjsmhakkouzumiflg")
    private String ifeTskjsmhakkouzumiflg;

    public String getIfeTskjsmhakkouzumiflg() {
        return ifeTskjsmhakkouzumiflg;
    }

    public void setIfeTskjsmhakkouzumiflg(String pIfeTskjsmhakkouzumiflg) {
        ifeTskjsmhakkouzumiflg = pIfeTskjsmhakkouzumiflg;
    }

    @Column(order = 6, label = "syuharaimanymd")
    private String ifeTssyuharaimanymd;

    public String getIfeTssyuharaimanymd() {
        return ifeTssyuharaimanymd;
    }

    public void setIfeTssyuharaimanymd(String pIfeTssyuharaimanymd) {
        ifeTssyuharaimanymd = pIfeTssyuharaimanymd;
    }

    @Column(order = 7, label = "gyoumuKousinKinou")
    private String ifeTsgyoumukousinkinou;

    public String getIfeTsgyoumukousinkinou() {
        return ifeTsgyoumukousinkinou;
    }

    public void setIfeTsgyoumukousinkinou(String pIfeTsgyoumukousinkinou) {
        ifeTsgyoumukousinkinou = pIfeTsgyoumukousinkinou;
    }

    @Column(order = 8, label = "gyoumuKousinsyaId")
    private String ifeTsgyoumukousinsyaid;

    public String getIfeTsgyoumukousinsyaid() {
        return ifeTsgyoumukousinsyaid;
    }

    public void setIfeTsgyoumukousinsyaid(String pIfeTsgyoumukousinsyaid) {
        ifeTsgyoumukousinsyaid = pIfeTsgyoumukousinsyaid;
    }

    @Column(order = 9, label = "gyoumuKousinTime")
    private String ifeTsgyoumukousintime;

    public String getIfeTsgyoumukousintime() {
        return ifeTsgyoumukousintime;
    }

    public void setIfeTsgyoumukousintime(String pIfeTsgyoumukousintime) {
        ifeTsgyoumukousintime = pIfeTsgyoumukousintime;
    }

    @Column(order = 10, label = "kousinsyaId")
    private String ifeTskousinsyaid;

    public String getIfeTskousinsyaid() {
        return ifeTskousinsyaid;
    }

    public void setIfeTskousinsyaid(String pIfeTskousinsyaid) {
        ifeTskousinsyaid = pIfeTskousinsyaid;
    }

    @Column(order = 11, label = "kousinTime")
    private String ifeTskousintime;

    public String getIfeTskousintime() {
        return ifeTskousintime;
    }

    public void setIfeTskousintime(String pIfeTskousintime) {
        ifeTskousintime = pIfeTskousintime;
    }

    @Column(order = 12, label = "kousinKinou")
    private String ifeTskousinkinou;

    public String getIfeTskousinkinou() {
        return ifeTskousinkinou;
    }

    public void setIfeTskousinkinou(String pIfeTskousinkinou) {
        ifeTskousinkinou = pIfeTskousinkinou;
    }

    @Column(order = 13, label = "version")
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
