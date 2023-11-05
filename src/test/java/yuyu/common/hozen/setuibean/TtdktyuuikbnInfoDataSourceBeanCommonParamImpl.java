package yuyu.common.hozen.setuibean;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_TtdktyuuiKbn;

public class TtdktyuuikbnInfoDataSourceBeanCommonParamImpl implements TtdktyuuikbnInfoDataSourceBeanCommonParam {

    private C_TtdktyuuiKbn vtdktttdktyuuikbn;
    @Override
    public C_TtdktyuuiKbn getVtdktttdktyuuikbn(){
        return vtdktttdktyuuikbn;
    }

    @Override
    public void setVtdktttdktyuuikbn(C_TtdktyuuiKbn pVtdktttdktyuuikbn){
        vtdktttdktyuuikbn = pVtdktttdktyuuikbn;
    }

    private String vtdktttdktyuuikbnhsknaiyou;

    @Override
    public String getVtdktttdktyikbnhsknaiyou(){
        return vtdktttdktyuuikbnhsknaiyou;
    }

    @Override
    public void setVtdktttdktyikbnhsknaiyou(String pVtdktttdktyuuikbnhsknaiyou){
        vtdktttdktyuuikbnhsknaiyou = pVtdktttdktyuuikbnhsknaiyou;
    }

    private BizDate vtdktttdktyuuikbnsetymd;
    @Override
    public BizDate getVtdktttdktyuuikbnsetymd(){
        return vtdktttdktyuuikbnsetymd;
    }

    @Override
    public void setVtdktttdktyuuikbnsetymd(BizDate pVtdktttdktyuuikbnsetymd){
        vtdktttdktyuuikbnsetymd = pVtdktttdktyuuikbnsetymd;
    }

    private String vtdktsetsosikinm;
    @Override
    public String getVtdktsetsosikinm(){
        return vtdktsetsosikinm;
    }

    @Override
    public void setVtdktsetsosikinm(String pVtdktsetsosikinm){
        vtdktsetsosikinm = pVtdktsetsosikinm;
    }
}
