package yuyu.common.siharai.siview.viewskkihon;

import yuyu.common.biz.bzview.CommonViewUiBeanParam;

/**
 * 保険金給付金支払 支払画面部品 請求基本情報表示 <br />
 */
public interface ViewSkKihonUiBeanParam extends CommonViewUiBeanParam {

    public String getSyono();

    public void setSyono(String pSyono);

    public String getSyoukaibtn();

    public void setSyoukaibtn(String pSyoukaibtn);

    public String getSkno();

    public void setSkno(String pSkno);

    public String getKouteikanriid();

    public void setKouteikanriid(String pKouteikanriid);

    public boolean isViewSkKihonSeigyo();

    public boolean isViewSkKihonDispFlg();
}
