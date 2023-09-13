package yuyu.def.direct.manager.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_DsKrHnnKakCdTtYhKbn;
import yuyu.def.classification.C_DsSousinMailSyubetuKbn;
import yuyu.def.db.dao.MT_BAK_DsKokyakuKanriDao;
import yuyu.def.db.dao.MT_DsHanyouKokyakuateTuutiDao;
import yuyu.def.db.dao.MT_DsHonninKakuninCdDao;
import yuyu.def.db.dao.MT_DsKokyakuKanriDao;
import yuyu.def.db.dao.MT_DsKokyakuKeiyakuDao;
import yuyu.def.db.dao.MT_DsMailAddressSpiralYykDao;
import yuyu.def.db.dao.MT_DsMailHaisinDao;
import yuyu.def.db.dao.MT_DsMailHaisinYoyakuDao;
import yuyu.def.db.dao.MT_DsNeugokiHanteiKekkaDao;
import yuyu.def.db.entity.MT_BAK_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsHanyouKokyakuateTuuti;
import yuyu.def.db.entity.MT_DsHonninKakuninCd;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsKokyakuKeiyaku;
import yuyu.def.db.entity.MT_DsLoginKanri;
import yuyu.def.db.entity.MT_DsMailAddressSpiralYyk;
import yuyu.def.db.entity.MT_DsMailHaisin;
import yuyu.def.db.entity.MT_DsMailHaisinYoyaku;
import yuyu.def.db.entity.MT_DsNeugokiHanteiKekka;
import yuyu.def.direct.result.bean.DsKokKnrInfosByDskrhnnkakcdttyhkbnSyoriYmdBean;
import yuyu.def.direct.result.bean.DsKokyakuInfoBySyonoDskykmukouhyjROWNUMBean;
import yuyu.def.direct.result.bean.DsKokyakuKanrisByItemsBean;
import yuyu.def.direct.sorter.SortMT_BAK_DsKokyakuKanri;
import yuyu.def.direct.sorter.SortMT_DsKokyakuKanri;
import yuyu.def.direct.sorter.SortMT_DsMailHaisin;
import yuyu.def.direct.sorter.SortMT_DsMailHaisinYoyaku;
import yuyu.def.direct.sorter.SortMT_DsNeugokiHanteiKekka;


/**
 * DirectInfoDomマネージャー<br />
 * DirectInfoにおける、DB操作を提供する。<br />
 */
class DirectInfoDomManager {

    @Inject
    private MT_BAK_DsKokyakuKanriDao bAK_DsKokyakuKanriDao;

    @Inject
    private MT_DsHanyouKokyakuateTuutiDao dsHanyouKokyakuateTuutiDao;

    @Inject
    private MT_DsHonninKakuninCdDao dsHonninKakuninCdDao;

    @Inject
    private MT_DsKokyakuKanriDao dsKokyakuKanriDao;

    @Inject
    private MT_DsKokyakuKeiyakuDao dsKokyakuKeiyakuDao;

    @Inject
    private MT_DsMailAddressSpiralYykDao dsMailAddressSpiralYykDao;

    @Inject
    private MT_DsMailHaisinDao dsMailHaisinDao;

    @Inject
    private MT_DsNeugokiHanteiKekkaDao dsNeugokiHanteiKekkaDao;

    @Inject
    private MT_DsMailHaisinYoyakuDao dsMailHaisinYoyakuDao;

    List<MT_DsKokyakuKanri> getAllDsKokyakuKanri(){
        SortMT_DsKokyakuKanri sortMT_DsKokyakuKanri = new SortMT_DsKokyakuKanri();
        return sortMT_DsKokyakuKanri.OrderMT_DsKokyakuKanriByPkAsc(dsKokyakuKanriDao.selectAll());
    }

    MT_DsKokyakuKanri getDsKokyakuKanri(String pDskokno) {

        return dsKokyakuKanriDao.getDsKokyakuKanri(pDskokno);
    }

    List<MT_DsKokyakuKeiyaku> getDsKokyakuKeiyakusBySyonoDskykmukouhyjBlank(String pSyono) {

        return dsKokyakuKeiyakuDao.getDsKokyakuKeiyakusBySyonoDskykmukouhyjBlank(pSyono);
    }

    List<MT_DsKokyakuKeiyaku> getDsKokyakuKeiyakusBySyono(String pSyono) {

        return dsKokyakuKeiyakuDao.getDsKokyakuKeiyakusBySyono(pSyono);
    }

    ExDBUpdatableResults<MT_DsKokyakuKanri>  getDsKokyakuKanrisByKakutyoujobcdDskokyakujtkbnSeisahuyouhyjDskykmukouhyj(String pKakutyoujobcd) {


        ExDBUpdatableResults<MT_DsKokyakuKanri> exDBUpdatableResults =
            dsKokyakuKanriDao.getDsKokyakuKanrisByKakutyoujobcdDskokyakujtkbnSeisahuyouhyjDskykmukouhyj();

        exDBUpdatableResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBUpdatableResults;
    }

    List<MT_BAK_DsKokyakuKanri> getAllBAKDsKokyakuKanri(){
        SortMT_BAK_DsKokyakuKanri sortMT_BAK_DsKokyakuKanri = new SortMT_BAK_DsKokyakuKanri();
        return sortMT_BAK_DsKokyakuKanri.OrderMT_BAK_DsKokyakuKanriByPkAsc(bAK_DsKokyakuKanriDao.selectAll());
    }

    MT_BAK_DsKokyakuKanri getBAKDsKokyakuKanri(String pDskokno, String pTrkssikibetukey) {

        return bAK_DsKokyakuKanriDao.getBAKDsKokyakuKanri(pDskokno, pTrkssikibetukey);
    }

    ExDBUpdatableResults<MT_DsKokyakuKanri> getDsKokyakuKanrisByKakutyoujobcd(String pKakutyoujobcd) {

        ExDBUpdatableResults<MT_DsKokyakuKanri> exDBUpdatableResults =
            dsKokyakuKanriDao.getDsKokyakuKanrisByKakutyoujobcd();

        exDBUpdatableResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBUpdatableResults;
    }



    List<MT_DsKokyakuKeiyaku> getDsKokyakuKeiyakusByDskoknoDskykmukouhyjSyutkkbnYuukousyoumetukbn(String pDskokno) {

        return dsKokyakuKeiyakuDao.getDsKokyakuKeiyakusByDskoknoDskykmukouhyjSyutkkbnYuukousyoumetukbn(pDskokno);
    }

    ExDBUpdatableResults<MT_DsKokyakuKanri> getDsKokyakuKanrisByDskokyakujtkbnDsteisiriyuukbnDskrhnnkakcdsetymd() {

        return dsKokyakuKeiyakuDao.getDsKokyakuKanrisByDskokyakujtkbnDsteisiriyuukbnDskrhnnkakcdsetymd();
    }

    ExDBUpdatableResults<MT_DsKokyakuKanri> getDsKokyakuKanrisByDskrhnnkakcdttyhkbnDskrhnnkakcdttshjyhsymd(
        C_DsKrHnnKakCdTtYhKbn pDskrhnnkakcdttyhkbn, BizDate pDskrhnnkakcdttshjyhsymd) {

        return dsKokyakuKanriDao.getDsKokyakuKanrisByDskrhnnkakcdttyhkbnDskrhnnkakcdttshjyhsymd(pDskrhnnkakcdttyhkbn, pDskrhnnkakcdttshjyhsymd);
    }

    List<MT_DsKokyakuKanri> getDsKokyakuKanrisBySyono(String pSyono) {

        return dsKokyakuKanriDao.getDsKokyakuKanrisBySyono(pSyono);
    }

    List<DsKokyakuKanrisByItemsBean> getDsKokyakuKanrisByItems(String pDskokyakunmkn, String pDskokyakunmkj, BizDate pDskokyakuseiymd, String pDskokyakuyno) {

        List<Object[]> list = dsKokyakuKanriDao.getDsKokyakuKanrisByItems(pDskokyakunmkn, pDskokyakunmkj, pDskokyakuseiymd, pDskokyakuyno);

        List<DsKokyakuKanrisByItemsBean> returnList = new ArrayList();

        for(Object[] onjs:list){
            DsKokyakuKanrisByItemsBean bean = new DsKokyakuKanrisByItemsBean();

            bean.setMT_DsKokyakuKanri((MT_DsKokyakuKanri)onjs[0]);
            bean.setMT_DsHonninKakuninCd((MT_DsHonninKakuninCd)onjs[1]);
            bean.setMT_DsLoginKanri((MT_DsLoginKanri)onjs[2]);
            bean.setMT_DsKokyakuKeiyaku((MT_DsKokyakuKeiyaku)onjs[3]);

            returnList.add(bean);
        }

        return returnList;
    }

    List<MT_DsKokyakuKanri> getDsKokyakuKanrisBySyonoDskykmukouhyj(String pSyono) {

        return dsKokyakuKanriDao.getDsKokyakuKanrisBySyonoDskykmukouhyj(pSyono);
    }

    DsKokyakuInfoBySyonoDskykmukouhyjROWNUMBean getDsKokyakuInfoBySyonoDskykmukouhyjROWNUM(String pSyono) {

        return dsKokyakuKanriDao.getDsKokyakuInfoBySyonoDskykmukouhyjROWNUM(pSyono);
    }

    List<MT_DsKokyakuKanri> getDsKokyakuKanrisByDskokyakujtkbnNe(String pDskokyakunmkn, String pDskokyakunmkj, BizDate pDskokyakuseiymd, String pDskokyakuyno) {

        return dsKokyakuKanriDao.getDsKokyakuKanrisByDskokyakujtkbnNe(pDskokyakunmkn, pDskokyakunmkj, pDskokyakuseiymd, pDskokyakuyno);
    }

    ExDBResults<MT_DsHanyouKokyakuateTuuti> getDsHanyouKokyakuateTuutisByDsdatasakuseiymd(BizDate pDsdatasakuseiymd) {

        return dsHanyouKokyakuateTuutiDao.getDsHanyouKokyakuateTuutisByDsdatasakuseiymd(pDsdatasakuseiymd);
    }

    ExDBResults<MT_DsHonninKakuninCd> getDsHonninKakuninCdsByDskrhnnkakcdttshjyhsymd(BizDate pDskrhnnkakcdttshjyhsymd) {

        return dsHonninKakuninCdDao.getDsHonninKakuninCdsByDskrhnnkakcdttshjyhsymd(pDskrhnnkakcdttshjyhsymd);
    }

    ExDBResults<DsKokKnrInfosByDskrhnnkakcdttyhkbnSyoriYmdBean> getDsKokKnrInfosByDskrhnnkakcdttyhkbnSyoriYmd(BizDate pSyoriYmd) {

        return dsHonninKakuninCdDao.getDsKokKnrInfosByDskrhnnkakcdttyhkbnSyoriYmd(pSyoriYmd);
    }

    ExDBResults<MT_DsMailAddressSpiralYyk> getDsMailAddressSpiralYyksByDsdatasakuseiymd(BizDate pDsdatasakuseiymd) {

        return dsMailAddressSpiralYykDao.getDsMailAddressSpiralYyksByDsdatasakuseiymd(pDsdatasakuseiymd);

    }

    List<MT_DsNeugokiHanteiKekka> getAllDsNeugokiHanteiKekka(){
        SortMT_DsNeugokiHanteiKekka sortMT_DsNeugokiHanteiKekka = new SortMT_DsNeugokiHanteiKekka();
        return sortMT_DsNeugokiHanteiKekka.OrderMT_DsNeugokiHanteiKekkaByPkAsc(dsNeugokiHanteiKekkaDao.selectAll());
    }

    MT_DsNeugokiHanteiKekka getDsNeugokiHanteiKekka(BizDate pDsdatasakuseiymd, String pSyono) {

        return dsNeugokiHanteiKekkaDao.getDsNeugokiHanteiKekka(pDsdatasakuseiymd, pSyono);
    }

    List<MT_DsMailHaisin> getAllDsMailHaisin(){
        SortMT_DsMailHaisin sortMT_DsMailHaisin = new SortMT_DsMailHaisin();
        return sortMT_DsMailHaisin.OrderMT_DsMailHaisinByPkAsc(dsMailHaisinDao.selectAll());
    }

    MT_DsMailHaisin getDsMailHaisin(BizDate pSousinymd, String pDskokmailaddressskbtkey, C_DsSousinMailSyubetuKbn pDssousinmailsyubetukbn
        , String pDssousinno) {

        return dsMailHaisinDao.getDsMailHaisin(pSousinymd, pDskokmailaddressskbtkey, pDssousinmailsyubetukbn
            , pDssousinno);
    }

    MT_DsMailHaisinYoyaku getDsMailHaisinYoyaku(String pDsmailhaisinyoyakuskbtkey) {

        return dsMailHaisinYoyakuDao.getDsMailHaisinYoyaku(pDsmailhaisinyoyakuskbtkey);
    }

    List<MT_DsMailHaisinYoyaku> getAllDsMailHaisinYoyaku(){
        SortMT_DsMailHaisinYoyaku sortMT_DsMailHaisinYoyaku = new SortMT_DsMailHaisinYoyaku();
        return sortMT_DsMailHaisinYoyaku.OrderMT_DsMailHaisinYoyakuByPkAsc(dsMailHaisinYoyakuDao.selectAll());
    }

}
