package yuyu.def.biz.manager.impl;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.biz.sorter.SortBM_AzukariRiritu;
import yuyu.def.biz.sorter.SortBM_FundIndexCfGaku;
import yuyu.def.biz.sorter.SortBM_FundIndexGessyoCf;
import yuyu.def.biz.sorter.SortBM_FundIndexGetumatuCf;
import yuyu.def.biz.sorter.SortBM_FundIndexKihon;
import yuyu.def.biz.sorter.SortBM_FundIndexSyokitousi;
import yuyu.def.biz.sorter.SortBM_HaitouRiritu;
import yuyu.def.biz.sorter.SortBM_HsykkntkSysnNkGnsritu;
import yuyu.def.biz.sorter.SortBM_IkkatuKeisuu;
import yuyu.def.biz.sorter.SortBM_IkkatuTekiyouNo;
import yuyu.def.biz.sorter.SortBM_IkkatuTekiyouNo2;
import yuyu.def.biz.sorter.SortBM_KaiyakuKoujyoRitu;
import yuyu.def.biz.sorter.SortBM_KawaseRate;
import yuyu.def.biz.sorter.SortBM_KijyungkHanteiKawaseRate;
import yuyu.def.biz.sorter.SortBM_KktNk1stNkBigkGnsritu;
import yuyu.def.biz.sorter.SortBM_KktNkGnsritu;
import yuyu.def.biz.sorter.SortBM_NenkinYoteiRiritu;
import yuyu.def.biz.sorter.SortBM_RateD;
import yuyu.def.biz.sorter.SortBM_RateNenkinD;
import yuyu.def.biz.sorter.SortBM_RateNenkinPkisoV;
import yuyu.def.biz.sorter.SortBM_RateP;
import yuyu.def.biz.sorter.SortBM_RateP2;
import yuyu.def.biz.sorter.SortBM_RateV;
import yuyu.def.biz.sorter.SortBM_RateV2;
import yuyu.def.biz.sorter.SortBM_RateW;
import yuyu.def.biz.sorter.SortBM_RisaHitSyouhnyouRateD;
import yuyu.def.biz.sorter.SortBM_RisaHitSyouhnyouRateD2;
import yuyu.def.biz.sorter.SortBM_SibouRitu;
import yuyu.def.biz.sorter.SortBM_Sisuu;
import yuyu.def.biz.sorter.SortBM_SisuuKihon;
import yuyu.def.biz.sorter.SortBM_SjkkkTyouseiyouRiritu;
import yuyu.def.biz.sorter.SortBM_SjkkkTyouseiyouRiritu2;
import yuyu.def.biz.sorter.SortBM_TienrisokuRiritu;
import yuyu.def.biz.sorter.SortBM_TuukabetuKyuusibi;
import yuyu.def.biz.sorter.SortBM_UnitFundKbn;
import yuyu.def.biz.sorter.SortBM_YoteiRiritu;
import yuyu.def.biz.sorter.SortBM_YoteiRiritu2;
import yuyu.def.biz.sorter.SortBM_YoteiRiritu3;
import yuyu.def.biz.sorter.SortBM_YoteiRirituRendouSeigyo;
import yuyu.def.biz.sorter.SortBM_ZennouGenkaRitu;
import yuyu.def.biz.sorter.SortBM_ZennouGenkaRitu2;
import yuyu.def.biz.sorter.SortBM_ZennouKeikaRiritu;
import yuyu.def.biz.sorter.SortBM_ZennouKeikaRiritu2;
import yuyu.def.biz.sorter.SortBM_ZennouRiritu;
import yuyu.def.biz.sorter.SortBM_ZennouRiritu2;
import yuyu.def.biz.sorter.SortBM_ZennouTumitateRitu;
import yuyu.def.biz.sorter.SortBM_ZennouTumitateRitu2;
import yuyu.def.classification.C_HhknNenKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_KwsrendouKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_Sisuukbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UnitFundKbn;
import yuyu.def.db.dao.BM_AzukariRirituDao;
import yuyu.def.db.dao.BM_FundIndexCfGakuDao;
import yuyu.def.db.dao.BM_FundIndexGessyoCfDao;
import yuyu.def.db.dao.BM_FundIndexGetumatuCfDao;
import yuyu.def.db.dao.BM_FundIndexKihonDao;
import yuyu.def.db.dao.BM_FundIndexSyokitousiDao;
import yuyu.def.db.dao.BM_HaitouRirituDao;
import yuyu.def.db.dao.BM_HsykkntkSysnNkGnsrituDao;
import yuyu.def.db.dao.BM_IkkatuKeisuuDao;
import yuyu.def.db.dao.BM_IkkatuTekiyouNoDao;
import yuyu.def.db.dao.BM_IkkatuTekiyouNo2Dao;
import yuyu.def.db.dao.BM_KaiyakuKoujyoRituDao;
import yuyu.def.db.dao.BM_KawaseRateDao;
import yuyu.def.db.dao.BM_KijyungkHanteiKawaseRateDao;
import yuyu.def.db.dao.BM_KktNk1stNkBigkGnsrituDao;
import yuyu.def.db.dao.BM_KktNkGnsrituDao;
import yuyu.def.db.dao.BM_NenkinYoteiRirituDao;
import yuyu.def.db.dao.BM_RateDDao;
import yuyu.def.db.dao.BM_RateNenkinDDao;
import yuyu.def.db.dao.BM_RateNenkinPkisoVDao;
import yuyu.def.db.dao.BM_RateP2Dao;
import yuyu.def.db.dao.BM_RatePDao;
import yuyu.def.db.dao.BM_RateV2Dao;
import yuyu.def.db.dao.BM_RateVDao;
import yuyu.def.db.dao.BM_RateWDao;
import yuyu.def.db.dao.BM_RisaHitSyouhnyouRateD2Dao;
import yuyu.def.db.dao.BM_RisaHitSyouhnyouRateDDao;
import yuyu.def.db.dao.BM_SibouRituDao;
import yuyu.def.db.dao.BM_SisuuDao;
import yuyu.def.db.dao.BM_SisuuKihonDao;
import yuyu.def.db.dao.BM_SjkkkTyouseiyouRiritu2Dao;
import yuyu.def.db.dao.BM_SjkkkTyouseiyouRirituDao;
import yuyu.def.db.dao.BM_TienrisokuRirituDao;
import yuyu.def.db.dao.BM_TuukabetuKyuusibiDao;
import yuyu.def.db.dao.BM_UnitFundKbnDao;
import yuyu.def.db.dao.BM_YoteiRiritu2Dao;
import yuyu.def.db.dao.BM_YoteiRiritu3Dao;
import yuyu.def.db.dao.BM_YoteiRirituDao;
import yuyu.def.db.dao.BM_YoteiRirituRendouSeigyoDao;
import yuyu.def.db.dao.BM_ZennouGenkaRitu2Dao;
import yuyu.def.db.dao.BM_ZennouGenkaRituDao;
import yuyu.def.db.dao.BM_ZennouKeikaRiritu2Dao;
import yuyu.def.db.dao.BM_ZennouKeikaRirituDao;
import yuyu.def.db.dao.BM_ZennouRiritu2Dao;
import yuyu.def.db.dao.BM_ZennouRirituDao;
import yuyu.def.db.dao.BM_ZennouTumitateRitu2Dao;
import yuyu.def.db.dao.BM_ZennouTumitateRituDao;
import yuyu.def.db.entity.BM_AzukariRiritu;
import yuyu.def.db.entity.BM_FundIndexCfGaku;
import yuyu.def.db.entity.BM_FundIndexGessyoCf;
import yuyu.def.db.entity.BM_FundIndexGetumatuCf;
import yuyu.def.db.entity.BM_FundIndexKihon;
import yuyu.def.db.entity.BM_FundIndexSyokitousi;
import yuyu.def.db.entity.BM_HaitouRiritu;
import yuyu.def.db.entity.BM_HsykkntkSysnNkGnsritu;
import yuyu.def.db.entity.BM_IkkatuKeisuu;
import yuyu.def.db.entity.BM_IkkatuTekiyouNo;
import yuyu.def.db.entity.BM_IkkatuTekiyouNo2;
import yuyu.def.db.entity.BM_KaiyakuKoujyoRitu;
import yuyu.def.db.entity.BM_KawaseRate;
import yuyu.def.db.entity.BM_KijyungkHanteiKawaseRate;
import yuyu.def.db.entity.BM_KktNk1stNkBigkGnsritu;
import yuyu.def.db.entity.BM_KktNkGnsritu;
import yuyu.def.db.entity.BM_NenkinYoteiRiritu;
import yuyu.def.db.entity.BM_RateD;
import yuyu.def.db.entity.BM_RateNenkinD;
import yuyu.def.db.entity.BM_RateNenkinPkisoV;
import yuyu.def.db.entity.BM_RateP;
import yuyu.def.db.entity.BM_RateP2;
import yuyu.def.db.entity.BM_RateV;
import yuyu.def.db.entity.BM_RateV2;
import yuyu.def.db.entity.BM_RateW;
import yuyu.def.db.entity.BM_RisaHitSyouhnyouRateD;
import yuyu.def.db.entity.BM_RisaHitSyouhnyouRateD2;
import yuyu.def.db.entity.BM_SibouRitu;
import yuyu.def.db.entity.BM_Sisuu;
import yuyu.def.db.entity.BM_SisuuKihon;
import yuyu.def.db.entity.BM_SjkkkTyouseiyouRiritu;
import yuyu.def.db.entity.BM_SjkkkTyouseiyouRiritu2;
import yuyu.def.db.entity.BM_TienrisokuRiritu;
import yuyu.def.db.entity.BM_TuukabetuKyuusibi;
import yuyu.def.db.entity.BM_UnitFundKbn;
import yuyu.def.db.entity.BM_YoteiRiritu;
import yuyu.def.db.entity.BM_YoteiRiritu2;
import yuyu.def.db.entity.BM_YoteiRiritu3;
import yuyu.def.db.entity.BM_YoteiRirituRendouSeigyo;
import yuyu.def.db.entity.BM_ZennouGenkaRitu;
import yuyu.def.db.entity.BM_ZennouGenkaRitu2;
import yuyu.def.db.entity.BM_ZennouKeikaRiritu;
import yuyu.def.db.entity.BM_ZennouKeikaRiritu2;
import yuyu.def.db.entity.BM_ZennouRiritu;
import yuyu.def.db.entity.BM_ZennouRiritu2;
import yuyu.def.db.entity.BM_ZennouTumitateRitu;
import yuyu.def.db.entity.BM_ZennouTumitateRitu2;


/**
 * KawaseRateDomマネージャー<br />
 * KawaseRateにおける、DB操作を提供する。<br />
 */
class KawaseRateDomManager {

    @Inject
    private BM_AzukariRirituDao azukariRirituDao;

    @Inject
    private BM_FundIndexCfGakuDao fundIndexCfGakuDao;

    @Inject
    private BM_FundIndexGessyoCfDao fundIndexGessyoCfDao;

    @Inject
    private BM_FundIndexGetumatuCfDao fundIndexGetumatuCfDao;

    @Inject
    private BM_FundIndexKihonDao fundIndexKihonDao;

    @Inject
    private BM_FundIndexSyokitousiDao fundIndexSyokitousiDao;

    @Inject
    private BM_HaitouRirituDao haitouRirituDao;

    @Inject
    private BM_HsykkntkSysnNkGnsrituDao hsykkntkSysnNkGnsrituDao;

    @Inject
    private BM_IkkatuKeisuuDao ikkatuKeisuuDao;

    @Inject
    private BM_IkkatuTekiyouNoDao ikkatuTekiyouNoDao;

    @Inject
    private BM_IkkatuTekiyouNo2Dao ikkatuTekiyouNo2Dao;

    @Inject
    private BM_KaiyakuKoujyoRituDao kaiyakuKoujyoRituDao;

    @Inject
    private BM_KktNk1stNkBigkGnsrituDao kktNk1stNkBigkGnsrituDao;

    @Inject
    private BM_SibouRituDao sibouRituDao;

    @Inject
    private BM_SjkkkTyouseiyouRirituDao sjkkkTyouseiyouRirituDao;

    @Inject
    private BM_SjkkkTyouseiyouRiritu2Dao sjkkkTyouseiyouRiritu2Dao;

    @Inject
    private BM_KawaseRateDao kawaseRateDao;

    @Inject
    private BM_KijyungkHanteiKawaseRateDao kijyungkHanteiKawaseRateDao;

    @Inject
    private BM_KktNkGnsrituDao kktNkGnsrituDao;

    @Inject
    private BM_NenkinYoteiRirituDao nenkinYoteiRirituDao;

    @Inject
    private BM_RateDDao rateDDao;

    @Inject
    private BM_RateNenkinDDao rateNenkinDDao;

    @Inject
    private BM_RateNenkinPkisoVDao rateNenkinPkisoVDao;

    @Inject
    private BM_RatePDao ratePDao;

    @Inject
    private BM_RateVDao rateVDao;

    @Inject
    private BM_RisaHitSyouhnyouRateDDao risaHitSyouhnyouRateDDao;

    @Inject
    private BM_RateP2Dao rateP2Dao;

    @Inject
    private BM_RateV2Dao rateV2Dao;

    @Inject
    private BM_RateWDao rateWDao;

    @Inject
    private BM_RisaHitSyouhnyouRateD2Dao risaHitSyouhnyouRateD2Dao;

    @Inject
    private BM_SisuuDao sisuuDao;

    @Inject
    private BM_SisuuKihonDao sisuuKihonDao;

    @Inject
    private BM_TuukabetuKyuusibiDao tuukabetuKyuusibiDao;

    @Inject
    private BM_UnitFundKbnDao unitFundKbnDao;

    @Inject
    private BM_YoteiRiritu2Dao yoteiRiritu2Dao;

    @Inject
    private BM_YoteiRiritu3Dao yoteiRiritu3Dao;

    @Inject
    private BM_YoteiRirituDao yoteiRirituDao;

    @Inject
    private BM_YoteiRirituRendouSeigyoDao yoteiRirituRendouSeigyoDao;

    @Inject
    private BM_ZennouGenkaRituDao zennouGenkaRituDao;

    @Inject
    private BM_ZennouKeikaRirituDao zennouKeikaRirituDao;

    @Inject
    private BM_ZennouRirituDao zennouRirituDao;

    @Inject
    private BM_ZennouGenkaRitu2Dao zennouGenkaRitu2Dao;

    @Inject
    private BM_ZennouKeikaRiritu2Dao zennouKeikaRiritu2Dao;

    @Inject
    private BM_ZennouRiritu2Dao zennouRiritu2Dao;

    @Inject
    private BM_ZennouTumitateRitu2Dao zennouTumitateRitu2Dao;

    @Inject
    private BM_ZennouTumitateRituDao zennouTumitateRituDao;

    @Inject
    private BM_TienrisokuRirituDao tienrisokuRirituDao;

    List<BM_KawaseRate> getAllKawaseRate(){
        SortBM_KawaseRate sortBM_KawaseRate = new SortBM_KawaseRate();
        return sortBM_KawaseRate.OrderBM_KawaseRateByPkAsc(kawaseRateDao.selectAll());
    }

    BM_KawaseRate getKawaseRate(BizDate pKwsratekjymd, C_KwsrendouKbn pKwsrendoukbn, C_Tuukasyu pMototuuka, C_Tuukasyu pKanzantuuka, C_KawasetekiyoKbn pKawasetekiyokbn
        , C_KawasetsryKbn pKawasetsrykbn) {

        return kawaseRateDao.getKawaseRate(pKwsratekjymd, pKwsrendoukbn, pMototuuka, pKanzantuuka, pKawasetekiyokbn
            , pKawasetsrykbn);
    }

    List<BM_TuukabetuKyuusibi> getAllTuukabetuKyuusibi(){
        SortBM_TuukabetuKyuusibi sortBM_TuukabetuKyuusibi = new SortBM_TuukabetuKyuusibi();
        return sortBM_TuukabetuKyuusibi.OrderBM_TuukabetuKyuusibiByPkAsc(tuukabetuKyuusibiDao.selectAll());
    }

    BM_TuukabetuKyuusibi getTuukabetuKyuusibi(BizDate pTuukatoriatukaiymd) {

        return tuukabetuKyuusibiDao.getTuukabetuKyuusibi(pTuukatoriatukaiymd);
    }

    List<BM_UnitFundKbn> getAllUnitFundKbn(){
        SortBM_UnitFundKbn sortBM_UnitFundKbn = new SortBM_UnitFundKbn();
        return sortBM_UnitFundKbn.OrderBM_UnitFundKbnByPkAsc(unitFundKbnDao.selectAll());
    }

    BM_UnitFundKbn getUnitFundKbn(String pSyouhncd, Integer pSyouhnsdno, C_Tuukasyu pTuukasyu, Integer pRenno) {

        return unitFundKbnDao.getUnitFundKbn(pSyouhncd, pSyouhnsdno, pTuukasyu, pRenno);
    }

    List<BM_KijyungkHanteiKawaseRate> getAllKijyungkHanteiKawaseRate(){
        SortBM_KijyungkHanteiKawaseRate sortBM_KijyungkHanteiKawaseRate = new SortBM_KijyungkHanteiKawaseRate();
        return sortBM_KijyungkHanteiKawaseRate.OrderBM_KijyungkHanteiKawaseRateByPkAsc(kijyungkHanteiKawaseRateDao.selectAll());
    }

    BM_KijyungkHanteiKawaseRate getKijyungkHanteiKawaseRate(String pKijunnendo, C_Tuukasyu pKyktuukasyu) {

        return kijyungkHanteiKawaseRateDao.getKijyungkHanteiKawaseRate(pKijunnendo, pKyktuukasyu);
    }

    List<BM_FundIndexKihon> getAllFundIndexKihon(){
        SortBM_FundIndexKihon sortBM_FundIndexKihon = new SortBM_FundIndexKihon();
        return sortBM_FundIndexKihon.OrderBM_FundIndexKihonByPkAsc(fundIndexKihonDao.selectAll());
    }

    BM_FundIndexKihon getFundIndexKihon(C_UnitFundKbn pUnitfundkbn, BizDate pFundhyoukaymd) {

        return fundIndexKihonDao.getFundIndexKihon(pUnitfundkbn, pFundhyoukaymd);
    }

    List<BM_FundIndexSyokitousi> getAllFundIndexSyokitousi(){
        SortBM_FundIndexSyokitousi sortBM_FundIndexSyokitousi = new SortBM_FundIndexSyokitousi();
        return sortBM_FundIndexSyokitousi.OrderBM_FundIndexSyokitousiByPkAsc(fundIndexSyokitousiDao.selectAll());
    }

    BM_FundIndexSyokitousi getFundIndexSyokitousi(C_UnitFundKbn pUnitfundkbn, BizDate pFundhyoukaymd, String pSegkey) {

        return fundIndexSyokitousiDao.getFundIndexSyokitousi(pUnitfundkbn, pFundhyoukaymd, pSegkey);
    }

    List<BM_FundIndexGetumatuCf> getAllFundIndexGetumatuCf(){
        SortBM_FundIndexGetumatuCf sortBM_FundIndexGetumatuCf = new SortBM_FundIndexGetumatuCf();
        return sortBM_FundIndexGetumatuCf.OrderBM_FundIndexGetumatuCfByPkAsc(fundIndexGetumatuCfDao.selectAll());
    }

    BM_FundIndexGetumatuCf getFundIndexGetumatuCf(C_UnitFundKbn pUnitfundkbn, BizDate pFundhyoukaymd, String pSegkey) {

        return fundIndexGetumatuCfDao.getFundIndexGetumatuCf(pUnitfundkbn, pFundhyoukaymd, pSegkey);
    }

    List<BM_FundIndexGessyoCf> getAllFundIndexGessyoCf(){
        SortBM_FundIndexGessyoCf sortBM_FundIndexGessyoCf = new SortBM_FundIndexGessyoCf();
        return sortBM_FundIndexGessyoCf.OrderBM_FundIndexGessyoCfByPkAsc(fundIndexGessyoCfDao.selectAll());
    }

    BM_FundIndexGessyoCf getFundIndexGessyoCf(C_UnitFundKbn pUnitfundkbn, BizDate pFundhyoukaymd, String pSegkey) {

        return fundIndexGessyoCfDao.getFundIndexGessyoCf(pUnitfundkbn, pFundhyoukaymd, pSegkey);
    }

    List<BM_FundIndexCfGaku> getAllFundIndexCfGaku(){
        SortBM_FundIndexCfGaku sortBM_FundIndexCfGaku = new SortBM_FundIndexCfGaku();
        return sortBM_FundIndexCfGaku.OrderBM_FundIndexCfGakuByPkAsc(fundIndexCfGakuDao.selectAll());
    }

    BM_FundIndexCfGaku getFundIndexCfGaku(C_UnitFundKbn pUnitfundkbn, BizDate pFundhyoukaymd, String pSegkey) {

        return fundIndexCfGakuDao.getFundIndexCfGaku(pUnitfundkbn, pFundhyoukaymd, pSegkey);
    }

    List<BM_NenkinYoteiRiritu> getAllNenkinYoteiRiritu(){
        SortBM_NenkinYoteiRiritu sortBM_NenkinYoteiRiritu = new SortBM_NenkinYoteiRiritu();
        return sortBM_NenkinYoteiRiritu.OrderBM_NenkinYoteiRirituByPkAsc(nenkinYoteiRirituDao.selectAll());
    }

    List<BM_NenkinYoteiRiritu> getNenkinYoteiRiritusByNenkinsyuTuukasyuKykfromymdKyktoymd(String pNenkinsyu, C_Tuukasyu pTuukasyu, BizDate pKykymd) {

        return nenkinYoteiRirituDao.getNenkinYoteiRiritusByNenkinsyuTuukasyuKykfromymdKyktoymd(pNenkinsyu, pTuukasyu, pKykymd);
    }

    BM_NenkinYoteiRiritu getNenkinYoteiRiritu(String pNenkinsyu, C_Tuukasyu pTuukasyu, BizDate pKykfromymd, BizDate pKyktoymd) {

        return nenkinYoteiRirituDao.getNenkinYoteiRiritu(pNenkinsyu, pTuukasyu, pKykfromymd, pKyktoymd);
    }

    List<BM_YoteiRiritu> getAllYoteiRiritu(){
        SortBM_YoteiRiritu sortBM_YoteiRiritu = new SortBM_YoteiRiritu();
        return sortBM_YoteiRiritu.OrderBM_YoteiRirituByPkAsc(yoteiRirituDao.selectAll());
    }

    List<BM_YoteiRiritu> getYoteiRiritusBySyouhncdTuukasyuCalckijyunymd(String pSyouhncd, C_Tuukasyu pTuukasyu, BizDate pCalckijyunymd) {

        return yoteiRirituDao.getYoteiRiritusBySyouhncdTuukasyuCalckijyunymd(pSyouhncd, pTuukasyu, pCalckijyunymd);
    }

    BM_YoteiRiritu getYoteiRiritu(String pSyouhncd, C_Tuukasyu pTuukasyu, C_HhknNenKbn pHhknnenkbn, BizDate pKykfromymd, BizDate pKyktoymd) {

        return yoteiRirituDao.getYoteiRiritu(pSyouhncd, pTuukasyu, pHhknnenkbn, pKykfromymd, pKyktoymd);
    }

    List<BM_YoteiRiritu> getYoteiRiritusByMosnoSyutkkbnTuukasyuKykymd(String pMosno, C_SyutkKbn pSyutkkbn, C_Tuukasyu pTuukasyu, BizDate pKykymd) {

        return yoteiRirituDao.getYoteiRiritusByMosnoSyutkkbnTuukasyuKykymd(pMosno, pSyutkkbn, pTuukasyu, pKykymd);
    }

    List<BM_YoteiRiritu> getYoteiRiritusByMosnoSyutkkbnTuukasyu(String pMosno, C_SyutkKbn pSyutkkbn, C_Tuukasyu pTuukasyu) {

        return yoteiRirituDao.getYoteiRiritusByMosnoSyutkkbnTuukasyu(pMosno,pSyutkkbn,pTuukasyu);
    }

    List<BM_YoteiRiritu> getYoteiRiritusBySyouhncdTuukasyuKykfromymdKyktoymd(String pSyouhncd, C_Tuukasyu pTuukasyu, BizDate pKykymd) {

        return yoteiRirituDao.getYoteiRiritusBySyouhncdTuukasyuKykfromymdKyktoymd(pSyouhncd, pTuukasyu, pKykymd);
    }

    List<BM_YoteiRiritu> getYoteiRiritusBySyouhncdKykfromymdKyktoymd(String pSyouhncd, BizDate pKykymd) {

        return yoteiRirituDao.getYoteiRiritusBySyouhncdKykfromymdKyktoymd(pSyouhncd, pKykymd);
    }

    List<BM_YoteiRiritu> getYoteiRiritusBySyouhncdTuukasyu(String pSyouhncd, C_Tuukasyu pTuukasyu) {

        return yoteiRirituDao.getYoteiRiritusBySyouhncdTuukasyu(pSyouhncd, pTuukasyu);
    }

    List<BM_YoteiRiritu> getYoteiRiritusByPK(String pSyouhncd, C_Tuukasyu pTuukasyu, C_HhknNenKbn pHhknnenkbn, BizDate pKykfromymd, BizDate pKyktoymd) {

        return yoteiRirituDao.getYoteiRiritusByPK(pSyouhncd, pTuukasyu, pHhknnenkbn, pKykfromymd, pKyktoymd);
    }

    List<BM_YoteiRiritu> getYoteiRiritusByKyktoymdMax() {

        return yoteiRirituDao.getYoteiRiritusByKyktoymdMax();
    }

    List<BM_YoteiRiritu2> getYoteiRiritu2sByKijyuntoymdMax() {

        return yoteiRiritu2Dao.getYoteiRiritu2sByKijyuntoymdMax();
    }

    public List<BM_YoteiRiritu2> getYoteiRiritu2sBySyouhncdKijyuntoymdMax(String pSyouhncd) {

        return yoteiRiritu2Dao.getYoteiRiritu2sBySyouhncdKijyuntoymdMax(pSyouhncd);
    }

    List<BM_YoteiRiritu3> getAllYoteiRiritu3(){
        SortBM_YoteiRiritu3 sortBM_YoteiRiritu3 = new SortBM_YoteiRiritu3();
        return sortBM_YoteiRiritu3.OrderBM_YoteiRiritu3ByPkAsc(yoteiRiritu3Dao.selectAll());
    }

    BM_YoteiRiritu3 getYoteiRiritu3(String pSyouhncd, C_Tuukasyu pTuukasyu, String pYoteiriritutkybr1, String pYoteiriritutkybr2, BizDate pKijyunfromymd
        , BizDate pKijyuntoymd) {

        return yoteiRiritu3Dao.getYoteiRiritu3(pSyouhncd, pTuukasyu, pYoteiriritutkybr1, pYoteiriritutkybr2, pKijyunfromymd
            , pKijyuntoymd);
    }
	
    List<BM_YoteiRiritu3> getYoteiRiritu3sBySyouhncdKijyuntoymdMax(String pSyouhncd) {

        return yoteiRiritu3Dao.getYoteiRiritu3sBySyouhncdKijyuntoymdMax(pSyouhncd);
    }

    List<BM_YoteiRirituRendouSeigyo> getAllYoteiRirituRendouSeigyo() {
        SortBM_YoteiRirituRendouSeigyo sortBM_YoteiRirituRendouSeigyo = new SortBM_YoteiRirituRendouSeigyo();
        return sortBM_YoteiRirituRendouSeigyo.OrderBM_YoteiRirituRendouSeigyoByPkAsc(yoteiRirituRendouSeigyoDao.selectAll());
    };

    BM_YoteiRirituRendouSeigyo getYoteiRirituRendouSeigyo(String pYoteirirituhanteidfrom, String yoteirirituhanteidto, String pSyouhncd) {

        return yoteiRirituRendouSeigyoDao.getYoteiRirituRendouSeigyo(pYoteirirituhanteidfrom, yoteirirituhanteidto, pSyouhncd);
    };

    public List<BM_YoteiRirituRendouSeigyo> getYoteiRirituRendouSeigyosByYoteirirituhanteid(String pYoteirirituhanteid) {

        return yoteiRirituRendouSeigyoDao.getYoteiRirituRendouSeigyosByYoteirirituhanteid(pYoteirirituhanteid);
    }

    List<BM_SjkkkTyouseiyouRiritu> getAllSjkkkTyouseiyouRiritu(){
        SortBM_SjkkkTyouseiyouRiritu sortBM_SjkkkTyouseiyouRiritu = new SortBM_SjkkkTyouseiyouRiritu();
        return sortBM_SjkkkTyouseiyouRiritu.OrderBM_SjkkkTyouseiyouRirituByPkAsc(sjkkkTyouseiyouRirituDao.selectAll());
    }

    BM_SjkkkTyouseiyouRiritu getSjkkkTyouseiyouRiritu(String pSyouhncd, C_Tuukasyu pTuukasyu, C_HhknNenKbn pHhknnenkbn, BizDate pKykfromymd, BizDate pKyktoymd) {

        return sjkkkTyouseiyouRirituDao.getSjkkkTyouseiyouRiritu(pSyouhncd, pTuukasyu, pHhknnenkbn, pKykfromymd, pKyktoymd);
    }

    List<BM_SjkkkTyouseiyouRiritu> getSjkkkTyouseiyouRiritusByPK(String pSyouhncd, C_Tuukasyu pTuukasyu, C_HhknNenKbn pHhknnenkbn, BizDate pKykfromymd, BizDate pKyktoymd) {

        return sjkkkTyouseiyouRirituDao.getSjkkkTyouseiyouRiritusByPK(pSyouhncd, pTuukasyu, pHhknnenkbn, pKykfromymd, pKyktoymd);
    }

    List<BM_SjkkkTyouseiyouRiritu> getSjkkkTyouseiyouRiritusByPKKykymd(String pSyouhncd, C_Tuukasyu pTuukasyu, C_HhknNenKbn pHhknnenkbn, BizDate pKykymd) {

        return sjkkkTyouseiyouRirituDao.getSjkkkTyouseiyouRiritusByPKKykymd(pSyouhncd, pTuukasyu, pHhknnenkbn, pKykymd);
    }

    List<BM_SjkkkTyouseiyouRiritu> getSjkkkTyouseiyouRiritusBy3PKMaxKyktoymd(String pSyouhncd, C_Tuukasyu pTuukasyu, C_HhknNenKbn pHhknnenkbn) {

        return sjkkkTyouseiyouRirituDao.getSjkkkTyouseiyouRiritusBy3PKMaxKyktoymd(pSyouhncd, pTuukasyu, pHhknnenkbn);
    }

    List<BM_SjkkkTyouseiyouRiritu> getSjkkkTyouseiyouRiritusByKyktoymdMax() {

        return sjkkkTyouseiyouRirituDao.getSjkkkTyouseiyouRiritusByKyktoymdMax();
    }

    List<BM_SjkkkTyouseiyouRiritu> getSjkkkTyouseiyouRiritusByPk(String pSyouhncd, C_Tuukasyu pTuukasyu, C_HhknNenKbn pHhknnenkbn, BizDate pKykymd) {

        return sjkkkTyouseiyouRirituDao.getSjkkkTyouseiyouRiritusByPk(pSyouhncd, pTuukasyu, pHhknnenkbn, pKykymd);
    }

    List<BM_KaiyakuKoujyoRitu> getAllKaiyakuKoujyoRitu(){
        SortBM_KaiyakuKoujyoRitu sortBM_KaiyakuKoujyoRitu = new SortBM_KaiyakuKoujyoRitu();
        return sortBM_KaiyakuKoujyoRitu.OrderBM_KaiyakuKoujyoRituByPkAsc(kaiyakuKoujyoRituDao.selectAll());
    }

    BM_KaiyakuKoujyoRitu getKaiyakuKoujyoRitu(String pSyouhncd, String pRyouritusdno, String pKaiyakukjtkybr1, String pKaiyakukjtkybr2, Integer pKeikanensuu) {

        return kaiyakuKoujyoRituDao.getKaiyakuKoujyoRitu(pSyouhncd, pRyouritusdno, pKaiyakukjtkybr1, pKaiyakukjtkybr2, pKeikanensuu);
    }

    List<BM_RateP> getAllRateP(){
        SortBM_RateP sortBM_RateP = new SortBM_RateP();
        return sortBM_RateP.OrderBM_RatePByPkAsc(ratePDao.selectAll());
    }

    BM_RateP getRateP(String pPalhokensyuruikigou, String pPalhokensyuruikigousdicode, String pPalyoteiriritu, String pPalpmencode
        , String pPalharaikomikaisuu, String pPalhhknsei, String pPalkeiyakujihhknnen, String pPalsaimankihyouji
        , String pPalhokenkikan, String pPalpharaikomikikan) {

        return ratePDao.getRateP(pPalhokensyuruikigou, pPalhokensyuruikigousdicode, pPalyoteiriritu, pPalpmencode
            , pPalharaikomikaisuu, pPalhhknsei, pPalkeiyakujihhknnen, pPalsaimankihyouji
            , pPalhokenkikan, pPalpharaikomikikan);
    }

    List<BM_RateV> getAllRateV(){
        SortBM_RateV sortBM_RateV = new SortBM_RateV();
        return sortBM_RateV.OrderBM_RateVByPkAsc(rateVDao.selectAll());
    }

    BM_RateV getRateV(String pPalhokensyuruikigou, String pPalhokensyuruikigousdicode, String pPalyoteiriritu, String pPalpmencode
        , String pPalharaikomikaisuu, String pPalhhknsei, String pPalkeiyakujihhknnen, String pPalsaimankihyouji
        , String pPalhokenkikan, String pPalpharaikomikikan) {

        return rateVDao.getRateV(pPalhokensyuruikigou, pPalhokensyuruikigousdicode, pPalyoteiriritu, pPalpmencode
            , pPalharaikomikaisuu, pPalhhknsei, pPalkeiyakujihhknnen, pPalsaimankihyouji
            , pPalhokenkikan, pPalpharaikomikikan);
    }

    List<BM_RateD> getAllRateD(){
        SortBM_RateD sortBM_RateD = new SortBM_RateD();
        return sortBM_RateD.OrderBM_RateDByPkAsc(rateDDao.selectAll());
    }

    BM_RateD getRateD(String pPalhokensyuruikigou, String pPalhokensyuruikigousdicode, String pPalyoteiriritu, String pPalpmencode
        , String pPalharaikomikaisuu, String pPalhhknsei, String pPalkeiyakujihhknnen, String pPalsaimankihyouji
        , String pPalhokenkikan, String pPalpharaikomikikan, String pPaldnendo, String pPaldratenaikakucode) {

        return rateDDao.getRateD(pPalhokensyuruikigou, pPalhokensyuruikigousdicode, pPalyoteiriritu, pPalpmencode
            , pPalharaikomikaisuu, pPalhhknsei, pPalkeiyakujihhknnen, pPalsaimankihyouji
            , pPalhokenkikan, pPalpharaikomikikan, pPaldnendo, pPaldratenaikakucode);
    }

    List<BM_RateNenkinPkisoV> getAllRateNenkinPkisoV(){
        SortBM_RateNenkinPkisoV sortBM_RateNenkinPkisoV = new SortBM_RateNenkinPkisoV();
        return sortBM_RateNenkinPkisoV.OrderBM_RateNenkinPkisoVByPkAsc(rateNenkinPkisoVDao.selectAll());
    }

    BM_RateNenkinPkisoV getRateNenkinPkisoV(String pPalnenkinsisutemusyurui, String pPalnenkinsyuruikigou, String pPalnenkinkigousedaicode, String pPalnenkinsiharaikikan
        , String pPalnnknksgyoteiriritucode, String pPalnnknksgjmtesuuryoucode) {

        return rateNenkinPkisoVDao.getRateNenkinPkisoV(pPalnenkinsisutemusyurui, pPalnenkinsyuruikigou, pPalnenkinkigousedaicode, pPalnenkinsiharaikikan
            , pPalnnknksgyoteiriritucode, pPalnnknksgjmtesuuryoucode);
    }

    List<BM_RateNenkinD> getAllRateNenkinD(){
        SortBM_RateNenkinD sortBM_RateNenkinD = new SortBM_RateNenkinD();
        return sortBM_RateNenkinD.OrderBM_RateNenkinDByPkAsc(rateNenkinDDao.selectAll());
    }

    BM_RateNenkinD getRateNenkinD(String pPalnenkinsisutemusyurui, String pPalnenkinsyuruikigou, String pPalnenkinkigousedaicode, String pPalnenkinsiharaikikan
        , String pPalnnknksgyoteiriritucode, String pPalnnknksgjmtesuuryoucode, String pPaldnendo, String pPaldratenaikakucode) {

        return rateNenkinDDao.getRateNenkinD(pPalnenkinsisutemusyurui, pPalnenkinsyuruikigou, pPalnenkinkigousedaicode, pPalnenkinsiharaikikan
            , pPalnnknksgyoteiriritucode, pPalnnknksgjmtesuuryoucode, pPaldnendo, pPaldratenaikakucode);
    }


    BM_RisaHitSyouhnyouRateD getRisaHitSyouhnyouRateD(String pPalhokensyuruikigou, String pPalhokensyuruikigousdicode, String pPalyoteiriritu, String pPalpmencode
        , String pPalharaikomikaisuu, String pPalhhknsei, String pPalkeiyakujihhknnen, String pPalsaimankihyouji
        , String pPalhokenkikan, String pPalpharaikomikikan, String pPaldnendo, String pPaldratenaikakucode) {

        return risaHitSyouhnyouRateDDao.getRisaHitSyouhnyouRateD(pPalhokensyuruikigou, pPalhokensyuruikigousdicode, pPalyoteiriritu, pPalpmencode
            , pPalharaikomikaisuu, pPalhhknsei, pPalkeiyakujihhknnen, pPalsaimankihyouji
            , pPalhokenkikan, pPalpharaikomikikan, pPaldnendo, pPaldratenaikakucode);
    }

    List<BM_RisaHitSyouhnyouRateD> getAllRisaHitSyouhnyouRateD(){
        SortBM_RisaHitSyouhnyouRateD sortBM_RisaHitSyouhnyouRateD = new SortBM_RisaHitSyouhnyouRateD();
        return sortBM_RisaHitSyouhnyouRateD.OrderBM_RisaHitSyouhnyouRateDByPkAsc(risaHitSyouhnyouRateDDao.selectAll());
    }

    List<BM_RateP2> getAllRateP2(){
        SortBM_RateP2 sortBM_RateP2 = new SortBM_RateP2();
        return sortBM_RateP2.OrderBM_RateP2ByPkAsc(rateP2Dao.selectAll());
    }

    BM_RateP2 getRateP2(String pPalhokensyuruikigou, String pPalhokensyuruikigousdicode, String pPalyoteiriritu, String pPalpmencode
        , String pPalharaikomikaisuu, String pPalhhknsei, String pPalkeiyakujihhknnen, String pPalsaimankihyouji
        , String pPalhokenkikan, String pPalpharaikomikikan, String pPalannaihuyouriyuukbn, String pRatetuukasyukbn
        , String pRatedai1hknkkn, String pPalryouritukbn) {

        return rateP2Dao.getRateP2(pPalhokensyuruikigou, pPalhokensyuruikigousdicode, pPalyoteiriritu, pPalpmencode
            , pPalharaikomikaisuu, pPalhhknsei, pPalkeiyakujihhknnen, pPalsaimankihyouji
            , pPalhokenkikan, pPalpharaikomikikan, pPalannaihuyouriyuukbn, pRatetuukasyukbn
            , pRatedai1hknkkn, pPalryouritukbn);
    }

    BM_RateP2 getRateP2byRatePkey(String pPalhokensyuruikigou, String pPalhokensyuruikigousdicode, String pPalyoteiriritu, String pPalpmencode
        , String pPalharaikomikaisuu, String pPalhhknsei, String pPalkeiyakujihhknnen, String pPalsaimankihyouji
        , String pPalhokenkikan, String pPalpharaikomikikan) {

        return rateP2Dao.getRateP2byRatePkey(pPalhokensyuruikigou, pPalhokensyuruikigousdicode, pPalyoteiriritu, pPalpmencode
            , pPalharaikomikaisuu, pPalhhknsei, pPalkeiyakujihhknnen, pPalsaimankihyouji
            , pPalhokenkikan, pPalpharaikomikikan);
    }

    List<BM_RateV2> getAllRateV2(){
        SortBM_RateV2 sortBM_RateV2 = new SortBM_RateV2();
        return sortBM_RateV2.OrderBM_RateV2ByPkAsc(rateV2Dao.selectAll());
    }

    BM_RateV2 getRateV2(String pPalhokensyuruikigou, String pPalhokensyuruikigousdicode, String pPalyoteiriritu, String pPalpmencode
        , String pPalharaikomikaisuu, String pPalhhknsei, String pPalkeiyakujihhknnen, String pPalsaimankihyouji
        , String pPalhokenkikan, String pPalpharaikomikikan, String pPalannaihuyouriyuukbn, String pRatetuukasyukbn
        , String pRatedai1hknkkn) {

        return rateV2Dao.getRateV2(pPalhokensyuruikigou, pPalhokensyuruikigousdicode, pPalyoteiriritu, pPalpmencode
            , pPalharaikomikaisuu, pPalhhknsei, pPalkeiyakujihhknnen, pPalsaimankihyouji
            , pPalhokenkikan, pPalpharaikomikikan, pPalannaihuyouriyuukbn, pRatetuukasyukbn
            , pRatedai1hknkkn);
    }

    BM_RateV2 getRateV2byRateVkey(String pPalhokensyuruikigou, String pPalhokensyuruikigousdicode, String pPalyoteiriritu, String pPalpmencode
        , String pPalharaikomikaisuu, String pPalhhknsei, String pPalkeiyakujihhknnen, String pPalsaimankihyouji
        , String pPalhokenkikan, String pPalpharaikomikikan) {

        return rateV2Dao.getRateV2byRateVkey(pPalhokensyuruikigou, pPalhokensyuruikigousdicode, pPalyoteiriritu, pPalpmencode
            , pPalharaikomikaisuu, pPalhhknsei, pPalkeiyakujihhknnen, pPalsaimankihyouji
            , pPalhokenkikan, pPalpharaikomikikan);
    }

    List<BM_RisaHitSyouhnyouRateD2> getAllRisaHitSyouhnyouRateD2(){
        SortBM_RisaHitSyouhnyouRateD2 sortBM_RisaHitSyouhnyouRateD2 = new SortBM_RisaHitSyouhnyouRateD2();
        return sortBM_RisaHitSyouhnyouRateD2.OrderBM_RisaHitSyouhnyouRateD2ByPkAsc(risaHitSyouhnyouRateD2Dao.selectAll());
    }

    BM_RisaHitSyouhnyouRateD2 getRisaHitSyouhnyouRateD2(String pPalhokensyuruikigou, String pPalhokensyuruikigousdicode, String pPalyoteiriritu, String pPalpmencode
        , String pPalharaikomikaisuu, String pPalhhknsei, String pPalkeiyakujihhknnen, String pPalsaimankihyouji
        , String pPalhokenkikan, String pPalpharaikomikikan, String pPalannaihuyouriyuukbn, String pRatetuukasyukbn
        , String pRatedai1hknkkn, String pPaldnendo, String pPaldratenaikakucode) {

        return risaHitSyouhnyouRateD2Dao.getRisaHitSyouhnyouRateD2(pPalhokensyuruikigou, pPalhokensyuruikigousdicode, pPalyoteiriritu, pPalpmencode
            , pPalharaikomikaisuu, pPalhhknsei, pPalkeiyakujihhknnen, pPalsaimankihyouji
            , pPalhokenkikan, pPalpharaikomikikan, pPalannaihuyouriyuukbn, pRatetuukasyukbn
            , pRatedai1hknkkn, pPaldnendo, pPaldratenaikakucode);
    }

    BM_RisaHitSyouhnyouRateD2 getRisaHitSyouhnyouRateD2byRisaHitSyouhnyouRateDkey(String pPalhokensyuruikigou, String pPalhokensyuruikigousdicode, String pPalyoteiriritu, String pPalpmencode
        , String pPalharaikomikaisuu, String pPalhhknsei, String pPalkeiyakujihhknnen, String pPalsaimankihyouji
        , String pPalhokenkikan, String pPalpharaikomikikan, String pPaldnendo, String pPaldratenaikakucode) {

        return risaHitSyouhnyouRateD2Dao.getRisaHitSyouhnyouRateD2byRisaHitSyouhnyouRateDkey(pPalhokensyuruikigou, pPalhokensyuruikigousdicode, pPalyoteiriritu, pPalpmencode,
            pPalharaikomikaisuu, pPalhhknsei, pPalkeiyakujihhknnen, pPalsaimankihyouji, pPalhokenkikan, pPalpharaikomikikan, pPaldnendo, pPaldratenaikakucode);
    }

    List<BM_RateW> getAllRateW(){
        SortBM_RateW sortBM_RateW = new SortBM_RateW();
        return sortBM_RateW.OrderBM_RateWByPkAsc(rateWDao.selectAll());
    }

    BM_RateW getRateW(String pPalhokensyuruikigou, String pPalhokensyuruikigousdicode, String pPalyoteiriritu, String pPalpmencode
        , String pPalharaikomikaisuu, String pPalhhknsei, String pPalkeiyakujihhknnen, String pPalsaimankihyouji
        , String pPalhokenkikan, String pPalpharaikomikikan, String pPalannaihuyouriyuukbn, String pRatetuukasyukbn
        , String pRatedai1hknkkn) {

        return rateWDao.getRateW(pPalhokensyuruikigou, pPalhokensyuruikigousdicode, pPalyoteiriritu, pPalpmencode
            , pPalharaikomikaisuu, pPalhhknsei, pPalkeiyakujihhknnen, pPalsaimankihyouji
            , pPalhokenkikan, pPalpharaikomikikan, pPalannaihuyouriyuukbn, pRatetuukasyukbn
            , pRatedai1hknkkn);
    }

    List<BM_TuukabetuKyuusibi> getTuukabetuKyuusibisByTuukatoriatukaiymdKyuusieurkbnBlank(BizDate pTyakkinyoteiymd, BizDate pSyutokuendymd) {

        return tuukabetuKyuusibiDao.getTuukabetuKyuusibisByTuukatoriatukaiymdKyuusieurkbnBlank(pTyakkinyoteiymd,pSyutokuendymd);
    }

    List<BM_TuukabetuKyuusibi> getTuukabetuKyuusibisByTuukatoriatukaiymdKyuusiaudkbnBlank(BizDate pTyakkinyoteiymd, BizDate pSyutokuendymd) {

        return tuukabetuKyuusibiDao.getTuukabetuKyuusibisByTuukatoriatukaiymdKyuusiaudkbnBlank(pTyakkinyoteiymd,pSyutokuendymd);
    }

    List<BM_TuukabetuKyuusibi> getTuukabetuKyuusibisByTuukatoriatukaiymdKyuusiusdkbnBlank(BizDate pTyakkinyoteiymd, BizDate pSyutokuendymd) {

        return tuukabetuKyuusibiDao.getTuukabetuKyuusibisByTuukatoriatukaiymdKyuusiusdkbnBlank(pTyakkinyoteiymd,pSyutokuendymd);
    }

    List<BM_YoteiRiritu2> getAllYoteiRiritu2(){
        SortBM_YoteiRiritu2 sortBM_YoteiRiritu2 = new SortBM_YoteiRiritu2();
        return sortBM_YoteiRiritu2.OrderBM_YoteiRiritu2ByPkAsc(yoteiRiritu2Dao.selectAll());
    }

    BM_YoteiRiritu2 getYoteiRiritu2(String pSyouhncd, String pYoteiriritutkybr1, String pYoteiriritutkybr2, BizDate pKijyunfromymd, BizDate pKijyuntoymd) {

        return yoteiRiritu2Dao.getYoteiRiritu2(pSyouhncd, pYoteiriritutkybr1, pYoteiriritutkybr2, pKijyunfromymd, pKijyuntoymd);
    }

    List<BM_SjkkkTyouseiyouRiritu2> getAllSjkkkTyouseiyouRiritu2(){
        SortBM_SjkkkTyouseiyouRiritu2 sortBM_SjkkkTyouseiyouRiritu2 = new SortBM_SjkkkTyouseiyouRiritu2();
        return sortBM_SjkkkTyouseiyouRiritu2.OrderBM_SjkkkTyouseiyouRiritu2ByPkAsc(sjkkkTyouseiyouRiritu2Dao.selectAll());
    }

    BM_SjkkkTyouseiyouRiritu2 getSjkkkTyouseiyouRiritu2(String pSyouhncd, String pSjkkktyouseiriritutkybr1, String pSjkkktyouseiriritutkybr2, BizDate pKijyunfromymd
        , BizDate pKijyuntoymd) {

        return sjkkkTyouseiyouRiritu2Dao.getSjkkkTyouseiyouRiritu2(pSyouhncd, pSjkkktyouseiriritutkybr1, pSjkkktyouseiriritutkybr2, pKijyunfromymd
            , pKijyuntoymd);
    }

    List<BM_Sisuu> getAllSisuu(){
        SortBM_Sisuu sortBM_Sisuu = new SortBM_Sisuu();
        return sortBM_Sisuu.OrderBM_SisuuByPkAsc(sisuuDao.selectAll());
    }

    BM_Sisuu getSisuu(C_Sisuukbn pSisuukbn, BizDate pSisuukouhyouymd) {

        return sisuuDao.getSisuu(pSisuukbn, pSisuukouhyouymd);
    }

    List<BM_SisuuKihon> getAllSisuuKihon(){
        SortBM_SisuuKihon sortBM_SisuuKihon = new SortBM_SisuuKihon();
        return sortBM_SisuuKihon.OrderBM_SisuuKihonByPkAsc(sisuuKihonDao.selectAll());
    }

    BM_SisuuKihon getSisuuKihon(C_Sisuukbn pSisuukbn) {

        return sisuuKihonDao.getSisuuKihon(pSisuukbn);
    }

    List<BM_AzukariRiritu> getAllAzukariRiritu(){
        SortBM_AzukariRiritu sortBM_AzukariRiritu = new SortBM_AzukariRiritu();
        return sortBM_AzukariRiritu.OrderBM_AzukariRirituByPkAsc(azukariRirituDao.selectAll());
    }

    BM_AzukariRiritu getAzukariRiritu(C_Tuukasyu pTuukasyu, BizDate pTkyfromymd, BizDate pTkytoymd) {

        return azukariRirituDao.getAzukariRiritu(pTuukasyu, pTkyfromymd, pTkytoymd);
    }

    List<BM_HaitouRiritu> getAllHaitouRiritu(){
        SortBM_HaitouRiritu sortBM_HaitouRiritu = new SortBM_HaitouRiritu();
        return sortBM_HaitouRiritu.OrderBM_HaitouRirituByPkAsc(haitouRirituDao.selectAll());
    }

    BM_HaitouRiritu getHaitouRiritu(BizDate pKijyunfromymd, BizDate pKijyuntoymd) {

        return haitouRirituDao.getHaitouRiritu(pKijyunfromymd, pKijyuntoymd);
    }

    List<BM_IkkatuKeisuu> getAllIkkatuKeisuu(){
        SortBM_IkkatuKeisuu sortBM_IkkatuKeisuu = new SortBM_IkkatuKeisuu();
        return sortBM_IkkatuKeisuu.OrderBM_IkkatuKeisuuByPkAsc(ikkatuKeisuuDao.selectAll());
    }

    BM_IkkatuKeisuu getIkkatuKeisuu(Integer pIkttekiyouno, Integer pNen1nen2baraihyouji, Integer pKeikatukisuu) {

        return ikkatuKeisuuDao.getIkkatuKeisuu(pIkttekiyouno, pNen1nen2baraihyouji, pKeikatukisuu);
    }

    List<BM_IkkatuTekiyouNo> getAllIkkatuTekiyouNo(){
        SortBM_IkkatuTekiyouNo sortBM_IkkatuTekiyouNo = new SortBM_IkkatuTekiyouNo();
        return sortBM_IkkatuTekiyouNo.OrderBM_IkkatuTekiyouNoByPkAsc(ikkatuTekiyouNoDao.selectAll());
    }

    BM_IkkatuTekiyouNo getIkkatuTekiyouNo(String pSyouhncd, String pRyouritusdno) {

        return ikkatuTekiyouNoDao.getIkkatuTekiyouNo(pSyouhncd, pRyouritusdno);
    }

    List<BM_IkkatuTekiyouNo2> getAllIkkatuTekiyouNo2(){
        SortBM_IkkatuTekiyouNo2 sortBM_IkkatuTekiyouNo2 = new SortBM_IkkatuTekiyouNo2();
        return sortBM_IkkatuTekiyouNo2.OrderBM_IkkatuTekiyouNo2ByPkAsc(ikkatuTekiyouNo2Dao.selectAll());
    }

    BM_IkkatuTekiyouNo2 getIkkatuTekiyouNo2(String pSyouhncd, String pRyouritusdno, BizNumber pYoteiriritu, String pIkttekiyoubr1, String pIkttekiyoubr2
        , String pIkttekiyoubr3) {

        return ikkatuTekiyouNo2Dao.getIkkatuTekiyouNo2(pSyouhncd, pRyouritusdno, pYoteiriritu, pIkttekiyoubr1, pIkttekiyoubr2
            , pIkttekiyoubr3);
    }

    List<BM_ZennouGenkaRitu> getAllZennouGenkaRitu(){
        SortBM_ZennouGenkaRitu sortBM_ZennouGenkaRitu = new SortBM_ZennouGenkaRitu();
        return sortBM_ZennouGenkaRitu.OrderBM_ZennouGenkaRituByPkAsc(zennouGenkaRituDao.selectAll());
    }

    BM_ZennouGenkaRitu getZennouGenkaRitu(Integer pZennounensuu, String pTekiyoukknfrom, String pTekiyoukknkto) {

        return zennouGenkaRituDao.getZennouGenkaRitu(pZennounensuu, pTekiyoukknfrom, pTekiyoukknkto);
    }

    List<BM_ZennouKeikaRiritu> getAllZennouKeikaRiritu(){
        SortBM_ZennouKeikaRiritu sortBM_ZennouKeikaRiritu = new SortBM_ZennouKeikaRiritu();
        return sortBM_ZennouKeikaRiritu.OrderBM_ZennouKeikaRirituByPkAsc(zennouKeikaRirituDao.selectAll());
    }

    BM_ZennouKeikaRiritu getZennouKeikaRiritu(Integer pKeikatukisuu, String pTekiyoukknfrom, String pTekiyoukknkto) {

        return zennouKeikaRirituDao.getZennouKeikaRiritu(pKeikatukisuu, pTekiyoukknfrom, pTekiyoukknkto);
    }

    List<BM_ZennouRiritu> getAllZennouRiritu(){
        SortBM_ZennouRiritu sortBM_ZennouRiritu = new SortBM_ZennouRiritu();
        return sortBM_ZennouRiritu.OrderBM_ZennouRirituByPkAsc(zennouRirituDao.selectAll());
    }

    BM_ZennouRiritu getZennouRiritu(String pTekiyoukknfrom, String pTekiyoukknkto) {

        return zennouRirituDao.getZennouRiritu(pTekiyoukknfrom, pTekiyoukknkto);
    }

    List<BM_ZennouTumitateRitu> getAllZennouTumitateRitu(){
        SortBM_ZennouTumitateRitu sortBM_ZennouTumitateRitu = new SortBM_ZennouTumitateRitu();
        return sortBM_ZennouTumitateRitu.OrderBM_ZennouTumitateRituByPkAsc(zennouTumitateRituDao.selectAll());
    }

    BM_ZennouTumitateRitu getZennouTumitateRitu(String pTekiyoukknfrom, String pTekiyoukknkto) {

        return zennouTumitateRituDao.getZennouTumitateRitu(pTekiyoukknfrom, pTekiyoukknkto);
    }

    public List<BM_SjkkkTyouseiyouRiritu2> getSjkkkTyouseiyouRiritu2sByKijyuntoymdMax() {
        return sjkkkTyouseiyouRiritu2Dao.getSjkkkTyouseiyouRiritu2sByKijyuntoymdMax();
    }

    List<BM_HsykkntkSysnNkGnsritu> getAllHsykkntkSysnNkGnsritu(){
        SortBM_HsykkntkSysnNkGnsritu sortBM_HsykkntkSysnNkGnsritu = new SortBM_HsykkntkSysnNkGnsritu();
        return sortBM_HsykkntkSysnNkGnsritu.OrderBM_HsykkntkSysnNkGnsrituByPkAsc(hsykkntkSysnNkGnsrituDao.selectAll());
    }

    BM_HsykkntkSysnNkGnsritu getHsykkntkSysnNkGnsritu(String pRyouritusdno, C_Tuukasyu pTuukasyu, C_Seibetu pSeibetu, Integer pNkshrstartnen) {

        return hsykkntkSysnNkGnsrituDao.getHsykkntkSysnNkGnsritu(pRyouritusdno, pTuukasyu, pSeibetu, pNkshrstartnen);
    }

    List<BM_KktNkGnsritu> getAllKktNkGnsritu(){
        SortBM_KktNkGnsritu sortBM_KktNkGnsritu = new SortBM_KktNkGnsritu();
        return sortBM_KktNkGnsritu.OrderBM_KktNkGnsrituByPkAsc(kktNkGnsrituDao.selectAll());
    }

    BM_KktNkGnsritu getKktNkGnsritu(String pRyouritusdno, C_Tuukasyu pTuukasyu, Integer pShrkkn) {

        return kktNkGnsrituDao.getKktNkGnsritu(pRyouritusdno, pTuukasyu, pShrkkn);
    }

    List<BM_Sisuu> getSisuusBySisuukouhyouymdMax() {

        return sisuuDao.getSisuusBySisuukouhyouymdMax();
    }

    List<BM_KktNk1stNkBigkGnsritu> getAllKktNk1stNkBigkGnsritu(){
        SortBM_KktNk1stNkBigkGnsritu sortBM_KktNk1stNkBigkGnsritu = new SortBM_KktNk1stNkBigkGnsritu();
        return sortBM_KktNk1stNkBigkGnsritu.OrderBM_KktNk1stNkBigkGnsrituByPkAsc(kktNk1stNkBigkGnsrituDao.selectAll());
    }

    BM_KktNk1stNkBigkGnsritu getKktNk1stNkBigkGnsritu(String pRyouritusdno, C_Tuukasyu pTuukasyu, Integer pShrkkn) {

        return kktNk1stNkBigkGnsrituDao.getKktNk1stNkBigkGnsritu(pRyouritusdno, pTuukasyu, pShrkkn);
    }

    List<BM_SibouRitu> getAllSibouRitu(){
        SortBM_SibouRitu sortBM_SibouRitu = new SortBM_SibouRitu();
        return sortBM_SibouRitu.OrderBM_SibouRituByPkAsc(sibouRituDao.selectAll());
    }

    BM_SibouRitu getSibouRitu(String pRyouritusdno, C_Seibetu pSeibetu, Integer pNen) {

        return sibouRituDao.getSibouRitu(pRyouritusdno, pSeibetu, pNen);
    }


    List<BM_TienrisokuRiritu> getAllTienrisokuRiritu(){
        SortBM_TienrisokuRiritu sortBM_TienrisokuRiritu = new SortBM_TienrisokuRiritu();
        return sortBM_TienrisokuRiritu.OrderBM_TienrisokuRirituByPkAsc(tienrisokuRirituDao.selectAll());
    }

    BM_TienrisokuRiritu getTienrisokuRiritu(String pTekiyoukknfrom, String pTekiyoukknkto) {

        return tienrisokuRirituDao.getTienrisokuRiritu(pTekiyoukknfrom, pTekiyoukknkto);
    }

    List<BM_ZennouGenkaRitu2> getAllZennouGenkaRitu2(){
        SortBM_ZennouGenkaRitu2 sortBM_ZennouGenkaRitu2 = new SortBM_ZennouGenkaRitu2();
        return sortBM_ZennouGenkaRitu2.OrderBM_ZennouGenkaRitu2ByPkAsc(zennouGenkaRitu2Dao.selectAll());
    }

    BM_ZennouGenkaRitu2 getZennouGenkaRitu2(C_Tuukasyu pTuukasyu, String pZennoutkybr1, String pZennoutkybr2, String pZennoutkybr3, Integer pZennounensuu
        , String pTekiyoukknfrom, String pTekiyoukknkto) {

        return zennouGenkaRitu2Dao.getZennouGenkaRitu2(pTuukasyu, pZennoutkybr1, pZennoutkybr2, pZennoutkybr3, pZennounensuu
            , pTekiyoukknfrom, pTekiyoukknkto);
    }

    List<BM_ZennouKeikaRiritu2> getAllZennouKeikaRiritu2(){
        SortBM_ZennouKeikaRiritu2 sortBM_ZennouKeikaRiritu2 = new SortBM_ZennouKeikaRiritu2();
        return sortBM_ZennouKeikaRiritu2.OrderBM_ZennouKeikaRiritu2ByPkAsc(zennouKeikaRiritu2Dao.selectAll());
    }

    BM_ZennouKeikaRiritu2 getZennouKeikaRiritu2(C_Tuukasyu pTuukasyu, String pZennoutkybr1, String pZennoutkybr2, String pZennoutkybr3, Integer pKeikatukisuu
        , String pTekiyoukknfrom, String pTekiyoukknkto) {

        return zennouKeikaRiritu2Dao.getZennouKeikaRiritu2(pTuukasyu, pZennoutkybr1, pZennoutkybr2, pZennoutkybr3, pKeikatukisuu
            , pTekiyoukknfrom, pTekiyoukknkto);
    }

    List<BM_ZennouRiritu2> getAllZennouRiritu2(){
        SortBM_ZennouRiritu2 sortBM_ZennouRiritu2 = new SortBM_ZennouRiritu2();
        return sortBM_ZennouRiritu2.OrderBM_ZennouRiritu2ByPkAsc(zennouRiritu2Dao.selectAll());
    }

    BM_ZennouRiritu2 getZennouRiritu2(C_Tuukasyu pTuukasyu, String pZennoutkybr1, String pZennoutkybr2, String pZennoutkybr3, String pTekiyoukknfrom
        , String pTekiyoukknkto) {

        return zennouRiritu2Dao.getZennouRiritu2(pTuukasyu, pZennoutkybr1, pZennoutkybr2, pZennoutkybr3, pTekiyoukknfrom
            , pTekiyoukknkto);
    }

    List<BM_ZennouTumitateRitu2> getAllZennouTumitateRitu2(){
        SortBM_ZennouTumitateRitu2 sortBM_ZennouTumitateRitu2 = new SortBM_ZennouTumitateRitu2();
        return sortBM_ZennouTumitateRitu2.OrderBM_ZennouTumitateRitu2ByPkAsc(zennouTumitateRitu2Dao.selectAll());
    }

    BM_ZennouTumitateRitu2 ZennouTumitateRitu2(C_Tuukasyu pTuukasyu, String pZennoutkybr1, String pZennoutkybr2, String pZennoutkybr3, String pTekiyoukknfrom
        , String pTekiyoukknkto) {

        return zennouTumitateRitu2Dao.getZennouTumitateRitu2(pTuukasyu, pZennoutkybr1, pZennoutkybr2, pZennoutkybr3, pTekiyoukknfrom
            , pTekiyoukknkto);
    }
}
