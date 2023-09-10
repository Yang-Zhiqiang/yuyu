package yuyu.def.siharai.manager.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_SaigaiHigaitouKbn;
import yuyu.def.classification.C_SaisateiKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_ShiharaikekkadataKbn;
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.classification.C_SyoriJyoutaiKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.dao.JM_ByoumeiDao;
import yuyu.def.db.dao.JM_SyujyutuDao;
import yuyu.def.db.dao.JM_SyujyutuKyuuhuDao;
import yuyu.def.db.dao.JT_MisyuupRendoDao;
import yuyu.def.db.dao.JT_SateiSyouninRirekiDao;
import yuyu.def.db.dao.JT_SiDenpyoDataDao;
import yuyu.def.db.dao.JT_SiDetailDao;
import yuyu.def.db.dao.JT_SiDshrTukiDao;
import yuyu.def.db.dao.JT_SiFBSoukinDataDao;
import yuyu.def.db.dao.JT_SiGaikaFBSoukinDataDao;
import yuyu.def.db.dao.JT_SiKekkaDao;
import yuyu.def.db.dao.JT_SiRirekiDao;
import yuyu.def.db.dao.JT_SiTyousyoDao;
import yuyu.def.db.dao.JT_SibouKariuketsukeDao;
import yuyu.def.db.dao.JT_SkDao;
import yuyu.def.db.dao.JT_SkKihonDao;
import yuyu.def.db.dao.JT_TtdkRirekiDao;
import yuyu.def.db.entity.JM_Byoumei;
import yuyu.def.db.entity.JM_Syujyutu;
import yuyu.def.db.entity.JM_SyujyutuKyuuhu;
import yuyu.def.db.entity.JT_MisyuupRendo;
import yuyu.def.db.entity.JT_SateiSyouninRireki;
import yuyu.def.db.entity.JT_SiDenpyoData;
import yuyu.def.db.entity.JT_SiDetail;
import yuyu.def.db.entity.JT_SiDshrTuki;
import yuyu.def.db.entity.JT_SiFBSoukinData;
import yuyu.def.db.entity.JT_SiGaikaFBSoukinData;
import yuyu.def.db.entity.JT_SiKekka;
import yuyu.def.db.entity.JT_SiRireki;
import yuyu.def.db.entity.JT_SiTyousyo;
import yuyu.def.db.entity.JT_Sk;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.db.entity.JT_TtdkRireki;
import yuyu.def.siharai.result.bean.DoujiSeikyuuInfosBySknoSyonoNeBean;
import yuyu.def.siharai.result.bean.SiDetailInfosBySknoSyonoSeikyuurirekinoBean;
import yuyu.def.siharai.result.bean.SibouKariuketsukeInfosBySeikyuusyubetuSiboukaritrkymdTorikesiflgBean;
import yuyu.def.siharai.result.bean.SkKihonInfosBySyonoHhknnmknSeikyuusyubetuSyoruiukeymdSeikyuurirekinoMaxBean;
import yuyu.def.siharai.sorter.SortJM_Byoumei;
import yuyu.def.siharai.sorter.SortJM_Syujyutu;
import yuyu.def.siharai.sorter.SortJM_SyujyutuKyuuhu;
import yuyu.def.siharai.sorter.SortJT_MisyuupRendo;
import yuyu.def.siharai.sorter.SortJT_SiDenpyoData;
import yuyu.def.siharai.sorter.SortJT_SiDshrTuki;
import yuyu.def.siharai.sorter.SortJT_SiFBSoukinData;
import yuyu.def.siharai.sorter.SortJT_SiGaikaFBSoukinData;
import yuyu.def.siharai.sorter.SortJT_SiKekka;
import yuyu.def.siharai.sorter.SortJT_SiTyousyo;
import yuyu.def.siharai.sorter.SortJT_SkKihon;


/**
 * SeikyuuDomマネージャー<br />
 * Seikyuuにおける、DB操作を提供する。<br />
 */
class SeikyuuDomManager {


    @Inject
    private JM_ByoumeiDao byoumeiDao;


    @Inject
    private JM_SyujyutuDao syujyutuDao;


    @Inject
    private JM_SyujyutuKyuuhuDao syujyutuKyuuhuDao;


    @Inject
    private JT_MisyuupRendoDao misyuupRendoDao;


    @Inject
    private JT_SateiSyouninRirekiDao sateiSyouninRirekiDao;


    @Inject
    private JT_SiDenpyoDataDao siDenpyoDataDao;


    @Inject
    private JT_SiFBSoukinDataDao siFBSoukinDataDao;


    @Inject
    private JT_SiGaikaFBSoukinDataDao siGaikaFBSoukinDataDao;


    @Inject
    private JT_SiKekkaDao siKekkaDao;


    @Inject
    private JT_SiRirekiDao siRirekiDao;


    @Inject
    private JT_SiTyousyoDao siTyousyoDao;


    @Inject
    private JT_SkDao skDao;


    @Inject
    private JT_SkKihonDao skKihonDao;


    @Inject
    private JT_TtdkRirekiDao ttdkRirekiDao;


    @Inject
    private JT_SiDetailDao siDetailDao;


    @Inject
    private JT_SibouKariuketsukeDao sibouKariuketsukeDao;


    @Inject
    private JT_SiDshrTukiDao siDshrTukiDao;

    List<JT_SkKihon> getAllSkKihon(){
        SortJT_SkKihon sortJT_SkKihon = new SortJT_SkKihon();
        return sortJT_SkKihon.OrderJT_SkKihonByPkAsc(skKihonDao.selectAll());
    }


    JT_SkKihon getSkKihon(String pSkno, String pSyono) {

        return skKihonDao.getSkKihon(pSkno, pSyono);
    }


    List<JT_SkKihon> getSkKihonsBySyono(String pSyono) {

        return skKihonDao.getSkKihonsBySyono(pSyono);
    }


    List<JT_SkKihon> getSkKihonsBySyorijyoutaikbnLikeHhknnmkn(C_SyoriJyoutaiKbn pSyorijyoutaikbn, String pHhknnmkn) {

        return skKihonDao.getSkKihonsBySyorijyoutaikbnLikeHhknnmkn(pSyorijyoutaikbn, pHhknnmkn);
    }


    ExDBResults<JT_SkKihon>  getSkKihonsBySeikyuusyubetuSiboukaritrkymdShrkekkakbns(C_SeikyuuSyubetu pSeikyuusyubetu, BizDate pSiboukaritrkymd, C_ShrKekkaKbn... pShrkekkakbn) {

        return skKihonDao.getSkKihonsBySeikyuusyubetuSiboukaritrkymdShrkekkakbns(pSeikyuusyubetu, pSiboukaritrkymd, pShrkekkakbn);
    }


    ExDBResults<JT_SkKihon>  getSkKihonsBySeikyuusyubetuSaisateikbnSiboukaritrkymdShrkekkakbns(C_SeikyuuSyubetu pSeikyuusyubetu, C_SaisateiKbn pSaisateikbn, BizDate pSiboukaritrkymd, BizDate pZennendoKsnbiymd,C_ShrKekkaKbn... pShrkekkakbn) {

        return skKihonDao.getSkKihonsBySeikyuusyubetuSaisateikbnSiboukaritrkymdShrkekkakbns(pSeikyuusyubetu, pSaisateikbn, pSiboukaritrkymd, pZennendoKsnbiymd, pShrkekkakbn);
    }


    ExDBResults<JT_SkKihon>  getSkKihonsByKakutyoujobcdSeikyuusyubetuItems(String pKakutyoujobcd, C_SeikyuuSyubetu pSeikyuusyubetu, BizDate pSiboukaritrkymd, BizDate pTyakkinymd
        , BizDate pShrsyoriymd) {


        ExDBResults<JT_SkKihon> exDBResults = skKihonDao.getSkKihonsByKakutyoujobcdSeikyuusyubetuItems(pSeikyuusyubetu,
            pSiboukaritrkymd, pTyakkinymd, pShrsyoriymd);


        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBResults;
    }


    ExDBResults<JT_SkKihon>  getSkKihonsByKakutyoujobcdSeikyuusyubetuItemsSaisateikbn(String pKakutyoujobcd, C_SeikyuuSyubetu pSeikyuusyubetu, BizDate pSiboukaritrkymd, C_SaisateiKbn pSaisateikbn
        , BizDate pTyakkinymd, BizDate pShrsyoriymd) {


        ExDBResults<JT_SkKihon> exDBResults = skKihonDao.getSkKihonsByKakutyoujobcdSeikyuusyubetuItemsSaisateikbn(pSeikyuusyubetu,
            pSiboukaritrkymd, pSaisateikbn, pTyakkinymd, pShrsyoriymd);


        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBResults;
    }


    ExDBResults<JT_SkKihon>  getSkKihonsByKakutyoujobcdSeikyuusyubetusItem(String pKakutyoujobcd, C_SeikyuuSyubetu pSeikyuusyubetu1, C_SeikyuuSyubetu pSeikyuusyubetu2, BizDate pSiboukaritrkymd) {


        ExDBResults<JT_SkKihon> exDBResults = skKihonDao.getSkKihonsByKakutyoujobcdSeikyuusyubetusItem(pSeikyuusyubetu1, pSeikyuusyubetu2, pSiboukaritrkymd);


        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBResults;
    }


    List<JT_SkKihon> getSkKihonsBySyonoSeikyuusyubetuTorikesiflg(String pSyono, C_SeikyuuSyubetu pSeikyuusyubetu, C_UmuKbn pTorikesiflg) {

        return skKihonDao.getSkKihonsBySyonoSeikyuusyubetuTorikesiflg(pSyono, pSeikyuusyubetu, pTorikesiflg);
    }


    List<JT_SkKihon> getSkKihonsBySyonoSeikyuusyubetu(String pSyono, C_SeikyuuSyubetu pSeikyuusyubetu) {

        return skKihonDao.getSkKihonsBySyonoSeikyuusyubetu(pSyono, pSeikyuusyubetu);
    }


    ExDBUpdatableResults<JT_SkKihon> getSkKihonsByKakutyoujobcdSyorijyoutaikbnShrkekkakbnNe(String pKakutyoujobcd, C_SyoriJyoutaiKbn pSyorijyoutaikbn, C_ShrKekkaKbn pShrkekkakbn) {


        ExDBUpdatableResults<JT_SkKihon> exDBResults = skKihonDao.getSkKihonsByKakutyoujobcdSyorijyoutaikbnShrkekkakbnNe(pSyorijyoutaikbn, pShrkekkakbn);


        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBResults;
    }


    ExDBResults<JT_SkKihon> getSkKihonsBySeikyuusyubetuNeShrsyoriymdShrkekkakbn(BizDate pShrsyoriymdFrom, BizDate pShrsyoriymdTo) {

        return skKihonDao.getSkKihonsBySeikyuusyubetuNeShrsyoriymdShrkekkakbn(pShrsyoriymdFrom, pShrsyoriymdTo);
    }


    ExDBResults<JT_SkKihon> getSkKihonsByShrsyoriymdShrkekkakbnSeikyuusyubetu(BizDate pShrsyoriymd, C_ShrKekkaKbn pShrkekkakbn, C_SeikyuuSyubetu pSeikyuusyubetu) {

        return skKihonDao.getSkKihonsByShrsyoriymdShrkekkakbnSeikyuusyubetu(pShrsyoriymd, pShrkekkakbn, pSeikyuusyubetu);
    }


    ExDBResults<JT_SkKihon> getSkKihonsByKakutyoujobcdSeikyuusyubetuNe(String pKakutyoujobcd, BizDate pShrsyoriymd, C_ShrKekkaKbn pShrkekkakbn, C_SeikyuuSyubetu pSeikyuusyubetu) {


        ExDBResults<JT_SkKihon> exDBResults = skKihonDao.getSkKihonsByKakutyoujobcdSeikyuusyubetuNe(pShrsyoriymd, pShrkekkakbn, pSeikyuusyubetu);


        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBResults;
    }


    List<SkKihonInfosBySyonoHhknnmknSeikyuusyubetuSyoruiukeymdSeikyuurirekinoMaxBean> getSkKihonInfosBySyonoHhknnmknSeikyuusyubetuSyoruiukeymdSeikyuurirekinoMax(String pSyono, String pHhknnmkn, C_SeikyuuSyubetu pSeikyuusyubetu, BizDate pSyoruiukeymdFrom, BizDate pSyoruiukeymdTo) {

        List<Object[]> list = skKihonDao.getSkKihonInfosBySyonoHhknnmknSeikyuusyubetuSyoruiukeymdSeikyuurirekinoMax(pSyono, pHhknnmkn, pSeikyuusyubetu, pSyoruiukeymdFrom, pSyoruiukeymdTo);

        List<SkKihonInfosBySyonoHhknnmknSeikyuusyubetuSyoruiukeymdSeikyuurirekinoMaxBean> returnList = new ArrayList();

        for(Object[] onjs:list){
            SkKihonInfosBySyonoHhknnmknSeikyuusyubetuSyoruiukeymdSeikyuurirekinoMaxBean bean = new SkKihonInfosBySyonoHhknnmknSeikyuusyubetuSyoruiukeymdSeikyuurirekinoMaxBean();

            bean.setSkKihon((JT_SkKihon)onjs[0]);
            bean.setSk((JT_Sk)onjs[1]);

            returnList.add(bean);
        }

        return returnList;
    }


    List<JT_SkKihon> getSkKihonsByHhknnmknTorikesiflg(String pHhknnmkn) {

        return skKihonDao.getSkKihonsByHhknnmknTorikesiflg(pHhknnmkn);
    }


    List<JT_SkKihon> getSkKihonsBySyonoSeikyuusyubetuSaisateikbn(String pSyono, C_SeikyuuSyubetu pSeikyuusyubetu, C_SaisateiKbn pSaisateikbn){

        return skKihonDao.getSkKihonsBySyonoSeikyuusyubetuSaisateikbn(pSyono, pSeikyuusyubetu, pSaisateikbn);
    }


    List<DoujiSeikyuuInfosBySknoSyonoNeBean> getDoujiSeikyuuInfosBySknoSyonoNe(String pSkno, String pSyono) {

        return skKihonDao.getDoujiSeikyuuInfosBySknoSyonoNe(pSkno, pSyono);
    }


    JT_Sk getSkBySknoSyonoMaxSeikyuurirekino(String pSkno, String pSyono) {

        return skDao.getSkBySknoSyonoMaxSeikyuurirekino(pSkno, pSyono);
    }


    Integer getSkMaxSeikyuurirekinoBySknoSyono(String pSkno, String pSyono) {

        return skDao.getSkMaxSeikyuurirekinoBySknoSyono(pSkno, pSyono);
    }


    List<JT_Sk> getSksBySyonoItemsSeikyuurirekinoMax(String pSyono, C_SeikyuuSyubetu pSeikyuusyubetu, C_SaisateiKbn pSaisateikbn, C_SyoriJyoutaiKbn pSyorijyoutaikbn) {

        return skDao.getSksBySyonoItemsSeikyuurirekinoMax(pSyono, pSeikyuusyubetu, pSaisateikbn, pSyorijyoutaikbn);
    }


    List<JT_SiRireki> getSiRirekisBySyonoShrkekkakbnTorikesiflg(String pSyono, C_ShrKekkaKbn pShrkekkakbn, C_UmuKbn pTorikesiflg) {

        return siRirekiDao.getSiRirekisBySyonoShrkekkakbnTorikesiflg(pSyono, pShrkekkakbn, pTorikesiflg);
    }


    List<JT_SiRireki> getSiRirekisBySyonoGyoumuKousinTime(String pSyono, String pGyoumuKousinTime) {

        return siRirekiDao.getSiRirekisBySyonoGyoumuKousinTime(pSyono, pGyoumuKousinTime);
    }


    String getSiRirekiMaxShrsikibetukeyBySknoSyono(String pSkno, String pSyono) {

        return siRirekiDao.getSiRirekiMaxShrsikibetukeyBySknoSyono(pSkno, pSyono);
    }


    List<Object[]> getSiRirekiSkKihonSksBySyonoTorikesiflg(String pSyono, C_UmuKbn pTorikesiflg) {

        return siRirekiDao.getSiRirekiSkKihonSksBySyonoTorikesiflg(pSyono, pTorikesiflg);
    }


    ExDBResults<JT_SiRireki> getSiRirekisBySeikyuusyubetuShrsyoriymdShrkekkakbn(BizDate pShrsyoriymdFrom, BizDate pShrsyoriymdTo) {

        return siRirekiDao.getSiRirekisBySeikyuusyubetuShrsyoriymdShrkekkakbn(pShrsyoriymdFrom, pShrsyoriymdTo);
    }


    ExDBResults<JT_SiRireki> getSiRirekisByShrkekkakbnShrsyoriymdFromShrsyoriymdTo(C_ShrKekkaKbn pShrkekkakbn, BizDate pShrsyoriymdFrom, BizDate pShrsyoriymdTo) {

        return siRirekiDao.getSiRirekisByShrkekkakbnShrsyoriymdFromShrsyoriymdTo(pShrkekkakbn, pShrsyoriymdFrom, pShrsyoriymdTo);
    }


    List<JM_Byoumei> getAllByoumei(){
        SortJM_Byoumei sortJM_Byoumei = new SortJM_Byoumei();
        return sortJM_Byoumei.OrderJM_ByoumeiByPkAsc(byoumeiDao.selectAll());
    }


    JM_Byoumei getByoumei(String pByoumeitourokuno) {

        return byoumeiDao.getByoumei(pByoumeitourokuno);
    }


    List<JM_Byoumei> getByoumeisByByoumeikjByoumeiknByoumeicd(String pByoumeikj, String pByoumeikn, String pByoumeicd) {

        return byoumeiDao.getByoumeisByByoumeikjByoumeiknByoumeicd(pByoumeikj, pByoumeikn, pByoumeicd);
    }


    List<JM_Syujyutu> getAllSyujyutu(){
        SortJM_Syujyutu sortJM_Syujyutu = new SortJM_Syujyutu();
        return sortJM_Syujyutu.OrderJM_SyujyutuByPkAsc(syujyutuDao.selectAll());
    }


    JM_Syujyutu getSyujyutu(String pSyujyututourokuno) {

        return syujyutuDao.getSyujyutu(pSyujyututourokuno);
    }


    List<JM_SyujyutuKyuuhu> getAllSyujyutuKyuuhu(){
        SortJM_SyujyutuKyuuhu sortJM_SyujyutuKyuuhu = new SortJM_SyujyutuKyuuhu();
        return sortJM_SyujyutuKyuuhu.OrderJM_SyujyutuKyuuhuByPkAsc(syujyutuKyuuhuDao.selectAll());
    }


    JM_SyujyutuKyuuhu getSyujyutuKyuuhu(String pSyujyutubunruicd, String pSyouhncd, Integer pSyouhnsdno, String pKyuuhucd, BizDate pSyujyututekiyoukkanfrom
        , BizDate pSyujyututekiyoukkanto) {

        return syujyutuKyuuhuDao.getSyujyutuKyuuhu(pSyujyutubunruicd, pSyouhncd, pSyouhnsdno, pKyuuhucd, pSyujyututekiyoukkanfrom
            , pSyujyututekiyoukkanto);
    }


    List<JT_MisyuupRendo> getAllMisyuupRendo(){
        SortJT_MisyuupRendo sortJT_MisyuupRendo = new SortJT_MisyuupRendo();
        return sortJT_MisyuupRendo.OrderJT_MisyuupRendoByPkAsc(misyuupRendoDao.selectAll());
    }


    JT_MisyuupRendo getMisyuupRendo(String pSyono, Integer pDatarenno) {

        return misyuupRendoDao.getMisyuupRendo(pSyono, pDatarenno);
    }


    List<JT_SiDenpyoData> getAllSiDenpyoData(){
        SortJT_SiDenpyoData sortJT_SiDenpyoData = new SortJT_SiDenpyoData();
        return sortJT_SiDenpyoData.OrderJT_SiDenpyoDataByPkAsc(siDenpyoDataDao.selectAll());
    }


    JT_SiDenpyoData getSiDenpyoData(String pDenrenno, Integer pEdano) {

        return siDenpyoDataDao.getSiDenpyoData(pDenrenno, pEdano);
    }


    List<JT_SiDenpyoData> getSiDenpyoDatasBySyonoSyoriYmdSyoricd(String pSyono, BizDate pSyoriYmd, String pSyoricd) {

        return siDenpyoDataDao.getSiDenpyoDatasBySyonoSyoriYmdSyoricd(pSyono, pSyoriYmd, pSyoricd);
    }


    ExDBUpdatableResults<JT_SiDenpyoData> getSiDenpyoDatasByKakutyoujobcdSyoriYmd(String pKakutyoujobcd, BizDate pSyoriYmd) {


        ExDBUpdatableResults<JT_SiDenpyoData> exDBUpdatableResults = siDenpyoDataDao.getSiDenpyoDatasByKakutyoujobcdSyoriYmd(pSyoriYmd);


        exDBUpdatableResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBUpdatableResults;
    }


    List<JT_SiFBSoukinData> getAllSiFBSoukinData(){
        SortJT_SiFBSoukinData sortJT_SiFBSoukinData = new SortJT_SiFBSoukinData();
        return sortJT_SiFBSoukinData.OrderJT_SiFBSoukinDataByPkAsc(siFBSoukinDataDao.selectAll());
    }


    List<JT_SiFBSoukinData> getSiFBSoukinDatasBySyonoSyoriYmdSyoricd(String pSyono, BizDate pSyoriYmd, String pSyoricd) {

        return siFBSoukinDataDao.getSiFBSoukinDatasBySyonoSyoriYmdSyoricd(pSyono, pSyoriYmd, pSyoricd);
    }


    ExDBResults<JT_SiFBSoukinData> getSiFBSoukinDatasByKakutyoujobcdSyoriYmd(String pKakutyoujobcd, BizDate pSyoriYmd) {


        ExDBResults<JT_SiFBSoukinData> exDBResults = siFBSoukinDataDao.getSiFBSoukinDatasByKakutyoujobcdSyoriYmd(pSyoriYmd);


        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBResults;
    }


    JT_SiFBSoukinData getSiFBSoukinData(String pFbsoukindatasikibetukey) {

        return siFBSoukinDataDao.getSiFBSoukinData(pFbsoukindatasikibetukey);
    }


    List<JT_SiGaikaFBSoukinData> getAllSiGaikaFBSoukinData(){
        SortJT_SiGaikaFBSoukinData sortJT_SiGaikaFBSoukinData = new SortJT_SiGaikaFBSoukinData();
        return sortJT_SiGaikaFBSoukinData.OrderJT_SiGaikaFBSoukinDataByPkAsc(siGaikaFBSoukinDataDao.selectAll());
    }


    List<JT_SiGaikaFBSoukinData> getSiGaikaFBSoukinDatasBySyonoSyoriYmdSyoricd(String pSyono, BizDate pSyoriYmd, String pSyoricd) {

        return siGaikaFBSoukinDataDao.getSiGaikaFBSoukinDatasBySyonoSyoriYmdSyoricd(pSyono, pSyoriYmd, pSyoricd);
    }


    JT_SiGaikaFBSoukinData getSiGaikaFBSoukinData(String pFbsoukindatasikibetukey) {

        return siGaikaFBSoukinDataDao.getSiGaikaFBSoukinData(pFbsoukindatasikibetukey);
    }


    ExDBResults<JT_SiGaikaFBSoukinData> getSiGaikaFBSoukinDatasByKakutyoujobcdSyoriYmd(String pKakutyoujobcd, BizDate pSyoriYmd) {


        ExDBResults<JT_SiGaikaFBSoukinData> exDBResults = siGaikaFBSoukinDataDao.getSiGaikaFBSoukinDatasByKakutyoujobcdSyoriYmd(pSyoriYmd);


        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBResults;
    }


    List<JT_SiKekka> getAllSiKekka(){
        SortJT_SiKekka sortJT_SiKekka = new SortJT_SiKekka();
        return sortJT_SiKekka.OrderJT_SiKekkaByPkAsc(siKekkaDao.selectAll());
    }


    JT_SiKekka getSiKekka(C_ShiharaikekkadataKbn pShiharaikekkadatakbn, String pSyono, String pSyouhncd, Integer pSyouhnsdno, Integer pKyksyouhnrenno
        , C_SyutkKbn pSyutkkbn) {

        return siKekkaDao.getSiKekka(pShiharaikekkadatakbn, pSyono, pSyouhncd, pSyouhnsdno, pKyksyouhnrenno
            , pSyutkkbn);
    }


    ExDBResults<JT_SiKekka> getSiKekkasByKakutyoujobcd(String pKakutyoujobcd) {


        ExDBResults<JT_SiKekka> exDBResults = siKekkaDao.getSiKekkasByKakutyoujobcd();


        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBResults;
    }


    ExDBResults<JT_SiKekka> getSiKekkasByKakutyoujobcdSyoriYmd(String pKakutyoujobcd, BizDate pSyoriYmd) {


        ExDBResults<JT_SiKekka> exDBResults = siKekkaDao.getSiKekkasByKakutyoujobcdSyoriYmd(pSyoriYmd);


        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBResults;
    }


    List<JT_SiKekka> getSiKekkasBySyono(String pSyono) {

        return siKekkaDao.getSiKekkasBySyono(pSyono);
    }


    List<JT_SiKekka> getSiKekkasBySyonoSyoumetujiyuuNe(String pSyono, C_Syoumetujiyuu  pSyoumetujiyuu) {

        return siKekkaDao.getSiKekkasBySyonoSyoumetujiyuuNe(pSyono, pSyoumetujiyuu);
    }


    List<JT_SiTyousyo> getAllSiTyousyo(){
        SortJT_SiTyousyo sortJT_SiTyousyo = new SortJT_SiTyousyo();
        return sortJT_SiTyousyo.OrderJT_SiTyousyoByPkAsc(siTyousyoDao.selectAll());
    }


    JT_SiTyousyo getSiTyousyo(String pSyono, BizDate pTyouhyouymd, Long pShrtysyrenno) {

        return siTyousyoDao.getSiTyousyo(pSyono, pTyouhyouymd, pShrtysyrenno);
    }


    List<JT_SkKihon> getSkKihonsBySyonoSibouKariuketsuke(String pSyono) {

        return skKihonDao.getSkKihonsBySyonoSibouKariuketsuke(pSyono);
    }


    String getTtdkRirekiMaxTtdkrrkskbtkeyBySknoSyono(String pSkno, String pSyono) {

        return ttdkRirekiDao.getTtdkRirekiMaxTtdkrrkskbtkeyBySknoSyono(pSkno, pSyono);
    }


    ExDBResults<JT_TtdkRireki> getTtdkRirekisBySyoriYmdKossyorisscdSyorikekkakbnMaxTtdkrrkskbtkey(BizDate pSyoriYmd, String pKossyorisscd) {

        return ttdkRirekiDao.getTtdkRirekisBySyoriYmdKossyorisscdSyorikekkakbnMaxTtdkrrkskbtkey(pSyoriYmd,pKossyorisscd);
    }


    JT_TtdkRireki getTtdkRirekisBySknoSyonoSyorikekkakbnKossyorisscds(String pSkno, String pSyono, C_SyorikekkaKbn pSyorikekkakbn, String[] pKossyorisscd) {

        return ttdkRirekiDao.getTtdkRirekisBySknoSyonoSyorikekkakbnKossyorisscds(pSkno, pSyono, pSyorikekkakbn, pKossyorisscd);
    }


    JT_TtdkRireki getTtdkRirekisBySknoSyonoSyorikekkakbnsKossyorisscds(String pSkno, String pSyono, String[] pKossyorisscd, C_SyorikekkaKbn... pSyorikekkakbn) {

        return ttdkRirekiDao.getTtdkRirekisBySknoSyonoSyorikekkakbnsKossyorisscds(pSkno, pSyono, pKossyorisscd, pSyorikekkakbn);
    }


    ExDBResults<JT_SateiSyouninRireki>  getSateiSyouninRirekisBySyorikekkakbnSyoriYmdKossyorisscds(C_SyorikekkaKbn pSyorikekkakbn, BizDate pSyoriYmdFrom, BizDate pSyoriYmdTo, String[] pKossyorisscd) {

        return sateiSyouninRirekiDao.getSateiSyouninRirekisBySyorikekkakbnSyoriYmdKossyorisscds(pSyorikekkakbn, pSyoriYmdFrom, pSyoriYmdTo, pKossyorisscd);
    }


    ExDBResults<JT_SateiSyouninRireki> getSaishigaitoulistsBySyorikekkakbnItems(C_SyorikekkaKbn pSyorikekkakbn, String[] pKossyorisscd, BizDate pSyoriYmdFrom, BizDate pSyoriYmdTo, C_SaigaiHigaitouKbn pSaigaihigaitoukbn) {

        return sateiSyouninRirekiDao.getSaishigaitoulistsBySyorikekkakbnItems(pSyorikekkakbn, pKossyorisscd, pSyoriYmdFrom, pSyoriYmdTo, pSaigaihigaitoukbn);
    }


    String getSateiSyouninRirekiMaxSateisyouninskbtkeyBySknoSyono(String pSkno, String pSyono) {

        return sateiSyouninRirekiDao.getSateiSyouninRirekiMaxSateisyouninskbtkeyBySknoSyono(pSkno, pSyono);
    }


    ExDBResults<SibouKariuketsukeInfosBySeikyuusyubetuSiboukaritrkymdTorikesiflgBean> getSibouKariuketsukeInfosBySeikyuusyubetuSiboukaritrkymdTorikesiflg(BizDate pTaisyoukknfrom, BizDate pTaisyoukknto) {

        return skKihonDao.getSibouKariuketsukeInfosBySeikyuusyubetuSiboukaritrkymdTorikesiflg(pTaisyoukknfrom, pTaisyoukknto);
    }


    List<JT_SkKihon> getSkKihonsBySyonoTorikesiflg(String pSyono, C_UmuKbn pTorikesiflg) {

        return skKihonDao.getSkKihonsBySyonoTorikesiflg(pSyono, pTorikesiflg);
    }


    List<SiDetailInfosBySknoSyonoSeikyuurirekinoBean> getSiDetailInfosBySknoSyonoSeikyuurirekino(String pSkno, String pSyono, Integer pSeikyuurirekino) {

        return siDetailDao.getSiDetailInfosBySknoSyonoSeikyuurirekino(pSkno, pSyono, pSeikyuurirekino);
    }


    ExDBResults<JT_SkKihon> getSkKihonsByKakutyoujobcdGaibuinsatuoutymd(String pKakutyoujobcd, BizDate pGaibuinsatuoutymd) {


        ExDBResults<JT_SkKihon> exDBResults = skKihonDao.getSkKihonsByKakutyoujobcdGaibuinsatuoutymd(pGaibuinsatuoutymd);


        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBResults;
    }


    List<JT_SiDetail> getSiDetailsBySknoSyonoSeikyuurirekino(String pSkno, String pSyono, Integer pSeikyuurirekino) {

        return siDetailDao.getSiDetailsBySknoSyonoSeikyuurirekino(pSkno, pSyono, pSeikyuurirekino);
    }


    ExDBResults<JT_SiRireki> getSiRirekisByShrkekkakbnTyakkinymdFromTyakkinymdTo(C_ShrKekkaKbn pShrkekkakbn, BizDate pTyakkinymdFrom, BizDate pTyakkinymdTo) {

        return siRirekiDao.getSiRirekisByShrkekkakbnTyakkinymdFromTyakkinymdTo(pShrkekkakbn, pTyakkinymdFrom, pTyakkinymdTo);
    }


    Long getSibouKariuketsukeCountBySyono(String pSyono){

        return sibouKariuketsukeDao.getSibouKariuketsukeCountBySyono(pSyono);
    }



    List<JT_SiDshrTuki> getAllSiDshrTuki(){
        SortJT_SiDshrTuki sortJT_SiDshrTuki = new SortJT_SiDshrTuki();
        return sortJT_SiDshrTuki.OrderJT_SiDshrTukiByPkAsc(siDshrTukiDao.selectAll());
    }


    JT_SiDshrTuki getSiDshrTuki(String pDshrtoukeisikibetukey) {

        return siDshrTukiDao.getSiDshrTuki(pDshrtoukeisikibetukey);
    }


    JT_SiDshrTuki getSiDshrTukiBySyonoSknoRirekino(String pSyono, String pSkno, Integer pSeikyuurirekino) {

        return siDshrTukiDao.getSiDshrTukiBySyonoSknoRirekino(pSyono, pSkno, pSeikyuurirekino);
    }
}
