package yuyu.def.siharai.file.csv;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （支払）区分経理用支払契約明細表レイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSiKbnKeiriKykMeisaiLayoutFile implements Serializable {


    private static final long serialVersionUID = 1L;


    public GenSiKbnKeiriKykMeisaiLayoutFile() {
    }


    @Column(order = 1, label = "証券番号")
    @NotNull
    private String ifcSyono;


    public String getIfcSyono() {
        return ifcSyono;
    }


    public void setIfcSyono(String pIfcSyono) {
        ifcSyono = pIfcSyono;
    }


    @Column(order = 2, label = "責任訂正処理表示")
    private String ifcSknntisisyrhyj;


    public String getIfcSknntisisyrhyj() {
        return ifcSknntisisyrhyj;
    }


    public void setIfcSknntisisyrhyj(String pIfcSknntisisyrhyj) {
        ifcSknntisisyrhyj = pIfcSknntisisyrhyj;
    }


    @Column(order = 3, label = "処理区分")
    private String ifcSyorikbnkbkrinfo;


    public String getIfcSyorikbnkbkrinfo() {
        return ifcSyorikbnkbkrinfo;
    }


    public void setIfcSyorikbnkbkrinfo(String pIfcSyorikbnkbkrinfo) {
        ifcSyorikbnkbkrinfo = pIfcSyorikbnkbkrinfo;
    }


    @Column(order = 4, label = "処理区分名")
    private String ifcSyorikbnnmkbkrinfo;


    public String getIfcSyorikbnnmkbkrinfo() {
        return ifcSyorikbnnmkbkrinfo;
    }


    public void setIfcSyorikbnnmkbkrinfo(String pIfcSyorikbnnmkbkrinfo) {
        ifcSyorikbnnmkbkrinfo = pIfcSyorikbnnmkbkrinfo;
    }


    @Column(order = 5, label = "受付日")
    private BizDate ifcUketukeymd;


    public BizDate getIfcUketukeymd() {
        return ifcUketukeymd;
    }


    public void setIfcUketukeymd(BizDate pIfcUketukeymd) {
        ifcUketukeymd = pIfcUketukeymd;
    }


    @Column(order = 6, label = "伝票日付")
    private BizDate ifcDenpyouymd;


    public BizDate getIfcDenpyouymd() {
        return ifcDenpyouymd;
    }


    public void setIfcDenpyouymd(BizDate pIfcDenpyouymd) {
        ifcDenpyouymd = pIfcDenpyouymd;
    }


    @Column(order = 7, label = "記号")
    private String ifcKigou;


    public String getIfcKigou() {
        return ifcKigou;
    }


    public void setIfcKigou(String pIfcKigou) {
        ifcKigou = pIfcKigou;
    }


    @Column(order = 8, label = "保険金種類区分")
    private String ifcHknknsyruikbn;


    public String getIfcHknknsyruikbn() {
        return ifcHknknsyruikbn;
    }


    public void setIfcHknknsyruikbn(String pIfcHknknsyruikbn) {
        ifcHknknsyruikbn = pIfcHknknsyruikbn;
    }


    @Column(order = 9, label = "支払保険金名")
    private String ifcShrhknknnm;


    public String getIfcShrhknknnm() {
        return ifcShrhknknnm;
    }


    public void setIfcShrhknknnm(String pIfcShrhknknnm) {
        ifcShrhknknnm = pIfcShrhknknnm;
    }


    @Column(order = 10, label = "セグメントレベル区分")
    private String ifcSeglevelkbn;


    public String getIfcSeglevelkbn() {
        return ifcSeglevelkbn;
    }


    public void setIfcSeglevelkbn(String pIfcSeglevelkbn) {
        ifcSeglevelkbn = pIfcSeglevelkbn;
    }


    @Column(order = 11, label = "保険種類レベル区分")
    private String ifcHknsyruilevelkbn;


    public String getIfcHknsyruilevelkbn() {
        return ifcHknsyruilevelkbn;
    }


    public void setIfcHknsyruilevelkbn(String pIfcHknsyruilevelkbn) {
        ifcHknsyruilevelkbn = pIfcHknsyruilevelkbn;
    }


    @Column(order = 12, label = "保険種類名")
    private String ifcHknsyuruimeikbkrinfo;


    public String getIfcHknsyuruimeikbkrinfo() {
        return ifcHknsyuruimeikbkrinfo;
    }


    public void setIfcHknsyuruimeikbkrinfo(String pIfcHknsyuruimeikbkrinfo) {
        ifcHknsyuruimeikbkrinfo = pIfcHknsyuruimeikbkrinfo;
    }


    @Column(order = 13, label = "特約種類記号")
    private String ifcTksyuruikigou;


    public String getIfcTksyuruikigou() {
        return ifcTksyuruikigou;
    }


    public void setIfcTksyuruikigou(String pIfcTksyuruikigou) {
        ifcTksyuruikigou = pIfcTksyuruikigou;
    }


    @Column(order = 14, label = "特約型区分")
    private String ifcTokuyakukbnkbkrinfo;


    public String getIfcTokuyakukbnkbkrinfo() {
        return ifcTokuyakukbnkbkrinfo;
    }


    public void setIfcTokuyakukbnkbkrinfo(String pIfcTokuyakukbnkbkrinfo) {
        ifcTokuyakukbnkbkrinfo = pIfcTokuyakukbnkbkrinfo;
    }


    @Column(order = 15, label = "特約型名")
    private String ifcTokuyakukatanmkbkrinfo;


    public String getIfcTokuyakukatanmkbkrinfo() {
        return ifcTokuyakukatanmkbkrinfo;
    }


    public void setIfcTokuyakukatanmkbkrinfo(String pIfcTokuyakukatanmkbkrinfo) {
        ifcTokuyakukatanmkbkrinfo = pIfcTokuyakukatanmkbkrinfo;
    }


    @Column(order = 16, label = "家族受傷者区分")
    private String ifcKzkjysyusykbn;


    public String getIfcKzkjysyusykbn() {
        return ifcKzkjysyusykbn;
    }


    public void setIfcKzkjysyusykbn(String pIfcKzkjysyusykbn) {
        ifcKzkjysyusykbn = pIfcKzkjysyusykbn;
    }


    @Column(order = 17, label = "家族受傷者名")
    private String ifcKzkjysyusynm;


    public String getIfcKzkjysyusynm() {
        return ifcKzkjysyusynm;
    }


    public void setIfcKzkjysyusynm(String pIfcKzkjysyusynm) {
        ifcKzkjysyusynm = pIfcKzkjysyusynm;
    }


    @Column(order = 18, label = "支払区分")
    private String ifcShrkbnkbkrinfo;


    public String getIfcShrkbnkbkrinfo() {
        return ifcShrkbnkbkrinfo;
    }


    public void setIfcShrkbnkbkrinfo(String pIfcShrkbnkbkrinfo) {
        ifcShrkbnkbkrinfo = pIfcShrkbnkbkrinfo;
    }


    @Column(order = 19, label = "支払区分名")
    private String ifcShrkbnnmkbkrinfo;


    public String getIfcShrkbnnmkbkrinfo() {
        return ifcShrkbnnmkbkrinfo;
    }


    public void setIfcShrkbnnmkbkrinfo(String pIfcShrkbnnmkbkrinfo) {
        ifcShrkbnnmkbkrinfo = pIfcShrkbnnmkbkrinfo;
    }


    @Column(order = 20, label = "計上区分")
    private String ifcKijykbn;


    public String getIfcKijykbn() {
        return ifcKijykbn;
    }


    public void setIfcKijykbn(String pIfcKijykbn) {
        ifcKijykbn = pIfcKijykbn;
    }


    @Column(order = 21, label = "受付事業年度")
    private String ifcUktkjigyounendo;


    public String getIfcUktkjigyounendo() {
        return ifcUktkjigyounendo;
    }


    public void setIfcUktkjigyounendo(String pIfcUktkjigyounendo) {
        ifcUktkjigyounendo = pIfcUktkjigyounendo;
    }


    @Column(order = 22, label = "支払金額")
    private String ifcShrgk;


    public String getIfcShrgk() {
        return ifcShrgk;
    }


    public void setIfcShrgk(String pIfcShrgk) {
        ifcShrgk = pIfcShrgk;
    }


    @Column(order = 23, label = "買増支払Ｓ")
    private String ifcKimsshrs;


    public String getIfcKimsshrs() {
        return ifcKimsshrs;
    }


    public void setIfcKimsshrs(String pIfcKimsshrs) {
        ifcKimsshrs = pIfcKimsshrs;
    }


    @Column(order = 24, label = "Ｓ増支払Ｓ")
    private String ifcSmsshrs;


    public String getIfcSmsshrs() {
        return ifcSmsshrs;
    }


    public void setIfcSmsshrs(String pIfcSmsshrs) {
        ifcSmsshrs = pIfcSmsshrs;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
