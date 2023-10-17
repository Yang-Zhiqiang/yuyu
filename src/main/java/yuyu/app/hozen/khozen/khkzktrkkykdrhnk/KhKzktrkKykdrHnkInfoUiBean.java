package yuyu.app.hozen.khozen.khkzktrkkykdrhnk;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.classification.C_TsindousiteiKbn;
import yuyu.def.classification.C_UktKbn;

/**
 * 登録家族・契約者代理情報Bean<br />
 */
public class KhKzktrkKykdrHnkInfoUiBean  implements Serializable {
    private static final long serialVersionUID = 1L;

    private String syono;
    private C_TrkKzkKbn trkkzkkbn1;
    private String trkkzknmkn1;
    private String trkkzknmkj1;
    private C_KjkhukaKbn trkkzknmkjkhukakbn1;
    private BizDate trkkzkseiymd1;
    private C_Seibetu trkkzksei1;
    private String trkkzkyno1;
    private String trkkzkadr1kj1;
    private String trkkzkadr2kj1;
    private String trkkzkadr3kj1;
    private String trkkzktelno1;
    private C_Tdk trkkzktdk1;
    private C_TrkKzkKbn trkkzkkbn2;
    private String trkkzknmkn2;
    private String trkkzknmkj2;
    private C_KjkhukaKbn trkkzknmkjkhukakbn2;
    private BizDate trkkzkseiymd2;
    private C_Seibetu trkkzksei2;
    private String trkkzkyno2;
    private String trkkzkadr1kj2;
    private String trkkzkadr2kj2;
    private String trkkzkadr3kj2;
    private String trkkzktelno2;
    private C_Tdk trkkzktdk2;
    private C_UktKbn kykdrkbn;
    private String kykdairinmkn;
    private String kykdairinmkj;
    private C_KjkhukaKbn kykdrnmkjkhukakbn;
    private BizDate kykdrseiymd;
    private String kykdryno;
    private String kykdradr1kj;
    private String kykdradr2kj;
    private String kykdradr3kj;
    private C_TsindousiteiKbn trkkzktsindousiteikbn1;
    private C_TsindousiteiKbn trkkzktsindousiteikbn2;

    public KhKzktrkKykdrHnkInfoUiBean() {
        syono = "";
        trkkzkkbn1 = C_TrkKzkKbn.BLNK;
        trkkzknmkn1 = "";
        trkkzknmkj1 = "";
        trkkzknmkjkhukakbn1 = C_KjkhukaKbn.BLNK;
        trkkzkseiymd1 = null;
        trkkzksei1 = C_Seibetu.BLNK;
        trkkzkyno1 = "";
        trkkzkadr1kj1 = "";
        trkkzkadr2kj1 = "";
        trkkzkadr3kj1 = "";
        trkkzktelno1 = "";
        trkkzktdk1 = C_Tdk.BLNK;
        trkkzkkbn2 = C_TrkKzkKbn.BLNK;
        trkkzknmkn2 = "";
        trkkzknmkj2 = "";
        trkkzknmkjkhukakbn2 = C_KjkhukaKbn.BLNK;
        trkkzkseiymd2 = null;
        trkkzksei2 = C_Seibetu.BLNK;
        trkkzkyno2 = "";
        trkkzkadr1kj2 = "";
        trkkzkadr2kj2 = "";
        trkkzkadr3kj2 = "";
        trkkzktelno2 = "";
        trkkzktdk2 = C_Tdk.BLNK;
        kykdrkbn = C_UktKbn.BLNK;
        kykdairinmkn = "";
        kykdairinmkj = "";
        kykdrnmkjkhukakbn = C_KjkhukaKbn.BLNK;
        kykdrseiymd = null;
        kykdryno = "";
        kykdradr1kj = "";
        kykdradr2kj = "";
        kykdradr3kj = "";
        trkkzktsindousiteikbn1 = C_TsindousiteiKbn.BLNK;
        trkkzktsindousiteikbn2 = C_TsindousiteiKbn.BLNK;
    }

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    public C_TrkKzkKbn getTrkkzkkbn1() {
        return trkkzkkbn1;
    }

    public void setTrkkzkkbn1(C_TrkKzkKbn pTrkkzkkbn1) {
        this.trkkzkkbn1 = pTrkkzkkbn1;
    }

    public String getTrkkzknmkn1() {
        return trkkzknmkn1;
    }

    public void setTrkkzknmkn1(String pTrkkzknmkn1) {
        trkkzknmkn1 = pTrkkzknmkn1;
    }

    public String getTrkkzknmkj1() {
        return trkkzknmkj1;
    }

    public void setTrkkzknmkj1(String pTrkkzknmkj1) {
        trkkzknmkj1 = pTrkkzknmkj1;
    }

    public C_KjkhukaKbn getTrkkzknmkjkhukakbn1() {
        return trkkzknmkjkhukakbn1;
    }

    public void setTrkkzknmkjkhukakbn1(C_KjkhukaKbn pTrkkzknmkjkhukakbn1) {
        trkkzknmkjkhukakbn1 = pTrkkzknmkjkhukakbn1;
    }

    public BizDate getTrkkzkseiymd1() {
        return trkkzkseiymd1;
    }

    public void setTrkkzkseiymd1(BizDate pTrkkzkseiymd1) {
        trkkzkseiymd1 = pTrkkzkseiymd1;
    }

    public C_Seibetu getTrkkzksei1() {
        return trkkzksei1;
    }

    public void setTrkkzksei1(C_Seibetu pTrkkzksei1) {
        trkkzksei1 = pTrkkzksei1;
    }

    public String getTrkkzkyno1() {
        return trkkzkyno1;
    }

    public void setTrkkzkyno1(String pTrkkzkyno1) {
        trkkzkyno1 = pTrkkzkyno1;
    }

    public String getTrkkzkadr1kj1() {
        return trkkzkadr1kj1;
    }

    public void setTrkkzkadr1kj1(String pTrkkzkadr1kj1) {
        trkkzkadr1kj1 = pTrkkzkadr1kj1;
    }

    public String getTrkkzkadr2kj1() {
        return trkkzkadr2kj1;
    }

    public void setTrkkzkadr2kj1(String pTrkkzkadr2kj1) {
        trkkzkadr2kj1 = pTrkkzkadr2kj1;
    }

    public String getTrkkzkadr3kj1() {
        return trkkzkadr3kj1;
    }

    public void setTrkkzkadr3kj1(String pTrkkzkadr3kj1) {
        trkkzkadr3kj1 = pTrkkzkadr3kj1;
    }

    public String getTrkkzktelno1() {
        return trkkzktelno1;
    }

    public void setTrkkzktelno1(String pTrkkzktelno1) {
        trkkzktelno1 = pTrkkzktelno1;
    }

    public C_Tdk getTrkkzktdk1() {
        return trkkzktdk1;
    }

    public void setTrkkzktdk1(C_Tdk pTrkkzktdk1) {
        trkkzktdk1 = pTrkkzktdk1;
    }

    public C_TrkKzkKbn getTrkkzkkbn2() {
        return trkkzkkbn2;
    }

    public void setTrkkzkkbn2(C_TrkKzkKbn pTrkkzkkbn2) {
        this.trkkzkkbn2 = pTrkkzkkbn2;
    }

    public String getTrkkzknmkn2() {
        return trkkzknmkn2;
    }

    public void setTrkkzknmkn2(String pTrkkzknmkn2) {
        trkkzknmkn2 = pTrkkzknmkn2;
    }

    public String getTrkkzknmkj2() {
        return trkkzknmkj2;
    }

    public void setTrkkzknmkj2(String pTrkkzknmkj2) {
        trkkzknmkj2 = pTrkkzknmkj2;
    }

    public C_KjkhukaKbn getTrkkzknmkjkhukakbn2() {
        return trkkzknmkjkhukakbn2;
    }

    public void setTrkkzknmkjkhukakbn2(C_KjkhukaKbn pTrkkzknmkjkhukakbn2) {
        trkkzknmkjkhukakbn2 = pTrkkzknmkjkhukakbn2;
    }

    public BizDate getTrkkzkseiymd2() {
        return trkkzkseiymd2;
    }

    public void setTrkkzkseiymd2(BizDate pTrkkzkseiymd2) {
        trkkzkseiymd2 = pTrkkzkseiymd2;
    }

    public C_Seibetu getTrkkzksei2() {
        return trkkzksei2;
    }

    public void setTrkkzksei2(C_Seibetu pTrkkzksei2) {
        trkkzksei2 = pTrkkzksei2;
    }

    public String getTrkkzkyno2() {
        return trkkzkyno2;
    }

    public void setTrkkzkyno2(String pTrkkzkyno2) {
        trkkzkyno2 = pTrkkzkyno2;
    }

    public String getTrkkzkadr1kj2() {
        return trkkzkadr1kj2;
    }

    public void setTrkkzkadr1kj2(String pTrkkzkadr1kj2) {
        trkkzkadr1kj2 = pTrkkzkadr1kj2;
    }

    public String getTrkkzkadr2kj2() {
        return trkkzkadr2kj2;
    }

    public void setTrkkzkadr2kj2(String pTrkkzkadr2kj2) {
        trkkzkadr2kj2 = pTrkkzkadr2kj2;
    }

    public String getTrkkzkadr3kj2() {
        return trkkzkadr3kj2;
    }

    public void setTrkkzkadr3kj2(String pTrkkzkadr3kj2) {
        trkkzkadr3kj2 = pTrkkzkadr3kj2;
    }

    public String getTrkkzktelno2() {
        return trkkzktelno2;
    }

    public void setTrkkzktelno2(String pTrkkzktelno2) {
        trkkzktelno2 = pTrkkzktelno2;
    }

    public C_Tdk getTrkkzktdk2() {
        return trkkzktdk2;
    }

    public void setTrkkzktdk2(C_Tdk pTrkkzktdk2) {
        trkkzktdk2 = pTrkkzktdk2;
    }

    public C_UktKbn getKykdrkbn() {
        return kykdrkbn;
    }

    public void setKykdrkbn(C_UktKbn pKykdrkbn) {
        kykdrkbn = pKykdrkbn;
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

    public C_KjkhukaKbn getKykdrnmkjkhukakbn() {
        return kykdrnmkjkhukakbn;
    }

    public void setKykdrnmkjkhukakbn(C_KjkhukaKbn pKykdrnmkjkhukakbn) {
        kykdrnmkjkhukakbn = pKykdrnmkjkhukakbn;
    }

    public BizDate getKykdrseiymd() {
        return kykdrseiymd;
    }

    public void setKykdrseiymd(BizDate pKykdrseiymd) {
        kykdrseiymd = pKykdrseiymd;
    }

    public String getKykdryno() {
        return kykdryno;
    }

    public void setKykdryno(String pKykdryno) {
        kykdryno = pKykdryno;
    }

    public String getKykdradr1kj() {
        return kykdradr1kj;
    }

    public void setKykdradr1kj(String pKykdradr1kj) {
        kykdradr1kj = pKykdradr1kj;
    }

    public String getKykdradr2kj() {
        return kykdradr2kj;
    }

    public void setKykdradr2kj(String pKykdradr2kj) {
        kykdradr2kj = pKykdradr2kj;
    }

    public String getKykdradr3kj() {
        return kykdradr3kj;
    }

    public void setKykdradr3kj(String pKykdradr3kj) {
        kykdradr3kj = pKykdradr3kj;
    }

    public C_TsindousiteiKbn getTrkkzktsindousiteikbn1() {
        return trkkzktsindousiteikbn1;
    }

    public void setTrkkzktsindousiteikbn1(C_TsindousiteiKbn pTrkkzktsindousiteikbn1) {
        trkkzktsindousiteikbn1 = pTrkkzktsindousiteikbn1;
    }

    public C_TsindousiteiKbn getTrkkzktsindousiteikbn2() {
        return trkkzktsindousiteikbn2;
    }

    public void setTrkkzktsindousiteikbn2(C_TsindousiteiKbn pTrkkzktsindousiteikbn2) {
        trkkzktsindousiteikbn2 = pTrkkzktsindousiteikbn2;
    }
}
