package iwf.callback.arriveimage;

/**
 * 到着予定未存在時戻り値インタフェースです。<br/>
 */
public interface ToutyakuYoteiInfo {

    public String getToutyakuKey();

    public String getAppKey();

    public String getSyoruiCd();

    public String getFlowId();

    public String getSubSystemId();

}