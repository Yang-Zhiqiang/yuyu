package yuyu.def.sinkeiyaku.manager.impl;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_AisyoumeiChannelKbn;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_DrtenRnrkhouKbn;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.dao.HM_ChkTesuuryouDao;
import yuyu.def.db.dao.HM_HonkouzaDao;
import yuyu.def.db.dao.HM_HurikomiKouzaDao;
import yuyu.def.db.dao.HM_SiinBunruiDao;
import yuyu.def.db.dao.HM_SkChannelDao;
import yuyu.def.db.dao.HM_SkDairitenKobetuJyouhouDao;
import yuyu.def.db.dao.HM_SkHokenSyuruiNoAisyouDao;
import yuyu.def.db.dao.HM_SkHokenSyuruiNoDao;
import yuyu.def.db.dao.HM_SkHubiKoumokuDao;
import yuyu.def.db.dao.HM_SkHubiNaiyouDao;
import yuyu.def.db.dao.HM_SkHubiRenrakuNaiyouDao;
import yuyu.def.db.dao.HM_SkSeibiSijiNaiyouDao;
import yuyu.def.db.dao.HM_SyouhnTaniHonkouza2Dao;
import yuyu.def.db.dao.HM_SyouhnTaniHonkouzaDao;
import yuyu.def.db.dao.HM_TokuteiKankeiHjnNmTotugouDao;
import yuyu.def.db.dao.HM_TokuteiKankeiHoujinDao;
import yuyu.def.db.entity.HM_ChkTesuuryou;
import yuyu.def.db.entity.HM_Honkouza;
import yuyu.def.db.entity.HM_HurikomiKouza;
import yuyu.def.db.entity.HM_SiinBunrui;
import yuyu.def.db.entity.HM_SkChannel;
import yuyu.def.db.entity.HM_SkDairitenKobetuJyouhou;
import yuyu.def.db.entity.HM_SkHokenSyuruiNo;
import yuyu.def.db.entity.HM_SkHokenSyuruiNoAisyou;
import yuyu.def.db.entity.HM_SkHubiKoumoku;
import yuyu.def.db.entity.HM_SkHubiNaiyou;
import yuyu.def.db.entity.HM_SkHubiRenrakuNaiyou;
import yuyu.def.db.entity.HM_SkSeibiSijiNaiyou;
import yuyu.def.db.entity.HM_SyouhnTaniHonkouza;
import yuyu.def.db.entity.HM_SyouhnTaniHonkouza2;
import yuyu.def.db.entity.HM_TokuteiKankeiHjnNmTotugou;
import yuyu.def.db.entity.HM_TokuteiKankeiHoujin;
import yuyu.def.sinkeiyaku.sorter.SortHM_ChkTesuuryou;
import yuyu.def.sinkeiyaku.sorter.SortHM_Honkouza;
import yuyu.def.sinkeiyaku.sorter.SortHM_HurikomiKouza;
import yuyu.def.sinkeiyaku.sorter.SortHM_SiinBunrui;
import yuyu.def.sinkeiyaku.sorter.SortHM_SkChannel;
import yuyu.def.sinkeiyaku.sorter.SortHM_SkDairitenKobetuJyouhou;
import yuyu.def.sinkeiyaku.sorter.SortHM_SkHokenSyuruiNo;
import yuyu.def.sinkeiyaku.sorter.SortHM_SkHokenSyuruiNoAisyou;
import yuyu.def.sinkeiyaku.sorter.SortHM_SkHubiKoumoku;
import yuyu.def.sinkeiyaku.sorter.SortHM_SkHubiNaiyou;
import yuyu.def.sinkeiyaku.sorter.SortHM_SkHubiRenrakuNaiyou;
import yuyu.def.sinkeiyaku.sorter.SortHM_SkSeibiSijiNaiyou;
import yuyu.def.sinkeiyaku.sorter.SortHM_SyouhnTaniHonkouza;
import yuyu.def.sinkeiyaku.sorter.SortHM_SyouhnTaniHonkouza2;
import yuyu.def.sinkeiyaku.sorter.SortHM_TokuteiKankeiHjnNmTotugou;
import yuyu.def.sinkeiyaku.sorter.SortHM_TokuteiKankeiHoujin;


/**
 * SinkeiyakuMstInfoDomマネージャー<br />
 * SinkeiyakuMstInfoにおける、DB操作を提供する。<br />
 */
class SinkeiyakuMstInfoDomManager {


    @Inject
    private HM_ChkTesuuryouDao chkTesuuryouDao;


    @Inject
    private HM_HonkouzaDao honkouzaDao;


    @Inject
    private HM_HurikomiKouzaDao hurikomiKouzaDao;


    @Inject
    private HM_SiinBunruiDao siinBunruiDao;


    @Inject
    private HM_SkChannelDao skChannelDao;


    @Inject
    private HM_SkDairitenKobetuJyouhouDao skDairitenKobetuJyouhouDao;


    @Inject
    private HM_SkHokenSyuruiNoAisyouDao skHokenSyuruiNoAisyouDao;


    @Inject
    private HM_SkHokenSyuruiNoDao skHokenSyuruiNoDao;


    @Inject
    private HM_SkHubiKoumokuDao skHubiKoumokuDao;


    @Inject
    private HM_SkHubiNaiyouDao skHubiNaiyouDao;


    @Inject
    private HM_SkHubiRenrakuNaiyouDao skHubiRenrakuNaiyouDao;


    @Inject
    private HM_SkSeibiSijiNaiyouDao skSeibiSijiNaiyouDao;


    @Inject
    private HM_SyouhnTaniHonkouzaDao syouhnTaniHonkouzaDao;


    @Inject
    private HM_SyouhnTaniHonkouza2Dao syouhnTaniHonkouza2Dao;


    @Inject
    private HM_TokuteiKankeiHjnNmTotugouDao tokuteiKankeiHjnNmTotugouDao;


    @Inject
    private HM_TokuteiKankeiHoujinDao tokuteiKankeiHoujinDao;


    List<HM_SkHokenSyuruiNo> getAllSkHokenSyuruiNo(){
        SortHM_SkHokenSyuruiNo sortHM_SkHokenSyuruiNo = new SortHM_SkHokenSyuruiNo();
        return sortHM_SkHokenSyuruiNo.OrderHM_SkHokenSyuruiNoByPkAsc(skHokenSyuruiNoDao.selectAll());
    }


    HM_SkHokenSyuruiNo getSkHokenSyuruiNo(C_HknsyuruiNo pHknsyuruino, Integer pHknsyuruinosd) {

        return skHokenSyuruiNoDao.getSkHokenSyuruiNo(pHknsyuruino, pHknsyuruinosd);
    }


    List<HM_SkHokenSyuruiNo> getSkHokenSyuruiNosByHknsyuruino(C_HknsyuruiNo pHknsyuruino) {

        return skHokenSyuruiNoDao.getSkHokenSyuruiNosByHknsyuruino(pHknsyuruino);
    }


    List<HM_SkHokenSyuruiNo> getSkHokenSyuruiNosByHyoujitoymdGt(BizDate pHyoujitoymd) {

        return skHokenSyuruiNoDao.getSkHokenSyuruiNosByHyoujitoymdGt(pHyoujitoymd);
    }


    List<HM_SkHokenSyuruiNo> getSkHokenSyuruiNosBySysdate(BizDate pSysdate) {

        return skHokenSyuruiNoDao.getSkHokenSyuruiNosBySysdate(pSysdate);
    }


    List<HM_SkHokenSyuruiNo> getSkHokenSyuruiNosByHyoujidate(BizDate pHyoujidate) {

        return skHokenSyuruiNoDao.getSkHokenSyuruiNosByHyoujidate(pHyoujidate);
    }


    List<HM_SkHokenSyuruiNo> getSkHokenSyuruiNosByHknsyuruinoHyoujidate(C_HknsyuruiNo pHknsyuruino, BizDate pHyoujidate) {

        return skHokenSyuruiNoDao.getSkHokenSyuruiNosByHknsyuruinoHyoujidate(pHknsyuruino, pHyoujidate);
    }


    List<HM_SkHokenSyuruiNoAisyou> getAllSkHokenSyuruiNoAisyou(){
        SortHM_SkHokenSyuruiNoAisyou sortHM_SkHokenSyuruiNoAisyou = new SortHM_SkHokenSyuruiNoAisyou();
        return sortHM_SkHokenSyuruiNoAisyou.OrderHM_SkHokenSyuruiNoAisyouByPkAsc(skHokenSyuruiNoAisyouDao.selectAll());
    }


    HM_SkHokenSyuruiNoAisyou getSkHokenSyuruiNoAisyou(C_HknsyuruiNo pHknsyuruino, Integer pHknsyuruinosdfrom, Integer pHknsyuruinosdto, String pHknsyuruinobetukey1
        , C_AisyoumeiChannelKbn pAisyoumeichannelkbn) {

        return skHokenSyuruiNoAisyouDao.getSkHokenSyuruiNoAisyou(pHknsyuruino, pHknsyuruinosdfrom, pHknsyuruinosdto, pHknsyuruinobetukey1
            , pAisyoumeichannelkbn);
    }


    List<HM_SkHokenSyuruiNoAisyou> getSkHokenSyuruiNoAisyousByHknsyuruinoAisyoumeichannelkbn(C_HknsyuruiNo pHknsyuruino, C_AisyoumeiChannelKbn pAisyoumeichannelkbn) {

        return skHokenSyuruiNoAisyouDao.getSkHokenSyuruiNoAisyousByHknsyuruinoAisyoumeichannelkbn(pHknsyuruino, pAisyoumeichannelkbn);
    }


    List<HM_SkHokenSyuruiNoAisyou> getSkHokenSyuruiNoAisyousByPK(C_HknsyuruiNo pHknsyuruino, Integer pHknsyuruinosd, C_AisyoumeiChannelKbn pAisyoumeichannelkbn, String pHknsyuruinobetukey1) {

        return skHokenSyuruiNoAisyouDao.getSkHokenSyuruiNoAisyousByPK(pHknsyuruino, pHknsyuruinosd, pAisyoumeichannelkbn, pHknsyuruinobetukey1);
    }


    List<HM_SkChannel> getAllSkChannel(){
        SortHM_SkChannel sortHM_SkChannel = new SortHM_SkChannel();
        return sortHM_SkChannel.OrderHM_SkChannelByPkAsc(skChannelDao.selectAll());
    }


    HM_SkChannel getSkChannel(C_Channelcd pChannelcd, String pOyadrtencd) {

        return skChannelDao.getSkChannel(pChannelcd, pOyadrtencd);
    }


    List<HM_SkChannel> getSkChannelsByChannelcd(C_Channelcd pChannelcd) {

        return skChannelDao.getSkChannelsByChannelcd(pChannelcd);
    }


    List<HM_SkDairitenKobetuJyouhou> getAllSkDairitenKobetuJyouhou(){
        SortHM_SkDairitenKobetuJyouhou sortHM_SkDairitenKobetuJyouhou = new SortHM_SkDairitenKobetuJyouhou();
        return sortHM_SkDairitenKobetuJyouhou.OrderHM_SkDairitenKobetuJyouhouByPkAsc(skDairitenKobetuJyouhouDao.selectAll());
    }


    HM_SkDairitenKobetuJyouhou getSkDairitenKobetuJyouhou(String pOyadrtencd) {

        return skDairitenKobetuJyouhouDao.getSkDairitenKobetuJyouhou(pOyadrtencd);
    }


    List<HM_SkDairitenKobetuJyouhou> getSkDairitenKobetuJyouhouByDrtenRnrkhouKbn(C_DrtenRnrkhouKbn pDrtenRnrkhouKbn) {

        return skDairitenKobetuJyouhouDao.getSkDairitenKobetuJyouhouByDrtenRnrkhouKbn(pDrtenRnrkhouKbn);
    }


    List<HM_TokuteiKankeiHoujin> getAllTokuteiKankeiHoujin(){
        SortHM_TokuteiKankeiHoujin sortHM_TokuteiKankeiHoujin = new SortHM_TokuteiKankeiHoujin();
        return sortHM_TokuteiKankeiHoujin.OrderHM_TokuteiKankeiHoujinByPkAsc(tokuteiKankeiHoujinDao.selectAll());
    }


    List<HM_TokuteiKankeiHoujin> getTokuteiKankeiHoujinsByTkhjnkinyuucdTkhjnkjdrtennmTkhjnnmkj(String pTkhjnkinyuucd, String pTkhjnkjdrtennm, String pTkhjnnmkj) {

        return tokuteiKankeiHoujinDao.getTokuteiKankeiHoujinsByTkhjnkinyuucdTkhjnkjdrtennmTkhjnnmkj(pTkhjnkinyuucd, pTkhjnkjdrtennm, pTkhjnnmkj);

    }


    HM_TokuteiKankeiHoujin getTokuteiKankeiHoujin(String pTkhjnkinyuucd, BizNumber pMeisaino) {

        return tokuteiKankeiHoujinDao.getTokuteiKankeiHoujin(pTkhjnkinyuucd, pMeisaino);
    }


    ExDBResults<HM_TokuteiKankeiHoujin> getTokuteiKankeiHoujins() {

        return tokuteiKankeiHoujinDao.getTokuteiKankeiHoujins();
    }


    List<HM_TokuteiKankeiHjnNmTotugou> getAllTokuteiKankeiHjnNmTotugou(){
        SortHM_TokuteiKankeiHjnNmTotugou sortHM_TokuteiKankeiHjnNmTotugou = new SortHM_TokuteiKankeiHjnNmTotugou();
        return sortHM_TokuteiKankeiHjnNmTotugou.OrderHM_TokuteiKankeiHjnNmTotugouByPkAsc(tokuteiKankeiHjnNmTotugouDao.selectAll());
    }


    HM_TokuteiKankeiHjnNmTotugou getTokuteiKankeiHjnNmTotugou(String pTkhjnkinyuucd, BizNumber pMeisaino, Integer pRenno) {

        return tokuteiKankeiHjnNmTotugouDao.getTokuteiKankeiHjnNmTotugou(pTkhjnkinyuucd, pMeisaino, pRenno);
    }


    List<String> getTotugoutkhjnnmkjsByTkhjnkinyuucd(String pTkhjnkinyuucd) {
        return tokuteiKankeiHjnNmTotugouDao.getTotugoutkhjnnmkjsByTkhjnkinyuucd(pTkhjnkinyuucd);
    }


    List<HM_SiinBunrui> getAllSiinBunrui(){
        SortHM_SiinBunrui sortHM_SiinBunrui = new SortHM_SiinBunrui();
        return sortHM_SiinBunrui.OrderHM_SiinBunruiByPkAsc(siinBunruiDao.selectAll());
    }


    HM_SiinBunrui getSiinBunrui(String pSiincd) {

        return siinBunruiDao.getSiinBunrui(pSiincd);
    }


    List<HM_SkHubiKoumoku> getAllSkHubiKoumoku(){
        SortHM_SkHubiKoumoku sortHM_SkHubiKoumoku = new SortHM_SkHubiKoumoku();
        return sortHM_SkHubiKoumoku.OrderHM_SkHubiKoumokuByPkAsc(skHubiKoumokuDao.selectAll());
    }


    HM_SkHubiKoumoku getSkHubiKoumoku(C_SyoruiCdKbn pSyoruiCd, String pSkhubikoumokucd) {

        return skHubiKoumokuDao.getSkHubiKoumoku(pSyoruiCd, pSkhubikoumokucd);
    }


    List<HM_SkHubiKoumoku> getSkHubiKoumokusBySyoruiCd(C_SyoruiCdKbn pSyoruiCd) {

        return skHubiKoumokuDao.getSkHubiKoumokusBySyoruiCd(pSyoruiCd);
    }


    List<HM_SkHubiNaiyou> getSkHubiNaiyousBySkhubikoumokucd(String pSkhubikoumokucd) {

        return skHubiNaiyouDao.getSkHubiNaiyousBySkhubikoumokucd(pSkhubikoumokucd);
    }


    List<HM_SkHubiNaiyou> getAllSkHubiNaiyou(){
        SortHM_SkHubiNaiyou sortHM_SkHubiNaiyou = new SortHM_SkHubiNaiyou();
        return sortHM_SkHubiNaiyou.OrderHM_SkHubiNaiyouByPkAsc(skHubiNaiyouDao.selectAll());
    }


    HM_SkHubiNaiyou getSkHubiNaiyou(String pSkhubikoumokucd, String pSkhubinaiyoucd) {

        return skHubiNaiyouDao.getSkHubiNaiyou(pSkhubikoumokucd, pSkhubinaiyoucd);
    }


    List<HM_SkHubiRenrakuNaiyou> getAllSkHubiRenrakuNaiyou(){
        SortHM_SkHubiRenrakuNaiyou sortHM_SkHubiRenrakuNaiyou = new SortHM_SkHubiRenrakuNaiyou();
        return sortHM_SkHubiRenrakuNaiyou.OrderHM_SkHubiRenrakuNaiyouByPkAsc(skHubiRenrakuNaiyouDao.selectAll());
    }


    HM_SkHubiRenrakuNaiyou getSkHubiRenrakuNaiyou(String pSkhubirenrakunaiyoucd) {

        return skHubiRenrakuNaiyouDao.getSkHubiRenrakuNaiyou(pSkhubirenrakunaiyoucd);
    }


    List<HM_SkSeibiSijiNaiyou> getAllSkSeibiSijiNaiyou(){
        SortHM_SkSeibiSijiNaiyou sortHM_SkSeibiSijiNaiyou = new SortHM_SkSeibiSijiNaiyou();
        return sortHM_SkSeibiSijiNaiyou.OrderHM_SkSeibiSijiNaiyouByHyoujijyunAsc(skSeibiSijiNaiyouDao.selectAll());
    }


    HM_SkSeibiSijiNaiyou getSkSeibiSijiNaiyou(String pSkseibisijinaiyoucd) {

        return skSeibiSijiNaiyouDao.getSkSeibiSijiNaiyou(pSkseibisijinaiyoucd);
    }


    List<HM_HurikomiKouza> getAllHurikomiKouza(){
        SortHM_HurikomiKouza sortHM_HurikomiKouza = new SortHM_HurikomiKouza();
        return sortHM_HurikomiKouza.OrderHM_HurikomiKouzaByPkAsc(hurikomiKouzaDao.selectAll());
    }


    List<HM_HurikomiKouza> getHurikomiKouzasByTuukasyuNe(C_Tuukasyu  pTuukasyu) {

        return hurikomiKouzaDao.getHurikomiKouzasByTuukasyuNe(pTuukasyu);
    }


    HM_HurikomiKouza getHurikomiKouza(String pBankcd, String pSitencd, String pKouzano, C_Tuukasyu pTuukasyu, String pHrkmirnincd) {

        return hurikomiKouzaDao.getHurikomiKouza(pBankcd, pSitencd, pKouzano, pTuukasyu, pHrkmirnincd);
    }


    List<HM_HurikomiKouza> getHurikomiKouzasByBankcdSitencdKouzanoTuukasyuYokinkbn(String pBankcd, String pSitencd, String pKouzano, C_Tuukasyu pTuukasyu, C_YokinKbn pYokinkbn) {

        return hurikomiKouzaDao.getHurikomiKouzasByBankcdSitencdKouzanoTuukasyuYokinkbn(pBankcd, pSitencd, pKouzano, pTuukasyu, pYokinkbn);
    }


    List<HM_HurikomiKouza> getHurikomiKouzasByBankcdSitencdKouzanoTuukasyu(String pBankcd, String pSitencd, String pKouzano, C_Tuukasyu pTuukasyu) {

        return hurikomiKouzaDao.getHurikomiKouzasByBankcdSitencdKouzanoTuukasyu(pBankcd, pSitencd, pKouzano, pTuukasyu);
    }


    List<HM_HurikomiKouza> getHurikomiKouzasByTuukasyu(C_Tuukasyu pTuukasyu) {

        return hurikomiKouzaDao.getHurikomiKouzasByTuukasyu(pTuukasyu);
    }


    List<HM_ChkTesuuryou> getAllChkTesuuryou(){
        SortHM_ChkTesuuryou sortHM_ChkTesuuryou = new SortHM_ChkTesuuryou();
        return sortHM_ChkTesuuryou.OrderHM_ChkTesuuryouByPkAsc(chkTesuuryouDao.selectAll());
    }


    HM_ChkTesuuryou getChkTesuuryou(Integer pRenno3keta) {

        return chkTesuuryouDao.getChkTesuuryou(pRenno3keta);
    }


    List<HM_Honkouza> getAllHonkouza(){
        SortHM_Honkouza sortHM_Honkouza = new SortHM_Honkouza();
        return sortHM_Honkouza.OrderHM_HonkouzaByPkAsc(honkouzaDao.selectAll());
    }


    HM_Honkouza getHonkouza(String pHonkouzacd) {

        return honkouzaDao.getHonkouza(pHonkouzacd);
    }


    List<HM_SyouhnTaniHonkouza> getAllSyouhnTaniHonkouza(){
        SortHM_SyouhnTaniHonkouza sortHM_SyouhnTaniHonkouza = new SortHM_SyouhnTaniHonkouza();
        return sortHM_SyouhnTaniHonkouza.OrderHM_SyouhnTaniHonkouzaByPkAsc(syouhnTaniHonkouzaDao.selectAll());
    }


    HM_SyouhnTaniHonkouza getSyouhnTaniHonkouza(String pSyouhncd) {

        return syouhnTaniHonkouzaDao.getSyouhnTaniHonkouza(pSyouhncd);
    }


    List<HM_SyouhnTaniHonkouza2> getAllSyouhnTaniHonkouza2(){
        SortHM_SyouhnTaniHonkouza2 sortHM_SyouhnTaniHonkouza2 = new SortHM_SyouhnTaniHonkouza2();
        return sortHM_SyouhnTaniHonkouza2.OrderHM_SyouhnTaniHonkouza2ByPkAsc(syouhnTaniHonkouza2Dao.selectAll());
    }


    HM_SyouhnTaniHonkouza2 getSyouhnTaniHonkouza2(String pSyouhncd, C_Tuukasyu pKyktuukasyu) {

        return syouhnTaniHonkouza2Dao.getSyouhnTaniHonkouza2(pSyouhncd, pKyktuukasyu);
    }

}
