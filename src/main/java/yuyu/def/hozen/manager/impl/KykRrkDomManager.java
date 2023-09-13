package yuyu.def.hozen.manager.impl;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_Meigihnkjiyuu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UnitFundKbn;
import yuyu.def.db.dao.IT_HengakuUnitRirekiDao;
import yuyu.def.db.dao.IT_KhHenkouRirekiDao;
import yuyu.def.db.dao.IT_KhTtdkRirekiDao;
import yuyu.def.db.dao.IT_KykSyaHenkouRirekiDao;
import yuyu.def.db.dao.IT_KykSyouhnDao;
import yuyu.def.db.dao.IT_KykSyouhnHnkmaeDao;
import yuyu.def.db.dao.IT_KykSyouhnRirekiDao;
import yuyu.def.db.dao.IT_SyouhnTokujouRirekiDao;
import yuyu.def.db.entity.IT_HengakuUnitRireki;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykSyaHenkouRireki;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykSyouhnHnkmae;
import yuyu.def.db.entity.IT_KykSyouhnRireki;
import yuyu.def.db.entity.IT_SyouhnTokujouRireki;
import yuyu.def.hozen.result.bean.HoyuuKhTtdkRirekiByPkBean;
import yuyu.def.hozen.result.bean.KeiyakuHozenTetuzukiRirekiInfosByKakutyoujobcdSyoriYmdSyutkkbnGyoumuKousinKinousBean;
import yuyu.def.hozen.result.bean.KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean;
import yuyu.def.hozen.result.bean.KhHenkouRirekiBfrnaiyouoriginalsBySyonoHenkousikibetukeyBean;
import yuyu.def.hozen.result.bean.KhHenkouRirekiHenkousikibetukeyItemsBySyonoBean;
import yuyu.def.hozen.result.bean.KhHenkouRirekiTargetBefaAftNaiyouOriginalBean;
import yuyu.def.hozen.result.bean.KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean;
import yuyu.def.hozen.sorter.SortIT_KykSyaHenkouRireki;
import yuyu.def.hozen.sorter.SortIT_KykSyouhnHnkmae;

/**
 * KykRrkDomマネージャー<br />
 * KykRrkにおける、DB操作を提供する。<br />
 */
class KykRrkDomManager {

    @Inject
    private IT_HengakuUnitRirekiDao hengakuUnitRirekiDao;

    @Inject
    private IT_KhTtdkRirekiDao khTtdkRirekiDao;

    @Inject
    private IT_KykSyaHenkouRirekiDao kykSyaHenkouRirekiDao;

    @Inject
    private IT_KykSyouhnDao kykSyouhnDao;

    @Inject
    private IT_KykSyouhnHnkmaeDao kykSyouhnHnkmaeDao;

    @Inject
    private IT_KykSyouhnRirekiDao kykSyouhnRirekiDao;

    @Inject
    private IT_SyouhnTokujouRirekiDao syouhnTokujouRirekiDao;

    @Inject
    private IT_KhHenkouRirekiDao khHenkouRirekiDao;

    List<Object[]> getKhTtdkRirekiCountBySyoriYmdSubSystemId(BizDate pSyoriYmd, String pSubSystemId) {

        return khTtdkRirekiDao.getKhTtdkRirekiCountBySyoriYmdSubSystemId(pSyoriYmd, pSubSystemId);
    }

    List<IT_HengakuUnitRireki> getHengakuUnitRirekisBySyonoUnitfundkbnCalckijyunymd(String pSyono, C_UnitFundKbn pUnitfundkbn, BizDate pCalckijyunymd) {

        return hengakuUnitRirekiDao.getHengakuUnitRirekisBySyonoUnitfundkbnCalckijyunymd(pSyono, pUnitfundkbn, pCalckijyunymd);
    }

    List<IT_KykSyouhnRireki> getKykSyouhnRirekisBySyonoMaxHenkousikibetukey(String pSyono) {

        return kykSyouhnRirekiDao.getKykSyouhnRirekisBySyonoMaxHenkousikibetukey(pSyono);
    }

    List<IT_SyouhnTokujouRireki> getSyouhnTokujouRirekisBySyonoMaxHenkousikibetukey(String pSyono) {

        return syouhnTokujouRirekiDao.getSyouhnTokujouRirekisBySyonoMaxHenkousikibetukey(pSyono);
    }

    List<IT_KykSyouhnRireki> getKykSyouhnRirekisBySyonoKouryokuhasseiymdGt(String pSyono, BizDate pKouryokuhasseiymd) {

        return kykSyouhnRirekiDao.getKykSyouhnRirekisBySyonoKouryokuhasseiymdGt(pSyono, pKouryokuhasseiymd);
    }

    List<IT_KykSyouhnRireki> getKykSyouhnRirekisByPk(String pSyono, C_SyutkKbn pSyutkkbn, String pSyouhncd, Integer pSyouhnsdno, Integer pKyksyouhnrenno) {

        return kykSyouhnRirekiDao.getKykSyouhnRirekisByPk(pSyono, pSyutkkbn, pSyouhncd, pSyouhnsdno, pKyksyouhnrenno);
    }

    Long getKhTtdkRirekiCountBySyono(String pSyono) {

        return khTtdkRirekiDao.getKhTtdkRirekiCountBySyono(pSyono);
    }

    List<IT_KykSyouhn> getKykSyouhnsBySyonoKouryokuhasseiymd(String pSyono, BizDate pKouryokuhasseiymd) {

        return kykSyouhnDao.getKykSyouhnsBySyonoKouryokuhasseiymd(pSyono, pKouryokuhasseiymd);
    }

    ExDBResults<KeiyakuHozenTetuzukiRirekiInfosByKakutyoujobcdSyoriYmdSyutkkbnGyoumuKousinKinousBean> getKeiyakuHozenTetuzukiRirekiInfosByKakutyoujobcdSyoriYmdSyutkkbnGyoumuKousinKinous(String pKakutyoujobcd, BizDate pSyoriYmd, C_SyutkKbn pSyutkkbn, String[] pGyoumuKousinKinou) {

        ExDBResults<KeiyakuHozenTetuzukiRirekiInfosByKakutyoujobcdSyoriYmdSyutkkbnGyoumuKousinKinousBean> exDBResults = khTtdkRirekiDao.getKeiyakuHozenTetuzukiRirekiInfosByKakutyoujobcdSyoriYmdSyutkkbnGyoumuKousinKinous(pSyoriYmd, pSyutkkbn, pGyoumuKousinKinou);

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    List<IT_KhTtdkRireki> getKhTtdkRirekisBySyonoGyoumuKousinKinous(String pSyono, String[] pGyoumuKousinKinou) {

        return khTtdkRirekiDao.getKhTtdkRirekisBySyonoGyoumuKousinKinous(pSyono,pGyoumuKousinKinou);
    }

    HoyuuKhTtdkRirekiByPkBean getHoyuuKhTtdkRirekiByPk(String pSyono, String pHenkousikibetukey) {

        return khTtdkRirekiDao.getHoyuuKhTtdkRirekiByPk(pSyono, pHenkousikibetukey);
    }

    List<KhHenkouRirekiBfrnaiyouoriginalsBySyonoHenkousikibetukeyBean> getKhHenkouRirekiBfrnaiyouoriginalsBySyonoHenkousikibetukey(String pSyono, String pHenkousikibetukey) {

        return khHenkouRirekiDao.getKhHenkouRirekiBfrnaiyouoriginalsBySyonoHenkousikibetukey(pSyono,pHenkousikibetukey);
    }

    List<KhHenkouRirekiHenkousikibetukeyItemsBySyonoBean> getKhHenkouRirekiHenkousikibetukeyItemsBySyono(String pSyono) {

        return khHenkouRirekiDao.getKhHenkouRirekiHenkousikibetukeyItemsBySyono(pSyono);
    }

    List<KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean> getKhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyono(String pSyono) {

        return khHenkouRirekiDao.getKhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyono(pSyono);
    }

    List<KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean> getTargetTokuyakuBefaAftMokuhyoutiDescList(String pSyono) {

        return khHenkouRirekiDao.getTargetTokuyakuBefaAftMokuhyoutiDescList(pSyono);
    }

    List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> getTargetTokuyakuBefaAftMokuhyoutiAscList(String pSyono) {

        return khHenkouRirekiDao.getTargetTokuyakuBefaAftMokuhyoutiAscList(pSyono);
    }

    List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> getTargetTokuyakuBefaAftKykhenkoYmdList(String pSyono, String pHenkousikibetukey) {

        return khHenkouRirekiDao.getTargetTokuyakuBefaAftKykhenkoYmdList(pSyono, pHenkousikibetukey);
    }

    List<KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean> getTargetTokuyakuBefaAftKijyungkDescList(String pSyono) {

        return khHenkouRirekiDao.getTargetTokuyakuBefaAftKijyungkDescList(pSyono);
    }

    List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> getTargetTokuyakuBefaAftKijyungkAscList(String pSyono) {

        return khHenkouRirekiDao.getTargetTokuyakuBefaAftKijyungkAscList(pSyono);
    }

    List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> getTargetTokuyakuBefaAftKijyungkList(String pSyono, String pHenkousikibetukey) {

        return khHenkouRirekiDao.getTargetTokuyakuBefaAftKijyungkList(pSyono, pHenkousikibetukey);
    }

    List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> getTargetTokuyakuBefaAftMokuhyoutiList(String pSyono, String pHenkousikibetukey) {

        return khHenkouRirekiDao.getTargetTokuyakuBefaAftMokuhyoutiList(pSyono, pHenkousikibetukey);
    }

    List<IT_KykSyaHenkouRireki> getAllKykSyaHenkouRireki(){
        SortIT_KykSyaHenkouRireki sortIT_KykSyahenkouRireki = new SortIT_KykSyaHenkouRireki();
        return sortIT_KykSyahenkouRireki.OrderIT_KykSyaHenkouRirekiByPkAsc(kykSyaHenkouRirekiDao.selectAll());
    }

    IT_KykSyaHenkouRireki getKysSyaHenkouRireki(String pSyono, String pHenkousikibetukey) {

        return kykSyaHenkouRirekiDao.getKykSyaHenkouRireki(pSyono, pHenkousikibetukey);
    }

    List<IT_KykSyaHenkouRireki> getKykSyaHenkouRirekisBySyonoMeigihnkjiyuu(String pSyono, C_Meigihnkjiyuu pMeigihnkjiyuu) {

        return kykSyaHenkouRirekiDao.getKykSyaHenkouRirekisBySyonoMeigihnkjiyuu(pSyono, pMeigihnkjiyuu);
    }

    List<IT_KykSyaHenkouRireki> getKykSyaHenkouRirekisBySyono(String pSyono) {

        return kykSyaHenkouRirekiDao.getKykSyaHenkouRirekisBySyono(pSyono);
    }

    List<IT_KykSyouhnHnkmae> getAllKykSyouhnHnkmae(){
        SortIT_KykSyouhnHnkmae sortIT_KykSyouhnHnkmae = new SortIT_KykSyouhnHnkmae();
        return sortIT_KykSyouhnHnkmae.OrderIT_KykSyouhnHnkmaeByPkAsc(kykSyouhnHnkmaeDao.selectAll());
    }

    IT_KykSyouhnHnkmae getKykSyouhnHnkmae(String pSyono, C_SyutkKbn pSyutkkbn, String pSyouhncd, Integer pSyouhnsdno, Integer pKyksyouhnrenno, Integer pRenno) {

        return kykSyouhnHnkmaeDao.getKykSyouhnHnkmae(pSyono, pSyutkkbn, pSyouhncd, pSyouhnsdno, pKyksyouhnrenno, pRenno);
    }

    IT_KykSyouhnHnkmae getKykSyouhnHnkmaeBySyono(String pSyono) {

        return kykSyouhnHnkmaeDao.getKykSyouhnHnkmaeBySyono(pSyono);
    }

}
