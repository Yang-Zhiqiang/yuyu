package yuyu.common.workflowcore.core.webservice.common;

import java.io.Serializable;

import jp.co.slcs.swak.util.string.DebugUtil;

/**
 * Webサービスリクエスト 追加パラメータ項目を定義します。<br/>
 */
@SuppressWarnings("serial")
public class WSExtParam implements Serializable {

    private String[] values;

    private String value;

    private String valueFrom;

    private String valueTo;

    @Deprecated
    public String getValue() {
        if(null != values){
            return values[0];
        }
        return null;
    }

    @Deprecated
    public String[] getValues() {
        return values;
    }

    public void setValues(String... pValues) {
        values = pValues;
    }

    @Deprecated
    public String getValueFrom() {
        return valueFrom;
    }

    public void setValueFrom(String pValueFrom) {
        valueFrom = pValueFrom;
    }

    @Deprecated
    public String getValueTo() {
        return valueTo;
    }

    public void setValueTo(String pValueTo) {
        valueTo = pValueTo;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{ " +
            "values:"    + DebugUtil.toString(values)    + ", " +
            "valueFrom:" + DebugUtil.toString(valueFrom) + ", " +
            "valueTo:"   + DebugUtil.toString(valueTo)   +
            " }";
    }

}