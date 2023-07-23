
package yuyu.infrext.mq;

import jp.co.slcs.swak.core.inject.annotation.ThreadScoped;


/**
 * RayWebServiceAuthInfo のロジックです。
 */
@ThreadScoped
public class RayWebServiceAuthInfo {


    private String SosikiCd;
    private String OperatorId;

    public String getSosikiCd(){
        return this.SosikiCd;
    }

    public void setSosikiCd(String SosikiCd){
        this.SosikiCd = SosikiCd;
    }

    public String getOperatorId(){
        return this.OperatorId;
    }

    public void setOperatorId(String OperatorId){
        this.OperatorId = OperatorId;
    }


}