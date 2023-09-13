package yuyu.def.direct.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （ダイレクト）値動き判定結果ファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenDsNeugokiHanteiKekkaFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenDsNeugokiHanteiKekkaFile() {
    }

    @Column(order = 1, label = "証券番号")
    private String ifcSyono;

    public String getIfcSyono() {
        return ifcSyono;
    }

    public void setIfcSyono(String pIfcSyono) {
        ifcSyono = pIfcSyono;
    }

    @Column(order = 2, label = "契約者名")
    private String ifcKyknmkn;

    public String getIfcKyknmkn() {
        return ifcKyknmkn;
    }

    public void setIfcKyknmkn(String pIfcKyknmkn) {
        ifcKyknmkn = pIfcKyknmkn;
    }

    @Column(order = 3, label = "判定日")
    private String ifcHanteiymd;

    public String getIfcHanteiymd() {
        return ifcHanteiymd;
    }

    public void setIfcHanteiymd(String pIfcHanteiymd) {
        ifcHanteiymd = pIfcHanteiymd;
    }

    @Column(order = 4, label = "募集時Ａ扱代理店コード")
    private String ifcBosyuujiaatukaidrtencd;

    public String getIfcBosyuujiaatukaidrtencd() {
        return ifcBosyuujiaatukaidrtencd;
    }

    public void setIfcBosyuujiaatukaidrtencd(String pIfcBosyuujiaatukaidrtencd) {
        ifcBosyuujiaatukaidrtencd = pIfcBosyuujiaatukaidrtencd;
    }

    @Column(order = 5, label = "募集時Ｂ扱代理店コード")
    private String ifcBosyuujibatukaidrtencd;

    public String getIfcBosyuujibatukaidrtencd() {
        return ifcBosyuujibatukaidrtencd;
    }

    public void setIfcBosyuujibatukaidrtencd(String pIfcBosyuujibatukaidrtencd) {
        ifcBosyuujibatukaidrtencd = pIfcBosyuujibatukaidrtencd;
    }

    @Column(order = 6, label = "メールアドレス登録有無")
    private String ifcMailaddresstourokuumukbn;

    public String getIfcMailaddresstourokuumukbn() {
        return ifcMailaddresstourokuumukbn;
    }

    public void setIfcMailaddresstourokuumukbn(String pIfcMailaddresstourokuumukbn) {
        ifcMailaddresstourokuumukbn = pIfcMailaddresstourokuumukbn;
    }

    @Column(order = 7, label = "メール送信区分")
    private String ifcMailsousinyhkbn;

    public String getIfcMailsousinyhkbn() {
        return ifcMailsousinyhkbn;
    }

    public void setIfcMailsousinyhkbn(String pIfcMailsousinyhkbn) {
        ifcMailsousinyhkbn = pIfcMailsousinyhkbn;
    }

    @Column(order = 8, label = "値動き割合")
    private String ifcNeugokiwari;

    public String getIfcNeugokiwari() {
        return ifcNeugokiwari;
    }

    public void setIfcNeugokiwari(String pIfcNeugokiwari) {
        ifcNeugokiwari = pIfcNeugokiwari;
    }

    @Column(order = 9, label = "一時払保険料")
    private String ifcItijibrp;

    public String getIfcItijibrp() {
        return ifcItijibrp;
    }

    public void setIfcItijibrp(String pIfcItijibrp) {
        ifcItijibrp = pIfcItijibrp;
    }

    @Column(order = 10, label = "通貨種類")
    private String ifcKyktuukasyu;

    public String getIfcKyktuukasyu() {
        return ifcKyktuukasyu;
    }

    public void setIfcKyktuukasyu(String pIfcKyktuukasyu) {
        ifcKyktuukasyu = pIfcKyktuukasyu;
    }

    @Column(order = 11, label = "基準金額")
    private String ifcNeugokihanteikjnkngk;

    public String getIfcNeugokihanteikjnkngk() {
        return ifcNeugokihanteikjnkngk;
    }

    public void setIfcNeugokihanteikjnkngk(String pIfcNeugokihanteikjnkngk) {
        ifcNeugokihanteikjnkngk = pIfcNeugokihanteikjnkngk;
    }

    @Column(order = 12, label = "解約返戻金額")
    private String ifcKaiyakuhryen;

    public String getIfcKaiyakuhryen() {
        return ifcKaiyakuhryen;
    }

    public void setIfcKaiyakuhryen(String pIfcKaiyakuhryen) {
        ifcKaiyakuhryen = pIfcKaiyakuhryen;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
