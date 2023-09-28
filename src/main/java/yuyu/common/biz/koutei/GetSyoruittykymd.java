package yuyu.common.biz.koutei;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.workflow.IwfImageClient;
import yuyu.common.biz.workflow.io.image.GetImagePropsInBean;
import yuyu.common.biz.workflow.io.image.GetImagePropsOutBean;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettargetimageprops.WSGetTargetImagePropsResponse.ImagePropsBean;
import yuyu.def.MessageId;
import yuyu.def.classification.C_SyoruiCdKbn;

/**
 * 業務共通 工程 書類到着日取得
 */
public class GetSyoruittykymd {

    @Inject
    private IwfImageClient iwfImageClient;

    @Inject
    private BaseUserInfo baseUserInfo;

    public GetSyoruittykymd() {
        super();
    }

    public BizDate exec(String pKouteiKanriId, C_SyoruiCdKbn pSyoruiCd) {

        BizDate syoruiTtykYmd;

        GetImagePropsInBean getImagePropsInBean = SWAKInjector.getInstance(GetImagePropsInBean.class);

        getImagePropsInBean.setAccountid(baseUserInfo.getUserId());
        getImagePropsInBean.setGyoumukey(pKouteiKanriId);
        getImagePropsInBean.setTorikomisyoruicd(pSyoruiCd.getValue());

        GetImagePropsOutBean getImagePropsOutBean = iwfImageClient.execGetImageProps(getImagePropsInBean);

        String kekkaStatus = getImagePropsOutBean.getKekkastatus();
        String syousaiMsgCd = getImagePropsOutBean.getSyousaimsgcd();

        if (BzIwfUtilConstants.API_RESULTCD_OK.equals(kekkaStatus)) {
        }
        else {
            throw new BizAppException(
                    MessageId.EBS0007, "書類到着日取得", "イメージプロパティ取得", syousaiMsgCd);
        }

        List<ImagePropsBean> imagePropsBeanLst = getImagePropsOutBean.getImagepropslist();

        if (imagePropsBeanLst == null || imagePropsBeanLst.size() == 0) {
            syoruiTtykYmd = null;
        }
        else if (imagePropsBeanLst.size() == 1) {
            syoruiTtykYmd = BizDate.valueOf(imagePropsBeanLst.get(0).getSyoruitoutyakutime().substring(0, 8));
        }
        else {
            String syoruittykYmdLast = imagePropsBeanLst.get(0).getSyoruitoutyakutime();

            for (int index = 1; index < imagePropsBeanLst.size(); index++) {
                if (imagePropsBeanLst.get(index).getSyoruitoutyakutime().compareTo(syoruittykYmdLast) > 0) {
                    syoruittykYmdLast = imagePropsBeanLst.get(index).getSyoruitoutyakutime();
                }
            }

            syoruiTtykYmd = BizDate.valueOf(syoruittykYmdLast.substring(0, 8));
        }

        return syoruiTtykYmd;
    }

    public BizDate getSyoruiTtykymdFirst(String pKouteiKanriId, C_SyoruiCdKbn pSyoruiCd) {

        BizDate syoruiTtykYmd;

        GetImagePropsInBean getImagePropsInBean = SWAKInjector.getInstance(GetImagePropsInBean.class);

        getImagePropsInBean.setAccountid(baseUserInfo.getUserId());
        getImagePropsInBean.setGyoumukey(pKouteiKanriId);
        getImagePropsInBean.setTorikomisyoruicd(pSyoruiCd.getValue());

        GetImagePropsOutBean getImagePropsOutBean = iwfImageClient.execGetImageProps(getImagePropsInBean);

        String kekkaStatus = getImagePropsOutBean.getKekkastatus();
        String syousaiMsgCd = getImagePropsOutBean.getSyousaimsgcd();

        if (BzIwfUtilConstants.API_RESULTCD_OK.equals(kekkaStatus)) {
        }
        else {
            throw new BizAppException(
                    MessageId.EBS0007, "書類到着日取得", "イメージプロパティ取得", syousaiMsgCd);
        }

        List<ImagePropsBean> imagePropsBeanLst = getImagePropsOutBean.getImagepropslist();

        if (imagePropsBeanLst == null || imagePropsBeanLst.size() == 0) {
            syoruiTtykYmd = null;
        }
        else if (imagePropsBeanLst.size() == 1) {
            syoruiTtykYmd = BizDate.valueOf(imagePropsBeanLst.get(0).getSyoruitoutyakutime().substring(0, 8));
        }
        else {
            String syoruittykYmdMin = imagePropsBeanLst.get(0).getSyoruitoutyakutime();

            for (int index = 1; index < imagePropsBeanLst.size(); index++) {
                if (imagePropsBeanLst.get(index).getSyoruitoutyakutime().compareTo(syoruittykYmdMin) < 0) {
                    syoruittykYmdMin = imagePropsBeanLst.get(index).getSyoruitoutyakutime();
                }
            }

            syoruiTtykYmd = BizDate.valueOf(syoruittykYmdMin.substring(0, 8));
        }

        return syoruiTtykYmd;
    }
}
