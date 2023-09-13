package yuyu.def.hozen.file.csv;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_AeoiHoujinSyuruiKbn;
import yuyu.def.classification.C_AeoiKekkaKbn;
import yuyu.def.classification.C_AeoiSyoriKbn;
import yuyu.def.classification.C_AeoiTaisyousyaKbn;

/**
 * （保全）ＡＥＯＩモニタリング契約データファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhAeoiMonitorKykDataFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhAeoiMonitorKykDataFile() {
    }

    @Column(order = 1, label = "ＡＥＯＩ確認処理年月日")
    @NotNull
    private BizDate ifcAeoikaksyoriymd;

    public BizDate getIfcAeoikaksyoriymd() {
        return ifcAeoikaksyoriymd;
    }

    public void setIfcAeoikaksyoriymd(BizDate pIfcAeoikaksyoriymd) {
        ifcAeoikaksyoriymd = pIfcAeoikaksyoriymd;
    }

    @Column(order = 2, label = "ＡＥＯＩ確認処理番号")
    @NotNull
    private Integer ifcAeoikaksyorino;

    public Integer getIfcAeoikaksyorino() {
        return ifcAeoikaksyorino;
    }

    public void setIfcAeoikaksyorino(Integer pIfcAeoikaksyorino) {
        ifcAeoikaksyorino = pIfcAeoikaksyorino;
    }

    @Column(order = 3, label = "ＡＥＯＩ確認処理コード")
    @NotNull
    private C_AeoiSyoriKbn ifcAeoikaksyoricd;

    public C_AeoiSyoriKbn getIfcAeoikaksyoricd() {
        return ifcAeoikaksyoricd;
    }

    public void setIfcAeoikaksyoricd(C_AeoiSyoriKbn pIfcAeoikaksyoricd) {
        ifcAeoikaksyoricd = pIfcAeoikaksyoricd;
    }

    @Column(order = 4, label = "ＡＥＯＩ確認処理組織コード")
    @NotNull
    private String ifcAeoikaksyorisosikicd;

    public String getIfcAeoikaksyorisosikicd() {
        return ifcAeoikaksyorisosikicd;
    }

    public void setIfcAeoikaksyorisosikicd(String pIfcAeoikaksyorisosikicd) {
        ifcAeoikaksyorisosikicd = pIfcAeoikaksyorisosikicd;
    }

    @Column(order = 5, label = "ＡＥＯＩ確認対象者区分")
    @NotNull
    private C_AeoiTaisyousyaKbn ifcAeoikaktgkbn;

    public C_AeoiTaisyousyaKbn getIfcAeoikaktgkbn() {
        return ifcAeoikaktgkbn;
    }

    public void setIfcAeoikaktgkbn(C_AeoiTaisyousyaKbn pIfcAeoikaktgkbn) {
        ifcAeoikaktgkbn = pIfcAeoikaktgkbn;
    }

    @Column(order = 6, label = "ＡＥＯＩ確認結果区分")
    @NotNull
    private C_AeoiKekkaKbn ifcAeoikakkekkakbn;

    public C_AeoiKekkaKbn getIfcAeoikakkekkakbn() {
        return ifcAeoikakkekkakbn;
    }

    public void setIfcAeoikakkekkakbn(C_AeoiKekkaKbn pIfcAeoikakkekkakbn) {
        ifcAeoikakkekkakbn = pIfcAeoikakkekkakbn;
    }

    @Column(order = 7, label = "ＡＥＯＩ確認法人種類区分")
    @NotNull
    private C_AeoiHoujinSyuruiKbn ifcAeoikakhinsyuruikbn;

    public C_AeoiHoujinSyuruiKbn getIfcAeoikakhinsyuruikbn() {
        return ifcAeoikakhinsyuruikbn;
    }

    public void setIfcAeoikakhinsyuruikbn(C_AeoiHoujinSyuruiKbn pIfcAeoikakhinsyuruikbn) {
        ifcAeoikakhinsyuruikbn = pIfcAeoikakhinsyuruikbn;
    }

    @Column(order = 8, label = "ＡＥＯＩ確認効力開始年月日")
    @NotNull
    private BizDate ifcAeoikakkrykstymd;

    public BizDate getIfcAeoikakkrykstymd() {
        return ifcAeoikakkrykstymd;
    }

    public void setIfcAeoikakkrykstymd(BizDate pIfcAeoikakkrykstymd) {
        ifcAeoikakkrykstymd = pIfcAeoikakkrykstymd;
    }

    @Column(order = 9, label = "ＡＥＯＩ確認効力終了年月日")
    private BizDate ifcAeoikakkryksyryymd;

    public BizDate getIfcAeoikakkryksyryymd() {
        return ifcAeoikakkryksyryymd;
    }

    public void setIfcAeoikakkryksyryymd(BizDate pIfcAeoikakkryksyryymd) {
        ifcAeoikakkryksyryymd = pIfcAeoikakkryksyryymd;
    }

    @Column(order = 10, label = "ファイル区分")
    private String ifcFilekbn;

    public String getIfcFilekbn() {
        return ifcFilekbn;
    }

    public void setIfcFilekbn(String pIfcFilekbn) {
        ifcFilekbn = pIfcFilekbn;
    }

    @Column(order = 11, label = "証券番号")
    @NotNull
    private String ifcSyono;

    public String getIfcSyono() {
        return ifcSyono;
    }

    public void setIfcSyono(String pIfcSyono) {
        ifcSyono = pIfcSyono;
    }

    @Column(order = 12, label = "消滅コード")
    private String ifcSyoumetucd;

    public String getIfcSyoumetucd() {
        return ifcSyoumetucd;
    }

    public void setIfcSyoumetucd(String pIfcSyoumetucd) {
        ifcSyoumetucd = pIfcSyoumetucd;
    }

    @Column(order = 13, label = "消滅年月日")
    private String ifcSyoumetuymd;

    public String getIfcSyoumetuymd() {
        return ifcSyoumetuymd;
    }

    public void setIfcSyoumetuymd(String pIfcSyoumetuymd) {
        ifcSyoumetuymd = pIfcSyoumetuymd;
    }

    @Column(order = 14, label = "お客様番号")
    private String ifcOkyksmno;

    public String getIfcOkyksmno() {
        return ifcOkyksmno;
    }

    public void setIfcOkyksmno(String pIfcOkyksmno) {
        ifcOkyksmno = pIfcOkyksmno;
    }

    @Column(order = 15, label = "法人コード")
    private String ifcHjncd;

    public String getIfcHjncd() {
        return ifcHjncd;
    }

    public void setIfcHjncd(String pIfcHjncd) {
        ifcHjncd = pIfcHjncd;
    }

    @Column(order = 16, label = "団体コード")
    private String ifcDntcd;

    public String getIfcDntcd() {
        return ifcDntcd;
    }

    public void setIfcDntcd(String pIfcDntcd) {
        ifcDntcd = pIfcDntcd;
    }

    @Column(order = 17, label = "契約者カナ名義")
    private String ifcKykknmeigi;

    public String getIfcKykknmeigi() {
        return ifcKykknmeigi;
    }

    public void setIfcKykknmeigi(String pIfcKykknmeigi) {
        ifcKykknmeigi = pIfcKykknmeigi;
    }

    @Column(order = 18, label = "契約者漢字名義")
    private String ifcKykkjmeigi;

    public String getIfcKykkjmeigi() {
        return ifcKykkjmeigi;
    }

    public void setIfcKykkjmeigi(String pIfcKykkjmeigi) {
        ifcKykkjmeigi = pIfcKykkjmeigi;
    }

    @Column(order = 19, label = "契約者生年月日")
    private String ifcKykseiymd;

    public String getIfcKykseiymd() {
        return ifcKykseiymd;
    }

    public void setIfcKykseiymd(String pIfcKykseiymd) {
        ifcKykseiymd = pIfcKykseiymd;
    }

    @Column(order = 20, label = "法人代表者カナ名義")
    private String ifcHjndaiknmeigi;

    public String getIfcHjndaiknmeigi() {
        return ifcHjndaiknmeigi;
    }

    public void setIfcHjndaiknmeigi(String pIfcHjndaiknmeigi) {
        ifcHjndaiknmeigi = pIfcHjndaiknmeigi;
    }

    @Column(order = 21, label = "法人代表者漢字名義")
    private String ifcHjndaikjmeigi;

    public String getIfcHjndaikjmeigi() {
        return ifcHjndaikjmeigi;
    }

    public void setIfcHjndaikjmeigi(String pIfcHjndaikjmeigi) {
        ifcHjndaikjmeigi = pIfcHjndaikjmeigi;
    }

    @Column(order = 22, label = "法人代表者生年月日")
    private String ifcHjndaiseiymd;

    public String getIfcHjndaiseiymd() {
        return ifcHjndaiseiymd;
    }

    public void setIfcHjndaiseiymd(String pIfcHjndaiseiymd) {
        ifcHjndaiseiymd = pIfcHjndaiseiymd;
    }

    @Column(order = 23, label = "通信先基本地区コード")
    private String ifcTsinkihontikucd;

    public String getIfcTsinkihontikucd() {
        return ifcTsinkihontikucd;
    }

    public void setIfcTsinkihontikucd(String pIfcTsinkihontikucd) {
        ifcTsinkihontikucd = pIfcTsinkihontikucd;
    }

    @Column(order = 24, label = "通信先下位住所")
    private String ifcTsinkaiadr;

    public String getIfcTsinkaiadr() {
        return ifcTsinkaiadr;
    }

    public void setIfcTsinkaiadr(String pIfcTsinkaiadr) {
        ifcTsinkaiadr = pIfcTsinkaiadr;
    }

    @Column(order = 25, label = "通信先電話番号")
    private String ifcTsintelno;

    public String getIfcTsintelno() {
        return ifcTsintelno;
    }

    public void setIfcTsintelno(String pIfcTsintelno) {
        ifcTsintelno = pIfcTsintelno;
    }

    @Column(order = 26, label = "最終名義変更処理年月日")
    private String ifcLastmeighnksyoriymd;

    public String getIfcLastmeighnksyoriymd() {
        return ifcLastmeighnksyoriymd;
    }

    public void setIfcLastmeighnksyoriymd(String pIfcLastmeighnksyoriymd) {
        ifcLastmeighnksyoriymd = pIfcLastmeighnksyoriymd;
    }

    @Column(order = 27, label = "契約者名義変更処理年月日")
    private String ifcKykmeighnksyoriymd;

    public String getIfcKykmeighnksyoriymd() {
        return ifcKykmeighnksyoriymd;
    }

    public void setIfcKykmeighnksyoriymd(String pIfcKykmeighnksyoriymd) {
        ifcKykmeighnksyoriymd = pIfcKykmeighnksyoriymd;
    }

    @Column(order = 28, label = "抽出区分")
    private String ifcTysytkbn;

    public String getIfcTysytkbn() {
        return ifcTysytkbn;
    }

    public void setIfcTysytkbn(String pIfcTysytkbn) {
        ifcTysytkbn = pIfcTysytkbn;
    }

    @Column(order = 29, label = "年金消滅コード")
    private String ifcNenkinsyoumetucd;

    public String getIfcNenkinsyoumetucd() {
        return ifcNenkinsyoumetucd;
    }

    public void setIfcNenkinsyoumetucd(String pIfcNenkinsyoumetucd) {
        ifcNenkinsyoumetucd = pIfcNenkinsyoumetucd;
    }

    @Column(order = 30, label = "年金消滅年月日")
    private BizDate ifcNenkinsyoumetuymd;

    public BizDate getIfcNenkinsyoumetuymd() {
        return ifcNenkinsyoumetuymd;
    }

    public void setIfcNenkinsyoumetuymd(BizDate pIfcNenkinsyoumetuymd) {
        ifcNenkinsyoumetuymd = pIfcNenkinsyoumetuymd;
    }

    @Column(order = 31, label = "特約有表示")
    private String ifcTkykarihyj;

    public String getIfcTkykarihyj() {
        return ifcTkykarihyj;
    }

    public void setIfcTkykarihyj(String pIfcTkykarihyj) {
        ifcTkykarihyj = pIfcTkykarihyj;
    }

    @Column(order = 32, label = "変額年金特殊抽出表示")
    private String ifcHengknktksytysythyj;

    public String getIfcHengknktksytysythyj() {
        return ifcHengknktksytysythyj;
    }

    public void setIfcHengknktksytysythyj(String pIfcHengknktksytysythyj) {
        ifcHengknktksytysythyj = pIfcHengknktksytysythyj;
    }

    @Column(order = 33, label = "年金支払特約表示")
    private String ifcNkshrtkykhyj;

    public String getIfcNkshrtkykhyj() {
        return ifcNkshrtkykhyj;
    }

    public void setIfcNkshrtkykhyj(String pIfcNkshrtkykhyj) {
        ifcNkshrtkykhyj = pIfcNkshrtkykhyj;
    }

    @Column(order = 34, label = "予備")
    private String ifcYobi01x01;

    public String getIfcYobi01x01() {
        return ifcYobi01x01;
    }

    public void setIfcYobi01x01(String pIfcYobi01x01) {
        ifcYobi01x01 = pIfcYobi01x01;
    }

    @Column(order = 35, label = "予備")
    private String ifcYobi01x02;

    public String getIfcYobi01x02() {
        return ifcYobi01x02;
    }

    public void setIfcYobi01x02(String pIfcYobi01x02) {
        ifcYobi01x02 = pIfcYobi01x02;
    }

    @Column(order = 36, label = "予備")
    private String ifcYobi01x03;

    public String getIfcYobi01x03() {
        return ifcYobi01x03;
    }

    public void setIfcYobi01x03(String pIfcYobi01x03) {
        ifcYobi01x03 = pIfcYobi01x03;
    }

    @Column(order = 37, label = "予備")
    private String ifcYobi01x04;

    public String getIfcYobi01x04() {
        return ifcYobi01x04;
    }

    public void setIfcYobi01x04(String pIfcYobi01x04) {
        ifcYobi01x04 = pIfcYobi01x04;
    }

    @Column(order = 38, label = "予備")
    private String ifcYobi01x05;

    public String getIfcYobi01x05() {
        return ifcYobi01x05;
    }

    public void setIfcYobi01x05(String pIfcYobi01x05) {
        ifcYobi01x05 = pIfcYobi01x05;
    }

    @Column(order = 39, label = "予備")
    private String ifcYobi01x06;

    public String getIfcYobi01x06() {
        return ifcYobi01x06;
    }

    public void setIfcYobi01x06(String pIfcYobi01x06) {
        ifcYobi01x06 = pIfcYobi01x06;
    }

    @Column(order = 40, label = "予備")
    private String ifcYobi02;

    public String getIfcYobi02() {
        return ifcYobi02;
    }

    public void setIfcYobi02(String pIfcYobi02) {
        ifcYobi02 = pIfcYobi02;
    }

    @Column(order = 41, label = "据置満期受取人区分")
    private String ifcSueokimnkuktkbn;

    public String getIfcSueokimnkuktkbn() {
        return ifcSueokimnkuktkbn;
    }

    public void setIfcSueokimnkuktkbn(String pIfcSueokimnkuktkbn) {
        ifcSueokimnkuktkbn = pIfcSueokimnkuktkbn;
    }

    @Column(order = 42, label = "据置特定名義表示")
    private String ifcSueokitokmeigihyj;

    public String getIfcSueokitokmeigihyj() {
        return ifcSueokitokmeigihyj;
    }

    public void setIfcSueokitokmeigihyj(String pIfcSueokitokmeigihyj) {
        ifcSueokitokmeigihyj = pIfcSueokitokmeigihyj;
    }

    @Column(order = 43, label = "据置複数名義表示")
    private String ifcSueokihukusuumeigihyj;

    public String getIfcSueokihukusuumeigihyj() {
        return ifcSueokihukusuumeigihyj;
    }

    public void setIfcSueokihukusuumeigihyj(String pIfcSueokihukusuumeigihyj) {
        ifcSueokihukusuumeigihyj = pIfcSueokihukusuumeigihyj;
    }

    @Column(order = 44, label = "据置備金表示")
    private String ifcSueokibikinhyj;

    public String getIfcSueokibikinhyj() {
        return ifcSueokibikinhyj;
    }

    public void setIfcSueokibikinhyj(String pIfcSueokibikinhyj) {
        ifcSueokibikinhyj = pIfcSueokibikinhyj;
    }

    @Column(order = 45, label = "予備")
    private String ifcYobi03x26;

    public String getIfcYobi03x26() {
        return ifcYobi03x26;
    }

    public void setIfcYobi03x26(String pIfcYobi03x26) {
        ifcYobi03x26 = pIfcYobi03x26;
    }

    @Column(order = 46, label = "キャッシュバリュー合計額")
    private String ifcCashvaluegkkeigk;

    public String getIfcCashvaluegkkeigk() {
        return ifcCashvaluegkkeigk;
    }

    public void setIfcCashvaluegkkeigk(String pIfcCashvaluegkkeigk) {
        ifcCashvaluegkkeigk = pIfcCashvaluegkkeigk;
    }

    @Column(order = 47, label = "解約返戻金")
    private String ifcKaiyakuhr;

    public String getIfcKaiyakuhr() {
        return ifcKaiyakuhr;
    }

    public void setIfcKaiyakuhr(String pIfcKaiyakuhr) {
        ifcKaiyakuhr = pIfcKaiyakuhr;
    }

    @Column(order = 48, label = "生存給付金")
    private String ifcSznkyhkn;

    public String getIfcSznkyhkn() {
        return ifcSznkyhkn;
    }

    public void setIfcSznkyhkn(String pIfcSznkyhkn) {
        ifcSznkyhkn = pIfcSznkyhkn;
    }

    @Column(order = 49, label = "配当金")
    private String ifcHaitoukin;

    public String getIfcHaitoukin() {
        return ifcHaitoukin;
    }

    public void setIfcHaitoukin(String pIfcHaitoukin) {
        ifcHaitoukin = pIfcHaitoukin;
    }

    @Column(order = 50, label = "未経過保険料")
    private String ifcMikeikap;

    public String getIfcMikeikap() {
        return ifcMikeikap;
    }

    public void setIfcMikeikap(String pIfcMikeikap) {
        ifcMikeikap = pIfcMikeikap;
    }

    @Column(order = 51, label = "年金用責任準備金")
    private BizCurrency ifcNkyousknnjynbkn;

    public BizCurrency getIfcNkyousknnjynbkn() {
        return ifcNkyousknnjynbkn;
    }

    public void setIfcNkyousknnjynbkn(BizCurrency pIfcNkyousknnjynbkn) {
        ifcNkyousknnjynbkn = pIfcNkyousknnjynbkn;
    }

    @Column(order = 52, label = "年金用支払備金")
    private BizCurrency ifcNkyoushrbkn;

    public BizCurrency getIfcNkyoushrbkn() {
        return ifcNkyoushrbkn;
    }

    public void setIfcNkyoushrbkn(BizCurrency pIfcNkyoushrbkn) {
        ifcNkyoushrbkn = pIfcNkyoushrbkn;
    }

    @Column(order = 53, label = "年金用一括払年金額")
    private BizCurrency ifcNkyouiktnkgk;

    public BizCurrency getIfcNkyouiktnkgk() {
        return ifcNkyouiktnkgk;
    }

    public void setIfcNkyouiktnkgk(BizCurrency pIfcNkyouiktnkgk) {
        ifcNkyouiktnkgk = pIfcNkyouiktnkgk;
    }

    @Column(order = 54, label = "年金用配当準備金")
    private BizCurrency ifcNkyouhaitoujynbkn;

    public BizCurrency getIfcNkyouhaitoujynbkn() {
        return ifcNkyouhaitoujynbkn;
    }

    public void setIfcNkyouhaitoujynbkn(BizCurrency pIfcNkyouhaitoujynbkn) {
        ifcNkyouhaitoujynbkn = pIfcNkyouhaitoujynbkn;
    }

    @Column(order = 55, label = "年金用解約返戻金")
    private BizCurrency ifcNkyoukaiyakuhr;

    public BizCurrency getIfcNkyoukaiyakuhr() {
        return ifcNkyoukaiyakuhr;
    }

    public void setIfcNkyoukaiyakuhr(BizCurrency pIfcNkyoukaiyakuhr) {
        ifcNkyoukaiyakuhr = pIfcNkyoukaiyakuhr;
    }

    @Column(order = 56, label = "据置用責任準備金")
    private BizCurrency ifcSueokiyousknnjynbkn;

    public BizCurrency getIfcSueokiyousknnjynbkn() {
        return ifcSueokiyousknnjynbkn;
    }

    public void setIfcSueokiyousknnjynbkn(BizCurrency pIfcSueokiyousknnjynbkn) {
        ifcSueokiyousknnjynbkn = pIfcSueokiyousknnjynbkn;
    }

    @Column(order = 57, label = "予備")
    private String ifcYobi04x01;

    public String getIfcYobi04x01() {
        return ifcYobi04x01;
    }

    public void setIfcYobi04x01(String pIfcYobi04x01) {
        ifcYobi04x01 = pIfcYobi04x01;
    }

    @Column(order = 58, label = "予備")
    private String ifcYobi04x02;

    public String getIfcYobi04x02() {
        return ifcYobi04x02;
    }

    public void setIfcYobi04x02(String pIfcYobi04x02) {
        ifcYobi04x02 = pIfcYobi04x02;
    }

    @Column(order = 59, label = "予備")
    private String ifcYobi04x03;

    public String getIfcYobi04x03() {
        return ifcYobi04x03;
    }

    public void setIfcYobi04x03(String pIfcYobi04x03) {
        ifcYobi04x03 = pIfcYobi04x03;
    }

    @Column(order = 60, label = "予備")
    private String ifcYobi04x04;

    public String getIfcYobi04x04() {
        return ifcYobi04x04;
    }

    public void setIfcYobi04x04(String pIfcYobi04x04) {
        ifcYobi04x04 = pIfcYobi04x04;
    }

    @Column(order = 61, label = "予備")
    private String ifcYobi04x05;

    public String getIfcYobi04x05() {
        return ifcYobi04x05;
    }

    public void setIfcYobi04x05(String pIfcYobi04x05) {
        ifcYobi04x05 = pIfcYobi04x05;
    }

    @Column(order = 62, label = "予備")
    private String ifcYobi04x06;

    public String getIfcYobi04x06() {
        return ifcYobi04x06;
    }

    public void setIfcYobi04x06(String pIfcYobi04x06) {
        ifcYobi04x06 = pIfcYobi04x06;
    }

    @Column(order = 63, label = "予備")
    private String ifcYobi04x07;

    public String getIfcYobi04x07() {
        return ifcYobi04x07;
    }

    public void setIfcYobi04x07(String pIfcYobi04x07) {
        ifcYobi04x07 = pIfcYobi04x07;
    }

    @Column(order = 64, label = "予備")
    private String ifcYobi04x08;

    public String getIfcYobi04x08() {
        return ifcYobi04x08;
    }

    public void setIfcYobi04x08(String pIfcYobi04x08) {
        ifcYobi04x08 = pIfcYobi04x08;
    }

    @Column(order = 65, label = "予備")
    private String ifcYobi04x09;

    public String getIfcYobi04x09() {
        return ifcYobi04x09;
    }

    public void setIfcYobi04x09(String pIfcYobi04x09) {
        ifcYobi04x09 = pIfcYobi04x09;
    }

    @Column(order = 66, label = "判定用案内不要理由区分")
    private String ifcHntiannaihuyouriyuukbn;

    public String getIfcHntiannaihuyouriyuukbn() {
        return ifcHntiannaihuyouriyuukbn;
    }

    public void setIfcHntiannaihuyouriyuukbn(String pIfcHntiannaihuyouriyuukbn) {
        ifcHntiannaihuyouriyuukbn = pIfcHntiannaihuyouriyuukbn;
    }

    @Column(order = 67, label = "データ管理番号")
    private String ifcDatakanrino;

    public String getIfcDatakanrino() {
        return ifcDatakanrino;
    }

    public void setIfcDatakanrino(String pIfcDatakanrino) {
        ifcDatakanrino = pIfcDatakanrino;
    }

    @Column(order = 68, label = "解約返戻金相当額ＵＬＦ表示")
    private String ifcKaiyakuhrstgkulfhyouji;

    public String getIfcKaiyakuhrstgkulfhyouji() {
        return ifcKaiyakuhrstgkulfhyouji;
    }

    public void setIfcKaiyakuhrstgkulfhyouji(String pIfcKaiyakuhrstgkulfhyouji) {
        ifcKaiyakuhrstgkulfhyouji = pIfcKaiyakuhrstgkulfhyouji;
    }

    @Column(order = 69, label = "備金時効Ｆ表示")
    private String ifcBknjikoufhyoji;

    public String getIfcBknjikoufhyoji() {
        return ifcBknjikoufhyoji;
    }

    public void setIfcBknjikoufhyoji(String pIfcBknjikoufhyoji) {
        ifcBknjikoufhyoji = pIfcBknjikoufhyoji;
    }

    @Column(order = 70, label = "備金コード")
    private String ifcBkncd;

    public String getIfcBkncd() {
        return ifcBkncd;
    }

    public void setIfcBkncd(String pIfcBkncd) {
        ifcBkncd = pIfcBkncd;
    }

    @Column(order = 71, label = "失効解約返戻金備金時効Ｆ表示")
    private String ifcSkKaiyakuhrbknjkufhyoji;

    public String getIfcSkKaiyakuhrbknjkufhyoji() {
        return ifcSkKaiyakuhrbknjkufhyoji;
    }

    public void setIfcSkKaiyakuhrbknjkufhyoji(String pIfcSkKaiyakuhrbknjkufhyoji) {
        ifcSkKaiyakuhrbknjkufhyoji = pIfcSkKaiyakuhrbknjkufhyoji;
    }

    @Column(order = 72, label = "生存給付金利息等捕捉用Ｆ表示")
    private String ifcSznkyhknrskthskyfhyj;

    public String getIfcSznkyhknrskthskyfhyj() {
        return ifcSznkyhknrskthskyfhyj;
    }

    public void setIfcSznkyhknrskthskyfhyj(String pIfcSznkyhknrskthskyfhyj) {
        ifcSznkyhknrskthskyfhyj = pIfcSznkyhknrskthskyfhyj;
    }

    @Column(order = 73, label = "生存給付金備金用ＵＬＦ表示")
    private String ifcSznkyhknbknyulfhyoji;

    public String getIfcSznkyhknbknyulfhyoji() {
        return ifcSznkyhknbknyulfhyoji;
    }

    public void setIfcSznkyhknbknyulfhyoji(String pIfcSznkyhknbknyulfhyoji) {
        ifcSznkyhknbknyulfhyoji = pIfcSznkyhknbknyulfhyoji;
    }

    @Column(order = 74, label = "棚卸決算用積立ＤＵＬＦ表示")
    private String ifcTnrsksnytmttdulfhyoji;

    public String getIfcTnrsksnytmttdulfhyoji() {
        return ifcTnrsksnytmttdulfhyoji;
    }

    public void setIfcTnrsksnytmttdulfhyoji(String pIfcTnrsksnytmttdulfhyoji) {
        ifcTnrsksnytmttdulfhyoji = pIfcTnrsksnytmttdulfhyoji;
    }

    @Column(order = 75, label = "棚卸決算用相殺ＤＵＬＦ表示")
    private String ifcTnrsksnysustdulfhyoji;

    public String getIfcTnrsksnysustdulfhyoji() {
        return ifcTnrsksnysustdulfhyoji;
    }

    public void setIfcTnrsksnysustdulfhyoji(String pIfcTnrsksnysustdulfhyoji) {
        ifcTnrsksnysustdulfhyoji = pIfcTnrsksnysustdulfhyoji;
    }

    @Column(order = 76, label = "棚卸決算用備金分精算ＤＦ表示")
    private String ifcTnrsksnbknbnsndfhyj;

    public String getIfcTnrsksnbknbnsndfhyj() {
        return ifcTnrsksnbknbnsndfhyj;
    }

    public void setIfcTnrsksnbknbnsndfhyj(String pIfcTnrsksnbknbnsndfhyj) {
        ifcTnrsksnbknbnsndfhyj = pIfcTnrsksnbknbnsndfhyj;
    }

    @Column(order = 77, label = "棚卸決算用暫定ＤＵＬＦ表示")
    private String ifcTnrsksnyzntidulfhyoji;

    public String getIfcTnrsksnyzntidulfhyoji() {
        return ifcTnrsksnyzntidulfhyoji;
    }

    public void setIfcTnrsksnyzntidulfhyoji(String pIfcTnrsksnyzntidulfhyoji) {
        ifcTnrsksnyzntidulfhyoji = pIfcTnrsksnyzntidulfhyoji;
    }

    @Column(order = 78, label = "棚卸決算用仮割当ＤＵＬＦ表示")
    private String ifcTnrsksnykrwratdulfhyoji;

    public String getIfcTnrsksnykrwratdulfhyoji() {
        return ifcTnrsksnykrwratdulfhyoji;
    }

    public void setIfcTnrsksnykrwratdulfhyoji(String pIfcTnrsksnykrwratdulfhyoji) {
        ifcTnrsksnykrwratdulfhyoji = pIfcTnrsksnykrwratdulfhyoji;
    }

    @Column(order = 79, label = "保有明細Ｆ表示")
    private String ifcHyumeisaifhyoji;

    public String getIfcHyumeisaifhyoji() {
        return ifcHyumeisaifhyoji;
    }

    public void setIfcHyumeisaifhyoji(String pIfcHyumeisaifhyoji) {
        ifcHyumeisaifhyoji = pIfcHyumeisaifhyoji;
    }

    @Column(order = 80, label = "未経過Ｐ備金時効Ｆ表示")
    private String ifcMikeikapbknjkufhyoji;

    public String getIfcMikeikapbknjkufhyoji() {
        return ifcMikeikapbknjkufhyoji;
    }

    public void setIfcMikeikapbknjkufhyoji(String pIfcMikeikapbknjkufhyoji) {
        ifcMikeikapbknjkufhyoji = pIfcMikeikapbknjkufhyoji;
    }

    @Column(order = 81, label = "ＯＬ失効未経過Ｐ返金Ｆ表示")
    private String ifcOlskmkkphknfhyj;

    public String getIfcOlskmkkphknfhyj() {
        return ifcOlskmkkphknfhyj;
    }

    public void setIfcOlskmkkphknfhyj(String pIfcOlskmkkphknfhyj) {
        ifcOlskmkkphknfhyj = pIfcOlskmkkphknfhyj;
    }

    @Column(order = 82, label = "年金用決算保有統計ＶＦ表示")
    private String ifcNkyouksnhytukivfhyj;

    public String getIfcNkyouksnhytukivfhyj() {
        return ifcNkyouksnhytukivfhyj;
    }

    public void setIfcNkyouksnhytukivfhyj(String pIfcNkyouksnhytukivfhyj) {
        ifcNkyouksnhytukivfhyj = pIfcNkyouksnhytukivfhyj;
    }

    @Column(order = 83, label = "年金用備金時効Ｆ表示")
    private String ifcNkyoubknjkufhyj;

    public String getIfcNkyoubknjkufhyj() {
        return ifcNkyoubknjkufhyj;
    }

    public void setIfcNkyoubknjkufhyj(String pIfcNkyoubknjkufhyj) {
        ifcNkyoubknjkufhyj = pIfcNkyoubknjkufhyj;
    }

    @Column(order = 84, label = "年金用一括払ＵＬＦ表示")
    private String ifcNkyouiktulfhyj;

    public String getIfcNkyouiktulfhyj() {
        return ifcNkyouiktulfhyj;
    }

    public void setIfcNkyouiktulfhyj(String pIfcNkyouiktulfhyj) {
        ifcNkyouiktulfhyj = pIfcNkyouiktulfhyj;
    }

    @Column(order = 85, label = "年金用配当準備金保有Ｆ表示")
    private String ifcNkyouhaitoujynbknhyufhyj;

    public String getIfcNkyouhaitoujynbknhyufhyj() {
        return ifcNkyouhaitoujynbknhyufhyj;
    }

    public void setIfcNkyouhaitoujynbknhyufhyj(String pIfcNkyouhaitoujynbknhyufhyj) {
        ifcNkyouhaitoujynbknhyufhyj = pIfcNkyouhaitoujynbknhyufhyj;
    }

    @Column(order = 86, label = "年金用解約返戻金ＵＬＦ表示")
    private String ifcNkyoukaiyakuhrulfhyj;

    public String getIfcNkyoukaiyakuhrulfhyj() {
        return ifcNkyoukaiyakuhrulfhyj;
    }

    public void setIfcNkyoukaiyakuhrulfhyj(String pIfcNkyoukaiyakuhrulfhyj) {
        ifcNkyoukaiyakuhrulfhyj = pIfcNkyoukaiyakuhrulfhyj;
    }

    @Column(order = 87, label = "据置用決算リスト作成Ｆ表示")
    private String ifcSueokiyouksnlistsksfhyj;

    public String getIfcSueokiyouksnlistsksfhyj() {
        return ifcSueokiyouksnlistsksfhyj;
    }

    public void setIfcSueokiyouksnlistsksfhyj(String pIfcSueokiyouksnlistsksfhyj) {
        ifcSueokiyouksnlistsksfhyj = pIfcSueokiyouksnlistsksfhyj;
    }

    @Column(order = 88, label = "予備")
    private String ifcYobi05x01;

    public String getIfcYobi05x01() {
        return ifcYobi05x01;
    }

    public void setIfcYobi05x01(String pIfcYobi05x01) {
        ifcYobi05x01 = pIfcYobi05x01;
    }

    @Column(order = 89, label = "予備")
    private String ifcYobi05x02;

    public String getIfcYobi05x02() {
        return ifcYobi05x02;
    }

    public void setIfcYobi05x02(String pIfcYobi05x02) {
        ifcYobi05x02 = pIfcYobi05x02;
    }

    @Column(order = 90, label = "ＣＶ計算不可表示")
    private String ifcCvkeisanhukahyouji;

    public String getIfcCvkeisanhukahyouji() {
        return ifcCvkeisanhukahyouji;
    }

    public void setIfcCvkeisanhukahyouji(String pIfcCvkeisanhukahyouji) {
        ifcCvkeisanhukahyouji = pIfcCvkeisanhukahyouji;
    }

    @Column(order = 91, label = "解約返戻金エラー区分")
    private String ifcKaiyakuhrerrkbn;

    public String getIfcKaiyakuhrerrkbn() {
        return ifcKaiyakuhrerrkbn;
    }

    public void setIfcKaiyakuhrerrkbn(String pIfcKaiyakuhrerrkbn) {
        ifcKaiyakuhrerrkbn = pIfcKaiyakuhrerrkbn;
    }

    @Column(order = 92, label = "生存給付金エラー区分")
    private String ifcSznkyhknerrkbn;

    public String getIfcSznkyhknerrkbn() {
        return ifcSznkyhknerrkbn;
    }

    public void setIfcSznkyhknerrkbn(String pIfcSznkyhknerrkbn) {
        ifcSznkyhknerrkbn = pIfcSznkyhknerrkbn;
    }

    @Column(order = 93, label = "配当金エラー区分")
    private String ifcHaitoukinerrkbn;

    public String getIfcHaitoukinerrkbn() {
        return ifcHaitoukinerrkbn;
    }

    public void setIfcHaitoukinerrkbn(String pIfcHaitoukinerrkbn) {
        ifcHaitoukinerrkbn = pIfcHaitoukinerrkbn;
    }

    @Column(order = 94, label = "未経過保険料エラー区分")
    private String ifcMikeikaperrkbn;

    public String getIfcMikeikaperrkbn() {
        return ifcMikeikaperrkbn;
    }

    public void setIfcMikeikaperrkbn(String pIfcMikeikaperrkbn) {
        ifcMikeikaperrkbn = pIfcMikeikaperrkbn;
    }

    @Column(order = 95, label = "案件管理番号")
    private String ifcAnkenkanrino6;

    public String getIfcAnkenkanrino6() {
        return ifcAnkenkanrino6;
    }

    public void setIfcAnkenkanrino6(String pIfcAnkenkanrino6) {
        ifcAnkenkanrino6 = pIfcAnkenkanrino6;
    }

    @Column(order = 96, label = "案件管理番号毎ＣＶ額")
    private BizCurrency ifcAnkenkanrinomaicvgk;

    public BizCurrency getIfcAnkenkanrinomaicvgk() {
        return ifcAnkenkanrinomaicvgk;
    }

    public void setIfcAnkenkanrinomaicvgk(BizCurrency pIfcAnkenkanrinomaicvgk) {
        ifcAnkenkanrinomaicvgk = pIfcAnkenkanrinomaicvgk;
    }

    @Column(order = 97, label = "ＣＶ額超過区分")
    private String ifcCvgktyoukakbn;

    public String getIfcCvgktyoukakbn() {
        return ifcCvgktyoukakbn;
    }

    public void setIfcCvgktyoukakbn(String pIfcCvgktyoukakbn) {
        ifcCvgktyoukakbn = pIfcCvgktyoukakbn;
    }

    @Column(order = 98, label = "契約者漢字名義複数表示")
    private String ifcKykkjmeigihukusuuhyj;

    public String getIfcKykkjmeigihukusuuhyj() {
        return ifcKykkjmeigihukusuuhyj;
    }

    public void setIfcKykkjmeigihukusuuhyj(String pIfcKykkjmeigihukusuuhyj) {
        ifcKykkjmeigihukusuuhyj = pIfcKykkjmeigihukusuuhyj;
    }

    @Column(order = 99, label = "契約者漢字名義管理番号")
    private String ifcKykkjmeigikanrino;

    public String getIfcKykkjmeigikanrino() {
        return ifcKykkjmeigikanrino;
    }

    public void setIfcKykkjmeigikanrino(String pIfcKykkjmeigikanrino) {
        ifcKykkjmeigikanrino = pIfcKykkjmeigikanrino;
    }

    @Column(order = 100, label = "電話番号複数表示")
    private String ifcTelnohukusuuhyj;

    public String getIfcTelnohukusuuhyj() {
        return ifcTelnohukusuuhyj;
    }

    public void setIfcTelnohukusuuhyj(String pIfcTelnohukusuuhyj) {
        ifcTelnohukusuuhyj = pIfcTelnohukusuuhyj;
    }

    @Column(order = 101, label = "電話番号管理番号")
    private String ifcTelnokanrino;

    public String getIfcTelnokanrino() {
        return ifcTelnokanrino;
    }

    public void setIfcTelnokanrino(String pIfcTelnokanrino) {
        ifcTelnokanrino = pIfcTelnokanrino;
    }

    @Column(order = 102, label = "名寄せ契約者カナ名義")
    private String ifcNyskykknmeigi;

    public String getIfcNyskykknmeigi() {
        return ifcNyskykknmeigi;
    }

    public void setIfcNyskykknmeigi(String pIfcNyskykknmeigi) {
        ifcNyskykknmeigi = pIfcNyskykknmeigi;
    }

    @Column(order = 103, label = "名寄せ契約者漢字名義")
    private String ifcNyskykkjmeigi;

    public String getIfcNyskykkjmeigi() {
        return ifcNyskykkjmeigi;
    }

    public void setIfcNyskykkjmeigi(String pIfcNyskykkjmeigi) {
        ifcNyskykkjmeigi = pIfcNyskykkjmeigi;
    }

    @Column(order = 104, label = "名寄せ電話番号")
    private String ifcNystelno;

    public String getIfcNystelno() {
        return ifcNystelno;
    }

    public void setIfcNystelno(String pIfcNystelno) {
        ifcNystelno = pIfcNystelno;
    }

    @Column(order = 105, label = "法人形態区分")
    private String ifcHjnkeitaikbn;

    public String getIfcHjnkeitaikbn() {
        return ifcHjnkeitaikbn;
    }

    public void setIfcHjnkeitaikbn(String pIfcHjnkeitaikbn) {
        ifcHjnkeitaikbn = pIfcHjnkeitaikbn;
    }

    @Column(order = 106, label = "法人名")
    private String ifcHjnnm;

    public String getIfcHjnnm() {
        return ifcHjnnm;
    }

    public void setIfcHjnnm(String pIfcHjnnm) {
        ifcHjnnm = pIfcHjnnm;
    }

    @Column(order = 107, label = "漢字法人名")
    private String ifcKjhjnnm;

    public String getIfcKjhjnnm() {
        return ifcKjhjnnm;
    }

    public void setIfcKjhjnnm(String pIfcKjhjnnm) {
        ifcKjhjnnm = pIfcKjhjnnm;
    }

    @Column(order = 108, label = "予備")
    private String ifcYobi06x01;

    public String getIfcYobi06x01() {
        return ifcYobi06x01;
    }

    public void setIfcYobi06x01(String pIfcYobi06x01) {
        ifcYobi06x01 = pIfcYobi06x01;
    }

    @Column(order = 109, label = "予備")
    private String ifcYobi06x02;

    public String getIfcYobi06x02() {
        return ifcYobi06x02;
    }

    public void setIfcYobi06x02(String pIfcYobi06x02) {
        ifcYobi06x02 = pIfcYobi06x02;
    }

    @Column(order = 110, label = "予備")
    private String ifcYobi06x03;

    public String getIfcYobi06x03() {
        return ifcYobi06x03;
    }

    public void setIfcYobi06x03(String pIfcYobi06x03) {
        ifcYobi06x03 = pIfcYobi06x03;
    }

    @Column(order = 111, label = "予備")
    private String ifcYobi06x04;

    public String getIfcYobi06x04() {
        return ifcYobi06x04;
    }

    public void setIfcYobi06x04(String pIfcYobi06x04) {
        ifcYobi06x04 = pIfcYobi06x04;
    }

    @Column(order = 112, label = "予備")
    private String ifcYobi06x05;

    public String getIfcYobi06x05() {
        return ifcYobi06x05;
    }

    public void setIfcYobi06x05(String pIfcYobi06x05) {
        ifcYobi06x05 = pIfcYobi06x05;
    }

    @Column(order = 113, label = "予備")
    private String ifcYobi06x06;

    public String getIfcYobi06x06() {
        return ifcYobi06x06;
    }

    public void setIfcYobi06x06(String pIfcYobi06x06) {
        ifcYobi06x06 = pIfcYobi06x06;
    }

    @Column(order = 114, label = "予備")
    private String ifcYobi06x07;

    public String getIfcYobi06x07() {
        return ifcYobi06x07;
    }

    public void setIfcYobi06x07(String pIfcYobi06x07) {
        ifcYobi06x07 = pIfcYobi06x07;
    }

    @Column(order = 115, label = "予備")
    private String ifcYobi06x08;

    public String getIfcYobi06x08() {
        return ifcYobi06x08;
    }

    public void setIfcYobi06x08(String pIfcYobi06x08) {
        ifcYobi06x08 = pIfcYobi06x08;
    }

    @Column(order = 116, label = "予備")
    private String ifcYobi06x09;

    public String getIfcYobi06x09() {
        return ifcYobi06x09;
    }

    public void setIfcYobi06x09(String pIfcYobi06x09) {
        ifcYobi06x09 = pIfcYobi06x09;
    }

    @Column(order = 117, label = "予備")
    private String ifcYobi06x10;

    public String getIfcYobi06x10() {
        return ifcYobi06x10;
    }

    public void setIfcYobi06x10(String pIfcYobi06x10) {
        ifcYobi06x10 = pIfcYobi06x10;
    }

    @Column(order = 118, label = "予備")
    private String ifcYobi06x11;

    public String getIfcYobi06x11() {
        return ifcYobi06x11;
    }

    public void setIfcYobi06x11(String pIfcYobi06x11) {
        ifcYobi06x11 = pIfcYobi06x11;
    }

    @Column(order = 119, label = "予備")
    private String ifcYobi06x12;

    public String getIfcYobi06x12() {
        return ifcYobi06x12;
    }

    public void setIfcYobi06x12(String pIfcYobi06x12) {
        ifcYobi06x12 = pIfcYobi06x12;
    }

    @Column(order = 120, label = "予備")
    private String ifcYobi06x13;

    public String getIfcYobi06x13() {
        return ifcYobi06x13;
    }

    public void setIfcYobi06x13(String pIfcYobi06x13) {
        ifcYobi06x13 = pIfcYobi06x13;
    }

    @Column(order = 121, label = "予備")
    private String ifcYobi06x14;

    public String getIfcYobi06x14() {
        return ifcYobi06x14;
    }

    public void setIfcYobi06x14(String pIfcYobi06x14) {
        ifcYobi06x14 = pIfcYobi06x14;
    }

    @Column(order = 122, label = "予備")
    private String ifcYobi06x15;

    public String getIfcYobi06x15() {
        return ifcYobi06x15;
    }

    public void setIfcYobi06x15(String pIfcYobi06x15) {
        ifcYobi06x15 = pIfcYobi06x15;
    }

    @Column(order = 123, label = "予備")
    private String ifcYobi07;

    public String getIfcYobi07() {
        return ifcYobi07;
    }

    public void setIfcYobi07(String pIfcYobi07) {
        ifcYobi07 = pIfcYobi07;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
