package yuyu.common.hozen.setuibean;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_UnitFundKbn;

public class TbktInfoDataSourceBeanCommonParamImpl implements TbktInfoDataSourceBeanCommonParam {

    private String vhsyudispfundunitkbnval;

    private C_UnitFundKbn vhsyudispfundunitkbn;

    private BizNumber vhsyudispunitsuu;

    private BizNumber vhsyudispfundindex;

    private BizCurrency vhsyudisptutakngk;

    private BizNumber vhsyudispwariai;


    @Override
    public String getVhsyudispfundunitkbnval() {
        return vhsyudispfundunitkbnval;
    }
    @Override
    public void setVhsyudispfundunitkbnval(String pVhsyudispfundunitkbnval){
        this.vhsyudispfundunitkbnval = pVhsyudispfundunitkbnval;
    }

    @Override
    public C_UnitFundKbn getVhsyudispfundunitkbn(){
        return vhsyudispfundunitkbn;
    }

    @Override
    public void setVhsyudispfundunitkbn(C_UnitFundKbn pVhsyudispfundunitkbn){
        this.vhsyudispfundunitkbn = pVhsyudispfundunitkbn;
    }

    @Override
    public BizNumber getVhsyudispunitsuu(){
        return vhsyudispunitsuu;
    }

    @Override
    public void setVhsyudispunitsuu(BizNumber pVhsyudispunitsuu){
        this.vhsyudispunitsuu = pVhsyudispunitsuu;
    }

    @Override
    public BizNumber getVhsyudispfundindex(){
        return vhsyudispfundindex;
    }

    @Override
    public void setVhsyudispfundindex(BizNumber pVhsyudispfundindex) {
        this.vhsyudispfundindex = pVhsyudispfundindex;
    }

    @Override
    public BizCurrency getVhsyudisptutakngk(){
        return vhsyudisptutakngk;
    }

    @Override
    public void setVhsyudisptutakngk(BizCurrency pVhsyudisptutakngk){
        this.vhsyudisptutakngk = pVhsyudisptutakngk;
    }

    @Override
    public BizNumber getVhsyudispwariai(){
        return vhsyudispwariai;
    }

    @Override
    public void setVhsyudispwariai(BizNumber pVhsyudispwariai){
        this.vhsyudispwariai = pVhsyudispwariai;
    }
}
