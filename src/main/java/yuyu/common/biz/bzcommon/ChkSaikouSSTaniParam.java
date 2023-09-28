package yuyu.common.biz.bzcommon;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

/**
 *  新契約 申込内容チェック 最高ＳＳ単位パラメータ
 */
public interface ChkSaikouSSTaniParam {

    public String getSyouhncd();

    public void setSyouhncd(String pSyouhncd);

    public Integer getSyusyouhnsdnofrom();

    public void setSyusyouhnsdnofrom(Integer pSyusyouhnsdnofrom);

    public Integer getSyusyouhnsdnoto();

    public void setSyusyouhnsdnoto(Integer pSyusyouhnsdnoto);

    public BizNumber getHhknfromnen();

    public void setHhknfromnen(BizNumber pHhknfromnen) ;

    public BizNumber getHhkntonen();

    public void setHhkntonen(BizNumber pHhkntonen);

    public Integer getMoskbnfrom();

    public void setMoskbnfrom(Integer pMoskbnfrom);

    public Integer getMoskbnto();

    public void setMoskbnto(Integer pMoskbnto);

    public BizCurrency getSaikous();

    public void setSaikous(BizCurrency pSaikous);

    public BizCurrency getStani();

    public void setStani(BizCurrency pStani);

    public BizNumber getBairitu();

    public void setBairitu(BizNumber pBairitu);

    public BizNumber getBairitu2();

    public void setBairitu2(BizNumber pBairitu2);
}
