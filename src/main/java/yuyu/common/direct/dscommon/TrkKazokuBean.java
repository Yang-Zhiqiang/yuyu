package yuyu.common.direct.dscommon;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;

import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * ダイレクトサービス ダイレクトサービス共通 登録家族情報Bean<br/>
 */
public class TrkKazokuBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_ErrorKbn errorKbn;

    private C_UmuKbn trkkzkumuKbn1;

    private C_TrkKzkKbn trkkzkKbn1;

    private BizDate trkkzksetteiYmd1;

    private String trkkzknmKn1;

    private String trkkzknmKj1;

    private C_KjkhukaKbn trkkzknmkjkhukaKbn1;

    private BizDate trkkzkseiYmd1;

    private C_Seibetu trkkzkSei1;

    private C_Tdk trkkzkTdk1;

    private String trkkzkYno1;

    private String trkkzkadr1Kj1;

    private String trkkzkadr2Kj1;

    private String trkkzkadr3Kj1;

    private String trkkzkTelno1;

    private String gyoumuKousinTime1;

    private C_UmuKbn trkkzkumuKbn2;

    private C_TrkKzkKbn trkkzkKbn2;

    private BizDate trkkzksetteiYmd2;

    private String trkkzknmKn2;

    private String trkkzknmKj2;

    private C_KjkhukaKbn trkkzknmkjkhukaKbn2;

    private BizDate trkkzkseiYmd2;

    private C_Seibetu trkkzkSei2;

    private C_Tdk trkkzkTdk2;

    private String trkkzkYno2;

    private String trkkzkadr1Kj2;

    private String trkkzkadr2Kj2;

    private String trkkzkadr3Kj2;

    private String trkkzkTelno2;

    private String gyoumuKousinTime2;

    public C_ErrorKbn getErrorKbn() {
        return errorKbn;
    }

    public void setErrorKbn(C_ErrorKbn pErrorKbn) {
        errorKbn = pErrorKbn;
    }

    public C_UmuKbn getTrkkzkumuKbn1() {
        return trkkzkumuKbn1;
    }

    public void setTrkkzkumuKbn1(C_UmuKbn pTrkkzkumuKbn1) {
        trkkzkumuKbn1 = pTrkkzkumuKbn1;
    }

    public C_TrkKzkKbn getTrkkzkKbn1() {
        return trkkzkKbn1;
    }

    public void setTrkkzkKbn1(C_TrkKzkKbn pTrkkzkKbn1) {
        trkkzkKbn1 = pTrkkzkKbn1;
    }

    public BizDate getTrkkzksetteiYmd1() {
        return trkkzksetteiYmd1;
    }

    public void setTrkkzksetteiYmd1(BizDate pTrkkzksetteiYmd1) {
        trkkzksetteiYmd1 = pTrkkzksetteiYmd1;
    }

    public String getTrkkzknmKn1() {
        return trkkzknmKn1;
    }

    public void setTrkkzknmKn1(String pTrkkzknmKn1) {
        trkkzknmKn1 = pTrkkzknmKn1;
    }

    public String getTrkkzknmKj1() {
        return trkkzknmKj1;
    }

    public void setTrkkzknmKj1(String pTrkkzknmKj1) {
        trkkzknmKj1 = pTrkkzknmKj1;
    }

    public C_KjkhukaKbn getTrkkzknmkjkhukaKbn1() {
        return trkkzknmkjkhukaKbn1;
    }

    public void setTrkkzknmkjkhukaKbn1(C_KjkhukaKbn pTrkkzknmkjkhukaKbn1) {
        trkkzknmkjkhukaKbn1 = pTrkkzknmkjkhukaKbn1;
    }

    public BizDate getTrkkzkseiYmd1() {
        return trkkzkseiYmd1;
    }

    public void setTrkkzkseiYmd1(BizDate pTrkkzkseiYmd1) {
        trkkzkseiYmd1 = pTrkkzkseiYmd1;
    }

    public C_Seibetu getTrkkzkSei1() {
        return trkkzkSei1;
    }

    public void setTrkkzkSei1(C_Seibetu pTrkkzkSei1) {
        trkkzkSei1 = pTrkkzkSei1;
    }

    public C_Tdk getTrkkzkTdk1() {
        return trkkzkTdk1;
    }

    public void setTrkkzkTdk1(C_Tdk pTrkkzkTdk1) {
        trkkzkTdk1 = pTrkkzkTdk1;
    }

    public String getTrkkzkYno1() {
        return trkkzkYno1;
    }

    public void setTrkkzkYno1(String pTrkkzkYno1) {
        trkkzkYno1 = pTrkkzkYno1;
    }

    public String getTrkkzkadr1Kj1() {
        return trkkzkadr1Kj1;
    }

    public void setTrkkzkadr1Kj1(String pTrkkzkadr1Kj1) {
        trkkzkadr1Kj1 = pTrkkzkadr1Kj1;
    }

    public String getTrkkzkadr2Kj1() {
        return trkkzkadr2Kj1;
    }

    public void setTrkkzkadr2Kj1(String pTrkkzkadr2Kj1) {
        trkkzkadr2Kj1 = pTrkkzkadr2Kj1;
    }

    public String getTrkkzkadr3Kj1() {
        return trkkzkadr3Kj1;
    }

    public void setTrkkzkadr3Kj1(String pTrkkzkadr3Kj1) {
        trkkzkadr3Kj1 = pTrkkzkadr3Kj1;
    }

    public String getTrkkzkTelno1() {
        return trkkzkTelno1;
    }

    public void setTrkkzkTelno1(String pTrkkzkTelno1) {
        trkkzkTelno1 = pTrkkzkTelno1;
    }

    public String getGyoumuKousinTime1() {
        return gyoumuKousinTime1;
    }

    public void setGyoumuKousinTime1(String pGyoumuKousinTime1) {
        gyoumuKousinTime1 = pGyoumuKousinTime1;
    }

    public C_UmuKbn getTrkkzkumuKbn2() {
        return trkkzkumuKbn2;
    }

    public void setTrkkzkumuKbn2(C_UmuKbn pTrkkzkumuKbn2) {
        trkkzkumuKbn2 = pTrkkzkumuKbn2;
    }

    public C_TrkKzkKbn getTrkkzkKbn2() {
        return trkkzkKbn2;
    }

    public void setTrkkzkKbn2(C_TrkKzkKbn pTrkkzkKbn2) {
        trkkzkKbn2 = pTrkkzkKbn2;
    }

    public BizDate getTrkkzksetteiYmd2() {
        return trkkzksetteiYmd2;
    }

    public void setTrkkzksetteiYmd2(BizDate pTrkkzksetteiYmd2) {
        trkkzksetteiYmd2 = pTrkkzksetteiYmd2;
    }

    public String getTrkkzknmKn2() {
        return trkkzknmKn2;
    }

    public void setTrkkzknmKn2(String pTrkkzknmKn2) {
        trkkzknmKn2 = pTrkkzknmKn2;
    }

    public String getTrkkzknmKj2() {
        return trkkzknmKj2;
    }

    public void setTrkkzknmKj2(String pTrkkzknmKj2) {
        trkkzknmKj2 = pTrkkzknmKj2;
    }

    public C_KjkhukaKbn getTrkkzknmkjkhukaKbn2() {
        return trkkzknmkjkhukaKbn2;
    }

    public void setTrkkzknmkjkhukaKbn2(C_KjkhukaKbn pTrkkzknmkjkhukaKbn2) {
        trkkzknmkjkhukaKbn2 = pTrkkzknmkjkhukaKbn2;
    }

    public BizDate getTrkkzkseiYmd2() {
        return trkkzkseiYmd2;
    }

    public void setTrkkzkseiYmd2(BizDate pTrkkzkseiYmd2) {
        trkkzkseiYmd2 = pTrkkzkseiYmd2;
    }

    public C_Seibetu getTrkkzkSei2() {
        return trkkzkSei2;
    }

    public void setTrkkzkSei2(C_Seibetu pTrkkzkSei2) {
        trkkzkSei2 = pTrkkzkSei2;
    }

    public C_Tdk getTrkkzkTdk2() {
        return trkkzkTdk2;
    }

    public void setTrkkzkTdk2(C_Tdk pTrkkzkTdk2) {
        trkkzkTdk2 = pTrkkzkTdk2;
    }

    public String getTrkkzkYno2() {
        return trkkzkYno2;
    }

    public void setTrkkzkYno2(String pTrkkzkYno2) {
        trkkzkYno2 = pTrkkzkYno2;
    }

    public String getTrkkzkadr1Kj2() {
        return trkkzkadr1Kj2;
    }

    public void setTrkkzkadr1Kj2(String pTrkkzkadr1Kj2) {
        trkkzkadr1Kj2 = pTrkkzkadr1Kj2;
    }

    public String getTrkkzkadr2Kj2() {
        return trkkzkadr2Kj2;
    }

    public void setTrkkzkadr2Kj2(String pTrkkzkadr2Kj2) {
        trkkzkadr2Kj2 = pTrkkzkadr2Kj2;
    }

    public String getTrkkzkadr3Kj2() {
        return trkkzkadr3Kj2;
    }

    public void setTrkkzkadr3Kj2(String pTrkkzkadr3Kj2) {
        trkkzkadr3Kj2 = pTrkkzkadr3Kj2;
    }

    public String getTrkkzkTelno2() {
        return trkkzkTelno2;
    }

    public void setTrkkzkTelno2(String pTrkkzkTelno2) {
        trkkzkTelno2 = pTrkkzkTelno2;
    }

    public String getGyoumuKousinTime2() {
        return gyoumuKousinTime2;
    }

    public void setGyoumuKousinTime2(String pGyoumuKousinTime2) {
        gyoumuKousinTime2 = pGyoumuKousinTime2;
    }

}
