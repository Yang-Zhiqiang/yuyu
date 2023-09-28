package yuyu.common.biz.syoruitoutyaku;

import iwf.callback.arriveimage.ToutyakuYoteiInfo;
import java.io.Serializable;

import yuyu.def.classification.C_SyoruiCdKbn;

/**
 * 業務共通 到着管理情報Bean
 */
public class ToutyakuInfoBean implements ToutyakuYoteiInfo, Serializable {

    private static final long serialVersionUID = 1L;

    private String toutyakuKey;

    private String appKey;

    private C_SyoruiCdKbn syoruiCdKbn;

    private String flowId;

    private String subSystemId;

    @Override
    public String getToutyakuKey() {
        return toutyakuKey;
    }

    public void setToutyakuKey(String pToutyakuKey) {
        this.toutyakuKey = pToutyakuKey;
    }

    @Override
    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String pAppKey) {
        this.appKey = pAppKey;
    }

    @Override
    public String getSyoruiCd() {
        return syoruiCdKbn == null ? null : syoruiCdKbn.getValue();
    }

    public C_SyoruiCdKbn getSyoruiCdKbn() {
        return syoruiCdKbn;
    }

    public void setSyoruiCdKbn(C_SyoruiCdKbn pSyoruiCdKbn) {
        this.syoruiCdKbn = pSyoruiCdKbn;
    }

    @Override
    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String pFlowId) {
        this.flowId = pFlowId;
    }

    @Override
    public String getSubSystemId() {
        return subSystemId;
    }

    public void setSubSystemId(String pSubSystemId) {
        this.subSystemId = pSubSystemId;
    }

}
