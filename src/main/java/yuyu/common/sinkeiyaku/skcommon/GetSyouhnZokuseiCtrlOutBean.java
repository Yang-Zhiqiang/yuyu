package yuyu.common.sinkeiyaku.skcommon;

import java.io.Serializable;

import jp.co.slcs.swak.web.ui.UserDefsList;
import yuyu.def.classification.C_HaitouKbn;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_Nstkumu;
import yuyu.def.classification.C_PtratkituukasiteiKbn;
import yuyu.def.classification.C_TargetTkHukaKanouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;

/**
 * 新契約 新契約共通 制御用商品属性取得出力Bean
 */
public class GetSyouhnZokuseiCtrlOutBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_HknsyuruiNo hknsyuruino;

    private Integer hknsyuruinosd;

    private String inputctrlsyouhncd;

    private C_UmuKbn sbuktumu;

    private C_UmuKbn kktumu;

    private C_UmuKbn musenumu;

    private C_UmuKbn syokugyoukktumu;

    private C_HaitouKbn haitoukbn;

    private C_UmuKbn teikisiharaikinumu;

    private C_UmuKbn itijibrumu;

    private C_UmuKbn gaikatatkiumu;

    private C_UmuKbn hengakuumu;

    private C_Nstkumu nstkumu;

    private C_UmuKbn kykdrtentuusanumu;

    private C_UmuKbn pyennykntktekiumu;

    private C_UmuKbn gaikanyuukintktekiumu;

    private C_UmuKbn syuusinhknumu;

    private C_UmuKbn nkhknumu;

    private C_UmuKbn syksbyensitihsyutktekiumu;

    private C_UmuKbn jyudkaigomehrtktekiumu;

    private C_UmuKbn stdrsktkumu;

    private UserDefsList dai1HknkknSelect;

    private UserDefsList targettkmkhtSelect;

    private C_Tuukasyu tuukasyu;

    private C_UmuKbn aeoitaisyouumu;

    private C_UmuKbn hokenkngkyakujyouumu;

    private C_TargetTkHukaKanouKbn targettkhukakanoukbn;

    private C_UmuKbn tmttknhaibunwarisiteiumu;

    private UserDefsList nenkinsyuSelect;

    private UserDefsList sueokikknSelect;

    private C_HknkknsmnKbn hknkknsmnKbn;

    private C_UmuKbn nkuktumu;

    private C_UmuKbn heijyunbaraiumu;

    private C_UmuKbn zennouumu;

    private C_UmuKbn itibuzennoutekiumu;

    private C_UmuKbn kouzahurikaebaraitekiumu;

    private C_UmuKbn zeiseitekikakuumu;

    private UserDefsList hrktuukaSelect;

    private UserDefsList hrkkeiroSelect;

    private C_HrkkknsmnKbn hrkkknsmnkbn;

    private C_UmuKbn teikiikkatubaraiumu;

    private C_UmuKbn mos2hyoujiumuKbn;

    private UserDefsList kyktuukasyuSelect;

    private UserDefsList kyktuukasyu2Select;

    private UserDefsList hrkkaisuuSelect;

    private UserDefsList ikkatubaraikaisuuSelect;

    private UserDefsList zenkizennouSelect;

    private C_UmuKbn kzktourokuserviceumu;

    private C_UmuKbn kykdrtkykumu;

    private C_PtratkituukasiteiKbn ptratkituukasiteikbn;

    public C_HknsyuruiNo getHknsyuruino() {
        return hknsyuruino;
    }

    public void setHknsyuruino(C_HknsyuruiNo pHksyuruino) {
        this.hknsyuruino = pHksyuruino;
    }

    public Integer getHknsyuruinosd() {
        return hknsyuruinosd;
    }

    public void setHknsyuruinosd(Integer pHknsyuruinosd) {
        this.hknsyuruinosd = pHknsyuruinosd;
    }

    public String getInputctrlsyouhncd() {
        return inputctrlsyouhncd;
    }

    public void setInputctrlsyouhncd(String pInputctrlsyouhncd) {
        this.inputctrlsyouhncd = pInputctrlsyouhncd;
    }

    public C_UmuKbn getSbuktumu() {
        return sbuktumu;
    }

    public void setSbuktumu(C_UmuKbn pSbuktumu) {
        sbuktumu = pSbuktumu;
    }

    public C_UmuKbn getKktumu() {
        return kktumu;
    }

    public void setKktumu(C_UmuKbn pKktumu) {
        kktumu = pKktumu;
    }

    public C_UmuKbn getMusenumu() {
        return musenumu;
    }

    public void setMusenumu(C_UmuKbn pMusenumu) {
        musenumu = pMusenumu;
    }

    public C_UmuKbn getSyokugyoukktumu() {
        return syokugyoukktumu;
    }

    public void setSyokugyoukktumu(C_UmuKbn pSyokugyoukktumu) {
        syokugyoukktumu = pSyokugyoukktumu;
    }

    public C_HaitouKbn getHaitoukbn() {
        return haitoukbn;
    }

    public void setHaitoukbn(C_HaitouKbn pHaitoukbn) {
        haitoukbn = pHaitoukbn;
    }

    public C_UmuKbn getTeikisiharaikinumu() {
        return teikisiharaikinumu;
    }

    public void setTeikisiharaikinumu(C_UmuKbn pTeikisiharaikinumu) {
        teikisiharaikinumu = pTeikisiharaikinumu;
    }

    public C_UmuKbn getItijibrumu() {
        return itijibrumu;
    }

    public void setItijibrumu(C_UmuKbn pItijibrumu) {
        itijibrumu = pItijibrumu;
    }

    public C_UmuKbn getGaikatatkiumu() {
        return gaikatatkiumu;
    }

    public void setGaikatatkiumu(C_UmuKbn pGaikatatkiumu) {
        gaikatatkiumu = pGaikatatkiumu;
    }

    public C_UmuKbn getHengakuumu() {
        return hengakuumu;
    }

    public void setHengakuumu(C_UmuKbn pHengakuumu) {
        hengakuumu = pHengakuumu;
    }

    public C_Nstkumu getNstkumu() {
        return nstkumu;
    }

    public void setNstkumu(C_Nstkumu pNstkumu) {
        nstkumu = pNstkumu;
    }

    public C_UmuKbn getKykdrtentuusanumu() {
        return kykdrtentuusanumu;
    }

    public void setKykdrtentuusanumu(C_UmuKbn pKykdrtentuusanumu) {
        kykdrtentuusanumu = pKykdrtentuusanumu;
    }

    public C_UmuKbn getPyennykntktekiumu() {
        return pyennykntktekiumu;
    }

    public void setPyennykntktekiumu(C_UmuKbn pPyennykntktekiumu) {
        pyennykntktekiumu = pPyennykntktekiumu;
    }

    public C_UmuKbn getGaikanyuukintktekiumu() {
        return gaikanyuukintktekiumu;
    }

    public void setGaikanyuukintktekiumu(C_UmuKbn pGaikanyuukintktekiumu) {
        gaikanyuukintktekiumu = pGaikanyuukintktekiumu;
    }

    public C_UmuKbn getSyuusinhknumu() {
        return syuusinhknumu;
    }

    public void setSyuusinhknumu(C_UmuKbn pSyuusinhknumu) {
        syuusinhknumu = pSyuusinhknumu;
    }

    public C_UmuKbn getNkhknumu() {
        return nkhknumu;
    }

    public void setNkhknumu(C_UmuKbn pNkhknumu) {
        nkhknumu = pNkhknumu;
    }

    public C_UmuKbn getSyksbyensitihsyutktekiumu() {
        return syksbyensitihsyutktekiumu;
    }

    public void setSyksbyensitihsyutktekiumu(C_UmuKbn pSyksbyensitihsyutktekiumu) {
        syksbyensitihsyutktekiumu = pSyksbyensitihsyutktekiumu;
    }

    public C_UmuKbn getJyudkaigomehrtktekiumu() {
        return jyudkaigomehrtktekiumu;
    }

    public void setJyudkaigomehrtktekiumu(C_UmuKbn pJyudkaigomehrtktekiumu) {
        jyudkaigomehrtktekiumu = pJyudkaigomehrtktekiumu;
    }

    public C_UmuKbn getStdrsktkumu() {
        return stdrsktkumu;
    }

    public void setStdrsktkumu(C_UmuKbn pStdrsktkumu) {
        stdrsktkumu = pStdrsktkumu;
    }

    public UserDefsList getDai1HknkknSelect() {
        return dai1HknkknSelect;
    }

    public void setDai1HknkknSelect(UserDefsList pDai1HknkknSelect) {
        dai1HknkknSelect = pDai1HknkknSelect;
    }

    public UserDefsList getTargettkmkhtSelect() {
        return targettkmkhtSelect;
    }

    public void setTargettkmkhtSelect(UserDefsList pTargettkmkhtSelect) {
        targettkmkhtSelect = pTargettkmkhtSelect;
    }

    public C_Tuukasyu getTuukasyu() {
        return tuukasyu;
    }

    public void setTuukasyu(C_Tuukasyu pTuukasyu) {
        tuukasyu = pTuukasyu;
    }

    public C_UmuKbn getAeoitaisyouumu() {
        return aeoitaisyouumu;
    }

    public void setAeoitaisyouumu(C_UmuKbn pAeoitaisyouumu) {
        aeoitaisyouumu = pAeoitaisyouumu;
    }

    public C_UmuKbn getHokenkngkyakujyouumu() {
        return hokenkngkyakujyouumu;
    }

    public void setHokenkngkyakujyouumu(C_UmuKbn pHokenkngkyakujyouumu) {
        hokenkngkyakujyouumu = pHokenkngkyakujyouumu;
    }

    public C_TargetTkHukaKanouKbn getTargettkhukakanoukbn() {
        return targettkhukakanoukbn;
    }

    public void setTargettkhukakanoukbn(C_TargetTkHukaKanouKbn pTargettkhukakanoukbn) {
        targettkhukakanoukbn = pTargettkhukakanoukbn;
    }

    public C_UmuKbn getTmttknhaibunwarisiteiumu() {
        return tmttknhaibunwarisiteiumu;
    }

    public void setTmttknhaibunwarisiteiumu(C_UmuKbn pTmttknhaibunwarisiteiumu) {
        tmttknhaibunwarisiteiumu = pTmttknhaibunwarisiteiumu;
    }

    public UserDefsList getNenkinsyuSelect() {
        return nenkinsyuSelect;
    }

    public void setNenkinsyuSelect(UserDefsList pNenkinsyuSelect) {
        nenkinsyuSelect = pNenkinsyuSelect;
    }

    public UserDefsList getSueokikknSelect() {
        return sueokikknSelect;
    }

    public void setSueokikknSelect(UserDefsList pSueokikknSelect) {
        sueokikknSelect = pSueokikknSelect;
    }

    public C_HknkknsmnKbn getHknkknsmnKbn() {
        return hknkknsmnKbn;
    }

    public void setHknkknsmnKbn(C_HknkknsmnKbn pHknkknsmnKbn) {
        hknkknsmnKbn = pHknkknsmnKbn;
    }

    public C_UmuKbn getNkuktumu() {
        return nkuktumu;
    }

    public void setNkuktumu(C_UmuKbn pNkuktumu) {
        nkuktumu = pNkuktumu;
    }

    public C_UmuKbn getHeijyunbaraiumu() {
        return heijyunbaraiumu;
    }

    public void setHeijyunbaraiumu(C_UmuKbn pHeijyunbaraiumu) {
        heijyunbaraiumu = pHeijyunbaraiumu;
    }

    public C_UmuKbn getZennouumu() {
        return zennouumu;
    }

    public void setZennouumu(C_UmuKbn pZennouumu) {
        zennouumu = pZennouumu;
    }

    public C_UmuKbn getItibuzennoutekiumu() {
        return itibuzennoutekiumu;
    }

    public void setItibuzennoutekiumu(C_UmuKbn pItibuzennoutekiumu) {
        itibuzennoutekiumu = pItibuzennoutekiumu;
    }

    public C_UmuKbn getKouzahurikaebaraitekiumu() {
        return kouzahurikaebaraitekiumu;
    }

    public void setKouzahurikaebaraitekiumu(C_UmuKbn pKouzahurikaebaraitekiumu) {
        kouzahurikaebaraitekiumu = pKouzahurikaebaraitekiumu;
    }

    public C_UmuKbn getZeiseitekikakuumu() {
        return zeiseitekikakuumu;
    }

    public void setZeiseitekikakuumu(C_UmuKbn pZeiseitekikakuumu) {
        zeiseitekikakuumu = pZeiseitekikakuumu;
    }

    public UserDefsList getHrktuukaSelect() {
        return hrktuukaSelect;
    }

    public void setHrktuukaSelect(UserDefsList pHrktuukaSelect) {
        hrktuukaSelect = pHrktuukaSelect;
    }

    public UserDefsList getHrkkeiroSelect() {
        return hrkkeiroSelect;
    }

    public void setHrkkeiroSelect(UserDefsList pHrkkeiroSelect) {
        hrkkeiroSelect = pHrkkeiroSelect;
    }

    public C_HrkkknsmnKbn getHrkkknsmnkbn() {
        return hrkkknsmnkbn;
    }

    public void setHrkkknsmnkbn(C_HrkkknsmnKbn pHrkkknsmnkbn) {
        hrkkknsmnkbn = pHrkkknsmnkbn;
    }

    public C_UmuKbn  getTeikiikkatubaraiumu() {
        return teikiikkatubaraiumu;
    }

    public void setTeikiikkatubaraiumu(C_UmuKbn  pTeikiikkatubaraiumu) {
        teikiikkatubaraiumu = pTeikiikkatubaraiumu;
    }

    public C_UmuKbn  getMos2hyoujiumuKbn() {
        return mos2hyoujiumuKbn;
    }

    public void setMos2hyoujiumuKbn(C_UmuKbn  pMos2hyoujiumuKbn) {
        mos2hyoujiumuKbn = pMos2hyoujiumuKbn;
    }

    public void setKyktuukasyuSelect(UserDefsList pKyktuukasyuSelect) {
        kyktuukasyuSelect = pKyktuukasyuSelect;
    }

    public UserDefsList getKyktuukasyuSelect() {
        return kyktuukasyuSelect;
    }

    public void setKyktuukasyu2Select(UserDefsList pKyktuukasyu2Select) {
        kyktuukasyu2Select = pKyktuukasyu2Select;
    }

    public UserDefsList getKyktuukasyu2Select() {
        return kyktuukasyu2Select;
    }

    public void setHrkkaisuuSelect(UserDefsList pHrkkaisuuSelect) {
        hrkkaisuuSelect = pHrkkaisuuSelect;
    }

    public UserDefsList getHrkkaisuuSelect() {
        return hrkkaisuuSelect;
    }

    public void setIkkatubaraikaisuuSelect(UserDefsList pIkkatubaraikaisuuSelect) {
        ikkatubaraikaisuuSelect = pIkkatubaraikaisuuSelect;
    }

    public UserDefsList getIkkatubaraikaisuuSelect() {
        return ikkatubaraikaisuuSelect;
    }


    public void setZenkizennouSelect(UserDefsList pZenkizennouSelect) {
        zenkizennouSelect = pZenkizennouSelect;
    }

    public UserDefsList getZenkizennouSelect() {
        return zenkizennouSelect;
    }
    public void setKzktourokuserviceumu(C_UmuKbn pKzktourokuserviceumu) {
        kzktourokuserviceumu = pKzktourokuserviceumu;
    }

    public C_UmuKbn getKzktourokuserviceumu() {
        return kzktourokuserviceumu;
    }
    public void setKykdrtkykumu(C_UmuKbn pKykdrtkykumu) {
        kykdrtkykumu = pKykdrtkykumu;
    }

    public C_UmuKbn getKykdrtkykumu() {
        return kykdrtkykumu;
    }

    public void setPtratkituukasiteikbn(C_PtratkituukasiteiKbn pPtratkituukasiteikbn) {

        ptratkituukasiteikbn = pPtratkituukasiteikbn;
    }

    public C_PtratkituukasiteiKbn getPtratkituukasiteikbn() {
        return ptratkituukasiteikbn;

    }
}