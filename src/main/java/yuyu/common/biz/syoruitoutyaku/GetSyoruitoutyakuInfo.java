package yuyu.common.biz.syoruitoutyaku;

import iwf.callback.arriveimage.ToutyakuYoteiInfo;

/**
 * 業務共通 書類到着 書類到着時管理情報取得処理
 */
public abstract class GetSyoruitoutyakuInfo {

    public ToutyakuYoteiInfo exec(String pToutyakuKey) {
        return getToutyakuYoteiInfo(pToutyakuKey);
    }

    public abstract ToutyakuYoteiInfo getToutyakuYoteiInfo(String pToutyakuKey);

}