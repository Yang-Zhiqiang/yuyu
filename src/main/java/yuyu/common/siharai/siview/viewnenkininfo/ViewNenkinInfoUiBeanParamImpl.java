package yuyu.common.siharai.siview.viewnenkininfo;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_Bnshrkaisuu;
import yuyu.def.classification.C_Nstknsyu;
import yuyu.def.classification.C_SUketoriHouhouKbn;

/**
 * 保険金給付金支払 支払画面部品 年金情報クラス <br />
 */
public class ViewNenkinInfoUiBeanParamImpl implements ViewNenkinInfoUiBeanParam{

    private BizDate nkkknsetymd;

    private BizDate nkshrstartymd;

    private C_Nstknsyu dispnkshrtkyknksyukbn;

    private Integer dispnkshrtkyknksyukkn;

    private BizCurrency nkgns;

    private C_Bnshrkaisuu dispbnshrkaisuu;

    private BizCurrency teihitukeihigaika;

    private BizCurrency teihitukeihiyen;

    private BizCurrency nknengk;

    private BizCurrency bnktnkgk;

    private C_SUketoriHouhouKbn suketorihouhoukbn;

    private boolean viewNenkinInfoSeigyo;

    private boolean viewNenkinInfoDispFlg;

    @Override
    public BizDate getNkkknsetymd() {
        return nkkknsetymd;
    }

    @Override
    public void setNkkknsetymd(BizDate pNkkknsetymd) {
        nkkknsetymd = pNkkknsetymd;
    }

    @Override
    public BizDate getNkshrstartymd() {
        return nkshrstartymd;
    }

    @Override
    public void setNkshrstartymd(BizDate pNkshrstartymd) {
        nkshrstartymd = pNkshrstartymd;
    }

    @Override
    public C_Nstknsyu getDispnkshrtkyknksyukbn() {
        return dispnkshrtkyknksyukbn;
    }

    @Override
    public void setDispnkshrtkyknksyukbn(C_Nstknsyu pDispnkshrtkyknksyukbn) {
        dispnkshrtkyknksyukbn = pDispnkshrtkyknksyukbn;
    }

    @Override
    public Integer getDispnkshrtkyknksyukkn() {
        return dispnkshrtkyknksyukkn;
    }

    @Override
    public void setDispnkshrtkyknksyukkn(Integer pDispnkshrtkyknksyukkn) {
        dispnkshrtkyknksyukkn = pDispnkshrtkyknksyukkn;
    }

    @Override
    public BizCurrency getNkgns() {
        return nkgns;
    }

    @Override
    public void setNkgns(BizCurrency pNkgns) {
        nkgns = pNkgns;
    }

    @Override
    public C_Bnshrkaisuu getDispbnshrkaisuu() {
        return dispbnshrkaisuu;
    }

    @Override
    public void setDispbnshrkaisuu(C_Bnshrkaisuu pDispbnshrkaisuu) {
        dispbnshrkaisuu = pDispbnshrkaisuu;
    }

    @Override
    public BizCurrency getTeihitukeihigaika() {
        return teihitukeihigaika;
    }

    @Override
    public void setTeihitukeihigaika(BizCurrency pTeihitukeihigaika) {
        teihitukeihigaika = pTeihitukeihigaika;
    }

    @Override
    public BizCurrency getTeihitukeihiyen() {
        return teihitukeihiyen;
    }

    @Override
    public void setTeihitukeihiyen(BizCurrency pTeihitukeihiyen) {
        teihitukeihiyen = pTeihitukeihiyen;
    }

    @Override
    public BizCurrency getNknengk() {
        return nknengk;
    }

    @Override
    public void setNknengk(BizCurrency pNknengk) {
        nknengk = pNknengk;
    }

    @Override
    public BizCurrency getBnktnkgk() {
        return bnktnkgk;
    }

    @Override
    public void setBnktnkgk(BizCurrency pBnktnkgk) {
        bnktnkgk = pBnktnkgk;
    }

    @Override
    public C_SUketoriHouhouKbn getSuketorihouhoukbn() {
        return suketorihouhoukbn;
    }

    public void setSuketorihouhoukbn(C_SUketoriHouhouKbn pSuketorihouhoukbn) {
        suketorihouhoukbn = pSuketorihouhoukbn;
    }

    @Override
    public boolean isViewNenkinInfoSeigyo() {
        return viewNenkinInfoSeigyo;
    }

    public void setViewNenkinInfoSeigyo(boolean pViewNenkinInfoSeigyo) {
        viewNenkinInfoSeigyo = pViewNenkinInfoSeigyo;
    }

    @Override
    public boolean isViewNenkinInfoDispFlg() {
        return viewNenkinInfoDispFlg;
    }

    public void setViewNenkinInfoDispFlg(boolean pViewNenkinInfoDispFlg) {
        viewNenkinInfoDispFlg = pViewNenkinInfoDispFlg;
    }
}
