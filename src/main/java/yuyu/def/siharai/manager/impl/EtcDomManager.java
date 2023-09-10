package yuyu.def.siharai.manager.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_BknJkuKbn;
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.classification.C_BknrigiKbn;
import yuyu.def.classification.C_GeninKbn;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YobidasimotoTaskKbn;
import yuyu.def.db.dao.JM_ChkSiJimuttdkDao;
import yuyu.def.db.dao.JM_JyudkaigomebrtkWrbkkknDao;
import yuyu.def.db.dao.JM_SiHubiNaiyouDao;
import yuyu.def.db.dao.JM_SiTyouhyoumsgDao;
import yuyu.def.db.dao.JM_SiinHanteiDao;
import yuyu.def.db.dao.JM_SkNaiyouChkDao;
import yuyu.def.db.dao.JT_AksrendouzumiSkKykInfoDao;
import yuyu.def.db.dao.JT_AksrendouzumiSyoruiImgDao;
import yuyu.def.db.dao.JT_SiBikinkanriDao;
import yuyu.def.db.dao.JT_SiJinsokuShrTtdkInfoDao;
import yuyu.def.db.dao.JT_SiSentakuInfoTourokuDao;
import yuyu.def.db.dao.JT_SinsaTyuuiDao;
import yuyu.def.db.entity.JM_ChkSiJimuttdk;
import yuyu.def.db.entity.JM_JyudkaigomebrtkWrbkkkn;
import yuyu.def.db.entity.JM_SiHubiNaiyou;
import yuyu.def.db.entity.JM_SiTyouhyoumsg;
import yuyu.def.db.entity.JM_SiinHantei;
import yuyu.def.db.entity.JM_SkNaiyouChk;
import yuyu.def.db.entity.JT_AksrendouzumiSkKykInfo;
import yuyu.def.db.entity.JT_AksrendouzumiSyoruiImg;
import yuyu.def.db.entity.JT_SiBikinkanri;
import yuyu.def.db.entity.JT_SiJinsokuShrTtdkInfo;
import yuyu.def.db.entity.JT_SiSentakuInfoTouroku;
import yuyu.def.db.entity.JT_SinsaTyuui;
import yuyu.def.siharai.predicate.FilterSiBikinkanriByKessankijyunymdBknrigikbnNe;
import yuyu.def.siharai.predicate.FilterSiBikinkanriBySyonoBknjkukbn;
import yuyu.def.siharai.predicate.FilterSiBikinkanriBySyonoKessankijyunymdBkncdkbn;
import yuyu.def.siharai.predicate.FilterSiBikinkanriBySyonoSkno;
import yuyu.def.siharai.result.bean.SiBikinkanriItemsBySyonoBean;
import yuyu.def.siharai.sorter.SortJM_ChkSiJimuttdk;
import yuyu.def.siharai.sorter.SortJM_JyudkaigomebrtkWrbkkkn;
import yuyu.def.siharai.sorter.SortJM_SiHubiNaiyou;
import yuyu.def.siharai.sorter.SortJM_SiTyouhyoumsg;
import yuyu.def.siharai.sorter.SortJM_SiinHantei;
import yuyu.def.siharai.sorter.SortJM_SkNaiyouChk;
import yuyu.def.siharai.sorter.SortJT_AksrendouzumiSkKykInfo;
import yuyu.def.siharai.sorter.SortJT_AksrendouzumiSyoruiImg;
import yuyu.def.siharai.sorter.SortJT_SiBikinkanri;
import yuyu.def.siharai.sorter.SortJT_SiJinsokuShrTtdkInfo;
import yuyu.def.siharai.sorter.SortJT_SiSentakuInfoTouroku;
import yuyu.def.siharai.sorter.SortJT_SinsaTyuui;

import com.google.common.collect.Collections2;

/**
 * EtcDomマネージャー<br />
 * Etcにおける、DB操作を提供する。<br />
 */
class EtcDomManager {


    @Inject
    private JM_ChkSiJimuttdkDao chkSiJimuttdkDao;


    @Inject
    private JM_JyudkaigomebrtkWrbkkknDao jyudkaigomebrtkWrbkkknDao;


    @Inject
    private JM_SiHubiNaiyouDao siHubiNaiyouDao;


    @Inject
    private JM_SiTyouhyoumsgDao siTyouhyoumsgDao;


    @Inject
    private JM_SiinHanteiDao siinHanteiDao;


    @Inject
    private JM_SkNaiyouChkDao skNaiyouChkDao;


    @Inject
    private JT_AksrendouzumiSkKykInfoDao aksrendouzumiSkKykInfoDao;


    @Inject
    private JT_AksrendouzumiSyoruiImgDao aksrendouzumiSyoruiImgDao;


    @Inject
    private JT_SiBikinkanriDao siBikinkanriDao;


    @Inject
    private JT_SiJinsokuShrTtdkInfoDao siJinsokuShrTtdkInfoDao;


    @Inject
    private JT_SiSentakuInfoTourokuDao siSentakuInfoTourokuDao;


    @Inject
    private JT_SinsaTyuuiDao sinsaTyuuiDao;


    List<JT_SiSentakuInfoTouroku> getAllSiSentakuInfoTouroku() {
        SortJT_SiSentakuInfoTouroku sortJT_SiSentakuInfoTouroku = new SortJT_SiSentakuInfoTouroku();
        return sortJT_SiSentakuInfoTouroku.OrderJT_SiSentakuInfoTourokuByPkAsc(siSentakuInfoTourokuDao.selectAll());
    }


    JT_SiSentakuInfoTouroku getSiSentakuInfoTouroku(String pSyono, Integer pRenno) {

        return siSentakuInfoTourokuDao.getSiSentakuInfoTouroku(pSyono, pRenno);
    }


    ExDBUpdatableResults<JT_SiSentakuInfoTouroku> getSiSentakuInfoTourokusByKakutyoujobcdSyorizumiflg(String pKakutyoujobcd, C_Syorizumiflg pSyorizumiflg) {


        ExDBUpdatableResults<JT_SiSentakuInfoTouroku> exDBUpdatableResults = siSentakuInfoTourokuDao
            .getSiSentakuInfoTourokusByKakutyoujobcdSyorizumiflg(pSyorizumiflg);


        exDBUpdatableResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBUpdatableResults;
    }


    List<JT_SinsaTyuui> getAllSinsaTyuui() {
        SortJT_SinsaTyuui sortJT_SinsaTyuui = new SortJT_SinsaTyuui();
        return sortJT_SinsaTyuui.OrderJT_SinsaTyuuiByPkAsc(sinsaTyuuiDao.selectAll());
    }


    JT_SinsaTyuui getSinsaTyuui(String pSyono) {

        return sinsaTyuuiDao.getSinsaTyuui(pSyono);
    }


    List<JM_SiTyouhyoumsg> getAllSiTyouhyoumsg() {
        SortJM_SiTyouhyoumsg sortJM_SiTyouhyoumsg = new SortJM_SiTyouhyoumsg();
        return sortJM_SiTyouhyoumsg.OrderJM_SiTyouhyoumsgByPkAsc(siTyouhyoumsgDao.selectAll());
    }


    JM_SiTyouhyoumsg getSiTyouhyoumsg(String pBunrui1, String pBunrui2, Integer pTyouhyoulineno) {

        return siTyouhyoumsgDao.getSiTyouhyoumsg(pBunrui1, pBunrui2, pTyouhyoulineno);
    }


    List<JM_SiTyouhyoumsg> getSiTyouhyoumsgsByBunrui1Bunrui2(String pBunrui1, String pBunrui2) {

        return siTyouhyoumsgDao.getSiTyouhyoumsgsByBunrui1Bunrui2(pBunrui1, pBunrui2);
    }


    List<JM_SkNaiyouChk> getAllSkNaiyouChk() {
        SortJM_SkNaiyouChk sortJM_SkNaiyouChk = new SortJM_SkNaiyouChk();
        return sortJM_SkNaiyouChk.OrderJM_SkNaiyouChkByPkAsc(skNaiyouChkDao.selectAll());
    }


    JM_SkNaiyouChk getSkNaiyouChk(C_SKNaiyouChkKbn pSknaiyouchkkbn, C_YobidasimotoTaskKbn pYobidasimototaskkbn) {

        return skNaiyouChkDao.getSkNaiyouChk(pSknaiyouchkkbn, pYobidasimototaskkbn);
    }


    List<JT_AksrendouzumiSyoruiImg> getAllAksrendouzumiSyoruiImg() {
        SortJT_AksrendouzumiSyoruiImg sortJT_AksrendouzumiSyoruiImg = new SortJT_AksrendouzumiSyoruiImg();
        return sortJT_AksrendouzumiSyoruiImg.OrderJT_AksrendouzumiSyoruiImgByPkAsc(aksrendouzumiSyoruiImgDao
            .selectAll());
    }


    JT_AksrendouzumiSyoruiImg getAksrendouzumiSyoruiImg(String pSkno, String pSyono, String pImageid) {

        return aksrendouzumiSyoruiImgDao.getAksrendouzumiSyoruiImg(pSkno, pSyono, pImageid);
    }


    List<JT_AksrendouzumiSkKykInfo> getAllAksrendouzumiSkKykInfo() {
        SortJT_AksrendouzumiSkKykInfo sortJT_AksrendouzumiSkKykInfo = new SortJT_AksrendouzumiSkKykInfo();
        return sortJT_AksrendouzumiSkKykInfo.OrderJT_AksrendouzumiSkKykInfoByPkAsc(aksrendouzumiSkKykInfoDao
            .selectAll());
    }


    JT_AksrendouzumiSkKykInfo getAksrendouzumiSkKykInfo(String pSkno, String pSyono) {

        return aksrendouzumiSkKykInfoDao.getAksrendouzumiSkKykInfo(pSkno, pSyono);
    }


    List<JT_SiJinsokuShrTtdkInfo> getAllSiJinsokuShrTtdkInfo() {
        SortJT_SiJinsokuShrTtdkInfo sortJT_SiJinsokuShrTtdkInfo = new SortJT_SiJinsokuShrTtdkInfo();
        return sortJT_SiJinsokuShrTtdkInfo.OrderJT_SiJinsokuShrTtdkInfoByPkAsc(siJinsokuShrTtdkInfoDao.selectAll());
    }


    JT_SiJinsokuShrTtdkInfo getSiJinsokuShrTtdkInfo(String pSyorisosikicd, String pSyoricd, String pHknknshrsntkno,
        BizDate pSyoruiukeymd, BizDate pSyoriYmd
        , BizDate pDenymd, String pSyono) {

        return siJinsokuShrTtdkInfoDao.getSiJinsokuShrTtdkInfo(pSyorisosikicd, pSyoricd, pHknknshrsntkno,
            pSyoruiukeymd, pSyoriYmd
            , pDenymd, pSyono);
    }


    ExDBResults<JT_SiJinsokuShrTtdkInfo> getSiJinsokuShrTtdkInfosBySyoriYmd(BizDate pSyoriYmdFrom, BizDate pSyoriYmdTo) {

        return siJinsokuShrTtdkInfoDao.getSiJinsokuShrTtdkInfosBySyoriYmd(pSyoriYmdFrom, pSyoriYmdTo);
    }


    List<JM_SiinHantei> getAllSiinHantei() {
        SortJM_SiinHantei sortJM_SiinHantei = new SortJM_SiinHantei();
        return sortJM_SiinHantei.OrderJM_SiinHanteiByPkAsc(siinHanteiDao.selectAll());
    }


    JM_SiinHantei getSiinHantei(C_GeninKbn pSiboukariuketukejigeninkbn, C_GeninKbn pSeikyuuuketukejigeninkbn,
        C_UmuKbn pKansensyouumukbn
        , C_UmuKbn pSaigaikanouseiumukbn, C_UmuKbn pHusyounosiumukbn, C_UmuKbn pSateikaksaigaikanouseikbn,
        C_UmuKbn pSateikakhusyousikbn) {

        return siinHanteiDao.getSiinHantei(pSiboukariuketukejigeninkbn, pSeikyuuuketukejigeninkbn, pKansensyouumukbn
            , pSaigaikanouseiumukbn, pHusyounosiumukbn, pSateikaksaigaikanouseikbn, pSateikakhusyousikbn);
    }


    List<JM_SiHubiNaiyou> getAllSiHubiNaiyou() {
        SortJM_SiHubiNaiyou sortJM_SiHubiNaiyou = new SortJM_SiHubiNaiyou();
        return sortJM_SiHubiNaiyou.OrderJM_SiHubiNaiyouByPkAsc(siHubiNaiyouDao.selectAll());
    }


    List<JM_SiHubiNaiyou> getSiHubiNaiyousByJimutetuzukicdSyoruiCd(String pJimutetuzukicd, C_SyoruiCdKbn pSyoruiCd) {

        return siHubiNaiyouDao.getSiHubiNaiyousByJimutetuzukicdSyoruiCd(pJimutetuzukicd, pSyoruiCd);
    }


    JM_SiHubiNaiyou getSiHubiNaiyou(String pJimutetuzukicd, C_SyoruiCdKbn pSyoruiCd, String pHubinaiyoucd) {

        return siHubiNaiyouDao.getSiHubiNaiyou(pJimutetuzukicd, pSyoruiCd, pHubinaiyoucd);
    }


    List<JT_SiBikinkanri> getAllSiBikinkanri() {
        SortJT_SiBikinkanri sortJT_SiBikinkanri = new SortJT_SiBikinkanri();
        return sortJT_SiBikinkanri.OrderJT_SiBikinkanriByPkAsc(siBikinkanriDao.selectAll());
    }


    JT_SiBikinkanri getSiBikinkanri(String pSkno, String pSyono, BizDate pKessankijyunymd, C_BkncdKbn pBkncdkbn,
        BizDate pBknkktymd, String pKyuuhucd) {

        return siBikinkanriDao.getSiBikinkanri(pSkno, pSyono, pKessankijyunymd, pBkncdkbn, pBknkktymd, pKyuuhucd);
    }


    ExDBResults<JT_SiBikinkanri> getSiBikinkanrisByKakutyoujobcdItemsOrderBy4Items(String pKakutyoujobcd,
        BizDate pKessankijyunymd, C_BknrigiKbn pBknrigikbn) {


        ExDBResults<JT_SiBikinkanri> exDBResults = siBikinkanriDao.getSiBikinkanrisByKakutyoujobcdItemsOrderBy4Items(
            pKessankijyunymd, pBknrigikbn);


        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBResults;
    }


    List<SiBikinkanriItemsBySyonoBean> getSiBikinkanriItemsBySyono(String pSyono) {

        return siBikinkanriDao.getSiBikinkanriItemsBySyono(pSyono);
    }


    ExDBResults<JT_SiBikinkanri> getSiBikinkanrisByKakutyoujobcdItems(String pKakutyoujobcd, BizDate pKessankijyunymd,
        C_BknrigiKbn pBknrigikbn) {


        ExDBResults<JT_SiBikinkanri> exDBResults = siBikinkanriDao.getSiBikinkanrisByKakutyoujobcdItems(pKessankijyunymd, pBknrigikbn);


        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBResults;
    }


    List<JT_SiBikinkanri> getSiBikinkanrisBySyono(String pSyono) {

        return siBikinkanriDao.getSiBikinkanrisBySyono(pSyono);
    }


    List<JT_SiBikinkanri> getSiBikinkanrisBySyonoBknjkukbn(String pSyono) {

        return  new ArrayList<JT_SiBikinkanri>(Collections2.filter(getAllSiBikinkanri(),
            new FilterSiBikinkanriBySyonoBknjkukbn(pSyono)));
    }


    List<JT_SiBikinkanri> getSiBikinkanrisBySyonoSkno(String pSyono, String pSkno) {

        return  new ArrayList<JT_SiBikinkanri>(Collections2.filter(getAllSiBikinkanri(),
            new FilterSiBikinkanriBySyonoSkno(pSyono, pSkno)));
    }


    ExDBResults<JT_SiBikinkanri> getSiBikinkanrisByBknkktymdCalckijyunymdKessankijyunymd(BizDate pBknkktymd,
        BizDate pCalckijyunymd, BizDate pKessankijyunymd) {

        return siBikinkanriDao.getSiBikinkanrisByBknkktymdCalckijyunymdKessankijyunymd(pBknkktymd, pCalckijyunymd,
            pKessankijyunymd);
    }


    ExDBResults<JT_SiBikinkanri> getSiBikinkanrisByBknkktymdItems(BizDate pBknkktymd, BizDate pCalckijyunymd,
        BizDate pKessankijyunymd, C_BknrigiKbn pBknrigikbn) {

        return siBikinkanriDao.getSiBikinkanrisByBknkktymdItems(pBknkktymd, pCalckijyunymd, pKessankijyunymd, pBknrigikbn);
    }


    List<JT_SiBikinkanri> getSiBikinkanrisByKessankijyunymdBknrigikbn(BizDate pKessankijyunymd, C_BknrigiKbn pBknrigikbn) {

        return siBikinkanriDao.getSiBikinkanrisByKessankijyunymdBknrigikbn(pKessankijyunymd, pBknrigikbn);
    }


    List<JT_SiBikinkanri> getSiBikinkanrisByKessankijyunymdBknrigikbnNe(BizDate pKessankijyunymd,
        C_BknrigiKbn pBknrigikbn) {


        List<JT_SiBikinkanri> sibikinkanriLst = new ArrayList<JT_SiBikinkanri>(Collections2.filter(
            getAllSiBikinkanri(),
            new FilterSiBikinkanriByKessankijyunymdBknrigikbnNe(pKessankijyunymd, pBknrigikbn)));

        return sibikinkanriLst;
    }


    List<JT_SiBikinkanri> getSiBikinkanrisBySknoSyonoKessankijyunymdBkncdkbn(String pSkno, String pSyono,
        BizDate pKessankijyunymd, C_BkncdKbn pBkncdkbn) {

        return siBikinkanriDao.getSiBikinkanrisBySknoSyonoKessankijyunymdBkncdkbn(pSkno, pSyono, pKessankijyunymd,
            pBkncdkbn);
    }


    List<JT_SiBikinkanri> getSiBikinkanrisBySyonoKessankijyunymdBkncdkbns(String pSyono, BizDate pKessankijyunymd,
        C_BkncdKbn... pBkncdkbn) {

        return siBikinkanriDao.getSiBikinkanrisBySyonoKessankijyunymdBkncdkbns(pSyono, pKessankijyunymd, pBkncdkbn);
    }


    ExDBResults<JT_SiBikinkanri> getSiBikinkanrisByKessankijyunymdBknrigikbnEx(BizDate pKessankijyunymd,
        C_BknrigiKbn pBknrigikbn) {

        return siBikinkanriDao.getSiBikinkanrisByKessankijyunymdBknrigikbnEx(pKessankijyunymd, pBknrigikbn);
    }


    List<JT_SiBikinkanri> getSiBikinkanrisBySyonoKessankijyunymdBkncdkbn(String pSyono, BizDate pKessankijyunymd) {

        return new ArrayList<JT_SiBikinkanri>(Collections2.filter(getAllSiBikinkanri(),
            new FilterSiBikinkanriBySyonoKessankijyunymdBkncdkbn(pSyono, pKessankijyunymd)));
    }


    List<JM_JyudkaigomebrtkWrbkkkn> getAllJyudkaigomebrtkWrbkkkn(){
        SortJM_JyudkaigomebrtkWrbkkkn sortJM_JyudkaigomebrtkWrbkkkn = new SortJM_JyudkaigomebrtkWrbkkkn();
        return sortJM_JyudkaigomebrtkWrbkkkn.OrderJM_JyudkaigomebrtkWrbkkknByPkAsc(jyudkaigomebrtkWrbkkknDao.selectAll());
    }


    JM_JyudkaigomebrtkWrbkkkn getJyudkaigomebrtkWrbkkkn(Integer pHhknnen, C_Seibetu pSeibetu) {

        return jyudkaigomebrtkWrbkkknDao.getJyudkaigomebrtkWrbkkkn(pHhknnen, pSeibetu);
    }


    ExDBResults<JT_SiBikinkanri> getSiBikinkanrisByKessankijyunymdBknrigikbnOrderByBkntyousafsyorikbnSyono(BizDate pKessankijyunymd,
        C_BknrigiKbn pBknrigikbn) {

        return siBikinkanriDao.getSiBikinkanrisByKessankijyunymdBknrigikbnOrderByBkntyousafsyorikbnSyono(pKessankijyunymd, pBknrigikbn);
    }


    ExDBResults<JT_SiBikinkanri> getSiBikinkanrisByZennouseisankin(BizDate pKessankijyunymd, C_UmuKbn pZennouseisankinumukbn, C_ShrKekkaKbn pShrkekkakbn, C_BknrigiKbn pBknrigikbn) {

        return siBikinkanriDao.getSiBikinkanrisByZennouseisankin(pKessankijyunymd, pZennouseisankinumukbn, pShrkekkakbn, pBknrigikbn);
    }


    ExDBResults<JT_SiBikinkanri> getSiBikinkanrisByMikeikap(BizDate pKessankijyunymd, C_UmuKbn pMikeikapumukbn, C_ShrKekkaKbn pShrkekkakbn, C_BknrigiKbn pBknrigikbn) {

        return siBikinkanriDao.getSiBikinkanrisByMikeikap(pKessankijyunymd, pMikeikapumukbn, pShrkekkakbn, pBknrigikbn);
    }


    ExDBResults<JT_SiBikinkanri> getSiBikinkanrisByMisyup(BizDate pKessankijyunymd, C_UmuKbn pMisyuupumukbn, C_ShrKekkaKbn pShrkekkakbn, C_BknrigiKbn pBknrigikbn) {

        return siBikinkanriDao.getSiBikinkanrisByMisyup(pKessankijyunymd, pMisyuupumukbn, pShrkekkakbn, pBknrigikbn);
    }


    List<JM_ChkSiJimuttdk> getAllChkSiJimuttdk(){
        SortJM_ChkSiJimuttdk sortJM_ChkSiJimuttdk = new SortJM_ChkSiJimuttdk();
        return sortJM_ChkSiJimuttdk.OrderJM_ChkSiJimuttdkByPkAsc(chkSiJimuttdkDao.selectAll());
    }


    JM_ChkSiJimuttdk getChkSiJimuttdk(String pKinouId, String pSyorijimuttdkcd) {

        return chkSiJimuttdkDao.getChkSiJimuttdk(pKinouId, pSyorijimuttdkcd);
    }


    public ExDBResults<JT_SiBikinkanri> getSiBikinkanrisByKsnYmdBknJkuKbnBknrigikbnEx(BizDate pKessankijyunymd,C_BknJkuKbn pBknJkuKbn,C_BknrigiKbn pBknrigiKbn) {

        return siBikinkanriDao.getSiBikinkanrisByKsnYmdBknJkuKbnBknrigikbnEx(pKessankijyunymd, pBknJkuKbn, pBknrigiKbn);
    }


    public List<JT_SiBikinkanri> getSiBikinkanrisBySyonoKsnYmdJkukbnRigikbnNe(String pSyono, BizDate pKessankijyunymd,
        C_BknJkuKbn pBknJkuKbn,C_BknrigiKbn pBknrigiKbn) {

        return siBikinkanriDao.getSiBikinkanrisBySyonoKsnYmdJkukbnRigikbnNe(pSyono,  pKessankijyunymd, pBknJkuKbn, pBknrigiKbn) ;

    }



}
