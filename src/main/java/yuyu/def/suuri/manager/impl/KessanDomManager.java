package yuyu.def.suuri.manager.impl;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_NaibuKeiyakuKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TekiyouKbn;
import yuyu.def.db.dao.ST_BknkykHtjynbknDao;
import yuyu.def.db.dao.ST_ConvertKanjyouKamokuDao;
import yuyu.def.db.dao.ST_DshrTukiTyukeiyouItzHznDao;
import yuyu.def.db.dao.ST_HoyuuMeisaiTyukeiyouItzHznDao;
import yuyu.def.db.dao.ST_IdouMeisaiTyukeiyouItzHznDao;
import yuyu.def.db.dao.ST_SkKessanSyukeiDao;
import yuyu.def.db.dao.ST_SkOikmKaikeiDao;
import yuyu.def.db.dao.ST_SkOikmSyukeiPDenpyouDao;
import yuyu.def.db.dao.ST_SkOikmTyouseiDenpyouDao;
import yuyu.def.db.dao.ST_SuuriyouErrJyouhouDao;
import yuyu.def.db.dao.ST_SynypTukiTugtTykiyuHozonDao;
import yuyu.def.db.dao.ST_SynypTukiYkgtIkouHozonDao;
import yuyu.def.db.dao.ST_YuukoukykHtjynbknKaridDao;
import yuyu.def.db.dao.ST_YuukoukykHtjynbknTmttdDao;
import yuyu.def.db.entity.ST_BknkykHtjynbkn;
import yuyu.def.db.entity.ST_ConvertKanjyouKamoku;
import yuyu.def.db.entity.ST_DshrTukiTyukeiyouItzHzn;
import yuyu.def.db.entity.ST_HoyuuMeisaiTyukeiyouItzHzn;
import yuyu.def.db.entity.ST_IdouMeisaiTyukeiyouItzHzn;
import yuyu.def.db.entity.ST_SkKessanSyukei;
import yuyu.def.db.entity.ST_SkOikmKaikei;
import yuyu.def.db.entity.ST_SkOikmSyukeiPDenpyou;
import yuyu.def.db.entity.ST_SkOikmTyouseiDenpyou;
import yuyu.def.db.entity.ST_SuuriyouErrJyouhou;
import yuyu.def.db.entity.ST_SynypTukiTugtTykiyuHozon;
import yuyu.def.db.entity.ST_SynypTukiYkgtIkouHozon;
import yuyu.def.db.entity.ST_YuukoukykHtjynbknKarid;
import yuyu.def.db.entity.ST_YuukoukykHtjynbknTmttd;
import yuyu.def.suuri.result.bean.SkOikmKaikeiTyouseiDensByDenymdSyoriYmdBean;
import yuyu.def.suuri.result.bean.SkOikmTyouseiDenpyouHkrDnpsBean;
import yuyu.def.suuri.result.bean.SkOikmTyouseiDenpyouInfosBean;
import yuyu.def.suuri.sorter.SortST_BknkykHtjynbkn;
import yuyu.def.suuri.sorter.SortST_ConvertKanjyouKamoku;
import yuyu.def.suuri.sorter.SortST_DshrTukiTyukeiyouItzHzn;
import yuyu.def.suuri.sorter.SortST_HoyuuMeisaiTyukeiyouItzHzn;
import yuyu.def.suuri.sorter.SortST_IdouMeisaiTyukeiyouItzHzn;
import yuyu.def.suuri.sorter.SortST_SkKessanSyukei;
import yuyu.def.suuri.sorter.SortST_SkOikmKaikei;
import yuyu.def.suuri.sorter.SortST_SkOikmSyukeiPDenpyou;
import yuyu.def.suuri.sorter.SortST_SkOikmTyouseiDenpyou;
import yuyu.def.suuri.sorter.SortST_SuuriyouErrJyouhou;
import yuyu.def.suuri.sorter.SortST_SynypTukiTugtTykiyuHozon;
import yuyu.def.suuri.sorter.SortST_SynypTukiYkgtIkouHozon;
import yuyu.def.suuri.sorter.SortST_YuukoukykHtjynbknKarid;
import yuyu.def.suuri.sorter.SortST_YuukoukykHtjynbknTmttd;


/**
 * KessanDomマネージャー<br />
 * Kessanにおける、DB操作を提供する。<br />
 */
class KessanDomManager {


    @Inject
    private ST_BknkykHtjynbknDao bknkykHtjynbknDao;


    @Inject
    private ST_ConvertKanjyouKamokuDao convertKanjyouKamokuDao;


    @Inject
    private ST_DshrTukiTyukeiyouItzHznDao dshrTukiTyukeiyouItzHznDao;


    @Inject
    private ST_HoyuuMeisaiTyukeiyouItzHznDao hoyuuMeisaiTyukeiyouItzHznDao;


    @Inject
    private ST_IdouMeisaiTyukeiyouItzHznDao idouMeisaiTyukeiyouItzHznDao;


    @Inject
    private ST_SkKessanSyukeiDao skKessanSyukeiDao;


    @Inject
    private ST_SkOikmKaikeiDao skOikmKaikeiDao;


    @Inject
    private ST_SkOikmSyukeiPDenpyouDao skOikmSyukeiPDenpyouDao;


    @Inject
    private ST_SkOikmTyouseiDenpyouDao skOikmTyouseiDenpyouDao;


    @Inject
    private ST_SuuriyouErrJyouhouDao suuriyouErrJyouhouDao;


    @Inject
    private ST_SynypTukiTugtTykiyuHozonDao synypTukiTugtTykiyuHozonDao;


    @Inject
    private ST_SynypTukiYkgtIkouHozonDao synypTukiYkgtIkouHozonDao;


    @Inject
    private ST_YuukoukykHtjynbknKaridDao yuukoukykHtjynbknKaridDao;


    @Inject
    private ST_YuukoukykHtjynbknTmttdDao yuukoukykHtjynbknTmttdDao;


    List<ST_SkOikmTyouseiDenpyou> getAllSkOikmTyouseiDenpyou(){
        SortST_SkOikmTyouseiDenpyou sortST_SkOikmTyouseiDenpyou = new SortST_SkOikmTyouseiDenpyou();
        return sortST_SkOikmTyouseiDenpyou.OrderST_SkOikmTyouseiDenpyouByPkAsc(skOikmTyouseiDenpyouDao.selectAll());
    }


    ST_SkOikmTyouseiDenpyou getSkOikmTyouseiDenpyou(String pMosno, C_Kanjyoukmkcd pKanjyoukmkcd, C_TaisyakuKbn  pTaisyakukbn, C_NaibuKeiyakuKbn pNaibukeiyakukbn
        , C_TekiyouKbn pTekiyoukbn, C_Segcd pSeg1cd) {

        return skOikmTyouseiDenpyouDao.getSkOikmTyouseiDenpyou(pMosno, pKanjyoukmkcd, pTaisyakukbn, pNaibukeiyakukbn
            , pTekiyoukbn, pSeg1cd);
    }


    ExDBResults<ST_SkOikmTyouseiDenpyou> getSkOikmTyouseiDenpyous() {

        return skOikmTyouseiDenpyouDao.getSkOikmTyouseiDenpyous();
    }


    List<ST_SkOikmSyukeiPDenpyou> getAllSkOikmSyukeiPDenpyou(){
        SortST_SkOikmSyukeiPDenpyou sortST_SkOikmSyukeiPDenpyou = new SortST_SkOikmSyukeiPDenpyou();
        return sortST_SkOikmSyukeiPDenpyou.OrderST_SkOikmSyukeiPDenpyouByPkAsc(skOikmSyukeiPDenpyouDao.selectAll());
    }


    ST_SkOikmSyukeiPDenpyou getSkOikmSyukeiPDenpyou(C_DensysKbn pDensyskbn, String pDenrenno, Integer pEdano) {

        return skOikmSyukeiPDenpyouDao.getSkOikmSyukeiPDenpyou(pDensyskbn, pDenrenno, pEdano);
    }


    ExDBResults<SkOikmTyouseiDenpyouHkrDnpsBean> getSkOikmTyouseiDenpyouHkrDnps() {

        return skOikmSyukeiPDenpyouDao.getSkOikmTyouseiDenpyouHkrDnps();
    }


    List<ST_SkOikmKaikei> getAllSkOikmKaikei(){
        SortST_SkOikmKaikei sortST_SkOikmKaikei = new SortST_SkOikmKaikei();
        return sortST_SkOikmKaikei.OrderST_SkOikmKaikeiByPkAsc(skOikmKaikeiDao.selectAll());
    }


    ST_SkOikmKaikei getSkOikmKaikei(C_DensysKbn pDensyskbn, String pDenrenno, Integer pEdano) {

        return skOikmKaikeiDao.getSkOikmKaikei(pDensyskbn, pDenrenno, pEdano);
    }


    ExDBResults<SkOikmKaikeiTyouseiDensByDenymdSyoriYmdBean> getSkOikmKaikeiTyouseiDensByDenymdSyoriYmd(BizDate pDenymd, BizDate pSyoriYmd) {

        return skOikmKaikeiDao.getSkOikmKaikeiTyouseiDensByDenymdSyoriYmd(pDenymd, pSyoriYmd);
    }


    ExDBResults<ST_SkOikmKaikei> getSkOikmKaikeisByDensyorikbnDenymdSyoriYmd(BizDate pDenymd, BizDate pSyoriYmd) {

        return skOikmKaikeiDao.getSkOikmKaikeisByDensyorikbnDenymdSyoriYmd(pDenymd, pSyoriYmd);
    }


    List<ST_SkKessanSyukei> getAllSkKessanSyukei(){
        SortST_SkKessanSyukei sortST_SkKessanSyukei = new SortST_SkKessanSyukei();
        return sortST_SkKessanSyukei.OrderST_SkKessanSyukeiByPkAsc(skKessanSyukeiDao.selectAll());
    }


    ST_SkKessanSyukei getSkKessanSyukei(String pMosno, BizDate pSuitouymd, C_Kanjyoukmkcd pKanjyoukmkcd, C_TaisyakuKbn pTaisyakukbn, C_NaibuKeiyakuKbn pNaibukeiyakukbn
        , C_TekiyouKbn pTekiyoukbn, C_Segcd pSeg1cd) {

        return skKessanSyukeiDao.getSkKessanSyukei(pMosno, pSuitouymd, pKanjyoukmkcd, pTaisyakukbn, pNaibukeiyakukbn
            , pTekiyoukbn, pSeg1cd);
    }


    List<ST_SkKessanSyukei> getSkKessanSyukeisByDenymd(BizDate pDenymd) {

        return skKessanSyukeiDao.getSkKessanSyukeisByDenymd(pDenymd);
    }


    List<ST_SkKessanSyukei> getSkKessanSyukeisBySeg1cdDenymd(BizDate pDenymd) {

        return skKessanSyukeiDao.getSkKessanSyukeisBySeg1cdDenymd(pDenymd);
    }


    List<ST_SkKessanSyukei> getSkKessanSyukeisKanjyouKamokuTantouCdByDenymd(BizDate pDenymd) {

        return skKessanSyukeiDao.getSkKessanSyukeisKanjyouKamokuTantouCdByDenymd(pDenymd);
    }


    List<ST_ConvertKanjyouKamoku> getAllConvertKanjyouKamoku(){
        SortST_ConvertKanjyouKamoku sortST_ConvertKanjyouKamoku = new SortST_ConvertKanjyouKamoku();
        return sortST_ConvertKanjyouKamoku.OrderST_ConvertKanjyouKamokuByPkAsc(convertKanjyouKamokuDao.selectAll());
    }


    ST_ConvertKanjyouKamoku getConvertKanjyouKamoku(C_Kanjyoukmkcd pKanjyoukmkcd, C_TaisyakuKbn pTaisyakukbn) {

        return convertKanjyouKamokuDao.getConvertKanjyouKamoku(pKanjyoukmkcd, pTaisyakukbn);
    }


    ExDBResults<SkOikmTyouseiDenpyouInfosBean> getSkOikmTyouseiDenpyouInfos() {

        return skOikmTyouseiDenpyouDao.getSkOikmTyouseiDenpyouInfos();
    }


    List<ST_SuuriyouErrJyouhou> getAllSuuriyouErrJyouhou() {
        SortST_SuuriyouErrJyouhou sortST_SuuriyouErrJyouhou = new SortST_SuuriyouErrJyouhou();
        return sortST_SuuriyouErrJyouhou.OrderST_SuuriyouErrJyouhouByPkAsc(suuriyouErrJyouhouDao.selectAll());
    }


    ST_SuuriyouErrJyouhou getSuuriyouErrJyouhou(BizDate pSyoriYmd, String pKakutyoujobcd, String pSyono, String pGyoumuKousinTime, String pSuuritoukeiyouerrnaiyou) {

        return suuriyouErrJyouhouDao.getSuuriyouErrJyouhou(pSyoriYmd, pKakutyoujobcd, pSyono, pGyoumuKousinTime, pSuuritoukeiyouerrnaiyou);
    }


    List<ST_HoyuuMeisaiTyukeiyouItzHzn> getAllHoyuuMeisaiTyukeiyouItzHzn(){
        SortST_HoyuuMeisaiTyukeiyouItzHzn sortST_HoyuuMeisaiTyukeiyouItzHzn = new SortST_HoyuuMeisaiTyukeiyouItzHzn();
        return sortST_HoyuuMeisaiTyukeiyouItzHzn.OrderST_HoyuuMeisaiTyukeiyouItzHznByPkAsc(hoyuuMeisaiTyukeiyouItzHznDao.selectAll());
    }


    ST_HoyuuMeisaiTyukeiyouItzHzn getHoyuuMeisaiTyukeiyouItzHzn(String pZtysrkijyunym, String pZtysrkakutyoujobcd, Integer pZtysequenceno) {

        return hoyuuMeisaiTyukeiyouItzHznDao.getHoyuuMeisaiTyukeiyouItzHzn(pZtysrkijyunym, pZtysrkakutyoujobcd, pZtysequenceno);
    }


    List<ST_IdouMeisaiTyukeiyouItzHzn> getAllIdouMeisaiTyukeiyouItzHzn(){
        SortST_IdouMeisaiTyukeiyouItzHzn sortST_IdouMeisaiTyukeiyouItzHzn = new SortST_IdouMeisaiTyukeiyouItzHzn();
        return sortST_IdouMeisaiTyukeiyouItzHzn.OrderST_IdouMeisaiTyukeiyouItzHznByPkAsc(idouMeisaiTyukeiyouItzHznDao.selectAll());
    }


    ST_IdouMeisaiTyukeiyouItzHzn getIdouMeisaiTyukeiyouItzHzn(String pZtysrkijyunym, String pZtysrkakutyoujobcd, Integer pZtysequenceno) {

        return idouMeisaiTyukeiyouItzHznDao.getIdouMeisaiTyukeiyouItzHzn(pZtysrkijyunym, pZtysrkakutyoujobcd, pZtysequenceno);
    }


    List<ST_SynypTukiTugtTykiyuHozon> getAllSynypTukiTugtTykiyuHozon(){
        SortST_SynypTukiTugtTykiyuHozon sortST_SynypTukiTugtTykiyuHozon = new SortST_SynypTukiTugtTykiyuHozon();
        return sortST_SynypTukiTugtTykiyuHozon.OrderST_SynypTukiTugtTykiyuHozonByPkAsc(synypTukiTugtTykiyuHozonDao.selectAll());
    }


    ST_SynypTukiTugtTykiyuHozon getSynypTukiTugtTykiyuHozon(String pZtysrkijyunym, String pZtysrkakutyoujobcd, Integer pZtysequenceno) {

        return synypTukiTugtTykiyuHozonDao.getSynypTukiTugtTykiyuHozon(pZtysrkijyunym, pZtysrkakutyoujobcd, pZtysequenceno);
    }


    List<ST_SynypTukiYkgtIkouHozon> getAllSynypTukiYkgtIkouHozon(){
        SortST_SynypTukiYkgtIkouHozon sortST_SynypTukiYkgtIkouHozon = new SortST_SynypTukiYkgtIkouHozon();
        return sortST_SynypTukiYkgtIkouHozon.OrderST_SynypTukiYkgtIkouHozonByPkAsc(synypTukiYkgtIkouHozonDao.selectAll());
    }


    ST_SynypTukiYkgtIkouHozon getSynypTukiYkgtIkouHozon(String pSrkijyunym, Integer pSequenceno, String pSyono, BizDateYM pJyutoustartym, BizDateYM pJyutouendym
        , C_TaisyakuKbn pTaisyakukbn) {

        return synypTukiYkgtIkouHozonDao.getSynypTukiYkgtIkouHozon(pSrkijyunym, pSequenceno, pSyono, pJyutoustartym, pJyutouendym
            , pTaisyakukbn);
    }


    List<ST_YuukoukykHtjynbknTmttd> getAllYuukoukykHtjynbknTmttd(){
        SortST_YuukoukykHtjynbknTmttd sortST_YuukoukykHtjynbknTmttd = new SortST_YuukoukykHtjynbknTmttd();
        return sortST_YuukoukykHtjynbknTmttd.OrderST_YuukoukykHtjynbknTmttdByPkAsc(yuukoukykHtjynbknTmttdDao.selectAll());
    }


    ST_YuukoukykHtjynbknTmttd getYuukoukykHtjynbknTmttd(BizDate pSyoriYmd, String pKakutyoujobcd, String pSyono, String pSrkijyunym) {

        return yuukoukykHtjynbknTmttdDao.getYuukoukykHtjynbknTmttd(pSyoriYmd, pKakutyoujobcd, pSyono, pSrkijyunym);
    }


    List<ST_YuukoukykHtjynbknKarid> getAllYuukoukykHtjynbknKarid(){
        SortST_YuukoukykHtjynbknKarid sortST_YuukoukykHtjynbknKarid = new SortST_YuukoukykHtjynbknKarid();
        return sortST_YuukoukykHtjynbknKarid.OrderST_YuukoukykHtjynbknKaridByPkAsc(yuukoukykHtjynbknKaridDao.selectAll());
    }


    ST_YuukoukykHtjynbknKarid getYuukoukykHtjynbknKarid(BizDate pSyoriYmd, String pKakutyoujobcd, String pSyono, String pSrkijyunym) {

        return yuukoukykHtjynbknKaridDao.getYuukoukykHtjynbknKarid(pSyoriYmd, pKakutyoujobcd, pSyono, pSrkijyunym);
    }


    List<ST_BknkykHtjynbkn> getAllBknkykHtjynbkn(){
        SortST_BknkykHtjynbkn sortST_BknkykHtjynbkn = new SortST_BknkykHtjynbkn();
        return sortST_BknkykHtjynbkn.OrderST_BknkykHtjynbknByPkAsc(bknkykHtjynbknDao.selectAll());
    }


    ST_BknkykHtjynbkn getBknkykHtjynbkn(BizDate pSyoriYmd, String pKakutyoujobcd, String pSyono, String pSrkijyunym) {

        return bknkykHtjynbknDao.getBknkykHtjynbkn(pSyoriYmd, pKakutyoujobcd, pSyono, pSrkijyunym);
    }


    List<ST_DshrTukiTyukeiyouItzHzn> getAllDshrTukiTyukeiyouItzHzn(){
        SortST_DshrTukiTyukeiyouItzHzn sortST_DshrTukiTyukeiyouItzHzn = new SortST_DshrTukiTyukeiyouItzHzn();
        return sortST_DshrTukiTyukeiyouItzHzn.OrderST_DshrTukiTyukeiyouItzHznByPkAsc(dshrTukiTyukeiyouItzHznDao.selectAll());
    }


    ST_DshrTukiTyukeiyouItzHzn getDshrTukiTyukeiyouItzHzn(Integer pZtysequenceno) {

        return dshrTukiTyukeiyouItzHznDao.getDshrTukiTyukeiyouItzHzn(pZtysequenceno);
    }

}
