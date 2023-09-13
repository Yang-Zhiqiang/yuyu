package yuyu.def.hozen.manager.impl;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.dao.IT_BunrimaeAuthoriKekkaDao;
import yuyu.def.db.dao.IT_KhTRAuthoriKekkaHihojiDao;
import yuyu.def.db.dao.IT_SkCreditCardTourokuKekkaDao;
import yuyu.def.db.dao.IT_TRAuthoriKekkaDao;
import yuyu.def.db.dao.IT_TRChkYukokekkaDao;
import yuyu.def.db.dao.IT_TRCreditKurikosiMinyuuDao;
import yuyu.def.db.dao.IT_TRDattaiDao;
import yuyu.def.db.dao.IT_TRGinkouTouhaigouDao;
import yuyu.def.db.dao.IT_TRKzhuriKurikosiMinyuuDao;
import yuyu.def.db.dao.IT_TRMinyuuDao;
import yuyu.def.db.dao.IT_TRNyuukinDao;
import yuyu.def.db.dao.IW_KhKzkPYokuJyuutouYoteiWkDao;
import yuyu.def.db.entity.IT_BunrimaeAuthoriKekka;
import yuyu.def.db.entity.IT_KhTRAuthoriKekkaHihoji;
import yuyu.def.db.entity.IT_SkCreditCardTourokuKekka;
import yuyu.def.db.entity.IT_TRAuthoriKekka;
import yuyu.def.db.entity.IT_TRChkYukokekka;
import yuyu.def.db.entity.IT_TRCreditKurikosiMinyuu;
import yuyu.def.db.entity.IT_TRDattai;
import yuyu.def.db.entity.IT_TRGinkouTouhaigou;
import yuyu.def.db.entity.IT_TRKzhuriKurikosiMinyuu;
import yuyu.def.db.entity.IT_TRMinyuu;
import yuyu.def.db.entity.IT_TRNyuukin;
import yuyu.def.db.entity.IW_KhKzkPYokuJyuutouYoteiWk;
import yuyu.def.hozen.sorter.SortIT_BunrimaeAuthoriKekka;
import yuyu.def.hozen.sorter.SortIT_KhTRAuthoriKekkaHihoji;
import yuyu.def.hozen.sorter.SortIT_SkCreditCardTourokuKekka;
import yuyu.def.hozen.sorter.SortIT_TRAuthoriKekka;
import yuyu.def.hozen.sorter.SortIT_TRChkYukokekka;
import yuyu.def.hozen.sorter.SortIT_TRCreditKurikosiMinyuu;
import yuyu.def.hozen.sorter.SortIT_TRDattai;
import yuyu.def.hozen.sorter.SortIT_TRGinkouTouhaigou;
import yuyu.def.hozen.sorter.SortIT_TRKzhuriKurikosiMinyuu;
import yuyu.def.hozen.sorter.SortIT_TRMinyuu;
import yuyu.def.hozen.sorter.SortIT_TRNyuukin;
import yuyu.def.hozen.sorter.SortIW_KhKzkPYokuJyuutouYoteiWk;


/**
 * TranDomマネージャー<br />
 * Tranにおける、DB操作を提供する。<br />
 */
class TranDomManager {

    @Inject
    private IT_BunrimaeAuthoriKekkaDao bunrimaeAuthoriKekkaDao;

    @Inject
    private IT_TRAuthoriKekkaDao tRAuthoriKekkaDao;

    @Inject
    private IT_TRChkYukokekkaDao tRChkYukokekkaDao;

    @Inject
    private IT_TRDattaiDao tRDattaiDao;

    @Inject
    private IT_TRGinkouTouhaigouDao tRGinkouTouhaigouDao;

    @Inject
    private IT_TRMinyuuDao tRMinyuuDao;

    @Inject
    private IT_TRNyuukinDao tRNyuukinDao;

    @Inject
    private IW_KhKzkPYokuJyuutouYoteiWkDao khKzkPYokuJyuutouYoteiWkDao;

    @Inject
    private IT_KhTRAuthoriKekkaHihojiDao khTRAuthoriKekkaHihojiDao;

    @Inject
    private IT_SkCreditCardTourokuKekkaDao skCreditCardTourokuKekkaDao;

    @Inject
    private IT_TRCreditKurikosiMinyuuDao tRCreditKurikosiMinyuuDao;

    @Inject
    private IT_TRKzhuriKurikosiMinyuuDao tRKzhuriKurikosiMinyuuDao;

    List<IT_TRDattai> getAllTRDattai(){
        SortIT_TRDattai sortIT_TRDattai = new SortIT_TRDattai();
        return sortIT_TRDattai.OrderIT_TRDattaiByPkAsc(tRDattaiDao.selectAll());
    }

    IT_TRDattai getTRDattai(String pSyono, BizDate pSyoriYmd, String pDattaitrrenno) {

        return tRDattaiDao.getTRDattai(pSyono, pSyoriYmd, pDattaitrrenno);
    }

    List<IT_TRAuthoriKekka> getAllTRAuthoriKekka(){
        SortIT_TRAuthoriKekka sortIT_TRAuthoriKekka = new SortIT_TRAuthoriKekka();
        return sortIT_TRAuthoriKekka.OrderIT_TRAuthoriKekkaByPkAsc(tRAuthoriKekkaDao.selectAll());
    }

    IT_TRAuthoriKekka getTRAuthoriKekka(String pSyono, BizDate pSyoriYmd, String pAuthorikktrrenno) {

        return tRAuthoriKekkaDao.getTRAuthoriKekka(pSyono, pSyoriYmd, pAuthorikktrrenno);
    }

    List<IT_TRNyuukin> getAllTRNyuukin(){
        SortIT_TRNyuukin sortIT_TRNyuukin = new SortIT_TRNyuukin();
        return sortIT_TRNyuukin.OrderIT_TRNyuukinByPkAsc(tRNyuukinDao.selectAll());
    }

    IT_TRNyuukin getTRNyuukin(String pSyono, BizDate pSyoriYmd, String pNyktrrenno, Integer pDatarenno) {

        return tRNyuukinDao.getTRNyuukin(pSyono, pSyoriYmd, pNyktrrenno, pDatarenno);
    }

    List<IT_TRMinyuu> getAllTRMinyuu(){
        SortIT_TRMinyuu sortIT_TRMinyuu = new SortIT_TRMinyuu();
        return sortIT_TRMinyuu.OrderIT_TRMinyuuByPkAsc(tRMinyuuDao.selectAll());
    }

    IT_TRMinyuu getTRMinyuu(String pSyono, BizDate pSyoriYmd, String pMinyuutrrenno) {

        return tRMinyuuDao.getTRMinyuu(pSyono, pSyoriYmd, pMinyuutrrenno);
    }

    List<IT_TRChkYukokekka> getAllTRChkYukokekka(){
        SortIT_TRChkYukokekka sortIT_TRChkYukokekka = new SortIT_TRChkYukokekka();
        return sortIT_TRChkYukokekka.OrderIT_TRChkYukokekkaByPkAsc(tRChkYukokekkaDao.selectAll());
    }

    IT_TRChkYukokekka getTRChkYukokekka(String pSyono, BizDate pSyoriYmd, String pYuukoutrrenno) {

        return tRChkYukokekkaDao.getTRChkYukokekka(pSyono, pSyoriYmd, pYuukoutrrenno);
    }

    List<IT_TRGinkouTouhaigou> getAllTRGinkouTouhaigou(){
        SortIT_TRGinkouTouhaigou sortIT_TRGinkouTouhaigou = new SortIT_TRGinkouTouhaigou();
        return sortIT_TRGinkouTouhaigou.OrderIT_TRGinkouTouhaigouByPkAsc(tRGinkouTouhaigouDao.selectAll());
    }

    IT_TRGinkouTouhaigou getTRGinkouTouhaigou(String pBfrikkatuseibibankcd, String pBfrikkatuseibisitencd) {

        return tRGinkouTouhaigouDao.getTRGinkouTouhaigou(pBfrikkatuseibibankcd, pBfrikkatuseibisitencd);
    }

    List<IW_KhKzkPYokuJyuutouYoteiWk> getAllKhKzkPYokuJyuutouYoteiWk(){
        SortIW_KhKzkPYokuJyuutouYoteiWk sortIW_KhKzkPYokuJyuutouYoteiWk = new SortIW_KhKzkPYokuJyuutouYoteiWk();
        return sortIW_KhKzkPYokuJyuutouYoteiWk.OrderIW_KhKzkPYokuJyuutouYoteiWkByPkAsc(khKzkPYokuJyuutouYoteiWkDao.selectAll());
    }

    IW_KhKzkPYokuJyuutouYoteiWk getKhKzkPYokuJyuutouYoteiWk(String pSyono) {

        return khKzkPYokuJyuutouYoteiWkDao.getKhKzkPYokuJyuutouYoteiWk(pSyono);
    }

    List<IT_TRCreditKurikosiMinyuu> getAllTRCreditKurikosiMinyuu(){
        SortIT_TRCreditKurikosiMinyuu sortIT_TRCreditKurikosiMinyuu = new SortIT_TRCreditKurikosiMinyuu();
        return sortIT_TRCreditKurikosiMinyuu.OrderIT_TRCreditKurikosiMinyuuByPkAsc(tRCreditKurikosiMinyuuDao.selectAll());
    }

    IT_TRCreditKurikosiMinyuu getTRCreditKurikosiMinyuu(String pSyono, BizDate pSyoriYmd, String pMinyuutrrenno) {

        return tRCreditKurikosiMinyuuDao.getTRCreditKurikosiMinyuu(pSyono, pSyoriYmd, pMinyuutrrenno);
    }

    List<IT_TRKzhuriKurikosiMinyuu> getAllTRKzhuriKurikosiMinyuu(){
        SortIT_TRKzhuriKurikosiMinyuu sortIT_TRKzhuriKurikosiMinyuu = new SortIT_TRKzhuriKurikosiMinyuu();
        return sortIT_TRKzhuriKurikosiMinyuu.OrderIT_TRKzhuriKurikosiMinyuuByPkAsc(tRKzhuriKurikosiMinyuuDao.selectAll());
    }

    IT_TRKzhuriKurikosiMinyuu getTRKzhuriKurikosiMinyuu(String pSyono, BizDate pSyoriYmd, String pMinyuutrrenno) {

        return tRKzhuriKurikosiMinyuuDao.getTRKzhuriKurikosiMinyuu(pSyono, pSyoriYmd, pMinyuutrrenno);
    }

    List<IT_KhTRAuthoriKekkaHihoji> getAllKhTRAuthoriKekkaHihoji(){
        SortIT_KhTRAuthoriKekkaHihoji sortIT_KhTRAuthoriKekkaHihoji = new SortIT_KhTRAuthoriKekkaHihoji();
        return sortIT_KhTRAuthoriKekkaHihoji.OrderIT_KhTRAuthoriKekkaHihojiByPkAsc(khTRAuthoriKekkaHihojiDao.selectAll());
    }

    IT_KhTRAuthoriKekkaHihoji getKhTRAuthoriKekkaHihoji(String pCreditkessaiyouno, BizDate pSyoriYmd) {

        return khTRAuthoriKekkaHihojiDao.getKhTRAuthoriKekkaHihoji(pCreditkessaiyouno, pSyoriYmd);
    }

    List<IT_BunrimaeAuthoriKekka> getAllBunrimaeAuthoriKekka(){
        SortIT_BunrimaeAuthoriKekka sortIT_BunrimaeAuthoriKekka = new SortIT_BunrimaeAuthoriKekka();
        return sortIT_BunrimaeAuthoriKekka.OrderIT_BunrimaeAuthoriKekkaByPkAsc(bunrimaeAuthoriKekkaDao.selectAll());
    }

    IT_BunrimaeAuthoriKekka getBunrimaeAuthoriKekka(String pCreditkessaiyouno, String pDatajyusinymd) {

        return bunrimaeAuthoriKekkaDao.getBunrimaeAuthoriKekka(pCreditkessaiyouno, pDatajyusinymd);
    }

    List<IT_SkCreditCardTourokuKekka> getAllSkCreditCardTourokuKekka(){
        SortIT_SkCreditCardTourokuKekka sortIT_SkCreditCardTourokuKekka = new SortIT_SkCreditCardTourokuKekka();
        return sortIT_SkCreditCardTourokuKekka.OrderIT_SkCreditCardTourokuKekkaByPkAsc(skCreditCardTourokuKekkaDao.selectAll());
    }

    IT_SkCreditCardTourokuKekka getSkCreditCardTourokuKekka(String pCreditkessaiyouno, String pDatajyusinymd) {

        return skCreditCardTourokuKekkaDao.getSkCreditCardTourokuKekka(pCreditkessaiyouno, pDatajyusinymd);
    }

}
