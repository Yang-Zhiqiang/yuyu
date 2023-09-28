package yuyu.common.biz.bznayose;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.def.classification.C_KankeisyaKbn;
import yuyu.def.classification.C_Mfrenflg;
import yuyu.def.classification.C_NayoseJyoutaiKbn;
import yuyu.def.classification.C_SeirituKbn;

/**
 * 新契約索引結果Beanクラスです。<br />
 */
public class BzSinkeiyakuSakuinKekkaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String skmosno;

    private C_KankeisyaKbn skmoskankeisyakbn;

    private String skmosfkojinkbn;

    private C_Mfrenflg skmfrenflg;

    private BizDate skmosymd;

    private BizDate skkykymd;

    private C_SeirituKbn skseiritukbn;

    private BizDate sksrsyoriymd;

    private String sksyouhncd;

    private BizDateYM skbosyuuym;

    private C_NayoseJyoutaiKbn sktaisyounayosejtkbn;

    private String sktaisyousakuinnmno;

    private BizDate sktaisyouseiymd;

    private Integer sksyouhnsdno;

    public BzSinkeiyakuSakuinKekkaBean() {
        super();
    }

    public String getSkmosno() {
        return skmosno;
    }

    public void setSkmosno(String pSkmosno) {
        skmosno = pSkmosno;
    }

    public C_KankeisyaKbn getSkmoskankeisyakbn() {
        return skmoskankeisyakbn;
    }

    public void setSkmoskankeisyakbn(C_KankeisyaKbn pSkmoskankeisyakbn) {
        skmoskankeisyakbn = pSkmoskankeisyakbn;
    }

    public String getSkmosfkojinkbn() {
        return skmosfkojinkbn;
    }

    public void setSkmosfkojinkbn(String pSkmosfkojinkbn) {
        skmosfkojinkbn = pSkmosfkojinkbn;
    }

    public C_Mfrenflg getSkmfrenflg() {
        return skmfrenflg;
    }

    public void setSkmfrenflg(C_Mfrenflg pSkmfrenflg) {
        skmfrenflg = pSkmfrenflg;
    }

    public BizDate getSkmosymd() {
        return skmosymd;
    }

    public void setSkmosymd(BizDate pSkmosymd) {
        skmosymd = pSkmosymd;
    }

    public BizDate getSkkykymd() {
        return skkykymd;
    }

    public void setSkkykymd(BizDate pSkkykymd) {
        skkykymd = pSkkykymd;
    }

    public C_SeirituKbn getSkseiritukbn() {
        return skseiritukbn;
    }

    public void setSkseiritukbn(C_SeirituKbn pSkseiritukbn) {
        skseiritukbn = pSkseiritukbn;
    }

    public BizDate getSksrsyoriymd() {
        return sksrsyoriymd;
    }

    public void setSksrsyoriymd(BizDate pSksrsyoriymd) {
        sksrsyoriymd = pSksrsyoriymd;
    }

    public String getSksyouhncd() {
        return sksyouhncd;
    }

    public void setSksyouhncd(String pSksyouhncd) {
        sksyouhncd = pSksyouhncd;
    }

    public BizDateYM getSkbosyuuym() {
        return skbosyuuym;
    }

    public void setSkbosyuuym(BizDateYM pSkbosyuuym) {
        skbosyuuym = pSkbosyuuym;
    }

    public C_NayoseJyoutaiKbn getSktaisyounayosejtkbn() {
        return sktaisyounayosejtkbn;
    }

    public void setSktaisyounayosejtkbn(C_NayoseJyoutaiKbn pSktaisyounayosejtkbn) {
        sktaisyounayosejtkbn = pSktaisyounayosejtkbn;
    }

    public String getSktaisyousakuinnmno() {
        return sktaisyousakuinnmno;
    }

    public void setSktaisyousakuinnmno(String pSktaisyousakuinnmno) {
        sktaisyousakuinnmno = pSktaisyousakuinnmno;
    }

    public BizDate getSktaisyouseiymd() {
        return sktaisyouseiymd;
    }

    public void setSktaisyouseiymd(BizDate pSktaisyouseiymd) {
        sktaisyouseiymd = pSktaisyouseiymd;
    }

    public Integer getSksyouhnsdno() {
        return sksyouhnsdno;
    }

    public void setSksyouhnsdno(Integer pSksyouhnsdno) {
        sksyouhnsdno = pSksyouhnsdno;
    }
}
