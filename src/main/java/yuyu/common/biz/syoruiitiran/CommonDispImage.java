package yuyu.common.biz.syoruiitiran;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.syoruiitiran.syoruiitiranutil.DispImageResultBean;
import yuyu.common.biz.syoruiitiran.syoruiitiranutil.SyoruiResultConstants;
import yuyu.common.biz.syoruiitiran.syoruiitiranutil.SyoruiUtility;
import yuyu.def.MessageId;

/**
 * 業務共通 書類情報一覧 イメージ表示共通
 */
public class CommonDispImage {

    public void execDispImage(String pImageid) {
        DispImageResultBean dispImageResultBean = SyoruiUtility.dispImage(new String[]{pImageid});
        if (!SyoruiResultConstants.RESULT_OK.equals(dispImageResultBean.getSyorikekkaStatus())) {
            if (SyoruiResultConstants.RESULT_NODATA.equals(dispImageResultBean.getSyorikekkaStatus())) {
                throw new BizLogicException(MessageId.EBF1020);
            }
            throw new CommonBizAppException("イメージ表示処理が正常終了しませんでした。");
        }
    }

    public void execDispImageAll(String[] pImageids) {
        DispImageResultBean dispImageResultBean = SyoruiUtility.dispImage(pImageids);
        if (!SyoruiResultConstants.RESULT_OK.equals(dispImageResultBean.getSyorikekkaStatus())) {
            if (SyoruiResultConstants.RESULT_NODATA.equals(dispImageResultBean.getSyorikekkaStatus())) {
                throw new BizLogicException(MessageId.EBF1020);
            }
            throw new CommonBizAppException("イメージ表示処理が正常終了しませんでした。");
        }
    }
}
