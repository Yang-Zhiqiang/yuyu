package yuyu.common.hozen.setuibean;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_UktKbn;

/**
 * 契約保全 UiBean設定 契約者代理人情報設定UiBean
 */
public class SetKyksyadairiExecUiBeanParamImpl implements SetKyksyadairiExecUiBeanParam{

    private String syono;

    private C_UktKbn vkykdrkykdrkbn;

    private String vkykdrkykdrnmkn;

    private String vkykdrkykdrnmkj;

    private C_KjkhukaKbn vkykdrkykdrnmkjkhukakbn;

    private BizDate vkykdrkykdrseiymd;

    private String vkykdrkykdryno;

    private String vkykdrkykdradr1kj;

    private String vkykdrkykdradr2kj;

    private String vkykdrkykdradr3kj;

    @Override
    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    public C_UktKbn getVkykdrkykdrkbn() {
        return vkykdrkykdrkbn;
    }

    @Override
    public void setVkykdrkykdrkbn(C_UktKbn pVkykdrkykdrkbn) {
        vkykdrkykdrkbn = pVkykdrkykdrkbn;
    }

    public String getVkykdrkykdrnmkn() {
        return vkykdrkykdrnmkn;
    }

    @Override
    public void setVkykdrkykdrnmkn(String pVkykdrkykdrnmkn) {
        vkykdrkykdrnmkn = pVkykdrkykdrnmkn;
    }

    public String getVkykdrkykdrnmkj() {
        return vkykdrkykdrnmkj;
    }

    @Override
    public void setVkykdrkykdrnmkj(String pVkykdrkykdrnmkj) {
        vkykdrkykdrnmkj = pVkykdrkykdrnmkj;
    }

    public C_KjkhukaKbn getVkykdrkykdrnmkjkhukakbn() {
        return vkykdrkykdrnmkjkhukakbn;
    }

    @Override
    public void setVkykdrkykdrnmkjkhukakbn(C_KjkhukaKbn pVkykdrkykdrnmkjkhukakbn) {
        vkykdrkykdrnmkjkhukakbn = pVkykdrkykdrnmkjkhukakbn;
    }

    public BizDate getVkykdrkykdrseiymd() {
        return vkykdrkykdrseiymd;
    }

    @Override
    public void setVkykdrkykdrseiymd(BizDate pVkykdrkykdrseiymd) {
        vkykdrkykdrseiymd = pVkykdrkykdrseiymd;
    }

    public String getVkykdrkykdryno() {
        return vkykdrkykdryno;
    }

    @Override
    public void setVkykdrkykdryno(String pVkykdrkykdryno) {
        vkykdrkykdryno = pVkykdrkykdryno;
    }

    public String getVkykdrkykdradr1kj() {
        return vkykdrkykdradr1kj;
    }

    @Override
    public void setVkykdrkykdradr1kj(String pVkykdrkykdradr1kj) {
        vkykdrkykdradr1kj = pVkykdrkykdradr1kj;
    }

    public String getVkykdrkykdradr2kj() {
        return vkykdrkykdradr2kj;
    }

    @Override
    public void setVkykdrkykdradr2kj(String pVkykdrkykdradr2kj) {
        vkykdrkykdradr2kj = pVkykdrkykdradr2kj;
    }

    public String getVkykdrkykdradr3kj() {
        return vkykdrkykdradr3kj;
    }

    @Override
    public void setVkykdrkykdradr3kj(String pVkykdrkykdradr3kj) {
        vkykdrkykdradr3kj = pVkykdrkykdradr3kj;
    }
}
