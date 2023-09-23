package yuyu.common.siharai.siview.viewnenkininfo;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.def.classification.C_Bnshrkaisuu;
import yuyu.def.classification.C_Nstknsyu;
import yuyu.def.classification.C_SUketoriHouhouKbn;

/**
 * 保険金給付金支払 支払画面部品 年金情報 <br />
 */
public interface ViewNenkinInfoUiBeanParam extends CommonViewUiBeanParam {

    public BizDate getNkkknsetymd();

    public void setNkkknsetymd(BizDate pNkkknsetymd);

    public BizDate getNkshrstartymd();

    public void setNkshrstartymd(BizDate pNkshrstartymd);

    public C_Nstknsyu getDispnkshrtkyknksyukbn();

    public void setDispnkshrtkyknksyukbn(C_Nstknsyu pDispnkshrtkyknksyukbn);

    public Integer getDispnkshrtkyknksyukkn();

    public void setDispnkshrtkyknksyukkn(Integer pDispnkshrtkyknksyukkn);

    public BizCurrency getNkgns();

    public void setNkgns(BizCurrency pNkgns);

    public C_Bnshrkaisuu getDispbnshrkaisuu();

    public void setDispbnshrkaisuu(C_Bnshrkaisuu pDispbnshrkaisuu);

    public BizCurrency getTeihitukeihigaika();

    public void setTeihitukeihigaika(BizCurrency pTeihitukeihigaika);

    public BizCurrency getTeihitukeihiyen();

    public void setTeihitukeihiyen(BizCurrency pTeihitukeihiyen);

    public BizCurrency getNknengk();

    public void setNknengk(BizCurrency pNknengk);

    public BizCurrency getBnktnkgk();

    public void setBnktnkgk(BizCurrency pBnktnkgk);

    public C_SUketoriHouhouKbn getSuketorihouhoukbn();

    public boolean isViewNenkinInfoSeigyo();

    public boolean isViewNenkinInfoDispFlg();
}
