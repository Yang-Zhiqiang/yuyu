package yuyu.def.hozen.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保全）モニタリングデータ（受取人変更）ＣＳＶＦファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhMonitoringDataUkthenkouCsvFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhMonitoringDataUkthenkouCsvFile() {
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

    @Column(order = 26, label = "変更前年金受取人人数")
    private String ifcBfnkuktnin;

    public String getIfcBfnkuktnin() {
        return ifcBfnkuktnin;
    }

    public void setIfcBfnkuktnin(String pIfcBfnkuktnin) {
        ifcBfnkuktnin = pIfcBfnkuktnin;
    }

    @Column(order = 27, label = "変更前年金受取人名")
    private String ifcBfnkuktnmknhan;

    public String getIfcBfnkuktnmknhan() {
        return ifcBfnkuktnmknhan;
    }

    public void setIfcBfnkuktnmknhan(String pIfcBfnkuktnmknhan) {
        ifcBfnkuktnmknhan = pIfcBfnkuktnmknhan;
    }

    @Column(order = 28, label = "変更前漢字年金受取人名")
    private String ifcBfnkuktnmkj;

    public String getIfcBfnkuktnmkj() {
        return ifcBfnkuktnmkj;
    }

    public void setIfcBfnkuktnmkj(String pIfcBfnkuktnmkj) {
        ifcBfnkuktnmkj = pIfcBfnkuktnmkj;
    }

    @Column(order = 29, label = "変更後年金受取人人数")
    private String ifcNewnkuktnin;

    public String getIfcNewnkuktnin() {
        return ifcNewnkuktnin;
    }

    public void setIfcNewnkuktnin(String pIfcNewnkuktnin) {
        ifcNewnkuktnin = pIfcNewnkuktnin;
    }

    @Column(order = 30, label = "変更後年金受取人名")
    private String ifcNewnkuktnmknhan;

    public String getIfcNewnkuktnmknhan() {
        return ifcNewnkuktnmknhan;
    }

    public void setIfcNewnkuktnmknhan(String pIfcNewnkuktnmknhan) {
        ifcNewnkuktnmknhan = pIfcNewnkuktnmknhan;
    }

    @Column(order = 31, label = "変更後漢字年金受取人名")
    private String ifcNewnkuktnmkj;

    public String getIfcNewnkuktnmkj() {
        return ifcNewnkuktnmkj;
    }

    public void setIfcNewnkuktnmkj(String pIfcNewnkuktnmkj) {
        ifcNewnkuktnmkj = pIfcNewnkuktnmkj;
    }

    @Column(order = 32, label = "変更前死亡受取人人数")
    private String ifcBfsbuktnin;

    public String getIfcBfsbuktnin() {
        return ifcBfsbuktnin;
    }

    public void setIfcBfsbuktnin(String pIfcBfsbuktnin) {
        ifcBfsbuktnin = pIfcBfsbuktnin;
    }

    @Column(order = 33, label = "変更前死亡受取人名１")
    private String ifcBfsbuktnmkn1han;

    public String getIfcBfsbuktnmkn1han() {
        return ifcBfsbuktnmkn1han;
    }

    public void setIfcBfsbuktnmkn1han(String pIfcBfsbuktnmkn1han) {
        ifcBfsbuktnmkn1han = pIfcBfsbuktnmkn1han;
    }

    @Column(order = 34, label = "変更前漢字死亡受取人名１")
    private String ifcBfsbuktnmkj1;

    public String getIfcBfsbuktnmkj1() {
        return ifcBfsbuktnmkj1;
    }

    public void setIfcBfsbuktnmkj1(String pIfcBfsbuktnmkj1) {
        ifcBfsbuktnmkj1 = pIfcBfsbuktnmkj1;
    }

    @Column(order = 35, label = "変更前死亡受取人名２")
    private String ifcBfsbuktnmkn2han;

    public String getIfcBfsbuktnmkn2han() {
        return ifcBfsbuktnmkn2han;
    }

    public void setIfcBfsbuktnmkn2han(String pIfcBfsbuktnmkn2han) {
        ifcBfsbuktnmkn2han = pIfcBfsbuktnmkn2han;
    }

    @Column(order = 36, label = "変更前漢字死亡受取人名２")
    private String ifcBfsbuktnmkj2;

    public String getIfcBfsbuktnmkj2() {
        return ifcBfsbuktnmkj2;
    }

    public void setIfcBfsbuktnmkj2(String pIfcBfsbuktnmkj2) {
        ifcBfsbuktnmkj2 = pIfcBfsbuktnmkj2;
    }

    @Column(order = 37, label = "変更前死亡受取人名３")
    private String ifcBfsbuktnmkn3han;

    public String getIfcBfsbuktnmkn3han() {
        return ifcBfsbuktnmkn3han;
    }

    public void setIfcBfsbuktnmkn3han(String pIfcBfsbuktnmkn3han) {
        ifcBfsbuktnmkn3han = pIfcBfsbuktnmkn3han;
    }

    @Column(order = 38, label = "変更前漢字死亡受取人名３")
    private String ifcBfsbuktnmkj3;

    public String getIfcBfsbuktnmkj3() {
        return ifcBfsbuktnmkj3;
    }

    public void setIfcBfsbuktnmkj3(String pIfcBfsbuktnmkj3) {
        ifcBfsbuktnmkj3 = pIfcBfsbuktnmkj3;
    }

    @Column(order = 39, label = "変更前死亡受取人名４")
    private String ifcBfsbuktnmkn4han;

    public String getIfcBfsbuktnmkn4han() {
        return ifcBfsbuktnmkn4han;
    }

    public void setIfcBfsbuktnmkn4han(String pIfcBfsbuktnmkn4han) {
        ifcBfsbuktnmkn4han = pIfcBfsbuktnmkn4han;
    }

    @Column(order = 40, label = "変更前漢字死亡受取人名４")
    private String ifcBfsbuktnmkj4;

    public String getIfcBfsbuktnmkj4() {
        return ifcBfsbuktnmkj4;
    }

    public void setIfcBfsbuktnmkj4(String pIfcBfsbuktnmkj4) {
        ifcBfsbuktnmkj4 = pIfcBfsbuktnmkj4;
    }

    @Column(order = 41, label = "変更後死亡受取人人数")
    private String ifcNewsbuktnin;

    public String getIfcNewsbuktnin() {
        return ifcNewsbuktnin;
    }

    public void setIfcNewsbuktnin(String pIfcNewsbuktnin) {
        ifcNewsbuktnin = pIfcNewsbuktnin;
    }

    @Column(order = 42, label = "変更後死亡受取人名１")
    private String ifcNewsbuktnmkn1han;

    public String getIfcNewsbuktnmkn1han() {
        return ifcNewsbuktnmkn1han;
    }

    public void setIfcNewsbuktnmkn1han(String pIfcNewsbuktnmkn1han) {
        ifcNewsbuktnmkn1han = pIfcNewsbuktnmkn1han;
    }

    @Column(order = 43, label = "変更後漢字死亡受取人名１")
    private String ifcNewsbuktnmkj1;

    public String getIfcNewsbuktnmkj1() {
        return ifcNewsbuktnmkj1;
    }

    public void setIfcNewsbuktnmkj1(String pIfcNewsbuktnmkj1) {
        ifcNewsbuktnmkj1 = pIfcNewsbuktnmkj1;
    }

    @Column(order = 44, label = "変更後死亡受取人名２")
    private String ifcNewsbuktnmkn2han;

    public String getIfcNewsbuktnmkn2han() {
        return ifcNewsbuktnmkn2han;
    }

    public void setIfcNewsbuktnmkn2han(String pIfcNewsbuktnmkn2han) {
        ifcNewsbuktnmkn2han = pIfcNewsbuktnmkn2han;
    }

    @Column(order = 45, label = "変更後漢字死亡受取人名２")
    private String ifcNewsbuktnmkj2;

    public String getIfcNewsbuktnmkj2() {
        return ifcNewsbuktnmkj2;
    }

    public void setIfcNewsbuktnmkj2(String pIfcNewsbuktnmkj2) {
        ifcNewsbuktnmkj2 = pIfcNewsbuktnmkj2;
    }

    @Column(order = 46, label = "変更後死亡受取人名３")
    private String ifcNewsbuktnmkn3han;

    public String getIfcNewsbuktnmkn3han() {
        return ifcNewsbuktnmkn3han;
    }

    public void setIfcNewsbuktnmkn3han(String pIfcNewsbuktnmkn3han) {
        ifcNewsbuktnmkn3han = pIfcNewsbuktnmkn3han;
    }

    @Column(order = 47, label = "変更後漢字死亡受取人名３")
    private String ifcNewsbuktnmkj3;

    public String getIfcNewsbuktnmkj3() {
        return ifcNewsbuktnmkj3;
    }

    public void setIfcNewsbuktnmkj3(String pIfcNewsbuktnmkj3) {
        ifcNewsbuktnmkj3 = pIfcNewsbuktnmkj3;
    }

    @Column(order = 48, label = "変更後死亡受取人名４")
    private String ifcNewsbuktnmkn4han;

    public String getIfcNewsbuktnmkn4han() {
        return ifcNewsbuktnmkn4han;
    }

    public void setIfcNewsbuktnmkn4han(String pIfcNewsbuktnmkn4han) {
        ifcNewsbuktnmkn4han = pIfcNewsbuktnmkn4han;
    }

    @Column(order = 49, label = "変更後漢字死亡受取人名４")
    private String ifcNewsbuktnmkj4;

    public String getIfcNewsbuktnmkj4() {
        return ifcNewsbuktnmkj4;
    }

    public void setIfcNewsbuktnmkj4(String pIfcNewsbuktnmkj4) {
        ifcNewsbuktnmkj4 = pIfcNewsbuktnmkj4;
    }

    @Column(order = 50, label = "受取人変更年月日")
    private String ifcUkthenymd;

    public String getIfcUkthenymd() {
        return ifcUkthenymd;
    }

    public void setIfcUkthenymd(String pIfcUkthenymd) {
        ifcUkthenymd = pIfcUkthenymd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
