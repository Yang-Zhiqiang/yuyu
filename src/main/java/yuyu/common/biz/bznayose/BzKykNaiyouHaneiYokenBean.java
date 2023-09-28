package yuyu.common.biz.bznayose;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HouteiTyotkseiSyouhnHyjKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Huho2kyknoKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_Mfrenflg;
import yuyu.def.classification.C_MossyoumetuKbn;
import yuyu.def.classification.C_NkSyoumetuCd;
import yuyu.def.classification.C_Nkshrjk;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_TrhkjiKakKbn;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;

/**
 * 業務共通 名寄せ 契約内容反映与件Beanクラス
 */
public class BzKykNaiyouHaneiYokenBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_Huho2kyknoKbn huho2kyknokbn;

    private String huho2kykno;

    private Integer recordsakujyohyouji;

    private C_YouhiKbn mqyouhikbn;

    private String khsyouhncd;

    private C_Kykjyoutai khkykjyoutai;

    private BizDate khkykymd;

    private C_YuukousyoumetuKbn khyuukousyoumetukbn;

    private C_Syoumetujiyuu khsyoumetujiyuu;

    private BizDate khsyoumetuymd;

    private C_Tuukasyu khkyktuukasyu;

    private C_Tuukasyu khtsntuukasyu;

    private BizCurrency khtsnsibous;

    private BizCurrency khtsnitijip;

    private BizCurrency khtsnnkgns;

    private Integer khhrkkkn;

    private C_SntkhouKbn khsntkhoukbn;

    private BizDateYM khbosyuuym;

    private Integer khkykhhkndouhyouji;

    private C_TtdktyuuiKbn khttdktyuuikbn1;

    private C_TtdktyuuiKbn khttdktyuuikbn2;

    private C_TtdktyuuiKbn khttdktyuuikbn3;

    private C_TtdktyuuiKbn khttdktyuuikbn4;

    private C_TtdktyuuiKbn khttdktyuuikbn5;

    private Integer khsyouhnsdno;

    private C_UmuKbn khkaigomaehrtkykumukbn;

    private C_UmuKbn khpyennykntkykumukbn;

    private BizCurrency khtsnyennyknkgk;

    private String khskjmosno;

    private C_HouteiTyotkseiSyouhnHyjKbn houteityotkseihyj;

    private C_TrhkjiKakKbn seiritujitrhkjikakkbn;

    private C_Hrkkeiro khhrkkeiro;

    private String sksyouhncd;

    private BizDate skmosymd;

    private BizDate skkykymd;

    private BizDate sksknnkaisiymd;

    private C_SeirituKbn skseiritukbn;

    private BizDate sksrsyoriymd;

    private C_Mfrenflg skmfrenflg;

    private String sksyono;

    private C_Tuukasyu skkyktuukasyu;

    private C_Tuukasyu sktsntuukasyu;

    private BizCurrency sktsnsibous;

    private BizCurrency sktsnitijip;

    private BizCurrency sktsnnkgns;

    private Integer skhrkkkn;

    private C_SntkhouKbn sksntkhoukbn;

    private BizDateYM skbosyuuym;

    private Integer skkykhhkndouhyouji;

    private C_MossyoumetuKbn skmossyoumetukbn;

    private Integer sksyouhnsdno;

    private C_UmuKbn skkaigomaehrtkykumukbn;

    private C_UmuKbn skpyennykntkykumukbn;

    private BizCurrency sktsnyennyknkgk;

    private C_Hrkkeiro skhrkkeiro;

    private String nksyouhncd;

    private C_Nkshrjk nknkshrjk;

    private BizDate nknkshrstartymd;

    private BizDate nkkykymd;

    private C_NkSyoumetuCd nknksyoumetucd;

    private BizDate nksyoumetuymd;

    private C_Tuukasyu nkshrtuukasyu;

    private String nkteinksyu;

    private BizCurrency nktsnnkgns;

    private Integer nknkukthhkndouhyouji;

    private Integer nksyouhnsdno;

    private String hhknnmkn;

    private String hhknnmkj;

    private BizDate hhknseiymd;

    private C_Hhknsei hhknsei;

    private String hhknyno;

    private String hhknadr1kj;

    private String hhknadr2kj;

    private String hhknadr3kj;

    private String hhkntelno;

    private String hhknsykgycd;

    private String kyknmkn;

    private String kyknmkj;

    private BizDate kykseiymd;

    private String nenkinuktnmkana;

    private String nenkinuktnmkanji;

    private BizDate nenkinuktseiymd;

    private String tsinyno;

    private String tsinadr1kj;

    private String tsinadr2kj;

    private String tsinadr3kj;

    private String tsintelno;

    private String sbuktnmkn1;

    private String sbuktnmkj1;

    private String sbuktnmkn2;

    private String sbuktnmkj2;

    private String sbuktnmkn3;

    private String sbuktnmkj3;

    private String sbuktnmkn4;

    private String sbuktnmkj4;

    private String stdrsknmkn;

    private String stdrsknmkj;

    private String kykdairinmkn;

    private String kykdairinmkj;

    private String kzktourokunmkn1;

    private String kzktourokunmkj1;

    private String kzktourokunmkn2;

    private String kzktourokunmkj2;

    private String bankcd;

    private String sitencd;

    private C_YokinKbn yokinkbn;

    private String kouzano;

    private String kzmeiginmkn;

    private C_KzkykdouKbn kzkykdoukbn;

    private String dairitencd1;

    private BizNumber bunwari1;

    private String dairitencd2;

    private BizNumber bunwari2;

    private String kanrisosikicd1;

    private String kanrisosikicd2;

    public BzKykNaiyouHaneiYokenBean() {
        super();
    }

    public C_Huho2kyknoKbn getHuho2kyknokbn() {
        return huho2kyknokbn;
    }

    public void setHuho2kyknokbn(C_Huho2kyknoKbn pHuho2kyknokbn) {
        huho2kyknokbn = pHuho2kyknokbn;
    }

    public String getHuho2kykno() {
        return huho2kykno;
    }

    public void setHuho2kykno(String pHuho2kykno) {
        huho2kykno = pHuho2kykno;
    }

    public Integer getRecordsakujyohyouji() {
        return recordsakujyohyouji;
    }

    public void setRecordsakujyohyouji(Integer pRecordsakujyohyouji) {
        recordsakujyohyouji = pRecordsakujyohyouji;
    }

    public C_YouhiKbn getMqyouhikbn() {
        return mqyouhikbn;
    }

    public void setMqyouhikbn(C_YouhiKbn pMqyouhikbn) {
        mqyouhikbn = pMqyouhikbn;
    }

    public String getKhsyouhncd() {
        return khsyouhncd;
    }

    public void setKhsyouhncd(String pKhsyouhncd) {
        khsyouhncd = pKhsyouhncd;
    }

    public C_Kykjyoutai getKhkykjyoutai() {
        return khkykjyoutai;
    }

    public void setKhkykjyoutai(C_Kykjyoutai pKhkykjyoutai) {
        khkykjyoutai = pKhkykjyoutai;
    }

    public BizDate getKhkykymd() {
        return khkykymd;
    }

    public void setKhkykymd(BizDate pKhkykymd) {
        khkykymd = pKhkykymd;
    }

    public C_YuukousyoumetuKbn getKhyuukousyoumetukbn() {
        return khyuukousyoumetukbn;
    }

    public void setKhyuukousyoumetukbn(C_YuukousyoumetuKbn pKhyuukousyoumetukbn) {
        khyuukousyoumetukbn = pKhyuukousyoumetukbn;
    }

    public C_Syoumetujiyuu getKhsyoumetujiyuu() {
        return khsyoumetujiyuu;
    }

    public void setKhsyoumetujiyuu(C_Syoumetujiyuu pKhsyoumetujiyuu) {
        khsyoumetujiyuu = pKhsyoumetujiyuu;
    }

    public BizDate getKhsyoumetuymd() {
        return khsyoumetuymd;
    }

    public void setKhsyoumetuymd(BizDate pKhsyoumetuymd) {
        khsyoumetuymd = pKhsyoumetuymd;
    }

    public C_Tuukasyu getKhkyktuukasyu() {
        return khkyktuukasyu;
    }

    public void setKhkyktuukasyu(C_Tuukasyu pKhkyktuukasyu) {
        khkyktuukasyu = pKhkyktuukasyu;
    }

    public C_Tuukasyu getKhtsntuukasyu() {
        return khtsntuukasyu;
    }

    public void setKhtsntuukasyu(C_Tuukasyu pKhtsntuukasyu) {
        khtsntuukasyu = pKhtsntuukasyu;
    }

    public BizCurrency getKhtsnsibous() {
        return khtsnsibous;
    }

    public void setKhtsnsibous(BizCurrency pKhtsnsibous) {
        khtsnsibous = pKhtsnsibous;
    }

    public BizCurrency getKhtsnitijip() {
        return khtsnitijip;
    }

    public void setKhtsnitijip(BizCurrency pKhtsnitijip) {
        khtsnitijip = pKhtsnitijip;
    }

    public BizCurrency getKhtsnnkgns() {
        return khtsnnkgns;
    }

    public void setKhtsnnkgns(BizCurrency pKhtsnnkgns) {
        khtsnnkgns = pKhtsnnkgns;
    }

    public Integer getKhhrkkkn() {
        return khhrkkkn;
    }

    public void setKhhrkkkn(Integer pKhhrkkkn) {
        khhrkkkn = pKhhrkkkn;
    }

    public C_SntkhouKbn getKhsntkhoukbn() {
        return khsntkhoukbn;
    }

    public void setKhsntkhoukbn(C_SntkhouKbn pKhsntkhoukbn) {
        khsntkhoukbn = pKhsntkhoukbn;
    }

    public BizDateYM getKhbosyuuym() {
        return khbosyuuym;
    }

    public void setKhbosyuuym(BizDateYM pKhbosyuuym) {
        khbosyuuym = pKhbosyuuym;
    }

    public Integer getKhkykhhkndouhyouji() {
        return khkykhhkndouhyouji;
    }

    public void setKhkykhhkndouhyouji(Integer pKhkykhhkndouhyouji) {
        khkykhhkndouhyouji = pKhkykhhkndouhyouji;
    }

    public C_TtdktyuuiKbn getKhttdktyuuikbn1() {
        return khttdktyuuikbn1;
    }

    public void setKhttdktyuuikbn1(C_TtdktyuuiKbn pKhttdktyuuikbn1) {
        khttdktyuuikbn1 = pKhttdktyuuikbn1;
    }

    public C_TtdktyuuiKbn getKhttdktyuuikbn2() {
        return khttdktyuuikbn2;
    }

    public void setKhttdktyuuikbn2(C_TtdktyuuiKbn pKhttdktyuuikbn2) {
        khttdktyuuikbn2 = pKhttdktyuuikbn2;
    }

    public C_TtdktyuuiKbn getKhttdktyuuikbn3() {
        return khttdktyuuikbn3;
    }

    public void setKhttdktyuuikbn3(C_TtdktyuuiKbn pKhttdktyuuikbn3) {
        khttdktyuuikbn3 = pKhttdktyuuikbn3;
    }

    public C_TtdktyuuiKbn getKhttdktyuuikbn4() {
        return khttdktyuuikbn4;
    }

    public void setKhttdktyuuikbn4(C_TtdktyuuiKbn pKhttdktyuuikbn4) {
        khttdktyuuikbn4 = pKhttdktyuuikbn4;
    }

    public C_TtdktyuuiKbn getKhttdktyuuikbn5() {
        return khttdktyuuikbn5;
    }

    public void setKhttdktyuuikbn5(C_TtdktyuuiKbn pKhttdktyuuikbn5) {
        khttdktyuuikbn5 = pKhttdktyuuikbn5;
    }

    public Integer getKhsyouhnsdno() {
        return khsyouhnsdno;
    }

    public void setKhsyouhnsdno(Integer pKhsyouhnsdno) {
        khsyouhnsdno = pKhsyouhnsdno;
    }

    public C_UmuKbn getKhkaigomaehrtkykumukbn() {
        return khkaigomaehrtkykumukbn;
    }

    public void setKhkaigomaehrtkykumukbn(C_UmuKbn pKhkaigomaehrtkykumukbn) {
        khkaigomaehrtkykumukbn = pKhkaigomaehrtkykumukbn;
    }

    public C_UmuKbn getKhpyennykntkykumukbn() {
        return khpyennykntkykumukbn;
    }

    public void setKhpyennykntkykumukbn(C_UmuKbn pKhpyennykntkykumukbn) {
        khpyennykntkykumukbn = pKhpyennykntkykumukbn;
    }

    public BizCurrency getKhtsnyennyknkgk() {
        return khtsnyennyknkgk;
    }

    public void setKhtsnyennyknkgk(BizCurrency pKhtsnyennyknkgk) {
        khtsnyennyknkgk = pKhtsnyennyknkgk;
    }

    public String getKhskjmosno() {
        return khskjmosno;
    }

    public void setKhskjmosno(String pKhskjmosno) {
        khskjmosno = pKhskjmosno;
    }

    public C_HouteiTyotkseiSyouhnHyjKbn getHouteityotkseihyj() {
        return houteityotkseihyj;
    }

    public void setHouteityotkseihyj(C_HouteiTyotkseiSyouhnHyjKbn pHouteityotkseihyj) {
        this.houteityotkseihyj = pHouteityotkseihyj;
    }

    public C_TrhkjiKakKbn getSeiritujitrhkjikakkbn() {
        return seiritujitrhkjikakkbn;
    }

    public void setSeiritujitrhkjikakkbn(C_TrhkjiKakKbn pSeiritujitrhkjikakkbn) {
        this.seiritujitrhkjikakkbn = pSeiritujitrhkjikakkbn;
    }

    public C_Hrkkeiro getKhhrkkeiro() {
        return khhrkkeiro;
    }

    public void setKhhrkkeiro(C_Hrkkeiro pKhhrkkeiro) {
        khhrkkeiro = pKhhrkkeiro;
    }

    public String getSksyouhncd() {
        return sksyouhncd;
    }

    public void setSksyouhncd(String pSksyouhncd) {
        sksyouhncd = pSksyouhncd;
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

    public BizDate getSksknnkaisiymd() {
        return sksknnkaisiymd;
    }

    public void setSksknnkaisiymd(BizDate pSksknnkaisiymd) {
        sksknnkaisiymd = pSksknnkaisiymd;
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

    public C_Mfrenflg getSkmfrenflg() {
        return skmfrenflg;
    }

    public void setSkmfrenflg(C_Mfrenflg pSkmfrenflg) {
        skmfrenflg = pSkmfrenflg;
    }

    public String getSksyono() {
        return sksyono;
    }

    public void setSksyono(String pSksyono) {
        sksyono = pSksyono;
    }

    public C_Tuukasyu getSkkyktuukasyu() {
        return skkyktuukasyu;
    }

    public void setSkkyktuukasyu(C_Tuukasyu pSkkyktuukasyu) {
        skkyktuukasyu = pSkkyktuukasyu;
    }

    public C_Tuukasyu getSktsntuukasyu() {
        return sktsntuukasyu;
    }

    public void setSktsntuukasyu(C_Tuukasyu pSktsntuukasyu) {
        sktsntuukasyu = pSktsntuukasyu;
    }

    public BizCurrency getSktsnsibous() {
        return sktsnsibous;
    }

    public void setSktsnsibous(BizCurrency pSktsnsibous) {
        sktsnsibous = pSktsnsibous;
    }

    public BizCurrency getSktsnitijip() {
        return sktsnitijip;
    }

    public void setSktsnitijip(BizCurrency pSktsnitijip) {
        sktsnitijip = pSktsnitijip;
    }

    public BizCurrency getSktsnnkgns() {
        return sktsnnkgns;
    }

    public void setSktsnnkgns(BizCurrency pSktsnnkgns) {
        sktsnnkgns = pSktsnnkgns;
    }

    public Integer getSkhrkkkn() {
        return skhrkkkn;
    }

    public void setSkhrkkkn(Integer pSkhrkkkn) {
        skhrkkkn = pSkhrkkkn;
    }

    public C_SntkhouKbn getSksntkhoukbn() {
        return sksntkhoukbn;
    }

    public void setSksntkhoukbn(C_SntkhouKbn pSksntkhoukbn) {
        sksntkhoukbn = pSksntkhoukbn;
    }

    public BizDateYM getSkbosyuuym() {
        return skbosyuuym;
    }

    public void setSkbosyuuym(BizDateYM pSkbosyuuym) {
        skbosyuuym = pSkbosyuuym;
    }

    public Integer getSkkykhhkndouhyouji() {
        return skkykhhkndouhyouji;
    }

    public void setSkkykhhkndouhyouji(Integer pSkkykhhkndouhyouji) {
        skkykhhkndouhyouji = pSkkykhhkndouhyouji;
    }

    public C_MossyoumetuKbn getSkmossyoumetukbn() {
        return skmossyoumetukbn;
    }

    public void setSkmossyoumetukbn(C_MossyoumetuKbn pSkmossyoumetukbn) {
        skmossyoumetukbn = pSkmossyoumetukbn;
    }

    public Integer getSksyouhnsdno() {
        return sksyouhnsdno;
    }

    public void setSksyouhnsdno(Integer pSksyouhnsdno) {
        sksyouhnsdno = pSksyouhnsdno;
    }

    public C_UmuKbn getSkkaigomaehrtkykumukbn() {
        return skkaigomaehrtkykumukbn;
    }

    public void setSkkaigomaehrtkykumukbn(C_UmuKbn pSkkaigomaehrtkykumukbn) {
        skkaigomaehrtkykumukbn = pSkkaigomaehrtkykumukbn;
    }

    public C_UmuKbn getSkpyennykntkykumukbn() {
        return skpyennykntkykumukbn;
    }

    public void setSkpyennykntkykumukbn(C_UmuKbn pSkpyennykntkykumukbn) {
        skpyennykntkykumukbn = pSkpyennykntkykumukbn;
    }

    public BizCurrency getSktsnyennyknkgk() {
        return sktsnyennyknkgk;
    }

    public void setSktsnyennyknkgk(BizCurrency pSktsnyennyknkgk) {
        sktsnyennyknkgk = pSktsnyennyknkgk;
    }

    public C_Hrkkeiro getSkhrkkeiro() {
        return skhrkkeiro;
    }

    public void setSkhrkkeiro(C_Hrkkeiro pSkhrkkeiro) {
        skhrkkeiro = pSkhrkkeiro;
    }

    public String getNksyouhncd() {
        return nksyouhncd;
    }

    public void setNksyouhncd(String pNksyouhncd) {
        nksyouhncd = pNksyouhncd;
    }

    public C_Nkshrjk getNknkshrjk() {
        return nknkshrjk;
    }

    public void setNknkshrjk(C_Nkshrjk pNknkshrjk) {
        nknkshrjk = pNknkshrjk;
    }

    public BizDate getNknkshrstartymd() {
        return nknkshrstartymd;
    }

    public void setNknkshrstartymd(BizDate pNknkshrstartymd) {
        nknkshrstartymd = pNknkshrstartymd;
    }

    public BizDate getNkkykymd() {
        return nkkykymd;
    }

    public void setNkkykymd(BizDate pNkkykymd) {
        nkkykymd = pNkkykymd;
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

    public C_Tuukasyu getNkshrtuukasyu() {
        return nkshrtuukasyu;
    }

    public void setNkshrtuukasyu(C_Tuukasyu pNkshrtuukasyu) {
        nkshrtuukasyu = pNkshrtuukasyu;
    }

    public String getNkteinksyu() {
        return nkteinksyu;
    }

    public void setNkteinksyu(String pNkteinksyu) {
        nkteinksyu = pNkteinksyu;
    }

    public BizCurrency getNktsnnkgns() {
        return nktsnnkgns;
    }

    public void setNktsnnkgns(BizCurrency pNktsnnkgns) {
        nktsnnkgns = pNktsnnkgns;
    }

    public Integer getNknkukthhkndouhyouji() {
        return nknkukthhkndouhyouji;
    }

    public void setNknkukthhkndouhyouji(Integer pNknkukthhkndouhyouji) {
        nknkukthhkndouhyouji = pNknkukthhkndouhyouji;
    }

    public Integer getNksyouhnsdno() {
        return nksyouhnsdno;
    }

    public void setNksyouhnsdno(Integer pNksyouhnsdno) {
        nksyouhnsdno = pNksyouhnsdno;
    }

    public String getHhknnmkn() {
        return hhknnmkn;
    }

    public void setHhknnmkn(String pHhknnmkn) {
        hhknnmkn = pHhknnmkn;
    }

    public String getHhknnmkj() {
        return hhknnmkj;
    }

    public void setHhknnmkj(String pHhknnmkj) {
        hhknnmkj = pHhknnmkj;
    }

    public BizDate getHhknseiymd() {
        return hhknseiymd;
    }

    public void setHhknseiymd(BizDate pHhknseiymd) {
        hhknseiymd = pHhknseiymd;
    }

    public C_Hhknsei getHhknsei() {
        return hhknsei;
    }

    public void setHhknsei(C_Hhknsei pHhknsei) {
        hhknsei = pHhknsei;
    }

    public String getHhknyno() {
        return hhknyno;
    }

    public void setHhknyno(String pHhknyno) {
        hhknyno = pHhknyno;
    }

    public String getHhknadr1kj() {
        return hhknadr1kj;
    }

    public void setHhknadr1kj(String pHhknadr1kj) {
        hhknadr1kj = pHhknadr1kj;
    }

    public String getHhknadr2kj() {
        return hhknadr2kj;
    }

    public void setHhknadr2kj(String pHhknadr2kj) {
        hhknadr2kj = pHhknadr2kj;
    }

    public String getHhknadr3kj() {
        return hhknadr3kj;
    }

    public void setHhknadr3kj(String pHhknadr3kj) {
        hhknadr3kj = pHhknadr3kj;
    }

    public String getHhkntelno() {
        return hhkntelno;
    }

    public void setHhkntelno(String pHhkntelno) {
        hhkntelno = pHhkntelno;
    }

    public String getHhknsykgycd() {
        return hhknsykgycd;
    }

    public void setHhknsykgycd(String pHhknsykgycd) {
        hhknsykgycd = pHhknsykgycd;
    }

    public String getKyknmkn() {
        return kyknmkn;
    }

    public void setKyknmkn(String pKyknmkn) {
        kyknmkn = pKyknmkn;
    }

    public String getKyknmkj() {
        return kyknmkj;
    }

    public void setKyknmkj(String pKyknmkj) {
        kyknmkj = pKyknmkj;
    }

    public BizDate getKykseiymd() {
        return kykseiymd;
    }

    public void setKykseiymd(BizDate pKykseiymd) {
        kykseiymd = pKykseiymd;
    }

    public String getNenkinuktnmkana() {
        return nenkinuktnmkana;
    }

    public void setNenkinuktnmkana(String pNenkinuktnmkana) {
        nenkinuktnmkana = pNenkinuktnmkana;
    }

    public String getNenkinuktnmkanji() {
        return nenkinuktnmkanji;
    }

    public void setNenkinuktnmkanji(String pNenkinuktnmkanji) {
        nenkinuktnmkanji = pNenkinuktnmkanji;
    }

    public BizDate getNenkinuktseiymd() {
        return nenkinuktseiymd;
    }

    public void setNenkinuktseiymd(BizDate pNenkinuktseiymd) {
        nenkinuktseiymd = pNenkinuktseiymd;
    }

    public String getTsinyno() {
        return tsinyno;
    }

    public void setTsinyno(String pTsinyno) {
        tsinyno = pTsinyno;
    }

    public String getTsinadr1kj() {
        return tsinadr1kj;
    }

    public void setTsinadr1kj(String pTsinadr1kj) {
        tsinadr1kj = pTsinadr1kj;
    }

    public String getTsinadr2kj() {
        return tsinadr2kj;
    }

    public void setTsinadr2kj(String pTsinadr2kj) {
        tsinadr2kj = pTsinadr2kj;
    }

    public String getTsinadr3kj() {
        return tsinadr3kj;
    }

    public void setTsinadr3kj(String pTsinadr3kj) {
        tsinadr3kj = pTsinadr3kj;
    }

    public String getTsintelno() {
        return tsintelno;
    }

    public void setTsintelno(String pTsintelno) {
        tsintelno = pTsintelno;
    }

    public String getSbuktnmkn1() {
        return sbuktnmkn1;
    }

    public void setSbuktnmkn1(String pSbuktnmkn1) {
        sbuktnmkn1 = pSbuktnmkn1;
    }

    public String getSbuktnmkj1() {
        return sbuktnmkj1;
    }

    public void setSbuktnmkj1(String pSbuktnmkj1) {
        sbuktnmkj1 = pSbuktnmkj1;
    }

    public String getSbuktnmkn2() {
        return sbuktnmkn2;
    }

    public void setSbuktnmkn2(String pSbuktnmkn2) {
        sbuktnmkn2 = pSbuktnmkn2;
    }

    public String getSbuktnmkj2() {
        return sbuktnmkj2;
    }

    public void setSbuktnmkj2(String pSbuktnmkj2) {
        sbuktnmkj2 = pSbuktnmkj2;
    }

    public String getSbuktnmkn3() {
        return sbuktnmkn3;
    }

    public void setSbuktnmkn3(String pSbuktnmkn3) {
        sbuktnmkn3 = pSbuktnmkn3;
    }

    public String getSbuktnmkj3() {
        return sbuktnmkj3;
    }

    public void setSbuktnmkj3(String pSbuktnmkj3) {
        sbuktnmkj3 = pSbuktnmkj3;
    }

    public String getSbuktnmkn4() {
        return sbuktnmkn4;
    }

    public void setSbuktnmkn4(String pSbuktnmkn4) {
        sbuktnmkn4 = pSbuktnmkn4;
    }

    public String getSbuktnmkj4() {
        return sbuktnmkj4;
    }

    public void setSbuktnmkj4(String pSbuktnmkj4) {
        sbuktnmkj4 = pSbuktnmkj4;
    }

    public String getStdrsknmkn() {
        return stdrsknmkn;
    }

    public void setStdrsknmkn(String pStdrsknmkn) {
        stdrsknmkn = pStdrsknmkn;
    }

    public String getStdrsknmkj() {
        return stdrsknmkj;
    }

    public void setStdrsknmkj(String pStdrsknmkj) {
        stdrsknmkj = pStdrsknmkj;
    }

    public String getKykdairinmkn() {
        return kykdairinmkn;
    }

    public void setKykdairinmkn(String pKykdairinmkn) {
        kykdairinmkn = pKykdairinmkn;
    }

    public String getKykdairinmkj() {
        return kykdairinmkj;
    }

    public void setKykdairinmkj(String pKykdairinmkj) {
        kykdairinmkj = pKykdairinmkj;
    }

    public String getKzktourokunmkn1() {
        return kzktourokunmkn1;
    }

    public void setKzktourokunmkn1(String pKzktourokunmkn1) {
        kzktourokunmkn1 = pKzktourokunmkn1;
    }

    public String getKzktourokunmkj1() {
        return kzktourokunmkj1;
    }

    public void setKzktourokunmkj1(String pKzktourokunmkj1) {
        kzktourokunmkj1 = pKzktourokunmkj1;
    }

    public String getKzktourokunmkn2() {
        return kzktourokunmkn2;
    }

    public void setKzktourokunmkn2(String pKzktourokunmkn2) {
        kzktourokunmkn2 = pKzktourokunmkn2;
    }

    public String getKzktourokunmkj2() {
        return kzktourokunmkj2;
    }

    public void setKzktourokunmkj2(String pKzktourokunmkj2) {
        kzktourokunmkj2 = pKzktourokunmkj2;
    }

    public String getBankcd() {
        return bankcd;
    }

    public void setBankcd(String pBankcd) {
        bankcd = pBankcd;
    }

    public String getSitencd() {
        return sitencd;
    }

    public void setSitencd(String pSitencd) {
        sitencd = pSitencd;
    }

    public C_YokinKbn getYokinkbn() {
        return yokinkbn;
    }

    public void setYokinkbn(C_YokinKbn pYokinkbn) {
        yokinkbn = pYokinkbn;
    }

    public String getKouzano() {
        return kouzano;
    }

    public void setKouzano(String pKouzano) {
        kouzano = pKouzano;
    }

    public String getKzmeiginmkn() {
        return kzmeiginmkn;
    }

    public void setKzmeiginmkn(String pKzmeiginmkn) {
        kzmeiginmkn = pKzmeiginmkn;
    }

    public C_KzkykdouKbn getKzkykdoukbn() {
        return kzkykdoukbn;
    }

    public void setKzkykdoukbn(C_KzkykdouKbn pKzkykdoukbn) {
        kzkykdoukbn = pKzkykdoukbn;
    }

    public String getDairitencd1() {
        return dairitencd1;
    }

    public void setDairitencd1(String pDairitencd1) {
        dairitencd1 = pDairitencd1;
    }

    public BizNumber getBunwari1() {
        return bunwari1;
    }

    public void setBunwari1(BizNumber pBunwari1) {
        bunwari1 = pBunwari1;
    }

    public String getDairitencd2() {
        return dairitencd2;
    }

    public void setDairitencd2(String pDairitencd2) {
        dairitencd2 = pDairitencd2;
    }

    public BizNumber getBunwari2() {
        return bunwari2;
    }

    public void setBunwari2(BizNumber pBunwari2) {
        bunwari2 = pBunwari2;
    }

    public String getKanrisosikicd1() {
        return kanrisosikicd1;
    }

    public void setKanrisosikicd1(String pKanrisosikicd1) {
        kanrisosikicd1 = pKanrisosikicd1;
    }

    public String getKanrisosikicd2() {
        return kanrisosikicd2;
    }

    public void setKanrisosikicd2(String pKanrisosikicd2) {
        kanrisosikicd2 = pKanrisosikicd2;
    }
}
