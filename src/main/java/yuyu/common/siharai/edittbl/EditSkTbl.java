package yuyu.common.siharai.edittbl;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.siharai.siview.ViewSindansyoInfo2DataSourceBeanCommonParam;
import yuyu.def.MessageId;
import yuyu.def.classification.C_Delflag;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.JT_BetukutiSateiInfo;
import yuyu.def.db.entity.JT_NenkinInfo;
import yuyu.def.db.entity.JT_SateiIppanHanteiInfo;
import yuyu.def.db.entity.JT_SateiJyuukasituChkInfo;
import yuyu.def.db.entity.JT_SateiKaijyoInfo;
import yuyu.def.db.entity.JT_SateiKokuhanInfo;
import yuyu.def.db.entity.JT_SateiMeigihenkouInfo;
import yuyu.def.db.entity.JT_SiDetail;
import yuyu.def.db.entity.JT_SibouSateiChkInfo;
import yuyu.def.db.entity.JT_SkByoumei;
import yuyu.def.db.entity.JT_SkJiyuu;
import yuyu.def.db.entity.JT_Toriatukaifuryouinfo;
import yuyu.infr.kinoumode.KinouMode;

import com.google.common.collect.Lists;

/**
 * 保険金給付金支払 保険金給付金支払共通 請求TBL編集
 */
public class EditSkTbl {

    private String systemYmdTime;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private KinouMode kinouMode;

    public EditSkTbl() {
        super();
    }

    public EditSkTblBean setEditKyhSkTbl(EditSkTblParam pEditSkTblParam, EditSkTblBean pEditSkTblBean) {

        checkInputValue(pEditSkTblParam, pEditSkTblBean);

        systemYmdTime = BizDate.getSysDateTimeMilli();

        if (pEditSkTblParam instanceof SiSeikyuusyaSindansyoParam) {
            setSiSeikyuusyaSindansyoParam((SiSeikyuusyaSindansyoParam) pEditSkTblParam, pEditSkTblBean);
        }

        if (pEditSkTblParam instanceof SiSouhusakiSindansyoParam) {
            setSiSouhusakiSindansyoParam((SiSouhusakiSindansyoParam) pEditSkTblParam, pEditSkTblBean);
        }

        if (pEditSkTblParam instanceof SiSoukinsakiParam) {
            setSiSoukinsakiParam((SiSoukinsakiParam) pEditSkTblParam, pEditSkTblBean);
        }

        if (pEditSkTblParam instanceof SiSindansyoryouShrParam) {
            setSiSindansyoryouShrParam((SiSindansyoryouShrParam) pEditSkTblParam, pEditSkTblBean);
        }

        if (pEditSkTblParam instanceof SiShrdtlsyoHassouParam) {
            setSiShrdtlsyoHassouParam((SiShrdtlsyoHassouParam) pEditSkTblParam, pEditSkTblBean);
        }

        if (pEditSkTblParam instanceof SiSeikyuusyaParam) {
            setSiSeikyuusyaParam((SiSeikyuusyaParam) pEditSkTblParam, pEditSkTblBean);
        }

        if (pEditSkTblParam instanceof SiSinkensyaKoukenninParam) {
            setSiSinkensyaKoukenninParam((SiSinkensyaKoukenninParam) pEditSkTblParam, pEditSkTblBean);
        }

        if (pEditSkTblParam instanceof SiSeikyuuNaiyouParam) {
            setSiSeikyuuNaiyouParam((SiSeikyuuNaiyouParam) pEditSkTblParam, pEditSkTblBean);
        }

        if (pEditSkTblParam instanceof SiSindansyoJyouhouSbParam) {
            setSiSindansyoJyouhouSbParam((SiSindansyoJyouhouSbParam) pEditSkTblParam, pEditSkTblBean);
        }

        if (pEditSkTblParam instanceof SiSyoruiUketukeYmdSkukeParam) {
            setSiSyoruiUketukeYmdSkukeParam((SiSyoruiUketukeYmdSkukeParam) pEditSkTblParam, pEditSkTblBean);
        }

        if (pEditSkTblParam instanceof SiSyoruiUketukeYmdSateiParam) {
            setSiSyoruiUketukeYmdSateiParam((SiSyoruiUketukeYmdSateiParam) pEditSkTblParam, pEditSkTblBean);
        }

        if (pEditSkTblParam instanceof SiSouhusakiInfoParam) {
            setSiSouhusakiInfoParam((SiSouhusakiInfoParam) pEditSkTblParam, pEditSkTblBean);
        }

        if (pEditSkTblParam instanceof SiSateiKakSbParam) {
            setSiSateiKakSbParam((SiSateiKakSbParam) pEditSkTblParam, pEditSkTblBean);
        }

        if (pEditSkTblParam instanceof SiByoumeiParam) {
            setSiByoumeiParam((SiByoumeiParam) pEditSkTblParam, pEditSkTblBean);
        }

        if (pEditSkTblParam instanceof SiSateiIppanHanteiParam) {
            setSiSateiIppanHanteiParam((SiSateiIppanHanteiParam) pEditSkTblParam, pEditSkTblBean);
        }

        if (pEditSkTblParam instanceof SiSateiKokuhanCheckParam) {
            setSiSateiKokuhanCheckParam((SiSateiKokuhanCheckParam) pEditSkTblParam, pEditSkTblBean);
        }

        if (pEditSkTblParam instanceof SiKaijoKigenParam) {
            setSiKaijoKigenParam((SiKaijoKigenParam) pEditSkTblParam, pEditSkTblBean);
        }

        if (pEditSkTblParam instanceof SiMeigihenkouSateiParam) {
            setSiMeigihenkouSateiParam((SiMeigihenkouSateiParam) pEditSkTblParam, pEditSkTblBean);
        }

        if (pEditSkTblParam instanceof SiToriatukaifuryouParam) {
            setSiToriatukaifuryouParam((SiToriatukaifuryouParam) pEditSkTblParam, pEditSkTblBean);
        }

        if (pEditSkTblParam instanceof SiSonotaSateiSbParam) {
            setSiSonotaSateiSbParam((SiSonotaSateiSbParam) pEditSkTblParam, pEditSkTblBean);
        }

        if (pEditSkTblParam instanceof SiBetukutiSateiSbParam) {
            setSiBetukutiSateiSbParam((SiBetukutiSateiSbParam) pEditSkTblParam, pEditSkTblBean);
        }

        if (pEditSkTblParam instanceof SiSiharaiSateiParam) {
            setSiSiharaiSateiParam((SiSiharaiSateiParam) pEditSkTblParam, pEditSkTblBean);
        }

        if (pEditSkTblParam instanceof SiSaikenParam) {
            setSiSaikenParam((SiSaikenParam) pEditSkTblParam, pEditSkTblBean);
        }

        if (pEditSkTblParam instanceof SiMnmeigibangouParam) {
            setSiMnmeigibangouParam((SiMnmeigibangouParam) pEditSkTblParam, pEditSkTblBean);
        }

        if (pEditSkTblParam instanceof SiSiinParam) {
            setSiSiinParam((SiSiinParam) pEditSkTblParam, pEditSkTblBean);
        }

        if (pEditSkTblParam instanceof SiSateiJuukasituParam) {
            setSiSateiJuukasituParam((SiSateiJuukasituParam) pEditSkTblParam, pEditSkTblBean);
        }

        if (pEditSkTblBean.getSkTblSetBean() != null) {
            setSkTbl(pEditSkTblBean.getSkTblSetBean(), pEditSkTblBean);
        }

        if (pEditSkTblBean.getSiSiDetailParamBeanLst() != null &&
            pEditSkTblBean.getSiSiDetailParamBeanLst().size() != 0) {
            setSiDetailTbl(pEditSkTblBean.getSiSiDetailParamBeanLst(), pEditSkTblBean);
        }

        if (pEditSkTblBean.getSiNenkinInfoBean() != null) {
            setNenkinInfoTbl(pEditSkTblBean.getSiNenkinInfoBean(), pEditSkTblBean);
        }

        setCommonColumn(pEditSkTblBean);

        return pEditSkTblBean;
    }

    private void checkInputValue(EditSkTblParam pEditSkTblParam, EditSkTblBean pEditSkTblBean) {

        if (pEditSkTblParam == null) {
            throw new BizAppException(MessageId.EJS1005, "pEditSkTblParam");
        }

        if (pEditSkTblBean == null) {
            throw new BizAppException(MessageId.EJS1005, "pEditSkTblBean");
        }

        if (BizUtil.isBlank(pEditSkTblBean.getSkNo())) {
            throw new BizAppException(MessageId.EJS1005, "skNo");
        }

        if (BizUtil.isBlank(pEditSkTblBean.getSyoNo())) {
            throw new BizAppException(MessageId.EJS1005, "syoNo");
        }

        if (pEditSkTblBean.getSeikyuuRirekiNo() == 0) {
            throw new BizAppException(MessageId.EJS1005, "seikyuuRirekiNo");
        }

        if (pEditSkTblBean.getUketukeNo() == 0) {
            throw new BizAppException(MessageId.EJS1005, "uketukeNo");
        }

    }

    private void setSiSeikyuusyaSindansyoParam(SiSeikyuusyaSindansyoParam pSiSeikyuusyaSindansyoParam,
        EditSkTblBean pEditSkTblBean) {

        SiSeikyuusyaSindansyoParamImpl siSeikyuusyaSindansyoParamImpl =
            SWAKInjector.getInstance(SiSeikyuusyaSindansyoParamImpl.class);

        BeanUtil.copyProperties(siSeikyuusyaSindansyoParamImpl, pSiSeikyuusyaSindansyoParam);

        BeanUtil.copyProperties(pEditSkTblBean.getSk(), siSeikyuusyaSindansyoParamImpl);
    }

    private void setSiSouhusakiSindansyoParam(SiSouhusakiSindansyoParam pSiSouhusakiSindansyoParam,
        EditSkTblBean pEditSkTblBean) {

        SiSouhusakiSindansyoParamImpl siSouhusakiSindansyoParamImpl =
            SWAKInjector.getInstance(SiSouhusakiSindansyoParamImpl.class);

        BeanUtil.copyProperties(siSouhusakiSindansyoParamImpl, pSiSouhusakiSindansyoParam);

        BeanUtil.copyProperties(pEditSkTblBean.getSk(), siSouhusakiSindansyoParamImpl);
    }

    private void setSiSoukinsakiParam(SiSoukinsakiParam pSiSoukinsakiParam, EditSkTblBean pEditSkTblBean) {

        SiSoukinsakiParamImpl siSoukinsakiParamImpl =
            SWAKInjector.getInstance(SiSoukinsakiParamImpl.class);

        BeanUtil.copyProperties(siSoukinsakiParamImpl, pSiSoukinsakiParam);

        BeanUtil.copyProperties(pEditSkTblBean.getSk(), siSoukinsakiParamImpl);
    }

    private void setSiSindansyoryouShrParam(SiSindansyoryouShrParam pSiSindansyoryouShrParam,
        EditSkTblBean pEditSkTblBean) {

        SiSindansyoryouShrParamImpl siSindansyoryouShrParamImpl =
            SWAKInjector.getInstance(SiSindansyoryouShrParamImpl.class);

        BeanUtil.copyProperties(siSindansyoryouShrParamImpl, pSiSindansyoryouShrParam);

        BeanUtil.copyProperties(pEditSkTblBean.getSk(), siSindansyoryouShrParamImpl);
    }

    private void setSiShrdtlsyoHassouParam(SiShrdtlsyoHassouParam pSiShrdtlsyoHassouParam, EditSkTblBean pEditSkTblBean) {

        SiShrdtlsyoHassouParamImpl siShrdtlsyoHassouParamImpl =
            SWAKInjector.getInstance(SiShrdtlsyoHassouParamImpl.class);

        BeanUtil.copyProperties(siShrdtlsyoHassouParamImpl, pSiShrdtlsyoHassouParam);

        BeanUtil.copyProperties(pEditSkTblBean.getSk(), siShrdtlsyoHassouParamImpl);
    }

    private void setSiSeikyuusyaParam(SiSeikyuusyaParam pSiSeikyuusyaParam, EditSkTblBean pEditSkTblBean) {

        SiSeikyuusyaParamImpl siSeikyuusyaParamImpl =
            SWAKInjector.getInstance(SiSeikyuusyaParamImpl.class);

        BeanUtil.copyProperties(siSeikyuusyaParamImpl, pSiSeikyuusyaParam);

        BeanUtil.copyProperties(pEditSkTblBean.getSk(), siSeikyuusyaParamImpl);
    }

    private void setSiSinkensyaKoukenninParam(SiSinkensyaKoukenninParam pSiSinkensyaKoukenninParam,
        EditSkTblBean pEditSkTblBean) {

        SiSinkensyaKoukenninParamImpl siSinkensyaKoukenninParamImpl =
            SWAKInjector.getInstance(SiSinkensyaKoukenninParamImpl.class);

        BeanUtil.copyProperties(siSinkensyaKoukenninParamImpl, pSiSinkensyaKoukenninParam);

        BeanUtil.copyProperties(pEditSkTblBean.getSk(), siSinkensyaKoukenninParamImpl);
    }

    private void setSiSeikyuuNaiyouParam(SiSeikyuuNaiyouParam pSiSeikyuuNaiyouParam, EditSkTblBean pEditSkTblBean) {

        SiSeikyuuNaiyouParamImpl siSeikyuuNaiyouParamImpl =
            SWAKInjector.getInstance(SiSeikyuuNaiyouParamImpl.class);

        BeanUtil.copyProperties(siSeikyuuNaiyouParamImpl, pSiSeikyuuNaiyouParam);

        BeanUtil.copyProperties(pEditSkTblBean.getSk(), siSeikyuuNaiyouParamImpl);
    }

    private void setSiSindansyoJyouhouSbParam(SiSindansyoJyouhouSbParam pSiSindansyoJyouhouSbParam,
        EditSkTblBean pEditSkTblBean) {

        List<JT_SkJiyuu> skJiyuuLst = Lists.newArrayList();

        JT_SkJiyuu skJiyuu = new JT_SkJiyuu();

        SiSindansyoJyouhouSbParamImpl siSindansyoJyouhouSbParamImpl =
            SWAKInjector.getInstance(SiSindansyoJyouhouSbParamImpl.class);

        BeanUtil.copyProperties(siSindansyoJyouhouSbParamImpl, pSiSindansyoJyouhouSbParam);

        BeanUtil.copyProperties(skJiyuu, siSindansyoJyouhouSbParamImpl);

        skJiyuuLst.add(skJiyuu);

        pEditSkTblBean.setSkJiyuuLst(skJiyuuLst);
    }

    private void setSiSyoruiUketukeYmdSkukeParam(SiSyoruiUketukeYmdSkukeParam pSiSyoruiUketukeYmdSkukeParam,
        EditSkTblBean pEditSkTblBean) {

        SiSyoruiUketukeYmdSkukeParamImpl siSyoruiUketukeYmdSkukeParamImpl =
            SWAKInjector.getInstance(SiSyoruiUketukeYmdSkukeParamImpl.class);

        BeanUtil.copyProperties(siSyoruiUketukeYmdSkukeParamImpl, pSiSyoruiUketukeYmdSkukeParam);

        BeanUtil.copyProperties(pEditSkTblBean.getSk(), siSyoruiUketukeYmdSkukeParamImpl);

    }

    private void setSiSyoruiUketukeYmdSateiParam(SiSyoruiUketukeYmdSateiParam pSiSyoruiUketukeYmdSateiParam,
        EditSkTblBean pEditSkTblBean) {

        SiSyoruiUketukeYmdSateiParamImpl siSyoruiUketukeYmdSateiParamImpl =
            SWAKInjector.getInstance(SiSyoruiUketukeYmdSateiParamImpl.class);

        BeanUtil.copyProperties(siSyoruiUketukeYmdSateiParamImpl, pSiSyoruiUketukeYmdSateiParam);

        BeanUtil.copyProperties(pEditSkTblBean.getSk(), siSyoruiUketukeYmdSateiParamImpl);

    }

    private void setSiSouhusakiInfoParam(SiSouhusakiInfoParam pSiSouhusakiInfoParam, EditSkTblBean pEditSkTblBean) {

        SiSouhusakiInfoParamImpl siSouhusakiInfoParamImpl =
            SWAKInjector.getInstance(SiSouhusakiInfoParamImpl.class);

        BeanUtil.copyProperties(siSouhusakiInfoParamImpl, pSiSouhusakiInfoParam);

        BeanUtil.copyProperties(pEditSkTblBean.getSk(), siSouhusakiInfoParamImpl);
    }

    private void setSiSateiKakSbParam(SiSateiKakSbParam pSiSateiKakSbParam, EditSkTblBean pEditSkTblBean) {

        SiSateiKakSbParamImpl siSateiKakSbParamImpl =
            SWAKInjector.getInstance(SiSateiKakSbParamImpl.class);

        BeanUtil.copyProperties(siSateiKakSbParamImpl, pSiSateiKakSbParam);

        BeanUtil.copyProperties(pEditSkTblBean.getSk(), siSateiKakSbParamImpl);
    }

    private void setSiByoumeiParam(SiByoumeiParam pSiByoumeiParam, EditSkTblBean pEditSkTblBean) {

        List<ViewSindansyoInfo2DataSourceBeanCommonParam> siByoumeiBeanLst =
            pSiByoumeiParam.convertCommonParamForSindansyoInfo2();

        List<JT_SkByoumei> skByoumeiLst = Lists.newArrayList();

        int renNo = 1;

        for (int n = 0; n < siByoumeiBeanLst.size(); n++) {
            if (C_Delflag.BLNK.eq(siByoumeiBeanLst.get(n).getSakujyoflg())) {
                JT_SkByoumei skByoumei = new JT_SkByoumei();
                BeanUtil.copyProperties(skByoumei, siByoumeiBeanLst.get(n));
                skByoumei.setRenno(renNo);
                skByoumeiLst.add(skByoumei);

                renNo++;

            }
        }

        pEditSkTblBean.setSkByoumeiLst(skByoumeiLst);
    }

    private void setSiSateiIppanHanteiParam(SiSateiIppanHanteiParam pSiSateiIppanHanteiParam,
        EditSkTblBean pEditSkTblBean) {

        SiSateiIppanHanteiParamImpl siSateiIppanHanteiParamImpl =
            SWAKInjector.getInstance(SiSateiIppanHanteiParamImpl.class);

        BeanUtil.copyProperties(siSateiIppanHanteiParamImpl, pSiSateiIppanHanteiParam);

        if (siSateiIppanHanteiParamImpl.isAllBlnk()) {
            pEditSkTblBean.setSateiIppanHanteiInfo(null);
        }
        else {
            pEditSkTblBean.setSateiIppanHanteiInfo(new JT_SateiIppanHanteiInfo());
            BeanUtil.copyProperties(pEditSkTblBean.getSateiIppanHanteiInfo(), siSateiIppanHanteiParamImpl);
        }

    }

    private void setSiSateiKokuhanCheckParam(SiSateiKokuhanCheckParam pSiSateiKokuhanCheckParam,
        EditSkTblBean pEditSkTblBean) {

        SiSateiKokuhanCheckParamImpl siSateiKokuhanCheckParamImpl =
            SWAKInjector.getInstance(SiSateiKokuhanCheckParamImpl.class);

        BeanUtil.copyProperties(siSateiKokuhanCheckParamImpl, pSiSateiKokuhanCheckParam);

        if (siSateiKokuhanCheckParamImpl.isAllBlnk()) {
            pEditSkTblBean.setSateiKokuhanInfo(null);
        }
        else {
            pEditSkTblBean.setSateiKokuhanInfo(new JT_SateiKokuhanInfo());
            BeanUtil.copyProperties(pEditSkTblBean.getSateiKokuhanInfo(), siSateiKokuhanCheckParamImpl);
        }
    }

    private void setSiKaijoKigenParam(SiKaijoKigenParam pSiKaijoKigenParam, EditSkTblBean pEditSkTblBean) {

        SiKaijoKigenParamImpl siKaijoKigenParamImpl =
            SWAKInjector.getInstance(SiKaijoKigenParamImpl.class);

        BeanUtil.copyProperties(siKaijoKigenParamImpl, pSiKaijoKigenParam);

        if (siKaijoKigenParamImpl.isAllBlnk()) {
            pEditSkTblBean.setSateiKaijyoInfo(null);
        }
        else {
            pEditSkTblBean.setSateiKaijyoInfo(new JT_SateiKaijyoInfo());
            BeanUtil.copyProperties(pEditSkTblBean.getSateiKaijyoInfo(), siKaijoKigenParamImpl);
        }
    }

    private void setSiMeigihenkouSateiParam(SiMeigihenkouSateiParam pSiMeigihenkouSateiParam,
        EditSkTblBean pEditSkTblBean) {

        SiMeigihenkouSateiParamImpl siMeigihenkouSateiParamImpl =
            SWAKInjector.getInstance(SiMeigihenkouSateiParamImpl.class);

        BeanUtil.copyProperties(siMeigihenkouSateiParamImpl, pSiMeigihenkouSateiParam);

        if (siMeigihenkouSateiParamImpl.isAllBlnk()) {
            pEditSkTblBean.setSateiMeigihenkouInfo(null);
        }
        else {
            pEditSkTblBean.setSateiMeigihenkouInfo(new JT_SateiMeigihenkouInfo());
            BeanUtil.copyProperties(pEditSkTblBean.getSateiMeigihenkouInfo(), siMeigihenkouSateiParamImpl);
        }
    }

    private void setSiToriatukaifuryouParam(SiToriatukaifuryouParam pSiToriatukaifuryouParam,
        EditSkTblBean pEditSkTblBean) {

        SiToriatukaifuryouParamImpl siToriatukaifuryouParamImpl =
            SWAKInjector.getInstance(SiToriatukaifuryouParamImpl.class);

        BeanUtil.copyProperties(siToriatukaifuryouParamImpl, pSiToriatukaifuryouParam);

        if (siToriatukaifuryouParamImpl.isAllBlnk()) {
            pEditSkTblBean.setToriatukaifuryouinfo(null);
        }
        else {
            pEditSkTblBean.setToriatukaifuryouinfo(new JT_Toriatukaifuryouinfo());
            BeanUtil.copyProperties(pEditSkTblBean.getToriatukaifuryouinfo(), siToriatukaifuryouParamImpl);
        }
    }

    private void setSiSonotaSateiSbParam(SiSonotaSateiSbParam pSiSonotaSateiSbParam, EditSkTblBean pEditSkTblBean) {

        SiSonotaSateiSbParamImpl siSonotaSateiSbParamImpl =
            SWAKInjector.getInstance(SiSonotaSateiSbParamImpl.class);

        BeanUtil.copyProperties(siSonotaSateiSbParamImpl, pSiSonotaSateiSbParam);

        if (siSonotaSateiSbParamImpl.isAllBlnk()) {
            pEditSkTblBean.setSibouSateiChkInfo(null);
        }
        else {
            pEditSkTblBean.setSibouSateiChkInfo(new JT_SibouSateiChkInfo());
            BeanUtil.copyProperties(pEditSkTblBean.getSibouSateiChkInfo(), siSonotaSateiSbParamImpl);
        }
    }

    private void setSiBetukutiSateiSbParam(SiBetukutiSateiSbParam pSiBetukutiSateiSbParam, EditSkTblBean pEditSkTblBean) {

        SiBetukutiSateiSbParamImpl siBetukutiSateiSbParamImpl =
            SWAKInjector.getInstance(SiBetukutiSateiSbParamImpl.class);

        BeanUtil.copyProperties(siBetukutiSateiSbParamImpl, pSiBetukutiSateiSbParam);

        if (siBetukutiSateiSbParamImpl.isAllBlnk()) {
            pEditSkTblBean.setBetukutiSateiInfo(null);
        }
        else {
            pEditSkTblBean.setBetukutiSateiInfo(new JT_BetukutiSateiInfo());
            BeanUtil.copyProperties(pEditSkTblBean.getBetukutiSateiInfo(), siBetukutiSateiSbParamImpl);
        }
    }

    private void setSiSiharaiSateiParam(SiSiharaiSateiParam pSiSiharaiSateiParam, EditSkTblBean pEditSkTblBean) {

        SiSiharaiSateiParamImpl siSiharaiSateiParamImpl =
            SWAKInjector.getInstance(SiSiharaiSateiParamImpl.class);

        BeanUtil.copyProperties(siSiharaiSateiParamImpl, pSiSiharaiSateiParam);

        BeanUtil.copyProperties(pEditSkTblBean.getSk(), siSiharaiSateiParamImpl);
    }

    private void setSiSaikenParam(SiSaikenParam pSiSaikenParam, EditSkTblBean pEditSkTblBean) {

        SiSaikenParamImpl siSaikenParamImpl =
            SWAKInjector.getInstance(SiSaikenParamImpl.class);

        BeanUtil.copyProperties(siSaikenParamImpl, pSiSaikenParam);

        BeanUtil.copyProperties(pEditSkTblBean.getSk(), siSaikenParamImpl);
    }

    private void setSiMnmeigibangouParam(SiMnmeigibangouParam pSiMnmeigibangouParam, EditSkTblBean pEditSkTblBean) {

        SiMnmeigibangouParamImpl siMnmeigibangouParamImpl =
            SWAKInjector.getInstance(SiMnmeigibangouParamImpl.class);

        BeanUtil.copyProperties(siMnmeigibangouParamImpl, pSiMnmeigibangouParam);

        BeanUtil.copyProperties(pEditSkTblBean.getSk(), siMnmeigibangouParamImpl);
    }

    private void setSiSiinParam(SiSiinParam pSiSiinParam, EditSkTblBean pEditSkTblBean) {

        SiSiinParamImpl siSiinParamImpl =
            SWAKInjector.getInstance(SiSiinParamImpl.class);

        BeanUtil.copyProperties(siSiinParamImpl, pSiSiinParam);

        BeanUtil.copyProperties(pEditSkTblBean.getSk(), siSiinParamImpl);
    }

    private void setSiSateiJuukasituParam(SiSateiJuukasituParam pSiSateiJuukasituParam, EditSkTblBean pEditSkTblBean) {

        SiSateiJuukasituParamImpl siSateiJuukasituParamImpl =
            SWAKInjector.getInstance(SiSateiJuukasituParamImpl.class);

        BeanUtil.copyProperties(siSateiJuukasituParamImpl, pSiSateiJuukasituParam);

        if (siSateiJuukasituParamImpl.isAllBlnk()) {
            pEditSkTblBean.setSateiJyuukasituChkInfo(null);
        }
        else {
            pEditSkTblBean.setSateiJyuukasituChkInfo(new JT_SateiJyuukasituChkInfo());
            BeanUtil.copyProperties(pEditSkTblBean.getSateiJyuukasituChkInfo(), siSateiJuukasituParamImpl);
        }
    }

    private void setSkTbl(SkTblSetBean pSkTblSetBean, EditSkTblBean pEditSkTblBean) {

        BeanUtil.copyProperties(pEditSkTblBean.getSk(), pSkTblSetBean);
    }

    private void setSiDetailTbl(List<SiSiDetailParamBean> pSiSiDetailParamBeanLst, EditSkTblBean pEditSkTblBean) {

        List<JT_SiDetail> siDetailLst = Lists.newArrayList();

        for (int n = 0; n < pSiSiDetailParamBeanLst.size(); n++) {
            JT_SiDetail siDetail = new JT_SiDetail();
            BeanUtil.copyProperties(siDetail, pSiSiDetailParamBeanLst.get(n));
            if(!C_Tuukasyu.JPY.eq(pEditSkTblBean.getSkTblSetBean().getShrtuukasyu())){
                siDetail.setSitihsyutkyumaeyenhknkngk(BizCurrency.valueOf(0));
            }
            siDetail.setRenno(n + 1);

            siDetailLst.add(siDetail);
        }

        pEditSkTblBean.setSiDetailLst(siDetailLst);

    }

    private void setNenkinInfoTbl(SiNenkinInfoBean pSiNenkinInfoBean, EditSkTblBean pEditSkTblBean) {

        pEditSkTblBean.setNenkinInfo(new JT_NenkinInfo());
        BeanUtil.copyProperties(pEditSkTblBean.getNenkinInfo(), pSiNenkinInfoBean);
    }

    private void setCommonColumn(EditSkTblBean pEditSkTblBean) {

        pEditSkTblBean.getSk().setSkno(pEditSkTblBean.getSkNo());
        pEditSkTblBean.getSk().setSyono(pEditSkTblBean.getSyoNo());
        pEditSkTblBean.getSk().setSeikyuurirekino(pEditSkTblBean.getSeikyuuRirekiNo());
        pEditSkTblBean.getSk().setKossyoricd(kinou.getKinouId());
        pEditSkTblBean.getSk().setKossyorisscd(kinouMode.getKinouMode());
        pEditSkTblBean.getSk().setGyoumuKousinsyaId(baseUserInfo.getUserId());
        pEditSkTblBean.getSk().setGyoumuKousinTime(systemYmdTime);

        if (pEditSkTblBean.getSkJiyuuLst() != null) {
            for (int n = 0; n < pEditSkTblBean.getSkJiyuuLst().size(); n++) {

                pEditSkTblBean.getSkJiyuuLst().get(n).setSkno(pEditSkTblBean.getSkNo());
                pEditSkTblBean.getSkJiyuuLst().get(n).setSyono(pEditSkTblBean.getSyoNo());
                pEditSkTblBean.getSkJiyuuLst().get(n).setSeikyuurirekino(pEditSkTblBean.getSeikyuuRirekiNo());
                pEditSkTblBean.getSkJiyuuLst().get(n).setUketukeno(pEditSkTblBean.getUketukeNo());
                pEditSkTblBean.getSkJiyuuLst().get(n).setKossyoricd(kinou.getKinouId());
                pEditSkTblBean.getSkJiyuuLst().get(n).setKossyorisscd(kinouMode.getKinouMode());
                pEditSkTblBean.getSkJiyuuLst().get(n).setGyoumuKousinsyaId(baseUserInfo.getUserId());
                pEditSkTblBean.getSkJiyuuLst().get(n).setGyoumuKousinTime(systemYmdTime);
            }
        }

        if (pEditSkTblBean.getSkByoumeiLst() != null) {
            for (int n = 0; n < pEditSkTblBean.getSkByoumeiLst().size(); n++) {

                pEditSkTblBean.getSkByoumeiLst().get(n).setSkno(pEditSkTblBean.getSkNo());
                pEditSkTblBean.getSkByoumeiLst().get(n).setSyono(pEditSkTblBean.getSyoNo());
                pEditSkTblBean.getSkByoumeiLst().get(n).setSeikyuurirekino(pEditSkTblBean.getSeikyuuRirekiNo());
                pEditSkTblBean.getSkByoumeiLst().get(n).setUketukeno(pEditSkTblBean.getUketukeNo());
                pEditSkTblBean.getSkByoumeiLst().get(n).setKossyoricd(kinou.getKinouId());
                pEditSkTblBean.getSkByoumeiLst().get(n).setKossyorisscd(kinouMode.getKinouMode());
                pEditSkTblBean.getSkByoumeiLst().get(n).setGyoumuKousinsyaId(baseUserInfo.getUserId());
                pEditSkTblBean.getSkByoumeiLst().get(n).setGyoumuKousinTime(systemYmdTime);
            }
        }

        if (pEditSkTblBean.getSiDetailLst() != null) {
            for (int n = 0; n < pEditSkTblBean.getSiDetailLst().size(); n++) {

                pEditSkTblBean.getSiDetailLst().get(n).setSkno(pEditSkTblBean.getSkNo());
                pEditSkTblBean.getSiDetailLst().get(n).setSyono(pEditSkTblBean.getSyoNo());
                pEditSkTblBean.getSiDetailLst().get(n).setSeikyuurirekino(pEditSkTblBean.getSeikyuuRirekiNo());
                pEditSkTblBean.getSiDetailLst().get(n).setUketukeno(pEditSkTblBean.getUketukeNo());
                pEditSkTblBean.getSiDetailLst().get(n).setKossyoricd(kinou.getKinouId());
                pEditSkTblBean.getSiDetailLst().get(n).setKossyorisscd(kinouMode.getKinouMode());
                pEditSkTblBean.getSiDetailLst().get(n).setGyoumuKousinsyaId(baseUserInfo.getUserId());
                pEditSkTblBean.getSiDetailLst().get(n).setGyoumuKousinTime(systemYmdTime);
            }
        }

        if (pEditSkTblBean.getNenkinInfo() != null) {

            pEditSkTblBean.getNenkinInfo().setSkno(pEditSkTblBean.getSkNo());
            pEditSkTblBean.getNenkinInfo().setSyono(pEditSkTblBean.getSyoNo());
            pEditSkTblBean.getNenkinInfo().setSeikyuurirekino(pEditSkTblBean.getSeikyuuRirekiNo());
            pEditSkTblBean.getNenkinInfo().setKossyoricd(kinou.getKinouId());
            pEditSkTblBean.getNenkinInfo().setKossyorisscd(kinouMode.getKinouMode());
            pEditSkTblBean.getNenkinInfo().setGyoumuKousinsyaId(baseUserInfo.getUserId());
            pEditSkTblBean.getNenkinInfo().setGyoumuKousinTime(systemYmdTime);
        }

        if (pEditSkTblBean.getSateiIppanHanteiInfo() != null) {

            pEditSkTblBean.getSateiIppanHanteiInfo().setSkno(pEditSkTblBean.getSkNo());
            pEditSkTblBean.getSateiIppanHanteiInfo().setSyono(pEditSkTblBean.getSyoNo());
            pEditSkTblBean.getSateiIppanHanteiInfo().setSeikyuurirekino(pEditSkTblBean.getSeikyuuRirekiNo());
            pEditSkTblBean.getSateiIppanHanteiInfo().setKossyoricd(kinou.getKinouId());
            pEditSkTblBean.getSateiIppanHanteiInfo().setKossyorisscd(kinouMode.getKinouMode());
            pEditSkTblBean.getSateiIppanHanteiInfo().setGyoumuKousinsyaId(baseUserInfo.getUserId());
            pEditSkTblBean.getSateiIppanHanteiInfo().setGyoumuKousinTime(systemYmdTime);
        }

        if (pEditSkTblBean.getSateiKokuhanInfo() != null) {

            pEditSkTblBean.getSateiKokuhanInfo().setSkno(pEditSkTblBean.getSkNo());
            pEditSkTblBean.getSateiKokuhanInfo().setSyono(pEditSkTblBean.getSyoNo());
            pEditSkTblBean.getSateiKokuhanInfo().setSeikyuurirekino(pEditSkTblBean.getSeikyuuRirekiNo());
            pEditSkTblBean.getSateiKokuhanInfo().setKossyoricd(kinou.getKinouId());
            pEditSkTblBean.getSateiKokuhanInfo().setKossyorisscd(kinouMode.getKinouMode());
            pEditSkTblBean.getSateiKokuhanInfo().setGyoumuKousinsyaId(baseUserInfo.getUserId());
            pEditSkTblBean.getSateiKokuhanInfo().setGyoumuKousinTime(systemYmdTime);
        }

        if (pEditSkTblBean.getSibouSateiChkInfo() != null) {

            pEditSkTblBean.getSibouSateiChkInfo().setSkno(pEditSkTblBean.getSkNo());
            pEditSkTblBean.getSibouSateiChkInfo().setSyono(pEditSkTblBean.getSyoNo());
            pEditSkTblBean.getSibouSateiChkInfo().setSeikyuurirekino(pEditSkTblBean.getSeikyuuRirekiNo());
            pEditSkTblBean.getSibouSateiChkInfo().setKossyoricd(kinou.getKinouId());
            pEditSkTblBean.getSibouSateiChkInfo().setKossyorisscd(kinouMode.getKinouMode());
            pEditSkTblBean.getSibouSateiChkInfo().setGyoumuKousinsyaId(baseUserInfo.getUserId());
            pEditSkTblBean.getSibouSateiChkInfo().setGyoumuKousinTime(systemYmdTime);
        }

        if (pEditSkTblBean.getToriatukaifuryouinfo() != null) {

            pEditSkTblBean.getToriatukaifuryouinfo().setSkno(pEditSkTblBean.getSkNo());
            pEditSkTblBean.getToriatukaifuryouinfo().setSyono(pEditSkTblBean.getSyoNo());
            pEditSkTblBean.getToriatukaifuryouinfo().setSeikyuurirekino(pEditSkTblBean.getSeikyuuRirekiNo());
            pEditSkTblBean.getToriatukaifuryouinfo().setKossyoricd(kinou.getKinouId());
            pEditSkTblBean.getToriatukaifuryouinfo().setKossyorisscd(kinouMode.getKinouMode());
            pEditSkTblBean.getToriatukaifuryouinfo().setGyoumuKousinsyaId(baseUserInfo.getUserId());
            pEditSkTblBean.getToriatukaifuryouinfo().setGyoumuKousinTime(systemYmdTime);
        }

        if (pEditSkTblBean.getSateiKaijyoInfo() != null) {

            pEditSkTblBean.getSateiKaijyoInfo().setSkno(pEditSkTblBean.getSkNo());
            pEditSkTblBean.getSateiKaijyoInfo().setSyono(pEditSkTblBean.getSyoNo());
            pEditSkTblBean.getSateiKaijyoInfo().setSeikyuurirekino(pEditSkTblBean.getSeikyuuRirekiNo());
            pEditSkTblBean.getSateiKaijyoInfo().setKossyoricd(kinou.getKinouId());
            pEditSkTblBean.getSateiKaijyoInfo().setKossyorisscd(kinouMode.getKinouMode());
            pEditSkTblBean.getSateiKaijyoInfo().setGyoumuKousinsyaId(baseUserInfo.getUserId());
            pEditSkTblBean.getSateiKaijyoInfo().setGyoumuKousinTime(systemYmdTime);
        }

        if (pEditSkTblBean.getSateiMeigihenkouInfo() != null) {

            pEditSkTblBean.getSateiMeigihenkouInfo().setSkno(pEditSkTblBean.getSkNo());
            pEditSkTblBean.getSateiMeigihenkouInfo().setSyono(pEditSkTblBean.getSyoNo());
            pEditSkTblBean.getSateiMeigihenkouInfo().setSeikyuurirekino(pEditSkTblBean.getSeikyuuRirekiNo());
            pEditSkTblBean.getSateiMeigihenkouInfo().setKossyoricd(kinou.getKinouId());
            pEditSkTblBean.getSateiMeigihenkouInfo().setKossyorisscd(kinouMode.getKinouMode());
            pEditSkTblBean.getSateiMeigihenkouInfo().setGyoumuKousinsyaId(baseUserInfo.getUserId());
            pEditSkTblBean.getSateiMeigihenkouInfo().setGyoumuKousinTime(systemYmdTime);
        }

        if (pEditSkTblBean.getBetukutiSateiInfo() != null) {

            pEditSkTblBean.getBetukutiSateiInfo().setSkno(pEditSkTblBean.getSkNo());
            pEditSkTblBean.getBetukutiSateiInfo().setSyono(pEditSkTblBean.getSyoNo());
            pEditSkTblBean.getBetukutiSateiInfo().setSeikyuurirekino(pEditSkTblBean.getSeikyuuRirekiNo());
            pEditSkTblBean.getBetukutiSateiInfo().setKossyoricd(kinou.getKinouId());
            pEditSkTblBean.getBetukutiSateiInfo().setKossyorisscd(kinouMode.getKinouMode());
            pEditSkTblBean.getBetukutiSateiInfo().setGyoumuKousinsyaId(baseUserInfo.getUserId());
            pEditSkTblBean.getBetukutiSateiInfo().setGyoumuKousinTime(systemYmdTime);
        }

        if (pEditSkTblBean.getSateiJyuukasituChkInfo() != null) {

            pEditSkTblBean.getSateiJyuukasituChkInfo().setSkno(pEditSkTblBean.getSkNo());
            pEditSkTblBean.getSateiJyuukasituChkInfo().setSyono(pEditSkTblBean.getSyoNo());
            pEditSkTblBean.getSateiJyuukasituChkInfo().setSeikyuurirekino(pEditSkTblBean.getSeikyuuRirekiNo());
            pEditSkTblBean.getSateiJyuukasituChkInfo().setKossyoricd(kinou.getKinouId());
            pEditSkTblBean.getSateiJyuukasituChkInfo().setKossyorisscd(kinouMode.getKinouMode());
            pEditSkTblBean.getSateiJyuukasituChkInfo().setGyoumuKousinsyaId(baseUserInfo.getUserId());
            pEditSkTblBean.getSateiJyuukasituChkInfo().setGyoumuKousinTime(systemYmdTime);
        }
    }
}