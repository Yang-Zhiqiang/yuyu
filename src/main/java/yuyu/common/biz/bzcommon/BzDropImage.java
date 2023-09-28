package yuyu.common.biz.bzcommon;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.common.biz.workflow.IwfImageClient;
import yuyu.common.biz.workflow.io.image.DropImageInBean;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.dropimagebyid.WSDropImageByIdResponse;

/**
 * 業務共通 共通 業務共通イメージ削除
 */
public class BzDropImage {

    @Inject
    private static Logger logger;

    public BzDropImage() {
        super();
    }

    public BzDropImageOutputBean exec(BzDropImageInputBean pBzDropImageInputBean) {

        logger.debug("▽ 業務共通イメージ削除 開始");

        DropImageInBean dropImageInBean = SWAKInjector.getInstance(DropImageInBean.class);
        BzDropImageOutputBean bzDropImageOutputBean = SWAKInjector.getInstance(BzDropImageOutputBean.class);
        IwfImageClient iwfImageClient = SWAKInjector.getInstance(IwfImageClient.class);

        dropImageInBean.setImageids(new String[]{pBzDropImageInputBean.getImageId()});
        dropImageInBean.setAccountid(pBzDropImageInputBean.getUserId());

        WSDropImageByIdResponse wDropImageByIdResponse = iwfImageClient.execDropImage(dropImageInBean);

        bzDropImageOutputBean.setSyousaiMsgCd(wDropImageByIdResponse.getSyousaimsgcd());
        bzDropImageOutputBean.setSyousaiMsg(wDropImageByIdResponse.getSyousaimsg());

        if (!"0".equals(wDropImageByIdResponse.getKekkastatus())) {

            if ("IWF3073".equals(wDropImageByIdResponse.getSyousaimsgcd())) {
                bzDropImageOutputBean.setKekkaStatus("-1");
            } else {
                bzDropImageOutputBean.setKekkaStatus(wDropImageByIdResponse.getKekkastatus());
            }

        } else {

            bzDropImageOutputBean.setKekkaStatus(wDropImageByIdResponse.getKekkastatus());

        }

        logger.debug("△ 業務共通イメージ削除 終了");

        return bzDropImageOutputBean;
    }
}
