package yuyu.common.biz.bzcommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.workflow.IwfImageClient;
import yuyu.common.biz.workflow.io.image.GetImagePropsInBean;
import yuyu.common.biz.workflow.io.image.GetImagePropsOutBean;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettargetimageprops.WSGetTargetImagePropsResponse.ImagePropsBean;

/**
 * 業務共通 共通 業務共通イメージプロパティ取得
 */
public class BzGetImageProps {

    @Inject
    private static Logger logger;

    @Inject
    private IwfImageClient iwfImageClient;

    @Inject
    private BaseUserInfo baseUserInfo;

    public BzGetImageProps() {
        super();
    }

    public BzGetImagePropsOutBean exec(BzGetImagePropsInBean pBzGetImagePropsInBean) {

        logger.debug("▽ 業務共通イメージプロパティ取得 開始");

        GetImagePropsInBean getImagePropsInBean = SWAKInjector.getInstance(GetImagePropsInBean.class);

        getImagePropsInBean.setAccountid(baseUserInfo.getUserId());
        if (!BizUtil.isBlank(pBzGetImagePropsInBean.getJimuTetuzukiCd())) {
            getImagePropsInBean.setFlowid(pBzGetImagePropsInBean.getJimuTetuzukiCd());
        }
        if (!BizUtil.isBlank(pBzGetImagePropsInBean.getKouteiKanriId())) {
            getImagePropsInBean.setGyoumukey(pBzGetImagePropsInBean.getKouteiKanriId());
        }
        if (pBzGetImagePropsInBean.getSyoruiCd() != null) {
            getImagePropsInBean.setTorikomisyoruicd(pBzGetImagePropsInBean.getSyoruiCd().getValue());
        }
        String syoruiTtykYmdTimeFrom = pBzGetImagePropsInBean.getSyoruiTtykYmdTimeFrom();
        String syoruiTtykYmdTimeTo = pBzGetImagePropsInBean.getSyoruiTtykYmdTimeTo();
        if (!BizUtil.isBlank(syoruiTtykYmdTimeFrom)) {
            getImagePropsInBean.setSyoruitoutyakuymdfrom(syoruiTtykYmdTimeFrom);
            if (!BizUtil.isBlank(syoruiTtykYmdTimeTo)) {
                getImagePropsInBean.setSyoruitoutyakuymdto(syoruiTtykYmdTimeTo);
            }
            else {
                getImagePropsInBean.setSyoruitoutyakuymdto("99999999999999999");
            }
        }
        else if (!BizUtil.isBlank(syoruiTtykYmdTimeTo)) {
            getImagePropsInBean.setSyoruitoutyakuymdfrom("00000000000000000");
            getImagePropsInBean.setSyoruitoutyakuymdto(syoruiTtykYmdTimeTo);
        }
        if (pBzGetImagePropsInBean.getKouteiKanriStatus() != null) {
            getImagePropsInBean.setKouteijyoutai(pBzGetImagePropsInBean.getKouteiKanriStatus().getValue());
        }

        GetImagePropsOutBean getImagePropsOutBean = iwfImageClient.execGetImageProps(getImagePropsInBean);

        BzGetImagePropsOutBean bzGetImagePropsOutBean = SWAKInjector.getInstance(BzGetImagePropsOutBean.class);
        bzGetImagePropsOutBean.setKekkaStatus(getImagePropsOutBean.getKekkastatus());
        bzGetImagePropsOutBean.setSyousaiMsgCd(getImagePropsOutBean.getSyousaimsgcd());
        bzGetImagePropsOutBean.setSyousaiMsg(getImagePropsOutBean.getSyousaimsg());

        List<BzGetImagePropsBean> bzGetImagePropsBeanLst = new ArrayList<>();
        List<ImagePropsBean> imagePropsBeanLst = getImagePropsOutBean.getImagepropslist();

        if (imagePropsBeanLst != null) {
            for (int index = 0; index < imagePropsBeanLst.size(); index++) {
                BzGetImagePropsBean bzGetImagePropsBean = SWAKInjector.getInstance(BzGetImagePropsBean.class);
                bzGetImagePropsBean.setImageId(imagePropsBeanLst.get(index).getImageid());
                bzGetImagePropsBean.setKouteiKanriId(imagePropsBeanLst.get(index).getGyoumukey());
                if (!BizUtil.isBlank(imagePropsBeanLst.get(index).getTorikomisyoruicd())) {
                    bzGetImagePropsBean.setSyoruiCd(C_SyoruiCdKbn.valueOf(imagePropsBeanLst.get(index).getTorikomisyoruicd()));
                }
                bzGetImagePropsBean.setSyoruiTtykYmdTime(imagePropsBeanLst.get(index).getSyoruitoutyakutime());
                if (!BizUtil.isBlank(imagePropsBeanLst.get(index).getKouteijyoutai())) {
                    bzGetImagePropsBean.setKouteiKanriStatus(C_Kouteikanristatus.valueOf(imagePropsBeanLst.get(index).getKouteijyoutai()));
                }
                bzGetImagePropsBean.setKengenUmu(imagePropsBeanLst.get(index).getKengenumu());
                bzGetImagePropsBean.setTourokuAccountId(imagePropsBeanLst.get(index).getTourokuaccountid());
                bzGetImagePropsBean.setPageCount(imagePropsBeanLst.get(index).getPagecount());

                bzGetImagePropsBeanLst.add(bzGetImagePropsBean);
            }
        }

        bzGetImagePropsOutBean.setBzGetImagePropsBeanLst(bzGetImagePropsBeanLst);
        logger.debug("△ 業務共通イメージプロパティ取得 終了");
        return bzGetImagePropsOutBean;
    }
}
