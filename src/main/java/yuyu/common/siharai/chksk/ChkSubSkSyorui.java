package yuyu.common.siharai.chksk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BzGetImageProps;
import yuyu.common.biz.bzcommon.BzGetImagePropsInBean;
import yuyu.common.biz.bzcommon.BzGetImagePropsOutBean;
import yuyu.common.siharai.sicommon.TeisuuSiharai;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.JT_SkKihon;

/**
 * 保険金給付金支払 請求内容チェック 請求書類チェック
 */
public class ChkSubSkSyorui {

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private static Logger logger;

    public ChkSubSkSyorui() {
        super();
    }

    public void exec(JT_SkKihon pSkKihon, List<ChkKekkaBean> pChkKekkaBeanLst) {

        logger.debug("▽ 請求書類チェック 開始");

        List<BT_GyoumuKouteiInfo> gyoumuKouteiInfoLst = bizDomManager.getGyoumuKouteiInfosByJimutetuzukicdSyonoSkno(
            TeisuuSiharai.JIMUTETUZUKICD_SISIBOU, pSkKihon.getSyono(), pSkKihon.getSkno());

        if (gyoumuKouteiInfoLst.size() > 0) {
            BzGetImageProps bzGetImageProps = SWAKInjector.getInstance(BzGetImageProps.class);
            BzGetImagePropsInBean bzGetImagePropsInBean = SWAKInjector.getInstance(BzGetImagePropsInBean.class);

            bzGetImagePropsInBean.setKouteiKanriId(gyoumuKouteiInfoLst.get(0).getKouteikanriid());
            bzGetImagePropsInBean.setSyoruiCd(C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS);

            BzGetImagePropsOutBean bzGetImagePropsOutBean = bzGetImageProps.exec(bzGetImagePropsInBean);

            if (bzGetImagePropsOutBean.getBzGetImagePropsBeanLst() != null &&
                bzGetImagePropsOutBean.getBzGetImagePropsBeanLst().size() > 0) {
                ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SATEICHK_SKSYORUI);
                pChkKekkaBeanLst.add(chkKekkaBean);
            }
        }

        logger.debug("△ 請求書類チェック 終了");
    }
}