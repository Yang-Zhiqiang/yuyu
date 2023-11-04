package yuyu.common.hozen.setuibean;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_FstphrkkeiroKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_SinkeizkKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_Yuukoukakkekka;

/**
 * 契約保全 UiBean設定 年金受取人情報設定UiBean
 */
public class SetHaraikomiInfoExecUiBeanParamImpl implements SetHaraikomiInfoExecUiBeanParam {

    private String syono;

    @Override
    public String getSyono(){
        return syono;
    }

    public void setSyono(String pSyono){
        this.syono = pSyono;
    }

    private BizDateYM vhrkijkipjytym;

    public BizDateYM getVhrkijkipjytym() {
        return vhrkijkipjytym;
    }

    @Override
    public void setVhrkijkipjytym(BizDateYM pVhrkijkipjytym) {
        this.vhrkijkipjytym = pVhrkijkipjytym;
    }

    private C_FstphrkkeiroKbn vhrkifstphrkkeirokbn;

    @Override
    public void setVhrkifstphrkkeirokbn(C_FstphrkkeiroKbn pVhrkifstphrkkeirokbn){
        this.vhrkifstphrkkeirokbn = pVhrkifstphrkkeirokbn;
    }

    public C_FstphrkkeiroKbn getVhrkifstphrkkeirokbn() {
        return vhrkifstphrkkeirokbn;
    }

    private C_Hrkkaisuu vhrkihrkkaisuu;

    @Override
    public void setVhrkihrkkaisuu(C_Hrkkaisuu pVhrkihrkkaisuu){
        this.vhrkihrkkaisuu = pVhrkihrkkaisuu;
    }

    public C_Hrkkaisuu getVhrkihrkkaisuu() {
        return vhrkihrkkaisuu;
    }

    private C_Hrkkeiro vhrkihrkkeiro;

    @Override
    public void setVhrkihrkkeiro(C_Hrkkeiro pVhrkihrkkeiro){
        this.vhrkihrkkeiro = pVhrkihrkkeiro;
    }

    public C_Hrkkeiro getVhrkihrkkeiro() {
        return vhrkihrkkeiro;
    }

    private BizCurrency vhrkihrkp;

    @Override
    public void setVhrkihrkp(BizCurrency pVhrkihrkp){
        this.vhrkihrkp = pVhrkihrkp;
    }

    public BizCurrency getVhrkihrkp() {
        return vhrkihrkp;
    }

    private BizCurrency vhrkikihrkp;

    @Override
    public void setVhrkikihrkp(BizCurrency pVhrkikihrkp){
        this.vhrkikihrkp = pVhrkikihrkp;
    }

    public BizCurrency getVhrkikihrkp() {
        return vhrkikihrkp;
    }

    private C_UmuKbn nextkosumu;

    @Override
    public void setNextkosumu(C_UmuKbn pNextkosumu){
        this.nextkosumu = pNextkosumu;
    }

    public C_UmuKbn getNextkosumu() {
        return nextkosumu;
    }

    private BizCurrency vhrkinextkosgohrkp;

    @Override
    public void setVhrkinextkosgohrkp(BizCurrency pVhrkinextkosgohrkp){
        this.vhrkinextkosgohrkp = pVhrkinextkosgohrkp;
    }

    public BizCurrency getVhrkinextkosgohrkp() {
        return vhrkinextkosgohrkp;
    }

    private String vhrkihrkinfobankcd;

    @Override
    public void setVhrkihrkinfobankcd(String pVhrkihrkinfobankcd){
        this.vhrkihrkinfobankcd = pVhrkihrkinfobankcd;
    }

    public String getVhrkihrkinfobankcd() {
        return vhrkihrkinfobankcd;
    }

    private String vhrkihrkinfobanknmkj;

    @Override
    public  void setVhrkihrkinfobanknmkj(String pVhrkihrkinfobanknmkj){
        this.vhrkihrkinfobanknmkj = pVhrkihrkinfobanknmkj;
    }


    public String getVhrkihrkinfobanknmkj() {
        return vhrkihrkinfobanknmkj;
    }


    private String vhrkihrkinfositencd;

    @Override
    public void setVhrkihrkinfositencd(String pVhrkihrkinfositencd){
        this.vhrkihrkinfositencd = pVhrkihrkinfositencd;
    }

    public String getVhrkihrkinfositencd() {
        return vhrkihrkinfositencd;
    }

    private String vhrkihrkinfositennmkj;

    @Override
    public void setVhrkihrkinfositennmkj(String pVhrkihrkinfositennmkj){
        this.vhrkihrkinfositennmkj = pVhrkihrkinfositennmkj;
    }

    public String getVhrkihrkinfositennmkj() {
        return vhrkihrkinfositennmkj;
    }

    private C_YokinKbn vhrkihrkinfoyokinkbn;

    @Override
    public void setVhrkihrkinfoyokinkbn(C_YokinKbn pVhrkihrkinfoyokinkbn){
        this.vhrkihrkinfoyokinkbn = pVhrkihrkinfoyokinkbn;
    }

    public C_YokinKbn getVhrkihrkinfoyokinkbn() {
        return vhrkihrkinfoyokinkbn;
    }

    private String vhrkihrkinfokouzano;

    @Override
    public void setVhrkihrkinfokouzano(String pVhrkihrkinfokouzano){
        this.vhrkihrkinfokouzano = pVhrkihrkinfokouzano;
    }

    public String getVhrkihrkinfokouzano() {
        return vhrkihrkinfokouzano;
    }


    private String vhrkihrkinfokzmeiginmkn;

    @Override
    public void setVhrkihrkinfokzmeiginmkn(String pVhrkihrkinfokzmeiginmkn){
        this.vhrkihrkinfokzmeiginmkn = pVhrkihrkinfokzmeiginmkn;
    }

    public String getVhrkihrkinfokzmeiginmkn() {
        return vhrkihrkinfokzmeiginmkn;
    }

    private C_SinkeizkKbn vhrkihrkinfosinkeizkkbn;

    @Override
    public void setVhrkihrkinfosinkeizkkbn(C_SinkeizkKbn pVhrkihrkinfosinkeizkkbn){
        this.vhrkihrkinfosinkeizkkbn = pVhrkihrkinfosinkeizkkbn;
    }

    public C_SinkeizkKbn getVhrkihrkinfosinkeizkkbn() {
        return vhrkihrkinfosinkeizkkbn;
    }

    private BizCurrency vhrkiyenkansannyknkingk;

    @Override
    public void setVhrkiyenkansannyknkingk(BizCurrency pVhrkiyenkansannyknkingk){
        this.vhrkiyenkansannyknkingk = pVhrkiyenkansannyknkingk;
    }

    public BizCurrency getVhrkiyenkansannyknkingk() {
        return vhrkiyenkansannyknkingk;
    }

    private BizDate vhrkiyentkykwsrateymd;

    @Override
    public void setVhrkiyentkykwsrateymd(BizDate vhrkiyentkykwsrateymd){
        this.vhrkiyentkykwsrateymd = vhrkiyentkykwsrateymd;
    }

    public BizDate getVhrkiyentkykwsrateymd() {
        return vhrkiyentkykwsrateymd;
    }


    private BizNumber vhrkiyentkykwsrate;

    @Override
    public void setVhrkiyentkykwsrate(BizNumber pVhrkiyentkykwsrate){
        this.vhrkiyentkykwsrate = pVhrkiyentkykwsrate;
    }

    public BizNumber getVhrkiyentkykwsrate() {
        return vhrkiyentkykwsrate;
    }

    private C_Tuukasyu vhrkiyentkykwsratetuukasyu;

    @Override
    public void setVhrkiyentkykwsratetuukasyu(C_Tuukasyu pVhrkiyentkykwsratetuukasyu) {
        this.vhrkiyentkykwsratetuukasyu = pVhrkiyentkykwsratetuukasyu;

    }

    public C_Tuukasyu getVhrkiyentkykwsratetuukasyu() {
        return vhrkiyentkykwsratetuukasyu;
    }

    private BizCurrency vhrkiitijibrp;

    @Override
    public void setVhrkiitijibrp(BizCurrency pVhrkiitijibrp) {
        this.vhrkiitijibrp = pVhrkiitijibrp;
    }

    public BizCurrency getVhrkiitijibrp() {
        return vhrkiitijibrp;
    }

    private C_UmuKbn yennykntkhkumu;

    @Override
    public void setYennykntkhkumu(C_UmuKbn pYennykntkhkumu) {
        this.yennykntkhkumu = pYennykntkhkumu;
    }

    public C_UmuKbn getYennykntkhkumu() {
        return yennykntkhkumu;
    }

    private C_Tuukasyu kyktuukasyu;

    @Override
    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu) {
        this.kyktuukasyu = pKyktuukasyu;
    }

    public C_Tuukasyu getKyktuukasyu() {
        return kyktuukasyu;
    }

    private String vhrkihrkinfotuutyoukigou;

    @Override
    public void setVhrkihrkinfotuutyoukigou(String pVhrkihrkinfotuutyoukigou) {
        this.vhrkihrkinfotuutyoukigou = pVhrkihrkinfotuutyoukigou;
    }

    public String getVhrkihrkinfotuutyoukigou() {
        return vhrkihrkinfotuutyoukigou;
    }

    private C_KzkykdouKbn vhrkikzdoukbn;

    @Override
    public void setVhrkikzdoukbn(C_KzkykdouKbn pVhrkikzdoukbn) {
        this.vhrkikzdoukbn = pVhrkikzdoukbn;
    }

    public C_KzkykdouKbn getVhrkikzdoukbn() {
        return vhrkikzdoukbn;
    }

    private C_TkiktbrisyuruiKbn vhrkitikiktbrijk;

    public C_TkiktbrisyuruiKbn getVhrkitikiktbrijk() {
        return vhrkitikiktbrijk;
    }

    @Override
    public void setVhrkitikiktbrijk(C_TkiktbrisyuruiKbn pVhrkitikiktbrijk) {
        this.vhrkitikiktbrijk = pVhrkitikiktbrijk;
    }

    private C_Kykjyoutai vhrkikykjyoutai;

    public C_Kykjyoutai getVhrkikykjyoutai() {
        return vhrkikykjyoutai;
    }

    @Override
    public void setVhrkikykjyoutai(C_Kykjyoutai pVhrkikykjyoutai) {
        this.vhrkikykjyoutai = pVhrkikykjyoutai;
    }

    private C_UmuKbn vhrkizenkizennouumu;

    public C_UmuKbn getVhrkizenkizennouumu() {
        return vhrkizenkizennouumu;
    }

    @Override
    public void setVhrkizenkizennouumu(C_UmuKbn pVhrkizenkizennouumu) {
        this.vhrkizenkizennouumu = pVhrkizenkizennouumu;
    }

    private BizDateYM vhrkizennoustartym;

    public BizDateYM getVhrkizennoustartym() {
        return vhrkizennoustartym;
    }

    @Override
    public void setVhrkizennoustartym(BizDateYM pVhrkizennoustartym) {
        this.vhrkizennoustartym = pVhrkizennoustartym;
    }

    private String vhrkizennoukkn;

    public String getVhrkizennoukkn() {
        return vhrkizennoukkn;
    }

    @Override
    public void setVhrkizennoukkn(String pVhrkizennoukkn) {
        this.vhrkizennoukkn = pVhrkizennoukkn;
    }

    private BizCurrency vhrkizennounyuukingk;

    public BizCurrency getVhrkizennounyuukingk() {
        return vhrkizennounyuukingk;
    }

    @Override
    public void setVhrkizennounyuukingk(BizCurrency pVhrkizennounyuukingk) {
        this.vhrkizennounyuukingk = pVhrkizennounyuukingk;
    }

    private BizDate vhrkizennounyuukinymd;

    public BizDate getVhrkizennounyuukinymd() {
        return vhrkizennounyuukinymd;
    }

    @Override
    public void setVhrkizennounyuukinymd(BizDate pVhrkizennounyuukinymd) {
        this.vhrkizennounyuukinymd = pVhrkizennounyuukinymd;
    }

    private String vhrkicreditkessaiyouno;

    public String getVhrkicreditkessaiyouno() {
        return vhrkicreditkessaiyouno;
    }

    @Override
    public void setVhrkicreditkessaiyouno(String pVhrkicreditkessaiyouno) {
        vhrkicreditkessaiyouno = pVhrkicreditkessaiyouno;
    }

    private String vhrkidispcreditkessaiyouno;

    public String getVhrkidispcreditkessaiyouno() {
        return vhrkidispcreditkessaiyouno;
    }

    @Override
    public void setVhrkidispcreditkessaiyouno(String pVhrkidispcreditkessaiyouno) {
        vhrkidispcreditkessaiyouno = pVhrkidispcreditkessaiyouno;
    }

    private C_Yuukoukakkekka vhrkicredityuukoukakkekka;

    public C_Yuukoukakkekka getVhrkicredityuukoukakkekka() {
        return vhrkicredityuukoukakkekka;
    }

    @Override
    public void setVhrkicredityuukoukakkekka(C_Yuukoukakkekka pVhrkicredityuukoukakkekka) {
        vhrkicredityuukoukakkekka = pVhrkicredityuukoukakkekka;
    }

    private BizDateYM vhrkicredityuukoukakym;

    public BizDateYM getVhrkicredityuukoukakym() {
        return vhrkicredityuukoukakym;
    }

    @Override
    public void setVhrkicredityuukoukakym(BizDateYM pVhrkicredityuukoukakym) {
        vhrkicredityuukoukakym = pVhrkicredityuukoukakym;
    }
}
