package yuyu.def.siharai.file.csv;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;

/**
 * （支払）分割支払計算レイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSiBunkatuSiharaiKeisanLayoutFile implements Serializable {


    private static final long serialVersionUID = 1L;


    public GenSiBunkatuSiharaiKeisanLayoutFile() {
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


    @Column(order = 2, label = "死因区分")
    private String ifcHnyksiinkbn;


    public String getIfcHnyksiinkbn() {
        return ifcHnyksiinkbn;
    }


    public void setIfcHnyksiinkbn(String pIfcHnyksiinkbn) {
        ifcHnyksiinkbn = pIfcHnyksiinkbn;
    }


    @Column(order = 3, label = "商品コード")
    private String ifcSyouhncd;


    public String getIfcSyouhncd() {
        return ifcSyouhncd;
    }


    public void setIfcSyouhncd(String pIfcSyouhncd) {
        ifcSyouhncd = pIfcSyouhncd;
    }


    @Column(order = 4, label = "契約者名（カナ）")
    private String ifcKyknmkn;


    public String getIfcKyknmkn() {
        return ifcKyknmkn;
    }


    public void setIfcKyknmkn(String pIfcKyknmkn) {
        ifcKyknmkn = pIfcKyknmkn;
    }


    @Column(order = 5, label = "契約者名（漢字）")
    private String ifcKyknmkj;


    public String getIfcKyknmkj() {
        return ifcKyknmkj;
    }


    public void setIfcKyknmkj(String pIfcKyknmkj) {
        ifcKyknmkj = pIfcKyknmkj;
    }


    @Column(order = 6, label = "契約者郵便番号")
    private String ifcTsinyno;


    public String getIfcTsinyno() {
        return ifcTsinyno;
    }


    public void setIfcTsinyno(String pIfcTsinyno) {
        ifcTsinyno = pIfcTsinyno;
    }


    @Column(order = 7, label = "契約者住所１")
    private String ifcTsinadr1kj;


    public String getIfcTsinadr1kj() {
        return ifcTsinadr1kj;
    }


    public void setIfcTsinadr1kj(String pIfcTsinadr1kj) {
        ifcTsinadr1kj = pIfcTsinadr1kj;
    }


    @Column(order = 8, label = "契約者住所２")
    private String ifcTsinadr2kj;


    public String getIfcTsinadr2kj() {
        return ifcTsinadr2kj;
    }


    public void setIfcTsinadr2kj(String pIfcTsinadr2kj) {
        ifcTsinadr2kj = pIfcTsinadr2kj;
    }


    @Column(order = 9, label = "契約者住所３")
    private String ifcTsinadr3kj;


    public String getIfcTsinadr3kj() {
        return ifcTsinadr3kj;
    }


    public void setIfcTsinadr3kj(String pIfcTsinadr3kj) {
        ifcTsinadr3kj = pIfcTsinadr3kj;
    }


    @Column(order = 10, label = "被保険者名（カナ）")
    private String ifcHhknnmkn;


    public String getIfcHhknnmkn() {
        return ifcHhknnmkn;
    }


    public void setIfcHhknnmkn(String pIfcHhknnmkn) {
        ifcHhknnmkn = pIfcHhknnmkn;
    }


    @Column(order = 11, label = "被保険者名（漢字）")
    private String ifcHhknnmkj;


    public String getIfcHhknnmkj() {
        return ifcHhknnmkj;
    }


    public void setIfcHhknnmkj(String pIfcHhknnmkj) {
        ifcHhknnmkj = pIfcHhknnmkj;
    }


    @Column(order = 12, label = "被保険者郵便番号")
    private String ifcHhknyno;


    public String getIfcHhknyno() {
        return ifcHhknyno;
    }


    public void setIfcHhknyno(String pIfcHhknyno) {
        ifcHhknyno = pIfcHhknyno;
    }


    @Column(order = 13, label = "被保険者住所１")
    private String ifcHhknadr1kj;


    public String getIfcHhknadr1kj() {
        return ifcHhknadr1kj;
    }


    public void setIfcHhknadr1kj(String pIfcHhknadr1kj) {
        ifcHhknadr1kj = pIfcHhknadr1kj;
    }


    @Column(order = 14, label = "被保険者住所２")
    private String ifcHhknadr2kj;


    public String getIfcHhknadr2kj() {
        return ifcHhknadr2kj;
    }


    public void setIfcHhknadr2kj(String pIfcHhknadr2kj) {
        ifcHhknadr2kj = pIfcHhknadr2kj;
    }


    @Column(order = 15, label = "被保険者住所３")
    private String ifcHhknadr3kj;


    public String getIfcHhknadr3kj() {
        return ifcHhknadr3kj;
    }


    public void setIfcHhknadr3kj(String pIfcHhknadr3kj) {
        ifcHhknadr3kj = pIfcHhknadr3kj;
    }


    @Column(order = 16, label = "指定通貨")
    private C_Tuukasyu ifcKyktuukasyukbn;


    public C_Tuukasyu getIfcKyktuukasyukbn() {
        return ifcKyktuukasyukbn;
    }


    public void setIfcKyktuukasyukbn(C_Tuukasyu pIfcKyktuukasyukbn) {
        ifcKyktuukasyukbn = pIfcKyktuukasyukbn;
    }


    @Column(order = 17, label = "最低保証適用有無")
    private C_UmuKbn ifcSaiteihosyouumu;


    public C_UmuKbn getIfcSaiteihosyouumu() {
        return ifcSaiteihosyouumu;
    }


    public void setIfcSaiteihosyouumu(C_UmuKbn pIfcSaiteihosyouumu) {
        ifcSaiteihosyouumu = pIfcSaiteihosyouumu;
    }


    @Column(order = 18, label = "契約者変更回数")
    private Integer ifcKykhnkkaisuu;


    public Integer getIfcKykhnkkaisuu() {
        return ifcKykhnkkaisuu;
    }


    public void setIfcKykhnkkaisuu(Integer pIfcKykhnkkaisuu) {
        ifcKykhnkkaisuu = pIfcKykhnkkaisuu;
    }


    @Column(order = 19, label = "死亡受取人人数")
    private Integer ifcSbuktnin;


    public Integer getIfcSbuktnin() {
        return ifcSbuktnin;
    }


    public void setIfcSbuktnin(Integer pIfcSbuktnin) {
        ifcSbuktnin = pIfcSbuktnin;
    }


    @Column(order = 20, label = "分割方法")
    private String ifcBunkatuhouhou;


    public String getIfcBunkatuhouhou() {
        return ifcBunkatuhouhou;
    }


    public void setIfcBunkatuhouhou(String pIfcBunkatuhouhou) {
        ifcBunkatuhouhou = pIfcBunkatuhouhou;
    }


    @Column(order = 21, label = "受取割合（分子）１")
    private Integer ifcUktrwraibunsi1;


    public Integer getIfcUktrwraibunsi1() {
        return ifcUktrwraibunsi1;
    }


    public void setIfcUktrwraibunsi1(Integer pIfcUktrwraibunsi1) {
        ifcUktrwraibunsi1 = pIfcUktrwraibunsi1;
    }


    @Column(order = 22, label = "受取割合（分母）１")
    private Integer ifcUktrwraibunbo1;


    public Integer getIfcUktrwraibunbo1() {
        return ifcUktrwraibunbo1;
    }


    public void setIfcUktrwraibunbo1(Integer pIfcUktrwraibunbo1) {
        ifcUktrwraibunbo1 = pIfcUktrwraibunbo1;
    }


    @Column(order = 23, label = "受取割合（分子）２")
    private Integer ifcUktrwraibunsi2;


    public Integer getIfcUktrwraibunsi2() {
        return ifcUktrwraibunsi2;
    }


    public void setIfcUktrwraibunsi2(Integer pIfcUktrwraibunsi2) {
        ifcUktrwraibunsi2 = pIfcUktrwraibunsi2;
    }


    @Column(order = 24, label = "受取割合（分母）２")
    private Integer ifcUktrwraibunbo2;


    public Integer getIfcUktrwraibunbo2() {
        return ifcUktrwraibunbo2;
    }


    public void setIfcUktrwraibunbo2(Integer pIfcUktrwraibunbo2) {
        ifcUktrwraibunbo2 = pIfcUktrwraibunbo2;
    }


    @Column(order = 25, label = "受取割合（分子）３")
    private Integer ifcUktrwraibunsi3;


    public Integer getIfcUktrwraibunsi3() {
        return ifcUktrwraibunsi3;
    }


    public void setIfcUktrwraibunsi3(Integer pIfcUktrwraibunsi3) {
        ifcUktrwraibunsi3 = pIfcUktrwraibunsi3;
    }


    @Column(order = 26, label = "受取割合（分母）３")
    private Integer ifcUktrwraibunbo3;


    public Integer getIfcUktrwraibunbo3() {
        return ifcUktrwraibunbo3;
    }


    public void setIfcUktrwraibunbo3(Integer pIfcUktrwraibunbo3) {
        ifcUktrwraibunbo3 = pIfcUktrwraibunbo3;
    }


    @Column(order = 27, label = "受取割合（分子）４")
    private Integer ifcUktrwraibunsi4;


    public Integer getIfcUktrwraibunsi4() {
        return ifcUktrwraibunsi4;
    }


    public void setIfcUktrwraibunsi4(Integer pIfcUktrwraibunsi4) {
        ifcUktrwraibunsi4 = pIfcUktrwraibunsi4;
    }


    @Column(order = 28, label = "受取割合（分母）４")
    private Integer ifcUktrwraibunbo4;


    public Integer getIfcUktrwraibunbo4() {
        return ifcUktrwraibunbo4;
    }


    public void setIfcUktrwraibunbo4(Integer pIfcUktrwraibunbo4) {
        ifcUktrwraibunbo4 = pIfcUktrwraibunbo4;
    }


    @Column(order = 29, label = "受取割合（分子）５")
    private Integer ifcUktrwraibunsi5;


    public Integer getIfcUktrwraibunsi5() {
        return ifcUktrwraibunsi5;
    }


    public void setIfcUktrwraibunsi5(Integer pIfcUktrwraibunsi5) {
        ifcUktrwraibunsi5 = pIfcUktrwraibunsi5;
    }


    @Column(order = 30, label = "受取割合（分母）５")
    private Integer ifcUktrwraibunbo5;


    public Integer getIfcUktrwraibunbo5() {
        return ifcUktrwraibunbo5;
    }


    public void setIfcUktrwraibunbo5(Integer pIfcUktrwraibunbo5) {
        ifcUktrwraibunbo5 = pIfcUktrwraibunbo5;
    }


    @Column(order = 31, label = "受取割合（分子）６")
    private Integer ifcUktrwraibunsi6;


    public Integer getIfcUktrwraibunsi6() {
        return ifcUktrwraibunsi6;
    }


    public void setIfcUktrwraibunsi6(Integer pIfcUktrwraibunsi6) {
        ifcUktrwraibunsi6 = pIfcUktrwraibunsi6;
    }


    @Column(order = 32, label = "受取割合（分母）６")
    private Integer ifcUktrwraibunbo6;


    public Integer getIfcUktrwraibunbo6() {
        return ifcUktrwraibunbo6;
    }


    public void setIfcUktrwraibunbo6(Integer pIfcUktrwraibunbo6) {
        ifcUktrwraibunbo6 = pIfcUktrwraibunbo6;
    }


    @Column(order = 33, label = "受取割合（分子）７")
    private Integer ifcUktrwraibunsi7;


    public Integer getIfcUktrwraibunsi7() {
        return ifcUktrwraibunsi7;
    }


    public void setIfcUktrwraibunsi7(Integer pIfcUktrwraibunsi7) {
        ifcUktrwraibunsi7 = pIfcUktrwraibunsi7;
    }


    @Column(order = 34, label = "受取割合（分母）７")
    private Integer ifcUktrwraibunbo7;


    public Integer getIfcUktrwraibunbo7() {
        return ifcUktrwraibunbo7;
    }


    public void setIfcUktrwraibunbo7(Integer pIfcUktrwraibunbo7) {
        ifcUktrwraibunbo7 = pIfcUktrwraibunbo7;
    }


    @Column(order = 35, label = "受取割合（分子）８")
    private Integer ifcUktrwraibunsi8;


    public Integer getIfcUktrwraibunsi8() {
        return ifcUktrwraibunsi8;
    }


    public void setIfcUktrwraibunsi8(Integer pIfcUktrwraibunsi8) {
        ifcUktrwraibunsi8 = pIfcUktrwraibunsi8;
    }


    @Column(order = 36, label = "受取割合（分母）８")
    private Integer ifcUktrwraibunbo8;


    public Integer getIfcUktrwraibunbo8() {
        return ifcUktrwraibunbo8;
    }


    public void setIfcUktrwraibunbo8(Integer pIfcUktrwraibunbo8) {
        ifcUktrwraibunbo8 = pIfcUktrwraibunbo8;
    }


    @Column(order = 37, label = "受取割合（分子）９")
    private Integer ifcUktrwraibunsi9;


    public Integer getIfcUktrwraibunsi9() {
        return ifcUktrwraibunsi9;
    }


    public void setIfcUktrwraibunsi9(Integer pIfcUktrwraibunsi9) {
        ifcUktrwraibunsi9 = pIfcUktrwraibunsi9;
    }


    @Column(order = 38, label = "受取割合（分母）９")
    private Integer ifcUktrwraibunbo9;


    public Integer getIfcUktrwraibunbo9() {
        return ifcUktrwraibunbo9;
    }


    public void setIfcUktrwraibunbo9(Integer pIfcUktrwraibunbo9) {
        ifcUktrwraibunbo9 = pIfcUktrwraibunbo9;
    }


    @Column(order = 39, label = "受取割合（分子）１０")
    private Integer ifcUktrwraibunsi10;


    public Integer getIfcUktrwraibunsi10() {
        return ifcUktrwraibunsi10;
    }


    public void setIfcUktrwraibunsi10(Integer pIfcUktrwraibunsi10) {
        ifcUktrwraibunsi10 = pIfcUktrwraibunsi10;
    }


    @Column(order = 40, label = "受取割合（分母）１０")
    private Integer ifcUktrwraibunbo10;


    public Integer getIfcUktrwraibunbo10() {
        return ifcUktrwraibunbo10;
    }


    public void setIfcUktrwraibunbo10(Integer pIfcUktrwraibunbo10) {
        ifcUktrwraibunbo10 = pIfcUktrwraibunbo10;
    }


    @Column(order = 41, label = "受取割合（分子）１１")
    private Integer ifcUktrwraibunsi11;


    public Integer getIfcUktrwraibunsi11() {
        return ifcUktrwraibunsi11;
    }


    public void setIfcUktrwraibunsi11(Integer pIfcUktrwraibunsi11) {
        ifcUktrwraibunsi11 = pIfcUktrwraibunsi11;
    }


    @Column(order = 42, label = "受取割合（分母）１１")
    private Integer ifcUktrwraibunbo11;


    public Integer getIfcUktrwraibunbo11() {
        return ifcUktrwraibunbo11;
    }


    public void setIfcUktrwraibunbo11(Integer pIfcUktrwraibunbo11) {
        ifcUktrwraibunbo11 = pIfcUktrwraibunbo11;
    }


    @Column(order = 43, label = "受取割合（分子）１２")
    private Integer ifcUktrwraibunsi12;


    public Integer getIfcUktrwraibunsi12() {
        return ifcUktrwraibunsi12;
    }


    public void setIfcUktrwraibunsi12(Integer pIfcUktrwraibunsi12) {
        ifcUktrwraibunsi12 = pIfcUktrwraibunsi12;
    }


    @Column(order = 44, label = "受取割合（分母）１２")
    private Integer ifcUktrwraibunbo12;


    public Integer getIfcUktrwraibunbo12() {
        return ifcUktrwraibunbo12;
    }


    public void setIfcUktrwraibunbo12(Integer pIfcUktrwraibunbo12) {
        ifcUktrwraibunbo12 = pIfcUktrwraibunbo12;
    }


    @Column(order = 45, label = "受取割合（分子）１３")
    private Integer ifcUktrwraibunsi13;


    public Integer getIfcUktrwraibunsi13() {
        return ifcUktrwraibunsi13;
    }


    public void setIfcUktrwraibunsi13(Integer pIfcUktrwraibunsi13) {
        ifcUktrwraibunsi13 = pIfcUktrwraibunsi13;
    }


    @Column(order = 46, label = "受取割合（分母）１３")
    private Integer ifcUktrwraibunbo13;


    public Integer getIfcUktrwraibunbo13() {
        return ifcUktrwraibunbo13;
    }


    public void setIfcUktrwraibunbo13(Integer pIfcUktrwraibunbo13) {
        ifcUktrwraibunbo13 = pIfcUktrwraibunbo13;
    }


    @Column(order = 47, label = "受取割合（分子）１４")
    private Integer ifcUktrwraibunsi14;


    public Integer getIfcUktrwraibunsi14() {
        return ifcUktrwraibunsi14;
    }


    public void setIfcUktrwraibunsi14(Integer pIfcUktrwraibunsi14) {
        ifcUktrwraibunsi14 = pIfcUktrwraibunsi14;
    }


    @Column(order = 48, label = "受取割合（分母）１４")
    private Integer ifcUktrwraibunbo14;


    public Integer getIfcUktrwraibunbo14() {
        return ifcUktrwraibunbo14;
    }


    public void setIfcUktrwraibunbo14(Integer pIfcUktrwraibunbo14) {
        ifcUktrwraibunbo14 = pIfcUktrwraibunbo14;
    }


    @Column(order = 49, label = "受取割合（分子）１５")
    private Integer ifcUktrwraibunsi15;


    public Integer getIfcUktrwraibunsi15() {
        return ifcUktrwraibunsi15;
    }


    public void setIfcUktrwraibunsi15(Integer pIfcUktrwraibunsi15) {
        ifcUktrwraibunsi15 = pIfcUktrwraibunsi15;
    }


    @Column(order = 50, label = "受取割合（分母）１５")
    private Integer ifcUktrwraibunbo15;


    public Integer getIfcUktrwraibunbo15() {
        return ifcUktrwraibunbo15;
    }


    public void setIfcUktrwraibunbo15(Integer pIfcUktrwraibunbo15) {
        ifcUktrwraibunbo15 = pIfcUktrwraibunbo15;
    }


    @Column(order = 51, label = "支払対象受取人順位")
    private Integer ifcShrtaisyouuktrjuni;


    public Integer getIfcShrtaisyouuktrjuni() {
        return ifcShrtaisyouuktrjuni;
    }


    public void setIfcShrtaisyouuktrjuni(Integer pIfcShrtaisyouuktrjuni) {
        ifcShrtaisyouuktrjuni = pIfcShrtaisyouuktrjuni;
    }


    @Column(order = 52, label = "支払通貨")
    private C_Tuukasyu ifcShrtuukasyu;


    public C_Tuukasyu getIfcShrtuukasyu() {
        return ifcShrtuukasyu;
    }


    public void setIfcShrtuukasyu(C_Tuukasyu pIfcShrtuukasyu) {
        ifcShrtuukasyu = pIfcShrtuukasyu;
    }


    @Column(order = 53, label = "死亡受取人名（漢字）")
    private String ifcUktnmkj;


    public String getIfcUktnmkj() {
        return ifcUktnmkj;
    }


    public void setIfcUktnmkj(String pIfcUktnmkj) {
        ifcUktnmkj = pIfcUktnmkj;
    }


    @Column(order = 54, label = "支払明細書送付先郵便番号")
    private String ifcShskyno;


    public String getIfcShskyno() {
        return ifcShskyno;
    }


    public void setIfcShskyno(String pIfcShskyno) {
        ifcShskyno = pIfcShskyno;
    }


    @Column(order = 55, label = "支払明細書送付先住所１")
    private String ifcShskadr1kj;


    public String getIfcShskadr1kj() {
        return ifcShskadr1kj;
    }


    public void setIfcShskadr1kj(String pIfcShskadr1kj) {
        ifcShskadr1kj = pIfcShskadr1kj;
    }


    @Column(order = 56, label = "支払明細書送付先住所２")
    private String ifcShskadr2kj;


    public String getIfcShskadr2kj() {
        return ifcShskadr2kj;
    }


    public void setIfcShskadr2kj(String pIfcShskadr2kj) {
        ifcShskadr2kj = pIfcShskadr2kj;
    }


    @Column(order = 57, label = "支払明細書送付先住所３")
    private String ifcShskadr3kj;


    public String getIfcShskadr3kj() {
        return ifcShskadr3kj;
    }


    public void setIfcShskadr3kj(String pIfcShskadr3kj) {
        ifcShskadr3kj = pIfcShskadr3kj;
    }


    @Column(order = 58, label = "死亡日")
    private BizDate ifcSibouymd;


    public BizDate getIfcSibouymd() {
        return ifcSibouymd;
    }


    public void setIfcSibouymd(BizDate pIfcSibouymd) {
        ifcSibouymd = pIfcSibouymd;
    }


    @Column(order = 59, label = "書類受付日")
    private BizDate ifcSyoruiukeymd;


    public BizDate getIfcSyoruiukeymd() {
        return ifcSyoruiukeymd;
    }


    public void setIfcSyoruiukeymd(BizDate pIfcSyoruiukeymd) {
        ifcSyoruiukeymd = pIfcSyoruiukeymd;
    }


    @Column(order = 60, label = "支払日")
    private BizDate ifcShrymd;


    public BizDate getIfcShrymd() {
        return ifcShrymd;
    }


    public void setIfcShrymd(BizDate pIfcShrymd) {
        ifcShrymd = pIfcShrymd;
    }


    @Column(order = 61, label = "死亡仮受付日")
    private BizDate ifcSiboukariymd;


    public BizDate getIfcSiboukariymd() {
        return ifcSiboukariymd;
    }


    public void setIfcSiboukariymd(BizDate pIfcSiboukariymd) {
        ifcSiboukariymd = pIfcSiboukariymd;
    }


    @Column(order = 62, label = "円換算基準日")
    private BizDate ifcShrkwsratekjnymd;


    public BizDate getIfcShrkwsratekjnymd() {
        return ifcShrkwsratekjnymd;
    }


    public void setIfcShrkwsratekjnymd(BizDate pIfcShrkwsratekjnymd) {
        ifcShrkwsratekjnymd = pIfcShrkwsratekjnymd;
    }


    @Column(order = 63, label = "円換算為替レート")
    private BizNumber ifcShrkwsrate;


    public BizNumber getIfcShrkwsrate() {
        return ifcShrkwsrate;
    }


    public void setIfcShrkwsrate(BizNumber pIfcShrkwsrate) {
        ifcShrkwsrate = pIfcShrkwsrate;
    }


    @Column(order = 64, label = "外貨換算基準日")
    private BizDate ifcGaikaknsnkwsratekjymd;


    public BizDate getIfcGaikaknsnkwsratekjymd() {
        return ifcGaikaknsnkwsratekjymd;
    }


    public void setIfcGaikaknsnkwsratekjymd(BizDate pIfcGaikaknsnkwsratekjymd) {
        ifcGaikaknsnkwsratekjymd = pIfcGaikaknsnkwsratekjymd;
    }


    @Column(order = 65, label = "外貨換算為替レート")
    private BizNumber ifcGaikaknsnkwsrate;


    public BizNumber getIfcGaikaknsnkwsrate() {
        return ifcGaikaknsnkwsrate;
    }


    public void setIfcGaikaknsnkwsrate(BizNumber pIfcGaikaknsnkwsrate) {
        ifcGaikaknsnkwsrate = pIfcGaikaknsnkwsrate;
    }


    @Column(order = 66, label = "税務用為替レート基準日")
    private BizDate ifcZeimukwsratekjnymd;


    public BizDate getIfcZeimukwsratekjnymd() {
        return ifcZeimukwsratekjnymd;
    }


    public void setIfcZeimukwsratekjnymd(BizDate pIfcZeimukwsratekjnymd) {
        ifcZeimukwsratekjnymd = pIfcZeimukwsratekjnymd;
    }


    @Column(order = 67, label = "税務用為替レート")
    private BizNumber ifcZeimukwsrate;


    public BizNumber getIfcZeimukwsrate() {
        return ifcZeimukwsrate;
    }


    public void setIfcZeimukwsrate(BizNumber pIfcZeimukwsrate) {
        ifcZeimukwsrate = pIfcZeimukwsrate;
    }


    @Column(order = 68, label = "外貨管理金額合計（分割前）")
    private BizCurrency ifcBnktmaegaikagoukei;


    public BizCurrency getIfcBnktmaegaikagoukei() {
        return ifcBnktmaegaikagoukei;
    }


    public void setIfcBnktmaegaikagoukei(BizCurrency pIfcBnktmaegaikagoukei) {
        ifcBnktmaegaikagoukei = pIfcBnktmaegaikagoukei;
    }


    @Column(order = 69, label = "外貨管理保険金額合計（分割前）")
    private BizCurrency ifcBnktmaehokenkngkgoukei;


    public BizCurrency getIfcBnktmaehokenkngkgoukei() {
        return ifcBnktmaehokenkngkgoukei;
    }


    public void setIfcBnktmaehokenkngkgoukei(BizCurrency pIfcBnktmaehokenkngkgoukei) {
        ifcBnktmaehokenkngkgoukei = pIfcBnktmaehokenkngkgoukei;
    }


    @Column(order = 70, label = "外貨管理未経過保険料（分割前）")
    private BizCurrency ifcBnktmaemikeikap;


    public BizCurrency getIfcBnktmaemikeikap() {
        return ifcBnktmaemikeikap;
    }


    public void setIfcBnktmaemikeikap(BizCurrency pIfcBnktmaemikeikap) {
        ifcBnktmaemikeikap = pIfcBnktmaemikeikap;
    }


    @Column(order = 71, label = "外貨管理未収保険料（分割前）")
    private BizCurrency ifcBnktmaemisyuup;


    public BizCurrency getIfcBnktmaemisyuup() {
        return ifcBnktmaemisyuup;
    }


    public void setIfcBnktmaemisyuup(BizCurrency pIfcBnktmaemisyuup) {
        ifcBnktmaemisyuup = pIfcBnktmaemisyuup;
    }


    @Column(order = 72, label = "外貨管理前納精算金額（分割前）")
    private BizCurrency ifcBnktmaeznnusisnkgk;


    public BizCurrency getIfcBnktmaeznnusisnkgk() {
        return ifcBnktmaeznnusisnkgk;
    }


    public void setIfcBnktmaeznnusisnkgk(BizCurrency pIfcBnktmaeznnusisnkgk) {
        ifcBnktmaeznnusisnkgk = pIfcBnktmaeznnusisnkgk;
    }


    @Column(order = 73, label = "外貨管理税適預り金（分割前）")
    private BizCurrency ifcBnktmaezitkazkrknstitk;


    public BizCurrency getIfcBnktmaezitkazkrknstitk() {
        return ifcBnktmaezitkazkrknstitk;
    }


    public void setIfcBnktmaezitkazkrknstitk(BizCurrency pIfcBnktmaezitkazkrknstitk) {
        ifcBnktmaezitkazkrknstitk = pIfcBnktmaezitkazkrknstitk;
    }


    @Column(order = 74, label = "円貨管理金額合計（分割前）")
    private BizCurrency ifcBnktmaeyengoukei;


    public BizCurrency getIfcBnktmaeyengoukei() {
        return ifcBnktmaeyengoukei;
    }


    public void setIfcBnktmaeyengoukei(BizCurrency pIfcBnktmaeyengoukei) {
        ifcBnktmaeyengoukei = pIfcBnktmaeyengoukei;
    }


    @Column(order = 75, label = "円貨管理保険金額合計（分割前）")
    private BizCurrency ifcBnktmaeyenhknkngkguki;


    public BizCurrency getIfcBnktmaeyenhknkngkguki() {
        return ifcBnktmaeyenhknkngkguki;
    }


    public void setIfcBnktmaeyenhknkngkguki(BizCurrency pIfcBnktmaeyenhknkngkguki) {
        ifcBnktmaeyenhknkngkguki = pIfcBnktmaeyenhknkngkguki;
    }


    @Column(order = 76, label = "円貨管理配当金（分割前）")
    private BizCurrency ifcBnktmaeyenhaitoukin;


    public BizCurrency getIfcBnktmaeyenhaitoukin() {
        return ifcBnktmaeyenhaitoukin;
    }


    public void setIfcBnktmaeyenhaitoukin(BizCurrency pIfcBnktmaeyenhaitoukin) {
        ifcBnktmaeyenhaitoukin = pIfcBnktmaeyenhaitoukin;
    }


    @Column(order = 77, label = "円貨管理その他配当金（分割前）")
    private BizCurrency ifcBnktmaeyensntahaitoukn;


    public BizCurrency getIfcBnktmaeyensntahaitoukn() {
        return ifcBnktmaeyensntahaitoukn;
    }


    public void setIfcBnktmaeyensntahaitoukn(BizCurrency pIfcBnktmaeyensntahaitoukn) {
        ifcBnktmaeyensntahaitoukn = pIfcBnktmaeyensntahaitoukn;
    }


    @Column(order = 78, label = "円貨管理未経過保険料（分割前）")
    private BizCurrency ifcBnktmaeyenmikeikap;


    public BizCurrency getIfcBnktmaeyenmikeikap() {
        return ifcBnktmaeyenmikeikap;
    }


    public void setIfcBnktmaeyenmikeikap(BizCurrency pIfcBnktmaeyenmikeikap) {
        ifcBnktmaeyenmikeikap = pIfcBnktmaeyenmikeikap;
    }


    @Column(order = 79, label = "円貨管理未収保険料（分割前）")
    private BizCurrency ifcBnktmaeyenmisyuup;


    public BizCurrency getIfcBnktmaeyenmisyuup() {
        return ifcBnktmaeyenmisyuup;
    }


    public void setIfcBnktmaeyenmisyuup(BizCurrency pIfcBnktmaeyenmisyuup) {
        ifcBnktmaeyenmisyuup = pIfcBnktmaeyenmisyuup;
    }


    @Column(order = 80, label = "円貨管理前納精算金額（分割前）")
    private BizCurrency ifcBnktmaeyenznnusisnkgk;


    public BizCurrency getIfcBnktmaeyenznnusisnkgk() {
        return ifcBnktmaeyenznnusisnkgk;
    }


    public void setIfcBnktmaeyenznnusisnkgk(BizCurrency pIfcBnktmaeyenznnusisnkgk) {
        ifcBnktmaeyenznnusisnkgk = pIfcBnktmaeyenznnusisnkgk;
    }


    @Column(order = 81, label = "円貨管理税適預り金（分割前）")
    private BizCurrency ifcBnktmaezitkazkrknyen;


    public BizCurrency getIfcBnktmaezitkazkrknyen() {
        return ifcBnktmaezitkazkrknyen;
    }


    public void setIfcBnktmaezitkazkrknyen(BizCurrency pIfcBnktmaezitkazkrknyen) {
        ifcBnktmaezitkazkrknyen = pIfcBnktmaezitkazkrknyen;
    }


    @Column(order = 82, label = "円貨管理仮受金（分割前）")
    private BizCurrency ifcBnktmaeyenkrkgk;


    public BizCurrency getIfcBnktmaeyenkrkgk() {
        return ifcBnktmaeyenkrkgk;
    }


    public void setIfcBnktmaeyenkrkgk(BizCurrency pIfcBnktmaeyenkrkgk) {
        ifcBnktmaeyenkrkgk = pIfcBnktmaeyenkrkgk;
    }


    @Column(order = 83, label = "外貨管理金額合計（分割後）")
    private BizCurrency ifcBnktgogaikagoukei;


    public BizCurrency getIfcBnktgogaikagoukei() {
        return ifcBnktgogaikagoukei;
    }


    public void setIfcBnktgogaikagoukei(BizCurrency pIfcBnktgogaikagoukei) {
        ifcBnktgogaikagoukei = pIfcBnktgogaikagoukei;
    }


    @Column(order = 84, label = "外貨管理保険金額合計（分割後）")
    private BizCurrency ifcBnktgohokenkngkgoukei;


    public BizCurrency getIfcBnktgohokenkngkgoukei() {
        return ifcBnktgohokenkngkgoukei;
    }


    public void setIfcBnktgohokenkngkgoukei(BizCurrency pIfcBnktgohokenkngkgoukei) {
        ifcBnktgohokenkngkgoukei = pIfcBnktgohokenkngkgoukei;
    }


    @Column(order = 85, label = "外貨管理未経過保険料（分割後）")
    private BizCurrency ifcBnktgomikeikap;


    public BizCurrency getIfcBnktgomikeikap() {
        return ifcBnktgomikeikap;
    }


    public void setIfcBnktgomikeikap(BizCurrency pIfcBnktgomikeikap) {
        ifcBnktgomikeikap = pIfcBnktgomikeikap;
    }


    @Column(order = 86, label = "外貨管理未収保険料（分割後）")
    private BizCurrency ifcBnktgomisyuup;


    public BizCurrency getIfcBnktgomisyuup() {
        return ifcBnktgomisyuup;
    }


    public void setIfcBnktgomisyuup(BizCurrency pIfcBnktgomisyuup) {
        ifcBnktgomisyuup = pIfcBnktgomisyuup;
    }


    @Column(order = 87, label = "外貨管理前納精算金額（分割後）")
    private BizCurrency ifcBnktgoznnusisnkgk;


    public BizCurrency getIfcBnktgoznnusisnkgk() {
        return ifcBnktgoznnusisnkgk;
    }


    public void setIfcBnktgoznnusisnkgk(BizCurrency pIfcBnktgoznnusisnkgk) {
        ifcBnktgoznnusisnkgk = pIfcBnktgoznnusisnkgk;
    }


    @Column(order = 88, label = "外貨管理税適預り金（分割後）")
    private BizCurrency ifcBnktgozitkazkrknstituka;


    public BizCurrency getIfcBnktgozitkazkrknstituka() {
        return ifcBnktgozitkazkrknstituka;
    }


    public void setIfcBnktgozitkazkrknstituka(BizCurrency pIfcBnktgozitkazkrknstituka) {
        ifcBnktgozitkazkrknstituka = pIfcBnktgozitkazkrknstituka;
    }


    @Column(order = 89, label = "円貨管理金額合計（分割後）")
    private BizCurrency ifcBnktgoyengoukei;


    public BizCurrency getIfcBnktgoyengoukei() {
        return ifcBnktgoyengoukei;
    }


    public void setIfcBnktgoyengoukei(BizCurrency pIfcBnktgoyengoukei) {
        ifcBnktgoyengoukei = pIfcBnktgoyengoukei;
    }


    @Column(order = 90, label = "円貨管理保険金額合計（分割後）")
    private BizCurrency ifcBnktgoyenhknkngkguki;


    public BizCurrency getIfcBnktgoyenhknkngkguki() {
        return ifcBnktgoyenhknkngkguki;
    }


    public void setIfcBnktgoyenhknkngkguki(BizCurrency pIfcBnktgoyenhknkngkguki) {
        ifcBnktgoyenhknkngkguki = pIfcBnktgoyenhknkngkguki;
    }


    @Column(order = 91, label = "円貨管理配当金（分割後）")
    private BizCurrency ifcBnktgoyenhaitoukin;


    public BizCurrency getIfcBnktgoyenhaitoukin() {
        return ifcBnktgoyenhaitoukin;
    }


    public void setIfcBnktgoyenhaitoukin(BizCurrency pIfcBnktgoyenhaitoukin) {
        ifcBnktgoyenhaitoukin = pIfcBnktgoyenhaitoukin;
    }


    @Column(order = 92, label = "円貨管理その他配当金（分割後）")
    private BizCurrency ifcBnktgoyensonotahaitoukin;


    public BizCurrency getIfcBnktgoyensonotahaitoukin() {
        return ifcBnktgoyensonotahaitoukin;
    }


    public void setIfcBnktgoyensonotahaitoukin(BizCurrency pIfcBnktgoyensonotahaitoukin) {
        ifcBnktgoyensonotahaitoukin = pIfcBnktgoyensonotahaitoukin;
    }


    @Column(order = 93, label = "円貨管理未経過保険料（分割後）")
    private BizCurrency ifcBnktgoyenmikeikap;


    public BizCurrency getIfcBnktgoyenmikeikap() {
        return ifcBnktgoyenmikeikap;
    }


    public void setIfcBnktgoyenmikeikap(BizCurrency pIfcBnktgoyenmikeikap) {
        ifcBnktgoyenmikeikap = pIfcBnktgoyenmikeikap;
    }


    @Column(order = 94, label = "円貨管理未収保険料（分割後）")
    private BizCurrency ifcBnktgoyenmisyuup;


    public BizCurrency getIfcBnktgoyenmisyuup() {
        return ifcBnktgoyenmisyuup;
    }


    public void setIfcBnktgoyenmisyuup(BizCurrency pIfcBnktgoyenmisyuup) {
        ifcBnktgoyenmisyuup = pIfcBnktgoyenmisyuup;
    }


    @Column(order = 95, label = "円貨管理前納精算金額（分割後）")
    private BizCurrency ifcBnktgoyenznnusisnkgk;


    public BizCurrency getIfcBnktgoyenznnusisnkgk() {
        return ifcBnktgoyenznnusisnkgk;
    }


    public void setIfcBnktgoyenznnusisnkgk(BizCurrency pIfcBnktgoyenznnusisnkgk) {
        ifcBnktgoyenznnusisnkgk = pIfcBnktgoyenznnusisnkgk;
    }


    @Column(order = 96, label = "円貨管理税適預り金（分割後）")
    private BizCurrency ifcBnktgozitkazkrknyen;


    public BizCurrency getIfcBnktgozitkazkrknyen() {
        return ifcBnktgozitkazkrknyen;
    }


    public void setIfcBnktgozitkazkrknyen(BizCurrency pIfcBnktgozitkazkrknyen) {
        ifcBnktgozitkazkrknyen = pIfcBnktgozitkazkrknyen;
    }


    @Column(order = 97, label = "円貨管理仮受金（分割後）")
    private BizCurrency ifcBnktgoyenkrkgk;


    public BizCurrency getIfcBnktgoyenkrkgk() {
        return ifcBnktgoyenkrkgk;
    }


    public void setIfcBnktgoyenkrkgk(BizCurrency pIfcBnktgoyenkrkgk) {
        ifcBnktgoyenkrkgk = pIfcBnktgoyenkrkgk;
    }


    @Column(order = 98, label = "円換算後外貨管理金額合計")
    private BizCurrency ifcBnktgoyenkaknsntkgk;


    public BizCurrency getIfcBnktgoyenkaknsntkgk() {
        return ifcBnktgoyenkaknsntkgk;
    }


    public void setIfcBnktgoyenkaknsntkgk(BizCurrency pIfcBnktgoyenkaknsntkgk) {
        ifcBnktgoyenkaknsntkgk = pIfcBnktgoyenkaknsntkgk;
    }


    @Column(order = 99, label = "外貨換算後円貨管理金額合計")
    private BizCurrency ifcBnktgogaikaknsntkgk;


    public BizCurrency getIfcBnktgogaikaknsntkgk() {
        return ifcBnktgogaikaknsntkgk;
    }


    public void setIfcBnktgogaikaknsntkgk(BizCurrency pIfcBnktgogaikaknsntkgk) {
        ifcBnktgogaikaknsntkgk = pIfcBnktgogaikaknsntkgk;
    }


    @Column(order = 100, label = "遅延利息")
    private String ifcShrtienrsk;


    public String getIfcShrtienrsk() {
        return ifcShrtienrsk;
    }


    public void setIfcShrtienrsk(String pIfcShrtienrsk) {
        ifcShrtienrsk = pIfcShrtienrsk;
    }


    @Column(order = 101, label = "支払金額（支払通貨）")
    private BizCurrency ifcShrkgbizc;


    public BizCurrency getIfcShrkgbizc() {
        return ifcShrkgbizc;
    }


    public void setIfcShrkgbizc(BizCurrency pIfcShrkgbizc) {
        ifcShrkgbizc = pIfcShrkgbizc;
    }


    @Column(order = 102, label = "課税対象金額（分割後）")
    private String ifckztgk;


    public String getIfckztgk() {
        return ifckztgk;
    }


    public void setIfckztgk(String pIfckztgk) {
        ifckztgk = pIfckztgk;
    }


    @Column(order = 103, label = "支払調書保険金額等（分割後）")
    private String ifcSetc;


    public String getIfcSetc() {
        return ifcSetc;
    }


    public void setIfcSetc(String pIfcSetc) {
        ifcSetc = pIfcSetc;
    }


    @Column(order = 104, label = "支払調書未払利益配当金等（分割後）")
    private String ifcMbrriekihaitou;


    public String getIfcMbrriekihaitou() {
        return ifcMbrriekihaitou;
    }


    public void setIfcMbrriekihaitou(String pIfcMbrriekihaitou) {
        ifcMbrriekihaitou = pIfcMbrriekihaitou;
    }


    @Column(order = 105, label = "支払調書未払込保険料等（分割後）")
    private String ifcMihrkmpetc;


    public String getIfcMihrkmpetc() {
        return ifcMihrkmpetc;
    }


    public void setIfcMihrkmpetc(String pIfcMihrkmpetc) {
        ifcMihrkmpetc = pIfcMihrkmpetc;
    }


    @Column(order = 106, label = "支払調書前納保険料等払戻金（分割後）")
    private String ifcZennouphrmdskn;


    public String getIfcZennouphrmdskn() {
        return ifcZennouphrmdskn;
    }


    public void setIfcZennouphrmdskn(String pIfcZennouphrmdskn) {
        ifcZennouphrmdskn = pIfcZennouphrmdskn;
    }


    @Column(order = 107, label = "支払調書差引支払保険金額等（分割後）")
    private String ifcSshkshrgketc;


    public String getIfcSshkshrgketc() {
        return ifcSshkshrgketc;
    }


    public void setIfcSshkshrgketc(String pIfcSshkshrgketc) {
        ifcSshkshrgketc = pIfcSshkshrgketc;
    }


    @Column(order = 108, label = "支払調書既払込保険料等（分割後）")
    private String ifcKihrkmpetc;


    public String getIfcKihrkmpetc() {
        return ifcKihrkmpetc;
    }


    public void setIfcKihrkmpetc(String pIfcKihrkmpetc) {
        ifcKihrkmpetc = pIfcKihrkmpetc;
    }


    @Column(order = 109, label = "借方１勘定科目コード")
    private C_Kanjyoukmkcd ifcKrkanjyoukmkcd1;


    public C_Kanjyoukmkcd getIfcKrkanjyoukmkcd1() {
        return ifcKrkanjyoukmkcd1;
    }


    public void setIfcKrkanjyoukmkcd1(C_Kanjyoukmkcd pIfcKrkanjyoukmkcd1) {
        ifcKrkanjyoukmkcd1 = pIfcKrkanjyoukmkcd1;
    }


    @Column(order = 110, label = "借方１勘定科目名")
    private String ifcKrkanjyoukmknm1;


    public String getIfcKrkanjyoukmknm1() {
        return ifcKrkanjyoukmknm1;
    }


    public void setIfcKrkanjyoukmknm1(String pIfcKrkanjyoukmknm1) {
        ifcKrkanjyoukmknm1 = pIfcKrkanjyoukmknm1;
    }


    @Column(order = 111, label = "借方１金額")
    private BizCurrency ifcKrkngk1;


    public BizCurrency getIfcKrkngk1() {
        return ifcKrkngk1;
    }


    public void setIfcKrkngk1(BizCurrency pIfcKrkngk1) {
        ifcKrkngk1 = pIfcKrkngk1;
    }


    @Column(order = 112, label = "借方１金額単位")
    private C_Tuukasyu ifcKrkngktani1;


    public C_Tuukasyu getIfcKrkngktani1() {
        return ifcKrkngktani1;
    }


    public void setIfcKrkngktani1(C_Tuukasyu pIfcKrkngktani1) {
        ifcKrkngktani1 = pIfcKrkngktani1;
    }


    @Column(order = 113, label = "借方２勘定科目コード")
    private C_Kanjyoukmkcd ifcKrkanjyoukmkcd2;


    public C_Kanjyoukmkcd getIfcKrkanjyoukmkcd2() {
        return ifcKrkanjyoukmkcd2;
    }


    public void setIfcKrkanjyoukmkcd2(C_Kanjyoukmkcd pIfcKrkanjyoukmkcd2) {
        ifcKrkanjyoukmkcd2 = pIfcKrkanjyoukmkcd2;
    }


    @Column(order = 114, label = "借方２勘定科目名")
    private String ifcKrkanjyoukmknm2;


    public String getIfcKrkanjyoukmknm2() {
        return ifcKrkanjyoukmknm2;
    }


    public void setIfcKrkanjyoukmknm2(String pIfcKrkanjyoukmknm2) {
        ifcKrkanjyoukmknm2 = pIfcKrkanjyoukmknm2;
    }


    @Column(order = 115, label = "借方２金額")
    private BizCurrency ifcKrkngk2;


    public BizCurrency getIfcKrkngk2() {
        return ifcKrkngk2;
    }


    public void setIfcKrkngk2(BizCurrency pIfcKrkngk2) {
        ifcKrkngk2 = pIfcKrkngk2;
    }


    @Column(order = 116, label = "借方２金額単位")
    private C_Tuukasyu ifcKrkngktani2;


    public C_Tuukasyu getIfcKrkngktani2() {
        return ifcKrkngktani2;
    }


    public void setIfcKrkngktani2(C_Tuukasyu pIfcKrkngktani2) {
        ifcKrkngktani2 = pIfcKrkngktani2;
    }


    @Column(order = 117, label = "借方３勘定科目コード")
    private C_Kanjyoukmkcd ifcKrkanjyoukmkcd3;


    public C_Kanjyoukmkcd getIfcKrkanjyoukmkcd3() {
        return ifcKrkanjyoukmkcd3;
    }


    public void setIfcKrkanjyoukmkcd3(C_Kanjyoukmkcd pIfcKrkanjyoukmkcd3) {
        ifcKrkanjyoukmkcd3 = pIfcKrkanjyoukmkcd3;
    }


    @Column(order = 118, label = "借方３勘定科目名")
    private String ifcKrkanjyoukmknm3;


    public String getIfcKrkanjyoukmknm3() {
        return ifcKrkanjyoukmknm3;
    }


    public void setIfcKrkanjyoukmknm3(String pIfcKrkanjyoukmknm3) {
        ifcKrkanjyoukmknm3 = pIfcKrkanjyoukmknm3;
    }


    @Column(order = 119, label = "借方３金額")
    private BizCurrency ifcKrkngk3;


    public BizCurrency getIfcKrkngk3() {
        return ifcKrkngk3;
    }


    public void setIfcKrkngk3(BizCurrency pIfcKrkngk3) {
        ifcKrkngk3 = pIfcKrkngk3;
    }


    @Column(order = 120, label = "借方３金額単位")
    private C_Tuukasyu ifcKrkngktani3;


    public C_Tuukasyu getIfcKrkngktani3() {
        return ifcKrkngktani3;
    }


    public void setIfcKrkngktani3(C_Tuukasyu pIfcKrkngktani3) {
        ifcKrkngktani3 = pIfcKrkngktani3;
    }


    @Column(order = 121, label = "借方４勘定科目コード")
    private C_Kanjyoukmkcd ifcKrkanjyoukmkcd4;


    public C_Kanjyoukmkcd getIfcKrkanjyoukmkcd4() {
        return ifcKrkanjyoukmkcd4;
    }


    public void setIfcKrkanjyoukmkcd4(C_Kanjyoukmkcd pIfcKrkanjyoukmkcd4) {
        ifcKrkanjyoukmkcd4 = pIfcKrkanjyoukmkcd4;
    }


    @Column(order = 122, label = "借方４勘定科目名")
    private String ifcKrkanjyoukmknm4;


    public String getIfcKrkanjyoukmknm4() {
        return ifcKrkanjyoukmknm4;
    }


    public void setIfcKrkanjyoukmknm4(String pIfcKrkanjyoukmknm4) {
        ifcKrkanjyoukmknm4 = pIfcKrkanjyoukmknm4;
    }


    @Column(order = 123, label = "借方４金額")
    private BizCurrency ifcKrkngk4;


    public BizCurrency getIfcKrkngk4() {
        return ifcKrkngk4;
    }


    public void setIfcKrkngk4(BizCurrency pIfcKrkngk4) {
        ifcKrkngk4 = pIfcKrkngk4;
    }


    @Column(order = 124, label = "借方４金額単位")
    private C_Tuukasyu ifcKrkngktani4;


    public C_Tuukasyu getIfcKrkngktani4() {
        return ifcKrkngktani4;
    }


    public void setIfcKrkngktani4(C_Tuukasyu pIfcKrkngktani4) {
        ifcKrkngktani4 = pIfcKrkngktani4;
    }


    @Column(order = 125, label = "借方５勘定科目コード")
    private C_Kanjyoukmkcd ifcKrkanjyoukmkcd5;


    public C_Kanjyoukmkcd getIfcKrkanjyoukmkcd5() {
        return ifcKrkanjyoukmkcd5;
    }


    public void setIfcKrkanjyoukmkcd5(C_Kanjyoukmkcd pIfcKrkanjyoukmkcd5) {
        ifcKrkanjyoukmkcd5 = pIfcKrkanjyoukmkcd5;
    }


    @Column(order = 126, label = "借方５勘定科目名")
    private String ifcKrkanjyoukmknm5;


    public String getIfcKrkanjyoukmknm5() {
        return ifcKrkanjyoukmknm5;
    }


    public void setIfcKrkanjyoukmknm5(String pIfcKrkanjyoukmknm5) {
        ifcKrkanjyoukmknm5 = pIfcKrkanjyoukmknm5;
    }


    @Column(order = 127, label = "借方５金額")
    private BizCurrency ifcKrkngk5;


    public BizCurrency getIfcKrkngk5() {
        return ifcKrkngk5;
    }


    public void setIfcKrkngk5(BizCurrency pIfcKrkngk5) {
        ifcKrkngk5 = pIfcKrkngk5;
    }


    @Column(order = 128, label = "借方５金額単位")
    private C_Tuukasyu ifcKrkngktani5;


    public C_Tuukasyu getIfcKrkngktani5() {
        return ifcKrkngktani5;
    }


    public void setIfcKrkngktani5(C_Tuukasyu pIfcKrkngktani5) {
        ifcKrkngktani5 = pIfcKrkngktani5;
    }


    @Column(order = 129, label = "借方６勘定科目コード")
    private C_Kanjyoukmkcd ifcKrkanjyoukmkcd6;


    public C_Kanjyoukmkcd getIfcKrkanjyoukmkcd6() {
        return ifcKrkanjyoukmkcd6;
    }


    public void setIfcKrkanjyoukmkcd6(C_Kanjyoukmkcd pIfcKrkanjyoukmkcd6) {
        ifcKrkanjyoukmkcd6 = pIfcKrkanjyoukmkcd6;
    }


    @Column(order = 130, label = "借方６勘定科目名")
    private String ifcKrkanjyoukmknm6;


    public String getIfcKrkanjyoukmknm6() {
        return ifcKrkanjyoukmknm6;
    }


    public void setIfcKrkanjyoukmknm6(String pIfcKrkanjyoukmknm6) {
        ifcKrkanjyoukmknm6 = pIfcKrkanjyoukmknm6;
    }


    @Column(order = 131, label = "借方６金額")
    private BizCurrency ifcKrkngk6;


    public BizCurrency getIfcKrkngk6() {
        return ifcKrkngk6;
    }


    public void setIfcKrkngk6(BizCurrency pIfcKrkngk6) {
        ifcKrkngk6 = pIfcKrkngk6;
    }


    @Column(order = 132, label = "借方６金額単位")
    private C_Tuukasyu ifcKrkngktani6;


    public C_Tuukasyu getIfcKrkngktani6() {
        return ifcKrkngktani6;
    }


    public void setIfcKrkngktani6(C_Tuukasyu pIfcKrkngktani6) {
        ifcKrkngktani6 = pIfcKrkngktani6;
    }


    @Column(order = 133, label = "借方７勘定科目コード")
    private C_Kanjyoukmkcd ifcKrkanjyoukmkcd7;


    public C_Kanjyoukmkcd getIfcKrkanjyoukmkcd7() {
        return ifcKrkanjyoukmkcd7;
    }


    public void setIfcKrkanjyoukmkcd7(C_Kanjyoukmkcd pIfcKrkanjyoukmkcd7) {
        ifcKrkanjyoukmkcd7 = pIfcKrkanjyoukmkcd7;
    }


    @Column(order = 134, label = "借方７勘定科目名")
    private String ifcKrkanjyoukmknm7;


    public String getIfcKrkanjyoukmknm7() {
        return ifcKrkanjyoukmknm7;
    }


    public void setIfcKrkanjyoukmknm7(String pIfcKrkanjyoukmknm7) {
        ifcKrkanjyoukmknm7 = pIfcKrkanjyoukmknm7;
    }


    @Column(order = 135, label = "借方７金額")
    private BizCurrency ifcKrkngk7;


    public BizCurrency getIfcKrkngk7() {
        return ifcKrkngk7;
    }


    public void setIfcKrkngk7(BizCurrency pIfcKrkngk7) {
        ifcKrkngk7 = pIfcKrkngk7;
    }


    @Column(order = 136, label = "借方７金額単位")
    private C_Tuukasyu ifcKrkngktani7;


    public C_Tuukasyu getIfcKrkngktani7() {
        return ifcKrkngktani7;
    }


    public void setIfcKrkngktani7(C_Tuukasyu pIfcKrkngktani7) {
        ifcKrkngktani7 = pIfcKrkngktani7;
    }


    @Column(order = 137, label = "借方８勘定科目コード")
    private C_Kanjyoukmkcd ifcKrkanjyoukmkcd8;


    public C_Kanjyoukmkcd getIfcKrkanjyoukmkcd8() {
        return ifcKrkanjyoukmkcd8;
    }


    public void setIfcKrkanjyoukmkcd8(C_Kanjyoukmkcd pIfcKrkanjyoukmkcd8) {
        ifcKrkanjyoukmkcd8 = pIfcKrkanjyoukmkcd8;
    }


    @Column(order = 138, label = "借方８勘定科目名")
    private String ifcKrkanjyoukmknm8;


    public String getIfcKrkanjyoukmknm8() {
        return ifcKrkanjyoukmknm8;
    }


    public void setIfcKrkanjyoukmknm8(String pIfcKrkanjyoukmknm8) {
        ifcKrkanjyoukmknm8 = pIfcKrkanjyoukmknm8;
    }


    @Column(order = 139, label = "借方８金額")
    private BizCurrency ifcKrkngk8;


    public BizCurrency getIfcKrkngk8() {
        return ifcKrkngk8;
    }


    public void setIfcKrkngk8(BizCurrency pIfcKrkngk8) {
        ifcKrkngk8 = pIfcKrkngk8;
    }


    @Column(order = 140, label = "借方８金額単位")
    private C_Tuukasyu ifcKrkngktani8;


    public C_Tuukasyu getIfcKrkngktani8() {
        return ifcKrkngktani8;
    }


    public void setIfcKrkngktani8(C_Tuukasyu pIfcKrkngktani8) {
        ifcKrkngktani8 = pIfcKrkngktani8;
    }


    @Column(order = 141, label = "借方９勘定科目コード")
    private C_Kanjyoukmkcd ifcKrkanjyoukmkcd9;


    public C_Kanjyoukmkcd getIfcKrkanjyoukmkcd9() {
        return ifcKrkanjyoukmkcd9;
    }


    public void setIfcKrkanjyoukmkcd9(C_Kanjyoukmkcd pIfcKrkanjyoukmkcd9) {
        ifcKrkanjyoukmkcd9 = pIfcKrkanjyoukmkcd9;
    }


    @Column(order = 142, label = "借方９勘定科目名")
    private String ifcKrkanjyoukmknm9;


    public String getIfcKrkanjyoukmknm9() {
        return ifcKrkanjyoukmknm9;
    }


    public void setIfcKrkanjyoukmknm9(String pIfcKrkanjyoukmknm9) {
        ifcKrkanjyoukmknm9 = pIfcKrkanjyoukmknm9;
    }


    @Column(order = 143, label = "借方９金額")
    private BizCurrency ifcKrkngk9;


    public BizCurrency getIfcKrkngk9() {
        return ifcKrkngk9;
    }


    public void setIfcKrkngk9(BizCurrency pIfcKrkngk9) {
        ifcKrkngk9 = pIfcKrkngk9;
    }


    @Column(order = 144, label = "借方９金額単位")
    private C_Tuukasyu ifcKrkngktani9;


    public C_Tuukasyu getIfcKrkngktani9() {
        return ifcKrkngktani9;
    }


    public void setIfcKrkngktani9(C_Tuukasyu pIfcKrkngktani9) {
        ifcKrkngktani9 = pIfcKrkngktani9;
    }


    @Column(order = 145, label = "借方１０勘定科目コード")
    private C_Kanjyoukmkcd ifcKrkanjyoukmkcd10;


    public C_Kanjyoukmkcd getIfcKrkanjyoukmkcd10() {
        return ifcKrkanjyoukmkcd10;
    }


    public void setIfcKrkanjyoukmkcd10(C_Kanjyoukmkcd pIfcKrkanjyoukmkcd10) {
        ifcKrkanjyoukmkcd10 = pIfcKrkanjyoukmkcd10;
    }


    @Column(order = 146, label = "借方１０勘定科目名")
    private String ifcKrkanjyoukmknm10;


    public String getIfcKrkanjyoukmknm10() {
        return ifcKrkanjyoukmknm10;
    }


    public void setIfcKrkanjyoukmknm10(String pIfcKrkanjyoukmknm10) {
        ifcKrkanjyoukmknm10 = pIfcKrkanjyoukmknm10;
    }


    @Column(order = 147, label = "借方１０金額")
    private BizCurrency ifcKrkngk10;


    public BizCurrency getIfcKrkngk10() {
        return ifcKrkngk10;
    }


    public void setIfcKrkngk10(BizCurrency pIfcKrkngk10) {
        ifcKrkngk10 = pIfcKrkngk10;
    }


    @Column(order = 148, label = "借方１０金額単位")
    private C_Tuukasyu ifcKrkngktani10;


    public C_Tuukasyu getIfcKrkngktani10() {
        return ifcKrkngktani10;
    }


    public void setIfcKrkngktani10(C_Tuukasyu pIfcKrkngktani10) {
        ifcKrkngktani10 = pIfcKrkngktani10;
    }


    @Column(order = 149, label = "貸方１勘定科目コード")
    private C_Kanjyoukmkcd ifcKskanjyoukmkcd1;


    public C_Kanjyoukmkcd getIfcKskanjyoukmkcd1() {
        return ifcKskanjyoukmkcd1;
    }


    public void setIfcKskanjyoukmkcd1(C_Kanjyoukmkcd pIfcKskanjyoukmkcd1) {
        ifcKskanjyoukmkcd1 = pIfcKskanjyoukmkcd1;
    }


    @Column(order = 150, label = "貸方１勘定科目名")
    private String ifcKskanjyoukmknm1;


    public String getIfcKskanjyoukmknm1() {
        return ifcKskanjyoukmknm1;
    }


    public void setIfcKskanjyoukmknm1(String pIfcKskanjyoukmknm1) {
        ifcKskanjyoukmknm1 = pIfcKskanjyoukmknm1;
    }


    @Column(order = 151, label = "貸方１金額")
    private BizCurrency ifcKskngk1;


    public BizCurrency getIfcKskngk1() {
        return ifcKskngk1;
    }


    public void setIfcKskngk1(BizCurrency pIfcKskngk1) {
        ifcKskngk1 = pIfcKskngk1;
    }


    @Column(order = 152, label = "貸方１金額単位")
    private C_Tuukasyu ifcKskngktani1;


    public C_Tuukasyu getIfcKskngktani1() {
        return ifcKskngktani1;
    }


    public void setIfcKskngktani1(C_Tuukasyu pIfcKskngktani1) {
        ifcKskngktani1 = pIfcKskngktani1;
    }


    @Column(order = 153, label = "貸方２勘定科目コード")
    private C_Kanjyoukmkcd ifcKskanjyoukmkcd2;


    public C_Kanjyoukmkcd getIfcKskanjyoukmkcd2() {
        return ifcKskanjyoukmkcd2;
    }


    public void setIfcKskanjyoukmkcd2(C_Kanjyoukmkcd pIfcKskanjyoukmkcd2) {
        ifcKskanjyoukmkcd2 = pIfcKskanjyoukmkcd2;
    }


    @Column(order = 154, label = "貸方２勘定科目名")
    private String ifcKskanjyoukmknm2;


    public String getIfcKskanjyoukmknm2() {
        return ifcKskanjyoukmknm2;
    }


    public void setIfcKskanjyoukmknm2(String pIfcKskanjyoukmknm2) {
        ifcKskanjyoukmknm2 = pIfcKskanjyoukmknm2;
    }


    @Column(order = 155, label = "貸方２金額")
    private BizCurrency ifcKskngk2;


    public BizCurrency getIfcKskngk2() {
        return ifcKskngk2;
    }


    public void setIfcKskngk2(BizCurrency pIfcKskngk2) {
        ifcKskngk2 = pIfcKskngk2;
    }


    @Column(order = 156, label = "貸方２金額単位")
    private C_Tuukasyu ifcKskngktani2;


    public C_Tuukasyu getIfcKskngktani2() {
        return ifcKskngktani2;
    }


    public void setIfcKskngktani2(C_Tuukasyu pIfcKskngktani2) {
        ifcKskngktani2 = pIfcKskngktani2;
    }


    @Column(order = 157, label = "貸方３勘定科目コード")
    private C_Kanjyoukmkcd ifcKskanjyoukmkcd3;


    public C_Kanjyoukmkcd getIfcKskanjyoukmkcd3() {
        return ifcKskanjyoukmkcd3;
    }


    public void setIfcKskanjyoukmkcd3(C_Kanjyoukmkcd pIfcKskanjyoukmkcd3) {
        ifcKskanjyoukmkcd3 = pIfcKskanjyoukmkcd3;
    }


    @Column(order = 158, label = "貸方３勘定科目名")
    private String ifcKskanjyoukmknm3;


    public String getIfcKskanjyoukmknm3() {
        return ifcKskanjyoukmknm3;
    }


    public void setIfcKskanjyoukmknm3(String pIfcKskanjyoukmknm3) {
        ifcKskanjyoukmknm3 = pIfcKskanjyoukmknm3;
    }


    @Column(order = 159, label = "貸方３金額")
    private BizCurrency ifcKskngk3;


    public BizCurrency getIfcKskngk3() {
        return ifcKskngk3;
    }


    public void setIfcKskngk3(BizCurrency pIfcKskngk3) {
        ifcKskngk3 = pIfcKskngk3;
    }


    @Column(order = 160, label = "貸方３金額単位")
    private C_Tuukasyu ifcKskngktani3;


    public C_Tuukasyu getIfcKskngktani3() {
        return ifcKskngktani3;
    }


    public void setIfcKskngktani3(C_Tuukasyu pIfcKskngktani3) {
        ifcKskngktani3 = pIfcKskngktani3;
    }


    @Column(order = 161, label = "貸方４勘定科目コード")
    private C_Kanjyoukmkcd ifcKskanjyoukmkcd4;


    public C_Kanjyoukmkcd getIfcKskanjyoukmkcd4() {
        return ifcKskanjyoukmkcd4;
    }


    public void setIfcKskanjyoukmkcd4(C_Kanjyoukmkcd pIfcKskanjyoukmkcd4) {
        ifcKskanjyoukmkcd4 = pIfcKskanjyoukmkcd4;
    }


    @Column(order = 162, label = "貸方４勘定科目名")
    private String ifcKskanjyoukmknm4;


    public String getIfcKskanjyoukmknm4() {
        return ifcKskanjyoukmknm4;
    }


    public void setIfcKskanjyoukmknm4(String pIfcKskanjyoukmknm4) {
        ifcKskanjyoukmknm4 = pIfcKskanjyoukmknm4;
    }


    @Column(order = 163, label = "貸方４金額")
    private BizCurrency ifcKskngk4;


    public BizCurrency getIfcKskngk4() {
        return ifcKskngk4;
    }


    public void setIfcKskngk4(BizCurrency pIfcKskngk4) {
        ifcKskngk4 = pIfcKskngk4;
    }


    @Column(order = 164, label = "貸方４金額単位")
    private C_Tuukasyu ifcKskngktani4;


    public C_Tuukasyu getIfcKskngktani4() {
        return ifcKskngktani4;
    }


    public void setIfcKskngktani4(C_Tuukasyu pIfcKskngktani4) {
        ifcKskngktani4 = pIfcKskngktani4;
    }


    @Column(order = 165, label = "貸方５勘定科目コード")
    private C_Kanjyoukmkcd ifcKskanjyoukmkcd5;


    public C_Kanjyoukmkcd getIfcKskanjyoukmkcd5() {
        return ifcKskanjyoukmkcd5;
    }


    public void setIfcKskanjyoukmkcd5(C_Kanjyoukmkcd pIfcKskanjyoukmkcd5) {
        ifcKskanjyoukmkcd5 = pIfcKskanjyoukmkcd5;
    }


    @Column(order = 166, label = "貸方５勘定科目名")
    private String ifcKskanjyoukmknm5;


    public String getIfcKskanjyoukmknm5() {
        return ifcKskanjyoukmknm5;
    }


    public void setIfcKskanjyoukmknm5(String pIfcKskanjyoukmknm5) {
        ifcKskanjyoukmknm5 = pIfcKskanjyoukmknm5;
    }


    @Column(order = 167, label = "貸方５金額")
    private BizCurrency ifcKskngk5;


    public BizCurrency getIfcKskngk5() {
        return ifcKskngk5;
    }


    public void setIfcKskngk5(BizCurrency pIfcKskngk5) {
        ifcKskngk5 = pIfcKskngk5;
    }


    @Column(order = 168, label = "貸方５金額単位")
    private C_Tuukasyu ifcKskngktani5;


    public C_Tuukasyu getIfcKskngktani5() {
        return ifcKskngktani5;
    }


    public void setIfcKskngktani5(C_Tuukasyu pIfcKskngktani5) {
        ifcKskngktani5 = pIfcKskngktani5;
    }


    @Column(order = 169, label = "貸方６勘定科目コード")
    private C_Kanjyoukmkcd ifcKskanjyoukmkcd6;


    public C_Kanjyoukmkcd getIfcKskanjyoukmkcd6() {
        return ifcKskanjyoukmkcd6;
    }


    public void setIfcKskanjyoukmkcd6(C_Kanjyoukmkcd pIfcKskanjyoukmkcd6) {
        ifcKskanjyoukmkcd6 = pIfcKskanjyoukmkcd6;
    }


    @Column(order = 170, label = "貸方６勘定科目名")
    private String ifcKskanjyoukmknm6;


    public String getIfcKskanjyoukmknm6() {
        return ifcKskanjyoukmknm6;
    }


    public void setIfcKskanjyoukmknm6(String pIfcKskanjyoukmknm6) {
        ifcKskanjyoukmknm6 = pIfcKskanjyoukmknm6;
    }


    @Column(order = 171, label = "貸方６金額")
    private BizCurrency ifcKskngk6;


    public BizCurrency getIfcKskngk6() {
        return ifcKskngk6;
    }


    public void setIfcKskngk6(BizCurrency pIfcKskngk6) {
        ifcKskngk6 = pIfcKskngk6;
    }


    @Column(order = 172, label = "貸方６金額単位")
    private C_Tuukasyu ifcKskngktani6;


    public C_Tuukasyu getIfcKskngktani6() {
        return ifcKskngktani6;
    }


    public void setIfcKskngktani6(C_Tuukasyu pIfcKskngktani6) {
        ifcKskngktani6 = pIfcKskngktani6;
    }


    @Column(order = 173, label = "貸方７勘定科目コード")
    private C_Kanjyoukmkcd ifcKskanjyoukmkcd7;


    public C_Kanjyoukmkcd getIfcKskanjyoukmkcd7() {
        return ifcKskanjyoukmkcd7;
    }


    public void setIfcKskanjyoukmkcd7(C_Kanjyoukmkcd pIfcKskanjyoukmkcd7) {
        ifcKskanjyoukmkcd7 = pIfcKskanjyoukmkcd7;
    }


    @Column(order = 174, label = "貸方７勘定科目名")
    private String ifcKskanjyoukmknm7;


    public String getIfcKskanjyoukmknm7() {
        return ifcKskanjyoukmknm7;
    }


    public void setIfcKskanjyoukmknm7(String pIfcKskanjyoukmknm7) {
        ifcKskanjyoukmknm7 = pIfcKskanjyoukmknm7;
    }


    @Column(order = 175, label = "貸方７金額")
    private BizCurrency ifcKskngk7;


    public BizCurrency getIfcKskngk7() {
        return ifcKskngk7;
    }


    public void setIfcKskngk7(BizCurrency pIfcKskngk7) {
        ifcKskngk7 = pIfcKskngk7;
    }


    @Column(order = 176, label = "貸方７金額単位")
    private C_Tuukasyu ifcKskngktani7;


    public C_Tuukasyu getIfcKskngktani7() {
        return ifcKskngktani7;
    }


    public void setIfcKskngktani7(C_Tuukasyu pIfcKskngktani7) {
        ifcKskngktani7 = pIfcKskngktani7;
    }


    @Column(order = 177, label = "貸方８勘定科目コード")
    private C_Kanjyoukmkcd ifcKskanjyoukmkcd8;


    public C_Kanjyoukmkcd getIfcKskanjyoukmkcd8() {
        return ifcKskanjyoukmkcd8;
    }


    public void setIfcKskanjyoukmkcd8(C_Kanjyoukmkcd pIfcKskanjyoukmkcd8) {
        ifcKskanjyoukmkcd8 = pIfcKskanjyoukmkcd8;
    }


    @Column(order = 178, label = "貸方８勘定科目名")
    private String ifcKskanjyoukmknm8;


    public String getIfcKskanjyoukmknm8() {
        return ifcKskanjyoukmknm8;
    }


    public void setIfcKskanjyoukmknm8(String pIfcKskanjyoukmknm8) {
        ifcKskanjyoukmknm8 = pIfcKskanjyoukmknm8;
    }


    @Column(order = 179, label = "貸方８金額")
    private BizCurrency ifcKskngk8;


    public BizCurrency getIfcKskngk8() {
        return ifcKskngk8;
    }


    public void setIfcKskngk8(BizCurrency pIfcKskngk8) {
        ifcKskngk8 = pIfcKskngk8;
    }


    @Column(order = 180, label = "貸方８金額単位")
    private C_Tuukasyu ifcKskngktani8;


    public C_Tuukasyu getIfcKskngktani8() {
        return ifcKskngktani8;
    }


    public void setIfcKskngktani8(C_Tuukasyu pIfcKskngktani8) {
        ifcKskngktani8 = pIfcKskngktani8;
    }


    @Column(order = 181, label = "貸方９勘定科目コード")
    private C_Kanjyoukmkcd ifcKskanjyoukmkcd9;


    public C_Kanjyoukmkcd getIfcKskanjyoukmkcd9() {
        return ifcKskanjyoukmkcd9;
    }


    public void setIfcKskanjyoukmkcd9(C_Kanjyoukmkcd pIfcKskanjyoukmkcd9) {
        ifcKskanjyoukmkcd9 = pIfcKskanjyoukmkcd9;
    }


    @Column(order = 182, label = "貸方９勘定科目名")
    private String ifcKskanjyoukmknm9;


    public String getIfcKskanjyoukmknm9() {
        return ifcKskanjyoukmknm9;
    }


    public void setIfcKskanjyoukmknm9(String pIfcKskanjyoukmknm9) {
        ifcKskanjyoukmknm9 = pIfcKskanjyoukmknm9;
    }


    @Column(order = 183, label = "貸方９金額")
    private BizCurrency ifcKskngk9;


    public BizCurrency getIfcKskngk9() {
        return ifcKskngk9;
    }


    public void setIfcKskngk9(BizCurrency pIfcKskngk9) {
        ifcKskngk9 = pIfcKskngk9;
    }


    @Column(order = 184, label = "貸方９金額単位")
    private C_Tuukasyu ifcKskngktani9;


    public C_Tuukasyu getIfcKskngktani9() {
        return ifcKskngktani9;
    }


    public void setIfcKskngktani9(C_Tuukasyu pIfcKskngktani9) {
        ifcKskngktani9 = pIfcKskngktani9;
    }


    @Column(order = 185, label = "貸方１０勘定科目コード")
    private C_Kanjyoukmkcd ifcKskanjyoukmkcd10;


    public C_Kanjyoukmkcd getIfcKskanjyoukmkcd10() {
        return ifcKskanjyoukmkcd10;
    }


    public void setIfcKskanjyoukmkcd10(C_Kanjyoukmkcd pIfcKskanjyoukmkcd10) {
        ifcKskanjyoukmkcd10 = pIfcKskanjyoukmkcd10;
    }


    @Column(order = 186, label = "貸方１０勘定科目名")
    private String ifcKskanjyoukmknm10;


    public String getIfcKskanjyoukmknm10() {
        return ifcKskanjyoukmknm10;
    }


    public void setIfcKskanjyoukmknm10(String pIfcKskanjyoukmknm10) {
        ifcKskanjyoukmknm10 = pIfcKskanjyoukmknm10;
    }


    @Column(order = 187, label = "貸方１０金額")
    private BizCurrency ifcKskngk10;


    public BizCurrency getIfcKskngk10() {
        return ifcKskngk10;
    }


    public void setIfcKskngk10(BizCurrency pIfcKskngk10) {
        ifcKskngk10 = pIfcKskngk10;
    }


    @Column(order = 188, label = "貸方１０金額単位")
    private C_Tuukasyu ifcKskngktani10;


    public C_Tuukasyu getIfcKskngktani10() {
        return ifcKskngktani10;
    }


    public void setIfcKskngktani10(C_Tuukasyu pIfcKskngktani10) {
        ifcKskngktani10 = pIfcKskngktani10;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
