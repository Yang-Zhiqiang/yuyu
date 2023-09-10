package yuyu.def.siharai.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_ShrKekkaKbn;

/**
 * （支払）ＩＢＮＲ備金明細Ｆレイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSiIBNRMeisaiFLayoutFile implements Serializable {


    private static final long serialVersionUID = 1L;


    public GenSiIBNRMeisaiFLayoutFile() {
    }


    @Column(order = 1, label = "証券番号")
    private String ifcSyono;


    public String getIfcSyono() {
        return ifcSyono;
    }


    public void setIfcSyono(String pIfcSyono) {
        ifcSyono = pIfcSyono;
    }


    @Column(order = 2, label = "商品コード")
    private String ifcSyouhncd;


    public String getIfcSyouhncd() {
        return ifcSyouhncd;
    }


    public void setIfcSyouhncd(String pIfcSyouhncd) {
        ifcSyouhncd = pIfcSyouhncd;
    }


    @Column(order = 3, label = "保険金種類")
    private String ifcHknknsyruikbn;


    public String getIfcHknknsyruikbn() {
        return ifcHknknsyruikbn;
    }


    public void setIfcHknknsyruikbn(String pIfcHknknsyruikbn) {
        ifcHknknsyruikbn = pIfcHknknsyruikbn;
    }


    @Column(order = 4, label = "支払結果")
    private C_ShrKekkaKbn ifcShrkekkakbn;


    public C_ShrKekkaKbn getIfcShrkekkakbn() {
        return ifcShrkekkakbn;
    }


    public void setIfcShrkekkakbn(C_ShrKekkaKbn pIfcShrkekkakbn) {
        ifcShrkekkakbn = pIfcShrkekkakbn;
    }


    @Column(order = 5, label = "指定通貨")
    private String ifcKyktuukasyu;


    public String getIfcKyktuukasyu() {
        return ifcKyktuukasyu;
    }


    public void setIfcKyktuukasyu(String pIfcKyktuukasyu) {
        ifcKyktuukasyu = pIfcKyktuukasyu;
    }


    @Column(order = 6, label = "指定通貨Ｓ")
    private String ifcShrgk;


    public String getIfcShrgk() {
        return ifcShrgk;
    }


    public void setIfcShrgk(String pIfcShrgk) {
        ifcShrgk = pIfcShrgk;
    }


    @Column(order = 7, label = "円換算Ｓ")
    private String ifcBkngk;


    public String getIfcBkngk() {
        return ifcBkngk;
    }


    public void setIfcBkngk(String pIfcBkngk) {
        ifcBkngk = pIfcBkngk;
    }


    @Column(order = 8, label = "円換算レート")
    private BizNumber ifcShrkwsrate;


    public BizNumber getIfcShrkwsrate() {
        return ifcShrkwsrate;
    }


    public void setIfcShrkwsrate(BizNumber pIfcShrkwsrate) {
        ifcShrkwsrate = pIfcShrkwsrate;
    }


    @Column(order = 9, label = "死亡日")
    private BizDate ifcSibouymd;


    public BizDate getIfcSibouymd() {
        return ifcSibouymd;
    }


    public void setIfcSibouymd(BizDate pIfcSibouymd) {
        ifcSibouymd = pIfcSibouymd;
    }


    @Column(order = 10, label = "死亡仮受付日")
    private BizDate ifcSiboukariymd;


    public BizDate getIfcSiboukariymd() {
        return ifcSiboukariymd;
    }


    public void setIfcSiboukariymd(BizDate pIfcSiboukariymd) {
        ifcSiboukariymd = pIfcSiboukariymd;
    }


    @Column(order = 11, label = "支払処理日")
    private BizDate ifcShrsyoriymd;


    public BizDate getIfcShrsyoriymd() {
        return ifcShrsyoriymd;
    }


    public void setIfcShrsyoriymd(BizDate pIfcShrsyoriymd) {
        ifcShrsyoriymd = pIfcShrsyoriymd;
    }


    @Column(order = 12, label = "着金日")
    private BizDate ifcTyakkinymd;


    public BizDate getIfcTyakkinymd() {
        return ifcTyakkinymd;
    }


    public void setIfcTyakkinymd(BizDate pIfcTyakkinymd) {
        ifcTyakkinymd = pIfcTyakkinymd;
    }


    @Column(order = 13, label = "書類受付日")
    private BizDate ifcSyoruiukeymd;


    public BizDate getIfcSyoruiukeymd() {
        return ifcSyoruiukeymd;
    }


    public void setIfcSyoruiukeymd(BizDate pIfcSyoruiukeymd) {
        ifcSyoruiukeymd = pIfcSyoruiukeymd;
    }


    @Column(order = 14, label = "不備完了日")
    private BizDate ifcHubikanryouymd;


    public BizDate getIfcHubikanryouymd() {
        return ifcHubikanryouymd;
    }


    public void setIfcHubikanryouymd(BizDate pIfcHubikanryouymd) {
        ifcHubikanryouymd = pIfcHubikanryouymd;
    }


    @Column(order = 15, label = "取得元")
    private String ifcBikou1;


    public String getIfcBikou1() {
        return ifcBikou1;
    }


    public void setIfcBikou1(String pIfcBikou1) {
        ifcBikou1 = pIfcBikou1;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
