package yuyu.common.siharai.koutei;

import java.io.Serializable;

import yuyu.def.classification.C_GeninKbn;
import yuyu.def.classification.C_KyksyaSibouUmuKbn;
import yuyu.def.classification.C_MousideninKbn;
import yuyu.def.classification.C_PmenKbn;
import yuyu.def.classification.C_SaigaiGeninKbn;
import yuyu.def.classification.C_SbjiShrKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_UmuKbn;

/**
 * 保険金給付金支払 工程 支払必要書類判定入力Bean
 */
public class SiHituyousyoruiHanteiInBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String kouteiKanriId;

    private C_SeikyuuSyubetu seikyuuSyubetu;

    private C_UmuKbn hrkmnryUmuKbn;

    private C_UmuKbn mikeikapUmuKbn;

    private C_SbjiShrKbn sbjiShrKbn;

    private C_UmuKbn kanitratkiUmuKbn;

    private String syouhnCd;

    private C_GeninKbn geninKbn;

    private C_SaigaiGeninKbn saigaiGeninKbn;

    private C_MousideninKbn mousideninKbn;

    private C_UmuKbn dhysntdkUmuKbn;

    private C_PmenKbn pmenKbn ;

    private C_UmuKbn stikasUmuKbn;

    private C_UmuKbn nstkhukaumukbn;

    private C_UmuKbn jisatumensekiumukbn;

    private C_KyksyaSibouUmuKbn  kyksyasibouumukbn;

    private C_UmuKbn jikojksumukbn;

    private C_UmuKbn  mynumbersinkokuumukbn;

    private C_Tdk  kkkyktdk;

    public SiHituyousyoruiHanteiInBean() {
        super();
    }

    public String getKouteiKanriId(){
        return kouteiKanriId;
    }

    public void setKouteiKanriId(String pKouteiKanriId){
        kouteiKanriId = pKouteiKanriId;
    }

    public C_SeikyuuSyubetu getSeikyuuSyubetu(){
        return seikyuuSyubetu;
    }

    public void setSeikyuuSyubetu(C_SeikyuuSyubetu pSeikyuuSyubetu){
        seikyuuSyubetu = pSeikyuuSyubetu;
    }

    public C_UmuKbn getHrkmnryUmuKbn(){
        return hrkmnryUmuKbn;
    }

    public void setHrkmnryUmuKbn(C_UmuKbn pHrkmnryUmuKbn){
        hrkmnryUmuKbn = pHrkmnryUmuKbn;
    }

    public C_UmuKbn getMikeikapUmuKbn(){
        return mikeikapUmuKbn;
    }

    public void setMikeikapUmuKbn(C_UmuKbn pMikeikapUmuKbn){
        mikeikapUmuKbn = pMikeikapUmuKbn;
    }

    public C_SbjiShrKbn getSbjiShrKbn(){
        return sbjiShrKbn;
    }

    public void setSbjiShrKbn(C_SbjiShrKbn pSbjiShrKbn){
        sbjiShrKbn = pSbjiShrKbn;
    }

    public C_UmuKbn getKanitratkiUmuKbn(){
        return kanitratkiUmuKbn;
    }

    public void setKanitratkiUmuKbn(C_UmuKbn pKanitratkiUmuKbn){
        kanitratkiUmuKbn = pKanitratkiUmuKbn;
    }

    public String getSyouhnCd(){
        return syouhnCd;
    }

    public void setSyouhnCd(String pSyouhnCd){
        syouhnCd = pSyouhnCd;
    }

    public C_GeninKbn getGeninKbn(){
        return geninKbn;
    }

    public void setGeninKbn(C_GeninKbn pGeninKbn){
        geninKbn = pGeninKbn;
    }

    public C_SaigaiGeninKbn getSaigaiGeninKbn(){
        return saigaiGeninKbn;
    }

    public void setSaigaiGeninKbn(C_SaigaiGeninKbn pSaigaiGeninKbn){
        saigaiGeninKbn = pSaigaiGeninKbn;
    }

    public C_MousideninKbn getMousideninKbn(){
        return mousideninKbn;
    }

    public void setMousideninKbn(C_MousideninKbn pMousideninKbn){
        mousideninKbn = pMousideninKbn;
    }

    public C_UmuKbn getDhysntdkUmuKbn(){
        return dhysntdkUmuKbn;
    }

    public void setDhysntdkUmuKbn(C_UmuKbn pDhysntdkUmuKbn){
        dhysntdkUmuKbn = pDhysntdkUmuKbn;
    }

    public C_PmenKbn getPmenKbn(){
        return pmenKbn;
    }

    public void setPmenKbn(C_PmenKbn pPmenKbn){
        pmenKbn = pPmenKbn;
    }

    public C_UmuKbn getStikasUmuKbn(){
        return stikasUmuKbn;
    }

    public void setStikasUmuKbn(C_UmuKbn pStikasUmuKbn){
        stikasUmuKbn = pStikasUmuKbn;
    }

    public C_UmuKbn getNstkhukaumukbn() {
        return nstkhukaumukbn;
    }

    public void setNstkhukaumukbn(C_UmuKbn pNstkhukaumukbn) {
        this.nstkhukaumukbn = pNstkhukaumukbn;
    }

    public C_UmuKbn getJisatumensekiumukbn() {
        return jisatumensekiumukbn;
    }

    public void setJisatumensekiumukbn(C_UmuKbn pJisatumensekiumukbn) {
        this.jisatumensekiumukbn = pJisatumensekiumukbn;
    }

    public C_KyksyaSibouUmuKbn getKyksyasibouumukbn() {
        return kyksyasibouumukbn;
    }

    public void setKyksyasibouumukbn(C_KyksyaSibouUmuKbn pKyksyasibouumukbn) {
        this.kyksyasibouumukbn = pKyksyasibouumukbn;
    }

    public C_UmuKbn getJikojksumukbn() {
        return jikojksumukbn;
    }

    public void setJikojksumukbn(C_UmuKbn pJikojksumukbn) {
        this.jikojksumukbn = pJikojksumukbn;
    }

    public C_UmuKbn getMynumbersinkokuumukbn() {
        return mynumbersinkokuumukbn;
    }

    public void setMynumbersinkokuumukbn(C_UmuKbn pMynumbersinkokuumukbn) {
        this.mynumbersinkokuumukbn = pMynumbersinkokuumukbn;
    }

    public C_Tdk getKkkyktdk() {
        return kkkyktdk;
    }

    public void setKkkyktdk(C_Tdk pKkkyktdk) {
        this.kkkyktdk = pKkkyktdk;
    }
}
