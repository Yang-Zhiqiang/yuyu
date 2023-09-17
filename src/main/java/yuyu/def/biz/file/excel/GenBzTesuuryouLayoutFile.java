package yuyu.def.biz.file.excel;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.excel.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）手数料情報テーブルレイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzTesuuryouLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzTesuuryouLayoutFile() {
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

    @Column(order = 3, label = "tsrysyorikbn")
    private String ifeTstsrysyorikbn;

    public String getIfeTstsrysyorikbn() {
        return ifeTstsrysyorikbn;
    }

    public void setIfeTstsrysyorikbn(String pIfeTstsrysyorikbn) {
        ifeTstsrysyorikbn = pIfeTstsrysyorikbn;
    }

    @Column(order = 4, label = "renno")
    private String ifeTsrenno;

    public String getIfeTsrenno() {
        return ifeTsrenno;
    }

    public void setIfeTsrenno(String pIfeTsrenno) {
        ifeTsrenno = pIfeTsrenno;
    }

    @Column(order = 5, label = "syoriYmd")
    private String ifeTssyoriymd;

    public String getIfeTssyoriymd() {
        return ifeTssyoriymd;
    }

    public void setIfeTssyoriymd(String pIfeTssyoriymd) {
        ifeTssyoriymd = pIfeTssyoriymd;
    }

    @Column(order = 6, label = "kouryokuhasseiym")
    private String ifeTskouryokuhasseiym;

    public String getIfeTskouryokuhasseiym() {
        return ifeTskouryokuhasseiym;
    }

    public void setIfeTskouryokuhasseiym(String pIfeTskouryokuhasseiym) {
        ifeTskouryokuhasseiym = pIfeTskouryokuhasseiym;
    }

    @Column(order = 7, label = "nyknkaisuuy")
    private String ifeTsnyknkaisuuy;

    public String getIfeTsnyknkaisuuy() {
        return ifeTsnyknkaisuuy;
    }

    public void setIfeTsnyknkaisuuy(String pIfeTsnyknkaisuuy) {
        ifeTsnyknkaisuuy = pIfeTsnyknkaisuuy;
    }

    @Column(order = 8, label = "nyknkaisuum")
    private String ifeTsnyknkaisuum;

    public String getIfeTsnyknkaisuum() {
        return ifeTsnyknkaisuum;
    }

    public void setIfeTsnyknkaisuum(String pIfeTsnyknkaisuum) {
        ifeTsnyknkaisuum = pIfeTsnyknkaisuum;
    }

    @Column(order = 9, label = "mikeikapariflg")
    private String ifeTsmikeikapariflg;

    public String getIfeTsmikeikapariflg() {
        return ifeTsmikeikapariflg;
    }

    public void setIfeTsmikeikapariflg(String pIfeTsmikeikapariflg) {
        ifeTsmikeikapariflg = pIfeTsmikeikapariflg;
    }

    @Column(order = 10, label = "misyuupariflg")
    private String ifeTsmisyuupariflg;

    public String getIfeTsmisyuupariflg() {
        return ifeTsmisyuupariflg;
    }

    public void setIfeTsmisyuupariflg(String pIfeTsmisyuupariflg) {
        ifeTsmisyuupariflg = pIfeTsmisyuupariflg;
    }

    @Column(order = 11, label = "mikeikap")
    private String ifeTsmikeikap;

    public String getIfeTsmikeikap() {
        return ifeTsmikeikap;
    }

    public void setIfeTsmikeikap(String pIfeTsmikeikap) {
        ifeTsmikeikap = pIfeTsmikeikap;
    }

    @Column(order = 12, label = "mikeikap$")
    private String ifeTsmikeikapt;

    public String getIfeTsmikeikapt() {
        return ifeTsmikeikapt;
    }

    public void setIfeTsmikeikapt(String pIfeTsmikeikapt) {
        ifeTsmikeikapt = pIfeTsmikeikapt;
    }

    @Column(order = 13, label = "iktp")
    private String ifeTsiktp;

    public String getIfeTsiktp() {
        return ifeTsiktp;
    }

    public void setIfeTsiktp(String pIfeTsiktp) {
        ifeTsiktp = pIfeTsiktp;
    }

    @Column(order = 14, label = "iktp$")
    private String ifeTsiktpt;

    public String getIfeTsiktpt() {
        return ifeTsiktpt;
    }

    public void setIfeTsiktpt(String pIfeTsiktpt) {
        ifeTsiktpt = pIfeTsiktpt;
    }

    @Column(order = 15, label = "seisekiym")
    private String ifeTsseisekiym;

    public String getIfeTsseisekiym() {
        return ifeTsseisekiym;
    }

    public void setIfeTsseisekiym(String pIfeTsseisekiym) {
        ifeTsseisekiym = pIfeTsseisekiym;
    }

    @Column(order = 16, label = "hrkkaisuu")
    private String ifeTshrkkaisuu;

    public String getIfeTshrkkaisuu() {
        return ifeTshrkkaisuu;
    }

    public void setIfeTshrkkaisuu(String pIfeTshrkkaisuu) {
        ifeTshrkkaisuu = pIfeTshrkkaisuu;
    }

    @Column(order = 17, label = "hrkkeiro")
    private String ifeTshrkkeiro;

    public String getIfeTshrkkeiro() {
        return ifeTshrkkeiro;
    }

    public void setIfeTshrkkeiro(String pIfeTshrkkeiro) {
        ifeTshrkkeiro = pIfeTshrkkeiro;
    }

    @Column(order = 18, label = "hrkp")
    private String ifeTshrkp;

    public String getIfeTshrkp() {
        return ifeTshrkp;
    }

    public void setIfeTshrkp(String pIfeTshrkp) {
        ifeTshrkp = pIfeTshrkp;
    }

    @Column(order = 19, label = "hrkp$")
    private String ifeTshrkpt;

    public String getIfeTshrkpt() {
        return ifeTshrkpt;
    }

    public void setIfeTshrkpt(String pIfeTshrkpt) {
        ifeTshrkpt = pIfeTshrkpt;
    }

    @Column(order = 20, label = "jkipjytym")
    private String ifeTsjkipjytym;

    public String getIfeTsjkipjytym() {
        return ifeTsjkipjytym;
    }

    public void setIfeTsjkipjytym(String pIfeTsjkipjytym) {
        ifeTsjkipjytym = pIfeTsjkipjytym;
    }

    @Column(order = 21, label = "haitounendo")
    private String ifeTshaitounendo;

    public String getIfeTshaitounendo() {
        return ifeTshaitounendo;
    }

    public void setIfeTshaitounendo(String pIfeTshaitounendo) {
        ifeTshaitounendo = pIfeTshaitounendo;
    }

    @Column(order = 22, label = "cifcd")
    private String ifeTscifcd;

    public String getIfeTscifcd() {
        return ifeTscifcd;
    }

    public void setIfeTscifcd(String pIfeTscifcd) {
        ifeTscifcd = pIfeTscifcd;
    }

    @Column(order = 23, label = "smbckanriid")
    private String ifeTssmbckanriid;

    public String getIfeTssmbckanriid() {
        return ifeTssmbckanriid;
    }

    public void setIfeTssmbckanriid(String pIfeTssmbckanriid) {
        ifeTssmbckanriid = pIfeTssmbckanriid;
    }

    @Column(order = 24, label = "boskykjyoutai")
    private String ifeTsboskykjyoutai;

    public String getIfeTsboskykjyoutai() {
        return ifeTsboskykjyoutai;
    }

    public void setIfeTsboskykjyoutai(String pIfeTsboskykjyoutai) {
        ifeTsboskykjyoutai = pIfeTsboskykjyoutai;
    }

    @Column(order = 25, label = "kyknmkj")
    private String ifeTskyknmkj;

    public String getIfeTskyknmkj() {
        return ifeTskyknmkj;
    }

    public void setIfeTskyknmkj(String pIfeTskyknmkj) {
        ifeTskyknmkj = pIfeTskyknmkj;
    }

    @Column(order = 26, label = "bosyuuym")
    private String ifeTsbosyuuym;

    public String getIfeTsbosyuuym() {
        return ifeTsbosyuuym;
    }

    public void setIfeTsbosyuuym(String pIfeTsbosyuuym) {
        ifeTsbosyuuym = pIfeTsbosyuuym;
    }

    @Column(order = 27, label = "nyknymd")
    private String ifeTsnyknymd;

    public String getIfeTsnyknymd() {
        return ifeTsnyknymd;
    }

    public void setIfeTsnyknymd(String pIfeTsnyknymd) {
        ifeTsnyknymd = pIfeTsnyknymd;
    }

    @Column(order = 28, label = "yenkansantkykwsrate")
    private String ifeTsyenkansantkykwsrate;

    public String getIfeTsyenkansantkykwsrate() {
        return ifeTsyenkansantkykwsrate;
    }

    public void setIfeTsyenkansantkykwsrate(String pIfeTsyenkansantkykwsrate) {
        ifeTsyenkansantkykwsrate = pIfeTsyenkansantkykwsrate;
    }

    @Column(order = 29, label = "yenkansantkykwsrateymd")
    private String ifeTsyenkansantkykwsrateymd;

    public String getIfeTsyenkansantkykwsrateymd() {
        return ifeTsyenkansantkykwsrateymd;
    }

    public void setIfeTsyenkansantkykwsrateymd(String pIfeTsyenkansantkykwsrateymd) {
        ifeTsyenkansantkykwsrateymd = pIfeTsyenkansantkykwsrateymd;
    }

    @Column(order = 30, label = "gyoumuKousinKinou")
    private String ifeTsgyoumukousinkinou;

    public String getIfeTsgyoumukousinkinou() {
        return ifeTsgyoumukousinkinou;
    }

    public void setIfeTsgyoumukousinkinou(String pIfeTsgyoumukousinkinou) {
        ifeTsgyoumukousinkinou = pIfeTsgyoumukousinkinou;
    }

    @Column(order = 31, label = "gyoumuKousinsyaId")
    private String ifeTsgyoumukousinsyaid;

    public String getIfeTsgyoumukousinsyaid() {
        return ifeTsgyoumukousinsyaid;
    }

    public void setIfeTsgyoumukousinsyaid(String pIfeTsgyoumukousinsyaid) {
        ifeTsgyoumukousinsyaid = pIfeTsgyoumukousinsyaid;
    }

    @Column(order = 32, label = "gyoumuKousinTime")
    private String ifeTsgyoumukousintime;

    public String getIfeTsgyoumukousintime() {
        return ifeTsgyoumukousintime;
    }

    public void setIfeTsgyoumukousintime(String pIfeTsgyoumukousintime) {
        ifeTsgyoumukousintime = pIfeTsgyoumukousintime;
    }

    @Column(order = 33, label = "kousinsyaId")
    private String ifeTskousinsyaid;

    public String getIfeTskousinsyaid() {
        return ifeTskousinsyaid;
    }

    public void setIfeTskousinsyaid(String pIfeTskousinsyaid) {
        ifeTskousinsyaid = pIfeTskousinsyaid;
    }

    @Column(order = 34, label = "kousinTime")
    private String ifeTskousintime;

    public String getIfeTskousintime() {
        return ifeTskousintime;
    }

    public void setIfeTskousintime(String pIfeTskousintime) {
        ifeTskousintime = pIfeTskousintime;
    }

    @Column(order = 35, label = "kousinKinou")
    private String ifeTskousinkinou;

    public String getIfeTskousinkinou() {
        return ifeTskousinkinou;
    }

    public void setIfeTskousinkinou(String pIfeTskousinkinou) {
        ifeTskousinkinou = pIfeTskousinkinou;
    }

    @Column(order = 36, label = "version")
    private String ifeTsversion;

    public String getIfeTsversion() {
        return ifeTsversion;
    }

    public void setIfeTsversion(String pIfeTsversion) {
        ifeTsversion = pIfeTsversion;
    }

    @Column(order = 37, label = "tikiktbrisyuruikbn")
    private String ifeTstikiktbrisyuruikbn;

    public String getIfeTstikiktbrisyuruikbn() {
        return ifeTstikiktbrisyuruikbn;
    }

    public void setIfeTstikiktbrisyuruikbn(String pIfeTstikiktbrisyuruikbn) {
        ifeTstikiktbrisyuruikbn = pIfeTstikiktbrisyuruikbn;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
