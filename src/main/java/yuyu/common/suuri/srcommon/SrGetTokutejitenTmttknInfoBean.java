package yuyu.common.suuri.srcommon;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

/**
 * 数理 数理共通 指数連動積増型年金積立金テーブル情報Bean
 */
public class SrGetTokutejitenTmttknInfoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String kbnkey;

    private String syono;

    private BizDateYM tmttkntaisyouym;

    private Integer renno;

    private BizDate tmttknkouryokukaisiymd;

    private BizCurrency teiritutmttkngk;

    private BizCurrency sisuurendoutmttkngk;

    private BizNumber sisuuupritu;

    private BizNumber tmttknzoukaritu;

    private BizDate tmttknhaneitmmshanteiymd;

    private BizNumber tmttknhaneisisuu;

    private String gyoumuKousinKinou;

    private String gyoumuKousinsyaId;

    private String gyoumuKousinTime;

    private String kousinsyaId;

    private String kousinTime;

    private String kousinKinou;

    private Long version;

    private BizCurrency itenmaeteiritutmttkngk;

    private BizCurrency itenmaesisuurendoutmttkngk;

    private String henkousikibetukey;

    private BizDate syoriYmd;

	/** 積立金効力開始日（比較用） */
    private BizDate tmttknkouryokukaisiymdForComp;

    public String getKbnkey() {
        return kbnkey;
    }

    public void setKbnkey(String pKbnkey) {
        kbnkey = pKbnkey;
    }

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    public BizDateYM getTmttkntaisyouym() {
        return tmttkntaisyouym;
    }

    public void setTmttkntaisyouym(BizDateYM pTmttkntaisyouym) {
        tmttkntaisyouym = pTmttkntaisyouym;
    }

    public Integer getRenno() {
        return renno;
    }

    public void setRenno(Integer pRenno) {
        renno = pRenno;
    }

    public BizDate getTmttknkouryokukaisiymd() {
        return tmttknkouryokukaisiymd;
    }

    public void setTmttknkouryokukaisiymd(BizDate pTmttknkouryokukaisiymd) {
        tmttknkouryokukaisiymd = pTmttknkouryokukaisiymd;
    }

    public BizCurrency getTeiritutmttkngk() {
        return teiritutmttkngk;
    }

    public void setTeiritutmttkngk(BizCurrency pTeiritutmttkngk) {
        teiritutmttkngk = pTeiritutmttkngk;
    }

    public BizCurrency getSisuurendoutmttkngk() {
        return sisuurendoutmttkngk;
    }

    public void setSisuurendoutmttkngk(BizCurrency pSisuurendoutmttkngk) {
        sisuurendoutmttkngk = pSisuurendoutmttkngk;
    }

    public BizNumber getSisuuupritu() {
        return sisuuupritu;
    }

    public void setSisuuupritu(BizNumber pSisuuupritu) {
        sisuuupritu = pSisuuupritu;
    }

    public BizNumber getTmttknzoukaritu() {
        return tmttknzoukaritu;
    }

    public void setTmttknzoukaritu(BizNumber pTmttknzoukaritu) {
        tmttknzoukaritu = pTmttknzoukaritu;
    }

    public BizDate getTmttknhaneitmmshanteiymd() {
        return tmttknhaneitmmshanteiymd;
    }

    public void setTmttknhaneitmmshanteiymd(BizDate pTmttknhaneitmmshanteiymd) {
        tmttknhaneitmmshanteiymd = pTmttknhaneitmmshanteiymd;
    }

    public BizNumber getTmttknhaneisisuu() {
        return tmttknhaneisisuu;
    }

    public void setTmttknhaneisisuu(BizNumber pTmttknhaneisisuu) {
        tmttknhaneisisuu = pTmttknhaneisisuu;
    }

    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }

    public String getKousinsyaId() {
        return kousinsyaId;
    }

    public void setKousinsyaId(String pKousinsyaId) {
        kousinsyaId = pKousinsyaId;
    }

    public String getKousinTime() {
        return kousinTime;
    }

    public void setKousinTime(String pKousinTime) {
        kousinTime = pKousinTime;
    }

    public String getKousinKinou() {
        return kousinKinou;
    }

    public void setKousinKinou(String pKousinKinou) {
        kousinKinou = pKousinKinou;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long pVersion) {
        version = pVersion;
    }

    public BizCurrency getItenmaeteiritutmttkngk() {
        return itenmaeteiritutmttkngk;
    }

    public void setItenmaeteiritutmttkngk(BizCurrency pItenmaeteiritutmttkngk) {
        itenmaeteiritutmttkngk = pItenmaeteiritutmttkngk;
    }

    public BizCurrency getItenmaesisuurendoutmttkngk() {
        return itenmaesisuurendoutmttkngk;
    }

    public void setItenmaesisuurendoutmttkngk(BizCurrency pItenmaesisuurendoutmttkngk) {
        itenmaesisuurendoutmttkngk = pItenmaesisuurendoutmttkngk;
    }

    public String getHenkousikibetukey() {
        return henkousikibetukey;
    }

    public void setHenkousikibetukey(String pHenkousikibetukey) {
        henkousikibetukey = pHenkousikibetukey;
    }

    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }

    public BizDate getTmttknkouryokukaisiymdForComp() {
        return tmttknkouryokukaisiymdForComp;
    }

    public void setTmttknkouryokukaisiymdForComp(BizDate pTmttknkouryokukaisiymdForComp) {
        tmttknkouryokukaisiymdForComp = pTmttknkouryokukaisiymdForComp;
    }

}
