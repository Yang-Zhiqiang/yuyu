package yuyu.common.biz.bzcommon;

import javax.persistence.Column;

import yuyu.def.db.mapping.GenAM_Batch;

public class ConvClass7 {

    private String paramBeanClass;

    @Column(name=GenAM_Batch.PARAMBEANCLASS)
    public String getParamBeanClass() {
        return paramBeanClass;
    }

    public void setParamBeanClass(String pParamBeanClass) {
        paramBeanClass = pParamBeanClass;
    }
}
