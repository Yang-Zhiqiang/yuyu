package yuyu.def.hozen.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保全）預り金リストＣＳＶＦファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhAzukarikinLstCsvfFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhAzukarikinLstCsvfFile() {
    }

    @Column(order = 1, label = "リスト名")
    private String ifcListnm;

    public String getIfcListnm() {
        return ifcListnm;
    }

    public void setIfcListnm(String pIfcListnm) {
        ifcListnm = pIfcListnm;
    }

    @Column(order = 2, label = "作成年月日")
    private String ifcSakuseiymdseireki;

    public String getIfcSakuseiymdseireki() {
        return ifcSakuseiymdseireki;
    }

    public void setIfcSakuseiymdseireki(String pIfcSakuseiymdseireki) {
        ifcSakuseiymdseireki = pIfcSakuseiymdseireki;
    }

    @Column(order = 3, label = "決算年度")
    private String ifcKessannnd;

    public String getIfcKessannnd() {
        return ifcKessannnd;
    }

    public void setIfcKessannnd(String pIfcKessannnd) {
        ifcKessannnd = pIfcKessannnd;
    }

    @Column(order = 4, label = "保険種類レベル")
    private String ifcHknsyuruilevel;

    public String getIfcHknsyuruilevel() {
        return ifcHknsyuruilevel;
    }

    public void setIfcHknsyuruilevel(String pIfcHknsyuruilevel) {
        ifcHknsyuruilevel = pIfcHknsyuruilevel;
    }

    @Column(order = 5, label = "セグメントコード")
    private String ifcSegcd;

    public String getIfcSegcd() {
        return ifcSegcd;
    }

    public void setIfcSegcd(String pIfcSegcd) {
        ifcSegcd = pIfcSegcd;
    }

    @Column(order = 6, label = "証券番号")
    private String ifcSyono;

    public String getIfcSyono() {
        return ifcSyono;
    }

    public void setIfcSyono(String pIfcSyono) {
        ifcSyono = pIfcSyono;
    }

    @Column(order = 7, label = "通貨種類")
    private String ifcTuukasyu;

    public String getIfcTuukasyu() {
        return ifcTuukasyu;
    }

    public void setIfcTuukasyu(String pIfcTuukasyu) {
        ifcTuukasyu = pIfcTuukasyu;
    }

    @Column(order = 8, label = "備金時効区分")
    private String ifcHnykbknjkukbn;

    public String getIfcHnykbknjkukbn() {
        return ifcHnykbknjkukbn;
    }

    public void setIfcHnykbknjkukbn(String pIfcHnykbknjkukbn) {
        ifcHnykbknjkukbn = pIfcHnykbknjkukbn;
    }

    @Column(order = 9, label = "消滅日")
    private String ifcSyoumetuymd;

    public String getIfcSyoumetuymd() {
        return ifcSyoumetuymd;
    }

    public void setIfcSyoumetuymd(String pIfcSyoumetuymd) {
        ifcSyoumetuymd = pIfcSyoumetuymd;
    }

    @Column(order = 10, label = "計算基準日")
    private String ifcCalckijyunymd;

    public String getIfcCalckijyunymd() {
        return ifcCalckijyunymd;
    }

    public void setIfcCalckijyunymd(String pIfcCalckijyunymd) {
        ifcCalckijyunymd = pIfcCalckijyunymd;
    }

    @Column(order = 11, label = "預り金発生日")
    private String ifcAzukarikinhsiymd;

    public String getIfcAzukarikinhsiymd() {
        return ifcAzukarikinhsiymd;
    }

    public void setIfcAzukarikinhsiymd(String pIfcAzukarikinhsiymd) {
        ifcAzukarikinhsiymd = pIfcAzukarikinhsiymd;
    }

    @Column(order = 12, label = "預り元利金")
    private String ifcAzukariganrikin;

    public String getIfcAzukariganrikin() {
        return ifcAzukariganrikin;
    }

    public void setIfcAzukariganrikin(String pIfcAzukariganrikin) {
        ifcAzukariganrikin = pIfcAzukariganrikin;
    }

    @Column(order = 13, label = "当年度元金")
    private String ifcTounendgankin;

    public String getIfcTounendgankin() {
        return ifcTounendgankin;
    }

    public void setIfcTounendgankin(String pIfcTounendgankin) {
        ifcTounendgankin = pIfcTounendgankin;
    }

    @Column(order = 14, label = "当年度利息")
    private String ifcTounendrsk;

    public String getIfcTounendrsk() {
        return ifcTounendrsk;
    }

    public void setIfcTounendrsk(String pIfcTounendrsk) {
        ifcTounendrsk = pIfcTounendrsk;
    }

    @Column(order = 15, label = "為替レート基準日")
    private String ifcKwsratekjymd;

    public String getIfcKwsratekjymd() {
        return ifcKwsratekjymd;
    }

    public void setIfcKwsratekjymd(String pIfcKwsratekjymd) {
        ifcKwsratekjymd = pIfcKwsratekjymd;
    }

    @Column(order = 16, label = "為替レート")
    private String ifcKawaserate;

    public String getIfcKawaserate() {
        return ifcKawaserate;
    }

    public void setIfcKawaserate(String pIfcKawaserate) {
        ifcKawaserate = pIfcKawaserate;
    }

    @Column(order = 17, label = "外貨預り元利金")
    private String ifcGaikaazukariganrikin;

    public String getIfcGaikaazukariganrikin() {
        return ifcGaikaazukariganrikin;
    }

    public void setIfcGaikaazukariganrikin(String pIfcGaikaazukariganrikin) {
        ifcGaikaazukariganrikin = pIfcGaikaazukariganrikin;
    }

    @Column(order = 18, label = "外貨当年度元金")
    private String ifcGaikatounendgankin;

    public String getIfcGaikatounendgankin() {
        return ifcGaikatounendgankin;
    }

    public void setIfcGaikatounendgankin(String pIfcGaikatounendgankin) {
        ifcGaikatounendgankin = pIfcGaikatounendgankin;
    }

    @Column(order = 19, label = "外貨当年度利息")
    private String ifcGaikatounendrsk;

    public String getIfcGaikatounendrsk() {
        return ifcGaikatounendrsk;
    }

    public void setIfcGaikatounendrsk(String pIfcGaikatounendrsk) {
        ifcGaikatounendrsk = pIfcGaikatounendrsk;
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

    @Column(order = 22, label = "外貨換算前預り元利金")
    private String ifcGkknsnmaeazukariganrikin;

    public String getIfcGkknsnmaeazukariganrikin() {
        return ifcGkknsnmaeazukariganrikin;
    }

    public void setIfcGkknsnmaeazukariganrikin(String pIfcGkknsnmaeazukariganrikin) {
        ifcGkknsnmaeazukariganrikin = pIfcGkknsnmaeazukariganrikin;
    }

    @Column(order = 23, label = "外貨換算前当年度元金")
    private String ifcGkknsnmaetounendgankin;

    public String getIfcGkknsnmaetounendgankin() {
        return ifcGkknsnmaetounendgankin;
    }

    public void setIfcGkknsnmaetounendgankin(String pIfcGkknsnmaetounendgankin) {
        ifcGkknsnmaetounendgankin = pIfcGkknsnmaetounendgankin;
    }

    @Column(order = 24, label = "外貨換算前当年度利息")
    private String ifcGkknsnmaetounendrsk;

    public String getIfcGkknsnmaetounendrsk() {
        return ifcGkknsnmaetounendrsk;
    }

    public void setIfcGkknsnmaetounendrsk(String pIfcGkknsnmaetounendrsk) {
        ifcGkknsnmaetounendrsk = pIfcGkknsnmaetounendrsk;
    }

    @Column(order = 25, label = "当年度利息（主計室用）")
    private String ifcTounendrsksyukeisitu;

    public String getIfcTounendrsksyukeisitu() {
        return ifcTounendrsksyukeisitu;
    }

    public void setIfcTounendrsksyukeisitu(String pIfcTounendrsksyukeisitu) {
        ifcTounendrsksyukeisitu = pIfcTounendrsksyukeisitu;
    }

    @Column(order = 26, label = "前年度利息（主計室用）")
    private String ifcZennendrsksyukeisitu;

    public String getIfcZennendrsksyukeisitu() {
        return ifcZennendrsksyukeisitu;
    }

    public void setIfcZennendrsksyukeisitu(String pIfcZennendrsksyukeisitu) {
        ifcZennendrsksyukeisitu = pIfcZennendrsksyukeisitu;
    }

    @Column(order = 27, label = "（１Ｑ）為替レート基準日")
    private String ifcKwsratekjymd1q;

    public String getIfcKwsratekjymd1q() {
        return ifcKwsratekjymd1q;
    }

    public void setIfcKwsratekjymd1q(String pIfcKwsratekjymd1q) {
        ifcKwsratekjymd1q = pIfcKwsratekjymd1q;
    }

    @Column(order = 28, label = "（１Ｑ）為替レート")
    private String ifcKawaserate1q;

    public String getIfcKawaserate1q() {
        return ifcKawaserate1q;
    }

    public void setIfcKawaserate1q(String pIfcKawaserate1q) {
        ifcKawaserate1q = pIfcKawaserate1q;
    }

    @Column(order = 29, label = "（１Ｑ）預り金利息")
    private String ifcAzukarikinrsk1q;

    public String getIfcAzukarikinrsk1q() {
        return ifcAzukarikinrsk1q;
    }

    public void setIfcAzukarikinrsk1q(String pIfcAzukarikinrsk1q) {
        ifcAzukarikinrsk1q = pIfcAzukarikinrsk1q;
    }

    @Column(order = 30, label = "（２Ｑ）為替レート基準日")
    private String ifcKwsratekjymd2q;

    public String getIfcKwsratekjymd2q() {
        return ifcKwsratekjymd2q;
    }

    public void setIfcKwsratekjymd2q(String pIfcKwsratekjymd2q) {
        ifcKwsratekjymd2q = pIfcKwsratekjymd2q;
    }

    @Column(order = 31, label = "（２Ｑ）為替レート")
    private String ifcKawaserate2q;

    public String getIfcKawaserate2q() {
        return ifcKawaserate2q;
    }

    public void setIfcKawaserate2q(String pIfcKawaserate2q) {
        ifcKawaserate2q = pIfcKawaserate2q;
    }

    @Column(order = 32, label = "（２Ｑ）預り金利息")
    private String ifcAzukarikinrsk2q;

    public String getIfcAzukarikinrsk2q() {
        return ifcAzukarikinrsk2q;
    }

    public void setIfcAzukarikinrsk2q(String pIfcAzukarikinrsk2q) {
        ifcAzukarikinrsk2q = pIfcAzukarikinrsk2q;
    }

    @Column(order = 33, label = "（３Ｑ）為替レート基準日")
    private String ifcKwsratekjymd3q;

    public String getIfcKwsratekjymd3q() {
        return ifcKwsratekjymd3q;
    }

    public void setIfcKwsratekjymd3q(String pIfcKwsratekjymd3q) {
        ifcKwsratekjymd3q = pIfcKwsratekjymd3q;
    }

    @Column(order = 34, label = "（３Ｑ）為替レート")
    private String ifcKawaserate3q;

    public String getIfcKawaserate3q() {
        return ifcKawaserate3q;
    }

    public void setIfcKawaserate3q(String pIfcKawaserate3q) {
        ifcKawaserate3q = pIfcKawaserate3q;
    }

    @Column(order = 35, label = "（３Ｑ）預り金利息")
    private String ifcAzukarikinrsk3q;

    public String getIfcAzukarikinrsk3q() {
        return ifcAzukarikinrsk3q;
    }

    public void setIfcAzukarikinrsk3q(String pIfcAzukarikinrsk3q) {
        ifcAzukarikinrsk3q = pIfcAzukarikinrsk3q;
    }

    @Column(order = 36, label = "（４Ｑ）為替レート基準日")
    private String ifcKwsratekjymd4q;

    public String getIfcKwsratekjymd4q() {
        return ifcKwsratekjymd4q;
    }

    public void setIfcKwsratekjymd4q(String pIfcKwsratekjymd4q) {
        ifcKwsratekjymd4q = pIfcKwsratekjymd4q;
    }

    @Column(order = 37, label = "（４Ｑ）為替レート")
    private String ifcKawaserate4q;

    public String getIfcKawaserate4q() {
        return ifcKawaserate4q;
    }

    public void setIfcKawaserate4q(String pIfcKawaserate4q) {
        ifcKawaserate4q = pIfcKawaserate4q;
    }

    @Column(order = 38, label = "（４Ｑ）預り金利息")
    private String ifcAzukarikinrsk4q;

    public String getIfcAzukarikinrsk4q() {
        return ifcAzukarikinrsk4q;
    }

    public void setIfcAzukarikinrsk4q(String pIfcAzukarikinrsk4q) {
        ifcAzukarikinrsk4q = pIfcAzukarikinrsk4q;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
