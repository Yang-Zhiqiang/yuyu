package yuyu.def.direct.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （ダイレクト）統計ファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenDsToukeiFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenDsToukeiFile() {
    }

    @Column(order = 1, label = "ＤＳ顧客番号")
    private String ifcDskokno;

    public String getIfcDskokno() {
        return ifcDskokno;
    }

    public void setIfcDskokno(String pIfcDskokno) {
        ifcDskokno = pIfcDskokno;
    }

    @Column(order = 2, label = "ＤＳ顧客状態区分")
    private String ifcDskokyakujtkbn;

    public String getIfcDskokyakujtkbn() {
        return ifcDskokyakujtkbn;
    }

    public void setIfcDskokyakujtkbn(String pIfcDskokyakujtkbn) {
        ifcDskokyakujtkbn = pIfcDskokyakujtkbn;
    }

    @Column(order = 3, label = "ＤＳ顧客作成年月日")
    private String ifcDskokyakusakuseiymd;

    public String getIfcDskokyakusakuseiymd() {
        return ifcDskokyakusakuseiymd;
    }

    public void setIfcDskokyakusakuseiymd(String pIfcDskokyakusakuseiymd) {
        ifcDskokyakusakuseiymd = pIfcDskokyakusakuseiymd;
    }

    @Column(order = 4, label = "ＤＳ停止理由区分")
    private String ifcDsteisiriyuukbn;

    public String getIfcDsteisiriyuukbn() {
        return ifcDsteisiriyuukbn;
    }

    public void setIfcDsteisiriyuukbn(String pIfcDsteisiriyuukbn) {
        ifcDsteisiriyuukbn = pIfcDsteisiriyuukbn;
    }

    @Column(order = 5, label = "ＤＳ顧客無効年月日")
    private String ifcDskokyakumukouymd;

    public String getIfcDskokyakumukouymd() {
        return ifcDskokyakumukouymd;
    }

    public void setIfcDskokyakumukouymd(String pIfcDskokyakumukouymd) {
        ifcDskokyakumukouymd = pIfcDskokyakumukouymd;
    }

    @Column(order = 6, label = "精査不要表示")
    private String ifcSeisahuyouhyj;

    public String getIfcSeisahuyouhyj() {
        return ifcSeisahuyouhyj;
    }

    public void setIfcSeisahuyouhyj(String pIfcSeisahuyouhyj) {
        ifcSeisahuyouhyj = pIfcSeisahuyouhyj;
    }

    @Column(order = 7, label = "ＤＳ顧客生年月日")
    private String ifcDskokyakuseiymd;

    public String getIfcDskokyakuseiymd() {
        return ifcDskokyakuseiymd;
    }

    public void setIfcDskokyakuseiymd(String pIfcDskokyakuseiymd) {
        ifcDskokyakuseiymd = pIfcDskokyakuseiymd;
    }

    @Column(order = 8, label = "ＤＳ顧客郵便番号")
    private String ifcDskokyakuyno;

    public String getIfcDskokyakuyno() {
        return ifcDskokyakuyno;
    }

    public void setIfcDskokyakuyno(String pIfcDskokyakuyno) {
        ifcDskokyakuyno = pIfcDskokyakuyno;
    }

    @Column(order = 9, label = "ＤＳ加入経路区分")
    private String ifcDskanyuukeirokbn;

    public String getIfcDskanyuukeirokbn() {
        return ifcDskanyuukeirokbn;
    }

    public void setIfcDskanyuukeirokbn(String pIfcDskanyuukeirokbn) {
        ifcDskanyuukeirokbn = pIfcDskanyuukeirokbn;
    }

    @Column(order = 10, label = "ＤＳ仮パスワード設定区分")
    private String ifcDskrhnnkakcdsetkbn;

    public String getIfcDskrhnnkakcdsetkbn() {
        return ifcDskrhnnkakcdsetkbn;
    }

    public void setIfcDskrhnnkakcdsetkbn(String pIfcDskrhnnkakcdsetkbn) {
        ifcDskrhnnkakcdsetkbn = pIfcDskrhnnkakcdsetkbn;
    }

    @Column(order = 11, label = "ＤＳ仮パスワード設定年月日")
    private String ifcDskrhnnkakcdsetymd;

    public String getIfcDskrhnnkakcdsetymd() {
        return ifcDskrhnnkakcdsetymd;
    }

    public void setIfcDskrhnnkakcdsetymd(String pIfcDskrhnnkakcdsetymd) {
        ifcDskrhnnkakcdsetymd = pIfcDskrhnnkakcdsetymd;
    }

    @Column(order = 12, label = "ＤＳ仮パスワード有効年月日")
    private String ifcDskrhnnkakcdyuukouymd;

    public String getIfcDskrhnnkakcdyuukouymd() {
        return ifcDskrhnnkakcdyuukouymd;
    }

    public void setIfcDskrhnnkakcdyuukouymd(String pIfcDskrhnnkakcdyuukouymd) {
        ifcDskrhnnkakcdyuukouymd = pIfcDskrhnnkakcdyuukouymd;
    }

    @Column(order = 13, label = "ＤＳパスワード設定年月日")
    private String ifcDshnnkakcdsetymd;

    public String getIfcDshnnkakcdsetymd() {
        return ifcDshnnkakcdsetymd;
    }

    public void setIfcDshnnkakcdsetymd(String pIfcDshnnkakcdsetymd) {
        ifcDshnnkakcdsetymd = pIfcDshnnkakcdsetymd;
    }

    @Column(order = 14, label = "ＤＳ仮パスワード通知送付事由発生日")
    private String ifcDskrhnnkakcdttshjyhsymd;

    public String getIfcDskrhnnkakcdttshjyhsymd() {
        return ifcDskrhnnkakcdttshjyhsymd;
    }

    public void setIfcDskrhnnkakcdttshjyhsymd(String pIfcDskrhnnkakcdttshjyhsymd) {
        ifcDskrhnnkakcdttshjyhsymd = pIfcDskrhnnkakcdttshjyhsymd;
    }

    @Column(order = 15, label = "ＤＳ仮パスワード通知要否区分")
    private String ifcDskrhnnkakcdttyhkbn;

    public String getIfcDskrhnnkakcdttyhkbn() {
        return ifcDskrhnnkakcdttyhkbn;
    }

    public void setIfcDskrhnnkakcdttyhkbn(String pIfcDskrhnnkakcdttyhkbn) {
        ifcDskrhnnkakcdttyhkbn = pIfcDskrhnnkakcdttyhkbn;
    }

    @Column(order = 16, label = "ＤＳ仮パスワード通知中断事由区分")
    private String ifcDskrhnnkakcdtttydnjykbn;

    public String getIfcDskrhnnkakcdtttydnjykbn() {
        return ifcDskrhnnkakcdtttydnjykbn;
    }

    public void setIfcDskrhnnkakcdtttydnjykbn(String pIfcDskrhnnkakcdtttydnjykbn) {
        ifcDskrhnnkakcdtttydnjykbn = pIfcDskrhnnkakcdtttydnjykbn;
    }

    @Column(order = 17, label = "初回ログイン年月日")
    private String ifcSyokailoginymd;

    public String getIfcSyokailoginymd() {
        return ifcSyokailoginymd;
    }

    public void setIfcSyokailoginymd(String pIfcSyokailoginymd) {
        ifcSyokailoginymd = pIfcSyokailoginymd;
    }

    @Column(order = 18, label = "初回ログイン時刻")
    private String ifcSyokailogintime;

    public String getIfcSyokailogintime() {
        return ifcSyokailogintime;
    }

    public void setIfcSyokailogintime(String pIfcSyokailogintime) {
        ifcSyokailogintime = pIfcSyokailogintime;
    }

    @Column(order = 19, label = "初回ログイン媒体区分")
    private String ifcSyokailoginbaitaikbn;

    public String getIfcSyokailoginbaitaikbn() {
        return ifcSyokailoginbaitaikbn;
    }

    public void setIfcSyokailoginbaitaikbn(String pIfcSyokailoginbaitaikbn) {
        ifcSyokailoginbaitaikbn = pIfcSyokailoginbaitaikbn;
    }

    @Column(order = 20, label = "最新ログイン年月日")
    private String ifcSaisinloginymd;

    public String getIfcSaisinloginymd() {
        return ifcSaisinloginymd;
    }

    public void setIfcSaisinloginymd(String pIfcSaisinloginymd) {
        ifcSaisinloginymd = pIfcSaisinloginymd;
    }

    @Column(order = 21, label = "最新ログイン時刻")
    private String ifcSaisinlogintime;

    public String getIfcSaisinlogintime() {
        return ifcSaisinlogintime;
    }

    public void setIfcSaisinlogintime(String pIfcSaisinlogintime) {
        ifcSaisinlogintime = pIfcSaisinlogintime;
    }

    @Column(order = 22, label = "最新ログイン媒体区分")
    private String ifcSaisinloginbaitaikbn;

    public String getIfcSaisinloginbaitaikbn() {
        return ifcSaisinloginbaitaikbn;
    }

    public void setIfcSaisinloginbaitaikbn(String pIfcSaisinloginbaitaikbn) {
        ifcSaisinloginbaitaikbn = pIfcSaisinloginbaitaikbn;
    }

    @Column(order = 23, label = "ＤＳパスワードエラー回数")
    private String ifcDshnnkakcderrorks;

    public String getIfcDshnnkakcderrorks() {
        return ifcDshnnkakcderrorks;
    }

    public void setIfcDshnnkakcderrorks(String pIfcDshnnkakcderrorks) {
        ifcDshnnkakcderrorks = pIfcDshnnkakcderrorks;
    }

    @Column(order = 24, label = "ＤＳ顧客名エラー回数")
    private String ifcDskokyakunmerrorks;

    public String getIfcDskokyakunmerrorks() {
        return ifcDskokyakunmerrorks;
    }

    public void setIfcDskokyakunmerrorks(String pIfcDskokyakunmerrorks) {
        ifcDskokyakunmerrorks = pIfcDskokyakunmerrorks;
    }

    @Column(order = 25, label = "ＤＳ顧客生年月日エラー回数")
    private String ifcDskokyakuseiymderrorks;

    public String getIfcDskokyakuseiymderrorks() {
        return ifcDskokyakuseiymderrorks;
    }

    public void setIfcDskokyakuseiymderrorks(String pIfcDskokyakuseiymderrorks) {
        ifcDskokyakuseiymderrorks = pIfcDskokyakuseiymderrorks;
    }

    @Column(order = 26, label = "ＤＳ顧客電話番号エラー回数")
    private String ifcDskokyakutelnoerrorks;

    public String getIfcDskokyakutelnoerrorks() {
        return ifcDskokyakutelnoerrorks;
    }

    public void setIfcDskokyakutelnoerrorks(String pIfcDskokyakutelnoerrorks) {
        ifcDskokyakutelnoerrorks = pIfcDskokyakutelnoerrorks;
    }

    @Column(order = 27, label = "証券番号")
    private String ifcSyono;

    public String getIfcSyono() {
        return ifcSyono;
    }

    public void setIfcSyono(String pIfcSyono) {
        ifcSyono = pIfcSyono;
    }

    @Column(order = 28, label = "ＤＳ契約加入年月日")
    private String ifcDskykkanyuuymd;

    public String getIfcDskykkanyuuymd() {
        return ifcDskykkanyuuymd;
    }

    public void setIfcDskykkanyuuymd(String pIfcDskykkanyuuymd) {
        ifcDskykkanyuuymd = pIfcDskykkanyuuymd;
    }

    @Column(order = 29, label = "ＤＳ契約変更年月日")
    private String ifcDskykhenkouymd;

    public String getIfcDskykhenkouymd() {
        return ifcDskykhenkouymd;
    }

    public void setIfcDskykhenkouymd(String pIfcDskykhenkouymd) {
        ifcDskykhenkouymd = pIfcDskykhenkouymd;
    }

    @Column(order = 30, label = "ＤＳ契約無効表示")
    private String ifcDskykmukouhyj;

    public String getIfcDskykmukouhyj() {
        return ifcDskykmukouhyj;
    }

    public void setIfcDskykmukouhyj(String pIfcDskykmukouhyj) {
        ifcDskykmukouhyj = pIfcDskykmukouhyj;
    }

    @Column(order = 31, label = "ＤＳ契約無効年月日")
    private String ifcDskykmukouymd;

    public String getIfcDskykmukouymd() {
        return ifcDskykmukouymd;
    }

    public void setIfcDskykmukouymd(String pIfcDskykmukouymd) {
        ifcDskykmukouymd = pIfcDskykmukouymd;
    }

    @Column(order = 32, label = "ＤＳメール登録状態区分")
    private String ifcDsmailtourokujyoutaikbn;

    public String getIfcDsmailtourokujyoutaikbn() {
        return ifcDsmailtourokujyoutaikbn;
    }

    public void setIfcDsmailtourokujyoutaikbn(String pIfcDsmailtourokujyoutaikbn) {
        ifcDsmailtourokujyoutaikbn = pIfcDsmailtourokujyoutaikbn;
    }

    @Column(order = 33, label = "ＤＳメールアドレス")
    private String ifcDsmailaddress;

    public String getIfcDsmailaddress() {
        return ifcDsmailaddress;
    }

    public void setIfcDsmailaddress(String pIfcDsmailaddress) {
        ifcDsmailaddress = pIfcDsmailaddress;
    }

    @Column(order = 34, label = "ＤＳメール送信状態区分")
    private String ifcDsmailsousinjyoutaikbn;

    public String getIfcDsmailsousinjyoutaikbn() {
        return ifcDsmailsousinjyoutaikbn;
    }

    public void setIfcDsmailsousinjyoutaikbn(String pIfcDsmailsousinjyoutaikbn) {
        ifcDsmailsousinjyoutaikbn = pIfcDsmailsousinjyoutaikbn;
    }

    @Column(order = 35, label = "ＤＳメール送信停止理由区分")
    private String ifcDsmailsousintisrykbn;

    public String getIfcDsmailsousintisrykbn() {
        return ifcDsmailsousintisrykbn;
    }

    public void setIfcDsmailsousintisrykbn(String pIfcDsmailsousintisrykbn) {
        ifcDsmailsousintisrykbn = pIfcDsmailsousintisrykbn;
    }

    @Column(order = 36, label = "ＤＳ登録日時")
    private String ifcDstourokuymdtime;

    public String getIfcDstourokuymdtime() {
        return ifcDstourokuymdtime;
    }

    public void setIfcDstourokuymdtime(String pIfcDstourokuymdtime) {
        ifcDstourokuymdtime = pIfcDstourokuymdtime;
    }

    @Column(order = 37, label = "ＤＳ更新日時")
    private String ifcDskousinymdtime;

    public String getIfcDskousinymdtime() {
        return ifcDskousinymdtime;
    }

    public void setIfcDskousinymdtime(String pIfcDskousinymdtime) {
        ifcDskousinymdtime = pIfcDskousinymdtime;
    }

    @Column(order = 38, label = "新契約時申込番号")
    private String ifcSkjmosno;

    public String getIfcSkjmosno() {
        return ifcSkjmosno;
    }

    public void setIfcSkjmosno(String pIfcSkjmosno) {
        ifcSkjmosno = pIfcSkjmosno;
    }

    @Column(order = 39, label = "申込受付区分")
    private String ifcMosuketukekbn;

    public String getIfcMosuketukekbn() {
        return ifcMosuketukekbn;
    }

    public void setIfcMosuketukekbn(String pIfcMosuketukekbn) {
        ifcMosuketukekbn = pIfcMosuketukekbn;
    }

    @Column(order = 40, label = "契約者性別")
    private String ifcKyksei;

    public String getIfcKyksei() {
        return ifcKyksei;
    }

    public void setIfcKyksei(String pIfcKyksei) {
        ifcKyksei = pIfcKyksei;
    }

    @Column(order = 41, label = "募集時親代理店コード")
    private String ifcBsyujoyadrtencd;

    public String getIfcBsyujoyadrtencd() {
        return ifcBsyujoyadrtencd;
    }

    public void setIfcBsyujoyadrtencd(String pIfcBsyujoyadrtencd) {
        ifcBsyujoyadrtencd = pIfcBsyujoyadrtencd;
    }

    @Column(order = 42, label = "募集時代理店コード")
    private String ifcBsyujdrtencd;

    public String getIfcBsyujdrtencd() {
        return ifcBsyujdrtencd;
    }

    public void setIfcBsyujdrtencd(String pIfcBsyujdrtencd) {
        ifcBsyujdrtencd = pIfcBsyujdrtencd;
    }

    @Column(order = 43, label = "ペーパーレス経由メアド更新日時")
    private String ifcPplessmailaddrkostime;

    public String getIfcPplessmailaddrkostime() {
        return ifcPplessmailaddrkostime;
    }

    public void setIfcPplessmailaddrkostime(String pIfcPplessmailaddrkostime) {
        ifcPplessmailaddrkostime = pIfcPplessmailaddrkostime;
    }

    @Column(order = 44, label = "ＤＳ取引サービス利用状況区分")
    private String ifcDstrhkserviceriyoujkkbn;

    public String getIfcDstrhkserviceriyoujkkbn() {
        return ifcDstrhkserviceriyoujkkbn;
    }

    public void setIfcDstrhkserviceriyoujkkbn(String pIfcDstrhkserviceriyoujkkbn) {
        ifcDstrhkserviceriyoujkkbn = pIfcDstrhkserviceriyoujkkbn;
    }

    @Column(order = 45, label = "ＤＳ取引サービス停止理由区分")
    private String ifcDstrhkservicetsriyuukbn;

    public String getIfcDstrhkservicetsriyuukbn() {
        return ifcDstrhkservicetsriyuukbn;
    }

    public void setIfcDstrhkservicetsriyuukbn(String pIfcDstrhkservicetsriyuukbn) {
        ifcDstrhkservicetsriyuukbn = pIfcDstrhkservicetsriyuukbn;
    }

    @Column(order = 46, label = "ＤＳ取引サービス登録年月日")
    private String ifcDstrhkservicetourokuymd;

    public String getIfcDstrhkservicetourokuymd() {
        return ifcDstrhkservicetourokuymd;
    }

    public void setIfcDstrhkservicetourokuymd(String pIfcDstrhkservicetourokuymd) {
        ifcDstrhkservicetourokuymd = pIfcDstrhkservicetourokuymd;
    }

    @Column(order = 47, label = "ＤＳ取引サービス無効年月日")
    private String ifcDstrhkservicemukouymd;

    public String getIfcDstrhkservicemukouymd() {
        return ifcDstrhkservicemukouymd;
    }

    public void setIfcDstrhkservicemukouymd(String pIfcDstrhkservicemukouymd) {
        ifcDstrhkservicemukouymd = pIfcDstrhkservicemukouymd;
    }

    @Column(order = 48, label = "ＤＳ取引サービス加入経路区分")
    private String ifcDstrhkservicekkkbn;

    public String getIfcDstrhkservicekkkbn() {
        return ifcDstrhkservicekkkbn;
    }

    public void setIfcDstrhkservicekkkbn(String pIfcDstrhkservicekkkbn) {
        ifcDstrhkservicekkkbn = pIfcDstrhkservicekkkbn;
    }

    @Column(order = 49, label = "特定取引用口座種類区分")
    private String ifcDssoukinkzsyuruikbn;

    public String getIfcDssoukinkzsyuruikbn() {
        return ifcDssoukinkzsyuruikbn;
    }

    public void setIfcDssoukinkzsyuruikbn(String pIfcDssoukinkzsyuruikbn) {
        ifcDssoukinkzsyuruikbn = pIfcDssoukinkzsyuruikbn;
    }

    @Column(order = 50, label = "特定取引用金融機関コード")
    private String ifcDssoukinkinyuucd;

    public String getIfcDssoukinkinyuucd() {
        return ifcDssoukinkinyuucd;
    }

    public void setIfcDssoukinkinyuucd(String pIfcDssoukinkinyuucd) {
        ifcDssoukinkinyuucd = pIfcDssoukinkinyuucd;
    }

    @Column(order = 51, label = "特定取引用金融機関支店コード")
    private String ifcDssoukinkinyuusitencd;

    public String getIfcDssoukinkinyuusitencd() {
        return ifcDssoukinkinyuusitencd;
    }

    public void setIfcDssoukinkinyuusitencd(String pIfcDssoukinkinyuusitencd) {
        ifcDssoukinkinyuusitencd = pIfcDssoukinkinyuusitencd;
    }

    @Column(order = 52, label = "特定取引用口座預金種目")
    private String ifcDssoukinyokin;

    public String getIfcDssoukinyokin() {
        return ifcDssoukinyokin;
    }

    public void setIfcDssoukinyokin(String pIfcDssoukinyokin) {
        ifcDssoukinyokin = pIfcDssoukinyokin;
    }

    @Column(order = 53, label = "特定取引用口座番号")
    private String ifcDssoukinkouzano;

    public String getIfcDssoukinkouzano() {
        return ifcDssoukinkouzano;
    }

    public void setIfcDssoukinkouzano(String pIfcDssoukinkouzano) {
        ifcDssoukinkouzano = pIfcDssoukinkouzano;
    }

    @Column(order = 54, label = "特定取引用口座名義人同一区分")
    private String ifcKzdoukbn;

    public String getIfcKzdoukbn() {
        return ifcKzdoukbn;
    }

    public void setIfcKzdoukbn(String pIfcKzdoukbn) {
        ifcKzdoukbn = pIfcKzdoukbn;
    }

    @Column(order = 55, label = "特定取引用暗証番号")
    private String ifcTokuteitrhkansyono;

    public String getIfcTokuteitrhkansyono() {
        return ifcTokuteitrhkansyono;
    }

    public void setIfcTokuteitrhkansyono(String pIfcTokuteitrhkansyono) {
        ifcTokuteitrhkansyono = pIfcTokuteitrhkansyono;
    }

    @Column(order = 56, label = "特定取引用暗証番号エラー回数")
    private String ifcTktrhkansyonoerrorkaisuu;

    public String getIfcTktrhkansyonoerrorkaisuu() {
        return ifcTktrhkansyonoerrorkaisuu;
    }

    public void setIfcTktrhkansyonoerrorkaisuu(String pIfcTktrhkansyonoerrorkaisuu) {
        ifcTktrhkansyonoerrorkaisuu = pIfcTktrhkansyonoerrorkaisuu;
    }

    @Column(order = 57, label = "特定取引用暗証番号設定年月日")
    private String ifcTktrhkansyonosetymd;

    public String getIfcTktrhkansyonosetymd() {
        return ifcTktrhkansyonosetymd;
    }

    public void setIfcTktrhkansyonosetymd(String pIfcTktrhkansyonosetymd) {
        ifcTktrhkansyonosetymd = pIfcTktrhkansyonosetymd;
    }

    @Column(order = 58, label = "ペーパーレス連動時ＤＳ書面手続表示")
    private String ifcPplessrjdssymnttdkhyj;

    public String getIfcPplessrjdssymnttdkhyj() {
        return ifcPplessrjdssymnttdkhyj;
    }

    public void setIfcPplessrjdssymnttdkhyj(String pIfcPplessrjdssymnttdkhyj) {
        ifcPplessrjdssymnttdkhyj = pIfcPplessrjdssymnttdkhyj;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
