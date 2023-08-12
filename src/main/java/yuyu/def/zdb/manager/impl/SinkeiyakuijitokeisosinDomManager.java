package yuyu.def.zdb.manager.impl;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.dao.ZT_IsaToukeiDataRnDao;
import yuyu.def.db.dao.ZT_IsaToukeiDataTyDao;
import yuyu.def.db.dao.ZT_SyuHukugouSikkanDataRnDao;
import yuyu.def.db.dao.ZT_SyuHukugouSikkanDataTyDao;
import yuyu.def.db.dao.ZT_SyuSibouToukeiRnDao;
import yuyu.def.db.dao.ZT_SyuSibouToukeiTyDao;
import yuyu.def.db.entity.ZT_IsaToukeiDataRn;
import yuyu.def.db.entity.ZT_IsaToukeiDataTy;
import yuyu.def.db.entity.ZT_SyuHukugouSikkanDataRn;
import yuyu.def.db.entity.ZT_SyuHukugouSikkanDataTy;
import yuyu.def.db.entity.ZT_SyuSibouToukeiRn;
import yuyu.def.db.entity.ZT_SyuSibouToukeiTy;


/**
 * SinkeiyakuijitokeisosinDomマネージャー<br />
 * Sinkeiyakuijitokeisosinにおける、DB操作を提供する。<br />
 */
class SinkeiyakuijitokeisosinDomManager {

    @Inject
    private ZT_IsaToukeiDataRnDao isaToukeiDataRnDao;

    @Inject
    private ZT_IsaToukeiDataTyDao isaToukeiDataTyDao;

    @Inject
    private ZT_SyuSibouToukeiRnDao syuSibouToukeiRnDao;

    @Inject
    private ZT_SyuSibouToukeiTyDao syuSibouToukeiTyDao;

    @Inject
    private ZT_SyuHukugouSikkanDataRnDao syuHukugouSikkanDataRnDao;

    @Inject
    private ZT_SyuHukugouSikkanDataTyDao syuHukugouSikkanDataTyDao;

    ExDBResults<ZT_IsaToukeiDataTy> getAllIsaToukeiDataTy(){
        return isaToukeiDataTyDao.selectAllZT_IsaToukeiDataTy();
    }


    ZT_IsaToukeiDataTy getIsaToukeiDataTy(String pZtymosno) {

        return isaToukeiDataTyDao.getIsaToukeiDataTy(pZtymosno);
    }

    ExDBResults<ZT_IsaToukeiDataRn> getAllIsaToukeiDataRn(){
        return isaToukeiDataRnDao.selectAllZT_IsaToukeiDataRn();
    }


    ZT_IsaToukeiDataRn getIsaToukeiDataRn(String pZrnmosno) {

        return isaToukeiDataRnDao.getIsaToukeiDataRn(pZrnmosno);
    }

    ExDBResults<ZT_SyuSibouToukeiTy> getAllSyuSibouToukeiTy(){
        return syuSibouToukeiTyDao.selectAllZT_SyuSibouToukeiTy();
    }


    ZT_SyuSibouToukeiTy getSyuSibouToukeiTy(String pZtysyono) {

        return syuSibouToukeiTyDao.getSyuSibouToukeiTy(pZtysyono);
    }

    ExDBResults<ZT_SyuSibouToukeiRn> getAllSyuSibouToukeiRn(){
        return syuSibouToukeiRnDao.selectAllZT_SyuSibouToukeiRn();
    }


    ZT_SyuSibouToukeiRn getSyuSibouToukeiRn(String pZrnsyono) {

        return syuSibouToukeiRnDao.getSyuSibouToukeiRn(pZrnsyono);
    }

    ExDBResults<ZT_SyuHukugouSikkanDataTy> getAllSyuHukugouSikkanDataTy(){
        return syuHukugouSikkanDataTyDao.selectAllZT_SyuHukugouSikkanDataTy();
    }


    ZT_SyuHukugouSikkanDataTy getSyuHukugouSikkanDataTy(String pZtyijitoukeidaihyousyurui, String pZtykeiyakunendo, String pZtyhknnendo, String pZtyhhknseikbn
        , String pZtykykage, String pZtytoutatunenrei, String pZtyatukaibetu, String pZtysinsahouhou, String pZtyketteikekkakbn
        , String pZtysibousrank, String pZtyjissituhosyousrank, String pZtysirajikykkbn, String pZtyhrkhuhukbn
        , String pZtyhknsyurui2keta, String pZtydaisiincd, String pZtytyuusiincd, String pZtysyousiincd, String pZtynenreihousikikbn
        , String pZtysykgycd, String pZtytodouhukencd, String pZtybotaisisyaeigyouhonbu, String pZtysisyaeigyoubu
        , String pZtyaatukaisosikicd, String pZtynensyuukbn, String pZtyhanbaikeirokbn, String pZtyoyadairitencd
        , String pZtytratkidrtencd, String pZtybsudirtnatkikeitaikbn, String pZtykyktuuka, String pZtyhrktuuka
        , String pZtyhknsyukigou, String pZtysyksbyensitihsyutyhkumu, String pZtyjyudkaigomehrtkhkumu, String pZtyijitoukeizennoukbn
        , String pZtydai1hknkkn, String pZtyijitoukeitikshrtkykkbn) {

        return syuHukugouSikkanDataTyDao.getSyuHukugouSikkanDataTy(pZtyijitoukeidaihyousyurui, pZtykeiyakunendo, pZtyhknnendo, pZtyhhknseikbn
            , pZtykykage, pZtytoutatunenrei, pZtyatukaibetu, pZtysinsahouhou, pZtyketteikekkakbn
            , pZtysibousrank, pZtyjissituhosyousrank, pZtysirajikykkbn, pZtyhrkhuhukbn
            , pZtyhknsyurui2keta, pZtydaisiincd, pZtytyuusiincd, pZtysyousiincd, pZtynenreihousikikbn
            , pZtysykgycd, pZtytodouhukencd, pZtybotaisisyaeigyouhonbu, pZtysisyaeigyoubu
            , pZtyaatukaisosikicd, pZtynensyuukbn, pZtyhanbaikeirokbn, pZtyoyadairitencd
            , pZtytratkidrtencd, pZtybsudirtnatkikeitaikbn, pZtykyktuuka, pZtyhrktuuka
            , pZtyhknsyukigou, pZtysyksbyensitihsyutyhkumu, pZtyjyudkaigomehrtkhkumu, pZtyijitoukeizennoukbn
            , pZtydai1hknkkn, pZtyijitoukeitikshrtkykkbn);
    }

    ExDBResults<ZT_SyuHukugouSikkanDataRn> getAllSyuHukugouSikkanDataRn(){
        return syuHukugouSikkanDataRnDao.selectAllZT_SyuHukugouSikkanDataRn();
    }


    ZT_SyuHukugouSikkanDataRn getSyuHukugouSikkanDataRn(String pZrnijitoukeidaihyousyurui, String pZrnkeiyakunendo, String pZrnhknnendo, String pZrnhhknseikbn
        , String pZrnkykage, String pZrntoutatunenrei, String pZrnatukaibetu, String pZrnsinsahouhou, String pZrnketteikekkakbn
        , String pZrnsibousrank, String pZrnjissituhosyousrank, String pZrnsirajikykkbn, String pZrnhrkhuhukbn
        , String pZrnhknsyurui2keta, String pZrndaisiincd, String pZrntyuusiincd, String pZrnsyousiincd, String pZrnnenreihousikikbn
        , String pZrnsykgycd, String pZrntodouhukencd, String pZrnbotaisisyaeigyouhonbu, String pZrnsisyaeigyoubu
        , String pZrnaatukaisosikicd, String pZrnnensyuukbn, String pZrnhanbaikeirokbn, String pZrnoyadairitencd
        , String pZrntratkidrtencd, String pZrnbsudirtnatkikeitaikbn, String pZrnkyktuuka, String pZrnhrktuuka
        , String pZrnhknsyukigou, String pZrnsyksbyensitihsyutyhkumu, String pZrnjyudkaigomehrtkhkumu, String pZrnijitoukeizennoukbn
        , String pZrndai1hknkkn, String pZrnijitoukeitikshrtkykkbn) {

        return syuHukugouSikkanDataRnDao.getSyuHukugouSikkanDataRn(pZrnijitoukeidaihyousyurui, pZrnkeiyakunendo, pZrnhknnendo, pZrnhhknseikbn
            , pZrnkykage, pZrntoutatunenrei, pZrnatukaibetu, pZrnsinsahouhou, pZrnketteikekkakbn
            , pZrnsibousrank, pZrnjissituhosyousrank, pZrnsirajikykkbn, pZrnhrkhuhukbn
            , pZrnhknsyurui2keta, pZrndaisiincd, pZrntyuusiincd, pZrnsyousiincd, pZrnnenreihousikikbn
            , pZrnsykgycd, pZrntodouhukencd, pZrnbotaisisyaeigyouhonbu, pZrnsisyaeigyoubu
            , pZrnaatukaisosikicd, pZrnnensyuukbn, pZrnhanbaikeirokbn, pZrnoyadairitencd
            , pZrntratkidrtencd, pZrnbsudirtnatkikeitaikbn, pZrnkyktuuka, pZrnhrktuuka
            , pZrnhknsyukigou, pZrnsyksbyensitihsyutyhkumu, pZrnjyudkaigomehrtkhkumu, pZrnijitoukeizennoukbn
            , pZrndai1hknkkn, pZrnijitoukeitikshrtkykkbn);
    }
}
