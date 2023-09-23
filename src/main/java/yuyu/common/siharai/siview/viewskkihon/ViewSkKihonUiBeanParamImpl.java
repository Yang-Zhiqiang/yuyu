package yuyu.common.siharai.siview.viewskkihon;

/**
 * 保険金給付金支払 支払画面部品 請求基本情報表示 <br />
 */
public class ViewSkKihonUiBeanParamImpl implements ViewSkKihonUiBeanParam {

    private String syono;

    private String syoukaibtn;

    private String skno;

    private String kouteikanriid;

    private boolean viewSkKihonSeigyo;

    private boolean viewSkKihonDispFlg;

    @Override
    public String getSyono() {
        return syono;
    }

    @Override
    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    @Override
    public String getSyoukaibtn() {
        return syoukaibtn;
    }

    @Override
    public void setSyoukaibtn(String pSyoukaibtn) {
        syoukaibtn = pSyoukaibtn;
    }

    @Override
    public String getSkno() {
        return skno;
    }

    @Override
    public void setSkno(String pSkno) {
        skno = pSkno;
    }

    @Override
    public String getKouteikanriid() {
        return kouteikanriid;
    }

    @Override
    public void setKouteikanriid(String pKouteikanriid) {
        kouteikanriid = pKouteikanriid;
    }

    @Override
    public boolean isViewSkKihonSeigyo() {
        return viewSkKihonSeigyo;
    }

    @Override
    public boolean isViewSkKihonDispFlg() {
        return viewSkKihonDispFlg;
    }
}
