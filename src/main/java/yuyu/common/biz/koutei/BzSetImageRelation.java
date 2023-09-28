package yuyu.common.biz.koutei;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import yuyu.common.biz.workflow.IwfImageClient;
import yuyu.common.biz.workflow.io.image.SetImageRelationOutBean;
import yuyu.common.biz.workflow.io.image.SetImageReleationInBean;
import yuyu.def.MessageId;

/**
 * 業務共通 工程 業務共通イメージ関連設定
 */
public class BzSetImageRelation {

    @Inject
    private IwfImageClient iwfImageClient;

    public BzSetImageRelation() {
        super();
    }

    public void exec(String pImageId, String[] pKouteikanriIds) {

        SetImageReleationInBean imageReleationInBean = new SetImageReleationInBean();

        imageReleationInBean.setImageid(pImageId);
        imageReleationInBean.setGyoumukeys(pKouteikanriIds);
        imageReleationInBean.setSyorikbn(BzIwfUtilConstants.API_SYORIKBN_SETRELATION);

        SetImageRelationOutBean imageRelationOutBean = (SetImageRelationOutBean) iwfImageClient
                .setImageRelation(imageReleationInBean);

        String kekkaStatus = imageRelationOutBean.getKekkastatus();
        String syousaiMsgCd = imageRelationOutBean.getSyousaimsgcd();

        if (BzIwfUtilConstants.API_RESULTCD_OK.equals(kekkaStatus)) {
        }
        else {
            throw new BizAppException(
                    MessageId.EBS0007, "業務共通イメージ関連設定", "イメージ関連設定", syousaiMsgCd);
        }
    }
}
