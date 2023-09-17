package yuyu.def.biz.manager.impl;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.def.biz.sorter.SortBM_Bosyuunin;
import yuyu.def.biz.sorter.SortBM_Channel;
import yuyu.def.biz.sorter.SortBM_Dairiten;
import yuyu.def.biz.sorter.SortBM_DairitenSyougou;
import yuyu.def.biz.sorter.SortBM_Kouin;
import yuyu.def.biz.sorter.SortBM_Tyouhyourenrakusaki;
import yuyu.def.biz.sorter.SortBT_BuntanInfo;
import yuyu.def.biz.sorter.SortBT_DairitenItakuSyouhn;
import yuyu.def.biz.sorter.SortBT_HknBosyuRiyouInfo;
import yuyu.def.biz.sorter.SortBT_MdhnBank;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_TyhyrenrakusikibetuKbn;
import yuyu.def.db.dao.BM_BosyuuninDao;
import yuyu.def.db.dao.BM_ChannelDao;
import yuyu.def.db.dao.BM_DairitenDao;
import yuyu.def.db.dao.BM_DairitenSyougouDao;
import yuyu.def.db.dao.BM_KouinDao;
import yuyu.def.db.dao.BM_TyouhyourenrakusakiDao;
import yuyu.def.db.dao.BT_BuntanInfoDao;
import yuyu.def.db.dao.BT_DairitenItakuSyouhnDao;
import yuyu.def.db.dao.BT_HknBosyuRiyouInfoDao;
import yuyu.def.db.dao.BT_MdhnBankDao;
import yuyu.def.db.entity.BM_Bosyuunin;
import yuyu.def.db.entity.BM_Channel;
import yuyu.def.db.entity.BM_Dairiten;
import yuyu.def.db.entity.BM_DairitenSyougou;
import yuyu.def.db.entity.BM_Kouin;
import yuyu.def.db.entity.BM_Tyouhyourenrakusaki;
import yuyu.def.db.entity.BT_BuntanInfo;
import yuyu.def.db.entity.BT_DairitenItakuSyouhn;
import yuyu.def.db.entity.BT_HknBosyuRiyouInfo;
import yuyu.def.db.entity.BT_MdhnBank;


/**
 * DairitenDomマネージャー<br />
 * Dairitenにおける、DB操作を提供する。<br />
 */
class DairitenDomManager {

    @Inject
    private BM_BosyuuninDao bosyuuninDao;

    @Inject
    private BM_ChannelDao channelDao;

    @Inject
    private BM_DairitenDao dairitenDao;

    @Inject
    private BT_DairitenItakuSyouhnDao dairitenItakuSyouhnDao;

    @Inject
    private BM_DairitenSyougouDao dairitenSyougouDao;

    @Inject
    private BM_KouinDao kouinDao;

    @Inject
    private BM_TyouhyourenrakusakiDao tyouhyourenrakusakiDao;

    @Inject
    private BT_BuntanInfoDao buntanInfoDao;

    @Inject
    private BT_HknBosyuRiyouInfoDao hknBosyuRiyouInfoDao;

    @Inject
    private BT_MdhnBankDao mdhnBankDao;

    List<BM_Channel> getAllChannel(){
        SortBM_Channel sortBM_Channel = new SortBM_Channel();
        return sortBM_Channel.OrderBM_ChannelByPkAsc(channelDao.selectAll());
    }

    BM_Channel getChannel(C_Channelcd pChannelcd) {

        return channelDao.getChannel(pChannelcd);
    }

    List<BM_Dairiten> getAllDairiten(){
        SortBM_Dairiten sortBM_Dairiten = new SortBM_Dairiten();
        return sortBM_Dairiten.OrderBM_DairitenByPkAsc(dairitenDao.selectAll());
    }

    BM_Dairiten getDairiten(String pDrtencd) {

        return dairitenDao.getDairiten(pDrtencd);
    }

    List<BM_Dairiten> getDairitensByOyadrtencdDrtenjimcd(String pOyadrtencd, String pDrtenjimcd) {

        return dairitenDao.getDairitensByOyadrtencdDrtenjimcd(pOyadrtencd, pDrtenjimcd);
    }

    List<BM_Dairiten> getDairitensByKinyuucdKinyuusitencd(String pKinyuucd, String pKinyuusitencd) {

        return dairitenDao.getDairitensByKinyuucdKinyuusitencd(pKinyuucd, pKinyuusitencd);
    }

    String getDairitenMinDrtencdByKinyuucdDrtenjimcd(String pKinyuucd, String pDrtenjimcd) {

        return dairitenDao.getDairitenMinDrtencdByKinyuucdDrtenjimcd(pKinyuucd, pDrtenjimcd);
    }

    List<BM_Dairiten> getDairitensByDrtencds(String[] pDrtencd) {

        return dairitenDao.getDairitensByDrtencds(pDrtencd);
    }

    List<BM_Dairiten> getDairitensByKinyuucd(String pKinyuucd) {

        return dairitenDao.getDairitensByKinyuucd(pKinyuucd);
    }

    List<BM_DairitenSyougou> getAllDairitenSyougou(){
        SortBM_DairitenSyougou sortBM_DairitenSyougou = new SortBM_DairitenSyougou();
        return sortBM_DairitenSyougou.OrderBM_DairitenSyougouByPkAsc(dairitenSyougouDao.selectAll());
    }

    BM_DairitenSyougou getDairitenSyougou(String pDrtencd) {

        return dairitenSyougouDao.getDairitenSyougou(pDrtencd);
    }

    List<BM_Bosyuunin> getAllBosyuunin(){
        SortBM_Bosyuunin sortBM_Bosyuunin = new SortBM_Bosyuunin();
        return sortBM_Bosyuunin.OrderBM_BosyuuninByPkAsc(bosyuuninDao.selectAll());
    }

    BM_Bosyuunin getBosyuunin(String pBosyuucd) {

        return bosyuuninDao.getBosyuunin(pBosyuucd);
    }

    List<BM_Bosyuunin> getBosyuuninByBosyuutrkno(String pBosyuutrkno) {

        return bosyuuninDao.getBosyuuninByBosyuutrkno(pBosyuutrkno);
    }

    List<BM_Tyouhyourenrakusaki> getAllTyouhyourenrakusaki(){
        SortBM_Tyouhyourenrakusaki sortBM_Tyouhyourenrakusaki = new SortBM_Tyouhyourenrakusaki();
        return sortBM_Tyouhyourenrakusaki.OrderBM_TyouhyourenrakusakiByPkAsc(tyouhyourenrakusakiDao.selectAll());
    }

    BM_Tyouhyourenrakusaki getTyouhyourenrakusaki(C_TyhyrenrakusikibetuKbn pTyhyrenrakusikibetukbn) {

        return tyouhyourenrakusakiDao.getTyouhyourenrakusaki(pTyhyrenrakusikibetukbn);
    }

    List<BM_Kouin> getAllKouin(){
        SortBM_Kouin sortBM_Kouin = new SortBM_Kouin();
        return sortBM_Kouin.OrderBM_KouinByPkAsc(kouinDao.selectAll());
    }

    BM_Kouin getKouin(String pKinyuucd, String pKouincd) {

        return kouinDao.getKouin(pKinyuucd, pKouincd);
    }

    List<BM_Kouin> getKouinsBybosyuucd(String pBosyuucd) {

        return kouinDao.getKouinsBybosyuucd(pBosyuucd);
    }

    List<BM_Kouin> getKouinsByKouincds(String pKinyuucd, String[] pKouincd) {

        return kouinDao.getKouinsByKouincds(pKinyuucd, pKouincd);
    }

    List<BT_MdhnBank> getAllMdhnBank(){
        SortBT_MdhnBank sortBT_MdhnBank = new SortBT_MdhnBank();
        return sortBT_MdhnBank.OrderBT_MdhnBankByPkAsc(mdhnBankDao.selectAll());
    }

    BT_MdhnBank getMdhnBank(String pDrtencd) {

        return mdhnBankDao.getMdhnBank(pDrtencd);
    }

    List<BT_HknBosyuRiyouInfo> getAllHknBosyuRiyouInfo(){
        SortBT_HknBosyuRiyouInfo sortBT_HknBosyuRiyouInfo = new SortBT_HknBosyuRiyouInfo();
        return sortBT_HknBosyuRiyouInfo.OrderBT_HknBosyuRiyouInfoByPkAsc(hknBosyuRiyouInfoDao.selectAll());
    }

    BT_HknBosyuRiyouInfo getHknBosyuRiyouInfo(String pDrtencd) {

        return hknBosyuRiyouInfoDao.getHknBosyuRiyouInfo(pDrtencd);
    }

    List<BT_BuntanInfo> getAllBuntanInfo(){
        SortBT_BuntanInfo sortBT_BuntanInfo = new SortBT_BuntanInfo();
        return sortBT_BuntanInfo.OrderBT_BuntanInfoByPkAsc(buntanInfoDao.selectAll());
    }

    BT_BuntanInfo getBuntanInfo(String pDrtencd, String pDairitensyouhincd, String pTesuuryoubuntandrtencd, BizDateYM pTesuuryoubuntanstartym) {

        return buntanInfoDao.getBuntanInfo(pDrtencd, pDairitensyouhincd, pTesuuryoubuntandrtencd, pTesuuryoubuntanstartym);
    }

    List<BT_BuntanInfo> getBuntanInfosByPK(String pDrtencd, String pDairitensyouhincd, String pTesuuryoubuntandrtencd, BizDateYM pSyutokukijyunym) {

        return buntanInfoDao.getBuntanInfosByPK(pDrtencd, pDairitensyouhincd, pTesuuryoubuntandrtencd, pSyutokukijyunym);
    }

    List<BT_BuntanInfo> getBuntanInfosAitedrtenSiteinasi(String pDrtencd, String pDairitensyouhincd, BizDateYM pSyutokukijyunym) {

        return buntanInfoDao.getBuntanInfosAitedrtenSiteinasi(pDrtencd, pDairitensyouhincd, pSyutokukijyunym);
    }

    List<BT_DairitenItakuSyouhn> getAllDairitenItakuSyouhn(){
        SortBT_DairitenItakuSyouhn sortBT_DairitenItakuSyouhn = new SortBT_DairitenItakuSyouhn();
        return sortBT_DairitenItakuSyouhn.OrderBT_DairitenItakuSyouhnByPkAsc(dairitenItakuSyouhnDao.selectAll());
    }

    BT_DairitenItakuSyouhn getDairitenItakuSyouhn(String pDrtencd, String pDrtsyouhinsikibetukbnstr, String pDrthrkhouhoukbn, String pDrtplannmkbn, BizDate pItakuhknhnbkaisiymd) {

        return dairitenItakuSyouhnDao.getDairitenItakuSyouhn(pDrtencd, pDrtsyouhinsikibetukbnstr, pDrthrkhouhoukbn, pDrtplannmkbn, pItakuhknhnbkaisiymd);
    }

    Long getDairitenCountByDrtencdDrtennm(String pDrtencd, String pDrtennmkn, String pDrtennmkj1, String pDrtennmkj2) {

        return dairitenDao.getDairitenCountByDrtencdDrtennm(pDrtencd, pDrtennmkn, pDrtennmkj1, pDrtennmkj2);
    }

    List<BM_Dairiten> getDairitenByDrtencdDrtennmOrderByDrtencdAsc(String pDrtencd, String pDrtennmkn, String pDrtennmkj1, String pDrtennmkj2) {

        return dairitenDao.getDairitenByDrtencdDrtennmOrderByDrtencdAsc(pDrtencd, pDrtennmkn, pDrtennmkj1, pDrtennmkj2);
    }

}
