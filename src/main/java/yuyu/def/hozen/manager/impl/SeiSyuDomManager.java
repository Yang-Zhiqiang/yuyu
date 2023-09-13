package yuyu.def.hozen.manager.impl;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.def.classification.C_AnsyuusysKbn;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.db.dao.IT_BAK_KhAuthoriDataDao;
import yuyu.def.db.dao.IT_ChkYukokekkaDataDao;
import yuyu.def.db.dao.IT_ChkYuukouseiDao;
import yuyu.def.db.dao.IT_KhAuthoriDataDao;
import yuyu.def.db.dao.IT_KhAuthoriKekDataDao;
import yuyu.def.db.dao.IT_KhKouzahuriAnnaiDataDao;
import yuyu.def.db.dao.IT_KhSyuunouKekkaDataDao;
import yuyu.def.db.dao.IT_KhUriageDataDao;
import yuyu.def.db.dao.IT_KhUriageKekkaDataDao;
import yuyu.def.db.dao.IT_KhUriageSeikyuuKekkaDataDao;
import yuyu.def.db.dao.IT_UriageSkDataSyuKnrDao;
import yuyu.def.db.dao.IT_YuukouKakKekkaKikykDao;
import yuyu.def.db.dao.IT_YuukouKakKekkaSkDao;
import yuyu.def.db.entity.IT_BAK_KhAuthoriData;
import yuyu.def.db.entity.IT_ChkYukokekkaData;
import yuyu.def.db.entity.IT_ChkYuukousei;
import yuyu.def.db.entity.IT_KhAuthoriData;
import yuyu.def.db.entity.IT_KhAuthoriKekData;
import yuyu.def.db.entity.IT_KhKouzahuriAnnaiData;
import yuyu.def.db.entity.IT_KhSyuunouKekkaData;
import yuyu.def.db.entity.IT_KhUriageData;
import yuyu.def.db.entity.IT_KhUriageKekkaData;
import yuyu.def.db.entity.IT_KhUriageSeikyuuKekkaData;
import yuyu.def.db.entity.IT_UriageSkDataSyuKnr;
import yuyu.def.db.entity.IT_YuukouKakKekkaKikyk;
import yuyu.def.db.entity.IT_YuukouKakKekkaSk;
import yuyu.def.hozen.sorter.SortIT_BAK_KhAuthoriData;
import yuyu.def.hozen.sorter.SortIT_ChkYukokekkaData;
import yuyu.def.hozen.sorter.SortIT_ChkYuukousei;
import yuyu.def.hozen.sorter.SortIT_KhAuthoriData;
import yuyu.def.hozen.sorter.SortIT_KhAuthoriKekData;
import yuyu.def.hozen.sorter.SortIT_KhKouzahuriAnnaiData;
import yuyu.def.hozen.sorter.SortIT_KhSyuunouKekkaData;
import yuyu.def.hozen.sorter.SortIT_KhUriageData;
import yuyu.def.hozen.sorter.SortIT_KhUriageKekkaData;
import yuyu.def.hozen.sorter.SortIT_KhUriageSeikyuuKekkaData;
import yuyu.def.hozen.sorter.SortIT_UriageSkDataSyuKnr;
import yuyu.def.hozen.sorter.SortIT_YuukouKakKekkaKikyk;
import yuyu.def.hozen.sorter.SortIT_YuukouKakKekkaSk;


/**
 * SeiSyuDomマネージャー<br />
 * SeiSyuにおける、DB操作を提供する。<br />
 */
class SeiSyuDomManager {

    @Inject
    private IT_BAK_KhAuthoriDataDao bAK_KhAuthoriDataDao;

    @Inject
    private IT_ChkYukokekkaDataDao chkYukokekkaDataDao;

    @Inject
    private IT_ChkYuukouseiDao chkYuukouseiDao;

    @Inject
    private IT_KhAuthoriDataDao khAuthoriDataDao;

    @Inject
    private IT_KhAuthoriKekDataDao khAuthoriKekDataDao;

    @Inject
    private IT_KhKouzahuriAnnaiDataDao khKouzahuriAnnaiDataDao;

    @Inject
    private IT_KhSyuunouKekkaDataDao khSyuunouKekkaDataDao;

    @Inject
    private IT_KhUriageDataDao khUriageDataDao;

    @Inject
    private IT_KhUriageKekkaDataDao khUriageKekkaDataDao;

    @Inject
    private IT_KhUriageSeikyuuKekkaDataDao khUriageSeikyuuKekkaDataDao;

    @Inject
    private IT_UriageSkDataSyuKnrDao uriageSkDataSyuKnrDao;

    @Inject
    private IT_YuukouKakKekkaKikykDao yuukouKakKekkaKikykDao;

    @Inject
    private IT_YuukouKakKekkaSkDao yuukouKakKekkaSkDao;

    List<IT_ChkYuukousei> getAllChkYuukousei(){
        SortIT_ChkYuukousei sortIT_ChkYuukousei = new SortIT_ChkYuukousei();
        return sortIT_ChkYuukousei.OrderIT_ChkYuukouseiByPkAsc(chkYuukouseiDao.selectAll());
    }

    IT_ChkYuukousei getChkYuukousei(C_AnsyuusysKbn pAnsyuusyskbn, BizDate pSyoriYmd, String pSyono) {

        return chkYuukouseiDao.getChkYuukousei(pAnsyuusyskbn, pSyoriYmd, pSyono);
    }

    List<IT_KhKouzahuriAnnaiData> getAllKhKouzahuriAnnaiData(){
        SortIT_KhKouzahuriAnnaiData sortIT_KhKouzahuriAnnaiData = new SortIT_KhKouzahuriAnnaiData();
        return sortIT_KhKouzahuriAnnaiData.OrderIT_KhKouzahuriAnnaiDataByPkAsc(khKouzahuriAnnaiDataDao.selectAll());
    }

    IT_KhKouzahuriAnnaiData getKhKouzahuriAnnaiData(C_AnsyuusysKbn pAnsyuusyskbn, BizDate pSyoriYmd, String pSyono, C_NyknaiyouKbn pNyknaiyoukbn, BizDateYM pJyuutouym) {

        return khKouzahuriAnnaiDataDao.getKhKouzahuriAnnaiData(pAnsyuusyskbn, pSyoriYmd, pSyono, pNyknaiyoukbn, pJyuutouym);
    }

    List<IT_ChkYukokekkaData> getAllChkYukokekkaData(){
        SortIT_ChkYukokekkaData sortIT_ChkYukokekkaData = new SortIT_ChkYukokekkaData();
        return sortIT_ChkYukokekkaData.OrderIT_ChkYukokekkaDataByPkAsc(chkYukokekkaDataDao.selectAll());
    }

    IT_ChkYukokekkaData getChkYukokekkaData(C_AnsyuusysKbn pAnsyuusyskbn, String pYuukoukekkarenno) {

        return chkYukokekkaDataDao.getChkYukokekkaData(pAnsyuusyskbn, pYuukoukekkarenno);
    }

    List<IT_KhUriageKekkaData> getAllKhUriageKekkaData(){
        SortIT_KhUriageKekkaData sortIT_KhUriageKekkaData = new SortIT_KhUriageKekkaData();
        return sortIT_KhUriageKekkaData.OrderIT_KhUriageKekkaDataByPkAsc(khUriageKekkaDataDao.selectAll());
    }

    IT_KhUriageKekkaData getKhUriageKekkaData(C_AnsyuusysKbn pAnsyuusyskbn, String pUriagekekkadatarenno) {

        return khUriageKekkaDataDao.getKhUriageKekkaData(pAnsyuusyskbn, pUriagekekkadatarenno);
    }

    List<IT_KhAuthoriData> getAllKhAuthoriData(){
        SortIT_KhAuthoriData sortIT_KhAuthoriData = new SortIT_KhAuthoriData();
        return sortIT_KhAuthoriData.OrderIT_KhAuthoriDataByPkAsc(khAuthoriDataDao.selectAll());
    }

    IT_KhAuthoriData getKhAuthoriData(C_AnsyuusysKbn pAnsyuusyskbn, BizDate pSyoriYmd, String pSyono, Integer pAuthorikaisuu) {

        return khAuthoriDataDao.getKhAuthoriData(pAnsyuusyskbn, pSyoriYmd, pSyono, pAuthorikaisuu);
    }

    List<IT_BAK_KhAuthoriData> getAllBAKKhAuthoriData(){
        SortIT_BAK_KhAuthoriData sortIT_BAK_KhAuthoriData = new SortIT_BAK_KhAuthoriData();
        return sortIT_BAK_KhAuthoriData.OrderIT_BAK_KhAuthoriDataByPkAsc(bAK_KhAuthoriDataDao.selectAll());
    }

    IT_BAK_KhAuthoriData getBAKKhAuthoriData(C_AnsyuusysKbn pAnsyuusyskbn, String pTrkssikibetukey, BizDate pSyoriYmd, String pSyono, Integer pAuthorikaisuu) {

        return bAK_KhAuthoriDataDao.getBAKKhAuthoriData(pAnsyuusyskbn, pTrkssikibetukey, pSyoriYmd, pSyono, pAuthorikaisuu);
    }

    List<IT_KhUriageData> getAllKhUriageData(){
        SortIT_KhUriageData sortIT_KhUriageData = new SortIT_KhUriageData();
        return sortIT_KhUriageData.OrderIT_KhUriageDataByPkAsc(khUriageDataDao.selectAll());
    }

    IT_KhUriageData getKhUriageData(C_AnsyuusysKbn pAnsyuusyskbn, BizDate pSyoriYmd, String pSyono, Integer pAuthorikaisuu) {

        return khUriageDataDao.getKhUriageData(pAnsyuusyskbn, pSyoriYmd, pSyono, pAuthorikaisuu);
    }

    List<IT_KhAuthoriKekData> getAllKhAuthoriKekData(){
        SortIT_KhAuthoriKekData sortIT_KhAuthoriKekData = new SortIT_KhAuthoriKekData();
        return sortIT_KhAuthoriKekData.OrderIT_KhAuthoriKekDataByPkAsc(khAuthoriKekDataDao.selectAll());
    }

    IT_KhAuthoriKekData getKhAuthoriKekData(C_AnsyuusysKbn pAnsyuusyskbn, String pAuthorikkdatarenno) {

        return khAuthoriKekDataDao.getKhAuthoriKekData(pAnsyuusyskbn, pAuthorikkdatarenno);
    }

    List<IT_KhSyuunouKekkaData> getAllKhSyuunouKekkaData(){
        SortIT_KhSyuunouKekkaData sortIT_KhSyuunouKekkaData = new SortIT_KhSyuunouKekkaData();
        return sortIT_KhSyuunouKekkaData.OrderIT_KhSyuunouKekkaDataByPkAsc(khSyuunouKekkaDataDao.selectAll());
    }

    IT_KhSyuunouKekkaData getKhSyuunouKekkaData(C_AnsyuusysKbn pAnsyuusyskbn, BizDate pSyoriYmd, String pSyono, BizDateYM pJyuutouym) {

        return khSyuunouKekkaDataDao.getKhSyuunouKekkaData(pAnsyuusyskbn, pSyoriYmd, pSyono, pJyuutouym);
    }

    List<IT_KhUriageSeikyuuKekkaData> getAllKhUriageSeikyuuKekkaData(){
        SortIT_KhUriageSeikyuuKekkaData sortIT_KhUriageSeikyuuKekkaData = new SortIT_KhUriageSeikyuuKekkaData();
        return sortIT_KhUriageSeikyuuKekkaData.OrderIT_KhUriageSeikyuuKekkaDataByPkAsc(khUriageSeikyuuKekkaDataDao.selectAll());
    }

    IT_KhUriageSeikyuuKekkaData getKhUriageSeikyuuKekkaData(String pSyono, String pCreditkessaiyouno, BizDate pUriagenengappi, Integer pRenno3keta) {

        return khUriageSeikyuuKekkaDataDao.getKhUriageSeikyuuKekkaData(pSyono, pCreditkessaiyouno, pUriagenengappi, pRenno3keta);
    }

    List<IT_YuukouKakKekkaKikyk> getAllYuukouKakKekkaKikyk(){
        SortIT_YuukouKakKekkaKikyk sortIT_YuukouKakKekkaKikyk = new SortIT_YuukouKakKekkaKikyk();
        return sortIT_YuukouKakKekkaKikyk.OrderIT_YuukouKakKekkaKikykByPkAsc(yuukouKakKekkaKikykDao.selectAll());
    }

    IT_YuukouKakKekkaKikyk getYuukouKakKekkaKikyk(String pCreditkessaiyouno) {

        return yuukouKakKekkaKikykDao.getYuukouKakKekkaKikyk(pCreditkessaiyouno);
    }

    List<IT_YuukouKakKekkaSk> getAllYuukouKakKekkaSk(){
        SortIT_YuukouKakKekkaSk sortIT_YuukouKakKekkaSk = new SortIT_YuukouKakKekkaSk();
        return sortIT_YuukouKakKekkaSk.OrderIT_YuukouKakKekkaSkByPkAsc(yuukouKakKekkaSkDao.selectAll());
    }

    IT_YuukouKakKekkaSk getYuukouKakKekkaSk(String pCreditkessaiyouno) {

        return yuukouKakKekkaSkDao.getYuukouKakKekkaSk(pCreditkessaiyouno);
    }

    List<IT_UriageSkDataSyuKnr> getAllUriageSkDataSyuKnr(){
        SortIT_UriageSkDataSyuKnr sortIT_UriageSkDataSyuKnr = new SortIT_UriageSkDataSyuKnr();
        return sortIT_UriageSkDataSyuKnr.OrderIT_UriageSkDataSyuKnrByPkAsc(uriageSkDataSyuKnrDao.selectAll());
    }

    IT_UriageSkDataSyuKnr getUriageSkDataSyuKnr(String pSyono, String pCreditkessaiyouno, BizDate pUriagenengappi, Integer pRenno3keta) {

        return uriageSkDataSyuKnrDao.getUriageSkDataSyuKnr(pSyono, pCreditkessaiyouno, pUriagenengappi, pRenno3keta);
    }

}
