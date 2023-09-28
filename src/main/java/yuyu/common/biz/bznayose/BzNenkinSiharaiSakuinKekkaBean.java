package yuyu.common.biz.bznayose;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_NkKankeisyaKbn;
import yuyu.def.classification.C_NkSyoumetuCd;

/**
 * 年金支払索引結果Beanクラスです。<br />
 */
public class BzNenkinSiharaiSakuinKekkaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nknksysyno;

    private C_NkKankeisyaKbn nknkkankeisyakbn;

    private String nknkkojinkbn;

    private BizDate nkkykymd;

    private BizDate nknkshrstartymd;

    private C_NkSyoumetuCd nknksyoumetucd;

    private BizDate nksyoumetuymd;

    private String nksyouhncd;

    private String nknenkinsyu;

    private BizDate nktaisyouseiymd;

    private Integer nksyouhnsdno;

    public BzNenkinSiharaiSakuinKekkaBean() {
        super();
    }

    public String getNknksysyno() {
        return nknksysyno;
    }

    public void setNknksysyno(String pNknksysyno) {
        nknksysyno = pNknksysyno;
    }

    public C_NkKankeisyaKbn getNknkkankeisyakbn() {
        return nknkkankeisyakbn;
    }

    public void setNknkkankeisyakbn(C_NkKankeisyaKbn pNknkkankeisyakbn) {
        nknkkankeisyakbn = pNknkkankeisyakbn;
    }

    public String getNknkkojinkbn() {
        return nknkkojinkbn;
    }

    public void setNknkkojinkbn(String pNknkkojinkbn) {
        nknkkojinkbn = pNknkkojinkbn;
    }

    public BizDate getNkkykymd() {
        return nkkykymd;
    }

    public void setNkkykymd(BizDate pNkkykymd) {
        nkkykymd = pNkkykymd;
    }

    public BizDate getNknkshrstartymd() {
        return nknkshrstartymd;
    }

    public void setNknkshrstartymd(BizDate pNknkshrstartymd) {
        nknkshrstartymd = pNknkshrstartymd;
    }

    public C_NkSyoumetuCd getNknksyoumetucd() {
        return nknksyoumetucd;
    }

    public void setNknksyoumetucd(C_NkSyoumetuCd pNknksyoumetucd) {
        nknksyoumetucd = pNknksyoumetucd;
    }

    public BizDate getNksyoumetuymd() {
        return nksyoumetuymd;
    }

    public void setNksyoumetuymd(BizDate pNksyoumetuymd) {
        nksyoumetuymd = pNksyoumetuymd;
    }

    public String getNksyouhncd() {
        return nksyouhncd;
    }

    public void setNksyouhncd(String pNksyouhncd) {
        nksyouhncd = pNksyouhncd;
    }

    public String getNknenkinsyu() {
        return nknenkinsyu;
    }

    public void setNknenkinsyu(String pNknenkinsyu) {
        nknenkinsyu = pNknenkinsyu;
    }

    public BizDate getNktaisyouseiymd() {
        return nktaisyouseiymd;
    }

    public void setNktaisyouseiymd(BizDate pNktaisyouseiymd) {
        nktaisyouseiymd = pNktaisyouseiymd;
    }

    public Integer getNksyouhnsdno() {
        return nksyouhnsdno;
    }

    public void setNksyouhnsdno(Integer pNksyouhnsdno) {
        nksyouhnsdno = pNksyouhnsdno;
    }

}
