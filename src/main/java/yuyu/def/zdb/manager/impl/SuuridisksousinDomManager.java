package yuyu.def.zdb.manager.impl;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.dao.*;
import yuyu.def.db.entity.*;


/**
 * SuuridisksousinDomマネージャー<br />
 * Suuridisksousinにおける、DB操作を提供する。<br />
 */
class SuuridisksousinDomManager {


    @Inject
    private ZT_AlmNnknHyuRnDao almNnknHyuRnDao;


    @Inject
    private ZT_AlmNnknHyuTyDao almNnknHyuTyDao;


    @Inject
    private ZT_BikinIdouMeisaiRnDao bikinIdouMeisaiRnDao;


    @Inject
    private ZT_BikinIdouMeisaiTyDao bikinIdouMeisaiTyDao;


    @Inject
    private ZT_BikinKeiyakuSeisandRnDao bikinKeiyakuSeisandRnDao;


    @Inject
    private ZT_BikinKeiyakuSeisandTyDao bikinKeiyakuSeisandTyDao;


    @Inject
    private ZT_DshrToukeiLoadingRnDao dshrToukeiLoadingRnDao;


    @Inject
    private ZT_DshrToukeiLoadingTyDao dshrToukeiLoadingTyDao;


    @Inject
    private ZT_KsnRayJigyohiRnDao ksnRayJigyohiRnDao;


    @Inject
    private ZT_KsnRayJigyohiTyDao ksnRayJigyohiTyDao;


    @Inject
    private ZT_RayIdouVRnDao rayIdouVRnDao;


    @Inject
    private ZT_RayIdouVTyDao rayIdouVTyDao;


    @Inject
    private ZT_RayJigyohiRnDao rayJigyohiRnDao;


    @Inject
    private ZT_RayJigyohiTyDao rayJigyohiTyDao;


    @Inject
    private ZT_RayKimatuVRnDao rayKimatuVRnDao;


    @Inject
    private ZT_RayKimatuVTyDao rayKimatuVTyDao;


    @Inject
    private ZT_RayVKnsyuyuRnDao rayVKnsyuyuRnDao;


    @Inject
    private ZT_RayVKnsyuyuTyDao rayVKnsyuyuTyDao;


    @Inject
    private ZT_DshrToukeiRnDao dshrToukeiRnDao;


    @Inject
    private ZT_DshrToukeiTyDao dshrToukeiTyDao;


    @Inject
    private ZT_GkknHnkuSyrSynypTukiRnDao gkknHnkuSyrSynypTukiRnDao;


    @Inject
    private ZT_GkknHnkuSyrSynypTukiTyDao gkknHnkuSyrSynypTukiTyDao;


    @Inject
    private ZT_HoyuuMeisaiRnDao hoyuuMeisaiRnDao;


    @Inject
    private ZT_HoyuuMeisaiTyDao hoyuuMeisaiTyDao;


    @Inject
    private ZT_IdouMeisaiRnDao idouMeisaiRnDao;


    @Inject
    private ZT_IdouMeisaiTyDao idouMeisaiTyDao;


    @Inject
    private ZT_JigyounndsikiTkHoyuuRnDao jigyounndsikiTkHoyuuRnDao;


    @Inject
    private ZT_JigyounndsikiTkHoyuuTyDao jigyounndsikiTkHoyuuTyDao;


    @Inject
    private ZT_KaiykHrSoutougakuRnDao kaiykHrSoutougakuRnDao;


    @Inject
    private ZT_KaiykHrSoutougakuTyDao kaiykHrSoutougakuTyDao;


    @Inject
    private ZT_KariwariateHtkinMeisaiRnDao kariwariateHtkinMeisaiRnDao;


    @Inject
    private ZT_KariwariateHtkinMeisaiTyDao kariwariateHtkinMeisaiTyDao;


    @Inject
    private ZT_KbkSsuRnduHknIdouVRnDao kbkSsuRnduHknIdouVRnDao;


    @Inject
    private ZT_KbkSsuRnduHknIdouVTyDao kbkSsuRnduHknIdouVTyDao;


    @Inject
    private ZT_KbkSsuRnduHknJigyohiRnDao kbkSsuRnduHknJigyohiRnDao;


    @Inject
    private ZT_KbkSsuRnduHknJigyohiTyDao kbkSsuRnduHknJigyohiTyDao;


    @Inject
    private ZT_KbkSsuRnduHknKimatuVRnDao kbkSsuRnduHknKimatuVRnDao;


    @Inject
    private ZT_KbkSsuRnduHknKimatuVTyDao kbkSsuRnduHknKimatuVTyDao;


    @Inject
    private ZT_KsnKbkSsuRnduHknJigyohiRnDao ksnKbkSsuRnduHknJigyohiRnDao;


    @Inject
    private ZT_KsnKbkSsuRnduHknJigyohiTyDao ksnKbkSsuRnduHknJigyohiTyDao;


    @Inject
    private ZT_KyhknShrJyoukyouRnrkRnDao kyhknShrJyoukyouRnrkRnDao;


    @Inject
    private ZT_KyhknShrJyoukyouRnrkTyDao kyhknShrJyoukyouRnrkTyDao;


    @Inject
    private ZT_NkBikinRnDao nkBikinRnDao;


    @Inject
    private ZT_NkBikinTyDao nkBikinTyDao;


    @Inject
    private ZT_NkGensiHySgRnDao nkGensiHySgRnDao;


    @Inject
    private ZT_NkGensiHySgTyDao nkGensiHySgTyDao;


    @Inject
    private ZT_NkGensiKtyRnDao nkGensiKtyRnDao;


    @Inject
    private ZT_NkGensiKtyTyDao nkGensiKtyTyDao;


    @Inject
    private ZT_NkGensiRigRnDao nkGensiRigRnDao;


    @Inject
    private ZT_NkGensiRigTyDao nkGensiRigTyDao;


    @Inject
    private ZT_NkHitAddInfoRnDao nkHitAddInfoRnDao;


    @Inject
    private ZT_NkHitAddInfoTyDao nkHitAddInfoTyDao;


    @Inject
    private ZT_NkHitKsnRnDao nkHitKsnRnDao;


    @Inject
    private ZT_NkHitKsnTyDao nkHitKsnTyDao;


    @Inject
    private ZT_NkHitKtyRnDao nkHitKtyRnDao;


    @Inject
    private ZT_NkHitKtyTyDao nkHitKtyTyDao;


    @Inject
    private ZT_NkHitRigRnDao nkHitRigRnDao;


    @Inject
    private ZT_NkHitRigTyDao nkHitRigTyDao;


    @Inject
    private ZT_NkIktHriRnDao nkIktHriRnDao;


    @Inject
    private ZT_NkIktHriTyDao nkIktHriTyDao;


    @Inject
    private ZT_NkToukeiHySgRnDao nkToukeiHySgRnDao;


    @Inject
    private ZT_NkToukeiHySgTyDao nkToukeiHySgTyDao;


    @Inject
    private ZT_NkToukeiKtyRnDao nkToukeiKtyRnDao;


    @Inject
    private ZT_NkToukeiKtyTyDao nkToukeiKtyTyDao;


    @Inject
    private ZT_NkToukeiRigRnDao nkToukeiRigRnDao;


    @Inject
    private ZT_NkToukeiRigTyDao nkToukeiRigTyDao;


    @Inject
    private ZT_OuNnknShrRnDao ouNnknShrRnDao;


    @Inject
    private ZT_OuNnknShrTyDao ouNnknShrTyDao;


    @Inject
    private ZT_RisaTjHitNminusZeroRnDao risaTjHitNminusZeroRnDao;


    @Inject
    private ZT_RisaTjHitNminusZeroTyDao risaTjHitNminusZeroTyDao;


    @Inject
    private ZT_RisaTjHitNplusQuartRnDao risaTjHitNplusQuartRnDao;


    @Inject
    private ZT_RisaTjHitNplusQuartTyDao risaTjHitNplusQuartTyDao;


    @Inject
    private ZT_RisaTjHitNplusZeroRnDao risaTjHitNplusZeroRnDao;


    @Inject
    private ZT_RisaTjHitNplusZeroTyDao risaTjHitNplusZeroTyDao;


    @Inject
    private ZT_RrtHndugtHknJigyohiRnDao rrtHndugtHknJigyohiRnDao;


    @Inject
    private ZT_RrtHndugtHknJigyohiTyDao rrtHndugtHknJigyohiTyDao;


    @Inject
    private ZT_RrtHndugtHknKsnJigyohiRnDao rrtHndugtHknKsnJigyohiRnDao;


    @Inject
    private ZT_RrtHndugtHknKsnJigyohiTyDao rrtHndugtHknKsnJigyohiTyDao;


    @Inject
    private ZT_RrtHndugtHknVKnsyuyuRnDao rrtHndugtHknVKnsyuyuRnDao;


    @Inject
    private ZT_RrtHndugtHknVKnsyuyuTyDao rrtHndugtHknVKnsyuyuTyDao;


    @Inject
    private ZT_SbRituRendouRnDao sbRituRendouRnDao;


    @Inject
    private ZT_SbRituRendouTyDao sbRituRendouTyDao;


    @Inject
    private ZT_SbRituToukeiSeibiRenRnDao sbRituToukeiSeibiRenRnDao;


    @Inject
    private ZT_SbRituToukeiSeibiRenTyDao sbRituToukeiSeibiRenTyDao;


    @Inject
    private ZT_SkKsnHurikaeHikaeRnDao skKsnHurikaeHikaeRnDao;


    @Inject
    private ZT_SkKsnHurikaeHikaeTyDao skKsnHurikaeHikaeTyDao;


    @Inject
    private ZT_SkKsnHurikaeRnDao skKsnHurikaeRnDao;


    @Inject
    private ZT_SkKsnHurikaeTyDao skKsnHurikaeTyDao;


    @Inject
    private ZT_SkKsnKaikeiTorihikiRnDao skKsnKaikeiTorihikiRnDao;


    @Inject
    private ZT_SkKsnKaikeiTorihikiTyDao skKsnKaikeiTorihikiTyDao;


    @Inject
    private ZT_SkKsnKubunKeiriRnDao skKsnKubunKeiriRnDao;


    @Inject
    private ZT_SkKsnKubunKeiriTyDao skKsnKubunKeiriTyDao;


    @Inject
    private ZT_Skeiksnbsgetujisr1RnDao skeiksnbsgetujisr1RnDao;


    @Inject
    private ZT_Skeiksnbsgetujisr1TyDao skeiksnbsgetujisr1TyDao;


    @Inject
    private ZT_Skeiksnbsgetujisr2RnDao skeiksnbsgetujisr2RnDao;


    @Inject
    private ZT_Skeiksnbsgetujisr2TyDao skeiksnbsgetujisr2TyDao;


    @Inject
    private ZT_Skeiksnbsgetujisr3RnDao skeiksnbsgetujisr3RnDao;


    @Inject
    private ZT_Skeiksnbsgetujisr3TyDao skeiksnbsgetujisr3TyDao;


    @Inject
    private ZT_Skeiksnbsgetujisr4RnDao skeiksnbsgetujisr4RnDao;


    @Inject
    private ZT_Skeiksnbsgetujisr4TyDao skeiksnbsgetujisr4TyDao;


    @Inject
    private ZT_Skeiksnbsgetujisr5RnDao skeiksnbsgetujisr5RnDao;


    @Inject
    private ZT_Skeiksnbsgetujisr5TyDao skeiksnbsgetujisr5TyDao;


    @Inject
    private ZT_Skeiksnbsgetujisr6RnDao skeiksnbsgetujisr6RnDao;


    @Inject
    private ZT_Skeiksnbsgetujisr6TyDao skeiksnbsgetujisr6TyDao;


    @Inject
    private ZT_SkeisynyptoukeiksnRnDao skeisynyptoukeiksnRnDao;


    @Inject
    private ZT_SkeisynyptoukeiksnTyDao skeisynyptoukeiksnTyDao;


    @Inject
    private ZT_SkeisynyptoukeirigRnDao skeisynyptoukeirigRnDao;


    @Inject
    private ZT_SkeisynyptoukeirigTyDao skeisynyptoukeirigTyDao;


    @Inject
    private ZT_Sp2RnduyuSouseiritu1RnDao sp2RnduyuSouseiritu1RnDao;


    @Inject
    private ZT_Sp2RnduyuSouseiritu1TyDao sp2RnduyuSouseiritu1TyDao;


    @Inject
    private ZT_Sp2RnduyuSouseiritu2RnDao sp2RnduyuSouseiritu2RnDao;


    @Inject
    private ZT_Sp2RnduyuSouseiritu2TyDao sp2RnduyuSouseiritu2TyDao;


    @Inject
    private ZT_Sp2RnduyuSouseiritu3RnDao sp2RnduyuSouseiritu3RnDao;


    @Inject
    private ZT_Sp2RnduyuSouseiritu3TyDao sp2RnduyuSouseiritu3TyDao;


    @Inject
    private ZT_Sp2RnduyuSouseiritu4RnDao sp2RnduyuSouseiritu4RnDao;


    @Inject
    private ZT_Sp2RnduyuSouseiritu4TyDao sp2RnduyuSouseiritu4TyDao;


    @Inject
    private ZT_Sp2RnduyuSouseiritu5RnDao sp2RnduyuSouseiritu5RnDao;


    @Inject
    private ZT_Sp2RnduyuSouseiritu5TyDao sp2RnduyuSouseiritu5TyDao;


    @Inject
    private ZT_Sp2RnduyuSouseiritu6RnDao sp2RnduyuSouseiritu6RnDao;


    @Inject
    private ZT_Sp2RnduyuSouseiritu6TyDao sp2RnduyuSouseiritu6TyDao;


    @Inject
    private ZT_SrKbkSsuRnduHknVKnsyuyuRnDao srKbkSsuRnduHknVKnsyuyuRnDao;


    @Inject
    private ZT_SrKbkSsuRnduHknVKnsyuyuTyDao srKbkSsuRnduHknVKnsyuyuTyDao;


    @Inject
    private ZT_TjHitsyyugkNminusZeroRnDao tjHitsyyugkNminusZeroRnDao;


    @Inject
    private ZT_TjHitsyyugkNminusZeroTyDao tjHitsyyugkNminusZeroTyDao;


    @Inject
    private ZT_TjHitsyyugkNplusOneRnDao tjHitsyyugkNplusOneRnDao;


    @Inject
    private ZT_TjHitsyyugkNplusOneTyDao tjHitsyyugkNplusOneTyDao;


    @Inject
    private ZT_TjHitsyyugkNplusQuartRnDao tjHitsyyugkNplusQuartRnDao;


    @Inject
    private ZT_TjHitsyyugkNplusQuartTyDao tjHitsyyugkNplusQuartTyDao;


    @Inject
    private ZT_TjHitsyyugkNplusTwoRnDao tjHitsyyugkNplusTwoRnDao;


    @Inject
    private ZT_TjHitsyyugkNplusTwoTyDao tjHitsyyugkNplusTwoTyDao;


    @Inject
    private ZT_TjHitsyyugkNplusZeroRnDao tjHitsyyugkNplusZeroRnDao;


    @Inject
    private ZT_TjHitsyyugkNplusZeroTyDao tjHitsyyugkNplusZeroTyDao;


    @Inject
    private ZT_TmttHaitoukinMeisaiRnDao tmttHaitoukinMeisaiRnDao;


    @Inject
    private ZT_TmttHaitoukinMeisaiTyDao tmttHaitoukinMeisaiTyDao;


    @Inject
    private ZT_ZitkAzukarikinSrRendouRnDao zitkAzukarikinSrRendouRnDao;


    @Inject
    private ZT_ZitkAzukarikinSrRendouTyDao zitkAzukarikinSrRendouTyDao;


    ExDBResults<ZT_HoyuuMeisaiTy> getAllHoyuuMeisaiTy(){
        return hoyuuMeisaiTyDao.selectAllZT_HoyuuMeisaiTy();
    }



    ZT_HoyuuMeisaiTy getHoyuuMeisaiTy(Integer pZtysequenceno) {

        return hoyuuMeisaiTyDao.getHoyuuMeisaiTy(pZtysequenceno);
    }


    ExDBResults<ZT_HoyuuMeisaiRn> getAllHoyuuMeisaiRn(){
        return hoyuuMeisaiRnDao.selectAllZT_HoyuuMeisaiRn();
    }



    ZT_HoyuuMeisaiRn getHoyuuMeisaiRn(Integer pZrnsequenceno) {

        return hoyuuMeisaiRnDao.getHoyuuMeisaiRn(pZrnsequenceno);
    }


    ExDBResults<ZT_IdouMeisaiTy> getAllIdouMeisaiTy(){
        return idouMeisaiTyDao.selectAllZT_IdouMeisaiTy();
    }



    ZT_IdouMeisaiTy getIdouMeisaiTy(Integer pZtysequenceno) {

        return idouMeisaiTyDao.getIdouMeisaiTy(pZtysequenceno);
    }


    ExDBResults<ZT_IdouMeisaiRn> getAllIdouMeisaiRn(){
        return idouMeisaiRnDao.selectAllZT_IdouMeisaiRn();
    }



    ZT_IdouMeisaiRn getIdouMeisaiRn(Integer pZrnsequenceno) {

        return idouMeisaiRnDao.getIdouMeisaiRn(pZrnsequenceno);
    }


    ExDBResults<ZT_BikinIdouMeisaiTy> getAllBikinIdouMeisaiTy(){
        return bikinIdouMeisaiTyDao.selectAllZT_BikinIdouMeisaiTy();
    }



    ZT_BikinIdouMeisaiTy getBikinIdouMeisaiTy(Integer pZtysequenceno) {

        return bikinIdouMeisaiTyDao.getBikinIdouMeisaiTy(pZtysequenceno);
    }


    ExDBResults<ZT_BikinIdouMeisaiRn> getAllBikinIdouMeisaiRn(){
        return bikinIdouMeisaiRnDao.selectAllZT_BikinIdouMeisaiRn();
    }



    ZT_BikinIdouMeisaiRn getBikinIdouMeisaiRn(Integer pZrnsequenceno) {

        return bikinIdouMeisaiRnDao.getBikinIdouMeisaiRn(pZrnsequenceno);
    }


    ExDBResults<ZT_Skeiksnbsgetujisr1Ty> getAllSkeiksnbsgetujisr1Ty(){
        return skeiksnbsgetujisr1TyDao.selectAllZT_Skeiksnbsgetujisr1Ty();
    }



    ZT_Skeiksnbsgetujisr1Ty getSkeiksnbsgetujisr1Ty(String pZtyktgysyono) {

        return skeiksnbsgetujisr1TyDao.getSkeiksnbsgetujisr1Ty(pZtyktgysyono);
    }


    ExDBResults<ZT_Skeiksnbsgetujisr1Rn> getAllSkeiksnbsgetujisr1Rn(){
        return skeiksnbsgetujisr1RnDao.selectAllZT_Skeiksnbsgetujisr1Rn();
    }



    ZT_Skeiksnbsgetujisr1Rn getSkeiksnbsgetujisr1Rn(String pZrnktgysyono) {

        return skeiksnbsgetujisr1RnDao.getSkeiksnbsgetujisr1Rn(pZrnktgysyono);
    }


    ExDBResults<ZT_Skeiksnbsgetujisr2Ty> getAllSkeiksnbsgetujisr2Ty(){
        return skeiksnbsgetujisr2TyDao.selectAllZT_Skeiksnbsgetujisr2Ty();
    }



    ZT_Skeiksnbsgetujisr2Ty getSkeiksnbsgetujisr2Ty(String pZtyktgysyono) {

        return skeiksnbsgetujisr2TyDao.getSkeiksnbsgetujisr2Ty(pZtyktgysyono);
    }


    ExDBResults<ZT_Skeiksnbsgetujisr2Rn> getAllSkeiksnbsgetujisr2Rn(){
        return skeiksnbsgetujisr2RnDao.selectAllZT_Skeiksnbsgetujisr2Rn();
    }



    ZT_Skeiksnbsgetujisr2Rn getSkeiksnbsgetujisr2Rn(String pZrnktgysyono) {

        return skeiksnbsgetujisr2RnDao.getSkeiksnbsgetujisr2Rn(pZrnktgysyono);
    }


    ExDBResults<ZT_Skeiksnbsgetujisr3Ty> getAllSkeiksnbsgetujisr3Ty(){
        return skeiksnbsgetujisr3TyDao.selectAllZT_Skeiksnbsgetujisr3Ty();
    }



    ZT_Skeiksnbsgetujisr3Ty getSkeiksnbsgetujisr3Ty(String pZtyktgysyono) {

        return skeiksnbsgetujisr3TyDao.getSkeiksnbsgetujisr3Ty(pZtyktgysyono);
    }


    ExDBResults<ZT_Skeiksnbsgetujisr3Rn> getAllSkeiksnbsgetujisr3Rn(){
        return skeiksnbsgetujisr3RnDao.selectAllZT_Skeiksnbsgetujisr3Rn();
    }



    ZT_Skeiksnbsgetujisr3Rn getSkeiksnbsgetujisr3Rn(String pZrnktgysyono) {

        return skeiksnbsgetujisr3RnDao.getSkeiksnbsgetujisr3Rn(pZrnktgysyono);
    }


    ExDBResults<ZT_Skeiksnbsgetujisr4Ty> getAllSkeiksnbsgetujisr4Ty(){
        return skeiksnbsgetujisr4TyDao.selectAllZT_Skeiksnbsgetujisr4Ty();
    }



    ZT_Skeiksnbsgetujisr4Ty getSkeiksnbsgetujisr4Ty(String pZtyktgysyono) {

        return skeiksnbsgetujisr4TyDao.getSkeiksnbsgetujisr4Ty(pZtyktgysyono);
    }


    ExDBResults<ZT_Skeiksnbsgetujisr4Rn> getAllSkeiksnbsgetujisr4Rn(){
        return skeiksnbsgetujisr4RnDao.selectAllZT_Skeiksnbsgetujisr4Rn();
    }



    ZT_Skeiksnbsgetujisr4Rn getSkeiksnbsgetujisr4Rn(String pZrnktgysyono) {

        return skeiksnbsgetujisr4RnDao.getSkeiksnbsgetujisr4Rn(pZrnktgysyono);
    }


    ExDBResults<ZT_Skeiksnbsgetujisr5Ty> getAllSkeiksnbsgetujisr5Ty(){
        return skeiksnbsgetujisr5TyDao.selectAllZT_Skeiksnbsgetujisr5Ty();
    }



    ZT_Skeiksnbsgetujisr5Ty getSkeiksnbsgetujisr5Ty(String pZtyktgysyono) {

        return skeiksnbsgetujisr5TyDao.getSkeiksnbsgetujisr5Ty(pZtyktgysyono);
    }


    ExDBResults<ZT_Skeiksnbsgetujisr5Rn> getAllSkeiksnbsgetujisr5Rn(){
        return skeiksnbsgetujisr5RnDao.selectAllZT_Skeiksnbsgetujisr5Rn();
    }



    ZT_Skeiksnbsgetujisr5Rn getSkeiksnbsgetujisr5Rn(String pZrnktgysyono) {

        return skeiksnbsgetujisr5RnDao.getSkeiksnbsgetujisr5Rn(pZrnktgysyono);
    }


    ExDBResults<ZT_Skeiksnbsgetujisr6Ty> getAllSkeiksnbsgetujisr6Ty(){
        return skeiksnbsgetujisr6TyDao.selectAllZT_Skeiksnbsgetujisr6Ty();
    }



    ZT_Skeiksnbsgetujisr6Ty getSkeiksnbsgetujisr6Ty(String pZtyktgysyono) {

        return skeiksnbsgetujisr6TyDao.getSkeiksnbsgetujisr6Ty(pZtyktgysyono);
    }


    ExDBResults<ZT_Skeiksnbsgetujisr6Rn> getAllSkeiksnbsgetujisr6Rn(){
        return skeiksnbsgetujisr6RnDao.selectAllZT_Skeiksnbsgetujisr6Rn();
    }



    ZT_Skeiksnbsgetujisr6Rn getSkeiksnbsgetujisr6Rn(String pZtyktgysyono) {

        return skeiksnbsgetujisr6RnDao.getSkeiksnbsgetujisr6Rn(pZtyktgysyono);
    }


    ExDBResults<ZT_SkeisynyptoukeiksnTy> getAllSkeisynyptoukeiksnTy(){
        return skeisynyptoukeiksnTyDao.selectAllZT_SkeisynyptoukeiksnTy();
    }



    ZT_SkeisynyptoukeiksnTy getSkeisynyptoukeiksnTy(Integer pZtysequenceno) {

        return skeisynyptoukeiksnTyDao.getSkeisynyptoukeiksnTy(pZtysequenceno);
    }


    ExDBResults<ZT_SkeisynyptoukeiksnRn> getAllSkeisynyptoukeiksnRn(){
        return skeisynyptoukeiksnRnDao.selectAllZT_SkeisynyptoukeiksnRn();
    }



    ZT_SkeisynyptoukeiksnRn getSkeisynyptoukeiksnRn(Integer pZrnsequenceno) {

        return skeisynyptoukeiksnRnDao.getSkeisynyptoukeiksnRn(pZrnsequenceno);
    }


    ExDBResults<ZT_SkeisynyptoukeirigTy> getAllSkeisynyptoukeirigTy(){
        return skeisynyptoukeirigTyDao.selectAllZT_SkeisynyptoukeirigTy();
    }



    ZT_SkeisynyptoukeirigTy getSkeisynyptoukeirigTy(Integer pZtysequenceno) {

        return skeisynyptoukeirigTyDao.getSkeisynyptoukeirigTy(pZtysequenceno);
    }


    ExDBResults<ZT_SkeisynyptoukeirigRn> getAllSkeisynyptoukeirigRn(){
        return skeisynyptoukeirigRnDao.selectAllZT_SkeisynyptoukeirigRn();
    }



    ZT_SkeisynyptoukeirigRn getSkeisynyptoukeirigRn(Integer pZrnsequenceno) {

        return skeisynyptoukeirigRnDao.getSkeisynyptoukeirigRn(pZrnsequenceno);
    }


    ExDBResults<ZT_KaiykHrSoutougakuTy> getAllKaiykHrSoutougakuTy(){
        return kaiykHrSoutougakuTyDao.selectAllZT_KaiykHrSoutougakuTy();
    }



    ZT_KaiykHrSoutougakuTy getKaiykHrSoutougakuTy(Integer pZtysequenceno) {

        return kaiykHrSoutougakuTyDao.getKaiykHrSoutougakuTy(pZtysequenceno);
    }


    ExDBResults<ZT_KaiykHrSoutougakuRn> getAllKaiykHrSoutougakuRn(){
        return kaiykHrSoutougakuRnDao.selectAllZT_KaiykHrSoutougakuRn();
    }



    ZT_KaiykHrSoutougakuRn getKaiykHrSoutougakuRn(Integer pZrnsequenceno) {

        return kaiykHrSoutougakuRnDao.getKaiykHrSoutougakuRn(pZrnsequenceno);
    }


    ExDBResults<ZT_TjHitsyyugkNplusZeroTy> getAllTjHitsyyugkNplusZeroTy(){
        return tjHitsyyugkNplusZeroTyDao.selectAllZT_TjHitsyyugkNplusZeroTy();
    }



    ZT_TjHitsyyugkNplusZeroTy getTjHitsyyugkNplusZeroTy(Integer pZtysequenceno) {

        return tjHitsyyugkNplusZeroTyDao.getTjHitsyyugkNplusZeroTy(pZtysequenceno);
    }


    ExDBResults<ZT_TjHitsyyugkNplusZeroRn> getAllTjHitsyyugkNplusZeroRn(){
        return tjHitsyyugkNplusZeroRnDao.selectAllZT_TjHitsyyugkNplusZeroRn();
    }



    ZT_TjHitsyyugkNplusZeroRn getTjHitsyyugkNplusZeroRn(Integer pZrnsequenceno) {

        return tjHitsyyugkNplusZeroRnDao.getTjHitsyyugkNplusZeroRn(pZrnsequenceno);
    }


    ExDBResults<ZT_TjHitsyyugkNplusOneTy> getAllTjHitsyyugkNplusOneTy(){
        return tjHitsyyugkNplusOneTyDao.selectAllZT_TjHitsyyugkNplusOneTy();
    }



    ZT_TjHitsyyugkNplusOneTy getTjHitsyyugkNplusOneTy(Integer pZtysequenceno) {

        return tjHitsyyugkNplusOneTyDao.getTjHitsyyugkNplusOneTy(pZtysequenceno);
    }


    ExDBResults<ZT_TjHitsyyugkNplusOneRn> getAllTjHitsyyugkNplusOneRn(){
        return tjHitsyyugkNplusOneRnDao.selectAllZT_TjHitsyyugkNplusOneRn();
    }



    ZT_TjHitsyyugkNplusOneRn getTjHitsyyugkNplusOneRn(Integer pZrnsequenceno) {

        return tjHitsyyugkNplusOneRnDao.getTjHitsyyugkNplusOneRn(pZrnsequenceno);
    }


    ExDBResults<ZT_TjHitsyyugkNplusTwoTy> getAllTjHitsyyugkNplusTwoTy(){
        return tjHitsyyugkNplusTwoTyDao.selectAllZT_TjHitsyyugkNplusTwoTy();
    }



    ZT_TjHitsyyugkNplusTwoTy getTjHitsyyugkNplusTwoTy(Integer pZtysequenceno) {

        return tjHitsyyugkNplusTwoTyDao.getTjHitsyyugkNplusTwoTy(pZtysequenceno);
    }


    ExDBResults<ZT_TjHitsyyugkNplusTwoRn> getAllTjHitsyyugkNplusTwoRn(){
        return tjHitsyyugkNplusTwoRnDao.selectAllZT_TjHitsyyugkNplusTwoRn();
    }



    ZT_TjHitsyyugkNplusTwoRn getTjHitsyyugkNplusTwoRn(Integer pZrnsequenceno) {

        return tjHitsyyugkNplusTwoRnDao.getTjHitsyyugkNplusTwoRn(pZrnsequenceno);
    }


    ExDBResults<ZT_TjHitsyyugkNminusZeroTy> getAllTjHitsyyugkNminusZeroTy(){
        return tjHitsyyugkNminusZeroTyDao.selectAllZT_TjHitsyyugkNminusZeroTy();
    }



    ZT_TjHitsyyugkNminusZeroTy getTjHitsyyugkNminusZeroTy(Integer pZtysequenceno) {

        return tjHitsyyugkNminusZeroTyDao.getTjHitsyyugkNminusZeroTy(pZtysequenceno);
    }


    ExDBResults<ZT_TjHitsyyugkNminusZeroRn> getAllTjHitsyyugkNminusZeroRn(){
        return tjHitsyyugkNminusZeroRnDao.selectAllZT_TjHitsyyugkNminusZeroRn();
    }



    ZT_TjHitsyyugkNminusZeroRn getTjHitsyyugkNminusZeroRn(Integer pZrnsequenceno) {

        return tjHitsyyugkNminusZeroRnDao.getTjHitsyyugkNminusZeroRn(pZrnsequenceno);
    }


    ExDBResults<ZT_TjHitsyyugkNplusQuartTy> getAllTjHitsyyugkNplusQuartTy(){
        return tjHitsyyugkNplusQuartTyDao.selectAllZT_TjHitsyyugkNplusQuartTy();
    }



    ZT_TjHitsyyugkNplusQuartTy getTjHitsyyugkNplusQuartTy(Integer pZtysequenceno) {

        return tjHitsyyugkNplusQuartTyDao.getTjHitsyyugkNplusQuartTy(pZtysequenceno);
    }


    ExDBResults<ZT_TjHitsyyugkNplusQuartRn> getAllTjHitsyyugkNplusQuartRn(){
        return tjHitsyyugkNplusQuartRnDao.selectAllZT_TjHitsyyugkNplusQuartRn();
    }



    ZT_TjHitsyyugkNplusQuartRn getTjHitsyyugkNplusQuartRn(Integer pZrnsequenceno) {

        return tjHitsyyugkNplusQuartRnDao.getTjHitsyyugkNplusQuartRn(pZrnsequenceno);
    }


    ExDBResults<ZT_RisaTjHitNplusZeroTy> getAllRisaTjHitNplusZeroTy(){
        return risaTjHitNplusZeroTyDao.selectAllZT_RisaTjHitNplusZeroTy();
    }



    ZT_RisaTjHitNplusZeroTy getRisaTjHitNplusZeroTy(Integer pZtysequenceno) {

        return risaTjHitNplusZeroTyDao.getRisaTjHitNplusZeroTy(pZtysequenceno);
    }


    ExDBResults<ZT_RisaTjHitNplusZeroRn> getAllRisaTjHitNplusZeroRn(){
        return risaTjHitNplusZeroRnDao.selectAllZT_RisaTjHitNplusZeroRn();
    }



    ZT_RisaTjHitNplusZeroRn getRisaTjHitNplusZeroRn(Integer pZrnsequenceno) {

        return risaTjHitNplusZeroRnDao.getRisaTjHitNplusZeroRn(pZrnsequenceno);
    }


    ExDBResults<ZT_RisaTjHitNminusZeroTy> getAllRisaTjHitNminusZeroTy(){
        return risaTjHitNminusZeroTyDao.selectAllZT_RisaTjHitNminusZeroTy();
    }



    ZT_RisaTjHitNminusZeroTy getRisaTjHitNminusZeroTy(Integer pZtysequenceno) {

        return risaTjHitNminusZeroTyDao.getRisaTjHitNminusZeroTy(pZtysequenceno);
    }


    ExDBResults<ZT_RisaTjHitNminusZeroRn> getAllRisaTjHitNminusZeroRn(){
        return risaTjHitNminusZeroRnDao.selectAllZT_RisaTjHitNminusZeroRn();
    }



    ZT_RisaTjHitNminusZeroRn getRisaTjHitNminusZeroRn(Integer pZrnsequenceno) {

        return risaTjHitNminusZeroRnDao.getRisaTjHitNminusZeroRn(pZrnsequenceno);
    }


    ExDBResults<ZT_RisaTjHitNplusQuartTy> getAllRisaTjHitNplusQuartTy(){
        return risaTjHitNplusQuartTyDao.selectAllZT_RisaTjHitNplusQuartTy();
    }



    ZT_RisaTjHitNplusQuartTy getRisaTjHitNplusQuartTy(Integer pZtysequenceno) {

        return risaTjHitNplusQuartTyDao.getRisaTjHitNplusQuartTy(pZtysequenceno);
    }


    ExDBResults<ZT_RisaTjHitNplusQuartRn> getAllRisaTjHitNplusQuartRn(){
        return risaTjHitNplusQuartRnDao.selectAllZT_RisaTjHitNplusQuartRn();
    }



    ZT_RisaTjHitNplusQuartRn getRisaTjHitNplusQuartRn(Integer pZrnsequenceno) {

        return risaTjHitNplusQuartRnDao.getRisaTjHitNplusQuartRn(pZrnsequenceno);
    }


    ExDBResults<ZT_SbRituRendouTy> getAllSbRituRendouTy(){
        return sbRituRendouTyDao.selectAllZT_SbRituRendouTy();
    }



    ZT_SbRituRendouTy getSbRituRendouTy(String pZtydatakanrino) {

        return sbRituRendouTyDao.getSbRituRendouTy(pZtydatakanrino);
    }


    ExDBResults<ZT_SbRituRendouRn> getAllSbRituRendouRn(){
        return sbRituRendouRnDao.selectAllZT_SbRituRendouRn();
    }



    ZT_SbRituRendouRn getSbRituRendouRn(String pZrndatakanrino) {

        return sbRituRendouRnDao.getSbRituRendouRn(pZrndatakanrino);
    }


    ExDBResults<ZT_SbRituToukeiSeibiRenTy> getAllSbRituToukeiSeibiRenTy(){
        return sbRituToukeiSeibiRenTyDao.selectAllZT_SbRituToukeiSeibiRenTy();
    }



    ZT_SbRituToukeiSeibiRenTy getSbRituToukeiSeibiRenTy(Integer pZtysequenceno) {

        return sbRituToukeiSeibiRenTyDao.getSbRituToukeiSeibiRenTy(pZtysequenceno);
    }


    ExDBResults<ZT_SbRituToukeiSeibiRenRn> getAllSbRituToukeiSeibiRenRn(){
        return sbRituToukeiSeibiRenRnDao.selectAllZT_SbRituToukeiSeibiRenRn();
    }



    ZT_SbRituToukeiSeibiRenRn getSbRituToukeiSeibiRenRn(Integer pZrnsequenceno) {

        return sbRituToukeiSeibiRenRnDao.getSbRituToukeiSeibiRenRn(pZrnsequenceno);
    }


    ExDBResults<ZT_JigyounndsikiTkHoyuuTy> getAllJigyounndsikiTkHoyuuTy(){
        return jigyounndsikiTkHoyuuTyDao.selectAllZT_JigyounndsikiTkHoyuuTy();
    }



    ZT_JigyounndsikiTkHoyuuTy getJigyounndsikiTkHoyuuTy(Integer pZtysequenceno) {

        return jigyounndsikiTkHoyuuTyDao.getJigyounndsikiTkHoyuuTy(pZtysequenceno);
    }


    ExDBResults<ZT_JigyounndsikiTkHoyuuRn> getAllJigyounndsikiTkHoyuuRn(){
        return jigyounndsikiTkHoyuuRnDao.selectAllZT_JigyounndsikiTkHoyuuRn();
    }



    ZT_JigyounndsikiTkHoyuuRn getJigyounndsikiTkHoyuuRn(Integer pZrnsequenceno) {

        return jigyounndsikiTkHoyuuRnDao.getJigyounndsikiTkHoyuuRn(pZrnsequenceno);
    }


    ExDBResults<ZT_KyhknShrJyoukyouRnrkTy> getAllKyhknShrJyoukyouRnrkTy(){
        return kyhknShrJyoukyouRnrkTyDao.selectAllZT_KyhknShrJyoukyouRnrkTy();
    }



    ZT_KyhknShrJyoukyouRnrkTy getKyhknShrJyoukyouRnrkTy(Integer pZtysequenceno) {

        return kyhknShrJyoukyouRnrkTyDao.getKyhknShrJyoukyouRnrkTy(pZtysequenceno);
    }


    ExDBResults<ZT_KyhknShrJyoukyouRnrkRn> getAllKyhknShrJyoukyouRnrkRn(){
        return kyhknShrJyoukyouRnrkRnDao.selectAllZT_KyhknShrJyoukyouRnrkRn();
    }



    ZT_KyhknShrJyoukyouRnrkRn getKyhknShrJyoukyouRnrkRn(Integer pZrnsequenceno) {

        return kyhknShrJyoukyouRnrkRnDao.getKyhknShrJyoukyouRnrkRn(pZrnsequenceno);
    }


    ExDBResults<ZT_GkknHnkuSyrSynypTukiTy> getAllGkknHnkuSyrSynypTukiTy(){
        return gkknHnkuSyrSynypTukiTyDao.selectAllZT_GkknHnkuSyrSynypTukiTy();
    }



    ZT_GkknHnkuSyrSynypTukiTy getGkknHnkuSyrSynypTukiTy(Integer pZtysequenceno) {

        return gkknHnkuSyrSynypTukiTyDao.getGkknHnkuSyrSynypTukiTy(pZtysequenceno);
    }


    ExDBResults<ZT_GkknHnkuSyrSynypTukiRn> getAllGkknHnkuSyrSynypTukiRn(){
        return gkknHnkuSyrSynypTukiRnDao.selectAllZT_GkknHnkuSyrSynypTukiRn();
    }



    ZT_GkknHnkuSyrSynypTukiRn getGkknHnkuSyrSynypTukiRn(Integer pZrnsequenceno) {

        return gkknHnkuSyrSynypTukiRnDao.getGkknHnkuSyrSynypTukiRn(pZrnsequenceno);
    }


    ExDBResults<ZT_Sp2RnduyuSouseiritu1Ty> getAllSp2RnduyuSouseiritu1Ty(){
        return sp2RnduyuSouseiritu1TyDao.selectAllZT_Sp2RnduyuSouseiritu1Ty();
    }



    ZT_Sp2RnduyuSouseiritu1Ty getSp2RnduyuSouseiritu1Ty(String pZtyktgysyono) {

        return sp2RnduyuSouseiritu1TyDao.getSp2RnduyuSouseiritu1Ty(pZtyktgysyono);
    }


    ExDBResults<ZT_Sp2RnduyuSouseiritu1Rn> getAllSp2RnduyuSouseiritu1Rn(){
        return sp2RnduyuSouseiritu1RnDao.selectAllZT_Sp2RnduyuSouseiritu1Rn();
    }



    ZT_Sp2RnduyuSouseiritu1Rn getSp2RnduyuSouseiritu1Rn(String pZrnktgysyono) {

        return sp2RnduyuSouseiritu1RnDao.getSp2RnduyuSouseiritu1Rn(pZrnktgysyono);
    }


    ExDBResults<ZT_Sp2RnduyuSouseiritu2Ty> getAllSp2RnduyuSouseiritu2Ty(){
        return sp2RnduyuSouseiritu2TyDao.selectAllZT_Sp2RnduyuSouseiritu2Ty();
    }



    ZT_Sp2RnduyuSouseiritu2Ty getSp2RnduyuSouseiritu2Ty(String pZtyktgysyono) {

        return sp2RnduyuSouseiritu2TyDao.getSp2RnduyuSouseiritu2Ty(pZtyktgysyono);
    }


    ExDBResults<ZT_Sp2RnduyuSouseiritu2Rn> getAllSp2RnduyuSouseiritu2Rn(){
        return sp2RnduyuSouseiritu2RnDao.selectAllZT_Sp2RnduyuSouseiritu2Rn();
    }



    ZT_Sp2RnduyuSouseiritu2Rn getSp2RnduyuSouseiritu2Rn(String pZrnktgysyono) {

        return sp2RnduyuSouseiritu2RnDao.getSp2RnduyuSouseiritu2Rn(pZrnktgysyono);
    }


    ExDBResults<ZT_Sp2RnduyuSouseiritu3Ty> getAllSp2RnduyuSouseiritu3Ty(){
        return sp2RnduyuSouseiritu3TyDao.selectAllZT_Sp2RnduyuSouseiritu3Ty();
    }



    ZT_Sp2RnduyuSouseiritu3Ty getSp2RnduyuSouseiritu3Ty(String pZtyktgysyono) {

        return sp2RnduyuSouseiritu3TyDao.getSp2RnduyuSouseiritu3Ty(pZtyktgysyono);
    }


    ExDBResults<ZT_Sp2RnduyuSouseiritu3Rn> getAllSp2RnduyuSouseiritu3Rn(){
        return sp2RnduyuSouseiritu3RnDao.selectAllZT_Sp2RnduyuSouseiritu3Rn();
    }



    ZT_Sp2RnduyuSouseiritu3Rn getSp2RnduyuSouseiritu3Rn(String pZrnktgysyono) {

        return sp2RnduyuSouseiritu3RnDao.getSp2RnduyuSouseiritu3Rn(pZrnktgysyono);
    }


    ExDBResults<ZT_Sp2RnduyuSouseiritu4Ty> getAllSp2RnduyuSouseiritu4Ty(){
        return sp2RnduyuSouseiritu4TyDao.selectAllZT_Sp2RnduyuSouseiritu4Ty();
    }



    ZT_Sp2RnduyuSouseiritu4Ty getSp2RnduyuSouseiritu4Ty(String pZtyktgysyono) {

        return sp2RnduyuSouseiritu4TyDao.getSp2RnduyuSouseiritu4Ty(pZtyktgysyono);
    }


    ExDBResults<ZT_Sp2RnduyuSouseiritu4Rn> getAllSp2RnduyuSouseiritu4Rn(){
        return sp2RnduyuSouseiritu4RnDao.selectAllZT_Sp2RnduyuSouseiritu4Rn();
    }



    ZT_Sp2RnduyuSouseiritu4Rn getSp2RnduyuSouseiritu4Rn(String pZrnktgysyono) {

        return sp2RnduyuSouseiritu4RnDao.getSp2RnduyuSouseiritu4Rn(pZrnktgysyono);
    }


    ExDBResults<ZT_Sp2RnduyuSouseiritu5Ty> getAllSp2RnduyuSouseiritu5Ty(){
        return sp2RnduyuSouseiritu5TyDao.selectAllZT_Sp2RnduyuSouseiritu5Ty();
    }



    ZT_Sp2RnduyuSouseiritu5Ty getSp2RnduyuSouseiritu5Ty(String pZtyktgysyono) {

        return sp2RnduyuSouseiritu5TyDao.getSp2RnduyuSouseiritu5Ty(pZtyktgysyono);
    }


    ExDBResults<ZT_Sp2RnduyuSouseiritu5Rn> getAllSp2RnduyuSouseiritu5Rn(){
        return sp2RnduyuSouseiritu5RnDao.selectAllZT_Sp2RnduyuSouseiritu5Rn();
    }



    ZT_Sp2RnduyuSouseiritu5Rn getSp2RnduyuSouseiritu5Rn(String pZrnktgysyono) {

        return sp2RnduyuSouseiritu5RnDao.getSp2RnduyuSouseiritu5Rn(pZrnktgysyono);
    }


    ExDBResults<ZT_Sp2RnduyuSouseiritu6Ty> getAllSp2RnduyuSouseiritu6Ty(){
        return sp2RnduyuSouseiritu6TyDao.selectAllZT_Sp2RnduyuSouseiritu6Ty();
    }



    ZT_Sp2RnduyuSouseiritu6Ty getSp2RnduyuSouseiritu6Ty(String pZtyktgysyono) {

        return sp2RnduyuSouseiritu6TyDao.getSp2RnduyuSouseiritu6Ty(pZtyktgysyono);
    }


    ExDBResults<ZT_Sp2RnduyuSouseiritu6Rn> getAllSp2RnduyuSouseiritu6Rn(){
        return sp2RnduyuSouseiritu6RnDao.selectAllZT_Sp2RnduyuSouseiritu6Rn();
    }



    ZT_Sp2RnduyuSouseiritu6Rn getSp2RnduyuSouseiritu6Rn(String pZrnktgysyono) {

        return sp2RnduyuSouseiritu6RnDao.getSp2RnduyuSouseiritu6Rn(pZrnktgysyono);
    }


    ExDBResults<ZT_AlmNnknHyuTy> getAllAlmNnknHyuTy(){
        return almNnknHyuTyDao.selectAllZT_AlmNnknHyuTy();
    }



    ZT_AlmNnknHyuTy getAlmNnknHyuTy(String pZtynksyousyono) {

        return almNnknHyuTyDao.getAlmNnknHyuTy(pZtynksyousyono);
    }


    ExDBResults<ZT_AlmNnknHyuRn> getAllAlmNnknHyuRn(){
        return almNnknHyuRnDao.selectAllZT_AlmNnknHyuRn();
    }



    ZT_AlmNnknHyuRn getAlmNnknHyuRn(String pZrnnksyousyono) {

        return almNnknHyuRnDao.getAlmNnknHyuRn(pZrnnksyousyono);
    }


    ExDBResults<ZT_OuNnknShrTy> getAllOuNnknShrTy(){
        return ouNnknShrTyDao.selectAllZT_OuNnknShrTy();
    }



    ZT_OuNnknShrTy getOuNnknShrTy(Integer pZtysequenceno) {

        return ouNnknShrTyDao.getOuNnknShrTy(pZtysequenceno);
    }


    ExDBResults<ZT_OuNnknShrRn> getAllOuNnknShrRn(){
        return ouNnknShrRnDao.selectAllZT_OuNnknShrRn();
    }



    ZT_OuNnknShrRn getOuNnknShrRn(Integer pZrnsequenceno) {

        return ouNnknShrRnDao.getOuNnknShrRn(pZrnsequenceno);
    }


    ExDBResults<ZT_NkIktHriTy> getAllNkIktHriTy(){
        return nkIktHriTyDao.selectAllZT_NkIktHriTy();
    }



    ZT_NkIktHriTy getNkIktHriTy(String pZtydatakanrino) {

        return nkIktHriTyDao.getNkIktHriTy(pZtydatakanrino);
    }


    ExDBResults<ZT_NkIktHriRn> getAllNkIktHriRn(){
        return nkIktHriRnDao.selectAllZT_NkIktHriRn();
    }



    ZT_NkIktHriRn getNkIktHriRn(String pZrndatakanrino) {

        return nkIktHriRnDao.getNkIktHriRn(pZrndatakanrino);
    }


    ExDBResults<ZT_NkGensiHySgTy> getAllNkGensiHySgTy(){
        return nkGensiHySgTyDao.selectAllZT_NkGensiHySgTy();
    }



    ZT_NkGensiHySgTy getNkGensiHySgTy(Integer pZtysequenceno) {

        return nkGensiHySgTyDao.getNkGensiHySgTy(pZtysequenceno);
    }


    ExDBResults<ZT_NkGensiRigTy> getAllNkGensiRigTy(){
        return nkGensiRigTyDao.selectAllZT_NkGensiRigTy();
    }



    ZT_NkGensiRigTy getNkGensiRigTy(Integer pZtysequenceno) {

        return nkGensiRigTyDao.getNkGensiRigTy(pZtysequenceno);
    }


    ExDBResults<ZT_NkGensiKtyTy> getAllNkGensiKtyTy(){
        return nkGensiKtyTyDao.selectAllZT_NkGensiKtyTy();
    }



    ZT_NkGensiKtyTy getNkGensiKtyTy(Integer pZtysequenceno) {

        return nkGensiKtyTyDao.getNkGensiKtyTy(pZtysequenceno);
    }


    ExDBResults<ZT_NkGensiHySgRn> getAllNkGensiHySgRn(){
        return nkGensiHySgRnDao.selectAllZT_NkGensiHySgRn();
    }



    ZT_NkGensiHySgRn getNkGensiHySgRn(Integer pZrnsequenceno) {

        return nkGensiHySgRnDao.getNkGensiHySgRn(pZrnsequenceno);
    }


    ExDBResults<ZT_NkGensiRigRn> getAllNkGensiRigRn(){
        return nkGensiRigRnDao.selectAllZT_NkGensiRigRn();
    }



    ZT_NkGensiRigRn getNkGensiRigRn(Integer pZrnsequenceno) {

        return nkGensiRigRnDao.getNkGensiRigRn(pZrnsequenceno);
    }


    ExDBResults<ZT_NkGensiKtyRn> getAllNkGensiKtyRn(){
        return nkGensiKtyRnDao.selectAllZT_NkGensiKtyRn();
    }



    ZT_NkGensiKtyRn getNkGensiKtyRn(Integer pZrnsequenceno) {

        return nkGensiKtyRnDao.getNkGensiKtyRn(pZrnsequenceno);
    }


    ExDBResults<ZT_NkToukeiHySgTy> getAllNkToukeiHySgTy(){
        return nkToukeiHySgTyDao.selectAllZT_NkToukeiHySgTy();
    }



    ZT_NkToukeiHySgTy getNkToukeiHySgTy(Integer pZtysequenceno) {

        return nkToukeiHySgTyDao.getNkToukeiHySgTy(pZtysequenceno);
    }


    ExDBResults<ZT_NkToukeiRigTy> getAllNkToukeiRigTy(){
        return nkToukeiRigTyDao.selectAllZT_NkToukeiRigTy();
    }



    ZT_NkToukeiRigTy getNkToukeiRigTy(Integer pZtysequenceno) {

        return nkToukeiRigTyDao.getNkToukeiRigTy(pZtysequenceno);
    }


    ExDBResults<ZT_NkToukeiKtyTy> getAllNkToukeiKtyTy(){
        return nkToukeiKtyTyDao.selectAllZT_NkToukeiKtyTy();
    }



    ZT_NkToukeiKtyTy getNkToukeiKtyTy(Integer pZtysequenceno) {

        return nkToukeiKtyTyDao.getNkToukeiKtyTy(pZtysequenceno);
    }


    ExDBResults<ZT_NkToukeiHySgRn> getAllNkToukeiHySgRn(){
        return nkToukeiHySgRnDao.selectAllZT_NkToukeiHySgRn();
    }



    ZT_NkToukeiHySgRn getNkToukeiHySgRn(Integer pZrnsequenceno) {

        return nkToukeiHySgRnDao.getNkToukeiHySgRn(pZrnsequenceno);
    }


    ExDBResults<ZT_NkToukeiRigRn> getAllNkToukeiRigRn(){
        return nkToukeiRigRnDao.selectAllZT_NkToukeiRigRn();
    }



    ZT_NkToukeiRigRn getNkToukeiRigRn(Integer pZrnsequenceno) {

        return nkToukeiRigRnDao.getNkToukeiRigRn(pZrnsequenceno);
    }


    ExDBResults<ZT_NkToukeiKtyRn> getAllNkToukeiKtyRn(){
        return nkToukeiKtyRnDao.selectAllZT_NkToukeiKtyRn();
    }



    ZT_NkToukeiKtyRn getNkToukeiKtyRn(Integer pZrnsequenceno) {

        return nkToukeiKtyRnDao.getNkToukeiKtyRn(pZrnsequenceno);
    }


    ExDBResults<ZT_NkHitRigTy> getAllNkHitRigTy(){
        return nkHitRigTyDao.selectAllZT_NkHitRigTy();
    }



    ZT_NkHitRigTy getNkHitRigTy(String pZtynksyousyono) {

        return nkHitRigTyDao.getNkHitRigTy(pZtynksyousyono);
    }


    ExDBResults<ZT_NkHitKtyTy> getAllNkHitKtyTy(){
        return nkHitKtyTyDao.selectAllZT_NkHitKtyTy();
    }



    ZT_NkHitKtyTy getNkHitKtyTy(String pZtynksyousyono) {

        return nkHitKtyTyDao.getNkHitKtyTy(pZtynksyousyono);
    }


    ExDBResults<ZT_NkHitKsnTy> getAllNkHitKsnTy(){
        return nkHitKsnTyDao.selectAllZT_NkHitKsnTy();
    }



    ZT_NkHitKsnTy getNkHitKsnTy(String pZtynksyousyono) {

        return nkHitKsnTyDao.getNkHitKsnTy(pZtynksyousyono);
    }


    ExDBResults<ZT_NkHitRigRn> getAllNkHitRigRn(){
        return nkHitRigRnDao.selectAllZT_NkHitRigRn();
    }



    ZT_NkHitRigRn getNkHitRigRn(String pZrnnksyousyono) {

        return nkHitRigRnDao.getNkHitRigRn(pZrnnksyousyono);
    }


    ExDBResults<ZT_NkHitKtyRn> getAllNkHitKtyRn(){
        return nkHitKtyRnDao.selectAllZT_NkHitKtyRn();
    }



    ZT_NkHitKtyRn getNkHitKtyRn(String pZrnnksyousyono) {

        return nkHitKtyRnDao.getNkHitKtyRn(pZrnnksyousyono);
    }


    ExDBResults<ZT_NkHitKsnRn> getAllNkHitKsnRn(){
        return nkHitKsnRnDao.selectAllZT_NkHitKsnRn();
    }



    ZT_NkHitKsnRn getNkHitKsnRn(String pZrnnksyousyono) {

        return nkHitKsnRnDao.getNkHitKsnRn(pZrnnksyousyono);
    }


    ExDBResults<ZT_NkHitAddInfoTy> getAllNkHitAddInfoTy(){
        return nkHitAddInfoTyDao.selectAllZT_NkHitAddInfoTy();
    }



    ZT_NkHitAddInfoTy getNkHitAddInfoTy(String pZtynksyousyono) {

        return nkHitAddInfoTyDao.getNkHitAddInfoTy(pZtynksyousyono);
    }


    ExDBResults<ZT_NkHitAddInfoRn> getAllNkHitAddInfoRn(){
        return nkHitAddInfoRnDao.selectAllZT_NkHitAddInfoRn();
    }



    ZT_NkHitAddInfoRn getNkHitAddInfoRn(String pZrnnksyousyono) {

        return nkHitAddInfoRnDao.getNkHitAddInfoRn(pZrnnksyousyono);
    }


    ExDBResults<ZT_NkBikinTy> getAllNkBikinTy(){
        return nkBikinTyDao.selectAllZT_NkBikinTy();
    }



    ZT_NkBikinTy getNkBikinTy(String pZtynksyousyono, String pZtyshiharaihasseiymd) {

        return nkBikinTyDao.getNkBikinTy(pZtynksyousyono, pZtyshiharaihasseiymd);
    }


    ExDBResults<ZT_NkBikinRn> getAllNkBikinRn(){
        return nkBikinRnDao.selectAllZT_NkBikinRn();
    }



    ZT_NkBikinRn getNkBikinRn(String pZrnnksyousyono, String pZrnshiharaihasseiymd) {

        return nkBikinRnDao.getNkBikinRn(pZrnnksyousyono, pZrnshiharaihasseiymd);
    }


    ExDBResults<ZT_SkKsnKaikeiTorihikiTy> getAllSkKsnKaikeiTorihikiTy(){
        return skKsnKaikeiTorihikiTyDao.selectAllZT_SkKsnKaikeiTorihikiTy();
    }



    ZT_SkKsnKaikeiTorihikiTy getSkKsnKaikeiTorihikiTy(String pZtytorihikiymd, String pZtytorihikinon7, String pZtytaisyakukbnn, String pZtykanjyoukamokucdn
        , String pZtysuitoubumon, String pZtytekiyoucd) {

        return skKsnKaikeiTorihikiTyDao.getSkKsnKaikeiTorihikiTy(pZtytorihikiymd, pZtytorihikinon7, pZtytaisyakukbnn, pZtykanjyoukamokucdn
            , pZtysuitoubumon, pZtytekiyoucd);
    }


    ExDBResults<ZT_SkKsnKaikeiTorihikiRn> getAllSkKsnKaikeiTorihikiRn(){
        return skKsnKaikeiTorihikiRnDao.selectAllZT_SkKsnKaikeiTorihikiRn();
    }



    ZT_SkKsnKaikeiTorihikiRn getSkKsnKaikeiTorihikiRn(String pZrntorihikiymd, String pZrntorihikinon7, String pZrntaisyakukbnn, String pZrnkanjyoukamokucdn
        , String pZrnsuitoubumon, String pZrntekiyoucd) {

        return skKsnKaikeiTorihikiRnDao.getSkKsnKaikeiTorihikiRn(pZrntorihikiymd, pZrntorihikinon7, pZrntaisyakukbnn, pZrnkanjyoukamokucdn
            , pZrnsuitoubumon, pZrntekiyoucd);
    }


    ExDBResults<ZT_SkKsnKubunKeiriTy> getAllSkKsnKubunKeiriTy(){
        return skKsnKubunKeiriTyDao.selectAllZT_SkKsnKubunKeiriTy();
    }



    ZT_SkKsnKubunKeiriTy getSkKsnKubunKeiriTy(String pZtytorihikiymd, String pZtytorihikinon7, String pZtytaisyakukbnn, String pZtykanjyoukamokucdn
        , String pZtysuitoubumoncd, String pZtykizokusegment, String pZtyaitesegment) {

        return skKsnKubunKeiriTyDao.getSkKsnKubunKeiriTy(pZtytorihikiymd, pZtytorihikinon7, pZtytaisyakukbnn, pZtykanjyoukamokucdn
            , pZtysuitoubumoncd, pZtykizokusegment, pZtyaitesegment);
    }


    ExDBResults<ZT_SkKsnKubunKeiriRn> getAllSkKsnKubunKeiriRn(){
        return skKsnKubunKeiriRnDao.selectAllZT_SkKsnKubunKeiriRn();
    }



    ZT_SkKsnKubunKeiriRn getSkKsnKubunKeiriRn(String pZrntorihikiymd, String pZrntorihikinon7, String pZrntaisyakukbnn, String pZrnkanjyoukamokucdn
        , String pZrnsuitoubumoncd, String pZrnkizokusegment, String pZrnaitesegment) {

        return skKsnKubunKeiriRnDao.getSkKsnKubunKeiriRn(pZrntorihikiymd, pZrntorihikinon7, pZrntaisyakukbnn, pZrnkanjyoukamokucdn
            , pZrnsuitoubumoncd, pZrnkizokusegment, pZrnaitesegment);
    }


    ExDBResults<ZT_SkKsnHurikaeTy> getAllSkKsnHurikaeTy(){
        return skKsnHurikaeTyDao.selectAllZT_SkKsnHurikaeTy();
    }



    ZT_SkKsnHurikaeTy getSkKsnHurikaeTy(String pZtytorihikinoc8, String pZtytorihikinoedano, String pZtytorihikiymdgengokbn, String pZtytorihikinen
        , String pZtytorihikituki, String pZtytorihikibi) {

        return skKsnHurikaeTyDao.getSkKsnHurikaeTy(pZtytorihikinoc8, pZtytorihikinoedano, pZtytorihikiymdgengokbn, pZtytorihikinen
            , pZtytorihikituki, pZtytorihikibi);
    }


    ExDBResults<ZT_SkKsnHurikaeHikaeTy> getAllSkKsnHurikaeHikaeTy(){
        return skKsnHurikaeHikaeTyDao.selectAllZT_SkKsnHurikaeHikaeTy();
    }



    ZT_SkKsnHurikaeHikaeTy getSkKsnHurikaeHikaeTy(String pZtytorihikinoc8, String pZtytorihikinoedano, String pZtytorihikiymdgengokbn, String pZtytorihikinen
        , String pZtytorihikituki, String pZtytorihikibi) {

        return skKsnHurikaeHikaeTyDao.getSkKsnHurikaeHikaeTy(pZtytorihikinoc8, pZtytorihikinoedano, pZtytorihikiymdgengokbn, pZtytorihikinen
            , pZtytorihikituki, pZtytorihikibi);
    }


    ExDBResults<ZT_SkKsnHurikaeRn> getAllSkKsnHurikaeRn(){
        return skKsnHurikaeRnDao.selectAllZT_SkKsnHurikaeRn();
    }



    ZT_SkKsnHurikaeRn getSkKsnHurikaeRn(String pZrntorihikinoc8, String pZrntorihikinoedano, String pZrntorihikiymdgengokbn, String pZrntorihikinen
        , String pZrntorihikituki, String pZrntorihikibi) {

        return skKsnHurikaeRnDao.getSkKsnHurikaeRn(pZrntorihikinoc8, pZrntorihikinoedano, pZrntorihikiymdgengokbn, pZrntorihikinen
            , pZrntorihikituki, pZrntorihikibi);
    }


    ExDBResults<ZT_SkKsnHurikaeHikaeRn> getAllSkKsnHurikaeHikaeRn(){
        return skKsnHurikaeHikaeRnDao.selectAllZT_SkKsnHurikaeHikaeRn();
    }



    ZT_SkKsnHurikaeHikaeRn getSkKsnHurikaeHikaeRn(String pZrntorihikinoc8, String pZrntorihikinoedano, String pZrntorihikiymdgengokbn, String pZrntorihikinen
        , String pZrntorihikituki, String pZrntorihikibi) {

        return skKsnHurikaeHikaeRnDao.getSkKsnHurikaeHikaeRn(pZrntorihikinoc8, pZrntorihikinoedano, pZrntorihikiymdgengokbn, pZrntorihikinen
            , pZrntorihikituki, pZrntorihikibi);
    }



    ExDBResults<ZT_SrKbkSsuRnduHknVKnsyuyuTy> getAllSrKbkSsuRnduHknVKnsyuyuTy(){
        return srKbkSsuRnduHknVKnsyuyuTyDao.selectAllZT_SrKbkSsuRnduHknVKnsyuyuTy();
    }



    ZT_SrKbkSsuRnduHknVKnsyuyuTy getSrKbkSsuRnduHknVKnsyuyuTy(Integer pZtysequenceno) {

        return srKbkSsuRnduHknVKnsyuyuTyDao.getSrKbkSsuRnduHknVKnsyuyuTy(pZtysequenceno);
    }


    ExDBResults<ZT_SrKbkSsuRnduHknVKnsyuyuRn> getAllSrKbkSsuRnduHknVKnsyuyuRn(){
        return srKbkSsuRnduHknVKnsyuyuRnDao.selectAllZT_SrKbkSsuRnduHknVKnsyuyuRn();
    }



    ZT_SrKbkSsuRnduHknVKnsyuyuRn getSrKbkSsuRnduHknVKnsyuyuRn(Integer pZrnsequenceno) {

        return srKbkSsuRnduHknVKnsyuyuRnDao.getSrKbkSsuRnduHknVKnsyuyuRn(pZrnsequenceno);
    }


    ExDBResults<ZT_KsnKbkSsuRnduHknJigyohiTy> getAllKsnKbkSsuRnduHknJigyohiTy(){
        return ksnKbkSsuRnduHknJigyohiTyDao.selectAllZT_KsnKbkSsuRnduHknJigyohiTy();
    }



    ZT_KsnKbkSsuRnduHknJigyohiTy getKsnKbkSsuRnduHknJigyohiTy(Integer pZtysequenceno) {

        return ksnKbkSsuRnduHknJigyohiTyDao.getKsnKbkSsuRnduHknJigyohiTy(pZtysequenceno);
    }


    ExDBResults<ZT_KsnKbkSsuRnduHknJigyohiRn> getAllKsnKbkSsuRnduHknJigyohiRn(){
        return ksnKbkSsuRnduHknJigyohiRnDao.selectAllZT_KsnKbkSsuRnduHknJigyohiRn();
    }



    ZT_KsnKbkSsuRnduHknJigyohiRn getKsnKbkSsuRnduHknJigyohiRn(Integer pZrnsequenceno) {

        return ksnKbkSsuRnduHknJigyohiRnDao.getKsnKbkSsuRnduHknJigyohiRn(pZrnsequenceno);
    }


    ExDBResults<ZT_KbkSsuRnduHknKimatuVTy> getAllKbkSsuRnduHknKimatuVTy(){
        return kbkSsuRnduHknKimatuVTyDao.selectAllZT_KbkSsuRnduHknKimatuVTy();
    }



    ZT_KbkSsuRnduHknKimatuVTy getKbkSsuRnduHknKimatuVTy(Integer pZtysequenceno) {

        return kbkSsuRnduHknKimatuVTyDao.getKbkSsuRnduHknKimatuVTy(pZtysequenceno);
    }


    ExDBResults<ZT_KbkSsuRnduHknKimatuVRn> getAllKbkSsuRnduHknKimatuVRn(){
        return kbkSsuRnduHknKimatuVRnDao.selectAllZT_KbkSsuRnduHknKimatuVRn();
    }



    ZT_KbkSsuRnduHknKimatuVRn getKbkSsuRnduHknKimatuVRn(Integer pZrnsequenceno) {

        return kbkSsuRnduHknKimatuVRnDao.getKbkSsuRnduHknKimatuVRn(pZrnsequenceno);
    }


    ExDBResults<ZT_KbkSsuRnduHknJigyohiTy> getAllKbkSsuRnduHknJigyohiTy(){
        return kbkSsuRnduHknJigyohiTyDao.selectAllZT_KbkSsuRnduHknJigyohiTy();
    }



    ZT_KbkSsuRnduHknJigyohiTy getKbkSsuRnduHknJigyohiTy(Integer pZtysequenceno) {

        return kbkSsuRnduHknJigyohiTyDao.getKbkSsuRnduHknJigyohiTy(pZtysequenceno);
    }


    ExDBResults<ZT_KbkSsuRnduHknJigyohiRn> getAllKbkSsuRnduHknJigyohiRn(){
        return kbkSsuRnduHknJigyohiRnDao.selectAllZT_KbkSsuRnduHknJigyohiRn();
    }



    ZT_KbkSsuRnduHknJigyohiRn getKbkSsuRnduHknJigyohiRn(Integer pZrnsequenceno) {

        return kbkSsuRnduHknJigyohiRnDao.getKbkSsuRnduHknJigyohiRn(pZrnsequenceno);
    }


    ExDBResults<ZT_KbkSsuRnduHknIdouVTy> getAllKbkSsuRnduHknIdouVTy(){
        return kbkSsuRnduHknIdouVTyDao.selectAllZT_KbkSsuRnduHknIdouVTy();
    }



    ZT_KbkSsuRnduHknIdouVTy getKbkSsuRnduHknIdouVTy(Integer pZtysequenceno) {

        return kbkSsuRnduHknIdouVTyDao.getKbkSsuRnduHknIdouVTy(pZtysequenceno);
    }


    ExDBResults<ZT_KbkSsuRnduHknIdouVRn> getAllKbkSsuRnduHknIdouVRn(){
        return kbkSsuRnduHknIdouVRnDao.selectAllZT_KbkSsuRnduHknIdouVRn();
    }



    ZT_KbkSsuRnduHknIdouVRn getKbkSsuRnduHknIdouVRn(Integer pZrnsequenceno) {

        return kbkSsuRnduHknIdouVRnDao.getKbkSsuRnduHknIdouVRn(pZrnsequenceno);
    }


    ExDBResults<ZT_RrtHndugtHknJigyohiRn> getAllRrtHndugtHknJigyohiRn(){
        return rrtHndugtHknJigyohiRnDao.selectAllZT_RrtHndugtHknJigyohiRn();
    }



    ZT_RrtHndugtHknJigyohiRn getRrtHndugtHknJigyohiRn(Integer pZrnsequenceno) {

        return rrtHndugtHknJigyohiRnDao.getRrtHndugtHknJigyohiRn(pZrnsequenceno);
    }


    ExDBResults<ZT_RrtHndugtHknJigyohiTy> getAllRrtHndugtHknJigyohiTy(){
        return rrtHndugtHknJigyohiTyDao.selectAllZT_RrtHndugtHknJigyohiTy();
    }



    ZT_RrtHndugtHknJigyohiTy getRrtHndugtHknJigyohiTy(Integer pZtysequenceno) {

        return rrtHndugtHknJigyohiTyDao.getRrtHndugtHknJigyohiTy(pZtysequenceno);
    }


    ExDBResults<ZT_RrtHndugtHknKsnJigyohiRn> getAllRrtHndugtHknKsnJigyohiRn(){
        return rrtHndugtHknKsnJigyohiRnDao.selectAllZT_RrtHndugtHknKsnJigyohiRn();
    }



    ZT_RrtHndugtHknKsnJigyohiRn getRrtHndugtHknKsnJigyohiRn(Integer pZrnsequenceno) {

        return rrtHndugtHknKsnJigyohiRnDao.getRrtHndugtHknKsnJigyohiRn(pZrnsequenceno);
    }


    ExDBResults<ZT_RrtHndugtHknKsnJigyohiTy> getAllRrtHndugtHknKsnJigyohiTy(){
        return rrtHndugtHknKsnJigyohiTyDao.selectAllZT_RrtHndugtHknKsnJigyohiTy();
    }



    ZT_RrtHndugtHknKsnJigyohiTy getRrtHndugtHknKsnJigyohiTy(Integer pZtysequenceno) {

        return rrtHndugtHknKsnJigyohiTyDao.getRrtHndugtHknKsnJigyohiTy(pZtysequenceno);
    }


    ExDBResults<ZT_RrtHndugtHknVKnsyuyuRn> getAllRrtHndugtHknVKnsyuyuRn(){
        return rrtHndugtHknVKnsyuyuRnDao.selectAllZT_RrtHndugtHknVKnsyuyuRn();
    }



    ZT_RrtHndugtHknVKnsyuyuRn getRrtHndugtHknVKnsyuyuRn(Integer pZrnsequenceno) {

        return rrtHndugtHknVKnsyuyuRnDao.getRrtHndugtHknVKnsyuyuRn(pZrnsequenceno);
    }


    ExDBResults<ZT_RrtHndugtHknVKnsyuyuTy> getAllRrtHndugtHknVKnsyuyuTy(){
        return rrtHndugtHknVKnsyuyuTyDao.selectAllZT_RrtHndugtHknVKnsyuyuTy();
    }



    ZT_RrtHndugtHknVKnsyuyuTy getRrtHndugtHknVKnsyuyuTy(Integer pZtysequenceno) {

        return rrtHndugtHknVKnsyuyuTyDao.getRrtHndugtHknVKnsyuyuTy(pZtysequenceno);
    }


    ExDBResults<ZT_ZitkAzukarikinSrRendouRn> getAllZitkAzukarikinSrRendouRn(){
        return zitkAzukarikinSrRendouRnDao.selectAllZT_ZitkAzukarikinSrRendouRn();
    }



    ZT_ZitkAzukarikinSrRendouRn getZitkAzukarikinSrRendouRn(Integer pZrnsequenceno) {

        return zitkAzukarikinSrRendouRnDao.getZitkAzukarikinSrRendouRn(pZrnsequenceno);
    }


    ExDBResults<ZT_ZitkAzukarikinSrRendouTy> getAllZitkAzukarikinSrRendouTy(){
        return zitkAzukarikinSrRendouTyDao.selectAllZT_ZitkAzukarikinSrRendouTy();
    }



    ZT_ZitkAzukarikinSrRendouTy getZitkAzukarikinSrRendouTy(Integer pZtysequenceno) {

        return zitkAzukarikinSrRendouTyDao.getZitkAzukarikinSrRendouTy(pZtysequenceno);
    }


    ExDBResults<ZT_TmttHaitoukinMeisaiRn> getAllTmttHaitoukinMeisaiRn(){
        return tmttHaitoukinMeisaiRnDao.selectAllZT_TmttHaitoukinMeisaiRn();
    }



    ZT_TmttHaitoukinMeisaiRn getTmttHaitoukinMeisaiRn(Integer pZrnsequenceno) {

        return tmttHaitoukinMeisaiRnDao.getTmttHaitoukinMeisaiRn(pZrnsequenceno);
    }


    ExDBResults<ZT_TmttHaitoukinMeisaiTy> getAllTmttHaitoukinMeisaiTy(){
        return tmttHaitoukinMeisaiTyDao.selectAllZT_TmttHaitoukinMeisaiTy();
    }



    ZT_TmttHaitoukinMeisaiTy getTmttHaitoukinMeisaiTy(Integer pZtysequenceno) {

        return tmttHaitoukinMeisaiTyDao.getTmttHaitoukinMeisaiTy(pZtysequenceno);
    }


    ExDBResults<ZT_KariwariateHtkinMeisaiRn> getAllKariwariateHtkinMeisaiRn(){
        return kariwariateHtkinMeisaiRnDao.selectAllZT_KariwariateHtkinMeisaiRn();
    }



    ZT_KariwariateHtkinMeisaiRn getKariwariateHtkinMeisaiRn(Integer pZrnsequenceno) {

        return kariwariateHtkinMeisaiRnDao.getKariwariateHtkinMeisaiRn(pZrnsequenceno);
    }


    ExDBResults<ZT_KariwariateHtkinMeisaiTy> getAllKariwariateHtkinMeisaiTy(){
        return kariwariateHtkinMeisaiTyDao.selectAllZT_KariwariateHtkinMeisaiTy();
    }



    ZT_KariwariateHtkinMeisaiTy getKariwariateHtkinMeisaiTy(Integer pZtysequenceno) {

        return kariwariateHtkinMeisaiTyDao.getKariwariateHtkinMeisaiTy(pZtysequenceno);
    }


    ExDBResults<ZT_BikinKeiyakuSeisandRn> getAllBikinKeiyakuSeisandRn(){
        return bikinKeiyakuSeisandRnDao.selectAllZT_BikinKeiyakuSeisandRn();
    }



    ZT_BikinKeiyakuSeisandRn getBikinKeiyakuSeisandRn(Integer pZrnsequenceno) {

        return bikinKeiyakuSeisandRnDao.getBikinKeiyakuSeisandRn(pZrnsequenceno);
    }


    ExDBResults<ZT_BikinKeiyakuSeisandTy> getAllBikinKeiyakuSeisandTy(){
        return bikinKeiyakuSeisandTyDao.selectAllZT_BikinKeiyakuSeisandTy();
    }



    ZT_BikinKeiyakuSeisandTy getBikinKeiyakuSeisandTy(Integer pZtysequenceno) {

        return bikinKeiyakuSeisandTyDao.getBikinKeiyakuSeisandTy(pZtysequenceno);
    }



    ExDBResults<ZT_DshrToukeiRn> getAllDshrToukeiRn(){
        return dshrToukeiRnDao.selectAllZT_DshrToukeiRn();
    }



    ZT_DshrToukeiRn getDshrToukeiRn(Integer pZrnsequenceno) {

        return dshrToukeiRnDao.getDshrToukeiRn(pZrnsequenceno);
    }


    ExDBResults<ZT_DshrToukeiTy> getAllDshrToukeiTy(){
        return dshrToukeiTyDao.selectAllZT_DshrToukeiTy();
    }



    ZT_DshrToukeiTy getDshrToukeiTy(Integer pZtysequenceno) {

        return dshrToukeiTyDao.getDshrToukeiTy(pZtysequenceno);
    }


    ExDBResults<ZT_DshrToukeiLoadingRn> getAllDshrToukeiLoadingRn(){
        return dshrToukeiLoadingRnDao.selectAllZT_DshrToukeiLoadingRn();
    }



    ZT_DshrToukeiLoadingRn getDshrToukeiLoadingRn(Integer pZrnsequenceno) {

        return dshrToukeiLoadingRnDao.getDshrToukeiLoadingRn(pZrnsequenceno);
    }


    ExDBResults<ZT_DshrToukeiLoadingTy> getAllDshrToukeiLoadingTy(){
        return dshrToukeiLoadingTyDao.selectAllZT_DshrToukeiLoadingTy();
    }


    ZT_DshrToukeiLoadingTy getDshrToukeiLoadingTy(Integer pZtysequenceno) {

        return dshrToukeiLoadingTyDao.getDshrToukeiLoadingTy(pZtysequenceno);
    }


    ExDBResults<ZT_RayVKnsyuyuTy> getAllRayVKnsyuyuTy(){
        return rayVKnsyuyuTyDao.selectAllZT_RayVKnsyuyuTy();
    }



    ZT_RayVKnsyuyuTy getRayVKnsyuyuTy(Integer pZtysequenceno) {

        return rayVKnsyuyuTyDao.getRayVKnsyuyuTy(pZtysequenceno);
    }


    ExDBResults<ZT_RayVKnsyuyuRn> getAllRayVKnsyuyuRn(){
        return rayVKnsyuyuRnDao.selectAllZT_RayVKnsyuyuRn();
    }



    ZT_RayVKnsyuyuRn getRayVKnsyuyuRn(Integer pZrnsequenceno) {

        return rayVKnsyuyuRnDao.getRayVKnsyuyuRn(pZrnsequenceno);
    }


    ExDBResults<ZT_RayKimatuVTy> getAllRayKimatuVTy(){
        return rayKimatuVTyDao.selectAllZT_RayKimatuVTy();
    }



    ZT_RayKimatuVTy getRayKimatuVTy(Integer pZtysequenceno) {

        return rayKimatuVTyDao.getRayKimatuVTy(pZtysequenceno);
    }


    ExDBResults<ZT_RayKimatuVRn> getAllRayKimatuVRn(){
        return rayKimatuVRnDao.selectAllZT_RayKimatuVRn();
    }



    ZT_RayKimatuVRn getRayKimatuVRn(Integer pZrnsequenceno) {

        return rayKimatuVRnDao.getRayKimatuVRn(pZrnsequenceno);
    }


    ExDBResults<ZT_RayIdouVTy> getAllRayIdouVTy(){
        return rayIdouVTyDao.selectAllZT_RayIdouVTy();
    }



    ZT_RayIdouVTy getRayIdouVTy(Integer pZtysequenceno) {

        return rayIdouVTyDao.getRayIdouVTy(pZtysequenceno);
    }


    ExDBResults<ZT_RayIdouVRn> getAllRayIdouVRn(){
        return rayIdouVRnDao.selectAllZT_RayIdouVRn();
    }



    ZT_RayIdouVRn getRayIdouVRn(Integer pZrnsequenceno) {

        return rayIdouVRnDao.getRayIdouVRn(pZrnsequenceno);
    }


    ExDBResults<ZT_RayJigyohiTy> getAllRayJigyohiTy(){
        return rayJigyohiTyDao.selectAllZT_RayJigyohiTy();
    }



    ZT_RayJigyohiTy getRayJigyohiTy(Integer pZtysequenceno) {

        return rayJigyohiTyDao.getRayJigyohiTy(pZtysequenceno);
    }


    ExDBResults<ZT_RayJigyohiRn> getAllRayJigyohiRn(){
        return rayJigyohiRnDao.selectAllZT_RayJigyohiRn();
    }



    ZT_RayJigyohiRn getRayJigyohiRn(Integer pZrnsequenceno) {

        return rayJigyohiRnDao.getRayJigyohiRn(pZrnsequenceno);
    }


    ExDBResults<ZT_KsnRayJigyohiTy> getAllKsnRayJigyohiTy(){
        return ksnRayJigyohiTyDao.selectAllZT_KsnRayJigyohiTy();
    }



    ZT_KsnRayJigyohiTy getKsnRayJigyohiTy(Integer pZtysequenceno) {

        return ksnRayJigyohiTyDao.getKsnRayJigyohiTy(pZtysequenceno);
    }


    ExDBResults<ZT_KsnRayJigyohiRn> getAllKsnRayJigyohiRn(){
        return ksnRayJigyohiRnDao.selectAllZT_KsnRayJigyohiRn();
    }



    ZT_KsnRayJigyohiRn getKsnRayJigyohiRn(Integer pZrnsequenceno) {

        return ksnRayJigyohiRnDao.getKsnRayJigyohiRn(pZrnsequenceno);
    }

}
