package yuyu.def.zdb.manager.impl;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.dao.ZT_DrtenIpToukeiRnDao;
import yuyu.def.db.dao.ZT_DrtenIpToukeiTyDao;
import yuyu.def.db.dao.ZT_FstpUriageSeikyuuDataRnDao;
import yuyu.def.db.dao.ZT_FstpUriageSeikyuuDataTyDao;
import yuyu.def.db.dao.ZT_HonsyaToukeiRnDao;
import yuyu.def.db.dao.ZT_HonsyaToukeiTyDao;
import yuyu.def.db.dao.ZT_MosJkItiranSyoukaiRnDao;
import yuyu.def.db.dao.ZT_MosJkItiranSyoukaiTyDao;
import yuyu.def.db.dao.ZT_SeirituInfoRnDao;
import yuyu.def.db.dao.ZT_SeirituInfoTyDao;
import yuyu.def.db.dao.ZT_SkSeirituRituRnDao;
import yuyu.def.db.dao.ZT_SkSeirituRituTyDao;
import yuyu.def.db.entity.ZT_DrtenIpToukeiRn;
import yuyu.def.db.entity.ZT_DrtenIpToukeiTy;
import yuyu.def.db.entity.ZT_FstpUriageSeikyuuDataRn;
import yuyu.def.db.entity.ZT_FstpUriageSeikyuuDataTy;
import yuyu.def.db.entity.ZT_HonsyaToukeiRn;
import yuyu.def.db.entity.ZT_HonsyaToukeiTy;
import yuyu.def.db.entity.ZT_MosJkItiranSyoukaiRn;
import yuyu.def.db.entity.ZT_MosJkItiranSyoukaiTy;
import yuyu.def.db.entity.ZT_SeirituInfoRn;
import yuyu.def.db.entity.ZT_SeirituInfoTy;
import yuyu.def.db.entity.ZT_SkSeirituRituRn;
import yuyu.def.db.entity.ZT_SkSeirituRituTy;


/**
 * SinkeiyakujyohososinDomマネージャー<br />
 * Sinkeiyakujyohososinにおける、DB操作を提供する。<br />
 */
class SinkeiyakujyohososinDomManager {


    @Inject
    private ZT_DrtenIpToukeiRnDao drtenIpToukeiRnDao;


    @Inject
    private ZT_DrtenIpToukeiTyDao drtenIpToukeiTyDao;


    @Inject
    private ZT_FstpUriageSeikyuuDataRnDao fstpUriageSeikyuuDataRnDao;


    @Inject
    private ZT_FstpUriageSeikyuuDataTyDao fstpUriageSeikyuuDataTyDao;


    @Inject
    private ZT_HonsyaToukeiRnDao honsyaToukeiRnDao;


    @Inject
    private ZT_HonsyaToukeiTyDao honsyaToukeiTyDao;


    @Inject
    private ZT_MosJkItiranSyoukaiRnDao mosJkItiranSyoukaiRnDao;


    @Inject
    private ZT_MosJkItiranSyoukaiTyDao mosJkItiranSyoukaiTyDao;


    @Inject
    private ZT_SeirituInfoRnDao seirituInfoRnDao;


    @Inject
    private ZT_SeirituInfoTyDao seirituInfoTyDao;


    @Inject
    private ZT_SkSeirituRituRnDao skSeirituRituRnDao;


    @Inject
    private ZT_SkSeirituRituTyDao skSeirituRituTyDao;


    ExDBResults<ZT_DrtenIpToukeiTy> getAllDrtenIpToukeiTy(){
        return drtenIpToukeiTyDao.selectAllZT_DrtenIpToukeiTy();
    }



    ZT_DrtenIpToukeiTy getDrtenIpToukeiTy(String pZtyeigyouhonbusisyacd, String pZtysosikicd, String pZtyatukaikojincd, String pZtymosym, String pZtymosno) {

        return drtenIpToukeiTyDao.getDrtenIpToukeiTy(pZtyeigyouhonbusisyacd, pZtysosikicd, pZtyatukaikojincd, pZtymosym, pZtymosno);
    }


    ExDBResults<ZT_DrtenIpToukeiRn> getAllDrtenIpToukeiRn(){
        return drtenIpToukeiRnDao.selectAllZT_DrtenIpToukeiRn();
    }



    ZT_DrtenIpToukeiRn getDrtenIpToukeiRn(String pZrneigyouhonbusisyacd, String pZrnsosikicd, String pZrnatukaikojincd, String pZrnmosym, String pZrnmosno) {

        return drtenIpToukeiRnDao.getDrtenIpToukeiRn(pZrneigyouhonbusisyacd, pZrnsosikicd, pZrnatukaikojincd, pZrnmosym, pZrnmosno);
    }


    ExDBResults<ZT_SkSeirituRituTy> getAllSkSeirituRituTy(){
        return skSeirituRituTyDao.selectAllZT_SkSeirituRituTy();
    }



    ZT_SkSeirituRituTy getSkSeirituRituTy(String pZtyeigyouhonbusisyacd, String pZtysosikicd, String pZtyatukaikojincd, String pZtymosno) {

        return skSeirituRituTyDao.getSkSeirituRituTy(pZtyeigyouhonbusisyacd, pZtysosikicd, pZtyatukaikojincd, pZtymosno);
    }


    ExDBResults<ZT_SkSeirituRituRn> getAllSkSeirituRituRn(){
        return skSeirituRituRnDao.selectAllZT_SkSeirituRituRn();
    }



    ZT_SkSeirituRituRn getSkSeirituRituRn(String pZrneigyouhonbusisyacd, String pZrnsosikicd, String pZrnatukaikojincd, String pZrnmosno) {

        return skSeirituRituRnDao.getSkSeirituRituRn(pZrneigyouhonbusisyacd, pZrnsosikicd, pZrnatukaikojincd, pZrnmosno);
    }


    ExDBResults<ZT_MosJkItiranSyoukaiTy> getAllMosJkItiranSyoukaiTy(){
        return mosJkItiranSyoukaiTyDao.selectAllZT_MosJkItiranSyoukaiTy();
    }



    ZT_MosJkItiranSyoukaiTy getMosJkItiranSyoukaiTy(String pZtymosym, String pZtymosno, String pZtybsydrtencd, String pZtyatukaikojincd) {

        return mosJkItiranSyoukaiTyDao.getMosJkItiranSyoukaiTy(pZtymosym, pZtymosno, pZtybsydrtencd, pZtyatukaikojincd);
    }


    ExDBResults<ZT_MosJkItiranSyoukaiRn> getAllMosJkItiranSyoukaiRn(){
        return mosJkItiranSyoukaiRnDao.selectAllZT_MosJkItiranSyoukaiRn();
    }



    ZT_MosJkItiranSyoukaiRn getMosJkItiranSyoukaiRn(String pZrnmosym, String pZrnmosno, String pZrnbsydrtencd, String pZrnatukaikojincd) {

        return mosJkItiranSyoukaiRnDao.getMosJkItiranSyoukaiRn(pZrnmosym, pZrnmosno, pZrnbsydrtencd, pZrnatukaikojincd);
    }


    ExDBResults<ZT_SeirituInfoTy> getAllSeirituInfoTy(){
        return seirituInfoTyDao.selectAllZT_SeirituInfoTy();
    }



    ZT_SeirituInfoTy getSeirituInfoTy(String pZtykijyunym, String pZtymosno) {

        return seirituInfoTyDao.getSeirituInfoTy(pZtykijyunym, pZtymosno);
    }


    ExDBResults<ZT_SeirituInfoRn> getAllSeirituInfoRn(){
        return seirituInfoRnDao.selectAllZT_SeirituInfoRn();
    }



    ZT_SeirituInfoRn getSeirituInfoRn(String pZrnkijyunym, String pZrnmosno) {

        return seirituInfoRnDao.getSeirituInfoRn(pZrnkijyunym, pZrnmosno);
    }


    ExDBResults<ZT_HonsyaToukeiTy> getAllHonsyaToukeiTy(){
        return honsyaToukeiTyDao.selectAllZT_HonsyaToukeiTy();
    }



    ZT_HonsyaToukeiTy getHonsyaToukeiTy(String pZtykijyunym, String pZtymosno) {

        return honsyaToukeiTyDao.getHonsyaToukeiTy(pZtykijyunym, pZtymosno);
    }


    ExDBResults<ZT_HonsyaToukeiRn> getAllHonsyaToukeiRn(){
        return honsyaToukeiRnDao.selectAllZT_HonsyaToukeiRn();
    }



    ZT_HonsyaToukeiRn getHonsyaToukeiRn(String pZrnkijyunym, String pZrnmosno) {

        return honsyaToukeiRnDao.getHonsyaToukeiRn(pZrnkijyunym, pZrnmosno);
    }


    ExDBResults<ZT_FstpUriageSeikyuuDataTy> getAllFstpUriageSeikyuuDataTy(){
        return fstpUriageSeikyuuDataTyDao.selectAllZT_FstpUriageSeikyuuDataTy();
    }



    ZT_FstpUriageSeikyuuDataTy getFstpUriageSeikyuuDataTy(String pZtyuriageymd6keta, String pZtycreditkessaiyouno, String pZtysyono, String pZtyrecordno, Long pZtyseikyuukngk11keta) {

        return fstpUriageSeikyuuDataTyDao.getFstpUriageSeikyuuDataTy(pZtyuriageymd6keta, pZtycreditkessaiyouno, pZtysyono, pZtyrecordno, pZtyseikyuukngk11keta);
    }


    ExDBResults<ZT_FstpUriageSeikyuuDataRn> getAllFstpUriageSeikyuuDataRn(){
        return fstpUriageSeikyuuDataRnDao.selectAllZT_FstpUriageSeikyuuDataRn();
    }



    ZT_FstpUriageSeikyuuDataRn getFstpUriageSeikyuuDataRn(String pZrnuriageymd6keta, String pZrncreditkessaiyouno, String pZrnsyono, String pZrnrecordno, Long pZrnseikyuukngk11keta) {

        return fstpUriageSeikyuuDataRnDao.getFstpUriageSeikyuuDataRn(pZrnuriageymd6keta, pZrncreditkessaiyouno, pZrnsyono, pZrnrecordno, pZrnseikyuukngk11keta);
    }

}
