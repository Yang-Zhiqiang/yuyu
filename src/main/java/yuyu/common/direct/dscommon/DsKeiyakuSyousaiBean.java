package yuyu.common.direct.dscommon;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_GkdtKoktuutiUktKbn;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * ダイレクトサービス ダイレクトサービス共通  ＤＳ契約詳細Bean<br />
 */
public class DsKeiyakuSyousaiBean implements Serializable{

    private static final long serialVersionUID = 1L;

    private String syono;

    private String syouhnnm;

    private String hhknnmkn;

    private BizDate hhknseiYmd;

    private BizDate kykymd;

    private C_UmuKbn tutakinUmukbn;

    private C_UmuKbn sbhsyUmukbn;

    private C_UmuKbn kghsyUmukbn;

    private C_UmuKbn iryhsyUmukbn;

    private C_UmuKbn rougohsyUmukbn;

    private BizDate sakuseiKijyunymd;

    private BizNumber sksiKijyunymdKawaseRate;

    private BizDate kwsrateKijyunymdSakusei;

    private BizCurrency ptumitaTekinYen;

    private BizCurrency ptumitaTekinKyktuuka;

    private C_Tuukasyu kyktuukasyu;

    private C_Tuukasyu rstuukasyu;

    private BizCurrency kaiyakuHrkeiYen;

    private BizCurrency kaiyakuHrkeiKyktuuka;

    private C_UmuKbn kaiyakuhrsuiiUmukbn;

    private String aisyoumei;

    private String kyknmkn;

    private String kyknmkj;

    private BizDate kykseiymd;

    private C_Kyksei kyksei;

    private int sbuktnin;

    private C_UktsyuKbn uktmidasikbn1;

    private C_GkdtKoktuutiUktKbn uktkbn1;

    private String uktnm1;

    private C_UktsyuKbn uktmidasikbn2;

    private C_GkdtKoktuutiUktKbn uktkbn2;

    private String uktnm2;

    private C_UktsyuKbn uktmidasikbn3;

    private C_GkdtKoktuutiUktKbn uktkbn3;

    private String uktnm3;

    private C_UktsyuKbn uktmidasikbn4;

    private C_GkdtKoktuutiUktKbn uktkbn4;

    private String uktnm4;

    private C_UktsyuKbn uktmidasikbn5;

    private C_GkdtKoktuutiUktKbn uktkbn5;

    private String uktnm5;

    private C_UktsyuKbn uktmidasikbn6;

    private C_GkdtKoktuutiUktKbn uktkbn6;

    private String uktnm6;

    private C_UktsyuKbn uktmidasikbn7;

    private C_GkdtKoktuutiUktKbn uktkbn7;

    private String uktnm7;

    private C_UktsyuKbn uktmidasikbn8;

    private C_GkdtKoktuutiUktKbn uktkbn8;

    private String uktnm8;

    private C_UktsyuKbn uktmidasikbn9;

    private C_GkdtKoktuutiUktKbn uktkbn9;

    private String uktnm9;

    private C_UktsyuKbn uktmidasikbn10;

    private C_GkdtKoktuutiUktKbn uktkbn10;

    private String uktnm10;

    private String trkKzknmkn1;

    private String trkKzknmkn2;

    private BizDate hknkknKaisiymd1;

    private BizDate hknkknManryouymd1;

    private int dai1Hknkkn;

    private BizDate hknkknKaisiymd2;

    private BizDate hknkknManryouymd2;

    private int dai2Hknkkn;

    private BizDate hknkknKaisiymd3;

    private BizDate hknkknManryouymd3;

    private C_UmuKbn kykdrtkykhukaUmu;

    private C_UmuKbn stdrsktkyhkUmu;

    private C_UmuKbn yennykntkhkUmu;

    private C_UmuKbn gaikanykntkhkUmu;

    private C_UmuKbn targettkhkUmu;

    private C_UmuKbn initsbjiyenSitihsytkhukaUmu;

    private C_UmuKbn jyudkaigomeharaiTkhukaUmu;

    private C_UmuKbn zeiseitkkkTkykhukaUmu;

    private BizNumber ryymdJitenkwsRate;

    private BizNumber ryymdJitenkwsRateStigi;

    private BizDate kwsrateKijyunymdRy;

    private BizDate kwsrateKijyunymdRyStigi;

    private BizCurrency rsgakuYen;

    private BizCurrency rsgakuStigi;

    private BizCurrency kijyunKingaku;

    private BizCurrency itijibrpRsYen;

    private BizCurrency itijibrpKyktuuka;

    private BizCurrency itijibrpRsKyktuuka;

    private BizCurrency kihonHokenkngk;

    private int mkhgkWari;

    private BizCurrency sibohknkngkYen;

    private BizCurrency sibohknkngkKyktuuka;

    private BizCurrency sgsbhknkngkYen;

    private BizCurrency sgsbhknkngkKyktuuka;

    private C_UmuKbn sgsbhknkngkhyoujiUmu;

    private C_KahiKbn kjsmsaihakkouKahikbn;

    private C_KahiKbn kykmeigihnkKahikbn;

    private C_KahiKbn syoukensaihkKahikbn;

    private C_KahiKbn stdrsktkytthkKahikbn;

    private C_KahiKbn targettkhkKahikbn;

    private C_ErrorKbn hokenkngkksnkekkaKbn;

    private C_KahiKbn kykniyusyoukaiKahikbn;

    private C_KahiKbn tumitatekinitenKahikbn;

    private C_KahiKbn dskaiyakuKahikbn;

    private C_KahiKbn adrhenkouKahikbn;

    private C_KahiKbn phrkhouhenkouKahikbn;

    private C_UmuKbn dai3HknkknhyoujiUmu;

    private String yakkanBunsyoNo;

    private String yoteiRiritu;

    private String tumitateRiritu;

    private String loadinghnkgtmttrrt;

    public DsKeiyakuSyousaiBean() {
        super();
    }

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    public String getSyouhnnm() {
        return syouhnnm;
    }

    public void setSyouhnnm(String pSyouhnnm) {
        syouhnnm = pSyouhnnm;
    }

    public String getHhknnmkn() {
        return hhknnmkn;
    }

    public void setHhknnmkn(String pHhknnmkn) {
        hhknnmkn = pHhknnmkn;
    }

    public BizDate getHhknseiYmd() {
        return hhknseiYmd;
    }

    public void setHhknseiYmd(BizDate pHhknseiYmd) {
        hhknseiYmd = pHhknseiYmd;
    }

    public BizDate getKykymd() {
        return kykymd;
    }

    public void setKykymd(BizDate pKykymd) {
        kykymd = pKykymd;
    }

    public C_UmuKbn getTutakinUmukbn() {
        return tutakinUmukbn;
    }

    public void setTutakinUmukbn(C_UmuKbn pTutakinUmukbn) {
        tutakinUmukbn = pTutakinUmukbn;
    }

    public C_UmuKbn getSbhsyUmukbn() {
        return sbhsyUmukbn;
    }

    public void setSbhsyUmukbn(C_UmuKbn pSbhsyUmukbn) {
        sbhsyUmukbn = pSbhsyUmukbn;
    }

    public C_UmuKbn getKghsyUmukbn() {
        return kghsyUmukbn;
    }

    public void setKghsyUmukbn(C_UmuKbn pKghsyUmukbn) {
        kghsyUmukbn = pKghsyUmukbn;
    }

    public C_UmuKbn getIryhsyUmukbn() {
        return iryhsyUmukbn;
    }

    public void setIryhsyUmukbn(C_UmuKbn pIryhsyUmukbn) {
        iryhsyUmukbn = pIryhsyUmukbn;
    }

    public C_UmuKbn getRougohsyUmukbn() {
        return rougohsyUmukbn;
    }

    public void setRougohsyUmukbn(C_UmuKbn pRougohsyUmukbn) {
        rougohsyUmukbn = pRougohsyUmukbn;
    }

    public BizDate getSakuseiKijyunymd() {
        return sakuseiKijyunymd;
    }

    public void setSakuseiKijyunymd(BizDate pSakuseiKijyunymd) {
        sakuseiKijyunymd = pSakuseiKijyunymd;
    }

    public BizNumber getSksiKijyunymdKawaseRate() {
        return sksiKijyunymdKawaseRate;
    }

    public void setSksiKijyunymdKawaseRate(BizNumber pSksiKijyunymdKawaseRate) {
        sksiKijyunymdKawaseRate = pSksiKijyunymdKawaseRate;
    }

    public BizDate getKwsrateKijyunymdSakusei() {
        return kwsrateKijyunymdSakusei;
    }

    public void setKwsrateKijyunymdSakusei(BizDate pKwsrateKijyunymdSakusei) {
        kwsrateKijyunymdSakusei = pKwsrateKijyunymdSakusei;
    }

    public BizCurrency getPtumitaTekinYen() {
        return ptumitaTekinYen;
    }

    public void setPtumitaTekinYen(BizCurrency pPtumitaTekinYen) {
        ptumitaTekinYen = pPtumitaTekinYen;
    }

    public BizCurrency getPtumitaTekinKyktuuka() {
        return ptumitaTekinKyktuuka;
    }

    public void setPtumitaTekinKyktuuka(BizCurrency pPtumitaTekinKyktuuka) {
        ptumitaTekinKyktuuka = pPtumitaTekinKyktuuka;
    }

    public C_Tuukasyu getKyktuukasyu() {
        return kyktuukasyu;
    }

    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu) {
        kyktuukasyu = pKyktuukasyu;
    }

    public C_Tuukasyu getRstuukasyu() {
        return rstuukasyu;
    }

    public void setRstuukasyu(C_Tuukasyu pRstuukasyu) {
        rstuukasyu = pRstuukasyu;
    }

    public BizCurrency getKaiyakuHrkeiYen() {
        return kaiyakuHrkeiYen;
    }

    public void setKaiyakuHrkeiYen(BizCurrency pKaiyakuHrkeiYen) {
        kaiyakuHrkeiYen = pKaiyakuHrkeiYen;
    }

    public BizCurrency getKaiyakuHrkeiKyktuuka() {
        return kaiyakuHrkeiKyktuuka;
    }

    public void setKaiyakuHrkeiKyktuuka(BizCurrency pKaiyakuHrkeiKyktuuka) {
        kaiyakuHrkeiKyktuuka = pKaiyakuHrkeiKyktuuka;
    }

    public C_UmuKbn getKaiyakuhrsuiiUmukbn() {
        return kaiyakuhrsuiiUmukbn;
    }

    public void setKaiyakuhrsuiiUmukbn(C_UmuKbn pKaiyakuhrsuiiUmukbn) {
        kaiyakuhrsuiiUmukbn = pKaiyakuhrsuiiUmukbn;
    }

    public String getAisyoumei() {
        return aisyoumei;
    }

    public void setAisyoumei(String pAisyoumei) {
        aisyoumei = pAisyoumei;
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

    public C_Kyksei getKyksei() {
        return kyksei;
    }

    public void setKyksei(C_Kyksei pKyksei) {
        kyksei = pKyksei;
    }

    public int getSbuktnin() {
        return sbuktnin;
    }

    public void setSbuktnin(int pSbuktnin) {
        sbuktnin = pSbuktnin;
    }

    public C_UktsyuKbn getUktmidasikbn1() {
        return uktmidasikbn1;
    }

    public void setUktmidasikbn1(C_UktsyuKbn pUktmidasikbn1) {
        uktmidasikbn1 = pUktmidasikbn1;
    }

    public C_GkdtKoktuutiUktKbn getUktkbn1() {
        return uktkbn1;
    }

    public void setUktkbn1(C_GkdtKoktuutiUktKbn pUktkbn1) {
        uktkbn1 = pUktkbn1;
    }

    public String getUktnm1() {
        return uktnm1;
    }

    public void setUktnm1(String pUktnm1) {
        uktnm1 = pUktnm1;
    }

    public C_UktsyuKbn getUktmidasikbn2() {
        return uktmidasikbn2;
    }

    public void setUktmidasikbn2(C_UktsyuKbn pUktmidasikbn2) {
        uktmidasikbn2 = pUktmidasikbn2;
    }

    public C_GkdtKoktuutiUktKbn getUktkbn2() {
        return uktkbn2;
    }

    public void setUktkbn2(C_GkdtKoktuutiUktKbn pUktkbn2) {
        uktkbn2 = pUktkbn2;
    }

    public String getUktnm2() {
        return uktnm2;
    }

    public void setUktnm2(String pUktnm2) {
        uktnm2 = pUktnm2;
    }

    public C_UktsyuKbn getUktmidasikbn3() {
        return uktmidasikbn3;
    }

    public void setUktmidasikbn3(C_UktsyuKbn pUktmidasikbn3) {
        uktmidasikbn3 = pUktmidasikbn3;
    }

    public C_GkdtKoktuutiUktKbn getUktkbn3() {
        return uktkbn3;
    }

    public void setUktkbn3(C_GkdtKoktuutiUktKbn pUktkbn3) {
        uktkbn3 = pUktkbn3;
    }

    public String getUktnm3() {
        return uktnm3;
    }

    public void setUktnm3(String pUktnm3) {
        uktnm3 = pUktnm3;
    }

    public C_UktsyuKbn getUktmidasikbn4() {
        return uktmidasikbn4;
    }

    public void setUktmidasikbn4(C_UktsyuKbn pUktmidasikbn4) {
        uktmidasikbn4 = pUktmidasikbn4;
    }

    public C_GkdtKoktuutiUktKbn getUktkbn4() {
        return uktkbn4;
    }

    public void setUktkbn4(C_GkdtKoktuutiUktKbn pUktkbn4) {
        uktkbn4 = pUktkbn4;
    }

    public String getUktnm4() {
        return uktnm4;
    }

    public void setUktnm4(String pUktnm4) {
        uktnm4 = pUktnm4;
    }

    public C_UktsyuKbn getUktmidasikbn5() {
        return uktmidasikbn5;
    }

    public void setUktmidasikbn5(C_UktsyuKbn pUktmidasikbn5) {
        uktmidasikbn5 = pUktmidasikbn5;
    }

    public C_GkdtKoktuutiUktKbn getUktkbn5() {
        return uktkbn5;
    }

    public void setUktkbn5(C_GkdtKoktuutiUktKbn pUktkbn5) {
        uktkbn5 = pUktkbn5;
    }

    public String getUktnm5() {
        return uktnm5;
    }

    public void setUktnm5(String pUktnm5) {
        uktnm5 = pUktnm5;
    }

    public C_UktsyuKbn getUktmidasikbn6() {
        return uktmidasikbn6;
    }

    public void setUktmidasikbn6(C_UktsyuKbn pUktmidasikbn6) {
        uktmidasikbn6 = pUktmidasikbn6;
    }

    public C_GkdtKoktuutiUktKbn getUktkbn6() {
        return uktkbn6;
    }

    public void setUktkbn6(C_GkdtKoktuutiUktKbn pUktkbn6) {
        uktkbn6 = pUktkbn6;
    }

    public String getUktnm6() {
        return uktnm6;
    }

    public void setUktnm6(String pUktnm6) {
        uktnm6 = pUktnm6;
    }

    public C_UktsyuKbn getUktmidasikbn7() {
        return uktmidasikbn7;
    }

    public void setUktmidasikbn7(C_UktsyuKbn pUktmidasikbn7) {
        uktmidasikbn7 = pUktmidasikbn7;
    }

    public C_GkdtKoktuutiUktKbn getUktkbn7() {
        return uktkbn7;
    }

    public void setUktkbn7(C_GkdtKoktuutiUktKbn pUktkbn7) {
        uktkbn7 = pUktkbn7;
    }

    public String getUktnm7() {
        return uktnm7;
    }

    public void setUktnm7(String pUktnm7) {
        uktnm7 = pUktnm7;
    }

    public C_UktsyuKbn getUktmidasikbn8() {
        return uktmidasikbn8;
    }

    public void setUktmidasikbn8(C_UktsyuKbn pUktmidasikbn8) {
        uktmidasikbn8 = pUktmidasikbn8;
    }

    public C_GkdtKoktuutiUktKbn getUktkbn8() {
        return uktkbn8;
    }

    public void setUktkbn8(C_GkdtKoktuutiUktKbn pUktkbn8) {
        uktkbn8 = pUktkbn8;
    }

    public String getUktnm8() {
        return uktnm8;
    }

    public void setUktnm8(String pUktnm8) {
        uktnm8 = pUktnm8;
    }

    public C_UktsyuKbn getUktmidasikbn9() {
        return uktmidasikbn9;
    }

    public void setUktmidasikbn9(C_UktsyuKbn pUktmidasikbn9) {
        uktmidasikbn9 = pUktmidasikbn9;
    }

    public C_GkdtKoktuutiUktKbn getUktkbn9() {
        return uktkbn9;
    }

    public void setUktkbn9(C_GkdtKoktuutiUktKbn pUktkbn9) {
        uktkbn9 = pUktkbn9;
    }

    public String getUktnm9() {
        return uktnm9;
    }

    public void setUktnm9(String pUktnm9) {
        uktnm9 = pUktnm9;
    }

    public C_UktsyuKbn getUktmidasikbn10() {
        return uktmidasikbn10;
    }

    public void setUktmidasikbn10(C_UktsyuKbn pUktmidasikbn10) {
        uktmidasikbn10 = pUktmidasikbn10;
    }

    public C_GkdtKoktuutiUktKbn getUktkbn10() {
        return uktkbn10;
    }

    public void setUktkbn10(C_GkdtKoktuutiUktKbn pUktkbn10) {
        uktkbn10 = pUktkbn10;
    }

    public String getUktnm10() {
        return uktnm10;
    }

    public void setUktnm10(String pUktnm10) {
        uktnm10 = pUktnm10;
    }

    public String getTrkKzknmkn1() {
        return trkKzknmkn1;
    }

    public void setTrkKzknmkn1(String pTrkKzknmkn1) {
        trkKzknmkn1 = pTrkKzknmkn1;
    }

    public String getTrkKzknmkn2() {
        return trkKzknmkn2;
    }

    public void setTrkKzknmkn2(String pTrkKzknmkn2) {
        trkKzknmkn2 = pTrkKzknmkn2;
    }

    public BizDate getHknkknKaisiymd1() {
        return hknkknKaisiymd1;
    }

    public void setHknkknKaisiymd1(BizDate pHknkknKaisiymd1) {
        hknkknKaisiymd1 = pHknkknKaisiymd1;
    }

    public BizDate getHknkknManryouymd1() {
        return hknkknManryouymd1;
    }

    public void setHknkknManryouymd1(BizDate pHknkknManryouymd1) {
        hknkknManryouymd1 = pHknkknManryouymd1;
    }

    public int getDai1Hknkkn() {
        return dai1Hknkkn;
    }

    public void setDai1Hknkkn(int pDai1Hknkkn) {
        dai1Hknkkn = pDai1Hknkkn;
    }

    public BizDate getHknkknKaisiymd2() {
        return hknkknKaisiymd2;
    }

    public void setHknkknKaisiymd2(BizDate pHknkknKaisiymd2) {
        hknkknKaisiymd2 = pHknkknKaisiymd2;
    }

    public BizDate getHknkknManryouymd2() {
        return hknkknManryouymd2;
    }

    public void setHknkknManryouymd2(BizDate pHknkknManryouymd2) {
        hknkknManryouymd2 = pHknkknManryouymd2;
    }

    public int getDai2Hknkkn() {
        return dai2Hknkkn;
    }

    public void setDai2Hknkkn(int pDai2Hknkkn) {
        dai2Hknkkn = pDai2Hknkkn;
    }

    public BizDate getHknkknKaisiymd3() {
        return hknkknKaisiymd3;
    }

    public void setHknkknKaisiymd3(BizDate pHknkknKaisiymd3) {
        hknkknKaisiymd3 = pHknkknKaisiymd3;
    }

    public BizDate getHknkknManryouymd3() {
        return hknkknManryouymd3;
    }

    public void setHknkknManryouymd3(BizDate pHknkknManryouymd3) {
        hknkknManryouymd3 = pHknkknManryouymd3;
    }

    public C_UmuKbn getKykdrtkykhukaUmu() {
        return kykdrtkykhukaUmu;
    }

    public void setKykdrtkykhukaUmu(C_UmuKbn pKykdrtkykhukaUmu) {
        kykdrtkykhukaUmu = pKykdrtkykhukaUmu;
    }

    public C_UmuKbn getStdrsktkyhkUmu() {
        return stdrsktkyhkUmu;
    }

    public void setStdrsktkyhkUmu(C_UmuKbn pStdrsktkyhkUmu) {
        stdrsktkyhkUmu = pStdrsktkyhkUmu;
    }

    public C_UmuKbn getYennykntkhkUmu() {
        return yennykntkhkUmu;
    }

    public void setYennykntkhkUmu(C_UmuKbn pYennykntkhkUmu) {
        yennykntkhkUmu = pYennykntkhkUmu;
    }

    public C_UmuKbn getGaikanykntkhkUmu() {
        return gaikanykntkhkUmu;
    }

    public void setGaikanykntkhkUmu(C_UmuKbn pGaikanykntkhkUmu) {
        gaikanykntkhkUmu = pGaikanykntkhkUmu;
    }

    public C_UmuKbn getTargettkhkUmu() {
        return targettkhkUmu;
    }

    public void setTargettkhkUmu(C_UmuKbn pTargettkhkUmu) {
        targettkhkUmu = pTargettkhkUmu;
    }

    public C_UmuKbn getInitsbjiyenSitihsytkhukaUmu() {
        return initsbjiyenSitihsytkhukaUmu;
    }

    public void setInitsbjiyenSitihsytkhukaUmu(C_UmuKbn pInitsbjiyenSitihsytkhukaUmu) {
        initsbjiyenSitihsytkhukaUmu = pInitsbjiyenSitihsytkhukaUmu;
    }

    public C_UmuKbn getJyudkaigomeharaiTkhukaUmu() {
        return jyudkaigomeharaiTkhukaUmu;
    }

    public void setJyudkaigomeharaiTkhukaUmu(C_UmuKbn pJyudkaigomeharaiTkhukaUmu) {
        jyudkaigomeharaiTkhukaUmu = pJyudkaigomeharaiTkhukaUmu;
    }

    public C_UmuKbn getZeiseitkkkTkykhukaUmu() {
        return zeiseitkkkTkykhukaUmu;
    }

    public void setZeiseitkkkTkykhukaUmu(C_UmuKbn pZeiseitkkkTkykhukaUmu) {
        zeiseitkkkTkykhukaUmu = pZeiseitkkkTkykhukaUmu;
    }

    public BizNumber getRyymdJitenkwsRate() {
        return ryymdJitenkwsRate;
    }

    public void setRyymdJitenkwsRate(BizNumber pRyymdJitenkwsRate) {
        ryymdJitenkwsRate = pRyymdJitenkwsRate;
    }

    public BizNumber getRyymdJitenkwsRateStigi() {
        return ryymdJitenkwsRateStigi;
    }

    public void setRyymdJitenkwsRateStigi(BizNumber pRyymdJitenkwsRateStigi) {
        ryymdJitenkwsRateStigi = pRyymdJitenkwsRateStigi;
    }

    public BizDate getKwsrateKijyunymdRy() {
        return kwsrateKijyunymdRy;
    }

    public void setKwsrateKijyunymdRy(BizDate pKwsrateKijyunymdRy) {
        kwsrateKijyunymdRy = pKwsrateKijyunymdRy;
    }

    public BizDate getKwsrateKijyunymdRyStigi() {
        return kwsrateKijyunymdRyStigi;
    }

    public void setKwsrateKijyunymdRyStigi(BizDate pKwsrateKijyunymdRyStigi) {
        kwsrateKijyunymdRyStigi = pKwsrateKijyunymdRyStigi;
    }

    public BizCurrency getRsgakuYen() {
        return rsgakuYen;
    }

    public void setRsgakuYen(BizCurrency pRsgakuYen) {
        rsgakuYen = pRsgakuYen;
    }

    public BizCurrency getRsgakuStigi() {
        return rsgakuStigi;
    }

    public void setRsgakuStigi(BizCurrency pRsgakuStigi) {
        rsgakuStigi = pRsgakuStigi;
    }

    public BizCurrency getKijyunKingaku() {
        return kijyunKingaku;
    }

    public void setKijyunKingaku(BizCurrency pKijyunKingaku) {
        kijyunKingaku = pKijyunKingaku;
    }

    public BizCurrency getItijibrpRsYen() {
        return itijibrpRsYen;
    }

    public void setItijibrpRsYen(BizCurrency pItijibrpRsYen) {
        itijibrpRsYen = pItijibrpRsYen;
    }

    public BizCurrency getItijibrpKyktuuka() {
        return itijibrpKyktuuka;
    }

    public void setItijibrpKyktuuka(BizCurrency pItijibrpKyktuuka) {
        itijibrpKyktuuka = pItijibrpKyktuuka;
    }

    public BizCurrency getItijibrpRsKyktuuka() {
        return itijibrpRsKyktuuka;
    }

    public void setItijibrpRsKyktuuka(BizCurrency pItijibrpRsKyktuuka) {
        itijibrpRsKyktuuka = pItijibrpRsKyktuuka;
    }

    public BizCurrency getKihonHokenkngk() {
        return kihonHokenkngk;
    }

    public void setKihonHokenkngk(BizCurrency pKihonHokenkngk) {
        kihonHokenkngk = pKihonHokenkngk;
    }

    public int getMkhgkWari() {
        return mkhgkWari;
    }

    public void setMkhgkWari(int pMkhgkWari) {
        mkhgkWari = pMkhgkWari;
    }

    public BizCurrency getSibohknkngkYen() {
        return sibohknkngkYen;
    }

    public void setSibohknkngkYen(BizCurrency pSibohknkngkYen) {
        sibohknkngkYen = pSibohknkngkYen;
    }

    public BizCurrency getSibohknkngkKyktuuka() {
        return sibohknkngkKyktuuka;
    }

    public void setSibohknkngkKyktuuka(BizCurrency pSibohknkngkKyktuuka) {
        sibohknkngkKyktuuka = pSibohknkngkKyktuuka;
    }

    public BizCurrency getSgsbhknkngkYen() {
        return sgsbhknkngkYen;
    }

    public void setSgsbhknkngkYen(BizCurrency pSgsbhknkngkYen) {
        sgsbhknkngkYen = pSgsbhknkngkYen;
    }

    public BizCurrency getSgsbhknkngkKyktuuka() {
        return sgsbhknkngkKyktuuka;
    }

    public void setSgsbhknkngkKyktuuka(BizCurrency pSgsbhknkngkKyktuuka) {
        sgsbhknkngkKyktuuka = pSgsbhknkngkKyktuuka;
    }

    public C_UmuKbn getSgsbhknkngkhyoujiUmu() {
        return sgsbhknkngkhyoujiUmu;
    }

    public void setSgsbhknkngkhyoujiUmu(C_UmuKbn pSgsbhknkngkhyoujiUmu) {
        sgsbhknkngkhyoujiUmu = pSgsbhknkngkhyoujiUmu;
    }

    public C_KahiKbn getKjsmsaihakkouKahikbn() {
        return kjsmsaihakkouKahikbn;
    }

    public void setKjsmsaihakkouKahikbn(C_KahiKbn pKjsmsaihakkouKahikbn) {
        kjsmsaihakkouKahikbn = pKjsmsaihakkouKahikbn;
    }

    public C_KahiKbn getKykmeigihnkKahikbn() {
        return kykmeigihnkKahikbn;
    }

    public void setKykmeigihnkKahikbn(C_KahiKbn pKykmeigihnkKahikbn) {
        kykmeigihnkKahikbn = pKykmeigihnkKahikbn;
    }

    public C_KahiKbn getSyoukensaihkKahikbn() {
        return syoukensaihkKahikbn;
    }

    public void setSyoukensaihkKahikbn(C_KahiKbn pSyoukensaihkKahikbn) {
        syoukensaihkKahikbn = pSyoukensaihkKahikbn;
    }

    public C_KahiKbn getStdrsktkytthkKahikbn() {
        return stdrsktkytthkKahikbn;
    }

    public void setStdrsktkytthkKahikbn(C_KahiKbn pStdrsktkytthkKahikbn) {
        stdrsktkytthkKahikbn = pStdrsktkytthkKahikbn;
    }

    public C_KahiKbn getTargettkhkKahikbn() {
        return targettkhkKahikbn;
    }

    public void setTargettkhkKahikbn(C_KahiKbn pTargettkhkKahikbn) {
        targettkhkKahikbn = pTargettkhkKahikbn;
    }

    public C_ErrorKbn getHokenkngkksnkekkaKbn() {
        return hokenkngkksnkekkaKbn;
    }

    public void setHokenkngkksnkekkaKbn(C_ErrorKbn pHokenkngkksnkekkaKbn) {
        hokenkngkksnkekkaKbn = pHokenkngkksnkekkaKbn;
    }

    public C_KahiKbn getKykniyusyoukaiKahikbn() {
        return kykniyusyoukaiKahikbn;
    }

    public void setKykniyusyoukaiKahikbn(C_KahiKbn pKykniyusyoukaiKahikbn) {
        kykniyusyoukaiKahikbn = pKykniyusyoukaiKahikbn;
    }

    public C_KahiKbn getTumitatekinitenKahikbn() {
        return tumitatekinitenKahikbn;
    }

    public void setTumitatekinitenKahikbn(C_KahiKbn pTumitatekinitenKahikbn) {
        tumitatekinitenKahikbn = pTumitatekinitenKahikbn;
    }

    public C_KahiKbn getDskaiyakuKahikbn() {
        return dskaiyakuKahikbn;
    }

    public void setDskaiyakuKahikbn(C_KahiKbn pDskaiyakuKahikbn) {
        dskaiyakuKahikbn = pDskaiyakuKahikbn;
    }

    public C_KahiKbn getAdrhenkouKahikbn() {
        return adrhenkouKahikbn;
    }

    public void setAdrhenkouKahikbn(C_KahiKbn pAdrhenkouKahikbn) {
        adrhenkouKahikbn = pAdrhenkouKahikbn;
    }

    public C_KahiKbn getPhrkhouhenkouKahikbn() {
        return phrkhouhenkouKahikbn;
    }

    public void setPhrkhouhenkouKahikbn(C_KahiKbn pPhrkhouhenkouKahikbn) {
        phrkhouhenkouKahikbn = pPhrkhouhenkouKahikbn;
    }

    public C_UmuKbn getDai3HknkknhyoujiUmu() {
        return dai3HknkknhyoujiUmu;
    }

    public void setDai3HknkknhyoujiUmu(C_UmuKbn pDai3HknkknhyoujiUmu) {
        dai3HknkknhyoujiUmu = pDai3HknkknhyoujiUmu;
    }

    public String getYakkanBunsyoNo() {
        return yakkanBunsyoNo;
    }

    public void setYakkanBunsyoNo(String pYakkanBunsyoNo) {
        yakkanBunsyoNo = pYakkanBunsyoNo;
    }

    public String getYoteiRiritu() {
        return yoteiRiritu;
    }

    public void setYoteiRiritu(String pYoteiRiritu) {
        yoteiRiritu = pYoteiRiritu;
    }

    public String getTumitateRiritu() {
        return tumitateRiritu;
    }

    public void setTumitateRiritu(String pTumitateRiritu) {
        tumitateRiritu = pTumitateRiritu;
    }

    public String getLoadinghnkgtmttrrt() {
        return loadinghnkgtmttrrt;
    }

    public void setLoadinghnkgtmttrrt(String pLoadinghnkgtmttrrt) {
        loadinghnkgtmttrrt = pLoadinghnkgtmttrrt;
    }
}
