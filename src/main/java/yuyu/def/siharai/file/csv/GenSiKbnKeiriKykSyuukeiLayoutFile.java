package yuyu.def.siharai.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （支払）区分経理用支払契約集計表レイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSiKbnKeiriKykSyuukeiLayoutFile implements Serializable {


    private static final long serialVersionUID = 1L;


    public GenSiKbnKeiriKykSyuukeiLayoutFile() {
    }


    @Column(order = 1, label = "責任訂正処理表示")
    private String ifcSknntisisyrhyj;


    public String getIfcSknntisisyrhyj() {
        return ifcSknntisisyrhyj;
    }


    public void setIfcSknntisisyrhyj(String pIfcSknntisisyrhyj) {
        ifcSknntisisyrhyj = pIfcSknntisisyrhyj;
    }


    @Column(order = 2, label = "処理区分")
    private String ifcSyorikbnkbkrinfo;


    public String getIfcSyorikbnkbkrinfo() {
        return ifcSyorikbnkbkrinfo;
    }


    public void setIfcSyorikbnkbkrinfo(String pIfcSyorikbnkbkrinfo) {
        ifcSyorikbnkbkrinfo = pIfcSyorikbnkbkrinfo;
    }


    @Column(order = 3, label = "処理区分名")
    private String ifcSyorikbnnmkbkrinfo;


    public String getIfcSyorikbnnmkbkrinfo() {
        return ifcSyorikbnnmkbkrinfo;
    }


    public void setIfcSyorikbnnmkbkrinfo(String pIfcSyorikbnnmkbkrinfo) {
        ifcSyorikbnnmkbkrinfo = pIfcSyorikbnnmkbkrinfo;
    }


    @Column(order = 4, label = "受付年月")
    private String ifcUktkym;


    public String getIfcUktkym() {
        return ifcUktkym;
    }


    public void setIfcUktkym(String pIfcUktkym) {
        ifcUktkym = pIfcUktkym;
    }


    @Column(order = 5, label = "保険金種類区分")
    private String ifcHknknsyruikbn;


    public String getIfcHknknsyruikbn() {
        return ifcHknknsyruikbn;
    }


    public void setIfcHknknsyruikbn(String pIfcHknknsyruikbn) {
        ifcHknknsyruikbn = pIfcHknknsyruikbn;
    }


    @Column(order = 6, label = "支払保険金名")
    private String ifcShrhknknnm;


    public String getIfcShrhknknnm() {
        return ifcShrhknknnm;
    }


    public void setIfcShrhknknnm(String pIfcShrhknknnm) {
        ifcShrhknknnm = pIfcShrhknknnm;
    }


    @Column(order = 7, label = "セグメントレベル区分")
    private String ifcSeglevelkbn;


    public String getIfcSeglevelkbn() {
        return ifcSeglevelkbn;
    }


    public void setIfcSeglevelkbn(String pIfcSeglevelkbn) {
        ifcSeglevelkbn = pIfcSeglevelkbn;
    }


    @Column(order = 8, label = "保険種類レベル区分")
    private String ifcHknsyruilevelkbn;


    public String getIfcHknsyruilevelkbn() {
        return ifcHknsyruilevelkbn;
    }


    public void setIfcHknsyruilevelkbn(String pIfcHknsyruilevelkbn) {
        ifcHknsyruilevelkbn = pIfcHknsyruilevelkbn;
    }


    @Column(order = 9, label = "保険種類名")
    private String ifcHknsyuruimeikbkrinfo;


    public String getIfcHknsyuruimeikbkrinfo() {
        return ifcHknsyuruimeikbkrinfo;
    }


    public void setIfcHknsyuruimeikbkrinfo(String pIfcHknsyuruimeikbkrinfo) {
        ifcHknsyuruimeikbkrinfo = pIfcHknsyuruimeikbkrinfo;
    }


    @Column(order = 10, label = "特約種類記号")
    private String ifcTksyuruikigou;


    public String getIfcTksyuruikigou() {
        return ifcTksyuruikigou;
    }


    public void setIfcTksyuruikigou(String pIfcTksyuruikigou) {
        ifcTksyuruikigou = pIfcTksyuruikigou;
    }


    @Column(order = 11, label = "特約型区分")
    private String ifcTokuyakukbnkbkrinfo;


    public String getIfcTokuyakukbnkbkrinfo() {
        return ifcTokuyakukbnkbkrinfo;
    }


    public void setIfcTokuyakukbnkbkrinfo(String pIfcTokuyakukbnkbkrinfo) {
        ifcTokuyakukbnkbkrinfo = pIfcTokuyakukbnkbkrinfo;
    }


    @Column(order = 12, label = "特約型名")
    private String ifcTokuyakukatanmkbkrinfo;


    public String getIfcTokuyakukatanmkbkrinfo() {
        return ifcTokuyakukatanmkbkrinfo;
    }


    public void setIfcTokuyakukatanmkbkrinfo(String pIfcTokuyakukatanmkbkrinfo) {
        ifcTokuyakukatanmkbkrinfo = pIfcTokuyakukatanmkbkrinfo;
    }


    @Column(order = 13, label = "家族受傷者区分")
    private String ifcKzkjysyusykbn;


    public String getIfcKzkjysyusykbn() {
        return ifcKzkjysyusykbn;
    }


    public void setIfcKzkjysyusykbn(String pIfcKzkjysyusykbn) {
        ifcKzkjysyusykbn = pIfcKzkjysyusykbn;
    }


    @Column(order = 14, label = "家族受傷者名")
    private String ifcKzkjysyusynm;


    public String getIfcKzkjysyusynm() {
        return ifcKzkjysyusynm;
    }


    public void setIfcKzkjysyusynm(String pIfcKzkjysyusynm) {
        ifcKzkjysyusynm = pIfcKzkjysyusynm;
    }


    @Column(order = 15, label = "支払区分")
    private String ifcShrkbnkbkrinfo;


    public String getIfcShrkbnkbkrinfo() {
        return ifcShrkbnkbkrinfo;
    }


    public void setIfcShrkbnkbkrinfo(String pIfcShrkbnkbkrinfo) {
        ifcShrkbnkbkrinfo = pIfcShrkbnkbkrinfo;
    }


    @Column(order = 16, label = "支払区分名")
    private String ifcShrkbnnmkbkrinfo;


    public String getIfcShrkbnnmkbkrinfo() {
        return ifcShrkbnnmkbkrinfo;
    }


    public void setIfcShrkbnnmkbkrinfo(String pIfcShrkbnnmkbkrinfo) {
        ifcShrkbnnmkbkrinfo = pIfcShrkbnnmkbkrinfo;
    }


    @Column(order = 17, label = "計上区分")
    private String ifcKijykbn;


    public String getIfcKijykbn() {
        return ifcKijykbn;
    }


    public void setIfcKijykbn(String pIfcKijykbn) {
        ifcKijykbn = pIfcKijykbn;
    }


    @Column(order = 18, label = "受付事業年度")
    private String ifcUktkjigyounendo;


    public String getIfcUktkjigyounendo() {
        return ifcUktkjigyounendo;
    }


    public void setIfcUktkjigyounendo(String pIfcUktkjigyounendo) {
        ifcUktkjigyounendo = pIfcUktkjigyounendo;
    }


    @Column(order = 19, label = "支払件数")
    private String ifcShrkensuu;


    public String getIfcShrkensuu() {
        return ifcShrkensuu;
    }


    public void setIfcShrkensuu(String pIfcShrkensuu) {
        ifcShrkensuu = pIfcShrkensuu;
    }


    @Column(order = 20, label = "支払金額")
    private String ifcShrgk;


    public String getIfcShrgk() {
        return ifcShrgk;
    }


    public void setIfcShrgk(String pIfcShrgk) {
        ifcShrgk = pIfcShrgk;
    }


    @Column(order = 21, label = "買増件数")
    private String ifcKimskensuu;


    public String getIfcKimskensuu() {
        return ifcKimskensuu;
    }


    public void setIfcKimskensuu(String pIfcKimskensuu) {
        ifcKimskensuu = pIfcKimskensuu;
    }


    @Column(order = 22, label = "買増支払Ｓ")
    private String ifcKimsshrs;


    public String getIfcKimsshrs() {
        return ifcKimsshrs;
    }


    public void setIfcKimsshrs(String pIfcKimsshrs) {
        ifcKimsshrs = pIfcKimsshrs;
    }


    @Column(order = 23, label = "Ｓ増件数")
    private String ifcSmskensuu;


    public String getIfcSmskensuu() {
        return ifcSmskensuu;
    }


    public void setIfcSmskensuu(String pIfcSmskensuu) {
        ifcSmskensuu = pIfcSmskensuu;
    }


    @Column(order = 24, label = "Ｓ増支払Ｓ")
    private String ifcSmsshrs;


    public String getIfcSmsshrs() {
        return ifcSmsshrs;
    }


    public void setIfcSmsshrs(String pIfcSmsshrs) {
        ifcSmsshrs = pIfcSmsshrs;
    }


    @Column(order = 25, label = "買増Ｓ増確認要表示")
    private String ifcKimssmskknnyuhyj;


    public String getIfcKimssmskknnyuhyj() {
        return ifcKimssmskknnyuhyj;
    }


    public void setIfcKimssmskknnyuhyj(String pIfcKimssmskknnyuhyj) {
        ifcKimssmskknnyuhyj = pIfcKimssmskknnyuhyj;
    }


    @Column(order = 26, label = "受付事業年度計支払件数")
    private String ifcUktkjgnedshrkensuu;


    public String getIfcUktkjgnedshrkensuu() {
        return ifcUktkjgnedshrkensuu;
    }


    public void setIfcUktkjgnedshrkensuu(String pIfcUktkjgnedshrkensuu) {
        ifcUktkjgnedshrkensuu = pIfcUktkjgnedshrkensuu;
    }


    @Column(order = 27, label = "受付事業年度計支払金額")
    private String ifcUktkjgnedshrgk;


    public String getIfcUktkjgnedshrgk() {
        return ifcUktkjgnedshrgk;
    }


    public void setIfcUktkjgnedshrgk(String pIfcUktkjgnedshrgk) {
        ifcUktkjgnedshrgk = pIfcUktkjgnedshrgk;
    }


    @Column(order = 28, label = "受付事業年度計買増件数")
    private String ifcUktkjgnedkimskensuu;


    public String getIfcUktkjgnedkimskensuu() {
        return ifcUktkjgnedkimskensuu;
    }


    public void setIfcUktkjgnedkimskensuu(String pIfcUktkjgnedkimskensuu) {
        ifcUktkjgnedkimskensuu = pIfcUktkjgnedkimskensuu;
    }


    @Column(order = 29, label = "受付事業年度計買増支払Ｓ")
    private String ifcUktkjgnedkimsshrs;


    public String getIfcUktkjgnedkimsshrs() {
        return ifcUktkjgnedkimsshrs;
    }


    public void setIfcUktkjgnedkimsshrs(String pIfcUktkjgnedkimsshrs) {
        ifcUktkjgnedkimsshrs = pIfcUktkjgnedkimsshrs;
    }


    @Column(order = 30, label = "受付事業年度計Ｓ増件数")
    private String ifcUktkjgnedsmskensuu;


    public String getIfcUktkjgnedsmskensuu() {
        return ifcUktkjgnedsmskensuu;
    }


    public void setIfcUktkjgnedsmskensuu(String pIfcUktkjgnedsmskensuu) {
        ifcUktkjgnedsmskensuu = pIfcUktkjgnedsmskensuu;
    }


    @Column(order = 31, label = "受付事業年度計Ｓ増支払Ｓ")
    private String ifcUktkjgnedsmsshrs;


    public String getIfcUktkjgnedsmsshrs() {
        return ifcUktkjgnedsmsshrs;
    }


    public void setIfcUktkjgnedsmsshrs(String pIfcUktkjgnedsmsshrs) {
        ifcUktkjgnedsmsshrs = pIfcUktkjgnedsmsshrs;
    }


    @Column(order = 32, label = "支払区分計支払件数")
    private String ifcShrkbnshrkensuu;


    public String getIfcShrkbnshrkensuu() {
        return ifcShrkbnshrkensuu;
    }


    public void setIfcShrkbnshrkensuu(String pIfcShrkbnshrkensuu) {
        ifcShrkbnshrkensuu = pIfcShrkbnshrkensuu;
    }


    @Column(order = 33, label = "支払区分計支払金額")
    private String ifcShrkbnshrgk;


    public String getIfcShrkbnshrgk() {
        return ifcShrkbnshrgk;
    }


    public void setIfcShrkbnshrgk(String pIfcShrkbnshrgk) {
        ifcShrkbnshrgk = pIfcShrkbnshrgk;
    }


    @Column(order = 34, label = "支払区分計買増件数")
    private String ifcShrkbnkimskensuu;


    public String getIfcShrkbnkimskensuu() {
        return ifcShrkbnkimskensuu;
    }


    public void setIfcShrkbnkimskensuu(String pIfcShrkbnkimskensuu) {
        ifcShrkbnkimskensuu = pIfcShrkbnkimskensuu;
    }


    @Column(order = 35, label = "支払区分計買増支払Ｓ")
    private String ifcShrkbnkimsshrs;


    public String getIfcShrkbnkimsshrs() {
        return ifcShrkbnkimsshrs;
    }


    public void setIfcShrkbnkimsshrs(String pIfcShrkbnkimsshrs) {
        ifcShrkbnkimsshrs = pIfcShrkbnkimsshrs;
    }


    @Column(order = 36, label = "支払区分計Ｓ増件数")
    private String ifcShrkbnsmskensuu;


    public String getIfcShrkbnsmskensuu() {
        return ifcShrkbnsmskensuu;
    }


    public void setIfcShrkbnsmskensuu(String pIfcShrkbnsmskensuu) {
        ifcShrkbnsmskensuu = pIfcShrkbnsmskensuu;
    }


    @Column(order = 37, label = "支払区分計Ｓ増支払Ｓ")
    private String ifcShrkbnsmsshrs;


    public String getIfcShrkbnsmsshrs() {
        return ifcShrkbnsmsshrs;
    }


    public void setIfcShrkbnsmsshrs(String pIfcShrkbnsmsshrs) {
        ifcShrkbnsmsshrs = pIfcShrkbnsmsshrs;
    }


    @Column(order = 38, label = "家族計支払件数")
    private String ifcKzkshrkensuu;


    public String getIfcKzkshrkensuu() {
        return ifcKzkshrkensuu;
    }


    public void setIfcKzkshrkensuu(String pIfcKzkshrkensuu) {
        ifcKzkshrkensuu = pIfcKzkshrkensuu;
    }


    @Column(order = 39, label = "家族計支払金額")
    private String ifcKzkshrgk;


    public String getIfcKzkshrgk() {
        return ifcKzkshrgk;
    }


    public void setIfcKzkshrgk(String pIfcKzkshrgk) {
        ifcKzkshrgk = pIfcKzkshrgk;
    }


    @Column(order = 40, label = "家族計買増件数")
    private String ifcKzkkimskensuu;


    public String getIfcKzkkimskensuu() {
        return ifcKzkkimskensuu;
    }


    public void setIfcKzkkimskensuu(String pIfcKzkkimskensuu) {
        ifcKzkkimskensuu = pIfcKzkkimskensuu;
    }


    @Column(order = 41, label = "家族計買増支払Ｓ")
    private String ifcKzkkimsshrs;


    public String getIfcKzkkimsshrs() {
        return ifcKzkkimsshrs;
    }


    public void setIfcKzkkimsshrs(String pIfcKzkkimsshrs) {
        ifcKzkkimsshrs = pIfcKzkkimsshrs;
    }


    @Column(order = 42, label = "家族計Ｓ増件数")
    private String ifcKzksmskensuu;


    public String getIfcKzksmskensuu() {
        return ifcKzksmskensuu;
    }


    public void setIfcKzksmskensuu(String pIfcKzksmskensuu) {
        ifcKzksmskensuu = pIfcKzksmskensuu;
    }


    @Column(order = 43, label = "家族計Ｓ増支払Ｓ")
    private String ifcKzksmsshrs;


    public String getIfcKzksmsshrs() {
        return ifcKzksmsshrs;
    }


    public void setIfcKzksmsshrs(String pIfcKzksmsshrs) {
        ifcKzksmsshrs = pIfcKzksmsshrs;
    }


    @Column(order = 44, label = "特約型計支払件数")
    private String ifcTkkatashrkensuu;


    public String getIfcTkkatashrkensuu() {
        return ifcTkkatashrkensuu;
    }


    public void setIfcTkkatashrkensuu(String pIfcTkkatashrkensuu) {
        ifcTkkatashrkensuu = pIfcTkkatashrkensuu;
    }


    @Column(order = 45, label = "特約型計支払金額")
    private String ifcTkkatashrgk;


    public String getIfcTkkatashrgk() {
        return ifcTkkatashrgk;
    }


    public void setIfcTkkatashrgk(String pIfcTkkatashrgk) {
        ifcTkkatashrgk = pIfcTkkatashrgk;
    }


    @Column(order = 46, label = "特約型計買増件数")
    private String ifcTkkatakimskensuu;


    public String getIfcTkkatakimskensuu() {
        return ifcTkkatakimskensuu;
    }


    public void setIfcTkkatakimskensuu(String pIfcTkkatakimskensuu) {
        ifcTkkatakimskensuu = pIfcTkkatakimskensuu;
    }


    @Column(order = 47, label = "特約型計買増支払Ｓ")
    private String ifcTkkatakimsshrs;


    public String getIfcTkkatakimsshrs() {
        return ifcTkkatakimsshrs;
    }


    public void setIfcTkkatakimsshrs(String pIfcTkkatakimsshrs) {
        ifcTkkatakimsshrs = pIfcTkkatakimsshrs;
    }


    @Column(order = 48, label = "特約型計Ｓ増件数")
    private String ifcTkkatasmskensuu;


    public String getIfcTkkatasmskensuu() {
        return ifcTkkatasmskensuu;
    }


    public void setIfcTkkatasmskensuu(String pIfcTkkatasmskensuu) {
        ifcTkkatasmskensuu = pIfcTkkatasmskensuu;
    }


    @Column(order = 49, label = "特約型計Ｓ増支払Ｓ")
    private String ifcTkkatasmsshrs;


    public String getIfcTkkatasmsshrs() {
        return ifcTkkatasmsshrs;
    }


    public void setIfcTkkatasmsshrs(String pIfcTkkatasmsshrs) {
        ifcTkkatasmsshrs = pIfcTkkatasmsshrs;
    }


    @Column(order = 50, label = "特約種類計支払件数")
    private String ifcTksyuruishrkensuu;


    public String getIfcTksyuruishrkensuu() {
        return ifcTksyuruishrkensuu;
    }


    public void setIfcTksyuruishrkensuu(String pIfcTksyuruishrkensuu) {
        ifcTksyuruishrkensuu = pIfcTksyuruishrkensuu;
    }


    @Column(order = 51, label = "特約種類計支払金額")
    private String ifcTksyuruishrgk;


    public String getIfcTksyuruishrgk() {
        return ifcTksyuruishrgk;
    }


    public void setIfcTksyuruishrgk(String pIfcTksyuruishrgk) {
        ifcTksyuruishrgk = pIfcTksyuruishrgk;
    }


    @Column(order = 52, label = "特約種類計買増件数")
    private String ifcTksyuruikimskensuu;


    public String getIfcTksyuruikimskensuu() {
        return ifcTksyuruikimskensuu;
    }


    public void setIfcTksyuruikimskensuu(String pIfcTksyuruikimskensuu) {
        ifcTksyuruikimskensuu = pIfcTksyuruikimskensuu;
    }


    @Column(order = 53, label = "特約種類計買増支払Ｓ")
    private String ifcTksyuruikimsshrs;


    public String getIfcTksyuruikimsshrs() {
        return ifcTksyuruikimsshrs;
    }


    public void setIfcTksyuruikimsshrs(String pIfcTksyuruikimsshrs) {
        ifcTksyuruikimsshrs = pIfcTksyuruikimsshrs;
    }


    @Column(order = 54, label = "特約種類計Ｓ増件数")
    private String ifcTksyuruismskensuu;


    public String getIfcTksyuruismskensuu() {
        return ifcTksyuruismskensuu;
    }


    public void setIfcTksyuruismskensuu(String pIfcTksyuruismskensuu) {
        ifcTksyuruismskensuu = pIfcTksyuruismskensuu;
    }


    @Column(order = 55, label = "特約種類計Ｓ増支払Ｓ")
    private String ifcTksyuruismsshrs;


    public String getIfcTksyuruismsshrs() {
        return ifcTksyuruismsshrs;
    }


    public void setIfcTksyuruismsshrs(String pIfcTksyuruismsshrs) {
        ifcTksyuruismsshrs = pIfcTksyuruismsshrs;
    }


    @Column(order = 56, label = "保険種類計支払件数")
    private String ifcHknsyuruishrkensuu;


    public String getIfcHknsyuruishrkensuu() {
        return ifcHknsyuruishrkensuu;
    }


    public void setIfcHknsyuruishrkensuu(String pIfcHknsyuruishrkensuu) {
        ifcHknsyuruishrkensuu = pIfcHknsyuruishrkensuu;
    }


    @Column(order = 57, label = "保険種類計支払金額")
    private String ifcHknsyuruishrgk;


    public String getIfcHknsyuruishrgk() {
        return ifcHknsyuruishrgk;
    }


    public void setIfcHknsyuruishrgk(String pIfcHknsyuruishrgk) {
        ifcHknsyuruishrgk = pIfcHknsyuruishrgk;
    }


    @Column(order = 58, label = "保険種類計買増件数")
    private String ifcHknsyuruikimskensuu;


    public String getIfcHknsyuruikimskensuu() {
        return ifcHknsyuruikimskensuu;
    }


    public void setIfcHknsyuruikimskensuu(String pIfcHknsyuruikimskensuu) {
        ifcHknsyuruikimskensuu = pIfcHknsyuruikimskensuu;
    }


    @Column(order = 59, label = "保険種類計買増支払Ｓ")
    private String ifcHknsyuruikimsshrs;


    public String getIfcHknsyuruikimsshrs() {
        return ifcHknsyuruikimsshrs;
    }


    public void setIfcHknsyuruikimsshrs(String pIfcHknsyuruikimsshrs) {
        ifcHknsyuruikimsshrs = pIfcHknsyuruikimsshrs;
    }


    @Column(order = 60, label = "保険種類計Ｓ増件数")
    private String ifcHknsyuruismskensuu;


    public String getIfcHknsyuruismskensuu() {
        return ifcHknsyuruismskensuu;
    }


    public void setIfcHknsyuruismskensuu(String pIfcHknsyuruismskensuu) {
        ifcHknsyuruismskensuu = pIfcHknsyuruismskensuu;
    }


    @Column(order = 61, label = "保険種類計Ｓ増支払Ｓ")
    private String ifcHknsyuruismsshrs;


    public String getIfcHknsyuruismsshrs() {
        return ifcHknsyuruismsshrs;
    }


    public void setIfcHknsyuruismsshrs(String pIfcHknsyuruismsshrs) {
        ifcHknsyuruismsshrs = pIfcHknsyuruismsshrs;
    }


    @Column(order = 62, label = "支払保険金計支払件数")
    private String ifcShrgkshrkensuu;


    public String getIfcShrgkshrkensuu() {
        return ifcShrgkshrkensuu;
    }


    public void setIfcShrgkshrkensuu(String pIfcShrgkshrkensuu) {
        ifcShrgkshrkensuu = pIfcShrgkshrkensuu;
    }


    @Column(order = 63, label = "支払保険金計支払金額")
    private String ifcShrgkshrgk;


    public String getIfcShrgkshrgk() {
        return ifcShrgkshrgk;
    }


    public void setIfcShrgkshrgk(String pIfcShrgkshrgk) {
        ifcShrgkshrgk = pIfcShrgkshrgk;
    }


    @Column(order = 64, label = "支払保険金計買増件数")
    private String ifcShrgkkimskensuu;


    public String getIfcShrgkkimskensuu() {
        return ifcShrgkkimskensuu;
    }


    public void setIfcShrgkkimskensuu(String pIfcShrgkkimskensuu) {
        ifcShrgkkimskensuu = pIfcShrgkkimskensuu;
    }


    @Column(order = 65, label = "支払保険金計買増支払Ｓ")
    private String ifcShrgkkimsshrs;


    public String getIfcShrgkkimsshrs() {
        return ifcShrgkkimsshrs;
    }


    public void setIfcShrgkkimsshrs(String pIfcShrgkkimsshrs) {
        ifcShrgkkimsshrs = pIfcShrgkkimsshrs;
    }


    @Column(order = 66, label = "支払保険金計Ｓ増件数")
    private String ifcShrgksmskensuu;


    public String getIfcShrgksmskensuu() {
        return ifcShrgksmskensuu;
    }


    public void setIfcShrgksmskensuu(String pIfcShrgksmskensuu) {
        ifcShrgksmskensuu = pIfcShrgksmskensuu;
    }


    @Column(order = 67, label = "支払保険金計Ｓ増支払Ｓ")
    private String ifcShrgksmsshrs;


    public String getIfcShrgksmsshrs() {
        return ifcShrgksmsshrs;
    }


    public void setIfcShrgksmsshrs(String pIfcShrgksmsshrs) {
        ifcShrgksmsshrs = pIfcShrgksmsshrs;
    }


    @Column(order = 68, label = "予備０１")
    private String ifcYobisiharai;


    public String getIfcYobisiharai() {
        return ifcYobisiharai;
    }


    public void setIfcYobisiharai(String pIfcYobisiharai) {
        ifcYobisiharai = pIfcYobisiharai;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
