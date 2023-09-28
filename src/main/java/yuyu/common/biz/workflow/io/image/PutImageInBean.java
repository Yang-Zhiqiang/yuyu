package yuyu.common.biz.workflow.io.image;

import java.util.List;
import java.util.Map;

import yuyu.common.workflowcore.core.webservice.provide.imagekanri.putimage.WSPutImageRequest;

/**
 * イメージ登録サービスの入力Bean
 */
@SuppressWarnings("serial")
public class PutImageInBean extends WSPutImageRequest {

    private byte[] bImagedata_;

    private List<Map<String, String>> extInfo_;

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

    public List<Map<String, String>> getExtInfo() {
        return extInfo_;
    }

    public void setExtInfo(List<Map<String, String>> pExtInfo) {
        extInfo_ = pExtInfo;
    }

    @Override
    @Deprecated
    public void setExtinfo(String psExtInfo) {
    }
}
