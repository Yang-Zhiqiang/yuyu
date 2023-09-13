package yuyu.def.hozen.file.csv;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_FatcahankeiiKbn;
import yuyu.def.classification.C_FatcakekKbn;
import yuyu.def.classification.C_FatcatgKbn;

/**
 * （保全）ＦＡＴＣＡ定期調査要データファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhFatcaTeikiTyousaDataFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhFatcaTeikiTyousaDataFile() {
    }

    @Column(order = 1, label = "ＦＡＴＣＡ確認処理年月日")
    @NotNull
    private String ifcFatcakaksyoriymd;

    public String getIfcFatcakaksyoriymd() {
        return ifcFatcakaksyoriymd;
    }

    public void setIfcFatcakaksyoriymd(String pIfcFatcakaksyoriymd) {
        ifcFatcakaksyoriymd = pIfcFatcakaksyoriymd;
    }

    @Column(order = 2, label = "ＦＡＴＣＡ確認処理番号")
    @NotNull
    private String ifcFatcakaksyorino;

    public String getIfcFatcakaksyorino() {
        return ifcFatcakaksyorino;
    }

    public void setIfcFatcakaksyorino(String pIfcFatcakaksyorino) {
        ifcFatcakaksyorino = pIfcFatcakaksyorino;
    }

    @Column(order = 3, label = "ＦＡＴＣＡ確認処理コード")
    @NotNull
    private C_FatcahankeiiKbn ifcFatcakaksyoricd;

    public C_FatcahankeiiKbn getIfcFatcakaksyoricd() {
        return ifcFatcakaksyoricd;
    }

    public void setIfcFatcakaksyoricd(C_FatcahankeiiKbn pIfcFatcakaksyoricd) {
        ifcFatcakaksyoricd = pIfcFatcakaksyoricd;
    }

    @Column(order = 4, label = "ＦＡＴＣＡ確認処理組織コード")
    @NotNull
    private String ifcFatcakaksyorisosikicd;

    public String getIfcFatcakaksyorisosikicd() {
        return ifcFatcakaksyorisosikicd;
    }

    public void setIfcFatcakaksyorisosikicd(String pIfcFatcakaksyorisosikicd) {
        ifcFatcakaksyorisosikicd = pIfcFatcakaksyorisosikicd;
    }

    @Column(order = 5, label = "ＦＡＴＣＡ確認対象者区分")
    @NotNull
    private C_FatcatgKbn ifcFatcakaktgkbn;

    public C_FatcatgKbn getIfcFatcakaktgkbn() {
        return ifcFatcakaktgkbn;
    }

    public void setIfcFatcakaktgkbn(C_FatcatgKbn pIfcFatcakaktgkbn) {
        ifcFatcakaktgkbn = pIfcFatcakaktgkbn;
    }

    @Column(order = 6, label = "ＦＡＴＣＡ確認結果区分")
    @NotNull
    private C_FatcakekKbn ifcFatcakakkekkakbn;

    public C_FatcakekKbn getIfcFatcakakkekkakbn() {
        return ifcFatcakakkekkakbn;
    }

    public void setIfcFatcakakkekkakbn(C_FatcakekKbn pIfcFatcakakkekkakbn) {
        ifcFatcakakkekkakbn = pIfcFatcakakkekkakbn;
    }

    @Column(order = 7, label = "ＦＡＴＣＡ確認法人業態区分")
    private String ifcFatcakakhingyoutaikbn;

    public String getIfcFatcakakhingyoutaikbn() {
        return ifcFatcakakhingyoutaikbn;
    }

    public void setIfcFatcakakhingyoutaikbn(String pIfcFatcakakhingyoutaikbn) {
        ifcFatcakakhingyoutaikbn = pIfcFatcakakhingyoutaikbn;
    }

    @Column(order = 8, label = "ＦＡＴＣＡ確認米国納税者番号")
    @NotNull
    private String ifcFatcakakbikknzsyno;

    public String getIfcFatcakakbikknzsyno() {
        return ifcFatcakakbikknzsyno;
    }

    public void setIfcFatcakakbikknzsyno(String pIfcFatcakakbikknzsyno) {
        ifcFatcakakbikknzsyno = pIfcFatcakakbikknzsyno;
    }

    @Column(order = 9, label = "ＦＡＴＣＡ確認効力終了年月日")
    private String ifcFatcakakkryksyryymd;

    public String getIfcFatcakakkryksyryymd() {
        return ifcFatcakakkryksyryymd;
    }

    public void setIfcFatcakakkryksyryymd(String pIfcFatcakakkryksyryymd) {
        ifcFatcakakkryksyryymd = pIfcFatcakakkryksyryymd;
    }

    @Column(order = 10, label = "証券番号")
    @NotNull
    private String ifcSyono;

    public String getIfcSyono() {
        return ifcSyono;
    }

    public void setIfcSyono(String pIfcSyono) {
        ifcSyono = pIfcSyono;
    }

    @Column(order = 11, label = "消滅コード")
    private String ifcSyoumetucd;

    public String getIfcSyoumetucd() {
        return ifcSyoumetucd;
    }

    public void setIfcSyoumetucd(String pIfcSyoumetucd) {
        ifcSyoumetucd = pIfcSyoumetucd;
    }

    @Column(order = 12, label = "消滅年月日")
    private String ifcSyoumetuymd;

    public String getIfcSyoumetuymd() {
        return ifcSyoumetuymd;
    }

    public void setIfcSyoumetuymd(String pIfcSyoumetuymd) {
        ifcSyoumetuymd = pIfcSyoumetuymd;
    }

    @Column(order = 13, label = "お客様番号")
    private String ifcOkyksmno;

    public String getIfcOkyksmno() {
        return ifcOkyksmno;
    }

    public void setIfcOkyksmno(String pIfcOkyksmno) {
        ifcOkyksmno = pIfcOkyksmno;
    }

    @Column(order = 14, label = "法人コード")
    private String ifcHjncd;

    public String getIfcHjncd() {
        return ifcHjncd;
    }

    public void setIfcHjncd(String pIfcHjncd) {
        ifcHjncd = pIfcHjncd;
    }

    @Column(order = 15, label = "団体コード")
    private String ifcDntcd;

    public String getIfcDntcd() {
        return ifcDntcd;
    }

    public void setIfcDntcd(String pIfcDntcd) {
        ifcDntcd = pIfcDntcd;
    }

    @Column(order = 16, label = "契約者カナ名義")
    private String ifcKykknmeigi;

    public String getIfcKykknmeigi() {
        return ifcKykknmeigi;
    }

    public void setIfcKykknmeigi(String pIfcKykknmeigi) {
        ifcKykknmeigi = pIfcKykknmeigi;
    }

    @Column(order = 17, label = "契約者漢字名義")
    private String ifcKykkjmeigi;

    public String getIfcKykkjmeigi() {
        return ifcKykkjmeigi;
    }

    public void setIfcKykkjmeigi(String pIfcKykkjmeigi) {
        ifcKykkjmeigi = pIfcKykkjmeigi;
    }

    @Column(order = 18, label = "契約者生年月日")
    private String ifcKykseiymd;

    public String getIfcKykseiymd() {
        return ifcKykseiymd;
    }

    public void setIfcKykseiymd(String pIfcKykseiymd) {
        ifcKykseiymd = pIfcKykseiymd;
    }

    @Column(order = 19, label = "法人代表者カナ名義")
    private String ifcHjndaiknmeigi;

    public String getIfcHjndaiknmeigi() {
        return ifcHjndaiknmeigi;
    }

    public void setIfcHjndaiknmeigi(String pIfcHjndaiknmeigi) {
        ifcHjndaiknmeigi = pIfcHjndaiknmeigi;
    }

    @Column(order = 20, label = "法人代表者漢字名義")
    private String ifcHjndaikjmeigi;

    public String getIfcHjndaikjmeigi() {
        return ifcHjndaikjmeigi;
    }

    public void setIfcHjndaikjmeigi(String pIfcHjndaikjmeigi) {
        ifcHjndaikjmeigi = pIfcHjndaikjmeigi;
    }

    @Column(order = 21, label = "法人代表者生年月日")
    private String ifcHjndaiseiymd;

    public String getIfcHjndaiseiymd() {
        return ifcHjndaiseiymd;
    }

    public void setIfcHjndaiseiymd(String pIfcHjndaiseiymd) {
        ifcHjndaiseiymd = pIfcHjndaiseiymd;
    }

    @Column(order = 22, label = "通信先基本地区コード")
    private String ifcTsinkihontikucd;

    public String getIfcTsinkihontikucd() {
        return ifcTsinkihontikucd;
    }

    public void setIfcTsinkihontikucd(String pIfcTsinkihontikucd) {
        ifcTsinkihontikucd = pIfcTsinkihontikucd;
    }

    @Column(order = 23, label = "通信先下位住所")
    private String ifcTsinkaiadr;

    public String getIfcTsinkaiadr() {
        return ifcTsinkaiadr;
    }

    public void setIfcTsinkaiadr(String pIfcTsinkaiadr) {
        ifcTsinkaiadr = pIfcTsinkaiadr;
    }

    @Column(order = 24, label = "通信先電話番号")
    private String ifcTsintelno;

    public String getIfcTsintelno() {
        return ifcTsintelno;
    }

    public void setIfcTsintelno(String pIfcTsintelno) {
        ifcTsintelno = pIfcTsintelno;
    }

    @Column(order = 25, label = "最終名義変更処理年月日")
    private String ifcLastmeighnksyoriymd;

    public String getIfcLastmeighnksyoriymd() {
        return ifcLastmeighnksyoriymd;
    }

    public void setIfcLastmeighnksyoriymd(String pIfcLastmeighnksyoriymd) {
        ifcLastmeighnksyoriymd = pIfcLastmeighnksyoriymd;
    }

    @Column(order = 26, label = "契約者名義変更処理年月日")
    private String ifcKykmeighnksyoriymd;

    public String getIfcKykmeighnksyoriymd() {
        return ifcKykmeighnksyoriymd;
    }

    public void setIfcKykmeighnksyoriymd(String pIfcKykmeighnksyoriymd) {
        ifcKykmeighnksyoriymd = pIfcKykmeighnksyoriymd;
    }

    @Column(order = 27, label = "抽出区分")
    private String ifcTysytkbn;

    public String getIfcTysytkbn() {
        return ifcTysytkbn;
    }

    public void setIfcTysytkbn(String pIfcTysytkbn) {
        ifcTysytkbn = pIfcTysytkbn;
    }

    @Column(order = 28, label = "キャッシュバリュー合計額")
    private String ifcCashvaluegkkeigk;

    public String getIfcCashvaluegkkeigk() {
        return ifcCashvaluegkkeigk;
    }

    public void setIfcCashvaluegkkeigk(String pIfcCashvaluegkkeigk) {
        ifcCashvaluegkkeigk = pIfcCashvaluegkkeigk;
    }

    @Column(order = 29, label = "解約返戻金")
    private String ifcKaiyakuhr;

    public String getIfcKaiyakuhr() {
        return ifcKaiyakuhr;
    }

    public void setIfcKaiyakuhr(String pIfcKaiyakuhr) {
        ifcKaiyakuhr = pIfcKaiyakuhr;
    }

    @Column(order = 30, label = "生存給付金")
    private String ifcSznkyhkn;

    public String getIfcSznkyhkn() {
        return ifcSznkyhkn;
    }

    public void setIfcSznkyhkn(String pIfcSznkyhkn) {
        ifcSznkyhkn = pIfcSznkyhkn;
    }

    @Column(order = 31, label = "配当金")
    private String ifcHaitoukin;

    public String getIfcHaitoukin() {
        return ifcHaitoukin;
    }

    public void setIfcHaitoukin(String pIfcHaitoukin) {
        ifcHaitoukin = pIfcHaitoukin;
    }

    @Column(order = 32, label = "未経過保険料")
    private String ifcMikeikap;

    public String getIfcMikeikap() {
        return ifcMikeikap;
    }

    public void setIfcMikeikap(String pIfcMikeikap) {
        ifcMikeikap = pIfcMikeikap;
    }

    @Column(order = 33, label = "ＣＶ計算不可表示")
    private String ifcCvkeisanhukahyouji;

    public String getIfcCvkeisanhukahyouji() {
        return ifcCvkeisanhukahyouji;
    }

    public void setIfcCvkeisanhukahyouji(String pIfcCvkeisanhukahyouji) {
        ifcCvkeisanhukahyouji = pIfcCvkeisanhukahyouji;
    }

    @Column(order = 34, label = "解約返戻金エラー区分")
    private String ifcKaiyakuhrerrkbn;

    public String getIfcKaiyakuhrerrkbn() {
        return ifcKaiyakuhrerrkbn;
    }

    public void setIfcKaiyakuhrerrkbn(String pIfcKaiyakuhrerrkbn) {
        ifcKaiyakuhrerrkbn = pIfcKaiyakuhrerrkbn;
    }

    @Column(order = 35, label = "生存給付金エラー区分")
    private String ifcSznkyhknerrkbn;

    public String getIfcSznkyhknerrkbn() {
        return ifcSznkyhknerrkbn;
    }

    public void setIfcSznkyhknerrkbn(String pIfcSznkyhknerrkbn) {
        ifcSznkyhknerrkbn = pIfcSznkyhknerrkbn;
    }

    @Column(order = 36, label = "配当金エラー区分")
    private String ifcHaitoukinerrkbn;

    public String getIfcHaitoukinerrkbn() {
        return ifcHaitoukinerrkbn;
    }

    public void setIfcHaitoukinerrkbn(String pIfcHaitoukinerrkbn) {
        ifcHaitoukinerrkbn = pIfcHaitoukinerrkbn;
    }

    @Column(order = 37, label = "未経過保険料エラー区分")
    private String ifcMikeikaperrkbn;

    public String getIfcMikeikaperrkbn() {
        return ifcMikeikaperrkbn;
    }

    public void setIfcMikeikaperrkbn(String pIfcMikeikaperrkbn) {
        ifcMikeikaperrkbn = pIfcMikeikaperrkbn;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
