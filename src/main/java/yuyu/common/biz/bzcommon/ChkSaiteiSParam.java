package yuyu.common.biz.bzcommon;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

/**
 *  新契約 申込内容チェック 最低Ｓパラメータ
 */
public interface ChkSaiteiSParam {

    public String getSyouhncd();

    public void setSyouhncd(String pSyouhncd);

    public Integer getSyusyouhnsdnofrom();

    public void setSyusyouhnsdnofrom(Integer pSyusyouhnsdnofrom);

    public Integer getSyusyouhnsdnoto();

    public void setSyusyouhnsdnoto(Integer pSyusyouhnsdnoto);

    public Integer getDntsdnumufrom();

    public void setDntsdnumufrom(Integer pDntsdnumufrom);

    public Integer getDntsdnumuto();

    public void setDntsdnumuto(Integer pDntsdnumuto);

    public Integer getHrkkknsmnkbnfrom();

    public void setHrkkknsmnkbnfrom(Integer pHrkkknsmnkbnfrom);

    public Integer getHrkkknsmnkbnto();

    public void setHrkkknsmnkbnto(Integer pHrkkknsmnkbnto);

    public BizNumber getHknkknfrom();

    public void setHknkknfrom(BizNumber pHknkknfrom);

    public BizNumber getHknkknto();

    public void setHknkknto(BizNumber pHknkknto);

    public Integer getSaiteisknwtkumufrom();

    public void setSaiteisknwtkumufrom(Integer pSaiteisknwtkumufrom);

    public Integer getSaiteisknwtkumuto();

    public void setSaiteisknwtkumuto(Integer pSaiteisknwtkumuto);

    public BizCurrency getSaiteis();

    public void setSaiteis(BizCurrency pSaiteis);

}
