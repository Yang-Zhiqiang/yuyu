package yuyu.def.hozen.manager.impl;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.dao.IW_KhDShrWkDao;
import yuyu.def.db.dao.IW_KhGengakuWkDao;
import yuyu.def.db.dao.IW_KhHaraikataHenkouWkDao;
import yuyu.def.db.dao.IW_KhHubiKaisyouDetailWkDao;
import yuyu.def.db.dao.IW_KhHubiWkDao;
import yuyu.def.db.dao.IW_KhJyudKigmaebriTkykHnkWkDao;
import yuyu.def.db.dao.IW_KhJyuusyoHenkouWkDao;
import yuyu.def.db.dao.IW_KhKaiyakuWkDao;
import yuyu.def.db.dao.IW_KhKeiyakuTorikesiWkDao;
import yuyu.def.db.dao.IW_KhKzktrkKykDrHnkWkDao;
import yuyu.def.db.dao.IW_KhMeigiHenkouWkDao;
import yuyu.def.db.dao.IW_KhMkhgkHenkouWkDao;
import yuyu.def.db.dao.IW_KhNkShrTokuyakuHenkouWkDao;
import yuyu.def.db.dao.IW_KhSeinengappiSeiTeiseiWkDao;
import yuyu.def.db.dao.IW_KhSiharaiKouzaHenkouWkDao;
import yuyu.def.db.dao.IW_KhSiteidairiTokuyakuWkDao;
import yuyu.def.db.dao.IW_KhSyoukenSaihakkouWkDao;
import yuyu.def.db.dao.IW_KhTargetTokuyakuHenkouWkDao;
import yuyu.def.db.dao.IW_KhTmttknitenWkDao;
import yuyu.def.db.dao.IW_KhYendtHnkHrShrWkDao;
import yuyu.def.db.dao.IW_KhYendtHnkUktkNiniWkDao;
import yuyu.def.db.entity.IW_KhDShrWk;
import yuyu.def.db.entity.IW_KhGengakuWk;
import yuyu.def.db.entity.IW_KhHaraikataHenkouWk;
import yuyu.def.db.entity.IW_KhHubiKaisyouDetailWk;
import yuyu.def.db.entity.IW_KhHubiWk;
import yuyu.def.db.entity.IW_KhJyudKigmaebriTkykHnkWk;
import yuyu.def.db.entity.IW_KhJyuusyoHenkouWk;
import yuyu.def.db.entity.IW_KhKaiyakuWk;
import yuyu.def.db.entity.IW_KhKeiyakuTorikesiWk;
import yuyu.def.db.entity.IW_KhKzktrkKykDrHnkWk;
import yuyu.def.db.entity.IW_KhMeigiHenkouWk;
import yuyu.def.db.entity.IW_KhMkhgkHenkouWk;
import yuyu.def.db.entity.IW_KhNkShrTokuyakuHenkouWk;
import yuyu.def.db.entity.IW_KhSeinengappiSeiTeiseiWk;
import yuyu.def.db.entity.IW_KhSiharaiKouzaHenkouWk;
import yuyu.def.db.entity.IW_KhSiteidairiTokuyakuWk;
import yuyu.def.db.entity.IW_KhSyoukenSaihakkouWk;
import yuyu.def.db.entity.IW_KhTargetTokuyakuHenkouWk;
import yuyu.def.db.entity.IW_KhTmttknitenWk;
import yuyu.def.db.entity.IW_KhYendtHnkHrShrWk;
import yuyu.def.db.entity.IW_KhYendtHnkUktkNiniWk;
import yuyu.def.hozen.sorter.SortIW_KhDShrWk;
import yuyu.def.hozen.sorter.SortIW_KhGengakuWk;
import yuyu.def.hozen.sorter.SortIW_KhHaraikataHenkouWk;
import yuyu.def.hozen.sorter.SortIW_KhHubiKaisyouDetailWk;
import yuyu.def.hozen.sorter.SortIW_KhHubiWk;
import yuyu.def.hozen.sorter.SortIW_KhJyudKigmaebriTkykHnkWk;
import yuyu.def.hozen.sorter.SortIW_KhJyuusyoHenkouWk;
import yuyu.def.hozen.sorter.SortIW_KhKaiyakuWk;
import yuyu.def.hozen.sorter.SortIW_KhKeiyakuTorikesiWk;
import yuyu.def.hozen.sorter.SortIW_KhKzktrkKykDrHnkWk;
import yuyu.def.hozen.sorter.SortIW_KhMeigiHenkouWk;
import yuyu.def.hozen.sorter.SortIW_KhMkhgkHenkouWk;
import yuyu.def.hozen.sorter.SortIW_KhNkShrTokuyakuHenkouWk;
import yuyu.def.hozen.sorter.SortIW_KhSeinengappiSeiTeiseiWk;
import yuyu.def.hozen.sorter.SortIW_KhSiharaiKouzaHenkouWk;
import yuyu.def.hozen.sorter.SortIW_KhSiteidairiTokuyakuWk;
import yuyu.def.hozen.sorter.SortIW_KhSyoukenSaihakkouWk;
import yuyu.def.hozen.sorter.SortIW_KhTargetTokuyakuHenkouWk;
import yuyu.def.hozen.sorter.SortIW_KhTmttknitenWk;
import yuyu.def.hozen.sorter.SortIW_KhYendtHnkHrShrWk;
import yuyu.def.hozen.sorter.SortIW_KhYendtHnkUktkNiniWk;


/**
 * WKDomマネージャー<br />
 * WKにおける、DB操作を提供する。<br />
 */
class WKDomManager {

    @Inject
    private IW_KhDShrWkDao khDShrWkDao;

    @Inject
    private IW_KhGengakuWkDao khGengakuWkDao;

    @Inject
    private IW_KhHaraikataHenkouWkDao khHaraikataHenkouWkDao;

    @Inject
    private IW_KhHubiKaisyouDetailWkDao khHubiKaisyouDetailWkDao;

    @Inject
    private IW_KhHubiWkDao khHubiWkDao;

    @Inject
    private IW_KhJyudKigmaebriTkykHnkWkDao khJyudKigmaebriTkykHnkWkDao;

    @Inject
    private IW_KhMkhgkHenkouWkDao khMkhgkHenkouWkDao;

    @Inject
    private IW_KhJyuusyoHenkouWkDao khJyuusyoHenkouWkDao;

    @Inject
    private IW_KhKaiyakuWkDao khKaiyakuWkDao;

    @Inject
    private IW_KhKeiyakuTorikesiWkDao khKeiyakuTorikesiWkDao;

    @Inject
    private IW_KhKzktrkKykDrHnkWkDao khKzktrkKykDrHnkWkDao;

    @Inject
    private IW_KhMeigiHenkouWkDao khMeigiHenkouWkDao;

    @Inject
    private IW_KhNkShrTokuyakuHenkouWkDao khNkShrTokuyakuHenkouWkDao;

    @Inject
    private IW_KhSeinengappiSeiTeiseiWkDao khSeinengappiSeiTeiseiWkDao;

    @Inject
    private IW_KhSiharaiKouzaHenkouWkDao khSiharaiKouzaHenkouWkDao;

    @Inject
    private IW_KhSiteidairiTokuyakuWkDao khSiteidairiTokuyakuWkDao;

    @Inject
    private IW_KhSyoukenSaihakkouWkDao khSyoukenSaihakkouWkDao;

    @Inject
    private IW_KhTargetTokuyakuHenkouWkDao khTargetTokuyakuHenkouWkDao;

    @Inject
    private IW_KhTmttknitenWkDao khTmttknitenWkDao;

    @Inject
    private IW_KhYendtHnkHrShrWkDao khYendtHnkHrShrWkDao;

    @Inject
    private IW_KhYendtHnkUktkNiniWkDao khYendtHnkUktkNiniWkDao;

    List<IW_KhKaiyakuWk> getAllKhKaiyakuWk(){
        SortIW_KhKaiyakuWk sortIW_KhKaiyakuWk = new SortIW_KhKaiyakuWk();
        return sortIW_KhKaiyakuWk.OrderIW_KhKaiyakuWkByPkAsc(khKaiyakuWkDao.selectAll());
    }

    IW_KhKaiyakuWk getKhKaiyakuWk(String pKouteikanriid) {

        return khKaiyakuWkDao.getKhKaiyakuWk(pKouteikanriid);
    }

    ExDBResults<IW_KhKaiyakuWk> getKhKaiyakuWksByKakutyoujobcdSkssakuseiymd(String pKakutyoujobcd, BizDate pSkssakuseiymd) {

        ExDBResults<IW_KhKaiyakuWk> exDBResults = khKaiyakuWkDao.getKhKaiyakuWksByKakutyoujobcdSkssakuseiymd(pSkssakuseiymd);

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    List<IW_KhJyuusyoHenkouWk> getAllKhJyuusyoHenkouWk(){
        SortIW_KhJyuusyoHenkouWk sortIW_KhJyuusyoHenkouWk = new SortIW_KhJyuusyoHenkouWk();
        return sortIW_KhJyuusyoHenkouWk.OrderIW_KhJyuusyoHenkouWkByPkAsc(khJyuusyoHenkouWkDao.selectAll());
    }

    IW_KhJyuusyoHenkouWk getKhJyuusyoHenkouWk(String pKouteikanriid) {

        return khJyuusyoHenkouWkDao.getKhJyuusyoHenkouWk(pKouteikanriid);
    }

    List<IW_KhMeigiHenkouWk> getAllKhMeigiHenkouWk(){
        SortIW_KhMeigiHenkouWk sortIW_KhMeigiHenkouWk = new SortIW_KhMeigiHenkouWk();
        return sortIW_KhMeigiHenkouWk.OrderIW_KhMeigiHenkouWkByPkAsc(khMeigiHenkouWkDao.selectAll());
    }

    IW_KhMeigiHenkouWk getKhMeigiHenkouWk(String pKouteikanriid) {

        return khMeigiHenkouWkDao.getKhMeigiHenkouWk(pKouteikanriid);
    }

    List<IW_KhSeinengappiSeiTeiseiWk> getAllKhSeinengappiSeiTeiseiWk(){
        SortIW_KhSeinengappiSeiTeiseiWk sortIW_KhSeinengappiSeiTeiseiWk = new SortIW_KhSeinengappiSeiTeiseiWk();
        return sortIW_KhSeinengappiSeiTeiseiWk.OrderIW_KhSeinengappiSeiTeiseiWkByPkAsc(khSeinengappiSeiTeiseiWkDao.selectAll());
    }

    IW_KhSeinengappiSeiTeiseiWk getKhSeinengappiSeiTeiseiWk(String pKouteikanriid) {

        return khSeinengappiSeiTeiseiWkDao.getKhSeinengappiSeiTeiseiWk(pKouteikanriid);
    }

    List<IW_KhSyoukenSaihakkouWk> getAllKhSyoukenSaihakkouWk(){
        SortIW_KhSyoukenSaihakkouWk sortIW_KhSyoukenSaihakkouWk = new SortIW_KhSyoukenSaihakkouWk();
        return sortIW_KhSyoukenSaihakkouWk.OrderIW_KhSyoukenSaihakkouWkByPkAsc(khSyoukenSaihakkouWkDao.selectAll());
    }

    IW_KhSyoukenSaihakkouWk getKhSyoukenSaihakkouWk(String pKouteikanriid) {

        return khSyoukenSaihakkouWkDao.getKhSyoukenSaihakkouWk(pKouteikanriid);
    }

    List<IW_KhHubiWk> getAllKhHubiWk(){
        SortIW_KhHubiWk sortIW_KhHubiWk = new SortIW_KhHubiWk();
        return sortIW_KhHubiWk.OrderIW_KhHubiWkByPkAsc(khHubiWkDao.selectAll());
    }

    IW_KhHubiWk getKhHubiWk(String pKouteikanriid) {

        return khHubiWkDao.getKhHubiWk(pKouteikanriid);
    }

    List<IW_KhHubiKaisyouDetailWk> getAllKhHubiKaisyouDetailWk(){
        SortIW_KhHubiKaisyouDetailWk sortIW_KhHubiKaisyouDetailWk = new SortIW_KhHubiKaisyouDetailWk();
        return sortIW_KhHubiKaisyouDetailWk.OrderIW_KhHubiKaisyouDetailWkByPkAsc(khHubiKaisyouDetailWkDao.selectAll());
    }

    IW_KhHubiKaisyouDetailWk getKhHubiKaisyouDetailWk(String pKouteikanriid, Integer pRenno3keta) {

        return khHubiKaisyouDetailWkDao.getKhHubiKaisyouDetailWk(pKouteikanriid, pRenno3keta);
    }

    List<IW_KhHubiKaisyouDetailWk> getKhHubiKaisyouDetailWksByKouteikanriid(String pKouteikanriid) {

        return khHubiKaisyouDetailWkDao.getKhHubiKaisyouDetailWksByKouteikanriid(pKouteikanriid);
    }

    List<IW_KhGengakuWk> getAllKhGengakuWk(){
        SortIW_KhGengakuWk sortIW_KhGengakuWk = new SortIW_KhGengakuWk();
        return sortIW_KhGengakuWk.OrderIW_KhGengakuWkByPkAsc(khGengakuWkDao.selectAll());
    }

    IW_KhGengakuWk getKhGengakuWk(String pKouteikanriid) {

        return khGengakuWkDao.getKhGengakuWk(pKouteikanriid);
    }

    List<IW_KhTargetTokuyakuHenkouWk> getAllKhTargetTokuyakuHenkouWk(){
        SortIW_KhTargetTokuyakuHenkouWk sortIW_KhTargetTokuyakuHenkouWk = new SortIW_KhTargetTokuyakuHenkouWk();
        return sortIW_KhTargetTokuyakuHenkouWk.OrderIW_KhTargetTokuyakuHenkouWkByPkAsc(khTargetTokuyakuHenkouWkDao.selectAll());
    }

    IW_KhTargetTokuyakuHenkouWk getKhTargetTokuyakuHenkouWk(String pKouteikanriid) {

        return khTargetTokuyakuHenkouWkDao.getKhTargetTokuyakuHenkouWk(pKouteikanriid);
    }

    List<IW_KhSiteidairiTokuyakuWk> getAllKhSiteidairiTokuyakuWk(){
        SortIW_KhSiteidairiTokuyakuWk sortIW_KhSiteidairiTokuyakuWk = new SortIW_KhSiteidairiTokuyakuWk();
        return sortIW_KhSiteidairiTokuyakuWk.OrderIW_KhSiteidairiTokuyakuWkByPkAsc(khSiteidairiTokuyakuWkDao.selectAll());
    }

    IW_KhSiteidairiTokuyakuWk getKhSiteidairiTokuyakuWk(String pKouteikanriid) {

        return khSiteidairiTokuyakuWkDao.getKhSiteidairiTokuyakuWk(pKouteikanriid);
    }

    List<IW_KhNkShrTokuyakuHenkouWk> getAllKhNkShrTokuyakuHenkouWk(){
        SortIW_KhNkShrTokuyakuHenkouWk sortIW_KhNkShrTokuyakuHenkouWk = new SortIW_KhNkShrTokuyakuHenkouWk();
        return sortIW_KhNkShrTokuyakuHenkouWk.OrderIW_KhNkShrTokuyakuHenkouWkByPkAsc(khNkShrTokuyakuHenkouWkDao.selectAll());
    }

    IW_KhNkShrTokuyakuHenkouWk getKhNkShrTokuyakuHenkouWk(String pKouteikanriid) {

        return khNkShrTokuyakuHenkouWkDao.getKhNkShrTokuyakuHenkouWk(pKouteikanriid);
    }

    List<IW_KhKeiyakuTorikesiWk> getAllKhKeiyakuTorikesiWk(){
        SortIW_KhKeiyakuTorikesiWk sortIW_KhKeiyakuTorikesiWk = new SortIW_KhKeiyakuTorikesiWk();
        return sortIW_KhKeiyakuTorikesiWk.OrderIW_KhKeiyakuTorikesiWkByPkAsc(khKeiyakuTorikesiWkDao.selectAll());
    }

    IW_KhKeiyakuTorikesiWk getKhKeiyakuTorikesiWk(String pKouteikanriid) {

        return khKeiyakuTorikesiWkDao.getKhKeiyakuTorikesiWk(pKouteikanriid);
    }

    List<IW_KhSiharaiKouzaHenkouWk> getAllKhSiharaiKouzaHenkouWk(){
        SortIW_KhSiharaiKouzaHenkouWk sortIW_KhSiharaiKouzaHenkouWk = new SortIW_KhSiharaiKouzaHenkouWk();
        return sortIW_KhSiharaiKouzaHenkouWk.OrderIW_KhSiharaiKouzaHenkouWkByPkAsc(khSiharaiKouzaHenkouWkDao.selectAll());
    }

    IW_KhSiharaiKouzaHenkouWk getKhSiharaiKouzaHenkouWk(String pKouteikanriid) {

        return khSiharaiKouzaHenkouWkDao.getKhSiharaiKouzaHenkouWk(pKouteikanriid);
    }

    List<IW_KhJyudKigmaebriTkykHnkWk> getAllKhJyudKigmaebriTkykHnkWk(){
        SortIW_KhJyudKigmaebriTkykHnkWk sortIW_KhJyudKigmaebriTkykHnkWk = new SortIW_KhJyudKigmaebriTkykHnkWk();
        return sortIW_KhJyudKigmaebriTkykHnkWk.OrderIW_KhJyudKigmaebriTkykHnkWkByPkAsc(khJyudKigmaebriTkykHnkWkDao.selectAll());
    }

    IW_KhJyudKigmaebriTkykHnkWk getKhJyudKigmaebriTkykHnkWk(String pKouteikanriid) {

        return khJyudKigmaebriTkykHnkWkDao.getKhJyudKigmaebriTkykHnkWk(pKouteikanriid);
    }

    List<IW_KhMkhgkHenkouWk> getAllKhMkhgkHenkouWk(){
        SortIW_KhMkhgkHenkouWk sortIW_KhMkhgkHenkouWk = new SortIW_KhMkhgkHenkouWk();
        return sortIW_KhMkhgkHenkouWk.OrderIW_KhMkhgkHenkouWkByPkAsc(khMkhgkHenkouWkDao.selectAll());
    }

    IW_KhMkhgkHenkouWk getKhMkhgkHenkouWk(String pKouteikanriid) {

        return khMkhgkHenkouWkDao.getKhMkhgkHenkouWk(pKouteikanriid);
    }

    List<IW_KhTmttknitenWk> getAllKhTmttknitenWk(){
        SortIW_KhTmttknitenWk sortIW_KhTmttknitenWk = new SortIW_KhTmttknitenWk();
        return sortIW_KhTmttknitenWk.OrderIW_KhTmttknitenWkByPkAsc(khTmttknitenWkDao.selectAll());
    }

    IW_KhTmttknitenWk getKhTmttknitenWk(String pKouteikanriid) {

        return khTmttknitenWkDao.getKhTmttknitenWk(pKouteikanriid);
    }

    List<IW_KhYendtHnkHrShrWk> getAllKhYendtHnkHrShrWk(){
        SortIW_KhYendtHnkHrShrWk sortIW_KhYendtHnkHrShrWk = new SortIW_KhYendtHnkHrShrWk();
        return sortIW_KhYendtHnkHrShrWk.OrderIW_KhYendtHnkHrShrWkByPkAsc(khYendtHnkHrShrWkDao.selectAll());
    }

    IW_KhYendtHnkHrShrWk getKhYendtHnkHrShrWk(String pKouteikanriid) {

        return khYendtHnkHrShrWkDao.getKhYendtHnkHrShrWk(pKouteikanriid);
    }

    List<IW_KhDShrWk> getAllKhDShrWk(){
        SortIW_KhDShrWk sortIW_KhDShrWk = new SortIW_KhDShrWk();
        return sortIW_KhDShrWk.OrderIW_KhDShrWkByPkAsc(khDShrWkDao.selectAll());
    }

    IW_KhDShrWk getKhDShrWk(String pKouteikanriid) {

        return khDShrWkDao.getKhDShrWk(pKouteikanriid);
    }

    List<IW_KhHaraikataHenkouWk> getAllKhHaraikataHenkouWk(){
        SortIW_KhHaraikataHenkouWk sortIW_KhHaraikataHenkouWk = new SortIW_KhHaraikataHenkouWk();
        return sortIW_KhHaraikataHenkouWk.OrderIW_KhHaraikataHenkouWkByPkAsc(khHaraikataHenkouWkDao.selectAll());
    }

    IW_KhHaraikataHenkouWk getKhHaraikataHenkouWk(String pKouteikanriid) {

        return khHaraikataHenkouWkDao.getKhHaraikataHenkouWk(pKouteikanriid);
    }

    List<IW_KhYendtHnkUktkNiniWk> getAllKhYendtHnkUktkNiniWk(){
        SortIW_KhYendtHnkUktkNiniWk sortIW_KhYendtHnkUktkNiniWk = new SortIW_KhYendtHnkUktkNiniWk();
        return sortIW_KhYendtHnkUktkNiniWk.OrderIW_KhYendtHnkUktkNiniWkByPkAsc(khYendtHnkUktkNiniWkDao.selectAll());
    }

    IW_KhYendtHnkUktkNiniWk getKhYendtHnkUktkNiniWk(String pKouteikanriid) {

        return khYendtHnkUktkNiniWkDao.getKhYendtHnkUktkNiniWk(pKouteikanriid);
    }

    List<IW_KhKzktrkKykDrHnkWk> getAllKhKzktrkKykDrHnkWk(){
        SortIW_KhKzktrkKykDrHnkWk sortIW_KhKzktrkKykDrHnkWk = new SortIW_KhKzktrkKykDrHnkWk();
        return sortIW_KhKzktrkKykDrHnkWk.OrderIW_KhKzktrkKykDrHnkWkByPkAsc(khKzktrkKykDrHnkWkDao.selectAll());
    }

    IW_KhKzktrkKykDrHnkWk getKhKzktrkKykDrHnkWk(String pKouteikanriid) {

        return khKzktrkKykDrHnkWkDao.getKhKzktrkKykDrHnkWk(pKouteikanriid);
    }

}
