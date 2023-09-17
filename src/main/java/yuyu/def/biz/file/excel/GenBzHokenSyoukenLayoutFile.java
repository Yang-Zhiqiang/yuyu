package yuyu.def.biz.file.excel;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.excel.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）保険証券テーブルレイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzHokenSyoukenLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzHokenSyoukenLayoutFile() {
    }

    @Column(order = 1, label = "kbnkey")
    private String ifeTskbnkey;

    public String getIfeTskbnkey() {
        return ifeTskbnkey;
    }

    public void setIfeTskbnkey(String pIfeTskbnkey) {
        ifeTskbnkey = pIfeTskbnkey;
    }

    @Column(order = 2, label = "syono")
    private String ifeTssyono;

    public String getIfeTssyono() {
        return ifeTssyono;
    }

    public void setIfeTssyono(String pIfeTssyono) {
        ifeTssyono = pIfeTssyono;
    }

    @Column(order = 3, label = "tyouhyouymd")
    private String ifeTstyouhyouymd;

    public String getIfeTstyouhyouymd() {
        return ifeTstyouhyouymd;
    }

    public void setIfeTstyouhyouymd(String pIfeTstyouhyouymd) {
        ifeTstyouhyouymd = pIfeTstyouhyouymd;
    }

    @Column(order = 4, label = "henkousikibetukey")
    private String ifeTshenkousikibetukey;

    public String getIfeTshenkousikibetukey() {
        return ifeTshenkousikibetukey;
    }

    public void setIfeTshenkousikibetukey(String pIfeTshenkousikibetukey) {
        ifeTshenkousikibetukey = pIfeTshenkousikibetukey;
    }

    @Column(order = 5, label = "sinsaihkkbn")
    private String ifeTssinsaihkkbn;

    public String getIfeTssinsaihkkbn() {
        return ifeTssinsaihkkbn;
    }

    public void setIfeTssinsaihkkbn(String pIfeTssinsaihkkbn) {
        ifeTssinsaihkkbn = pIfeTssinsaihkkbn;
    }

    @Column(order = 6, label = "syoukensaihkkbn")
    private String ifeTssyoukensaihkkbn;

    public String getIfeTssyoukensaihkkbn() {
        return ifeTssyoukensaihkkbn;
    }

    public void setIfeTssyoukensaihkkbn(String pIfeTssyoukensaihkkbn) {
        ifeTssyoukensaihkkbn = pIfeTssyoukensaihkkbn;
    }

    @Column(order = 7, label = "insizeishryouhikbn")
    private String ifeTsinsizeishryouhikbn;

    public String getIfeTsinsizeishryouhikbn() {
        return ifeTsinsizeishryouhikbn;
    }

    public void setIfeTsinsizeishryouhikbn(String pIfeTsinsizeishryouhikbn) {
        ifeTsinsizeishryouhikbn = pIfeTsinsizeishryouhikbn;
    }

    @Column(order = 8, label = "hassoukbn")
    private String ifeTshassoukbn;

    public String getIfeTshassoukbn() {
        return ifeTshassoukbn;
    }

    public void setIfeTshassoukbn(String pIfeTshassoukbn) {
        ifeTshassoukbn = pIfeTshassoukbn;
    }

    @Column(order = 9, label = "koujyosyoumeiumukbn")
    private String ifeTskoujyosyoumeiumukbn;

    public String getIfeTskoujyosyoumeiumukbn() {
        return ifeTskoujyosyoumeiumukbn;
    }

    public void setIfeTskoujyosyoumeiumukbn(String pIfeTskoujyosyoumeiumukbn) {
        ifeTskoujyosyoumeiumukbn = pIfeTskoujyosyoumeiumukbn;
    }

    @Column(order = 10, label = "suiihyouumukbn")
    private String ifeTssuiihyouumukbn;

    public String getIfeTssuiihyouumukbn() {
        return ifeTssuiihyouumukbn;
    }

    public void setIfeTssuiihyouumukbn(String pIfeTssuiihyouumukbn) {
        ifeTssuiihyouumukbn = pIfeTssuiihyouumukbn;
    }

    @Column(order = 11, label = "kanryoutuutiumukbn")
    private String ifeTskanryoutuutiumukbn;

    public String getIfeTskanryoutuutiumukbn() {
        return ifeTskanryoutuutiumukbn;
    }

    public void setIfeTskanryoutuutiumukbn(String pIfeTskanryoutuutiumukbn) {
        ifeTskanryoutuutiumukbn = pIfeTskanryoutuutiumukbn;
    }

    @Column(order = 12, label = "stdrsktirasidouhuukbn")
    private String ifeTsstdrsktirasidouhuukbn;

    public String getIfeTsstdrsktirasidouhuukbn() {
        return ifeTsstdrsktirasidouhuukbn;
    }

    public void setIfeTsstdrsktirasidouhuukbn(String pIfeTsstdrsktirasidouhuukbn) {
        ifeTsstdrsktirasidouhuukbn = pIfeTsstdrsktirasidouhuukbn;
    }

    @Column(order = 13, label = "dstirasidouhuukbn")
    private String ifeTsdstirasidouhuukbn;

    public String getIfeTsdstirasidouhuukbn() {
        return ifeTsdstirasidouhuukbn;
    }

    public void setIfeTsdstirasidouhuukbn(String pIfeTsdstirasidouhuukbn) {
        ifeTsdstirasidouhuukbn = pIfeTsdstirasidouhuukbn;
    }

    @Column(order = 14, label = "aisyoumeikbn")
    private String ifeTsaisyoumeikbn;

    public String getIfeTsaisyoumeikbn() {
        return ifeTsaisyoumeikbn;
    }

    public void setIfeTsaisyoumeikbn(String pIfeTsaisyoumeikbn) {
        ifeTsaisyoumeikbn = pIfeTsaisyoumeikbn;
    }

    @Column(order = 15, label = "syotnshuyoupostumukbn")
    private String ifeTssyotnshuyoupostumukbn;

    public String getIfeTssyotnshuyoupostumukbn() {
        return ifeTssyotnshuyoupostumukbn;
    }

    public void setIfeTssyotnshuyoupostumukbn(String pIfeTssyotnshuyoupostumukbn) {
        ifeTssyotnshuyoupostumukbn = pIfeTssyotnshuyoupostumukbn;
    }

    @Column(order = 16, label = "hyoujiranhidarimsgcd1")
    private String ifeTshyoujiranhidarimsgcd1;

    public String getIfeTshyoujiranhidarimsgcd1() {
        return ifeTshyoujiranhidarimsgcd1;
    }

    public void setIfeTshyoujiranhidarimsgcd1(String pIfeTshyoujiranhidarimsgcd1) {
        ifeTshyoujiranhidarimsgcd1 = pIfeTshyoujiranhidarimsgcd1;
    }

    @Column(order = 17, label = "hyoujiranhidarimsgcd2")
    private String ifeTshyoujiranhidarimsgcd2;

    public String getIfeTshyoujiranhidarimsgcd2() {
        return ifeTshyoujiranhidarimsgcd2;
    }

    public void setIfeTshyoujiranhidarimsgcd2(String pIfeTshyoujiranhidarimsgcd2) {
        ifeTshyoujiranhidarimsgcd2 = pIfeTshyoujiranhidarimsgcd2;
    }

    @Column(order = 18, label = "hyoujiranhidarimsgcd3")
    private String ifeTshyoujiranhidarimsgcd3;

    public String getIfeTshyoujiranhidarimsgcd3() {
        return ifeTshyoujiranhidarimsgcd3;
    }

    public void setIfeTshyoujiranhidarimsgcd3(String pIfeTshyoujiranhidarimsgcd3) {
        ifeTshyoujiranhidarimsgcd3 = pIfeTshyoujiranhidarimsgcd3;
    }

    @Column(order = 19, label = "hyoujiranhidarimsgcd4")
    private String ifeTshyoujiranhidarimsgcd4;

    public String getIfeTshyoujiranhidarimsgcd4() {
        return ifeTshyoujiranhidarimsgcd4;
    }

    public void setIfeTshyoujiranhidarimsgcd4(String pIfeTshyoujiranhidarimsgcd4) {
        ifeTshyoujiranhidarimsgcd4 = pIfeTshyoujiranhidarimsgcd4;
    }

    @Column(order = 20, label = "hyoujiranhidarimsgcd5")
    private String ifeTshyoujiranhidarimsgcd5;

    public String getIfeTshyoujiranhidarimsgcd5() {
        return ifeTshyoujiranhidarimsgcd5;
    }

    public void setIfeTshyoujiranhidarimsgcd5(String pIfeTshyoujiranhidarimsgcd5) {
        ifeTshyoujiranhidarimsgcd5 = pIfeTshyoujiranhidarimsgcd5;
    }

    @Column(order = 21, label = "hyoujiranhidarimsgcd6")
    private String ifeTshyoujiranhidarimsgcd6;

    public String getIfeTshyoujiranhidarimsgcd6() {
        return ifeTshyoujiranhidarimsgcd6;
    }

    public void setIfeTshyoujiranhidarimsgcd6(String pIfeTshyoujiranhidarimsgcd6) {
        ifeTshyoujiranhidarimsgcd6 = pIfeTshyoujiranhidarimsgcd6;
    }

    @Column(order = 22, label = "hyoujiranhidarimsgcd7")
    private String ifeTshyoujiranhidarimsgcd7;

    public String getIfeTshyoujiranhidarimsgcd7() {
        return ifeTshyoujiranhidarimsgcd7;
    }

    public void setIfeTshyoujiranhidarimsgcd7(String pIfeTshyoujiranhidarimsgcd7) {
        ifeTshyoujiranhidarimsgcd7 = pIfeTshyoujiranhidarimsgcd7;
    }

    @Column(order = 23, label = "hyoujiranhidarimsgcd8")
    private String ifeTshyoujiranhidarimsgcd8;

    public String getIfeTshyoujiranhidarimsgcd8() {
        return ifeTshyoujiranhidarimsgcd8;
    }

    public void setIfeTshyoujiranhidarimsgcd8(String pIfeTshyoujiranhidarimsgcd8) {
        ifeTshyoujiranhidarimsgcd8 = pIfeTshyoujiranhidarimsgcd8;
    }

    @Column(order = 24, label = "hyoujiranhidarimsgcd9")
    private String ifeTshyoujiranhidarimsgcd9;

    public String getIfeTshyoujiranhidarimsgcd9() {
        return ifeTshyoujiranhidarimsgcd9;
    }

    public void setIfeTshyoujiranhidarimsgcd9(String pIfeTshyoujiranhidarimsgcd9) {
        ifeTshyoujiranhidarimsgcd9 = pIfeTshyoujiranhidarimsgcd9;
    }

    @Column(order = 25, label = "hyoujiranhidarimsgcd10")
    private String ifeTshyoujiranhidarimsgcd10;

    public String getIfeTshyoujiranhidarimsgcd10() {
        return ifeTshyoujiranhidarimsgcd10;
    }

    public void setIfeTshyoujiranhidarimsgcd10(String pIfeTshyoujiranhidarimsgcd10) {
        ifeTshyoujiranhidarimsgcd10 = pIfeTshyoujiranhidarimsgcd10;
    }

    @Column(order = 26, label = "hyoujiranhidarimsgcd11")
    private String ifeTshyoujiranhidarimsgcd11;

    public String getIfeTshyoujiranhidarimsgcd11() {
        return ifeTshyoujiranhidarimsgcd11;
    }

    public void setIfeTshyoujiranhidarimsgcd11(String pIfeTshyoujiranhidarimsgcd11) {
        ifeTshyoujiranhidarimsgcd11 = pIfeTshyoujiranhidarimsgcd11;
    }

    @Column(order = 27, label = "hyoujiranhidarimsgcd12")
    private String ifeTshyoujiranhidarimsgcd12;

    public String getIfeTshyoujiranhidarimsgcd12() {
        return ifeTshyoujiranhidarimsgcd12;
    }

    public void setIfeTshyoujiranhidarimsgcd12(String pIfeTshyoujiranhidarimsgcd12) {
        ifeTshyoujiranhidarimsgcd12 = pIfeTshyoujiranhidarimsgcd12;
    }

    @Column(order = 28, label = "hyoujiranhidarimsgcd13")
    private String ifeTshyoujiranhidarimsgcd13;

    public String getIfeTshyoujiranhidarimsgcd13() {
        return ifeTshyoujiranhidarimsgcd13;
    }

    public void setIfeTshyoujiranhidarimsgcd13(String pIfeTshyoujiranhidarimsgcd13) {
        ifeTshyoujiranhidarimsgcd13 = pIfeTshyoujiranhidarimsgcd13;
    }

    @Column(order = 29, label = "hyoujiranhidarimsgcd14")
    private String ifeTshyoujiranhidarimsgcd14;

    public String getIfeTshyoujiranhidarimsgcd14() {
        return ifeTshyoujiranhidarimsgcd14;
    }

    public void setIfeTshyoujiranhidarimsgcd14(String pIfeTshyoujiranhidarimsgcd14) {
        ifeTshyoujiranhidarimsgcd14 = pIfeTshyoujiranhidarimsgcd14;
    }

    @Column(order = 30, label = "hyoujiranhidarimsgcd15")
    private String ifeTshyoujiranhidarimsgcd15;

    public String getIfeTshyoujiranhidarimsgcd15() {
        return ifeTshyoujiranhidarimsgcd15;
    }

    public void setIfeTshyoujiranhidarimsgcd15(String pIfeTshyoujiranhidarimsgcd15) {
        ifeTshyoujiranhidarimsgcd15 = pIfeTshyoujiranhidarimsgcd15;
    }

    @Column(order = 31, label = "hyoujiranhidarimsgcd16")
    private String ifeTshyoujiranhidarimsgcd16;

    public String getIfeTshyoujiranhidarimsgcd16() {
        return ifeTshyoujiranhidarimsgcd16;
    }

    public void setIfeTshyoujiranhidarimsgcd16(String pIfeTshyoujiranhidarimsgcd16) {
        ifeTshyoujiranhidarimsgcd16 = pIfeTshyoujiranhidarimsgcd16;
    }

    @Column(order = 32, label = "hyoujiranhidarimsgcd17")
    private String ifeTshyoujiranhidarimsgcd17;

    public String getIfeTshyoujiranhidarimsgcd17() {
        return ifeTshyoujiranhidarimsgcd17;
    }

    public void setIfeTshyoujiranhidarimsgcd17(String pIfeTshyoujiranhidarimsgcd17) {
        ifeTshyoujiranhidarimsgcd17 = pIfeTshyoujiranhidarimsgcd17;
    }

    @Column(order = 33, label = "hyoujiranhidarimsgcd18")
    private String ifeTshyoujiranhidarimsgcd18;

    public String getIfeTshyoujiranhidarimsgcd18() {
        return ifeTshyoujiranhidarimsgcd18;
    }

    public void setIfeTshyoujiranhidarimsgcd18(String pIfeTshyoujiranhidarimsgcd18) {
        ifeTshyoujiranhidarimsgcd18 = pIfeTshyoujiranhidarimsgcd18;
    }

    @Column(order = 34, label = "hyoujiranhidarimsgcd19")
    private String ifeTshyoujiranhidarimsgcd19;

    public String getIfeTshyoujiranhidarimsgcd19() {
        return ifeTshyoujiranhidarimsgcd19;
    }

    public void setIfeTshyoujiranhidarimsgcd19(String pIfeTshyoujiranhidarimsgcd19) {
        ifeTshyoujiranhidarimsgcd19 = pIfeTshyoujiranhidarimsgcd19;
    }

    @Column(order = 35, label = "hyoujiranhidarimsgcd20")
    private String ifeTshyoujiranhidarimsgcd20;

    public String getIfeTshyoujiranhidarimsgcd20() {
        return ifeTshyoujiranhidarimsgcd20;
    }

    public void setIfeTshyoujiranhidarimsgcd20(String pIfeTshyoujiranhidarimsgcd20) {
        ifeTshyoujiranhidarimsgcd20 = pIfeTshyoujiranhidarimsgcd20;
    }

    @Column(order = 36, label = "hyoujiranmigiimsgcd1")
    private String ifeTshyoujiranmigiimsgcd1;

    public String getIfeTshyoujiranmigiimsgcd1() {
        return ifeTshyoujiranmigiimsgcd1;
    }

    public void setIfeTshyoujiranmigiimsgcd1(String pIfeTshyoujiranmigiimsgcd1) {
        ifeTshyoujiranmigiimsgcd1 = pIfeTshyoujiranmigiimsgcd1;
    }

    @Column(order = 37, label = "hyoujiranmigiimsgcd2")
    private String ifeTshyoujiranmigiimsgcd2;

    public String getIfeTshyoujiranmigiimsgcd2() {
        return ifeTshyoujiranmigiimsgcd2;
    }

    public void setIfeTshyoujiranmigiimsgcd2(String pIfeTshyoujiranmigiimsgcd2) {
        ifeTshyoujiranmigiimsgcd2 = pIfeTshyoujiranmigiimsgcd2;
    }

    @Column(order = 38, label = "hyoujiranmigiimsgcd3")
    private String ifeTshyoujiranmigiimsgcd3;

    public String getIfeTshyoujiranmigiimsgcd3() {
        return ifeTshyoujiranmigiimsgcd3;
    }

    public void setIfeTshyoujiranmigiimsgcd3(String pIfeTshyoujiranmigiimsgcd3) {
        ifeTshyoujiranmigiimsgcd3 = pIfeTshyoujiranmigiimsgcd3;
    }

    @Column(order = 39, label = "hyoujiranmigiimsgcd4")
    private String ifeTshyoujiranmigiimsgcd4;

    public String getIfeTshyoujiranmigiimsgcd4() {
        return ifeTshyoujiranmigiimsgcd4;
    }

    public void setIfeTshyoujiranmigiimsgcd4(String pIfeTshyoujiranmigiimsgcd4) {
        ifeTshyoujiranmigiimsgcd4 = pIfeTshyoujiranmigiimsgcd4;
    }

    @Column(order = 40, label = "hyoujiranmigiimsgcd5")
    private String ifeTshyoujiranmigiimsgcd5;

    public String getIfeTshyoujiranmigiimsgcd5() {
        return ifeTshyoujiranmigiimsgcd5;
    }

    public void setIfeTshyoujiranmigiimsgcd5(String pIfeTshyoujiranmigiimsgcd5) {
        ifeTshyoujiranmigiimsgcd5 = pIfeTshyoujiranmigiimsgcd5;
    }

    @Column(order = 41, label = "hyoujiranmigiimsgcd6")
    private String ifeTshyoujiranmigiimsgcd6;

    public String getIfeTshyoujiranmigiimsgcd6() {
        return ifeTshyoujiranmigiimsgcd6;
    }

    public void setIfeTshyoujiranmigiimsgcd6(String pIfeTshyoujiranmigiimsgcd6) {
        ifeTshyoujiranmigiimsgcd6 = pIfeTshyoujiranmigiimsgcd6;
    }

    @Column(order = 42, label = "hyoujiranmigiimsgcd7")
    private String ifeTshyoujiranmigiimsgcd7;

    public String getIfeTshyoujiranmigiimsgcd7() {
        return ifeTshyoujiranmigiimsgcd7;
    }

    public void setIfeTshyoujiranmigiimsgcd7(String pIfeTshyoujiranmigiimsgcd7) {
        ifeTshyoujiranmigiimsgcd7 = pIfeTshyoujiranmigiimsgcd7;
    }

    @Column(order = 43, label = "hyoujiranmigiimsgcd8")
    private String ifeTshyoujiranmigiimsgcd8;

    public String getIfeTshyoujiranmigiimsgcd8() {
        return ifeTshyoujiranmigiimsgcd8;
    }

    public void setIfeTshyoujiranmigiimsgcd8(String pIfeTshyoujiranmigiimsgcd8) {
        ifeTshyoujiranmigiimsgcd8 = pIfeTshyoujiranmigiimsgcd8;
    }

    @Column(order = 44, label = "hyoujiranmigiimsgcd9")
    private String ifeTshyoujiranmigiimsgcd9;

    public String getIfeTshyoujiranmigiimsgcd9() {
        return ifeTshyoujiranmigiimsgcd9;
    }

    public void setIfeTshyoujiranmigiimsgcd9(String pIfeTshyoujiranmigiimsgcd9) {
        ifeTshyoujiranmigiimsgcd9 = pIfeTshyoujiranmigiimsgcd9;
    }

    @Column(order = 45, label = "hyoujiranmigiimsgcd10")
    private String ifeTshyoujiranmigiimsgcd10;

    public String getIfeTshyoujiranmigiimsgcd10() {
        return ifeTshyoujiranmigiimsgcd10;
    }

    public void setIfeTshyoujiranmigiimsgcd10(String pIfeTshyoujiranmigiimsgcd10) {
        ifeTshyoujiranmigiimsgcd10 = pIfeTshyoujiranmigiimsgcd10;
    }

    @Column(order = 46, label = "hyoujiranmigiimsgcd11")
    private String ifeTshyoujiranmigiimsgcd11;

    public String getIfeTshyoujiranmigiimsgcd11() {
        return ifeTshyoujiranmigiimsgcd11;
    }

    public void setIfeTshyoujiranmigiimsgcd11(String pIfeTshyoujiranmigiimsgcd11) {
        ifeTshyoujiranmigiimsgcd11 = pIfeTshyoujiranmigiimsgcd11;
    }

    @Column(order = 47, label = "hyoujiranmigiimsgcd12")
    private String ifeTshyoujiranmigiimsgcd12;

    public String getIfeTshyoujiranmigiimsgcd12() {
        return ifeTshyoujiranmigiimsgcd12;
    }

    public void setIfeTshyoujiranmigiimsgcd12(String pIfeTshyoujiranmigiimsgcd12) {
        ifeTshyoujiranmigiimsgcd12 = pIfeTshyoujiranmigiimsgcd12;
    }

    @Column(order = 48, label = "hyoujiranmigiimsgcd13")
    private String ifeTshyoujiranmigiimsgcd13;

    public String getIfeTshyoujiranmigiimsgcd13() {
        return ifeTshyoujiranmigiimsgcd13;
    }

    public void setIfeTshyoujiranmigiimsgcd13(String pIfeTshyoujiranmigiimsgcd13) {
        ifeTshyoujiranmigiimsgcd13 = pIfeTshyoujiranmigiimsgcd13;
    }

    @Column(order = 49, label = "hyoujiranmigiimsgcd14")
    private String ifeTshyoujiranmigiimsgcd14;

    public String getIfeTshyoujiranmigiimsgcd14() {
        return ifeTshyoujiranmigiimsgcd14;
    }

    public void setIfeTshyoujiranmigiimsgcd14(String pIfeTshyoujiranmigiimsgcd14) {
        ifeTshyoujiranmigiimsgcd14 = pIfeTshyoujiranmigiimsgcd14;
    }

    @Column(order = 50, label = "hyoujiranmigiimsgcd15")
    private String ifeTshyoujiranmigiimsgcd15;

    public String getIfeTshyoujiranmigiimsgcd15() {
        return ifeTshyoujiranmigiimsgcd15;
    }

    public void setIfeTshyoujiranmigiimsgcd15(String pIfeTshyoujiranmigiimsgcd15) {
        ifeTshyoujiranmigiimsgcd15 = pIfeTshyoujiranmigiimsgcd15;
    }

    @Column(order = 51, label = "hyoujiranmigiimsgcd16")
    private String ifeTshyoujiranmigiimsgcd16;

    public String getIfeTshyoujiranmigiimsgcd16() {
        return ifeTshyoujiranmigiimsgcd16;
    }

    public void setIfeTshyoujiranmigiimsgcd16(String pIfeTshyoujiranmigiimsgcd16) {
        ifeTshyoujiranmigiimsgcd16 = pIfeTshyoujiranmigiimsgcd16;
    }

    @Column(order = 52, label = "hyoujiranmigiimsgcd17")
    private String ifeTshyoujiranmigiimsgcd17;

    public String getIfeTshyoujiranmigiimsgcd17() {
        return ifeTshyoujiranmigiimsgcd17;
    }

    public void setIfeTshyoujiranmigiimsgcd17(String pIfeTshyoujiranmigiimsgcd17) {
        ifeTshyoujiranmigiimsgcd17 = pIfeTshyoujiranmigiimsgcd17;
    }

    @Column(order = 53, label = "hyoujiranmigiimsgcd18")
    private String ifeTshyoujiranmigiimsgcd18;

    public String getIfeTshyoujiranmigiimsgcd18() {
        return ifeTshyoujiranmigiimsgcd18;
    }

    public void setIfeTshyoujiranmigiimsgcd18(String pIfeTshyoujiranmigiimsgcd18) {
        ifeTshyoujiranmigiimsgcd18 = pIfeTshyoujiranmigiimsgcd18;
    }

    @Column(order = 54, label = "hyoujiranmigiimsgcd19")
    private String ifeTshyoujiranmigiimsgcd19;

    public String getIfeTshyoujiranmigiimsgcd19() {
        return ifeTshyoujiranmigiimsgcd19;
    }

    public void setIfeTshyoujiranmigiimsgcd19(String pIfeTshyoujiranmigiimsgcd19) {
        ifeTshyoujiranmigiimsgcd19 = pIfeTshyoujiranmigiimsgcd19;
    }

    @Column(order = 55, label = "hyoujiranmigiimsgcd20")
    private String ifeTshyoujiranmigiimsgcd20;

    public String getIfeTshyoujiranmigiimsgcd20() {
        return ifeTshyoujiranmigiimsgcd20;
    }

    public void setIfeTshyoujiranmigiimsgcd20(String pIfeTshyoujiranmigiimsgcd20) {
        ifeTshyoujiranmigiimsgcd20 = pIfeTshyoujiranmigiimsgcd20;
    }

    @Column(order = 56, label = "hyoujiransknnkaisiymd")
    private String ifeTshyoujiransknnkaisiymd;

    public String getIfeTshyoujiransknnkaisiymd() {
        return ifeTshyoujiransknnkaisiymd;
    }

    public void setIfeTshyoujiransknnkaisiymd(String pIfeTshyoujiransknnkaisiymd) {
        ifeTshyoujiransknnkaisiymd = pIfeTshyoujiransknnkaisiymd;
    }

    @Column(order = 57, label = "hyoujiranyoteiriritu")
    private String ifeTshyoujiranyoteiriritu;

    public String getIfeTshyoujiranyoteiriritu() {
        return ifeTshyoujiranyoteiriritu;
    }

    public void setIfeTshyoujiranyoteiriritu(String pIfeTshyoujiranyoteiriritu) {
        ifeTshyoujiranyoteiriritu = pIfeTshyoujiranyoteiriritu;
    }

    @Column(order = 58, label = "hyoujiransjkkktusirrt")
    private String ifeTshyoujiransjkkktusirrt;

    public String getIfeTshyoujiransjkkktusirrt() {
        return ifeTshyoujiransjkkktusirrt;
    }

    public void setIfeTshyoujiransjkkktusirrt(String pIfeTshyoujiransjkkktusirrt) {
        ifeTshyoujiransjkkktusirrt = pIfeTshyoujiransjkkktusirrt;
    }

    @Column(order = 59, label = "hknsyukigou")
    private String ifeTshknsyukigou;

    public String getIfeTshknsyukigou() {
        return ifeTshknsyukigou;
    }

    public void setIfeTshknsyukigou(String pIfeTshknsyukigou) {
        ifeTshknsyukigou = pIfeTshknsyukigou;
    }

    @Column(order = 60, label = "syohakkouymd")
    private String ifeTssyohakkouymd;

    public String getIfeTssyohakkouymd() {
        return ifeTssyohakkouymd;
    }

    public void setIfeTssyohakkouymd(String pIfeTssyohakkouymd) {
        ifeTssyohakkouymd = pIfeTssyohakkouymd;
    }

    @Column(order = 61, label = "hanbainm")
    private String ifeTshanbainm;

    public String getIfeTshanbainm() {
        return ifeTshanbainm;
    }

    public void setIfeTshanbainm(String pIfeTshanbainm) {
        ifeTshanbainm = pIfeTshanbainm;
    }

    @Column(order = 62, label = "seisikihknnm")
    private String ifeTsseisikihknnm;

    public String getIfeTsseisikihknnm() {
        return ifeTsseisikihknnm;
    }

    public void setIfeTsseisikihknnm(String pIfeTsseisikihknnm) {
        ifeTsseisikihknnm = pIfeTsseisikihknnm;
    }

    @Column(order = 63, label = "kouryokukaisiymd")
    private String ifeTskouryokukaisiymd;

    public String getIfeTskouryokukaisiymd() {
        return ifeTskouryokukaisiymd;
    }

    public void setIfeTskouryokukaisiymd(String pIfeTskouryokukaisiymd) {
        ifeTskouryokukaisiymd = pIfeTskouryokukaisiymd;
    }

    @Column(order = 64, label = "kyknmkj")
    private String ifeTskyknmkj;

    public String getIfeTskyknmkj() {
        return ifeTskyknmkj;
    }

    public void setIfeTskyknmkj(String pIfeTskyknmkj) {
        ifeTskyknmkj = pIfeTskyknmkj;
    }

    @Column(order = 65, label = "kyknmkjkhukakbn")
    private String ifeTskyknmkjkhukakbn;

    public String getIfeTskyknmkjkhukakbn() {
        return ifeTskyknmkjkhukakbn;
    }

    public void setIfeTskyknmkjkhukakbn(String pIfeTskyknmkjkhukakbn) {
        ifeTskyknmkjkhukakbn = pIfeTskyknmkjkhukakbn;
    }

    @Column(order = 66, label = "hhknnmkj")
    private String ifeTshhknnmkj;

    public String getIfeTshhknnmkj() {
        return ifeTshhknnmkj;
    }

    public void setIfeTshhknnmkj(String pIfeTshhknnmkj) {
        ifeTshhknnmkj = pIfeTshhknnmkj;
    }

    @Column(order = 67, label = "hhknnmkjkhukakbn")
    private String ifeTshhknnmkjkhukakbn;

    public String getIfeTshhknnmkjkhukakbn() {
        return ifeTshhknnmkjkhukakbn;
    }

    public void setIfeTshhknnmkjkhukakbn(String pIfeTshhknnmkjkhukakbn) {
        ifeTshhknnmkjkhukakbn = pIfeTshhknnmkjkhukakbn;
    }

    @Column(order = 68, label = "hhknseiymd")
    private String ifeTshhknseiymd;

    public String getIfeTshhknseiymd() {
        return ifeTshhknseiymd;
    }

    public void setIfeTshhknseiymd(String pIfeTshhknseiymd) {
        ifeTshhknseiymd = pIfeTshhknseiymd;
    }

    @Column(order = 69, label = "hhknsei")
    private String ifeTshhknsei;

    public String getIfeTshhknsei() {
        return ifeTshhknsei;
    }

    public void setIfeTshhknsei(String pIfeTshhknsei) {
        ifeTshhknsei = pIfeTshhknsei;
    }

    @Column(order = 70, label = "hhknnen")
    private String ifeTshhknnen;

    public String getIfeTshhknnen() {
        return ifeTshhknnen;
    }

    public void setIfeTshhknnen(String pIfeTshhknnen) {
        ifeTshhknnen = pIfeTshhknnen;
    }

    @Column(order = 71, label = "syoukenuktmidasikbn1")
    private String ifeTssyoukenuktmidasikbn1;

    public String getIfeTssyoukenuktmidasikbn1() {
        return ifeTssyoukenuktmidasikbn1;
    }

    public void setIfeTssyoukenuktmidasikbn1(String pIfeTssyoukenuktmidasikbn1) {
        ifeTssyoukenuktmidasikbn1 = pIfeTssyoukenuktmidasikbn1;
    }

    @Column(order = 72, label = "syoukenuktkbn1")
    private String ifeTssyoukenuktkbn1;

    public String getIfeTssyoukenuktkbn1() {
        return ifeTssyoukenuktkbn1;
    }

    public void setIfeTssyoukenuktkbn1(String pIfeTssyoukenuktkbn1) {
        ifeTssyoukenuktkbn1 = pIfeTssyoukenuktkbn1;
    }

    @Column(order = 73, label = "syoukenuktnm1")
    private String ifeTssyoukenuktnm1;

    public String getIfeTssyoukenuktnm1() {
        return ifeTssyoukenuktnm1;
    }

    public void setIfeTssyoukenuktnm1(String pIfeTssyoukenuktnm1) {
        ifeTssyoukenuktnm1 = pIfeTssyoukenuktnm1;
    }

    @Column(order = 74, label = "syoukenuktbnwari1")
    private String ifeTssyoukenuktbnwari1;

    public String getIfeTssyoukenuktbnwari1() {
        return ifeTssyoukenuktbnwari1;
    }

    public void setIfeTssyoukenuktbnwari1(String pIfeTssyoukenuktbnwari1) {
        ifeTssyoukenuktbnwari1 = pIfeTssyoukenuktbnwari1;
    }

    @Column(order = 75, label = "syoukenuktmidasikbn2")
    private String ifeTssyoukenuktmidasikbn2;

    public String getIfeTssyoukenuktmidasikbn2() {
        return ifeTssyoukenuktmidasikbn2;
    }

    public void setIfeTssyoukenuktmidasikbn2(String pIfeTssyoukenuktmidasikbn2) {
        ifeTssyoukenuktmidasikbn2 = pIfeTssyoukenuktmidasikbn2;
    }

    @Column(order = 76, label = "syoukenuktkbn2")
    private String ifeTssyoukenuktkbn2;

    public String getIfeTssyoukenuktkbn2() {
        return ifeTssyoukenuktkbn2;
    }

    public void setIfeTssyoukenuktkbn2(String pIfeTssyoukenuktkbn2) {
        ifeTssyoukenuktkbn2 = pIfeTssyoukenuktkbn2;
    }

    @Column(order = 77, label = "syoukenuktnm2")
    private String ifeTssyoukenuktnm2;

    public String getIfeTssyoukenuktnm2() {
        return ifeTssyoukenuktnm2;
    }

    public void setIfeTssyoukenuktnm2(String pIfeTssyoukenuktnm2) {
        ifeTssyoukenuktnm2 = pIfeTssyoukenuktnm2;
    }

    @Column(order = 78, label = "syoukenuktbnwari2")
    private String ifeTssyoukenuktbnwari2;

    public String getIfeTssyoukenuktbnwari2() {
        return ifeTssyoukenuktbnwari2;
    }

    public void setIfeTssyoukenuktbnwari2(String pIfeTssyoukenuktbnwari2) {
        ifeTssyoukenuktbnwari2 = pIfeTssyoukenuktbnwari2;
    }

    @Column(order = 79, label = "syoukenuktmidasikbn3")
    private String ifeTssyoukenuktmidasikbn3;

    public String getIfeTssyoukenuktmidasikbn3() {
        return ifeTssyoukenuktmidasikbn3;
    }

    public void setIfeTssyoukenuktmidasikbn3(String pIfeTssyoukenuktmidasikbn3) {
        ifeTssyoukenuktmidasikbn3 = pIfeTssyoukenuktmidasikbn3;
    }

    @Column(order = 80, label = "syoukenuktkbn3")
    private String ifeTssyoukenuktkbn3;

    public String getIfeTssyoukenuktkbn3() {
        return ifeTssyoukenuktkbn3;
    }

    public void setIfeTssyoukenuktkbn3(String pIfeTssyoukenuktkbn3) {
        ifeTssyoukenuktkbn3 = pIfeTssyoukenuktkbn3;
    }

    @Column(order = 81, label = "syoukenuktnm3")
    private String ifeTssyoukenuktnm3;

    public String getIfeTssyoukenuktnm3() {
        return ifeTssyoukenuktnm3;
    }

    public void setIfeTssyoukenuktnm3(String pIfeTssyoukenuktnm3) {
        ifeTssyoukenuktnm3 = pIfeTssyoukenuktnm3;
    }

    @Column(order = 82, label = "syoukenuktbnwari3")
    private String ifeTssyoukenuktbnwari3;

    public String getIfeTssyoukenuktbnwari3() {
        return ifeTssyoukenuktbnwari3;
    }

    public void setIfeTssyoukenuktbnwari3(String pIfeTssyoukenuktbnwari3) {
        ifeTssyoukenuktbnwari3 = pIfeTssyoukenuktbnwari3;
    }

    @Column(order = 83, label = "syoukenuktmidasikbn4")
    private String ifeTssyoukenuktmidasikbn4;

    public String getIfeTssyoukenuktmidasikbn4() {
        return ifeTssyoukenuktmidasikbn4;
    }

    public void setIfeTssyoukenuktmidasikbn4(String pIfeTssyoukenuktmidasikbn4) {
        ifeTssyoukenuktmidasikbn4 = pIfeTssyoukenuktmidasikbn4;
    }

    @Column(order = 84, label = "syoukenuktkbn4")
    private String ifeTssyoukenuktkbn4;

    public String getIfeTssyoukenuktkbn4() {
        return ifeTssyoukenuktkbn4;
    }

    public void setIfeTssyoukenuktkbn4(String pIfeTssyoukenuktkbn4) {
        ifeTssyoukenuktkbn4 = pIfeTssyoukenuktkbn4;
    }

    @Column(order = 85, label = "syoukenuktnm4")
    private String ifeTssyoukenuktnm4;

    public String getIfeTssyoukenuktnm4() {
        return ifeTssyoukenuktnm4;
    }

    public void setIfeTssyoukenuktnm4(String pIfeTssyoukenuktnm4) {
        ifeTssyoukenuktnm4 = pIfeTssyoukenuktnm4;
    }

    @Column(order = 86, label = "syoukenuktbnwari4")
    private String ifeTssyoukenuktbnwari4;

    public String getIfeTssyoukenuktbnwari4() {
        return ifeTssyoukenuktbnwari4;
    }

    public void setIfeTssyoukenuktbnwari4(String pIfeTssyoukenuktbnwari4) {
        ifeTssyoukenuktbnwari4 = pIfeTssyoukenuktbnwari4;
    }

    @Column(order = 87, label = "syoukenuktmidasikbn5")
    private String ifeTssyoukenuktmidasikbn5;

    public String getIfeTssyoukenuktmidasikbn5() {
        return ifeTssyoukenuktmidasikbn5;
    }

    public void setIfeTssyoukenuktmidasikbn5(String pIfeTssyoukenuktmidasikbn5) {
        ifeTssyoukenuktmidasikbn5 = pIfeTssyoukenuktmidasikbn5;
    }

    @Column(order = 88, label = "syoukenuktkbn5")
    private String ifeTssyoukenuktkbn5;

    public String getIfeTssyoukenuktkbn5() {
        return ifeTssyoukenuktkbn5;
    }

    public void setIfeTssyoukenuktkbn5(String pIfeTssyoukenuktkbn5) {
        ifeTssyoukenuktkbn5 = pIfeTssyoukenuktkbn5;
    }

    @Column(order = 89, label = "syoukenuktnm5")
    private String ifeTssyoukenuktnm5;

    public String getIfeTssyoukenuktnm5() {
        return ifeTssyoukenuktnm5;
    }

    public void setIfeTssyoukenuktnm5(String pIfeTssyoukenuktnm5) {
        ifeTssyoukenuktnm5 = pIfeTssyoukenuktnm5;
    }

    @Column(order = 90, label = "syoukenuktbnwari5")
    private String ifeTssyoukenuktbnwari5;

    public String getIfeTssyoukenuktbnwari5() {
        return ifeTssyoukenuktbnwari5;
    }

    public void setIfeTssyoukenuktbnwari5(String pIfeTssyoukenuktbnwari5) {
        ifeTssyoukenuktbnwari5 = pIfeTssyoukenuktbnwari5;
    }

    @Column(order = 91, label = "syoukenuktmidasikbn6")
    private String ifeTssyoukenuktmidasikbn6;

    public String getIfeTssyoukenuktmidasikbn6() {
        return ifeTssyoukenuktmidasikbn6;
    }

    public void setIfeTssyoukenuktmidasikbn6(String pIfeTssyoukenuktmidasikbn6) {
        ifeTssyoukenuktmidasikbn6 = pIfeTssyoukenuktmidasikbn6;
    }

    @Column(order = 92, label = "syoukenuktkbn6")
    private String ifeTssyoukenuktkbn6;

    public String getIfeTssyoukenuktkbn6() {
        return ifeTssyoukenuktkbn6;
    }

    public void setIfeTssyoukenuktkbn6(String pIfeTssyoukenuktkbn6) {
        ifeTssyoukenuktkbn6 = pIfeTssyoukenuktkbn6;
    }

    @Column(order = 93, label = "syoukenuktnm6")
    private String ifeTssyoukenuktnm6;

    public String getIfeTssyoukenuktnm6() {
        return ifeTssyoukenuktnm6;
    }

    public void setIfeTssyoukenuktnm6(String pIfeTssyoukenuktnm6) {
        ifeTssyoukenuktnm6 = pIfeTssyoukenuktnm6;
    }

    @Column(order = 94, label = "syoukenuktbnwari6")
    private String ifeTssyoukenuktbnwari6;

    public String getIfeTssyoukenuktbnwari6() {
        return ifeTssyoukenuktbnwari6;
    }

    public void setIfeTssyoukenuktbnwari6(String pIfeTssyoukenuktbnwari6) {
        ifeTssyoukenuktbnwari6 = pIfeTssyoukenuktbnwari6;
    }

    @Column(order = 95, label = "syoukenuktmidasikbn7")
    private String ifeTssyoukenuktmidasikbn7;

    public String getIfeTssyoukenuktmidasikbn7() {
        return ifeTssyoukenuktmidasikbn7;
    }

    public void setIfeTssyoukenuktmidasikbn7(String pIfeTssyoukenuktmidasikbn7) {
        ifeTssyoukenuktmidasikbn7 = pIfeTssyoukenuktmidasikbn7;
    }

    @Column(order = 96, label = "syoukenuktkbn7")
    private String ifeTssyoukenuktkbn7;

    public String getIfeTssyoukenuktkbn7() {
        return ifeTssyoukenuktkbn7;
    }

    public void setIfeTssyoukenuktkbn7(String pIfeTssyoukenuktkbn7) {
        ifeTssyoukenuktkbn7 = pIfeTssyoukenuktkbn7;
    }

    @Column(order = 97, label = "syoukenuktnm7")
    private String ifeTssyoukenuktnm7;

    public String getIfeTssyoukenuktnm7() {
        return ifeTssyoukenuktnm7;
    }

    public void setIfeTssyoukenuktnm7(String pIfeTssyoukenuktnm7) {
        ifeTssyoukenuktnm7 = pIfeTssyoukenuktnm7;
    }

    @Column(order = 98, label = "syoukenuktbnwari7")
    private String ifeTssyoukenuktbnwari7;

    public String getIfeTssyoukenuktbnwari7() {
        return ifeTssyoukenuktbnwari7;
    }

    public void setIfeTssyoukenuktbnwari7(String pIfeTssyoukenuktbnwari7) {
        ifeTssyoukenuktbnwari7 = pIfeTssyoukenuktbnwari7;
    }

    @Column(order = 99, label = "syoukenuktmidasikbn8")
    private String ifeTssyoukenuktmidasikbn8;

    public String getIfeTssyoukenuktmidasikbn8() {
        return ifeTssyoukenuktmidasikbn8;
    }

    public void setIfeTssyoukenuktmidasikbn8(String pIfeTssyoukenuktmidasikbn8) {
        ifeTssyoukenuktmidasikbn8 = pIfeTssyoukenuktmidasikbn8;
    }

    @Column(order = 100, label = "syoukenuktkbn8")
    private String ifeTssyoukenuktkbn8;

    public String getIfeTssyoukenuktkbn8() {
        return ifeTssyoukenuktkbn8;
    }

    public void setIfeTssyoukenuktkbn8(String pIfeTssyoukenuktkbn8) {
        ifeTssyoukenuktkbn8 = pIfeTssyoukenuktkbn8;
    }

    @Column(order = 101, label = "syoukenuktnm8")
    private String ifeTssyoukenuktnm8;

    public String getIfeTssyoukenuktnm8() {
        return ifeTssyoukenuktnm8;
    }

    public void setIfeTssyoukenuktnm8(String pIfeTssyoukenuktnm8) {
        ifeTssyoukenuktnm8 = pIfeTssyoukenuktnm8;
    }

    @Column(order = 102, label = "syoukenuktbnwari8")
    private String ifeTssyoukenuktbnwari8;

    public String getIfeTssyoukenuktbnwari8() {
        return ifeTssyoukenuktbnwari8;
    }

    public void setIfeTssyoukenuktbnwari8(String pIfeTssyoukenuktbnwari8) {
        ifeTssyoukenuktbnwari8 = pIfeTssyoukenuktbnwari8;
    }

    @Column(order = 103, label = "syoukenuktmidasikbn9")
    private String ifeTssyoukenuktmidasikbn9;

    public String getIfeTssyoukenuktmidasikbn9() {
        return ifeTssyoukenuktmidasikbn9;
    }

    public void setIfeTssyoukenuktmidasikbn9(String pIfeTssyoukenuktmidasikbn9) {
        ifeTssyoukenuktmidasikbn9 = pIfeTssyoukenuktmidasikbn9;
    }

    @Column(order = 104, label = "syoukenuktkbn9")
    private String ifeTssyoukenuktkbn9;

    public String getIfeTssyoukenuktkbn9() {
        return ifeTssyoukenuktkbn9;
    }

    public void setIfeTssyoukenuktkbn9(String pIfeTssyoukenuktkbn9) {
        ifeTssyoukenuktkbn9 = pIfeTssyoukenuktkbn9;
    }

    @Column(order = 105, label = "syoukenuktnm9")
    private String ifeTssyoukenuktnm9;

    public String getIfeTssyoukenuktnm9() {
        return ifeTssyoukenuktnm9;
    }

    public void setIfeTssyoukenuktnm9(String pIfeTssyoukenuktnm9) {
        ifeTssyoukenuktnm9 = pIfeTssyoukenuktnm9;
    }

    @Column(order = 106, label = "syoukenuktbnwari9")
    private String ifeTssyoukenuktbnwari9;

    public String getIfeTssyoukenuktbnwari9() {
        return ifeTssyoukenuktbnwari9;
    }

    public void setIfeTssyoukenuktbnwari9(String pIfeTssyoukenuktbnwari9) {
        ifeTssyoukenuktbnwari9 = pIfeTssyoukenuktbnwari9;
    }

    @Column(order = 107, label = "syoukenuktmidasikbn10")
    private String ifeTssyoukenuktmidasikbn10;

    public String getIfeTssyoukenuktmidasikbn10() {
        return ifeTssyoukenuktmidasikbn10;
    }

    public void setIfeTssyoukenuktmidasikbn10(String pIfeTssyoukenuktmidasikbn10) {
        ifeTssyoukenuktmidasikbn10 = pIfeTssyoukenuktmidasikbn10;
    }

    @Column(order = 108, label = "syoukenuktkbn10")
    private String ifeTssyoukenuktkbn10;

    public String getIfeTssyoukenuktkbn10() {
        return ifeTssyoukenuktkbn10;
    }

    public void setIfeTssyoukenuktkbn10(String pIfeTssyoukenuktkbn10) {
        ifeTssyoukenuktkbn10 = pIfeTssyoukenuktkbn10;
    }

    @Column(order = 109, label = "syoukenuktnm10")
    private String ifeTssyoukenuktnm10;

    public String getIfeTssyoukenuktnm10() {
        return ifeTssyoukenuktnm10;
    }

    public void setIfeTssyoukenuktnm10(String pIfeTssyoukenuktnm10) {
        ifeTssyoukenuktnm10 = pIfeTssyoukenuktnm10;
    }

    @Column(order = 110, label = "syoukenuktbnwari10")
    private String ifeTssyoukenuktbnwari10;

    public String getIfeTssyoukenuktbnwari10() {
        return ifeTssyoukenuktbnwari10;
    }

    public void setIfeTssyoukenuktbnwari10(String pIfeTssyoukenuktbnwari10) {
        ifeTssyoukenuktbnwari10 = pIfeTssyoukenuktbnwari10;
    }

    @Column(order = 111, label = "pmsgcd1")
    private String ifeTspmsgcd1;

    public String getIfeTspmsgcd1() {
        return ifeTspmsgcd1;
    }

    public void setIfeTspmsgcd1(String pIfeTspmsgcd1) {
        ifeTspmsgcd1 = pIfeTspmsgcd1;
    }

    @Column(order = 112, label = "pmsgcd2")
    private String ifeTspmsgcd2;

    public String getIfeTspmsgcd2() {
        return ifeTspmsgcd2;
    }

    public void setIfeTspmsgcd2(String pIfeTspmsgcd2) {
        ifeTspmsgcd2 = pIfeTspmsgcd2;
    }

    @Column(order = 113, label = "pmsgcd3")
    private String ifeTspmsgcd3;

    public String getIfeTspmsgcd3() {
        return ifeTspmsgcd3;
    }

    public void setIfeTspmsgcd3(String pIfeTspmsgcd3) {
        ifeTspmsgcd3 = pIfeTspmsgcd3;
    }

    @Column(order = 114, label = "ptuukatype")
    private String ifeTsptuukatype;

    public String getIfeTsptuukatype() {
        return ifeTsptuukatype;
    }

    public void setIfeTsptuukatype(String pIfeTsptuukatype) {
        ifeTsptuukatype = pIfeTsptuukatype;
    }

    @Column(order = 115, label = "hokenryou")
    private String ifeTshokenryou;

    public String getIfeTshokenryou() {
        return ifeTshokenryou;
    }

    public void setIfeTshokenryou(String pIfeTshokenryou) {
        ifeTshokenryou = pIfeTshokenryou;
    }

    @Column(order = 116, label = "hokenryou$")
    private String ifeTshokenryout;

    public String getIfeTshokenryout() {
        return ifeTshokenryout;
    }

    public void setIfeTshokenryout(String pIfeTshokenryout) {
        ifeTshokenryout = pIfeTshokenryout;
    }

    @Column(order = 117, label = "ptuuka")
    private String ifeTsptuuka;

    public String getIfeTsptuuka() {
        return ifeTsptuuka;
    }

    public void setIfeTsptuuka(String pIfeTsptuuka) {
        ifeTsptuuka = pIfeTsptuuka;
    }

    @Column(order = 118, label = "ptokuyakumsgcd")
    private String ifeTsptokuyakumsgcd;

    public String getIfeTsptokuyakumsgcd() {
        return ifeTsptokuyakumsgcd;
    }

    public void setIfeTsptokuyakumsgcd(String pIfeTsptokuyakumsgcd) {
        ifeTsptokuyakumsgcd = pIfeTsptokuyakumsgcd;
    }

    @Column(order = 119, label = "kykymd")
    private String ifeTskykymd;

    public String getIfeTskykymd() {
        return ifeTskykymd;
    }

    public void setIfeTskykymd(String pIfeTskykymd) {
        ifeTskykymd = pIfeTskykymd;
    }

    @Column(order = 120, label = "phrkkknmidasikbn")
    private String ifeTsphrkkknmidasikbn;

    public String getIfeTsphrkkknmidasikbn() {
        return ifeTsphrkkknmidasikbn;
    }

    public void setIfeTsphrkkknmidasikbn(String pIfeTsphrkkknmidasikbn) {
        ifeTsphrkkknmidasikbn = pIfeTsphrkkknmidasikbn;
    }

    @Column(order = 121, label = "hrkkknmsgkbn")
    private String ifeTshrkkknmsgkbn;

    public String getIfeTshrkkknmsgkbn() {
        return ifeTshrkkknmsgkbn;
    }

    public void setIfeTshrkkknmsgkbn(String pIfeTshrkkknmsgkbn) {
        ifeTshrkkknmsgkbn = pIfeTshrkkknmsgkbn;
    }

    @Column(order = 122, label = "hrkkaisuumsgkbn")
    private String ifeTshrkkaisuumsgkbn;

    public String getIfeTshrkkaisuumsgkbn() {
        return ifeTshrkkaisuumsgkbn;
    }

    public void setIfeTshrkkaisuumsgkbn(String pIfeTshrkkaisuumsgkbn) {
        ifeTshrkkaisuumsgkbn = pIfeTshrkkaisuumsgkbn;
    }

    @Column(order = 123, label = "hrkkitukimsgkbn")
    private String ifeTshrkkitukimsgkbn;

    public String getIfeTshrkkitukimsgkbn() {
        return ifeTshrkkitukimsgkbn;
    }

    public void setIfeTshrkkitukimsgkbn(String pIfeTshrkkitukimsgkbn) {
        ifeTshrkkitukimsgkbn = pIfeTshrkkitukimsgkbn;
    }

    @Column(order = 124, label = "hrkhouhoumsgkbn")
    private String ifeTshrkhouhoumsgkbn;

    public String getIfeTshrkhouhoumsgkbn() {
        return ifeTshrkhouhoumsgkbn;
    }

    public void setIfeTshrkhouhoumsgkbn(String pIfeTshrkhouhoumsgkbn) {
        ifeTshrkhouhoumsgkbn = pIfeTshrkhouhoumsgkbn;
    }

    @Column(order = 125, label = "syukyktkykrenban1")
    private String ifeTssyukyktkykrenban1;

    public String getIfeTssyukyktkykrenban1() {
        return ifeTssyukyktkykrenban1;
    }

    public void setIfeTssyukyktkykrenban1(String pIfeTssyukyktkykrenban1) {
        ifeTssyukyktkykrenban1 = pIfeTssyukyktkykrenban1;
    }

    @Column(order = 126, label = "syukyktkykmsgkbn1")
    private String ifeTssyukyktkykmsgkbn1;

    public String getIfeTssyukyktkykmsgkbn1() {
        return ifeTssyukyktkykmsgkbn1;
    }

    public void setIfeTssyukyktkykmsgkbn1(String pIfeTssyukyktkykmsgkbn1) {
        ifeTssyukyktkykmsgkbn1 = pIfeTssyukyktkykmsgkbn1;
    }

    @Column(order = 127, label = "syukyktkyksmsgkbn1")
    private String ifeTssyukyktkyksmsgkbn1;

    public String getIfeTssyukyktkyksmsgkbn1() {
        return ifeTssyukyktkyksmsgkbn1;
    }

    public void setIfeTssyukyktkyksmsgkbn1(String pIfeTssyukyktkyksmsgkbn1) {
        ifeTssyukyktkyksmsgkbn1 = pIfeTssyukyktkyksmsgkbn1;
    }

    @Column(order = 128, label = "syukyktkykhknkknmsgkbn1")
    private String ifeTssykyktkykhknkknmsgkbn1;

    public String getIfeTssykyktkykhknkknmsgkbn1() {
        return ifeTssykyktkykhknkknmsgkbn1;
    }

    public void setIfeTssykyktkykhknkknmsgkbn1(String pIfeTssykyktkykhknkknmsgkbn1) {
        ifeTssykyktkykhknkknmsgkbn1 = pIfeTssykyktkykhknkknmsgkbn1;
    }

    @Column(order = 129, label = "syukyktkykstuukatype1")
    private String ifeTssyukyktkykstuukatype1;

    public String getIfeTssyukyktkykstuukatype1() {
        return ifeTssyukyktkykstuukatype1;
    }

    public void setIfeTssyukyktkykstuukatype1(String pIfeTssyukyktkykstuukatype1) {
        ifeTssyukyktkykstuukatype1 = pIfeTssyukyktkykstuukatype1;
    }

    @Column(order = 130, label = "syukyktkykhknkngk1")
    private String ifeTssyukyktkykhknkngk1;

    public String getIfeTssyukyktkykhknkngk1() {
        return ifeTssyukyktkykhknkngk1;
    }

    public void setIfeTssyukyktkykhknkngk1(String pIfeTssyukyktkykhknkngk1) {
        ifeTssyukyktkykhknkngk1 = pIfeTssyukyktkykhknkngk1;
    }

    @Column(order = 131, label = "syukyktkykhknkngk1$")
    private String ifeTssyukyktkykhknkngk1t;

    public String getIfeTssyukyktkykhknkngk1t() {
        return ifeTssyukyktkykhknkngk1t;
    }

    public void setIfeTssyukyktkykhknkngk1t(String pIfeTssyukyktkykhknkngk1t) {
        ifeTssyukyktkykhknkngk1t = pIfeTssyukyktkykhknkngk1t;
    }

    @Column(order = 132, label = "syukyktkykdai1hknkkn1")
    private String ifeTssyukyktkykdai1hknkkn1;

    public String getIfeTssyukyktkykdai1hknkkn1() {
        return ifeTssyukyktkykdai1hknkkn1;
    }

    public void setIfeTssyukyktkykdai1hknkkn1(String pIfeTssyukyktkykdai1hknkkn1) {
        ifeTssyukyktkykdai1hknkkn1 = pIfeTssyukyktkykdai1hknkkn1;
    }

    @Column(order = 133, label = "syukyktkykdai2hknkkn1")
    private String ifeTssyukyktkykdai2hknkkn1;

    public String getIfeTssyukyktkykdai2hknkkn1() {
        return ifeTssyukyktkykdai2hknkkn1;
    }

    public void setIfeTssyukyktkykdai2hknkkn1(String pIfeTssyukyktkykdai2hknkkn1) {
        ifeTssyukyktkykdai2hknkkn1 = pIfeTssyukyktkykdai2hknkkn1;
    }

    @Column(order = 134, label = "syutkdai1hknkknymdto1")
    private String ifeTssyutkdai1hknkknymdto1;

    public String getIfeTssyutkdai1hknkknymdto1() {
        return ifeTssyutkdai1hknkknymdto1;
    }

    public void setIfeTssyutkdai1hknkknymdto1(String pIfeTssyutkdai1hknkknymdto1) {
        ifeTssyutkdai1hknkknymdto1 = pIfeTssyutkdai1hknkknymdto1;
    }

    @Column(order = 135, label = "syutkdai2hknkknymdto1")
    private String ifeTssyutkdai2hknkknymdto1;

    public String getIfeTssyutkdai2hknkknymdto1() {
        return ifeTssyutkdai2hknkknymdto1;
    }

    public void setIfeTssyutkdai2hknkknymdto1(String pIfeTssyutkdai2hknkknymdto1) {
        ifeTssyutkdai2hknkknymdto1 = pIfeTssyutkdai2hknkknymdto1;
    }

    @Column(order = 136, label = "syukyktkykrenban2")
    private String ifeTssyukyktkykrenban2;

    public String getIfeTssyukyktkykrenban2() {
        return ifeTssyukyktkykrenban2;
    }

    public void setIfeTssyukyktkykrenban2(String pIfeTssyukyktkykrenban2) {
        ifeTssyukyktkykrenban2 = pIfeTssyukyktkykrenban2;
    }

    @Column(order = 137, label = "syukyktkykmsgkbn2")
    private String ifeTssyukyktkykmsgkbn2;

    public String getIfeTssyukyktkykmsgkbn2() {
        return ifeTssyukyktkykmsgkbn2;
    }

    public void setIfeTssyukyktkykmsgkbn2(String pIfeTssyukyktkykmsgkbn2) {
        ifeTssyukyktkykmsgkbn2 = pIfeTssyukyktkykmsgkbn2;
    }

    @Column(order = 138, label = "syukyktkyksmsgkbn2")
    private String ifeTssyukyktkyksmsgkbn2;

    public String getIfeTssyukyktkyksmsgkbn2() {
        return ifeTssyukyktkyksmsgkbn2;
    }

    public void setIfeTssyukyktkyksmsgkbn2(String pIfeTssyukyktkyksmsgkbn2) {
        ifeTssyukyktkyksmsgkbn2 = pIfeTssyukyktkyksmsgkbn2;
    }

    @Column(order = 139, label = "syukyktkykhknkknmsgkbn2")
    private String ifeTssykyktkykhknkknmsgkbn2;

    public String getIfeTssykyktkykhknkknmsgkbn2() {
        return ifeTssykyktkykhknkknmsgkbn2;
    }

    public void setIfeTssykyktkykhknkknmsgkbn2(String pIfeTssykyktkykhknkknmsgkbn2) {
        ifeTssykyktkykhknkknmsgkbn2 = pIfeTssykyktkykhknkknmsgkbn2;
    }

    @Column(order = 140, label = "syukyktkykstuukatype2")
    private String ifeTssyukyktkykstuukatype2;

    public String getIfeTssyukyktkykstuukatype2() {
        return ifeTssyukyktkykstuukatype2;
    }

    public void setIfeTssyukyktkykstuukatype2(String pIfeTssyukyktkykstuukatype2) {
        ifeTssyukyktkykstuukatype2 = pIfeTssyukyktkykstuukatype2;
    }

    @Column(order = 141, label = "syukyktkykhknkngk2")
    private String ifeTssyukyktkykhknkngk2;

    public String getIfeTssyukyktkykhknkngk2() {
        return ifeTssyukyktkykhknkngk2;
    }

    public void setIfeTssyukyktkykhknkngk2(String pIfeTssyukyktkykhknkngk2) {
        ifeTssyukyktkykhknkngk2 = pIfeTssyukyktkykhknkngk2;
    }

    @Column(order = 142, label = "syukyktkykhknkngk2$")
    private String ifeTssyukyktkykhknkngk2t;

    public String getIfeTssyukyktkykhknkngk2t() {
        return ifeTssyukyktkykhknkngk2t;
    }

    public void setIfeTssyukyktkykhknkngk2t(String pIfeTssyukyktkykhknkngk2t) {
        ifeTssyukyktkykhknkngk2t = pIfeTssyukyktkykhknkngk2t;
    }

    @Column(order = 143, label = "syukyktkykdai1hknkkn2")
    private String ifeTssyukyktkykdai1hknkkn2;

    public String getIfeTssyukyktkykdai1hknkkn2() {
        return ifeTssyukyktkykdai1hknkkn2;
    }

    public void setIfeTssyukyktkykdai1hknkkn2(String pIfeTssyukyktkykdai1hknkkn2) {
        ifeTssyukyktkykdai1hknkkn2 = pIfeTssyukyktkykdai1hknkkn2;
    }

    @Column(order = 144, label = "syukyktkykdai2hknkkn2")
    private String ifeTssyukyktkykdai2hknkkn2;

    public String getIfeTssyukyktkykdai2hknkkn2() {
        return ifeTssyukyktkykdai2hknkkn2;
    }

    public void setIfeTssyukyktkykdai2hknkkn2(String pIfeTssyukyktkykdai2hknkkn2) {
        ifeTssyukyktkykdai2hknkkn2 = pIfeTssyukyktkykdai2hknkkn2;
    }

    @Column(order = 145, label = "syutkdai1hknkknymdto2")
    private String ifeTssyutkdai1hknkknymdto2;

    public String getIfeTssyutkdai1hknkknymdto2() {
        return ifeTssyutkdai1hknkknymdto2;
    }

    public void setIfeTssyutkdai1hknkknymdto2(String pIfeTssyutkdai1hknkknymdto2) {
        ifeTssyutkdai1hknkknymdto2 = pIfeTssyutkdai1hknkknymdto2;
    }

    @Column(order = 146, label = "syutkdai2hknkknymdto2")
    private String ifeTssyutkdai2hknkknymdto2;

    public String getIfeTssyutkdai2hknkknymdto2() {
        return ifeTssyutkdai2hknkknymdto2;
    }

    public void setIfeTssyutkdai2hknkknymdto2(String pIfeTssyutkdai2hknkknymdto2) {
        ifeTssyutkdai2hknkknymdto2 = pIfeTssyutkdai2hknkknymdto2;
    }

    @Column(order = 147, label = "syukyktkykrenban3")
    private String ifeTssyukyktkykrenban3;

    public String getIfeTssyukyktkykrenban3() {
        return ifeTssyukyktkykrenban3;
    }

    public void setIfeTssyukyktkykrenban3(String pIfeTssyukyktkykrenban3) {
        ifeTssyukyktkykrenban3 = pIfeTssyukyktkykrenban3;
    }

    @Column(order = 148, label = "syukyktkykmsgkbn3")
    private String ifeTssyukyktkykmsgkbn3;

    public String getIfeTssyukyktkykmsgkbn3() {
        return ifeTssyukyktkykmsgkbn3;
    }

    public void setIfeTssyukyktkykmsgkbn3(String pIfeTssyukyktkykmsgkbn3) {
        ifeTssyukyktkykmsgkbn3 = pIfeTssyukyktkykmsgkbn3;
    }

    @Column(order = 149, label = "syukyktkyksmsgkbn3")
    private String ifeTssyukyktkyksmsgkbn3;

    public String getIfeTssyukyktkyksmsgkbn3() {
        return ifeTssyukyktkyksmsgkbn3;
    }

    public void setIfeTssyukyktkyksmsgkbn3(String pIfeTssyukyktkyksmsgkbn3) {
        ifeTssyukyktkyksmsgkbn3 = pIfeTssyukyktkyksmsgkbn3;
    }

    @Column(order = 150, label = "syukyktkykhknkknmsgkbn3")
    private String ifeTssykyktkykhknkknmsgkbn3;

    public String getIfeTssykyktkykhknkknmsgkbn3() {
        return ifeTssykyktkykhknkknmsgkbn3;
    }

    public void setIfeTssykyktkykhknkknmsgkbn3(String pIfeTssykyktkykhknkknmsgkbn3) {
        ifeTssykyktkykhknkknmsgkbn3 = pIfeTssykyktkykhknkknmsgkbn3;
    }

    @Column(order = 151, label = "syukyktkykstuukatype3")
    private String ifeTssyukyktkykstuukatype3;

    public String getIfeTssyukyktkykstuukatype3() {
        return ifeTssyukyktkykstuukatype3;
    }

    public void setIfeTssyukyktkykstuukatype3(String pIfeTssyukyktkykstuukatype3) {
        ifeTssyukyktkykstuukatype3 = pIfeTssyukyktkykstuukatype3;
    }

    @Column(order = 152, label = "syukyktkykhknkngk3")
    private String ifeTssyukyktkykhknkngk3;

    public String getIfeTssyukyktkykhknkngk3() {
        return ifeTssyukyktkykhknkngk3;
    }

    public void setIfeTssyukyktkykhknkngk3(String pIfeTssyukyktkykhknkngk3) {
        ifeTssyukyktkykhknkngk3 = pIfeTssyukyktkykhknkngk3;
    }

    @Column(order = 153, label = "syukyktkykhknkngk3$")
    private String ifeTssyukyktkykhknkngk3t;

    public String getIfeTssyukyktkykhknkngk3t() {
        return ifeTssyukyktkykhknkngk3t;
    }

    public void setIfeTssyukyktkykhknkngk3t(String pIfeTssyukyktkykhknkngk3t) {
        ifeTssyukyktkykhknkngk3t = pIfeTssyukyktkykhknkngk3t;
    }

    @Column(order = 154, label = "syukyktkykdai1hknkkn3")
    private String ifeTssyukyktkykdai1hknkkn3;

    public String getIfeTssyukyktkykdai1hknkkn3() {
        return ifeTssyukyktkykdai1hknkkn3;
    }

    public void setIfeTssyukyktkykdai1hknkkn3(String pIfeTssyukyktkykdai1hknkkn3) {
        ifeTssyukyktkykdai1hknkkn3 = pIfeTssyukyktkykdai1hknkkn3;
    }

    @Column(order = 155, label = "syukyktkykdai2hknkkn3")
    private String ifeTssyukyktkykdai2hknkkn3;

    public String getIfeTssyukyktkykdai2hknkkn3() {
        return ifeTssyukyktkykdai2hknkkn3;
    }

    public void setIfeTssyukyktkykdai2hknkkn3(String pIfeTssyukyktkykdai2hknkkn3) {
        ifeTssyukyktkykdai2hknkkn3 = pIfeTssyukyktkykdai2hknkkn3;
    }

    @Column(order = 156, label = "syutkdai1hknkknymdto3")
    private String ifeTssyutkdai1hknkknymdto3;

    public String getIfeTssyutkdai1hknkknymdto3() {
        return ifeTssyutkdai1hknkknymdto3;
    }

    public void setIfeTssyutkdai1hknkknymdto3(String pIfeTssyutkdai1hknkknymdto3) {
        ifeTssyutkdai1hknkknymdto3 = pIfeTssyutkdai1hknkknymdto3;
    }

    @Column(order = 157, label = "syutkdai2hknkknymdto3")
    private String ifeTssyutkdai2hknkknymdto3;

    public String getIfeTssyutkdai2hknkknymdto3() {
        return ifeTssyutkdai2hknkknymdto3;
    }

    public void setIfeTssyutkdai2hknkknymdto3(String pIfeTssyutkdai2hknkknymdto3) {
        ifeTssyutkdai2hknkknymdto3 = pIfeTssyutkdai2hknkknymdto3;
    }

    @Column(order = 158, label = "syukyktkykrenban4")
    private String ifeTssyukyktkykrenban4;

    public String getIfeTssyukyktkykrenban4() {
        return ifeTssyukyktkykrenban4;
    }

    public void setIfeTssyukyktkykrenban4(String pIfeTssyukyktkykrenban4) {
        ifeTssyukyktkykrenban4 = pIfeTssyukyktkykrenban4;
    }

    @Column(order = 159, label = "syukyktkykmsgkbn4")
    private String ifeTssyukyktkykmsgkbn4;

    public String getIfeTssyukyktkykmsgkbn4() {
        return ifeTssyukyktkykmsgkbn4;
    }

    public void setIfeTssyukyktkykmsgkbn4(String pIfeTssyukyktkykmsgkbn4) {
        ifeTssyukyktkykmsgkbn4 = pIfeTssyukyktkykmsgkbn4;
    }

    @Column(order = 160, label = "syukyktkyksmsgkbn4")
    private String ifeTssyukyktkyksmsgkbn4;

    public String getIfeTssyukyktkyksmsgkbn4() {
        return ifeTssyukyktkyksmsgkbn4;
    }

    public void setIfeTssyukyktkyksmsgkbn4(String pIfeTssyukyktkyksmsgkbn4) {
        ifeTssyukyktkyksmsgkbn4 = pIfeTssyukyktkyksmsgkbn4;
    }

    @Column(order = 161, label = "syukyktkykhknkknmsgkbn4")
    private String ifeTssykyktkykhknkknmsgkbn4;

    public String getIfeTssykyktkykhknkknmsgkbn4() {
        return ifeTssykyktkykhknkknmsgkbn4;
    }

    public void setIfeTssykyktkykhknkknmsgkbn4(String pIfeTssykyktkykhknkknmsgkbn4) {
        ifeTssykyktkykhknkknmsgkbn4 = pIfeTssykyktkykhknkknmsgkbn4;
    }

    @Column(order = 162, label = "syukyktkykstuukatype4")
    private String ifeTssyukyktkykstuukatype4;

    public String getIfeTssyukyktkykstuukatype4() {
        return ifeTssyukyktkykstuukatype4;
    }

    public void setIfeTssyukyktkykstuukatype4(String pIfeTssyukyktkykstuukatype4) {
        ifeTssyukyktkykstuukatype4 = pIfeTssyukyktkykstuukatype4;
    }

    @Column(order = 163, label = "syukyktkykhknkngk4")
    private String ifeTssyukyktkykhknkngk4;

    public String getIfeTssyukyktkykhknkngk4() {
        return ifeTssyukyktkykhknkngk4;
    }

    public void setIfeTssyukyktkykhknkngk4(String pIfeTssyukyktkykhknkngk4) {
        ifeTssyukyktkykhknkngk4 = pIfeTssyukyktkykhknkngk4;
    }

    @Column(order = 164, label = "syukyktkykhknkngk4$")
    private String ifeTssyukyktkykhknkngk4t;

    public String getIfeTssyukyktkykhknkngk4t() {
        return ifeTssyukyktkykhknkngk4t;
    }

    public void setIfeTssyukyktkykhknkngk4t(String pIfeTssyukyktkykhknkngk4t) {
        ifeTssyukyktkykhknkngk4t = pIfeTssyukyktkykhknkngk4t;
    }

    @Column(order = 165, label = "syukyktkykdai1hknkkn4")
    private String ifeTssyukyktkykdai1hknkkn4;

    public String getIfeTssyukyktkykdai1hknkkn4() {
        return ifeTssyukyktkykdai1hknkkn4;
    }

    public void setIfeTssyukyktkykdai1hknkkn4(String pIfeTssyukyktkykdai1hknkkn4) {
        ifeTssyukyktkykdai1hknkkn4 = pIfeTssyukyktkykdai1hknkkn4;
    }

    @Column(order = 166, label = "syukyktkykdai2hknkkn4")
    private String ifeTssyukyktkykdai2hknkkn4;

    public String getIfeTssyukyktkykdai2hknkkn4() {
        return ifeTssyukyktkykdai2hknkkn4;
    }

    public void setIfeTssyukyktkykdai2hknkkn4(String pIfeTssyukyktkykdai2hknkkn4) {
        ifeTssyukyktkykdai2hknkkn4 = pIfeTssyukyktkykdai2hknkkn4;
    }

    @Column(order = 167, label = "syutkdai1hknkknymdto4")
    private String ifeTssyutkdai1hknkknymdto4;

    public String getIfeTssyutkdai1hknkknymdto4() {
        return ifeTssyutkdai1hknkknymdto4;
    }

    public void setIfeTssyutkdai1hknkknymdto4(String pIfeTssyutkdai1hknkknymdto4) {
        ifeTssyutkdai1hknkknymdto4 = pIfeTssyutkdai1hknkknymdto4;
    }

    @Column(order = 168, label = "syutkdai2hknkknymdto4")
    private String ifeTssyutkdai2hknkknymdto4;

    public String getIfeTssyutkdai2hknkknymdto4() {
        return ifeTssyutkdai2hknkknymdto4;
    }

    public void setIfeTssyutkdai2hknkknymdto4(String pIfeTssyutkdai2hknkknymdto4) {
        ifeTssyutkdai2hknkknymdto4 = pIfeTssyutkdai2hknkknymdto4;
    }

    @Column(order = 169, label = "syukyktkykrenban5")
    private String ifeTssyukyktkykrenban5;

    public String getIfeTssyukyktkykrenban5() {
        return ifeTssyukyktkykrenban5;
    }

    public void setIfeTssyukyktkykrenban5(String pIfeTssyukyktkykrenban5) {
        ifeTssyukyktkykrenban5 = pIfeTssyukyktkykrenban5;
    }

    @Column(order = 170, label = "syukyktkykmsgkbn5")
    private String ifeTssyukyktkykmsgkbn5;

    public String getIfeTssyukyktkykmsgkbn5() {
        return ifeTssyukyktkykmsgkbn5;
    }

    public void setIfeTssyukyktkykmsgkbn5(String pIfeTssyukyktkykmsgkbn5) {
        ifeTssyukyktkykmsgkbn5 = pIfeTssyukyktkykmsgkbn5;
    }

    @Column(order = 171, label = "syukyktkyksmsgkbn5")
    private String ifeTssyukyktkyksmsgkbn5;

    public String getIfeTssyukyktkyksmsgkbn5() {
        return ifeTssyukyktkyksmsgkbn5;
    }

    public void setIfeTssyukyktkyksmsgkbn5(String pIfeTssyukyktkyksmsgkbn5) {
        ifeTssyukyktkyksmsgkbn5 = pIfeTssyukyktkyksmsgkbn5;
    }

    @Column(order = 172, label = "syukyktkykhknkknmsgkbn5")
    private String ifeTssykyktkykhknkknmsgkbn5;

    public String getIfeTssykyktkykhknkknmsgkbn5() {
        return ifeTssykyktkykhknkknmsgkbn5;
    }

    public void setIfeTssykyktkykhknkknmsgkbn5(String pIfeTssykyktkykhknkknmsgkbn5) {
        ifeTssykyktkykhknkknmsgkbn5 = pIfeTssykyktkykhknkknmsgkbn5;
    }

    @Column(order = 173, label = "syukyktkykstuukatype5")
    private String ifeTssyukyktkykstuukatype5;

    public String getIfeTssyukyktkykstuukatype5() {
        return ifeTssyukyktkykstuukatype5;
    }

    public void setIfeTssyukyktkykstuukatype5(String pIfeTssyukyktkykstuukatype5) {
        ifeTssyukyktkykstuukatype5 = pIfeTssyukyktkykstuukatype5;
    }

    @Column(order = 174, label = "syukyktkykhknkngk5")
    private String ifeTssyukyktkykhknkngk5;

    public String getIfeTssyukyktkykhknkngk5() {
        return ifeTssyukyktkykhknkngk5;
    }

    public void setIfeTssyukyktkykhknkngk5(String pIfeTssyukyktkykhknkngk5) {
        ifeTssyukyktkykhknkngk5 = pIfeTssyukyktkykhknkngk5;
    }

    @Column(order = 175, label = "syukyktkykhknkngk5$")
    private String ifeTssyukyktkykhknkngk5t;

    public String getIfeTssyukyktkykhknkngk5t() {
        return ifeTssyukyktkykhknkngk5t;
    }

    public void setIfeTssyukyktkykhknkngk5t(String pIfeTssyukyktkykhknkngk5t) {
        ifeTssyukyktkykhknkngk5t = pIfeTssyukyktkykhknkngk5t;
    }

    @Column(order = 176, label = "syukyktkykdai1hknkkn5")
    private String ifeTssyukyktkykdai1hknkkn5;

    public String getIfeTssyukyktkykdai1hknkkn5() {
        return ifeTssyukyktkykdai1hknkkn5;
    }

    public void setIfeTssyukyktkykdai1hknkkn5(String pIfeTssyukyktkykdai1hknkkn5) {
        ifeTssyukyktkykdai1hknkkn5 = pIfeTssyukyktkykdai1hknkkn5;
    }

    @Column(order = 177, label = "syukyktkykdai2hknkkn5")
    private String ifeTssyukyktkykdai2hknkkn5;

    public String getIfeTssyukyktkykdai2hknkkn5() {
        return ifeTssyukyktkykdai2hknkkn5;
    }

    public void setIfeTssyukyktkykdai2hknkkn5(String pIfeTssyukyktkykdai2hknkkn5) {
        ifeTssyukyktkykdai2hknkkn5 = pIfeTssyukyktkykdai2hknkkn5;
    }

    @Column(order = 178, label = "syutkdai1hknkknymdto5")
    private String ifeTssyutkdai1hknkknymdto5;

    public String getIfeTssyutkdai1hknkknymdto5() {
        return ifeTssyutkdai1hknkknymdto5;
    }

    public void setIfeTssyutkdai1hknkknymdto5(String pIfeTssyutkdai1hknkknymdto5) {
        ifeTssyutkdai1hknkknymdto5 = pIfeTssyutkdai1hknkknymdto5;
    }

    @Column(order = 179, label = "syutkdai2hknkknymdto5")
    private String ifeTssyutkdai2hknkknymdto5;

    public String getIfeTssyutkdai2hknkknymdto5() {
        return ifeTssyutkdai2hknkknymdto5;
    }

    public void setIfeTssyutkdai2hknkknymdto5(String pIfeTssyutkdai2hknkknymdto5) {
        ifeTssyutkdai2hknkknymdto5 = pIfeTssyutkdai2hknkknymdto5;
    }

    @Column(order = 180, label = "syukyktkykrenban6")
    private String ifeTssyukyktkykrenban6;

    public String getIfeTssyukyktkykrenban6() {
        return ifeTssyukyktkykrenban6;
    }

    public void setIfeTssyukyktkykrenban6(String pIfeTssyukyktkykrenban6) {
        ifeTssyukyktkykrenban6 = pIfeTssyukyktkykrenban6;
    }

    @Column(order = 181, label = "syukyktkykmsgkbn6")
    private String ifeTssyukyktkykmsgkbn6;

    public String getIfeTssyukyktkykmsgkbn6() {
        return ifeTssyukyktkykmsgkbn6;
    }

    public void setIfeTssyukyktkykmsgkbn6(String pIfeTssyukyktkykmsgkbn6) {
        ifeTssyukyktkykmsgkbn6 = pIfeTssyukyktkykmsgkbn6;
    }

    @Column(order = 182, label = "syukyktkyksmsgkbn6")
    private String ifeTssyukyktkyksmsgkbn6;

    public String getIfeTssyukyktkyksmsgkbn6() {
        return ifeTssyukyktkyksmsgkbn6;
    }

    public void setIfeTssyukyktkyksmsgkbn6(String pIfeTssyukyktkyksmsgkbn6) {
        ifeTssyukyktkyksmsgkbn6 = pIfeTssyukyktkyksmsgkbn6;
    }

    @Column(order = 183, label = "syukyktkykhknkknmsgkbn6")
    private String ifeTssykyktkykhknkknmsgkbn6;

    public String getIfeTssykyktkykhknkknmsgkbn6() {
        return ifeTssykyktkykhknkknmsgkbn6;
    }

    public void setIfeTssykyktkykhknkknmsgkbn6(String pIfeTssykyktkykhknkknmsgkbn6) {
        ifeTssykyktkykhknkknmsgkbn6 = pIfeTssykyktkykhknkknmsgkbn6;
    }

    @Column(order = 184, label = "syukyktkykstuukatype6")
    private String ifeTssyukyktkykstuukatype6;

    public String getIfeTssyukyktkykstuukatype6() {
        return ifeTssyukyktkykstuukatype6;
    }

    public void setIfeTssyukyktkykstuukatype6(String pIfeTssyukyktkykstuukatype6) {
        ifeTssyukyktkykstuukatype6 = pIfeTssyukyktkykstuukatype6;
    }

    @Column(order = 185, label = "syukyktkykhknkngk6")
    private String ifeTssyukyktkykhknkngk6;

    public String getIfeTssyukyktkykhknkngk6() {
        return ifeTssyukyktkykhknkngk6;
    }

    public void setIfeTssyukyktkykhknkngk6(String pIfeTssyukyktkykhknkngk6) {
        ifeTssyukyktkykhknkngk6 = pIfeTssyukyktkykhknkngk6;
    }

    @Column(order = 186, label = "syukyktkykhknkngk6$")
    private String ifeTssyukyktkykhknkngk6t;

    public String getIfeTssyukyktkykhknkngk6t() {
        return ifeTssyukyktkykhknkngk6t;
    }

    public void setIfeTssyukyktkykhknkngk6t(String pIfeTssyukyktkykhknkngk6t) {
        ifeTssyukyktkykhknkngk6t = pIfeTssyukyktkykhknkngk6t;
    }

    @Column(order = 187, label = "syukyktkykdai1hknkkn6")
    private String ifeTssyukyktkykdai1hknkkn6;

    public String getIfeTssyukyktkykdai1hknkkn6() {
        return ifeTssyukyktkykdai1hknkkn6;
    }

    public void setIfeTssyukyktkykdai1hknkkn6(String pIfeTssyukyktkykdai1hknkkn6) {
        ifeTssyukyktkykdai1hknkkn6 = pIfeTssyukyktkykdai1hknkkn6;
    }

    @Column(order = 188, label = "syukyktkykdai2hknkkn6")
    private String ifeTssyukyktkykdai2hknkkn6;

    public String getIfeTssyukyktkykdai2hknkkn6() {
        return ifeTssyukyktkykdai2hknkkn6;
    }

    public void setIfeTssyukyktkykdai2hknkkn6(String pIfeTssyukyktkykdai2hknkkn6) {
        ifeTssyukyktkykdai2hknkkn6 = pIfeTssyukyktkykdai2hknkkn6;
    }

    @Column(order = 189, label = "syutkdai1hknkknymdto6")
    private String ifeTssyutkdai1hknkknymdto6;

    public String getIfeTssyutkdai1hknkknymdto6() {
        return ifeTssyutkdai1hknkknymdto6;
    }

    public void setIfeTssyutkdai1hknkknymdto6(String pIfeTssyutkdai1hknkknymdto6) {
        ifeTssyutkdai1hknkknymdto6 = pIfeTssyutkdai1hknkknymdto6;
    }

    @Column(order = 190, label = "syutkdai2hknkknymdto6")
    private String ifeTssyutkdai2hknkknymdto6;

    public String getIfeTssyutkdai2hknkknymdto6() {
        return ifeTssyutkdai2hknkknymdto6;
    }

    public void setIfeTssyutkdai2hknkknymdto6(String pIfeTssyutkdai2hknkknymdto6) {
        ifeTssyutkdai2hknkknymdto6 = pIfeTssyutkdai2hknkknymdto6;
    }

    @Column(order = 191, label = "syukyktkykrenban7")
    private String ifeTssyukyktkykrenban7;

    public String getIfeTssyukyktkykrenban7() {
        return ifeTssyukyktkykrenban7;
    }

    public void setIfeTssyukyktkykrenban7(String pIfeTssyukyktkykrenban7) {
        ifeTssyukyktkykrenban7 = pIfeTssyukyktkykrenban7;
    }

    @Column(order = 192, label = "syukyktkykmsgkbn7")
    private String ifeTssyukyktkykmsgkbn7;

    public String getIfeTssyukyktkykmsgkbn7() {
        return ifeTssyukyktkykmsgkbn7;
    }

    public void setIfeTssyukyktkykmsgkbn7(String pIfeTssyukyktkykmsgkbn7) {
        ifeTssyukyktkykmsgkbn7 = pIfeTssyukyktkykmsgkbn7;
    }

    @Column(order = 193, label = "syukyktkyksmsgkbn7")
    private String ifeTssyukyktkyksmsgkbn7;

    public String getIfeTssyukyktkyksmsgkbn7() {
        return ifeTssyukyktkyksmsgkbn7;
    }

    public void setIfeTssyukyktkyksmsgkbn7(String pIfeTssyukyktkyksmsgkbn7) {
        ifeTssyukyktkyksmsgkbn7 = pIfeTssyukyktkyksmsgkbn7;
    }

    @Column(order = 194, label = "syukyktkykhknkknmsgkbn7")
    private String ifeTssykyktkykhknkknmsgkbn7;

    public String getIfeTssykyktkykhknkknmsgkbn7() {
        return ifeTssykyktkykhknkknmsgkbn7;
    }

    public void setIfeTssykyktkykhknkknmsgkbn7(String pIfeTssykyktkykhknkknmsgkbn7) {
        ifeTssykyktkykhknkknmsgkbn7 = pIfeTssykyktkykhknkknmsgkbn7;
    }

    @Column(order = 195, label = "syukyktkykstuukatype7")
    private String ifeTssyukyktkykstuukatype7;

    public String getIfeTssyukyktkykstuukatype7() {
        return ifeTssyukyktkykstuukatype7;
    }

    public void setIfeTssyukyktkykstuukatype7(String pIfeTssyukyktkykstuukatype7) {
        ifeTssyukyktkykstuukatype7 = pIfeTssyukyktkykstuukatype7;
    }

    @Column(order = 196, label = "syukyktkykhknkngk7")
    private String ifeTssyukyktkykhknkngk7;

    public String getIfeTssyukyktkykhknkngk7() {
        return ifeTssyukyktkykhknkngk7;
    }

    public void setIfeTssyukyktkykhknkngk7(String pIfeTssyukyktkykhknkngk7) {
        ifeTssyukyktkykhknkngk7 = pIfeTssyukyktkykhknkngk7;
    }

    @Column(order = 197, label = "syukyktkykhknkngk7$")
    private String ifeTssyukyktkykhknkngk7t;

    public String getIfeTssyukyktkykhknkngk7t() {
        return ifeTssyukyktkykhknkngk7t;
    }

    public void setIfeTssyukyktkykhknkngk7t(String pIfeTssyukyktkykhknkngk7t) {
        ifeTssyukyktkykhknkngk7t = pIfeTssyukyktkykhknkngk7t;
    }

    @Column(order = 198, label = "syukyktkykdai1hknkkn7")
    private String ifeTssyukyktkykdai1hknkkn7;

    public String getIfeTssyukyktkykdai1hknkkn7() {
        return ifeTssyukyktkykdai1hknkkn7;
    }

    public void setIfeTssyukyktkykdai1hknkkn7(String pIfeTssyukyktkykdai1hknkkn7) {
        ifeTssyukyktkykdai1hknkkn7 = pIfeTssyukyktkykdai1hknkkn7;
    }

    @Column(order = 199, label = "syukyktkykdai2hknkkn7")
    private String ifeTssyukyktkykdai2hknkkn7;

    public String getIfeTssyukyktkykdai2hknkkn7() {
        return ifeTssyukyktkykdai2hknkkn7;
    }

    public void setIfeTssyukyktkykdai2hknkkn7(String pIfeTssyukyktkykdai2hknkkn7) {
        ifeTssyukyktkykdai2hknkkn7 = pIfeTssyukyktkykdai2hknkkn7;
    }

    @Column(order = 200, label = "syutkdai1hknkknymdto7")
    private String ifeTssyutkdai1hknkknymdto7;

    public String getIfeTssyutkdai1hknkknymdto7() {
        return ifeTssyutkdai1hknkknymdto7;
    }

    public void setIfeTssyutkdai1hknkknymdto7(String pIfeTssyutkdai1hknkknymdto7) {
        ifeTssyutkdai1hknkknymdto7 = pIfeTssyutkdai1hknkknymdto7;
    }

    @Column(order = 201, label = "syutkdai2hknkknymdto7")
    private String ifeTssyutkdai2hknkknymdto7;

    public String getIfeTssyutkdai2hknkknymdto7() {
        return ifeTssyutkdai2hknkknymdto7;
    }

    public void setIfeTssyutkdai2hknkknymdto7(String pIfeTssyutkdai2hknkknymdto7) {
        ifeTssyutkdai2hknkknymdto7 = pIfeTssyutkdai2hknkknymdto7;
    }

    @Column(order = 202, label = "syukyktkykrenban8")
    private String ifeTssyukyktkykrenban8;

    public String getIfeTssyukyktkykrenban8() {
        return ifeTssyukyktkykrenban8;
    }

    public void setIfeTssyukyktkykrenban8(String pIfeTssyukyktkykrenban8) {
        ifeTssyukyktkykrenban8 = pIfeTssyukyktkykrenban8;
    }

    @Column(order = 203, label = "syukyktkykmsgkbn8")
    private String ifeTssyukyktkykmsgkbn8;

    public String getIfeTssyukyktkykmsgkbn8() {
        return ifeTssyukyktkykmsgkbn8;
    }

    public void setIfeTssyukyktkykmsgkbn8(String pIfeTssyukyktkykmsgkbn8) {
        ifeTssyukyktkykmsgkbn8 = pIfeTssyukyktkykmsgkbn8;
    }

    @Column(order = 204, label = "syukyktkyksmsgkbn8")
    private String ifeTssyukyktkyksmsgkbn8;

    public String getIfeTssyukyktkyksmsgkbn8() {
        return ifeTssyukyktkyksmsgkbn8;
    }

    public void setIfeTssyukyktkyksmsgkbn8(String pIfeTssyukyktkyksmsgkbn8) {
        ifeTssyukyktkyksmsgkbn8 = pIfeTssyukyktkyksmsgkbn8;
    }

    @Column(order = 205, label = "syukyktkykhknkknmsgkbn8")
    private String ifeTssykyktkykhknkknmsgkbn8;

    public String getIfeTssykyktkykhknkknmsgkbn8() {
        return ifeTssykyktkykhknkknmsgkbn8;
    }

    public void setIfeTssykyktkykhknkknmsgkbn8(String pIfeTssykyktkykhknkknmsgkbn8) {
        ifeTssykyktkykhknkknmsgkbn8 = pIfeTssykyktkykhknkknmsgkbn8;
    }

    @Column(order = 206, label = "syukyktkykstuukatype8")
    private String ifeTssyukyktkykstuukatype8;

    public String getIfeTssyukyktkykstuukatype8() {
        return ifeTssyukyktkykstuukatype8;
    }

    public void setIfeTssyukyktkykstuukatype8(String pIfeTssyukyktkykstuukatype8) {
        ifeTssyukyktkykstuukatype8 = pIfeTssyukyktkykstuukatype8;
    }

    @Column(order = 207, label = "syukyktkykhknkngk8")
    private String ifeTssyukyktkykhknkngk8;

    public String getIfeTssyukyktkykhknkngk8() {
        return ifeTssyukyktkykhknkngk8;
    }

    public void setIfeTssyukyktkykhknkngk8(String pIfeTssyukyktkykhknkngk8) {
        ifeTssyukyktkykhknkngk8 = pIfeTssyukyktkykhknkngk8;
    }

    @Column(order = 208, label = "syukyktkykhknkngk8$")
    private String ifeTssyukyktkykhknkngk8t;

    public String getIfeTssyukyktkykhknkngk8t() {
        return ifeTssyukyktkykhknkngk8t;
    }

    public void setIfeTssyukyktkykhknkngk8t(String pIfeTssyukyktkykhknkngk8t) {
        ifeTssyukyktkykhknkngk8t = pIfeTssyukyktkykhknkngk8t;
    }

    @Column(order = 209, label = "syukyktkykdai1hknkkn8")
    private String ifeTssyukyktkykdai1hknkkn8;

    public String getIfeTssyukyktkykdai1hknkkn8() {
        return ifeTssyukyktkykdai1hknkkn8;
    }

    public void setIfeTssyukyktkykdai1hknkkn8(String pIfeTssyukyktkykdai1hknkkn8) {
        ifeTssyukyktkykdai1hknkkn8 = pIfeTssyukyktkykdai1hknkkn8;
    }

    @Column(order = 210, label = "syukyktkykdai2hknkkn8")
    private String ifeTssyukyktkykdai2hknkkn8;

    public String getIfeTssyukyktkykdai2hknkkn8() {
        return ifeTssyukyktkykdai2hknkkn8;
    }

    public void setIfeTssyukyktkykdai2hknkkn8(String pIfeTssyukyktkykdai2hknkkn8) {
        ifeTssyukyktkykdai2hknkkn8 = pIfeTssyukyktkykdai2hknkkn8;
    }

    @Column(order = 211, label = "syutkdai1hknkknymdto8")
    private String ifeTssyutkdai1hknkknymdto8;

    public String getIfeTssyutkdai1hknkknymdto8() {
        return ifeTssyutkdai1hknkknymdto8;
    }

    public void setIfeTssyutkdai1hknkknymdto8(String pIfeTssyutkdai1hknkknymdto8) {
        ifeTssyutkdai1hknkknymdto8 = pIfeTssyutkdai1hknkknymdto8;
    }

    @Column(order = 212, label = "syutkdai2hknkknymdto8")
    private String ifeTssyutkdai2hknkknymdto8;

    public String getIfeTssyutkdai2hknkknymdto8() {
        return ifeTssyutkdai2hknkknymdto8;
    }

    public void setIfeTssyutkdai2hknkknymdto8(String pIfeTssyutkdai2hknkknymdto8) {
        ifeTssyutkdai2hknkknymdto8 = pIfeTssyutkdai2hknkknymdto8;
    }

    @Column(order = 213, label = "syukyktkykrenban9")
    private String ifeTssyukyktkykrenban9;

    public String getIfeTssyukyktkykrenban9() {
        return ifeTssyukyktkykrenban9;
    }

    public void setIfeTssyukyktkykrenban9(String pIfeTssyukyktkykrenban9) {
        ifeTssyukyktkykrenban9 = pIfeTssyukyktkykrenban9;
    }

    @Column(order = 214, label = "syukyktkykmsgkbn9")
    private String ifeTssyukyktkykmsgkbn9;

    public String getIfeTssyukyktkykmsgkbn9() {
        return ifeTssyukyktkykmsgkbn9;
    }

    public void setIfeTssyukyktkykmsgkbn9(String pIfeTssyukyktkykmsgkbn9) {
        ifeTssyukyktkykmsgkbn9 = pIfeTssyukyktkykmsgkbn9;
    }

    @Column(order = 215, label = "syukyktkyksmsgkbn9")
    private String ifeTssyukyktkyksmsgkbn9;

    public String getIfeTssyukyktkyksmsgkbn9() {
        return ifeTssyukyktkyksmsgkbn9;
    }

    public void setIfeTssyukyktkyksmsgkbn9(String pIfeTssyukyktkyksmsgkbn9) {
        ifeTssyukyktkyksmsgkbn9 = pIfeTssyukyktkyksmsgkbn9;
    }

    @Column(order = 216, label = "syukyktkykhknkknmsgkbn9")
    private String ifeTssykyktkykhknkknmsgkbn9;

    public String getIfeTssykyktkykhknkknmsgkbn9() {
        return ifeTssykyktkykhknkknmsgkbn9;
    }

    public void setIfeTssykyktkykhknkknmsgkbn9(String pIfeTssykyktkykhknkknmsgkbn9) {
        ifeTssykyktkykhknkknmsgkbn9 = pIfeTssykyktkykhknkknmsgkbn9;
    }

    @Column(order = 217, label = "syukyktkykstuukatype9")
    private String ifeTssyukyktkykstuukatype9;

    public String getIfeTssyukyktkykstuukatype9() {
        return ifeTssyukyktkykstuukatype9;
    }

    public void setIfeTssyukyktkykstuukatype9(String pIfeTssyukyktkykstuukatype9) {
        ifeTssyukyktkykstuukatype9 = pIfeTssyukyktkykstuukatype9;
    }

    @Column(order = 218, label = "syukyktkykhknkngk9")
    private String ifeTssyukyktkykhknkngk9;

    public String getIfeTssyukyktkykhknkngk9() {
        return ifeTssyukyktkykhknkngk9;
    }

    public void setIfeTssyukyktkykhknkngk9(String pIfeTssyukyktkykhknkngk9) {
        ifeTssyukyktkykhknkngk9 = pIfeTssyukyktkykhknkngk9;
    }

    @Column(order = 219, label = "syukyktkykhknkngk9$")
    private String ifeTssyukyktkykhknkngk9t;

    public String getIfeTssyukyktkykhknkngk9t() {
        return ifeTssyukyktkykhknkngk9t;
    }

    public void setIfeTssyukyktkykhknkngk9t(String pIfeTssyukyktkykhknkngk9t) {
        ifeTssyukyktkykhknkngk9t = pIfeTssyukyktkykhknkngk9t;
    }

    @Column(order = 220, label = "syukyktkykdai1hknkkn9")
    private String ifeTssyukyktkykdai1hknkkn9;

    public String getIfeTssyukyktkykdai1hknkkn9() {
        return ifeTssyukyktkykdai1hknkkn9;
    }

    public void setIfeTssyukyktkykdai1hknkkn9(String pIfeTssyukyktkykdai1hknkkn9) {
        ifeTssyukyktkykdai1hknkkn9 = pIfeTssyukyktkykdai1hknkkn9;
    }

    @Column(order = 221, label = "syukyktkykdai2hknkkn9")
    private String ifeTssyukyktkykdai2hknkkn9;

    public String getIfeTssyukyktkykdai2hknkkn9() {
        return ifeTssyukyktkykdai2hknkkn9;
    }

    public void setIfeTssyukyktkykdai2hknkkn9(String pIfeTssyukyktkykdai2hknkkn9) {
        ifeTssyukyktkykdai2hknkkn9 = pIfeTssyukyktkykdai2hknkkn9;
    }

    @Column(order = 222, label = "syutkdai1hknkknymdto9")
    private String ifeTssyutkdai1hknkknymdto9;

    public String getIfeTssyutkdai1hknkknymdto9() {
        return ifeTssyutkdai1hknkknymdto9;
    }

    public void setIfeTssyutkdai1hknkknymdto9(String pIfeTssyutkdai1hknkknymdto9) {
        ifeTssyutkdai1hknkknymdto9 = pIfeTssyutkdai1hknkknymdto9;
    }

    @Column(order = 223, label = "syutkdai2hknkknymdto9")
    private String ifeTssyutkdai2hknkknymdto9;

    public String getIfeTssyutkdai2hknkknymdto9() {
        return ifeTssyutkdai2hknkknymdto9;
    }

    public void setIfeTssyutkdai2hknkknymdto9(String pIfeTssyutkdai2hknkknymdto9) {
        ifeTssyutkdai2hknkknymdto9 = pIfeTssyutkdai2hknkknymdto9;
    }

    @Column(order = 224, label = "syukyktkykrenban10")
    private String ifeTssyukyktkykrenban10;

    public String getIfeTssyukyktkykrenban10() {
        return ifeTssyukyktkykrenban10;
    }

    public void setIfeTssyukyktkykrenban10(String pIfeTssyukyktkykrenban10) {
        ifeTssyukyktkykrenban10 = pIfeTssyukyktkykrenban10;
    }

    @Column(order = 225, label = "syukyktkykmsgkbn10")
    private String ifeTssyukyktkykmsgkbn10;

    public String getIfeTssyukyktkykmsgkbn10() {
        return ifeTssyukyktkykmsgkbn10;
    }

    public void setIfeTssyukyktkykmsgkbn10(String pIfeTssyukyktkykmsgkbn10) {
        ifeTssyukyktkykmsgkbn10 = pIfeTssyukyktkykmsgkbn10;
    }

    @Column(order = 226, label = "syukyktkyksmsgkbn10")
    private String ifeTssyukyktkyksmsgkbn10;

    public String getIfeTssyukyktkyksmsgkbn10() {
        return ifeTssyukyktkyksmsgkbn10;
    }

    public void setIfeTssyukyktkyksmsgkbn10(String pIfeTssyukyktkyksmsgkbn10) {
        ifeTssyukyktkyksmsgkbn10 = pIfeTssyukyktkyksmsgkbn10;
    }

    @Column(order = 227, label = "syukyktkykhknkknmsgkbn10")
    private String ifeTssykyktkykhknkkmsgkbn10;

    public String getIfeTssykyktkykhknkkmsgkbn10() {
        return ifeTssykyktkykhknkkmsgkbn10;
    }

    public void setIfeTssykyktkykhknkkmsgkbn10(String pIfeTssykyktkykhknkkmsgkbn10) {
        ifeTssykyktkykhknkkmsgkbn10 = pIfeTssykyktkykhknkkmsgkbn10;
    }

    @Column(order = 228, label = "syukyktkykstuukatype10")
    private String ifeTssyukyktkykstuukatype10;

    public String getIfeTssyukyktkykstuukatype10() {
        return ifeTssyukyktkykstuukatype10;
    }

    public void setIfeTssyukyktkykstuukatype10(String pIfeTssyukyktkykstuukatype10) {
        ifeTssyukyktkykstuukatype10 = pIfeTssyukyktkykstuukatype10;
    }

    @Column(order = 229, label = "syukyktkykhknkngk10")
    private String ifeTssyukyktkykhknkngk10;

    public String getIfeTssyukyktkykhknkngk10() {
        return ifeTssyukyktkykhknkngk10;
    }

    public void setIfeTssyukyktkykhknkngk10(String pIfeTssyukyktkykhknkngk10) {
        ifeTssyukyktkykhknkngk10 = pIfeTssyukyktkykhknkngk10;
    }

    @Column(order = 230, label = "syukyktkykhknkngk10$")
    private String ifeTssyukyktkykhknkngk10t;

    public String getIfeTssyukyktkykhknkngk10t() {
        return ifeTssyukyktkykhknkngk10t;
    }

    public void setIfeTssyukyktkykhknkngk10t(String pIfeTssyukyktkykhknkngk10t) {
        ifeTssyukyktkykhknkngk10t = pIfeTssyukyktkykhknkngk10t;
    }

    @Column(order = 231, label = "syukyktkykdai1hknkkn10")
    private String ifeTssyukyktkykdai1hknkkn10;

    public String getIfeTssyukyktkykdai1hknkkn10() {
        return ifeTssyukyktkykdai1hknkkn10;
    }

    public void setIfeTssyukyktkykdai1hknkkn10(String pIfeTssyukyktkykdai1hknkkn10) {
        ifeTssyukyktkykdai1hknkkn10 = pIfeTssyukyktkykdai1hknkkn10;
    }

    @Column(order = 232, label = "syukyktkykdai2hknkkn10")
    private String ifeTssyukyktkykdai2hknkkn10;

    public String getIfeTssyukyktkykdai2hknkkn10() {
        return ifeTssyukyktkykdai2hknkkn10;
    }

    public void setIfeTssyukyktkykdai2hknkkn10(String pIfeTssyukyktkykdai2hknkkn10) {
        ifeTssyukyktkykdai2hknkkn10 = pIfeTssyukyktkykdai2hknkkn10;
    }

    @Column(order = 233, label = "syutkdai1hknkknymdto10")
    private String ifeTssyutkdai1hknkknymdto10;

    public String getIfeTssyutkdai1hknkknymdto10() {
        return ifeTssyutkdai1hknkknymdto10;
    }

    public void setIfeTssyutkdai1hknkknymdto10(String pIfeTssyutkdai1hknkknymdto10) {
        ifeTssyutkdai1hknkknymdto10 = pIfeTssyutkdai1hknkknymdto10;
    }

    @Column(order = 234, label = "syutkdai2hknkknymdto10")
    private String ifeTssyutkdai2hknkknymdto10;

    public String getIfeTssyutkdai2hknkknymdto10() {
        return ifeTssyutkdai2hknkknymdto10;
    }

    public void setIfeTssyutkdai2hknkknymdto10(String pIfeTssyutkdai2hknkknymdto10) {
        ifeTssyutkdai2hknkknymdto10 = pIfeTssyutkdai2hknkknymdto10;
    }

    @Column(order = 235, label = "kykniyustmsgcd1")
    private String ifeTskykniyustmsgcd1;

    public String getIfeTskykniyustmsgcd1() {
        return ifeTskykniyustmsgcd1;
    }

    public void setIfeTskykniyustmsgcd1(String pIfeTskykniyustmsgcd1) {
        ifeTskykniyustmsgcd1 = pIfeTskykniyustmsgcd1;
    }

    @Column(order = 236, label = "kykniyustmsgcd2")
    private String ifeTskykniyustmsgcd2;

    public String getIfeTskykniyustmsgcd2() {
        return ifeTskykniyustmsgcd2;
    }

    public void setIfeTskykniyustmsgcd2(String pIfeTskykniyustmsgcd2) {
        ifeTskykniyustmsgcd2 = pIfeTskykniyustmsgcd2;
    }

    @Column(order = 237, label = "kykniyustmsgcd3")
    private String ifeTskykniyustmsgcd3;

    public String getIfeTskykniyustmsgcd3() {
        return ifeTskykniyustmsgcd3;
    }

    public void setIfeTskykniyustmsgcd3(String pIfeTskykniyustmsgcd3) {
        ifeTskykniyustmsgcd3 = pIfeTskykniyustmsgcd3;
    }

    @Column(order = 238, label = "kykniyustmsgcd4")
    private String ifeTskykniyustmsgcd4;

    public String getIfeTskykniyustmsgcd4() {
        return ifeTskykniyustmsgcd4;
    }

    public void setIfeTskykniyustmsgcd4(String pIfeTskykniyustmsgcd4) {
        ifeTskykniyustmsgcd4 = pIfeTskykniyustmsgcd4;
    }

    @Column(order = 239, label = "kykniyustmsgcd5")
    private String ifeTskykniyustmsgcd5;

    public String getIfeTskykniyustmsgcd5() {
        return ifeTskykniyustmsgcd5;
    }

    public void setIfeTskykniyustmsgcd5(String pIfeTskykniyustmsgcd5) {
        ifeTskykniyustmsgcd5 = pIfeTskykniyustmsgcd5;
    }

    @Column(order = 240, label = "kykniyustmsgcd6")
    private String ifeTskykniyustmsgcd6;

    public String getIfeTskykniyustmsgcd6() {
        return ifeTskykniyustmsgcd6;
    }

    public void setIfeTskykniyustmsgcd6(String pIfeTskykniyustmsgcd6) {
        ifeTskykniyustmsgcd6 = pIfeTskykniyustmsgcd6;
    }

    @Column(order = 241, label = "kykniyustmsgcd7")
    private String ifeTskykniyustmsgcd7;

    public String getIfeTskykniyustmsgcd7() {
        return ifeTskykniyustmsgcd7;
    }

    public void setIfeTskykniyustmsgcd7(String pIfeTskykniyustmsgcd7) {
        ifeTskykniyustmsgcd7 = pIfeTskykniyustmsgcd7;
    }

    @Column(order = 242, label = "kykniyustmsgcd8")
    private String ifeTskykniyustmsgcd8;

    public String getIfeTskykniyustmsgcd8() {
        return ifeTskykniyustmsgcd8;
    }

    public void setIfeTskykniyustmsgcd8(String pIfeTskykniyustmsgcd8) {
        ifeTskykniyustmsgcd8 = pIfeTskykniyustmsgcd8;
    }

    @Column(order = 243, label = "kykniyustmsgcd9")
    private String ifeTskykniyustmsgcd9;

    public String getIfeTskykniyustmsgcd9() {
        return ifeTskykniyustmsgcd9;
    }

    public void setIfeTskykniyustmsgcd9(String pIfeTskykniyustmsgcd9) {
        ifeTskykniyustmsgcd9 = pIfeTskykniyustmsgcd9;
    }

    @Column(order = 244, label = "kykniyustmsgcd10")
    private String ifeTskykniyustmsgcd10;

    public String getIfeTskykniyustmsgcd10() {
        return ifeTskykniyustmsgcd10;
    }

    public void setIfeTskykniyustmsgcd10(String pIfeTskykniyustmsgcd10) {
        ifeTskykniyustmsgcd10 = pIfeTskykniyustmsgcd10;
    }

    @Column(order = 245, label = "kykniyustmsgcd11")
    private String ifeTskykniyustmsgcd11;

    public String getIfeTskykniyustmsgcd11() {
        return ifeTskykniyustmsgcd11;
    }

    public void setIfeTskykniyustmsgcd11(String pIfeTskykniyustmsgcd11) {
        ifeTskykniyustmsgcd11 = pIfeTskykniyustmsgcd11;
    }

    @Column(order = 246, label = "kykniyustmsgcd12")
    private String ifeTskykniyustmsgcd12;

    public String getIfeTskykniyustmsgcd12() {
        return ifeTskykniyustmsgcd12;
    }

    public void setIfeTskykniyustmsgcd12(String pIfeTskykniyustmsgcd12) {
        ifeTskykniyustmsgcd12 = pIfeTskykniyustmsgcd12;
    }

    @Column(order = 247, label = "kykniyustmsgcd13")
    private String ifeTskykniyustmsgcd13;

    public String getIfeTskykniyustmsgcd13() {
        return ifeTskykniyustmsgcd13;
    }

    public void setIfeTskykniyustmsgcd13(String pIfeTskykniyustmsgcd13) {
        ifeTskykniyustmsgcd13 = pIfeTskykniyustmsgcd13;
    }

    @Column(order = 248, label = "kykniyustmsgcd14")
    private String ifeTskykniyustmsgcd14;

    public String getIfeTskykniyustmsgcd14() {
        return ifeTskykniyustmsgcd14;
    }

    public void setIfeTskykniyustmsgcd14(String pIfeTskykniyustmsgcd14) {
        ifeTskykniyustmsgcd14 = pIfeTskykniyustmsgcd14;
    }

    @Column(order = 249, label = "kykniyustmsgcd15")
    private String ifeTskykniyustmsgcd15;

    public String getIfeTskykniyustmsgcd15() {
        return ifeTskykniyustmsgcd15;
    }

    public void setIfeTskykniyustmsgcd15(String pIfeTskykniyustmsgcd15) {
        ifeTskykniyustmsgcd15 = pIfeTskykniyustmsgcd15;
    }

    @Column(order = 250, label = "kykniyustitjbrptuuktype")
    private String ifeTskykniystitjbrptuuktype;

    public String getIfeTskykniystitjbrptuuktype() {
        return ifeTskykniystitjbrptuuktype;
    }

    public void setIfeTskykniystitjbrptuuktype(String pIfeTskykniystitjbrptuuktype) {
        ifeTskykniystitjbrptuuktype = pIfeTskykniystitjbrptuuktype;
    }

    @Column(order = 251, label = "kykniyustitjbrp")
    private String ifeTskykniyustitjbrp;

    public String getIfeTskykniyustitjbrp() {
        return ifeTskykniyustitjbrp;
    }

    public void setIfeTskykniyustitjbrp(String pIfeTskykniyustitjbrp) {
        ifeTskykniyustitjbrp = pIfeTskykniyustitjbrp;
    }

    @Column(order = 252, label = "kykniyustitjbrp$")
    private String ifeTskykniyustitjbrpt;

    public String getIfeTskykniyustitjbrpt() {
        return ifeTskykniyustitjbrpt;
    }

    public void setIfeTskykniyustitjbrpt(String pIfeTskykniyustitjbrpt) {
        ifeTskykniyustitjbrpt = pIfeTskykniyustitjbrpt;
    }

    @Column(order = 253, label = "stnaiyouranmsgcd1")
    private String ifeTsstnaiyouranmsgcd1;

    public String getIfeTsstnaiyouranmsgcd1() {
        return ifeTsstnaiyouranmsgcd1;
    }

    public void setIfeTsstnaiyouranmsgcd1(String pIfeTsstnaiyouranmsgcd1) {
        ifeTsstnaiyouranmsgcd1 = pIfeTsstnaiyouranmsgcd1;
    }

    @Column(order = 254, label = "stnaiyouranmsgcd2")
    private String ifeTsstnaiyouranmsgcd2;

    public String getIfeTsstnaiyouranmsgcd2() {
        return ifeTsstnaiyouranmsgcd2;
    }

    public void setIfeTsstnaiyouranmsgcd2(String pIfeTsstnaiyouranmsgcd2) {
        ifeTsstnaiyouranmsgcd2 = pIfeTsstnaiyouranmsgcd2;
    }

    @Column(order = 255, label = "stnaiyouranmsgcd3")
    private String ifeTsstnaiyouranmsgcd3;

    public String getIfeTsstnaiyouranmsgcd3() {
        return ifeTsstnaiyouranmsgcd3;
    }

    public void setIfeTsstnaiyouranmsgcd3(String pIfeTsstnaiyouranmsgcd3) {
        ifeTsstnaiyouranmsgcd3 = pIfeTsstnaiyouranmsgcd3;
    }

    @Column(order = 256, label = "stnaiyouranmsgcd4")
    private String ifeTsstnaiyouranmsgcd4;

    public String getIfeTsstnaiyouranmsgcd4() {
        return ifeTsstnaiyouranmsgcd4;
    }

    public void setIfeTsstnaiyouranmsgcd4(String pIfeTsstnaiyouranmsgcd4) {
        ifeTsstnaiyouranmsgcd4 = pIfeTsstnaiyouranmsgcd4;
    }

    @Column(order = 257, label = "stnaiyouranmsgcd5")
    private String ifeTsstnaiyouranmsgcd5;

    public String getIfeTsstnaiyouranmsgcd5() {
        return ifeTsstnaiyouranmsgcd5;
    }

    public void setIfeTsstnaiyouranmsgcd5(String pIfeTsstnaiyouranmsgcd5) {
        ifeTsstnaiyouranmsgcd5 = pIfeTsstnaiyouranmsgcd5;
    }

    @Column(order = 258, label = "stnaiyouranmsgcd6")
    private String ifeTsstnaiyouranmsgcd6;

    public String getIfeTsstnaiyouranmsgcd6() {
        return ifeTsstnaiyouranmsgcd6;
    }

    public void setIfeTsstnaiyouranmsgcd6(String pIfeTsstnaiyouranmsgcd6) {
        ifeTsstnaiyouranmsgcd6 = pIfeTsstnaiyouranmsgcd6;
    }

    @Column(order = 259, label = "stnaiyouranmsgcd7")
    private String ifeTsstnaiyouranmsgcd7;

    public String getIfeTsstnaiyouranmsgcd7() {
        return ifeTsstnaiyouranmsgcd7;
    }

    public void setIfeTsstnaiyouranmsgcd7(String pIfeTsstnaiyouranmsgcd7) {
        ifeTsstnaiyouranmsgcd7 = pIfeTsstnaiyouranmsgcd7;
    }

    @Column(order = 260, label = "stnaiyouranmsgcd8")
    private String ifeTsstnaiyouranmsgcd8;

    public String getIfeTsstnaiyouranmsgcd8() {
        return ifeTsstnaiyouranmsgcd8;
    }

    public void setIfeTsstnaiyouranmsgcd8(String pIfeTsstnaiyouranmsgcd8) {
        ifeTsstnaiyouranmsgcd8 = pIfeTsstnaiyouranmsgcd8;
    }

    @Column(order = 261, label = "stnaiyouranmsgcd9")
    private String ifeTsstnaiyouranmsgcd9;

    public String getIfeTsstnaiyouranmsgcd9() {
        return ifeTsstnaiyouranmsgcd9;
    }

    public void setIfeTsstnaiyouranmsgcd9(String pIfeTsstnaiyouranmsgcd9) {
        ifeTsstnaiyouranmsgcd9 = pIfeTsstnaiyouranmsgcd9;
    }

    @Column(order = 262, label = "stnaiyouranmsgcd10")
    private String ifeTsstnaiyouranmsgcd10;

    public String getIfeTsstnaiyouranmsgcd10() {
        return ifeTsstnaiyouranmsgcd10;
    }

    public void setIfeTsstnaiyouranmsgcd10(String pIfeTsstnaiyouranmsgcd10) {
        ifeTsstnaiyouranmsgcd10 = pIfeTsstnaiyouranmsgcd10;
    }

    @Column(order = 263, label = "stnaiyouranmsgcd11")
    private String ifeTsstnaiyouranmsgcd11;

    public String getIfeTsstnaiyouranmsgcd11() {
        return ifeTsstnaiyouranmsgcd11;
    }

    public void setIfeTsstnaiyouranmsgcd11(String pIfeTsstnaiyouranmsgcd11) {
        ifeTsstnaiyouranmsgcd11 = pIfeTsstnaiyouranmsgcd11;
    }

    @Column(order = 264, label = "stnaiyouranmsgcd12")
    private String ifeTsstnaiyouranmsgcd12;

    public String getIfeTsstnaiyouranmsgcd12() {
        return ifeTsstnaiyouranmsgcd12;
    }

    public void setIfeTsstnaiyouranmsgcd12(String pIfeTsstnaiyouranmsgcd12) {
        ifeTsstnaiyouranmsgcd12 = pIfeTsstnaiyouranmsgcd12;
    }

    @Column(order = 265, label = "stnaiyouranmsgcd13")
    private String ifeTsstnaiyouranmsgcd13;

    public String getIfeTsstnaiyouranmsgcd13() {
        return ifeTsstnaiyouranmsgcd13;
    }

    public void setIfeTsstnaiyouranmsgcd13(String pIfeTsstnaiyouranmsgcd13) {
        ifeTsstnaiyouranmsgcd13 = pIfeTsstnaiyouranmsgcd13;
    }

    @Column(order = 266, label = "stnaiyouranmsgcd14")
    private String ifeTsstnaiyouranmsgcd14;

    public String getIfeTsstnaiyouranmsgcd14() {
        return ifeTsstnaiyouranmsgcd14;
    }

    public void setIfeTsstnaiyouranmsgcd14(String pIfeTsstnaiyouranmsgcd14) {
        ifeTsstnaiyouranmsgcd14 = pIfeTsstnaiyouranmsgcd14;
    }

    @Column(order = 267, label = "stnaiyouranmsgcd15")
    private String ifeTsstnaiyouranmsgcd15;

    public String getIfeTsstnaiyouranmsgcd15() {
        return ifeTsstnaiyouranmsgcd15;
    }

    public void setIfeTsstnaiyouranmsgcd15(String pIfeTsstnaiyouranmsgcd15) {
        ifeTsstnaiyouranmsgcd15 = pIfeTsstnaiyouranmsgcd15;
    }

    @Column(order = 268, label = "stnaiyouranmsgcd16")
    private String ifeTsstnaiyouranmsgcd16;

    public String getIfeTsstnaiyouranmsgcd16() {
        return ifeTsstnaiyouranmsgcd16;
    }

    public void setIfeTsstnaiyouranmsgcd16(String pIfeTsstnaiyouranmsgcd16) {
        ifeTsstnaiyouranmsgcd16 = pIfeTsstnaiyouranmsgcd16;
    }

    @Column(order = 269, label = "stnaiyouranmsgcd17")
    private String ifeTsstnaiyouranmsgcd17;

    public String getIfeTsstnaiyouranmsgcd17() {
        return ifeTsstnaiyouranmsgcd17;
    }

    public void setIfeTsstnaiyouranmsgcd17(String pIfeTsstnaiyouranmsgcd17) {
        ifeTsstnaiyouranmsgcd17 = pIfeTsstnaiyouranmsgcd17;
    }

    @Column(order = 270, label = "stnaiyouranmsgcd18")
    private String ifeTsstnaiyouranmsgcd18;

    public String getIfeTsstnaiyouranmsgcd18() {
        return ifeTsstnaiyouranmsgcd18;
    }

    public void setIfeTsstnaiyouranmsgcd18(String pIfeTsstnaiyouranmsgcd18) {
        ifeTsstnaiyouranmsgcd18 = pIfeTsstnaiyouranmsgcd18;
    }

    @Column(order = 271, label = "stnaiyouranmsgcd19")
    private String ifeTsstnaiyouranmsgcd19;

    public String getIfeTsstnaiyouranmsgcd19() {
        return ifeTsstnaiyouranmsgcd19;
    }

    public void setIfeTsstnaiyouranmsgcd19(String pIfeTsstnaiyouranmsgcd19) {
        ifeTsstnaiyouranmsgcd19 = pIfeTsstnaiyouranmsgcd19;
    }

    @Column(order = 272, label = "stnaiyouranmsgcd20")
    private String ifeTsstnaiyouranmsgcd20;

    public String getIfeTsstnaiyouranmsgcd20() {
        return ifeTsstnaiyouranmsgcd20;
    }

    public void setIfeTsstnaiyouranmsgcd20(String pIfeTsstnaiyouranmsgcd20) {
        ifeTsstnaiyouranmsgcd20 = pIfeTsstnaiyouranmsgcd20;
    }

    @Column(order = 273, label = "sonotanyransiteituuka")
    private String ifeTssonotanyransiteituuka;

    public String getIfeTssonotanyransiteituuka() {
        return ifeTssonotanyransiteituuka;
    }

    public void setIfeTssonotanyransiteituuka(String pIfeTssonotanyransiteituuka) {
        ifeTssonotanyransiteituuka = pIfeTssonotanyransiteituuka;
    }

    @Column(order = 274, label = "sonotanyrannykntuktype")
    private String ifeTssonotanyrannykntuktype;

    public String getIfeTssonotanyrannykntuktype() {
        return ifeTssonotanyrannykntuktype;
    }

    public void setIfeTssonotanyrannykntuktype(String pIfeTssonotanyrannykntuktype) {
        ifeTssonotanyrannykntuktype = pIfeTssonotanyrannykntuktype;
    }

    @Column(order = 275, label = "sonotanyrannykntuukap")
    private String ifeTssonotanyrannykntuukap;

    public String getIfeTssonotanyrannykntuukap() {
        return ifeTssonotanyrannykntuukap;
    }

    public void setIfeTssonotanyrannykntuukap(String pIfeTssonotanyrannykntuukap) {
        ifeTssonotanyrannykntuukap = pIfeTssonotanyrannykntuukap;
    }

    @Column(order = 276, label = "sonotanyrannykntuukap$")
    private String ifeTssonotanyrannykntuukapt;

    public String getIfeTssonotanyrannykntuukapt() {
        return ifeTssonotanyrannykntuukapt;
    }

    public void setIfeTssonotanyrannykntuukapt(String pIfeTssonotanyrannykntuukapt) {
        ifeTssonotanyrannykntuukapt = pIfeTssonotanyrannykntuukapt;
    }

    @Column(order = 277, label = "sonotanyrannykntuukasyu")
    private String ifeTssntnyrannykntuukasyu;

    public String getIfeTssntnyrannykntuukasyu() {
        return ifeTssntnyrannykntuukasyu;
    }

    public void setIfeTssntnyrannykntuukasyu(String pIfeTssntnyrannykntuukasyu) {
        ifeTssntnyrannykntuukasyu = pIfeTssntnyrannykntuukasyu;
    }

    @Column(order = 278, label = "sonotanyranenkhrikmrate")
    private String ifeTssntnyranenkhrikmrate;

    public String getIfeTssntnyranenkhrikmrate() {
        return ifeTssntnyranenkhrikmrate;
    }

    public void setIfeTssntnyranenkhrikmrate(String pIfeTssntnyranenkhrikmrate) {
        ifeTssntnyranenkhrikmrate = pIfeTssntnyranenkhrikmrate;
    }

    @Column(order = 279, label = "sonotanyranstigikwsrate")
    private String ifeTssntnyranstigikwsrate;

    public String getIfeTssntnyranstigikwsrate() {
        return ifeTssntnyranstigikwsrate;
    }

    public void setIfeTssntnyranstigikwsrate(String pIfeTssntnyranstigikwsrate) {
        ifeTssntnyranstigikwsrate = pIfeTssntnyranstigikwsrate;
    }

    @Column(order = 280, label = "sonotanyrankjnkngktuktype")
    private String ifeTssntnyrankjnkngktuktype;

    public String getIfeTssntnyrankjnkngktuktype() {
        return ifeTssntnyrankjnkngktuktype;
    }

    public void setIfeTssntnyrankjnkngktuktype(String pIfeTssntnyrankjnkngktuktype) {
        ifeTssntnyrankjnkngktuktype = pIfeTssntnyrankjnkngktuktype;
    }

    @Column(order = 281, label = "sonotanyrankjnkngk")
    private String ifeTssonotanyrankjnkngk;

    public String getIfeTssonotanyrankjnkngk() {
        return ifeTssonotanyrankjnkngk;
    }

    public void setIfeTssonotanyrankjnkngk(String pIfeTssonotanyrankjnkngk) {
        ifeTssonotanyrankjnkngk = pIfeTssonotanyrankjnkngk;
    }

    @Column(order = 282, label = "sonotanyrankjnkngk$")
    private String ifeTssonotanyrankjnkngkt;

    public String getIfeTssonotanyrankjnkngkt() {
        return ifeTssonotanyrankjnkngkt;
    }

    public void setIfeTssonotanyrankjnkngkt(String pIfeTssonotanyrankjnkngkt) {
        ifeTssonotanyrankjnkngkt = pIfeTssonotanyrankjnkngkt;
    }

    @Column(order = 283, label = "sonotanyrankjnkngkrate")
    private String ifeTssonotanyrankjnkngkrate;

    public String getIfeTssonotanyrankjnkngkrate() {
        return ifeTssonotanyrankjnkngkrate;
    }

    public void setIfeTssonotanyrankjnkngkrate(String pIfeTssonotanyrankjnkngkrate) {
        ifeTssonotanyrankjnkngkrate = pIfeTssonotanyrankjnkngkrate;
    }

    @Column(order = 284, label = "sonotanyrankjnkngktuuka")
    private String ifeTssntnyrankjnkngktuuka;

    public String getIfeTssntnyrankjnkngktuuka() {
        return ifeTssntnyrankjnkngktuuka;
    }

    public void setIfeTssntnyrankjnkngktuuka(String pIfeTssntnyrankjnkngktuuka) {
        ifeTssntnyrankjnkngktuuka = pIfeTssntnyrankjnkngktuuka;
    }

    @Column(order = 285, label = "sonotanyranpentuktype")
    private String ifeTssonotanyranpentuktype;

    public String getIfeTssonotanyranpentuktype() {
        return ifeTssonotanyranpentuktype;
    }

    public void setIfeTssonotanyranpentuktype(String pIfeTssonotanyranpentuktype) {
        ifeTssonotanyranpentuktype = pIfeTssonotanyranpentuktype;
    }

    @Column(order = 286, label = "sonotanyranpenknsngk")
    private String ifeTssonotanyranpenknsngk;

    public String getIfeTssonotanyranpenknsngk() {
        return ifeTssonotanyranpenknsngk;
    }

    public void setIfeTssonotanyranpenknsngk(String pIfeTssonotanyranpenknsngk) {
        ifeTssonotanyranpenknsngk = pIfeTssonotanyranpenknsngk;
    }

    @Column(order = 287, label = "sonotanyranpenknsngk$")
    private String ifeTssonotanyranpenknsngkt;

    public String getIfeTssonotanyranpenknsngkt() {
        return ifeTssonotanyranpenknsngkt;
    }

    public void setIfeTssonotanyranpenknsngkt(String pIfeTssonotanyranpenknsngkt) {
        ifeTssonotanyranpenknsngkt = pIfeTssonotanyranpenknsngkt;
    }

    @Column(order = 288, label = "sonotanyranmkhwariai")
    private String ifeTssonotanyranmkhwariai;

    public String getIfeTssonotanyranmkhwariai() {
        return ifeTssonotanyranmkhwariai;
    }

    public void setIfeTssonotanyranmkhwariai(String pIfeTssonotanyranmkhwariai) {
        ifeTssonotanyranmkhwariai = pIfeTssonotanyranmkhwariai;
    }

    @Column(order = 289, label = "sonotanyranytirrt")
    private String ifeTssonotanyranytirrt;

    public String getIfeTssonotanyranytirrt() {
        return ifeTssonotanyranytirrt;
    }

    public void setIfeTssonotanyranytirrt(String pIfeTssonotanyranytirrt) {
        ifeTssonotanyranytirrt = pIfeTssonotanyranytirrt;
    }

    @Column(order = 290, label = "sonotanyransjkkktusirrt")
    private String ifeTssntnyransjkkktusirrt;

    public String getIfeTssntnyransjkkktusirrt() {
        return ifeTssntnyransjkkktusirrt;
    }

    public void setIfeTssntnyransjkkktusirrt(String pIfeTssntnyransjkkktusirrt) {
        ifeTssntnyransjkkktusirrt = pIfeTssntnyransjkkktusirrt;
    }

    @Column(order = 291, label = "stnaiyourangaimsgcd")
    private String ifeTsstnaiyourangaimsgcd;

    public String getIfeTsstnaiyourangaimsgcd() {
        return ifeTsstnaiyourangaimsgcd;
    }

    public void setIfeTsstnaiyourangaimsgcd(String pIfeTsstnaiyourangaimsgcd) {
        ifeTsstnaiyourangaimsgcd = pIfeTsstnaiyourangaimsgcd;
    }

    @Column(order = 292, label = "tsinyno")
    private String ifeTstsinyno;

    public String getIfeTstsinyno() {
        return ifeTstsinyno;
    }

    public void setIfeTstsinyno(String pIfeTstsinyno) {
        ifeTstsinyno = pIfeTstsinyno;
    }

    @Column(order = 293, label = "tsinadr1kj")
    private String ifeTstsinadr1kj;

    public String getIfeTstsinadr1kj() {
        return ifeTstsinadr1kj;
    }

    public void setIfeTstsinadr1kj(String pIfeTstsinadr1kj) {
        ifeTstsinadr1kj = pIfeTstsinadr1kj;
    }

    @Column(order = 294, label = "tsinadr2kj")
    private String ifeTstsinadr2kj;

    public String getIfeTstsinadr2kj() {
        return ifeTstsinadr2kj;
    }

    public void setIfeTstsinadr2kj(String pIfeTstsinadr2kj) {
        ifeTstsinadr2kj = pIfeTstsinadr2kj;
    }

    @Column(order = 295, label = "tsinadr3kj")
    private String ifeTstsinadr3kj;

    public String getIfeTstsinadr3kj() {
        return ifeTstsinadr3kj;
    }

    public void setIfeTstsinadr3kj(String pIfeTstsinadr3kj) {
        ifeTstsinadr3kj = pIfeTstsinadr3kj;
    }

    @Column(order = 296, label = "shsnmkj")
    private String ifeTsshsnmkj;

    public String getIfeTsshsnmkj() {
        return ifeTsshsnmkj;
    }

    public void setIfeTsshsnmkj(String pIfeTsshsnmkj) {
        ifeTsshsnmkj = pIfeTsshsnmkj;
    }

    @Column(order = 297, label = "tnknmissmsg")
    private String ifeTstnknmissmsg;

    public String getIfeTstnknmissmsg() {
        return ifeTstnknmissmsg;
    }

    public void setIfeTstnknmissmsg(String pIfeTstnknmissmsg) {
        ifeTstnknmissmsg = pIfeTstnknmissmsg;
    }

    @Column(order = 298, label = "errormsgcd")
    private String ifeTserrormsgcd;

    public String getIfeTserrormsgcd() {
        return ifeTserrormsgcd;
    }

    public void setIfeTserrormsgcd(String pIfeTserrormsgcd) {
        ifeTserrormsgcd = pIfeTserrormsgcd;
    }

    @Column(order = 299, label = "sisyacd")
    private String ifeTssisyacd;

    public String getIfeTssisyacd() {
        return ifeTssisyacd;
    }

    public void setIfeTssisyacd(String pIfeTssisyacd) {
        ifeTssisyacd = pIfeTssisyacd;
    }

    @Column(order = 300, label = "duhutusnrntousaadrmsgcd")
    private String ifeTsdhutusnrntousaadrmsgcd;

    public String getIfeTsdhutusnrntousaadrmsgcd() {
        return ifeTsdhutusnrntousaadrmsgcd;
    }

    public void setIfeTsdhutusnrntousaadrmsgcd(String pIfeTsdhutusnrntousaadrmsgcd) {
        ifeTsdhutusnrntousaadrmsgcd = pIfeTsdhutusnrntousaadrmsgcd;
    }

    @Column(order = 301, label = "duhutusnrnsyono")
    private String ifeTsduhutusnrnsyono;

    public String getIfeTsduhutusnrnsyono() {
        return ifeTsduhutusnrnsyono;
    }

    public void setIfeTsduhutusnrnsyono(String pIfeTsduhutusnrnsyono) {
        ifeTsduhutusnrnsyono = pIfeTsduhutusnrnsyono;
    }

    @Column(order = 302, label = "channelcd")
    private String ifeTschannelcd;

    public String getIfeTschannelcd() {
        return ifeTschannelcd;
    }

    public void setIfeTschannelcd(String pIfeTschannelcd) {
        ifeTschannelcd = pIfeTschannelcd;
    }

    @Column(order = 303, label = "dairitenmidasikbn")
    private String ifeTsdairitenmidasikbn;

    public String getIfeTsdairitenmidasikbn() {
        return ifeTsdairitenmidasikbn;
    }

    public void setIfeTsdairitenmidasikbn(String pIfeTsdairitenmidasikbn) {
        ifeTsdairitenmidasikbn = pIfeTsdairitenmidasikbn;
    }

    @Column(order = 304, label = "drtennm1kj")
    private String ifeTsdrtennm1kj;

    public String getIfeTsdrtennm1kj() {
        return ifeTsdrtennm1kj;
    }

    public void setIfeTsdrtennm1kj(String pIfeTsdrtennm1kj) {
        ifeTsdrtennm1kj = pIfeTsdrtennm1kj;
    }

    @Column(order = 305, label = "drtennm2kj")
    private String ifeTsdrtennm2kj;

    public String getIfeTsdrtennm2kj() {
        return ifeTsdrtennm2kj;
    }

    public void setIfeTsdrtennm2kj(String pIfeTsdrtennm2kj) {
        ifeTsdrtennm2kj = pIfeTsdrtennm2kj;
    }

    @Column(order = 306, label = "aisatumsgcd")
    private String ifeTsaisatumsgcd;

    public String getIfeTsaisatumsgcd() {
        return ifeTsaisatumsgcd;
    }

    public void setIfeTsaisatumsgcd(String pIfeTsaisatumsgcd) {
        ifeTsaisatumsgcd = pIfeTsaisatumsgcd;
    }

    @Column(order = 307, label = "ccmsgcd")
    private String ifeTsccmsgcd;

    public String getIfeTsccmsgcd() {
        return ifeTsccmsgcd;
    }

    public void setIfeTsccmsgcd(String pIfeTsccmsgcd) {
        ifeTsccmsgcd = pIfeTsccmsgcd;
    }

    @Column(order = 308, label = "hskmsgcd")
    private String ifeTshskmsgcd;

    public String getIfeTshskmsgcd() {
        return ifeTshskmsgcd;
    }

    public void setIfeTshskmsgcd(String pIfeTshskmsgcd) {
        ifeTshskmsgcd = pIfeTshskmsgcd;
    }

    @Column(order = 309, label = "hosyounymsgcd")
    private String ifeTshosyounymsgcd;

    public String getIfeTshosyounymsgcd() {
        return ifeTshosyounymsgcd;
    }

    public void setIfeTshosyounymsgcd(String pIfeTshosyounymsgcd) {
        ifeTshosyounymsgcd = pIfeTshosyounymsgcd;
    }

    @Column(order = 310, label = "hosyounyhihknsyameikanji")
    private String ifeTshosynyhihknsyameikanji;

    public String getIfeTshosynyhihknsyameikanji() {
        return ifeTshosynyhihknsyameikanji;
    }

    public void setIfeTshosynyhihknsyameikanji(String pIfeTshosynyhihknsyameikanji) {
        ifeTshosynyhihknsyameikanji = pIfeTshosynyhihknsyameikanji;
    }

    @Column(order = 311, label = "siboumidasimsgcd")
    private String ifeTssiboumidasimsgcd;

    public String getIfeTssiboumidasimsgcd() {
        return ifeTssiboumidasimsgcd;
    }

    public void setIfeTssiboumidasimsgcd(String pIfeTssiboumidasimsgcd) {
        ifeTssiboumidasimsgcd = pIfeTssiboumidasimsgcd;
    }

    @Column(order = 312, label = "siboumidasimsgcd2")
    private String ifeTssiboumidasimsgcd2;

    public String getIfeTssiboumidasimsgcd2() {
        return ifeTssiboumidasimsgcd2;
    }

    public void setIfeTssiboumidasimsgcd2(String pIfeTssiboumidasimsgcd2) {
        ifeTssiboumidasimsgcd2 = pIfeTssiboumidasimsgcd2;
    }

    @Column(order = 313, label = "siboudai1hknkknmsgcd1")
    private String ifeTssiboudai1hknkknmsgcd1;

    public String getIfeTssiboudai1hknkknmsgcd1() {
        return ifeTssiboudai1hknkknmsgcd1;
    }

    public void setIfeTssiboudai1hknkknmsgcd1(String pIfeTssiboudai1hknkknmsgcd1) {
        ifeTssiboudai1hknkknmsgcd1 = pIfeTssiboudai1hknkknmsgcd1;
    }

    @Column(order = 314, label = "siboudai1hknkknmsgcd2")
    private String ifeTssiboudai1hknkknmsgcd2;

    public String getIfeTssiboudai1hknkknmsgcd2() {
        return ifeTssiboudai1hknkknmsgcd2;
    }

    public void setIfeTssiboudai1hknkknmsgcd2(String pIfeTssiboudai1hknkknmsgcd2) {
        ifeTssiboudai1hknkknmsgcd2 = pIfeTssiboudai1hknkknmsgcd2;
    }

    @Column(order = 315, label = "siboudai1hknkknigimsgcd")
    private String ifeTssiboud1hknkknigimsgcd;

    public String getIfeTssiboud1hknkknigimsgcd() {
        return ifeTssiboud1hknkknigimsgcd;
    }

    public void setIfeTssiboud1hknkknigimsgcd(String pIfeTssiboud1hknkknigimsgcd) {
        ifeTssiboud1hknkknigimsgcd = pIfeTssiboud1hknkknigimsgcd;
    }

    @Column(order = 316, label = "siboudai1hknkknigimsgcd2")
    private String ifeTssiboud1hknkknigimsgcd2;

    public String getIfeTssiboud1hknkknigimsgcd2() {
        return ifeTssiboud1hknkknigimsgcd2;
    }

    public void setIfeTssiboud1hknkknigimsgcd2(String pIfeTssiboud1hknkknigimsgcd2) {
        ifeTssiboud1hknkknigimsgcd2 = pIfeTssiboud1hknkknigimsgcd2;
    }

    @Column(order = 317, label = "siboudai1hknkknhrsmsgcd")
    private String ifeTssiboud1hknkknhrsmsgcd;

    public String getIfeTssiboud1hknkknhrsmsgcd() {
        return ifeTssiboud1hknkknhrsmsgcd;
    }

    public void setIfeTssiboud1hknkknhrsmsgcd(String pIfeTssiboud1hknkknhrsmsgcd) {
        ifeTssiboud1hknkknhrsmsgcd = pIfeTssiboud1hknkknhrsmsgcd;
    }

    @Column(order = 318, label = "siboudai1hknkknhrsmsgcd2")
    private String ifeTssiboud1hknkknhrsmsgcd2;

    public String getIfeTssiboud1hknkknhrsmsgcd2() {
        return ifeTssiboud1hknkknhrsmsgcd2;
    }

    public void setIfeTssiboud1hknkknhrsmsgcd2(String pIfeTssiboud1hknkknhrsmsgcd2) {
        ifeTssiboud1hknkknhrsmsgcd2 = pIfeTssiboud1hknkknhrsmsgcd2;
    }

    @Column(order = 319, label = "siboudai1hknkknsmrmsgcd")
    private String ifeTssiboud1hknkknsmrmsgcd;

    public String getIfeTssiboud1hknkknsmrmsgcd() {
        return ifeTssiboud1hknkknsmrmsgcd;
    }

    public void setIfeTssiboud1hknkknsmrmsgcd(String pIfeTssiboud1hknkknsmrmsgcd) {
        ifeTssiboud1hknkknsmrmsgcd = pIfeTssiboud1hknkknsmrmsgcd;
    }

    @Column(order = 320, label = "siboudai2hknkknmsgcd1")
    private String ifeTssiboudai2hknkknmsgcd1;

    public String getIfeTssiboudai2hknkknmsgcd1() {
        return ifeTssiboudai2hknkknmsgcd1;
    }

    public void setIfeTssiboudai2hknkknmsgcd1(String pIfeTssiboudai2hknkknmsgcd1) {
        ifeTssiboudai2hknkknmsgcd1 = pIfeTssiboudai2hknkknmsgcd1;
    }

    @Column(order = 321, label = "siboudai2hknkknmsgcd2")
    private String ifeTssiboudai2hknkknmsgcd2;

    public String getIfeTssiboudai2hknkknmsgcd2() {
        return ifeTssiboudai2hknkknmsgcd2;
    }

    public void setIfeTssiboudai2hknkknmsgcd2(String pIfeTssiboudai2hknkknmsgcd2) {
        ifeTssiboudai2hknkknmsgcd2 = pIfeTssiboudai2hknkknmsgcd2;
    }

    @Column(order = 322, label = "siboudai2hknkknsmsgcd")
    private String ifeTssiboudai2hknkknsmsgcd;

    public String getIfeTssiboudai2hknkknsmsgcd() {
        return ifeTssiboudai2hknkknsmsgcd;
    }

    public void setIfeTssiboudai2hknkknsmsgcd(String pIfeTssiboudai2hknkknsmsgcd) {
        ifeTssiboudai2hknkknsmsgcd = pIfeTssiboudai2hknkknsmsgcd;
    }

    @Column(order = 323, label = "siboudai2hknkknsmsgcd2")
    private String ifeTssiboudai2hknkknsmsgcd2;

    public String getIfeTssiboudai2hknkknsmsgcd2() {
        return ifeTssiboudai2hknkknsmsgcd2;
    }

    public void setIfeTssiboudai2hknkknsmsgcd2(String pIfeTssiboudai2hknkknsmsgcd2) {
        ifeTssiboudai2hknkknsmsgcd2 = pIfeTssiboudai2hknkknsmsgcd2;
    }

    @Column(order = 324, label = "siboudai3hknkknmsgcd1")
    private String ifeTssiboudai3hknkknmsgcd1;

    public String getIfeTssiboudai3hknkknmsgcd1() {
        return ifeTssiboudai3hknkknmsgcd1;
    }

    public void setIfeTssiboudai3hknkknmsgcd1(String pIfeTssiboudai3hknkknmsgcd1) {
        ifeTssiboudai3hknkknmsgcd1 = pIfeTssiboudai3hknkknmsgcd1;
    }

    @Column(order = 325, label = "siboudai3hknkknmsgcd2")
    private String ifeTssiboudai3hknkknmsgcd2;

    public String getIfeTssiboudai3hknkknmsgcd2() {
        return ifeTssiboudai3hknkknmsgcd2;
    }

    public void setIfeTssiboudai3hknkknmsgcd2(String pIfeTssiboudai3hknkknmsgcd2) {
        ifeTssiboudai3hknkknmsgcd2 = pIfeTssiboudai3hknkknmsgcd2;
    }

    @Column(order = 326, label = "siboudai1hknkkn")
    private String ifeTssiboudai1hknkkn;

    public String getIfeTssiboudai1hknkkn() {
        return ifeTssiboudai1hknkkn;
    }

    public void setIfeTssiboudai1hknkkn(String pIfeTssiboudai1hknkkn) {
        ifeTssiboudai1hknkkn = pIfeTssiboudai1hknkkn;
    }

    @Column(order = 327, label = "siboudai1hknkknymdto")
    private String ifeTssiboudai1hknkknymdto;

    public String getIfeTssiboudai1hknkknymdto() {
        return ifeTssiboudai1hknkknymdto;
    }

    public void setIfeTssiboudai1hknkknymdto(String pIfeTssiboudai1hknkknymdto) {
        ifeTssiboudai1hknkknymdto = pIfeTssiboudai1hknkknymdto;
    }

    @Column(order = 328, label = "sibouitjbrpyentuuktype")
    private String ifeTssibouitjbrpyentuuktype;

    public String getIfeTssibouitjbrpyentuuktype() {
        return ifeTssibouitjbrpyentuuktype;
    }

    public void setIfeTssibouitjbrpyentuuktype(String pIfeTssibouitjbrpyentuuktype) {
        ifeTssibouitjbrpyentuuktype = pIfeTssibouitjbrpyentuuktype;
    }

    @Column(order = 329, label = "sibouitjbrpyentuukgk")
    private String ifeTssibouitjbrpyentuukgk;

    public String getIfeTssibouitjbrpyentuukgk() {
        return ifeTssibouitjbrpyentuukgk;
    }

    public void setIfeTssibouitjbrpyentuukgk(String pIfeTssibouitjbrpyentuukgk) {
        ifeTssibouitjbrpyentuukgk = pIfeTssibouitjbrpyentuukgk;
    }

    @Column(order = 330, label = "sibouitjbrpyentuukgk$")
    private String ifeTssibouitjbrpyentuukgkt;

    public String getIfeTssibouitjbrpyentuukgkt() {
        return ifeTssibouitjbrpyentuukgkt;
    }

    public void setIfeTssibouitjbrpyentuukgkt(String pIfeTssibouitjbrpyentuukgkt) {
        ifeTssibouitjbrpyentuukgkt = pIfeTssibouitjbrpyentuukgkt;
    }

    @Column(order = 331, label = "siboudai1kjnkngktuuktype")
    private String ifeTssiboud1kjnkngktuuktype;

    public String getIfeTssiboud1kjnkngktuuktype() {
        return ifeTssiboud1kjnkngktuuktype;
    }

    public void setIfeTssiboud1kjnkngktuuktype(String pIfeTssiboud1kjnkngktuuktype) {
        ifeTssiboud1kjnkngktuuktype = pIfeTssiboud1kjnkngktuuktype;
    }

    @Column(order = 332, label = "siboudai1kjnkngk")
    private String ifeTssiboudai1kjnkngk;

    public String getIfeTssiboudai1kjnkngk() {
        return ifeTssiboudai1kjnkngk;
    }

    public void setIfeTssiboudai1kjnkngk(String pIfeTssiboudai1kjnkngk) {
        ifeTssiboudai1kjnkngk = pIfeTssiboudai1kjnkngk;
    }

    @Column(order = 333, label = "siboudai1kjnkngk$")
    private String ifeTssiboudai1kjnkngkt;

    public String getIfeTssiboudai1kjnkngkt() {
        return ifeTssiboudai1kjnkngkt;
    }

    public void setIfeTssiboudai1kjnkngkt(String pIfeTssiboudai1kjnkngkt) {
        ifeTssiboudai1kjnkngkt = pIfeTssiboudai1kjnkngkt;
    }

    @Column(order = 334, label = "siboudai2hknkkn")
    private String ifeTssiboudai2hknkkn;

    public String getIfeTssiboudai2hknkkn() {
        return ifeTssiboudai2hknkkn;
    }

    public void setIfeTssiboudai2hknkkn(String pIfeTssiboudai2hknkkn) {
        ifeTssiboudai2hknkkn = pIfeTssiboudai2hknkkn;
    }

    @Column(order = 335, label = "siboudai2hknkknymdto")
    private String ifeTssiboudai2hknkknymdto;

    public String getIfeTssiboudai2hknkknymdto() {
        return ifeTssiboudai2hknkknymdto;
    }

    public void setIfeTssiboudai2hknkknymdto(String pIfeTssiboudai2hknkknymdto) {
        ifeTssiboudai2hknkknymdto = pIfeTssiboudai2hknkknymdto;
    }

    @Column(order = 336, label = "siboudai2kjnkngktuuktype")
    private String ifeTssiboud2kjnkngktuuktype;

    public String getIfeTssiboud2kjnkngktuuktype() {
        return ifeTssiboud2kjnkngktuuktype;
    }

    public void setIfeTssiboud2kjnkngktuuktype(String pIfeTssiboud2kjnkngktuuktype) {
        ifeTssiboud2kjnkngktuuktype = pIfeTssiboud2kjnkngktuuktype;
    }

    @Column(order = 337, label = "siboudai2kjnkngk")
    private String ifeTssiboudai2kjnkngk;

    public String getIfeTssiboudai2kjnkngk() {
        return ifeTssiboudai2kjnkngk;
    }

    public void setIfeTssiboudai2kjnkngk(String pIfeTssiboudai2kjnkngk) {
        ifeTssiboudai2kjnkngk = pIfeTssiboudai2kjnkngk;
    }

    @Column(order = 338, label = "siboudai2kjnkngk$")
    private String ifeTssiboudai2kjnkngkt;

    public String getIfeTssiboudai2kjnkngkt() {
        return ifeTssiboudai2kjnkngkt;
    }

    public void setIfeTssiboudai2kjnkngkt(String pIfeTssiboudai2kjnkngkt) {
        ifeTssiboudai2kjnkngkt = pIfeTssiboudai2kjnkngkt;
    }

    @Column(order = 339, label = "siboudai3kjnkngktuuktype")
    private String ifeTssiboud3kjnkngktuuktype;

    public String getIfeTssiboud3kjnkngktuuktype() {
        return ifeTssiboud3kjnkngktuuktype;
    }

    public void setIfeTssiboud3kjnkngktuuktype(String pIfeTssiboud3kjnkngktuuktype) {
        ifeTssiboud3kjnkngktuuktype = pIfeTssiboud3kjnkngktuuktype;
    }

    @Column(order = 340, label = "siboudai3kjnkngk")
    private String ifeTssiboudai3kjnkngk;

    public String getIfeTssiboudai3kjnkngk() {
        return ifeTssiboudai3kjnkngk;
    }

    public void setIfeTssiboudai3kjnkngk(String pIfeTssiboudai3kjnkngk) {
        ifeTssiboudai3kjnkngk = pIfeTssiboudai3kjnkngk;
    }

    @Column(order = 341, label = "siboudai3kjnkngk$")
    private String ifeTssiboudai3kjnkngkt;

    public String getIfeTssiboudai3kjnkngkt() {
        return ifeTssiboudai3kjnkngkt;
    }

    public void setIfeTssiboudai3kjnkngkt(String pIfeTssiboudai3kjnkngkt) {
        ifeTssiboudai3kjnkngkt = pIfeTssiboudai3kjnkngkt;
    }

    @Column(order = 342, label = "dai1skwsrateyendaka")
    private String ifeTsdai1skwsrateyendaka;

    public String getIfeTsdai1skwsrateyendaka() {
        return ifeTsdai1skwsrateyendaka;
    }

    public void setIfeTsdai1skwsrateyendaka(String pIfeTsdai1skwsrateyendaka) {
        ifeTsdai1skwsrateyendaka = pIfeTsdai1skwsrateyendaka;
    }

    @Column(order = 343, label = "dai1skwsrateyenkijyun")
    private String ifeTsdai1skwsrateyenkijyun;

    public String getIfeTsdai1skwsrateyenkijyun() {
        return ifeTsdai1skwsrateyenkijyun;
    }

    public void setIfeTsdai1skwsrateyenkijyun(String pIfeTsdai1skwsrateyenkijyun) {
        ifeTsdai1skwsrateyenkijyun = pIfeTsdai1skwsrateyenkijyun;
    }

    @Column(order = 344, label = "dai1skwsrateyenyasu")
    private String ifeTsdai1skwsrateyenyasu;

    public String getIfeTsdai1skwsrateyenyasu() {
        return ifeTsdai1skwsrateyenyasu;
    }

    public void setIfeTsdai1skwsrateyenyasu(String pIfeTsdai1skwsrateyenyasu) {
        ifeTsdai1skwsrateyenyasu = pIfeTsdai1skwsrateyenyasu;
    }

    @Column(order = 345, label = "dai1skeikanensuu01")
    private String ifeTsdai1skeikanensuu01;

    public String getIfeTsdai1skeikanensuu01() {
        return ifeTsdai1skeikanensuu01;
    }

    public void setIfeTsdai1skeikanensuu01(String pIfeTsdai1skeikanensuu01) {
        ifeTsdai1skeikanensuu01 = pIfeTsdai1skeikanensuu01;
    }

    @Column(order = 346, label = "dai1sibousnenoutouymd01")
    private String ifeTsd1sibousnenoutouymd01;

    public String getIfeTsd1sibousnenoutouymd01() {
        return ifeTsd1sibousnenoutouymd01;
    }

    public void setIfeTsd1sibousnenoutouymd01(String pIfeTsd1sibousnenoutouymd01) {
        ifeTsd1sibousnenoutouymd01 = pIfeTsd1sibousnenoutouymd01;
    }

    @Column(order = 347, label = "dai1stuuktype01")
    private String ifeTsdai1stuuktype01;

    public String getIfeTsdai1stuuktype01() {
        return ifeTsdai1stuuktype01;
    }

    public void setIfeTsdai1stuuktype01(String pIfeTsdai1stuuktype01) {
        ifeTsdai1stuuktype01 = pIfeTsdai1stuuktype01;
    }

    @Column(order = 348, label = "dai1s01")
    private String ifeTsdai1s01;

    public String getIfeTsdai1s01() {
        return ifeTsdai1s01;
    }

    public void setIfeTsdai1s01(String pIfeTsdai1s01) {
        ifeTsdai1s01 = pIfeTsdai1s01;
    }

    @Column(order = 349, label = "dai1s01$")
    private String ifeTsdai1s01t;

    public String getIfeTsdai1s01t() {
        return ifeTsdai1s01t;
    }

    public void setIfeTsdai1s01t(String pIfeTsdai1s01t) {
        ifeTsdai1s01t = pIfeTsdai1s01t;
    }

    @Column(order = 350, label = "dai1syenyendakaumu01")
    private String ifeTsdai1syenyendakaumu01;

    public String getIfeTsdai1syenyendakaumu01() {
        return ifeTsdai1syenyendakaumu01;
    }

    public void setIfeTsdai1syenyendakaumu01(String pIfeTsdai1syenyendakaumu01) {
        ifeTsdai1syenyendakaumu01 = pIfeTsdai1syenyendakaumu01;
    }

    @Column(order = 351, label = "dai1syenyenkijyunumu01")
    private String ifeTsdai1syenyenkijyunumu01;

    public String getIfeTsdai1syenyenkijyunumu01() {
        return ifeTsdai1syenyenkijyunumu01;
    }

    public void setIfeTsdai1syenyenkijyunumu01(String pIfeTsdai1syenyenkijyunumu01) {
        ifeTsdai1syenyenkijyunumu01 = pIfeTsdai1syenyenkijyunumu01;
    }

    @Column(order = 352, label = "dai1syenyenyasuumu01")
    private String ifeTsdai1syenyenyasuumu01;

    public String getIfeTsdai1syenyenyasuumu01() {
        return ifeTsdai1syenyenyasuumu01;
    }

    public void setIfeTsdai1syenyenyasuumu01(String pIfeTsdai1syenyenyasuumu01) {
        ifeTsdai1syenyenyasuumu01 = pIfeTsdai1syenyenyasuumu01;
    }

    @Column(order = 353, label = "dai1syentuuktype01")
    private String ifeTsdai1syentuuktype01;

    public String getIfeTsdai1syentuuktype01() {
        return ifeTsdai1syentuuktype01;
    }

    public void setIfeTsdai1syentuuktype01(String pIfeTsdai1syentuuktype01) {
        ifeTsdai1syentuuktype01 = pIfeTsdai1syentuuktype01;
    }

    @Column(order = 354, label = "dai1syenyendaka01")
    private String ifeTsdai1syenyendaka01;

    public String getIfeTsdai1syenyendaka01() {
        return ifeTsdai1syenyendaka01;
    }

    public void setIfeTsdai1syenyendaka01(String pIfeTsdai1syenyendaka01) {
        ifeTsdai1syenyendaka01 = pIfeTsdai1syenyendaka01;
    }

    @Column(order = 355, label = "dai1syenyendaka01$")
    private String ifeTsdai1syenyendaka01t;

    public String getIfeTsdai1syenyendaka01t() {
        return ifeTsdai1syenyendaka01t;
    }

    public void setIfeTsdai1syenyendaka01t(String pIfeTsdai1syenyendaka01t) {
        ifeTsdai1syenyendaka01t = pIfeTsdai1syenyendaka01t;
    }

    @Column(order = 356, label = "dai1syenyenkijyun01")
    private String ifeTsdai1syenyenkijyun01;

    public String getIfeTsdai1syenyenkijyun01() {
        return ifeTsdai1syenyenkijyun01;
    }

    public void setIfeTsdai1syenyenkijyun01(String pIfeTsdai1syenyenkijyun01) {
        ifeTsdai1syenyenkijyun01 = pIfeTsdai1syenyenkijyun01;
    }

    @Column(order = 357, label = "dai1syenyenkijyun01$")
    private String ifeTsdai1syenyenkijyun01t;

    public String getIfeTsdai1syenyenkijyun01t() {
        return ifeTsdai1syenyenkijyun01t;
    }

    public void setIfeTsdai1syenyenkijyun01t(String pIfeTsdai1syenyenkijyun01t) {
        ifeTsdai1syenyenkijyun01t = pIfeTsdai1syenyenkijyun01t;
    }

    @Column(order = 358, label = "dai1syenyenyasu01")
    private String ifeTsdai1syenyenyasu01;

    public String getIfeTsdai1syenyenyasu01() {
        return ifeTsdai1syenyenyasu01;
    }

    public void setIfeTsdai1syenyenyasu01(String pIfeTsdai1syenyenyasu01) {
        ifeTsdai1syenyenyasu01 = pIfeTsdai1syenyenyasu01;
    }

    @Column(order = 359, label = "dai1syenyenyasu01$")
    private String ifeTsdai1syenyenyasu01t;

    public String getIfeTsdai1syenyenyasu01t() {
        return ifeTsdai1syenyenyasu01t;
    }

    public void setIfeTsdai1syenyenyasu01t(String pIfeTsdai1syenyenyasu01t) {
        ifeTsdai1syenyenyasu01t = pIfeTsdai1syenyenyasu01t;
    }

    @Column(order = 360, label = "dai1skeikanensuu02")
    private String ifeTsdai1skeikanensuu02;

    public String getIfeTsdai1skeikanensuu02() {
        return ifeTsdai1skeikanensuu02;
    }

    public void setIfeTsdai1skeikanensuu02(String pIfeTsdai1skeikanensuu02) {
        ifeTsdai1skeikanensuu02 = pIfeTsdai1skeikanensuu02;
    }

    @Column(order = 361, label = "dai1sibousnenoutouymd02")
    private String ifeTsd1sibousnenoutouymd02;

    public String getIfeTsd1sibousnenoutouymd02() {
        return ifeTsd1sibousnenoutouymd02;
    }

    public void setIfeTsd1sibousnenoutouymd02(String pIfeTsd1sibousnenoutouymd02) {
        ifeTsd1sibousnenoutouymd02 = pIfeTsd1sibousnenoutouymd02;
    }

    @Column(order = 362, label = "dai1stuuktype02")
    private String ifeTsdai1stuuktype02;

    public String getIfeTsdai1stuuktype02() {
        return ifeTsdai1stuuktype02;
    }

    public void setIfeTsdai1stuuktype02(String pIfeTsdai1stuuktype02) {
        ifeTsdai1stuuktype02 = pIfeTsdai1stuuktype02;
    }

    @Column(order = 363, label = "dai1s02")
    private String ifeTsdai1s02;

    public String getIfeTsdai1s02() {
        return ifeTsdai1s02;
    }

    public void setIfeTsdai1s02(String pIfeTsdai1s02) {
        ifeTsdai1s02 = pIfeTsdai1s02;
    }

    @Column(order = 364, label = "dai1s02$")
    private String ifeTsdai1s02t;

    public String getIfeTsdai1s02t() {
        return ifeTsdai1s02t;
    }

    public void setIfeTsdai1s02t(String pIfeTsdai1s02t) {
        ifeTsdai1s02t = pIfeTsdai1s02t;
    }

    @Column(order = 365, label = "dai1syenyendakaumu02")
    private String ifeTsdai1syenyendakaumu02;

    public String getIfeTsdai1syenyendakaumu02() {
        return ifeTsdai1syenyendakaumu02;
    }

    public void setIfeTsdai1syenyendakaumu02(String pIfeTsdai1syenyendakaumu02) {
        ifeTsdai1syenyendakaumu02 = pIfeTsdai1syenyendakaumu02;
    }

    @Column(order = 366, label = "dai1syenyenkijyunumu02")
    private String ifeTsdai1syenyenkijyunumu02;

    public String getIfeTsdai1syenyenkijyunumu02() {
        return ifeTsdai1syenyenkijyunumu02;
    }

    public void setIfeTsdai1syenyenkijyunumu02(String pIfeTsdai1syenyenkijyunumu02) {
        ifeTsdai1syenyenkijyunumu02 = pIfeTsdai1syenyenkijyunumu02;
    }

    @Column(order = 367, label = "dai1syenyenyasuumu02")
    private String ifeTsdai1syenyenyasuumu02;

    public String getIfeTsdai1syenyenyasuumu02() {
        return ifeTsdai1syenyenyasuumu02;
    }

    public void setIfeTsdai1syenyenyasuumu02(String pIfeTsdai1syenyenyasuumu02) {
        ifeTsdai1syenyenyasuumu02 = pIfeTsdai1syenyenyasuumu02;
    }

    @Column(order = 368, label = "dai1syentuuktype02")
    private String ifeTsdai1syentuuktype02;

    public String getIfeTsdai1syentuuktype02() {
        return ifeTsdai1syentuuktype02;
    }

    public void setIfeTsdai1syentuuktype02(String pIfeTsdai1syentuuktype02) {
        ifeTsdai1syentuuktype02 = pIfeTsdai1syentuuktype02;
    }

    @Column(order = 369, label = "dai1syenyendaka02")
    private String ifeTsdai1syenyendaka02;

    public String getIfeTsdai1syenyendaka02() {
        return ifeTsdai1syenyendaka02;
    }

    public void setIfeTsdai1syenyendaka02(String pIfeTsdai1syenyendaka02) {
        ifeTsdai1syenyendaka02 = pIfeTsdai1syenyendaka02;
    }

    @Column(order = 370, label = "dai1syenyendaka02$")
    private String ifeTsdai1syenyendaka02t;

    public String getIfeTsdai1syenyendaka02t() {
        return ifeTsdai1syenyendaka02t;
    }

    public void setIfeTsdai1syenyendaka02t(String pIfeTsdai1syenyendaka02t) {
        ifeTsdai1syenyendaka02t = pIfeTsdai1syenyendaka02t;
    }

    @Column(order = 371, label = "dai1syenyenkijyun02")
    private String ifeTsdai1syenyenkijyun02;

    public String getIfeTsdai1syenyenkijyun02() {
        return ifeTsdai1syenyenkijyun02;
    }

    public void setIfeTsdai1syenyenkijyun02(String pIfeTsdai1syenyenkijyun02) {
        ifeTsdai1syenyenkijyun02 = pIfeTsdai1syenyenkijyun02;
    }

    @Column(order = 372, label = "dai1syenyenkijyun02$")
    private String ifeTsdai1syenyenkijyun02t;

    public String getIfeTsdai1syenyenkijyun02t() {
        return ifeTsdai1syenyenkijyun02t;
    }

    public void setIfeTsdai1syenyenkijyun02t(String pIfeTsdai1syenyenkijyun02t) {
        ifeTsdai1syenyenkijyun02t = pIfeTsdai1syenyenkijyun02t;
    }

    @Column(order = 373, label = "dai1syenyenyasu02")
    private String ifeTsdai1syenyenyasu02;

    public String getIfeTsdai1syenyenyasu02() {
        return ifeTsdai1syenyenyasu02;
    }

    public void setIfeTsdai1syenyenyasu02(String pIfeTsdai1syenyenyasu02) {
        ifeTsdai1syenyenyasu02 = pIfeTsdai1syenyenyasu02;
    }

    @Column(order = 374, label = "dai1syenyenyasu02$")
    private String ifeTsdai1syenyenyasu02t;

    public String getIfeTsdai1syenyenyasu02t() {
        return ifeTsdai1syenyenyasu02t;
    }

    public void setIfeTsdai1syenyenyasu02t(String pIfeTsdai1syenyenyasu02t) {
        ifeTsdai1syenyenyasu02t = pIfeTsdai1syenyenyasu02t;
    }

    @Column(order = 375, label = "dai1skeikanensuu03")
    private String ifeTsdai1skeikanensuu03;

    public String getIfeTsdai1skeikanensuu03() {
        return ifeTsdai1skeikanensuu03;
    }

    public void setIfeTsdai1skeikanensuu03(String pIfeTsdai1skeikanensuu03) {
        ifeTsdai1skeikanensuu03 = pIfeTsdai1skeikanensuu03;
    }

    @Column(order = 376, label = "dai1sibousnenoutouymd03")
    private String ifeTsd1sibousnenoutouymd03;

    public String getIfeTsd1sibousnenoutouymd03() {
        return ifeTsd1sibousnenoutouymd03;
    }

    public void setIfeTsd1sibousnenoutouymd03(String pIfeTsd1sibousnenoutouymd03) {
        ifeTsd1sibousnenoutouymd03 = pIfeTsd1sibousnenoutouymd03;
    }

    @Column(order = 377, label = "dai1stuuktype03")
    private String ifeTsdai1stuuktype03;

    public String getIfeTsdai1stuuktype03() {
        return ifeTsdai1stuuktype03;
    }

    public void setIfeTsdai1stuuktype03(String pIfeTsdai1stuuktype03) {
        ifeTsdai1stuuktype03 = pIfeTsdai1stuuktype03;
    }

    @Column(order = 378, label = "dai1s03")
    private String ifeTsdai1s03;

    public String getIfeTsdai1s03() {
        return ifeTsdai1s03;
    }

    public void setIfeTsdai1s03(String pIfeTsdai1s03) {
        ifeTsdai1s03 = pIfeTsdai1s03;
    }

    @Column(order = 379, label = "dai1s03$")
    private String ifeTsdai1s03t;

    public String getIfeTsdai1s03t() {
        return ifeTsdai1s03t;
    }

    public void setIfeTsdai1s03t(String pIfeTsdai1s03t) {
        ifeTsdai1s03t = pIfeTsdai1s03t;
    }

    @Column(order = 380, label = "dai1syenyendakaumu03")
    private String ifeTsdai1syenyendakaumu03;

    public String getIfeTsdai1syenyendakaumu03() {
        return ifeTsdai1syenyendakaumu03;
    }

    public void setIfeTsdai1syenyendakaumu03(String pIfeTsdai1syenyendakaumu03) {
        ifeTsdai1syenyendakaumu03 = pIfeTsdai1syenyendakaumu03;
    }

    @Column(order = 381, label = "dai1syenyenkijyunumu03")
    private String ifeTsdai1syenyenkijyunumu03;

    public String getIfeTsdai1syenyenkijyunumu03() {
        return ifeTsdai1syenyenkijyunumu03;
    }

    public void setIfeTsdai1syenyenkijyunumu03(String pIfeTsdai1syenyenkijyunumu03) {
        ifeTsdai1syenyenkijyunumu03 = pIfeTsdai1syenyenkijyunumu03;
    }

    @Column(order = 382, label = "dai1syenyenyasuumu03")
    private String ifeTsdai1syenyenyasuumu03;

    public String getIfeTsdai1syenyenyasuumu03() {
        return ifeTsdai1syenyenyasuumu03;
    }

    public void setIfeTsdai1syenyenyasuumu03(String pIfeTsdai1syenyenyasuumu03) {
        ifeTsdai1syenyenyasuumu03 = pIfeTsdai1syenyenyasuumu03;
    }

    @Column(order = 383, label = "dai1syentuuktype03")
    private String ifeTsdai1syentuuktype03;

    public String getIfeTsdai1syentuuktype03() {
        return ifeTsdai1syentuuktype03;
    }

    public void setIfeTsdai1syentuuktype03(String pIfeTsdai1syentuuktype03) {
        ifeTsdai1syentuuktype03 = pIfeTsdai1syentuuktype03;
    }

    @Column(order = 384, label = "dai1syenyendaka03")
    private String ifeTsdai1syenyendaka03;

    public String getIfeTsdai1syenyendaka03() {
        return ifeTsdai1syenyendaka03;
    }

    public void setIfeTsdai1syenyendaka03(String pIfeTsdai1syenyendaka03) {
        ifeTsdai1syenyendaka03 = pIfeTsdai1syenyendaka03;
    }

    @Column(order = 385, label = "dai1syenyendaka03$")
    private String ifeTsdai1syenyendaka03t;

    public String getIfeTsdai1syenyendaka03t() {
        return ifeTsdai1syenyendaka03t;
    }

    public void setIfeTsdai1syenyendaka03t(String pIfeTsdai1syenyendaka03t) {
        ifeTsdai1syenyendaka03t = pIfeTsdai1syenyendaka03t;
    }

    @Column(order = 386, label = "dai1syenyenkijyun03")
    private String ifeTsdai1syenyenkijyun03;

    public String getIfeTsdai1syenyenkijyun03() {
        return ifeTsdai1syenyenkijyun03;
    }

    public void setIfeTsdai1syenyenkijyun03(String pIfeTsdai1syenyenkijyun03) {
        ifeTsdai1syenyenkijyun03 = pIfeTsdai1syenyenkijyun03;
    }

    @Column(order = 387, label = "dai1syenyenkijyun03$")
    private String ifeTsdai1syenyenkijyun03t;

    public String getIfeTsdai1syenyenkijyun03t() {
        return ifeTsdai1syenyenkijyun03t;
    }

    public void setIfeTsdai1syenyenkijyun03t(String pIfeTsdai1syenyenkijyun03t) {
        ifeTsdai1syenyenkijyun03t = pIfeTsdai1syenyenkijyun03t;
    }

    @Column(order = 388, label = "dai1syenyenyasu03")
    private String ifeTsdai1syenyenyasu03;

    public String getIfeTsdai1syenyenyasu03() {
        return ifeTsdai1syenyenyasu03;
    }

    public void setIfeTsdai1syenyenyasu03(String pIfeTsdai1syenyenyasu03) {
        ifeTsdai1syenyenyasu03 = pIfeTsdai1syenyenyasu03;
    }

    @Column(order = 389, label = "dai1syenyenyasu03$")
    private String ifeTsdai1syenyenyasu03t;

    public String getIfeTsdai1syenyenyasu03t() {
        return ifeTsdai1syenyenyasu03t;
    }

    public void setIfeTsdai1syenyenyasu03t(String pIfeTsdai1syenyenyasu03t) {
        ifeTsdai1syenyenyasu03t = pIfeTsdai1syenyenyasu03t;
    }

    @Column(order = 390, label = "dai1skeikanensuu04")
    private String ifeTsdai1skeikanensuu04;

    public String getIfeTsdai1skeikanensuu04() {
        return ifeTsdai1skeikanensuu04;
    }

    public void setIfeTsdai1skeikanensuu04(String pIfeTsdai1skeikanensuu04) {
        ifeTsdai1skeikanensuu04 = pIfeTsdai1skeikanensuu04;
    }

    @Column(order = 391, label = "dai1sibousnenoutouymd04")
    private String ifeTsd1sibousnenoutouymd04;

    public String getIfeTsd1sibousnenoutouymd04() {
        return ifeTsd1sibousnenoutouymd04;
    }

    public void setIfeTsd1sibousnenoutouymd04(String pIfeTsd1sibousnenoutouymd04) {
        ifeTsd1sibousnenoutouymd04 = pIfeTsd1sibousnenoutouymd04;
    }

    @Column(order = 392, label = "dai1stuuktype04")
    private String ifeTsdai1stuuktype04;

    public String getIfeTsdai1stuuktype04() {
        return ifeTsdai1stuuktype04;
    }

    public void setIfeTsdai1stuuktype04(String pIfeTsdai1stuuktype04) {
        ifeTsdai1stuuktype04 = pIfeTsdai1stuuktype04;
    }

    @Column(order = 393, label = "dai1s04")
    private String ifeTsdai1s04;

    public String getIfeTsdai1s04() {
        return ifeTsdai1s04;
    }

    public void setIfeTsdai1s04(String pIfeTsdai1s04) {
        ifeTsdai1s04 = pIfeTsdai1s04;
    }

    @Column(order = 394, label = "dai1s04$")
    private String ifeTsdai1s04t;

    public String getIfeTsdai1s04t() {
        return ifeTsdai1s04t;
    }

    public void setIfeTsdai1s04t(String pIfeTsdai1s04t) {
        ifeTsdai1s04t = pIfeTsdai1s04t;
    }

    @Column(order = 395, label = "dai1syenyendakaumu04")
    private String ifeTsdai1syenyendakaumu04;

    public String getIfeTsdai1syenyendakaumu04() {
        return ifeTsdai1syenyendakaumu04;
    }

    public void setIfeTsdai1syenyendakaumu04(String pIfeTsdai1syenyendakaumu04) {
        ifeTsdai1syenyendakaumu04 = pIfeTsdai1syenyendakaumu04;
    }

    @Column(order = 396, label = "dai1syenyenkijyunumu04")
    private String ifeTsdai1syenyenkijyunumu04;

    public String getIfeTsdai1syenyenkijyunumu04() {
        return ifeTsdai1syenyenkijyunumu04;
    }

    public void setIfeTsdai1syenyenkijyunumu04(String pIfeTsdai1syenyenkijyunumu04) {
        ifeTsdai1syenyenkijyunumu04 = pIfeTsdai1syenyenkijyunumu04;
    }

    @Column(order = 397, label = "dai1syenyenyasuumu04")
    private String ifeTsdai1syenyenyasuumu04;

    public String getIfeTsdai1syenyenyasuumu04() {
        return ifeTsdai1syenyenyasuumu04;
    }

    public void setIfeTsdai1syenyenyasuumu04(String pIfeTsdai1syenyenyasuumu04) {
        ifeTsdai1syenyenyasuumu04 = pIfeTsdai1syenyenyasuumu04;
    }

    @Column(order = 398, label = "dai1syentuuktype04")
    private String ifeTsdai1syentuuktype04;

    public String getIfeTsdai1syentuuktype04() {
        return ifeTsdai1syentuuktype04;
    }

    public void setIfeTsdai1syentuuktype04(String pIfeTsdai1syentuuktype04) {
        ifeTsdai1syentuuktype04 = pIfeTsdai1syentuuktype04;
    }

    @Column(order = 399, label = "dai1syenyendaka04")
    private String ifeTsdai1syenyendaka04;

    public String getIfeTsdai1syenyendaka04() {
        return ifeTsdai1syenyendaka04;
    }

    public void setIfeTsdai1syenyendaka04(String pIfeTsdai1syenyendaka04) {
        ifeTsdai1syenyendaka04 = pIfeTsdai1syenyendaka04;
    }

    @Column(order = 400, label = "dai1syenyendaka04$")
    private String ifeTsdai1syenyendaka04t;

    public String getIfeTsdai1syenyendaka04t() {
        return ifeTsdai1syenyendaka04t;
    }

    public void setIfeTsdai1syenyendaka04t(String pIfeTsdai1syenyendaka04t) {
        ifeTsdai1syenyendaka04t = pIfeTsdai1syenyendaka04t;
    }

    @Column(order = 401, label = "dai1syenyenkijyun04")
    private String ifeTsdai1syenyenkijyun04;

    public String getIfeTsdai1syenyenkijyun04() {
        return ifeTsdai1syenyenkijyun04;
    }

    public void setIfeTsdai1syenyenkijyun04(String pIfeTsdai1syenyenkijyun04) {
        ifeTsdai1syenyenkijyun04 = pIfeTsdai1syenyenkijyun04;
    }

    @Column(order = 402, label = "dai1syenyenkijyun04$")
    private String ifeTsdai1syenyenkijyun04t;

    public String getIfeTsdai1syenyenkijyun04t() {
        return ifeTsdai1syenyenkijyun04t;
    }

    public void setIfeTsdai1syenyenkijyun04t(String pIfeTsdai1syenyenkijyun04t) {
        ifeTsdai1syenyenkijyun04t = pIfeTsdai1syenyenkijyun04t;
    }

    @Column(order = 403, label = "dai1syenyenyasu04")
    private String ifeTsdai1syenyenyasu04;

    public String getIfeTsdai1syenyenyasu04() {
        return ifeTsdai1syenyenyasu04;
    }

    public void setIfeTsdai1syenyenyasu04(String pIfeTsdai1syenyenyasu04) {
        ifeTsdai1syenyenyasu04 = pIfeTsdai1syenyenyasu04;
    }

    @Column(order = 404, label = "dai1syenyenyasu04$")
    private String ifeTsdai1syenyenyasu04t;

    public String getIfeTsdai1syenyenyasu04t() {
        return ifeTsdai1syenyenyasu04t;
    }

    public void setIfeTsdai1syenyenyasu04t(String pIfeTsdai1syenyenyasu04t) {
        ifeTsdai1syenyenyasu04t = pIfeTsdai1syenyenyasu04t;
    }

    @Column(order = 405, label = "dai1skeikanensuu05")
    private String ifeTsdai1skeikanensuu05;

    public String getIfeTsdai1skeikanensuu05() {
        return ifeTsdai1skeikanensuu05;
    }

    public void setIfeTsdai1skeikanensuu05(String pIfeTsdai1skeikanensuu05) {
        ifeTsdai1skeikanensuu05 = pIfeTsdai1skeikanensuu05;
    }

    @Column(order = 406, label = "dai1sibousnenoutouymd05")
    private String ifeTsd1sibousnenoutouymd05;

    public String getIfeTsd1sibousnenoutouymd05() {
        return ifeTsd1sibousnenoutouymd05;
    }

    public void setIfeTsd1sibousnenoutouymd05(String pIfeTsd1sibousnenoutouymd05) {
        ifeTsd1sibousnenoutouymd05 = pIfeTsd1sibousnenoutouymd05;
    }

    @Column(order = 407, label = "dai1stuuktype05")
    private String ifeTsdai1stuuktype05;

    public String getIfeTsdai1stuuktype05() {
        return ifeTsdai1stuuktype05;
    }

    public void setIfeTsdai1stuuktype05(String pIfeTsdai1stuuktype05) {
        ifeTsdai1stuuktype05 = pIfeTsdai1stuuktype05;
    }

    @Column(order = 408, label = "dai1s05")
    private String ifeTsdai1s05;

    public String getIfeTsdai1s05() {
        return ifeTsdai1s05;
    }

    public void setIfeTsdai1s05(String pIfeTsdai1s05) {
        ifeTsdai1s05 = pIfeTsdai1s05;
    }

    @Column(order = 409, label = "dai1s05$")
    private String ifeTsdai1s05t;

    public String getIfeTsdai1s05t() {
        return ifeTsdai1s05t;
    }

    public void setIfeTsdai1s05t(String pIfeTsdai1s05t) {
        ifeTsdai1s05t = pIfeTsdai1s05t;
    }

    @Column(order = 410, label = "dai1syenyendakaumu05")
    private String ifeTsdai1syenyendakaumu05;

    public String getIfeTsdai1syenyendakaumu05() {
        return ifeTsdai1syenyendakaumu05;
    }

    public void setIfeTsdai1syenyendakaumu05(String pIfeTsdai1syenyendakaumu05) {
        ifeTsdai1syenyendakaumu05 = pIfeTsdai1syenyendakaumu05;
    }

    @Column(order = 411, label = "dai1syenyenkijyunumu05")
    private String ifeTsdai1syenyenkijyunumu05;

    public String getIfeTsdai1syenyenkijyunumu05() {
        return ifeTsdai1syenyenkijyunumu05;
    }

    public void setIfeTsdai1syenyenkijyunumu05(String pIfeTsdai1syenyenkijyunumu05) {
        ifeTsdai1syenyenkijyunumu05 = pIfeTsdai1syenyenkijyunumu05;
    }

    @Column(order = 412, label = "dai1syenyenyasuumu05")
    private String ifeTsdai1syenyenyasuumu05;

    public String getIfeTsdai1syenyenyasuumu05() {
        return ifeTsdai1syenyenyasuumu05;
    }

    public void setIfeTsdai1syenyenyasuumu05(String pIfeTsdai1syenyenyasuumu05) {
        ifeTsdai1syenyenyasuumu05 = pIfeTsdai1syenyenyasuumu05;
    }

    @Column(order = 413, label = "dai1syentuuktype05")
    private String ifeTsdai1syentuuktype05;

    public String getIfeTsdai1syentuuktype05() {
        return ifeTsdai1syentuuktype05;
    }

    public void setIfeTsdai1syentuuktype05(String pIfeTsdai1syentuuktype05) {
        ifeTsdai1syentuuktype05 = pIfeTsdai1syentuuktype05;
    }

    @Column(order = 414, label = "dai1syenyendaka05")
    private String ifeTsdai1syenyendaka05;

    public String getIfeTsdai1syenyendaka05() {
        return ifeTsdai1syenyendaka05;
    }

    public void setIfeTsdai1syenyendaka05(String pIfeTsdai1syenyendaka05) {
        ifeTsdai1syenyendaka05 = pIfeTsdai1syenyendaka05;
    }

    @Column(order = 415, label = "dai1syenyendaka05$")
    private String ifeTsdai1syenyendaka05t;

    public String getIfeTsdai1syenyendaka05t() {
        return ifeTsdai1syenyendaka05t;
    }

    public void setIfeTsdai1syenyendaka05t(String pIfeTsdai1syenyendaka05t) {
        ifeTsdai1syenyendaka05t = pIfeTsdai1syenyendaka05t;
    }

    @Column(order = 416, label = "dai1syenyenkijyun05")
    private String ifeTsdai1syenyenkijyun05;

    public String getIfeTsdai1syenyenkijyun05() {
        return ifeTsdai1syenyenkijyun05;
    }

    public void setIfeTsdai1syenyenkijyun05(String pIfeTsdai1syenyenkijyun05) {
        ifeTsdai1syenyenkijyun05 = pIfeTsdai1syenyenkijyun05;
    }

    @Column(order = 417, label = "dai1syenyenkijyun05$")
    private String ifeTsdai1syenyenkijyun05t;

    public String getIfeTsdai1syenyenkijyun05t() {
        return ifeTsdai1syenyenkijyun05t;
    }

    public void setIfeTsdai1syenyenkijyun05t(String pIfeTsdai1syenyenkijyun05t) {
        ifeTsdai1syenyenkijyun05t = pIfeTsdai1syenyenkijyun05t;
    }

    @Column(order = 418, label = "dai1syenyenyasu05")
    private String ifeTsdai1syenyenyasu05;

    public String getIfeTsdai1syenyenyasu05() {
        return ifeTsdai1syenyenyasu05;
    }

    public void setIfeTsdai1syenyenyasu05(String pIfeTsdai1syenyenyasu05) {
        ifeTsdai1syenyenyasu05 = pIfeTsdai1syenyenyasu05;
    }

    @Column(order = 419, label = "dai1syenyenyasu05$")
    private String ifeTsdai1syenyenyasu05t;

    public String getIfeTsdai1syenyenyasu05t() {
        return ifeTsdai1syenyenyasu05t;
    }

    public void setIfeTsdai1syenyenyasu05t(String pIfeTsdai1syenyenyasu05t) {
        ifeTsdai1syenyenyasu05t = pIfeTsdai1syenyenyasu05t;
    }

    @Column(order = 420, label = "dai1skeikanensuu06")
    private String ifeTsdai1skeikanensuu06;

    public String getIfeTsdai1skeikanensuu06() {
        return ifeTsdai1skeikanensuu06;
    }

    public void setIfeTsdai1skeikanensuu06(String pIfeTsdai1skeikanensuu06) {
        ifeTsdai1skeikanensuu06 = pIfeTsdai1skeikanensuu06;
    }

    @Column(order = 421, label = "dai1sibousnenoutouymd06")
    private String ifeTsd1sibousnenoutouymd06;

    public String getIfeTsd1sibousnenoutouymd06() {
        return ifeTsd1sibousnenoutouymd06;
    }

    public void setIfeTsd1sibousnenoutouymd06(String pIfeTsd1sibousnenoutouymd06) {
        ifeTsd1sibousnenoutouymd06 = pIfeTsd1sibousnenoutouymd06;
    }

    @Column(order = 422, label = "dai1stuuktype06")
    private String ifeTsdai1stuuktype06;

    public String getIfeTsdai1stuuktype06() {
        return ifeTsdai1stuuktype06;
    }

    public void setIfeTsdai1stuuktype06(String pIfeTsdai1stuuktype06) {
        ifeTsdai1stuuktype06 = pIfeTsdai1stuuktype06;
    }

    @Column(order = 423, label = "dai1s06")
    private String ifeTsdai1s06;

    public String getIfeTsdai1s06() {
        return ifeTsdai1s06;
    }

    public void setIfeTsdai1s06(String pIfeTsdai1s06) {
        ifeTsdai1s06 = pIfeTsdai1s06;
    }

    @Column(order = 424, label = "dai1s06$")
    private String ifeTsdai1s06t;

    public String getIfeTsdai1s06t() {
        return ifeTsdai1s06t;
    }

    public void setIfeTsdai1s06t(String pIfeTsdai1s06t) {
        ifeTsdai1s06t = pIfeTsdai1s06t;
    }

    @Column(order = 425, label = "dai1syenyendakaumu06")
    private String ifeTsdai1syenyendakaumu06;

    public String getIfeTsdai1syenyendakaumu06() {
        return ifeTsdai1syenyendakaumu06;
    }

    public void setIfeTsdai1syenyendakaumu06(String pIfeTsdai1syenyendakaumu06) {
        ifeTsdai1syenyendakaumu06 = pIfeTsdai1syenyendakaumu06;
    }

    @Column(order = 426, label = "dai1syenyenkijyunumu06")
    private String ifeTsdai1syenyenkijyunumu06;

    public String getIfeTsdai1syenyenkijyunumu06() {
        return ifeTsdai1syenyenkijyunumu06;
    }

    public void setIfeTsdai1syenyenkijyunumu06(String pIfeTsdai1syenyenkijyunumu06) {
        ifeTsdai1syenyenkijyunumu06 = pIfeTsdai1syenyenkijyunumu06;
    }

    @Column(order = 427, label = "dai1syenyenyasuumu06")
    private String ifeTsdai1syenyenyasuumu06;

    public String getIfeTsdai1syenyenyasuumu06() {
        return ifeTsdai1syenyenyasuumu06;
    }

    public void setIfeTsdai1syenyenyasuumu06(String pIfeTsdai1syenyenyasuumu06) {
        ifeTsdai1syenyenyasuumu06 = pIfeTsdai1syenyenyasuumu06;
    }

    @Column(order = 428, label = "dai1syentuuktype06")
    private String ifeTsdai1syentuuktype06;

    public String getIfeTsdai1syentuuktype06() {
        return ifeTsdai1syentuuktype06;
    }

    public void setIfeTsdai1syentuuktype06(String pIfeTsdai1syentuuktype06) {
        ifeTsdai1syentuuktype06 = pIfeTsdai1syentuuktype06;
    }

    @Column(order = 429, label = "dai1syenyendaka06")
    private String ifeTsdai1syenyendaka06;

    public String getIfeTsdai1syenyendaka06() {
        return ifeTsdai1syenyendaka06;
    }

    public void setIfeTsdai1syenyendaka06(String pIfeTsdai1syenyendaka06) {
        ifeTsdai1syenyendaka06 = pIfeTsdai1syenyendaka06;
    }

    @Column(order = 430, label = "dai1syenyendaka06$")
    private String ifeTsdai1syenyendaka06t;

    public String getIfeTsdai1syenyendaka06t() {
        return ifeTsdai1syenyendaka06t;
    }

    public void setIfeTsdai1syenyendaka06t(String pIfeTsdai1syenyendaka06t) {
        ifeTsdai1syenyendaka06t = pIfeTsdai1syenyendaka06t;
    }

    @Column(order = 431, label = "dai1syenyenkijyun06")
    private String ifeTsdai1syenyenkijyun06;

    public String getIfeTsdai1syenyenkijyun06() {
        return ifeTsdai1syenyenkijyun06;
    }

    public void setIfeTsdai1syenyenkijyun06(String pIfeTsdai1syenyenkijyun06) {
        ifeTsdai1syenyenkijyun06 = pIfeTsdai1syenyenkijyun06;
    }

    @Column(order = 432, label = "dai1syenyenkijyun06$")
    private String ifeTsdai1syenyenkijyun06t;

    public String getIfeTsdai1syenyenkijyun06t() {
        return ifeTsdai1syenyenkijyun06t;
    }

    public void setIfeTsdai1syenyenkijyun06t(String pIfeTsdai1syenyenkijyun06t) {
        ifeTsdai1syenyenkijyun06t = pIfeTsdai1syenyenkijyun06t;
    }

    @Column(order = 433, label = "dai1syenyenyasu06")
    private String ifeTsdai1syenyenyasu06;

    public String getIfeTsdai1syenyenyasu06() {
        return ifeTsdai1syenyenyasu06;
    }

    public void setIfeTsdai1syenyenyasu06(String pIfeTsdai1syenyenyasu06) {
        ifeTsdai1syenyenyasu06 = pIfeTsdai1syenyenyasu06;
    }

    @Column(order = 434, label = "dai1syenyenyasu06$")
    private String ifeTsdai1syenyenyasu06t;

    public String getIfeTsdai1syenyenyasu06t() {
        return ifeTsdai1syenyenyasu06t;
    }

    public void setIfeTsdai1syenyenyasu06t(String pIfeTsdai1syenyenyasu06t) {
        ifeTsdai1syenyenyasu06t = pIfeTsdai1syenyenyasu06t;
    }

    @Column(order = 435, label = "dai1skeikanensuu07")
    private String ifeTsdai1skeikanensuu07;

    public String getIfeTsdai1skeikanensuu07() {
        return ifeTsdai1skeikanensuu07;
    }

    public void setIfeTsdai1skeikanensuu07(String pIfeTsdai1skeikanensuu07) {
        ifeTsdai1skeikanensuu07 = pIfeTsdai1skeikanensuu07;
    }

    @Column(order = 436, label = "dai1sibousnenoutouymd07")
    private String ifeTsd1sibousnenoutouymd07;

    public String getIfeTsd1sibousnenoutouymd07() {
        return ifeTsd1sibousnenoutouymd07;
    }

    public void setIfeTsd1sibousnenoutouymd07(String pIfeTsd1sibousnenoutouymd07) {
        ifeTsd1sibousnenoutouymd07 = pIfeTsd1sibousnenoutouymd07;
    }

    @Column(order = 437, label = "dai1stuuktype07")
    private String ifeTsdai1stuuktype07;

    public String getIfeTsdai1stuuktype07() {
        return ifeTsdai1stuuktype07;
    }

    public void setIfeTsdai1stuuktype07(String pIfeTsdai1stuuktype07) {
        ifeTsdai1stuuktype07 = pIfeTsdai1stuuktype07;
    }

    @Column(order = 438, label = "dai1s07")
    private String ifeTsdai1s07;

    public String getIfeTsdai1s07() {
        return ifeTsdai1s07;
    }

    public void setIfeTsdai1s07(String pIfeTsdai1s07) {
        ifeTsdai1s07 = pIfeTsdai1s07;
    }

    @Column(order = 439, label = "dai1s07$")
    private String ifeTsdai1s07t;

    public String getIfeTsdai1s07t() {
        return ifeTsdai1s07t;
    }

    public void setIfeTsdai1s07t(String pIfeTsdai1s07t) {
        ifeTsdai1s07t = pIfeTsdai1s07t;
    }

    @Column(order = 440, label = "dai1syenyendakaumu07")
    private String ifeTsdai1syenyendakaumu07;

    public String getIfeTsdai1syenyendakaumu07() {
        return ifeTsdai1syenyendakaumu07;
    }

    public void setIfeTsdai1syenyendakaumu07(String pIfeTsdai1syenyendakaumu07) {
        ifeTsdai1syenyendakaumu07 = pIfeTsdai1syenyendakaumu07;
    }

    @Column(order = 441, label = "dai1syenyenkijyunumu07")
    private String ifeTsdai1syenyenkijyunumu07;

    public String getIfeTsdai1syenyenkijyunumu07() {
        return ifeTsdai1syenyenkijyunumu07;
    }

    public void setIfeTsdai1syenyenkijyunumu07(String pIfeTsdai1syenyenkijyunumu07) {
        ifeTsdai1syenyenkijyunumu07 = pIfeTsdai1syenyenkijyunumu07;
    }

    @Column(order = 442, label = "dai1syenyenyasuumu07")
    private String ifeTsdai1syenyenyasuumu07;

    public String getIfeTsdai1syenyenyasuumu07() {
        return ifeTsdai1syenyenyasuumu07;
    }

    public void setIfeTsdai1syenyenyasuumu07(String pIfeTsdai1syenyenyasuumu07) {
        ifeTsdai1syenyenyasuumu07 = pIfeTsdai1syenyenyasuumu07;
    }

    @Column(order = 443, label = "dai1syentuuktype07")
    private String ifeTsdai1syentuuktype07;

    public String getIfeTsdai1syentuuktype07() {
        return ifeTsdai1syentuuktype07;
    }

    public void setIfeTsdai1syentuuktype07(String pIfeTsdai1syentuuktype07) {
        ifeTsdai1syentuuktype07 = pIfeTsdai1syentuuktype07;
    }

    @Column(order = 444, label = "dai1syenyendaka07")
    private String ifeTsdai1syenyendaka07;

    public String getIfeTsdai1syenyendaka07() {
        return ifeTsdai1syenyendaka07;
    }

    public void setIfeTsdai1syenyendaka07(String pIfeTsdai1syenyendaka07) {
        ifeTsdai1syenyendaka07 = pIfeTsdai1syenyendaka07;
    }

    @Column(order = 445, label = "dai1syenyendaka07$")
    private String ifeTsdai1syenyendaka07t;

    public String getIfeTsdai1syenyendaka07t() {
        return ifeTsdai1syenyendaka07t;
    }

    public void setIfeTsdai1syenyendaka07t(String pIfeTsdai1syenyendaka07t) {
        ifeTsdai1syenyendaka07t = pIfeTsdai1syenyendaka07t;
    }

    @Column(order = 446, label = "dai1syenyenkijyun07")
    private String ifeTsdai1syenyenkijyun07;

    public String getIfeTsdai1syenyenkijyun07() {
        return ifeTsdai1syenyenkijyun07;
    }

    public void setIfeTsdai1syenyenkijyun07(String pIfeTsdai1syenyenkijyun07) {
        ifeTsdai1syenyenkijyun07 = pIfeTsdai1syenyenkijyun07;
    }

    @Column(order = 447, label = "dai1syenyenkijyun07$")
    private String ifeTsdai1syenyenkijyun07t;

    public String getIfeTsdai1syenyenkijyun07t() {
        return ifeTsdai1syenyenkijyun07t;
    }

    public void setIfeTsdai1syenyenkijyun07t(String pIfeTsdai1syenyenkijyun07t) {
        ifeTsdai1syenyenkijyun07t = pIfeTsdai1syenyenkijyun07t;
    }

    @Column(order = 448, label = "dai1syenyenyasu07")
    private String ifeTsdai1syenyenyasu07;

    public String getIfeTsdai1syenyenyasu07() {
        return ifeTsdai1syenyenyasu07;
    }

    public void setIfeTsdai1syenyenyasu07(String pIfeTsdai1syenyenyasu07) {
        ifeTsdai1syenyenyasu07 = pIfeTsdai1syenyenyasu07;
    }

    @Column(order = 449, label = "dai1syenyenyasu07$")
    private String ifeTsdai1syenyenyasu07t;

    public String getIfeTsdai1syenyenyasu07t() {
        return ifeTsdai1syenyenyasu07t;
    }

    public void setIfeTsdai1syenyenyasu07t(String pIfeTsdai1syenyenyasu07t) {
        ifeTsdai1syenyenyasu07t = pIfeTsdai1syenyenyasu07t;
    }

    @Column(order = 450, label = "dai1skeikanensuu08")
    private String ifeTsdai1skeikanensuu08;

    public String getIfeTsdai1skeikanensuu08() {
        return ifeTsdai1skeikanensuu08;
    }

    public void setIfeTsdai1skeikanensuu08(String pIfeTsdai1skeikanensuu08) {
        ifeTsdai1skeikanensuu08 = pIfeTsdai1skeikanensuu08;
    }

    @Column(order = 451, label = "dai1sibousnenoutouymd08")
    private String ifeTsd1sibousnenoutouymd08;

    public String getIfeTsd1sibousnenoutouymd08() {
        return ifeTsd1sibousnenoutouymd08;
    }

    public void setIfeTsd1sibousnenoutouymd08(String pIfeTsd1sibousnenoutouymd08) {
        ifeTsd1sibousnenoutouymd08 = pIfeTsd1sibousnenoutouymd08;
    }

    @Column(order = 452, label = "dai1stuuktype08")
    private String ifeTsdai1stuuktype08;

    public String getIfeTsdai1stuuktype08() {
        return ifeTsdai1stuuktype08;
    }

    public void setIfeTsdai1stuuktype08(String pIfeTsdai1stuuktype08) {
        ifeTsdai1stuuktype08 = pIfeTsdai1stuuktype08;
    }

    @Column(order = 453, label = "dai1s08")
    private String ifeTsdai1s08;

    public String getIfeTsdai1s08() {
        return ifeTsdai1s08;
    }

    public void setIfeTsdai1s08(String pIfeTsdai1s08) {
        ifeTsdai1s08 = pIfeTsdai1s08;
    }

    @Column(order = 454, label = "dai1s08$")
    private String ifeTsdai1s08t;

    public String getIfeTsdai1s08t() {
        return ifeTsdai1s08t;
    }

    public void setIfeTsdai1s08t(String pIfeTsdai1s08t) {
        ifeTsdai1s08t = pIfeTsdai1s08t;
    }

    @Column(order = 455, label = "dai1syenyendakaumu08")
    private String ifeTsdai1syenyendakaumu08;

    public String getIfeTsdai1syenyendakaumu08() {
        return ifeTsdai1syenyendakaumu08;
    }

    public void setIfeTsdai1syenyendakaumu08(String pIfeTsdai1syenyendakaumu08) {
        ifeTsdai1syenyendakaumu08 = pIfeTsdai1syenyendakaumu08;
    }

    @Column(order = 456, label = "dai1syenyenkijyunumu08")
    private String ifeTsdai1syenyenkijyunumu08;

    public String getIfeTsdai1syenyenkijyunumu08() {
        return ifeTsdai1syenyenkijyunumu08;
    }

    public void setIfeTsdai1syenyenkijyunumu08(String pIfeTsdai1syenyenkijyunumu08) {
        ifeTsdai1syenyenkijyunumu08 = pIfeTsdai1syenyenkijyunumu08;
    }

    @Column(order = 457, label = "dai1syenyenyasuumu08")
    private String ifeTsdai1syenyenyasuumu08;

    public String getIfeTsdai1syenyenyasuumu08() {
        return ifeTsdai1syenyenyasuumu08;
    }

    public void setIfeTsdai1syenyenyasuumu08(String pIfeTsdai1syenyenyasuumu08) {
        ifeTsdai1syenyenyasuumu08 = pIfeTsdai1syenyenyasuumu08;
    }

    @Column(order = 458, label = "dai1syentuuktype08")
    private String ifeTsdai1syentuuktype08;

    public String getIfeTsdai1syentuuktype08() {
        return ifeTsdai1syentuuktype08;
    }

    public void setIfeTsdai1syentuuktype08(String pIfeTsdai1syentuuktype08) {
        ifeTsdai1syentuuktype08 = pIfeTsdai1syentuuktype08;
    }

    @Column(order = 459, label = "dai1syenyendaka08")
    private String ifeTsdai1syenyendaka08;

    public String getIfeTsdai1syenyendaka08() {
        return ifeTsdai1syenyendaka08;
    }

    public void setIfeTsdai1syenyendaka08(String pIfeTsdai1syenyendaka08) {
        ifeTsdai1syenyendaka08 = pIfeTsdai1syenyendaka08;
    }

    @Column(order = 460, label = "dai1syenyendaka08$")
    private String ifeTsdai1syenyendaka08t;

    public String getIfeTsdai1syenyendaka08t() {
        return ifeTsdai1syenyendaka08t;
    }

    public void setIfeTsdai1syenyendaka08t(String pIfeTsdai1syenyendaka08t) {
        ifeTsdai1syenyendaka08t = pIfeTsdai1syenyendaka08t;
    }

    @Column(order = 461, label = "dai1syenyenkijyun08")
    private String ifeTsdai1syenyenkijyun08;

    public String getIfeTsdai1syenyenkijyun08() {
        return ifeTsdai1syenyenkijyun08;
    }

    public void setIfeTsdai1syenyenkijyun08(String pIfeTsdai1syenyenkijyun08) {
        ifeTsdai1syenyenkijyun08 = pIfeTsdai1syenyenkijyun08;
    }

    @Column(order = 462, label = "dai1syenyenkijyun08$")
    private String ifeTsdai1syenyenkijyun08t;

    public String getIfeTsdai1syenyenkijyun08t() {
        return ifeTsdai1syenyenkijyun08t;
    }

    public void setIfeTsdai1syenyenkijyun08t(String pIfeTsdai1syenyenkijyun08t) {
        ifeTsdai1syenyenkijyun08t = pIfeTsdai1syenyenkijyun08t;
    }

    @Column(order = 463, label = "dai1syenyenyasu08")
    private String ifeTsdai1syenyenyasu08;

    public String getIfeTsdai1syenyenyasu08() {
        return ifeTsdai1syenyenyasu08;
    }

    public void setIfeTsdai1syenyenyasu08(String pIfeTsdai1syenyenyasu08) {
        ifeTsdai1syenyenyasu08 = pIfeTsdai1syenyenyasu08;
    }

    @Column(order = 464, label = "dai1syenyenyasu08$")
    private String ifeTsdai1syenyenyasu08t;

    public String getIfeTsdai1syenyenyasu08t() {
        return ifeTsdai1syenyenyasu08t;
    }

    public void setIfeTsdai1syenyenyasu08t(String pIfeTsdai1syenyenyasu08t) {
        ifeTsdai1syenyenyasu08t = pIfeTsdai1syenyenyasu08t;
    }

    @Column(order = 465, label = "dai1skeikanensuu09")
    private String ifeTsdai1skeikanensuu09;

    public String getIfeTsdai1skeikanensuu09() {
        return ifeTsdai1skeikanensuu09;
    }

    public void setIfeTsdai1skeikanensuu09(String pIfeTsdai1skeikanensuu09) {
        ifeTsdai1skeikanensuu09 = pIfeTsdai1skeikanensuu09;
    }

    @Column(order = 466, label = "dai1sibousnenoutouymd09")
    private String ifeTsd1sibousnenoutouymd09;

    public String getIfeTsd1sibousnenoutouymd09() {
        return ifeTsd1sibousnenoutouymd09;
    }

    public void setIfeTsd1sibousnenoutouymd09(String pIfeTsd1sibousnenoutouymd09) {
        ifeTsd1sibousnenoutouymd09 = pIfeTsd1sibousnenoutouymd09;
    }

    @Column(order = 467, label = "dai1stuuktype09")
    private String ifeTsdai1stuuktype09;

    public String getIfeTsdai1stuuktype09() {
        return ifeTsdai1stuuktype09;
    }

    public void setIfeTsdai1stuuktype09(String pIfeTsdai1stuuktype09) {
        ifeTsdai1stuuktype09 = pIfeTsdai1stuuktype09;
    }

    @Column(order = 468, label = "dai1s09")
    private String ifeTsdai1s09;

    public String getIfeTsdai1s09() {
        return ifeTsdai1s09;
    }

    public void setIfeTsdai1s09(String pIfeTsdai1s09) {
        ifeTsdai1s09 = pIfeTsdai1s09;
    }

    @Column(order = 469, label = "dai1s09$")
    private String ifeTsdai1s09t;

    public String getIfeTsdai1s09t() {
        return ifeTsdai1s09t;
    }

    public void setIfeTsdai1s09t(String pIfeTsdai1s09t) {
        ifeTsdai1s09t = pIfeTsdai1s09t;
    }

    @Column(order = 470, label = "dai1syenyendakaumu09")
    private String ifeTsdai1syenyendakaumu09;

    public String getIfeTsdai1syenyendakaumu09() {
        return ifeTsdai1syenyendakaumu09;
    }

    public void setIfeTsdai1syenyendakaumu09(String pIfeTsdai1syenyendakaumu09) {
        ifeTsdai1syenyendakaumu09 = pIfeTsdai1syenyendakaumu09;
    }

    @Column(order = 471, label = "dai1syenyenkijyunumu09")
    private String ifeTsdai1syenyenkijyunumu09;

    public String getIfeTsdai1syenyenkijyunumu09() {
        return ifeTsdai1syenyenkijyunumu09;
    }

    public void setIfeTsdai1syenyenkijyunumu09(String pIfeTsdai1syenyenkijyunumu09) {
        ifeTsdai1syenyenkijyunumu09 = pIfeTsdai1syenyenkijyunumu09;
    }

    @Column(order = 472, label = "dai1syenyenyasuumu09")
    private String ifeTsdai1syenyenyasuumu09;

    public String getIfeTsdai1syenyenyasuumu09() {
        return ifeTsdai1syenyenyasuumu09;
    }

    public void setIfeTsdai1syenyenyasuumu09(String pIfeTsdai1syenyenyasuumu09) {
        ifeTsdai1syenyenyasuumu09 = pIfeTsdai1syenyenyasuumu09;
    }

    @Column(order = 473, label = "dai1syentuuktype09")
    private String ifeTsdai1syentuuktype09;

    public String getIfeTsdai1syentuuktype09() {
        return ifeTsdai1syentuuktype09;
    }

    public void setIfeTsdai1syentuuktype09(String pIfeTsdai1syentuuktype09) {
        ifeTsdai1syentuuktype09 = pIfeTsdai1syentuuktype09;
    }

    @Column(order = 474, label = "dai1syenyendaka09")
    private String ifeTsdai1syenyendaka09;

    public String getIfeTsdai1syenyendaka09() {
        return ifeTsdai1syenyendaka09;
    }

    public void setIfeTsdai1syenyendaka09(String pIfeTsdai1syenyendaka09) {
        ifeTsdai1syenyendaka09 = pIfeTsdai1syenyendaka09;
    }

    @Column(order = 475, label = "dai1syenyendaka09$")
    private String ifeTsdai1syenyendaka09t;

    public String getIfeTsdai1syenyendaka09t() {
        return ifeTsdai1syenyendaka09t;
    }

    public void setIfeTsdai1syenyendaka09t(String pIfeTsdai1syenyendaka09t) {
        ifeTsdai1syenyendaka09t = pIfeTsdai1syenyendaka09t;
    }

    @Column(order = 476, label = "dai1syenyenkijyun09")
    private String ifeTsdai1syenyenkijyun09;

    public String getIfeTsdai1syenyenkijyun09() {
        return ifeTsdai1syenyenkijyun09;
    }

    public void setIfeTsdai1syenyenkijyun09(String pIfeTsdai1syenyenkijyun09) {
        ifeTsdai1syenyenkijyun09 = pIfeTsdai1syenyenkijyun09;
    }

    @Column(order = 477, label = "dai1syenyenkijyun09$")
    private String ifeTsdai1syenyenkijyun09t;

    public String getIfeTsdai1syenyenkijyun09t() {
        return ifeTsdai1syenyenkijyun09t;
    }

    public void setIfeTsdai1syenyenkijyun09t(String pIfeTsdai1syenyenkijyun09t) {
        ifeTsdai1syenyenkijyun09t = pIfeTsdai1syenyenkijyun09t;
    }

    @Column(order = 478, label = "dai1syenyenyasu09")
    private String ifeTsdai1syenyenyasu09;

    public String getIfeTsdai1syenyenyasu09() {
        return ifeTsdai1syenyenyasu09;
    }

    public void setIfeTsdai1syenyenyasu09(String pIfeTsdai1syenyenyasu09) {
        ifeTsdai1syenyenyasu09 = pIfeTsdai1syenyenyasu09;
    }

    @Column(order = 479, label = "dai1syenyenyasu09$")
    private String ifeTsdai1syenyenyasu09t;

    public String getIfeTsdai1syenyenyasu09t() {
        return ifeTsdai1syenyenyasu09t;
    }

    public void setIfeTsdai1syenyenyasu09t(String pIfeTsdai1syenyenyasu09t) {
        ifeTsdai1syenyenyasu09t = pIfeTsdai1syenyenyasu09t;
    }

    @Column(order = 480, label = "dai1skeikanensuu10")
    private String ifeTsdai1skeikanensuu10;

    public String getIfeTsdai1skeikanensuu10() {
        return ifeTsdai1skeikanensuu10;
    }

    public void setIfeTsdai1skeikanensuu10(String pIfeTsdai1skeikanensuu10) {
        ifeTsdai1skeikanensuu10 = pIfeTsdai1skeikanensuu10;
    }

    @Column(order = 481, label = "dai1sibousnenoutouymd10")
    private String ifeTsd1sibousnenoutouymd10;

    public String getIfeTsd1sibousnenoutouymd10() {
        return ifeTsd1sibousnenoutouymd10;
    }

    public void setIfeTsd1sibousnenoutouymd10(String pIfeTsd1sibousnenoutouymd10) {
        ifeTsd1sibousnenoutouymd10 = pIfeTsd1sibousnenoutouymd10;
    }

    @Column(order = 482, label = "dai1stuuktype10")
    private String ifeTsdai1stuuktype10;

    public String getIfeTsdai1stuuktype10() {
        return ifeTsdai1stuuktype10;
    }

    public void setIfeTsdai1stuuktype10(String pIfeTsdai1stuuktype10) {
        ifeTsdai1stuuktype10 = pIfeTsdai1stuuktype10;
    }

    @Column(order = 483, label = "dai1s10")
    private String ifeTsdai1s10;

    public String getIfeTsdai1s10() {
        return ifeTsdai1s10;
    }

    public void setIfeTsdai1s10(String pIfeTsdai1s10) {
        ifeTsdai1s10 = pIfeTsdai1s10;
    }

    @Column(order = 484, label = "dai1s10$")
    private String ifeTsdai1s10t;

    public String getIfeTsdai1s10t() {
        return ifeTsdai1s10t;
    }

    public void setIfeTsdai1s10t(String pIfeTsdai1s10t) {
        ifeTsdai1s10t = pIfeTsdai1s10t;
    }

    @Column(order = 485, label = "dai1syenyendakaumu10")
    private String ifeTsdai1syenyendakaumu10;

    public String getIfeTsdai1syenyendakaumu10() {
        return ifeTsdai1syenyendakaumu10;
    }

    public void setIfeTsdai1syenyendakaumu10(String pIfeTsdai1syenyendakaumu10) {
        ifeTsdai1syenyendakaumu10 = pIfeTsdai1syenyendakaumu10;
    }

    @Column(order = 486, label = "dai1syenyenkijyunumu10")
    private String ifeTsdai1syenyenkijyunumu10;

    public String getIfeTsdai1syenyenkijyunumu10() {
        return ifeTsdai1syenyenkijyunumu10;
    }

    public void setIfeTsdai1syenyenkijyunumu10(String pIfeTsdai1syenyenkijyunumu10) {
        ifeTsdai1syenyenkijyunumu10 = pIfeTsdai1syenyenkijyunumu10;
    }

    @Column(order = 487, label = "dai1syenyenyasuumu10")
    private String ifeTsdai1syenyenyasuumu10;

    public String getIfeTsdai1syenyenyasuumu10() {
        return ifeTsdai1syenyenyasuumu10;
    }

    public void setIfeTsdai1syenyenyasuumu10(String pIfeTsdai1syenyenyasuumu10) {
        ifeTsdai1syenyenyasuumu10 = pIfeTsdai1syenyenyasuumu10;
    }

    @Column(order = 488, label = "dai1syentuuktype10")
    private String ifeTsdai1syentuuktype10;

    public String getIfeTsdai1syentuuktype10() {
        return ifeTsdai1syentuuktype10;
    }

    public void setIfeTsdai1syentuuktype10(String pIfeTsdai1syentuuktype10) {
        ifeTsdai1syentuuktype10 = pIfeTsdai1syentuuktype10;
    }

    @Column(order = 489, label = "dai1syenyendaka10")
    private String ifeTsdai1syenyendaka10;

    public String getIfeTsdai1syenyendaka10() {
        return ifeTsdai1syenyendaka10;
    }

    public void setIfeTsdai1syenyendaka10(String pIfeTsdai1syenyendaka10) {
        ifeTsdai1syenyendaka10 = pIfeTsdai1syenyendaka10;
    }

    @Column(order = 490, label = "dai1syenyendaka10$")
    private String ifeTsdai1syenyendaka10t;

    public String getIfeTsdai1syenyendaka10t() {
        return ifeTsdai1syenyendaka10t;
    }

    public void setIfeTsdai1syenyendaka10t(String pIfeTsdai1syenyendaka10t) {
        ifeTsdai1syenyendaka10t = pIfeTsdai1syenyendaka10t;
    }

    @Column(order = 491, label = "dai1syenyenkijyun10")
    private String ifeTsdai1syenyenkijyun10;

    public String getIfeTsdai1syenyenkijyun10() {
        return ifeTsdai1syenyenkijyun10;
    }

    public void setIfeTsdai1syenyenkijyun10(String pIfeTsdai1syenyenkijyun10) {
        ifeTsdai1syenyenkijyun10 = pIfeTsdai1syenyenkijyun10;
    }

    @Column(order = 492, label = "dai1syenyenkijyun10$")
    private String ifeTsdai1syenyenkijyun10t;

    public String getIfeTsdai1syenyenkijyun10t() {
        return ifeTsdai1syenyenkijyun10t;
    }

    public void setIfeTsdai1syenyenkijyun10t(String pIfeTsdai1syenyenkijyun10t) {
        ifeTsdai1syenyenkijyun10t = pIfeTsdai1syenyenkijyun10t;
    }

    @Column(order = 493, label = "dai1syenyenyasu10")
    private String ifeTsdai1syenyenyasu10;

    public String getIfeTsdai1syenyenyasu10() {
        return ifeTsdai1syenyenyasu10;
    }

    public void setIfeTsdai1syenyenyasu10(String pIfeTsdai1syenyenyasu10) {
        ifeTsdai1syenyenyasu10 = pIfeTsdai1syenyenyasu10;
    }

    @Column(order = 494, label = "dai1syenyenyasu10$")
    private String ifeTsdai1syenyenyasu10t;

    public String getIfeTsdai1syenyenyasu10t() {
        return ifeTsdai1syenyenyasu10t;
    }

    public void setIfeTsdai1syenyenyasu10t(String pIfeTsdai1syenyenyasu10t) {
        ifeTsdai1syenyenyasu10t = pIfeTsdai1syenyenyasu10t;
    }

    @Column(order = 495, label = "dai1stuuktypehuryo")
    private String ifeTsdai1stuuktypehuryo;

    public String getIfeTsdai1stuuktypehuryo() {
        return ifeTsdai1stuuktypehuryo;
    }

    public void setIfeTsdai1stuuktypehuryo(String pIfeTsdai1stuuktypehuryo) {
        ifeTsdai1stuuktypehuryo = pIfeTsdai1stuuktypehuryo;
    }

    @Column(order = 496, label = "dai1shuryo")
    private String ifeTsdai1shuryo;

    public String getIfeTsdai1shuryo() {
        return ifeTsdai1shuryo;
    }

    public void setIfeTsdai1shuryo(String pIfeTsdai1shuryo) {
        ifeTsdai1shuryo = pIfeTsdai1shuryo;
    }

    @Column(order = 497, label = "dai1shuryo$")
    private String ifeTsdai1shuryot;

    public String getIfeTsdai1shuryot() {
        return ifeTsdai1shuryot;
    }

    public void setIfeTsdai1shuryot(String pIfeTsdai1shuryot) {
        ifeTsdai1shuryot = pIfeTsdai1shuryot;
    }

    @Column(order = 498, label = "dai1syenyendakaumuhuryo")
    private String ifeTsd1syenyendakaumuhuryo;

    public String getIfeTsd1syenyendakaumuhuryo() {
        return ifeTsd1syenyendakaumuhuryo;
    }

    public void setIfeTsd1syenyendakaumuhuryo(String pIfeTsd1syenyendakaumuhuryo) {
        ifeTsd1syenyendakaumuhuryo = pIfeTsd1syenyendakaumuhuryo;
    }

    @Column(order = 499, label = "dai1syenyenkjnumuhuryo")
    private String ifeTsdai1syenyenkjnumuhuryo;

    public String getIfeTsdai1syenyenkjnumuhuryo() {
        return ifeTsdai1syenyenkjnumuhuryo;
    }

    public void setIfeTsdai1syenyenkjnumuhuryo(String pIfeTsdai1syenyenkjnumuhuryo) {
        ifeTsdai1syenyenkjnumuhuryo = pIfeTsdai1syenyenkjnumuhuryo;
    }

    @Column(order = 500, label = "dai1syenyenyasuumuhuryo")
    private String ifeTsd1syenyenyasuumuhuryo;

    public String getIfeTsd1syenyenyasuumuhuryo() {
        return ifeTsd1syenyenyasuumuhuryo;
    }

    public void setIfeTsd1syenyenyasuumuhuryo(String pIfeTsd1syenyenyasuumuhuryo) {
        ifeTsd1syenyenyasuumuhuryo = pIfeTsd1syenyenyasuumuhuryo;
    }

    @Column(order = 501, label = "dai1syentuuktypehuryo")
    private String ifeTsdai1syentuuktypehuryo;

    public String getIfeTsdai1syentuuktypehuryo() {
        return ifeTsdai1syentuuktypehuryo;
    }

    public void setIfeTsdai1syentuuktypehuryo(String pIfeTsdai1syentuuktypehuryo) {
        ifeTsdai1syentuuktypehuryo = pIfeTsdai1syentuuktypehuryo;
    }

    @Column(order = 502, label = "dai1syenyendakahuryo")
    private String ifeTsdai1syenyendakahuryo;

    public String getIfeTsdai1syenyendakahuryo() {
        return ifeTsdai1syenyendakahuryo;
    }

    public void setIfeTsdai1syenyendakahuryo(String pIfeTsdai1syenyendakahuryo) {
        ifeTsdai1syenyendakahuryo = pIfeTsdai1syenyendakahuryo;
    }

    @Column(order = 503, label = "dai1syenyendakahuryo$")
    private String ifeTsdai1syenyendakahuryot;

    public String getIfeTsdai1syenyendakahuryot() {
        return ifeTsdai1syenyendakahuryot;
    }

    public void setIfeTsdai1syenyendakahuryot(String pIfeTsdai1syenyendakahuryot) {
        ifeTsdai1syenyendakahuryot = pIfeTsdai1syenyendakahuryot;
    }

    @Column(order = 504, label = "dai1syenyenkijyunhuryo")
    private String ifeTsdai1syenyenkijyunhuryo;

    public String getIfeTsdai1syenyenkijyunhuryo() {
        return ifeTsdai1syenyenkijyunhuryo;
    }

    public void setIfeTsdai1syenyenkijyunhuryo(String pIfeTsdai1syenyenkijyunhuryo) {
        ifeTsdai1syenyenkijyunhuryo = pIfeTsdai1syenyenkijyunhuryo;
    }

    @Column(order = 505, label = "dai1syenyenkijyunhuryo$")
    private String ifeTsd1syenyenkijyunhuryot;

    public String getIfeTsd1syenyenkijyunhuryot() {
        return ifeTsd1syenyenkijyunhuryot;
    }

    public void setIfeTsd1syenyenkijyunhuryot(String pIfeTsd1syenyenkijyunhuryot) {
        ifeTsd1syenyenkijyunhuryot = pIfeTsd1syenyenkijyunhuryot;
    }

    @Column(order = 506, label = "dai1syenyenyasuhuryo")
    private String ifeTsdai1syenyenyasuhuryo;

    public String getIfeTsdai1syenyenyasuhuryo() {
        return ifeTsdai1syenyenyasuhuryo;
    }

    public void setIfeTsdai1syenyenyasuhuryo(String pIfeTsdai1syenyenyasuhuryo) {
        ifeTsdai1syenyenyasuhuryo = pIfeTsdai1syenyenyasuhuryo;
    }

    @Column(order = 507, label = "dai1syenyenyasuhuryo$")
    private String ifeTsdai1syenyenyasuhuryot;

    public String getIfeTsdai1syenyenyasuhuryot() {
        return ifeTsdai1syenyenyasuhuryot;
    }

    public void setIfeTsdai1syenyenyasuhuryot(String pIfeTsdai1syenyenyasuhuryot) {
        ifeTsdai1syenyenyasuhuryot = pIfeTsdai1syenyenyasuhuryot;
    }

    @Column(order = 508, label = "initsbjiyenkasaiteihsygk")
    private String ifeTsinitsbjiyenkasthsygk;

    public String getIfeTsinitsbjiyenkasthsygk() {
        return ifeTsinitsbjiyenkasthsygk;
    }

    public void setIfeTsinitsbjiyenkasthsygk(String pIfeTsinitsbjiyenkasthsygk) {
        ifeTsinitsbjiyenkasthsygk = pIfeTsinitsbjiyenkasthsygk;
    }

    @Column(order = 509, label = "initsbjiyenkasaiteihsygk$")
    private String ifeTsinitsbjiyenkasthsygkt;

    public String getIfeTsinitsbjiyenkasthsygkt() {
        return ifeTsinitsbjiyenkasthsygkt;
    }

    public void setIfeTsinitsbjiyenkasthsygkt(String pIfeTsinitsbjiyenkasthsygkt) {
        ifeTsinitsbjiyenkasthsygkt = pIfeTsinitsbjiyenkasthsygkt;
    }

    @Column(order = 510, label = "dai2stuuktype")
    private String ifeTsdai2stuuktype;

    public String getIfeTsdai2stuuktype() {
        return ifeTsdai2stuuktype;
    }

    public void setIfeTsdai2stuuktype(String pIfeTsdai2stuuktype) {
        ifeTsdai2stuuktype = pIfeTsdai2stuuktype;
    }

    @Column(order = 511, label = "dai2s")
    private String ifeTsdai2s;

    public String getIfeTsdai2s() {
        return ifeTsdai2s;
    }

    public void setIfeTsdai2s(String pIfeTsdai2s) {
        ifeTsdai2s = pIfeTsdai2s;
    }

    @Column(order = 512, label = "dai2s$")
    private String ifeTsdai2st;

    public String getIfeTsdai2st() {
        return ifeTsdai2st;
    }

    public void setIfeTsdai2st(String pIfeTsdai2st) {
        ifeTsdai2st = pIfeTsdai2st;
    }

    @Column(order = 513, label = "dai2syentuuktype")
    private String ifeTsdai2syentuuktype;

    public String getIfeTsdai2syentuuktype() {
        return ifeTsdai2syentuuktype;
    }

    public void setIfeTsdai2syentuuktype(String pIfeTsdai2syentuuktype) {
        ifeTsdai2syentuuktype = pIfeTsdai2syentuuktype;
    }

    @Column(order = 514, label = "dai2syenyendaka")
    private String ifeTsdai2syenyendaka;

    public String getIfeTsdai2syenyendaka() {
        return ifeTsdai2syenyendaka;
    }

    public void setIfeTsdai2syenyendaka(String pIfeTsdai2syenyendaka) {
        ifeTsdai2syenyendaka = pIfeTsdai2syenyendaka;
    }

    @Column(order = 515, label = "dai2syenyendaka$")
    private String ifeTsdai2syenyendakat;

    public String getIfeTsdai2syenyendakat() {
        return ifeTsdai2syenyendakat;
    }

    public void setIfeTsdai2syenyendakat(String pIfeTsdai2syenyendakat) {
        ifeTsdai2syenyendakat = pIfeTsdai2syenyendakat;
    }

    @Column(order = 516, label = "dai2syenyenkijyun")
    private String ifeTsdai2syenyenkijyun;

    public String getIfeTsdai2syenyenkijyun() {
        return ifeTsdai2syenyenkijyun;
    }

    public void setIfeTsdai2syenyenkijyun(String pIfeTsdai2syenyenkijyun) {
        ifeTsdai2syenyenkijyun = pIfeTsdai2syenyenkijyun;
    }

    @Column(order = 517, label = "dai2syenyenkijyun$")
    private String ifeTsdai2syenyenkijyunt;

    public String getIfeTsdai2syenyenkijyunt() {
        return ifeTsdai2syenyenkijyunt;
    }

    public void setIfeTsdai2syenyenkijyunt(String pIfeTsdai2syenyenkijyunt) {
        ifeTsdai2syenyenkijyunt = pIfeTsdai2syenyenkijyunt;
    }

    @Column(order = 518, label = "dai2syenyenyasu")
    private String ifeTsdai2syenyenyasu;

    public String getIfeTsdai2syenyenyasu() {
        return ifeTsdai2syenyenyasu;
    }

    public void setIfeTsdai2syenyenyasu(String pIfeTsdai2syenyenyasu) {
        ifeTsdai2syenyenyasu = pIfeTsdai2syenyenyasu;
    }

    @Column(order = 519, label = "dai2syenyenyasu$")
    private String ifeTsdai2syenyenyasut;

    public String getIfeTsdai2syenyenyasut() {
        return ifeTsdai2syenyenyasut;
    }

    public void setIfeTsdai2syenyenyasut(String pIfeTsdai2syenyenyasut) {
        ifeTsdai2syenyenyasut = pIfeTsdai2syenyenyasut;
    }

    @Column(order = 520, label = "dai3stuuktype")
    private String ifeTsdai3stuuktype;

    public String getIfeTsdai3stuuktype() {
        return ifeTsdai3stuuktype;
    }

    public void setIfeTsdai3stuuktype(String pIfeTsdai3stuuktype) {
        ifeTsdai3stuuktype = pIfeTsdai3stuuktype;
    }

    @Column(order = 521, label = "dai3s")
    private String ifeTsdai3s;

    public String getIfeTsdai3s() {
        return ifeTsdai3s;
    }

    public void setIfeTsdai3s(String pIfeTsdai3s) {
        ifeTsdai3s = pIfeTsdai3s;
    }

    @Column(order = 522, label = "dai3s$")
    private String ifeTsdai3st;

    public String getIfeTsdai3st() {
        return ifeTsdai3st;
    }

    public void setIfeTsdai3st(String pIfeTsdai3st) {
        ifeTsdai3st = pIfeTsdai3st;
    }

    @Column(order = 523, label = "dai3syentuuktype")
    private String ifeTsdai3syentuuktype;

    public String getIfeTsdai3syentuuktype() {
        return ifeTsdai3syentuuktype;
    }

    public void setIfeTsdai3syentuuktype(String pIfeTsdai3syentuuktype) {
        ifeTsdai3syentuuktype = pIfeTsdai3syentuuktype;
    }

    @Column(order = 524, label = "dai3syenyendaka")
    private String ifeTsdai3syenyendaka;

    public String getIfeTsdai3syenyendaka() {
        return ifeTsdai3syenyendaka;
    }

    public void setIfeTsdai3syenyendaka(String pIfeTsdai3syenyendaka) {
        ifeTsdai3syenyendaka = pIfeTsdai3syenyendaka;
    }

    @Column(order = 525, label = "dai3syenyendaka$")
    private String ifeTsdai3syenyendakat;

    public String getIfeTsdai3syenyendakat() {
        return ifeTsdai3syenyendakat;
    }

    public void setIfeTsdai3syenyendakat(String pIfeTsdai3syenyendakat) {
        ifeTsdai3syenyendakat = pIfeTsdai3syenyendakat;
    }

    @Column(order = 526, label = "dai3syenyenkijyun")
    private String ifeTsdai3syenyenkijyun;

    public String getIfeTsdai3syenyenkijyun() {
        return ifeTsdai3syenyenkijyun;
    }

    public void setIfeTsdai3syenyenkijyun(String pIfeTsdai3syenyenkijyun) {
        ifeTsdai3syenyenkijyun = pIfeTsdai3syenyenkijyun;
    }

    @Column(order = 527, label = "dai3syenyenkijyun$")
    private String ifeTsdai3syenyenkijyunt;

    public String getIfeTsdai3syenyenkijyunt() {
        return ifeTsdai3syenyenkijyunt;
    }

    public void setIfeTsdai3syenyenkijyunt(String pIfeTsdai3syenyenkijyunt) {
        ifeTsdai3syenyenkijyunt = pIfeTsdai3syenyenkijyunt;
    }

    @Column(order = 528, label = "dai3syenyenyasu")
    private String ifeTsdai3syenyenyasu;

    public String getIfeTsdai3syenyenyasu() {
        return ifeTsdai3syenyenyasu;
    }

    public void setIfeTsdai3syenyenyasu(String pIfeTsdai3syenyenyasu) {
        ifeTsdai3syenyenyasu = pIfeTsdai3syenyenyasu;
    }

    @Column(order = 529, label = "dai3syenyenyasu$")
    private String ifeTsdai3syenyenyasut;

    public String getIfeTsdai3syenyenyasut() {
        return ifeTsdai3syenyenyasut;
    }

    public void setIfeTsdai3syenyenyasut(String pIfeTsdai3syenyenyasut) {
        ifeTsdai3syenyenyasut = pIfeTsdai3syenyenyasut;
    }

    @Column(order = 530, label = "sibouinjiptnkbn")
    private String ifeTssibouinjiptnkbn;

    public String getIfeTssibouinjiptnkbn() {
        return ifeTssibouinjiptnkbn;
    }

    public void setIfeTssibouinjiptnkbn(String pIfeTssibouinjiptnkbn) {
        ifeTssibouinjiptnkbn = pIfeTssibouinjiptnkbn;
    }

    @Column(order = 531, label = "mkhyouyensysnikoumsgcd")
    private String ifeTsmkhyouyensysnikoumsgcd;

    public String getIfeTsmkhyouyensysnikoumsgcd() {
        return ifeTsmkhyouyensysnikoumsgcd;
    }

    public void setIfeTsmkhyouyensysnikoumsgcd(String pIfeTsmkhyouyensysnikoumsgcd) {
        ifeTsmkhyouyensysnikoumsgcd = pIfeTsmkhyouyensysnikoumsgcd;
    }

    @Column(order = 532, label = "mkhyouyensysnikoumsgcd2")
    private String ifeTsmkhyyensysnikoumsgcd2;

    public String getIfeTsmkhyyensysnikoumsgcd2() {
        return ifeTsmkhyyensysnikoumsgcd2;
    }

    public void setIfeTsmkhyyensysnikoumsgcd2(String pIfeTsmkhyyensysnikoumsgcd2) {
        ifeTsmkhyyensysnikoumsgcd2 = pIfeTsmkhyyensysnikoumsgcd2;
    }

    @Column(order = 533, label = "mkhyouyensysnikoumsgcd3")
    private String ifeTsmkhyyensysnikoumsgcd3;

    public String getIfeTsmkhyyensysnikoumsgcd3() {
        return ifeTsmkhyyensysnikoumsgcd3;
    }

    public void setIfeTsmkhyyensysnikoumsgcd3(String pIfeTsmkhyyensysnikoumsgcd3) {
        ifeTsmkhyyensysnikoumsgcd3 = pIfeTsmkhyyensysnikoumsgcd3;
    }

    @Column(order = 534, label = "mkhyouyensysnikougktype")
    private String ifeTsmkhyyensysnikougktype;

    public String getIfeTsmkhyyensysnikougktype() {
        return ifeTsmkhyyensysnikougktype;
    }

    public void setIfeTsmkhyyensysnikougktype(String pIfeTsmkhyyensysnikougktype) {
        ifeTsmkhyyensysnikougktype = pIfeTsmkhyyensysnikougktype;
    }

    @Column(order = 535, label = "mkhyouyensysnikougk")
    private String ifeTsmkhyouyensysnikougk;

    public String getIfeTsmkhyouyensysnikougk() {
        return ifeTsmkhyouyensysnikougk;
    }

    public void setIfeTsmkhyouyensysnikougk(String pIfeTsmkhyouyensysnikougk) {
        ifeTsmkhyouyensysnikougk = pIfeTsmkhyouyensysnikougk;
    }

    @Column(order = 536, label = "mkhyouyensysnikougk$")
    private String ifeTsmkhyouyensysnikougkt;

    public String getIfeTsmkhyouyensysnikougkt() {
        return ifeTsmkhyouyensysnikougkt;
    }

    public void setIfeTsmkhyouyensysnikougkt(String pIfeTsmkhyouyensysnikougkt) {
        ifeTsmkhyouyensysnikougkt = pIfeTsmkhyouyensysnikougkt;
    }

    @Column(order = 537, label = "mkhyouyensysnikouwra")
    private String ifeTsmkhyouyensysnikouwra;

    public String getIfeTsmkhyouyensysnikouwra() {
        return ifeTsmkhyouyensysnikouwra;
    }

    public void setIfeTsmkhyouyensysnikouwra(String pIfeTsmkhyouyensysnikouwra) {
        ifeTsmkhyouyensysnikouwra = pIfeTsmkhyouyensysnikouwra;
    }

    @Column(order = 538, label = "kaigomaehrtkykmsgcd1")
    private String ifeTskaigomaehrtkykmsgcd1;

    public String getIfeTskaigomaehrtkykmsgcd1() {
        return ifeTskaigomaehrtkykmsgcd1;
    }

    public void setIfeTskaigomaehrtkykmsgcd1(String pIfeTskaigomaehrtkykmsgcd1) {
        ifeTskaigomaehrtkykmsgcd1 = pIfeTskaigomaehrtkykmsgcd1;
    }

    @Column(order = 539, label = "kaigomaehrtkykmsgcd2")
    private String ifeTskaigomaehrtkykmsgcd2;

    public String getIfeTskaigomaehrtkykmsgcd2() {
        return ifeTskaigomaehrtkykmsgcd2;
    }

    public void setIfeTskaigomaehrtkykmsgcd2(String pIfeTskaigomaehrtkykmsgcd2) {
        ifeTskaigomaehrtkykmsgcd2 = pIfeTskaigomaehrtkykmsgcd2;
    }

    @Column(order = 540, label = "kaigomaehrtkykmsgcdst1")
    private String ifeTskaigomaehrtkykmsgcdst1;

    public String getIfeTskaigomaehrtkykmsgcdst1() {
        return ifeTskaigomaehrtkykmsgcdst1;
    }

    public void setIfeTskaigomaehrtkykmsgcdst1(String pIfeTskaigomaehrtkykmsgcdst1) {
        ifeTskaigomaehrtkykmsgcdst1 = pIfeTskaigomaehrtkykmsgcdst1;
    }

    @Column(order = 541, label = "kaigomaehrtkykmsgcdst2")
    private String ifeTskaigomaehrtkykmsgcdst2;

    public String getIfeTskaigomaehrtkykmsgcdst2() {
        return ifeTskaigomaehrtkykmsgcdst2;
    }

    public void setIfeTskaigomaehrtkykmsgcdst2(String pIfeTskaigomaehrtkykmsgcdst2) {
        ifeTskaigomaehrtkykmsgcdst2 = pIfeTskaigomaehrtkykmsgcdst2;
    }

    @Column(order = 542, label = "kaigomaehruktgkumu")
    private String ifeTskaigomaehruktgkumu;

    public String getIfeTskaigomaehruktgkumu() {
        return ifeTskaigomaehruktgkumu;
    }

    public void setIfeTskaigomaehruktgkumu(String pIfeTskaigomaehruktgkumu) {
        ifeTskaigomaehruktgkumu = pIfeTskaigomaehruktgkumu;
    }

    @Column(order = 543, label = "kaigomaehrtkykkyktuuka")
    private String ifeTskaigomaehrtkykkyktuuka;

    public String getIfeTskaigomaehrtkykkyktuuka() {
        return ifeTskaigomaehrtkykkyktuuka;
    }

    public void setIfeTskaigomaehrtkykkyktuuka(String pIfeTskaigomaehrtkykkyktuuka) {
        ifeTskaigomaehrtkykkyktuuka = pIfeTskaigomaehrtkykkyktuuka;
    }

    @Column(order = 544, label = "kaigomaehrtkykstdmsgcd")
    private String ifeTskaigomaehrtkykstdmsgcd;

    public String getIfeTskaigomaehrtkykstdmsgcd() {
        return ifeTskaigomaehrtkykstdmsgcd;
    }

    public void setIfeTskaigomaehrtkykstdmsgcd(String pIfeTskaigomaehrtkykstdmsgcd) {
        ifeTskaigomaehrtkykstdmsgcd = pIfeTskaigomaehrtkykstdmsgcd;
    }

    @Column(order = 545, label = "kaigomaehrjrugktype")
    private String ifeTskaigomaehrjrugktype;

    public String getIfeTskaigomaehrjrugktype() {
        return ifeTskaigomaehrjrugktype;
    }

    public void setIfeTskaigomaehrjrugktype(String pIfeTskaigomaehrjrugktype) {
        ifeTskaigomaehrjrugktype = pIfeTskaigomaehrjrugktype;
    }

    @Column(order = 546, label = "kaigomaehrsikuhhknnen01")
    private String ifeTskgomaehrsikuhhknnen01;

    public String getIfeTskgomaehrsikuhhknnen01() {
        return ifeTskgomaehrsikuhhknnen01;
    }

    public void setIfeTskgomaehrsikuhhknnen01(String pIfeTskgomaehrsikuhhknnen01) {
        ifeTskgomaehrsikuhhknnen01 = pIfeTskgomaehrsikuhhknnen01;
    }

    @Column(order = 547, label = "kaigomaehrstikkn01")
    private String ifeTskaigomaehrstikkn01;

    public String getIfeTskaigomaehrstikkn01() {
        return ifeTskaigomaehrstikkn01;
    }

    public void setIfeTskaigomaehrstikkn01(String pIfeTskaigomaehrstikkn01) {
        ifeTskaigomaehrstikkn01 = pIfeTskaigomaehrstikkn01;
    }

    @Column(order = 548, label = "kaigomaehrjrugk01")
    private String ifeTskaigomaehrjrugk01;

    public String getIfeTskaigomaehrjrugk01() {
        return ifeTskaigomaehrjrugk01;
    }

    public void setIfeTskaigomaehrjrugk01(String pIfeTskaigomaehrjrugk01) {
        ifeTskaigomaehrjrugk01 = pIfeTskaigomaehrjrugk01;
    }

    @Column(order = 549, label = "kaigomaehrjrugk01$")
    private String ifeTskaigomaehrjrugk01t;

    public String getIfeTskaigomaehrjrugk01t() {
        return ifeTskaigomaehrjrugk01t;
    }

    public void setIfeTskaigomaehrjrugk01t(String pIfeTskaigomaehrjrugk01t) {
        ifeTskaigomaehrjrugk01t = pIfeTskaigomaehrjrugk01t;
    }

    @Column(order = 550, label = "kaigomaehrsikuhhknnen02")
    private String ifeTskgomaehrsikuhhknnen02;

    public String getIfeTskgomaehrsikuhhknnen02() {
        return ifeTskgomaehrsikuhhknnen02;
    }

    public void setIfeTskgomaehrsikuhhknnen02(String pIfeTskgomaehrsikuhhknnen02) {
        ifeTskgomaehrsikuhhknnen02 = pIfeTskgomaehrsikuhhknnen02;
    }

    @Column(order = 551, label = "kaigomaehrstikkn02")
    private String ifeTskaigomaehrstikkn02;

    public String getIfeTskaigomaehrstikkn02() {
        return ifeTskaigomaehrstikkn02;
    }

    public void setIfeTskaigomaehrstikkn02(String pIfeTskaigomaehrstikkn02) {
        ifeTskaigomaehrstikkn02 = pIfeTskaigomaehrstikkn02;
    }

    @Column(order = 552, label = "kaigomaehrjrugk02")
    private String ifeTskaigomaehrjrugk02;

    public String getIfeTskaigomaehrjrugk02() {
        return ifeTskaigomaehrjrugk02;
    }

    public void setIfeTskaigomaehrjrugk02(String pIfeTskaigomaehrjrugk02) {
        ifeTskaigomaehrjrugk02 = pIfeTskaigomaehrjrugk02;
    }

    @Column(order = 553, label = "kaigomaehrjrugk02$")
    private String ifeTskaigomaehrjrugk02t;

    public String getIfeTskaigomaehrjrugk02t() {
        return ifeTskaigomaehrjrugk02t;
    }

    public void setIfeTskaigomaehrjrugk02t(String pIfeTskaigomaehrjrugk02t) {
        ifeTskaigomaehrjrugk02t = pIfeTskaigomaehrjrugk02t;
    }

    @Column(order = 554, label = "kaigomaehrsikuhhknnen03")
    private String ifeTskgomaehrsikuhhknnen03;

    public String getIfeTskgomaehrsikuhhknnen03() {
        return ifeTskgomaehrsikuhhknnen03;
    }

    public void setIfeTskgomaehrsikuhhknnen03(String pIfeTskgomaehrsikuhhknnen03) {
        ifeTskgomaehrsikuhhknnen03 = pIfeTskgomaehrsikuhhknnen03;
    }

    @Column(order = 555, label = "kaigomaehrstikkn03")
    private String ifeTskaigomaehrstikkn03;

    public String getIfeTskaigomaehrstikkn03() {
        return ifeTskaigomaehrstikkn03;
    }

    public void setIfeTskaigomaehrstikkn03(String pIfeTskaigomaehrstikkn03) {
        ifeTskaigomaehrstikkn03 = pIfeTskaigomaehrstikkn03;
    }

    @Column(order = 556, label = "kaigomaehrjrugk03")
    private String ifeTskaigomaehrjrugk03;

    public String getIfeTskaigomaehrjrugk03() {
        return ifeTskaigomaehrjrugk03;
    }

    public void setIfeTskaigomaehrjrugk03(String pIfeTskaigomaehrjrugk03) {
        ifeTskaigomaehrjrugk03 = pIfeTskaigomaehrjrugk03;
    }

    @Column(order = 557, label = "kaigomaehrjrugk03$")
    private String ifeTskaigomaehrjrugk03t;

    public String getIfeTskaigomaehrjrugk03t() {
        return ifeTskaigomaehrjrugk03t;
    }

    public void setIfeTskaigomaehrjrugk03t(String pIfeTskaigomaehrjrugk03t) {
        ifeTskaigomaehrjrugk03t = pIfeTskaigomaehrjrugk03t;
    }

    @Column(order = 558, label = "kaigomaehrsikuhhknnen04")
    private String ifeTskgomaehrsikuhhknnen04;

    public String getIfeTskgomaehrsikuhhknnen04() {
        return ifeTskgomaehrsikuhhknnen04;
    }

    public void setIfeTskgomaehrsikuhhknnen04(String pIfeTskgomaehrsikuhhknnen04) {
        ifeTskgomaehrsikuhhknnen04 = pIfeTskgomaehrsikuhhknnen04;
    }

    @Column(order = 559, label = "kaigomaehrstikkn04")
    private String ifeTskaigomaehrstikkn04;

    public String getIfeTskaigomaehrstikkn04() {
        return ifeTskaigomaehrstikkn04;
    }

    public void setIfeTskaigomaehrstikkn04(String pIfeTskaigomaehrstikkn04) {
        ifeTskaigomaehrstikkn04 = pIfeTskaigomaehrstikkn04;
    }

    @Column(order = 560, label = "kaigomaehrjrugk04")
    private String ifeTskaigomaehrjrugk04;

    public String getIfeTskaigomaehrjrugk04() {
        return ifeTskaigomaehrjrugk04;
    }

    public void setIfeTskaigomaehrjrugk04(String pIfeTskaigomaehrjrugk04) {
        ifeTskaigomaehrjrugk04 = pIfeTskaigomaehrjrugk04;
    }

    @Column(order = 561, label = "kaigomaehrjrugk04$")
    private String ifeTskaigomaehrjrugk04t;

    public String getIfeTskaigomaehrjrugk04t() {
        return ifeTskaigomaehrjrugk04t;
    }

    public void setIfeTskaigomaehrjrugk04t(String pIfeTskaigomaehrjrugk04t) {
        ifeTskaigomaehrjrugk04t = pIfeTskaigomaehrjrugk04t;
    }

    @Column(order = 562, label = "kaigomaehrsikuhhknnen05")
    private String ifeTskgomaehrsikuhhknnen05;

    public String getIfeTskgomaehrsikuhhknnen05() {
        return ifeTskgomaehrsikuhhknnen05;
    }

    public void setIfeTskgomaehrsikuhhknnen05(String pIfeTskgomaehrsikuhhknnen05) {
        ifeTskgomaehrsikuhhknnen05 = pIfeTskgomaehrsikuhhknnen05;
    }

    @Column(order = 563, label = "kaigomaehrstikkn05")
    private String ifeTskaigomaehrstikkn05;

    public String getIfeTskaigomaehrstikkn05() {
        return ifeTskaigomaehrstikkn05;
    }

    public void setIfeTskaigomaehrstikkn05(String pIfeTskaigomaehrstikkn05) {
        ifeTskaigomaehrstikkn05 = pIfeTskaigomaehrstikkn05;
    }

    @Column(order = 564, label = "kaigomaehrjrugk05")
    private String ifeTskaigomaehrjrugk05;

    public String getIfeTskaigomaehrjrugk05() {
        return ifeTskaigomaehrjrugk05;
    }

    public void setIfeTskaigomaehrjrugk05(String pIfeTskaigomaehrjrugk05) {
        ifeTskaigomaehrjrugk05 = pIfeTskaigomaehrjrugk05;
    }

    @Column(order = 565, label = "kaigomaehrjrugk05$")
    private String ifeTskaigomaehrjrugk05t;

    public String getIfeTskaigomaehrjrugk05t() {
        return ifeTskaigomaehrjrugk05t;
    }

    public void setIfeTskaigomaehrjrugk05t(String pIfeTskaigomaehrjrugk05t) {
        ifeTskaigomaehrjrugk05t = pIfeTskaigomaehrjrugk05t;
    }

    @Column(order = 566, label = "kaigomaehrsikuhhknnen06")
    private String ifeTskgomaehrsikuhhknnen06;

    public String getIfeTskgomaehrsikuhhknnen06() {
        return ifeTskgomaehrsikuhhknnen06;
    }

    public void setIfeTskgomaehrsikuhhknnen06(String pIfeTskgomaehrsikuhhknnen06) {
        ifeTskgomaehrsikuhhknnen06 = pIfeTskgomaehrsikuhhknnen06;
    }

    @Column(order = 567, label = "kaigomaehrstikkn06")
    private String ifeTskaigomaehrstikkn06;

    public String getIfeTskaigomaehrstikkn06() {
        return ifeTskaigomaehrstikkn06;
    }

    public void setIfeTskaigomaehrstikkn06(String pIfeTskaigomaehrstikkn06) {
        ifeTskaigomaehrstikkn06 = pIfeTskaigomaehrstikkn06;
    }

    @Column(order = 568, label = "kaigomaehrjrugk06")
    private String ifeTskaigomaehrjrugk06;

    public String getIfeTskaigomaehrjrugk06() {
        return ifeTskaigomaehrjrugk06;
    }

    public void setIfeTskaigomaehrjrugk06(String pIfeTskaigomaehrjrugk06) {
        ifeTskaigomaehrjrugk06 = pIfeTskaigomaehrjrugk06;
    }

    @Column(order = 569, label = "kaigomaehrjrugk06$")
    private String ifeTskaigomaehrjrugk06t;

    public String getIfeTskaigomaehrjrugk06t() {
        return ifeTskaigomaehrjrugk06t;
    }

    public void setIfeTskaigomaehrjrugk06t(String pIfeTskaigomaehrjrugk06t) {
        ifeTskaigomaehrjrugk06t = pIfeTskaigomaehrjrugk06t;
    }

    @Column(order = 570, label = "kaigomaehrsikuhhknnen07")
    private String ifeTskgomaehrsikuhhknnen07;

    public String getIfeTskgomaehrsikuhhknnen07() {
        return ifeTskgomaehrsikuhhknnen07;
    }

    public void setIfeTskgomaehrsikuhhknnen07(String pIfeTskgomaehrsikuhhknnen07) {
        ifeTskgomaehrsikuhhknnen07 = pIfeTskgomaehrsikuhhknnen07;
    }

    @Column(order = 571, label = "kaigomaehrstikkn07")
    private String ifeTskaigomaehrstikkn07;

    public String getIfeTskaigomaehrstikkn07() {
        return ifeTskaigomaehrstikkn07;
    }

    public void setIfeTskaigomaehrstikkn07(String pIfeTskaigomaehrstikkn07) {
        ifeTskaigomaehrstikkn07 = pIfeTskaigomaehrstikkn07;
    }

    @Column(order = 572, label = "kaigomaehrjrugk07")
    private String ifeTskaigomaehrjrugk07;

    public String getIfeTskaigomaehrjrugk07() {
        return ifeTskaigomaehrjrugk07;
    }

    public void setIfeTskaigomaehrjrugk07(String pIfeTskaigomaehrjrugk07) {
        ifeTskaigomaehrjrugk07 = pIfeTskaigomaehrjrugk07;
    }

    @Column(order = 573, label = "kaigomaehrjrugk07$")
    private String ifeTskaigomaehrjrugk07t;

    public String getIfeTskaigomaehrjrugk07t() {
        return ifeTskaigomaehrjrugk07t;
    }

    public void setIfeTskaigomaehrjrugk07t(String pIfeTskaigomaehrjrugk07t) {
        ifeTskaigomaehrjrugk07t = pIfeTskaigomaehrjrugk07t;
    }

    @Column(order = 574, label = "kaigomaehrsikuhhknnen08")
    private String ifeTskgomaehrsikuhhknnen08;

    public String getIfeTskgomaehrsikuhhknnen08() {
        return ifeTskgomaehrsikuhhknnen08;
    }

    public void setIfeTskgomaehrsikuhhknnen08(String pIfeTskgomaehrsikuhhknnen08) {
        ifeTskgomaehrsikuhhknnen08 = pIfeTskgomaehrsikuhhknnen08;
    }

    @Column(order = 575, label = "kaigomaehrstikkn08")
    private String ifeTskaigomaehrstikkn08;

    public String getIfeTskaigomaehrstikkn08() {
        return ifeTskaigomaehrstikkn08;
    }

    public void setIfeTskaigomaehrstikkn08(String pIfeTskaigomaehrstikkn08) {
        ifeTskaigomaehrstikkn08 = pIfeTskaigomaehrstikkn08;
    }

    @Column(order = 576, label = "kaigomaehrjrugk08")
    private String ifeTskaigomaehrjrugk08;

    public String getIfeTskaigomaehrjrugk08() {
        return ifeTskaigomaehrjrugk08;
    }

    public void setIfeTskaigomaehrjrugk08(String pIfeTskaigomaehrjrugk08) {
        ifeTskaigomaehrjrugk08 = pIfeTskaigomaehrjrugk08;
    }

    @Column(order = 577, label = "kaigomaehrjrugk08$")
    private String ifeTskaigomaehrjrugk08t;

    public String getIfeTskaigomaehrjrugk08t() {
        return ifeTskaigomaehrjrugk08t;
    }

    public void setIfeTskaigomaehrjrugk08t(String pIfeTskaigomaehrjrugk08t) {
        ifeTskaigomaehrjrugk08t = pIfeTskaigomaehrjrugk08t;
    }

    @Column(order = 578, label = "kaigomaehrsikuhhknnen09")
    private String ifeTskgomaehrsikuhhknnen09;

    public String getIfeTskgomaehrsikuhhknnen09() {
        return ifeTskgomaehrsikuhhknnen09;
    }

    public void setIfeTskgomaehrsikuhhknnen09(String pIfeTskgomaehrsikuhhknnen09) {
        ifeTskgomaehrsikuhhknnen09 = pIfeTskgomaehrsikuhhknnen09;
    }

    @Column(order = 579, label = "kaigomaehrstikkn09")
    private String ifeTskaigomaehrstikkn09;

    public String getIfeTskaigomaehrstikkn09() {
        return ifeTskaigomaehrstikkn09;
    }

    public void setIfeTskaigomaehrstikkn09(String pIfeTskaigomaehrstikkn09) {
        ifeTskaigomaehrstikkn09 = pIfeTskaigomaehrstikkn09;
    }

    @Column(order = 580, label = "kaigomaehrjrugk09")
    private String ifeTskaigomaehrjrugk09;

    public String getIfeTskaigomaehrjrugk09() {
        return ifeTskaigomaehrjrugk09;
    }

    public void setIfeTskaigomaehrjrugk09(String pIfeTskaigomaehrjrugk09) {
        ifeTskaigomaehrjrugk09 = pIfeTskaigomaehrjrugk09;
    }

    @Column(order = 581, label = "kaigomaehrjrugk09$")
    private String ifeTskaigomaehrjrugk09t;

    public String getIfeTskaigomaehrjrugk09t() {
        return ifeTskaigomaehrjrugk09t;
    }

    public void setIfeTskaigomaehrjrugk09t(String pIfeTskaigomaehrjrugk09t) {
        ifeTskaigomaehrjrugk09t = pIfeTskaigomaehrjrugk09t;
    }

    @Column(order = 582, label = "kaigomaehrsikuhhknnen10")
    private String ifeTskgomaehrsikuhhknnen10;

    public String getIfeTskgomaehrsikuhhknnen10() {
        return ifeTskgomaehrsikuhhknnen10;
    }

    public void setIfeTskgomaehrsikuhhknnen10(String pIfeTskgomaehrsikuhhknnen10) {
        ifeTskgomaehrsikuhhknnen10 = pIfeTskgomaehrsikuhhknnen10;
    }

    @Column(order = 583, label = "kaigomaehrstikkn10")
    private String ifeTskaigomaehrstikkn10;

    public String getIfeTskaigomaehrstikkn10() {
        return ifeTskaigomaehrstikkn10;
    }

    public void setIfeTskaigomaehrstikkn10(String pIfeTskaigomaehrstikkn10) {
        ifeTskaigomaehrstikkn10 = pIfeTskaigomaehrstikkn10;
    }

    @Column(order = 584, label = "kaigomaehrjrugk10")
    private String ifeTskaigomaehrjrugk10;

    public String getIfeTskaigomaehrjrugk10() {
        return ifeTskaigomaehrjrugk10;
    }

    public void setIfeTskaigomaehrjrugk10(String pIfeTskaigomaehrjrugk10) {
        ifeTskaigomaehrjrugk10 = pIfeTskaigomaehrjrugk10;
    }

    @Column(order = 585, label = "kaigomaehrjrugk10$")
    private String ifeTskaigomaehrjrugk10t;

    public String getIfeTskaigomaehrjrugk10t() {
        return ifeTskaigomaehrjrugk10t;
    }

    public void setIfeTskaigomaehrjrugk10t(String pIfeTskaigomaehrjrugk10t) {
        ifeTskaigomaehrjrugk10t = pIfeTskaigomaehrjrugk10t;
    }

    @Column(order = 586, label = "hutanhiyustmmsgcdue01")
    private String ifeTshutanhiyustmmsgcdue01;

    public String getIfeTshutanhiyustmmsgcdue01() {
        return ifeTshutanhiyustmmsgcdue01;
    }

    public void setIfeTshutanhiyustmmsgcdue01(String pIfeTshutanhiyustmmsgcdue01) {
        ifeTshutanhiyustmmsgcdue01 = pIfeTshutanhiyustmmsgcdue01;
    }

    @Column(order = 587, label = "hutanhiyustmmsgcdue02")
    private String ifeTshutanhiyustmmsgcdue02;

    public String getIfeTshutanhiyustmmsgcdue02() {
        return ifeTshutanhiyustmmsgcdue02;
    }

    public void setIfeTshutanhiyustmmsgcdue02(String pIfeTshutanhiyustmmsgcdue02) {
        ifeTshutanhiyustmmsgcdue02 = pIfeTshutanhiyustmmsgcdue02;
    }

    @Column(order = 588, label = "hutanhiyustmmsgcdue03")
    private String ifeTshutanhiyustmmsgcdue03;

    public String getIfeTshutanhiyustmmsgcdue03() {
        return ifeTshutanhiyustmmsgcdue03;
    }

    public void setIfeTshutanhiyustmmsgcdue03(String pIfeTshutanhiyustmmsgcdue03) {
        ifeTshutanhiyustmmsgcdue03 = pIfeTshutanhiyustmmsgcdue03;
    }

    @Column(order = 589, label = "hutanhiyustmmsgcdue04")
    private String ifeTshutanhiyustmmsgcdue04;

    public String getIfeTshutanhiyustmmsgcdue04() {
        return ifeTshutanhiyustmmsgcdue04;
    }

    public void setIfeTshutanhiyustmmsgcdue04(String pIfeTshutanhiyustmmsgcdue04) {
        ifeTshutanhiyustmmsgcdue04 = pIfeTshutanhiyustmmsgcdue04;
    }

    @Column(order = 590, label = "hutanhiyustmknsnhyuptn")
    private String ifeTshutanhiyustmknsnhyuptn;

    public String getIfeTshutanhiyustmknsnhyuptn() {
        return ifeTshutanhiyustmknsnhyuptn;
    }

    public void setIfeTshutanhiyustmknsnhyuptn(String pIfeTshutanhiyustmknsnhyuptn) {
        ifeTshutanhiyustmknsnhyuptn = pIfeTshutanhiyustmknsnhyuptn;
    }

    @Column(order = 591, label = "hutanhiyustmmsgcdst01")
    private String ifeTshutanhiyustmmsgcdst01;

    public String getIfeTshutanhiyustmmsgcdst01() {
        return ifeTshutanhiyustmmsgcdst01;
    }

    public void setIfeTshutanhiyustmmsgcdst01(String pIfeTshutanhiyustmmsgcdst01) {
        ifeTshutanhiyustmmsgcdst01 = pIfeTshutanhiyustmmsgcdst01;
    }

    @Column(order = 592, label = "hutanhiyustmmsgcdst02")
    private String ifeTshutanhiyustmmsgcdst02;

    public String getIfeTshutanhiyustmmsgcdst02() {
        return ifeTshutanhiyustmmsgcdst02;
    }

    public void setIfeTshutanhiyustmmsgcdst02(String pIfeTshutanhiyustmmsgcdst02) {
        ifeTshutanhiyustmmsgcdst02 = pIfeTshutanhiyustmmsgcdst02;
    }

    @Column(order = 593, label = "hutanhiyustmmsgcdst03")
    private String ifeTshutanhiyustmmsgcdst03;

    public String getIfeTshutanhiyustmmsgcdst03() {
        return ifeTshutanhiyustmmsgcdst03;
    }

    public void setIfeTshutanhiyustmmsgcdst03(String pIfeTshutanhiyustmmsgcdst03) {
        ifeTshutanhiyustmmsgcdst03 = pIfeTshutanhiyustmmsgcdst03;
    }

    @Column(order = 594, label = "stdstmmsgcd")
    private String ifeTsstdstmmsgcd;

    public String getIfeTsstdstmmsgcd() {
        return ifeTsstdstmmsgcd;
    }

    public void setIfeTsstdstmmsgcd(String pIfeTsstdstmmsgcd) {
        ifeTsstdstmmsgcd = pIfeTsstdstmmsgcd;
    }

    @Column(order = 595, label = "fstpmsgcd")
    private String ifeTsfstpmsgcd;

    public String getIfeTsfstpmsgcd() {
        return ifeTsfstpmsgcd;
    }

    public void setIfeTsfstpmsgcd(String pIfeTsfstpmsgcd) {
        ifeTsfstpmsgcd = pIfeTsfstpmsgcd;
    }

    @Column(order = 596, label = "fstphrkpkngkkeituuktype")
    private String ifeTsfstphrkpkngkketuuktype;

    public String getIfeTsfstphrkpkngkketuuktype() {
        return ifeTsfstphrkpkngkketuuktype;
    }

    public void setIfeTsfstphrkpkngkketuuktype(String pIfeTsfstphrkpkngkketuuktype) {
        ifeTsfstphrkpkngkketuuktype = pIfeTsfstphrkpkngkketuuktype;
    }

    @Column(order = 597, label = "fstphrkpkngkkei")
    private String ifeTsfstphrkpkngkkei;

    public String getIfeTsfstphrkpkngkkei() {
        return ifeTsfstphrkpkngkkei;
    }

    public void setIfeTsfstphrkpkngkkei(String pIfeTsfstphrkpkngkkei) {
        ifeTsfstphrkpkngkkei = pIfeTsfstphrkpkngkkei;
    }

    @Column(order = 598, label = "fstphrkpkngkkei$")
    private String ifeTsfstphrkpkngkkeit;

    public String getIfeTsfstphrkpkngkkeit() {
        return ifeTsfstphrkpkngkkeit;
    }

    public void setIfeTsfstphrkpkngkkeit(String pIfeTsfstphrkpkngkkeit) {
        ifeTsfstphrkpkngkkeit = pIfeTsfstphrkpkngkkeit;
    }

    @Column(order = 599, label = "fstponegaimsgcd")
    private String ifeTsfstponegaimsgcd;

    public String getIfeTsfstponegaimsgcd() {
        return ifeTsfstponegaimsgcd;
    }

    public void setIfeTsfstponegaimsgcd(String pIfeTsfstponegaimsgcd) {
        ifeTsfstponegaimsgcd = pIfeTsfstponegaimsgcd;
    }

    @Column(order = 600, label = "dsmsgcd")
    private String ifeTsdsmsgcd;

    public String getIfeTsdsmsgcd() {
        return ifeTsdsmsgcd;
    }

    public void setIfeTsdsmsgcd(String pIfeTsdsmsgcd) {
        ifeTsdsmsgcd = pIfeTsdsmsgcd;
    }

    @Column(order = 601, label = "syouhnhutaimsgcd1")
    private String ifeTssyouhnhutaimsgcd1;

    public String getIfeTssyouhnhutaimsgcd1() {
        return ifeTssyouhnhutaimsgcd1;
    }

    public void setIfeTssyouhnhutaimsgcd1(String pIfeTssyouhnhutaimsgcd1) {
        ifeTssyouhnhutaimsgcd1 = pIfeTssyouhnhutaimsgcd1;
    }

    @Column(order = 602, label = "syouhnhutaimsgcd2")
    private String ifeTssyouhnhutaimsgcd2;

    public String getIfeTssyouhnhutaimsgcd2() {
        return ifeTssyouhnhutaimsgcd2;
    }

    public void setIfeTssyouhnhutaimsgcd2(String pIfeTssyouhnhutaimsgcd2) {
        ifeTssyouhnhutaimsgcd2 = pIfeTssyouhnhutaimsgcd2;
    }

    @Column(order = 603, label = "pyentuuktype")
    private String ifeTspyentuuktype;

    public String getIfeTspyentuuktype() {
        return ifeTspyentuuktype;
    }

    public void setIfeTspyentuuktype(String pIfeTspyentuuktype) {
        ifeTspyentuuktype = pIfeTspyentuuktype;
    }

    @Column(order = 604, label = "pyen")
    private String ifeTspyen;

    public String getIfeTspyen() {
        return ifeTspyen;
    }

    public void setIfeTspyen(String pIfeTspyen) {
        ifeTspyen = pIfeTspyen;
    }

    @Column(order = 605, label = "pyen$")
    private String ifeTspyent;

    public String getIfeTspyent() {
        return ifeTspyent;
    }

    public void setIfeTspyent(String pIfeTspyent) {
        ifeTspyent = pIfeTspyent;
    }

    @Column(order = 606, label = "toiawasesakihanyoumsgcd")
    private String ifeTstoiawasesakihanyomsgcd;

    public String getIfeTstoiawasesakihanyomsgcd() {
        return ifeTstoiawasesakihanyomsgcd;
    }

    public void setIfeTstoiawasesakihanyomsgcd(String pIfeTstoiawasesakihanyomsgcd) {
        ifeTstoiawasesakihanyomsgcd = pIfeTstoiawasesakihanyomsgcd;
    }

    @Column(order = 607, label = "annaihanyoumsgcd")
    private String ifeTsannaihanyoumsgcd;

    public String getIfeTsannaihanyoumsgcd() {
        return ifeTsannaihanyoumsgcd;
    }

    public void setIfeTsannaihanyoumsgcd(String pIfeTsannaihanyoumsgcd) {
        ifeTsannaihanyoumsgcd = pIfeTsannaihanyoumsgcd;
    }

    @Column(order = 608, label = "wmsgcd1")
    private String ifeTswmsgcd1;

    public String getIfeTswmsgcd1() {
        return ifeTswmsgcd1;
    }

    public void setIfeTswmsgcd1(String pIfeTswmsgcd1) {
        ifeTswmsgcd1 = pIfeTswmsgcd1;
    }

    @Column(order = 609, label = "wmsgcd2")
    private String ifeTswmsgcd2;

    public String getIfeTswmsgcd2() {
        return ifeTswmsgcd2;
    }

    public void setIfeTswmsgcd2(String pIfeTswmsgcd2) {
        ifeTswmsgcd2 = pIfeTswmsgcd2;
    }

    @Column(order = 610, label = "wmsgcd3")
    private String ifeTswmsgcd3;

    public String getIfeTswmsgcd3() {
        return ifeTswmsgcd3;
    }

    public void setIfeTswmsgcd3(String pIfeTswmsgcd3) {
        ifeTswmsgcd3 = pIfeTswmsgcd3;
    }

    @Column(order = 611, label = "wtyuuijikoumsgcd1")
    private String ifeTswtyuuijikoumsgcd1;

    public String getIfeTswtyuuijikoumsgcd1() {
        return ifeTswtyuuijikoumsgcd1;
    }

    public void setIfeTswtyuuijikoumsgcd1(String pIfeTswtyuuijikoumsgcd1) {
        ifeTswtyuuijikoumsgcd1 = pIfeTswtyuuijikoumsgcd1;
    }

    @Column(order = 612, label = "wtyuuijikoumsgcd2")
    private String ifeTswtyuuijikoumsgcd2;

    public String getIfeTswtyuuijikoumsgcd2() {
        return ifeTswtyuuijikoumsgcd2;
    }

    public void setIfeTswtyuuijikoumsgcd2(String pIfeTswtyuuijikoumsgcd2) {
        ifeTswtyuuijikoumsgcd2 = pIfeTswtyuuijikoumsgcd2;
    }

    @Column(order = 613, label = "wtyuuijikoumsgcd3")
    private String ifeTswtyuuijikoumsgcd3;

    public String getIfeTswtyuuijikoumsgcd3() {
        return ifeTswtyuuijikoumsgcd3;
    }

    public void setIfeTswtyuuijikoumsgcd3(String pIfeTswtyuuijikoumsgcd3) {
        ifeTswtyuuijikoumsgcd3 = pIfeTswtyuuijikoumsgcd3;
    }

    @Column(order = 614, label = "wtyuuijikoumsgcd4")
    private String ifeTswtyuuijikoumsgcd4;

    public String getIfeTswtyuuijikoumsgcd4() {
        return ifeTswtyuuijikoumsgcd4;
    }

    public void setIfeTswtyuuijikoumsgcd4(String pIfeTswtyuuijikoumsgcd4) {
        ifeTswtyuuijikoumsgcd4 = pIfeTswtyuuijikoumsgcd4;
    }

    @Column(order = 615, label = "wtyuuijikoumsgcd5")
    private String ifeTswtyuuijikoumsgcd5;

    public String getIfeTswtyuuijikoumsgcd5() {
        return ifeTswtyuuijikoumsgcd5;
    }

    public void setIfeTswtyuuijikoumsgcd5(String pIfeTswtyuuijikoumsgcd5) {
        ifeTswtyuuijikoumsgcd5 = pIfeTswtyuuijikoumsgcd5;
    }

    @Column(order = 616, label = "witijibrptuktype")
    private String ifeTswitijibrptuktype;

    public String getIfeTswitijibrptuktype() {
        return ifeTswitijibrptuktype;
    }

    public void setIfeTswitijibrptuktype(String pIfeTswitijibrptuktype) {
        ifeTswitijibrptuktype = pIfeTswitijibrptuktype;
    }

    @Column(order = 617, label = "witijibrp")
    private String ifeTswitijibrp;

    public String getIfeTswitijibrp() {
        return ifeTswitijibrp;
    }

    public void setIfeTswitijibrp(String pIfeTswitijibrp) {
        ifeTswitijibrp = pIfeTswitijibrp;
    }

    @Column(order = 618, label = "witijibrp$")
    private String ifeTswitijibrpt;

    public String getIfeTswitijibrpt() {
        return ifeTswitijibrpt;
    }

    public void setIfeTswitijibrpt(String pIfeTswitijibrpt) {
        ifeTswitijibrpt = pIfeTswitijibrpt;
    }

    @Column(order = 619, label = "wyenhrkgktuktype")
    private String ifeTswyenhrkgktuktype;

    public String getIfeTswyenhrkgktuktype() {
        return ifeTswyenhrkgktuktype;
    }

    public void setIfeTswyenhrkgktuktype(String pIfeTswyenhrkgktuktype) {
        ifeTswyenhrkgktuktype = pIfeTswyenhrkgktuktype;
    }

    @Column(order = 620, label = "wyenhrkgk")
    private String ifeTswyenhrkgk;

    public String getIfeTswyenhrkgk() {
        return ifeTswyenhrkgk;
    }

    public void setIfeTswyenhrkgk(String pIfeTswyenhrkgk) {
        ifeTswyenhrkgk = pIfeTswyenhrkgk;
    }

    @Column(order = 621, label = "wyenhrkgk$")
    private String ifeTswyenhrkgkt;

    public String getIfeTswyenhrkgkt() {
        return ifeTswyenhrkgkt;
    }

    public void setIfeTswyenhrkgkt(String pIfeTswyenhrkgkt) {
        ifeTswyenhrkgkt = pIfeTswyenhrkgkt;
    }

    @Column(order = 622, label = "wyenitijibrptuktype")
    private String ifeTswyenitijibrptuktype;

    public String getIfeTswyenitijibrptuktype() {
        return ifeTswyenitijibrptuktype;
    }

    public void setIfeTswyenitijibrptuktype(String pIfeTswyenitijibrptuktype) {
        ifeTswyenitijibrptuktype = pIfeTswyenitijibrptuktype;
    }

    @Column(order = 623, label = "wyenitijibrp")
    private String ifeTswyenitijibrp;

    public String getIfeTswyenitijibrp() {
        return ifeTswyenitijibrp;
    }

    public void setIfeTswyenitijibrp(String pIfeTswyenitijibrp) {
        ifeTswyenitijibrp = pIfeTswyenitijibrp;
    }

    @Column(order = 624, label = "wyenitijibrp$")
    private String ifeTswyenitijibrpt;

    public String getIfeTswyenitijibrpt() {
        return ifeTswyenitijibrpt;
    }

    public void setIfeTswyenitijibrpt(String pIfeTswyenitijibrpt) {
        ifeTswyenitijibrpt = pIfeTswyenitijibrpt;
    }

    @Column(order = 625, label = "koujyosyoumeimsgcd1")
    private String ifeTskoujyosyoumeimsgcd1;

    public String getIfeTskoujyosyoumeimsgcd1() {
        return ifeTskoujyosyoumeimsgcd1;
    }

    public void setIfeTskoujyosyoumeimsgcd1(String pIfeTskoujyosyoumeimsgcd1) {
        ifeTskoujyosyoumeimsgcd1 = pIfeTskoujyosyoumeimsgcd1;
    }

    @Column(order = 626, label = "koujyosyoumeimsgcd2")
    private String ifeTskoujyosyoumeimsgcd2;

    public String getIfeTskoujyosyoumeimsgcd2() {
        return ifeTskoujyosyoumeimsgcd2;
    }

    public void setIfeTskoujyosyoumeimsgcd2(String pIfeTskoujyosyoumeimsgcd2) {
        ifeTskoujyosyoumeimsgcd2 = pIfeTskoujyosyoumeimsgcd2;
    }

    @Column(order = 627, label = "koujyosyoumeimsgcd3")
    private String ifeTskoujyosyoumeimsgcd3;

    public String getIfeTskoujyosyoumeimsgcd3() {
        return ifeTskoujyosyoumeimsgcd3;
    }

    public void setIfeTskoujyosyoumeimsgcd3(String pIfeTskoujyosyoumeimsgcd3) {
        ifeTskoujyosyoumeimsgcd3 = pIfeTskoujyosyoumeimsgcd3;
    }

    @Column(order = 628, label = "koujyosyoumeihskmsgcd")
    private String ifeTskoujyosyoumeihskmsgcd;

    public String getIfeTskoujyosyoumeihskmsgcd() {
        return ifeTskoujyosyoumeihskmsgcd;
    }

    public void setIfeTskoujyosyoumeihskmsgcd(String pIfeTskoujyosyoumeihskmsgcd) {
        ifeTskoujyosyoumeihskmsgcd = pIfeTskoujyosyoumeihskmsgcd;
    }

    @Column(order = 629, label = "nenkoujyosyoumeihskmsgcd")
    private String ifeTsnenkoujyosyoumhskmsgcd;

    public String getIfeTsnenkoujyosyoumhskmsgcd() {
        return ifeTsnenkoujyosyoumhskmsgcd;
    }

    public void setIfeTsnenkoujyosyoumhskmsgcd(String pIfeTsnenkoujyosyoumhskmsgcd) {
        ifeTsnenkoujyosyoumhskmsgcd = pIfeTsnenkoujyosyoumhskmsgcd;
    }

    @Column(order = 630, label = "tokusyusyorinaiyoukbn1")
    private String ifeTstokusyusyorinaiyoukbn1;

    public String getIfeTstokusyusyorinaiyoukbn1() {
        return ifeTstokusyusyorinaiyoukbn1;
    }

    public void setIfeTstokusyusyorinaiyoukbn1(String pIfeTstokusyusyorinaiyoukbn1) {
        ifeTstokusyusyorinaiyoukbn1 = pIfeTstokusyusyorinaiyoukbn1;
    }

    @Column(order = 631, label = "tokusyusyorinaiyoukbn2")
    private String ifeTstokusyusyorinaiyoukbn2;

    public String getIfeTstokusyusyorinaiyoukbn2() {
        return ifeTstokusyusyorinaiyoukbn2;
    }

    public void setIfeTstokusyusyorinaiyoukbn2(String pIfeTstokusyusyorinaiyoukbn2) {
        ifeTstokusyusyorinaiyoukbn2 = pIfeTstokusyusyorinaiyoukbn2;
    }

    @Column(order = 632, label = "tokusyusyorinaiyoukbn3")
    private String ifeTstokusyusyorinaiyoukbn3;

    public String getIfeTstokusyusyorinaiyoukbn3() {
        return ifeTstokusyusyorinaiyoukbn3;
    }

    public void setIfeTstokusyusyorinaiyoukbn3(String pIfeTstokusyusyorinaiyoukbn3) {
        ifeTstokusyusyorinaiyoukbn3 = pIfeTstokusyusyorinaiyoukbn3;
    }

    @Column(order = 633, label = "tokusyusyorinaiyoukbn4")
    private String ifeTstokusyusyorinaiyoukbn4;

    public String getIfeTstokusyusyorinaiyoukbn4() {
        return ifeTstokusyusyorinaiyoukbn4;
    }

    public void setIfeTstokusyusyorinaiyoukbn4(String pIfeTstokusyusyorinaiyoukbn4) {
        ifeTstokusyusyorinaiyoukbn4 = pIfeTstokusyusyorinaiyoukbn4;
    }

    @Column(order = 634, label = "tokusyusyorinaiyoukbn5")
    private String ifeTstokusyusyorinaiyoukbn5;

    public String getIfeTstokusyusyorinaiyoukbn5() {
        return ifeTstokusyusyorinaiyoukbn5;
    }

    public void setIfeTstokusyusyorinaiyoukbn5(String pIfeTstokusyusyorinaiyoukbn5) {
        ifeTstokusyusyorinaiyoukbn5 = pIfeTstokusyusyorinaiyoukbn5;
    }

    @Column(order = 635, label = "tokusyusyorinaiyoukbn6")
    private String ifeTstokusyusyorinaiyoukbn6;

    public String getIfeTstokusyusyorinaiyoukbn6() {
        return ifeTstokusyusyorinaiyoukbn6;
    }

    public void setIfeTstokusyusyorinaiyoukbn6(String pIfeTstokusyusyorinaiyoukbn6) {
        ifeTstokusyusyorinaiyoukbn6 = pIfeTstokusyusyorinaiyoukbn6;
    }

    @Column(order = 636, label = "tokusyusyorinaiyoukbn7")
    private String ifeTstokusyusyorinaiyoukbn7;

    public String getIfeTstokusyusyorinaiyoukbn7() {
        return ifeTstokusyusyorinaiyoukbn7;
    }

    public void setIfeTstokusyusyorinaiyoukbn7(String pIfeTstokusyusyorinaiyoukbn7) {
        ifeTstokusyusyorinaiyoukbn7 = pIfeTstokusyusyorinaiyoukbn7;
    }

    @Column(order = 637, label = "tokusyusyorinaiyoukbn8")
    private String ifeTstokusyusyorinaiyoukbn8;

    public String getIfeTstokusyusyorinaiyoukbn8() {
        return ifeTstokusyusyorinaiyoukbn8;
    }

    public void setIfeTstokusyusyorinaiyoukbn8(String pIfeTstokusyusyorinaiyoukbn8) {
        ifeTstokusyusyorinaiyoukbn8 = pIfeTstokusyusyorinaiyoukbn8;
    }

    @Column(order = 638, label = "tokusyusyorinaiyoukbn9")
    private String ifeTstokusyusyorinaiyoukbn9;

    public String getIfeTstokusyusyorinaiyoukbn9() {
        return ifeTstokusyusyorinaiyoukbn9;
    }

    public void setIfeTstokusyusyorinaiyoukbn9(String pIfeTstokusyusyorinaiyoukbn9) {
        ifeTstokusyusyorinaiyoukbn9 = pIfeTstokusyusyorinaiyoukbn9;
    }

    @Column(order = 639, label = "tokusyusyorinaiyoukbn10")
    private String ifeTstokusyusyorinaiyokbn10;

    public String getIfeTstokusyusyorinaiyokbn10() {
        return ifeTstokusyusyorinaiyokbn10;
    }

    public void setIfeTstokusyusyorinaiyokbn10(String pIfeTstokusyusyorinaiyokbn10) {
        ifeTstokusyusyorinaiyokbn10 = pIfeTstokusyusyorinaiyokbn10;
    }

    @Column(order = 640, label = "tokusyusyorinaiyoukbn11")
    private String ifeTstokusyusyorinaiyokbn11;

    public String getIfeTstokusyusyorinaiyokbn11() {
        return ifeTstokusyusyorinaiyokbn11;
    }

    public void setIfeTstokusyusyorinaiyokbn11(String pIfeTstokusyusyorinaiyokbn11) {
        ifeTstokusyusyorinaiyokbn11 = pIfeTstokusyusyorinaiyokbn11;
    }

    @Column(order = 641, label = "tokusyusyorinaiyoukbn12")
    private String ifeTstokusyusyorinaiyokbn12;

    public String getIfeTstokusyusyorinaiyokbn12() {
        return ifeTstokusyusyorinaiyokbn12;
    }

    public void setIfeTstokusyusyorinaiyokbn12(String pIfeTstokusyusyorinaiyokbn12) {
        ifeTstokusyusyorinaiyokbn12 = pIfeTstokusyusyorinaiyokbn12;
    }

    @Column(order = 642, label = "tokusyusyorinaiyoukbn13")
    private String ifeTstokusyusyorinaiyokbn13;

    public String getIfeTstokusyusyorinaiyokbn13() {
        return ifeTstokusyusyorinaiyokbn13;
    }

    public void setIfeTstokusyusyorinaiyokbn13(String pIfeTstokusyusyorinaiyokbn13) {
        ifeTstokusyusyorinaiyokbn13 = pIfeTstokusyusyorinaiyokbn13;
    }

    @Column(order = 643, label = "tokusyusyorinaiyoukbn14")
    private String ifeTstokusyusyorinaiyokbn14;

    public String getIfeTstokusyusyorinaiyokbn14() {
        return ifeTstokusyusyorinaiyokbn14;
    }

    public void setIfeTstokusyusyorinaiyokbn14(String pIfeTstokusyusyorinaiyokbn14) {
        ifeTstokusyusyorinaiyokbn14 = pIfeTstokusyusyorinaiyokbn14;
    }

    @Column(order = 644, label = "tokusyusyorinaiyoukbn15")
    private String ifeTstokusyusyorinaiyokbn15;

    public String getIfeTstokusyusyorinaiyokbn15() {
        return ifeTstokusyusyorinaiyokbn15;
    }

    public void setIfeTstokusyusyorinaiyokbn15(String pIfeTstokusyusyorinaiyokbn15) {
        ifeTstokusyusyorinaiyokbn15 = pIfeTstokusyusyorinaiyokbn15;
    }

    @Column(order = 645, label = "tokusyusyorinaiyoukbn16")
    private String ifeTstokusyusyorinaiyokbn16;

    public String getIfeTstokusyusyorinaiyokbn16() {
        return ifeTstokusyusyorinaiyokbn16;
    }

    public void setIfeTstokusyusyorinaiyokbn16(String pIfeTstokusyusyorinaiyokbn16) {
        ifeTstokusyusyorinaiyokbn16 = pIfeTstokusyusyorinaiyokbn16;
    }

    @Column(order = 646, label = "tokusyusyorinaiyoukbn17")
    private String ifeTstokusyusyorinaiyokbn17;

    public String getIfeTstokusyusyorinaiyokbn17() {
        return ifeTstokusyusyorinaiyokbn17;
    }

    public void setIfeTstokusyusyorinaiyokbn17(String pIfeTstokusyusyorinaiyokbn17) {
        ifeTstokusyusyorinaiyokbn17 = pIfeTstokusyusyorinaiyokbn17;
    }

    @Column(order = 647, label = "gyoumuKousinKinou")
    private String ifeTsgyoumukousinkinou;

    public String getIfeTsgyoumukousinkinou() {
        return ifeTsgyoumukousinkinou;
    }

    public void setIfeTsgyoumukousinkinou(String pIfeTsgyoumukousinkinou) {
        ifeTsgyoumukousinkinou = pIfeTsgyoumukousinkinou;
    }

    @Column(order = 648, label = "gyoumuKousinsyaId")
    private String ifeTsgyoumukousinsyaid;

    public String getIfeTsgyoumukousinsyaid() {
        return ifeTsgyoumukousinsyaid;
    }

    public void setIfeTsgyoumukousinsyaid(String pIfeTsgyoumukousinsyaid) {
        ifeTsgyoumukousinsyaid = pIfeTsgyoumukousinsyaid;
    }

    @Column(order = 649, label = "gyoumuKousinTime")
    private String ifeTsgyoumukousintime;

    public String getIfeTsgyoumukousintime() {
        return ifeTsgyoumukousintime;
    }

    public void setIfeTsgyoumukousintime(String pIfeTsgyoumukousintime) {
        ifeTsgyoumukousintime = pIfeTsgyoumukousintime;
    }

    @Column(order = 650, label = "kousinsyaId")
    private String ifeTskousinsyaid;

    public String getIfeTskousinsyaid() {
        return ifeTskousinsyaid;
    }

    public void setIfeTskousinsyaid(String pIfeTskousinsyaid) {
        ifeTskousinsyaid = pIfeTskousinsyaid;
    }

    @Column(order = 651, label = "kousinTime")
    private String ifeTskousintime;

    public String getIfeTskousintime() {
        return ifeTskousintime;
    }

    public void setIfeTskousintime(String pIfeTskousintime) {
        ifeTskousintime = pIfeTskousintime;
    }

    @Column(order = 652, label = "kousinKinou")
    private String ifeTskousinkinou;

    public String getIfeTskousinkinou() {
        return ifeTskousinkinou;
    }

    public void setIfeTskousinkinou(String pIfeTskousinkinou) {
        ifeTskousinkinou = pIfeTskousinkinou;
    }

    @Column(order = 653, label = "version")
    private String ifeTsversion;

    public String getIfeTsversion() {
        return ifeTsversion;
    }

    public void setIfeTsversion(String pIfeTsversion) {
        ifeTsversion = pIfeTsversion;
    }

    @Column(order = 654, label = "kyknmkn")
    private String ifeTskyknmkn;

    public String getIfeTskyknmkn() {
        return ifeTskyknmkn;
    }

    public void setIfeTskyknmkn(String pIfeTskyknmkn) {
        ifeTskyknmkn = pIfeTskyknmkn;
    }

    @Column(order = 655, label = "hhknnmkn")
    private String ifeTshhknnmkn;

    public String getIfeTshhknnmkn() {
        return ifeTshhknnmkn;
    }

    public void setIfeTshhknnmkn(String pIfeTshhknnmkn) {
        ifeTshhknnmkn = pIfeTshhknnmkn;
    }

    @Column(order = 656, label = "sonotanyrannkshrstartymd")
    private String ifeTssntnyrnnkshrstartymd;

    public String getIfeTssntnyrnnkshrstartymd() {
        return ifeTssntnyrnnkshrstartymd;
    }

    public void setIfeTssntnyrnnkshrstartymd(String pIfeTssntnyrnnkshrstartymd) {
        ifeTssntnyrnnkshrstartymd = pIfeTssntnyrnnkshrstartymd;
    }

    @Column(order = 657, label = "sonotanyrannenkinkkn")
    private String ifeTssonotanyrannenkinkkn;

    public String getIfeTssonotanyrannenkinkkn() {
        return ifeTssonotanyrannenkinkkn;
    }

    public void setIfeTssonotanyrannenkinkkn(String pIfeTssonotanyrannenkinkkn) {
        ifeTssonotanyrannenkinkkn = pIfeTssonotanyrannenkinkkn;
    }

    @Column(order = 658, label = "sonotanyranyensysnhkhnkymd")
    private String ifeTssntnyrnyensysnhkhnkymd;

    public String getIfeTssntnyrnyensysnhkhnkymd() {
        return ifeTssntnyrnyensysnhkhnkymd;
    }

    public void setIfeTssntnyrnyensysnhkhnkymd(String pIfeTssntnyrnyensysnhkhnkymd) {
        ifeTssntnyrnyensysnhkhnkymd = pIfeTssntnyrnyensysnhkhnkymd;
    }

    @Column(order = 659, label = "sonotanyrantumitateriritu")
    private String ifeTssntnyrntumitateriritu;

    public String getIfeTssntnyrntumitateriritu() {
        return ifeTssntnyrntumitateriritu;
    }

    public void setIfeTssntnyrntumitateriritu(String pIfeTssntnyrntumitateriritu) {
        ifeTssntnyrntumitateriritu = pIfeTssntnyrntumitateriritu;
    }

    @Column(order = 660, label = "sonotanyrantmttknzkrtjygn")
    private String ifeTssntnyrntmttknzkrtjygn;

    public String getIfeTssntnyrntmttknzkrtjygn() {
        return ifeTssntnyrntmttknzkrtjygn;
    }

    public void setIfeTssntnyrntmttknzkrtjygn(String pIfeTssntnyrntmttknzkrtjygn) {
        ifeTssntnyrntmttknzkrtjygn = pIfeTssntnyrntmttknzkrtjygn;
    }

    @Column(order = 661, label = "sonotanyransetteibairitu")
    private String ifeTssntnyrnsetteibairitu;

    public String getIfeTssntnyrnsetteibairitu() {
        return ifeTssntnyrnsetteibairitu;
    }

    public void setIfeTssntnyrnsetteibairitu(String pIfeTssntnyrnsetteibairitu) {
        ifeTssntnyrnsetteibairitu = pIfeTssntnyrnsetteibairitu;
    }

    @Column(order = 662, label = "sonotanyrantmttkngktuktype")
    private String ifeTssntnyrntmttkngktuktype;

    public String getIfeTssntnyrntmttkngktuktype() {
        return ifeTssntnyrntmttkngktuktype;
    }

    public void setIfeTssntnyrntmttkngktuktype(String pIfeTssntnyrntmttkngktuktype) {
        ifeTssntnyrntmttkngktuktype = pIfeTssntnyrntmttkngktuktype;
    }

    @Column(order = 663, label = "sonotanyranteiritutmttkngk")
    private String ifeTssntnyrnteirittmttkngk;

    public String getIfeTssntnyrnteirittmttkngk() {
        return ifeTssntnyrnteirittmttkngk;
    }

    public void setIfeTssntnyrnteirittmttkngk(String pIfeTssntnyrnteirittmttkngk) {
        ifeTssntnyrnteirittmttkngk = pIfeTssntnyrnteirittmttkngk;
    }

    @Column(order = 664, label = "sonotanyranteiritutmttkngk$")
    private String ifeTssntnyrnteirittmttkngkt;

    public String getIfeTssntnyrnteirittmttkngkt() {
        return ifeTssntnyrnteirittmttkngkt;
    }

    public void setIfeTssntnyrnteirittmttkngkt(String pIfeTssntnyrnteirittmttkngkt) {
        ifeTssntnyrnteirittmttkngkt = pIfeTssntnyrnteirittmttkngkt;
    }

    @Column(order = 665, label = "sonotanyransisuutmttkngk")
    private String ifeTssntnyrnsisuutmttkngk;

    public String getIfeTssntnyrnsisuutmttkngk() {
        return ifeTssntnyrnsisuutmttkngk;
    }

    public void setIfeTssntnyrnsisuutmttkngk(String pIfeTssntnyrnsisuutmttkngk) {
        ifeTssntnyrnsisuutmttkngk = pIfeTssntnyrnsisuutmttkngk;
    }

    @Column(order = 666, label = "sonotanyransisuutmttkngk$")
    private String ifeTssntnyrnsisuutmttkngkt;

    public String getIfeTssntnyrnsisuutmttkngkt() {
        return ifeTssntnyrnsisuutmttkngkt;
    }

    public void setIfeTssntnyrnsisuutmttkngkt(String pIfeTssntnyrnsisuutmttkngkt) {
        ifeTssntnyrnsisuutmttkngkt = pIfeTssntnyrnsisuutmttkngkt;
    }

    @Column(order = 667, label = "sonotanyransisuunm")
    private String ifeTssonotanyransisuunm;

    public String getIfeTssonotanyransisuunm() {
        return ifeTssonotanyransisuunm;
    }

    public void setIfeTssonotanyransisuunm(String pIfeTssonotanyransisuunm) {
        ifeTssonotanyransisuunm = pIfeTssonotanyransisuunm;
    }

    @Column(order = 668, label = "kgmaehrtkdai1hknkknmnryymd")
    private String ifeTskgmhrtkd1hknkknmnryymd;

    public String getIfeTskgmhrtkd1hknkknmnryymd() {
        return ifeTskgmhrtkd1hknkknmnryymd;
    }

    public void setIfeTskgmhrtkd1hknkknmnryymd(String pIfeTskgmhrtkd1hknkknmnryymd) {
        ifeTskgmhrtkd1hknkknmnryymd = pIfeTskgmhrtkd1hknkknmnryymd;
    }

    @Column(order = 669, label = "nkmsgcd1")
    private String ifeTsnkmsgcd1;

    public String getIfeTsnkmsgcd1() {
        return ifeTsnkmsgcd1;
    }

    public void setIfeTsnkmsgcd1(String pIfeTsnkmsgcd1) {
        ifeTsnkmsgcd1 = pIfeTsnkmsgcd1;
    }

    @Column(order = 670, label = "nkmsgcd2")
    private String ifeTsnkmsgcd2;

    public String getIfeTsnkmsgcd2() {
        return ifeTsnkmsgcd2;
    }

    public void setIfeTsnkmsgcd2(String pIfeTsnkmsgcd2) {
        ifeTsnkmsgcd2 = pIfeTsnkmsgcd2;
    }

    @Column(order = 671, label = "nkmsgcd3")
    private String ifeTsnkmsgcd3;

    public String getIfeTsnkmsgcd3() {
        return ifeTsnkmsgcd3;
    }

    public void setIfeTsnkmsgcd3(String pIfeTsnkmsgcd3) {
        ifeTsnkmsgcd3 = pIfeTsnkmsgcd3;
    }

    @Column(order = 672, label = "nkmsgcd4")
    private String ifeTsnkmsgcd4;

    public String getIfeTsnkmsgcd4() {
        return ifeTsnkmsgcd4;
    }

    public void setIfeTsnkmsgcd4(String pIfeTsnkmsgcd4) {
        ifeTsnkmsgcd4 = pIfeTsnkmsgcd4;
    }

    @Column(order = 673, label = "nkmsgcd5")
    private String ifeTsnkmsgcd5;

    public String getIfeTsnkmsgcd5() {
        return ifeTsnkmsgcd5;
    }

    public void setIfeTsnkmsgcd5(String pIfeTsnkmsgcd5) {
        ifeTsnkmsgcd5 = pIfeTsnkmsgcd5;
    }

    @Column(order = 674, label = "nkmsgcd6")
    private String ifeTsnkmsgcd6;

    public String getIfeTsnkmsgcd6() {
        return ifeTsnkmsgcd6;
    }

    public void setIfeTsnkmsgcd6(String pIfeTsnkmsgcd6) {
        ifeTsnkmsgcd6 = pIfeTsnkmsgcd6;
    }

    @Column(order = 675, label = "nkmsgcd7")
    private String ifeTsnkmsgcd7;

    public String getIfeTsnkmsgcd7() {
        return ifeTsnkmsgcd7;
    }

    public void setIfeTsnkmsgcd7(String pIfeTsnkmsgcd7) {
        ifeTsnkmsgcd7 = pIfeTsnkmsgcd7;
    }

    @Column(order = 676, label = "nkmsgcd8")
    private String ifeTsnkmsgcd8;

    public String getIfeTsnkmsgcd8() {
        return ifeTsnkmsgcd8;
    }

    public void setIfeTsnkmsgcd8(String pIfeTsnkmsgcd8) {
        ifeTsnkmsgcd8 = pIfeTsnkmsgcd8;
    }

    @Column(order = 677, label = "nkmsgcd9")
    private String ifeTsnkmsgcd9;

    public String getIfeTsnkmsgcd9() {
        return ifeTsnkmsgcd9;
    }

    public void setIfeTsnkmsgcd9(String pIfeTsnkmsgcd9) {
        ifeTsnkmsgcd9 = pIfeTsnkmsgcd9;
    }

    @Column(order = 678, label = "nkmsgcd10")
    private String ifeTsnkmsgcd10;

    public String getIfeTsnkmsgcd10() {
        return ifeTsnkmsgcd10;
    }

    public void setIfeTsnkmsgcd10(String pIfeTsnkmsgcd10) {
        ifeTsnkmsgcd10 = pIfeTsnkmsgcd10;
    }

    @Column(order = 679, label = "siboukyuuhukinmsgcd1")
    private String ifeTssiboukyuuhukinmsgcd1;

    public String getIfeTssiboukyuuhukinmsgcd1() {
        return ifeTssiboukyuuhukinmsgcd1;
    }

    public void setIfeTssiboukyuuhukinmsgcd1(String pIfeTssiboukyuuhukinmsgcd1) {
        ifeTssiboukyuuhukinmsgcd1 = pIfeTssiboukyuuhukinmsgcd1;
    }

    @Column(order = 680, label = "siboukyuuhukinmsgcd2")
    private String ifeTssiboukyuuhukinmsgcd2;

    public String getIfeTssiboukyuuhukinmsgcd2() {
        return ifeTssiboukyuuhukinmsgcd2;
    }

    public void setIfeTssiboukyuuhukinmsgcd2(String pIfeTssiboukyuuhukinmsgcd2) {
        ifeTssiboukyuuhukinmsgcd2 = pIfeTssiboukyuuhukinmsgcd2;
    }

    @Column(order = 681, label = "siboukyuuhukinmsgcd3")
    private String ifeTssiboukyuuhukinmsgcd3;

    public String getIfeTssiboukyuuhukinmsgcd3() {
        return ifeTssiboukyuuhukinmsgcd3;
    }

    public void setIfeTssiboukyuuhukinmsgcd3(String pIfeTssiboukyuuhukinmsgcd3) {
        ifeTssiboukyuuhukinmsgcd3 = pIfeTssiboukyuuhukinmsgcd3;
    }

    @Column(order = 682, label = "siboukyuuhukinmsgcd4")
    private String ifeTssiboukyuuhukinmsgcd4;

    public String getIfeTssiboukyuuhukinmsgcd4() {
        return ifeTssiboukyuuhukinmsgcd4;
    }

    public void setIfeTssiboukyuuhukinmsgcd4(String pIfeTssiboukyuuhukinmsgcd4) {
        ifeTssiboukyuuhukinmsgcd4 = pIfeTssiboukyuuhukinmsgcd4;
    }

    @Column(order = 683, label = "siboukyuuhukinmsgcd5")
    private String ifeTssiboukyuuhukinmsgcd5;

    public String getIfeTssiboukyuuhukinmsgcd5() {
        return ifeTssiboukyuuhukinmsgcd5;
    }

    public void setIfeTssiboukyuuhukinmsgcd5(String pIfeTssiboukyuuhukinmsgcd5) {
        ifeTssiboukyuuhukinmsgcd5 = pIfeTssiboukyuuhukinmsgcd5;
    }

    @Column(order = 684, label = "siboukyuuhukinmsgcd6")
    private String ifeTssiboukyuuhukinmsgcd6;

    public String getIfeTssiboukyuuhukinmsgcd6() {
        return ifeTssiboukyuuhukinmsgcd6;
    }

    public void setIfeTssiboukyuuhukinmsgcd6(String pIfeTssiboukyuuhukinmsgcd6) {
        ifeTssiboukyuuhukinmsgcd6 = pIfeTssiboukyuuhukinmsgcd6;
    }

    @Column(order = 685, label = "siboukyuuhukinmsgcd7")
    private String ifeTssiboukyuuhukinmsgcd7;

    public String getIfeTssiboukyuuhukinmsgcd7() {
        return ifeTssiboukyuuhukinmsgcd7;
    }

    public void setIfeTssiboukyuuhukinmsgcd7(String pIfeTssiboukyuuhukinmsgcd7) {
        ifeTssiboukyuuhukinmsgcd7 = pIfeTssiboukyuuhukinmsgcd7;
    }

    @Column(order = 686, label = "siboukyuuhukinmsgcd8")
    private String ifeTssiboukyuuhukinmsgcd8;

    public String getIfeTssiboukyuuhukinmsgcd8() {
        return ifeTssiboukyuuhukinmsgcd8;
    }

    public void setIfeTssiboukyuuhukinmsgcd8(String pIfeTssiboukyuuhukinmsgcd8) {
        ifeTssiboukyuuhukinmsgcd8 = pIfeTssiboukyuuhukinmsgcd8;
    }

    @Column(order = 687, label = "siboukyuuhukinmsgcd9")
    private String ifeTssiboukyuuhukinmsgcd9;

    public String getIfeTssiboukyuuhukinmsgcd9() {
        return ifeTssiboukyuuhukinmsgcd9;
    }

    public void setIfeTssiboukyuuhukinmsgcd9(String pIfeTssiboukyuuhukinmsgcd9) {
        ifeTssiboukyuuhukinmsgcd9 = pIfeTssiboukyuuhukinmsgcd9;
    }

    @Column(order = 688, label = "siboukyuuhukinmsgcd10")
    private String ifeTssiboukyuuhukinmsgcd10;

    public String getIfeTssiboukyuuhukinmsgcd10() {
        return ifeTssiboukyuuhukinmsgcd10;
    }

    public void setIfeTssiboukyuuhukinmsgcd10(String pIfeTssiboukyuuhukinmsgcd10) {
        ifeTssiboukyuuhukinmsgcd10 = pIfeTssiboukyuuhukinmsgcd10;
    }

    @Column(order = 689, label = "nkshrstartzenymd")
    private String ifeTsnkshrstartzenymd;

    public String getIfeTsnkshrstartzenymd() {
        return ifeTsnkshrstartzenymd;
    }

    public void setIfeTsnkshrstartzenymd(String pIfeTsnkshrstartzenymd) {
        ifeTsnkshrstartzenymd = pIfeTsnkshrstartzenymd;
    }

    @Column(order = 690, label = "mkhyouyennkhknhentktype")
    private String ifeTsmkhyyennkhknhntktype;

    public String getIfeTsmkhyyennkhknhntktype() {
        return ifeTsmkhyyennkhknhntktype;
    }

    public void setIfeTsmkhyyennkhknhntktype(String pIfeTsmkhyyennkhknhntktype) {
        ifeTsmkhyyennkhknhntktype = pIfeTsmkhyyennkhknhntktype;
    }

    @Column(order = 691, label = "mkhyouyennkhknhentkmkhgk")
    private String ifeTsmkhyyennkhknhntkmkhgk;

    public String getIfeTsmkhyyennkhknhntkmkhgk() {
        return ifeTsmkhyyennkhknhntkmkhgk;
    }

    public void setIfeTsmkhyyennkhknhntkmkhgk(String pIfeTsmkhyyennkhknhntkmkhgk) {
        ifeTsmkhyyennkhknhntkmkhgk = pIfeTsmkhyyennkhknhntkmkhgk;
    }

    @Column(order = 692, label = "mkhyouyennkhknhentkmkhgk$")
    private String ifeTsmkhyyennkhknhntkmkhgkt;

    public String getIfeTsmkhyyennkhknhntkmkhgkt() {
        return ifeTsmkhyyennkhknhntkmkhgkt;
    }

    public void setIfeTsmkhyyennkhknhntkmkhgkt(String pIfeTsmkhyyennkhknhntkmkhgkt) {
        ifeTsmkhyyennkhknhntkmkhgkt = pIfeTsmkhyyennkhknhntkmkhgkt;
    }

    @Column(order = 693, label = "mkhyouyennkhknhentkmkhwari")
    private String ifeTsmkhyyennkhknhntkmkhwar;

    public String getIfeTsmkhyyennkhknhntkmkhwar() {
        return ifeTsmkhyyennkhknhntkmkhwar;
    }

    public void setIfeTsmkhyyennkhknhntkmkhwar(String pIfeTsmkhyyennkhknhntkmkhwar) {
        ifeTsmkhyyennkhknhntkmkhwar = pIfeTsmkhyyennkhknhntkmkhwar;
    }

    @Column(order = 694, label = "haibunwarimsgcd1")
    private String ifeTshaibunwarimsgcd1;

    public String getIfeTshaibunwarimsgcd1() {
        return ifeTshaibunwarimsgcd1;
    }

    public void setIfeTshaibunwarimsgcd1(String pIfeTshaibunwarimsgcd1) {
        ifeTshaibunwarimsgcd1 = pIfeTshaibunwarimsgcd1;
    }

    @Column(order = 695, label = "haibunwarimsgcd2")
    private String ifeTshaibunwarimsgcd2;

    public String getIfeTshaibunwarimsgcd2() {
        return ifeTshaibunwarimsgcd2;
    }

    public void setIfeTshaibunwarimsgcd2(String pIfeTshaibunwarimsgcd2) {
        ifeTshaibunwarimsgcd2 = pIfeTshaibunwarimsgcd2;
    }

    @Column(order = 696, label = "haibunwarimsgcd3")
    private String ifeTshaibunwarimsgcd3;

    public String getIfeTshaibunwarimsgcd3() {
        return ifeTshaibunwarimsgcd3;
    }

    public void setIfeTshaibunwarimsgcd3(String pIfeTshaibunwarimsgcd3) {
        ifeTshaibunwarimsgcd3 = pIfeTshaibunwarimsgcd3;
    }

    @Column(order = 697, label = "teiritutmtthbnwr")
    private String ifeTsteiritutmtthbnwr;

    public String getIfeTsteiritutmtthbnwr() {
        return ifeTsteiritutmtthbnwr;
    }

    public void setIfeTsteiritutmtthbnwr(String pIfeTsteiritutmtthbnwr) {
        ifeTsteiritutmtthbnwr = pIfeTsteiritutmtthbnwr;
    }

    @Column(order = 698, label = "sisuutmtthbnwr")
    private String ifeTssisuutmtthbnwr;

    public String getIfeTssisuutmtthbnwr() {
        return ifeTssisuutmtthbnwr;
    }

    public void setIfeTssisuutmtthbnwr(String pIfeTssisuutmtthbnwr) {
        ifeTssisuutmtthbnwr = pIfeTssisuutmtthbnwr;
    }

    @Column(order = 699, label = "sisuuannaimsg1")
    private String ifeTssisuuannaimsg1;

    public String getIfeTssisuuannaimsg1() {
        return ifeTssisuuannaimsg1;
    }

    public void setIfeTssisuuannaimsg1(String pIfeTssisuuannaimsg1) {
        ifeTssisuuannaimsg1 = pIfeTssisuuannaimsg1;
    }

    @Column(order = 700, label = "sisuuannaimsg2")
    private String ifeTssisuuannaimsg2;

    public String getIfeTssisuuannaimsg2() {
        return ifeTssisuuannaimsg2;
    }

    public void setIfeTssisuuannaimsg2(String pIfeTssisuuannaimsg2) {
        ifeTssisuuannaimsg2 = pIfeTssisuuannaimsg2;
    }

    @Column(order = 701, label = "sisuuannaimsg3")
    private String ifeTssisuuannaimsg3;

    public String getIfeTssisuuannaimsg3() {
        return ifeTssisuuannaimsg3;
    }

    public void setIfeTssisuuannaimsg3(String pIfeTssisuuannaimsg3) {
        ifeTssisuuannaimsg3 = pIfeTssisuuannaimsg3;
    }

    @Column(order = 702, label = "hutanhiyustmytijihiritu")
    private String ifeTshutanhiystmytijihiritu;

    public String getIfeTshutanhiystmytijihiritu() {
        return ifeTshutanhiystmytijihiritu;
    }

    public void setIfeTshutanhiystmytijihiritu(String pIfeTshutanhiystmytijihiritu) {
        ifeTshutanhiystmytijihiritu = pIfeTshutanhiystmytijihiritu;
    }

    @Column(order = 703, label = "wmsgcd21")
    private String ifeTswmsgcd21;

    public String getIfeTswmsgcd21() {
        return ifeTswmsgcd21;
    }

    public void setIfeTswmsgcd21(String pIfeTswmsgcd21) {
        ifeTswmsgcd21 = pIfeTswmsgcd21;
    }

    @Column(order = 704, label = "wmsgcd22")
    private String ifeTswmsgcd22;

    public String getIfeTswmsgcd22() {
        return ifeTswmsgcd22;
    }

    public void setIfeTswmsgcd22(String pIfeTswmsgcd22) {
        ifeTswmsgcd22 = pIfeTswmsgcd22;
    }

    @Column(order = 705, label = "wmsgcd23")
    private String ifeTswmsgcd23;

    public String getIfeTswmsgcd23() {
        return ifeTswmsgcd23;
    }

    public void setIfeTswmsgcd23(String pIfeTswmsgcd23) {
        ifeTswmsgcd23 = pIfeTswmsgcd23;
    }

    @Column(order = 706, label = "wmsgcd31")
    private String ifeTswmsgcd31;

    public String getIfeTswmsgcd31() {
        return ifeTswmsgcd31;
    }

    public void setIfeTswmsgcd31(String pIfeTswmsgcd31) {
        ifeTswmsgcd31 = pIfeTswmsgcd31;
    }

    @Column(order = 707, label = "wmsgcd32")
    private String ifeTswmsgcd32;

    public String getIfeTswmsgcd32() {
        return ifeTswmsgcd32;
    }

    public void setIfeTswmsgcd32(String pIfeTswmsgcd32) {
        ifeTswmsgcd32 = pIfeTswmsgcd32;
    }

    @Column(order = 708, label = "wmsgcd33")
    private String ifeTswmsgcd33;

    public String getIfeTswmsgcd33() {
        return ifeTswmsgcd33;
    }

    public void setIfeTswmsgcd33(String pIfeTswmsgcd33) {
        ifeTswmsgcd33 = pIfeTswmsgcd33;
    }

    @Column(order = 709, label = "wmsgcdst1")
    private String ifeTswmsgcdst1;

    public String getIfeTswmsgcdst1() {
        return ifeTswmsgcdst1;
    }

    public void setIfeTswmsgcdst1(String pIfeTswmsgcdst1) {
        ifeTswmsgcdst1 = pIfeTswmsgcdst1;
    }

    @Column(order = 710, label = "wtyuuijikoumsgcd6")
    private String ifeTswtyuuijikoumsgcd6;

    public String getIfeTswtyuuijikoumsgcd6() {
        return ifeTswtyuuijikoumsgcd6;
    }

    public void setIfeTswtyuuijikoumsgcd6(String pIfeTswtyuuijikoumsgcd6) {
        ifeTswtyuuijikoumsgcd6 = pIfeTswtyuuijikoumsgcd6;
    }

    @Column(order = 711, label = "wtyuuijikoumsgcd7")
    private String ifeTswtyuuijikoumsgcd7;

    public String getIfeTswtyuuijikoumsgcd7() {
        return ifeTswtyuuijikoumsgcd7;
    }

    public void setIfeTswtyuuijikoumsgcd7(String pIfeTswtyuuijikoumsgcd7) {
        ifeTswtyuuijikoumsgcd7 = pIfeTswtyuuijikoumsgcd7;
    }

    @Column(order = 712, label = "tantocd")
    private String ifeTstantocd;

    public String getIfeTstantocd() {
        return ifeTstantocd;
    }

    public void setIfeTstantocd(String pIfeTstantocd) {
        ifeTstantocd = pIfeTstantocd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
