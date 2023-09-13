package yuyu.def.hozen.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保全）モニタリングデータ（クーリングオフ）ＣＳＶＦファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhMonitoringDataCoolingoffCsvFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhMonitoringDataCoolingoffCsvFile() {
    }

    @Column(order = 1, label = "申込番号")
    private String ifcMosno;

    public String getIfcMosno() {
        return ifcMosno;
    }

    public void setIfcMosno(String pIfcMosno) {
        ifcMosno = pIfcMosno;
    }

    @Column(order = 2, label = "証券番号")
    private String ifcSyono;

    public String getIfcSyono() {
        return ifcSyono;
    }

    public void setIfcSyono(String pIfcSyono) {
        ifcSyono = pIfcSyono;
    }

    @Column(order = 3, label = "お客さま番号")
    private String ifcOkyksmno;

    public String getIfcOkyksmno() {
        return ifcOkyksmno;
    }

    public void setIfcOkyksmno(String pIfcOkyksmno) {
        ifcOkyksmno = pIfcOkyksmno;
    }

    @Column(order = 4, label = "カナ契約者名")
    private String ifcKyknmknhan;

    public String getIfcKyknmknhan() {
        return ifcKyknmknhan;
    }

    public void setIfcKyknmknhan(String pIfcKyknmknhan) {
        ifcKyknmknhan = pIfcKyknmknhan;
    }

    @Column(order = 5, label = "漢字契約者名")
    private String ifcKyknmkj;

    public String getIfcKyknmkj() {
        return ifcKyknmkj;
    }

    public void setIfcKyknmkj(String pIfcKyknmkj) {
        ifcKyknmkj = pIfcKyknmkj;
    }

    @Column(order = 6, label = "契約者生年月日")
    private String ifcKykseiymd;

    public String getIfcKykseiymd() {
        return ifcKykseiymd;
    }

    public void setIfcKykseiymd(String pIfcKykseiymd) {
        ifcKykseiymd = pIfcKykseiymd;
    }

    @Column(order = 7, label = "基本地区コード")
    private String ifcCommonkihontikucd;

    public String getIfcCommonkihontikucd() {
        return ifcCommonkihontikucd;
    }

    public void setIfcCommonkihontikucd(String pIfcCommonkihontikucd) {
        ifcCommonkihontikucd = pIfcCommonkihontikucd;
    }

    @Column(order = 8, label = "契約年月日")
    private String ifcKykymdstr;

    public String getIfcKykymdstr() {
        return ifcKykymdstr;
    }

    public void setIfcKykymdstr(String pIfcKykymdstr) {
        ifcKykymdstr = pIfcKykymdstr;
    }

    @Column(order = 9, label = "直近１年間の増額経緯")
    private String ifcLastzugkymd;

    public String getIfcLastzugkymd() {
        return ifcLastzugkymd;
    }

    public void setIfcLastzugkymd(String pIfcLastzugkymd) {
        ifcLastzugkymd = pIfcLastzugkymd;
    }

    @Column(order = 10, label = "直近１年間の増額金額")
    private String ifcZuruigk;

    public String getIfcZuruigk() {
        return ifcZuruigk;
    }

    public void setIfcZuruigk(String pIfcZuruigk) {
        ifcZuruigk = pIfcZuruigk;
    }

    @Column(order = 11, label = "直近１年間の名変経緯")
    private String ifcLastmeighnksyoriymd;

    public String getIfcLastmeighnksyoriymd() {
        return ifcLastmeighnksyoriymd;
    }

    public void setIfcLastmeighnksyoriymd(String pIfcLastmeighnksyoriymd) {
        ifcLastmeighnksyoriymd = pIfcLastmeighnksyoriymd;
    }

    @Column(order = 12, label = "払込経路区分")
    private String ifcHrkkeirokbn;

    public String getIfcHrkkeirokbn() {
        return ifcHrkkeirokbn;
    }

    public void setIfcHrkkeirokbn(String pIfcHrkkeirokbn) {
        ifcHrkkeirokbn = pIfcHrkkeirokbn;
    }

    @Column(order = 13, label = "収納経路区分")
    private String ifcSyuunoukeirokbn;

    public String getIfcSyuunoukeirokbn() {
        return ifcSyuunoukeirokbn;
    }

    public void setIfcSyuunoukeirokbn(String pIfcSyuunoukeirokbn) {
        ifcSyuunoukeirokbn = pIfcSyuunoukeirokbn;
    }

    @Column(order = 14, label = "口座名義人契約者同一表示")
    private String ifcKykkzdoukbn;

    public String getIfcKykkzdoukbn() {
        return ifcKykkzdoukbn;
    }

    public void setIfcKykkzdoukbn(String pIfcKykkzdoukbn) {
        ifcKykkzdoukbn = pIfcKykkzdoukbn;
    }

    @Column(order = 15, label = "扱者支社コード")
    private String ifcAtukaisisyacd;

    public String getIfcAtukaisisyacd() {
        return ifcAtukaisisyacd;
    }

    public void setIfcAtukaisisyacd(String pIfcAtukaisisyacd) {
        ifcAtukaisisyacd = pIfcAtukaisisyacd;
    }

    @Column(order = 16, label = "扱者支部コード")
    private String ifcAtukaisibucd;

    public String getIfcAtukaisibucd() {
        return ifcAtukaisibucd;
    }

    public void setIfcAtukaisibucd(String pIfcAtukaisibucd) {
        ifcAtukaisibucd = pIfcAtukaisibucd;
    }

    @Column(order = 17, label = "扱者個人コード")
    private String ifcAtukaikojincd;

    public String getIfcAtukaikojincd() {
        return ifcAtukaikojincd;
    }

    public void setIfcAtukaikojincd(String pIfcAtukaikojincd) {
        ifcAtukaikojincd = pIfcAtukaikojincd;
    }

    @Column(order = 18, label = "ＭＲ契約表示")
    private String ifcMrkykhyj;

    public String getIfcMrkykhyj() {
        return ifcMrkykhyj;
    }

    public void setIfcMrkykhyj(String pIfcMrkykhyj) {
        ifcMrkykhyj = pIfcMrkykhyj;
    }

    @Column(order = 19, label = "内部契約表示")
    private String ifcNaibukykhyj;

    public String getIfcNaibukykhyj() {
        return ifcNaibukykhyj;
    }

    public void setIfcNaibukykhyj(String pIfcNaibukykhyj) {
        ifcNaibukykhyj = pIfcNaibukykhyj;
    }

    @Column(order = 20, label = "自己契約表示")
    private String ifcJikokykhyj;

    public String getIfcJikokykhyj() {
        return ifcJikokykhyj;
    }

    public void setIfcJikokykhyj(String pIfcJikokykhyj) {
        ifcJikokykhyj = pIfcJikokykhyj;
    }

    @Column(order = 21, label = "法人契約表示")
    private String ifcHjnkykhyj;

    public String getIfcHjnkykhyj() {
        return ifcHjnkykhyj;
    }

    public void setIfcHjnkykhyj(String pIfcHjnkykhyj) {
        ifcHjnkykhyj = pIfcHjnkykhyj;
    }

    @Column(order = 22, label = "処理コード")
    private String ifcCommonsyoricd;

    public String getIfcCommonsyoricd() {
        return ifcCommonsyoricd;
    }

    public void setIfcCommonsyoricd(String pIfcCommonsyoricd) {
        ifcCommonsyoricd = pIfcCommonsyoricd;
    }

    @Column(order = 23, label = "法定貯蓄性保険表示")
    private String ifcHouteityotkhknhyj;

    public String getIfcHouteityotkhknhyj() {
        return ifcHouteityotkhknhyj;
    }

    public void setIfcHouteityotkhknhyj(String pIfcHouteityotkhknhyj) {
        ifcHouteityotkhknhyj = pIfcHouteityotkhknhyj;
    }

    @Column(order = 24, label = "解約返戻金５０００万以上表示")
    private String ifcTyotkhknhyj;

    public String getIfcTyotkhknhyj() {
        return ifcTyotkhknhyj;
    }

    public void setIfcTyotkhknhyj(String pIfcTyotkhknhyj) {
        ifcTyotkhknhyj = pIfcTyotkhknhyj;
    }

    @Column(order = 25, label = "商品分類区分")
    private String ifcSyouhnbunruikbn;

    public String getIfcSyouhnbunruikbn() {
        return ifcSyouhnbunruikbn;
    }

    public void setIfcSyouhnbunruikbn(String pIfcSyouhnbunruikbn) {
        ifcSyouhnbunruikbn = pIfcSyouhnbunruikbn;
    }

    @Column(order = 26, label = "商品名称区分")
    private String ifcSyouhnnmkbn;

    public String getIfcSyouhnnmkbn() {
        return ifcSyouhnnmkbn;
    }

    public void setIfcSyouhnnmkbn(String pIfcSyouhnnmkbn) {
        ifcSyouhnnmkbn = pIfcSyouhnnmkbn;
    }

    @Column(order = 27, label = "手続注意７４表示")
    private String ifcHighriskflg;

    public String getIfcHighriskflg() {
        return ifcHighriskflg;
    }

    public void setIfcHighriskflg(String pIfcHighriskflg) {
        ifcHighriskflg = pIfcHighriskflg;
    }

    @Column(order = 28, label = "支社名")
    private String ifcCommonsisyanm;

    public String getIfcCommonsisyanm() {
        return ifcCommonsisyanm;
    }

    public void setIfcCommonsisyanm(String pIfcCommonsisyanm) {
        ifcCommonsisyanm = pIfcCommonsisyanm;
    }

    @Column(order = 29, label = "組織名")
    private String ifcSosikinm;

    public String getIfcSosikinm() {
        return ifcSosikinm;
    }

    public void setIfcSosikinm(String pIfcSosikinm) {
        ifcSosikinm = pIfcSosikinm;
    }

    @Column(order = 30, label = "初回払込Ｐ")
    private String ifcSyokaiphrkgk;

    public String getIfcSyokaiphrkgk() {
        return ifcSyokaiphrkgk;
    }

    public void setIfcSyokaiphrkgk(String pIfcSyokaiphrkgk) {
        ifcSyokaiphrkgk = pIfcSyokaiphrkgk;
    }

    @Column(order = 31, label = "初回払込Ｐ入金方法区分")
    private String ifcFsthrkpnyknhhkbn;

    public String getIfcFsthrkpnyknhhkbn() {
        return ifcFsthrkpnyknhhkbn;
    }

    public void setIfcFsthrkpnyknhhkbn(String pIfcFsthrkpnyknhhkbn) {
        ifcFsthrkpnyknhhkbn = pIfcFsthrkpnyknhhkbn;
    }

    @Column(order = 32, label = "１００万円超過表示")
    private String ifcOver100manflg;

    public String getIfcOver100manflg() {
        return ifcOver100manflg;
    }

    public void setIfcOver100manflg(String pIfcOver100manflg) {
        ifcOver100manflg = pIfcOver100manflg;
    }

    @Column(order = 33, label = "５０万円超過表示")
    private String ifcOver50manflg;

    public String getIfcOver50manflg() {
        return ifcOver50manflg;
    }

    public void setIfcOver50manflg(String pIfcOver50manflg) {
        ifcOver50manflg = pIfcOver50manflg;
    }

    @Column(order = 34, label = "成契経路区分")
    private String ifcSeikeikeirokbn;

    public String getIfcSeikeikeirokbn() {
        return ifcSeikeikeirokbn;
    }

    public void setIfcSeikeikeirokbn(String pIfcSeikeikeirokbn) {
        ifcSeikeikeirokbn = pIfcSeikeikeirokbn;
    }

    @Column(order = 35, label = "申込時本人確認区分")
    private String ifcMosjihonninkknnkbn;

    public String getIfcMosjihonninkknnkbn() {
        return ifcMosjihonninkknnkbn;
    }

    public void setIfcMosjihonninkknnkbn(String pIfcMosjihonninkknnkbn) {
        ifcMosjihonninkknnkbn = pIfcMosjihonninkknnkbn;
    }

    @Column(order = 36, label = "申込消滅区分")
    private String ifcMossyoumetukbn;

    public String getIfcMossyoumetukbn() {
        return ifcMossyoumetukbn;
    }

    public void setIfcMossyoumetukbn(String pIfcMossyoumetukbn) {
        ifcMossyoumetukbn = pIfcMossyoumetukbn;
    }

    @Column(order = 37, label = "申込消滅確定年月日")
    private String ifcMossyoumetukktiymd;

    public String getIfcMossyoumetukktiymd() {
        return ifcMossyoumetukktiymd;
    }

    public void setIfcMossyoumetukktiymd(String pIfcMossyoumetukktiymd) {
        ifcMossyoumetukktiymd = pIfcMossyoumetukktiymd;
    }

    @Column(order = 38, label = "申込取消区分")
    private String ifcMostrkskbn;

    public String getIfcMostrkskbn() {
        return ifcMostrkskbn;
    }

    public void setIfcMostrkskbn(String pIfcMostrkskbn) {
        ifcMostrkskbn = pIfcMostrkskbn;
    }

    @Column(order = 39, label = "申込取消詳細理由区分")
    private String ifcMostrkssyousairiyuukbn;

    public String getIfcMostrkssyousairiyuukbn() {
        return ifcMostrkssyousairiyuukbn;
    }

    public void setIfcMostrkssyousairiyuukbn(String pIfcMostrkssyousairiyuukbn) {
        ifcMostrkssyousairiyuukbn = pIfcMostrkssyousairiyuukbn;
    }

    @Column(order = 40, label = "払込回数区分")
    private String ifcHrkkaisuustr;

    public String getIfcHrkkaisuustr() {
        return ifcHrkkaisuustr;
    }

    public void setIfcHrkkaisuustr(String pIfcHrkkaisuustr) {
        ifcHrkkaisuustr = pIfcHrkkaisuustr;
    }

    @Column(order = 41, label = "取引時確認区分")
    private String ifcTrhkjikakkbn;

    public String getIfcTrhkjikakkbn() {
        return ifcTrhkjikakkbn;
    }

    public void setIfcTrhkjikakkbn(String pIfcTrhkjikakkbn) {
        ifcTrhkjikakkbn = pIfcTrhkjikakkbn;
    }

    @Column(order = 42, label = "入金状態区分")
    private String ifcNyuukinjoutaikbn;

    public String getIfcNyuukinjoutaikbn() {
        return ifcNyuukinjoutaikbn;
    }

    public void setIfcNyuukinjoutaikbn(String pIfcNyuukinjoutaikbn) {
        ifcNyuukinjoutaikbn = pIfcNyuukinjoutaikbn;
    }

    @Column(order = 43, label = "事業契約表示")
    private String ifcJigyoukeiyakuhyouji;

    public String getIfcJigyoukeiyakuhyouji() {
        return ifcJigyoukeiyakuhyouji;
    }

    public void setIfcJigyoukeiyakuhyouji(String pIfcJigyoukeiyakuhyouji) {
        ifcJigyoukeiyakuhyouji = pIfcJigyoukeiyakuhyouji;
    }

    @Column(order = 44, label = "入金回数")
    private String ifcNyknkaisuu;

    public String getIfcNyknkaisuu() {
        return ifcNyknkaisuu;
    }

    public void setIfcNyknkaisuu(String pIfcNyknkaisuu) {
        ifcNyknkaisuu = pIfcNyknkaisuu;
    }

    @Column(order = 45, label = "契約者被保険者同一表示")
    private String ifcKykhhkndouhyouji;

    public String getIfcKykhhkndouhyouji() {
        return ifcKykhhkndouhyouji;
    }

    public void setIfcKykhhkndouhyouji(String pIfcKykhhkndouhyouji) {
        ifcKykhhkndouhyouji = pIfcKykhhkndouhyouji;
    }

    @Column(order = 46, label = "案内先コード")
    private String ifcAnniskcd;

    public String getIfcAnniskcd() {
        return ifcAnniskcd;
    }

    public void setIfcAnniskcd(String pIfcAnniskcd) {
        ifcAnniskcd = pIfcAnniskcd;
    }

    @Column(order = 47, label = "入力案内先コード")
    private String ifcNyuuryokuanniskcd;

    public String getIfcNyuuryokuanniskcd() {
        return ifcNyuuryokuanniskcd;
    }

    public void setIfcNyuuryokuanniskcd(String pIfcNyuuryokuanniskcd) {
        ifcNyuuryokuanniskcd = pIfcNyuuryokuanniskcd;
    }

    @Column(order = 48, label = "漢字法人代表者名")
    private String ifcHjndaikjmeigi;

    public String getIfcHjndaikjmeigi() {
        return ifcHjndaikjmeigi;
    }

    public void setIfcHjndaikjmeigi(String pIfcHjndaikjmeigi) {
        ifcHjndaikjmeigi = pIfcHjndaikjmeigi;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
