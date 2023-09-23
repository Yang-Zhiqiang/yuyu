package yuyu.common.siharai.siview;

import yuyu.def.classification.C_Delflag;

/**
 * 保険金給付金支払 保険金給付金支払共通 請求病名表示インタフェース
 */
public interface ViewSindansyoInfo2DataSourceBeanCommonParam {

    public String getByoumeitourokuno();

    public void setByoumeitourokuno(String pByoumeiTourokuNo);

    public String getByoumeikn();

    public void setByoumeikn(String pByoumeiKn);

    public String getByoumeikj();

    public void setByoumeikj(String pByoumeiKn);

    public C_Delflag getSakujyoflg();

    public void setSakujyoflg(C_Delflag pSakujyoflg);
}
