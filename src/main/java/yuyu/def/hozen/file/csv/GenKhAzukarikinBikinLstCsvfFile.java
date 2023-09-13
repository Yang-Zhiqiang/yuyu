package yuyu.def.hozen.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保全）預り金備金リストＣＳＶＦファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhAzukarikinBikinLstCsvfFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhAzukarikinBikinLstCsvfFile() {
    }

    @Column(order = 1, label = "リスト名")
    private String ifcListnm;

    public String getIfcListnm() {
        return ifcListnm;
    }

    public void setIfcListnm(String pIfcListnm) {
        ifcListnm = pIfcListnm;
    }

    @Column(order = 2, label = "決算年度")
    private String ifcKessannnd;

    public String getIfcKessannnd() {
        return ifcKessannnd;
    }

    public void setIfcKessannnd(String pIfcKessannnd) {
        ifcKessannnd = pIfcKessannnd;
    }

    @Column(order = 3, label = "セグメントコード")
    private String ifcSegcd;

    public String getIfcSegcd() {
        return ifcSegcd;
    }

    public void setIfcSegcd(String pIfcSegcd) {
        ifcSegcd = pIfcSegcd;
    }

    @Column(order = 4, label = "保険種類レベル")
    private String ifcHknsyuruilevel;

    public String getIfcHknsyuruilevel() {
        return ifcHknsyuruilevel;
    }

    public void setIfcHknsyuruilevel(String pIfcHknsyuruilevel) {
        ifcHknsyuruilevel = pIfcHknsyuruilevel;
    }

    @Column(order = 5, label = "通貨種類")
    private String ifcTuukasyu;

    public String getIfcTuukasyu() {
        return ifcTuukasyu;
    }

    public void setIfcTuukasyu(String pIfcTuukasyu) {
        ifcTuukasyu = pIfcTuukasyu;
    }

    @Column(order = 6, label = "為替レート")
    private String ifcKawaserate;

    public String getIfcKawaserate() {
        return ifcKawaserate;
    }

    public void setIfcKawaserate(String pIfcKawaserate) {
        ifcKawaserate = pIfcKawaserate;
    }

    @Column(order = 7, label = "証券番号")
    private String ifcSyono;

    public String getIfcSyono() {
        return ifcSyono;
    }

    public void setIfcSyono(String pIfcSyono) {
        ifcSyono = pIfcSyono;
    }

    @Column(order = 8, label = "備金コード")
    private String ifcBkncd;

    public String getIfcBkncd() {
        return ifcBkncd;
    }

    public void setIfcBkncd(String pIfcBkncd) {
        ifcBkncd = pIfcBkncd;
    }

    @Column(order = 9, label = "備金計上日")
    private String ifcBknkeiymd;

    public String getIfcBknkeiymd() {
        return ifcBknkeiymd;
    }

    public void setIfcBknkeiymd(String pIfcBknkeiymd) {
        ifcBknkeiymd = pIfcBknkeiymd;
    }

    @Column(order = 10, label = "備金時効区分")
    private String ifcHnykbknjkukbn;

    public String getIfcHnykbknjkukbn() {
        return ifcHnykbknjkukbn;
    }

    public void setIfcHnykbknjkukbn(String pIfcHnykbknjkukbn) {
        ifcHnykbknjkukbn = pIfcHnykbknjkukbn;
    }

    @Column(order = 11, label = "預り金")
    private String ifcTounendgankin;

    public String getIfcTounendgankin() {
        return ifcTounendgankin;
    }

    public void setIfcTounendgankin(String pIfcTounendgankin) {
        ifcTounendgankin = pIfcTounendgankin;
    }

    @Column(order = 12, label = "利息")
    private String ifcTounendrsk;

    public String getIfcTounendrsk() {
        return ifcTounendrsk;
    }

    public void setIfcTounendrsk(String pIfcTounendrsk) {
        ifcTounendrsk = pIfcTounendrsk;
    }

    @Column(order = 13, label = "元利合計")
    private String ifcAzukariganrikin;

    public String getIfcAzukariganrikin() {
        return ifcAzukariganrikin;
    }

    public void setIfcAzukariganrikin(String pIfcAzukariganrikin) {
        ifcAzukariganrikin = pIfcAzukariganrikin;
    }

    @Column(order = 14, label = "預り日")
    private String ifcAzukarikinhsiymd;

    public String getIfcAzukarikinhsiymd() {
        return ifcAzukarikinhsiymd;
    }

    public void setIfcAzukarikinhsiymd(String pIfcAzukarikinhsiymd) {
        ifcAzukarikinhsiymd = pIfcAzukarikinhsiymd;
    }

    @Column(order = 15, label = "件数")
    private String ifcKensuu;

    public String getIfcKensuu() {
        return ifcKensuu;
    }

    public void setIfcKensuu(String pIfcKensuu) {
        ifcKensuu = pIfcKensuu;
    }

    @Column(order = 16, label = "合計")
    private String ifcGoukeikingk;

    public String getIfcGoukeikingk() {
        return ifcGoukeikingk;
    }

    public void setIfcGoukeikingk(String pIfcGoukeikingk) {
        ifcGoukeikingk = pIfcGoukeikingk;
    }

    @Column(order = 17, label = "外貨当年度元金")
    private String ifcGaikatounendgankin;

    public String getIfcGaikatounendgankin() {
        return ifcGaikatounendgankin;
    }

    public void setIfcGaikatounendgankin(String pIfcGaikatounendgankin) {
        ifcGaikatounendgankin = pIfcGaikatounendgankin;
    }

    @Column(order = 18, label = "外貨当年度利息")
    private String ifcGaikatounendrsk;

    public String getIfcGaikatounendrsk() {
        return ifcGaikatounendrsk;
    }

    public void setIfcGaikatounendrsk(String pIfcGaikatounendrsk) {
        ifcGaikatounendrsk = pIfcGaikatounendrsk;
    }

    @Column(order = 19, label = "外貨預り元利金")
    private String ifcGaikaazukariganrikin;

    public String getIfcGaikaazukariganrikin() {
        return ifcGaikaazukariganrikin;
    }

    public void setIfcGaikaazukariganrikin(String pIfcGaikaazukariganrikin) {
        ifcGaikaazukariganrikin = pIfcGaikaazukariganrikin;
    }

    @Column(order = 20, label = "外貨支払時為替レート基準日")
    private String ifcGaikashrkwsratekjnymd;

    public String getIfcGaikashrkwsratekjnymd() {
        return ifcGaikashrkwsratekjnymd;
    }

    public void setIfcGaikashrkwsratekjnymd(String pIfcGaikashrkwsratekjnymd) {
        ifcGaikashrkwsratekjnymd = pIfcGaikashrkwsratekjnymd;
    }

    @Column(order = 21, label = "外貨支払時為替レート")
    private BizNumber ifcGaikashrkwsrate;

    public BizNumber getIfcGaikashrkwsrate() {
        return ifcGaikashrkwsrate;
    }

    public void setIfcGaikashrkwsrate(BizNumber pIfcGaikashrkwsrate) {
        ifcGaikashrkwsrate = pIfcGaikashrkwsrate;
    }

    @Column(order = 22, label = "外貨換算前当年度元金")
    private String ifcGkknsnmaetounendgankin;

    public String getIfcGkknsnmaetounendgankin() {
        return ifcGkknsnmaetounendgankin;
    }

    public void setIfcGkknsnmaetounendgankin(String pIfcGkknsnmaetounendgankin) {
        ifcGkknsnmaetounendgankin = pIfcGkknsnmaetounendgankin;
    }

    @Column(order = 23, label = "外貨換算前当年度利息")
    private String ifcGkknsnmaetounendrsk;

    public String getIfcGkknsnmaetounendrsk() {
        return ifcGkknsnmaetounendrsk;
    }

    public void setIfcGkknsnmaetounendrsk(String pIfcGkknsnmaetounendrsk) {
        ifcGkknsnmaetounendrsk = pIfcGkknsnmaetounendrsk;
    }

    @Column(order = 24, label = "外貨換算前預り元利金")
    private String ifcGkknsnmaeazukariganrikin;

    public String getIfcGkknsnmaeazukariganrikin() {
        return ifcGkknsnmaeazukariganrikin;
    }

    public void setIfcGkknsnmaeazukariganrikin(String pIfcGkknsnmaeazukariganrikin) {
        ifcGkknsnmaeazukariganrikin = pIfcGkknsnmaeazukariganrikin;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
