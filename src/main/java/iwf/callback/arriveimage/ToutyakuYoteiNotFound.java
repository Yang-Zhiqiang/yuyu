package iwf.callback.arriveimage;

/**
 * 到着予定未存在時コールバックです。
 */
public class ToutyakuYoteiNotFound {

    public ToutyakuYoteiInfo exec(String toutyakuKey) {
        throw new RuntimeException("Arrived unknown image.");
    }
}
