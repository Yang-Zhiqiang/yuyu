package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_6daiLdKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_KataKbn;
import yuyu.def.classification.C_KhnkyhkgbairituKbn;
import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Nenkinsyu;
import yuyu.def.classification.C_PmnjtkKbn;
import yuyu.def.classification.C_Sisuukbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyukyhkinkataKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TmttknhaibunjyoutaiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;

/**
 * 契約保全 契約保全共通 契約商品共通パラメータテスト用
 */
public class KykSyouhnCommonParamTest implements KykSyouhnCommonParam{

    private BizCurrency hokenryou;

    @Override
    public BizCurrency getHokenryou() {

        return hokenryou;
    }

    @Override
    public void setHokenryou(BizCurrency pHokenryou) {
        hokenryou = pHokenryou;

    }

    @Override
    public String getKbnkey(){
        return null;
    }

    @Override
    public void setKbnkey(String pKbnkey){

    }

    @Override
    public String getSyono() {

        return null;
    }

    @Override
    public void setSyono(String pSyono) {


    }

    private C_SyutkKbn syutkkbn;

    @Override
    public C_SyutkKbn getSyutkkbn() {

        return syutkkbn;
    }

    @Override
    public void setSyutkkbn(C_SyutkKbn pSyutkkbn) {

        syutkkbn = pSyutkkbn;
    }

    private String syouhncd;

    @Override
    public String getSyouhncd() {

        return syouhncd;
    }

    @Override
    public void setSyouhncd(String pSyouhncd) {

        syouhncd = pSyouhncd;
    }

    private Integer syouhnsdno;

    @Override
    public Integer getSyouhnsdno() {

        return syouhnsdno;
    }

    @Override
    public void setSyouhnsdno(Integer pSyouhnsdno) {

        syouhnsdno = pSyouhnsdno;
    }

    @Override
    public Integer getKyksyouhnrenno() {

        return null;
    }

    @Override
    public void setKyksyouhnrenno(Integer pKyksyouhnrenno) {


    }

    @Override
    public String getHenkousikibetukey() {

        return null;
    }

    @Override
    public void setHenkousikibetukey(String pHenkousikibetukey) {


    }

    @Override
    public C_YuukousyoumetuKbn getYuukousyoumetukbn() {

        return null;
    }

    @Override
    public void setYuukousyoumetukbn(C_YuukousyoumetuKbn pYuukousyoumetukbn) {


    }

    @Override
    public C_Kykjyoutai getKykjyoutai() {

        return null;
    }

    @Override
    public void setKykjyoutai(C_Kykjyoutai pKykjyoutai) {


    }

    @Override
    public C_Syoumetujiyuu getSyoumetujiyuu() {

        return null;
    }

    @Override
    public void setSyoumetujiyuu(C_Syoumetujiyuu pSyoumetujiyuu) {

    }

    @Override
    public BizDate getSyoumetuymd() {

        return null;
    }

    @Override
    public void setSyoumetuymd(BizDate pSyoumetuymd) {


    }

    @Override
    public BizDate getKouryokuhasseiymd() {

        return null;
    }

    @Override
    public void setKouryokuhasseiymd(BizDate pKouryokuhasseiymd) {


    }

    @Override
    public BizDate getKykymd() {

        return null;
    }

    @Override
    public void setKykymd(BizDate pKykymd) {


    }

    @Override
    public C_UmuKbn getKykymdsiteiumukbn() {

        return null;
    }

    @Override
    public void setKykymdsiteiumukbn(C_UmuKbn pKykymdsiteiumukbn) {


    }

    @Override
    public BizDate getSknnkaisiymd() {

        return null;
    }

    @Override
    public void setSknnkaisiymd(BizDate pSknnkaisiymd) {


    }

    @Override
    public BizDate getGansknnkaisiymd() {

        return null;
    }

    @Override
    public void setGansknnkaisiymd(BizDate pGansknnkaisiymd) {


    }

    @Override
    public BizDate getHksknnkaisiymd() {

        return null;
    }

    @Override
    public void setHksknnkaisiymd(BizDate pHksknnkaisiymd) {


    }

    @Override
    public BizDate getHkgansknnkaisiymd() {

        return null;
    }

    @Override
    public void setHkgansknnkaisiymd(BizDate pHkgansknnkaisiymd) {


    }

    @Override
    public C_HknkknsmnKbn getHknkknsmnkbn() {

        return null;
    }

    @Override
    public void setHknkknsmnkbn(C_HknkknsmnKbn pHknkknsmnkbn) {


    }

    @Override
    public Integer getHknkkn() {

        return null;
    }

    @Override
    public void setHknkkn(Integer pHknkkn) {


    }

    @Override
    public C_HrkkknsmnKbn getHrkkknsmnkbn() {

        return null;
    }

    @Override
    public void setHrkkknsmnkbn(C_HrkkknsmnKbn pHrkkknsmnkbn) {


    }

    @Override
    public Integer getHrkkkn() {

        return null;
    }

    @Override
    public void setHrkkkn(Integer pHrkkkn) {


    }

    @Override
    public Integer getKyknen() {

        return null;
    }

    @Override
    public void setKyknen(Integer pKyknen) {


    }

    @Override
    public Integer getHhknnen() {

        return null;
    }

    @Override
    public void setHhknnen(Integer pHhknnen) {


    }

    @Override
    public BizDate getHhknseiymd(){
        return null;
    }

    @Override
    public void setHhknseiymd(BizDate pHhknseiymd){

    }

    @Override
    public C_Hhknsei getHhknsei(){
        return null;
    }

    @Override
    public void setHhknsei(C_Hhknsei pHhknsei){

    }

    @Override
    public BizDate getHaraimanymd() {

        return null;
    }

    @Override
    public void setHaraimanymd(BizDate pHaraimanymd) {


    }

    @Override
    public BizDate getHknkknmanryouymd() {

        return null;
    }

    @Override
    public void setHknkknmanryouymd(BizDate pHknkknmanryouymd) {


    }

    @Override
    public C_KataKbn getKatakbn() {

        return null;
    }

    @Override
    public void setKatakbn(C_KataKbn pKatakbn) {


    }

    @Override
    public C_KyhgndkataKbn getKyhgndkatakbn() {

        return null;
    }

    @Override
    public void setKyhgndkatakbn(C_KyhgndkataKbn pKyhgndkatakbn) {


    }

    @Override
    public C_SyukyhkinkataKbn getSyukyhkinkatakbn() {

        return null;
    }

    @Override
    public void setSyukyhkinkatakbn(C_SyukyhkinkataKbn pSyukyhkinkatakbn) {


    }

    @Override
    public C_KhnkyhkgbairituKbn getKhnkyhkgbairitukbn() {

        return null;
    }

    @Override
    public void setKhnkyhkgbairitukbn(C_KhnkyhkgbairituKbn pKhnkyhkgbairitukbn) {


    }

    @Override
    public C_6daiLdKbn getRokudaildkbn() {

        return null;
    }

    @Override
    public void setRokudaildkbn(C_6daiLdKbn pRokudaildkbn) {


    }

    @Override
    public C_PmnjtkKbn getPmnjtkkbn() {

        return null;
    }

    @Override
    public void setPmnjtkkbn(C_PmnjtkKbn pPmnjtkkbn) {


    }

    @Override
    public BizCurrency getKihons() {

        return null;
    }

    @Override
    public void setKihons(BizCurrency pKihons) {


    }

    @Override
    public String getGyoumuKousinKinou() {

        return null;
    }


    @Override
    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {


    }

    @Override
    public String getGyoumuKousinsyaId() {

        return null;
    }

    @Override
    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {


    }

    @Override
    public String getGyoumuKousinTime() {

        return null;
    }

    @Override
    public void setGyoumuKousinTime(String pGyoumuKousinTime) {

    }

    @Override
    public C_Tuukasyu getKyktuukasyu(){
        return null;
    }

    @Override
    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu){

    }

    @Override
    public String getRyouritusdno(){
        return null;
    }

    @Override
    public void setRyouritusdno(String pRyouritusdno){

    }

    @Override
    public BizNumber getYoteiriritu(){
        return null;
    }

    @Override
    public void setYoteiriritu(BizNumber pYoteiriritu){

    }

    @Override
    public BizNumber getYoteirrthendohosyurrt(){
        return null;
    }

    @Override
    public void setYoteirrthendohosyurrt(BizNumber pYoteirrthendohosyurrt){

    }

    @Override
    public Integer getYtirrthndmnskaisuu(){
        return null;
    }

    @Override
    public void setYtirrthndmnskaisuu(Integer pYtirrthndmnskaisuu){

    }

    @Override
    public BizNumber getKyksjkkktyouseiriritu(){
        return null;
    }

    @Override
    public void setKyksjkkktyouseiriritu(BizNumber pKyksjkkktyouseiriritu){

    }

    @Override
    public C_Nenkinsyu getNksyukbn(){
        return null;
    }

    @Override
    public void setNksyukbn(C_Nenkinsyu pNksyukbn){

    }

    @Override
    public Integer getNenkinkkn(){
        return null;
    }

    @Override
    public void setNenkinkkn(Integer pNenkinkkn){

    }

    @Override
    public Integer getNkgnshosyouritu(){
        return null;
    }

    @Override
    public void setNkgnshosyouritu(Integer pNkgnshosyouritu){

    }

    @Override
    public BizCurrency getNkgnshosyougk(){
        return null;
    }

    @Override
    public void setNkgnshosyougk(BizCurrency pNkgnshosyougk){

    }
    @Override
    public BizCurrency getGengakugoyenitijibrpstgk(){
        return null;
    }
    @Override
    public void setGengakugoyenitijibrpstgk(BizCurrency pGengakugoyenitijibrpstgk){

    }
    @Override
    public BizDate getYendthnkymd(){
        return null;
    }
    @Override
    public void setYendthnkymd(BizDate pYendthnkymd){

    }
    @Override
    public BizNumber getSetteibairitu(){
        return null;
    }
    @Override
    public void setSetteibairitu(BizNumber pSetteibairitu){

    }
    @Override
    public BizNumber getKykjisisuurendourate(){
        return null;
    }

    @Override
    public void setKykjisisuurendourate(BizNumber pKykjisisuurendourate){

    }
    @Override
    public BizNumber getTmttknzoukaritujygn(){
        return null;
    }
    @Override
    public void setTmttknzoukaritujygn(BizNumber pTmttknzoukaritujygn){

    }
    @Override
    public BizNumber getTumitateriritu(){
        return null;
    }
    @Override
    public void setTumitateriritu(BizNumber pTumitateriritu){

    }
    @Override
    public C_TmttknhaibunjyoutaiKbn getTmttknhaibunjyoutai(){
        return null;
    }
    @Override
    public void setTmttknhaibunjyoutai(C_TmttknhaibunjyoutaiKbn pTmttknhaibunjyoutai){

    }
    @Override
    public C_Sisuukbn getSisuukbn(){
        return null;
    }
    @Override
    public void setSisuukbn(C_Sisuukbn pSisuukbn){

    }
    @Override
    public C_UmuKbn getGsbunrikzkakuninumu(){
        return null;
    }
    @Override
    public void setGsbunrikzkakuninumu(C_UmuKbn pGsbunrikzkakuninumu){

    }
    @Override
    public C_UmuKbn getGsbunritaisyou(){
        return null;
    }
    @Override
    public void setGsbunritaisyou(C_UmuKbn pGsbunritaisyou){

    }
    @Override
    public BizCurrency getPharaikomisougaku(){
        return null;
    }
    @Override
    public void setPharaikomisougaku(BizCurrency pPharaikomisougaku){

    }
    @Override
    public BizDate getTmttknitenymd(){
        return null;
    }
    @Override
    public void setTmttknitenymd(BizDate pTmttknitenymd){

    }
    @Override
    public BizNumber getLoadinghnkgtumitateriritu(){
        return null;
    }
    @Override
    public void setLoadinghnkgtumitateriritu(BizNumber pLoadinghnkgtumitateriritu){

    }

    @Override
    public BizNumber getRendouritu() {
        return null;
    }

    @Override
    public void setRendouritu(BizNumber pRendouritu) {

    }

    @Override
    public BizNumber getTeikishrritu() {
        return null;
    }

    @Override
    public void setTeikishrritu(BizNumber pTeikishrritu) {

    }

    @Override
    public Integer getDai1hknkkn() {
        return null;
    }

    @Override
    public void setDai1hknkkn(Integer pDai1hknkkn) {

    }
}
