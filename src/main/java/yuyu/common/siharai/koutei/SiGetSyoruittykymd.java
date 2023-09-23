package yuyu.common.siharai.koutei;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzGetImageProps;
import yuyu.common.biz.bzcommon.BzGetImagePropsBean;
import yuyu.common.biz.bzcommon.BzGetImagePropsInBean;
import yuyu.common.biz.bzcommon.BzGetImagePropsOutBean;
import yuyu.common.biz.koutei.BzIwfUtilConstants;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;

/**
 * 保険金給付金支払 工程 支払書類到着日取得
 */
public class SiGetSyoruittykymd {

    @Inject
    private BizDomManager bizDomManager;

    public SiGetSyoruittykymd() {
        super();
    }

    public BizDate exec(String pKouteiKanriId, String pSkNo, String pSyoNo, C_SyoruiCdKbn pSyoruiCd) {

        BizDate syoruiTtykYmd;
        String kouteiKanriId;

        if (BizUtil.isBlank(pKouteiKanriId)) {
            List<BT_GyoumuKouteiInfo> gyoumuKouteiInfoLst = bizDomManager
                .getGyoumuKouteiInfosBySyonoSkno(pSyoNo, pSkNo);
            kouteiKanriId = gyoumuKouteiInfoLst.get(0).getSyukouteikanriid();
        }
        else {
            kouteiKanriId = pKouteiKanriId;
        }

        BzGetImagePropsInBean bzGetImagePropsInBean = SWAKInjector.getInstance(BzGetImagePropsInBean.class);

        bzGetImagePropsInBean.setKouteiKanriId(kouteiKanriId);
        bzGetImagePropsInBean.setSyoruiCd(pSyoruiCd);

        BzGetImageProps bzGetImageProps = SWAKInjector.getInstance(BzGetImageProps.class);
        BzGetImagePropsOutBean bzGetImagePropsOutBean = bzGetImageProps.exec(bzGetImagePropsInBean);
        String kekkaStatus = bzGetImagePropsOutBean.getKekkaStatus();
        String syousaiMsgCd = bzGetImagePropsOutBean.getSyousaiMsgCd();

        if (!BzIwfUtilConstants.API_RESULTCD_OK.equals(kekkaStatus)) {
            String kinou = MessageUtil.getMessage(MessageId.IJW1039);
            String api = MessageUtil.getMessage(MessageId.IJW1040);
            throw new BizAppException(
                MessageId.EBS0007, kinou, api, syousaiMsgCd);
        }

        List<BzGetImagePropsBean> bzGetImagePropsBeanLst = bzGetImagePropsOutBean.getBzGetImagePropsBeanLst();

        if (bzGetImagePropsBeanLst == null || bzGetImagePropsBeanLst.size() == 0) {
            syoruiTtykYmd = null;
        }
        else if (bzGetImagePropsBeanLst.size() == 1) {
            syoruiTtykYmd = BizDate.valueOf(bzGetImagePropsBeanLst.get(0).getSyoruiTtykYmdTime().substring(0, 8));
        }
        else {
            String syoruittykYmdMin = bzGetImagePropsBeanLst.get(0).getSyoruiTtykYmdTime();

            for (BzGetImagePropsBean bzGetImagePropsBeanTemp : bzGetImagePropsBeanLst) {
                if (bzGetImagePropsBeanTemp.getSyoruiTtykYmdTime().compareTo(syoruittykYmdMin) < 0) {
                    syoruittykYmdMin = bzGetImagePropsBeanTemp.getSyoruiTtykYmdTime();
                }
            }
            syoruiTtykYmd = BizDate.valueOf(syoruittykYmdMin.substring(0, 8));
        }

        return syoruiTtykYmd;
    }
}
