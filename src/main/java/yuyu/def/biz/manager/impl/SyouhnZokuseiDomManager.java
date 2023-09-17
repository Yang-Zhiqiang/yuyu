package yuyu.def.biz.manager.impl;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.biz.result.bean.SyouhnZokuseiHaitoukbnSeg1cdByPKBean;
import yuyu.def.biz.sorter.SortBM_BosyuuKyuusi;
import yuyu.def.biz.sorter.SortBM_BunsyonoSettei;
import yuyu.def.biz.sorter.SortBM_KyhNitigakuBairitu;
import yuyu.def.biz.sorter.SortBM_SyouhnToriatukaiTuuka;
import yuyu.def.biz.sorter.SortBM_SyouhnZokusei;
import yuyu.def.biz.sorter.SortBM_SyouhnbetuSegment;
import yuyu.def.biz.sorter.SortBM_TokujyouSakugenRate;
import yuyu.def.biz.sorter.SortBM_Tuuka;
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_BoskyuusiRiyuuKbn;
import yuyu.def.classification.C_BunsyoSyubetuKbn;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_KataKbn;
import yuyu.def.classification.C_SegbunruiKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_Sknenkinsyu;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tkjyskgnkkn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.dao.BM_BosyuuKyuusiDao;
import yuyu.def.db.dao.BM_BunsyonoSetteiDao;
import yuyu.def.db.dao.BM_KyhNitigakuBairituDao;
import yuyu.def.db.dao.BM_SyouhnToriatukaiTuukaDao;
import yuyu.def.db.dao.BM_SyouhnZokuseiDao;
import yuyu.def.db.dao.BM_SyouhnbetuSegmentDao;
import yuyu.def.db.dao.BM_TokujyouSakugenRateDao;
import yuyu.def.db.dao.BM_TuukaDao;
import yuyu.def.db.entity.BM_BosyuuKyuusi;
import yuyu.def.db.entity.BM_BunsyonoSettei;
import yuyu.def.db.entity.BM_KyhNitigakuBairitu;
import yuyu.def.db.entity.BM_SyouhnToriatukaiTuuka;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.BM_SyouhnbetuSegment;
import yuyu.def.db.entity.BM_TokujyouSakugenRate;
import yuyu.def.db.entity.BM_Tuuka;


/**
 * SyouhnZokuseiDomマネージャー<br />
 * SyouhnZokuseiにおける、DB操作を提供する。<br />
 */
class SyouhnZokuseiDomManager {

    @Inject
    private BM_BunsyonoSetteiDao bunsyonoSetteiDao;

    @Inject
    private BM_KyhNitigakuBairituDao kyhNitigakuBairituDao;

    @Inject
    private BM_SyouhnZokuseiDao syouhnZokuseiDao;

    @Inject
    private BM_TokujyouSakugenRateDao tokujyouSakugenRateDao;

    @Inject
    private BM_TuukaDao tuukaDao;

    @Inject
    private BM_SyouhnbetuSegmentDao syouhnbetuSegmentDao;

    @Inject
    private BM_BosyuuKyuusiDao bosyuuKyuusiDao;

    @Inject
    private BM_SyouhnToriatukaiTuukaDao syouhnToriatukaiTuukaDao;

    List<BM_SyouhnZokusei> getAllSyouhnZokusei(){
        SortBM_SyouhnZokusei sortBM_SyouhnZokusei = new SortBM_SyouhnZokusei();
        return sortBM_SyouhnZokusei.OrderBM_SyouhnZokuseiByPkAsc(syouhnZokuseiDao.selectAll());
    }

    BM_SyouhnZokusei getSyouhnZokusei(String pSyouhncd, Integer pSyouhnsdno) {

        return syouhnZokuseiDao.getSyouhnZokusei(pSyouhncd, pSyouhnsdno);
    }

    BM_SyouhnZokusei getSyouhnZokuseiBySyouhncdHyoujiymd(String pSyouhncd, BizDate pHiduke) {

        return syouhnZokuseiDao.getSyouhnZokuseiBySyouhncdHyoujiymd(pSyouhncd, pHiduke);
    }

    SyouhnZokuseiHaitoukbnSeg1cdByPKBean getSyouhnZokuseiHaitoukbnSeg1cdByPK(String pSyouhncd, Integer pSyouhnsdno) {

        return syouhnZokuseiDao.getSyouhnZokuseiHaitoukbnSeg1cdByPK(pSyouhncd, pSyouhnsdno);
    }

    List<BM_SyouhnZokusei> getSyouhnZokuseisBySyutkkbnHyoujiymd(C_SyutkKbn pSyutkkbn, BizDate pHyoujidate) {

        return syouhnZokuseiDao.getSyouhnZokuseisBySyutkkbnHyoujiymd(pSyutkkbn, pHyoujidate);
    }

    Integer getSyouhnZokuseiMaxSyouhnsdnoBySyouhncdKykymd(String pSyouhncd, BizDate pKykymd) {

        return syouhnZokuseiDao.getSyouhnZokuseiMaxSyouhnsdnoBySyouhncdKykymd(pSyouhncd, pKykymd);
    }

    List<BM_SyouhnZokusei> getSyouhnZokuseisBySyouhncd(String pSyouhncd) {

        return syouhnZokuseiDao.getSyouhnZokuseisBySyouhncd(pSyouhncd);
    }

    List<BM_SyouhnZokusei> getSyouhnZokuseisBySyouhncdKijyunymd(String pSyouhncd, BizDate pKijyunymd) {

        return syouhnZokuseiDao.getSyouhnZokuseisBySyouhncdKijyunymd(pSyouhncd, pKijyunymd);
    }

    List<BM_SyouhnZokusei> getSyouhnZokuseisByHyoujidateItems(BizDate pHyoujidate, C_SyutkKbn pSyutkkbn, C_HknsyuruiNo pHknsyuruino, Integer pNkgnshosyouritu, Integer pDai1hknkkn) {

        return syouhnZokuseiDao.getSyouhnZokuseisByHyoujidateItems(pHyoujidate, pSyutkkbn, pHknsyuruino, pNkgnshosyouritu, pDai1hknkkn);
    }

    List<BM_SyouhnZokusei> getSyouhnZokuseisByHknsyuruinoItems(BizDate pHyoujidate, C_SyutkKbn pSyutkkbn, C_HknsyuruiNo pHknsyuruino, Integer pNkgnshosyouritu, Integer pDai1hknkkn
        , C_Tuukasyu pTuukasyu, C_UmuKbn pSyksbyensitihsyutktekiumu, C_Sknenkinsyu pSknenkinsyu, C_UmuKbn pTeikisiharaikinumu) {

        return syouhnZokuseiDao.getSyouhnZokuseisByHknsyuruinoItems(pHyoujidate,pSyutkkbn,pHknsyuruino,pNkgnshosyouritu,pDai1hknkkn,pTuukasyu,pSyksbyensitihsyutktekiumu,pSknenkinsyu,pTeikisiharaikinumu);
    }

    List<BM_SyouhnZokusei> getSyouhnZokuseisByKykymdItems(BizDate pKykymd, C_SyutkKbn pSyutkkbn, C_HknsyuruiNo pHknsyuruino, Integer pNkgnshosyouritu, Integer pDai1hknkkn
        , C_Tuukasyu pTuukasyu, C_UmuKbn pSyksbyensitihsyutktekiumu, C_Sknenkinsyu pSknenkinsyu, C_UmuKbn pTeikisiharaikinumu) {

        return syouhnZokuseiDao.getSyouhnZokuseisByKykymdItems(pKykymd,pSyutkkbn,pHknsyuruino,pNkgnshosyouritu,pDai1hknkkn,pTuukasyu,pSyksbyensitihsyutktekiumu,pSknenkinsyu, pTeikisiharaikinumu);
    }

    List<BM_SyouhnZokusei> getSyouhnZokuseisByKykymdItems2(BizDate pKykymd, C_SyutkKbn pSyutkkbn, C_HknsyuruiNo pHknsyuruino, Integer pNkgnshosyouritu,
        C_UmuKbn pSyksbyensitihsyutktekiumu, C_Sknenkinsyu pSknenkinsyu, C_UmuKbn pTeikisiharaikinumu) {

        return syouhnZokuseiDao.getSyouhnZokuseisByKykymdItems2(pKykymd,pSyutkkbn,pHknsyuruino,pNkgnshosyouritu,pSyksbyensitihsyutktekiumu,pSknenkinsyu, pTeikisiharaikinumu);
    }

    BM_SyouhnZokusei getSyouhnZokuseiBySyouhncdMaxSyouhnsdno(String pSyouhncd) {

        return syouhnZokuseiDao.getSyouhnZokuseiBySyouhncdMaxSyouhnsdno(pSyouhncd);
    }

    List<BM_SyouhnZokusei> getSyouhnZokuseisByMosnoSyutkkbnSyssyoriymd(String pMosno, C_SyutkKbn pSyutkkbn, BizDate pSyssyoriymd) {

        return syouhnZokuseiDao.getSyouhnZokuseisByMosnoSyutkkbnSyssyoriymd(pMosno, pSyutkkbn, pSyssyoriymd);
    }

    List<BM_SyouhnZokusei> getSyouhnZokuseisByHyoujidateSyutkkbnHknsyuruinoNkgnshosyouritu(BizDate pHyoujidate, C_SyutkKbn pSyutkkbn, C_HknsyuruiNo pHknsyuruino, Integer pNkgnshosyouritu) {

        return syouhnZokuseiDao.getSyouhnZokuseisByHyoujidateSyutkkbnHknsyuruinoNkgnshosyouritu(pHyoujidate, pSyutkkbn, pHknsyuruino, pNkgnshosyouritu);
    }

    List<BM_SyouhnZokusei> getSyouhnZokuseisBySyouhncdKykfromymdKyktoymd(String pSyouhncd, BizDate pKykymd) {

        return syouhnZokuseiDao.getSyouhnZokuseisBySyouhncdKykfromymdKyktoymd(pSyouhncd, pKykymd);
    }

    List<BM_KyhNitigakuBairitu> getAllKyhNitigakuBairitu(){
        SortBM_KyhNitigakuBairitu sortBM_KyhNitigakuBairitu = new SortBM_KyhNitigakuBairitu();
        return sortBM_KyhNitigakuBairitu.OrderBM_KyhNitigakuBairituByPkAsc(kyhNitigakuBairituDao.selectAll());
    }

    BM_KyhNitigakuBairitu getKyhNitigakuBairitu(String pSyouhncd, Integer pSyouhnsdno, C_KataKbn pKatakbn) {

        return kyhNitigakuBairituDao.getKyhNitigakuBairitu(pSyouhncd, pSyouhnsdno, pKatakbn);
    }

    List<BM_TokujyouSakugenRate> getAllTokujyouSakugenRate(){
        SortBM_TokujyouSakugenRate sortBM_TokujyouSakugenRate = new SortBM_TokujyouSakugenRate();
        return sortBM_TokujyouSakugenRate.OrderBM_TokujyouSakugenRateByPkAsc(tokujyouSakugenRateDao.selectAll());
    }

    BM_TokujyouSakugenRate getTokujyouSakugenRate(String pSyouhncd, Integer pSyouhnsdno, C_Tkjyskgnkkn pTkjyskgnkkn) {

        return tokujyouSakugenRateDao.getTokujyouSakugenRate(pSyouhncd, pSyouhnsdno, pTkjyskgnkkn);
    }

    List<BM_Tuuka> getAllTuuka(){
        SortBM_Tuuka sortBM_Tuuka = new SortBM_Tuuka();
        return sortBM_Tuuka.OrderBM_TuukaByPkAsc(tuukaDao.selectAll());
    }

    BM_Tuuka getTuuka(C_Tuukasyu pTuukasyu) {

        return tuukaDao.getTuuka(pTuukasyu);
    }

    List<BM_BunsyonoSettei> getAllBunsyonoSettei(){
        SortBM_BunsyonoSettei sortBM_BunsyonoSettei = new SortBM_BunsyonoSettei();
        return sortBM_BunsyonoSettei.OrderBM_BunsyonoSetteiByPkAsc(bunsyonoSetteiDao.selectAll());
    }

    BM_BunsyonoSettei getBunsyonoSettei(C_BunsyoSyubetuKbn pBunsyosyubetukbn, C_AisyoumeiKbn pAisyoumeikbn, C_Channelcd pChannelcd, String pOyadrtencd, Integer pRenno) {

        return bunsyonoSetteiDao.getBunsyonoSettei(pBunsyosyubetukbn, pAisyoumeikbn, pChannelcd, pOyadrtencd, pRenno);
    }

    List<BM_BunsyonoSettei> getBunsyonoSetteiByBnsysybtkbnAisyoumeikbnChannelcdTkyuymd(C_BunsyoSyubetuKbn pBunsyosyubetukbn, C_AisyoumeiKbn pAisyoumeikbn, C_Channelcd pChannelcd, BizDate pTekiyouYmd) {

        return bunsyonoSetteiDao.getBunsyonoSetteiByBnsysybtkbnAisyoumeikbnChannelcdTkyuymd(pBunsyosyubetukbn, pAisyoumeikbn, pChannelcd, pTekiyouYmd);
    }

    List<BM_SyouhnbetuSegment> getAllSyouhnbetuSegment(){
        SortBM_SyouhnbetuSegment sortBM_SyouhnbetuSegment = new SortBM_SyouhnbetuSegment();
        return sortBM_SyouhnbetuSegment.OrderBM_SyouhnbetuSegmentByPkAsc(syouhnbetuSegmentDao.selectAll());
    }

    BM_SyouhnbetuSegment getSyouhnbetuSegment(String pSyouhncd, C_Tuukasyu pKyktuukasyu, C_SegbunruiKbn pSegbunrui1, C_SegbunruiKbn pSegbunrui2) {

        return syouhnbetuSegmentDao.getSyouhnbetuSegment(pSyouhncd, pKyktuukasyu, pSegbunrui1, pSegbunrui2);
    }

    List<BM_BosyuuKyuusi> getAllBosyuuKyuusi(){
        SortBM_BosyuuKyuusi sortBM_BosyuuKyuusi = new SortBM_BosyuuKyuusi();
        return sortBM_BosyuuKyuusi.OrderBM_BosyuuKyuusiByPkAsc(bosyuuKyuusiDao.selectAll());
    }

    BM_BosyuuKyuusi getBosyuuKyuusi(C_SysKbn pSksyskbn, String pSyouhncd, String pYoteiriritutkybr1, String pYoteiriritutkybr2, C_SkeijimuKbn pSkeijimukbn
        , Integer pHanteiyuusendo) {

        return bosyuuKyuusiDao.getBosyuuKyuusi(pSksyskbn, pSyouhncd, pYoteiriritutkybr1, pYoteiriritutkybr2, pSkeijimukbn
            , pHanteiyuusendo);
    }

    List<BM_BosyuuKyuusi> getBosyuuKyuusiBySyouhncdSkeijimukbn(C_SysKbn pSksyskbn, String pSyouhncd, String pYoteiriritutkybr1, String pYoteiriritutkybr2, C_SkeijimuKbn pSkeijimukbn
        , C_BoskyuusiRiyuuKbn pBoskyuusiriyuukbn) {

        return bosyuuKyuusiDao.getBosyuuKyuusiBySyouhncdSkeijimukbn(pSksyskbn, pSyouhncd, pYoteiriritutkybr1, pYoteiriritutkybr2, pSkeijimukbn, pBoskyuusiriyuukbn);
    }

    List<BM_SyouhnToriatukaiTuuka> getAllSyouhnToriatukaiTuuka(){
        SortBM_SyouhnToriatukaiTuuka sortBM_SyouhnToriatukaiTuuka = new SortBM_SyouhnToriatukaiTuuka();
        return sortBM_SyouhnToriatukaiTuuka.OrderBM_SyouhnToriatukaiTuukaByPkAsc(syouhnToriatukaiTuukaDao.selectAll());
    }

    BM_SyouhnToriatukaiTuuka getSyouhnToriatukaiTuuka(String pSyouhncd, BizDate pTkyfromymd, BizDate pTkytoymd, C_BlnktkumuKbn pZenkizennouumu, C_Tuukasyu pKyktuukasyu
        , C_Tuukasyu pHrktuukasyu) {

        return syouhnToriatukaiTuukaDao.getSyouhnToriatukaiTuuka(pSyouhncd, pTkyfromymd, pTkytoymd, pZenkizennouumu, pKyktuukasyu
            , pHrktuukasyu);
    }

    List<BM_SyouhnToriatukaiTuuka> getSyouhnToriatukaiTuukasByPk(String pSyouhncd, BizDate pTekiyouYmd, C_BlnktkumuKbn pZenkizennouumu, C_Tuukasyu pKyktuukasyu
        , C_Tuukasyu pHrktuukasyu) {

        return syouhnToriatukaiTuukaDao.getSyouhnToriatukaiTuukasByPk(pSyouhncd, pTekiyouYmd, pZenkizennouumu, pKyktuukasyu, pHrktuukasyu);
    }

    List<BM_SyouhnZokusei> getSyouhnZokuseisByHknsyuruinoItems2(BizDate pHyoujidate, C_SyutkKbn pSyutkkbn, C_HknsyuruiNo pHknsyuruino, Integer pNkgnshosyouritu
        , C_UmuKbn pSyksbyensitihsyutktekiumu, C_Sknenkinsyu pSknenkinsyu, C_UmuKbn pTeikisiharaikinumu) {

        return syouhnZokuseiDao.getSyouhnZokuseisByHknsyuruinoItems2(pHyoujidate,pSyutkkbn,pHknsyuruino,pNkgnshosyouritu,pSyksbyensitihsyutktekiumu,pSknenkinsyu,pTeikisiharaikinumu);
    }

}
