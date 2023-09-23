package yuyu.common.siharai.edittbl;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.MessageId;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.infr.kinoumode.KinouMode;

/**
 * 保険金給付金支払 保険金給付金支払共通 査定承認履歴TBL編集
 */
public class EditSateiRrkTbl {

    private String sysDateTime;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private KinouMode kinoumode;

    public EditSateiRrkTbl() {
        super();
    }

    public EditSateiRrkTblBean exec(EditSateiRrkTblParam pEditSateiRrkTblParam,
        EditSateiRrkTblBean pEditSateiRrkTblBean) {

        inputCheck(pEditSateiRrkTblParam, pEditSateiRrkTblBean);
        sysDateTime = BizDate.getSysDateTimeMilli();


        if (pEditSateiRrkTblParam instanceof SiSyoriKekkaParam) {
            setSiSyoriKekka((SiSyoriKekkaParam)pEditSateiRrkTblParam, pEditSateiRrkTblBean);
        }

        if (pEditSateiRrkTblParam instanceof SiSyoriKekkaSateiParam) {
            setSiSyoriKekkaSatei((SiSyoriKekkaSateiParam)pEditSateiRrkTblParam, pEditSateiRrkTblBean);
        }

        setCommon(pEditSateiRrkTblBean);

        return pEditSateiRrkTblBean;
    }

    private void inputCheck(EditSateiRrkTblParam pEditSateiRrkTblParam, EditSateiRrkTblBean pEditSateiRrkTblBean) {

        if (pEditSateiRrkTblParam == null) {
            throw new BizAppException(MessageId.EJS1005, "pEditSateiRrkTblParam");
        }
        if (pEditSateiRrkTblBean == null) {
            throw new BizAppException(MessageId.EJS1005, "pEditSateiRrkTblBean");
        }

        if (BizUtil.isBlank(pEditSateiRrkTblBean.getSkno())) {
            throw new BizAppException(MessageId.EJS1005, "skno");
        }

        if (BizUtil.isBlank(pEditSateiRrkTblBean.getSyono())) {
            throw new BizAppException(MessageId.EJS1005, "syono");
        }

        if (BizUtil.isBlank(pEditSateiRrkTblBean.getSateisyouninskbtkey())) {
            throw new BizAppException(MessageId.EJS1005, "sateisyouninskbtkey");
        }
    }

    private void setSiSyoriKekka(SiSyoriKekkaParam pSiSyoriKekkaParam, EditSateiRrkTblBean pEditSateiRrkTblBean) {
        SiSyoriKekkaParam siSyoriKekkaParam = SWAKInjector.getInstance(SiSyoriKekkaParamImpl.class);

        BeanUtil.copyProperties(siSyoriKekkaParam, pSiSyoriKekkaParam);

        BeanUtil.copyProperties(pEditSateiRrkTblBean.getSateiSyouninRireki(), siSyoriKekkaParam);
    }

    private void setSiSyoriKekkaSatei(SiSyoriKekkaSateiParam pSiSyoriKekkaSateiParam,
        EditSateiRrkTblBean pEditSateiRrkTblBean) {

        SiSyoriKekkaSateiParam siSyoriKekkaSateiParam = SWAKInjector.getInstance(SiSyoriKekkaSateiParamImpl.class);

        BeanUtil.copyProperties(siSyoriKekkaSateiParam, pSiSyoriKekkaSateiParam);

        BeanUtil.copyProperties(pEditSateiRrkTblBean.getSateiSyouninRireki(), siSyoriKekkaSateiParam);
    }

    private void setCommon(EditSateiRrkTblBean pEditSateiRrkTblBean) {

        pEditSateiRrkTblBean.getSateiSyouninRireki().setSkno(pEditSateiRrkTblBean.getSkno());

        pEditSateiRrkTblBean.getSateiSyouninRireki().setSyono(pEditSateiRrkTblBean.getSyono());

        pEditSateiRrkTblBean.getSateiSyouninRireki().setSateisyouninskbtkey(
            pEditSateiRrkTblBean.getSateisyouninskbtkey());

        pEditSateiRrkTblBean.getSateiSyouninRireki().setSeikyuurirekino(
            pEditSateiRrkTblBean.getSeikyuurirekino());

        pEditSateiRrkTblBean.getSateiSyouninRireki().setKossyoricd(kinou.getKinouId());

        pEditSateiRrkTblBean.getSateiSyouninRireki().setKossyorisscd(kinoumode.getKinouMode());

        pEditSateiRrkTblBean.getSateiSyouninRireki().setGyoumuKousinsyaId(baseUserInfo.getUserId());

        pEditSateiRrkTblBean.getSateiSyouninRireki().setGyoumuKousinTime(sysDateTime);

    }
}