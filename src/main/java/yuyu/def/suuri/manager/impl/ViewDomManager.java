package yuyu.def.suuri.manager.impl;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_HaitouKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.dao.SV_BikinIdouMeisaiDao;
import yuyu.def.db.dao.SV_HoyuuMeisaiDao;
import yuyu.def.db.dao.SV_IdouMeisaiDao;
import yuyu.def.db.dao.SV_KiykHnriknSutugkDao;
import yuyu.def.db.dao.SV_KiykSyuhnDataDao;
import yuyu.def.db.dao.SV_RisanomiTuujyuHitusyyugkDao;
import yuyu.def.db.dao.SV_SibourituRendouDao;
import yuyu.def.db.dao.SV_SibourituToukeiSeibigoDao;
import yuyu.def.db.dao.SV_SnkiykGtjSirtDao;
import yuyu.def.db.dao.SV_SnkiykSyunyupDao;
import yuyu.def.db.dao.SV_Sp2RnduyuSouseirituDao;
import yuyu.def.db.dao.SV_TuujyuHitusyyugkDao;
import yuyu.def.db.entity.SV_BikinIdouMeisai;
import yuyu.def.db.entity.SV_HoyuuMeisai;
import yuyu.def.db.entity.SV_IdouMeisai;
import yuyu.def.db.entity.SV_KiykHnriknSutugk;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.def.db.entity.SV_RisanomiTuujyuHitusyyugk;
import yuyu.def.db.entity.SV_SibourituRendou;
import yuyu.def.db.entity.SV_SibourituToukeiSeibigo;
import yuyu.def.db.entity.SV_SnkiykGtjSirt;
import yuyu.def.db.entity.SV_SnkiykSyunyup;
import yuyu.def.db.entity.SV_Sp2RnduyuSouseiritu;
import yuyu.def.db.entity.SV_TuujyuHitusyyugk;
import yuyu.def.suuri.sorter.SortSV_BikinIdouMeisai;
import yuyu.def.suuri.sorter.SortSV_HoyuuMeisai;
import yuyu.def.suuri.sorter.SortSV_IdouMeisai;
import yuyu.def.suuri.sorter.SortSV_KiykHnriknSutugk;
import yuyu.def.suuri.sorter.SortSV_KiykSyuhnData;
import yuyu.def.suuri.sorter.SortSV_RisanomiTuujyuHitusyyugk;
import yuyu.def.suuri.sorter.SortSV_SibourituRendou;
import yuyu.def.suuri.sorter.SortSV_SibourituToukeiSeibigo;
import yuyu.def.suuri.sorter.SortSV_SnkiykGtjSirt;
import yuyu.def.suuri.sorter.SortSV_SnkiykSyunyup;
import yuyu.def.suuri.sorter.SortSV_Sp2RnduyuSouseiritu;
import yuyu.def.suuri.sorter.SortSV_TuujyuHitusyyugk;


/**
 * ViewDomマネージャー<br />
 * Viewにおける、DB操作を提供する。<br />
 */
class ViewDomManager {


    @Inject
    private SV_BikinIdouMeisaiDao bikinIdouMeisaiDao;


    @Inject
    private SV_HoyuuMeisaiDao hoyuuMeisaiDao;


    @Inject
    private SV_IdouMeisaiDao idouMeisaiDao;


    @Inject
    private SV_KiykHnriknSutugkDao kiykHnriknSutugkDao;


    @Inject
    private SV_KiykSyuhnDataDao kiykSyuhnDataDao;


    @Inject
    private SV_RisanomiTuujyuHitusyyugkDao risanomiTuujyuHitusyyugkDao;


    @Inject
    private SV_SibourituRendouDao sibourituRendouDao;


    @Inject
    private SV_SibourituToukeiSeibigoDao sibourituToukeiSeibigoDao;


    @Inject
    private SV_SnkiykGtjSirtDao snkiykGtjSirtDao;


    @Inject
    private SV_SnkiykSyunyupDao snkiykSyunyupDao;


    @Inject
    private SV_Sp2RnduyuSouseirituDao sp2RnduyuSouseirituDao;


    @Inject
    private SV_TuujyuHitusyyugkDao tuujyuHitusyyugkDao;


    List<SV_SnkiykGtjSirt> getAllSnkiykGtjSirt(){
        SortSV_SnkiykGtjSirt sortSV_SnkiykGtjSirt = new SortSV_SnkiykGtjSirt();
        return sortSV_SnkiykGtjSirt.OrderSV_SnkiykGtjSirtByPkAsc(snkiykGtjSirtDao.selectAll());
    }


    SV_SnkiykGtjSirt getSnkiykGtjSirt(String pMosno) {

        return snkiykGtjSirtDao.getSnkiykGtjSirt(pMosno);
    }


    List<SV_SnkiykSyunyup> getAllSnkiykSyunyup(){
        SortSV_SnkiykSyunyup sortSV_SnkiykSyunyup = new SortSV_SnkiykSyunyup();
        return sortSV_SnkiykSyunyup.OrderSV_SnkiykSyunyupByPkAsc(snkiykSyunyupDao.selectAll());
    }


    SV_SnkiykSyunyup getSnkiykSyunyup(String pMosno) {

        return snkiykSyunyupDao.getSnkiykSyunyup(pMosno);
    }


    List<SV_HoyuuMeisai> getAllHoyuuMeisai(){
        SortSV_HoyuuMeisai sortSV_HoyuuMeisai = new SortSV_HoyuuMeisai();
        return sortSV_HoyuuMeisai.OrderSV_HoyuuMeisaiByPkAsc(hoyuuMeisaiDao.selectAll());
    }


    SV_HoyuuMeisai getHoyuuMeisai(String pSyono) {

        return hoyuuMeisaiDao.getHoyuuMeisai(pSyono);
    }


    List<SV_KiykHnriknSutugk> getAllKiykHnriknSutugk(){
        SortSV_KiykHnriknSutugk sortSV_KiykHnriknSutugk = new SortSV_KiykHnriknSutugk();
        return sortSV_KiykHnriknSutugk.OrderSV_KiykHnriknSutugkByPkAsc(kiykHnriknSutugkDao.selectAll());
    }


    SV_KiykHnriknSutugk getKiykHnriknSutugk(String pSyono) {

        return kiykHnriknSutugkDao.getKiykHnriknSutugk(pSyono);
    }


    List<SV_KiykSyuhnData> getAllKiykSyuhnData(){
        SortSV_KiykSyuhnData sortSV_KiykSyuhnData = new SortSV_KiykSyuhnData();
        return sortSV_KiykSyuhnData.OrderSV_KiykSyuhnDataByPkAsc(kiykSyuhnDataDao.selectAll());
    }


    SV_KiykSyuhnData getKiykSyuhnData(String pSyono, C_SyutkKbn pSyutkkbn, String pSyouhncd, Integer pSyouhnsdno, Integer pKyksyouhnrenno, String pHenkousikibetukey) {

        return kiykSyuhnDataDao.getKiykSyuhnData(pSyono, pSyutkkbn, pSyouhncd, pSyouhnsdno, pKyksyouhnrenno, pHenkousikibetukey);
    }


    List<SV_IdouMeisai> getAllIdouMeisai(){
        SortSV_IdouMeisai sortSV_IdouMeisai = new SortSV_IdouMeisai();
        return sortSV_IdouMeisai.OrderSV_IdouMeisaiByPkAsc(idouMeisaiDao.selectAll());
    }


    SV_IdouMeisai getIdouMeisai(String pSyono, String pGyoumuKousinKinou, String pGyoumuKousinTime) {

        return idouMeisaiDao.getIdouMeisai(pSyono, pGyoumuKousinKinou, pGyoumuKousinTime);
    }


    List<SV_BikinIdouMeisai> getAllBikinIdouMeisai(){
        SortSV_BikinIdouMeisai sortSV_BikinIdouMeisai = new SortSV_BikinIdouMeisai();
        return sortSV_BikinIdouMeisai.OrderSV_BikinIdouMeisaiByPkAsc(bikinIdouMeisaiDao.selectAll());
    }


    SV_BikinIdouMeisai getBikinIdouMeisai(String pSyono, String pGyoumuKousinKinou, String pGyoumuKousinTime) {

        return bikinIdouMeisaiDao.getBikinIdouMeisai(pSyono, pGyoumuKousinKinou, pGyoumuKousinTime);
    }


    List<SV_SibourituToukeiSeibigo> getAllSibourituToukeiSeibigo(){
        SortSV_SibourituToukeiSeibigo sortSV_SibourituToukeiSeibigo = new SortSV_SibourituToukeiSeibigo();
        return sortSV_SibourituToukeiSeibigo.OrderSV_SibourituToukeiSeibigoByPkAsc(sibourituToukeiSeibigoDao.selectAll());
    }


    SV_SibourituToukeiSeibigo getSibourituToukeiSeibigo(String pSyono, String pGyoumuKousinKinou, String pGyoumuKousinTime) {

        return sibourituToukeiSeibigoDao.getSibourituToukeiSeibigo(pSyono, pGyoumuKousinKinou, pGyoumuKousinTime);
    }


    List<SV_Sp2RnduyuSouseiritu> getAllSp2RnduyuSouseiritu(){
        SortSV_Sp2RnduyuSouseiritu sortSV_Sp2RnduyuSouseiritu = new SortSV_Sp2RnduyuSouseiritu();
        return sortSV_Sp2RnduyuSouseiritu.OrderSV_Sp2RnduyuSouseirituByPkAsc(sp2RnduyuSouseirituDao.selectAll());
    }


    SV_Sp2RnduyuSouseiritu getSp2RnduyuSouseiritu(String pMosno) {

        return sp2RnduyuSouseirituDao.getSp2RnduyuSouseiritu(pMosno);
    }


    ExDBResults<SV_TuujyuHitusyyugk> getTuujyuHitusyyugksBySyutkkbnHaitoukbn(C_SyutkKbn pSyutkkbn, C_HaitouKbn pHaitoukbn1, String pKbnkey) {

        return tuujyuHitusyyugkDao.getTuujyuHitusyyugksBySyutkkbnHaitoukbn(pSyutkkbn, pHaitoukbn1, pKbnkey);
    }


    List<SV_KiykSyuhnData> getKiykSyuhnDatasBySyonoSyutkkbn(String pSyono, C_SyutkKbn pSyutkkbn) {

        return  kiykSyuhnDataDao.getKiykSyuhnDatasBySyonoSyutkkbn(pSyono, pSyutkkbn);
    }


    List<BizDate> getKiykSyuhnDataKouryokuhasseiymdsBySyonoHenkousikibetukey(String pSyono, String pHenkousikibetukey) {

        return kiykSyuhnDataDao.getKiykSyuhnDataKouryokuhasseiymdsBySyonoHenkousikibetukey(pSyono, pHenkousikibetukey);
    }


    ExDBResults<SV_RisanomiTuujyuHitusyyugk> getRisanomiTuujyuHitusyyugksBySyutkkbnHaitoukbn(C_SyutkKbn pSyutkkbn, C_HaitouKbn pHaitoukbn, String pKbnkey) {

        return risanomiTuujyuHitusyyugkDao.getRisanomiTuujyuHitusyyugksBySyutkkbnHaitoukbn(pSyutkkbn, pHaitoukbn, pKbnkey);
    }


    List<SV_SibourituRendou> getAllSibourituRendou(){
        SortSV_SibourituRendou sortSV_SibourituRendou = new SortSV_SibourituRendou();
        return sortSV_SibourituRendou.OrderSV_SibourituRendouByPkAsc(sibourituRendouDao.selectAll());
    }


    SV_SibourituRendou getSibourituRendou(String pMosno) {

        return sibourituRendouDao.getSibourituRendou(pMosno);
    }


    List<SV_TuujyuHitusyyugk> getAllTuujyuHitusyyugk(){
        SortSV_TuujyuHitusyyugk sortSV_TuujyuHitusyyugk = new SortSV_TuujyuHitusyyugk();
        return sortSV_TuujyuHitusyyugk.OrderSV_TuujyuHitusyyugkByPkAsc(tuujyuHitusyyugkDao.selectAll());
    }


    SV_TuujyuHitusyyugk getTuujyuHitusyyugk(String pSyono, C_SyutkKbn pSyutkkbn, String pSyouhncd, Integer pSyouhnsdno, Integer pKyksyouhnrenno) {

        return tuujyuHitusyyugkDao.getTuujyuHitusyyugk(pSyono, pSyutkkbn, pSyouhncd, pSyouhnsdno, pKyksyouhnrenno);
    }


    List<SV_RisanomiTuujyuHitusyyugk> getAllRisanomiTuujyuHitusyyugk(){
        SortSV_RisanomiTuujyuHitusyyugk sortSV_RisanomiTuujyuHitusyyugk = new SortSV_RisanomiTuujyuHitusyyugk();
        return sortSV_RisanomiTuujyuHitusyyugk.OrderSV_RisanomiTuujyuHitusyyugkByPkAsc(risanomiTuujyuHitusyyugkDao.selectAll());
    }


    SV_RisanomiTuujyuHitusyyugk getRisanomiTuujyuHitusyyugk(String pSyono, C_SyutkKbn pSyutkkbn, String pSyouhncd, Integer pSyouhnsdno, Integer pKyksyouhnrenno) {

        return risanomiTuujyuHitusyyugkDao.getRisanomiTuujyuHitusyyugk(pSyono, pSyutkkbn, pSyouhncd, pSyouhnsdno, pKyksyouhnrenno);
    }

}
