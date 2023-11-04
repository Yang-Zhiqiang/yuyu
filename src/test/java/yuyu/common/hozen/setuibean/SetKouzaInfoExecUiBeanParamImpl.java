package yuyu.common.hozen.setuibean;

import yuyu.def.classification.C_Kzdou;

/**
 * 契約保全 UiBean設定 年金受取人情報設定UiBean
 */
public class SetKouzaInfoExecUiBeanParamImpl implements SetKouzaInfoExecUiBeanParam{

    private C_Kzdou kzdoukbn;

    @Override
    public C_Kzdou getKzdoukbn(){
        return kzdoukbn;
    }

    public void setKzdoukbn(C_Kzdou pKzdoukbn){
        this.kzdoukbn = pKzdoukbn;
    }

    private String kzmeiginmkn;

    @Override
    public void setKzmeiginmkn(String pKzmeiginmkn){
        this.kzmeiginmkn = pKzmeiginmkn;
    }

    public String getKzmeiginmkn(){
        return kzmeiginmkn;
    }

    private String vkykskyknmkn;

    public void setVkykskyknmkn(String pVkykskyknmkn){
        this.vkykskyknmkn = pVkykskyknmkn;
    }

    @Override
    public String getVkykskyknmkn(){
        return vkykskyknmkn;
    }
}
