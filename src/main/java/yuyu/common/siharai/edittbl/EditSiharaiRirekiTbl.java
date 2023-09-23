package yuyu.common.siharai.edittbl;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;

import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.MessageId;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.infr.kinoumode.KinouMode;

/**
 * 保険金給付金支払 保険金給付金支払共通 支払履歴TBL編集クラス
 */
public class EditSiharaiRirekiTbl {

    @Inject
    private static Logger logger;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private KinouMode kinoumode;

    private String sysDateTimeMilli;

    public EditSiharaiRirekiTbl() {
        super();
    }

    public EditSiharaiRirekiTblBean exec(EditSiharaiRirekiTblParam pEditSiharaiRirekiTblParam,
        EditSiharaiRirekiTblBean pEditSiharaiRirekiTblBean) {

        logger.debug("▽ 支払履歴TBL編集 開始");

        chkInput(pEditSiharaiRirekiTblParam, pEditSiharaiRirekiTblBean);

        sysDateTimeMilli = BizDate.getSysDateTimeMilli();


        if (pEditSiharaiRirekiTblParam instanceof SiharaiRirekiParam) {
            SiharaiRirekiParam siharaiRirekiParam = (SiharaiRirekiParam) pEditSiharaiRirekiTblParam;

            setSiharaiRireki(siharaiRirekiParam, pEditSiharaiRirekiTblBean);
        }

        editCommon(pEditSiharaiRirekiTblBean);

        logger.debug("△ 支払履歴TBL編集 終了");

        return pEditSiharaiRirekiTblBean;
    }

    private void chkInput(EditSiharaiRirekiTblParam pEditSiharaiRirekiTblParam,
        EditSiharaiRirekiTblBean pEditSiharaiRirekiTblBean) {


        if (pEditSiharaiRirekiTblBean == null) {
            throw new BizAppException(MessageId.EJS1005, "pEditSiharaiRirekiTblBean");
        }
        if (pEditSiharaiRirekiTblParam == null) {
            throw new BizAppException(MessageId.EJS1005, "pEditSiharaiRirekiTblParam");
        }
        if (BizUtil.isBlank(pEditSiharaiRirekiTblBean.getSkno())) {
            throw new BizAppException(MessageId.EJS1005, "skno");
        }
        if (BizUtil.isBlank(pEditSiharaiRirekiTblBean.getSyono())) {
            throw new BizAppException(MessageId.EJS1005, "syono");
        }
        if (BizUtil.isBlank(pEditSiharaiRirekiTblBean.getShrsikibetukey())) {
            throw new BizAppException(MessageId.EJS1005, "shrsikibetukey");
        }
    }

    private void setSiharaiRireki(SiharaiRirekiParam pSiharaiRirekiParam,
        EditSiharaiRirekiTblBean pEditSiharaiRirekiTblBean) {

        SiharaiRirekiParam siharaiRirekiParam = new  SiharaiRirekiParamImpl();

        BeanUtil.copyProperties(siharaiRirekiParam, pSiharaiRirekiParam);
        BeanUtil.copyProperties(pEditSiharaiRirekiTblBean.getSirireki(), siharaiRirekiParam);
    }

    private void editCommon(EditSiharaiRirekiTblBean pEditSiharaiRirekiTblBean) {

        BeanUtil.copyProperties(pEditSiharaiRirekiTblBean.getSirireki(), pEditSiharaiRirekiTblBean);

        pEditSiharaiRirekiTblBean.getSirireki().setKossyoricd(kinou.getKinouId());
        pEditSiharaiRirekiTblBean.getSirireki().setKossyorisscd(kinoumode.getKinouMode());
        pEditSiharaiRirekiTblBean.getSirireki().setGyoumuKousinsyaId(baseUserInfo.getUserId());
        pEditSiharaiRirekiTblBean.getSirireki().setGyoumuKousinTime(sysDateTimeMilli);
    }
}