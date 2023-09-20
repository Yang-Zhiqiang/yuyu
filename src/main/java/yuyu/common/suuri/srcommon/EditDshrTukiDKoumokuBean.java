package yuyu.common.suuri.srcommon;

import java.io.Serializable;
import java.util.List;

import yuyu.def.classification.C_HaitoukinsksKbn;
import yuyu.def.classification.C_HaitoumeisaiKbn;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_TumitateDSakuseiKbn;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

/**
 * 数理 数理共通 Ｄ支払統計配当金項目編集用Bean
 */
public class EditDshrTukiDKoumokuBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BizDate calckijyunYmd;

    private BizDate syoriYmd2;

    private BizDateYM jkipjytYm;

    private BizDate kinoubetukijyunYmd;

    private BizNumber gengkwari;

    private BizCurrency itibushrGk;

    private BizCurrency haitoushrKin;

    private BizCurrency kariwariatedruiGk ;

    private BizCurrency kariwariatedgngkknGk;

    private BizCurrency kariwariatedshrGk;

    private BizCurrency dkeisanhaitouKin;

    private C_NaiteiKakuteiKbn dkeisannaiteikakuteiKbn;

    private BizDateY haitounendo ;

    private BizCurrency haitoushrkinGk;

    private BizCurrency kariwariatedganrikinDshr ;

    private BizCurrency tumitated;

    private BizCurrency tumitatedModosimae ;

    private BizCurrency tumitatedModosigo ;

    private BizCurrency tkbtHaitou;

    private BizDateY haitounendo2;

    private C_HaitoukinsksKbn haitoukinsksKbn ;

    private C_HaitoumeisaiKbn haitoumeisaikbn;

    private BizDateY fstkariwariatedNendo;

    private BizCurrency tounendod;

    private C_NaiteiKakuteiKbn naiteikakuteiKbn;

    private BizDate kariwariatedshrYmd;

    private BizCurrency kariwariatedruiGk2;

    private BizCurrency kariwariatedgngkknGk2;

    private BizCurrency kariwariatedshrGk2;

    private BizDate tumitatedtumitateYmd;

    private C_TumitateDSakuseiKbn tumitatedsksKbn;

    private BizCurrency tumitated2;

    private BizDate tumitatedshrkrkYmd;

    private C_NaiteiKakuteiKbn naiteikakuteiKbn2;

    private BizCurrency haitouganrikincalcKari;

    private List<BizNumber> ganrikincalcKariwariatedRirituLst;

    private BizCurrency haitouganrikincalcTumi;

    private List<BizNumber> ganrikincalcTumitatedRirituLst;

    public EditDshrTukiDKoumokuBean() {
        super();
    }

    public BizDate getCalckijyunYmd() {
        return calckijyunYmd;
    }

    public void setCalckijyunYmd(BizDate pCalckijyunYmd) {
        calckijyunYmd = pCalckijyunYmd;
    }

    public BizDate getSyoriYmd2() {
        return syoriYmd2;
    }

    public void setSyoriYmd2(BizDate pSyoriYmd2) {
        syoriYmd2 = pSyoriYmd2;
    }

    public BizDateYM getJkipjytYm() {
        return jkipjytYm;
    }

    public void setJkipjytYm(BizDateYM pJkipjytYm) {
        jkipjytYm = pJkipjytYm;
    }

    public BizDate getKinoubetukijyunYmd() {
        return kinoubetukijyunYmd;
    }

    public void setKinoubetukijyunYmd(BizDate pKinoubetukijyunYmd) {
        kinoubetukijyunYmd = pKinoubetukijyunYmd;
    }

    public BizNumber getGengkwari() {
        return gengkwari;
    }

    public void setGengkwari(BizNumber pGengkwari) {
        gengkwari = pGengkwari;
    }

    public BizCurrency getItibushrGk() {
        return itibushrGk;
    }

    public void setItibushrGk(BizCurrency pItibushrGk) {
        itibushrGk = pItibushrGk;
    }

    public BizCurrency getHaitoushrKin() {
        return haitoushrKin;
    }

    public void setHaitoushrKin(BizCurrency pHaitoushrKin) {
        haitoushrKin = pHaitoushrKin;
    }

    public BizCurrency getKariwariatedruiGk () {
        return kariwariatedruiGk ;
    }

    public void setKariwariatedruiGk (BizCurrency pKariwariatedruiGk ) {
        kariwariatedruiGk = pKariwariatedruiGk ;
    }

    public BizCurrency getKariwariatedgngkknGk() {
        return kariwariatedgngkknGk;
    }

    public void setKariwariatedgngkknGk(BizCurrency pKariwariatedgngkknGk) {
        kariwariatedgngkknGk = pKariwariatedgngkknGk;
    }

    public BizCurrency getKariwariatedshrGk() {
        return kariwariatedshrGk;
    }

    public void setKariwariatedshrGk(BizCurrency pKariwariatedshrGk) {
        kariwariatedshrGk = pKariwariatedshrGk;
    }

    public BizCurrency getDkeisanhaitouKin() {
        return dkeisanhaitouKin;
    }

    public void setDkeisanhaitouKin(BizCurrency pDkeisanhaitouKin) {
        dkeisanhaitouKin = pDkeisanhaitouKin;
    }

    public C_NaiteiKakuteiKbn getDkeisannaiteikakuteiKbn() {
        return dkeisannaiteikakuteiKbn;
    }

    public void setDkeisannaiteikakuteiKbn(C_NaiteiKakuteiKbn pDkeisannaiteikakuteiKbn) {
        dkeisannaiteikakuteiKbn = pDkeisannaiteikakuteiKbn;
    }

    public BizDateY getHaitounendo () {
        return haitounendo ;
    }

    public void setHaitounendo (BizDateY pHaitounendo ) {
        haitounendo = pHaitounendo ;
    }

    public BizCurrency getHaitoushrkinGk() {
        return haitoushrkinGk;
    }

    public void setHaitoushrkinGk(BizCurrency pHaitoushrkinGk) {
        haitoushrkinGk = pHaitoushrkinGk;
    }

    public BizCurrency getKariwariatedganrikinDshr () {
        return kariwariatedganrikinDshr ;
    }

    public void setKariwariatedganrikinDshr (BizCurrency pKariwariatedganrikinDshr ) {
        kariwariatedganrikinDshr = pKariwariatedganrikinDshr ;
    }

    public BizCurrency getTumitated() {
        return tumitated;
    }

    public void setTumitated(BizCurrency pTumitated) {
        tumitated = pTumitated;
    }

    public BizCurrency getTumitatedModosimae () {
        return tumitatedModosimae ;
    }

    public void setTumitatedModosimae (BizCurrency pTumitatedModosimae ) {
        tumitatedModosimae = pTumitatedModosimae ;
    }

    public BizCurrency getTumitatedModosigo () {
        return tumitatedModosigo ;
    }

    public void setTumitatedModosigo (BizCurrency pTumitatedModosigo ) {
        tumitatedModosigo = pTumitatedModosigo ;
    }

    public BizCurrency getTkbtHaitou() {
        return tkbtHaitou;
    }

    public void setTkbtHaitou(BizCurrency pTkbtHaitou) {
        tkbtHaitou = pTkbtHaitou;
    }

    public BizDateY getHaitounendo2() {
        return haitounendo2;
    }

    public void setHaitounendo2(BizDateY pHaitounendo2) {
        haitounendo2 = pHaitounendo2;
    }

    public C_HaitoukinsksKbn getHaitoukinsksKbn () {
        return haitoukinsksKbn ;
    }

    public void setHaitoukinskskbn (C_HaitoukinsksKbn pHaitoukinsksKbn ) {
        haitoukinsksKbn = pHaitoukinsksKbn ;
    }

    public C_HaitoumeisaiKbn getHaitoumeisaikbn() {
        return haitoumeisaikbn;
    }

    public void setHaitoumeisaikbn(C_HaitoumeisaiKbn pHaitoumeisaikbn) {
        haitoumeisaikbn = pHaitoumeisaikbn;
    }

    public BizDateY getFstkariwariatedNendo() {
        return fstkariwariatedNendo;
    }

    public void setFstkariwariatedNendo(BizDateY pFstkariwariatedNendo) {
        fstkariwariatedNendo = pFstkariwariatedNendo;
    }

    public BizCurrency getTounendod() {
        return tounendod;
    }

    public void setTounendod(BizCurrency pTounendod) {
        tounendod = pTounendod;
    }

    public C_NaiteiKakuteiKbn getNaiteikakuteiKbn() {
        return naiteikakuteiKbn;
    }

    public void setNaiteikakuteiKbn(C_NaiteiKakuteiKbn pNaiteikakuteiKbn) {
        naiteikakuteiKbn = pNaiteikakuteiKbn;
    }

    public BizDate getKariwariatedshrYmd() {
        return kariwariatedshrYmd;
    }

    public void setKariwariatedshrYmd(BizDate pKariwariatedshrYmd) {
        kariwariatedshrYmd = pKariwariatedshrYmd;
    }

    public BizCurrency getKariwariatedruiGk2() {
        return kariwariatedruiGk2;
    }

    public void setKariwariatedruiGk2(BizCurrency pKariwariatedruiGk2) {
        kariwariatedruiGk2 = pKariwariatedruiGk2;
    }

    public BizCurrency getKariwariatedgngkknGk2() {
        return kariwariatedgngkknGk2;
    }

    public void setKariwariatedgngkknGk2(BizCurrency pKariwariatedgngkknGk2) {
        kariwariatedgngkknGk2 = pKariwariatedgngkknGk2;
    }

    public BizCurrency getKariwariatedshrGk2() {
        return kariwariatedshrGk2;
    }

    public void setKariwariatedshrGk2(BizCurrency pKariwariatedshrGk2) {
        kariwariatedshrGk2 = pKariwariatedshrGk2;
    }

    public BizDate getTumitatedtumitateYmd() {
        return tumitatedtumitateYmd;
    }

    public void setTumitatedtumitateYmd(BizDate pTumitatedtumitateYmd) {
        tumitatedtumitateYmd = pTumitatedtumitateYmd;
    }

    public C_TumitateDSakuseiKbn getTumitatedsksKbn() {
        return tumitatedsksKbn;
    }

    public void setTumitatedsksKbn(C_TumitateDSakuseiKbn pTumitatedsksKbn) {
        tumitatedsksKbn = pTumitatedsksKbn;
    }

    public BizCurrency getTumitated2() {
        return tumitated2;
    }

    public void setTumitated2(BizCurrency pTumitated2) {
        tumitated2 = pTumitated2;
    }

    public BizDate getTumitatedshrkrkYmd() {
        return tumitatedshrkrkYmd;
    }

    public void setTumitatedshrkrkYmd(BizDate pTumitatedshrkrkYmd) {
        tumitatedshrkrkYmd = pTumitatedshrkrkYmd;
    }

    public C_NaiteiKakuteiKbn getNaiteikakuteiKbn2() {
        return naiteikakuteiKbn2;
    }

    public void setNaiteikakuteiKbn2(C_NaiteiKakuteiKbn pNaiteikakuteiKbn2) {
        naiteikakuteiKbn2 = pNaiteikakuteiKbn2;
    }

    public BizCurrency getHaitouganrikincalcKari() {
        return haitouganrikincalcKari;
    }

    public void setHaitouganrikincalcKari(BizCurrency pHaitouganrikincalcKari) {
        haitouganrikincalcKari = pHaitouganrikincalcKari;
    }

    public List<BizNumber> getGanrikincalcKariwariatedRirituLst() {
        return ganrikincalcKariwariatedRirituLst;
    }

    public void setGanrikincalcKariwariatedRirituLst(List<BizNumber> pGanrikincalcKariwariatedRirituLst) {
        ganrikincalcKariwariatedRirituLst = pGanrikincalcKariwariatedRirituLst;
    }

    public BizCurrency getHaitouganrikincalcTumi() {
        return haitouganrikincalcTumi;
    }

    public void setHaitouganrikincalcTumi(BizCurrency pHaitouganrikinCalcTumi) {
        haitouganrikincalcTumi = pHaitouganrikinCalcTumi;
    }

    public List<BizNumber> getGanrikincalcTumitatedRirituLst() {
        return ganrikincalcTumitatedRirituLst;
    }

    public void setGanrikincalcTumitatedRirituLst(List<BizNumber> pGanrikincalcTumitatedRirituLst) {
        ganrikincalcTumitatedRirituLst = pGanrikincalcTumitatedRirituLst;
    }

}
