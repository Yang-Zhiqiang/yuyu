package yuyu.def.hozen.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_YokinKbn;

/**
 * （保全）モニタリングデータ（早期解約）ＣＳＶＦファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhMonitoringDataSoukiKaiyakuCsvFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhMonitoringDataSoukiKaiyakuCsvFile() {
    }

    @Column(order = 1, label = "証券番号")
    private String ifcSyono;

    public String getIfcSyono() {
        return ifcSyono;
    }

    public void setIfcSyono(String pIfcSyono) {
        ifcSyono = pIfcSyono;
    }

    @Column(order = 2, label = "お客さま番号")
    private String ifcOkyksmno;

    public String getIfcOkyksmno() {
        return ifcOkyksmno;
    }

    public void setIfcOkyksmno(String pIfcOkyksmno) {
        ifcOkyksmno = pIfcOkyksmno;
    }

    @Column(order = 3, label = "カナ契約者名")
    private String ifcKyknmknhan;

    public String getIfcKyknmknhan() {
        return ifcKyknmknhan;
    }

    public void setIfcKyknmknhan(String pIfcKyknmknhan) {
        ifcKyknmknhan = pIfcKyknmknhan;
    }

    @Column(order = 4, label = "漢字契約者名")
    private String ifcKyknmkj;

    public String getIfcKyknmkj() {
        return ifcKyknmkj;
    }

    public void setIfcKyknmkj(String pIfcKyknmkj) {
        ifcKyknmkj = pIfcKyknmkj;
    }

    @Column(order = 5, label = "生年月日")
    private String ifcKykseiymd;

    public String getIfcKykseiymd() {
        return ifcKykseiymd;
    }

    public void setIfcKykseiymd(String pIfcKykseiymd) {
        ifcKykseiymd = pIfcKykseiymd;
    }

    @Column(order = 6, label = "基本地区コード")
    private String ifcCommonkihontikucd;

    public String getIfcCommonkihontikucd() {
        return ifcCommonkihontikucd;
    }

    public void setIfcCommonkihontikucd(String pIfcCommonkihontikucd) {
        ifcCommonkihontikucd = pIfcCommonkihontikucd;
    }

    @Column(order = 7, label = "契約年月日")
    private String ifcKykymdstr;

    public String getIfcKykymdstr() {
        return ifcKykymdstr;
    }

    public void setIfcKykymdstr(String pIfcKykymdstr) {
        ifcKykymdstr = pIfcKykymdstr;
    }

    @Column(order = 8, label = "最終増額年月日※１年以内")
    private String ifcLastzugkymd;

    public String getIfcLastzugkymd() {
        return ifcLastzugkymd;
    }

    public void setIfcLastzugkymd(String pIfcLastzugkymd) {
        ifcLastzugkymd = pIfcLastzugkymd;
    }

    @Column(order = 9, label = "増額金額累計※１年以内")
    private String ifcZuruigk;

    public String getIfcZuruigk() {
        return ifcZuruigk;
    }

    public void setIfcZuruigk(String pIfcZuruigk) {
        ifcZuruigk = pIfcZuruigk;
    }

    @Column(order = 10, label = "最終名義変更年月日※１年以内")
    private String ifcLastmeighnksyoriymd;

    public String getIfcLastmeighnksyoriymd() {
        return ifcLastmeighnksyoriymd;
    }

    public void setIfcLastmeighnksyoriymd(String pIfcLastmeighnksyoriymd) {
        ifcLastmeighnksyoriymd = pIfcLastmeighnksyoriymd;
    }

    @Column(order = 11, label = "払込経路区分")
    private String ifcHrkkeirokbn;

    public String getIfcHrkkeirokbn() {
        return ifcHrkkeirokbn;
    }

    public void setIfcHrkkeirokbn(String pIfcHrkkeirokbn) {
        ifcHrkkeirokbn = pIfcHrkkeirokbn;
    }

    @Column(order = 12, label = "収納経路区分")
    private String ifcSyuunoukeirokbn;

    public String getIfcSyuunoukeirokbn() {
        return ifcSyuunoukeirokbn;
    }

    public void setIfcSyuunoukeirokbn(String pIfcSyuunoukeirokbn) {
        ifcSyuunoukeirokbn = pIfcSyuunoukeirokbn;
    }

    @Column(order = 13, label = "口座名義人契約者同一表示")
    private String ifcKykkzdoukbn;

    public String getIfcKykkzdoukbn() {
        return ifcKykkzdoukbn;
    }

    public void setIfcKykkzdoukbn(String pIfcKykkzdoukbn) {
        ifcKykkzdoukbn = pIfcKykkzdoukbn;
    }

    @Column(order = 14, label = "扱支社コード")
    private String ifcAtukaisisyacd;

    public String getIfcAtukaisisyacd() {
        return ifcAtukaisisyacd;
    }

    public void setIfcAtukaisisyacd(String pIfcAtukaisisyacd) {
        ifcAtukaisisyacd = pIfcAtukaisisyacd;
    }

    @Column(order = 15, label = "扱支部コード")
    private String ifcAtukaisibucd;

    public String getIfcAtukaisibucd() {
        return ifcAtukaisibucd;
    }

    public void setIfcAtukaisibucd(String pIfcAtukaisibucd) {
        ifcAtukaisibucd = pIfcAtukaisibucd;
    }

    @Column(order = 16, label = "扱者個人コード")
    private String ifcAtukaikojincd;

    public String getIfcAtukaikojincd() {
        return ifcAtukaikojincd;
    }

    public void setIfcAtukaikojincd(String pIfcAtukaikojincd) {
        ifcAtukaikojincd = pIfcAtukaikojincd;
    }

    @Column(order = 17, label = "ＭＲ契約表示")
    private String ifcMrkykhyj;

    public String getIfcMrkykhyj() {
        return ifcMrkykhyj;
    }

    public void setIfcMrkykhyj(String pIfcMrkykhyj) {
        ifcMrkykhyj = pIfcMrkykhyj;
    }

    @Column(order = 18, label = "内部契約表示")
    private String ifcNaibukykhyj;

    public String getIfcNaibukykhyj() {
        return ifcNaibukykhyj;
    }

    public void setIfcNaibukykhyj(String pIfcNaibukykhyj) {
        ifcNaibukykhyj = pIfcNaibukykhyj;
    }

    @Column(order = 19, label = "自己契約表示")
    private String ifcJikokykhyj;

    public String getIfcJikokykhyj() {
        return ifcJikokykhyj;
    }

    public void setIfcJikokykhyj(String pIfcJikokykhyj) {
        ifcJikokykhyj = pIfcJikokykhyj;
    }

    @Column(order = 20, label = "法人契約表示")
    private String ifcHjnkykhyj;

    public String getIfcHjnkykhyj() {
        return ifcHjnkykhyj;
    }

    public void setIfcHjnkykhyj(String pIfcHjnkykhyj) {
        ifcHjnkykhyj = pIfcHjnkykhyj;
    }

    @Column(order = 21, label = "商品分類区分")
    private String ifcSyouhnbunruikbn;

    public String getIfcSyouhnbunruikbn() {
        return ifcSyouhnbunruikbn;
    }

    public void setIfcSyouhnbunruikbn(String pIfcSyouhnbunruikbn) {
        ifcSyouhnbunruikbn = pIfcSyouhnbunruikbn;
    }

    @Column(order = 22, label = "商品名称区分")
    private String ifcSyouhnnmkbn;

    public String getIfcSyouhnnmkbn() {
        return ifcSyouhnnmkbn;
    }

    public void setIfcSyouhnnmkbn(String pIfcSyouhnnmkbn) {
        ifcSyouhnnmkbn = pIfcSyouhnnmkbn;
    }

    @Column(order = 23, label = "法定貯蓄性保険表示")
    private String ifcHouteityotkhknhyj;

    public String getIfcHouteityotkhknhyj() {
        return ifcHouteityotkhknhyj;
    }

    public void setIfcHouteityotkhknhyj(String pIfcHouteityotkhknhyj) {
        ifcHouteityotkhknhyj = pIfcHouteityotkhknhyj;
    }

    @Column(order = 24, label = "キャッシュバリュー高表示")
    private String ifcTyotkhknhyj;

    public String getIfcTyotkhknhyj() {
        return ifcTyotkhknhyj;
    }

    public void setIfcTyotkhknhyj(String pIfcTyotkhknhyj) {
        ifcTyotkhknhyj = pIfcTyotkhknhyj;
    }

    @Column(order = 25, label = "高ＣＶ計算エラー区分")
    private String ifcHighcverrorkbn;

    public String getIfcHighcverrorkbn() {
        return ifcHighcverrorkbn;
    }

    public void setIfcHighcverrorkbn(String pIfcHighcverrorkbn) {
        ifcHighcverrorkbn = pIfcHighcverrorkbn;
    }

    @Column(order = 26, label = "解約処理年月日")
    private String ifcKaiykymd;

    public String getIfcKaiykymd() {
        return ifcKaiykymd;
    }

    public void setIfcKaiykymd(String pIfcKaiykymd) {
        ifcKaiykymd = pIfcKaiykymd;
    }

    @Column(order = 27, label = "解約差引支払金額")
    private String ifcKaiyakuhrkngak;

    public String getIfcKaiyakuhrkngak() {
        return ifcKaiyakuhrkngak;
    }

    public void setIfcKaiyakuhrkngak(String pIfcKaiyakuhrkngak) {
        ifcKaiyakuhrkngak = pIfcKaiyakuhrkngak;
    }

    @Column(order = 28, label = "処理コード")
    private String ifcCommonsyoricd;

    public String getIfcCommonsyoricd() {
        return ifcCommonsyoricd;
    }

    public void setIfcCommonsyoricd(String pIfcCommonsyoricd) {
        ifcCommonsyoricd = pIfcCommonsyoricd;
    }

    @Column(order = 29, label = "支払方法区分")
    private String ifcShrhousiteikbn;

    public String getIfcShrhousiteikbn() {
        return ifcShrhousiteikbn;
    }

    public void setIfcShrhousiteikbn(String pIfcShrhousiteikbn) {
        ifcShrhousiteikbn = pIfcShrhousiteikbn;
    }

    @Column(order = 30, label = "銀行番号")
    private String ifcBankcd;

    public String getIfcBankcd() {
        return ifcBankcd;
    }

    public void setIfcBankcd(String pIfcBankcd) {
        ifcBankcd = pIfcBankcd;
    }

    @Column(order = 31, label = "支店番号")
    private String ifcSitencd;

    public String getIfcSitencd() {
        return ifcSitencd;
    }

    public void setIfcSitencd(String pIfcSitencd) {
        ifcSitencd = pIfcSitencd;
    }

    @Column(order = 32, label = "預金種目区分")
    private C_YokinKbn ifcYokinkbn;

    public C_YokinKbn getIfcYokinkbn() {
        return ifcYokinkbn;
    }

    public void setIfcYokinkbn(C_YokinKbn pIfcYokinkbn) {
        ifcYokinkbn = pIfcYokinkbn;
    }

    @Column(order = 33, label = "口座番号")
    private String ifcShrsakikz;

    public String getIfcShrsakikz() {
        return ifcShrsakikz;
    }

    public void setIfcShrsakikz(String pIfcShrsakikz) {
        ifcShrsakikz = pIfcShrsakikz;
    }

    @Column(order = 34, label = "口座名義人名")
    private String ifcKzmeiginmknhan;

    public String getIfcKzmeiginmknhan() {
        return ifcKzmeiginmknhan;
    }

    public void setIfcKzmeiginmknhan(String pIfcKzmeiginmknhan) {
        ifcKzmeiginmknhan = pIfcKzmeiginmknhan;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
