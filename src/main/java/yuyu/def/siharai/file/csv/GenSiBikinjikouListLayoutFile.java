package yuyu.def.siharai.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_BknJkuKbn;
import yuyu.def.classification.C_HushrGeninKbn;
import yuyu.def.classification.C_NoinitUmuKbn;
import yuyu.def.classification.C_SUketoriHouhouKbn;
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.classification.C_SiinKbn;

/**
 * （支払）備金時効リストレイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSiBikinjikouListLayoutFile implements Serializable {


    private static final long serialVersionUID = 1L;


    public GenSiBikinjikouListLayoutFile() {
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


    @Column(order = 4, label = "ページ番号")
    private String ifcPageno;


    public String getIfcPageno() {
        return ifcPageno;
    }


    public void setIfcPageno(String pIfcPageno) {
        ifcPageno = pIfcPageno;
    }


    @Column(order = 5, label = "保険種類レベルコード")
    private String ifcHknsyruilevelcd;


    public String getIfcHknsyruilevelcd() {
        return ifcHknsyruilevelcd;
    }


    public void setIfcHknsyruilevelcd(String pIfcHknsyruilevelcd) {
        ifcHknsyruilevelcd = pIfcHknsyruilevelcd;
    }


    @Column(order = 6, label = "保険種類")
    private String ifcHknsyurui;


    public String getIfcHknsyurui() {
        return ifcHknsyurui;
    }


    public void setIfcHknsyurui(String pIfcHknsyurui) {
        ifcHknsyurui = pIfcHknsyurui;
    }


    @Column(order = 7, label = "決算年度")
    private String ifcKessannnd;


    public String getIfcKessannnd() {
        return ifcKessannnd;
    }


    public void setIfcKessannnd(String pIfcKessannnd) {
        ifcKessannnd = pIfcKessannnd;
    }


    @Column(order = 8, label = "備金コード")
    private String ifcBkncd;


    public String getIfcBkncd() {
        return ifcBkncd;
    }


    public void setIfcBkncd(String pIfcBkncd) {
        ifcBkncd = pIfcBkncd;
    }


    @Column(order = 9, label = "給付種類")
    private String ifcKyhsyurui;


    public String getIfcKyhsyurui() {
        return ifcKyhsyurui;
    }


    public void setIfcKyhsyurui(String pIfcKyhsyurui) {
        ifcKyhsyurui = pIfcKyhsyurui;
    }


    @Column(order = 10, label = "備金区分")
    private String ifcHknknsyruiname;


    public String getIfcHknknsyruiname() {
        return ifcHknknsyruiname;
    }


    public void setIfcHknknsyruiname(String pIfcHknknsyruiname) {
        ifcHknknsyruiname = pIfcHknknsyruiname;
    }


    @Column(order = 11, label = "支払表示")
    private String ifcShrhyj;


    public String getIfcShrhyj() {
        return ifcShrhyj;
    }


    public void setIfcShrhyj(String pIfcShrhyj) {
        ifcShrhyj = pIfcShrhyj;
    }


    @Column(order = 12, label = "備金確定年月日")
    private String ifcBknkktiymdseireki;


    public String getIfcBknkktiymdseireki() {
        return ifcBknkktiymdseireki;
    }


    public void setIfcBknkktiymdseireki(String pIfcBknkktiymdseireki) {
        ifcBknkktiymdseireki = pIfcBknkktiymdseireki;
    }


    @Column(order = 13, label = "計算基準年月日")
    private String ifcCalckijyunymd;


    public String getIfcCalckijyunymd() {
        return ifcCalckijyunymd;
    }


    public void setIfcCalckijyunymd(String pIfcCalckijyunymd) {
        ifcCalckijyunymd = pIfcCalckijyunymd;
    }


    @Column(order = 14, label = "支社コード")
    private String ifcSisyacd;


    public String getIfcSisyacd() {
        return ifcSisyacd;
    }


    public void setIfcSisyacd(String pIfcSisyacd) {
        ifcSisyacd = pIfcSisyacd;
    }


    @Column(order = 15, label = "記号")
    private String ifcKigou;


    public String getIfcKigou() {
        return ifcKigou;
    }


    public void setIfcKigou(String pIfcKigou) {
        ifcKigou = pIfcKigou;
    }


    @Column(order = 16, label = "証券番号")
    private String ifcSyono;


    public String getIfcSyono() {
        return ifcSyono;
    }


    public void setIfcSyono(String pIfcSyono) {
        ifcSyono = pIfcSyono;
    }


    @Column(order = 17, label = "備金額")
    private String ifcBkngk;


    public String getIfcBkngk() {
        return ifcBkngk;
    }


    public void setIfcBkngk(String pIfcBkngk) {
        ifcBkngk = pIfcBkngk;
    }


    @Column(order = 18, label = "書類受付年月日")
    private String ifcSyoruiukeymdseireki;


    public String getIfcSyoruiukeymdseireki() {
        return ifcSyoruiukeymdseireki;
    }


    public void setIfcSyoruiukeymdseireki(String pIfcSyoruiukeymdseireki) {
        ifcSyoruiukeymdseireki = pIfcSyoruiukeymdseireki;
    }


    @Column(order = 19, label = "円受取表示")
    private String ifcYenukthyoji;


    public String getIfcYenukthyoji() {
        return ifcYenukthyoji;
    }


    public void setIfcYenukthyoji(String pIfcYenukthyoji) {
        ifcYenukthyoji = pIfcYenukthyoji;
    }


    @Column(order = 20, label = "換算基準年月日")
    private String ifcKnsnkijyunymd;


    public String getIfcKnsnkijyunymd() {
        return ifcKnsnkijyunymd;
    }


    public void setIfcKnsnkijyunymd(String pIfcKnsnkijyunymd) {
        ifcKnsnkijyunymd = pIfcKnsnkijyunymd;
    }


    @Column(order = 21, label = "円換算レート")
    private String ifcYenkansantkykwsrate;


    public String getIfcYenkansantkykwsrate() {
        return ifcYenkansantkykwsrate;
    }


    public void setIfcYenkansantkykwsrate(String pIfcYenkansantkykwsrate) {
        ifcYenkansantkykwsrate = pIfcYenkansantkykwsrate;
    }


    @Column(order = 22, label = "指定通貨建保険金額")
    private String ifcSiteituukahokenkngk;


    public String getIfcSiteituukahokenkngk() {
        return ifcSiteituukahokenkngk;
    }


    public void setIfcSiteituukahokenkngk(String pIfcSiteituukahokenkngk) {
        ifcSiteituukahokenkngk = pIfcSiteituukahokenkngk;
    }


    @Column(order = 23, label = "円換算最低保証金額")
    private String ifcYenkasaiteihsygk;


    public String getIfcYenkasaiteihsygk() {
        return ifcYenkasaiteihsygk;
    }


    public void setIfcYenkasaiteihsygk(String pIfcYenkasaiteihsygk) {
        ifcYenkasaiteihsygk = pIfcYenkasaiteihsygk;
    }


    @Column(order = 24, label = "基本（保障）Ｓ")
    private String ifcKihons;


    public String getIfcKihons() {
        return ifcKihons;
    }


    public void setIfcKihons(String pIfcKihons) {
        ifcKihons = pIfcKihons;
    }


    @Column(order = 25, label = "特約Ｓ")
    private String ifcTks;


    public String getIfcTks() {
        return ifcTks;
    }


    public void setIfcTks(String pIfcTks) {
        ifcTks = pIfcTks;
    }


    @Column(order = 26, label = "特約記号")
    private String ifcTkkigou;


    public String getIfcTkkigou() {
        return ifcTkkigou;
    }


    public void setIfcTkkigou(String pIfcTkkigou) {
        ifcTkkigou = pIfcTkkigou;
    }


    @Column(order = 27, label = "型")
    private String ifcKata;


    public String getIfcKata() {
        return ifcKata;
    }


    public void setIfcKata(String pIfcKata) {
        ifcKata = pIfcKata;
    }


    @Column(order = 28, label = "妻子区分")
    private String ifcSaisikbn;


    public String getIfcSaisikbn() {
        return ifcSaisikbn;
    }


    public void setIfcSaisikbn(String pIfcSaisikbn) {
        ifcSaisikbn = pIfcSaisikbn;
    }


    @Column(order = 29, label = "診査表示")
    private String ifcSinsahyj;


    public String getIfcSinsahyj() {
        return ifcSinsahyj;
    }


    public void setIfcSinsahyj(String pIfcSinsahyj) {
        ifcSinsahyj = pIfcSinsahyj;
    }


    @Column(order = 30, label = "早期表示")
    private String ifcSoukihyj;


    public String getIfcSoukihyj() {
        return ifcSoukihyj;
    }


    public void setIfcSoukihyj(String pIfcSoukihyj) {
        ifcSoukihyj = pIfcSoukihyj;
    }


    @Column(order = 31, label = "削減表示")
    private String ifcSkgnhyj;


    public String getIfcSkgnhyj() {
        return ifcSkgnhyj;
    }


    public void setIfcSkgnhyj(String pIfcSkgnhyj) {
        ifcSkgnhyj = pIfcSkgnhyj;
    }


    @Column(order = 32, label = "転換表示")
    private String ifcTnknhyj;


    public String getIfcTnknhyj() {
        return ifcTnknhyj;
    }


    public void setIfcTnknhyj(String pIfcTnknhyj) {
        ifcTnknhyj = pIfcTnknhyj;
    }


    @Column(order = 33, label = "基本Ｓ通貨種類")
    private String ifcKihonstuukasyurui;


    public String getIfcKihonstuukasyurui() {
        return ifcKihonstuukasyurui;
    }


    public void setIfcKihonstuukasyurui(String pIfcKihonstuukasyurui) {
        ifcKihonstuukasyurui = pIfcKihonstuukasyurui;
    }


    @Column(order = 34, label = "現在工程")
    private String ifcGenzaikoutei;


    public String getIfcGenzaikoutei() {
        return ifcGenzaikoutei;
    }


    public void setIfcGenzaikoutei(String pIfcGenzaikoutei) {
        ifcGenzaikoutei = pIfcGenzaikoutei;
    }


    @Column(order = 35, label = "決裁日（査定）")
    private String ifcKessaiymdsatei;


    public String getIfcKessaiymdsatei() {
        return ifcKessaiymdsatei;
    }


    public void setIfcKessaiymdsatei(String pIfcKessaiymdsatei) {
        ifcKessaiymdsatei = pIfcKessaiymdsatei;
    }


    @Column(order = 36, label = "査定結果")
    private C_ShrKekkaKbn ifcShrkekkakbn;


    public C_ShrKekkaKbn getIfcShrkekkakbn() {
        return ifcShrkekkakbn;
    }


    public void setIfcShrkekkakbn(C_ShrKekkaKbn pIfcShrkekkakbn) {
        ifcShrkekkakbn = pIfcShrkekkakbn;
    }


    @Column(order = 37, label = "非該当原因")
    private C_HushrGeninKbn ifcHushrgeninkbn;


    public C_HushrGeninKbn getIfcHushrgeninkbn() {
        return ifcHushrgeninkbn;
    }


    public void setIfcHushrgeninkbn(C_HushrGeninKbn pIfcHushrgeninkbn) {
        ifcHushrgeninkbn = pIfcHushrgeninkbn;
    }


    @Column(order = 38, label = "死因区分")
    private C_SiinKbn ifcSiinkbn;


    public C_SiinKbn getIfcSiinkbn() {
        return ifcSiinkbn;
    }


    public void setIfcSiinkbn(C_SiinKbn pIfcSiinkbn) {
        ifcSiinkbn = pIfcSiinkbn;
    }


    @Column(order = 39, label = "受取方法")
    private C_SUketoriHouhouKbn ifcSuketorihouhoukbn;


    public C_SUketoriHouhouKbn getIfcSuketorihouhoukbn() {
        return ifcSuketorihouhoukbn;
    }


    public void setIfcSuketorihouhoukbn(C_SUketoriHouhouKbn pIfcSuketorihouhoukbn) {
        ifcSuketorihouhoukbn = pIfcSuketorihouhoukbn;
    }


    @Column(order = 40, label = "保険料積立金")
    private String ifcPtumitatekin;


    public String getIfcPtumitatekin() {
        return ifcPtumitatekin;
    }


    public void setIfcPtumitatekin(String pIfcPtumitatekin) {
        ifcPtumitatekin = pIfcPtumitatekin;
    }


    @Column(order = 41, label = "解約返戻金")
    private String ifcKaiyakuhr;


    public String getIfcKaiyakuhr() {
        return ifcKaiyakuhr;
    }


    public void setIfcKaiyakuhr(String pIfcKaiyakuhr) {
        ifcKaiyakuhr = pIfcKaiyakuhr;
    }


    @Column(order = 42, label = "備金区分")
    private C_BknJkuKbn ifcBknjkukbn;


    public C_BknJkuKbn getIfcBknjkukbn() {
        return ifcBknjkukbn;
    }


    public void setIfcBknjkukbn(C_BknJkuKbn pIfcBknjkukbn) {
        ifcBknjkukbn = pIfcBknjkukbn;
    }


    @Column(order = 43, label = "減額有無")
    private C_NoinitUmuKbn ifcGengkumukbn;


    public C_NoinitUmuKbn getIfcGengkumukbn() {
        return ifcGengkumukbn;
    }


    public void setIfcGengkumukbn(C_NoinitUmuKbn pIfcGengkumukbn) {
        ifcGengkumukbn = pIfcGengkumukbn;
    }


    @Column(order = 44, label = "減額処理年月日")
    private String ifcGengksyoriymd;


    public String getIfcGengksyoriymd() {
        return ifcGengksyoriymd;
    }


    public void setIfcGengksyoriymd(String pIfcGengksyoriymd) {
        ifcGengksyoriymd = pIfcGengksyoriymd;
    }


    @Column(order = 45, label = "消滅有無区分")
    private String ifcSyoumetuumu;


    public String getIfcSyoumetuumu() {
        return ifcSyoumetuumu;
    }


    public void setIfcSyoumetuumu(String pIfcSyoumetuumu) {
        ifcSyoumetuumu = pIfcSyoumetuumu;
    }


    @Column(order = 46, label = "精算金額")
    private String ifcSeisankgk;


    public String getIfcSeisankgk() {
        return ifcSeisankgk;
    }


    public void setIfcSeisankgk(String pIfcSeisankgk) {
        ifcSeisankgk = pIfcSeisankgk;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
