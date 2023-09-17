package yuyu.def.biz.file.excel;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.excel.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）口座テーブルレイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzKouzaLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzKouzaLayoutFile() {
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

    @Column(order = 3, label = "kokno")
    private String ifeTskokno;

    public String getIfeTskokno() {
        return ifeTskokno;
    }

    public void setIfeTskokno(String pIfeTskokno) {
        ifeTskokno = pIfeTskokno;
    }

    @Column(order = 4, label = "bankcd")
    private String ifeTsbankcd;

    public String getIfeTsbankcd() {
        return ifeTsbankcd;
    }

    public void setIfeTsbankcd(String pIfeTsbankcd) {
        ifeTsbankcd = pIfeTsbankcd;
    }

    @Column(order = 5, label = "sitencd")
    private String ifeTssitencd;

    public String getIfeTssitencd() {
        return ifeTssitencd;
    }

    public void setIfeTssitencd(String pIfeTssitencd) {
        ifeTssitencd = pIfeTssitencd;
    }

    @Column(order = 6, label = "yokinkbn")
    private String ifeTsyokinkbn;

    public String getIfeTsyokinkbn() {
        return ifeTsyokinkbn;
    }

    public void setIfeTsyokinkbn(String pIfeTsyokinkbn) {
        ifeTsyokinkbn = pIfeTsyokinkbn;
    }

    @Column(order = 7, label = "kouzano")
    private String ifeTskouzano;

    public String getIfeTskouzano() {
        return ifeTskouzano;
    }

    public void setIfeTskouzano(String pIfeTskouzano) {
        ifeTskouzano = pIfeTskouzano;
    }

    @Column(order = 8, label = "kzmeiginmkn")
    private String ifeTskzmeiginmkn;

    public String getIfeTskzmeiginmkn() {
        return ifeTskzmeiginmkn;
    }

    public void setIfeTskzmeiginmkn(String pIfeTskzmeiginmkn) {
        ifeTskzmeiginmkn = pIfeTskzmeiginmkn;
    }

    @Column(order = 9, label = "sinkeizkkbn")
    private String ifeTssinkeizkkbn;

    public String getIfeTssinkeizkkbn() {
        return ifeTssinkeizkkbn;
    }

    public void setIfeTssinkeizkkbn(String pIfeTssinkeizkkbn) {
        ifeTssinkeizkkbn = pIfeTssinkeizkkbn;
    }

    @Column(order = 10, label = "syuudaikocd")
    private String ifeTssyuudaikocd;

    public String getIfeTssyuudaikocd() {
        return ifeTssyuudaikocd;
    }

    public void setIfeTssyuudaikocd(String pIfeTssyuudaikocd) {
        ifeTssyuudaikocd = pIfeTssyuudaikocd;
    }

    @Column(order = 11, label = "kzkykdoukbn")
    private String ifeTskzkykdoukbn;

    public String getIfeTskzkykdoukbn() {
        return ifeTskzkykdoukbn;
    }

    public void setIfeTskzkykdoukbn(String pIfeTskzkykdoukbn) {
        ifeTskzkykdoukbn = pIfeTskzkykdoukbn;
    }

    @Column(order = 12, label = "gyoumuKousinKinou")
    private String ifeTsgyoumukousinkinou;

    public String getIfeTsgyoumukousinkinou() {
        return ifeTsgyoumukousinkinou;
    }

    public void setIfeTsgyoumukousinkinou(String pIfeTsgyoumukousinkinou) {
        ifeTsgyoumukousinkinou = pIfeTsgyoumukousinkinou;
    }

    @Column(order = 13, label = "gyoumuKousinsyaId")
    private String ifeTsgyoumukousinsyaid;

    public String getIfeTsgyoumukousinsyaid() {
        return ifeTsgyoumukousinsyaid;
    }

    public void setIfeTsgyoumukousinsyaid(String pIfeTsgyoumukousinsyaid) {
        ifeTsgyoumukousinsyaid = pIfeTsgyoumukousinsyaid;
    }

    @Column(order = 14, label = "gyoumuKousinTime")
    private String ifeTsgyoumukousintime;

    public String getIfeTsgyoumukousintime() {
        return ifeTsgyoumukousintime;
    }

    public void setIfeTsgyoumukousintime(String pIfeTsgyoumukousintime) {
        ifeTsgyoumukousintime = pIfeTsgyoumukousintime;
    }

    @Column(order = 15, label = "kousinsyaId")
    private String ifeTskousinsyaid;

    public String getIfeTskousinsyaid() {
        return ifeTskousinsyaid;
    }

    public void setIfeTskousinsyaid(String pIfeTskousinsyaid) {
        ifeTskousinsyaid = pIfeTskousinsyaid;
    }

    @Column(order = 16, label = "kousinTime")
    private String ifeTskousintime;

    public String getIfeTskousintime() {
        return ifeTskousintime;
    }

    public void setIfeTskousintime(String pIfeTskousintime) {
        ifeTskousintime = pIfeTskousintime;
    }

    @Column(order = 17, label = "kousinKinou")
    private String ifeTskousinkinou;

    public String getIfeTskousinkinou() {
        return ifeTskousinkinou;
    }

    public void setIfeTskousinkinou(String pIfeTskousinkinou) {
        ifeTskousinkinou = pIfeTskousinkinou;
    }

    @Column(order = 18, label = "version")
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
