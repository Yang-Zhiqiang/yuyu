package yuyu.common.biz.workflow.io.image;

import yuyu.common.workflowcore.core.webservice.provide.imagekanri.putArrivalImage.WSPutArrivalImageRequest;

/**
 * イメージ到着サービスの入力Bean
 */
@SuppressWarnings("serial")
public class PutArrivalImageInBean extends WSPutArrivalImageRequest {

    private byte[] bImagedata_;

    public byte[] getImagedata() {
        return bImagedata_;
    }

    public void setImagedata(byte[] pbImagedata) {
        bImagedata_ = pbImagedata;
    }

    @Override
    @Deprecated
    public void setImagedatastr(String psImagedatastr) {
    }

}
