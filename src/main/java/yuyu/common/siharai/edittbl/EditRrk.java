package yuyu.common.siharai.edittbl;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.SaibanBiz;
import yuyu.def.MessageId;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.infr.kinoumode.KinouMode;

/**
 * 保険金給付金支払 保険金給付金支払共通 手続履歴TBL編集
 */
public class EditRrk {
    private String sysDateTime;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private KinouMode kinoumode;

    @Inject
    private BaseUserInfo baseUserInfo;

    public EditRrk() {
        super();
    }

    public EditRrkTblBean makeTtdkRrk(EditRrkTblParam pEditRrkTblParam,
        EditRrkTblBean pEditRrkTblBean) {

        inputCheck(pEditRrkTblParam, pEditRrkTblBean);

        sysDateTime = BizDate.getSysDateTimeMilli();


        if (pEditRrkTblParam instanceof SiKekkaInputParam) {
            setSiKekkaInput((SiKekkaInputParam) pEditRrkTblParam, pEditRrkTblBean);
        }

        setCommon(pEditRrkTblBean);

        return pEditRrkTblBean;
    }

    private void inputCheck(EditRrkTblParam pEditRrkTblParam, EditRrkTblBean pEditRrkTblBean) {

        if (pEditRrkTblParam == null) {
            throw new BizAppException(MessageId.EJS1005, "pEditRrkTblParam");
        }
        if (pEditRrkTblBean == null) {
            throw new BizAppException(MessageId.EJS1005, "pEditRrkTblBean");
        }

        if (BizUtil.isBlank(pEditRrkTblBean.getSeiNo())) {
            throw new BizAppException(MessageId.EJS1005, "seiNo");
        }

        if (BizUtil.isBlank(pEditRrkTblBean.getSyoNo())) {
            throw new BizAppException(MessageId.EJS1005, "syoNo");
        }

        if (pEditRrkTblBean.getSyoriYmd() == null) {
            throw new BizAppException(MessageId.EJS1005, "syoriYmd");
        }
    }

    private void setSiKekkaInput(SiKekkaInputParam pSiKekkaInputParam, EditRrkTblBean pEditRrkTblBean) {
        SiKekkaInputParam siKekkaInputParam = SWAKInjector.getInstance(SiKekkaInputParamImpl.class);

        BeanUtil.copyProperties(siKekkaInputParam, pSiKekkaInputParam);

        BeanUtil.copyProperties(pEditRrkTblBean.getTtdkRireki(), siKekkaInputParam);
    }

    private void setCommon(EditRrkTblBean pEditRrkTblBean) {
        String ttdkrrkskbtkey = SaibanBiz.getTetudukirirekiSikibetukey(pEditRrkTblBean.getSyoNo());

        pEditRrkTblBean.getTtdkRireki().setSkno(pEditRrkTblBean.getSeiNo());

        pEditRrkTblBean.getTtdkRireki().setSyono(pEditRrkTblBean.getSyoNo());

        pEditRrkTblBean.getTtdkRireki().setTtdkrrkskbtkey(ttdkrrkskbtkey);

        pEditRrkTblBean.getTtdkRireki().setSyoriYmd(pEditRrkTblBean.getSyoriYmd());

        pEditRrkTblBean.getTtdkRireki().setSyorisosikicd(baseUserInfo.getTmSosikiCd());

        pEditRrkTblBean.getTtdkRireki().setJimukakuteiumukbn(pEditRrkTblBean.getJimKakuteiUmuKbn());

        pEditRrkTblBean.getTtdkRireki().setSeikyuurirekino(pEditRrkTblBean.getSeiRrkNo());

        pEditRrkTblBean.getTtdkRireki().setShrsikibetukey(pEditRrkTblBean.getShrSkbtKey());

        pEditRrkTblBean.getTtdkRireki().setSateisyouninskbtkey(pEditRrkTblBean.getSateiSkbtKey());

        pEditRrkTblBean.getTtdkRireki().setKossyoricd(kinou.getKinouId());

        pEditRrkTblBean.getTtdkRireki().setKossyorisscd(kinoumode.getKinouMode());

        pEditRrkTblBean.getTtdkRireki().setGyoumuKousinsyaId(baseUserInfo.getUserId());

        pEditRrkTblBean.getTtdkRireki().setGyoumuKousinTime(sysDateTime);
    }
}