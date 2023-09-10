package yuyu.def.siharai.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （支払）備金作業リストレイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSiBikinsagyouListLayoutFile implements Serializable {


    private static final long serialVersionUID = 1L;


    public GenSiBikinsagyouListLayoutFile() {
    }


    @Column(order = 1, label = "リスト名")
    private String ifcListnm;


    public String getIfcListnm() {
        return ifcListnm;
    }


    public void setIfcListnm(String pIfcListnm) {
        ifcListnm = pIfcListnm;
    }


    @Column(order = 2, label = "宛先")
    private String ifcAtesaki;


    public String getIfcAtesaki() {
        return ifcAtesaki;
    }


    public void setIfcAtesaki(String pIfcAtesaki) {
        ifcAtesaki = pIfcAtesaki;
    }


    @Column(order = 3, label = "作成年月日")
    private String ifcSakuseiymdseireki;


    public String getIfcSakuseiymdseireki() {
        return ifcSakuseiymdseireki;
    }


    public void setIfcSakuseiymdseireki(String pIfcSakuseiymdseireki) {
        ifcSakuseiymdseireki = pIfcSakuseiymdseireki;
    }


    @Column(order = 4, label = "頁番号")
    private String ifcPageno;


    public String getIfcPageno() {
        return ifcPageno;
    }


    public void setIfcPageno(String pIfcPageno) {
        ifcPageno = pIfcPageno;
    }


    @Column(order = 5, label = "決算年度")
    private String ifcKessannnd;


    public String getIfcKessannnd() {
        return ifcKessannnd;
    }


    public void setIfcKessannnd(String pIfcKessannnd) {
        ifcKessannnd = pIfcKessannnd;
    }


    @Column(order = 6, label = "備金コード")
    private String ifcBkncd;


    public String getIfcBkncd() {
        return ifcBkncd;
    }


    public void setIfcBkncd(String pIfcBkncd) {
        ifcBkncd = pIfcBkncd;
    }


    @Column(order = 7, label = "保険種類")
    private String ifcHknsyurui;


    public String getIfcHknsyurui() {
        return ifcHknsyurui;
    }


    public void setIfcHknsyurui(String pIfcHknsyurui) {
        ifcHknsyurui = pIfcHknsyurui;
    }


    @Column(order = 8, label = "備金確定年月日")
    private String ifcBknkktiymdseireki;


    public String getIfcBknkktiymdseireki() {
        return ifcBknkktiymdseireki;
    }


    public void setIfcBknkktiymdseireki(String pIfcBknkktiymdseireki) {
        ifcBknkktiymdseireki = pIfcBknkktiymdseireki;
    }


    @Column(order = 9, label = "計算基準年月日")
    private String ifcCalckijyunymd;


    public String getIfcCalckijyunymd() {
        return ifcCalckijyunymd;
    }


    public void setIfcCalckijyunymd(String pIfcCalckijyunymd) {
        ifcCalckijyunymd = pIfcCalckijyunymd;
    }


    @Column(order = 10, label = "支社コード")
    private String ifcSisyacd;


    public String getIfcSisyacd() {
        return ifcSisyacd;
    }


    public void setIfcSisyacd(String pIfcSisyacd) {
        ifcSisyacd = pIfcSisyacd;
    }


    @Column(order = 11, label = "記号")
    private String ifcKigou;


    public String getIfcKigou() {
        return ifcKigou;
    }


    public void setIfcKigou(String pIfcKigou) {
        ifcKigou = pIfcKigou;
    }


    @Column(order = 12, label = "証券番号")
    private String ifcSyono;


    public String getIfcSyono() {
        return ifcSyono;
    }


    public void setIfcSyono(String pIfcSyono) {
        ifcSyono = pIfcSyono;
    }


    @Column(order = 13, label = "備金額")
    private String ifcBkngk;


    public String getIfcBkngk() {
        return ifcBkngk;
    }


    public void setIfcBkngk(String pIfcBkngk) {
        ifcBkngk = pIfcBkngk;
    }


    @Column(order = 14, label = "基本（保障）Ｓ")
    private String ifcKihons;


    public String getIfcKihons() {
        return ifcKihons;
    }


    public void setIfcKihons(String pIfcKihons) {
        ifcKihons = pIfcKihons;
    }


    @Column(order = 15, label = "特約Ｓ")
    private String ifcTks;


    public String getIfcTks() {
        return ifcTks;
    }


    public void setIfcTks(String pIfcTks) {
        ifcTks = pIfcTks;
    }


    @Column(order = 16, label = "特約記号")
    private String ifcTkkigou;


    public String getIfcTkkigou() {
        return ifcTkkigou;
    }


    public void setIfcTkkigou(String pIfcTkkigou) {
        ifcTkkigou = pIfcTkkigou;
    }


    @Column(order = 17, label = "型区分")
    private String ifcKatakbn;


    public String getIfcKatakbn() {
        return ifcKatakbn;
    }


    public void setIfcKatakbn(String pIfcKatakbn) {
        ifcKatakbn = pIfcKatakbn;
    }


    @Column(order = 18, label = "妻子区分")
    private String ifcSaisikbn;


    public String getIfcSaisikbn() {
        return ifcSaisikbn;
    }


    public void setIfcSaisikbn(String pIfcSaisikbn) {
        ifcSaisikbn = pIfcSaisikbn;
    }


    @Column(order = 19, label = "同時備金１")
    private String ifcDoujibkn1;


    public String getIfcDoujibkn1() {
        return ifcDoujibkn1;
    }


    public void setIfcDoujibkn1(String pIfcDoujibkn1) {
        ifcDoujibkn1 = pIfcDoujibkn1;
    }


    @Column(order = 20, label = "同時備金２")
    private String ifcDoujibkn2;


    public String getIfcDoujibkn2() {
        return ifcDoujibkn2;
    }


    public void setIfcDoujibkn2(String pIfcDoujibkn2) {
        ifcDoujibkn2 = pIfcDoujibkn2;
    }


    @Column(order = 21, label = "同時備金３")
    private String ifcDoujibkn3;


    public String getIfcDoujibkn3() {
        return ifcDoujibkn3;
    }


    public void setIfcDoujibkn3(String pIfcDoujibkn3) {
        ifcDoujibkn3 = pIfcDoujibkn3;
    }


    @Column(order = 22, label = "同時備金４")
    private String ifcDoujibkn4;


    public String getIfcDoujibkn4() {
        return ifcDoujibkn4;
    }


    public void setIfcDoujibkn4(String pIfcDoujibkn4) {
        ifcDoujibkn4 = pIfcDoujibkn4;
    }


    @Column(order = 23, label = "遡及区分")
    private String ifcSokyuukbn;


    public String getIfcSokyuukbn() {
        return ifcSokyuukbn;
    }


    public void setIfcSokyuukbn(String pIfcSokyuukbn) {
        ifcSokyuukbn = pIfcSokyuukbn;
    }


    @Column(order = 24, label = "早期表示")
    private String ifcSoukihyj;


    public String getIfcSoukihyj() {
        return ifcSoukihyj;
    }


    public void setIfcSoukihyj(String pIfcSoukihyj) {
        ifcSoukihyj = pIfcSoukihyj;
    }


    @Column(order = 25, label = "エラーＭＳＧ")
    private String ifcErrormsg;


    public String getIfcErrormsg() {
        return ifcErrormsg;
    }


    public void setIfcErrormsg(String pIfcErrormsg) {
        ifcErrormsg = pIfcErrormsg;
    }


    @Column(order = 26, label = "削減表示")
    private String ifcSkgnhyj;


    public String getIfcSkgnhyj() {
        return ifcSkgnhyj;
    }


    public void setIfcSkgnhyj(String pIfcSkgnhyj) {
        ifcSkgnhyj = pIfcSkgnhyj;
    }


    @Column(order = 27, label = "年金表示")
    private String ifcNkhyj;


    public String getIfcNkhyj() {
        return ifcNkhyj;
    }


    public void setIfcNkhyj(String pIfcNkhyj) {
        ifcNkhyj = pIfcNkhyj;
    }


    @Column(order = 28, label = "転換表示")
    private String ifcTnknhyj;


    public String getIfcTnknhyj() {
        return ifcTnknhyj;
    }


    public void setIfcTnknhyj(String pIfcTnknhyj) {
        ifcTnknhyj = pIfcTnknhyj;
    }


    @Column(order = 29, label = "契約前表示")
    private String ifcKykmaehyj;


    public String getIfcKykmaehyj() {
        return ifcKykmaehyj;
    }


    public void setIfcKykmaehyj(String pIfcKykmaehyj) {
        ifcKykmaehyj = pIfcKykmaehyj;
    }


    @Column(order = 30, label = "再保険表示")
    private String ifcSihknhyj;


    public String getIfcSihknhyj() {
        return ifcSihknhyj;
    }


    public void setIfcSihknhyj(String pIfcSihknhyj) {
        ifcSihknhyj = pIfcSihknhyj;
    }


    @Column(order = 31, label = "Ｓ増調整表示")
    private String ifcSzoutysihyj;


    public String getIfcSzoutysihyj() {
        return ifcSzoutysihyj;
    }


    public void setIfcSzoutysihyj(String pIfcSzoutysihyj) {
        ifcSzoutysihyj = pIfcSzoutysihyj;
    }


    @Column(order = 32, label = "基本Ｓ通貨種類")
    private String ifcKihonstuukasyurui;


    public String getIfcKihonstuukasyurui() {
        return ifcKihonstuukasyurui;
    }


    public void setIfcKihonstuukasyurui(String pIfcKihonstuukasyurui) {
        ifcKihonstuukasyurui = pIfcKihonstuukasyurui;
    }


    @Column(order = 33, label = "消滅有無区分")
    private String ifcSyoumetuumu;


    public String getIfcSyoumetuumu() {
        return ifcSyoumetuumu;
    }


    public void setIfcSyoumetuumu(String pIfcSyoumetuumu) {
        ifcSyoumetuumu = pIfcSyoumetuumu;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
