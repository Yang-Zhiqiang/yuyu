package yuyu.common.siharai.sicommon;

import yuyu.common.siharai.siview.ViewSindansyoInfo2DataSourceBeanCommonParam;
import yuyu.def.classification.C_Delflag;
/**
 * 保険金給付金支払 保険金給付金支払共通 請求病名表示インタフェース実現クラス（テスト用）
 */
public class ViewSindansyoInfo2DataSourceBeanCommonParamImpl implements ViewSindansyoInfo2DataSourceBeanCommonParam {

    private String byoumeitourokuno;

    private String byoumeikn;

    private String byoumeikj;

    private C_Delflag sakujyoflg;

    @Override
    public String getByoumeitourokuno() {
        return byoumeitourokuno;
    }

    @Override
    public void setByoumeitourokuno(String pByoumeitourokuno) {
        byoumeitourokuno = pByoumeitourokuno;
    }

    @Override
    public String getByoumeikn() {
        return byoumeikn;
    }

    @Override
    public void setByoumeikn(String pByoumeikn) {
        byoumeikn = pByoumeikn;
    }

    @Override
    public String getByoumeikj() {
        return byoumeikj;
    }

    @Override
    public void setByoumeikj(String pByoumeikj) {
        byoumeikj = pByoumeikj;
    }

    @Override
    public C_Delflag getSakujyoflg() {
        return sakujyoflg;
    }

    @Override
    public void setSakujyoflg(C_Delflag pSakujyoflg) {
        sakujyoflg = pSakujyoflg;
    }
}
