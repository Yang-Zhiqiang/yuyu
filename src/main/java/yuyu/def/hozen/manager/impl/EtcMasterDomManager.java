package yuyu.def.hozen.manager.impl;

import java.util.List;

import javax.inject.Inject;

import yuyu.def.classification.C_AnnaijyoutaiKbn;
import yuyu.def.classification.C_HassinsakiKbn;
import yuyu.def.classification.C_KensakuyouGenponHnkykumu;
import yuyu.def.classification.C_KhTyouhyoumsgbunruiKbn1;
import yuyu.def.classification.C_KhTyouhyoumsgbunruiKbn2;
import yuyu.def.classification.C_KhTyouhyoumsgbunruiKbn3;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_KyksyaSibouUmuKbn;
import yuyu.def.classification.C_Meigihnkjiyuu;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.classification.C_UktkSyoriKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YuukoujyotaikahiKbn;
import yuyu.def.classification.C_ZennouKbn;
import yuyu.def.classification.C_ZennouToukeiListKbn;
import yuyu.def.db.dao.IM_AnnaijyoutaikahiDao;
import yuyu.def.db.dao.IM_IktSyuunouRateDao;
import yuyu.def.db.dao.IM_KhHenkouUktksyorikahiDao;
import yuyu.def.db.dao.IM_KhHituyouSyoruiDao;
import yuyu.def.db.dao.IM_KhHubiNaiyouDao;
import yuyu.def.db.dao.IM_KhTtdkTyuuikahiDao;
import yuyu.def.db.dao.IM_KhTyouhyoumsg2Dao;
import yuyu.def.db.dao.IM_KhTyouhyoumsgDao;
import yuyu.def.db.dao.IM_KhTyuuiKahiDao;
import yuyu.def.db.dao.IM_KykjyoutaikahiDao;
import yuyu.def.db.dao.IM_SyorijtkahiDao;
import yuyu.def.db.dao.IM_SyoumetukahiDao;
import yuyu.def.db.dao.IM_YykIdouUktksyorikahiDao;
import yuyu.def.db.dao.IM_ZennouMkkpSampleListDao;
import yuyu.def.db.entity.IM_Annaijyoutaikahi;
import yuyu.def.db.entity.IM_IktSyuunouRate;
import yuyu.def.db.entity.IM_KhHenkouUktksyorikahi;
import yuyu.def.db.entity.IM_KhHituyouSyorui;
import yuyu.def.db.entity.IM_KhHubiNaiyou;
import yuyu.def.db.entity.IM_KhTtdkTyuuikahi;
import yuyu.def.db.entity.IM_KhTyouhyoumsg;
import yuyu.def.db.entity.IM_KhTyouhyoumsg2;
import yuyu.def.db.entity.IM_KhTyuuiKahi;
import yuyu.def.db.entity.IM_Kykjyoutaikahi;
import yuyu.def.db.entity.IM_Syorijtkahi;
import yuyu.def.db.entity.IM_Syoumetukahi;
import yuyu.def.db.entity.IM_YykIdouUktksyorikahi;
import yuyu.def.db.entity.IM_ZennouMkkpSampleList;
import yuyu.def.hozen.sorter.SortIM_Annaijyoutaikahi;
import yuyu.def.hozen.sorter.SortIM_IktSyuunouRate;
import yuyu.def.hozen.sorter.SortIM_KhHenkouUktksyorikahi;
import yuyu.def.hozen.sorter.SortIM_KhHituyouSyorui;
import yuyu.def.hozen.sorter.SortIM_KhHubiNaiyou;
import yuyu.def.hozen.sorter.SortIM_KhTtdkTyuuikahi;
import yuyu.def.hozen.sorter.SortIM_KhTyouhyoumsg;
import yuyu.def.hozen.sorter.SortIM_KhTyouhyoumsg2;
import yuyu.def.hozen.sorter.SortIM_KhTyuuiKahi;
import yuyu.def.hozen.sorter.SortIM_Kykjyoutaikahi;
import yuyu.def.hozen.sorter.SortIM_Syorijtkahi;
import yuyu.def.hozen.sorter.SortIM_Syoumetukahi;
import yuyu.def.hozen.sorter.SortIM_YykIdouUktksyorikahi;
import yuyu.def.hozen.sorter.SortIM_ZennouMkkpSampleList;

/**
 * EtcMasterDomマネージャー<br />
 * EtcMasterにおける、DB操作を提供する。<br />
 */
class EtcMasterDomManager {

    @Inject
    private IM_AnnaijyoutaikahiDao annaijyoutaikahiDao;

    @Inject
    private IM_IktSyuunouRateDao iktSyuunouRateDao;

    @Inject
    private IM_KhHenkouUktksyorikahiDao khHenkouUktksyorikahiDao;

    @Inject
    private IM_KhHituyouSyoruiDao khHituyouSyoruiDao;

    @Inject
    private IM_KhHubiNaiyouDao khHubiNaiyouDao;

    @Inject
    private IM_KhTtdkTyuuikahiDao khTtdkTyuuikahiDao;

    @Inject
    private IM_KhTyouhyoumsg2Dao khTyouhyoumsg2Dao;

    @Inject
    private IM_KhTyouhyoumsgDao khTyouhyoumsgDao;

    @Inject
    private IM_KhTyuuiKahiDao khTyuuiKahiDao;

    @Inject
    private IM_KykjyoutaikahiDao kykjyoutaikahiDao;

    @Inject
    private IM_SyorijtkahiDao syorijtkahiDao;

    @Inject
    private IM_SyoumetukahiDao syoumetukahiDao;

    @Inject
    private IM_YykIdouUktksyorikahiDao yykIdouUktksyorikahiDao;

    @Inject
    private IM_ZennouMkkpSampleListDao zennouMkkpSampleListDao;

    List<IM_KhHituyouSyorui> getAllKhHituyouSyorui(){
        SortIM_KhHituyouSyorui sortIM_KhHituyouSyorui = new SortIM_KhHituyouSyorui();
        return sortIM_KhHituyouSyorui.OrderIM_KhHituyouSyoruiByPkAsc(khHituyouSyoruiDao.selectAll());
    }

    IM_KhHituyouSyorui getKhHituyouSyorui(String pKinouId, Integer pHanteikbn1, Integer pHanteikbn2, Integer pHanteikbn3, Integer pHtysrirenno) {

        return khHituyouSyoruiDao.getKhHituyouSyorui(pKinouId, pHanteikbn1, pHanteikbn2, pHanteikbn3, pHtysrirenno);
    }

    List<IM_KhHituyouSyorui> getKhHituyouSyoruisByKinouIdHanteikbn1Hanteikbn2Hanteikbn3(String pKinouId, Integer pHanteikbn1, Integer pHanteikbn2, Integer pHanteikbn3) {

        return khHituyouSyoruiDao.getKhHituyouSyoruisByKinouIdHanteikbn1Hanteikbn2Hanteikbn3(pKinouId, pHanteikbn1, pHanteikbn2, pHanteikbn3);
    }

    List<IM_KhTyuuiKahi> getAllKhTyuuiKahi(){
        SortIM_KhTyuuiKahi sortIM_KhTyuuiKahi = new SortIM_KhTyuuiKahi();
        return sortIM_KhTyuuiKahi.OrderIM_KhTyuuiKahiByPkAsc(khTyuuiKahiDao.selectAll());
    }

    IM_KhTyuuiKahi getKhTyuuiKahi(String pKinouId) {

        return khTyuuiKahiDao.getKhTyuuiKahi(pKinouId);
    }

    List<IM_Syoumetukahi> getAllSyoumetukahi(){
        SortIM_Syoumetukahi sortIM_Syoumetukahi = new SortIM_Syoumetukahi();
        return sortIM_Syoumetukahi.OrderIM_SyoumetukahiByPkAsc(syoumetukahiDao.selectAll());
    }

    IM_Syoumetukahi getSyoumetukahi(String pKinouId, C_Syoumetujiyuu pSyoumetujiyuu) {

        return syoumetukahiDao.getSyoumetukahi(pKinouId, pSyoumetujiyuu);
    }

    List<IM_Annaijyoutaikahi> getAllAnnaijyoutaikahi(){
        SortIM_Annaijyoutaikahi sortIM_Annaijyoutaikahi = new SortIM_Annaijyoutaikahi();
        return sortIM_Annaijyoutaikahi.OrderIM_AnnaijyoutaikahiByPkAsc(annaijyoutaikahiDao.selectAll());
    }

    IM_Annaijyoutaikahi getAnnaijyoutaikahi(String pKinouId, C_AnnaijyoutaiKbn pAnnaijyoutaikbn) {

        return annaijyoutaikahiDao.getAnnaijyoutaikahi(pKinouId, pAnnaijyoutaikbn);
    }

    List<IM_KhTtdkTyuuikahi> getAllKhTtdkTyuuikahi(){
        SortIM_KhTtdkTyuuikahi sortIM_KhTtdkTyuuikahi = new SortIM_KhTtdkTyuuikahi();
        return sortIM_KhTtdkTyuuikahi.OrderIM_KhTtdkTyuuikahiByPkAsc(khTtdkTyuuikahiDao.selectAll());
    }

    IM_KhTtdkTyuuikahi getKhTtdkTyuuikahi(String pKinouId, C_TtdktyuuiKbn pTtdktyuuikbn) {

        return khTtdkTyuuikahiDao.getKhTtdkTyuuikahi(pKinouId, pTtdktyuuikbn);
    }

    List<IM_KhTyouhyoumsg> getAllKhTyouhyoumsg(){
        SortIM_KhTyouhyoumsg sortIM_KhTyouhyoumsg = new SortIM_KhTyouhyoumsg();
        return sortIM_KhTyouhyoumsg.OrderIM_KhTyouhyoumsgByPkAsc(khTyouhyoumsgDao.selectAll());
    }

    IM_KhTyouhyoumsg getKhTyouhyoumsg(C_SyoruiCdKbn pSyoruiCd, C_Meigihnkjiyuu pMeigihnkjiyuu, C_KyksyaSibouUmuKbn pKyksbumu, C_UmuKbn pShrumu
        , C_UmuKbn pTuityouumu) {

        return khTyouhyoumsgDao.getKhTyouhyoumsg(pSyoruiCd, pMeigihnkjiyuu, pKyksbumu, pShrumu
            , pTuityouumu);
    }

    List<IM_Kykjyoutaikahi> getAllKykjyoutaikahi(){
        SortIM_Kykjyoutaikahi sortIM_Kykjyoutaikahi = new SortIM_Kykjyoutaikahi();
        return sortIM_Kykjyoutaikahi.OrderIM_KykjyoutaikahiByPkAsc(kykjyoutaikahiDao.selectAll());
    }

    IM_Kykjyoutaikahi getKykjyoutaikahi(String pKinouId, C_Kykjyoutai pKykjyoutai) {

        return kykjyoutaikahiDao.getKykjyoutaikahi(pKinouId, pKykjyoutai);
    }

    List<IM_Syorijtkahi> getAllSyorijtkahi(){
        SortIM_Syorijtkahi sortIM_Syorijtkahi = new SortIM_Syorijtkahi();
        return sortIM_Syorijtkahi.OrderIM_SyorijtkahiByPkAsc(syorijtkahiDao.selectAll());
    }

    IM_Syorijtkahi getSyorijtkahi(String pKinouId, String pSyorijimuttdkcd, String pSyoritaskid) {

        return syorijtkahiDao.getSyorijtkahi(pKinouId, pSyorijimuttdkcd, pSyoritaskid);
    }

    List<IM_YykIdouUktksyorikahi> getAllYykIdouUktksyorikahi(){
        SortIM_YykIdouUktksyorikahi sortIM_YykIdouUktksyorikahi = new SortIM_YykIdouUktksyorikahi();
        return sortIM_YykIdouUktksyorikahi.OrderIM_YykIdouUktksyorikahiByPkAsc(yykIdouUktksyorikahiDao.selectAll());
    }

    IM_YykIdouUktksyorikahi getYykIdouUktksyorikahi(String pKinouId, String pYykuktkkinouid) {

        return yykIdouUktksyorikahiDao.getYykIdouUktksyorikahi(pKinouId, pYykuktkkinouid);
    }

    List<IM_KhHubiNaiyou> getAllKhHubiNaiyou(){
        SortIM_KhHubiNaiyou sortIM_KhHubiNaiyou = new SortIM_KhHubiNaiyou();
        return sortIM_KhHubiNaiyou.OrderIM_KhHubiNaiyouByPkAsc(khHubiNaiyouDao.selectAll());
    }

    IM_KhHubiNaiyou getKhHubiNaiyou(String pJimutetuzukicd, C_SyoruiCdKbn pSyoruiCd, String pHubinaiyoucd) {

        return khHubiNaiyouDao.getKhHubiNaiyou(pJimutetuzukicd, pSyoruiCd, pHubinaiyoucd);
    }

    List<IM_KhHubiNaiyou> getKhHubiNaiyousByJimutetuzukicdSyoruiCd(String pJimutetuzukicd, C_SyoruiCdKbn pSyoruiCd) {

        return khHubiNaiyouDao.getKhHubiNaiyousByJimutetuzukicdSyoruiCd(pJimutetuzukicd, pSyoruiCd);
    }

    List<IM_KhHubiNaiyou> getKhHubiNaiyousByJimutetuzukicdSyoruiCdItems(String pJimutetuzukicd, C_SyoruiCdKbn pSyoruiCd, C_HassinsakiKbn pHassinsakikbn,
        C_KensakuyouGenponHnkykumu pKensakuyougenponhnkykumu, C_UmuKbn pGenponhnkykumu, String pHubinaiyou) {

        return khHubiNaiyouDao.getKhHubiNaiyousByJimutetuzukicdSyoruiCdItems(pJimutetuzukicd, pSyoruiCd, pHassinsakikbn,
            pKensakuyougenponhnkykumu, pGenponhnkykumu, pHubinaiyou);
    }

    List<IM_IktSyuunouRate> getAllIktSyuunouRate(){
        SortIM_IktSyuunouRate sortIM_IktSyuunouRate = new SortIM_IktSyuunouRate();
        return sortIM_IktSyuunouRate.OrderIM_IktSyuunouRateByPkAsc(iktSyuunouRateDao.selectAll());
    }

    IM_IktSyuunouRate getIktSyuunouRate(String pSyouhncd, Integer pSyouhnsdno, Integer pIktkaisuu) {

        return iktSyuunouRateDao.getIktSyuunouRate(pSyouhncd, pSyouhnsdno, pIktkaisuu);
    }

    List<IM_KhHenkouUktksyorikahi> getAllKhHenkouUktksyorikahi(){
        SortIM_KhHenkouUktksyorikahi sortIM_KhHenkouUktksyorikahi = new SortIM_KhHenkouUktksyorikahi();
        return sortIM_KhHenkouUktksyorikahi.OrderIM_KhHenkouUktksyorikahiByPkAsc(khHenkouUktksyorikahiDao.selectAll());
    }

    IM_KhHenkouUktksyorikahi getKhHenkouUktksyorikahi(String pKinouId, C_UktkSyoriKbn pUktksyorikbn) {

        return khHenkouUktksyorikahiDao.getKhHenkouUktksyorikahi(pKinouId, pUktksyorikbn);
    }

    List<IM_KhTyouhyoumsg2> getAllKhTyouhyoumsg2(){
        SortIM_KhTyouhyoumsg2 sortIM_KhTyouhyoumsg2 = new SortIM_KhTyouhyoumsg2();
        return sortIM_KhTyouhyoumsg2.OrderIM_KhTyouhyoumsg2ByPkAsc(khTyouhyoumsg2Dao.selectAll());
    }

    IM_KhTyouhyoumsg2 getKhTyouhyoumsg2(C_SyoruiCdKbn pSyoruiCd, C_Meigihnkjiyuu pMeigihnkjiyuu, C_KyksyaSibouUmuKbn pKyksbumu, C_UmuKbn pShrumu
        , C_UmuKbn pTuityouumu, C_KhTyouhyoumsgbunruiKbn1 pKhtyouhyoumsgbunruikbn1, C_KhTyouhyoumsgbunruiKbn2 pKhtyouhyoumsgbunruikbn2
        , C_KhTyouhyoumsgbunruiKbn3 pKhtyouhyoumsgbunruikbn3) {

        return khTyouhyoumsg2Dao.getKhTyouhyoumsg2(pSyoruiCd, pMeigihnkjiyuu, pKyksbumu, pShrumu
            , pTuityouumu, pKhtyouhyoumsgbunruikbn1, pKhtyouhyoumsgbunruikbn2
            , pKhtyouhyoumsgbunruikbn3);
    }

    List<IM_ZennouMkkpSampleList> getAllZennouMkkpSampleList(){
        SortIM_ZennouMkkpSampleList sortIM_ZennouMkkpSampleList = new SortIM_ZennouMkkpSampleList();
        return sortIM_ZennouMkkpSampleList.OrderIM_ZennouMkkpSampleListByPkAsc(zennouMkkpSampleListDao.selectAll());
    }

    IM_ZennouMkkpSampleList getZennouMkkpSampleList(C_ZennouToukeiListKbn pZennoutoukeilistkbn, C_ZennouKbn pZennoukbn, C_Segcd   pKbnkeirisegcd) {

        return zennouMkkpSampleListDao.getZennouMkkpSampleList(pZennoutoukeilistkbn, pZennoukbn, pKbnkeirisegcd);
    }

    List<IM_Syorijtkahi> getSyorijtkahiByKinouidYuukoujyotaikahikbn(String pKinouId, C_YuukoujyotaikahiKbn pYuukoujyotaikahikbn) {

        return syorijtkahiDao.getSyorijtkahiByKinouidYuukoujyotaikahikbn(pKinouId, pYuukoujyotaikahikbn);
    }

}
