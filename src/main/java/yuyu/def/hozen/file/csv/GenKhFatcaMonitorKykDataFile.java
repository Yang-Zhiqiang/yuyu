package yuyu.def.hozen.file.csv;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_FatcahankeiiKbn;
import yuyu.def.classification.C_FatcakekKbn;
import yuyu.def.classification.C_FatcatgKbn;

/**
 * （保全）ＦＡＴＣＡモニタリング確認契約データファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhFatcaMonitorKykDataFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhFatcaMonitorKykDataFile() {
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

    @Column(order = 33, label = "案内不要理由区分")
    private String ifcAnnaifuyouriyuukbn;

    public String getIfcAnnaifuyouriyuukbn() {
        return ifcAnnaifuyouriyuukbn;
    }

    public void setIfcAnnaifuyouriyuukbn(String pIfcAnnaifuyouriyuukbn) {
        ifcAnnaifuyouriyuukbn = pIfcAnnaifuyouriyuukbn;
    }

    @Column(order = 34, label = "データ管理番号")
    private String ifcDatakanrino;

    public String getIfcDatakanrino() {
        return ifcDatakanrino;
    }

    public void setIfcDatakanrino(String pIfcDatakanrino) {
        ifcDatakanrino = pIfcDatakanrino;
    }

    @Column(order = 35, label = "解約返戻金相当額ＵＬＦ表示")
    private String ifcKaiyakuhrstgkulfhyouji;

    public String getIfcKaiyakuhrstgkulfhyouji() {
        return ifcKaiyakuhrstgkulfhyouji;
    }

    public void setIfcKaiyakuhrstgkulfhyouji(String pIfcKaiyakuhrstgkulfhyouji) {
        ifcKaiyakuhrstgkulfhyouji = pIfcKaiyakuhrstgkulfhyouji;
    }

    @Column(order = 36, label = "備金時効Ｆ表示")
    private String ifcBknjikoufhyoji;

    public String getIfcBknjikoufhyoji() {
        return ifcBknjikoufhyoji;
    }

    public void setIfcBknjikoufhyoji(String pIfcBknjikoufhyoji) {
        ifcBknjikoufhyoji = pIfcBknjikoufhyoji;
    }

    @Column(order = 37, label = "備金コード")
    private String ifcBkncd;

    public String getIfcBkncd() {
        return ifcBkncd;
    }

    public void setIfcBkncd(String pIfcBkncd) {
        ifcBkncd = pIfcBkncd;
    }

    @Column(order = 38, label = "失効解約返戻金備金時効Ｆ表示")
    private String ifcSkKaiyakuhrbknjkufhyoji;

    public String getIfcSkKaiyakuhrbknjkufhyoji() {
        return ifcSkKaiyakuhrbknjkufhyoji;
    }

    public void setIfcSkKaiyakuhrbknjkufhyoji(String pIfcSkKaiyakuhrbknjkufhyoji) {
        ifcSkKaiyakuhrbknjkufhyoji = pIfcSkKaiyakuhrbknjkufhyoji;
    }

    @Column(order = 39, label = "生存給付金利息等捕捉用ＵＬＦ表示")
    private String ifcSznkyhknrskthskyulfhyoji;

    public String getIfcSznkyhknrskthskyulfhyoji() {
        return ifcSznkyhknrskthskyulfhyoji;
    }

    public void setIfcSznkyhknrskthskyulfhyoji(String pIfcSznkyhknrskthskyulfhyoji) {
        ifcSznkyhknrskthskyulfhyoji = pIfcSznkyhknrskthskyulfhyoji;
    }

    @Column(order = 40, label = "生存給付金備金用ＵＬＦ表示")
    private String ifcSznkyhknbknyulfhyoji;

    public String getIfcSznkyhknbknyulfhyoji() {
        return ifcSznkyhknbknyulfhyoji;
    }

    public void setIfcSznkyhknbknyulfhyoji(String pIfcSznkyhknbknyulfhyoji) {
        ifcSznkyhknbknyulfhyoji = pIfcSznkyhknbknyulfhyoji;
    }

    @Column(order = 41, label = "棚卸決算用積立ＤＵＬＦ表示")
    private String ifcTnrsksnytmttdulfhyoji;

    public String getIfcTnrsksnytmttdulfhyoji() {
        return ifcTnrsksnytmttdulfhyoji;
    }

    public void setIfcTnrsksnytmttdulfhyoji(String pIfcTnrsksnytmttdulfhyoji) {
        ifcTnrsksnytmttdulfhyoji = pIfcTnrsksnytmttdulfhyoji;
    }

    @Column(order = 42, label = "棚卸決算用相殺ＤＵＬＦ表示")
    private String ifcTnrsksnysustdulfhyoji;

    public String getIfcTnrsksnysustdulfhyoji() {
        return ifcTnrsksnysustdulfhyoji;
    }

    public void setIfcTnrsksnysustdulfhyoji(String pIfcTnrsksnysustdulfhyoji) {
        ifcTnrsksnysustdulfhyoji = pIfcTnrsksnysustdulfhyoji;
    }

    @Column(order = 43, label = "棚卸決算用備金分精算ＤＵＬＦ表示")
    private String ifcTnrsksnbknbnsndulfhyoji;

    public String getIfcTnrsksnbknbnsndulfhyoji() {
        return ifcTnrsksnbknbnsndulfhyoji;
    }

    public void setIfcTnrsksnbknbnsndulfhyoji(String pIfcTnrsksnbknbnsndulfhyoji) {
        ifcTnrsksnbknbnsndulfhyoji = pIfcTnrsksnbknbnsndulfhyoji;
    }

    @Column(order = 44, label = "棚卸決算用暫定ＤＵＬＦ表示")
    private String ifcTnrsksnyzntidulfhyoji;

    public String getIfcTnrsksnyzntidulfhyoji() {
        return ifcTnrsksnyzntidulfhyoji;
    }

    public void setIfcTnrsksnyzntidulfhyoji(String pIfcTnrsksnyzntidulfhyoji) {
        ifcTnrsksnyzntidulfhyoji = pIfcTnrsksnyzntidulfhyoji;
    }

    @Column(order = 45, label = "棚卸決算用仮割当ＤＵＬＦ表示")
    private String ifcTnrsksnykrwratdulfhyoji;

    public String getIfcTnrsksnykrwratdulfhyoji() {
        return ifcTnrsksnykrwratdulfhyoji;
    }

    public void setIfcTnrsksnykrwratdulfhyoji(String pIfcTnrsksnykrwratdulfhyoji) {
        ifcTnrsksnykrwratdulfhyoji = pIfcTnrsksnykrwratdulfhyoji;
    }

    @Column(order = 46, label = "保有明細Ｆ表示")
    private String ifcHyumeisaifhyoji;

    public String getIfcHyumeisaifhyoji() {
        return ifcHyumeisaifhyoji;
    }

    public void setIfcHyumeisaifhyoji(String pIfcHyumeisaifhyoji) {
        ifcHyumeisaifhyoji = pIfcHyumeisaifhyoji;
    }

    @Column(order = 47, label = "未経過Ｐ備金時効Ｆ表示")
    private String ifcMikeikapbknjkufhyoji;

    public String getIfcMikeikapbknjkufhyoji() {
        return ifcMikeikapbknjkufhyoji;
    }

    public void setIfcMikeikapbknjkufhyoji(String pIfcMikeikapbknjkufhyoji) {
        ifcMikeikapbknjkufhyoji = pIfcMikeikapbknjkufhyoji;
    }

    @Column(order = 48, label = "ＯＬ失効未経過Ｐ返金ＵＬＦ表示")
    private String ifcOlskmkkphknulfhyouji;

    public String getIfcOlskmkkphknulfhyouji() {
        return ifcOlskmkkphknulfhyouji;
    }

    public void setIfcOlskmkkphknulfhyouji(String pIfcOlskmkkphknulfhyouji) {
        ifcOlskmkkphknulfhyouji = pIfcOlskmkkphknulfhyouji;
    }

    @Column(order = 49, label = "予備")
    private String ifcYobi01x01;

    public String getIfcYobi01x01() {
        return ifcYobi01x01;
    }

    public void setIfcYobi01x01(String pIfcYobi01x01) {
        ifcYobi01x01 = pIfcYobi01x01;
    }

    @Column(order = 50, label = "予備")
    private String ifcYobi01x02;

    public String getIfcYobi01x02() {
        return ifcYobi01x02;
    }

    public void setIfcYobi01x02(String pIfcYobi01x02) {
        ifcYobi01x02 = pIfcYobi01x02;
    }

    @Column(order = 51, label = "ＣＶ計算不可表示")
    private String ifcCvkeisanhukahyouji;

    public String getIfcCvkeisanhukahyouji() {
        return ifcCvkeisanhukahyouji;
    }

    public void setIfcCvkeisanhukahyouji(String pIfcCvkeisanhukahyouji) {
        ifcCvkeisanhukahyouji = pIfcCvkeisanhukahyouji;
    }

    @Column(order = 52, label = "解約返戻金エラー区分")
    private String ifcKaiyakuhrerrkbn;

    public String getIfcKaiyakuhrerrkbn() {
        return ifcKaiyakuhrerrkbn;
    }

    public void setIfcKaiyakuhrerrkbn(String pIfcKaiyakuhrerrkbn) {
        ifcKaiyakuhrerrkbn = pIfcKaiyakuhrerrkbn;
    }

    @Column(order = 53, label = "生存給付金エラー区分")
    private String ifcSznkyhknerrkbn;

    public String getIfcSznkyhknerrkbn() {
        return ifcSznkyhknerrkbn;
    }

    public void setIfcSznkyhknerrkbn(String pIfcSznkyhknerrkbn) {
        ifcSznkyhknerrkbn = pIfcSznkyhknerrkbn;
    }

    @Column(order = 54, label = "配当金エラー区分")
    private String ifcHaitoukinerrkbn;

    public String getIfcHaitoukinerrkbn() {
        return ifcHaitoukinerrkbn;
    }

    public void setIfcHaitoukinerrkbn(String pIfcHaitoukinerrkbn) {
        ifcHaitoukinerrkbn = pIfcHaitoukinerrkbn;
    }

    @Column(order = 55, label = "未経過保険料エラー区分")
    private String ifcMikeikaperrkbn;

    public String getIfcMikeikaperrkbn() {
        return ifcMikeikaperrkbn;
    }

    public void setIfcMikeikaperrkbn(String pIfcMikeikaperrkbn) {
        ifcMikeikaperrkbn = pIfcMikeikaperrkbn;
    }

    @Column(order = 56, label = "予備")
    private String ifcYobi02x01;

    public String getIfcYobi02x01() {
        return ifcYobi02x01;
    }

    public void setIfcYobi02x01(String pIfcYobi02x01) {
        ifcYobi02x01 = pIfcYobi02x01;
    }

    @Column(order = 57, label = "予備")
    private String ifcYobi02x02;

    public String getIfcYobi02x02() {
        return ifcYobi02x02;
    }

    public void setIfcYobi02x02(String pIfcYobi02x02) {
        ifcYobi02x02 = pIfcYobi02x02;
    }

    @Column(order = 58, label = "予備")
    private String ifcYobi02x03;

    public String getIfcYobi02x03() {
        return ifcYobi02x03;
    }

    public void setIfcYobi02x03(String pIfcYobi02x03) {
        ifcYobi02x03 = pIfcYobi02x03;
    }

    @Column(order = 59, label = "予備")
    private String ifcYobi02x04;

    public String getIfcYobi02x04() {
        return ifcYobi02x04;
    }

    public void setIfcYobi02x04(String pIfcYobi02x04) {
        ifcYobi02x04 = pIfcYobi02x04;
    }

    @Column(order = 60, label = "予備")
    private String ifcYobi02x05;

    public String getIfcYobi02x05() {
        return ifcYobi02x05;
    }

    public void setIfcYobi02x05(String pIfcYobi02x05) {
        ifcYobi02x05 = pIfcYobi02x05;
    }

    @Column(order = 61, label = "予備")
    private String ifcYobi02x06;

    public String getIfcYobi02x06() {
        return ifcYobi02x06;
    }

    public void setIfcYobi02x06(String pIfcYobi02x06) {
        ifcYobi02x06 = pIfcYobi02x06;
    }

    @Column(order = 62, label = "予備")
    private String ifcYobi02x07;

    public String getIfcYobi02x07() {
        return ifcYobi02x07;
    }

    public void setIfcYobi02x07(String pIfcYobi02x07) {
        ifcYobi02x07 = pIfcYobi02x07;
    }

    @Column(order = 63, label = "予備")
    private String ifcYobi02x08;

    public String getIfcYobi02x08() {
        return ifcYobi02x08;
    }

    public void setIfcYobi02x08(String pIfcYobi02x08) {
        ifcYobi02x08 = pIfcYobi02x08;
    }

    @Column(order = 64, label = "予備")
    private String ifcYobi02x09;

    public String getIfcYobi02x09() {
        return ifcYobi02x09;
    }

    public void setIfcYobi02x09(String pIfcYobi02x09) {
        ifcYobi02x09 = pIfcYobi02x09;
    }

    @Column(order = 65, label = "予備")
    private String ifcYobi02x10;

    public String getIfcYobi02x10() {
        return ifcYobi02x10;
    }

    public void setIfcYobi02x10(String pIfcYobi02x10) {
        ifcYobi02x10 = pIfcYobi02x10;
    }

    @Column(order = 66, label = "予備")
    private String ifcYobi02x11;

    public String getIfcYobi02x11() {
        return ifcYobi02x11;
    }

    public void setIfcYobi02x11(String pIfcYobi02x11) {
        ifcYobi02x11 = pIfcYobi02x11;
    }

    @Column(order = 67, label = "予備")
    private String ifcYobi02x12;

    public String getIfcYobi02x12() {
        return ifcYobi02x12;
    }

    public void setIfcYobi02x12(String pIfcYobi02x12) {
        ifcYobi02x12 = pIfcYobi02x12;
    }

    @Column(order = 68, label = "予備")
    private String ifcYobi02x13;

    public String getIfcYobi02x13() {
        return ifcYobi02x13;
    }

    public void setIfcYobi02x13(String pIfcYobi02x13) {
        ifcYobi02x13 = pIfcYobi02x13;
    }

    @Column(order = 69, label = "予備")
    private String ifcYobi03;

    public String getIfcYobi03() {
        return ifcYobi03;
    }

    public void setIfcYobi03(String pIfcYobi03) {
        ifcYobi03 = pIfcYobi03;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
