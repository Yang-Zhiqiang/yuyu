package yuyu.def.biz.manager.impl;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.biz.sorter.SortBM_MqBatchSosiki;
import yuyu.def.biz.sorter.SortBT_TjtIdouNyKh;
import yuyu.def.biz.sorter.SortBT_TjtIdouNyKhItjhzn;
import yuyu.def.biz.sorter.SortBT_TjtIdouNyNk;
import yuyu.def.biz.sorter.SortBT_TjtIdouNyNkItjhzn;
import yuyu.def.biz.sorter.SortBT_TjtIdouNySk;
import yuyu.def.biz.sorter.SortBT_TjtIdouNySkItjhzn;
import yuyu.def.biz.sorter.SortBT_YoukyuuNoKanri;
import yuyu.def.db.dao.BM_MqBatchSosikiDao;
import yuyu.def.db.dao.BT_TjtIdouNyKhDao;
import yuyu.def.db.dao.BT_TjtIdouNyKhItjhznDao;
import yuyu.def.db.dao.BT_TjtIdouNyNkDao;
import yuyu.def.db.dao.BT_TjtIdouNyNkItjhznDao;
import yuyu.def.db.dao.BT_TjtIdouNySkDao;
import yuyu.def.db.dao.BT_TjtIdouNySkItjhznDao;
import yuyu.def.db.dao.BT_YoukyuuNoKanriDao;
import yuyu.def.db.entity.BM_MqBatchSosiki;
import yuyu.def.db.entity.BT_TjtIdouNyKh;
import yuyu.def.db.entity.BT_TjtIdouNyKhItjhzn;
import yuyu.def.db.entity.BT_TjtIdouNyNk;
import yuyu.def.db.entity.BT_TjtIdouNyNkItjhzn;
import yuyu.def.db.entity.BT_TjtIdouNySk;
import yuyu.def.db.entity.BT_TjtIdouNySkItjhzn;
import yuyu.def.db.entity.BT_YoukyuuNoKanri;


/**
 * NayoseDomマネージャー<br />
 * Nayoseにおける、DB操作を提供する。<br />
 */
class NayoseDomManager {

    @Inject
    private BM_MqBatchSosikiDao mqBatchSosikiDao;

    @Inject
    private BT_TjtIdouNyKhDao tjtIdouNyKhDao;

    @Inject
    private BT_TjtIdouNyKhItjhznDao tjtIdouNyKhItjhznDao;

    @Inject
    private BT_TjtIdouNyNkDao tjtIdouNyNkDao;

    @Inject
    private BT_TjtIdouNyNkItjhznDao tjtIdouNyNkItjhznDao;

    @Inject
    private BT_TjtIdouNySkDao tjtIdouNySkDao;

    @Inject
    private BT_TjtIdouNySkItjhznDao tjtIdouNySkItjhznDao;

    @Inject
    private BT_YoukyuuNoKanriDao youkyuuNoKanriDao;

    List<BT_YoukyuuNoKanri> getAllYoukyuuNoKanri(){
        SortBT_YoukyuuNoKanri sortBT_YoukyuuNoKanri = new SortBT_YoukyuuNoKanri();
        return sortBT_YoukyuuNoKanri.OrderBT_YoukyuuNoKanriByPkAsc(youkyuuNoKanriDao.selectAll());
    }

    BT_YoukyuuNoKanri getYoukyuuNoKanri(String pYoukyuuno) {

        return youkyuuNoKanriDao.getYoukyuuNoKanri(pYoukyuuno);
    }

    List<BM_MqBatchSosiki> getAllMqBatchSosiki(){
        SortBM_MqBatchSosiki sortBM_MqBatchSosiki = new SortBM_MqBatchSosiki();
        return sortBM_MqBatchSosiki.OrderBM_MqBatchSosikiByPkAsc(mqBatchSosikiDao.selectAll());
    }

    BM_MqBatchSosiki getMqBatchSosiki(String pKinouId) {

        return mqBatchSosikiDao.getMqBatchSosiki(pKinouId);
    }

    List<BT_TjtIdouNyKh> getAllTjtIdouNyKh(){
        SortBT_TjtIdouNyKh sortBT_TjtIdouNyKh = new SortBT_TjtIdouNyKh();
        return sortBT_TjtIdouNyKh.OrderBT_TjtIdouNyKhByPkAsc(tjtIdouNyKhDao.selectAll());
    }

    BT_TjtIdouNyKh getTjtIdouNyKh(String pSyono, Integer pRenno3keta) {

        return tjtIdouNyKhDao.getTjtIdouNyKh(pSyono, pRenno3keta);
    }

    ExDBResults<BT_TjtIdouNyKh> getTjtIdouNyKhs() {

        return tjtIdouNyKhDao.getTjtIdouNyKhs();
    }

    ExDBResults<BT_TjtIdouNyKh> getTjtIdouNyKhsByKakutyoujobcdMaxRenno3keta(String pKakutyoujobcd) {


        ExDBResults<BT_TjtIdouNyKh> exDBResults = tjtIdouNyKhDao.getTjtIdouNyKhsByKakutyoujobcdMaxRenno3keta();


        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBResults;
    }

    List<BT_TjtIdouNyKh> getTjtIdouNyKhsBySyono(String pSyono) {

        return  tjtIdouNyKhDao.getTjtIdouNyKhsBySyono(pSyono);
    }

    Integer getTjtIdouNyKhMaxRenno3ketaBySyono(String pSyono) {

        return tjtIdouNyKhDao.getTjtIdouNyKhMaxRenno3ketaBySyono( pSyono);
    }

    List<BT_TjtIdouNyKh> getTjtIdouNyKhsBySyonoYoukyuuno(String pSyono, String pYoukyuuno) {

        return tjtIdouNyKhDao.getTjtIdouNyKhsBySyonoYoukyuuno(pSyono, pYoukyuuno);
    }

    List<BT_TjtIdouNySk> getAllTjtIdouNySk(){
        SortBT_TjtIdouNySk sortBT_TjtIdouNySk = new SortBT_TjtIdouNySk();
        return sortBT_TjtIdouNySk.OrderBT_TjtIdouNySkByPkAsc(tjtIdouNySkDao.selectAll());
    }

    ExDBResults<BT_TjtIdouNySk> getTjtIdouNySks() {

        return tjtIdouNySkDao.getTjtIdouNySks();
    }

    ExDBResults<BT_TjtIdouNySk> getTjtIdouNySksByKakutyoujobcdMaxRenno3keta(String pKakutyoujobcd) {


        ExDBResults<BT_TjtIdouNySk> exDBResults = tjtIdouNySkDao.getTjtIdouNySksByKakutyoujobcdMaxRenno3keta();


        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBResults;
    }

    List<BT_TjtIdouNySk> getTjtIdouNySksByMosno(String pMosno) {

        return tjtIdouNySkDao.getTjtIdouNySksByMosno(pMosno);
    }

    BT_TjtIdouNySk getTjtIdouNySk(String pMosno, Integer pRenno3keta) {

        return tjtIdouNySkDao.getTjtIdouNySk(pMosno, pRenno3keta);
    }

    Integer getTjtIdouNySkMaxRenno3ketaByMosno(String pMosno) {
        return tjtIdouNySkDao.getTjtIdouNySkMaxRenno3ketaByMosno(pMosno);
    }

    List<BT_TjtIdouNySk> getTjtIdouNySksByMosnoYoukyuuno(String pMosno, String pYoukyuuno) {

        return tjtIdouNySkDao.getTjtIdouNySksByMosnoYoukyuuno(pMosno, pYoukyuuno);
    }

    List<BT_TjtIdouNyNk> getAllTjtIdouNyNk(){
        SortBT_TjtIdouNyNk sortBT_TjtIdouNyNk = new SortBT_TjtIdouNyNk();
        return sortBT_TjtIdouNyNk.OrderBT_TjtIdouNyNkByPkAsc(tjtIdouNyNkDao.selectAll());
    }

    List<BT_TjtIdouNyNk> getTjtIdouNyNksByNksysyno(String pNksysyno) {

        return tjtIdouNyNkDao.getTjtIdouNyNksByNksysyno(pNksysyno);
    }

    ExDBResults<BT_TjtIdouNyNk> getTjtIdouNyNks() {

        return tjtIdouNyNkDao.getTjtIdouNyNks();
    }

    ExDBResults<BT_TjtIdouNyNk> getTjtIdouNyNksByKakutyoujobcdMaxRenno3keta(String pKakutyoujobcd) {


        ExDBResults<BT_TjtIdouNyNk> exDBResults = tjtIdouNyNkDao.getTjtIdouNyNksByKakutyoujobcdMaxRenno3keta();


        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBResults;
    }

    BT_TjtIdouNyNk getTjtIdouNyNk(String pNksysyno, Integer pRenno3keta) {

        return tjtIdouNyNkDao.getTjtIdouNyNk(pNksysyno, pRenno3keta);
    }

    Integer getTjtIdouNyNkMaxRenno3ketaByNksysyno(String pNksysyno) {

        return tjtIdouNyNkDao.getTjtIdouNyNkMaxRenno3ketaByNksysyno(pNksysyno);
    }

    List<BT_TjtIdouNyNk> getTjtIdouNyNksByNksysynoYoukyuuno(String pNksysyno, String pYoukyuuno) {

        return tjtIdouNyNkDao.getTjtIdouNyNksByNksysynoYoukyuuno(pNksysyno, pYoukyuuno);
    }

    List<BT_TjtIdouNyKhItjhzn> getAllTjtIdouNyKhItjhzn(){
        SortBT_TjtIdouNyKhItjhzn sortBT_TjtIdouNyKhItjhzn = new SortBT_TjtIdouNyKhItjhzn();
        return sortBT_TjtIdouNyKhItjhzn.OrderBT_TjtIdouNyKhItjhznByPkAsc(tjtIdouNyKhItjhznDao.selectAll());
    }

    BT_TjtIdouNyKhItjhzn getTjtIdouNyKhItjhzn(String pSyono, Integer pRenno3keta) {

        return tjtIdouNyKhItjhznDao.getTjtIdouNyKhItjhzn(pSyono, pRenno3keta);
    }

    List<BT_TjtIdouNySkItjhzn> getAllTjtIdouNySkItjhzn(){
        SortBT_TjtIdouNySkItjhzn sortBT_TjtIdouNySkItjhzn = new SortBT_TjtIdouNySkItjhzn();
        return sortBT_TjtIdouNySkItjhzn.OrderBT_TjtIdouNySkItjhznByPkAsc(tjtIdouNySkItjhznDao.selectAll());
    }

    BT_TjtIdouNySkItjhzn getTjtIdouNySkItjhzn(String pMosno, Integer pRenno3keta) {

        return tjtIdouNySkItjhznDao.getTjtIdouNySkItjhzn(pMosno, pRenno3keta);
    }

    List<BT_TjtIdouNyNkItjhzn> getAllTjtIdouNyNkItjhzn(){
        SortBT_TjtIdouNyNkItjhzn sortBT_TjtIdouNyNkItjhzn = new SortBT_TjtIdouNyNkItjhzn();
        return sortBT_TjtIdouNyNkItjhzn.OrderBT_TjtIdouNyNkItjhznByPkAsc(tjtIdouNyNkItjhznDao.selectAll());
    }

    BT_TjtIdouNyNkItjhzn getTjtIdouNyNkItjhzn(String pNksysyno, Integer pRenno3keta) {

        return tjtIdouNyNkItjhznDao.getTjtIdouNyNkItjhzn(pNksysyno, pRenno3keta);
    }

}
