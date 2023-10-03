package yuyu.batch.suuri.srsuuritoukei.srdshrtoukeiloading;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBResults;

/**
 * 数理 数理統計 Ｄ支払統計ローディング情報作成のＤＢアクセスクラス
 */
public class SrDshrToukeiLoadingBatchDbAccess {

    @Inject
    private SrDshrToukeiLoadingDao srDshrToukeiLoadingDao;

    public ExDBResults<StDshrTukiTyukeiyouItzHznBean> getSrDshrToukeiLoadingInfo() {

        ExDBResults<StDshrTukiTyukeiyouItzHznBean> stDshrTukiTyukeiyouItzHznBeanList = srDshrToukeiLoadingDao
            .getSrDshrToukeiLoadingInfo();

        return stDshrTukiTyukeiyouItzHznBeanList;
    }
}
